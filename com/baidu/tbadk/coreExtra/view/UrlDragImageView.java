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
/* loaded from: classes6.dex */
public class UrlDragImageView extends RelativeLayout {
    private ImageUrlData dmy;
    private b dnE;
    private boolean dnL;
    private boolean dnN;
    private float dpA;
    private float dpB;
    private float dpC;
    private float dpD;
    private boolean dpE;
    private boolean dpF;
    private boolean dpG;
    public boolean dpH;
    private com.baidu.tbadk.img.b dpI;
    private View.OnTouchListener dpJ;
    private boolean dpK;
    private float dpL;
    private String dpM;
    private CircleProgressView dpN;
    private boolean dpO;
    private boolean dpP;
    private Runnable dpQ;
    private Runnable dpR;
    private View.OnTouchListener dpS;
    protected DragImageView dpi;
    protected TextView dpj;
    protected SubsamplingScaleImageView dpk;
    private SubsamplingScaleImageView.OnImageEventListener dpl;
    private a dpm;
    private boolean dpn;
    private boolean dpo;
    private boolean dpp;
    private boolean dpq;
    private boolean dpr;
    private Bitmap dps;
    private RectF dpt;
    private Rect dpu;
    private Rect dpv;
    private Rect dpw;
    private DragImageView.d dpx;
    private String dpy;
    private float dpz;
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
    private static final String dpg = TbadkCoreApplication.getInst().getString(R.string.original_img_look);
    private static long dph = Config.RAVEN_LOG_LIMIT;
    private static final int EXIT_DISTANCE = l.getEquipmentHeight(TbadkCoreApplication.getInst()) / 5;
    private static final String TAG = UrlDragImageView.class.getSimpleName();
    private static final int TOUCH_SLOP = ViewConfiguration.get(TbadkCoreApplication.getInst()).getScaledTouchSlop();

    /* loaded from: classes6.dex */
    public interface a {
        void k(String str, byte[] bArr);
    }

    /* loaded from: classes6.dex */
    public interface b {
        void aKJ();
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
        if (this.dpi != null) {
            this.dpi.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.dpm = aVar;
    }

    public UrlDragImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.dpi = null;
        this.dpm = null;
        this.dnL = false;
        this.dpp = false;
        this.isInDragScaleMode = false;
        this.mRatio = 1.0f;
        this.mMoveDistance = 0.0f;
        this.mDragMatrix = new Matrix();
        this.mDstRect = new RectF();
        this.dpz = 0.0f;
        this.dpA = 0.0f;
        this.dpB = 1.0f;
        this.dpC = 1.0f;
        this.dpD = 0.0f;
        this.dpE = false;
        this.dpF = false;
        this.dpG = false;
        this.dpH = false;
        this.dpK = true;
        this.dpL = 0.0f;
        this.mOnClickListener = null;
        this.mLongClickListener = null;
        this.dpM = null;
        this.dpQ = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.dpK = true;
            }
        };
        this.dpR = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.dpN.setVisibility(8);
                        UrlDragImageView.this.dpM = null;
                        UrlDragImageView.this.dpH = false;
                    }
                });
            }
        };
        this.dpS = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.dpJ != null) {
                    UrlDragImageView.this.dpJ.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.dpI = new com.baidu.tbadk.img.b();
        init();
    }

    public UrlDragImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.dpi = null;
        this.dpm = null;
        this.dnL = false;
        this.dpp = false;
        this.isInDragScaleMode = false;
        this.mRatio = 1.0f;
        this.mMoveDistance = 0.0f;
        this.mDragMatrix = new Matrix();
        this.mDstRect = new RectF();
        this.dpz = 0.0f;
        this.dpA = 0.0f;
        this.dpB = 1.0f;
        this.dpC = 1.0f;
        this.dpD = 0.0f;
        this.dpE = false;
        this.dpF = false;
        this.dpG = false;
        this.dpH = false;
        this.dpK = true;
        this.dpL = 0.0f;
        this.mOnClickListener = null;
        this.mLongClickListener = null;
        this.dpM = null;
        this.dpQ = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.dpK = true;
            }
        };
        this.dpR = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.dpN.setVisibility(8);
                        UrlDragImageView.this.dpM = null;
                        UrlDragImageView.this.dpH = false;
                    }
                });
            }
        };
        this.dpS = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.dpJ != null) {
                    UrlDragImageView.this.dpJ.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.dpI = new com.baidu.tbadk.img.b();
        init();
    }

    public DragImageView getImageView() {
        return this.dpi;
    }

    public void setGifSetListener(DragImageView.e eVar) {
        this.dpi.setGifSetListener(eVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.dpi.setImageOnClickListener(onClickListener);
        this.dpk.setOnClickListener(onClickListener);
        this.mOnClickListener = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mLongClickListener = onLongClickListener;
        if (!this.dnN) {
            this.dpi.setImageOnLongClickListener(this.mLongClickListener);
            this.dpk.setOnLongClickListener(this.mLongClickListener);
        }
    }

    public void setOnSizeChangedListener(final DragImageView.g gVar) {
        this.dpi.setOnSizeChangedListener(new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.8
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (gVar != null) {
                    gVar.a(dragImageView, z, z2);
                }
                UrlDragImageView.this.aKx();
            }
        });
    }

    protected void init() {
        this.dpy = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        this.mMaxWidth = l.getEquipmentWidth(this.mContext);
        this.mMaxHeight = l.getEquipmentHeight(this.mContext) - ((int) this.mContext.getResources().getDimension(R.dimen.ds166));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.dpi = new DragImageView(this.mContext);
        this.dpi.setLayoutParams(layoutParams);
        this.dpi.setOnTouchListener(this.dpS);
        addView(this.dpi);
        this.dpk = new SubsamplingScaleImageView(this.mContext);
        this.dpk.setMaxScale(50.0f);
        this.dpk.setOnTouchListener(this.dpS);
        this.dpk.setVisibility(4);
        addView(this.dpk, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(getResources().getDrawable(R.drawable.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        aKw();
        this.dpP = TbSingleton.getInstance().isCutoutScreen(TbadkApplication.getInst().getCurrentActivity());
    }

    private void aKw() {
        this.dpN = new CircleProgressView(this.mContext);
        this.dpN.setCircleBackgroundColor(am.getColor(R.color.cp_cont_d));
        this.dpN.setCircleForegroundColor(am.getColor(R.color.cp_link_tip_a));
        this.dpN.setProgress(0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds80), l.getDimens(getContext(), R.dimen.tbds80));
        layoutParams.addRule(13);
        this.dpN.setVisibility(8);
        addView(this.dpN, layoutParams);
    }

    public void setIsCanDrag(boolean z) {
        this.dnN = z;
    }

    public String getmCheckOriginPicText() {
        return this.dpM;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        Bitmap imageBitmap;
        int height;
        int width;
        if (this.dpE && !this.dpO && this.dpk.getVisibility() == 0 && !this.dpk.isImageLoaded()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.dnN || !this.dpo) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.dpq && motionEvent.getPointerCount() >= 2) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.dpq || this.dpr) {
            requestDisallowInterceptTouchEvent(true);
        }
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        float x = motionEvent.getX();
        int i = action & 255;
        if (i == 0) {
            if (this.dps == null) {
                if (this.dpk.getVisibility() == 0) {
                    this.dps = g.bi(this.dpk);
                } else {
                    this.dps = g.bi(this.dpi);
                }
            }
            if (this.mDisplayRect == null && this.dps != null) {
                int measuredWidth = getMeasuredWidth();
                float measuredWidth2 = ((getMeasuredWidth() * 1.0f) / this.dps.getWidth()) * this.dps.getHeight();
                if (measuredWidth2 > getMeasuredHeight()) {
                    measuredWidth2 = getMeasuredHeight();
                }
                RectF rectInScreenFromPosition = getRectInScreenFromPosition(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
                this.mDisplayRect = new Rect((int) rectInScreenFromPosition.left, (int) rectInScreenFromPosition.top, (int) rectInScreenFromPosition.right, (int) rectInScreenFromPosition.bottom);
            }
            if (this.dpv == null && this.dps != null) {
                if (this.dpk.getVisibility() == 0) {
                    height = this.dpk.getSHeight();
                    width = this.dpk.getSWidth();
                } else {
                    if (this.dpi.getImageType() == 1) {
                        imageBitmap = (this.dpi.getCurrentFrame() == null || this.dpi.getCurrentFrame().bm == null) ? this.dps : this.dpi.getCurrentFrame().bm;
                    } else {
                        imageBitmap = this.dpi.getImageBitmap() == null ? this.dps : this.dpi.getImageBitmap();
                    }
                    height = imageBitmap.getHeight();
                    width = imageBitmap.getWidth();
                }
                float equipmentDensity = l.getEquipmentDensity(getContext());
                int i2 = (int) (height * equipmentDensity);
                int i3 = (int) (width * equipmentDensity);
                if (i3 > this.dps.getWidth() && this.dps.getWidth() != 0) {
                    float width2 = (i3 * 1.0f) / this.dps.getWidth();
                    i3 = this.dps.getWidth();
                    i2 = (int) (i2 / width2);
                }
                if (i2 > this.dps.getHeight() && this.dps.getHeight() != 0) {
                    i3 = (int) (i3 / ((i2 * 1.0f) / this.dps.getHeight()));
                    i2 = this.dps.getHeight();
                }
                int equipmentHeight = (l.getEquipmentHeight(getContext()) - i2) / 2;
                int equipmentWidth = (l.getEquipmentWidth(getContext()) - i3) / 2;
                this.dpv = new Rect(equipmentWidth, equipmentHeight, i3 + equipmentWidth, i2 + equipmentHeight);
                this.dpw = new Rect(this.dpv);
                this.dpD = equipmentHeight / l.getEquipmentHeight(getContext());
                this.dpu = new Rect(0, 0, this.dps.getWidth(), this.dps.getHeight());
            }
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (i == 2) {
            this.dpq = s(this.mLastMotionX - x, this.mLastMotionY - y);
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (this.dpq || this.dpr) {
            this.dpi.setImageOnLongClickListener(null);
            this.dpk.setOnLongClickListener(null);
            z = true;
        } else {
            this.dpi.setImageOnLongClickListener(this.mLongClickListener);
            this.dpk.setOnLongClickListener(this.mLongClickListener);
            z = super.dispatchTouchEvent(motionEvent);
        }
        if (i == 1 || i == 3) {
            this.mLastMotionX = 0.0f;
            this.mLastMotionY = 0.0f;
            boolean z2 = (-this.mMoveDistance) > ((float) EXIT_DISTANCE);
            boolean z3 = this.mMoveDistance > ((float) EXIT_DISTANCE);
            if (z2 || z3) {
                this.dpr = true;
                startExitAnimation();
                if (z2) {
                    TiebaStatic.log(new an("c13377").cp("obj_type", "3"));
                } else if (z3) {
                    TiebaStatic.log(new an("c13377").cp("obj_type", "2"));
                }
            } else {
                if (this.dpq && this.dpx != null) {
                    this.dpx.aQm();
                }
                this.mRatio = 1.0f;
                invalidate();
            }
            this.isInDragScaleMode = false;
            this.mDragMatrix.reset();
            this.dpq = false;
        }
        return z;
    }

    private boolean s(float f, float f2) {
        if (this.dpk.getVisibility() != 0 || this.dpk.isCanDrag()) {
            if (this.dmy == null || !this.dmy.isLongPic || this.dpk.getVisibility() != 0 || this.dpk.isViewTop()) {
                if (this.dmy == null || !this.dmy.isLongPic || this.dpk.getVisibility() == 0 || this.dpi.isAtViewTop() || this.dpi.aQk()) {
                    if (this.dpk.getVisibility() == 0 || this.dpi.pagerCantScroll()) {
                        if (this.dps != null && getScrollY() == 0) {
                            boolean z = (this.dmy == null || !this.dmy.isLongPic) && ((f2 < -15.0f && !this.isInDragScaleMode) || (f2 > 15.0f && !this.isInDragScaleMode));
                            boolean z2 = this.dmy != null && this.dmy.isLongPic && f2 < 0.0f && !this.isInDragScaleMode;
                            if (z || (z2 && this.dpi.isViewTop())) {
                                this.dpi.setImageOnLongClickListener(null);
                                this.dpk.setOnLongClickListener(null);
                                this.isInDragScaleMode = true;
                                this.mMoveDistance = 0.0f;
                                this.mRatio = 1.0f;
                                if (this.dpx != null) {
                                    this.dpx.onDragStart();
                                }
                            }
                        }
                        if (!this.isInDragScaleMode || this.dps == null) {
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
                        this.mDragMatrix.preScale(1.0f + f3, 1.0f + f3, (this.mRatio * this.dps.getWidth()) / 2.0f, this.mRatio * (this.dps.getHeight() / 2));
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
        if (this.dpq && this.dps != null && !this.dps.isRecycled() && this.isInDragScaleMode) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.mDstRect == null) {
                this.mDstRect = new RectF();
            }
            this.mDragMatrix.mapRect(this.mDstRect, new RectF(this.mDisplayRect));
            canvas.drawBitmap(this.dps, this.dpu, this.mDstRect, (Paint) null);
        } else if (this.dpr && this.dps != null && !this.dps.isRecycled()) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.dmy == null || this.dmy.getSourceImageRectInScreen() == null) {
                canvas.drawBitmap(this.dps, this.dpu, this.mDstRect, (Paint) null);
            } else {
                canvas.drawBitmap(this.dps, this.dpv, this.mDstRect, (Paint) null);
            }
        } else {
            super.dispatchDraw(canvas);
        }
    }

    private void startExitAnimation() {
        if (this.dmy == null) {
            if (this.dpx != null) {
                this.dpx.onDragEnd();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.dmy.getSourceImageRectInScreen();
        final Rect dstRectInScreen = this.dmy.getDstRectInScreen();
        if (sourceImageRectInScreen == null || dstRectInScreen == null) {
            if (this.dpx != null) {
                this.dpx.onDragEnd();
                return;
            }
            return;
        }
        a(sourceImageRectInScreen, dstRectInScreen);
        b(sourceImageRectInScreen);
        this.dpt = new RectF(this.mDstRect);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(150L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && sourceImageRectInScreen != null && dstRectInScreen != null) {
                    UrlDragImageView.this.ar(valueAnimator.getAnimatedFraction());
                    UrlDragImageView.this.a(dstRectInScreen, valueAnimator.getAnimatedFraction(), UrlDragImageView.this.dpP);
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
                if (UrlDragImageView.this.dpx != null) {
                    UrlDragImageView.this.dpx.onDragEnd();
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
            this.mDstRect.top += this.mDstRect.height() * this.dpD;
            this.mDstRect.bottom = f + this.mDstRect.top;
        }
    }

    public void setCanScale(boolean z) {
        if (this.dpi != null) {
            this.dpi.setCanScale(z);
        }
    }

    private void a(Rect rect, Rect rect2) {
        this.dpz = 0.0f;
        this.dpA = 0.0f;
        this.dpB = 1.0f;
        this.dpC = 1.0f;
        if (rect != null && rect2 != null && rect.contains(rect2)) {
            this.dpz = (rect2.left - rect.left) / rect.width();
            this.dpA = (rect2.top - rect.top) / rect.height();
            this.dpB = (rect2.right - rect.left) / rect.width();
            this.dpC = (rect2.bottom - rect.top) / rect.height();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ar(float f) {
        if (this.dpv != null) {
            this.dpv.left = (int) (this.dpw.left + (this.dpw.width() * this.dpz * f));
            this.dpv.top = (int) (this.dpw.top + (this.dpw.height() * this.dpA * f));
            this.dpv.right = (int) (this.dpw.left + (this.dpw.width() * (((1.0f - this.dpB) * (1.0f - f)) + this.dpB)));
            this.dpv.bottom = (int) (this.dpw.top + (this.dpw.height() * (((1.0f - this.dpC) * (1.0f - f)) + this.dpC)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Rect rect, float f, boolean z) {
        int i = 0;
        if (z) {
            i = l.getDimens(getContext(), R.dimen.tbds80);
        }
        if (this.mDstRect != null && rect != null) {
            this.mDstRect.left = this.dpt.left + ((rect.left - this.dpt.left) * f);
            this.mDstRect.top = (this.dpt.top + ((rect.top - this.dpt.top) * f)) - i;
            this.mDstRect.right = this.dpt.right + ((rect.right - this.dpt.right) * f);
            this.mDstRect.bottom = this.dpt.bottom + ((rect.bottom - this.dpt.bottom) * f);
        }
    }

    private RectF getRectInScreenFromPosition(float f, float f2, float f3, float f4) {
        return new RectF(f - (f3 / 2.0f), f2 - (f4 / 2.0f), (f3 / 2.0f) + f, (f4 / 2.0f) + f2);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.dpJ = onTouchListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKx() {
        if ((this.dpn || this.dpo) && this.dmy != null && this.dmy.mPicType == 1 && !TextUtils.isEmpty(this.dmy.mTagName)) {
            if (this.dpj != null) {
                this.dpj.setVisibility(8);
                this.dpj = null;
            }
            this.dpj = new TextView(this.mContext);
            this.dpj.setText(this.dmy.mTagName);
            this.dpj.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize26));
            am.setViewTextColor(this.dpj, R.color.common_color_10013, 1, 0);
            am.setBackgroundColor(this.dpj, R.color.common_color_10215);
            this.dpj.setAlpha(0.75f);
            this.dpj.setIncludeFontPadding(false);
            this.dpj.setGravity(17);
            int dimens = l.getDimens(this.mContext, R.dimen.ds2);
            this.dpj.setPadding(dimens, dimens, dimens, dimens);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.dpi.getBottomOffset();
            layoutParams.leftMargin = this.dpi.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.dpj, layoutParams);
            this.dpj.setVisibility(0);
        }
    }

    public void setUrl(String str, boolean z) {
        if (str.contains("*")) {
            str = str.split("[*]")[0];
        }
        this.dpi.setTag(str);
        this.dpi.setLoadBigImage(false);
        this.dpi.setImageDrawable(null);
        this.dpn = false;
        this.dpo = false;
        this.dpE = aKF();
        this.dpM = null;
        if (uo(str)) {
            e(str, z, false);
        }
    }

    private boolean aKy() {
        return this.dpi != null && this.dpi.isLoadBigImage();
    }

    public void aKz() {
        if (this.dmy != null && !aKy()) {
            String str = this.dmy.imageUrl;
            int i = this.dmy.urlType;
            com.baidu.adp.widget.ImageView.a aVar = null;
            if (com.baidu.tbadk.core.util.d.a.ab(str, i)) {
                aVar = com.baidu.tbadk.core.util.d.a.ac(str, i);
            }
            if (aVar != null) {
                setThumbBitmapToView(aVar);
            }
        }
    }

    private boolean gk(boolean z) {
        String nameMd5FromUrl;
        if (!this.dpF || z) {
            this.dpF = true;
            if (!this.dpE || this.dmy == null || StringUtils.isNull(this.dmy.originalUrl, true) || this.dmy.originalSize < 0 || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String str = this.dpy + ap.aEn().tg(nameMd5FromUrl) + "/" + as.getNameMd5FromUrl(this.dmy.originalUrl);
            final int[] imageFileWH = m.getImageFileWH(str);
            this.dpk.setVisibility(0);
            if (this.dpl == null) {
                this.dpl = new SubsamplingScaleImageView.OnImageEventListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12
                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onReady() {
                        UrlDragImageView.this.dpM = null;
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.dpi.restoreSize();
                        UrlDragImageView.this.dpi.setVisibility(4);
                    }

                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onImageLoaded() {
                        if (UrlDragImageView.this.dmy.isLongPic && imageFileWH[0] > 0) {
                            UrlDragImageView.this.dpi.onDestroy();
                            final float measuredWidth = (UrlDragImageView.this.getMeasuredWidth() * 1.0f) / imageFileWH[0];
                            final PointF pointF = new PointF((imageFileWH[0] * 1.0f) / 2.0f, 0.0f);
                            UrlDragImageView.this.dpk.setScaleAndCenter(measuredWidth, pointF);
                            UrlDragImageView.this.dpk.setMaxScale(2.0f * measuredWidth);
                            UrlDragImageView.this.dpk.setDoubleTapZoomScale(2.0f * measuredWidth);
                            UrlDragImageView.this.dpk.setInitScale(measuredWidth);
                            UrlDragImageView.this.dpk.setDoubleTapZoomStyle(4);
                            UrlDragImageView.this.dpk.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12.1
                                @Override // android.view.View.OnTouchListener
                                public boolean onTouch(View view, MotionEvent motionEvent) {
                                    if (UrlDragImageView.this.dpJ != null) {
                                        UrlDragImageView.this.dpJ.onTouch(view, motionEvent);
                                    }
                                    switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                                        case 0:
                                            UrlDragImageView.this.dpL = motionEvent.getY();
                                            UrlDragImageView.this.dpk.setOnClickListener(UrlDragImageView.this.dpK ? UrlDragImageView.this.mOnClickListener : null);
                                            UrlDragImageView.this.dpk.setOnLongClickListener(UrlDragImageView.this.dpK ? UrlDragImageView.this.mLongClickListener : null);
                                            break;
                                        case 1:
                                        case 3:
                                            if (UrlDragImageView.this.dpk.getScale() < measuredWidth) {
                                                UrlDragImageView.this.dpk.setScaleAndCenter(measuredWidth, pointF);
                                            }
                                            e.gx().removeCallbacks(UrlDragImageView.this.dpQ);
                                            e.gx().postDelayed(UrlDragImageView.this.dpQ, 1000L);
                                            break;
                                        case 2:
                                            if (Math.abs(motionEvent.getY() - UrlDragImageView.this.dpL) > UrlDragImageView.TOUCH_SLOP) {
                                                UrlDragImageView.this.dpK = false;
                                                UrlDragImageView.this.dpk.setOnClickListener(null);
                                                UrlDragImageView.this.dpk.setOnLongClickListener(null);
                                            }
                                            UrlDragImageView.this.dpL = motionEvent.getY();
                                            break;
                                    }
                                    return false;
                                }
                            });
                            UrlDragImageView.this.dpi.setVisibility(4);
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
            this.dpk.setOnImageEventListener(this.dpl);
            if (this.dpk.isImageLoaded() && this.dmy.isLongPic) {
                this.dpl.onImageLoaded();
            } else {
                this.dpk.setImage(ImageSource.uri(str));
            }
            return true;
        }
        return false;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.dpx = dVar;
        if (this.dpi != null) {
            this.dpi.setDragToExitListener(dVar);
        }
    }

    public void aKA() {
        gk(false);
    }

    private boolean uo(String str) {
        return j.isNetWorkAvailable() || com.baidu.tbadk.core.util.d.c.tr(str);
    }

    private void setThumbBitmapToView(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap rawBitmap;
        if (!this.dpo && aVar != null && (rawBitmap = aVar.getRawBitmap()) != null) {
            this.dpn = true;
            if (aVar.isGif()) {
                this.dpi.setImageUrlData(this.dmy);
                this.dpi.setImageBitmap(rawBitmap);
                this.dpM = null;
                this.dpH = false;
            } else {
                if (this.dmy != null && this.dmy.isLongPic) {
                    this.dpi.createLargeImageDelegate();
                    this.dpi.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.13
                        @Override // com.baidu.tbadk.widget.largeImage.logic.a
                        public void onLoadFinished() {
                        }
                    });
                }
                this.dpi.setImageUrlData(this.dmy);
                this.dpi.setImageData(rawBitmap, aVar.getByteData());
            }
            aKx();
        }
    }

    private void e(String str, boolean z, boolean z2) {
        if (up(str)) {
            if (z2 || (!this.dpp && !this.dpo)) {
                if (!z2 || !gk(true)) {
                    this.dpp = true;
                    com.baidu.adp.lib.e.c.gr().a(str, 27, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.14
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.b
                        public void onCancelled(String str2) {
                            UrlDragImageView.this.dpp = false;
                            UrlDragImageView.this.dpi.setVisibility(0);
                            UrlDragImageView.this.mProgressBar.setVisibility(8);
                            UrlDragImageView.this.dpM = null;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            UrlDragImageView.this.dpp = false;
                            UrlDragImageView.this.dpo = true;
                            UrlDragImageView.this.b(aVar);
                        }
                    }, 0, 0, false, null, Boolean.valueOf(z), this.dpi.getImageData(), Boolean.valueOf(this.dnL));
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
        imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.aJ(this.mMaxWidth, this.mMaxHeight));
        com.baidu.adp.widget.ImageView.a a2 = this.dpI.a(imageFileInfo, false);
        if (a2 != null) {
            this.dpo = true;
            this.mProgressBar.setVisibility(8);
            this.dpM = null;
            b(a2);
            return;
        }
        this.dpI.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.2
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.ImageView.a aVar, String str2, boolean z3) {
                UrlDragImageView.this.dpo = true;
                UrlDragImageView.this.mProgressBar.setVisibility(8);
                UrlDragImageView.this.dpM = null;
                UrlDragImageView.this.b(aVar);
            }
        }, false);
    }

    private boolean up(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null && this.dpm != null) {
            this.dpm.k(aVar.getUrl(), aVar.getByteData());
        }
        if (aVar == null || aVar.getRawBitmap() == null) {
            aKB();
            return;
        }
        Bitmap rawBitmap = aVar.getRawBitmap();
        this.dpi.setLoadBigImage(true);
        if (aVar.isGif()) {
            this.dpi.setGifData(aVar.getByteData(), rawBitmap);
            this.dpi.invalidate();
            this.dpi.play();
            this.dpH = false;
            this.dpM = null;
            this.mProgressBar.setVisibility(8);
        } else {
            if (this.dmy != null && this.dmy.isLongPic) {
                this.dpi.createLargeImageDelegate();
                this.dpi.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.3
                    @Override // com.baidu.tbadk.widget.largeImage.logic.a
                    public void onLoadFinished() {
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.dpM = null;
                    }
                });
            } else {
                this.mProgressBar.setVisibility(8);
                this.dpM = null;
            }
            this.dpi.setImageUrlData(this.dmy);
            this.dpi.setImageData(rawBitmap, aVar.getByteData());
            aKG();
        }
        aKx();
    }

    private void aKB() {
        if (!this.dpn) {
            this.dpi.setDefaultBitmap();
        } else {
            this.dpo = false;
        }
        this.dpM = null;
        this.mProgressBar.setVisibility(8);
    }

    public void setGifMaxUseableMem(int i) {
        this.dpi.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.dpi != null) {
            this.dpi.onDestroy();
        }
        if (this.dpk != null) {
            this.dpk.recycle();
        }
        if (this.dps != null) {
            this.dps.recycle();
            this.dps = null;
        }
        if (this.mProgressBar != null) {
            this.dpM = null;
            this.mProgressBar.setVisibility(8);
        }
        e.gx().removeCallbacks(this.dpQ);
        com.baidu.tieba.view.c.cRV().setColor(-1);
    }

    public void release() {
        if (this.dpi != null) {
            this.dpi.release();
        }
        if (this.mProgressBar != null) {
            this.dpM = null;
            this.mProgressBar.setVisibility(8);
        }
        this.dpM = null;
    }

    public void aKC() {
        if (this.dpi != null && this.dpi.getImageType() == 1) {
            this.dpi.stop();
        }
    }

    public void u(boolean z, boolean z2) {
        String str;
        if (this.dpi != null && (str = (String) this.dpi.getTag()) != null) {
            if (this.dpi.getImageType() == 1) {
                if (this.dpi.getGifCache() == null || !this.dpi.isLoadBigImage()) {
                    e(str, z, z2);
                }
            } else if (this.dpi.getImageType() == 2) {
                e(str, z, z2);
            } else if (aKD()) {
                e(str, z, z2);
            }
        }
    }

    private boolean aKD() {
        if (this.dpi.getImageBitmap() != null && this.dpi.isLoadBigImage()) {
            if (this.dmy == null || !this.dmy.isLongPic || this.dpi.hasLoadLongImage()) {
                return false;
            }
            this.dpo = false;
            this.dpF = false;
            return true;
        }
        return true;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.dmy = imageUrlData;
    }

    public ImageUrlData getmAssistUrlData() {
        return this.dmy;
    }

    public void setIsCdn(boolean z) {
        this.dnL = z;
    }

    public void aKE() {
        final String nameMd5FromUrl = as.getNameMd5FromUrl(this.dmy.originalUrl);
        if (this.dmy.originalProcess >= 0) {
            com.baidu.tbadk.download.d.aLR().cancelDownLoadById(nameMd5FromUrl, 13);
            this.dmy.originalProcess = -1;
            aKG();
            return;
        }
        if (this.dnE != null) {
            this.dnE.aKJ();
        }
        com.baidu.adp.base.e<?> ab = i.ab(this.mContext);
        if (ab == null) {
            uq(nameMd5FromUrl);
        } else if (!j.isNetWorkAvailable() || j.isWifiNet() || com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean(SharedPrefConfig.ORIGINAL_IMG_DOWN_TIP, false)) {
            uq(nameMd5FromUrl);
        } else {
            com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean(SharedPrefConfig.ORIGINAL_IMG_DOWN_TIP, true);
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(ab.getPageActivity());
            aVar.jF(R.string.original_img_down_no_wifi_tip);
            aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    UrlDragImageView.this.uq(nameMd5FromUrl);
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                }
            });
            aVar.b(ab);
            aVar.aCp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uq(String str) {
        if (this.dmy != null) {
            this.dmy.originalProcess = 0;
            this.dpN.setProgress(0);
            this.dpN.setVisibility(0);
            DownloadData downloadData = new DownloadData(str);
            downloadData.setStatus(1);
            downloadData.setUrl(this.dmy.originalUrl);
            downloadData.setType(13);
            downloadData.setPath(this.dpy + ap.aEn().tg(str) + "/" + str);
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.6
                @Override // com.baidu.tbadk.download.c
                public boolean onPreDownload(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2 != null) {
                        if (UrlDragImageView.this.dmy != null && UrlDragImageView.this.dmy.originalProcess != -1) {
                            UrlDragImageView.this.dmy.originalProcess = downloadData2.getProcess();
                        }
                        if (UrlDragImageView.this.dmy == null || UrlDragImageView.this.dmy.originalProcess != -1) {
                            UrlDragImageView.this.dpN.setProgress(downloadData2.getProcess());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public boolean onFileDownloaded(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadSucceed(DownloadData downloadData2) {
                    UrlDragImageView.this.dpN.setVisibility(8);
                    e.gx().postDelayed(UrlDragImageView.this.dpR, 1500L);
                    UrlDragImageView.this.dpF = false;
                    UrlDragImageView.this.dpE = UrlDragImageView.this.aKF();
                    UrlDragImageView.this.aKA();
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str2) {
                    UrlDragImageView.this.dpN.setVisibility(8);
                    UrlDragImageView.this.dpF = false;
                    BdToast.b(UrlDragImageView.this.mContext, str2).aCt().aCu();
                    UrlDragImageView.this.dmy.originalProcess = -1;
                    UrlDragImageView.this.aKG();
                }
            });
            com.baidu.tbadk.download.d.aLR().a(downloadData, 100);
            this.dpO = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aKF() {
        if (this.dmy != null && !StringUtils.isNull(this.dmy.originalUrl, true) && this.dmy.originalSize >= 0 && !this.dmy.isBlockedPic) {
            String nameMd5FromUrl = as.getNameMd5FromUrl(this.dmy.originalUrl);
            File file = new File(this.dpy + ap.aEn().tg(nameMd5FromUrl) + "/" + nameMd5FromUrl);
            if (file != null && file.exists()) {
                this.dmy.originalProcess = 100;
                return true;
            }
            if (this.dmy.originalProcess < 0) {
                aKG();
            } else {
                this.dpN.setProgress(this.dmy.originalProcess);
            }
            this.dpH = true;
        } else {
            this.dpM = null;
        }
        return false;
    }

    public void aKG() {
        if (this.dmy != null) {
            if (!aKH() || !this.dpH) {
                this.dpM = null;
            } else if (this.dmy.originalSize > 0 && !bD(this.dmy.originalSize)) {
                this.dpM = dpg + "(" + aq.getFormatSize(this.dmy.originalSize) + ")";
            } else {
                this.dpM = dpg;
            }
        }
    }

    private boolean aKH() {
        return (this.dmy == null || !this.dmy.mIsShowOrigonButton || this.dmy.isBlockedPic || StringUtils.isNull(this.dmy.originalUrl)) ? false : true;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.dnE = bVar;
    }

    private boolean bD(long j) {
        return j > dph;
    }
}
