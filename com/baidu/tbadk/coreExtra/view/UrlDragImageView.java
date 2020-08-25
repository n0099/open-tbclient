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
import com.baidu.tbadk.util.g;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.File;
/* loaded from: classes15.dex */
public class UrlDragImageView extends RelativeLayout {
    private b eFZ;
    private ImageUrlData eFd;
    private boolean eGg;
    private boolean eGi;
    protected DragImageView eHD;
    protected TextView eHE;
    protected SubsamplingScaleImageView eHF;
    private SubsamplingScaleImageView.OnImageEventListener eHG;
    private a eHH;
    private boolean eHI;
    private boolean eHJ;
    private boolean eHK;
    private boolean eHL;
    private boolean eHM;
    private Bitmap eHN;
    private RectF eHO;
    private Rect eHP;
    private Rect eHQ;
    private Rect eHR;
    private DragImageView.d eHS;
    private String eHT;
    private float eHU;
    private float eHV;
    private float eHW;
    private float eHX;
    private float eHY;
    private boolean eHZ;
    private boolean eIa;
    private boolean eIb;
    public boolean eIc;
    private com.baidu.tbadk.img.b eId;
    private View.OnTouchListener eIe;
    private boolean eIf;
    private float eIg;
    private String eIh;
    private CircleProgressView eIi;
    private boolean eIj;
    private boolean eIk;
    private Runnable eIl;
    private Runnable eIm;
    private View.OnTouchListener eIn;
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
    private static final String eHB = TbadkCoreApplication.getInst().getString(R.string.original_img_look);
    private static long eHC = Config.RAVEN_LOG_LIMIT;
    private static final int EXIT_DISTANCE = l.getEquipmentHeight(TbadkCoreApplication.getInst()) / 5;
    private static final String TAG = UrlDragImageView.class.getSimpleName();
    private static final int TOUCH_SLOP = ViewConfiguration.get(TbadkCoreApplication.getInst()).getScaledTouchSlop();

    /* loaded from: classes15.dex */
    public interface a {
        void k(String str, byte[] bArr);
    }

    /* loaded from: classes15.dex */
    public interface b {
        void bqo();
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
        if (this.eHD != null) {
            this.eHD.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.eHH = aVar;
    }

    public UrlDragImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.eHD = null;
        this.eHH = null;
        this.eGg = false;
        this.eHK = false;
        this.isInDragScaleMode = false;
        this.mRatio = 1.0f;
        this.mMoveDistance = 0.0f;
        this.mDragMatrix = new Matrix();
        this.mDstRect = new RectF();
        this.eHU = 0.0f;
        this.eHV = 0.0f;
        this.eHW = 1.0f;
        this.eHX = 1.0f;
        this.eHY = 0.0f;
        this.eHZ = false;
        this.eIa = false;
        this.eIb = false;
        this.eIc = false;
        this.eIf = true;
        this.eIg = 0.0f;
        this.mOnClickListener = null;
        this.mLongClickListener = null;
        this.eIh = null;
        this.eIl = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.eIf = true;
            }
        };
        this.eIm = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.eIi.setVisibility(8);
                        UrlDragImageView.this.eIh = null;
                        UrlDragImageView.this.eIc = false;
                    }
                });
            }
        };
        this.eIn = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.eIe != null) {
                    UrlDragImageView.this.eIe.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.eId = new com.baidu.tbadk.img.b();
        init();
    }

    public UrlDragImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.eHD = null;
        this.eHH = null;
        this.eGg = false;
        this.eHK = false;
        this.isInDragScaleMode = false;
        this.mRatio = 1.0f;
        this.mMoveDistance = 0.0f;
        this.mDragMatrix = new Matrix();
        this.mDstRect = new RectF();
        this.eHU = 0.0f;
        this.eHV = 0.0f;
        this.eHW = 1.0f;
        this.eHX = 1.0f;
        this.eHY = 0.0f;
        this.eHZ = false;
        this.eIa = false;
        this.eIb = false;
        this.eIc = false;
        this.eIf = true;
        this.eIg = 0.0f;
        this.mOnClickListener = null;
        this.mLongClickListener = null;
        this.eIh = null;
        this.eIl = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.eIf = true;
            }
        };
        this.eIm = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.eIi.setVisibility(8);
                        UrlDragImageView.this.eIh = null;
                        UrlDragImageView.this.eIc = false;
                    }
                });
            }
        };
        this.eIn = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.eIe != null) {
                    UrlDragImageView.this.eIe.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.eId = new com.baidu.tbadk.img.b();
        init();
    }

    public DragImageView getImageView() {
        return this.eHD;
    }

    public void setGifSetListener(DragImageView.e eVar) {
        this.eHD.setGifSetListener(eVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.eHD.setImageOnClickListener(onClickListener);
        this.eHF.setOnClickListener(onClickListener);
        this.mOnClickListener = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mLongClickListener = onLongClickListener;
        if (!this.eGi) {
            this.eHD.setImageOnLongClickListener(this.mLongClickListener);
            this.eHF.setOnLongClickListener(this.mLongClickListener);
        }
    }

    public void setOnSizeChangedListener(final DragImageView.g gVar) {
        this.eHD.setOnSizeChangedListener(new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.8
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (gVar != null) {
                    gVar.a(dragImageView, z, z2);
                }
                UrlDragImageView.this.bqc();
            }
        });
    }

    protected void init() {
        this.eHT = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        this.mMaxWidth = l.getEquipmentWidth(this.mContext);
        this.mMaxHeight = l.getEquipmentHeight(this.mContext) - ((int) this.mContext.getResources().getDimension(R.dimen.ds166));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.eHD = new DragImageView(this.mContext);
        this.eHD.setLayoutParams(layoutParams);
        this.eHD.setOnTouchListener(this.eIn);
        addView(this.eHD);
        this.eHF = new SubsamplingScaleImageView(this.mContext);
        this.eHF.setMaxScale(50.0f);
        this.eHF.setOnTouchListener(this.eIn);
        this.eHF.setVisibility(4);
        addView(this.eHF, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(getResources().getDrawable(R.drawable.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        bqb();
        this.eIk = TbSingleton.getInstance().isCutoutScreen(TbadkApplication.getInst().getCurrentActivity());
    }

    private void bqb() {
        this.eIi = new CircleProgressView(this.mContext);
        this.eIi.setCircleBackgroundColor(ap.getColor(R.color.cp_cont_d));
        this.eIi.setCircleForegroundColor(ap.getColor(R.color.cp_link_tip_a));
        this.eIi.setProgress(0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds80), l.getDimens(getContext(), R.dimen.tbds80));
        layoutParams.addRule(13);
        this.eIi.setVisibility(8);
        addView(this.eIi, layoutParams);
    }

    public void setIsCanDrag(boolean z) {
        this.eGi = z;
    }

    public String getmCheckOriginPicText() {
        return this.eIh;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        Bitmap imageBitmap;
        int height;
        int width;
        if (this.eHZ && !this.eIj && this.eHF.getVisibility() == 0 && !this.eHF.isImageLoaded()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.eGi || !this.eHJ) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.eHL && motionEvent.getPointerCount() >= 2) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.eHL || this.eHM) {
            requestDisallowInterceptTouchEvent(true);
        }
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        float x = motionEvent.getX();
        int i = action & 255;
        if (i == 0) {
            if (this.eHN == null) {
                if (this.eHF.getVisibility() == 0) {
                    this.eHN = g.bt(this.eHF);
                } else {
                    this.eHN = g.bt(this.eHD);
                }
            }
            if (this.mDisplayRect == null && this.eHN != null) {
                int measuredWidth = getMeasuredWidth();
                float measuredWidth2 = ((getMeasuredWidth() * 1.0f) / this.eHN.getWidth()) * this.eHN.getHeight();
                if (measuredWidth2 > getMeasuredHeight()) {
                    measuredWidth2 = getMeasuredHeight();
                }
                RectF rectInScreenFromPosition = getRectInScreenFromPosition(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
                this.mDisplayRect = new Rect((int) rectInScreenFromPosition.left, (int) rectInScreenFromPosition.top, (int) rectInScreenFromPosition.right, (int) rectInScreenFromPosition.bottom);
            }
            if (this.eHQ == null && this.eHN != null) {
                if (this.eHF.getVisibility() == 0) {
                    height = this.eHF.getSHeight();
                    width = this.eHF.getSWidth();
                } else {
                    if (this.eHD.getImageType() == 1) {
                        imageBitmap = (this.eHD.getCurrentFrame() == null || this.eHD.getCurrentFrame().bm == null) ? this.eHN : this.eHD.getCurrentFrame().bm;
                    } else {
                        imageBitmap = this.eHD.getImageBitmap() == null ? this.eHN : this.eHD.getImageBitmap();
                    }
                    height = imageBitmap.getHeight();
                    width = imageBitmap.getWidth();
                }
                float equipmentDensity = l.getEquipmentDensity(getContext());
                int i2 = (int) (height * equipmentDensity);
                int i3 = (int) (width * equipmentDensity);
                if (i3 > this.eHN.getWidth() && this.eHN.getWidth() != 0) {
                    float width2 = (i3 * 1.0f) / this.eHN.getWidth();
                    i3 = this.eHN.getWidth();
                    i2 = (int) (i2 / width2);
                }
                if (i2 > this.eHN.getHeight() && this.eHN.getHeight() != 0) {
                    i3 = (int) (i3 / ((i2 * 1.0f) / this.eHN.getHeight()));
                    i2 = this.eHN.getHeight();
                }
                int equipmentHeight = (l.getEquipmentHeight(getContext()) - i2) / 2;
                int equipmentWidth = (l.getEquipmentWidth(getContext()) - i3) / 2;
                this.eHQ = new Rect(equipmentWidth, equipmentHeight, i3 + equipmentWidth, i2 + equipmentHeight);
                this.eHR = new Rect(this.eHQ);
                this.eHY = equipmentHeight / l.getEquipmentHeight(getContext());
                this.eHP = new Rect(0, 0, this.eHN.getWidth(), this.eHN.getHeight());
            }
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (i == 2) {
            this.eHL = v(this.mLastMotionX - x, this.mLastMotionY - y);
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (this.eHL || this.eHM) {
            this.eHD.setImageOnLongClickListener(null);
            this.eHF.setOnLongClickListener(null);
            z = true;
        } else {
            this.eHD.setImageOnLongClickListener(this.mLongClickListener);
            this.eHF.setOnLongClickListener(this.mLongClickListener);
            z = super.dispatchTouchEvent(motionEvent);
        }
        if (i == 1 || i == 3) {
            this.mLastMotionX = 0.0f;
            this.mLastMotionY = 0.0f;
            boolean z2 = (-this.mMoveDistance) > ((float) EXIT_DISTANCE);
            boolean z3 = this.mMoveDistance > ((float) EXIT_DISTANCE);
            if (z2 || z3) {
                this.eHM = true;
                startExitAnimation();
                if (z2) {
                    TiebaStatic.log(new aq("c13377").dD("obj_type", "3"));
                } else if (z3) {
                    TiebaStatic.log(new aq("c13377").dD("obj_type", "2"));
                }
            } else {
                if (this.eHL && this.eHS != null) {
                    this.eHS.bvY();
                }
                this.mRatio = 1.0f;
                invalidate();
            }
            this.isInDragScaleMode = false;
            this.mDragMatrix.reset();
            this.eHL = false;
        }
        return z;
    }

    private boolean v(float f, float f2) {
        if (this.eHF.getVisibility() != 0 || this.eHF.isCanDrag()) {
            if (this.eFd == null || !this.eFd.isLongPic || this.eHF.getVisibility() != 0 || this.eHF.isViewTop()) {
                if (this.eFd == null || !this.eFd.isLongPic || this.eHF.getVisibility() == 0 || this.eHD.isAtViewTop() || this.eHD.bvW()) {
                    if (this.eHF.getVisibility() == 0 || this.eHD.pagerCantScroll()) {
                        if (this.eHN != null && getScrollY() == 0) {
                            boolean z = (this.eFd == null || !this.eFd.isLongPic) && ((f2 < -15.0f && !this.isInDragScaleMode) || (f2 > 15.0f && !this.isInDragScaleMode));
                            boolean z2 = this.eFd != null && this.eFd.isLongPic && f2 < 0.0f && !this.isInDragScaleMode;
                            if (z || (z2 && this.eHD.isViewTop())) {
                                this.eHD.setImageOnLongClickListener(null);
                                this.eHF.setOnLongClickListener(null);
                                this.isInDragScaleMode = true;
                                this.mMoveDistance = 0.0f;
                                this.mRatio = 1.0f;
                                if (this.eHS != null) {
                                    this.eHS.onDragStart();
                                }
                            }
                        }
                        if (!this.isInDragScaleMode || this.eHN == null) {
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
                        this.mDragMatrix.preScale(1.0f + f3, 1.0f + f3, (this.mRatio * this.eHN.getWidth()) / 2.0f, this.mRatio * (this.eHN.getHeight() / 2));
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
        if (this.eHL && this.eHN != null && !this.eHN.isRecycled() && this.isInDragScaleMode) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.mDstRect == null) {
                this.mDstRect = new RectF();
            }
            this.mDragMatrix.mapRect(this.mDstRect, new RectF(this.mDisplayRect));
            canvas.drawBitmap(this.eHN, this.eHP, this.mDstRect, (Paint) null);
        } else if (this.eHM && this.eHN != null && !this.eHN.isRecycled()) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.eFd == null || this.eFd.getSourceImageRectInScreen() == null) {
                canvas.drawBitmap(this.eHN, this.eHP, this.mDstRect, (Paint) null);
            } else {
                canvas.drawBitmap(this.eHN, this.eHQ, this.mDstRect, (Paint) null);
            }
        } else {
            super.dispatchDraw(canvas);
        }
    }

    private void startExitAnimation() {
        if (this.eFd == null) {
            if (this.eHS != null) {
                this.eHS.onDragEnd();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.eFd.getSourceImageRectInScreen();
        final Rect dstRectInScreen = this.eFd.getDstRectInScreen();
        if (sourceImageRectInScreen == null || dstRectInScreen == null) {
            if (this.eHS != null) {
                this.eHS.onDragEnd();
                return;
            }
            return;
        }
        a(sourceImageRectInScreen, dstRectInScreen);
        b(sourceImageRectInScreen);
        this.eHO = new RectF(this.mDstRect);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(150L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && sourceImageRectInScreen != null && dstRectInScreen != null) {
                    UrlDragImageView.this.af(valueAnimator.getAnimatedFraction());
                    UrlDragImageView.this.a(dstRectInScreen, valueAnimator.getAnimatedFraction(), UrlDragImageView.this.eIk);
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
                if (UrlDragImageView.this.eHS != null) {
                    UrlDragImageView.this.eHS.onDragEnd();
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
            this.mDstRect.top += this.mDstRect.height() * this.eHY;
            this.mDstRect.bottom = f + this.mDstRect.top;
        }
    }

    public void setCanScale(boolean z) {
        if (this.eHD != null) {
            this.eHD.setCanScale(z);
        }
    }

    private void a(Rect rect, Rect rect2) {
        this.eHU = 0.0f;
        this.eHV = 0.0f;
        this.eHW = 1.0f;
        this.eHX = 1.0f;
        if (rect != null && rect2 != null && rect.contains(rect2)) {
            this.eHU = (rect2.left - rect.left) / rect.width();
            this.eHV = (rect2.top - rect.top) / rect.height();
            this.eHW = (rect2.right - rect.left) / rect.width();
            this.eHX = (rect2.bottom - rect.top) / rect.height();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void af(float f) {
        if (this.eHQ != null) {
            this.eHQ.left = (int) (this.eHR.left + (this.eHR.width() * this.eHU * f));
            this.eHQ.top = (int) (this.eHR.top + (this.eHR.height() * this.eHV * f));
            this.eHQ.right = (int) (this.eHR.left + (this.eHR.width() * (((1.0f - this.eHW) * (1.0f - f)) + this.eHW)));
            this.eHQ.bottom = (int) (this.eHR.top + (this.eHR.height() * (((1.0f - this.eHX) * (1.0f - f)) + this.eHX)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Rect rect, float f, boolean z) {
        int i = 0;
        if (z) {
            i = l.getDimens(getContext(), R.dimen.tbds80);
        }
        if (this.mDstRect != null && rect != null) {
            this.mDstRect.left = this.eHO.left + ((rect.left - this.eHO.left) * f);
            this.mDstRect.top = (this.eHO.top + ((rect.top - this.eHO.top) * f)) - i;
            this.mDstRect.right = this.eHO.right + ((rect.right - this.eHO.right) * f);
            this.mDstRect.bottom = this.eHO.bottom + ((rect.bottom - this.eHO.bottom) * f);
        }
    }

    private RectF getRectInScreenFromPosition(float f, float f2, float f3, float f4) {
        return new RectF(f - (f3 / 2.0f), f2 - (f4 / 2.0f), (f3 / 2.0f) + f, (f4 / 2.0f) + f2);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.eIe = onTouchListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqc() {
        if ((this.eHI || this.eHJ) && this.eFd != null && this.eFd.mPicType == 1 && !TextUtils.isEmpty(this.eFd.mTagName)) {
            if (this.eHE != null) {
                this.eHE.setVisibility(8);
                this.eHE = null;
            }
            this.eHE = new TextView(this.mContext);
            this.eHE.setText(this.eFd.mTagName);
            this.eHE.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize26));
            ap.setViewTextColor(this.eHE, R.color.common_color_10013, 1, 0);
            ap.setBackgroundColor(this.eHE, R.color.common_color_10215);
            this.eHE.setAlpha(0.75f);
            this.eHE.setIncludeFontPadding(false);
            this.eHE.setGravity(17);
            int dimens = l.getDimens(this.mContext, R.dimen.ds2);
            this.eHE.setPadding(dimens, dimens, dimens, dimens);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.eHD.getBottomOffset();
            layoutParams.leftMargin = this.eHD.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.eHE, layoutParams);
            this.eHE.setVisibility(0);
        }
    }

    public void setUrl(String str, boolean z) {
        if (str.contains("*")) {
            str = str.split("[*]")[0];
        }
        this.eHD.setTag(str);
        this.eHD.setLoadBigImage(false);
        this.eHD.setImageDrawable(null);
        this.eHI = false;
        this.eHJ = false;
        this.eHZ = bqk();
        this.eIh = null;
        if (Bs(str)) {
            e(str, z, false);
        }
    }

    private boolean bqd() {
        return this.eHD != null && this.eHD.isLoadBigImage();
    }

    public void bqe() {
        if (this.eFd != null && !bqd()) {
            String str = this.eFd.imageUrl;
            int i = this.eFd.urlType;
            com.baidu.adp.widget.ImageView.a aVar = null;
            if (com.baidu.tbadk.core.util.c.a.ak(str, i)) {
                aVar = com.baidu.tbadk.core.util.c.a.al(str, i);
            }
            if (aVar != null) {
                setThumbBitmapToView(aVar);
            }
        }
    }

    private boolean iX(boolean z) {
        String nameMd5FromUrl;
        if (!this.eIa || z) {
            this.eIa = true;
            if (!this.eHZ || this.eFd == null || StringUtils.isNull(this.eFd.originalUrl, true) || this.eFd.originalSize < 0 || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String str = this.eHT + as.bjo().Ae(nameMd5FromUrl) + "/" + av.getNameMd5FromUrl(this.eFd.originalUrl);
            final int[] imageFileWH = n.getImageFileWH(str);
            this.eHF.setVisibility(0);
            if (this.eHG == null) {
                this.eHG = new SubsamplingScaleImageView.OnImageEventListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12
                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onReady() {
                        UrlDragImageView.this.eIh = null;
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.eHD.restoreSize();
                        UrlDragImageView.this.eHD.setVisibility(4);
                    }

                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onImageLoaded() {
                        if (UrlDragImageView.this.eFd.isLongPic && imageFileWH[0] > 0) {
                            UrlDragImageView.this.eHD.onDestroy();
                            final float measuredWidth = (UrlDragImageView.this.getMeasuredWidth() * 1.0f) / imageFileWH[0];
                            final PointF pointF = new PointF((imageFileWH[0] * 1.0f) / 2.0f, 0.0f);
                            UrlDragImageView.this.eHF.setScaleAndCenter(measuredWidth, pointF);
                            UrlDragImageView.this.eHF.setMaxScale(2.0f * measuredWidth);
                            UrlDragImageView.this.eHF.setDoubleTapZoomScale(2.0f * measuredWidth);
                            UrlDragImageView.this.eHF.setInitScale(measuredWidth);
                            UrlDragImageView.this.eHF.setDoubleTapZoomStyle(4);
                            UrlDragImageView.this.eHF.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12.1
                                @Override // android.view.View.OnTouchListener
                                public boolean onTouch(View view, MotionEvent motionEvent) {
                                    if (UrlDragImageView.this.eIe != null) {
                                        UrlDragImageView.this.eIe.onTouch(view, motionEvent);
                                    }
                                    switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                                        case 0:
                                            UrlDragImageView.this.eIg = motionEvent.getY();
                                            UrlDragImageView.this.eHF.setOnClickListener(UrlDragImageView.this.eIf ? UrlDragImageView.this.mOnClickListener : null);
                                            UrlDragImageView.this.eHF.setOnLongClickListener(UrlDragImageView.this.eIf ? UrlDragImageView.this.mLongClickListener : null);
                                            break;
                                        case 1:
                                        case 3:
                                            if (UrlDragImageView.this.eHF.getScale() < measuredWidth) {
                                                UrlDragImageView.this.eHF.setScaleAndCenter(measuredWidth, pointF);
                                            }
                                            e.mS().removeCallbacks(UrlDragImageView.this.eIl);
                                            e.mS().postDelayed(UrlDragImageView.this.eIl, 1000L);
                                            break;
                                        case 2:
                                            if (Math.abs(motionEvent.getY() - UrlDragImageView.this.eIg) > UrlDragImageView.TOUCH_SLOP) {
                                                UrlDragImageView.this.eIf = false;
                                                UrlDragImageView.this.eHF.setOnClickListener(null);
                                                UrlDragImageView.this.eHF.setOnLongClickListener(null);
                                            }
                                            UrlDragImageView.this.eIg = motionEvent.getY();
                                            break;
                                    }
                                    return false;
                                }
                            });
                            UrlDragImageView.this.eHD.setVisibility(4);
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
            this.eHF.setOnImageEventListener(this.eHG);
            if (this.eHF.isImageLoaded() && this.eFd.isLongPic) {
                this.eHG.onImageLoaded();
            } else {
                this.eHF.setImage(ImageSource.uri(str));
            }
            return true;
        }
        return false;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.eHS = dVar;
        if (this.eHD != null) {
            this.eHD.setDragToExitListener(dVar);
        }
    }

    public void bqf() {
        iX(false);
    }

    private boolean Bs(String str) {
        return j.isNetWorkAvailable() || com.baidu.tbadk.core.util.c.c.Ar(str);
    }

    private void setThumbBitmapToView(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap rawBitmap;
        if (!this.eHJ && aVar != null && (rawBitmap = aVar.getRawBitmap()) != null) {
            this.eHI = true;
            if (aVar.isGif()) {
                this.eHD.setImageUrlData(this.eFd);
                this.eHD.setImageBitmap(rawBitmap);
                this.eIh = null;
                this.eIc = false;
            } else {
                if (this.eFd != null && this.eFd.isLongPic) {
                    this.eHD.createLargeImageDelegate();
                    this.eHD.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.13
                        @Override // com.baidu.tbadk.widget.largeImage.logic.a
                        public void onLoadFinished() {
                        }
                    });
                }
                this.eHD.setImageUrlData(this.eFd);
                this.eHD.setImageData(rawBitmap, aVar.getByteData());
            }
            bqc();
        }
    }

    private void e(String str, boolean z, boolean z2) {
        if (Bt(str)) {
            if (z2 || (!this.eHK && !this.eHJ)) {
                if (!z2 || !iX(true)) {
                    this.eHK = true;
                    com.baidu.adp.lib.e.c.mM().a(str, 27, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.14
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.b
                        public void onCancelled(String str2) {
                            UrlDragImageView.this.eHK = false;
                            UrlDragImageView.this.eHD.setVisibility(0);
                            UrlDragImageView.this.mProgressBar.setVisibility(8);
                            UrlDragImageView.this.eIh = null;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            UrlDragImageView.this.eHK = false;
                            UrlDragImageView.this.eHJ = true;
                            UrlDragImageView.this.b(aVar);
                        }
                    }, 0, 0, false, null, Boolean.valueOf(z), this.eHD.getImageData(), Boolean.valueOf(this.eGg));
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
        com.baidu.adp.widget.ImageView.a a2 = this.eId.a(imageFileInfo, false);
        if (a2 != null) {
            this.eHJ = true;
            this.mProgressBar.setVisibility(8);
            this.eIh = null;
            b(a2);
            return;
        }
        this.eId.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.2
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.ImageView.a aVar, String str2, boolean z3) {
                UrlDragImageView.this.eHJ = true;
                UrlDragImageView.this.mProgressBar.setVisibility(8);
                UrlDragImageView.this.eIh = null;
                UrlDragImageView.this.b(aVar);
            }
        }, false);
    }

    private boolean Bt(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null && this.eHH != null) {
            this.eHH.k(aVar.getUrl(), aVar.getByteData());
        }
        if (aVar == null || aVar.getRawBitmap() == null) {
            bqg();
            return;
        }
        Bitmap rawBitmap = aVar.getRawBitmap();
        this.eHD.setLoadBigImage(true);
        if (aVar.isGif()) {
            this.eHD.setGifData(aVar.getByteData(), rawBitmap);
            this.eHD.invalidate();
            this.eHD.play();
            this.eIc = false;
            this.eIh = null;
            this.mProgressBar.setVisibility(8);
        } else {
            if (this.eFd != null && this.eFd.isLongPic) {
                this.eHD.createLargeImageDelegate();
                this.eHD.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.3
                    @Override // com.baidu.tbadk.widget.largeImage.logic.a
                    public void onLoadFinished() {
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.eIh = null;
                    }
                });
            } else {
                this.mProgressBar.setVisibility(8);
                this.eIh = null;
            }
            this.eHD.setImageUrlData(this.eFd);
            this.eHD.setImageData(rawBitmap, aVar.getByteData());
            bql();
        }
        bqc();
    }

    private void bqg() {
        if (!this.eHI) {
            this.eHD.setDefaultBitmap();
        } else {
            this.eHJ = false;
        }
        this.eIh = null;
        this.mProgressBar.setVisibility(8);
    }

    public void setGifMaxUseableMem(int i) {
        this.eHD.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.eHD != null) {
            this.eHD.onDestroy();
        }
        if (this.eHF != null) {
            this.eHF.recycle();
        }
        if (this.eHN != null) {
            this.eHN.recycle();
            this.eHN = null;
        }
        if (this.mProgressBar != null) {
            this.eIh = null;
            this.mProgressBar.setVisibility(8);
        }
        e.mS().removeCallbacks(this.eIl);
        com.baidu.tieba.view.c.dEZ().setColor(-1);
    }

    public void release() {
        if (this.eHD != null) {
            this.eHD.release();
        }
        if (this.mProgressBar != null) {
            this.eIh = null;
            this.mProgressBar.setVisibility(8);
        }
        this.eIh = null;
    }

    public void bqh() {
        if (this.eHD != null && this.eHD.getImageType() == 1) {
            this.eHD.stop();
        }
    }

    public void E(boolean z, boolean z2) {
        String str;
        if (this.eHD != null && (str = (String) this.eHD.getTag()) != null) {
            if (this.eHD.getImageType() == 1) {
                if (this.eHD.getGifCache() == null || !this.eHD.isLoadBigImage()) {
                    e(str, z, z2);
                }
            } else if (this.eHD.getImageType() == 2) {
                e(str, z, z2);
            } else if (bqi()) {
                e(str, z, z2);
            }
        }
    }

    private boolean bqi() {
        if (this.eHD.getImageBitmap() != null && this.eHD.isLoadBigImage()) {
            if (this.eFd == null || !this.eFd.isLongPic || this.eHD.hasLoadLongImage()) {
                return false;
            }
            this.eHJ = false;
            this.eIa = false;
            return true;
        }
        return true;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.eFd = imageUrlData;
    }

    public ImageUrlData getmAssistUrlData() {
        return this.eFd;
    }

    public void setIsCdn(boolean z) {
        this.eGg = z;
    }

    public void bqj() {
        final String nameMd5FromUrl = av.getNameMd5FromUrl(this.eFd.originalUrl);
        if (this.eFd.originalProcess >= 0) {
            com.baidu.tbadk.download.d.brr().cancelDownLoadById(nameMd5FromUrl, 13);
            this.eFd.originalProcess = -1;
            bql();
            return;
        }
        if (this.eFZ != null) {
            this.eFZ.bqo();
        }
        com.baidu.adp.base.e<?> I = i.I(this.mContext);
        if (I == null) {
            Bu(nameMd5FromUrl);
        } else if (!j.isNetWorkAvailable() || j.isWifiNet() || com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(SharedPrefConfig.ORIGINAL_IMG_DOWN_TIP, false)) {
            Bu(nameMd5FromUrl);
        } else {
            com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.ORIGINAL_IMG_DOWN_TIP, true);
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(I.getPageActivity());
            aVar.nt(R.string.original_img_down_no_wifi_tip);
            aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    UrlDragImageView.this.Bu(nameMd5FromUrl);
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                }
            });
            aVar.b(I);
            aVar.bhg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bu(String str) {
        if (this.eFd != null) {
            this.eFd.originalProcess = 0;
            this.eIi.setProgress(0);
            this.eIi.setVisibility(0);
            DownloadData downloadData = new DownloadData(str);
            downloadData.setStatus(1);
            downloadData.setUrl(this.eFd.originalUrl);
            downloadData.setType(13);
            downloadData.setPath(this.eHT + as.bjo().Ae(str) + "/" + str);
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.6
                @Override // com.baidu.tbadk.download.c
                public boolean onPreDownload(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2 != null) {
                        if (UrlDragImageView.this.eFd != null && UrlDragImageView.this.eFd.originalProcess != -1) {
                            UrlDragImageView.this.eFd.originalProcess = downloadData2.getProcess();
                        }
                        if (UrlDragImageView.this.eFd == null || UrlDragImageView.this.eFd.originalProcess != -1) {
                            UrlDragImageView.this.eIi.setProgress(downloadData2.getProcess());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public boolean onFileDownloaded(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadSucceed(DownloadData downloadData2) {
                    UrlDragImageView.this.eIi.setVisibility(8);
                    e.mS().postDelayed(UrlDragImageView.this.eIm, 1500L);
                    UrlDragImageView.this.eIa = false;
                    UrlDragImageView.this.eHZ = UrlDragImageView.this.bqk();
                    UrlDragImageView.this.bqf();
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str2) {
                    UrlDragImageView.this.eIi.setVisibility(8);
                    UrlDragImageView.this.eIa = false;
                    BdToast.b(UrlDragImageView.this.mContext, str2).bhl().bhm();
                    UrlDragImageView.this.eFd.originalProcess = -1;
                    UrlDragImageView.this.bql();
                }
            });
            com.baidu.tbadk.download.d.brr().a(downloadData, 100);
            this.eIj = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bqk() {
        if (this.eFd != null && !StringUtils.isNull(this.eFd.originalUrl, true) && this.eFd.originalSize >= 0 && !this.eFd.isBlockedPic) {
            String nameMd5FromUrl = av.getNameMd5FromUrl(this.eFd.originalUrl);
            File file = new File(this.eHT + as.bjo().Ae(nameMd5FromUrl) + "/" + nameMd5FromUrl);
            if (file != null && file.exists()) {
                this.eFd.originalProcess = 100;
                return true;
            }
            if (this.eFd.originalProcess < 0) {
                bql();
            } else {
                this.eIi.setProgress(this.eFd.originalProcess);
            }
            this.eIc = true;
        } else {
            this.eIh = null;
        }
        return false;
    }

    public void bql() {
        if (this.eFd != null) {
            if (!bqm() || !this.eIc) {
                this.eIh = null;
            } else if (this.eFd.originalSize > 0 && !cX(this.eFd.originalSize)) {
                this.eIh = eHB + "(" + at.getFormatSize(this.eFd.originalSize) + ")";
            } else {
                this.eIh = eHB;
            }
        }
    }

    private boolean bqm() {
        return (this.eFd == null || !this.eFd.mIsShowOrigonButton || this.eFd.isBlockedPic || StringUtils.isNull(this.eFd.originalUrl)) ? false : true;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.eFZ = bVar;
    }

    private boolean cX(long j) {
        return j > eHC;
    }
}
