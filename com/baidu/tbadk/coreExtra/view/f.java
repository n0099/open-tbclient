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
    private boolean bki;
    private b bkk;
    private boolean bkl;
    protected TextView bmA;
    protected SubsamplingScaleImageView bmB;
    private SubsamplingScaleImageView.OnImageEventListener bmC;
    private a bmD;
    private boolean bmE;
    private boolean bmF;
    private boolean bmG;
    private boolean bmH;
    private boolean bmI;
    private Bitmap bmJ;
    private boolean bmK;
    private float bmL;
    private Matrix bmM;
    private Rect bmN;
    private RectF bmO;
    private Rect bmP;
    private Rect bmQ;
    private a.d bmR;
    private ImageUrlData bmT;
    private boolean bmU;
    private boolean bmV;
    private boolean bmW;
    public boolean bmX;
    private TextView bmY;
    private com.baidu.tbadk.img.b bmZ;
    protected com.baidu.tbadk.widget.a bmx;
    protected TextView bmy;
    protected TextView bmz;
    private View.OnTouchListener bna;
    private boolean bnb;
    private float bnc;
    private View.OnLongClickListener bnd;
    private Runnable bne;
    private Runnable bnf;
    private View.OnTouchListener bng;
    protected Context mContext;
    private float mLastMotionX;
    private float mLastMotionY;
    private int mMaxHeight;
    private int mMaxWidth;
    private View.OnClickListener mOnClickListener;
    protected ProgressBar mProgressBar;
    private float mRatio;
    private int mSkinType;
    private static final String bmv = TbadkCoreApplication.getInst().getString(d.j.original_img_look);
    private static long bmw = 52428800;
    private static final int bmS = l.aq(TbadkCoreApplication.getInst()) / 5;
    private static final String TAG = f.class.getSimpleName();
    private static final int TOUCH_SLOP = ViewConfiguration.get(TbadkCoreApplication.getInst()).getScaledTouchSlop();

    /* loaded from: classes.dex */
    public interface a {
        void j(String str, byte[] bArr);
    }

    /* loaded from: classes.dex */
    public interface b {
        void Jh();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.bmy != null) {
                aj.s(this.bmy, d.f.btn_percent_yuantu);
                aj.b(this.bmy, d.C0107d.cp_cont_g, 1, 0);
            }
            if (this.bmz != null) {
                aj.t(this.bmz, d.C0107d.common_color_10022);
                aj.b(this.bmz, d.C0107d.cp_cont_g, 1, 0);
            }
            this.mSkinType = i;
        }
    }

    public void setHeadImage(boolean z) {
        if (this.bmx != null) {
            this.bmx.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.bmD = aVar;
    }

    public f(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mContext = null;
        this.mProgressBar = null;
        this.bmx = null;
        this.bmD = null;
        this.bki = false;
        this.bmG = false;
        this.bmK = false;
        this.mRatio = 1.0f;
        this.bmL = 0.0f;
        this.bmM = new Matrix();
        this.bmO = new RectF();
        this.bmU = false;
        this.bmV = false;
        this.bmW = false;
        this.bmX = false;
        this.bmY = null;
        this.bnb = true;
        this.bnc = 0.0f;
        this.mOnClickListener = null;
        this.bnd = null;
        this.bne = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.f.1
            @Override // java.lang.Runnable
            public void run() {
                f.this.bnb = true;
            }
        };
        this.bnf = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.f.7
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
                        f.this.bmy.setVisibility(8);
                        f.this.bmX = false;
                    }
                });
                f.this.bmy.startAnimation(alphaAnimation);
            }
        };
        this.bng = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.f.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (f.this.bna != null) {
                    f.this.bna.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.bmZ = new com.baidu.tbadk.img.b();
        init();
    }

    public com.baidu.tbadk.widget.a getImageView() {
        return this.bmx;
    }

    public void setGifSetListener(a.e eVar) {
        this.bmx.setGifSetListener(eVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.bmx.setImageOnClickListener(onClickListener);
        this.bmB.setOnClickListener(onClickListener);
        this.mOnClickListener = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bnd = onLongClickListener;
        if (!this.bkl) {
            this.bmx.setImageOnLongClickListener(this.bnd);
            this.bmB.setOnLongClickListener(this.bnd);
        }
    }

    public void setOnSizeChangedListener(final a.f fVar) {
        this.bmx.setOnSizeChangedListener(new a.f() { // from class: com.baidu.tbadk.coreExtra.view.f.8
            @Override // com.baidu.tbadk.widget.a.f
            public void a(com.baidu.tbadk.widget.a aVar, boolean z, boolean z2) {
                if (fVar != null) {
                    fVar.a(aVar, z, z2);
                }
                f.this.IV();
            }
        });
    }

    protected void init() {
        this.mMaxWidth = l.ao(this.mContext);
        this.mMaxHeight = l.aq(this.mContext) - ((int) this.mContext.getResources().getDimension(d.e.ds166));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.bmx = new com.baidu.tbadk.widget.a(this.mContext);
        this.bmx.setLayoutParams(layoutParams);
        this.bmx.setOnTouchListener(this.bng);
        addView(this.bmx);
        this.bmB = new SubsamplingScaleImageView(this.mContext);
        this.bmB.setMaxScale(50.0f);
        this.bmB.setOnTouchListener(this.bng);
        this.bmB.setVisibility(4);
        addView(this.bmB, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(getResources().getDrawable(d.f.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        IR();
        IP();
        IS();
    }

    private void IP() {
        this.bmy = new TextView(this.mContext);
        aj.s(this.bmy, d.f.btn_percent_yuantu);
        this.bmy.setText(d.j.original_img_look);
        this.bmy.setTextSize(0, getResources().getDimensionPixelSize(d.e.fontsize28));
        aj.b(this.bmy, d.C0107d.cp_cont_g, 1, 0);
        this.bmy.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds20);
        this.bmy.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        this.bmy.setMinWidth(getResources().getDimensionPixelSize(d.e.ds220));
        this.bmy.setMinHeight(getResources().getDimensionPixelSize(d.e.ds68));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(d.e.fontsize40);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        this.bmy.setOnClickListener(this);
        this.bmy.setVisibility(8);
        addView(this.bmy, layoutParams);
    }

    public void setIsCanDrag(boolean z) {
        this.bkl = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        Bitmap imageBitmap;
        int height;
        int width;
        if (!this.bkl || !this.bmF) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.bmH && motionEvent.getPointerCount() >= 2) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.bmH || this.bmI) {
            requestDisallowInterceptTouchEvent(true);
        }
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        float x = motionEvent.getX();
        int i = action & 255;
        if (i == 0) {
            if (this.bmJ == null) {
                if (this.bmB.getVisibility() == 0) {
                    this.bmJ = com.baidu.tbadk.util.d.bm(this.bmB);
                } else {
                    this.bmJ = com.baidu.tbadk.util.d.bm(this.bmx);
                }
            }
            if (this.bmN == null && this.bmJ != null) {
                int measuredWidth = getMeasuredWidth();
                float measuredWidth2 = ((getMeasuredWidth() * 1.0f) / this.bmJ.getWidth()) * this.bmJ.getHeight();
                if (measuredWidth2 > getMeasuredHeight()) {
                    measuredWidth2 = getMeasuredHeight();
                }
                RectF h = h(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
                this.bmN = new Rect((int) h.left, (int) h.top, (int) h.right, (int) h.bottom);
            }
            if (this.bmQ == null && this.bmJ != null) {
                if (this.bmB.getVisibility() == 0) {
                    height = this.bmB.getSHeight();
                    width = this.bmB.getSWidth();
                } else {
                    if (this.bmx.getImageType() == 1) {
                        imageBitmap = (this.bmx.getCurrentFrame() == null || this.bmx.getCurrentFrame().bCr == null) ? this.bmJ : this.bmx.getCurrentFrame().bCr;
                    } else {
                        imageBitmap = this.bmx.getImageBitmap() == null ? this.bmJ : this.bmx.getImageBitmap();
                    }
                    height = imageBitmap.getHeight();
                    width = imageBitmap.getWidth();
                }
                float ar = l.ar(getContext());
                int i2 = (int) (height * ar);
                int i3 = (int) (width * ar);
                if (i3 > this.bmJ.getWidth() && this.bmJ.getWidth() != 0) {
                    float width2 = (i3 * 1.0f) / this.bmJ.getWidth();
                    i3 = this.bmJ.getWidth();
                    i2 = (int) (i2 / width2);
                }
                if (i2 > this.bmJ.getHeight() && this.bmJ.getHeight() != 0) {
                    i3 = (int) (i3 / ((i2 * 1.0f) / this.bmJ.getHeight()));
                    i2 = this.bmJ.getHeight();
                }
                int aq = (l.aq(getContext()) - i2) / 2;
                int ao = (l.ao(getContext()) - i3) / 2;
                this.bmQ = new Rect(ao, aq, i3 + ao, i2 + aq);
                this.bmP = new Rect(0, 0, this.bmJ.getWidth(), this.bmJ.getHeight());
            }
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (i == 2) {
            this.bmH = l(this.mLastMotionX - x, this.mLastMotionY - y);
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (this.bmH || this.bmI) {
            this.bmx.setImageOnLongClickListener(null);
            this.bmB.setOnLongClickListener(null);
            z = true;
        } else {
            this.bmx.setImageOnLongClickListener(this.bnd);
            this.bmB.setOnLongClickListener(this.bnd);
            z = super.dispatchTouchEvent(motionEvent);
        }
        if (i == 1 || i == 3) {
            this.mLastMotionX = 0.0f;
            this.mLastMotionY = 0.0f;
            this.bmK = false;
            this.bmM.reset();
            this.bmH = false;
            if (this.bmL > bmS) {
                this.bmI = true;
                IQ();
                return z;
            }
            this.mRatio = 1.0f;
            invalidate();
            return z;
        }
        return z;
    }

    private boolean l(float f, float f2) {
        if (this.bmB.getVisibility() != 0 || this.bmB.isCanDrag()) {
            if (this.bmT == null || !this.bmT.isLongPic || this.bmB.getVisibility() != 0 || this.bmB.isViewTop()) {
                if (this.bmT == null || !this.bmT.isLongPic || this.bmB.getVisibility() == 0 || this.bmx.OO()) {
                    if (this.bmB.getVisibility() == 0 || this.bmx.OQ()) {
                        if (this.bmJ != null && getScrollY() == 0 && f2 < 0.0f && !this.bmK) {
                            this.bmK = true;
                            this.bmL = 0.0f;
                            this.mRatio = 1.0f;
                            if (this.bmR != null) {
                                this.bmR.Ph();
                            }
                        }
                        if (this.bmK) {
                            this.bmL -= f2;
                            int measuredHeight = getMeasuredHeight();
                            if (this.bmL > measuredHeight) {
                                this.bmL = measuredHeight;
                            }
                            float f3 = f2 / measuredHeight;
                            this.bmM.postTranslate((-f) * 1.5f * this.mRatio, (-1.5f) * f2 * this.mRatio);
                            if (this.mRatio * (1.0f + f3) > 1.0f || this.bmL < 0.0f) {
                                this.bmM.preScale(1.0f / this.mRatio, 1.0f / this.mRatio, (this.mRatio * this.bmJ.getWidth()) / 2.0f, this.mRatio * (this.bmJ.getHeight() / 2));
                                this.mRatio = 1.0f;
                            } else {
                                this.bmM.preScale(1.0f + f3, 1.0f + f3, (this.mRatio * this.bmJ.getWidth()) / 2.0f, this.mRatio * (this.bmJ.getHeight() / 2));
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
        if (this.bmH && this.bmJ != null && !this.bmJ.isRecycled() && this.bmK) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.bmO == null) {
                this.bmO = new RectF();
            }
            this.bmM.mapRect(this.bmO, new RectF(this.bmN));
            canvas.drawBitmap(this.bmJ, this.bmP, this.bmO, (Paint) null);
        } else if (this.bmI && this.bmJ != null && !this.bmJ.isRecycled()) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.bmT == null || this.bmT.getSourceImageRectInScreen() == null) {
                canvas.drawBitmap(this.bmJ, this.bmP, this.bmO, (Paint) null);
            } else {
                canvas.drawBitmap(this.bmJ, this.bmQ, this.bmO, (Paint) null);
            }
        } else {
            super.dispatchDraw(canvas);
        }
    }

    private void IQ() {
        if (this.bmT == null) {
            if (this.bmR != null) {
                this.bmR.Pi();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.bmT.getSourceImageRectInScreen();
        if (sourceImageRectInScreen == null) {
            if (this.bmR != null) {
                this.bmR.Pi();
                return;
            }
            return;
        }
        this.bmO.bottom = (((sourceImageRectInScreen.bottom - sourceImageRectInScreen.top) / (sourceImageRectInScreen.right - sourceImageRectInScreen.left)) * (this.bmO.right - this.bmO.left)) + this.bmO.top;
        final float[] fArr = {(this.bmO.left + this.bmO.right) / 2.0f, (this.bmO.top + this.bmO.bottom) / 2.0f};
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
                    f.this.bmO = f.this.h(floatValue, animatedFraction, sourceImageRectInScreen.right - sourceImageRectInScreen.left, sourceImageRectInScreen.bottom - sourceImageRectInScreen.top);
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
                f.this.bmK = false;
                f.this.invalidate();
                if (f.this.bmR != null) {
                    f.this.bmR.Pi();
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
    public RectF h(float f, float f2, float f3, float f4) {
        return new RectF(f - (f3 / 2.0f), f2 - (f4 / 2.0f), (f3 / 2.0f) + f, (f4 / 2.0f) + f2);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.bna = onTouchListener;
    }

    private void IR() {
        this.bmY = new TextView(this.mContext);
        this.bmY.setBackgroundResource(d.f.bg_url_drag_imagview_fade_view);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.height = getResources().getDimensionPixelSize(d.e.ds180);
        layoutParams.addRule(12);
        addView(this.bmY, layoutParams);
        this.bmY.setVisibility(8);
    }

    private void IS() {
        this.bmz = new TextView(this.mContext);
        aj.t(this.bmz, d.C0107d.common_color_10022);
        this.bmz.setText(d.j.goto_pb_floor);
        this.bmz.setTextSize(0, getResources().getDimensionPixelSize(d.e.fontsize24));
        aj.b(this.bmz, d.C0107d.cp_cont_g, 1, 0);
        this.bmz.setCompoundDrawablePadding(l.dip2px(this.mContext, 4.0f));
        this.bmz.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_see_arrow), (Drawable) null);
        this.bmz.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds20);
        this.bmz.setPadding(dimensionPixelSize * 3, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(d.e.ds30);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(d.e.ds10);
        layoutParams.leftMargin = getResources().getDimensionPixelSize(d.e.ds20);
        layoutParams.addRule(1, this.bmy.getId());
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        this.bmz.setOnClickListener(this);
        this.bmz.setMinHeight(getResources().getDimensionPixelSize(d.e.ds100));
        addView(this.bmz, layoutParams);
        this.bmz.setVisibility(8);
    }

    private void IT() {
        if (this.bmz != null) {
            boolean z = this.bmE || this.bmF;
            if (!this.bmW && z && this.bmT != null && this.bmT.threadId > 0 && this.bmT.postId > 0 && this.bmT.mThreadType != 33 && !this.bmT.isBlockedPic) {
                this.bmz.setVisibility(0);
                if (this.bmY != null) {
                    this.bmY.setVisibility(0);
                    return;
                }
                return;
            }
            this.bmz.setVisibility(8);
            if (this.bmY != null) {
                this.bmY.setVisibility(8);
            }
        }
    }

    private void IU() {
        if (this.bmz != null) {
            this.bmz.setVisibility(8);
            if (this.bmY != null) {
                this.bmY.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IV() {
        if ((this.bmE || this.bmF) && this.bmT != null && this.bmT.mPicType == 1 && !TextUtils.isEmpty(this.bmT.mTagName)) {
            if (this.bmA != null) {
                this.bmA.setVisibility(8);
                this.bmA = null;
            }
            this.bmA = new TextView(this.mContext);
            this.bmA.setText(this.bmT.mTagName);
            this.bmA.setTextSize(0, getResources().getDimensionPixelSize(d.e.fontsize26));
            aj.b(this.bmA, d.C0107d.common_color_10013, 1, 0);
            aj.t(this.bmA, d.C0107d.common_color_10215);
            this.bmA.setAlpha(0.75f);
            this.bmA.setIncludeFontPadding(false);
            this.bmA.setGravity(17);
            int s = l.s(this.mContext, d.e.ds2);
            this.bmA.setPadding(s, s, s, s);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.bmx.getBottomOffset();
            layoutParams.leftMargin = this.bmx.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.bmA, layoutParams);
            this.bmA.setVisibility(0);
        }
    }

    public void bP(boolean z) {
        this.bmW = z;
        if (this.bmW) {
            IU();
        } else {
            IT();
        }
    }

    public void n(String str, boolean z) {
        if (str.contains("*")) {
            str = str.split("[*]")[0];
        }
        this.bmx.setTag(str);
        this.bmx.setLoadBigImage(false);
        this.bmx.setImageDrawable(null);
        this.bmE = false;
        this.bmF = false;
        this.bmU = Jc();
        this.bmy.setVisibility(8);
        if (fw(str)) {
            d(str, z, false);
        }
    }

    private boolean IW() {
        return this.bmx != null && this.bmx.Pf();
    }

    public void IX() {
        if (this.bmT != null && !IW()) {
            String str = this.bmT.imageUrl;
            int i = this.bmT.urlType;
            com.baidu.adp.widget.a.a aVar = null;
            if (com.baidu.tbadk.core.util.c.a.v(str, i)) {
                aVar = com.baidu.tbadk.core.util.c.a.w(str, i);
            }
            if (aVar != null) {
                setThumbBitmapToView(aVar);
            }
        }
    }

    private boolean bQ(boolean z) {
        String ee;
        if (!this.bmV || z) {
            this.bmV = true;
            if (!this.bmU || this.bmT == null || StringUtils.isNull(this.bmT.originalUrl, true) || this.bmT.originalSize < 0 || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String str = k.BB() + al.CE().dW(ee) + "/" + ao.ee(this.bmT.originalUrl);
            final int[] dz = k.dz(str);
            this.bmB.setVisibility(0);
            if (this.bmC == null) {
                this.bmC = new SubsamplingScaleImageView.OnImageEventListener() { // from class: com.baidu.tbadk.coreExtra.view.f.12
                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onReady() {
                        f.this.mProgressBar.setVisibility(8);
                        f.this.bmx.Pb();
                        f.this.bmx.setVisibility(4);
                    }

                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onImageLoaded() {
                        if (f.this.bmT.isLongPic && dz[0] > 0) {
                            f.this.bmx.onDestroy();
                            final float measuredWidth = (f.this.getMeasuredWidth() * 1.0f) / dz[0];
                            final PointF pointF = new PointF((dz[0] * 1.0f) / 2.0f, 0.0f);
                            f.this.bmB.setScaleAndCenter(measuredWidth, pointF);
                            f.this.bmB.setMaxScale(2.0f * measuredWidth);
                            f.this.bmB.setDoubleTapZoomScale(2.0f * measuredWidth);
                            f.this.bmB.setInitScale(measuredWidth);
                            f.this.bmB.setDoubleTapZoomStyle(4);
                            f.this.bmB.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.f.12.1
                                @Override // android.view.View.OnTouchListener
                                public boolean onTouch(View view, MotionEvent motionEvent) {
                                    if (f.this.bna != null) {
                                        f.this.bna.onTouch(view, motionEvent);
                                    }
                                    switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                                        case 0:
                                            f.this.bnc = motionEvent.getY();
                                            f.this.bmB.setOnClickListener(f.this.bnb ? f.this.mOnClickListener : null);
                                            f.this.bmB.setOnLongClickListener(f.this.bnb ? f.this.bnd : null);
                                            break;
                                        case 1:
                                        case 3:
                                            if (f.this.bmB.getScale() < measuredWidth) {
                                                f.this.bmB.setScaleAndCenter(measuredWidth, pointF);
                                            }
                                            com.baidu.adp.lib.g.e.nr().removeCallbacks(f.this.bne);
                                            com.baidu.adp.lib.g.e.nr().postDelayed(f.this.bne, 1000L);
                                            break;
                                        case 2:
                                            if (Math.abs(motionEvent.getY() - f.this.bnc) > f.TOUCH_SLOP) {
                                                f.this.bnb = false;
                                                f.this.bmB.setOnClickListener(null);
                                                f.this.bmB.setOnLongClickListener(null);
                                            }
                                            f.this.bnc = motionEvent.getY();
                                            break;
                                    }
                                    return false;
                                }
                            });
                            f.this.bmx.setVisibility(4);
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
            this.bmB.setOnImageEventListener(this.bmC);
            if (this.bmB.isImageLoaded() && this.bmT.isLongPic) {
                this.bmC.onImageLoaded();
            } else {
                this.bmB.setImage(ImageSource.uri(str));
            }
            return true;
        }
        return false;
    }

    public void setDragToExitListener(a.d dVar) {
        this.bmR = dVar;
        if (this.bmx != null) {
            this.bmx.setDragToExitListener(dVar);
        }
    }

    public void IY() {
        bQ(false);
    }

    private boolean fw(String str) {
        return j.oI() || com.baidu.tbadk.core.util.c.c.es(str);
    }

    private void setThumbBitmapToView(com.baidu.adp.widget.a.a aVar) {
        Bitmap si;
        if (!this.bmF && aVar != null && (si = aVar.si()) != null) {
            this.bmE = true;
            if (aVar.isGif()) {
                this.bmx.setImageUrlData(this.bmT);
                this.bmx.setImageBitmap(si);
                this.bmy.setVisibility(8);
                this.bmX = false;
            } else {
                if (this.bmT != null && this.bmT.isLongPic) {
                    this.bmx.OT();
                    this.bmx.setImageLoadCallBack(new com.baidu.tbadk.widget.a.b.a() { // from class: com.baidu.tbadk.coreExtra.view.f.13
                        @Override // com.baidu.tbadk.widget.a.b.a
                        public void Jg() {
                        }
                    });
                }
                this.bmx.setImageUrlData(this.bmT);
                this.bmx.a(si, aVar.sn());
            }
            IT();
            IV();
        }
    }

    private void d(String str, boolean z, boolean z2) {
        if (fx(str)) {
            if (z2 || (!this.bmG && !this.bmF)) {
                if (!z2 || !bQ(true)) {
                    this.bmG = true;
                    com.baidu.adp.lib.f.c.nl().a(str, 27, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.coreExtra.view.f.14
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onCancelled(String str2) {
                            f.this.bmG = false;
                            f.this.bmx.setVisibility(0);
                            f.this.mProgressBar.setVisibility(8);
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onLoaded(com.baidu.adp.widget.a.a aVar, String str2, int i) {
                            f.this.bmG = false;
                            f.this.bmF = true;
                            f.this.b(aVar);
                        }
                    }, 0, 0, false, null, Boolean.valueOf(z), this.bmx.getImageData(), Boolean.valueOf(this.bki));
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
        com.baidu.adp.widget.a.a a2 = this.bmZ.a(imageFileInfo, false);
        if (a2 != null) {
            this.bmF = true;
            this.mProgressBar.setVisibility(8);
            b(a2);
            return;
        }
        this.bmZ.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.coreExtra.view.f.2
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.a.a aVar, String str2, boolean z3) {
                f.this.bmF = true;
                f.this.mProgressBar.setVisibility(8);
                f.this.b(aVar);
            }
        }, false);
    }

    private boolean fx(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith("https://"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null && this.bmD != null) {
            this.bmD.j(aVar.getUrl(), aVar.sn());
        }
        if (aVar == null || aVar.si() == null) {
            IZ();
            return;
        }
        Bitmap si = aVar.si();
        this.bmx.setLoadBigImage(true);
        if (aVar.isGif()) {
            this.bmx.a(aVar.sn(), si);
            this.bmx.invalidate();
            this.bmx.play();
            this.bmX = false;
            this.bmy.setVisibility(8);
            this.mProgressBar.setVisibility(8);
        } else {
            if (this.bmT != null && this.bmT.isLongPic) {
                this.bmx.OT();
                this.bmx.setImageLoadCallBack(new com.baidu.tbadk.widget.a.b.a() { // from class: com.baidu.tbadk.coreExtra.view.f.3
                    @Override // com.baidu.tbadk.widget.a.b.a
                    public void Jg() {
                        f.this.mProgressBar.setVisibility(8);
                    }
                });
            } else {
                this.mProgressBar.setVisibility(8);
            }
            this.bmx.setImageUrlData(this.bmT);
            this.bmx.a(si, aVar.sn());
            Jd();
        }
        IT();
        IV();
    }

    private void IZ() {
        if (!this.bmE) {
            this.bmx.OY();
        } else {
            this.bmF = false;
        }
        this.bmy.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    public void setGifMaxUseableMem(int i) {
        this.bmx.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.bmx != null) {
            this.bmx.onDestroy();
        }
        if (this.bmB != null) {
            this.bmB.recycle();
        }
        if (this.bmJ != null) {
            this.bmJ.recycle();
            this.bmJ = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.bne);
    }

    public void release() {
        if (this.bmx != null) {
            this.bmx.release();
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.bmy != null) {
            this.bmy.setVisibility(8);
        }
    }

    public void Ja() {
        if (this.bmx != null && this.bmx.getImageType() == 1) {
            this.bmx.stop();
        }
    }

    public void l(boolean z, boolean z2) {
        String str;
        if (this.bmx != null && (str = (String) this.bmx.getTag()) != null) {
            if (this.bmx.getImageType() == 1) {
                if (this.bmx.getGifCache() == null || !this.bmx.Pf()) {
                    d(str, z, z2);
                }
            } else if (this.bmx.getImageType() == 2) {
                d(str, z, z2);
            } else if (Jb()) {
                d(str, z, z2);
            }
        }
    }

    private boolean Jb() {
        if (this.bmx.getImageBitmap() != null && this.bmx.Pf()) {
            if (this.bmT == null || !this.bmT.isLongPic || this.bmx.OU()) {
                return false;
            }
            this.bmF = false;
            this.bmV = false;
            return true;
        }
        return true;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.bmT = imageUrlData;
    }

    public void setIsCdn(boolean z) {
        this.bki = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bmy) {
            if (!(this.bmy.getTag() instanceof Boolean) || ((Boolean) this.bmy.getTag()).booleanValue()) {
                final String ee = ao.ee(this.bmT.originalUrl);
                if (this.bmT.originalProcess >= 0) {
                    com.baidu.tbadk.download.e.Km().z(ee, 13);
                    this.bmT.originalProcess = -1;
                    Jd();
                    return;
                }
                if (this.bkk != null) {
                    this.bkk.Jh();
                }
                com.baidu.adp.base.e<?> ak = i.ak(this.mContext);
                if (ak == null) {
                    fy(ee);
                } else if (!j.oI() || j.oJ() || com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("original_img_down_tip", false)) {
                    fy(ee);
                } else {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("original_img_down_tip", true);
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(ak.getPageActivity());
                    aVar.fb(d.j.original_img_down_no_wifi_tip);
                    aVar.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.f.4
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar.dismiss();
                            f.this.fy(ee);
                        }
                    });
                    aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.f.5
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar.dismiss();
                        }
                    });
                    aVar.b(ak);
                    aVar.AA();
                }
            }
        } else if (view == this.bmz && this.bmT != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mContext).createHistoryCfg(String.valueOf(this.bmT.threadId), String.valueOf(this.bmT.postId), this.bmT.mIsSeeHost, this.bmT.mIsReserver, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fy(String str) {
        if (this.bmT != null) {
            this.bmT.originalProcess = 0;
        }
        this.bmy.setText("0%");
        this.bmy.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_close_yuantu, 0);
        DownloadData downloadData = new DownloadData(str);
        downloadData.setStatus(1);
        downloadData.setUrl(this.bmT.originalUrl);
        downloadData.setType(13);
        downloadData.setPath(k.BB() + al.CE().dW(str) + "/" + str);
        downloadData.setCallback(new com.baidu.tbadk.download.d() { // from class: com.baidu.tbadk.coreExtra.view.f.6
            @Override // com.baidu.tbadk.download.d
            public boolean onPreDownload(DownloadData downloadData2) {
                return true;
            }

            @Override // com.baidu.tbadk.download.d
            public void onFileUpdateProgress(DownloadData downloadData2) {
                if (downloadData2 != null) {
                    if (f.this.bmT != null && f.this.bmT.originalProcess != -1) {
                        f.this.bmT.originalProcess = downloadData2.getProcess();
                    }
                    if (f.this.bmT == null || f.this.bmT.originalProcess != -1) {
                        f.this.bmy.setText(downloadData2.getProcess() + "%");
                        f.this.bmy.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_close_yuantu, 0);
                    }
                }
            }

            @Override // com.baidu.tbadk.download.d
            public boolean onFileDownloaded(DownloadData downloadData2) {
                return true;
            }

            @Override // com.baidu.tbadk.download.d
            public void onFileDownloadSucceed(DownloadData downloadData2) {
                f.this.bmy.setText(f.this.getResources().getString(d.j.done));
                f.this.bmy.setTag(false);
                f.this.bmy.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                com.baidu.adp.lib.g.e.nr().postDelayed(f.this.bnf, 1500L);
                f.this.bmV = false;
                f.this.bmU = f.this.Jc();
                f.this.IY();
            }

            @Override // com.baidu.tbadk.download.d
            public void onFileDownloadFailed(DownloadData downloadData2, int i, String str2) {
                f.this.bmV = false;
                BdToast.a(f.this.mContext, str2).AG().AI();
                f.this.bmT.originalProcess = -1;
                f.this.Jd();
            }
        });
        com.baidu.tbadk.download.e.Km().a(downloadData, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Jc() {
        if (this.bmT != null && !StringUtils.isNull(this.bmT.originalUrl, true) && this.bmT.originalSize >= 0 && !this.bmT.isBlockedPic) {
            String ee = ao.ee(this.bmT.originalUrl);
            File file = new File(k.BB() + al.CE().dW(ee) + "/" + ee);
            if (file != null && file.exists()) {
                this.bmT.originalProcess = 100;
                return true;
            }
            if (this.bmT.originalProcess < 0) {
                Jd();
            } else {
                this.bmy.setText(this.bmT.originalProcess + "%");
                this.bmy.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_close_yuantu, 0);
            }
            this.bmX = true;
        } else {
            this.bmy.setVisibility(8);
        }
        return false;
    }

    public void Jd() {
        if (this.bmT != null) {
            if (!Je() || !this.bmX) {
                this.bmy.setVisibility(8);
            } else {
                this.bmy.setVisibility(0);
            }
            if (this.bmT.originalSize > 0 && !Z(this.bmT.originalSize)) {
                this.bmy.setText(bmv + "(" + am.O(this.bmT.originalSize) + ")");
            } else {
                this.bmy.setText(bmv);
            }
            this.bmy.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    private boolean Je() {
        return (this.bmT == null || !this.bmT.mIsShowOrigonButton || this.bmT.isBlockedPic || StringUtils.isNull(this.bmT.originalUrl)) ? false : true;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.bkk = bVar;
    }

    private boolean Z(long j) {
        return j > bmw;
    }
}
