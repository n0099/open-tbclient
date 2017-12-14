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
    private boolean avQ;
    private b avS;
    private boolean avT;
    private a.d ayA;
    private ImageUrlData ayC;
    private boolean ayD;
    private boolean ayE;
    private boolean ayF;
    public boolean ayG;
    private TextView ayH;
    private com.baidu.tbadk.img.b ayI;
    private View.OnTouchListener ayJ;
    private boolean ayK;
    private float ayL;
    private View.OnLongClickListener ayM;
    private Runnable ayN;
    private Runnable ayO;
    private View.OnTouchListener ayP;
    protected com.baidu.tbadk.widget.a ayg;
    protected TextView ayh;
    protected TextView ayi;
    protected TextView ayj;
    protected SubsamplingScaleImageView ayk;
    private SubsamplingScaleImageView.OnImageEventListener ayl;
    private a aym;
    private boolean ayn;
    private boolean ayo;
    private boolean ayp;
    private boolean ayq;
    private boolean ayr;
    private Bitmap ays;
    private boolean ayt;
    private float ayu;
    private Matrix ayv;
    private Rect ayw;
    private RectF ayx;
    private Rect ayy;
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
    private static final String aye = TbadkCoreApplication.getInst().getString(d.j.original_img_look);
    private static long ayf = 52428800;
    private static final int ayB = l.ae(TbadkCoreApplication.getInst()) / 5;
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
            if (this.ayh != null) {
                aj.j(this.ayh, d.f.btn_percent_yuantu);
                aj.b(this.ayh, d.C0096d.cp_cont_g, 1, 0);
            }
            if (this.ayi != null) {
                aj.k(this.ayi, d.C0096d.common_color_10022);
                aj.b(this.ayi, d.C0096d.cp_cont_g, 1, 0);
            }
            this.mSkinType = i;
        }
    }

    public void setHeadImage(boolean z) {
        if (this.ayg != null) {
            this.ayg.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.aym = aVar;
    }

    public f(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mContext = null;
        this.mProgressBar = null;
        this.ayg = null;
        this.aym = null;
        this.avQ = false;
        this.ayp = false;
        this.ayt = false;
        this.mRatio = 1.0f;
        this.ayu = 0.0f;
        this.ayv = new Matrix();
        this.ayx = new RectF();
        this.ayD = false;
        this.ayE = false;
        this.ayF = false;
        this.ayG = false;
        this.ayH = null;
        this.ayK = true;
        this.ayL = 0.0f;
        this.mOnClickListener = null;
        this.ayM = null;
        this.ayN = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.f.1
            @Override // java.lang.Runnable
            public void run() {
                f.this.ayK = true;
            }
        };
        this.ayO = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.f.7
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
                        f.this.ayh.setVisibility(8);
                        f.this.ayG = false;
                    }
                });
                f.this.ayh.startAnimation(alphaAnimation);
            }
        };
        this.ayP = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.f.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (f.this.ayJ != null) {
                    f.this.ayJ.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.ayI = new com.baidu.tbadk.img.b();
        init();
    }

    public com.baidu.tbadk.widget.a getImageView() {
        return this.ayg;
    }

    public void setGifSetListener(a.e eVar) {
        this.ayg.setGifSetListener(eVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.ayg.setImageOnClickListener(onClickListener);
        this.ayk.setOnClickListener(onClickListener);
        this.mOnClickListener = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.ayM = onLongClickListener;
        if (!this.avT) {
            this.ayg.setImageOnLongClickListener(this.ayM);
            this.ayk.setOnLongClickListener(this.ayM);
        }
    }

    public void setOnSizeChangedListener(final a.f fVar) {
        this.ayg.setOnSizeChangedListener(new a.f() { // from class: com.baidu.tbadk.coreExtra.view.f.8
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
        this.ayg = new com.baidu.tbadk.widget.a(this.mContext);
        this.ayg.setLayoutParams(layoutParams);
        this.ayg.setOnTouchListener(this.ayP);
        addView(this.ayg);
        this.ayk = new SubsamplingScaleImageView(this.mContext);
        this.ayk.setMaxScale(50.0f);
        this.ayk.setOnTouchListener(this.ayP);
        this.ayk.setVisibility(4);
        addView(this.ayk, layoutParams);
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
        this.ayh = new TextView(this.mContext);
        aj.j(this.ayh, d.f.btn_percent_yuantu);
        this.ayh.setText(d.j.original_img_look);
        this.ayh.setTextSize(0, getResources().getDimensionPixelSize(d.e.fontsize28));
        aj.b(this.ayh, d.C0096d.cp_cont_g, 1, 0);
        this.ayh.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds20);
        this.ayh.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        this.ayh.setMinWidth(getResources().getDimensionPixelSize(d.e.ds220));
        this.ayh.setMinHeight(getResources().getDimensionPixelSize(d.e.ds68));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(d.e.fontsize40);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        this.ayh.setOnClickListener(this);
        this.ayh.setVisibility(8);
        addView(this.ayh, layoutParams);
    }

    public void setIsCanDrag(boolean z) {
        this.avT = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        Bitmap imageBitmap;
        int height;
        int width;
        if (!this.avT || !this.ayo) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.ayq && motionEvent.getPointerCount() >= 2) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.ayq || this.ayr) {
            requestDisallowInterceptTouchEvent(true);
        }
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        float x = motionEvent.getX();
        int i = action & MotionEventCompat.ACTION_MASK;
        if (i == 0) {
            if (this.ays == null) {
                if (this.ayk.getVisibility() == 0) {
                    this.ays = com.baidu.tbadk.util.d.S(this.ayk);
                } else {
                    this.ays = com.baidu.tbadk.util.d.S(this.ayg);
                }
            }
            if (this.ayw == null && this.ays != null) {
                int measuredWidth = getMeasuredWidth();
                float measuredWidth2 = ((getMeasuredWidth() * 1.0f) / this.ays.getWidth()) * this.ays.getHeight();
                if (measuredWidth2 > getMeasuredHeight()) {
                    measuredWidth2 = getMeasuredHeight();
                }
                RectF e = e(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
                this.ayw = new Rect((int) e.left, (int) e.top, (int) e.right, (int) e.bottom);
            }
            if (this.ayz == null && this.ays != null) {
                if (this.ayk.getVisibility() == 0) {
                    height = this.ayk.getSHeight();
                    width = this.ayk.getSWidth();
                } else {
                    if (this.ayg.getImageType() == 1) {
                        imageBitmap = (this.ayg.getCurrentFrame() == null || this.ayg.getCurrentFrame().aOs == null) ? this.ays : this.ayg.getCurrentFrame().aOs;
                    } else {
                        imageBitmap = this.ayg.getImageBitmap() == null ? this.ays : this.ayg.getImageBitmap();
                    }
                    height = imageBitmap.getHeight();
                    width = imageBitmap.getWidth();
                }
                float af = l.af(getContext());
                int i2 = (int) (height * af);
                int i3 = (int) (width * af);
                if (i3 > this.ays.getWidth() && this.ays.getWidth() != 0) {
                    float width2 = (i3 * 1.0f) / this.ays.getWidth();
                    i3 = this.ays.getWidth();
                    i2 = (int) (i2 / width2);
                }
                if (i2 > this.ays.getHeight() && this.ays.getHeight() != 0) {
                    i3 = (int) (i3 / ((i2 * 1.0f) / this.ays.getHeight()));
                    i2 = this.ays.getHeight();
                }
                int ae = (l.ae(getContext()) - i2) / 2;
                int ac = (l.ac(getContext()) - i3) / 2;
                this.ayz = new Rect(ac, ae, i3 + ac, i2 + ae);
                this.ayy = new Rect(0, 0, this.ays.getWidth(), this.ays.getHeight());
            }
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (i == 2) {
            this.ayq = d(this.mLastMotionX - x, this.mLastMotionY - y);
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (this.ayq || this.ayr) {
            this.ayg.setImageOnLongClickListener(null);
            this.ayk.setOnLongClickListener(null);
            z = true;
        } else {
            this.ayg.setImageOnLongClickListener(this.ayM);
            this.ayk.setOnLongClickListener(this.ayM);
            z = super.dispatchTouchEvent(motionEvent);
        }
        if (i == 1 || i == 3) {
            this.mLastMotionX = 0.0f;
            this.mLastMotionY = 0.0f;
            this.ayt = false;
            this.ayv.reset();
            this.ayq = false;
            if (this.ayu > ayB) {
                this.ayr = true;
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
        if (this.ayk.getVisibility() != 0 || this.ayk.isCanDrag()) {
            if (this.ayC == null || !this.ayC.isLongPic || this.ayk.getVisibility() != 0 || this.ayk.isViewTop()) {
                if (this.ayC == null || !this.ayC.isLongPic || this.ayk.getVisibility() == 0 || this.ayg.HB()) {
                    if (this.ayk.getVisibility() == 0 || this.ayg.HD()) {
                        if (this.ays != null && getScrollY() == 0 && f2 < 0.0f && !this.ayt) {
                            this.ayt = true;
                            this.ayu = 0.0f;
                            this.mRatio = 1.0f;
                            if (this.ayA != null) {
                                this.ayA.HU();
                            }
                        }
                        if (this.ayt) {
                            this.ayu -= f2;
                            int measuredHeight = getMeasuredHeight();
                            if (this.ayu > measuredHeight) {
                                this.ayu = measuredHeight;
                            }
                            float f3 = f2 / measuredHeight;
                            this.ayv.postTranslate((-f) * 1.5f * this.mRatio, (-1.5f) * f2 * this.mRatio);
                            if (this.mRatio * (1.0f + f3) > 1.0f || this.ayu < 0.0f) {
                                this.ayv.preScale(1.0f / this.mRatio, 1.0f / this.mRatio, (this.mRatio * this.ays.getWidth()) / 2.0f, this.mRatio * (this.ays.getHeight() / 2));
                                this.mRatio = 1.0f;
                            } else {
                                this.ayv.preScale(1.0f + f3, 1.0f + f3, (this.mRatio * this.ays.getWidth()) / 2.0f, this.mRatio * (this.ays.getHeight() / 2));
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
        if (this.ayq && this.ays != null && !this.ays.isRecycled() && this.ayt) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.ayx == null) {
                this.ayx = new RectF();
            }
            this.ayv.mapRect(this.ayx, new RectF(this.ayw));
            canvas.drawBitmap(this.ays, this.ayy, this.ayx, (Paint) null);
        } else if (this.ayr && this.ays != null && !this.ays.isRecycled()) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.ayC == null || this.ayC.getSourceImageRectInScreen() == null) {
                canvas.drawBitmap(this.ays, this.ayy, this.ayx, (Paint) null);
            } else {
                canvas.drawBitmap(this.ays, this.ayz, this.ayx, (Paint) null);
            }
        } else {
            super.dispatchDraw(canvas);
        }
    }

    private void Bz() {
        if (this.ayC == null) {
            if (this.ayA != null) {
                this.ayA.HV();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.ayC.getSourceImageRectInScreen();
        if (sourceImageRectInScreen == null) {
            if (this.ayA != null) {
                this.ayA.HV();
                return;
            }
            return;
        }
        this.ayx.bottom = (((sourceImageRectInScreen.bottom - sourceImageRectInScreen.top) / (sourceImageRectInScreen.right - sourceImageRectInScreen.left)) * (this.ayx.right - this.ayx.left)) + this.ayx.top;
        final float[] fArr = {(this.ayx.left + this.ayx.right) / 2.0f, (this.ayx.top + this.ayx.bottom) / 2.0f};
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
                    f.this.ayx = f.this.e(floatValue, animatedFraction, sourceImageRectInScreen.right - sourceImageRectInScreen.left, sourceImageRectInScreen.bottom - sourceImageRectInScreen.top);
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
                f.this.ayt = false;
                f.this.invalidate();
                if (f.this.ayA != null) {
                    f.this.ayA.HV();
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
        this.ayJ = onTouchListener;
    }

    private void BA() {
        this.ayH = new TextView(this.mContext);
        this.ayH.setBackgroundResource(d.f.bg_url_drag_imagview_fade_view);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.height = getResources().getDimensionPixelSize(d.e.ds180);
        layoutParams.addRule(12);
        addView(this.ayH, layoutParams);
        this.ayH.setVisibility(8);
    }

    private void BB() {
        this.ayi = new TextView(this.mContext);
        aj.k(this.ayi, d.C0096d.common_color_10022);
        this.ayi.setText(d.j.goto_pb_floor);
        this.ayi.setTextSize(0, getResources().getDimensionPixelSize(d.e.fontsize24));
        aj.b(this.ayi, d.C0096d.cp_cont_g, 1, 0);
        this.ayi.setCompoundDrawablePadding(l.dip2px(this.mContext, 4.0f));
        this.ayi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_see_arrow), (Drawable) null);
        this.ayi.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds20);
        this.ayi.setPadding(dimensionPixelSize * 3, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(d.e.ds30);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(d.e.ds10);
        layoutParams.leftMargin = getResources().getDimensionPixelSize(d.e.ds20);
        layoutParams.addRule(1, this.ayh.getId());
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        this.ayi.setOnClickListener(this);
        this.ayi.setMinHeight(getResources().getDimensionPixelSize(d.e.ds100));
        addView(this.ayi, layoutParams);
        this.ayi.setVisibility(8);
    }

    private void BC() {
        if (this.ayi != null) {
            boolean z = this.ayn || this.ayo;
            if (!this.ayF && z && this.ayC != null && this.ayC.threadId > 0 && this.ayC.postId > 0 && this.ayC.mThreadType != 33 && !this.ayC.isBlockedPic) {
                this.ayi.setVisibility(0);
                if (this.ayH != null) {
                    this.ayH.setVisibility(0);
                    return;
                }
                return;
            }
            this.ayi.setVisibility(8);
            if (this.ayH != null) {
                this.ayH.setVisibility(8);
            }
        }
    }

    private void BD() {
        if (this.ayi != null) {
            this.ayi.setVisibility(8);
            if (this.ayH != null) {
                this.ayH.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BE() {
        if ((this.ayn || this.ayo) && this.ayC != null && this.ayC.mPicType == 1 && !TextUtils.isEmpty(this.ayC.mTagName)) {
            if (this.ayj != null) {
                this.ayj.setVisibility(8);
                this.ayj = null;
            }
            this.ayj = new TextView(this.mContext);
            this.ayj.setText(this.ayC.mTagName);
            this.ayj.setTextSize(0, getResources().getDimensionPixelSize(d.e.fontsize26));
            aj.b(this.ayj, d.C0096d.common_color_10013, 1, 0);
            aj.k(this.ayj, d.C0096d.common_color_10215);
            this.ayj.setAlpha(0.75f);
            this.ayj.setIncludeFontPadding(false);
            this.ayj.setGravity(17);
            int f = l.f(this.mContext, d.e.ds2);
            this.ayj.setPadding(f, f, f, f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.ayg.getBottomOffset();
            layoutParams.leftMargin = this.ayg.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.ayj, layoutParams);
            this.ayj.setVisibility(0);
        }
    }

    public void bl(boolean z) {
        this.ayF = z;
        if (this.ayF) {
            BD();
        } else {
            BC();
        }
    }

    public void o(String str, boolean z) {
        if (str.contains("*")) {
            str = str.split("[*]")[0];
        }
        this.ayg.setTag(str);
        this.ayg.setLoadBigImage(false);
        this.ayg.setImageDrawable(null);
        this.ayn = false;
        this.ayo = false;
        this.ayD = BL();
        this.ayh.setVisibility(8);
        if (fo(str)) {
            d(str, z, false);
        }
    }

    private boolean BF() {
        return this.ayg != null && this.ayg.HS();
    }

    public void BG() {
        if (this.ayC != null && !BF()) {
            String str = this.ayC.imageUrl;
            int i = this.ayC.urlType;
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
        if (!this.ayE || z) {
            this.ayE = true;
            if (!this.ayD || this.ayC == null || StringUtils.isNull(this.ayC.originalUrl, true) || this.ayC.originalSize < 0 || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String str = k.uj() + al.vm().dP(dX) + "/" + ao.dX(this.ayC.originalUrl);
            final int[] ds = k.ds(str);
            this.ayk.setVisibility(0);
            if (this.ayl == null) {
                this.ayl = new SubsamplingScaleImageView.OnImageEventListener() { // from class: com.baidu.tbadk.coreExtra.view.f.12
                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onReady() {
                        f.this.mProgressBar.setVisibility(8);
                        f.this.ayg.HO();
                        f.this.ayg.setVisibility(4);
                    }

                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onImageLoaded() {
                        if (f.this.ayC.isLongPic && ds[0] > 0) {
                            f.this.ayg.onDestroy();
                            final float measuredWidth = (f.this.getMeasuredWidth() * 1.0f) / ds[0];
                            final PointF pointF = new PointF((ds[0] * 1.0f) / 2.0f, 0.0f);
                            f.this.ayk.setScaleAndCenter(measuredWidth, pointF);
                            f.this.ayk.setMaxScale(2.0f * measuredWidth);
                            f.this.ayk.setDoubleTapZoomScale(2.0f * measuredWidth);
                            f.this.ayk.setInitScale(measuredWidth);
                            f.this.ayk.setDoubleTapZoomStyle(4);
                            f.this.ayk.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.f.12.1
                                @Override // android.view.View.OnTouchListener
                                public boolean onTouch(View view, MotionEvent motionEvent) {
                                    if (f.this.ayJ != null) {
                                        f.this.ayJ.onTouch(view, motionEvent);
                                    }
                                    switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                                        case 0:
                                            f.this.ayL = motionEvent.getY();
                                            f.this.ayk.setOnClickListener(f.this.ayK ? f.this.mOnClickListener : null);
                                            f.this.ayk.setOnLongClickListener(f.this.ayK ? f.this.ayM : null);
                                            break;
                                        case 1:
                                        case 3:
                                            if (f.this.ayk.getScale() < measuredWidth) {
                                                f.this.ayk.setScaleAndCenter(measuredWidth, pointF);
                                            }
                                            com.baidu.adp.lib.g.e.fP().removeCallbacks(f.this.ayN);
                                            com.baidu.adp.lib.g.e.fP().postDelayed(f.this.ayN, 1000L);
                                            break;
                                        case 2:
                                            if (Math.abs(motionEvent.getY() - f.this.ayL) > f.TOUCH_SLOP) {
                                                f.this.ayK = false;
                                                f.this.ayk.setOnClickListener(null);
                                                f.this.ayk.setOnLongClickListener(null);
                                            }
                                            f.this.ayL = motionEvent.getY();
                                            break;
                                    }
                                    return false;
                                }
                            });
                            f.this.ayg.setVisibility(4);
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
            this.ayk.setOnImageEventListener(this.ayl);
            if (this.ayk.isImageLoaded() && this.ayC.isLongPic) {
                this.ayl.onImageLoaded();
            } else {
                this.ayk.setImage(ImageSource.uri(str));
            }
            return true;
        }
        return false;
    }

    public void setDragToExitListener(a.d dVar) {
        this.ayA = dVar;
        if (this.ayg != null) {
            this.ayg.setDragToExitListener(dVar);
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
        if (!this.ayo && aVar != null && (kK = aVar.kK()) != null) {
            this.ayn = true;
            if (aVar.isGif()) {
                this.ayg.setImageUrlData(this.ayC);
                this.ayg.setImageBitmap(kK);
                this.ayh.setVisibility(8);
                this.ayG = false;
            } else {
                if (this.ayC != null && this.ayC.isLongPic) {
                    this.ayg.HG();
                    this.ayg.setImageLoadCallBack(new com.baidu.tbadk.widget.a.b.a() { // from class: com.baidu.tbadk.coreExtra.view.f.13
                        @Override // com.baidu.tbadk.widget.a.b.a
                        public void BP() {
                        }
                    });
                }
                this.ayg.setImageUrlData(this.ayC);
                this.ayg.a(kK, aVar.kP());
            }
            BC();
            BE();
        }
    }

    private void d(String str, boolean z, boolean z2) {
        if (fp(str)) {
            if (z2 || (!this.ayp && !this.ayo)) {
                if (!z2 || !bn(true)) {
                    this.ayp = true;
                    com.baidu.adp.lib.f.c.fJ().a(str, 27, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.coreExtra.view.f.14
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onCancelled(String str2) {
                            f.this.ayp = false;
                            f.this.ayg.setVisibility(0);
                            f.this.mProgressBar.setVisibility(8);
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onLoaded(com.baidu.adp.widget.a.a aVar, String str2, int i) {
                            f.this.ayp = false;
                            f.this.ayo = true;
                            f.this.b(aVar);
                        }
                    }, 0, 0, false, null, Boolean.valueOf(z), this.ayg.getImageData(), Boolean.valueOf(this.avQ));
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
        com.baidu.adp.widget.a.a a2 = this.ayI.a(imageFileInfo, false);
        if (a2 != null) {
            this.ayo = true;
            this.mProgressBar.setVisibility(8);
            b(a2);
            return;
        }
        this.ayI.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.coreExtra.view.f.2
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.a.a aVar, String str2, boolean z3) {
                f.this.ayo = true;
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
        if (aVar != null && this.aym != null) {
            this.aym.j(aVar.getUrl(), aVar.kP());
        }
        if (aVar == null || aVar.kK() == null) {
            BI();
            return;
        }
        Bitmap kK = aVar.kK();
        this.ayg.setLoadBigImage(true);
        if (aVar.isGif()) {
            this.ayg.a(aVar.kP(), kK);
            this.ayg.invalidate();
            this.ayg.play();
            this.ayG = false;
            this.ayh.setVisibility(8);
            this.mProgressBar.setVisibility(8);
        } else {
            if (this.ayC != null && this.ayC.isLongPic) {
                this.ayg.HG();
                this.ayg.setImageLoadCallBack(new com.baidu.tbadk.widget.a.b.a() { // from class: com.baidu.tbadk.coreExtra.view.f.3
                    @Override // com.baidu.tbadk.widget.a.b.a
                    public void BP() {
                        f.this.mProgressBar.setVisibility(8);
                    }
                });
            } else {
                this.mProgressBar.setVisibility(8);
            }
            this.ayg.setImageUrlData(this.ayC);
            this.ayg.a(kK, aVar.kP());
            BM();
        }
        BC();
        BE();
    }

    private void BI() {
        if (!this.ayn) {
            this.ayg.HL();
        } else {
            this.ayo = false;
        }
        this.ayh.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    public void setGifMaxUseableMem(int i) {
        this.ayg.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.ayg != null) {
            this.ayg.onDestroy();
        }
        if (this.ayk != null) {
            this.ayk.recycle();
        }
        if (this.ays != null) {
            this.ays.recycle();
            this.ays = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.ayN);
    }

    public void release() {
        if (this.ayg != null) {
            this.ayg.release();
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.ayh != null) {
            this.ayh.setVisibility(8);
        }
    }

    public void BJ() {
        if (this.ayg != null && this.ayg.getImageType() == 1) {
            this.ayg.stop();
        }
    }

    public void j(boolean z, boolean z2) {
        String str;
        if (this.ayg != null && (str = (String) this.ayg.getTag()) != null) {
            if (this.ayg.getImageType() == 1) {
                if (this.ayg.getGifCache() == null || !this.ayg.HS()) {
                    d(str, z, z2);
                }
            } else if (this.ayg.getImageType() == 2) {
                d(str, z, z2);
            } else if (BK()) {
                d(str, z, z2);
            }
        }
    }

    private boolean BK() {
        if (this.ayg.getImageBitmap() != null && this.ayg.HS()) {
            if (this.ayC == null || !this.ayC.isLongPic || this.ayg.HH()) {
                return false;
            }
            this.ayo = false;
            this.ayE = false;
            return true;
        }
        return true;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.ayC = imageUrlData;
    }

    public void setIsCdn(boolean z) {
        this.avQ = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ayh) {
            if (!(this.ayh.getTag() instanceof Boolean) || ((Boolean) this.ayh.getTag()).booleanValue()) {
                final String dX = ao.dX(this.ayC.originalUrl);
                if (this.ayC.originalProcess >= 0) {
                    com.baidu.tbadk.download.e.CW().z(dX, 13);
                    this.ayC.originalProcess = -1;
                    BM();
                    return;
                }
                if (this.avS != null) {
                    this.avS.BQ();
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
        } else if (view == this.ayi && this.ayC != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mContext).createHistoryCfg(String.valueOf(this.ayC.threadId), String.valueOf(this.ayC.postId), this.ayC.mIsSeeHost, this.ayC.mIsReserver, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fq(String str) {
        if (this.ayC != null) {
            this.ayC.originalProcess = 0;
        }
        this.ayh.setText("0%");
        this.ayh.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_close_yuantu, 0);
        DownloadData downloadData = new DownloadData(str);
        downloadData.setStatus(1);
        downloadData.setUrl(this.ayC.originalUrl);
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
                    if (f.this.ayC != null && f.this.ayC.originalProcess != -1) {
                        f.this.ayC.originalProcess = downloadData2.getProcess();
                    }
                    if (f.this.ayC == null || f.this.ayC.originalProcess != -1) {
                        f.this.ayh.setText(downloadData2.getProcess() + "%");
                        f.this.ayh.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_close_yuantu, 0);
                    }
                }
            }

            @Override // com.baidu.tbadk.download.d
            public boolean onFileDownloaded(DownloadData downloadData2) {
                return true;
            }

            @Override // com.baidu.tbadk.download.d
            public void onFileDownloadSucceed(DownloadData downloadData2) {
                f.this.ayh.setText(f.this.getResources().getString(d.j.done));
                f.this.ayh.setTag(false);
                f.this.ayh.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                com.baidu.adp.lib.g.e.fP().postDelayed(f.this.ayO, 1500L);
                f.this.ayE = false;
                f.this.ayD = f.this.BL();
                f.this.BH();
            }

            @Override // com.baidu.tbadk.download.d
            public void onFileDownloadFailed(DownloadData downloadData2, int i, String str2) {
                f.this.ayE = false;
                BdToast.a(f.this.mContext, str2).to().tq();
                f.this.ayC.originalProcess = -1;
                f.this.BM();
            }
        });
        com.baidu.tbadk.download.e.CW().a(downloadData, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean BL() {
        if (this.ayC != null && !StringUtils.isNull(this.ayC.originalUrl, true) && this.ayC.originalSize >= 0 && !this.ayC.isBlockedPic) {
            String dX = ao.dX(this.ayC.originalUrl);
            File file = new File(k.uj() + al.vm().dP(dX) + "/" + dX);
            if (file != null && file.exists()) {
                this.ayC.originalProcess = 100;
                return true;
            }
            if (this.ayC.originalProcess < 0) {
                BM();
            } else {
                this.ayh.setText(this.ayC.originalProcess + "%");
                this.ayh.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_close_yuantu, 0);
            }
            this.ayG = true;
        } else {
            this.ayh.setVisibility(8);
        }
        return false;
    }

    public void BM() {
        if (this.ayC != null) {
            if (!BN() || !this.ayG) {
                this.ayh.setVisibility(8);
            } else {
                this.ayh.setVisibility(0);
            }
            if (this.ayC.originalSize > 0 && !R(this.ayC.originalSize)) {
                this.ayh.setText(aye + "(" + am.G(this.ayC.originalSize) + ")");
            } else {
                this.ayh.setText(aye);
            }
            this.ayh.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    private boolean BN() {
        return (this.ayC == null || !this.ayC.mIsShowOrigonButton || this.ayC.isBlockedPic || StringUtils.isNull(this.ayC.originalUrl)) ? false : true;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.avS = bVar;
    }

    private boolean R(long j) {
        return j > ayf;
    }
}
