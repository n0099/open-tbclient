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
    private ImageUrlData fvI;
    private b fwC;
    private boolean fwJ;
    private boolean fwL;
    private float fyA;
    private boolean fyB;
    private boolean fyC;
    private boolean fyD;
    public boolean fyE;
    private com.baidu.tbadk.img.b fyF;
    private View.OnTouchListener fyG;
    private boolean fyH;
    private float fyI;
    private String fyJ;
    private CircleProgressView fyK;
    private boolean fyL;
    private boolean fyM;
    private Runnable fyN;
    private Runnable fyO;
    private View.OnTouchListener fyP;
    protected DragImageView fyf;
    protected TextView fyg;
    protected SubsamplingScaleImageView fyh;
    private SubsamplingScaleImageView.OnImageEventListener fyi;
    private a fyj;
    private boolean fyk;
    private boolean fyl;
    private boolean fym;
    private boolean fyn;
    private boolean fyo;
    private Bitmap fyp;
    private RectF fyq;
    private Rect fyr;
    private Rect fys;
    private Rect fyt;
    private DragImageView.d fyu;
    private String fyv;
    private float fyw;
    private float fyx;
    private float fyy;
    private float fyz;
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
    private static final String fyd = TbadkCoreApplication.getInst().getString(R.string.original_img_look);
    private static long fye = Config.RAVEN_LOG_LIMIT;
    private static final int EXIT_DISTANCE = l.getEquipmentHeight(TbadkCoreApplication.getInst()) / 5;
    private static final String TAG = UrlDragImageView.class.getSimpleName();
    private static final int TOUCH_SLOP = ViewConfiguration.get(TbadkCoreApplication.getInst()).getScaledTouchSlop();

    /* loaded from: classes.dex */
    public interface a {
        void l(String str, byte[] bArr);
    }

    /* loaded from: classes.dex */
    public interface b {
        void bzU();
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
        if (this.fyf != null) {
            this.fyf.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.fyj = aVar;
    }

    public UrlDragImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.fyf = null;
        this.fyj = null;
        this.fwJ = false;
        this.fym = false;
        this.isInDragScaleMode = false;
        this.mRatio = 1.0f;
        this.mMoveDistance = 0.0f;
        this.mDragMatrix = new Matrix();
        this.mDstRect = new RectF();
        this.fyw = 0.0f;
        this.fyx = 0.0f;
        this.fyy = 1.0f;
        this.fyz = 1.0f;
        this.fyA = 0.0f;
        this.fyB = false;
        this.fyC = false;
        this.fyD = false;
        this.fyE = false;
        this.fyH = true;
        this.fyI = 0.0f;
        this.mOnClickListener = null;
        this.mLongClickListener = null;
        this.fyJ = null;
        this.fyN = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.fyH = true;
            }
        };
        this.fyO = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.fyK.setVisibility(8);
                        UrlDragImageView.this.fyJ = null;
                        UrlDragImageView.this.fyE = false;
                    }
                });
            }
        };
        this.fyP = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.fyG != null) {
                    UrlDragImageView.this.fyG.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.fyF = new com.baidu.tbadk.img.b();
        init();
    }

    public UrlDragImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.fyf = null;
        this.fyj = null;
        this.fwJ = false;
        this.fym = false;
        this.isInDragScaleMode = false;
        this.mRatio = 1.0f;
        this.mMoveDistance = 0.0f;
        this.mDragMatrix = new Matrix();
        this.mDstRect = new RectF();
        this.fyw = 0.0f;
        this.fyx = 0.0f;
        this.fyy = 1.0f;
        this.fyz = 1.0f;
        this.fyA = 0.0f;
        this.fyB = false;
        this.fyC = false;
        this.fyD = false;
        this.fyE = false;
        this.fyH = true;
        this.fyI = 0.0f;
        this.mOnClickListener = null;
        this.mLongClickListener = null;
        this.fyJ = null;
        this.fyN = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.fyH = true;
            }
        };
        this.fyO = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.fyK.setVisibility(8);
                        UrlDragImageView.this.fyJ = null;
                        UrlDragImageView.this.fyE = false;
                    }
                });
            }
        };
        this.fyP = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.fyG != null) {
                    UrlDragImageView.this.fyG.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.fyF = new com.baidu.tbadk.img.b();
        init();
    }

    public DragImageView getImageView() {
        return this.fyf;
    }

    public void setGifSetListener(DragImageView.e eVar) {
        this.fyf.setGifSetListener(eVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.fyf.setImageOnClickListener(onClickListener);
        this.fyh.setOnClickListener(onClickListener);
        this.mOnClickListener = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mLongClickListener = onLongClickListener;
        if (!this.fwL) {
            this.fyf.setImageOnLongClickListener(this.mLongClickListener);
            this.fyh.setOnLongClickListener(this.mLongClickListener);
        }
    }

    public void setOnSizeChangedListener(final DragImageView.g gVar) {
        this.fyf.setOnSizeChangedListener(new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.8
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (gVar != null) {
                    gVar.a(dragImageView, z, z2);
                }
                UrlDragImageView.this.bzI();
            }
        });
    }

    protected void init() {
        this.fyv = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        this.mMaxWidth = l.getEquipmentWidth(this.mContext);
        this.mMaxHeight = l.getEquipmentHeight(this.mContext) - ((int) this.mContext.getResources().getDimension(R.dimen.ds166));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.fyf = new DragImageView(this.mContext);
        this.fyf.setLayoutParams(layoutParams);
        this.fyf.setOnTouchListener(this.fyP);
        addView(this.fyf);
        this.fyh = new SubsamplingScaleImageView(this.mContext);
        this.fyh.setMaxScale(50.0f);
        this.fyh.setOnTouchListener(this.fyP);
        this.fyh.setVisibility(4);
        addView(this.fyh, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(getResources().getDrawable(R.drawable.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        bzH();
        this.fyM = TbSingleton.getInstance().isCutoutScreen(TbadkApplication.getInst().getCurrentActivity());
    }

    private void bzH() {
        this.fyK = new CircleProgressView(this.mContext);
        this.fyK.setCircleBackgroundColor(ap.getColor(R.color.CAM_X0109));
        this.fyK.setCircleForegroundColor(ap.getColor(R.color.CAM_X0302));
        this.fyK.setProgress(0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds80), l.getDimens(getContext(), R.dimen.tbds80));
        layoutParams.addRule(13);
        this.fyK.setVisibility(8);
        addView(this.fyK, layoutParams);
    }

    public void setIsCanDrag(boolean z) {
        this.fwL = z;
    }

    public String getmCheckOriginPicText() {
        return this.fyJ;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        Bitmap imageBitmap;
        int height;
        int width;
        if (this.fyB && !this.fyL && this.fyh.getVisibility() == 0 && !this.fyh.isImageLoaded()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.fwL || !this.fyl) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.fyn && motionEvent.getPointerCount() >= 2) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.fyn || this.fyo) {
            requestDisallowInterceptTouchEvent(true);
        }
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        float x = motionEvent.getX();
        int i = action & 255;
        if (i == 0) {
            if (this.fyp == null) {
                if (this.fyh.getVisibility() == 0) {
                    this.fyp = h.bV(this.fyh);
                } else {
                    this.fyp = h.bV(this.fyf);
                }
            }
            if (this.mDisplayRect == null && this.fyp != null) {
                int measuredWidth = getMeasuredWidth();
                float measuredWidth2 = ((getMeasuredWidth() * 1.0f) / this.fyp.getWidth()) * this.fyp.getHeight();
                if (measuredWidth2 > getMeasuredHeight()) {
                    measuredWidth2 = getMeasuredHeight();
                }
                RectF rectInScreenFromPosition = getRectInScreenFromPosition(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
                this.mDisplayRect = new Rect((int) rectInScreenFromPosition.left, (int) rectInScreenFromPosition.top, (int) rectInScreenFromPosition.right, (int) rectInScreenFromPosition.bottom);
            }
            if (this.fys == null && this.fyp != null) {
                if (this.fyh.getVisibility() == 0) {
                    height = this.fyh.getSHeight();
                    width = this.fyh.getSWidth();
                } else {
                    if (this.fyf.getImageType() == 1) {
                        imageBitmap = (this.fyf.getCurrentFrame() == null || this.fyf.getCurrentFrame().bm == null) ? this.fyp : this.fyf.getCurrentFrame().bm;
                    } else {
                        imageBitmap = this.fyf.getImageBitmap() == null ? this.fyp : this.fyf.getImageBitmap();
                    }
                    height = imageBitmap.getHeight();
                    width = imageBitmap.getWidth();
                }
                float equipmentDensity = l.getEquipmentDensity(getContext());
                int i2 = (int) (height * equipmentDensity);
                int i3 = (int) (width * equipmentDensity);
                if (i3 > this.fyp.getWidth() && this.fyp.getWidth() != 0) {
                    float width2 = (i3 * 1.0f) / this.fyp.getWidth();
                    i3 = this.fyp.getWidth();
                    i2 = (int) (i2 / width2);
                }
                if (i2 > this.fyp.getHeight() && this.fyp.getHeight() != 0) {
                    i3 = (int) (i3 / ((i2 * 1.0f) / this.fyp.getHeight()));
                    i2 = this.fyp.getHeight();
                }
                int equipmentHeight = (l.getEquipmentHeight(getContext()) - i2) / 2;
                int equipmentWidth = (l.getEquipmentWidth(getContext()) - i3) / 2;
                this.fys = new Rect(equipmentWidth, equipmentHeight, i3 + equipmentWidth, i2 + equipmentHeight);
                this.fyt = new Rect(this.fys);
                this.fyA = equipmentHeight / l.getEquipmentHeight(getContext());
                this.fyr = new Rect(0, 0, this.fyp.getWidth(), this.fyp.getHeight());
            }
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (i == 2) {
            this.fyn = x(this.mLastMotionX - x, this.mLastMotionY - y);
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (this.fyn || this.fyo) {
            this.fyf.setImageOnLongClickListener(null);
            this.fyh.setOnLongClickListener(null);
            z = true;
        } else {
            this.fyf.setImageOnLongClickListener(this.mLongClickListener);
            this.fyh.setOnLongClickListener(this.mLongClickListener);
            z = super.dispatchTouchEvent(motionEvent);
        }
        if (i == 1 || i == 3) {
            this.mLastMotionX = 0.0f;
            this.mLastMotionY = 0.0f;
            boolean z2 = (-this.mMoveDistance) > ((float) (EXIT_DISTANCE * 2));
            boolean z3 = this.mMoveDistance > ((float) EXIT_DISTANCE);
            if (z2 || z3) {
                this.fyo = true;
                startExitAnimation();
                if (z2) {
                    TiebaStatic.log(new ar("c13377").dR("obj_type", "3"));
                } else if (z3) {
                    TiebaStatic.log(new ar("c13377").dR("obj_type", "2"));
                }
            } else {
                if (this.fyn && this.fyu != null) {
                    this.fyu.bGa();
                }
                this.mRatio = 1.0f;
                invalidate();
            }
            this.isInDragScaleMode = false;
            this.mDragMatrix.reset();
            this.fyn = false;
        }
        return z;
    }

    private boolean x(float f, float f2) {
        if (this.fyh.getVisibility() != 0 || this.fyh.isCanDrag()) {
            if (this.fvI == null || !this.fvI.isLongPic || this.fyh.getVisibility() != 0 || this.fyh.isViewTop()) {
                if (this.fvI == null || !this.fvI.isLongPic || this.fyh.getVisibility() == 0 || this.fyf.isAtViewTop() || this.fyf.bFY()) {
                    if (this.fyh.getVisibility() == 0 || this.fyf.pagerCantScroll()) {
                        if (this.fyp != null && getScrollY() == 0) {
                            boolean z = (this.fvI == null || !this.fvI.isLongPic) && ((f2 < -15.0f && !this.isInDragScaleMode) || (f2 > 15.0f && !this.isInDragScaleMode));
                            boolean z2 = this.fvI != null && this.fvI.isLongPic && f2 < 0.0f && !this.isInDragScaleMode;
                            if (z || (z2 && this.fyf.isViewTop())) {
                                this.fyf.setImageOnLongClickListener(null);
                                this.fyh.setOnLongClickListener(null);
                                this.isInDragScaleMode = true;
                                this.mMoveDistance = 0.0f;
                                this.mRatio = 1.0f;
                                if (this.fyu != null) {
                                    this.fyu.onDragStart();
                                }
                            }
                        }
                        if (!this.isInDragScaleMode || this.fyp == null) {
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
                        this.mDragMatrix.preScale(1.0f + f3, 1.0f + f3, (this.mRatio * this.fyp.getWidth()) / 2.0f, this.mRatio * (this.fyp.getHeight() / 2));
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
        if (this.fyn && this.fyp != null && !this.fyp.isRecycled() && this.isInDragScaleMode) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.mDstRect == null) {
                this.mDstRect = new RectF();
            }
            this.mDragMatrix.mapRect(this.mDstRect, new RectF(this.mDisplayRect));
            canvas.drawBitmap(this.fyp, this.fyr, this.mDstRect, (Paint) null);
        } else if (this.fyo && this.fyp != null && !this.fyp.isRecycled()) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.fvI == null || this.fvI.getSourceImageRectInScreen() == null) {
                canvas.drawBitmap(this.fyp, this.fyr, this.mDstRect, (Paint) null);
            } else {
                canvas.drawBitmap(this.fyp, this.fys, this.mDstRect, (Paint) null);
            }
        } else {
            super.dispatchDraw(canvas);
        }
    }

    private void startExitAnimation() {
        if (this.fvI == null) {
            if (this.fyu != null) {
                this.fyu.onDragEnd();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.fvI.getSourceImageRectInScreen();
        final Rect dstRectInScreen = this.fvI.getDstRectInScreen();
        if (sourceImageRectInScreen == null || dstRectInScreen == null) {
            if (this.fyu != null) {
                this.fyu.onDragEnd();
                return;
            }
            return;
        }
        a(sourceImageRectInScreen, dstRectInScreen);
        a(sourceImageRectInScreen);
        this.fyq = new RectF(this.mDstRect);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(150L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && sourceImageRectInScreen != null && dstRectInScreen != null) {
                    UrlDragImageView.this.ap(valueAnimator.getAnimatedFraction());
                    UrlDragImageView.this.a(dstRectInScreen, valueAnimator.getAnimatedFraction(), UrlDragImageView.this.fyM);
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
                if (UrlDragImageView.this.fyu != null) {
                    UrlDragImageView.this.fyu.onDragEnd();
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
            this.mDstRect.top += this.mDstRect.height() * this.fyA;
            this.mDstRect.bottom = f + this.mDstRect.top;
        }
    }

    public void setCanScale(boolean z) {
        if (this.fyf != null) {
            this.fyf.setCanScale(z);
        }
    }

    private void a(Rect rect, Rect rect2) {
        this.fyw = 0.0f;
        this.fyx = 0.0f;
        this.fyy = 1.0f;
        this.fyz = 1.0f;
        if (rect != null && rect2 != null && rect.contains(rect2)) {
            this.fyw = (rect2.left - rect.left) / rect.width();
            this.fyx = (rect2.top - rect.top) / rect.height();
            this.fyy = (rect2.right - rect.left) / rect.width();
            this.fyz = (rect2.bottom - rect.top) / rect.height();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(float f) {
        if (this.fys != null) {
            this.fys.left = (int) (this.fyt.left + (this.fyt.width() * this.fyw * f));
            this.fys.top = (int) (this.fyt.top + (this.fyt.height() * this.fyx * f));
            this.fys.right = (int) (this.fyt.left + (this.fyt.width() * (((1.0f - this.fyy) * (1.0f - f)) + this.fyy)));
            this.fys.bottom = (int) (this.fyt.top + (this.fyt.height() * (((1.0f - this.fyz) * (1.0f - f)) + this.fyz)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Rect rect, float f, boolean z) {
        int i = 0;
        if (z) {
            i = l.getDimens(getContext(), R.dimen.tbds80);
        }
        if (this.mDstRect != null && rect != null) {
            this.mDstRect.left = this.fyq.left + ((rect.left - this.fyq.left) * f);
            this.mDstRect.top = (this.fyq.top + ((rect.top - this.fyq.top) * f)) - i;
            this.mDstRect.right = this.fyq.right + ((rect.right - this.fyq.right) * f);
            this.mDstRect.bottom = this.fyq.bottom + ((rect.bottom - this.fyq.bottom) * f);
        }
    }

    private RectF getRectInScreenFromPosition(float f, float f2, float f3, float f4) {
        return new RectF(f - (f3 / 2.0f), f2 - (f4 / 2.0f), (f3 / 2.0f) + f, (f4 / 2.0f) + f2);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.fyG = onTouchListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzI() {
        if ((this.fyk || this.fyl) && this.fvI != null && this.fvI.mPicType == 1 && !TextUtils.isEmpty(this.fvI.mTagName)) {
            if (this.fyg != null) {
                this.fyg.setVisibility(8);
                this.fyg = null;
            }
            this.fyg = new TextView(this.mContext);
            this.fyg.setText(this.fvI.mTagName);
            this.fyg.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize26));
            ap.setViewTextColor(this.fyg, R.color.common_color_10013, 1, 0);
            ap.setBackgroundColor(this.fyg, R.color.common_color_10215);
            this.fyg.setAlpha(0.75f);
            this.fyg.setIncludeFontPadding(false);
            this.fyg.setGravity(17);
            int dimens = l.getDimens(this.mContext, R.dimen.ds2);
            this.fyg.setPadding(dimens, dimens, dimens, dimens);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.fyf.getBottomOffset();
            layoutParams.leftMargin = this.fyf.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.fyg, layoutParams);
            this.fyg.setVisibility(0);
        }
    }

    public void setUrl(String str, boolean z) {
        if (str.contains("*")) {
            str = str.split("[*]")[0];
        }
        this.fyf.setTag(str);
        this.fyf.setLoadBigImage(false);
        this.fyf.setImageDrawable(null);
        this.fyk = false;
        this.fyl = false;
        this.fyB = bzQ();
        this.fyJ = null;
        if (Cs(str)) {
            e(str, z, false);
        }
    }

    private boolean bzJ() {
        return this.fyf != null && this.fyf.isLoadBigImage();
    }

    public void bzK() {
        if (this.fvI != null && !bzJ()) {
            String str = this.fvI.imageUrl;
            int i = this.fvI.urlType;
            com.baidu.adp.widget.ImageView.a aVar = null;
            if (com.baidu.tbadk.core.util.d.a.ar(str, i)) {
                aVar = com.baidu.tbadk.core.util.d.a.as(str, i);
            }
            if (aVar != null) {
                setThumbBitmapToView(aVar);
            }
        }
    }

    private boolean kC(boolean z) {
        String nameMd5FromUrl;
        if (!this.fyC || z) {
            this.fyC = true;
            if (!this.fyB || this.fvI == null || StringUtils.isNull(this.fvI.originalUrl, true) || this.fvI.originalSize < 0 || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String str = this.fyv + at.bsP().Be(nameMd5FromUrl) + "/" + aw.getNameMd5FromUrl(this.fvI.originalUrl);
            final int[] imageFileWH = o.getImageFileWH(str);
            this.fyh.setVisibility(0);
            if (this.fyi == null) {
                this.fyi = new SubsamplingScaleImageView.OnImageEventListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12
                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onReady() {
                        UrlDragImageView.this.fyJ = null;
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.fyf.restoreSize();
                        UrlDragImageView.this.fyf.setVisibility(4);
                    }

                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onImageLoaded() {
                        if (UrlDragImageView.this.fvI.isLongPic && imageFileWH[0] > 0) {
                            UrlDragImageView.this.fyf.onDestroy();
                            final float measuredWidth = (UrlDragImageView.this.getMeasuredWidth() * 1.0f) / imageFileWH[0];
                            final PointF pointF = new PointF((imageFileWH[0] * 1.0f) / 2.0f, 0.0f);
                            UrlDragImageView.this.fyh.setScaleAndCenter(measuredWidth, pointF);
                            UrlDragImageView.this.fyh.setMaxScale(2.0f * measuredWidth);
                            UrlDragImageView.this.fyh.setDoubleTapZoomScale(2.0f * measuredWidth);
                            UrlDragImageView.this.fyh.setInitScale(measuredWidth);
                            UrlDragImageView.this.fyh.setDoubleTapZoomStyle(4);
                            UrlDragImageView.this.fyh.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12.1
                                @Override // android.view.View.OnTouchListener
                                public boolean onTouch(View view, MotionEvent motionEvent) {
                                    if (UrlDragImageView.this.fyG != null) {
                                        UrlDragImageView.this.fyG.onTouch(view, motionEvent);
                                    }
                                    switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                                        case 0:
                                            UrlDragImageView.this.fyI = motionEvent.getY();
                                            UrlDragImageView.this.fyh.setOnClickListener(UrlDragImageView.this.fyH ? UrlDragImageView.this.mOnClickListener : null);
                                            UrlDragImageView.this.fyh.setOnLongClickListener(UrlDragImageView.this.fyH ? UrlDragImageView.this.mLongClickListener : null);
                                            break;
                                        case 1:
                                        case 3:
                                            if (UrlDragImageView.this.fyh.getScale() < measuredWidth) {
                                                UrlDragImageView.this.fyh.setScaleAndCenter(measuredWidth, pointF);
                                            }
                                            e.mA().removeCallbacks(UrlDragImageView.this.fyN);
                                            e.mA().postDelayed(UrlDragImageView.this.fyN, 1000L);
                                            break;
                                        case 2:
                                            if (Math.abs(motionEvent.getY() - UrlDragImageView.this.fyI) > UrlDragImageView.TOUCH_SLOP) {
                                                UrlDragImageView.this.fyH = false;
                                                UrlDragImageView.this.fyh.setOnClickListener(null);
                                                UrlDragImageView.this.fyh.setOnLongClickListener(null);
                                            }
                                            UrlDragImageView.this.fyI = motionEvent.getY();
                                            break;
                                    }
                                    return false;
                                }
                            });
                            UrlDragImageView.this.fyf.setVisibility(4);
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
            this.fyh.setOnImageEventListener(this.fyi);
            if (this.fyh.isImageLoaded() && this.fvI.isLongPic) {
                this.fyi.onImageLoaded();
            } else {
                this.fyh.setImage(ImageSource.uri(str));
            }
            return true;
        }
        return false;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.fyu = dVar;
        if (this.fyf != null) {
            this.fyf.setDragToExitListener(dVar);
        }
    }

    public void bzL() {
        kC(false);
    }

    private boolean Cs(String str) {
        return j.isNetWorkAvailable() || com.baidu.tbadk.core.util.d.b.Br(str);
    }

    private void setThumbBitmapToView(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap rawBitmap;
        if (!this.fyl && aVar != null && (rawBitmap = aVar.getRawBitmap()) != null) {
            this.fyk = true;
            if (aVar.isGif()) {
                this.fyf.setImageUrlData(this.fvI);
                this.fyf.setImageBitmap(rawBitmap);
                this.fyJ = null;
                this.fyE = false;
            } else {
                if (this.fvI != null && this.fvI.isLongPic) {
                    this.fyf.createLargeImageDelegate();
                    this.fyf.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.13
                        @Override // com.baidu.tbadk.widget.largeImage.logic.a
                        public void onLoadFinished() {
                        }
                    });
                }
                this.fyf.setImageUrlData(this.fvI);
                this.fyf.setImageData(rawBitmap, aVar.getByteData());
            }
            bzI();
        }
    }

    private void e(String str, boolean z, boolean z2) {
        if (Ct(str)) {
            if (z2 || (!this.fym && !this.fyl)) {
                if (!z2 || !kC(true)) {
                    this.fym = true;
                    d.mw().a(str, 27, new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.14
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.c
                        public void onCancelled(String str2) {
                            UrlDragImageView.this.fym = false;
                            UrlDragImageView.this.fyf.setVisibility(0);
                            UrlDragImageView.this.mProgressBar.setVisibility(8);
                            UrlDragImageView.this.fyJ = null;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.c
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            UrlDragImageView.this.fym = false;
                            UrlDragImageView.this.fyl = true;
                            UrlDragImageView.this.b(aVar);
                        }
                    }, 0, 0, false, null, Boolean.valueOf(z), this.fyf.getImageData(), Boolean.valueOf(this.fwJ));
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
        com.baidu.adp.widget.ImageView.a a2 = this.fyF.a(imageFileInfo, false);
        if (a2 != null) {
            this.fyl = true;
            this.mProgressBar.setVisibility(8);
            this.fyJ = null;
            b(a2);
            return;
        }
        this.fyF.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.2
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.ImageView.a aVar, String str2, boolean z3) {
                UrlDragImageView.this.fyl = true;
                UrlDragImageView.this.mProgressBar.setVisibility(8);
                UrlDragImageView.this.fyJ = null;
                UrlDragImageView.this.b(aVar);
            }
        }, false);
    }

    private boolean Ct(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null && this.fyj != null) {
            this.fyj.l(aVar.getUrl(), aVar.getByteData());
        }
        if (aVar == null || aVar.getRawBitmap() == null) {
            bzM();
            return;
        }
        Bitmap rawBitmap = aVar.getRawBitmap();
        this.fyf.setLoadBigImage(true);
        if (aVar.isGif()) {
            this.fyf.setGifData(aVar.getByteData(), rawBitmap);
            this.fyf.invalidate();
            this.fyf.play();
            this.fyE = false;
            this.fyJ = null;
            this.mProgressBar.setVisibility(8);
        } else {
            if (this.fvI != null && this.fvI.isLongPic) {
                this.fyf.createLargeImageDelegate();
                this.fyf.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.3
                    @Override // com.baidu.tbadk.widget.largeImage.logic.a
                    public void onLoadFinished() {
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.fyJ = null;
                    }
                });
            } else {
                this.mProgressBar.setVisibility(8);
                this.fyJ = null;
            }
            this.fyf.setImageUrlData(this.fvI);
            this.fyf.setImageData(rawBitmap, aVar.getByteData());
            bzR();
        }
        bzI();
    }

    private void bzM() {
        if (!this.fyk) {
            this.fyf.setDefaultBitmap();
        } else {
            this.fyl = false;
        }
        this.fyJ = null;
        this.mProgressBar.setVisibility(8);
    }

    public void setGifMaxUseableMem(int i) {
        this.fyf.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.fyf != null) {
            this.fyf.onDestroy();
        }
        if (this.fyh != null) {
            this.fyh.recycle();
        }
        if (this.fyp != null) {
            this.fyp.recycle();
            this.fyp = null;
        }
        if (this.mProgressBar != null) {
            this.fyJ = null;
            this.mProgressBar.setVisibility(8);
        }
        e.mA().removeCallbacks(this.fyN);
        com.baidu.tieba.view.c.dVY().setColor(-1);
    }

    public void release() {
        if (this.fyf != null) {
            this.fyf.release();
        }
        if (this.mProgressBar != null) {
            this.fyJ = null;
            this.mProgressBar.setVisibility(8);
        }
        this.fyJ = null;
    }

    public void bzN() {
        if (this.fyf != null && this.fyf.getImageType() == 1) {
            this.fyf.stop();
        }
    }

    public void D(boolean z, boolean z2) {
        String str;
        if (this.fyf != null && (str = (String) this.fyf.getTag()) != null) {
            if (this.fyf.getImageType() == 1) {
                if (this.fyf.getGifCache() == null || !this.fyf.isLoadBigImage()) {
                    e(str, z, z2);
                }
            } else if (this.fyf.getImageType() == 2) {
                e(str, z, z2);
            } else if (bzO()) {
                e(str, z, z2);
            }
        }
    }

    private boolean bzO() {
        if (this.fyf.getImageBitmap() != null && this.fyf.isLoadBigImage()) {
            if (this.fvI == null || !this.fvI.isLongPic || this.fyf.hasLoadLongImage()) {
                return false;
            }
            this.fyl = false;
            this.fyC = false;
            return true;
        }
        return true;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.fvI = imageUrlData;
    }

    public ImageUrlData getmAssistUrlData() {
        return this.fvI;
    }

    public void setIsCdn(boolean z) {
        this.fwJ = z;
    }

    public void bzP() {
        final String nameMd5FromUrl = aw.getNameMd5FromUrl(this.fvI.originalUrl);
        if (this.fvI.originalProcess >= 0) {
            com.baidu.tbadk.download.d.bBd().cancelDownLoadById(nameMd5FromUrl, 13);
            this.fvI.originalProcess = -1;
            bzR();
            return;
        }
        if (this.fwC != null) {
            this.fwC.bzU();
        }
        f<?> K = com.baidu.adp.base.j.K(this.mContext);
        if (K == null) {
            Cu(nameMd5FromUrl);
        } else if (!j.isNetWorkAvailable() || j.isWifiNet() || com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean(SharedPrefConfig.ORIGINAL_IMG_DOWN_TIP, false)) {
            Cu(nameMd5FromUrl);
        } else {
            com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(SharedPrefConfig.ORIGINAL_IMG_DOWN_TIP, true);
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(K.getPageActivity());
            aVar.nx(R.string.original_img_down_no_wifi_tip);
            aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    UrlDragImageView.this.Cu(nameMd5FromUrl);
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                }
            });
            aVar.b(K);
            aVar.bqx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cu(String str) {
        if (this.fvI != null) {
            this.fvI.originalProcess = 0;
            this.fyK.setProgress(0);
            this.fyK.setVisibility(0);
            DownloadData downloadData = new DownloadData(str);
            downloadData.setStatus(1);
            downloadData.setUrl(this.fvI.originalUrl);
            downloadData.setType(13);
            downloadData.setPath(this.fyv + at.bsP().Be(str) + "/" + str);
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.6
                @Override // com.baidu.tbadk.download.c
                public boolean onPreDownload(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2 != null) {
                        if (UrlDragImageView.this.fvI != null && UrlDragImageView.this.fvI.originalProcess != -1) {
                            UrlDragImageView.this.fvI.originalProcess = downloadData2.getProcess();
                        }
                        if (UrlDragImageView.this.fvI == null || UrlDragImageView.this.fvI.originalProcess != -1) {
                            UrlDragImageView.this.fyK.setProgress(downloadData2.getProcess());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public boolean onFileDownloaded(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadSucceed(DownloadData downloadData2) {
                    UrlDragImageView.this.fyK.setVisibility(8);
                    e.mA().postDelayed(UrlDragImageView.this.fyO, 1500L);
                    UrlDragImageView.this.fyC = false;
                    UrlDragImageView.this.fyB = UrlDragImageView.this.bzQ();
                    UrlDragImageView.this.bzL();
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str2) {
                    UrlDragImageView.this.fyK.setVisibility(8);
                    UrlDragImageView.this.fyC = false;
                    BdToast.b(UrlDragImageView.this.mContext, str2).bqC().bqD();
                    UrlDragImageView.this.fvI.originalProcess = -1;
                    UrlDragImageView.this.bzR();
                }
            });
            com.baidu.tbadk.download.d.bBd().a(downloadData, 100);
            this.fyL = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bzQ() {
        if (this.fvI != null && !StringUtils.isNull(this.fvI.originalUrl, true) && this.fvI.originalSize >= 0 && !this.fvI.isBlockedPic) {
            String nameMd5FromUrl = aw.getNameMd5FromUrl(this.fvI.originalUrl);
            File file = new File(this.fyv + at.bsP().Be(nameMd5FromUrl) + "/" + nameMd5FromUrl);
            if (file != null && file.exists()) {
                this.fvI.originalProcess = 100;
                return true;
            }
            if (this.fvI.originalProcess < 0) {
                bzR();
            } else {
                this.fyK.setProgress(this.fvI.originalProcess);
            }
            this.fyE = true;
        } else {
            this.fyJ = null;
        }
        return false;
    }

    public void bzR() {
        if (this.fvI != null) {
            if (!bzS() || !this.fyE) {
                this.fyJ = null;
            } else if (this.fvI.originalSize > 0 && !ej(this.fvI.originalSize)) {
                this.fyJ = fyd + "(" + au.getFormatSize(this.fvI.originalSize) + ")";
            } else {
                this.fyJ = fyd;
            }
        }
    }

    private boolean bzS() {
        return (this.fvI == null || !this.fvI.mIsShowOrigonButton || this.fvI.isBlockedPic || StringUtils.isNull(this.fvI.originalUrl)) ? false : true;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.fwC = bVar;
    }

    private boolean ej(long j) {
        return j > fye;
    }
}
