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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.at;
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
/* loaded from: classes8.dex */
public class UrlDragImageView extends RelativeLayout {
    private ImageUrlData eop;
    private b epl;
    private boolean eps;
    private boolean epu;
    protected DragImageView eqK;
    protected TextView eqL;
    protected SubsamplingScaleImageView eqM;
    private SubsamplingScaleImageView.OnImageEventListener eqN;
    private a eqO;
    private boolean eqP;
    private boolean eqQ;
    private boolean eqR;
    private boolean eqS;
    private boolean eqT;
    private Bitmap eqU;
    private RectF eqV;
    private Rect eqW;
    private Rect eqX;
    private Rect eqY;
    private DragImageView.d eqZ;
    private String era;
    private float erb;
    private float erc;
    private float erd;
    private float ere;
    private float erf;
    private boolean erg;
    private boolean erh;
    private boolean eri;
    public boolean erj;
    private com.baidu.tbadk.img.b erk;
    private View.OnTouchListener erl;
    private boolean erm;
    private float ern;
    private String ero;
    private CircleProgressView erp;
    private boolean erq;
    private boolean ers;
    private Runnable ert;
    private Runnable eru;
    private View.OnTouchListener erv;
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
    private static final String eqI = TbadkCoreApplication.getInst().getString(R.string.original_img_look);
    private static long eqJ = Config.RAVEN_LOG_LIMIT;
    private static final int EXIT_DISTANCE = l.getEquipmentHeight(TbadkCoreApplication.getInst()) / 5;
    private static final String TAG = UrlDragImageView.class.getSimpleName();
    private static final int TOUCH_SLOP = ViewConfiguration.get(TbadkCoreApplication.getInst()).getScaledTouchSlop();

    /* loaded from: classes8.dex */
    public interface a {
        void k(String str, byte[] bArr);
    }

    /* loaded from: classes8.dex */
    public interface b {
        void bdT();
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
        if (this.eqK != null) {
            this.eqK.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.eqO = aVar;
    }

    public UrlDragImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.eqK = null;
        this.eqO = null;
        this.eps = false;
        this.eqR = false;
        this.isInDragScaleMode = false;
        this.mRatio = 1.0f;
        this.mMoveDistance = 0.0f;
        this.mDragMatrix = new Matrix();
        this.mDstRect = new RectF();
        this.erb = 0.0f;
        this.erc = 0.0f;
        this.erd = 1.0f;
        this.ere = 1.0f;
        this.erf = 0.0f;
        this.erg = false;
        this.erh = false;
        this.eri = false;
        this.erj = false;
        this.erm = true;
        this.ern = 0.0f;
        this.mOnClickListener = null;
        this.mLongClickListener = null;
        this.ero = null;
        this.ert = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.erm = true;
            }
        };
        this.eru = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.erp.setVisibility(8);
                        UrlDragImageView.this.ero = null;
                        UrlDragImageView.this.erj = false;
                    }
                });
            }
        };
        this.erv = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.erl != null) {
                    UrlDragImageView.this.erl.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.erk = new com.baidu.tbadk.img.b();
        init();
    }

    public UrlDragImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.eqK = null;
        this.eqO = null;
        this.eps = false;
        this.eqR = false;
        this.isInDragScaleMode = false;
        this.mRatio = 1.0f;
        this.mMoveDistance = 0.0f;
        this.mDragMatrix = new Matrix();
        this.mDstRect = new RectF();
        this.erb = 0.0f;
        this.erc = 0.0f;
        this.erd = 1.0f;
        this.ere = 1.0f;
        this.erf = 0.0f;
        this.erg = false;
        this.erh = false;
        this.eri = false;
        this.erj = false;
        this.erm = true;
        this.ern = 0.0f;
        this.mOnClickListener = null;
        this.mLongClickListener = null;
        this.ero = null;
        this.ert = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.erm = true;
            }
        };
        this.eru = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.erp.setVisibility(8);
                        UrlDragImageView.this.ero = null;
                        UrlDragImageView.this.erj = false;
                    }
                });
            }
        };
        this.erv = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.erl != null) {
                    UrlDragImageView.this.erl.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.erk = new com.baidu.tbadk.img.b();
        init();
    }

    public DragImageView getImageView() {
        return this.eqK;
    }

    public void setGifSetListener(DragImageView.e eVar) {
        this.eqK.setGifSetListener(eVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.eqK.setImageOnClickListener(onClickListener);
        this.eqM.setOnClickListener(onClickListener);
        this.mOnClickListener = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mLongClickListener = onLongClickListener;
        if (!this.epu) {
            this.eqK.setImageOnLongClickListener(this.mLongClickListener);
            this.eqM.setOnLongClickListener(this.mLongClickListener);
        }
    }

    public void setOnSizeChangedListener(final DragImageView.g gVar) {
        this.eqK.setOnSizeChangedListener(new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.8
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (gVar != null) {
                    gVar.a(dragImageView, z, z2);
                }
                UrlDragImageView.this.bdH();
            }
        });
    }

    protected void init() {
        this.era = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        this.mMaxWidth = l.getEquipmentWidth(this.mContext);
        this.mMaxHeight = l.getEquipmentHeight(this.mContext) - ((int) this.mContext.getResources().getDimension(R.dimen.ds166));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.eqK = new DragImageView(this.mContext);
        this.eqK.setLayoutParams(layoutParams);
        this.eqK.setOnTouchListener(this.erv);
        addView(this.eqK);
        this.eqM = new SubsamplingScaleImageView(this.mContext);
        this.eqM.setMaxScale(50.0f);
        this.eqM.setOnTouchListener(this.erv);
        this.eqM.setVisibility(4);
        addView(this.eqM, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(getResources().getDrawable(R.drawable.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        bdG();
        this.ers = TbSingleton.getInstance().isCutoutScreen(TbadkApplication.getInst().getCurrentActivity());
    }

    private void bdG() {
        this.erp = new CircleProgressView(this.mContext);
        this.erp.setCircleBackgroundColor(an.getColor(R.color.cp_cont_d));
        this.erp.setCircleForegroundColor(an.getColor(R.color.cp_link_tip_a));
        this.erp.setProgress(0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds80), l.getDimens(getContext(), R.dimen.tbds80));
        layoutParams.addRule(13);
        this.erp.setVisibility(8);
        addView(this.erp, layoutParams);
    }

    public void setIsCanDrag(boolean z) {
        this.epu = z;
    }

    public String getmCheckOriginPicText() {
        return this.ero;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        Bitmap imageBitmap;
        int height;
        int width;
        if (this.erg && !this.erq && this.eqM.getVisibility() == 0 && !this.eqM.isImageLoaded()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.epu || !this.eqQ) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.eqS && motionEvent.getPointerCount() >= 2) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.eqS || this.eqT) {
            requestDisallowInterceptTouchEvent(true);
        }
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        float x = motionEvent.getX();
        int i = action & 255;
        if (i == 0) {
            if (this.eqU == null) {
                if (this.eqM.getVisibility() == 0) {
                    this.eqU = g.bl(this.eqM);
                } else {
                    this.eqU = g.bl(this.eqK);
                }
            }
            if (this.mDisplayRect == null && this.eqU != null) {
                int measuredWidth = getMeasuredWidth();
                float measuredWidth2 = ((getMeasuredWidth() * 1.0f) / this.eqU.getWidth()) * this.eqU.getHeight();
                if (measuredWidth2 > getMeasuredHeight()) {
                    measuredWidth2 = getMeasuredHeight();
                }
                RectF rectInScreenFromPosition = getRectInScreenFromPosition(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
                this.mDisplayRect = new Rect((int) rectInScreenFromPosition.left, (int) rectInScreenFromPosition.top, (int) rectInScreenFromPosition.right, (int) rectInScreenFromPosition.bottom);
            }
            if (this.eqX == null && this.eqU != null) {
                if (this.eqM.getVisibility() == 0) {
                    height = this.eqM.getSHeight();
                    width = this.eqM.getSWidth();
                } else {
                    if (this.eqK.getImageType() == 1) {
                        imageBitmap = (this.eqK.getCurrentFrame() == null || this.eqK.getCurrentFrame().bm == null) ? this.eqU : this.eqK.getCurrentFrame().bm;
                    } else {
                        imageBitmap = this.eqK.getImageBitmap() == null ? this.eqU : this.eqK.getImageBitmap();
                    }
                    height = imageBitmap.getHeight();
                    width = imageBitmap.getWidth();
                }
                float equipmentDensity = l.getEquipmentDensity(getContext());
                int i2 = (int) (height * equipmentDensity);
                int i3 = (int) (width * equipmentDensity);
                if (i3 > this.eqU.getWidth() && this.eqU.getWidth() != 0) {
                    float width2 = (i3 * 1.0f) / this.eqU.getWidth();
                    i3 = this.eqU.getWidth();
                    i2 = (int) (i2 / width2);
                }
                if (i2 > this.eqU.getHeight() && this.eqU.getHeight() != 0) {
                    i3 = (int) (i3 / ((i2 * 1.0f) / this.eqU.getHeight()));
                    i2 = this.eqU.getHeight();
                }
                int equipmentHeight = (l.getEquipmentHeight(getContext()) - i2) / 2;
                int equipmentWidth = (l.getEquipmentWidth(getContext()) - i3) / 2;
                this.eqX = new Rect(equipmentWidth, equipmentHeight, i3 + equipmentWidth, i2 + equipmentHeight);
                this.eqY = new Rect(this.eqX);
                this.erf = equipmentHeight / l.getEquipmentHeight(getContext());
                this.eqW = new Rect(0, 0, this.eqU.getWidth(), this.eqU.getHeight());
            }
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (i == 2) {
            this.eqS = r(this.mLastMotionX - x, this.mLastMotionY - y);
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (this.eqS || this.eqT) {
            this.eqK.setImageOnLongClickListener(null);
            this.eqM.setOnLongClickListener(null);
            z = true;
        } else {
            this.eqK.setImageOnLongClickListener(this.mLongClickListener);
            this.eqM.setOnLongClickListener(this.mLongClickListener);
            z = super.dispatchTouchEvent(motionEvent);
        }
        if (i == 1 || i == 3) {
            this.mLastMotionX = 0.0f;
            this.mLastMotionY = 0.0f;
            boolean z2 = (-this.mMoveDistance) > ((float) EXIT_DISTANCE);
            boolean z3 = this.mMoveDistance > ((float) EXIT_DISTANCE);
            if (z2 || z3) {
                this.eqT = true;
                startExitAnimation();
                if (z2) {
                    TiebaStatic.log(new ao("c13377").dk("obj_type", "3"));
                } else if (z3) {
                    TiebaStatic.log(new ao("c13377").dk("obj_type", "2"));
                }
            } else {
                if (this.eqS && this.eqZ != null) {
                    this.eqZ.bjr();
                }
                this.mRatio = 1.0f;
                invalidate();
            }
            this.isInDragScaleMode = false;
            this.mDragMatrix.reset();
            this.eqS = false;
        }
        return z;
    }

    private boolean r(float f, float f2) {
        if (this.eqM.getVisibility() != 0 || this.eqM.isCanDrag()) {
            if (this.eop == null || !this.eop.isLongPic || this.eqM.getVisibility() != 0 || this.eqM.isViewTop()) {
                if (this.eop == null || !this.eop.isLongPic || this.eqM.getVisibility() == 0 || this.eqK.isAtViewTop() || this.eqK.bjp()) {
                    if (this.eqM.getVisibility() == 0 || this.eqK.pagerCantScroll()) {
                        if (this.eqU != null && getScrollY() == 0) {
                            boolean z = (this.eop == null || !this.eop.isLongPic) && ((f2 < -15.0f && !this.isInDragScaleMode) || (f2 > 15.0f && !this.isInDragScaleMode));
                            boolean z2 = this.eop != null && this.eop.isLongPic && f2 < 0.0f && !this.isInDragScaleMode;
                            if (z || (z2 && this.eqK.isViewTop())) {
                                this.eqK.setImageOnLongClickListener(null);
                                this.eqM.setOnLongClickListener(null);
                                this.isInDragScaleMode = true;
                                this.mMoveDistance = 0.0f;
                                this.mRatio = 1.0f;
                                if (this.eqZ != null) {
                                    this.eqZ.onDragStart();
                                }
                            }
                        }
                        if (!this.isInDragScaleMode || this.eqU == null) {
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
                        this.mDragMatrix.preScale(1.0f + f3, 1.0f + f3, (this.mRatio * this.eqU.getWidth()) / 2.0f, this.mRatio * (this.eqU.getHeight() / 2));
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
        if (this.eqS && this.eqU != null && !this.eqU.isRecycled() && this.isInDragScaleMode) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.mDstRect == null) {
                this.mDstRect = new RectF();
            }
            this.mDragMatrix.mapRect(this.mDstRect, new RectF(this.mDisplayRect));
            canvas.drawBitmap(this.eqU, this.eqW, this.mDstRect, (Paint) null);
        } else if (this.eqT && this.eqU != null && !this.eqU.isRecycled()) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.eop == null || this.eop.getSourceImageRectInScreen() == null) {
                canvas.drawBitmap(this.eqU, this.eqW, this.mDstRect, (Paint) null);
            } else {
                canvas.drawBitmap(this.eqU, this.eqX, this.mDstRect, (Paint) null);
            }
        } else {
            super.dispatchDraw(canvas);
        }
    }

    private void startExitAnimation() {
        if (this.eop == null) {
            if (this.eqZ != null) {
                this.eqZ.onDragEnd();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.eop.getSourceImageRectInScreen();
        final Rect dstRectInScreen = this.eop.getDstRectInScreen();
        if (sourceImageRectInScreen == null || dstRectInScreen == null) {
            if (this.eqZ != null) {
                this.eqZ.onDragEnd();
                return;
            }
            return;
        }
        a(sourceImageRectInScreen, dstRectInScreen);
        b(sourceImageRectInScreen);
        this.eqV = new RectF(this.mDstRect);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(150L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && sourceImageRectInScreen != null && dstRectInScreen != null) {
                    UrlDragImageView.this.aa(valueAnimator.getAnimatedFraction());
                    UrlDragImageView.this.a(dstRectInScreen, valueAnimator.getAnimatedFraction(), UrlDragImageView.this.ers);
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
                if (UrlDragImageView.this.eqZ != null) {
                    UrlDragImageView.this.eqZ.onDragEnd();
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
            this.mDstRect.top += this.mDstRect.height() * this.erf;
            this.mDstRect.bottom = f + this.mDstRect.top;
        }
    }

    public void setCanScale(boolean z) {
        if (this.eqK != null) {
            this.eqK.setCanScale(z);
        }
    }

    private void a(Rect rect, Rect rect2) {
        this.erb = 0.0f;
        this.erc = 0.0f;
        this.erd = 1.0f;
        this.ere = 1.0f;
        if (rect != null && rect2 != null && rect.contains(rect2)) {
            this.erb = (rect2.left - rect.left) / rect.width();
            this.erc = (rect2.top - rect.top) / rect.height();
            this.erd = (rect2.right - rect.left) / rect.width();
            this.ere = (rect2.bottom - rect.top) / rect.height();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa(float f) {
        if (this.eqX != null) {
            this.eqX.left = (int) (this.eqY.left + (this.eqY.width() * this.erb * f));
            this.eqX.top = (int) (this.eqY.top + (this.eqY.height() * this.erc * f));
            this.eqX.right = (int) (this.eqY.left + (this.eqY.width() * (((1.0f - this.erd) * (1.0f - f)) + this.erd)));
            this.eqX.bottom = (int) (this.eqY.top + (this.eqY.height() * (((1.0f - this.ere) * (1.0f - f)) + this.ere)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Rect rect, float f, boolean z) {
        int i = 0;
        if (z) {
            i = l.getDimens(getContext(), R.dimen.tbds80);
        }
        if (this.mDstRect != null && rect != null) {
            this.mDstRect.left = this.eqV.left + ((rect.left - this.eqV.left) * f);
            this.mDstRect.top = (this.eqV.top + ((rect.top - this.eqV.top) * f)) - i;
            this.mDstRect.right = this.eqV.right + ((rect.right - this.eqV.right) * f);
            this.mDstRect.bottom = this.eqV.bottom + ((rect.bottom - this.eqV.bottom) * f);
        }
    }

    private RectF getRectInScreenFromPosition(float f, float f2, float f3, float f4) {
        return new RectF(f - (f3 / 2.0f), f2 - (f4 / 2.0f), (f3 / 2.0f) + f, (f4 / 2.0f) + f2);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.erl = onTouchListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdH() {
        if ((this.eqP || this.eqQ) && this.eop != null && this.eop.mPicType == 1 && !TextUtils.isEmpty(this.eop.mTagName)) {
            if (this.eqL != null) {
                this.eqL.setVisibility(8);
                this.eqL = null;
            }
            this.eqL = new TextView(this.mContext);
            this.eqL.setText(this.eop.mTagName);
            this.eqL.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize26));
            an.setViewTextColor(this.eqL, R.color.common_color_10013, 1, 0);
            an.setBackgroundColor(this.eqL, R.color.common_color_10215);
            this.eqL.setAlpha(0.75f);
            this.eqL.setIncludeFontPadding(false);
            this.eqL.setGravity(17);
            int dimens = l.getDimens(this.mContext, R.dimen.ds2);
            this.eqL.setPadding(dimens, dimens, dimens, dimens);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.eqK.getBottomOffset();
            layoutParams.leftMargin = this.eqK.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.eqL, layoutParams);
            this.eqL.setVisibility(0);
        }
    }

    public void setUrl(String str, boolean z) {
        if (str.contains("*")) {
            str = str.split("[*]")[0];
        }
        this.eqK.setTag(str);
        this.eqK.setLoadBigImage(false);
        this.eqK.setImageDrawable(null);
        this.eqP = false;
        this.eqQ = false;
        this.erg = bdP();
        this.ero = null;
        if (xW(str)) {
            e(str, z, false);
        }
    }

    private boolean bdI() {
        return this.eqK != null && this.eqK.isLoadBigImage();
    }

    public void bdJ() {
        if (this.eop != null && !bdI()) {
            String str = this.eop.imageUrl;
            int i = this.eop.urlType;
            com.baidu.adp.widget.ImageView.a aVar = null;
            if (com.baidu.tbadk.core.util.c.a.ai(str, i)) {
                aVar = com.baidu.tbadk.core.util.c.a.aj(str, i);
            }
            if (aVar != null) {
                setThumbBitmapToView(aVar);
            }
        }
    }

    private boolean hV(boolean z) {
        String nameMd5FromUrl;
        if (!this.erh || z) {
            this.erh = true;
            if (!this.erg || this.eop == null || StringUtils.isNull(this.eop.originalUrl, true) || this.eop.originalSize < 0 || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String str = this.era + aq.aWO().wI(nameMd5FromUrl) + "/" + at.getNameMd5FromUrl(this.eop.originalUrl);
            final int[] imageFileWH = n.getImageFileWH(str);
            this.eqM.setVisibility(0);
            if (this.eqN == null) {
                this.eqN = new SubsamplingScaleImageView.OnImageEventListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12
                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onReady() {
                        UrlDragImageView.this.ero = null;
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.eqK.restoreSize();
                        UrlDragImageView.this.eqK.setVisibility(4);
                    }

                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onImageLoaded() {
                        if (UrlDragImageView.this.eop.isLongPic && imageFileWH[0] > 0) {
                            UrlDragImageView.this.eqK.onDestroy();
                            final float measuredWidth = (UrlDragImageView.this.getMeasuredWidth() * 1.0f) / imageFileWH[0];
                            final PointF pointF = new PointF((imageFileWH[0] * 1.0f) / 2.0f, 0.0f);
                            UrlDragImageView.this.eqM.setScaleAndCenter(measuredWidth, pointF);
                            UrlDragImageView.this.eqM.setMaxScale(2.0f * measuredWidth);
                            UrlDragImageView.this.eqM.setDoubleTapZoomScale(2.0f * measuredWidth);
                            UrlDragImageView.this.eqM.setInitScale(measuredWidth);
                            UrlDragImageView.this.eqM.setDoubleTapZoomStyle(4);
                            UrlDragImageView.this.eqM.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12.1
                                @Override // android.view.View.OnTouchListener
                                public boolean onTouch(View view, MotionEvent motionEvent) {
                                    if (UrlDragImageView.this.erl != null) {
                                        UrlDragImageView.this.erl.onTouch(view, motionEvent);
                                    }
                                    switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                                        case 0:
                                            UrlDragImageView.this.ern = motionEvent.getY();
                                            UrlDragImageView.this.eqM.setOnClickListener(UrlDragImageView.this.erm ? UrlDragImageView.this.mOnClickListener : null);
                                            UrlDragImageView.this.eqM.setOnLongClickListener(UrlDragImageView.this.erm ? UrlDragImageView.this.mLongClickListener : null);
                                            break;
                                        case 1:
                                        case 3:
                                            if (UrlDragImageView.this.eqM.getScale() < measuredWidth) {
                                                UrlDragImageView.this.eqM.setScaleAndCenter(measuredWidth, pointF);
                                            }
                                            e.lt().removeCallbacks(UrlDragImageView.this.ert);
                                            e.lt().postDelayed(UrlDragImageView.this.ert, 1000L);
                                            break;
                                        case 2:
                                            if (Math.abs(motionEvent.getY() - UrlDragImageView.this.ern) > UrlDragImageView.TOUCH_SLOP) {
                                                UrlDragImageView.this.erm = false;
                                                UrlDragImageView.this.eqM.setOnClickListener(null);
                                                UrlDragImageView.this.eqM.setOnLongClickListener(null);
                                            }
                                            UrlDragImageView.this.ern = motionEvent.getY();
                                            break;
                                    }
                                    return false;
                                }
                            });
                            UrlDragImageView.this.eqK.setVisibility(4);
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
            this.eqM.setOnImageEventListener(this.eqN);
            if (this.eqM.isImageLoaded() && this.eop.isLongPic) {
                this.eqN.onImageLoaded();
            } else {
                this.eqM.setImage(ImageSource.uri(str));
            }
            return true;
        }
        return false;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.eqZ = dVar;
        if (this.eqK != null) {
            this.eqK.setDragToExitListener(dVar);
        }
    }

    public void bdK() {
        hV(false);
    }

    private boolean xW(String str) {
        return j.isNetWorkAvailable() || com.baidu.tbadk.core.util.c.c.wV(str);
    }

    private void setThumbBitmapToView(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap rawBitmap;
        if (!this.eqQ && aVar != null && (rawBitmap = aVar.getRawBitmap()) != null) {
            this.eqP = true;
            if (aVar.isGif()) {
                this.eqK.setImageUrlData(this.eop);
                this.eqK.setImageBitmap(rawBitmap);
                this.ero = null;
                this.erj = false;
            } else {
                if (this.eop != null && this.eop.isLongPic) {
                    this.eqK.createLargeImageDelegate();
                    this.eqK.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.13
                        @Override // com.baidu.tbadk.widget.largeImage.logic.a
                        public void onLoadFinished() {
                        }
                    });
                }
                this.eqK.setImageUrlData(this.eop);
                this.eqK.setImageData(rawBitmap, aVar.getByteData());
            }
            bdH();
        }
    }

    private void e(String str, boolean z, boolean z2) {
        if (xX(str)) {
            if (z2 || (!this.eqR && !this.eqQ)) {
                if (!z2 || !hV(true)) {
                    this.eqR = true;
                    com.baidu.adp.lib.e.c.ln().a(str, 27, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.14
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.b
                        public void onCancelled(String str2) {
                            UrlDragImageView.this.eqR = false;
                            UrlDragImageView.this.eqK.setVisibility(0);
                            UrlDragImageView.this.mProgressBar.setVisibility(8);
                            UrlDragImageView.this.ero = null;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            UrlDragImageView.this.eqR = false;
                            UrlDragImageView.this.eqQ = true;
                            UrlDragImageView.this.b(aVar);
                        }
                    }, 0, 0, false, null, Boolean.valueOf(z), this.eqK.getImageData(), Boolean.valueOf(this.eps));
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
        imageFileInfo.addPageAction(d.aW(this.mMaxWidth, this.mMaxHeight));
        com.baidu.adp.widget.ImageView.a a2 = this.erk.a(imageFileInfo, false);
        if (a2 != null) {
            this.eqQ = true;
            this.mProgressBar.setVisibility(8);
            this.ero = null;
            b(a2);
            return;
        }
        this.erk.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.2
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.ImageView.a aVar, String str2, boolean z3) {
                UrlDragImageView.this.eqQ = true;
                UrlDragImageView.this.mProgressBar.setVisibility(8);
                UrlDragImageView.this.ero = null;
                UrlDragImageView.this.b(aVar);
            }
        }, false);
    }

    private boolean xX(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null && this.eqO != null) {
            this.eqO.k(aVar.getUrl(), aVar.getByteData());
        }
        if (aVar == null || aVar.getRawBitmap() == null) {
            bdL();
            return;
        }
        Bitmap rawBitmap = aVar.getRawBitmap();
        this.eqK.setLoadBigImage(true);
        if (aVar.isGif()) {
            this.eqK.setGifData(aVar.getByteData(), rawBitmap);
            this.eqK.invalidate();
            this.eqK.play();
            this.erj = false;
            this.ero = null;
            this.mProgressBar.setVisibility(8);
        } else {
            if (this.eop != null && this.eop.isLongPic) {
                this.eqK.createLargeImageDelegate();
                this.eqK.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.3
                    @Override // com.baidu.tbadk.widget.largeImage.logic.a
                    public void onLoadFinished() {
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.ero = null;
                    }
                });
            } else {
                this.mProgressBar.setVisibility(8);
                this.ero = null;
            }
            this.eqK.setImageUrlData(this.eop);
            this.eqK.setImageData(rawBitmap, aVar.getByteData());
            bdQ();
        }
        bdH();
    }

    private void bdL() {
        if (!this.eqP) {
            this.eqK.setDefaultBitmap();
        } else {
            this.eqQ = false;
        }
        this.ero = null;
        this.mProgressBar.setVisibility(8);
    }

    public void setGifMaxUseableMem(int i) {
        this.eqK.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.eqK != null) {
            this.eqK.onDestroy();
        }
        if (this.eqM != null) {
            this.eqM.recycle();
        }
        if (this.eqU != null) {
            this.eqU.recycle();
            this.eqU = null;
        }
        if (this.mProgressBar != null) {
            this.ero = null;
            this.mProgressBar.setVisibility(8);
        }
        e.lt().removeCallbacks(this.ert);
        com.baidu.tieba.view.c.dqu().setColor(-1);
    }

    public void release() {
        if (this.eqK != null) {
            this.eqK.release();
        }
        if (this.mProgressBar != null) {
            this.ero = null;
            this.mProgressBar.setVisibility(8);
        }
        this.ero = null;
    }

    public void bdM() {
        if (this.eqK != null && this.eqK.getImageType() == 1) {
            this.eqK.stop();
        }
    }

    public void A(boolean z, boolean z2) {
        String str;
        if (this.eqK != null && (str = (String) this.eqK.getTag()) != null) {
            if (this.eqK.getImageType() == 1) {
                if (this.eqK.getGifCache() == null || !this.eqK.isLoadBigImage()) {
                    e(str, z, z2);
                }
            } else if (this.eqK.getImageType() == 2) {
                e(str, z, z2);
            } else if (bdN()) {
                e(str, z, z2);
            }
        }
    }

    private boolean bdN() {
        if (this.eqK.getImageBitmap() != null && this.eqK.isLoadBigImage()) {
            if (this.eop == null || !this.eop.isLongPic || this.eqK.hasLoadLongImage()) {
                return false;
            }
            this.eqQ = false;
            this.erh = false;
            return true;
        }
        return true;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.eop = imageUrlData;
    }

    public ImageUrlData getmAssistUrlData() {
        return this.eop;
    }

    public void setIsCdn(boolean z) {
        this.eps = z;
    }

    public void bdO() {
        final String nameMd5FromUrl = at.getNameMd5FromUrl(this.eop.originalUrl);
        if (this.eop.originalProcess >= 0) {
            com.baidu.tbadk.download.d.beW().cancelDownLoadById(nameMd5FromUrl, 13);
            this.eop.originalProcess = -1;
            bdQ();
            return;
        }
        if (this.epl != null) {
            this.epl.bdT();
        }
        com.baidu.adp.base.e<?> G = i.G(this.mContext);
        if (G == null) {
            xY(nameMd5FromUrl);
        } else if (!j.isNetWorkAvailable() || j.isWifiNet() || com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean(SharedPrefConfig.ORIGINAL_IMG_DOWN_TIP, false)) {
            xY(nameMd5FromUrl);
        } else {
            com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean(SharedPrefConfig.ORIGINAL_IMG_DOWN_TIP, true);
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(G.getPageActivity());
            aVar.kT(R.string.original_img_down_no_wifi_tip);
            aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    UrlDragImageView.this.xY(nameMd5FromUrl);
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                }
            });
            aVar.b(G);
            aVar.aUN();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xY(String str) {
        if (this.eop != null) {
            this.eop.originalProcess = 0;
            this.erp.setProgress(0);
            this.erp.setVisibility(0);
            DownloadData downloadData = new DownloadData(str);
            downloadData.setStatus(1);
            downloadData.setUrl(this.eop.originalUrl);
            downloadData.setType(13);
            downloadData.setPath(this.era + aq.aWO().wI(str) + "/" + str);
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.6
                @Override // com.baidu.tbadk.download.c
                public boolean onPreDownload(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2 != null) {
                        if (UrlDragImageView.this.eop != null && UrlDragImageView.this.eop.originalProcess != -1) {
                            UrlDragImageView.this.eop.originalProcess = downloadData2.getProcess();
                        }
                        if (UrlDragImageView.this.eop == null || UrlDragImageView.this.eop.originalProcess != -1) {
                            UrlDragImageView.this.erp.setProgress(downloadData2.getProcess());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public boolean onFileDownloaded(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadSucceed(DownloadData downloadData2) {
                    UrlDragImageView.this.erp.setVisibility(8);
                    e.lt().postDelayed(UrlDragImageView.this.eru, 1500L);
                    UrlDragImageView.this.erh = false;
                    UrlDragImageView.this.erg = UrlDragImageView.this.bdP();
                    UrlDragImageView.this.bdK();
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str2) {
                    UrlDragImageView.this.erp.setVisibility(8);
                    UrlDragImageView.this.erh = false;
                    BdToast.b(UrlDragImageView.this.mContext, str2).aUR().aUS();
                    UrlDragImageView.this.eop.originalProcess = -1;
                    UrlDragImageView.this.bdQ();
                }
            });
            com.baidu.tbadk.download.d.beW().a(downloadData, 100);
            this.erq = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bdP() {
        if (this.eop != null && !StringUtils.isNull(this.eop.originalUrl, true) && this.eop.originalSize >= 0 && !this.eop.isBlockedPic) {
            String nameMd5FromUrl = at.getNameMd5FromUrl(this.eop.originalUrl);
            File file = new File(this.era + aq.aWO().wI(nameMd5FromUrl) + "/" + nameMd5FromUrl);
            if (file != null && file.exists()) {
                this.eop.originalProcess = 100;
                return true;
            }
            if (this.eop.originalProcess < 0) {
                bdQ();
            } else {
                this.erp.setProgress(this.eop.originalProcess);
            }
            this.erj = true;
        } else {
            this.ero = null;
        }
        return false;
    }

    public void bdQ() {
        if (this.eop != null) {
            if (!bdR() || !this.erj) {
                this.ero = null;
            } else if (this.eop.originalSize > 0 && !cs(this.eop.originalSize)) {
                this.ero = eqI + "(" + ar.getFormatSize(this.eop.originalSize) + ")";
            } else {
                this.ero = eqI;
            }
        }
    }

    private boolean bdR() {
        return (this.eop == null || !this.eop.mIsShowOrigonButton || this.eop.isBlockedPic || StringUtils.isNull(this.eop.originalUrl)) ? false : true;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.epl = bVar;
    }

    private boolean cs(long j) {
        return j > eqJ;
    }
}
