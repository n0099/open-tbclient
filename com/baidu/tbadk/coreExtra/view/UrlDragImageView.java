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
    private boolean ayh;
    private b ayj;
    private boolean ayk;
    private Rect azA;
    private Rect azB;
    private DragImageView.d azC;
    private String azE;
    private ImageUrlData azF;
    private boolean azG;
    private boolean azH;
    private boolean azI;
    public boolean azJ;
    private TextView azK;
    private com.baidu.tbadk.img.b azL;
    private View.OnTouchListener azM;
    private boolean azN;
    private float azO;
    private View.OnLongClickListener azP;
    private Runnable azQ;
    private Runnable azR;
    private View.OnTouchListener azS;
    protected DragImageView azi;
    protected TextView azj;
    protected TextView azk;
    protected TextView azl;
    protected SubsamplingScaleImageView azm;
    private SubsamplingScaleImageView.OnImageEventListener azn;
    private a azo;
    private boolean azp;
    private boolean azq;
    private boolean azr;
    private boolean azs;
    private boolean azt;
    private Bitmap azu;
    private boolean azv;
    private float azw;
    private Matrix azx;
    private Rect azy;
    private RectF azz;
    protected Context mContext;
    private float mLastMotionX;
    private float mLastMotionY;
    private int mMaxHeight;
    private int mMaxWidth;
    private View.OnClickListener mOnClickListener;
    protected ProgressBar mProgressBar;
    private float mRatio;
    private int mSkinType;
    private static final String azg = TbadkCoreApplication.getInst().getString(d.k.original_img_look);
    private static long azh = 52428800;
    private static final int azD = l.ah(TbadkCoreApplication.getInst()) / 5;
    private static final String TAG = UrlDragImageView.class.getSimpleName();
    private static final int TOUCH_SLOP = ViewConfiguration.get(TbadkCoreApplication.getInst()).getScaledTouchSlop();

    /* loaded from: classes.dex */
    public interface a {
        void j(String str, byte[] bArr);
    }

    /* loaded from: classes.dex */
    public interface b {
        void Cw();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.azj != null) {
                ak.i(this.azj, d.f.btn_percent_yuantu);
                ak.b(this.azj, d.C0126d.cp_cont_g, 1, 0);
            }
            if (this.azk != null) {
                ak.j(this.azk, d.C0126d.common_color_10022);
                ak.b(this.azk, d.C0126d.cp_cont_g, 1, 0);
            }
            this.mSkinType = i;
        }
    }

    public void setHeadImage(boolean z) {
        if (this.azi != null) {
            this.azi.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.azo = aVar;
    }

    public UrlDragImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mContext = null;
        this.mProgressBar = null;
        this.azi = null;
        this.azo = null;
        this.ayh = false;
        this.azr = false;
        this.azv = false;
        this.mRatio = 1.0f;
        this.azw = 0.0f;
        this.azx = new Matrix();
        this.azz = new RectF();
        this.azG = false;
        this.azH = false;
        this.azI = false;
        this.azJ = false;
        this.azK = null;
        this.azN = true;
        this.azO = 0.0f;
        this.mOnClickListener = null;
        this.azP = null;
        this.azQ = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.azN = true;
            }
        };
        this.azR = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.azj.setVisibility(8);
                        UrlDragImageView.this.azJ = false;
                    }
                });
                UrlDragImageView.this.azj.startAnimation(alphaAnimation);
            }
        };
        this.azS = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (UrlDragImageView.this.azM != null) {
                    UrlDragImageView.this.azM.onTouch(view2, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.azL = new com.baidu.tbadk.img.b();
        init();
    }

    public UrlDragImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.mContext = null;
        this.mProgressBar = null;
        this.azi = null;
        this.azo = null;
        this.ayh = false;
        this.azr = false;
        this.azv = false;
        this.mRatio = 1.0f;
        this.azw = 0.0f;
        this.azx = new Matrix();
        this.azz = new RectF();
        this.azG = false;
        this.azH = false;
        this.azI = false;
        this.azJ = false;
        this.azK = null;
        this.azN = true;
        this.azO = 0.0f;
        this.mOnClickListener = null;
        this.azP = null;
        this.azQ = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.azN = true;
            }
        };
        this.azR = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.azj.setVisibility(8);
                        UrlDragImageView.this.azJ = false;
                    }
                });
                UrlDragImageView.this.azj.startAnimation(alphaAnimation);
            }
        };
        this.azS = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (UrlDragImageView.this.azM != null) {
                    UrlDragImageView.this.azM.onTouch(view2, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.azL = new com.baidu.tbadk.img.b();
        init();
    }

    public DragImageView getImageView() {
        return this.azi;
    }

    public void setGifSetListener(DragImageView.e eVar) {
        this.azi.setGifSetListener(eVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.azi.setImageOnClickListener(onClickListener);
        this.azm.setOnClickListener(onClickListener);
        this.mOnClickListener = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.azP = onLongClickListener;
        if (!this.ayk) {
            this.azi.setImageOnLongClickListener(this.azP);
            this.azm.setOnLongClickListener(this.azP);
        }
    }

    public void setOnSizeChangedListener(final DragImageView.f fVar) {
        this.azi.setOnSizeChangedListener(new DragImageView.f() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.8
            @Override // com.baidu.tbadk.widget.DragImageView.f
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (fVar != null) {
                    fVar.a(dragImageView, z, z2);
                }
                UrlDragImageView.this.Ck();
            }
        });
    }

    protected void init() {
        this.mMaxWidth = l.af(this.mContext);
        this.mMaxHeight = l.ah(this.mContext) - ((int) this.mContext.getResources().getDimension(d.e.ds166));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.azi = new DragImageView(this.mContext);
        this.azi.setLayoutParams(layoutParams);
        this.azi.setOnTouchListener(this.azS);
        addView(this.azi);
        this.azm = new SubsamplingScaleImageView(this.mContext);
        this.azm.setMaxScale(50.0f);
        this.azm.setOnTouchListener(this.azS);
        this.azm.setVisibility(4);
        addView(this.azm, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(getResources().getDrawable(d.f.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        Cg();
        Ce();
        Ch();
    }

    private void Ce() {
        this.azE = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        this.azj = new TextView(this.mContext);
        ak.i(this.azj, d.f.btn_percent_yuantu);
        this.azj.setText(d.k.original_img_look);
        this.azj.setTextSize(0, getResources().getDimensionPixelSize(d.e.fontsize28));
        ak.b(this.azj, d.C0126d.cp_cont_g, 1, 0);
        this.azj.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds20);
        this.azj.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        this.azj.setMinWidth(getResources().getDimensionPixelSize(d.e.ds220));
        this.azj.setMinHeight(getResources().getDimensionPixelSize(d.e.ds68));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(d.e.fontsize40);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        this.azj.setOnClickListener(this);
        this.azj.setVisibility(8);
        addView(this.azj, layoutParams);
    }

    public void setIsCanDrag(boolean z) {
        this.ayk = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        Bitmap imageBitmap;
        int height;
        int width;
        if (!this.ayk || !this.azq) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.azs && motionEvent.getPointerCount() >= 2) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.azs || this.azt) {
            requestDisallowInterceptTouchEvent(true);
        }
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        float x = motionEvent.getX();
        int i = action & 255;
        if (i == 0) {
            if (this.azu == null) {
                if (this.azm.getVisibility() == 0) {
                    this.azu = com.baidu.tbadk.util.d.R(this.azm);
                } else {
                    this.azu = com.baidu.tbadk.util.d.R(this.azi);
                }
            }
            if (this.azy == null && this.azu != null) {
                int measuredWidth = getMeasuredWidth();
                float measuredWidth2 = ((getMeasuredWidth() * 1.0f) / this.azu.getWidth()) * this.azu.getHeight();
                if (measuredWidth2 > getMeasuredHeight()) {
                    measuredWidth2 = getMeasuredHeight();
                }
                RectF f = f(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
                this.azy = new Rect((int) f.left, (int) f.top, (int) f.right, (int) f.bottom);
            }
            if (this.azB == null && this.azu != null) {
                if (this.azm.getVisibility() == 0) {
                    height = this.azm.getSHeight();
                    width = this.azm.getSWidth();
                } else {
                    if (this.azi.getImageType() == 1) {
                        imageBitmap = (this.azi.getCurrentFrame() == null || this.azi.getCurrentFrame().aOQ == null) ? this.azu : this.azi.getCurrentFrame().aOQ;
                    } else {
                        imageBitmap = this.azi.getImageBitmap() == null ? this.azu : this.azi.getImageBitmap();
                    }
                    height = imageBitmap.getHeight();
                    width = imageBitmap.getWidth();
                }
                float ai = l.ai(getContext());
                int i2 = (int) (height * ai);
                int i3 = (int) (width * ai);
                if (i3 > this.azu.getWidth() && this.azu.getWidth() != 0) {
                    float width2 = (i3 * 1.0f) / this.azu.getWidth();
                    i3 = this.azu.getWidth();
                    i2 = (int) (i2 / width2);
                }
                if (i2 > this.azu.getHeight() && this.azu.getHeight() != 0) {
                    i3 = (int) (i3 / ((i2 * 1.0f) / this.azu.getHeight()));
                    i2 = this.azu.getHeight();
                }
                int ah = (l.ah(getContext()) - i2) / 2;
                int af = (l.af(getContext()) - i3) / 2;
                this.azB = new Rect(af, ah, i3 + af, i2 + ah);
                this.azA = new Rect(0, 0, this.azu.getWidth(), this.azu.getHeight());
            }
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (i == 2) {
            this.azs = e(this.mLastMotionX - x, this.mLastMotionY - y);
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (this.azs || this.azt) {
            this.azi.setImageOnLongClickListener(null);
            this.azm.setOnLongClickListener(null);
            z = true;
        } else {
            this.azi.setImageOnLongClickListener(this.azP);
            this.azm.setOnLongClickListener(this.azP);
            z = super.dispatchTouchEvent(motionEvent);
        }
        if (i == 1 || i == 3) {
            this.mLastMotionX = 0.0f;
            this.mLastMotionY = 0.0f;
            this.azv = false;
            this.azx.reset();
            this.azs = false;
            if (this.azw > azD) {
                this.azt = true;
                Cf();
                return z;
            }
            this.mRatio = 1.0f;
            invalidate();
            return z;
        }
        return z;
    }

    private boolean e(float f, float f2) {
        if (this.azm.getVisibility() != 0 || this.azm.isCanDrag()) {
            if (this.azF == null || !this.azF.isLongPic || this.azm.getVisibility() != 0 || this.azm.isViewTop()) {
                if (this.azF == null || !this.azF.isLongPic || this.azm.getVisibility() == 0 || this.azi.HX()) {
                    if (this.azm.getVisibility() == 0 || this.azi.HZ()) {
                        if (this.azu != null && getScrollY() == 0 && f2 < 0.0f && !this.azv) {
                            this.azv = true;
                            this.azw = 0.0f;
                            this.mRatio = 1.0f;
                            if (this.azC != null) {
                                this.azC.Ip();
                            }
                        }
                        if (this.azv) {
                            this.azw -= f2;
                            int measuredHeight = getMeasuredHeight();
                            if (this.azw > measuredHeight) {
                                this.azw = measuredHeight;
                            }
                            float f3 = f2 / measuredHeight;
                            this.azx.postTranslate((-f) * 1.5f * this.mRatio, (-1.5f) * f2 * this.mRatio);
                            if (this.mRatio * (1.0f + f3) > 1.0f || this.azw < 0.0f) {
                                this.azx.preScale(1.0f / this.mRatio, 1.0f / this.mRatio, (this.mRatio * this.azu.getWidth()) / 2.0f, this.mRatio * (this.azu.getHeight() / 2));
                                this.mRatio = 1.0f;
                            } else {
                                this.azx.preScale(1.0f + f3, 1.0f + f3, (this.mRatio * this.azu.getWidth()) / 2.0f, this.mRatio * (this.azu.getHeight() / 2));
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
        if (this.azs && this.azu != null && !this.azu.isRecycled() && this.azv) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.azz == null) {
                this.azz = new RectF();
            }
            this.azx.mapRect(this.azz, new RectF(this.azy));
            canvas.drawBitmap(this.azu, this.azA, this.azz, (Paint) null);
        } else if (this.azt && this.azu != null && !this.azu.isRecycled()) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.azF == null || this.azF.getSourceImageRectInScreen() == null) {
                canvas.drawBitmap(this.azu, this.azA, this.azz, (Paint) null);
            } else {
                canvas.drawBitmap(this.azu, this.azB, this.azz, (Paint) null);
            }
        } else {
            super.dispatchDraw(canvas);
        }
    }

    private void Cf() {
        if (this.azF == null) {
            if (this.azC != null) {
                this.azC.Iq();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.azF.getSourceImageRectInScreen();
        if (sourceImageRectInScreen == null) {
            if (this.azC != null) {
                this.azC.Iq();
                return;
            }
            return;
        }
        this.azz.bottom = (((sourceImageRectInScreen.bottom - sourceImageRectInScreen.top) / (sourceImageRectInScreen.right - sourceImageRectInScreen.left)) * (this.azz.right - this.azz.left)) + this.azz.top;
        final float[] fArr = {(this.azz.left + this.azz.right) / 2.0f, (this.azz.top + this.azz.bottom) / 2.0f};
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
                    UrlDragImageView.this.azz = UrlDragImageView.this.f(floatValue, animatedFraction, sourceImageRectInScreen.right - sourceImageRectInScreen.left, sourceImageRectInScreen.bottom - sourceImageRectInScreen.top);
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
                UrlDragImageView.this.azv = false;
                UrlDragImageView.this.invalidate();
                if (UrlDragImageView.this.azC != null) {
                    UrlDragImageView.this.azC.Iq();
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
        this.azM = onTouchListener;
    }

    private void Cg() {
        this.azK = new TextView(this.mContext);
        this.azK.setBackgroundResource(d.f.bg_url_drag_imagview_fade_view);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.height = getResources().getDimensionPixelSize(d.e.ds180);
        layoutParams.addRule(12);
        addView(this.azK, layoutParams);
        this.azK.setVisibility(8);
    }

    private void Ch() {
        this.azk = new TextView(this.mContext);
        ak.j(this.azk, d.C0126d.common_color_10022);
        this.azk.setText(d.k.goto_pb_floor);
        this.azk.setTextSize(0, getResources().getDimensionPixelSize(d.e.fontsize24));
        ak.b(this.azk, d.C0126d.cp_cont_g, 1, 0);
        this.azk.setCompoundDrawablePadding(l.dip2px(this.mContext, 4.0f));
        this.azk.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ak.getDrawable(d.f.icon_see_arrow), (Drawable) null);
        this.azk.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds20);
        this.azk.setPadding(dimensionPixelSize * 3, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(d.e.ds30);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(d.e.ds10);
        layoutParams.leftMargin = getResources().getDimensionPixelSize(d.e.ds20);
        layoutParams.addRule(1, this.azj.getId());
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        this.azk.setOnClickListener(this);
        this.azk.setMinHeight(getResources().getDimensionPixelSize(d.e.ds100));
        addView(this.azk, layoutParams);
        this.azk.setVisibility(8);
    }

    private void Ci() {
        if (this.azk != null) {
            boolean z = this.azp || this.azq;
            if (!this.azI && z && this.azF != null && this.azF.threadId > 0 && this.azF.postId > 0 && this.azF.mThreadType != 33 && !this.azF.isBlockedPic) {
                this.azk.setVisibility(0);
                if (this.azK != null) {
                    this.azK.setVisibility(0);
                    return;
                }
                return;
            }
            this.azk.setVisibility(8);
            if (this.azK != null) {
                this.azK.setVisibility(8);
            }
        }
    }

    private void Cj() {
        if (this.azk != null) {
            this.azk.setVisibility(8);
            if (this.azK != null) {
                this.azK.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ck() {
        if ((this.azp || this.azq) && this.azF != null && this.azF.mPicType == 1 && !TextUtils.isEmpty(this.azF.mTagName)) {
            if (this.azl != null) {
                this.azl.setVisibility(8);
                this.azl = null;
            }
            this.azl = new TextView(this.mContext);
            this.azl.setText(this.azF.mTagName);
            this.azl.setTextSize(0, getResources().getDimensionPixelSize(d.e.fontsize26));
            ak.b(this.azl, d.C0126d.common_color_10013, 1, 0);
            ak.j(this.azl, d.C0126d.common_color_10215);
            this.azl.setAlpha(0.75f);
            this.azl.setIncludeFontPadding(false);
            this.azl.setGravity(17);
            int e = l.e(this.mContext, d.e.ds2);
            this.azl.setPadding(e, e, e, e);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.azi.getBottomOffset();
            layoutParams.leftMargin = this.azi.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.azl, layoutParams);
            this.azl.setVisibility(0);
        }
    }

    public void bm(boolean z) {
        this.azI = z;
        if (this.azI) {
            Cj();
        } else {
            Ci();
        }
    }

    public void setUrl(String str, boolean z) {
        if (str.contains("*")) {
            str = str.split("[*]")[0];
        }
        this.azi.setTag(str);
        this.azi.setLoadBigImage(false);
        this.azi.setImageDrawable(null);
        this.azp = false;
        this.azq = false;
        this.azG = Cr();
        this.azj.setVisibility(8);
        if (fE(str)) {
            b(str, z, false);
        }
    }

    private boolean Cl() {
        return this.azi != null && this.azi.In();
    }

    public void Cm() {
        if (this.azF != null && !Cl()) {
            String str = this.azF.imageUrl;
            int i = this.azF.urlType;
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
        if (!this.azH || z) {
            this.azH = true;
            if (!this.azG || this.azF == null || StringUtils.isNull(this.azF.originalUrl, true) || this.azF.originalSize < 0 || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String str = this.azE + am.vK().ef(em) + "/" + aq.em(this.azF.originalUrl);
            final int[] dG = k.dG(str);
            this.azm.setVisibility(0);
            if (this.azn == null) {
                this.azn = new SubsamplingScaleImageView.OnImageEventListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12
                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onReady() {
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.azi.Ij();
                        UrlDragImageView.this.azi.setVisibility(4);
                    }

                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onImageLoaded() {
                        if (UrlDragImageView.this.azF.isLongPic && dG[0] > 0) {
                            UrlDragImageView.this.azi.onDestroy();
                            final float measuredWidth = (UrlDragImageView.this.getMeasuredWidth() * 1.0f) / dG[0];
                            final PointF pointF = new PointF((dG[0] * 1.0f) / 2.0f, 0.0f);
                            UrlDragImageView.this.azm.setScaleAndCenter(measuredWidth, pointF);
                            UrlDragImageView.this.azm.setMaxScale(2.0f * measuredWidth);
                            UrlDragImageView.this.azm.setDoubleTapZoomScale(2.0f * measuredWidth);
                            UrlDragImageView.this.azm.setInitScale(measuredWidth);
                            UrlDragImageView.this.azm.setDoubleTapZoomStyle(4);
                            UrlDragImageView.this.azm.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12.1
                                @Override // android.view.View.OnTouchListener
                                public boolean onTouch(View view2, MotionEvent motionEvent) {
                                    if (UrlDragImageView.this.azM != null) {
                                        UrlDragImageView.this.azM.onTouch(view2, motionEvent);
                                    }
                                    switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                                        case 0:
                                            UrlDragImageView.this.azO = motionEvent.getY();
                                            UrlDragImageView.this.azm.setOnClickListener(UrlDragImageView.this.azN ? UrlDragImageView.this.mOnClickListener : null);
                                            UrlDragImageView.this.azm.setOnLongClickListener(UrlDragImageView.this.azN ? UrlDragImageView.this.azP : null);
                                            break;
                                        case 1:
                                        case 3:
                                            if (UrlDragImageView.this.azm.getScale() < measuredWidth) {
                                                UrlDragImageView.this.azm.setScaleAndCenter(measuredWidth, pointF);
                                            }
                                            e.fw().removeCallbacks(UrlDragImageView.this.azQ);
                                            e.fw().postDelayed(UrlDragImageView.this.azQ, 1000L);
                                            break;
                                        case 2:
                                            if (Math.abs(motionEvent.getY() - UrlDragImageView.this.azO) > UrlDragImageView.TOUCH_SLOP) {
                                                UrlDragImageView.this.azN = false;
                                                UrlDragImageView.this.azm.setOnClickListener(null);
                                                UrlDragImageView.this.azm.setOnLongClickListener(null);
                                            }
                                            UrlDragImageView.this.azO = motionEvent.getY();
                                            break;
                                    }
                                    return false;
                                }
                            });
                            UrlDragImageView.this.azi.setVisibility(4);
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
            this.azm.setOnImageEventListener(this.azn);
            if (this.azm.isImageLoaded() && this.azF.isLongPic) {
                this.azn.onImageLoaded();
            } else {
                this.azm.setImage(ImageSource.uri(str));
            }
            return true;
        }
        return false;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.azC = dVar;
        if (this.azi != null) {
            this.azi.setDragToExitListener(dVar);
        }
    }

    public void Cn() {
        bn(false);
    }

    private boolean fE(String str) {
        return j.gP() || c.eD(str);
    }

    private void setThumbBitmapToView(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap km;
        if (!this.azq && aVar != null && (km = aVar.km()) != null) {
            this.azp = true;
            if (aVar.isGif()) {
                this.azi.setImageUrlData(this.azF);
                this.azi.setImageBitmap(km);
                this.azj.setVisibility(8);
                this.azJ = false;
            } else {
                if (this.azF != null && this.azF.isLongPic) {
                    this.azi.Ic();
                    this.azi.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.13
                        @Override // com.baidu.tbadk.widget.largeImage.logic.a
                        public void Cv() {
                        }
                    });
                }
                this.azi.setImageUrlData(this.azF);
                this.azi.setImageData(km, aVar.kr());
            }
            Ci();
            Ck();
        }
    }

    private void b(String str, boolean z, boolean z2) {
        if (fF(str)) {
            if (z2 || (!this.azr && !this.azq)) {
                if (!z2 || !bn(true)) {
                    this.azr = true;
                    com.baidu.adp.lib.f.c.fp().a(str, 27, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.14
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onCancelled(String str2) {
                            UrlDragImageView.this.azr = false;
                            UrlDragImageView.this.azi.setVisibility(0);
                            UrlDragImageView.this.mProgressBar.setVisibility(8);
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            UrlDragImageView.this.azr = false;
                            UrlDragImageView.this.azq = true;
                            UrlDragImageView.this.b(aVar);
                        }
                    }, 0, 0, false, null, Boolean.valueOf(z), this.azi.getImageData(), Boolean.valueOf(this.ayh));
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
        com.baidu.adp.widget.ImageView.a a2 = this.azL.a(imageFileInfo, false);
        if (a2 != null) {
            this.azq = true;
            this.mProgressBar.setVisibility(8);
            b(a2);
            return;
        }
        this.azL.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.2
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.ImageView.a aVar, String str2, boolean z3) {
                UrlDragImageView.this.azq = true;
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
        if (aVar != null && this.azo != null) {
            this.azo.j(aVar.getUrl(), aVar.kr());
        }
        if (aVar == null || aVar.km() == null) {
            Co();
            return;
        }
        Bitmap km = aVar.km();
        this.azi.setLoadBigImage(true);
        if (aVar.isGif()) {
            this.azi.setGifData(aVar.kr(), km);
            this.azi.invalidate();
            this.azi.play();
            this.azJ = false;
            this.azj.setVisibility(8);
            this.mProgressBar.setVisibility(8);
        } else {
            if (this.azF != null && this.azF.isLongPic) {
                this.azi.Ic();
                this.azi.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.3
                    @Override // com.baidu.tbadk.widget.largeImage.logic.a
                    public void Cv() {
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                    }
                });
            } else {
                this.mProgressBar.setVisibility(8);
            }
            this.azi.setImageUrlData(this.azF);
            this.azi.setImageData(km, aVar.kr());
            Cs();
        }
        Ci();
        Ck();
    }

    private void Co() {
        if (!this.azp) {
            this.azi.setDefaultBitmap();
        } else {
            this.azq = false;
        }
        this.azj.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    public void setGifMaxUseableMem(int i) {
        this.azi.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.azi != null) {
            this.azi.onDestroy();
        }
        if (this.azm != null) {
            this.azm.recycle();
        }
        if (this.azu != null) {
            this.azu.recycle();
            this.azu = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        e.fw().removeCallbacks(this.azQ);
    }

    public void release() {
        if (this.azi != null) {
            this.azi.release();
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.azj != null) {
            this.azj.setVisibility(8);
        }
    }

    public void Cp() {
        if (this.azi != null && this.azi.getImageType() == 1) {
            this.azi.stop();
        }
    }

    public void i(boolean z, boolean z2) {
        String str;
        if (this.azi != null && (str = (String) this.azi.getTag()) != null) {
            if (this.azi.getImageType() == 1) {
                if (this.azi.getGifCache() == null || !this.azi.In()) {
                    b(str, z, z2);
                }
            } else if (this.azi.getImageType() == 2) {
                b(str, z, z2);
            } else if (Cq()) {
                b(str, z, z2);
            }
        }
    }

    private boolean Cq() {
        if (this.azi.getImageBitmap() != null && this.azi.In()) {
            if (this.azF == null || !this.azF.isLongPic || this.azi.Id()) {
                return false;
            }
            this.azq = false;
            this.azH = false;
            return true;
        }
        return true;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.azF = imageUrlData;
    }

    public void setIsCdn(boolean z) {
        this.ayh = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.azj) {
            if (!(this.azj.getTag() instanceof Boolean) || ((Boolean) this.azj.getTag()).booleanValue()) {
                final String em = aq.em(this.azF.originalUrl);
                if (this.azF.originalProcess >= 0) {
                    com.baidu.tbadk.download.e.Dy().z(em, 13);
                    this.azF.originalProcess = -1;
                    Cs();
                    return;
                }
                if (this.ayj != null) {
                    this.ayj.Cw();
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
                    aVar.tD();
                }
            }
        } else if (view2 == this.azk && this.azF != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.mContext).createHistoryCfg(String.valueOf(this.azF.threadId), String.valueOf(this.azF.postId), this.azF.mIsSeeHost, this.azF.mIsReserver, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fG(String str) {
        if (this.azF != null) {
            this.azF.originalProcess = 0;
        }
        this.azj.setText("0%");
        this.azj.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_close_yuantu, 0);
        DownloadData downloadData = new DownloadData(str);
        downloadData.setStatus(1);
        downloadData.setUrl(this.azF.originalUrl);
        downloadData.setType(13);
        downloadData.setPath(this.azE + am.vK().ef(str) + "/" + str);
        downloadData.setCallback(new com.baidu.tbadk.download.d() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.6
            @Override // com.baidu.tbadk.download.d
            public boolean onPreDownload(DownloadData downloadData2) {
                return true;
            }

            @Override // com.baidu.tbadk.download.d
            public void onFileUpdateProgress(DownloadData downloadData2) {
                if (downloadData2 != null) {
                    if (UrlDragImageView.this.azF != null && UrlDragImageView.this.azF.originalProcess != -1) {
                        UrlDragImageView.this.azF.originalProcess = downloadData2.getProcess();
                    }
                    if (UrlDragImageView.this.azF == null || UrlDragImageView.this.azF.originalProcess != -1) {
                        UrlDragImageView.this.azj.setText(downloadData2.getProcess() + "%");
                        UrlDragImageView.this.azj.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_close_yuantu, 0);
                    }
                }
            }

            @Override // com.baidu.tbadk.download.d
            public boolean onFileDownloaded(DownloadData downloadData2) {
                return true;
            }

            @Override // com.baidu.tbadk.download.d
            public void onFileDownloadSucceed(DownloadData downloadData2) {
                UrlDragImageView.this.azj.setText(UrlDragImageView.this.getResources().getString(d.k.done));
                UrlDragImageView.this.azj.setTag(false);
                UrlDragImageView.this.azj.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                e.fw().postDelayed(UrlDragImageView.this.azR, 1500L);
                UrlDragImageView.this.azH = false;
                UrlDragImageView.this.azG = UrlDragImageView.this.Cr();
                UrlDragImageView.this.Cn();
            }

            @Override // com.baidu.tbadk.download.d
            public void onFileDownloadFailed(DownloadData downloadData2, int i, String str2) {
                UrlDragImageView.this.azH = false;
                BdToast.a(UrlDragImageView.this.mContext, str2).tJ().tL();
                UrlDragImageView.this.azF.originalProcess = -1;
                UrlDragImageView.this.Cs();
            }
        });
        com.baidu.tbadk.download.e.Dy().a(downloadData, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Cr() {
        if (this.azF != null && !StringUtils.isNull(this.azF.originalUrl, true) && this.azF.originalSize >= 0 && !this.azF.isBlockedPic) {
            String em = aq.em(this.azF.originalUrl);
            File file = new File(this.azE + am.vK().ef(em) + "/" + em);
            if (file != null && file.exists()) {
                this.azF.originalProcess = 100;
                return true;
            }
            if (this.azF.originalProcess < 0) {
                Cs();
            } else {
                this.azj.setText(this.azF.originalProcess + "%");
                this.azj.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_close_yuantu, 0);
            }
            this.azJ = true;
        } else {
            this.azj.setVisibility(8);
        }
        return false;
    }

    public void Cs() {
        if (this.azF != null) {
            if (!Ct() || !this.azJ) {
                this.azj.setVisibility(8);
            } else {
                this.azj.setVisibility(0);
            }
            if (this.azF.originalSize > 0 && !R(this.azF.originalSize)) {
                this.azj.setText(azg + "(" + an.G(this.azF.originalSize) + ")");
            } else {
                this.azj.setText(azg);
            }
            this.azj.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    private boolean Ct() {
        return (this.azF == null || !this.azF.mIsShowOrigonButton || this.azF.isBlockedPic || StringUtils.isNull(this.azF.originalUrl)) ? false : true;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.ayj = bVar;
    }

    private boolean R(long j) {
        return j > azh;
    }
}
