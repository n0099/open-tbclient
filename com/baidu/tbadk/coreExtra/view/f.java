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
    private boolean avL;
    private b avN;
    private boolean avO;
    private boolean ayA;
    public boolean ayB;
    private TextView ayC;
    private com.baidu.tbadk.img.b ayD;
    private View.OnTouchListener ayE;
    private boolean ayF;
    private float ayG;
    private View.OnLongClickListener ayH;
    private Runnable ayI;
    private Runnable ayJ;
    private View.OnTouchListener ayK;
    protected com.baidu.tbadk.widget.a ayb;
    protected TextView ayc;
    protected TextView ayd;
    protected TextView aye;
    protected SubsamplingScaleImageView ayf;
    private SubsamplingScaleImageView.OnImageEventListener ayg;
    private a ayh;
    private boolean ayi;
    private boolean ayj;
    private boolean ayk;
    private boolean ayl;
    private boolean aym;
    private Bitmap ayn;
    private boolean ayo;
    private float ayp;
    private Matrix ayq;
    private Rect ayr;
    private RectF ays;
    private Rect ayt;
    private Rect ayu;
    private a.d ayv;
    private ImageUrlData ayx;
    private boolean ayy;
    private boolean ayz;
    protected Context mContext;
    private float mLastMotionX;
    private float mLastMotionY;
    private int mMaxHeight;
    private int mMaxWidth;
    private View.OnClickListener mOnClickListener;
    protected ProgressBar mProgressBar;
    private float mRatio;
    private int mSkinType;
    private static final String axZ = TbadkCoreApplication.getInst().getString(d.j.original_img_look);
    private static long aya = 52428800;
    private static final int ayw = l.ae(TbadkCoreApplication.getInst()) / 5;
    private static final String TAG = f.class.getSimpleName();
    private static final int TOUCH_SLOP = ViewConfiguration.get(TbadkCoreApplication.getInst()).getScaledTouchSlop();

    /* loaded from: classes.dex */
    public interface a {
        void j(String str, byte[] bArr);
    }

    /* loaded from: classes.dex */
    public interface b {
        void BP();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.ayc != null) {
                aj.j(this.ayc, d.f.btn_percent_yuantu);
                aj.b(this.ayc, d.C0082d.cp_cont_g, 1, 0);
            }
            if (this.ayd != null) {
                aj.k(this.ayd, d.C0082d.common_color_10022);
                aj.b(this.ayd, d.C0082d.cp_cont_g, 1, 0);
            }
            this.mSkinType = i;
        }
    }

    public void setHeadImage(boolean z) {
        if (this.ayb != null) {
            this.ayb.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.ayh = aVar;
    }

    public f(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mContext = null;
        this.mProgressBar = null;
        this.ayb = null;
        this.ayh = null;
        this.avL = false;
        this.ayk = false;
        this.ayo = false;
        this.mRatio = 1.0f;
        this.ayp = 0.0f;
        this.ayq = new Matrix();
        this.ays = new RectF();
        this.ayy = false;
        this.ayz = false;
        this.ayA = false;
        this.ayB = false;
        this.ayC = null;
        this.ayF = true;
        this.ayG = 0.0f;
        this.mOnClickListener = null;
        this.ayH = null;
        this.ayI = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.f.1
            @Override // java.lang.Runnable
            public void run() {
                f.this.ayF = true;
            }
        };
        this.ayJ = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.f.7
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
                        f.this.ayc.setVisibility(8);
                        f.this.ayB = false;
                    }
                });
                f.this.ayc.startAnimation(alphaAnimation);
            }
        };
        this.ayK = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.f.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (f.this.ayE != null) {
                    f.this.ayE.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.ayD = new com.baidu.tbadk.img.b();
        init();
    }

    public com.baidu.tbadk.widget.a getImageView() {
        return this.ayb;
    }

    public void setGifSetListener(a.e eVar) {
        this.ayb.setGifSetListener(eVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.ayb.setImageOnClickListener(onClickListener);
        this.ayf.setOnClickListener(onClickListener);
        this.mOnClickListener = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.ayH = onLongClickListener;
        if (!this.avO) {
            this.ayb.setImageOnLongClickListener(this.ayH);
            this.ayf.setOnLongClickListener(this.ayH);
        }
    }

    public void setOnSizeChangedListener(final a.f fVar) {
        this.ayb.setOnSizeChangedListener(new a.f() { // from class: com.baidu.tbadk.coreExtra.view.f.8
            @Override // com.baidu.tbadk.widget.a.f
            public void a(com.baidu.tbadk.widget.a aVar, boolean z, boolean z2) {
                if (fVar != null) {
                    fVar.a(aVar, z, z2);
                }
                f.this.BD();
            }
        });
    }

    protected void init() {
        this.mMaxWidth = l.ac(this.mContext);
        this.mMaxHeight = l.ae(this.mContext) - ((int) this.mContext.getResources().getDimension(d.e.ds166));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.ayb = new com.baidu.tbadk.widget.a(this.mContext);
        this.ayb.setLayoutParams(layoutParams);
        this.ayb.setOnTouchListener(this.ayK);
        addView(this.ayb);
        this.ayf = new SubsamplingScaleImageView(this.mContext);
        this.ayf.setMaxScale(50.0f);
        this.ayf.setOnTouchListener(this.ayK);
        this.ayf.setVisibility(4);
        addView(this.ayf, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(getResources().getDrawable(d.f.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        Bz();
        Bx();
        BA();
    }

    private void Bx() {
        this.ayc = new TextView(this.mContext);
        aj.j(this.ayc, d.f.btn_percent_yuantu);
        this.ayc.setText(d.j.original_img_look);
        this.ayc.setTextSize(0, getResources().getDimensionPixelSize(d.e.fontsize28));
        aj.b(this.ayc, d.C0082d.cp_cont_g, 1, 0);
        this.ayc.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds20);
        this.ayc.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        this.ayc.setMinWidth(getResources().getDimensionPixelSize(d.e.ds220));
        this.ayc.setMinHeight(getResources().getDimensionPixelSize(d.e.ds68));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(d.e.fontsize40);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        this.ayc.setOnClickListener(this);
        this.ayc.setVisibility(8);
        addView(this.ayc, layoutParams);
    }

    public void setIsCanDrag(boolean z) {
        this.avO = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        Bitmap imageBitmap;
        int height;
        int width;
        if (!this.avO || !this.ayj) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.ayl && motionEvent.getPointerCount() >= 2) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.ayl || this.aym) {
            requestDisallowInterceptTouchEvent(true);
        }
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        float x = motionEvent.getX();
        int i = action & MotionEventCompat.ACTION_MASK;
        if (i == 0) {
            if (this.ayn == null) {
                if (this.ayf.getVisibility() == 0) {
                    this.ayn = com.baidu.tbadk.util.d.R(this.ayf);
                } else {
                    this.ayn = com.baidu.tbadk.util.d.R(this.ayb);
                }
            }
            if (this.ayr == null && this.ayn != null) {
                int measuredWidth = getMeasuredWidth();
                float measuredWidth2 = ((getMeasuredWidth() * 1.0f) / this.ayn.getWidth()) * this.ayn.getHeight();
                if (measuredWidth2 > getMeasuredHeight()) {
                    measuredWidth2 = getMeasuredHeight();
                }
                RectF e = e(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
                this.ayr = new Rect((int) e.left, (int) e.top, (int) e.right, (int) e.bottom);
            }
            if (this.ayu == null && this.ayn != null) {
                if (this.ayf.getVisibility() == 0) {
                    height = this.ayf.getSHeight();
                    width = this.ayf.getSWidth();
                } else {
                    if (this.ayb.getImageType() == 1) {
                        imageBitmap = (this.ayb.getCurrentFrame() == null || this.ayb.getCurrentFrame().aOp == null) ? this.ayn : this.ayb.getCurrentFrame().aOp;
                    } else {
                        imageBitmap = this.ayb.getImageBitmap() == null ? this.ayn : this.ayb.getImageBitmap();
                    }
                    height = imageBitmap.getHeight();
                    width = imageBitmap.getWidth();
                }
                float af = l.af(getContext());
                int i2 = (int) (height * af);
                int i3 = (int) (width * af);
                if (i3 > this.ayn.getWidth() && this.ayn.getWidth() != 0) {
                    float width2 = (i3 * 1.0f) / this.ayn.getWidth();
                    i3 = this.ayn.getWidth();
                    i2 = (int) (i2 / width2);
                }
                if (i2 > this.ayn.getHeight() && this.ayn.getHeight() != 0) {
                    i3 = (int) (i3 / ((i2 * 1.0f) / this.ayn.getHeight()));
                    i2 = this.ayn.getHeight();
                }
                int ae = (l.ae(getContext()) - i2) / 2;
                int ac = (l.ac(getContext()) - i3) / 2;
                this.ayu = new Rect(ac, ae, i3 + ac, i2 + ae);
                this.ayt = new Rect(0, 0, this.ayn.getWidth(), this.ayn.getHeight());
            }
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (i == 2) {
            this.ayl = d(this.mLastMotionX - x, this.mLastMotionY - y);
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (this.ayl || this.aym) {
            this.ayb.setImageOnLongClickListener(null);
            this.ayf.setOnLongClickListener(null);
            z = true;
        } else {
            this.ayb.setImageOnLongClickListener(this.ayH);
            this.ayf.setOnLongClickListener(this.ayH);
            z = super.dispatchTouchEvent(motionEvent);
        }
        if (i == 1 || i == 3) {
            this.mLastMotionX = 0.0f;
            this.mLastMotionY = 0.0f;
            this.ayo = false;
            this.ayq.reset();
            this.ayl = false;
            if (this.ayp > ayw) {
                this.aym = true;
                By();
                return z;
            }
            this.mRatio = 1.0f;
            invalidate();
            return z;
        }
        return z;
    }

    private boolean d(float f, float f2) {
        if (this.ayf.getVisibility() != 0 || this.ayf.isCanDrag()) {
            if (this.ayx == null || !this.ayx.isLongPic || this.ayf.getVisibility() != 0 || this.ayf.isViewTop()) {
                if (this.ayx == null || !this.ayx.isLongPic || this.ayf.getVisibility() == 0 || this.ayb.HA()) {
                    if (this.ayf.getVisibility() == 0 || this.ayb.HC()) {
                        if (this.ayn != null && getScrollY() == 0 && f2 < 0.0f && !this.ayo) {
                            this.ayo = true;
                            this.ayp = 0.0f;
                            this.mRatio = 1.0f;
                            if (this.ayv != null) {
                                this.ayv.HT();
                            }
                        }
                        if (this.ayo) {
                            this.ayp -= f2;
                            int measuredHeight = getMeasuredHeight();
                            if (this.ayp > measuredHeight) {
                                this.ayp = measuredHeight;
                            }
                            float f3 = f2 / measuredHeight;
                            this.ayq.postTranslate((-f) * 1.5f * this.mRatio, (-1.5f) * f2 * this.mRatio);
                            if (this.mRatio * (1.0f + f3) > 1.0f || this.ayp < 0.0f) {
                                this.ayq.preScale(1.0f / this.mRatio, 1.0f / this.mRatio, (this.mRatio * this.ayn.getWidth()) / 2.0f, this.mRatio * (this.ayn.getHeight() / 2));
                                this.mRatio = 1.0f;
                            } else {
                                this.ayq.preScale(1.0f + f3, 1.0f + f3, (this.mRatio * this.ayn.getWidth()) / 2.0f, this.mRatio * (this.ayn.getHeight() / 2));
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
        if (this.ayl && this.ayn != null && !this.ayn.isRecycled() && this.ayo) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.ays == null) {
                this.ays = new RectF();
            }
            this.ayq.mapRect(this.ays, new RectF(this.ayr));
            canvas.drawBitmap(this.ayn, this.ayt, this.ays, (Paint) null);
        } else if (this.aym && this.ayn != null && !this.ayn.isRecycled()) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.ayx == null || this.ayx.getSourceImageRectInScreen() == null) {
                canvas.drawBitmap(this.ayn, this.ayt, this.ays, (Paint) null);
            } else {
                canvas.drawBitmap(this.ayn, this.ayu, this.ays, (Paint) null);
            }
        } else {
            super.dispatchDraw(canvas);
        }
    }

    private void By() {
        if (this.ayx == null) {
            if (this.ayv != null) {
                this.ayv.HU();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.ayx.getSourceImageRectInScreen();
        if (sourceImageRectInScreen == null) {
            if (this.ayv != null) {
                this.ayv.HU();
                return;
            }
            return;
        }
        this.ays.bottom = (((sourceImageRectInScreen.bottom - sourceImageRectInScreen.top) / (sourceImageRectInScreen.right - sourceImageRectInScreen.left)) * (this.ays.right - this.ays.left)) + this.ays.top;
        final float[] fArr = {(this.ays.left + this.ays.right) / 2.0f, (this.ays.top + this.ays.bottom) / 2.0f};
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
                    f.this.ays = f.this.e(floatValue, animatedFraction, sourceImageRectInScreen.right - sourceImageRectInScreen.left, sourceImageRectInScreen.bottom - sourceImageRectInScreen.top);
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
                f.this.ayo = false;
                f.this.invalidate();
                if (f.this.ayv != null) {
                    f.this.ayv.HU();
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
        this.ayE = onTouchListener;
    }

    private void Bz() {
        this.ayC = new TextView(this.mContext);
        this.ayC.setBackgroundResource(d.f.bg_url_drag_imagview_fade_view);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.height = getResources().getDimensionPixelSize(d.e.ds180);
        layoutParams.addRule(12);
        addView(this.ayC, layoutParams);
        this.ayC.setVisibility(8);
    }

    private void BA() {
        this.ayd = new TextView(this.mContext);
        aj.k(this.ayd, d.C0082d.common_color_10022);
        this.ayd.setText(d.j.goto_pb_floor);
        this.ayd.setTextSize(0, getResources().getDimensionPixelSize(d.e.fontsize24));
        aj.b(this.ayd, d.C0082d.cp_cont_g, 1, 0);
        this.ayd.setCompoundDrawablePadding(l.dip2px(this.mContext, 4.0f));
        this.ayd.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_see_arrow), (Drawable) null);
        this.ayd.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds20);
        this.ayd.setPadding(dimensionPixelSize * 3, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(d.e.ds30);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(d.e.ds10);
        layoutParams.leftMargin = getResources().getDimensionPixelSize(d.e.ds20);
        layoutParams.addRule(1, this.ayc.getId());
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        this.ayd.setOnClickListener(this);
        this.ayd.setMinHeight(getResources().getDimensionPixelSize(d.e.ds100));
        addView(this.ayd, layoutParams);
        this.ayd.setVisibility(8);
    }

    private void BB() {
        if (this.ayd != null) {
            boolean z = this.ayi || this.ayj;
            if (!this.ayA && z && this.ayx != null && this.ayx.threadId > 0 && this.ayx.postId > 0 && this.ayx.mThreadType != 33 && !this.ayx.isBlockedPic) {
                this.ayd.setVisibility(0);
                if (this.ayC != null) {
                    this.ayC.setVisibility(0);
                    return;
                }
                return;
            }
            this.ayd.setVisibility(8);
            if (this.ayC != null) {
                this.ayC.setVisibility(8);
            }
        }
    }

    private void BC() {
        if (this.ayd != null) {
            this.ayd.setVisibility(8);
            if (this.ayC != null) {
                this.ayC.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BD() {
        if ((this.ayi || this.ayj) && this.ayx != null && this.ayx.mPicType == 1 && !TextUtils.isEmpty(this.ayx.mTagName)) {
            if (this.aye != null) {
                this.aye.setVisibility(8);
                this.aye = null;
            }
            this.aye = new TextView(this.mContext);
            this.aye.setText(this.ayx.mTagName);
            this.aye.setTextSize(0, getResources().getDimensionPixelSize(d.e.fontsize26));
            aj.b(this.aye, d.C0082d.common_color_10013, 1, 0);
            aj.k(this.aye, d.C0082d.common_color_10215);
            this.aye.setAlpha(0.75f);
            this.aye.setIncludeFontPadding(false);
            this.aye.setGravity(17);
            int f = l.f(this.mContext, d.e.ds2);
            this.aye.setPadding(f, f, f, f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.ayb.getBottomOffset();
            layoutParams.leftMargin = this.ayb.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.aye, layoutParams);
            this.aye.setVisibility(0);
        }
    }

    public void bk(boolean z) {
        this.ayA = z;
        if (this.ayA) {
            BC();
        } else {
            BB();
        }
    }

    public void n(String str, boolean z) {
        if (str.contains("*")) {
            str = str.split("[*]")[0];
        }
        this.ayb.setTag(str);
        this.ayb.setLoadBigImage(false);
        this.ayb.setImageDrawable(null);
        this.ayi = false;
        this.ayj = false;
        this.ayy = BK();
        this.ayc.setVisibility(8);
        if (fp(str)) {
            d(str, z, false);
        }
    }

    private boolean BE() {
        return this.ayb != null && this.ayb.HR();
    }

    public void BF() {
        if (this.ayx != null && !BE()) {
            String str = this.ayx.imageUrl;
            int i = this.ayx.urlType;
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
        String dX;
        if (!this.ayz || z) {
            this.ayz = true;
            if (!this.ayy || this.ayx == null || StringUtils.isNull(this.ayx.originalUrl, true) || this.ayx.originalSize < 0 || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String str = k.um() + al.vp().dP(dX) + "/" + ao.dX(this.ayx.originalUrl);
            final int[] ds = k.ds(str);
            this.ayf.setVisibility(0);
            if (this.ayg == null) {
                this.ayg = new SubsamplingScaleImageView.OnImageEventListener() { // from class: com.baidu.tbadk.coreExtra.view.f.12
                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onReady() {
                        f.this.mProgressBar.setVisibility(8);
                        f.this.ayb.HN();
                        f.this.ayb.setVisibility(4);
                    }

                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onImageLoaded() {
                        if (f.this.ayx.isLongPic && ds[0] > 0) {
                            f.this.ayb.onDestroy();
                            final float measuredWidth = (f.this.getMeasuredWidth() * 1.0f) / ds[0];
                            final PointF pointF = new PointF((ds[0] * 1.0f) / 2.0f, 0.0f);
                            f.this.ayf.setScaleAndCenter(measuredWidth, pointF);
                            f.this.ayf.setMaxScale(2.0f * measuredWidth);
                            f.this.ayf.setDoubleTapZoomScale(2.0f * measuredWidth);
                            f.this.ayf.setInitScale(measuredWidth);
                            f.this.ayf.setDoubleTapZoomStyle(4);
                            f.this.ayf.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.f.12.1
                                @Override // android.view.View.OnTouchListener
                                public boolean onTouch(View view, MotionEvent motionEvent) {
                                    if (f.this.ayE != null) {
                                        f.this.ayE.onTouch(view, motionEvent);
                                    }
                                    switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                                        case 0:
                                            f.this.ayG = motionEvent.getY();
                                            f.this.ayf.setOnClickListener(f.this.ayF ? f.this.mOnClickListener : null);
                                            f.this.ayf.setOnLongClickListener(f.this.ayF ? f.this.ayH : null);
                                            break;
                                        case 1:
                                        case 3:
                                            if (f.this.ayf.getScale() < measuredWidth) {
                                                f.this.ayf.setScaleAndCenter(measuredWidth, pointF);
                                            }
                                            com.baidu.adp.lib.g.e.fP().removeCallbacks(f.this.ayI);
                                            com.baidu.adp.lib.g.e.fP().postDelayed(f.this.ayI, 1000L);
                                            break;
                                        case 2:
                                            if (Math.abs(motionEvent.getY() - f.this.ayG) > f.TOUCH_SLOP) {
                                                f.this.ayF = false;
                                                f.this.ayf.setOnClickListener(null);
                                                f.this.ayf.setOnLongClickListener(null);
                                            }
                                            f.this.ayG = motionEvent.getY();
                                            break;
                                    }
                                    return false;
                                }
                            });
                            f.this.ayb.setVisibility(4);
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
            this.ayf.setOnImageEventListener(this.ayg);
            if (this.ayf.isImageLoaded() && this.ayx.isLongPic) {
                this.ayg.onImageLoaded();
            } else {
                this.ayf.setImage(ImageSource.uri(str));
            }
            return true;
        }
        return false;
    }

    public void setDragToExitListener(a.d dVar) {
        this.ayv = dVar;
        if (this.ayb != null) {
            this.ayb.setDragToExitListener(dVar);
        }
    }

    public void BG() {
        bm(false);
    }

    private boolean fp(String str) {
        return j.hh() || com.baidu.tbadk.core.util.c.c.el(str);
    }

    private void setThumbBitmapToView(com.baidu.adp.widget.a.a aVar) {
        Bitmap kK;
        if (!this.ayj && aVar != null && (kK = aVar.kK()) != null) {
            this.ayi = true;
            if (aVar.isGif()) {
                this.ayb.setImageUrlData(this.ayx);
                this.ayb.setImageBitmap(kK);
                this.ayc.setVisibility(8);
                this.ayB = false;
            } else {
                if (this.ayx != null && this.ayx.isLongPic) {
                    this.ayb.HF();
                    this.ayb.setImageLoadCallBack(new com.baidu.tbadk.widget.a.b.a() { // from class: com.baidu.tbadk.coreExtra.view.f.13
                        @Override // com.baidu.tbadk.widget.a.b.a
                        public void BO() {
                        }
                    });
                }
                this.ayb.setImageUrlData(this.ayx);
                this.ayb.a(kK, aVar.kP());
            }
            BB();
            BD();
        }
    }

    private void d(String str, boolean z, boolean z2) {
        if (fq(str)) {
            if (z2 || (!this.ayk && !this.ayj)) {
                if (!z2 || !bm(true)) {
                    this.ayk = true;
                    com.baidu.adp.lib.f.c.fJ().a(str, 27, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.coreExtra.view.f.14
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onCancelled(String str2) {
                            f.this.ayk = false;
                            f.this.ayb.setVisibility(0);
                            f.this.mProgressBar.setVisibility(8);
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onLoaded(com.baidu.adp.widget.a.a aVar, String str2, int i) {
                            f.this.ayk = false;
                            f.this.ayj = true;
                            f.this.b(aVar);
                        }
                    }, 0, 0, false, null, Boolean.valueOf(z), this.ayb.getImageData(), Boolean.valueOf(this.avL));
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
        imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.I(this.mMaxWidth, this.mMaxHeight));
        com.baidu.adp.widget.a.a a2 = this.ayD.a(imageFileInfo, false);
        if (a2 != null) {
            this.ayj = true;
            this.mProgressBar.setVisibility(8);
            b(a2);
            return;
        }
        this.ayD.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.coreExtra.view.f.2
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.a.a aVar, String str2, boolean z3) {
                f.this.ayj = true;
                f.this.mProgressBar.setVisibility(8);
                f.this.b(aVar);
            }
        }, false);
    }

    private boolean fq(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith("https://"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null && this.ayh != null) {
            this.ayh.j(aVar.getUrl(), aVar.kP());
        }
        if (aVar == null || aVar.kK() == null) {
            BH();
            return;
        }
        Bitmap kK = aVar.kK();
        this.ayb.setLoadBigImage(true);
        if (aVar.isGif()) {
            this.ayb.a(aVar.kP(), kK);
            this.ayb.invalidate();
            this.ayb.play();
            this.ayB = false;
            this.ayc.setVisibility(8);
            this.mProgressBar.setVisibility(8);
        } else {
            if (this.ayx != null && this.ayx.isLongPic) {
                this.ayb.HF();
                this.ayb.setImageLoadCallBack(new com.baidu.tbadk.widget.a.b.a() { // from class: com.baidu.tbadk.coreExtra.view.f.3
                    @Override // com.baidu.tbadk.widget.a.b.a
                    public void BO() {
                        f.this.mProgressBar.setVisibility(8);
                    }
                });
            } else {
                this.mProgressBar.setVisibility(8);
            }
            this.ayb.setImageUrlData(this.ayx);
            this.ayb.a(kK, aVar.kP());
            BL();
        }
        BB();
        BD();
    }

    private void BH() {
        if (!this.ayi) {
            this.ayb.HK();
        } else {
            this.ayj = false;
        }
        this.ayc.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    public void setGifMaxUseableMem(int i) {
        this.ayb.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.ayb != null) {
            this.ayb.onDestroy();
        }
        if (this.ayf != null) {
            this.ayf.recycle();
        }
        if (this.ayn != null) {
            this.ayn.recycle();
            this.ayn = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.ayI);
    }

    public void release() {
        if (this.ayb != null) {
            this.ayb.release();
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.ayc != null) {
            this.ayc.setVisibility(8);
        }
    }

    public void BI() {
        if (this.ayb != null && this.ayb.getImageType() == 1) {
            this.ayb.stop();
        }
    }

    public void j(boolean z, boolean z2) {
        String str;
        if (this.ayb != null && (str = (String) this.ayb.getTag()) != null) {
            if (this.ayb.getImageType() == 1) {
                if (this.ayb.getGifCache() == null || !this.ayb.HR()) {
                    d(str, z, z2);
                }
            } else if (this.ayb.getImageType() == 2) {
                d(str, z, z2);
            } else if (BJ()) {
                d(str, z, z2);
            }
        }
    }

    private boolean BJ() {
        if (this.ayb.getImageBitmap() != null && this.ayb.HR()) {
            if (this.ayx == null || !this.ayx.isLongPic || this.ayb.HG()) {
                return false;
            }
            this.ayj = false;
            this.ayz = false;
            return true;
        }
        return true;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.ayx = imageUrlData;
    }

    public void setIsCdn(boolean z) {
        this.avL = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ayc) {
            if (!(this.ayc.getTag() instanceof Boolean) || ((Boolean) this.ayc.getTag()).booleanValue()) {
                final String dX = ao.dX(this.ayx.originalUrl);
                if (this.ayx.originalProcess >= 0) {
                    com.baidu.tbadk.download.e.CV().z(dX, 13);
                    this.ayx.originalProcess = -1;
                    BL();
                    return;
                }
                if (this.avN != null) {
                    this.avN.BP();
                }
                com.baidu.adp.base.e<?> Y = i.Y(this.mContext);
                if (Y == null) {
                    fr(dX);
                } else if (!j.hh() || j.hi() || com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("original_img_down_tip", false)) {
                    fr(dX);
                } else {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("original_img_down_tip", true);
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(Y.getPageActivity());
                    aVar.cd(d.j.original_img_down_no_wifi_tip);
                    aVar.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.f.4
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar.dismiss();
                            f.this.fr(dX);
                        }
                    });
                    aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.f.5
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar.dismiss();
                        }
                    });
                    aVar.b(Y);
                    aVar.tk();
                }
            }
        } else if (view == this.ayd && this.ayx != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mContext).createHistoryCfg(String.valueOf(this.ayx.threadId), String.valueOf(this.ayx.postId), this.ayx.mIsSeeHost, this.ayx.mIsReserver, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fr(String str) {
        if (this.ayx != null) {
            this.ayx.originalProcess = 0;
        }
        this.ayc.setText("0%");
        this.ayc.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_close_yuantu, 0);
        DownloadData downloadData = new DownloadData(str);
        downloadData.setStatus(1);
        downloadData.setUrl(this.ayx.originalUrl);
        downloadData.setType(13);
        downloadData.setPath(k.um() + al.vp().dP(str) + "/" + str);
        downloadData.setCallback(new com.baidu.tbadk.download.d() { // from class: com.baidu.tbadk.coreExtra.view.f.6
            @Override // com.baidu.tbadk.download.d
            public boolean onPreDownload(DownloadData downloadData2) {
                return true;
            }

            @Override // com.baidu.tbadk.download.d
            public void onFileUpdateProgress(DownloadData downloadData2) {
                if (downloadData2 != null) {
                    if (f.this.ayx != null && f.this.ayx.originalProcess != -1) {
                        f.this.ayx.originalProcess = downloadData2.getProcess();
                    }
                    if (f.this.ayx == null || f.this.ayx.originalProcess != -1) {
                        f.this.ayc.setText(downloadData2.getProcess() + "%");
                        f.this.ayc.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_close_yuantu, 0);
                    }
                }
            }

            @Override // com.baidu.tbadk.download.d
            public boolean onFileDownloaded(DownloadData downloadData2) {
                return true;
            }

            @Override // com.baidu.tbadk.download.d
            public void onFileDownloadSucceed(DownloadData downloadData2) {
                f.this.ayc.setText(f.this.getResources().getString(d.j.done));
                f.this.ayc.setTag(false);
                f.this.ayc.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                com.baidu.adp.lib.g.e.fP().postDelayed(f.this.ayJ, 1500L);
                f.this.ayz = false;
                f.this.ayy = f.this.BK();
                f.this.BG();
            }

            @Override // com.baidu.tbadk.download.d
            public void onFileDownloadFailed(DownloadData downloadData2, int i, String str2) {
                f.this.ayz = false;
                BdToast.a(f.this.mContext, str2).tr().tt();
                f.this.ayx.originalProcess = -1;
                f.this.BL();
            }
        });
        com.baidu.tbadk.download.e.CV().a(downloadData, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean BK() {
        if (this.ayx != null && !StringUtils.isNull(this.ayx.originalUrl, true) && this.ayx.originalSize >= 0 && !this.ayx.isBlockedPic) {
            String dX = ao.dX(this.ayx.originalUrl);
            File file = new File(k.um() + al.vp().dP(dX) + "/" + dX);
            if (file != null && file.exists()) {
                this.ayx.originalProcess = 100;
                return true;
            }
            if (this.ayx.originalProcess < 0) {
                BL();
            } else {
                this.ayc.setText(this.ayx.originalProcess + "%");
                this.ayc.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_close_yuantu, 0);
            }
            this.ayB = true;
        } else {
            this.ayc.setVisibility(8);
        }
        return false;
    }

    public void BL() {
        if (this.ayx != null) {
            if (!BM() || !this.ayB) {
                this.ayc.setVisibility(8);
            } else {
                this.ayc.setVisibility(0);
            }
            if (this.ayx.originalSize > 0 && !R(this.ayx.originalSize)) {
                this.ayc.setText(axZ + "(" + am.G(this.ayx.originalSize) + ")");
            } else {
                this.ayc.setText(axZ);
            }
            this.ayc.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    private boolean BM() {
        return (this.ayx == null || !this.ayx.mIsShowOrigonButton || this.ayx.isBlockedPic || StringUtils.isNull(this.ayx.originalUrl)) ? false : true;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.avN = bVar;
    }

    private boolean R(long j) {
        return j > aya;
    }
}
