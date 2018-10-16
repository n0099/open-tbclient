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
    private boolean aPk;
    private b aPm;
    private boolean aPn;
    private boolean aPo;
    private boolean aQA;
    private boolean aQB;
    private Bitmap aQC;
    private boolean aQD;
    private float aQE;
    private Matrix aQF;
    private Rect aQG;
    private RectF aQH;
    private RectF aQI;
    private Rect aQJ;
    private Rect aQK;
    private Rect aQL;
    private DragImageView.d aQM;
    private String aQO;
    private float aQP;
    private float aQQ;
    private float aQR;
    private float aQS;
    private float aQT;
    private ImageUrlData aQU;
    private boolean aQV;
    private boolean aQW;
    private boolean aQX;
    public boolean aQY;
    private TextView aQZ;
    protected DragImageView aQq;
    protected TextView aQr;
    protected TextView aQs;
    protected TextView aQt;
    protected SubsamplingScaleImageView aQu;
    private SubsamplingScaleImageView.OnImageEventListener aQv;
    private a aQw;
    private boolean aQx;
    private boolean aQy;
    private boolean aQz;
    private com.baidu.tbadk.img.b aRa;
    private View.OnTouchListener aRb;
    private boolean aRc;
    private float aRd;
    private View.OnLongClickListener aRe;
    private Runnable aRf;
    private Runnable aRg;
    private View.OnTouchListener aRh;
    protected Context mContext;
    private float mLastMotionX;
    private float mLastMotionY;
    private int mMaxHeight;
    private int mMaxWidth;
    private View.OnClickListener mOnClickListener;
    protected ProgressBar mProgressBar;
    private float mRatio;
    private int mSkinType;
    private static final String aQo = TbadkCoreApplication.getInst().getString(e.j.original_img_look);
    private static long aQp = Config.RAVEN_LOG_LIMIT;
    private static final int aQN = l.aQ(TbadkCoreApplication.getInst()) / 5;
    private static final String TAG = UrlDragImageView.class.getSimpleName();
    private static final int TOUCH_SLOP = ViewConfiguration.get(TbadkCoreApplication.getInst()).getScaledTouchSlop();

    /* loaded from: classes6.dex */
    public interface a {
        void j(String str, byte[] bArr);
    }

    /* loaded from: classes6.dex */
    public interface b {
        void JC();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.aQr != null) {
                al.i(this.aQr, e.f.btn_percent_yuantu);
                al.b(this.aQr, e.d.cp_cont_g, 1, 0);
            }
            if (this.aQs != null) {
                al.j(this.aQs, e.d.common_color_10022);
                al.b(this.aQs, e.d.cp_cont_g, 1, 0);
            }
            this.mSkinType = i;
        }
    }

    public void setHeadImage(boolean z) {
        if (this.aQq != null) {
            this.aQq.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.aQw = aVar;
    }

    public UrlDragImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mContext = null;
        this.mProgressBar = null;
        this.aQq = null;
        this.aQw = null;
        this.aPk = false;
        this.aQz = false;
        this.aQD = false;
        this.mRatio = 1.0f;
        this.aQE = 0.0f;
        this.aQF = new Matrix();
        this.aQH = new RectF();
        this.aQP = 0.0f;
        this.aQQ = 0.0f;
        this.aQR = 1.0f;
        this.aQS = 1.0f;
        this.aQT = 0.0f;
        this.aQV = false;
        this.aQW = false;
        this.aQX = false;
        this.aQY = false;
        this.aQZ = null;
        this.aRc = true;
        this.aRd = 0.0f;
        this.mOnClickListener = null;
        this.aRe = null;
        this.aRf = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.aRc = true;
            }
        };
        this.aRg = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.aQr.setVisibility(8);
                        UrlDragImageView.this.aQY = false;
                    }
                });
                UrlDragImageView.this.aQr.startAnimation(alphaAnimation);
            }
        };
        this.aRh = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.aRb != null) {
                    UrlDragImageView.this.aRb.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.aRa = new com.baidu.tbadk.img.b();
        init();
    }

    public UrlDragImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.mContext = null;
        this.mProgressBar = null;
        this.aQq = null;
        this.aQw = null;
        this.aPk = false;
        this.aQz = false;
        this.aQD = false;
        this.mRatio = 1.0f;
        this.aQE = 0.0f;
        this.aQF = new Matrix();
        this.aQH = new RectF();
        this.aQP = 0.0f;
        this.aQQ = 0.0f;
        this.aQR = 1.0f;
        this.aQS = 1.0f;
        this.aQT = 0.0f;
        this.aQV = false;
        this.aQW = false;
        this.aQX = false;
        this.aQY = false;
        this.aQZ = null;
        this.aRc = true;
        this.aRd = 0.0f;
        this.mOnClickListener = null;
        this.aRe = null;
        this.aRf = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.aRc = true;
            }
        };
        this.aRg = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.aQr.setVisibility(8);
                        UrlDragImageView.this.aQY = false;
                    }
                });
                UrlDragImageView.this.aQr.startAnimation(alphaAnimation);
            }
        };
        this.aRh = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.aRb != null) {
                    UrlDragImageView.this.aRb.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.aRa = new com.baidu.tbadk.img.b();
        init();
    }

    public DragImageView getImageView() {
        return this.aQq;
    }

    public void setGifSetListener(DragImageView.e eVar) {
        this.aQq.setGifSetListener(eVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.aQq.setImageOnClickListener(onClickListener);
        this.aQu.setOnClickListener(onClickListener);
        this.mOnClickListener = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aRe = onLongClickListener;
        if (!this.aPn) {
            this.aQq.setImageOnLongClickListener(this.aRe);
            this.aQu.setOnLongClickListener(this.aRe);
        }
    }

    public void setOnSizeChangedListener(final DragImageView.g gVar) {
        this.aQq.setOnSizeChangedListener(new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.8
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (gVar != null) {
                    gVar.a(dragImageView, z, z2);
                }
                UrlDragImageView.this.Jq();
            }
        });
    }

    protected void init() {
        this.mMaxWidth = l.aO(this.mContext);
        this.mMaxHeight = l.aQ(this.mContext) - ((int) this.mContext.getResources().getDimension(e.C0175e.ds166));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.aQq = new DragImageView(this.mContext);
        this.aQq.setLayoutParams(layoutParams);
        this.aQq.setOnTouchListener(this.aRh);
        addView(this.aQq);
        this.aQu = new SubsamplingScaleImageView(this.mContext);
        this.aQu.setMaxScale(50.0f);
        this.aQu.setOnTouchListener(this.aRh);
        this.aQu.setVisibility(4);
        addView(this.aQu, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(getResources().getDrawable(e.f.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        Jm();
        Jk();
        Jn();
    }

    private void Jk() {
        this.aQO = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        this.aQr = new TextView(this.mContext);
        al.i(this.aQr, e.f.btn_percent_yuantu);
        this.aQr.setText(e.j.original_img_look);
        this.aQr.setTextSize(0, getResources().getDimensionPixelSize(e.C0175e.fontsize28));
        al.b(this.aQr, e.d.cp_cont_i, 1, 0);
        this.aQr.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(e.C0175e.ds16);
        this.aQr.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        this.aQr.setMinWidth(getResources().getDimensionPixelSize(e.C0175e.ds222));
        this.aQr.setMinHeight(getResources().getDimensionPixelSize(e.C0175e.ds60));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(e.C0175e.fontsize40);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        this.aQr.setOnClickListener(this);
        this.aQr.setVisibility(8);
        addView(this.aQr, layoutParams);
    }

    public void setIsCanDrag(boolean z) {
        this.aPn = z;
    }

    public void setIsHotSort(boolean z) {
        this.aPo = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        Bitmap imageBitmap;
        int height;
        int width;
        if (!this.aPn || !this.aQy) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.aQA && motionEvent.getPointerCount() >= 2) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.aQA || this.aQB) {
            requestDisallowInterceptTouchEvent(true);
        }
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        float x = motionEvent.getX();
        int i = action & 255;
        if (i == 0) {
            if (this.aQC == null) {
                if (this.aQu.getVisibility() == 0) {
                    this.aQC = com.baidu.tbadk.util.e.af(this.aQu);
                } else {
                    this.aQC = com.baidu.tbadk.util.e.af(this.aQq);
                }
            }
            if (this.aQG == null && this.aQC != null) {
                int measuredWidth = getMeasuredWidth();
                float measuredWidth2 = ((getMeasuredWidth() * 1.0f) / this.aQC.getWidth()) * this.aQC.getHeight();
                if (measuredWidth2 > getMeasuredHeight()) {
                    measuredWidth2 = getMeasuredHeight();
                }
                RectF h = h(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
                this.aQG = new Rect((int) h.left, (int) h.top, (int) h.right, (int) h.bottom);
            }
            if (this.aQK == null && this.aQC != null) {
                if (this.aQu.getVisibility() == 0) {
                    height = this.aQu.getSHeight();
                    width = this.aQu.getSWidth();
                } else {
                    if (this.aQq.getImageType() == 1) {
                        imageBitmap = (this.aQq.getCurrentFrame() == null || this.aQq.getCurrentFrame().bfJ == null) ? this.aQC : this.aQq.getCurrentFrame().bfJ;
                    } else {
                        imageBitmap = this.aQq.getImageBitmap() == null ? this.aQC : this.aQq.getImageBitmap();
                    }
                    height = imageBitmap.getHeight();
                    width = imageBitmap.getWidth();
                }
                float aR = l.aR(getContext());
                int i2 = (int) (height * aR);
                int i3 = (int) (width * aR);
                if (i3 > this.aQC.getWidth() && this.aQC.getWidth() != 0) {
                    float width2 = (i3 * 1.0f) / this.aQC.getWidth();
                    i3 = this.aQC.getWidth();
                    i2 = (int) (i2 / width2);
                }
                if (i2 > this.aQC.getHeight() && this.aQC.getHeight() != 0) {
                    i3 = (int) (i3 / ((i2 * 1.0f) / this.aQC.getHeight()));
                    i2 = this.aQC.getHeight();
                }
                int aQ = (l.aQ(getContext()) - i2) / 2;
                int aO = (l.aO(getContext()) - i3) / 2;
                this.aQK = new Rect(aO, aQ, i3 + aO, i2 + aQ);
                this.aQL = new Rect(this.aQK);
                this.aQT = aQ / l.aQ(getContext());
                this.aQJ = new Rect(0, 0, this.aQC.getWidth(), this.aQC.getHeight());
            }
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (i == 2) {
            this.aQA = l(this.mLastMotionX - x, this.mLastMotionY - y);
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (this.aQA || this.aQB) {
            this.aQq.setImageOnLongClickListener(null);
            this.aQu.setOnLongClickListener(null);
            z = true;
        } else {
            this.aQq.setImageOnLongClickListener(this.aRe);
            this.aQu.setOnLongClickListener(this.aRe);
            z = super.dispatchTouchEvent(motionEvent);
        }
        if (i == 1 || i == 3) {
            this.mLastMotionX = 0.0f;
            this.mLastMotionY = 0.0f;
            this.aQD = false;
            this.aQF.reset();
            this.aQA = false;
            if (this.aQE > aQN) {
                this.aQB = true;
                Jl();
                return z;
            }
            this.mRatio = 1.0f;
            invalidate();
            return z;
        }
        return z;
    }

    private boolean l(float f, float f2) {
        if (this.aQu.getVisibility() != 0 || this.aQu.isCanDrag()) {
            if (this.aQU == null || !this.aQU.isLongPic || this.aQu.getVisibility() != 0 || this.aQu.isViewTop()) {
                if (this.aQU == null || !this.aQU.isLongPic || this.aQu.getVisibility() == 0 || this.aQq.OZ()) {
                    if (this.aQu.getVisibility() == 0 || this.aQq.Pb()) {
                        if (this.aQC != null && getScrollY() == 0 && f2 < 0.0f && !this.aQD) {
                            this.aQD = true;
                            this.aQE = 0.0f;
                            this.mRatio = 1.0f;
                            if (this.aQM != null) {
                                this.aQM.Pr();
                            }
                        }
                        if (this.aQD) {
                            this.aQE -= f2;
                            int measuredHeight = getMeasuredHeight();
                            if (this.aQE > measuredHeight) {
                                this.aQE = measuredHeight;
                            }
                            float f3 = f2 / measuredHeight;
                            this.aQF.postTranslate((-f) * 1.5f * this.mRatio, (-1.5f) * f2 * this.mRatio);
                            if (this.mRatio * (1.0f + f3) > 1.0f || this.aQE < 0.0f) {
                                this.aQF.preScale(1.0f / this.mRatio, 1.0f / this.mRatio, (this.mRatio * this.aQC.getWidth()) / 2.0f, this.mRatio * (this.aQC.getHeight() / 2));
                                this.mRatio = 1.0f;
                            } else {
                                this.aQF.preScale(1.0f + f3, 1.0f + f3, (this.mRatio * this.aQC.getWidth()) / 2.0f, this.mRatio * (this.aQC.getHeight() / 2));
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
        if (this.aQA && this.aQC != null && !this.aQC.isRecycled() && this.aQD) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.aQH == null) {
                this.aQH = new RectF();
            }
            this.aQF.mapRect(this.aQH, new RectF(this.aQG));
            canvas.drawBitmap(this.aQC, this.aQJ, this.aQH, (Paint) null);
        } else if (this.aQB && this.aQC != null && !this.aQC.isRecycled()) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.aQU == null || this.aQU.getSourceImageRectInScreen() == null) {
                canvas.drawBitmap(this.aQC, this.aQJ, this.aQH, (Paint) null);
            } else {
                canvas.drawBitmap(this.aQC, this.aQK, this.aQH, (Paint) null);
            }
        } else {
            super.dispatchDraw(canvas);
        }
    }

    private void Jl() {
        if (this.aQU == null) {
            if (this.aQM != null) {
                this.aQM.Ps();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.aQU.getSourceImageRectInScreen();
        final Rect dstRectInScreen = this.aQU.getDstRectInScreen();
        if (sourceImageRectInScreen == null || dstRectInScreen == null) {
            if (this.aQM != null) {
                this.aQM.Ps();
                return;
            }
            return;
        }
        a(sourceImageRectInScreen, dstRectInScreen);
        e(sourceImageRectInScreen);
        this.aQI = new RectF(this.aQH);
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
                UrlDragImageView.this.aQD = false;
                UrlDragImageView.this.invalidate();
                if (UrlDragImageView.this.aQM != null) {
                    UrlDragImageView.this.aQM.Ps();
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
            float f = ((rect.bottom - rect.top) / (rect.right - rect.left)) * (this.aQH.right - this.aQH.left);
            this.aQH.top += this.aQH.height() * this.aQT;
            this.aQH.bottom = f + this.aQH.top;
        }
    }

    private void a(Rect rect, Rect rect2) {
        this.aQP = 0.0f;
        this.aQQ = 0.0f;
        this.aQR = 1.0f;
        this.aQS = 1.0f;
        if (rect != null && rect2 != null && rect.contains(rect2)) {
            this.aQP = (rect2.left - rect.left) / rect.width();
            this.aQQ = (rect2.top - rect.top) / rect.height();
            this.aQR = (rect2.right - rect.left) / rect.width();
            this.aQS = (rect2.bottom - rect.top) / rect.height();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa(float f) {
        if (this.aQK != null) {
            this.aQK.left = (int) (this.aQL.left + (this.aQL.width() * this.aQP * f));
            this.aQK.top = (int) (this.aQL.top + (this.aQL.height() * this.aQQ * f));
            this.aQK.right = (int) (this.aQL.left + (this.aQL.width() * (((1.0f - this.aQR) * (1.0f - f)) + this.aQR)));
            this.aQK.bottom = (int) (this.aQL.top + (this.aQL.height() * (((1.0f - this.aQS) * (1.0f - f)) + this.aQS)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Rect rect, float f) {
        if (this.aQH != null && rect != null) {
            this.aQH.left = this.aQI.left + ((rect.left - this.aQI.left) * f);
            this.aQH.top = this.aQI.top + ((rect.top - this.aQI.top) * f);
            this.aQH.right = this.aQI.right + ((rect.right - this.aQI.right) * f);
            this.aQH.bottom = this.aQI.bottom + ((rect.bottom - this.aQI.bottom) * f);
        }
    }

    private RectF h(float f, float f2, float f3, float f4) {
        return new RectF(f - (f3 / 2.0f), f2 - (f4 / 2.0f), (f3 / 2.0f) + f, (f4 / 2.0f) + f2);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.aRb = onTouchListener;
    }

    private void Jm() {
        this.aQZ = new TextView(this.mContext);
        this.aQZ.setBackgroundResource(e.f.bg_url_drag_imagview_fade_view);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.height = getResources().getDimensionPixelSize(e.C0175e.ds180);
        layoutParams.addRule(12);
        addView(this.aQZ, layoutParams);
        this.aQZ.setVisibility(8);
    }

    private void Jn() {
        this.aQs = new TextView(this.mContext);
        al.j(this.aQs, e.d.common_color_10022);
        this.aQs.setText(e.j.goto_pb_floor);
        this.aQs.setTextSize(0, getResources().getDimensionPixelSize(e.C0175e.fontsize28));
        al.b(this.aQs, e.d.cp_cont_i, 1, 0);
        this.aQs.setCompoundDrawablePadding(l.dip2px(this.mContext, 4.0f));
        this.aQs.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_see_arrow), (Drawable) null);
        this.aQs.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(e.C0175e.ds20);
        this.aQs.setPadding(dimensionPixelSize * 3, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(e.C0175e.ds30);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(e.C0175e.ds10);
        layoutParams.leftMargin = getResources().getDimensionPixelSize(e.C0175e.ds20);
        layoutParams.addRule(1, this.aQr.getId());
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        this.aQs.setOnClickListener(this);
        this.aQs.setMinHeight(getResources().getDimensionPixelSize(e.C0175e.ds100));
        addView(this.aQs, layoutParams);
        this.aQs.setVisibility(8);
    }

    private void Jo() {
        if (this.aQs != null) {
            boolean z = this.aQx || this.aQy;
            if (!this.aQX && z && this.aQU != null && this.aQU.threadId > 0 && this.aQU.postId > 0 && this.aQU.mThreadType != 33 && !this.aQU.isBlockedPic && !this.aPo) {
                this.aQs.setVisibility(0);
                if (this.aQZ != null) {
                    this.aQZ.setVisibility(0);
                    return;
                }
                return;
            }
            this.aQs.setVisibility(8);
            if (this.aQZ != null) {
                this.aQZ.setVisibility(8);
            }
        }
    }

    private void Jp() {
        if (this.aQs != null) {
            this.aQs.setVisibility(8);
            if (this.aQZ != null) {
                this.aQZ.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jq() {
        if ((this.aQx || this.aQy) && this.aQU != null && this.aQU.mPicType == 1 && !TextUtils.isEmpty(this.aQU.mTagName)) {
            if (this.aQt != null) {
                this.aQt.setVisibility(8);
                this.aQt = null;
            }
            this.aQt = new TextView(this.mContext);
            this.aQt.setText(this.aQU.mTagName);
            this.aQt.setTextSize(0, getResources().getDimensionPixelSize(e.C0175e.fontsize26));
            al.b(this.aQt, e.d.common_color_10013, 1, 0);
            al.j(this.aQt, e.d.common_color_10215);
            this.aQt.setAlpha(0.75f);
            this.aQt.setIncludeFontPadding(false);
            this.aQt.setGravity(17);
            int h = l.h(this.mContext, e.C0175e.ds2);
            this.aQt.setPadding(h, h, h, h);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.aQq.getBottomOffset();
            layoutParams.leftMargin = this.aQq.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.aQt, layoutParams);
            this.aQt.setVisibility(0);
        }
    }

    public void bN(boolean z) {
        this.aQX = z;
        if (this.aQX) {
            Jp();
        } else {
            Jo();
        }
    }

    public void setUrl(String str, boolean z) {
        if (str.contains("*")) {
            str = str.split("[*]")[0];
        }
        this.aQq.setTag(str);
        this.aQq.setLoadBigImage(false);
        this.aQq.setImageDrawable(null);
        this.aQx = false;
        this.aQy = false;
        this.aQV = Jx();
        this.aQr.setVisibility(8);
        if (gP(str)) {
            b(str, z, false);
        }
    }

    private boolean Jr() {
        return this.aQq != null && this.aQq.Pp();
    }

    public void Js() {
        if (this.aQU != null && !Jr()) {
            String str = this.aQU.imageUrl;
            int i = this.aQU.urlType;
            com.baidu.adp.widget.ImageView.a aVar = null;
            if (com.baidu.tbadk.core.util.d.a.B(str, i)) {
                aVar = com.baidu.tbadk.core.util.d.a.C(str, i);
            }
            if (aVar != null) {
                setThumbBitmapToView(aVar);
            }
        }
    }

    private boolean bO(boolean z) {
        String fs;
        if (!this.aQW || z) {
            this.aQW = true;
            if (!this.aQV || this.aQU == null || StringUtils.isNull(this.aQU.originalUrl, true) || this.aQU.originalSize < 0 || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String str = this.aQO + an.CA().fl(fs) + "/" + ar.fs(this.aQU.originalUrl);
            final int[] eP = com.baidu.tbadk.core.util.l.eP(str);
            this.aQu.setVisibility(0);
            if (this.aQv == null) {
                this.aQv = new SubsamplingScaleImageView.OnImageEventListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12
                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onReady() {
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.aQq.Pl();
                        UrlDragImageView.this.aQq.setVisibility(4);
                    }

                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onImageLoaded() {
                        if (UrlDragImageView.this.aQU.isLongPic && eP[0] > 0) {
                            UrlDragImageView.this.aQq.onDestroy();
                            final float measuredWidth = (UrlDragImageView.this.getMeasuredWidth() * 1.0f) / eP[0];
                            final PointF pointF = new PointF((eP[0] * 1.0f) / 2.0f, 0.0f);
                            UrlDragImageView.this.aQu.setScaleAndCenter(measuredWidth, pointF);
                            UrlDragImageView.this.aQu.setMaxScale(2.0f * measuredWidth);
                            UrlDragImageView.this.aQu.setDoubleTapZoomScale(2.0f * measuredWidth);
                            UrlDragImageView.this.aQu.setInitScale(measuredWidth);
                            UrlDragImageView.this.aQu.setDoubleTapZoomStyle(4);
                            UrlDragImageView.this.aQu.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12.1
                                @Override // android.view.View.OnTouchListener
                                public boolean onTouch(View view, MotionEvent motionEvent) {
                                    if (UrlDragImageView.this.aRb != null) {
                                        UrlDragImageView.this.aRb.onTouch(view, motionEvent);
                                    }
                                    switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                                        case 0:
                                            UrlDragImageView.this.aRd = motionEvent.getY();
                                            UrlDragImageView.this.aQu.setOnClickListener(UrlDragImageView.this.aRc ? UrlDragImageView.this.mOnClickListener : null);
                                            UrlDragImageView.this.aQu.setOnLongClickListener(UrlDragImageView.this.aRc ? UrlDragImageView.this.aRe : null);
                                            break;
                                        case 1:
                                        case 3:
                                            if (UrlDragImageView.this.aQu.getScale() < measuredWidth) {
                                                UrlDragImageView.this.aQu.setScaleAndCenter(measuredWidth, pointF);
                                            }
                                            com.baidu.adp.lib.g.e.jI().removeCallbacks(UrlDragImageView.this.aRf);
                                            com.baidu.adp.lib.g.e.jI().postDelayed(UrlDragImageView.this.aRf, 1000L);
                                            break;
                                        case 2:
                                            if (Math.abs(motionEvent.getY() - UrlDragImageView.this.aRd) > UrlDragImageView.TOUCH_SLOP) {
                                                UrlDragImageView.this.aRc = false;
                                                UrlDragImageView.this.aQu.setOnClickListener(null);
                                                UrlDragImageView.this.aQu.setOnLongClickListener(null);
                                            }
                                            UrlDragImageView.this.aRd = motionEvent.getY();
                                            break;
                                    }
                                    return false;
                                }
                            });
                            UrlDragImageView.this.aQq.setVisibility(4);
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
            this.aQu.setOnImageEventListener(this.aQv);
            if (this.aQu.isImageLoaded() && this.aQU.isLongPic) {
                this.aQv.onImageLoaded();
            } else {
                this.aQu.setImage(ImageSource.uri(str));
            }
            return true;
        }
        return false;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.aQM = dVar;
        if (this.aQq != null) {
            this.aQq.setDragToExitListener(dVar);
        }
    }

    public void Jt() {
        bO(false);
    }

    private boolean gP(String str) {
        return j.kX() || c.fJ(str);
    }

    private void setThumbBitmapToView(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap os;
        if (!this.aQy && aVar != null && (os = aVar.os()) != null) {
            this.aQx = true;
            if (aVar.isGif()) {
                this.aQq.setImageUrlData(this.aQU);
                this.aQq.setImageBitmap(os);
                this.aQr.setVisibility(8);
                this.aQY = false;
            } else {
                if (this.aQU != null && this.aQU.isLongPic) {
                    this.aQq.Pe();
                    this.aQq.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.13
                        @Override // com.baidu.tbadk.widget.largeImage.logic.a
                        public void JB() {
                        }
                    });
                }
                this.aQq.setImageUrlData(this.aQU);
                this.aQq.setImageData(os, aVar.ox());
            }
            Jo();
            Jq();
        }
    }

    private void b(String str, boolean z, boolean z2) {
        if (gQ(str)) {
            if (z2 || (!this.aQz && !this.aQy)) {
                if (!z2 || !bO(true)) {
                    this.aQz = true;
                    com.baidu.adp.lib.f.c.jC().a(str, 27, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.14
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onCancelled(String str2) {
                            UrlDragImageView.this.aQz = false;
                            UrlDragImageView.this.aQq.setVisibility(0);
                            UrlDragImageView.this.mProgressBar.setVisibility(8);
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            UrlDragImageView.this.aQz = false;
                            UrlDragImageView.this.aQy = true;
                            UrlDragImageView.this.b(aVar);
                        }
                    }, 0, 0, false, null, Boolean.valueOf(z), this.aQq.getImageData(), Boolean.valueOf(this.aPk));
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
        com.baidu.adp.widget.ImageView.a a2 = this.aRa.a(imageFileInfo, false);
        if (a2 != null) {
            this.aQy = true;
            this.mProgressBar.setVisibility(8);
            b(a2);
            return;
        }
        this.aRa.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.2
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.ImageView.a aVar, String str2, boolean z3) {
                UrlDragImageView.this.aQy = true;
                UrlDragImageView.this.mProgressBar.setVisibility(8);
                UrlDragImageView.this.b(aVar);
            }
        }, false);
    }

    private boolean gQ(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null && this.aQw != null) {
            this.aQw.j(aVar.getUrl(), aVar.ox());
        }
        if (aVar == null || aVar.os() == null) {
            Ju();
            return;
        }
        Bitmap os = aVar.os();
        this.aQq.setLoadBigImage(true);
        if (aVar.isGif()) {
            this.aQq.setGifData(aVar.ox(), os);
            this.aQq.invalidate();
            this.aQq.play();
            this.aQY = false;
            this.aQr.setVisibility(8);
            this.mProgressBar.setVisibility(8);
        } else {
            if (this.aQU != null && this.aQU.isLongPic) {
                this.aQq.Pe();
                this.aQq.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.3
                    @Override // com.baidu.tbadk.widget.largeImage.logic.a
                    public void JB() {
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                    }
                });
            } else {
                this.mProgressBar.setVisibility(8);
            }
            this.aQq.setImageUrlData(this.aQU);
            this.aQq.setImageData(os, aVar.ox());
            Jy();
        }
        Jo();
        Jq();
    }

    private void Ju() {
        if (!this.aQx) {
            this.aQq.setDefaultBitmap();
        } else {
            this.aQy = false;
        }
        this.aQr.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    public void setGifMaxUseableMem(int i) {
        this.aQq.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.aQq != null) {
            this.aQq.onDestroy();
        }
        if (this.aQu != null) {
            this.aQu.recycle();
        }
        if (this.aQC != null) {
            this.aQC.recycle();
            this.aQC = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.aRf);
    }

    public void release() {
        if (this.aQq != null) {
            this.aQq.release();
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.aQr != null) {
            this.aQr.setVisibility(8);
        }
    }

    public void Jv() {
        if (this.aQq != null && this.aQq.getImageType() == 1) {
            this.aQq.stop();
        }
    }

    public void k(boolean z, boolean z2) {
        String str;
        if (this.aQq != null && (str = (String) this.aQq.getTag()) != null) {
            if (this.aQq.getImageType() == 1) {
                if (this.aQq.getGifCache() == null || !this.aQq.Pp()) {
                    b(str, z, z2);
                }
            } else if (this.aQq.getImageType() == 2) {
                b(str, z, z2);
            } else if (Jw()) {
                b(str, z, z2);
            }
        }
    }

    private boolean Jw() {
        if (this.aQq.getImageBitmap() != null && this.aQq.Pp()) {
            if (this.aQU == null || !this.aQU.isLongPic || this.aQq.Pf()) {
                return false;
            }
            this.aQy = false;
            this.aQW = false;
            return true;
        }
        return true;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.aQU = imageUrlData;
    }

    public void setIsCdn(boolean z) {
        this.aPk = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aQr) {
            if (!(this.aQr.getTag() instanceof Boolean) || ((Boolean) this.aQr.getTag()).booleanValue()) {
                final String fs = ar.fs(this.aQU.originalUrl);
                if (this.aQU.originalProcess >= 0) {
                    com.baidu.tbadk.download.d.KB().F(fs, 13);
                    this.aQU.originalProcess = -1;
                    Jy();
                    return;
                }
                if (this.aPm != null) {
                    this.aPm.JC();
                }
                com.baidu.adp.base.e<?> aK = i.aK(this.mContext);
                if (aK == null) {
                    gR(fs);
                } else if (!j.kX() || j.kY() || com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("original_img_down_tip", false)) {
                    gR(fs);
                } else {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("original_img_down_tip", true);
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(aK.getPageActivity());
                    aVar.cz(e.j.original_img_down_no_wifi_tip);
                    aVar.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.4
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar.dismiss();
                            UrlDragImageView.this.gR(fs);
                        }
                    });
                    aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.5
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar.dismiss();
                        }
                    });
                    aVar.b(aK);
                    aVar.Au();
                }
            }
        } else if (view == this.aQs && this.aQU != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.mContext).createHistoryCfg(String.valueOf(this.aQU.threadId), String.valueOf(this.aQU.postId), this.aQU.mIsSeeHost, this.aQU.mIsReserver, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gR(String str) {
        if (this.aQU != null) {
            this.aQU.originalProcess = 0;
            this.aQr.setText("0%");
            this.aQr.setCompoundDrawablesWithIntrinsicBounds(0, 0, e.f.icon_close_yuantu, 0);
            DownloadData downloadData = new DownloadData(str);
            downloadData.setStatus(1);
            downloadData.setUrl(this.aQU.originalUrl);
            downloadData.setType(13);
            downloadData.setPath(this.aQO + an.CA().fl(str) + "/" + str);
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.6
                @Override // com.baidu.tbadk.download.c
                public boolean onPreDownload(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2 != null) {
                        if (UrlDragImageView.this.aQU != null && UrlDragImageView.this.aQU.originalProcess != -1) {
                            UrlDragImageView.this.aQU.originalProcess = downloadData2.getProcess();
                        }
                        if (UrlDragImageView.this.aQU == null || UrlDragImageView.this.aQU.originalProcess != -1) {
                            UrlDragImageView.this.aQr.setText(downloadData2.getProcess() + "%");
                            UrlDragImageView.this.aQr.setCompoundDrawablesWithIntrinsicBounds(0, 0, e.f.icon_close_yuantu, 0);
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public boolean onFileDownloaded(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadSucceed(DownloadData downloadData2) {
                    UrlDragImageView.this.aQr.setText(UrlDragImageView.this.getResources().getString(e.j.done));
                    UrlDragImageView.this.aQr.setTag(false);
                    UrlDragImageView.this.aQr.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    com.baidu.adp.lib.g.e.jI().postDelayed(UrlDragImageView.this.aRg, 1500L);
                    UrlDragImageView.this.aQW = false;
                    UrlDragImageView.this.aQV = UrlDragImageView.this.Jx();
                    UrlDragImageView.this.Jt();
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str2) {
                    UrlDragImageView.this.aQW = false;
                    BdToast.a(UrlDragImageView.this.mContext, str2).AA().AC();
                    UrlDragImageView.this.aQU.originalProcess = -1;
                    UrlDragImageView.this.Jy();
                }
            });
            com.baidu.tbadk.download.d.KB().a(downloadData, 100);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Jx() {
        if (this.aQU != null && !StringUtils.isNull(this.aQU.originalUrl, true) && this.aQU.originalSize >= 0 && !this.aQU.isBlockedPic) {
            String fs = ar.fs(this.aQU.originalUrl);
            File file = new File(this.aQO + an.CA().fl(fs) + "/" + fs);
            if (file != null && file.exists()) {
                this.aQU.originalProcess = 100;
                return true;
            }
            if (this.aQU.originalProcess < 0) {
                Jy();
            } else {
                this.aQr.setText(this.aQU.originalProcess + "%");
                this.aQr.setCompoundDrawablesWithIntrinsicBounds(0, 0, e.f.icon_close_yuantu, 0);
            }
            this.aQY = true;
        } else {
            this.aQr.setVisibility(8);
        }
        return false;
    }

    public void Jy() {
        if (this.aQU != null) {
            if (!Jz() || !this.aQY) {
                this.aQr.setVisibility(8);
            } else {
                this.aQr.setVisibility(0);
            }
            if (this.aQU.originalSize > 0 && !ad(this.aQU.originalSize)) {
                this.aQr.setText(aQo + "(" + ao.S(this.aQU.originalSize) + ")");
            } else {
                this.aQr.setText(aQo);
            }
            this.aQr.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    private boolean Jz() {
        return (this.aQU == null || !this.aQU.mIsShowOrigonButton || this.aQU.isBlockedPic || StringUtils.isNull(this.aQU.originalUrl)) ? false : true;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.aPm = bVar;
    }

    private boolean ad(long j) {
        return j > aQp;
    }
}
