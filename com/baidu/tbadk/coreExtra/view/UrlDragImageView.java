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
/* loaded from: classes6.dex */
public class UrlDragImageView extends RelativeLayout implements View.OnClickListener {
    private boolean aQa;
    private b aQc;
    private boolean aQd;
    private boolean aQe;
    private Rect aRA;
    private Rect aRB;
    private DragImageView.d aRC;
    private String aRE;
    private float aRF;
    private float aRG;
    private float aRH;
    private float aRI;
    private float aRJ;
    private ImageUrlData aRK;
    private boolean aRL;
    private boolean aRM;
    private boolean aRN;
    public boolean aRO;
    private TextView aRP;
    private com.baidu.tbadk.img.b aRQ;
    private View.OnTouchListener aRR;
    private boolean aRS;
    private float aRT;
    private View.OnLongClickListener aRU;
    private Runnable aRV;
    private Runnable aRW;
    private View.OnTouchListener aRX;
    protected DragImageView aRg;
    protected TextView aRh;
    protected TextView aRi;
    protected TextView aRj;
    protected SubsamplingScaleImageView aRk;
    private SubsamplingScaleImageView.OnImageEventListener aRl;
    private a aRm;
    private boolean aRn;
    private boolean aRo;
    private boolean aRp;
    private boolean aRq;
    private boolean aRr;
    private Bitmap aRs;
    private boolean aRt;
    private float aRu;
    private Matrix aRv;
    private Rect aRw;
    private RectF aRx;
    private RectF aRy;
    private Rect aRz;
    protected Context mContext;
    private float mLastMotionX;
    private float mLastMotionY;
    private int mMaxHeight;
    private int mMaxWidth;
    private View.OnClickListener mOnClickListener;
    protected ProgressBar mProgressBar;
    private float mRatio;
    private int mSkinType;
    private static final String aRe = TbadkCoreApplication.getInst().getString(e.j.original_img_look);
    private static long aRf = Config.RAVEN_LOG_LIMIT;
    private static final int aRD = l.aQ(TbadkCoreApplication.getInst()) / 5;
    private static final String TAG = UrlDragImageView.class.getSimpleName();
    private static final int TOUCH_SLOP = ViewConfiguration.get(TbadkCoreApplication.getInst()).getScaledTouchSlop();

    /* loaded from: classes6.dex */
    public interface a {
        void j(String str, byte[] bArr);
    }

    /* loaded from: classes6.dex */
    public interface b {
        void JO();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.aRh != null) {
                al.i(this.aRh, e.f.btn_percent_yuantu);
                al.b(this.aRh, e.d.cp_cont_g, 1, 0);
            }
            if (this.aRi != null) {
                al.j(this.aRi, e.d.common_color_10022);
                al.b(this.aRi, e.d.cp_cont_g, 1, 0);
            }
            this.mSkinType = i;
        }
    }

    public void setHeadImage(boolean z) {
        if (this.aRg != null) {
            this.aRg.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.aRm = aVar;
    }

    public UrlDragImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mContext = null;
        this.mProgressBar = null;
        this.aRg = null;
        this.aRm = null;
        this.aQa = false;
        this.aRp = false;
        this.aRt = false;
        this.mRatio = 1.0f;
        this.aRu = 0.0f;
        this.aRv = new Matrix();
        this.aRx = new RectF();
        this.aRF = 0.0f;
        this.aRG = 0.0f;
        this.aRH = 1.0f;
        this.aRI = 1.0f;
        this.aRJ = 0.0f;
        this.aRL = false;
        this.aRM = false;
        this.aRN = false;
        this.aRO = false;
        this.aRP = null;
        this.aRS = true;
        this.aRT = 0.0f;
        this.mOnClickListener = null;
        this.aRU = null;
        this.aRV = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.aRS = true;
            }
        };
        this.aRW = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.aRh.setVisibility(8);
                        UrlDragImageView.this.aRO = false;
                    }
                });
                UrlDragImageView.this.aRh.startAnimation(alphaAnimation);
            }
        };
        this.aRX = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.aRR != null) {
                    UrlDragImageView.this.aRR.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.aRQ = new com.baidu.tbadk.img.b();
        init();
    }

    public UrlDragImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.mContext = null;
        this.mProgressBar = null;
        this.aRg = null;
        this.aRm = null;
        this.aQa = false;
        this.aRp = false;
        this.aRt = false;
        this.mRatio = 1.0f;
        this.aRu = 0.0f;
        this.aRv = new Matrix();
        this.aRx = new RectF();
        this.aRF = 0.0f;
        this.aRG = 0.0f;
        this.aRH = 1.0f;
        this.aRI = 1.0f;
        this.aRJ = 0.0f;
        this.aRL = false;
        this.aRM = false;
        this.aRN = false;
        this.aRO = false;
        this.aRP = null;
        this.aRS = true;
        this.aRT = 0.0f;
        this.mOnClickListener = null;
        this.aRU = null;
        this.aRV = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.aRS = true;
            }
        };
        this.aRW = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.aRh.setVisibility(8);
                        UrlDragImageView.this.aRO = false;
                    }
                });
                UrlDragImageView.this.aRh.startAnimation(alphaAnimation);
            }
        };
        this.aRX = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.aRR != null) {
                    UrlDragImageView.this.aRR.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.aRQ = new com.baidu.tbadk.img.b();
        init();
    }

    public DragImageView getImageView() {
        return this.aRg;
    }

    public void setGifSetListener(DragImageView.e eVar) {
        this.aRg.setGifSetListener(eVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.aRg.setImageOnClickListener(onClickListener);
        this.aRk.setOnClickListener(onClickListener);
        this.mOnClickListener = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aRU = onLongClickListener;
        if (!this.aQd) {
            this.aRg.setImageOnLongClickListener(this.aRU);
            this.aRk.setOnLongClickListener(this.aRU);
        }
    }

    public void setOnSizeChangedListener(final DragImageView.g gVar) {
        this.aRg.setOnSizeChangedListener(new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.8
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (gVar != null) {
                    gVar.a(dragImageView, z, z2);
                }
                UrlDragImageView.this.JC();
            }
        });
    }

    protected void init() {
        this.mMaxWidth = l.aO(this.mContext);
        this.mMaxHeight = l.aQ(this.mContext) - ((int) this.mContext.getResources().getDimension(e.C0200e.ds166));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.aRg = new DragImageView(this.mContext);
        this.aRg.setLayoutParams(layoutParams);
        this.aRg.setOnTouchListener(this.aRX);
        addView(this.aRg);
        this.aRk = new SubsamplingScaleImageView(this.mContext);
        this.aRk.setMaxScale(50.0f);
        this.aRk.setOnTouchListener(this.aRX);
        this.aRk.setVisibility(4);
        addView(this.aRk, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(getResources().getDrawable(e.f.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        Jy();
        Jw();
        Jz();
    }

    private void Jw() {
        this.aRE = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        this.aRh = new TextView(this.mContext);
        al.i(this.aRh, e.f.btn_percent_yuantu);
        this.aRh.setText(e.j.original_img_look);
        this.aRh.setTextSize(0, getResources().getDimensionPixelSize(e.C0200e.fontsize28));
        al.b(this.aRh, e.d.cp_cont_i, 1, 0);
        this.aRh.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(e.C0200e.ds16);
        this.aRh.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        this.aRh.setMinWidth(getResources().getDimensionPixelSize(e.C0200e.ds222));
        this.aRh.setMinHeight(getResources().getDimensionPixelSize(e.C0200e.ds60));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(e.C0200e.fontsize40);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        this.aRh.setOnClickListener(this);
        this.aRh.setVisibility(8);
        addView(this.aRh, layoutParams);
    }

    public void setIsCanDrag(boolean z) {
        this.aQd = z;
    }

    public void setIsHotSort(boolean z) {
        this.aQe = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        Bitmap imageBitmap;
        int height;
        int width;
        if (!this.aQd || !this.aRo) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.aRq && motionEvent.getPointerCount() >= 2) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.aRq || this.aRr) {
            requestDisallowInterceptTouchEvent(true);
        }
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        float x = motionEvent.getX();
        int i = action & 255;
        if (i == 0) {
            if (this.aRs == null) {
                if (this.aRk.getVisibility() == 0) {
                    this.aRs = com.baidu.tbadk.util.e.ae(this.aRk);
                } else {
                    this.aRs = com.baidu.tbadk.util.e.ae(this.aRg);
                }
            }
            if (this.aRw == null && this.aRs != null) {
                int measuredWidth = getMeasuredWidth();
                float measuredWidth2 = ((getMeasuredWidth() * 1.0f) / this.aRs.getWidth()) * this.aRs.getHeight();
                if (measuredWidth2 > getMeasuredHeight()) {
                    measuredWidth2 = getMeasuredHeight();
                }
                RectF h = h(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
                this.aRw = new Rect((int) h.left, (int) h.top, (int) h.right, (int) h.bottom);
            }
            if (this.aRA == null && this.aRs != null) {
                if (this.aRk.getVisibility() == 0) {
                    height = this.aRk.getSHeight();
                    width = this.aRk.getSWidth();
                } else {
                    if (this.aRg.getImageType() == 1) {
                        imageBitmap = (this.aRg.getCurrentFrame() == null || this.aRg.getCurrentFrame().bgw == null) ? this.aRs : this.aRg.getCurrentFrame().bgw;
                    } else {
                        imageBitmap = this.aRg.getImageBitmap() == null ? this.aRs : this.aRg.getImageBitmap();
                    }
                    height = imageBitmap.getHeight();
                    width = imageBitmap.getWidth();
                }
                float aR = l.aR(getContext());
                int i2 = (int) (height * aR);
                int i3 = (int) (width * aR);
                if (i3 > this.aRs.getWidth() && this.aRs.getWidth() != 0) {
                    float width2 = (i3 * 1.0f) / this.aRs.getWidth();
                    i3 = this.aRs.getWidth();
                    i2 = (int) (i2 / width2);
                }
                if (i2 > this.aRs.getHeight() && this.aRs.getHeight() != 0) {
                    i3 = (int) (i3 / ((i2 * 1.0f) / this.aRs.getHeight()));
                    i2 = this.aRs.getHeight();
                }
                int aQ = (l.aQ(getContext()) - i2) / 2;
                int aO = (l.aO(getContext()) - i3) / 2;
                this.aRA = new Rect(aO, aQ, i3 + aO, i2 + aQ);
                this.aRB = new Rect(this.aRA);
                this.aRJ = aQ / l.aQ(getContext());
                this.aRz = new Rect(0, 0, this.aRs.getWidth(), this.aRs.getHeight());
            }
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (i == 2) {
            this.aRq = o(this.mLastMotionX - x, this.mLastMotionY - y);
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (this.aRq || this.aRr) {
            this.aRg.setImageOnLongClickListener(null);
            this.aRk.setOnLongClickListener(null);
            z = true;
        } else {
            this.aRg.setImageOnLongClickListener(this.aRU);
            this.aRk.setOnLongClickListener(this.aRU);
            z = super.dispatchTouchEvent(motionEvent);
        }
        if (i == 1 || i == 3) {
            this.mLastMotionX = 0.0f;
            this.mLastMotionY = 0.0f;
            this.aRt = false;
            this.aRv.reset();
            this.aRq = false;
            if (this.aRu > aRD) {
                this.aRr = true;
                Jx();
                return z;
            }
            this.mRatio = 1.0f;
            invalidate();
            return z;
        }
        return z;
    }

    private boolean o(float f, float f2) {
        if (this.aRk.getVisibility() != 0 || this.aRk.isCanDrag()) {
            if (this.aRK == null || !this.aRK.isLongPic || this.aRk.getVisibility() != 0 || this.aRk.isViewTop()) {
                if (this.aRK == null || !this.aRK.isLongPic || this.aRk.getVisibility() == 0 || this.aRg.Pi()) {
                    if (this.aRk.getVisibility() == 0 || this.aRg.Pk()) {
                        if (this.aRs != null && getScrollY() == 0 && f2 < 0.0f && !this.aRt) {
                            this.aRt = true;
                            this.aRu = 0.0f;
                            this.mRatio = 1.0f;
                            if (this.aRC != null) {
                                this.aRC.PA();
                            }
                        }
                        if (this.aRt) {
                            this.aRu -= f2;
                            int measuredHeight = getMeasuredHeight();
                            if (this.aRu > measuredHeight) {
                                this.aRu = measuredHeight;
                            }
                            float f3 = f2 / measuredHeight;
                            this.aRv.postTranslate((-f) * 1.5f * this.mRatio, (-1.5f) * f2 * this.mRatio);
                            if (this.mRatio * (1.0f + f3) > 1.0f || this.aRu < 0.0f) {
                                this.aRv.preScale(1.0f / this.mRatio, 1.0f / this.mRatio, (this.mRatio * this.aRs.getWidth()) / 2.0f, this.mRatio * (this.aRs.getHeight() / 2));
                                this.mRatio = 1.0f;
                            } else {
                                this.aRv.preScale(1.0f + f3, 1.0f + f3, (this.mRatio * this.aRs.getWidth()) / 2.0f, this.mRatio * (this.aRs.getHeight() / 2));
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
        if (this.aRq && this.aRs != null && !this.aRs.isRecycled() && this.aRt) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.aRx == null) {
                this.aRx = new RectF();
            }
            this.aRv.mapRect(this.aRx, new RectF(this.aRw));
            canvas.drawBitmap(this.aRs, this.aRz, this.aRx, (Paint) null);
        } else if (this.aRr && this.aRs != null && !this.aRs.isRecycled()) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.aRK == null || this.aRK.getSourceImageRectInScreen() == null) {
                canvas.drawBitmap(this.aRs, this.aRz, this.aRx, (Paint) null);
            } else {
                canvas.drawBitmap(this.aRs, this.aRA, this.aRx, (Paint) null);
            }
        } else {
            super.dispatchDraw(canvas);
        }
    }

    private void Jx() {
        if (this.aRK == null) {
            if (this.aRC != null) {
                this.aRC.PB();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.aRK.getSourceImageRectInScreen();
        final Rect dstRectInScreen = this.aRK.getDstRectInScreen();
        if (sourceImageRectInScreen == null || dstRectInScreen == null) {
            if (this.aRC != null) {
                this.aRC.PB();
                return;
            }
            return;
        }
        a(sourceImageRectInScreen, dstRectInScreen);
        e(sourceImageRectInScreen);
        this.aRy = new RectF(this.aRx);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(150L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && sourceImageRectInScreen != null && dstRectInScreen != null) {
                    UrlDragImageView.this.aa(valueAnimator.getAnimatedFraction());
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
                UrlDragImageView.this.aRt = false;
                UrlDragImageView.this.invalidate();
                if (UrlDragImageView.this.aRC != null) {
                    UrlDragImageView.this.aRC.PB();
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
            float f = ((rect.bottom - rect.top) / (rect.right - rect.left)) * (this.aRx.right - this.aRx.left);
            this.aRx.top += this.aRx.height() * this.aRJ;
            this.aRx.bottom = f + this.aRx.top;
        }
    }

    private void a(Rect rect, Rect rect2) {
        this.aRF = 0.0f;
        this.aRG = 0.0f;
        this.aRH = 1.0f;
        this.aRI = 1.0f;
        if (rect != null && rect2 != null && rect.contains(rect2)) {
            this.aRF = (rect2.left - rect.left) / rect.width();
            this.aRG = (rect2.top - rect.top) / rect.height();
            this.aRH = (rect2.right - rect.left) / rect.width();
            this.aRI = (rect2.bottom - rect.top) / rect.height();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa(float f) {
        if (this.aRA != null) {
            this.aRA.left = (int) (this.aRB.left + (this.aRB.width() * this.aRF * f));
            this.aRA.top = (int) (this.aRB.top + (this.aRB.height() * this.aRG * f));
            this.aRA.right = (int) (this.aRB.left + (this.aRB.width() * (((1.0f - this.aRH) * (1.0f - f)) + this.aRH)));
            this.aRA.bottom = (int) (this.aRB.top + (this.aRB.height() * (((1.0f - this.aRI) * (1.0f - f)) + this.aRI)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Rect rect, float f) {
        if (this.aRx != null && rect != null) {
            this.aRx.left = this.aRy.left + ((rect.left - this.aRy.left) * f);
            this.aRx.top = this.aRy.top + ((rect.top - this.aRy.top) * f);
            this.aRx.right = this.aRy.right + ((rect.right - this.aRy.right) * f);
            this.aRx.bottom = this.aRy.bottom + ((rect.bottom - this.aRy.bottom) * f);
        }
    }

    private RectF h(float f, float f2, float f3, float f4) {
        return new RectF(f - (f3 / 2.0f), f2 - (f4 / 2.0f), (f3 / 2.0f) + f, (f4 / 2.0f) + f2);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.aRR = onTouchListener;
    }

    private void Jy() {
        this.aRP = new TextView(this.mContext);
        this.aRP.setBackgroundResource(e.f.bg_url_drag_imagview_fade_view);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.height = getResources().getDimensionPixelSize(e.C0200e.ds180);
        layoutParams.addRule(12);
        addView(this.aRP, layoutParams);
        this.aRP.setVisibility(8);
    }

    private void Jz() {
        this.aRi = new TextView(this.mContext);
        al.j(this.aRi, e.d.common_color_10022);
        this.aRi.setText(e.j.goto_pb_floor);
        this.aRi.setTextSize(0, getResources().getDimensionPixelSize(e.C0200e.fontsize28));
        al.b(this.aRi, e.d.cp_cont_i, 1, 0);
        this.aRi.setCompoundDrawablePadding(l.dip2px(this.mContext, 4.0f));
        this.aRi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_see_arrow), (Drawable) null);
        this.aRi.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(e.C0200e.ds20);
        this.aRi.setPadding(dimensionPixelSize * 3, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(e.C0200e.ds30);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(e.C0200e.ds10);
        layoutParams.leftMargin = getResources().getDimensionPixelSize(e.C0200e.ds20);
        layoutParams.addRule(1, this.aRh.getId());
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        this.aRi.setOnClickListener(this);
        this.aRi.setMinHeight(getResources().getDimensionPixelSize(e.C0200e.ds100));
        addView(this.aRi, layoutParams);
        this.aRi.setVisibility(8);
    }

    private void JA() {
        if (this.aRi != null) {
            boolean z = this.aRn || this.aRo;
            if (!this.aRN && z && this.aRK != null && this.aRK.threadId > 0 && this.aRK.postId > 0 && this.aRK.mThreadType != 33 && !this.aRK.isBlockedPic && !this.aQe) {
                this.aRi.setVisibility(0);
                if (this.aRP != null) {
                    this.aRP.setVisibility(0);
                    return;
                }
                return;
            }
            this.aRi.setVisibility(8);
            if (this.aRP != null) {
                this.aRP.setVisibility(8);
            }
        }
    }

    private void JB() {
        if (this.aRi != null) {
            this.aRi.setVisibility(8);
            if (this.aRP != null) {
                this.aRP.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JC() {
        if ((this.aRn || this.aRo) && this.aRK != null && this.aRK.mPicType == 1 && !TextUtils.isEmpty(this.aRK.mTagName)) {
            if (this.aRj != null) {
                this.aRj.setVisibility(8);
                this.aRj = null;
            }
            this.aRj = new TextView(this.mContext);
            this.aRj.setText(this.aRK.mTagName);
            this.aRj.setTextSize(0, getResources().getDimensionPixelSize(e.C0200e.fontsize26));
            al.b(this.aRj, e.d.common_color_10013, 1, 0);
            al.j(this.aRj, e.d.common_color_10215);
            this.aRj.setAlpha(0.75f);
            this.aRj.setIncludeFontPadding(false);
            this.aRj.setGravity(17);
            int h = l.h(this.mContext, e.C0200e.ds2);
            this.aRj.setPadding(h, h, h, h);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.aRg.getBottomOffset();
            layoutParams.leftMargin = this.aRg.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.aRj, layoutParams);
            this.aRj.setVisibility(0);
        }
    }

    public void ce(boolean z) {
        this.aRN = z;
        if (this.aRN) {
            JB();
        } else {
            JA();
        }
    }

    public void setUrl(String str, boolean z) {
        if (str.contains("*")) {
            str = str.split("[*]")[0];
        }
        this.aRg.setTag(str);
        this.aRg.setLoadBigImage(false);
        this.aRg.setImageDrawable(null);
        this.aRn = false;
        this.aRo = false;
        this.aRL = JJ();
        this.aRh.setVisibility(8);
        if (gQ(str)) {
            b(str, z, false);
        }
    }

    private boolean JD() {
        return this.aRg != null && this.aRg.Py();
    }

    public void JE() {
        if (this.aRK != null && !JD()) {
            String str = this.aRK.imageUrl;
            int i = this.aRK.urlType;
            com.baidu.adp.widget.ImageView.a aVar = null;
            if (com.baidu.tbadk.core.util.d.a.B(str, i)) {
                aVar = com.baidu.tbadk.core.util.d.a.C(str, i);
            }
            if (aVar != null) {
                setThumbBitmapToView(aVar);
            }
        }
    }

    private boolean cf(boolean z) {
        String fs;
        if (!this.aRM || z) {
            this.aRM = true;
            if (!this.aRL || this.aRK == null || StringUtils.isNull(this.aRK.originalUrl, true) || this.aRK.originalSize < 0 || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String str = this.aRE + an.CH().fl(fs) + "/" + ar.fs(this.aRK.originalUrl);
            final int[] eP = com.baidu.tbadk.core.util.l.eP(str);
            this.aRk.setVisibility(0);
            if (this.aRl == null) {
                this.aRl = new SubsamplingScaleImageView.OnImageEventListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12
                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onReady() {
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.aRg.Pu();
                        UrlDragImageView.this.aRg.setVisibility(4);
                    }

                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onImageLoaded() {
                        if (UrlDragImageView.this.aRK.isLongPic && eP[0] > 0) {
                            UrlDragImageView.this.aRg.onDestroy();
                            final float measuredWidth = (UrlDragImageView.this.getMeasuredWidth() * 1.0f) / eP[0];
                            final PointF pointF = new PointF((eP[0] * 1.0f) / 2.0f, 0.0f);
                            UrlDragImageView.this.aRk.setScaleAndCenter(measuredWidth, pointF);
                            UrlDragImageView.this.aRk.setMaxScale(2.0f * measuredWidth);
                            UrlDragImageView.this.aRk.setDoubleTapZoomScale(2.0f * measuredWidth);
                            UrlDragImageView.this.aRk.setInitScale(measuredWidth);
                            UrlDragImageView.this.aRk.setDoubleTapZoomStyle(4);
                            UrlDragImageView.this.aRk.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12.1
                                @Override // android.view.View.OnTouchListener
                                public boolean onTouch(View view, MotionEvent motionEvent) {
                                    if (UrlDragImageView.this.aRR != null) {
                                        UrlDragImageView.this.aRR.onTouch(view, motionEvent);
                                    }
                                    switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                                        case 0:
                                            UrlDragImageView.this.aRT = motionEvent.getY();
                                            UrlDragImageView.this.aRk.setOnClickListener(UrlDragImageView.this.aRS ? UrlDragImageView.this.mOnClickListener : null);
                                            UrlDragImageView.this.aRk.setOnLongClickListener(UrlDragImageView.this.aRS ? UrlDragImageView.this.aRU : null);
                                            break;
                                        case 1:
                                        case 3:
                                            if (UrlDragImageView.this.aRk.getScale() < measuredWidth) {
                                                UrlDragImageView.this.aRk.setScaleAndCenter(measuredWidth, pointF);
                                            }
                                            com.baidu.adp.lib.g.e.jG().removeCallbacks(UrlDragImageView.this.aRV);
                                            com.baidu.adp.lib.g.e.jG().postDelayed(UrlDragImageView.this.aRV, 1000L);
                                            break;
                                        case 2:
                                            if (Math.abs(motionEvent.getY() - UrlDragImageView.this.aRT) > UrlDragImageView.TOUCH_SLOP) {
                                                UrlDragImageView.this.aRS = false;
                                                UrlDragImageView.this.aRk.setOnClickListener(null);
                                                UrlDragImageView.this.aRk.setOnLongClickListener(null);
                                            }
                                            UrlDragImageView.this.aRT = motionEvent.getY();
                                            break;
                                    }
                                    return false;
                                }
                            });
                            UrlDragImageView.this.aRg.setVisibility(4);
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
            this.aRk.setOnImageEventListener(this.aRl);
            if (this.aRk.isImageLoaded() && this.aRK.isLongPic) {
                this.aRl.onImageLoaded();
            } else {
                this.aRk.setImage(ImageSource.uri(str));
            }
            return true;
        }
        return false;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.aRC = dVar;
        if (this.aRg != null) {
            this.aRg.setDragToExitListener(dVar);
        }
    }

    public void JF() {
        cf(false);
    }

    private boolean gQ(String str) {
        return j.kV() || c.fJ(str);
    }

    private void setThumbBitmapToView(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap oq;
        if (!this.aRo && aVar != null && (oq = aVar.oq()) != null) {
            this.aRn = true;
            if (aVar.isGif()) {
                this.aRg.setImageUrlData(this.aRK);
                this.aRg.setImageBitmap(oq);
                this.aRh.setVisibility(8);
                this.aRO = false;
            } else {
                if (this.aRK != null && this.aRK.isLongPic) {
                    this.aRg.Pn();
                    this.aRg.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.13
                        @Override // com.baidu.tbadk.widget.largeImage.logic.a
                        public void JN() {
                        }
                    });
                }
                this.aRg.setImageUrlData(this.aRK);
                this.aRg.setImageData(oq, aVar.ov());
            }
            JA();
            JC();
        }
    }

    private void b(String str, boolean z, boolean z2) {
        if (gR(str)) {
            if (z2 || (!this.aRp && !this.aRo)) {
                if (!z2 || !cf(true)) {
                    this.aRp = true;
                    com.baidu.adp.lib.f.c.jA().a(str, 27, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.14
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onCancelled(String str2) {
                            UrlDragImageView.this.aRp = false;
                            UrlDragImageView.this.aRg.setVisibility(0);
                            UrlDragImageView.this.mProgressBar.setVisibility(8);
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            UrlDragImageView.this.aRp = false;
                            UrlDragImageView.this.aRo = true;
                            UrlDragImageView.this.b(aVar);
                        }
                    }, 0, 0, false, null, Boolean.valueOf(z), this.aRg.getImageData(), Boolean.valueOf(this.aQa));
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
        com.baidu.adp.widget.ImageView.a a2 = this.aRQ.a(imageFileInfo, false);
        if (a2 != null) {
            this.aRo = true;
            this.mProgressBar.setVisibility(8);
            b(a2);
            return;
        }
        this.aRQ.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.2
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.ImageView.a aVar, String str2, boolean z3) {
                UrlDragImageView.this.aRo = true;
                UrlDragImageView.this.mProgressBar.setVisibility(8);
                UrlDragImageView.this.b(aVar);
            }
        }, false);
    }

    private boolean gR(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null && this.aRm != null) {
            this.aRm.j(aVar.getUrl(), aVar.ov());
        }
        if (aVar == null || aVar.oq() == null) {
            JG();
            return;
        }
        Bitmap oq = aVar.oq();
        this.aRg.setLoadBigImage(true);
        if (aVar.isGif()) {
            this.aRg.setGifData(aVar.ov(), oq);
            this.aRg.invalidate();
            this.aRg.play();
            this.aRO = false;
            this.aRh.setVisibility(8);
            this.mProgressBar.setVisibility(8);
        } else {
            if (this.aRK != null && this.aRK.isLongPic) {
                this.aRg.Pn();
                this.aRg.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.3
                    @Override // com.baidu.tbadk.widget.largeImage.logic.a
                    public void JN() {
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                    }
                });
            } else {
                this.mProgressBar.setVisibility(8);
            }
            this.aRg.setImageUrlData(this.aRK);
            this.aRg.setImageData(oq, aVar.ov());
            JK();
        }
        JA();
        JC();
    }

    private void JG() {
        if (!this.aRn) {
            this.aRg.setDefaultBitmap();
        } else {
            this.aRo = false;
        }
        this.aRh.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    public void setGifMaxUseableMem(int i) {
        this.aRg.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.aRg != null) {
            this.aRg.onDestroy();
        }
        if (this.aRk != null) {
            this.aRk.recycle();
        }
        if (this.aRs != null) {
            this.aRs.recycle();
            this.aRs = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.aRV);
    }

    public void release() {
        if (this.aRg != null) {
            this.aRg.release();
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.aRh != null) {
            this.aRh.setVisibility(8);
        }
    }

    public void JH() {
        if (this.aRg != null && this.aRg.getImageType() == 1) {
            this.aRg.stop();
        }
    }

    public void k(boolean z, boolean z2) {
        String str;
        if (this.aRg != null && (str = (String) this.aRg.getTag()) != null) {
            if (this.aRg.getImageType() == 1) {
                if (this.aRg.getGifCache() == null || !this.aRg.Py()) {
                    b(str, z, z2);
                }
            } else if (this.aRg.getImageType() == 2) {
                b(str, z, z2);
            } else if (JI()) {
                b(str, z, z2);
            }
        }
    }

    private boolean JI() {
        if (this.aRg.getImageBitmap() != null && this.aRg.Py()) {
            if (this.aRK == null || !this.aRK.isLongPic || this.aRg.Po()) {
                return false;
            }
            this.aRo = false;
            this.aRM = false;
            return true;
        }
        return true;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.aRK = imageUrlData;
    }

    public void setIsCdn(boolean z) {
        this.aQa = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aRh) {
            if (!(this.aRh.getTag() instanceof Boolean) || ((Boolean) this.aRh.getTag()).booleanValue()) {
                final String fs = ar.fs(this.aRK.originalUrl);
                if (this.aRK.originalProcess >= 0) {
                    com.baidu.tbadk.download.d.KN().F(fs, 13);
                    this.aRK.originalProcess = -1;
                    JK();
                    return;
                }
                if (this.aQc != null) {
                    this.aQc.JO();
                }
                com.baidu.adp.base.e<?> aK = i.aK(this.mContext);
                if (aK == null) {
                    gS(fs);
                } else if (!j.kV() || j.kW() || com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("original_img_down_tip", false)) {
                    gS(fs);
                } else {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("original_img_down_tip", true);
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(aK.getPageActivity());
                    aVar.cN(e.j.original_img_down_no_wifi_tip);
                    aVar.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.4
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar.dismiss();
                            UrlDragImageView.this.gS(fs);
                        }
                    });
                    aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.5
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar.dismiss();
                        }
                    });
                    aVar.b(aK);
                    aVar.AB();
                }
            }
        } else if (view == this.aRi && this.aRK != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.mContext).createHistoryCfg(String.valueOf(this.aRK.threadId), String.valueOf(this.aRK.postId), this.aRK.mIsSeeHost, this.aRK.mIsReserver, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gS(String str) {
        if (this.aRK != null) {
            this.aRK.originalProcess = 0;
            this.aRh.setText("0%");
            this.aRh.setCompoundDrawablesWithIntrinsicBounds(0, 0, e.f.icon_close_yuantu, 0);
            DownloadData downloadData = new DownloadData(str);
            downloadData.setStatus(1);
            downloadData.setUrl(this.aRK.originalUrl);
            downloadData.setType(13);
            downloadData.setPath(this.aRE + an.CH().fl(str) + "/" + str);
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.6
                @Override // com.baidu.tbadk.download.c
                public boolean onPreDownload(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2 != null) {
                        if (UrlDragImageView.this.aRK != null && UrlDragImageView.this.aRK.originalProcess != -1) {
                            UrlDragImageView.this.aRK.originalProcess = downloadData2.getProcess();
                        }
                        if (UrlDragImageView.this.aRK == null || UrlDragImageView.this.aRK.originalProcess != -1) {
                            UrlDragImageView.this.aRh.setText(downloadData2.getProcess() + "%");
                            UrlDragImageView.this.aRh.setCompoundDrawablesWithIntrinsicBounds(0, 0, e.f.icon_close_yuantu, 0);
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public boolean onFileDownloaded(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadSucceed(DownloadData downloadData2) {
                    UrlDragImageView.this.aRh.setText(UrlDragImageView.this.getResources().getString(e.j.done));
                    UrlDragImageView.this.aRh.setTag(false);
                    UrlDragImageView.this.aRh.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    com.baidu.adp.lib.g.e.jG().postDelayed(UrlDragImageView.this.aRW, 1500L);
                    UrlDragImageView.this.aRM = false;
                    UrlDragImageView.this.aRL = UrlDragImageView.this.JJ();
                    UrlDragImageView.this.JF();
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str2) {
                    UrlDragImageView.this.aRM = false;
                    BdToast.a(UrlDragImageView.this.mContext, str2).AH().AJ();
                    UrlDragImageView.this.aRK.originalProcess = -1;
                    UrlDragImageView.this.JK();
                }
            });
            com.baidu.tbadk.download.d.KN().a(downloadData, 100);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean JJ() {
        if (this.aRK != null && !StringUtils.isNull(this.aRK.originalUrl, true) && this.aRK.originalSize >= 0 && !this.aRK.isBlockedPic) {
            String fs = ar.fs(this.aRK.originalUrl);
            File file = new File(this.aRE + an.CH().fl(fs) + "/" + fs);
            if (file != null && file.exists()) {
                this.aRK.originalProcess = 100;
                return true;
            }
            if (this.aRK.originalProcess < 0) {
                JK();
            } else {
                this.aRh.setText(this.aRK.originalProcess + "%");
                this.aRh.setCompoundDrawablesWithIntrinsicBounds(0, 0, e.f.icon_close_yuantu, 0);
            }
            this.aRO = true;
        } else {
            this.aRh.setVisibility(8);
        }
        return false;
    }

    public void JK() {
        if (this.aRK != null) {
            if (!JL() || !this.aRO) {
                this.aRh.setVisibility(8);
            } else {
                this.aRh.setVisibility(0);
            }
            if (this.aRK.originalSize > 0 && !af(this.aRK.originalSize)) {
                this.aRh.setText(aRe + "(" + ao.U(this.aRK.originalSize) + ")");
            } else {
                this.aRh.setText(aRe);
            }
            this.aRh.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    private boolean JL() {
        return (this.aRK == null || !this.aRK.mIsShowOrigonButton || this.aRK.isBlockedPic || StringUtils.isNull(this.aRK.originalUrl)) ? false : true;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.aQc = bVar;
    }

    private boolean af(long j) {
        return j > aRf;
    }
}
