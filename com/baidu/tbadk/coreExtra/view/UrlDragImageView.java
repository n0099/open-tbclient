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
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.d;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.File;
/* loaded from: classes.dex */
public class UrlDragImageView extends RelativeLayout implements View.OnClickListener {
    private boolean aGD;
    private b aGF;
    private boolean aGG;
    protected DragImageView aHE;
    protected TextView aHF;
    protected TextView aHG;
    protected TextView aHH;
    protected SubsamplingScaleImageView aHI;
    private SubsamplingScaleImageView.OnImageEventListener aHJ;
    private a aHK;
    private boolean aHL;
    private boolean aHM;
    private boolean aHN;
    private boolean aHO;
    private boolean aHP;
    private Bitmap aHQ;
    private boolean aHR;
    private float aHS;
    private Matrix aHT;
    private Rect aHU;
    private RectF aHV;
    private Rect aHW;
    private Rect aHX;
    private DragImageView.d aHY;
    private String aIa;
    private ImageUrlData aIb;
    private boolean aIc;
    private boolean aId;
    private boolean aIe;
    public boolean aIf;
    private TextView aIg;
    private com.baidu.tbadk.img.b aIh;
    private View.OnTouchListener aIi;
    private boolean aIj;
    private float aIk;
    private View.OnLongClickListener aIl;
    private Runnable aIm;
    private Runnable aIn;
    private View.OnTouchListener aIo;
    protected Context mContext;
    private float mLastMotionX;
    private float mLastMotionY;
    private int mMaxHeight;
    private int mMaxWidth;
    private View.OnClickListener mOnClickListener;
    protected ProgressBar mProgressBar;
    private float mRatio;
    private int mSkinType;
    private static final String aHC = TbadkCoreApplication.getInst().getString(d.k.original_img_look);
    private static long aHD = 52428800;
    private static final int aHZ = l.aj(TbadkCoreApplication.getInst()) / 5;
    private static final String TAG = UrlDragImageView.class.getSimpleName();
    private static final int TOUCH_SLOP = ViewConfiguration.get(TbadkCoreApplication.getInst()).getScaledTouchSlop();

    /* loaded from: classes.dex */
    public interface a {
        void j(String str, byte[] bArr);
    }

    /* loaded from: classes.dex */
    public interface b {
        void FX();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.aHF != null) {
                al.i(this.aHF, d.f.btn_percent_yuantu);
                al.b(this.aHF, d.C0141d.cp_cont_g, 1, 0);
            }
            if (this.aHG != null) {
                al.j(this.aHG, d.C0141d.common_color_10022);
                al.b(this.aHG, d.C0141d.cp_cont_g, 1, 0);
            }
            this.mSkinType = i;
        }
    }

    public void setHeadImage(boolean z) {
        if (this.aHE != null) {
            this.aHE.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.aHK = aVar;
    }

    public UrlDragImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mContext = null;
        this.mProgressBar = null;
        this.aHE = null;
        this.aHK = null;
        this.aGD = false;
        this.aHN = false;
        this.aHR = false;
        this.mRatio = 1.0f;
        this.aHS = 0.0f;
        this.aHT = new Matrix();
        this.aHV = new RectF();
        this.aIc = false;
        this.aId = false;
        this.aIe = false;
        this.aIf = false;
        this.aIg = null;
        this.aIj = true;
        this.aIk = 0.0f;
        this.mOnClickListener = null;
        this.aIl = null;
        this.aIm = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.aIj = true;
            }
        };
        this.aIn = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.aHF.setVisibility(8);
                        UrlDragImageView.this.aIf = false;
                    }
                });
                UrlDragImageView.this.aHF.startAnimation(alphaAnimation);
            }
        };
        this.aIo = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.aIi != null) {
                    UrlDragImageView.this.aIi.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.aIh = new com.baidu.tbadk.img.b();
        init();
    }

    public UrlDragImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.mContext = null;
        this.mProgressBar = null;
        this.aHE = null;
        this.aHK = null;
        this.aGD = false;
        this.aHN = false;
        this.aHR = false;
        this.mRatio = 1.0f;
        this.aHS = 0.0f;
        this.aHT = new Matrix();
        this.aHV = new RectF();
        this.aIc = false;
        this.aId = false;
        this.aIe = false;
        this.aIf = false;
        this.aIg = null;
        this.aIj = true;
        this.aIk = 0.0f;
        this.mOnClickListener = null;
        this.aIl = null;
        this.aIm = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.aIj = true;
            }
        };
        this.aIn = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.aHF.setVisibility(8);
                        UrlDragImageView.this.aIf = false;
                    }
                });
                UrlDragImageView.this.aHF.startAnimation(alphaAnimation);
            }
        };
        this.aIo = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.aIi != null) {
                    UrlDragImageView.this.aIi.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.aIh = new com.baidu.tbadk.img.b();
        init();
    }

    public DragImageView getImageView() {
        return this.aHE;
    }

    public void setGifSetListener(DragImageView.e eVar) {
        this.aHE.setGifSetListener(eVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.aHE.setImageOnClickListener(onClickListener);
        this.aHI.setOnClickListener(onClickListener);
        this.mOnClickListener = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aIl = onLongClickListener;
        if (!this.aGG) {
            this.aHE.setImageOnLongClickListener(this.aIl);
            this.aHI.setOnLongClickListener(this.aIl);
        }
    }

    public void setOnSizeChangedListener(final DragImageView.f fVar) {
        this.aHE.setOnSizeChangedListener(new DragImageView.f() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.8
            @Override // com.baidu.tbadk.widget.DragImageView.f
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (fVar != null) {
                    fVar.a(dragImageView, z, z2);
                }
                UrlDragImageView.this.FL();
            }
        });
    }

    protected void init() {
        this.mMaxWidth = l.ah(this.mContext);
        this.mMaxHeight = l.aj(this.mContext) - ((int) this.mContext.getResources().getDimension(d.e.ds166));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.aHE = new DragImageView(this.mContext);
        this.aHE.setLayoutParams(layoutParams);
        this.aHE.setOnTouchListener(this.aIo);
        addView(this.aHE);
        this.aHI = new SubsamplingScaleImageView(this.mContext);
        this.aHI.setMaxScale(50.0f);
        this.aHI.setOnTouchListener(this.aIo);
        this.aHI.setVisibility(4);
        addView(this.aHI, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(getResources().getDrawable(d.f.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        FH();
        FF();
        FI();
    }

    private void FF() {
        this.aIa = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        this.aHF = new TextView(this.mContext);
        al.i(this.aHF, d.f.btn_percent_yuantu);
        this.aHF.setText(d.k.original_img_look);
        this.aHF.setTextSize(0, getResources().getDimensionPixelSize(d.e.fontsize28));
        al.b(this.aHF, d.C0141d.cp_cont_i, 1, 0);
        this.aHF.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds16);
        this.aHF.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        this.aHF.setMinWidth(getResources().getDimensionPixelSize(d.e.ds222));
        this.aHF.setMinHeight(getResources().getDimensionPixelSize(d.e.ds60));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(d.e.fontsize40);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        this.aHF.setOnClickListener(this);
        this.aHF.setVisibility(8);
        addView(this.aHF, layoutParams);
    }

    public void setIsCanDrag(boolean z) {
        this.aGG = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        Bitmap imageBitmap;
        int height;
        int width;
        if (!this.aGG || !this.aHM) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.aHO && motionEvent.getPointerCount() >= 2) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.aHO || this.aHP) {
            requestDisallowInterceptTouchEvent(true);
        }
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        float x = motionEvent.getX();
        int i = action & 255;
        if (i == 0) {
            if (this.aHQ == null) {
                if (this.aHI.getVisibility() == 0) {
                    this.aHQ = com.baidu.tbadk.util.d.R(this.aHI);
                } else {
                    this.aHQ = com.baidu.tbadk.util.d.R(this.aHE);
                }
            }
            if (this.aHU == null && this.aHQ != null) {
                int measuredWidth = getMeasuredWidth();
                float measuredWidth2 = ((getMeasuredWidth() * 1.0f) / this.aHQ.getWidth()) * this.aHQ.getHeight();
                if (measuredWidth2 > getMeasuredHeight()) {
                    measuredWidth2 = getMeasuredHeight();
                }
                RectF g = g(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
                this.aHU = new Rect((int) g.left, (int) g.top, (int) g.right, (int) g.bottom);
            }
            if (this.aHX == null && this.aHQ != null) {
                if (this.aHI.getVisibility() == 0) {
                    height = this.aHI.getSHeight();
                    width = this.aHI.getSWidth();
                } else {
                    if (this.aHE.getImageType() == 1) {
                        imageBitmap = (this.aHE.getCurrentFrame() == null || this.aHE.getCurrentFrame().aWN == null) ? this.aHQ : this.aHE.getCurrentFrame().aWN;
                    } else {
                        imageBitmap = this.aHE.getImageBitmap() == null ? this.aHQ : this.aHE.getImageBitmap();
                    }
                    height = imageBitmap.getHeight();
                    width = imageBitmap.getWidth();
                }
                float ak = l.ak(getContext());
                int i2 = (int) (height * ak);
                int i3 = (int) (width * ak);
                if (i3 > this.aHQ.getWidth() && this.aHQ.getWidth() != 0) {
                    float width2 = (i3 * 1.0f) / this.aHQ.getWidth();
                    i3 = this.aHQ.getWidth();
                    i2 = (int) (i2 / width2);
                }
                if (i2 > this.aHQ.getHeight() && this.aHQ.getHeight() != 0) {
                    i3 = (int) (i3 / ((i2 * 1.0f) / this.aHQ.getHeight()));
                    i2 = this.aHQ.getHeight();
                }
                int aj = (l.aj(getContext()) - i2) / 2;
                int ah = (l.ah(getContext()) - i3) / 2;
                this.aHX = new Rect(ah, aj, i3 + ah, i2 + aj);
                this.aHW = new Rect(0, 0, this.aHQ.getWidth(), this.aHQ.getHeight());
            }
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (i == 2) {
            this.aHO = l(this.mLastMotionX - x, this.mLastMotionY - y);
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (this.aHO || this.aHP) {
            this.aHE.setImageOnLongClickListener(null);
            this.aHI.setOnLongClickListener(null);
            z = true;
        } else {
            this.aHE.setImageOnLongClickListener(this.aIl);
            this.aHI.setOnLongClickListener(this.aIl);
            z = super.dispatchTouchEvent(motionEvent);
        }
        if (i == 1 || i == 3) {
            this.mLastMotionX = 0.0f;
            this.mLastMotionY = 0.0f;
            this.aHR = false;
            this.aHT.reset();
            this.aHO = false;
            if (this.aHS > aHZ) {
                this.aHP = true;
                FG();
                return z;
            }
            this.mRatio = 1.0f;
            invalidate();
            return z;
        }
        return z;
    }

    private boolean l(float f, float f2) {
        if (this.aHI.getVisibility() != 0 || this.aHI.isCanDrag()) {
            if (this.aIb == null || !this.aIb.isLongPic || this.aHI.getVisibility() != 0 || this.aHI.isViewTop()) {
                if (this.aIb == null || !this.aIb.isLongPic || this.aHI.getVisibility() == 0 || this.aHE.Lr()) {
                    if (this.aHI.getVisibility() == 0 || this.aHE.Lt()) {
                        if (this.aHQ != null && getScrollY() == 0 && f2 < 0.0f && !this.aHR) {
                            this.aHR = true;
                            this.aHS = 0.0f;
                            this.mRatio = 1.0f;
                            if (this.aHY != null) {
                                this.aHY.LJ();
                            }
                        }
                        if (this.aHR) {
                            this.aHS -= f2;
                            int measuredHeight = getMeasuredHeight();
                            if (this.aHS > measuredHeight) {
                                this.aHS = measuredHeight;
                            }
                            float f3 = f2 / measuredHeight;
                            this.aHT.postTranslate((-f) * 1.5f * this.mRatio, (-1.5f) * f2 * this.mRatio);
                            if (this.mRatio * (1.0f + f3) > 1.0f || this.aHS < 0.0f) {
                                this.aHT.preScale(1.0f / this.mRatio, 1.0f / this.mRatio, (this.mRatio * this.aHQ.getWidth()) / 2.0f, this.mRatio * (this.aHQ.getHeight() / 2));
                                this.mRatio = 1.0f;
                            } else {
                                this.aHT.preScale(1.0f + f3, 1.0f + f3, (this.mRatio * this.aHQ.getWidth()) / 2.0f, this.mRatio * (this.aHQ.getHeight() / 2));
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
        if (this.aHO && this.aHQ != null && !this.aHQ.isRecycled() && this.aHR) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.aHV == null) {
                this.aHV = new RectF();
            }
            this.aHT.mapRect(this.aHV, new RectF(this.aHU));
            canvas.drawBitmap(this.aHQ, this.aHW, this.aHV, (Paint) null);
        } else if (this.aHP && this.aHQ != null && !this.aHQ.isRecycled()) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.aIb == null || this.aIb.getSourceImageRectInScreen() == null) {
                canvas.drawBitmap(this.aHQ, this.aHW, this.aHV, (Paint) null);
            } else {
                canvas.drawBitmap(this.aHQ, this.aHX, this.aHV, (Paint) null);
            }
        } else {
            super.dispatchDraw(canvas);
        }
    }

    private void FG() {
        if (this.aIb == null) {
            if (this.aHY != null) {
                this.aHY.LK();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.aIb.getSourceImageRectInScreen();
        if (sourceImageRectInScreen == null) {
            if (this.aHY != null) {
                this.aHY.LK();
                return;
            }
            return;
        }
        this.aHV.bottom = (((sourceImageRectInScreen.bottom - sourceImageRectInScreen.top) / (sourceImageRectInScreen.right - sourceImageRectInScreen.left)) * (this.aHV.right - this.aHV.left)) + this.aHV.top;
        final float[] fArr = {(this.aHV.left + this.aHV.right) / 2.0f, (this.aHV.top + this.aHV.bottom) / 2.0f};
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
                    UrlDragImageView.this.aHV = UrlDragImageView.this.g(floatValue, animatedFraction, sourceImageRectInScreen.right - sourceImageRectInScreen.left, sourceImageRectInScreen.bottom - sourceImageRectInScreen.top);
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
                UrlDragImageView.this.aHR = false;
                UrlDragImageView.this.invalidate();
                if (UrlDragImageView.this.aHY != null) {
                    UrlDragImageView.this.aHY.LK();
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
        this.aIi = onTouchListener;
    }

    private void FH() {
        this.aIg = new TextView(this.mContext);
        this.aIg.setBackgroundResource(d.f.bg_url_drag_imagview_fade_view);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.height = getResources().getDimensionPixelSize(d.e.ds180);
        layoutParams.addRule(12);
        addView(this.aIg, layoutParams);
        this.aIg.setVisibility(8);
    }

    private void FI() {
        this.aHG = new TextView(this.mContext);
        al.j(this.aHG, d.C0141d.common_color_10022);
        this.aHG.setText(d.k.goto_pb_floor);
        this.aHG.setTextSize(0, getResources().getDimensionPixelSize(d.e.fontsize28));
        al.b(this.aHG, d.C0141d.cp_cont_i, 1, 0);
        this.aHG.setCompoundDrawablePadding(l.dip2px(this.mContext, 4.0f));
        this.aHG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(d.f.icon_see_arrow), (Drawable) null);
        this.aHG.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds20);
        this.aHG.setPadding(dimensionPixelSize * 3, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(d.e.ds30);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(d.e.ds10);
        layoutParams.leftMargin = getResources().getDimensionPixelSize(d.e.ds20);
        layoutParams.addRule(1, this.aHF.getId());
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        this.aHG.setOnClickListener(this);
        this.aHG.setMinHeight(getResources().getDimensionPixelSize(d.e.ds100));
        addView(this.aHG, layoutParams);
        this.aHG.setVisibility(8);
    }

    private void FJ() {
        if (this.aHG != null) {
            boolean z = this.aHL || this.aHM;
            if (!this.aIe && z && this.aIb != null && this.aIb.threadId > 0 && this.aIb.postId > 0 && this.aIb.mThreadType != 33 && !this.aIb.isBlockedPic) {
                this.aHG.setVisibility(0);
                if (this.aIg != null) {
                    this.aIg.setVisibility(0);
                    return;
                }
                return;
            }
            this.aHG.setVisibility(8);
            if (this.aIg != null) {
                this.aIg.setVisibility(8);
            }
        }
    }

    private void FK() {
        if (this.aHG != null) {
            this.aHG.setVisibility(8);
            if (this.aIg != null) {
                this.aIg.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FL() {
        if ((this.aHL || this.aHM) && this.aIb != null && this.aIb.mPicType == 1 && !TextUtils.isEmpty(this.aIb.mTagName)) {
            if (this.aHH != null) {
                this.aHH.setVisibility(8);
                this.aHH = null;
            }
            this.aHH = new TextView(this.mContext);
            this.aHH.setText(this.aIb.mTagName);
            this.aHH.setTextSize(0, getResources().getDimensionPixelSize(d.e.fontsize26));
            al.b(this.aHH, d.C0141d.common_color_10013, 1, 0);
            al.j(this.aHH, d.C0141d.common_color_10215);
            this.aHH.setAlpha(0.75f);
            this.aHH.setIncludeFontPadding(false);
            this.aHH.setGravity(17);
            int e = l.e(this.mContext, d.e.ds2);
            this.aHH.setPadding(e, e, e, e);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.aHE.getBottomOffset();
            layoutParams.leftMargin = this.aHE.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.aHH, layoutParams);
            this.aHH.setVisibility(0);
        }
    }

    public void bq(boolean z) {
        this.aIe = z;
        if (this.aIe) {
            FK();
        } else {
            FJ();
        }
    }

    public void setUrl(String str, boolean z) {
        if (str.contains("*")) {
            str = str.split("[*]")[0];
        }
        this.aHE.setTag(str);
        this.aHE.setLoadBigImage(false);
        this.aHE.setImageDrawable(null);
        this.aHL = false;
        this.aHM = false;
        this.aIc = FS();
        this.aHF.setVisibility(8);
        if (gc(str)) {
            b(str, z, false);
        }
    }

    private boolean FM() {
        return this.aHE != null && this.aHE.LH();
    }

    public void FN() {
        if (this.aIb != null && !FM()) {
            String str = this.aIb.imageUrl;
            int i = this.aIb.urlType;
            com.baidu.adp.widget.ImageView.a aVar = null;
            if (com.baidu.tbadk.core.util.d.a.v(str, i)) {
                aVar = com.baidu.tbadk.core.util.d.a.w(str, i);
            }
            if (aVar != null) {
                setThumbBitmapToView(aVar);
            }
        }
    }

    private boolean br(boolean z) {
        String eL;
        if (!this.aId || z) {
            this.aId = true;
            if (!this.aIc || this.aIb == null || StringUtils.isNull(this.aIb.originalUrl, true) || this.aIb.originalSize < 0 || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String str = this.aIa + an.zk().eE(eL) + "/" + ar.eL(this.aIb.originalUrl);
            final int[] eg = com.baidu.tbadk.core.util.l.eg(str);
            this.aHI.setVisibility(0);
            if (this.aHJ == null) {
                this.aHJ = new SubsamplingScaleImageView.OnImageEventListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12
                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onReady() {
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.aHE.LD();
                        UrlDragImageView.this.aHE.setVisibility(4);
                    }

                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onImageLoaded() {
                        if (UrlDragImageView.this.aIb.isLongPic && eg[0] > 0) {
                            UrlDragImageView.this.aHE.onDestroy();
                            final float measuredWidth = (UrlDragImageView.this.getMeasuredWidth() * 1.0f) / eg[0];
                            final PointF pointF = new PointF((eg[0] * 1.0f) / 2.0f, 0.0f);
                            UrlDragImageView.this.aHI.setScaleAndCenter(measuredWidth, pointF);
                            UrlDragImageView.this.aHI.setMaxScale(2.0f * measuredWidth);
                            UrlDragImageView.this.aHI.setDoubleTapZoomScale(2.0f * measuredWidth);
                            UrlDragImageView.this.aHI.setInitScale(measuredWidth);
                            UrlDragImageView.this.aHI.setDoubleTapZoomStyle(4);
                            UrlDragImageView.this.aHI.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12.1
                                @Override // android.view.View.OnTouchListener
                                public boolean onTouch(View view, MotionEvent motionEvent) {
                                    if (UrlDragImageView.this.aIi != null) {
                                        UrlDragImageView.this.aIi.onTouch(view, motionEvent);
                                    }
                                    switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                                        case 0:
                                            UrlDragImageView.this.aIk = motionEvent.getY();
                                            UrlDragImageView.this.aHI.setOnClickListener(UrlDragImageView.this.aIj ? UrlDragImageView.this.mOnClickListener : null);
                                            UrlDragImageView.this.aHI.setOnLongClickListener(UrlDragImageView.this.aIj ? UrlDragImageView.this.aIl : null);
                                            break;
                                        case 1:
                                        case 3:
                                            if (UrlDragImageView.this.aHI.getScale() < measuredWidth) {
                                                UrlDragImageView.this.aHI.setScaleAndCenter(measuredWidth, pointF);
                                            }
                                            e.im().removeCallbacks(UrlDragImageView.this.aIm);
                                            e.im().postDelayed(UrlDragImageView.this.aIm, 1000L);
                                            break;
                                        case 2:
                                            if (Math.abs(motionEvent.getY() - UrlDragImageView.this.aIk) > UrlDragImageView.TOUCH_SLOP) {
                                                UrlDragImageView.this.aIj = false;
                                                UrlDragImageView.this.aHI.setOnClickListener(null);
                                                UrlDragImageView.this.aHI.setOnLongClickListener(null);
                                            }
                                            UrlDragImageView.this.aIk = motionEvent.getY();
                                            break;
                                    }
                                    return false;
                                }
                            });
                            UrlDragImageView.this.aHE.setVisibility(4);
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
            this.aHI.setOnImageEventListener(this.aHJ);
            if (this.aHI.isImageLoaded() && this.aIb.isLongPic) {
                this.aHJ.onImageLoaded();
            } else {
                this.aHI.setImage(ImageSource.uri(str));
            }
            return true;
        }
        return false;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.aHY = dVar;
        if (this.aHE != null) {
            this.aHE.setDragToExitListener(dVar);
        }
    }

    public void FO() {
        br(false);
    }

    private boolean gc(String str) {
        return j.jD() || c.fc(str);
    }

    private void setThumbBitmapToView(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap mZ;
        if (!this.aHM && aVar != null && (mZ = aVar.mZ()) != null) {
            this.aHL = true;
            if (aVar.isGif()) {
                this.aHE.setImageUrlData(this.aIb);
                this.aHE.setImageBitmap(mZ);
                this.aHF.setVisibility(8);
                this.aIf = false;
            } else {
                if (this.aIb != null && this.aIb.isLongPic) {
                    this.aHE.Lw();
                    this.aHE.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.13
                        @Override // com.baidu.tbadk.widget.largeImage.logic.a
                        public void FW() {
                        }
                    });
                }
                this.aHE.setImageUrlData(this.aIb);
                this.aHE.setImageData(mZ, aVar.ne());
            }
            FJ();
            FL();
        }
    }

    private void b(String str, boolean z, boolean z2) {
        if (gd(str)) {
            if (z2 || (!this.aHN && !this.aHM)) {
                if (!z2 || !br(true)) {
                    this.aHN = true;
                    com.baidu.adp.lib.f.c.ig().a(str, 27, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.14
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onCancelled(String str2) {
                            UrlDragImageView.this.aHN = false;
                            UrlDragImageView.this.aHE.setVisibility(0);
                            UrlDragImageView.this.mProgressBar.setVisibility(8);
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            UrlDragImageView.this.aHN = false;
                            UrlDragImageView.this.aHM = true;
                            UrlDragImageView.this.b(aVar);
                        }
                    }, 0, 0, false, null, Boolean.valueOf(z), this.aHE.getImageData(), Boolean.valueOf(this.aGD));
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
        com.baidu.adp.widget.ImageView.a a2 = this.aIh.a(imageFileInfo, false);
        if (a2 != null) {
            this.aHM = true;
            this.mProgressBar.setVisibility(8);
            b(a2);
            return;
        }
        this.aIh.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.2
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.ImageView.a aVar, String str2, boolean z3) {
                UrlDragImageView.this.aHM = true;
                UrlDragImageView.this.mProgressBar.setVisibility(8);
                UrlDragImageView.this.b(aVar);
            }
        }, false);
    }

    private boolean gd(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith("https://"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null && this.aHK != null) {
            this.aHK.j(aVar.getUrl(), aVar.ne());
        }
        if (aVar == null || aVar.mZ() == null) {
            FP();
            return;
        }
        Bitmap mZ = aVar.mZ();
        this.aHE.setLoadBigImage(true);
        if (aVar.isGif()) {
            this.aHE.setGifData(aVar.ne(), mZ);
            this.aHE.invalidate();
            this.aHE.play();
            this.aIf = false;
            this.aHF.setVisibility(8);
            this.mProgressBar.setVisibility(8);
        } else {
            if (this.aIb != null && this.aIb.isLongPic) {
                this.aHE.Lw();
                this.aHE.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.3
                    @Override // com.baidu.tbadk.widget.largeImage.logic.a
                    public void FW() {
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                    }
                });
            } else {
                this.mProgressBar.setVisibility(8);
            }
            this.aHE.setImageUrlData(this.aIb);
            this.aHE.setImageData(mZ, aVar.ne());
            FT();
        }
        FJ();
        FL();
    }

    private void FP() {
        if (!this.aHL) {
            this.aHE.setDefaultBitmap();
        } else {
            this.aHM = false;
        }
        this.aHF.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    public void setGifMaxUseableMem(int i) {
        this.aHE.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.aHE != null) {
            this.aHE.onDestroy();
        }
        if (this.aHI != null) {
            this.aHI.recycle();
        }
        if (this.aHQ != null) {
            this.aHQ.recycle();
            this.aHQ = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        e.im().removeCallbacks(this.aIm);
    }

    public void release() {
        if (this.aHE != null) {
            this.aHE.release();
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.aHF != null) {
            this.aHF.setVisibility(8);
        }
    }

    public void FQ() {
        if (this.aHE != null && this.aHE.getImageType() == 1) {
            this.aHE.stop();
        }
    }

    public void i(boolean z, boolean z2) {
        String str;
        if (this.aHE != null && (str = (String) this.aHE.getTag()) != null) {
            if (this.aHE.getImageType() == 1) {
                if (this.aHE.getGifCache() == null || !this.aHE.LH()) {
                    b(str, z, z2);
                }
            } else if (this.aHE.getImageType() == 2) {
                b(str, z, z2);
            } else if (FR()) {
                b(str, z, z2);
            }
        }
    }

    private boolean FR() {
        if (this.aHE.getImageBitmap() != null && this.aHE.LH()) {
            if (this.aIb == null || !this.aIb.isLongPic || this.aHE.Lx()) {
                return false;
            }
            this.aHM = false;
            this.aId = false;
            return true;
        }
        return true;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.aIb = imageUrlData;
    }

    public void setIsCdn(boolean z) {
        this.aGD = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aHF) {
            if (!(this.aHF.getTag() instanceof Boolean) || ((Boolean) this.aHF.getTag()).booleanValue()) {
                final String eL = ar.eL(this.aIb.originalUrl);
                if (this.aIb.originalProcess >= 0) {
                    com.baidu.tbadk.download.e.GZ().z(eL, 13);
                    this.aIb.originalProcess = -1;
                    FT();
                    return;
                }
                if (this.aGF != null) {
                    this.aGF.FX();
                }
                com.baidu.adp.base.e<?> ad = i.ad(this.mContext);
                if (ad == null) {
                    ge(eL);
                } else if (!j.jD() || j.jE() || com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("original_img_down_tip", false)) {
                    ge(eL);
                } else {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("original_img_down_tip", true);
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(ad.getPageActivity());
                    aVar.cc(d.k.original_img_down_no_wifi_tip);
                    aVar.a(d.k.alert_yes_button, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.4
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar.dismiss();
                            UrlDragImageView.this.ge(eL);
                        }
                    });
                    aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.5
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar.dismiss();
                        }
                    });
                    aVar.b(ad);
                    aVar.xa();
                }
            }
        } else if (view == this.aHG && this.aIb != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.mContext).createHistoryCfg(String.valueOf(this.aIb.threadId), String.valueOf(this.aIb.postId), this.aIb.mIsSeeHost, this.aIb.mIsReserver, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ge(String str) {
        if (this.aIb != null) {
            this.aIb.originalProcess = 0;
        }
        this.aHF.setText("0%");
        this.aHF.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_close_yuantu, 0);
        DownloadData downloadData = new DownloadData(str);
        downloadData.setStatus(1);
        downloadData.setUrl(this.aIb.originalUrl);
        downloadData.setType(13);
        downloadData.setPath(this.aIa + an.zk().eE(str) + "/" + str);
        downloadData.setCallback(new com.baidu.tbadk.download.d() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.6
            @Override // com.baidu.tbadk.download.d
            public boolean onPreDownload(DownloadData downloadData2) {
                return true;
            }

            @Override // com.baidu.tbadk.download.d
            public void onFileUpdateProgress(DownloadData downloadData2) {
                if (downloadData2 != null) {
                    if (UrlDragImageView.this.aIb != null && UrlDragImageView.this.aIb.originalProcess != -1) {
                        UrlDragImageView.this.aIb.originalProcess = downloadData2.getProcess();
                    }
                    if (UrlDragImageView.this.aIb == null || UrlDragImageView.this.aIb.originalProcess != -1) {
                        UrlDragImageView.this.aHF.setText(downloadData2.getProcess() + "%");
                        UrlDragImageView.this.aHF.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_close_yuantu, 0);
                    }
                }
            }

            @Override // com.baidu.tbadk.download.d
            public boolean onFileDownloaded(DownloadData downloadData2) {
                return true;
            }

            @Override // com.baidu.tbadk.download.d
            public void onFileDownloadSucceed(DownloadData downloadData2) {
                UrlDragImageView.this.aHF.setText(UrlDragImageView.this.getResources().getString(d.k.done));
                UrlDragImageView.this.aHF.setTag(false);
                UrlDragImageView.this.aHF.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                e.im().postDelayed(UrlDragImageView.this.aIn, 1500L);
                UrlDragImageView.this.aId = false;
                UrlDragImageView.this.aIc = UrlDragImageView.this.FS();
                UrlDragImageView.this.FO();
            }

            @Override // com.baidu.tbadk.download.d
            public void onFileDownloadFailed(DownloadData downloadData2, int i, String str2) {
                UrlDragImageView.this.aId = false;
                BdToast.a(UrlDragImageView.this.mContext, str2).xg().xi();
                UrlDragImageView.this.aIb.originalProcess = -1;
                UrlDragImageView.this.FT();
            }
        });
        com.baidu.tbadk.download.e.GZ().a(downloadData, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean FS() {
        if (this.aIb != null && !StringUtils.isNull(this.aIb.originalUrl, true) && this.aIb.originalSize >= 0 && !this.aIb.isBlockedPic) {
            String eL = ar.eL(this.aIb.originalUrl);
            File file = new File(this.aIa + an.zk().eE(eL) + "/" + eL);
            if (file != null && file.exists()) {
                this.aIb.originalProcess = 100;
                return true;
            }
            if (this.aIb.originalProcess < 0) {
                FT();
            } else {
                this.aHF.setText(this.aIb.originalProcess + "%");
                this.aHF.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_close_yuantu, 0);
            }
            this.aIf = true;
        } else {
            this.aHF.setVisibility(8);
        }
        return false;
    }

    public void FT() {
        if (this.aIb != null) {
            if (!FU() || !this.aIf) {
                this.aHF.setVisibility(8);
            } else {
                this.aHF.setVisibility(0);
            }
            if (this.aIb.originalSize > 0 && !U(this.aIb.originalSize)) {
                this.aHF.setText(aHC + "(" + ao.J(this.aIb.originalSize) + ")");
            } else {
                this.aHF.setText(aHC);
            }
            this.aHF.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    private boolean FU() {
        return (this.aIb == null || !this.aIb.mIsShowOrigonButton || this.aIb.isBlockedPic || StringUtils.isNull(this.aIb.originalUrl)) ? false : true;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.aGF = bVar;
    }

    private boolean U(long j) {
        return j > aHD;
    }
}
