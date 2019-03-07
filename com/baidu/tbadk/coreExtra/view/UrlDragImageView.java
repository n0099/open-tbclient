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
    private ImageUrlData cbW;
    private b cdi;
    private boolean cdq;
    private boolean cds;
    private boolean cdt;
    protected DragImageView ceK;
    protected TextView ceL;
    protected SubsamplingScaleImageView ceM;
    private SubsamplingScaleImageView.OnImageEventListener ceN;
    private a ceO;
    private boolean ceP;
    private boolean ceQ;
    private boolean ceR;
    private boolean ceS;
    private boolean ceT;
    private Bitmap ceU;
    private boolean ceV;
    private float ceW;
    private final Matrix ceX;
    private Rect ceY;
    private RectF ceZ;
    private View.OnTouchListener cfA;
    private RectF cfa;
    private Rect cfb;
    private Rect cfc;
    private Rect cfd;
    private DragImageView.d cfe;
    private String cfg;
    private float cfh;
    private float cfi;
    private float cfj;
    private float cfk;
    private float cfl;
    private boolean cfm;
    private boolean cfn;
    private boolean cfo;
    public boolean cfp;
    private com.baidu.tbadk.img.b cfq;
    private View.OnTouchListener cfr;
    private boolean cfs;
    private float cft;
    private View.OnLongClickListener cfu;
    private String cfv;
    private CircleProgressView cfw;
    private boolean cfx;
    private Runnable cfy;
    private Runnable cfz;
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
    private static final String ceI = TbadkCoreApplication.getInst().getString(d.j.original_img_look);
    private static long ceJ = 52428800;
    private static final int cff = l.aQ(TbadkCoreApplication.getInst()) / 5;
    private static final String TAG = UrlDragImageView.class.getSimpleName();
    private static final int TOUCH_SLOP = ViewConfiguration.get(TbadkCoreApplication.getInst()).getScaledTouchSlop();

    /* loaded from: classes3.dex */
    public interface a {
        void i(String str, byte[] bArr);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void akJ();
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
        if (this.ceK != null) {
            this.ceK.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.ceO = aVar;
    }

    public UrlDragImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.ceK = null;
        this.ceO = null;
        this.cdq = false;
        this.ceR = false;
        this.ceV = false;
        this.mRatio = 1.0f;
        this.ceW = 0.0f;
        this.ceX = new Matrix();
        this.ceZ = new RectF();
        this.cfh = 0.0f;
        this.cfi = 0.0f;
        this.cfj = 1.0f;
        this.cfk = 1.0f;
        this.cfl = 0.0f;
        this.cfm = false;
        this.cfn = false;
        this.cfo = false;
        this.cfp = false;
        this.cfs = true;
        this.cft = 0.0f;
        this.mOnClickListener = null;
        this.cfu = null;
        this.cfv = null;
        this.cfy = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.cfs = true;
            }
        };
        this.cfz = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.cfw.setVisibility(8);
                        UrlDragImageView.this.cfv = null;
                        UrlDragImageView.this.cfp = false;
                    }
                });
            }
        };
        this.cfA = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.cfr != null) {
                    UrlDragImageView.this.cfr.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.cfq = new com.baidu.tbadk.img.b();
        init();
    }

    public UrlDragImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.ceK = null;
        this.ceO = null;
        this.cdq = false;
        this.ceR = false;
        this.ceV = false;
        this.mRatio = 1.0f;
        this.ceW = 0.0f;
        this.ceX = new Matrix();
        this.ceZ = new RectF();
        this.cfh = 0.0f;
        this.cfi = 0.0f;
        this.cfj = 1.0f;
        this.cfk = 1.0f;
        this.cfl = 0.0f;
        this.cfm = false;
        this.cfn = false;
        this.cfo = false;
        this.cfp = false;
        this.cfs = true;
        this.cft = 0.0f;
        this.mOnClickListener = null;
        this.cfu = null;
        this.cfv = null;
        this.cfy = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.cfs = true;
            }
        };
        this.cfz = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.cfw.setVisibility(8);
                        UrlDragImageView.this.cfv = null;
                        UrlDragImageView.this.cfp = false;
                    }
                });
            }
        };
        this.cfA = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.cfr != null) {
                    UrlDragImageView.this.cfr.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.cfq = new com.baidu.tbadk.img.b();
        init();
    }

    public DragImageView getImageView() {
        return this.ceK;
    }

    public void setGifSetListener(DragImageView.e eVar) {
        this.ceK.setGifSetListener(eVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.ceK.setImageOnClickListener(onClickListener);
        this.ceM.setOnClickListener(onClickListener);
        this.mOnClickListener = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cfu = onLongClickListener;
        if (!this.cds) {
            this.ceK.setImageOnLongClickListener(this.cfu);
            this.ceM.setOnLongClickListener(this.cfu);
        }
    }

    public void setOnSizeChangedListener(final DragImageView.g gVar) {
        this.ceK.setOnSizeChangedListener(new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.8
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (gVar != null) {
                    gVar.a(dragImageView, z, z2);
                }
                UrlDragImageView.this.akw();
            }
        });
    }

    protected void init() {
        this.cfg = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        this.mMaxWidth = l.aO(this.mContext);
        this.mMaxHeight = l.aQ(this.mContext) - ((int) this.mContext.getResources().getDimension(d.e.ds166));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.ceK = new DragImageView(this.mContext);
        this.ceK.setLayoutParams(layoutParams);
        this.ceK.setOnTouchListener(this.cfA);
        addView(this.ceK);
        this.ceM = new SubsamplingScaleImageView(this.mContext);
        this.ceM.setMaxScale(50.0f);
        this.ceM.setOnTouchListener(this.cfA);
        this.ceM.setVisibility(4);
        addView(this.ceM, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(getResources().getDrawable(d.f.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        aku();
    }

    private void aku() {
        this.cfw = new CircleProgressView(this.mContext);
        this.cfw.setCircleBackgroundColor(al.getColor(d.C0236d.cp_cont_d));
        this.cfw.setCircleForegroundColor(al.getColor(d.C0236d.cp_link_tip_a));
        this.cfw.setProgress(0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.h(getContext(), d.e.tbds80), l.h(getContext(), d.e.tbds80));
        layoutParams.addRule(13);
        this.cfw.setVisibility(8);
        addView(this.cfw, layoutParams);
    }

    public void setIsCanDrag(boolean z) {
        this.cds = z;
    }

    public void setIsHotSort(boolean z) {
        this.cdt = z;
    }

    public String getmCheckOriginPicText() {
        return this.cfv;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        Bitmap imageBitmap;
        int height;
        int width;
        if (this.cfm && !this.cfx && this.ceM.getVisibility() == 0 && !this.ceM.isImageLoaded()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.cds || !this.ceQ) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.ceS && motionEvent.getPointerCount() >= 2) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.ceS || this.ceT) {
            requestDisallowInterceptTouchEvent(true);
        }
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        float x = motionEvent.getX();
        int i = action & 255;
        if (i == 0) {
            if (this.ceU == null) {
                if (this.ceM.getVisibility() == 0) {
                    this.ceU = f.aZ(this.ceM);
                } else {
                    this.ceU = f.aZ(this.ceK);
                }
            }
            if (this.ceY == null && this.ceU != null) {
                int measuredWidth = getMeasuredWidth();
                float measuredWidth2 = ((getMeasuredWidth() * 1.0f) / this.ceU.getWidth()) * this.ceU.getHeight();
                if (measuredWidth2 > getMeasuredHeight()) {
                    measuredWidth2 = getMeasuredHeight();
                }
                RectF h = h(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
                this.ceY = new Rect((int) h.left, (int) h.top, (int) h.right, (int) h.bottom);
            }
            if (this.cfc == null && this.ceU != null) {
                if (this.ceM.getVisibility() == 0) {
                    height = this.ceM.getSHeight();
                    width = this.ceM.getSWidth();
                } else {
                    if (this.ceK.getImageType() == 1) {
                        imageBitmap = (this.ceK.getCurrentFrame() == null || this.ceK.getCurrentFrame().cuX == null) ? this.ceU : this.ceK.getCurrentFrame().cuX;
                    } else {
                        imageBitmap = this.ceK.getImageBitmap() == null ? this.ceU : this.ceK.getImageBitmap();
                    }
                    height = imageBitmap.getHeight();
                    width = imageBitmap.getWidth();
                }
                float aR = l.aR(getContext());
                int i2 = (int) (height * aR);
                int i3 = (int) (width * aR);
                if (i3 > this.ceU.getWidth() && this.ceU.getWidth() != 0) {
                    float width2 = (i3 * 1.0f) / this.ceU.getWidth();
                    i3 = this.ceU.getWidth();
                    i2 = (int) (i2 / width2);
                }
                if (i2 > this.ceU.getHeight() && this.ceU.getHeight() != 0) {
                    i3 = (int) (i3 / ((i2 * 1.0f) / this.ceU.getHeight()));
                    i2 = this.ceU.getHeight();
                }
                int aQ = (l.aQ(getContext()) - i2) / 2;
                int aO = (l.aO(getContext()) - i3) / 2;
                this.cfc = new Rect(aO, aQ, i3 + aO, i2 + aQ);
                this.cfd = new Rect(this.cfc);
                this.cfl = aQ / l.aQ(getContext());
                this.cfb = new Rect(0, 0, this.ceU.getWidth(), this.ceU.getHeight());
            }
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (i == 2) {
            this.ceS = r(this.mLastMotionX - x, this.mLastMotionY - y);
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (this.ceS || this.ceT) {
            this.ceK.setImageOnLongClickListener(null);
            this.ceM.setOnLongClickListener(null);
            z = true;
        } else {
            this.ceK.setImageOnLongClickListener(this.cfu);
            this.ceM.setOnLongClickListener(this.cfu);
            z = super.dispatchTouchEvent(motionEvent);
        }
        if (i == 1 || i == 3) {
            this.mLastMotionX = 0.0f;
            this.mLastMotionY = 0.0f;
            if (this.ceW > cff) {
                this.ceT = true;
                akv();
            } else {
                if (this.ceS && this.cfe != null) {
                    this.cfe.aqU();
                }
                this.mRatio = 1.0f;
                invalidate();
            }
            this.ceV = false;
            this.ceX.reset();
            this.ceS = false;
            return z;
        }
        return z;
    }

    private boolean r(float f, float f2) {
        if (this.ceM.getVisibility() != 0 || this.ceM.isCanDrag()) {
            if (this.cbW == null || !this.cbW.isLongPic || this.ceM.getVisibility() != 0 || this.ceM.isViewTop()) {
                if (this.cbW == null || !this.cbW.isLongPic || this.ceM.getVisibility() == 0 || this.ceK.aqA()) {
                    if (this.ceM.getVisibility() == 0 || this.ceK.aqC()) {
                        if (this.ceU != null && getScrollY() == 0 && f2 < 0.0f && !this.ceV) {
                            this.ceK.setImageOnLongClickListener(null);
                            this.ceM.setOnLongClickListener(null);
                            this.ceV = true;
                            this.ceW = 0.0f;
                            this.mRatio = 1.0f;
                            if (this.cfe != null) {
                                this.cfe.aqS();
                            }
                        }
                        if (!this.ceV || this.ceU == null) {
                            return false;
                        }
                        this.ceW -= f2;
                        int measuredHeight = getMeasuredHeight();
                        if (this.ceW > measuredHeight) {
                            this.ceW = measuredHeight;
                        }
                        float f3 = f2 / measuredHeight;
                        this.ceX.postTranslate((-f) * 1.5f * this.mRatio, (-1.5f) * f2 * this.mRatio);
                        if (this.mRatio * (1.0f + f3) > 1.0f || this.ceW < 0.0f) {
                            this.ceX.preScale(1.0f / this.mRatio, 1.0f / this.mRatio, (this.mRatio * this.ceU.getWidth()) / 2.0f, this.mRatio * (this.ceU.getHeight() / 2));
                            this.mRatio = 1.0f;
                        } else {
                            this.ceX.preScale(1.0f + f3, 1.0f + f3, (this.mRatio * this.ceU.getWidth()) / 2.0f, this.mRatio * (this.ceU.getHeight() / 2));
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
        if (this.ceS && this.ceU != null && !this.ceU.isRecycled() && this.ceV) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.ceZ == null) {
                this.ceZ = new RectF();
            }
            this.ceX.mapRect(this.ceZ, new RectF(this.ceY));
            canvas.drawBitmap(this.ceU, this.cfb, this.ceZ, (Paint) null);
        } else if (this.ceT && this.ceU != null && !this.ceU.isRecycled()) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.cbW == null || this.cbW.getSourceImageRectInScreen() == null) {
                canvas.drawBitmap(this.ceU, this.cfb, this.ceZ, (Paint) null);
            } else {
                canvas.drawBitmap(this.ceU, this.cfc, this.ceZ, (Paint) null);
            }
        } else {
            super.dispatchDraw(canvas);
        }
    }

    private void akv() {
        if (this.cbW == null) {
            if (this.cfe != null) {
                this.cfe.aqT();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.cbW.getSourceImageRectInScreen();
        final Rect dstRectInScreen = this.cbW.getDstRectInScreen();
        if (sourceImageRectInScreen == null || dstRectInScreen == null) {
            if (this.cfe != null) {
                this.cfe.aqT();
                return;
            }
            return;
        }
        a(sourceImageRectInScreen, dstRectInScreen);
        f(sourceImageRectInScreen);
        this.cfa = new RectF(this.ceZ);
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
                UrlDragImageView.this.ceV = false;
                UrlDragImageView.this.invalidate();
                if (UrlDragImageView.this.cfe != null) {
                    UrlDragImageView.this.cfe.aqT();
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
            float f = ((rect.bottom - rect.top) / (rect.right - rect.left)) * (this.ceZ.right - this.ceZ.left);
            this.ceZ.top += this.ceZ.height() * this.cfl;
            this.ceZ.bottom = f + this.ceZ.top;
        }
    }

    public void setCanScale(boolean z) {
        if (this.ceK != null) {
            this.ceK.setCanScale(z);
        }
    }

    private void a(Rect rect, Rect rect2) {
        this.cfh = 0.0f;
        this.cfi = 0.0f;
        this.cfj = 1.0f;
        this.cfk = 1.0f;
        if (rect != null && rect2 != null && rect.contains(rect2)) {
            this.cfh = (rect2.left - rect.left) / rect.width();
            this.cfi = (rect2.top - rect.top) / rect.height();
            this.cfj = (rect2.right - rect.left) / rect.width();
            this.cfk = (rect2.bottom - rect.top) / rect.height();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void an(float f) {
        if (this.cfc != null) {
            this.cfc.left = (int) (this.cfd.left + (this.cfd.width() * this.cfh * f));
            this.cfc.top = (int) (this.cfd.top + (this.cfd.height() * this.cfi * f));
            this.cfc.right = (int) (this.cfd.left + (this.cfd.width() * (((1.0f - this.cfj) * (1.0f - f)) + this.cfj)));
            this.cfc.bottom = (int) (this.cfd.top + (this.cfd.height() * (((1.0f - this.cfk) * (1.0f - f)) + this.cfk)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Rect rect, float f) {
        if (this.ceZ != null && rect != null) {
            this.ceZ.left = this.cfa.left + ((rect.left - this.cfa.left) * f);
            this.ceZ.top = this.cfa.top + ((rect.top - this.cfa.top) * f);
            this.ceZ.right = this.cfa.right + ((rect.right - this.cfa.right) * f);
            this.ceZ.bottom = this.cfa.bottom + ((rect.bottom - this.cfa.bottom) * f);
        }
    }

    private RectF h(float f, float f2, float f3, float f4) {
        return new RectF(f - (f3 / 2.0f), f2 - (f4 / 2.0f), (f3 / 2.0f) + f, (f4 / 2.0f) + f2);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.cfr = onTouchListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akw() {
        if ((this.ceP || this.ceQ) && this.cbW != null && this.cbW.mPicType == 1 && !TextUtils.isEmpty(this.cbW.mTagName)) {
            if (this.ceL != null) {
                this.ceL.setVisibility(8);
                this.ceL = null;
            }
            this.ceL = new TextView(this.mContext);
            this.ceL.setText(this.cbW.mTagName);
            this.ceL.setTextSize(0, getResources().getDimensionPixelSize(d.e.fontsize26));
            al.c(this.ceL, d.C0236d.common_color_10013, 1, 0);
            al.l(this.ceL, d.C0236d.common_color_10215);
            this.ceL.setAlpha(0.75f);
            this.ceL.setIncludeFontPadding(false);
            this.ceL.setGravity(17);
            int h = l.h(this.mContext, d.e.ds2);
            this.ceL.setPadding(h, h, h, h);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.ceK.getBottomOffset();
            layoutParams.leftMargin = this.ceK.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.ceL, layoutParams);
            this.ceL.setVisibility(0);
        }
    }

    public void setUrl(String str, boolean z) {
        if (str.contains("*")) {
            str = str.split("[*]")[0];
        }
        this.ceK.setTag(str);
        this.ceK.setLoadBigImage(false);
        this.ceK.setImageDrawable(null);
        this.ceP = false;
        this.ceQ = false;
        this.cfm = akE();
        this.cfv = null;
        if (ok(str)) {
            e(str, z, false);
        }
    }

    private boolean akx() {
        return this.ceK != null && this.ceK.aqQ();
    }

    public void aky() {
        if (this.cbW != null && !akx()) {
            String str = this.cbW.imageUrl;
            int i = this.cbW.urlType;
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
        String mK;
        if (!this.cfn || z) {
            this.cfn = true;
            if (!this.cfm || this.cbW == null || StringUtils.isNull(this.cbW.originalUrl, true) || this.cbW.originalSize < 0 || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String str = this.cfg + ao.adk().mB(mK) + "/" + as.mK(this.cbW.originalUrl);
            final int[] me = m.me(str);
            this.ceM.setVisibility(0);
            if (this.ceN == null) {
                this.ceN = new SubsamplingScaleImageView.OnImageEventListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12
                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onReady() {
                        UrlDragImageView.this.cfv = null;
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.ceK.aqM();
                        UrlDragImageView.this.ceK.setVisibility(4);
                    }

                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onImageLoaded() {
                        if (UrlDragImageView.this.cbW.isLongPic && me[0] > 0) {
                            UrlDragImageView.this.ceK.onDestroy();
                            final float measuredWidth = (UrlDragImageView.this.getMeasuredWidth() * 1.0f) / me[0];
                            final PointF pointF = new PointF((me[0] * 1.0f) / 2.0f, 0.0f);
                            UrlDragImageView.this.ceM.setScaleAndCenter(measuredWidth, pointF);
                            UrlDragImageView.this.ceM.setMaxScale(2.0f * measuredWidth);
                            UrlDragImageView.this.ceM.setDoubleTapZoomScale(2.0f * measuredWidth);
                            UrlDragImageView.this.ceM.setInitScale(measuredWidth);
                            UrlDragImageView.this.ceM.setDoubleTapZoomStyle(4);
                            UrlDragImageView.this.ceM.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12.1
                                @Override // android.view.View.OnTouchListener
                                public boolean onTouch(View view, MotionEvent motionEvent) {
                                    if (UrlDragImageView.this.cfr != null) {
                                        UrlDragImageView.this.cfr.onTouch(view, motionEvent);
                                    }
                                    switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                                        case 0:
                                            UrlDragImageView.this.cft = motionEvent.getY();
                                            UrlDragImageView.this.ceM.setOnClickListener(UrlDragImageView.this.cfs ? UrlDragImageView.this.mOnClickListener : null);
                                            UrlDragImageView.this.ceM.setOnLongClickListener(UrlDragImageView.this.cfs ? UrlDragImageView.this.cfu : null);
                                            break;
                                        case 1:
                                        case 3:
                                            if (UrlDragImageView.this.ceM.getScale() < measuredWidth) {
                                                UrlDragImageView.this.ceM.setScaleAndCenter(measuredWidth, pointF);
                                            }
                                            e.jH().removeCallbacks(UrlDragImageView.this.cfy);
                                            e.jH().postDelayed(UrlDragImageView.this.cfy, 1000L);
                                            break;
                                        case 2:
                                            if (Math.abs(motionEvent.getY() - UrlDragImageView.this.cft) > UrlDragImageView.TOUCH_SLOP) {
                                                UrlDragImageView.this.cfs = false;
                                                UrlDragImageView.this.ceM.setOnClickListener(null);
                                                UrlDragImageView.this.ceM.setOnLongClickListener(null);
                                            }
                                            UrlDragImageView.this.cft = motionEvent.getY();
                                            break;
                                    }
                                    return false;
                                }
                            });
                            UrlDragImageView.this.ceK.setVisibility(4);
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
            this.ceM.setOnImageEventListener(this.ceN);
            if (this.ceM.isImageLoaded() && this.cbW.isLongPic) {
                this.ceN.onImageLoaded();
            } else {
                this.ceM.setImage(ImageSource.uri(str));
            }
            return true;
        }
        return false;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.cfe = dVar;
        if (this.ceK != null) {
            this.ceK.setDragToExitListener(dVar);
        }
    }

    public void akz() {
        ev(false);
    }

    private boolean ok(String str) {
        return j.kY() || com.baidu.tbadk.core.util.d.c.nb(str);
    }

    private void setThumbBitmapToView(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap oy;
        if (!this.ceQ && aVar != null && (oy = aVar.oy()) != null) {
            this.ceP = true;
            if (aVar.isGif()) {
                this.ceK.setImageUrlData(this.cbW);
                this.ceK.setImageBitmap(oy);
                this.cfv = null;
                this.cfp = false;
            } else {
                if (this.cbW != null && this.cbW.isLongPic) {
                    this.ceK.aqF();
                    this.ceK.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.13
                        @Override // com.baidu.tbadk.widget.largeImage.logic.a
                        public void akI() {
                        }
                    });
                }
                this.ceK.setImageUrlData(this.cbW);
                this.ceK.setImageData(oy, aVar.oD());
            }
            akw();
        }
    }

    private void e(String str, boolean z, boolean z2) {
        if (ol(str)) {
            if (z2 || (!this.ceR && !this.ceQ)) {
                if (!z2 || !ev(true)) {
                    this.ceR = true;
                    com.baidu.adp.lib.f.c.jB().a(str, 27, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.14
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onCancelled(String str2) {
                            UrlDragImageView.this.ceR = false;
                            UrlDragImageView.this.ceK.setVisibility(0);
                            UrlDragImageView.this.mProgressBar.setVisibility(8);
                            UrlDragImageView.this.cfv = null;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            UrlDragImageView.this.ceR = false;
                            UrlDragImageView.this.ceQ = true;
                            UrlDragImageView.this.b(aVar);
                        }
                    }, 0, 0, false, null, Boolean.valueOf(z), this.ceK.getImageData(), Boolean.valueOf(this.cdq));
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
        com.baidu.adp.widget.ImageView.a a2 = this.cfq.a(imageFileInfo, false);
        if (a2 != null) {
            this.ceQ = true;
            this.mProgressBar.setVisibility(8);
            this.cfv = null;
            b(a2);
            return;
        }
        this.cfq.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.2
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.ImageView.a aVar, String str2, boolean z3) {
                UrlDragImageView.this.ceQ = true;
                UrlDragImageView.this.mProgressBar.setVisibility(8);
                UrlDragImageView.this.cfv = null;
                UrlDragImageView.this.b(aVar);
            }
        }, false);
    }

    private boolean ol(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith("https://"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null && this.ceO != null) {
            this.ceO.i(aVar.getUrl(), aVar.oD());
        }
        if (aVar == null || aVar.oy() == null) {
            akA();
            return;
        }
        Bitmap oy = aVar.oy();
        this.ceK.setLoadBigImage(true);
        if (aVar.isGif()) {
            this.ceK.setGifData(aVar.oD(), oy);
            this.ceK.invalidate();
            this.ceK.play();
            this.cfp = false;
            this.cfv = null;
            this.mProgressBar.setVisibility(8);
        } else {
            if (this.cbW != null && this.cbW.isLongPic) {
                this.ceK.aqF();
                this.ceK.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.3
                    @Override // com.baidu.tbadk.widget.largeImage.logic.a
                    public void akI() {
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.cfv = null;
                    }
                });
            } else {
                this.mProgressBar.setVisibility(8);
                this.cfv = null;
            }
            this.ceK.setImageUrlData(this.cbW);
            this.ceK.setImageData(oy, aVar.oD());
            akF();
        }
        akw();
    }

    private void akA() {
        if (!this.ceP) {
            this.ceK.setDefaultBitmap();
        } else {
            this.ceQ = false;
        }
        this.cfv = null;
        this.mProgressBar.setVisibility(8);
    }

    public void setGifMaxUseableMem(int i) {
        this.ceK.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.ceK != null) {
            this.ceK.onDestroy();
        }
        if (this.ceM != null) {
            this.ceM.recycle();
        }
        if (this.ceU != null) {
            this.ceU.recycle();
            this.ceU = null;
        }
        if (this.mProgressBar != null) {
            this.cfv = null;
            this.mProgressBar.setVisibility(8);
        }
        e.jH().removeCallbacks(this.cfy);
        com.baidu.tieba.view.c.cmN().setColor(-1);
    }

    public void release() {
        if (this.ceK != null) {
            this.ceK.release();
        }
        if (this.mProgressBar != null) {
            this.cfv = null;
            this.mProgressBar.setVisibility(8);
        }
        this.cfv = null;
    }

    public void akB() {
        if (this.ceK != null && this.ceK.getImageType() == 1) {
            this.ceK.stop();
        }
    }

    public void o(boolean z, boolean z2) {
        String str;
        if (this.ceK != null && (str = (String) this.ceK.getTag()) != null) {
            if (this.ceK.getImageType() == 1) {
                if (this.ceK.getGifCache() == null || !this.ceK.aqQ()) {
                    e(str, z, z2);
                }
            } else if (this.ceK.getImageType() == 2) {
                e(str, z, z2);
            } else if (akC()) {
                e(str, z, z2);
            }
        }
    }

    private boolean akC() {
        if (this.ceK.getImageBitmap() != null && this.ceK.aqQ()) {
            if (this.cbW == null || !this.cbW.isLongPic || this.ceK.aqG()) {
                return false;
            }
            this.ceQ = false;
            this.cfn = false;
            return true;
        }
        return true;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.cbW = imageUrlData;
    }

    public ImageUrlData getmAssistUrlData() {
        return this.cbW;
    }

    public void setIsCdn(boolean z) {
        this.cdq = z;
    }

    public void akD() {
        final String mK = as.mK(this.cbW.originalUrl);
        if (this.cbW.originalProcess >= 0) {
            com.baidu.tbadk.download.d.alN().ac(mK, 13);
            this.cbW.originalProcess = -1;
            akF();
            return;
        }
        if (this.cdi != null) {
            this.cdi.akJ();
        }
        com.baidu.adp.base.e<?> aK = i.aK(this.mContext);
        if (aK == null) {
            om(mK);
        } else if (!j.kY() || j.kZ() || com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("original_img_down_tip", false)) {
            om(mK);
        } else {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("original_img_down_tip", true);
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(aK.getPageActivity());
            aVar.gD(d.j.original_img_down_no_wifi_tip);
            aVar.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    UrlDragImageView.this.om(mK);
                }
            });
            aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                }
            });
            aVar.b(aK);
            aVar.aaZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void om(String str) {
        if (this.cbW != null) {
            this.cbW.originalProcess = 0;
            this.cfw.setProgress(0);
            this.cfw.setVisibility(0);
            DownloadData downloadData = new DownloadData(str);
            downloadData.setStatus(1);
            downloadData.setUrl(this.cbW.originalUrl);
            downloadData.setType(13);
            downloadData.setPath(this.cfg + ao.adk().mB(str) + "/" + str);
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.6
                @Override // com.baidu.tbadk.download.c
                public boolean onPreDownload(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2 != null) {
                        if (UrlDragImageView.this.cbW != null && UrlDragImageView.this.cbW.originalProcess != -1) {
                            UrlDragImageView.this.cbW.originalProcess = downloadData2.getProcess();
                        }
                        if (UrlDragImageView.this.cbW == null || UrlDragImageView.this.cbW.originalProcess != -1) {
                            UrlDragImageView.this.cfw.setProgress(downloadData2.getProcess());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public boolean onFileDownloaded(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadSucceed(DownloadData downloadData2) {
                    UrlDragImageView.this.cfw.setVisibility(8);
                    e.jH().postDelayed(UrlDragImageView.this.cfz, 1500L);
                    UrlDragImageView.this.cfn = false;
                    UrlDragImageView.this.cfm = UrlDragImageView.this.akE();
                    UrlDragImageView.this.akz();
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str2) {
                    UrlDragImageView.this.cfw.setVisibility(8);
                    UrlDragImageView.this.cfn = false;
                    BdToast.b(UrlDragImageView.this.mContext, str2).abf().abh();
                    UrlDragImageView.this.cbW.originalProcess = -1;
                    UrlDragImageView.this.akF();
                }
            });
            com.baidu.tbadk.download.d.alN().a(downloadData, 100);
            this.cfx = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean akE() {
        if (this.cbW != null && !StringUtils.isNull(this.cbW.originalUrl, true) && this.cbW.originalSize >= 0 && !this.cbW.isBlockedPic) {
            String mK = as.mK(this.cbW.originalUrl);
            File file = new File(this.cfg + ao.adk().mB(mK) + "/" + mK);
            if (file != null && file.exists()) {
                this.cbW.originalProcess = 100;
                return true;
            }
            if (this.cbW.originalProcess < 0) {
                akF();
            } else {
                this.cfw.setProgress(this.cbW.originalProcess);
            }
            this.cfp = true;
        } else {
            this.cfv = null;
        }
        return false;
    }

    public void akF() {
        if (this.cbW != null) {
            if (!akG() || !this.cfp) {
                this.cfv = null;
            } else if (this.cbW.originalSize > 0 && !aP(this.cbW.originalSize)) {
                this.cfv = ceI + "(" + ap.aE(this.cbW.originalSize) + ")";
            } else {
                this.cfv = ceI;
            }
        }
    }

    private boolean akG() {
        return (this.cbW == null || !this.cbW.mIsShowOrigonButton || this.cbW.isBlockedPic || StringUtils.isNull(this.cbW.originalUrl)) ? false : true;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.cdi = bVar;
    }

    private boolean aP(long j) {
        return j > ceJ;
    }
}
