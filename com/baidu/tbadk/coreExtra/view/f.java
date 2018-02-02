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
    private boolean bkq;
    private b bks;
    private boolean bkt;
    protected com.baidu.tbadk.widget.a bmF;
    protected TextView bmG;
    protected TextView bmH;
    protected TextView bmI;
    protected SubsamplingScaleImageView bmJ;
    private SubsamplingScaleImageView.OnImageEventListener bmK;
    private a bmL;
    private boolean bmM;
    private boolean bmN;
    private boolean bmO;
    private boolean bmP;
    private boolean bmQ;
    private Bitmap bmR;
    private boolean bmS;
    private float bmT;
    private Matrix bmU;
    private Rect bmV;
    private RectF bmW;
    private Rect bmX;
    private Rect bmY;
    private a.d bmZ;
    private String bnb;
    private ImageUrlData bnc;
    private boolean bnd;
    private boolean bne;
    private boolean bnf;
    public boolean bng;
    private TextView bnh;
    private com.baidu.tbadk.img.b bni;
    private View.OnTouchListener bnj;
    private boolean bnk;
    private float bnl;
    private View.OnLongClickListener bnm;
    private Runnable bnn;
    private Runnable bno;
    private View.OnTouchListener bnp;
    protected Context mContext;
    private float mLastMotionX;
    private float mLastMotionY;
    private int mMaxHeight;
    private int mMaxWidth;
    private View.OnClickListener mOnClickListener;
    protected ProgressBar mProgressBar;
    private float mRatio;
    private int mSkinType;
    private static final String bmD = TbadkCoreApplication.getInst().getString(d.j.original_img_look);
    private static long bmE = 52428800;
    private static final int bna = l.aq(TbadkCoreApplication.getInst()) / 5;
    private static final String TAG = f.class.getSimpleName();
    private static final int TOUCH_SLOP = ViewConfiguration.get(TbadkCoreApplication.getInst()).getScaledTouchSlop();

    /* loaded from: classes.dex */
    public interface a {
        void k(String str, byte[] bArr);
    }

    /* loaded from: classes.dex */
    public interface b {
        void Jj();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.bmG != null) {
                aj.s(this.bmG, d.f.btn_percent_yuantu);
                aj.b(this.bmG, d.C0108d.cp_cont_g, 1, 0);
            }
            if (this.bmH != null) {
                aj.t(this.bmH, d.C0108d.common_color_10022);
                aj.b(this.bmH, d.C0108d.cp_cont_g, 1, 0);
            }
            this.mSkinType = i;
        }
    }

    public void setHeadImage(boolean z) {
        if (this.bmF != null) {
            this.bmF.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.bmL = aVar;
    }

    public f(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mContext = null;
        this.mProgressBar = null;
        this.bmF = null;
        this.bmL = null;
        this.bkq = false;
        this.bmO = false;
        this.bmS = false;
        this.mRatio = 1.0f;
        this.bmT = 0.0f;
        this.bmU = new Matrix();
        this.bmW = new RectF();
        this.bnd = false;
        this.bne = false;
        this.bnf = false;
        this.bng = false;
        this.bnh = null;
        this.bnk = true;
        this.bnl = 0.0f;
        this.mOnClickListener = null;
        this.bnm = null;
        this.bnn = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.f.1
            @Override // java.lang.Runnable
            public void run() {
                f.this.bnk = true;
            }
        };
        this.bno = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.f.7
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
                        f.this.bmG.setVisibility(8);
                        f.this.bng = false;
                    }
                });
                f.this.bmG.startAnimation(alphaAnimation);
            }
        };
        this.bnp = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.f.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (f.this.bnj != null) {
                    f.this.bnj.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.bni = new com.baidu.tbadk.img.b();
        init();
    }

    public com.baidu.tbadk.widget.a getImageView() {
        return this.bmF;
    }

    public void setGifSetListener(a.e eVar) {
        this.bmF.setGifSetListener(eVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.bmF.setImageOnClickListener(onClickListener);
        this.bmJ.setOnClickListener(onClickListener);
        this.mOnClickListener = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bnm = onLongClickListener;
        if (!this.bkt) {
            this.bmF.setImageOnLongClickListener(this.bnm);
            this.bmJ.setOnLongClickListener(this.bnm);
        }
    }

    public void setOnSizeChangedListener(final a.f fVar) {
        this.bmF.setOnSizeChangedListener(new a.f() { // from class: com.baidu.tbadk.coreExtra.view.f.8
            @Override // com.baidu.tbadk.widget.a.f
            public void a(com.baidu.tbadk.widget.a aVar, boolean z, boolean z2) {
                if (fVar != null) {
                    fVar.a(aVar, z, z2);
                }
                f.this.IX();
            }
        });
    }

    protected void init() {
        this.mMaxWidth = l.ao(this.mContext);
        this.mMaxHeight = l.aq(this.mContext) - ((int) this.mContext.getResources().getDimension(d.e.ds166));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.bmF = new com.baidu.tbadk.widget.a(this.mContext);
        this.bmF.setLayoutParams(layoutParams);
        this.bmF.setOnTouchListener(this.bnp);
        addView(this.bmF);
        this.bmJ = new SubsamplingScaleImageView(this.mContext);
        this.bmJ.setMaxScale(50.0f);
        this.bmJ.setOnTouchListener(this.bnp);
        this.bmJ.setVisibility(4);
        addView(this.bmJ, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(getResources().getDrawable(d.f.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        IT();
        IR();
        IU();
    }

    private void IR() {
        this.bnb = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        this.bmG = new TextView(this.mContext);
        aj.s(this.bmG, d.f.btn_percent_yuantu);
        this.bmG.setText(d.j.original_img_look);
        this.bmG.setTextSize(0, getResources().getDimensionPixelSize(d.e.fontsize28));
        aj.b(this.bmG, d.C0108d.cp_cont_g, 1, 0);
        this.bmG.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds20);
        this.bmG.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        this.bmG.setMinWidth(getResources().getDimensionPixelSize(d.e.ds220));
        this.bmG.setMinHeight(getResources().getDimensionPixelSize(d.e.ds68));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(d.e.fontsize40);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        this.bmG.setOnClickListener(this);
        this.bmG.setVisibility(8);
        addView(this.bmG, layoutParams);
    }

    public void setIsCanDrag(boolean z) {
        this.bkt = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        Bitmap imageBitmap;
        int height;
        int width;
        if (!this.bkt || !this.bmN) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.bmP && motionEvent.getPointerCount() >= 2) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.bmP || this.bmQ) {
            requestDisallowInterceptTouchEvent(true);
        }
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        float x = motionEvent.getX();
        int i = action & 255;
        if (i == 0) {
            if (this.bmR == null) {
                if (this.bmJ.getVisibility() == 0) {
                    this.bmR = com.baidu.tbadk.util.d.bm(this.bmJ);
                } else {
                    this.bmR = com.baidu.tbadk.util.d.bm(this.bmF);
                }
            }
            if (this.bmV == null && this.bmR != null) {
                int measuredWidth = getMeasuredWidth();
                float measuredWidth2 = ((getMeasuredWidth() * 1.0f) / this.bmR.getWidth()) * this.bmR.getHeight();
                if (measuredWidth2 > getMeasuredHeight()) {
                    measuredWidth2 = getMeasuredHeight();
                }
                RectF h = h(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
                this.bmV = new Rect((int) h.left, (int) h.top, (int) h.right, (int) h.bottom);
            }
            if (this.bmY == null && this.bmR != null) {
                if (this.bmJ.getVisibility() == 0) {
                    height = this.bmJ.getSHeight();
                    width = this.bmJ.getSWidth();
                } else {
                    if (this.bmF.getImageType() == 1) {
                        imageBitmap = (this.bmF.getCurrentFrame() == null || this.bmF.getCurrentFrame().bCz == null) ? this.bmR : this.bmF.getCurrentFrame().bCz;
                    } else {
                        imageBitmap = this.bmF.getImageBitmap() == null ? this.bmR : this.bmF.getImageBitmap();
                    }
                    height = imageBitmap.getHeight();
                    width = imageBitmap.getWidth();
                }
                float ar = l.ar(getContext());
                int i2 = (int) (height * ar);
                int i3 = (int) (width * ar);
                if (i3 > this.bmR.getWidth() && this.bmR.getWidth() != 0) {
                    float width2 = (i3 * 1.0f) / this.bmR.getWidth();
                    i3 = this.bmR.getWidth();
                    i2 = (int) (i2 / width2);
                }
                if (i2 > this.bmR.getHeight() && this.bmR.getHeight() != 0) {
                    i3 = (int) (i3 / ((i2 * 1.0f) / this.bmR.getHeight()));
                    i2 = this.bmR.getHeight();
                }
                int aq = (l.aq(getContext()) - i2) / 2;
                int ao = (l.ao(getContext()) - i3) / 2;
                this.bmY = new Rect(ao, aq, i3 + ao, i2 + aq);
                this.bmX = new Rect(0, 0, this.bmR.getWidth(), this.bmR.getHeight());
            }
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (i == 2) {
            this.bmP = l(this.mLastMotionX - x, this.mLastMotionY - y);
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (this.bmP || this.bmQ) {
            this.bmF.setImageOnLongClickListener(null);
            this.bmJ.setOnLongClickListener(null);
            z = true;
        } else {
            this.bmF.setImageOnLongClickListener(this.bnm);
            this.bmJ.setOnLongClickListener(this.bnm);
            z = super.dispatchTouchEvent(motionEvent);
        }
        if (i == 1 || i == 3) {
            this.mLastMotionX = 0.0f;
            this.mLastMotionY = 0.0f;
            this.bmS = false;
            this.bmU.reset();
            this.bmP = false;
            if (this.bmT > bna) {
                this.bmQ = true;
                IS();
                return z;
            }
            this.mRatio = 1.0f;
            invalidate();
            return z;
        }
        return z;
    }

    private boolean l(float f, float f2) {
        if (this.bmJ.getVisibility() != 0 || this.bmJ.isCanDrag()) {
            if (this.bnc == null || !this.bnc.isLongPic || this.bmJ.getVisibility() != 0 || this.bmJ.isViewTop()) {
                if (this.bnc == null || !this.bnc.isLongPic || this.bmJ.getVisibility() == 0 || this.bmF.OQ()) {
                    if (this.bmJ.getVisibility() == 0 || this.bmF.OS()) {
                        if (this.bmR != null && getScrollY() == 0 && f2 < 0.0f && !this.bmS) {
                            this.bmS = true;
                            this.bmT = 0.0f;
                            this.mRatio = 1.0f;
                            if (this.bmZ != null) {
                                this.bmZ.Pj();
                            }
                        }
                        if (this.bmS) {
                            this.bmT -= f2;
                            int measuredHeight = getMeasuredHeight();
                            if (this.bmT > measuredHeight) {
                                this.bmT = measuredHeight;
                            }
                            float f3 = f2 / measuredHeight;
                            this.bmU.postTranslate((-f) * 1.5f * this.mRatio, (-1.5f) * f2 * this.mRatio);
                            if (this.mRatio * (1.0f + f3) > 1.0f || this.bmT < 0.0f) {
                                this.bmU.preScale(1.0f / this.mRatio, 1.0f / this.mRatio, (this.mRatio * this.bmR.getWidth()) / 2.0f, this.mRatio * (this.bmR.getHeight() / 2));
                                this.mRatio = 1.0f;
                            } else {
                                this.bmU.preScale(1.0f + f3, 1.0f + f3, (this.mRatio * this.bmR.getWidth()) / 2.0f, this.mRatio * (this.bmR.getHeight() / 2));
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
        if (this.bmP && this.bmR != null && !this.bmR.isRecycled() && this.bmS) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.bmW == null) {
                this.bmW = new RectF();
            }
            this.bmU.mapRect(this.bmW, new RectF(this.bmV));
            canvas.drawBitmap(this.bmR, this.bmX, this.bmW, (Paint) null);
        } else if (this.bmQ && this.bmR != null && !this.bmR.isRecycled()) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.bnc == null || this.bnc.getSourceImageRectInScreen() == null) {
                canvas.drawBitmap(this.bmR, this.bmX, this.bmW, (Paint) null);
            } else {
                canvas.drawBitmap(this.bmR, this.bmY, this.bmW, (Paint) null);
            }
        } else {
            super.dispatchDraw(canvas);
        }
    }

    private void IS() {
        if (this.bnc == null) {
            if (this.bmZ != null) {
                this.bmZ.Pk();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.bnc.getSourceImageRectInScreen();
        if (sourceImageRectInScreen == null) {
            if (this.bmZ != null) {
                this.bmZ.Pk();
                return;
            }
            return;
        }
        this.bmW.bottom = (((sourceImageRectInScreen.bottom - sourceImageRectInScreen.top) / (sourceImageRectInScreen.right - sourceImageRectInScreen.left)) * (this.bmW.right - this.bmW.left)) + this.bmW.top;
        final float[] fArr = {(this.bmW.left + this.bmW.right) / 2.0f, (this.bmW.top + this.bmW.bottom) / 2.0f};
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
                    f.this.bmW = f.this.h(floatValue, animatedFraction, sourceImageRectInScreen.right - sourceImageRectInScreen.left, sourceImageRectInScreen.bottom - sourceImageRectInScreen.top);
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
                f.this.bmS = false;
                f.this.invalidate();
                if (f.this.bmZ != null) {
                    f.this.bmZ.Pk();
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
        this.bnj = onTouchListener;
    }

    private void IT() {
        this.bnh = new TextView(this.mContext);
        this.bnh.setBackgroundResource(d.f.bg_url_drag_imagview_fade_view);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.height = getResources().getDimensionPixelSize(d.e.ds180);
        layoutParams.addRule(12);
        addView(this.bnh, layoutParams);
        this.bnh.setVisibility(8);
    }

    private void IU() {
        this.bmH = new TextView(this.mContext);
        aj.t(this.bmH, d.C0108d.common_color_10022);
        this.bmH.setText(d.j.goto_pb_floor);
        this.bmH.setTextSize(0, getResources().getDimensionPixelSize(d.e.fontsize24));
        aj.b(this.bmH, d.C0108d.cp_cont_g, 1, 0);
        this.bmH.setCompoundDrawablePadding(l.dip2px(this.mContext, 4.0f));
        this.bmH.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_see_arrow), (Drawable) null);
        this.bmH.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds20);
        this.bmH.setPadding(dimensionPixelSize * 3, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(d.e.ds30);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(d.e.ds10);
        layoutParams.leftMargin = getResources().getDimensionPixelSize(d.e.ds20);
        layoutParams.addRule(1, this.bmG.getId());
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        this.bmH.setOnClickListener(this);
        this.bmH.setMinHeight(getResources().getDimensionPixelSize(d.e.ds100));
        addView(this.bmH, layoutParams);
        this.bmH.setVisibility(8);
    }

    private void IV() {
        if (this.bmH != null) {
            boolean z = this.bmM || this.bmN;
            if (!this.bnf && z && this.bnc != null && this.bnc.threadId > 0 && this.bnc.postId > 0 && this.bnc.mThreadType != 33 && !this.bnc.isBlockedPic) {
                this.bmH.setVisibility(0);
                if (this.bnh != null) {
                    this.bnh.setVisibility(0);
                    return;
                }
                return;
            }
            this.bmH.setVisibility(8);
            if (this.bnh != null) {
                this.bnh.setVisibility(8);
            }
        }
    }

    private void IW() {
        if (this.bmH != null) {
            this.bmH.setVisibility(8);
            if (this.bnh != null) {
                this.bnh.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IX() {
        if ((this.bmM || this.bmN) && this.bnc != null && this.bnc.mPicType == 1 && !TextUtils.isEmpty(this.bnc.mTagName)) {
            if (this.bmI != null) {
                this.bmI.setVisibility(8);
                this.bmI = null;
            }
            this.bmI = new TextView(this.mContext);
            this.bmI.setText(this.bnc.mTagName);
            this.bmI.setTextSize(0, getResources().getDimensionPixelSize(d.e.fontsize26));
            aj.b(this.bmI, d.C0108d.common_color_10013, 1, 0);
            aj.t(this.bmI, d.C0108d.common_color_10215);
            this.bmI.setAlpha(0.75f);
            this.bmI.setIncludeFontPadding(false);
            this.bmI.setGravity(17);
            int s = l.s(this.mContext, d.e.ds2);
            this.bmI.setPadding(s, s, s, s);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.bmF.getBottomOffset();
            layoutParams.leftMargin = this.bmF.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.bmI, layoutParams);
            this.bmI.setVisibility(0);
        }
    }

    public void bQ(boolean z) {
        this.bnf = z;
        if (this.bnf) {
            IW();
        } else {
            IV();
        }
    }

    public void n(String str, boolean z) {
        if (str.contains("*")) {
            str = str.split("[*]")[0];
        }
        this.bmF.setTag(str);
        this.bmF.setLoadBigImage(false);
        this.bmF.setImageDrawable(null);
        this.bmM = false;
        this.bmN = false;
        this.bnd = Je();
        this.bmG.setVisibility(8);
        if (fE(str)) {
            b(str, z, false);
        }
    }

    private boolean IY() {
        return this.bmF != null && this.bmF.Ph();
    }

    public void IZ() {
        if (this.bnc != null && !IY()) {
            String str = this.bnc.imageUrl;
            int i = this.bnc.urlType;
            com.baidu.adp.widget.a.a aVar = null;
            if (com.baidu.tbadk.core.util.d.a.v(str, i)) {
                aVar = com.baidu.tbadk.core.util.d.a.w(str, i);
            }
            if (aVar != null) {
                setThumbBitmapToView(aVar);
            }
        }
    }

    private boolean bR(boolean z) {
        String ej;
        if (!this.bne || z) {
            this.bne = true;
            if (!this.bnd || this.bnc == null || StringUtils.isNull(this.bnc.originalUrl, true) || this.bnc.originalSize < 0 || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String str = this.bnb + al.CF().ec(ej) + "/" + ao.ej(this.bnc.originalUrl);
            final int[] dD = k.dD(str);
            this.bmJ.setVisibility(0);
            if (this.bmK == null) {
                this.bmK = new SubsamplingScaleImageView.OnImageEventListener() { // from class: com.baidu.tbadk.coreExtra.view.f.12
                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onReady() {
                        f.this.mProgressBar.setVisibility(8);
                        f.this.bmF.Pd();
                        f.this.bmF.setVisibility(4);
                    }

                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onImageLoaded() {
                        if (f.this.bnc.isLongPic && dD[0] > 0) {
                            f.this.bmF.onDestroy();
                            final float measuredWidth = (f.this.getMeasuredWidth() * 1.0f) / dD[0];
                            final PointF pointF = new PointF((dD[0] * 1.0f) / 2.0f, 0.0f);
                            f.this.bmJ.setScaleAndCenter(measuredWidth, pointF);
                            f.this.bmJ.setMaxScale(2.0f * measuredWidth);
                            f.this.bmJ.setDoubleTapZoomScale(2.0f * measuredWidth);
                            f.this.bmJ.setInitScale(measuredWidth);
                            f.this.bmJ.setDoubleTapZoomStyle(4);
                            f.this.bmJ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.f.12.1
                                @Override // android.view.View.OnTouchListener
                                public boolean onTouch(View view, MotionEvent motionEvent) {
                                    if (f.this.bnj != null) {
                                        f.this.bnj.onTouch(view, motionEvent);
                                    }
                                    switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                                        case 0:
                                            f.this.bnl = motionEvent.getY();
                                            f.this.bmJ.setOnClickListener(f.this.bnk ? f.this.mOnClickListener : null);
                                            f.this.bmJ.setOnLongClickListener(f.this.bnk ? f.this.bnm : null);
                                            break;
                                        case 1:
                                        case 3:
                                            if (f.this.bmJ.getScale() < measuredWidth) {
                                                f.this.bmJ.setScaleAndCenter(measuredWidth, pointF);
                                            }
                                            com.baidu.adp.lib.g.e.ns().removeCallbacks(f.this.bnn);
                                            com.baidu.adp.lib.g.e.ns().postDelayed(f.this.bnn, 1000L);
                                            break;
                                        case 2:
                                            if (Math.abs(motionEvent.getY() - f.this.bnl) > f.TOUCH_SLOP) {
                                                f.this.bnk = false;
                                                f.this.bmJ.setOnClickListener(null);
                                                f.this.bmJ.setOnLongClickListener(null);
                                            }
                                            f.this.bnl = motionEvent.getY();
                                            break;
                                    }
                                    return false;
                                }
                            });
                            f.this.bmF.setVisibility(4);
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
            this.bmJ.setOnImageEventListener(this.bmK);
            if (this.bmJ.isImageLoaded() && this.bnc.isLongPic) {
                this.bmK.onImageLoaded();
            } else {
                this.bmJ.setImage(ImageSource.uri(str));
            }
            return true;
        }
        return false;
    }

    public void setDragToExitListener(a.d dVar) {
        this.bmZ = dVar;
        if (this.bmF != null) {
            this.bmF.setDragToExitListener(dVar);
        }
    }

    public void Ja() {
        bR(false);
    }

    private boolean fE(String str) {
        return j.oJ() || com.baidu.tbadk.core.util.d.c.eA(str);
    }

    private void setThumbBitmapToView(com.baidu.adp.widget.a.a aVar) {
        Bitmap sj;
        if (!this.bmN && aVar != null && (sj = aVar.sj()) != null) {
            this.bmM = true;
            if (aVar.isGif()) {
                this.bmF.setImageUrlData(this.bnc);
                this.bmF.setImageBitmap(sj);
                this.bmG.setVisibility(8);
                this.bng = false;
            } else {
                if (this.bnc != null && this.bnc.isLongPic) {
                    this.bmF.OV();
                    this.bmF.setImageLoadCallBack(new com.baidu.tbadk.widget.a.b.a() { // from class: com.baidu.tbadk.coreExtra.view.f.13
                        @Override // com.baidu.tbadk.widget.a.b.a
                        public void Ji() {
                        }
                    });
                }
                this.bmF.setImageUrlData(this.bnc);
                this.bmF.a(sj, aVar.so());
            }
            IV();
            IX();
        }
    }

    private void b(String str, boolean z, boolean z2) {
        if (fF(str)) {
            if (z2 || (!this.bmO && !this.bmN)) {
                if (!z2 || !bR(true)) {
                    this.bmO = true;
                    com.baidu.adp.lib.f.c.nm().a(str, 27, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.coreExtra.view.f.14
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onCancelled(String str2) {
                            f.this.bmO = false;
                            f.this.bmF.setVisibility(0);
                            f.this.mProgressBar.setVisibility(8);
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onLoaded(com.baidu.adp.widget.a.a aVar, String str2, int i) {
                            f.this.bmO = false;
                            f.this.bmN = true;
                            f.this.b(aVar);
                        }
                    }, 0, 0, false, null, Boolean.valueOf(z), this.bmF.getImageData(), Boolean.valueOf(this.bkq));
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
        com.baidu.adp.widget.a.a a2 = this.bni.a(imageFileInfo, false);
        if (a2 != null) {
            this.bmN = true;
            this.mProgressBar.setVisibility(8);
            b(a2);
            return;
        }
        this.bni.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.coreExtra.view.f.2
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.a.a aVar, String str2, boolean z3) {
                f.this.bmN = true;
                f.this.mProgressBar.setVisibility(8);
                f.this.b(aVar);
            }
        }, false);
    }

    private boolean fF(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith("https://"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null && this.bmL != null) {
            this.bmL.k(aVar.getUrl(), aVar.so());
        }
        if (aVar == null || aVar.sj() == null) {
            Jb();
            return;
        }
        Bitmap sj = aVar.sj();
        this.bmF.setLoadBigImage(true);
        if (aVar.isGif()) {
            this.bmF.a(aVar.so(), sj);
            this.bmF.invalidate();
            this.bmF.play();
            this.bng = false;
            this.bmG.setVisibility(8);
            this.mProgressBar.setVisibility(8);
        } else {
            if (this.bnc != null && this.bnc.isLongPic) {
                this.bmF.OV();
                this.bmF.setImageLoadCallBack(new com.baidu.tbadk.widget.a.b.a() { // from class: com.baidu.tbadk.coreExtra.view.f.3
                    @Override // com.baidu.tbadk.widget.a.b.a
                    public void Ji() {
                        f.this.mProgressBar.setVisibility(8);
                    }
                });
            } else {
                this.mProgressBar.setVisibility(8);
            }
            this.bmF.setImageUrlData(this.bnc);
            this.bmF.a(sj, aVar.so());
            Jf();
        }
        IV();
        IX();
    }

    private void Jb() {
        if (!this.bmM) {
            this.bmF.Pa();
        } else {
            this.bmN = false;
        }
        this.bmG.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    public void setGifMaxUseableMem(int i) {
        this.bmF.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.bmF != null) {
            this.bmF.onDestroy();
        }
        if (this.bmJ != null) {
            this.bmJ.recycle();
        }
        if (this.bmR != null) {
            this.bmR.recycle();
            this.bmR = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.bnn);
    }

    public void release() {
        if (this.bmF != null) {
            this.bmF.release();
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.bmG != null) {
            this.bmG.setVisibility(8);
        }
    }

    public void Jc() {
        if (this.bmF != null && this.bmF.getImageType() == 1) {
            this.bmF.stop();
        }
    }

    public void l(boolean z, boolean z2) {
        String str;
        if (this.bmF != null && (str = (String) this.bmF.getTag()) != null) {
            if (this.bmF.getImageType() == 1) {
                if (this.bmF.getGifCache() == null || !this.bmF.Ph()) {
                    b(str, z, z2);
                }
            } else if (this.bmF.getImageType() == 2) {
                b(str, z, z2);
            } else if (Jd()) {
                b(str, z, z2);
            }
        }
    }

    private boolean Jd() {
        if (this.bmF.getImageBitmap() != null && this.bmF.Ph()) {
            if (this.bnc == null || !this.bnc.isLongPic || this.bmF.OW()) {
                return false;
            }
            this.bmN = false;
            this.bne = false;
            return true;
        }
        return true;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.bnc = imageUrlData;
    }

    public void setIsCdn(boolean z) {
        this.bkq = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bmG) {
            if (!(this.bmG.getTag() instanceof Boolean) || ((Boolean) this.bmG.getTag()).booleanValue()) {
                final String ej = ao.ej(this.bnc.originalUrl);
                if (this.bnc.originalProcess >= 0) {
                    com.baidu.tbadk.download.e.Ko().z(ej, 13);
                    this.bnc.originalProcess = -1;
                    Jf();
                    return;
                }
                if (this.bks != null) {
                    this.bks.Jj();
                }
                com.baidu.adp.base.e<?> ak = i.ak(this.mContext);
                if (ak == null) {
                    fG(ej);
                } else if (!j.oJ() || j.oK() || com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("original_img_down_tip", false)) {
                    fG(ej);
                } else {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("original_img_down_tip", true);
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(ak.getPageActivity());
                    aVar.fb(d.j.original_img_down_no_wifi_tip);
                    aVar.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.f.4
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar.dismiss();
                            f.this.fG(ej);
                        }
                    });
                    aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.f.5
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar.dismiss();
                        }
                    });
                    aVar.b(ak);
                    aVar.AB();
                }
            }
        } else if (view == this.bmH && this.bnc != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mContext).createHistoryCfg(String.valueOf(this.bnc.threadId), String.valueOf(this.bnc.postId), this.bnc.mIsSeeHost, this.bnc.mIsReserver, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fG(String str) {
        if (this.bnc != null) {
            this.bnc.originalProcess = 0;
        }
        this.bmG.setText("0%");
        this.bmG.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_close_yuantu, 0);
        DownloadData downloadData = new DownloadData(str);
        downloadData.setStatus(1);
        downloadData.setUrl(this.bnc.originalUrl);
        downloadData.setType(13);
        downloadData.setPath(this.bnb + al.CF().ec(str) + "/" + str);
        downloadData.setCallback(new com.baidu.tbadk.download.d() { // from class: com.baidu.tbadk.coreExtra.view.f.6
            @Override // com.baidu.tbadk.download.d
            public boolean onPreDownload(DownloadData downloadData2) {
                return true;
            }

            @Override // com.baidu.tbadk.download.d
            public void onFileUpdateProgress(DownloadData downloadData2) {
                if (downloadData2 != null) {
                    if (f.this.bnc != null && f.this.bnc.originalProcess != -1) {
                        f.this.bnc.originalProcess = downloadData2.getProcess();
                    }
                    if (f.this.bnc == null || f.this.bnc.originalProcess != -1) {
                        f.this.bmG.setText(downloadData2.getProcess() + "%");
                        f.this.bmG.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_close_yuantu, 0);
                    }
                }
            }

            @Override // com.baidu.tbadk.download.d
            public boolean onFileDownloaded(DownloadData downloadData2) {
                return true;
            }

            @Override // com.baidu.tbadk.download.d
            public void onFileDownloadSucceed(DownloadData downloadData2) {
                f.this.bmG.setText(f.this.getResources().getString(d.j.done));
                f.this.bmG.setTag(false);
                f.this.bmG.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                com.baidu.adp.lib.g.e.ns().postDelayed(f.this.bno, 1500L);
                f.this.bne = false;
                f.this.bnd = f.this.Je();
                f.this.Ja();
            }

            @Override // com.baidu.tbadk.download.d
            public void onFileDownloadFailed(DownloadData downloadData2, int i, String str2) {
                f.this.bne = false;
                BdToast.a(f.this.mContext, str2).AH().AJ();
                f.this.bnc.originalProcess = -1;
                f.this.Jf();
            }
        });
        com.baidu.tbadk.download.e.Ko().a(downloadData, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Je() {
        if (this.bnc != null && !StringUtils.isNull(this.bnc.originalUrl, true) && this.bnc.originalSize >= 0 && !this.bnc.isBlockedPic) {
            String ej = ao.ej(this.bnc.originalUrl);
            File file = new File(this.bnb + al.CF().ec(ej) + "/" + ej);
            if (file != null && file.exists()) {
                this.bnc.originalProcess = 100;
                return true;
            }
            if (this.bnc.originalProcess < 0) {
                Jf();
            } else {
                this.bmG.setText(this.bnc.originalProcess + "%");
                this.bmG.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_close_yuantu, 0);
            }
            this.bng = true;
        } else {
            this.bmG.setVisibility(8);
        }
        return false;
    }

    public void Jf() {
        if (this.bnc != null) {
            if (!Jg() || !this.bng) {
                this.bmG.setVisibility(8);
            } else {
                this.bmG.setVisibility(0);
            }
            if (this.bnc.originalSize > 0 && !Z(this.bnc.originalSize)) {
                this.bmG.setText(bmD + "(" + am.O(this.bnc.originalSize) + ")");
            } else {
                this.bmG.setText(bmD);
            }
            this.bmG.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    private boolean Jg() {
        return (this.bnc == null || !this.bnc.mIsShowOrigonButton || this.bnc.isBlockedPic || StringUtils.isNull(this.bnc.originalUrl)) ? false : true;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.bks = bVar;
    }

    private boolean Z(long j) {
        return j > bmE;
    }
}
