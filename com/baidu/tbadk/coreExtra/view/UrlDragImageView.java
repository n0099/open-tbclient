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
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.d.c;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.d;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.File;
/* loaded from: classes.dex */
public class UrlDragImageView extends RelativeLayout implements View.OnClickListener {
    private boolean aHv;
    private b aHx;
    private boolean aHy;
    protected DragImageView aIB;
    protected TextView aIC;
    protected TextView aID;
    protected TextView aIE;
    protected SubsamplingScaleImageView aIF;
    private SubsamplingScaleImageView.OnImageEventListener aIG;
    private a aIH;
    private boolean aII;
    private boolean aIJ;
    private boolean aIK;
    private boolean aIL;
    private boolean aIM;
    private Bitmap aIN;
    private boolean aIO;
    private float aIP;
    private Matrix aIQ;
    private Rect aIR;
    private RectF aIS;
    private Rect aIT;
    private Rect aIU;
    private DragImageView.d aIV;
    private String aIX;
    private ImageUrlData aIY;
    private boolean aIZ;
    private boolean aJa;
    private boolean aJb;
    public boolean aJc;
    private TextView aJd;
    private com.baidu.tbadk.img.b aJe;
    private View.OnTouchListener aJf;
    private boolean aJg;
    private float aJh;
    private View.OnLongClickListener aJi;
    private Runnable aJj;
    private Runnable aJk;
    private View.OnTouchListener aJl;
    protected Context mContext;
    private float mLastMotionX;
    private float mLastMotionY;
    private int mMaxHeight;
    private int mMaxWidth;
    private View.OnClickListener mOnClickListener;
    protected ProgressBar mProgressBar;
    private float mRatio;
    private int mSkinType;
    private static final String aIz = TbadkCoreApplication.getInst().getString(d.k.original_img_look);
    private static long aIA = 52428800;
    private static final int aIW = l.aj(TbadkCoreApplication.getInst()) / 5;
    private static final String TAG = UrlDragImageView.class.getSimpleName();
    private static final int TOUCH_SLOP = ViewConfiguration.get(TbadkCoreApplication.getInst()).getScaledTouchSlop();

    /* loaded from: classes.dex */
    public interface a {
        void j(String str, byte[] bArr);
    }

    /* loaded from: classes.dex */
    public interface b {
        void Gp();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.aIC != null) {
                am.i(this.aIC, d.f.btn_percent_yuantu);
                am.b(this.aIC, d.C0142d.cp_cont_g, 1, 0);
            }
            if (this.aID != null) {
                am.j(this.aID, d.C0142d.common_color_10022);
                am.b(this.aID, d.C0142d.cp_cont_g, 1, 0);
            }
            this.mSkinType = i;
        }
    }

    public void setHeadImage(boolean z) {
        if (this.aIB != null) {
            this.aIB.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.aIH = aVar;
    }

    public UrlDragImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mContext = null;
        this.mProgressBar = null;
        this.aIB = null;
        this.aIH = null;
        this.aHv = false;
        this.aIK = false;
        this.aIO = false;
        this.mRatio = 1.0f;
        this.aIP = 0.0f;
        this.aIQ = new Matrix();
        this.aIS = new RectF();
        this.aIZ = false;
        this.aJa = false;
        this.aJb = false;
        this.aJc = false;
        this.aJd = null;
        this.aJg = true;
        this.aJh = 0.0f;
        this.mOnClickListener = null;
        this.aJi = null;
        this.aJj = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.aJg = true;
            }
        };
        this.aJk = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.aIC.setVisibility(8);
                        UrlDragImageView.this.aJc = false;
                    }
                });
                UrlDragImageView.this.aIC.startAnimation(alphaAnimation);
            }
        };
        this.aJl = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.aJf != null) {
                    UrlDragImageView.this.aJf.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.aJe = new com.baidu.tbadk.img.b();
        init();
    }

    public UrlDragImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.mContext = null;
        this.mProgressBar = null;
        this.aIB = null;
        this.aIH = null;
        this.aHv = false;
        this.aIK = false;
        this.aIO = false;
        this.mRatio = 1.0f;
        this.aIP = 0.0f;
        this.aIQ = new Matrix();
        this.aIS = new RectF();
        this.aIZ = false;
        this.aJa = false;
        this.aJb = false;
        this.aJc = false;
        this.aJd = null;
        this.aJg = true;
        this.aJh = 0.0f;
        this.mOnClickListener = null;
        this.aJi = null;
        this.aJj = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.aJg = true;
            }
        };
        this.aJk = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.aIC.setVisibility(8);
                        UrlDragImageView.this.aJc = false;
                    }
                });
                UrlDragImageView.this.aIC.startAnimation(alphaAnimation);
            }
        };
        this.aJl = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.aJf != null) {
                    UrlDragImageView.this.aJf.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.aJe = new com.baidu.tbadk.img.b();
        init();
    }

    public DragImageView getImageView() {
        return this.aIB;
    }

    public void setGifSetListener(DragImageView.e eVar) {
        this.aIB.setGifSetListener(eVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.aIB.setImageOnClickListener(onClickListener);
        this.aIF.setOnClickListener(onClickListener);
        this.mOnClickListener = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aJi = onLongClickListener;
        if (!this.aHy) {
            this.aIB.setImageOnLongClickListener(this.aJi);
            this.aIF.setOnLongClickListener(this.aJi);
        }
    }

    public void setOnSizeChangedListener(final DragImageView.f fVar) {
        this.aIB.setOnSizeChangedListener(new DragImageView.f() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.8
            @Override // com.baidu.tbadk.widget.DragImageView.f
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (fVar != null) {
                    fVar.a(dragImageView, z, z2);
                }
                UrlDragImageView.this.Gd();
            }
        });
    }

    protected void init() {
        this.mMaxWidth = l.ah(this.mContext);
        this.mMaxHeight = l.aj(this.mContext) - ((int) this.mContext.getResources().getDimension(d.e.ds166));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.aIB = new DragImageView(this.mContext);
        this.aIB.setLayoutParams(layoutParams);
        this.aIB.setOnTouchListener(this.aJl);
        addView(this.aIB);
        this.aIF = new SubsamplingScaleImageView(this.mContext);
        this.aIF.setMaxScale(50.0f);
        this.aIF.setOnTouchListener(this.aJl);
        this.aIF.setVisibility(4);
        addView(this.aIF, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(getResources().getDrawable(d.f.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        FZ();
        FX();
        Ga();
    }

    private void FX() {
        this.aIX = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        this.aIC = new TextView(this.mContext);
        am.i(this.aIC, d.f.btn_percent_yuantu);
        this.aIC.setText(d.k.original_img_look);
        this.aIC.setTextSize(0, getResources().getDimensionPixelSize(d.e.fontsize28));
        am.b(this.aIC, d.C0142d.cp_cont_i, 1, 0);
        this.aIC.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds16);
        this.aIC.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        this.aIC.setMinWidth(getResources().getDimensionPixelSize(d.e.ds222));
        this.aIC.setMinHeight(getResources().getDimensionPixelSize(d.e.ds60));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(d.e.fontsize40);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        this.aIC.setOnClickListener(this);
        this.aIC.setVisibility(8);
        addView(this.aIC, layoutParams);
    }

    public void setIsCanDrag(boolean z) {
        this.aHy = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        Bitmap imageBitmap;
        int height;
        int width;
        if (!this.aHy || !this.aIJ) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.aIL && motionEvent.getPointerCount() >= 2) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.aIL || this.aIM) {
            requestDisallowInterceptTouchEvent(true);
        }
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        float x = motionEvent.getX();
        int i = action & 255;
        if (i == 0) {
            if (this.aIN == null) {
                if (this.aIF.getVisibility() == 0) {
                    this.aIN = com.baidu.tbadk.util.d.S(this.aIF);
                } else {
                    this.aIN = com.baidu.tbadk.util.d.S(this.aIB);
                }
            }
            if (this.aIR == null && this.aIN != null) {
                int measuredWidth = getMeasuredWidth();
                float measuredWidth2 = ((getMeasuredWidth() * 1.0f) / this.aIN.getWidth()) * this.aIN.getHeight();
                if (measuredWidth2 > getMeasuredHeight()) {
                    measuredWidth2 = getMeasuredHeight();
                }
                RectF g = g(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
                this.aIR = new Rect((int) g.left, (int) g.top, (int) g.right, (int) g.bottom);
            }
            if (this.aIU == null && this.aIN != null) {
                if (this.aIF.getVisibility() == 0) {
                    height = this.aIF.getSHeight();
                    width = this.aIF.getSWidth();
                } else {
                    if (this.aIB.getImageType() == 1) {
                        imageBitmap = (this.aIB.getCurrentFrame() == null || this.aIB.getCurrentFrame().aXI == null) ? this.aIN : this.aIB.getCurrentFrame().aXI;
                    } else {
                        imageBitmap = this.aIB.getImageBitmap() == null ? this.aIN : this.aIB.getImageBitmap();
                    }
                    height = imageBitmap.getHeight();
                    width = imageBitmap.getWidth();
                }
                float ak = l.ak(getContext());
                int i2 = (int) (height * ak);
                int i3 = (int) (width * ak);
                if (i3 > this.aIN.getWidth() && this.aIN.getWidth() != 0) {
                    float width2 = (i3 * 1.0f) / this.aIN.getWidth();
                    i3 = this.aIN.getWidth();
                    i2 = (int) (i2 / width2);
                }
                if (i2 > this.aIN.getHeight() && this.aIN.getHeight() != 0) {
                    i3 = (int) (i3 / ((i2 * 1.0f) / this.aIN.getHeight()));
                    i2 = this.aIN.getHeight();
                }
                int aj = (l.aj(getContext()) - i2) / 2;
                int ah = (l.ah(getContext()) - i3) / 2;
                this.aIU = new Rect(ah, aj, i3 + ah, i2 + aj);
                this.aIT = new Rect(0, 0, this.aIN.getWidth(), this.aIN.getHeight());
            }
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (i == 2) {
            this.aIL = l(this.mLastMotionX - x, this.mLastMotionY - y);
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (this.aIL || this.aIM) {
            this.aIB.setImageOnLongClickListener(null);
            this.aIF.setOnLongClickListener(null);
            z = true;
        } else {
            this.aIB.setImageOnLongClickListener(this.aJi);
            this.aIF.setOnLongClickListener(this.aJi);
            z = super.dispatchTouchEvent(motionEvent);
        }
        if (i == 1 || i == 3) {
            this.mLastMotionX = 0.0f;
            this.mLastMotionY = 0.0f;
            this.aIO = false;
            this.aIQ.reset();
            this.aIL = false;
            if (this.aIP > aIW) {
                this.aIM = true;
                FY();
                return z;
            }
            this.mRatio = 1.0f;
            invalidate();
            return z;
        }
        return z;
    }

    private boolean l(float f, float f2) {
        if (this.aIF.getVisibility() != 0 || this.aIF.isCanDrag()) {
            if (this.aIY == null || !this.aIY.isLongPic || this.aIF.getVisibility() != 0 || this.aIF.isViewTop()) {
                if (this.aIY == null || !this.aIY.isLongPic || this.aIF.getVisibility() == 0 || this.aIB.LJ()) {
                    if (this.aIF.getVisibility() == 0 || this.aIB.LL()) {
                        if (this.aIN != null && getScrollY() == 0 && f2 < 0.0f && !this.aIO) {
                            this.aIO = true;
                            this.aIP = 0.0f;
                            this.mRatio = 1.0f;
                            if (this.aIV != null) {
                                this.aIV.Mb();
                            }
                        }
                        if (this.aIO) {
                            this.aIP -= f2;
                            int measuredHeight = getMeasuredHeight();
                            if (this.aIP > measuredHeight) {
                                this.aIP = measuredHeight;
                            }
                            float f3 = f2 / measuredHeight;
                            this.aIQ.postTranslate((-f) * 1.5f * this.mRatio, (-1.5f) * f2 * this.mRatio);
                            if (this.mRatio * (1.0f + f3) > 1.0f || this.aIP < 0.0f) {
                                this.aIQ.preScale(1.0f / this.mRatio, 1.0f / this.mRatio, (this.mRatio * this.aIN.getWidth()) / 2.0f, this.mRatio * (this.aIN.getHeight() / 2));
                                this.mRatio = 1.0f;
                            } else {
                                this.aIQ.preScale(1.0f + f3, 1.0f + f3, (this.mRatio * this.aIN.getWidth()) / 2.0f, this.mRatio * (this.aIN.getHeight() / 2));
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
        if (this.aIL && this.aIN != null && !this.aIN.isRecycled() && this.aIO) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.aIS == null) {
                this.aIS = new RectF();
            }
            this.aIQ.mapRect(this.aIS, new RectF(this.aIR));
            canvas.drawBitmap(this.aIN, this.aIT, this.aIS, (Paint) null);
        } else if (this.aIM && this.aIN != null && !this.aIN.isRecycled()) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.aIY == null || this.aIY.getSourceImageRectInScreen() == null) {
                canvas.drawBitmap(this.aIN, this.aIT, this.aIS, (Paint) null);
            } else {
                canvas.drawBitmap(this.aIN, this.aIU, this.aIS, (Paint) null);
            }
        } else {
            super.dispatchDraw(canvas);
        }
    }

    private void FY() {
        if (this.aIY == null) {
            if (this.aIV != null) {
                this.aIV.Mc();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.aIY.getSourceImageRectInScreen();
        if (sourceImageRectInScreen == null) {
            if (this.aIV != null) {
                this.aIV.Mc();
                return;
            }
            return;
        }
        this.aIS.bottom = (((sourceImageRectInScreen.bottom - sourceImageRectInScreen.top) / (sourceImageRectInScreen.right - sourceImageRectInScreen.left)) * (this.aIS.right - this.aIS.left)) + this.aIS.top;
        final float[] fArr = {(this.aIS.left + this.aIS.right) / 2.0f, (this.aIS.top + this.aIS.bottom) / 2.0f};
        final float[] fArr2 = {(sourceImageRectInScreen.left + sourceImageRectInScreen.right) / 2, (sourceImageRectInScreen.top + sourceImageRectInScreen.bottom) / 2};
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr[0], fArr2[0]);
        ofFloat.setDuration(150L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && sourceImageRectInScreen != null) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    float animatedFraction = fArr[1] + ((fArr2[1] - fArr[1]) * valueAnimator.getAnimatedFraction());
                    UrlDragImageView.this.aIS = UrlDragImageView.this.g(floatValue, animatedFraction, sourceImageRectInScreen.right - sourceImageRectInScreen.left, sourceImageRectInScreen.bottom - sourceImageRectInScreen.top);
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
                UrlDragImageView.this.aIO = false;
                UrlDragImageView.this.invalidate();
                if (UrlDragImageView.this.aIV != null) {
                    UrlDragImageView.this.aIV.Mc();
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
    public RectF g(float f, float f2, float f3, float f4) {
        return new RectF(f - (f3 / 2.0f), f2 - (f4 / 2.0f), (f3 / 2.0f) + f, (f4 / 2.0f) + f2);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.aJf = onTouchListener;
    }

    private void FZ() {
        this.aJd = new TextView(this.mContext);
        this.aJd.setBackgroundResource(d.f.bg_url_drag_imagview_fade_view);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.height = getResources().getDimensionPixelSize(d.e.ds180);
        layoutParams.addRule(12);
        addView(this.aJd, layoutParams);
        this.aJd.setVisibility(8);
    }

    private void Ga() {
        this.aID = new TextView(this.mContext);
        am.j(this.aID, d.C0142d.common_color_10022);
        this.aID.setText(d.k.goto_pb_floor);
        this.aID.setTextSize(0, getResources().getDimensionPixelSize(d.e.fontsize28));
        am.b(this.aID, d.C0142d.cp_cont_i, 1, 0);
        this.aID.setCompoundDrawablePadding(l.dip2px(this.mContext, 4.0f));
        this.aID.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(d.f.icon_see_arrow), (Drawable) null);
        this.aID.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds20);
        this.aID.setPadding(dimensionPixelSize * 3, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(d.e.ds30);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(d.e.ds10);
        layoutParams.leftMargin = getResources().getDimensionPixelSize(d.e.ds20);
        layoutParams.addRule(1, this.aIC.getId());
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        this.aID.setOnClickListener(this);
        this.aID.setMinHeight(getResources().getDimensionPixelSize(d.e.ds100));
        addView(this.aID, layoutParams);
        this.aID.setVisibility(8);
    }

    private void Gb() {
        if (this.aID != null) {
            boolean z = this.aII || this.aIJ;
            if (!this.aJb && z && this.aIY != null && this.aIY.threadId > 0 && this.aIY.postId > 0 && this.aIY.mThreadType != 33 && !this.aIY.isBlockedPic) {
                this.aID.setVisibility(0);
                if (this.aJd != null) {
                    this.aJd.setVisibility(0);
                    return;
                }
                return;
            }
            this.aID.setVisibility(8);
            if (this.aJd != null) {
                this.aJd.setVisibility(8);
            }
        }
    }

    private void Gc() {
        if (this.aID != null) {
            this.aID.setVisibility(8);
            if (this.aJd != null) {
                this.aJd.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gd() {
        if ((this.aII || this.aIJ) && this.aIY != null && this.aIY.mPicType == 1 && !TextUtils.isEmpty(this.aIY.mTagName)) {
            if (this.aIE != null) {
                this.aIE.setVisibility(8);
                this.aIE = null;
            }
            this.aIE = new TextView(this.mContext);
            this.aIE.setText(this.aIY.mTagName);
            this.aIE.setTextSize(0, getResources().getDimensionPixelSize(d.e.fontsize26));
            am.b(this.aIE, d.C0142d.common_color_10013, 1, 0);
            am.j(this.aIE, d.C0142d.common_color_10215);
            this.aIE.setAlpha(0.75f);
            this.aIE.setIncludeFontPadding(false);
            this.aIE.setGravity(17);
            int e = l.e(this.mContext, d.e.ds2);
            this.aIE.setPadding(e, e, e, e);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.aIB.getBottomOffset();
            layoutParams.leftMargin = this.aIB.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.aIE, layoutParams);
            this.aIE.setVisibility(0);
        }
    }

    public void bt(boolean z) {
        this.aJb = z;
        if (this.aJb) {
            Gc();
        } else {
            Gb();
        }
    }

    public void setUrl(String str, boolean z) {
        if (str.contains("*")) {
            str = str.split("[*]")[0];
        }
        this.aIB.setTag(str);
        this.aIB.setLoadBigImage(false);
        this.aIB.setImageDrawable(null);
        this.aII = false;
        this.aIJ = false;
        this.aIZ = Gk();
        this.aIC.setVisibility(8);
        if (gg(str)) {
            b(str, z, false);
        }
    }

    private boolean Ge() {
        return this.aIB != null && this.aIB.LZ();
    }

    public void Gf() {
        if (this.aIY != null && !Ge()) {
            String str = this.aIY.imageUrl;
            int i = this.aIY.urlType;
            com.baidu.adp.widget.ImageView.a aVar = null;
            if (com.baidu.tbadk.core.util.d.a.v(str, i)) {
                aVar = com.baidu.tbadk.core.util.d.a.w(str, i);
            }
            if (aVar != null) {
                setThumbBitmapToView(aVar);
            }
        }
    }

    private boolean bu(boolean z) {
        String eO;
        if (!this.aJa || z) {
            this.aJa = true;
            if (!this.aIZ || this.aIY == null || StringUtils.isNull(this.aIY.originalUrl, true) || this.aIY.originalSize < 0 || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String str = this.aIX + ao.zz().eH(eO) + "/" + as.eO(this.aIY.originalUrl);
            final int[] ej = com.baidu.tbadk.core.util.l.ej(str);
            this.aIF.setVisibility(0);
            if (this.aIG == null) {
                this.aIG = new SubsamplingScaleImageView.OnImageEventListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12
                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onReady() {
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.aIB.LV();
                        UrlDragImageView.this.aIB.setVisibility(4);
                    }

                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onImageLoaded() {
                        if (UrlDragImageView.this.aIY.isLongPic && ej[0] > 0) {
                            UrlDragImageView.this.aIB.onDestroy();
                            final float measuredWidth = (UrlDragImageView.this.getMeasuredWidth() * 1.0f) / ej[0];
                            final PointF pointF = new PointF((ej[0] * 1.0f) / 2.0f, 0.0f);
                            UrlDragImageView.this.aIF.setScaleAndCenter(measuredWidth, pointF);
                            UrlDragImageView.this.aIF.setMaxScale(2.0f * measuredWidth);
                            UrlDragImageView.this.aIF.setDoubleTapZoomScale(2.0f * measuredWidth);
                            UrlDragImageView.this.aIF.setInitScale(measuredWidth);
                            UrlDragImageView.this.aIF.setDoubleTapZoomStyle(4);
                            UrlDragImageView.this.aIF.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12.1
                                @Override // android.view.View.OnTouchListener
                                public boolean onTouch(View view, MotionEvent motionEvent) {
                                    if (UrlDragImageView.this.aJf != null) {
                                        UrlDragImageView.this.aJf.onTouch(view, motionEvent);
                                    }
                                    switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                                        case 0:
                                            UrlDragImageView.this.aJh = motionEvent.getY();
                                            UrlDragImageView.this.aIF.setOnClickListener(UrlDragImageView.this.aJg ? UrlDragImageView.this.mOnClickListener : null);
                                            UrlDragImageView.this.aIF.setOnLongClickListener(UrlDragImageView.this.aJg ? UrlDragImageView.this.aJi : null);
                                            break;
                                        case 1:
                                        case 3:
                                            if (UrlDragImageView.this.aIF.getScale() < measuredWidth) {
                                                UrlDragImageView.this.aIF.setScaleAndCenter(measuredWidth, pointF);
                                            }
                                            e.im().removeCallbacks(UrlDragImageView.this.aJj);
                                            e.im().postDelayed(UrlDragImageView.this.aJj, 1000L);
                                            break;
                                        case 2:
                                            if (Math.abs(motionEvent.getY() - UrlDragImageView.this.aJh) > UrlDragImageView.TOUCH_SLOP) {
                                                UrlDragImageView.this.aJg = false;
                                                UrlDragImageView.this.aIF.setOnClickListener(null);
                                                UrlDragImageView.this.aIF.setOnLongClickListener(null);
                                            }
                                            UrlDragImageView.this.aJh = motionEvent.getY();
                                            break;
                                    }
                                    return false;
                                }
                            });
                            UrlDragImageView.this.aIB.setVisibility(4);
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
            this.aIF.setOnImageEventListener(this.aIG);
            if (this.aIF.isImageLoaded() && this.aIY.isLongPic) {
                this.aIG.onImageLoaded();
            } else {
                this.aIF.setImage(ImageSource.uri(str));
            }
            return true;
        }
        return false;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.aIV = dVar;
        if (this.aIB != null) {
            this.aIB.setDragToExitListener(dVar);
        }
    }

    public void Gg() {
        bu(false);
    }

    private boolean gg(String str) {
        return j.jD() || c.ff(str);
    }

    private void setThumbBitmapToView(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap mZ;
        if (!this.aIJ && aVar != null && (mZ = aVar.mZ()) != null) {
            this.aII = true;
            if (aVar.isGif()) {
                this.aIB.setImageUrlData(this.aIY);
                this.aIB.setImageBitmap(mZ);
                this.aIC.setVisibility(8);
                this.aJc = false;
            } else {
                if (this.aIY != null && this.aIY.isLongPic) {
                    this.aIB.LO();
                    this.aIB.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.13
                        @Override // com.baidu.tbadk.widget.largeImage.logic.a
                        public void Go() {
                        }
                    });
                }
                this.aIB.setImageUrlData(this.aIY);
                this.aIB.setImageData(mZ, aVar.ne());
            }
            Gb();
            Gd();
        }
    }

    private void b(String str, boolean z, boolean z2) {
        if (gh(str)) {
            if (z2 || (!this.aIK && !this.aIJ)) {
                if (!z2 || !bu(true)) {
                    this.aIK = true;
                    com.baidu.adp.lib.f.c.ig().a(str, 27, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.14
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onCancelled(String str2) {
                            UrlDragImageView.this.aIK = false;
                            UrlDragImageView.this.aIB.setVisibility(0);
                            UrlDragImageView.this.mProgressBar.setVisibility(8);
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            UrlDragImageView.this.aIK = false;
                            UrlDragImageView.this.aIJ = true;
                            UrlDragImageView.this.b(aVar);
                        }
                    }, 0, 0, false, null, Boolean.valueOf(z), this.aIB.getImageData(), Boolean.valueOf(this.aHv));
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
        imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.H(this.mMaxWidth, this.mMaxHeight));
        com.baidu.adp.widget.ImageView.a a2 = this.aJe.a(imageFileInfo, false);
        if (a2 != null) {
            this.aIJ = true;
            this.mProgressBar.setVisibility(8);
            b(a2);
            return;
        }
        this.aJe.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.2
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.ImageView.a aVar, String str2, boolean z3) {
                UrlDragImageView.this.aIJ = true;
                UrlDragImageView.this.mProgressBar.setVisibility(8);
                UrlDragImageView.this.b(aVar);
            }
        }, false);
    }

    private boolean gh(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null && this.aIH != null) {
            this.aIH.j(aVar.getUrl(), aVar.ne());
        }
        if (aVar == null || aVar.mZ() == null) {
            Gh();
            return;
        }
        Bitmap mZ = aVar.mZ();
        this.aIB.setLoadBigImage(true);
        if (aVar.isGif()) {
            this.aIB.setGifData(aVar.ne(), mZ);
            this.aIB.invalidate();
            this.aIB.play();
            this.aJc = false;
            this.aIC.setVisibility(8);
            this.mProgressBar.setVisibility(8);
        } else {
            if (this.aIY != null && this.aIY.isLongPic) {
                this.aIB.LO();
                this.aIB.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.3
                    @Override // com.baidu.tbadk.widget.largeImage.logic.a
                    public void Go() {
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                    }
                });
            } else {
                this.mProgressBar.setVisibility(8);
            }
            this.aIB.setImageUrlData(this.aIY);
            this.aIB.setImageData(mZ, aVar.ne());
            Gl();
        }
        Gb();
        Gd();
    }

    private void Gh() {
        if (!this.aII) {
            this.aIB.setDefaultBitmap();
        } else {
            this.aIJ = false;
        }
        this.aIC.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    public void setGifMaxUseableMem(int i) {
        this.aIB.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.aIB != null) {
            this.aIB.onDestroy();
        }
        if (this.aIF != null) {
            this.aIF.recycle();
        }
        if (this.aIN != null) {
            this.aIN.recycle();
            this.aIN = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        e.im().removeCallbacks(this.aJj);
    }

    public void release() {
        if (this.aIB != null) {
            this.aIB.release();
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.aIC != null) {
            this.aIC.setVisibility(8);
        }
    }

    public void Gi() {
        if (this.aIB != null && this.aIB.getImageType() == 1) {
            this.aIB.stop();
        }
    }

    public void i(boolean z, boolean z2) {
        String str;
        if (this.aIB != null && (str = (String) this.aIB.getTag()) != null) {
            if (this.aIB.getImageType() == 1) {
                if (this.aIB.getGifCache() == null || !this.aIB.LZ()) {
                    b(str, z, z2);
                }
            } else if (this.aIB.getImageType() == 2) {
                b(str, z, z2);
            } else if (Gj()) {
                b(str, z, z2);
            }
        }
    }

    private boolean Gj() {
        if (this.aIB.getImageBitmap() != null && this.aIB.LZ()) {
            if (this.aIY == null || !this.aIY.isLongPic || this.aIB.LP()) {
                return false;
            }
            this.aIJ = false;
            this.aJa = false;
            return true;
        }
        return true;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.aIY = imageUrlData;
    }

    public void setIsCdn(boolean z) {
        this.aHv = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aIC) {
            if (!(this.aIC.getTag() instanceof Boolean) || ((Boolean) this.aIC.getTag()).booleanValue()) {
                final String eO = as.eO(this.aIY.originalUrl);
                if (this.aIY.originalProcess >= 0) {
                    com.baidu.tbadk.download.e.Hr().z(eO, 13);
                    this.aIY.originalProcess = -1;
                    Gl();
                    return;
                }
                if (this.aHx != null) {
                    this.aHx.Gp();
                }
                com.baidu.adp.base.e<?> ad = i.ad(this.mContext);
                if (ad == null) {
                    gi(eO);
                } else if (!j.jD() || j.jE() || com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("original_img_down_tip", false)) {
                    gi(eO);
                } else {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("original_img_down_tip", true);
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(ad.getPageActivity());
                    aVar.cd(d.k.original_img_down_no_wifi_tip);
                    aVar.a(d.k.alert_yes_button, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.4
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar.dismiss();
                            UrlDragImageView.this.gi(eO);
                        }
                    });
                    aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.5
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar.dismiss();
                        }
                    });
                    aVar.b(ad);
                    aVar.xn();
                }
            }
        } else if (view == this.aID && this.aIY != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.mContext).createHistoryCfg(String.valueOf(this.aIY.threadId), String.valueOf(this.aIY.postId), this.aIY.mIsSeeHost, this.aIY.mIsReserver, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gi(String str) {
        if (this.aIY != null) {
            this.aIY.originalProcess = 0;
        }
        this.aIC.setText("0%");
        this.aIC.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_close_yuantu, 0);
        DownloadData downloadData = new DownloadData(str);
        downloadData.setStatus(1);
        downloadData.setUrl(this.aIY.originalUrl);
        downloadData.setType(13);
        downloadData.setPath(this.aIX + ao.zz().eH(str) + "/" + str);
        downloadData.setCallback(new com.baidu.tbadk.download.d() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.6
            @Override // com.baidu.tbadk.download.d
            public boolean onPreDownload(DownloadData downloadData2) {
                return true;
            }

            @Override // com.baidu.tbadk.download.d
            public void onFileUpdateProgress(DownloadData downloadData2) {
                if (downloadData2 != null) {
                    if (UrlDragImageView.this.aIY != null && UrlDragImageView.this.aIY.originalProcess != -1) {
                        UrlDragImageView.this.aIY.originalProcess = downloadData2.getProcess();
                    }
                    if (UrlDragImageView.this.aIY == null || UrlDragImageView.this.aIY.originalProcess != -1) {
                        UrlDragImageView.this.aIC.setText(downloadData2.getProcess() + "%");
                        UrlDragImageView.this.aIC.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_close_yuantu, 0);
                    }
                }
            }

            @Override // com.baidu.tbadk.download.d
            public boolean onFileDownloaded(DownloadData downloadData2) {
                return true;
            }

            @Override // com.baidu.tbadk.download.d
            public void onFileDownloadSucceed(DownloadData downloadData2) {
                UrlDragImageView.this.aIC.setText(UrlDragImageView.this.getResources().getString(d.k.done));
                UrlDragImageView.this.aIC.setTag(false);
                UrlDragImageView.this.aIC.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                e.im().postDelayed(UrlDragImageView.this.aJk, 1500L);
                UrlDragImageView.this.aJa = false;
                UrlDragImageView.this.aIZ = UrlDragImageView.this.Gk();
                UrlDragImageView.this.Gg();
            }

            @Override // com.baidu.tbadk.download.d
            public void onFileDownloadFailed(DownloadData downloadData2, int i, String str2) {
                UrlDragImageView.this.aJa = false;
                BdToast.a(UrlDragImageView.this.mContext, str2).xt().xv();
                UrlDragImageView.this.aIY.originalProcess = -1;
                UrlDragImageView.this.Gl();
            }
        });
        com.baidu.tbadk.download.e.Hr().a(downloadData, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Gk() {
        if (this.aIY != null && !StringUtils.isNull(this.aIY.originalUrl, true) && this.aIY.originalSize >= 0 && !this.aIY.isBlockedPic) {
            String eO = as.eO(this.aIY.originalUrl);
            File file = new File(this.aIX + ao.zz().eH(eO) + "/" + eO);
            if (file != null && file.exists()) {
                this.aIY.originalProcess = 100;
                return true;
            }
            if (this.aIY.originalProcess < 0) {
                Gl();
            } else {
                this.aIC.setText(this.aIY.originalProcess + "%");
                this.aIC.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_close_yuantu, 0);
            }
            this.aJc = true;
        } else {
            this.aIC.setVisibility(8);
        }
        return false;
    }

    public void Gl() {
        if (this.aIY != null) {
            if (!Gm() || !this.aJc) {
                this.aIC.setVisibility(8);
            } else {
                this.aIC.setVisibility(0);
            }
            if (this.aIY.originalSize > 0 && !V(this.aIY.originalSize)) {
                this.aIC.setText(aIz + "(" + ap.K(this.aIY.originalSize) + ")");
            } else {
                this.aIC.setText(aIz);
            }
            this.aIC.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    private boolean Gm() {
        return (this.aIY == null || !this.aIY.mIsShowOrigonButton || this.aIY.isBlockedPic || StringUtils.isNull(this.aIY.originalUrl)) ? false : true;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.aHx = bVar;
    }

    private boolean V(long j) {
        return j > aIA;
    }
}
