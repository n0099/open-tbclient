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
import com.baidu.adp.base.i;
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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.util.g;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.File;
/* loaded from: classes8.dex */
public class UrlDragImageView extends RelativeLayout {
    private ImageUrlData dRk;
    private b dSp;
    private boolean dSw;
    private boolean dSy;
    protected DragImageView dTR;
    protected TextView dTS;
    protected SubsamplingScaleImageView dTT;
    private SubsamplingScaleImageView.OnImageEventListener dTU;
    private a dTV;
    private boolean dTW;
    private boolean dTX;
    private boolean dTY;
    private boolean dTZ;
    private Runnable dUA;
    private View.OnTouchListener dUB;
    private boolean dUa;
    private Bitmap dUb;
    private RectF dUc;
    private Rect dUd;
    private Rect dUe;
    private Rect dUf;
    private DragImageView.d dUg;
    private String dUh;
    private float dUi;
    private float dUj;
    private float dUk;
    private float dUl;
    private float dUm;
    private boolean dUn;
    private boolean dUo;
    private boolean dUp;
    public boolean dUq;
    private com.baidu.tbadk.img.b dUr;
    private View.OnTouchListener dUs;
    private boolean dUt;
    private float dUu;
    private String dUv;
    private CircleProgressView dUw;
    private boolean dUx;
    private boolean dUy;
    private Runnable dUz;
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
    private static final String dTP = TbadkCoreApplication.getInst().getString(R.string.original_img_look);
    private static long dTQ = Config.RAVEN_LOG_LIMIT;
    private static final int EXIT_DISTANCE = l.getEquipmentHeight(TbadkCoreApplication.getInst()) / 5;
    private static final String TAG = UrlDragImageView.class.getSimpleName();
    private static final int TOUCH_SLOP = ViewConfiguration.get(TbadkCoreApplication.getInst()).getScaledTouchSlop();

    /* loaded from: classes8.dex */
    public interface a {
        void k(String str, byte[] bArr);
    }

    /* loaded from: classes8.dex */
    public interface b {
        void aVH();
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
        if (this.dTR != null) {
            this.dTR.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.dTV = aVar;
    }

    public UrlDragImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.dTR = null;
        this.dTV = null;
        this.dSw = false;
        this.dTY = false;
        this.isInDragScaleMode = false;
        this.mRatio = 1.0f;
        this.mMoveDistance = 0.0f;
        this.mDragMatrix = new Matrix();
        this.mDstRect = new RectF();
        this.dUi = 0.0f;
        this.dUj = 0.0f;
        this.dUk = 1.0f;
        this.dUl = 1.0f;
        this.dUm = 0.0f;
        this.dUn = false;
        this.dUo = false;
        this.dUp = false;
        this.dUq = false;
        this.dUt = true;
        this.dUu = 0.0f;
        this.mOnClickListener = null;
        this.mLongClickListener = null;
        this.dUv = null;
        this.dUz = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.dUt = true;
            }
        };
        this.dUA = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.dUw.setVisibility(8);
                        UrlDragImageView.this.dUv = null;
                        UrlDragImageView.this.dUq = false;
                    }
                });
            }
        };
        this.dUB = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.dUs != null) {
                    UrlDragImageView.this.dUs.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.dUr = new com.baidu.tbadk.img.b();
        init();
    }

    public UrlDragImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.dTR = null;
        this.dTV = null;
        this.dSw = false;
        this.dTY = false;
        this.isInDragScaleMode = false;
        this.mRatio = 1.0f;
        this.mMoveDistance = 0.0f;
        this.mDragMatrix = new Matrix();
        this.mDstRect = new RectF();
        this.dUi = 0.0f;
        this.dUj = 0.0f;
        this.dUk = 1.0f;
        this.dUl = 1.0f;
        this.dUm = 0.0f;
        this.dUn = false;
        this.dUo = false;
        this.dUp = false;
        this.dUq = false;
        this.dUt = true;
        this.dUu = 0.0f;
        this.mOnClickListener = null;
        this.mLongClickListener = null;
        this.dUv = null;
        this.dUz = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.dUt = true;
            }
        };
        this.dUA = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.dUw.setVisibility(8);
                        UrlDragImageView.this.dUv = null;
                        UrlDragImageView.this.dUq = false;
                    }
                });
            }
        };
        this.dUB = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.dUs != null) {
                    UrlDragImageView.this.dUs.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.dUr = new com.baidu.tbadk.img.b();
        init();
    }

    public DragImageView getImageView() {
        return this.dTR;
    }

    public void setGifSetListener(DragImageView.e eVar) {
        this.dTR.setGifSetListener(eVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.dTR.setImageOnClickListener(onClickListener);
        this.dTT.setOnClickListener(onClickListener);
        this.mOnClickListener = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mLongClickListener = onLongClickListener;
        if (!this.dSy) {
            this.dTR.setImageOnLongClickListener(this.mLongClickListener);
            this.dTT.setOnLongClickListener(this.mLongClickListener);
        }
    }

    public void setOnSizeChangedListener(final DragImageView.g gVar) {
        this.dTR.setOnSizeChangedListener(new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.8
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (gVar != null) {
                    gVar.a(dragImageView, z, z2);
                }
                UrlDragImageView.this.aVv();
            }
        });
    }

    protected void init() {
        this.dUh = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        this.mMaxWidth = l.getEquipmentWidth(this.mContext);
        this.mMaxHeight = l.getEquipmentHeight(this.mContext) - ((int) this.mContext.getResources().getDimension(R.dimen.ds166));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.dTR = new DragImageView(this.mContext);
        this.dTR.setLayoutParams(layoutParams);
        this.dTR.setOnTouchListener(this.dUB);
        addView(this.dTR);
        this.dTT = new SubsamplingScaleImageView(this.mContext);
        this.dTT.setMaxScale(50.0f);
        this.dTT.setOnTouchListener(this.dUB);
        this.dTT.setVisibility(4);
        addView(this.dTT, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(getResources().getDrawable(R.drawable.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        aVu();
        this.dUy = TbSingleton.getInstance().isCutoutScreen(TbadkApplication.getInst().getCurrentActivity());
    }

    private void aVu() {
        this.dUw = new CircleProgressView(this.mContext);
        this.dUw.setCircleBackgroundColor(am.getColor(R.color.cp_cont_d));
        this.dUw.setCircleForegroundColor(am.getColor(R.color.cp_link_tip_a));
        this.dUw.setProgress(0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds80), l.getDimens(getContext(), R.dimen.tbds80));
        layoutParams.addRule(13);
        this.dUw.setVisibility(8);
        addView(this.dUw, layoutParams);
    }

    public void setIsCanDrag(boolean z) {
        this.dSy = z;
    }

    public String getmCheckOriginPicText() {
        return this.dUv;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        Bitmap imageBitmap;
        int height;
        int width;
        if (this.dUn && !this.dUx && this.dTT.getVisibility() == 0 && !this.dTT.isImageLoaded()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.dSy || !this.dTX) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.dTZ && motionEvent.getPointerCount() >= 2) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.dTZ || this.dUa) {
            requestDisallowInterceptTouchEvent(true);
        }
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        float x = motionEvent.getX();
        int i = action & 255;
        if (i == 0) {
            if (this.dUb == null) {
                if (this.dTT.getVisibility() == 0) {
                    this.dUb = g.bj(this.dTT);
                } else {
                    this.dUb = g.bj(this.dTR);
                }
            }
            if (this.mDisplayRect == null && this.dUb != null) {
                int measuredWidth = getMeasuredWidth();
                float measuredWidth2 = ((getMeasuredWidth() * 1.0f) / this.dUb.getWidth()) * this.dUb.getHeight();
                if (measuredWidth2 > getMeasuredHeight()) {
                    measuredWidth2 = getMeasuredHeight();
                }
                RectF rectInScreenFromPosition = getRectInScreenFromPosition(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
                this.mDisplayRect = new Rect((int) rectInScreenFromPosition.left, (int) rectInScreenFromPosition.top, (int) rectInScreenFromPosition.right, (int) rectInScreenFromPosition.bottom);
            }
            if (this.dUe == null && this.dUb != null) {
                if (this.dTT.getVisibility() == 0) {
                    height = this.dTT.getSHeight();
                    width = this.dTT.getSWidth();
                } else {
                    if (this.dTR.getImageType() == 1) {
                        imageBitmap = (this.dTR.getCurrentFrame() == null || this.dTR.getCurrentFrame().bm == null) ? this.dUb : this.dTR.getCurrentFrame().bm;
                    } else {
                        imageBitmap = this.dTR.getImageBitmap() == null ? this.dUb : this.dTR.getImageBitmap();
                    }
                    height = imageBitmap.getHeight();
                    width = imageBitmap.getWidth();
                }
                float equipmentDensity = l.getEquipmentDensity(getContext());
                int i2 = (int) (height * equipmentDensity);
                int i3 = (int) (width * equipmentDensity);
                if (i3 > this.dUb.getWidth() && this.dUb.getWidth() != 0) {
                    float width2 = (i3 * 1.0f) / this.dUb.getWidth();
                    i3 = this.dUb.getWidth();
                    i2 = (int) (i2 / width2);
                }
                if (i2 > this.dUb.getHeight() && this.dUb.getHeight() != 0) {
                    i3 = (int) (i3 / ((i2 * 1.0f) / this.dUb.getHeight()));
                    i2 = this.dUb.getHeight();
                }
                int equipmentHeight = (l.getEquipmentHeight(getContext()) - i2) / 2;
                int equipmentWidth = (l.getEquipmentWidth(getContext()) - i3) / 2;
                this.dUe = new Rect(equipmentWidth, equipmentHeight, i3 + equipmentWidth, i2 + equipmentHeight);
                this.dUf = new Rect(this.dUe);
                this.dUm = equipmentHeight / l.getEquipmentHeight(getContext());
                this.dUd = new Rect(0, 0, this.dUb.getWidth(), this.dUb.getHeight());
            }
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (i == 2) {
            this.dTZ = r(this.mLastMotionX - x, this.mLastMotionY - y);
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (this.dTZ || this.dUa) {
            this.dTR.setImageOnLongClickListener(null);
            this.dTT.setOnLongClickListener(null);
            z = true;
        } else {
            this.dTR.setImageOnLongClickListener(this.mLongClickListener);
            this.dTT.setOnLongClickListener(this.mLongClickListener);
            z = super.dispatchTouchEvent(motionEvent);
        }
        if (i == 1 || i == 3) {
            this.mLastMotionX = 0.0f;
            this.mLastMotionY = 0.0f;
            boolean z2 = (-this.mMoveDistance) > ((float) EXIT_DISTANCE);
            boolean z3 = this.mMoveDistance > ((float) EXIT_DISTANCE);
            if (z2 || z3) {
                this.dUa = true;
                startExitAnimation();
                if (z2) {
                    TiebaStatic.log(new an("c13377").cI("obj_type", "3"));
                } else if (z3) {
                    TiebaStatic.log(new an("c13377").cI("obj_type", "2"));
                }
            } else {
                if (this.dTZ && this.dUg != null) {
                    this.dUg.baR();
                }
                this.mRatio = 1.0f;
                invalidate();
            }
            this.isInDragScaleMode = false;
            this.mDragMatrix.reset();
            this.dTZ = false;
        }
        return z;
    }

    private boolean r(float f, float f2) {
        if (this.dTT.getVisibility() != 0 || this.dTT.isCanDrag()) {
            if (this.dRk == null || !this.dRk.isLongPic || this.dTT.getVisibility() != 0 || this.dTT.isViewTop()) {
                if (this.dRk == null || !this.dRk.isLongPic || this.dTT.getVisibility() == 0 || this.dTR.isAtViewTop() || this.dTR.baP()) {
                    if (this.dTT.getVisibility() == 0 || this.dTR.pagerCantScroll()) {
                        if (this.dUb != null && getScrollY() == 0) {
                            boolean z = (this.dRk == null || !this.dRk.isLongPic) && ((f2 < -15.0f && !this.isInDragScaleMode) || (f2 > 15.0f && !this.isInDragScaleMode));
                            boolean z2 = this.dRk != null && this.dRk.isLongPic && f2 < 0.0f && !this.isInDragScaleMode;
                            if (z || (z2 && this.dTR.isViewTop())) {
                                this.dTR.setImageOnLongClickListener(null);
                                this.dTT.setOnLongClickListener(null);
                                this.isInDragScaleMode = true;
                                this.mMoveDistance = 0.0f;
                                this.mRatio = 1.0f;
                                if (this.dUg != null) {
                                    this.dUg.onDragStart();
                                }
                            }
                        }
                        if (!this.isInDragScaleMode || this.dUb == null) {
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
                        this.mDragMatrix.preScale(1.0f + f3, 1.0f + f3, (this.mRatio * this.dUb.getWidth()) / 2.0f, this.mRatio * (this.dUb.getHeight() / 2));
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
        if (this.dTZ && this.dUb != null && !this.dUb.isRecycled() && this.isInDragScaleMode) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.mDstRect == null) {
                this.mDstRect = new RectF();
            }
            this.mDragMatrix.mapRect(this.mDstRect, new RectF(this.mDisplayRect));
            canvas.drawBitmap(this.dUb, this.dUd, this.mDstRect, (Paint) null);
        } else if (this.dUa && this.dUb != null && !this.dUb.isRecycled()) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.dRk == null || this.dRk.getSourceImageRectInScreen() == null) {
                canvas.drawBitmap(this.dUb, this.dUd, this.mDstRect, (Paint) null);
            } else {
                canvas.drawBitmap(this.dUb, this.dUe, this.mDstRect, (Paint) null);
            }
        } else {
            super.dispatchDraw(canvas);
        }
    }

    private void startExitAnimation() {
        if (this.dRk == null) {
            if (this.dUg != null) {
                this.dUg.onDragEnd();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.dRk.getSourceImageRectInScreen();
        final Rect dstRectInScreen = this.dRk.getDstRectInScreen();
        if (sourceImageRectInScreen == null || dstRectInScreen == null) {
            if (this.dUg != null) {
                this.dUg.onDragEnd();
                return;
            }
            return;
        }
        b(sourceImageRectInScreen, dstRectInScreen);
        b(sourceImageRectInScreen);
        this.dUc = new RectF(this.mDstRect);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(150L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && sourceImageRectInScreen != null && dstRectInScreen != null) {
                    UrlDragImageView.this.aa(valueAnimator.getAnimatedFraction());
                    UrlDragImageView.this.a(dstRectInScreen, valueAnimator.getAnimatedFraction(), UrlDragImageView.this.dUy);
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
                if (UrlDragImageView.this.dUg != null) {
                    UrlDragImageView.this.dUg.onDragEnd();
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

    private void b(Rect rect) {
        if (rect != null) {
            float f = ((rect.bottom - rect.top) / (rect.right - rect.left)) * (this.mDstRect.right - this.mDstRect.left);
            this.mDstRect.top += this.mDstRect.height() * this.dUm;
            this.mDstRect.bottom = f + this.mDstRect.top;
        }
    }

    public void setCanScale(boolean z) {
        if (this.dTR != null) {
            this.dTR.setCanScale(z);
        }
    }

    private void b(Rect rect, Rect rect2) {
        this.dUi = 0.0f;
        this.dUj = 0.0f;
        this.dUk = 1.0f;
        this.dUl = 1.0f;
        if (rect != null && rect2 != null && rect.contains(rect2)) {
            this.dUi = (rect2.left - rect.left) / rect.width();
            this.dUj = (rect2.top - rect.top) / rect.height();
            this.dUk = (rect2.right - rect.left) / rect.width();
            this.dUl = (rect2.bottom - rect.top) / rect.height();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa(float f) {
        if (this.dUe != null) {
            this.dUe.left = (int) (this.dUf.left + (this.dUf.width() * this.dUi * f));
            this.dUe.top = (int) (this.dUf.top + (this.dUf.height() * this.dUj * f));
            this.dUe.right = (int) (this.dUf.left + (this.dUf.width() * (((1.0f - this.dUk) * (1.0f - f)) + this.dUk)));
            this.dUe.bottom = (int) (this.dUf.top + (this.dUf.height() * (((1.0f - this.dUl) * (1.0f - f)) + this.dUl)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Rect rect, float f, boolean z) {
        int i = 0;
        if (z) {
            i = l.getDimens(getContext(), R.dimen.tbds80);
        }
        if (this.mDstRect != null && rect != null) {
            this.mDstRect.left = this.dUc.left + ((rect.left - this.dUc.left) * f);
            this.mDstRect.top = (this.dUc.top + ((rect.top - this.dUc.top) * f)) - i;
            this.mDstRect.right = this.dUc.right + ((rect.right - this.dUc.right) * f);
            this.mDstRect.bottom = this.dUc.bottom + ((rect.bottom - this.dUc.bottom) * f);
        }
    }

    private RectF getRectInScreenFromPosition(float f, float f2, float f3, float f4) {
        return new RectF(f - (f3 / 2.0f), f2 - (f4 / 2.0f), (f3 / 2.0f) + f, (f4 / 2.0f) + f2);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.dUs = onTouchListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVv() {
        if ((this.dTW || this.dTX) && this.dRk != null && this.dRk.mPicType == 1 && !TextUtils.isEmpty(this.dRk.mTagName)) {
            if (this.dTS != null) {
                this.dTS.setVisibility(8);
                this.dTS = null;
            }
            this.dTS = new TextView(this.mContext);
            this.dTS.setText(this.dRk.mTagName);
            this.dTS.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize26));
            am.setViewTextColor(this.dTS, R.color.common_color_10013, 1, 0);
            am.setBackgroundColor(this.dTS, R.color.common_color_10215);
            this.dTS.setAlpha(0.75f);
            this.dTS.setIncludeFontPadding(false);
            this.dTS.setGravity(17);
            int dimens = l.getDimens(this.mContext, R.dimen.ds2);
            this.dTS.setPadding(dimens, dimens, dimens, dimens);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.dTR.getBottomOffset();
            layoutParams.leftMargin = this.dTR.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.dTS, layoutParams);
            this.dTS.setVisibility(0);
        }
    }

    public void setUrl(String str, boolean z) {
        if (str.contains("*")) {
            str = str.split("[*]")[0];
        }
        this.dTR.setTag(str);
        this.dTR.setLoadBigImage(false);
        this.dTR.setImageDrawable(null);
        this.dTW = false;
        this.dTX = false;
        this.dUn = aVD();
        this.dUv = null;
        if (vX(str)) {
            e(str, z, false);
        }
    }

    private boolean aVw() {
        return this.dTR != null && this.dTR.isLoadBigImage();
    }

    public void aVx() {
        if (this.dRk != null && !aVw()) {
            String str = this.dRk.imageUrl;
            int i = this.dRk.urlType;
            com.baidu.adp.widget.ImageView.a aVar = null;
            if (com.baidu.tbadk.core.util.c.a.ah(str, i)) {
                aVar = com.baidu.tbadk.core.util.c.a.ai(str, i);
            }
            if (aVar != null) {
                setThumbBitmapToView(aVar);
            }
        }
    }

    private boolean hq(boolean z) {
        String nameMd5FromUrl;
        if (!this.dUo || z) {
            this.dUo = true;
            if (!this.dUn || this.dRk == null || StringUtils.isNull(this.dRk.originalUrl, true) || this.dRk.originalSize < 0 || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String str = this.dUh + ap.aOP().uM(nameMd5FromUrl) + "/" + as.getNameMd5FromUrl(this.dRk.originalUrl);
            final int[] imageFileWH = m.getImageFileWH(str);
            this.dTT.setVisibility(0);
            if (this.dTU == null) {
                this.dTU = new SubsamplingScaleImageView.OnImageEventListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12
                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onReady() {
                        UrlDragImageView.this.dUv = null;
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.dTR.restoreSize();
                        UrlDragImageView.this.dTR.setVisibility(4);
                    }

                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onImageLoaded() {
                        if (UrlDragImageView.this.dRk.isLongPic && imageFileWH[0] > 0) {
                            UrlDragImageView.this.dTR.onDestroy();
                            final float measuredWidth = (UrlDragImageView.this.getMeasuredWidth() * 1.0f) / imageFileWH[0];
                            final PointF pointF = new PointF((imageFileWH[0] * 1.0f) / 2.0f, 0.0f);
                            UrlDragImageView.this.dTT.setScaleAndCenter(measuredWidth, pointF);
                            UrlDragImageView.this.dTT.setMaxScale(2.0f * measuredWidth);
                            UrlDragImageView.this.dTT.setDoubleTapZoomScale(2.0f * measuredWidth);
                            UrlDragImageView.this.dTT.setInitScale(measuredWidth);
                            UrlDragImageView.this.dTT.setDoubleTapZoomStyle(4);
                            UrlDragImageView.this.dTT.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12.1
                                @Override // android.view.View.OnTouchListener
                                public boolean onTouch(View view, MotionEvent motionEvent) {
                                    if (UrlDragImageView.this.dUs != null) {
                                        UrlDragImageView.this.dUs.onTouch(view, motionEvent);
                                    }
                                    switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                                        case 0:
                                            UrlDragImageView.this.dUu = motionEvent.getY();
                                            UrlDragImageView.this.dTT.setOnClickListener(UrlDragImageView.this.dUt ? UrlDragImageView.this.mOnClickListener : null);
                                            UrlDragImageView.this.dTT.setOnLongClickListener(UrlDragImageView.this.dUt ? UrlDragImageView.this.mLongClickListener : null);
                                            break;
                                        case 1:
                                        case 3:
                                            if (UrlDragImageView.this.dTT.getScale() < measuredWidth) {
                                                UrlDragImageView.this.dTT.setScaleAndCenter(measuredWidth, pointF);
                                            }
                                            e.lb().removeCallbacks(UrlDragImageView.this.dUz);
                                            e.lb().postDelayed(UrlDragImageView.this.dUz, 1000L);
                                            break;
                                        case 2:
                                            if (Math.abs(motionEvent.getY() - UrlDragImageView.this.dUu) > UrlDragImageView.TOUCH_SLOP) {
                                                UrlDragImageView.this.dUt = false;
                                                UrlDragImageView.this.dTT.setOnClickListener(null);
                                                UrlDragImageView.this.dTT.setOnLongClickListener(null);
                                            }
                                            UrlDragImageView.this.dUu = motionEvent.getY();
                                            break;
                                    }
                                    return false;
                                }
                            });
                            UrlDragImageView.this.dTR.setVisibility(4);
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
            this.dTT.setOnImageEventListener(this.dTU);
            if (this.dTT.isImageLoaded() && this.dRk.isLongPic) {
                this.dTU.onImageLoaded();
            } else {
                this.dTT.setImage(ImageSource.uri(str));
            }
            return true;
        }
        return false;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.dUg = dVar;
        if (this.dTR != null) {
            this.dTR.setDragToExitListener(dVar);
        }
    }

    public void aVy() {
        hq(false);
    }

    private boolean vX(String str) {
        return j.isNetWorkAvailable() || com.baidu.tbadk.core.util.c.c.uY(str);
    }

    private void setThumbBitmapToView(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap rawBitmap;
        if (!this.dTX && aVar != null && (rawBitmap = aVar.getRawBitmap()) != null) {
            this.dTW = true;
            if (aVar.isGif()) {
                this.dTR.setImageUrlData(this.dRk);
                this.dTR.setImageBitmap(rawBitmap);
                this.dUv = null;
                this.dUq = false;
            } else {
                if (this.dRk != null && this.dRk.isLongPic) {
                    this.dTR.createLargeImageDelegate();
                    this.dTR.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.13
                        @Override // com.baidu.tbadk.widget.largeImage.logic.a
                        public void onLoadFinished() {
                        }
                    });
                }
                this.dTR.setImageUrlData(this.dRk);
                this.dTR.setImageData(rawBitmap, aVar.getByteData());
            }
            aVv();
        }
    }

    private void e(String str, boolean z, boolean z2) {
        if (vY(str)) {
            if (z2 || (!this.dTY && !this.dTX)) {
                if (!z2 || !hq(true)) {
                    this.dTY = true;
                    com.baidu.adp.lib.e.c.kV().a(str, 27, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.14
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.b
                        public void onCancelled(String str2) {
                            UrlDragImageView.this.dTY = false;
                            UrlDragImageView.this.dTR.setVisibility(0);
                            UrlDragImageView.this.mProgressBar.setVisibility(8);
                            UrlDragImageView.this.dUv = null;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            UrlDragImageView.this.dTY = false;
                            UrlDragImageView.this.dTX = true;
                            UrlDragImageView.this.b(aVar);
                        }
                    }, 0, 0, false, null, Boolean.valueOf(z), this.dTR.getImageData(), Boolean.valueOf(this.dSw));
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
        imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.aO(this.mMaxWidth, this.mMaxHeight));
        com.baidu.adp.widget.ImageView.a a2 = this.dUr.a(imageFileInfo, false);
        if (a2 != null) {
            this.dTX = true;
            this.mProgressBar.setVisibility(8);
            this.dUv = null;
            b(a2);
            return;
        }
        this.dUr.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.2
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.ImageView.a aVar, String str2, boolean z3) {
                UrlDragImageView.this.dTX = true;
                UrlDragImageView.this.mProgressBar.setVisibility(8);
                UrlDragImageView.this.dUv = null;
                UrlDragImageView.this.b(aVar);
            }
        }, false);
    }

    private boolean vY(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null && this.dTV != null) {
            this.dTV.k(aVar.getUrl(), aVar.getByteData());
        }
        if (aVar == null || aVar.getRawBitmap() == null) {
            aVz();
            return;
        }
        Bitmap rawBitmap = aVar.getRawBitmap();
        this.dTR.setLoadBigImage(true);
        if (aVar.isGif()) {
            this.dTR.setGifData(aVar.getByteData(), rawBitmap);
            this.dTR.invalidate();
            this.dTR.play();
            this.dUq = false;
            this.dUv = null;
            this.mProgressBar.setVisibility(8);
        } else {
            if (this.dRk != null && this.dRk.isLongPic) {
                this.dTR.createLargeImageDelegate();
                this.dTR.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.3
                    @Override // com.baidu.tbadk.widget.largeImage.logic.a
                    public void onLoadFinished() {
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.dUv = null;
                    }
                });
            } else {
                this.mProgressBar.setVisibility(8);
                this.dUv = null;
            }
            this.dTR.setImageUrlData(this.dRk);
            this.dTR.setImageData(rawBitmap, aVar.getByteData());
            aVE();
        }
        aVv();
    }

    private void aVz() {
        if (!this.dTW) {
            this.dTR.setDefaultBitmap();
        } else {
            this.dTX = false;
        }
        this.dUv = null;
        this.mProgressBar.setVisibility(8);
    }

    public void setGifMaxUseableMem(int i) {
        this.dTR.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.dTR != null) {
            this.dTR.onDestroy();
        }
        if (this.dTT != null) {
            this.dTT.recycle();
        }
        if (this.dUb != null) {
            this.dUb.recycle();
            this.dUb = null;
        }
        if (this.mProgressBar != null) {
            this.dUv = null;
            this.mProgressBar.setVisibility(8);
        }
        e.lb().removeCallbacks(this.dUz);
        com.baidu.tieba.view.c.deB().setColor(-1);
    }

    public void release() {
        if (this.dTR != null) {
            this.dTR.release();
        }
        if (this.mProgressBar != null) {
            this.dUv = null;
            this.mProgressBar.setVisibility(8);
        }
        this.dUv = null;
    }

    public void aVA() {
        if (this.dTR != null && this.dTR.getImageType() == 1) {
            this.dTR.stop();
        }
    }

    public void x(boolean z, boolean z2) {
        String str;
        if (this.dTR != null && (str = (String) this.dTR.getTag()) != null) {
            if (this.dTR.getImageType() == 1) {
                if (this.dTR.getGifCache() == null || !this.dTR.isLoadBigImage()) {
                    e(str, z, z2);
                }
            } else if (this.dTR.getImageType() == 2) {
                e(str, z, z2);
            } else if (aVB()) {
                e(str, z, z2);
            }
        }
    }

    private boolean aVB() {
        if (this.dTR.getImageBitmap() != null && this.dTR.isLoadBigImage()) {
            if (this.dRk == null || !this.dRk.isLongPic || this.dTR.hasLoadLongImage()) {
                return false;
            }
            this.dTX = false;
            this.dUo = false;
            return true;
        }
        return true;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.dRk = imageUrlData;
    }

    public ImageUrlData getmAssistUrlData() {
        return this.dRk;
    }

    public void setIsCdn(boolean z) {
        this.dSw = z;
    }

    public void aVC() {
        final String nameMd5FromUrl = as.getNameMd5FromUrl(this.dRk.originalUrl);
        if (this.dRk.originalProcess >= 0) {
            com.baidu.tbadk.download.d.aWJ().cancelDownLoadById(nameMd5FromUrl, 13);
            this.dRk.originalProcess = -1;
            aVE();
            return;
        }
        if (this.dSp != null) {
            this.dSp.aVH();
        }
        com.baidu.adp.base.e<?> G = i.G(this.mContext);
        if (G == null) {
            vZ(nameMd5FromUrl);
        } else if (!j.isNetWorkAvailable() || j.isWifiNet() || com.baidu.tbadk.core.sharedPref.b.aNT().getBoolean(SharedPrefConfig.ORIGINAL_IMG_DOWN_TIP, false)) {
            vZ(nameMd5FromUrl);
        } else {
            com.baidu.tbadk.core.sharedPref.b.aNT().putBoolean(SharedPrefConfig.ORIGINAL_IMG_DOWN_TIP, true);
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(G.getPageActivity());
            aVar.kd(R.string.original_img_down_no_wifi_tip);
            aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    UrlDragImageView.this.vZ(nameMd5FromUrl);
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                }
            });
            aVar.b(G);
            aVar.aMS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vZ(String str) {
        if (this.dRk != null) {
            this.dRk.originalProcess = 0;
            this.dUw.setProgress(0);
            this.dUw.setVisibility(0);
            DownloadData downloadData = new DownloadData(str);
            downloadData.setStatus(1);
            downloadData.setUrl(this.dRk.originalUrl);
            downloadData.setType(13);
            downloadData.setPath(this.dUh + ap.aOP().uM(str) + "/" + str);
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.6
                @Override // com.baidu.tbadk.download.c
                public boolean onPreDownload(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2 != null) {
                        if (UrlDragImageView.this.dRk != null && UrlDragImageView.this.dRk.originalProcess != -1) {
                            UrlDragImageView.this.dRk.originalProcess = downloadData2.getProcess();
                        }
                        if (UrlDragImageView.this.dRk == null || UrlDragImageView.this.dRk.originalProcess != -1) {
                            UrlDragImageView.this.dUw.setProgress(downloadData2.getProcess());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public boolean onFileDownloaded(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadSucceed(DownloadData downloadData2) {
                    UrlDragImageView.this.dUw.setVisibility(8);
                    e.lb().postDelayed(UrlDragImageView.this.dUA, 1500L);
                    UrlDragImageView.this.dUo = false;
                    UrlDragImageView.this.dUn = UrlDragImageView.this.aVD();
                    UrlDragImageView.this.aVy();
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str2) {
                    UrlDragImageView.this.dUw.setVisibility(8);
                    UrlDragImageView.this.dUo = false;
                    BdToast.b(UrlDragImageView.this.mContext, str2).aMW().aMX();
                    UrlDragImageView.this.dRk.originalProcess = -1;
                    UrlDragImageView.this.aVE();
                }
            });
            com.baidu.tbadk.download.d.aWJ().a(downloadData, 100);
            this.dUx = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aVD() {
        if (this.dRk != null && !StringUtils.isNull(this.dRk.originalUrl, true) && this.dRk.originalSize >= 0 && !this.dRk.isBlockedPic) {
            String nameMd5FromUrl = as.getNameMd5FromUrl(this.dRk.originalUrl);
            File file = new File(this.dUh + ap.aOP().uM(nameMd5FromUrl) + "/" + nameMd5FromUrl);
            if (file != null && file.exists()) {
                this.dRk.originalProcess = 100;
                return true;
            }
            if (this.dRk.originalProcess < 0) {
                aVE();
            } else {
                this.dUw.setProgress(this.dRk.originalProcess);
            }
            this.dUq = true;
        } else {
            this.dUv = null;
        }
        return false;
    }

    public void aVE() {
        if (this.dRk != null) {
            if (!aVF() || !this.dUq) {
                this.dUv = null;
            } else if (this.dRk.originalSize > 0 && !co(this.dRk.originalSize)) {
                this.dUv = dTP + "(" + aq.getFormatSize(this.dRk.originalSize) + ")";
            } else {
                this.dUv = dTP;
            }
        }
    }

    private boolean aVF() {
        return (this.dRk == null || !this.dRk.mIsShowOrigonButton || this.dRk.isBlockedPic || StringUtils.isNull(this.dRk.originalUrl)) ? false : true;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.dSp = bVar;
    }

    private boolean co(long j) {
        return j > dTQ;
    }
}
