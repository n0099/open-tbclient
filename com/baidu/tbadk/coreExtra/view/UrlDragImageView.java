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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.effect.d;
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.File;
/* loaded from: classes21.dex */
public class UrlDragImageView extends RelativeLayout {
    private ImageUrlData fbR;
    private b fcO;
    private boolean fcV;
    private boolean fcX;
    private boolean feA;
    private Bitmap feB;
    private RectF feC;
    private Rect feD;
    private Rect feE;
    private Rect feF;
    private DragImageView.d feG;
    private String feH;
    private float feI;
    private float feJ;
    private float feK;
    private float feL;
    private float feM;
    private boolean feN;
    private boolean feO;
    private boolean feP;
    public boolean feQ;
    private com.baidu.tbadk.img.b feR;
    private View.OnTouchListener feS;
    private boolean feT;
    private float feU;
    private String feV;
    private CircleProgressView feW;
    private boolean feX;
    private boolean feY;
    private Runnable feZ;
    protected DragImageView fer;
    protected TextView fes;
    protected SubsamplingScaleImageView fet;
    private SubsamplingScaleImageView.OnImageEventListener feu;
    private a fev;
    private boolean few;
    private boolean fex;
    private boolean fey;
    private boolean fez;
    private Runnable ffa;
    private View.OnTouchListener ffb;
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
    private static final String fep = TbadkCoreApplication.getInst().getString(R.string.original_img_look);
    private static long feq = Config.RAVEN_LOG_LIMIT;
    private static final int EXIT_DISTANCE = l.getEquipmentHeight(TbadkCoreApplication.getInst()) / 5;
    private static final String TAG = UrlDragImageView.class.getSimpleName();
    private static final int TOUCH_SLOP = ViewConfiguration.get(TbadkCoreApplication.getInst()).getScaledTouchSlop();

    /* loaded from: classes21.dex */
    public interface a {
        void k(String str, byte[] bArr);
    }

    /* loaded from: classes21.dex */
    public interface b {
        void bvM();
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
        if (this.fer != null) {
            this.fer.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.fev = aVar;
    }

    public UrlDragImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.fer = null;
        this.fev = null;
        this.fcV = false;
        this.fey = false;
        this.isInDragScaleMode = false;
        this.mRatio = 1.0f;
        this.mMoveDistance = 0.0f;
        this.mDragMatrix = new Matrix();
        this.mDstRect = new RectF();
        this.feI = 0.0f;
        this.feJ = 0.0f;
        this.feK = 1.0f;
        this.feL = 1.0f;
        this.feM = 0.0f;
        this.feN = false;
        this.feO = false;
        this.feP = false;
        this.feQ = false;
        this.feT = true;
        this.feU = 0.0f;
        this.mOnClickListener = null;
        this.mLongClickListener = null;
        this.feV = null;
        this.feZ = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.feT = true;
            }
        };
        this.ffa = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.feW.setVisibility(8);
                        UrlDragImageView.this.feV = null;
                        UrlDragImageView.this.feQ = false;
                    }
                });
            }
        };
        this.ffb = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.feS != null) {
                    UrlDragImageView.this.feS.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.feR = new com.baidu.tbadk.img.b();
        init();
    }

    public UrlDragImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.fer = null;
        this.fev = null;
        this.fcV = false;
        this.fey = false;
        this.isInDragScaleMode = false;
        this.mRatio = 1.0f;
        this.mMoveDistance = 0.0f;
        this.mDragMatrix = new Matrix();
        this.mDstRect = new RectF();
        this.feI = 0.0f;
        this.feJ = 0.0f;
        this.feK = 1.0f;
        this.feL = 1.0f;
        this.feM = 0.0f;
        this.feN = false;
        this.feO = false;
        this.feP = false;
        this.feQ = false;
        this.feT = true;
        this.feU = 0.0f;
        this.mOnClickListener = null;
        this.mLongClickListener = null;
        this.feV = null;
        this.feZ = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.feT = true;
            }
        };
        this.ffa = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.feW.setVisibility(8);
                        UrlDragImageView.this.feV = null;
                        UrlDragImageView.this.feQ = false;
                    }
                });
            }
        };
        this.ffb = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.feS != null) {
                    UrlDragImageView.this.feS.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.feR = new com.baidu.tbadk.img.b();
        init();
    }

    public DragImageView getImageView() {
        return this.fer;
    }

    public void setGifSetListener(DragImageView.e eVar) {
        this.fer.setGifSetListener(eVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.fer.setImageOnClickListener(onClickListener);
        this.fet.setOnClickListener(onClickListener);
        this.mOnClickListener = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mLongClickListener = onLongClickListener;
        if (!this.fcX) {
            this.fer.setImageOnLongClickListener(this.mLongClickListener);
            this.fet.setOnLongClickListener(this.mLongClickListener);
        }
    }

    public void setOnSizeChangedListener(final DragImageView.g gVar) {
        this.fer.setOnSizeChangedListener(new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.8
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (gVar != null) {
                    gVar.a(dragImageView, z, z2);
                }
                UrlDragImageView.this.bvA();
            }
        });
    }

    protected void init() {
        this.feH = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        this.mMaxWidth = l.getEquipmentWidth(this.mContext);
        this.mMaxHeight = l.getEquipmentHeight(this.mContext) - ((int) this.mContext.getResources().getDimension(R.dimen.ds166));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.fer = new DragImageView(this.mContext);
        this.fer.setLayoutParams(layoutParams);
        this.fer.setOnTouchListener(this.ffb);
        addView(this.fer);
        this.fet = new SubsamplingScaleImageView(this.mContext);
        this.fet.setMaxScale(50.0f);
        this.fet.setOnTouchListener(this.ffb);
        this.fet.setVisibility(4);
        addView(this.fet, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(getResources().getDrawable(R.drawable.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        bvz();
        this.feY = TbSingleton.getInstance().isCutoutScreen(TbadkApplication.getInst().getCurrentActivity());
    }

    private void bvz() {
        this.feW = new CircleProgressView(this.mContext);
        this.feW.setCircleBackgroundColor(ap.getColor(R.color.cp_cont_d));
        this.feW.setCircleForegroundColor(ap.getColor(R.color.cp_link_tip_a));
        this.feW.setProgress(0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds80), l.getDimens(getContext(), R.dimen.tbds80));
        layoutParams.addRule(13);
        this.feW.setVisibility(8);
        addView(this.feW, layoutParams);
    }

    public void setIsCanDrag(boolean z) {
        this.fcX = z;
    }

    public String getmCheckOriginPicText() {
        return this.feV;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        Bitmap imageBitmap;
        int height;
        int width;
        if (this.feN && !this.feX && this.fet.getVisibility() == 0 && !this.fet.isImageLoaded()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.fcX || !this.fex) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.fez && motionEvent.getPointerCount() >= 2) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.fez || this.feA) {
            requestDisallowInterceptTouchEvent(true);
        }
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        float x = motionEvent.getX();
        int i = action & 255;
        if (i == 0) {
            if (this.feB == null) {
                if (this.fet.getVisibility() == 0) {
                    this.feB = h.bC(this.fet);
                } else {
                    this.feB = h.bC(this.fer);
                }
            }
            if (this.mDisplayRect == null && this.feB != null) {
                int measuredWidth = getMeasuredWidth();
                float measuredWidth2 = ((getMeasuredWidth() * 1.0f) / this.feB.getWidth()) * this.feB.getHeight();
                if (measuredWidth2 > getMeasuredHeight()) {
                    measuredWidth2 = getMeasuredHeight();
                }
                RectF rectInScreenFromPosition = getRectInScreenFromPosition(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
                this.mDisplayRect = new Rect((int) rectInScreenFromPosition.left, (int) rectInScreenFromPosition.top, (int) rectInScreenFromPosition.right, (int) rectInScreenFromPosition.bottom);
            }
            if (this.feE == null && this.feB != null) {
                if (this.fet.getVisibility() == 0) {
                    height = this.fet.getSHeight();
                    width = this.fet.getSWidth();
                } else {
                    if (this.fer.getImageType() == 1) {
                        imageBitmap = (this.fer.getCurrentFrame() == null || this.fer.getCurrentFrame().bm == null) ? this.feB : this.fer.getCurrentFrame().bm;
                    } else {
                        imageBitmap = this.fer.getImageBitmap() == null ? this.feB : this.fer.getImageBitmap();
                    }
                    height = imageBitmap.getHeight();
                    width = imageBitmap.getWidth();
                }
                float equipmentDensity = l.getEquipmentDensity(getContext());
                int i2 = (int) (height * equipmentDensity);
                int i3 = (int) (width * equipmentDensity);
                if (i3 > this.feB.getWidth() && this.feB.getWidth() != 0) {
                    float width2 = (i3 * 1.0f) / this.feB.getWidth();
                    i3 = this.feB.getWidth();
                    i2 = (int) (i2 / width2);
                }
                if (i2 > this.feB.getHeight() && this.feB.getHeight() != 0) {
                    i3 = (int) (i3 / ((i2 * 1.0f) / this.feB.getHeight()));
                    i2 = this.feB.getHeight();
                }
                int equipmentHeight = (l.getEquipmentHeight(getContext()) - i2) / 2;
                int equipmentWidth = (l.getEquipmentWidth(getContext()) - i3) / 2;
                this.feE = new Rect(equipmentWidth, equipmentHeight, i3 + equipmentWidth, i2 + equipmentHeight);
                this.feF = new Rect(this.feE);
                this.feM = equipmentHeight / l.getEquipmentHeight(getContext());
                this.feD = new Rect(0, 0, this.feB.getWidth(), this.feB.getHeight());
            }
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (i == 2) {
            this.fez = w(this.mLastMotionX - x, this.mLastMotionY - y);
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (this.fez || this.feA) {
            this.fer.setImageOnLongClickListener(null);
            this.fet.setOnLongClickListener(null);
            z = true;
        } else {
            this.fer.setImageOnLongClickListener(this.mLongClickListener);
            this.fet.setOnLongClickListener(this.mLongClickListener);
            z = super.dispatchTouchEvent(motionEvent);
        }
        if (i == 1 || i == 3) {
            this.mLastMotionX = 0.0f;
            this.mLastMotionY = 0.0f;
            boolean z2 = (-this.mMoveDistance) > ((float) EXIT_DISTANCE);
            boolean z3 = this.mMoveDistance > ((float) EXIT_DISTANCE);
            if (z2 || z3) {
                this.feA = true;
                startExitAnimation();
                if (z2) {
                    TiebaStatic.log(new aq("c13377").dR("obj_type", "3"));
                } else if (z3) {
                    TiebaStatic.log(new aq("c13377").dR("obj_type", "2"));
                }
            } else {
                if (this.fez && this.feG != null) {
                    this.feG.bBL();
                }
                this.mRatio = 1.0f;
                invalidate();
            }
            this.isInDragScaleMode = false;
            this.mDragMatrix.reset();
            this.fez = false;
        }
        return z;
    }

    private boolean w(float f, float f2) {
        if (this.fet.getVisibility() != 0 || this.fet.isCanDrag()) {
            if (this.fbR == null || !this.fbR.isLongPic || this.fet.getVisibility() != 0 || this.fet.isViewTop()) {
                if (this.fbR == null || !this.fbR.isLongPic || this.fet.getVisibility() == 0 || this.fer.isAtViewTop() || this.fer.bBJ()) {
                    if (this.fet.getVisibility() == 0 || this.fer.pagerCantScroll()) {
                        if (this.feB != null && getScrollY() == 0) {
                            boolean z = (this.fbR == null || !this.fbR.isLongPic) && ((f2 < -15.0f && !this.isInDragScaleMode) || (f2 > 15.0f && !this.isInDragScaleMode));
                            boolean z2 = this.fbR != null && this.fbR.isLongPic && f2 < 0.0f && !this.isInDragScaleMode;
                            if (z || (z2 && this.fer.isViewTop())) {
                                this.fer.setImageOnLongClickListener(null);
                                this.fet.setOnLongClickListener(null);
                                this.isInDragScaleMode = true;
                                this.mMoveDistance = 0.0f;
                                this.mRatio = 1.0f;
                                if (this.feG != null) {
                                    this.feG.onDragStart();
                                }
                            }
                        }
                        if (!this.isInDragScaleMode || this.feB == null) {
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
                        this.mDragMatrix.preScale(1.0f + f3, 1.0f + f3, (this.mRatio * this.feB.getWidth()) / 2.0f, this.mRatio * (this.feB.getHeight() / 2));
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
        if (this.fez && this.feB != null && !this.feB.isRecycled() && this.isInDragScaleMode) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.mDstRect == null) {
                this.mDstRect = new RectF();
            }
            this.mDragMatrix.mapRect(this.mDstRect, new RectF(this.mDisplayRect));
            canvas.drawBitmap(this.feB, this.feD, this.mDstRect, (Paint) null);
        } else if (this.feA && this.feB != null && !this.feB.isRecycled()) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.fbR == null || this.fbR.getSourceImageRectInScreen() == null) {
                canvas.drawBitmap(this.feB, this.feD, this.mDstRect, (Paint) null);
            } else {
                canvas.drawBitmap(this.feB, this.feE, this.mDstRect, (Paint) null);
            }
        } else {
            super.dispatchDraw(canvas);
        }
    }

    private void startExitAnimation() {
        if (this.fbR == null) {
            if (this.feG != null) {
                this.feG.onDragEnd();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.fbR.getSourceImageRectInScreen();
        final Rect dstRectInScreen = this.fbR.getDstRectInScreen();
        if (sourceImageRectInScreen == null || dstRectInScreen == null) {
            if (this.feG != null) {
                this.feG.onDragEnd();
                return;
            }
            return;
        }
        a(sourceImageRectInScreen, dstRectInScreen);
        b(sourceImageRectInScreen);
        this.feC = new RectF(this.mDstRect);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(150L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && sourceImageRectInScreen != null && dstRectInScreen != null) {
                    UrlDragImageView.this.aj(valueAnimator.getAnimatedFraction());
                    UrlDragImageView.this.a(dstRectInScreen, valueAnimator.getAnimatedFraction(), UrlDragImageView.this.feY);
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
                if (UrlDragImageView.this.feG != null) {
                    UrlDragImageView.this.feG.onDragEnd();
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
            this.mDstRect.top += this.mDstRect.height() * this.feM;
            this.mDstRect.bottom = f + this.mDstRect.top;
        }
    }

    public void setCanScale(boolean z) {
        if (this.fer != null) {
            this.fer.setCanScale(z);
        }
    }

    private void a(Rect rect, Rect rect2) {
        this.feI = 0.0f;
        this.feJ = 0.0f;
        this.feK = 1.0f;
        this.feL = 1.0f;
        if (rect != null && rect2 != null && rect.contains(rect2)) {
            this.feI = (rect2.left - rect.left) / rect.width();
            this.feJ = (rect2.top - rect.top) / rect.height();
            this.feK = (rect2.right - rect.left) / rect.width();
            this.feL = (rect2.bottom - rect.top) / rect.height();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aj(float f) {
        if (this.feE != null) {
            this.feE.left = (int) (this.feF.left + (this.feF.width() * this.feI * f));
            this.feE.top = (int) (this.feF.top + (this.feF.height() * this.feJ * f));
            this.feE.right = (int) (this.feF.left + (this.feF.width() * (((1.0f - this.feK) * (1.0f - f)) + this.feK)));
            this.feE.bottom = (int) (this.feF.top + (this.feF.height() * (((1.0f - this.feL) * (1.0f - f)) + this.feL)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Rect rect, float f, boolean z) {
        int i = 0;
        if (z) {
            i = l.getDimens(getContext(), R.dimen.tbds80);
        }
        if (this.mDstRect != null && rect != null) {
            this.mDstRect.left = this.feC.left + ((rect.left - this.feC.left) * f);
            this.mDstRect.top = (this.feC.top + ((rect.top - this.feC.top) * f)) - i;
            this.mDstRect.right = this.feC.right + ((rect.right - this.feC.right) * f);
            this.mDstRect.bottom = this.feC.bottom + ((rect.bottom - this.feC.bottom) * f);
        }
    }

    private RectF getRectInScreenFromPosition(float f, float f2, float f3, float f4) {
        return new RectF(f - (f3 / 2.0f), f2 - (f4 / 2.0f), (f3 / 2.0f) + f, (f4 / 2.0f) + f2);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.feS = onTouchListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvA() {
        if ((this.few || this.fex) && this.fbR != null && this.fbR.mPicType == 1 && !TextUtils.isEmpty(this.fbR.mTagName)) {
            if (this.fes != null) {
                this.fes.setVisibility(8);
                this.fes = null;
            }
            this.fes = new TextView(this.mContext);
            this.fes.setText(this.fbR.mTagName);
            this.fes.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize26));
            ap.setViewTextColor(this.fes, R.color.common_color_10013, 1, 0);
            ap.setBackgroundColor(this.fes, R.color.common_color_10215);
            this.fes.setAlpha(0.75f);
            this.fes.setIncludeFontPadding(false);
            this.fes.setGravity(17);
            int dimens = l.getDimens(this.mContext, R.dimen.ds2);
            this.fes.setPadding(dimens, dimens, dimens, dimens);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.fer.getBottomOffset();
            layoutParams.leftMargin = this.fer.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.fes, layoutParams);
            this.fes.setVisibility(0);
        }
    }

    public void setUrl(String str, boolean z) {
        if (str.contains("*")) {
            str = str.split("[*]")[0];
        }
        this.fer.setTag(str);
        this.fer.setLoadBigImage(false);
        this.fer.setImageDrawable(null);
        this.few = false;
        this.fex = false;
        this.feN = bvI();
        this.feV = null;
        if (CU(str)) {
            e(str, z, false);
        }
    }

    private boolean bvB() {
        return this.fer != null && this.fer.isLoadBigImage();
    }

    public void bvC() {
        if (this.fbR != null && !bvB()) {
            String str = this.fbR.imageUrl;
            int i = this.fbR.urlType;
            com.baidu.adp.widget.ImageView.a aVar = null;
            if (com.baidu.tbadk.core.util.c.a.al(str, i)) {
                aVar = com.baidu.tbadk.core.util.c.a.am(str, i);
            }
            if (aVar != null) {
                setThumbBitmapToView(aVar);
            }
        }
    }

    private boolean jH(boolean z) {
        String nameMd5FromUrl;
        if (!this.feO || z) {
            this.feO = true;
            if (!this.feN || this.fbR == null || StringUtils.isNull(this.fbR.originalUrl, true) || this.fbR.originalSize < 0 || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String str = this.feH + as.boL().BG(nameMd5FromUrl) + "/" + av.getNameMd5FromUrl(this.fbR.originalUrl);
            final int[] imageFileWH = n.getImageFileWH(str);
            this.fet.setVisibility(0);
            if (this.feu == null) {
                this.feu = new SubsamplingScaleImageView.OnImageEventListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12
                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onReady() {
                        UrlDragImageView.this.feV = null;
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.fer.restoreSize();
                        UrlDragImageView.this.fer.setVisibility(4);
                    }

                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onImageLoaded() {
                        if (UrlDragImageView.this.fbR.isLongPic && imageFileWH[0] > 0) {
                            UrlDragImageView.this.fer.onDestroy();
                            final float measuredWidth = (UrlDragImageView.this.getMeasuredWidth() * 1.0f) / imageFileWH[0];
                            final PointF pointF = new PointF((imageFileWH[0] * 1.0f) / 2.0f, 0.0f);
                            UrlDragImageView.this.fet.setScaleAndCenter(measuredWidth, pointF);
                            UrlDragImageView.this.fet.setMaxScale(2.0f * measuredWidth);
                            UrlDragImageView.this.fet.setDoubleTapZoomScale(2.0f * measuredWidth);
                            UrlDragImageView.this.fet.setInitScale(measuredWidth);
                            UrlDragImageView.this.fet.setDoubleTapZoomStyle(4);
                            UrlDragImageView.this.fet.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12.1
                                @Override // android.view.View.OnTouchListener
                                public boolean onTouch(View view, MotionEvent motionEvent) {
                                    if (UrlDragImageView.this.feS != null) {
                                        UrlDragImageView.this.feS.onTouch(view, motionEvent);
                                    }
                                    switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                                        case 0:
                                            UrlDragImageView.this.feU = motionEvent.getY();
                                            UrlDragImageView.this.fet.setOnClickListener(UrlDragImageView.this.feT ? UrlDragImageView.this.mOnClickListener : null);
                                            UrlDragImageView.this.fet.setOnLongClickListener(UrlDragImageView.this.feT ? UrlDragImageView.this.mLongClickListener : null);
                                            break;
                                        case 1:
                                        case 3:
                                            if (UrlDragImageView.this.fet.getScale() < measuredWidth) {
                                                UrlDragImageView.this.fet.setScaleAndCenter(measuredWidth, pointF);
                                            }
                                            e.mY().removeCallbacks(UrlDragImageView.this.feZ);
                                            e.mY().postDelayed(UrlDragImageView.this.feZ, 1000L);
                                            break;
                                        case 2:
                                            if (Math.abs(motionEvent.getY() - UrlDragImageView.this.feU) > UrlDragImageView.TOUCH_SLOP) {
                                                UrlDragImageView.this.feT = false;
                                                UrlDragImageView.this.fet.setOnClickListener(null);
                                                UrlDragImageView.this.fet.setOnLongClickListener(null);
                                            }
                                            UrlDragImageView.this.feU = motionEvent.getY();
                                            break;
                                    }
                                    return false;
                                }
                            });
                            UrlDragImageView.this.fer.setVisibility(4);
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
            this.fet.setOnImageEventListener(this.feu);
            if (this.fet.isImageLoaded() && this.fbR.isLongPic) {
                this.feu.onImageLoaded();
            } else {
                this.fet.setImage(ImageSource.uri(str));
            }
            return true;
        }
        return false;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.feG = dVar;
        if (this.fer != null) {
            this.fer.setDragToExitListener(dVar);
        }
    }

    public void bvD() {
        jH(false);
    }

    private boolean CU(String str) {
        return j.isNetWorkAvailable() || com.baidu.tbadk.core.util.c.c.BT(str);
    }

    private void setThumbBitmapToView(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap rawBitmap;
        if (!this.fex && aVar != null && (rawBitmap = aVar.getRawBitmap()) != null) {
            this.few = true;
            if (aVar.isGif()) {
                this.fer.setImageUrlData(this.fbR);
                this.fer.setImageBitmap(rawBitmap);
                this.feV = null;
                this.feQ = false;
            } else {
                if (this.fbR != null && this.fbR.isLongPic) {
                    this.fer.createLargeImageDelegate();
                    this.fer.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.13
                        @Override // com.baidu.tbadk.widget.largeImage.logic.a
                        public void onLoadFinished() {
                        }
                    });
                }
                this.fer.setImageUrlData(this.fbR);
                this.fer.setImageData(rawBitmap, aVar.getByteData());
            }
            bvA();
        }
    }

    private void e(String str, boolean z, boolean z2) {
        if (CV(str)) {
            if (z2 || (!this.fey && !this.fex)) {
                if (!z2 || !jH(true)) {
                    this.fey = true;
                    com.baidu.adp.lib.e.c.mS().a(str, 27, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.14
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.b
                        public void onCancelled(String str2) {
                            UrlDragImageView.this.fey = false;
                            UrlDragImageView.this.fer.setVisibility(0);
                            UrlDragImageView.this.mProgressBar.setVisibility(8);
                            UrlDragImageView.this.feV = null;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            UrlDragImageView.this.fey = false;
                            UrlDragImageView.this.fex = true;
                            UrlDragImageView.this.b(aVar);
                        }
                    }, 0, 0, false, null, Boolean.valueOf(z), this.fer.getImageData(), Boolean.valueOf(this.fcV));
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
        imageFileInfo.addPageAction(d.bg(this.mMaxWidth, this.mMaxHeight));
        com.baidu.adp.widget.ImageView.a a2 = this.feR.a(imageFileInfo, false);
        if (a2 != null) {
            this.fex = true;
            this.mProgressBar.setVisibility(8);
            this.feV = null;
            b(a2);
            return;
        }
        this.feR.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.2
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.ImageView.a aVar, String str2, boolean z3) {
                UrlDragImageView.this.fex = true;
                UrlDragImageView.this.mProgressBar.setVisibility(8);
                UrlDragImageView.this.feV = null;
                UrlDragImageView.this.b(aVar);
            }
        }, false);
    }

    private boolean CV(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null && this.fev != null) {
            this.fev.k(aVar.getUrl(), aVar.getByteData());
        }
        if (aVar == null || aVar.getRawBitmap() == null) {
            bvE();
            return;
        }
        Bitmap rawBitmap = aVar.getRawBitmap();
        this.fer.setLoadBigImage(true);
        if (aVar.isGif()) {
            this.fer.setGifData(aVar.getByteData(), rawBitmap);
            this.fer.invalidate();
            this.fer.play();
            this.feQ = false;
            this.feV = null;
            this.mProgressBar.setVisibility(8);
        } else {
            if (this.fbR != null && this.fbR.isLongPic) {
                this.fer.createLargeImageDelegate();
                this.fer.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.3
                    @Override // com.baidu.tbadk.widget.largeImage.logic.a
                    public void onLoadFinished() {
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.feV = null;
                    }
                });
            } else {
                this.mProgressBar.setVisibility(8);
                this.feV = null;
            }
            this.fer.setImageUrlData(this.fbR);
            this.fer.setImageData(rawBitmap, aVar.getByteData());
            bvJ();
        }
        bvA();
    }

    private void bvE() {
        if (!this.few) {
            this.fer.setDefaultBitmap();
        } else {
            this.fex = false;
        }
        this.feV = null;
        this.mProgressBar.setVisibility(8);
    }

    public void setGifMaxUseableMem(int i) {
        this.fer.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.fer != null) {
            this.fer.onDestroy();
        }
        if (this.fet != null) {
            this.fet.recycle();
        }
        if (this.feB != null) {
            this.feB.recycle();
            this.feB = null;
        }
        if (this.mProgressBar != null) {
            this.feV = null;
            this.mProgressBar.setVisibility(8);
        }
        e.mY().removeCallbacks(this.feZ);
        com.baidu.tieba.view.c.dPW().setColor(-1);
    }

    public void release() {
        if (this.fer != null) {
            this.fer.release();
        }
        if (this.mProgressBar != null) {
            this.feV = null;
            this.mProgressBar.setVisibility(8);
        }
        this.feV = null;
    }

    public void bvF() {
        if (this.fer != null && this.fer.getImageType() == 1) {
            this.fer.stop();
        }
    }

    public void E(boolean z, boolean z2) {
        String str;
        if (this.fer != null && (str = (String) this.fer.getTag()) != null) {
            if (this.fer.getImageType() == 1) {
                if (this.fer.getGifCache() == null || !this.fer.isLoadBigImage()) {
                    e(str, z, z2);
                }
            } else if (this.fer.getImageType() == 2) {
                e(str, z, z2);
            } else if (bvG()) {
                e(str, z, z2);
            }
        }
    }

    private boolean bvG() {
        if (this.fer.getImageBitmap() != null && this.fer.isLoadBigImage()) {
            if (this.fbR == null || !this.fbR.isLongPic || this.fer.hasLoadLongImage()) {
                return false;
            }
            this.fex = false;
            this.feO = false;
            return true;
        }
        return true;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.fbR = imageUrlData;
    }

    public ImageUrlData getmAssistUrlData() {
        return this.fbR;
    }

    public void setIsCdn(boolean z) {
        this.fcV = z;
    }

    public void bvH() {
        final String nameMd5FromUrl = av.getNameMd5FromUrl(this.fbR.originalUrl);
        if (this.fbR.originalProcess >= 0) {
            com.baidu.tbadk.download.d.bwU().cancelDownLoadById(nameMd5FromUrl, 13);
            this.fbR.originalProcess = -1;
            bvJ();
            return;
        }
        if (this.fcO != null) {
            this.fcO.bvM();
        }
        com.baidu.adp.base.e<?> I = i.I(this.mContext);
        if (I == null) {
            CW(nameMd5FromUrl);
        } else if (!j.isNetWorkAvailable() || j.isWifiNet() || com.baidu.tbadk.core.sharedPref.b.bnH().getBoolean(SharedPrefConfig.ORIGINAL_IMG_DOWN_TIP, false)) {
            CW(nameMd5FromUrl);
        } else {
            com.baidu.tbadk.core.sharedPref.b.bnH().putBoolean(SharedPrefConfig.ORIGINAL_IMG_DOWN_TIP, true);
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(I.getPageActivity());
            aVar.om(R.string.original_img_down_no_wifi_tip);
            aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    UrlDragImageView.this.CW(nameMd5FromUrl);
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                }
            });
            aVar.b(I);
            aVar.bmC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CW(String str) {
        if (this.fbR != null) {
            this.fbR.originalProcess = 0;
            this.feW.setProgress(0);
            this.feW.setVisibility(0);
            DownloadData downloadData = new DownloadData(str);
            downloadData.setStatus(1);
            downloadData.setUrl(this.fbR.originalUrl);
            downloadData.setType(13);
            downloadData.setPath(this.feH + as.boL().BG(str) + "/" + str);
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.6
                @Override // com.baidu.tbadk.download.c
                public boolean onPreDownload(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2 != null) {
                        if (UrlDragImageView.this.fbR != null && UrlDragImageView.this.fbR.originalProcess != -1) {
                            UrlDragImageView.this.fbR.originalProcess = downloadData2.getProcess();
                        }
                        if (UrlDragImageView.this.fbR == null || UrlDragImageView.this.fbR.originalProcess != -1) {
                            UrlDragImageView.this.feW.setProgress(downloadData2.getProcess());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public boolean onFileDownloaded(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadSucceed(DownloadData downloadData2) {
                    UrlDragImageView.this.feW.setVisibility(8);
                    e.mY().postDelayed(UrlDragImageView.this.ffa, 1500L);
                    UrlDragImageView.this.feO = false;
                    UrlDragImageView.this.feN = UrlDragImageView.this.bvI();
                    UrlDragImageView.this.bvD();
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str2) {
                    UrlDragImageView.this.feW.setVisibility(8);
                    UrlDragImageView.this.feO = false;
                    BdToast.b(UrlDragImageView.this.mContext, str2).bmH().bmI();
                    UrlDragImageView.this.fbR.originalProcess = -1;
                    UrlDragImageView.this.bvJ();
                }
            });
            com.baidu.tbadk.download.d.bwU().a(downloadData, 100);
            this.feX = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bvI() {
        if (this.fbR != null && !StringUtils.isNull(this.fbR.originalUrl, true) && this.fbR.originalSize >= 0 && !this.fbR.isBlockedPic) {
            String nameMd5FromUrl = av.getNameMd5FromUrl(this.fbR.originalUrl);
            File file = new File(this.feH + as.boL().BG(nameMd5FromUrl) + "/" + nameMd5FromUrl);
            if (file != null && file.exists()) {
                this.fbR.originalProcess = 100;
                return true;
            }
            if (this.fbR.originalProcess < 0) {
                bvJ();
            } else {
                this.feW.setProgress(this.fbR.originalProcess);
            }
            this.feQ = true;
        } else {
            this.feV = null;
        }
        return false;
    }

    public void bvJ() {
        if (this.fbR != null) {
            if (!bvK() || !this.feQ) {
                this.feV = null;
            } else if (this.fbR.originalSize > 0 && !di(this.fbR.originalSize)) {
                this.feV = fep + "(" + at.getFormatSize(this.fbR.originalSize) + ")";
            } else {
                this.feV = fep;
            }
        }
    }

    private boolean bvK() {
        return (this.fbR == null || !this.fbR.mIsShowOrigonButton || this.fbR.isBlockedPic || StringUtils.isNull(this.fbR.originalUrl)) ? false : true;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.fcO = bVar;
    }

    private boolean di(long j) {
        return j > feq;
    }
}
