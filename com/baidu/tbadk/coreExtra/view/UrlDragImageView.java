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
/* loaded from: classes2.dex */
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
    private RectF aIT;
    private Rect aIU;
    private Rect aIV;
    private Rect aIW;
    private DragImageView.d aIX;
    private String aIZ;
    private float aJa;
    private float aJb;
    private float aJc;
    private float aJd;
    private float aJe;
    private ImageUrlData aJf;
    private boolean aJg;
    private boolean aJh;
    private boolean aJi;
    public boolean aJj;
    private TextView aJk;
    private com.baidu.tbadk.img.b aJl;
    private View.OnTouchListener aJm;
    private boolean aJn;
    private float aJo;
    private View.OnLongClickListener aJp;
    private Runnable aJq;
    private Runnable aJr;
    private View.OnTouchListener aJs;
    protected Context mContext;
    private float mLastMotionX;
    private float mLastMotionY;
    private int mMaxHeight;
    private int mMaxWidth;
    private View.OnClickListener mOnClickListener;
    protected ProgressBar mProgressBar;
    private float mRatio;
    private int mSkinType;
    private static final String aIz = TbadkCoreApplication.getInst().getString(d.j.original_img_look);
    private static long aIA = 52428800;
    private static final int aIY = l.aj(TbadkCoreApplication.getInst()) / 5;
    private static final String TAG = UrlDragImageView.class.getSimpleName();
    private static final int TOUCH_SLOP = ViewConfiguration.get(TbadkCoreApplication.getInst()).getScaledTouchSlop();

    /* loaded from: classes2.dex */
    public interface a {
        void j(String str, byte[] bArr);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void Gl();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.aIC != null) {
                am.i(this.aIC, d.f.btn_percent_yuantu);
                am.b(this.aIC, d.C0140d.cp_cont_g, 1, 0);
            }
            if (this.aID != null) {
                am.j(this.aID, d.C0140d.common_color_10022);
                am.b(this.aID, d.C0140d.cp_cont_g, 1, 0);
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
        this.aJa = 0.0f;
        this.aJb = 0.0f;
        this.aJc = 1.0f;
        this.aJd = 1.0f;
        this.aJe = 0.0f;
        this.aJg = false;
        this.aJh = false;
        this.aJi = false;
        this.aJj = false;
        this.aJk = null;
        this.aJn = true;
        this.aJo = 0.0f;
        this.mOnClickListener = null;
        this.aJp = null;
        this.aJq = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.aJn = true;
            }
        };
        this.aJr = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.aJj = false;
                    }
                });
                UrlDragImageView.this.aIC.startAnimation(alphaAnimation);
            }
        };
        this.aJs = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.aJm != null) {
                    UrlDragImageView.this.aJm.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.aJl = new com.baidu.tbadk.img.b();
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
        this.aJa = 0.0f;
        this.aJb = 0.0f;
        this.aJc = 1.0f;
        this.aJd = 1.0f;
        this.aJe = 0.0f;
        this.aJg = false;
        this.aJh = false;
        this.aJi = false;
        this.aJj = false;
        this.aJk = null;
        this.aJn = true;
        this.aJo = 0.0f;
        this.mOnClickListener = null;
        this.aJp = null;
        this.aJq = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.aJn = true;
            }
        };
        this.aJr = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.aJj = false;
                    }
                });
                UrlDragImageView.this.aIC.startAnimation(alphaAnimation);
            }
        };
        this.aJs = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.aJm != null) {
                    UrlDragImageView.this.aJm.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.aJl = new com.baidu.tbadk.img.b();
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
        this.aJp = onLongClickListener;
        if (!this.aHy) {
            this.aIB.setImageOnLongClickListener(this.aJp);
            this.aIF.setOnLongClickListener(this.aJp);
        }
    }

    public void setOnSizeChangedListener(final DragImageView.g gVar) {
        this.aIB.setOnSizeChangedListener(new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.8
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (gVar != null) {
                    gVar.a(dragImageView, z, z2);
                }
                UrlDragImageView.this.FZ();
            }
        });
    }

    protected void init() {
        this.mMaxWidth = l.ah(this.mContext);
        this.mMaxHeight = l.aj(this.mContext) - ((int) this.mContext.getResources().getDimension(d.e.ds166));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.aIB = new DragImageView(this.mContext);
        this.aIB.setLayoutParams(layoutParams);
        this.aIB.setOnTouchListener(this.aJs);
        addView(this.aIB);
        this.aIF = new SubsamplingScaleImageView(this.mContext);
        this.aIF.setMaxScale(50.0f);
        this.aIF.setOnTouchListener(this.aJs);
        this.aIF.setVisibility(4);
        addView(this.aIF, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(getResources().getDrawable(d.f.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        FV();
        FT();
        FW();
    }

    private void FT() {
        this.aIZ = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        this.aIC = new TextView(this.mContext);
        am.i(this.aIC, d.f.btn_percent_yuantu);
        this.aIC.setText(d.j.original_img_look);
        this.aIC.setTextSize(0, getResources().getDimensionPixelSize(d.e.fontsize28));
        am.b(this.aIC, d.C0140d.cp_cont_i, 1, 0);
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
            if (this.aIV == null && this.aIN != null) {
                if (this.aIF.getVisibility() == 0) {
                    height = this.aIF.getSHeight();
                    width = this.aIF.getSWidth();
                } else {
                    if (this.aIB.getImageType() == 1) {
                        imageBitmap = (this.aIB.getCurrentFrame() == null || this.aIB.getCurrentFrame().aXO == null) ? this.aIN : this.aIB.getCurrentFrame().aXO;
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
                this.aIV = new Rect(ah, aj, i3 + ah, i2 + aj);
                this.aIW = new Rect(this.aIV);
                this.aJe = aj / l.aj(getContext());
                this.aIU = new Rect(0, 0, this.aIN.getWidth(), this.aIN.getHeight());
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
            this.aIB.setImageOnLongClickListener(this.aJp);
            this.aIF.setOnLongClickListener(this.aJp);
            z = super.dispatchTouchEvent(motionEvent);
        }
        if (i == 1 || i == 3) {
            this.mLastMotionX = 0.0f;
            this.mLastMotionY = 0.0f;
            this.aIO = false;
            this.aIQ.reset();
            this.aIL = false;
            if (this.aIP > aIY) {
                this.aIM = true;
                FU();
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
            if (this.aJf == null || !this.aJf.isLongPic || this.aIF.getVisibility() != 0 || this.aIF.isViewTop()) {
                if (this.aJf == null || !this.aJf.isLongPic || this.aIF.getVisibility() == 0 || this.aIB.LF()) {
                    if (this.aIF.getVisibility() == 0 || this.aIB.LH()) {
                        if (this.aIN != null && getScrollY() == 0 && f2 < 0.0f && !this.aIO) {
                            this.aIO = true;
                            this.aIP = 0.0f;
                            this.mRatio = 1.0f;
                            if (this.aIX != null) {
                                this.aIX.LX();
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
            canvas.drawBitmap(this.aIN, this.aIU, this.aIS, (Paint) null);
        } else if (this.aIM && this.aIN != null && !this.aIN.isRecycled()) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.aJf == null || this.aJf.getSourceImageRectInScreen() == null) {
                canvas.drawBitmap(this.aIN, this.aIU, this.aIS, (Paint) null);
            } else {
                canvas.drawBitmap(this.aIN, this.aIV, this.aIS, (Paint) null);
            }
        } else {
            super.dispatchDraw(canvas);
        }
    }

    private void FU() {
        if (this.aJf == null) {
            if (this.aIX != null) {
                this.aIX.LY();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.aJf.getSourceImageRectInScreen();
        final Rect dstRectInScreen = this.aJf.getDstRectInScreen();
        if (sourceImageRectInScreen == null || dstRectInScreen == null) {
            if (this.aIX != null) {
                this.aIX.LY();
                return;
            }
            return;
        }
        a(sourceImageRectInScreen, dstRectInScreen);
        e(sourceImageRectInScreen);
        this.aIT = new RectF(this.aIS);
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
                UrlDragImageView.this.aIO = false;
                UrlDragImageView.this.invalidate();
                if (UrlDragImageView.this.aIX != null) {
                    UrlDragImageView.this.aIX.LY();
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
            float f = ((rect.bottom - rect.top) / (rect.right - rect.left)) * (this.aIS.right - this.aIS.left);
            this.aIS.top += this.aIS.height() * this.aJe;
            this.aIS.bottom = f + this.aIS.top;
        }
    }

    private void a(Rect rect, Rect rect2) {
        this.aJa = 0.0f;
        this.aJb = 0.0f;
        this.aJc = 1.0f;
        this.aJd = 1.0f;
        if (rect != null && rect2 != null && rect.contains(rect2)) {
            this.aJa = (rect2.left - rect.left) / rect.width();
            this.aJb = (rect2.top - rect.top) / rect.height();
            this.aJc = (rect2.right - rect.left) / rect.width();
            this.aJd = (rect2.bottom - rect.top) / rect.height();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(float f) {
        if (this.aIV != null) {
            this.aIV.left = (int) (this.aIW.left + (this.aIW.width() * this.aJa * f));
            this.aIV.top = (int) (this.aIW.top + (this.aIW.height() * this.aJb * f));
            this.aIV.right = (int) (this.aIW.left + (this.aIW.width() * (((1.0f - this.aJc) * (1.0f - f)) + this.aJc)));
            this.aIV.bottom = (int) (this.aIW.top + (this.aIW.height() * (((1.0f - this.aJd) * (1.0f - f)) + this.aJd)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Rect rect, float f) {
        if (this.aIS != null && rect != null) {
            this.aIS.left = this.aIT.left + ((rect.left - this.aIT.left) * f);
            this.aIS.top = this.aIT.top + ((rect.top - this.aIT.top) * f);
            this.aIS.right = this.aIT.right + ((rect.right - this.aIT.right) * f);
            this.aIS.bottom = this.aIT.bottom + ((rect.bottom - this.aIT.bottom) * f);
        }
    }

    private RectF g(float f, float f2, float f3, float f4) {
        return new RectF(f - (f3 / 2.0f), f2 - (f4 / 2.0f), (f3 / 2.0f) + f, (f4 / 2.0f) + f2);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.aJm = onTouchListener;
    }

    private void FV() {
        this.aJk = new TextView(this.mContext);
        this.aJk.setBackgroundResource(d.f.bg_url_drag_imagview_fade_view);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.height = getResources().getDimensionPixelSize(d.e.ds180);
        layoutParams.addRule(12);
        addView(this.aJk, layoutParams);
        this.aJk.setVisibility(8);
    }

    private void FW() {
        this.aID = new TextView(this.mContext);
        am.j(this.aID, d.C0140d.common_color_10022);
        this.aID.setText(d.j.goto_pb_floor);
        this.aID.setTextSize(0, getResources().getDimensionPixelSize(d.e.fontsize28));
        am.b(this.aID, d.C0140d.cp_cont_i, 1, 0);
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

    private void FX() {
        if (this.aID != null) {
            boolean z = this.aII || this.aIJ;
            if (!this.aJi && z && this.aJf != null && this.aJf.threadId > 0 && this.aJf.postId > 0 && this.aJf.mThreadType != 33 && !this.aJf.isBlockedPic) {
                this.aID.setVisibility(0);
                if (this.aJk != null) {
                    this.aJk.setVisibility(0);
                    return;
                }
                return;
            }
            this.aID.setVisibility(8);
            if (this.aJk != null) {
                this.aJk.setVisibility(8);
            }
        }
    }

    private void FY() {
        if (this.aID != null) {
            this.aID.setVisibility(8);
            if (this.aJk != null) {
                this.aJk.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FZ() {
        if ((this.aII || this.aIJ) && this.aJf != null && this.aJf.mPicType == 1 && !TextUtils.isEmpty(this.aJf.mTagName)) {
            if (this.aIE != null) {
                this.aIE.setVisibility(8);
                this.aIE = null;
            }
            this.aIE = new TextView(this.mContext);
            this.aIE.setText(this.aJf.mTagName);
            this.aIE.setTextSize(0, getResources().getDimensionPixelSize(d.e.fontsize26));
            am.b(this.aIE, d.C0140d.common_color_10013, 1, 0);
            am.j(this.aIE, d.C0140d.common_color_10215);
            this.aIE.setAlpha(0.75f);
            this.aIE.setIncludeFontPadding(false);
            this.aIE.setGravity(17);
            int f = l.f(this.mContext, d.e.ds2);
            this.aIE.setPadding(f, f, f, f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.aIB.getBottomOffset();
            layoutParams.leftMargin = this.aIB.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.aIE, layoutParams);
            this.aIE.setVisibility(0);
        }
    }

    public void br(boolean z) {
        this.aJi = z;
        if (this.aJi) {
            FY();
        } else {
            FX();
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
        this.aJg = Gg();
        this.aIC.setVisibility(8);
        if (ge(str)) {
            b(str, z, false);
        }
    }

    private boolean Ga() {
        return this.aIB != null && this.aIB.LV();
    }

    public void Gb() {
        if (this.aJf != null && !Ga()) {
            String str = this.aJf.imageUrl;
            int i = this.aJf.urlType;
            com.baidu.adp.widget.ImageView.a aVar = null;
            if (com.baidu.tbadk.core.util.d.a.v(str, i)) {
                aVar = com.baidu.tbadk.core.util.d.a.w(str, i);
            }
            if (aVar != null) {
                setThumbBitmapToView(aVar);
            }
        }
    }

    private boolean bs(boolean z) {
        String eM;
        if (!this.aJh || z) {
            this.aJh = true;
            if (!this.aJg || this.aJf == null || StringUtils.isNull(this.aJf.originalUrl, true) || this.aJf.originalSize < 0 || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String str = this.aIZ + ao.zq().eF(eM) + "/" + as.eM(this.aJf.originalUrl);
            final int[] eh = com.baidu.tbadk.core.util.l.eh(str);
            this.aIF.setVisibility(0);
            if (this.aIG == null) {
                this.aIG = new SubsamplingScaleImageView.OnImageEventListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12
                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onReady() {
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.aIB.LR();
                        UrlDragImageView.this.aIB.setVisibility(4);
                    }

                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onImageLoaded() {
                        if (UrlDragImageView.this.aJf.isLongPic && eh[0] > 0) {
                            UrlDragImageView.this.aIB.onDestroy();
                            final float measuredWidth = (UrlDragImageView.this.getMeasuredWidth() * 1.0f) / eh[0];
                            final PointF pointF = new PointF((eh[0] * 1.0f) / 2.0f, 0.0f);
                            UrlDragImageView.this.aIF.setScaleAndCenter(measuredWidth, pointF);
                            UrlDragImageView.this.aIF.setMaxScale(2.0f * measuredWidth);
                            UrlDragImageView.this.aIF.setDoubleTapZoomScale(2.0f * measuredWidth);
                            UrlDragImageView.this.aIF.setInitScale(measuredWidth);
                            UrlDragImageView.this.aIF.setDoubleTapZoomStyle(4);
                            UrlDragImageView.this.aIF.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12.1
                                @Override // android.view.View.OnTouchListener
                                public boolean onTouch(View view, MotionEvent motionEvent) {
                                    if (UrlDragImageView.this.aJm != null) {
                                        UrlDragImageView.this.aJm.onTouch(view, motionEvent);
                                    }
                                    switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                                        case 0:
                                            UrlDragImageView.this.aJo = motionEvent.getY();
                                            UrlDragImageView.this.aIF.setOnClickListener(UrlDragImageView.this.aJn ? UrlDragImageView.this.mOnClickListener : null);
                                            UrlDragImageView.this.aIF.setOnLongClickListener(UrlDragImageView.this.aJn ? UrlDragImageView.this.aJp : null);
                                            break;
                                        case 1:
                                        case 3:
                                            if (UrlDragImageView.this.aIF.getScale() < measuredWidth) {
                                                UrlDragImageView.this.aIF.setScaleAndCenter(measuredWidth, pointF);
                                            }
                                            e.in().removeCallbacks(UrlDragImageView.this.aJq);
                                            e.in().postDelayed(UrlDragImageView.this.aJq, 1000L);
                                            break;
                                        case 2:
                                            if (Math.abs(motionEvent.getY() - UrlDragImageView.this.aJo) > UrlDragImageView.TOUCH_SLOP) {
                                                UrlDragImageView.this.aJn = false;
                                                UrlDragImageView.this.aIF.setOnClickListener(null);
                                                UrlDragImageView.this.aIF.setOnLongClickListener(null);
                                            }
                                            UrlDragImageView.this.aJo = motionEvent.getY();
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
            if (this.aIF.isImageLoaded() && this.aJf.isLongPic) {
                this.aIG.onImageLoaded();
            } else {
                this.aIF.setImage(ImageSource.uri(str));
            }
            return true;
        }
        return false;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.aIX = dVar;
        if (this.aIB != null) {
            this.aIB.setDragToExitListener(dVar);
        }
    }

    public void Gc() {
        bs(false);
    }

    private boolean ge(String str) {
        return j.jE() || c.fd(str);
    }

    private void setThumbBitmapToView(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap nb;
        if (!this.aIJ && aVar != null && (nb = aVar.nb()) != null) {
            this.aII = true;
            if (aVar.isGif()) {
                this.aIB.setImageUrlData(this.aJf);
                this.aIB.setImageBitmap(nb);
                this.aIC.setVisibility(8);
                this.aJj = false;
            } else {
                if (this.aJf != null && this.aJf.isLongPic) {
                    this.aIB.LK();
                    this.aIB.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.13
                        @Override // com.baidu.tbadk.widget.largeImage.logic.a
                        public void Gk() {
                        }
                    });
                }
                this.aIB.setImageUrlData(this.aJf);
                this.aIB.setImageData(nb, aVar.ng());
            }
            FX();
            FZ();
        }
    }

    private void b(String str, boolean z, boolean z2) {
        if (gf(str)) {
            if (z2 || (!this.aIK && !this.aIJ)) {
                if (!z2 || !bs(true)) {
                    this.aIK = true;
                    com.baidu.adp.lib.f.c.ih().a(str, 27, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.14
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
        imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.I(this.mMaxWidth, this.mMaxHeight));
        com.baidu.adp.widget.ImageView.a a2 = this.aJl.a(imageFileInfo, false);
        if (a2 != null) {
            this.aIJ = true;
            this.mProgressBar.setVisibility(8);
            b(a2);
            return;
        }
        this.aJl.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.2
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.ImageView.a aVar, String str2, boolean z3) {
                UrlDragImageView.this.aIJ = true;
                UrlDragImageView.this.mProgressBar.setVisibility(8);
                UrlDragImageView.this.b(aVar);
            }
        }, false);
    }

    private boolean gf(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null && this.aIH != null) {
            this.aIH.j(aVar.getUrl(), aVar.ng());
        }
        if (aVar == null || aVar.nb() == null) {
            Gd();
            return;
        }
        Bitmap nb = aVar.nb();
        this.aIB.setLoadBigImage(true);
        if (aVar.isGif()) {
            this.aIB.setGifData(aVar.ng(), nb);
            this.aIB.invalidate();
            this.aIB.play();
            this.aJj = false;
            this.aIC.setVisibility(8);
            this.mProgressBar.setVisibility(8);
        } else {
            if (this.aJf != null && this.aJf.isLongPic) {
                this.aIB.LK();
                this.aIB.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.3
                    @Override // com.baidu.tbadk.widget.largeImage.logic.a
                    public void Gk() {
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                    }
                });
            } else {
                this.mProgressBar.setVisibility(8);
            }
            this.aIB.setImageUrlData(this.aJf);
            this.aIB.setImageData(nb, aVar.ng());
            Gh();
        }
        FX();
        FZ();
    }

    private void Gd() {
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
        e.in().removeCallbacks(this.aJq);
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

    public void Ge() {
        if (this.aIB != null && this.aIB.getImageType() == 1) {
            this.aIB.stop();
        }
    }

    public void i(boolean z, boolean z2) {
        String str;
        if (this.aIB != null && (str = (String) this.aIB.getTag()) != null) {
            if (this.aIB.getImageType() == 1) {
                if (this.aIB.getGifCache() == null || !this.aIB.LV()) {
                    b(str, z, z2);
                }
            } else if (this.aIB.getImageType() == 2) {
                b(str, z, z2);
            } else if (Gf()) {
                b(str, z, z2);
            }
        }
    }

    private boolean Gf() {
        if (this.aIB.getImageBitmap() != null && this.aIB.LV()) {
            if (this.aJf == null || !this.aJf.isLongPic || this.aIB.LL()) {
                return false;
            }
            this.aIJ = false;
            this.aJh = false;
            return true;
        }
        return true;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.aJf = imageUrlData;
    }

    public void setIsCdn(boolean z) {
        this.aHv = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aIC) {
            if (!(this.aIC.getTag() instanceof Boolean) || ((Boolean) this.aIC.getTag()).booleanValue()) {
                final String eM = as.eM(this.aJf.originalUrl);
                if (this.aJf.originalProcess >= 0) {
                    com.baidu.tbadk.download.d.Hn().z(eM, 13);
                    this.aJf.originalProcess = -1;
                    Gh();
                    return;
                }
                if (this.aHx != null) {
                    this.aHx.Gl();
                }
                com.baidu.adp.base.e<?> ad = i.ad(this.mContext);
                if (ad == null) {
                    gg(eM);
                } else if (!j.jE() || j.jF() || com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("original_img_down_tip", false)) {
                    gg(eM);
                } else {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("original_img_down_tip", true);
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(ad.getPageActivity());
                    aVar.cf(d.j.original_img_down_no_wifi_tip);
                    aVar.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.4
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar.dismiss();
                            UrlDragImageView.this.gg(eM);
                        }
                    });
                    aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.5
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar.dismiss();
                        }
                    });
                    aVar.b(ad);
                    aVar.xf();
                }
            }
        } else if (view == this.aID && this.aJf != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.mContext).createHistoryCfg(String.valueOf(this.aJf.threadId), String.valueOf(this.aJf.postId), this.aJf.mIsSeeHost, this.aJf.mIsReserver, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gg(String str) {
        if (this.aJf != null) {
            this.aJf.originalProcess = 0;
            this.aIC.setText("0%");
            this.aIC.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_close_yuantu, 0);
            DownloadData downloadData = new DownloadData(str);
            downloadData.setStatus(1);
            downloadData.setUrl(this.aJf.originalUrl);
            downloadData.setType(13);
            downloadData.setPath(this.aIZ + ao.zq().eF(str) + "/" + str);
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.6
                @Override // com.baidu.tbadk.download.c
                public boolean onPreDownload(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2 != null) {
                        if (UrlDragImageView.this.aJf != null && UrlDragImageView.this.aJf.originalProcess != -1) {
                            UrlDragImageView.this.aJf.originalProcess = downloadData2.getProcess();
                        }
                        if (UrlDragImageView.this.aJf == null || UrlDragImageView.this.aJf.originalProcess != -1) {
                            UrlDragImageView.this.aIC.setText(downloadData2.getProcess() + "%");
                            UrlDragImageView.this.aIC.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_close_yuantu, 0);
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public boolean onFileDownloaded(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadSucceed(DownloadData downloadData2) {
                    UrlDragImageView.this.aIC.setText(UrlDragImageView.this.getResources().getString(d.j.done));
                    UrlDragImageView.this.aIC.setTag(false);
                    UrlDragImageView.this.aIC.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    e.in().postDelayed(UrlDragImageView.this.aJr, 1500L);
                    UrlDragImageView.this.aJh = false;
                    UrlDragImageView.this.aJg = UrlDragImageView.this.Gg();
                    UrlDragImageView.this.Gc();
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str2) {
                    UrlDragImageView.this.aJh = false;
                    BdToast.a(UrlDragImageView.this.mContext, str2).xl().xn();
                    UrlDragImageView.this.aJf.originalProcess = -1;
                    UrlDragImageView.this.Gh();
                }
            });
            com.baidu.tbadk.download.d.Hn().a(downloadData, 100);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Gg() {
        if (this.aJf != null && !StringUtils.isNull(this.aJf.originalUrl, true) && this.aJf.originalSize >= 0 && !this.aJf.isBlockedPic) {
            String eM = as.eM(this.aJf.originalUrl);
            File file = new File(this.aIZ + ao.zq().eF(eM) + "/" + eM);
            if (file != null && file.exists()) {
                this.aJf.originalProcess = 100;
                return true;
            }
            if (this.aJf.originalProcess < 0) {
                Gh();
            } else {
                this.aIC.setText(this.aJf.originalProcess + "%");
                this.aIC.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_close_yuantu, 0);
            }
            this.aJj = true;
        } else {
            this.aIC.setVisibility(8);
        }
        return false;
    }

    public void Gh() {
        if (this.aJf != null) {
            if (!Gi() || !this.aJj) {
                this.aIC.setVisibility(8);
            } else {
                this.aIC.setVisibility(0);
            }
            if (this.aJf.originalSize > 0 && !X(this.aJf.originalSize)) {
                this.aIC.setText(aIz + "(" + ap.M(this.aJf.originalSize) + ")");
            } else {
                this.aIC.setText(aIz);
            }
            this.aIC.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    private boolean Gi() {
        return (this.aJf == null || !this.aJf.mIsShowOrigonButton || this.aJf.isBlockedPic || StringUtils.isNull(this.aJf.originalUrl)) ? false : true;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.aHx = bVar;
    }

    private boolean X(long j) {
        return j > aIA;
    }
}
