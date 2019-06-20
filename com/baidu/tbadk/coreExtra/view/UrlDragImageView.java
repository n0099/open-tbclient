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
    private ImageUrlData ckf;
    private boolean clA;
    private boolean clB;
    private b clq;
    private boolean cly;
    protected DragImageView cmU;
    protected TextView cmV;
    protected SubsamplingScaleImageView cmW;
    private SubsamplingScaleImageView.OnImageEventListener cmX;
    private a cmY;
    private boolean cmZ;
    public boolean cnA;
    private com.baidu.tbadk.img.b cnB;
    private View.OnTouchListener cnC;
    private boolean cnD;
    private float cnE;
    private View.OnLongClickListener cnF;
    private String cnG;
    private CircleProgressView cnH;
    private boolean cnI;
    private Runnable cnJ;
    private Runnable cnK;
    private View.OnTouchListener cnL;
    private boolean cna;
    private boolean cnb;
    private boolean cnc;
    private boolean cnd;
    private Bitmap cne;
    private boolean cnf;
    private float cng;
    private final Matrix cnh;
    private Rect cni;
    private RectF cnj;
    private RectF cnk;
    private Rect cnl;
    private Rect cnm;
    private Rect cnn;
    private DragImageView.d cno;
    private String cnq;
    private float cnr;
    private float cns;
    private float cnu;
    private float cnv;
    private float cnw;
    private boolean cnx;
    private boolean cny;
    private boolean cnz;
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
    private static final String cmS = TbadkCoreApplication.getInst().getString(R.string.original_img_look);
    private static long cmT = Config.RAVEN_LOG_LIMIT;
    private static final int cnp = l.ah(TbadkCoreApplication.getInst()) / 5;
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
        if (this.cmU != null) {
            this.cmU.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.cmY = aVar;
    }

    public UrlDragImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.cmU = null;
        this.cmY = null;
        this.cly = false;
        this.cnb = false;
        this.cnf = false;
        this.mRatio = 1.0f;
        this.cng = 0.0f;
        this.cnh = new Matrix();
        this.cnj = new RectF();
        this.cnr = 0.0f;
        this.cns = 0.0f;
        this.cnu = 1.0f;
        this.cnv = 1.0f;
        this.cnw = 0.0f;
        this.cnx = false;
        this.cny = false;
        this.cnz = false;
        this.cnA = false;
        this.cnD = true;
        this.cnE = 0.0f;
        this.mOnClickListener = null;
        this.cnF = null;
        this.cnG = null;
        this.cnJ = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.cnD = true;
            }
        };
        this.cnK = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.cnH.setVisibility(8);
                        UrlDragImageView.this.cnG = null;
                        UrlDragImageView.this.cnA = false;
                    }
                });
            }
        };
        this.cnL = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.cnC != null) {
                    UrlDragImageView.this.cnC.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.cnB = new com.baidu.tbadk.img.b();
        init();
    }

    public UrlDragImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.cmU = null;
        this.cmY = null;
        this.cly = false;
        this.cnb = false;
        this.cnf = false;
        this.mRatio = 1.0f;
        this.cng = 0.0f;
        this.cnh = new Matrix();
        this.cnj = new RectF();
        this.cnr = 0.0f;
        this.cns = 0.0f;
        this.cnu = 1.0f;
        this.cnv = 1.0f;
        this.cnw = 0.0f;
        this.cnx = false;
        this.cny = false;
        this.cnz = false;
        this.cnA = false;
        this.cnD = true;
        this.cnE = 0.0f;
        this.mOnClickListener = null;
        this.cnF = null;
        this.cnG = null;
        this.cnJ = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.cnD = true;
            }
        };
        this.cnK = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.cnH.setVisibility(8);
                        UrlDragImageView.this.cnG = null;
                        UrlDragImageView.this.cnA = false;
                    }
                });
            }
        };
        this.cnL = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.cnC != null) {
                    UrlDragImageView.this.cnC.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.cnB = new com.baidu.tbadk.img.b();
        init();
    }

    public DragImageView getImageView() {
        return this.cmU;
    }

    public void setGifSetListener(DragImageView.e eVar) {
        this.cmU.setGifSetListener(eVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.cmU.setImageOnClickListener(onClickListener);
        this.cmW.setOnClickListener(onClickListener);
        this.mOnClickListener = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cnF = onLongClickListener;
        if (!this.clA) {
            this.cmU.setImageOnLongClickListener(this.cnF);
            this.cmW.setOnLongClickListener(this.cnF);
        }
    }

    public void setOnSizeChangedListener(final DragImageView.g gVar) {
        this.cmU.setOnSizeChangedListener(new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.8
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
        this.cnq = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        this.mMaxWidth = l.af(this.mContext);
        this.mMaxHeight = l.ah(this.mContext) - ((int) this.mContext.getResources().getDimension(R.dimen.ds166));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.cmU = new DragImageView(this.mContext);
        this.cmU.setLayoutParams(layoutParams);
        this.cmU.setOnTouchListener(this.cnL);
        addView(this.cmU);
        this.cmW = new SubsamplingScaleImageView(this.mContext);
        this.cmW.setMaxScale(50.0f);
        this.cmW.setOnTouchListener(this.cnL);
        this.cmW.setVisibility(4);
        addView(this.cmW, layoutParams);
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
        this.cnH = new CircleProgressView(this.mContext);
        this.cnH.setCircleBackgroundColor(al.getColor(R.color.cp_cont_d));
        this.cnH.setCircleForegroundColor(al.getColor(R.color.cp_link_tip_a));
        this.cnH.setProgress(0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.g(getContext(), R.dimen.tbds80), l.g(getContext(), R.dimen.tbds80));
        layoutParams.addRule(13);
        this.cnH.setVisibility(8);
        addView(this.cnH, layoutParams);
    }

    public void setIsCanDrag(boolean z) {
        this.clA = z;
    }

    public void setIsHotSort(boolean z) {
        this.clB = z;
    }

    public String getmCheckOriginPicText() {
        return this.cnG;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        Bitmap imageBitmap;
        int height;
        int width;
        if (this.cnx && !this.cnI && this.cmW.getVisibility() == 0 && !this.cmW.isImageLoaded()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.clA || !this.cna) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.cnc && motionEvent.getPointerCount() >= 2) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.cnc || this.cnd) {
            requestDisallowInterceptTouchEvent(true);
        }
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        float x = motionEvent.getX();
        int i = action & 255;
        if (i == 0) {
            if (this.cne == null) {
                if (this.cmW.getVisibility() == 0) {
                    this.cne = f.bf(this.cmW);
                } else {
                    this.cne = f.bf(this.cmU);
                }
            }
            if (this.cni == null && this.cne != null) {
                int measuredWidth = getMeasuredWidth();
                float measuredWidth2 = ((getMeasuredWidth() * 1.0f) / this.cne.getWidth()) * this.cne.getHeight();
                if (measuredWidth2 > getMeasuredHeight()) {
                    measuredWidth2 = getMeasuredHeight();
                }
                RectF h = h(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
                this.cni = new Rect((int) h.left, (int) h.top, (int) h.right, (int) h.bottom);
            }
            if (this.cnm == null && this.cne != null) {
                if (this.cmW.getVisibility() == 0) {
                    height = this.cmW.getSHeight();
                    width = this.cmW.getSWidth();
                } else {
                    if (this.cmU.getImageType() == 1) {
                        imageBitmap = (this.cmU.getCurrentFrame() == null || this.cmU.getCurrentFrame().cDh == null) ? this.cne : this.cmU.getCurrentFrame().cDh;
                    } else {
                        imageBitmap = this.cmU.getImageBitmap() == null ? this.cne : this.cmU.getImageBitmap();
                    }
                    height = imageBitmap.getHeight();
                    width = imageBitmap.getWidth();
                }
                float ai = l.ai(getContext());
                int i2 = (int) (height * ai);
                int i3 = (int) (width * ai);
                if (i3 > this.cne.getWidth() && this.cne.getWidth() != 0) {
                    float width2 = (i3 * 1.0f) / this.cne.getWidth();
                    i3 = this.cne.getWidth();
                    i2 = (int) (i2 / width2);
                }
                if (i2 > this.cne.getHeight() && this.cne.getHeight() != 0) {
                    i3 = (int) (i3 / ((i2 * 1.0f) / this.cne.getHeight()));
                    i2 = this.cne.getHeight();
                }
                int ah = (l.ah(getContext()) - i2) / 2;
                int af = (l.af(getContext()) - i3) / 2;
                this.cnm = new Rect(af, ah, i3 + af, i2 + ah);
                this.cnn = new Rect(this.cnm);
                this.cnw = ah / l.ah(getContext());
                this.cnl = new Rect(0, 0, this.cne.getWidth(), this.cne.getHeight());
            }
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (i == 2) {
            this.cnc = r(this.mLastMotionX - x, this.mLastMotionY - y);
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (this.cnc || this.cnd) {
            this.cmU.setImageOnLongClickListener(null);
            this.cmW.setOnLongClickListener(null);
            z = true;
        } else {
            this.cmU.setImageOnLongClickListener(this.cnF);
            this.cmW.setOnLongClickListener(this.cnF);
            z = super.dispatchTouchEvent(motionEvent);
        }
        if (i == 1 || i == 3) {
            this.mLastMotionX = 0.0f;
            this.mLastMotionY = 0.0f;
            if (this.cng > cnp) {
                this.cnd = true;
                apu();
            } else {
                if (this.cnc && this.cno != null) {
                    this.cno.avY();
                }
                this.mRatio = 1.0f;
                invalidate();
            }
            this.cnf = false;
            this.cnh.reset();
            this.cnc = false;
            return z;
        }
        return z;
    }

    private boolean r(float f, float f2) {
        if (this.cmW.getVisibility() != 0 || this.cmW.isCanDrag()) {
            if (this.ckf == null || !this.ckf.isLongPic || this.cmW.getVisibility() != 0 || this.cmW.isViewTop()) {
                if (this.ckf == null || !this.ckf.isLongPic || this.cmW.getVisibility() == 0 || this.cmU.avE()) {
                    if (this.cmW.getVisibility() == 0 || this.cmU.avG()) {
                        if (this.cne != null && getScrollY() == 0 && f2 < 0.0f && !this.cnf) {
                            this.cmU.setImageOnLongClickListener(null);
                            this.cmW.setOnLongClickListener(null);
                            this.cnf = true;
                            this.cng = 0.0f;
                            this.mRatio = 1.0f;
                            if (this.cno != null) {
                                this.cno.avW();
                            }
                        }
                        if (!this.cnf || this.cne == null) {
                            return false;
                        }
                        this.cng -= f2;
                        int measuredHeight = getMeasuredHeight();
                        if (this.cng > measuredHeight) {
                            this.cng = measuredHeight;
                        }
                        float f3 = f2 / measuredHeight;
                        this.cnh.postTranslate((-f) * 1.5f * this.mRatio, (-1.5f) * f2 * this.mRatio);
                        if (this.mRatio * (1.0f + f3) > 1.0f || this.cng < 0.0f) {
                            this.cnh.preScale(1.0f / this.mRatio, 1.0f / this.mRatio, (this.mRatio * this.cne.getWidth()) / 2.0f, this.mRatio * (this.cne.getHeight() / 2));
                            this.mRatio = 1.0f;
                        } else {
                            this.cnh.preScale(1.0f + f3, 1.0f + f3, (this.mRatio * this.cne.getWidth()) / 2.0f, this.mRatio * (this.cne.getHeight() / 2));
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
        if (this.cnc && this.cne != null && !this.cne.isRecycled() && this.cnf) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.cnj == null) {
                this.cnj = new RectF();
            }
            this.cnh.mapRect(this.cnj, new RectF(this.cni));
            canvas.drawBitmap(this.cne, this.cnl, this.cnj, (Paint) null);
        } else if (this.cnd && this.cne != null && !this.cne.isRecycled()) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.ckf == null || this.ckf.getSourceImageRectInScreen() == null) {
                canvas.drawBitmap(this.cne, this.cnl, this.cnj, (Paint) null);
            } else {
                canvas.drawBitmap(this.cne, this.cnm, this.cnj, (Paint) null);
            }
        } else {
            super.dispatchDraw(canvas);
        }
    }

    private void apu() {
        if (this.ckf == null) {
            if (this.cno != null) {
                this.cno.avX();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.ckf.getSourceImageRectInScreen();
        final Rect dstRectInScreen = this.ckf.getDstRectInScreen();
        if (sourceImageRectInScreen == null || dstRectInScreen == null) {
            if (this.cno != null) {
                this.cno.avX();
                return;
            }
            return;
        }
        a(sourceImageRectInScreen, dstRectInScreen);
        f(sourceImageRectInScreen);
        this.cnk = new RectF(this.cnj);
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
                UrlDragImageView.this.cnf = false;
                UrlDragImageView.this.invalidate();
                if (UrlDragImageView.this.cno != null) {
                    UrlDragImageView.this.cno.avX();
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
            float f = ((rect.bottom - rect.top) / (rect.right - rect.left)) * (this.cnj.right - this.cnj.left);
            this.cnj.top += this.cnj.height() * this.cnw;
            this.cnj.bottom = f + this.cnj.top;
        }
    }

    public void setCanScale(boolean z) {
        if (this.cmU != null) {
            this.cmU.setCanScale(z);
        }
    }

    private void a(Rect rect, Rect rect2) {
        this.cnr = 0.0f;
        this.cns = 0.0f;
        this.cnu = 1.0f;
        this.cnv = 1.0f;
        if (rect != null && rect2 != null && rect.contains(rect2)) {
            this.cnr = (rect2.left - rect.left) / rect.width();
            this.cns = (rect2.top - rect.top) / rect.height();
            this.cnu = (rect2.right - rect.left) / rect.width();
            this.cnv = (rect2.bottom - rect.top) / rect.height();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(float f) {
        if (this.cnm != null) {
            this.cnm.left = (int) (this.cnn.left + (this.cnn.width() * this.cnr * f));
            this.cnm.top = (int) (this.cnn.top + (this.cnn.height() * this.cns * f));
            this.cnm.right = (int) (this.cnn.left + (this.cnn.width() * (((1.0f - this.cnu) * (1.0f - f)) + this.cnu)));
            this.cnm.bottom = (int) (this.cnn.top + (this.cnn.height() * (((1.0f - this.cnv) * (1.0f - f)) + this.cnv)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Rect rect, float f) {
        if (this.cnj != null && rect != null) {
            this.cnj.left = this.cnk.left + ((rect.left - this.cnk.left) * f);
            this.cnj.top = this.cnk.top + ((rect.top - this.cnk.top) * f);
            this.cnj.right = this.cnk.right + ((rect.right - this.cnk.right) * f);
            this.cnj.bottom = this.cnk.bottom + ((rect.bottom - this.cnk.bottom) * f);
        }
    }

    private RectF h(float f, float f2, float f3, float f4) {
        return new RectF(f - (f3 / 2.0f), f2 - (f4 / 2.0f), (f3 / 2.0f) + f, (f4 / 2.0f) + f2);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.cnC = onTouchListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apv() {
        if ((this.cmZ || this.cna) && this.ckf != null && this.ckf.mPicType == 1 && !TextUtils.isEmpty(this.ckf.mTagName)) {
            if (this.cmV != null) {
                this.cmV.setVisibility(8);
                this.cmV = null;
            }
            this.cmV = new TextView(this.mContext);
            this.cmV.setText(this.ckf.mTagName);
            this.cmV.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize26));
            al.c(this.cmV, R.color.common_color_10013, 1, 0);
            al.l(this.cmV, R.color.common_color_10215);
            this.cmV.setAlpha(0.75f);
            this.cmV.setIncludeFontPadding(false);
            this.cmV.setGravity(17);
            int g = l.g(this.mContext, R.dimen.ds2);
            this.cmV.setPadding(g, g, g, g);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.cmU.getBottomOffset();
            layoutParams.leftMargin = this.cmU.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.cmV, layoutParams);
            this.cmV.setVisibility(0);
        }
    }

    public void setUrl(String str, boolean z) {
        if (str.contains("*")) {
            str = str.split("[*]")[0];
        }
        this.cmU.setTag(str);
        this.cmU.setLoadBigImage(false);
        this.cmU.setImageDrawable(null);
        this.cmZ = false;
        this.cna = false;
        this.cnx = apD();
        this.cnG = null;
        if (pt(str)) {
            e(str, z, false);
        }
    }

    private boolean apw() {
        return this.cmU != null && this.cmU.avU();
    }

    public void apx() {
        if (this.ckf != null && !apw()) {
            String str = this.ckf.imageUrl;
            int i = this.ckf.urlType;
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
        String nS;
        if (!this.cny || z) {
            this.cny = true;
            if (!this.cnx || this.ckf == null || StringUtils.isNull(this.ckf.originalUrl, true) || this.ckf.originalSize < 0 || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String str = this.cnq + ao.aig().nJ(nS) + "/" + as.nS(this.ckf.originalUrl);
            final int[] nm = m.nm(str);
            this.cmW.setVisibility(0);
            if (this.cmX == null) {
                this.cmX = new SubsamplingScaleImageView.OnImageEventListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12
                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onReady() {
                        UrlDragImageView.this.cnG = null;
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.cmU.avQ();
                        UrlDragImageView.this.cmU.setVisibility(4);
                    }

                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onImageLoaded() {
                        if (UrlDragImageView.this.ckf.isLongPic && nm[0] > 0) {
                            UrlDragImageView.this.cmU.onDestroy();
                            final float measuredWidth = (UrlDragImageView.this.getMeasuredWidth() * 1.0f) / nm[0];
                            final PointF pointF = new PointF((nm[0] * 1.0f) / 2.0f, 0.0f);
                            UrlDragImageView.this.cmW.setScaleAndCenter(measuredWidth, pointF);
                            UrlDragImageView.this.cmW.setMaxScale(2.0f * measuredWidth);
                            UrlDragImageView.this.cmW.setDoubleTapZoomScale(2.0f * measuredWidth);
                            UrlDragImageView.this.cmW.setInitScale(measuredWidth);
                            UrlDragImageView.this.cmW.setDoubleTapZoomStyle(4);
                            UrlDragImageView.this.cmW.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12.1
                                @Override // android.view.View.OnTouchListener
                                public boolean onTouch(View view, MotionEvent motionEvent) {
                                    if (UrlDragImageView.this.cnC != null) {
                                        UrlDragImageView.this.cnC.onTouch(view, motionEvent);
                                    }
                                    switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                                        case 0:
                                            UrlDragImageView.this.cnE = motionEvent.getY();
                                            UrlDragImageView.this.cmW.setOnClickListener(UrlDragImageView.this.cnD ? UrlDragImageView.this.mOnClickListener : null);
                                            UrlDragImageView.this.cmW.setOnLongClickListener(UrlDragImageView.this.cnD ? UrlDragImageView.this.cnF : null);
                                            break;
                                        case 1:
                                        case 3:
                                            if (UrlDragImageView.this.cmW.getScale() < measuredWidth) {
                                                UrlDragImageView.this.cmW.setScaleAndCenter(measuredWidth, pointF);
                                            }
                                            e.iB().removeCallbacks(UrlDragImageView.this.cnJ);
                                            e.iB().postDelayed(UrlDragImageView.this.cnJ, 1000L);
                                            break;
                                        case 2:
                                            if (Math.abs(motionEvent.getY() - UrlDragImageView.this.cnE) > UrlDragImageView.TOUCH_SLOP) {
                                                UrlDragImageView.this.cnD = false;
                                                UrlDragImageView.this.cmW.setOnClickListener(null);
                                                UrlDragImageView.this.cmW.setOnLongClickListener(null);
                                            }
                                            UrlDragImageView.this.cnE = motionEvent.getY();
                                            break;
                                    }
                                    return false;
                                }
                            });
                            UrlDragImageView.this.cmU.setVisibility(4);
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
            this.cmW.setOnImageEventListener(this.cmX);
            if (this.cmW.isImageLoaded() && this.ckf.isLongPic) {
                this.cmX.onImageLoaded();
            } else {
                this.cmW.setImage(ImageSource.uri(str));
            }
            return true;
        }
        return false;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.cno = dVar;
        if (this.cmU != null) {
            this.cmU.setDragToExitListener(dVar);
        }
    }

    public void apy() {
        eR(false);
    }

    private boolean pt(String str) {
        return j.jS() || com.baidu.tbadk.core.util.d.c.ok(str);
    }

    private void setThumbBitmapToView(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap ns;
        if (!this.cna && aVar != null && (ns = aVar.ns()) != null) {
            this.cmZ = true;
            if (aVar.isGif()) {
                this.cmU.setImageUrlData(this.ckf);
                this.cmU.setImageBitmap(ns);
                this.cnG = null;
                this.cnA = false;
            } else {
                if (this.ckf != null && this.ckf.isLongPic) {
                    this.cmU.avJ();
                    this.cmU.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.13
                        @Override // com.baidu.tbadk.widget.largeImage.logic.a
                        public void apH() {
                        }
                    });
                }
                this.cmU.setImageUrlData(this.ckf);
                this.cmU.setImageData(ns, aVar.nx());
            }
            apv();
        }
    }

    private void e(String str, boolean z, boolean z2) {
        if (pu(str)) {
            if (z2 || (!this.cnb && !this.cna)) {
                if (!z2 || !eR(true)) {
                    this.cnb = true;
                    com.baidu.adp.lib.f.c.iv().a(str, 27, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.14
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onCancelled(String str2) {
                            UrlDragImageView.this.cnb = false;
                            UrlDragImageView.this.cmU.setVisibility(0);
                            UrlDragImageView.this.mProgressBar.setVisibility(8);
                            UrlDragImageView.this.cnG = null;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            UrlDragImageView.this.cnb = false;
                            UrlDragImageView.this.cna = true;
                            UrlDragImageView.this.b(aVar);
                        }
                    }, 0, 0, false, null, Boolean.valueOf(z), this.cmU.getImageData(), Boolean.valueOf(this.cly));
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
        com.baidu.adp.widget.ImageView.a a2 = this.cnB.a(imageFileInfo, false);
        if (a2 != null) {
            this.cna = true;
            this.mProgressBar.setVisibility(8);
            this.cnG = null;
            b(a2);
            return;
        }
        this.cnB.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.2
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.ImageView.a aVar, String str2, boolean z3) {
                UrlDragImageView.this.cna = true;
                UrlDragImageView.this.mProgressBar.setVisibility(8);
                UrlDragImageView.this.cnG = null;
                UrlDragImageView.this.b(aVar);
            }
        }, false);
    }

    private boolean pu(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith("https://"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null && this.cmY != null) {
            this.cmY.i(aVar.getUrl(), aVar.nx());
        }
        if (aVar == null || aVar.ns() == null) {
            apz();
            return;
        }
        Bitmap ns = aVar.ns();
        this.cmU.setLoadBigImage(true);
        if (aVar.isGif()) {
            this.cmU.setGifData(aVar.nx(), ns);
            this.cmU.invalidate();
            this.cmU.play();
            this.cnA = false;
            this.cnG = null;
            this.mProgressBar.setVisibility(8);
        } else {
            if (this.ckf != null && this.ckf.isLongPic) {
                this.cmU.avJ();
                this.cmU.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.3
                    @Override // com.baidu.tbadk.widget.largeImage.logic.a
                    public void apH() {
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.cnG = null;
                    }
                });
            } else {
                this.mProgressBar.setVisibility(8);
                this.cnG = null;
            }
            this.cmU.setImageUrlData(this.ckf);
            this.cmU.setImageData(ns, aVar.nx());
            apE();
        }
        apv();
    }

    private void apz() {
        if (!this.cmZ) {
            this.cmU.setDefaultBitmap();
        } else {
            this.cna = false;
        }
        this.cnG = null;
        this.mProgressBar.setVisibility(8);
    }

    public void setGifMaxUseableMem(int i) {
        this.cmU.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.cmU != null) {
            this.cmU.onDestroy();
        }
        if (this.cmW != null) {
            this.cmW.recycle();
        }
        if (this.cne != null) {
            this.cne.recycle();
            this.cne = null;
        }
        if (this.mProgressBar != null) {
            this.cnG = null;
            this.mProgressBar.setVisibility(8);
        }
        e.iB().removeCallbacks(this.cnJ);
        com.baidu.tieba.view.c.cvc().setColor(-1);
    }

    public void release() {
        if (this.cmU != null) {
            this.cmU.release();
        }
        if (this.mProgressBar != null) {
            this.cnG = null;
            this.mProgressBar.setVisibility(8);
        }
        this.cnG = null;
    }

    public void apA() {
        if (this.cmU != null && this.cmU.getImageType() == 1) {
            this.cmU.stop();
        }
    }

    public void p(boolean z, boolean z2) {
        String str;
        if (this.cmU != null && (str = (String) this.cmU.getTag()) != null) {
            if (this.cmU.getImageType() == 1) {
                if (this.cmU.getGifCache() == null || !this.cmU.avU()) {
                    e(str, z, z2);
                }
            } else if (this.cmU.getImageType() == 2) {
                e(str, z, z2);
            } else if (apB()) {
                e(str, z, z2);
            }
        }
    }

    private boolean apB() {
        if (this.cmU.getImageBitmap() != null && this.cmU.avU()) {
            if (this.ckf == null || !this.ckf.isLongPic || this.cmU.avK()) {
                return false;
            }
            this.cna = false;
            this.cny = false;
            return true;
        }
        return true;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.ckf = imageUrlData;
    }

    public ImageUrlData getmAssistUrlData() {
        return this.ckf;
    }

    public void setIsCdn(boolean z) {
        this.cly = z;
    }

    public void apC() {
        final String nS = as.nS(this.ckf.originalUrl);
        if (this.ckf.originalProcess >= 0) {
            com.baidu.tbadk.download.d.aqM().Y(nS, 13);
            this.ckf.originalProcess = -1;
            apE();
            return;
        }
        if (this.clq != null) {
            this.clq.apI();
        }
        com.baidu.adp.base.e<?> ab = i.ab(this.mContext);
        if (ab == null) {
            pv(nS);
        } else if (!j.jS() || j.jT() || com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("original_img_down_tip", false)) {
            pv(nS);
        } else {
            com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("original_img_down_tip", true);
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(ab.getPageActivity());
            aVar.ho(R.string.original_img_down_no_wifi_tip);
            aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    UrlDragImageView.this.pv(nS);
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
    public void pv(String str) {
        if (this.ckf != null) {
            this.ckf.originalProcess = 0;
            this.cnH.setProgress(0);
            this.cnH.setVisibility(0);
            DownloadData downloadData = new DownloadData(str);
            downloadData.setStatus(1);
            downloadData.setUrl(this.ckf.originalUrl);
            downloadData.setType(13);
            downloadData.setPath(this.cnq + ao.aig().nJ(str) + "/" + str);
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.6
                @Override // com.baidu.tbadk.download.c
                public boolean onPreDownload(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2 != null) {
                        if (UrlDragImageView.this.ckf != null && UrlDragImageView.this.ckf.originalProcess != -1) {
                            UrlDragImageView.this.ckf.originalProcess = downloadData2.getProcess();
                        }
                        if (UrlDragImageView.this.ckf == null || UrlDragImageView.this.ckf.originalProcess != -1) {
                            UrlDragImageView.this.cnH.setProgress(downloadData2.getProcess());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public boolean onFileDownloaded(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadSucceed(DownloadData downloadData2) {
                    UrlDragImageView.this.cnH.setVisibility(8);
                    e.iB().postDelayed(UrlDragImageView.this.cnK, 1500L);
                    UrlDragImageView.this.cny = false;
                    UrlDragImageView.this.cnx = UrlDragImageView.this.apD();
                    UrlDragImageView.this.apy();
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str2) {
                    UrlDragImageView.this.cnH.setVisibility(8);
                    UrlDragImageView.this.cny = false;
                    BdToast.b(UrlDragImageView.this.mContext, str2).afM().afO();
                    UrlDragImageView.this.ckf.originalProcess = -1;
                    UrlDragImageView.this.apE();
                }
            });
            com.baidu.tbadk.download.d.aqM().a(downloadData, 100);
            this.cnI = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean apD() {
        if (this.ckf != null && !StringUtils.isNull(this.ckf.originalUrl, true) && this.ckf.originalSize >= 0 && !this.ckf.isBlockedPic) {
            String nS = as.nS(this.ckf.originalUrl);
            File file = new File(this.cnq + ao.aig().nJ(nS) + "/" + nS);
            if (file != null && file.exists()) {
                this.ckf.originalProcess = 100;
                return true;
            }
            if (this.ckf.originalProcess < 0) {
                apE();
            } else {
                this.cnH.setProgress(this.ckf.originalProcess);
            }
            this.cnA = true;
        } else {
            this.cnG = null;
        }
        return false;
    }

    public void apE() {
        if (this.ckf != null) {
            if (!apF() || !this.cnA) {
                this.cnG = null;
            } else if (this.ckf.originalSize > 0 && !be(this.ckf.originalSize)) {
                this.cnG = cmS + "(" + ap.aT(this.ckf.originalSize) + ")";
            } else {
                this.cnG = cmS;
            }
        }
    }

    private boolean apF() {
        return (this.ckf == null || !this.ckf.mIsShowOrigonButton || this.ckf.isBlockedPic || StringUtils.isNull(this.ckf.originalUrl)) ? false : true;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.clq = bVar;
    }

    private boolean be(long j) {
        return j > cmT;
    }
}
