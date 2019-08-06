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
import com.baidu.mobstat.Config;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
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
    private ImageUrlData cly;
    private b cmK;
    private boolean cmS;
    private boolean cmU;
    private boolean cmV;
    private float coA;
    private final Matrix coB;
    private Rect coC;
    private RectF coD;
    private RectF coE;
    private Rect coF;
    private Rect coG;
    private Rect coH;
    private DragImageView.d coI;
    private String coK;
    private float coL;
    private float coM;
    private float coN;
    private float coO;
    private float coP;
    private boolean coQ;
    private boolean coR;
    private boolean coS;
    public boolean coT;
    private com.baidu.tbadk.img.b coU;
    private View.OnTouchListener coV;
    private boolean coW;
    private float coX;
    private View.OnLongClickListener coY;
    private String coZ;
    protected DragImageView coo;
    protected TextView cop;
    protected SubsamplingScaleImageView coq;
    private SubsamplingScaleImageView.OnImageEventListener cor;
    private a cos;
    private boolean cot;
    private boolean cou;
    private boolean cov;
    private boolean cow;
    private boolean cox;
    private Bitmap coy;
    private boolean coz;
    private CircleProgressView cpa;
    private boolean cpb;
    private Runnable cpc;
    private Runnable cpd;
    private View.OnTouchListener cpe;
    protected Context mContext;
    private float mLastMotionX;
    private float mLastMotionY;
    private int mMaxHeight;
    private int mMaxWidth;
    private View.OnClickListener mOnClickListener;
    protected ProgressBar mProgressBar;
    private float mRatio;
    private int mSkinType;
    private String mUserId;

    /* renamed from: com  reason: collision with root package name */
    private static final String f3com = TbadkCoreApplication.getInst().getString(R.string.original_img_look);
    private static long con = Config.RAVEN_LOG_LIMIT;
    private static final int coJ = l.ah(TbadkCoreApplication.getInst()) / 5;
    private static final String TAG = UrlDragImageView.class.getSimpleName();
    private static final int TOUCH_SLOP = ViewConfiguration.get(TbadkCoreApplication.getInst()).getScaledTouchSlop();

    /* loaded from: classes3.dex */
    public interface a {
        void i(String str, byte[] bArr);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void aqP();
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
        if (this.coo != null) {
            this.coo.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.cos = aVar;
    }

    public UrlDragImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.coo = null;
        this.cos = null;
        this.cmS = false;
        this.cov = false;
        this.coz = false;
        this.mRatio = 1.0f;
        this.coA = 0.0f;
        this.coB = new Matrix();
        this.coD = new RectF();
        this.coL = 0.0f;
        this.coM = 0.0f;
        this.coN = 1.0f;
        this.coO = 1.0f;
        this.coP = 0.0f;
        this.coQ = false;
        this.coR = false;
        this.coS = false;
        this.coT = false;
        this.coW = true;
        this.coX = 0.0f;
        this.mOnClickListener = null;
        this.coY = null;
        this.coZ = null;
        this.cpc = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.coW = true;
            }
        };
        this.cpd = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.cpa.setVisibility(8);
                        UrlDragImageView.this.coZ = null;
                        UrlDragImageView.this.coT = false;
                    }
                });
            }
        };
        this.cpe = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.coV != null) {
                    UrlDragImageView.this.coV.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.coU = new com.baidu.tbadk.img.b();
        init();
    }

    public UrlDragImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.coo = null;
        this.cos = null;
        this.cmS = false;
        this.cov = false;
        this.coz = false;
        this.mRatio = 1.0f;
        this.coA = 0.0f;
        this.coB = new Matrix();
        this.coD = new RectF();
        this.coL = 0.0f;
        this.coM = 0.0f;
        this.coN = 1.0f;
        this.coO = 1.0f;
        this.coP = 0.0f;
        this.coQ = false;
        this.coR = false;
        this.coS = false;
        this.coT = false;
        this.coW = true;
        this.coX = 0.0f;
        this.mOnClickListener = null;
        this.coY = null;
        this.coZ = null;
        this.cpc = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.coW = true;
            }
        };
        this.cpd = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.cpa.setVisibility(8);
                        UrlDragImageView.this.coZ = null;
                        UrlDragImageView.this.coT = false;
                    }
                });
            }
        };
        this.cpe = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.coV != null) {
                    UrlDragImageView.this.coV.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.coU = new com.baidu.tbadk.img.b();
        init();
    }

    public DragImageView getImageView() {
        return this.coo;
    }

    public void setGifSetListener(DragImageView.e eVar) {
        this.coo.setGifSetListener(eVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.coo.setImageOnClickListener(onClickListener);
        this.coq.setOnClickListener(onClickListener);
        this.mOnClickListener = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.coY = onLongClickListener;
        if (!this.cmU) {
            this.coo.setImageOnLongClickListener(this.coY);
            this.coq.setOnLongClickListener(this.coY);
        }
    }

    public void setOnSizeChangedListener(final DragImageView.g gVar) {
        this.coo.setOnSizeChangedListener(new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.8
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (gVar != null) {
                    gVar.a(dragImageView, z, z2);
                }
                UrlDragImageView.this.aqC();
            }
        });
    }

    protected void init() {
        this.coK = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        this.mMaxWidth = l.af(this.mContext);
        this.mMaxHeight = l.ah(this.mContext) - ((int) this.mContext.getResources().getDimension(R.dimen.ds166));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.coo = new DragImageView(this.mContext);
        this.coo.setLayoutParams(layoutParams);
        this.coo.setOnTouchListener(this.cpe);
        addView(this.coo);
        this.coq = new SubsamplingScaleImageView(this.mContext);
        this.coq.setMaxScale(50.0f);
        this.coq.setOnTouchListener(this.cpe);
        this.coq.setVisibility(4);
        addView(this.coq, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(getResources().getDrawable(R.drawable.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        aqA();
    }

    private void aqA() {
        this.cpa = new CircleProgressView(this.mContext);
        this.cpa.setCircleBackgroundColor(am.getColor(R.color.cp_cont_d));
        this.cpa.setCircleForegroundColor(am.getColor(R.color.cp_link_tip_a));
        this.cpa.setProgress(0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.g(getContext(), R.dimen.tbds80), l.g(getContext(), R.dimen.tbds80));
        layoutParams.addRule(13);
        this.cpa.setVisibility(8);
        addView(this.cpa, layoutParams);
    }

    public void setIsCanDrag(boolean z) {
        this.cmU = z;
    }

    public void setIsHotSort(boolean z) {
        this.cmV = z;
    }

    public String getmCheckOriginPicText() {
        return this.coZ;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        Bitmap imageBitmap;
        int height;
        int width;
        if (this.coQ && !this.cpb && this.coq.getVisibility() == 0 && !this.coq.isImageLoaded()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.cmU || !this.cou) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.cow && motionEvent.getPointerCount() >= 2) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.cow || this.cox) {
            requestDisallowInterceptTouchEvent(true);
        }
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        float x = motionEvent.getX();
        int i = action & 255;
        if (i == 0) {
            if (this.coy == null) {
                if (this.coq.getVisibility() == 0) {
                    this.coy = f.bh(this.coq);
                } else {
                    this.coy = f.bh(this.coo);
                }
            }
            if (this.coC == null && this.coy != null) {
                int measuredWidth = getMeasuredWidth();
                float measuredWidth2 = ((getMeasuredWidth() * 1.0f) / this.coy.getWidth()) * this.coy.getHeight();
                if (measuredWidth2 > getMeasuredHeight()) {
                    measuredWidth2 = getMeasuredHeight();
                }
                RectF h = h(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
                this.coC = new Rect((int) h.left, (int) h.top, (int) h.right, (int) h.bottom);
            }
            if (this.coG == null && this.coy != null) {
                if (this.coq.getVisibility() == 0) {
                    height = this.coq.getSHeight();
                    width = this.coq.getSWidth();
                } else {
                    if (this.coo.getImageType() == 1) {
                        imageBitmap = (this.coo.getCurrentFrame() == null || this.coo.getCurrentFrame().cEF == null) ? this.coy : this.coo.getCurrentFrame().cEF;
                    } else {
                        imageBitmap = this.coo.getImageBitmap() == null ? this.coy : this.coo.getImageBitmap();
                    }
                    height = imageBitmap.getHeight();
                    width = imageBitmap.getWidth();
                }
                float ai = l.ai(getContext());
                int i2 = (int) (height * ai);
                int i3 = (int) (width * ai);
                if (i3 > this.coy.getWidth() && this.coy.getWidth() != 0) {
                    float width2 = (i3 * 1.0f) / this.coy.getWidth();
                    i3 = this.coy.getWidth();
                    i2 = (int) (i2 / width2);
                }
                if (i2 > this.coy.getHeight() && this.coy.getHeight() != 0) {
                    i3 = (int) (i3 / ((i2 * 1.0f) / this.coy.getHeight()));
                    i2 = this.coy.getHeight();
                }
                int ah = (l.ah(getContext()) - i2) / 2;
                int af = (l.af(getContext()) - i3) / 2;
                this.coG = new Rect(af, ah, i3 + af, i2 + ah);
                this.coH = new Rect(this.coG);
                this.coP = ah / l.ah(getContext());
                this.coF = new Rect(0, 0, this.coy.getWidth(), this.coy.getHeight());
            }
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (i == 2) {
            this.cow = r(this.mLastMotionX - x, this.mLastMotionY - y);
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (this.cow || this.cox) {
            this.coo.setImageOnLongClickListener(null);
            this.coq.setOnLongClickListener(null);
            z = true;
        } else {
            this.coo.setImageOnLongClickListener(this.coY);
            this.coq.setOnLongClickListener(this.coY);
            z = super.dispatchTouchEvent(motionEvent);
        }
        if (i == 1 || i == 3) {
            this.mLastMotionX = 0.0f;
            this.mLastMotionY = 0.0f;
            if (this.coA > coJ) {
                this.cox = true;
                aqB();
            } else {
                if (this.cow && this.coI != null) {
                    this.coI.axl();
                }
                this.mRatio = 1.0f;
                invalidate();
            }
            this.coz = false;
            this.coB.reset();
            this.cow = false;
            return z;
        }
        return z;
    }

    private boolean r(float f, float f2) {
        if (this.coq.getVisibility() != 0 || this.coq.isCanDrag()) {
            if (this.cly == null || !this.cly.isLongPic || this.coq.getVisibility() != 0 || this.coq.isViewTop()) {
                if (this.cly == null || !this.cly.isLongPic || this.coq.getVisibility() == 0 || this.coo.awP()) {
                    if (this.coq.getVisibility() == 0 || this.coo.awR()) {
                        if (this.coy != null && getScrollY() == 0 && f2 < 0.0f && !this.coz) {
                            this.coo.setImageOnLongClickListener(null);
                            this.coq.setOnLongClickListener(null);
                            this.coz = true;
                            this.coA = 0.0f;
                            this.mRatio = 1.0f;
                            if (this.coI != null) {
                                this.coI.axj();
                            }
                        }
                        if (!this.coz || this.coy == null) {
                            return false;
                        }
                        this.coA -= f2;
                        int measuredHeight = getMeasuredHeight();
                        if (this.coA > measuredHeight) {
                            this.coA = measuredHeight;
                        }
                        float f3 = f2 / measuredHeight;
                        this.coB.postTranslate((-f) * 1.5f * this.mRatio, (-1.5f) * f2 * this.mRatio);
                        if (this.mRatio * (1.0f + f3) > 1.0f || this.coA < 0.0f) {
                            this.coB.preScale(1.0f / this.mRatio, 1.0f / this.mRatio, (this.mRatio * this.coy.getWidth()) / 2.0f, this.mRatio * (this.coy.getHeight() / 2));
                            this.mRatio = 1.0f;
                        } else {
                            this.coB.preScale(1.0f + f3, 1.0f + f3, (this.mRatio * this.coy.getWidth()) / 2.0f, this.mRatio * (this.coy.getHeight() / 2));
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
        if (this.cow && this.coy != null && !this.coy.isRecycled() && this.coz) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.coD == null) {
                this.coD = new RectF();
            }
            this.coB.mapRect(this.coD, new RectF(this.coC));
            canvas.drawBitmap(this.coy, this.coF, this.coD, (Paint) null);
        } else if (this.cox && this.coy != null && !this.coy.isRecycled()) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.cly == null || this.cly.getSourceImageRectInScreen() == null) {
                canvas.drawBitmap(this.coy, this.coF, this.coD, (Paint) null);
            } else {
                canvas.drawBitmap(this.coy, this.coG, this.coD, (Paint) null);
            }
        } else {
            super.dispatchDraw(canvas);
        }
    }

    private void aqB() {
        if (this.cly == null) {
            if (this.coI != null) {
                this.coI.axk();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.cly.getSourceImageRectInScreen();
        final Rect dstRectInScreen = this.cly.getDstRectInScreen();
        if (sourceImageRectInScreen == null || dstRectInScreen == null) {
            if (this.coI != null) {
                this.coI.axk();
                return;
            }
            return;
        }
        a(sourceImageRectInScreen, dstRectInScreen);
        f(sourceImageRectInScreen);
        this.coE = new RectF(this.coD);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(150L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && sourceImageRectInScreen != null && dstRectInScreen != null) {
                    UrlDragImageView.this.ap(valueAnimator.getAnimatedFraction());
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
                UrlDragImageView.this.coz = false;
                UrlDragImageView.this.invalidate();
                if (UrlDragImageView.this.coI != null) {
                    UrlDragImageView.this.coI.axk();
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

    private void f(Rect rect) {
        if (rect != null) {
            float f = ((rect.bottom - rect.top) / (rect.right - rect.left)) * (this.coD.right - this.coD.left);
            this.coD.top += this.coD.height() * this.coP;
            this.coD.bottom = f + this.coD.top;
        }
    }

    public void setCanScale(boolean z) {
        if (this.coo != null) {
            this.coo.setCanScale(z);
        }
    }

    private void a(Rect rect, Rect rect2) {
        this.coL = 0.0f;
        this.coM = 0.0f;
        this.coN = 1.0f;
        this.coO = 1.0f;
        if (rect != null && rect2 != null && rect.contains(rect2)) {
            this.coL = (rect2.left - rect.left) / rect.width();
            this.coM = (rect2.top - rect.top) / rect.height();
            this.coN = (rect2.right - rect.left) / rect.width();
            this.coO = (rect2.bottom - rect.top) / rect.height();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(float f) {
        if (this.coG != null) {
            this.coG.left = (int) (this.coH.left + (this.coH.width() * this.coL * f));
            this.coG.top = (int) (this.coH.top + (this.coH.height() * this.coM * f));
            this.coG.right = (int) (this.coH.left + (this.coH.width() * (((1.0f - this.coN) * (1.0f - f)) + this.coN)));
            this.coG.bottom = (int) (this.coH.top + (this.coH.height() * (((1.0f - this.coO) * (1.0f - f)) + this.coO)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Rect rect, float f) {
        if (this.coD != null && rect != null) {
            this.coD.left = this.coE.left + ((rect.left - this.coE.left) * f);
            this.coD.top = this.coE.top + ((rect.top - this.coE.top) * f);
            this.coD.right = this.coE.right + ((rect.right - this.coE.right) * f);
            this.coD.bottom = this.coE.bottom + ((rect.bottom - this.coE.bottom) * f);
        }
    }

    private RectF h(float f, float f2, float f3, float f4) {
        return new RectF(f - (f3 / 2.0f), f2 - (f4 / 2.0f), (f3 / 2.0f) + f, (f4 / 2.0f) + f2);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.coV = onTouchListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqC() {
        if ((this.cot || this.cou) && this.cly != null && this.cly.mPicType == 1 && !TextUtils.isEmpty(this.cly.mTagName)) {
            if (this.cop != null) {
                this.cop.setVisibility(8);
                this.cop = null;
            }
            this.cop = new TextView(this.mContext);
            this.cop.setText(this.cly.mTagName);
            this.cop.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize26));
            am.d(this.cop, R.color.common_color_10013, 1, 0);
            am.l(this.cop, R.color.common_color_10215);
            this.cop.setAlpha(0.75f);
            this.cop.setIncludeFontPadding(false);
            this.cop.setGravity(17);
            int g = l.g(this.mContext, R.dimen.ds2);
            this.cop.setPadding(g, g, g, g);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.coo.getBottomOffset();
            layoutParams.leftMargin = this.coo.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.cop, layoutParams);
            this.cop.setVisibility(0);
        }
    }

    public void setUrl(String str, boolean z) {
        if (str.contains("*")) {
            str = str.split("[*]")[0];
        }
        this.coo.setTag(str);
        this.coo.setLoadBigImage(false);
        this.coo.setImageDrawable(null);
        this.cot = false;
        this.cou = false;
        this.coQ = aqK();
        this.coZ = null;
        if (pK(str)) {
            e(str, z, false);
        }
    }

    private boolean aqD() {
        return this.coo != null && this.coo.axh();
    }

    public void aqE() {
        if (this.cly != null && !aqD()) {
            String str = this.cly.imageUrl;
            int i = this.cly.urlType;
            com.baidu.adp.widget.ImageView.a aVar = null;
            if (com.baidu.tbadk.core.util.d.a.U(str, i)) {
                aVar = com.baidu.tbadk.core.util.d.a.V(str, i);
            }
            if (aVar != null) {
                setThumbBitmapToView(aVar);
            }
        }
    }

    private boolean eV(boolean z) {
        String oj;
        if (!this.coR || z) {
            this.coR = true;
            if (!this.coQ || this.cly == null || StringUtils.isNull(this.cly.originalUrl, true) || this.cly.originalSize < 0 || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String str = this.coK + ap.ajl().nW(oj) + "/" + at.oj(this.cly.originalUrl);
            final int[] ny = m.ny(str);
            this.coq.setVisibility(0);
            if (this.cor == null) {
                this.cor = new SubsamplingScaleImageView.OnImageEventListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12
                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onReady() {
                        UrlDragImageView.this.coZ = null;
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.coo.axb();
                        UrlDragImageView.this.coo.setVisibility(4);
                    }

                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onImageLoaded() {
                        if (UrlDragImageView.this.cly.isLongPic && ny[0] > 0) {
                            UrlDragImageView.this.coo.onDestroy();
                            final float measuredWidth = (UrlDragImageView.this.getMeasuredWidth() * 1.0f) / ny[0];
                            final PointF pointF = new PointF((ny[0] * 1.0f) / 2.0f, 0.0f);
                            UrlDragImageView.this.coq.setScaleAndCenter(measuredWidth, pointF);
                            UrlDragImageView.this.coq.setMaxScale(2.0f * measuredWidth);
                            UrlDragImageView.this.coq.setDoubleTapZoomScale(2.0f * measuredWidth);
                            UrlDragImageView.this.coq.setInitScale(measuredWidth);
                            UrlDragImageView.this.coq.setDoubleTapZoomStyle(4);
                            UrlDragImageView.this.coq.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12.1
                                @Override // android.view.View.OnTouchListener
                                public boolean onTouch(View view, MotionEvent motionEvent) {
                                    if (UrlDragImageView.this.coV != null) {
                                        UrlDragImageView.this.coV.onTouch(view, motionEvent);
                                    }
                                    switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                                        case 0:
                                            UrlDragImageView.this.coX = motionEvent.getY();
                                            UrlDragImageView.this.coq.setOnClickListener(UrlDragImageView.this.coW ? UrlDragImageView.this.mOnClickListener : null);
                                            UrlDragImageView.this.coq.setOnLongClickListener(UrlDragImageView.this.coW ? UrlDragImageView.this.coY : null);
                                            break;
                                        case 1:
                                        case 3:
                                            if (UrlDragImageView.this.coq.getScale() < measuredWidth) {
                                                UrlDragImageView.this.coq.setScaleAndCenter(measuredWidth, pointF);
                                            }
                                            e.iK().removeCallbacks(UrlDragImageView.this.cpc);
                                            e.iK().postDelayed(UrlDragImageView.this.cpc, 1000L);
                                            break;
                                        case 2:
                                            if (Math.abs(motionEvent.getY() - UrlDragImageView.this.coX) > UrlDragImageView.TOUCH_SLOP) {
                                                UrlDragImageView.this.coW = false;
                                                UrlDragImageView.this.coq.setOnClickListener(null);
                                                UrlDragImageView.this.coq.setOnLongClickListener(null);
                                            }
                                            UrlDragImageView.this.coX = motionEvent.getY();
                                            break;
                                    }
                                    return false;
                                }
                            });
                            UrlDragImageView.this.coo.setVisibility(4);
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
            this.coq.setOnImageEventListener(this.cor);
            if (this.coq.isImageLoaded() && this.cly.isLongPic) {
                this.cor.onImageLoaded();
            } else {
                this.coq.setImage(ImageSource.uri(str));
            }
            return true;
        }
        return false;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.coI = dVar;
        if (this.coo != null) {
            this.coo.setDragToExitListener(dVar);
        }
    }

    public void aqF() {
        eV(false);
    }

    private boolean pK(String str) {
        return j.kc() || com.baidu.tbadk.core.util.d.c.oC(str);
    }

    private void setThumbBitmapToView(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap nK;
        if (!this.cou && aVar != null && (nK = aVar.nK()) != null) {
            this.cot = true;
            if (aVar.isGif()) {
                this.coo.setImageUrlData(this.cly);
                this.coo.setImageBitmap(nK);
                this.coZ = null;
                this.coT = false;
            } else {
                if (this.cly != null && this.cly.isLongPic) {
                    this.coo.awU();
                    this.coo.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.13
                        @Override // com.baidu.tbadk.widget.largeImage.logic.a
                        public void aqO() {
                        }
                    });
                }
                this.coo.setImageUrlData(this.cly);
                this.coo.setImageData(nK, aVar.nP());
            }
            aqC();
        }
    }

    private void e(String str, boolean z, boolean z2) {
        if (pL(str)) {
            if (z2 || (!this.cov && !this.cou)) {
                if (!z2 || !eV(true)) {
                    this.cov = true;
                    com.baidu.adp.lib.f.c.iE().a(str, 27, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.14
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onCancelled(String str2) {
                            UrlDragImageView.this.cov = false;
                            UrlDragImageView.this.coo.setVisibility(0);
                            UrlDragImageView.this.mProgressBar.setVisibility(8);
                            UrlDragImageView.this.coZ = null;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            UrlDragImageView.this.cov = false;
                            UrlDragImageView.this.cou = true;
                            UrlDragImageView.this.b(aVar);
                        }
                    }, 0, 0, false, null, Boolean.valueOf(z), this.coo.getImageData(), Boolean.valueOf(this.cmS));
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
        imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.al(this.mMaxWidth, this.mMaxHeight));
        com.baidu.adp.widget.ImageView.a a2 = this.coU.a(imageFileInfo, false);
        if (a2 != null) {
            this.cou = true;
            this.mProgressBar.setVisibility(8);
            this.coZ = null;
            b(a2);
            return;
        }
        this.coU.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.2
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.ImageView.a aVar, String str2, boolean z3) {
                UrlDragImageView.this.cou = true;
                UrlDragImageView.this.mProgressBar.setVisibility(8);
                UrlDragImageView.this.coZ = null;
                UrlDragImageView.this.b(aVar);
            }
        }, false);
    }

    private boolean pL(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null && this.cos != null) {
            this.cos.i(aVar.getUrl(), aVar.nP());
        }
        if (aVar == null || aVar.nK() == null) {
            aqG();
            return;
        }
        Bitmap nK = aVar.nK();
        this.coo.setLoadBigImage(true);
        if (aVar.isGif()) {
            this.coo.setGifData(aVar.nP(), nK);
            this.coo.invalidate();
            this.coo.play();
            this.coT = false;
            this.coZ = null;
            this.mProgressBar.setVisibility(8);
        } else {
            if (this.cly != null && this.cly.isLongPic) {
                this.coo.awU();
                this.coo.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.3
                    @Override // com.baidu.tbadk.widget.largeImage.logic.a
                    public void aqO() {
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.coZ = null;
                    }
                });
            } else {
                this.mProgressBar.setVisibility(8);
                this.coZ = null;
            }
            this.coo.setImageUrlData(this.cly);
            this.coo.setImageData(nK, aVar.nP());
            aqL();
        }
        aqC();
    }

    private void aqG() {
        if (!this.cot) {
            this.coo.setDefaultBitmap();
        } else {
            this.cou = false;
        }
        this.coZ = null;
        this.mProgressBar.setVisibility(8);
    }

    public void setGifMaxUseableMem(int i) {
        this.coo.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.coo != null) {
            this.coo.onDestroy();
        }
        if (this.coq != null) {
            this.coq.recycle();
        }
        if (this.coy != null) {
            this.coy.recycle();
            this.coy = null;
        }
        if (this.mProgressBar != null) {
            this.coZ = null;
            this.mProgressBar.setVisibility(8);
        }
        e.iK().removeCallbacks(this.cpc);
        com.baidu.tieba.view.c.cyn().setColor(-1);
    }

    public void release() {
        if (this.coo != null) {
            this.coo.release();
        }
        if (this.mProgressBar != null) {
            this.coZ = null;
            this.mProgressBar.setVisibility(8);
        }
        this.coZ = null;
    }

    public void aqH() {
        if (this.coo != null && this.coo.getImageType() == 1) {
            this.coo.stop();
        }
    }

    public void r(boolean z, boolean z2) {
        String str;
        if (this.coo != null && (str = (String) this.coo.getTag()) != null) {
            if (this.coo.getImageType() == 1) {
                if (this.coo.getGifCache() == null || !this.coo.axh()) {
                    e(str, z, z2);
                }
            } else if (this.coo.getImageType() == 2) {
                e(str, z, z2);
            } else if (aqI()) {
                e(str, z, z2);
            }
        }
    }

    private boolean aqI() {
        if (this.coo.getImageBitmap() != null && this.coo.axh()) {
            if (this.cly == null || !this.cly.isLongPic || this.coo.awV()) {
                return false;
            }
            this.cou = false;
            this.coR = false;
            return true;
        }
        return true;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.cly = imageUrlData;
    }

    public ImageUrlData getmAssistUrlData() {
        return this.cly;
    }

    public void setIsCdn(boolean z) {
        this.cmS = z;
    }

    public void aqJ() {
        final String oj = at.oj(this.cly.originalUrl);
        if (this.cly.originalProcess >= 0) {
            com.baidu.tbadk.download.d.arU().Y(oj, 13);
            this.cly.originalProcess = -1;
            aqL();
            return;
        }
        if (this.cmK != null) {
            this.cmK.aqP();
        }
        com.baidu.adp.base.e<?> ab = i.ab(this.mContext);
        if (ab == null) {
            pM(oj);
        } else if (!j.kc() || j.kd() || com.baidu.tbadk.core.sharedPref.b.ahQ().getBoolean("original_img_down_tip", false)) {
            pM(oj);
        } else {
            com.baidu.tbadk.core.sharedPref.b.ahQ().putBoolean("original_img_down_tip", true);
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(ab.getPageActivity());
            aVar.hu(R.string.original_img_down_no_wifi_tip);
            aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    UrlDragImageView.this.pM(oj);
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                }
            });
            aVar.b(ab);
            aVar.agK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pM(String str) {
        if (this.cly != null) {
            this.cly.originalProcess = 0;
            this.cpa.setProgress(0);
            this.cpa.setVisibility(0);
            DownloadData downloadData = new DownloadData(str);
            downloadData.setStatus(1);
            downloadData.setUrl(this.cly.originalUrl);
            downloadData.setType(13);
            downloadData.setPath(this.coK + ap.ajl().nW(str) + "/" + str);
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.6
                @Override // com.baidu.tbadk.download.c
                public boolean onPreDownload(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2 != null) {
                        if (UrlDragImageView.this.cly != null && UrlDragImageView.this.cly.originalProcess != -1) {
                            UrlDragImageView.this.cly.originalProcess = downloadData2.getProcess();
                        }
                        if (UrlDragImageView.this.cly == null || UrlDragImageView.this.cly.originalProcess != -1) {
                            UrlDragImageView.this.cpa.setProgress(downloadData2.getProcess());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public boolean onFileDownloaded(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadSucceed(DownloadData downloadData2) {
                    UrlDragImageView.this.cpa.setVisibility(8);
                    e.iK().postDelayed(UrlDragImageView.this.cpd, 1500L);
                    UrlDragImageView.this.coR = false;
                    UrlDragImageView.this.coQ = UrlDragImageView.this.aqK();
                    UrlDragImageView.this.aqF();
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str2) {
                    UrlDragImageView.this.cpa.setVisibility(8);
                    UrlDragImageView.this.coR = false;
                    BdToast.b(UrlDragImageView.this.mContext, str2).agQ().agS();
                    UrlDragImageView.this.cly.originalProcess = -1;
                    UrlDragImageView.this.aqL();
                }
            });
            com.baidu.tbadk.download.d.arU().a(downloadData, 100);
            this.cpb = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aqK() {
        if (this.cly != null && !StringUtils.isNull(this.cly.originalUrl, true) && this.cly.originalSize >= 0 && !this.cly.isBlockedPic) {
            String oj = at.oj(this.cly.originalUrl);
            File file = new File(this.coK + ap.ajl().nW(oj) + "/" + oj);
            if (file != null && file.exists()) {
                this.cly.originalProcess = 100;
                return true;
            }
            if (this.cly.originalProcess < 0) {
                aqL();
            } else {
                this.cpa.setProgress(this.cly.originalProcess);
            }
            this.coT = true;
        } else {
            this.coZ = null;
        }
        return false;
    }

    public void aqL() {
        if (this.cly != null) {
            if (!aqM() || !this.coT) {
                this.coZ = null;
            } else if (this.cly.originalSize > 0 && !bf(this.cly.originalSize)) {
                this.coZ = f3com + "(" + aq.aU(this.cly.originalSize) + ")";
            } else {
                this.coZ = f3com;
            }
        }
    }

    private boolean aqM() {
        return (this.cly == null || !this.cly.mIsShowOrigonButton || this.cly.isBlockedPic || StringUtils.isNull(this.cly.originalUrl)) ? false : true;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.cmK = bVar;
    }

    private boolean bf(long j) {
        return j > con;
    }
}
