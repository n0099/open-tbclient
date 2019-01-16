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
    private boolean aUk;
    private b aUm;
    private boolean aUn;
    private boolean aUo;
    private Bitmap aVA;
    private boolean aVB;
    private float aVC;
    private Matrix aVD;
    private Rect aVE;
    private RectF aVF;
    private RectF aVG;
    private Rect aVH;
    private Rect aVI;
    private Rect aVJ;
    private DragImageView.d aVK;
    private String aVM;
    private float aVN;
    private float aVO;
    private float aVP;
    private float aVQ;
    private float aVR;
    private ImageUrlData aVS;
    private boolean aVT;
    private boolean aVU;
    private boolean aVV;
    public boolean aVW;
    private TextView aVX;
    private com.baidu.tbadk.img.b aVY;
    private View.OnTouchListener aVZ;
    protected DragImageView aVo;
    protected TextView aVp;
    protected TextView aVq;
    protected TextView aVr;
    protected SubsamplingScaleImageView aVs;
    private SubsamplingScaleImageView.OnImageEventListener aVt;
    private a aVu;
    private boolean aVv;
    private boolean aVw;
    private boolean aVx;
    private boolean aVy;
    private boolean aVz;
    private boolean aWa;
    private float aWb;
    private View.OnLongClickListener aWc;
    private Runnable aWd;
    private Runnable aWe;
    private View.OnTouchListener aWf;
    protected Context mContext;
    private float mLastMotionX;
    private float mLastMotionY;
    private int mMaxHeight;
    private int mMaxWidth;
    private View.OnClickListener mOnClickListener;
    protected ProgressBar mProgressBar;
    private float mRatio;
    private int mSkinType;
    private static final String aVm = TbadkCoreApplication.getInst().getString(e.j.original_img_look);
    private static long aVn = Config.RAVEN_LOG_LIMIT;
    private static final int aVL = l.aQ(TbadkCoreApplication.getInst()) / 5;
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
            if (this.aVp != null) {
                al.i(this.aVp, e.f.btn_percent_yuantu);
                al.b(this.aVp, e.d.cp_cont_g, 1, 0);
            }
            if (this.aVq != null) {
                al.j(this.aVq, e.d.common_color_10022);
                al.b(this.aVq, e.d.cp_cont_g, 1, 0);
            }
            this.mSkinType = i;
        }
    }

    public void setHeadImage(boolean z) {
        if (this.aVo != null) {
            this.aVo.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.aVu = aVar;
    }

    public UrlDragImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mContext = null;
        this.mProgressBar = null;
        this.aVo = null;
        this.aVu = null;
        this.aUk = false;
        this.aVx = false;
        this.aVB = false;
        this.mRatio = 1.0f;
        this.aVC = 0.0f;
        this.aVD = new Matrix();
        this.aVF = new RectF();
        this.aVN = 0.0f;
        this.aVO = 0.0f;
        this.aVP = 1.0f;
        this.aVQ = 1.0f;
        this.aVR = 0.0f;
        this.aVT = false;
        this.aVU = false;
        this.aVV = false;
        this.aVW = false;
        this.aVX = null;
        this.aWa = true;
        this.aWb = 0.0f;
        this.mOnClickListener = null;
        this.aWc = null;
        this.aWd = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.aWa = true;
            }
        };
        this.aWe = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.aVp.setVisibility(8);
                        UrlDragImageView.this.aVW = false;
                    }
                });
                UrlDragImageView.this.aVp.startAnimation(alphaAnimation);
            }
        };
        this.aWf = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.aVZ != null) {
                    UrlDragImageView.this.aVZ.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.aVY = new com.baidu.tbadk.img.b();
        init();
    }

    public UrlDragImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.mContext = null;
        this.mProgressBar = null;
        this.aVo = null;
        this.aVu = null;
        this.aUk = false;
        this.aVx = false;
        this.aVB = false;
        this.mRatio = 1.0f;
        this.aVC = 0.0f;
        this.aVD = new Matrix();
        this.aVF = new RectF();
        this.aVN = 0.0f;
        this.aVO = 0.0f;
        this.aVP = 1.0f;
        this.aVQ = 1.0f;
        this.aVR = 0.0f;
        this.aVT = false;
        this.aVU = false;
        this.aVV = false;
        this.aVW = false;
        this.aVX = null;
        this.aWa = true;
        this.aWb = 0.0f;
        this.mOnClickListener = null;
        this.aWc = null;
        this.aWd = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.aWa = true;
            }
        };
        this.aWe = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.aVp.setVisibility(8);
                        UrlDragImageView.this.aVW = false;
                    }
                });
                UrlDragImageView.this.aVp.startAnimation(alphaAnimation);
            }
        };
        this.aWf = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.aVZ != null) {
                    UrlDragImageView.this.aVZ.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.aVY = new com.baidu.tbadk.img.b();
        init();
    }

    public DragImageView getImageView() {
        return this.aVo;
    }

    public void setGifSetListener(DragImageView.e eVar) {
        this.aVo.setGifSetListener(eVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.aVo.setImageOnClickListener(onClickListener);
        this.aVs.setOnClickListener(onClickListener);
        this.mOnClickListener = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aWc = onLongClickListener;
        if (!this.aUn) {
            this.aVo.setImageOnLongClickListener(this.aWc);
            this.aVs.setOnLongClickListener(this.aWc);
        }
    }

    public void setOnSizeChangedListener(final DragImageView.g gVar) {
        this.aVo.setOnSizeChangedListener(new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.8
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
        this.aVo = new DragImageView(this.mContext);
        this.aVo.setLayoutParams(layoutParams);
        this.aVo.setOnTouchListener(this.aWf);
        addView(this.aVo);
        this.aVs = new SubsamplingScaleImageView(this.mContext);
        this.aVs.setMaxScale(50.0f);
        this.aVs.setOnTouchListener(this.aWf);
        this.aVs.setVisibility(4);
        addView(this.aVs, layoutParams);
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
        this.aVM = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        this.aVp = new TextView(this.mContext);
        al.i(this.aVp, e.f.btn_percent_yuantu);
        this.aVp.setText(e.j.original_img_look);
        this.aVp.setTextSize(0, getResources().getDimensionPixelSize(e.C0210e.fontsize28));
        al.b(this.aVp, e.d.cp_cont_i, 1, 0);
        this.aVp.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(e.C0210e.ds16);
        this.aVp.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        this.aVp.setMinWidth(getResources().getDimensionPixelSize(e.C0210e.ds222));
        this.aVp.setMinHeight(getResources().getDimensionPixelSize(e.C0210e.ds60));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(e.C0210e.fontsize40);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        this.aVp.setOnClickListener(this);
        this.aVp.setVisibility(8);
        addView(this.aVp, layoutParams);
    }

    public void setIsCanDrag(boolean z) {
        this.aUn = z;
    }

    public void setIsHotSort(boolean z) {
        this.aUo = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        Bitmap imageBitmap;
        int height;
        int width;
        if (!this.aUn || !this.aVw) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.aVy && motionEvent.getPointerCount() >= 2) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.aVy || this.aVz) {
            requestDisallowInterceptTouchEvent(true);
        }
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        float x = motionEvent.getX();
        int i = action & 255;
        if (i == 0) {
            if (this.aVA == null) {
                if (this.aVs.getVisibility() == 0) {
                    this.aVA = com.baidu.tbadk.util.e.ae(this.aVs);
                } else {
                    this.aVA = com.baidu.tbadk.util.e.ae(this.aVo);
                }
            }
            if (this.aVE == null && this.aVA != null) {
                int measuredWidth = getMeasuredWidth();
                float measuredWidth2 = ((getMeasuredWidth() * 1.0f) / this.aVA.getWidth()) * this.aVA.getHeight();
                if (measuredWidth2 > getMeasuredHeight()) {
                    measuredWidth2 = getMeasuredHeight();
                }
                RectF h = h(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
                this.aVE = new Rect((int) h.left, (int) h.top, (int) h.right, (int) h.bottom);
            }
            if (this.aVI == null && this.aVA != null) {
                if (this.aVs.getVisibility() == 0) {
                    height = this.aVs.getSHeight();
                    width = this.aVs.getSWidth();
                } else {
                    if (this.aVo.getImageType() == 1) {
                        imageBitmap = (this.aVo.getCurrentFrame() == null || this.aVo.getCurrentFrame().bkM == null) ? this.aVA : this.aVo.getCurrentFrame().bkM;
                    } else {
                        imageBitmap = this.aVo.getImageBitmap() == null ? this.aVA : this.aVo.getImageBitmap();
                    }
                    height = imageBitmap.getHeight();
                    width = imageBitmap.getWidth();
                }
                float aR = l.aR(getContext());
                int i2 = (int) (height * aR);
                int i3 = (int) (width * aR);
                if (i3 > this.aVA.getWidth() && this.aVA.getWidth() != 0) {
                    float width2 = (i3 * 1.0f) / this.aVA.getWidth();
                    i3 = this.aVA.getWidth();
                    i2 = (int) (i2 / width2);
                }
                if (i2 > this.aVA.getHeight() && this.aVA.getHeight() != 0) {
                    i3 = (int) (i3 / ((i2 * 1.0f) / this.aVA.getHeight()));
                    i2 = this.aVA.getHeight();
                }
                int aQ = (l.aQ(getContext()) - i2) / 2;
                int aO = (l.aO(getContext()) - i3) / 2;
                this.aVI = new Rect(aO, aQ, i3 + aO, i2 + aQ);
                this.aVJ = new Rect(this.aVI);
                this.aVR = aQ / l.aQ(getContext());
                this.aVH = new Rect(0, 0, this.aVA.getWidth(), this.aVA.getHeight());
            }
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (i == 2) {
            this.aVy = o(this.mLastMotionX - x, this.mLastMotionY - y);
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (this.aVy || this.aVz) {
            this.aVo.setImageOnLongClickListener(null);
            this.aVs.setOnLongClickListener(null);
            z = true;
        } else {
            this.aVo.setImageOnLongClickListener(this.aWc);
            this.aVs.setOnLongClickListener(this.aWc);
            z = super.dispatchTouchEvent(motionEvent);
        }
        if (i == 1 || i == 3) {
            this.mLastMotionX = 0.0f;
            this.mLastMotionY = 0.0f;
            this.aVB = false;
            this.aVD.reset();
            this.aVy = false;
            if (this.aVC > aVL) {
                this.aVz = true;
                KR();
                return z;
            }
            if (this.aVK != null) {
                this.aVK.Rf();
            }
            this.mRatio = 1.0f;
            invalidate();
            return z;
        }
        return z;
    }

    private boolean o(float f, float f2) {
        if (this.aVs.getVisibility() != 0 || this.aVs.isCanDrag()) {
            if (this.aVS == null || !this.aVS.isLongPic || this.aVs.getVisibility() != 0 || this.aVs.isViewTop()) {
                if (this.aVS == null || !this.aVS.isLongPic || this.aVs.getVisibility() == 0 || this.aVo.QL()) {
                    if (this.aVs.getVisibility() == 0 || this.aVo.QN()) {
                        if (this.aVA != null && getScrollY() == 0 && f2 < 0.0f && !this.aVB) {
                            this.aVB = true;
                            this.aVC = 0.0f;
                            this.mRatio = 1.0f;
                            if (this.aVK != null) {
                                this.aVK.Rd();
                            }
                        }
                        if (this.aVB) {
                            this.aVC -= f2;
                            int measuredHeight = getMeasuredHeight();
                            if (this.aVC > measuredHeight) {
                                this.aVC = measuredHeight;
                            }
                            float f3 = f2 / measuredHeight;
                            this.aVD.postTranslate((-f) * 1.5f * this.mRatio, (-1.5f) * f2 * this.mRatio);
                            if (this.mRatio * (1.0f + f3) > 1.0f || this.aVC < 0.0f) {
                                this.aVD.preScale(1.0f / this.mRatio, 1.0f / this.mRatio, (this.mRatio * this.aVA.getWidth()) / 2.0f, this.mRatio * (this.aVA.getHeight() / 2));
                                this.mRatio = 1.0f;
                            } else {
                                this.aVD.preScale(1.0f + f3, 1.0f + f3, (this.mRatio * this.aVA.getWidth()) / 2.0f, this.mRatio * (this.aVA.getHeight() / 2));
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
        if (this.aVy && this.aVA != null && !this.aVA.isRecycled() && this.aVB) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.aVF == null) {
                this.aVF = new RectF();
            }
            this.aVD.mapRect(this.aVF, new RectF(this.aVE));
            canvas.drawBitmap(this.aVA, this.aVH, this.aVF, (Paint) null);
        } else if (this.aVz && this.aVA != null && !this.aVA.isRecycled()) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.aVS == null || this.aVS.getSourceImageRectInScreen() == null) {
                canvas.drawBitmap(this.aVA, this.aVH, this.aVF, (Paint) null);
            } else {
                canvas.drawBitmap(this.aVA, this.aVI, this.aVF, (Paint) null);
            }
        } else {
            super.dispatchDraw(canvas);
        }
    }

    private void KR() {
        if (this.aVS == null) {
            if (this.aVK != null) {
                this.aVK.Re();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.aVS.getSourceImageRectInScreen();
        final Rect dstRectInScreen = this.aVS.getDstRectInScreen();
        if (sourceImageRectInScreen == null || dstRectInScreen == null) {
            if (this.aVK != null) {
                this.aVK.Re();
                return;
            }
            return;
        }
        a(sourceImageRectInScreen, dstRectInScreen);
        e(sourceImageRectInScreen);
        this.aVG = new RectF(this.aVF);
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
                UrlDragImageView.this.aVB = false;
                UrlDragImageView.this.invalidate();
                if (UrlDragImageView.this.aVK != null) {
                    UrlDragImageView.this.aVK.Re();
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
            float f = ((rect.bottom - rect.top) / (rect.right - rect.left)) * (this.aVF.right - this.aVF.left);
            this.aVF.top += this.aVF.height() * this.aVR;
            this.aVF.bottom = f + this.aVF.top;
        }
    }

    public void setCanScale(boolean z) {
        if (this.aVo != null) {
            this.aVo.setCanScale(z);
        }
    }

    private void a(Rect rect, Rect rect2) {
        this.aVN = 0.0f;
        this.aVO = 0.0f;
        this.aVP = 1.0f;
        this.aVQ = 1.0f;
        if (rect != null && rect2 != null && rect.contains(rect2)) {
            this.aVN = (rect2.left - rect.left) / rect.width();
            this.aVO = (rect2.top - rect.top) / rect.height();
            this.aVP = (rect2.right - rect.left) / rect.width();
            this.aVQ = (rect2.bottom - rect.top) / rect.height();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa(float f) {
        if (this.aVI != null) {
            this.aVI.left = (int) (this.aVJ.left + (this.aVJ.width() * this.aVN * f));
            this.aVI.top = (int) (this.aVJ.top + (this.aVJ.height() * this.aVO * f));
            this.aVI.right = (int) (this.aVJ.left + (this.aVJ.width() * (((1.0f - this.aVP) * (1.0f - f)) + this.aVP)));
            this.aVI.bottom = (int) (this.aVJ.top + (this.aVJ.height() * (((1.0f - this.aVQ) * (1.0f - f)) + this.aVQ)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Rect rect, float f) {
        if (this.aVF != null && rect != null) {
            this.aVF.left = this.aVG.left + ((rect.left - this.aVG.left) * f);
            this.aVF.top = this.aVG.top + ((rect.top - this.aVG.top) * f);
            this.aVF.right = this.aVG.right + ((rect.right - this.aVG.right) * f);
            this.aVF.bottom = this.aVG.bottom + ((rect.bottom - this.aVG.bottom) * f);
        }
    }

    private RectF h(float f, float f2, float f3, float f4) {
        return new RectF(f - (f3 / 2.0f), f2 - (f4 / 2.0f), (f3 / 2.0f) + f, (f4 / 2.0f) + f2);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.aVZ = onTouchListener;
    }

    private void KS() {
        this.aVX = new TextView(this.mContext);
        this.aVX.setBackgroundResource(e.f.bg_url_drag_imagview_fade_view);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.height = getResources().getDimensionPixelSize(e.C0210e.ds180);
        layoutParams.addRule(12);
        addView(this.aVX, layoutParams);
        this.aVX.setVisibility(8);
    }

    private void KT() {
        this.aVq = new TextView(this.mContext);
        al.j(this.aVq, e.d.common_color_10022);
        this.aVq.setText(e.j.goto_pb_floor);
        this.aVq.setTextSize(0, getResources().getDimensionPixelSize(e.C0210e.fontsize28));
        al.b(this.aVq, e.d.cp_cont_i, 1, 0);
        this.aVq.setCompoundDrawablePadding(l.dip2px(this.mContext, 4.0f));
        this.aVq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_see_arrow), (Drawable) null);
        this.aVq.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(e.C0210e.ds20);
        this.aVq.setPadding(dimensionPixelSize * 3, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(e.C0210e.ds30);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(e.C0210e.ds10);
        layoutParams.leftMargin = getResources().getDimensionPixelSize(e.C0210e.ds20);
        layoutParams.addRule(1, this.aVp.getId());
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        this.aVq.setOnClickListener(this);
        this.aVq.setMinHeight(getResources().getDimensionPixelSize(e.C0210e.ds100));
        addView(this.aVq, layoutParams);
        this.aVq.setVisibility(8);
    }

    private void KU() {
        if (this.aVq != null) {
            boolean z = this.aVv || this.aVw;
            if (!this.aVV && z && this.aVS != null && this.aVS.threadId > 0 && this.aVS.postId > 0 && this.aVS.mThreadType != 33 && !this.aVS.isBlockedPic && !this.aUo) {
                this.aVq.setVisibility(0);
                if (this.aVX != null) {
                    this.aVX.setVisibility(0);
                    return;
                }
                return;
            }
            this.aVq.setVisibility(8);
            if (this.aVX != null) {
                this.aVX.setVisibility(8);
            }
        }
    }

    private void KV() {
        if (this.aVq != null) {
            this.aVq.setVisibility(8);
            if (this.aVX != null) {
                this.aVX.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KW() {
        if ((this.aVv || this.aVw) && this.aVS != null && this.aVS.mPicType == 1 && !TextUtils.isEmpty(this.aVS.mTagName)) {
            if (this.aVr != null) {
                this.aVr.setVisibility(8);
                this.aVr = null;
            }
            this.aVr = new TextView(this.mContext);
            this.aVr.setText(this.aVS.mTagName);
            this.aVr.setTextSize(0, getResources().getDimensionPixelSize(e.C0210e.fontsize26));
            al.b(this.aVr, e.d.common_color_10013, 1, 0);
            al.j(this.aVr, e.d.common_color_10215);
            this.aVr.setAlpha(0.75f);
            this.aVr.setIncludeFontPadding(false);
            this.aVr.setGravity(17);
            int h = l.h(this.mContext, e.C0210e.ds2);
            this.aVr.setPadding(h, h, h, h);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.aVo.getBottomOffset();
            layoutParams.leftMargin = this.aVo.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.aVr, layoutParams);
            this.aVr.setVisibility(0);
        }
    }

    public void cg(boolean z) {
        this.aVV = z;
        if (this.aVV) {
            KV();
        } else {
            KU();
        }
    }

    public void setUrl(String str, boolean z) {
        if (str.contains("*")) {
            str = str.split("[*]")[0];
        }
        this.aVo.setTag(str);
        this.aVo.setLoadBigImage(false);
        this.aVo.setImageDrawable(null);
        this.aVv = false;
        this.aVw = false;
        this.aVT = Ld();
        this.aVp.setVisibility(8);
        if (hx(str)) {
            b(str, z, false);
        }
    }

    private boolean KX() {
        return this.aVo != null && this.aVo.Rb();
    }

    public void KY() {
        if (this.aVS != null && !KX()) {
            String str = this.aVS.imageUrl;
            int i = this.aVS.urlType;
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
        if (!this.aVU || z) {
            this.aVU = true;
            if (!this.aVT || this.aVS == null || StringUtils.isNull(this.aVS.originalUrl, true) || this.aVS.originalSize < 0 || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String str = this.aVM + an.DZ().fQ(fY) + "/" + ar.fY(this.aVS.originalUrl);
            final int[] fr = com.baidu.tbadk.core.util.l.fr(str);
            this.aVs.setVisibility(0);
            if (this.aVt == null) {
                this.aVt = new SubsamplingScaleImageView.OnImageEventListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12
                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onReady() {
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.aVo.QX();
                        UrlDragImageView.this.aVo.setVisibility(4);
                    }

                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onImageLoaded() {
                        if (UrlDragImageView.this.aVS.isLongPic && fr[0] > 0) {
                            UrlDragImageView.this.aVo.onDestroy();
                            final float measuredWidth = (UrlDragImageView.this.getMeasuredWidth() * 1.0f) / fr[0];
                            final PointF pointF = new PointF((fr[0] * 1.0f) / 2.0f, 0.0f);
                            UrlDragImageView.this.aVs.setScaleAndCenter(measuredWidth, pointF);
                            UrlDragImageView.this.aVs.setMaxScale(2.0f * measuredWidth);
                            UrlDragImageView.this.aVs.setDoubleTapZoomScale(2.0f * measuredWidth);
                            UrlDragImageView.this.aVs.setInitScale(measuredWidth);
                            UrlDragImageView.this.aVs.setDoubleTapZoomStyle(4);
                            UrlDragImageView.this.aVs.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12.1
                                @Override // android.view.View.OnTouchListener
                                public boolean onTouch(View view, MotionEvent motionEvent) {
                                    if (UrlDragImageView.this.aVZ != null) {
                                        UrlDragImageView.this.aVZ.onTouch(view, motionEvent);
                                    }
                                    switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                                        case 0:
                                            UrlDragImageView.this.aWb = motionEvent.getY();
                                            UrlDragImageView.this.aVs.setOnClickListener(UrlDragImageView.this.aWa ? UrlDragImageView.this.mOnClickListener : null);
                                            UrlDragImageView.this.aVs.setOnLongClickListener(UrlDragImageView.this.aWa ? UrlDragImageView.this.aWc : null);
                                            break;
                                        case 1:
                                        case 3:
                                            if (UrlDragImageView.this.aVs.getScale() < measuredWidth) {
                                                UrlDragImageView.this.aVs.setScaleAndCenter(measuredWidth, pointF);
                                            }
                                            com.baidu.adp.lib.g.e.jG().removeCallbacks(UrlDragImageView.this.aWd);
                                            com.baidu.adp.lib.g.e.jG().postDelayed(UrlDragImageView.this.aWd, 1000L);
                                            break;
                                        case 2:
                                            if (Math.abs(motionEvent.getY() - UrlDragImageView.this.aWb) > UrlDragImageView.TOUCH_SLOP) {
                                                UrlDragImageView.this.aWa = false;
                                                UrlDragImageView.this.aVs.setOnClickListener(null);
                                                UrlDragImageView.this.aVs.setOnLongClickListener(null);
                                            }
                                            UrlDragImageView.this.aWb = motionEvent.getY();
                                            break;
                                    }
                                    return false;
                                }
                            });
                            UrlDragImageView.this.aVo.setVisibility(4);
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
            this.aVs.setOnImageEventListener(this.aVt);
            if (this.aVs.isImageLoaded() && this.aVS.isLongPic) {
                this.aVt.onImageLoaded();
            } else {
                this.aVs.setImage(ImageSource.uri(str));
            }
            return true;
        }
        return false;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.aVK = dVar;
        if (this.aVo != null) {
            this.aVo.setDragToExitListener(dVar);
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
        if (!this.aVw && aVar != null && (ot = aVar.ot()) != null) {
            this.aVv = true;
            if (aVar.isGif()) {
                this.aVo.setImageUrlData(this.aVS);
                this.aVo.setImageBitmap(ot);
                this.aVp.setVisibility(8);
                this.aVW = false;
            } else {
                if (this.aVS != null && this.aVS.isLongPic) {
                    this.aVo.QQ();
                    this.aVo.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.13
                        @Override // com.baidu.tbadk.widget.largeImage.logic.a
                        public void Lh() {
                        }
                    });
                }
                this.aVo.setImageUrlData(this.aVS);
                this.aVo.setImageData(ot, aVar.oy());
            }
            KU();
            KW();
        }
    }

    private void b(String str, boolean z, boolean z2) {
        if (hy(str)) {
            if (z2 || (!this.aVx && !this.aVw)) {
                if (!z2 || !ch(true)) {
                    this.aVx = true;
                    com.baidu.adp.lib.f.c.jA().a(str, 27, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.14
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onCancelled(String str2) {
                            UrlDragImageView.this.aVx = false;
                            UrlDragImageView.this.aVo.setVisibility(0);
                            UrlDragImageView.this.mProgressBar.setVisibility(8);
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            UrlDragImageView.this.aVx = false;
                            UrlDragImageView.this.aVw = true;
                            UrlDragImageView.this.b(aVar);
                        }
                    }, 0, 0, false, null, Boolean.valueOf(z), this.aVo.getImageData(), Boolean.valueOf(this.aUk));
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
        com.baidu.adp.widget.ImageView.a a2 = this.aVY.a(imageFileInfo, false);
        if (a2 != null) {
            this.aVw = true;
            this.mProgressBar.setVisibility(8);
            b(a2);
            return;
        }
        this.aVY.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.2
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.ImageView.a aVar, String str2, boolean z3) {
                UrlDragImageView.this.aVw = true;
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
        if (aVar != null && this.aVu != null) {
            this.aVu.j(aVar.getUrl(), aVar.oy());
        }
        if (aVar == null || aVar.ot() == null) {
            La();
            return;
        }
        Bitmap ot = aVar.ot();
        this.aVo.setLoadBigImage(true);
        if (aVar.isGif()) {
            this.aVo.setGifData(aVar.oy(), ot);
            this.aVo.invalidate();
            this.aVo.play();
            this.aVW = false;
            this.aVp.setVisibility(8);
            this.mProgressBar.setVisibility(8);
        } else {
            if (this.aVS != null && this.aVS.isLongPic) {
                this.aVo.QQ();
                this.aVo.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.3
                    @Override // com.baidu.tbadk.widget.largeImage.logic.a
                    public void Lh() {
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                    }
                });
            } else {
                this.mProgressBar.setVisibility(8);
            }
            this.aVo.setImageUrlData(this.aVS);
            this.aVo.setImageData(ot, aVar.oy());
            Le();
        }
        KU();
        KW();
    }

    private void La() {
        if (!this.aVv) {
            this.aVo.setDefaultBitmap();
        } else {
            this.aVw = false;
        }
        this.aVp.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    public void setGifMaxUseableMem(int i) {
        this.aVo.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.aVo != null) {
            this.aVo.onDestroy();
        }
        if (this.aVs != null) {
            this.aVs.recycle();
        }
        if (this.aVA != null) {
            this.aVA.recycle();
            this.aVA = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.aWd);
    }

    public void release() {
        if (this.aVo != null) {
            this.aVo.release();
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.aVp != null) {
            this.aVp.setVisibility(8);
        }
    }

    public void Lb() {
        if (this.aVo != null && this.aVo.getImageType() == 1) {
            this.aVo.stop();
        }
    }

    public void k(boolean z, boolean z2) {
        String str;
        if (this.aVo != null && (str = (String) this.aVo.getTag()) != null) {
            if (this.aVo.getImageType() == 1) {
                if (this.aVo.getGifCache() == null || !this.aVo.Rb()) {
                    b(str, z, z2);
                }
            } else if (this.aVo.getImageType() == 2) {
                b(str, z, z2);
            } else if (Lc()) {
                b(str, z, z2);
            }
        }
    }

    private boolean Lc() {
        if (this.aVo.getImageBitmap() != null && this.aVo.Rb()) {
            if (this.aVS == null || !this.aVS.isLongPic || this.aVo.QR()) {
                return false;
            }
            this.aVw = false;
            this.aVU = false;
            return true;
        }
        return true;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.aVS = imageUrlData;
    }

    public void setIsCdn(boolean z) {
        this.aUk = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aVp) {
            if (!(this.aVp.getTag() instanceof Boolean) || ((Boolean) this.aVp.getTag()).booleanValue()) {
                final String fY = ar.fY(this.aVS.originalUrl);
                if (this.aVS.originalProcess >= 0) {
                    com.baidu.tbadk.download.d.Mj().G(fY, 13);
                    this.aVS.originalProcess = -1;
                    Le();
                    return;
                }
                if (this.aUm != null) {
                    this.aUm.Li();
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
        } else if (view == this.aVq && this.aVS != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.mContext).createHistoryCfg(String.valueOf(this.aVS.threadId), String.valueOf(this.aVS.postId), this.aVS.mIsSeeHost, this.aVS.mIsReserver, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hz(String str) {
        if (this.aVS != null) {
            this.aVS.originalProcess = 0;
            this.aVp.setText("0%");
            this.aVp.setCompoundDrawablesWithIntrinsicBounds(0, 0, e.f.icon_close_yuantu, 0);
            DownloadData downloadData = new DownloadData(str);
            downloadData.setStatus(1);
            downloadData.setUrl(this.aVS.originalUrl);
            downloadData.setType(13);
            downloadData.setPath(this.aVM + an.DZ().fQ(str) + "/" + str);
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.6
                @Override // com.baidu.tbadk.download.c
                public boolean onPreDownload(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2 != null) {
                        if (UrlDragImageView.this.aVS != null && UrlDragImageView.this.aVS.originalProcess != -1) {
                            UrlDragImageView.this.aVS.originalProcess = downloadData2.getProcess();
                        }
                        if (UrlDragImageView.this.aVS == null || UrlDragImageView.this.aVS.originalProcess != -1) {
                            UrlDragImageView.this.aVp.setText(downloadData2.getProcess() + "%");
                            UrlDragImageView.this.aVp.setCompoundDrawablesWithIntrinsicBounds(0, 0, e.f.icon_close_yuantu, 0);
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public boolean onFileDownloaded(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadSucceed(DownloadData downloadData2) {
                    UrlDragImageView.this.aVp.setText(UrlDragImageView.this.getResources().getString(e.j.done));
                    UrlDragImageView.this.aVp.setTag(false);
                    UrlDragImageView.this.aVp.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    com.baidu.adp.lib.g.e.jG().postDelayed(UrlDragImageView.this.aWe, 1500L);
                    UrlDragImageView.this.aVU = false;
                    UrlDragImageView.this.aVT = UrlDragImageView.this.Ld();
                    UrlDragImageView.this.KZ();
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str2) {
                    UrlDragImageView.this.aVU = false;
                    BdToast.a(UrlDragImageView.this.mContext, str2).BY().Ca();
                    UrlDragImageView.this.aVS.originalProcess = -1;
                    UrlDragImageView.this.Le();
                }
            });
            com.baidu.tbadk.download.d.Mj().a(downloadData, 100);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ld() {
        if (this.aVS != null && !StringUtils.isNull(this.aVS.originalUrl, true) && this.aVS.originalSize >= 0 && !this.aVS.isBlockedPic) {
            String fY = ar.fY(this.aVS.originalUrl);
            File file = new File(this.aVM + an.DZ().fQ(fY) + "/" + fY);
            if (file != null && file.exists()) {
                this.aVS.originalProcess = 100;
                return true;
            }
            if (this.aVS.originalProcess < 0) {
                Le();
            } else {
                this.aVp.setText(this.aVS.originalProcess + "%");
                this.aVp.setCompoundDrawablesWithIntrinsicBounds(0, 0, e.f.icon_close_yuantu, 0);
            }
            this.aVW = true;
        } else {
            this.aVp.setVisibility(8);
        }
        return false;
    }

    public void Le() {
        if (this.aVS != null) {
            if (!Lf() || !this.aVW) {
                this.aVp.setVisibility(8);
            } else {
                this.aVp.setVisibility(0);
            }
            if (this.aVS.originalSize > 0 && !an(this.aVS.originalSize)) {
                this.aVp.setText(aVm + "(" + ao.ac(this.aVS.originalSize) + ")");
            } else {
                this.aVp.setText(aVm);
            }
            this.aVp.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    private boolean Lf() {
        return (this.aVS == null || !this.aVS.mIsShowOrigonButton || this.aVS.isBlockedPic || StringUtils.isNull(this.aVS.originalUrl)) ? false : true;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.aUm = bVar;
    }

    private boolean an(long j) {
        return j > aVn;
    }
}
