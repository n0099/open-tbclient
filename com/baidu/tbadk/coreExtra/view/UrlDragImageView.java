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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.d.c;
import com.baidu.tbadk.core.util.k;
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
    private boolean ayi;
    private b ayk;
    private boolean ayl;
    private RectF azA;
    private Rect azB;
    private Rect azC;
    private DragImageView.d azD;
    private String azF;
    private ImageUrlData azG;
    private boolean azH;
    private boolean azI;
    private boolean azJ;
    public boolean azK;
    private TextView azL;
    private com.baidu.tbadk.img.b azM;
    private View.OnTouchListener azN;
    private boolean azO;
    private float azP;
    private View.OnLongClickListener azQ;
    private Runnable azR;
    private Runnable azS;
    private View.OnTouchListener azT;
    protected DragImageView azj;
    protected TextView azk;
    protected TextView azl;
    protected TextView azm;
    protected SubsamplingScaleImageView azn;
    private SubsamplingScaleImageView.OnImageEventListener azo;
    private a azp;
    private boolean azq;
    private boolean azr;
    private boolean azs;
    private boolean azt;
    private boolean azu;
    private Bitmap azv;
    private boolean azw;
    private float azx;
    private Matrix azy;
    private Rect azz;
    protected Context mContext;
    private float mLastMotionX;
    private float mLastMotionY;
    private int mMaxHeight;
    private int mMaxWidth;
    private View.OnClickListener mOnClickListener;
    protected ProgressBar mProgressBar;
    private float mRatio;
    private int mSkinType;
    private static final String azh = TbadkCoreApplication.getInst().getString(d.k.original_img_look);
    private static long azi = 52428800;
    private static final int azE = l.ah(TbadkCoreApplication.getInst()) / 5;
    private static final String TAG = UrlDragImageView.class.getSimpleName();
    private static final int TOUCH_SLOP = ViewConfiguration.get(TbadkCoreApplication.getInst()).getScaledTouchSlop();

    /* loaded from: classes.dex */
    public interface a {
        void j(String str, byte[] bArr);
    }

    /* loaded from: classes.dex */
    public interface b {
        void Cu();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.azk != null) {
                ak.i(this.azk, d.f.btn_percent_yuantu);
                ak.b(this.azk, d.C0126d.cp_cont_g, 1, 0);
            }
            if (this.azl != null) {
                ak.j(this.azl, d.C0126d.common_color_10022);
                ak.b(this.azl, d.C0126d.cp_cont_g, 1, 0);
            }
            this.mSkinType = i;
        }
    }

    public void setHeadImage(boolean z) {
        if (this.azj != null) {
            this.azj.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.azp = aVar;
    }

    public UrlDragImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mContext = null;
        this.mProgressBar = null;
        this.azj = null;
        this.azp = null;
        this.ayi = false;
        this.azs = false;
        this.azw = false;
        this.mRatio = 1.0f;
        this.azx = 0.0f;
        this.azy = new Matrix();
        this.azA = new RectF();
        this.azH = false;
        this.azI = false;
        this.azJ = false;
        this.azK = false;
        this.azL = null;
        this.azO = true;
        this.azP = 0.0f;
        this.mOnClickListener = null;
        this.azQ = null;
        this.azR = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.azO = true;
            }
        };
        this.azS = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.azk.setVisibility(8);
                        UrlDragImageView.this.azK = false;
                    }
                });
                UrlDragImageView.this.azk.startAnimation(alphaAnimation);
            }
        };
        this.azT = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (UrlDragImageView.this.azN != null) {
                    UrlDragImageView.this.azN.onTouch(view2, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.azM = new com.baidu.tbadk.img.b();
        init();
    }

    public UrlDragImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.mContext = null;
        this.mProgressBar = null;
        this.azj = null;
        this.azp = null;
        this.ayi = false;
        this.azs = false;
        this.azw = false;
        this.mRatio = 1.0f;
        this.azx = 0.0f;
        this.azy = new Matrix();
        this.azA = new RectF();
        this.azH = false;
        this.azI = false;
        this.azJ = false;
        this.azK = false;
        this.azL = null;
        this.azO = true;
        this.azP = 0.0f;
        this.mOnClickListener = null;
        this.azQ = null;
        this.azR = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.azO = true;
            }
        };
        this.azS = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.azk.setVisibility(8);
                        UrlDragImageView.this.azK = false;
                    }
                });
                UrlDragImageView.this.azk.startAnimation(alphaAnimation);
            }
        };
        this.azT = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (UrlDragImageView.this.azN != null) {
                    UrlDragImageView.this.azN.onTouch(view2, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.azM = new com.baidu.tbadk.img.b();
        init();
    }

    public DragImageView getImageView() {
        return this.azj;
    }

    public void setGifSetListener(DragImageView.e eVar) {
        this.azj.setGifSetListener(eVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.azj.setImageOnClickListener(onClickListener);
        this.azn.setOnClickListener(onClickListener);
        this.mOnClickListener = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.azQ = onLongClickListener;
        if (!this.ayl) {
            this.azj.setImageOnLongClickListener(this.azQ);
            this.azn.setOnLongClickListener(this.azQ);
        }
    }

    public void setOnSizeChangedListener(final DragImageView.f fVar) {
        this.azj.setOnSizeChangedListener(new DragImageView.f() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.8
            @Override // com.baidu.tbadk.widget.DragImageView.f
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (fVar != null) {
                    fVar.a(dragImageView, z, z2);
                }
                UrlDragImageView.this.Ci();
            }
        });
    }

    protected void init() {
        this.mMaxWidth = l.af(this.mContext);
        this.mMaxHeight = l.ah(this.mContext) - ((int) this.mContext.getResources().getDimension(d.e.ds166));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.azj = new DragImageView(this.mContext);
        this.azj.setLayoutParams(layoutParams);
        this.azj.setOnTouchListener(this.azT);
        addView(this.azj);
        this.azn = new SubsamplingScaleImageView(this.mContext);
        this.azn.setMaxScale(50.0f);
        this.azn.setOnTouchListener(this.azT);
        this.azn.setVisibility(4);
        addView(this.azn, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(getResources().getDrawable(d.f.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        Ce();
        Cc();
        Cf();
    }

    private void Cc() {
        this.azF = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        this.azk = new TextView(this.mContext);
        ak.i(this.azk, d.f.btn_percent_yuantu);
        this.azk.setText(d.k.original_img_look);
        this.azk.setTextSize(0, getResources().getDimensionPixelSize(d.e.fontsize28));
        ak.b(this.azk, d.C0126d.cp_cont_g, 1, 0);
        this.azk.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds20);
        this.azk.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        this.azk.setMinWidth(getResources().getDimensionPixelSize(d.e.ds220));
        this.azk.setMinHeight(getResources().getDimensionPixelSize(d.e.ds68));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(d.e.fontsize40);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        this.azk.setOnClickListener(this);
        this.azk.setVisibility(8);
        addView(this.azk, layoutParams);
    }

    public void setIsCanDrag(boolean z) {
        this.ayl = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        Bitmap imageBitmap;
        int height;
        int width;
        if (!this.ayl || !this.azr) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.azt && motionEvent.getPointerCount() >= 2) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.azt || this.azu) {
            requestDisallowInterceptTouchEvent(true);
        }
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        float x = motionEvent.getX();
        int i = action & 255;
        if (i == 0) {
            if (this.azv == null) {
                if (this.azn.getVisibility() == 0) {
                    this.azv = com.baidu.tbadk.util.d.R(this.azn);
                } else {
                    this.azv = com.baidu.tbadk.util.d.R(this.azj);
                }
            }
            if (this.azz == null && this.azv != null) {
                int measuredWidth = getMeasuredWidth();
                float measuredWidth2 = ((getMeasuredWidth() * 1.0f) / this.azv.getWidth()) * this.azv.getHeight();
                if (measuredWidth2 > getMeasuredHeight()) {
                    measuredWidth2 = getMeasuredHeight();
                }
                RectF f = f(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
                this.azz = new Rect((int) f.left, (int) f.top, (int) f.right, (int) f.bottom);
            }
            if (this.azC == null && this.azv != null) {
                if (this.azn.getVisibility() == 0) {
                    height = this.azn.getSHeight();
                    width = this.azn.getSWidth();
                } else {
                    if (this.azj.getImageType() == 1) {
                        imageBitmap = (this.azj.getCurrentFrame() == null || this.azj.getCurrentFrame().aOR == null) ? this.azv : this.azj.getCurrentFrame().aOR;
                    } else {
                        imageBitmap = this.azj.getImageBitmap() == null ? this.azv : this.azj.getImageBitmap();
                    }
                    height = imageBitmap.getHeight();
                    width = imageBitmap.getWidth();
                }
                float ai = l.ai(getContext());
                int i2 = (int) (height * ai);
                int i3 = (int) (width * ai);
                if (i3 > this.azv.getWidth() && this.azv.getWidth() != 0) {
                    float width2 = (i3 * 1.0f) / this.azv.getWidth();
                    i3 = this.azv.getWidth();
                    i2 = (int) (i2 / width2);
                }
                if (i2 > this.azv.getHeight() && this.azv.getHeight() != 0) {
                    i3 = (int) (i3 / ((i2 * 1.0f) / this.azv.getHeight()));
                    i2 = this.azv.getHeight();
                }
                int ah = (l.ah(getContext()) - i2) / 2;
                int af = (l.af(getContext()) - i3) / 2;
                this.azC = new Rect(af, ah, i3 + af, i2 + ah);
                this.azB = new Rect(0, 0, this.azv.getWidth(), this.azv.getHeight());
            }
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (i == 2) {
            this.azt = e(this.mLastMotionX - x, this.mLastMotionY - y);
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (this.azt || this.azu) {
            this.azj.setImageOnLongClickListener(null);
            this.azn.setOnLongClickListener(null);
            z = true;
        } else {
            this.azj.setImageOnLongClickListener(this.azQ);
            this.azn.setOnLongClickListener(this.azQ);
            z = super.dispatchTouchEvent(motionEvent);
        }
        if (i == 1 || i == 3) {
            this.mLastMotionX = 0.0f;
            this.mLastMotionY = 0.0f;
            this.azw = false;
            this.azy.reset();
            this.azt = false;
            if (this.azx > azE) {
                this.azu = true;
                Cd();
                return z;
            }
            this.mRatio = 1.0f;
            invalidate();
            return z;
        }
        return z;
    }

    private boolean e(float f, float f2) {
        if (this.azn.getVisibility() != 0 || this.azn.isCanDrag()) {
            if (this.azG == null || !this.azG.isLongPic || this.azn.getVisibility() != 0 || this.azn.isViewTop()) {
                if (this.azG == null || !this.azG.isLongPic || this.azn.getVisibility() == 0 || this.azj.HV()) {
                    if (this.azn.getVisibility() == 0 || this.azj.HX()) {
                        if (this.azv != null && getScrollY() == 0 && f2 < 0.0f && !this.azw) {
                            this.azw = true;
                            this.azx = 0.0f;
                            this.mRatio = 1.0f;
                            if (this.azD != null) {
                                this.azD.In();
                            }
                        }
                        if (this.azw) {
                            this.azx -= f2;
                            int measuredHeight = getMeasuredHeight();
                            if (this.azx > measuredHeight) {
                                this.azx = measuredHeight;
                            }
                            float f3 = f2 / measuredHeight;
                            this.azy.postTranslate((-f) * 1.5f * this.mRatio, (-1.5f) * f2 * this.mRatio);
                            if (this.mRatio * (1.0f + f3) > 1.0f || this.azx < 0.0f) {
                                this.azy.preScale(1.0f / this.mRatio, 1.0f / this.mRatio, (this.mRatio * this.azv.getWidth()) / 2.0f, this.mRatio * (this.azv.getHeight() / 2));
                                this.mRatio = 1.0f;
                            } else {
                                this.azy.preScale(1.0f + f3, 1.0f + f3, (this.mRatio * this.azv.getWidth()) / 2.0f, this.mRatio * (this.azv.getHeight() / 2));
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
        if (this.azt && this.azv != null && !this.azv.isRecycled() && this.azw) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.azA == null) {
                this.azA = new RectF();
            }
            this.azy.mapRect(this.azA, new RectF(this.azz));
            canvas.drawBitmap(this.azv, this.azB, this.azA, (Paint) null);
        } else if (this.azu && this.azv != null && !this.azv.isRecycled()) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.azG == null || this.azG.getSourceImageRectInScreen() == null) {
                canvas.drawBitmap(this.azv, this.azB, this.azA, (Paint) null);
            } else {
                canvas.drawBitmap(this.azv, this.azC, this.azA, (Paint) null);
            }
        } else {
            super.dispatchDraw(canvas);
        }
    }

    private void Cd() {
        if (this.azG == null) {
            if (this.azD != null) {
                this.azD.Io();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.azG.getSourceImageRectInScreen();
        if (sourceImageRectInScreen == null) {
            if (this.azD != null) {
                this.azD.Io();
                return;
            }
            return;
        }
        this.azA.bottom = (((sourceImageRectInScreen.bottom - sourceImageRectInScreen.top) / (sourceImageRectInScreen.right - sourceImageRectInScreen.left)) * (this.azA.right - this.azA.left)) + this.azA.top;
        final float[] fArr = {(this.azA.left + this.azA.right) / 2.0f, (this.azA.top + this.azA.bottom) / 2.0f};
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
                    UrlDragImageView.this.azA = UrlDragImageView.this.f(floatValue, animatedFraction, sourceImageRectInScreen.right - sourceImageRectInScreen.left, sourceImageRectInScreen.bottom - sourceImageRectInScreen.top);
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
                UrlDragImageView.this.azw = false;
                UrlDragImageView.this.invalidate();
                if (UrlDragImageView.this.azD != null) {
                    UrlDragImageView.this.azD.Io();
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
    public RectF f(float f, float f2, float f3, float f4) {
        return new RectF(f - (f3 / 2.0f), f2 - (f4 / 2.0f), (f3 / 2.0f) + f, (f4 / 2.0f) + f2);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.azN = onTouchListener;
    }

    private void Ce() {
        this.azL = new TextView(this.mContext);
        this.azL.setBackgroundResource(d.f.bg_url_drag_imagview_fade_view);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.height = getResources().getDimensionPixelSize(d.e.ds180);
        layoutParams.addRule(12);
        addView(this.azL, layoutParams);
        this.azL.setVisibility(8);
    }

    private void Cf() {
        this.azl = new TextView(this.mContext);
        ak.j(this.azl, d.C0126d.common_color_10022);
        this.azl.setText(d.k.goto_pb_floor);
        this.azl.setTextSize(0, getResources().getDimensionPixelSize(d.e.fontsize24));
        ak.b(this.azl, d.C0126d.cp_cont_g, 1, 0);
        this.azl.setCompoundDrawablePadding(l.dip2px(this.mContext, 4.0f));
        this.azl.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ak.getDrawable(d.f.icon_see_arrow), (Drawable) null);
        this.azl.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds20);
        this.azl.setPadding(dimensionPixelSize * 3, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(d.e.ds30);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(d.e.ds10);
        layoutParams.leftMargin = getResources().getDimensionPixelSize(d.e.ds20);
        layoutParams.addRule(1, this.azk.getId());
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        this.azl.setOnClickListener(this);
        this.azl.setMinHeight(getResources().getDimensionPixelSize(d.e.ds100));
        addView(this.azl, layoutParams);
        this.azl.setVisibility(8);
    }

    private void Cg() {
        if (this.azl != null) {
            boolean z = this.azq || this.azr;
            if (!this.azJ && z && this.azG != null && this.azG.threadId > 0 && this.azG.postId > 0 && this.azG.mThreadType != 33 && !this.azG.isBlockedPic) {
                this.azl.setVisibility(0);
                if (this.azL != null) {
                    this.azL.setVisibility(0);
                    return;
                }
                return;
            }
            this.azl.setVisibility(8);
            if (this.azL != null) {
                this.azL.setVisibility(8);
            }
        }
    }

    private void Ch() {
        if (this.azl != null) {
            this.azl.setVisibility(8);
            if (this.azL != null) {
                this.azL.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ci() {
        if ((this.azq || this.azr) && this.azG != null && this.azG.mPicType == 1 && !TextUtils.isEmpty(this.azG.mTagName)) {
            if (this.azm != null) {
                this.azm.setVisibility(8);
                this.azm = null;
            }
            this.azm = new TextView(this.mContext);
            this.azm.setText(this.azG.mTagName);
            this.azm.setTextSize(0, getResources().getDimensionPixelSize(d.e.fontsize26));
            ak.b(this.azm, d.C0126d.common_color_10013, 1, 0);
            ak.j(this.azm, d.C0126d.common_color_10215);
            this.azm.setAlpha(0.75f);
            this.azm.setIncludeFontPadding(false);
            this.azm.setGravity(17);
            int e = l.e(this.mContext, d.e.ds2);
            this.azm.setPadding(e, e, e, e);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.azj.getBottomOffset();
            layoutParams.leftMargin = this.azj.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.azm, layoutParams);
            this.azm.setVisibility(0);
        }
    }

    public void bm(boolean z) {
        this.azJ = z;
        if (this.azJ) {
            Ch();
        } else {
            Cg();
        }
    }

    public void setUrl(String str, boolean z) {
        if (str.contains("*")) {
            str = str.split("[*]")[0];
        }
        this.azj.setTag(str);
        this.azj.setLoadBigImage(false);
        this.azj.setImageDrawable(null);
        this.azq = false;
        this.azr = false;
        this.azH = Cp();
        this.azk.setVisibility(8);
        if (fE(str)) {
            b(str, z, false);
        }
    }

    private boolean Cj() {
        return this.azj != null && this.azj.Il();
    }

    public void Ck() {
        if (this.azG != null && !Cj()) {
            String str = this.azG.imageUrl;
            int i = this.azG.urlType;
            com.baidu.adp.widget.ImageView.a aVar = null;
            if (com.baidu.tbadk.core.util.d.a.v(str, i)) {
                aVar = com.baidu.tbadk.core.util.d.a.w(str, i);
            }
            if (aVar != null) {
                setThumbBitmapToView(aVar);
            }
        }
    }

    private boolean bn(boolean z) {
        String em;
        if (!this.azI || z) {
            this.azI = true;
            if (!this.azH || this.azG == null || StringUtils.isNull(this.azG.originalUrl, true) || this.azG.originalSize < 0 || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String str = this.azF + am.vJ().ef(em) + "/" + aq.em(this.azG.originalUrl);
            final int[] dG = k.dG(str);
            this.azn.setVisibility(0);
            if (this.azo == null) {
                this.azo = new SubsamplingScaleImageView.OnImageEventListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12
                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onReady() {
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.azj.Ih();
                        UrlDragImageView.this.azj.setVisibility(4);
                    }

                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onImageLoaded() {
                        if (UrlDragImageView.this.azG.isLongPic && dG[0] > 0) {
                            UrlDragImageView.this.azj.onDestroy();
                            final float measuredWidth = (UrlDragImageView.this.getMeasuredWidth() * 1.0f) / dG[0];
                            final PointF pointF = new PointF((dG[0] * 1.0f) / 2.0f, 0.0f);
                            UrlDragImageView.this.azn.setScaleAndCenter(measuredWidth, pointF);
                            UrlDragImageView.this.azn.setMaxScale(2.0f * measuredWidth);
                            UrlDragImageView.this.azn.setDoubleTapZoomScale(2.0f * measuredWidth);
                            UrlDragImageView.this.azn.setInitScale(measuredWidth);
                            UrlDragImageView.this.azn.setDoubleTapZoomStyle(4);
                            UrlDragImageView.this.azn.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12.1
                                @Override // android.view.View.OnTouchListener
                                public boolean onTouch(View view2, MotionEvent motionEvent) {
                                    if (UrlDragImageView.this.azN != null) {
                                        UrlDragImageView.this.azN.onTouch(view2, motionEvent);
                                    }
                                    switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                                        case 0:
                                            UrlDragImageView.this.azP = motionEvent.getY();
                                            UrlDragImageView.this.azn.setOnClickListener(UrlDragImageView.this.azO ? UrlDragImageView.this.mOnClickListener : null);
                                            UrlDragImageView.this.azn.setOnLongClickListener(UrlDragImageView.this.azO ? UrlDragImageView.this.azQ : null);
                                            break;
                                        case 1:
                                        case 3:
                                            if (UrlDragImageView.this.azn.getScale() < measuredWidth) {
                                                UrlDragImageView.this.azn.setScaleAndCenter(measuredWidth, pointF);
                                            }
                                            e.fw().removeCallbacks(UrlDragImageView.this.azR);
                                            e.fw().postDelayed(UrlDragImageView.this.azR, 1000L);
                                            break;
                                        case 2:
                                            if (Math.abs(motionEvent.getY() - UrlDragImageView.this.azP) > UrlDragImageView.TOUCH_SLOP) {
                                                UrlDragImageView.this.azO = false;
                                                UrlDragImageView.this.azn.setOnClickListener(null);
                                                UrlDragImageView.this.azn.setOnLongClickListener(null);
                                            }
                                            UrlDragImageView.this.azP = motionEvent.getY();
                                            break;
                                    }
                                    return false;
                                }
                            });
                            UrlDragImageView.this.azj.setVisibility(4);
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
            this.azn.setOnImageEventListener(this.azo);
            if (this.azn.isImageLoaded() && this.azG.isLongPic) {
                this.azo.onImageLoaded();
            } else {
                this.azn.setImage(ImageSource.uri(str));
            }
            return true;
        }
        return false;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.azD = dVar;
        if (this.azj != null) {
            this.azj.setDragToExitListener(dVar);
        }
    }

    public void Cl() {
        bn(false);
    }

    private boolean fE(String str) {
        return j.gP() || c.eD(str);
    }

    private void setThumbBitmapToView(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap kl;
        if (!this.azr && aVar != null && (kl = aVar.kl()) != null) {
            this.azq = true;
            if (aVar.isGif()) {
                this.azj.setImageUrlData(this.azG);
                this.azj.setImageBitmap(kl);
                this.azk.setVisibility(8);
                this.azK = false;
            } else {
                if (this.azG != null && this.azG.isLongPic) {
                    this.azj.Ia();
                    this.azj.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.13
                        @Override // com.baidu.tbadk.widget.largeImage.logic.a
                        public void Ct() {
                        }
                    });
                }
                this.azj.setImageUrlData(this.azG);
                this.azj.setImageData(kl, aVar.kq());
            }
            Cg();
            Ci();
        }
    }

    private void b(String str, boolean z, boolean z2) {
        if (fF(str)) {
            if (z2 || (!this.azs && !this.azr)) {
                if (!z2 || !bn(true)) {
                    this.azs = true;
                    com.baidu.adp.lib.f.c.fp().a(str, 27, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.14
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onCancelled(String str2) {
                            UrlDragImageView.this.azs = false;
                            UrlDragImageView.this.azj.setVisibility(0);
                            UrlDragImageView.this.mProgressBar.setVisibility(8);
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            UrlDragImageView.this.azs = false;
                            UrlDragImageView.this.azr = true;
                            UrlDragImageView.this.b(aVar);
                        }
                    }, 0, 0, false, null, Boolean.valueOf(z), this.azj.getImageData(), Boolean.valueOf(this.ayi));
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
        imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.G(this.mMaxWidth, this.mMaxHeight));
        com.baidu.adp.widget.ImageView.a a2 = this.azM.a(imageFileInfo, false);
        if (a2 != null) {
            this.azr = true;
            this.mProgressBar.setVisibility(8);
            b(a2);
            return;
        }
        this.azM.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.2
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.ImageView.a aVar, String str2, boolean z3) {
                UrlDragImageView.this.azr = true;
                UrlDragImageView.this.mProgressBar.setVisibility(8);
                UrlDragImageView.this.b(aVar);
            }
        }, false);
    }

    private boolean fF(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith("https://"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null && this.azp != null) {
            this.azp.j(aVar.getUrl(), aVar.kq());
        }
        if (aVar == null || aVar.kl() == null) {
            Cm();
            return;
        }
        Bitmap kl = aVar.kl();
        this.azj.setLoadBigImage(true);
        if (aVar.isGif()) {
            this.azj.setGifData(aVar.kq(), kl);
            this.azj.invalidate();
            this.azj.play();
            this.azK = false;
            this.azk.setVisibility(8);
            this.mProgressBar.setVisibility(8);
        } else {
            if (this.azG != null && this.azG.isLongPic) {
                this.azj.Ia();
                this.azj.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.3
                    @Override // com.baidu.tbadk.widget.largeImage.logic.a
                    public void Ct() {
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                    }
                });
            } else {
                this.mProgressBar.setVisibility(8);
            }
            this.azj.setImageUrlData(this.azG);
            this.azj.setImageData(kl, aVar.kq());
            Cq();
        }
        Cg();
        Ci();
    }

    private void Cm() {
        if (!this.azq) {
            this.azj.setDefaultBitmap();
        } else {
            this.azr = false;
        }
        this.azk.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    public void setGifMaxUseableMem(int i) {
        this.azj.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.azj != null) {
            this.azj.onDestroy();
        }
        if (this.azn != null) {
            this.azn.recycle();
        }
        if (this.azv != null) {
            this.azv.recycle();
            this.azv = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        e.fw().removeCallbacks(this.azR);
    }

    public void release() {
        if (this.azj != null) {
            this.azj.release();
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.azk != null) {
            this.azk.setVisibility(8);
        }
    }

    public void Cn() {
        if (this.azj != null && this.azj.getImageType() == 1) {
            this.azj.stop();
        }
    }

    public void i(boolean z, boolean z2) {
        String str;
        if (this.azj != null && (str = (String) this.azj.getTag()) != null) {
            if (this.azj.getImageType() == 1) {
                if (this.azj.getGifCache() == null || !this.azj.Il()) {
                    b(str, z, z2);
                }
            } else if (this.azj.getImageType() == 2) {
                b(str, z, z2);
            } else if (Co()) {
                b(str, z, z2);
            }
        }
    }

    private boolean Co() {
        if (this.azj.getImageBitmap() != null && this.azj.Il()) {
            if (this.azG == null || !this.azG.isLongPic || this.azj.Ib()) {
                return false;
            }
            this.azr = false;
            this.azI = false;
            return true;
        }
        return true;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.azG = imageUrlData;
    }

    public void setIsCdn(boolean z) {
        this.ayi = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.azk) {
            if (!(this.azk.getTag() instanceof Boolean) || ((Boolean) this.azk.getTag()).booleanValue()) {
                final String em = aq.em(this.azG.originalUrl);
                if (this.azG.originalProcess >= 0) {
                    com.baidu.tbadk.download.e.Dw().z(em, 13);
                    this.azG.originalProcess = -1;
                    Cq();
                    return;
                }
                if (this.ayk != null) {
                    this.ayk.Cu();
                }
                com.baidu.adp.base.e<?> ab = i.ab(this.mContext);
                if (ab == null) {
                    fG(em);
                } else if (!j.gP() || j.gQ() || com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("original_img_down_tip", false)) {
                    fG(em);
                } else {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("original_img_down_tip", true);
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(ab.getPageActivity());
                    aVar.ca(d.k.original_img_down_no_wifi_tip);
                    aVar.a(d.k.alert_yes_button, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.4
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar.dismiss();
                            UrlDragImageView.this.fG(em);
                        }
                    });
                    aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.5
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar.dismiss();
                        }
                    });
                    aVar.b(ab);
                    aVar.tC();
                }
            }
        } else if (view2 == this.azl && this.azG != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.mContext).createHistoryCfg(String.valueOf(this.azG.threadId), String.valueOf(this.azG.postId), this.azG.mIsSeeHost, this.azG.mIsReserver, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fG(String str) {
        if (this.azG != null) {
            this.azG.originalProcess = 0;
        }
        this.azk.setText("0%");
        this.azk.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_close_yuantu, 0);
        DownloadData downloadData = new DownloadData(str);
        downloadData.setStatus(1);
        downloadData.setUrl(this.azG.originalUrl);
        downloadData.setType(13);
        downloadData.setPath(this.azF + am.vJ().ef(str) + "/" + str);
        downloadData.setCallback(new com.baidu.tbadk.download.d() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.6
            @Override // com.baidu.tbadk.download.d
            public boolean onPreDownload(DownloadData downloadData2) {
                return true;
            }

            @Override // com.baidu.tbadk.download.d
            public void onFileUpdateProgress(DownloadData downloadData2) {
                if (downloadData2 != null) {
                    if (UrlDragImageView.this.azG != null && UrlDragImageView.this.azG.originalProcess != -1) {
                        UrlDragImageView.this.azG.originalProcess = downloadData2.getProcess();
                    }
                    if (UrlDragImageView.this.azG == null || UrlDragImageView.this.azG.originalProcess != -1) {
                        UrlDragImageView.this.azk.setText(downloadData2.getProcess() + "%");
                        UrlDragImageView.this.azk.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_close_yuantu, 0);
                    }
                }
            }

            @Override // com.baidu.tbadk.download.d
            public boolean onFileDownloaded(DownloadData downloadData2) {
                return true;
            }

            @Override // com.baidu.tbadk.download.d
            public void onFileDownloadSucceed(DownloadData downloadData2) {
                UrlDragImageView.this.azk.setText(UrlDragImageView.this.getResources().getString(d.k.done));
                UrlDragImageView.this.azk.setTag(false);
                UrlDragImageView.this.azk.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                e.fw().postDelayed(UrlDragImageView.this.azS, 1500L);
                UrlDragImageView.this.azI = false;
                UrlDragImageView.this.azH = UrlDragImageView.this.Cp();
                UrlDragImageView.this.Cl();
            }

            @Override // com.baidu.tbadk.download.d
            public void onFileDownloadFailed(DownloadData downloadData2, int i, String str2) {
                UrlDragImageView.this.azI = false;
                BdToast.a(UrlDragImageView.this.mContext, str2).tI().tK();
                UrlDragImageView.this.azG.originalProcess = -1;
                UrlDragImageView.this.Cq();
            }
        });
        com.baidu.tbadk.download.e.Dw().a(downloadData, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Cp() {
        if (this.azG != null && !StringUtils.isNull(this.azG.originalUrl, true) && this.azG.originalSize >= 0 && !this.azG.isBlockedPic) {
            String em = aq.em(this.azG.originalUrl);
            File file = new File(this.azF + am.vJ().ef(em) + "/" + em);
            if (file != null && file.exists()) {
                this.azG.originalProcess = 100;
                return true;
            }
            if (this.azG.originalProcess < 0) {
                Cq();
            } else {
                this.azk.setText(this.azG.originalProcess + "%");
                this.azk.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_close_yuantu, 0);
            }
            this.azK = true;
        } else {
            this.azk.setVisibility(8);
        }
        return false;
    }

    public void Cq() {
        if (this.azG != null) {
            if (!Cr() || !this.azK) {
                this.azk.setVisibility(8);
            } else {
                this.azk.setVisibility(0);
            }
            if (this.azG.originalSize > 0 && !R(this.azG.originalSize)) {
                this.azk.setText(azh + "(" + an.G(this.azG.originalSize) + ")");
            } else {
                this.azk.setText(azh);
            }
            this.azk.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    private boolean Cr() {
        return (this.azG == null || !this.azG.mIsShowOrigonButton || this.azG.isBlockedPic || StringUtils.isNull(this.azG.originalUrl)) ? false : true;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.ayk = bVar;
    }

    private boolean R(long j) {
        return j > azi;
    }
}
