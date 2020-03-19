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
    private ImageUrlData dri;
    private b dso;
    private boolean dsw;
    private boolean dsy;
    protected DragImageView dtR;
    protected TextView dtS;
    protected SubsamplingScaleImageView dtT;
    private SubsamplingScaleImageView.OnImageEventListener dtU;
    private a dtV;
    private boolean dtW;
    private boolean dtX;
    private boolean dtY;
    private boolean dtZ;
    private Runnable duA;
    private View.OnTouchListener duB;
    private boolean dua;
    private Bitmap dub;
    private RectF duc;
    private Rect dud;
    private Rect due;
    private Rect duf;
    private DragImageView.d dug;
    private String duh;
    private float dui;
    private float duj;
    private float duk;
    private float dul;
    private float dum;
    private boolean dun;
    private boolean duo;
    private boolean dup;
    public boolean duq;
    private com.baidu.tbadk.img.b dur;
    private View.OnTouchListener dus;
    private boolean dut;
    private float duu;
    private String duv;
    private CircleProgressView duw;
    private boolean dux;
    private boolean duy;
    private Runnable duz;
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
    private static final String dtP = TbadkCoreApplication.getInst().getString(R.string.original_img_look);
    private static long dtQ = Config.RAVEN_LOG_LIMIT;
    private static final int EXIT_DISTANCE = l.getEquipmentHeight(TbadkCoreApplication.getInst()) / 5;
    private static final String TAG = UrlDragImageView.class.getSimpleName();
    private static final int TOUCH_SLOP = ViewConfiguration.get(TbadkCoreApplication.getInst()).getScaledTouchSlop();

    /* loaded from: classes8.dex */
    public interface a {
        void k(String str, byte[] bArr);
    }

    /* loaded from: classes8.dex */
    public interface b {
        void aNm();
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
        if (this.dtR != null) {
            this.dtR.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.dtV = aVar;
    }

    public UrlDragImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.dtR = null;
        this.dtV = null;
        this.dsw = false;
        this.dtY = false;
        this.isInDragScaleMode = false;
        this.mRatio = 1.0f;
        this.mMoveDistance = 0.0f;
        this.mDragMatrix = new Matrix();
        this.mDstRect = new RectF();
        this.dui = 0.0f;
        this.duj = 0.0f;
        this.duk = 1.0f;
        this.dul = 1.0f;
        this.dum = 0.0f;
        this.dun = false;
        this.duo = false;
        this.dup = false;
        this.duq = false;
        this.dut = true;
        this.duu = 0.0f;
        this.mOnClickListener = null;
        this.mLongClickListener = null;
        this.duv = null;
        this.duz = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.dut = true;
            }
        };
        this.duA = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.duw.setVisibility(8);
                        UrlDragImageView.this.duv = null;
                        UrlDragImageView.this.duq = false;
                    }
                });
            }
        };
        this.duB = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.dus != null) {
                    UrlDragImageView.this.dus.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.dur = new com.baidu.tbadk.img.b();
        init();
    }

    public UrlDragImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.dtR = null;
        this.dtV = null;
        this.dsw = false;
        this.dtY = false;
        this.isInDragScaleMode = false;
        this.mRatio = 1.0f;
        this.mMoveDistance = 0.0f;
        this.mDragMatrix = new Matrix();
        this.mDstRect = new RectF();
        this.dui = 0.0f;
        this.duj = 0.0f;
        this.duk = 1.0f;
        this.dul = 1.0f;
        this.dum = 0.0f;
        this.dun = false;
        this.duo = false;
        this.dup = false;
        this.duq = false;
        this.dut = true;
        this.duu = 0.0f;
        this.mOnClickListener = null;
        this.mLongClickListener = null;
        this.duv = null;
        this.duz = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.dut = true;
            }
        };
        this.duA = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.duw.setVisibility(8);
                        UrlDragImageView.this.duv = null;
                        UrlDragImageView.this.duq = false;
                    }
                });
            }
        };
        this.duB = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.dus != null) {
                    UrlDragImageView.this.dus.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.dur = new com.baidu.tbadk.img.b();
        init();
    }

    public DragImageView getImageView() {
        return this.dtR;
    }

    public void setGifSetListener(DragImageView.e eVar) {
        this.dtR.setGifSetListener(eVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.dtR.setImageOnClickListener(onClickListener);
        this.dtT.setOnClickListener(onClickListener);
        this.mOnClickListener = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mLongClickListener = onLongClickListener;
        if (!this.dsy) {
            this.dtR.setImageOnLongClickListener(this.mLongClickListener);
            this.dtT.setOnLongClickListener(this.mLongClickListener);
        }
    }

    public void setOnSizeChangedListener(final DragImageView.g gVar) {
        this.dtR.setOnSizeChangedListener(new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.8
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (gVar != null) {
                    gVar.a(dragImageView, z, z2);
                }
                UrlDragImageView.this.aNa();
            }
        });
    }

    protected void init() {
        this.duh = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        this.mMaxWidth = l.getEquipmentWidth(this.mContext);
        this.mMaxHeight = l.getEquipmentHeight(this.mContext) - ((int) this.mContext.getResources().getDimension(R.dimen.ds166));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.dtR = new DragImageView(this.mContext);
        this.dtR.setLayoutParams(layoutParams);
        this.dtR.setOnTouchListener(this.duB);
        addView(this.dtR);
        this.dtT = new SubsamplingScaleImageView(this.mContext);
        this.dtT.setMaxScale(50.0f);
        this.dtT.setOnTouchListener(this.duB);
        this.dtT.setVisibility(4);
        addView(this.dtT, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(getResources().getDrawable(R.drawable.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        aMZ();
        this.duy = TbSingleton.getInstance().isCutoutScreen(TbadkApplication.getInst().getCurrentActivity());
    }

    private void aMZ() {
        this.duw = new CircleProgressView(this.mContext);
        this.duw.setCircleBackgroundColor(am.getColor(R.color.cp_cont_d));
        this.duw.setCircleForegroundColor(am.getColor(R.color.cp_link_tip_a));
        this.duw.setProgress(0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds80), l.getDimens(getContext(), R.dimen.tbds80));
        layoutParams.addRule(13);
        this.duw.setVisibility(8);
        addView(this.duw, layoutParams);
    }

    public void setIsCanDrag(boolean z) {
        this.dsy = z;
    }

    public String getmCheckOriginPicText() {
        return this.duv;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        Bitmap imageBitmap;
        int height;
        int width;
        if (this.dun && !this.dux && this.dtT.getVisibility() == 0 && !this.dtT.isImageLoaded()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.dsy || !this.dtX) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.dtZ && motionEvent.getPointerCount() >= 2) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.dtZ || this.dua) {
            requestDisallowInterceptTouchEvent(true);
        }
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        float x = motionEvent.getX();
        int i = action & 255;
        if (i == 0) {
            if (this.dub == null) {
                if (this.dtT.getVisibility() == 0) {
                    this.dub = g.bi(this.dtT);
                } else {
                    this.dub = g.bi(this.dtR);
                }
            }
            if (this.mDisplayRect == null && this.dub != null) {
                int measuredWidth = getMeasuredWidth();
                float measuredWidth2 = ((getMeasuredWidth() * 1.0f) / this.dub.getWidth()) * this.dub.getHeight();
                if (measuredWidth2 > getMeasuredHeight()) {
                    measuredWidth2 = getMeasuredHeight();
                }
                RectF rectInScreenFromPosition = getRectInScreenFromPosition(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
                this.mDisplayRect = new Rect((int) rectInScreenFromPosition.left, (int) rectInScreenFromPosition.top, (int) rectInScreenFromPosition.right, (int) rectInScreenFromPosition.bottom);
            }
            if (this.due == null && this.dub != null) {
                if (this.dtT.getVisibility() == 0) {
                    height = this.dtT.getSHeight();
                    width = this.dtT.getSWidth();
                } else {
                    if (this.dtR.getImageType() == 1) {
                        imageBitmap = (this.dtR.getCurrentFrame() == null || this.dtR.getCurrentFrame().bm == null) ? this.dub : this.dtR.getCurrentFrame().bm;
                    } else {
                        imageBitmap = this.dtR.getImageBitmap() == null ? this.dub : this.dtR.getImageBitmap();
                    }
                    height = imageBitmap.getHeight();
                    width = imageBitmap.getWidth();
                }
                float equipmentDensity = l.getEquipmentDensity(getContext());
                int i2 = (int) (height * equipmentDensity);
                int i3 = (int) (width * equipmentDensity);
                if (i3 > this.dub.getWidth() && this.dub.getWidth() != 0) {
                    float width2 = (i3 * 1.0f) / this.dub.getWidth();
                    i3 = this.dub.getWidth();
                    i2 = (int) (i2 / width2);
                }
                if (i2 > this.dub.getHeight() && this.dub.getHeight() != 0) {
                    i3 = (int) (i3 / ((i2 * 1.0f) / this.dub.getHeight()));
                    i2 = this.dub.getHeight();
                }
                int equipmentHeight = (l.getEquipmentHeight(getContext()) - i2) / 2;
                int equipmentWidth = (l.getEquipmentWidth(getContext()) - i3) / 2;
                this.due = new Rect(equipmentWidth, equipmentHeight, i3 + equipmentWidth, i2 + equipmentHeight);
                this.duf = new Rect(this.due);
                this.dum = equipmentHeight / l.getEquipmentHeight(getContext());
                this.dud = new Rect(0, 0, this.dub.getWidth(), this.dub.getHeight());
            }
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (i == 2) {
            this.dtZ = s(this.mLastMotionX - x, this.mLastMotionY - y);
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (this.dtZ || this.dua) {
            this.dtR.setImageOnLongClickListener(null);
            this.dtT.setOnLongClickListener(null);
            z = true;
        } else {
            this.dtR.setImageOnLongClickListener(this.mLongClickListener);
            this.dtT.setOnLongClickListener(this.mLongClickListener);
            z = super.dispatchTouchEvent(motionEvent);
        }
        if (i == 1 || i == 3) {
            this.mLastMotionX = 0.0f;
            this.mLastMotionY = 0.0f;
            boolean z2 = (-this.mMoveDistance) > ((float) EXIT_DISTANCE);
            boolean z3 = this.mMoveDistance > ((float) EXIT_DISTANCE);
            if (z2 || z3) {
                this.dua = true;
                startExitAnimation();
                if (z2) {
                    TiebaStatic.log(new an("c13377").cx("obj_type", "3"));
                } else if (z3) {
                    TiebaStatic.log(new an("c13377").cx("obj_type", "2"));
                }
            } else {
                if (this.dtZ && this.dug != null) {
                    this.dug.aSK();
                }
                this.mRatio = 1.0f;
                invalidate();
            }
            this.isInDragScaleMode = false;
            this.mDragMatrix.reset();
            this.dtZ = false;
        }
        return z;
    }

    private boolean s(float f, float f2) {
        if (this.dtT.getVisibility() != 0 || this.dtT.isCanDrag()) {
            if (this.dri == null || !this.dri.isLongPic || this.dtT.getVisibility() != 0 || this.dtT.isViewTop()) {
                if (this.dri == null || !this.dri.isLongPic || this.dtT.getVisibility() == 0 || this.dtR.isAtViewTop() || this.dtR.aSI()) {
                    if (this.dtT.getVisibility() == 0 || this.dtR.pagerCantScroll()) {
                        if (this.dub != null && getScrollY() == 0) {
                            boolean z = (this.dri == null || !this.dri.isLongPic) && ((f2 < -15.0f && !this.isInDragScaleMode) || (f2 > 15.0f && !this.isInDragScaleMode));
                            boolean z2 = this.dri != null && this.dri.isLongPic && f2 < 0.0f && !this.isInDragScaleMode;
                            if (z || (z2 && this.dtR.isViewTop())) {
                                this.dtR.setImageOnLongClickListener(null);
                                this.dtT.setOnLongClickListener(null);
                                this.isInDragScaleMode = true;
                                this.mMoveDistance = 0.0f;
                                this.mRatio = 1.0f;
                                if (this.dug != null) {
                                    this.dug.onDragStart();
                                }
                            }
                        }
                        if (!this.isInDragScaleMode || this.dub == null) {
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
                        this.mDragMatrix.preScale(1.0f + f3, 1.0f + f3, (this.mRatio * this.dub.getWidth()) / 2.0f, this.mRatio * (this.dub.getHeight() / 2));
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
        if (this.dtZ && this.dub != null && !this.dub.isRecycled() && this.isInDragScaleMode) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.mDstRect == null) {
                this.mDstRect = new RectF();
            }
            this.mDragMatrix.mapRect(this.mDstRect, new RectF(this.mDisplayRect));
            canvas.drawBitmap(this.dub, this.dud, this.mDstRect, (Paint) null);
        } else if (this.dua && this.dub != null && !this.dub.isRecycled()) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.dri == null || this.dri.getSourceImageRectInScreen() == null) {
                canvas.drawBitmap(this.dub, this.dud, this.mDstRect, (Paint) null);
            } else {
                canvas.drawBitmap(this.dub, this.due, this.mDstRect, (Paint) null);
            }
        } else {
            super.dispatchDraw(canvas);
        }
    }

    private void startExitAnimation() {
        if (this.dri == null) {
            if (this.dug != null) {
                this.dug.onDragEnd();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.dri.getSourceImageRectInScreen();
        final Rect dstRectInScreen = this.dri.getDstRectInScreen();
        if (sourceImageRectInScreen == null || dstRectInScreen == null) {
            if (this.dug != null) {
                this.dug.onDragEnd();
                return;
            }
            return;
        }
        a(sourceImageRectInScreen, dstRectInScreen);
        b(sourceImageRectInScreen);
        this.duc = new RectF(this.mDstRect);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(150L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && sourceImageRectInScreen != null && dstRectInScreen != null) {
                    UrlDragImageView.this.aq(valueAnimator.getAnimatedFraction());
                    UrlDragImageView.this.a(dstRectInScreen, valueAnimator.getAnimatedFraction(), UrlDragImageView.this.duy);
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
                if (UrlDragImageView.this.dug != null) {
                    UrlDragImageView.this.dug.onDragEnd();
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
            this.mDstRect.top += this.mDstRect.height() * this.dum;
            this.mDstRect.bottom = f + this.mDstRect.top;
        }
    }

    public void setCanScale(boolean z) {
        if (this.dtR != null) {
            this.dtR.setCanScale(z);
        }
    }

    private void a(Rect rect, Rect rect2) {
        this.dui = 0.0f;
        this.duj = 0.0f;
        this.duk = 1.0f;
        this.dul = 1.0f;
        if (rect != null && rect2 != null && rect.contains(rect2)) {
            this.dui = (rect2.left - rect.left) / rect.width();
            this.duj = (rect2.top - rect.top) / rect.height();
            this.duk = (rect2.right - rect.left) / rect.width();
            this.dul = (rect2.bottom - rect.top) / rect.height();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aq(float f) {
        if (this.due != null) {
            this.due.left = (int) (this.duf.left + (this.duf.width() * this.dui * f));
            this.due.top = (int) (this.duf.top + (this.duf.height() * this.duj * f));
            this.due.right = (int) (this.duf.left + (this.duf.width() * (((1.0f - this.duk) * (1.0f - f)) + this.duk)));
            this.due.bottom = (int) (this.duf.top + (this.duf.height() * (((1.0f - this.dul) * (1.0f - f)) + this.dul)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Rect rect, float f, boolean z) {
        int i = 0;
        if (z) {
            i = l.getDimens(getContext(), R.dimen.tbds80);
        }
        if (this.mDstRect != null && rect != null) {
            this.mDstRect.left = this.duc.left + ((rect.left - this.duc.left) * f);
            this.mDstRect.top = (this.duc.top + ((rect.top - this.duc.top) * f)) - i;
            this.mDstRect.right = this.duc.right + ((rect.right - this.duc.right) * f);
            this.mDstRect.bottom = this.duc.bottom + ((rect.bottom - this.duc.bottom) * f);
        }
    }

    private RectF getRectInScreenFromPosition(float f, float f2, float f3, float f4) {
        return new RectF(f - (f3 / 2.0f), f2 - (f4 / 2.0f), (f3 / 2.0f) + f, (f4 / 2.0f) + f2);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.dus = onTouchListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNa() {
        if ((this.dtW || this.dtX) && this.dri != null && this.dri.mPicType == 1 && !TextUtils.isEmpty(this.dri.mTagName)) {
            if (this.dtS != null) {
                this.dtS.setVisibility(8);
                this.dtS = null;
            }
            this.dtS = new TextView(this.mContext);
            this.dtS.setText(this.dri.mTagName);
            this.dtS.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize26));
            am.setViewTextColor(this.dtS, R.color.common_color_10013, 1, 0);
            am.setBackgroundColor(this.dtS, R.color.common_color_10215);
            this.dtS.setAlpha(0.75f);
            this.dtS.setIncludeFontPadding(false);
            this.dtS.setGravity(17);
            int dimens = l.getDimens(this.mContext, R.dimen.ds2);
            this.dtS.setPadding(dimens, dimens, dimens, dimens);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.dtR.getBottomOffset();
            layoutParams.leftMargin = this.dtR.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.dtS, layoutParams);
            this.dtS.setVisibility(0);
        }
    }

    public void setUrl(String str, boolean z) {
        if (str.contains("*")) {
            str = str.split("[*]")[0];
        }
        this.dtR.setTag(str);
        this.dtR.setLoadBigImage(false);
        this.dtR.setImageDrawable(null);
        this.dtW = false;
        this.dtX = false;
        this.dun = aNi();
        this.duv = null;
        if (uG(str)) {
            e(str, z, false);
        }
    }

    private boolean aNb() {
        return this.dtR != null && this.dtR.isLoadBigImage();
    }

    public void aNc() {
        if (this.dri != null && !aNb()) {
            String str = this.dri.imageUrl;
            int i = this.dri.urlType;
            com.baidu.adp.widget.ImageView.a aVar = null;
            if (com.baidu.tbadk.core.util.c.a.Z(str, i)) {
                aVar = com.baidu.tbadk.core.util.c.a.aa(str, i);
            }
            if (aVar != null) {
                setThumbBitmapToView(aVar);
            }
        }
    }

    private boolean gs(boolean z) {
        String nameMd5FromUrl;
        if (!this.duo || z) {
            this.duo = true;
            if (!this.dun || this.dri == null || StringUtils.isNull(this.dri.originalUrl, true) || this.dri.originalSize < 0 || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String str = this.duh + ap.aGE().tw(nameMd5FromUrl) + "/" + as.getNameMd5FromUrl(this.dri.originalUrl);
            final int[] imageFileWH = m.getImageFileWH(str);
            this.dtT.setVisibility(0);
            if (this.dtU == null) {
                this.dtU = new SubsamplingScaleImageView.OnImageEventListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12
                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onReady() {
                        UrlDragImageView.this.duv = null;
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.dtR.restoreSize();
                        UrlDragImageView.this.dtR.setVisibility(4);
                    }

                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onImageLoaded() {
                        if (UrlDragImageView.this.dri.isLongPic && imageFileWH[0] > 0) {
                            UrlDragImageView.this.dtR.onDestroy();
                            final float measuredWidth = (UrlDragImageView.this.getMeasuredWidth() * 1.0f) / imageFileWH[0];
                            final PointF pointF = new PointF((imageFileWH[0] * 1.0f) / 2.0f, 0.0f);
                            UrlDragImageView.this.dtT.setScaleAndCenter(measuredWidth, pointF);
                            UrlDragImageView.this.dtT.setMaxScale(2.0f * measuredWidth);
                            UrlDragImageView.this.dtT.setDoubleTapZoomScale(2.0f * measuredWidth);
                            UrlDragImageView.this.dtT.setInitScale(measuredWidth);
                            UrlDragImageView.this.dtT.setDoubleTapZoomStyle(4);
                            UrlDragImageView.this.dtT.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12.1
                                @Override // android.view.View.OnTouchListener
                                public boolean onTouch(View view, MotionEvent motionEvent) {
                                    if (UrlDragImageView.this.dus != null) {
                                        UrlDragImageView.this.dus.onTouch(view, motionEvent);
                                    }
                                    switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                                        case 0:
                                            UrlDragImageView.this.duu = motionEvent.getY();
                                            UrlDragImageView.this.dtT.setOnClickListener(UrlDragImageView.this.dut ? UrlDragImageView.this.mOnClickListener : null);
                                            UrlDragImageView.this.dtT.setOnLongClickListener(UrlDragImageView.this.dut ? UrlDragImageView.this.mLongClickListener : null);
                                            break;
                                        case 1:
                                        case 3:
                                            if (UrlDragImageView.this.dtT.getScale() < measuredWidth) {
                                                UrlDragImageView.this.dtT.setScaleAndCenter(measuredWidth, pointF);
                                            }
                                            e.gx().removeCallbacks(UrlDragImageView.this.duz);
                                            e.gx().postDelayed(UrlDragImageView.this.duz, 1000L);
                                            break;
                                        case 2:
                                            if (Math.abs(motionEvent.getY() - UrlDragImageView.this.duu) > UrlDragImageView.TOUCH_SLOP) {
                                                UrlDragImageView.this.dut = false;
                                                UrlDragImageView.this.dtT.setOnClickListener(null);
                                                UrlDragImageView.this.dtT.setOnLongClickListener(null);
                                            }
                                            UrlDragImageView.this.duu = motionEvent.getY();
                                            break;
                                    }
                                    return false;
                                }
                            });
                            UrlDragImageView.this.dtR.setVisibility(4);
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
            this.dtT.setOnImageEventListener(this.dtU);
            if (this.dtT.isImageLoaded() && this.dri.isLongPic) {
                this.dtU.onImageLoaded();
            } else {
                this.dtT.setImage(ImageSource.uri(str));
            }
            return true;
        }
        return false;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.dug = dVar;
        if (this.dtR != null) {
            this.dtR.setDragToExitListener(dVar);
        }
    }

    public void aNd() {
        gs(false);
    }

    private boolean uG(String str) {
        return j.isNetWorkAvailable() || com.baidu.tbadk.core.util.c.c.tI(str);
    }

    private void setThumbBitmapToView(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap rawBitmap;
        if (!this.dtX && aVar != null && (rawBitmap = aVar.getRawBitmap()) != null) {
            this.dtW = true;
            if (aVar.isGif()) {
                this.dtR.setImageUrlData(this.dri);
                this.dtR.setImageBitmap(rawBitmap);
                this.duv = null;
                this.duq = false;
            } else {
                if (this.dri != null && this.dri.isLongPic) {
                    this.dtR.createLargeImageDelegate();
                    this.dtR.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.13
                        @Override // com.baidu.tbadk.widget.largeImage.logic.a
                        public void onLoadFinished() {
                        }
                    });
                }
                this.dtR.setImageUrlData(this.dri);
                this.dtR.setImageData(rawBitmap, aVar.getByteData());
            }
            aNa();
        }
    }

    private void e(String str, boolean z, boolean z2) {
        if (uH(str)) {
            if (z2 || (!this.dtY && !this.dtX)) {
                if (!z2 || !gs(true)) {
                    this.dtY = true;
                    com.baidu.adp.lib.e.c.gr().a(str, 27, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.14
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.b
                        public void onCancelled(String str2) {
                            UrlDragImageView.this.dtY = false;
                            UrlDragImageView.this.dtR.setVisibility(0);
                            UrlDragImageView.this.mProgressBar.setVisibility(8);
                            UrlDragImageView.this.duv = null;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            UrlDragImageView.this.dtY = false;
                            UrlDragImageView.this.dtX = true;
                            UrlDragImageView.this.b(aVar);
                        }
                    }, 0, 0, false, null, Boolean.valueOf(z), this.dtR.getImageData(), Boolean.valueOf(this.dsw));
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
        imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.aK(this.mMaxWidth, this.mMaxHeight));
        com.baidu.adp.widget.ImageView.a a2 = this.dur.a(imageFileInfo, false);
        if (a2 != null) {
            this.dtX = true;
            this.mProgressBar.setVisibility(8);
            this.duv = null;
            b(a2);
            return;
        }
        this.dur.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.2
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.ImageView.a aVar, String str2, boolean z3) {
                UrlDragImageView.this.dtX = true;
                UrlDragImageView.this.mProgressBar.setVisibility(8);
                UrlDragImageView.this.duv = null;
                UrlDragImageView.this.b(aVar);
            }
        }, false);
    }

    private boolean uH(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null && this.dtV != null) {
            this.dtV.k(aVar.getUrl(), aVar.getByteData());
        }
        if (aVar == null || aVar.getRawBitmap() == null) {
            aNe();
            return;
        }
        Bitmap rawBitmap = aVar.getRawBitmap();
        this.dtR.setLoadBigImage(true);
        if (aVar.isGif()) {
            this.dtR.setGifData(aVar.getByteData(), rawBitmap);
            this.dtR.invalidate();
            this.dtR.play();
            this.duq = false;
            this.duv = null;
            this.mProgressBar.setVisibility(8);
        } else {
            if (this.dri != null && this.dri.isLongPic) {
                this.dtR.createLargeImageDelegate();
                this.dtR.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.3
                    @Override // com.baidu.tbadk.widget.largeImage.logic.a
                    public void onLoadFinished() {
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.duv = null;
                    }
                });
            } else {
                this.mProgressBar.setVisibility(8);
                this.duv = null;
            }
            this.dtR.setImageUrlData(this.dri);
            this.dtR.setImageData(rawBitmap, aVar.getByteData());
            aNj();
        }
        aNa();
    }

    private void aNe() {
        if (!this.dtW) {
            this.dtR.setDefaultBitmap();
        } else {
            this.dtX = false;
        }
        this.duv = null;
        this.mProgressBar.setVisibility(8);
    }

    public void setGifMaxUseableMem(int i) {
        this.dtR.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.dtR != null) {
            this.dtR.onDestroy();
        }
        if (this.dtT != null) {
            this.dtT.recycle();
        }
        if (this.dub != null) {
            this.dub.recycle();
            this.dub = null;
        }
        if (this.mProgressBar != null) {
            this.duv = null;
            this.mProgressBar.setVisibility(8);
        }
        e.gx().removeCallbacks(this.duz);
        com.baidu.tieba.view.c.cTP().setColor(-1);
    }

    public void release() {
        if (this.dtR != null) {
            this.dtR.release();
        }
        if (this.mProgressBar != null) {
            this.duv = null;
            this.mProgressBar.setVisibility(8);
        }
        this.duv = null;
    }

    public void aNf() {
        if (this.dtR != null && this.dtR.getImageType() == 1) {
            this.dtR.stop();
        }
    }

    public void y(boolean z, boolean z2) {
        String str;
        if (this.dtR != null && (str = (String) this.dtR.getTag()) != null) {
            if (this.dtR.getImageType() == 1) {
                if (this.dtR.getGifCache() == null || !this.dtR.isLoadBigImage()) {
                    e(str, z, z2);
                }
            } else if (this.dtR.getImageType() == 2) {
                e(str, z, z2);
            } else if (aNg()) {
                e(str, z, z2);
            }
        }
    }

    private boolean aNg() {
        if (this.dtR.getImageBitmap() != null && this.dtR.isLoadBigImage()) {
            if (this.dri == null || !this.dri.isLongPic || this.dtR.hasLoadLongImage()) {
                return false;
            }
            this.dtX = false;
            this.duo = false;
            return true;
        }
        return true;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.dri = imageUrlData;
    }

    public ImageUrlData getmAssistUrlData() {
        return this.dri;
    }

    public void setIsCdn(boolean z) {
        this.dsw = z;
    }

    public void aNh() {
        final String nameMd5FromUrl = as.getNameMd5FromUrl(this.dri.originalUrl);
        if (this.dri.originalProcess >= 0) {
            com.baidu.tbadk.download.d.aOu().cancelDownLoadById(nameMd5FromUrl, 13);
            this.dri.originalProcess = -1;
            aNj();
            return;
        }
        if (this.dso != null) {
            this.dso.aNm();
        }
        com.baidu.adp.base.e<?> ab = i.ab(this.mContext);
        if (ab == null) {
            uI(nameMd5FromUrl);
        } else if (!j.isNetWorkAvailable() || j.isWifiNet() || com.baidu.tbadk.core.sharedPref.b.aFH().getBoolean(SharedPrefConfig.ORIGINAL_IMG_DOWN_TIP, false)) {
            uI(nameMd5FromUrl);
        } else {
            com.baidu.tbadk.core.sharedPref.b.aFH().putBoolean(SharedPrefConfig.ORIGINAL_IMG_DOWN_TIP, true);
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(ab.getPageActivity());
            aVar.jW(R.string.original_img_down_no_wifi_tip);
            aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    UrlDragImageView.this.uI(nameMd5FromUrl);
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                }
            });
            aVar.b(ab);
            aVar.aEG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uI(String str) {
        if (this.dri != null) {
            this.dri.originalProcess = 0;
            this.duw.setProgress(0);
            this.duw.setVisibility(0);
            DownloadData downloadData = new DownloadData(str);
            downloadData.setStatus(1);
            downloadData.setUrl(this.dri.originalUrl);
            downloadData.setType(13);
            downloadData.setPath(this.duh + ap.aGE().tw(str) + "/" + str);
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.6
                @Override // com.baidu.tbadk.download.c
                public boolean onPreDownload(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2 != null) {
                        if (UrlDragImageView.this.dri != null && UrlDragImageView.this.dri.originalProcess != -1) {
                            UrlDragImageView.this.dri.originalProcess = downloadData2.getProcess();
                        }
                        if (UrlDragImageView.this.dri == null || UrlDragImageView.this.dri.originalProcess != -1) {
                            UrlDragImageView.this.duw.setProgress(downloadData2.getProcess());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public boolean onFileDownloaded(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadSucceed(DownloadData downloadData2) {
                    UrlDragImageView.this.duw.setVisibility(8);
                    e.gx().postDelayed(UrlDragImageView.this.duA, 1500L);
                    UrlDragImageView.this.duo = false;
                    UrlDragImageView.this.dun = UrlDragImageView.this.aNi();
                    UrlDragImageView.this.aNd();
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str2) {
                    UrlDragImageView.this.duw.setVisibility(8);
                    UrlDragImageView.this.duo = false;
                    BdToast.b(UrlDragImageView.this.mContext, str2).aEK().aEL();
                    UrlDragImageView.this.dri.originalProcess = -1;
                    UrlDragImageView.this.aNj();
                }
            });
            com.baidu.tbadk.download.d.aOu().a(downloadData, 100);
            this.dux = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aNi() {
        if (this.dri != null && !StringUtils.isNull(this.dri.originalUrl, true) && this.dri.originalSize >= 0 && !this.dri.isBlockedPic) {
            String nameMd5FromUrl = as.getNameMd5FromUrl(this.dri.originalUrl);
            File file = new File(this.duh + ap.aGE().tw(nameMd5FromUrl) + "/" + nameMd5FromUrl);
            if (file != null && file.exists()) {
                this.dri.originalProcess = 100;
                return true;
            }
            if (this.dri.originalProcess < 0) {
                aNj();
            } else {
                this.duw.setProgress(this.dri.originalProcess);
            }
            this.duq = true;
        } else {
            this.duv = null;
        }
        return false;
    }

    public void aNj() {
        if (this.dri != null) {
            if (!aNk() || !this.duq) {
                this.duv = null;
            } else if (this.dri.originalSize > 0 && !bH(this.dri.originalSize)) {
                this.duv = dtP + "(" + aq.getFormatSize(this.dri.originalSize) + ")";
            } else {
                this.duv = dtP;
            }
        }
    }

    private boolean aNk() {
        return (this.dri == null || !this.dri.mIsShowOrigonButton || this.dri.isBlockedPic || StringUtils.isNull(this.dri.originalUrl)) ? false : true;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.dso = bVar;
    }

    private boolean bH(long j) {
        return j > dtQ;
    }
}
