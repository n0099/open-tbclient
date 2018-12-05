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
    private b aTB;
    private boolean aTC;
    private boolean aTD;
    private boolean aTz;
    protected DragImageView aUD;
    protected TextView aUE;
    protected TextView aUF;
    protected TextView aUG;
    protected SubsamplingScaleImageView aUH;
    private SubsamplingScaleImageView.OnImageEventListener aUI;
    private a aUJ;
    private boolean aUK;
    private boolean aUL;
    private boolean aUM;
    private boolean aUN;
    private boolean aUO;
    private Bitmap aUP;
    private boolean aUQ;
    private float aUR;
    private Matrix aUS;
    private Rect aUT;
    private RectF aUU;
    private RectF aUV;
    private Rect aUW;
    private Rect aUX;
    private Rect aUY;
    private DragImageView.d aUZ;
    private String aVb;
    private float aVc;
    private float aVd;
    private float aVe;
    private float aVf;
    private float aVg;
    private ImageUrlData aVh;
    private boolean aVi;
    private boolean aVj;
    private boolean aVk;
    public boolean aVl;
    private TextView aVm;
    private com.baidu.tbadk.img.b aVn;
    private View.OnTouchListener aVo;
    private boolean aVp;
    private float aVq;
    private View.OnLongClickListener aVr;
    private Runnable aVs;
    private Runnable aVt;
    private View.OnTouchListener aVu;
    protected Context mContext;
    private float mLastMotionX;
    private float mLastMotionY;
    private int mMaxHeight;
    private int mMaxWidth;
    private View.OnClickListener mOnClickListener;
    protected ProgressBar mProgressBar;
    private float mRatio;
    private int mSkinType;
    private static final String aUB = TbadkCoreApplication.getInst().getString(e.j.original_img_look);
    private static long aUC = Config.RAVEN_LOG_LIMIT;
    private static final int aVa = l.aQ(TbadkCoreApplication.getInst()) / 5;
    private static final String TAG = UrlDragImageView.class.getSimpleName();
    private static final int TOUCH_SLOP = ViewConfiguration.get(TbadkCoreApplication.getInst()).getScaledTouchSlop();

    /* loaded from: classes6.dex */
    public interface a {
        void j(String str, byte[] bArr);
    }

    /* loaded from: classes6.dex */
    public interface b {
        void KS();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.aUE != null) {
                al.i(this.aUE, e.f.btn_percent_yuantu);
                al.b(this.aUE, e.d.cp_cont_g, 1, 0);
            }
            if (this.aUF != null) {
                al.j(this.aUF, e.d.common_color_10022);
                al.b(this.aUF, e.d.cp_cont_g, 1, 0);
            }
            this.mSkinType = i;
        }
    }

    public void setHeadImage(boolean z) {
        if (this.aUD != null) {
            this.aUD.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.aUJ = aVar;
    }

    public UrlDragImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mContext = null;
        this.mProgressBar = null;
        this.aUD = null;
        this.aUJ = null;
        this.aTz = false;
        this.aUM = false;
        this.aUQ = false;
        this.mRatio = 1.0f;
        this.aUR = 0.0f;
        this.aUS = new Matrix();
        this.aUU = new RectF();
        this.aVc = 0.0f;
        this.aVd = 0.0f;
        this.aVe = 1.0f;
        this.aVf = 1.0f;
        this.aVg = 0.0f;
        this.aVi = false;
        this.aVj = false;
        this.aVk = false;
        this.aVl = false;
        this.aVm = null;
        this.aVp = true;
        this.aVq = 0.0f;
        this.mOnClickListener = null;
        this.aVr = null;
        this.aVs = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.aVp = true;
            }
        };
        this.aVt = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.aUE.setVisibility(8);
                        UrlDragImageView.this.aVl = false;
                    }
                });
                UrlDragImageView.this.aUE.startAnimation(alphaAnimation);
            }
        };
        this.aVu = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.aVo != null) {
                    UrlDragImageView.this.aVo.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.aVn = new com.baidu.tbadk.img.b();
        init();
    }

    public UrlDragImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.mContext = null;
        this.mProgressBar = null;
        this.aUD = null;
        this.aUJ = null;
        this.aTz = false;
        this.aUM = false;
        this.aUQ = false;
        this.mRatio = 1.0f;
        this.aUR = 0.0f;
        this.aUS = new Matrix();
        this.aUU = new RectF();
        this.aVc = 0.0f;
        this.aVd = 0.0f;
        this.aVe = 1.0f;
        this.aVf = 1.0f;
        this.aVg = 0.0f;
        this.aVi = false;
        this.aVj = false;
        this.aVk = false;
        this.aVl = false;
        this.aVm = null;
        this.aVp = true;
        this.aVq = 0.0f;
        this.mOnClickListener = null;
        this.aVr = null;
        this.aVs = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.aVp = true;
            }
        };
        this.aVt = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.aUE.setVisibility(8);
                        UrlDragImageView.this.aVl = false;
                    }
                });
                UrlDragImageView.this.aUE.startAnimation(alphaAnimation);
            }
        };
        this.aVu = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.aVo != null) {
                    UrlDragImageView.this.aVo.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.aVn = new com.baidu.tbadk.img.b();
        init();
    }

    public DragImageView getImageView() {
        return this.aUD;
    }

    public void setGifSetListener(DragImageView.e eVar) {
        this.aUD.setGifSetListener(eVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.aUD.setImageOnClickListener(onClickListener);
        this.aUH.setOnClickListener(onClickListener);
        this.mOnClickListener = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aVr = onLongClickListener;
        if (!this.aTC) {
            this.aUD.setImageOnLongClickListener(this.aVr);
            this.aUH.setOnLongClickListener(this.aVr);
        }
    }

    public void setOnSizeChangedListener(final DragImageView.g gVar) {
        this.aUD.setOnSizeChangedListener(new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.8
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (gVar != null) {
                    gVar.a(dragImageView, z, z2);
                }
                UrlDragImageView.this.KG();
            }
        });
    }

    protected void init() {
        this.mMaxWidth = l.aO(this.mContext);
        this.mMaxHeight = l.aQ(this.mContext) - ((int) this.mContext.getResources().getDimension(e.C0210e.ds166));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.aUD = new DragImageView(this.mContext);
        this.aUD.setLayoutParams(layoutParams);
        this.aUD.setOnTouchListener(this.aVu);
        addView(this.aUD);
        this.aUH = new SubsamplingScaleImageView(this.mContext);
        this.aUH.setMaxScale(50.0f);
        this.aUH.setOnTouchListener(this.aVu);
        this.aUH.setVisibility(4);
        addView(this.aUH, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(getResources().getDrawable(e.f.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        KC();
        KA();
        KD();
    }

    private void KA() {
        this.aVb = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        this.aUE = new TextView(this.mContext);
        al.i(this.aUE, e.f.btn_percent_yuantu);
        this.aUE.setText(e.j.original_img_look);
        this.aUE.setTextSize(0, getResources().getDimensionPixelSize(e.C0210e.fontsize28));
        al.b(this.aUE, e.d.cp_cont_i, 1, 0);
        this.aUE.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(e.C0210e.ds16);
        this.aUE.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        this.aUE.setMinWidth(getResources().getDimensionPixelSize(e.C0210e.ds222));
        this.aUE.setMinHeight(getResources().getDimensionPixelSize(e.C0210e.ds60));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(e.C0210e.fontsize40);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        this.aUE.setOnClickListener(this);
        this.aUE.setVisibility(8);
        addView(this.aUE, layoutParams);
    }

    public void setIsCanDrag(boolean z) {
        this.aTC = z;
    }

    public void setIsHotSort(boolean z) {
        this.aTD = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        Bitmap imageBitmap;
        int height;
        int width;
        if (!this.aTC || !this.aUL) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.aUN && motionEvent.getPointerCount() >= 2) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.aUN || this.aUO) {
            requestDisallowInterceptTouchEvent(true);
        }
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        float x = motionEvent.getX();
        int i = action & 255;
        if (i == 0) {
            if (this.aUP == null) {
                if (this.aUH.getVisibility() == 0) {
                    this.aUP = com.baidu.tbadk.util.e.ae(this.aUH);
                } else {
                    this.aUP = com.baidu.tbadk.util.e.ae(this.aUD);
                }
            }
            if (this.aUT == null && this.aUP != null) {
                int measuredWidth = getMeasuredWidth();
                float measuredWidth2 = ((getMeasuredWidth() * 1.0f) / this.aUP.getWidth()) * this.aUP.getHeight();
                if (measuredWidth2 > getMeasuredHeight()) {
                    measuredWidth2 = getMeasuredHeight();
                }
                RectF h = h(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
                this.aUT = new Rect((int) h.left, (int) h.top, (int) h.right, (int) h.bottom);
            }
            if (this.aUX == null && this.aUP != null) {
                if (this.aUH.getVisibility() == 0) {
                    height = this.aUH.getSHeight();
                    width = this.aUH.getSWidth();
                } else {
                    if (this.aUD.getImageType() == 1) {
                        imageBitmap = (this.aUD.getCurrentFrame() == null || this.aUD.getCurrentFrame().bjV == null) ? this.aUP : this.aUD.getCurrentFrame().bjV;
                    } else {
                        imageBitmap = this.aUD.getImageBitmap() == null ? this.aUP : this.aUD.getImageBitmap();
                    }
                    height = imageBitmap.getHeight();
                    width = imageBitmap.getWidth();
                }
                float aR = l.aR(getContext());
                int i2 = (int) (height * aR);
                int i3 = (int) (width * aR);
                if (i3 > this.aUP.getWidth() && this.aUP.getWidth() != 0) {
                    float width2 = (i3 * 1.0f) / this.aUP.getWidth();
                    i3 = this.aUP.getWidth();
                    i2 = (int) (i2 / width2);
                }
                if (i2 > this.aUP.getHeight() && this.aUP.getHeight() != 0) {
                    i3 = (int) (i3 / ((i2 * 1.0f) / this.aUP.getHeight()));
                    i2 = this.aUP.getHeight();
                }
                int aQ = (l.aQ(getContext()) - i2) / 2;
                int aO = (l.aO(getContext()) - i3) / 2;
                this.aUX = new Rect(aO, aQ, i3 + aO, i2 + aQ);
                this.aUY = new Rect(this.aUX);
                this.aVg = aQ / l.aQ(getContext());
                this.aUW = new Rect(0, 0, this.aUP.getWidth(), this.aUP.getHeight());
            }
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (i == 2) {
            this.aUN = o(this.mLastMotionX - x, this.mLastMotionY - y);
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (this.aUN || this.aUO) {
            this.aUD.setImageOnLongClickListener(null);
            this.aUH.setOnLongClickListener(null);
            z = true;
        } else {
            this.aUD.setImageOnLongClickListener(this.aVr);
            this.aUH.setOnLongClickListener(this.aVr);
            z = super.dispatchTouchEvent(motionEvent);
        }
        if (i == 1 || i == 3) {
            this.mLastMotionX = 0.0f;
            this.mLastMotionY = 0.0f;
            this.aUQ = false;
            this.aUS.reset();
            this.aUN = false;
            if (this.aUR > aVa) {
                this.aUO = true;
                KB();
                return z;
            }
            this.mRatio = 1.0f;
            invalidate();
            return z;
        }
        return z;
    }

    private boolean o(float f, float f2) {
        if (this.aUH.getVisibility() != 0 || this.aUH.isCanDrag()) {
            if (this.aVh == null || !this.aVh.isLongPic || this.aUH.getVisibility() != 0 || this.aUH.isViewTop()) {
                if (this.aVh == null || !this.aVh.isLongPic || this.aUH.getVisibility() == 0 || this.aUD.Qo()) {
                    if (this.aUH.getVisibility() == 0 || this.aUD.Qq()) {
                        if (this.aUP != null && getScrollY() == 0 && f2 < 0.0f && !this.aUQ) {
                            this.aUQ = true;
                            this.aUR = 0.0f;
                            this.mRatio = 1.0f;
                            if (this.aUZ != null) {
                                this.aUZ.QG();
                            }
                        }
                        if (this.aUQ) {
                            this.aUR -= f2;
                            int measuredHeight = getMeasuredHeight();
                            if (this.aUR > measuredHeight) {
                                this.aUR = measuredHeight;
                            }
                            float f3 = f2 / measuredHeight;
                            this.aUS.postTranslate((-f) * 1.5f * this.mRatio, (-1.5f) * f2 * this.mRatio);
                            if (this.mRatio * (1.0f + f3) > 1.0f || this.aUR < 0.0f) {
                                this.aUS.preScale(1.0f / this.mRatio, 1.0f / this.mRatio, (this.mRatio * this.aUP.getWidth()) / 2.0f, this.mRatio * (this.aUP.getHeight() / 2));
                                this.mRatio = 1.0f;
                            } else {
                                this.aUS.preScale(1.0f + f3, 1.0f + f3, (this.mRatio * this.aUP.getWidth()) / 2.0f, this.mRatio * (this.aUP.getHeight() / 2));
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
        if (this.aUN && this.aUP != null && !this.aUP.isRecycled() && this.aUQ) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.aUU == null) {
                this.aUU = new RectF();
            }
            this.aUS.mapRect(this.aUU, new RectF(this.aUT));
            canvas.drawBitmap(this.aUP, this.aUW, this.aUU, (Paint) null);
        } else if (this.aUO && this.aUP != null && !this.aUP.isRecycled()) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.aVh == null || this.aVh.getSourceImageRectInScreen() == null) {
                canvas.drawBitmap(this.aUP, this.aUW, this.aUU, (Paint) null);
            } else {
                canvas.drawBitmap(this.aUP, this.aUX, this.aUU, (Paint) null);
            }
        } else {
            super.dispatchDraw(canvas);
        }
    }

    private void KB() {
        if (this.aVh == null) {
            if (this.aUZ != null) {
                this.aUZ.QH();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.aVh.getSourceImageRectInScreen();
        final Rect dstRectInScreen = this.aVh.getDstRectInScreen();
        if (sourceImageRectInScreen == null || dstRectInScreen == null) {
            if (this.aUZ != null) {
                this.aUZ.QH();
                return;
            }
            return;
        }
        a(sourceImageRectInScreen, dstRectInScreen);
        e(sourceImageRectInScreen);
        this.aUV = new RectF(this.aUU);
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
                UrlDragImageView.this.aUQ = false;
                UrlDragImageView.this.invalidate();
                if (UrlDragImageView.this.aUZ != null) {
                    UrlDragImageView.this.aUZ.QH();
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
            float f = ((rect.bottom - rect.top) / (rect.right - rect.left)) * (this.aUU.right - this.aUU.left);
            this.aUU.top += this.aUU.height() * this.aVg;
            this.aUU.bottom = f + this.aUU.top;
        }
    }

    private void a(Rect rect, Rect rect2) {
        this.aVc = 0.0f;
        this.aVd = 0.0f;
        this.aVe = 1.0f;
        this.aVf = 1.0f;
        if (rect != null && rect2 != null && rect.contains(rect2)) {
            this.aVc = (rect2.left - rect.left) / rect.width();
            this.aVd = (rect2.top - rect.top) / rect.height();
            this.aVe = (rect2.right - rect.left) / rect.width();
            this.aVf = (rect2.bottom - rect.top) / rect.height();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa(float f) {
        if (this.aUX != null) {
            this.aUX.left = (int) (this.aUY.left + (this.aUY.width() * this.aVc * f));
            this.aUX.top = (int) (this.aUY.top + (this.aUY.height() * this.aVd * f));
            this.aUX.right = (int) (this.aUY.left + (this.aUY.width() * (((1.0f - this.aVe) * (1.0f - f)) + this.aVe)));
            this.aUX.bottom = (int) (this.aUY.top + (this.aUY.height() * (((1.0f - this.aVf) * (1.0f - f)) + this.aVf)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Rect rect, float f) {
        if (this.aUU != null && rect != null) {
            this.aUU.left = this.aUV.left + ((rect.left - this.aUV.left) * f);
            this.aUU.top = this.aUV.top + ((rect.top - this.aUV.top) * f);
            this.aUU.right = this.aUV.right + ((rect.right - this.aUV.right) * f);
            this.aUU.bottom = this.aUV.bottom + ((rect.bottom - this.aUV.bottom) * f);
        }
    }

    private RectF h(float f, float f2, float f3, float f4) {
        return new RectF(f - (f3 / 2.0f), f2 - (f4 / 2.0f), (f3 / 2.0f) + f, (f4 / 2.0f) + f2);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.aVo = onTouchListener;
    }

    private void KC() {
        this.aVm = new TextView(this.mContext);
        this.aVm.setBackgroundResource(e.f.bg_url_drag_imagview_fade_view);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.height = getResources().getDimensionPixelSize(e.C0210e.ds180);
        layoutParams.addRule(12);
        addView(this.aVm, layoutParams);
        this.aVm.setVisibility(8);
    }

    private void KD() {
        this.aUF = new TextView(this.mContext);
        al.j(this.aUF, e.d.common_color_10022);
        this.aUF.setText(e.j.goto_pb_floor);
        this.aUF.setTextSize(0, getResources().getDimensionPixelSize(e.C0210e.fontsize28));
        al.b(this.aUF, e.d.cp_cont_i, 1, 0);
        this.aUF.setCompoundDrawablePadding(l.dip2px(this.mContext, 4.0f));
        this.aUF.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_see_arrow), (Drawable) null);
        this.aUF.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(e.C0210e.ds20);
        this.aUF.setPadding(dimensionPixelSize * 3, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(e.C0210e.ds30);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(e.C0210e.ds10);
        layoutParams.leftMargin = getResources().getDimensionPixelSize(e.C0210e.ds20);
        layoutParams.addRule(1, this.aUE.getId());
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        this.aUF.setOnClickListener(this);
        this.aUF.setMinHeight(getResources().getDimensionPixelSize(e.C0210e.ds100));
        addView(this.aUF, layoutParams);
        this.aUF.setVisibility(8);
    }

    private void KE() {
        if (this.aUF != null) {
            boolean z = this.aUK || this.aUL;
            if (!this.aVk && z && this.aVh != null && this.aVh.threadId > 0 && this.aVh.postId > 0 && this.aVh.mThreadType != 33 && !this.aVh.isBlockedPic && !this.aTD) {
                this.aUF.setVisibility(0);
                if (this.aVm != null) {
                    this.aVm.setVisibility(0);
                    return;
                }
                return;
            }
            this.aUF.setVisibility(8);
            if (this.aVm != null) {
                this.aVm.setVisibility(8);
            }
        }
    }

    private void KF() {
        if (this.aUF != null) {
            this.aUF.setVisibility(8);
            if (this.aVm != null) {
                this.aVm.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KG() {
        if ((this.aUK || this.aUL) && this.aVh != null && this.aVh.mPicType == 1 && !TextUtils.isEmpty(this.aVh.mTagName)) {
            if (this.aUG != null) {
                this.aUG.setVisibility(8);
                this.aUG = null;
            }
            this.aUG = new TextView(this.mContext);
            this.aUG.setText(this.aVh.mTagName);
            this.aUG.setTextSize(0, getResources().getDimensionPixelSize(e.C0210e.fontsize26));
            al.b(this.aUG, e.d.common_color_10013, 1, 0);
            al.j(this.aUG, e.d.common_color_10215);
            this.aUG.setAlpha(0.75f);
            this.aUG.setIncludeFontPadding(false);
            this.aUG.setGravity(17);
            int h = l.h(this.mContext, e.C0210e.ds2);
            this.aUG.setPadding(h, h, h, h);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.aUD.getBottomOffset();
            layoutParams.leftMargin = this.aUD.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.aUG, layoutParams);
            this.aUG.setVisibility(0);
        }
    }

    public void cf(boolean z) {
        this.aVk = z;
        if (this.aVk) {
            KF();
        } else {
            KE();
        }
    }

    public void setUrl(String str, boolean z) {
        if (str.contains("*")) {
            str = str.split("[*]")[0];
        }
        this.aUD.setTag(str);
        this.aUD.setLoadBigImage(false);
        this.aUD.setImageDrawable(null);
        this.aUK = false;
        this.aUL = false;
        this.aVi = KN();
        this.aUE.setVisibility(8);
        if (hi(str)) {
            b(str, z, false);
        }
    }

    private boolean KH() {
        return this.aUD != null && this.aUD.QE();
    }

    public void KI() {
        if (this.aVh != null && !KH()) {
            String str = this.aVh.imageUrl;
            int i = this.aVh.urlType;
            com.baidu.adp.widget.ImageView.a aVar = null;
            if (com.baidu.tbadk.core.util.d.a.B(str, i)) {
                aVar = com.baidu.tbadk.core.util.d.a.C(str, i);
            }
            if (aVar != null) {
                setThumbBitmapToView(aVar);
            }
        }
    }

    private boolean cg(boolean z) {
        String fK;
        if (!this.aVj || z) {
            this.aVj = true;
            if (!this.aVi || this.aVh == null || StringUtils.isNull(this.aVh.originalUrl, true) || this.aVh.originalSize < 0 || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String str = this.aVb + an.DL().fD(fK) + "/" + ar.fK(this.aVh.originalUrl);
            final int[] fh = com.baidu.tbadk.core.util.l.fh(str);
            this.aUH.setVisibility(0);
            if (this.aUI == null) {
                this.aUI = new SubsamplingScaleImageView.OnImageEventListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12
                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onReady() {
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.aUD.QA();
                        UrlDragImageView.this.aUD.setVisibility(4);
                    }

                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onImageLoaded() {
                        if (UrlDragImageView.this.aVh.isLongPic && fh[0] > 0) {
                            UrlDragImageView.this.aUD.onDestroy();
                            final float measuredWidth = (UrlDragImageView.this.getMeasuredWidth() * 1.0f) / fh[0];
                            final PointF pointF = new PointF((fh[0] * 1.0f) / 2.0f, 0.0f);
                            UrlDragImageView.this.aUH.setScaleAndCenter(measuredWidth, pointF);
                            UrlDragImageView.this.aUH.setMaxScale(2.0f * measuredWidth);
                            UrlDragImageView.this.aUH.setDoubleTapZoomScale(2.0f * measuredWidth);
                            UrlDragImageView.this.aUH.setInitScale(measuredWidth);
                            UrlDragImageView.this.aUH.setDoubleTapZoomStyle(4);
                            UrlDragImageView.this.aUH.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12.1
                                @Override // android.view.View.OnTouchListener
                                public boolean onTouch(View view, MotionEvent motionEvent) {
                                    if (UrlDragImageView.this.aVo != null) {
                                        UrlDragImageView.this.aVo.onTouch(view, motionEvent);
                                    }
                                    switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                                        case 0:
                                            UrlDragImageView.this.aVq = motionEvent.getY();
                                            UrlDragImageView.this.aUH.setOnClickListener(UrlDragImageView.this.aVp ? UrlDragImageView.this.mOnClickListener : null);
                                            UrlDragImageView.this.aUH.setOnLongClickListener(UrlDragImageView.this.aVp ? UrlDragImageView.this.aVr : null);
                                            break;
                                        case 1:
                                        case 3:
                                            if (UrlDragImageView.this.aUH.getScale() < measuredWidth) {
                                                UrlDragImageView.this.aUH.setScaleAndCenter(measuredWidth, pointF);
                                            }
                                            com.baidu.adp.lib.g.e.jG().removeCallbacks(UrlDragImageView.this.aVs);
                                            com.baidu.adp.lib.g.e.jG().postDelayed(UrlDragImageView.this.aVs, 1000L);
                                            break;
                                        case 2:
                                            if (Math.abs(motionEvent.getY() - UrlDragImageView.this.aVq) > UrlDragImageView.TOUCH_SLOP) {
                                                UrlDragImageView.this.aVp = false;
                                                UrlDragImageView.this.aUH.setOnClickListener(null);
                                                UrlDragImageView.this.aUH.setOnLongClickListener(null);
                                            }
                                            UrlDragImageView.this.aVq = motionEvent.getY();
                                            break;
                                    }
                                    return false;
                                }
                            });
                            UrlDragImageView.this.aUD.setVisibility(4);
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
            this.aUH.setOnImageEventListener(this.aUI);
            if (this.aUH.isImageLoaded() && this.aVh.isLongPic) {
                this.aUI.onImageLoaded();
            } else {
                this.aUH.setImage(ImageSource.uri(str));
            }
            return true;
        }
        return false;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.aUZ = dVar;
        if (this.aUD != null) {
            this.aUD.setDragToExitListener(dVar);
        }
    }

    public void KJ() {
        cg(false);
    }

    private boolean hi(String str) {
        return j.kV() || c.gb(str);
    }

    private void setThumbBitmapToView(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap op;
        if (!this.aUL && aVar != null && (op = aVar.op()) != null) {
            this.aUK = true;
            if (aVar.isGif()) {
                this.aUD.setImageUrlData(this.aVh);
                this.aUD.setImageBitmap(op);
                this.aUE.setVisibility(8);
                this.aVl = false;
            } else {
                if (this.aVh != null && this.aVh.isLongPic) {
                    this.aUD.Qt();
                    this.aUD.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.13
                        @Override // com.baidu.tbadk.widget.largeImage.logic.a
                        public void KR() {
                        }
                    });
                }
                this.aUD.setImageUrlData(this.aVh);
                this.aUD.setImageData(op, aVar.ou());
            }
            KE();
            KG();
        }
    }

    private void b(String str, boolean z, boolean z2) {
        if (hj(str)) {
            if (z2 || (!this.aUM && !this.aUL)) {
                if (!z2 || !cg(true)) {
                    this.aUM = true;
                    com.baidu.adp.lib.f.c.jA().a(str, 27, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.14
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onCancelled(String str2) {
                            UrlDragImageView.this.aUM = false;
                            UrlDragImageView.this.aUD.setVisibility(0);
                            UrlDragImageView.this.mProgressBar.setVisibility(8);
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            UrlDragImageView.this.aUM = false;
                            UrlDragImageView.this.aUL = true;
                            UrlDragImageView.this.b(aVar);
                        }
                    }, 0, 0, false, null, Boolean.valueOf(z), this.aUD.getImageData(), Boolean.valueOf(this.aTz));
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
        imageFileInfo.addPageAction(d.L(this.mMaxWidth, this.mMaxHeight));
        com.baidu.adp.widget.ImageView.a a2 = this.aVn.a(imageFileInfo, false);
        if (a2 != null) {
            this.aUL = true;
            this.mProgressBar.setVisibility(8);
            b(a2);
            return;
        }
        this.aVn.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.2
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.ImageView.a aVar, String str2, boolean z3) {
                UrlDragImageView.this.aUL = true;
                UrlDragImageView.this.mProgressBar.setVisibility(8);
                UrlDragImageView.this.b(aVar);
            }
        }, false);
    }

    private boolean hj(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null && this.aUJ != null) {
            this.aUJ.j(aVar.getUrl(), aVar.ou());
        }
        if (aVar == null || aVar.op() == null) {
            KK();
            return;
        }
        Bitmap op = aVar.op();
        this.aUD.setLoadBigImage(true);
        if (aVar.isGif()) {
            this.aUD.setGifData(aVar.ou(), op);
            this.aUD.invalidate();
            this.aUD.play();
            this.aVl = false;
            this.aUE.setVisibility(8);
            this.mProgressBar.setVisibility(8);
        } else {
            if (this.aVh != null && this.aVh.isLongPic) {
                this.aUD.Qt();
                this.aUD.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.3
                    @Override // com.baidu.tbadk.widget.largeImage.logic.a
                    public void KR() {
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                    }
                });
            } else {
                this.mProgressBar.setVisibility(8);
            }
            this.aUD.setImageUrlData(this.aVh);
            this.aUD.setImageData(op, aVar.ou());
            KO();
        }
        KE();
        KG();
    }

    private void KK() {
        if (!this.aUK) {
            this.aUD.setDefaultBitmap();
        } else {
            this.aUL = false;
        }
        this.aUE.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    public void setGifMaxUseableMem(int i) {
        this.aUD.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.aUD != null) {
            this.aUD.onDestroy();
        }
        if (this.aUH != null) {
            this.aUH.recycle();
        }
        if (this.aUP != null) {
            this.aUP.recycle();
            this.aUP = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.aVs);
    }

    public void release() {
        if (this.aUD != null) {
            this.aUD.release();
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.aUE != null) {
            this.aUE.setVisibility(8);
        }
    }

    public void KL() {
        if (this.aUD != null && this.aUD.getImageType() == 1) {
            this.aUD.stop();
        }
    }

    public void k(boolean z, boolean z2) {
        String str;
        if (this.aUD != null && (str = (String) this.aUD.getTag()) != null) {
            if (this.aUD.getImageType() == 1) {
                if (this.aUD.getGifCache() == null || !this.aUD.QE()) {
                    b(str, z, z2);
                }
            } else if (this.aUD.getImageType() == 2) {
                b(str, z, z2);
            } else if (KM()) {
                b(str, z, z2);
            }
        }
    }

    private boolean KM() {
        if (this.aUD.getImageBitmap() != null && this.aUD.QE()) {
            if (this.aVh == null || !this.aVh.isLongPic || this.aUD.Qu()) {
                return false;
            }
            this.aUL = false;
            this.aVj = false;
            return true;
        }
        return true;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.aVh = imageUrlData;
    }

    public void setIsCdn(boolean z) {
        this.aTz = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aUE) {
            if (!(this.aUE.getTag() instanceof Boolean) || ((Boolean) this.aUE.getTag()).booleanValue()) {
                final String fK = ar.fK(this.aVh.originalUrl);
                if (this.aVh.originalProcess >= 0) {
                    com.baidu.tbadk.download.d.LR().F(fK, 13);
                    this.aVh.originalProcess = -1;
                    KO();
                    return;
                }
                if (this.aTB != null) {
                    this.aTB.KS();
                }
                com.baidu.adp.base.e<?> aK = i.aK(this.mContext);
                if (aK == null) {
                    hk(fK);
                } else if (!j.kV() || j.kW() || com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("original_img_down_tip", false)) {
                    hk(fK);
                } else {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("original_img_down_tip", true);
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(aK.getPageActivity());
                    aVar.db(e.j.original_img_down_no_wifi_tip);
                    aVar.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.4
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar.dismiss();
                            UrlDragImageView.this.hk(fK);
                        }
                    });
                    aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.5
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar.dismiss();
                        }
                    });
                    aVar.b(aK);
                    aVar.BF();
                }
            }
        } else if (view == this.aUF && this.aVh != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.mContext).createHistoryCfg(String.valueOf(this.aVh.threadId), String.valueOf(this.aVh.postId), this.aVh.mIsSeeHost, this.aVh.mIsReserver, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hk(String str) {
        if (this.aVh != null) {
            this.aVh.originalProcess = 0;
            this.aUE.setText("0%");
            this.aUE.setCompoundDrawablesWithIntrinsicBounds(0, 0, e.f.icon_close_yuantu, 0);
            DownloadData downloadData = new DownloadData(str);
            downloadData.setStatus(1);
            downloadData.setUrl(this.aVh.originalUrl);
            downloadData.setType(13);
            downloadData.setPath(this.aVb + an.DL().fD(str) + "/" + str);
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.6
                @Override // com.baidu.tbadk.download.c
                public boolean onPreDownload(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2 != null) {
                        if (UrlDragImageView.this.aVh != null && UrlDragImageView.this.aVh.originalProcess != -1) {
                            UrlDragImageView.this.aVh.originalProcess = downloadData2.getProcess();
                        }
                        if (UrlDragImageView.this.aVh == null || UrlDragImageView.this.aVh.originalProcess != -1) {
                            UrlDragImageView.this.aUE.setText(downloadData2.getProcess() + "%");
                            UrlDragImageView.this.aUE.setCompoundDrawablesWithIntrinsicBounds(0, 0, e.f.icon_close_yuantu, 0);
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public boolean onFileDownloaded(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadSucceed(DownloadData downloadData2) {
                    UrlDragImageView.this.aUE.setText(UrlDragImageView.this.getResources().getString(e.j.done));
                    UrlDragImageView.this.aUE.setTag(false);
                    UrlDragImageView.this.aUE.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    com.baidu.adp.lib.g.e.jG().postDelayed(UrlDragImageView.this.aVt, 1500L);
                    UrlDragImageView.this.aVj = false;
                    UrlDragImageView.this.aVi = UrlDragImageView.this.KN();
                    UrlDragImageView.this.KJ();
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str2) {
                    UrlDragImageView.this.aVj = false;
                    BdToast.a(UrlDragImageView.this.mContext, str2).BL().BN();
                    UrlDragImageView.this.aVh.originalProcess = -1;
                    UrlDragImageView.this.KO();
                }
            });
            com.baidu.tbadk.download.d.LR().a(downloadData, 100);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean KN() {
        if (this.aVh != null && !StringUtils.isNull(this.aVh.originalUrl, true) && this.aVh.originalSize >= 0 && !this.aVh.isBlockedPic) {
            String fK = ar.fK(this.aVh.originalUrl);
            File file = new File(this.aVb + an.DL().fD(fK) + "/" + fK);
            if (file != null && file.exists()) {
                this.aVh.originalProcess = 100;
                return true;
            }
            if (this.aVh.originalProcess < 0) {
                KO();
            } else {
                this.aUE.setText(this.aVh.originalProcess + "%");
                this.aUE.setCompoundDrawablesWithIntrinsicBounds(0, 0, e.f.icon_close_yuantu, 0);
            }
            this.aVl = true;
        } else {
            this.aUE.setVisibility(8);
        }
        return false;
    }

    public void KO() {
        if (this.aVh != null) {
            if (!KP() || !this.aVl) {
                this.aUE.setVisibility(8);
            } else {
                this.aUE.setVisibility(0);
            }
            if (this.aVh.originalSize > 0 && !am(this.aVh.originalSize)) {
                this.aUE.setText(aUB + "(" + ao.ab(this.aVh.originalSize) + ")");
            } else {
                this.aUE.setText(aUB);
            }
            this.aUE.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    private boolean KP() {
        return (this.aVh == null || !this.aVh.mIsShowOrigonButton || this.aVh.isBlockedPic || StringUtils.isNull(this.aVh.originalUrl)) ? false : true;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.aTB = bVar;
    }

    private boolean am(long j) {
        return j > aUC;
    }
}
