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
    private ImageUrlData cmu;
    private b cnG;
    private boolean cnO;
    private boolean cnQ;
    private boolean cnR;
    private Rect cpA;
    private Rect cpB;
    private Rect cpC;
    private DragImageView.d cpD;
    private String cpF;
    private float cpG;
    private float cpH;
    private float cpI;
    private float cpJ;
    private float cpK;
    private boolean cpL;
    private boolean cpM;
    private boolean cpN;
    public boolean cpO;
    private com.baidu.tbadk.img.b cpP;
    private View.OnTouchListener cpQ;
    private boolean cpR;
    private float cpS;
    private View.OnLongClickListener cpT;
    private String cpU;
    private CircleProgressView cpV;
    private boolean cpW;
    private Runnable cpX;
    private Runnable cpY;
    private View.OnTouchListener cpZ;
    protected DragImageView cpj;
    protected TextView cpk;
    protected SubsamplingScaleImageView cpl;
    private SubsamplingScaleImageView.OnImageEventListener cpm;
    private a cpn;
    private boolean cpo;
    private boolean cpp;
    private boolean cpq;
    private boolean cpr;
    private Bitmap cps;
    private boolean cpt;
    private float cpv;
    private final Matrix cpw;
    private Rect cpx;
    private RectF cpy;
    private RectF cpz;
    protected Context mContext;
    private boolean mIsDrag;
    private float mLastMotionX;
    private float mLastMotionY;
    private int mMaxHeight;
    private int mMaxWidth;
    private View.OnClickListener mOnClickListener;
    protected ProgressBar mProgressBar;
    private float mRatio;
    private int mSkinType;
    private String mUserId;
    private static final String cph = TbadkCoreApplication.getInst().getString(R.string.original_img_look);
    private static long cpi = Config.RAVEN_LOG_LIMIT;
    private static final int cpE = l.ah(TbadkCoreApplication.getInst()) / 5;
    private static final String TAG = UrlDragImageView.class.getSimpleName();
    private static final int TOUCH_SLOP = ViewConfiguration.get(TbadkCoreApplication.getInst()).getScaledTouchSlop();

    /* loaded from: classes3.dex */
    public interface a {
        void i(String str, byte[] bArr);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void arb();
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
        if (this.cpj != null) {
            this.cpj.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.cpn = aVar;
    }

    public UrlDragImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.cpj = null;
        this.cpn = null;
        this.cnO = false;
        this.cpq = false;
        this.cpt = false;
        this.mRatio = 1.0f;
        this.cpv = 0.0f;
        this.cpw = new Matrix();
        this.cpy = new RectF();
        this.cpG = 0.0f;
        this.cpH = 0.0f;
        this.cpI = 1.0f;
        this.cpJ = 1.0f;
        this.cpK = 0.0f;
        this.cpL = false;
        this.cpM = false;
        this.cpN = false;
        this.cpO = false;
        this.cpR = true;
        this.cpS = 0.0f;
        this.mOnClickListener = null;
        this.cpT = null;
        this.cpU = null;
        this.cpX = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.cpR = true;
            }
        };
        this.cpY = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.cpV.setVisibility(8);
                        UrlDragImageView.this.cpU = null;
                        UrlDragImageView.this.cpO = false;
                    }
                });
            }
        };
        this.cpZ = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.cpQ != null) {
                    UrlDragImageView.this.cpQ.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.cpP = new com.baidu.tbadk.img.b();
        init();
    }

    public UrlDragImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.cpj = null;
        this.cpn = null;
        this.cnO = false;
        this.cpq = false;
        this.cpt = false;
        this.mRatio = 1.0f;
        this.cpv = 0.0f;
        this.cpw = new Matrix();
        this.cpy = new RectF();
        this.cpG = 0.0f;
        this.cpH = 0.0f;
        this.cpI = 1.0f;
        this.cpJ = 1.0f;
        this.cpK = 0.0f;
        this.cpL = false;
        this.cpM = false;
        this.cpN = false;
        this.cpO = false;
        this.cpR = true;
        this.cpS = 0.0f;
        this.mOnClickListener = null;
        this.cpT = null;
        this.cpU = null;
        this.cpX = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.cpR = true;
            }
        };
        this.cpY = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.cpV.setVisibility(8);
                        UrlDragImageView.this.cpU = null;
                        UrlDragImageView.this.cpO = false;
                    }
                });
            }
        };
        this.cpZ = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.cpQ != null) {
                    UrlDragImageView.this.cpQ.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.cpP = new com.baidu.tbadk.img.b();
        init();
    }

    public DragImageView getImageView() {
        return this.cpj;
    }

    public void setGifSetListener(DragImageView.e eVar) {
        this.cpj.setGifSetListener(eVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.cpj.setImageOnClickListener(onClickListener);
        this.cpl.setOnClickListener(onClickListener);
        this.mOnClickListener = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cpT = onLongClickListener;
        if (!this.cnQ) {
            this.cpj.setImageOnLongClickListener(this.cpT);
            this.cpl.setOnLongClickListener(this.cpT);
        }
    }

    public void setOnSizeChangedListener(final DragImageView.g gVar) {
        this.cpj.setOnSizeChangedListener(new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.8
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (gVar != null) {
                    gVar.a(dragImageView, z, z2);
                }
                UrlDragImageView.this.aqO();
            }
        });
    }

    protected void init() {
        this.cpF = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        this.mMaxWidth = l.af(this.mContext);
        this.mMaxHeight = l.ah(this.mContext) - ((int) this.mContext.getResources().getDimension(R.dimen.ds166));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.cpj = new DragImageView(this.mContext);
        this.cpj.setLayoutParams(layoutParams);
        this.cpj.setOnTouchListener(this.cpZ);
        addView(this.cpj);
        this.cpl = new SubsamplingScaleImageView(this.mContext);
        this.cpl.setMaxScale(50.0f);
        this.cpl.setOnTouchListener(this.cpZ);
        this.cpl.setVisibility(4);
        addView(this.cpl, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(getResources().getDrawable(R.drawable.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        aqM();
    }

    private void aqM() {
        this.cpV = new CircleProgressView(this.mContext);
        this.cpV.setCircleBackgroundColor(am.getColor(R.color.cp_cont_d));
        this.cpV.setCircleForegroundColor(am.getColor(R.color.cp_link_tip_a));
        this.cpV.setProgress(0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.g(getContext(), R.dimen.tbds80), l.g(getContext(), R.dimen.tbds80));
        layoutParams.addRule(13);
        this.cpV.setVisibility(8);
        addView(this.cpV, layoutParams);
    }

    public void setIsCanDrag(boolean z) {
        this.cnQ = z;
    }

    public void setIsHotSort(boolean z) {
        this.cnR = z;
    }

    public String getmCheckOriginPicText() {
        return this.cpU;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        Bitmap imageBitmap;
        int height;
        int width;
        if (this.cpL && !this.cpW && this.cpl.getVisibility() == 0 && !this.cpl.isImageLoaded()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.cnQ || !this.cpp) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.mIsDrag && motionEvent.getPointerCount() >= 2) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.mIsDrag || this.cpr) {
            requestDisallowInterceptTouchEvent(true);
        }
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        float x = motionEvent.getX();
        int i = action & 255;
        if (i == 0) {
            if (this.cps == null) {
                if (this.cpl.getVisibility() == 0) {
                    this.cps = f.bh(this.cpl);
                } else {
                    this.cps = f.bh(this.cpj);
                }
            }
            if (this.cpx == null && this.cps != null) {
                int measuredWidth = getMeasuredWidth();
                float measuredWidth2 = ((getMeasuredWidth() * 1.0f) / this.cps.getWidth()) * this.cps.getHeight();
                if (measuredWidth2 > getMeasuredHeight()) {
                    measuredWidth2 = getMeasuredHeight();
                }
                RectF h = h(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
                this.cpx = new Rect((int) h.left, (int) h.top, (int) h.right, (int) h.bottom);
            }
            if (this.cpB == null && this.cps != null) {
                if (this.cpl.getVisibility() == 0) {
                    height = this.cpl.getSHeight();
                    width = this.cpl.getSWidth();
                } else {
                    if (this.cpj.getImageType() == 1) {
                        imageBitmap = (this.cpj.getCurrentFrame() == null || this.cpj.getCurrentFrame().cFw == null) ? this.cps : this.cpj.getCurrentFrame().cFw;
                    } else {
                        imageBitmap = this.cpj.getImageBitmap() == null ? this.cps : this.cpj.getImageBitmap();
                    }
                    height = imageBitmap.getHeight();
                    width = imageBitmap.getWidth();
                }
                float ai = l.ai(getContext());
                int i2 = (int) (height * ai);
                int i3 = (int) (width * ai);
                if (i3 > this.cps.getWidth() && this.cps.getWidth() != 0) {
                    float width2 = (i3 * 1.0f) / this.cps.getWidth();
                    i3 = this.cps.getWidth();
                    i2 = (int) (i2 / width2);
                }
                if (i2 > this.cps.getHeight() && this.cps.getHeight() != 0) {
                    i3 = (int) (i3 / ((i2 * 1.0f) / this.cps.getHeight()));
                    i2 = this.cps.getHeight();
                }
                int ah = (l.ah(getContext()) - i2) / 2;
                int af = (l.af(getContext()) - i3) / 2;
                this.cpB = new Rect(af, ah, i3 + af, i2 + ah);
                this.cpC = new Rect(this.cpB);
                this.cpK = ah / l.ah(getContext());
                this.cpA = new Rect(0, 0, this.cps.getWidth(), this.cps.getHeight());
            }
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (i == 2) {
            this.mIsDrag = r(this.mLastMotionX - x, this.mLastMotionY - y);
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (this.mIsDrag || this.cpr) {
            this.cpj.setImageOnLongClickListener(null);
            this.cpl.setOnLongClickListener(null);
            z = true;
        } else {
            this.cpj.setImageOnLongClickListener(this.cpT);
            this.cpl.setOnLongClickListener(this.cpT);
            z = super.dispatchTouchEvent(motionEvent);
        }
        if (i == 1 || i == 3) {
            this.mLastMotionX = 0.0f;
            this.mLastMotionY = 0.0f;
            if (this.cpv > cpE) {
                this.cpr = true;
                aqN();
            } else {
                if (this.mIsDrag && this.cpD != null) {
                    this.cpD.axx();
                }
                this.mRatio = 1.0f;
                invalidate();
            }
            this.cpt = false;
            this.cpw.reset();
            this.mIsDrag = false;
            return z;
        }
        return z;
    }

    private boolean r(float f, float f2) {
        if (this.cpl.getVisibility() != 0 || this.cpl.isCanDrag()) {
            if (this.cmu == null || !this.cmu.isLongPic || this.cpl.getVisibility() != 0 || this.cpl.isViewTop()) {
                if (this.cmu == null || !this.cmu.isLongPic || this.cpl.getVisibility() == 0 || this.cpj.axb()) {
                    if (this.cpl.getVisibility() == 0 || this.cpj.axd()) {
                        if (this.cps != null && getScrollY() == 0 && f2 < 0.0f && !this.cpt) {
                            this.cpj.setImageOnLongClickListener(null);
                            this.cpl.setOnLongClickListener(null);
                            this.cpt = true;
                            this.cpv = 0.0f;
                            this.mRatio = 1.0f;
                            if (this.cpD != null) {
                                this.cpD.axv();
                            }
                        }
                        if (!this.cpt || this.cps == null) {
                            return false;
                        }
                        this.cpv -= f2;
                        int measuredHeight = getMeasuredHeight();
                        if (this.cpv > measuredHeight) {
                            this.cpv = measuredHeight;
                        }
                        float f3 = f2 / measuredHeight;
                        this.cpw.postTranslate((-f) * 1.5f * this.mRatio, (-1.5f) * f2 * this.mRatio);
                        if (this.mRatio * (1.0f + f3) > 1.0f || this.cpv < 0.0f) {
                            this.cpw.preScale(1.0f / this.mRatio, 1.0f / this.mRatio, (this.mRatio * this.cps.getWidth()) / 2.0f, this.mRatio * (this.cps.getHeight() / 2));
                            this.mRatio = 1.0f;
                        } else {
                            this.cpw.preScale(1.0f + f3, 1.0f + f3, (this.mRatio * this.cps.getWidth()) / 2.0f, this.mRatio * (this.cps.getHeight() / 2));
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
        if (this.mIsDrag && this.cps != null && !this.cps.isRecycled() && this.cpt) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.cpy == null) {
                this.cpy = new RectF();
            }
            this.cpw.mapRect(this.cpy, new RectF(this.cpx));
            canvas.drawBitmap(this.cps, this.cpA, this.cpy, (Paint) null);
        } else if (this.cpr && this.cps != null && !this.cps.isRecycled()) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.cmu == null || this.cmu.getSourceImageRectInScreen() == null) {
                canvas.drawBitmap(this.cps, this.cpA, this.cpy, (Paint) null);
            } else {
                canvas.drawBitmap(this.cps, this.cpB, this.cpy, (Paint) null);
            }
        } else {
            super.dispatchDraw(canvas);
        }
    }

    private void aqN() {
        if (this.cmu == null) {
            if (this.cpD != null) {
                this.cpD.axw();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.cmu.getSourceImageRectInScreen();
        final Rect dstRectInScreen = this.cmu.getDstRectInScreen();
        if (sourceImageRectInScreen == null || dstRectInScreen == null) {
            if (this.cpD != null) {
                this.cpD.axw();
                return;
            }
            return;
        }
        a(sourceImageRectInScreen, dstRectInScreen);
        f(sourceImageRectInScreen);
        this.cpz = new RectF(this.cpy);
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
                UrlDragImageView.this.cpt = false;
                UrlDragImageView.this.invalidate();
                if (UrlDragImageView.this.cpD != null) {
                    UrlDragImageView.this.cpD.axw();
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
            float f = ((rect.bottom - rect.top) / (rect.right - rect.left)) * (this.cpy.right - this.cpy.left);
            this.cpy.top += this.cpy.height() * this.cpK;
            this.cpy.bottom = f + this.cpy.top;
        }
    }

    public void setCanScale(boolean z) {
        if (this.cpj != null) {
            this.cpj.setCanScale(z);
        }
    }

    private void a(Rect rect, Rect rect2) {
        this.cpG = 0.0f;
        this.cpH = 0.0f;
        this.cpI = 1.0f;
        this.cpJ = 1.0f;
        if (rect != null && rect2 != null && rect.contains(rect2)) {
            this.cpG = (rect2.left - rect.left) / rect.width();
            this.cpH = (rect2.top - rect.top) / rect.height();
            this.cpI = (rect2.right - rect.left) / rect.width();
            this.cpJ = (rect2.bottom - rect.top) / rect.height();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(float f) {
        if (this.cpB != null) {
            this.cpB.left = (int) (this.cpC.left + (this.cpC.width() * this.cpG * f));
            this.cpB.top = (int) (this.cpC.top + (this.cpC.height() * this.cpH * f));
            this.cpB.right = (int) (this.cpC.left + (this.cpC.width() * (((1.0f - this.cpI) * (1.0f - f)) + this.cpI)));
            this.cpB.bottom = (int) (this.cpC.top + (this.cpC.height() * (((1.0f - this.cpJ) * (1.0f - f)) + this.cpJ)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Rect rect, float f) {
        if (this.cpy != null && rect != null) {
            this.cpy.left = this.cpz.left + ((rect.left - this.cpz.left) * f);
            this.cpy.top = this.cpz.top + ((rect.top - this.cpz.top) * f);
            this.cpy.right = this.cpz.right + ((rect.right - this.cpz.right) * f);
            this.cpy.bottom = this.cpz.bottom + ((rect.bottom - this.cpz.bottom) * f);
        }
    }

    private RectF h(float f, float f2, float f3, float f4) {
        return new RectF(f - (f3 / 2.0f), f2 - (f4 / 2.0f), (f3 / 2.0f) + f, (f4 / 2.0f) + f2);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.cpQ = onTouchListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqO() {
        if ((this.cpo || this.cpp) && this.cmu != null && this.cmu.mPicType == 1 && !TextUtils.isEmpty(this.cmu.mTagName)) {
            if (this.cpk != null) {
                this.cpk.setVisibility(8);
                this.cpk = null;
            }
            this.cpk = new TextView(this.mContext);
            this.cpk.setText(this.cmu.mTagName);
            this.cpk.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize26));
            am.d(this.cpk, R.color.common_color_10013, 1, 0);
            am.l(this.cpk, R.color.common_color_10215);
            this.cpk.setAlpha(0.75f);
            this.cpk.setIncludeFontPadding(false);
            this.cpk.setGravity(17);
            int g = l.g(this.mContext, R.dimen.ds2);
            this.cpk.setPadding(g, g, g, g);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.cpj.getBottomOffset();
            layoutParams.leftMargin = this.cpj.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.cpk, layoutParams);
            this.cpk.setVisibility(0);
        }
    }

    public void setUrl(String str, boolean z) {
        if (str.contains("*")) {
            str = str.split("[*]")[0];
        }
        this.cpj.setTag(str);
        this.cpj.setLoadBigImage(false);
        this.cpj.setImageDrawable(null);
        this.cpo = false;
        this.cpp = false;
        this.cpL = aqW();
        this.cpU = null;
        if (pV(str)) {
            e(str, z, false);
        }
    }

    private boolean aqP() {
        return this.cpj != null && this.cpj.axt();
    }

    public void aqQ() {
        if (this.cmu != null && !aqP()) {
            String str = this.cmu.imageUrl;
            int i = this.cmu.urlType;
            com.baidu.adp.widget.ImageView.a aVar = null;
            if (com.baidu.tbadk.core.util.e.a.U(str, i)) {
                aVar = com.baidu.tbadk.core.util.e.a.V(str, i);
            }
            if (aVar != null) {
                setThumbBitmapToView(aVar);
            }
        }
    }

    private boolean eY(boolean z) {
        String ol;
        if (!this.cpM || z) {
            this.cpM = true;
            if (!this.cpL || this.cmu == null || StringUtils.isNull(this.cmu.originalUrl, true) || this.cmu.originalSize < 0 || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String str = this.cpF + ap.ajr().nY(ol) + "/" + as.ol(this.cmu.originalUrl);
            final int[] nA = m.nA(str);
            this.cpl.setVisibility(0);
            if (this.cpm == null) {
                this.cpm = new SubsamplingScaleImageView.OnImageEventListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12
                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onReady() {
                        UrlDragImageView.this.cpU = null;
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.cpj.axn();
                        UrlDragImageView.this.cpj.setVisibility(4);
                    }

                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onImageLoaded() {
                        if (UrlDragImageView.this.cmu.isLongPic && nA[0] > 0) {
                            UrlDragImageView.this.cpj.onDestroy();
                            final float measuredWidth = (UrlDragImageView.this.getMeasuredWidth() * 1.0f) / nA[0];
                            final PointF pointF = new PointF((nA[0] * 1.0f) / 2.0f, 0.0f);
                            UrlDragImageView.this.cpl.setScaleAndCenter(measuredWidth, pointF);
                            UrlDragImageView.this.cpl.setMaxScale(2.0f * measuredWidth);
                            UrlDragImageView.this.cpl.setDoubleTapZoomScale(2.0f * measuredWidth);
                            UrlDragImageView.this.cpl.setInitScale(measuredWidth);
                            UrlDragImageView.this.cpl.setDoubleTapZoomStyle(4);
                            UrlDragImageView.this.cpl.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12.1
                                @Override // android.view.View.OnTouchListener
                                public boolean onTouch(View view, MotionEvent motionEvent) {
                                    if (UrlDragImageView.this.cpQ != null) {
                                        UrlDragImageView.this.cpQ.onTouch(view, motionEvent);
                                    }
                                    switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                                        case 0:
                                            UrlDragImageView.this.cpS = motionEvent.getY();
                                            UrlDragImageView.this.cpl.setOnClickListener(UrlDragImageView.this.cpR ? UrlDragImageView.this.mOnClickListener : null);
                                            UrlDragImageView.this.cpl.setOnLongClickListener(UrlDragImageView.this.cpR ? UrlDragImageView.this.cpT : null);
                                            break;
                                        case 1:
                                        case 3:
                                            if (UrlDragImageView.this.cpl.getScale() < measuredWidth) {
                                                UrlDragImageView.this.cpl.setScaleAndCenter(measuredWidth, pointF);
                                            }
                                            e.iK().removeCallbacks(UrlDragImageView.this.cpX);
                                            e.iK().postDelayed(UrlDragImageView.this.cpX, 1000L);
                                            break;
                                        case 2:
                                            if (Math.abs(motionEvent.getY() - UrlDragImageView.this.cpS) > UrlDragImageView.TOUCH_SLOP) {
                                                UrlDragImageView.this.cpR = false;
                                                UrlDragImageView.this.cpl.setOnClickListener(null);
                                                UrlDragImageView.this.cpl.setOnLongClickListener(null);
                                            }
                                            UrlDragImageView.this.cpS = motionEvent.getY();
                                            break;
                                    }
                                    return false;
                                }
                            });
                            UrlDragImageView.this.cpj.setVisibility(4);
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
            this.cpl.setOnImageEventListener(this.cpm);
            if (this.cpl.isImageLoaded() && this.cmu.isLongPic) {
                this.cpm.onImageLoaded();
            } else {
                this.cpl.setImage(ImageSource.uri(str));
            }
            return true;
        }
        return false;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.cpD = dVar;
        if (this.cpj != null) {
            this.cpj.setDragToExitListener(dVar);
        }
    }

    public void aqR() {
        eY(false);
    }

    private boolean pV(String str) {
        return j.kc() || com.baidu.tbadk.core.util.e.c.oK(str);
    }

    private void setThumbBitmapToView(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap nK;
        if (!this.cpp && aVar != null && (nK = aVar.nK()) != null) {
            this.cpo = true;
            if (aVar.isGif()) {
                this.cpj.setImageUrlData(this.cmu);
                this.cpj.setImageBitmap(nK);
                this.cpU = null;
                this.cpO = false;
            } else {
                if (this.cmu != null && this.cmu.isLongPic) {
                    this.cpj.axg();
                    this.cpj.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.13
                        @Override // com.baidu.tbadk.widget.largeImage.logic.a
                        public void ara() {
                        }
                    });
                }
                this.cpj.setImageUrlData(this.cmu);
                this.cpj.setImageData(nK, aVar.nP());
            }
            aqO();
        }
    }

    private void e(String str, boolean z, boolean z2) {
        if (pW(str)) {
            if (z2 || (!this.cpq && !this.cpp)) {
                if (!z2 || !eY(true)) {
                    this.cpq = true;
                    com.baidu.adp.lib.f.c.iE().a(str, 27, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.14
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onCancelled(String str2) {
                            UrlDragImageView.this.cpq = false;
                            UrlDragImageView.this.cpj.setVisibility(0);
                            UrlDragImageView.this.mProgressBar.setVisibility(8);
                            UrlDragImageView.this.cpU = null;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            UrlDragImageView.this.cpq = false;
                            UrlDragImageView.this.cpp = true;
                            UrlDragImageView.this.b(aVar);
                        }
                    }, 0, 0, false, null, Boolean.valueOf(z), this.cpj.getImageData(), Boolean.valueOf(this.cnO));
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
        com.baidu.adp.widget.ImageView.a a2 = this.cpP.a(imageFileInfo, false);
        if (a2 != null) {
            this.cpp = true;
            this.mProgressBar.setVisibility(8);
            this.cpU = null;
            b(a2);
            return;
        }
        this.cpP.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.2
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.ImageView.a aVar, String str2, boolean z3) {
                UrlDragImageView.this.cpp = true;
                UrlDragImageView.this.mProgressBar.setVisibility(8);
                UrlDragImageView.this.cpU = null;
                UrlDragImageView.this.b(aVar);
            }
        }, false);
    }

    private boolean pW(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null && this.cpn != null) {
            this.cpn.i(aVar.getUrl(), aVar.nP());
        }
        if (aVar == null || aVar.nK() == null) {
            aqS();
            return;
        }
        Bitmap nK = aVar.nK();
        this.cpj.setLoadBigImage(true);
        if (aVar.isGif()) {
            this.cpj.setGifData(aVar.nP(), nK);
            this.cpj.invalidate();
            this.cpj.play();
            this.cpO = false;
            this.cpU = null;
            this.mProgressBar.setVisibility(8);
        } else {
            if (this.cmu != null && this.cmu.isLongPic) {
                this.cpj.axg();
                this.cpj.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.3
                    @Override // com.baidu.tbadk.widget.largeImage.logic.a
                    public void ara() {
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.cpU = null;
                    }
                });
            } else {
                this.mProgressBar.setVisibility(8);
                this.cpU = null;
            }
            this.cpj.setImageUrlData(this.cmu);
            this.cpj.setImageData(nK, aVar.nP());
            aqX();
        }
        aqO();
    }

    private void aqS() {
        if (!this.cpo) {
            this.cpj.setDefaultBitmap();
        } else {
            this.cpp = false;
        }
        this.cpU = null;
        this.mProgressBar.setVisibility(8);
    }

    public void setGifMaxUseableMem(int i) {
        this.cpj.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.cpj != null) {
            this.cpj.onDestroy();
        }
        if (this.cpl != null) {
            this.cpl.recycle();
        }
        if (this.cps != null) {
            this.cps.recycle();
            this.cps = null;
        }
        if (this.mProgressBar != null) {
            this.cpU = null;
            this.mProgressBar.setVisibility(8);
        }
        e.iK().removeCallbacks(this.cpX);
        com.baidu.tieba.view.c.czb().setColor(-1);
    }

    public void release() {
        if (this.cpj != null) {
            this.cpj.release();
        }
        if (this.mProgressBar != null) {
            this.cpU = null;
            this.mProgressBar.setVisibility(8);
        }
        this.cpU = null;
    }

    public void aqT() {
        if (this.cpj != null && this.cpj.getImageType() == 1) {
            this.cpj.stop();
        }
    }

    public void r(boolean z, boolean z2) {
        String str;
        if (this.cpj != null && (str = (String) this.cpj.getTag()) != null) {
            if (this.cpj.getImageType() == 1) {
                if (this.cpj.getGifCache() == null || !this.cpj.axt()) {
                    e(str, z, z2);
                }
            } else if (this.cpj.getImageType() == 2) {
                e(str, z, z2);
            } else if (aqU()) {
                e(str, z, z2);
            }
        }
    }

    private boolean aqU() {
        if (this.cpj.getImageBitmap() != null && this.cpj.axt()) {
            if (this.cmu == null || !this.cmu.isLongPic || this.cpj.axh()) {
                return false;
            }
            this.cpp = false;
            this.cpM = false;
            return true;
        }
        return true;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.cmu = imageUrlData;
    }

    public ImageUrlData getmAssistUrlData() {
        return this.cmu;
    }

    public void setIsCdn(boolean z) {
        this.cnO = z;
    }

    public void aqV() {
        final String ol = as.ol(this.cmu.originalUrl);
        if (this.cmu.originalProcess >= 0) {
            com.baidu.tbadk.download.d.asg().Y(ol, 13);
            this.cmu.originalProcess = -1;
            aqX();
            return;
        }
        if (this.cnG != null) {
            this.cnG.arb();
        }
        com.baidu.adp.base.e<?> ab = i.ab(this.mContext);
        if (ab == null) {
            pX(ol);
        } else if (!j.kc() || j.kd() || com.baidu.tbadk.core.sharedPref.b.ahU().getBoolean("original_img_down_tip", false)) {
            pX(ol);
        } else {
            com.baidu.tbadk.core.sharedPref.b.ahU().putBoolean("original_img_down_tip", true);
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(ab.getPageActivity());
            aVar.hv(R.string.original_img_down_no_wifi_tip);
            aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    UrlDragImageView.this.pX(ol);
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                }
            });
            aVar.b(ab);
            aVar.agO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pX(String str) {
        if (this.cmu != null) {
            this.cmu.originalProcess = 0;
            this.cpV.setProgress(0);
            this.cpV.setVisibility(0);
            DownloadData downloadData = new DownloadData(str);
            downloadData.setStatus(1);
            downloadData.setUrl(this.cmu.originalUrl);
            downloadData.setType(13);
            downloadData.setPath(this.cpF + ap.ajr().nY(str) + "/" + str);
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.6
                @Override // com.baidu.tbadk.download.c
                public boolean onPreDownload(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2 != null) {
                        if (UrlDragImageView.this.cmu != null && UrlDragImageView.this.cmu.originalProcess != -1) {
                            UrlDragImageView.this.cmu.originalProcess = downloadData2.getProcess();
                        }
                        if (UrlDragImageView.this.cmu == null || UrlDragImageView.this.cmu.originalProcess != -1) {
                            UrlDragImageView.this.cpV.setProgress(downloadData2.getProcess());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public boolean onFileDownloaded(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadSucceed(DownloadData downloadData2) {
                    UrlDragImageView.this.cpV.setVisibility(8);
                    e.iK().postDelayed(UrlDragImageView.this.cpY, 1500L);
                    UrlDragImageView.this.cpM = false;
                    UrlDragImageView.this.cpL = UrlDragImageView.this.aqW();
                    UrlDragImageView.this.aqR();
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str2) {
                    UrlDragImageView.this.cpV.setVisibility(8);
                    UrlDragImageView.this.cpM = false;
                    BdToast.b(UrlDragImageView.this.mContext, str2).agU().agW();
                    UrlDragImageView.this.cmu.originalProcess = -1;
                    UrlDragImageView.this.aqX();
                }
            });
            com.baidu.tbadk.download.d.asg().a(downloadData, 100);
            this.cpW = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aqW() {
        if (this.cmu != null && !StringUtils.isNull(this.cmu.originalUrl, true) && this.cmu.originalSize >= 0 && !this.cmu.isBlockedPic) {
            String ol = as.ol(this.cmu.originalUrl);
            File file = new File(this.cpF + ap.ajr().nY(ol) + "/" + ol);
            if (file != null && file.exists()) {
                this.cmu.originalProcess = 100;
                return true;
            }
            if (this.cmu.originalProcess < 0) {
                aqX();
            } else {
                this.cpV.setProgress(this.cmu.originalProcess);
            }
            this.cpO = true;
        } else {
            this.cpU = null;
        }
        return false;
    }

    public void aqX() {
        if (this.cmu != null) {
            if (!aqY() || !this.cpO) {
                this.cpU = null;
            } else if (this.cmu.originalSize > 0 && !bi(this.cmu.originalSize)) {
                this.cpU = cph + "(" + aq.aU(this.cmu.originalSize) + ")";
            } else {
                this.cpU = cph;
            }
        }
    }

    private boolean aqY() {
        return (this.cmu == null || !this.cmu.mIsShowOrigonButton || this.cmu.isBlockedPic || StringUtils.isNull(this.cmu.originalUrl)) ? false : true;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.cnG = bVar;
    }

    private boolean bi(long j) {
        return j > cpi;
    }
}
