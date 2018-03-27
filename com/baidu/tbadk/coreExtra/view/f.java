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
    private boolean bmv;
    private b bmx;
    private boolean bmy;
    protected com.baidu.tbadk.widget.a boJ;
    protected TextView boK;
    protected TextView boL;
    protected TextView boM;
    protected SubsamplingScaleImageView boN;
    private SubsamplingScaleImageView.OnImageEventListener boO;
    private a boP;
    private boolean boQ;
    private boolean boR;
    private boolean boS;
    private boolean boT;
    private boolean boU;
    private Bitmap boV;
    private boolean boW;
    private float boX;
    private Matrix boY;
    private Rect boZ;
    private RectF bpa;
    private Rect bpb;
    private Rect bpc;
    private a.d bpd;
    private String bpf;
    private ImageUrlData bpg;
    private boolean bph;
    private boolean bpi;
    private boolean bpj;
    public boolean bpk;
    private TextView bpl;
    private com.baidu.tbadk.img.b bpm;
    private View.OnTouchListener bpn;
    private boolean bpo;
    private float bpp;
    private View.OnLongClickListener bpq;
    private Runnable bpr;
    private Runnable bps;
    private View.OnTouchListener bpt;
    protected Context mContext;
    private float mLastMotionX;
    private float mLastMotionY;
    private int mMaxHeight;
    private int mMaxWidth;
    private View.OnClickListener mOnClickListener;
    protected ProgressBar mProgressBar;
    private float mRatio;
    private int mSkinType;
    private static final String boH = TbadkCoreApplication.getInst().getString(d.j.original_img_look);
    private static long boI = 52428800;
    private static final int bpe = l.aq(TbadkCoreApplication.getInst()) / 5;
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
            if (this.boK != null) {
                aj.s(this.boK, d.f.btn_percent_yuantu);
                aj.b(this.boK, d.C0141d.cp_cont_g, 1, 0);
            }
            if (this.boL != null) {
                aj.t(this.boL, d.C0141d.common_color_10022);
                aj.b(this.boL, d.C0141d.cp_cont_g, 1, 0);
            }
            this.mSkinType = i;
        }
    }

    public void setHeadImage(boolean z) {
        if (this.boJ != null) {
            this.boJ.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.boP = aVar;
    }

    public f(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mContext = null;
        this.mProgressBar = null;
        this.boJ = null;
        this.boP = null;
        this.bmv = false;
        this.boS = false;
        this.boW = false;
        this.mRatio = 1.0f;
        this.boX = 0.0f;
        this.boY = new Matrix();
        this.bpa = new RectF();
        this.bph = false;
        this.bpi = false;
        this.bpj = false;
        this.bpk = false;
        this.bpl = null;
        this.bpo = true;
        this.bpp = 0.0f;
        this.mOnClickListener = null;
        this.bpq = null;
        this.bpr = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.f.1
            @Override // java.lang.Runnable
            public void run() {
                f.this.bpo = true;
            }
        };
        this.bps = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.f.7
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
                        f.this.boK.setVisibility(8);
                        f.this.bpk = false;
                    }
                });
                f.this.boK.startAnimation(alphaAnimation);
            }
        };
        this.bpt = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.f.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (f.this.bpn != null) {
                    f.this.bpn.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.bpm = new com.baidu.tbadk.img.b();
        init();
    }

    public com.baidu.tbadk.widget.a getImageView() {
        return this.boJ;
    }

    public void setGifSetListener(a.e eVar) {
        this.boJ.setGifSetListener(eVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.boJ.setImageOnClickListener(onClickListener);
        this.boN.setOnClickListener(onClickListener);
        this.mOnClickListener = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bpq = onLongClickListener;
        if (!this.bmy) {
            this.boJ.setImageOnLongClickListener(this.bpq);
            this.boN.setOnLongClickListener(this.bpq);
        }
    }

    public void setOnSizeChangedListener(final a.f fVar) {
        this.boJ.setOnSizeChangedListener(new a.f() { // from class: com.baidu.tbadk.coreExtra.view.f.8
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
        this.boJ = new com.baidu.tbadk.widget.a(this.mContext);
        this.boJ.setLayoutParams(layoutParams);
        this.boJ.setOnTouchListener(this.bpt);
        addView(this.boJ);
        this.boN = new SubsamplingScaleImageView(this.mContext);
        this.boN.setMaxScale(50.0f);
        this.boN.setOnTouchListener(this.bpt);
        this.boN.setVisibility(4);
        addView(this.boN, layoutParams);
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
        this.bpf = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        this.boK = new TextView(this.mContext);
        aj.s(this.boK, d.f.btn_percent_yuantu);
        this.boK.setText(d.j.original_img_look);
        this.boK.setTextSize(0, getResources().getDimensionPixelSize(d.e.fontsize28));
        aj.b(this.boK, d.C0141d.cp_cont_g, 1, 0);
        this.boK.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds20);
        this.boK.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        this.boK.setMinWidth(getResources().getDimensionPixelSize(d.e.ds220));
        this.boK.setMinHeight(getResources().getDimensionPixelSize(d.e.ds68));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(d.e.fontsize40);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        this.boK.setOnClickListener(this);
        this.boK.setVisibility(8);
        addView(this.boK, layoutParams);
    }

    public void setIsCanDrag(boolean z) {
        this.bmy = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        Bitmap imageBitmap;
        int height;
        int width;
        if (!this.bmy || !this.boR) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.boT && motionEvent.getPointerCount() >= 2) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.boT || this.boU) {
            requestDisallowInterceptTouchEvent(true);
        }
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        float x = motionEvent.getX();
        int i = action & 255;
        if (i == 0) {
            if (this.boV == null) {
                if (this.boN.getVisibility() == 0) {
                    this.boV = com.baidu.tbadk.util.d.bm(this.boN);
                } else {
                    this.boV = com.baidu.tbadk.util.d.bm(this.boJ);
                }
            }
            if (this.boZ == null && this.boV != null) {
                int measuredWidth = getMeasuredWidth();
                float measuredWidth2 = ((getMeasuredWidth() * 1.0f) / this.boV.getWidth()) * this.boV.getHeight();
                if (measuredWidth2 > getMeasuredHeight()) {
                    measuredWidth2 = getMeasuredHeight();
                }
                RectF i2 = i(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
                this.boZ = new Rect((int) i2.left, (int) i2.top, (int) i2.right, (int) i2.bottom);
            }
            if (this.bpc == null && this.boV != null) {
                if (this.boN.getVisibility() == 0) {
                    height = this.boN.getSHeight();
                    width = this.boN.getSWidth();
                } else {
                    if (this.boJ.getImageType() == 1) {
                        imageBitmap = (this.boJ.getCurrentFrame() == null || this.boJ.getCurrentFrame().bEt == null) ? this.boV : this.boJ.getCurrentFrame().bEt;
                    } else {
                        imageBitmap = this.boJ.getImageBitmap() == null ? this.boV : this.boJ.getImageBitmap();
                    }
                    height = imageBitmap.getHeight();
                    width = imageBitmap.getWidth();
                }
                float ar = l.ar(getContext());
                int i3 = (int) (height * ar);
                int i4 = (int) (width * ar);
                if (i4 > this.boV.getWidth() && this.boV.getWidth() != 0) {
                    float width2 = (i4 * 1.0f) / this.boV.getWidth();
                    i4 = this.boV.getWidth();
                    i3 = (int) (i3 / width2);
                }
                if (i3 > this.boV.getHeight() && this.boV.getHeight() != 0) {
                    i4 = (int) (i4 / ((i3 * 1.0f) / this.boV.getHeight()));
                    i3 = this.boV.getHeight();
                }
                int aq = (l.aq(getContext()) - i3) / 2;
                int ao = (l.ao(getContext()) - i4) / 2;
                this.bpc = new Rect(ao, aq, i4 + ao, i3 + aq);
                this.bpb = new Rect(0, 0, this.boV.getWidth(), this.boV.getHeight());
            }
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (i == 2) {
            this.boT = l(this.mLastMotionX - x, this.mLastMotionY - y);
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (this.boT || this.boU) {
            this.boJ.setImageOnLongClickListener(null);
            this.boN.setOnLongClickListener(null);
            z = true;
        } else {
            this.boJ.setImageOnLongClickListener(this.bpq);
            this.boN.setOnLongClickListener(this.bpq);
            z = super.dispatchTouchEvent(motionEvent);
        }
        if (i == 1 || i == 3) {
            this.mLastMotionX = 0.0f;
            this.mLastMotionY = 0.0f;
            this.boW = false;
            this.boY.reset();
            this.boT = false;
            if (this.boX > bpe) {
                this.boU = true;
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
        if (this.boN.getVisibility() != 0 || this.boN.isCanDrag()) {
            if (this.bpg == null || !this.bpg.isLongPic || this.boN.getVisibility() != 0 || this.boN.isViewTop()) {
                if (this.bpg == null || !this.bpg.isLongPic || this.boN.getVisibility() == 0 || this.boJ.Pv()) {
                    if (this.boN.getVisibility() == 0 || this.boJ.Px()) {
                        if (this.boV != null && getScrollY() == 0 && f2 < 0.0f && !this.boW) {
                            this.boW = true;
                            this.boX = 0.0f;
                            this.mRatio = 1.0f;
                            if (this.bpd != null) {
                                this.bpd.PO();
                            }
                        }
                        if (this.boW) {
                            this.boX -= f2;
                            int measuredHeight = getMeasuredHeight();
                            if (this.boX > measuredHeight) {
                                this.boX = measuredHeight;
                            }
                            float f3 = f2 / measuredHeight;
                            this.boY.postTranslate((-f) * 1.5f * this.mRatio, (-1.5f) * f2 * this.mRatio);
                            if (this.mRatio * (1.0f + f3) > 1.0f || this.boX < 0.0f) {
                                this.boY.preScale(1.0f / this.mRatio, 1.0f / this.mRatio, (this.mRatio * this.boV.getWidth()) / 2.0f, this.mRatio * (this.boV.getHeight() / 2));
                                this.mRatio = 1.0f;
                            } else {
                                this.boY.preScale(1.0f + f3, 1.0f + f3, (this.mRatio * this.boV.getWidth()) / 2.0f, this.mRatio * (this.boV.getHeight() / 2));
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
        if (this.boT && this.boV != null && !this.boV.isRecycled() && this.boW) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.bpa == null) {
                this.bpa = new RectF();
            }
            this.boY.mapRect(this.bpa, new RectF(this.boZ));
            canvas.drawBitmap(this.boV, this.bpb, this.bpa, (Paint) null);
        } else if (this.boU && this.boV != null && !this.boV.isRecycled()) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.bpg == null || this.bpg.getSourceImageRectInScreen() == null) {
                canvas.drawBitmap(this.boV, this.bpb, this.bpa, (Paint) null);
            } else {
                canvas.drawBitmap(this.boV, this.bpc, this.bpa, (Paint) null);
            }
        } else {
            super.dispatchDraw(canvas);
        }
    }

    private void Jz() {
        if (this.bpg == null) {
            if (this.bpd != null) {
                this.bpd.PP();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.bpg.getSourceImageRectInScreen();
        if (sourceImageRectInScreen == null) {
            if (this.bpd != null) {
                this.bpd.PP();
                return;
            }
            return;
        }
        this.bpa.bottom = (((sourceImageRectInScreen.bottom - sourceImageRectInScreen.top) / (sourceImageRectInScreen.right - sourceImageRectInScreen.left)) * (this.bpa.right - this.bpa.left)) + this.bpa.top;
        final float[] fArr = {(this.bpa.left + this.bpa.right) / 2.0f, (this.bpa.top + this.bpa.bottom) / 2.0f};
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
                    f.this.bpa = f.this.i(floatValue, animatedFraction, sourceImageRectInScreen.right - sourceImageRectInScreen.left, sourceImageRectInScreen.bottom - sourceImageRectInScreen.top);
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
                f.this.boW = false;
                f.this.invalidate();
                if (f.this.bpd != null) {
                    f.this.bpd.PP();
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
        this.bpn = onTouchListener;
    }

    private void JA() {
        this.bpl = new TextView(this.mContext);
        this.bpl.setBackgroundResource(d.f.bg_url_drag_imagview_fade_view);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.height = getResources().getDimensionPixelSize(d.e.ds180);
        layoutParams.addRule(12);
        addView(this.bpl, layoutParams);
        this.bpl.setVisibility(8);
    }

    private void JB() {
        this.boL = new TextView(this.mContext);
        aj.t(this.boL, d.C0141d.common_color_10022);
        this.boL.setText(d.j.goto_pb_floor);
        this.boL.setTextSize(0, getResources().getDimensionPixelSize(d.e.fontsize24));
        aj.b(this.boL, d.C0141d.cp_cont_g, 1, 0);
        this.boL.setCompoundDrawablePadding(l.dip2px(this.mContext, 4.0f));
        this.boL.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_see_arrow), (Drawable) null);
        this.boL.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds20);
        this.boL.setPadding(dimensionPixelSize * 3, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(d.e.ds30);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(d.e.ds10);
        layoutParams.leftMargin = getResources().getDimensionPixelSize(d.e.ds20);
        layoutParams.addRule(1, this.boK.getId());
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        this.boL.setOnClickListener(this);
        this.boL.setMinHeight(getResources().getDimensionPixelSize(d.e.ds100));
        addView(this.boL, layoutParams);
        this.boL.setVisibility(8);
    }

    private void JC() {
        if (this.boL != null) {
            boolean z = this.boQ || this.boR;
            if (!this.bpj && z && this.bpg != null && this.bpg.threadId > 0 && this.bpg.postId > 0 && this.bpg.mThreadType != 33 && !this.bpg.isBlockedPic) {
                this.boL.setVisibility(0);
                if (this.bpl != null) {
                    this.bpl.setVisibility(0);
                    return;
                }
                return;
            }
            this.boL.setVisibility(8);
            if (this.bpl != null) {
                this.bpl.setVisibility(8);
            }
        }
    }

    private void JD() {
        if (this.boL != null) {
            this.boL.setVisibility(8);
            if (this.bpl != null) {
                this.bpl.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JE() {
        if ((this.boQ || this.boR) && this.bpg != null && this.bpg.mPicType == 1 && !TextUtils.isEmpty(this.bpg.mTagName)) {
            if (this.boM != null) {
                this.boM.setVisibility(8);
                this.boM = null;
            }
            this.boM = new TextView(this.mContext);
            this.boM.setText(this.bpg.mTagName);
            this.boM.setTextSize(0, getResources().getDimensionPixelSize(d.e.fontsize26));
            aj.b(this.boM, d.C0141d.common_color_10013, 1, 0);
            aj.t(this.boM, d.C0141d.common_color_10215);
            this.boM.setAlpha(0.75f);
            this.boM.setIncludeFontPadding(false);
            this.boM.setGravity(17);
            int t = l.t(this.mContext, d.e.ds2);
            this.boM.setPadding(t, t, t, t);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.boJ.getBottomOffset();
            layoutParams.leftMargin = this.boJ.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.boM, layoutParams);
            this.boM.setVisibility(0);
        }
    }

    public void bU(boolean z) {
        this.bpj = z;
        if (this.bpj) {
            JD();
        } else {
            JC();
        }
    }

    public void m(String str, boolean z) {
        if (str.contains("*")) {
            str = str.split("[*]")[0];
        }
        this.boJ.setTag(str);
        this.boJ.setLoadBigImage(false);
        this.boJ.setImageDrawable(null);
        this.boQ = false;
        this.boR = false;
        this.bph = JL();
        this.boK.setVisibility(8);
        if (fN(str)) {
            b(str, z, false);
        }
    }

    private boolean JF() {
        return this.boJ != null && this.boJ.PM();
    }

    public void JG() {
        if (this.bpg != null && !JF()) {
            String str = this.bpg.imageUrl;
            int i = this.bpg.urlType;
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
        if (!this.bpi || z) {
            this.bpi = true;
            if (!this.bph || this.bpg == null || StringUtils.isNull(this.bpg.originalUrl, true) || this.bpg.originalSize < 0 || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String str = this.bpf + al.CY().en(eu) + "/" + ap.eu(this.bpg.originalUrl);
            final int[] dO = k.dO(str);
            this.boN.setVisibility(0);
            if (this.boO == null) {
                this.boO = new SubsamplingScaleImageView.OnImageEventListener() { // from class: com.baidu.tbadk.coreExtra.view.f.12
                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onReady() {
                        f.this.mProgressBar.setVisibility(8);
                        f.this.boJ.PI();
                        f.this.boJ.setVisibility(4);
                    }

                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onImageLoaded() {
                        if (f.this.bpg.isLongPic && dO[0] > 0) {
                            f.this.boJ.onDestroy();
                            final float measuredWidth = (f.this.getMeasuredWidth() * 1.0f) / dO[0];
                            final PointF pointF = new PointF((dO[0] * 1.0f) / 2.0f, 0.0f);
                            f.this.boN.setScaleAndCenter(measuredWidth, pointF);
                            f.this.boN.setMaxScale(2.0f * measuredWidth);
                            f.this.boN.setDoubleTapZoomScale(2.0f * measuredWidth);
                            f.this.boN.setInitScale(measuredWidth);
                            f.this.boN.setDoubleTapZoomStyle(4);
                            f.this.boN.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.f.12.1
                                @Override // android.view.View.OnTouchListener
                                public boolean onTouch(View view, MotionEvent motionEvent) {
                                    if (f.this.bpn != null) {
                                        f.this.bpn.onTouch(view, motionEvent);
                                    }
                                    switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                                        case 0:
                                            f.this.bpp = motionEvent.getY();
                                            f.this.boN.setOnClickListener(f.this.bpo ? f.this.mOnClickListener : null);
                                            f.this.boN.setOnLongClickListener(f.this.bpo ? f.this.bpq : null);
                                            break;
                                        case 1:
                                        case 3:
                                            if (f.this.boN.getScale() < measuredWidth) {
                                                f.this.boN.setScaleAndCenter(measuredWidth, pointF);
                                            }
                                            com.baidu.adp.lib.g.e.ns().removeCallbacks(f.this.bpr);
                                            com.baidu.adp.lib.g.e.ns().postDelayed(f.this.bpr, 1000L);
                                            break;
                                        case 2:
                                            if (Math.abs(motionEvent.getY() - f.this.bpp) > f.TOUCH_SLOP) {
                                                f.this.bpo = false;
                                                f.this.boN.setOnClickListener(null);
                                                f.this.boN.setOnLongClickListener(null);
                                            }
                                            f.this.bpp = motionEvent.getY();
                                            break;
                                    }
                                    return false;
                                }
                            });
                            f.this.boJ.setVisibility(4);
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
            this.boN.setOnImageEventListener(this.boO);
            if (this.boN.isImageLoaded() && this.bpg.isLongPic) {
                this.boO.onImageLoaded();
            } else {
                this.boN.setImage(ImageSource.uri(str));
            }
            return true;
        }
        return false;
    }

    public void setDragToExitListener(a.d dVar) {
        this.bpd = dVar;
        if (this.boJ != null) {
            this.boJ.setDragToExitListener(dVar);
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
        if (!this.boR && aVar != null && (sh = aVar.sh()) != null) {
            this.boQ = true;
            if (aVar.isGif()) {
                this.boJ.setImageUrlData(this.bpg);
                this.boJ.setImageBitmap(sh);
                this.boK.setVisibility(8);
                this.bpk = false;
            } else {
                if (this.bpg != null && this.bpg.isLongPic) {
                    this.boJ.PA();
                    this.boJ.setImageLoadCallBack(new com.baidu.tbadk.widget.a.b.a() { // from class: com.baidu.tbadk.coreExtra.view.f.13
                        @Override // com.baidu.tbadk.widget.a.b.a
                        public void JP() {
                        }
                    });
                }
                this.boJ.setImageUrlData(this.bpg);
                this.boJ.a(sh, aVar.sm());
            }
            JC();
            JE();
        }
    }

    private void b(String str, boolean z, boolean z2) {
        if (fO(str)) {
            if (z2 || (!this.boS && !this.boR)) {
                if (!z2 || !bV(true)) {
                    this.boS = true;
                    com.baidu.adp.lib.f.c.nm().a(str, 27, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.coreExtra.view.f.14
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onCancelled(String str2) {
                            f.this.boS = false;
                            f.this.boJ.setVisibility(0);
                            f.this.mProgressBar.setVisibility(8);
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onLoaded(com.baidu.adp.widget.a.a aVar, String str2, int i) {
                            f.this.boS = false;
                            f.this.boR = true;
                            f.this.b(aVar);
                        }
                    }, 0, 0, false, null, Boolean.valueOf(z), this.boJ.getImageData(), Boolean.valueOf(this.bmv));
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
        com.baidu.adp.widget.a.a a2 = this.bpm.a(imageFileInfo, false);
        if (a2 != null) {
            this.boR = true;
            this.mProgressBar.setVisibility(8);
            b(a2);
            return;
        }
        this.bpm.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.coreExtra.view.f.2
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.a.a aVar, String str2, boolean z3) {
                f.this.boR = true;
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
        if (aVar != null && this.boP != null) {
            this.boP.k(aVar.getUrl(), aVar.sm());
        }
        if (aVar == null || aVar.sh() == null) {
            JI();
            return;
        }
        Bitmap sh = aVar.sh();
        this.boJ.setLoadBigImage(true);
        if (aVar.isGif()) {
            this.boJ.a(aVar.sm(), sh);
            this.boJ.invalidate();
            this.boJ.play();
            this.bpk = false;
            this.boK.setVisibility(8);
            this.mProgressBar.setVisibility(8);
        } else {
            if (this.bpg != null && this.bpg.isLongPic) {
                this.boJ.PA();
                this.boJ.setImageLoadCallBack(new com.baidu.tbadk.widget.a.b.a() { // from class: com.baidu.tbadk.coreExtra.view.f.3
                    @Override // com.baidu.tbadk.widget.a.b.a
                    public void JP() {
                        f.this.mProgressBar.setVisibility(8);
                    }
                });
            } else {
                this.mProgressBar.setVisibility(8);
            }
            this.boJ.setImageUrlData(this.bpg);
            this.boJ.a(sh, aVar.sm());
            JM();
        }
        JC();
        JE();
    }

    private void JI() {
        if (!this.boQ) {
            this.boJ.PF();
        } else {
            this.boR = false;
        }
        this.boK.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    public void setGifMaxUseableMem(int i) {
        this.boJ.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.boJ != null) {
            this.boJ.onDestroy();
        }
        if (this.boN != null) {
            this.boN.recycle();
        }
        if (this.boV != null) {
            this.boV.recycle();
            this.boV = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.bpr);
    }

    public void release() {
        if (this.boJ != null) {
            this.boJ.release();
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.boK != null) {
            this.boK.setVisibility(8);
        }
    }

    public void JJ() {
        if (this.boJ != null && this.boJ.getImageType() == 1) {
            this.boJ.stop();
        }
    }

    public void l(boolean z, boolean z2) {
        String str;
        if (this.boJ != null && (str = (String) this.boJ.getTag()) != null) {
            if (this.boJ.getImageType() == 1) {
                if (this.boJ.getGifCache() == null || !this.boJ.PM()) {
                    b(str, z, z2);
                }
            } else if (this.boJ.getImageType() == 2) {
                b(str, z, z2);
            } else if (JK()) {
                b(str, z, z2);
            }
        }
    }

    private boolean JK() {
        if (this.boJ.getImageBitmap() != null && this.boJ.PM()) {
            if (this.bpg == null || !this.bpg.isLongPic || this.boJ.PB()) {
                return false;
            }
            this.boR = false;
            this.bpi = false;
            return true;
        }
        return true;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.bpg = imageUrlData;
    }

    public void setIsCdn(boolean z) {
        this.bmv = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.boK) {
            if (!(this.boK.getTag() instanceof Boolean) || ((Boolean) this.boK.getTag()).booleanValue()) {
                final String eu = ap.eu(this.bpg.originalUrl);
                if (this.bpg.originalProcess >= 0) {
                    com.baidu.tbadk.download.e.KU().z(eu, 13);
                    this.bpg.originalProcess = -1;
                    JM();
                    return;
                }
                if (this.bmx != null) {
                    this.bmx.JQ();
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
                    aVar.AV();
                }
            }
        } else if (view == this.boL && this.bpg != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.mContext).createHistoryCfg(String.valueOf(this.bpg.threadId), String.valueOf(this.bpg.postId), this.bpg.mIsSeeHost, this.bpg.mIsReserver, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fP(String str) {
        if (this.bpg != null) {
            this.bpg.originalProcess = 0;
        }
        this.boK.setText("0%");
        this.boK.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_close_yuantu, 0);
        DownloadData downloadData = new DownloadData(str);
        downloadData.setStatus(1);
        downloadData.setUrl(this.bpg.originalUrl);
        downloadData.setType(13);
        downloadData.setPath(this.bpf + al.CY().en(str) + "/" + str);
        downloadData.setCallback(new com.baidu.tbadk.download.d() { // from class: com.baidu.tbadk.coreExtra.view.f.6
            @Override // com.baidu.tbadk.download.d
            public boolean onPreDownload(DownloadData downloadData2) {
                return true;
            }

            @Override // com.baidu.tbadk.download.d
            public void onFileUpdateProgress(DownloadData downloadData2) {
                if (downloadData2 != null) {
                    if (f.this.bpg != null && f.this.bpg.originalProcess != -1) {
                        f.this.bpg.originalProcess = downloadData2.getProcess();
                    }
                    if (f.this.bpg == null || f.this.bpg.originalProcess != -1) {
                        f.this.boK.setText(downloadData2.getProcess() + "%");
                        f.this.boK.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_close_yuantu, 0);
                    }
                }
            }

            @Override // com.baidu.tbadk.download.d
            public boolean onFileDownloaded(DownloadData downloadData2) {
                return true;
            }

            @Override // com.baidu.tbadk.download.d
            public void onFileDownloadSucceed(DownloadData downloadData2) {
                f.this.boK.setText(f.this.getResources().getString(d.j.done));
                f.this.boK.setTag(false);
                f.this.boK.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                com.baidu.adp.lib.g.e.ns().postDelayed(f.this.bps, 1500L);
                f.this.bpi = false;
                f.this.bph = f.this.JL();
                f.this.JH();
            }

            @Override // com.baidu.tbadk.download.d
            public void onFileDownloadFailed(DownloadData downloadData2, int i, String str2) {
                f.this.bpi = false;
                BdToast.a(f.this.mContext, str2).Bb().Bd();
                f.this.bpg.originalProcess = -1;
                f.this.JM();
            }
        });
        com.baidu.tbadk.download.e.KU().a(downloadData, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean JL() {
        if (this.bpg != null && !StringUtils.isNull(this.bpg.originalUrl, true) && this.bpg.originalSize >= 0 && !this.bpg.isBlockedPic) {
            String eu = ap.eu(this.bpg.originalUrl);
            File file = new File(this.bpf + al.CY().en(eu) + "/" + eu);
            if (file != null && file.exists()) {
                this.bpg.originalProcess = 100;
                return true;
            }
            if (this.bpg.originalProcess < 0) {
                JM();
            } else {
                this.boK.setText(this.bpg.originalProcess + "%");
                this.boK.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_close_yuantu, 0);
            }
            this.bpk = true;
        } else {
            this.boK.setVisibility(8);
        }
        return false;
    }

    public void JM() {
        if (this.bpg != null) {
            if (!JN() || !this.bpk) {
                this.boK.setVisibility(8);
            } else {
                this.boK.setVisibility(0);
            }
            if (this.bpg.originalSize > 0 && !Z(this.bpg.originalSize)) {
                this.boK.setText(boH + "(" + am.O(this.bpg.originalSize) + ")");
            } else {
                this.boK.setText(boH);
            }
            this.boK.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    private boolean JN() {
        return (this.bpg == null || !this.bpg.mIsShowOrigonButton || this.bpg.isBlockedPic || StringUtils.isNull(this.bpg.originalUrl)) ? false : true;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.bmx = bVar;
    }

    private boolean Z(long j) {
        return j > boI;
    }
}
