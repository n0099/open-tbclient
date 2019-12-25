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
/* loaded from: classes5.dex */
public class UrlDragImageView extends RelativeLayout {
    private ImageUrlData dmk;
    private boolean dnA;
    private boolean dnC;
    private b dnt;
    protected DragImageView doX;
    protected TextView doY;
    protected SubsamplingScaleImageView doZ;
    private float dpA;
    private String dpB;
    private CircleProgressView dpC;
    private boolean dpD;
    private boolean dpE;
    private Runnable dpF;
    private Runnable dpG;
    private View.OnTouchListener dpH;
    private SubsamplingScaleImageView.OnImageEventListener dpa;
    private a dpb;
    private boolean dpc;
    private boolean dpd;
    private boolean dpe;
    private boolean dpf;
    private boolean dpg;
    private Bitmap dph;
    private RectF dpi;
    private Rect dpj;
    private Rect dpk;
    private Rect dpl;
    private DragImageView.d dpm;
    private String dpn;
    private float dpo;
    private float dpp;
    private float dpq;
    private float dpr;
    private float dps;
    private boolean dpt;
    private boolean dpu;
    private boolean dpv;
    public boolean dpw;
    private com.baidu.tbadk.img.b dpx;
    private View.OnTouchListener dpy;
    private boolean dpz;
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
    private static final String doV = TbadkCoreApplication.getInst().getString(R.string.original_img_look);
    private static long doW = Config.RAVEN_LOG_LIMIT;
    private static final int EXIT_DISTANCE = l.getEquipmentHeight(TbadkCoreApplication.getInst()) / 5;
    private static final String TAG = UrlDragImageView.class.getSimpleName();
    private static final int TOUCH_SLOP = ViewConfiguration.get(TbadkCoreApplication.getInst()).getScaledTouchSlop();

    /* loaded from: classes5.dex */
    public interface a {
        void k(String str, byte[] bArr);
    }

    /* loaded from: classes5.dex */
    public interface b {
        void aKq();
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
        if (this.doX != null) {
            this.doX.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.dpb = aVar;
    }

    public UrlDragImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.doX = null;
        this.dpb = null;
        this.dnA = false;
        this.dpe = false;
        this.isInDragScaleMode = false;
        this.mRatio = 1.0f;
        this.mMoveDistance = 0.0f;
        this.mDragMatrix = new Matrix();
        this.mDstRect = new RectF();
        this.dpo = 0.0f;
        this.dpp = 0.0f;
        this.dpq = 1.0f;
        this.dpr = 1.0f;
        this.dps = 0.0f;
        this.dpt = false;
        this.dpu = false;
        this.dpv = false;
        this.dpw = false;
        this.dpz = true;
        this.dpA = 0.0f;
        this.mOnClickListener = null;
        this.mLongClickListener = null;
        this.dpB = null;
        this.dpF = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.dpz = true;
            }
        };
        this.dpG = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.dpC.setVisibility(8);
                        UrlDragImageView.this.dpB = null;
                        UrlDragImageView.this.dpw = false;
                    }
                });
            }
        };
        this.dpH = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.dpy != null) {
                    UrlDragImageView.this.dpy.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.dpx = new com.baidu.tbadk.img.b();
        init();
    }

    public UrlDragImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.doX = null;
        this.dpb = null;
        this.dnA = false;
        this.dpe = false;
        this.isInDragScaleMode = false;
        this.mRatio = 1.0f;
        this.mMoveDistance = 0.0f;
        this.mDragMatrix = new Matrix();
        this.mDstRect = new RectF();
        this.dpo = 0.0f;
        this.dpp = 0.0f;
        this.dpq = 1.0f;
        this.dpr = 1.0f;
        this.dps = 0.0f;
        this.dpt = false;
        this.dpu = false;
        this.dpv = false;
        this.dpw = false;
        this.dpz = true;
        this.dpA = 0.0f;
        this.mOnClickListener = null;
        this.mLongClickListener = null;
        this.dpB = null;
        this.dpF = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.dpz = true;
            }
        };
        this.dpG = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.dpC.setVisibility(8);
                        UrlDragImageView.this.dpB = null;
                        UrlDragImageView.this.dpw = false;
                    }
                });
            }
        };
        this.dpH = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.dpy != null) {
                    UrlDragImageView.this.dpy.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.dpx = new com.baidu.tbadk.img.b();
        init();
    }

    public DragImageView getImageView() {
        return this.doX;
    }

    public void setGifSetListener(DragImageView.e eVar) {
        this.doX.setGifSetListener(eVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.doX.setImageOnClickListener(onClickListener);
        this.doZ.setOnClickListener(onClickListener);
        this.mOnClickListener = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mLongClickListener = onLongClickListener;
        if (!this.dnC) {
            this.doX.setImageOnLongClickListener(this.mLongClickListener);
            this.doZ.setOnLongClickListener(this.mLongClickListener);
        }
    }

    public void setOnSizeChangedListener(final DragImageView.g gVar) {
        this.doX.setOnSizeChangedListener(new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.8
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (gVar != null) {
                    gVar.a(dragImageView, z, z2);
                }
                UrlDragImageView.this.aKe();
            }
        });
    }

    protected void init() {
        this.dpn = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        this.mMaxWidth = l.getEquipmentWidth(this.mContext);
        this.mMaxHeight = l.getEquipmentHeight(this.mContext) - ((int) this.mContext.getResources().getDimension(R.dimen.ds166));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.doX = new DragImageView(this.mContext);
        this.doX.setLayoutParams(layoutParams);
        this.doX.setOnTouchListener(this.dpH);
        addView(this.doX);
        this.doZ = new SubsamplingScaleImageView(this.mContext);
        this.doZ.setMaxScale(50.0f);
        this.doZ.setOnTouchListener(this.dpH);
        this.doZ.setVisibility(4);
        addView(this.doZ, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(getResources().getDrawable(R.drawable.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        aKd();
        this.dpE = TbSingleton.getInstance().isCutoutScreen(TbadkApplication.getInst().getCurrentActivity());
    }

    private void aKd() {
        this.dpC = new CircleProgressView(this.mContext);
        this.dpC.setCircleBackgroundColor(am.getColor(R.color.cp_cont_d));
        this.dpC.setCircleForegroundColor(am.getColor(R.color.cp_link_tip_a));
        this.dpC.setProgress(0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds80), l.getDimens(getContext(), R.dimen.tbds80));
        layoutParams.addRule(13);
        this.dpC.setVisibility(8);
        addView(this.dpC, layoutParams);
    }

    public void setIsCanDrag(boolean z) {
        this.dnC = z;
    }

    public String getmCheckOriginPicText() {
        return this.dpB;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        Bitmap imageBitmap;
        int height;
        int width;
        if (this.dpt && !this.dpD && this.doZ.getVisibility() == 0 && !this.doZ.isImageLoaded()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.dnC || !this.dpd) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.dpf && motionEvent.getPointerCount() >= 2) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.dpf || this.dpg) {
            requestDisallowInterceptTouchEvent(true);
        }
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        float x = motionEvent.getX();
        int i = action & 255;
        if (i == 0) {
            if (this.dph == null) {
                if (this.doZ.getVisibility() == 0) {
                    this.dph = g.be(this.doZ);
                } else {
                    this.dph = g.be(this.doX);
                }
            }
            if (this.mDisplayRect == null && this.dph != null) {
                int measuredWidth = getMeasuredWidth();
                float measuredWidth2 = ((getMeasuredWidth() * 1.0f) / this.dph.getWidth()) * this.dph.getHeight();
                if (measuredWidth2 > getMeasuredHeight()) {
                    measuredWidth2 = getMeasuredHeight();
                }
                RectF rectInScreenFromPosition = getRectInScreenFromPosition(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
                this.mDisplayRect = new Rect((int) rectInScreenFromPosition.left, (int) rectInScreenFromPosition.top, (int) rectInScreenFromPosition.right, (int) rectInScreenFromPosition.bottom);
            }
            if (this.dpk == null && this.dph != null) {
                if (this.doZ.getVisibility() == 0) {
                    height = this.doZ.getSHeight();
                    width = this.doZ.getSWidth();
                } else {
                    if (this.doX.getImageType() == 1) {
                        imageBitmap = (this.doX.getCurrentFrame() == null || this.doX.getCurrentFrame().bm == null) ? this.dph : this.doX.getCurrentFrame().bm;
                    } else {
                        imageBitmap = this.doX.getImageBitmap() == null ? this.dph : this.doX.getImageBitmap();
                    }
                    height = imageBitmap.getHeight();
                    width = imageBitmap.getWidth();
                }
                float equipmentDensity = l.getEquipmentDensity(getContext());
                int i2 = (int) (height * equipmentDensity);
                int i3 = (int) (width * equipmentDensity);
                if (i3 > this.dph.getWidth() && this.dph.getWidth() != 0) {
                    float width2 = (i3 * 1.0f) / this.dph.getWidth();
                    i3 = this.dph.getWidth();
                    i2 = (int) (i2 / width2);
                }
                if (i2 > this.dph.getHeight() && this.dph.getHeight() != 0) {
                    i3 = (int) (i3 / ((i2 * 1.0f) / this.dph.getHeight()));
                    i2 = this.dph.getHeight();
                }
                int equipmentHeight = (l.getEquipmentHeight(getContext()) - i2) / 2;
                int equipmentWidth = (l.getEquipmentWidth(getContext()) - i3) / 2;
                this.dpk = new Rect(equipmentWidth, equipmentHeight, i3 + equipmentWidth, i2 + equipmentHeight);
                this.dpl = new Rect(this.dpk);
                this.dps = equipmentHeight / l.getEquipmentHeight(getContext());
                this.dpj = new Rect(0, 0, this.dph.getWidth(), this.dph.getHeight());
            }
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (i == 2) {
            this.dpf = s(this.mLastMotionX - x, this.mLastMotionY - y);
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (this.dpf || this.dpg) {
            this.doX.setImageOnLongClickListener(null);
            this.doZ.setOnLongClickListener(null);
            z = true;
        } else {
            this.doX.setImageOnLongClickListener(this.mLongClickListener);
            this.doZ.setOnLongClickListener(this.mLongClickListener);
            z = super.dispatchTouchEvent(motionEvent);
        }
        if (i == 1 || i == 3) {
            this.mLastMotionX = 0.0f;
            this.mLastMotionY = 0.0f;
            boolean z2 = (-this.mMoveDistance) > ((float) EXIT_DISTANCE);
            boolean z3 = this.mMoveDistance > ((float) EXIT_DISTANCE);
            if (z2 || z3) {
                this.dpg = true;
                startExitAnimation();
                if (z2) {
                    TiebaStatic.log(new an("c13377").cp("obj_type", "3"));
                } else if (z3) {
                    TiebaStatic.log(new an("c13377").cp("obj_type", "2"));
                }
            } else {
                if (this.dpf && this.dpm != null) {
                    this.dpm.aPT();
                }
                this.mRatio = 1.0f;
                invalidate();
            }
            this.isInDragScaleMode = false;
            this.mDragMatrix.reset();
            this.dpf = false;
        }
        return z;
    }

    private boolean s(float f, float f2) {
        if (this.doZ.getVisibility() != 0 || this.doZ.isCanDrag()) {
            if (this.dmk == null || !this.dmk.isLongPic || this.doZ.getVisibility() != 0 || this.doZ.isViewTop()) {
                if (this.dmk == null || !this.dmk.isLongPic || this.doZ.getVisibility() == 0 || this.doX.isAtViewTop() || this.doX.aPR()) {
                    if (this.doZ.getVisibility() == 0 || this.doX.pagerCantScroll()) {
                        if (this.dph != null && getScrollY() == 0) {
                            boolean z = (this.dmk == null || !this.dmk.isLongPic) && ((f2 < -15.0f && !this.isInDragScaleMode) || (f2 > 15.0f && !this.isInDragScaleMode));
                            boolean z2 = this.dmk != null && this.dmk.isLongPic && f2 < 0.0f && !this.isInDragScaleMode;
                            if (z || (z2 && this.doX.isViewTop())) {
                                this.doX.setImageOnLongClickListener(null);
                                this.doZ.setOnLongClickListener(null);
                                this.isInDragScaleMode = true;
                                this.mMoveDistance = 0.0f;
                                this.mRatio = 1.0f;
                                if (this.dpm != null) {
                                    this.dpm.onDragStart();
                                }
                            }
                        }
                        if (!this.isInDragScaleMode || this.dph == null) {
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
                        this.mDragMatrix.preScale(1.0f + f3, 1.0f + f3, (this.mRatio * this.dph.getWidth()) / 2.0f, this.mRatio * (this.dph.getHeight() / 2));
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
        if (this.dpf && this.dph != null && !this.dph.isRecycled() && this.isInDragScaleMode) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.mDstRect == null) {
                this.mDstRect = new RectF();
            }
            this.mDragMatrix.mapRect(this.mDstRect, new RectF(this.mDisplayRect));
            canvas.drawBitmap(this.dph, this.dpj, this.mDstRect, (Paint) null);
        } else if (this.dpg && this.dph != null && !this.dph.isRecycled()) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.dmk == null || this.dmk.getSourceImageRectInScreen() == null) {
                canvas.drawBitmap(this.dph, this.dpj, this.mDstRect, (Paint) null);
            } else {
                canvas.drawBitmap(this.dph, this.dpk, this.mDstRect, (Paint) null);
            }
        } else {
            super.dispatchDraw(canvas);
        }
    }

    private void startExitAnimation() {
        if (this.dmk == null) {
            if (this.dpm != null) {
                this.dpm.onDragEnd();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.dmk.getSourceImageRectInScreen();
        final Rect dstRectInScreen = this.dmk.getDstRectInScreen();
        if (sourceImageRectInScreen == null || dstRectInScreen == null) {
            if (this.dpm != null) {
                this.dpm.onDragEnd();
                return;
            }
            return;
        }
        a(sourceImageRectInScreen, dstRectInScreen);
        b(sourceImageRectInScreen);
        this.dpi = new RectF(this.mDstRect);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(150L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && sourceImageRectInScreen != null && dstRectInScreen != null) {
                    UrlDragImageView.this.as(valueAnimator.getAnimatedFraction());
                    UrlDragImageView.this.a(dstRectInScreen, valueAnimator.getAnimatedFraction(), UrlDragImageView.this.dpE);
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
                if (UrlDragImageView.this.dpm != null) {
                    UrlDragImageView.this.dpm.onDragEnd();
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
            this.mDstRect.top += this.mDstRect.height() * this.dps;
            this.mDstRect.bottom = f + this.mDstRect.top;
        }
    }

    public void setCanScale(boolean z) {
        if (this.doX != null) {
            this.doX.setCanScale(z);
        }
    }

    private void a(Rect rect, Rect rect2) {
        this.dpo = 0.0f;
        this.dpp = 0.0f;
        this.dpq = 1.0f;
        this.dpr = 1.0f;
        if (rect != null && rect2 != null && rect.contains(rect2)) {
            this.dpo = (rect2.left - rect.left) / rect.width();
            this.dpp = (rect2.top - rect.top) / rect.height();
            this.dpq = (rect2.right - rect.left) / rect.width();
            this.dpr = (rect2.bottom - rect.top) / rect.height();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void as(float f) {
        if (this.dpk != null) {
            this.dpk.left = (int) (this.dpl.left + (this.dpl.width() * this.dpo * f));
            this.dpk.top = (int) (this.dpl.top + (this.dpl.height() * this.dpp * f));
            this.dpk.right = (int) (this.dpl.left + (this.dpl.width() * (((1.0f - this.dpq) * (1.0f - f)) + this.dpq)));
            this.dpk.bottom = (int) (this.dpl.top + (this.dpl.height() * (((1.0f - this.dpr) * (1.0f - f)) + this.dpr)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Rect rect, float f, boolean z) {
        int i = 0;
        if (z) {
            i = l.getDimens(getContext(), R.dimen.tbds80);
        }
        if (this.mDstRect != null && rect != null) {
            this.mDstRect.left = this.dpi.left + ((rect.left - this.dpi.left) * f);
            this.mDstRect.top = (this.dpi.top + ((rect.top - this.dpi.top) * f)) - i;
            this.mDstRect.right = this.dpi.right + ((rect.right - this.dpi.right) * f);
            this.mDstRect.bottom = this.dpi.bottom + ((rect.bottom - this.dpi.bottom) * f);
        }
    }

    private RectF getRectInScreenFromPosition(float f, float f2, float f3, float f4) {
        return new RectF(f - (f3 / 2.0f), f2 - (f4 / 2.0f), (f3 / 2.0f) + f, (f4 / 2.0f) + f2);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.dpy = onTouchListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKe() {
        if ((this.dpc || this.dpd) && this.dmk != null && this.dmk.mPicType == 1 && !TextUtils.isEmpty(this.dmk.mTagName)) {
            if (this.doY != null) {
                this.doY.setVisibility(8);
                this.doY = null;
            }
            this.doY = new TextView(this.mContext);
            this.doY.setText(this.dmk.mTagName);
            this.doY.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize26));
            am.setViewTextColor(this.doY, R.color.common_color_10013, 1, 0);
            am.setBackgroundColor(this.doY, R.color.common_color_10215);
            this.doY.setAlpha(0.75f);
            this.doY.setIncludeFontPadding(false);
            this.doY.setGravity(17);
            int dimens = l.getDimens(this.mContext, R.dimen.ds2);
            this.doY.setPadding(dimens, dimens, dimens, dimens);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.doX.getBottomOffset();
            layoutParams.leftMargin = this.doX.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.doY, layoutParams);
            this.doY.setVisibility(0);
        }
    }

    public void setUrl(String str, boolean z) {
        if (str.contains("*")) {
            str = str.split("[*]")[0];
        }
        this.doX.setTag(str);
        this.doX.setLoadBigImage(false);
        this.doX.setImageDrawable(null);
        this.dpc = false;
        this.dpd = false;
        this.dpt = aKm();
        this.dpB = null;
        if (uj(str)) {
            e(str, z, false);
        }
    }

    private boolean aKf() {
        return this.doX != null && this.doX.isLoadBigImage();
    }

    public void aKg() {
        if (this.dmk != null && !aKf()) {
            String str = this.dmk.imageUrl;
            int i = this.dmk.urlType;
            com.baidu.adp.widget.ImageView.a aVar = null;
            if (com.baidu.tbadk.core.util.d.a.aa(str, i)) {
                aVar = com.baidu.tbadk.core.util.d.a.ab(str, i);
            }
            if (aVar != null) {
                setThumbBitmapToView(aVar);
            }
        }
    }

    private boolean gf(boolean z) {
        String nameMd5FromUrl;
        if (!this.dpu || z) {
            this.dpu = true;
            if (!this.dpt || this.dmk == null || StringUtils.isNull(this.dmk.originalUrl, true) || this.dmk.originalSize < 0 || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String str = this.dpn + ap.aDU().tc(nameMd5FromUrl) + "/" + as.getNameMd5FromUrl(this.dmk.originalUrl);
            final int[] imageFileWH = m.getImageFileWH(str);
            this.doZ.setVisibility(0);
            if (this.dpa == null) {
                this.dpa = new SubsamplingScaleImageView.OnImageEventListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12
                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onReady() {
                        UrlDragImageView.this.dpB = null;
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.doX.restoreSize();
                        UrlDragImageView.this.doX.setVisibility(4);
                    }

                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onImageLoaded() {
                        if (UrlDragImageView.this.dmk.isLongPic && imageFileWH[0] > 0) {
                            UrlDragImageView.this.doX.onDestroy();
                            final float measuredWidth = (UrlDragImageView.this.getMeasuredWidth() * 1.0f) / imageFileWH[0];
                            final PointF pointF = new PointF((imageFileWH[0] * 1.0f) / 2.0f, 0.0f);
                            UrlDragImageView.this.doZ.setScaleAndCenter(measuredWidth, pointF);
                            UrlDragImageView.this.doZ.setMaxScale(2.0f * measuredWidth);
                            UrlDragImageView.this.doZ.setDoubleTapZoomScale(2.0f * measuredWidth);
                            UrlDragImageView.this.doZ.setInitScale(measuredWidth);
                            UrlDragImageView.this.doZ.setDoubleTapZoomStyle(4);
                            UrlDragImageView.this.doZ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12.1
                                @Override // android.view.View.OnTouchListener
                                public boolean onTouch(View view, MotionEvent motionEvent) {
                                    if (UrlDragImageView.this.dpy != null) {
                                        UrlDragImageView.this.dpy.onTouch(view, motionEvent);
                                    }
                                    switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                                        case 0:
                                            UrlDragImageView.this.dpA = motionEvent.getY();
                                            UrlDragImageView.this.doZ.setOnClickListener(UrlDragImageView.this.dpz ? UrlDragImageView.this.mOnClickListener : null);
                                            UrlDragImageView.this.doZ.setOnLongClickListener(UrlDragImageView.this.dpz ? UrlDragImageView.this.mLongClickListener : null);
                                            break;
                                        case 1:
                                        case 3:
                                            if (UrlDragImageView.this.doZ.getScale() < measuredWidth) {
                                                UrlDragImageView.this.doZ.setScaleAndCenter(measuredWidth, pointF);
                                            }
                                            e.gy().removeCallbacks(UrlDragImageView.this.dpF);
                                            e.gy().postDelayed(UrlDragImageView.this.dpF, 1000L);
                                            break;
                                        case 2:
                                            if (Math.abs(motionEvent.getY() - UrlDragImageView.this.dpA) > UrlDragImageView.TOUCH_SLOP) {
                                                UrlDragImageView.this.dpz = false;
                                                UrlDragImageView.this.doZ.setOnClickListener(null);
                                                UrlDragImageView.this.doZ.setOnLongClickListener(null);
                                            }
                                            UrlDragImageView.this.dpA = motionEvent.getY();
                                            break;
                                    }
                                    return false;
                                }
                            });
                            UrlDragImageView.this.doX.setVisibility(4);
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
            this.doZ.setOnImageEventListener(this.dpa);
            if (this.doZ.isImageLoaded() && this.dmk.isLongPic) {
                this.dpa.onImageLoaded();
            } else {
                this.doZ.setImage(ImageSource.uri(str));
            }
            return true;
        }
        return false;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.dpm = dVar;
        if (this.doX != null) {
            this.doX.setDragToExitListener(dVar);
        }
    }

    public void aKh() {
        gf(false);
    }

    private boolean uj(String str) {
        return j.isNetWorkAvailable() || com.baidu.tbadk.core.util.d.c.tn(str);
    }

    private void setThumbBitmapToView(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap rawBitmap;
        if (!this.dpd && aVar != null && (rawBitmap = aVar.getRawBitmap()) != null) {
            this.dpc = true;
            if (aVar.isGif()) {
                this.doX.setImageUrlData(this.dmk);
                this.doX.setImageBitmap(rawBitmap);
                this.dpB = null;
                this.dpw = false;
            } else {
                if (this.dmk != null && this.dmk.isLongPic) {
                    this.doX.createLargeImageDelegate();
                    this.doX.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.13
                        @Override // com.baidu.tbadk.widget.largeImage.logic.a
                        public void onLoadFinished() {
                        }
                    });
                }
                this.doX.setImageUrlData(this.dmk);
                this.doX.setImageData(rawBitmap, aVar.getByteData());
            }
            aKe();
        }
    }

    private void e(String str, boolean z, boolean z2) {
        if (uk(str)) {
            if (z2 || (!this.dpe && !this.dpd)) {
                if (!z2 || !gf(true)) {
                    this.dpe = true;
                    com.baidu.adp.lib.e.c.gs().a(str, 27, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.14
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.b
                        public void onCancelled(String str2) {
                            UrlDragImageView.this.dpe = false;
                            UrlDragImageView.this.doX.setVisibility(0);
                            UrlDragImageView.this.mProgressBar.setVisibility(8);
                            UrlDragImageView.this.dpB = null;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            UrlDragImageView.this.dpe = false;
                            UrlDragImageView.this.dpd = true;
                            UrlDragImageView.this.b(aVar);
                        }
                    }, 0, 0, false, null, Boolean.valueOf(z), this.doX.getImageData(), Boolean.valueOf(this.dnA));
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
        imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.aF(this.mMaxWidth, this.mMaxHeight));
        com.baidu.adp.widget.ImageView.a a2 = this.dpx.a(imageFileInfo, false);
        if (a2 != null) {
            this.dpd = true;
            this.mProgressBar.setVisibility(8);
            this.dpB = null;
            b(a2);
            return;
        }
        this.dpx.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.2
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.ImageView.a aVar, String str2, boolean z3) {
                UrlDragImageView.this.dpd = true;
                UrlDragImageView.this.mProgressBar.setVisibility(8);
                UrlDragImageView.this.dpB = null;
                UrlDragImageView.this.b(aVar);
            }
        }, false);
    }

    private boolean uk(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null && this.dpb != null) {
            this.dpb.k(aVar.getUrl(), aVar.getByteData());
        }
        if (aVar == null || aVar.getRawBitmap() == null) {
            aKi();
            return;
        }
        Bitmap rawBitmap = aVar.getRawBitmap();
        this.doX.setLoadBigImage(true);
        if (aVar.isGif()) {
            this.doX.setGifData(aVar.getByteData(), rawBitmap);
            this.doX.invalidate();
            this.doX.play();
            this.dpw = false;
            this.dpB = null;
            this.mProgressBar.setVisibility(8);
        } else {
            if (this.dmk != null && this.dmk.isLongPic) {
                this.doX.createLargeImageDelegate();
                this.doX.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.3
                    @Override // com.baidu.tbadk.widget.largeImage.logic.a
                    public void onLoadFinished() {
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.dpB = null;
                    }
                });
            } else {
                this.mProgressBar.setVisibility(8);
                this.dpB = null;
            }
            this.doX.setImageUrlData(this.dmk);
            this.doX.setImageData(rawBitmap, aVar.getByteData());
            aKn();
        }
        aKe();
    }

    private void aKi() {
        if (!this.dpc) {
            this.doX.setDefaultBitmap();
        } else {
            this.dpd = false;
        }
        this.dpB = null;
        this.mProgressBar.setVisibility(8);
    }

    public void setGifMaxUseableMem(int i) {
        this.doX.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.doX != null) {
            this.doX.onDestroy();
        }
        if (this.doZ != null) {
            this.doZ.recycle();
        }
        if (this.dph != null) {
            this.dph.recycle();
            this.dph = null;
        }
        if (this.mProgressBar != null) {
            this.dpB = null;
            this.mProgressBar.setVisibility(8);
        }
        e.gy().removeCallbacks(this.dpF);
        com.baidu.tieba.view.c.cQS().setColor(-1);
    }

    public void release() {
        if (this.doX != null) {
            this.doX.release();
        }
        if (this.mProgressBar != null) {
            this.dpB = null;
            this.mProgressBar.setVisibility(8);
        }
        this.dpB = null;
    }

    public void aKj() {
        if (this.doX != null && this.doX.getImageType() == 1) {
            this.doX.stop();
        }
    }

    public void v(boolean z, boolean z2) {
        String str;
        if (this.doX != null && (str = (String) this.doX.getTag()) != null) {
            if (this.doX.getImageType() == 1) {
                if (this.doX.getGifCache() == null || !this.doX.isLoadBigImage()) {
                    e(str, z, z2);
                }
            } else if (this.doX.getImageType() == 2) {
                e(str, z, z2);
            } else if (aKk()) {
                e(str, z, z2);
            }
        }
    }

    private boolean aKk() {
        if (this.doX.getImageBitmap() != null && this.doX.isLoadBigImage()) {
            if (this.dmk == null || !this.dmk.isLongPic || this.doX.hasLoadLongImage()) {
                return false;
            }
            this.dpd = false;
            this.dpu = false;
            return true;
        }
        return true;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.dmk = imageUrlData;
    }

    public ImageUrlData getmAssistUrlData() {
        return this.dmk;
    }

    public void setIsCdn(boolean z) {
        this.dnA = z;
    }

    public void aKl() {
        final String nameMd5FromUrl = as.getNameMd5FromUrl(this.dmk.originalUrl);
        if (this.dmk.originalProcess >= 0) {
            com.baidu.tbadk.download.d.aLy().cancelDownLoadById(nameMd5FromUrl, 13);
            this.dmk.originalProcess = -1;
            aKn();
            return;
        }
        if (this.dnt != null) {
            this.dnt.aKq();
        }
        com.baidu.adp.base.e<?> ab = i.ab(this.mContext);
        if (ab == null) {
            ul(nameMd5FromUrl);
        } else if (!j.isNetWorkAvailable() || j.isWifiNet() || com.baidu.tbadk.core.sharedPref.b.aCY().getBoolean(SharedPrefConfig.ORIGINAL_IMG_DOWN_TIP, false)) {
            ul(nameMd5FromUrl);
        } else {
            com.baidu.tbadk.core.sharedPref.b.aCY().putBoolean(SharedPrefConfig.ORIGINAL_IMG_DOWN_TIP, true);
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(ab.getPageActivity());
            aVar.jF(R.string.original_img_down_no_wifi_tip);
            aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    UrlDragImageView.this.ul(nameMd5FromUrl);
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                }
            });
            aVar.b(ab);
            aVar.aBW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ul(String str) {
        if (this.dmk != null) {
            this.dmk.originalProcess = 0;
            this.dpC.setProgress(0);
            this.dpC.setVisibility(0);
            DownloadData downloadData = new DownloadData(str);
            downloadData.setStatus(1);
            downloadData.setUrl(this.dmk.originalUrl);
            downloadData.setType(13);
            downloadData.setPath(this.dpn + ap.aDU().tc(str) + "/" + str);
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.6
                @Override // com.baidu.tbadk.download.c
                public boolean onPreDownload(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2 != null) {
                        if (UrlDragImageView.this.dmk != null && UrlDragImageView.this.dmk.originalProcess != -1) {
                            UrlDragImageView.this.dmk.originalProcess = downloadData2.getProcess();
                        }
                        if (UrlDragImageView.this.dmk == null || UrlDragImageView.this.dmk.originalProcess != -1) {
                            UrlDragImageView.this.dpC.setProgress(downloadData2.getProcess());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public boolean onFileDownloaded(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadSucceed(DownloadData downloadData2) {
                    UrlDragImageView.this.dpC.setVisibility(8);
                    e.gy().postDelayed(UrlDragImageView.this.dpG, 1500L);
                    UrlDragImageView.this.dpu = false;
                    UrlDragImageView.this.dpt = UrlDragImageView.this.aKm();
                    UrlDragImageView.this.aKh();
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str2) {
                    UrlDragImageView.this.dpC.setVisibility(8);
                    UrlDragImageView.this.dpu = false;
                    BdToast.b(UrlDragImageView.this.mContext, str2).aCa().aCb();
                    UrlDragImageView.this.dmk.originalProcess = -1;
                    UrlDragImageView.this.aKn();
                }
            });
            com.baidu.tbadk.download.d.aLy().a(downloadData, 100);
            this.dpD = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aKm() {
        if (this.dmk != null && !StringUtils.isNull(this.dmk.originalUrl, true) && this.dmk.originalSize >= 0 && !this.dmk.isBlockedPic) {
            String nameMd5FromUrl = as.getNameMd5FromUrl(this.dmk.originalUrl);
            File file = new File(this.dpn + ap.aDU().tc(nameMd5FromUrl) + "/" + nameMd5FromUrl);
            if (file != null && file.exists()) {
                this.dmk.originalProcess = 100;
                return true;
            }
            if (this.dmk.originalProcess < 0) {
                aKn();
            } else {
                this.dpC.setProgress(this.dmk.originalProcess);
            }
            this.dpw = true;
        } else {
            this.dpB = null;
        }
        return false;
    }

    public void aKn() {
        if (this.dmk != null) {
            if (!aKo() || !this.dpw) {
                this.dpB = null;
            } else if (this.dmk.originalSize > 0 && !bA(this.dmk.originalSize)) {
                this.dpB = doV + "(" + aq.getFormatSize(this.dmk.originalSize) + ")";
            } else {
                this.dpB = doV;
            }
        }
    }

    private boolean aKo() {
        return (this.dmk == null || !this.dmk.mIsShowOrigonButton || this.dmk.isBlockedPic || StringUtils.isNull(this.dmk.originalUrl)) ? false : true;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.dnt = bVar;
    }

    private boolean bA(long j) {
        return j > doW;
    }
}
