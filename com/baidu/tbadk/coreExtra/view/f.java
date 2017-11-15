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
    private boolean avk;
    private b avm;
    private boolean avn;
    protected com.baidu.tbadk.widget.a axA;
    protected TextView axB;
    protected TextView axC;
    protected TextView axD;
    protected SubsamplingScaleImageView axE;
    private SubsamplingScaleImageView.OnImageEventListener axF;
    private a axG;
    private boolean axH;
    private boolean axI;
    private boolean axJ;
    private boolean axK;
    private boolean axL;
    private Bitmap axM;
    private boolean axN;
    private float axO;
    private Matrix axP;
    private Rect axQ;
    private RectF axR;
    private Rect axS;
    private Rect axT;
    private a.d axU;
    private ImageUrlData axW;
    private boolean axX;
    private boolean axY;
    private boolean axZ;
    public boolean aya;
    private TextView ayb;
    private com.baidu.tbadk.img.b ayc;
    private View.OnTouchListener ayd;
    private boolean aye;
    private float ayf;
    private View.OnLongClickListener ayg;
    private Runnable ayh;
    private Runnable ayi;
    private View.OnTouchListener ayj;
    protected Context mContext;
    private float mLastMotionX;
    private float mLastMotionY;
    private int mMaxHeight;
    private int mMaxWidth;
    private View.OnClickListener mOnClickListener;
    protected ProgressBar mProgressBar;
    private float mRatio;
    private int mSkinType;
    private static final String axy = TbadkCoreApplication.getInst().getString(d.j.original_img_look);
    private static long axz = 52428800;
    private static final int axV = l.ae(TbadkCoreApplication.getInst()) / 5;
    private static final String TAG = f.class.getSimpleName();
    private static final int TOUCH_SLOP = ViewConfiguration.get(TbadkCoreApplication.getInst()).getScaledTouchSlop();

    /* loaded from: classes.dex */
    public interface a {
        void j(String str, byte[] bArr);
    }

    /* loaded from: classes.dex */
    public interface b {
        void BF();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.axB != null) {
                aj.j(this.axB, d.f.btn_percent_yuantu);
                aj.b(this.axB, d.C0080d.cp_cont_g, 1, 0);
            }
            if (this.axC != null) {
                aj.k(this.axC, d.C0080d.common_color_10022);
                aj.b(this.axC, d.C0080d.cp_cont_g, 1, 0);
            }
            this.mSkinType = i;
        }
    }

    public void setHeadImage(boolean z) {
        if (this.axA != null) {
            this.axA.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.axG = aVar;
    }

    public f(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mContext = null;
        this.mProgressBar = null;
        this.axA = null;
        this.axG = null;
        this.avk = false;
        this.axJ = false;
        this.axN = false;
        this.mRatio = 1.0f;
        this.axO = 0.0f;
        this.axP = new Matrix();
        this.axR = new RectF();
        this.axX = false;
        this.axY = false;
        this.axZ = false;
        this.aya = false;
        this.ayb = null;
        this.aye = true;
        this.ayf = 0.0f;
        this.mOnClickListener = null;
        this.ayg = null;
        this.ayh = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.f.1
            @Override // java.lang.Runnable
            public void run() {
                f.this.aye = true;
            }
        };
        this.ayi = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.f.7
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
                        f.this.axB.setVisibility(8);
                        f.this.aya = false;
                    }
                });
                f.this.axB.startAnimation(alphaAnimation);
            }
        };
        this.ayj = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.f.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (f.this.ayd != null) {
                    f.this.ayd.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.ayc = new com.baidu.tbadk.img.b();
        init();
    }

    public com.baidu.tbadk.widget.a getImageView() {
        return this.axA;
    }

    public void setGifSetListener(a.e eVar) {
        this.axA.setGifSetListener(eVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.axA.setImageOnClickListener(onClickListener);
        this.axE.setOnClickListener(onClickListener);
        this.mOnClickListener = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.ayg = onLongClickListener;
        if (!this.avn) {
            this.axA.setImageOnLongClickListener(this.ayg);
            this.axE.setOnLongClickListener(this.ayg);
        }
    }

    public void setOnSizeChangedListener(final a.f fVar) {
        this.axA.setOnSizeChangedListener(new a.f() { // from class: com.baidu.tbadk.coreExtra.view.f.8
            @Override // com.baidu.tbadk.widget.a.f
            public void a(com.baidu.tbadk.widget.a aVar, boolean z, boolean z2) {
                if (fVar != null) {
                    fVar.a(aVar, z, z2);
                }
                f.this.Bt();
            }
        });
    }

    protected void init() {
        this.mMaxWidth = l.ac(this.mContext);
        this.mMaxHeight = l.ae(this.mContext) - ((int) this.mContext.getResources().getDimension(d.e.ds166));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.axA = new com.baidu.tbadk.widget.a(this.mContext);
        this.axA.setLayoutParams(layoutParams);
        this.axA.setOnTouchListener(this.ayj);
        addView(this.axA);
        this.axE = new SubsamplingScaleImageView(this.mContext);
        this.axE.setMaxScale(50.0f);
        this.axE.setOnTouchListener(this.ayj);
        this.axE.setVisibility(4);
        addView(this.axE, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(getResources().getDrawable(d.f.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        Bp();
        Bn();
        Bq();
    }

    private void Bn() {
        this.axB = new TextView(this.mContext);
        aj.j(this.axB, d.f.btn_percent_yuantu);
        this.axB.setText(d.j.original_img_look);
        this.axB.setTextSize(0, getResources().getDimensionPixelSize(d.e.fontsize28));
        aj.b(this.axB, d.C0080d.cp_cont_g, 1, 0);
        this.axB.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds20);
        this.axB.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        this.axB.setMinWidth(getResources().getDimensionPixelSize(d.e.ds220));
        this.axB.setMinHeight(getResources().getDimensionPixelSize(d.e.ds68));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(d.e.fontsize40);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        this.axB.setOnClickListener(this);
        this.axB.setVisibility(8);
        addView(this.axB, layoutParams);
    }

    public void setIsCanDrag(boolean z) {
        this.avn = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        Bitmap imageBitmap;
        int height;
        int width;
        if (!this.avn || !this.axI) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.axK && motionEvent.getPointerCount() >= 2) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.axK || this.axL) {
            requestDisallowInterceptTouchEvent(true);
        }
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        float x = motionEvent.getX();
        int i = action & MotionEventCompat.ACTION_MASK;
        if (i == 0) {
            if (this.axM == null) {
                if (this.axE.getVisibility() == 0) {
                    this.axM = com.baidu.tbadk.util.d.R(this.axE);
                } else {
                    this.axM = com.baidu.tbadk.util.d.R(this.axA);
                }
            }
            if (this.axQ == null && this.axM != null) {
                int measuredWidth = getMeasuredWidth();
                float measuredWidth2 = ((getMeasuredWidth() * 1.0f) / this.axM.getWidth()) * this.axM.getHeight();
                if (measuredWidth2 > getMeasuredHeight()) {
                    measuredWidth2 = getMeasuredHeight();
                }
                RectF e = e(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
                this.axQ = new Rect((int) e.left, (int) e.top, (int) e.right, (int) e.bottom);
            }
            if (this.axT == null && this.axM != null) {
                if (this.axE.getVisibility() == 0) {
                    height = this.axE.getSHeight();
                    width = this.axE.getSWidth();
                } else {
                    if (this.axA.getImageType() == 1) {
                        imageBitmap = (this.axA.getCurrentFrame() == null || this.axA.getCurrentFrame().aNO == null) ? this.axM : this.axA.getCurrentFrame().aNO;
                    } else {
                        imageBitmap = this.axA.getImageBitmap() == null ? this.axM : this.axA.getImageBitmap();
                    }
                    height = imageBitmap.getHeight();
                    width = imageBitmap.getWidth();
                }
                float af = l.af(getContext());
                int i2 = (int) (height * af);
                int i3 = (int) (width * af);
                if (i3 > this.axM.getWidth() && this.axM.getWidth() != 0) {
                    float width2 = (i3 * 1.0f) / this.axM.getWidth();
                    i3 = this.axM.getWidth();
                    i2 = (int) (i2 / width2);
                }
                if (i2 > this.axM.getHeight() && this.axM.getHeight() != 0) {
                    i3 = (int) (i3 / ((i2 * 1.0f) / this.axM.getHeight()));
                    i2 = this.axM.getHeight();
                }
                int ae = (l.ae(getContext()) - i2) / 2;
                int ac = (l.ac(getContext()) - i3) / 2;
                this.axT = new Rect(ac, ae, i3 + ac, i2 + ae);
                this.axS = new Rect(0, 0, this.axM.getWidth(), this.axM.getHeight());
            }
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (i == 2) {
            this.axK = d(this.mLastMotionX - x, this.mLastMotionY - y);
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (this.axK || this.axL) {
            this.axA.setImageOnLongClickListener(null);
            this.axE.setOnLongClickListener(null);
            z = true;
        } else {
            this.axA.setImageOnLongClickListener(this.ayg);
            this.axE.setOnLongClickListener(this.ayg);
            z = super.dispatchTouchEvent(motionEvent);
        }
        if (i == 1 || i == 3) {
            this.mLastMotionX = 0.0f;
            this.mLastMotionY = 0.0f;
            this.axN = false;
            this.axP.reset();
            this.axK = false;
            if (this.axO > axV) {
                this.axL = true;
                Bo();
                return z;
            }
            this.mRatio = 1.0f;
            invalidate();
            return z;
        }
        return z;
    }

    private boolean d(float f, float f2) {
        if (this.axE.getVisibility() != 0 || this.axE.isCanDrag()) {
            if (this.axW == null || !this.axW.isLongPic || this.axE.getVisibility() != 0 || this.axE.isViewTop()) {
                if (this.axW == null || !this.axW.isLongPic || this.axE.getVisibility() == 0 || this.axA.Ht()) {
                    if (this.axE.getVisibility() == 0 || this.axA.Hv()) {
                        if (this.axM != null && getScrollY() == 0 && f2 < 0.0f && !this.axN) {
                            this.axN = true;
                            this.axO = 0.0f;
                            this.mRatio = 1.0f;
                            if (this.axU != null) {
                                this.axU.HM();
                            }
                        }
                        if (this.axN) {
                            this.axO -= f2;
                            int measuredHeight = getMeasuredHeight();
                            if (this.axO > measuredHeight) {
                                this.axO = measuredHeight;
                            }
                            float f3 = f2 / measuredHeight;
                            this.axP.postTranslate((-f) * 1.5f * this.mRatio, (-1.5f) * f2 * this.mRatio);
                            if (this.mRatio * (1.0f + f3) > 1.0f || this.axO < 0.0f) {
                                this.axP.preScale(1.0f / this.mRatio, 1.0f / this.mRatio, (this.mRatio * this.axM.getWidth()) / 2.0f, this.mRatio * (this.axM.getHeight() / 2));
                                this.mRatio = 1.0f;
                            } else {
                                this.axP.preScale(1.0f + f3, 1.0f + f3, (this.mRatio * this.axM.getWidth()) / 2.0f, this.mRatio * (this.axM.getHeight() / 2));
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
        if (this.axK && this.axM != null && !this.axM.isRecycled() && this.axN) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.axR == null) {
                this.axR = new RectF();
            }
            this.axP.mapRect(this.axR, new RectF(this.axQ));
            canvas.drawBitmap(this.axM, this.axS, this.axR, (Paint) null);
        } else if (this.axL && this.axM != null && !this.axM.isRecycled()) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            canvas.drawBitmap(this.axM, this.axT, this.axR, (Paint) null);
        } else {
            super.dispatchDraw(canvas);
        }
    }

    private void Bo() {
        if (this.axW == null) {
            if (this.axU != null) {
                this.axU.HN();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.axW.getSourceImageRectInScreen();
        if (sourceImageRectInScreen == null) {
            if (this.axU != null) {
                this.axU.HN();
                return;
            }
            return;
        }
        this.axR.bottom = (((sourceImageRectInScreen.bottom - sourceImageRectInScreen.top) / (sourceImageRectInScreen.right - sourceImageRectInScreen.left)) * (this.axR.right - this.axR.left)) + this.axR.top;
        final float[] fArr = {(this.axR.left + this.axR.right) / 2.0f, (this.axR.top + this.axR.bottom) / 2.0f};
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
                    f.this.axR = f.this.e(floatValue, animatedFraction, sourceImageRectInScreen.right - sourceImageRectInScreen.left, sourceImageRectInScreen.bottom - sourceImageRectInScreen.top);
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
                f.this.axN = false;
                f.this.invalidate();
                if (f.this.axU != null) {
                    f.this.axU.HN();
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
        this.ayd = onTouchListener;
    }

    private void Bp() {
        this.ayb = new TextView(this.mContext);
        this.ayb.setBackgroundResource(d.f.bg_url_drag_imagview_fade_view);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.height = getResources().getDimensionPixelSize(d.e.ds180);
        layoutParams.addRule(12);
        addView(this.ayb, layoutParams);
        this.ayb.setVisibility(8);
    }

    private void Bq() {
        this.axC = new TextView(this.mContext);
        aj.k(this.axC, d.C0080d.common_color_10022);
        this.axC.setText(d.j.goto_pb_floor);
        this.axC.setTextSize(0, getResources().getDimensionPixelSize(d.e.fontsize24));
        aj.b(this.axC, d.C0080d.cp_cont_g, 1, 0);
        this.axC.setCompoundDrawablePadding(l.dip2px(this.mContext, 4.0f));
        this.axC.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_see_arrow), (Drawable) null);
        this.axC.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds20);
        this.axC.setPadding(dimensionPixelSize * 3, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(d.e.ds30);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(d.e.ds10);
        layoutParams.leftMargin = getResources().getDimensionPixelSize(d.e.ds20);
        layoutParams.addRule(1, this.axB.getId());
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        this.axC.setOnClickListener(this);
        this.axC.setMinHeight(getResources().getDimensionPixelSize(d.e.ds100));
        addView(this.axC, layoutParams);
        this.axC.setVisibility(8);
    }

    private void Br() {
        if (this.axC != null) {
            boolean z = this.axH || this.axI;
            if (!this.axZ && z && this.axW != null && this.axW.threadId > 0 && this.axW.postId > 0 && this.axW.mThreadType != 33 && !this.axW.isBlockedPic) {
                this.axC.setVisibility(0);
                if (this.ayb != null) {
                    this.ayb.setVisibility(0);
                    return;
                }
                return;
            }
            this.axC.setVisibility(8);
            if (this.ayb != null) {
                this.ayb.setVisibility(8);
            }
        }
    }

    private void Bs() {
        if (this.axC != null) {
            this.axC.setVisibility(8);
            if (this.ayb != null) {
                this.ayb.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bt() {
        if ((this.axH || this.axI) && this.axW != null && this.axW.mPicType == 1 && !TextUtils.isEmpty(this.axW.mTagName)) {
            if (this.axD != null) {
                this.axD.setVisibility(8);
                this.axD = null;
            }
            this.axD = new TextView(this.mContext);
            this.axD.setText(this.axW.mTagName);
            this.axD.setTextSize(0, getResources().getDimensionPixelSize(d.e.fontsize26));
            aj.b(this.axD, d.C0080d.common_color_10013, 1, 0);
            aj.k(this.axD, d.C0080d.common_color_10215);
            this.axD.setAlpha(0.75f);
            this.axD.setIncludeFontPadding(false);
            this.axD.setGravity(17);
            int f = l.f(this.mContext, d.e.ds2);
            this.axD.setPadding(f, f, f, f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.axA.getBottomOffset();
            layoutParams.leftMargin = this.axA.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.axD, layoutParams);
            this.axD.setVisibility(0);
        }
    }

    public void bk(boolean z) {
        this.axZ = z;
        if (this.axZ) {
            Bs();
        } else {
            Br();
        }
    }

    public void n(String str, boolean z) {
        if (str.contains("*")) {
            str = str.split("[*]")[0];
        }
        this.axA.setTag(str);
        this.axA.setLoadBigImage(false);
        this.axA.setImageDrawable(null);
        this.axH = false;
        this.axI = false;
        this.axX = BA();
        this.axB.setVisibility(8);
        if (fj(str)) {
            d(str, z, false);
        }
    }

    private boolean Bu() {
        return this.axA != null && this.axA.HK();
    }

    public void Bv() {
        if (this.axW != null && !Bu()) {
            String str = this.axW.imageUrl;
            int i = this.axW.urlType;
            com.baidu.adp.widget.a.a aVar = null;
            if (com.baidu.tbadk.core.util.c.a.v(str, i)) {
                aVar = com.baidu.tbadk.core.util.c.a.w(str, i);
            }
            if (aVar != null) {
                setThumbBitmapToView(aVar);
            }
        }
    }

    private boolean bm(boolean z) {
        String dV;
        if (!this.axY || z) {
            this.axY = true;
            if (!this.axX || this.axW == null || StringUtils.isNull(this.axW.originalUrl, true) || this.axW.originalSize < 0 || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String str = k.uj() + al.vm().dN(dV) + "/" + ao.dV(this.axW.originalUrl);
            final int[] ds = k.ds(str);
            this.axE.setVisibility(0);
            if (this.axF == null) {
                this.axF = new SubsamplingScaleImageView.OnImageEventListener() { // from class: com.baidu.tbadk.coreExtra.view.f.12
                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onReady() {
                        f.this.mProgressBar.setVisibility(8);
                        f.this.axA.HG();
                        f.this.axA.setVisibility(4);
                    }

                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onImageLoaded() {
                        if (f.this.axW.isLongPic && ds[0] > 0) {
                            f.this.axA.onDestroy();
                            final float measuredWidth = (f.this.getMeasuredWidth() * 1.0f) / ds[0];
                            final PointF pointF = new PointF((ds[0] * 1.0f) / 2.0f, 0.0f);
                            f.this.axE.setScaleAndCenter(measuredWidth, pointF);
                            f.this.axE.setMaxScale(2.0f * measuredWidth);
                            f.this.axE.setDoubleTapZoomScale(2.0f * measuredWidth);
                            f.this.axE.setInitScale(measuredWidth);
                            f.this.axE.setDoubleTapZoomStyle(4);
                            f.this.axE.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.f.12.1
                                @Override // android.view.View.OnTouchListener
                                public boolean onTouch(View view, MotionEvent motionEvent) {
                                    if (f.this.ayd != null) {
                                        f.this.ayd.onTouch(view, motionEvent);
                                    }
                                    switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                                        case 0:
                                            f.this.ayf = motionEvent.getY();
                                            f.this.axE.setOnClickListener(f.this.aye ? f.this.mOnClickListener : null);
                                            f.this.axE.setOnLongClickListener(f.this.aye ? f.this.ayg : null);
                                            break;
                                        case 1:
                                        case 3:
                                            if (f.this.axE.getScale() < measuredWidth) {
                                                f.this.axE.setScaleAndCenter(measuredWidth, pointF);
                                            }
                                            com.baidu.adp.lib.g.e.fP().removeCallbacks(f.this.ayh);
                                            com.baidu.adp.lib.g.e.fP().postDelayed(f.this.ayh, 1000L);
                                            break;
                                        case 2:
                                            if (Math.abs(motionEvent.getY() - f.this.ayf) > f.TOUCH_SLOP) {
                                                f.this.aye = false;
                                                f.this.axE.setOnClickListener(null);
                                                f.this.axE.setOnLongClickListener(null);
                                            }
                                            f.this.ayf = motionEvent.getY();
                                            break;
                                    }
                                    return false;
                                }
                            });
                            f.this.axA.setVisibility(4);
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
            this.axE.setOnImageEventListener(this.axF);
            if (this.axE.isImageLoaded() && this.axW.isLongPic) {
                this.axF.onImageLoaded();
            } else {
                this.axE.setImage(ImageSource.uri(str));
            }
            return true;
        }
        return false;
    }

    public void setDragToExitListener(a.d dVar) {
        this.axU = dVar;
        if (this.axA != null) {
            this.axA.setDragToExitListener(dVar);
        }
    }

    public void Bw() {
        bm(false);
    }

    private boolean fj(String str) {
        return j.hh() || com.baidu.tbadk.core.util.c.c.ej(str);
    }

    private void setThumbBitmapToView(com.baidu.adp.widget.a.a aVar) {
        Bitmap kK;
        if (!this.axI && aVar != null && (kK = aVar.kK()) != null) {
            this.axH = true;
            if (aVar.isGif()) {
                this.axA.setImageUrlData(this.axW);
                this.axA.setImageBitmap(kK);
                this.axB.setVisibility(8);
                this.aya = false;
            } else {
                if (this.axW != null && this.axW.isLongPic) {
                    this.axA.Hy();
                    this.axA.setImageLoadCallBack(new com.baidu.tbadk.widget.a.b.a() { // from class: com.baidu.tbadk.coreExtra.view.f.13
                        @Override // com.baidu.tbadk.widget.a.b.a
                        public void BE() {
                        }
                    });
                }
                this.axA.setImageUrlData(this.axW);
                this.axA.a(kK, aVar.kP());
            }
            Br();
            Bt();
        }
    }

    private void d(String str, boolean z, boolean z2) {
        if (fk(str)) {
            if (z2 || (!this.axJ && !this.axI)) {
                if (!z2 || !bm(true)) {
                    this.axJ = true;
                    com.baidu.adp.lib.f.c.fJ().a(str, 27, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.coreExtra.view.f.14
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onCancelled(String str2) {
                            f.this.axJ = false;
                            f.this.axA.setVisibility(0);
                            f.this.mProgressBar.setVisibility(8);
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onLoaded(com.baidu.adp.widget.a.a aVar, String str2, int i) {
                            f.this.axJ = false;
                            f.this.axI = true;
                            f.this.b(aVar);
                        }
                    }, 0, 0, false, null, Boolean.valueOf(z), this.axA.getImageData(), Boolean.valueOf(this.avk));
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
        com.baidu.adp.widget.a.a a2 = this.ayc.a(imageFileInfo, false);
        if (a2 != null) {
            this.axI = true;
            this.mProgressBar.setVisibility(8);
            b(a2);
            return;
        }
        this.ayc.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.coreExtra.view.f.2
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.a.a aVar, String str2, boolean z3) {
                f.this.axI = true;
                f.this.mProgressBar.setVisibility(8);
                f.this.b(aVar);
            }
        }, false);
    }

    private boolean fk(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith("https://"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null && this.axG != null) {
            this.axG.j(aVar.getUrl(), aVar.kP());
        }
        if (aVar == null || aVar.kK() == null) {
            Bx();
            return;
        }
        Bitmap kK = aVar.kK();
        this.axA.setLoadBigImage(true);
        if (aVar.isGif()) {
            this.axA.a(aVar.kP(), kK);
            this.axA.invalidate();
            this.axA.play();
            this.aya = false;
            this.axB.setVisibility(8);
            this.mProgressBar.setVisibility(8);
        } else {
            if (this.axW != null && this.axW.isLongPic) {
                this.axA.Hy();
                this.axA.setImageLoadCallBack(new com.baidu.tbadk.widget.a.b.a() { // from class: com.baidu.tbadk.coreExtra.view.f.3
                    @Override // com.baidu.tbadk.widget.a.b.a
                    public void BE() {
                        f.this.mProgressBar.setVisibility(8);
                    }
                });
            } else {
                this.mProgressBar.setVisibility(8);
            }
            this.axA.setImageUrlData(this.axW);
            this.axA.a(kK, aVar.kP());
            BB();
        }
        Br();
        Bt();
    }

    private void Bx() {
        if (!this.axH) {
            this.axA.HD();
        } else {
            this.axI = false;
        }
        this.axB.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    public void setGifMaxUseableMem(int i) {
        this.axA.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.axA != null) {
            this.axA.onDestroy();
        }
        if (this.axE != null) {
            this.axE.recycle();
        }
        if (this.axM != null) {
            this.axM.recycle();
            this.axM = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.ayh);
    }

    public void release() {
        if (this.axA != null) {
            this.axA.release();
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.axB != null) {
            this.axB.setVisibility(8);
        }
    }

    public void By() {
        if (this.axA != null && this.axA.getImageType() == 1) {
            this.axA.stop();
        }
    }

    public void j(boolean z, boolean z2) {
        String str;
        if (this.axA != null && (str = (String) this.axA.getTag()) != null) {
            if (this.axA.getImageType() == 1) {
                if (this.axA.getGifCache() == null || !this.axA.HK()) {
                    d(str, z, z2);
                }
            } else if (this.axA.getImageType() == 2) {
                d(str, z, z2);
            } else if (Bz()) {
                d(str, z, z2);
            }
        }
    }

    private boolean Bz() {
        if (this.axA.getImageBitmap() != null && this.axA.HK()) {
            if (this.axW == null || !this.axW.isLongPic || this.axA.Hz()) {
                return false;
            }
            this.axI = false;
            this.axY = false;
            return true;
        }
        return true;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.axW = imageUrlData;
    }

    public void setIsCdn(boolean z) {
        this.avk = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.axB) {
            if (!(this.axB.getTag() instanceof Boolean) || ((Boolean) this.axB.getTag()).booleanValue()) {
                final String dV = ao.dV(this.axW.originalUrl);
                if (this.axW.originalProcess >= 0) {
                    com.baidu.tbadk.download.e.CM().z(dV, 13);
                    this.axW.originalProcess = -1;
                    BB();
                    return;
                }
                if (this.avm != null) {
                    this.avm.BF();
                }
                com.baidu.adp.base.e<?> Y = i.Y(this.mContext);
                if (Y == null) {
                    fl(dV);
                } else if (!j.hh() || j.hi() || com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("original_img_down_tip", false)) {
                    fl(dV);
                } else {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("original_img_down_tip", true);
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(Y.getPageActivity());
                    aVar.cc(d.j.original_img_down_no_wifi_tip);
                    aVar.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.f.4
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar.dismiss();
                            f.this.fl(dV);
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
        } else if (view == this.axC && this.axW != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mContext).createHistoryCfg(String.valueOf(this.axW.threadId), String.valueOf(this.axW.postId), this.axW.mIsSeeHost, this.axW.mIsReserver, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fl(String str) {
        if (this.axW != null) {
            this.axW.originalProcess = 0;
        }
        this.axB.setText("0%");
        this.axB.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_close_yuantu, 0);
        DownloadData downloadData = new DownloadData(str);
        downloadData.setStatus(1);
        downloadData.setUrl(this.axW.originalUrl);
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
                    if (f.this.axW != null && f.this.axW.originalProcess != -1) {
                        f.this.axW.originalProcess = downloadData2.getProcess();
                    }
                    if (f.this.axW == null || f.this.axW.originalProcess != -1) {
                        f.this.axB.setText(downloadData2.getProcess() + "%");
                        f.this.axB.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_close_yuantu, 0);
                    }
                }
            }

            @Override // com.baidu.tbadk.download.d
            public boolean onFileDownloaded(DownloadData downloadData2) {
                return true;
            }

            @Override // com.baidu.tbadk.download.d
            public void onFileDownloadSucceed(DownloadData downloadData2) {
                f.this.axB.setText(f.this.getResources().getString(d.j.done));
                f.this.axB.setTag(false);
                f.this.axB.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                com.baidu.adp.lib.g.e.fP().postDelayed(f.this.ayi, 1500L);
                f.this.axY = false;
                f.this.axX = f.this.BA();
                f.this.Bw();
            }

            @Override // com.baidu.tbadk.download.d
            public void onFileDownloadFailed(DownloadData downloadData2, int i, String str2) {
                f.this.axY = false;
                BdToast.a(f.this.mContext, str2).to().tq();
                f.this.axW.originalProcess = -1;
                f.this.BB();
            }
        });
        com.baidu.tbadk.download.e.CM().a(downloadData, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean BA() {
        if (this.axW != null && !StringUtils.isNull(this.axW.originalUrl, true) && this.axW.originalSize >= 0 && !this.axW.isBlockedPic) {
            String dV = ao.dV(this.axW.originalUrl);
            File file = new File(k.uj() + al.vm().dN(dV) + "/" + dV);
            if (file != null && file.exists()) {
                this.axW.originalProcess = 100;
                return true;
            }
            if (this.axW.originalProcess < 0) {
                BB();
            } else {
                this.axB.setText(this.axW.originalProcess + "%");
                this.axB.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_close_yuantu, 0);
            }
            this.aya = true;
        } else {
            this.axB.setVisibility(8);
        }
        return false;
    }

    public void BB() {
        if (this.axW != null) {
            if (!BC() || !this.aya) {
                this.axB.setVisibility(8);
            } else {
                this.axB.setVisibility(0);
            }
            if (this.axW.originalSize > 0 && !O(this.axW.originalSize)) {
                this.axB.setText(axy + "(" + am.G(this.axW.originalSize) + ")");
            } else {
                this.axB.setText(axy);
            }
            this.axB.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    private boolean BC() {
        return (this.axW == null || !this.axW.mIsShowOrigonButton || this.axW.isBlockedPic || StringUtils.isNull(this.axW.originalUrl)) ? false : true;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.avm = bVar;
    }

    private boolean O(long j) {
        return j > axz;
    }
}
