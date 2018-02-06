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
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.a;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.d;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.File;
/* loaded from: classes.dex */
public class f extends RelativeLayout implements View.OnClickListener {
    private boolean bmF;
    private b bmH;
    private boolean bmI;
    protected com.baidu.tbadk.widget.a boT;
    protected TextView boU;
    protected TextView boV;
    protected TextView boW;
    protected SubsamplingScaleImageView boX;
    private SubsamplingScaleImageView.OnImageEventListener boY;
    private a boZ;
    private View.OnLongClickListener bpA;
    private Runnable bpB;
    private Runnable bpC;
    private View.OnTouchListener bpD;
    private boolean bpa;
    private boolean bpb;
    private boolean bpc;
    private boolean bpd;
    private boolean bpe;
    private Bitmap bpf;
    private boolean bpg;
    private float bph;
    private Matrix bpi;
    private Rect bpj;
    private RectF bpk;
    private Rect bpl;
    private Rect bpm;
    private a.d bpn;
    private String bpp;
    private ImageUrlData bpq;
    private boolean bpr;
    private boolean bps;
    private boolean bpt;
    public boolean bpu;
    private TextView bpv;
    private com.baidu.tbadk.img.b bpw;
    private View.OnTouchListener bpx;
    private boolean bpy;
    private float bpz;
    protected Context mContext;
    private float mLastMotionX;
    private float mLastMotionY;
    private int mMaxHeight;
    private int mMaxWidth;
    private View.OnClickListener mOnClickListener;
    protected ProgressBar mProgressBar;
    private float mRatio;
    private int mSkinType;
    private static final String boR = TbadkCoreApplication.getInst().getString(d.j.original_img_look);
    private static long boS = 52428800;
    private static final int bpo = l.aq(TbadkCoreApplication.getInst()) / 5;
    private static final String TAG = f.class.getSimpleName();
    private static final int TOUCH_SLOP = ViewConfiguration.get(TbadkCoreApplication.getInst()).getScaledTouchSlop();

    /* loaded from: classes.dex */
    public interface a {
        void k(String str, byte[] bArr);
    }

    /* loaded from: classes.dex */
    public interface b {
        void JQ();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.boU != null) {
                aj.s(this.boU, d.f.btn_percent_yuantu);
                aj.b(this.boU, d.C0140d.cp_cont_g, 1, 0);
            }
            if (this.boV != null) {
                aj.t(this.boV, d.C0140d.common_color_10022);
                aj.b(this.boV, d.C0140d.cp_cont_g, 1, 0);
            }
            this.mSkinType = i;
        }
    }

    public void setHeadImage(boolean z) {
        if (this.boT != null) {
            this.boT.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.boZ = aVar;
    }

    public f(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mContext = null;
        this.mProgressBar = null;
        this.boT = null;
        this.boZ = null;
        this.bmF = false;
        this.bpc = false;
        this.bpg = false;
        this.mRatio = 1.0f;
        this.bph = 0.0f;
        this.bpi = new Matrix();
        this.bpk = new RectF();
        this.bpr = false;
        this.bps = false;
        this.bpt = false;
        this.bpu = false;
        this.bpv = null;
        this.bpy = true;
        this.bpz = 0.0f;
        this.mOnClickListener = null;
        this.bpA = null;
        this.bpB = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.f.1
            @Override // java.lang.Runnable
            public void run() {
                f.this.bpy = true;
            }
        };
        this.bpC = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.f.7
            @Override // java.lang.Runnable
            public void run() {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(200L);
                alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tbadk.coreExtra.view.f.7.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        f.this.boU.setVisibility(8);
                        f.this.bpu = false;
                    }
                });
                f.this.boU.startAnimation(alphaAnimation);
            }
        };
        this.bpD = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.f.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (f.this.bpx != null) {
                    f.this.bpx.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.bpw = new com.baidu.tbadk.img.b();
        init();
    }

    public com.baidu.tbadk.widget.a getImageView() {
        return this.boT;
    }

    public void setGifSetListener(a.e eVar) {
        this.boT.setGifSetListener(eVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.boT.setImageOnClickListener(onClickListener);
        this.boX.setOnClickListener(onClickListener);
        this.mOnClickListener = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bpA = onLongClickListener;
        if (!this.bmI) {
            this.boT.setImageOnLongClickListener(this.bpA);
            this.boX.setOnLongClickListener(this.bpA);
        }
    }

    public void setOnSizeChangedListener(final a.f fVar) {
        this.boT.setOnSizeChangedListener(new a.f() { // from class: com.baidu.tbadk.coreExtra.view.f.8
            @Override // com.baidu.tbadk.widget.a.f
            public void a(com.baidu.tbadk.widget.a aVar, boolean z, boolean z2) {
                if (fVar != null) {
                    fVar.a(aVar, z, z2);
                }
                f.this.JE();
            }
        });
    }

    protected void init() {
        this.mMaxWidth = l.ao(this.mContext);
        this.mMaxHeight = l.aq(this.mContext) - ((int) this.mContext.getResources().getDimension(d.e.ds166));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.boT = new com.baidu.tbadk.widget.a(this.mContext);
        this.boT.setLayoutParams(layoutParams);
        this.boT.setOnTouchListener(this.bpD);
        addView(this.boT);
        this.boX = new SubsamplingScaleImageView(this.mContext);
        this.boX.setMaxScale(50.0f);
        this.boX.setOnTouchListener(this.bpD);
        this.boX.setVisibility(4);
        addView(this.boX, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(getResources().getDrawable(d.f.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        JA();
        Jy();
        JB();
    }

    private void Jy() {
        this.bpp = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        this.boU = new TextView(this.mContext);
        aj.s(this.boU, d.f.btn_percent_yuantu);
        this.boU.setText(d.j.original_img_look);
        this.boU.setTextSize(0, getResources().getDimensionPixelSize(d.e.fontsize28));
        aj.b(this.boU, d.C0140d.cp_cont_g, 1, 0);
        this.boU.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds20);
        this.boU.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        this.boU.setMinWidth(getResources().getDimensionPixelSize(d.e.ds220));
        this.boU.setMinHeight(getResources().getDimensionPixelSize(d.e.ds68));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(d.e.fontsize40);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        this.boU.setOnClickListener(this);
        this.boU.setVisibility(8);
        addView(this.boU, layoutParams);
    }

    public void setIsCanDrag(boolean z) {
        this.bmI = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        Bitmap imageBitmap;
        int height;
        int width;
        if (!this.bmI || !this.bpb) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.bpd && motionEvent.getPointerCount() >= 2) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.bpd || this.bpe) {
            requestDisallowInterceptTouchEvent(true);
        }
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        float x = motionEvent.getX();
        int i = action & 255;
        if (i == 0) {
            if (this.bpf == null) {
                if (this.boX.getVisibility() == 0) {
                    this.bpf = com.baidu.tbadk.util.d.bm(this.boX);
                } else {
                    this.bpf = com.baidu.tbadk.util.d.bm(this.boT);
                }
            }
            if (this.bpj == null && this.bpf != null) {
                int measuredWidth = getMeasuredWidth();
                float measuredWidth2 = ((getMeasuredWidth() * 1.0f) / this.bpf.getWidth()) * this.bpf.getHeight();
                if (measuredWidth2 > getMeasuredHeight()) {
                    measuredWidth2 = getMeasuredHeight();
                }
                RectF i2 = i(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
                this.bpj = new Rect((int) i2.left, (int) i2.top, (int) i2.right, (int) i2.bottom);
            }
            if (this.bpm == null && this.bpf != null) {
                if (this.boX.getVisibility() == 0) {
                    height = this.boX.getSHeight();
                    width = this.boX.getSWidth();
                } else {
                    if (this.boT.getImageType() == 1) {
                        imageBitmap = (this.boT.getCurrentFrame() == null || this.boT.getCurrentFrame().bED == null) ? this.bpf : this.boT.getCurrentFrame().bED;
                    } else {
                        imageBitmap = this.boT.getImageBitmap() == null ? this.bpf : this.boT.getImageBitmap();
                    }
                    height = imageBitmap.getHeight();
                    width = imageBitmap.getWidth();
                }
                float ar = l.ar(getContext());
                int i3 = (int) (height * ar);
                int i4 = (int) (width * ar);
                if (i4 > this.bpf.getWidth() && this.bpf.getWidth() != 0) {
                    float width2 = (i4 * 1.0f) / this.bpf.getWidth();
                    i4 = this.bpf.getWidth();
                    i3 = (int) (i3 / width2);
                }
                if (i3 > this.bpf.getHeight() && this.bpf.getHeight() != 0) {
                    i4 = (int) (i4 / ((i3 * 1.0f) / this.bpf.getHeight()));
                    i3 = this.bpf.getHeight();
                }
                int aq = (l.aq(getContext()) - i3) / 2;
                int ao = (l.ao(getContext()) - i4) / 2;
                this.bpm = new Rect(ao, aq, i4 + ao, i3 + aq);
                this.bpl = new Rect(0, 0, this.bpf.getWidth(), this.bpf.getHeight());
            }
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (i == 2) {
            this.bpd = l(this.mLastMotionX - x, this.mLastMotionY - y);
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (this.bpd || this.bpe) {
            this.boT.setImageOnLongClickListener(null);
            this.boX.setOnLongClickListener(null);
            z = true;
        } else {
            this.boT.setImageOnLongClickListener(this.bpA);
            this.boX.setOnLongClickListener(this.bpA);
            z = super.dispatchTouchEvent(motionEvent);
        }
        if (i == 1 || i == 3) {
            this.mLastMotionX = 0.0f;
            this.mLastMotionY = 0.0f;
            this.bpg = false;
            this.bpi.reset();
            this.bpd = false;
            if (this.bph > bpo) {
                this.bpe = true;
                Jz();
                return z;
            }
            this.mRatio = 1.0f;
            invalidate();
            return z;
        }
        return z;
    }

    private boolean l(float f, float f2) {
        if (this.boX.getVisibility() != 0 || this.boX.isCanDrag()) {
            if (this.bpq == null || !this.bpq.isLongPic || this.boX.getVisibility() != 0 || this.boX.isViewTop()) {
                if (this.bpq == null || !this.bpq.isLongPic || this.boX.getVisibility() == 0 || this.boT.Pv()) {
                    if (this.boX.getVisibility() == 0 || this.boT.Px()) {
                        if (this.bpf != null && getScrollY() == 0 && f2 < 0.0f && !this.bpg) {
                            this.bpg = true;
                            this.bph = 0.0f;
                            this.mRatio = 1.0f;
                            if (this.bpn != null) {
                                this.bpn.PO();
                            }
                        }
                        if (this.bpg) {
                            this.bph -= f2;
                            int measuredHeight = getMeasuredHeight();
                            if (this.bph > measuredHeight) {
                                this.bph = measuredHeight;
                            }
                            float f3 = f2 / measuredHeight;
                            this.bpi.postTranslate((-f) * 1.5f * this.mRatio, (-1.5f) * f2 * this.mRatio);
                            if (this.mRatio * (1.0f + f3) > 1.0f || this.bph < 0.0f) {
                                this.bpi.preScale(1.0f / this.mRatio, 1.0f / this.mRatio, (this.mRatio * this.bpf.getWidth()) / 2.0f, this.mRatio * (this.bpf.getHeight() / 2));
                                this.mRatio = 1.0f;
                            } else {
                                this.bpi.preScale(1.0f + f3, 1.0f + f3, (this.mRatio * this.bpf.getWidth()) / 2.0f, this.mRatio * (this.bpf.getHeight() / 2));
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
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.bpd && this.bpf != null && !this.bpf.isRecycled() && this.bpg) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.bpk == null) {
                this.bpk = new RectF();
            }
            this.bpi.mapRect(this.bpk, new RectF(this.bpj));
            canvas.drawBitmap(this.bpf, this.bpl, this.bpk, (Paint) null);
        } else if (this.bpe && this.bpf != null && !this.bpf.isRecycled()) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.bpq == null || this.bpq.getSourceImageRectInScreen() == null) {
                canvas.drawBitmap(this.bpf, this.bpl, this.bpk, (Paint) null);
            } else {
                canvas.drawBitmap(this.bpf, this.bpm, this.bpk, (Paint) null);
            }
        } else {
            super.dispatchDraw(canvas);
        }
    }

    private void Jz() {
        if (this.bpq == null) {
            if (this.bpn != null) {
                this.bpn.PP();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.bpq.getSourceImageRectInScreen();
        if (sourceImageRectInScreen == null) {
            if (this.bpn != null) {
                this.bpn.PP();
                return;
            }
            return;
        }
        this.bpk.bottom = (((sourceImageRectInScreen.bottom - sourceImageRectInScreen.top) / (sourceImageRectInScreen.right - sourceImageRectInScreen.left)) * (this.bpk.right - this.bpk.left)) + this.bpk.top;
        final float[] fArr = {(this.bpk.left + this.bpk.right) / 2.0f, (this.bpk.top + this.bpk.bottom) / 2.0f};
        final float[] fArr2 = {(sourceImageRectInScreen.left + sourceImageRectInScreen.right) / 2, (sourceImageRectInScreen.top + sourceImageRectInScreen.bottom) / 2};
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr[0], fArr2[0]);
        ofFloat.setDuration(150L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.coreExtra.view.f.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && sourceImageRectInScreen != null) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    float animatedFraction = fArr[1] + ((fArr2[1] - fArr[1]) * valueAnimator.getAnimatedFraction());
                    f.this.bpk = f.this.i(floatValue, animatedFraction, sourceImageRectInScreen.right - sourceImageRectInScreen.left, sourceImageRectInScreen.bottom - sourceImageRectInScreen.top);
                    f.this.invalidate();
                }
            }
        });
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tbadk.coreExtra.view.f.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                f.this.bpg = false;
                f.this.invalidate();
                if (f.this.bpn != null) {
                    f.this.bpn.PP();
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

    /* JADX INFO: Access modifiers changed from: private */
    public RectF i(float f, float f2, float f3, float f4) {
        return new RectF(f - (f3 / 2.0f), f2 - (f4 / 2.0f), (f3 / 2.0f) + f, (f4 / 2.0f) + f2);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.bpx = onTouchListener;
    }

    private void JA() {
        this.bpv = new TextView(this.mContext);
        this.bpv.setBackgroundResource(d.f.bg_url_drag_imagview_fade_view);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.height = getResources().getDimensionPixelSize(d.e.ds180);
        layoutParams.addRule(12);
        addView(this.bpv, layoutParams);
        this.bpv.setVisibility(8);
    }

    private void JB() {
        this.boV = new TextView(this.mContext);
        aj.t(this.boV, d.C0140d.common_color_10022);
        this.boV.setText(d.j.goto_pb_floor);
        this.boV.setTextSize(0, getResources().getDimensionPixelSize(d.e.fontsize24));
        aj.b(this.boV, d.C0140d.cp_cont_g, 1, 0);
        this.boV.setCompoundDrawablePadding(l.dip2px(this.mContext, 4.0f));
        this.boV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_see_arrow), (Drawable) null);
        this.boV.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds20);
        this.boV.setPadding(dimensionPixelSize * 3, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(d.e.ds30);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(d.e.ds10);
        layoutParams.leftMargin = getResources().getDimensionPixelSize(d.e.ds20);
        layoutParams.addRule(1, this.boU.getId());
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        this.boV.setOnClickListener(this);
        this.boV.setMinHeight(getResources().getDimensionPixelSize(d.e.ds100));
        addView(this.boV, layoutParams);
        this.boV.setVisibility(8);
    }

    private void JC() {
        if (this.boV != null) {
            boolean z = this.bpa || this.bpb;
            if (!this.bpt && z && this.bpq != null && this.bpq.threadId > 0 && this.bpq.postId > 0 && this.bpq.mThreadType != 33 && !this.bpq.isBlockedPic) {
                this.boV.setVisibility(0);
                if (this.bpv != null) {
                    this.bpv.setVisibility(0);
                    return;
                }
                return;
            }
            this.boV.setVisibility(8);
            if (this.bpv != null) {
                this.bpv.setVisibility(8);
            }
        }
    }

    private void JD() {
        if (this.boV != null) {
            this.boV.setVisibility(8);
            if (this.bpv != null) {
                this.bpv.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JE() {
        if ((this.bpa || this.bpb) && this.bpq != null && this.bpq.mPicType == 1 && !TextUtils.isEmpty(this.bpq.mTagName)) {
            if (this.boW != null) {
                this.boW.setVisibility(8);
                this.boW = null;
            }
            this.boW = new TextView(this.mContext);
            this.boW.setText(this.bpq.mTagName);
            this.boW.setTextSize(0, getResources().getDimensionPixelSize(d.e.fontsize26));
            aj.b(this.boW, d.C0140d.common_color_10013, 1, 0);
            aj.t(this.boW, d.C0140d.common_color_10215);
            this.boW.setAlpha(0.75f);
            this.boW.setIncludeFontPadding(false);
            this.boW.setGravity(17);
            int t = l.t(this.mContext, d.e.ds2);
            this.boW.setPadding(t, t, t, t);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.boT.getBottomOffset();
            layoutParams.leftMargin = this.boT.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.boW, layoutParams);
            this.boW.setVisibility(0);
        }
    }

    public void bU(boolean z) {
        this.bpt = z;
        if (this.bpt) {
            JD();
        } else {
            JC();
        }
    }

    public void n(String str, boolean z) {
        if (str.contains("*")) {
            str = str.split("[*]")[0];
        }
        this.boT.setTag(str);
        this.boT.setLoadBigImage(false);
        this.boT.setImageDrawable(null);
        this.bpa = false;
        this.bpb = false;
        this.bpr = JL();
        this.boU.setVisibility(8);
        if (fN(str)) {
            b(str, z, false);
        }
    }

    private boolean JF() {
        return this.boT != null && this.boT.PM();
    }

    public void JG() {
        if (this.bpq != null && !JF()) {
            String str = this.bpq.imageUrl;
            int i = this.bpq.urlType;
            com.baidu.adp.widget.a.a aVar = null;
            if (com.baidu.tbadk.core.util.d.a.v(str, i)) {
                aVar = com.baidu.tbadk.core.util.d.a.w(str, i);
            }
            if (aVar != null) {
                setThumbBitmapToView(aVar);
            }
        }
    }

    private boolean bV(boolean z) {
        String eu;
        if (!this.bps || z) {
            this.bps = true;
            if (!this.bpr || this.bpq == null || StringUtils.isNull(this.bpq.originalUrl, true) || this.bpq.originalSize < 0 || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String str = this.bpp + al.CY().en(eu) + "/" + ap.eu(this.bpq.originalUrl);
            final int[] dO = k.dO(str);
            this.boX.setVisibility(0);
            if (this.boY == null) {
                this.boY = new SubsamplingScaleImageView.OnImageEventListener() { // from class: com.baidu.tbadk.coreExtra.view.f.12
                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onReady() {
                        f.this.mProgressBar.setVisibility(8);
                        f.this.boT.PI();
                        f.this.boT.setVisibility(4);
                    }

                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onImageLoaded() {
                        if (f.this.bpq.isLongPic && dO[0] > 0) {
                            f.this.boT.onDestroy();
                            final float measuredWidth = (f.this.getMeasuredWidth() * 1.0f) / dO[0];
                            final PointF pointF = new PointF((dO[0] * 1.0f) / 2.0f, 0.0f);
                            f.this.boX.setScaleAndCenter(measuredWidth, pointF);
                            f.this.boX.setMaxScale(2.0f * measuredWidth);
                            f.this.boX.setDoubleTapZoomScale(2.0f * measuredWidth);
                            f.this.boX.setInitScale(measuredWidth);
                            f.this.boX.setDoubleTapZoomStyle(4);
                            f.this.boX.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.f.12.1
                                @Override // android.view.View.OnTouchListener
                                public boolean onTouch(View view, MotionEvent motionEvent) {
                                    if (f.this.bpx != null) {
                                        f.this.bpx.onTouch(view, motionEvent);
                                    }
                                    switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                                        case 0:
                                            f.this.bpz = motionEvent.getY();
                                            f.this.boX.setOnClickListener(f.this.bpy ? f.this.mOnClickListener : null);
                                            f.this.boX.setOnLongClickListener(f.this.bpy ? f.this.bpA : null);
                                            break;
                                        case 1:
                                        case 3:
                                            if (f.this.boX.getScale() < measuredWidth) {
                                                f.this.boX.setScaleAndCenter(measuredWidth, pointF);
                                            }
                                            com.baidu.adp.lib.g.e.ns().removeCallbacks(f.this.bpB);
                                            com.baidu.adp.lib.g.e.ns().postDelayed(f.this.bpB, 1000L);
                                            break;
                                        case 2:
                                            if (Math.abs(motionEvent.getY() - f.this.bpz) > f.TOUCH_SLOP) {
                                                f.this.bpy = false;
                                                f.this.boX.setOnClickListener(null);
                                                f.this.boX.setOnLongClickListener(null);
                                            }
                                            f.this.bpz = motionEvent.getY();
                                            break;
                                    }
                                    return false;
                                }
                            });
                            f.this.boT.setVisibility(4);
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
            this.boX.setOnImageEventListener(this.boY);
            if (this.boX.isImageLoaded() && this.bpq.isLongPic) {
                this.boY.onImageLoaded();
            } else {
                this.boX.setImage(ImageSource.uri(str));
            }
            return true;
        }
        return false;
    }

    public void setDragToExitListener(a.d dVar) {
        this.bpn = dVar;
        if (this.boT != null) {
            this.boT.setDragToExitListener(dVar);
        }
    }

    public void JH() {
        bV(false);
    }

    private boolean fN(String str) {
        return j.oJ() || com.baidu.tbadk.core.util.d.c.eL(str);
    }

    private void setThumbBitmapToView(com.baidu.adp.widget.a.a aVar) {
        Bitmap sh;
        if (!this.bpb && aVar != null && (sh = aVar.sh()) != null) {
            this.bpa = true;
            if (aVar.isGif()) {
                this.boT.setImageUrlData(this.bpq);
                this.boT.setImageBitmap(sh);
                this.boU.setVisibility(8);
                this.bpu = false;
            } else {
                if (this.bpq != null && this.bpq.isLongPic) {
                    this.boT.PA();
                    this.boT.setImageLoadCallBack(new com.baidu.tbadk.widget.a.b.a() { // from class: com.baidu.tbadk.coreExtra.view.f.13
                        @Override // com.baidu.tbadk.widget.a.b.a
                        public void JP() {
                        }
                    });
                }
                this.boT.setImageUrlData(this.bpq);
                this.boT.a(sh, aVar.sm());
            }
            JC();
            JE();
        }
    }

    private void b(String str, boolean z, boolean z2) {
        if (fO(str)) {
            if (z2 || (!this.bpc && !this.bpb)) {
                if (!z2 || !bV(true)) {
                    this.bpc = true;
                    com.baidu.adp.lib.f.c.nm().a(str, 27, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.coreExtra.view.f.14
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onCancelled(String str2) {
                            f.this.bpc = false;
                            f.this.boT.setVisibility(0);
                            f.this.mProgressBar.setVisibility(8);
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onLoaded(com.baidu.adp.widget.a.a aVar, String str2, int i) {
                            f.this.bpc = false;
                            f.this.bpb = true;
                            f.this.b(aVar);
                        }
                    }, 0, 0, false, null, Boolean.valueOf(z), this.boT.getImageData(), Boolean.valueOf(this.bmF));
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
        imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.aI(this.mMaxWidth, this.mMaxHeight));
        com.baidu.adp.widget.a.a a2 = this.bpw.a(imageFileInfo, false);
        if (a2 != null) {
            this.bpb = true;
            this.mProgressBar.setVisibility(8);
            b(a2);
            return;
        }
        this.bpw.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.coreExtra.view.f.2
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.a.a aVar, String str2, boolean z3) {
                f.this.bpb = true;
                f.this.mProgressBar.setVisibility(8);
                f.this.b(aVar);
            }
        }, false);
    }

    private boolean fO(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith("https://"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null && this.boZ != null) {
            this.boZ.k(aVar.getUrl(), aVar.sm());
        }
        if (aVar == null || aVar.sh() == null) {
            JI();
            return;
        }
        Bitmap sh = aVar.sh();
        this.boT.setLoadBigImage(true);
        if (aVar.isGif()) {
            this.boT.a(aVar.sm(), sh);
            this.boT.invalidate();
            this.boT.play();
            this.bpu = false;
            this.boU.setVisibility(8);
            this.mProgressBar.setVisibility(8);
        } else {
            if (this.bpq != null && this.bpq.isLongPic) {
                this.boT.PA();
                this.boT.setImageLoadCallBack(new com.baidu.tbadk.widget.a.b.a() { // from class: com.baidu.tbadk.coreExtra.view.f.3
                    @Override // com.baidu.tbadk.widget.a.b.a
                    public void JP() {
                        f.this.mProgressBar.setVisibility(8);
                    }
                });
            } else {
                this.mProgressBar.setVisibility(8);
            }
            this.boT.setImageUrlData(this.bpq);
            this.boT.a(sh, aVar.sm());
            JM();
        }
        JC();
        JE();
    }

    private void JI() {
        if (!this.bpa) {
            this.boT.PF();
        } else {
            this.bpb = false;
        }
        this.boU.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    public void setGifMaxUseableMem(int i) {
        this.boT.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.boT != null) {
            this.boT.onDestroy();
        }
        if (this.boX != null) {
            this.boX.recycle();
        }
        if (this.bpf != null) {
            this.bpf.recycle();
            this.bpf = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.bpB);
    }

    public void release() {
        if (this.boT != null) {
            this.boT.release();
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.boU != null) {
            this.boU.setVisibility(8);
        }
    }

    public void JJ() {
        if (this.boT != null && this.boT.getImageType() == 1) {
            this.boT.stop();
        }
    }

    public void l(boolean z, boolean z2) {
        String str;
        if (this.boT != null && (str = (String) this.boT.getTag()) != null) {
            if (this.boT.getImageType() == 1) {
                if (this.boT.getGifCache() == null || !this.boT.PM()) {
                    b(str, z, z2);
                }
            } else if (this.boT.getImageType() == 2) {
                b(str, z, z2);
            } else if (JK()) {
                b(str, z, z2);
            }
        }
    }

    private boolean JK() {
        if (this.boT.getImageBitmap() != null && this.boT.PM()) {
            if (this.bpq == null || !this.bpq.isLongPic || this.boT.PB()) {
                return false;
            }
            this.bpb = false;
            this.bps = false;
            return true;
        }
        return true;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.bpq = imageUrlData;
    }

    public void setIsCdn(boolean z) {
        this.bmF = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.boU) {
            if (!(this.boU.getTag() instanceof Boolean) || ((Boolean) this.boU.getTag()).booleanValue()) {
                final String eu = ap.eu(this.bpq.originalUrl);
                if (this.bpq.originalProcess >= 0) {
                    com.baidu.tbadk.download.e.KU().z(eu, 13);
                    this.bpq.originalProcess = -1;
                    JM();
                    return;
                }
                if (this.bmH != null) {
                    this.bmH.JQ();
                }
                com.baidu.adp.base.e<?> ak = i.ak(this.mContext);
                if (ak == null) {
                    fP(eu);
                } else if (!j.oJ() || j.oK() || com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("original_img_down_tip", false)) {
                    fP(eu);
                } else {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("original_img_down_tip", true);
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(ak.getPageActivity());
                    aVar.fb(d.j.original_img_down_no_wifi_tip);
                    aVar.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.f.4
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar.dismiss();
                            f.this.fP(eu);
                        }
                    });
                    aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.f.5
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar.dismiss();
                        }
                    });
                    aVar.b(ak);
                    aVar.AU();
                }
            }
        } else if (view == this.boV && this.bpq != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.mContext).createHistoryCfg(String.valueOf(this.bpq.threadId), String.valueOf(this.bpq.postId), this.bpq.mIsSeeHost, this.bpq.mIsReserver, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fP(String str) {
        if (this.bpq != null) {
            this.bpq.originalProcess = 0;
        }
        this.boU.setText("0%");
        this.boU.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_close_yuantu, 0);
        DownloadData downloadData = new DownloadData(str);
        downloadData.setStatus(1);
        downloadData.setUrl(this.bpq.originalUrl);
        downloadData.setType(13);
        downloadData.setPath(this.bpp + al.CY().en(str) + "/" + str);
        downloadData.setCallback(new com.baidu.tbadk.download.d() { // from class: com.baidu.tbadk.coreExtra.view.f.6
            @Override // com.baidu.tbadk.download.d
            public boolean onPreDownload(DownloadData downloadData2) {
                return true;
            }

            @Override // com.baidu.tbadk.download.d
            public void onFileUpdateProgress(DownloadData downloadData2) {
                if (downloadData2 != null) {
                    if (f.this.bpq != null && f.this.bpq.originalProcess != -1) {
                        f.this.bpq.originalProcess = downloadData2.getProcess();
                    }
                    if (f.this.bpq == null || f.this.bpq.originalProcess != -1) {
                        f.this.boU.setText(downloadData2.getProcess() + "%");
                        f.this.boU.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_close_yuantu, 0);
                    }
                }
            }

            @Override // com.baidu.tbadk.download.d
            public boolean onFileDownloaded(DownloadData downloadData2) {
                return true;
            }

            @Override // com.baidu.tbadk.download.d
            public void onFileDownloadSucceed(DownloadData downloadData2) {
                f.this.boU.setText(f.this.getResources().getString(d.j.done));
                f.this.boU.setTag(false);
                f.this.boU.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                com.baidu.adp.lib.g.e.ns().postDelayed(f.this.bpC, 1500L);
                f.this.bps = false;
                f.this.bpr = f.this.JL();
                f.this.JH();
            }

            @Override // com.baidu.tbadk.download.d
            public void onFileDownloadFailed(DownloadData downloadData2, int i, String str2) {
                f.this.bps = false;
                BdToast.a(f.this.mContext, str2).Ba().Bc();
                f.this.bpq.originalProcess = -1;
                f.this.JM();
            }
        });
        com.baidu.tbadk.download.e.KU().a(downloadData, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean JL() {
        if (this.bpq != null && !StringUtils.isNull(this.bpq.originalUrl, true) && this.bpq.originalSize >= 0 && !this.bpq.isBlockedPic) {
            String eu = ap.eu(this.bpq.originalUrl);
            File file = new File(this.bpp + al.CY().en(eu) + "/" + eu);
            if (file != null && file.exists()) {
                this.bpq.originalProcess = 100;
                return true;
            }
            if (this.bpq.originalProcess < 0) {
                JM();
            } else {
                this.boU.setText(this.bpq.originalProcess + "%");
                this.boU.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_close_yuantu, 0);
            }
            this.bpu = true;
        } else {
            this.boU.setVisibility(8);
        }
        return false;
    }

    public void JM() {
        if (this.bpq != null) {
            if (!JN() || !this.bpu) {
                this.boU.setVisibility(8);
            } else {
                this.boU.setVisibility(0);
            }
            if (this.bpq.originalSize > 0 && !Z(this.bpq.originalSize)) {
                this.boU.setText(boR + "(" + am.O(this.bpq.originalSize) + ")");
            } else {
                this.boU.setText(boR);
            }
            this.boU.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    private boolean JN() {
        return (this.bpq == null || !this.bpq.mIsShowOrigonButton || this.bpq.isBlockedPic || StringUtils.isNull(this.bpq.originalUrl)) ? false : true;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.bmH = bVar;
    }

    private boolean Z(long j) {
        return j > boS;
    }
}
