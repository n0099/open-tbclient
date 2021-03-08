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
import com.baidu.adp.base.f;
import com.baidu.adp.lib.e.d;
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
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.File;
/* loaded from: classes.dex */
public class UrlDragImageView extends RelativeLayout {
    private boolean fAa;
    private boolean fAb;
    private boolean fAc;
    public boolean fAd;
    private com.baidu.tbadk.img.b fAe;
    private View.OnTouchListener fAf;
    private boolean fAg;
    private float fAh;
    private String fAi;
    private CircleProgressView fAj;
    private boolean fAk;
    private boolean fAl;
    private Runnable fAm;
    private Runnable fAn;
    private View.OnTouchListener fAo;
    private ImageUrlData fxh;
    private b fyb;
    private boolean fyi;
    private boolean fyk;
    protected DragImageView fzE;
    protected TextView fzF;
    protected SubsamplingScaleImageView fzG;
    private SubsamplingScaleImageView.OnImageEventListener fzH;
    private a fzI;
    private boolean fzJ;
    private boolean fzK;
    private boolean fzL;
    private boolean fzM;
    private boolean fzN;
    private Bitmap fzO;
    private RectF fzP;
    private Rect fzQ;
    private Rect fzR;
    private Rect fzS;
    private DragImageView.d fzT;
    private String fzU;
    private float fzV;
    private float fzW;
    private float fzX;
    private float fzY;
    private float fzZ;
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
    private static final String fzC = TbadkCoreApplication.getInst().getString(R.string.original_img_look);
    private static long fzD = Config.RAVEN_LOG_LIMIT;
    private static final int EXIT_DISTANCE = l.getEquipmentHeight(TbadkCoreApplication.getInst()) / 5;
    private static final String TAG = UrlDragImageView.class.getSimpleName();
    private static final int TOUCH_SLOP = ViewConfiguration.get(TbadkCoreApplication.getInst()).getScaledTouchSlop();

    /* loaded from: classes.dex */
    public interface a {
        void k(String str, byte[] bArr);
    }

    /* loaded from: classes.dex */
    public interface b {
        void bzX();
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
        if (this.fzE != null) {
            this.fzE.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.fzI = aVar;
    }

    public UrlDragImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.fzE = null;
        this.fzI = null;
        this.fyi = false;
        this.fzL = false;
        this.isInDragScaleMode = false;
        this.mRatio = 1.0f;
        this.mMoveDistance = 0.0f;
        this.mDragMatrix = new Matrix();
        this.mDstRect = new RectF();
        this.fzV = 0.0f;
        this.fzW = 0.0f;
        this.fzX = 1.0f;
        this.fzY = 1.0f;
        this.fzZ = 0.0f;
        this.fAa = false;
        this.fAb = false;
        this.fAc = false;
        this.fAd = false;
        this.fAg = true;
        this.fAh = 0.0f;
        this.mOnClickListener = null;
        this.mLongClickListener = null;
        this.fAi = null;
        this.fAm = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.fAg = true;
            }
        };
        this.fAn = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.fAj.setVisibility(8);
                        UrlDragImageView.this.fAi = null;
                        UrlDragImageView.this.fAd = false;
                    }
                });
            }
        };
        this.fAo = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.fAf != null) {
                    UrlDragImageView.this.fAf.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.fAe = new com.baidu.tbadk.img.b();
        init();
    }

    public UrlDragImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.fzE = null;
        this.fzI = null;
        this.fyi = false;
        this.fzL = false;
        this.isInDragScaleMode = false;
        this.mRatio = 1.0f;
        this.mMoveDistance = 0.0f;
        this.mDragMatrix = new Matrix();
        this.mDstRect = new RectF();
        this.fzV = 0.0f;
        this.fzW = 0.0f;
        this.fzX = 1.0f;
        this.fzY = 1.0f;
        this.fzZ = 0.0f;
        this.fAa = false;
        this.fAb = false;
        this.fAc = false;
        this.fAd = false;
        this.fAg = true;
        this.fAh = 0.0f;
        this.mOnClickListener = null;
        this.mLongClickListener = null;
        this.fAi = null;
        this.fAm = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.fAg = true;
            }
        };
        this.fAn = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.fAj.setVisibility(8);
                        UrlDragImageView.this.fAi = null;
                        UrlDragImageView.this.fAd = false;
                    }
                });
            }
        };
        this.fAo = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.fAf != null) {
                    UrlDragImageView.this.fAf.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.fAe = new com.baidu.tbadk.img.b();
        init();
    }

    public DragImageView getImageView() {
        return this.fzE;
    }

    public void setGifSetListener(DragImageView.e eVar) {
        this.fzE.setGifSetListener(eVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.fzE.setImageOnClickListener(onClickListener);
        this.fzG.setOnClickListener(onClickListener);
        this.mOnClickListener = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mLongClickListener = onLongClickListener;
        if (!this.fyk) {
            this.fzE.setImageOnLongClickListener(this.mLongClickListener);
            this.fzG.setOnLongClickListener(this.mLongClickListener);
        }
    }

    public void setOnSizeChangedListener(final DragImageView.g gVar) {
        this.fzE.setOnSizeChangedListener(new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.8
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (gVar != null) {
                    gVar.a(dragImageView, z, z2);
                }
                UrlDragImageView.this.bzL();
            }
        });
    }

    protected void init() {
        this.fzU = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        this.mMaxWidth = l.getEquipmentWidth(this.mContext);
        this.mMaxHeight = l.getEquipmentHeight(this.mContext) - ((int) this.mContext.getResources().getDimension(R.dimen.ds166));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.fzE = new DragImageView(this.mContext);
        this.fzE.setLayoutParams(layoutParams);
        this.fzE.setOnTouchListener(this.fAo);
        addView(this.fzE);
        this.fzG = new SubsamplingScaleImageView(this.mContext);
        this.fzG.setMaxScale(50.0f);
        this.fzG.setOnTouchListener(this.fAo);
        this.fzG.setVisibility(4);
        addView(this.fzG, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(getResources().getDrawable(R.drawable.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        bzK();
        this.fAl = TbSingleton.getInstance().isCutoutScreen(TbadkApplication.getInst().getCurrentActivity());
    }

    private void bzK() {
        this.fAj = new CircleProgressView(this.mContext);
        this.fAj.setCircleBackgroundColor(ap.getColor(R.color.CAM_X0109));
        this.fAj.setCircleForegroundColor(ap.getColor(R.color.CAM_X0302));
        this.fAj.setProgress(0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds80), l.getDimens(getContext(), R.dimen.tbds80));
        layoutParams.addRule(13);
        this.fAj.setVisibility(8);
        addView(this.fAj, layoutParams);
    }

    public void setIsCanDrag(boolean z) {
        this.fyk = z;
    }

    public String getmCheckOriginPicText() {
        return this.fAi;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        Bitmap imageBitmap;
        int height;
        int width;
        if (this.fAa && !this.fAk && this.fzG.getVisibility() == 0 && !this.fzG.isImageLoaded()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.fyk || !this.fzK) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.fzM && motionEvent.getPointerCount() >= 2) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.fzM || this.fzN) {
            requestDisallowInterceptTouchEvent(true);
        }
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        float x = motionEvent.getX();
        int i = action & 255;
        if (i == 0) {
            if (this.fzO == null) {
                if (this.fzG.getVisibility() == 0) {
                    this.fzO = h.bV(this.fzG);
                } else {
                    this.fzO = h.bV(this.fzE);
                }
            }
            if (this.mDisplayRect == null && this.fzO != null) {
                int measuredWidth = getMeasuredWidth();
                float measuredWidth2 = ((getMeasuredWidth() * 1.0f) / this.fzO.getWidth()) * this.fzO.getHeight();
                if (measuredWidth2 > getMeasuredHeight()) {
                    measuredWidth2 = getMeasuredHeight();
                }
                RectF rectInScreenFromPosition = getRectInScreenFromPosition(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
                this.mDisplayRect = new Rect((int) rectInScreenFromPosition.left, (int) rectInScreenFromPosition.top, (int) rectInScreenFromPosition.right, (int) rectInScreenFromPosition.bottom);
            }
            if (this.fzR == null && this.fzO != null) {
                if (this.fzG.getVisibility() == 0) {
                    height = this.fzG.getSHeight();
                    width = this.fzG.getSWidth();
                } else {
                    if (this.fzE.getImageType() == 1) {
                        imageBitmap = (this.fzE.getCurrentFrame() == null || this.fzE.getCurrentFrame().bm == null) ? this.fzO : this.fzE.getCurrentFrame().bm;
                    } else {
                        imageBitmap = this.fzE.getImageBitmap() == null ? this.fzO : this.fzE.getImageBitmap();
                    }
                    height = imageBitmap.getHeight();
                    width = imageBitmap.getWidth();
                }
                float equipmentDensity = l.getEquipmentDensity(getContext());
                int i2 = (int) (height * equipmentDensity);
                int i3 = (int) (width * equipmentDensity);
                if (i3 > this.fzO.getWidth() && this.fzO.getWidth() != 0) {
                    float width2 = (i3 * 1.0f) / this.fzO.getWidth();
                    i3 = this.fzO.getWidth();
                    i2 = (int) (i2 / width2);
                }
                if (i2 > this.fzO.getHeight() && this.fzO.getHeight() != 0) {
                    i3 = (int) (i3 / ((i2 * 1.0f) / this.fzO.getHeight()));
                    i2 = this.fzO.getHeight();
                }
                int equipmentHeight = (l.getEquipmentHeight(getContext()) - i2) / 2;
                int equipmentWidth = (l.getEquipmentWidth(getContext()) - i3) / 2;
                this.fzR = new Rect(equipmentWidth, equipmentHeight, i3 + equipmentWidth, i2 + equipmentHeight);
                this.fzS = new Rect(this.fzR);
                this.fzZ = equipmentHeight / l.getEquipmentHeight(getContext());
                this.fzQ = new Rect(0, 0, this.fzO.getWidth(), this.fzO.getHeight());
            }
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (i == 2) {
            this.fzM = x(this.mLastMotionX - x, this.mLastMotionY - y);
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (this.fzM || this.fzN) {
            this.fzE.setImageOnLongClickListener(null);
            this.fzG.setOnLongClickListener(null);
            z = true;
        } else {
            this.fzE.setImageOnLongClickListener(this.mLongClickListener);
            this.fzG.setOnLongClickListener(this.mLongClickListener);
            z = super.dispatchTouchEvent(motionEvent);
        }
        if (i == 1 || i == 3) {
            this.mLastMotionX = 0.0f;
            this.mLastMotionY = 0.0f;
            boolean z2 = (-this.mMoveDistance) > ((float) (EXIT_DISTANCE * 2));
            boolean z3 = this.mMoveDistance > ((float) EXIT_DISTANCE);
            if (z2 || z3) {
                this.fzN = true;
                startExitAnimation();
                if (z2) {
                    TiebaStatic.log(new ar("c13377").dR("obj_type", "3"));
                } else if (z3) {
                    TiebaStatic.log(new ar("c13377").dR("obj_type", "2"));
                }
            } else {
                if (this.fzM && this.fzT != null) {
                    this.fzT.bGe();
                }
                this.mRatio = 1.0f;
                invalidate();
            }
            this.isInDragScaleMode = false;
            this.mDragMatrix.reset();
            this.fzM = false;
        }
        return z;
    }

    private boolean x(float f, float f2) {
        if (this.fzG.getVisibility() != 0 || this.fzG.isCanDrag()) {
            if (this.fxh == null || !this.fxh.isLongPic || this.fzG.getVisibility() != 0 || this.fzG.isViewTop()) {
                if (this.fxh == null || !this.fxh.isLongPic || this.fzG.getVisibility() == 0 || this.fzE.isAtViewTop() || this.fzE.bGc()) {
                    if (this.fzG.getVisibility() == 0 || this.fzE.pagerCantScroll()) {
                        if (this.fzO != null && getScrollY() == 0) {
                            boolean z = (this.fxh == null || !this.fxh.isLongPic) && ((f2 < -15.0f && !this.isInDragScaleMode) || (f2 > 15.0f && !this.isInDragScaleMode));
                            boolean z2 = this.fxh != null && this.fxh.isLongPic && f2 < 0.0f && !this.isInDragScaleMode;
                            if (z || (z2 && this.fzE.isViewTop())) {
                                this.fzE.setImageOnLongClickListener(null);
                                this.fzG.setOnLongClickListener(null);
                                this.isInDragScaleMode = true;
                                this.mMoveDistance = 0.0f;
                                this.mRatio = 1.0f;
                                if (this.fzT != null) {
                                    this.fzT.onDragStart();
                                }
                            }
                        }
                        if (!this.isInDragScaleMode || this.fzO == null) {
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
                        this.mDragMatrix.preScale(1.0f + f3, 1.0f + f3, (this.mRatio * this.fzO.getWidth()) / 2.0f, this.mRatio * (this.fzO.getHeight() / 2));
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
        if (this.fzM && this.fzO != null && !this.fzO.isRecycled() && this.isInDragScaleMode) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.mDstRect == null) {
                this.mDstRect = new RectF();
            }
            this.mDragMatrix.mapRect(this.mDstRect, new RectF(this.mDisplayRect));
            canvas.drawBitmap(this.fzO, this.fzQ, this.mDstRect, (Paint) null);
        } else if (this.fzN && this.fzO != null && !this.fzO.isRecycled()) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.fxh == null || this.fxh.getSourceImageRectInScreen() == null) {
                canvas.drawBitmap(this.fzO, this.fzQ, this.mDstRect, (Paint) null);
            } else {
                canvas.drawBitmap(this.fzO, this.fzR, this.mDstRect, (Paint) null);
            }
        } else {
            super.dispatchDraw(canvas);
        }
    }

    private void startExitAnimation() {
        if (this.fxh == null) {
            if (this.fzT != null) {
                this.fzT.onDragEnd();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.fxh.getSourceImageRectInScreen();
        final Rect dstRectInScreen = this.fxh.getDstRectInScreen();
        if (sourceImageRectInScreen == null || dstRectInScreen == null) {
            if (this.fzT != null) {
                this.fzT.onDragEnd();
                return;
            }
            return;
        }
        a(sourceImageRectInScreen, dstRectInScreen);
        a(sourceImageRectInScreen);
        this.fzP = new RectF(this.mDstRect);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(150L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && sourceImageRectInScreen != null && dstRectInScreen != null) {
                    UrlDragImageView.this.at(valueAnimator.getAnimatedFraction());
                    UrlDragImageView.this.a(dstRectInScreen, valueAnimator.getAnimatedFraction(), UrlDragImageView.this.fAl);
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
                if (UrlDragImageView.this.fzT != null) {
                    UrlDragImageView.this.fzT.onDragEnd();
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

    private void a(Rect rect) {
        if (rect != null) {
            float f = ((rect.bottom - rect.top) / (rect.right - rect.left)) * (this.mDstRect.right - this.mDstRect.left);
            this.mDstRect.top += this.mDstRect.height() * this.fzZ;
            this.mDstRect.bottom = f + this.mDstRect.top;
        }
    }

    public void setCanScale(boolean z) {
        if (this.fzE != null) {
            this.fzE.setCanScale(z);
        }
    }

    private void a(Rect rect, Rect rect2) {
        this.fzV = 0.0f;
        this.fzW = 0.0f;
        this.fzX = 1.0f;
        this.fzY = 1.0f;
        if (rect != null && rect2 != null && rect.contains(rect2)) {
            this.fzV = (rect2.left - rect.left) / rect.width();
            this.fzW = (rect2.top - rect.top) / rect.height();
            this.fzX = (rect2.right - rect.left) / rect.width();
            this.fzY = (rect2.bottom - rect.top) / rect.height();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void at(float f) {
        if (this.fzR != null) {
            this.fzR.left = (int) (this.fzS.left + (this.fzS.width() * this.fzV * f));
            this.fzR.top = (int) (this.fzS.top + (this.fzS.height() * this.fzW * f));
            this.fzR.right = (int) (this.fzS.left + (this.fzS.width() * (((1.0f - this.fzX) * (1.0f - f)) + this.fzX)));
            this.fzR.bottom = (int) (this.fzS.top + (this.fzS.height() * (((1.0f - this.fzY) * (1.0f - f)) + this.fzY)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Rect rect, float f, boolean z) {
        int i = 0;
        if (z) {
            i = l.getDimens(getContext(), R.dimen.tbds80);
        }
        if (this.mDstRect != null && rect != null) {
            this.mDstRect.left = this.fzP.left + ((rect.left - this.fzP.left) * f);
            this.mDstRect.top = (this.fzP.top + ((rect.top - this.fzP.top) * f)) - i;
            this.mDstRect.right = this.fzP.right + ((rect.right - this.fzP.right) * f);
            this.mDstRect.bottom = this.fzP.bottom + ((rect.bottom - this.fzP.bottom) * f);
        }
    }

    private RectF getRectInScreenFromPosition(float f, float f2, float f3, float f4) {
        return new RectF(f - (f3 / 2.0f), f2 - (f4 / 2.0f), (f3 / 2.0f) + f, (f4 / 2.0f) + f2);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.fAf = onTouchListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzL() {
        if ((this.fzJ || this.fzK) && this.fxh != null && this.fxh.mPicType == 1 && !TextUtils.isEmpty(this.fxh.mTagName)) {
            if (this.fzF != null) {
                this.fzF.setVisibility(8);
                this.fzF = null;
            }
            this.fzF = new TextView(this.mContext);
            this.fzF.setText(this.fxh.mTagName);
            this.fzF.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize26));
            ap.setViewTextColor(this.fzF, R.color.common_color_10013, 1, 0);
            ap.setBackgroundColor(this.fzF, R.color.common_color_10215);
            this.fzF.setAlpha(0.75f);
            this.fzF.setIncludeFontPadding(false);
            this.fzF.setGravity(17);
            int dimens = l.getDimens(this.mContext, R.dimen.ds2);
            this.fzF.setPadding(dimens, dimens, dimens, dimens);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.fzE.getBottomOffset();
            layoutParams.leftMargin = this.fzE.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.fzF, layoutParams);
            this.fzF.setVisibility(0);
        }
    }

    public void setUrl(String str, boolean z) {
        if (str.contains("*")) {
            str = str.split("[*]")[0];
        }
        this.fzE.setTag(str);
        this.fzE.setLoadBigImage(false);
        this.fzE.setImageDrawable(null);
        this.fzJ = false;
        this.fzK = false;
        this.fAa = bzT();
        this.fAi = null;
        if (Cz(str)) {
            e(str, z, false);
        }
    }

    private boolean bzM() {
        return this.fzE != null && this.fzE.isLoadBigImage();
    }

    public void bzN() {
        if (this.fxh != null && !bzM()) {
            String str = this.fxh.imageUrl;
            int i = this.fxh.urlType;
            com.baidu.adp.widget.ImageView.a aVar = null;
            if (com.baidu.tbadk.core.util.d.a.as(str, i)) {
                aVar = com.baidu.tbadk.core.util.d.a.at(str, i);
            }
            if (aVar != null) {
                setThumbBitmapToView(aVar);
            }
        }
    }

    private boolean kC(boolean z) {
        String nameMd5FromUrl;
        if (!this.fAb || z) {
            this.fAb = true;
            if (!this.fAa || this.fxh == null || StringUtils.isNull(this.fxh.originalUrl, true) || this.fxh.originalSize < 0 || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String str = this.fzU + at.bsS().Bl(nameMd5FromUrl) + "/" + aw.getNameMd5FromUrl(this.fxh.originalUrl);
            final int[] imageFileWH = o.getImageFileWH(str);
            this.fzG.setVisibility(0);
            if (this.fzH == null) {
                this.fzH = new SubsamplingScaleImageView.OnImageEventListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12
                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onReady() {
                        UrlDragImageView.this.fAi = null;
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.fzE.restoreSize();
                        UrlDragImageView.this.fzE.setVisibility(4);
                    }

                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onImageLoaded() {
                        if (UrlDragImageView.this.fxh.isLongPic && imageFileWH[0] > 0) {
                            UrlDragImageView.this.fzE.onDestroy();
                            final float measuredWidth = (UrlDragImageView.this.getMeasuredWidth() * 1.0f) / imageFileWH[0];
                            final PointF pointF = new PointF((imageFileWH[0] * 1.0f) / 2.0f, 0.0f);
                            UrlDragImageView.this.fzG.setScaleAndCenter(measuredWidth, pointF);
                            UrlDragImageView.this.fzG.setMaxScale(2.0f * measuredWidth);
                            UrlDragImageView.this.fzG.setDoubleTapZoomScale(2.0f * measuredWidth);
                            UrlDragImageView.this.fzG.setInitScale(measuredWidth);
                            UrlDragImageView.this.fzG.setDoubleTapZoomStyle(4);
                            UrlDragImageView.this.fzG.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12.1
                                @Override // android.view.View.OnTouchListener
                                public boolean onTouch(View view, MotionEvent motionEvent) {
                                    if (UrlDragImageView.this.fAf != null) {
                                        UrlDragImageView.this.fAf.onTouch(view, motionEvent);
                                    }
                                    switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                                        case 0:
                                            UrlDragImageView.this.fAh = motionEvent.getY();
                                            UrlDragImageView.this.fzG.setOnClickListener(UrlDragImageView.this.fAg ? UrlDragImageView.this.mOnClickListener : null);
                                            UrlDragImageView.this.fzG.setOnLongClickListener(UrlDragImageView.this.fAg ? UrlDragImageView.this.mLongClickListener : null);
                                            break;
                                        case 1:
                                        case 3:
                                            if (UrlDragImageView.this.fzG.getScale() < measuredWidth) {
                                                UrlDragImageView.this.fzG.setScaleAndCenter(measuredWidth, pointF);
                                            }
                                            e.mA().removeCallbacks(UrlDragImageView.this.fAm);
                                            e.mA().postDelayed(UrlDragImageView.this.fAm, 1000L);
                                            break;
                                        case 2:
                                            if (Math.abs(motionEvent.getY() - UrlDragImageView.this.fAh) > UrlDragImageView.TOUCH_SLOP) {
                                                UrlDragImageView.this.fAg = false;
                                                UrlDragImageView.this.fzG.setOnClickListener(null);
                                                UrlDragImageView.this.fzG.setOnLongClickListener(null);
                                            }
                                            UrlDragImageView.this.fAh = motionEvent.getY();
                                            break;
                                    }
                                    return false;
                                }
                            });
                            UrlDragImageView.this.fzE.setVisibility(4);
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
            this.fzG.setOnImageEventListener(this.fzH);
            if (this.fzG.isImageLoaded() && this.fxh.isLongPic) {
                this.fzH.onImageLoaded();
            } else {
                this.fzG.setImage(ImageSource.uri(str));
            }
            return true;
        }
        return false;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.fzT = dVar;
        if (this.fzE != null) {
            this.fzE.setDragToExitListener(dVar);
        }
    }

    public void bzO() {
        kC(false);
    }

    private boolean Cz(String str) {
        return j.isNetWorkAvailable() || com.baidu.tbadk.core.util.d.b.By(str);
    }

    private void setThumbBitmapToView(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap rawBitmap;
        if (!this.fzK && aVar != null && (rawBitmap = aVar.getRawBitmap()) != null) {
            this.fzJ = true;
            if (aVar.isGif()) {
                this.fzE.setImageUrlData(this.fxh);
                this.fzE.setImageBitmap(rawBitmap);
                this.fAi = null;
                this.fAd = false;
            } else {
                if (this.fxh != null && this.fxh.isLongPic) {
                    this.fzE.createLargeImageDelegate();
                    this.fzE.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.13
                        @Override // com.baidu.tbadk.widget.largeImage.logic.a
                        public void onLoadFinished() {
                        }
                    });
                }
                this.fzE.setImageUrlData(this.fxh);
                this.fzE.setImageData(rawBitmap, aVar.getByteData());
            }
            bzL();
        }
    }

    private void e(String str, boolean z, boolean z2) {
        if (CA(str)) {
            if (z2 || (!this.fzL && !this.fzK)) {
                if (!z2 || !kC(true)) {
                    this.fzL = true;
                    d.mw().a(str, 27, new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.14
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.c
                        public void onCancelled(String str2) {
                            UrlDragImageView.this.fzL = false;
                            UrlDragImageView.this.fzE.setVisibility(0);
                            UrlDragImageView.this.mProgressBar.setVisibility(8);
                            UrlDragImageView.this.fAi = null;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.c
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            UrlDragImageView.this.fzL = false;
                            UrlDragImageView.this.fzK = true;
                            UrlDragImageView.this.b(aVar);
                        }
                    }, 0, 0, false, null, Boolean.valueOf(z), this.fzE.getImageData(), Boolean.valueOf(this.fyi));
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
        imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.bd(this.mMaxWidth, this.mMaxHeight));
        com.baidu.adp.widget.ImageView.a a2 = this.fAe.a(imageFileInfo, false);
        if (a2 != null) {
            this.fzK = true;
            this.mProgressBar.setVisibility(8);
            this.fAi = null;
            b(a2);
            return;
        }
        this.fAe.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.2
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.ImageView.a aVar, String str2, boolean z3) {
                UrlDragImageView.this.fzK = true;
                UrlDragImageView.this.mProgressBar.setVisibility(8);
                UrlDragImageView.this.fAi = null;
                UrlDragImageView.this.b(aVar);
            }
        }, false);
    }

    private boolean CA(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null && this.fzI != null) {
            this.fzI.k(aVar.getUrl(), aVar.getByteData());
        }
        if (aVar == null || aVar.getRawBitmap() == null) {
            bzP();
            return;
        }
        Bitmap rawBitmap = aVar.getRawBitmap();
        this.fzE.setLoadBigImage(true);
        if (aVar.isGif()) {
            this.fzE.setGifData(aVar.getByteData(), rawBitmap);
            this.fzE.invalidate();
            this.fzE.play();
            this.fAd = false;
            this.fAi = null;
            this.mProgressBar.setVisibility(8);
        } else {
            if (this.fxh != null && this.fxh.isLongPic) {
                this.fzE.createLargeImageDelegate();
                this.fzE.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.3
                    @Override // com.baidu.tbadk.widget.largeImage.logic.a
                    public void onLoadFinished() {
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.fAi = null;
                    }
                });
            } else {
                this.mProgressBar.setVisibility(8);
                this.fAi = null;
            }
            this.fzE.setImageUrlData(this.fxh);
            this.fzE.setImageData(rawBitmap, aVar.getByteData());
            bzU();
        }
        bzL();
    }

    private void bzP() {
        if (!this.fzJ) {
            this.fzE.setDefaultBitmap();
        } else {
            this.fzK = false;
        }
        this.fAi = null;
        this.mProgressBar.setVisibility(8);
    }

    public void setGifMaxUseableMem(int i) {
        this.fzE.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.fzE != null) {
            this.fzE.onDestroy();
        }
        if (this.fzG != null) {
            this.fzG.recycle();
        }
        if (this.fzO != null) {
            this.fzO.recycle();
            this.fzO = null;
        }
        if (this.mProgressBar != null) {
            this.fAi = null;
            this.mProgressBar.setVisibility(8);
        }
        e.mA().removeCallbacks(this.fAm);
        com.baidu.tieba.view.c.dWg().setColor(-1);
    }

    public void release() {
        if (this.fzE != null) {
            this.fzE.release();
        }
        if (this.mProgressBar != null) {
            this.fAi = null;
            this.mProgressBar.setVisibility(8);
        }
        this.fAi = null;
    }

    public void bzQ() {
        if (this.fzE != null && this.fzE.getImageType() == 1) {
            this.fzE.stop();
        }
    }

    public void D(boolean z, boolean z2) {
        String str;
        if (this.fzE != null && (str = (String) this.fzE.getTag()) != null) {
            if (this.fzE.getImageType() == 1) {
                if (this.fzE.getGifCache() == null || !this.fzE.isLoadBigImage()) {
                    e(str, z, z2);
                }
            } else if (this.fzE.getImageType() == 2) {
                e(str, z, z2);
            } else if (bzR()) {
                e(str, z, z2);
            }
        }
    }

    private boolean bzR() {
        if (this.fzE.getImageBitmap() != null && this.fzE.isLoadBigImage()) {
            if (this.fxh == null || !this.fxh.isLongPic || this.fzE.hasLoadLongImage()) {
                return false;
            }
            this.fzK = false;
            this.fAb = false;
            return true;
        }
        return true;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.fxh = imageUrlData;
    }

    public ImageUrlData getmAssistUrlData() {
        return this.fxh;
    }

    public void setIsCdn(boolean z) {
        this.fyi = z;
    }

    public void bzS() {
        final String nameMd5FromUrl = aw.getNameMd5FromUrl(this.fxh.originalUrl);
        if (this.fxh.originalProcess >= 0) {
            com.baidu.tbadk.download.d.bBg().cancelDownLoadById(nameMd5FromUrl, 13);
            this.fxh.originalProcess = -1;
            bzU();
            return;
        }
        if (this.fyb != null) {
            this.fyb.bzX();
        }
        f<?> J = com.baidu.adp.base.j.J(this.mContext);
        if (J == null) {
            CB(nameMd5FromUrl);
        } else if (!j.isNetWorkAvailable() || j.isWifiNet() || com.baidu.tbadk.core.sharedPref.b.brR().getBoolean(SharedPrefConfig.ORIGINAL_IMG_DOWN_TIP, false)) {
            CB(nameMd5FromUrl);
        } else {
            com.baidu.tbadk.core.sharedPref.b.brR().putBoolean(SharedPrefConfig.ORIGINAL_IMG_DOWN_TIP, true);
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(J.getPageActivity());
            aVar.ny(R.string.original_img_down_no_wifi_tip);
            aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    UrlDragImageView.this.CB(nameMd5FromUrl);
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                }
            });
            aVar.b(J);
            aVar.bqz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CB(String str) {
        if (this.fxh != null) {
            this.fxh.originalProcess = 0;
            this.fAj.setProgress(0);
            this.fAj.setVisibility(0);
            DownloadData downloadData = new DownloadData(str);
            downloadData.setStatus(1);
            downloadData.setUrl(this.fxh.originalUrl);
            downloadData.setType(13);
            downloadData.setPath(this.fzU + at.bsS().Bl(str) + "/" + str);
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.6
                @Override // com.baidu.tbadk.download.c
                public boolean onPreDownload(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2 != null) {
                        if (UrlDragImageView.this.fxh != null && UrlDragImageView.this.fxh.originalProcess != -1) {
                            UrlDragImageView.this.fxh.originalProcess = downloadData2.getProcess();
                        }
                        if (UrlDragImageView.this.fxh == null || UrlDragImageView.this.fxh.originalProcess != -1) {
                            UrlDragImageView.this.fAj.setProgress(downloadData2.getProcess());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public boolean onFileDownloaded(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadSucceed(DownloadData downloadData2) {
                    UrlDragImageView.this.fAj.setVisibility(8);
                    e.mA().postDelayed(UrlDragImageView.this.fAn, 1500L);
                    UrlDragImageView.this.fAb = false;
                    UrlDragImageView.this.fAa = UrlDragImageView.this.bzT();
                    UrlDragImageView.this.bzO();
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str2) {
                    UrlDragImageView.this.fAj.setVisibility(8);
                    UrlDragImageView.this.fAb = false;
                    BdToast.b(UrlDragImageView.this.mContext, str2).bqE().bqF();
                    UrlDragImageView.this.fxh.originalProcess = -1;
                    UrlDragImageView.this.bzU();
                }
            });
            com.baidu.tbadk.download.d.bBg().a(downloadData, 100);
            this.fAk = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bzT() {
        if (this.fxh != null && !StringUtils.isNull(this.fxh.originalUrl, true) && this.fxh.originalSize >= 0 && !this.fxh.isBlockedPic) {
            String nameMd5FromUrl = aw.getNameMd5FromUrl(this.fxh.originalUrl);
            File file = new File(this.fzU + at.bsS().Bl(nameMd5FromUrl) + "/" + nameMd5FromUrl);
            if (file != null && file.exists()) {
                this.fxh.originalProcess = 100;
                return true;
            }
            if (this.fxh.originalProcess < 0) {
                bzU();
            } else {
                this.fAj.setProgress(this.fxh.originalProcess);
            }
            this.fAd = true;
        } else {
            this.fAi = null;
        }
        return false;
    }

    public void bzU() {
        if (this.fxh != null) {
            if (!bzV() || !this.fAd) {
                this.fAi = null;
            } else if (this.fxh.originalSize > 0 && !ej(this.fxh.originalSize)) {
                this.fAi = fzC + "(" + au.getFormatSize(this.fxh.originalSize) + ")";
            } else {
                this.fAi = fzC;
            }
        }
    }

    private boolean bzV() {
        return (this.fxh == null || !this.fxh.mIsShowOrigonButton || this.fxh.isBlockedPic || StringUtils.isNull(this.fxh.originalUrl)) ? false : true;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.fyb = bVar;
    }

    private boolean ej(long j) {
        return j > fzD;
    }
}
