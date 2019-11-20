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
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.util.f;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.File;
/* loaded from: classes3.dex */
public class UrlDragImageView extends RelativeLayout {
    private Rect cBA;
    private DragImageView.d cBB;
    private String cBC;
    private float cBD;
    private float cBE;
    private float cBF;
    private float cBG;
    private float cBH;
    private boolean cBI;
    private boolean cBJ;
    private boolean cBK;
    public boolean cBL;
    private com.baidu.tbadk.img.b cBM;
    private View.OnTouchListener cBN;
    private boolean cBO;
    private float cBP;
    private String cBQ;
    private CircleProgressView cBR;
    private boolean cBS;
    private Runnable cBT;
    private Runnable cBU;
    private View.OnTouchListener cBV;
    protected DragImageView cBn;
    protected TextView cBo;
    protected SubsamplingScaleImageView cBp;
    private SubsamplingScaleImageView.OnImageEventListener cBq;
    private a cBr;
    private boolean cBs;
    private boolean cBt;
    private boolean cBu;
    private boolean cBv;
    private Bitmap cBw;
    private RectF cBx;
    private Rect cBy;
    private Rect cBz;
    private ImageUrlData cyC;
    private b czL;
    private boolean czS;
    private boolean czU;
    private boolean czV;
    private boolean isInDragScaleMode;
    protected Context mContext;
    private Rect mDisplayRect;
    private final Matrix mDragMatrix;
    private RectF mDstRect;
    private boolean mIsDrag;
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
    private static final String cBl = TbadkCoreApplication.getInst().getString(R.string.original_img_look);
    private static long cBm = Config.RAVEN_LOG_LIMIT;
    private static final int EXIT_DISTANCE = l.getEquipmentHeight(TbadkCoreApplication.getInst()) / 5;
    private static final String TAG = UrlDragImageView.class.getSimpleName();
    private static final int TOUCH_SLOP = ViewConfiguration.get(TbadkCoreApplication.getInst()).getScaledTouchSlop();

    /* loaded from: classes3.dex */
    public interface a {
        void h(String str, byte[] bArr);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void asR();
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
        if (this.cBn != null) {
            this.cBn.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.cBr = aVar;
    }

    public UrlDragImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.cBn = null;
        this.cBr = null;
        this.czS = false;
        this.cBu = false;
        this.isInDragScaleMode = false;
        this.mRatio = 1.0f;
        this.mMoveDistance = 0.0f;
        this.mDragMatrix = new Matrix();
        this.mDstRect = new RectF();
        this.cBD = 0.0f;
        this.cBE = 0.0f;
        this.cBF = 1.0f;
        this.cBG = 1.0f;
        this.cBH = 0.0f;
        this.cBI = false;
        this.cBJ = false;
        this.cBK = false;
        this.cBL = false;
        this.cBO = true;
        this.cBP = 0.0f;
        this.mOnClickListener = null;
        this.mLongClickListener = null;
        this.cBQ = null;
        this.cBT = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.cBO = true;
            }
        };
        this.cBU = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.cBR.setVisibility(8);
                        UrlDragImageView.this.cBQ = null;
                        UrlDragImageView.this.cBL = false;
                    }
                });
            }
        };
        this.cBV = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.cBN != null) {
                    UrlDragImageView.this.cBN.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.cBM = new com.baidu.tbadk.img.b();
        init();
    }

    public UrlDragImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.cBn = null;
        this.cBr = null;
        this.czS = false;
        this.cBu = false;
        this.isInDragScaleMode = false;
        this.mRatio = 1.0f;
        this.mMoveDistance = 0.0f;
        this.mDragMatrix = new Matrix();
        this.mDstRect = new RectF();
        this.cBD = 0.0f;
        this.cBE = 0.0f;
        this.cBF = 1.0f;
        this.cBG = 1.0f;
        this.cBH = 0.0f;
        this.cBI = false;
        this.cBJ = false;
        this.cBK = false;
        this.cBL = false;
        this.cBO = true;
        this.cBP = 0.0f;
        this.mOnClickListener = null;
        this.mLongClickListener = null;
        this.cBQ = null;
        this.cBT = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.cBO = true;
            }
        };
        this.cBU = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.cBR.setVisibility(8);
                        UrlDragImageView.this.cBQ = null;
                        UrlDragImageView.this.cBL = false;
                    }
                });
            }
        };
        this.cBV = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.cBN != null) {
                    UrlDragImageView.this.cBN.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.cBM = new com.baidu.tbadk.img.b();
        init();
    }

    public DragImageView getImageView() {
        return this.cBn;
    }

    public void setGifSetListener(DragImageView.e eVar) {
        this.cBn.setGifSetListener(eVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.cBn.setImageOnClickListener(onClickListener);
        this.cBp.setOnClickListener(onClickListener);
        this.mOnClickListener = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mLongClickListener = onLongClickListener;
        if (!this.czU) {
            this.cBn.setImageOnLongClickListener(this.mLongClickListener);
            this.cBp.setOnLongClickListener(this.mLongClickListener);
        }
    }

    public void setOnSizeChangedListener(final DragImageView.g gVar) {
        this.cBn.setOnSizeChangedListener(new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.8
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (gVar != null) {
                    gVar.a(dragImageView, z, z2);
                }
                UrlDragImageView.this.asF();
            }
        });
    }

    protected void init() {
        this.cBC = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        this.mMaxWidth = l.getEquipmentWidth(this.mContext);
        this.mMaxHeight = l.getEquipmentHeight(this.mContext) - ((int) this.mContext.getResources().getDimension(R.dimen.ds166));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.cBn = new DragImageView(this.mContext);
        this.cBn.setLayoutParams(layoutParams);
        this.cBn.setOnTouchListener(this.cBV);
        addView(this.cBn);
        this.cBp = new SubsamplingScaleImageView(this.mContext);
        this.cBp.setMaxScale(50.0f);
        this.cBp.setOnTouchListener(this.cBV);
        this.cBp.setVisibility(4);
        addView(this.cBp, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(getResources().getDrawable(R.drawable.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        asE();
    }

    private void asE() {
        this.cBR = new CircleProgressView(this.mContext);
        this.cBR.setCircleBackgroundColor(am.getColor(R.color.cp_cont_d));
        this.cBR.setCircleForegroundColor(am.getColor(R.color.cp_link_tip_a));
        this.cBR.setProgress(0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds80), l.getDimens(getContext(), R.dimen.tbds80));
        layoutParams.addRule(13);
        this.cBR.setVisibility(8);
        addView(this.cBR, layoutParams);
    }

    public void setIsCanDrag(boolean z) {
        this.czU = z;
    }

    public void setIsHotSort(boolean z) {
        this.czV = z;
    }

    public String getmCheckOriginPicText() {
        return this.cBQ;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        Bitmap imageBitmap;
        int height;
        int width;
        if (this.cBI && !this.cBS && this.cBp.getVisibility() == 0 && !this.cBp.isImageLoaded()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.czU || !this.cBt) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.mIsDrag && motionEvent.getPointerCount() >= 2) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.mIsDrag || this.cBv) {
            requestDisallowInterceptTouchEvent(true);
        }
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        float x = motionEvent.getX();
        int i = action & 255;
        if (i == 0) {
            if (this.cBw == null) {
                if (this.cBp.getVisibility() == 0) {
                    this.cBw = f.bh(this.cBp);
                } else {
                    this.cBw = f.bh(this.cBn);
                }
            }
            if (this.mDisplayRect == null && this.cBw != null) {
                int measuredWidth = getMeasuredWidth();
                float measuredWidth2 = ((getMeasuredWidth() * 1.0f) / this.cBw.getWidth()) * this.cBw.getHeight();
                if (measuredWidth2 > getMeasuredHeight()) {
                    measuredWidth2 = getMeasuredHeight();
                }
                RectF rectInScreenFromPosition = getRectInScreenFromPosition(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
                this.mDisplayRect = new Rect((int) rectInScreenFromPosition.left, (int) rectInScreenFromPosition.top, (int) rectInScreenFromPosition.right, (int) rectInScreenFromPosition.bottom);
            }
            if (this.cBz == null && this.cBw != null) {
                if (this.cBp.getVisibility() == 0) {
                    height = this.cBp.getSHeight();
                    width = this.cBp.getSWidth();
                } else {
                    if (this.cBn.getImageType() == 1) {
                        imageBitmap = (this.cBn.getCurrentFrame() == null || this.cBn.getCurrentFrame().bm == null) ? this.cBw : this.cBn.getCurrentFrame().bm;
                    } else {
                        imageBitmap = this.cBn.getImageBitmap() == null ? this.cBw : this.cBn.getImageBitmap();
                    }
                    height = imageBitmap.getHeight();
                    width = imageBitmap.getWidth();
                }
                float equipmentDensity = l.getEquipmentDensity(getContext());
                int i2 = (int) (height * equipmentDensity);
                int i3 = (int) (width * equipmentDensity);
                if (i3 > this.cBw.getWidth() && this.cBw.getWidth() != 0) {
                    float width2 = (i3 * 1.0f) / this.cBw.getWidth();
                    i3 = this.cBw.getWidth();
                    i2 = (int) (i2 / width2);
                }
                if (i2 > this.cBw.getHeight() && this.cBw.getHeight() != 0) {
                    i3 = (int) (i3 / ((i2 * 1.0f) / this.cBw.getHeight()));
                    i2 = this.cBw.getHeight();
                }
                int equipmentHeight = (l.getEquipmentHeight(getContext()) - i2) / 2;
                int equipmentWidth = (l.getEquipmentWidth(getContext()) - i3) / 2;
                this.cBz = new Rect(equipmentWidth, equipmentHeight, i3 + equipmentWidth, i2 + equipmentHeight);
                this.cBA = new Rect(this.cBz);
                this.cBH = equipmentHeight / l.getEquipmentHeight(getContext());
                this.cBy = new Rect(0, 0, this.cBw.getWidth(), this.cBw.getHeight());
            }
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (i == 2) {
            this.mIsDrag = q(this.mLastMotionX - x, this.mLastMotionY - y);
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (this.mIsDrag || this.cBv) {
            this.cBn.setImageOnLongClickListener(null);
            this.cBp.setOnLongClickListener(null);
            z = true;
        } else {
            this.cBn.setImageOnLongClickListener(this.mLongClickListener);
            this.cBp.setOnLongClickListener(this.mLongClickListener);
            z = super.dispatchTouchEvent(motionEvent);
        }
        if (i == 1 || i == 3) {
            this.mLastMotionX = 0.0f;
            this.mLastMotionY = 0.0f;
            if (this.mMoveDistance > EXIT_DISTANCE) {
                this.cBv = true;
                startExitAnimation();
            } else {
                if (this.mIsDrag && this.cBB != null) {
                    this.cBB.aya();
                }
                this.mRatio = 1.0f;
                invalidate();
            }
            this.isInDragScaleMode = false;
            this.mDragMatrix.reset();
            this.mIsDrag = false;
            return z;
        }
        return z;
    }

    private boolean q(float f, float f2) {
        if (this.cBp.getVisibility() != 0 || this.cBp.isCanDrag()) {
            if (this.cyC == null || !this.cyC.isLongPic || this.cBp.getVisibility() != 0 || this.cBp.isViewTop()) {
                if (this.cyC == null || !this.cyC.isLongPic || this.cBp.getVisibility() == 0 || this.cBn.isAtViewTop()) {
                    if (this.cBp.getVisibility() == 0 || this.cBn.pagerCantScroll()) {
                        if (this.cBw != null && getScrollY() == 0 && f2 < 0.0f && !this.isInDragScaleMode) {
                            this.cBn.setImageOnLongClickListener(null);
                            this.cBp.setOnLongClickListener(null);
                            this.isInDragScaleMode = true;
                            this.mMoveDistance = 0.0f;
                            this.mRatio = 1.0f;
                            if (this.cBB != null) {
                                this.cBB.onDragStart();
                            }
                        }
                        if (!this.isInDragScaleMode || this.cBw == null) {
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
                            this.mDragMatrix.preScale(1.0f / this.mRatio, 1.0f / this.mRatio, (this.mRatio * this.cBw.getWidth()) / 2.0f, this.mRatio * (this.cBw.getHeight() / 2));
                            this.mRatio = 1.0f;
                        } else {
                            this.mDragMatrix.preScale(1.0f + f3, 1.0f + f3, (this.mRatio * this.cBw.getWidth()) / 2.0f, this.mRatio * (this.cBw.getHeight() / 2));
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
        if (this.mIsDrag && this.cBw != null && !this.cBw.isRecycled() && this.isInDragScaleMode) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.mDstRect == null) {
                this.mDstRect = new RectF();
            }
            this.mDragMatrix.mapRect(this.mDstRect, new RectF(this.mDisplayRect));
            canvas.drawBitmap(this.cBw, this.cBy, this.mDstRect, (Paint) null);
        } else if (this.cBv && this.cBw != null && !this.cBw.isRecycled()) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.cyC == null || this.cyC.getSourceImageRectInScreen() == null) {
                canvas.drawBitmap(this.cBw, this.cBy, this.mDstRect, (Paint) null);
            } else {
                canvas.drawBitmap(this.cBw, this.cBz, this.mDstRect, (Paint) null);
            }
        } else {
            super.dispatchDraw(canvas);
        }
    }

    private void startExitAnimation() {
        if (this.cyC == null) {
            if (this.cBB != null) {
                this.cBB.onDragEnd();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.cyC.getSourceImageRectInScreen();
        final Rect dstRectInScreen = this.cyC.getDstRectInScreen();
        if (sourceImageRectInScreen == null || dstRectInScreen == null) {
            if (this.cBB != null) {
                this.cBB.onDragEnd();
                return;
            }
            return;
        }
        a(sourceImageRectInScreen, dstRectInScreen);
        d(sourceImageRectInScreen);
        this.cBx = new RectF(this.mDstRect);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(150L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && sourceImageRectInScreen != null && dstRectInScreen != null) {
                    UrlDragImageView.this.ad(valueAnimator.getAnimatedFraction());
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
                UrlDragImageView.this.isInDragScaleMode = false;
                UrlDragImageView.this.invalidate();
                if (UrlDragImageView.this.cBB != null) {
                    UrlDragImageView.this.cBB.onDragEnd();
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

    private void d(Rect rect) {
        if (rect != null) {
            float f = ((rect.bottom - rect.top) / (rect.right - rect.left)) * (this.mDstRect.right - this.mDstRect.left);
            this.mDstRect.top += this.mDstRect.height() * this.cBH;
            this.mDstRect.bottom = f + this.mDstRect.top;
        }
    }

    public void setCanScale(boolean z) {
        if (this.cBn != null) {
            this.cBn.setCanScale(z);
        }
    }

    private void a(Rect rect, Rect rect2) {
        this.cBD = 0.0f;
        this.cBE = 0.0f;
        this.cBF = 1.0f;
        this.cBG = 1.0f;
        if (rect != null && rect2 != null && rect.contains(rect2)) {
            this.cBD = (rect2.left - rect.left) / rect.width();
            this.cBE = (rect2.top - rect.top) / rect.height();
            this.cBF = (rect2.right - rect.left) / rect.width();
            this.cBG = (rect2.bottom - rect.top) / rect.height();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ad(float f) {
        if (this.cBz != null) {
            this.cBz.left = (int) (this.cBA.left + (this.cBA.width() * this.cBD * f));
            this.cBz.top = (int) (this.cBA.top + (this.cBA.height() * this.cBE * f));
            this.cBz.right = (int) (this.cBA.left + (this.cBA.width() * (((1.0f - this.cBF) * (1.0f - f)) + this.cBF)));
            this.cBz.bottom = (int) (this.cBA.top + (this.cBA.height() * (((1.0f - this.cBG) * (1.0f - f)) + this.cBG)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Rect rect, float f) {
        if (this.mDstRect != null && rect != null) {
            this.mDstRect.left = this.cBx.left + ((rect.left - this.cBx.left) * f);
            this.mDstRect.top = this.cBx.top + ((rect.top - this.cBx.top) * f);
            this.mDstRect.right = this.cBx.right + ((rect.right - this.cBx.right) * f);
            this.mDstRect.bottom = this.cBx.bottom + ((rect.bottom - this.cBx.bottom) * f);
        }
    }

    private RectF getRectInScreenFromPosition(float f, float f2, float f3, float f4) {
        return new RectF(f - (f3 / 2.0f), f2 - (f4 / 2.0f), (f3 / 2.0f) + f, (f4 / 2.0f) + f2);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.cBN = onTouchListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asF() {
        if ((this.cBs || this.cBt) && this.cyC != null && this.cyC.mPicType == 1 && !TextUtils.isEmpty(this.cyC.mTagName)) {
            if (this.cBo != null) {
                this.cBo.setVisibility(8);
                this.cBo = null;
            }
            this.cBo = new TextView(this.mContext);
            this.cBo.setText(this.cyC.mTagName);
            this.cBo.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize26));
            am.setViewTextColor(this.cBo, R.color.common_color_10013, 1, 0);
            am.setBackgroundColor(this.cBo, R.color.common_color_10215);
            this.cBo.setAlpha(0.75f);
            this.cBo.setIncludeFontPadding(false);
            this.cBo.setGravity(17);
            int dimens = l.getDimens(this.mContext, R.dimen.ds2);
            this.cBo.setPadding(dimens, dimens, dimens, dimens);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.cBn.getBottomOffset();
            layoutParams.leftMargin = this.cBn.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.cBo, layoutParams);
            this.cBo.setVisibility(0);
        }
    }

    public void setUrl(String str, boolean z) {
        if (str.contains("*")) {
            str = str.split("[*]")[0];
        }
        this.cBn.setTag(str);
        this.cBn.setLoadBigImage(false);
        this.cBn.setImageDrawable(null);
        this.cBs = false;
        this.cBt = false;
        this.cBI = asN();
        this.cBQ = null;
        if (pf(str)) {
            e(str, z, false);
        }
    }

    private boolean asG() {
        return this.cBn != null && this.cBn.isLoadBigImage();
    }

    public void asH() {
        if (this.cyC != null && !asG()) {
            String str = this.cyC.imageUrl;
            int i = this.cyC.urlType;
            com.baidu.adp.widget.ImageView.a aVar = null;
            if (com.baidu.tbadk.core.util.e.a.P(str, i)) {
                aVar = com.baidu.tbadk.core.util.e.a.Q(str, i);
            }
            if (aVar != null) {
                setThumbBitmapToView(aVar);
            }
        }
    }

    private boolean eT(boolean z) {
        String nameMd5FromUrl;
        if (!this.cBJ || z) {
            this.cBJ = true;
            if (!this.cBI || this.cyC == null || StringUtils.isNull(this.cyC.originalUrl, true) || this.cyC.originalSize < 0 || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String str = this.cBC + ap.amJ().nQ(nameMd5FromUrl) + "/" + as.getNameMd5FromUrl(this.cyC.originalUrl);
            final int[] imageFileWH = m.getImageFileWH(str);
            this.cBp.setVisibility(0);
            if (this.cBq == null) {
                this.cBq = new SubsamplingScaleImageView.OnImageEventListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12
                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onReady() {
                        UrlDragImageView.this.cBQ = null;
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.cBn.restoreSize();
                        UrlDragImageView.this.cBn.setVisibility(4);
                    }

                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onImageLoaded() {
                        if (UrlDragImageView.this.cyC.isLongPic && imageFileWH[0] > 0) {
                            UrlDragImageView.this.cBn.onDestroy();
                            final float measuredWidth = (UrlDragImageView.this.getMeasuredWidth() * 1.0f) / imageFileWH[0];
                            final PointF pointF = new PointF((imageFileWH[0] * 1.0f) / 2.0f, 0.0f);
                            UrlDragImageView.this.cBp.setScaleAndCenter(measuredWidth, pointF);
                            UrlDragImageView.this.cBp.setMaxScale(2.0f * measuredWidth);
                            UrlDragImageView.this.cBp.setDoubleTapZoomScale(2.0f * measuredWidth);
                            UrlDragImageView.this.cBp.setInitScale(measuredWidth);
                            UrlDragImageView.this.cBp.setDoubleTapZoomStyle(4);
                            UrlDragImageView.this.cBp.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12.1
                                @Override // android.view.View.OnTouchListener
                                public boolean onTouch(View view, MotionEvent motionEvent) {
                                    if (UrlDragImageView.this.cBN != null) {
                                        UrlDragImageView.this.cBN.onTouch(view, motionEvent);
                                    }
                                    switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                                        case 0:
                                            UrlDragImageView.this.cBP = motionEvent.getY();
                                            UrlDragImageView.this.cBp.setOnClickListener(UrlDragImageView.this.cBO ? UrlDragImageView.this.mOnClickListener : null);
                                            UrlDragImageView.this.cBp.setOnLongClickListener(UrlDragImageView.this.cBO ? UrlDragImageView.this.mLongClickListener : null);
                                            break;
                                        case 1:
                                        case 3:
                                            if (UrlDragImageView.this.cBp.getScale() < measuredWidth) {
                                                UrlDragImageView.this.cBp.setScaleAndCenter(measuredWidth, pointF);
                                            }
                                            e.fZ().removeCallbacks(UrlDragImageView.this.cBT);
                                            e.fZ().postDelayed(UrlDragImageView.this.cBT, 1000L);
                                            break;
                                        case 2:
                                            if (Math.abs(motionEvent.getY() - UrlDragImageView.this.cBP) > UrlDragImageView.TOUCH_SLOP) {
                                                UrlDragImageView.this.cBO = false;
                                                UrlDragImageView.this.cBp.setOnClickListener(null);
                                                UrlDragImageView.this.cBp.setOnLongClickListener(null);
                                            }
                                            UrlDragImageView.this.cBP = motionEvent.getY();
                                            break;
                                    }
                                    return false;
                                }
                            });
                            UrlDragImageView.this.cBn.setVisibility(4);
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
            this.cBp.setOnImageEventListener(this.cBq);
            if (this.cBp.isImageLoaded() && this.cyC.isLongPic) {
                this.cBq.onImageLoaded();
            } else {
                this.cBp.setImage(ImageSource.uri(str));
            }
            return true;
        }
        return false;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.cBB = dVar;
        if (this.cBn != null) {
            this.cBn.setDragToExitListener(dVar);
        }
    }

    public void asI() {
        eT(false);
    }

    private boolean pf(String str) {
        return j.isNetWorkAvailable() || com.baidu.tbadk.core.util.e.c.oj(str);
    }

    private void setThumbBitmapToView(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap rawBitmap;
        if (!this.cBt && aVar != null && (rawBitmap = aVar.getRawBitmap()) != null) {
            this.cBs = true;
            if (aVar.isGif()) {
                this.cBn.setImageUrlData(this.cyC);
                this.cBn.setImageBitmap(rawBitmap);
                this.cBQ = null;
                this.cBL = false;
            } else {
                if (this.cyC != null && this.cyC.isLongPic) {
                    this.cBn.createLargeImageDelegate();
                    this.cBn.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.13
                        @Override // com.baidu.tbadk.widget.largeImage.logic.a
                        public void onLoadFinished() {
                        }
                    });
                }
                this.cBn.setImageUrlData(this.cyC);
                this.cBn.setImageData(rawBitmap, aVar.getByteData());
            }
            asF();
        }
    }

    private void e(String str, boolean z, boolean z2) {
        if (pg(str)) {
            if (z2 || (!this.cBu && !this.cBt)) {
                if (!z2 || !eT(true)) {
                    this.cBu = true;
                    com.baidu.adp.lib.f.c.fT().a(str, 27, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.14
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onCancelled(String str2) {
                            UrlDragImageView.this.cBu = false;
                            UrlDragImageView.this.cBn.setVisibility(0);
                            UrlDragImageView.this.mProgressBar.setVisibility(8);
                            UrlDragImageView.this.cBQ = null;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            UrlDragImageView.this.cBu = false;
                            UrlDragImageView.this.cBt = true;
                            UrlDragImageView.this.b(aVar);
                        }
                    }, 0, 0, false, null, Boolean.valueOf(z), this.cBn.getImageData(), Boolean.valueOf(this.czS));
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
        imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.am(this.mMaxWidth, this.mMaxHeight));
        com.baidu.adp.widget.ImageView.a a2 = this.cBM.a(imageFileInfo, false);
        if (a2 != null) {
            this.cBt = true;
            this.mProgressBar.setVisibility(8);
            this.cBQ = null;
            b(a2);
            return;
        }
        this.cBM.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.2
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.ImageView.a aVar, String str2, boolean z3) {
                UrlDragImageView.this.cBt = true;
                UrlDragImageView.this.mProgressBar.setVisibility(8);
                UrlDragImageView.this.cBQ = null;
                UrlDragImageView.this.b(aVar);
            }
        }, false);
    }

    private boolean pg(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null && this.cBr != null) {
            this.cBr.h(aVar.getUrl(), aVar.getByteData());
        }
        if (aVar == null || aVar.getRawBitmap() == null) {
            asJ();
            return;
        }
        Bitmap rawBitmap = aVar.getRawBitmap();
        this.cBn.setLoadBigImage(true);
        if (aVar.isGif()) {
            this.cBn.setGifData(aVar.getByteData(), rawBitmap);
            this.cBn.invalidate();
            this.cBn.play();
            this.cBL = false;
            this.cBQ = null;
            this.mProgressBar.setVisibility(8);
        } else {
            if (this.cyC != null && this.cyC.isLongPic) {
                this.cBn.createLargeImageDelegate();
                this.cBn.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.3
                    @Override // com.baidu.tbadk.widget.largeImage.logic.a
                    public void onLoadFinished() {
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.cBQ = null;
                    }
                });
            } else {
                this.mProgressBar.setVisibility(8);
                this.cBQ = null;
            }
            this.cBn.setImageUrlData(this.cyC);
            this.cBn.setImageData(rawBitmap, aVar.getByteData());
            asO();
        }
        asF();
    }

    private void asJ() {
        if (!this.cBs) {
            this.cBn.setDefaultBitmap();
        } else {
            this.cBt = false;
        }
        this.cBQ = null;
        this.mProgressBar.setVisibility(8);
    }

    public void setGifMaxUseableMem(int i) {
        this.cBn.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.cBn != null) {
            this.cBn.onDestroy();
        }
        if (this.cBp != null) {
            this.cBp.recycle();
        }
        if (this.cBw != null) {
            this.cBw.recycle();
            this.cBw = null;
        }
        if (this.mProgressBar != null) {
            this.cBQ = null;
            this.mProgressBar.setVisibility(8);
        }
        e.fZ().removeCallbacks(this.cBT);
        com.baidu.tieba.view.c.cwN().setColor(-1);
    }

    public void release() {
        if (this.cBn != null) {
            this.cBn.release();
        }
        if (this.mProgressBar != null) {
            this.cBQ = null;
            this.mProgressBar.setVisibility(8);
        }
        this.cBQ = null;
    }

    public void asK() {
        if (this.cBn != null && this.cBn.getImageType() == 1) {
            this.cBn.stop();
        }
    }

    public void u(boolean z, boolean z2) {
        String str;
        if (this.cBn != null && (str = (String) this.cBn.getTag()) != null) {
            if (this.cBn.getImageType() == 1) {
                if (this.cBn.getGifCache() == null || !this.cBn.isLoadBigImage()) {
                    e(str, z, z2);
                }
            } else if (this.cBn.getImageType() == 2) {
                e(str, z, z2);
            } else if (asL()) {
                e(str, z, z2);
            }
        }
    }

    private boolean asL() {
        if (this.cBn.getImageBitmap() != null && this.cBn.isLoadBigImage()) {
            if (this.cyC == null || !this.cyC.isLongPic || this.cBn.hasLoadLongImage()) {
                return false;
            }
            this.cBt = false;
            this.cBJ = false;
            return true;
        }
        return true;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.cyC = imageUrlData;
    }

    public ImageUrlData getmAssistUrlData() {
        return this.cyC;
    }

    public void setIsCdn(boolean z) {
        this.czS = z;
    }

    public void asM() {
        final String nameMd5FromUrl = as.getNameMd5FromUrl(this.cyC.originalUrl);
        if (this.cyC.originalProcess >= 0) {
            com.baidu.tbadk.download.d.atT().cancelDownLoadById(nameMd5FromUrl, 13);
            this.cyC.originalProcess = -1;
            asO();
            return;
        }
        if (this.czL != null) {
            this.czL.asR();
        }
        com.baidu.adp.base.e<?> ab = i.ab(this.mContext);
        if (ab == null) {
            ph(nameMd5FromUrl);
        } else if (!j.isNetWorkAvailable() || j.isWifiNet() || com.baidu.tbadk.core.sharedPref.b.alP().getBoolean(SharedPrefConfig.ORIGINAL_IMG_DOWN_TIP, false)) {
            ph(nameMd5FromUrl);
        } else {
            com.baidu.tbadk.core.sharedPref.b.alP().putBoolean(SharedPrefConfig.ORIGINAL_IMG_DOWN_TIP, true);
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(ab.getPageActivity());
            aVar.hT(R.string.original_img_down_no_wifi_tip);
            aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    UrlDragImageView.this.ph(nameMd5FromUrl);
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                }
            });
            aVar.b(ab);
            aVar.akM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ph(String str) {
        if (this.cyC != null) {
            this.cyC.originalProcess = 0;
            this.cBR.setProgress(0);
            this.cBR.setVisibility(0);
            DownloadData downloadData = new DownloadData(str);
            downloadData.setStatus(1);
            downloadData.setUrl(this.cyC.originalUrl);
            downloadData.setType(13);
            downloadData.setPath(this.cBC + ap.amJ().nQ(str) + "/" + str);
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.6
                @Override // com.baidu.tbadk.download.c
                public boolean onPreDownload(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2 != null) {
                        if (UrlDragImageView.this.cyC != null && UrlDragImageView.this.cyC.originalProcess != -1) {
                            UrlDragImageView.this.cyC.originalProcess = downloadData2.getProcess();
                        }
                        if (UrlDragImageView.this.cyC == null || UrlDragImageView.this.cyC.originalProcess != -1) {
                            UrlDragImageView.this.cBR.setProgress(downloadData2.getProcess());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public boolean onFileDownloaded(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadSucceed(DownloadData downloadData2) {
                    UrlDragImageView.this.cBR.setVisibility(8);
                    e.fZ().postDelayed(UrlDragImageView.this.cBU, 1500L);
                    UrlDragImageView.this.cBJ = false;
                    UrlDragImageView.this.cBI = UrlDragImageView.this.asN();
                    UrlDragImageView.this.asI();
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str2) {
                    UrlDragImageView.this.cBR.setVisibility(8);
                    UrlDragImageView.this.cBJ = false;
                    BdToast.b(UrlDragImageView.this.mContext, str2).akQ().akR();
                    UrlDragImageView.this.cyC.originalProcess = -1;
                    UrlDragImageView.this.asO();
                }
            });
            com.baidu.tbadk.download.d.atT().a(downloadData, 100);
            this.cBS = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean asN() {
        if (this.cyC != null && !StringUtils.isNull(this.cyC.originalUrl, true) && this.cyC.originalSize >= 0 && !this.cyC.isBlockedPic) {
            String nameMd5FromUrl = as.getNameMd5FromUrl(this.cyC.originalUrl);
            File file = new File(this.cBC + ap.amJ().nQ(nameMd5FromUrl) + "/" + nameMd5FromUrl);
            if (file != null && file.exists()) {
                this.cyC.originalProcess = 100;
                return true;
            }
            if (this.cyC.originalProcess < 0) {
                asO();
            } else {
                this.cBR.setProgress(this.cyC.originalProcess);
            }
            this.cBL = true;
        } else {
            this.cBQ = null;
        }
        return false;
    }

    public void asO() {
        if (this.cyC != null) {
            if (!asP() || !this.cBL) {
                this.cBQ = null;
            } else if (this.cyC.originalSize > 0 && !aY(this.cyC.originalSize)) {
                this.cBQ = cBl + "(" + aq.getFormatSize(this.cyC.originalSize) + ")";
            } else {
                this.cBQ = cBl;
            }
        }
    }

    private boolean asP() {
        return (this.cyC == null || !this.cyC.mIsShowOrigonButton || this.cyC.isBlockedPic || StringUtils.isNull(this.cyC.originalUrl)) ? false : true;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.czL = bVar;
    }

    private boolean aY(long j) {
        return j > cBm;
    }
}
