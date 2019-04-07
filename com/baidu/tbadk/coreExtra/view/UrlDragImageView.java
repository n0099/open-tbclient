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
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.util.f;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.d;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.File;
/* loaded from: classes3.dex */
public class UrlDragImageView extends RelativeLayout {
    private ImageUrlData cbY;
    private b cdk;
    private boolean cds;
    private boolean cdu;
    private boolean cdv;
    protected DragImageView ceM;
    protected TextView ceN;
    protected SubsamplingScaleImageView ceO;
    private SubsamplingScaleImageView.OnImageEventListener ceP;
    private a ceQ;
    private boolean ceR;
    private boolean ceS;
    private boolean ceT;
    private boolean ceU;
    private boolean ceV;
    private Bitmap ceW;
    private boolean ceX;
    private float ceY;
    private final Matrix ceZ;
    private Runnable cfA;
    private Runnable cfB;
    private View.OnTouchListener cfC;
    private Rect cfa;
    private RectF cfb;
    private RectF cfc;
    private Rect cfd;
    private Rect cfe;
    private Rect cff;
    private DragImageView.d cfg;
    private String cfi;
    private float cfj;
    private float cfk;
    private float cfl;
    private float cfm;
    private float cfn;
    private boolean cfo;
    private boolean cfp;
    private boolean cfq;
    public boolean cfr;
    private com.baidu.tbadk.img.b cfs;
    private View.OnTouchListener cft;
    private boolean cfu;
    private float cfv;
    private View.OnLongClickListener cfw;
    private String cfx;
    private CircleProgressView cfy;
    private boolean cfz;
    protected Context mContext;
    private float mLastMotionX;
    private float mLastMotionY;
    private int mMaxHeight;
    private int mMaxWidth;
    private View.OnClickListener mOnClickListener;
    protected ProgressBar mProgressBar;
    private float mRatio;
    private int mSkinType;
    private String mUserId;
    private static final String ceK = TbadkCoreApplication.getInst().getString(d.j.original_img_look);
    private static long ceL = Config.RAVEN_LOG_LIMIT;
    private static final int cfh = l.aQ(TbadkCoreApplication.getInst()) / 5;
    private static final String TAG = UrlDragImageView.class.getSimpleName();
    private static final int TOUCH_SLOP = ViewConfiguration.get(TbadkCoreApplication.getInst()).getScaledTouchSlop();

    /* loaded from: classes3.dex */
    public interface a {
        void i(String str, byte[] bArr);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void akF();
    }

    public void setUserId(String str) {
        this.mUserId = str;
    }

    public String getUserId() {
        return this.mUserId;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
        }
    }

    public void setHeadImage(boolean z) {
        if (this.ceM != null) {
            this.ceM.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.ceQ = aVar;
    }

    public UrlDragImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.ceM = null;
        this.ceQ = null;
        this.cds = false;
        this.ceT = false;
        this.ceX = false;
        this.mRatio = 1.0f;
        this.ceY = 0.0f;
        this.ceZ = new Matrix();
        this.cfb = new RectF();
        this.cfj = 0.0f;
        this.cfk = 0.0f;
        this.cfl = 1.0f;
        this.cfm = 1.0f;
        this.cfn = 0.0f;
        this.cfo = false;
        this.cfp = false;
        this.cfq = false;
        this.cfr = false;
        this.cfu = true;
        this.cfv = 0.0f;
        this.mOnClickListener = null;
        this.cfw = null;
        this.cfx = null;
        this.cfA = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.cfu = true;
            }
        };
        this.cfB = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.cfy.setVisibility(8);
                        UrlDragImageView.this.cfx = null;
                        UrlDragImageView.this.cfr = false;
                    }
                });
            }
        };
        this.cfC = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.cft != null) {
                    UrlDragImageView.this.cft.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.cfs = new com.baidu.tbadk.img.b();
        init();
    }

    public UrlDragImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.ceM = null;
        this.ceQ = null;
        this.cds = false;
        this.ceT = false;
        this.ceX = false;
        this.mRatio = 1.0f;
        this.ceY = 0.0f;
        this.ceZ = new Matrix();
        this.cfb = new RectF();
        this.cfj = 0.0f;
        this.cfk = 0.0f;
        this.cfl = 1.0f;
        this.cfm = 1.0f;
        this.cfn = 0.0f;
        this.cfo = false;
        this.cfp = false;
        this.cfq = false;
        this.cfr = false;
        this.cfu = true;
        this.cfv = 0.0f;
        this.mOnClickListener = null;
        this.cfw = null;
        this.cfx = null;
        this.cfA = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.cfu = true;
            }
        };
        this.cfB = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.cfy.setVisibility(8);
                        UrlDragImageView.this.cfx = null;
                        UrlDragImageView.this.cfr = false;
                    }
                });
            }
        };
        this.cfC = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.cft != null) {
                    UrlDragImageView.this.cft.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.cfs = new com.baidu.tbadk.img.b();
        init();
    }

    public DragImageView getImageView() {
        return this.ceM;
    }

    public void setGifSetListener(DragImageView.e eVar) {
        this.ceM.setGifSetListener(eVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.ceM.setImageOnClickListener(onClickListener);
        this.ceO.setOnClickListener(onClickListener);
        this.mOnClickListener = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cfw = onLongClickListener;
        if (!this.cdu) {
            this.ceM.setImageOnLongClickListener(this.cfw);
            this.ceO.setOnLongClickListener(this.cfw);
        }
    }

    public void setOnSizeChangedListener(final DragImageView.g gVar) {
        this.ceM.setOnSizeChangedListener(new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.8
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (gVar != null) {
                    gVar.a(dragImageView, z, z2);
                }
                UrlDragImageView.this.aks();
            }
        });
    }

    protected void init() {
        this.cfi = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        this.mMaxWidth = l.aO(this.mContext);
        this.mMaxHeight = l.aQ(this.mContext) - ((int) this.mContext.getResources().getDimension(d.e.ds166));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.ceM = new DragImageView(this.mContext);
        this.ceM.setLayoutParams(layoutParams);
        this.ceM.setOnTouchListener(this.cfC);
        addView(this.ceM);
        this.ceO = new SubsamplingScaleImageView(this.mContext);
        this.ceO.setMaxScale(50.0f);
        this.ceO.setOnTouchListener(this.cfC);
        this.ceO.setVisibility(4);
        addView(this.ceO, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(getResources().getDrawable(d.f.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        akq();
    }

    private void akq() {
        this.cfy = new CircleProgressView(this.mContext);
        this.cfy.setCircleBackgroundColor(al.getColor(d.C0277d.cp_cont_d));
        this.cfy.setCircleForegroundColor(al.getColor(d.C0277d.cp_link_tip_a));
        this.cfy.setProgress(0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.h(getContext(), d.e.tbds80), l.h(getContext(), d.e.tbds80));
        layoutParams.addRule(13);
        this.cfy.setVisibility(8);
        addView(this.cfy, layoutParams);
    }

    public void setIsCanDrag(boolean z) {
        this.cdu = z;
    }

    public void setIsHotSort(boolean z) {
        this.cdv = z;
    }

    public String getmCheckOriginPicText() {
        return this.cfx;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        Bitmap imageBitmap;
        int height;
        int width;
        if (this.cfo && !this.cfz && this.ceO.getVisibility() == 0 && !this.ceO.isImageLoaded()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.cdu || !this.ceS) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.ceU && motionEvent.getPointerCount() >= 2) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.ceU || this.ceV) {
            requestDisallowInterceptTouchEvent(true);
        }
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        float x = motionEvent.getX();
        int i = action & 255;
        if (i == 0) {
            if (this.ceW == null) {
                if (this.ceO.getVisibility() == 0) {
                    this.ceW = f.aZ(this.ceO);
                } else {
                    this.ceW = f.aZ(this.ceM);
                }
            }
            if (this.cfa == null && this.ceW != null) {
                int measuredWidth = getMeasuredWidth();
                float measuredWidth2 = ((getMeasuredWidth() * 1.0f) / this.ceW.getWidth()) * this.ceW.getHeight();
                if (measuredWidth2 > getMeasuredHeight()) {
                    measuredWidth2 = getMeasuredHeight();
                }
                RectF h = h(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
                this.cfa = new Rect((int) h.left, (int) h.top, (int) h.right, (int) h.bottom);
            }
            if (this.cfe == null && this.ceW != null) {
                if (this.ceO.getVisibility() == 0) {
                    height = this.ceO.getSHeight();
                    width = this.ceO.getSWidth();
                } else {
                    if (this.ceM.getImageType() == 1) {
                        imageBitmap = (this.ceM.getCurrentFrame() == null || this.ceM.getCurrentFrame().cuW == null) ? this.ceW : this.ceM.getCurrentFrame().cuW;
                    } else {
                        imageBitmap = this.ceM.getImageBitmap() == null ? this.ceW : this.ceM.getImageBitmap();
                    }
                    height = imageBitmap.getHeight();
                    width = imageBitmap.getWidth();
                }
                float aR = l.aR(getContext());
                int i2 = (int) (height * aR);
                int i3 = (int) (width * aR);
                if (i3 > this.ceW.getWidth() && this.ceW.getWidth() != 0) {
                    float width2 = (i3 * 1.0f) / this.ceW.getWidth();
                    i3 = this.ceW.getWidth();
                    i2 = (int) (i2 / width2);
                }
                if (i2 > this.ceW.getHeight() && this.ceW.getHeight() != 0) {
                    i3 = (int) (i3 / ((i2 * 1.0f) / this.ceW.getHeight()));
                    i2 = this.ceW.getHeight();
                }
                int aQ = (l.aQ(getContext()) - i2) / 2;
                int aO = (l.aO(getContext()) - i3) / 2;
                this.cfe = new Rect(aO, aQ, i3 + aO, i2 + aQ);
                this.cff = new Rect(this.cfe);
                this.cfn = aQ / l.aQ(getContext());
                this.cfd = new Rect(0, 0, this.ceW.getWidth(), this.ceW.getHeight());
            }
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (i == 2) {
            this.ceU = r(this.mLastMotionX - x, this.mLastMotionY - y);
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (this.ceU || this.ceV) {
            this.ceM.setImageOnLongClickListener(null);
            this.ceO.setOnLongClickListener(null);
            z = true;
        } else {
            this.ceM.setImageOnLongClickListener(this.cfw);
            this.ceO.setOnLongClickListener(this.cfw);
            z = super.dispatchTouchEvent(motionEvent);
        }
        if (i == 1 || i == 3) {
            this.mLastMotionX = 0.0f;
            this.mLastMotionY = 0.0f;
            if (this.ceY > cfh) {
                this.ceV = true;
                akr();
            } else {
                if (this.ceU && this.cfg != null) {
                    this.cfg.aqR();
                }
                this.mRatio = 1.0f;
                invalidate();
            }
            this.ceX = false;
            this.ceZ.reset();
            this.ceU = false;
            return z;
        }
        return z;
    }

    private boolean r(float f, float f2) {
        if (this.ceO.getVisibility() != 0 || this.ceO.isCanDrag()) {
            if (this.cbY == null || !this.cbY.isLongPic || this.ceO.getVisibility() != 0 || this.ceO.isViewTop()) {
                if (this.cbY == null || !this.cbY.isLongPic || this.ceO.getVisibility() == 0 || this.ceM.aqx()) {
                    if (this.ceO.getVisibility() == 0 || this.ceM.aqz()) {
                        if (this.ceW != null && getScrollY() == 0 && f2 < 0.0f && !this.ceX) {
                            this.ceM.setImageOnLongClickListener(null);
                            this.ceO.setOnLongClickListener(null);
                            this.ceX = true;
                            this.ceY = 0.0f;
                            this.mRatio = 1.0f;
                            if (this.cfg != null) {
                                this.cfg.aqP();
                            }
                        }
                        if (!this.ceX || this.ceW == null) {
                            return false;
                        }
                        this.ceY -= f2;
                        int measuredHeight = getMeasuredHeight();
                        if (this.ceY > measuredHeight) {
                            this.ceY = measuredHeight;
                        }
                        float f3 = f2 / measuredHeight;
                        this.ceZ.postTranslate((-f) * 1.5f * this.mRatio, (-1.5f) * f2 * this.mRatio);
                        if (this.mRatio * (1.0f + f3) > 1.0f || this.ceY < 0.0f) {
                            this.ceZ.preScale(1.0f / this.mRatio, 1.0f / this.mRatio, (this.mRatio * this.ceW.getWidth()) / 2.0f, this.mRatio * (this.ceW.getHeight() / 2));
                            this.mRatio = 1.0f;
                        } else {
                            this.ceZ.preScale(1.0f + f3, 1.0f + f3, (this.mRatio * this.ceW.getWidth()) / 2.0f, this.mRatio * (this.ceW.getHeight() / 2));
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

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.ceU && this.ceW != null && !this.ceW.isRecycled() && this.ceX) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.cfb == null) {
                this.cfb = new RectF();
            }
            this.ceZ.mapRect(this.cfb, new RectF(this.cfa));
            canvas.drawBitmap(this.ceW, this.cfd, this.cfb, (Paint) null);
        } else if (this.ceV && this.ceW != null && !this.ceW.isRecycled()) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.cbY == null || this.cbY.getSourceImageRectInScreen() == null) {
                canvas.drawBitmap(this.ceW, this.cfd, this.cfb, (Paint) null);
            } else {
                canvas.drawBitmap(this.ceW, this.cfe, this.cfb, (Paint) null);
            }
        } else {
            super.dispatchDraw(canvas);
        }
    }

    private void akr() {
        if (this.cbY == null) {
            if (this.cfg != null) {
                this.cfg.aqQ();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.cbY.getSourceImageRectInScreen();
        final Rect dstRectInScreen = this.cbY.getDstRectInScreen();
        if (sourceImageRectInScreen == null || dstRectInScreen == null) {
            if (this.cfg != null) {
                this.cfg.aqQ();
                return;
            }
            return;
        }
        a(sourceImageRectInScreen, dstRectInScreen);
        f(sourceImageRectInScreen);
        this.cfc = new RectF(this.cfb);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(150L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && sourceImageRectInScreen != null && dstRectInScreen != null) {
                    UrlDragImageView.this.an(valueAnimator.getAnimatedFraction());
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
                UrlDragImageView.this.ceX = false;
                UrlDragImageView.this.invalidate();
                if (UrlDragImageView.this.cfg != null) {
                    UrlDragImageView.this.cfg.aqQ();
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

    private void f(Rect rect) {
        if (rect != null) {
            float f = ((rect.bottom - rect.top) / (rect.right - rect.left)) * (this.cfb.right - this.cfb.left);
            this.cfb.top += this.cfb.height() * this.cfn;
            this.cfb.bottom = f + this.cfb.top;
        }
    }

    public void setCanScale(boolean z) {
        if (this.ceM != null) {
            this.ceM.setCanScale(z);
        }
    }

    private void a(Rect rect, Rect rect2) {
        this.cfj = 0.0f;
        this.cfk = 0.0f;
        this.cfl = 1.0f;
        this.cfm = 1.0f;
        if (rect != null && rect2 != null && rect.contains(rect2)) {
            this.cfj = (rect2.left - rect.left) / rect.width();
            this.cfk = (rect2.top - rect.top) / rect.height();
            this.cfl = (rect2.right - rect.left) / rect.width();
            this.cfm = (rect2.bottom - rect.top) / rect.height();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void an(float f) {
        if (this.cfe != null) {
            this.cfe.left = (int) (this.cff.left + (this.cff.width() * this.cfj * f));
            this.cfe.top = (int) (this.cff.top + (this.cff.height() * this.cfk * f));
            this.cfe.right = (int) (this.cff.left + (this.cff.width() * (((1.0f - this.cfl) * (1.0f - f)) + this.cfl)));
            this.cfe.bottom = (int) (this.cff.top + (this.cff.height() * (((1.0f - this.cfm) * (1.0f - f)) + this.cfm)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Rect rect, float f) {
        if (this.cfb != null && rect != null) {
            this.cfb.left = this.cfc.left + ((rect.left - this.cfc.left) * f);
            this.cfb.top = this.cfc.top + ((rect.top - this.cfc.top) * f);
            this.cfb.right = this.cfc.right + ((rect.right - this.cfc.right) * f);
            this.cfb.bottom = this.cfc.bottom + ((rect.bottom - this.cfc.bottom) * f);
        }
    }

    private RectF h(float f, float f2, float f3, float f4) {
        return new RectF(f - (f3 / 2.0f), f2 - (f4 / 2.0f), (f3 / 2.0f) + f, (f4 / 2.0f) + f2);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.cft = onTouchListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aks() {
        if ((this.ceR || this.ceS) && this.cbY != null && this.cbY.mPicType == 1 && !TextUtils.isEmpty(this.cbY.mTagName)) {
            if (this.ceN != null) {
                this.ceN.setVisibility(8);
                this.ceN = null;
            }
            this.ceN = new TextView(this.mContext);
            this.ceN.setText(this.cbY.mTagName);
            this.ceN.setTextSize(0, getResources().getDimensionPixelSize(d.e.fontsize26));
            al.c(this.ceN, d.C0277d.common_color_10013, 1, 0);
            al.l(this.ceN, d.C0277d.common_color_10215);
            this.ceN.setAlpha(0.75f);
            this.ceN.setIncludeFontPadding(false);
            this.ceN.setGravity(17);
            int h = l.h(this.mContext, d.e.ds2);
            this.ceN.setPadding(h, h, h, h);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.ceM.getBottomOffset();
            layoutParams.leftMargin = this.ceM.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.ceN, layoutParams);
            this.ceN.setVisibility(0);
        }
    }

    public void setUrl(String str, boolean z) {
        if (str.contains("*")) {
            str = str.split("[*]")[0];
        }
        this.ceM.setTag(str);
        this.ceM.setLoadBigImage(false);
        this.ceM.setImageDrawable(null);
        this.ceR = false;
        this.ceS = false;
        this.cfo = akA();
        this.cfx = null;
        if (ol(str)) {
            e(str, z, false);
        }
    }

    private boolean akt() {
        return this.ceM != null && this.ceM.aqN();
    }

    public void aku() {
        if (this.cbY != null && !akt()) {
            String str = this.cbY.imageUrl;
            int i = this.cbY.urlType;
            com.baidu.adp.widget.ImageView.a aVar = null;
            if (com.baidu.tbadk.core.util.d.a.Y(str, i)) {
                aVar = com.baidu.tbadk.core.util.d.a.Z(str, i);
            }
            if (aVar != null) {
                setThumbBitmapToView(aVar);
            }
        }
    }

    private boolean ev(boolean z) {
        String mL;
        if (!this.cfp || z) {
            this.cfp = true;
            if (!this.cfo || this.cbY == null || StringUtils.isNull(this.cbY.originalUrl, true) || this.cbY.originalSize < 0 || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String str = this.cfi + ao.adh().mC(mL) + "/" + as.mL(this.cbY.originalUrl);
            final int[] mf = m.mf(str);
            this.ceO.setVisibility(0);
            if (this.ceP == null) {
                this.ceP = new SubsamplingScaleImageView.OnImageEventListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12
                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onReady() {
                        UrlDragImageView.this.cfx = null;
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.ceM.aqJ();
                        UrlDragImageView.this.ceM.setVisibility(4);
                    }

                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onImageLoaded() {
                        if (UrlDragImageView.this.cbY.isLongPic && mf[0] > 0) {
                            UrlDragImageView.this.ceM.onDestroy();
                            final float measuredWidth = (UrlDragImageView.this.getMeasuredWidth() * 1.0f) / mf[0];
                            final PointF pointF = new PointF((mf[0] * 1.0f) / 2.0f, 0.0f);
                            UrlDragImageView.this.ceO.setScaleAndCenter(measuredWidth, pointF);
                            UrlDragImageView.this.ceO.setMaxScale(2.0f * measuredWidth);
                            UrlDragImageView.this.ceO.setDoubleTapZoomScale(2.0f * measuredWidth);
                            UrlDragImageView.this.ceO.setInitScale(measuredWidth);
                            UrlDragImageView.this.ceO.setDoubleTapZoomStyle(4);
                            UrlDragImageView.this.ceO.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12.1
                                @Override // android.view.View.OnTouchListener
                                public boolean onTouch(View view, MotionEvent motionEvent) {
                                    if (UrlDragImageView.this.cft != null) {
                                        UrlDragImageView.this.cft.onTouch(view, motionEvent);
                                    }
                                    switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                                        case 0:
                                            UrlDragImageView.this.cfv = motionEvent.getY();
                                            UrlDragImageView.this.ceO.setOnClickListener(UrlDragImageView.this.cfu ? UrlDragImageView.this.mOnClickListener : null);
                                            UrlDragImageView.this.ceO.setOnLongClickListener(UrlDragImageView.this.cfu ? UrlDragImageView.this.cfw : null);
                                            break;
                                        case 1:
                                        case 3:
                                            if (UrlDragImageView.this.ceO.getScale() < measuredWidth) {
                                                UrlDragImageView.this.ceO.setScaleAndCenter(measuredWidth, pointF);
                                            }
                                            e.jH().removeCallbacks(UrlDragImageView.this.cfA);
                                            e.jH().postDelayed(UrlDragImageView.this.cfA, 1000L);
                                            break;
                                        case 2:
                                            if (Math.abs(motionEvent.getY() - UrlDragImageView.this.cfv) > UrlDragImageView.TOUCH_SLOP) {
                                                UrlDragImageView.this.cfu = false;
                                                UrlDragImageView.this.ceO.setOnClickListener(null);
                                                UrlDragImageView.this.ceO.setOnLongClickListener(null);
                                            }
                                            UrlDragImageView.this.cfv = motionEvent.getY();
                                            break;
                                    }
                                    return false;
                                }
                            });
                            UrlDragImageView.this.ceM.setVisibility(4);
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
            this.ceO.setOnImageEventListener(this.ceP);
            if (this.ceO.isImageLoaded() && this.cbY.isLongPic) {
                this.ceP.onImageLoaded();
            } else {
                this.ceO.setImage(ImageSource.uri(str));
            }
            return true;
        }
        return false;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.cfg = dVar;
        if (this.ceM != null) {
            this.ceM.setDragToExitListener(dVar);
        }
    }

    public void akv() {
        ev(false);
    }

    private boolean ol(String str) {
        return j.kY() || com.baidu.tbadk.core.util.d.c.nc(str);
    }

    private void setThumbBitmapToView(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap oy;
        if (!this.ceS && aVar != null && (oy = aVar.oy()) != null) {
            this.ceR = true;
            if (aVar.isGif()) {
                this.ceM.setImageUrlData(this.cbY);
                this.ceM.setImageBitmap(oy);
                this.cfx = null;
                this.cfr = false;
            } else {
                if (this.cbY != null && this.cbY.isLongPic) {
                    this.ceM.aqC();
                    this.ceM.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.13
                        @Override // com.baidu.tbadk.widget.largeImage.logic.a
                        public void akE() {
                        }
                    });
                }
                this.ceM.setImageUrlData(this.cbY);
                this.ceM.setImageData(oy, aVar.oD());
            }
            aks();
        }
    }

    private void e(String str, boolean z, boolean z2) {
        if (om(str)) {
            if (z2 || (!this.ceT && !this.ceS)) {
                if (!z2 || !ev(true)) {
                    this.ceT = true;
                    com.baidu.adp.lib.f.c.jB().a(str, 27, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.14
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onCancelled(String str2) {
                            UrlDragImageView.this.ceT = false;
                            UrlDragImageView.this.ceM.setVisibility(0);
                            UrlDragImageView.this.mProgressBar.setVisibility(8);
                            UrlDragImageView.this.cfx = null;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            UrlDragImageView.this.ceT = false;
                            UrlDragImageView.this.ceS = true;
                            UrlDragImageView.this.b(aVar);
                        }
                    }, 0, 0, false, null, Boolean.valueOf(z), this.ceM.getImageData(), Boolean.valueOf(this.cds));
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
        imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.ai(this.mMaxWidth, this.mMaxHeight));
        com.baidu.adp.widget.ImageView.a a2 = this.cfs.a(imageFileInfo, false);
        if (a2 != null) {
            this.ceS = true;
            this.mProgressBar.setVisibility(8);
            this.cfx = null;
            b(a2);
            return;
        }
        this.cfs.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.2
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.ImageView.a aVar, String str2, boolean z3) {
                UrlDragImageView.this.ceS = true;
                UrlDragImageView.this.mProgressBar.setVisibility(8);
                UrlDragImageView.this.cfx = null;
                UrlDragImageView.this.b(aVar);
            }
        }, false);
    }

    private boolean om(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith("https://"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null && this.ceQ != null) {
            this.ceQ.i(aVar.getUrl(), aVar.oD());
        }
        if (aVar == null || aVar.oy() == null) {
            akw();
            return;
        }
        Bitmap oy = aVar.oy();
        this.ceM.setLoadBigImage(true);
        if (aVar.isGif()) {
            this.ceM.setGifData(aVar.oD(), oy);
            this.ceM.invalidate();
            this.ceM.play();
            this.cfr = false;
            this.cfx = null;
            this.mProgressBar.setVisibility(8);
        } else {
            if (this.cbY != null && this.cbY.isLongPic) {
                this.ceM.aqC();
                this.ceM.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.3
                    @Override // com.baidu.tbadk.widget.largeImage.logic.a
                    public void akE() {
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.cfx = null;
                    }
                });
            } else {
                this.mProgressBar.setVisibility(8);
                this.cfx = null;
            }
            this.ceM.setImageUrlData(this.cbY);
            this.ceM.setImageData(oy, aVar.oD());
            akB();
        }
        aks();
    }

    private void akw() {
        if (!this.ceR) {
            this.ceM.setDefaultBitmap();
        } else {
            this.ceS = false;
        }
        this.cfx = null;
        this.mProgressBar.setVisibility(8);
    }

    public void setGifMaxUseableMem(int i) {
        this.ceM.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.ceM != null) {
            this.ceM.onDestroy();
        }
        if (this.ceO != null) {
            this.ceO.recycle();
        }
        if (this.ceW != null) {
            this.ceW.recycle();
            this.ceW = null;
        }
        if (this.mProgressBar != null) {
            this.cfx = null;
            this.mProgressBar.setVisibility(8);
        }
        e.jH().removeCallbacks(this.cfA);
        com.baidu.tieba.view.c.cmY().setColor(-1);
    }

    public void release() {
        if (this.ceM != null) {
            this.ceM.release();
        }
        if (this.mProgressBar != null) {
            this.cfx = null;
            this.mProgressBar.setVisibility(8);
        }
        this.cfx = null;
    }

    public void akx() {
        if (this.ceM != null && this.ceM.getImageType() == 1) {
            this.ceM.stop();
        }
    }

    public void o(boolean z, boolean z2) {
        String str;
        if (this.ceM != null && (str = (String) this.ceM.getTag()) != null) {
            if (this.ceM.getImageType() == 1) {
                if (this.ceM.getGifCache() == null || !this.ceM.aqN()) {
                    e(str, z, z2);
                }
            } else if (this.ceM.getImageType() == 2) {
                e(str, z, z2);
            } else if (aky()) {
                e(str, z, z2);
            }
        }
    }

    private boolean aky() {
        if (this.ceM.getImageBitmap() != null && this.ceM.aqN()) {
            if (this.cbY == null || !this.cbY.isLongPic || this.ceM.aqD()) {
                return false;
            }
            this.ceS = false;
            this.cfp = false;
            return true;
        }
        return true;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.cbY = imageUrlData;
    }

    public ImageUrlData getmAssistUrlData() {
        return this.cbY;
    }

    public void setIsCdn(boolean z) {
        this.cds = z;
    }

    public void akz() {
        final String mL = as.mL(this.cbY.originalUrl);
        if (this.cbY.originalProcess >= 0) {
            com.baidu.tbadk.download.d.alJ().ac(mL, 13);
            this.cbY.originalProcess = -1;
            akB();
            return;
        }
        if (this.cdk != null) {
            this.cdk.akF();
        }
        com.baidu.adp.base.e<?> aK = i.aK(this.mContext);
        if (aK == null) {
            oo(mL);
        } else if (!j.kY() || j.kZ() || com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("original_img_down_tip", false)) {
            oo(mL);
        } else {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("original_img_down_tip", true);
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(aK.getPageActivity());
            aVar.gC(d.j.original_img_down_no_wifi_tip);
            aVar.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    UrlDragImageView.this.oo(mL);
                }
            });
            aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                }
            });
            aVar.b(aK);
            aVar.aaW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oo(String str) {
        if (this.cbY != null) {
            this.cbY.originalProcess = 0;
            this.cfy.setProgress(0);
            this.cfy.setVisibility(0);
            DownloadData downloadData = new DownloadData(str);
            downloadData.setStatus(1);
            downloadData.setUrl(this.cbY.originalUrl);
            downloadData.setType(13);
            downloadData.setPath(this.cfi + ao.adh().mC(str) + "/" + str);
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.6
                @Override // com.baidu.tbadk.download.c
                public boolean onPreDownload(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2 != null) {
                        if (UrlDragImageView.this.cbY != null && UrlDragImageView.this.cbY.originalProcess != -1) {
                            UrlDragImageView.this.cbY.originalProcess = downloadData2.getProcess();
                        }
                        if (UrlDragImageView.this.cbY == null || UrlDragImageView.this.cbY.originalProcess != -1) {
                            UrlDragImageView.this.cfy.setProgress(downloadData2.getProcess());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public boolean onFileDownloaded(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadSucceed(DownloadData downloadData2) {
                    UrlDragImageView.this.cfy.setVisibility(8);
                    e.jH().postDelayed(UrlDragImageView.this.cfB, 1500L);
                    UrlDragImageView.this.cfp = false;
                    UrlDragImageView.this.cfo = UrlDragImageView.this.akA();
                    UrlDragImageView.this.akv();
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str2) {
                    UrlDragImageView.this.cfy.setVisibility(8);
                    UrlDragImageView.this.cfp = false;
                    BdToast.b(UrlDragImageView.this.mContext, str2).abc().abe();
                    UrlDragImageView.this.cbY.originalProcess = -1;
                    UrlDragImageView.this.akB();
                }
            });
            com.baidu.tbadk.download.d.alJ().a(downloadData, 100);
            this.cfz = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean akA() {
        if (this.cbY != null && !StringUtils.isNull(this.cbY.originalUrl, true) && this.cbY.originalSize >= 0 && !this.cbY.isBlockedPic) {
            String mL = as.mL(this.cbY.originalUrl);
            File file = new File(this.cfi + ao.adh().mC(mL) + "/" + mL);
            if (file != null && file.exists()) {
                this.cbY.originalProcess = 100;
                return true;
            }
            if (this.cbY.originalProcess < 0) {
                akB();
            } else {
                this.cfy.setProgress(this.cbY.originalProcess);
            }
            this.cfr = true;
        } else {
            this.cfx = null;
        }
        return false;
    }

    public void akB() {
        if (this.cbY != null) {
            if (!akC() || !this.cfr) {
                this.cfx = null;
            } else if (this.cbY.originalSize > 0 && !aP(this.cbY.originalSize)) {
                this.cfx = ceK + "(" + ap.aE(this.cbY.originalSize) + ")";
            } else {
                this.cfx = ceK;
            }
        }
    }

    private boolean akC() {
        return (this.cbY == null || !this.cbY.mIsShowOrigonButton || this.cbY.isBlockedPic || StringUtils.isNull(this.cbY.originalUrl)) ? false : true;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.cdk = bVar;
    }

    private boolean aP(long j) {
        return j > ceL;
    }
}
