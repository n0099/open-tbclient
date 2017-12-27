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
    private boolean bjY;
    private b bka;
    private boolean bkb;
    private Bitmap bmA;
    private boolean bmB;
    private float bmC;
    private Matrix bmD;
    private Rect bmE;
    private RectF bmF;
    private Rect bmG;
    private Rect bmH;
    private a.d bmI;
    private ImageUrlData bmK;
    private boolean bmL;
    private boolean bmM;
    private boolean bmN;
    public boolean bmO;
    private TextView bmP;
    private com.baidu.tbadk.img.b bmQ;
    private View.OnTouchListener bmR;
    private boolean bmS;
    private float bmT;
    private View.OnLongClickListener bmU;
    private Runnable bmV;
    private Runnable bmW;
    private View.OnTouchListener bmX;
    protected com.baidu.tbadk.widget.a bmo;
    protected TextView bmp;
    protected TextView bmq;
    protected TextView bmr;
    protected SubsamplingScaleImageView bms;
    private SubsamplingScaleImageView.OnImageEventListener bmt;
    private a bmu;
    private boolean bmv;
    private boolean bmw;
    private boolean bmx;
    private boolean bmy;
    private boolean bmz;
    protected Context mContext;
    private float mLastMotionX;
    private float mLastMotionY;
    private int mMaxHeight;
    private int mMaxWidth;
    private View.OnClickListener mOnClickListener;
    protected ProgressBar mProgressBar;
    private float mRatio;
    private int mSkinType;
    private static final String bmm = TbadkCoreApplication.getInst().getString(d.j.original_img_look);
    private static long bmn = 52428800;
    private static final int bmJ = l.aq(TbadkCoreApplication.getInst()) / 5;
    private static final String TAG = f.class.getSimpleName();
    private static final int TOUCH_SLOP = ViewConfiguration.get(TbadkCoreApplication.getInst()).getScaledTouchSlop();

    /* loaded from: classes.dex */
    public interface a {
        void j(String str, byte[] bArr);
    }

    /* loaded from: classes.dex */
    public interface b {
        void Js();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.bmp != null) {
                aj.s(this.bmp, d.f.btn_percent_yuantu);
                aj.b(this.bmp, d.C0108d.cp_cont_g, 1, 0);
            }
            if (this.bmq != null) {
                aj.t(this.bmq, d.C0108d.common_color_10022);
                aj.b(this.bmq, d.C0108d.cp_cont_g, 1, 0);
            }
            this.mSkinType = i;
        }
    }

    public void setHeadImage(boolean z) {
        if (this.bmo != null) {
            this.bmo.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.bmu = aVar;
    }

    public f(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mContext = null;
        this.mProgressBar = null;
        this.bmo = null;
        this.bmu = null;
        this.bjY = false;
        this.bmx = false;
        this.bmB = false;
        this.mRatio = 1.0f;
        this.bmC = 0.0f;
        this.bmD = new Matrix();
        this.bmF = new RectF();
        this.bmL = false;
        this.bmM = false;
        this.bmN = false;
        this.bmO = false;
        this.bmP = null;
        this.bmS = true;
        this.bmT = 0.0f;
        this.mOnClickListener = null;
        this.bmU = null;
        this.bmV = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.f.1
            @Override // java.lang.Runnable
            public void run() {
                f.this.bmS = true;
            }
        };
        this.bmW = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.f.7
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
                        f.this.bmp.setVisibility(8);
                        f.this.bmO = false;
                    }
                });
                f.this.bmp.startAnimation(alphaAnimation);
            }
        };
        this.bmX = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.f.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (f.this.bmR != null) {
                    f.this.bmR.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.bmQ = new com.baidu.tbadk.img.b();
        init();
    }

    public com.baidu.tbadk.widget.a getImageView() {
        return this.bmo;
    }

    public void setGifSetListener(a.e eVar) {
        this.bmo.setGifSetListener(eVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.bmo.setImageOnClickListener(onClickListener);
        this.bms.setOnClickListener(onClickListener);
        this.mOnClickListener = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bmU = onLongClickListener;
        if (!this.bkb) {
            this.bmo.setImageOnLongClickListener(this.bmU);
            this.bms.setOnLongClickListener(this.bmU);
        }
    }

    public void setOnSizeChangedListener(final a.f fVar) {
        this.bmo.setOnSizeChangedListener(new a.f() { // from class: com.baidu.tbadk.coreExtra.view.f.8
            @Override // com.baidu.tbadk.widget.a.f
            public void a(com.baidu.tbadk.widget.a aVar, boolean z, boolean z2) {
                if (fVar != null) {
                    fVar.a(aVar, z, z2);
                }
                f.this.Jg();
            }
        });
    }

    protected void init() {
        this.mMaxWidth = l.ao(this.mContext);
        this.mMaxHeight = l.aq(this.mContext) - ((int) this.mContext.getResources().getDimension(d.e.ds166));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.bmo = new com.baidu.tbadk.widget.a(this.mContext);
        this.bmo.setLayoutParams(layoutParams);
        this.bmo.setOnTouchListener(this.bmX);
        addView(this.bmo);
        this.bms = new SubsamplingScaleImageView(this.mContext);
        this.bms.setMaxScale(50.0f);
        this.bms.setOnTouchListener(this.bmX);
        this.bms.setVisibility(4);
        addView(this.bms, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(getResources().getDrawable(d.f.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        Jc();
        Ja();
        Jd();
    }

    private void Ja() {
        this.bmp = new TextView(this.mContext);
        aj.s(this.bmp, d.f.btn_percent_yuantu);
        this.bmp.setText(d.j.original_img_look);
        this.bmp.setTextSize(0, getResources().getDimensionPixelSize(d.e.fontsize28));
        aj.b(this.bmp, d.C0108d.cp_cont_g, 1, 0);
        this.bmp.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds20);
        this.bmp.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        this.bmp.setMinWidth(getResources().getDimensionPixelSize(d.e.ds220));
        this.bmp.setMinHeight(getResources().getDimensionPixelSize(d.e.ds68));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(d.e.fontsize40);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        this.bmp.setOnClickListener(this);
        this.bmp.setVisibility(8);
        addView(this.bmp, layoutParams);
    }

    public void setIsCanDrag(boolean z) {
        this.bkb = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        Bitmap imageBitmap;
        int height;
        int width;
        if (!this.bkb || !this.bmw) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.bmy && motionEvent.getPointerCount() >= 2) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.bmy || this.bmz) {
            requestDisallowInterceptTouchEvent(true);
        }
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        float x = motionEvent.getX();
        int i = action & 255;
        if (i == 0) {
            if (this.bmA == null) {
                if (this.bms.getVisibility() == 0) {
                    this.bmA = com.baidu.tbadk.util.d.bk(this.bms);
                } else {
                    this.bmA = com.baidu.tbadk.util.d.bk(this.bmo);
                }
            }
            if (this.bmE == null && this.bmA != null) {
                int measuredWidth = getMeasuredWidth();
                float measuredWidth2 = ((getMeasuredWidth() * 1.0f) / this.bmA.getWidth()) * this.bmA.getHeight();
                if (measuredWidth2 > getMeasuredHeight()) {
                    measuredWidth2 = getMeasuredHeight();
                }
                RectF h = h(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
                this.bmE = new Rect((int) h.left, (int) h.top, (int) h.right, (int) h.bottom);
            }
            if (this.bmH == null && this.bmA != null) {
                if (this.bms.getVisibility() == 0) {
                    height = this.bms.getSHeight();
                    width = this.bms.getSWidth();
                } else {
                    if (this.bmo.getImageType() == 1) {
                        imageBitmap = (this.bmo.getCurrentFrame() == null || this.bmo.getCurrentFrame().bCi == null) ? this.bmA : this.bmo.getCurrentFrame().bCi;
                    } else {
                        imageBitmap = this.bmo.getImageBitmap() == null ? this.bmA : this.bmo.getImageBitmap();
                    }
                    height = imageBitmap.getHeight();
                    width = imageBitmap.getWidth();
                }
                float ar = l.ar(getContext());
                int i2 = (int) (height * ar);
                int i3 = (int) (width * ar);
                if (i3 > this.bmA.getWidth() && this.bmA.getWidth() != 0) {
                    float width2 = (i3 * 1.0f) / this.bmA.getWidth();
                    i3 = this.bmA.getWidth();
                    i2 = (int) (i2 / width2);
                }
                if (i2 > this.bmA.getHeight() && this.bmA.getHeight() != 0) {
                    i3 = (int) (i3 / ((i2 * 1.0f) / this.bmA.getHeight()));
                    i2 = this.bmA.getHeight();
                }
                int aq = (l.aq(getContext()) - i2) / 2;
                int ao = (l.ao(getContext()) - i3) / 2;
                this.bmH = new Rect(ao, aq, i3 + ao, i2 + aq);
                this.bmG = new Rect(0, 0, this.bmA.getWidth(), this.bmA.getHeight());
            }
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (i == 2) {
            this.bmy = l(this.mLastMotionX - x, this.mLastMotionY - y);
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (this.bmy || this.bmz) {
            this.bmo.setImageOnLongClickListener(null);
            this.bms.setOnLongClickListener(null);
            z = true;
        } else {
            this.bmo.setImageOnLongClickListener(this.bmU);
            this.bms.setOnLongClickListener(this.bmU);
            z = super.dispatchTouchEvent(motionEvent);
        }
        if (i == 1 || i == 3) {
            this.mLastMotionX = 0.0f;
            this.mLastMotionY = 0.0f;
            this.bmB = false;
            this.bmD.reset();
            this.bmy = false;
            if (this.bmC > bmJ) {
                this.bmz = true;
                Jb();
                return z;
            }
            this.mRatio = 1.0f;
            invalidate();
            return z;
        }
        return z;
    }

    private boolean l(float f, float f2) {
        if (this.bms.getVisibility() != 0 || this.bms.isCanDrag()) {
            if (this.bmK == null || !this.bmK.isLongPic || this.bms.getVisibility() != 0 || this.bms.isViewTop()) {
                if (this.bmK == null || !this.bmK.isLongPic || this.bms.getVisibility() == 0 || this.bmo.Pa()) {
                    if (this.bms.getVisibility() == 0 || this.bmo.Pc()) {
                        if (this.bmA != null && getScrollY() == 0 && f2 < 0.0f && !this.bmB) {
                            this.bmB = true;
                            this.bmC = 0.0f;
                            this.mRatio = 1.0f;
                            if (this.bmI != null) {
                                this.bmI.Pt();
                            }
                        }
                        if (this.bmB) {
                            this.bmC -= f2;
                            int measuredHeight = getMeasuredHeight();
                            if (this.bmC > measuredHeight) {
                                this.bmC = measuredHeight;
                            }
                            float f3 = f2 / measuredHeight;
                            this.bmD.postTranslate((-f) * 1.5f * this.mRatio, (-1.5f) * f2 * this.mRatio);
                            if (this.mRatio * (1.0f + f3) > 1.0f || this.bmC < 0.0f) {
                                this.bmD.preScale(1.0f / this.mRatio, 1.0f / this.mRatio, (this.mRatio * this.bmA.getWidth()) / 2.0f, this.mRatio * (this.bmA.getHeight() / 2));
                                this.mRatio = 1.0f;
                            } else {
                                this.bmD.preScale(1.0f + f3, 1.0f + f3, (this.mRatio * this.bmA.getWidth()) / 2.0f, this.mRatio * (this.bmA.getHeight() / 2));
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
        if (this.bmy && this.bmA != null && !this.bmA.isRecycled() && this.bmB) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.bmF == null) {
                this.bmF = new RectF();
            }
            this.bmD.mapRect(this.bmF, new RectF(this.bmE));
            canvas.drawBitmap(this.bmA, this.bmG, this.bmF, (Paint) null);
        } else if (this.bmz && this.bmA != null && !this.bmA.isRecycled()) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.bmK == null || this.bmK.getSourceImageRectInScreen() == null) {
                canvas.drawBitmap(this.bmA, this.bmG, this.bmF, (Paint) null);
            } else {
                canvas.drawBitmap(this.bmA, this.bmH, this.bmF, (Paint) null);
            }
        } else {
            super.dispatchDraw(canvas);
        }
    }

    private void Jb() {
        if (this.bmK == null) {
            if (this.bmI != null) {
                this.bmI.Pu();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.bmK.getSourceImageRectInScreen();
        if (sourceImageRectInScreen == null) {
            if (this.bmI != null) {
                this.bmI.Pu();
                return;
            }
            return;
        }
        this.bmF.bottom = (((sourceImageRectInScreen.bottom - sourceImageRectInScreen.top) / (sourceImageRectInScreen.right - sourceImageRectInScreen.left)) * (this.bmF.right - this.bmF.left)) + this.bmF.top;
        final float[] fArr = {(this.bmF.left + this.bmF.right) / 2.0f, (this.bmF.top + this.bmF.bottom) / 2.0f};
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
                    f.this.bmF = f.this.h(floatValue, animatedFraction, sourceImageRectInScreen.right - sourceImageRectInScreen.left, sourceImageRectInScreen.bottom - sourceImageRectInScreen.top);
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
                f.this.bmB = false;
                f.this.invalidate();
                if (f.this.bmI != null) {
                    f.this.bmI.Pu();
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
        this.bmR = onTouchListener;
    }

    private void Jc() {
        this.bmP = new TextView(this.mContext);
        this.bmP.setBackgroundResource(d.f.bg_url_drag_imagview_fade_view);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.height = getResources().getDimensionPixelSize(d.e.ds180);
        layoutParams.addRule(12);
        addView(this.bmP, layoutParams);
        this.bmP.setVisibility(8);
    }

    private void Jd() {
        this.bmq = new TextView(this.mContext);
        aj.t(this.bmq, d.C0108d.common_color_10022);
        this.bmq.setText(d.j.goto_pb_floor);
        this.bmq.setTextSize(0, getResources().getDimensionPixelSize(d.e.fontsize24));
        aj.b(this.bmq, d.C0108d.cp_cont_g, 1, 0);
        this.bmq.setCompoundDrawablePadding(l.dip2px(this.mContext, 4.0f));
        this.bmq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_see_arrow), (Drawable) null);
        this.bmq.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds20);
        this.bmq.setPadding(dimensionPixelSize * 3, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(d.e.ds30);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(d.e.ds10);
        layoutParams.leftMargin = getResources().getDimensionPixelSize(d.e.ds20);
        layoutParams.addRule(1, this.bmp.getId());
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        this.bmq.setOnClickListener(this);
        this.bmq.setMinHeight(getResources().getDimensionPixelSize(d.e.ds100));
        addView(this.bmq, layoutParams);
        this.bmq.setVisibility(8);
    }

    private void Je() {
        if (this.bmq != null) {
            boolean z = this.bmv || this.bmw;
            if (!this.bmN && z && this.bmK != null && this.bmK.threadId > 0 && this.bmK.postId > 0 && this.bmK.mThreadType != 33 && !this.bmK.isBlockedPic) {
                this.bmq.setVisibility(0);
                if (this.bmP != null) {
                    this.bmP.setVisibility(0);
                    return;
                }
                return;
            }
            this.bmq.setVisibility(8);
            if (this.bmP != null) {
                this.bmP.setVisibility(8);
            }
        }
    }

    private void Jf() {
        if (this.bmq != null) {
            this.bmq.setVisibility(8);
            if (this.bmP != null) {
                this.bmP.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jg() {
        if ((this.bmv || this.bmw) && this.bmK != null && this.bmK.mPicType == 1 && !TextUtils.isEmpty(this.bmK.mTagName)) {
            if (this.bmr != null) {
                this.bmr.setVisibility(8);
                this.bmr = null;
            }
            this.bmr = new TextView(this.mContext);
            this.bmr.setText(this.bmK.mTagName);
            this.bmr.setTextSize(0, getResources().getDimensionPixelSize(d.e.fontsize26));
            aj.b(this.bmr, d.C0108d.common_color_10013, 1, 0);
            aj.t(this.bmr, d.C0108d.common_color_10215);
            this.bmr.setAlpha(0.75f);
            this.bmr.setIncludeFontPadding(false);
            this.bmr.setGravity(17);
            int s = l.s(this.mContext, d.e.ds2);
            this.bmr.setPadding(s, s, s, s);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.bmo.getBottomOffset();
            layoutParams.leftMargin = this.bmo.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.bmr, layoutParams);
            this.bmr.setVisibility(0);
        }
    }

    public void bR(boolean z) {
        this.bmN = z;
        if (this.bmN) {
            Jf();
        } else {
            Je();
        }
    }

    public void n(String str, boolean z) {
        if (str.contains("*")) {
            str = str.split("[*]")[0];
        }
        this.bmo.setTag(str);
        this.bmo.setLoadBigImage(false);
        this.bmo.setImageDrawable(null);
        this.bmv = false;
        this.bmw = false;
        this.bmL = Jn();
        this.bmp.setVisibility(8);
        if (fv(str)) {
            d(str, z, false);
        }
    }

    private boolean Jh() {
        return this.bmo != null && this.bmo.Pr();
    }

    public void Ji() {
        if (this.bmK != null && !Jh()) {
            String str = this.bmK.imageUrl;
            int i = this.bmK.urlType;
            com.baidu.adp.widget.a.a aVar = null;
            if (com.baidu.tbadk.core.util.c.a.v(str, i)) {
                aVar = com.baidu.tbadk.core.util.c.a.w(str, i);
            }
            if (aVar != null) {
                setThumbBitmapToView(aVar);
            }
        }
    }

    private boolean bS(boolean z) {
        String ee;
        if (!this.bmM || z) {
            this.bmM = true;
            if (!this.bmL || this.bmK == null || StringUtils.isNull(this.bmK.originalUrl, true) || this.bmK.originalSize < 0 || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String str = k.BJ() + al.CM().dW(ee) + "/" + ao.ee(this.bmK.originalUrl);
            final int[] dz = k.dz(str);
            this.bms.setVisibility(0);
            if (this.bmt == null) {
                this.bmt = new SubsamplingScaleImageView.OnImageEventListener() { // from class: com.baidu.tbadk.coreExtra.view.f.12
                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onReady() {
                        f.this.mProgressBar.setVisibility(8);
                        f.this.bmo.Pn();
                        f.this.bmo.setVisibility(4);
                    }

                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onImageLoaded() {
                        if (f.this.bmK.isLongPic && dz[0] > 0) {
                            f.this.bmo.onDestroy();
                            final float measuredWidth = (f.this.getMeasuredWidth() * 1.0f) / dz[0];
                            final PointF pointF = new PointF((dz[0] * 1.0f) / 2.0f, 0.0f);
                            f.this.bms.setScaleAndCenter(measuredWidth, pointF);
                            f.this.bms.setMaxScale(2.0f * measuredWidth);
                            f.this.bms.setDoubleTapZoomScale(2.0f * measuredWidth);
                            f.this.bms.setInitScale(measuredWidth);
                            f.this.bms.setDoubleTapZoomStyle(4);
                            f.this.bms.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.f.12.1
                                @Override // android.view.View.OnTouchListener
                                public boolean onTouch(View view, MotionEvent motionEvent) {
                                    if (f.this.bmR != null) {
                                        f.this.bmR.onTouch(view, motionEvent);
                                    }
                                    switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                                        case 0:
                                            f.this.bmT = motionEvent.getY();
                                            f.this.bms.setOnClickListener(f.this.bmS ? f.this.mOnClickListener : null);
                                            f.this.bms.setOnLongClickListener(f.this.bmS ? f.this.bmU : null);
                                            break;
                                        case 1:
                                        case 3:
                                            if (f.this.bms.getScale() < measuredWidth) {
                                                f.this.bms.setScaleAndCenter(measuredWidth, pointF);
                                            }
                                            com.baidu.adp.lib.g.e.nr().removeCallbacks(f.this.bmV);
                                            com.baidu.adp.lib.g.e.nr().postDelayed(f.this.bmV, 1000L);
                                            break;
                                        case 2:
                                            if (Math.abs(motionEvent.getY() - f.this.bmT) > f.TOUCH_SLOP) {
                                                f.this.bmS = false;
                                                f.this.bms.setOnClickListener(null);
                                                f.this.bms.setOnLongClickListener(null);
                                            }
                                            f.this.bmT = motionEvent.getY();
                                            break;
                                    }
                                    return false;
                                }
                            });
                            f.this.bmo.setVisibility(4);
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
            this.bms.setOnImageEventListener(this.bmt);
            if (this.bms.isImageLoaded() && this.bmK.isLongPic) {
                this.bmt.onImageLoaded();
            } else {
                this.bms.setImage(ImageSource.uri(str));
            }
            return true;
        }
        return false;
    }

    public void setDragToExitListener(a.d dVar) {
        this.bmI = dVar;
        if (this.bmo != null) {
            this.bmo.setDragToExitListener(dVar);
        }
    }

    public void Jj() {
        bS(false);
    }

    private boolean fv(String str) {
        return j.oI() || com.baidu.tbadk.core.util.c.c.es(str);
    }

    private void setThumbBitmapToView(com.baidu.adp.widget.a.a aVar) {
        Bitmap si;
        if (!this.bmw && aVar != null && (si = aVar.si()) != null) {
            this.bmv = true;
            if (aVar.isGif()) {
                this.bmo.setImageUrlData(this.bmK);
                this.bmo.setImageBitmap(si);
                this.bmp.setVisibility(8);
                this.bmO = false;
            } else {
                if (this.bmK != null && this.bmK.isLongPic) {
                    this.bmo.Pf();
                    this.bmo.setImageLoadCallBack(new com.baidu.tbadk.widget.a.b.a() { // from class: com.baidu.tbadk.coreExtra.view.f.13
                        @Override // com.baidu.tbadk.widget.a.b.a
                        public void Jr() {
                        }
                    });
                }
                this.bmo.setImageUrlData(this.bmK);
                this.bmo.a(si, aVar.sn());
            }
            Je();
            Jg();
        }
    }

    private void d(String str, boolean z, boolean z2) {
        if (fw(str)) {
            if (z2 || (!this.bmx && !this.bmw)) {
                if (!z2 || !bS(true)) {
                    this.bmx = true;
                    com.baidu.adp.lib.f.c.nl().a(str, 27, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.coreExtra.view.f.14
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onCancelled(String str2) {
                            f.this.bmx = false;
                            f.this.bmo.setVisibility(0);
                            f.this.mProgressBar.setVisibility(8);
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onLoaded(com.baidu.adp.widget.a.a aVar, String str2, int i) {
                            f.this.bmx = false;
                            f.this.bmw = true;
                            f.this.b(aVar);
                        }
                    }, 0, 0, false, null, Boolean.valueOf(z), this.bmo.getImageData(), Boolean.valueOf(this.bjY));
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
        com.baidu.adp.widget.a.a a2 = this.bmQ.a(imageFileInfo, false);
        if (a2 != null) {
            this.bmw = true;
            this.mProgressBar.setVisibility(8);
            b(a2);
            return;
        }
        this.bmQ.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.coreExtra.view.f.2
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.a.a aVar, String str2, boolean z3) {
                f.this.bmw = true;
                f.this.mProgressBar.setVisibility(8);
                f.this.b(aVar);
            }
        }, false);
    }

    private boolean fw(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith("https://"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null && this.bmu != null) {
            this.bmu.j(aVar.getUrl(), aVar.sn());
        }
        if (aVar == null || aVar.si() == null) {
            Jk();
            return;
        }
        Bitmap si = aVar.si();
        this.bmo.setLoadBigImage(true);
        if (aVar.isGif()) {
            this.bmo.a(aVar.sn(), si);
            this.bmo.invalidate();
            this.bmo.play();
            this.bmO = false;
            this.bmp.setVisibility(8);
            this.mProgressBar.setVisibility(8);
        } else {
            if (this.bmK != null && this.bmK.isLongPic) {
                this.bmo.Pf();
                this.bmo.setImageLoadCallBack(new com.baidu.tbadk.widget.a.b.a() { // from class: com.baidu.tbadk.coreExtra.view.f.3
                    @Override // com.baidu.tbadk.widget.a.b.a
                    public void Jr() {
                        f.this.mProgressBar.setVisibility(8);
                    }
                });
            } else {
                this.mProgressBar.setVisibility(8);
            }
            this.bmo.setImageUrlData(this.bmK);
            this.bmo.a(si, aVar.sn());
            Jo();
        }
        Je();
        Jg();
    }

    private void Jk() {
        if (!this.bmv) {
            this.bmo.Pk();
        } else {
            this.bmw = false;
        }
        this.bmp.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    public void setGifMaxUseableMem(int i) {
        this.bmo.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.bmo != null) {
            this.bmo.onDestroy();
        }
        if (this.bms != null) {
            this.bms.recycle();
        }
        if (this.bmA != null) {
            this.bmA.recycle();
            this.bmA = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.bmV);
    }

    public void release() {
        if (this.bmo != null) {
            this.bmo.release();
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.bmp != null) {
            this.bmp.setVisibility(8);
        }
    }

    public void Jl() {
        if (this.bmo != null && this.bmo.getImageType() == 1) {
            this.bmo.stop();
        }
    }

    public void l(boolean z, boolean z2) {
        String str;
        if (this.bmo != null && (str = (String) this.bmo.getTag()) != null) {
            if (this.bmo.getImageType() == 1) {
                if (this.bmo.getGifCache() == null || !this.bmo.Pr()) {
                    d(str, z, z2);
                }
            } else if (this.bmo.getImageType() == 2) {
                d(str, z, z2);
            } else if (Jm()) {
                d(str, z, z2);
            }
        }
    }

    private boolean Jm() {
        if (this.bmo.getImageBitmap() != null && this.bmo.Pr()) {
            if (this.bmK == null || !this.bmK.isLongPic || this.bmo.Pg()) {
                return false;
            }
            this.bmw = false;
            this.bmM = false;
            return true;
        }
        return true;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.bmK = imageUrlData;
    }

    public void setIsCdn(boolean z) {
        this.bjY = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bmp) {
            if (!(this.bmp.getTag() instanceof Boolean) || ((Boolean) this.bmp.getTag()).booleanValue()) {
                final String ee = ao.ee(this.bmK.originalUrl);
                if (this.bmK.originalProcess >= 0) {
                    com.baidu.tbadk.download.e.Kx().z(ee, 13);
                    this.bmK.originalProcess = -1;
                    Jo();
                    return;
                }
                if (this.bka != null) {
                    this.bka.Js();
                }
                com.baidu.adp.base.e<?> ak = i.ak(this.mContext);
                if (ak == null) {
                    fx(ee);
                } else if (!j.oI() || j.oJ() || com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("original_img_down_tip", false)) {
                    fx(ee);
                } else {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("original_img_down_tip", true);
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(ak.getPageActivity());
                    aVar.fd(d.j.original_img_down_no_wifi_tip);
                    aVar.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.f.4
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar.dismiss();
                            f.this.fx(ee);
                        }
                    });
                    aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.f.5
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar.dismiss();
                        }
                    });
                    aVar.b(ak);
                    aVar.AI();
                }
            }
        } else if (view == this.bmq && this.bmK != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mContext).createHistoryCfg(String.valueOf(this.bmK.threadId), String.valueOf(this.bmK.postId), this.bmK.mIsSeeHost, this.bmK.mIsReserver, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fx(String str) {
        if (this.bmK != null) {
            this.bmK.originalProcess = 0;
        }
        this.bmp.setText("0%");
        this.bmp.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_close_yuantu, 0);
        DownloadData downloadData = new DownloadData(str);
        downloadData.setStatus(1);
        downloadData.setUrl(this.bmK.originalUrl);
        downloadData.setType(13);
        downloadData.setPath(k.BJ() + al.CM().dW(str) + "/" + str);
        downloadData.setCallback(new com.baidu.tbadk.download.d() { // from class: com.baidu.tbadk.coreExtra.view.f.6
            @Override // com.baidu.tbadk.download.d
            public boolean onPreDownload(DownloadData downloadData2) {
                return true;
            }

            @Override // com.baidu.tbadk.download.d
            public void onFileUpdateProgress(DownloadData downloadData2) {
                if (downloadData2 != null) {
                    if (f.this.bmK != null && f.this.bmK.originalProcess != -1) {
                        f.this.bmK.originalProcess = downloadData2.getProcess();
                    }
                    if (f.this.bmK == null || f.this.bmK.originalProcess != -1) {
                        f.this.bmp.setText(downloadData2.getProcess() + "%");
                        f.this.bmp.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_close_yuantu, 0);
                    }
                }
            }

            @Override // com.baidu.tbadk.download.d
            public boolean onFileDownloaded(DownloadData downloadData2) {
                return true;
            }

            @Override // com.baidu.tbadk.download.d
            public void onFileDownloadSucceed(DownloadData downloadData2) {
                f.this.bmp.setText(f.this.getResources().getString(d.j.done));
                f.this.bmp.setTag(false);
                f.this.bmp.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                com.baidu.adp.lib.g.e.nr().postDelayed(f.this.bmW, 1500L);
                f.this.bmM = false;
                f.this.bmL = f.this.Jn();
                f.this.Jj();
            }

            @Override // com.baidu.tbadk.download.d
            public void onFileDownloadFailed(DownloadData downloadData2, int i, String str2) {
                f.this.bmM = false;
                BdToast.a(f.this.mContext, str2).AO().AQ();
                f.this.bmK.originalProcess = -1;
                f.this.Jo();
            }
        });
        com.baidu.tbadk.download.e.Kx().a(downloadData, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Jn() {
        if (this.bmK != null && !StringUtils.isNull(this.bmK.originalUrl, true) && this.bmK.originalSize >= 0 && !this.bmK.isBlockedPic) {
            String ee = ao.ee(this.bmK.originalUrl);
            File file = new File(k.BJ() + al.CM().dW(ee) + "/" + ee);
            if (file != null && file.exists()) {
                this.bmK.originalProcess = 100;
                return true;
            }
            if (this.bmK.originalProcess < 0) {
                Jo();
            } else {
                this.bmp.setText(this.bmK.originalProcess + "%");
                this.bmp.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_close_yuantu, 0);
            }
            this.bmO = true;
        } else {
            this.bmp.setVisibility(8);
        }
        return false;
    }

    public void Jo() {
        if (this.bmK != null) {
            if (!Jp() || !this.bmO) {
                this.bmp.setVisibility(8);
            } else {
                this.bmp.setVisibility(0);
            }
            if (this.bmK.originalSize > 0 && !Z(this.bmK.originalSize)) {
                this.bmp.setText(bmm + "(" + am.O(this.bmK.originalSize) + ")");
            } else {
                this.bmp.setText(bmm);
            }
            this.bmp.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    private boolean Jp() {
        return (this.bmK == null || !this.bmK.mIsShowOrigonButton || this.bmK.isBlockedPic || StringUtils.isNull(this.bmK.originalUrl)) ? false : true;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.bka = bVar;
    }

    private boolean Z(long j) {
        return j > bmn;
    }
}
