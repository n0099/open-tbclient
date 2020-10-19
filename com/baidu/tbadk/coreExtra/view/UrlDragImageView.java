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
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.effect.d;
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.File;
/* loaded from: classes21.dex */
public class UrlDragImageView extends RelativeLayout {
    private ImageUrlData eTv;
    private boolean eUA;
    private b eUr;
    private boolean eUy;
    protected DragImageView eVV;
    protected TextView eVW;
    protected SubsamplingScaleImageView eVX;
    private SubsamplingScaleImageView.OnImageEventListener eVY;
    private a eVZ;
    private CircleProgressView eWA;
    private boolean eWB;
    private boolean eWC;
    private Runnable eWD;
    private Runnable eWE;
    private View.OnTouchListener eWF;
    private boolean eWa;
    private boolean eWb;
    private boolean eWc;
    private boolean eWd;
    private boolean eWe;
    private Bitmap eWf;
    private RectF eWg;
    private Rect eWh;
    private Rect eWi;
    private Rect eWj;
    private DragImageView.d eWk;
    private String eWl;
    private float eWm;
    private float eWn;
    private float eWo;
    private float eWp;
    private float eWq;
    private boolean eWr;
    private boolean eWs;
    private boolean eWt;
    public boolean eWu;
    private com.baidu.tbadk.img.b eWv;
    private View.OnTouchListener eWw;
    private boolean eWx;
    private float eWy;
    private String eWz;
    private boolean isInDragScaleMode;
    protected Context mContext;
    private Rect mDisplayRect;
    private final Matrix mDragMatrix;
    private RectF mDstRect;
    private float mLastMotionX;
    private float mLastMotionY;
    private View.OnLongClickListener mLongClickListener;
    private int mMaxHeight;
    private int mMaxWidth;
    private float mMoveDistance;
    private View.OnClickListener mOnClickListener;
    protected ProgressBar mProgressBar;
    private float mRatio;
    private int mSkinType;
    private String mUserId;
    private static final String eVT = TbadkCoreApplication.getInst().getString(R.string.original_img_look);
    private static long eVU = Config.RAVEN_LOG_LIMIT;
    private static final int EXIT_DISTANCE = l.getEquipmentHeight(TbadkCoreApplication.getInst()) / 5;
    private static final String TAG = UrlDragImageView.class.getSimpleName();
    private static final int TOUCH_SLOP = ViewConfiguration.get(TbadkCoreApplication.getInst()).getScaledTouchSlop();

    /* loaded from: classes21.dex */
    public interface a {
        void k(String str, byte[] bArr);
    }

    /* loaded from: classes21.dex */
    public interface b {
        void btT();
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
        if (this.eVV != null) {
            this.eVV.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.eVZ = aVar;
    }

    public UrlDragImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.eVV = null;
        this.eVZ = null;
        this.eUy = false;
        this.eWc = false;
        this.isInDragScaleMode = false;
        this.mRatio = 1.0f;
        this.mMoveDistance = 0.0f;
        this.mDragMatrix = new Matrix();
        this.mDstRect = new RectF();
        this.eWm = 0.0f;
        this.eWn = 0.0f;
        this.eWo = 1.0f;
        this.eWp = 1.0f;
        this.eWq = 0.0f;
        this.eWr = false;
        this.eWs = false;
        this.eWt = false;
        this.eWu = false;
        this.eWx = true;
        this.eWy = 0.0f;
        this.mOnClickListener = null;
        this.mLongClickListener = null;
        this.eWz = null;
        this.eWD = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.eWx = true;
            }
        };
        this.eWE = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.eWA.setVisibility(8);
                        UrlDragImageView.this.eWz = null;
                        UrlDragImageView.this.eWu = false;
                    }
                });
            }
        };
        this.eWF = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.eWw != null) {
                    UrlDragImageView.this.eWw.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.eWv = new com.baidu.tbadk.img.b();
        init();
    }

    public UrlDragImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.eVV = null;
        this.eVZ = null;
        this.eUy = false;
        this.eWc = false;
        this.isInDragScaleMode = false;
        this.mRatio = 1.0f;
        this.mMoveDistance = 0.0f;
        this.mDragMatrix = new Matrix();
        this.mDstRect = new RectF();
        this.eWm = 0.0f;
        this.eWn = 0.0f;
        this.eWo = 1.0f;
        this.eWp = 1.0f;
        this.eWq = 0.0f;
        this.eWr = false;
        this.eWs = false;
        this.eWt = false;
        this.eWu = false;
        this.eWx = true;
        this.eWy = 0.0f;
        this.mOnClickListener = null;
        this.mLongClickListener = null;
        this.eWz = null;
        this.eWD = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.eWx = true;
            }
        };
        this.eWE = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.eWA.setVisibility(8);
                        UrlDragImageView.this.eWz = null;
                        UrlDragImageView.this.eWu = false;
                    }
                });
            }
        };
        this.eWF = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.eWw != null) {
                    UrlDragImageView.this.eWw.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.eWv = new com.baidu.tbadk.img.b();
        init();
    }

    public DragImageView getImageView() {
        return this.eVV;
    }

    public void setGifSetListener(DragImageView.e eVar) {
        this.eVV.setGifSetListener(eVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.eVV.setImageOnClickListener(onClickListener);
        this.eVX.setOnClickListener(onClickListener);
        this.mOnClickListener = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mLongClickListener = onLongClickListener;
        if (!this.eUA) {
            this.eVV.setImageOnLongClickListener(this.mLongClickListener);
            this.eVX.setOnLongClickListener(this.mLongClickListener);
        }
    }

    public void setOnSizeChangedListener(final DragImageView.g gVar) {
        this.eVV.setOnSizeChangedListener(new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.8
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (gVar != null) {
                    gVar.a(dragImageView, z, z2);
                }
                UrlDragImageView.this.btH();
            }
        });
    }

    protected void init() {
        this.eWl = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        this.mMaxWidth = l.getEquipmentWidth(this.mContext);
        this.mMaxHeight = l.getEquipmentHeight(this.mContext) - ((int) this.mContext.getResources().getDimension(R.dimen.ds166));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.eVV = new DragImageView(this.mContext);
        this.eVV.setLayoutParams(layoutParams);
        this.eVV.setOnTouchListener(this.eWF);
        addView(this.eVV);
        this.eVX = new SubsamplingScaleImageView(this.mContext);
        this.eVX.setMaxScale(50.0f);
        this.eVX.setOnTouchListener(this.eWF);
        this.eVX.setVisibility(4);
        addView(this.eVX, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(getResources().getDrawable(R.drawable.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        btG();
        this.eWC = TbSingleton.getInstance().isCutoutScreen(TbadkApplication.getInst().getCurrentActivity());
    }

    private void btG() {
        this.eWA = new CircleProgressView(this.mContext);
        this.eWA.setCircleBackgroundColor(ap.getColor(R.color.cp_cont_d));
        this.eWA.setCircleForegroundColor(ap.getColor(R.color.cp_link_tip_a));
        this.eWA.setProgress(0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds80), l.getDimens(getContext(), R.dimen.tbds80));
        layoutParams.addRule(13);
        this.eWA.setVisibility(8);
        addView(this.eWA, layoutParams);
    }

    public void setIsCanDrag(boolean z) {
        this.eUA = z;
    }

    public String getmCheckOriginPicText() {
        return this.eWz;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        Bitmap imageBitmap;
        int height;
        int width;
        if (this.eWr && !this.eWB && this.eVX.getVisibility() == 0 && !this.eVX.isImageLoaded()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.eUA || !this.eWb) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.eWd && motionEvent.getPointerCount() >= 2) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.eWd || this.eWe) {
            requestDisallowInterceptTouchEvent(true);
        }
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        float x = motionEvent.getX();
        int i = action & 255;
        if (i == 0) {
            if (this.eWf == null) {
                if (this.eVX.getVisibility() == 0) {
                    this.eWf = h.bB(this.eVX);
                } else {
                    this.eWf = h.bB(this.eVV);
                }
            }
            if (this.mDisplayRect == null && this.eWf != null) {
                int measuredWidth = getMeasuredWidth();
                float measuredWidth2 = ((getMeasuredWidth() * 1.0f) / this.eWf.getWidth()) * this.eWf.getHeight();
                if (measuredWidth2 > getMeasuredHeight()) {
                    measuredWidth2 = getMeasuredHeight();
                }
                RectF rectInScreenFromPosition = getRectInScreenFromPosition(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
                this.mDisplayRect = new Rect((int) rectInScreenFromPosition.left, (int) rectInScreenFromPosition.top, (int) rectInScreenFromPosition.right, (int) rectInScreenFromPosition.bottom);
            }
            if (this.eWi == null && this.eWf != null) {
                if (this.eVX.getVisibility() == 0) {
                    height = this.eVX.getSHeight();
                    width = this.eVX.getSWidth();
                } else {
                    if (this.eVV.getImageType() == 1) {
                        imageBitmap = (this.eVV.getCurrentFrame() == null || this.eVV.getCurrentFrame().bm == null) ? this.eWf : this.eVV.getCurrentFrame().bm;
                    } else {
                        imageBitmap = this.eVV.getImageBitmap() == null ? this.eWf : this.eVV.getImageBitmap();
                    }
                    height = imageBitmap.getHeight();
                    width = imageBitmap.getWidth();
                }
                float equipmentDensity = l.getEquipmentDensity(getContext());
                int i2 = (int) (height * equipmentDensity);
                int i3 = (int) (width * equipmentDensity);
                if (i3 > this.eWf.getWidth() && this.eWf.getWidth() != 0) {
                    float width2 = (i3 * 1.0f) / this.eWf.getWidth();
                    i3 = this.eWf.getWidth();
                    i2 = (int) (i2 / width2);
                }
                if (i2 > this.eWf.getHeight() && this.eWf.getHeight() != 0) {
                    i3 = (int) (i3 / ((i2 * 1.0f) / this.eWf.getHeight()));
                    i2 = this.eWf.getHeight();
                }
                int equipmentHeight = (l.getEquipmentHeight(getContext()) - i2) / 2;
                int equipmentWidth = (l.getEquipmentWidth(getContext()) - i3) / 2;
                this.eWi = new Rect(equipmentWidth, equipmentHeight, i3 + equipmentWidth, i2 + equipmentHeight);
                this.eWj = new Rect(this.eWi);
                this.eWq = equipmentHeight / l.getEquipmentHeight(getContext());
                this.eWh = new Rect(0, 0, this.eWf.getWidth(), this.eWf.getHeight());
            }
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (i == 2) {
            this.eWd = w(this.mLastMotionX - x, this.mLastMotionY - y);
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (this.eWd || this.eWe) {
            this.eVV.setImageOnLongClickListener(null);
            this.eVX.setOnLongClickListener(null);
            z = true;
        } else {
            this.eVV.setImageOnLongClickListener(this.mLongClickListener);
            this.eVX.setOnLongClickListener(this.mLongClickListener);
            z = super.dispatchTouchEvent(motionEvent);
        }
        if (i == 1 || i == 3) {
            this.mLastMotionX = 0.0f;
            this.mLastMotionY = 0.0f;
            boolean z2 = (-this.mMoveDistance) > ((float) EXIT_DISTANCE);
            boolean z3 = this.mMoveDistance > ((float) EXIT_DISTANCE);
            if (z2 || z3) {
                this.eWe = true;
                startExitAnimation();
                if (z2) {
                    TiebaStatic.log(new aq("c13377").dK("obj_type", "3"));
                } else if (z3) {
                    TiebaStatic.log(new aq("c13377").dK("obj_type", "2"));
                }
            } else {
                if (this.eWd && this.eWk != null) {
                    this.eWk.bzS();
                }
                this.mRatio = 1.0f;
                invalidate();
            }
            this.isInDragScaleMode = false;
            this.mDragMatrix.reset();
            this.eWd = false;
        }
        return z;
    }

    private boolean w(float f, float f2) {
        if (this.eVX.getVisibility() != 0 || this.eVX.isCanDrag()) {
            if (this.eTv == null || !this.eTv.isLongPic || this.eVX.getVisibility() != 0 || this.eVX.isViewTop()) {
                if (this.eTv == null || !this.eTv.isLongPic || this.eVX.getVisibility() == 0 || this.eVV.isAtViewTop() || this.eVV.bzQ()) {
                    if (this.eVX.getVisibility() == 0 || this.eVV.pagerCantScroll()) {
                        if (this.eWf != null && getScrollY() == 0) {
                            boolean z = (this.eTv == null || !this.eTv.isLongPic) && ((f2 < -15.0f && !this.isInDragScaleMode) || (f2 > 15.0f && !this.isInDragScaleMode));
                            boolean z2 = this.eTv != null && this.eTv.isLongPic && f2 < 0.0f && !this.isInDragScaleMode;
                            if (z || (z2 && this.eVV.isViewTop())) {
                                this.eVV.setImageOnLongClickListener(null);
                                this.eVX.setOnLongClickListener(null);
                                this.isInDragScaleMode = true;
                                this.mMoveDistance = 0.0f;
                                this.mRatio = 1.0f;
                                if (this.eWk != null) {
                                    this.eWk.onDragStart();
                                }
                            }
                        }
                        if (!this.isInDragScaleMode || this.eWf == null) {
                            return false;
                        }
                        this.mMoveDistance -= f2;
                        int measuredHeight = getMeasuredHeight();
                        if (this.mMoveDistance > measuredHeight) {
                            this.mMoveDistance = measuredHeight;
                        }
                        float f3 = f2 / measuredHeight;
                        this.mDragMatrix.postTranslate((-f) * 1.5f * this.mRatio, (-1.5f) * f2 * this.mRatio);
                        if (this.mRatio * (1.0f + f3) > 1.0f || this.mMoveDistance < 0.0f) {
                            f3 = -f3;
                        }
                        this.mDragMatrix.preScale(1.0f + f3, 1.0f + f3, (this.mRatio * this.eWf.getWidth()) / 2.0f, this.mRatio * (this.eWf.getHeight() / 2));
                        this.mRatio = (f3 + 1.0f) * this.mRatio;
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
        if (this.eWd && this.eWf != null && !this.eWf.isRecycled() && this.isInDragScaleMode) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.mDstRect == null) {
                this.mDstRect = new RectF();
            }
            this.mDragMatrix.mapRect(this.mDstRect, new RectF(this.mDisplayRect));
            canvas.drawBitmap(this.eWf, this.eWh, this.mDstRect, (Paint) null);
        } else if (this.eWe && this.eWf != null && !this.eWf.isRecycled()) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.eTv == null || this.eTv.getSourceImageRectInScreen() == null) {
                canvas.drawBitmap(this.eWf, this.eWh, this.mDstRect, (Paint) null);
            } else {
                canvas.drawBitmap(this.eWf, this.eWi, this.mDstRect, (Paint) null);
            }
        } else {
            super.dispatchDraw(canvas);
        }
    }

    private void startExitAnimation() {
        if (this.eTv == null) {
            if (this.eWk != null) {
                this.eWk.onDragEnd();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.eTv.getSourceImageRectInScreen();
        final Rect dstRectInScreen = this.eTv.getDstRectInScreen();
        if (sourceImageRectInScreen == null || dstRectInScreen == null) {
            if (this.eWk != null) {
                this.eWk.onDragEnd();
                return;
            }
            return;
        }
        a(sourceImageRectInScreen, dstRectInScreen);
        b(sourceImageRectInScreen);
        this.eWg = new RectF(this.mDstRect);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(150L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && sourceImageRectInScreen != null && dstRectInScreen != null) {
                    UrlDragImageView.this.ah(valueAnimator.getAnimatedFraction());
                    UrlDragImageView.this.a(dstRectInScreen, valueAnimator.getAnimatedFraction(), UrlDragImageView.this.eWC);
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
                UrlDragImageView.this.isInDragScaleMode = false;
                UrlDragImageView.this.invalidate();
                if (UrlDragImageView.this.eWk != null) {
                    UrlDragImageView.this.eWk.onDragEnd();
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

    private void b(Rect rect) {
        if (rect != null) {
            float f = ((rect.bottom - rect.top) / (rect.right - rect.left)) * (this.mDstRect.right - this.mDstRect.left);
            this.mDstRect.top += this.mDstRect.height() * this.eWq;
            this.mDstRect.bottom = f + this.mDstRect.top;
        }
    }

    public void setCanScale(boolean z) {
        if (this.eVV != null) {
            this.eVV.setCanScale(z);
        }
    }

    private void a(Rect rect, Rect rect2) {
        this.eWm = 0.0f;
        this.eWn = 0.0f;
        this.eWo = 1.0f;
        this.eWp = 1.0f;
        if (rect != null && rect2 != null && rect.contains(rect2)) {
            this.eWm = (rect2.left - rect.left) / rect.width();
            this.eWn = (rect2.top - rect.top) / rect.height();
            this.eWo = (rect2.right - rect.left) / rect.width();
            this.eWp = (rect2.bottom - rect.top) / rect.height();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah(float f) {
        if (this.eWi != null) {
            this.eWi.left = (int) (this.eWj.left + (this.eWj.width() * this.eWm * f));
            this.eWi.top = (int) (this.eWj.top + (this.eWj.height() * this.eWn * f));
            this.eWi.right = (int) (this.eWj.left + (this.eWj.width() * (((1.0f - this.eWo) * (1.0f - f)) + this.eWo)));
            this.eWi.bottom = (int) (this.eWj.top + (this.eWj.height() * (((1.0f - this.eWp) * (1.0f - f)) + this.eWp)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Rect rect, float f, boolean z) {
        int i = 0;
        if (z) {
            i = l.getDimens(getContext(), R.dimen.tbds80);
        }
        if (this.mDstRect != null && rect != null) {
            this.mDstRect.left = this.eWg.left + ((rect.left - this.eWg.left) * f);
            this.mDstRect.top = (this.eWg.top + ((rect.top - this.eWg.top) * f)) - i;
            this.mDstRect.right = this.eWg.right + ((rect.right - this.eWg.right) * f);
            this.mDstRect.bottom = this.eWg.bottom + ((rect.bottom - this.eWg.bottom) * f);
        }
    }

    private RectF getRectInScreenFromPosition(float f, float f2, float f3, float f4) {
        return new RectF(f - (f3 / 2.0f), f2 - (f4 / 2.0f), (f3 / 2.0f) + f, (f4 / 2.0f) + f2);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.eWw = onTouchListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btH() {
        if ((this.eWa || this.eWb) && this.eTv != null && this.eTv.mPicType == 1 && !TextUtils.isEmpty(this.eTv.mTagName)) {
            if (this.eVW != null) {
                this.eVW.setVisibility(8);
                this.eVW = null;
            }
            this.eVW = new TextView(this.mContext);
            this.eVW.setText(this.eTv.mTagName);
            this.eVW.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize26));
            ap.setViewTextColor(this.eVW, R.color.common_color_10013, 1, 0);
            ap.setBackgroundColor(this.eVW, R.color.common_color_10215);
            this.eVW.setAlpha(0.75f);
            this.eVW.setIncludeFontPadding(false);
            this.eVW.setGravity(17);
            int dimens = l.getDimens(this.mContext, R.dimen.ds2);
            this.eVW.setPadding(dimens, dimens, dimens, dimens);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.eVV.getBottomOffset();
            layoutParams.leftMargin = this.eVV.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.eVW, layoutParams);
            this.eVW.setVisibility(0);
        }
    }

    public void setUrl(String str, boolean z) {
        if (str.contains("*")) {
            str = str.split("[*]")[0];
        }
        this.eVV.setTag(str);
        this.eVV.setLoadBigImage(false);
        this.eVV.setImageDrawable(null);
        this.eWa = false;
        this.eWb = false;
        this.eWr = btP();
        this.eWz = null;
        if (CB(str)) {
            e(str, z, false);
        }
    }

    private boolean btI() {
        return this.eVV != null && this.eVV.isLoadBigImage();
    }

    public void btJ() {
        if (this.eTv != null && !btI()) {
            String str = this.eTv.imageUrl;
            int i = this.eTv.urlType;
            com.baidu.adp.widget.ImageView.a aVar = null;
            if (com.baidu.tbadk.core.util.c.a.al(str, i)) {
                aVar = com.baidu.tbadk.core.util.c.a.am(str, i);
            }
            if (aVar != null) {
                setThumbBitmapToView(aVar);
            }
        }
    }

    private boolean ju(boolean z) {
        String nameMd5FromUrl;
        if (!this.eWs || z) {
            this.eWs = true;
            if (!this.eWr || this.eTv == null || StringUtils.isNull(this.eTv.originalUrl, true) || this.eTv.originalSize < 0 || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String str = this.eWl + as.bmS().Bn(nameMd5FromUrl) + "/" + av.getNameMd5FromUrl(this.eTv.originalUrl);
            final int[] imageFileWH = n.getImageFileWH(str);
            this.eVX.setVisibility(0);
            if (this.eVY == null) {
                this.eVY = new SubsamplingScaleImageView.OnImageEventListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12
                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onReady() {
                        UrlDragImageView.this.eWz = null;
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.eVV.restoreSize();
                        UrlDragImageView.this.eVV.setVisibility(4);
                    }

                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onImageLoaded() {
                        if (UrlDragImageView.this.eTv.isLongPic && imageFileWH[0] > 0) {
                            UrlDragImageView.this.eVV.onDestroy();
                            final float measuredWidth = (UrlDragImageView.this.getMeasuredWidth() * 1.0f) / imageFileWH[0];
                            final PointF pointF = new PointF((imageFileWH[0] * 1.0f) / 2.0f, 0.0f);
                            UrlDragImageView.this.eVX.setScaleAndCenter(measuredWidth, pointF);
                            UrlDragImageView.this.eVX.setMaxScale(2.0f * measuredWidth);
                            UrlDragImageView.this.eVX.setDoubleTapZoomScale(2.0f * measuredWidth);
                            UrlDragImageView.this.eVX.setInitScale(measuredWidth);
                            UrlDragImageView.this.eVX.setDoubleTapZoomStyle(4);
                            UrlDragImageView.this.eVX.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12.1
                                @Override // android.view.View.OnTouchListener
                                public boolean onTouch(View view, MotionEvent motionEvent) {
                                    if (UrlDragImageView.this.eWw != null) {
                                        UrlDragImageView.this.eWw.onTouch(view, motionEvent);
                                    }
                                    switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                                        case 0:
                                            UrlDragImageView.this.eWy = motionEvent.getY();
                                            UrlDragImageView.this.eVX.setOnClickListener(UrlDragImageView.this.eWx ? UrlDragImageView.this.mOnClickListener : null);
                                            UrlDragImageView.this.eVX.setOnLongClickListener(UrlDragImageView.this.eWx ? UrlDragImageView.this.mLongClickListener : null);
                                            break;
                                        case 1:
                                        case 3:
                                            if (UrlDragImageView.this.eVX.getScale() < measuredWidth) {
                                                UrlDragImageView.this.eVX.setScaleAndCenter(measuredWidth, pointF);
                                            }
                                            e.mY().removeCallbacks(UrlDragImageView.this.eWD);
                                            e.mY().postDelayed(UrlDragImageView.this.eWD, 1000L);
                                            break;
                                        case 2:
                                            if (Math.abs(motionEvent.getY() - UrlDragImageView.this.eWy) > UrlDragImageView.TOUCH_SLOP) {
                                                UrlDragImageView.this.eWx = false;
                                                UrlDragImageView.this.eVX.setOnClickListener(null);
                                                UrlDragImageView.this.eVX.setOnLongClickListener(null);
                                            }
                                            UrlDragImageView.this.eWy = motionEvent.getY();
                                            break;
                                    }
                                    return false;
                                }
                            });
                            UrlDragImageView.this.eVV.setVisibility(4);
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
            this.eVX.setOnImageEventListener(this.eVY);
            if (this.eVX.isImageLoaded() && this.eTv.isLongPic) {
                this.eVY.onImageLoaded();
            } else {
                this.eVX.setImage(ImageSource.uri(str));
            }
            return true;
        }
        return false;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.eWk = dVar;
        if (this.eVV != null) {
            this.eVV.setDragToExitListener(dVar);
        }
    }

    public void btK() {
        ju(false);
    }

    private boolean CB(String str) {
        return j.isNetWorkAvailable() || com.baidu.tbadk.core.util.c.c.BA(str);
    }

    private void setThumbBitmapToView(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap rawBitmap;
        if (!this.eWb && aVar != null && (rawBitmap = aVar.getRawBitmap()) != null) {
            this.eWa = true;
            if (aVar.isGif()) {
                this.eVV.setImageUrlData(this.eTv);
                this.eVV.setImageBitmap(rawBitmap);
                this.eWz = null;
                this.eWu = false;
            } else {
                if (this.eTv != null && this.eTv.isLongPic) {
                    this.eVV.createLargeImageDelegate();
                    this.eVV.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.13
                        @Override // com.baidu.tbadk.widget.largeImage.logic.a
                        public void onLoadFinished() {
                        }
                    });
                }
                this.eVV.setImageUrlData(this.eTv);
                this.eVV.setImageData(rawBitmap, aVar.getByteData());
            }
            btH();
        }
    }

    private void e(String str, boolean z, boolean z2) {
        if (CC(str)) {
            if (z2 || (!this.eWc && !this.eWb)) {
                if (!z2 || !ju(true)) {
                    this.eWc = true;
                    com.baidu.adp.lib.e.c.mS().a(str, 27, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.14
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.b
                        public void onCancelled(String str2) {
                            UrlDragImageView.this.eWc = false;
                            UrlDragImageView.this.eVV.setVisibility(0);
                            UrlDragImageView.this.mProgressBar.setVisibility(8);
                            UrlDragImageView.this.eWz = null;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            UrlDragImageView.this.eWc = false;
                            UrlDragImageView.this.eWb = true;
                            UrlDragImageView.this.b(aVar);
                        }
                    }, 0, 0, false, null, Boolean.valueOf(z), this.eVV.getImageData(), Boolean.valueOf(this.eUy));
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
        imageFileInfo.addPageAction(d.bf(this.mMaxWidth, this.mMaxHeight));
        com.baidu.adp.widget.ImageView.a a2 = this.eWv.a(imageFileInfo, false);
        if (a2 != null) {
            this.eWb = true;
            this.mProgressBar.setVisibility(8);
            this.eWz = null;
            b(a2);
            return;
        }
        this.eWv.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.2
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.ImageView.a aVar, String str2, boolean z3) {
                UrlDragImageView.this.eWb = true;
                UrlDragImageView.this.mProgressBar.setVisibility(8);
                UrlDragImageView.this.eWz = null;
                UrlDragImageView.this.b(aVar);
            }
        }, false);
    }

    private boolean CC(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null && this.eVZ != null) {
            this.eVZ.k(aVar.getUrl(), aVar.getByteData());
        }
        if (aVar == null || aVar.getRawBitmap() == null) {
            btL();
            return;
        }
        Bitmap rawBitmap = aVar.getRawBitmap();
        this.eVV.setLoadBigImage(true);
        if (aVar.isGif()) {
            this.eVV.setGifData(aVar.getByteData(), rawBitmap);
            this.eVV.invalidate();
            this.eVV.play();
            this.eWu = false;
            this.eWz = null;
            this.mProgressBar.setVisibility(8);
        } else {
            if (this.eTv != null && this.eTv.isLongPic) {
                this.eVV.createLargeImageDelegate();
                this.eVV.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.3
                    @Override // com.baidu.tbadk.widget.largeImage.logic.a
                    public void onLoadFinished() {
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.eWz = null;
                    }
                });
            } else {
                this.mProgressBar.setVisibility(8);
                this.eWz = null;
            }
            this.eVV.setImageUrlData(this.eTv);
            this.eVV.setImageData(rawBitmap, aVar.getByteData());
            btQ();
        }
        btH();
    }

    private void btL() {
        if (!this.eWa) {
            this.eVV.setDefaultBitmap();
        } else {
            this.eWb = false;
        }
        this.eWz = null;
        this.mProgressBar.setVisibility(8);
    }

    public void setGifMaxUseableMem(int i) {
        this.eVV.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.eVV != null) {
            this.eVV.onDestroy();
        }
        if (this.eVX != null) {
            this.eVX.recycle();
        }
        if (this.eWf != null) {
            this.eWf.recycle();
            this.eWf = null;
        }
        if (this.mProgressBar != null) {
            this.eWz = null;
            this.mProgressBar.setVisibility(8);
        }
        e.mY().removeCallbacks(this.eWD);
        com.baidu.tieba.view.c.dMO().setColor(-1);
    }

    public void release() {
        if (this.eVV != null) {
            this.eVV.release();
        }
        if (this.mProgressBar != null) {
            this.eWz = null;
            this.mProgressBar.setVisibility(8);
        }
        this.eWz = null;
    }

    public void btM() {
        if (this.eVV != null && this.eVV.getImageType() == 1) {
            this.eVV.stop();
        }
    }

    public void E(boolean z, boolean z2) {
        String str;
        if (this.eVV != null && (str = (String) this.eVV.getTag()) != null) {
            if (this.eVV.getImageType() == 1) {
                if (this.eVV.getGifCache() == null || !this.eVV.isLoadBigImage()) {
                    e(str, z, z2);
                }
            } else if (this.eVV.getImageType() == 2) {
                e(str, z, z2);
            } else if (btN()) {
                e(str, z, z2);
            }
        }
    }

    private boolean btN() {
        if (this.eVV.getImageBitmap() != null && this.eVV.isLoadBigImage()) {
            if (this.eTv == null || !this.eTv.isLongPic || this.eVV.hasLoadLongImage()) {
                return false;
            }
            this.eWb = false;
            this.eWs = false;
            return true;
        }
        return true;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.eTv = imageUrlData;
    }

    public ImageUrlData getmAssistUrlData() {
        return this.eTv;
    }

    public void setIsCdn(boolean z) {
        this.eUy = z;
    }

    public void btO() {
        final String nameMd5FromUrl = av.getNameMd5FromUrl(this.eTv.originalUrl);
        if (this.eTv.originalProcess >= 0) {
            com.baidu.tbadk.download.d.bvb().cancelDownLoadById(nameMd5FromUrl, 13);
            this.eTv.originalProcess = -1;
            btQ();
            return;
        }
        if (this.eUr != null) {
            this.eUr.btT();
        }
        com.baidu.adp.base.e<?> I = i.I(this.mContext);
        if (I == null) {
            CD(nameMd5FromUrl);
        } else if (!j.isNetWorkAvailable() || j.isWifiNet() || com.baidu.tbadk.core.sharedPref.b.blO().getBoolean(SharedPrefConfig.ORIGINAL_IMG_DOWN_TIP, false)) {
            CD(nameMd5FromUrl);
        } else {
            com.baidu.tbadk.core.sharedPref.b.blO().putBoolean(SharedPrefConfig.ORIGINAL_IMG_DOWN_TIP, true);
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(I.getPageActivity());
            aVar.ob(R.string.original_img_down_no_wifi_tip);
            aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    UrlDragImageView.this.CD(nameMd5FromUrl);
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                }
            });
            aVar.b(I);
            aVar.bkJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CD(String str) {
        if (this.eTv != null) {
            this.eTv.originalProcess = 0;
            this.eWA.setProgress(0);
            this.eWA.setVisibility(0);
            DownloadData downloadData = new DownloadData(str);
            downloadData.setStatus(1);
            downloadData.setUrl(this.eTv.originalUrl);
            downloadData.setType(13);
            downloadData.setPath(this.eWl + as.bmS().Bn(str) + "/" + str);
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.6
                @Override // com.baidu.tbadk.download.c
                public boolean onPreDownload(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2 != null) {
                        if (UrlDragImageView.this.eTv != null && UrlDragImageView.this.eTv.originalProcess != -1) {
                            UrlDragImageView.this.eTv.originalProcess = downloadData2.getProcess();
                        }
                        if (UrlDragImageView.this.eTv == null || UrlDragImageView.this.eTv.originalProcess != -1) {
                            UrlDragImageView.this.eWA.setProgress(downloadData2.getProcess());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public boolean onFileDownloaded(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadSucceed(DownloadData downloadData2) {
                    UrlDragImageView.this.eWA.setVisibility(8);
                    e.mY().postDelayed(UrlDragImageView.this.eWE, 1500L);
                    UrlDragImageView.this.eWs = false;
                    UrlDragImageView.this.eWr = UrlDragImageView.this.btP();
                    UrlDragImageView.this.btK();
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str2) {
                    UrlDragImageView.this.eWA.setVisibility(8);
                    UrlDragImageView.this.eWs = false;
                    BdToast.b(UrlDragImageView.this.mContext, str2).bkO().bkP();
                    UrlDragImageView.this.eTv.originalProcess = -1;
                    UrlDragImageView.this.btQ();
                }
            });
            com.baidu.tbadk.download.d.bvb().a(downloadData, 100);
            this.eWB = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean btP() {
        if (this.eTv != null && !StringUtils.isNull(this.eTv.originalUrl, true) && this.eTv.originalSize >= 0 && !this.eTv.isBlockedPic) {
            String nameMd5FromUrl = av.getNameMd5FromUrl(this.eTv.originalUrl);
            File file = new File(this.eWl + as.bmS().Bn(nameMd5FromUrl) + "/" + nameMd5FromUrl);
            if (file != null && file.exists()) {
                this.eTv.originalProcess = 100;
                return true;
            }
            if (this.eTv.originalProcess < 0) {
                btQ();
            } else {
                this.eWA.setProgress(this.eTv.originalProcess);
            }
            this.eWu = true;
        } else {
            this.eWz = null;
        }
        return false;
    }

    public void btQ() {
        if (this.eTv != null) {
            if (!btR() || !this.eWu) {
                this.eWz = null;
            } else if (this.eTv.originalSize > 0 && !dg(this.eTv.originalSize)) {
                this.eWz = eVT + "(" + at.getFormatSize(this.eTv.originalSize) + ")";
            } else {
                this.eWz = eVT;
            }
        }
    }

    private boolean btR() {
        return (this.eTv == null || !this.eTv.mIsShowOrigonButton || this.eTv.isBlockedPic || StringUtils.isNull(this.eTv.originalUrl)) ? false : true;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.eUr = bVar;
    }

    private boolean dg(long j) {
        return j > eVU;
    }
}
