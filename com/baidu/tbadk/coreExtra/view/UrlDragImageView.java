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
    private boolean aUl;
    private b aUn;
    private boolean aUo;
    private boolean aUp;
    private boolean aVA;
    private Bitmap aVB;
    private boolean aVC;
    private float aVD;
    private Matrix aVE;
    private Rect aVF;
    private RectF aVG;
    private RectF aVH;
    private Rect aVI;
    private Rect aVJ;
    private Rect aVK;
    private DragImageView.d aVL;
    private String aVN;
    private float aVO;
    private float aVP;
    private float aVQ;
    private float aVR;
    private float aVS;
    private ImageUrlData aVT;
    private boolean aVU;
    private boolean aVV;
    private boolean aVW;
    public boolean aVX;
    private TextView aVY;
    private com.baidu.tbadk.img.b aVZ;
    protected DragImageView aVp;
    protected TextView aVq;
    protected TextView aVr;
    protected TextView aVs;
    protected SubsamplingScaleImageView aVt;
    private SubsamplingScaleImageView.OnImageEventListener aVu;
    private a aVv;
    private boolean aVw;
    private boolean aVx;
    private boolean aVy;
    private boolean aVz;
    private View.OnTouchListener aWa;
    private boolean aWb;
    private float aWc;
    private View.OnLongClickListener aWd;
    private Runnable aWe;
    private Runnable aWf;
    private View.OnTouchListener aWg;
    protected Context mContext;
    private float mLastMotionX;
    private float mLastMotionY;
    private int mMaxHeight;
    private int mMaxWidth;
    private View.OnClickListener mOnClickListener;
    protected ProgressBar mProgressBar;
    private float mRatio;
    private int mSkinType;
    private static final String aVn = TbadkCoreApplication.getInst().getString(e.j.original_img_look);
    private static long aVo = Config.RAVEN_LOG_LIMIT;
    private static final int aVM = l.aQ(TbadkCoreApplication.getInst()) / 5;
    private static final String TAG = UrlDragImageView.class.getSimpleName();
    private static final int TOUCH_SLOP = ViewConfiguration.get(TbadkCoreApplication.getInst()).getScaledTouchSlop();

    /* loaded from: classes6.dex */
    public interface a {
        void j(String str, byte[] bArr);
    }

    /* loaded from: classes6.dex */
    public interface b {
        void Li();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.aVq != null) {
                al.i(this.aVq, e.f.btn_percent_yuantu);
                al.b(this.aVq, e.d.cp_cont_g, 1, 0);
            }
            if (this.aVr != null) {
                al.j(this.aVr, e.d.common_color_10022);
                al.b(this.aVr, e.d.cp_cont_g, 1, 0);
            }
            this.mSkinType = i;
        }
    }

    public void setHeadImage(boolean z) {
        if (this.aVp != null) {
            this.aVp.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.aVv = aVar;
    }

    public UrlDragImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mContext = null;
        this.mProgressBar = null;
        this.aVp = null;
        this.aVv = null;
        this.aUl = false;
        this.aVy = false;
        this.aVC = false;
        this.mRatio = 1.0f;
        this.aVD = 0.0f;
        this.aVE = new Matrix();
        this.aVG = new RectF();
        this.aVO = 0.0f;
        this.aVP = 0.0f;
        this.aVQ = 1.0f;
        this.aVR = 1.0f;
        this.aVS = 0.0f;
        this.aVU = false;
        this.aVV = false;
        this.aVW = false;
        this.aVX = false;
        this.aVY = null;
        this.aWb = true;
        this.aWc = 0.0f;
        this.mOnClickListener = null;
        this.aWd = null;
        this.aWe = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.aWb = true;
            }
        };
        this.aWf = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.aVq.setVisibility(8);
                        UrlDragImageView.this.aVX = false;
                    }
                });
                UrlDragImageView.this.aVq.startAnimation(alphaAnimation);
            }
        };
        this.aWg = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.aWa != null) {
                    UrlDragImageView.this.aWa.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.aVZ = new com.baidu.tbadk.img.b();
        init();
    }

    public UrlDragImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.mContext = null;
        this.mProgressBar = null;
        this.aVp = null;
        this.aVv = null;
        this.aUl = false;
        this.aVy = false;
        this.aVC = false;
        this.mRatio = 1.0f;
        this.aVD = 0.0f;
        this.aVE = new Matrix();
        this.aVG = new RectF();
        this.aVO = 0.0f;
        this.aVP = 0.0f;
        this.aVQ = 1.0f;
        this.aVR = 1.0f;
        this.aVS = 0.0f;
        this.aVU = false;
        this.aVV = false;
        this.aVW = false;
        this.aVX = false;
        this.aVY = null;
        this.aWb = true;
        this.aWc = 0.0f;
        this.mOnClickListener = null;
        this.aWd = null;
        this.aWe = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.aWb = true;
            }
        };
        this.aWf = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.aVq.setVisibility(8);
                        UrlDragImageView.this.aVX = false;
                    }
                });
                UrlDragImageView.this.aVq.startAnimation(alphaAnimation);
            }
        };
        this.aWg = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.aWa != null) {
                    UrlDragImageView.this.aWa.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.aVZ = new com.baidu.tbadk.img.b();
        init();
    }

    public DragImageView getImageView() {
        return this.aVp;
    }

    public void setGifSetListener(DragImageView.e eVar) {
        this.aVp.setGifSetListener(eVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.aVp.setImageOnClickListener(onClickListener);
        this.aVt.setOnClickListener(onClickListener);
        this.mOnClickListener = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aWd = onLongClickListener;
        if (!this.aUo) {
            this.aVp.setImageOnLongClickListener(this.aWd);
            this.aVt.setOnLongClickListener(this.aWd);
        }
    }

    public void setOnSizeChangedListener(final DragImageView.g gVar) {
        this.aVp.setOnSizeChangedListener(new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.8
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (gVar != null) {
                    gVar.a(dragImageView, z, z2);
                }
                UrlDragImageView.this.KW();
            }
        });
    }

    protected void init() {
        this.mMaxWidth = l.aO(this.mContext);
        this.mMaxHeight = l.aQ(this.mContext) - ((int) this.mContext.getResources().getDimension(e.C0210e.ds166));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.aVp = new DragImageView(this.mContext);
        this.aVp.setLayoutParams(layoutParams);
        this.aVp.setOnTouchListener(this.aWg);
        addView(this.aVp);
        this.aVt = new SubsamplingScaleImageView(this.mContext);
        this.aVt.setMaxScale(50.0f);
        this.aVt.setOnTouchListener(this.aWg);
        this.aVt.setVisibility(4);
        addView(this.aVt, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(getResources().getDrawable(e.f.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        KS();
        KQ();
        KT();
    }

    private void KQ() {
        this.aVN = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        this.aVq = new TextView(this.mContext);
        al.i(this.aVq, e.f.btn_percent_yuantu);
        this.aVq.setText(e.j.original_img_look);
        this.aVq.setTextSize(0, getResources().getDimensionPixelSize(e.C0210e.fontsize28));
        al.b(this.aVq, e.d.cp_cont_i, 1, 0);
        this.aVq.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(e.C0210e.ds16);
        this.aVq.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        this.aVq.setMinWidth(getResources().getDimensionPixelSize(e.C0210e.ds222));
        this.aVq.setMinHeight(getResources().getDimensionPixelSize(e.C0210e.ds60));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(e.C0210e.fontsize40);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        this.aVq.setOnClickListener(this);
        this.aVq.setVisibility(8);
        addView(this.aVq, layoutParams);
    }

    public void setIsCanDrag(boolean z) {
        this.aUo = z;
    }

    public void setIsHotSort(boolean z) {
        this.aUp = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        Bitmap imageBitmap;
        int height;
        int width;
        if (!this.aUo || !this.aVx) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.aVz && motionEvent.getPointerCount() >= 2) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.aVz || this.aVA) {
            requestDisallowInterceptTouchEvent(true);
        }
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        float x = motionEvent.getX();
        int i = action & 255;
        if (i == 0) {
            if (this.aVB == null) {
                if (this.aVt.getVisibility() == 0) {
                    this.aVB = com.baidu.tbadk.util.e.ae(this.aVt);
                } else {
                    this.aVB = com.baidu.tbadk.util.e.ae(this.aVp);
                }
            }
            if (this.aVF == null && this.aVB != null) {
                int measuredWidth = getMeasuredWidth();
                float measuredWidth2 = ((getMeasuredWidth() * 1.0f) / this.aVB.getWidth()) * this.aVB.getHeight();
                if (measuredWidth2 > getMeasuredHeight()) {
                    measuredWidth2 = getMeasuredHeight();
                }
                RectF h = h(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
                this.aVF = new Rect((int) h.left, (int) h.top, (int) h.right, (int) h.bottom);
            }
            if (this.aVJ == null && this.aVB != null) {
                if (this.aVt.getVisibility() == 0) {
                    height = this.aVt.getSHeight();
                    width = this.aVt.getSWidth();
                } else {
                    if (this.aVp.getImageType() == 1) {
                        imageBitmap = (this.aVp.getCurrentFrame() == null || this.aVp.getCurrentFrame().bkN == null) ? this.aVB : this.aVp.getCurrentFrame().bkN;
                    } else {
                        imageBitmap = this.aVp.getImageBitmap() == null ? this.aVB : this.aVp.getImageBitmap();
                    }
                    height = imageBitmap.getHeight();
                    width = imageBitmap.getWidth();
                }
                float aR = l.aR(getContext());
                int i2 = (int) (height * aR);
                int i3 = (int) (width * aR);
                if (i3 > this.aVB.getWidth() && this.aVB.getWidth() != 0) {
                    float width2 = (i3 * 1.0f) / this.aVB.getWidth();
                    i3 = this.aVB.getWidth();
                    i2 = (int) (i2 / width2);
                }
                if (i2 > this.aVB.getHeight() && this.aVB.getHeight() != 0) {
                    i3 = (int) (i3 / ((i2 * 1.0f) / this.aVB.getHeight()));
                    i2 = this.aVB.getHeight();
                }
                int aQ = (l.aQ(getContext()) - i2) / 2;
                int aO = (l.aO(getContext()) - i3) / 2;
                this.aVJ = new Rect(aO, aQ, i3 + aO, i2 + aQ);
                this.aVK = new Rect(this.aVJ);
                this.aVS = aQ / l.aQ(getContext());
                this.aVI = new Rect(0, 0, this.aVB.getWidth(), this.aVB.getHeight());
            }
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (i == 2) {
            this.aVz = o(this.mLastMotionX - x, this.mLastMotionY - y);
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (this.aVz || this.aVA) {
            this.aVp.setImageOnLongClickListener(null);
            this.aVt.setOnLongClickListener(null);
            z = true;
        } else {
            this.aVp.setImageOnLongClickListener(this.aWd);
            this.aVt.setOnLongClickListener(this.aWd);
            z = super.dispatchTouchEvent(motionEvent);
        }
        if (i == 1 || i == 3) {
            this.mLastMotionX = 0.0f;
            this.mLastMotionY = 0.0f;
            this.aVC = false;
            this.aVE.reset();
            this.aVz = false;
            if (this.aVD > aVM) {
                this.aVA = true;
                KR();
                return z;
            }
            if (this.aVL != null) {
                this.aVL.Rf();
            }
            this.mRatio = 1.0f;
            invalidate();
            return z;
        }
        return z;
    }

    private boolean o(float f, float f2) {
        if (this.aVt.getVisibility() != 0 || this.aVt.isCanDrag()) {
            if (this.aVT == null || !this.aVT.isLongPic || this.aVt.getVisibility() != 0 || this.aVt.isViewTop()) {
                if (this.aVT == null || !this.aVT.isLongPic || this.aVt.getVisibility() == 0 || this.aVp.QL()) {
                    if (this.aVt.getVisibility() == 0 || this.aVp.QN()) {
                        if (this.aVB != null && getScrollY() == 0 && f2 < 0.0f && !this.aVC) {
                            this.aVC = true;
                            this.aVD = 0.0f;
                            this.mRatio = 1.0f;
                            if (this.aVL != null) {
                                this.aVL.Rd();
                            }
                        }
                        if (this.aVC) {
                            this.aVD -= f2;
                            int measuredHeight = getMeasuredHeight();
                            if (this.aVD > measuredHeight) {
                                this.aVD = measuredHeight;
                            }
                            float f3 = f2 / measuredHeight;
                            this.aVE.postTranslate((-f) * 1.5f * this.mRatio, (-1.5f) * f2 * this.mRatio);
                            if (this.mRatio * (1.0f + f3) > 1.0f || this.aVD < 0.0f) {
                                this.aVE.preScale(1.0f / this.mRatio, 1.0f / this.mRatio, (this.mRatio * this.aVB.getWidth()) / 2.0f, this.mRatio * (this.aVB.getHeight() / 2));
                                this.mRatio = 1.0f;
                            } else {
                                this.aVE.preScale(1.0f + f3, 1.0f + f3, (this.mRatio * this.aVB.getWidth()) / 2.0f, this.mRatio * (this.aVB.getHeight() / 2));
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
        if (this.aVz && this.aVB != null && !this.aVB.isRecycled() && this.aVC) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.aVG == null) {
                this.aVG = new RectF();
            }
            this.aVE.mapRect(this.aVG, new RectF(this.aVF));
            canvas.drawBitmap(this.aVB, this.aVI, this.aVG, (Paint) null);
        } else if (this.aVA && this.aVB != null && !this.aVB.isRecycled()) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.aVT == null || this.aVT.getSourceImageRectInScreen() == null) {
                canvas.drawBitmap(this.aVB, this.aVI, this.aVG, (Paint) null);
            } else {
                canvas.drawBitmap(this.aVB, this.aVJ, this.aVG, (Paint) null);
            }
        } else {
            super.dispatchDraw(canvas);
        }
    }

    private void KR() {
        if (this.aVT == null) {
            if (this.aVL != null) {
                this.aVL.Re();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.aVT.getSourceImageRectInScreen();
        final Rect dstRectInScreen = this.aVT.getDstRectInScreen();
        if (sourceImageRectInScreen == null || dstRectInScreen == null) {
            if (this.aVL != null) {
                this.aVL.Re();
                return;
            }
            return;
        }
        a(sourceImageRectInScreen, dstRectInScreen);
        e(sourceImageRectInScreen);
        this.aVH = new RectF(this.aVG);
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
                UrlDragImageView.this.aVC = false;
                UrlDragImageView.this.invalidate();
                if (UrlDragImageView.this.aVL != null) {
                    UrlDragImageView.this.aVL.Re();
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
            float f = ((rect.bottom - rect.top) / (rect.right - rect.left)) * (this.aVG.right - this.aVG.left);
            this.aVG.top += this.aVG.height() * this.aVS;
            this.aVG.bottom = f + this.aVG.top;
        }
    }

    public void setCanScale(boolean z) {
        if (this.aVp != null) {
            this.aVp.setCanScale(z);
        }
    }

    private void a(Rect rect, Rect rect2) {
        this.aVO = 0.0f;
        this.aVP = 0.0f;
        this.aVQ = 1.0f;
        this.aVR = 1.0f;
        if (rect != null && rect2 != null && rect.contains(rect2)) {
            this.aVO = (rect2.left - rect.left) / rect.width();
            this.aVP = (rect2.top - rect.top) / rect.height();
            this.aVQ = (rect2.right - rect.left) / rect.width();
            this.aVR = (rect2.bottom - rect.top) / rect.height();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa(float f) {
        if (this.aVJ != null) {
            this.aVJ.left = (int) (this.aVK.left + (this.aVK.width() * this.aVO * f));
            this.aVJ.top = (int) (this.aVK.top + (this.aVK.height() * this.aVP * f));
            this.aVJ.right = (int) (this.aVK.left + (this.aVK.width() * (((1.0f - this.aVQ) * (1.0f - f)) + this.aVQ)));
            this.aVJ.bottom = (int) (this.aVK.top + (this.aVK.height() * (((1.0f - this.aVR) * (1.0f - f)) + this.aVR)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Rect rect, float f) {
        if (this.aVG != null && rect != null) {
            this.aVG.left = this.aVH.left + ((rect.left - this.aVH.left) * f);
            this.aVG.top = this.aVH.top + ((rect.top - this.aVH.top) * f);
            this.aVG.right = this.aVH.right + ((rect.right - this.aVH.right) * f);
            this.aVG.bottom = this.aVH.bottom + ((rect.bottom - this.aVH.bottom) * f);
        }
    }

    private RectF h(float f, float f2, float f3, float f4) {
        return new RectF(f - (f3 / 2.0f), f2 - (f4 / 2.0f), (f3 / 2.0f) + f, (f4 / 2.0f) + f2);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.aWa = onTouchListener;
    }

    private void KS() {
        this.aVY = new TextView(this.mContext);
        this.aVY.setBackgroundResource(e.f.bg_url_drag_imagview_fade_view);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.height = getResources().getDimensionPixelSize(e.C0210e.ds180);
        layoutParams.addRule(12);
        addView(this.aVY, layoutParams);
        this.aVY.setVisibility(8);
    }

    private void KT() {
        this.aVr = new TextView(this.mContext);
        al.j(this.aVr, e.d.common_color_10022);
        this.aVr.setText(e.j.goto_pb_floor);
        this.aVr.setTextSize(0, getResources().getDimensionPixelSize(e.C0210e.fontsize28));
        al.b(this.aVr, e.d.cp_cont_i, 1, 0);
        this.aVr.setCompoundDrawablePadding(l.dip2px(this.mContext, 4.0f));
        this.aVr.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_see_arrow), (Drawable) null);
        this.aVr.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(e.C0210e.ds20);
        this.aVr.setPadding(dimensionPixelSize * 3, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(e.C0210e.ds30);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(e.C0210e.ds10);
        layoutParams.leftMargin = getResources().getDimensionPixelSize(e.C0210e.ds20);
        layoutParams.addRule(1, this.aVq.getId());
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        this.aVr.setOnClickListener(this);
        this.aVr.setMinHeight(getResources().getDimensionPixelSize(e.C0210e.ds100));
        addView(this.aVr, layoutParams);
        this.aVr.setVisibility(8);
    }

    private void KU() {
        if (this.aVr != null) {
            boolean z = this.aVw || this.aVx;
            if (!this.aVW && z && this.aVT != null && this.aVT.threadId > 0 && this.aVT.postId > 0 && this.aVT.mThreadType != 33 && !this.aVT.isBlockedPic && !this.aUp) {
                this.aVr.setVisibility(0);
                if (this.aVY != null) {
                    this.aVY.setVisibility(0);
                    return;
                }
                return;
            }
            this.aVr.setVisibility(8);
            if (this.aVY != null) {
                this.aVY.setVisibility(8);
            }
        }
    }

    private void KV() {
        if (this.aVr != null) {
            this.aVr.setVisibility(8);
            if (this.aVY != null) {
                this.aVY.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KW() {
        if ((this.aVw || this.aVx) && this.aVT != null && this.aVT.mPicType == 1 && !TextUtils.isEmpty(this.aVT.mTagName)) {
            if (this.aVs != null) {
                this.aVs.setVisibility(8);
                this.aVs = null;
            }
            this.aVs = new TextView(this.mContext);
            this.aVs.setText(this.aVT.mTagName);
            this.aVs.setTextSize(0, getResources().getDimensionPixelSize(e.C0210e.fontsize26));
            al.b(this.aVs, e.d.common_color_10013, 1, 0);
            al.j(this.aVs, e.d.common_color_10215);
            this.aVs.setAlpha(0.75f);
            this.aVs.setIncludeFontPadding(false);
            this.aVs.setGravity(17);
            int h = l.h(this.mContext, e.C0210e.ds2);
            this.aVs.setPadding(h, h, h, h);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.aVp.getBottomOffset();
            layoutParams.leftMargin = this.aVp.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.aVs, layoutParams);
            this.aVs.setVisibility(0);
        }
    }

    public void cg(boolean z) {
        this.aVW = z;
        if (this.aVW) {
            KV();
        } else {
            KU();
        }
    }

    public void setUrl(String str, boolean z) {
        if (str.contains("*")) {
            str = str.split("[*]")[0];
        }
        this.aVp.setTag(str);
        this.aVp.setLoadBigImage(false);
        this.aVp.setImageDrawable(null);
        this.aVw = false;
        this.aVx = false;
        this.aVU = Ld();
        this.aVq.setVisibility(8);
        if (hx(str)) {
            b(str, z, false);
        }
    }

    private boolean KX() {
        return this.aVp != null && this.aVp.Rb();
    }

    public void KY() {
        if (this.aVT != null && !KX()) {
            String str = this.aVT.imageUrl;
            int i = this.aVT.urlType;
            com.baidu.adp.widget.ImageView.a aVar = null;
            if (com.baidu.tbadk.core.util.d.a.D(str, i)) {
                aVar = com.baidu.tbadk.core.util.d.a.E(str, i);
            }
            if (aVar != null) {
                setThumbBitmapToView(aVar);
            }
        }
    }

    private boolean ch(boolean z) {
        String fY;
        if (!this.aVV || z) {
            this.aVV = true;
            if (!this.aVU || this.aVT == null || StringUtils.isNull(this.aVT.originalUrl, true) || this.aVT.originalSize < 0 || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String str = this.aVN + an.DZ().fQ(fY) + "/" + ar.fY(this.aVT.originalUrl);
            final int[] fr = com.baidu.tbadk.core.util.l.fr(str);
            this.aVt.setVisibility(0);
            if (this.aVu == null) {
                this.aVu = new SubsamplingScaleImageView.OnImageEventListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12
                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onReady() {
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.aVp.QX();
                        UrlDragImageView.this.aVp.setVisibility(4);
                    }

                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onImageLoaded() {
                        if (UrlDragImageView.this.aVT.isLongPic && fr[0] > 0) {
                            UrlDragImageView.this.aVp.onDestroy();
                            final float measuredWidth = (UrlDragImageView.this.getMeasuredWidth() * 1.0f) / fr[0];
                            final PointF pointF = new PointF((fr[0] * 1.0f) / 2.0f, 0.0f);
                            UrlDragImageView.this.aVt.setScaleAndCenter(measuredWidth, pointF);
                            UrlDragImageView.this.aVt.setMaxScale(2.0f * measuredWidth);
                            UrlDragImageView.this.aVt.setDoubleTapZoomScale(2.0f * measuredWidth);
                            UrlDragImageView.this.aVt.setInitScale(measuredWidth);
                            UrlDragImageView.this.aVt.setDoubleTapZoomStyle(4);
                            UrlDragImageView.this.aVt.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12.1
                                @Override // android.view.View.OnTouchListener
                                public boolean onTouch(View view, MotionEvent motionEvent) {
                                    if (UrlDragImageView.this.aWa != null) {
                                        UrlDragImageView.this.aWa.onTouch(view, motionEvent);
                                    }
                                    switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                                        case 0:
                                            UrlDragImageView.this.aWc = motionEvent.getY();
                                            UrlDragImageView.this.aVt.setOnClickListener(UrlDragImageView.this.aWb ? UrlDragImageView.this.mOnClickListener : null);
                                            UrlDragImageView.this.aVt.setOnLongClickListener(UrlDragImageView.this.aWb ? UrlDragImageView.this.aWd : null);
                                            break;
                                        case 1:
                                        case 3:
                                            if (UrlDragImageView.this.aVt.getScale() < measuredWidth) {
                                                UrlDragImageView.this.aVt.setScaleAndCenter(measuredWidth, pointF);
                                            }
                                            com.baidu.adp.lib.g.e.jG().removeCallbacks(UrlDragImageView.this.aWe);
                                            com.baidu.adp.lib.g.e.jG().postDelayed(UrlDragImageView.this.aWe, 1000L);
                                            break;
                                        case 2:
                                            if (Math.abs(motionEvent.getY() - UrlDragImageView.this.aWc) > UrlDragImageView.TOUCH_SLOP) {
                                                UrlDragImageView.this.aWb = false;
                                                UrlDragImageView.this.aVt.setOnClickListener(null);
                                                UrlDragImageView.this.aVt.setOnLongClickListener(null);
                                            }
                                            UrlDragImageView.this.aWc = motionEvent.getY();
                                            break;
                                    }
                                    return false;
                                }
                            });
                            UrlDragImageView.this.aVp.setVisibility(4);
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
            this.aVt.setOnImageEventListener(this.aVu);
            if (this.aVt.isImageLoaded() && this.aVT.isLongPic) {
                this.aVu.onImageLoaded();
            } else {
                this.aVt.setImage(ImageSource.uri(str));
            }
            return true;
        }
        return false;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.aVL = dVar;
        if (this.aVp != null) {
            this.aVp.setDragToExitListener(dVar);
        }
    }

    public void KZ() {
        ch(false);
    }

    private boolean hx(String str) {
        return j.kV() || c.gp(str);
    }

    private void setThumbBitmapToView(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap ot;
        if (!this.aVx && aVar != null && (ot = aVar.ot()) != null) {
            this.aVw = true;
            if (aVar.isGif()) {
                this.aVp.setImageUrlData(this.aVT);
                this.aVp.setImageBitmap(ot);
                this.aVq.setVisibility(8);
                this.aVX = false;
            } else {
                if (this.aVT != null && this.aVT.isLongPic) {
                    this.aVp.QQ();
                    this.aVp.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.13
                        @Override // com.baidu.tbadk.widget.largeImage.logic.a
                        public void Lh() {
                        }
                    });
                }
                this.aVp.setImageUrlData(this.aVT);
                this.aVp.setImageData(ot, aVar.oy());
            }
            KU();
            KW();
        }
    }

    private void b(String str, boolean z, boolean z2) {
        if (hy(str)) {
            if (z2 || (!this.aVy && !this.aVx)) {
                if (!z2 || !ch(true)) {
                    this.aVy = true;
                    com.baidu.adp.lib.f.c.jA().a(str, 27, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.14
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onCancelled(String str2) {
                            UrlDragImageView.this.aVy = false;
                            UrlDragImageView.this.aVp.setVisibility(0);
                            UrlDragImageView.this.mProgressBar.setVisibility(8);
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            UrlDragImageView.this.aVy = false;
                            UrlDragImageView.this.aVx = true;
                            UrlDragImageView.this.b(aVar);
                        }
                    }, 0, 0, false, null, Boolean.valueOf(z), this.aVp.getImageData(), Boolean.valueOf(this.aUl));
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
        com.baidu.adp.widget.ImageView.a a2 = this.aVZ.a(imageFileInfo, false);
        if (a2 != null) {
            this.aVx = true;
            this.mProgressBar.setVisibility(8);
            b(a2);
            return;
        }
        this.aVZ.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.2
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.ImageView.a aVar, String str2, boolean z3) {
                UrlDragImageView.this.aVx = true;
                UrlDragImageView.this.mProgressBar.setVisibility(8);
                UrlDragImageView.this.b(aVar);
            }
        }, false);
    }

    private boolean hy(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null && this.aVv != null) {
            this.aVv.j(aVar.getUrl(), aVar.oy());
        }
        if (aVar == null || aVar.ot() == null) {
            La();
            return;
        }
        Bitmap ot = aVar.ot();
        this.aVp.setLoadBigImage(true);
        if (aVar.isGif()) {
            this.aVp.setGifData(aVar.oy(), ot);
            this.aVp.invalidate();
            this.aVp.play();
            this.aVX = false;
            this.aVq.setVisibility(8);
            this.mProgressBar.setVisibility(8);
        } else {
            if (this.aVT != null && this.aVT.isLongPic) {
                this.aVp.QQ();
                this.aVp.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.3
                    @Override // com.baidu.tbadk.widget.largeImage.logic.a
                    public void Lh() {
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                    }
                });
            } else {
                this.mProgressBar.setVisibility(8);
            }
            this.aVp.setImageUrlData(this.aVT);
            this.aVp.setImageData(ot, aVar.oy());
            Le();
        }
        KU();
        KW();
    }

    private void La() {
        if (!this.aVw) {
            this.aVp.setDefaultBitmap();
        } else {
            this.aVx = false;
        }
        this.aVq.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    public void setGifMaxUseableMem(int i) {
        this.aVp.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.aVp != null) {
            this.aVp.onDestroy();
        }
        if (this.aVt != null) {
            this.aVt.recycle();
        }
        if (this.aVB != null) {
            this.aVB.recycle();
            this.aVB = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.aWe);
    }

    public void release() {
        if (this.aVp != null) {
            this.aVp.release();
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.aVq != null) {
            this.aVq.setVisibility(8);
        }
    }

    public void Lb() {
        if (this.aVp != null && this.aVp.getImageType() == 1) {
            this.aVp.stop();
        }
    }

    public void k(boolean z, boolean z2) {
        String str;
        if (this.aVp != null && (str = (String) this.aVp.getTag()) != null) {
            if (this.aVp.getImageType() == 1) {
                if (this.aVp.getGifCache() == null || !this.aVp.Rb()) {
                    b(str, z, z2);
                }
            } else if (this.aVp.getImageType() == 2) {
                b(str, z, z2);
            } else if (Lc()) {
                b(str, z, z2);
            }
        }
    }

    private boolean Lc() {
        if (this.aVp.getImageBitmap() != null && this.aVp.Rb()) {
            if (this.aVT == null || !this.aVT.isLongPic || this.aVp.QR()) {
                return false;
            }
            this.aVx = false;
            this.aVV = false;
            return true;
        }
        return true;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.aVT = imageUrlData;
    }

    public void setIsCdn(boolean z) {
        this.aUl = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aVq) {
            if (!(this.aVq.getTag() instanceof Boolean) || ((Boolean) this.aVq.getTag()).booleanValue()) {
                final String fY = ar.fY(this.aVT.originalUrl);
                if (this.aVT.originalProcess >= 0) {
                    com.baidu.tbadk.download.d.Mj().G(fY, 13);
                    this.aVT.originalProcess = -1;
                    Le();
                    return;
                }
                if (this.aUn != null) {
                    this.aUn.Li();
                }
                com.baidu.adp.base.e<?> aK = i.aK(this.mContext);
                if (aK == null) {
                    hz(fY);
                } else if (!j.kV() || j.kW() || com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("original_img_down_tip", false)) {
                    hz(fY);
                } else {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("original_img_down_tip", true);
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(aK.getPageActivity());
                    aVar.db(e.j.original_img_down_no_wifi_tip);
                    aVar.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.4
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar.dismiss();
                            UrlDragImageView.this.hz(fY);
                        }
                    });
                    aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.5
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar.dismiss();
                        }
                    });
                    aVar.b(aK);
                    aVar.BS();
                }
            }
        } else if (view == this.aVr && this.aVT != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.mContext).createHistoryCfg(String.valueOf(this.aVT.threadId), String.valueOf(this.aVT.postId), this.aVT.mIsSeeHost, this.aVT.mIsReserver, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hz(String str) {
        if (this.aVT != null) {
            this.aVT.originalProcess = 0;
            this.aVq.setText("0%");
            this.aVq.setCompoundDrawablesWithIntrinsicBounds(0, 0, e.f.icon_close_yuantu, 0);
            DownloadData downloadData = new DownloadData(str);
            downloadData.setStatus(1);
            downloadData.setUrl(this.aVT.originalUrl);
            downloadData.setType(13);
            downloadData.setPath(this.aVN + an.DZ().fQ(str) + "/" + str);
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.6
                @Override // com.baidu.tbadk.download.c
                public boolean onPreDownload(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2 != null) {
                        if (UrlDragImageView.this.aVT != null && UrlDragImageView.this.aVT.originalProcess != -1) {
                            UrlDragImageView.this.aVT.originalProcess = downloadData2.getProcess();
                        }
                        if (UrlDragImageView.this.aVT == null || UrlDragImageView.this.aVT.originalProcess != -1) {
                            UrlDragImageView.this.aVq.setText(downloadData2.getProcess() + "%");
                            UrlDragImageView.this.aVq.setCompoundDrawablesWithIntrinsicBounds(0, 0, e.f.icon_close_yuantu, 0);
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public boolean onFileDownloaded(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadSucceed(DownloadData downloadData2) {
                    UrlDragImageView.this.aVq.setText(UrlDragImageView.this.getResources().getString(e.j.done));
                    UrlDragImageView.this.aVq.setTag(false);
                    UrlDragImageView.this.aVq.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    com.baidu.adp.lib.g.e.jG().postDelayed(UrlDragImageView.this.aWf, 1500L);
                    UrlDragImageView.this.aVV = false;
                    UrlDragImageView.this.aVU = UrlDragImageView.this.Ld();
                    UrlDragImageView.this.KZ();
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str2) {
                    UrlDragImageView.this.aVV = false;
                    BdToast.a(UrlDragImageView.this.mContext, str2).BY().Ca();
                    UrlDragImageView.this.aVT.originalProcess = -1;
                    UrlDragImageView.this.Le();
                }
            });
            com.baidu.tbadk.download.d.Mj().a(downloadData, 100);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ld() {
        if (this.aVT != null && !StringUtils.isNull(this.aVT.originalUrl, true) && this.aVT.originalSize >= 0 && !this.aVT.isBlockedPic) {
            String fY = ar.fY(this.aVT.originalUrl);
            File file = new File(this.aVN + an.DZ().fQ(fY) + "/" + fY);
            if (file != null && file.exists()) {
                this.aVT.originalProcess = 100;
                return true;
            }
            if (this.aVT.originalProcess < 0) {
                Le();
            } else {
                this.aVq.setText(this.aVT.originalProcess + "%");
                this.aVq.setCompoundDrawablesWithIntrinsicBounds(0, 0, e.f.icon_close_yuantu, 0);
            }
            this.aVX = true;
        } else {
            this.aVq.setVisibility(8);
        }
        return false;
    }

    public void Le() {
        if (this.aVT != null) {
            if (!Lf() || !this.aVX) {
                this.aVq.setVisibility(8);
            } else {
                this.aVq.setVisibility(0);
            }
            if (this.aVT.originalSize > 0 && !an(this.aVT.originalSize)) {
                this.aVq.setText(aVn + "(" + ao.ac(this.aVT.originalSize) + ")");
            } else {
                this.aVq.setText(aVn);
            }
            this.aVq.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    private boolean Lf() {
        return (this.aVT == null || !this.aVT.mIsShowOrigonButton || this.aVT.isBlockedPic || StringUtils.isNull(this.aVT.originalUrl)) ? false : true;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.aUn = bVar;
    }

    private boolean an(long j) {
        return j > aVo;
    }
}
