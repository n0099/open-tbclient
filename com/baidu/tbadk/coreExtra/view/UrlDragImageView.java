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
/* loaded from: classes20.dex */
public class UrlDragImageView extends RelativeLayout {
    private ImageUrlData eHo;
    private b eIk;
    private boolean eIr;
    private boolean eIt;
    protected DragImageView eJO;
    protected TextView eJP;
    protected SubsamplingScaleImageView eJQ;
    private SubsamplingScaleImageView.OnImageEventListener eJR;
    private a eJS;
    private boolean eJT;
    private boolean eJU;
    private boolean eJV;
    private boolean eJW;
    private boolean eJX;
    private Bitmap eJY;
    private RectF eJZ;
    private Rect eKa;
    private Rect eKb;
    private Rect eKc;
    private DragImageView.d eKd;
    private String eKe;
    private float eKf;
    private float eKg;
    private float eKh;
    private float eKi;
    private float eKj;
    private boolean eKk;
    private boolean eKl;
    private boolean eKm;
    public boolean eKn;
    private com.baidu.tbadk.img.b eKo;
    private View.OnTouchListener eKp;
    private boolean eKq;
    private float eKr;
    private String eKs;
    private CircleProgressView eKt;
    private boolean eKu;
    private boolean eKv;
    private Runnable eKw;
    private Runnable eKx;
    private View.OnTouchListener eKy;
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
    private static final String eJM = TbadkCoreApplication.getInst().getString(R.string.original_img_look);
    private static long eJN = Config.RAVEN_LOG_LIMIT;
    private static final int EXIT_DISTANCE = l.getEquipmentHeight(TbadkCoreApplication.getInst()) / 5;
    private static final String TAG = UrlDragImageView.class.getSimpleName();
    private static final int TOUCH_SLOP = ViewConfiguration.get(TbadkCoreApplication.getInst()).getScaledTouchSlop();

    /* loaded from: classes20.dex */
    public interface a {
        void k(String str, byte[] bArr);
    }

    /* loaded from: classes20.dex */
    public interface b {
        void brj();
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
        if (this.eJO != null) {
            this.eJO.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.eJS = aVar;
    }

    public UrlDragImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.eJO = null;
        this.eJS = null;
        this.eIr = false;
        this.eJV = false;
        this.isInDragScaleMode = false;
        this.mRatio = 1.0f;
        this.mMoveDistance = 0.0f;
        this.mDragMatrix = new Matrix();
        this.mDstRect = new RectF();
        this.eKf = 0.0f;
        this.eKg = 0.0f;
        this.eKh = 1.0f;
        this.eKi = 1.0f;
        this.eKj = 0.0f;
        this.eKk = false;
        this.eKl = false;
        this.eKm = false;
        this.eKn = false;
        this.eKq = true;
        this.eKr = 0.0f;
        this.mOnClickListener = null;
        this.mLongClickListener = null;
        this.eKs = null;
        this.eKw = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.eKq = true;
            }
        };
        this.eKx = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.eKt.setVisibility(8);
                        UrlDragImageView.this.eKs = null;
                        UrlDragImageView.this.eKn = false;
                    }
                });
            }
        };
        this.eKy = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.eKp != null) {
                    UrlDragImageView.this.eKp.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.eKo = new com.baidu.tbadk.img.b();
        init();
    }

    public UrlDragImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.eJO = null;
        this.eJS = null;
        this.eIr = false;
        this.eJV = false;
        this.isInDragScaleMode = false;
        this.mRatio = 1.0f;
        this.mMoveDistance = 0.0f;
        this.mDragMatrix = new Matrix();
        this.mDstRect = new RectF();
        this.eKf = 0.0f;
        this.eKg = 0.0f;
        this.eKh = 1.0f;
        this.eKi = 1.0f;
        this.eKj = 0.0f;
        this.eKk = false;
        this.eKl = false;
        this.eKm = false;
        this.eKn = false;
        this.eKq = true;
        this.eKr = 0.0f;
        this.mOnClickListener = null;
        this.mLongClickListener = null;
        this.eKs = null;
        this.eKw = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.eKq = true;
            }
        };
        this.eKx = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.eKt.setVisibility(8);
                        UrlDragImageView.this.eKs = null;
                        UrlDragImageView.this.eKn = false;
                    }
                });
            }
        };
        this.eKy = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.eKp != null) {
                    UrlDragImageView.this.eKp.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.eKo = new com.baidu.tbadk.img.b();
        init();
    }

    public DragImageView getImageView() {
        return this.eJO;
    }

    public void setGifSetListener(DragImageView.e eVar) {
        this.eJO.setGifSetListener(eVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.eJO.setImageOnClickListener(onClickListener);
        this.eJQ.setOnClickListener(onClickListener);
        this.mOnClickListener = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mLongClickListener = onLongClickListener;
        if (!this.eIt) {
            this.eJO.setImageOnLongClickListener(this.mLongClickListener);
            this.eJQ.setOnLongClickListener(this.mLongClickListener);
        }
    }

    public void setOnSizeChangedListener(final DragImageView.g gVar) {
        this.eJO.setOnSizeChangedListener(new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.8
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (gVar != null) {
                    gVar.a(dragImageView, z, z2);
                }
                UrlDragImageView.this.bqX();
            }
        });
    }

    protected void init() {
        this.eKe = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        this.mMaxWidth = l.getEquipmentWidth(this.mContext);
        this.mMaxHeight = l.getEquipmentHeight(this.mContext) - ((int) this.mContext.getResources().getDimension(R.dimen.ds166));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.eJO = new DragImageView(this.mContext);
        this.eJO.setLayoutParams(layoutParams);
        this.eJO.setOnTouchListener(this.eKy);
        addView(this.eJO);
        this.eJQ = new SubsamplingScaleImageView(this.mContext);
        this.eJQ.setMaxScale(50.0f);
        this.eJQ.setOnTouchListener(this.eKy);
        this.eJQ.setVisibility(4);
        addView(this.eJQ, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(getResources().getDrawable(R.drawable.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        bqW();
        this.eKv = TbSingleton.getInstance().isCutoutScreen(TbadkApplication.getInst().getCurrentActivity());
    }

    private void bqW() {
        this.eKt = new CircleProgressView(this.mContext);
        this.eKt.setCircleBackgroundColor(ap.getColor(R.color.cp_cont_d));
        this.eKt.setCircleForegroundColor(ap.getColor(R.color.cp_link_tip_a));
        this.eKt.setProgress(0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds80), l.getDimens(getContext(), R.dimen.tbds80));
        layoutParams.addRule(13);
        this.eKt.setVisibility(8);
        addView(this.eKt, layoutParams);
    }

    public void setIsCanDrag(boolean z) {
        this.eIt = z;
    }

    public String getmCheckOriginPicText() {
        return this.eKs;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        Bitmap imageBitmap;
        int height;
        int width;
        if (this.eKk && !this.eKu && this.eJQ.getVisibility() == 0 && !this.eJQ.isImageLoaded()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.eIt || !this.eJU) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.eJW && motionEvent.getPointerCount() >= 2) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.eJW || this.eJX) {
            requestDisallowInterceptTouchEvent(true);
        }
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        float x = motionEvent.getX();
        int i = action & 255;
        if (i == 0) {
            if (this.eJY == null) {
                if (this.eJQ.getVisibility() == 0) {
                    this.eJY = h.bx(this.eJQ);
                } else {
                    this.eJY = h.bx(this.eJO);
                }
            }
            if (this.mDisplayRect == null && this.eJY != null) {
                int measuredWidth = getMeasuredWidth();
                float measuredWidth2 = ((getMeasuredWidth() * 1.0f) / this.eJY.getWidth()) * this.eJY.getHeight();
                if (measuredWidth2 > getMeasuredHeight()) {
                    measuredWidth2 = getMeasuredHeight();
                }
                RectF rectInScreenFromPosition = getRectInScreenFromPosition(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
                this.mDisplayRect = new Rect((int) rectInScreenFromPosition.left, (int) rectInScreenFromPosition.top, (int) rectInScreenFromPosition.right, (int) rectInScreenFromPosition.bottom);
            }
            if (this.eKb == null && this.eJY != null) {
                if (this.eJQ.getVisibility() == 0) {
                    height = this.eJQ.getSHeight();
                    width = this.eJQ.getSWidth();
                } else {
                    if (this.eJO.getImageType() == 1) {
                        imageBitmap = (this.eJO.getCurrentFrame() == null || this.eJO.getCurrentFrame().bm == null) ? this.eJY : this.eJO.getCurrentFrame().bm;
                    } else {
                        imageBitmap = this.eJO.getImageBitmap() == null ? this.eJY : this.eJO.getImageBitmap();
                    }
                    height = imageBitmap.getHeight();
                    width = imageBitmap.getWidth();
                }
                float equipmentDensity = l.getEquipmentDensity(getContext());
                int i2 = (int) (height * equipmentDensity);
                int i3 = (int) (width * equipmentDensity);
                if (i3 > this.eJY.getWidth() && this.eJY.getWidth() != 0) {
                    float width2 = (i3 * 1.0f) / this.eJY.getWidth();
                    i3 = this.eJY.getWidth();
                    i2 = (int) (i2 / width2);
                }
                if (i2 > this.eJY.getHeight() && this.eJY.getHeight() != 0) {
                    i3 = (int) (i3 / ((i2 * 1.0f) / this.eJY.getHeight()));
                    i2 = this.eJY.getHeight();
                }
                int equipmentHeight = (l.getEquipmentHeight(getContext()) - i2) / 2;
                int equipmentWidth = (l.getEquipmentWidth(getContext()) - i3) / 2;
                this.eKb = new Rect(equipmentWidth, equipmentHeight, i3 + equipmentWidth, i2 + equipmentHeight);
                this.eKc = new Rect(this.eKb);
                this.eKj = equipmentHeight / l.getEquipmentHeight(getContext());
                this.eKa = new Rect(0, 0, this.eJY.getWidth(), this.eJY.getHeight());
            }
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (i == 2) {
            this.eJW = w(this.mLastMotionX - x, this.mLastMotionY - y);
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (this.eJW || this.eJX) {
            this.eJO.setImageOnLongClickListener(null);
            this.eJQ.setOnLongClickListener(null);
            z = true;
        } else {
            this.eJO.setImageOnLongClickListener(this.mLongClickListener);
            this.eJQ.setOnLongClickListener(this.mLongClickListener);
            z = super.dispatchTouchEvent(motionEvent);
        }
        if (i == 1 || i == 3) {
            this.mLastMotionX = 0.0f;
            this.mLastMotionY = 0.0f;
            boolean z2 = (-this.mMoveDistance) > ((float) EXIT_DISTANCE);
            boolean z3 = this.mMoveDistance > ((float) EXIT_DISTANCE);
            if (z2 || z3) {
                this.eJX = true;
                startExitAnimation();
                if (z2) {
                    TiebaStatic.log(new aq("c13377").dF("obj_type", "3"));
                } else if (z3) {
                    TiebaStatic.log(new aq("c13377").dF("obj_type", "2"));
                }
            } else {
                if (this.eJW && this.eKd != null) {
                    this.eKd.bxi();
                }
                this.mRatio = 1.0f;
                invalidate();
            }
            this.isInDragScaleMode = false;
            this.mDragMatrix.reset();
            this.eJW = false;
        }
        return z;
    }

    private boolean w(float f, float f2) {
        if (this.eJQ.getVisibility() != 0 || this.eJQ.isCanDrag()) {
            if (this.eHo == null || !this.eHo.isLongPic || this.eJQ.getVisibility() != 0 || this.eJQ.isViewTop()) {
                if (this.eHo == null || !this.eHo.isLongPic || this.eJQ.getVisibility() == 0 || this.eJO.isAtViewTop() || this.eJO.bxg()) {
                    if (this.eJQ.getVisibility() == 0 || this.eJO.pagerCantScroll()) {
                        if (this.eJY != null && getScrollY() == 0) {
                            boolean z = (this.eHo == null || !this.eHo.isLongPic) && ((f2 < -15.0f && !this.isInDragScaleMode) || (f2 > 15.0f && !this.isInDragScaleMode));
                            boolean z2 = this.eHo != null && this.eHo.isLongPic && f2 < 0.0f && !this.isInDragScaleMode;
                            if (z || (z2 && this.eJO.isViewTop())) {
                                this.eJO.setImageOnLongClickListener(null);
                                this.eJQ.setOnLongClickListener(null);
                                this.isInDragScaleMode = true;
                                this.mMoveDistance = 0.0f;
                                this.mRatio = 1.0f;
                                if (this.eKd != null) {
                                    this.eKd.onDragStart();
                                }
                            }
                        }
                        if (!this.isInDragScaleMode || this.eJY == null) {
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
                        this.mDragMatrix.preScale(1.0f + f3, 1.0f + f3, (this.mRatio * this.eJY.getWidth()) / 2.0f, this.mRatio * (this.eJY.getHeight() / 2));
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
        if (this.eJW && this.eJY != null && !this.eJY.isRecycled() && this.isInDragScaleMode) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.mDstRect == null) {
                this.mDstRect = new RectF();
            }
            this.mDragMatrix.mapRect(this.mDstRect, new RectF(this.mDisplayRect));
            canvas.drawBitmap(this.eJY, this.eKa, this.mDstRect, (Paint) null);
        } else if (this.eJX && this.eJY != null && !this.eJY.isRecycled()) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.eHo == null || this.eHo.getSourceImageRectInScreen() == null) {
                canvas.drawBitmap(this.eJY, this.eKa, this.mDstRect, (Paint) null);
            } else {
                canvas.drawBitmap(this.eJY, this.eKb, this.mDstRect, (Paint) null);
            }
        } else {
            super.dispatchDraw(canvas);
        }
    }

    private void startExitAnimation() {
        if (this.eHo == null) {
            if (this.eKd != null) {
                this.eKd.onDragEnd();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.eHo.getSourceImageRectInScreen();
        final Rect dstRectInScreen = this.eHo.getDstRectInScreen();
        if (sourceImageRectInScreen == null || dstRectInScreen == null) {
            if (this.eKd != null) {
                this.eKd.onDragEnd();
                return;
            }
            return;
        }
        a(sourceImageRectInScreen, dstRectInScreen);
        b(sourceImageRectInScreen);
        this.eJZ = new RectF(this.mDstRect);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(150L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && sourceImageRectInScreen != null && dstRectInScreen != null) {
                    UrlDragImageView.this.af(valueAnimator.getAnimatedFraction());
                    UrlDragImageView.this.a(dstRectInScreen, valueAnimator.getAnimatedFraction(), UrlDragImageView.this.eKv);
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
                if (UrlDragImageView.this.eKd != null) {
                    UrlDragImageView.this.eKd.onDragEnd();
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
            this.mDstRect.top += this.mDstRect.height() * this.eKj;
            this.mDstRect.bottom = f + this.mDstRect.top;
        }
    }

    public void setCanScale(boolean z) {
        if (this.eJO != null) {
            this.eJO.setCanScale(z);
        }
    }

    private void a(Rect rect, Rect rect2) {
        this.eKf = 0.0f;
        this.eKg = 0.0f;
        this.eKh = 1.0f;
        this.eKi = 1.0f;
        if (rect != null && rect2 != null && rect.contains(rect2)) {
            this.eKf = (rect2.left - rect.left) / rect.width();
            this.eKg = (rect2.top - rect.top) / rect.height();
            this.eKh = (rect2.right - rect.left) / rect.width();
            this.eKi = (rect2.bottom - rect.top) / rect.height();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void af(float f) {
        if (this.eKb != null) {
            this.eKb.left = (int) (this.eKc.left + (this.eKc.width() * this.eKf * f));
            this.eKb.top = (int) (this.eKc.top + (this.eKc.height() * this.eKg * f));
            this.eKb.right = (int) (this.eKc.left + (this.eKc.width() * (((1.0f - this.eKh) * (1.0f - f)) + this.eKh)));
            this.eKb.bottom = (int) (this.eKc.top + (this.eKc.height() * (((1.0f - this.eKi) * (1.0f - f)) + this.eKi)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Rect rect, float f, boolean z) {
        int i = 0;
        if (z) {
            i = l.getDimens(getContext(), R.dimen.tbds80);
        }
        if (this.mDstRect != null && rect != null) {
            this.mDstRect.left = this.eJZ.left + ((rect.left - this.eJZ.left) * f);
            this.mDstRect.top = (this.eJZ.top + ((rect.top - this.eJZ.top) * f)) - i;
            this.mDstRect.right = this.eJZ.right + ((rect.right - this.eJZ.right) * f);
            this.mDstRect.bottom = this.eJZ.bottom + ((rect.bottom - this.eJZ.bottom) * f);
        }
    }

    private RectF getRectInScreenFromPosition(float f, float f2, float f3, float f4) {
        return new RectF(f - (f3 / 2.0f), f2 - (f4 / 2.0f), (f3 / 2.0f) + f, (f4 / 2.0f) + f2);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.eKp = onTouchListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqX() {
        if ((this.eJT || this.eJU) && this.eHo != null && this.eHo.mPicType == 1 && !TextUtils.isEmpty(this.eHo.mTagName)) {
            if (this.eJP != null) {
                this.eJP.setVisibility(8);
                this.eJP = null;
            }
            this.eJP = new TextView(this.mContext);
            this.eJP.setText(this.eHo.mTagName);
            this.eJP.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize26));
            ap.setViewTextColor(this.eJP, R.color.common_color_10013, 1, 0);
            ap.setBackgroundColor(this.eJP, R.color.common_color_10215);
            this.eJP.setAlpha(0.75f);
            this.eJP.setIncludeFontPadding(false);
            this.eJP.setGravity(17);
            int dimens = l.getDimens(this.mContext, R.dimen.ds2);
            this.eJP.setPadding(dimens, dimens, dimens, dimens);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.eJO.getBottomOffset();
            layoutParams.leftMargin = this.eJO.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.eJP, layoutParams);
            this.eJP.setVisibility(0);
        }
    }

    public void setUrl(String str, boolean z) {
        if (str.contains("*")) {
            str = str.split("[*]")[0];
        }
        this.eJO.setTag(str);
        this.eJO.setLoadBigImage(false);
        this.eJO.setImageDrawable(null);
        this.eJT = false;
        this.eJU = false;
        this.eKk = brf();
        this.eKs = null;
        if (BP(str)) {
            e(str, z, false);
        }
    }

    private boolean bqY() {
        return this.eJO != null && this.eJO.isLoadBigImage();
    }

    public void bqZ() {
        if (this.eHo != null && !bqY()) {
            String str = this.eHo.imageUrl;
            int i = this.eHo.urlType;
            com.baidu.adp.widget.ImageView.a aVar = null;
            if (com.baidu.tbadk.core.util.c.a.ak(str, i)) {
                aVar = com.baidu.tbadk.core.util.c.a.al(str, i);
            }
            if (aVar != null) {
                setThumbBitmapToView(aVar);
            }
        }
    }

    private boolean iW(boolean z) {
        String nameMd5FromUrl;
        if (!this.eKl || z) {
            this.eKl = true;
            if (!this.eKk || this.eHo == null || StringUtils.isNull(this.eHo.originalUrl, true) || this.eHo.originalSize < 0 || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String str = this.eKe + as.bkj().AB(nameMd5FromUrl) + "/" + av.getNameMd5FromUrl(this.eHo.originalUrl);
            final int[] imageFileWH = n.getImageFileWH(str);
            this.eJQ.setVisibility(0);
            if (this.eJR == null) {
                this.eJR = new SubsamplingScaleImageView.OnImageEventListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12
                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onReady() {
                        UrlDragImageView.this.eKs = null;
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.eJO.restoreSize();
                        UrlDragImageView.this.eJO.setVisibility(4);
                    }

                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onImageLoaded() {
                        if (UrlDragImageView.this.eHo.isLongPic && imageFileWH[0] > 0) {
                            UrlDragImageView.this.eJO.onDestroy();
                            final float measuredWidth = (UrlDragImageView.this.getMeasuredWidth() * 1.0f) / imageFileWH[0];
                            final PointF pointF = new PointF((imageFileWH[0] * 1.0f) / 2.0f, 0.0f);
                            UrlDragImageView.this.eJQ.setScaleAndCenter(measuredWidth, pointF);
                            UrlDragImageView.this.eJQ.setMaxScale(2.0f * measuredWidth);
                            UrlDragImageView.this.eJQ.setDoubleTapZoomScale(2.0f * measuredWidth);
                            UrlDragImageView.this.eJQ.setInitScale(measuredWidth);
                            UrlDragImageView.this.eJQ.setDoubleTapZoomStyle(4);
                            UrlDragImageView.this.eJQ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12.1
                                @Override // android.view.View.OnTouchListener
                                public boolean onTouch(View view, MotionEvent motionEvent) {
                                    if (UrlDragImageView.this.eKp != null) {
                                        UrlDragImageView.this.eKp.onTouch(view, motionEvent);
                                    }
                                    switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                                        case 0:
                                            UrlDragImageView.this.eKr = motionEvent.getY();
                                            UrlDragImageView.this.eJQ.setOnClickListener(UrlDragImageView.this.eKq ? UrlDragImageView.this.mOnClickListener : null);
                                            UrlDragImageView.this.eJQ.setOnLongClickListener(UrlDragImageView.this.eKq ? UrlDragImageView.this.mLongClickListener : null);
                                            break;
                                        case 1:
                                        case 3:
                                            if (UrlDragImageView.this.eJQ.getScale() < measuredWidth) {
                                                UrlDragImageView.this.eJQ.setScaleAndCenter(measuredWidth, pointF);
                                            }
                                            e.mX().removeCallbacks(UrlDragImageView.this.eKw);
                                            e.mX().postDelayed(UrlDragImageView.this.eKw, 1000L);
                                            break;
                                        case 2:
                                            if (Math.abs(motionEvent.getY() - UrlDragImageView.this.eKr) > UrlDragImageView.TOUCH_SLOP) {
                                                UrlDragImageView.this.eKq = false;
                                                UrlDragImageView.this.eJQ.setOnClickListener(null);
                                                UrlDragImageView.this.eJQ.setOnLongClickListener(null);
                                            }
                                            UrlDragImageView.this.eKr = motionEvent.getY();
                                            break;
                                    }
                                    return false;
                                }
                            });
                            UrlDragImageView.this.eJO.setVisibility(4);
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
            this.eJQ.setOnImageEventListener(this.eJR);
            if (this.eJQ.isImageLoaded() && this.eHo.isLongPic) {
                this.eJR.onImageLoaded();
            } else {
                this.eJQ.setImage(ImageSource.uri(str));
            }
            return true;
        }
        return false;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.eKd = dVar;
        if (this.eJO != null) {
            this.eJO.setDragToExitListener(dVar);
        }
    }

    public void bra() {
        iW(false);
    }

    private boolean BP(String str) {
        return j.isNetWorkAvailable() || com.baidu.tbadk.core.util.c.c.AO(str);
    }

    private void setThumbBitmapToView(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap rawBitmap;
        if (!this.eJU && aVar != null && (rawBitmap = aVar.getRawBitmap()) != null) {
            this.eJT = true;
            if (aVar.isGif()) {
                this.eJO.setImageUrlData(this.eHo);
                this.eJO.setImageBitmap(rawBitmap);
                this.eKs = null;
                this.eKn = false;
            } else {
                if (this.eHo != null && this.eHo.isLongPic) {
                    this.eJO.createLargeImageDelegate();
                    this.eJO.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.13
                        @Override // com.baidu.tbadk.widget.largeImage.logic.a
                        public void onLoadFinished() {
                        }
                    });
                }
                this.eJO.setImageUrlData(this.eHo);
                this.eJO.setImageData(rawBitmap, aVar.getByteData());
            }
            bqX();
        }
    }

    private void e(String str, boolean z, boolean z2) {
        if (BQ(str)) {
            if (z2 || (!this.eJV && !this.eJU)) {
                if (!z2 || !iW(true)) {
                    this.eJV = true;
                    com.baidu.adp.lib.e.c.mR().a(str, 27, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.14
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.b
                        public void onCancelled(String str2) {
                            UrlDragImageView.this.eJV = false;
                            UrlDragImageView.this.eJO.setVisibility(0);
                            UrlDragImageView.this.mProgressBar.setVisibility(8);
                            UrlDragImageView.this.eKs = null;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            UrlDragImageView.this.eJV = false;
                            UrlDragImageView.this.eJU = true;
                            UrlDragImageView.this.b(aVar);
                        }
                    }, 0, 0, false, null, Boolean.valueOf(z), this.eJO.getImageData(), Boolean.valueOf(this.eIr));
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
        com.baidu.adp.widget.ImageView.a a2 = this.eKo.a(imageFileInfo, false);
        if (a2 != null) {
            this.eJU = true;
            this.mProgressBar.setVisibility(8);
            this.eKs = null;
            b(a2);
            return;
        }
        this.eKo.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.2
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.ImageView.a aVar, String str2, boolean z3) {
                UrlDragImageView.this.eJU = true;
                UrlDragImageView.this.mProgressBar.setVisibility(8);
                UrlDragImageView.this.eKs = null;
                UrlDragImageView.this.b(aVar);
            }
        }, false);
    }

    private boolean BQ(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null && this.eJS != null) {
            this.eJS.k(aVar.getUrl(), aVar.getByteData());
        }
        if (aVar == null || aVar.getRawBitmap() == null) {
            brb();
            return;
        }
        Bitmap rawBitmap = aVar.getRawBitmap();
        this.eJO.setLoadBigImage(true);
        if (aVar.isGif()) {
            this.eJO.setGifData(aVar.getByteData(), rawBitmap);
            this.eJO.invalidate();
            this.eJO.play();
            this.eKn = false;
            this.eKs = null;
            this.mProgressBar.setVisibility(8);
        } else {
            if (this.eHo != null && this.eHo.isLongPic) {
                this.eJO.createLargeImageDelegate();
                this.eJO.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.3
                    @Override // com.baidu.tbadk.widget.largeImage.logic.a
                    public void onLoadFinished() {
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.eKs = null;
                    }
                });
            } else {
                this.mProgressBar.setVisibility(8);
                this.eKs = null;
            }
            this.eJO.setImageUrlData(this.eHo);
            this.eJO.setImageData(rawBitmap, aVar.getByteData());
            brg();
        }
        bqX();
    }

    private void brb() {
        if (!this.eJT) {
            this.eJO.setDefaultBitmap();
        } else {
            this.eJU = false;
        }
        this.eKs = null;
        this.mProgressBar.setVisibility(8);
    }

    public void setGifMaxUseableMem(int i) {
        this.eJO.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.eJO != null) {
            this.eJO.onDestroy();
        }
        if (this.eJQ != null) {
            this.eJQ.recycle();
        }
        if (this.eJY != null) {
            this.eJY.recycle();
            this.eJY = null;
        }
        if (this.mProgressBar != null) {
            this.eKs = null;
            this.mProgressBar.setVisibility(8);
        }
        e.mX().removeCallbacks(this.eKw);
        com.baidu.tieba.view.c.dJc().setColor(-1);
    }

    public void release() {
        if (this.eJO != null) {
            this.eJO.release();
        }
        if (this.mProgressBar != null) {
            this.eKs = null;
            this.mProgressBar.setVisibility(8);
        }
        this.eKs = null;
    }

    public void brc() {
        if (this.eJO != null && this.eJO.getImageType() == 1) {
            this.eJO.stop();
        }
    }

    public void E(boolean z, boolean z2) {
        String str;
        if (this.eJO != null && (str = (String) this.eJO.getTag()) != null) {
            if (this.eJO.getImageType() == 1) {
                if (this.eJO.getGifCache() == null || !this.eJO.isLoadBigImage()) {
                    e(str, z, z2);
                }
            } else if (this.eJO.getImageType() == 2) {
                e(str, z, z2);
            } else if (brd()) {
                e(str, z, z2);
            }
        }
    }

    private boolean brd() {
        if (this.eJO.getImageBitmap() != null && this.eJO.isLoadBigImage()) {
            if (this.eHo == null || !this.eHo.isLongPic || this.eJO.hasLoadLongImage()) {
                return false;
            }
            this.eJU = false;
            this.eKl = false;
            return true;
        }
        return true;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.eHo = imageUrlData;
    }

    public ImageUrlData getmAssistUrlData() {
        return this.eHo;
    }

    public void setIsCdn(boolean z) {
        this.eIr = z;
    }

    public void bre() {
        final String nameMd5FromUrl = av.getNameMd5FromUrl(this.eHo.originalUrl);
        if (this.eHo.originalProcess >= 0) {
            com.baidu.tbadk.download.d.bsr().cancelDownLoadById(nameMd5FromUrl, 13);
            this.eHo.originalProcess = -1;
            brg();
            return;
        }
        if (this.eIk != null) {
            this.eIk.brj();
        }
        com.baidu.adp.base.e<?> I = i.I(this.mContext);
        if (I == null) {
            BR(nameMd5FromUrl);
        } else if (!j.isNetWorkAvailable() || j.isWifiNet() || com.baidu.tbadk.core.sharedPref.b.bjf().getBoolean(SharedPrefConfig.ORIGINAL_IMG_DOWN_TIP, false)) {
            BR(nameMd5FromUrl);
        } else {
            com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean(SharedPrefConfig.ORIGINAL_IMG_DOWN_TIP, true);
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(I.getPageActivity());
            aVar.nE(R.string.original_img_down_no_wifi_tip);
            aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    UrlDragImageView.this.BR(nameMd5FromUrl);
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                }
            });
            aVar.b(I);
            aVar.bia();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BR(String str) {
        if (this.eHo != null) {
            this.eHo.originalProcess = 0;
            this.eKt.setProgress(0);
            this.eKt.setVisibility(0);
            DownloadData downloadData = new DownloadData(str);
            downloadData.setStatus(1);
            downloadData.setUrl(this.eHo.originalUrl);
            downloadData.setType(13);
            downloadData.setPath(this.eKe + as.bkj().AB(str) + "/" + str);
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.6
                @Override // com.baidu.tbadk.download.c
                public boolean onPreDownload(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2 != null) {
                        if (UrlDragImageView.this.eHo != null && UrlDragImageView.this.eHo.originalProcess != -1) {
                            UrlDragImageView.this.eHo.originalProcess = downloadData2.getProcess();
                        }
                        if (UrlDragImageView.this.eHo == null || UrlDragImageView.this.eHo.originalProcess != -1) {
                            UrlDragImageView.this.eKt.setProgress(downloadData2.getProcess());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public boolean onFileDownloaded(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadSucceed(DownloadData downloadData2) {
                    UrlDragImageView.this.eKt.setVisibility(8);
                    e.mX().postDelayed(UrlDragImageView.this.eKx, 1500L);
                    UrlDragImageView.this.eKl = false;
                    UrlDragImageView.this.eKk = UrlDragImageView.this.brf();
                    UrlDragImageView.this.bra();
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str2) {
                    UrlDragImageView.this.eKt.setVisibility(8);
                    UrlDragImageView.this.eKl = false;
                    BdToast.b(UrlDragImageView.this.mContext, str2).bif().big();
                    UrlDragImageView.this.eHo.originalProcess = -1;
                    UrlDragImageView.this.brg();
                }
            });
            com.baidu.tbadk.download.d.bsr().a(downloadData, 100);
            this.eKu = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean brf() {
        if (this.eHo != null && !StringUtils.isNull(this.eHo.originalUrl, true) && this.eHo.originalSize >= 0 && !this.eHo.isBlockedPic) {
            String nameMd5FromUrl = av.getNameMd5FromUrl(this.eHo.originalUrl);
            File file = new File(this.eKe + as.bkj().AB(nameMd5FromUrl) + "/" + nameMd5FromUrl);
            if (file != null && file.exists()) {
                this.eHo.originalProcess = 100;
                return true;
            }
            if (this.eHo.originalProcess < 0) {
                brg();
            } else {
                this.eKt.setProgress(this.eHo.originalProcess);
            }
            this.eKn = true;
        } else {
            this.eKs = null;
        }
        return false;
    }

    public void brg() {
        if (this.eHo != null) {
            if (!brh() || !this.eKn) {
                this.eKs = null;
            } else if (this.eHo.originalSize > 0 && !cY(this.eHo.originalSize)) {
                this.eKs = eJM + "(" + at.getFormatSize(this.eHo.originalSize) + ")";
            } else {
                this.eKs = eJM;
            }
        }
    }

    private boolean brh() {
        return (this.eHo == null || !this.eHo.mIsShowOrigonButton || this.eHo.isBlockedPic || StringUtils.isNull(this.eHo.originalUrl)) ? false : true;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.eIk = bVar;
    }

    private boolean cY(long j) {
        return j > eJN;
    }
}
