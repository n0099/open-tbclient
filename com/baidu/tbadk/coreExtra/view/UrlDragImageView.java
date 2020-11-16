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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.aw;
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
/* loaded from: classes20.dex */
public class UrlDragImageView extends RelativeLayout {
    private ImageUrlData fgQ;
    private b fhM;
    private boolean fhT;
    private boolean fhV;
    private boolean fjA;
    private boolean fjB;
    private Bitmap fjC;
    private RectF fjD;
    private Rect fjE;
    private Rect fjF;
    private Rect fjG;
    private DragImageView.d fjH;
    private String fjI;
    private float fjJ;
    private float fjK;
    private float fjL;
    private float fjM;
    private float fjN;
    private boolean fjO;
    private boolean fjP;
    private boolean fjQ;
    public boolean fjR;
    private com.baidu.tbadk.img.b fjS;
    private View.OnTouchListener fjT;
    private boolean fjU;
    private float fjV;
    private String fjW;
    private CircleProgressView fjX;
    private boolean fjY;
    private boolean fjZ;
    protected DragImageView fjs;
    protected TextView fjt;
    protected SubsamplingScaleImageView fju;
    private SubsamplingScaleImageView.OnImageEventListener fjv;
    private a fjw;
    private boolean fjx;
    private boolean fjy;
    private boolean fjz;
    private Runnable fka;
    private Runnable fkb;
    private View.OnTouchListener fkc;
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
    private static final String fjq = TbadkCoreApplication.getInst().getString(R.string.original_img_look);
    private static long fjr = Config.RAVEN_LOG_LIMIT;
    private static final int EXIT_DISTANCE = l.getEquipmentHeight(TbadkCoreApplication.getInst()) / 5;
    private static final String TAG = UrlDragImageView.class.getSimpleName();
    private static final int TOUCH_SLOP = ViewConfiguration.get(TbadkCoreApplication.getInst()).getScaledTouchSlop();

    /* loaded from: classes20.dex */
    public interface a {
        void k(String str, byte[] bArr);
    }

    /* loaded from: classes20.dex */
    public interface b {
        void bxB();
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
        if (this.fjs != null) {
            this.fjs.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.fjw = aVar;
    }

    public UrlDragImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.fjs = null;
        this.fjw = null;
        this.fhT = false;
        this.fjz = false;
        this.isInDragScaleMode = false;
        this.mRatio = 1.0f;
        this.mMoveDistance = 0.0f;
        this.mDragMatrix = new Matrix();
        this.mDstRect = new RectF();
        this.fjJ = 0.0f;
        this.fjK = 0.0f;
        this.fjL = 1.0f;
        this.fjM = 1.0f;
        this.fjN = 0.0f;
        this.fjO = false;
        this.fjP = false;
        this.fjQ = false;
        this.fjR = false;
        this.fjU = true;
        this.fjV = 0.0f;
        this.mOnClickListener = null;
        this.mLongClickListener = null;
        this.fjW = null;
        this.fka = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.fjU = true;
            }
        };
        this.fkb = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.fjX.setVisibility(8);
                        UrlDragImageView.this.fjW = null;
                        UrlDragImageView.this.fjR = false;
                    }
                });
            }
        };
        this.fkc = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.fjT != null) {
                    UrlDragImageView.this.fjT.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.fjS = new com.baidu.tbadk.img.b();
        init();
    }

    public UrlDragImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.fjs = null;
        this.fjw = null;
        this.fhT = false;
        this.fjz = false;
        this.isInDragScaleMode = false;
        this.mRatio = 1.0f;
        this.mMoveDistance = 0.0f;
        this.mDragMatrix = new Matrix();
        this.mDstRect = new RectF();
        this.fjJ = 0.0f;
        this.fjK = 0.0f;
        this.fjL = 1.0f;
        this.fjM = 1.0f;
        this.fjN = 0.0f;
        this.fjO = false;
        this.fjP = false;
        this.fjQ = false;
        this.fjR = false;
        this.fjU = true;
        this.fjV = 0.0f;
        this.mOnClickListener = null;
        this.mLongClickListener = null;
        this.fjW = null;
        this.fka = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.fjU = true;
            }
        };
        this.fkb = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.fjX.setVisibility(8);
                        UrlDragImageView.this.fjW = null;
                        UrlDragImageView.this.fjR = false;
                    }
                });
            }
        };
        this.fkc = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.fjT != null) {
                    UrlDragImageView.this.fjT.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.fjS = new com.baidu.tbadk.img.b();
        init();
    }

    public DragImageView getImageView() {
        return this.fjs;
    }

    public void setGifSetListener(DragImageView.e eVar) {
        this.fjs.setGifSetListener(eVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.fjs.setImageOnClickListener(onClickListener);
        this.fju.setOnClickListener(onClickListener);
        this.mOnClickListener = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mLongClickListener = onLongClickListener;
        if (!this.fhV) {
            this.fjs.setImageOnLongClickListener(this.mLongClickListener);
            this.fju.setOnLongClickListener(this.mLongClickListener);
        }
    }

    public void setOnSizeChangedListener(final DragImageView.g gVar) {
        this.fjs.setOnSizeChangedListener(new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.8
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (gVar != null) {
                    gVar.a(dragImageView, z, z2);
                }
                UrlDragImageView.this.bxp();
            }
        });
    }

    protected void init() {
        this.fjI = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        this.mMaxWidth = l.getEquipmentWidth(this.mContext);
        this.mMaxHeight = l.getEquipmentHeight(this.mContext) - ((int) this.mContext.getResources().getDimension(R.dimen.ds166));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.fjs = new DragImageView(this.mContext);
        this.fjs.setLayoutParams(layoutParams);
        this.fjs.setOnTouchListener(this.fkc);
        addView(this.fjs);
        this.fju = new SubsamplingScaleImageView(this.mContext);
        this.fju.setMaxScale(50.0f);
        this.fju.setOnTouchListener(this.fkc);
        this.fju.setVisibility(4);
        addView(this.fju, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(getResources().getDrawable(R.drawable.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        bxo();
        this.fjZ = TbSingleton.getInstance().isCutoutScreen(TbadkApplication.getInst().getCurrentActivity());
    }

    private void bxo() {
        this.fjX = new CircleProgressView(this.mContext);
        this.fjX.setCircleBackgroundColor(ap.getColor(R.color.CAM_X0109));
        this.fjX.setCircleForegroundColor(ap.getColor(R.color.CAM_X0302));
        this.fjX.setProgress(0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds80), l.getDimens(getContext(), R.dimen.tbds80));
        layoutParams.addRule(13);
        this.fjX.setVisibility(8);
        addView(this.fjX, layoutParams);
    }

    public void setIsCanDrag(boolean z) {
        this.fhV = z;
    }

    public String getmCheckOriginPicText() {
        return this.fjW;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        Bitmap imageBitmap;
        int height;
        int width;
        if (this.fjO && !this.fjY && this.fju.getVisibility() == 0 && !this.fju.isImageLoaded()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.fhV || !this.fjy) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.fjA && motionEvent.getPointerCount() >= 2) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.fjA || this.fjB) {
            requestDisallowInterceptTouchEvent(true);
        }
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        float x = motionEvent.getX();
        int i = action & 255;
        if (i == 0) {
            if (this.fjC == null) {
                if (this.fju.getVisibility() == 0) {
                    this.fjC = h.bJ(this.fju);
                } else {
                    this.fjC = h.bJ(this.fjs);
                }
            }
            if (this.mDisplayRect == null && this.fjC != null) {
                int measuredWidth = getMeasuredWidth();
                float measuredWidth2 = ((getMeasuredWidth() * 1.0f) / this.fjC.getWidth()) * this.fjC.getHeight();
                if (measuredWidth2 > getMeasuredHeight()) {
                    measuredWidth2 = getMeasuredHeight();
                }
                RectF rectInScreenFromPosition = getRectInScreenFromPosition(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
                this.mDisplayRect = new Rect((int) rectInScreenFromPosition.left, (int) rectInScreenFromPosition.top, (int) rectInScreenFromPosition.right, (int) rectInScreenFromPosition.bottom);
            }
            if (this.fjF == null && this.fjC != null) {
                if (this.fju.getVisibility() == 0) {
                    height = this.fju.getSHeight();
                    width = this.fju.getSWidth();
                } else {
                    if (this.fjs.getImageType() == 1) {
                        imageBitmap = (this.fjs.getCurrentFrame() == null || this.fjs.getCurrentFrame().bm == null) ? this.fjC : this.fjs.getCurrentFrame().bm;
                    } else {
                        imageBitmap = this.fjs.getImageBitmap() == null ? this.fjC : this.fjs.getImageBitmap();
                    }
                    height = imageBitmap.getHeight();
                    width = imageBitmap.getWidth();
                }
                float equipmentDensity = l.getEquipmentDensity(getContext());
                int i2 = (int) (height * equipmentDensity);
                int i3 = (int) (width * equipmentDensity);
                if (i3 > this.fjC.getWidth() && this.fjC.getWidth() != 0) {
                    float width2 = (i3 * 1.0f) / this.fjC.getWidth();
                    i3 = this.fjC.getWidth();
                    i2 = (int) (i2 / width2);
                }
                if (i2 > this.fjC.getHeight() && this.fjC.getHeight() != 0) {
                    i3 = (int) (i3 / ((i2 * 1.0f) / this.fjC.getHeight()));
                    i2 = this.fjC.getHeight();
                }
                int equipmentHeight = (l.getEquipmentHeight(getContext()) - i2) / 2;
                int equipmentWidth = (l.getEquipmentWidth(getContext()) - i3) / 2;
                this.fjF = new Rect(equipmentWidth, equipmentHeight, i3 + equipmentWidth, i2 + equipmentHeight);
                this.fjG = new Rect(this.fjF);
                this.fjN = equipmentHeight / l.getEquipmentHeight(getContext());
                this.fjE = new Rect(0, 0, this.fjC.getWidth(), this.fjC.getHeight());
            }
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (i == 2) {
            this.fjA = w(this.mLastMotionX - x, this.mLastMotionY - y);
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (this.fjA || this.fjB) {
            this.fjs.setImageOnLongClickListener(null);
            this.fju.setOnLongClickListener(null);
            z = true;
        } else {
            this.fjs.setImageOnLongClickListener(this.mLongClickListener);
            this.fju.setOnLongClickListener(this.mLongClickListener);
            z = super.dispatchTouchEvent(motionEvent);
        }
        if (i == 1 || i == 3) {
            this.mLastMotionX = 0.0f;
            this.mLastMotionY = 0.0f;
            boolean z2 = (-this.mMoveDistance) > ((float) EXIT_DISTANCE);
            boolean z3 = this.mMoveDistance > ((float) EXIT_DISTANCE);
            if (z2 || z3) {
                this.fjB = true;
                startExitAnimation();
                if (z2) {
                    TiebaStatic.log(new ar("c13377").dR("obj_type", "3"));
                } else if (z3) {
                    TiebaStatic.log(new ar("c13377").dR("obj_type", "2"));
                }
            } else {
                if (this.fjA && this.fjH != null) {
                    this.fjH.bDD();
                }
                this.mRatio = 1.0f;
                invalidate();
            }
            this.isInDragScaleMode = false;
            this.mDragMatrix.reset();
            this.fjA = false;
        }
        return z;
    }

    private boolean w(float f, float f2) {
        if (this.fju.getVisibility() != 0 || this.fju.isCanDrag()) {
            if (this.fgQ == null || !this.fgQ.isLongPic || this.fju.getVisibility() != 0 || this.fju.isViewTop()) {
                if (this.fgQ == null || !this.fgQ.isLongPic || this.fju.getVisibility() == 0 || this.fjs.isAtViewTop() || this.fjs.bDB()) {
                    if (this.fju.getVisibility() == 0 || this.fjs.pagerCantScroll()) {
                        if (this.fjC != null && getScrollY() == 0) {
                            boolean z = (this.fgQ == null || !this.fgQ.isLongPic) && ((f2 < -15.0f && !this.isInDragScaleMode) || (f2 > 15.0f && !this.isInDragScaleMode));
                            boolean z2 = this.fgQ != null && this.fgQ.isLongPic && f2 < 0.0f && !this.isInDragScaleMode;
                            if (z || (z2 && this.fjs.isViewTop())) {
                                this.fjs.setImageOnLongClickListener(null);
                                this.fju.setOnLongClickListener(null);
                                this.isInDragScaleMode = true;
                                this.mMoveDistance = 0.0f;
                                this.mRatio = 1.0f;
                                if (this.fjH != null) {
                                    this.fjH.onDragStart();
                                }
                            }
                        }
                        if (!this.isInDragScaleMode || this.fjC == null) {
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
                        this.mDragMatrix.preScale(1.0f + f3, 1.0f + f3, (this.mRatio * this.fjC.getWidth()) / 2.0f, this.mRatio * (this.fjC.getHeight() / 2));
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
        if (this.fjA && this.fjC != null && !this.fjC.isRecycled() && this.isInDragScaleMode) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.mDstRect == null) {
                this.mDstRect = new RectF();
            }
            this.mDragMatrix.mapRect(this.mDstRect, new RectF(this.mDisplayRect));
            canvas.drawBitmap(this.fjC, this.fjE, this.mDstRect, (Paint) null);
        } else if (this.fjB && this.fjC != null && !this.fjC.isRecycled()) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.fgQ == null || this.fgQ.getSourceImageRectInScreen() == null) {
                canvas.drawBitmap(this.fjC, this.fjE, this.mDstRect, (Paint) null);
            } else {
                canvas.drawBitmap(this.fjC, this.fjF, this.mDstRect, (Paint) null);
            }
        } else {
            super.dispatchDraw(canvas);
        }
    }

    private void startExitAnimation() {
        if (this.fgQ == null) {
            if (this.fjH != null) {
                this.fjH.onDragEnd();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.fgQ.getSourceImageRectInScreen();
        final Rect dstRectInScreen = this.fgQ.getDstRectInScreen();
        if (sourceImageRectInScreen == null || dstRectInScreen == null) {
            if (this.fjH != null) {
                this.fjH.onDragEnd();
                return;
            }
            return;
        }
        a(sourceImageRectInScreen, dstRectInScreen);
        b(sourceImageRectInScreen);
        this.fjD = new RectF(this.mDstRect);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(150L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && sourceImageRectInScreen != null && dstRectInScreen != null) {
                    UrlDragImageView.this.am(valueAnimator.getAnimatedFraction());
                    UrlDragImageView.this.a(dstRectInScreen, valueAnimator.getAnimatedFraction(), UrlDragImageView.this.fjZ);
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
                if (UrlDragImageView.this.fjH != null) {
                    UrlDragImageView.this.fjH.onDragEnd();
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
            this.mDstRect.top += this.mDstRect.height() * this.fjN;
            this.mDstRect.bottom = f + this.mDstRect.top;
        }
    }

    public void setCanScale(boolean z) {
        if (this.fjs != null) {
            this.fjs.setCanScale(z);
        }
    }

    private void a(Rect rect, Rect rect2) {
        this.fjJ = 0.0f;
        this.fjK = 0.0f;
        this.fjL = 1.0f;
        this.fjM = 1.0f;
        if (rect != null && rect2 != null && rect.contains(rect2)) {
            this.fjJ = (rect2.left - rect.left) / rect.width();
            this.fjK = (rect2.top - rect.top) / rect.height();
            this.fjL = (rect2.right - rect.left) / rect.width();
            this.fjM = (rect2.bottom - rect.top) / rect.height();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void am(float f) {
        if (this.fjF != null) {
            this.fjF.left = (int) (this.fjG.left + (this.fjG.width() * this.fjJ * f));
            this.fjF.top = (int) (this.fjG.top + (this.fjG.height() * this.fjK * f));
            this.fjF.right = (int) (this.fjG.left + (this.fjG.width() * (((1.0f - this.fjL) * (1.0f - f)) + this.fjL)));
            this.fjF.bottom = (int) (this.fjG.top + (this.fjG.height() * (((1.0f - this.fjM) * (1.0f - f)) + this.fjM)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Rect rect, float f, boolean z) {
        int i = 0;
        if (z) {
            i = l.getDimens(getContext(), R.dimen.tbds80);
        }
        if (this.mDstRect != null && rect != null) {
            this.mDstRect.left = this.fjD.left + ((rect.left - this.fjD.left) * f);
            this.mDstRect.top = (this.fjD.top + ((rect.top - this.fjD.top) * f)) - i;
            this.mDstRect.right = this.fjD.right + ((rect.right - this.fjD.right) * f);
            this.mDstRect.bottom = this.fjD.bottom + ((rect.bottom - this.fjD.bottom) * f);
        }
    }

    private RectF getRectInScreenFromPosition(float f, float f2, float f3, float f4) {
        return new RectF(f - (f3 / 2.0f), f2 - (f4 / 2.0f), (f3 / 2.0f) + f, (f4 / 2.0f) + f2);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.fjT = onTouchListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxp() {
        if ((this.fjx || this.fjy) && this.fgQ != null && this.fgQ.mPicType == 1 && !TextUtils.isEmpty(this.fgQ.mTagName)) {
            if (this.fjt != null) {
                this.fjt.setVisibility(8);
                this.fjt = null;
            }
            this.fjt = new TextView(this.mContext);
            this.fjt.setText(this.fgQ.mTagName);
            this.fjt.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize26));
            ap.setViewTextColor(this.fjt, R.color.common_color_10013, 1, 0);
            ap.setBackgroundColor(this.fjt, R.color.common_color_10215);
            this.fjt.setAlpha(0.75f);
            this.fjt.setIncludeFontPadding(false);
            this.fjt.setGravity(17);
            int dimens = l.getDimens(this.mContext, R.dimen.ds2);
            this.fjt.setPadding(dimens, dimens, dimens, dimens);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.fjs.getBottomOffset();
            layoutParams.leftMargin = this.fjs.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.fjt, layoutParams);
            this.fjt.setVisibility(0);
        }
    }

    public void setUrl(String str, boolean z) {
        if (str.contains("*")) {
            str = str.split("[*]")[0];
        }
        this.fjs.setTag(str);
        this.fjs.setLoadBigImage(false);
        this.fjs.setImageDrawable(null);
        this.fjx = false;
        this.fjy = false;
        this.fjO = bxx();
        this.fjW = null;
        if (CH(str)) {
            e(str, z, false);
        }
    }

    private boolean bxq() {
        return this.fjs != null && this.fjs.isLoadBigImage();
    }

    public void bxr() {
        if (this.fgQ != null && !bxq()) {
            String str = this.fgQ.imageUrl;
            int i = this.fgQ.urlType;
            com.baidu.adp.widget.ImageView.a aVar = null;
            if (com.baidu.tbadk.core.util.c.a.am(str, i)) {
                aVar = com.baidu.tbadk.core.util.c.a.an(str, i);
            }
            if (aVar != null) {
                setThumbBitmapToView(aVar);
            }
        }
    }

    private boolean jR(boolean z) {
        String nameMd5FromUrl;
        if (!this.fjP || z) {
            this.fjP = true;
            if (!this.fjO || this.fgQ == null || StringUtils.isNull(this.fgQ.originalUrl, true) || this.fgQ.originalSize < 0 || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String str = this.fjI + at.bqz().Bt(nameMd5FromUrl) + "/" + aw.getNameMd5FromUrl(this.fgQ.originalUrl);
            final int[] imageFileWH = n.getImageFileWH(str);
            this.fju.setVisibility(0);
            if (this.fjv == null) {
                this.fjv = new SubsamplingScaleImageView.OnImageEventListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12
                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onReady() {
                        UrlDragImageView.this.fjW = null;
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.fjs.restoreSize();
                        UrlDragImageView.this.fjs.setVisibility(4);
                    }

                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onImageLoaded() {
                        if (UrlDragImageView.this.fgQ.isLongPic && imageFileWH[0] > 0) {
                            UrlDragImageView.this.fjs.onDestroy();
                            final float measuredWidth = (UrlDragImageView.this.getMeasuredWidth() * 1.0f) / imageFileWH[0];
                            final PointF pointF = new PointF((imageFileWH[0] * 1.0f) / 2.0f, 0.0f);
                            UrlDragImageView.this.fju.setScaleAndCenter(measuredWidth, pointF);
                            UrlDragImageView.this.fju.setMaxScale(2.0f * measuredWidth);
                            UrlDragImageView.this.fju.setDoubleTapZoomScale(2.0f * measuredWidth);
                            UrlDragImageView.this.fju.setInitScale(measuredWidth);
                            UrlDragImageView.this.fju.setDoubleTapZoomStyle(4);
                            UrlDragImageView.this.fju.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12.1
                                @Override // android.view.View.OnTouchListener
                                public boolean onTouch(View view, MotionEvent motionEvent) {
                                    if (UrlDragImageView.this.fjT != null) {
                                        UrlDragImageView.this.fjT.onTouch(view, motionEvent);
                                    }
                                    switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                                        case 0:
                                            UrlDragImageView.this.fjV = motionEvent.getY();
                                            UrlDragImageView.this.fju.setOnClickListener(UrlDragImageView.this.fjU ? UrlDragImageView.this.mOnClickListener : null);
                                            UrlDragImageView.this.fju.setOnLongClickListener(UrlDragImageView.this.fjU ? UrlDragImageView.this.mLongClickListener : null);
                                            break;
                                        case 1:
                                        case 3:
                                            if (UrlDragImageView.this.fju.getScale() < measuredWidth) {
                                                UrlDragImageView.this.fju.setScaleAndCenter(measuredWidth, pointF);
                                            }
                                            e.mY().removeCallbacks(UrlDragImageView.this.fka);
                                            e.mY().postDelayed(UrlDragImageView.this.fka, 1000L);
                                            break;
                                        case 2:
                                            if (Math.abs(motionEvent.getY() - UrlDragImageView.this.fjV) > UrlDragImageView.TOUCH_SLOP) {
                                                UrlDragImageView.this.fjU = false;
                                                UrlDragImageView.this.fju.setOnClickListener(null);
                                                UrlDragImageView.this.fju.setOnLongClickListener(null);
                                            }
                                            UrlDragImageView.this.fjV = motionEvent.getY();
                                            break;
                                    }
                                    return false;
                                }
                            });
                            UrlDragImageView.this.fjs.setVisibility(4);
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
            this.fju.setOnImageEventListener(this.fjv);
            if (this.fju.isImageLoaded() && this.fgQ.isLongPic) {
                this.fjv.onImageLoaded();
            } else {
                this.fju.setImage(ImageSource.uri(str));
            }
            return true;
        }
        return false;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.fjH = dVar;
        if (this.fjs != null) {
            this.fjs.setDragToExitListener(dVar);
        }
    }

    public void bxs() {
        jR(false);
    }

    private boolean CH(String str) {
        return j.isNetWorkAvailable() || com.baidu.tbadk.core.util.c.c.BH(str);
    }

    private void setThumbBitmapToView(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap rawBitmap;
        if (!this.fjy && aVar != null && (rawBitmap = aVar.getRawBitmap()) != null) {
            this.fjx = true;
            if (aVar.isGif()) {
                this.fjs.setImageUrlData(this.fgQ);
                this.fjs.setImageBitmap(rawBitmap);
                this.fjW = null;
                this.fjR = false;
            } else {
                if (this.fgQ != null && this.fgQ.isLongPic) {
                    this.fjs.createLargeImageDelegate();
                    this.fjs.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.13
                        @Override // com.baidu.tbadk.widget.largeImage.logic.a
                        public void onLoadFinished() {
                        }
                    });
                }
                this.fjs.setImageUrlData(this.fgQ);
                this.fjs.setImageData(rawBitmap, aVar.getByteData());
            }
            bxp();
        }
    }

    private void e(String str, boolean z, boolean z2) {
        if (CI(str)) {
            if (z2 || (!this.fjz && !this.fjy)) {
                if (!z2 || !jR(true)) {
                    this.fjz = true;
                    com.baidu.adp.lib.e.c.mS().a(str, 27, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.14
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.b
                        public void onCancelled(String str2) {
                            UrlDragImageView.this.fjz = false;
                            UrlDragImageView.this.fjs.setVisibility(0);
                            UrlDragImageView.this.mProgressBar.setVisibility(8);
                            UrlDragImageView.this.fjW = null;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            UrlDragImageView.this.fjz = false;
                            UrlDragImageView.this.fjy = true;
                            UrlDragImageView.this.b(aVar);
                        }
                    }, 0, 0, false, null, Boolean.valueOf(z), this.fjs.getImageData(), Boolean.valueOf(this.fhT));
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
        imageFileInfo.addPageAction(d.bg(this.mMaxWidth, this.mMaxHeight));
        com.baidu.adp.widget.ImageView.a a2 = this.fjS.a(imageFileInfo, false);
        if (a2 != null) {
            this.fjy = true;
            this.mProgressBar.setVisibility(8);
            this.fjW = null;
            b(a2);
            return;
        }
        this.fjS.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.2
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.ImageView.a aVar, String str2, boolean z3) {
                UrlDragImageView.this.fjy = true;
                UrlDragImageView.this.mProgressBar.setVisibility(8);
                UrlDragImageView.this.fjW = null;
                UrlDragImageView.this.b(aVar);
            }
        }, false);
    }

    private boolean CI(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null && this.fjw != null) {
            this.fjw.k(aVar.getUrl(), aVar.getByteData());
        }
        if (aVar == null || aVar.getRawBitmap() == null) {
            bxt();
            return;
        }
        Bitmap rawBitmap = aVar.getRawBitmap();
        this.fjs.setLoadBigImage(true);
        if (aVar.isGif()) {
            this.fjs.setGifData(aVar.getByteData(), rawBitmap);
            this.fjs.invalidate();
            this.fjs.play();
            this.fjR = false;
            this.fjW = null;
            this.mProgressBar.setVisibility(8);
        } else {
            if (this.fgQ != null && this.fgQ.isLongPic) {
                this.fjs.createLargeImageDelegate();
                this.fjs.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.3
                    @Override // com.baidu.tbadk.widget.largeImage.logic.a
                    public void onLoadFinished() {
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.fjW = null;
                    }
                });
            } else {
                this.mProgressBar.setVisibility(8);
                this.fjW = null;
            }
            this.fjs.setImageUrlData(this.fgQ);
            this.fjs.setImageData(rawBitmap, aVar.getByteData());
            bxy();
        }
        bxp();
    }

    private void bxt() {
        if (!this.fjx) {
            this.fjs.setDefaultBitmap();
        } else {
            this.fjy = false;
        }
        this.fjW = null;
        this.mProgressBar.setVisibility(8);
    }

    public void setGifMaxUseableMem(int i) {
        this.fjs.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.fjs != null) {
            this.fjs.onDestroy();
        }
        if (this.fju != null) {
            this.fju.recycle();
        }
        if (this.fjC != null) {
            this.fjC.recycle();
            this.fjC = null;
        }
        if (this.mProgressBar != null) {
            this.fjW = null;
            this.mProgressBar.setVisibility(8);
        }
        e.mY().removeCallbacks(this.fka);
        com.baidu.tieba.view.c.dSx().setColor(-1);
    }

    public void release() {
        if (this.fjs != null) {
            this.fjs.release();
        }
        if (this.mProgressBar != null) {
            this.fjW = null;
            this.mProgressBar.setVisibility(8);
        }
        this.fjW = null;
    }

    public void bxu() {
        if (this.fjs != null && this.fjs.getImageType() == 1) {
            this.fjs.stop();
        }
    }

    public void E(boolean z, boolean z2) {
        String str;
        if (this.fjs != null && (str = (String) this.fjs.getTag()) != null) {
            if (this.fjs.getImageType() == 1) {
                if (this.fjs.getGifCache() == null || !this.fjs.isLoadBigImage()) {
                    e(str, z, z2);
                }
            } else if (this.fjs.getImageType() == 2) {
                e(str, z, z2);
            } else if (bxv()) {
                e(str, z, z2);
            }
        }
    }

    private boolean bxv() {
        if (this.fjs.getImageBitmap() != null && this.fjs.isLoadBigImage()) {
            if (this.fgQ == null || !this.fgQ.isLongPic || this.fjs.hasLoadLongImage()) {
                return false;
            }
            this.fjy = false;
            this.fjP = false;
            return true;
        }
        return true;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.fgQ = imageUrlData;
    }

    public ImageUrlData getmAssistUrlData() {
        return this.fgQ;
    }

    public void setIsCdn(boolean z) {
        this.fhT = z;
    }

    public void bxw() {
        final String nameMd5FromUrl = aw.getNameMd5FromUrl(this.fgQ.originalUrl);
        if (this.fgQ.originalProcess >= 0) {
            com.baidu.tbadk.download.d.byJ().cancelDownLoadById(nameMd5FromUrl, 13);
            this.fgQ.originalProcess = -1;
            bxy();
            return;
        }
        if (this.fhM != null) {
            this.fhM.bxB();
        }
        com.baidu.adp.base.e<?> I = i.I(this.mContext);
        if (I == null) {
            CJ(nameMd5FromUrl);
        } else if (!j.isNetWorkAvailable() || j.isWifiNet() || com.baidu.tbadk.core.sharedPref.b.bpu().getBoolean(SharedPrefConfig.ORIGINAL_IMG_DOWN_TIP, false)) {
            CJ(nameMd5FromUrl);
        } else {
            com.baidu.tbadk.core.sharedPref.b.bpu().putBoolean(SharedPrefConfig.ORIGINAL_IMG_DOWN_TIP, true);
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(I.getPageActivity());
            aVar.os(R.string.original_img_down_no_wifi_tip);
            aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    UrlDragImageView.this.CJ(nameMd5FromUrl);
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                }
            });
            aVar.b(I);
            aVar.bog();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CJ(String str) {
        if (this.fgQ != null) {
            this.fgQ.originalProcess = 0;
            this.fjX.setProgress(0);
            this.fjX.setVisibility(0);
            DownloadData downloadData = new DownloadData(str);
            downloadData.setStatus(1);
            downloadData.setUrl(this.fgQ.originalUrl);
            downloadData.setType(13);
            downloadData.setPath(this.fjI + at.bqz().Bt(str) + "/" + str);
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.6
                @Override // com.baidu.tbadk.download.c
                public boolean onPreDownload(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2 != null) {
                        if (UrlDragImageView.this.fgQ != null && UrlDragImageView.this.fgQ.originalProcess != -1) {
                            UrlDragImageView.this.fgQ.originalProcess = downloadData2.getProcess();
                        }
                        if (UrlDragImageView.this.fgQ == null || UrlDragImageView.this.fgQ.originalProcess != -1) {
                            UrlDragImageView.this.fjX.setProgress(downloadData2.getProcess());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public boolean onFileDownloaded(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadSucceed(DownloadData downloadData2) {
                    UrlDragImageView.this.fjX.setVisibility(8);
                    e.mY().postDelayed(UrlDragImageView.this.fkb, 1500L);
                    UrlDragImageView.this.fjP = false;
                    UrlDragImageView.this.fjO = UrlDragImageView.this.bxx();
                    UrlDragImageView.this.bxs();
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str2) {
                    UrlDragImageView.this.fjX.setVisibility(8);
                    UrlDragImageView.this.fjP = false;
                    BdToast.b(UrlDragImageView.this.mContext, str2).bol().bom();
                    UrlDragImageView.this.fgQ.originalProcess = -1;
                    UrlDragImageView.this.bxy();
                }
            });
            com.baidu.tbadk.download.d.byJ().a(downloadData, 100);
            this.fjY = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bxx() {
        if (this.fgQ != null && !StringUtils.isNull(this.fgQ.originalUrl, true) && this.fgQ.originalSize >= 0 && !this.fgQ.isBlockedPic) {
            String nameMd5FromUrl = aw.getNameMd5FromUrl(this.fgQ.originalUrl);
            File file = new File(this.fjI + at.bqz().Bt(nameMd5FromUrl) + "/" + nameMd5FromUrl);
            if (file != null && file.exists()) {
                this.fgQ.originalProcess = 100;
                return true;
            }
            if (this.fgQ.originalProcess < 0) {
                bxy();
            } else {
                this.fjX.setProgress(this.fgQ.originalProcess);
            }
            this.fjR = true;
        } else {
            this.fjW = null;
        }
        return false;
    }

    public void bxy() {
        if (this.fgQ != null) {
            if (!bxz() || !this.fjR) {
                this.fjW = null;
            } else if (this.fgQ.originalSize > 0 && !dE(this.fgQ.originalSize)) {
                this.fjW = fjq + "(" + au.getFormatSize(this.fgQ.originalSize) + ")";
            } else {
                this.fjW = fjq;
            }
        }
    }

    private boolean bxz() {
        return (this.fgQ == null || !this.fgQ.mIsShowOrigonButton || this.fgQ.isBlockedPic || StringUtils.isNull(this.fgQ.originalUrl)) ? false : true;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.fhM = bVar;
    }

    private boolean dE(long j) {
        return j > fjr;
    }
}
