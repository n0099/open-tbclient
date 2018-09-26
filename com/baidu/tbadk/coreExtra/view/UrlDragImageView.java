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
import android.util.AttributeSet;
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
import com.baidu.mobstat.Config;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.d.c;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.effect.d;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.e;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.File;
/* loaded from: classes2.dex */
public class UrlDragImageView extends RelativeLayout implements View.OnClickListener {
    private boolean aKI;
    private b aKK;
    private boolean aKL;
    private boolean aKM;
    protected DragImageView aLO;
    protected TextView aLP;
    protected TextView aLQ;
    protected TextView aLR;
    protected SubsamplingScaleImageView aLS;
    private SubsamplingScaleImageView.OnImageEventListener aLT;
    private a aLU;
    private boolean aLV;
    private boolean aLW;
    private boolean aLX;
    private boolean aLY;
    private boolean aLZ;
    private boolean aMA;
    private float aMB;
    private View.OnLongClickListener aMC;
    private Runnable aMD;
    private Runnable aME;
    private View.OnTouchListener aMF;
    private Bitmap aMa;
    private boolean aMb;
    private float aMc;
    private Matrix aMd;
    private Rect aMe;
    private RectF aMf;
    private RectF aMg;
    private Rect aMh;
    private Rect aMi;
    private Rect aMj;
    private DragImageView.d aMk;
    private String aMm;
    private float aMn;
    private float aMo;
    private float aMp;
    private float aMq;
    private float aMr;
    private ImageUrlData aMs;
    private boolean aMt;
    private boolean aMu;
    private boolean aMv;
    public boolean aMw;
    private TextView aMx;
    private com.baidu.tbadk.img.b aMy;
    private View.OnTouchListener aMz;
    protected Context mContext;
    private float mLastMotionX;
    private float mLastMotionY;
    private int mMaxHeight;
    private int mMaxWidth;
    private View.OnClickListener mOnClickListener;
    protected ProgressBar mProgressBar;
    private float mRatio;
    private int mSkinType;
    private static final String aLM = TbadkCoreApplication.getInst().getString(e.j.original_img_look);
    private static long aLN = Config.RAVEN_LOG_LIMIT;
    private static final int aMl = l.aQ(TbadkCoreApplication.getInst()) / 5;
    private static final String TAG = UrlDragImageView.class.getSimpleName();
    private static final int TOUCH_SLOP = ViewConfiguration.get(TbadkCoreApplication.getInst()).getScaledTouchSlop();

    /* loaded from: classes2.dex */
    public interface a {
        void j(String str, byte[] bArr);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void HB();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.aLP != null) {
                al.i(this.aLP, e.f.btn_percent_yuantu);
                al.b(this.aLP, e.d.cp_cont_g, 1, 0);
            }
            if (this.aLQ != null) {
                al.j(this.aLQ, e.d.common_color_10022);
                al.b(this.aLQ, e.d.cp_cont_g, 1, 0);
            }
            this.mSkinType = i;
        }
    }

    public void setHeadImage(boolean z) {
        if (this.aLO != null) {
            this.aLO.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.aLU = aVar;
    }

    public UrlDragImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mContext = null;
        this.mProgressBar = null;
        this.aLO = null;
        this.aLU = null;
        this.aKI = false;
        this.aLX = false;
        this.aMb = false;
        this.mRatio = 1.0f;
        this.aMc = 0.0f;
        this.aMd = new Matrix();
        this.aMf = new RectF();
        this.aMn = 0.0f;
        this.aMo = 0.0f;
        this.aMp = 1.0f;
        this.aMq = 1.0f;
        this.aMr = 0.0f;
        this.aMt = false;
        this.aMu = false;
        this.aMv = false;
        this.aMw = false;
        this.aMx = null;
        this.aMA = true;
        this.aMB = 0.0f;
        this.mOnClickListener = null;
        this.aMC = null;
        this.aMD = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.aMA = true;
            }
        };
        this.aME = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
            @Override // java.lang.Runnable
            public void run() {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(200L);
                alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        UrlDragImageView.this.aLP.setVisibility(8);
                        UrlDragImageView.this.aMw = false;
                    }
                });
                UrlDragImageView.this.aLP.startAnimation(alphaAnimation);
            }
        };
        this.aMF = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.aMz != null) {
                    UrlDragImageView.this.aMz.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.aMy = new com.baidu.tbadk.img.b();
        init();
    }

    public UrlDragImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.mContext = null;
        this.mProgressBar = null;
        this.aLO = null;
        this.aLU = null;
        this.aKI = false;
        this.aLX = false;
        this.aMb = false;
        this.mRatio = 1.0f;
        this.aMc = 0.0f;
        this.aMd = new Matrix();
        this.aMf = new RectF();
        this.aMn = 0.0f;
        this.aMo = 0.0f;
        this.aMp = 1.0f;
        this.aMq = 1.0f;
        this.aMr = 0.0f;
        this.aMt = false;
        this.aMu = false;
        this.aMv = false;
        this.aMw = false;
        this.aMx = null;
        this.aMA = true;
        this.aMB = 0.0f;
        this.mOnClickListener = null;
        this.aMC = null;
        this.aMD = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.aMA = true;
            }
        };
        this.aME = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
            @Override // java.lang.Runnable
            public void run() {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(200L);
                alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        UrlDragImageView.this.aLP.setVisibility(8);
                        UrlDragImageView.this.aMw = false;
                    }
                });
                UrlDragImageView.this.aLP.startAnimation(alphaAnimation);
            }
        };
        this.aMF = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.aMz != null) {
                    UrlDragImageView.this.aMz.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.aMy = new com.baidu.tbadk.img.b();
        init();
    }

    public DragImageView getImageView() {
        return this.aLO;
    }

    public void setGifSetListener(DragImageView.e eVar) {
        this.aLO.setGifSetListener(eVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.aLO.setImageOnClickListener(onClickListener);
        this.aLS.setOnClickListener(onClickListener);
        this.mOnClickListener = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aMC = onLongClickListener;
        if (!this.aKL) {
            this.aLO.setImageOnLongClickListener(this.aMC);
            this.aLS.setOnLongClickListener(this.aMC);
        }
    }

    public void setOnSizeChangedListener(final DragImageView.g gVar) {
        this.aLO.setOnSizeChangedListener(new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.8
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (gVar != null) {
                    gVar.a(dragImageView, z, z2);
                }
                UrlDragImageView.this.Hp();
            }
        });
    }

    protected void init() {
        this.mMaxWidth = l.aO(this.mContext);
        this.mMaxHeight = l.aQ(this.mContext) - ((int) this.mContext.getResources().getDimension(e.C0141e.ds166));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.aLO = new DragImageView(this.mContext);
        this.aLO.setLayoutParams(layoutParams);
        this.aLO.setOnTouchListener(this.aMF);
        addView(this.aLO);
        this.aLS = new SubsamplingScaleImageView(this.mContext);
        this.aLS.setMaxScale(50.0f);
        this.aLS.setOnTouchListener(this.aMF);
        this.aLS.setVisibility(4);
        addView(this.aLS, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(getResources().getDrawable(e.f.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        Hl();
        Hj();
        Hm();
    }

    private void Hj() {
        this.aMm = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        this.aLP = new TextView(this.mContext);
        al.i(this.aLP, e.f.btn_percent_yuantu);
        this.aLP.setText(e.j.original_img_look);
        this.aLP.setTextSize(0, getResources().getDimensionPixelSize(e.C0141e.fontsize28));
        al.b(this.aLP, e.d.cp_cont_i, 1, 0);
        this.aLP.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(e.C0141e.ds16);
        this.aLP.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        this.aLP.setMinWidth(getResources().getDimensionPixelSize(e.C0141e.ds222));
        this.aLP.setMinHeight(getResources().getDimensionPixelSize(e.C0141e.ds60));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(e.C0141e.fontsize40);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        this.aLP.setOnClickListener(this);
        this.aLP.setVisibility(8);
        addView(this.aLP, layoutParams);
    }

    public void setIsCanDrag(boolean z) {
        this.aKL = z;
    }

    public void setIsHotSort(boolean z) {
        this.aKM = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        Bitmap imageBitmap;
        int height;
        int width;
        if (!this.aKL || !this.aLW) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.aLY && motionEvent.getPointerCount() >= 2) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.aLY || this.aLZ) {
            requestDisallowInterceptTouchEvent(true);
        }
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        float x = motionEvent.getX();
        int i = action & 255;
        if (i == 0) {
            if (this.aMa == null) {
                if (this.aLS.getVisibility() == 0) {
                    this.aMa = com.baidu.tbadk.util.e.af(this.aLS);
                } else {
                    this.aMa = com.baidu.tbadk.util.e.af(this.aLO);
                }
            }
            if (this.aMe == null && this.aMa != null) {
                int measuredWidth = getMeasuredWidth();
                float measuredWidth2 = ((getMeasuredWidth() * 1.0f) / this.aMa.getWidth()) * this.aMa.getHeight();
                if (measuredWidth2 > getMeasuredHeight()) {
                    measuredWidth2 = getMeasuredHeight();
                }
                RectF h = h(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
                this.aMe = new Rect((int) h.left, (int) h.top, (int) h.right, (int) h.bottom);
            }
            if (this.aMi == null && this.aMa != null) {
                if (this.aLS.getVisibility() == 0) {
                    height = this.aLS.getSHeight();
                    width = this.aLS.getSWidth();
                } else {
                    if (this.aLO.getImageType() == 1) {
                        imageBitmap = (this.aLO.getCurrentFrame() == null || this.aLO.getCurrentFrame().bbh == null) ? this.aMa : this.aLO.getCurrentFrame().bbh;
                    } else {
                        imageBitmap = this.aLO.getImageBitmap() == null ? this.aMa : this.aLO.getImageBitmap();
                    }
                    height = imageBitmap.getHeight();
                    width = imageBitmap.getWidth();
                }
                float aR = l.aR(getContext());
                int i2 = (int) (height * aR);
                int i3 = (int) (width * aR);
                if (i3 > this.aMa.getWidth() && this.aMa.getWidth() != 0) {
                    float width2 = (i3 * 1.0f) / this.aMa.getWidth();
                    i3 = this.aMa.getWidth();
                    i2 = (int) (i2 / width2);
                }
                if (i2 > this.aMa.getHeight() && this.aMa.getHeight() != 0) {
                    i3 = (int) (i3 / ((i2 * 1.0f) / this.aMa.getHeight()));
                    i2 = this.aMa.getHeight();
                }
                int aQ = (l.aQ(getContext()) - i2) / 2;
                int aO = (l.aO(getContext()) - i3) / 2;
                this.aMi = new Rect(aO, aQ, i3 + aO, i2 + aQ);
                this.aMj = new Rect(this.aMi);
                this.aMr = aQ / l.aQ(getContext());
                this.aMh = new Rect(0, 0, this.aMa.getWidth(), this.aMa.getHeight());
            }
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (i == 2) {
            this.aLY = l(this.mLastMotionX - x, this.mLastMotionY - y);
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (this.aLY || this.aLZ) {
            this.aLO.setImageOnLongClickListener(null);
            this.aLS.setOnLongClickListener(null);
            z = true;
        } else {
            this.aLO.setImageOnLongClickListener(this.aMC);
            this.aLS.setOnLongClickListener(this.aMC);
            z = super.dispatchTouchEvent(motionEvent);
        }
        if (i == 1 || i == 3) {
            this.mLastMotionX = 0.0f;
            this.mLastMotionY = 0.0f;
            this.aMb = false;
            this.aMd.reset();
            this.aLY = false;
            if (this.aMc > aMl) {
                this.aLZ = true;
                Hk();
                return z;
            }
            this.mRatio = 1.0f;
            invalidate();
            return z;
        }
        return z;
    }

    private boolean l(float f, float f2) {
        if (this.aLS.getVisibility() != 0 || this.aLS.isCanDrag()) {
            if (this.aMs == null || !this.aMs.isLongPic || this.aLS.getVisibility() != 0 || this.aLS.isViewTop()) {
                if (this.aMs == null || !this.aMs.isLongPic || this.aLS.getVisibility() == 0 || this.aLO.Nb()) {
                    if (this.aLS.getVisibility() == 0 || this.aLO.Nd()) {
                        if (this.aMa != null && getScrollY() == 0 && f2 < 0.0f && !this.aMb) {
                            this.aMb = true;
                            this.aMc = 0.0f;
                            this.mRatio = 1.0f;
                            if (this.aMk != null) {
                                this.aMk.Nt();
                            }
                        }
                        if (this.aMb) {
                            this.aMc -= f2;
                            int measuredHeight = getMeasuredHeight();
                            if (this.aMc > measuredHeight) {
                                this.aMc = measuredHeight;
                            }
                            float f3 = f2 / measuredHeight;
                            this.aMd.postTranslate((-f) * 1.5f * this.mRatio, (-1.5f) * f2 * this.mRatio);
                            if (this.mRatio * (1.0f + f3) > 1.0f || this.aMc < 0.0f) {
                                this.aMd.preScale(1.0f / this.mRatio, 1.0f / this.mRatio, (this.mRatio * this.aMa.getWidth()) / 2.0f, this.mRatio * (this.aMa.getHeight() / 2));
                                this.mRatio = 1.0f;
                            } else {
                                this.aMd.preScale(1.0f + f3, 1.0f + f3, (this.mRatio * this.aMa.getWidth()) / 2.0f, this.mRatio * (this.aMa.getHeight() / 2));
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
        if (this.aLY && this.aMa != null && !this.aMa.isRecycled() && this.aMb) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.aMf == null) {
                this.aMf = new RectF();
            }
            this.aMd.mapRect(this.aMf, new RectF(this.aMe));
            canvas.drawBitmap(this.aMa, this.aMh, this.aMf, (Paint) null);
        } else if (this.aLZ && this.aMa != null && !this.aMa.isRecycled()) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.aMs == null || this.aMs.getSourceImageRectInScreen() == null) {
                canvas.drawBitmap(this.aMa, this.aMh, this.aMf, (Paint) null);
            } else {
                canvas.drawBitmap(this.aMa, this.aMi, this.aMf, (Paint) null);
            }
        } else {
            super.dispatchDraw(canvas);
        }
    }

    private void Hk() {
        if (this.aMs == null) {
            if (this.aMk != null) {
                this.aMk.Nu();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.aMs.getSourceImageRectInScreen();
        final Rect dstRectInScreen = this.aMs.getDstRectInScreen();
        if (sourceImageRectInScreen == null || dstRectInScreen == null) {
            if (this.aMk != null) {
                this.aMk.Nu();
                return;
            }
            return;
        }
        a(sourceImageRectInScreen, dstRectInScreen);
        e(sourceImageRectInScreen);
        this.aMg = new RectF(this.aMf);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(150L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && sourceImageRectInScreen != null && dstRectInScreen != null) {
                    UrlDragImageView.this.Z(valueAnimator.getAnimatedFraction());
                    UrlDragImageView.this.a(dstRectInScreen, valueAnimator.getAnimatedFraction());
                    UrlDragImageView.this.invalidate();
                }
            }
        });
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                UrlDragImageView.this.aMb = false;
                UrlDragImageView.this.invalidate();
                if (UrlDragImageView.this.aMk != null) {
                    UrlDragImageView.this.aMk.Nu();
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

    private void e(Rect rect) {
        if (rect != null) {
            float f = ((rect.bottom - rect.top) / (rect.right - rect.left)) * (this.aMf.right - this.aMf.left);
            this.aMf.top += this.aMf.height() * this.aMr;
            this.aMf.bottom = f + this.aMf.top;
        }
    }

    private void a(Rect rect, Rect rect2) {
        this.aMn = 0.0f;
        this.aMo = 0.0f;
        this.aMp = 1.0f;
        this.aMq = 1.0f;
        if (rect != null && rect2 != null && rect.contains(rect2)) {
            this.aMn = (rect2.left - rect.left) / rect.width();
            this.aMo = (rect2.top - rect.top) / rect.height();
            this.aMp = (rect2.right - rect.left) / rect.width();
            this.aMq = (rect2.bottom - rect.top) / rect.height();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(float f) {
        if (this.aMi != null) {
            this.aMi.left = (int) (this.aMj.left + (this.aMj.width() * this.aMn * f));
            this.aMi.top = (int) (this.aMj.top + (this.aMj.height() * this.aMo * f));
            this.aMi.right = (int) (this.aMj.left + (this.aMj.width() * (((1.0f - this.aMp) * (1.0f - f)) + this.aMp)));
            this.aMi.bottom = (int) (this.aMj.top + (this.aMj.height() * (((1.0f - this.aMq) * (1.0f - f)) + this.aMq)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Rect rect, float f) {
        if (this.aMf != null && rect != null) {
            this.aMf.left = this.aMg.left + ((rect.left - this.aMg.left) * f);
            this.aMf.top = this.aMg.top + ((rect.top - this.aMg.top) * f);
            this.aMf.right = this.aMg.right + ((rect.right - this.aMg.right) * f);
            this.aMf.bottom = this.aMg.bottom + ((rect.bottom - this.aMg.bottom) * f);
        }
    }

    private RectF h(float f, float f2, float f3, float f4) {
        return new RectF(f - (f3 / 2.0f), f2 - (f4 / 2.0f), (f3 / 2.0f) + f, (f4 / 2.0f) + f2);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.aMz = onTouchListener;
    }

    private void Hl() {
        this.aMx = new TextView(this.mContext);
        this.aMx.setBackgroundResource(e.f.bg_url_drag_imagview_fade_view);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.height = getResources().getDimensionPixelSize(e.C0141e.ds180);
        layoutParams.addRule(12);
        addView(this.aMx, layoutParams);
        this.aMx.setVisibility(8);
    }

    private void Hm() {
        this.aLQ = new TextView(this.mContext);
        al.j(this.aLQ, e.d.common_color_10022);
        this.aLQ.setText(e.j.goto_pb_floor);
        this.aLQ.setTextSize(0, getResources().getDimensionPixelSize(e.C0141e.fontsize28));
        al.b(this.aLQ, e.d.cp_cont_i, 1, 0);
        this.aLQ.setCompoundDrawablePadding(l.dip2px(this.mContext, 4.0f));
        this.aLQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_see_arrow), (Drawable) null);
        this.aLQ.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(e.C0141e.ds20);
        this.aLQ.setPadding(dimensionPixelSize * 3, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(e.C0141e.ds30);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(e.C0141e.ds10);
        layoutParams.leftMargin = getResources().getDimensionPixelSize(e.C0141e.ds20);
        layoutParams.addRule(1, this.aLP.getId());
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        this.aLQ.setOnClickListener(this);
        this.aLQ.setMinHeight(getResources().getDimensionPixelSize(e.C0141e.ds100));
        addView(this.aLQ, layoutParams);
        this.aLQ.setVisibility(8);
    }

    private void Hn() {
        if (this.aLQ != null) {
            boolean z = this.aLV || this.aLW;
            if (!this.aMv && z && this.aMs != null && this.aMs.threadId > 0 && this.aMs.postId > 0 && this.aMs.mThreadType != 33 && !this.aMs.isBlockedPic && !this.aKM) {
                this.aLQ.setVisibility(0);
                if (this.aMx != null) {
                    this.aMx.setVisibility(0);
                    return;
                }
                return;
            }
            this.aLQ.setVisibility(8);
            if (this.aMx != null) {
                this.aMx.setVisibility(8);
            }
        }
    }

    private void Ho() {
        if (this.aLQ != null) {
            this.aLQ.setVisibility(8);
            if (this.aMx != null) {
                this.aMx.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hp() {
        if ((this.aLV || this.aLW) && this.aMs != null && this.aMs.mPicType == 1 && !TextUtils.isEmpty(this.aMs.mTagName)) {
            if (this.aLR != null) {
                this.aLR.setVisibility(8);
                this.aLR = null;
            }
            this.aLR = new TextView(this.mContext);
            this.aLR.setText(this.aMs.mTagName);
            this.aLR.setTextSize(0, getResources().getDimensionPixelSize(e.C0141e.fontsize26));
            al.b(this.aLR, e.d.common_color_10013, 1, 0);
            al.j(this.aLR, e.d.common_color_10215);
            this.aLR.setAlpha(0.75f);
            this.aLR.setIncludeFontPadding(false);
            this.aLR.setGravity(17);
            int h = l.h(this.mContext, e.C0141e.ds2);
            this.aLR.setPadding(h, h, h, h);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.aLO.getBottomOffset();
            layoutParams.leftMargin = this.aLO.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.aLR, layoutParams);
            this.aLR.setVisibility(0);
        }
    }

    public void bE(boolean z) {
        this.aMv = z;
        if (this.aMv) {
            Ho();
        } else {
            Hn();
        }
    }

    public void setUrl(String str, boolean z) {
        if (str.contains("*")) {
            str = str.split("[*]")[0];
        }
        this.aLO.setTag(str);
        this.aLO.setLoadBigImage(false);
        this.aLO.setImageDrawable(null);
        this.aLV = false;
        this.aLW = false;
        this.aMt = Hw();
        this.aLP.setVisibility(8);
        if (gB(str)) {
            b(str, z, false);
        }
    }

    private boolean Hq() {
        return this.aLO != null && this.aLO.Nr();
    }

    public void Hr() {
        if (this.aMs != null && !Hq()) {
            String str = this.aMs.imageUrl;
            int i = this.aMs.urlType;
            com.baidu.adp.widget.ImageView.a aVar = null;
            if (com.baidu.tbadk.core.util.d.a.A(str, i)) {
                aVar = com.baidu.tbadk.core.util.d.a.B(str, i);
            }
            if (aVar != null) {
                setThumbBitmapToView(aVar);
            }
        }
    }

    private boolean bF(boolean z) {
        String fe;
        if (!this.aMu || z) {
            this.aMu = true;
            if (!this.aMt || this.aMs == null || StringUtils.isNull(this.aMs.originalUrl, true) || this.aMs.originalSize < 0 || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String str = this.aMm + an.At().eX(fe) + "/" + ar.fe(this.aMs.originalUrl);
            final int[] ez = com.baidu.tbadk.core.util.l.ez(str);
            this.aLS.setVisibility(0);
            if (this.aLT == null) {
                this.aLT = new SubsamplingScaleImageView.OnImageEventListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12
                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onReady() {
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.aLO.Nn();
                        UrlDragImageView.this.aLO.setVisibility(4);
                    }

                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onImageLoaded() {
                        if (UrlDragImageView.this.aMs.isLongPic && ez[0] > 0) {
                            UrlDragImageView.this.aLO.onDestroy();
                            final float measuredWidth = (UrlDragImageView.this.getMeasuredWidth() * 1.0f) / ez[0];
                            final PointF pointF = new PointF((ez[0] * 1.0f) / 2.0f, 0.0f);
                            UrlDragImageView.this.aLS.setScaleAndCenter(measuredWidth, pointF);
                            UrlDragImageView.this.aLS.setMaxScale(2.0f * measuredWidth);
                            UrlDragImageView.this.aLS.setDoubleTapZoomScale(2.0f * measuredWidth);
                            UrlDragImageView.this.aLS.setInitScale(measuredWidth);
                            UrlDragImageView.this.aLS.setDoubleTapZoomStyle(4);
                            UrlDragImageView.this.aLS.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12.1
                                @Override // android.view.View.OnTouchListener
                                public boolean onTouch(View view, MotionEvent motionEvent) {
                                    if (UrlDragImageView.this.aMz != null) {
                                        UrlDragImageView.this.aMz.onTouch(view, motionEvent);
                                    }
                                    switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                                        case 0:
                                            UrlDragImageView.this.aMB = motionEvent.getY();
                                            UrlDragImageView.this.aLS.setOnClickListener(UrlDragImageView.this.aMA ? UrlDragImageView.this.mOnClickListener : null);
                                            UrlDragImageView.this.aLS.setOnLongClickListener(UrlDragImageView.this.aMA ? UrlDragImageView.this.aMC : null);
                                            break;
                                        case 1:
                                        case 3:
                                            if (UrlDragImageView.this.aLS.getScale() < measuredWidth) {
                                                UrlDragImageView.this.aLS.setScaleAndCenter(measuredWidth, pointF);
                                            }
                                            com.baidu.adp.lib.g.e.jt().removeCallbacks(UrlDragImageView.this.aMD);
                                            com.baidu.adp.lib.g.e.jt().postDelayed(UrlDragImageView.this.aMD, 1000L);
                                            break;
                                        case 2:
                                            if (Math.abs(motionEvent.getY() - UrlDragImageView.this.aMB) > UrlDragImageView.TOUCH_SLOP) {
                                                UrlDragImageView.this.aMA = false;
                                                UrlDragImageView.this.aLS.setOnClickListener(null);
                                                UrlDragImageView.this.aLS.setOnLongClickListener(null);
                                            }
                                            UrlDragImageView.this.aMB = motionEvent.getY();
                                            break;
                                    }
                                    return false;
                                }
                            });
                            UrlDragImageView.this.aLO.setVisibility(4);
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
            this.aLS.setOnImageEventListener(this.aLT);
            if (this.aLS.isImageLoaded() && this.aMs.isLongPic) {
                this.aLT.onImageLoaded();
            } else {
                this.aLS.setImage(ImageSource.uri(str));
            }
            return true;
        }
        return false;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.aMk = dVar;
        if (this.aLO != null) {
            this.aLO.setDragToExitListener(dVar);
        }
    }

    public void Hs() {
        bF(false);
    }

    private boolean gB(String str) {
        return j.kK() || c.fv(str);
    }

    private void setThumbBitmapToView(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap oh;
        if (!this.aLW && aVar != null && (oh = aVar.oh()) != null) {
            this.aLV = true;
            if (aVar.isGif()) {
                this.aLO.setImageUrlData(this.aMs);
                this.aLO.setImageBitmap(oh);
                this.aLP.setVisibility(8);
                this.aMw = false;
            } else {
                if (this.aMs != null && this.aMs.isLongPic) {
                    this.aLO.Ng();
                    this.aLO.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.13
                        @Override // com.baidu.tbadk.widget.largeImage.logic.a
                        public void HA() {
                        }
                    });
                }
                this.aLO.setImageUrlData(this.aMs);
                this.aLO.setImageData(oh, aVar.om());
            }
            Hn();
            Hp();
        }
    }

    private void b(String str, boolean z, boolean z2) {
        if (gC(str)) {
            if (z2 || (!this.aLX && !this.aLW)) {
                if (!z2 || !bF(true)) {
                    this.aLX = true;
                    com.baidu.adp.lib.f.c.jn().a(str, 27, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.14
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onCancelled(String str2) {
                            UrlDragImageView.this.aLX = false;
                            UrlDragImageView.this.aLO.setVisibility(0);
                            UrlDragImageView.this.mProgressBar.setVisibility(8);
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            UrlDragImageView.this.aLX = false;
                            UrlDragImageView.this.aLW = true;
                            UrlDragImageView.this.b(aVar);
                        }
                    }, 0, 0, false, null, Boolean.valueOf(z), this.aLO.getImageData(), Boolean.valueOf(this.aKI));
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
        imageFileInfo.addPageAction(d.K(this.mMaxWidth, this.mMaxHeight));
        com.baidu.adp.widget.ImageView.a a2 = this.aMy.a(imageFileInfo, false);
        if (a2 != null) {
            this.aLW = true;
            this.mProgressBar.setVisibility(8);
            b(a2);
            return;
        }
        this.aMy.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.2
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.ImageView.a aVar, String str2, boolean z3) {
                UrlDragImageView.this.aLW = true;
                UrlDragImageView.this.mProgressBar.setVisibility(8);
                UrlDragImageView.this.b(aVar);
            }
        }, false);
    }

    private boolean gC(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null && this.aLU != null) {
            this.aLU.j(aVar.getUrl(), aVar.om());
        }
        if (aVar == null || aVar.oh() == null) {
            Ht();
            return;
        }
        Bitmap oh = aVar.oh();
        this.aLO.setLoadBigImage(true);
        if (aVar.isGif()) {
            this.aLO.setGifData(aVar.om(), oh);
            this.aLO.invalidate();
            this.aLO.play();
            this.aMw = false;
            this.aLP.setVisibility(8);
            this.mProgressBar.setVisibility(8);
        } else {
            if (this.aMs != null && this.aMs.isLongPic) {
                this.aLO.Ng();
                this.aLO.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.3
                    @Override // com.baidu.tbadk.widget.largeImage.logic.a
                    public void HA() {
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                    }
                });
            } else {
                this.mProgressBar.setVisibility(8);
            }
            this.aLO.setImageUrlData(this.aMs);
            this.aLO.setImageData(oh, aVar.om());
            Hx();
        }
        Hn();
        Hp();
    }

    private void Ht() {
        if (!this.aLV) {
            this.aLO.setDefaultBitmap();
        } else {
            this.aLW = false;
        }
        this.aLP.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    public void setGifMaxUseableMem(int i) {
        this.aLO.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.aLO != null) {
            this.aLO.onDestroy();
        }
        if (this.aLS != null) {
            this.aLS.recycle();
        }
        if (this.aMa != null) {
            this.aMa.recycle();
            this.aMa = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.aMD);
    }

    public void release() {
        if (this.aLO != null) {
            this.aLO.release();
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.aLP != null) {
            this.aLP.setVisibility(8);
        }
    }

    public void Hu() {
        if (this.aLO != null && this.aLO.getImageType() == 1) {
            this.aLO.stop();
        }
    }

    public void k(boolean z, boolean z2) {
        String str;
        if (this.aLO != null && (str = (String) this.aLO.getTag()) != null) {
            if (this.aLO.getImageType() == 1) {
                if (this.aLO.getGifCache() == null || !this.aLO.Nr()) {
                    b(str, z, z2);
                }
            } else if (this.aLO.getImageType() == 2) {
                b(str, z, z2);
            } else if (Hv()) {
                b(str, z, z2);
            }
        }
    }

    private boolean Hv() {
        if (this.aLO.getImageBitmap() != null && this.aLO.Nr()) {
            if (this.aMs == null || !this.aMs.isLongPic || this.aLO.Nh()) {
                return false;
            }
            this.aLW = false;
            this.aMu = false;
            return true;
        }
        return true;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.aMs = imageUrlData;
    }

    public void setIsCdn(boolean z) {
        this.aKI = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aLP) {
            if (!(this.aLP.getTag() instanceof Boolean) || ((Boolean) this.aLP.getTag()).booleanValue()) {
                final String fe = ar.fe(this.aMs.originalUrl);
                if (this.aMs.originalProcess >= 0) {
                    com.baidu.tbadk.download.d.ID().E(fe, 13);
                    this.aMs.originalProcess = -1;
                    Hx();
                    return;
                }
                if (this.aKK != null) {
                    this.aKK.HB();
                }
                com.baidu.adp.base.e<?> aK = i.aK(this.mContext);
                if (aK == null) {
                    gD(fe);
                } else if (!j.kK() || j.kL() || com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("original_img_down_tip", false)) {
                    gD(fe);
                } else {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("original_img_down_tip", true);
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(aK.getPageActivity());
                    aVar.cp(e.j.original_img_down_no_wifi_tip);
                    aVar.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.4
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar.dismiss();
                            UrlDragImageView.this.gD(fe);
                        }
                    });
                    aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.5
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar.dismiss();
                        }
                    });
                    aVar.b(aK);
                    aVar.yl();
                }
            }
        } else if (view == this.aLQ && this.aMs != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.mContext).createHistoryCfg(String.valueOf(this.aMs.threadId), String.valueOf(this.aMs.postId), this.aMs.mIsSeeHost, this.aMs.mIsReserver, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gD(String str) {
        if (this.aMs != null) {
            this.aMs.originalProcess = 0;
            this.aLP.setText("0%");
            this.aLP.setCompoundDrawablesWithIntrinsicBounds(0, 0, e.f.icon_close_yuantu, 0);
            DownloadData downloadData = new DownloadData(str);
            downloadData.setStatus(1);
            downloadData.setUrl(this.aMs.originalUrl);
            downloadData.setType(13);
            downloadData.setPath(this.aMm + an.At().eX(str) + "/" + str);
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.6
                @Override // com.baidu.tbadk.download.c
                public boolean onPreDownload(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2 != null) {
                        if (UrlDragImageView.this.aMs != null && UrlDragImageView.this.aMs.originalProcess != -1) {
                            UrlDragImageView.this.aMs.originalProcess = downloadData2.getProcess();
                        }
                        if (UrlDragImageView.this.aMs == null || UrlDragImageView.this.aMs.originalProcess != -1) {
                            UrlDragImageView.this.aLP.setText(downloadData2.getProcess() + "%");
                            UrlDragImageView.this.aLP.setCompoundDrawablesWithIntrinsicBounds(0, 0, e.f.icon_close_yuantu, 0);
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public boolean onFileDownloaded(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadSucceed(DownloadData downloadData2) {
                    UrlDragImageView.this.aLP.setText(UrlDragImageView.this.getResources().getString(e.j.done));
                    UrlDragImageView.this.aLP.setTag(false);
                    UrlDragImageView.this.aLP.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    com.baidu.adp.lib.g.e.jt().postDelayed(UrlDragImageView.this.aME, 1500L);
                    UrlDragImageView.this.aMu = false;
                    UrlDragImageView.this.aMt = UrlDragImageView.this.Hw();
                    UrlDragImageView.this.Hs();
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str2) {
                    UrlDragImageView.this.aMu = false;
                    BdToast.a(UrlDragImageView.this.mContext, str2).yr().yt();
                    UrlDragImageView.this.aMs.originalProcess = -1;
                    UrlDragImageView.this.Hx();
                }
            });
            com.baidu.tbadk.download.d.ID().a(downloadData, 100);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Hw() {
        if (this.aMs != null && !StringUtils.isNull(this.aMs.originalUrl, true) && this.aMs.originalSize >= 0 && !this.aMs.isBlockedPic) {
            String fe = ar.fe(this.aMs.originalUrl);
            File file = new File(this.aMm + an.At().eX(fe) + "/" + fe);
            if (file != null && file.exists()) {
                this.aMs.originalProcess = 100;
                return true;
            }
            if (this.aMs.originalProcess < 0) {
                Hx();
            } else {
                this.aLP.setText(this.aMs.originalProcess + "%");
                this.aLP.setCompoundDrawablesWithIntrinsicBounds(0, 0, e.f.icon_close_yuantu, 0);
            }
            this.aMw = true;
        } else {
            this.aLP.setVisibility(8);
        }
        return false;
    }

    public void Hx() {
        if (this.aMs != null) {
            if (!Hy() || !this.aMw) {
                this.aLP.setVisibility(8);
            } else {
                this.aLP.setVisibility(0);
            }
            if (this.aMs.originalSize > 0 && !ab(this.aMs.originalSize)) {
                this.aLP.setText(aLM + "(" + ao.Q(this.aMs.originalSize) + ")");
            } else {
                this.aLP.setText(aLM);
            }
            this.aLP.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    private boolean Hy() {
        return (this.aMs == null || !this.aMs.mIsShowOrigonButton || this.aMs.isBlockedPic || StringUtils.isNull(this.aMs.originalUrl)) ? false : true;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.aKK = bVar;
    }

    private boolean ab(long j) {
        return j > aLN;
    }
}
