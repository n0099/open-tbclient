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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
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
    private ImageUrlData cke;
    private boolean clA;
    private b clp;
    private boolean clx;
    private boolean clz;
    protected DragImageView cmT;
    protected TextView cmU;
    protected SubsamplingScaleImageView cmV;
    private SubsamplingScaleImageView.OnImageEventListener cmW;
    private a cmX;
    private boolean cmY;
    private boolean cmZ;
    private com.baidu.tbadk.img.b cnA;
    private View.OnTouchListener cnB;
    private boolean cnC;
    private float cnD;
    private View.OnLongClickListener cnE;
    private String cnF;
    private CircleProgressView cnG;
    private boolean cnH;
    private Runnable cnI;
    private Runnable cnJ;
    private View.OnTouchListener cnK;
    private boolean cna;
    private boolean cnb;
    private boolean cnc;
    private Bitmap cnd;
    private boolean cne;
    private float cnf;
    private final Matrix cng;
    private Rect cnh;
    private RectF cni;
    private RectF cnj;
    private Rect cnk;
    private Rect cnl;
    private Rect cnm;
    private DragImageView.d cnn;
    private String cnp;
    private float cnq;
    private float cnr;
    private float cns;
    private float cnu;
    private float cnv;
    private boolean cnw;
    private boolean cnx;
    private boolean cny;
    public boolean cnz;
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
    private static final String cmR = TbadkCoreApplication.getInst().getString(R.string.original_img_look);
    private static long cmS = Config.RAVEN_LOG_LIMIT;
    private static final int cno = l.ah(TbadkCoreApplication.getInst()) / 5;
    private static final String TAG = UrlDragImageView.class.getSimpleName();
    private static final int TOUCH_SLOP = ViewConfiguration.get(TbadkCoreApplication.getInst()).getScaledTouchSlop();

    /* loaded from: classes3.dex */
    public interface a {
        void i(String str, byte[] bArr);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void apI();
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
        if (this.cmT != null) {
            this.cmT.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.cmX = aVar;
    }

    public UrlDragImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.cmT = null;
        this.cmX = null;
        this.clx = false;
        this.cna = false;
        this.cne = false;
        this.mRatio = 1.0f;
        this.cnf = 0.0f;
        this.cng = new Matrix();
        this.cni = new RectF();
        this.cnq = 0.0f;
        this.cnr = 0.0f;
        this.cns = 1.0f;
        this.cnu = 1.0f;
        this.cnv = 0.0f;
        this.cnw = false;
        this.cnx = false;
        this.cny = false;
        this.cnz = false;
        this.cnC = true;
        this.cnD = 0.0f;
        this.mOnClickListener = null;
        this.cnE = null;
        this.cnF = null;
        this.cnI = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.cnC = true;
            }
        };
        this.cnJ = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.cnG.setVisibility(8);
                        UrlDragImageView.this.cnF = null;
                        UrlDragImageView.this.cnz = false;
                    }
                });
            }
        };
        this.cnK = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.cnB != null) {
                    UrlDragImageView.this.cnB.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.cnA = new com.baidu.tbadk.img.b();
        init();
    }

    public UrlDragImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.cmT = null;
        this.cmX = null;
        this.clx = false;
        this.cna = false;
        this.cne = false;
        this.mRatio = 1.0f;
        this.cnf = 0.0f;
        this.cng = new Matrix();
        this.cni = new RectF();
        this.cnq = 0.0f;
        this.cnr = 0.0f;
        this.cns = 1.0f;
        this.cnu = 1.0f;
        this.cnv = 0.0f;
        this.cnw = false;
        this.cnx = false;
        this.cny = false;
        this.cnz = false;
        this.cnC = true;
        this.cnD = 0.0f;
        this.mOnClickListener = null;
        this.cnE = null;
        this.cnF = null;
        this.cnI = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.cnC = true;
            }
        };
        this.cnJ = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.cnG.setVisibility(8);
                        UrlDragImageView.this.cnF = null;
                        UrlDragImageView.this.cnz = false;
                    }
                });
            }
        };
        this.cnK = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.cnB != null) {
                    UrlDragImageView.this.cnB.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.cnA = new com.baidu.tbadk.img.b();
        init();
    }

    public DragImageView getImageView() {
        return this.cmT;
    }

    public void setGifSetListener(DragImageView.e eVar) {
        this.cmT.setGifSetListener(eVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.cmT.setImageOnClickListener(onClickListener);
        this.cmV.setOnClickListener(onClickListener);
        this.mOnClickListener = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cnE = onLongClickListener;
        if (!this.clz) {
            this.cmT.setImageOnLongClickListener(this.cnE);
            this.cmV.setOnLongClickListener(this.cnE);
        }
    }

    public void setOnSizeChangedListener(final DragImageView.g gVar) {
        this.cmT.setOnSizeChangedListener(new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.8
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (gVar != null) {
                    gVar.a(dragImageView, z, z2);
                }
                UrlDragImageView.this.apv();
            }
        });
    }

    protected void init() {
        this.cnp = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        this.mMaxWidth = l.af(this.mContext);
        this.mMaxHeight = l.ah(this.mContext) - ((int) this.mContext.getResources().getDimension(R.dimen.ds166));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.cmT = new DragImageView(this.mContext);
        this.cmT.setLayoutParams(layoutParams);
        this.cmT.setOnTouchListener(this.cnK);
        addView(this.cmT);
        this.cmV = new SubsamplingScaleImageView(this.mContext);
        this.cmV.setMaxScale(50.0f);
        this.cmV.setOnTouchListener(this.cnK);
        this.cmV.setVisibility(4);
        addView(this.cmV, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(getResources().getDrawable(R.drawable.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        apt();
    }

    private void apt() {
        this.cnG = new CircleProgressView(this.mContext);
        this.cnG.setCircleBackgroundColor(al.getColor(R.color.cp_cont_d));
        this.cnG.setCircleForegroundColor(al.getColor(R.color.cp_link_tip_a));
        this.cnG.setProgress(0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.g(getContext(), R.dimen.tbds80), l.g(getContext(), R.dimen.tbds80));
        layoutParams.addRule(13);
        this.cnG.setVisibility(8);
        addView(this.cnG, layoutParams);
    }

    public void setIsCanDrag(boolean z) {
        this.clz = z;
    }

    public void setIsHotSort(boolean z) {
        this.clA = z;
    }

    public String getmCheckOriginPicText() {
        return this.cnF;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        Bitmap imageBitmap;
        int height;
        int width;
        if (this.cnw && !this.cnH && this.cmV.getVisibility() == 0 && !this.cmV.isImageLoaded()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.clz || !this.cmZ) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.cnb && motionEvent.getPointerCount() >= 2) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.cnb || this.cnc) {
            requestDisallowInterceptTouchEvent(true);
        }
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        float x = motionEvent.getX();
        int i = action & 255;
        if (i == 0) {
            if (this.cnd == null) {
                if (this.cmV.getVisibility() == 0) {
                    this.cnd = f.bf(this.cmV);
                } else {
                    this.cnd = f.bf(this.cmT);
                }
            }
            if (this.cnh == null && this.cnd != null) {
                int measuredWidth = getMeasuredWidth();
                float measuredWidth2 = ((getMeasuredWidth() * 1.0f) / this.cnd.getWidth()) * this.cnd.getHeight();
                if (measuredWidth2 > getMeasuredHeight()) {
                    measuredWidth2 = getMeasuredHeight();
                }
                RectF h = h(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
                this.cnh = new Rect((int) h.left, (int) h.top, (int) h.right, (int) h.bottom);
            }
            if (this.cnl == null && this.cnd != null) {
                if (this.cmV.getVisibility() == 0) {
                    height = this.cmV.getSHeight();
                    width = this.cmV.getSWidth();
                } else {
                    if (this.cmT.getImageType() == 1) {
                        imageBitmap = (this.cmT.getCurrentFrame() == null || this.cmT.getCurrentFrame().cDg == null) ? this.cnd : this.cmT.getCurrentFrame().cDg;
                    } else {
                        imageBitmap = this.cmT.getImageBitmap() == null ? this.cnd : this.cmT.getImageBitmap();
                    }
                    height = imageBitmap.getHeight();
                    width = imageBitmap.getWidth();
                }
                float ai = l.ai(getContext());
                int i2 = (int) (height * ai);
                int i3 = (int) (width * ai);
                if (i3 > this.cnd.getWidth() && this.cnd.getWidth() != 0) {
                    float width2 = (i3 * 1.0f) / this.cnd.getWidth();
                    i3 = this.cnd.getWidth();
                    i2 = (int) (i2 / width2);
                }
                if (i2 > this.cnd.getHeight() && this.cnd.getHeight() != 0) {
                    i3 = (int) (i3 / ((i2 * 1.0f) / this.cnd.getHeight()));
                    i2 = this.cnd.getHeight();
                }
                int ah = (l.ah(getContext()) - i2) / 2;
                int af = (l.af(getContext()) - i3) / 2;
                this.cnl = new Rect(af, ah, i3 + af, i2 + ah);
                this.cnm = new Rect(this.cnl);
                this.cnv = ah / l.ah(getContext());
                this.cnk = new Rect(0, 0, this.cnd.getWidth(), this.cnd.getHeight());
            }
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (i == 2) {
            this.cnb = r(this.mLastMotionX - x, this.mLastMotionY - y);
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (this.cnb || this.cnc) {
            this.cmT.setImageOnLongClickListener(null);
            this.cmV.setOnLongClickListener(null);
            z = true;
        } else {
            this.cmT.setImageOnLongClickListener(this.cnE);
            this.cmV.setOnLongClickListener(this.cnE);
            z = super.dispatchTouchEvent(motionEvent);
        }
        if (i == 1 || i == 3) {
            this.mLastMotionX = 0.0f;
            this.mLastMotionY = 0.0f;
            if (this.cnf > cno) {
                this.cnc = true;
                apu();
            } else {
                if (this.cnb && this.cnn != null) {
                    this.cnn.avX();
                }
                this.mRatio = 1.0f;
                invalidate();
            }
            this.cne = false;
            this.cng.reset();
            this.cnb = false;
            return z;
        }
        return z;
    }

    private boolean r(float f, float f2) {
        if (this.cmV.getVisibility() != 0 || this.cmV.isCanDrag()) {
            if (this.cke == null || !this.cke.isLongPic || this.cmV.getVisibility() != 0 || this.cmV.isViewTop()) {
                if (this.cke == null || !this.cke.isLongPic || this.cmV.getVisibility() == 0 || this.cmT.avD()) {
                    if (this.cmV.getVisibility() == 0 || this.cmT.avF()) {
                        if (this.cnd != null && getScrollY() == 0 && f2 < 0.0f && !this.cne) {
                            this.cmT.setImageOnLongClickListener(null);
                            this.cmV.setOnLongClickListener(null);
                            this.cne = true;
                            this.cnf = 0.0f;
                            this.mRatio = 1.0f;
                            if (this.cnn != null) {
                                this.cnn.avV();
                            }
                        }
                        if (!this.cne || this.cnd == null) {
                            return false;
                        }
                        this.cnf -= f2;
                        int measuredHeight = getMeasuredHeight();
                        if (this.cnf > measuredHeight) {
                            this.cnf = measuredHeight;
                        }
                        float f3 = f2 / measuredHeight;
                        this.cng.postTranslate((-f) * 1.5f * this.mRatio, (-1.5f) * f2 * this.mRatio);
                        if (this.mRatio * (1.0f + f3) > 1.0f || this.cnf < 0.0f) {
                            this.cng.preScale(1.0f / this.mRatio, 1.0f / this.mRatio, (this.mRatio * this.cnd.getWidth()) / 2.0f, this.mRatio * (this.cnd.getHeight() / 2));
                            this.mRatio = 1.0f;
                        } else {
                            this.cng.preScale(1.0f + f3, 1.0f + f3, (this.mRatio * this.cnd.getWidth()) / 2.0f, this.mRatio * (this.cnd.getHeight() / 2));
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
        if (this.cnb && this.cnd != null && !this.cnd.isRecycled() && this.cne) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.cni == null) {
                this.cni = new RectF();
            }
            this.cng.mapRect(this.cni, new RectF(this.cnh));
            canvas.drawBitmap(this.cnd, this.cnk, this.cni, (Paint) null);
        } else if (this.cnc && this.cnd != null && !this.cnd.isRecycled()) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.cke == null || this.cke.getSourceImageRectInScreen() == null) {
                canvas.drawBitmap(this.cnd, this.cnk, this.cni, (Paint) null);
            } else {
                canvas.drawBitmap(this.cnd, this.cnl, this.cni, (Paint) null);
            }
        } else {
            super.dispatchDraw(canvas);
        }
    }

    private void apu() {
        if (this.cke == null) {
            if (this.cnn != null) {
                this.cnn.avW();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.cke.getSourceImageRectInScreen();
        final Rect dstRectInScreen = this.cke.getDstRectInScreen();
        if (sourceImageRectInScreen == null || dstRectInScreen == null) {
            if (this.cnn != null) {
                this.cnn.avW();
                return;
            }
            return;
        }
        a(sourceImageRectInScreen, dstRectInScreen);
        f(sourceImageRectInScreen);
        this.cnj = new RectF(this.cni);
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
                UrlDragImageView.this.cne = false;
                UrlDragImageView.this.invalidate();
                if (UrlDragImageView.this.cnn != null) {
                    UrlDragImageView.this.cnn.avW();
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
            float f = ((rect.bottom - rect.top) / (rect.right - rect.left)) * (this.cni.right - this.cni.left);
            this.cni.top += this.cni.height() * this.cnv;
            this.cni.bottom = f + this.cni.top;
        }
    }

    public void setCanScale(boolean z) {
        if (this.cmT != null) {
            this.cmT.setCanScale(z);
        }
    }

    private void a(Rect rect, Rect rect2) {
        this.cnq = 0.0f;
        this.cnr = 0.0f;
        this.cns = 1.0f;
        this.cnu = 1.0f;
        if (rect != null && rect2 != null && rect.contains(rect2)) {
            this.cnq = (rect2.left - rect.left) / rect.width();
            this.cnr = (rect2.top - rect.top) / rect.height();
            this.cns = (rect2.right - rect.left) / rect.width();
            this.cnu = (rect2.bottom - rect.top) / rect.height();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(float f) {
        if (this.cnl != null) {
            this.cnl.left = (int) (this.cnm.left + (this.cnm.width() * this.cnq * f));
            this.cnl.top = (int) (this.cnm.top + (this.cnm.height() * this.cnr * f));
            this.cnl.right = (int) (this.cnm.left + (this.cnm.width() * (((1.0f - this.cns) * (1.0f - f)) + this.cns)));
            this.cnl.bottom = (int) (this.cnm.top + (this.cnm.height() * (((1.0f - this.cnu) * (1.0f - f)) + this.cnu)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Rect rect, float f) {
        if (this.cni != null && rect != null) {
            this.cni.left = this.cnj.left + ((rect.left - this.cnj.left) * f);
            this.cni.top = this.cnj.top + ((rect.top - this.cnj.top) * f);
            this.cni.right = this.cnj.right + ((rect.right - this.cnj.right) * f);
            this.cni.bottom = this.cnj.bottom + ((rect.bottom - this.cnj.bottom) * f);
        }
    }

    private RectF h(float f, float f2, float f3, float f4) {
        return new RectF(f - (f3 / 2.0f), f2 - (f4 / 2.0f), (f3 / 2.0f) + f, (f4 / 2.0f) + f2);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.cnB = onTouchListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apv() {
        if ((this.cmY || this.cmZ) && this.cke != null && this.cke.mPicType == 1 && !TextUtils.isEmpty(this.cke.mTagName)) {
            if (this.cmU != null) {
                this.cmU.setVisibility(8);
                this.cmU = null;
            }
            this.cmU = new TextView(this.mContext);
            this.cmU.setText(this.cke.mTagName);
            this.cmU.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize26));
            al.c(this.cmU, R.color.common_color_10013, 1, 0);
            al.l(this.cmU, R.color.common_color_10215);
            this.cmU.setAlpha(0.75f);
            this.cmU.setIncludeFontPadding(false);
            this.cmU.setGravity(17);
            int g = l.g(this.mContext, R.dimen.ds2);
            this.cmU.setPadding(g, g, g, g);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.cmT.getBottomOffset();
            layoutParams.leftMargin = this.cmT.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.cmU, layoutParams);
            this.cmU.setVisibility(0);
        }
    }

    public void setUrl(String str, boolean z) {
        if (str.contains("*")) {
            str = str.split("[*]")[0];
        }
        this.cmT.setTag(str);
        this.cmT.setLoadBigImage(false);
        this.cmT.setImageDrawable(null);
        this.cmY = false;
        this.cmZ = false;
        this.cnw = apD();
        this.cnF = null;
        if (pu(str)) {
            e(str, z, false);
        }
    }

    private boolean apw() {
        return this.cmT != null && this.cmT.avT();
    }

    public void apx() {
        if (this.cke != null && !apw()) {
            String str = this.cke.imageUrl;
            int i = this.cke.urlType;
            com.baidu.adp.widget.ImageView.a aVar = null;
            if (com.baidu.tbadk.core.util.d.a.U(str, i)) {
                aVar = com.baidu.tbadk.core.util.d.a.V(str, i);
            }
            if (aVar != null) {
                setThumbBitmapToView(aVar);
            }
        }
    }

    private boolean eR(boolean z) {
        String nT;
        if (!this.cnx || z) {
            this.cnx = true;
            if (!this.cnw || this.cke == null || StringUtils.isNull(this.cke.originalUrl, true) || this.cke.originalSize < 0 || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String str = this.cnp + ao.aig().nK(nT) + "/" + as.nT(this.cke.originalUrl);
            final int[] nn = m.nn(str);
            this.cmV.setVisibility(0);
            if (this.cmW == null) {
                this.cmW = new SubsamplingScaleImageView.OnImageEventListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12
                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onReady() {
                        UrlDragImageView.this.cnF = null;
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.cmT.avP();
                        UrlDragImageView.this.cmT.setVisibility(4);
                    }

                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onImageLoaded() {
                        if (UrlDragImageView.this.cke.isLongPic && nn[0] > 0) {
                            UrlDragImageView.this.cmT.onDestroy();
                            final float measuredWidth = (UrlDragImageView.this.getMeasuredWidth() * 1.0f) / nn[0];
                            final PointF pointF = new PointF((nn[0] * 1.0f) / 2.0f, 0.0f);
                            UrlDragImageView.this.cmV.setScaleAndCenter(measuredWidth, pointF);
                            UrlDragImageView.this.cmV.setMaxScale(2.0f * measuredWidth);
                            UrlDragImageView.this.cmV.setDoubleTapZoomScale(2.0f * measuredWidth);
                            UrlDragImageView.this.cmV.setInitScale(measuredWidth);
                            UrlDragImageView.this.cmV.setDoubleTapZoomStyle(4);
                            UrlDragImageView.this.cmV.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12.1
                                @Override // android.view.View.OnTouchListener
                                public boolean onTouch(View view, MotionEvent motionEvent) {
                                    if (UrlDragImageView.this.cnB != null) {
                                        UrlDragImageView.this.cnB.onTouch(view, motionEvent);
                                    }
                                    switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                                        case 0:
                                            UrlDragImageView.this.cnD = motionEvent.getY();
                                            UrlDragImageView.this.cmV.setOnClickListener(UrlDragImageView.this.cnC ? UrlDragImageView.this.mOnClickListener : null);
                                            UrlDragImageView.this.cmV.setOnLongClickListener(UrlDragImageView.this.cnC ? UrlDragImageView.this.cnE : null);
                                            break;
                                        case 1:
                                        case 3:
                                            if (UrlDragImageView.this.cmV.getScale() < measuredWidth) {
                                                UrlDragImageView.this.cmV.setScaleAndCenter(measuredWidth, pointF);
                                            }
                                            e.iB().removeCallbacks(UrlDragImageView.this.cnI);
                                            e.iB().postDelayed(UrlDragImageView.this.cnI, 1000L);
                                            break;
                                        case 2:
                                            if (Math.abs(motionEvent.getY() - UrlDragImageView.this.cnD) > UrlDragImageView.TOUCH_SLOP) {
                                                UrlDragImageView.this.cnC = false;
                                                UrlDragImageView.this.cmV.setOnClickListener(null);
                                                UrlDragImageView.this.cmV.setOnLongClickListener(null);
                                            }
                                            UrlDragImageView.this.cnD = motionEvent.getY();
                                            break;
                                    }
                                    return false;
                                }
                            });
                            UrlDragImageView.this.cmT.setVisibility(4);
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
            this.cmV.setOnImageEventListener(this.cmW);
            if (this.cmV.isImageLoaded() && this.cke.isLongPic) {
                this.cmW.onImageLoaded();
            } else {
                this.cmV.setImage(ImageSource.uri(str));
            }
            return true;
        }
        return false;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.cnn = dVar;
        if (this.cmT != null) {
            this.cmT.setDragToExitListener(dVar);
        }
    }

    public void apy() {
        eR(false);
    }

    private boolean pu(String str) {
        return j.jS() || com.baidu.tbadk.core.util.d.c.ol(str);
    }

    private void setThumbBitmapToView(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap ns;
        if (!this.cmZ && aVar != null && (ns = aVar.ns()) != null) {
            this.cmY = true;
            if (aVar.isGif()) {
                this.cmT.setImageUrlData(this.cke);
                this.cmT.setImageBitmap(ns);
                this.cnF = null;
                this.cnz = false;
            } else {
                if (this.cke != null && this.cke.isLongPic) {
                    this.cmT.avI();
                    this.cmT.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.13
                        @Override // com.baidu.tbadk.widget.largeImage.logic.a
                        public void apH() {
                        }
                    });
                }
                this.cmT.setImageUrlData(this.cke);
                this.cmT.setImageData(ns, aVar.nx());
            }
            apv();
        }
    }

    private void e(String str, boolean z, boolean z2) {
        if (pv(str)) {
            if (z2 || (!this.cna && !this.cmZ)) {
                if (!z2 || !eR(true)) {
                    this.cna = true;
                    com.baidu.adp.lib.f.c.iv().a(str, 27, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.14
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onCancelled(String str2) {
                            UrlDragImageView.this.cna = false;
                            UrlDragImageView.this.cmT.setVisibility(0);
                            UrlDragImageView.this.mProgressBar.setVisibility(8);
                            UrlDragImageView.this.cnF = null;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            UrlDragImageView.this.cna = false;
                            UrlDragImageView.this.cmZ = true;
                            UrlDragImageView.this.b(aVar);
                        }
                    }, 0, 0, false, null, Boolean.valueOf(z), this.cmT.getImageData(), Boolean.valueOf(this.clx));
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
        imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.ai(this.mMaxWidth, this.mMaxHeight));
        com.baidu.adp.widget.ImageView.a a2 = this.cnA.a(imageFileInfo, false);
        if (a2 != null) {
            this.cmZ = true;
            this.mProgressBar.setVisibility(8);
            this.cnF = null;
            b(a2);
            return;
        }
        this.cnA.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.2
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.ImageView.a aVar, String str2, boolean z3) {
                UrlDragImageView.this.cmZ = true;
                UrlDragImageView.this.mProgressBar.setVisibility(8);
                UrlDragImageView.this.cnF = null;
                UrlDragImageView.this.b(aVar);
            }
        }, false);
    }

    private boolean pv(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith("https://"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null && this.cmX != null) {
            this.cmX.i(aVar.getUrl(), aVar.nx());
        }
        if (aVar == null || aVar.ns() == null) {
            apz();
            return;
        }
        Bitmap ns = aVar.ns();
        this.cmT.setLoadBigImage(true);
        if (aVar.isGif()) {
            this.cmT.setGifData(aVar.nx(), ns);
            this.cmT.invalidate();
            this.cmT.play();
            this.cnz = false;
            this.cnF = null;
            this.mProgressBar.setVisibility(8);
        } else {
            if (this.cke != null && this.cke.isLongPic) {
                this.cmT.avI();
                this.cmT.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.3
                    @Override // com.baidu.tbadk.widget.largeImage.logic.a
                    public void apH() {
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.cnF = null;
                    }
                });
            } else {
                this.mProgressBar.setVisibility(8);
                this.cnF = null;
            }
            this.cmT.setImageUrlData(this.cke);
            this.cmT.setImageData(ns, aVar.nx());
            apE();
        }
        apv();
    }

    private void apz() {
        if (!this.cmY) {
            this.cmT.setDefaultBitmap();
        } else {
            this.cmZ = false;
        }
        this.cnF = null;
        this.mProgressBar.setVisibility(8);
    }

    public void setGifMaxUseableMem(int i) {
        this.cmT.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.cmT != null) {
            this.cmT.onDestroy();
        }
        if (this.cmV != null) {
            this.cmV.recycle();
        }
        if (this.cnd != null) {
            this.cnd.recycle();
            this.cnd = null;
        }
        if (this.mProgressBar != null) {
            this.cnF = null;
            this.mProgressBar.setVisibility(8);
        }
        e.iB().removeCallbacks(this.cnI);
        com.baidu.tieba.view.c.cvb().setColor(-1);
    }

    public void release() {
        if (this.cmT != null) {
            this.cmT.release();
        }
        if (this.mProgressBar != null) {
            this.cnF = null;
            this.mProgressBar.setVisibility(8);
        }
        this.cnF = null;
    }

    public void apA() {
        if (this.cmT != null && this.cmT.getImageType() == 1) {
            this.cmT.stop();
        }
    }

    public void p(boolean z, boolean z2) {
        String str;
        if (this.cmT != null && (str = (String) this.cmT.getTag()) != null) {
            if (this.cmT.getImageType() == 1) {
                if (this.cmT.getGifCache() == null || !this.cmT.avT()) {
                    e(str, z, z2);
                }
            } else if (this.cmT.getImageType() == 2) {
                e(str, z, z2);
            } else if (apB()) {
                e(str, z, z2);
            }
        }
    }

    private boolean apB() {
        if (this.cmT.getImageBitmap() != null && this.cmT.avT()) {
            if (this.cke == null || !this.cke.isLongPic || this.cmT.avJ()) {
                return false;
            }
            this.cmZ = false;
            this.cnx = false;
            return true;
        }
        return true;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.cke = imageUrlData;
    }

    public ImageUrlData getmAssistUrlData() {
        return this.cke;
    }

    public void setIsCdn(boolean z) {
        this.clx = z;
    }

    public void apC() {
        final String nT = as.nT(this.cke.originalUrl);
        if (this.cke.originalProcess >= 0) {
            com.baidu.tbadk.download.d.aqM().Y(nT, 13);
            this.cke.originalProcess = -1;
            apE();
            return;
        }
        if (this.clp != null) {
            this.clp.apI();
        }
        com.baidu.adp.base.e<?> ab = i.ab(this.mContext);
        if (ab == null) {
            pw(nT);
        } else if (!j.jS() || j.jT() || com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("original_img_down_tip", false)) {
            pw(nT);
        } else {
            com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("original_img_down_tip", true);
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(ab.getPageActivity());
            aVar.ho(R.string.original_img_down_no_wifi_tip);
            aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    UrlDragImageView.this.pw(nT);
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                }
            });
            aVar.b(ab);
            aVar.afG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pw(String str) {
        if (this.cke != null) {
            this.cke.originalProcess = 0;
            this.cnG.setProgress(0);
            this.cnG.setVisibility(0);
            DownloadData downloadData = new DownloadData(str);
            downloadData.setStatus(1);
            downloadData.setUrl(this.cke.originalUrl);
            downloadData.setType(13);
            downloadData.setPath(this.cnp + ao.aig().nK(str) + "/" + str);
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.6
                @Override // com.baidu.tbadk.download.c
                public boolean onPreDownload(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2 != null) {
                        if (UrlDragImageView.this.cke != null && UrlDragImageView.this.cke.originalProcess != -1) {
                            UrlDragImageView.this.cke.originalProcess = downloadData2.getProcess();
                        }
                        if (UrlDragImageView.this.cke == null || UrlDragImageView.this.cke.originalProcess != -1) {
                            UrlDragImageView.this.cnG.setProgress(downloadData2.getProcess());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public boolean onFileDownloaded(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadSucceed(DownloadData downloadData2) {
                    UrlDragImageView.this.cnG.setVisibility(8);
                    e.iB().postDelayed(UrlDragImageView.this.cnJ, 1500L);
                    UrlDragImageView.this.cnx = false;
                    UrlDragImageView.this.cnw = UrlDragImageView.this.apD();
                    UrlDragImageView.this.apy();
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str2) {
                    UrlDragImageView.this.cnG.setVisibility(8);
                    UrlDragImageView.this.cnx = false;
                    BdToast.b(UrlDragImageView.this.mContext, str2).afM().afO();
                    UrlDragImageView.this.cke.originalProcess = -1;
                    UrlDragImageView.this.apE();
                }
            });
            com.baidu.tbadk.download.d.aqM().a(downloadData, 100);
            this.cnH = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean apD() {
        if (this.cke != null && !StringUtils.isNull(this.cke.originalUrl, true) && this.cke.originalSize >= 0 && !this.cke.isBlockedPic) {
            String nT = as.nT(this.cke.originalUrl);
            File file = new File(this.cnp + ao.aig().nK(nT) + "/" + nT);
            if (file != null && file.exists()) {
                this.cke.originalProcess = 100;
                return true;
            }
            if (this.cke.originalProcess < 0) {
                apE();
            } else {
                this.cnG.setProgress(this.cke.originalProcess);
            }
            this.cnz = true;
        } else {
            this.cnF = null;
        }
        return false;
    }

    public void apE() {
        if (this.cke != null) {
            if (!apF() || !this.cnz) {
                this.cnF = null;
            } else if (this.cke.originalSize > 0 && !be(this.cke.originalSize)) {
                this.cnF = cmR + "(" + ap.aT(this.cke.originalSize) + ")";
            } else {
                this.cnF = cmR;
            }
        }
    }

    private boolean apF() {
        return (this.cke == null || !this.cke.mIsShowOrigonButton || this.cke.isBlockedPic || StringUtils.isNull(this.cke.originalUrl)) ? false : true;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.clp = bVar;
    }

    private boolean be(long j) {
        return j > cmS;
    }
}
