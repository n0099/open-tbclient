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
    private boolean bms;
    private b bmu;
    private boolean bmv;
    protected com.baidu.tbadk.widget.a boG;
    protected TextView boH;
    protected TextView boI;
    protected TextView boJ;
    protected SubsamplingScaleImageView boK;
    private SubsamplingScaleImageView.OnImageEventListener boL;
    private a boM;
    private boolean boN;
    private boolean boO;
    private boolean boP;
    private boolean boQ;
    private boolean boR;
    private Bitmap boS;
    private boolean boT;
    private float boU;
    private Matrix boV;
    private Rect boW;
    private RectF boX;
    private Rect boY;
    private Rect boZ;
    private a.d bpa;
    private String bpc;
    private ImageUrlData bpd;
    private boolean bpe;
    private boolean bpf;
    private boolean bpg;
    public boolean bph;
    private TextView bpi;
    private com.baidu.tbadk.img.b bpj;
    private View.OnTouchListener bpk;
    private boolean bpl;
    private float bpm;
    private View.OnLongClickListener bpn;
    private Runnable bpo;
    private Runnable bpp;
    private View.OnTouchListener bpq;
    protected Context mContext;
    private float mLastMotionX;
    private float mLastMotionY;
    private int mMaxHeight;
    private int mMaxWidth;
    private View.OnClickListener mOnClickListener;
    protected ProgressBar mProgressBar;
    private float mRatio;
    private int mSkinType;
    private static final String boE = TbadkCoreApplication.getInst().getString(d.j.original_img_look);
    private static long boF = 52428800;
    private static final int bpb = l.aq(TbadkCoreApplication.getInst()) / 5;
    private static final String TAG = f.class.getSimpleName();
    private static final int TOUCH_SLOP = ViewConfiguration.get(TbadkCoreApplication.getInst()).getScaledTouchSlop();

    /* loaded from: classes.dex */
    public interface a {
        void k(String str, byte[] bArr);
    }

    /* loaded from: classes.dex */
    public interface b {
        void JP();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.boH != null) {
                aj.s(this.boH, d.f.btn_percent_yuantu);
                aj.b(this.boH, d.C0141d.cp_cont_g, 1, 0);
            }
            if (this.boI != null) {
                aj.t(this.boI, d.C0141d.common_color_10022);
                aj.b(this.boI, d.C0141d.cp_cont_g, 1, 0);
            }
            this.mSkinType = i;
        }
    }

    public void setHeadImage(boolean z) {
        if (this.boG != null) {
            this.boG.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.boM = aVar;
    }

    public f(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mContext = null;
        this.mProgressBar = null;
        this.boG = null;
        this.boM = null;
        this.bms = false;
        this.boP = false;
        this.boT = false;
        this.mRatio = 1.0f;
        this.boU = 0.0f;
        this.boV = new Matrix();
        this.boX = new RectF();
        this.bpe = false;
        this.bpf = false;
        this.bpg = false;
        this.bph = false;
        this.bpi = null;
        this.bpl = true;
        this.bpm = 0.0f;
        this.mOnClickListener = null;
        this.bpn = null;
        this.bpo = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.f.1
            @Override // java.lang.Runnable
            public void run() {
                f.this.bpl = true;
            }
        };
        this.bpp = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.f.7
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
                        f.this.boH.setVisibility(8);
                        f.this.bph = false;
                    }
                });
                f.this.boH.startAnimation(alphaAnimation);
            }
        };
        this.bpq = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.f.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (f.this.bpk != null) {
                    f.this.bpk.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.bpj = new com.baidu.tbadk.img.b();
        init();
    }

    public com.baidu.tbadk.widget.a getImageView() {
        return this.boG;
    }

    public void setGifSetListener(a.e eVar) {
        this.boG.setGifSetListener(eVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.boG.setImageOnClickListener(onClickListener);
        this.boK.setOnClickListener(onClickListener);
        this.mOnClickListener = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bpn = onLongClickListener;
        if (!this.bmv) {
            this.boG.setImageOnLongClickListener(this.bpn);
            this.boK.setOnLongClickListener(this.bpn);
        }
    }

    public void setOnSizeChangedListener(final a.f fVar) {
        this.boG.setOnSizeChangedListener(new a.f() { // from class: com.baidu.tbadk.coreExtra.view.f.8
            @Override // com.baidu.tbadk.widget.a.f
            public void a(com.baidu.tbadk.widget.a aVar, boolean z, boolean z2) {
                if (fVar != null) {
                    fVar.a(aVar, z, z2);
                }
                f.this.JD();
            }
        });
    }

    protected void init() {
        this.mMaxWidth = l.ao(this.mContext);
        this.mMaxHeight = l.aq(this.mContext) - ((int) this.mContext.getResources().getDimension(d.e.ds166));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.boG = new com.baidu.tbadk.widget.a(this.mContext);
        this.boG.setLayoutParams(layoutParams);
        this.boG.setOnTouchListener(this.bpq);
        addView(this.boG);
        this.boK = new SubsamplingScaleImageView(this.mContext);
        this.boK.setMaxScale(50.0f);
        this.boK.setOnTouchListener(this.bpq);
        this.boK.setVisibility(4);
        addView(this.boK, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(getResources().getDrawable(d.f.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        Jz();
        Jx();
        JA();
    }

    private void Jx() {
        this.bpc = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        this.boH = new TextView(this.mContext);
        aj.s(this.boH, d.f.btn_percent_yuantu);
        this.boH.setText(d.j.original_img_look);
        this.boH.setTextSize(0, getResources().getDimensionPixelSize(d.e.fontsize28));
        aj.b(this.boH, d.C0141d.cp_cont_g, 1, 0);
        this.boH.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds20);
        this.boH.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        this.boH.setMinWidth(getResources().getDimensionPixelSize(d.e.ds220));
        this.boH.setMinHeight(getResources().getDimensionPixelSize(d.e.ds68));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(d.e.fontsize40);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        this.boH.setOnClickListener(this);
        this.boH.setVisibility(8);
        addView(this.boH, layoutParams);
    }

    public void setIsCanDrag(boolean z) {
        this.bmv = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        Bitmap imageBitmap;
        int height;
        int width;
        if (!this.bmv || !this.boO) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.boQ && motionEvent.getPointerCount() >= 2) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.boQ || this.boR) {
            requestDisallowInterceptTouchEvent(true);
        }
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        float x = motionEvent.getX();
        int i = action & 255;
        if (i == 0) {
            if (this.boS == null) {
                if (this.boK.getVisibility() == 0) {
                    this.boS = com.baidu.tbadk.util.d.bm(this.boK);
                } else {
                    this.boS = com.baidu.tbadk.util.d.bm(this.boG);
                }
            }
            if (this.boW == null && this.boS != null) {
                int measuredWidth = getMeasuredWidth();
                float measuredWidth2 = ((getMeasuredWidth() * 1.0f) / this.boS.getWidth()) * this.boS.getHeight();
                if (measuredWidth2 > getMeasuredHeight()) {
                    measuredWidth2 = getMeasuredHeight();
                }
                RectF i2 = i(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
                this.boW = new Rect((int) i2.left, (int) i2.top, (int) i2.right, (int) i2.bottom);
            }
            if (this.boZ == null && this.boS != null) {
                if (this.boK.getVisibility() == 0) {
                    height = this.boK.getSHeight();
                    width = this.boK.getSWidth();
                } else {
                    if (this.boG.getImageType() == 1) {
                        imageBitmap = (this.boG.getCurrentFrame() == null || this.boG.getCurrentFrame().bEq == null) ? this.boS : this.boG.getCurrentFrame().bEq;
                    } else {
                        imageBitmap = this.boG.getImageBitmap() == null ? this.boS : this.boG.getImageBitmap();
                    }
                    height = imageBitmap.getHeight();
                    width = imageBitmap.getWidth();
                }
                float ar = l.ar(getContext());
                int i3 = (int) (height * ar);
                int i4 = (int) (width * ar);
                if (i4 > this.boS.getWidth() && this.boS.getWidth() != 0) {
                    float width2 = (i4 * 1.0f) / this.boS.getWidth();
                    i4 = this.boS.getWidth();
                    i3 = (int) (i3 / width2);
                }
                if (i3 > this.boS.getHeight() && this.boS.getHeight() != 0) {
                    i4 = (int) (i4 / ((i3 * 1.0f) / this.boS.getHeight()));
                    i3 = this.boS.getHeight();
                }
                int aq = (l.aq(getContext()) - i3) / 2;
                int ao = (l.ao(getContext()) - i4) / 2;
                this.boZ = new Rect(ao, aq, i4 + ao, i3 + aq);
                this.boY = new Rect(0, 0, this.boS.getWidth(), this.boS.getHeight());
            }
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (i == 2) {
            this.boQ = l(this.mLastMotionX - x, this.mLastMotionY - y);
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (this.boQ || this.boR) {
            this.boG.setImageOnLongClickListener(null);
            this.boK.setOnLongClickListener(null);
            z = true;
        } else {
            this.boG.setImageOnLongClickListener(this.bpn);
            this.boK.setOnLongClickListener(this.bpn);
            z = super.dispatchTouchEvent(motionEvent);
        }
        if (i == 1 || i == 3) {
            this.mLastMotionX = 0.0f;
            this.mLastMotionY = 0.0f;
            this.boT = false;
            this.boV.reset();
            this.boQ = false;
            if (this.boU > bpb) {
                this.boR = true;
                Jy();
                return z;
            }
            this.mRatio = 1.0f;
            invalidate();
            return z;
        }
        return z;
    }

    private boolean l(float f, float f2) {
        if (this.boK.getVisibility() != 0 || this.boK.isCanDrag()) {
            if (this.bpd == null || !this.bpd.isLongPic || this.boK.getVisibility() != 0 || this.boK.isViewTop()) {
                if (this.bpd == null || !this.bpd.isLongPic || this.boK.getVisibility() == 0 || this.boG.Pu()) {
                    if (this.boK.getVisibility() == 0 || this.boG.Pw()) {
                        if (this.boS != null && getScrollY() == 0 && f2 < 0.0f && !this.boT) {
                            this.boT = true;
                            this.boU = 0.0f;
                            this.mRatio = 1.0f;
                            if (this.bpa != null) {
                                this.bpa.PN();
                            }
                        }
                        if (this.boT) {
                            this.boU -= f2;
                            int measuredHeight = getMeasuredHeight();
                            if (this.boU > measuredHeight) {
                                this.boU = measuredHeight;
                            }
                            float f3 = f2 / measuredHeight;
                            this.boV.postTranslate((-f) * 1.5f * this.mRatio, (-1.5f) * f2 * this.mRatio);
                            if (this.mRatio * (1.0f + f3) > 1.0f || this.boU < 0.0f) {
                                this.boV.preScale(1.0f / this.mRatio, 1.0f / this.mRatio, (this.mRatio * this.boS.getWidth()) / 2.0f, this.mRatio * (this.boS.getHeight() / 2));
                                this.mRatio = 1.0f;
                            } else {
                                this.boV.preScale(1.0f + f3, 1.0f + f3, (this.mRatio * this.boS.getWidth()) / 2.0f, this.mRatio * (this.boS.getHeight() / 2));
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
        if (this.boQ && this.boS != null && !this.boS.isRecycled() && this.boT) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.boX == null) {
                this.boX = new RectF();
            }
            this.boV.mapRect(this.boX, new RectF(this.boW));
            canvas.drawBitmap(this.boS, this.boY, this.boX, (Paint) null);
        } else if (this.boR && this.boS != null && !this.boS.isRecycled()) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.bpd == null || this.bpd.getSourceImageRectInScreen() == null) {
                canvas.drawBitmap(this.boS, this.boY, this.boX, (Paint) null);
            } else {
                canvas.drawBitmap(this.boS, this.boZ, this.boX, (Paint) null);
            }
        } else {
            super.dispatchDraw(canvas);
        }
    }

    private void Jy() {
        if (this.bpd == null) {
            if (this.bpa != null) {
                this.bpa.PO();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.bpd.getSourceImageRectInScreen();
        if (sourceImageRectInScreen == null) {
            if (this.bpa != null) {
                this.bpa.PO();
                return;
            }
            return;
        }
        this.boX.bottom = (((sourceImageRectInScreen.bottom - sourceImageRectInScreen.top) / (sourceImageRectInScreen.right - sourceImageRectInScreen.left)) * (this.boX.right - this.boX.left)) + this.boX.top;
        final float[] fArr = {(this.boX.left + this.boX.right) / 2.0f, (this.boX.top + this.boX.bottom) / 2.0f};
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
                    f.this.boX = f.this.i(floatValue, animatedFraction, sourceImageRectInScreen.right - sourceImageRectInScreen.left, sourceImageRectInScreen.bottom - sourceImageRectInScreen.top);
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
                f.this.boT = false;
                f.this.invalidate();
                if (f.this.bpa != null) {
                    f.this.bpa.PO();
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
        this.bpk = onTouchListener;
    }

    private void Jz() {
        this.bpi = new TextView(this.mContext);
        this.bpi.setBackgroundResource(d.f.bg_url_drag_imagview_fade_view);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.height = getResources().getDimensionPixelSize(d.e.ds180);
        layoutParams.addRule(12);
        addView(this.bpi, layoutParams);
        this.bpi.setVisibility(8);
    }

    private void JA() {
        this.boI = new TextView(this.mContext);
        aj.t(this.boI, d.C0141d.common_color_10022);
        this.boI.setText(d.j.goto_pb_floor);
        this.boI.setTextSize(0, getResources().getDimensionPixelSize(d.e.fontsize24));
        aj.b(this.boI, d.C0141d.cp_cont_g, 1, 0);
        this.boI.setCompoundDrawablePadding(l.dip2px(this.mContext, 4.0f));
        this.boI.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_see_arrow), (Drawable) null);
        this.boI.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds20);
        this.boI.setPadding(dimensionPixelSize * 3, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(d.e.ds30);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(d.e.ds10);
        layoutParams.leftMargin = getResources().getDimensionPixelSize(d.e.ds20);
        layoutParams.addRule(1, this.boH.getId());
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        this.boI.setOnClickListener(this);
        this.boI.setMinHeight(getResources().getDimensionPixelSize(d.e.ds100));
        addView(this.boI, layoutParams);
        this.boI.setVisibility(8);
    }

    private void JB() {
        if (this.boI != null) {
            boolean z = this.boN || this.boO;
            if (!this.bpg && z && this.bpd != null && this.bpd.threadId > 0 && this.bpd.postId > 0 && this.bpd.mThreadType != 33 && !this.bpd.isBlockedPic) {
                this.boI.setVisibility(0);
                if (this.bpi != null) {
                    this.bpi.setVisibility(0);
                    return;
                }
                return;
            }
            this.boI.setVisibility(8);
            if (this.bpi != null) {
                this.bpi.setVisibility(8);
            }
        }
    }

    private void JC() {
        if (this.boI != null) {
            this.boI.setVisibility(8);
            if (this.bpi != null) {
                this.bpi.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JD() {
        if ((this.boN || this.boO) && this.bpd != null && this.bpd.mPicType == 1 && !TextUtils.isEmpty(this.bpd.mTagName)) {
            if (this.boJ != null) {
                this.boJ.setVisibility(8);
                this.boJ = null;
            }
            this.boJ = new TextView(this.mContext);
            this.boJ.setText(this.bpd.mTagName);
            this.boJ.setTextSize(0, getResources().getDimensionPixelSize(d.e.fontsize26));
            aj.b(this.boJ, d.C0141d.common_color_10013, 1, 0);
            aj.t(this.boJ, d.C0141d.common_color_10215);
            this.boJ.setAlpha(0.75f);
            this.boJ.setIncludeFontPadding(false);
            this.boJ.setGravity(17);
            int t = l.t(this.mContext, d.e.ds2);
            this.boJ.setPadding(t, t, t, t);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.boG.getBottomOffset();
            layoutParams.leftMargin = this.boG.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.boJ, layoutParams);
            this.boJ.setVisibility(0);
        }
    }

    public void bU(boolean z) {
        this.bpg = z;
        if (this.bpg) {
            JC();
        } else {
            JB();
        }
    }

    public void m(String str, boolean z) {
        if (str.contains("*")) {
            str = str.split("[*]")[0];
        }
        this.boG.setTag(str);
        this.boG.setLoadBigImage(false);
        this.boG.setImageDrawable(null);
        this.boN = false;
        this.boO = false;
        this.bpe = JK();
        this.boH.setVisibility(8);
        if (fN(str)) {
            b(str, z, false);
        }
    }

    private boolean JE() {
        return this.boG != null && this.boG.PL();
    }

    public void JF() {
        if (this.bpd != null && !JE()) {
            String str = this.bpd.imageUrl;
            int i = this.bpd.urlType;
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
        if (!this.bpf || z) {
            this.bpf = true;
            if (!this.bpe || this.bpd == null || StringUtils.isNull(this.bpd.originalUrl, true) || this.bpd.originalSize < 0 || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String str = this.bpc + al.CX().en(eu) + "/" + ap.eu(this.bpd.originalUrl);
            final int[] dO = k.dO(str);
            this.boK.setVisibility(0);
            if (this.boL == null) {
                this.boL = new SubsamplingScaleImageView.OnImageEventListener() { // from class: com.baidu.tbadk.coreExtra.view.f.12
                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onReady() {
                        f.this.mProgressBar.setVisibility(8);
                        f.this.boG.PH();
                        f.this.boG.setVisibility(4);
                    }

                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onImageLoaded() {
                        if (f.this.bpd.isLongPic && dO[0] > 0) {
                            f.this.boG.onDestroy();
                            final float measuredWidth = (f.this.getMeasuredWidth() * 1.0f) / dO[0];
                            final PointF pointF = new PointF((dO[0] * 1.0f) / 2.0f, 0.0f);
                            f.this.boK.setScaleAndCenter(measuredWidth, pointF);
                            f.this.boK.setMaxScale(2.0f * measuredWidth);
                            f.this.boK.setDoubleTapZoomScale(2.0f * measuredWidth);
                            f.this.boK.setInitScale(measuredWidth);
                            f.this.boK.setDoubleTapZoomStyle(4);
                            f.this.boK.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.f.12.1
                                @Override // android.view.View.OnTouchListener
                                public boolean onTouch(View view, MotionEvent motionEvent) {
                                    if (f.this.bpk != null) {
                                        f.this.bpk.onTouch(view, motionEvent);
                                    }
                                    switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                                        case 0:
                                            f.this.bpm = motionEvent.getY();
                                            f.this.boK.setOnClickListener(f.this.bpl ? f.this.mOnClickListener : null);
                                            f.this.boK.setOnLongClickListener(f.this.bpl ? f.this.bpn : null);
                                            break;
                                        case 1:
                                        case 3:
                                            if (f.this.boK.getScale() < measuredWidth) {
                                                f.this.boK.setScaleAndCenter(measuredWidth, pointF);
                                            }
                                            com.baidu.adp.lib.g.e.ns().removeCallbacks(f.this.bpo);
                                            com.baidu.adp.lib.g.e.ns().postDelayed(f.this.bpo, 1000L);
                                            break;
                                        case 2:
                                            if (Math.abs(motionEvent.getY() - f.this.bpm) > f.TOUCH_SLOP) {
                                                f.this.bpl = false;
                                                f.this.boK.setOnClickListener(null);
                                                f.this.boK.setOnLongClickListener(null);
                                            }
                                            f.this.bpm = motionEvent.getY();
                                            break;
                                    }
                                    return false;
                                }
                            });
                            f.this.boG.setVisibility(4);
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
            this.boK.setOnImageEventListener(this.boL);
            if (this.boK.isImageLoaded() && this.bpd.isLongPic) {
                this.boL.onImageLoaded();
            } else {
                this.boK.setImage(ImageSource.uri(str));
            }
            return true;
        }
        return false;
    }

    public void setDragToExitListener(a.d dVar) {
        this.bpa = dVar;
        if (this.boG != null) {
            this.boG.setDragToExitListener(dVar);
        }
    }

    public void JG() {
        bV(false);
    }

    private boolean fN(String str) {
        return j.oJ() || com.baidu.tbadk.core.util.d.c.eL(str);
    }

    private void setThumbBitmapToView(com.baidu.adp.widget.a.a aVar) {
        Bitmap sh;
        if (!this.boO && aVar != null && (sh = aVar.sh()) != null) {
            this.boN = true;
            if (aVar.isGif()) {
                this.boG.setImageUrlData(this.bpd);
                this.boG.setImageBitmap(sh);
                this.boH.setVisibility(8);
                this.bph = false;
            } else {
                if (this.bpd != null && this.bpd.isLongPic) {
                    this.boG.Pz();
                    this.boG.setImageLoadCallBack(new com.baidu.tbadk.widget.a.b.a() { // from class: com.baidu.tbadk.coreExtra.view.f.13
                        @Override // com.baidu.tbadk.widget.a.b.a
                        public void JO() {
                        }
                    });
                }
                this.boG.setImageUrlData(this.bpd);
                this.boG.a(sh, aVar.sm());
            }
            JB();
            JD();
        }
    }

    private void b(String str, boolean z, boolean z2) {
        if (fO(str)) {
            if (z2 || (!this.boP && !this.boO)) {
                if (!z2 || !bV(true)) {
                    this.boP = true;
                    com.baidu.adp.lib.f.c.nm().a(str, 27, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.coreExtra.view.f.14
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onCancelled(String str2) {
                            f.this.boP = false;
                            f.this.boG.setVisibility(0);
                            f.this.mProgressBar.setVisibility(8);
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onLoaded(com.baidu.adp.widget.a.a aVar, String str2, int i) {
                            f.this.boP = false;
                            f.this.boO = true;
                            f.this.b(aVar);
                        }
                    }, 0, 0, false, null, Boolean.valueOf(z), this.boG.getImageData(), Boolean.valueOf(this.bms));
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
        com.baidu.adp.widget.a.a a2 = this.bpj.a(imageFileInfo, false);
        if (a2 != null) {
            this.boO = true;
            this.mProgressBar.setVisibility(8);
            b(a2);
            return;
        }
        this.bpj.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.coreExtra.view.f.2
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.a.a aVar, String str2, boolean z3) {
                f.this.boO = true;
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
        if (aVar != null && this.boM != null) {
            this.boM.k(aVar.getUrl(), aVar.sm());
        }
        if (aVar == null || aVar.sh() == null) {
            JH();
            return;
        }
        Bitmap sh = aVar.sh();
        this.boG.setLoadBigImage(true);
        if (aVar.isGif()) {
            this.boG.a(aVar.sm(), sh);
            this.boG.invalidate();
            this.boG.play();
            this.bph = false;
            this.boH.setVisibility(8);
            this.mProgressBar.setVisibility(8);
        } else {
            if (this.bpd != null && this.bpd.isLongPic) {
                this.boG.Pz();
                this.boG.setImageLoadCallBack(new com.baidu.tbadk.widget.a.b.a() { // from class: com.baidu.tbadk.coreExtra.view.f.3
                    @Override // com.baidu.tbadk.widget.a.b.a
                    public void JO() {
                        f.this.mProgressBar.setVisibility(8);
                    }
                });
            } else {
                this.mProgressBar.setVisibility(8);
            }
            this.boG.setImageUrlData(this.bpd);
            this.boG.a(sh, aVar.sm());
            JL();
        }
        JB();
        JD();
    }

    private void JH() {
        if (!this.boN) {
            this.boG.PE();
        } else {
            this.boO = false;
        }
        this.boH.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    public void setGifMaxUseableMem(int i) {
        this.boG.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.boG != null) {
            this.boG.onDestroy();
        }
        if (this.boK != null) {
            this.boK.recycle();
        }
        if (this.boS != null) {
            this.boS.recycle();
            this.boS = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.bpo);
    }

    public void release() {
        if (this.boG != null) {
            this.boG.release();
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.boH != null) {
            this.boH.setVisibility(8);
        }
    }

    public void JI() {
        if (this.boG != null && this.boG.getImageType() == 1) {
            this.boG.stop();
        }
    }

    public void l(boolean z, boolean z2) {
        String str;
        if (this.boG != null && (str = (String) this.boG.getTag()) != null) {
            if (this.boG.getImageType() == 1) {
                if (this.boG.getGifCache() == null || !this.boG.PL()) {
                    b(str, z, z2);
                }
            } else if (this.boG.getImageType() == 2) {
                b(str, z, z2);
            } else if (JJ()) {
                b(str, z, z2);
            }
        }
    }

    private boolean JJ() {
        if (this.boG.getImageBitmap() != null && this.boG.PL()) {
            if (this.bpd == null || !this.bpd.isLongPic || this.boG.PA()) {
                return false;
            }
            this.boO = false;
            this.bpf = false;
            return true;
        }
        return true;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.bpd = imageUrlData;
    }

    public void setIsCdn(boolean z) {
        this.bms = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.boH) {
            if (!(this.boH.getTag() instanceof Boolean) || ((Boolean) this.boH.getTag()).booleanValue()) {
                final String eu = ap.eu(this.bpd.originalUrl);
                if (this.bpd.originalProcess >= 0) {
                    com.baidu.tbadk.download.e.KT().z(eu, 13);
                    this.bpd.originalProcess = -1;
                    JL();
                    return;
                }
                if (this.bmu != null) {
                    this.bmu.JP();
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
        } else if (view == this.boI && this.bpd != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.mContext).createHistoryCfg(String.valueOf(this.bpd.threadId), String.valueOf(this.bpd.postId), this.bpd.mIsSeeHost, this.bpd.mIsReserver, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fP(String str) {
        if (this.bpd != null) {
            this.bpd.originalProcess = 0;
        }
        this.boH.setText("0%");
        this.boH.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_close_yuantu, 0);
        DownloadData downloadData = new DownloadData(str);
        downloadData.setStatus(1);
        downloadData.setUrl(this.bpd.originalUrl);
        downloadData.setType(13);
        downloadData.setPath(this.bpc + al.CX().en(str) + "/" + str);
        downloadData.setCallback(new com.baidu.tbadk.download.d() { // from class: com.baidu.tbadk.coreExtra.view.f.6
            @Override // com.baidu.tbadk.download.d
            public boolean onPreDownload(DownloadData downloadData2) {
                return true;
            }

            @Override // com.baidu.tbadk.download.d
            public void onFileUpdateProgress(DownloadData downloadData2) {
                if (downloadData2 != null) {
                    if (f.this.bpd != null && f.this.bpd.originalProcess != -1) {
                        f.this.bpd.originalProcess = downloadData2.getProcess();
                    }
                    if (f.this.bpd == null || f.this.bpd.originalProcess != -1) {
                        f.this.boH.setText(downloadData2.getProcess() + "%");
                        f.this.boH.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_close_yuantu, 0);
                    }
                }
            }

            @Override // com.baidu.tbadk.download.d
            public boolean onFileDownloaded(DownloadData downloadData2) {
                return true;
            }

            @Override // com.baidu.tbadk.download.d
            public void onFileDownloadSucceed(DownloadData downloadData2) {
                f.this.boH.setText(f.this.getResources().getString(d.j.done));
                f.this.boH.setTag(false);
                f.this.boH.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                com.baidu.adp.lib.g.e.ns().postDelayed(f.this.bpp, 1500L);
                f.this.bpf = false;
                f.this.bpe = f.this.JK();
                f.this.JG();
            }

            @Override // com.baidu.tbadk.download.d
            public void onFileDownloadFailed(DownloadData downloadData2, int i, String str2) {
                f.this.bpf = false;
                BdToast.a(f.this.mContext, str2).Ba().Bc();
                f.this.bpd.originalProcess = -1;
                f.this.JL();
            }
        });
        com.baidu.tbadk.download.e.KT().a(downloadData, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean JK() {
        if (this.bpd != null && !StringUtils.isNull(this.bpd.originalUrl, true) && this.bpd.originalSize >= 0 && !this.bpd.isBlockedPic) {
            String eu = ap.eu(this.bpd.originalUrl);
            File file = new File(this.bpc + al.CX().en(eu) + "/" + eu);
            if (file != null && file.exists()) {
                this.bpd.originalProcess = 100;
                return true;
            }
            if (this.bpd.originalProcess < 0) {
                JL();
            } else {
                this.boH.setText(this.bpd.originalProcess + "%");
                this.boH.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_close_yuantu, 0);
            }
            this.bph = true;
        } else {
            this.boH.setVisibility(8);
        }
        return false;
    }

    public void JL() {
        if (this.bpd != null) {
            if (!JM() || !this.bph) {
                this.boH.setVisibility(8);
            } else {
                this.boH.setVisibility(0);
            }
            if (this.bpd.originalSize > 0 && !Z(this.bpd.originalSize)) {
                this.boH.setText(boE + "(" + am.O(this.bpd.originalSize) + ")");
            } else {
                this.boH.setText(boE);
            }
            this.boH.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    private boolean JM() {
        return (this.bpd == null || !this.bpd.mIsShowOrigonButton || this.bpd.isBlockedPic || StringUtils.isNull(this.bpd.originalUrl)) ? false : true;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.bmu = bVar;
    }

    private boolean Z(long j) {
        return j > boF;
    }
}
