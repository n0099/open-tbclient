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
import android.support.v4.view.MotionEventCompat;
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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
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
    private boolean avc;
    private b ave;
    private boolean avf;
    private boolean axA;
    private boolean axB;
    private boolean axC;
    private boolean axD;
    private Bitmap axE;
    private boolean axF;
    private float axG;
    private Matrix axH;
    private Rect axI;
    private RectF axJ;
    private Rect axK;
    private Rect axL;
    private a.d axM;
    private ImageUrlData axO;
    private boolean axP;
    private boolean axQ;
    private boolean axR;
    public boolean axS;
    private TextView axT;
    private com.baidu.tbadk.img.b axU;
    private View.OnTouchListener axV;
    private boolean axW;
    private float axX;
    private View.OnLongClickListener axY;
    private Runnable axZ;
    protected com.baidu.tbadk.widget.a axs;
    protected TextView axt;
    protected TextView axu;
    protected TextView axv;
    protected SubsamplingScaleImageView axw;
    private SubsamplingScaleImageView.OnImageEventListener axx;
    private a axy;
    private boolean axz;
    private Runnable aya;
    private View.OnTouchListener ayb;
    protected Context mContext;
    private float mLastMotionX;
    private float mLastMotionY;
    private int mMaxHeight;
    private int mMaxWidth;
    private View.OnClickListener mOnClickListener;
    protected ProgressBar mProgressBar;
    private float mRatio;
    private int mSkinType;
    private static final String axq = TbadkCoreApplication.getInst().getString(d.j.original_img_look);
    private static long axr = 52428800;
    private static final int axN = l.ae(TbadkCoreApplication.getInst()) / 5;
    private static final String TAG = f.class.getSimpleName();
    private static final int TOUCH_SLOP = ViewConfiguration.get(TbadkCoreApplication.getInst()).getScaledTouchSlop();

    /* loaded from: classes.dex */
    public interface a {
        void j(String str, byte[] bArr);
    }

    /* loaded from: classes.dex */
    public interface b {
        void Bt();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.axt != null) {
                aj.j(this.axt, d.f.btn_percent_yuantu);
                aj.b(this.axt, d.C0080d.cp_cont_g, 1, 0);
            }
            if (this.axu != null) {
                aj.k(this.axu, d.C0080d.common_color_10022);
                aj.b(this.axu, d.C0080d.cp_cont_g, 1, 0);
            }
            this.mSkinType = i;
        }
    }

    public void setHeadImage(boolean z) {
        if (this.axs != null) {
            this.axs.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.axy = aVar;
    }

    public f(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mContext = null;
        this.mProgressBar = null;
        this.axs = null;
        this.axy = null;
        this.avc = false;
        this.axB = false;
        this.axF = false;
        this.mRatio = 1.0f;
        this.axG = 0.0f;
        this.axH = new Matrix();
        this.axJ = new RectF();
        this.axP = false;
        this.axQ = false;
        this.axR = false;
        this.axS = false;
        this.axT = null;
        this.axW = true;
        this.axX = 0.0f;
        this.mOnClickListener = null;
        this.axY = null;
        this.axZ = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.f.1
            @Override // java.lang.Runnable
            public void run() {
                f.this.axW = true;
            }
        };
        this.aya = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.f.7
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
                        f.this.axt.setVisibility(8);
                        f.this.axS = false;
                    }
                });
                f.this.axt.startAnimation(alphaAnimation);
            }
        };
        this.ayb = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.f.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (f.this.axV != null) {
                    f.this.axV.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.axU = new com.baidu.tbadk.img.b();
        init();
    }

    public com.baidu.tbadk.widget.a getImageView() {
        return this.axs;
    }

    public void setGifSetListener(a.e eVar) {
        this.axs.setGifSetListener(eVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.axs.setImageOnClickListener(onClickListener);
        this.axw.setOnClickListener(onClickListener);
        this.mOnClickListener = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.axY = onLongClickListener;
        if (!this.avf) {
            this.axs.setImageOnLongClickListener(this.axY);
            this.axw.setOnLongClickListener(this.axY);
        }
    }

    public void setOnSizeChangedListener(final a.f fVar) {
        this.axs.setOnSizeChangedListener(new a.f() { // from class: com.baidu.tbadk.coreExtra.view.f.8
            @Override // com.baidu.tbadk.widget.a.f
            public void a(com.baidu.tbadk.widget.a aVar, boolean z, boolean z2) {
                if (fVar != null) {
                    fVar.a(aVar, z, z2);
                }
                f.this.Bh();
            }
        });
    }

    protected void init() {
        this.mMaxWidth = l.ac(this.mContext);
        this.mMaxHeight = l.ae(this.mContext) - ((int) this.mContext.getResources().getDimension(d.e.ds166));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.axs = new com.baidu.tbadk.widget.a(this.mContext);
        this.axs.setLayoutParams(layoutParams);
        this.axs.setOnTouchListener(this.ayb);
        addView(this.axs);
        this.axw = new SubsamplingScaleImageView(this.mContext);
        this.axw.setMaxScale(50.0f);
        this.axw.setOnTouchListener(this.ayb);
        this.axw.setVisibility(4);
        addView(this.axw, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(getResources().getDrawable(d.f.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        Bd();
        Bb();
        Be();
    }

    private void Bb() {
        this.axt = new TextView(this.mContext);
        aj.j(this.axt, d.f.btn_percent_yuantu);
        this.axt.setText(d.j.original_img_look);
        this.axt.setTextSize(0, getResources().getDimensionPixelSize(d.e.fontsize28));
        aj.b(this.axt, d.C0080d.cp_cont_g, 1, 0);
        this.axt.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds20);
        this.axt.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        this.axt.setMinWidth(getResources().getDimensionPixelSize(d.e.ds220));
        this.axt.setMinHeight(getResources().getDimensionPixelSize(d.e.ds68));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(d.e.fontsize40);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        this.axt.setOnClickListener(this);
        this.axt.setVisibility(8);
        addView(this.axt, layoutParams);
    }

    public void setIsCanDrag(boolean z) {
        this.avf = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        Bitmap imageBitmap;
        int height;
        int width;
        if (!this.avf || !this.axA) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.axC && motionEvent.getPointerCount() >= 2) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.axC || this.axD) {
            requestDisallowInterceptTouchEvent(true);
        }
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        float x = motionEvent.getX();
        int i = action & MotionEventCompat.ACTION_MASK;
        if (i == 0) {
            if (this.axE == null) {
                if (this.axw.getVisibility() == 0) {
                    this.axE = com.baidu.tbadk.util.d.R(this.axw);
                } else {
                    this.axE = com.baidu.tbadk.util.d.R(this.axs);
                }
            }
            if (this.axI == null && this.axE != null) {
                int measuredWidth = getMeasuredWidth();
                float measuredWidth2 = ((getMeasuredWidth() * 1.0f) / this.axE.getWidth()) * this.axE.getHeight();
                if (measuredWidth2 > getMeasuredHeight()) {
                    measuredWidth2 = getMeasuredHeight();
                }
                RectF e = e(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
                this.axI = new Rect((int) e.left, (int) e.top, (int) e.right, (int) e.bottom);
            }
            if (this.axL == null && this.axE != null) {
                if (this.axw.getVisibility() == 0) {
                    height = this.axw.getSHeight();
                    width = this.axw.getSWidth();
                } else {
                    if (this.axs.getImageType() == 1) {
                        imageBitmap = (this.axs.getCurrentFrame() == null || this.axs.getCurrentFrame().aNG == null) ? this.axE : this.axs.getCurrentFrame().aNG;
                    } else {
                        imageBitmap = this.axs.getImageBitmap() == null ? this.axE : this.axs.getImageBitmap();
                    }
                    height = imageBitmap.getHeight();
                    width = imageBitmap.getWidth();
                }
                float af = l.af(getContext());
                int i2 = (int) (height * af);
                int i3 = (int) (width * af);
                if (i3 > this.axE.getWidth() && this.axE.getWidth() != 0) {
                    float width2 = (i3 * 1.0f) / this.axE.getWidth();
                    i3 = this.axE.getWidth();
                    i2 = (int) (i2 / width2);
                }
                if (i2 > this.axE.getHeight() && this.axE.getHeight() != 0) {
                    i3 = (int) (i3 / ((i2 * 1.0f) / this.axE.getHeight()));
                    i2 = this.axE.getHeight();
                }
                int ae = (l.ae(getContext()) - i2) / 2;
                int ac = (l.ac(getContext()) - i3) / 2;
                this.axL = new Rect(ac, ae, i3 + ac, i2 + ae);
                this.axK = new Rect(0, 0, this.axE.getWidth(), this.axE.getHeight());
            }
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (i == 2) {
            this.axC = d(this.mLastMotionX - x, this.mLastMotionY - y);
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (this.axC || this.axD) {
            this.axs.setImageOnLongClickListener(null);
            this.axw.setOnLongClickListener(null);
            z = true;
        } else {
            this.axs.setImageOnLongClickListener(this.axY);
            this.axw.setOnLongClickListener(this.axY);
            z = super.dispatchTouchEvent(motionEvent);
        }
        if (i == 1 || i == 3) {
            this.mLastMotionX = 0.0f;
            this.mLastMotionY = 0.0f;
            this.axF = false;
            this.axH.reset();
            this.axC = false;
            if (this.axG > axN) {
                this.axD = true;
                Bc();
                return z;
            }
            this.mRatio = 1.0f;
            invalidate();
            return z;
        }
        return z;
    }

    private boolean d(float f, float f2) {
        if (this.axw.getVisibility() != 0 || this.axw.isCanDrag()) {
            if (this.axO == null || !this.axO.isLongPic || this.axw.getVisibility() != 0 || this.axw.isViewTop()) {
                if (this.axO == null || !this.axO.isLongPic || this.axw.getVisibility() == 0 || this.axs.Hi()) {
                    if (this.axw.getVisibility() == 0 || this.axs.Hk()) {
                        if (this.axE != null && getScrollY() == 0 && f2 < 0.0f && !this.axF) {
                            this.axF = true;
                            this.axG = 0.0f;
                            this.mRatio = 1.0f;
                            if (this.axM != null) {
                                this.axM.HB();
                            }
                        }
                        if (this.axF) {
                            this.axG -= f2;
                            int measuredHeight = getMeasuredHeight();
                            if (this.axG > measuredHeight) {
                                this.axG = measuredHeight;
                            }
                            float f3 = f2 / measuredHeight;
                            this.axH.postTranslate((-f) * 1.5f * this.mRatio, (-1.5f) * f2 * this.mRatio);
                            if (this.mRatio * (1.0f + f3) > 1.0f || this.axG < 0.0f) {
                                this.axH.preScale(1.0f / this.mRatio, 1.0f / this.mRatio, (this.mRatio * this.axE.getWidth()) / 2.0f, this.mRatio * (this.axE.getHeight() / 2));
                                this.mRatio = 1.0f;
                            } else {
                                this.axH.preScale(1.0f + f3, 1.0f + f3, (this.mRatio * this.axE.getWidth()) / 2.0f, this.mRatio * (this.axE.getHeight() / 2));
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
        if (this.axC && this.axE != null && !this.axE.isRecycled() && this.axF) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.axJ == null) {
                this.axJ = new RectF();
            }
            this.axH.mapRect(this.axJ, new RectF(this.axI));
            canvas.drawBitmap(this.axE, this.axK, this.axJ, (Paint) null);
        } else if (this.axD && this.axE != null && !this.axE.isRecycled()) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            canvas.drawBitmap(this.axE, this.axL, this.axJ, (Paint) null);
        } else {
            super.dispatchDraw(canvas);
        }
    }

    private void Bc() {
        if (this.axO == null) {
            if (this.axM != null) {
                this.axM.HC();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.axO.getSourceImageRectInScreen();
        if (sourceImageRectInScreen == null) {
            if (this.axM != null) {
                this.axM.HC();
                return;
            }
            return;
        }
        this.axJ.bottom = (((sourceImageRectInScreen.bottom - sourceImageRectInScreen.top) / (sourceImageRectInScreen.right - sourceImageRectInScreen.left)) * (this.axJ.right - this.axJ.left)) + this.axJ.top;
        final float[] fArr = {(this.axJ.left + this.axJ.right) / 2.0f, (this.axJ.top + this.axJ.bottom) / 2.0f};
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
                    f.this.axJ = f.this.e(floatValue, animatedFraction, sourceImageRectInScreen.right - sourceImageRectInScreen.left, sourceImageRectInScreen.bottom - sourceImageRectInScreen.top);
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
                f.this.axF = false;
                f.this.invalidate();
                if (f.this.axM != null) {
                    f.this.axM.HC();
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
    public RectF e(float f, float f2, float f3, float f4) {
        return new RectF(f - (f3 / 2.0f), f2 - (f4 / 2.0f), (f3 / 2.0f) + f, (f4 / 2.0f) + f2);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.axV = onTouchListener;
    }

    private void Bd() {
        this.axT = new TextView(this.mContext);
        this.axT.setBackgroundResource(d.f.bg_url_drag_imagview_fade_view);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.height = getResources().getDimensionPixelSize(d.e.ds180);
        layoutParams.addRule(12);
        addView(this.axT, layoutParams);
        this.axT.setVisibility(8);
    }

    private void Be() {
        this.axu = new TextView(this.mContext);
        aj.k(this.axu, d.C0080d.common_color_10022);
        this.axu.setText(d.j.goto_pb_floor);
        this.axu.setTextSize(0, getResources().getDimensionPixelSize(d.e.fontsize24));
        aj.b(this.axu, d.C0080d.cp_cont_g, 1, 0);
        this.axu.setCompoundDrawablePadding(l.dip2px(this.mContext, 4.0f));
        this.axu.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_see_arrow), (Drawable) null);
        this.axu.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds20);
        this.axu.setPadding(dimensionPixelSize * 3, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(d.e.ds30);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(d.e.ds10);
        layoutParams.leftMargin = getResources().getDimensionPixelSize(d.e.ds20);
        layoutParams.addRule(1, this.axt.getId());
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        this.axu.setOnClickListener(this);
        this.axu.setMinHeight(getResources().getDimensionPixelSize(d.e.ds100));
        addView(this.axu, layoutParams);
        this.axu.setVisibility(8);
    }

    private void Bf() {
        if (this.axu != null) {
            boolean z = this.axz || this.axA;
            if (!this.axR && z && this.axO != null && this.axO.threadId > 0 && this.axO.postId > 0 && this.axO.mThreadType != 33 && !this.axO.isBlockedPic) {
                this.axu.setVisibility(0);
                if (this.axT != null) {
                    this.axT.setVisibility(0);
                    return;
                }
                return;
            }
            this.axu.setVisibility(8);
            if (this.axT != null) {
                this.axT.setVisibility(8);
            }
        }
    }

    private void Bg() {
        if (this.axu != null) {
            this.axu.setVisibility(8);
            if (this.axT != null) {
                this.axT.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bh() {
        if ((this.axz || this.axA) && this.axO != null && this.axO.mPicType == 1 && !TextUtils.isEmpty(this.axO.mTagName)) {
            if (this.axv != null) {
                this.axv.setVisibility(8);
                this.axv = null;
            }
            this.axv = new TextView(this.mContext);
            this.axv.setText(this.axO.mTagName);
            this.axv.setTextSize(0, getResources().getDimensionPixelSize(d.e.fontsize26));
            aj.b(this.axv, d.C0080d.common_color_10013, 1, 0);
            aj.k(this.axv, d.C0080d.common_color_10215);
            this.axv.setAlpha(0.75f);
            this.axv.setIncludeFontPadding(false);
            this.axv.setGravity(17);
            int f = l.f(this.mContext, d.e.ds2);
            this.axv.setPadding(f, f, f, f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.axs.getBottomOffset();
            layoutParams.leftMargin = this.axs.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.axv, layoutParams);
            this.axv.setVisibility(0);
        }
    }

    public void bj(boolean z) {
        this.axR = z;
        if (this.axR) {
            Bg();
        } else {
            Bf();
        }
    }

    public void n(String str, boolean z) {
        if (str.contains("*")) {
            str = str.split("[*]")[0];
        }
        this.axs.setTag(str);
        this.axs.setLoadBigImage(false);
        this.axs.setImageDrawable(null);
        this.axz = false;
        this.axA = false;
        this.axP = Bo();
        this.axt.setVisibility(8);
        if (fi(str)) {
            d(str, z, false);
        }
    }

    private boolean Bi() {
        return this.axs != null && this.axs.Hz();
    }

    public void Bj() {
        if (this.axO != null && !Bi()) {
            String str = this.axO.imageUrl;
            int i = this.axO.urlType;
            com.baidu.adp.widget.a.a aVar = null;
            if (com.baidu.tbadk.core.util.c.a.v(str, i)) {
                aVar = com.baidu.tbadk.core.util.c.a.w(str, i);
            }
            if (aVar != null) {
                setThumbBitmapToView(aVar);
            }
        }
    }

    private boolean bl(boolean z) {
        String dV;
        if (!this.axQ || z) {
            this.axQ = true;
            if (!this.axP || this.axO == null || StringUtils.isNull(this.axO.originalUrl, true) || this.axO.originalSize < 0 || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String str = k.uj() + al.vm().dN(dV) + "/" + ao.dV(this.axO.originalUrl);
            final int[] ds = k.ds(str);
            this.axw.setVisibility(0);
            if (this.axx == null) {
                this.axx = new SubsamplingScaleImageView.OnImageEventListener() { // from class: com.baidu.tbadk.coreExtra.view.f.12
                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onReady() {
                        f.this.mProgressBar.setVisibility(8);
                        f.this.axs.Hv();
                        f.this.axs.setVisibility(4);
                    }

                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onImageLoaded() {
                        if (f.this.axO.isLongPic && ds[0] > 0) {
                            f.this.axs.onDestroy();
                            final float measuredWidth = (f.this.getMeasuredWidth() * 1.0f) / ds[0];
                            final PointF pointF = new PointF((ds[0] * 1.0f) / 2.0f, 0.0f);
                            f.this.axw.setScaleAndCenter(measuredWidth, pointF);
                            f.this.axw.setMaxScale(2.0f * measuredWidth);
                            f.this.axw.setDoubleTapZoomScale(2.0f * measuredWidth);
                            f.this.axw.setInitScale(measuredWidth);
                            f.this.axw.setDoubleTapZoomStyle(4);
                            f.this.axw.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.f.12.1
                                @Override // android.view.View.OnTouchListener
                                public boolean onTouch(View view, MotionEvent motionEvent) {
                                    if (f.this.axV != null) {
                                        f.this.axV.onTouch(view, motionEvent);
                                    }
                                    switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                                        case 0:
                                            f.this.axX = motionEvent.getY();
                                            f.this.axw.setOnClickListener(f.this.axW ? f.this.mOnClickListener : null);
                                            f.this.axw.setOnLongClickListener(f.this.axW ? f.this.axY : null);
                                            break;
                                        case 1:
                                        case 3:
                                            if (f.this.axw.getScale() < measuredWidth) {
                                                f.this.axw.setScaleAndCenter(measuredWidth, pointF);
                                            }
                                            com.baidu.adp.lib.g.e.fP().removeCallbacks(f.this.axZ);
                                            com.baidu.adp.lib.g.e.fP().postDelayed(f.this.axZ, 1000L);
                                            break;
                                        case 2:
                                            if (Math.abs(motionEvent.getY() - f.this.axX) > f.TOUCH_SLOP) {
                                                f.this.axW = false;
                                                f.this.axw.setOnClickListener(null);
                                                f.this.axw.setOnLongClickListener(null);
                                            }
                                            f.this.axX = motionEvent.getY();
                                            break;
                                    }
                                    return false;
                                }
                            });
                            f.this.axs.setVisibility(4);
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
            this.axw.setOnImageEventListener(this.axx);
            if (this.axw.isImageLoaded() && this.axO.isLongPic) {
                this.axx.onImageLoaded();
            } else {
                this.axw.setImage(ImageSource.uri(str));
            }
            return true;
        }
        return false;
    }

    public void setDragToExitListener(a.d dVar) {
        this.axM = dVar;
        if (this.axs != null) {
            this.axs.setDragToExitListener(dVar);
        }
    }

    public void Bk() {
        bl(false);
    }

    private boolean fi(String str) {
        return j.hh() || com.baidu.tbadk.core.util.c.c.ej(str);
    }

    private void setThumbBitmapToView(com.baidu.adp.widget.a.a aVar) {
        Bitmap kK;
        if (!this.axA && aVar != null && (kK = aVar.kK()) != null) {
            this.axz = true;
            if (aVar.isGif()) {
                this.axs.setImageUrlData(this.axO);
                this.axs.setImageBitmap(kK);
                this.axt.setVisibility(8);
                this.axS = false;
            } else {
                if (this.axO != null && this.axO.isLongPic) {
                    this.axs.Hn();
                    this.axs.setImageLoadCallBack(new com.baidu.tbadk.widget.a.b.a() { // from class: com.baidu.tbadk.coreExtra.view.f.13
                        @Override // com.baidu.tbadk.widget.a.b.a
                        public void Bs() {
                        }
                    });
                }
                this.axs.setImageUrlData(this.axO);
                this.axs.a(kK, aVar.kP());
            }
            Bf();
            Bh();
        }
    }

    private void d(String str, boolean z, boolean z2) {
        if (fj(str)) {
            if (z2 || (!this.axB && !this.axA)) {
                if (!z2 || !bl(true)) {
                    this.axB = true;
                    com.baidu.adp.lib.f.c.fJ().a(str, 27, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.coreExtra.view.f.14
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onCancelled(String str2) {
                            f.this.axB = false;
                            f.this.axs.setVisibility(0);
                            f.this.mProgressBar.setVisibility(8);
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onLoaded(com.baidu.adp.widget.a.a aVar, String str2, int i) {
                            f.this.axB = false;
                            f.this.axA = true;
                            f.this.b(aVar);
                        }
                    }, 0, 0, false, null, Boolean.valueOf(z), this.axs.getImageData(), Boolean.valueOf(this.avc));
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
        imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.K(this.mMaxWidth, this.mMaxHeight));
        com.baidu.adp.widget.a.a a2 = this.axU.a(imageFileInfo, false);
        if (a2 != null) {
            this.axA = true;
            this.mProgressBar.setVisibility(8);
            b(a2);
            return;
        }
        this.axU.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.coreExtra.view.f.2
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.a.a aVar, String str2, boolean z3) {
                f.this.axA = true;
                f.this.mProgressBar.setVisibility(8);
                f.this.b(aVar);
            }
        }, false);
    }

    private boolean fj(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith("https://"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null && this.axy != null) {
            this.axy.j(aVar.getUrl(), aVar.kP());
        }
        if (aVar == null || aVar.kK() == null) {
            Bl();
            return;
        }
        Bitmap kK = aVar.kK();
        this.axs.setLoadBigImage(true);
        if (aVar.isGif()) {
            this.axs.a(aVar.kP(), kK);
            this.axs.invalidate();
            this.axs.play();
            this.axS = false;
            this.axt.setVisibility(8);
            this.mProgressBar.setVisibility(8);
        } else {
            if (this.axO != null && this.axO.isLongPic) {
                this.axs.Hn();
                this.axs.setImageLoadCallBack(new com.baidu.tbadk.widget.a.b.a() { // from class: com.baidu.tbadk.coreExtra.view.f.3
                    @Override // com.baidu.tbadk.widget.a.b.a
                    public void Bs() {
                        f.this.mProgressBar.setVisibility(8);
                    }
                });
            } else {
                this.mProgressBar.setVisibility(8);
            }
            this.axs.setImageUrlData(this.axO);
            this.axs.a(kK, aVar.kP());
            Bp();
        }
        Bf();
        Bh();
    }

    private void Bl() {
        if (!this.axz) {
            this.axs.Hs();
        } else {
            this.axA = false;
        }
        this.axt.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    public void setGifMaxUseableMem(int i) {
        this.axs.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.axs != null) {
            this.axs.onDestroy();
        }
        if (this.axw != null) {
            this.axw.recycle();
        }
        if (this.axE != null) {
            this.axE.recycle();
            this.axE = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.axZ);
    }

    public void release() {
        if (this.axs != null) {
            this.axs.release();
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.axt != null) {
            this.axt.setVisibility(8);
        }
    }

    public void Bm() {
        if (this.axs != null && this.axs.getImageType() == 1) {
            this.axs.stop();
        }
    }

    public void j(boolean z, boolean z2) {
        String str;
        if (this.axs != null && (str = (String) this.axs.getTag()) != null) {
            if (this.axs.getImageType() == 1) {
                if (this.axs.getGifCache() == null || !this.axs.Hz()) {
                    d(str, z, z2);
                }
            } else if (this.axs.getImageType() == 2) {
                d(str, z, z2);
            } else if (Bn()) {
                d(str, z, z2);
            }
        }
    }

    private boolean Bn() {
        if (this.axs.getImageBitmap() != null && this.axs.Hz()) {
            if (this.axO == null || !this.axO.isLongPic || this.axs.Ho()) {
                return false;
            }
            this.axA = false;
            this.axQ = false;
            return true;
        }
        return true;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.axO = imageUrlData;
    }

    public void setIsCdn(boolean z) {
        this.avc = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.axt) {
            if (!(this.axt.getTag() instanceof Boolean) || ((Boolean) this.axt.getTag()).booleanValue()) {
                final String dV = ao.dV(this.axO.originalUrl);
                if (this.axO.originalProcess >= 0) {
                    com.baidu.tbadk.download.e.CA().z(dV, 13);
                    this.axO.originalProcess = -1;
                    Bp();
                    return;
                }
                if (this.ave != null) {
                    this.ave.Bt();
                }
                com.baidu.adp.base.e<?> Y = i.Y(this.mContext);
                if (Y == null) {
                    fk(dV);
                } else if (!j.hh() || j.hi() || com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("original_img_down_tip", false)) {
                    fk(dV);
                } else {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("original_img_down_tip", true);
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(Y.getPageActivity());
                    aVar.cc(d.j.original_img_down_no_wifi_tip);
                    aVar.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.f.4
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar.dismiss();
                            f.this.fk(dV);
                        }
                    });
                    aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.f.5
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar.dismiss();
                        }
                    });
                    aVar.b(Y);
                    aVar.th();
                }
            }
        } else if (view == this.axu && this.axO != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mContext).createHistoryCfg(String.valueOf(this.axO.threadId), String.valueOf(this.axO.postId), this.axO.mIsSeeHost, this.axO.mIsReserver, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fk(String str) {
        if (this.axO != null) {
            this.axO.originalProcess = 0;
        }
        this.axt.setText("0%");
        this.axt.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_close_yuantu, 0);
        DownloadData downloadData = new DownloadData(str);
        downloadData.setStatus(1);
        downloadData.setUrl(this.axO.originalUrl);
        downloadData.setType(13);
        downloadData.setPath(k.uj() + al.vm().dN(str) + "/" + str);
        downloadData.setCallback(new com.baidu.tbadk.download.d() { // from class: com.baidu.tbadk.coreExtra.view.f.6
            @Override // com.baidu.tbadk.download.d
            public boolean onPreDownload(DownloadData downloadData2) {
                return true;
            }

            @Override // com.baidu.tbadk.download.d
            public void onFileUpdateProgress(DownloadData downloadData2) {
                if (downloadData2 != null) {
                    if (f.this.axO != null && f.this.axO.originalProcess != -1) {
                        f.this.axO.originalProcess = downloadData2.getProcess();
                    }
                    if (f.this.axO == null || f.this.axO.originalProcess != -1) {
                        f.this.axt.setText(downloadData2.getProcess() + "%");
                        f.this.axt.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_close_yuantu, 0);
                    }
                }
            }

            @Override // com.baidu.tbadk.download.d
            public boolean onFileDownloaded(DownloadData downloadData2) {
                return true;
            }

            @Override // com.baidu.tbadk.download.d
            public void onFileDownloadSucceed(DownloadData downloadData2) {
                f.this.axt.setText(f.this.getResources().getString(d.j.done));
                f.this.axt.setTag(false);
                f.this.axt.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                com.baidu.adp.lib.g.e.fP().postDelayed(f.this.aya, 1500L);
                f.this.axQ = false;
                f.this.axP = f.this.Bo();
                f.this.Bk();
            }

            @Override // com.baidu.tbadk.download.d
            public void onFileDownloadFailed(DownloadData downloadData2, int i, String str2) {
                f.this.axQ = false;
                BdToast.a(f.this.mContext, str2).to().tq();
                f.this.axO.originalProcess = -1;
                f.this.Bp();
            }
        });
        com.baidu.tbadk.download.e.CA().a(downloadData, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Bo() {
        if (this.axO != null && !StringUtils.isNull(this.axO.originalUrl, true) && this.axO.originalSize >= 0 && !this.axO.isBlockedPic) {
            String dV = ao.dV(this.axO.originalUrl);
            File file = new File(k.uj() + al.vm().dN(dV) + "/" + dV);
            if (file != null && file.exists()) {
                this.axO.originalProcess = 100;
                return true;
            }
            if (this.axO.originalProcess < 0) {
                Bp();
            } else {
                this.axt.setText(this.axO.originalProcess + "%");
                this.axt.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_close_yuantu, 0);
            }
            this.axS = true;
        } else {
            this.axt.setVisibility(8);
        }
        return false;
    }

    public void Bp() {
        if (this.axO != null) {
            if (!Bq() || !this.axS) {
                this.axt.setVisibility(8);
            } else {
                this.axt.setVisibility(0);
            }
            if (this.axO.originalSize > 0 && !O(this.axO.originalSize)) {
                this.axt.setText(axq + "(" + am.G(this.axO.originalSize) + ")");
            } else {
                this.axt.setText(axq);
            }
            this.axt.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    private boolean Bq() {
        return (this.axO == null || !this.axO.mIsShowOrigonButton || this.axO.isBlockedPic || StringUtils.isNull(this.axO.originalUrl)) ? false : true;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.ave = bVar;
    }

    private boolean O(long j) {
        return j > axr;
    }
}
