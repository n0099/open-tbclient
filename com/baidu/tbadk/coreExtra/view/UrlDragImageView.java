package com.baidu.tbadk.coreExtra.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.base.f;
import com.baidu.adp.lib.e.d;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.util.g;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.File;
/* loaded from: classes.dex */
public class UrlDragImageView extends RelativeLayout {
    private ImageUrlData ftr;
    private b fum;
    private boolean fut;
    private boolean fuv;
    protected DragImageView fvP;
    protected TextView fvQ;
    protected SubsamplingScaleImageView fvR;
    private SubsamplingScaleImageView.OnImageEventListener fvS;
    private a fvT;
    private boolean fvU;
    private boolean fvV;
    private boolean fvW;
    private boolean fvX;
    private boolean fvY;
    private Bitmap fvZ;
    private RectF fwa;
    private Rect fwb;
    private Rect fwc;
    private Rect fwd;
    private DragImageView.d fwe;
    private String fwf;
    private float fwg;
    private float fwh;
    private float fwi;
    private float fwj;
    private float fwk;
    private boolean fwl;
    private boolean fwm;
    private boolean fwn;
    public boolean fwo;
    private com.baidu.tbadk.img.b fwp;
    private View.OnTouchListener fwq;
    private boolean fwr;
    private float fws;
    private String fwt;
    private CircleProgressView fwu;
    private boolean fwv;
    private boolean fww;
    private Runnable fwx;
    private Runnable fwy;
    private View.OnTouchListener fwz;
    private boolean isInDragScaleMode;
    protected Context mContext;
    private Rect mDisplayRect;
    private final Matrix mDragMatrix;
    private RectF mDstRect;
    private float mLastMotionX;
    private float mLastMotionY;
    private View.OnLongClickListener mLongClickListener;
    private int mMaxHeight;
    private int mMaxWidth;
    private float mMoveDistance;
    private View.OnClickListener mOnClickListener;
    protected ProgressBar mProgressBar;
    private float mRatio;
    private int mSkinType;
    private String mUserId;
    private static final String fvN = TbadkCoreApplication.getInst().getString(R.string.original_img_look);
    private static long fvO = Config.RAVEN_LOG_LIMIT;
    private static final int EXIT_DISTANCE = l.getEquipmentHeight(TbadkCoreApplication.getInst()) / 5;
    private static final String TAG = UrlDragImageView.class.getSimpleName();
    private static final int TOUCH_SLOP = ViewConfiguration.get(TbadkCoreApplication.getInst()).getScaledTouchSlop();

    /* loaded from: classes.dex */
    public interface a {
        void l(String str, byte[] bArr);
    }

    /* loaded from: classes.dex */
    public interface b {
        void bzC();
    }

    public void setUserId(String str) {
        this.mUserId = str;
    }

    public String getUserId() {
        return this.mUserId;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
        }
    }

    public void setHeadImage(boolean z) {
        if (this.fvP != null) {
            this.fvP.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.fvT = aVar;
    }

    public UrlDragImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.fvP = null;
        this.fvT = null;
        this.fut = false;
        this.fvW = false;
        this.isInDragScaleMode = false;
        this.mRatio = 1.0f;
        this.mMoveDistance = 0.0f;
        this.mDragMatrix = new Matrix();
        this.mDstRect = new RectF();
        this.fwg = 0.0f;
        this.fwh = 0.0f;
        this.fwi = 1.0f;
        this.fwj = 1.0f;
        this.fwk = 0.0f;
        this.fwl = false;
        this.fwm = false;
        this.fwn = false;
        this.fwo = false;
        this.fwr = true;
        this.fws = 0.0f;
        this.mOnClickListener = null;
        this.mLongClickListener = null;
        this.fwt = null;
        this.fwx = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.fwr = true;
            }
        };
        this.fwy = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
            @Override // java.lang.Runnable
            public void run() {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(200L);
                alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        UrlDragImageView.this.fwu.setVisibility(8);
                        UrlDragImageView.this.fwt = null;
                        UrlDragImageView.this.fwo = false;
                    }
                });
            }
        };
        this.fwz = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.fwq != null) {
                    UrlDragImageView.this.fwq.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.fwp = new com.baidu.tbadk.img.b();
        init();
    }

    public UrlDragImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.fvP = null;
        this.fvT = null;
        this.fut = false;
        this.fvW = false;
        this.isInDragScaleMode = false;
        this.mRatio = 1.0f;
        this.mMoveDistance = 0.0f;
        this.mDragMatrix = new Matrix();
        this.mDstRect = new RectF();
        this.fwg = 0.0f;
        this.fwh = 0.0f;
        this.fwi = 1.0f;
        this.fwj = 1.0f;
        this.fwk = 0.0f;
        this.fwl = false;
        this.fwm = false;
        this.fwn = false;
        this.fwo = false;
        this.fwr = true;
        this.fws = 0.0f;
        this.mOnClickListener = null;
        this.mLongClickListener = null;
        this.fwt = null;
        this.fwx = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.fwr = true;
            }
        };
        this.fwy = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
            @Override // java.lang.Runnable
            public void run() {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(200L);
                alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        UrlDragImageView.this.fwu.setVisibility(8);
                        UrlDragImageView.this.fwt = null;
                        UrlDragImageView.this.fwo = false;
                    }
                });
            }
        };
        this.fwz = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.fwq != null) {
                    UrlDragImageView.this.fwq.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.fwp = new com.baidu.tbadk.img.b();
        init();
    }

    public DragImageView getImageView() {
        return this.fvP;
    }

    public void setGifSetListener(DragImageView.e eVar) {
        this.fvP.setGifSetListener(eVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.fvP.setImageOnClickListener(onClickListener);
        this.fvR.setOnClickListener(onClickListener);
        this.mOnClickListener = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mLongClickListener = onLongClickListener;
        if (!this.fuv) {
            this.fvP.setImageOnLongClickListener(this.mLongClickListener);
            this.fvR.setOnLongClickListener(this.mLongClickListener);
        }
    }

    public void setOnSizeChangedListener(final DragImageView.g gVar) {
        this.fvP.setOnSizeChangedListener(new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.8
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (gVar != null) {
                    gVar.a(dragImageView, z, z2);
                }
                UrlDragImageView.this.bzq();
            }
        });
    }

    protected void init() {
        this.fwf = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        this.mMaxWidth = l.getEquipmentWidth(this.mContext);
        this.mMaxHeight = l.getEquipmentHeight(this.mContext) - ((int) this.mContext.getResources().getDimension(R.dimen.ds166));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.fvP = new DragImageView(this.mContext);
        this.fvP.setLayoutParams(layoutParams);
        this.fvP.setOnTouchListener(this.fwz);
        addView(this.fvP);
        this.fvR = new SubsamplingScaleImageView(this.mContext);
        this.fvR.setMaxScale(50.0f);
        this.fvR.setOnTouchListener(this.fwz);
        this.fvR.setVisibility(4);
        addView(this.fvR, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(getResources().getDrawable(R.drawable.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        bzp();
        this.fww = TbSingleton.getInstance().isCutoutScreen(TbadkApplication.getInst().getCurrentActivity());
    }

    private void bzp() {
        this.fwu = new CircleProgressView(this.mContext);
        this.fwu.setCircleBackgroundColor(ao.getColor(R.color.CAM_X0109));
        this.fwu.setCircleForegroundColor(ao.getColor(R.color.CAM_X0302));
        this.fwu.setProgress(0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds80), l.getDimens(getContext(), R.dimen.tbds80));
        layoutParams.addRule(13);
        this.fwu.setVisibility(8);
        addView(this.fwu, layoutParams);
    }

    public void setIsCanDrag(boolean z) {
        this.fuv = z;
    }

    public String getmCheckOriginPicText() {
        return this.fwt;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        Bitmap imageBitmap;
        int height;
        int width;
        if (this.fwl && !this.fwv && this.fvR.getVisibility() == 0 && !this.fvR.isImageLoaded()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.fuv || !this.fvV) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.fvX && motionEvent.getPointerCount() >= 2) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.fvX || this.fvY) {
            requestDisallowInterceptTouchEvent(true);
        }
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        float x = motionEvent.getX();
        int i = action & 255;
        if (i == 0) {
            if (this.fvZ == null) {
                if (this.fvR.getVisibility() == 0) {
                    this.fvZ = g.bZ(this.fvR);
                } else {
                    this.fvZ = g.bZ(this.fvP);
                }
            }
            if (this.mDisplayRect == null && this.fvZ != null) {
                int measuredWidth = getMeasuredWidth();
                float measuredWidth2 = ((getMeasuredWidth() * 1.0f) / this.fvZ.getWidth()) * this.fvZ.getHeight();
                if (measuredWidth2 > getMeasuredHeight()) {
                    measuredWidth2 = getMeasuredHeight();
                }
                RectF rectInScreenFromPosition = getRectInScreenFromPosition(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
                this.mDisplayRect = new Rect((int) rectInScreenFromPosition.left, (int) rectInScreenFromPosition.top, (int) rectInScreenFromPosition.right, (int) rectInScreenFromPosition.bottom);
            }
            if (this.fwc == null && this.fvZ != null) {
                if (this.fvR.getVisibility() == 0) {
                    height = this.fvR.getSHeight();
                    width = this.fvR.getSWidth();
                } else {
                    if (this.fvP.getImageType() == 1) {
                        imageBitmap = (this.fvP.getCurrentFrame() == null || this.fvP.getCurrentFrame().bm == null) ? this.fvZ : this.fvP.getCurrentFrame().bm;
                    } else {
                        imageBitmap = this.fvP.getImageBitmap() == null ? this.fvZ : this.fvP.getImageBitmap();
                    }
                    height = imageBitmap.getHeight();
                    width = imageBitmap.getWidth();
                }
                float equipmentDensity = l.getEquipmentDensity(getContext());
                int i2 = (int) (height * equipmentDensity);
                int i3 = (int) (width * equipmentDensity);
                if (i3 > this.fvZ.getWidth() && this.fvZ.getWidth() != 0) {
                    float width2 = (i3 * 1.0f) / this.fvZ.getWidth();
                    i3 = this.fvZ.getWidth();
                    i2 = (int) (i2 / width2);
                }
                if (i2 > this.fvZ.getHeight() && this.fvZ.getHeight() != 0) {
                    i3 = (int) (i3 / ((i2 * 1.0f) / this.fvZ.getHeight()));
                    i2 = this.fvZ.getHeight();
                }
                int equipmentHeight = (l.getEquipmentHeight(getContext()) - i2) / 2;
                int equipmentWidth = (l.getEquipmentWidth(getContext()) - i3) / 2;
                this.fwc = new Rect(equipmentWidth, equipmentHeight, i3 + equipmentWidth, i2 + equipmentHeight);
                this.fwd = new Rect(this.fwc);
                this.fwk = equipmentHeight / l.getEquipmentHeight(getContext());
                this.fwb = new Rect(0, 0, this.fvZ.getWidth(), this.fvZ.getHeight());
            }
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (i == 2) {
            this.fvX = x(this.mLastMotionX - x, this.mLastMotionY - y);
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (this.fvX || this.fvY) {
            this.fvP.setImageOnLongClickListener(null);
            this.fvR.setOnLongClickListener(null);
            z = true;
        } else {
            this.fvP.setImageOnLongClickListener(this.mLongClickListener);
            this.fvR.setOnLongClickListener(this.mLongClickListener);
            z = super.dispatchTouchEvent(motionEvent);
        }
        if (i == 1 || i == 3) {
            this.mLastMotionX = 0.0f;
            this.mLastMotionY = 0.0f;
            boolean z2 = (-this.mMoveDistance) > ((float) (EXIT_DISTANCE * 2));
            boolean z3 = this.mMoveDistance > ((float) EXIT_DISTANCE);
            if (z2 || z3) {
                this.fvY = true;
                startExitAnimation();
                if (z2) {
                    TiebaStatic.log(new aq("c13377").dW("obj_type", "3"));
                } else if (z3) {
                    TiebaStatic.log(new aq("c13377").dW("obj_type", "2"));
                }
            } else {
                if (this.fvX && this.fwe != null) {
                    this.fwe.bFG();
                }
                this.mRatio = 1.0f;
                invalidate();
            }
            this.isInDragScaleMode = false;
            this.mDragMatrix.reset();
            this.fvX = false;
        }
        return z;
    }

    private boolean x(float f, float f2) {
        if (this.fvR.getVisibility() != 0 || this.fvR.isCanDrag()) {
            if (this.ftr == null || !this.ftr.isLongPic || this.fvR.getVisibility() != 0 || this.fvR.isViewTop()) {
                if (this.ftr == null || !this.ftr.isLongPic || this.fvR.getVisibility() == 0 || this.fvP.isAtViewTop() || this.fvP.bFE()) {
                    if (this.fvR.getVisibility() == 0 || this.fvP.pagerCantScroll()) {
                        if (this.fvZ != null && getScrollY() == 0) {
                            boolean z = (this.ftr == null || !this.ftr.isLongPic) && ((f2 < -15.0f && !this.isInDragScaleMode) || (f2 > 15.0f && !this.isInDragScaleMode));
                            boolean z2 = this.ftr != null && this.ftr.isLongPic && f2 < 0.0f && !this.isInDragScaleMode;
                            if (z || (z2 && this.fvP.isViewTop())) {
                                this.fvP.setImageOnLongClickListener(null);
                                this.fvR.setOnLongClickListener(null);
                                this.isInDragScaleMode = true;
                                this.mMoveDistance = 0.0f;
                                this.mRatio = 1.0f;
                                if (this.fwe != null) {
                                    this.fwe.onDragStart();
                                }
                            }
                        }
                        if (!this.isInDragScaleMode || this.fvZ == null) {
                            return false;
                        }
                        this.mMoveDistance -= f2;
                        int measuredHeight = getMeasuredHeight();
                        if (this.mMoveDistance > measuredHeight) {
                            this.mMoveDistance = measuredHeight;
                        }
                        float f3 = f2 / measuredHeight;
                        this.mDragMatrix.postTranslate((-f) * 1.5f * this.mRatio, (-1.5f) * f2 * this.mRatio);
                        if (this.mRatio * (1.0f + f3) > 1.0f || this.mMoveDistance < 0.0f) {
                            f3 = -f3;
                        }
                        this.mDragMatrix.preScale(1.0f + f3, 1.0f + f3, (this.mRatio * this.fvZ.getWidth()) / 2.0f, this.mRatio * (this.fvZ.getHeight() / 2));
                        this.mRatio = (f3 + 1.0f) * this.mRatio;
                        invalidate();
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.fvX && this.fvZ != null && !this.fvZ.isRecycled() && this.isInDragScaleMode) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.mDstRect == null) {
                this.mDstRect = new RectF();
            }
            this.mDragMatrix.mapRect(this.mDstRect, new RectF(this.mDisplayRect));
            canvas.drawBitmap(this.fvZ, this.fwb, this.mDstRect, (Paint) null);
        } else if (this.fvY && this.fvZ != null && !this.fvZ.isRecycled()) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.ftr == null || this.ftr.getSourceImageRectInScreen() == null) {
                canvas.drawBitmap(this.fvZ, this.fwb, this.mDstRect, (Paint) null);
            } else {
                canvas.drawBitmap(this.fvZ, this.fwc, this.mDstRect, (Paint) null);
            }
        } else {
            super.dispatchDraw(canvas);
        }
    }

    private void startExitAnimation() {
        if (this.ftr == null) {
            if (this.fwe != null) {
                this.fwe.onDragEnd();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.ftr.getSourceImageRectInScreen();
        final Rect dstRectInScreen = this.ftr.getDstRectInScreen();
        if (sourceImageRectInScreen == null || dstRectInScreen == null) {
            if (this.fwe != null) {
                this.fwe.onDragEnd();
                return;
            }
            return;
        }
        a(sourceImageRectInScreen, dstRectInScreen);
        a(sourceImageRectInScreen);
        this.fwa = new RectF(this.mDstRect);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(150L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && sourceImageRectInScreen != null && dstRectInScreen != null) {
                    UrlDragImageView.this.ao(valueAnimator.getAnimatedFraction());
                    UrlDragImageView.this.a(dstRectInScreen, valueAnimator.getAnimatedFraction(), UrlDragImageView.this.fww);
                    UrlDragImageView.this.invalidate();
                }
            }
        });
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                UrlDragImageView.this.isInDragScaleMode = false;
                UrlDragImageView.this.invalidate();
                if (UrlDragImageView.this.fwe != null) {
                    UrlDragImageView.this.fwe.onDragEnd();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        ofFloat.start();
    }

    private void a(Rect rect) {
        if (rect != null) {
            float f = ((rect.bottom - rect.top) / (rect.right - rect.left)) * (this.mDstRect.right - this.mDstRect.left);
            this.mDstRect.top += this.mDstRect.height() * this.fwk;
            this.mDstRect.bottom = f + this.mDstRect.top;
        }
    }

    public void setCanScale(boolean z) {
        if (this.fvP != null) {
            this.fvP.setCanScale(z);
        }
    }

    private void a(Rect rect, Rect rect2) {
        this.fwg = 0.0f;
        this.fwh = 0.0f;
        this.fwi = 1.0f;
        this.fwj = 1.0f;
        if (rect != null && rect2 != null && rect.contains(rect2)) {
            this.fwg = (rect2.left - rect.left) / rect.width();
            this.fwh = (rect2.top - rect.top) / rect.height();
            this.fwi = (rect2.right - rect.left) / rect.width();
            this.fwj = (rect2.bottom - rect.top) / rect.height();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ao(float f) {
        if (this.fwc != null) {
            this.fwc.left = (int) (this.fwd.left + (this.fwd.width() * this.fwg * f));
            this.fwc.top = (int) (this.fwd.top + (this.fwd.height() * this.fwh * f));
            this.fwc.right = (int) (this.fwd.left + (this.fwd.width() * (((1.0f - this.fwi) * (1.0f - f)) + this.fwi)));
            this.fwc.bottom = (int) (this.fwd.top + (this.fwd.height() * (((1.0f - this.fwj) * (1.0f - f)) + this.fwj)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Rect rect, float f, boolean z) {
        int i = 0;
        if (z) {
            i = l.getDimens(getContext(), R.dimen.tbds80);
        }
        if (this.mDstRect != null && rect != null) {
            this.mDstRect.left = this.fwa.left + ((rect.left - this.fwa.left) * f);
            this.mDstRect.top = (this.fwa.top + ((rect.top - this.fwa.top) * f)) - i;
            this.mDstRect.right = this.fwa.right + ((rect.right - this.fwa.right) * f);
            this.mDstRect.bottom = this.fwa.bottom + ((rect.bottom - this.fwa.bottom) * f);
        }
    }

    private RectF getRectInScreenFromPosition(float f, float f2, float f3, float f4) {
        return new RectF(f - (f3 / 2.0f), f2 - (f4 / 2.0f), (f3 / 2.0f) + f, (f4 / 2.0f) + f2);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.fwq = onTouchListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzq() {
        if ((this.fvU || this.fvV) && this.ftr != null && this.ftr.mPicType == 1 && !TextUtils.isEmpty(this.ftr.mTagName)) {
            if (this.fvQ != null) {
                this.fvQ.setVisibility(8);
                this.fvQ = null;
            }
            this.fvQ = new TextView(this.mContext);
            this.fvQ.setText(this.ftr.mTagName);
            this.fvQ.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize26));
            ao.setViewTextColor(this.fvQ, R.color.common_color_10013, 1, 0);
            ao.setBackgroundColor(this.fvQ, R.color.common_color_10215);
            this.fvQ.setAlpha(0.75f);
            this.fvQ.setIncludeFontPadding(false);
            this.fvQ.setGravity(17);
            int dimens = l.getDimens(this.mContext, R.dimen.ds2);
            this.fvQ.setPadding(dimens, dimens, dimens, dimens);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.fvP.getBottomOffset();
            layoutParams.leftMargin = this.fvP.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.fvQ, layoutParams);
            this.fvQ.setVisibility(0);
        }
    }

    public void setUrl(String str, boolean z) {
        if (str.contains("*")) {
            str = str.split("[*]")[0];
        }
        this.fvP.setTag(str);
        this.fvP.setLoadBigImage(false);
        this.fvP.setImageDrawable(null);
        this.fvU = false;
        this.fvV = false;
        this.fwl = bzy();
        this.fwt = null;
        if (Cb(str)) {
            e(str, z, false);
        }
    }

    private boolean bzr() {
        return this.fvP != null && this.fvP.isLoadBigImage();
    }

    public void bzs() {
        if (this.ftr != null && !bzr()) {
            String str = this.ftr.imageUrl;
            int i = this.ftr.urlType;
            com.baidu.adp.widget.ImageView.a aVar = null;
            if (com.baidu.tbadk.core.util.d.a.ap(str, i)) {
                aVar = com.baidu.tbadk.core.util.d.a.aq(str, i);
            }
            if (aVar != null) {
                setThumbBitmapToView(aVar);
            }
        }
    }

    private boolean kz(boolean z) {
        String nameMd5FromUrl;
        if (!this.fwm || z) {
            this.fwm = true;
            if (!this.fwl || this.ftr == null || StringUtils.isNull(this.ftr.originalUrl, true) || this.ftr.originalSize < 0 || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String str = this.fwf + as.bsv().AN(nameMd5FromUrl) + "/" + av.getNameMd5FromUrl(this.ftr.originalUrl);
            final int[] imageFileWH = n.getImageFileWH(str);
            this.fvR.setVisibility(0);
            if (this.fvS == null) {
                this.fvS = new SubsamplingScaleImageView.OnImageEventListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12
                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onReady() {
                        UrlDragImageView.this.fwt = null;
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.fvP.restoreSize();
                        UrlDragImageView.this.fvP.setVisibility(4);
                    }

                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onImageLoaded() {
                        if (UrlDragImageView.this.ftr.isLongPic && imageFileWH[0] > 0) {
                            UrlDragImageView.this.fvP.onDestroy();
                            final float measuredWidth = (UrlDragImageView.this.getMeasuredWidth() * 1.0f) / imageFileWH[0];
                            final PointF pointF = new PointF((imageFileWH[0] * 1.0f) / 2.0f, 0.0f);
                            UrlDragImageView.this.fvR.setScaleAndCenter(measuredWidth, pointF);
                            UrlDragImageView.this.fvR.setMaxScale(2.0f * measuredWidth);
                            UrlDragImageView.this.fvR.setDoubleTapZoomScale(2.0f * measuredWidth);
                            UrlDragImageView.this.fvR.setInitScale(measuredWidth);
                            UrlDragImageView.this.fvR.setDoubleTapZoomStyle(4);
                            UrlDragImageView.this.fvR.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12.1
                                @Override // android.view.View.OnTouchListener
                                public boolean onTouch(View view, MotionEvent motionEvent) {
                                    if (UrlDragImageView.this.fwq != null) {
                                        UrlDragImageView.this.fwq.onTouch(view, motionEvent);
                                    }
                                    switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                                        case 0:
                                            UrlDragImageView.this.fws = motionEvent.getY();
                                            UrlDragImageView.this.fvR.setOnClickListener(UrlDragImageView.this.fwr ? UrlDragImageView.this.mOnClickListener : null);
                                            UrlDragImageView.this.fvR.setOnLongClickListener(UrlDragImageView.this.fwr ? UrlDragImageView.this.mLongClickListener : null);
                                            break;
                                        case 1:
                                        case 3:
                                            if (UrlDragImageView.this.fvR.getScale() < measuredWidth) {
                                                UrlDragImageView.this.fvR.setScaleAndCenter(measuredWidth, pointF);
                                            }
                                            e.mB().removeCallbacks(UrlDragImageView.this.fwx);
                                            e.mB().postDelayed(UrlDragImageView.this.fwx, 1000L);
                                            break;
                                        case 2:
                                            if (Math.abs(motionEvent.getY() - UrlDragImageView.this.fws) > UrlDragImageView.TOUCH_SLOP) {
                                                UrlDragImageView.this.fwr = false;
                                                UrlDragImageView.this.fvR.setOnClickListener(null);
                                                UrlDragImageView.this.fvR.setOnLongClickListener(null);
                                            }
                                            UrlDragImageView.this.fws = motionEvent.getY();
                                            break;
                                    }
                                    return false;
                                }
                            });
                            UrlDragImageView.this.fvP.setVisibility(4);
                        }
                    }

                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onPreviewLoadError(Exception exc) {
                    }

                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onImageLoadError(Exception exc) {
                    }

                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onTileLoadError(Exception exc) {
                    }
                };
            }
            this.fvR.setOnImageEventListener(this.fvS);
            if (this.fvR.isImageLoaded() && this.ftr.isLongPic) {
                this.fvS.onImageLoaded();
            } else {
                this.fvR.setImage(ImageSource.uri(str));
            }
            return true;
        }
        return false;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.fwe = dVar;
        if (this.fvP != null) {
            this.fvP.setDragToExitListener(dVar);
        }
    }

    public void bzt() {
        kz(false);
    }

    private boolean Cb(String str) {
        return j.isNetWorkAvailable() || com.baidu.tbadk.core.util.d.b.Ba(str);
    }

    private void setThumbBitmapToView(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap rawBitmap;
        if (!this.fvV && aVar != null && (rawBitmap = aVar.getRawBitmap()) != null) {
            this.fvU = true;
            if (aVar.isGif()) {
                this.fvP.setImageUrlData(this.ftr);
                this.fvP.setImageBitmap(rawBitmap);
                this.fwt = null;
                this.fwo = false;
            } else {
                if (this.ftr != null && this.ftr.isLongPic) {
                    this.fvP.createLargeImageDelegate();
                    this.fvP.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.13
                        @Override // com.baidu.tbadk.widget.largeImage.logic.a
                        public void onLoadFinished() {
                        }
                    });
                }
                this.fvP.setImageUrlData(this.ftr);
                this.fvP.setImageData(rawBitmap, aVar.getByteData());
            }
            bzq();
        }
    }

    private void e(String str, boolean z, boolean z2) {
        if (Cc(str)) {
            if (z2 || (!this.fvW && !this.fvV)) {
                if (!z2 || !kz(true)) {
                    this.fvW = true;
                    d.mx().a(str, 27, new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.14
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.c
                        public void onCancelled(String str2) {
                            UrlDragImageView.this.fvW = false;
                            UrlDragImageView.this.fvP.setVisibility(0);
                            UrlDragImageView.this.mProgressBar.setVisibility(8);
                            UrlDragImageView.this.fwt = null;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.c
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            UrlDragImageView.this.fvW = false;
                            UrlDragImageView.this.fvV = true;
                            UrlDragImageView.this.b(aVar);
                        }
                    }, 0, 0, false, null, Boolean.valueOf(z), this.fvP.getImageData(), Boolean.valueOf(this.fut));
                    return;
                }
                return;
            }
            return;
        }
        this.mProgressBar.setVisibility(0);
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(str);
        imageFileInfo.setTempFile(true);
        imageFileInfo.clearPageActions();
        imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.bg(this.mMaxWidth, this.mMaxHeight));
        com.baidu.adp.widget.ImageView.a a2 = this.fwp.a(imageFileInfo, false);
        if (a2 != null) {
            this.fvV = true;
            this.mProgressBar.setVisibility(8);
            this.fwt = null;
            b(a2);
            return;
        }
        this.fwp.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.2
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.ImageView.a aVar, String str2, boolean z3) {
                UrlDragImageView.this.fvV = true;
                UrlDragImageView.this.mProgressBar.setVisibility(8);
                UrlDragImageView.this.fwt = null;
                UrlDragImageView.this.b(aVar);
            }
        }, false);
    }

    private boolean Cc(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null && this.fvT != null) {
            this.fvT.l(aVar.getUrl(), aVar.getByteData());
        }
        if (aVar == null || aVar.getRawBitmap() == null) {
            bzu();
            return;
        }
        Bitmap rawBitmap = aVar.getRawBitmap();
        this.fvP.setLoadBigImage(true);
        if (aVar.isGif()) {
            this.fvP.setGifData(aVar.getByteData(), rawBitmap);
            this.fvP.invalidate();
            this.fvP.play();
            this.fwo = false;
            this.fwt = null;
            this.mProgressBar.setVisibility(8);
        } else {
            if (this.ftr != null && this.ftr.isLongPic) {
                this.fvP.createLargeImageDelegate();
                this.fvP.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.3
                    @Override // com.baidu.tbadk.widget.largeImage.logic.a
                    public void onLoadFinished() {
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.fwt = null;
                    }
                });
            } else {
                this.mProgressBar.setVisibility(8);
                this.fwt = null;
            }
            this.fvP.setImageUrlData(this.ftr);
            this.fvP.setImageData(rawBitmap, aVar.getByteData());
            bzz();
        }
        bzq();
    }

    private void bzu() {
        if (!this.fvU) {
            this.fvP.setDefaultBitmap();
        } else {
            this.fvV = false;
        }
        this.fwt = null;
        this.mProgressBar.setVisibility(8);
    }

    public void setGifMaxUseableMem(int i) {
        this.fvP.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.fvP != null) {
            this.fvP.onDestroy();
        }
        if (this.fvR != null) {
            this.fvR.recycle();
        }
        if (this.fvZ != null) {
            this.fvZ.recycle();
            this.fvZ = null;
        }
        if (this.mProgressBar != null) {
            this.fwt = null;
            this.mProgressBar.setVisibility(8);
        }
        e.mB().removeCallbacks(this.fwx);
        com.baidu.tieba.view.c.dTE().setColor(-1);
    }

    public void release() {
        if (this.fvP != null) {
            this.fvP.release();
        }
        if (this.mProgressBar != null) {
            this.fwt = null;
            this.mProgressBar.setVisibility(8);
        }
        this.fwt = null;
    }

    public void bzv() {
        if (this.fvP != null && this.fvP.getImageType() == 1) {
            this.fvP.stop();
        }
    }

    public void E(boolean z, boolean z2) {
        String str;
        if (this.fvP != null && (str = (String) this.fvP.getTag()) != null) {
            if (this.fvP.getImageType() == 1) {
                if (this.fvP.getGifCache() == null || !this.fvP.isLoadBigImage()) {
                    e(str, z, z2);
                }
            } else if (this.fvP.getImageType() == 2) {
                e(str, z, z2);
            } else if (bzw()) {
                e(str, z, z2);
            }
        }
    }

    private boolean bzw() {
        if (this.fvP.getImageBitmap() != null && this.fvP.isLoadBigImage()) {
            if (this.ftr == null || !this.ftr.isLongPic || this.fvP.hasLoadLongImage()) {
                return false;
            }
            this.fvV = false;
            this.fwm = false;
            return true;
        }
        return true;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.ftr = imageUrlData;
    }

    public ImageUrlData getmAssistUrlData() {
        return this.ftr;
    }

    public void setIsCdn(boolean z) {
        this.fut = z;
    }

    public void bzx() {
        final String nameMd5FromUrl = av.getNameMd5FromUrl(this.ftr.originalUrl);
        if (this.ftr.originalProcess >= 0) {
            com.baidu.tbadk.download.d.bAL().cancelDownLoadById(nameMd5FromUrl, 13);
            this.ftr.originalProcess = -1;
            bzz();
            return;
        }
        if (this.fum != null) {
            this.fum.bzC();
        }
        f<?> K = com.baidu.adp.base.j.K(this.mContext);
        if (K == null) {
            Cd(nameMd5FromUrl);
        } else if (!j.isNetWorkAvailable() || j.isWifiNet() || com.baidu.tbadk.core.sharedPref.b.brx().getBoolean(SharedPrefConfig.ORIGINAL_IMG_DOWN_TIP, false)) {
            Cd(nameMd5FromUrl);
        } else {
            com.baidu.tbadk.core.sharedPref.b.brx().putBoolean(SharedPrefConfig.ORIGINAL_IMG_DOWN_TIP, true);
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(K.getPageActivity());
            aVar.nu(R.string.original_img_down_no_wifi_tip);
            aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    UrlDragImageView.this.Cd(nameMd5FromUrl);
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                }
            });
            aVar.b(K);
            aVar.bqe();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cd(String str) {
        if (this.ftr != null) {
            this.ftr.originalProcess = 0;
            this.fwu.setProgress(0);
            this.fwu.setVisibility(0);
            DownloadData downloadData = new DownloadData(str);
            downloadData.setStatus(1);
            downloadData.setUrl(this.ftr.originalUrl);
            downloadData.setType(13);
            downloadData.setPath(this.fwf + as.bsv().AN(str) + "/" + str);
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.6
                @Override // com.baidu.tbadk.download.c
                public boolean onPreDownload(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2 != null) {
                        if (UrlDragImageView.this.ftr != null && UrlDragImageView.this.ftr.originalProcess != -1) {
                            UrlDragImageView.this.ftr.originalProcess = downloadData2.getProcess();
                        }
                        if (UrlDragImageView.this.ftr == null || UrlDragImageView.this.ftr.originalProcess != -1) {
                            UrlDragImageView.this.fwu.setProgress(downloadData2.getProcess());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public boolean onFileDownloaded(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadSucceed(DownloadData downloadData2) {
                    UrlDragImageView.this.fwu.setVisibility(8);
                    e.mB().postDelayed(UrlDragImageView.this.fwy, 1500L);
                    UrlDragImageView.this.fwm = false;
                    UrlDragImageView.this.fwl = UrlDragImageView.this.bzy();
                    UrlDragImageView.this.bzt();
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str2) {
                    UrlDragImageView.this.fwu.setVisibility(8);
                    UrlDragImageView.this.fwm = false;
                    BdToast.b(UrlDragImageView.this.mContext, str2).bqj().bqk();
                    UrlDragImageView.this.ftr.originalProcess = -1;
                    UrlDragImageView.this.bzz();
                }
            });
            com.baidu.tbadk.download.d.bAL().a(downloadData, 100);
            this.fwv = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bzy() {
        if (this.ftr != null && !StringUtils.isNull(this.ftr.originalUrl, true) && this.ftr.originalSize >= 0 && !this.ftr.isBlockedPic) {
            String nameMd5FromUrl = av.getNameMd5FromUrl(this.ftr.originalUrl);
            File file = new File(this.fwf + as.bsv().AN(nameMd5FromUrl) + "/" + nameMd5FromUrl);
            if (file != null && file.exists()) {
                this.ftr.originalProcess = 100;
                return true;
            }
            if (this.ftr.originalProcess < 0) {
                bzz();
            } else {
                this.fwu.setProgress(this.ftr.originalProcess);
            }
            this.fwo = true;
        } else {
            this.fwt = null;
        }
        return false;
    }

    public void bzz() {
        if (this.ftr != null) {
            if (!bzA() || !this.fwo) {
                this.fwt = null;
            } else if (this.ftr.originalSize > 0 && !ed(this.ftr.originalSize)) {
                this.fwt = fvN + "(" + at.getFormatSize(this.ftr.originalSize) + ")";
            } else {
                this.fwt = fvN;
            }
        }
    }

    private boolean bzA() {
        return (this.ftr == null || !this.ftr.mIsShowOrigonButton || this.ftr.isBlockedPic || StringUtils.isNull(this.ftr.originalUrl)) ? false : true;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.fum = bVar;
    }

    private boolean ed(long j) {
        return j > fvO;
    }
}
