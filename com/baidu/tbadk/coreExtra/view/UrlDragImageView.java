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
    private ImageUrlData clr;
    private b cmD;
    private boolean cmL;
    private boolean cmN;
    private boolean cmO;
    private Rect coA;
    private DragImageView.d coB;
    private String coD;
    private float coE;
    private float coF;
    private float coG;
    private float coH;
    private float coI;
    private boolean coJ;
    private boolean coK;
    private boolean coL;
    public boolean coM;
    private com.baidu.tbadk.img.b coN;
    private View.OnTouchListener coO;
    private boolean coP;
    private float coQ;
    private View.OnLongClickListener coR;
    private String coS;
    private CircleProgressView coT;
    private boolean coU;
    private Runnable coV;
    private Runnable coW;
    private View.OnTouchListener coX;
    protected DragImageView coh;
    protected TextView coi;
    protected SubsamplingScaleImageView coj;
    private SubsamplingScaleImageView.OnImageEventListener cok;
    private a col;

    /* renamed from: com  reason: collision with root package name */
    private boolean f3com;
    private boolean con;
    private boolean coo;
    private boolean cop;
    private boolean coq;
    private Bitmap cor;
    private boolean cos;
    private float cot;
    private final Matrix cou;
    private Rect cov;
    private RectF cow;
    private RectF cox;
    private Rect coy;
    private Rect coz;
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
    private static final String cof = TbadkCoreApplication.getInst().getString(R.string.original_img_look);
    private static long cog = Config.RAVEN_LOG_LIMIT;
    private static final int coC = l.ah(TbadkCoreApplication.getInst()) / 5;
    private static final String TAG = UrlDragImageView.class.getSimpleName();
    private static final int TOUCH_SLOP = ViewConfiguration.get(TbadkCoreApplication.getInst()).getScaledTouchSlop();

    /* loaded from: classes3.dex */
    public interface a {
        void i(String str, byte[] bArr);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void aqN();
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
        if (this.coh != null) {
            this.coh.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.col = aVar;
    }

    public UrlDragImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.coh = null;
        this.col = null;
        this.cmL = false;
        this.coo = false;
        this.cos = false;
        this.mRatio = 1.0f;
        this.cot = 0.0f;
        this.cou = new Matrix();
        this.cow = new RectF();
        this.coE = 0.0f;
        this.coF = 0.0f;
        this.coG = 1.0f;
        this.coH = 1.0f;
        this.coI = 0.0f;
        this.coJ = false;
        this.coK = false;
        this.coL = false;
        this.coM = false;
        this.coP = true;
        this.coQ = 0.0f;
        this.mOnClickListener = null;
        this.coR = null;
        this.coS = null;
        this.coV = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.coP = true;
            }
        };
        this.coW = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.coT.setVisibility(8);
                        UrlDragImageView.this.coS = null;
                        UrlDragImageView.this.coM = false;
                    }
                });
            }
        };
        this.coX = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.coO != null) {
                    UrlDragImageView.this.coO.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.coN = new com.baidu.tbadk.img.b();
        init();
    }

    public UrlDragImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.coh = null;
        this.col = null;
        this.cmL = false;
        this.coo = false;
        this.cos = false;
        this.mRatio = 1.0f;
        this.cot = 0.0f;
        this.cou = new Matrix();
        this.cow = new RectF();
        this.coE = 0.0f;
        this.coF = 0.0f;
        this.coG = 1.0f;
        this.coH = 1.0f;
        this.coI = 0.0f;
        this.coJ = false;
        this.coK = false;
        this.coL = false;
        this.coM = false;
        this.coP = true;
        this.coQ = 0.0f;
        this.mOnClickListener = null;
        this.coR = null;
        this.coS = null;
        this.coV = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.coP = true;
            }
        };
        this.coW = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.coT.setVisibility(8);
                        UrlDragImageView.this.coS = null;
                        UrlDragImageView.this.coM = false;
                    }
                });
            }
        };
        this.coX = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.coO != null) {
                    UrlDragImageView.this.coO.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.coN = new com.baidu.tbadk.img.b();
        init();
    }

    public DragImageView getImageView() {
        return this.coh;
    }

    public void setGifSetListener(DragImageView.e eVar) {
        this.coh.setGifSetListener(eVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.coh.setImageOnClickListener(onClickListener);
        this.coj.setOnClickListener(onClickListener);
        this.mOnClickListener = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.coR = onLongClickListener;
        if (!this.cmN) {
            this.coh.setImageOnLongClickListener(this.coR);
            this.coj.setOnLongClickListener(this.coR);
        }
    }

    public void setOnSizeChangedListener(final DragImageView.g gVar) {
        this.coh.setOnSizeChangedListener(new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.8
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (gVar != null) {
                    gVar.a(dragImageView, z, z2);
                }
                UrlDragImageView.this.aqA();
            }
        });
    }

    protected void init() {
        this.coD = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        this.mMaxWidth = l.af(this.mContext);
        this.mMaxHeight = l.ah(this.mContext) - ((int) this.mContext.getResources().getDimension(R.dimen.ds166));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.coh = new DragImageView(this.mContext);
        this.coh.setLayoutParams(layoutParams);
        this.coh.setOnTouchListener(this.coX);
        addView(this.coh);
        this.coj = new SubsamplingScaleImageView(this.mContext);
        this.coj.setMaxScale(50.0f);
        this.coj.setOnTouchListener(this.coX);
        this.coj.setVisibility(4);
        addView(this.coj, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(getResources().getDrawable(R.drawable.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        aqy();
    }

    private void aqy() {
        this.coT = new CircleProgressView(this.mContext);
        this.coT.setCircleBackgroundColor(am.getColor(R.color.cp_cont_d));
        this.coT.setCircleForegroundColor(am.getColor(R.color.cp_link_tip_a));
        this.coT.setProgress(0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.g(getContext(), R.dimen.tbds80), l.g(getContext(), R.dimen.tbds80));
        layoutParams.addRule(13);
        this.coT.setVisibility(8);
        addView(this.coT, layoutParams);
    }

    public void setIsCanDrag(boolean z) {
        this.cmN = z;
    }

    public void setIsHotSort(boolean z) {
        this.cmO = z;
    }

    public String getmCheckOriginPicText() {
        return this.coS;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        Bitmap imageBitmap;
        int height;
        int width;
        if (this.coJ && !this.coU && this.coj.getVisibility() == 0 && !this.coj.isImageLoaded()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.cmN || !this.con) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.cop && motionEvent.getPointerCount() >= 2) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.cop || this.coq) {
            requestDisallowInterceptTouchEvent(true);
        }
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        float x = motionEvent.getX();
        int i = action & 255;
        if (i == 0) {
            if (this.cor == null) {
                if (this.coj.getVisibility() == 0) {
                    this.cor = f.bh(this.coj);
                } else {
                    this.cor = f.bh(this.coh);
                }
            }
            if (this.cov == null && this.cor != null) {
                int measuredWidth = getMeasuredWidth();
                float measuredWidth2 = ((getMeasuredWidth() * 1.0f) / this.cor.getWidth()) * this.cor.getHeight();
                if (measuredWidth2 > getMeasuredHeight()) {
                    measuredWidth2 = getMeasuredHeight();
                }
                RectF h = h(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
                this.cov = new Rect((int) h.left, (int) h.top, (int) h.right, (int) h.bottom);
            }
            if (this.coz == null && this.cor != null) {
                if (this.coj.getVisibility() == 0) {
                    height = this.coj.getSHeight();
                    width = this.coj.getSWidth();
                } else {
                    if (this.coh.getImageType() == 1) {
                        imageBitmap = (this.coh.getCurrentFrame() == null || this.coh.getCurrentFrame().cEy == null) ? this.cor : this.coh.getCurrentFrame().cEy;
                    } else {
                        imageBitmap = this.coh.getImageBitmap() == null ? this.cor : this.coh.getImageBitmap();
                    }
                    height = imageBitmap.getHeight();
                    width = imageBitmap.getWidth();
                }
                float ai = l.ai(getContext());
                int i2 = (int) (height * ai);
                int i3 = (int) (width * ai);
                if (i3 > this.cor.getWidth() && this.cor.getWidth() != 0) {
                    float width2 = (i3 * 1.0f) / this.cor.getWidth();
                    i3 = this.cor.getWidth();
                    i2 = (int) (i2 / width2);
                }
                if (i2 > this.cor.getHeight() && this.cor.getHeight() != 0) {
                    i3 = (int) (i3 / ((i2 * 1.0f) / this.cor.getHeight()));
                    i2 = this.cor.getHeight();
                }
                int ah = (l.ah(getContext()) - i2) / 2;
                int af = (l.af(getContext()) - i3) / 2;
                this.coz = new Rect(af, ah, i3 + af, i2 + ah);
                this.coA = new Rect(this.coz);
                this.coI = ah / l.ah(getContext());
                this.coy = new Rect(0, 0, this.cor.getWidth(), this.cor.getHeight());
            }
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (i == 2) {
            this.cop = r(this.mLastMotionX - x, this.mLastMotionY - y);
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (this.cop || this.coq) {
            this.coh.setImageOnLongClickListener(null);
            this.coj.setOnLongClickListener(null);
            z = true;
        } else {
            this.coh.setImageOnLongClickListener(this.coR);
            this.coj.setOnLongClickListener(this.coR);
            z = super.dispatchTouchEvent(motionEvent);
        }
        if (i == 1 || i == 3) {
            this.mLastMotionX = 0.0f;
            this.mLastMotionY = 0.0f;
            if (this.cot > coC) {
                this.coq = true;
                aqz();
            } else {
                if (this.cop && this.coB != null) {
                    this.coB.axj();
                }
                this.mRatio = 1.0f;
                invalidate();
            }
            this.cos = false;
            this.cou.reset();
            this.cop = false;
            return z;
        }
        return z;
    }

    private boolean r(float f, float f2) {
        if (this.coj.getVisibility() != 0 || this.coj.isCanDrag()) {
            if (this.clr == null || !this.clr.isLongPic || this.coj.getVisibility() != 0 || this.coj.isViewTop()) {
                if (this.clr == null || !this.clr.isLongPic || this.coj.getVisibility() == 0 || this.coh.awN()) {
                    if (this.coj.getVisibility() == 0 || this.coh.awP()) {
                        if (this.cor != null && getScrollY() == 0 && f2 < 0.0f && !this.cos) {
                            this.coh.setImageOnLongClickListener(null);
                            this.coj.setOnLongClickListener(null);
                            this.cos = true;
                            this.cot = 0.0f;
                            this.mRatio = 1.0f;
                            if (this.coB != null) {
                                this.coB.axh();
                            }
                        }
                        if (!this.cos || this.cor == null) {
                            return false;
                        }
                        this.cot -= f2;
                        int measuredHeight = getMeasuredHeight();
                        if (this.cot > measuredHeight) {
                            this.cot = measuredHeight;
                        }
                        float f3 = f2 / measuredHeight;
                        this.cou.postTranslate((-f) * 1.5f * this.mRatio, (-1.5f) * f2 * this.mRatio);
                        if (this.mRatio * (1.0f + f3) > 1.0f || this.cot < 0.0f) {
                            this.cou.preScale(1.0f / this.mRatio, 1.0f / this.mRatio, (this.mRatio * this.cor.getWidth()) / 2.0f, this.mRatio * (this.cor.getHeight() / 2));
                            this.mRatio = 1.0f;
                        } else {
                            this.cou.preScale(1.0f + f3, 1.0f + f3, (this.mRatio * this.cor.getWidth()) / 2.0f, this.mRatio * (this.cor.getHeight() / 2));
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
        if (this.cop && this.cor != null && !this.cor.isRecycled() && this.cos) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.cow == null) {
                this.cow = new RectF();
            }
            this.cou.mapRect(this.cow, new RectF(this.cov));
            canvas.drawBitmap(this.cor, this.coy, this.cow, (Paint) null);
        } else if (this.coq && this.cor != null && !this.cor.isRecycled()) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.clr == null || this.clr.getSourceImageRectInScreen() == null) {
                canvas.drawBitmap(this.cor, this.coy, this.cow, (Paint) null);
            } else {
                canvas.drawBitmap(this.cor, this.coz, this.cow, (Paint) null);
            }
        } else {
            super.dispatchDraw(canvas);
        }
    }

    private void aqz() {
        if (this.clr == null) {
            if (this.coB != null) {
                this.coB.axi();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.clr.getSourceImageRectInScreen();
        final Rect dstRectInScreen = this.clr.getDstRectInScreen();
        if (sourceImageRectInScreen == null || dstRectInScreen == null) {
            if (this.coB != null) {
                this.coB.axi();
                return;
            }
            return;
        }
        a(sourceImageRectInScreen, dstRectInScreen);
        f(sourceImageRectInScreen);
        this.cox = new RectF(this.cow);
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
                UrlDragImageView.this.cos = false;
                UrlDragImageView.this.invalidate();
                if (UrlDragImageView.this.coB != null) {
                    UrlDragImageView.this.coB.axi();
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
            float f = ((rect.bottom - rect.top) / (rect.right - rect.left)) * (this.cow.right - this.cow.left);
            this.cow.top += this.cow.height() * this.coI;
            this.cow.bottom = f + this.cow.top;
        }
    }

    public void setCanScale(boolean z) {
        if (this.coh != null) {
            this.coh.setCanScale(z);
        }
    }

    private void a(Rect rect, Rect rect2) {
        this.coE = 0.0f;
        this.coF = 0.0f;
        this.coG = 1.0f;
        this.coH = 1.0f;
        if (rect != null && rect2 != null && rect.contains(rect2)) {
            this.coE = (rect2.left - rect.left) / rect.width();
            this.coF = (rect2.top - rect.top) / rect.height();
            this.coG = (rect2.right - rect.left) / rect.width();
            this.coH = (rect2.bottom - rect.top) / rect.height();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(float f) {
        if (this.coz != null) {
            this.coz.left = (int) (this.coA.left + (this.coA.width() * this.coE * f));
            this.coz.top = (int) (this.coA.top + (this.coA.height() * this.coF * f));
            this.coz.right = (int) (this.coA.left + (this.coA.width() * (((1.0f - this.coG) * (1.0f - f)) + this.coG)));
            this.coz.bottom = (int) (this.coA.top + (this.coA.height() * (((1.0f - this.coH) * (1.0f - f)) + this.coH)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Rect rect, float f) {
        if (this.cow != null && rect != null) {
            this.cow.left = this.cox.left + ((rect.left - this.cox.left) * f);
            this.cow.top = this.cox.top + ((rect.top - this.cox.top) * f);
            this.cow.right = this.cox.right + ((rect.right - this.cox.right) * f);
            this.cow.bottom = this.cox.bottom + ((rect.bottom - this.cox.bottom) * f);
        }
    }

    private RectF h(float f, float f2, float f3, float f4) {
        return new RectF(f - (f3 / 2.0f), f2 - (f4 / 2.0f), (f3 / 2.0f) + f, (f4 / 2.0f) + f2);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.coO = onTouchListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqA() {
        if ((this.f3com || this.con) && this.clr != null && this.clr.mPicType == 1 && !TextUtils.isEmpty(this.clr.mTagName)) {
            if (this.coi != null) {
                this.coi.setVisibility(8);
                this.coi = null;
            }
            this.coi = new TextView(this.mContext);
            this.coi.setText(this.clr.mTagName);
            this.coi.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize26));
            am.d(this.coi, R.color.common_color_10013, 1, 0);
            am.l(this.coi, R.color.common_color_10215);
            this.coi.setAlpha(0.75f);
            this.coi.setIncludeFontPadding(false);
            this.coi.setGravity(17);
            int g = l.g(this.mContext, R.dimen.ds2);
            this.coi.setPadding(g, g, g, g);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.coh.getBottomOffset();
            layoutParams.leftMargin = this.coh.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.coi, layoutParams);
            this.coi.setVisibility(0);
        }
    }

    public void setUrl(String str, boolean z) {
        if (str.contains("*")) {
            str = str.split("[*]")[0];
        }
        this.coh.setTag(str);
        this.coh.setLoadBigImage(false);
        this.coh.setImageDrawable(null);
        this.f3com = false;
        this.con = false;
        this.coJ = aqI();
        this.coS = null;
        if (pK(str)) {
            e(str, z, false);
        }
    }

    private boolean aqB() {
        return this.coh != null && this.coh.axf();
    }

    public void aqC() {
        if (this.clr != null && !aqB()) {
            String str = this.clr.imageUrl;
            int i = this.clr.urlType;
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
        if (!this.coK || z) {
            this.coK = true;
            if (!this.coJ || this.clr == null || StringUtils.isNull(this.clr.originalUrl, true) || this.clr.originalSize < 0 || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String str = this.coD + ap.ajj().nW(oj) + "/" + at.oj(this.clr.originalUrl);
            final int[] ny = m.ny(str);
            this.coj.setVisibility(0);
            if (this.cok == null) {
                this.cok = new SubsamplingScaleImageView.OnImageEventListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12
                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onReady() {
                        UrlDragImageView.this.coS = null;
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.coh.awZ();
                        UrlDragImageView.this.coh.setVisibility(4);
                    }

                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onImageLoaded() {
                        if (UrlDragImageView.this.clr.isLongPic && ny[0] > 0) {
                            UrlDragImageView.this.coh.onDestroy();
                            final float measuredWidth = (UrlDragImageView.this.getMeasuredWidth() * 1.0f) / ny[0];
                            final PointF pointF = new PointF((ny[0] * 1.0f) / 2.0f, 0.0f);
                            UrlDragImageView.this.coj.setScaleAndCenter(measuredWidth, pointF);
                            UrlDragImageView.this.coj.setMaxScale(2.0f * measuredWidth);
                            UrlDragImageView.this.coj.setDoubleTapZoomScale(2.0f * measuredWidth);
                            UrlDragImageView.this.coj.setInitScale(measuredWidth);
                            UrlDragImageView.this.coj.setDoubleTapZoomStyle(4);
                            UrlDragImageView.this.coj.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12.1
                                @Override // android.view.View.OnTouchListener
                                public boolean onTouch(View view, MotionEvent motionEvent) {
                                    if (UrlDragImageView.this.coO != null) {
                                        UrlDragImageView.this.coO.onTouch(view, motionEvent);
                                    }
                                    switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                                        case 0:
                                            UrlDragImageView.this.coQ = motionEvent.getY();
                                            UrlDragImageView.this.coj.setOnClickListener(UrlDragImageView.this.coP ? UrlDragImageView.this.mOnClickListener : null);
                                            UrlDragImageView.this.coj.setOnLongClickListener(UrlDragImageView.this.coP ? UrlDragImageView.this.coR : null);
                                            break;
                                        case 1:
                                        case 3:
                                            if (UrlDragImageView.this.coj.getScale() < measuredWidth) {
                                                UrlDragImageView.this.coj.setScaleAndCenter(measuredWidth, pointF);
                                            }
                                            e.iK().removeCallbacks(UrlDragImageView.this.coV);
                                            e.iK().postDelayed(UrlDragImageView.this.coV, 1000L);
                                            break;
                                        case 2:
                                            if (Math.abs(motionEvent.getY() - UrlDragImageView.this.coQ) > UrlDragImageView.TOUCH_SLOP) {
                                                UrlDragImageView.this.coP = false;
                                                UrlDragImageView.this.coj.setOnClickListener(null);
                                                UrlDragImageView.this.coj.setOnLongClickListener(null);
                                            }
                                            UrlDragImageView.this.coQ = motionEvent.getY();
                                            break;
                                    }
                                    return false;
                                }
                            });
                            UrlDragImageView.this.coh.setVisibility(4);
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
            this.coj.setOnImageEventListener(this.cok);
            if (this.coj.isImageLoaded() && this.clr.isLongPic) {
                this.cok.onImageLoaded();
            } else {
                this.coj.setImage(ImageSource.uri(str));
            }
            return true;
        }
        return false;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.coB = dVar;
        if (this.coh != null) {
            this.coh.setDragToExitListener(dVar);
        }
    }

    public void aqD() {
        eV(false);
    }

    private boolean pK(String str) {
        return j.kc() || com.baidu.tbadk.core.util.d.c.oC(str);
    }

    private void setThumbBitmapToView(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap nK;
        if (!this.con && aVar != null && (nK = aVar.nK()) != null) {
            this.f3com = true;
            if (aVar.isGif()) {
                this.coh.setImageUrlData(this.clr);
                this.coh.setImageBitmap(nK);
                this.coS = null;
                this.coM = false;
            } else {
                if (this.clr != null && this.clr.isLongPic) {
                    this.coh.awS();
                    this.coh.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.13
                        @Override // com.baidu.tbadk.widget.largeImage.logic.a
                        public void aqM() {
                        }
                    });
                }
                this.coh.setImageUrlData(this.clr);
                this.coh.setImageData(nK, aVar.nP());
            }
            aqA();
        }
    }

    private void e(String str, boolean z, boolean z2) {
        if (pL(str)) {
            if (z2 || (!this.coo && !this.con)) {
                if (!z2 || !eV(true)) {
                    this.coo = true;
                    com.baidu.adp.lib.f.c.iE().a(str, 27, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.14
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onCancelled(String str2) {
                            UrlDragImageView.this.coo = false;
                            UrlDragImageView.this.coh.setVisibility(0);
                            UrlDragImageView.this.mProgressBar.setVisibility(8);
                            UrlDragImageView.this.coS = null;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            UrlDragImageView.this.coo = false;
                            UrlDragImageView.this.con = true;
                            UrlDragImageView.this.b(aVar);
                        }
                    }, 0, 0, false, null, Boolean.valueOf(z), this.coh.getImageData(), Boolean.valueOf(this.cmL));
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
        com.baidu.adp.widget.ImageView.a a2 = this.coN.a(imageFileInfo, false);
        if (a2 != null) {
            this.con = true;
            this.mProgressBar.setVisibility(8);
            this.coS = null;
            b(a2);
            return;
        }
        this.coN.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.2
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.ImageView.a aVar, String str2, boolean z3) {
                UrlDragImageView.this.con = true;
                UrlDragImageView.this.mProgressBar.setVisibility(8);
                UrlDragImageView.this.coS = null;
                UrlDragImageView.this.b(aVar);
            }
        }, false);
    }

    private boolean pL(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null && this.col != null) {
            this.col.i(aVar.getUrl(), aVar.nP());
        }
        if (aVar == null || aVar.nK() == null) {
            aqE();
            return;
        }
        Bitmap nK = aVar.nK();
        this.coh.setLoadBigImage(true);
        if (aVar.isGif()) {
            this.coh.setGifData(aVar.nP(), nK);
            this.coh.invalidate();
            this.coh.play();
            this.coM = false;
            this.coS = null;
            this.mProgressBar.setVisibility(8);
        } else {
            if (this.clr != null && this.clr.isLongPic) {
                this.coh.awS();
                this.coh.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.3
                    @Override // com.baidu.tbadk.widget.largeImage.logic.a
                    public void aqM() {
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.coS = null;
                    }
                });
            } else {
                this.mProgressBar.setVisibility(8);
                this.coS = null;
            }
            this.coh.setImageUrlData(this.clr);
            this.coh.setImageData(nK, aVar.nP());
            aqJ();
        }
        aqA();
    }

    private void aqE() {
        if (!this.f3com) {
            this.coh.setDefaultBitmap();
        } else {
            this.con = false;
        }
        this.coS = null;
        this.mProgressBar.setVisibility(8);
    }

    public void setGifMaxUseableMem(int i) {
        this.coh.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.coh != null) {
            this.coh.onDestroy();
        }
        if (this.coj != null) {
            this.coj.recycle();
        }
        if (this.cor != null) {
            this.cor.recycle();
            this.cor = null;
        }
        if (this.mProgressBar != null) {
            this.coS = null;
            this.mProgressBar.setVisibility(8);
        }
        e.iK().removeCallbacks(this.coV);
        com.baidu.tieba.view.c.cxR().setColor(-1);
    }

    public void release() {
        if (this.coh != null) {
            this.coh.release();
        }
        if (this.mProgressBar != null) {
            this.coS = null;
            this.mProgressBar.setVisibility(8);
        }
        this.coS = null;
    }

    public void aqF() {
        if (this.coh != null && this.coh.getImageType() == 1) {
            this.coh.stop();
        }
    }

    public void r(boolean z, boolean z2) {
        String str;
        if (this.coh != null && (str = (String) this.coh.getTag()) != null) {
            if (this.coh.getImageType() == 1) {
                if (this.coh.getGifCache() == null || !this.coh.axf()) {
                    e(str, z, z2);
                }
            } else if (this.coh.getImageType() == 2) {
                e(str, z, z2);
            } else if (aqG()) {
                e(str, z, z2);
            }
        }
    }

    private boolean aqG() {
        if (this.coh.getImageBitmap() != null && this.coh.axf()) {
            if (this.clr == null || !this.clr.isLongPic || this.coh.awT()) {
                return false;
            }
            this.con = false;
            this.coK = false;
            return true;
        }
        return true;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.clr = imageUrlData;
    }

    public ImageUrlData getmAssistUrlData() {
        return this.clr;
    }

    public void setIsCdn(boolean z) {
        this.cmL = z;
    }

    public void aqH() {
        final String oj = at.oj(this.clr.originalUrl);
        if (this.clr.originalProcess >= 0) {
            com.baidu.tbadk.download.d.arS().Y(oj, 13);
            this.clr.originalProcess = -1;
            aqJ();
            return;
        }
        if (this.cmD != null) {
            this.cmD.aqN();
        }
        com.baidu.adp.base.e<?> ab = i.ab(this.mContext);
        if (ab == null) {
            pM(oj);
        } else if (!j.kc() || j.kd() || com.baidu.tbadk.core.sharedPref.b.ahO().getBoolean("original_img_down_tip", false)) {
            pM(oj);
        } else {
            com.baidu.tbadk.core.sharedPref.b.ahO().putBoolean("original_img_down_tip", true);
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
            aVar.agI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pM(String str) {
        if (this.clr != null) {
            this.clr.originalProcess = 0;
            this.coT.setProgress(0);
            this.coT.setVisibility(0);
            DownloadData downloadData = new DownloadData(str);
            downloadData.setStatus(1);
            downloadData.setUrl(this.clr.originalUrl);
            downloadData.setType(13);
            downloadData.setPath(this.coD + ap.ajj().nW(str) + "/" + str);
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.6
                @Override // com.baidu.tbadk.download.c
                public boolean onPreDownload(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2 != null) {
                        if (UrlDragImageView.this.clr != null && UrlDragImageView.this.clr.originalProcess != -1) {
                            UrlDragImageView.this.clr.originalProcess = downloadData2.getProcess();
                        }
                        if (UrlDragImageView.this.clr == null || UrlDragImageView.this.clr.originalProcess != -1) {
                            UrlDragImageView.this.coT.setProgress(downloadData2.getProcess());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public boolean onFileDownloaded(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadSucceed(DownloadData downloadData2) {
                    UrlDragImageView.this.coT.setVisibility(8);
                    e.iK().postDelayed(UrlDragImageView.this.coW, 1500L);
                    UrlDragImageView.this.coK = false;
                    UrlDragImageView.this.coJ = UrlDragImageView.this.aqI();
                    UrlDragImageView.this.aqD();
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str2) {
                    UrlDragImageView.this.coT.setVisibility(8);
                    UrlDragImageView.this.coK = false;
                    BdToast.b(UrlDragImageView.this.mContext, str2).agO().agQ();
                    UrlDragImageView.this.clr.originalProcess = -1;
                    UrlDragImageView.this.aqJ();
                }
            });
            com.baidu.tbadk.download.d.arS().a(downloadData, 100);
            this.coU = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aqI() {
        if (this.clr != null && !StringUtils.isNull(this.clr.originalUrl, true) && this.clr.originalSize >= 0 && !this.clr.isBlockedPic) {
            String oj = at.oj(this.clr.originalUrl);
            File file = new File(this.coD + ap.ajj().nW(oj) + "/" + oj);
            if (file != null && file.exists()) {
                this.clr.originalProcess = 100;
                return true;
            }
            if (this.clr.originalProcess < 0) {
                aqJ();
            } else {
                this.coT.setProgress(this.clr.originalProcess);
            }
            this.coM = true;
        } else {
            this.coS = null;
        }
        return false;
    }

    public void aqJ() {
        if (this.clr != null) {
            if (!aqK() || !this.coM) {
                this.coS = null;
            } else if (this.clr.originalSize > 0 && !bf(this.clr.originalSize)) {
                this.coS = cof + "(" + aq.aU(this.clr.originalSize) + ")";
            } else {
                this.coS = cof;
            }
        }
    }

    private boolean aqK() {
        return (this.clr == null || !this.clr.mIsShowOrigonButton || this.clr.isBlockedPic || StringUtils.isNull(this.clr.originalUrl)) ? false : true;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.cmD = bVar;
    }

    private boolean bf(long j) {
        return j > cog;
    }
}
