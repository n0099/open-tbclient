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
    private ImageUrlData dRf;
    private b dSk;
    private boolean dSr;
    private boolean dSt;
    protected DragImageView dTM;
    protected TextView dTN;
    protected SubsamplingScaleImageView dTO;
    private SubsamplingScaleImageView.OnImageEventListener dTP;
    private a dTQ;
    private boolean dTR;
    private boolean dTS;
    private boolean dTT;
    private boolean dTU;
    private boolean dTV;
    private Bitmap dTW;
    private RectF dTX;
    private Rect dTY;
    private Rect dTZ;
    private Rect dUa;
    private DragImageView.d dUb;
    private String dUc;
    private float dUd;
    private float dUe;
    private float dUf;
    private float dUg;
    private float dUh;
    private boolean dUi;
    private boolean dUj;
    private boolean dUk;
    public boolean dUl;
    private com.baidu.tbadk.img.b dUm;
    private View.OnTouchListener dUn;
    private boolean dUo;
    private float dUp;
    private String dUq;
    private CircleProgressView dUr;
    private boolean dUs;
    private boolean dUt;
    private Runnable dUu;
    private Runnable dUv;
    private View.OnTouchListener dUw;
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
    private static final String dTK = TbadkCoreApplication.getInst().getString(R.string.original_img_look);
    private static long dTL = Config.RAVEN_LOG_LIMIT;
    private static final int EXIT_DISTANCE = l.getEquipmentHeight(TbadkCoreApplication.getInst()) / 5;
    private static final String TAG = UrlDragImageView.class.getSimpleName();
    private static final int TOUCH_SLOP = ViewConfiguration.get(TbadkCoreApplication.getInst()).getScaledTouchSlop();

    /* loaded from: classes8.dex */
    public interface a {
        void k(String str, byte[] bArr);
    }

    /* loaded from: classes8.dex */
    public interface b {
        void aVJ();
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
        if (this.dTM != null) {
            this.dTM.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.dTQ = aVar;
    }

    public UrlDragImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.dTM = null;
        this.dTQ = null;
        this.dSr = false;
        this.dTT = false;
        this.isInDragScaleMode = false;
        this.mRatio = 1.0f;
        this.mMoveDistance = 0.0f;
        this.mDragMatrix = new Matrix();
        this.mDstRect = new RectF();
        this.dUd = 0.0f;
        this.dUe = 0.0f;
        this.dUf = 1.0f;
        this.dUg = 1.0f;
        this.dUh = 0.0f;
        this.dUi = false;
        this.dUj = false;
        this.dUk = false;
        this.dUl = false;
        this.dUo = true;
        this.dUp = 0.0f;
        this.mOnClickListener = null;
        this.mLongClickListener = null;
        this.dUq = null;
        this.dUu = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.dUo = true;
            }
        };
        this.dUv = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.dUr.setVisibility(8);
                        UrlDragImageView.this.dUq = null;
                        UrlDragImageView.this.dUl = false;
                    }
                });
            }
        };
        this.dUw = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.dUn != null) {
                    UrlDragImageView.this.dUn.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.dUm = new com.baidu.tbadk.img.b();
        init();
    }

    public UrlDragImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.dTM = null;
        this.dTQ = null;
        this.dSr = false;
        this.dTT = false;
        this.isInDragScaleMode = false;
        this.mRatio = 1.0f;
        this.mMoveDistance = 0.0f;
        this.mDragMatrix = new Matrix();
        this.mDstRect = new RectF();
        this.dUd = 0.0f;
        this.dUe = 0.0f;
        this.dUf = 1.0f;
        this.dUg = 1.0f;
        this.dUh = 0.0f;
        this.dUi = false;
        this.dUj = false;
        this.dUk = false;
        this.dUl = false;
        this.dUo = true;
        this.dUp = 0.0f;
        this.mOnClickListener = null;
        this.mLongClickListener = null;
        this.dUq = null;
        this.dUu = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.dUo = true;
            }
        };
        this.dUv = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.dUr.setVisibility(8);
                        UrlDragImageView.this.dUq = null;
                        UrlDragImageView.this.dUl = false;
                    }
                });
            }
        };
        this.dUw = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.dUn != null) {
                    UrlDragImageView.this.dUn.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.dUm = new com.baidu.tbadk.img.b();
        init();
    }

    public DragImageView getImageView() {
        return this.dTM;
    }

    public void setGifSetListener(DragImageView.e eVar) {
        this.dTM.setGifSetListener(eVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.dTM.setImageOnClickListener(onClickListener);
        this.dTO.setOnClickListener(onClickListener);
        this.mOnClickListener = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mLongClickListener = onLongClickListener;
        if (!this.dSt) {
            this.dTM.setImageOnLongClickListener(this.mLongClickListener);
            this.dTO.setOnLongClickListener(this.mLongClickListener);
        }
    }

    public void setOnSizeChangedListener(final DragImageView.g gVar) {
        this.dTM.setOnSizeChangedListener(new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.8
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (gVar != null) {
                    gVar.a(dragImageView, z, z2);
                }
                UrlDragImageView.this.aVx();
            }
        });
    }

    protected void init() {
        this.dUc = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        this.mMaxWidth = l.getEquipmentWidth(this.mContext);
        this.mMaxHeight = l.getEquipmentHeight(this.mContext) - ((int) this.mContext.getResources().getDimension(R.dimen.ds166));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.dTM = new DragImageView(this.mContext);
        this.dTM.setLayoutParams(layoutParams);
        this.dTM.setOnTouchListener(this.dUw);
        addView(this.dTM);
        this.dTO = new SubsamplingScaleImageView(this.mContext);
        this.dTO.setMaxScale(50.0f);
        this.dTO.setOnTouchListener(this.dUw);
        this.dTO.setVisibility(4);
        addView(this.dTO, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(getResources().getDrawable(R.drawable.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        aVw();
        this.dUt = TbSingleton.getInstance().isCutoutScreen(TbadkApplication.getInst().getCurrentActivity());
    }

    private void aVw() {
        this.dUr = new CircleProgressView(this.mContext);
        this.dUr.setCircleBackgroundColor(am.getColor(R.color.cp_cont_d));
        this.dUr.setCircleForegroundColor(am.getColor(R.color.cp_link_tip_a));
        this.dUr.setProgress(0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds80), l.getDimens(getContext(), R.dimen.tbds80));
        layoutParams.addRule(13);
        this.dUr.setVisibility(8);
        addView(this.dUr, layoutParams);
    }

    public void setIsCanDrag(boolean z) {
        this.dSt = z;
    }

    public String getmCheckOriginPicText() {
        return this.dUq;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        Bitmap imageBitmap;
        int height;
        int width;
        if (this.dUi && !this.dUs && this.dTO.getVisibility() == 0 && !this.dTO.isImageLoaded()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.dSt || !this.dTS) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.dTU && motionEvent.getPointerCount() >= 2) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.dTU || this.dTV) {
            requestDisallowInterceptTouchEvent(true);
        }
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        float x = motionEvent.getX();
        int i = action & 255;
        if (i == 0) {
            if (this.dTW == null) {
                if (this.dTO.getVisibility() == 0) {
                    this.dTW = g.bj(this.dTO);
                } else {
                    this.dTW = g.bj(this.dTM);
                }
            }
            if (this.mDisplayRect == null && this.dTW != null) {
                int measuredWidth = getMeasuredWidth();
                float measuredWidth2 = ((getMeasuredWidth() * 1.0f) / this.dTW.getWidth()) * this.dTW.getHeight();
                if (measuredWidth2 > getMeasuredHeight()) {
                    measuredWidth2 = getMeasuredHeight();
                }
                RectF rectInScreenFromPosition = getRectInScreenFromPosition(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
                this.mDisplayRect = new Rect((int) rectInScreenFromPosition.left, (int) rectInScreenFromPosition.top, (int) rectInScreenFromPosition.right, (int) rectInScreenFromPosition.bottom);
            }
            if (this.dTZ == null && this.dTW != null) {
                if (this.dTO.getVisibility() == 0) {
                    height = this.dTO.getSHeight();
                    width = this.dTO.getSWidth();
                } else {
                    if (this.dTM.getImageType() == 1) {
                        imageBitmap = (this.dTM.getCurrentFrame() == null || this.dTM.getCurrentFrame().bm == null) ? this.dTW : this.dTM.getCurrentFrame().bm;
                    } else {
                        imageBitmap = this.dTM.getImageBitmap() == null ? this.dTW : this.dTM.getImageBitmap();
                    }
                    height = imageBitmap.getHeight();
                    width = imageBitmap.getWidth();
                }
                float equipmentDensity = l.getEquipmentDensity(getContext());
                int i2 = (int) (height * equipmentDensity);
                int i3 = (int) (width * equipmentDensity);
                if (i3 > this.dTW.getWidth() && this.dTW.getWidth() != 0) {
                    float width2 = (i3 * 1.0f) / this.dTW.getWidth();
                    i3 = this.dTW.getWidth();
                    i2 = (int) (i2 / width2);
                }
                if (i2 > this.dTW.getHeight() && this.dTW.getHeight() != 0) {
                    i3 = (int) (i3 / ((i2 * 1.0f) / this.dTW.getHeight()));
                    i2 = this.dTW.getHeight();
                }
                int equipmentHeight = (l.getEquipmentHeight(getContext()) - i2) / 2;
                int equipmentWidth = (l.getEquipmentWidth(getContext()) - i3) / 2;
                this.dTZ = new Rect(equipmentWidth, equipmentHeight, i3 + equipmentWidth, i2 + equipmentHeight);
                this.dUa = new Rect(this.dTZ);
                this.dUh = equipmentHeight / l.getEquipmentHeight(getContext());
                this.dTY = new Rect(0, 0, this.dTW.getWidth(), this.dTW.getHeight());
            }
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (i == 2) {
            this.dTU = r(this.mLastMotionX - x, this.mLastMotionY - y);
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (this.dTU || this.dTV) {
            this.dTM.setImageOnLongClickListener(null);
            this.dTO.setOnLongClickListener(null);
            z = true;
        } else {
            this.dTM.setImageOnLongClickListener(this.mLongClickListener);
            this.dTO.setOnLongClickListener(this.mLongClickListener);
            z = super.dispatchTouchEvent(motionEvent);
        }
        if (i == 1 || i == 3) {
            this.mLastMotionX = 0.0f;
            this.mLastMotionY = 0.0f;
            boolean z2 = (-this.mMoveDistance) > ((float) EXIT_DISTANCE);
            boolean z3 = this.mMoveDistance > ((float) EXIT_DISTANCE);
            if (z2 || z3) {
                this.dTV = true;
                startExitAnimation();
                if (z2) {
                    TiebaStatic.log(new an("c13377").cI("obj_type", "3"));
                } else if (z3) {
                    TiebaStatic.log(new an("c13377").cI("obj_type", "2"));
                }
            } else {
                if (this.dTU && this.dUb != null) {
                    this.dUb.baT();
                }
                this.mRatio = 1.0f;
                invalidate();
            }
            this.isInDragScaleMode = false;
            this.mDragMatrix.reset();
            this.dTU = false;
        }
        return z;
    }

    private boolean r(float f, float f2) {
        if (this.dTO.getVisibility() != 0 || this.dTO.isCanDrag()) {
            if (this.dRf == null || !this.dRf.isLongPic || this.dTO.getVisibility() != 0 || this.dTO.isViewTop()) {
                if (this.dRf == null || !this.dRf.isLongPic || this.dTO.getVisibility() == 0 || this.dTM.isAtViewTop() || this.dTM.baR()) {
                    if (this.dTO.getVisibility() == 0 || this.dTM.pagerCantScroll()) {
                        if (this.dTW != null && getScrollY() == 0) {
                            boolean z = (this.dRf == null || !this.dRf.isLongPic) && ((f2 < -15.0f && !this.isInDragScaleMode) || (f2 > 15.0f && !this.isInDragScaleMode));
                            boolean z2 = this.dRf != null && this.dRf.isLongPic && f2 < 0.0f && !this.isInDragScaleMode;
                            if (z || (z2 && this.dTM.isViewTop())) {
                                this.dTM.setImageOnLongClickListener(null);
                                this.dTO.setOnLongClickListener(null);
                                this.isInDragScaleMode = true;
                                this.mMoveDistance = 0.0f;
                                this.mRatio = 1.0f;
                                if (this.dUb != null) {
                                    this.dUb.onDragStart();
                                }
                            }
                        }
                        if (!this.isInDragScaleMode || this.dTW == null) {
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
                        this.mDragMatrix.preScale(1.0f + f3, 1.0f + f3, (this.mRatio * this.dTW.getWidth()) / 2.0f, this.mRatio * (this.dTW.getHeight() / 2));
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
        if (this.dTU && this.dTW != null && !this.dTW.isRecycled() && this.isInDragScaleMode) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.mDstRect == null) {
                this.mDstRect = new RectF();
            }
            this.mDragMatrix.mapRect(this.mDstRect, new RectF(this.mDisplayRect));
            canvas.drawBitmap(this.dTW, this.dTY, this.mDstRect, (Paint) null);
        } else if (this.dTV && this.dTW != null && !this.dTW.isRecycled()) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.dRf == null || this.dRf.getSourceImageRectInScreen() == null) {
                canvas.drawBitmap(this.dTW, this.dTY, this.mDstRect, (Paint) null);
            } else {
                canvas.drawBitmap(this.dTW, this.dTZ, this.mDstRect, (Paint) null);
            }
        } else {
            super.dispatchDraw(canvas);
        }
    }

    private void startExitAnimation() {
        if (this.dRf == null) {
            if (this.dUb != null) {
                this.dUb.onDragEnd();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.dRf.getSourceImageRectInScreen();
        final Rect dstRectInScreen = this.dRf.getDstRectInScreen();
        if (sourceImageRectInScreen == null || dstRectInScreen == null) {
            if (this.dUb != null) {
                this.dUb.onDragEnd();
                return;
            }
            return;
        }
        b(sourceImageRectInScreen, dstRectInScreen);
        b(sourceImageRectInScreen);
        this.dTX = new RectF(this.mDstRect);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(150L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && sourceImageRectInScreen != null && dstRectInScreen != null) {
                    UrlDragImageView.this.aa(valueAnimator.getAnimatedFraction());
                    UrlDragImageView.this.a(dstRectInScreen, valueAnimator.getAnimatedFraction(), UrlDragImageView.this.dUt);
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
                if (UrlDragImageView.this.dUb != null) {
                    UrlDragImageView.this.dUb.onDragEnd();
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
            this.mDstRect.top += this.mDstRect.height() * this.dUh;
            this.mDstRect.bottom = f + this.mDstRect.top;
        }
    }

    public void setCanScale(boolean z) {
        if (this.dTM != null) {
            this.dTM.setCanScale(z);
        }
    }

    private void b(Rect rect, Rect rect2) {
        this.dUd = 0.0f;
        this.dUe = 0.0f;
        this.dUf = 1.0f;
        this.dUg = 1.0f;
        if (rect != null && rect2 != null && rect.contains(rect2)) {
            this.dUd = (rect2.left - rect.left) / rect.width();
            this.dUe = (rect2.top - rect.top) / rect.height();
            this.dUf = (rect2.right - rect.left) / rect.width();
            this.dUg = (rect2.bottom - rect.top) / rect.height();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa(float f) {
        if (this.dTZ != null) {
            this.dTZ.left = (int) (this.dUa.left + (this.dUa.width() * this.dUd * f));
            this.dTZ.top = (int) (this.dUa.top + (this.dUa.height() * this.dUe * f));
            this.dTZ.right = (int) (this.dUa.left + (this.dUa.width() * (((1.0f - this.dUf) * (1.0f - f)) + this.dUf)));
            this.dTZ.bottom = (int) (this.dUa.top + (this.dUa.height() * (((1.0f - this.dUg) * (1.0f - f)) + this.dUg)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Rect rect, float f, boolean z) {
        int i = 0;
        if (z) {
            i = l.getDimens(getContext(), R.dimen.tbds80);
        }
        if (this.mDstRect != null && rect != null) {
            this.mDstRect.left = this.dTX.left + ((rect.left - this.dTX.left) * f);
            this.mDstRect.top = (this.dTX.top + ((rect.top - this.dTX.top) * f)) - i;
            this.mDstRect.right = this.dTX.right + ((rect.right - this.dTX.right) * f);
            this.mDstRect.bottom = this.dTX.bottom + ((rect.bottom - this.dTX.bottom) * f);
        }
    }

    private RectF getRectInScreenFromPosition(float f, float f2, float f3, float f4) {
        return new RectF(f - (f3 / 2.0f), f2 - (f4 / 2.0f), (f3 / 2.0f) + f, (f4 / 2.0f) + f2);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.dUn = onTouchListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVx() {
        if ((this.dTR || this.dTS) && this.dRf != null && this.dRf.mPicType == 1 && !TextUtils.isEmpty(this.dRf.mTagName)) {
            if (this.dTN != null) {
                this.dTN.setVisibility(8);
                this.dTN = null;
            }
            this.dTN = new TextView(this.mContext);
            this.dTN.setText(this.dRf.mTagName);
            this.dTN.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize26));
            am.setViewTextColor(this.dTN, R.color.common_color_10013, 1, 0);
            am.setBackgroundColor(this.dTN, R.color.common_color_10215);
            this.dTN.setAlpha(0.75f);
            this.dTN.setIncludeFontPadding(false);
            this.dTN.setGravity(17);
            int dimens = l.getDimens(this.mContext, R.dimen.ds2);
            this.dTN.setPadding(dimens, dimens, dimens, dimens);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.dTM.getBottomOffset();
            layoutParams.leftMargin = this.dTM.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.dTN, layoutParams);
            this.dTN.setVisibility(0);
        }
    }

    public void setUrl(String str, boolean z) {
        if (str.contains("*")) {
            str = str.split("[*]")[0];
        }
        this.dTM.setTag(str);
        this.dTM.setLoadBigImage(false);
        this.dTM.setImageDrawable(null);
        this.dTR = false;
        this.dTS = false;
        this.dUi = aVF();
        this.dUq = null;
        if (vU(str)) {
            e(str, z, false);
        }
    }

    private boolean aVy() {
        return this.dTM != null && this.dTM.isLoadBigImage();
    }

    public void aVz() {
        if (this.dRf != null && !aVy()) {
            String str = this.dRf.imageUrl;
            int i = this.dRf.urlType;
            com.baidu.adp.widget.ImageView.a aVar = null;
            if (com.baidu.tbadk.core.util.c.a.ah(str, i)) {
                aVar = com.baidu.tbadk.core.util.c.a.ai(str, i);
            }
            if (aVar != null) {
                setThumbBitmapToView(aVar);
            }
        }
    }

    private boolean hq(boolean z) {
        String nameMd5FromUrl;
        if (!this.dUj || z) {
            this.dUj = true;
            if (!this.dUi || this.dRf == null || StringUtils.isNull(this.dRf.originalUrl, true) || this.dRf.originalSize < 0 || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String str = this.dUc + ap.aOS().uJ(nameMd5FromUrl) + "/" + as.getNameMd5FromUrl(this.dRf.originalUrl);
            final int[] imageFileWH = m.getImageFileWH(str);
            this.dTO.setVisibility(0);
            if (this.dTP == null) {
                this.dTP = new SubsamplingScaleImageView.OnImageEventListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12
                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onReady() {
                        UrlDragImageView.this.dUq = null;
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.dTM.restoreSize();
                        UrlDragImageView.this.dTM.setVisibility(4);
                    }

                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onImageLoaded() {
                        if (UrlDragImageView.this.dRf.isLongPic && imageFileWH[0] > 0) {
                            UrlDragImageView.this.dTM.onDestroy();
                            final float measuredWidth = (UrlDragImageView.this.getMeasuredWidth() * 1.0f) / imageFileWH[0];
                            final PointF pointF = new PointF((imageFileWH[0] * 1.0f) / 2.0f, 0.0f);
                            UrlDragImageView.this.dTO.setScaleAndCenter(measuredWidth, pointF);
                            UrlDragImageView.this.dTO.setMaxScale(2.0f * measuredWidth);
                            UrlDragImageView.this.dTO.setDoubleTapZoomScale(2.0f * measuredWidth);
                            UrlDragImageView.this.dTO.setInitScale(measuredWidth);
                            UrlDragImageView.this.dTO.setDoubleTapZoomStyle(4);
                            UrlDragImageView.this.dTO.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12.1
                                @Override // android.view.View.OnTouchListener
                                public boolean onTouch(View view, MotionEvent motionEvent) {
                                    if (UrlDragImageView.this.dUn != null) {
                                        UrlDragImageView.this.dUn.onTouch(view, motionEvent);
                                    }
                                    switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                                        case 0:
                                            UrlDragImageView.this.dUp = motionEvent.getY();
                                            UrlDragImageView.this.dTO.setOnClickListener(UrlDragImageView.this.dUo ? UrlDragImageView.this.mOnClickListener : null);
                                            UrlDragImageView.this.dTO.setOnLongClickListener(UrlDragImageView.this.dUo ? UrlDragImageView.this.mLongClickListener : null);
                                            break;
                                        case 1:
                                        case 3:
                                            if (UrlDragImageView.this.dTO.getScale() < measuredWidth) {
                                                UrlDragImageView.this.dTO.setScaleAndCenter(measuredWidth, pointF);
                                            }
                                            e.lb().removeCallbacks(UrlDragImageView.this.dUu);
                                            e.lb().postDelayed(UrlDragImageView.this.dUu, 1000L);
                                            break;
                                        case 2:
                                            if (Math.abs(motionEvent.getY() - UrlDragImageView.this.dUp) > UrlDragImageView.TOUCH_SLOP) {
                                                UrlDragImageView.this.dUo = false;
                                                UrlDragImageView.this.dTO.setOnClickListener(null);
                                                UrlDragImageView.this.dTO.setOnLongClickListener(null);
                                            }
                                            UrlDragImageView.this.dUp = motionEvent.getY();
                                            break;
                                    }
                                    return false;
                                }
                            });
                            UrlDragImageView.this.dTM.setVisibility(4);
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
            this.dTO.setOnImageEventListener(this.dTP);
            if (this.dTO.isImageLoaded() && this.dRf.isLongPic) {
                this.dTP.onImageLoaded();
            } else {
                this.dTO.setImage(ImageSource.uri(str));
            }
            return true;
        }
        return false;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.dUb = dVar;
        if (this.dTM != null) {
            this.dTM.setDragToExitListener(dVar);
        }
    }

    public void aVA() {
        hq(false);
    }

    private boolean vU(String str) {
        return j.isNetWorkAvailable() || com.baidu.tbadk.core.util.c.c.uV(str);
    }

    private void setThumbBitmapToView(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap rawBitmap;
        if (!this.dTS && aVar != null && (rawBitmap = aVar.getRawBitmap()) != null) {
            this.dTR = true;
            if (aVar.isGif()) {
                this.dTM.setImageUrlData(this.dRf);
                this.dTM.setImageBitmap(rawBitmap);
                this.dUq = null;
                this.dUl = false;
            } else {
                if (this.dRf != null && this.dRf.isLongPic) {
                    this.dTM.createLargeImageDelegate();
                    this.dTM.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.13
                        @Override // com.baidu.tbadk.widget.largeImage.logic.a
                        public void onLoadFinished() {
                        }
                    });
                }
                this.dTM.setImageUrlData(this.dRf);
                this.dTM.setImageData(rawBitmap, aVar.getByteData());
            }
            aVx();
        }
    }

    private void e(String str, boolean z, boolean z2) {
        if (vV(str)) {
            if (z2 || (!this.dTT && !this.dTS)) {
                if (!z2 || !hq(true)) {
                    this.dTT = true;
                    com.baidu.adp.lib.e.c.kV().a(str, 27, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.14
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.b
                        public void onCancelled(String str2) {
                            UrlDragImageView.this.dTT = false;
                            UrlDragImageView.this.dTM.setVisibility(0);
                            UrlDragImageView.this.mProgressBar.setVisibility(8);
                            UrlDragImageView.this.dUq = null;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            UrlDragImageView.this.dTT = false;
                            UrlDragImageView.this.dTS = true;
                            UrlDragImageView.this.b(aVar);
                        }
                    }, 0, 0, false, null, Boolean.valueOf(z), this.dTM.getImageData(), Boolean.valueOf(this.dSr));
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
        imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.aO(this.mMaxWidth, this.mMaxHeight));
        com.baidu.adp.widget.ImageView.a a2 = this.dUm.a(imageFileInfo, false);
        if (a2 != null) {
            this.dTS = true;
            this.mProgressBar.setVisibility(8);
            this.dUq = null;
            b(a2);
            return;
        }
        this.dUm.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.2
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.ImageView.a aVar, String str2, boolean z3) {
                UrlDragImageView.this.dTS = true;
                UrlDragImageView.this.mProgressBar.setVisibility(8);
                UrlDragImageView.this.dUq = null;
                UrlDragImageView.this.b(aVar);
            }
        }, false);
    }

    private boolean vV(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null && this.dTQ != null) {
            this.dTQ.k(aVar.getUrl(), aVar.getByteData());
        }
        if (aVar == null || aVar.getRawBitmap() == null) {
            aVB();
            return;
        }
        Bitmap rawBitmap = aVar.getRawBitmap();
        this.dTM.setLoadBigImage(true);
        if (aVar.isGif()) {
            this.dTM.setGifData(aVar.getByteData(), rawBitmap);
            this.dTM.invalidate();
            this.dTM.play();
            this.dUl = false;
            this.dUq = null;
            this.mProgressBar.setVisibility(8);
        } else {
            if (this.dRf != null && this.dRf.isLongPic) {
                this.dTM.createLargeImageDelegate();
                this.dTM.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.3
                    @Override // com.baidu.tbadk.widget.largeImage.logic.a
                    public void onLoadFinished() {
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.dUq = null;
                    }
                });
            } else {
                this.mProgressBar.setVisibility(8);
                this.dUq = null;
            }
            this.dTM.setImageUrlData(this.dRf);
            this.dTM.setImageData(rawBitmap, aVar.getByteData());
            aVG();
        }
        aVx();
    }

    private void aVB() {
        if (!this.dTR) {
            this.dTM.setDefaultBitmap();
        } else {
            this.dTS = false;
        }
        this.dUq = null;
        this.mProgressBar.setVisibility(8);
    }

    public void setGifMaxUseableMem(int i) {
        this.dTM.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.dTM != null) {
            this.dTM.onDestroy();
        }
        if (this.dTO != null) {
            this.dTO.recycle();
        }
        if (this.dTW != null) {
            this.dTW.recycle();
            this.dTW = null;
        }
        if (this.mProgressBar != null) {
            this.dUq = null;
            this.mProgressBar.setVisibility(8);
        }
        e.lb().removeCallbacks(this.dUu);
        com.baidu.tieba.view.c.deD().setColor(-1);
    }

    public void release() {
        if (this.dTM != null) {
            this.dTM.release();
        }
        if (this.mProgressBar != null) {
            this.dUq = null;
            this.mProgressBar.setVisibility(8);
        }
        this.dUq = null;
    }

    public void aVC() {
        if (this.dTM != null && this.dTM.getImageType() == 1) {
            this.dTM.stop();
        }
    }

    public void x(boolean z, boolean z2) {
        String str;
        if (this.dTM != null && (str = (String) this.dTM.getTag()) != null) {
            if (this.dTM.getImageType() == 1) {
                if (this.dTM.getGifCache() == null || !this.dTM.isLoadBigImage()) {
                    e(str, z, z2);
                }
            } else if (this.dTM.getImageType() == 2) {
                e(str, z, z2);
            } else if (aVD()) {
                e(str, z, z2);
            }
        }
    }

    private boolean aVD() {
        if (this.dTM.getImageBitmap() != null && this.dTM.isLoadBigImage()) {
            if (this.dRf == null || !this.dRf.isLongPic || this.dTM.hasLoadLongImage()) {
                return false;
            }
            this.dTS = false;
            this.dUj = false;
            return true;
        }
        return true;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.dRf = imageUrlData;
    }

    public ImageUrlData getmAssistUrlData() {
        return this.dRf;
    }

    public void setIsCdn(boolean z) {
        this.dSr = z;
    }

    public void aVE() {
        final String nameMd5FromUrl = as.getNameMd5FromUrl(this.dRf.originalUrl);
        if (this.dRf.originalProcess >= 0) {
            com.baidu.tbadk.download.d.aWL().cancelDownLoadById(nameMd5FromUrl, 13);
            this.dRf.originalProcess = -1;
            aVG();
            return;
        }
        if (this.dSk != null) {
            this.dSk.aVJ();
        }
        com.baidu.adp.base.e<?> T = i.T(this.mContext);
        if (T == null) {
            vW(nameMd5FromUrl);
        } else if (!j.isNetWorkAvailable() || j.isWifiNet() || com.baidu.tbadk.core.sharedPref.b.aNV().getBoolean(SharedPrefConfig.ORIGINAL_IMG_DOWN_TIP, false)) {
            vW(nameMd5FromUrl);
        } else {
            com.baidu.tbadk.core.sharedPref.b.aNV().putBoolean(SharedPrefConfig.ORIGINAL_IMG_DOWN_TIP, true);
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(T.getPageActivity());
            aVar.kd(R.string.original_img_down_no_wifi_tip);
            aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    UrlDragImageView.this.vW(nameMd5FromUrl);
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                }
            });
            aVar.b(T);
            aVar.aMU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vW(String str) {
        if (this.dRf != null) {
            this.dRf.originalProcess = 0;
            this.dUr.setProgress(0);
            this.dUr.setVisibility(0);
            DownloadData downloadData = new DownloadData(str);
            downloadData.setStatus(1);
            downloadData.setUrl(this.dRf.originalUrl);
            downloadData.setType(13);
            downloadData.setPath(this.dUc + ap.aOS().uJ(str) + "/" + str);
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.6
                @Override // com.baidu.tbadk.download.c
                public boolean onPreDownload(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2 != null) {
                        if (UrlDragImageView.this.dRf != null && UrlDragImageView.this.dRf.originalProcess != -1) {
                            UrlDragImageView.this.dRf.originalProcess = downloadData2.getProcess();
                        }
                        if (UrlDragImageView.this.dRf == null || UrlDragImageView.this.dRf.originalProcess != -1) {
                            UrlDragImageView.this.dUr.setProgress(downloadData2.getProcess());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public boolean onFileDownloaded(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadSucceed(DownloadData downloadData2) {
                    UrlDragImageView.this.dUr.setVisibility(8);
                    e.lb().postDelayed(UrlDragImageView.this.dUv, 1500L);
                    UrlDragImageView.this.dUj = false;
                    UrlDragImageView.this.dUi = UrlDragImageView.this.aVF();
                    UrlDragImageView.this.aVA();
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str2) {
                    UrlDragImageView.this.dUr.setVisibility(8);
                    UrlDragImageView.this.dUj = false;
                    BdToast.b(UrlDragImageView.this.mContext, str2).aMY().aMZ();
                    UrlDragImageView.this.dRf.originalProcess = -1;
                    UrlDragImageView.this.aVG();
                }
            });
            com.baidu.tbadk.download.d.aWL().a(downloadData, 100);
            this.dUs = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aVF() {
        if (this.dRf != null && !StringUtils.isNull(this.dRf.originalUrl, true) && this.dRf.originalSize >= 0 && !this.dRf.isBlockedPic) {
            String nameMd5FromUrl = as.getNameMd5FromUrl(this.dRf.originalUrl);
            File file = new File(this.dUc + ap.aOS().uJ(nameMd5FromUrl) + "/" + nameMd5FromUrl);
            if (file != null && file.exists()) {
                this.dRf.originalProcess = 100;
                return true;
            }
            if (this.dRf.originalProcess < 0) {
                aVG();
            } else {
                this.dUr.setProgress(this.dRf.originalProcess);
            }
            this.dUl = true;
        } else {
            this.dUq = null;
        }
        return false;
    }

    public void aVG() {
        if (this.dRf != null) {
            if (!aVH() || !this.dUl) {
                this.dUq = null;
            } else if (this.dRf.originalSize > 0 && !co(this.dRf.originalSize)) {
                this.dUq = dTK + "(" + aq.getFormatSize(this.dRf.originalSize) + ")";
            } else {
                this.dUq = dTK;
            }
        }
    }

    private boolean aVH() {
        return (this.dRf == null || !this.dRf.mIsShowOrigonButton || this.dRf.isBlockedPic || StringUtils.isNull(this.dRf.originalUrl)) ? false : true;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.dSk = bVar;
    }

    private boolean co(long j) {
        return j > dTL;
    }
}
