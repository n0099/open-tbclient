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
    private SubsamplingScaleImageView.OnImageEventListener fAA;
    private a fAB;
    private boolean fAC;
    private boolean fAD;
    private boolean fAE;
    private boolean fAF;
    private boolean fAG;
    private Bitmap fAH;
    private RectF fAI;
    private Rect fAJ;
    private Rect fAK;
    private Rect fAL;
    private DragImageView.d fAM;
    private String fAN;
    private float fAO;
    private float fAP;
    private float fAQ;
    private float fAR;
    private float fAS;
    private boolean fAT;
    private boolean fAU;
    private boolean fAV;
    public boolean fAW;
    private com.baidu.tbadk.img.b fAX;
    private View.OnTouchListener fAY;
    private boolean fAZ;
    protected DragImageView fAx;
    protected TextView fAy;
    protected SubsamplingScaleImageView fAz;
    private float fBa;
    private String fBb;
    private CircleProgressView fBc;
    private boolean fBd;
    private boolean fBe;
    private Runnable fBf;
    private Runnable fBg;
    private View.OnTouchListener fBh;
    private ImageUrlData fxZ;
    private b fyU;
    private boolean fzb;
    private boolean fzd;
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
    private static final String fAv = TbadkCoreApplication.getInst().getString(R.string.original_img_look);
    private static long fAw = Config.RAVEN_LOG_LIMIT;
    private static final int EXIT_DISTANCE = l.getEquipmentHeight(TbadkCoreApplication.getInst()) / 5;
    private static final String TAG = UrlDragImageView.class.getSimpleName();
    private static final int TOUCH_SLOP = ViewConfiguration.get(TbadkCoreApplication.getInst()).getScaledTouchSlop();

    /* loaded from: classes.dex */
    public interface a {
        void l(String str, byte[] bArr);
    }

    /* loaded from: classes.dex */
    public interface b {
        void bDw();
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
        if (this.fAx != null) {
            this.fAx.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.fAB = aVar;
    }

    public UrlDragImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.fAx = null;
        this.fAB = null;
        this.fzb = false;
        this.fAE = false;
        this.isInDragScaleMode = false;
        this.mRatio = 1.0f;
        this.mMoveDistance = 0.0f;
        this.mDragMatrix = new Matrix();
        this.mDstRect = new RectF();
        this.fAO = 0.0f;
        this.fAP = 0.0f;
        this.fAQ = 1.0f;
        this.fAR = 1.0f;
        this.fAS = 0.0f;
        this.fAT = false;
        this.fAU = false;
        this.fAV = false;
        this.fAW = false;
        this.fAZ = true;
        this.fBa = 0.0f;
        this.mOnClickListener = null;
        this.mLongClickListener = null;
        this.fBb = null;
        this.fBf = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.fAZ = true;
            }
        };
        this.fBg = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.fBc.setVisibility(8);
                        UrlDragImageView.this.fBb = null;
                        UrlDragImageView.this.fAW = false;
                    }
                });
            }
        };
        this.fBh = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.fAY != null) {
                    UrlDragImageView.this.fAY.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.fAX = new com.baidu.tbadk.img.b();
        init();
    }

    public UrlDragImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.fAx = null;
        this.fAB = null;
        this.fzb = false;
        this.fAE = false;
        this.isInDragScaleMode = false;
        this.mRatio = 1.0f;
        this.mMoveDistance = 0.0f;
        this.mDragMatrix = new Matrix();
        this.mDstRect = new RectF();
        this.fAO = 0.0f;
        this.fAP = 0.0f;
        this.fAQ = 1.0f;
        this.fAR = 1.0f;
        this.fAS = 0.0f;
        this.fAT = false;
        this.fAU = false;
        this.fAV = false;
        this.fAW = false;
        this.fAZ = true;
        this.fBa = 0.0f;
        this.mOnClickListener = null;
        this.mLongClickListener = null;
        this.fBb = null;
        this.fBf = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.fAZ = true;
            }
        };
        this.fBg = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.fBc.setVisibility(8);
                        UrlDragImageView.this.fBb = null;
                        UrlDragImageView.this.fAW = false;
                    }
                });
            }
        };
        this.fBh = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.fAY != null) {
                    UrlDragImageView.this.fAY.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.fAX = new com.baidu.tbadk.img.b();
        init();
    }

    public DragImageView getImageView() {
        return this.fAx;
    }

    public void setGifSetListener(DragImageView.e eVar) {
        this.fAx.setGifSetListener(eVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.fAx.setImageOnClickListener(onClickListener);
        this.fAz.setOnClickListener(onClickListener);
        this.mOnClickListener = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mLongClickListener = onLongClickListener;
        if (!this.fzd) {
            this.fAx.setImageOnLongClickListener(this.mLongClickListener);
            this.fAz.setOnLongClickListener(this.mLongClickListener);
        }
    }

    public void setOnSizeChangedListener(final DragImageView.g gVar) {
        this.fAx.setOnSizeChangedListener(new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.8
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (gVar != null) {
                    gVar.a(dragImageView, z, z2);
                }
                UrlDragImageView.this.bDk();
            }
        });
    }

    protected void init() {
        this.fAN = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        this.mMaxWidth = l.getEquipmentWidth(this.mContext);
        this.mMaxHeight = l.getEquipmentHeight(this.mContext) - ((int) this.mContext.getResources().getDimension(R.dimen.ds166));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.fAx = new DragImageView(this.mContext);
        this.fAx.setLayoutParams(layoutParams);
        this.fAx.setOnTouchListener(this.fBh);
        addView(this.fAx);
        this.fAz = new SubsamplingScaleImageView(this.mContext);
        this.fAz.setMaxScale(50.0f);
        this.fAz.setOnTouchListener(this.fBh);
        this.fAz.setVisibility(4);
        addView(this.fAz, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(getResources().getDrawable(R.drawable.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        bDj();
        this.fBe = TbSingleton.getInstance().isCutoutScreen(TbadkApplication.getInst().getCurrentActivity());
    }

    private void bDj() {
        this.fBc = new CircleProgressView(this.mContext);
        this.fBc.setCircleBackgroundColor(ao.getColor(R.color.CAM_X0109));
        this.fBc.setCircleForegroundColor(ao.getColor(R.color.CAM_X0302));
        this.fBc.setProgress(0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds80), l.getDimens(getContext(), R.dimen.tbds80));
        layoutParams.addRule(13);
        this.fBc.setVisibility(8);
        addView(this.fBc, layoutParams);
    }

    public void setIsCanDrag(boolean z) {
        this.fzd = z;
    }

    public String getmCheckOriginPicText() {
        return this.fBb;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        Bitmap imageBitmap;
        int height;
        int width;
        if (this.fAT && !this.fBd && this.fAz.getVisibility() == 0 && !this.fAz.isImageLoaded()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.fzd || !this.fAD) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.fAF && motionEvent.getPointerCount() >= 2) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.fAF || this.fAG) {
            requestDisallowInterceptTouchEvent(true);
        }
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        float x = motionEvent.getX();
        int i = action & 255;
        if (i == 0) {
            if (this.fAH == null) {
                if (this.fAz.getVisibility() == 0) {
                    this.fAH = g.bZ(this.fAz);
                } else {
                    this.fAH = g.bZ(this.fAx);
                }
            }
            if (this.mDisplayRect == null && this.fAH != null) {
                int measuredWidth = getMeasuredWidth();
                float measuredWidth2 = ((getMeasuredWidth() * 1.0f) / this.fAH.getWidth()) * this.fAH.getHeight();
                if (measuredWidth2 > getMeasuredHeight()) {
                    measuredWidth2 = getMeasuredHeight();
                }
                RectF rectInScreenFromPosition = getRectInScreenFromPosition(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
                this.mDisplayRect = new Rect((int) rectInScreenFromPosition.left, (int) rectInScreenFromPosition.top, (int) rectInScreenFromPosition.right, (int) rectInScreenFromPosition.bottom);
            }
            if (this.fAK == null && this.fAH != null) {
                if (this.fAz.getVisibility() == 0) {
                    height = this.fAz.getSHeight();
                    width = this.fAz.getSWidth();
                } else {
                    if (this.fAx.getImageType() == 1) {
                        imageBitmap = (this.fAx.getCurrentFrame() == null || this.fAx.getCurrentFrame().bm == null) ? this.fAH : this.fAx.getCurrentFrame().bm;
                    } else {
                        imageBitmap = this.fAx.getImageBitmap() == null ? this.fAH : this.fAx.getImageBitmap();
                    }
                    height = imageBitmap.getHeight();
                    width = imageBitmap.getWidth();
                }
                float equipmentDensity = l.getEquipmentDensity(getContext());
                int i2 = (int) (height * equipmentDensity);
                int i3 = (int) (width * equipmentDensity);
                if (i3 > this.fAH.getWidth() && this.fAH.getWidth() != 0) {
                    float width2 = (i3 * 1.0f) / this.fAH.getWidth();
                    i3 = this.fAH.getWidth();
                    i2 = (int) (i2 / width2);
                }
                if (i2 > this.fAH.getHeight() && this.fAH.getHeight() != 0) {
                    i3 = (int) (i3 / ((i2 * 1.0f) / this.fAH.getHeight()));
                    i2 = this.fAH.getHeight();
                }
                int equipmentHeight = (l.getEquipmentHeight(getContext()) - i2) / 2;
                int equipmentWidth = (l.getEquipmentWidth(getContext()) - i3) / 2;
                this.fAK = new Rect(equipmentWidth, equipmentHeight, i3 + equipmentWidth, i2 + equipmentHeight);
                this.fAL = new Rect(this.fAK);
                this.fAS = equipmentHeight / l.getEquipmentHeight(getContext());
                this.fAJ = new Rect(0, 0, this.fAH.getWidth(), this.fAH.getHeight());
            }
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (i == 2) {
            this.fAF = w(this.mLastMotionX - x, this.mLastMotionY - y);
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (this.fAF || this.fAG) {
            this.fAx.setImageOnLongClickListener(null);
            this.fAz.setOnLongClickListener(null);
            z = true;
        } else {
            this.fAx.setImageOnLongClickListener(this.mLongClickListener);
            this.fAz.setOnLongClickListener(this.mLongClickListener);
            z = super.dispatchTouchEvent(motionEvent);
        }
        if (i == 1 || i == 3) {
            this.mLastMotionX = 0.0f;
            this.mLastMotionY = 0.0f;
            boolean z2 = (-this.mMoveDistance) > ((float) (EXIT_DISTANCE * 2));
            boolean z3 = this.mMoveDistance > ((float) EXIT_DISTANCE);
            if (z2 || z3) {
                this.fAG = true;
                startExitAnimation();
                if (z2) {
                    TiebaStatic.log(new aq("c13377").dX("obj_type", "3"));
                } else if (z3) {
                    TiebaStatic.log(new aq("c13377").dX("obj_type", "2"));
                }
            } else {
                if (this.fAF && this.fAM != null) {
                    this.fAM.bJy();
                }
                this.mRatio = 1.0f;
                invalidate();
            }
            this.isInDragScaleMode = false;
            this.mDragMatrix.reset();
            this.fAF = false;
        }
        return z;
    }

    private boolean w(float f, float f2) {
        if (this.fAz.getVisibility() != 0 || this.fAz.isCanDrag()) {
            if (this.fxZ == null || !this.fxZ.isLongPic || this.fAz.getVisibility() != 0 || this.fAz.isViewTop()) {
                if (this.fxZ == null || !this.fxZ.isLongPic || this.fAz.getVisibility() == 0 || this.fAx.isAtViewTop() || this.fAx.bJw()) {
                    if (this.fAz.getVisibility() == 0 || this.fAx.pagerCantScroll()) {
                        if (this.fAH != null && getScrollY() == 0) {
                            boolean z = (this.fxZ == null || !this.fxZ.isLongPic) && ((f2 < -15.0f && !this.isInDragScaleMode) || (f2 > 15.0f && !this.isInDragScaleMode));
                            boolean z2 = this.fxZ != null && this.fxZ.isLongPic && f2 < 0.0f && !this.isInDragScaleMode;
                            if (z || (z2 && this.fAx.isViewTop())) {
                                this.fAx.setImageOnLongClickListener(null);
                                this.fAz.setOnLongClickListener(null);
                                this.isInDragScaleMode = true;
                                this.mMoveDistance = 0.0f;
                                this.mRatio = 1.0f;
                                if (this.fAM != null) {
                                    this.fAM.onDragStart();
                                }
                            }
                        }
                        if (!this.isInDragScaleMode || this.fAH == null) {
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
                        this.mDragMatrix.preScale(1.0f + f3, 1.0f + f3, (this.mRatio * this.fAH.getWidth()) / 2.0f, this.mRatio * (this.fAH.getHeight() / 2));
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
        if (this.fAF && this.fAH != null && !this.fAH.isRecycled() && this.isInDragScaleMode) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.mDstRect == null) {
                this.mDstRect = new RectF();
            }
            this.mDragMatrix.mapRect(this.mDstRect, new RectF(this.mDisplayRect));
            canvas.drawBitmap(this.fAH, this.fAJ, this.mDstRect, (Paint) null);
        } else if (this.fAG && this.fAH != null && !this.fAH.isRecycled()) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.fxZ == null || this.fxZ.getSourceImageRectInScreen() == null) {
                canvas.drawBitmap(this.fAH, this.fAJ, this.mDstRect, (Paint) null);
            } else {
                canvas.drawBitmap(this.fAH, this.fAK, this.mDstRect, (Paint) null);
            }
        } else {
            super.dispatchDraw(canvas);
        }
    }

    private void startExitAnimation() {
        if (this.fxZ == null) {
            if (this.fAM != null) {
                this.fAM.onDragEnd();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.fxZ.getSourceImageRectInScreen();
        final Rect dstRectInScreen = this.fxZ.getDstRectInScreen();
        if (sourceImageRectInScreen == null || dstRectInScreen == null) {
            if (this.fAM != null) {
                this.fAM.onDragEnd();
                return;
            }
            return;
        }
        a(sourceImageRectInScreen, dstRectInScreen);
        a(sourceImageRectInScreen);
        this.fAI = new RectF(this.mDstRect);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(150L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && sourceImageRectInScreen != null && dstRectInScreen != null) {
                    UrlDragImageView.this.ao(valueAnimator.getAnimatedFraction());
                    UrlDragImageView.this.a(dstRectInScreen, valueAnimator.getAnimatedFraction(), UrlDragImageView.this.fBe);
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
                if (UrlDragImageView.this.fAM != null) {
                    UrlDragImageView.this.fAM.onDragEnd();
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
            this.mDstRect.top += this.mDstRect.height() * this.fAS;
            this.mDstRect.bottom = f + this.mDstRect.top;
        }
    }

    public void setCanScale(boolean z) {
        if (this.fAx != null) {
            this.fAx.setCanScale(z);
        }
    }

    private void a(Rect rect, Rect rect2) {
        this.fAO = 0.0f;
        this.fAP = 0.0f;
        this.fAQ = 1.0f;
        this.fAR = 1.0f;
        if (rect != null && rect2 != null && rect.contains(rect2)) {
            this.fAO = (rect2.left - rect.left) / rect.width();
            this.fAP = (rect2.top - rect.top) / rect.height();
            this.fAQ = (rect2.right - rect.left) / rect.width();
            this.fAR = (rect2.bottom - rect.top) / rect.height();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ao(float f) {
        if (this.fAK != null) {
            this.fAK.left = (int) (this.fAL.left + (this.fAL.width() * this.fAO * f));
            this.fAK.top = (int) (this.fAL.top + (this.fAL.height() * this.fAP * f));
            this.fAK.right = (int) (this.fAL.left + (this.fAL.width() * (((1.0f - this.fAQ) * (1.0f - f)) + this.fAQ)));
            this.fAK.bottom = (int) (this.fAL.top + (this.fAL.height() * (((1.0f - this.fAR) * (1.0f - f)) + this.fAR)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Rect rect, float f, boolean z) {
        int i = 0;
        if (z) {
            i = l.getDimens(getContext(), R.dimen.tbds80);
        }
        if (this.mDstRect != null && rect != null) {
            this.mDstRect.left = this.fAI.left + ((rect.left - this.fAI.left) * f);
            this.mDstRect.top = (this.fAI.top + ((rect.top - this.fAI.top) * f)) - i;
            this.mDstRect.right = this.fAI.right + ((rect.right - this.fAI.right) * f);
            this.mDstRect.bottom = this.fAI.bottom + ((rect.bottom - this.fAI.bottom) * f);
        }
    }

    private RectF getRectInScreenFromPosition(float f, float f2, float f3, float f4) {
        return new RectF(f - (f3 / 2.0f), f2 - (f4 / 2.0f), (f3 / 2.0f) + f, (f4 / 2.0f) + f2);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.fAY = onTouchListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDk() {
        if ((this.fAC || this.fAD) && this.fxZ != null && this.fxZ.mPicType == 1 && !TextUtils.isEmpty(this.fxZ.mTagName)) {
            if (this.fAy != null) {
                this.fAy.setVisibility(8);
                this.fAy = null;
            }
            this.fAy = new TextView(this.mContext);
            this.fAy.setText(this.fxZ.mTagName);
            this.fAy.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize26));
            ao.setViewTextColor(this.fAy, R.color.common_color_10013, 1, 0);
            ao.setBackgroundColor(this.fAy, R.color.common_color_10215);
            this.fAy.setAlpha(0.75f);
            this.fAy.setIncludeFontPadding(false);
            this.fAy.setGravity(17);
            int dimens = l.getDimens(this.mContext, R.dimen.ds2);
            this.fAy.setPadding(dimens, dimens, dimens, dimens);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.fAx.getBottomOffset();
            layoutParams.leftMargin = this.fAx.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.fAy, layoutParams);
            this.fAy.setVisibility(0);
        }
    }

    public void setUrl(String str, boolean z) {
        if (str.contains("*")) {
            str = str.split("[*]")[0];
        }
        this.fAx.setTag(str);
        this.fAx.setLoadBigImage(false);
        this.fAx.setImageDrawable(null);
        this.fAC = false;
        this.fAD = false;
        this.fAT = bDs();
        this.fBb = null;
        if (Dm(str)) {
            e(str, z, false);
        }
    }

    private boolean bDl() {
        return this.fAx != null && this.fAx.isLoadBigImage();
    }

    public void bDm() {
        if (this.fxZ != null && !bDl()) {
            String str = this.fxZ.imageUrl;
            int i = this.fxZ.urlType;
            com.baidu.adp.widget.ImageView.a aVar = null;
            if (com.baidu.tbadk.core.util.d.a.ap(str, i)) {
                aVar = com.baidu.tbadk.core.util.d.a.aq(str, i);
            }
            if (aVar != null) {
                setThumbBitmapToView(aVar);
            }
        }
    }

    private boolean kD(boolean z) {
        String nameMd5FromUrl;
        if (!this.fAU || z) {
            this.fAU = true;
            if (!this.fAT || this.fxZ == null || StringUtils.isNull(this.fxZ.originalUrl, true) || this.fxZ.originalSize < 0 || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String str = this.fAN + as.bwp().BY(nameMd5FromUrl) + "/" + av.getNameMd5FromUrl(this.fxZ.originalUrl);
            final int[] imageFileWH = n.getImageFileWH(str);
            this.fAz.setVisibility(0);
            if (this.fAA == null) {
                this.fAA = new SubsamplingScaleImageView.OnImageEventListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12
                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onReady() {
                        UrlDragImageView.this.fBb = null;
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.fAx.restoreSize();
                        UrlDragImageView.this.fAx.setVisibility(4);
                    }

                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onImageLoaded() {
                        if (UrlDragImageView.this.fxZ.isLongPic && imageFileWH[0] > 0) {
                            UrlDragImageView.this.fAx.onDestroy();
                            final float measuredWidth = (UrlDragImageView.this.getMeasuredWidth() * 1.0f) / imageFileWH[0];
                            final PointF pointF = new PointF((imageFileWH[0] * 1.0f) / 2.0f, 0.0f);
                            UrlDragImageView.this.fAz.setScaleAndCenter(measuredWidth, pointF);
                            UrlDragImageView.this.fAz.setMaxScale(2.0f * measuredWidth);
                            UrlDragImageView.this.fAz.setDoubleTapZoomScale(2.0f * measuredWidth);
                            UrlDragImageView.this.fAz.setInitScale(measuredWidth);
                            UrlDragImageView.this.fAz.setDoubleTapZoomStyle(4);
                            UrlDragImageView.this.fAz.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12.1
                                @Override // android.view.View.OnTouchListener
                                public boolean onTouch(View view, MotionEvent motionEvent) {
                                    if (UrlDragImageView.this.fAY != null) {
                                        UrlDragImageView.this.fAY.onTouch(view, motionEvent);
                                    }
                                    switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                                        case 0:
                                            UrlDragImageView.this.fBa = motionEvent.getY();
                                            UrlDragImageView.this.fAz.setOnClickListener(UrlDragImageView.this.fAZ ? UrlDragImageView.this.mOnClickListener : null);
                                            UrlDragImageView.this.fAz.setOnLongClickListener(UrlDragImageView.this.fAZ ? UrlDragImageView.this.mLongClickListener : null);
                                            break;
                                        case 1:
                                        case 3:
                                            if (UrlDragImageView.this.fAz.getScale() < measuredWidth) {
                                                UrlDragImageView.this.fAz.setScaleAndCenter(measuredWidth, pointF);
                                            }
                                            e.mB().removeCallbacks(UrlDragImageView.this.fBf);
                                            e.mB().postDelayed(UrlDragImageView.this.fBf, 1000L);
                                            break;
                                        case 2:
                                            if (Math.abs(motionEvent.getY() - UrlDragImageView.this.fBa) > UrlDragImageView.TOUCH_SLOP) {
                                                UrlDragImageView.this.fAZ = false;
                                                UrlDragImageView.this.fAz.setOnClickListener(null);
                                                UrlDragImageView.this.fAz.setOnLongClickListener(null);
                                            }
                                            UrlDragImageView.this.fBa = motionEvent.getY();
                                            break;
                                    }
                                    return false;
                                }
                            });
                            UrlDragImageView.this.fAx.setVisibility(4);
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
            this.fAz.setOnImageEventListener(this.fAA);
            if (this.fAz.isImageLoaded() && this.fxZ.isLongPic) {
                this.fAA.onImageLoaded();
            } else {
                this.fAz.setImage(ImageSource.uri(str));
            }
            return true;
        }
        return false;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.fAM = dVar;
        if (this.fAx != null) {
            this.fAx.setDragToExitListener(dVar);
        }
    }

    public void bDn() {
        kD(false);
    }

    private boolean Dm(String str) {
        return j.isNetWorkAvailable() || com.baidu.tbadk.core.util.d.b.Cl(str);
    }

    private void setThumbBitmapToView(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap rawBitmap;
        if (!this.fAD && aVar != null && (rawBitmap = aVar.getRawBitmap()) != null) {
            this.fAC = true;
            if (aVar.isGif()) {
                this.fAx.setImageUrlData(this.fxZ);
                this.fAx.setImageBitmap(rawBitmap);
                this.fBb = null;
                this.fAW = false;
            } else {
                if (this.fxZ != null && this.fxZ.isLongPic) {
                    this.fAx.createLargeImageDelegate();
                    this.fAx.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.13
                        @Override // com.baidu.tbadk.widget.largeImage.logic.a
                        public void onLoadFinished() {
                        }
                    });
                }
                this.fAx.setImageUrlData(this.fxZ);
                this.fAx.setImageData(rawBitmap, aVar.getByteData());
            }
            bDk();
        }
    }

    private void e(String str, boolean z, boolean z2) {
        if (Dn(str)) {
            if (z2 || (!this.fAE && !this.fAD)) {
                if (!z2 || !kD(true)) {
                    this.fAE = true;
                    d.mx().a(str, 27, new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.14
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.c
                        public void onCancelled(String str2) {
                            UrlDragImageView.this.fAE = false;
                            UrlDragImageView.this.fAx.setVisibility(0);
                            UrlDragImageView.this.mProgressBar.setVisibility(8);
                            UrlDragImageView.this.fBb = null;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.c
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            UrlDragImageView.this.fAE = false;
                            UrlDragImageView.this.fAD = true;
                            UrlDragImageView.this.b(aVar);
                        }
                    }, 0, 0, false, null, Boolean.valueOf(z), this.fAx.getImageData(), Boolean.valueOf(this.fzb));
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
        com.baidu.adp.widget.ImageView.a a2 = this.fAX.a(imageFileInfo, false);
        if (a2 != null) {
            this.fAD = true;
            this.mProgressBar.setVisibility(8);
            this.fBb = null;
            b(a2);
            return;
        }
        this.fAX.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.2
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.ImageView.a aVar, String str2, boolean z3) {
                UrlDragImageView.this.fAD = true;
                UrlDragImageView.this.mProgressBar.setVisibility(8);
                UrlDragImageView.this.fBb = null;
                UrlDragImageView.this.b(aVar);
            }
        }, false);
    }

    private boolean Dn(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null && this.fAB != null) {
            this.fAB.l(aVar.getUrl(), aVar.getByteData());
        }
        if (aVar == null || aVar.getRawBitmap() == null) {
            bDo();
            return;
        }
        Bitmap rawBitmap = aVar.getRawBitmap();
        this.fAx.setLoadBigImage(true);
        if (aVar.isGif()) {
            this.fAx.setGifData(aVar.getByteData(), rawBitmap);
            this.fAx.invalidate();
            this.fAx.play();
            this.fAW = false;
            this.fBb = null;
            this.mProgressBar.setVisibility(8);
        } else {
            if (this.fxZ != null && this.fxZ.isLongPic) {
                this.fAx.createLargeImageDelegate();
                this.fAx.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.3
                    @Override // com.baidu.tbadk.widget.largeImage.logic.a
                    public void onLoadFinished() {
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.fBb = null;
                    }
                });
            } else {
                this.mProgressBar.setVisibility(8);
                this.fBb = null;
            }
            this.fAx.setImageUrlData(this.fxZ);
            this.fAx.setImageData(rawBitmap, aVar.getByteData());
            bDt();
        }
        bDk();
    }

    private void bDo() {
        if (!this.fAC) {
            this.fAx.setDefaultBitmap();
        } else {
            this.fAD = false;
        }
        this.fBb = null;
        this.mProgressBar.setVisibility(8);
    }

    public void setGifMaxUseableMem(int i) {
        this.fAx.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.fAx != null) {
            this.fAx.onDestroy();
        }
        if (this.fAz != null) {
            this.fAz.recycle();
        }
        if (this.fAH != null) {
            this.fAH.recycle();
            this.fAH = null;
        }
        if (this.mProgressBar != null) {
            this.fBb = null;
            this.mProgressBar.setVisibility(8);
        }
        e.mB().removeCallbacks(this.fBf);
        com.baidu.tieba.view.c.dXw().setColor(-1);
    }

    public void release() {
        if (this.fAx != null) {
            this.fAx.release();
        }
        if (this.mProgressBar != null) {
            this.fBb = null;
            this.mProgressBar.setVisibility(8);
        }
        this.fBb = null;
    }

    public void bDp() {
        if (this.fAx != null && this.fAx.getImageType() == 1) {
            this.fAx.stop();
        }
    }

    public void E(boolean z, boolean z2) {
        String str;
        if (this.fAx != null && (str = (String) this.fAx.getTag()) != null) {
            if (this.fAx.getImageType() == 1) {
                if (this.fAx.getGifCache() == null || !this.fAx.isLoadBigImage()) {
                    e(str, z, z2);
                }
            } else if (this.fAx.getImageType() == 2) {
                e(str, z, z2);
            } else if (bDq()) {
                e(str, z, z2);
            }
        }
    }

    private boolean bDq() {
        if (this.fAx.getImageBitmap() != null && this.fAx.isLoadBigImage()) {
            if (this.fxZ == null || !this.fxZ.isLongPic || this.fAx.hasLoadLongImage()) {
                return false;
            }
            this.fAD = false;
            this.fAU = false;
            return true;
        }
        return true;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.fxZ = imageUrlData;
    }

    public ImageUrlData getmAssistUrlData() {
        return this.fxZ;
    }

    public void setIsCdn(boolean z) {
        this.fzb = z;
    }

    public void bDr() {
        final String nameMd5FromUrl = av.getNameMd5FromUrl(this.fxZ.originalUrl);
        if (this.fxZ.originalProcess >= 0) {
            com.baidu.tbadk.download.d.bEF().cancelDownLoadById(nameMd5FromUrl, 13);
            this.fxZ.originalProcess = -1;
            bDt();
            return;
        }
        if (this.fyU != null) {
            this.fyU.bDw();
        }
        f<?> K = com.baidu.adp.base.j.K(this.mContext);
        if (K == null) {
            Do(nameMd5FromUrl);
        } else if (!j.isNetWorkAvailable() || j.isWifiNet() || com.baidu.tbadk.core.sharedPref.b.bvr().getBoolean(SharedPrefConfig.ORIGINAL_IMG_DOWN_TIP, false)) {
            Do(nameMd5FromUrl);
        } else {
            com.baidu.tbadk.core.sharedPref.b.bvr().putBoolean(SharedPrefConfig.ORIGINAL_IMG_DOWN_TIP, true);
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(K.getPageActivity());
            aVar.pa(R.string.original_img_down_no_wifi_tip);
            aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    UrlDragImageView.this.Do(nameMd5FromUrl);
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                }
            });
            aVar.b(K);
            aVar.btY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Do(String str) {
        if (this.fxZ != null) {
            this.fxZ.originalProcess = 0;
            this.fBc.setProgress(0);
            this.fBc.setVisibility(0);
            DownloadData downloadData = new DownloadData(str);
            downloadData.setStatus(1);
            downloadData.setUrl(this.fxZ.originalUrl);
            downloadData.setType(13);
            downloadData.setPath(this.fAN + as.bwp().BY(str) + "/" + str);
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.6
                @Override // com.baidu.tbadk.download.c
                public boolean onPreDownload(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2 != null) {
                        if (UrlDragImageView.this.fxZ != null && UrlDragImageView.this.fxZ.originalProcess != -1) {
                            UrlDragImageView.this.fxZ.originalProcess = downloadData2.getProcess();
                        }
                        if (UrlDragImageView.this.fxZ == null || UrlDragImageView.this.fxZ.originalProcess != -1) {
                            UrlDragImageView.this.fBc.setProgress(downloadData2.getProcess());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public boolean onFileDownloaded(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadSucceed(DownloadData downloadData2) {
                    UrlDragImageView.this.fBc.setVisibility(8);
                    e.mB().postDelayed(UrlDragImageView.this.fBg, 1500L);
                    UrlDragImageView.this.fAU = false;
                    UrlDragImageView.this.fAT = UrlDragImageView.this.bDs();
                    UrlDragImageView.this.bDn();
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str2) {
                    UrlDragImageView.this.fBc.setVisibility(8);
                    UrlDragImageView.this.fAU = false;
                    BdToast.b(UrlDragImageView.this.mContext, str2).bud().bue();
                    UrlDragImageView.this.fxZ.originalProcess = -1;
                    UrlDragImageView.this.bDt();
                }
            });
            com.baidu.tbadk.download.d.bEF().a(downloadData, 100);
            this.fBd = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bDs() {
        if (this.fxZ != null && !StringUtils.isNull(this.fxZ.originalUrl, true) && this.fxZ.originalSize >= 0 && !this.fxZ.isBlockedPic) {
            String nameMd5FromUrl = av.getNameMd5FromUrl(this.fxZ.originalUrl);
            File file = new File(this.fAN + as.bwp().BY(nameMd5FromUrl) + "/" + nameMd5FromUrl);
            if (file != null && file.exists()) {
                this.fxZ.originalProcess = 100;
                return true;
            }
            if (this.fxZ.originalProcess < 0) {
                bDt();
            } else {
                this.fBc.setProgress(this.fxZ.originalProcess);
            }
            this.fAW = true;
        } else {
            this.fBb = null;
        }
        return false;
    }

    public void bDt() {
        if (this.fxZ != null) {
            if (!bDu() || !this.fAW) {
                this.fBb = null;
            } else if (this.fxZ.originalSize > 0 && !ed(this.fxZ.originalSize)) {
                this.fBb = fAv + "(" + at.getFormatSize(this.fxZ.originalSize) + ")";
            } else {
                this.fBb = fAv;
            }
        }
    }

    private boolean bDu() {
        return (this.fxZ == null || !this.fxZ.mIsShowOrigonButton || this.fxZ.isBlockedPic || StringUtils.isNull(this.fxZ.originalUrl)) ? false : true;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.fyU = bVar;
    }

    private boolean ed(long j) {
        return j > fAw;
    }
}
