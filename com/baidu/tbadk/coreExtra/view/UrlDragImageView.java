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
    private ImageUrlData fhI;
    private b fiH;
    private boolean fiO;
    private boolean fiQ;
    private String fkA;
    private float fkB;
    private float fkC;
    private float fkD;
    private float fkE;
    private float fkF;
    private boolean fkG;
    private boolean fkH;
    private boolean fkI;
    public boolean fkJ;
    private com.baidu.tbadk.img.b fkK;
    private View.OnTouchListener fkL;
    private boolean fkM;
    private float fkN;
    private String fkO;
    private CircleProgressView fkP;
    private boolean fkQ;
    private boolean fkR;
    private Runnable fkS;
    private Runnable fkT;
    private View.OnTouchListener fkU;
    protected DragImageView fkk;
    protected TextView fkl;
    protected SubsamplingScaleImageView fkm;
    private SubsamplingScaleImageView.OnImageEventListener fkn;
    private a fko;
    private boolean fkp;
    private boolean fkq;
    private boolean fkr;
    private boolean fks;
    private boolean fkt;
    private Bitmap fku;
    private RectF fkv;
    private Rect fkw;
    private Rect fkx;
    private Rect fky;
    private DragImageView.d fkz;
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
    private static final String fki = TbadkCoreApplication.getInst().getString(R.string.original_img_look);
    private static long fkj = Config.RAVEN_LOG_LIMIT;
    private static final int EXIT_DISTANCE = l.getEquipmentHeight(TbadkCoreApplication.getInst()) / 5;
    private static final String TAG = UrlDragImageView.class.getSimpleName();
    private static final int TOUCH_SLOP = ViewConfiguration.get(TbadkCoreApplication.getInst()).getScaledTouchSlop();

    /* loaded from: classes21.dex */
    public interface a {
        void k(String str, byte[] bArr);
    }

    /* loaded from: classes21.dex */
    public interface b {
        void byl();
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
        if (this.fkk != null) {
            this.fkk.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.fko = aVar;
    }

    public UrlDragImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.fkk = null;
        this.fko = null;
        this.fiO = false;
        this.fkr = false;
        this.isInDragScaleMode = false;
        this.mRatio = 1.0f;
        this.mMoveDistance = 0.0f;
        this.mDragMatrix = new Matrix();
        this.mDstRect = new RectF();
        this.fkB = 0.0f;
        this.fkC = 0.0f;
        this.fkD = 1.0f;
        this.fkE = 1.0f;
        this.fkF = 0.0f;
        this.fkG = false;
        this.fkH = false;
        this.fkI = false;
        this.fkJ = false;
        this.fkM = true;
        this.fkN = 0.0f;
        this.mOnClickListener = null;
        this.mLongClickListener = null;
        this.fkO = null;
        this.fkS = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.fkM = true;
            }
        };
        this.fkT = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.fkP.setVisibility(8);
                        UrlDragImageView.this.fkO = null;
                        UrlDragImageView.this.fkJ = false;
                    }
                });
            }
        };
        this.fkU = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.fkL != null) {
                    UrlDragImageView.this.fkL.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.fkK = new com.baidu.tbadk.img.b();
        init();
    }

    public UrlDragImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.fkk = null;
        this.fko = null;
        this.fiO = false;
        this.fkr = false;
        this.isInDragScaleMode = false;
        this.mRatio = 1.0f;
        this.mMoveDistance = 0.0f;
        this.mDragMatrix = new Matrix();
        this.mDstRect = new RectF();
        this.fkB = 0.0f;
        this.fkC = 0.0f;
        this.fkD = 1.0f;
        this.fkE = 1.0f;
        this.fkF = 0.0f;
        this.fkG = false;
        this.fkH = false;
        this.fkI = false;
        this.fkJ = false;
        this.fkM = true;
        this.fkN = 0.0f;
        this.mOnClickListener = null;
        this.mLongClickListener = null;
        this.fkO = null;
        this.fkS = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.fkM = true;
            }
        };
        this.fkT = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.fkP.setVisibility(8);
                        UrlDragImageView.this.fkO = null;
                        UrlDragImageView.this.fkJ = false;
                    }
                });
            }
        };
        this.fkU = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.fkL != null) {
                    UrlDragImageView.this.fkL.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.fkK = new com.baidu.tbadk.img.b();
        init();
    }

    public DragImageView getImageView() {
        return this.fkk;
    }

    public void setGifSetListener(DragImageView.e eVar) {
        this.fkk.setGifSetListener(eVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.fkk.setImageOnClickListener(onClickListener);
        this.fkm.setOnClickListener(onClickListener);
        this.mOnClickListener = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mLongClickListener = onLongClickListener;
        if (!this.fiQ) {
            this.fkk.setImageOnLongClickListener(this.mLongClickListener);
            this.fkm.setOnLongClickListener(this.mLongClickListener);
        }
    }

    public void setOnSizeChangedListener(final DragImageView.g gVar) {
        this.fkk.setOnSizeChangedListener(new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.8
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (gVar != null) {
                    gVar.a(dragImageView, z, z2);
                }
                UrlDragImageView.this.bxZ();
            }
        });
    }

    protected void init() {
        this.fkA = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        this.mMaxWidth = l.getEquipmentWidth(this.mContext);
        this.mMaxHeight = l.getEquipmentHeight(this.mContext) - ((int) this.mContext.getResources().getDimension(R.dimen.ds166));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.fkk = new DragImageView(this.mContext);
        this.fkk.setLayoutParams(layoutParams);
        this.fkk.setOnTouchListener(this.fkU);
        addView(this.fkk);
        this.fkm = new SubsamplingScaleImageView(this.mContext);
        this.fkm.setMaxScale(50.0f);
        this.fkm.setOnTouchListener(this.fkU);
        this.fkm.setVisibility(4);
        addView(this.fkm, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(getResources().getDrawable(R.drawable.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        bxY();
        this.fkR = TbSingleton.getInstance().isCutoutScreen(TbadkApplication.getInst().getCurrentActivity());
    }

    private void bxY() {
        this.fkP = new CircleProgressView(this.mContext);
        this.fkP.setCircleBackgroundColor(ap.getColor(R.color.cp_cont_d));
        this.fkP.setCircleForegroundColor(ap.getColor(R.color.cp_link_tip_a));
        this.fkP.setProgress(0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds80), l.getDimens(getContext(), R.dimen.tbds80));
        layoutParams.addRule(13);
        this.fkP.setVisibility(8);
        addView(this.fkP, layoutParams);
    }

    public void setIsCanDrag(boolean z) {
        this.fiQ = z;
    }

    public String getmCheckOriginPicText() {
        return this.fkO;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        Bitmap imageBitmap;
        int height;
        int width;
        if (this.fkG && !this.fkQ && this.fkm.getVisibility() == 0 && !this.fkm.isImageLoaded()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.fiQ || !this.fkq) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.fks && motionEvent.getPointerCount() >= 2) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.fks || this.fkt) {
            requestDisallowInterceptTouchEvent(true);
        }
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        float x = motionEvent.getX();
        int i = action & 255;
        if (i == 0) {
            if (this.fku == null) {
                if (this.fkm.getVisibility() == 0) {
                    this.fku = h.bG(this.fkm);
                } else {
                    this.fku = h.bG(this.fkk);
                }
            }
            if (this.mDisplayRect == null && this.fku != null) {
                int measuredWidth = getMeasuredWidth();
                float measuredWidth2 = ((getMeasuredWidth() * 1.0f) / this.fku.getWidth()) * this.fku.getHeight();
                if (measuredWidth2 > getMeasuredHeight()) {
                    measuredWidth2 = getMeasuredHeight();
                }
                RectF rectInScreenFromPosition = getRectInScreenFromPosition(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
                this.mDisplayRect = new Rect((int) rectInScreenFromPosition.left, (int) rectInScreenFromPosition.top, (int) rectInScreenFromPosition.right, (int) rectInScreenFromPosition.bottom);
            }
            if (this.fkx == null && this.fku != null) {
                if (this.fkm.getVisibility() == 0) {
                    height = this.fkm.getSHeight();
                    width = this.fkm.getSWidth();
                } else {
                    if (this.fkk.getImageType() == 1) {
                        imageBitmap = (this.fkk.getCurrentFrame() == null || this.fkk.getCurrentFrame().bm == null) ? this.fku : this.fkk.getCurrentFrame().bm;
                    } else {
                        imageBitmap = this.fkk.getImageBitmap() == null ? this.fku : this.fkk.getImageBitmap();
                    }
                    height = imageBitmap.getHeight();
                    width = imageBitmap.getWidth();
                }
                float equipmentDensity = l.getEquipmentDensity(getContext());
                int i2 = (int) (height * equipmentDensity);
                int i3 = (int) (width * equipmentDensity);
                if (i3 > this.fku.getWidth() && this.fku.getWidth() != 0) {
                    float width2 = (i3 * 1.0f) / this.fku.getWidth();
                    i3 = this.fku.getWidth();
                    i2 = (int) (i2 / width2);
                }
                if (i2 > this.fku.getHeight() && this.fku.getHeight() != 0) {
                    i3 = (int) (i3 / ((i2 * 1.0f) / this.fku.getHeight()));
                    i2 = this.fku.getHeight();
                }
                int equipmentHeight = (l.getEquipmentHeight(getContext()) - i2) / 2;
                int equipmentWidth = (l.getEquipmentWidth(getContext()) - i3) / 2;
                this.fkx = new Rect(equipmentWidth, equipmentHeight, i3 + equipmentWidth, i2 + equipmentHeight);
                this.fky = new Rect(this.fkx);
                this.fkF = equipmentHeight / l.getEquipmentHeight(getContext());
                this.fkw = new Rect(0, 0, this.fku.getWidth(), this.fku.getHeight());
            }
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (i == 2) {
            this.fks = w(this.mLastMotionX - x, this.mLastMotionY - y);
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (this.fks || this.fkt) {
            this.fkk.setImageOnLongClickListener(null);
            this.fkm.setOnLongClickListener(null);
            z = true;
        } else {
            this.fkk.setImageOnLongClickListener(this.mLongClickListener);
            this.fkm.setOnLongClickListener(this.mLongClickListener);
            z = super.dispatchTouchEvent(motionEvent);
        }
        if (i == 1 || i == 3) {
            this.mLastMotionX = 0.0f;
            this.mLastMotionY = 0.0f;
            boolean z2 = (-this.mMoveDistance) > ((float) EXIT_DISTANCE);
            boolean z3 = this.mMoveDistance > ((float) EXIT_DISTANCE);
            if (z2 || z3) {
                this.fkt = true;
                startExitAnimation();
                if (z2) {
                    TiebaStatic.log(new aq("c13377").dR("obj_type", "3"));
                } else if (z3) {
                    TiebaStatic.log(new aq("c13377").dR("obj_type", "2"));
                }
            } else {
                if (this.fks && this.fkz != null) {
                    this.fkz.bEk();
                }
                this.mRatio = 1.0f;
                invalidate();
            }
            this.isInDragScaleMode = false;
            this.mDragMatrix.reset();
            this.fks = false;
        }
        return z;
    }

    private boolean w(float f, float f2) {
        if (this.fkm.getVisibility() != 0 || this.fkm.isCanDrag()) {
            if (this.fhI == null || !this.fhI.isLongPic || this.fkm.getVisibility() != 0 || this.fkm.isViewTop()) {
                if (this.fhI == null || !this.fhI.isLongPic || this.fkm.getVisibility() == 0 || this.fkk.isAtViewTop() || this.fkk.bEi()) {
                    if (this.fkm.getVisibility() == 0 || this.fkk.pagerCantScroll()) {
                        if (this.fku != null && getScrollY() == 0) {
                            boolean z = (this.fhI == null || !this.fhI.isLongPic) && ((f2 < -15.0f && !this.isInDragScaleMode) || (f2 > 15.0f && !this.isInDragScaleMode));
                            boolean z2 = this.fhI != null && this.fhI.isLongPic && f2 < 0.0f && !this.isInDragScaleMode;
                            if (z || (z2 && this.fkk.isViewTop())) {
                                this.fkk.setImageOnLongClickListener(null);
                                this.fkm.setOnLongClickListener(null);
                                this.isInDragScaleMode = true;
                                this.mMoveDistance = 0.0f;
                                this.mRatio = 1.0f;
                                if (this.fkz != null) {
                                    this.fkz.onDragStart();
                                }
                            }
                        }
                        if (!this.isInDragScaleMode || this.fku == null) {
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
                        this.mDragMatrix.preScale(1.0f + f3, 1.0f + f3, (this.mRatio * this.fku.getWidth()) / 2.0f, this.mRatio * (this.fku.getHeight() / 2));
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
        if (this.fks && this.fku != null && !this.fku.isRecycled() && this.isInDragScaleMode) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.mDstRect == null) {
                this.mDstRect = new RectF();
            }
            this.mDragMatrix.mapRect(this.mDstRect, new RectF(this.mDisplayRect));
            canvas.drawBitmap(this.fku, this.fkw, this.mDstRect, (Paint) null);
        } else if (this.fkt && this.fku != null && !this.fku.isRecycled()) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.fhI == null || this.fhI.getSourceImageRectInScreen() == null) {
                canvas.drawBitmap(this.fku, this.fkw, this.mDstRect, (Paint) null);
            } else {
                canvas.drawBitmap(this.fku, this.fkx, this.mDstRect, (Paint) null);
            }
        } else {
            super.dispatchDraw(canvas);
        }
    }

    private void startExitAnimation() {
        if (this.fhI == null) {
            if (this.fkz != null) {
                this.fkz.onDragEnd();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.fhI.getSourceImageRectInScreen();
        final Rect dstRectInScreen = this.fhI.getDstRectInScreen();
        if (sourceImageRectInScreen == null || dstRectInScreen == null) {
            if (this.fkz != null) {
                this.fkz.onDragEnd();
                return;
            }
            return;
        }
        a(sourceImageRectInScreen, dstRectInScreen);
        b(sourceImageRectInScreen);
        this.fkv = new RectF(this.mDstRect);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(150L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && sourceImageRectInScreen != null && dstRectInScreen != null) {
                    UrlDragImageView.this.al(valueAnimator.getAnimatedFraction());
                    UrlDragImageView.this.a(dstRectInScreen, valueAnimator.getAnimatedFraction(), UrlDragImageView.this.fkR);
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
                if (UrlDragImageView.this.fkz != null) {
                    UrlDragImageView.this.fkz.onDragEnd();
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
            this.mDstRect.top += this.mDstRect.height() * this.fkF;
            this.mDstRect.bottom = f + this.mDstRect.top;
        }
    }

    public void setCanScale(boolean z) {
        if (this.fkk != null) {
            this.fkk.setCanScale(z);
        }
    }

    private void a(Rect rect, Rect rect2) {
        this.fkB = 0.0f;
        this.fkC = 0.0f;
        this.fkD = 1.0f;
        this.fkE = 1.0f;
        if (rect != null && rect2 != null && rect.contains(rect2)) {
            this.fkB = (rect2.left - rect.left) / rect.width();
            this.fkC = (rect2.top - rect.top) / rect.height();
            this.fkD = (rect2.right - rect.left) / rect.width();
            this.fkE = (rect2.bottom - rect.top) / rect.height();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void al(float f) {
        if (this.fkx != null) {
            this.fkx.left = (int) (this.fky.left + (this.fky.width() * this.fkB * f));
            this.fkx.top = (int) (this.fky.top + (this.fky.height() * this.fkC * f));
            this.fkx.right = (int) (this.fky.left + (this.fky.width() * (((1.0f - this.fkD) * (1.0f - f)) + this.fkD)));
            this.fkx.bottom = (int) (this.fky.top + (this.fky.height() * (((1.0f - this.fkE) * (1.0f - f)) + this.fkE)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Rect rect, float f, boolean z) {
        int i = 0;
        if (z) {
            i = l.getDimens(getContext(), R.dimen.tbds80);
        }
        if (this.mDstRect != null && rect != null) {
            this.mDstRect.left = this.fkv.left + ((rect.left - this.fkv.left) * f);
            this.mDstRect.top = (this.fkv.top + ((rect.top - this.fkv.top) * f)) - i;
            this.mDstRect.right = this.fkv.right + ((rect.right - this.fkv.right) * f);
            this.mDstRect.bottom = this.fkv.bottom + ((rect.bottom - this.fkv.bottom) * f);
        }
    }

    private RectF getRectInScreenFromPosition(float f, float f2, float f3, float f4) {
        return new RectF(f - (f3 / 2.0f), f2 - (f4 / 2.0f), (f3 / 2.0f) + f, (f4 / 2.0f) + f2);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.fkL = onTouchListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxZ() {
        if ((this.fkp || this.fkq) && this.fhI != null && this.fhI.mPicType == 1 && !TextUtils.isEmpty(this.fhI.mTagName)) {
            if (this.fkl != null) {
                this.fkl.setVisibility(8);
                this.fkl = null;
            }
            this.fkl = new TextView(this.mContext);
            this.fkl.setText(this.fhI.mTagName);
            this.fkl.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize26));
            ap.setViewTextColor(this.fkl, R.color.common_color_10013, 1, 0);
            ap.setBackgroundColor(this.fkl, R.color.common_color_10215);
            this.fkl.setAlpha(0.75f);
            this.fkl.setIncludeFontPadding(false);
            this.fkl.setGravity(17);
            int dimens = l.getDimens(this.mContext, R.dimen.ds2);
            this.fkl.setPadding(dimens, dimens, dimens, dimens);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.fkk.getBottomOffset();
            layoutParams.leftMargin = this.fkk.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.fkl, layoutParams);
            this.fkl.setVisibility(0);
        }
    }

    public void setUrl(String str, boolean z) {
        if (str.contains("*")) {
            str = str.split("[*]")[0];
        }
        this.fkk.setTag(str);
        this.fkk.setLoadBigImage(false);
        this.fkk.setImageDrawable(null);
        this.fkp = false;
        this.fkq = false;
        this.fkG = byh();
        this.fkO = null;
        if (Di(str)) {
            e(str, z, false);
        }
    }

    private boolean bya() {
        return this.fkk != null && this.fkk.isLoadBigImage();
    }

    public void byb() {
        if (this.fhI != null && !bya()) {
            String str = this.fhI.imageUrl;
            int i = this.fhI.urlType;
            com.baidu.adp.widget.ImageView.a aVar = null;
            if (com.baidu.tbadk.core.util.c.a.an(str, i)) {
                aVar = com.baidu.tbadk.core.util.c.a.ao(str, i);
            }
            if (aVar != null) {
                setThumbBitmapToView(aVar);
            }
        }
    }

    private boolean jQ(boolean z) {
        String nameMd5FromUrl;
        if (!this.fkH || z) {
            this.fkH = true;
            if (!this.fkG || this.fhI == null || StringUtils.isNull(this.fhI.originalUrl, true) || this.fhI.originalSize < 0 || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String str = this.fkA + as.brl().BU(nameMd5FromUrl) + "/" + av.getNameMd5FromUrl(this.fhI.originalUrl);
            final int[] imageFileWH = n.getImageFileWH(str);
            this.fkm.setVisibility(0);
            if (this.fkn == null) {
                this.fkn = new SubsamplingScaleImageView.OnImageEventListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12
                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onReady() {
                        UrlDragImageView.this.fkO = null;
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.fkk.restoreSize();
                        UrlDragImageView.this.fkk.setVisibility(4);
                    }

                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onImageLoaded() {
                        if (UrlDragImageView.this.fhI.isLongPic && imageFileWH[0] > 0) {
                            UrlDragImageView.this.fkk.onDestroy();
                            final float measuredWidth = (UrlDragImageView.this.getMeasuredWidth() * 1.0f) / imageFileWH[0];
                            final PointF pointF = new PointF((imageFileWH[0] * 1.0f) / 2.0f, 0.0f);
                            UrlDragImageView.this.fkm.setScaleAndCenter(measuredWidth, pointF);
                            UrlDragImageView.this.fkm.setMaxScale(2.0f * measuredWidth);
                            UrlDragImageView.this.fkm.setDoubleTapZoomScale(2.0f * measuredWidth);
                            UrlDragImageView.this.fkm.setInitScale(measuredWidth);
                            UrlDragImageView.this.fkm.setDoubleTapZoomStyle(4);
                            UrlDragImageView.this.fkm.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12.1
                                @Override // android.view.View.OnTouchListener
                                public boolean onTouch(View view, MotionEvent motionEvent) {
                                    if (UrlDragImageView.this.fkL != null) {
                                        UrlDragImageView.this.fkL.onTouch(view, motionEvent);
                                    }
                                    switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                                        case 0:
                                            UrlDragImageView.this.fkN = motionEvent.getY();
                                            UrlDragImageView.this.fkm.setOnClickListener(UrlDragImageView.this.fkM ? UrlDragImageView.this.mOnClickListener : null);
                                            UrlDragImageView.this.fkm.setOnLongClickListener(UrlDragImageView.this.fkM ? UrlDragImageView.this.mLongClickListener : null);
                                            break;
                                        case 1:
                                        case 3:
                                            if (UrlDragImageView.this.fkm.getScale() < measuredWidth) {
                                                UrlDragImageView.this.fkm.setScaleAndCenter(measuredWidth, pointF);
                                            }
                                            e.mY().removeCallbacks(UrlDragImageView.this.fkS);
                                            e.mY().postDelayed(UrlDragImageView.this.fkS, 1000L);
                                            break;
                                        case 2:
                                            if (Math.abs(motionEvent.getY() - UrlDragImageView.this.fkN) > UrlDragImageView.TOUCH_SLOP) {
                                                UrlDragImageView.this.fkM = false;
                                                UrlDragImageView.this.fkm.setOnClickListener(null);
                                                UrlDragImageView.this.fkm.setOnLongClickListener(null);
                                            }
                                            UrlDragImageView.this.fkN = motionEvent.getY();
                                            break;
                                    }
                                    return false;
                                }
                            });
                            UrlDragImageView.this.fkk.setVisibility(4);
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
            this.fkm.setOnImageEventListener(this.fkn);
            if (this.fkm.isImageLoaded() && this.fhI.isLongPic) {
                this.fkn.onImageLoaded();
            } else {
                this.fkm.setImage(ImageSource.uri(str));
            }
            return true;
        }
        return false;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.fkz = dVar;
        if (this.fkk != null) {
            this.fkk.setDragToExitListener(dVar);
        }
    }

    public void byc() {
        jQ(false);
    }

    private boolean Di(String str) {
        return j.isNetWorkAvailable() || com.baidu.tbadk.core.util.c.c.Ch(str);
    }

    private void setThumbBitmapToView(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap rawBitmap;
        if (!this.fkq && aVar != null && (rawBitmap = aVar.getRawBitmap()) != null) {
            this.fkp = true;
            if (aVar.isGif()) {
                this.fkk.setImageUrlData(this.fhI);
                this.fkk.setImageBitmap(rawBitmap);
                this.fkO = null;
                this.fkJ = false;
            } else {
                if (this.fhI != null && this.fhI.isLongPic) {
                    this.fkk.createLargeImageDelegate();
                    this.fkk.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.13
                        @Override // com.baidu.tbadk.widget.largeImage.logic.a
                        public void onLoadFinished() {
                        }
                    });
                }
                this.fkk.setImageUrlData(this.fhI);
                this.fkk.setImageData(rawBitmap, aVar.getByteData());
            }
            bxZ();
        }
    }

    private void e(String str, boolean z, boolean z2) {
        if (Dj(str)) {
            if (z2 || (!this.fkr && !this.fkq)) {
                if (!z2 || !jQ(true)) {
                    this.fkr = true;
                    com.baidu.adp.lib.e.c.mS().a(str, 27, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.14
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.b
                        public void onCancelled(String str2) {
                            UrlDragImageView.this.fkr = false;
                            UrlDragImageView.this.fkk.setVisibility(0);
                            UrlDragImageView.this.mProgressBar.setVisibility(8);
                            UrlDragImageView.this.fkO = null;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            UrlDragImageView.this.fkr = false;
                            UrlDragImageView.this.fkq = true;
                            UrlDragImageView.this.b(aVar);
                        }
                    }, 0, 0, false, null, Boolean.valueOf(z), this.fkk.getImageData(), Boolean.valueOf(this.fiO));
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
        com.baidu.adp.widget.ImageView.a a2 = this.fkK.a(imageFileInfo, false);
        if (a2 != null) {
            this.fkq = true;
            this.mProgressBar.setVisibility(8);
            this.fkO = null;
            b(a2);
            return;
        }
        this.fkK.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.2
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.ImageView.a aVar, String str2, boolean z3) {
                UrlDragImageView.this.fkq = true;
                UrlDragImageView.this.mProgressBar.setVisibility(8);
                UrlDragImageView.this.fkO = null;
                UrlDragImageView.this.b(aVar);
            }
        }, false);
    }

    private boolean Dj(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null && this.fko != null) {
            this.fko.k(aVar.getUrl(), aVar.getByteData());
        }
        if (aVar == null || aVar.getRawBitmap() == null) {
            byd();
            return;
        }
        Bitmap rawBitmap = aVar.getRawBitmap();
        this.fkk.setLoadBigImage(true);
        if (aVar.isGif()) {
            this.fkk.setGifData(aVar.getByteData(), rawBitmap);
            this.fkk.invalidate();
            this.fkk.play();
            this.fkJ = false;
            this.fkO = null;
            this.mProgressBar.setVisibility(8);
        } else {
            if (this.fhI != null && this.fhI.isLongPic) {
                this.fkk.createLargeImageDelegate();
                this.fkk.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.3
                    @Override // com.baidu.tbadk.widget.largeImage.logic.a
                    public void onLoadFinished() {
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.fkO = null;
                    }
                });
            } else {
                this.mProgressBar.setVisibility(8);
                this.fkO = null;
            }
            this.fkk.setImageUrlData(this.fhI);
            this.fkk.setImageData(rawBitmap, aVar.getByteData());
            byi();
        }
        bxZ();
    }

    private void byd() {
        if (!this.fkp) {
            this.fkk.setDefaultBitmap();
        } else {
            this.fkq = false;
        }
        this.fkO = null;
        this.mProgressBar.setVisibility(8);
    }

    public void setGifMaxUseableMem(int i) {
        this.fkk.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.fkk != null) {
            this.fkk.onDestroy();
        }
        if (this.fkm != null) {
            this.fkm.recycle();
        }
        if (this.fku != null) {
            this.fku.recycle();
            this.fku = null;
        }
        if (this.mProgressBar != null) {
            this.fkO = null;
            this.mProgressBar.setVisibility(8);
        }
        e.mY().removeCallbacks(this.fkS);
        com.baidu.tieba.view.c.dSy().setColor(-1);
    }

    public void release() {
        if (this.fkk != null) {
            this.fkk.release();
        }
        if (this.mProgressBar != null) {
            this.fkO = null;
            this.mProgressBar.setVisibility(8);
        }
        this.fkO = null;
    }

    public void bye() {
        if (this.fkk != null && this.fkk.getImageType() == 1) {
            this.fkk.stop();
        }
    }

    public void E(boolean z, boolean z2) {
        String str;
        if (this.fkk != null && (str = (String) this.fkk.getTag()) != null) {
            if (this.fkk.getImageType() == 1) {
                if (this.fkk.getGifCache() == null || !this.fkk.isLoadBigImage()) {
                    e(str, z, z2);
                }
            } else if (this.fkk.getImageType() == 2) {
                e(str, z, z2);
            } else if (byf()) {
                e(str, z, z2);
            }
        }
    }

    private boolean byf() {
        if (this.fkk.getImageBitmap() != null && this.fkk.isLoadBigImage()) {
            if (this.fhI == null || !this.fhI.isLongPic || this.fkk.hasLoadLongImage()) {
                return false;
            }
            this.fkq = false;
            this.fkH = false;
            return true;
        }
        return true;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.fhI = imageUrlData;
    }

    public ImageUrlData getmAssistUrlData() {
        return this.fhI;
    }

    public void setIsCdn(boolean z) {
        this.fiO = z;
    }

    public void byg() {
        final String nameMd5FromUrl = av.getNameMd5FromUrl(this.fhI.originalUrl);
        if (this.fhI.originalProcess >= 0) {
            com.baidu.tbadk.download.d.bzt().cancelDownLoadById(nameMd5FromUrl, 13);
            this.fhI.originalProcess = -1;
            byi();
            return;
        }
        if (this.fiH != null) {
            this.fiH.byl();
        }
        com.baidu.adp.base.e<?> I = i.I(this.mContext);
        if (I == null) {
            Dk(nameMd5FromUrl);
        } else if (!j.isNetWorkAvailable() || j.isWifiNet() || com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean(SharedPrefConfig.ORIGINAL_IMG_DOWN_TIP, false)) {
            Dk(nameMd5FromUrl);
        } else {
            com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean(SharedPrefConfig.ORIGINAL_IMG_DOWN_TIP, true);
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(I.getPageActivity());
            aVar.ow(R.string.original_img_down_no_wifi_tip);
            aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    UrlDragImageView.this.Dk(nameMd5FromUrl);
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                }
            });
            aVar.b(I);
            aVar.bpc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dk(String str) {
        if (this.fhI != null) {
            this.fhI.originalProcess = 0;
            this.fkP.setProgress(0);
            this.fkP.setVisibility(0);
            DownloadData downloadData = new DownloadData(str);
            downloadData.setStatus(1);
            downloadData.setUrl(this.fhI.originalUrl);
            downloadData.setType(13);
            downloadData.setPath(this.fkA + as.brl().BU(str) + "/" + str);
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.6
                @Override // com.baidu.tbadk.download.c
                public boolean onPreDownload(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2 != null) {
                        if (UrlDragImageView.this.fhI != null && UrlDragImageView.this.fhI.originalProcess != -1) {
                            UrlDragImageView.this.fhI.originalProcess = downloadData2.getProcess();
                        }
                        if (UrlDragImageView.this.fhI == null || UrlDragImageView.this.fhI.originalProcess != -1) {
                            UrlDragImageView.this.fkP.setProgress(downloadData2.getProcess());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public boolean onFileDownloaded(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadSucceed(DownloadData downloadData2) {
                    UrlDragImageView.this.fkP.setVisibility(8);
                    e.mY().postDelayed(UrlDragImageView.this.fkT, 1500L);
                    UrlDragImageView.this.fkH = false;
                    UrlDragImageView.this.fkG = UrlDragImageView.this.byh();
                    UrlDragImageView.this.byc();
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str2) {
                    UrlDragImageView.this.fkP.setVisibility(8);
                    UrlDragImageView.this.fkH = false;
                    BdToast.b(UrlDragImageView.this.mContext, str2).bph().bpi();
                    UrlDragImageView.this.fhI.originalProcess = -1;
                    UrlDragImageView.this.byi();
                }
            });
            com.baidu.tbadk.download.d.bzt().a(downloadData, 100);
            this.fkQ = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean byh() {
        if (this.fhI != null && !StringUtils.isNull(this.fhI.originalUrl, true) && this.fhI.originalSize >= 0 && !this.fhI.isBlockedPic) {
            String nameMd5FromUrl = av.getNameMd5FromUrl(this.fhI.originalUrl);
            File file = new File(this.fkA + as.brl().BU(nameMd5FromUrl) + "/" + nameMd5FromUrl);
            if (file != null && file.exists()) {
                this.fhI.originalProcess = 100;
                return true;
            }
            if (this.fhI.originalProcess < 0) {
                byi();
            } else {
                this.fkP.setProgress(this.fhI.originalProcess);
            }
            this.fkJ = true;
        } else {
            this.fkO = null;
        }
        return false;
    }

    public void byi() {
        if (this.fhI != null) {
            if (!byj() || !this.fkJ) {
                this.fkO = null;
            } else if (this.fhI.originalSize > 0 && !dE(this.fhI.originalSize)) {
                this.fkO = fki + "(" + at.getFormatSize(this.fhI.originalSize) + ")";
            } else {
                this.fkO = fki;
            }
        }
    }

    private boolean byj() {
        return (this.fhI == null || !this.fhI.mIsShowOrigonButton || this.fhI.isBlockedPic || StringUtils.isNull(this.fhI.originalUrl)) ? false : true;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.fiH = bVar;
    }

    private boolean dE(long j) {
        return j > fkj;
    }
}
