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
    private ImageUrlData dqI;
    private b drO;
    private boolean drV;
    private boolean drX;
    private boolean dtA;
    private Bitmap dtB;
    private RectF dtC;
    private Rect dtD;
    private Rect dtE;
    private Rect dtF;
    private DragImageView.d dtG;
    private String dtH;
    private float dtI;
    private float dtJ;
    private float dtK;
    private float dtL;
    private float dtM;
    private boolean dtN;
    private boolean dtO;
    private boolean dtP;
    public boolean dtQ;
    private com.baidu.tbadk.img.b dtR;
    private View.OnTouchListener dtS;
    private boolean dtT;
    private float dtU;
    private String dtV;
    private CircleProgressView dtW;
    private boolean dtX;
    private boolean dtY;
    private Runnable dtZ;
    protected DragImageView dtr;
    protected TextView dts;
    protected SubsamplingScaleImageView dtt;
    private SubsamplingScaleImageView.OnImageEventListener dtu;
    private a dtv;
    private boolean dtw;
    private boolean dtx;
    private boolean dty;
    private boolean dtz;
    private Runnable dua;
    private View.OnTouchListener dub;
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
    private static final String dtp = TbadkCoreApplication.getInst().getString(R.string.original_img_look);
    private static long dtq = Config.RAVEN_LOG_LIMIT;
    private static final int EXIT_DISTANCE = l.getEquipmentHeight(TbadkCoreApplication.getInst()) / 5;
    private static final String TAG = UrlDragImageView.class.getSimpleName();
    private static final int TOUCH_SLOP = ViewConfiguration.get(TbadkCoreApplication.getInst()).getScaledTouchSlop();

    /* loaded from: classes8.dex */
    public interface a {
        void k(String str, byte[] bArr);
    }

    /* loaded from: classes8.dex */
    public interface b {
        void aNh();
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
        if (this.dtr != null) {
            this.dtr.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.dtv = aVar;
    }

    public UrlDragImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.dtr = null;
        this.dtv = null;
        this.drV = false;
        this.dty = false;
        this.isInDragScaleMode = false;
        this.mRatio = 1.0f;
        this.mMoveDistance = 0.0f;
        this.mDragMatrix = new Matrix();
        this.mDstRect = new RectF();
        this.dtI = 0.0f;
        this.dtJ = 0.0f;
        this.dtK = 1.0f;
        this.dtL = 1.0f;
        this.dtM = 0.0f;
        this.dtN = false;
        this.dtO = false;
        this.dtP = false;
        this.dtQ = false;
        this.dtT = true;
        this.dtU = 0.0f;
        this.mOnClickListener = null;
        this.mLongClickListener = null;
        this.dtV = null;
        this.dtZ = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.dtT = true;
            }
        };
        this.dua = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.dtW.setVisibility(8);
                        UrlDragImageView.this.dtV = null;
                        UrlDragImageView.this.dtQ = false;
                    }
                });
            }
        };
        this.dub = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.dtS != null) {
                    UrlDragImageView.this.dtS.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.dtR = new com.baidu.tbadk.img.b();
        init();
    }

    public UrlDragImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.dtr = null;
        this.dtv = null;
        this.drV = false;
        this.dty = false;
        this.isInDragScaleMode = false;
        this.mRatio = 1.0f;
        this.mMoveDistance = 0.0f;
        this.mDragMatrix = new Matrix();
        this.mDstRect = new RectF();
        this.dtI = 0.0f;
        this.dtJ = 0.0f;
        this.dtK = 1.0f;
        this.dtL = 1.0f;
        this.dtM = 0.0f;
        this.dtN = false;
        this.dtO = false;
        this.dtP = false;
        this.dtQ = false;
        this.dtT = true;
        this.dtU = 0.0f;
        this.mOnClickListener = null;
        this.mLongClickListener = null;
        this.dtV = null;
        this.dtZ = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.dtT = true;
            }
        };
        this.dua = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.dtW.setVisibility(8);
                        UrlDragImageView.this.dtV = null;
                        UrlDragImageView.this.dtQ = false;
                    }
                });
            }
        };
        this.dub = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.dtS != null) {
                    UrlDragImageView.this.dtS.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.dtR = new com.baidu.tbadk.img.b();
        init();
    }

    public DragImageView getImageView() {
        return this.dtr;
    }

    public void setGifSetListener(DragImageView.e eVar) {
        this.dtr.setGifSetListener(eVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.dtr.setImageOnClickListener(onClickListener);
        this.dtt.setOnClickListener(onClickListener);
        this.mOnClickListener = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mLongClickListener = onLongClickListener;
        if (!this.drX) {
            this.dtr.setImageOnLongClickListener(this.mLongClickListener);
            this.dtt.setOnLongClickListener(this.mLongClickListener);
        }
    }

    public void setOnSizeChangedListener(final DragImageView.g gVar) {
        this.dtr.setOnSizeChangedListener(new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.8
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (gVar != null) {
                    gVar.a(dragImageView, z, z2);
                }
                UrlDragImageView.this.aMV();
            }
        });
    }

    protected void init() {
        this.dtH = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        this.mMaxWidth = l.getEquipmentWidth(this.mContext);
        this.mMaxHeight = l.getEquipmentHeight(this.mContext) - ((int) this.mContext.getResources().getDimension(R.dimen.ds166));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.dtr = new DragImageView(this.mContext);
        this.dtr.setLayoutParams(layoutParams);
        this.dtr.setOnTouchListener(this.dub);
        addView(this.dtr);
        this.dtt = new SubsamplingScaleImageView(this.mContext);
        this.dtt.setMaxScale(50.0f);
        this.dtt.setOnTouchListener(this.dub);
        this.dtt.setVisibility(4);
        addView(this.dtt, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(getResources().getDrawable(R.drawable.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        aMU();
        this.dtY = TbSingleton.getInstance().isCutoutScreen(TbadkApplication.getInst().getCurrentActivity());
    }

    private void aMU() {
        this.dtW = new CircleProgressView(this.mContext);
        this.dtW.setCircleBackgroundColor(am.getColor(R.color.cp_cont_d));
        this.dtW.setCircleForegroundColor(am.getColor(R.color.cp_link_tip_a));
        this.dtW.setProgress(0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds80), l.getDimens(getContext(), R.dimen.tbds80));
        layoutParams.addRule(13);
        this.dtW.setVisibility(8);
        addView(this.dtW, layoutParams);
    }

    public void setIsCanDrag(boolean z) {
        this.drX = z;
    }

    public String getmCheckOriginPicText() {
        return this.dtV;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        Bitmap imageBitmap;
        int height;
        int width;
        if (this.dtN && !this.dtX && this.dtt.getVisibility() == 0 && !this.dtt.isImageLoaded()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.drX || !this.dtx) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.dtz && motionEvent.getPointerCount() >= 2) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.dtz || this.dtA) {
            requestDisallowInterceptTouchEvent(true);
        }
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        float x = motionEvent.getX();
        int i = action & 255;
        if (i == 0) {
            if (this.dtB == null) {
                if (this.dtt.getVisibility() == 0) {
                    this.dtB = g.bi(this.dtt);
                } else {
                    this.dtB = g.bi(this.dtr);
                }
            }
            if (this.mDisplayRect == null && this.dtB != null) {
                int measuredWidth = getMeasuredWidth();
                float measuredWidth2 = ((getMeasuredWidth() * 1.0f) / this.dtB.getWidth()) * this.dtB.getHeight();
                if (measuredWidth2 > getMeasuredHeight()) {
                    measuredWidth2 = getMeasuredHeight();
                }
                RectF rectInScreenFromPosition = getRectInScreenFromPosition(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
                this.mDisplayRect = new Rect((int) rectInScreenFromPosition.left, (int) rectInScreenFromPosition.top, (int) rectInScreenFromPosition.right, (int) rectInScreenFromPosition.bottom);
            }
            if (this.dtE == null && this.dtB != null) {
                if (this.dtt.getVisibility() == 0) {
                    height = this.dtt.getSHeight();
                    width = this.dtt.getSWidth();
                } else {
                    if (this.dtr.getImageType() == 1) {
                        imageBitmap = (this.dtr.getCurrentFrame() == null || this.dtr.getCurrentFrame().bm == null) ? this.dtB : this.dtr.getCurrentFrame().bm;
                    } else {
                        imageBitmap = this.dtr.getImageBitmap() == null ? this.dtB : this.dtr.getImageBitmap();
                    }
                    height = imageBitmap.getHeight();
                    width = imageBitmap.getWidth();
                }
                float equipmentDensity = l.getEquipmentDensity(getContext());
                int i2 = (int) (height * equipmentDensity);
                int i3 = (int) (width * equipmentDensity);
                if (i3 > this.dtB.getWidth() && this.dtB.getWidth() != 0) {
                    float width2 = (i3 * 1.0f) / this.dtB.getWidth();
                    i3 = this.dtB.getWidth();
                    i2 = (int) (i2 / width2);
                }
                if (i2 > this.dtB.getHeight() && this.dtB.getHeight() != 0) {
                    i3 = (int) (i3 / ((i2 * 1.0f) / this.dtB.getHeight()));
                    i2 = this.dtB.getHeight();
                }
                int equipmentHeight = (l.getEquipmentHeight(getContext()) - i2) / 2;
                int equipmentWidth = (l.getEquipmentWidth(getContext()) - i3) / 2;
                this.dtE = new Rect(equipmentWidth, equipmentHeight, i3 + equipmentWidth, i2 + equipmentHeight);
                this.dtF = new Rect(this.dtE);
                this.dtM = equipmentHeight / l.getEquipmentHeight(getContext());
                this.dtD = new Rect(0, 0, this.dtB.getWidth(), this.dtB.getHeight());
            }
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (i == 2) {
            this.dtz = s(this.mLastMotionX - x, this.mLastMotionY - y);
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (this.dtz || this.dtA) {
            this.dtr.setImageOnLongClickListener(null);
            this.dtt.setOnLongClickListener(null);
            z = true;
        } else {
            this.dtr.setImageOnLongClickListener(this.mLongClickListener);
            this.dtt.setOnLongClickListener(this.mLongClickListener);
            z = super.dispatchTouchEvent(motionEvent);
        }
        if (i == 1 || i == 3) {
            this.mLastMotionX = 0.0f;
            this.mLastMotionY = 0.0f;
            boolean z2 = (-this.mMoveDistance) > ((float) EXIT_DISTANCE);
            boolean z3 = this.mMoveDistance > ((float) EXIT_DISTANCE);
            if (z2 || z3) {
                this.dtA = true;
                startExitAnimation();
                if (z2) {
                    TiebaStatic.log(new an("c13377").cy("obj_type", "3"));
                } else if (z3) {
                    TiebaStatic.log(new an("c13377").cy("obj_type", "2"));
                }
            } else {
                if (this.dtz && this.dtG != null) {
                    this.dtG.aSF();
                }
                this.mRatio = 1.0f;
                invalidate();
            }
            this.isInDragScaleMode = false;
            this.mDragMatrix.reset();
            this.dtz = false;
        }
        return z;
    }

    private boolean s(float f, float f2) {
        if (this.dtt.getVisibility() != 0 || this.dtt.isCanDrag()) {
            if (this.dqI == null || !this.dqI.isLongPic || this.dtt.getVisibility() != 0 || this.dtt.isViewTop()) {
                if (this.dqI == null || !this.dqI.isLongPic || this.dtt.getVisibility() == 0 || this.dtr.isAtViewTop() || this.dtr.aSD()) {
                    if (this.dtt.getVisibility() == 0 || this.dtr.pagerCantScroll()) {
                        if (this.dtB != null && getScrollY() == 0) {
                            boolean z = (this.dqI == null || !this.dqI.isLongPic) && ((f2 < -15.0f && !this.isInDragScaleMode) || (f2 > 15.0f && !this.isInDragScaleMode));
                            boolean z2 = this.dqI != null && this.dqI.isLongPic && f2 < 0.0f && !this.isInDragScaleMode;
                            if (z || (z2 && this.dtr.isViewTop())) {
                                this.dtr.setImageOnLongClickListener(null);
                                this.dtt.setOnLongClickListener(null);
                                this.isInDragScaleMode = true;
                                this.mMoveDistance = 0.0f;
                                this.mRatio = 1.0f;
                                if (this.dtG != null) {
                                    this.dtG.onDragStart();
                                }
                            }
                        }
                        if (!this.isInDragScaleMode || this.dtB == null) {
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
                        this.mDragMatrix.preScale(1.0f + f3, 1.0f + f3, (this.mRatio * this.dtB.getWidth()) / 2.0f, this.mRatio * (this.dtB.getHeight() / 2));
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
        if (this.dtz && this.dtB != null && !this.dtB.isRecycled() && this.isInDragScaleMode) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.mDstRect == null) {
                this.mDstRect = new RectF();
            }
            this.mDragMatrix.mapRect(this.mDstRect, new RectF(this.mDisplayRect));
            canvas.drawBitmap(this.dtB, this.dtD, this.mDstRect, (Paint) null);
        } else if (this.dtA && this.dtB != null && !this.dtB.isRecycled()) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.dqI == null || this.dqI.getSourceImageRectInScreen() == null) {
                canvas.drawBitmap(this.dtB, this.dtD, this.mDstRect, (Paint) null);
            } else {
                canvas.drawBitmap(this.dtB, this.dtE, this.mDstRect, (Paint) null);
            }
        } else {
            super.dispatchDraw(canvas);
        }
    }

    private void startExitAnimation() {
        if (this.dqI == null) {
            if (this.dtG != null) {
                this.dtG.onDragEnd();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.dqI.getSourceImageRectInScreen();
        final Rect dstRectInScreen = this.dqI.getDstRectInScreen();
        if (sourceImageRectInScreen == null || dstRectInScreen == null) {
            if (this.dtG != null) {
                this.dtG.onDragEnd();
                return;
            }
            return;
        }
        a(sourceImageRectInScreen, dstRectInScreen);
        b(sourceImageRectInScreen);
        this.dtC = new RectF(this.mDstRect);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(150L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && sourceImageRectInScreen != null && dstRectInScreen != null) {
                    UrlDragImageView.this.aq(valueAnimator.getAnimatedFraction());
                    UrlDragImageView.this.a(dstRectInScreen, valueAnimator.getAnimatedFraction(), UrlDragImageView.this.dtY);
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
                if (UrlDragImageView.this.dtG != null) {
                    UrlDragImageView.this.dtG.onDragEnd();
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
            this.mDstRect.top += this.mDstRect.height() * this.dtM;
            this.mDstRect.bottom = f + this.mDstRect.top;
        }
    }

    public void setCanScale(boolean z) {
        if (this.dtr != null) {
            this.dtr.setCanScale(z);
        }
    }

    private void a(Rect rect, Rect rect2) {
        this.dtI = 0.0f;
        this.dtJ = 0.0f;
        this.dtK = 1.0f;
        this.dtL = 1.0f;
        if (rect != null && rect2 != null && rect.contains(rect2)) {
            this.dtI = (rect2.left - rect.left) / rect.width();
            this.dtJ = (rect2.top - rect.top) / rect.height();
            this.dtK = (rect2.right - rect.left) / rect.width();
            this.dtL = (rect2.bottom - rect.top) / rect.height();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aq(float f) {
        if (this.dtE != null) {
            this.dtE.left = (int) (this.dtF.left + (this.dtF.width() * this.dtI * f));
            this.dtE.top = (int) (this.dtF.top + (this.dtF.height() * this.dtJ * f));
            this.dtE.right = (int) (this.dtF.left + (this.dtF.width() * (((1.0f - this.dtK) * (1.0f - f)) + this.dtK)));
            this.dtE.bottom = (int) (this.dtF.top + (this.dtF.height() * (((1.0f - this.dtL) * (1.0f - f)) + this.dtL)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Rect rect, float f, boolean z) {
        int i = 0;
        if (z) {
            i = l.getDimens(getContext(), R.dimen.tbds80);
        }
        if (this.mDstRect != null && rect != null) {
            this.mDstRect.left = this.dtC.left + ((rect.left - this.dtC.left) * f);
            this.mDstRect.top = (this.dtC.top + ((rect.top - this.dtC.top) * f)) - i;
            this.mDstRect.right = this.dtC.right + ((rect.right - this.dtC.right) * f);
            this.mDstRect.bottom = this.dtC.bottom + ((rect.bottom - this.dtC.bottom) * f);
        }
    }

    private RectF getRectInScreenFromPosition(float f, float f2, float f3, float f4) {
        return new RectF(f - (f3 / 2.0f), f2 - (f4 / 2.0f), (f3 / 2.0f) + f, (f4 / 2.0f) + f2);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.dtS = onTouchListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMV() {
        if ((this.dtw || this.dtx) && this.dqI != null && this.dqI.mPicType == 1 && !TextUtils.isEmpty(this.dqI.mTagName)) {
            if (this.dts != null) {
                this.dts.setVisibility(8);
                this.dts = null;
            }
            this.dts = new TextView(this.mContext);
            this.dts.setText(this.dqI.mTagName);
            this.dts.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize26));
            am.setViewTextColor(this.dts, R.color.common_color_10013, 1, 0);
            am.setBackgroundColor(this.dts, R.color.common_color_10215);
            this.dts.setAlpha(0.75f);
            this.dts.setIncludeFontPadding(false);
            this.dts.setGravity(17);
            int dimens = l.getDimens(this.mContext, R.dimen.ds2);
            this.dts.setPadding(dimens, dimens, dimens, dimens);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.dtr.getBottomOffset();
            layoutParams.leftMargin = this.dtr.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.dts, layoutParams);
            this.dts.setVisibility(0);
        }
    }

    public void setUrl(String str, boolean z) {
        if (str.contains("*")) {
            str = str.split("[*]")[0];
        }
        this.dtr.setTag(str);
        this.dtr.setLoadBigImage(false);
        this.dtr.setImageDrawable(null);
        this.dtw = false;
        this.dtx = false;
        this.dtN = aNd();
        this.dtV = null;
        if (uF(str)) {
            e(str, z, false);
        }
    }

    private boolean aMW() {
        return this.dtr != null && this.dtr.isLoadBigImage();
    }

    public void aMX() {
        if (this.dqI != null && !aMW()) {
            String str = this.dqI.imageUrl;
            int i = this.dqI.urlType;
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
        if (!this.dtO || z) {
            this.dtO = true;
            if (!this.dtN || this.dqI == null || StringUtils.isNull(this.dqI.originalUrl, true) || this.dqI.originalSize < 0 || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String str = this.dtH + ap.aGA().tw(nameMd5FromUrl) + "/" + as.getNameMd5FromUrl(this.dqI.originalUrl);
            final int[] imageFileWH = m.getImageFileWH(str);
            this.dtt.setVisibility(0);
            if (this.dtu == null) {
                this.dtu = new SubsamplingScaleImageView.OnImageEventListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12
                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onReady() {
                        UrlDragImageView.this.dtV = null;
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.dtr.restoreSize();
                        UrlDragImageView.this.dtr.setVisibility(4);
                    }

                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onImageLoaded() {
                        if (UrlDragImageView.this.dqI.isLongPic && imageFileWH[0] > 0) {
                            UrlDragImageView.this.dtr.onDestroy();
                            final float measuredWidth = (UrlDragImageView.this.getMeasuredWidth() * 1.0f) / imageFileWH[0];
                            final PointF pointF = new PointF((imageFileWH[0] * 1.0f) / 2.0f, 0.0f);
                            UrlDragImageView.this.dtt.setScaleAndCenter(measuredWidth, pointF);
                            UrlDragImageView.this.dtt.setMaxScale(2.0f * measuredWidth);
                            UrlDragImageView.this.dtt.setDoubleTapZoomScale(2.0f * measuredWidth);
                            UrlDragImageView.this.dtt.setInitScale(measuredWidth);
                            UrlDragImageView.this.dtt.setDoubleTapZoomStyle(4);
                            UrlDragImageView.this.dtt.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12.1
                                @Override // android.view.View.OnTouchListener
                                public boolean onTouch(View view, MotionEvent motionEvent) {
                                    if (UrlDragImageView.this.dtS != null) {
                                        UrlDragImageView.this.dtS.onTouch(view, motionEvent);
                                    }
                                    switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                                        case 0:
                                            UrlDragImageView.this.dtU = motionEvent.getY();
                                            UrlDragImageView.this.dtt.setOnClickListener(UrlDragImageView.this.dtT ? UrlDragImageView.this.mOnClickListener : null);
                                            UrlDragImageView.this.dtt.setOnLongClickListener(UrlDragImageView.this.dtT ? UrlDragImageView.this.mLongClickListener : null);
                                            break;
                                        case 1:
                                        case 3:
                                            if (UrlDragImageView.this.dtt.getScale() < measuredWidth) {
                                                UrlDragImageView.this.dtt.setScaleAndCenter(measuredWidth, pointF);
                                            }
                                            e.gx().removeCallbacks(UrlDragImageView.this.dtZ);
                                            e.gx().postDelayed(UrlDragImageView.this.dtZ, 1000L);
                                            break;
                                        case 2:
                                            if (Math.abs(motionEvent.getY() - UrlDragImageView.this.dtU) > UrlDragImageView.TOUCH_SLOP) {
                                                UrlDragImageView.this.dtT = false;
                                                UrlDragImageView.this.dtt.setOnClickListener(null);
                                                UrlDragImageView.this.dtt.setOnLongClickListener(null);
                                            }
                                            UrlDragImageView.this.dtU = motionEvent.getY();
                                            break;
                                    }
                                    return false;
                                }
                            });
                            UrlDragImageView.this.dtr.setVisibility(4);
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
            this.dtt.setOnImageEventListener(this.dtu);
            if (this.dtt.isImageLoaded() && this.dqI.isLongPic) {
                this.dtu.onImageLoaded();
            } else {
                this.dtt.setImage(ImageSource.uri(str));
            }
            return true;
        }
        return false;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.dtG = dVar;
        if (this.dtr != null) {
            this.dtr.setDragToExitListener(dVar);
        }
    }

    public void aMY() {
        gr(false);
    }

    private boolean uF(String str) {
        return j.isNetWorkAvailable() || com.baidu.tbadk.core.util.d.c.tH(str);
    }

    private void setThumbBitmapToView(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap rawBitmap;
        if (!this.dtx && aVar != null && (rawBitmap = aVar.getRawBitmap()) != null) {
            this.dtw = true;
            if (aVar.isGif()) {
                this.dtr.setImageUrlData(this.dqI);
                this.dtr.setImageBitmap(rawBitmap);
                this.dtV = null;
                this.dtQ = false;
            } else {
                if (this.dqI != null && this.dqI.isLongPic) {
                    this.dtr.createLargeImageDelegate();
                    this.dtr.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.13
                        @Override // com.baidu.tbadk.widget.largeImage.logic.a
                        public void onLoadFinished() {
                        }
                    });
                }
                this.dtr.setImageUrlData(this.dqI);
                this.dtr.setImageData(rawBitmap, aVar.getByteData());
            }
            aMV();
        }
    }

    private void e(String str, boolean z, boolean z2) {
        if (uG(str)) {
            if (z2 || (!this.dty && !this.dtx)) {
                if (!z2 || !gr(true)) {
                    this.dty = true;
                    com.baidu.adp.lib.e.c.gr().a(str, 27, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.14
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.b
                        public void onCancelled(String str2) {
                            UrlDragImageView.this.dty = false;
                            UrlDragImageView.this.dtr.setVisibility(0);
                            UrlDragImageView.this.mProgressBar.setVisibility(8);
                            UrlDragImageView.this.dtV = null;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            UrlDragImageView.this.dty = false;
                            UrlDragImageView.this.dtx = true;
                            UrlDragImageView.this.b(aVar);
                        }
                    }, 0, 0, false, null, Boolean.valueOf(z), this.dtr.getImageData(), Boolean.valueOf(this.drV));
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
        com.baidu.adp.widget.ImageView.a a2 = this.dtR.a(imageFileInfo, false);
        if (a2 != null) {
            this.dtx = true;
            this.mProgressBar.setVisibility(8);
            this.dtV = null;
            b(a2);
            return;
        }
        this.dtR.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.2
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.ImageView.a aVar, String str2, boolean z3) {
                UrlDragImageView.this.dtx = true;
                UrlDragImageView.this.mProgressBar.setVisibility(8);
                UrlDragImageView.this.dtV = null;
                UrlDragImageView.this.b(aVar);
            }
        }, false);
    }

    private boolean uG(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null && this.dtv != null) {
            this.dtv.k(aVar.getUrl(), aVar.getByteData());
        }
        if (aVar == null || aVar.getRawBitmap() == null) {
            aMZ();
            return;
        }
        Bitmap rawBitmap = aVar.getRawBitmap();
        this.dtr.setLoadBigImage(true);
        if (aVar.isGif()) {
            this.dtr.setGifData(aVar.getByteData(), rawBitmap);
            this.dtr.invalidate();
            this.dtr.play();
            this.dtQ = false;
            this.dtV = null;
            this.mProgressBar.setVisibility(8);
        } else {
            if (this.dqI != null && this.dqI.isLongPic) {
                this.dtr.createLargeImageDelegate();
                this.dtr.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.3
                    @Override // com.baidu.tbadk.widget.largeImage.logic.a
                    public void onLoadFinished() {
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.dtV = null;
                    }
                });
            } else {
                this.mProgressBar.setVisibility(8);
                this.dtV = null;
            }
            this.dtr.setImageUrlData(this.dqI);
            this.dtr.setImageData(rawBitmap, aVar.getByteData());
            aNe();
        }
        aMV();
    }

    private void aMZ() {
        if (!this.dtw) {
            this.dtr.setDefaultBitmap();
        } else {
            this.dtx = false;
        }
        this.dtV = null;
        this.mProgressBar.setVisibility(8);
    }

    public void setGifMaxUseableMem(int i) {
        this.dtr.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.dtr != null) {
            this.dtr.onDestroy();
        }
        if (this.dtt != null) {
            this.dtt.recycle();
        }
        if (this.dtB != null) {
            this.dtB.recycle();
            this.dtB = null;
        }
        if (this.mProgressBar != null) {
            this.dtV = null;
            this.mProgressBar.setVisibility(8);
        }
        e.gx().removeCallbacks(this.dtZ);
        com.baidu.tieba.view.c.cTu().setColor(-1);
    }

    public void release() {
        if (this.dtr != null) {
            this.dtr.release();
        }
        if (this.mProgressBar != null) {
            this.dtV = null;
            this.mProgressBar.setVisibility(8);
        }
        this.dtV = null;
    }

    public void aNa() {
        if (this.dtr != null && this.dtr.getImageType() == 1) {
            this.dtr.stop();
        }
    }

    public void x(boolean z, boolean z2) {
        String str;
        if (this.dtr != null && (str = (String) this.dtr.getTag()) != null) {
            if (this.dtr.getImageType() == 1) {
                if (this.dtr.getGifCache() == null || !this.dtr.isLoadBigImage()) {
                    e(str, z, z2);
                }
            } else if (this.dtr.getImageType() == 2) {
                e(str, z, z2);
            } else if (aNb()) {
                e(str, z, z2);
            }
        }
    }

    private boolean aNb() {
        if (this.dtr.getImageBitmap() != null && this.dtr.isLoadBigImage()) {
            if (this.dqI == null || !this.dqI.isLongPic || this.dtr.hasLoadLongImage()) {
                return false;
            }
            this.dtx = false;
            this.dtO = false;
            return true;
        }
        return true;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.dqI = imageUrlData;
    }

    public ImageUrlData getmAssistUrlData() {
        return this.dqI;
    }

    public void setIsCdn(boolean z) {
        this.drV = z;
    }

    public void aNc() {
        final String nameMd5FromUrl = as.getNameMd5FromUrl(this.dqI.originalUrl);
        if (this.dqI.originalProcess >= 0) {
            com.baidu.tbadk.download.d.aOp().cancelDownLoadById(nameMd5FromUrl, 13);
            this.dqI.originalProcess = -1;
            aNe();
            return;
        }
        if (this.drO != null) {
            this.drO.aNh();
        }
        com.baidu.adp.base.e<?> ab = i.ab(this.mContext);
        if (ab == null) {
            uH(nameMd5FromUrl);
        } else if (!j.isNetWorkAvailable() || j.isWifiNet() || com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean(SharedPrefConfig.ORIGINAL_IMG_DOWN_TIP, false)) {
            uH(nameMd5FromUrl);
        } else {
            com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean(SharedPrefConfig.ORIGINAL_IMG_DOWN_TIP, true);
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
            aVar.aEC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uH(String str) {
        if (this.dqI != null) {
            this.dqI.originalProcess = 0;
            this.dtW.setProgress(0);
            this.dtW.setVisibility(0);
            DownloadData downloadData = new DownloadData(str);
            downloadData.setStatus(1);
            downloadData.setUrl(this.dqI.originalUrl);
            downloadData.setType(13);
            downloadData.setPath(this.dtH + ap.aGA().tw(str) + "/" + str);
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.6
                @Override // com.baidu.tbadk.download.c
                public boolean onPreDownload(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2 != null) {
                        if (UrlDragImageView.this.dqI != null && UrlDragImageView.this.dqI.originalProcess != -1) {
                            UrlDragImageView.this.dqI.originalProcess = downloadData2.getProcess();
                        }
                        if (UrlDragImageView.this.dqI == null || UrlDragImageView.this.dqI.originalProcess != -1) {
                            UrlDragImageView.this.dtW.setProgress(downloadData2.getProcess());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public boolean onFileDownloaded(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadSucceed(DownloadData downloadData2) {
                    UrlDragImageView.this.dtW.setVisibility(8);
                    e.gx().postDelayed(UrlDragImageView.this.dua, 1500L);
                    UrlDragImageView.this.dtO = false;
                    UrlDragImageView.this.dtN = UrlDragImageView.this.aNd();
                    UrlDragImageView.this.aMY();
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str2) {
                    UrlDragImageView.this.dtW.setVisibility(8);
                    UrlDragImageView.this.dtO = false;
                    BdToast.b(UrlDragImageView.this.mContext, str2).aEG().aEH();
                    UrlDragImageView.this.dqI.originalProcess = -1;
                    UrlDragImageView.this.aNe();
                }
            });
            com.baidu.tbadk.download.d.aOp().a(downloadData, 100);
            this.dtX = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aNd() {
        if (this.dqI != null && !StringUtils.isNull(this.dqI.originalUrl, true) && this.dqI.originalSize >= 0 && !this.dqI.isBlockedPic) {
            String nameMd5FromUrl = as.getNameMd5FromUrl(this.dqI.originalUrl);
            File file = new File(this.dtH + ap.aGA().tw(nameMd5FromUrl) + "/" + nameMd5FromUrl);
            if (file != null && file.exists()) {
                this.dqI.originalProcess = 100;
                return true;
            }
            if (this.dqI.originalProcess < 0) {
                aNe();
            } else {
                this.dtW.setProgress(this.dqI.originalProcess);
            }
            this.dtQ = true;
        } else {
            this.dtV = null;
        }
        return false;
    }

    public void aNe() {
        if (this.dqI != null) {
            if (!aNf() || !this.dtQ) {
                this.dtV = null;
            } else if (this.dqI.originalSize > 0 && !bH(this.dqI.originalSize)) {
                this.dtV = dtp + "(" + aq.getFormatSize(this.dqI.originalSize) + ")";
            } else {
                this.dtV = dtp;
            }
        }
    }

    private boolean aNf() {
        return (this.dqI == null || !this.dqI.mIsShowOrigonButton || this.dqI.isBlockedPic || StringUtils.isNull(this.dqI.originalUrl)) ? false : true;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.drO = bVar;
    }

    private boolean bH(long j) {
        return j > dtq;
    }
}
