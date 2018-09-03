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
import com.baidu.tbadk.util.d;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.f;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.File;
/* loaded from: classes2.dex */
public class UrlDragImageView extends RelativeLayout implements View.OnClickListener {
    private boolean aHu;
    private b aHw;
    private boolean aHx;
    protected TextView aIA;
    protected TextView aIB;
    protected SubsamplingScaleImageView aIC;
    private SubsamplingScaleImageView.OnImageEventListener aID;
    private a aIE;
    private boolean aIF;
    private boolean aIG;
    private boolean aIH;
    private boolean aII;
    private boolean aIJ;
    private Bitmap aIK;
    private boolean aIL;
    private float aIM;
    private Matrix aIN;
    private Rect aIO;
    private RectF aIP;
    private RectF aIQ;
    private Rect aIR;
    private Rect aIS;
    private Rect aIT;
    private DragImageView.d aIU;
    private String aIW;
    private float aIX;
    private float aIY;
    private float aIZ;
    protected DragImageView aIy;
    protected TextView aIz;
    private float aJa;
    private float aJb;
    private ImageUrlData aJc;
    private boolean aJd;
    private boolean aJe;
    private boolean aJf;
    public boolean aJg;
    private TextView aJh;
    private com.baidu.tbadk.img.b aJi;
    private View.OnTouchListener aJj;
    private boolean aJk;
    private float aJl;
    private View.OnLongClickListener aJm;
    private Runnable aJn;
    private Runnable aJo;
    private View.OnTouchListener aJp;
    protected Context mContext;
    private float mLastMotionX;
    private float mLastMotionY;
    private int mMaxHeight;
    private int mMaxWidth;
    private View.OnClickListener mOnClickListener;
    protected ProgressBar mProgressBar;
    private float mRatio;
    private int mSkinType;
    private static final String aIw = TbadkCoreApplication.getInst().getString(f.j.original_img_look);
    private static long aIx = 52428800;
    private static final int aIV = l.aj(TbadkCoreApplication.getInst()) / 5;
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
            if (this.aIz != null) {
                am.i(this.aIz, f.C0146f.btn_percent_yuantu);
                am.b(this.aIz, f.d.cp_cont_g, 1, 0);
            }
            if (this.aIA != null) {
                am.j(this.aIA, f.d.common_color_10022);
                am.b(this.aIA, f.d.cp_cont_g, 1, 0);
            }
            this.mSkinType = i;
        }
    }

    public void setHeadImage(boolean z) {
        if (this.aIy != null) {
            this.aIy.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.aIE = aVar;
    }

    public UrlDragImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mContext = null;
        this.mProgressBar = null;
        this.aIy = null;
        this.aIE = null;
        this.aHu = false;
        this.aIH = false;
        this.aIL = false;
        this.mRatio = 1.0f;
        this.aIM = 0.0f;
        this.aIN = new Matrix();
        this.aIP = new RectF();
        this.aIX = 0.0f;
        this.aIY = 0.0f;
        this.aIZ = 1.0f;
        this.aJa = 1.0f;
        this.aJb = 0.0f;
        this.aJd = false;
        this.aJe = false;
        this.aJf = false;
        this.aJg = false;
        this.aJh = null;
        this.aJk = true;
        this.aJl = 0.0f;
        this.mOnClickListener = null;
        this.aJm = null;
        this.aJn = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.aJk = true;
            }
        };
        this.aJo = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.aIz.setVisibility(8);
                        UrlDragImageView.this.aJg = false;
                    }
                });
                UrlDragImageView.this.aIz.startAnimation(alphaAnimation);
            }
        };
        this.aJp = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.aJj != null) {
                    UrlDragImageView.this.aJj.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.aJi = new com.baidu.tbadk.img.b();
        init();
    }

    public UrlDragImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.mContext = null;
        this.mProgressBar = null;
        this.aIy = null;
        this.aIE = null;
        this.aHu = false;
        this.aIH = false;
        this.aIL = false;
        this.mRatio = 1.0f;
        this.aIM = 0.0f;
        this.aIN = new Matrix();
        this.aIP = new RectF();
        this.aIX = 0.0f;
        this.aIY = 0.0f;
        this.aIZ = 1.0f;
        this.aJa = 1.0f;
        this.aJb = 0.0f;
        this.aJd = false;
        this.aJe = false;
        this.aJf = false;
        this.aJg = false;
        this.aJh = null;
        this.aJk = true;
        this.aJl = 0.0f;
        this.mOnClickListener = null;
        this.aJm = null;
        this.aJn = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.aJk = true;
            }
        };
        this.aJo = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.aIz.setVisibility(8);
                        UrlDragImageView.this.aJg = false;
                    }
                });
                UrlDragImageView.this.aIz.startAnimation(alphaAnimation);
            }
        };
        this.aJp = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.aJj != null) {
                    UrlDragImageView.this.aJj.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.aJi = new com.baidu.tbadk.img.b();
        init();
    }

    public DragImageView getImageView() {
        return this.aIy;
    }

    public void setGifSetListener(DragImageView.e eVar) {
        this.aIy.setGifSetListener(eVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.aIy.setImageOnClickListener(onClickListener);
        this.aIC.setOnClickListener(onClickListener);
        this.mOnClickListener = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aJm = onLongClickListener;
        if (!this.aHx) {
            this.aIy.setImageOnLongClickListener(this.aJm);
            this.aIC.setOnLongClickListener(this.aJm);
        }
    }

    public void setOnSizeChangedListener(final DragImageView.g gVar) {
        this.aIy.setOnSizeChangedListener(new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.8
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
        this.mMaxHeight = l.aj(this.mContext) - ((int) this.mContext.getResources().getDimension(f.e.ds166));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.aIy = new DragImageView(this.mContext);
        this.aIy.setLayoutParams(layoutParams);
        this.aIy.setOnTouchListener(this.aJp);
        addView(this.aIy);
        this.aIC = new SubsamplingScaleImageView(this.mContext);
        this.aIC.setMaxScale(50.0f);
        this.aIC.setOnTouchListener(this.aJp);
        this.aIC.setVisibility(4);
        addView(this.aIC, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(getResources().getDrawable(f.C0146f.progressbar));
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
        this.aIW = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        this.aIz = new TextView(this.mContext);
        am.i(this.aIz, f.C0146f.btn_percent_yuantu);
        this.aIz.setText(f.j.original_img_look);
        this.aIz.setTextSize(0, getResources().getDimensionPixelSize(f.e.fontsize28));
        am.b(this.aIz, f.d.cp_cont_i, 1, 0);
        this.aIz.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(f.e.ds16);
        this.aIz.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        this.aIz.setMinWidth(getResources().getDimensionPixelSize(f.e.ds222));
        this.aIz.setMinHeight(getResources().getDimensionPixelSize(f.e.ds60));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(f.e.fontsize40);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        this.aIz.setOnClickListener(this);
        this.aIz.setVisibility(8);
        addView(this.aIz, layoutParams);
    }

    public void setIsCanDrag(boolean z) {
        this.aHx = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        Bitmap imageBitmap;
        int height;
        int width;
        if (!this.aHx || !this.aIG) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.aII && motionEvent.getPointerCount() >= 2) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.aII || this.aIJ) {
            requestDisallowInterceptTouchEvent(true);
        }
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        float x = motionEvent.getX();
        int i = action & 255;
        if (i == 0) {
            if (this.aIK == null) {
                if (this.aIC.getVisibility() == 0) {
                    this.aIK = d.S(this.aIC);
                } else {
                    this.aIK = d.S(this.aIy);
                }
            }
            if (this.aIO == null && this.aIK != null) {
                int measuredWidth = getMeasuredWidth();
                float measuredWidth2 = ((getMeasuredWidth() * 1.0f) / this.aIK.getWidth()) * this.aIK.getHeight();
                if (measuredWidth2 > getMeasuredHeight()) {
                    measuredWidth2 = getMeasuredHeight();
                }
                RectF g = g(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
                this.aIO = new Rect((int) g.left, (int) g.top, (int) g.right, (int) g.bottom);
            }
            if (this.aIS == null && this.aIK != null) {
                if (this.aIC.getVisibility() == 0) {
                    height = this.aIC.getSHeight();
                    width = this.aIC.getSWidth();
                } else {
                    if (this.aIy.getImageType() == 1) {
                        imageBitmap = (this.aIy.getCurrentFrame() == null || this.aIy.getCurrentFrame().aXO == null) ? this.aIK : this.aIy.getCurrentFrame().aXO;
                    } else {
                        imageBitmap = this.aIy.getImageBitmap() == null ? this.aIK : this.aIy.getImageBitmap();
                    }
                    height = imageBitmap.getHeight();
                    width = imageBitmap.getWidth();
                }
                float ak = l.ak(getContext());
                int i2 = (int) (height * ak);
                int i3 = (int) (width * ak);
                if (i3 > this.aIK.getWidth() && this.aIK.getWidth() != 0) {
                    float width2 = (i3 * 1.0f) / this.aIK.getWidth();
                    i3 = this.aIK.getWidth();
                    i2 = (int) (i2 / width2);
                }
                if (i2 > this.aIK.getHeight() && this.aIK.getHeight() != 0) {
                    i3 = (int) (i3 / ((i2 * 1.0f) / this.aIK.getHeight()));
                    i2 = this.aIK.getHeight();
                }
                int aj = (l.aj(getContext()) - i2) / 2;
                int ah = (l.ah(getContext()) - i3) / 2;
                this.aIS = new Rect(ah, aj, i3 + ah, i2 + aj);
                this.aIT = new Rect(this.aIS);
                this.aJb = aj / l.aj(getContext());
                this.aIR = new Rect(0, 0, this.aIK.getWidth(), this.aIK.getHeight());
            }
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (i == 2) {
            this.aII = l(this.mLastMotionX - x, this.mLastMotionY - y);
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (this.aII || this.aIJ) {
            this.aIy.setImageOnLongClickListener(null);
            this.aIC.setOnLongClickListener(null);
            z = true;
        } else {
            this.aIy.setImageOnLongClickListener(this.aJm);
            this.aIC.setOnLongClickListener(this.aJm);
            z = super.dispatchTouchEvent(motionEvent);
        }
        if (i == 1 || i == 3) {
            this.mLastMotionX = 0.0f;
            this.mLastMotionY = 0.0f;
            this.aIL = false;
            this.aIN.reset();
            this.aII = false;
            if (this.aIM > aIV) {
                this.aIJ = true;
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
        if (this.aIC.getVisibility() != 0 || this.aIC.isCanDrag()) {
            if (this.aJc == null || !this.aJc.isLongPic || this.aIC.getVisibility() != 0 || this.aIC.isViewTop()) {
                if (this.aJc == null || !this.aJc.isLongPic || this.aIC.getVisibility() == 0 || this.aIy.LJ()) {
                    if (this.aIC.getVisibility() == 0 || this.aIy.LL()) {
                        if (this.aIK != null && getScrollY() == 0 && f2 < 0.0f && !this.aIL) {
                            this.aIL = true;
                            this.aIM = 0.0f;
                            this.mRatio = 1.0f;
                            if (this.aIU != null) {
                                this.aIU.Mb();
                            }
                        }
                        if (this.aIL) {
                            this.aIM -= f2;
                            int measuredHeight = getMeasuredHeight();
                            if (this.aIM > measuredHeight) {
                                this.aIM = measuredHeight;
                            }
                            float f3 = f2 / measuredHeight;
                            this.aIN.postTranslate((-f) * 1.5f * this.mRatio, (-1.5f) * f2 * this.mRatio);
                            if (this.mRatio * (1.0f + f3) > 1.0f || this.aIM < 0.0f) {
                                this.aIN.preScale(1.0f / this.mRatio, 1.0f / this.mRatio, (this.mRatio * this.aIK.getWidth()) / 2.0f, this.mRatio * (this.aIK.getHeight() / 2));
                                this.mRatio = 1.0f;
                            } else {
                                this.aIN.preScale(1.0f + f3, 1.0f + f3, (this.mRatio * this.aIK.getWidth()) / 2.0f, this.mRatio * (this.aIK.getHeight() / 2));
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
        if (this.aII && this.aIK != null && !this.aIK.isRecycled() && this.aIL) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.aIP == null) {
                this.aIP = new RectF();
            }
            this.aIN.mapRect(this.aIP, new RectF(this.aIO));
            canvas.drawBitmap(this.aIK, this.aIR, this.aIP, (Paint) null);
        } else if (this.aIJ && this.aIK != null && !this.aIK.isRecycled()) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.aJc == null || this.aJc.getSourceImageRectInScreen() == null) {
                canvas.drawBitmap(this.aIK, this.aIR, this.aIP, (Paint) null);
            } else {
                canvas.drawBitmap(this.aIK, this.aIS, this.aIP, (Paint) null);
            }
        } else {
            super.dispatchDraw(canvas);
        }
    }

    private void FU() {
        if (this.aJc == null) {
            if (this.aIU != null) {
                this.aIU.Mc();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.aJc.getSourceImageRectInScreen();
        final Rect dstRectInScreen = this.aJc.getDstRectInScreen();
        if (sourceImageRectInScreen == null || dstRectInScreen == null) {
            if (this.aIU != null) {
                this.aIU.Mc();
                return;
            }
            return;
        }
        a(sourceImageRectInScreen, dstRectInScreen);
        e(sourceImageRectInScreen);
        this.aIQ = new RectF(this.aIP);
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
                UrlDragImageView.this.aIL = false;
                UrlDragImageView.this.invalidate();
                if (UrlDragImageView.this.aIU != null) {
                    UrlDragImageView.this.aIU.Mc();
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
            float f = ((rect.bottom - rect.top) / (rect.right - rect.left)) * (this.aIP.right - this.aIP.left);
            this.aIP.top += this.aIP.height() * this.aJb;
            this.aIP.bottom = f + this.aIP.top;
        }
    }

    private void a(Rect rect, Rect rect2) {
        this.aIX = 0.0f;
        this.aIY = 0.0f;
        this.aIZ = 1.0f;
        this.aJa = 1.0f;
        if (rect != null && rect2 != null && rect.contains(rect2)) {
            this.aIX = (rect2.left - rect.left) / rect.width();
            this.aIY = (rect2.top - rect.top) / rect.height();
            this.aIZ = (rect2.right - rect.left) / rect.width();
            this.aJa = (rect2.bottom - rect.top) / rect.height();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(float f) {
        if (this.aIS != null) {
            this.aIS.left = (int) (this.aIT.left + (this.aIT.width() * this.aIX * f));
            this.aIS.top = (int) (this.aIT.top + (this.aIT.height() * this.aIY * f));
            this.aIS.right = (int) (this.aIT.left + (this.aIT.width() * (((1.0f - this.aIZ) * (1.0f - f)) + this.aIZ)));
            this.aIS.bottom = (int) (this.aIT.top + (this.aIT.height() * (((1.0f - this.aJa) * (1.0f - f)) + this.aJa)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Rect rect, float f) {
        if (this.aIP != null && rect != null) {
            this.aIP.left = this.aIQ.left + ((rect.left - this.aIQ.left) * f);
            this.aIP.top = this.aIQ.top + ((rect.top - this.aIQ.top) * f);
            this.aIP.right = this.aIQ.right + ((rect.right - this.aIQ.right) * f);
            this.aIP.bottom = this.aIQ.bottom + ((rect.bottom - this.aIQ.bottom) * f);
        }
    }

    private RectF g(float f, float f2, float f3, float f4) {
        return new RectF(f - (f3 / 2.0f), f2 - (f4 / 2.0f), (f3 / 2.0f) + f, (f4 / 2.0f) + f2);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.aJj = onTouchListener;
    }

    private void FV() {
        this.aJh = new TextView(this.mContext);
        this.aJh.setBackgroundResource(f.C0146f.bg_url_drag_imagview_fade_view);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.height = getResources().getDimensionPixelSize(f.e.ds180);
        layoutParams.addRule(12);
        addView(this.aJh, layoutParams);
        this.aJh.setVisibility(8);
    }

    private void FW() {
        this.aIA = new TextView(this.mContext);
        am.j(this.aIA, f.d.common_color_10022);
        this.aIA.setText(f.j.goto_pb_floor);
        this.aIA.setTextSize(0, getResources().getDimensionPixelSize(f.e.fontsize28));
        am.b(this.aIA, f.d.cp_cont_i, 1, 0);
        this.aIA.setCompoundDrawablePadding(l.dip2px(this.mContext, 4.0f));
        this.aIA.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(f.C0146f.icon_see_arrow), (Drawable) null);
        this.aIA.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(f.e.ds20);
        this.aIA.setPadding(dimensionPixelSize * 3, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(f.e.ds30);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(f.e.ds10);
        layoutParams.leftMargin = getResources().getDimensionPixelSize(f.e.ds20);
        layoutParams.addRule(1, this.aIz.getId());
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        this.aIA.setOnClickListener(this);
        this.aIA.setMinHeight(getResources().getDimensionPixelSize(f.e.ds100));
        addView(this.aIA, layoutParams);
        this.aIA.setVisibility(8);
    }

    private void FX() {
        if (this.aIA != null) {
            boolean z = this.aIF || this.aIG;
            if (!this.aJf && z && this.aJc != null && this.aJc.threadId > 0 && this.aJc.postId > 0 && this.aJc.mThreadType != 33 && !this.aJc.isBlockedPic) {
                this.aIA.setVisibility(0);
                if (this.aJh != null) {
                    this.aJh.setVisibility(0);
                    return;
                }
                return;
            }
            this.aIA.setVisibility(8);
            if (this.aJh != null) {
                this.aJh.setVisibility(8);
            }
        }
    }

    private void FY() {
        if (this.aIA != null) {
            this.aIA.setVisibility(8);
            if (this.aJh != null) {
                this.aJh.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FZ() {
        if ((this.aIF || this.aIG) && this.aJc != null && this.aJc.mPicType == 1 && !TextUtils.isEmpty(this.aJc.mTagName)) {
            if (this.aIB != null) {
                this.aIB.setVisibility(8);
                this.aIB = null;
            }
            this.aIB = new TextView(this.mContext);
            this.aIB.setText(this.aJc.mTagName);
            this.aIB.setTextSize(0, getResources().getDimensionPixelSize(f.e.fontsize26));
            am.b(this.aIB, f.d.common_color_10013, 1, 0);
            am.j(this.aIB, f.d.common_color_10215);
            this.aIB.setAlpha(0.75f);
            this.aIB.setIncludeFontPadding(false);
            this.aIB.setGravity(17);
            int f = l.f(this.mContext, f.e.ds2);
            this.aIB.setPadding(f, f, f, f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.aIy.getBottomOffset();
            layoutParams.leftMargin = this.aIy.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.aIB, layoutParams);
            this.aIB.setVisibility(0);
        }
    }

    public void bs(boolean z) {
        this.aJf = z;
        if (this.aJf) {
            FY();
        } else {
            FX();
        }
    }

    public void setUrl(String str, boolean z) {
        if (str.contains("*")) {
            str = str.split("[*]")[0];
        }
        this.aIy.setTag(str);
        this.aIy.setLoadBigImage(false);
        this.aIy.setImageDrawable(null);
        this.aIF = false;
        this.aIG = false;
        this.aJd = Gg();
        this.aIz.setVisibility(8);
        if (ge(str)) {
            b(str, z, false);
        }
    }

    private boolean Ga() {
        return this.aIy != null && this.aIy.LZ();
    }

    public void Gb() {
        if (this.aJc != null && !Ga()) {
            String str = this.aJc.imageUrl;
            int i = this.aJc.urlType;
            com.baidu.adp.widget.ImageView.a aVar = null;
            if (com.baidu.tbadk.core.util.d.a.v(str, i)) {
                aVar = com.baidu.tbadk.core.util.d.a.w(str, i);
            }
            if (aVar != null) {
                setThumbBitmapToView(aVar);
            }
        }
    }

    private boolean bt(boolean z) {
        String eM;
        if (!this.aJe || z) {
            this.aJe = true;
            if (!this.aJd || this.aJc == null || StringUtils.isNull(this.aJc.originalUrl, true) || this.aJc.originalSize < 0 || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String str = this.aIW + ao.zo().eF(eM) + "/" + as.eM(this.aJc.originalUrl);
            final int[] eh = com.baidu.tbadk.core.util.l.eh(str);
            this.aIC.setVisibility(0);
            if (this.aID == null) {
                this.aID = new SubsamplingScaleImageView.OnImageEventListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12
                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onReady() {
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.aIy.LV();
                        UrlDragImageView.this.aIy.setVisibility(4);
                    }

                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onImageLoaded() {
                        if (UrlDragImageView.this.aJc.isLongPic && eh[0] > 0) {
                            UrlDragImageView.this.aIy.onDestroy();
                            final float measuredWidth = (UrlDragImageView.this.getMeasuredWidth() * 1.0f) / eh[0];
                            final PointF pointF = new PointF((eh[0] * 1.0f) / 2.0f, 0.0f);
                            UrlDragImageView.this.aIC.setScaleAndCenter(measuredWidth, pointF);
                            UrlDragImageView.this.aIC.setMaxScale(2.0f * measuredWidth);
                            UrlDragImageView.this.aIC.setDoubleTapZoomScale(2.0f * measuredWidth);
                            UrlDragImageView.this.aIC.setInitScale(measuredWidth);
                            UrlDragImageView.this.aIC.setDoubleTapZoomStyle(4);
                            UrlDragImageView.this.aIC.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12.1
                                @Override // android.view.View.OnTouchListener
                                public boolean onTouch(View view, MotionEvent motionEvent) {
                                    if (UrlDragImageView.this.aJj != null) {
                                        UrlDragImageView.this.aJj.onTouch(view, motionEvent);
                                    }
                                    switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                                        case 0:
                                            UrlDragImageView.this.aJl = motionEvent.getY();
                                            UrlDragImageView.this.aIC.setOnClickListener(UrlDragImageView.this.aJk ? UrlDragImageView.this.mOnClickListener : null);
                                            UrlDragImageView.this.aIC.setOnLongClickListener(UrlDragImageView.this.aJk ? UrlDragImageView.this.aJm : null);
                                            break;
                                        case 1:
                                        case 3:
                                            if (UrlDragImageView.this.aIC.getScale() < measuredWidth) {
                                                UrlDragImageView.this.aIC.setScaleAndCenter(measuredWidth, pointF);
                                            }
                                            e.in().removeCallbacks(UrlDragImageView.this.aJn);
                                            e.in().postDelayed(UrlDragImageView.this.aJn, 1000L);
                                            break;
                                        case 2:
                                            if (Math.abs(motionEvent.getY() - UrlDragImageView.this.aJl) > UrlDragImageView.TOUCH_SLOP) {
                                                UrlDragImageView.this.aJk = false;
                                                UrlDragImageView.this.aIC.setOnClickListener(null);
                                                UrlDragImageView.this.aIC.setOnLongClickListener(null);
                                            }
                                            UrlDragImageView.this.aJl = motionEvent.getY();
                                            break;
                                    }
                                    return false;
                                }
                            });
                            UrlDragImageView.this.aIy.setVisibility(4);
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
            this.aIC.setOnImageEventListener(this.aID);
            if (this.aIC.isImageLoaded() && this.aJc.isLongPic) {
                this.aID.onImageLoaded();
            } else {
                this.aIC.setImage(ImageSource.uri(str));
            }
            return true;
        }
        return false;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.aIU = dVar;
        if (this.aIy != null) {
            this.aIy.setDragToExitListener(dVar);
        }
    }

    public void Gc() {
        bt(false);
    }

    private boolean ge(String str) {
        return j.jE() || c.fd(str);
    }

    private void setThumbBitmapToView(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap nb;
        if (!this.aIG && aVar != null && (nb = aVar.nb()) != null) {
            this.aIF = true;
            if (aVar.isGif()) {
                this.aIy.setImageUrlData(this.aJc);
                this.aIy.setImageBitmap(nb);
                this.aIz.setVisibility(8);
                this.aJg = false;
            } else {
                if (this.aJc != null && this.aJc.isLongPic) {
                    this.aIy.LO();
                    this.aIy.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.13
                        @Override // com.baidu.tbadk.widget.largeImage.logic.a
                        public void Gk() {
                        }
                    });
                }
                this.aIy.setImageUrlData(this.aJc);
                this.aIy.setImageData(nb, aVar.ng());
            }
            FX();
            FZ();
        }
    }

    private void b(String str, boolean z, boolean z2) {
        if (gf(str)) {
            if (z2 || (!this.aIH && !this.aIG)) {
                if (!z2 || !bt(true)) {
                    this.aIH = true;
                    com.baidu.adp.lib.f.c.ih().a(str, 27, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.14
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onCancelled(String str2) {
                            UrlDragImageView.this.aIH = false;
                            UrlDragImageView.this.aIy.setVisibility(0);
                            UrlDragImageView.this.mProgressBar.setVisibility(8);
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            UrlDragImageView.this.aIH = false;
                            UrlDragImageView.this.aIG = true;
                            UrlDragImageView.this.b(aVar);
                        }
                    }, 0, 0, false, null, Boolean.valueOf(z), this.aIy.getImageData(), Boolean.valueOf(this.aHu));
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
        com.baidu.adp.widget.ImageView.a a2 = this.aJi.a(imageFileInfo, false);
        if (a2 != null) {
            this.aIG = true;
            this.mProgressBar.setVisibility(8);
            b(a2);
            return;
        }
        this.aJi.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.2
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.ImageView.a aVar, String str2, boolean z3) {
                UrlDragImageView.this.aIG = true;
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
        if (aVar != null && this.aIE != null) {
            this.aIE.j(aVar.getUrl(), aVar.ng());
        }
        if (aVar == null || aVar.nb() == null) {
            Gd();
            return;
        }
        Bitmap nb = aVar.nb();
        this.aIy.setLoadBigImage(true);
        if (aVar.isGif()) {
            this.aIy.setGifData(aVar.ng(), nb);
            this.aIy.invalidate();
            this.aIy.play();
            this.aJg = false;
            this.aIz.setVisibility(8);
            this.mProgressBar.setVisibility(8);
        } else {
            if (this.aJc != null && this.aJc.isLongPic) {
                this.aIy.LO();
                this.aIy.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.3
                    @Override // com.baidu.tbadk.widget.largeImage.logic.a
                    public void Gk() {
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                    }
                });
            } else {
                this.mProgressBar.setVisibility(8);
            }
            this.aIy.setImageUrlData(this.aJc);
            this.aIy.setImageData(nb, aVar.ng());
            Gh();
        }
        FX();
        FZ();
    }

    private void Gd() {
        if (!this.aIF) {
            this.aIy.setDefaultBitmap();
        } else {
            this.aIG = false;
        }
        this.aIz.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    public void setGifMaxUseableMem(int i) {
        this.aIy.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.aIy != null) {
            this.aIy.onDestroy();
        }
        if (this.aIC != null) {
            this.aIC.recycle();
        }
        if (this.aIK != null) {
            this.aIK.recycle();
            this.aIK = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        e.in().removeCallbacks(this.aJn);
    }

    public void release() {
        if (this.aIy != null) {
            this.aIy.release();
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.aIz != null) {
            this.aIz.setVisibility(8);
        }
    }

    public void Ge() {
        if (this.aIy != null && this.aIy.getImageType() == 1) {
            this.aIy.stop();
        }
    }

    public void i(boolean z, boolean z2) {
        String str;
        if (this.aIy != null && (str = (String) this.aIy.getTag()) != null) {
            if (this.aIy.getImageType() == 1) {
                if (this.aIy.getGifCache() == null || !this.aIy.LZ()) {
                    b(str, z, z2);
                }
            } else if (this.aIy.getImageType() == 2) {
                b(str, z, z2);
            } else if (Gf()) {
                b(str, z, z2);
            }
        }
    }

    private boolean Gf() {
        if (this.aIy.getImageBitmap() != null && this.aIy.LZ()) {
            if (this.aJc == null || !this.aJc.isLongPic || this.aIy.LP()) {
                return false;
            }
            this.aIG = false;
            this.aJe = false;
            return true;
        }
        return true;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.aJc = imageUrlData;
    }

    public void setIsCdn(boolean z) {
        this.aHu = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aIz) {
            if (!(this.aIz.getTag() instanceof Boolean) || ((Boolean) this.aIz.getTag()).booleanValue()) {
                final String eM = as.eM(this.aJc.originalUrl);
                if (this.aJc.originalProcess >= 0) {
                    com.baidu.tbadk.download.d.Hn().z(eM, 13);
                    this.aJc.originalProcess = -1;
                    Gh();
                    return;
                }
                if (this.aHw != null) {
                    this.aHw.Gl();
                }
                com.baidu.adp.base.e<?> ad = i.ad(this.mContext);
                if (ad == null) {
                    gg(eM);
                } else if (!j.jE() || j.jF() || com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("original_img_down_tip", false)) {
                    gg(eM);
                } else {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("original_img_down_tip", true);
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(ad.getPageActivity());
                    aVar.cf(f.j.original_img_down_no_wifi_tip);
                    aVar.a(f.j.alert_yes_button, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.4
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar.dismiss();
                            UrlDragImageView.this.gg(eM);
                        }
                    });
                    aVar.b(f.j.cancel, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.5
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar.dismiss();
                        }
                    });
                    aVar.b(ad);
                    aVar.xe();
                }
            }
        } else if (view == this.aIA && this.aJc != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.mContext).createHistoryCfg(String.valueOf(this.aJc.threadId), String.valueOf(this.aJc.postId), this.aJc.mIsSeeHost, this.aJc.mIsReserver, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gg(String str) {
        if (this.aJc != null) {
            this.aJc.originalProcess = 0;
            this.aIz.setText("0%");
            this.aIz.setCompoundDrawablesWithIntrinsicBounds(0, 0, f.C0146f.icon_close_yuantu, 0);
            DownloadData downloadData = new DownloadData(str);
            downloadData.setStatus(1);
            downloadData.setUrl(this.aJc.originalUrl);
            downloadData.setType(13);
            downloadData.setPath(this.aIW + ao.zo().eF(str) + "/" + str);
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.6
                @Override // com.baidu.tbadk.download.c
                public boolean onPreDownload(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2 != null) {
                        if (UrlDragImageView.this.aJc != null && UrlDragImageView.this.aJc.originalProcess != -1) {
                            UrlDragImageView.this.aJc.originalProcess = downloadData2.getProcess();
                        }
                        if (UrlDragImageView.this.aJc == null || UrlDragImageView.this.aJc.originalProcess != -1) {
                            UrlDragImageView.this.aIz.setText(downloadData2.getProcess() + "%");
                            UrlDragImageView.this.aIz.setCompoundDrawablesWithIntrinsicBounds(0, 0, f.C0146f.icon_close_yuantu, 0);
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public boolean onFileDownloaded(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadSucceed(DownloadData downloadData2) {
                    UrlDragImageView.this.aIz.setText(UrlDragImageView.this.getResources().getString(f.j.done));
                    UrlDragImageView.this.aIz.setTag(false);
                    UrlDragImageView.this.aIz.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    e.in().postDelayed(UrlDragImageView.this.aJo, 1500L);
                    UrlDragImageView.this.aJe = false;
                    UrlDragImageView.this.aJd = UrlDragImageView.this.Gg();
                    UrlDragImageView.this.Gc();
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str2) {
                    UrlDragImageView.this.aJe = false;
                    BdToast.a(UrlDragImageView.this.mContext, str2).xk().xm();
                    UrlDragImageView.this.aJc.originalProcess = -1;
                    UrlDragImageView.this.Gh();
                }
            });
            com.baidu.tbadk.download.d.Hn().a(downloadData, 100);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Gg() {
        if (this.aJc != null && !StringUtils.isNull(this.aJc.originalUrl, true) && this.aJc.originalSize >= 0 && !this.aJc.isBlockedPic) {
            String eM = as.eM(this.aJc.originalUrl);
            File file = new File(this.aIW + ao.zo().eF(eM) + "/" + eM);
            if (file != null && file.exists()) {
                this.aJc.originalProcess = 100;
                return true;
            }
            if (this.aJc.originalProcess < 0) {
                Gh();
            } else {
                this.aIz.setText(this.aJc.originalProcess + "%");
                this.aIz.setCompoundDrawablesWithIntrinsicBounds(0, 0, f.C0146f.icon_close_yuantu, 0);
            }
            this.aJg = true;
        } else {
            this.aIz.setVisibility(8);
        }
        return false;
    }

    public void Gh() {
        if (this.aJc != null) {
            if (!Gi() || !this.aJg) {
                this.aIz.setVisibility(8);
            } else {
                this.aIz.setVisibility(0);
            }
            if (this.aJc.originalSize > 0 && !X(this.aJc.originalSize)) {
                this.aIz.setText(aIw + "(" + ap.M(this.aJc.originalSize) + ")");
            } else {
                this.aIz.setText(aIw);
            }
            this.aIz.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    private boolean Gi() {
        return (this.aJc == null || !this.aJc.mIsShowOrigonButton || this.aJc.isBlockedPic || StringUtils.isNull(this.aJc.originalUrl)) ? false : true;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.aHw = bVar;
    }

    private boolean X(long j) {
        return j > aIx;
    }
}
