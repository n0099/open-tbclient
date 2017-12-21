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
    private boolean avT;
    private b avV;
    private boolean avW;
    private RectF ayA;
    private Rect ayB;
    private Rect ayC;
    private a.d ayD;
    private ImageUrlData ayF;
    private boolean ayG;
    private boolean ayH;
    private boolean ayI;
    public boolean ayJ;
    private TextView ayK;
    private com.baidu.tbadk.img.b ayL;
    private View.OnTouchListener ayM;
    private boolean ayN;
    private float ayO;
    private View.OnLongClickListener ayP;
    private Runnable ayQ;
    private Runnable ayR;
    private View.OnTouchListener ayS;
    protected com.baidu.tbadk.widget.a ayj;
    protected TextView ayk;
    protected TextView ayl;
    protected TextView aym;
    protected SubsamplingScaleImageView ayn;
    private SubsamplingScaleImageView.OnImageEventListener ayo;
    private a ayp;
    private boolean ayq;
    private boolean ayr;
    private boolean ays;
    private boolean ayt;
    private boolean ayu;
    private Bitmap ayv;
    private boolean ayw;
    private float ayx;
    private Matrix ayy;
    private Rect ayz;
    protected Context mContext;
    private float mLastMotionX;
    private float mLastMotionY;
    private int mMaxHeight;
    private int mMaxWidth;
    private View.OnClickListener mOnClickListener;
    protected ProgressBar mProgressBar;
    private float mRatio;
    private int mSkinType;
    private static final String ayh = TbadkCoreApplication.getInst().getString(d.j.original_img_look);
    private static long ayi = 52428800;
    private static final int ayE = l.ae(TbadkCoreApplication.getInst()) / 5;
    private static final String TAG = f.class.getSimpleName();
    private static final int TOUCH_SLOP = ViewConfiguration.get(TbadkCoreApplication.getInst()).getScaledTouchSlop();

    /* loaded from: classes.dex */
    public interface a {
        void j(String str, byte[] bArr);
    }

    /* loaded from: classes.dex */
    public interface b {
        void BQ();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.ayk != null) {
                aj.j(this.ayk, d.f.btn_percent_yuantu);
                aj.b(this.ayk, d.C0095d.cp_cont_g, 1, 0);
            }
            if (this.ayl != null) {
                aj.k(this.ayl, d.C0095d.common_color_10022);
                aj.b(this.ayl, d.C0095d.cp_cont_g, 1, 0);
            }
            this.mSkinType = i;
        }
    }

    public void setHeadImage(boolean z) {
        if (this.ayj != null) {
            this.ayj.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.ayp = aVar;
    }

    public f(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mContext = null;
        this.mProgressBar = null;
        this.ayj = null;
        this.ayp = null;
        this.avT = false;
        this.ays = false;
        this.ayw = false;
        this.mRatio = 1.0f;
        this.ayx = 0.0f;
        this.ayy = new Matrix();
        this.ayA = new RectF();
        this.ayG = false;
        this.ayH = false;
        this.ayI = false;
        this.ayJ = false;
        this.ayK = null;
        this.ayN = true;
        this.ayO = 0.0f;
        this.mOnClickListener = null;
        this.ayP = null;
        this.ayQ = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.f.1
            @Override // java.lang.Runnable
            public void run() {
                f.this.ayN = true;
            }
        };
        this.ayR = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.f.7
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
                        f.this.ayk.setVisibility(8);
                        f.this.ayJ = false;
                    }
                });
                f.this.ayk.startAnimation(alphaAnimation);
            }
        };
        this.ayS = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.f.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (f.this.ayM != null) {
                    f.this.ayM.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.ayL = new com.baidu.tbadk.img.b();
        init();
    }

    public com.baidu.tbadk.widget.a getImageView() {
        return this.ayj;
    }

    public void setGifSetListener(a.e eVar) {
        this.ayj.setGifSetListener(eVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.ayj.setImageOnClickListener(onClickListener);
        this.ayn.setOnClickListener(onClickListener);
        this.mOnClickListener = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.ayP = onLongClickListener;
        if (!this.avW) {
            this.ayj.setImageOnLongClickListener(this.ayP);
            this.ayn.setOnLongClickListener(this.ayP);
        }
    }

    public void setOnSizeChangedListener(final a.f fVar) {
        this.ayj.setOnSizeChangedListener(new a.f() { // from class: com.baidu.tbadk.coreExtra.view.f.8
            @Override // com.baidu.tbadk.widget.a.f
            public void a(com.baidu.tbadk.widget.a aVar, boolean z, boolean z2) {
                if (fVar != null) {
                    fVar.a(aVar, z, z2);
                }
                f.this.BE();
            }
        });
    }

    protected void init() {
        this.mMaxWidth = l.ac(this.mContext);
        this.mMaxHeight = l.ae(this.mContext) - ((int) this.mContext.getResources().getDimension(d.e.ds166));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.ayj = new com.baidu.tbadk.widget.a(this.mContext);
        this.ayj.setLayoutParams(layoutParams);
        this.ayj.setOnTouchListener(this.ayS);
        addView(this.ayj);
        this.ayn = new SubsamplingScaleImageView(this.mContext);
        this.ayn.setMaxScale(50.0f);
        this.ayn.setOnTouchListener(this.ayS);
        this.ayn.setVisibility(4);
        addView(this.ayn, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(getResources().getDrawable(d.f.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        BA();
        By();
        BB();
    }

    private void By() {
        this.ayk = new TextView(this.mContext);
        aj.j(this.ayk, d.f.btn_percent_yuantu);
        this.ayk.setText(d.j.original_img_look);
        this.ayk.setTextSize(0, getResources().getDimensionPixelSize(d.e.fontsize28));
        aj.b(this.ayk, d.C0095d.cp_cont_g, 1, 0);
        this.ayk.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds20);
        this.ayk.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        this.ayk.setMinWidth(getResources().getDimensionPixelSize(d.e.ds220));
        this.ayk.setMinHeight(getResources().getDimensionPixelSize(d.e.ds68));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(d.e.fontsize40);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        this.ayk.setOnClickListener(this);
        this.ayk.setVisibility(8);
        addView(this.ayk, layoutParams);
    }

    public void setIsCanDrag(boolean z) {
        this.avW = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        Bitmap imageBitmap;
        int height;
        int width;
        if (!this.avW || !this.ayr) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.ayt && motionEvent.getPointerCount() >= 2) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.ayt || this.ayu) {
            requestDisallowInterceptTouchEvent(true);
        }
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        float x = motionEvent.getX();
        int i = action & MotionEventCompat.ACTION_MASK;
        if (i == 0) {
            if (this.ayv == null) {
                if (this.ayn.getVisibility() == 0) {
                    this.ayv = com.baidu.tbadk.util.d.S(this.ayn);
                } else {
                    this.ayv = com.baidu.tbadk.util.d.S(this.ayj);
                }
            }
            if (this.ayz == null && this.ayv != null) {
                int measuredWidth = getMeasuredWidth();
                float measuredWidth2 = ((getMeasuredWidth() * 1.0f) / this.ayv.getWidth()) * this.ayv.getHeight();
                if (measuredWidth2 > getMeasuredHeight()) {
                    measuredWidth2 = getMeasuredHeight();
                }
                RectF e = e(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
                this.ayz = new Rect((int) e.left, (int) e.top, (int) e.right, (int) e.bottom);
            }
            if (this.ayC == null && this.ayv != null) {
                if (this.ayn.getVisibility() == 0) {
                    height = this.ayn.getSHeight();
                    width = this.ayn.getSWidth();
                } else {
                    if (this.ayj.getImageType() == 1) {
                        imageBitmap = (this.ayj.getCurrentFrame() == null || this.ayj.getCurrentFrame().aOv == null) ? this.ayv : this.ayj.getCurrentFrame().aOv;
                    } else {
                        imageBitmap = this.ayj.getImageBitmap() == null ? this.ayv : this.ayj.getImageBitmap();
                    }
                    height = imageBitmap.getHeight();
                    width = imageBitmap.getWidth();
                }
                float af = l.af(getContext());
                int i2 = (int) (height * af);
                int i3 = (int) (width * af);
                if (i3 > this.ayv.getWidth() && this.ayv.getWidth() != 0) {
                    float width2 = (i3 * 1.0f) / this.ayv.getWidth();
                    i3 = this.ayv.getWidth();
                    i2 = (int) (i2 / width2);
                }
                if (i2 > this.ayv.getHeight() && this.ayv.getHeight() != 0) {
                    i3 = (int) (i3 / ((i2 * 1.0f) / this.ayv.getHeight()));
                    i2 = this.ayv.getHeight();
                }
                int ae = (l.ae(getContext()) - i2) / 2;
                int ac = (l.ac(getContext()) - i3) / 2;
                this.ayC = new Rect(ac, ae, i3 + ac, i2 + ae);
                this.ayB = new Rect(0, 0, this.ayv.getWidth(), this.ayv.getHeight());
            }
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (i == 2) {
            this.ayt = d(this.mLastMotionX - x, this.mLastMotionY - y);
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (this.ayt || this.ayu) {
            this.ayj.setImageOnLongClickListener(null);
            this.ayn.setOnLongClickListener(null);
            z = true;
        } else {
            this.ayj.setImageOnLongClickListener(this.ayP);
            this.ayn.setOnLongClickListener(this.ayP);
            z = super.dispatchTouchEvent(motionEvent);
        }
        if (i == 1 || i == 3) {
            this.mLastMotionX = 0.0f;
            this.mLastMotionY = 0.0f;
            this.ayw = false;
            this.ayy.reset();
            this.ayt = false;
            if (this.ayx > ayE) {
                this.ayu = true;
                Bz();
                return z;
            }
            this.mRatio = 1.0f;
            invalidate();
            return z;
        }
        return z;
    }

    private boolean d(float f, float f2) {
        if (this.ayn.getVisibility() != 0 || this.ayn.isCanDrag()) {
            if (this.ayF == null || !this.ayF.isLongPic || this.ayn.getVisibility() != 0 || this.ayn.isViewTop()) {
                if (this.ayF == null || !this.ayF.isLongPic || this.ayn.getVisibility() == 0 || this.ayj.HB()) {
                    if (this.ayn.getVisibility() == 0 || this.ayj.HD()) {
                        if (this.ayv != null && getScrollY() == 0 && f2 < 0.0f && !this.ayw) {
                            this.ayw = true;
                            this.ayx = 0.0f;
                            this.mRatio = 1.0f;
                            if (this.ayD != null) {
                                this.ayD.HU();
                            }
                        }
                        if (this.ayw) {
                            this.ayx -= f2;
                            int measuredHeight = getMeasuredHeight();
                            if (this.ayx > measuredHeight) {
                                this.ayx = measuredHeight;
                            }
                            float f3 = f2 / measuredHeight;
                            this.ayy.postTranslate((-f) * 1.5f * this.mRatio, (-1.5f) * f2 * this.mRatio);
                            if (this.mRatio * (1.0f + f3) > 1.0f || this.ayx < 0.0f) {
                                this.ayy.preScale(1.0f / this.mRatio, 1.0f / this.mRatio, (this.mRatio * this.ayv.getWidth()) / 2.0f, this.mRatio * (this.ayv.getHeight() / 2));
                                this.mRatio = 1.0f;
                            } else {
                                this.ayy.preScale(1.0f + f3, 1.0f + f3, (this.mRatio * this.ayv.getWidth()) / 2.0f, this.mRatio * (this.ayv.getHeight() / 2));
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
        if (this.ayt && this.ayv != null && !this.ayv.isRecycled() && this.ayw) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.ayA == null) {
                this.ayA = new RectF();
            }
            this.ayy.mapRect(this.ayA, new RectF(this.ayz));
            canvas.drawBitmap(this.ayv, this.ayB, this.ayA, (Paint) null);
        } else if (this.ayu && this.ayv != null && !this.ayv.isRecycled()) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.ayF == null || this.ayF.getSourceImageRectInScreen() == null) {
                canvas.drawBitmap(this.ayv, this.ayB, this.ayA, (Paint) null);
            } else {
                canvas.drawBitmap(this.ayv, this.ayC, this.ayA, (Paint) null);
            }
        } else {
            super.dispatchDraw(canvas);
        }
    }

    private void Bz() {
        if (this.ayF == null) {
            if (this.ayD != null) {
                this.ayD.HV();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.ayF.getSourceImageRectInScreen();
        if (sourceImageRectInScreen == null) {
            if (this.ayD != null) {
                this.ayD.HV();
                return;
            }
            return;
        }
        this.ayA.bottom = (((sourceImageRectInScreen.bottom - sourceImageRectInScreen.top) / (sourceImageRectInScreen.right - sourceImageRectInScreen.left)) * (this.ayA.right - this.ayA.left)) + this.ayA.top;
        final float[] fArr = {(this.ayA.left + this.ayA.right) / 2.0f, (this.ayA.top + this.ayA.bottom) / 2.0f};
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
                    f.this.ayA = f.this.e(floatValue, animatedFraction, sourceImageRectInScreen.right - sourceImageRectInScreen.left, sourceImageRectInScreen.bottom - sourceImageRectInScreen.top);
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
                f.this.ayw = false;
                f.this.invalidate();
                if (f.this.ayD != null) {
                    f.this.ayD.HV();
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
        this.ayM = onTouchListener;
    }

    private void BA() {
        this.ayK = new TextView(this.mContext);
        this.ayK.setBackgroundResource(d.f.bg_url_drag_imagview_fade_view);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.height = getResources().getDimensionPixelSize(d.e.ds180);
        layoutParams.addRule(12);
        addView(this.ayK, layoutParams);
        this.ayK.setVisibility(8);
    }

    private void BB() {
        this.ayl = new TextView(this.mContext);
        aj.k(this.ayl, d.C0095d.common_color_10022);
        this.ayl.setText(d.j.goto_pb_floor);
        this.ayl.setTextSize(0, getResources().getDimensionPixelSize(d.e.fontsize24));
        aj.b(this.ayl, d.C0095d.cp_cont_g, 1, 0);
        this.ayl.setCompoundDrawablePadding(l.dip2px(this.mContext, 4.0f));
        this.ayl.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_see_arrow), (Drawable) null);
        this.ayl.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds20);
        this.ayl.setPadding(dimensionPixelSize * 3, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(d.e.ds30);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(d.e.ds10);
        layoutParams.leftMargin = getResources().getDimensionPixelSize(d.e.ds20);
        layoutParams.addRule(1, this.ayk.getId());
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        this.ayl.setOnClickListener(this);
        this.ayl.setMinHeight(getResources().getDimensionPixelSize(d.e.ds100));
        addView(this.ayl, layoutParams);
        this.ayl.setVisibility(8);
    }

    private void BC() {
        if (this.ayl != null) {
            boolean z = this.ayq || this.ayr;
            if (!this.ayI && z && this.ayF != null && this.ayF.threadId > 0 && this.ayF.postId > 0 && this.ayF.mThreadType != 33 && !this.ayF.isBlockedPic) {
                this.ayl.setVisibility(0);
                if (this.ayK != null) {
                    this.ayK.setVisibility(0);
                    return;
                }
                return;
            }
            this.ayl.setVisibility(8);
            if (this.ayK != null) {
                this.ayK.setVisibility(8);
            }
        }
    }

    private void BD() {
        if (this.ayl != null) {
            this.ayl.setVisibility(8);
            if (this.ayK != null) {
                this.ayK.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BE() {
        if ((this.ayq || this.ayr) && this.ayF != null && this.ayF.mPicType == 1 && !TextUtils.isEmpty(this.ayF.mTagName)) {
            if (this.aym != null) {
                this.aym.setVisibility(8);
                this.aym = null;
            }
            this.aym = new TextView(this.mContext);
            this.aym.setText(this.ayF.mTagName);
            this.aym.setTextSize(0, getResources().getDimensionPixelSize(d.e.fontsize26));
            aj.b(this.aym, d.C0095d.common_color_10013, 1, 0);
            aj.k(this.aym, d.C0095d.common_color_10215);
            this.aym.setAlpha(0.75f);
            this.aym.setIncludeFontPadding(false);
            this.aym.setGravity(17);
            int f = l.f(this.mContext, d.e.ds2);
            this.aym.setPadding(f, f, f, f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.ayj.getBottomOffset();
            layoutParams.leftMargin = this.ayj.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.aym, layoutParams);
            this.aym.setVisibility(0);
        }
    }

    public void bl(boolean z) {
        this.ayI = z;
        if (this.ayI) {
            BD();
        } else {
            BC();
        }
    }

    public void o(String str, boolean z) {
        if (str.contains("*")) {
            str = str.split("[*]")[0];
        }
        this.ayj.setTag(str);
        this.ayj.setLoadBigImage(false);
        this.ayj.setImageDrawable(null);
        this.ayq = false;
        this.ayr = false;
        this.ayG = BL();
        this.ayk.setVisibility(8);
        if (fo(str)) {
            d(str, z, false);
        }
    }

    private boolean BF() {
        return this.ayj != null && this.ayj.HS();
    }

    public void BG() {
        if (this.ayF != null && !BF()) {
            String str = this.ayF.imageUrl;
            int i = this.ayF.urlType;
            com.baidu.adp.widget.a.a aVar = null;
            if (com.baidu.tbadk.core.util.c.a.v(str, i)) {
                aVar = com.baidu.tbadk.core.util.c.a.w(str, i);
            }
            if (aVar != null) {
                setThumbBitmapToView(aVar);
            }
        }
    }

    private boolean bn(boolean z) {
        String dX;
        if (!this.ayH || z) {
            this.ayH = true;
            if (!this.ayG || this.ayF == null || StringUtils.isNull(this.ayF.originalUrl, true) || this.ayF.originalSize < 0 || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String str = k.uj() + al.vm().dP(dX) + "/" + ao.dX(this.ayF.originalUrl);
            final int[] ds = k.ds(str);
            this.ayn.setVisibility(0);
            if (this.ayo == null) {
                this.ayo = new SubsamplingScaleImageView.OnImageEventListener() { // from class: com.baidu.tbadk.coreExtra.view.f.12
                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onReady() {
                        f.this.mProgressBar.setVisibility(8);
                        f.this.ayj.HO();
                        f.this.ayj.setVisibility(4);
                    }

                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onImageLoaded() {
                        if (f.this.ayF.isLongPic && ds[0] > 0) {
                            f.this.ayj.onDestroy();
                            final float measuredWidth = (f.this.getMeasuredWidth() * 1.0f) / ds[0];
                            final PointF pointF = new PointF((ds[0] * 1.0f) / 2.0f, 0.0f);
                            f.this.ayn.setScaleAndCenter(measuredWidth, pointF);
                            f.this.ayn.setMaxScale(2.0f * measuredWidth);
                            f.this.ayn.setDoubleTapZoomScale(2.0f * measuredWidth);
                            f.this.ayn.setInitScale(measuredWidth);
                            f.this.ayn.setDoubleTapZoomStyle(4);
                            f.this.ayn.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.f.12.1
                                @Override // android.view.View.OnTouchListener
                                public boolean onTouch(View view, MotionEvent motionEvent) {
                                    if (f.this.ayM != null) {
                                        f.this.ayM.onTouch(view, motionEvent);
                                    }
                                    switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                                        case 0:
                                            f.this.ayO = motionEvent.getY();
                                            f.this.ayn.setOnClickListener(f.this.ayN ? f.this.mOnClickListener : null);
                                            f.this.ayn.setOnLongClickListener(f.this.ayN ? f.this.ayP : null);
                                            break;
                                        case 1:
                                        case 3:
                                            if (f.this.ayn.getScale() < measuredWidth) {
                                                f.this.ayn.setScaleAndCenter(measuredWidth, pointF);
                                            }
                                            com.baidu.adp.lib.g.e.fP().removeCallbacks(f.this.ayQ);
                                            com.baidu.adp.lib.g.e.fP().postDelayed(f.this.ayQ, 1000L);
                                            break;
                                        case 2:
                                            if (Math.abs(motionEvent.getY() - f.this.ayO) > f.TOUCH_SLOP) {
                                                f.this.ayN = false;
                                                f.this.ayn.setOnClickListener(null);
                                                f.this.ayn.setOnLongClickListener(null);
                                            }
                                            f.this.ayO = motionEvent.getY();
                                            break;
                                    }
                                    return false;
                                }
                            });
                            f.this.ayj.setVisibility(4);
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
            this.ayn.setOnImageEventListener(this.ayo);
            if (this.ayn.isImageLoaded() && this.ayF.isLongPic) {
                this.ayo.onImageLoaded();
            } else {
                this.ayn.setImage(ImageSource.uri(str));
            }
            return true;
        }
        return false;
    }

    public void setDragToExitListener(a.d dVar) {
        this.ayD = dVar;
        if (this.ayj != null) {
            this.ayj.setDragToExitListener(dVar);
        }
    }

    public void BH() {
        bn(false);
    }

    private boolean fo(String str) {
        return j.hh() || com.baidu.tbadk.core.util.c.c.el(str);
    }

    private void setThumbBitmapToView(com.baidu.adp.widget.a.a aVar) {
        Bitmap kK;
        if (!this.ayr && aVar != null && (kK = aVar.kK()) != null) {
            this.ayq = true;
            if (aVar.isGif()) {
                this.ayj.setImageUrlData(this.ayF);
                this.ayj.setImageBitmap(kK);
                this.ayk.setVisibility(8);
                this.ayJ = false;
            } else {
                if (this.ayF != null && this.ayF.isLongPic) {
                    this.ayj.HG();
                    this.ayj.setImageLoadCallBack(new com.baidu.tbadk.widget.a.b.a() { // from class: com.baidu.tbadk.coreExtra.view.f.13
                        @Override // com.baidu.tbadk.widget.a.b.a
                        public void BP() {
                        }
                    });
                }
                this.ayj.setImageUrlData(this.ayF);
                this.ayj.a(kK, aVar.kP());
            }
            BC();
            BE();
        }
    }

    private void d(String str, boolean z, boolean z2) {
        if (fp(str)) {
            if (z2 || (!this.ays && !this.ayr)) {
                if (!z2 || !bn(true)) {
                    this.ays = true;
                    com.baidu.adp.lib.f.c.fJ().a(str, 27, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.coreExtra.view.f.14
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onCancelled(String str2) {
                            f.this.ays = false;
                            f.this.ayj.setVisibility(0);
                            f.this.mProgressBar.setVisibility(8);
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onLoaded(com.baidu.adp.widget.a.a aVar, String str2, int i) {
                            f.this.ays = false;
                            f.this.ayr = true;
                            f.this.b(aVar);
                        }
                    }, 0, 0, false, null, Boolean.valueOf(z), this.ayj.getImageData(), Boolean.valueOf(this.avT));
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
        imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.J(this.mMaxWidth, this.mMaxHeight));
        com.baidu.adp.widget.a.a a2 = this.ayL.a(imageFileInfo, false);
        if (a2 != null) {
            this.ayr = true;
            this.mProgressBar.setVisibility(8);
            b(a2);
            return;
        }
        this.ayL.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.coreExtra.view.f.2
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.a.a aVar, String str2, boolean z3) {
                f.this.ayr = true;
                f.this.mProgressBar.setVisibility(8);
                f.this.b(aVar);
            }
        }, false);
    }

    private boolean fp(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith("https://"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null && this.ayp != null) {
            this.ayp.j(aVar.getUrl(), aVar.kP());
        }
        if (aVar == null || aVar.kK() == null) {
            BI();
            return;
        }
        Bitmap kK = aVar.kK();
        this.ayj.setLoadBigImage(true);
        if (aVar.isGif()) {
            this.ayj.a(aVar.kP(), kK);
            this.ayj.invalidate();
            this.ayj.play();
            this.ayJ = false;
            this.ayk.setVisibility(8);
            this.mProgressBar.setVisibility(8);
        } else {
            if (this.ayF != null && this.ayF.isLongPic) {
                this.ayj.HG();
                this.ayj.setImageLoadCallBack(new com.baidu.tbadk.widget.a.b.a() { // from class: com.baidu.tbadk.coreExtra.view.f.3
                    @Override // com.baidu.tbadk.widget.a.b.a
                    public void BP() {
                        f.this.mProgressBar.setVisibility(8);
                    }
                });
            } else {
                this.mProgressBar.setVisibility(8);
            }
            this.ayj.setImageUrlData(this.ayF);
            this.ayj.a(kK, aVar.kP());
            BM();
        }
        BC();
        BE();
    }

    private void BI() {
        if (!this.ayq) {
            this.ayj.HL();
        } else {
            this.ayr = false;
        }
        this.ayk.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    public void setGifMaxUseableMem(int i) {
        this.ayj.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.ayj != null) {
            this.ayj.onDestroy();
        }
        if (this.ayn != null) {
            this.ayn.recycle();
        }
        if (this.ayv != null) {
            this.ayv.recycle();
            this.ayv = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.ayQ);
    }

    public void release() {
        if (this.ayj != null) {
            this.ayj.release();
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.ayk != null) {
            this.ayk.setVisibility(8);
        }
    }

    public void BJ() {
        if (this.ayj != null && this.ayj.getImageType() == 1) {
            this.ayj.stop();
        }
    }

    public void j(boolean z, boolean z2) {
        String str;
        if (this.ayj != null && (str = (String) this.ayj.getTag()) != null) {
            if (this.ayj.getImageType() == 1) {
                if (this.ayj.getGifCache() == null || !this.ayj.HS()) {
                    d(str, z, z2);
                }
            } else if (this.ayj.getImageType() == 2) {
                d(str, z, z2);
            } else if (BK()) {
                d(str, z, z2);
            }
        }
    }

    private boolean BK() {
        if (this.ayj.getImageBitmap() != null && this.ayj.HS()) {
            if (this.ayF == null || !this.ayF.isLongPic || this.ayj.HH()) {
                return false;
            }
            this.ayr = false;
            this.ayH = false;
            return true;
        }
        return true;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.ayF = imageUrlData;
    }

    public void setIsCdn(boolean z) {
        this.avT = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ayk) {
            if (!(this.ayk.getTag() instanceof Boolean) || ((Boolean) this.ayk.getTag()).booleanValue()) {
                final String dX = ao.dX(this.ayF.originalUrl);
                if (this.ayF.originalProcess >= 0) {
                    com.baidu.tbadk.download.e.CW().z(dX, 13);
                    this.ayF.originalProcess = -1;
                    BM();
                    return;
                }
                if (this.avV != null) {
                    this.avV.BQ();
                }
                com.baidu.adp.base.e<?> Y = i.Y(this.mContext);
                if (Y == null) {
                    fq(dX);
                } else if (!j.hh() || j.hi() || com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("original_img_down_tip", false)) {
                    fq(dX);
                } else {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("original_img_down_tip", true);
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(Y.getPageActivity());
                    aVar.cd(d.j.original_img_down_no_wifi_tip);
                    aVar.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.f.4
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar.dismiss();
                            f.this.fq(dX);
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
        } else if (view == this.ayl && this.ayF != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mContext).createHistoryCfg(String.valueOf(this.ayF.threadId), String.valueOf(this.ayF.postId), this.ayF.mIsSeeHost, this.ayF.mIsReserver, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fq(String str) {
        if (this.ayF != null) {
            this.ayF.originalProcess = 0;
        }
        this.ayk.setText("0%");
        this.ayk.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_close_yuantu, 0);
        DownloadData downloadData = new DownloadData(str);
        downloadData.setStatus(1);
        downloadData.setUrl(this.ayF.originalUrl);
        downloadData.setType(13);
        downloadData.setPath(k.uj() + al.vm().dP(str) + "/" + str);
        downloadData.setCallback(new com.baidu.tbadk.download.d() { // from class: com.baidu.tbadk.coreExtra.view.f.6
            @Override // com.baidu.tbadk.download.d
            public boolean onPreDownload(DownloadData downloadData2) {
                return true;
            }

            @Override // com.baidu.tbadk.download.d
            public void onFileUpdateProgress(DownloadData downloadData2) {
                if (downloadData2 != null) {
                    if (f.this.ayF != null && f.this.ayF.originalProcess != -1) {
                        f.this.ayF.originalProcess = downloadData2.getProcess();
                    }
                    if (f.this.ayF == null || f.this.ayF.originalProcess != -1) {
                        f.this.ayk.setText(downloadData2.getProcess() + "%");
                        f.this.ayk.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_close_yuantu, 0);
                    }
                }
            }

            @Override // com.baidu.tbadk.download.d
            public boolean onFileDownloaded(DownloadData downloadData2) {
                return true;
            }

            @Override // com.baidu.tbadk.download.d
            public void onFileDownloadSucceed(DownloadData downloadData2) {
                f.this.ayk.setText(f.this.getResources().getString(d.j.done));
                f.this.ayk.setTag(false);
                f.this.ayk.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                com.baidu.adp.lib.g.e.fP().postDelayed(f.this.ayR, 1500L);
                f.this.ayH = false;
                f.this.ayG = f.this.BL();
                f.this.BH();
            }

            @Override // com.baidu.tbadk.download.d
            public void onFileDownloadFailed(DownloadData downloadData2, int i, String str2) {
                f.this.ayH = false;
                BdToast.a(f.this.mContext, str2).to().tq();
                f.this.ayF.originalProcess = -1;
                f.this.BM();
            }
        });
        com.baidu.tbadk.download.e.CW().a(downloadData, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean BL() {
        if (this.ayF != null && !StringUtils.isNull(this.ayF.originalUrl, true) && this.ayF.originalSize >= 0 && !this.ayF.isBlockedPic) {
            String dX = ao.dX(this.ayF.originalUrl);
            File file = new File(k.uj() + al.vm().dP(dX) + "/" + dX);
            if (file != null && file.exists()) {
                this.ayF.originalProcess = 100;
                return true;
            }
            if (this.ayF.originalProcess < 0) {
                BM();
            } else {
                this.ayk.setText(this.ayF.originalProcess + "%");
                this.ayk.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_close_yuantu, 0);
            }
            this.ayJ = true;
        } else {
            this.ayk.setVisibility(8);
        }
        return false;
    }

    public void BM() {
        if (this.ayF != null) {
            if (!BN() || !this.ayJ) {
                this.ayk.setVisibility(8);
            } else {
                this.ayk.setVisibility(0);
            }
            if (this.ayF.originalSize > 0 && !R(this.ayF.originalSize)) {
                this.ayk.setText(ayh + "(" + am.G(this.ayF.originalSize) + ")");
            } else {
                this.ayk.setText(ayh);
            }
            this.ayk.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    private boolean BN() {
        return (this.ayF == null || !this.ayF.mIsShowOrigonButton || this.ayF.isBlockedPic || StringUtils.isNull(this.ayF.originalUrl)) ? false : true;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.avV = bVar;
    }

    private boolean R(long j) {
        return j > ayi;
    }
}
