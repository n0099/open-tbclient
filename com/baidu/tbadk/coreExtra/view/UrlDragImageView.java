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
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.util.f;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.File;
/* loaded from: classes3.dex */
public class UrlDragImageView extends RelativeLayout {
    private b cAC;
    private boolean cAJ;
    private boolean cAL;
    private boolean cAM;
    private boolean cCA;
    private boolean cCB;
    public boolean cCC;
    private com.baidu.tbadk.img.b cCD;
    private View.OnTouchListener cCE;
    private boolean cCF;
    private float cCG;
    private String cCH;
    private CircleProgressView cCI;
    private boolean cCJ;
    private Runnable cCK;
    private Runnable cCL;
    private View.OnTouchListener cCM;
    protected DragImageView cCe;
    protected TextView cCf;
    protected SubsamplingScaleImageView cCg;
    private SubsamplingScaleImageView.OnImageEventListener cCh;
    private a cCi;
    private boolean cCj;
    private boolean cCk;
    private boolean cCl;
    private boolean cCm;
    private Bitmap cCn;
    private RectF cCo;
    private Rect cCp;
    private Rect cCq;
    private Rect cCr;
    private DragImageView.d cCs;
    private String cCt;
    private float cCu;
    private float cCv;
    private float cCw;
    private float cCx;
    private float cCy;
    private boolean cCz;
    private ImageUrlData czt;
    private boolean isInDragScaleMode;
    protected Context mContext;
    private Rect mDisplayRect;
    private final Matrix mDragMatrix;
    private RectF mDstRect;
    private boolean mIsDrag;
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
    private static final String cCc = TbadkCoreApplication.getInst().getString(R.string.original_img_look);
    private static long cCd = Config.RAVEN_LOG_LIMIT;
    private static final int EXIT_DISTANCE = l.getEquipmentHeight(TbadkCoreApplication.getInst()) / 5;
    private static final String TAG = UrlDragImageView.class.getSimpleName();
    private static final int TOUCH_SLOP = ViewConfiguration.get(TbadkCoreApplication.getInst()).getScaledTouchSlop();

    /* loaded from: classes3.dex */
    public interface a {
        void h(String str, byte[] bArr);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void asT();
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
        if (this.cCe != null) {
            this.cCe.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.cCi = aVar;
    }

    public UrlDragImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.cCe = null;
        this.cCi = null;
        this.cAJ = false;
        this.cCl = false;
        this.isInDragScaleMode = false;
        this.mRatio = 1.0f;
        this.mMoveDistance = 0.0f;
        this.mDragMatrix = new Matrix();
        this.mDstRect = new RectF();
        this.cCu = 0.0f;
        this.cCv = 0.0f;
        this.cCw = 1.0f;
        this.cCx = 1.0f;
        this.cCy = 0.0f;
        this.cCz = false;
        this.cCA = false;
        this.cCB = false;
        this.cCC = false;
        this.cCF = true;
        this.cCG = 0.0f;
        this.mOnClickListener = null;
        this.mLongClickListener = null;
        this.cCH = null;
        this.cCK = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.cCF = true;
            }
        };
        this.cCL = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.cCI.setVisibility(8);
                        UrlDragImageView.this.cCH = null;
                        UrlDragImageView.this.cCC = false;
                    }
                });
            }
        };
        this.cCM = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.cCE != null) {
                    UrlDragImageView.this.cCE.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.cCD = new com.baidu.tbadk.img.b();
        init();
    }

    public UrlDragImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.cCe = null;
        this.cCi = null;
        this.cAJ = false;
        this.cCl = false;
        this.isInDragScaleMode = false;
        this.mRatio = 1.0f;
        this.mMoveDistance = 0.0f;
        this.mDragMatrix = new Matrix();
        this.mDstRect = new RectF();
        this.cCu = 0.0f;
        this.cCv = 0.0f;
        this.cCw = 1.0f;
        this.cCx = 1.0f;
        this.cCy = 0.0f;
        this.cCz = false;
        this.cCA = false;
        this.cCB = false;
        this.cCC = false;
        this.cCF = true;
        this.cCG = 0.0f;
        this.mOnClickListener = null;
        this.mLongClickListener = null;
        this.cCH = null;
        this.cCK = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.cCF = true;
            }
        };
        this.cCL = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.cCI.setVisibility(8);
                        UrlDragImageView.this.cCH = null;
                        UrlDragImageView.this.cCC = false;
                    }
                });
            }
        };
        this.cCM = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.cCE != null) {
                    UrlDragImageView.this.cCE.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.cCD = new com.baidu.tbadk.img.b();
        init();
    }

    public DragImageView getImageView() {
        return this.cCe;
    }

    public void setGifSetListener(DragImageView.e eVar) {
        this.cCe.setGifSetListener(eVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.cCe.setImageOnClickListener(onClickListener);
        this.cCg.setOnClickListener(onClickListener);
        this.mOnClickListener = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mLongClickListener = onLongClickListener;
        if (!this.cAL) {
            this.cCe.setImageOnLongClickListener(this.mLongClickListener);
            this.cCg.setOnLongClickListener(this.mLongClickListener);
        }
    }

    public void setOnSizeChangedListener(final DragImageView.g gVar) {
        this.cCe.setOnSizeChangedListener(new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.8
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (gVar != null) {
                    gVar.a(dragImageView, z, z2);
                }
                UrlDragImageView.this.asH();
            }
        });
    }

    protected void init() {
        this.cCt = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        this.mMaxWidth = l.getEquipmentWidth(this.mContext);
        this.mMaxHeight = l.getEquipmentHeight(this.mContext) - ((int) this.mContext.getResources().getDimension(R.dimen.ds166));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.cCe = new DragImageView(this.mContext);
        this.cCe.setLayoutParams(layoutParams);
        this.cCe.setOnTouchListener(this.cCM);
        addView(this.cCe);
        this.cCg = new SubsamplingScaleImageView(this.mContext);
        this.cCg.setMaxScale(50.0f);
        this.cCg.setOnTouchListener(this.cCM);
        this.cCg.setVisibility(4);
        addView(this.cCg, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(getResources().getDrawable(R.drawable.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        asG();
    }

    private void asG() {
        this.cCI = new CircleProgressView(this.mContext);
        this.cCI.setCircleBackgroundColor(am.getColor(R.color.cp_cont_d));
        this.cCI.setCircleForegroundColor(am.getColor(R.color.cp_link_tip_a));
        this.cCI.setProgress(0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds80), l.getDimens(getContext(), R.dimen.tbds80));
        layoutParams.addRule(13);
        this.cCI.setVisibility(8);
        addView(this.cCI, layoutParams);
    }

    public void setIsCanDrag(boolean z) {
        this.cAL = z;
    }

    public void setIsHotSort(boolean z) {
        this.cAM = z;
    }

    public String getmCheckOriginPicText() {
        return this.cCH;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        Bitmap imageBitmap;
        int height;
        int width;
        if (this.cCz && !this.cCJ && this.cCg.getVisibility() == 0 && !this.cCg.isImageLoaded()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.cAL || !this.cCk) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.mIsDrag && motionEvent.getPointerCount() >= 2) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.mIsDrag || this.cCm) {
            requestDisallowInterceptTouchEvent(true);
        }
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        float x = motionEvent.getX();
        int i = action & 255;
        if (i == 0) {
            if (this.cCn == null) {
                if (this.cCg.getVisibility() == 0) {
                    this.cCn = f.bh(this.cCg);
                } else {
                    this.cCn = f.bh(this.cCe);
                }
            }
            if (this.mDisplayRect == null && this.cCn != null) {
                int measuredWidth = getMeasuredWidth();
                float measuredWidth2 = ((getMeasuredWidth() * 1.0f) / this.cCn.getWidth()) * this.cCn.getHeight();
                if (measuredWidth2 > getMeasuredHeight()) {
                    measuredWidth2 = getMeasuredHeight();
                }
                RectF rectInScreenFromPosition = getRectInScreenFromPosition(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
                this.mDisplayRect = new Rect((int) rectInScreenFromPosition.left, (int) rectInScreenFromPosition.top, (int) rectInScreenFromPosition.right, (int) rectInScreenFromPosition.bottom);
            }
            if (this.cCq == null && this.cCn != null) {
                if (this.cCg.getVisibility() == 0) {
                    height = this.cCg.getSHeight();
                    width = this.cCg.getSWidth();
                } else {
                    if (this.cCe.getImageType() == 1) {
                        imageBitmap = (this.cCe.getCurrentFrame() == null || this.cCe.getCurrentFrame().bm == null) ? this.cCn : this.cCe.getCurrentFrame().bm;
                    } else {
                        imageBitmap = this.cCe.getImageBitmap() == null ? this.cCn : this.cCe.getImageBitmap();
                    }
                    height = imageBitmap.getHeight();
                    width = imageBitmap.getWidth();
                }
                float equipmentDensity = l.getEquipmentDensity(getContext());
                int i2 = (int) (height * equipmentDensity);
                int i3 = (int) (width * equipmentDensity);
                if (i3 > this.cCn.getWidth() && this.cCn.getWidth() != 0) {
                    float width2 = (i3 * 1.0f) / this.cCn.getWidth();
                    i3 = this.cCn.getWidth();
                    i2 = (int) (i2 / width2);
                }
                if (i2 > this.cCn.getHeight() && this.cCn.getHeight() != 0) {
                    i3 = (int) (i3 / ((i2 * 1.0f) / this.cCn.getHeight()));
                    i2 = this.cCn.getHeight();
                }
                int equipmentHeight = (l.getEquipmentHeight(getContext()) - i2) / 2;
                int equipmentWidth = (l.getEquipmentWidth(getContext()) - i3) / 2;
                this.cCq = new Rect(equipmentWidth, equipmentHeight, i3 + equipmentWidth, i2 + equipmentHeight);
                this.cCr = new Rect(this.cCq);
                this.cCy = equipmentHeight / l.getEquipmentHeight(getContext());
                this.cCp = new Rect(0, 0, this.cCn.getWidth(), this.cCn.getHeight());
            }
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (i == 2) {
            this.mIsDrag = q(this.mLastMotionX - x, this.mLastMotionY - y);
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (this.mIsDrag || this.cCm) {
            this.cCe.setImageOnLongClickListener(null);
            this.cCg.setOnLongClickListener(null);
            z = true;
        } else {
            this.cCe.setImageOnLongClickListener(this.mLongClickListener);
            this.cCg.setOnLongClickListener(this.mLongClickListener);
            z = super.dispatchTouchEvent(motionEvent);
        }
        if (i == 1 || i == 3) {
            this.mLastMotionX = 0.0f;
            this.mLastMotionY = 0.0f;
            if (this.mMoveDistance > EXIT_DISTANCE) {
                this.cCm = true;
                startExitAnimation();
            } else {
                if (this.mIsDrag && this.cCs != null) {
                    this.cCs.ayc();
                }
                this.mRatio = 1.0f;
                invalidate();
            }
            this.isInDragScaleMode = false;
            this.mDragMatrix.reset();
            this.mIsDrag = false;
            return z;
        }
        return z;
    }

    private boolean q(float f, float f2) {
        if (this.cCg.getVisibility() != 0 || this.cCg.isCanDrag()) {
            if (this.czt == null || !this.czt.isLongPic || this.cCg.getVisibility() != 0 || this.cCg.isViewTop()) {
                if (this.czt == null || !this.czt.isLongPic || this.cCg.getVisibility() == 0 || this.cCe.isAtViewTop()) {
                    if (this.cCg.getVisibility() == 0 || this.cCe.pagerCantScroll()) {
                        if (this.cCn != null && getScrollY() == 0 && f2 < 0.0f && !this.isInDragScaleMode) {
                            this.cCe.setImageOnLongClickListener(null);
                            this.cCg.setOnLongClickListener(null);
                            this.isInDragScaleMode = true;
                            this.mMoveDistance = 0.0f;
                            this.mRatio = 1.0f;
                            if (this.cCs != null) {
                                this.cCs.onDragStart();
                            }
                        }
                        if (!this.isInDragScaleMode || this.cCn == null) {
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
                            this.mDragMatrix.preScale(1.0f / this.mRatio, 1.0f / this.mRatio, (this.mRatio * this.cCn.getWidth()) / 2.0f, this.mRatio * (this.cCn.getHeight() / 2));
                            this.mRatio = 1.0f;
                        } else {
                            this.mDragMatrix.preScale(1.0f + f3, 1.0f + f3, (this.mRatio * this.cCn.getWidth()) / 2.0f, this.mRatio * (this.cCn.getHeight() / 2));
                            this.mRatio = (f3 + 1.0f) * this.mRatio;
                        }
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
        if (this.mIsDrag && this.cCn != null && !this.cCn.isRecycled() && this.isInDragScaleMode) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.mDstRect == null) {
                this.mDstRect = new RectF();
            }
            this.mDragMatrix.mapRect(this.mDstRect, new RectF(this.mDisplayRect));
            canvas.drawBitmap(this.cCn, this.cCp, this.mDstRect, (Paint) null);
        } else if (this.cCm && this.cCn != null && !this.cCn.isRecycled()) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.czt == null || this.czt.getSourceImageRectInScreen() == null) {
                canvas.drawBitmap(this.cCn, this.cCp, this.mDstRect, (Paint) null);
            } else {
                canvas.drawBitmap(this.cCn, this.cCq, this.mDstRect, (Paint) null);
            }
        } else {
            super.dispatchDraw(canvas);
        }
    }

    private void startExitAnimation() {
        if (this.czt == null) {
            if (this.cCs != null) {
                this.cCs.onDragEnd();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.czt.getSourceImageRectInScreen();
        final Rect dstRectInScreen = this.czt.getDstRectInScreen();
        if (sourceImageRectInScreen == null || dstRectInScreen == null) {
            if (this.cCs != null) {
                this.cCs.onDragEnd();
                return;
            }
            return;
        }
        a(sourceImageRectInScreen, dstRectInScreen);
        d(sourceImageRectInScreen);
        this.cCo = new RectF(this.mDstRect);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(150L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && sourceImageRectInScreen != null && dstRectInScreen != null) {
                    UrlDragImageView.this.ad(valueAnimator.getAnimatedFraction());
                    UrlDragImageView.this.a(dstRectInScreen, valueAnimator.getAnimatedFraction());
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
                if (UrlDragImageView.this.cCs != null) {
                    UrlDragImageView.this.cCs.onDragEnd();
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

    private void d(Rect rect) {
        if (rect != null) {
            float f = ((rect.bottom - rect.top) / (rect.right - rect.left)) * (this.mDstRect.right - this.mDstRect.left);
            this.mDstRect.top += this.mDstRect.height() * this.cCy;
            this.mDstRect.bottom = f + this.mDstRect.top;
        }
    }

    public void setCanScale(boolean z) {
        if (this.cCe != null) {
            this.cCe.setCanScale(z);
        }
    }

    private void a(Rect rect, Rect rect2) {
        this.cCu = 0.0f;
        this.cCv = 0.0f;
        this.cCw = 1.0f;
        this.cCx = 1.0f;
        if (rect != null && rect2 != null && rect.contains(rect2)) {
            this.cCu = (rect2.left - rect.left) / rect.width();
            this.cCv = (rect2.top - rect.top) / rect.height();
            this.cCw = (rect2.right - rect.left) / rect.width();
            this.cCx = (rect2.bottom - rect.top) / rect.height();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ad(float f) {
        if (this.cCq != null) {
            this.cCq.left = (int) (this.cCr.left + (this.cCr.width() * this.cCu * f));
            this.cCq.top = (int) (this.cCr.top + (this.cCr.height() * this.cCv * f));
            this.cCq.right = (int) (this.cCr.left + (this.cCr.width() * (((1.0f - this.cCw) * (1.0f - f)) + this.cCw)));
            this.cCq.bottom = (int) (this.cCr.top + (this.cCr.height() * (((1.0f - this.cCx) * (1.0f - f)) + this.cCx)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Rect rect, float f) {
        if (this.mDstRect != null && rect != null) {
            this.mDstRect.left = this.cCo.left + ((rect.left - this.cCo.left) * f);
            this.mDstRect.top = this.cCo.top + ((rect.top - this.cCo.top) * f);
            this.mDstRect.right = this.cCo.right + ((rect.right - this.cCo.right) * f);
            this.mDstRect.bottom = this.cCo.bottom + ((rect.bottom - this.cCo.bottom) * f);
        }
    }

    private RectF getRectInScreenFromPosition(float f, float f2, float f3, float f4) {
        return new RectF(f - (f3 / 2.0f), f2 - (f4 / 2.0f), (f3 / 2.0f) + f, (f4 / 2.0f) + f2);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.cCE = onTouchListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asH() {
        if ((this.cCj || this.cCk) && this.czt != null && this.czt.mPicType == 1 && !TextUtils.isEmpty(this.czt.mTagName)) {
            if (this.cCf != null) {
                this.cCf.setVisibility(8);
                this.cCf = null;
            }
            this.cCf = new TextView(this.mContext);
            this.cCf.setText(this.czt.mTagName);
            this.cCf.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize26));
            am.setViewTextColor(this.cCf, R.color.common_color_10013, 1, 0);
            am.setBackgroundColor(this.cCf, R.color.common_color_10215);
            this.cCf.setAlpha(0.75f);
            this.cCf.setIncludeFontPadding(false);
            this.cCf.setGravity(17);
            int dimens = l.getDimens(this.mContext, R.dimen.ds2);
            this.cCf.setPadding(dimens, dimens, dimens, dimens);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.cCe.getBottomOffset();
            layoutParams.leftMargin = this.cCe.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.cCf, layoutParams);
            this.cCf.setVisibility(0);
        }
    }

    public void setUrl(String str, boolean z) {
        if (str.contains("*")) {
            str = str.split("[*]")[0];
        }
        this.cCe.setTag(str);
        this.cCe.setLoadBigImage(false);
        this.cCe.setImageDrawable(null);
        this.cCj = false;
        this.cCk = false;
        this.cCz = asP();
        this.cCH = null;
        if (pf(str)) {
            e(str, z, false);
        }
    }

    private boolean asI() {
        return this.cCe != null && this.cCe.isLoadBigImage();
    }

    public void asJ() {
        if (this.czt != null && !asI()) {
            String str = this.czt.imageUrl;
            int i = this.czt.urlType;
            com.baidu.adp.widget.ImageView.a aVar = null;
            if (com.baidu.tbadk.core.util.e.a.P(str, i)) {
                aVar = com.baidu.tbadk.core.util.e.a.Q(str, i);
            }
            if (aVar != null) {
                setThumbBitmapToView(aVar);
            }
        }
    }

    private boolean eT(boolean z) {
        String nameMd5FromUrl;
        if (!this.cCA || z) {
            this.cCA = true;
            if (!this.cCz || this.czt == null || StringUtils.isNull(this.czt.originalUrl, true) || this.czt.originalSize < 0 || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String str = this.cCt + ap.amL().nQ(nameMd5FromUrl) + "/" + as.getNameMd5FromUrl(this.czt.originalUrl);
            final int[] imageFileWH = m.getImageFileWH(str);
            this.cCg.setVisibility(0);
            if (this.cCh == null) {
                this.cCh = new SubsamplingScaleImageView.OnImageEventListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12
                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onReady() {
                        UrlDragImageView.this.cCH = null;
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.cCe.restoreSize();
                        UrlDragImageView.this.cCe.setVisibility(4);
                    }

                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onImageLoaded() {
                        if (UrlDragImageView.this.czt.isLongPic && imageFileWH[0] > 0) {
                            UrlDragImageView.this.cCe.onDestroy();
                            final float measuredWidth = (UrlDragImageView.this.getMeasuredWidth() * 1.0f) / imageFileWH[0];
                            final PointF pointF = new PointF((imageFileWH[0] * 1.0f) / 2.0f, 0.0f);
                            UrlDragImageView.this.cCg.setScaleAndCenter(measuredWidth, pointF);
                            UrlDragImageView.this.cCg.setMaxScale(2.0f * measuredWidth);
                            UrlDragImageView.this.cCg.setDoubleTapZoomScale(2.0f * measuredWidth);
                            UrlDragImageView.this.cCg.setInitScale(measuredWidth);
                            UrlDragImageView.this.cCg.setDoubleTapZoomStyle(4);
                            UrlDragImageView.this.cCg.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12.1
                                @Override // android.view.View.OnTouchListener
                                public boolean onTouch(View view, MotionEvent motionEvent) {
                                    if (UrlDragImageView.this.cCE != null) {
                                        UrlDragImageView.this.cCE.onTouch(view, motionEvent);
                                    }
                                    switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                                        case 0:
                                            UrlDragImageView.this.cCG = motionEvent.getY();
                                            UrlDragImageView.this.cCg.setOnClickListener(UrlDragImageView.this.cCF ? UrlDragImageView.this.mOnClickListener : null);
                                            UrlDragImageView.this.cCg.setOnLongClickListener(UrlDragImageView.this.cCF ? UrlDragImageView.this.mLongClickListener : null);
                                            break;
                                        case 1:
                                        case 3:
                                            if (UrlDragImageView.this.cCg.getScale() < measuredWidth) {
                                                UrlDragImageView.this.cCg.setScaleAndCenter(measuredWidth, pointF);
                                            }
                                            e.fZ().removeCallbacks(UrlDragImageView.this.cCK);
                                            e.fZ().postDelayed(UrlDragImageView.this.cCK, 1000L);
                                            break;
                                        case 2:
                                            if (Math.abs(motionEvent.getY() - UrlDragImageView.this.cCG) > UrlDragImageView.TOUCH_SLOP) {
                                                UrlDragImageView.this.cCF = false;
                                                UrlDragImageView.this.cCg.setOnClickListener(null);
                                                UrlDragImageView.this.cCg.setOnLongClickListener(null);
                                            }
                                            UrlDragImageView.this.cCG = motionEvent.getY();
                                            break;
                                    }
                                    return false;
                                }
                            });
                            UrlDragImageView.this.cCe.setVisibility(4);
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
            this.cCg.setOnImageEventListener(this.cCh);
            if (this.cCg.isImageLoaded() && this.czt.isLongPic) {
                this.cCh.onImageLoaded();
            } else {
                this.cCg.setImage(ImageSource.uri(str));
            }
            return true;
        }
        return false;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.cCs = dVar;
        if (this.cCe != null) {
            this.cCe.setDragToExitListener(dVar);
        }
    }

    public void asK() {
        eT(false);
    }

    private boolean pf(String str) {
        return j.isNetWorkAvailable() || com.baidu.tbadk.core.util.e.c.oj(str);
    }

    private void setThumbBitmapToView(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap rawBitmap;
        if (!this.cCk && aVar != null && (rawBitmap = aVar.getRawBitmap()) != null) {
            this.cCj = true;
            if (aVar.isGif()) {
                this.cCe.setImageUrlData(this.czt);
                this.cCe.setImageBitmap(rawBitmap);
                this.cCH = null;
                this.cCC = false;
            } else {
                if (this.czt != null && this.czt.isLongPic) {
                    this.cCe.createLargeImageDelegate();
                    this.cCe.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.13
                        @Override // com.baidu.tbadk.widget.largeImage.logic.a
                        public void onLoadFinished() {
                        }
                    });
                }
                this.cCe.setImageUrlData(this.czt);
                this.cCe.setImageData(rawBitmap, aVar.getByteData());
            }
            asH();
        }
    }

    private void e(String str, boolean z, boolean z2) {
        if (pg(str)) {
            if (z2 || (!this.cCl && !this.cCk)) {
                if (!z2 || !eT(true)) {
                    this.cCl = true;
                    com.baidu.adp.lib.f.c.fT().a(str, 27, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.14
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onCancelled(String str2) {
                            UrlDragImageView.this.cCl = false;
                            UrlDragImageView.this.cCe.setVisibility(0);
                            UrlDragImageView.this.mProgressBar.setVisibility(8);
                            UrlDragImageView.this.cCH = null;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            UrlDragImageView.this.cCl = false;
                            UrlDragImageView.this.cCk = true;
                            UrlDragImageView.this.b(aVar);
                        }
                    }, 0, 0, false, null, Boolean.valueOf(z), this.cCe.getImageData(), Boolean.valueOf(this.cAJ));
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
        imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.ao(this.mMaxWidth, this.mMaxHeight));
        com.baidu.adp.widget.ImageView.a a2 = this.cCD.a(imageFileInfo, false);
        if (a2 != null) {
            this.cCk = true;
            this.mProgressBar.setVisibility(8);
            this.cCH = null;
            b(a2);
            return;
        }
        this.cCD.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.2
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.ImageView.a aVar, String str2, boolean z3) {
                UrlDragImageView.this.cCk = true;
                UrlDragImageView.this.mProgressBar.setVisibility(8);
                UrlDragImageView.this.cCH = null;
                UrlDragImageView.this.b(aVar);
            }
        }, false);
    }

    private boolean pg(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null && this.cCi != null) {
            this.cCi.h(aVar.getUrl(), aVar.getByteData());
        }
        if (aVar == null || aVar.getRawBitmap() == null) {
            asL();
            return;
        }
        Bitmap rawBitmap = aVar.getRawBitmap();
        this.cCe.setLoadBigImage(true);
        if (aVar.isGif()) {
            this.cCe.setGifData(aVar.getByteData(), rawBitmap);
            this.cCe.invalidate();
            this.cCe.play();
            this.cCC = false;
            this.cCH = null;
            this.mProgressBar.setVisibility(8);
        } else {
            if (this.czt != null && this.czt.isLongPic) {
                this.cCe.createLargeImageDelegate();
                this.cCe.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.3
                    @Override // com.baidu.tbadk.widget.largeImage.logic.a
                    public void onLoadFinished() {
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.cCH = null;
                    }
                });
            } else {
                this.mProgressBar.setVisibility(8);
                this.cCH = null;
            }
            this.cCe.setImageUrlData(this.czt);
            this.cCe.setImageData(rawBitmap, aVar.getByteData());
            asQ();
        }
        asH();
    }

    private void asL() {
        if (!this.cCj) {
            this.cCe.setDefaultBitmap();
        } else {
            this.cCk = false;
        }
        this.cCH = null;
        this.mProgressBar.setVisibility(8);
    }

    public void setGifMaxUseableMem(int i) {
        this.cCe.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.cCe != null) {
            this.cCe.onDestroy();
        }
        if (this.cCg != null) {
            this.cCg.recycle();
        }
        if (this.cCn != null) {
            this.cCn.recycle();
            this.cCn = null;
        }
        if (this.mProgressBar != null) {
            this.cCH = null;
            this.mProgressBar.setVisibility(8);
        }
        e.fZ().removeCallbacks(this.cCK);
        com.baidu.tieba.view.c.cwP().setColor(-1);
    }

    public void release() {
        if (this.cCe != null) {
            this.cCe.release();
        }
        if (this.mProgressBar != null) {
            this.cCH = null;
            this.mProgressBar.setVisibility(8);
        }
        this.cCH = null;
    }

    public void asM() {
        if (this.cCe != null && this.cCe.getImageType() == 1) {
            this.cCe.stop();
        }
    }

    public void u(boolean z, boolean z2) {
        String str;
        if (this.cCe != null && (str = (String) this.cCe.getTag()) != null) {
            if (this.cCe.getImageType() == 1) {
                if (this.cCe.getGifCache() == null || !this.cCe.isLoadBigImage()) {
                    e(str, z, z2);
                }
            } else if (this.cCe.getImageType() == 2) {
                e(str, z, z2);
            } else if (asN()) {
                e(str, z, z2);
            }
        }
    }

    private boolean asN() {
        if (this.cCe.getImageBitmap() != null && this.cCe.isLoadBigImage()) {
            if (this.czt == null || !this.czt.isLongPic || this.cCe.hasLoadLongImage()) {
                return false;
            }
            this.cCk = false;
            this.cCA = false;
            return true;
        }
        return true;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.czt = imageUrlData;
    }

    public ImageUrlData getmAssistUrlData() {
        return this.czt;
    }

    public void setIsCdn(boolean z) {
        this.cAJ = z;
    }

    public void asO() {
        final String nameMd5FromUrl = as.getNameMd5FromUrl(this.czt.originalUrl);
        if (this.czt.originalProcess >= 0) {
            com.baidu.tbadk.download.d.atV().cancelDownLoadById(nameMd5FromUrl, 13);
            this.czt.originalProcess = -1;
            asQ();
            return;
        }
        if (this.cAC != null) {
            this.cAC.asT();
        }
        com.baidu.adp.base.e<?> ab = i.ab(this.mContext);
        if (ab == null) {
            ph(nameMd5FromUrl);
        } else if (!j.isNetWorkAvailable() || j.isWifiNet() || com.baidu.tbadk.core.sharedPref.b.alR().getBoolean(SharedPrefConfig.ORIGINAL_IMG_DOWN_TIP, false)) {
            ph(nameMd5FromUrl);
        } else {
            com.baidu.tbadk.core.sharedPref.b.alR().putBoolean(SharedPrefConfig.ORIGINAL_IMG_DOWN_TIP, true);
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(ab.getPageActivity());
            aVar.hU(R.string.original_img_down_no_wifi_tip);
            aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    UrlDragImageView.this.ph(nameMd5FromUrl);
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                }
            });
            aVar.b(ab);
            aVar.akO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ph(String str) {
        if (this.czt != null) {
            this.czt.originalProcess = 0;
            this.cCI.setProgress(0);
            this.cCI.setVisibility(0);
            DownloadData downloadData = new DownloadData(str);
            downloadData.setStatus(1);
            downloadData.setUrl(this.czt.originalUrl);
            downloadData.setType(13);
            downloadData.setPath(this.cCt + ap.amL().nQ(str) + "/" + str);
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.6
                @Override // com.baidu.tbadk.download.c
                public boolean onPreDownload(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2 != null) {
                        if (UrlDragImageView.this.czt != null && UrlDragImageView.this.czt.originalProcess != -1) {
                            UrlDragImageView.this.czt.originalProcess = downloadData2.getProcess();
                        }
                        if (UrlDragImageView.this.czt == null || UrlDragImageView.this.czt.originalProcess != -1) {
                            UrlDragImageView.this.cCI.setProgress(downloadData2.getProcess());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public boolean onFileDownloaded(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadSucceed(DownloadData downloadData2) {
                    UrlDragImageView.this.cCI.setVisibility(8);
                    e.fZ().postDelayed(UrlDragImageView.this.cCL, 1500L);
                    UrlDragImageView.this.cCA = false;
                    UrlDragImageView.this.cCz = UrlDragImageView.this.asP();
                    UrlDragImageView.this.asK();
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str2) {
                    UrlDragImageView.this.cCI.setVisibility(8);
                    UrlDragImageView.this.cCA = false;
                    BdToast.b(UrlDragImageView.this.mContext, str2).akS().akT();
                    UrlDragImageView.this.czt.originalProcess = -1;
                    UrlDragImageView.this.asQ();
                }
            });
            com.baidu.tbadk.download.d.atV().a(downloadData, 100);
            this.cCJ = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean asP() {
        if (this.czt != null && !StringUtils.isNull(this.czt.originalUrl, true) && this.czt.originalSize >= 0 && !this.czt.isBlockedPic) {
            String nameMd5FromUrl = as.getNameMd5FromUrl(this.czt.originalUrl);
            File file = new File(this.cCt + ap.amL().nQ(nameMd5FromUrl) + "/" + nameMd5FromUrl);
            if (file != null && file.exists()) {
                this.czt.originalProcess = 100;
                return true;
            }
            if (this.czt.originalProcess < 0) {
                asQ();
            } else {
                this.cCI.setProgress(this.czt.originalProcess);
            }
            this.cCC = true;
        } else {
            this.cCH = null;
        }
        return false;
    }

    public void asQ() {
        if (this.czt != null) {
            if (!asR() || !this.cCC) {
                this.cCH = null;
            } else if (this.czt.originalSize > 0 && !aZ(this.czt.originalSize)) {
                this.cCH = cCc + "(" + aq.getFormatSize(this.czt.originalSize) + ")";
            } else {
                this.cCH = cCc;
            }
        }
    }

    private boolean asR() {
        return (this.czt == null || !this.czt.mIsShowOrigonButton || this.czt.isBlockedPic || StringUtils.isNull(this.czt.originalUrl)) ? false : true;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.cAC = bVar;
    }

    private boolean aZ(long j) {
        return j > cCd;
    }
}
