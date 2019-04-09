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
    private ImageUrlData cbZ;
    private b cdl;
    private boolean cdt;
    private boolean cdv;
    private boolean cdw;
    protected DragImageView ceN;
    protected TextView ceO;
    protected SubsamplingScaleImageView ceP;
    private SubsamplingScaleImageView.OnImageEventListener ceQ;
    private a ceR;
    private boolean ceS;
    private boolean ceT;
    private boolean ceU;
    private boolean ceV;
    private boolean ceW;
    private Bitmap ceX;
    private boolean ceY;
    private float ceZ;
    private boolean cfA;
    private Runnable cfB;
    private Runnable cfC;
    private View.OnTouchListener cfD;
    private final Matrix cfa;
    private Rect cfb;
    private RectF cfc;
    private RectF cfd;
    private Rect cfe;
    private Rect cff;
    private Rect cfg;
    private DragImageView.d cfh;
    private String cfj;
    private float cfk;
    private float cfl;
    private float cfm;
    private float cfn;
    private float cfo;
    private boolean cfp;
    private boolean cfq;
    private boolean cfr;
    public boolean cfs;
    private com.baidu.tbadk.img.b cft;
    private View.OnTouchListener cfu;
    private boolean cfv;
    private float cfw;
    private View.OnLongClickListener cfx;
    private String cfy;
    private CircleProgressView cfz;
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
    private static final String ceL = TbadkCoreApplication.getInst().getString(d.j.original_img_look);
    private static long ceM = Config.RAVEN_LOG_LIMIT;
    private static final int cfi = l.aQ(TbadkCoreApplication.getInst()) / 5;
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
        if (this.ceN != null) {
            this.ceN.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.ceR = aVar;
    }

    public UrlDragImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.ceN = null;
        this.ceR = null;
        this.cdt = false;
        this.ceU = false;
        this.ceY = false;
        this.mRatio = 1.0f;
        this.ceZ = 0.0f;
        this.cfa = new Matrix();
        this.cfc = new RectF();
        this.cfk = 0.0f;
        this.cfl = 0.0f;
        this.cfm = 1.0f;
        this.cfn = 1.0f;
        this.cfo = 0.0f;
        this.cfp = false;
        this.cfq = false;
        this.cfr = false;
        this.cfs = false;
        this.cfv = true;
        this.cfw = 0.0f;
        this.mOnClickListener = null;
        this.cfx = null;
        this.cfy = null;
        this.cfB = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.cfv = true;
            }
        };
        this.cfC = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.cfz.setVisibility(8);
                        UrlDragImageView.this.cfy = null;
                        UrlDragImageView.this.cfs = false;
                    }
                });
            }
        };
        this.cfD = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.cfu != null) {
                    UrlDragImageView.this.cfu.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.cft = new com.baidu.tbadk.img.b();
        init();
    }

    public UrlDragImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.ceN = null;
        this.ceR = null;
        this.cdt = false;
        this.ceU = false;
        this.ceY = false;
        this.mRatio = 1.0f;
        this.ceZ = 0.0f;
        this.cfa = new Matrix();
        this.cfc = new RectF();
        this.cfk = 0.0f;
        this.cfl = 0.0f;
        this.cfm = 1.0f;
        this.cfn = 1.0f;
        this.cfo = 0.0f;
        this.cfp = false;
        this.cfq = false;
        this.cfr = false;
        this.cfs = false;
        this.cfv = true;
        this.cfw = 0.0f;
        this.mOnClickListener = null;
        this.cfx = null;
        this.cfy = null;
        this.cfB = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.cfv = true;
            }
        };
        this.cfC = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.cfz.setVisibility(8);
                        UrlDragImageView.this.cfy = null;
                        UrlDragImageView.this.cfs = false;
                    }
                });
            }
        };
        this.cfD = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.cfu != null) {
                    UrlDragImageView.this.cfu.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.cft = new com.baidu.tbadk.img.b();
        init();
    }

    public DragImageView getImageView() {
        return this.ceN;
    }

    public void setGifSetListener(DragImageView.e eVar) {
        this.ceN.setGifSetListener(eVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.ceN.setImageOnClickListener(onClickListener);
        this.ceP.setOnClickListener(onClickListener);
        this.mOnClickListener = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cfx = onLongClickListener;
        if (!this.cdv) {
            this.ceN.setImageOnLongClickListener(this.cfx);
            this.ceP.setOnLongClickListener(this.cfx);
        }
    }

    public void setOnSizeChangedListener(final DragImageView.g gVar) {
        this.ceN.setOnSizeChangedListener(new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.8
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
        this.cfj = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        this.mMaxWidth = l.aO(this.mContext);
        this.mMaxHeight = l.aQ(this.mContext) - ((int) this.mContext.getResources().getDimension(d.e.ds166));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.ceN = new DragImageView(this.mContext);
        this.ceN.setLayoutParams(layoutParams);
        this.ceN.setOnTouchListener(this.cfD);
        addView(this.ceN);
        this.ceP = new SubsamplingScaleImageView(this.mContext);
        this.ceP.setMaxScale(50.0f);
        this.ceP.setOnTouchListener(this.cfD);
        this.ceP.setVisibility(4);
        addView(this.ceP, layoutParams);
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
        this.cfz = new CircleProgressView(this.mContext);
        this.cfz.setCircleBackgroundColor(al.getColor(d.C0277d.cp_cont_d));
        this.cfz.setCircleForegroundColor(al.getColor(d.C0277d.cp_link_tip_a));
        this.cfz.setProgress(0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.h(getContext(), d.e.tbds80), l.h(getContext(), d.e.tbds80));
        layoutParams.addRule(13);
        this.cfz.setVisibility(8);
        addView(this.cfz, layoutParams);
    }

    public void setIsCanDrag(boolean z) {
        this.cdv = z;
    }

    public void setIsHotSort(boolean z) {
        this.cdw = z;
    }

    public String getmCheckOriginPicText() {
        return this.cfy;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        Bitmap imageBitmap;
        int height;
        int width;
        if (this.cfp && !this.cfA && this.ceP.getVisibility() == 0 && !this.ceP.isImageLoaded()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.cdv || !this.ceT) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.ceV && motionEvent.getPointerCount() >= 2) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.ceV || this.ceW) {
            requestDisallowInterceptTouchEvent(true);
        }
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        float x = motionEvent.getX();
        int i = action & 255;
        if (i == 0) {
            if (this.ceX == null) {
                if (this.ceP.getVisibility() == 0) {
                    this.ceX = f.aZ(this.ceP);
                } else {
                    this.ceX = f.aZ(this.ceN);
                }
            }
            if (this.cfb == null && this.ceX != null) {
                int measuredWidth = getMeasuredWidth();
                float measuredWidth2 = ((getMeasuredWidth() * 1.0f) / this.ceX.getWidth()) * this.ceX.getHeight();
                if (measuredWidth2 > getMeasuredHeight()) {
                    measuredWidth2 = getMeasuredHeight();
                }
                RectF h = h(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
                this.cfb = new Rect((int) h.left, (int) h.top, (int) h.right, (int) h.bottom);
            }
            if (this.cff == null && this.ceX != null) {
                if (this.ceP.getVisibility() == 0) {
                    height = this.ceP.getSHeight();
                    width = this.ceP.getSWidth();
                } else {
                    if (this.ceN.getImageType() == 1) {
                        imageBitmap = (this.ceN.getCurrentFrame() == null || this.ceN.getCurrentFrame().cuX == null) ? this.ceX : this.ceN.getCurrentFrame().cuX;
                    } else {
                        imageBitmap = this.ceN.getImageBitmap() == null ? this.ceX : this.ceN.getImageBitmap();
                    }
                    height = imageBitmap.getHeight();
                    width = imageBitmap.getWidth();
                }
                float aR = l.aR(getContext());
                int i2 = (int) (height * aR);
                int i3 = (int) (width * aR);
                if (i3 > this.ceX.getWidth() && this.ceX.getWidth() != 0) {
                    float width2 = (i3 * 1.0f) / this.ceX.getWidth();
                    i3 = this.ceX.getWidth();
                    i2 = (int) (i2 / width2);
                }
                if (i2 > this.ceX.getHeight() && this.ceX.getHeight() != 0) {
                    i3 = (int) (i3 / ((i2 * 1.0f) / this.ceX.getHeight()));
                    i2 = this.ceX.getHeight();
                }
                int aQ = (l.aQ(getContext()) - i2) / 2;
                int aO = (l.aO(getContext()) - i3) / 2;
                this.cff = new Rect(aO, aQ, i3 + aO, i2 + aQ);
                this.cfg = new Rect(this.cff);
                this.cfo = aQ / l.aQ(getContext());
                this.cfe = new Rect(0, 0, this.ceX.getWidth(), this.ceX.getHeight());
            }
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (i == 2) {
            this.ceV = r(this.mLastMotionX - x, this.mLastMotionY - y);
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (this.ceV || this.ceW) {
            this.ceN.setImageOnLongClickListener(null);
            this.ceP.setOnLongClickListener(null);
            z = true;
        } else {
            this.ceN.setImageOnLongClickListener(this.cfx);
            this.ceP.setOnLongClickListener(this.cfx);
            z = super.dispatchTouchEvent(motionEvent);
        }
        if (i == 1 || i == 3) {
            this.mLastMotionX = 0.0f;
            this.mLastMotionY = 0.0f;
            if (this.ceZ > cfi) {
                this.ceW = true;
                akr();
            } else {
                if (this.ceV && this.cfh != null) {
                    this.cfh.aqR();
                }
                this.mRatio = 1.0f;
                invalidate();
            }
            this.ceY = false;
            this.cfa.reset();
            this.ceV = false;
            return z;
        }
        return z;
    }

    private boolean r(float f, float f2) {
        if (this.ceP.getVisibility() != 0 || this.ceP.isCanDrag()) {
            if (this.cbZ == null || !this.cbZ.isLongPic || this.ceP.getVisibility() != 0 || this.ceP.isViewTop()) {
                if (this.cbZ == null || !this.cbZ.isLongPic || this.ceP.getVisibility() == 0 || this.ceN.aqx()) {
                    if (this.ceP.getVisibility() == 0 || this.ceN.aqz()) {
                        if (this.ceX != null && getScrollY() == 0 && f2 < 0.0f && !this.ceY) {
                            this.ceN.setImageOnLongClickListener(null);
                            this.ceP.setOnLongClickListener(null);
                            this.ceY = true;
                            this.ceZ = 0.0f;
                            this.mRatio = 1.0f;
                            if (this.cfh != null) {
                                this.cfh.aqP();
                            }
                        }
                        if (!this.ceY || this.ceX == null) {
                            return false;
                        }
                        this.ceZ -= f2;
                        int measuredHeight = getMeasuredHeight();
                        if (this.ceZ > measuredHeight) {
                            this.ceZ = measuredHeight;
                        }
                        float f3 = f2 / measuredHeight;
                        this.cfa.postTranslate((-f) * 1.5f * this.mRatio, (-1.5f) * f2 * this.mRatio);
                        if (this.mRatio * (1.0f + f3) > 1.0f || this.ceZ < 0.0f) {
                            this.cfa.preScale(1.0f / this.mRatio, 1.0f / this.mRatio, (this.mRatio * this.ceX.getWidth()) / 2.0f, this.mRatio * (this.ceX.getHeight() / 2));
                            this.mRatio = 1.0f;
                        } else {
                            this.cfa.preScale(1.0f + f3, 1.0f + f3, (this.mRatio * this.ceX.getWidth()) / 2.0f, this.mRatio * (this.ceX.getHeight() / 2));
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
        if (this.ceV && this.ceX != null && !this.ceX.isRecycled() && this.ceY) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.cfc == null) {
                this.cfc = new RectF();
            }
            this.cfa.mapRect(this.cfc, new RectF(this.cfb));
            canvas.drawBitmap(this.ceX, this.cfe, this.cfc, (Paint) null);
        } else if (this.ceW && this.ceX != null && !this.ceX.isRecycled()) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.cbZ == null || this.cbZ.getSourceImageRectInScreen() == null) {
                canvas.drawBitmap(this.ceX, this.cfe, this.cfc, (Paint) null);
            } else {
                canvas.drawBitmap(this.ceX, this.cff, this.cfc, (Paint) null);
            }
        } else {
            super.dispatchDraw(canvas);
        }
    }

    private void akr() {
        if (this.cbZ == null) {
            if (this.cfh != null) {
                this.cfh.aqQ();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.cbZ.getSourceImageRectInScreen();
        final Rect dstRectInScreen = this.cbZ.getDstRectInScreen();
        if (sourceImageRectInScreen == null || dstRectInScreen == null) {
            if (this.cfh != null) {
                this.cfh.aqQ();
                return;
            }
            return;
        }
        a(sourceImageRectInScreen, dstRectInScreen);
        f(sourceImageRectInScreen);
        this.cfd = new RectF(this.cfc);
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
                UrlDragImageView.this.ceY = false;
                UrlDragImageView.this.invalidate();
                if (UrlDragImageView.this.cfh != null) {
                    UrlDragImageView.this.cfh.aqQ();
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
            float f = ((rect.bottom - rect.top) / (rect.right - rect.left)) * (this.cfc.right - this.cfc.left);
            this.cfc.top += this.cfc.height() * this.cfo;
            this.cfc.bottom = f + this.cfc.top;
        }
    }

    public void setCanScale(boolean z) {
        if (this.ceN != null) {
            this.ceN.setCanScale(z);
        }
    }

    private void a(Rect rect, Rect rect2) {
        this.cfk = 0.0f;
        this.cfl = 0.0f;
        this.cfm = 1.0f;
        this.cfn = 1.0f;
        if (rect != null && rect2 != null && rect.contains(rect2)) {
            this.cfk = (rect2.left - rect.left) / rect.width();
            this.cfl = (rect2.top - rect.top) / rect.height();
            this.cfm = (rect2.right - rect.left) / rect.width();
            this.cfn = (rect2.bottom - rect.top) / rect.height();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void an(float f) {
        if (this.cff != null) {
            this.cff.left = (int) (this.cfg.left + (this.cfg.width() * this.cfk * f));
            this.cff.top = (int) (this.cfg.top + (this.cfg.height() * this.cfl * f));
            this.cff.right = (int) (this.cfg.left + (this.cfg.width() * (((1.0f - this.cfm) * (1.0f - f)) + this.cfm)));
            this.cff.bottom = (int) (this.cfg.top + (this.cfg.height() * (((1.0f - this.cfn) * (1.0f - f)) + this.cfn)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Rect rect, float f) {
        if (this.cfc != null && rect != null) {
            this.cfc.left = this.cfd.left + ((rect.left - this.cfd.left) * f);
            this.cfc.top = this.cfd.top + ((rect.top - this.cfd.top) * f);
            this.cfc.right = this.cfd.right + ((rect.right - this.cfd.right) * f);
            this.cfc.bottom = this.cfd.bottom + ((rect.bottom - this.cfd.bottom) * f);
        }
    }

    private RectF h(float f, float f2, float f3, float f4) {
        return new RectF(f - (f3 / 2.0f), f2 - (f4 / 2.0f), (f3 / 2.0f) + f, (f4 / 2.0f) + f2);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.cfu = onTouchListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aks() {
        if ((this.ceS || this.ceT) && this.cbZ != null && this.cbZ.mPicType == 1 && !TextUtils.isEmpty(this.cbZ.mTagName)) {
            if (this.ceO != null) {
                this.ceO.setVisibility(8);
                this.ceO = null;
            }
            this.ceO = new TextView(this.mContext);
            this.ceO.setText(this.cbZ.mTagName);
            this.ceO.setTextSize(0, getResources().getDimensionPixelSize(d.e.fontsize26));
            al.c(this.ceO, d.C0277d.common_color_10013, 1, 0);
            al.l(this.ceO, d.C0277d.common_color_10215);
            this.ceO.setAlpha(0.75f);
            this.ceO.setIncludeFontPadding(false);
            this.ceO.setGravity(17);
            int h = l.h(this.mContext, d.e.ds2);
            this.ceO.setPadding(h, h, h, h);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.ceN.getBottomOffset();
            layoutParams.leftMargin = this.ceN.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.ceO, layoutParams);
            this.ceO.setVisibility(0);
        }
    }

    public void setUrl(String str, boolean z) {
        if (str.contains("*")) {
            str = str.split("[*]")[0];
        }
        this.ceN.setTag(str);
        this.ceN.setLoadBigImage(false);
        this.ceN.setImageDrawable(null);
        this.ceS = false;
        this.ceT = false;
        this.cfp = akA();
        this.cfy = null;
        if (ol(str)) {
            e(str, z, false);
        }
    }

    private boolean akt() {
        return this.ceN != null && this.ceN.aqN();
    }

    public void aku() {
        if (this.cbZ != null && !akt()) {
            String str = this.cbZ.imageUrl;
            int i = this.cbZ.urlType;
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
        if (!this.cfq || z) {
            this.cfq = true;
            if (!this.cfp || this.cbZ == null || StringUtils.isNull(this.cbZ.originalUrl, true) || this.cbZ.originalSize < 0 || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String str = this.cfj + ao.adh().mC(mL) + "/" + as.mL(this.cbZ.originalUrl);
            final int[] mf = m.mf(str);
            this.ceP.setVisibility(0);
            if (this.ceQ == null) {
                this.ceQ = new SubsamplingScaleImageView.OnImageEventListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12
                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onReady() {
                        UrlDragImageView.this.cfy = null;
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.ceN.aqJ();
                        UrlDragImageView.this.ceN.setVisibility(4);
                    }

                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onImageLoaded() {
                        if (UrlDragImageView.this.cbZ.isLongPic && mf[0] > 0) {
                            UrlDragImageView.this.ceN.onDestroy();
                            final float measuredWidth = (UrlDragImageView.this.getMeasuredWidth() * 1.0f) / mf[0];
                            final PointF pointF = new PointF((mf[0] * 1.0f) / 2.0f, 0.0f);
                            UrlDragImageView.this.ceP.setScaleAndCenter(measuredWidth, pointF);
                            UrlDragImageView.this.ceP.setMaxScale(2.0f * measuredWidth);
                            UrlDragImageView.this.ceP.setDoubleTapZoomScale(2.0f * measuredWidth);
                            UrlDragImageView.this.ceP.setInitScale(measuredWidth);
                            UrlDragImageView.this.ceP.setDoubleTapZoomStyle(4);
                            UrlDragImageView.this.ceP.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12.1
                                @Override // android.view.View.OnTouchListener
                                public boolean onTouch(View view, MotionEvent motionEvent) {
                                    if (UrlDragImageView.this.cfu != null) {
                                        UrlDragImageView.this.cfu.onTouch(view, motionEvent);
                                    }
                                    switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                                        case 0:
                                            UrlDragImageView.this.cfw = motionEvent.getY();
                                            UrlDragImageView.this.ceP.setOnClickListener(UrlDragImageView.this.cfv ? UrlDragImageView.this.mOnClickListener : null);
                                            UrlDragImageView.this.ceP.setOnLongClickListener(UrlDragImageView.this.cfv ? UrlDragImageView.this.cfx : null);
                                            break;
                                        case 1:
                                        case 3:
                                            if (UrlDragImageView.this.ceP.getScale() < measuredWidth) {
                                                UrlDragImageView.this.ceP.setScaleAndCenter(measuredWidth, pointF);
                                            }
                                            e.jH().removeCallbacks(UrlDragImageView.this.cfB);
                                            e.jH().postDelayed(UrlDragImageView.this.cfB, 1000L);
                                            break;
                                        case 2:
                                            if (Math.abs(motionEvent.getY() - UrlDragImageView.this.cfw) > UrlDragImageView.TOUCH_SLOP) {
                                                UrlDragImageView.this.cfv = false;
                                                UrlDragImageView.this.ceP.setOnClickListener(null);
                                                UrlDragImageView.this.ceP.setOnLongClickListener(null);
                                            }
                                            UrlDragImageView.this.cfw = motionEvent.getY();
                                            break;
                                    }
                                    return false;
                                }
                            });
                            UrlDragImageView.this.ceN.setVisibility(4);
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
            this.ceP.setOnImageEventListener(this.ceQ);
            if (this.ceP.isImageLoaded() && this.cbZ.isLongPic) {
                this.ceQ.onImageLoaded();
            } else {
                this.ceP.setImage(ImageSource.uri(str));
            }
            return true;
        }
        return false;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.cfh = dVar;
        if (this.ceN != null) {
            this.ceN.setDragToExitListener(dVar);
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
        if (!this.ceT && aVar != null && (oy = aVar.oy()) != null) {
            this.ceS = true;
            if (aVar.isGif()) {
                this.ceN.setImageUrlData(this.cbZ);
                this.ceN.setImageBitmap(oy);
                this.cfy = null;
                this.cfs = false;
            } else {
                if (this.cbZ != null && this.cbZ.isLongPic) {
                    this.ceN.aqC();
                    this.ceN.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.13
                        @Override // com.baidu.tbadk.widget.largeImage.logic.a
                        public void akE() {
                        }
                    });
                }
                this.ceN.setImageUrlData(this.cbZ);
                this.ceN.setImageData(oy, aVar.oD());
            }
            aks();
        }
    }

    private void e(String str, boolean z, boolean z2) {
        if (om(str)) {
            if (z2 || (!this.ceU && !this.ceT)) {
                if (!z2 || !ev(true)) {
                    this.ceU = true;
                    com.baidu.adp.lib.f.c.jB().a(str, 27, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.14
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onCancelled(String str2) {
                            UrlDragImageView.this.ceU = false;
                            UrlDragImageView.this.ceN.setVisibility(0);
                            UrlDragImageView.this.mProgressBar.setVisibility(8);
                            UrlDragImageView.this.cfy = null;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            UrlDragImageView.this.ceU = false;
                            UrlDragImageView.this.ceT = true;
                            UrlDragImageView.this.b(aVar);
                        }
                    }, 0, 0, false, null, Boolean.valueOf(z), this.ceN.getImageData(), Boolean.valueOf(this.cdt));
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
        com.baidu.adp.widget.ImageView.a a2 = this.cft.a(imageFileInfo, false);
        if (a2 != null) {
            this.ceT = true;
            this.mProgressBar.setVisibility(8);
            this.cfy = null;
            b(a2);
            return;
        }
        this.cft.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.2
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.ImageView.a aVar, String str2, boolean z3) {
                UrlDragImageView.this.ceT = true;
                UrlDragImageView.this.mProgressBar.setVisibility(8);
                UrlDragImageView.this.cfy = null;
                UrlDragImageView.this.b(aVar);
            }
        }, false);
    }

    private boolean om(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith("https://"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null && this.ceR != null) {
            this.ceR.i(aVar.getUrl(), aVar.oD());
        }
        if (aVar == null || aVar.oy() == null) {
            akw();
            return;
        }
        Bitmap oy = aVar.oy();
        this.ceN.setLoadBigImage(true);
        if (aVar.isGif()) {
            this.ceN.setGifData(aVar.oD(), oy);
            this.ceN.invalidate();
            this.ceN.play();
            this.cfs = false;
            this.cfy = null;
            this.mProgressBar.setVisibility(8);
        } else {
            if (this.cbZ != null && this.cbZ.isLongPic) {
                this.ceN.aqC();
                this.ceN.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.3
                    @Override // com.baidu.tbadk.widget.largeImage.logic.a
                    public void akE() {
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.cfy = null;
                    }
                });
            } else {
                this.mProgressBar.setVisibility(8);
                this.cfy = null;
            }
            this.ceN.setImageUrlData(this.cbZ);
            this.ceN.setImageData(oy, aVar.oD());
            akB();
        }
        aks();
    }

    private void akw() {
        if (!this.ceS) {
            this.ceN.setDefaultBitmap();
        } else {
            this.ceT = false;
        }
        this.cfy = null;
        this.mProgressBar.setVisibility(8);
    }

    public void setGifMaxUseableMem(int i) {
        this.ceN.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.ceN != null) {
            this.ceN.onDestroy();
        }
        if (this.ceP != null) {
            this.ceP.recycle();
        }
        if (this.ceX != null) {
            this.ceX.recycle();
            this.ceX = null;
        }
        if (this.mProgressBar != null) {
            this.cfy = null;
            this.mProgressBar.setVisibility(8);
        }
        e.jH().removeCallbacks(this.cfB);
        com.baidu.tieba.view.c.cmY().setColor(-1);
    }

    public void release() {
        if (this.ceN != null) {
            this.ceN.release();
        }
        if (this.mProgressBar != null) {
            this.cfy = null;
            this.mProgressBar.setVisibility(8);
        }
        this.cfy = null;
    }

    public void akx() {
        if (this.ceN != null && this.ceN.getImageType() == 1) {
            this.ceN.stop();
        }
    }

    public void o(boolean z, boolean z2) {
        String str;
        if (this.ceN != null && (str = (String) this.ceN.getTag()) != null) {
            if (this.ceN.getImageType() == 1) {
                if (this.ceN.getGifCache() == null || !this.ceN.aqN()) {
                    e(str, z, z2);
                }
            } else if (this.ceN.getImageType() == 2) {
                e(str, z, z2);
            } else if (aky()) {
                e(str, z, z2);
            }
        }
    }

    private boolean aky() {
        if (this.ceN.getImageBitmap() != null && this.ceN.aqN()) {
            if (this.cbZ == null || !this.cbZ.isLongPic || this.ceN.aqD()) {
                return false;
            }
            this.ceT = false;
            this.cfq = false;
            return true;
        }
        return true;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.cbZ = imageUrlData;
    }

    public ImageUrlData getmAssistUrlData() {
        return this.cbZ;
    }

    public void setIsCdn(boolean z) {
        this.cdt = z;
    }

    public void akz() {
        final String mL = as.mL(this.cbZ.originalUrl);
        if (this.cbZ.originalProcess >= 0) {
            com.baidu.tbadk.download.d.alJ().ac(mL, 13);
            this.cbZ.originalProcess = -1;
            akB();
            return;
        }
        if (this.cdl != null) {
            this.cdl.akF();
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
        if (this.cbZ != null) {
            this.cbZ.originalProcess = 0;
            this.cfz.setProgress(0);
            this.cfz.setVisibility(0);
            DownloadData downloadData = new DownloadData(str);
            downloadData.setStatus(1);
            downloadData.setUrl(this.cbZ.originalUrl);
            downloadData.setType(13);
            downloadData.setPath(this.cfj + ao.adh().mC(str) + "/" + str);
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.6
                @Override // com.baidu.tbadk.download.c
                public boolean onPreDownload(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2 != null) {
                        if (UrlDragImageView.this.cbZ != null && UrlDragImageView.this.cbZ.originalProcess != -1) {
                            UrlDragImageView.this.cbZ.originalProcess = downloadData2.getProcess();
                        }
                        if (UrlDragImageView.this.cbZ == null || UrlDragImageView.this.cbZ.originalProcess != -1) {
                            UrlDragImageView.this.cfz.setProgress(downloadData2.getProcess());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public boolean onFileDownloaded(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadSucceed(DownloadData downloadData2) {
                    UrlDragImageView.this.cfz.setVisibility(8);
                    e.jH().postDelayed(UrlDragImageView.this.cfC, 1500L);
                    UrlDragImageView.this.cfq = false;
                    UrlDragImageView.this.cfp = UrlDragImageView.this.akA();
                    UrlDragImageView.this.akv();
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str2) {
                    UrlDragImageView.this.cfz.setVisibility(8);
                    UrlDragImageView.this.cfq = false;
                    BdToast.b(UrlDragImageView.this.mContext, str2).abc().abe();
                    UrlDragImageView.this.cbZ.originalProcess = -1;
                    UrlDragImageView.this.akB();
                }
            });
            com.baidu.tbadk.download.d.alJ().a(downloadData, 100);
            this.cfA = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean akA() {
        if (this.cbZ != null && !StringUtils.isNull(this.cbZ.originalUrl, true) && this.cbZ.originalSize >= 0 && !this.cbZ.isBlockedPic) {
            String mL = as.mL(this.cbZ.originalUrl);
            File file = new File(this.cfj + ao.adh().mC(mL) + "/" + mL);
            if (file != null && file.exists()) {
                this.cbZ.originalProcess = 100;
                return true;
            }
            if (this.cbZ.originalProcess < 0) {
                akB();
            } else {
                this.cfz.setProgress(this.cbZ.originalProcess);
            }
            this.cfs = true;
        } else {
            this.cfy = null;
        }
        return false;
    }

    public void akB() {
        if (this.cbZ != null) {
            if (!akC() || !this.cfs) {
                this.cfy = null;
            } else if (this.cbZ.originalSize > 0 && !aP(this.cbZ.originalSize)) {
                this.cfy = ceL + "(" + ap.aE(this.cbZ.originalSize) + ")";
            } else {
                this.cfy = ceL;
            }
        }
    }

    private boolean akC() {
        return (this.cbZ == null || !this.cbZ.mIsShowOrigonButton || this.cbZ.isBlockedPic || StringUtils.isNull(this.cbZ.originalUrl)) ? false : true;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.cdl = bVar;
    }

    private boolean aP(long j) {
        return j > ceM;
    }
}
