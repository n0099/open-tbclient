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
    private boolean aTC;
    private b aTE;
    private boolean aTF;
    private boolean aTG;
    protected DragImageView aUG;
    protected TextView aUH;
    protected TextView aUI;
    protected TextView aUJ;
    protected SubsamplingScaleImageView aUK;
    private SubsamplingScaleImageView.OnImageEventListener aUL;
    private a aUM;
    private boolean aUN;
    private boolean aUO;
    private boolean aUP;
    private boolean aUQ;
    private boolean aUR;
    private Bitmap aUS;
    private boolean aUT;
    private float aUU;
    private Matrix aUV;
    private Rect aUW;
    private RectF aUX;
    private RectF aUY;
    private Rect aUZ;
    private Rect aVa;
    private Rect aVb;
    private DragImageView.d aVc;
    private String aVe;
    private float aVf;
    private float aVg;
    private float aVh;
    private float aVi;
    private float aVj;
    private ImageUrlData aVk;
    private boolean aVl;
    private boolean aVm;
    private boolean aVn;
    public boolean aVo;
    private TextView aVp;
    private com.baidu.tbadk.img.b aVq;
    private View.OnTouchListener aVr;
    private boolean aVs;
    private float aVt;
    private View.OnLongClickListener aVu;
    private Runnable aVv;
    private Runnable aVw;
    private View.OnTouchListener aVx;
    protected Context mContext;
    private float mLastMotionX;
    private float mLastMotionY;
    private int mMaxHeight;
    private int mMaxWidth;
    private View.OnClickListener mOnClickListener;
    protected ProgressBar mProgressBar;
    private float mRatio;
    private int mSkinType;
    private static final String aUE = TbadkCoreApplication.getInst().getString(e.j.original_img_look);
    private static long aUF = Config.RAVEN_LOG_LIMIT;
    private static final int aVd = l.aQ(TbadkCoreApplication.getInst()) / 5;
    private static final String TAG = UrlDragImageView.class.getSimpleName();
    private static final int TOUCH_SLOP = ViewConfiguration.get(TbadkCoreApplication.getInst()).getScaledTouchSlop();

    /* loaded from: classes6.dex */
    public interface a {
        void j(String str, byte[] bArr);
    }

    /* loaded from: classes6.dex */
    public interface b {
        void KT();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.aUH != null) {
                al.i(this.aUH, e.f.btn_percent_yuantu);
                al.b(this.aUH, e.d.cp_cont_g, 1, 0);
            }
            if (this.aUI != null) {
                al.j(this.aUI, e.d.common_color_10022);
                al.b(this.aUI, e.d.cp_cont_g, 1, 0);
            }
            this.mSkinType = i;
        }
    }

    public void setHeadImage(boolean z) {
        if (this.aUG != null) {
            this.aUG.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.aUM = aVar;
    }

    public UrlDragImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mContext = null;
        this.mProgressBar = null;
        this.aUG = null;
        this.aUM = null;
        this.aTC = false;
        this.aUP = false;
        this.aUT = false;
        this.mRatio = 1.0f;
        this.aUU = 0.0f;
        this.aUV = new Matrix();
        this.aUX = new RectF();
        this.aVf = 0.0f;
        this.aVg = 0.0f;
        this.aVh = 1.0f;
        this.aVi = 1.0f;
        this.aVj = 0.0f;
        this.aVl = false;
        this.aVm = false;
        this.aVn = false;
        this.aVo = false;
        this.aVp = null;
        this.aVs = true;
        this.aVt = 0.0f;
        this.mOnClickListener = null;
        this.aVu = null;
        this.aVv = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.aVs = true;
            }
        };
        this.aVw = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.aUH.setVisibility(8);
                        UrlDragImageView.this.aVo = false;
                    }
                });
                UrlDragImageView.this.aUH.startAnimation(alphaAnimation);
            }
        };
        this.aVx = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.aVr != null) {
                    UrlDragImageView.this.aVr.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.aVq = new com.baidu.tbadk.img.b();
        init();
    }

    public UrlDragImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.mContext = null;
        this.mProgressBar = null;
        this.aUG = null;
        this.aUM = null;
        this.aTC = false;
        this.aUP = false;
        this.aUT = false;
        this.mRatio = 1.0f;
        this.aUU = 0.0f;
        this.aUV = new Matrix();
        this.aUX = new RectF();
        this.aVf = 0.0f;
        this.aVg = 0.0f;
        this.aVh = 1.0f;
        this.aVi = 1.0f;
        this.aVj = 0.0f;
        this.aVl = false;
        this.aVm = false;
        this.aVn = false;
        this.aVo = false;
        this.aVp = null;
        this.aVs = true;
        this.aVt = 0.0f;
        this.mOnClickListener = null;
        this.aVu = null;
        this.aVv = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.aVs = true;
            }
        };
        this.aVw = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.aUH.setVisibility(8);
                        UrlDragImageView.this.aVo = false;
                    }
                });
                UrlDragImageView.this.aUH.startAnimation(alphaAnimation);
            }
        };
        this.aVx = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.aVr != null) {
                    UrlDragImageView.this.aVr.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.aVq = new com.baidu.tbadk.img.b();
        init();
    }

    public DragImageView getImageView() {
        return this.aUG;
    }

    public void setGifSetListener(DragImageView.e eVar) {
        this.aUG.setGifSetListener(eVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.aUG.setImageOnClickListener(onClickListener);
        this.aUK.setOnClickListener(onClickListener);
        this.mOnClickListener = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aVu = onLongClickListener;
        if (!this.aTF) {
            this.aUG.setImageOnLongClickListener(this.aVu);
            this.aUK.setOnLongClickListener(this.aVu);
        }
    }

    public void setOnSizeChangedListener(final DragImageView.g gVar) {
        this.aUG.setOnSizeChangedListener(new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.8
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (gVar != null) {
                    gVar.a(dragImageView, z, z2);
                }
                UrlDragImageView.this.KH();
            }
        });
    }

    protected void init() {
        this.mMaxWidth = l.aO(this.mContext);
        this.mMaxHeight = l.aQ(this.mContext) - ((int) this.mContext.getResources().getDimension(e.C0210e.ds166));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.aUG = new DragImageView(this.mContext);
        this.aUG.setLayoutParams(layoutParams);
        this.aUG.setOnTouchListener(this.aVx);
        addView(this.aUG);
        this.aUK = new SubsamplingScaleImageView(this.mContext);
        this.aUK.setMaxScale(50.0f);
        this.aUK.setOnTouchListener(this.aVx);
        this.aUK.setVisibility(4);
        addView(this.aUK, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(getResources().getDrawable(e.f.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        KD();
        KB();
        KE();
    }

    private void KB() {
        this.aVe = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        this.aUH = new TextView(this.mContext);
        al.i(this.aUH, e.f.btn_percent_yuantu);
        this.aUH.setText(e.j.original_img_look);
        this.aUH.setTextSize(0, getResources().getDimensionPixelSize(e.C0210e.fontsize28));
        al.b(this.aUH, e.d.cp_cont_i, 1, 0);
        this.aUH.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(e.C0210e.ds16);
        this.aUH.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        this.aUH.setMinWidth(getResources().getDimensionPixelSize(e.C0210e.ds222));
        this.aUH.setMinHeight(getResources().getDimensionPixelSize(e.C0210e.ds60));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(e.C0210e.fontsize40);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        this.aUH.setOnClickListener(this);
        this.aUH.setVisibility(8);
        addView(this.aUH, layoutParams);
    }

    public void setIsCanDrag(boolean z) {
        this.aTF = z;
    }

    public void setIsHotSort(boolean z) {
        this.aTG = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        Bitmap imageBitmap;
        int height;
        int width;
        if (!this.aTF || !this.aUO) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.aUQ && motionEvent.getPointerCount() >= 2) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.aUQ || this.aUR) {
            requestDisallowInterceptTouchEvent(true);
        }
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        float x = motionEvent.getX();
        int i = action & 255;
        if (i == 0) {
            if (this.aUS == null) {
                if (this.aUK.getVisibility() == 0) {
                    this.aUS = com.baidu.tbadk.util.e.ae(this.aUK);
                } else {
                    this.aUS = com.baidu.tbadk.util.e.ae(this.aUG);
                }
            }
            if (this.aUW == null && this.aUS != null) {
                int measuredWidth = getMeasuredWidth();
                float measuredWidth2 = ((getMeasuredWidth() * 1.0f) / this.aUS.getWidth()) * this.aUS.getHeight();
                if (measuredWidth2 > getMeasuredHeight()) {
                    measuredWidth2 = getMeasuredHeight();
                }
                RectF h = h(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
                this.aUW = new Rect((int) h.left, (int) h.top, (int) h.right, (int) h.bottom);
            }
            if (this.aVa == null && this.aUS != null) {
                if (this.aUK.getVisibility() == 0) {
                    height = this.aUK.getSHeight();
                    width = this.aUK.getSWidth();
                } else {
                    if (this.aUG.getImageType() == 1) {
                        imageBitmap = (this.aUG.getCurrentFrame() == null || this.aUG.getCurrentFrame().bjY == null) ? this.aUS : this.aUG.getCurrentFrame().bjY;
                    } else {
                        imageBitmap = this.aUG.getImageBitmap() == null ? this.aUS : this.aUG.getImageBitmap();
                    }
                    height = imageBitmap.getHeight();
                    width = imageBitmap.getWidth();
                }
                float aR = l.aR(getContext());
                int i2 = (int) (height * aR);
                int i3 = (int) (width * aR);
                if (i3 > this.aUS.getWidth() && this.aUS.getWidth() != 0) {
                    float width2 = (i3 * 1.0f) / this.aUS.getWidth();
                    i3 = this.aUS.getWidth();
                    i2 = (int) (i2 / width2);
                }
                if (i2 > this.aUS.getHeight() && this.aUS.getHeight() != 0) {
                    i3 = (int) (i3 / ((i2 * 1.0f) / this.aUS.getHeight()));
                    i2 = this.aUS.getHeight();
                }
                int aQ = (l.aQ(getContext()) - i2) / 2;
                int aO = (l.aO(getContext()) - i3) / 2;
                this.aVa = new Rect(aO, aQ, i3 + aO, i2 + aQ);
                this.aVb = new Rect(this.aVa);
                this.aVj = aQ / l.aQ(getContext());
                this.aUZ = new Rect(0, 0, this.aUS.getWidth(), this.aUS.getHeight());
            }
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (i == 2) {
            this.aUQ = o(this.mLastMotionX - x, this.mLastMotionY - y);
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (this.aUQ || this.aUR) {
            this.aUG.setImageOnLongClickListener(null);
            this.aUK.setOnLongClickListener(null);
            z = true;
        } else {
            this.aUG.setImageOnLongClickListener(this.aVu);
            this.aUK.setOnLongClickListener(this.aVu);
            z = super.dispatchTouchEvent(motionEvent);
        }
        if (i == 1 || i == 3) {
            this.mLastMotionX = 0.0f;
            this.mLastMotionY = 0.0f;
            this.aUT = false;
            this.aUV.reset();
            this.aUQ = false;
            if (this.aUU > aVd) {
                this.aUR = true;
                KC();
                return z;
            }
            this.mRatio = 1.0f;
            invalidate();
            return z;
        }
        return z;
    }

    private boolean o(float f, float f2) {
        if (this.aUK.getVisibility() != 0 || this.aUK.isCanDrag()) {
            if (this.aVk == null || !this.aVk.isLongPic || this.aUK.getVisibility() != 0 || this.aUK.isViewTop()) {
                if (this.aVk == null || !this.aVk.isLongPic || this.aUK.getVisibility() == 0 || this.aUG.Qq()) {
                    if (this.aUK.getVisibility() == 0 || this.aUG.Qs()) {
                        if (this.aUS != null && getScrollY() == 0 && f2 < 0.0f && !this.aUT) {
                            this.aUT = true;
                            this.aUU = 0.0f;
                            this.mRatio = 1.0f;
                            if (this.aVc != null) {
                                this.aVc.QI();
                            }
                        }
                        if (this.aUT) {
                            this.aUU -= f2;
                            int measuredHeight = getMeasuredHeight();
                            if (this.aUU > measuredHeight) {
                                this.aUU = measuredHeight;
                            }
                            float f3 = f2 / measuredHeight;
                            this.aUV.postTranslate((-f) * 1.5f * this.mRatio, (-1.5f) * f2 * this.mRatio);
                            if (this.mRatio * (1.0f + f3) > 1.0f || this.aUU < 0.0f) {
                                this.aUV.preScale(1.0f / this.mRatio, 1.0f / this.mRatio, (this.mRatio * this.aUS.getWidth()) / 2.0f, this.mRatio * (this.aUS.getHeight() / 2));
                                this.mRatio = 1.0f;
                            } else {
                                this.aUV.preScale(1.0f + f3, 1.0f + f3, (this.mRatio * this.aUS.getWidth()) / 2.0f, this.mRatio * (this.aUS.getHeight() / 2));
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
        if (this.aUQ && this.aUS != null && !this.aUS.isRecycled() && this.aUT) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.aUX == null) {
                this.aUX = new RectF();
            }
            this.aUV.mapRect(this.aUX, new RectF(this.aUW));
            canvas.drawBitmap(this.aUS, this.aUZ, this.aUX, (Paint) null);
        } else if (this.aUR && this.aUS != null && !this.aUS.isRecycled()) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.aVk == null || this.aVk.getSourceImageRectInScreen() == null) {
                canvas.drawBitmap(this.aUS, this.aUZ, this.aUX, (Paint) null);
            } else {
                canvas.drawBitmap(this.aUS, this.aVa, this.aUX, (Paint) null);
            }
        } else {
            super.dispatchDraw(canvas);
        }
    }

    private void KC() {
        if (this.aVk == null) {
            if (this.aVc != null) {
                this.aVc.QJ();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.aVk.getSourceImageRectInScreen();
        final Rect dstRectInScreen = this.aVk.getDstRectInScreen();
        if (sourceImageRectInScreen == null || dstRectInScreen == null) {
            if (this.aVc != null) {
                this.aVc.QJ();
                return;
            }
            return;
        }
        a(sourceImageRectInScreen, dstRectInScreen);
        e(sourceImageRectInScreen);
        this.aUY = new RectF(this.aUX);
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
                UrlDragImageView.this.aUT = false;
                UrlDragImageView.this.invalidate();
                if (UrlDragImageView.this.aVc != null) {
                    UrlDragImageView.this.aVc.QJ();
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
            float f = ((rect.bottom - rect.top) / (rect.right - rect.left)) * (this.aUX.right - this.aUX.left);
            this.aUX.top += this.aUX.height() * this.aVj;
            this.aUX.bottom = f + this.aUX.top;
        }
    }

    private void a(Rect rect, Rect rect2) {
        this.aVf = 0.0f;
        this.aVg = 0.0f;
        this.aVh = 1.0f;
        this.aVi = 1.0f;
        if (rect != null && rect2 != null && rect.contains(rect2)) {
            this.aVf = (rect2.left - rect.left) / rect.width();
            this.aVg = (rect2.top - rect.top) / rect.height();
            this.aVh = (rect2.right - rect.left) / rect.width();
            this.aVi = (rect2.bottom - rect.top) / rect.height();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa(float f) {
        if (this.aVa != null) {
            this.aVa.left = (int) (this.aVb.left + (this.aVb.width() * this.aVf * f));
            this.aVa.top = (int) (this.aVb.top + (this.aVb.height() * this.aVg * f));
            this.aVa.right = (int) (this.aVb.left + (this.aVb.width() * (((1.0f - this.aVh) * (1.0f - f)) + this.aVh)));
            this.aVa.bottom = (int) (this.aVb.top + (this.aVb.height() * (((1.0f - this.aVi) * (1.0f - f)) + this.aVi)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Rect rect, float f) {
        if (this.aUX != null && rect != null) {
            this.aUX.left = this.aUY.left + ((rect.left - this.aUY.left) * f);
            this.aUX.top = this.aUY.top + ((rect.top - this.aUY.top) * f);
            this.aUX.right = this.aUY.right + ((rect.right - this.aUY.right) * f);
            this.aUX.bottom = this.aUY.bottom + ((rect.bottom - this.aUY.bottom) * f);
        }
    }

    private RectF h(float f, float f2, float f3, float f4) {
        return new RectF(f - (f3 / 2.0f), f2 - (f4 / 2.0f), (f3 / 2.0f) + f, (f4 / 2.0f) + f2);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.aVr = onTouchListener;
    }

    private void KD() {
        this.aVp = new TextView(this.mContext);
        this.aVp.setBackgroundResource(e.f.bg_url_drag_imagview_fade_view);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.height = getResources().getDimensionPixelSize(e.C0210e.ds180);
        layoutParams.addRule(12);
        addView(this.aVp, layoutParams);
        this.aVp.setVisibility(8);
    }

    private void KE() {
        this.aUI = new TextView(this.mContext);
        al.j(this.aUI, e.d.common_color_10022);
        this.aUI.setText(e.j.goto_pb_floor);
        this.aUI.setTextSize(0, getResources().getDimensionPixelSize(e.C0210e.fontsize28));
        al.b(this.aUI, e.d.cp_cont_i, 1, 0);
        this.aUI.setCompoundDrawablePadding(l.dip2px(this.mContext, 4.0f));
        this.aUI.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_see_arrow), (Drawable) null);
        this.aUI.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(e.C0210e.ds20);
        this.aUI.setPadding(dimensionPixelSize * 3, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(e.C0210e.ds30);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(e.C0210e.ds10);
        layoutParams.leftMargin = getResources().getDimensionPixelSize(e.C0210e.ds20);
        layoutParams.addRule(1, this.aUH.getId());
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        this.aUI.setOnClickListener(this);
        this.aUI.setMinHeight(getResources().getDimensionPixelSize(e.C0210e.ds100));
        addView(this.aUI, layoutParams);
        this.aUI.setVisibility(8);
    }

    private void KF() {
        if (this.aUI != null) {
            boolean z = this.aUN || this.aUO;
            if (!this.aVn && z && this.aVk != null && this.aVk.threadId > 0 && this.aVk.postId > 0 && this.aVk.mThreadType != 33 && !this.aVk.isBlockedPic && !this.aTG) {
                this.aUI.setVisibility(0);
                if (this.aVp != null) {
                    this.aVp.setVisibility(0);
                    return;
                }
                return;
            }
            this.aUI.setVisibility(8);
            if (this.aVp != null) {
                this.aVp.setVisibility(8);
            }
        }
    }

    private void KG() {
        if (this.aUI != null) {
            this.aUI.setVisibility(8);
            if (this.aVp != null) {
                this.aVp.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KH() {
        if ((this.aUN || this.aUO) && this.aVk != null && this.aVk.mPicType == 1 && !TextUtils.isEmpty(this.aVk.mTagName)) {
            if (this.aUJ != null) {
                this.aUJ.setVisibility(8);
                this.aUJ = null;
            }
            this.aUJ = new TextView(this.mContext);
            this.aUJ.setText(this.aVk.mTagName);
            this.aUJ.setTextSize(0, getResources().getDimensionPixelSize(e.C0210e.fontsize26));
            al.b(this.aUJ, e.d.common_color_10013, 1, 0);
            al.j(this.aUJ, e.d.common_color_10215);
            this.aUJ.setAlpha(0.75f);
            this.aUJ.setIncludeFontPadding(false);
            this.aUJ.setGravity(17);
            int h = l.h(this.mContext, e.C0210e.ds2);
            this.aUJ.setPadding(h, h, h, h);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.aUG.getBottomOffset();
            layoutParams.leftMargin = this.aUG.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.aUJ, layoutParams);
            this.aUJ.setVisibility(0);
        }
    }

    public void cf(boolean z) {
        this.aVn = z;
        if (this.aVn) {
            KG();
        } else {
            KF();
        }
    }

    public void setUrl(String str, boolean z) {
        if (str.contains("*")) {
            str = str.split("[*]")[0];
        }
        this.aUG.setTag(str);
        this.aUG.setLoadBigImage(false);
        this.aUG.setImageDrawable(null);
        this.aUN = false;
        this.aUO = false;
        this.aVl = KO();
        this.aUH.setVisibility(8);
        if (hj(str)) {
            b(str, z, false);
        }
    }

    private boolean KI() {
        return this.aUG != null && this.aUG.QG();
    }

    public void KJ() {
        if (this.aVk != null && !KI()) {
            String str = this.aVk.imageUrl;
            int i = this.aVk.urlType;
            com.baidu.adp.widget.ImageView.a aVar = null;
            if (com.baidu.tbadk.core.util.d.a.C(str, i)) {
                aVar = com.baidu.tbadk.core.util.d.a.D(str, i);
            }
            if (aVar != null) {
                setThumbBitmapToView(aVar);
            }
        }
    }

    private boolean cg(boolean z) {
        String fL;
        if (!this.aVm || z) {
            this.aVm = true;
            if (!this.aVl || this.aVk == null || StringUtils.isNull(this.aVk.originalUrl, true) || this.aVk.originalSize < 0 || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String str = this.aVe + an.DL().fD(fL) + "/" + ar.fL(this.aVk.originalUrl);
            final int[] fh = com.baidu.tbadk.core.util.l.fh(str);
            this.aUK.setVisibility(0);
            if (this.aUL == null) {
                this.aUL = new SubsamplingScaleImageView.OnImageEventListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12
                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onReady() {
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.aUG.QC();
                        UrlDragImageView.this.aUG.setVisibility(4);
                    }

                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onImageLoaded() {
                        if (UrlDragImageView.this.aVk.isLongPic && fh[0] > 0) {
                            UrlDragImageView.this.aUG.onDestroy();
                            final float measuredWidth = (UrlDragImageView.this.getMeasuredWidth() * 1.0f) / fh[0];
                            final PointF pointF = new PointF((fh[0] * 1.0f) / 2.0f, 0.0f);
                            UrlDragImageView.this.aUK.setScaleAndCenter(measuredWidth, pointF);
                            UrlDragImageView.this.aUK.setMaxScale(2.0f * measuredWidth);
                            UrlDragImageView.this.aUK.setDoubleTapZoomScale(2.0f * measuredWidth);
                            UrlDragImageView.this.aUK.setInitScale(measuredWidth);
                            UrlDragImageView.this.aUK.setDoubleTapZoomStyle(4);
                            UrlDragImageView.this.aUK.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12.1
                                @Override // android.view.View.OnTouchListener
                                public boolean onTouch(View view, MotionEvent motionEvent) {
                                    if (UrlDragImageView.this.aVr != null) {
                                        UrlDragImageView.this.aVr.onTouch(view, motionEvent);
                                    }
                                    switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                                        case 0:
                                            UrlDragImageView.this.aVt = motionEvent.getY();
                                            UrlDragImageView.this.aUK.setOnClickListener(UrlDragImageView.this.aVs ? UrlDragImageView.this.mOnClickListener : null);
                                            UrlDragImageView.this.aUK.setOnLongClickListener(UrlDragImageView.this.aVs ? UrlDragImageView.this.aVu : null);
                                            break;
                                        case 1:
                                        case 3:
                                            if (UrlDragImageView.this.aUK.getScale() < measuredWidth) {
                                                UrlDragImageView.this.aUK.setScaleAndCenter(measuredWidth, pointF);
                                            }
                                            com.baidu.adp.lib.g.e.jG().removeCallbacks(UrlDragImageView.this.aVv);
                                            com.baidu.adp.lib.g.e.jG().postDelayed(UrlDragImageView.this.aVv, 1000L);
                                            break;
                                        case 2:
                                            if (Math.abs(motionEvent.getY() - UrlDragImageView.this.aVt) > UrlDragImageView.TOUCH_SLOP) {
                                                UrlDragImageView.this.aVs = false;
                                                UrlDragImageView.this.aUK.setOnClickListener(null);
                                                UrlDragImageView.this.aUK.setOnLongClickListener(null);
                                            }
                                            UrlDragImageView.this.aVt = motionEvent.getY();
                                            break;
                                    }
                                    return false;
                                }
                            });
                            UrlDragImageView.this.aUG.setVisibility(4);
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
            this.aUK.setOnImageEventListener(this.aUL);
            if (this.aUK.isImageLoaded() && this.aVk.isLongPic) {
                this.aUL.onImageLoaded();
            } else {
                this.aUK.setImage(ImageSource.uri(str));
            }
            return true;
        }
        return false;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.aVc = dVar;
        if (this.aUG != null) {
            this.aUG.setDragToExitListener(dVar);
        }
    }

    public void KK() {
        cg(false);
    }

    private boolean hj(String str) {
        return j.kV() || c.gc(str);
    }

    private void setThumbBitmapToView(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap op;
        if (!this.aUO && aVar != null && (op = aVar.op()) != null) {
            this.aUN = true;
            if (aVar.isGif()) {
                this.aUG.setImageUrlData(this.aVk);
                this.aUG.setImageBitmap(op);
                this.aUH.setVisibility(8);
                this.aVo = false;
            } else {
                if (this.aVk != null && this.aVk.isLongPic) {
                    this.aUG.Qv();
                    this.aUG.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.13
                        @Override // com.baidu.tbadk.widget.largeImage.logic.a
                        public void KS() {
                        }
                    });
                }
                this.aUG.setImageUrlData(this.aVk);
                this.aUG.setImageData(op, aVar.ou());
            }
            KF();
            KH();
        }
    }

    private void b(String str, boolean z, boolean z2) {
        if (hk(str)) {
            if (z2 || (!this.aUP && !this.aUO)) {
                if (!z2 || !cg(true)) {
                    this.aUP = true;
                    com.baidu.adp.lib.f.c.jA().a(str, 27, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.14
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onCancelled(String str2) {
                            UrlDragImageView.this.aUP = false;
                            UrlDragImageView.this.aUG.setVisibility(0);
                            UrlDragImageView.this.mProgressBar.setVisibility(8);
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            UrlDragImageView.this.aUP = false;
                            UrlDragImageView.this.aUO = true;
                            UrlDragImageView.this.b(aVar);
                        }
                    }, 0, 0, false, null, Boolean.valueOf(z), this.aUG.getImageData(), Boolean.valueOf(this.aTC));
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
        com.baidu.adp.widget.ImageView.a a2 = this.aVq.a(imageFileInfo, false);
        if (a2 != null) {
            this.aUO = true;
            this.mProgressBar.setVisibility(8);
            b(a2);
            return;
        }
        this.aVq.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.2
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.ImageView.a aVar, String str2, boolean z3) {
                UrlDragImageView.this.aUO = true;
                UrlDragImageView.this.mProgressBar.setVisibility(8);
                UrlDragImageView.this.b(aVar);
            }
        }, false);
    }

    private boolean hk(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null && this.aUM != null) {
            this.aUM.j(aVar.getUrl(), aVar.ou());
        }
        if (aVar == null || aVar.op() == null) {
            KL();
            return;
        }
        Bitmap op = aVar.op();
        this.aUG.setLoadBigImage(true);
        if (aVar.isGif()) {
            this.aUG.setGifData(aVar.ou(), op);
            this.aUG.invalidate();
            this.aUG.play();
            this.aVo = false;
            this.aUH.setVisibility(8);
            this.mProgressBar.setVisibility(8);
        } else {
            if (this.aVk != null && this.aVk.isLongPic) {
                this.aUG.Qv();
                this.aUG.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.3
                    @Override // com.baidu.tbadk.widget.largeImage.logic.a
                    public void KS() {
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                    }
                });
            } else {
                this.mProgressBar.setVisibility(8);
            }
            this.aUG.setImageUrlData(this.aVk);
            this.aUG.setImageData(op, aVar.ou());
            KP();
        }
        KF();
        KH();
    }

    private void KL() {
        if (!this.aUN) {
            this.aUG.setDefaultBitmap();
        } else {
            this.aUO = false;
        }
        this.aUH.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    public void setGifMaxUseableMem(int i) {
        this.aUG.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.aUG != null) {
            this.aUG.onDestroy();
        }
        if (this.aUK != null) {
            this.aUK.recycle();
        }
        if (this.aUS != null) {
            this.aUS.recycle();
            this.aUS = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.aVv);
    }

    public void release() {
        if (this.aUG != null) {
            this.aUG.release();
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.aUH != null) {
            this.aUH.setVisibility(8);
        }
    }

    public void KM() {
        if (this.aUG != null && this.aUG.getImageType() == 1) {
            this.aUG.stop();
        }
    }

    public void k(boolean z, boolean z2) {
        String str;
        if (this.aUG != null && (str = (String) this.aUG.getTag()) != null) {
            if (this.aUG.getImageType() == 1) {
                if (this.aUG.getGifCache() == null || !this.aUG.QG()) {
                    b(str, z, z2);
                }
            } else if (this.aUG.getImageType() == 2) {
                b(str, z, z2);
            } else if (KN()) {
                b(str, z, z2);
            }
        }
    }

    private boolean KN() {
        if (this.aUG.getImageBitmap() != null && this.aUG.QG()) {
            if (this.aVk == null || !this.aVk.isLongPic || this.aUG.Qw()) {
                return false;
            }
            this.aUO = false;
            this.aVm = false;
            return true;
        }
        return true;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.aVk = imageUrlData;
    }

    public void setIsCdn(boolean z) {
        this.aTC = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aUH) {
            if (!(this.aUH.getTag() instanceof Boolean) || ((Boolean) this.aUH.getTag()).booleanValue()) {
                final String fL = ar.fL(this.aVk.originalUrl);
                if (this.aVk.originalProcess >= 0) {
                    com.baidu.tbadk.download.d.LS().G(fL, 13);
                    this.aVk.originalProcess = -1;
                    KP();
                    return;
                }
                if (this.aTE != null) {
                    this.aTE.KT();
                }
                com.baidu.adp.base.e<?> aK = i.aK(this.mContext);
                if (aK == null) {
                    hl(fL);
                } else if (!j.kV() || j.kW() || com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("original_img_down_tip", false)) {
                    hl(fL);
                } else {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("original_img_down_tip", true);
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(aK.getPageActivity());
                    aVar.db(e.j.original_img_down_no_wifi_tip);
                    aVar.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.4
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar.dismiss();
                            UrlDragImageView.this.hl(fL);
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
        } else if (view == this.aUI && this.aVk != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.mContext).createHistoryCfg(String.valueOf(this.aVk.threadId), String.valueOf(this.aVk.postId), this.aVk.mIsSeeHost, this.aVk.mIsReserver, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hl(String str) {
        if (this.aVk != null) {
            this.aVk.originalProcess = 0;
            this.aUH.setText("0%");
            this.aUH.setCompoundDrawablesWithIntrinsicBounds(0, 0, e.f.icon_close_yuantu, 0);
            DownloadData downloadData = new DownloadData(str);
            downloadData.setStatus(1);
            downloadData.setUrl(this.aVk.originalUrl);
            downloadData.setType(13);
            downloadData.setPath(this.aVe + an.DL().fD(str) + "/" + str);
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.6
                @Override // com.baidu.tbadk.download.c
                public boolean onPreDownload(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2 != null) {
                        if (UrlDragImageView.this.aVk != null && UrlDragImageView.this.aVk.originalProcess != -1) {
                            UrlDragImageView.this.aVk.originalProcess = downloadData2.getProcess();
                        }
                        if (UrlDragImageView.this.aVk == null || UrlDragImageView.this.aVk.originalProcess != -1) {
                            UrlDragImageView.this.aUH.setText(downloadData2.getProcess() + "%");
                            UrlDragImageView.this.aUH.setCompoundDrawablesWithIntrinsicBounds(0, 0, e.f.icon_close_yuantu, 0);
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public boolean onFileDownloaded(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadSucceed(DownloadData downloadData2) {
                    UrlDragImageView.this.aUH.setText(UrlDragImageView.this.getResources().getString(e.j.done));
                    UrlDragImageView.this.aUH.setTag(false);
                    UrlDragImageView.this.aUH.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    com.baidu.adp.lib.g.e.jG().postDelayed(UrlDragImageView.this.aVw, 1500L);
                    UrlDragImageView.this.aVm = false;
                    UrlDragImageView.this.aVl = UrlDragImageView.this.KO();
                    UrlDragImageView.this.KK();
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str2) {
                    UrlDragImageView.this.aVm = false;
                    BdToast.a(UrlDragImageView.this.mContext, str2).BL().BN();
                    UrlDragImageView.this.aVk.originalProcess = -1;
                    UrlDragImageView.this.KP();
                }
            });
            com.baidu.tbadk.download.d.LS().a(downloadData, 100);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean KO() {
        if (this.aVk != null && !StringUtils.isNull(this.aVk.originalUrl, true) && this.aVk.originalSize >= 0 && !this.aVk.isBlockedPic) {
            String fL = ar.fL(this.aVk.originalUrl);
            File file = new File(this.aVe + an.DL().fD(fL) + "/" + fL);
            if (file != null && file.exists()) {
                this.aVk.originalProcess = 100;
                return true;
            }
            if (this.aVk.originalProcess < 0) {
                KP();
            } else {
                this.aUH.setText(this.aVk.originalProcess + "%");
                this.aUH.setCompoundDrawablesWithIntrinsicBounds(0, 0, e.f.icon_close_yuantu, 0);
            }
            this.aVo = true;
        } else {
            this.aUH.setVisibility(8);
        }
        return false;
    }

    public void KP() {
        if (this.aVk != null) {
            if (!KQ() || !this.aVo) {
                this.aUH.setVisibility(8);
            } else {
                this.aUH.setVisibility(0);
            }
            if (this.aVk.originalSize > 0 && !an(this.aVk.originalSize)) {
                this.aUH.setText(aUE + "(" + ao.ac(this.aVk.originalSize) + ")");
            } else {
                this.aUH.setText(aUE);
            }
            this.aUH.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    private boolean KQ() {
        return (this.aVk == null || !this.aVk.mIsShowOrigonButton || this.aVk.isBlockedPic || StringUtils.isNull(this.aVk.originalUrl)) ? false : true;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.aTE = bVar;
    }

    private boolean an(long j) {
        return j > aUF;
    }
}
