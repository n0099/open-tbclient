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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.util.g;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.File;
/* loaded from: classes8.dex */
public class UrlDragImageView extends RelativeLayout {
    private ImageUrlData dqH;
    private b drN;
    private boolean drU;
    private boolean drW;
    private Bitmap dtA;
    private RectF dtB;
    private Rect dtC;
    private Rect dtD;
    private Rect dtE;
    private DragImageView.d dtF;
    private String dtG;
    private float dtH;
    private float dtI;
    private float dtJ;
    private float dtK;
    private float dtL;
    private boolean dtM;
    private boolean dtN;
    private boolean dtO;
    public boolean dtP;
    private com.baidu.tbadk.img.b dtQ;
    private View.OnTouchListener dtR;
    private boolean dtS;
    private float dtT;
    private String dtU;
    private CircleProgressView dtV;
    private boolean dtW;
    private boolean dtX;
    private Runnable dtY;
    private Runnable dtZ;
    protected DragImageView dtq;
    protected TextView dtr;
    protected SubsamplingScaleImageView dts;
    private SubsamplingScaleImageView.OnImageEventListener dtt;
    private a dtu;
    private boolean dtv;
    private boolean dtw;
    private boolean dtx;
    private boolean dty;
    private boolean dtz;
    private View.OnTouchListener dua;
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
    private static final String dto = TbadkCoreApplication.getInst().getString(R.string.original_img_look);
    private static long dtp = Config.RAVEN_LOG_LIMIT;
    private static final int EXIT_DISTANCE = l.getEquipmentHeight(TbadkCoreApplication.getInst()) / 5;
    private static final String TAG = UrlDragImageView.class.getSimpleName();
    private static final int TOUCH_SLOP = ViewConfiguration.get(TbadkCoreApplication.getInst()).getScaledTouchSlop();

    /* loaded from: classes8.dex */
    public interface a {
        void k(String str, byte[] bArr);
    }

    /* loaded from: classes8.dex */
    public interface b {
        void aNf();
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
        if (this.dtq != null) {
            this.dtq.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.dtu = aVar;
    }

    public UrlDragImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.dtq = null;
        this.dtu = null;
        this.drU = false;
        this.dtx = false;
        this.isInDragScaleMode = false;
        this.mRatio = 1.0f;
        this.mMoveDistance = 0.0f;
        this.mDragMatrix = new Matrix();
        this.mDstRect = new RectF();
        this.dtH = 0.0f;
        this.dtI = 0.0f;
        this.dtJ = 1.0f;
        this.dtK = 1.0f;
        this.dtL = 0.0f;
        this.dtM = false;
        this.dtN = false;
        this.dtO = false;
        this.dtP = false;
        this.dtS = true;
        this.dtT = 0.0f;
        this.mOnClickListener = null;
        this.mLongClickListener = null;
        this.dtU = null;
        this.dtY = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.dtS = true;
            }
        };
        this.dtZ = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.dtV.setVisibility(8);
                        UrlDragImageView.this.dtU = null;
                        UrlDragImageView.this.dtP = false;
                    }
                });
            }
        };
        this.dua = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.dtR != null) {
                    UrlDragImageView.this.dtR.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.dtQ = new com.baidu.tbadk.img.b();
        init();
    }

    public UrlDragImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.dtq = null;
        this.dtu = null;
        this.drU = false;
        this.dtx = false;
        this.isInDragScaleMode = false;
        this.mRatio = 1.0f;
        this.mMoveDistance = 0.0f;
        this.mDragMatrix = new Matrix();
        this.mDstRect = new RectF();
        this.dtH = 0.0f;
        this.dtI = 0.0f;
        this.dtJ = 1.0f;
        this.dtK = 1.0f;
        this.dtL = 0.0f;
        this.dtM = false;
        this.dtN = false;
        this.dtO = false;
        this.dtP = false;
        this.dtS = true;
        this.dtT = 0.0f;
        this.mOnClickListener = null;
        this.mLongClickListener = null;
        this.dtU = null;
        this.dtY = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.dtS = true;
            }
        };
        this.dtZ = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.dtV.setVisibility(8);
                        UrlDragImageView.this.dtU = null;
                        UrlDragImageView.this.dtP = false;
                    }
                });
            }
        };
        this.dua = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.dtR != null) {
                    UrlDragImageView.this.dtR.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.dtQ = new com.baidu.tbadk.img.b();
        init();
    }

    public DragImageView getImageView() {
        return this.dtq;
    }

    public void setGifSetListener(DragImageView.e eVar) {
        this.dtq.setGifSetListener(eVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.dtq.setImageOnClickListener(onClickListener);
        this.dts.setOnClickListener(onClickListener);
        this.mOnClickListener = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mLongClickListener = onLongClickListener;
        if (!this.drW) {
            this.dtq.setImageOnLongClickListener(this.mLongClickListener);
            this.dts.setOnLongClickListener(this.mLongClickListener);
        }
    }

    public void setOnSizeChangedListener(final DragImageView.g gVar) {
        this.dtq.setOnSizeChangedListener(new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.8
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (gVar != null) {
                    gVar.a(dragImageView, z, z2);
                }
                UrlDragImageView.this.aMT();
            }
        });
    }

    protected void init() {
        this.dtG = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        this.mMaxWidth = l.getEquipmentWidth(this.mContext);
        this.mMaxHeight = l.getEquipmentHeight(this.mContext) - ((int) this.mContext.getResources().getDimension(R.dimen.ds166));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.dtq = new DragImageView(this.mContext);
        this.dtq.setLayoutParams(layoutParams);
        this.dtq.setOnTouchListener(this.dua);
        addView(this.dtq);
        this.dts = new SubsamplingScaleImageView(this.mContext);
        this.dts.setMaxScale(50.0f);
        this.dts.setOnTouchListener(this.dua);
        this.dts.setVisibility(4);
        addView(this.dts, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(getResources().getDrawable(R.drawable.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        aMS();
        this.dtX = TbSingleton.getInstance().isCutoutScreen(TbadkApplication.getInst().getCurrentActivity());
    }

    private void aMS() {
        this.dtV = new CircleProgressView(this.mContext);
        this.dtV.setCircleBackgroundColor(am.getColor(R.color.cp_cont_d));
        this.dtV.setCircleForegroundColor(am.getColor(R.color.cp_link_tip_a));
        this.dtV.setProgress(0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds80), l.getDimens(getContext(), R.dimen.tbds80));
        layoutParams.addRule(13);
        this.dtV.setVisibility(8);
        addView(this.dtV, layoutParams);
    }

    public void setIsCanDrag(boolean z) {
        this.drW = z;
    }

    public String getmCheckOriginPicText() {
        return this.dtU;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        Bitmap imageBitmap;
        int height;
        int width;
        if (this.dtM && !this.dtW && this.dts.getVisibility() == 0 && !this.dts.isImageLoaded()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.drW || !this.dtw) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.dty && motionEvent.getPointerCount() >= 2) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.dty || this.dtz) {
            requestDisallowInterceptTouchEvent(true);
        }
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        float x = motionEvent.getX();
        int i = action & 255;
        if (i == 0) {
            if (this.dtA == null) {
                if (this.dts.getVisibility() == 0) {
                    this.dtA = g.bi(this.dts);
                } else {
                    this.dtA = g.bi(this.dtq);
                }
            }
            if (this.mDisplayRect == null && this.dtA != null) {
                int measuredWidth = getMeasuredWidth();
                float measuredWidth2 = ((getMeasuredWidth() * 1.0f) / this.dtA.getWidth()) * this.dtA.getHeight();
                if (measuredWidth2 > getMeasuredHeight()) {
                    measuredWidth2 = getMeasuredHeight();
                }
                RectF rectInScreenFromPosition = getRectInScreenFromPosition(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
                this.mDisplayRect = new Rect((int) rectInScreenFromPosition.left, (int) rectInScreenFromPosition.top, (int) rectInScreenFromPosition.right, (int) rectInScreenFromPosition.bottom);
            }
            if (this.dtD == null && this.dtA != null) {
                if (this.dts.getVisibility() == 0) {
                    height = this.dts.getSHeight();
                    width = this.dts.getSWidth();
                } else {
                    if (this.dtq.getImageType() == 1) {
                        imageBitmap = (this.dtq.getCurrentFrame() == null || this.dtq.getCurrentFrame().bm == null) ? this.dtA : this.dtq.getCurrentFrame().bm;
                    } else {
                        imageBitmap = this.dtq.getImageBitmap() == null ? this.dtA : this.dtq.getImageBitmap();
                    }
                    height = imageBitmap.getHeight();
                    width = imageBitmap.getWidth();
                }
                float equipmentDensity = l.getEquipmentDensity(getContext());
                int i2 = (int) (height * equipmentDensity);
                int i3 = (int) (width * equipmentDensity);
                if (i3 > this.dtA.getWidth() && this.dtA.getWidth() != 0) {
                    float width2 = (i3 * 1.0f) / this.dtA.getWidth();
                    i3 = this.dtA.getWidth();
                    i2 = (int) (i2 / width2);
                }
                if (i2 > this.dtA.getHeight() && this.dtA.getHeight() != 0) {
                    i3 = (int) (i3 / ((i2 * 1.0f) / this.dtA.getHeight()));
                    i2 = this.dtA.getHeight();
                }
                int equipmentHeight = (l.getEquipmentHeight(getContext()) - i2) / 2;
                int equipmentWidth = (l.getEquipmentWidth(getContext()) - i3) / 2;
                this.dtD = new Rect(equipmentWidth, equipmentHeight, i3 + equipmentWidth, i2 + equipmentHeight);
                this.dtE = new Rect(this.dtD);
                this.dtL = equipmentHeight / l.getEquipmentHeight(getContext());
                this.dtC = new Rect(0, 0, this.dtA.getWidth(), this.dtA.getHeight());
            }
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (i == 2) {
            this.dty = s(this.mLastMotionX - x, this.mLastMotionY - y);
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (this.dty || this.dtz) {
            this.dtq.setImageOnLongClickListener(null);
            this.dts.setOnLongClickListener(null);
            z = true;
        } else {
            this.dtq.setImageOnLongClickListener(this.mLongClickListener);
            this.dts.setOnLongClickListener(this.mLongClickListener);
            z = super.dispatchTouchEvent(motionEvent);
        }
        if (i == 1 || i == 3) {
            this.mLastMotionX = 0.0f;
            this.mLastMotionY = 0.0f;
            boolean z2 = (-this.mMoveDistance) > ((float) EXIT_DISTANCE);
            boolean z3 = this.mMoveDistance > ((float) EXIT_DISTANCE);
            if (z2 || z3) {
                this.dtz = true;
                startExitAnimation();
                if (z2) {
                    TiebaStatic.log(new an("c13377").cy("obj_type", "3"));
                } else if (z3) {
                    TiebaStatic.log(new an("c13377").cy("obj_type", "2"));
                }
            } else {
                if (this.dty && this.dtF != null) {
                    this.dtF.aSD();
                }
                this.mRatio = 1.0f;
                invalidate();
            }
            this.isInDragScaleMode = false;
            this.mDragMatrix.reset();
            this.dty = false;
        }
        return z;
    }

    private boolean s(float f, float f2) {
        if (this.dts.getVisibility() != 0 || this.dts.isCanDrag()) {
            if (this.dqH == null || !this.dqH.isLongPic || this.dts.getVisibility() != 0 || this.dts.isViewTop()) {
                if (this.dqH == null || !this.dqH.isLongPic || this.dts.getVisibility() == 0 || this.dtq.isAtViewTop() || this.dtq.aSB()) {
                    if (this.dts.getVisibility() == 0 || this.dtq.pagerCantScroll()) {
                        if (this.dtA != null && getScrollY() == 0) {
                            boolean z = (this.dqH == null || !this.dqH.isLongPic) && ((f2 < -15.0f && !this.isInDragScaleMode) || (f2 > 15.0f && !this.isInDragScaleMode));
                            boolean z2 = this.dqH != null && this.dqH.isLongPic && f2 < 0.0f && !this.isInDragScaleMode;
                            if (z || (z2 && this.dtq.isViewTop())) {
                                this.dtq.setImageOnLongClickListener(null);
                                this.dts.setOnLongClickListener(null);
                                this.isInDragScaleMode = true;
                                this.mMoveDistance = 0.0f;
                                this.mRatio = 1.0f;
                                if (this.dtF != null) {
                                    this.dtF.onDragStart();
                                }
                            }
                        }
                        if (!this.isInDragScaleMode || this.dtA == null) {
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
                        this.mDragMatrix.preScale(1.0f + f3, 1.0f + f3, (this.mRatio * this.dtA.getWidth()) / 2.0f, this.mRatio * (this.dtA.getHeight() / 2));
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
        if (this.dty && this.dtA != null && !this.dtA.isRecycled() && this.isInDragScaleMode) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.mDstRect == null) {
                this.mDstRect = new RectF();
            }
            this.mDragMatrix.mapRect(this.mDstRect, new RectF(this.mDisplayRect));
            canvas.drawBitmap(this.dtA, this.dtC, this.mDstRect, (Paint) null);
        } else if (this.dtz && this.dtA != null && !this.dtA.isRecycled()) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.dqH == null || this.dqH.getSourceImageRectInScreen() == null) {
                canvas.drawBitmap(this.dtA, this.dtC, this.mDstRect, (Paint) null);
            } else {
                canvas.drawBitmap(this.dtA, this.dtD, this.mDstRect, (Paint) null);
            }
        } else {
            super.dispatchDraw(canvas);
        }
    }

    private void startExitAnimation() {
        if (this.dqH == null) {
            if (this.dtF != null) {
                this.dtF.onDragEnd();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.dqH.getSourceImageRectInScreen();
        final Rect dstRectInScreen = this.dqH.getDstRectInScreen();
        if (sourceImageRectInScreen == null || dstRectInScreen == null) {
            if (this.dtF != null) {
                this.dtF.onDragEnd();
                return;
            }
            return;
        }
        a(sourceImageRectInScreen, dstRectInScreen);
        b(sourceImageRectInScreen);
        this.dtB = new RectF(this.mDstRect);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(150L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && sourceImageRectInScreen != null && dstRectInScreen != null) {
                    UrlDragImageView.this.aq(valueAnimator.getAnimatedFraction());
                    UrlDragImageView.this.a(dstRectInScreen, valueAnimator.getAnimatedFraction(), UrlDragImageView.this.dtX);
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
                if (UrlDragImageView.this.dtF != null) {
                    UrlDragImageView.this.dtF.onDragEnd();
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
            this.mDstRect.top += this.mDstRect.height() * this.dtL;
            this.mDstRect.bottom = f + this.mDstRect.top;
        }
    }

    public void setCanScale(boolean z) {
        if (this.dtq != null) {
            this.dtq.setCanScale(z);
        }
    }

    private void a(Rect rect, Rect rect2) {
        this.dtH = 0.0f;
        this.dtI = 0.0f;
        this.dtJ = 1.0f;
        this.dtK = 1.0f;
        if (rect != null && rect2 != null && rect.contains(rect2)) {
            this.dtH = (rect2.left - rect.left) / rect.width();
            this.dtI = (rect2.top - rect.top) / rect.height();
            this.dtJ = (rect2.right - rect.left) / rect.width();
            this.dtK = (rect2.bottom - rect.top) / rect.height();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aq(float f) {
        if (this.dtD != null) {
            this.dtD.left = (int) (this.dtE.left + (this.dtE.width() * this.dtH * f));
            this.dtD.top = (int) (this.dtE.top + (this.dtE.height() * this.dtI * f));
            this.dtD.right = (int) (this.dtE.left + (this.dtE.width() * (((1.0f - this.dtJ) * (1.0f - f)) + this.dtJ)));
            this.dtD.bottom = (int) (this.dtE.top + (this.dtE.height() * (((1.0f - this.dtK) * (1.0f - f)) + this.dtK)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Rect rect, float f, boolean z) {
        int i = 0;
        if (z) {
            i = l.getDimens(getContext(), R.dimen.tbds80);
        }
        if (this.mDstRect != null && rect != null) {
            this.mDstRect.left = this.dtB.left + ((rect.left - this.dtB.left) * f);
            this.mDstRect.top = (this.dtB.top + ((rect.top - this.dtB.top) * f)) - i;
            this.mDstRect.right = this.dtB.right + ((rect.right - this.dtB.right) * f);
            this.mDstRect.bottom = this.dtB.bottom + ((rect.bottom - this.dtB.bottom) * f);
        }
    }

    private RectF getRectInScreenFromPosition(float f, float f2, float f3, float f4) {
        return new RectF(f - (f3 / 2.0f), f2 - (f4 / 2.0f), (f3 / 2.0f) + f, (f4 / 2.0f) + f2);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.dtR = onTouchListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMT() {
        if ((this.dtv || this.dtw) && this.dqH != null && this.dqH.mPicType == 1 && !TextUtils.isEmpty(this.dqH.mTagName)) {
            if (this.dtr != null) {
                this.dtr.setVisibility(8);
                this.dtr = null;
            }
            this.dtr = new TextView(this.mContext);
            this.dtr.setText(this.dqH.mTagName);
            this.dtr.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize26));
            am.setViewTextColor(this.dtr, R.color.common_color_10013, 1, 0);
            am.setBackgroundColor(this.dtr, R.color.common_color_10215);
            this.dtr.setAlpha(0.75f);
            this.dtr.setIncludeFontPadding(false);
            this.dtr.setGravity(17);
            int dimens = l.getDimens(this.mContext, R.dimen.ds2);
            this.dtr.setPadding(dimens, dimens, dimens, dimens);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.dtq.getBottomOffset();
            layoutParams.leftMargin = this.dtq.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.dtr, layoutParams);
            this.dtr.setVisibility(0);
        }
    }

    public void setUrl(String str, boolean z) {
        if (str.contains("*")) {
            str = str.split("[*]")[0];
        }
        this.dtq.setTag(str);
        this.dtq.setLoadBigImage(false);
        this.dtq.setImageDrawable(null);
        this.dtv = false;
        this.dtw = false;
        this.dtM = aNb();
        this.dtU = null;
        if (uF(str)) {
            e(str, z, false);
        }
    }

    private boolean aMU() {
        return this.dtq != null && this.dtq.isLoadBigImage();
    }

    public void aMV() {
        if (this.dqH != null && !aMU()) {
            String str = this.dqH.imageUrl;
            int i = this.dqH.urlType;
            com.baidu.adp.widget.ImageView.a aVar = null;
            if (com.baidu.tbadk.core.util.d.a.Z(str, i)) {
                aVar = com.baidu.tbadk.core.util.d.a.aa(str, i);
            }
            if (aVar != null) {
                setThumbBitmapToView(aVar);
            }
        }
    }

    private boolean gr(boolean z) {
        String nameMd5FromUrl;
        if (!this.dtN || z) {
            this.dtN = true;
            if (!this.dtM || this.dqH == null || StringUtils.isNull(this.dqH.originalUrl, true) || this.dqH.originalSize < 0 || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String str = this.dtG + ap.aGy().tw(nameMd5FromUrl) + "/" + as.getNameMd5FromUrl(this.dqH.originalUrl);
            final int[] imageFileWH = m.getImageFileWH(str);
            this.dts.setVisibility(0);
            if (this.dtt == null) {
                this.dtt = new SubsamplingScaleImageView.OnImageEventListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12
                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onReady() {
                        UrlDragImageView.this.dtU = null;
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.dtq.restoreSize();
                        UrlDragImageView.this.dtq.setVisibility(4);
                    }

                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onImageLoaded() {
                        if (UrlDragImageView.this.dqH.isLongPic && imageFileWH[0] > 0) {
                            UrlDragImageView.this.dtq.onDestroy();
                            final float measuredWidth = (UrlDragImageView.this.getMeasuredWidth() * 1.0f) / imageFileWH[0];
                            final PointF pointF = new PointF((imageFileWH[0] * 1.0f) / 2.0f, 0.0f);
                            UrlDragImageView.this.dts.setScaleAndCenter(measuredWidth, pointF);
                            UrlDragImageView.this.dts.setMaxScale(2.0f * measuredWidth);
                            UrlDragImageView.this.dts.setDoubleTapZoomScale(2.0f * measuredWidth);
                            UrlDragImageView.this.dts.setInitScale(measuredWidth);
                            UrlDragImageView.this.dts.setDoubleTapZoomStyle(4);
                            UrlDragImageView.this.dts.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12.1
                                @Override // android.view.View.OnTouchListener
                                public boolean onTouch(View view, MotionEvent motionEvent) {
                                    if (UrlDragImageView.this.dtR != null) {
                                        UrlDragImageView.this.dtR.onTouch(view, motionEvent);
                                    }
                                    switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                                        case 0:
                                            UrlDragImageView.this.dtT = motionEvent.getY();
                                            UrlDragImageView.this.dts.setOnClickListener(UrlDragImageView.this.dtS ? UrlDragImageView.this.mOnClickListener : null);
                                            UrlDragImageView.this.dts.setOnLongClickListener(UrlDragImageView.this.dtS ? UrlDragImageView.this.mLongClickListener : null);
                                            break;
                                        case 1:
                                        case 3:
                                            if (UrlDragImageView.this.dts.getScale() < measuredWidth) {
                                                UrlDragImageView.this.dts.setScaleAndCenter(measuredWidth, pointF);
                                            }
                                            e.gx().removeCallbacks(UrlDragImageView.this.dtY);
                                            e.gx().postDelayed(UrlDragImageView.this.dtY, 1000L);
                                            break;
                                        case 2:
                                            if (Math.abs(motionEvent.getY() - UrlDragImageView.this.dtT) > UrlDragImageView.TOUCH_SLOP) {
                                                UrlDragImageView.this.dtS = false;
                                                UrlDragImageView.this.dts.setOnClickListener(null);
                                                UrlDragImageView.this.dts.setOnLongClickListener(null);
                                            }
                                            UrlDragImageView.this.dtT = motionEvent.getY();
                                            break;
                                    }
                                    return false;
                                }
                            });
                            UrlDragImageView.this.dtq.setVisibility(4);
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
            this.dts.setOnImageEventListener(this.dtt);
            if (this.dts.isImageLoaded() && this.dqH.isLongPic) {
                this.dtt.onImageLoaded();
            } else {
                this.dts.setImage(ImageSource.uri(str));
            }
            return true;
        }
        return false;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.dtF = dVar;
        if (this.dtq != null) {
            this.dtq.setDragToExitListener(dVar);
        }
    }

    public void aMW() {
        gr(false);
    }

    private boolean uF(String str) {
        return j.isNetWorkAvailable() || com.baidu.tbadk.core.util.d.c.tH(str);
    }

    private void setThumbBitmapToView(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap rawBitmap;
        if (!this.dtw && aVar != null && (rawBitmap = aVar.getRawBitmap()) != null) {
            this.dtv = true;
            if (aVar.isGif()) {
                this.dtq.setImageUrlData(this.dqH);
                this.dtq.setImageBitmap(rawBitmap);
                this.dtU = null;
                this.dtP = false;
            } else {
                if (this.dqH != null && this.dqH.isLongPic) {
                    this.dtq.createLargeImageDelegate();
                    this.dtq.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.13
                        @Override // com.baidu.tbadk.widget.largeImage.logic.a
                        public void onLoadFinished() {
                        }
                    });
                }
                this.dtq.setImageUrlData(this.dqH);
                this.dtq.setImageData(rawBitmap, aVar.getByteData());
            }
            aMT();
        }
    }

    private void e(String str, boolean z, boolean z2) {
        if (uG(str)) {
            if (z2 || (!this.dtx && !this.dtw)) {
                if (!z2 || !gr(true)) {
                    this.dtx = true;
                    com.baidu.adp.lib.e.c.gr().a(str, 27, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.14
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.b
                        public void onCancelled(String str2) {
                            UrlDragImageView.this.dtx = false;
                            UrlDragImageView.this.dtq.setVisibility(0);
                            UrlDragImageView.this.mProgressBar.setVisibility(8);
                            UrlDragImageView.this.dtU = null;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            UrlDragImageView.this.dtx = false;
                            UrlDragImageView.this.dtw = true;
                            UrlDragImageView.this.b(aVar);
                        }
                    }, 0, 0, false, null, Boolean.valueOf(z), this.dtq.getImageData(), Boolean.valueOf(this.drU));
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
        imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.aJ(this.mMaxWidth, this.mMaxHeight));
        com.baidu.adp.widget.ImageView.a a2 = this.dtQ.a(imageFileInfo, false);
        if (a2 != null) {
            this.dtw = true;
            this.mProgressBar.setVisibility(8);
            this.dtU = null;
            b(a2);
            return;
        }
        this.dtQ.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.2
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.ImageView.a aVar, String str2, boolean z3) {
                UrlDragImageView.this.dtw = true;
                UrlDragImageView.this.mProgressBar.setVisibility(8);
                UrlDragImageView.this.dtU = null;
                UrlDragImageView.this.b(aVar);
            }
        }, false);
    }

    private boolean uG(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null && this.dtu != null) {
            this.dtu.k(aVar.getUrl(), aVar.getByteData());
        }
        if (aVar == null || aVar.getRawBitmap() == null) {
            aMX();
            return;
        }
        Bitmap rawBitmap = aVar.getRawBitmap();
        this.dtq.setLoadBigImage(true);
        if (aVar.isGif()) {
            this.dtq.setGifData(aVar.getByteData(), rawBitmap);
            this.dtq.invalidate();
            this.dtq.play();
            this.dtP = false;
            this.dtU = null;
            this.mProgressBar.setVisibility(8);
        } else {
            if (this.dqH != null && this.dqH.isLongPic) {
                this.dtq.createLargeImageDelegate();
                this.dtq.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.3
                    @Override // com.baidu.tbadk.widget.largeImage.logic.a
                    public void onLoadFinished() {
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.dtU = null;
                    }
                });
            } else {
                this.mProgressBar.setVisibility(8);
                this.dtU = null;
            }
            this.dtq.setImageUrlData(this.dqH);
            this.dtq.setImageData(rawBitmap, aVar.getByteData());
            aNc();
        }
        aMT();
    }

    private void aMX() {
        if (!this.dtv) {
            this.dtq.setDefaultBitmap();
        } else {
            this.dtw = false;
        }
        this.dtU = null;
        this.mProgressBar.setVisibility(8);
    }

    public void setGifMaxUseableMem(int i) {
        this.dtq.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.dtq != null) {
            this.dtq.onDestroy();
        }
        if (this.dts != null) {
            this.dts.recycle();
        }
        if (this.dtA != null) {
            this.dtA.recycle();
            this.dtA = null;
        }
        if (this.mProgressBar != null) {
            this.dtU = null;
            this.mProgressBar.setVisibility(8);
        }
        e.gx().removeCallbacks(this.dtY);
        com.baidu.tieba.view.c.cTs().setColor(-1);
    }

    public void release() {
        if (this.dtq != null) {
            this.dtq.release();
        }
        if (this.mProgressBar != null) {
            this.dtU = null;
            this.mProgressBar.setVisibility(8);
        }
        this.dtU = null;
    }

    public void aMY() {
        if (this.dtq != null && this.dtq.getImageType() == 1) {
            this.dtq.stop();
        }
    }

    public void x(boolean z, boolean z2) {
        String str;
        if (this.dtq != null && (str = (String) this.dtq.getTag()) != null) {
            if (this.dtq.getImageType() == 1) {
                if (this.dtq.getGifCache() == null || !this.dtq.isLoadBigImage()) {
                    e(str, z, z2);
                }
            } else if (this.dtq.getImageType() == 2) {
                e(str, z, z2);
            } else if (aMZ()) {
                e(str, z, z2);
            }
        }
    }

    private boolean aMZ() {
        if (this.dtq.getImageBitmap() != null && this.dtq.isLoadBigImage()) {
            if (this.dqH == null || !this.dqH.isLongPic || this.dtq.hasLoadLongImage()) {
                return false;
            }
            this.dtw = false;
            this.dtN = false;
            return true;
        }
        return true;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.dqH = imageUrlData;
    }

    public ImageUrlData getmAssistUrlData() {
        return this.dqH;
    }

    public void setIsCdn(boolean z) {
        this.drU = z;
    }

    public void aNa() {
        final String nameMd5FromUrl = as.getNameMd5FromUrl(this.dqH.originalUrl);
        if (this.dqH.originalProcess >= 0) {
            com.baidu.tbadk.download.d.aOn().cancelDownLoadById(nameMd5FromUrl, 13);
            this.dqH.originalProcess = -1;
            aNc();
            return;
        }
        if (this.drN != null) {
            this.drN.aNf();
        }
        com.baidu.adp.base.e<?> ab = i.ab(this.mContext);
        if (ab == null) {
            uH(nameMd5FromUrl);
        } else if (!j.isNetWorkAvailable() || j.isWifiNet() || com.baidu.tbadk.core.sharedPref.b.aFB().getBoolean(SharedPrefConfig.ORIGINAL_IMG_DOWN_TIP, false)) {
            uH(nameMd5FromUrl);
        } else {
            com.baidu.tbadk.core.sharedPref.b.aFB().putBoolean(SharedPrefConfig.ORIGINAL_IMG_DOWN_TIP, true);
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(ab.getPageActivity());
            aVar.jW(R.string.original_img_down_no_wifi_tip);
            aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    UrlDragImageView.this.uH(nameMd5FromUrl);
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                }
            });
            aVar.b(ab);
            aVar.aEA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uH(String str) {
        if (this.dqH != null) {
            this.dqH.originalProcess = 0;
            this.dtV.setProgress(0);
            this.dtV.setVisibility(0);
            DownloadData downloadData = new DownloadData(str);
            downloadData.setStatus(1);
            downloadData.setUrl(this.dqH.originalUrl);
            downloadData.setType(13);
            downloadData.setPath(this.dtG + ap.aGy().tw(str) + "/" + str);
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.6
                @Override // com.baidu.tbadk.download.c
                public boolean onPreDownload(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2 != null) {
                        if (UrlDragImageView.this.dqH != null && UrlDragImageView.this.dqH.originalProcess != -1) {
                            UrlDragImageView.this.dqH.originalProcess = downloadData2.getProcess();
                        }
                        if (UrlDragImageView.this.dqH == null || UrlDragImageView.this.dqH.originalProcess != -1) {
                            UrlDragImageView.this.dtV.setProgress(downloadData2.getProcess());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public boolean onFileDownloaded(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadSucceed(DownloadData downloadData2) {
                    UrlDragImageView.this.dtV.setVisibility(8);
                    e.gx().postDelayed(UrlDragImageView.this.dtZ, 1500L);
                    UrlDragImageView.this.dtN = false;
                    UrlDragImageView.this.dtM = UrlDragImageView.this.aNb();
                    UrlDragImageView.this.aMW();
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str2) {
                    UrlDragImageView.this.dtV.setVisibility(8);
                    UrlDragImageView.this.dtN = false;
                    BdToast.b(UrlDragImageView.this.mContext, str2).aEE().aEF();
                    UrlDragImageView.this.dqH.originalProcess = -1;
                    UrlDragImageView.this.aNc();
                }
            });
            com.baidu.tbadk.download.d.aOn().a(downloadData, 100);
            this.dtW = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aNb() {
        if (this.dqH != null && !StringUtils.isNull(this.dqH.originalUrl, true) && this.dqH.originalSize >= 0 && !this.dqH.isBlockedPic) {
            String nameMd5FromUrl = as.getNameMd5FromUrl(this.dqH.originalUrl);
            File file = new File(this.dtG + ap.aGy().tw(nameMd5FromUrl) + "/" + nameMd5FromUrl);
            if (file != null && file.exists()) {
                this.dqH.originalProcess = 100;
                return true;
            }
            if (this.dqH.originalProcess < 0) {
                aNc();
            } else {
                this.dtV.setProgress(this.dqH.originalProcess);
            }
            this.dtP = true;
        } else {
            this.dtU = null;
        }
        return false;
    }

    public void aNc() {
        if (this.dqH != null) {
            if (!aNd() || !this.dtP) {
                this.dtU = null;
            } else if (this.dqH.originalSize > 0 && !bH(this.dqH.originalSize)) {
                this.dtU = dto + "(" + aq.getFormatSize(this.dqH.originalSize) + ")";
            } else {
                this.dtU = dto;
            }
        }
    }

    private boolean aNd() {
        return (this.dqH == null || !this.dqH.mIsShowOrigonButton || this.dqH.isBlockedPic || StringUtils.isNull(this.dqH.originalUrl)) ? false : true;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.drN = bVar;
    }

    private boolean bH(long j) {
        return j > dtp;
    }
}
