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
/* loaded from: classes21.dex */
public class UrlDragImageView extends RelativeLayout {
    private ImageUrlData foq;
    private b fpm;
    private boolean fpu;
    private boolean fpw;
    protected DragImageView fqQ;
    protected TextView fqR;
    protected SubsamplingScaleImageView fqS;
    private SubsamplingScaleImageView.OnImageEventListener fqT;
    private a fqU;
    private boolean fqV;
    private boolean fqW;
    private boolean fqX;
    private boolean fqY;
    private boolean fqZ;
    private Runnable frA;
    private Runnable frB;
    private View.OnTouchListener frC;
    private Bitmap fra;
    private RectF frb;
    private Rect frd;
    private Rect fre;
    private Rect frf;
    private DragImageView.d frg;
    private String frh;
    private float fri;
    private float frj;
    private float frk;
    private float frl;
    private float frm;
    private boolean frn;
    private boolean fro;
    private boolean frp;
    public boolean frq;
    private com.baidu.tbadk.img.b frr;
    private View.OnTouchListener frt;
    private boolean fru;
    private float frv;
    private String frw;
    private CircleProgressView frx;
    private boolean fry;
    private boolean frz;
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
    private static final String fqO = TbadkCoreApplication.getInst().getString(R.string.original_img_look);
    private static long fqP = Config.RAVEN_LOG_LIMIT;
    private static final int EXIT_DISTANCE = l.getEquipmentHeight(TbadkCoreApplication.getInst()) / 5;
    private static final String TAG = UrlDragImageView.class.getSimpleName();
    private static final int TOUCH_SLOP = ViewConfiguration.get(TbadkCoreApplication.getInst()).getScaledTouchSlop();

    /* loaded from: classes21.dex */
    public interface a {
        void k(String str, byte[] bArr);
    }

    /* loaded from: classes21.dex */
    public interface b {
        void bBb();
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
        if (this.fqQ != null) {
            this.fqQ.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.fqU = aVar;
    }

    public UrlDragImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.fqQ = null;
        this.fqU = null;
        this.fpu = false;
        this.fqX = false;
        this.isInDragScaleMode = false;
        this.mRatio = 1.0f;
        this.mMoveDistance = 0.0f;
        this.mDragMatrix = new Matrix();
        this.mDstRect = new RectF();
        this.fri = 0.0f;
        this.frj = 0.0f;
        this.frk = 1.0f;
        this.frl = 1.0f;
        this.frm = 0.0f;
        this.frn = false;
        this.fro = false;
        this.frp = false;
        this.frq = false;
        this.fru = true;
        this.frv = 0.0f;
        this.mOnClickListener = null;
        this.mLongClickListener = null;
        this.frw = null;
        this.frA = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.fru = true;
            }
        };
        this.frB = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.frx.setVisibility(8);
                        UrlDragImageView.this.frw = null;
                        UrlDragImageView.this.frq = false;
                    }
                });
            }
        };
        this.frC = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.frt != null) {
                    UrlDragImageView.this.frt.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.frr = new com.baidu.tbadk.img.b();
        init();
    }

    public UrlDragImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.fqQ = null;
        this.fqU = null;
        this.fpu = false;
        this.fqX = false;
        this.isInDragScaleMode = false;
        this.mRatio = 1.0f;
        this.mMoveDistance = 0.0f;
        this.mDragMatrix = new Matrix();
        this.mDstRect = new RectF();
        this.fri = 0.0f;
        this.frj = 0.0f;
        this.frk = 1.0f;
        this.frl = 1.0f;
        this.frm = 0.0f;
        this.frn = false;
        this.fro = false;
        this.frp = false;
        this.frq = false;
        this.fru = true;
        this.frv = 0.0f;
        this.mOnClickListener = null;
        this.mLongClickListener = null;
        this.frw = null;
        this.frA = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.fru = true;
            }
        };
        this.frB = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.frx.setVisibility(8);
                        UrlDragImageView.this.frw = null;
                        UrlDragImageView.this.frq = false;
                    }
                });
            }
        };
        this.frC = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.frt != null) {
                    UrlDragImageView.this.frt.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.frr = new com.baidu.tbadk.img.b();
        init();
    }

    public DragImageView getImageView() {
        return this.fqQ;
    }

    public void setGifSetListener(DragImageView.e eVar) {
        this.fqQ.setGifSetListener(eVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.fqQ.setImageOnClickListener(onClickListener);
        this.fqS.setOnClickListener(onClickListener);
        this.mOnClickListener = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mLongClickListener = onLongClickListener;
        if (!this.fpw) {
            this.fqQ.setImageOnLongClickListener(this.mLongClickListener);
            this.fqS.setOnLongClickListener(this.mLongClickListener);
        }
    }

    public void setOnSizeChangedListener(final DragImageView.g gVar) {
        this.fqQ.setOnSizeChangedListener(new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.8
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (gVar != null) {
                    gVar.a(dragImageView, z, z2);
                }
                UrlDragImageView.this.bAP();
            }
        });
    }

    protected void init() {
        this.frh = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        this.mMaxWidth = l.getEquipmentWidth(this.mContext);
        this.mMaxHeight = l.getEquipmentHeight(this.mContext) - ((int) this.mContext.getResources().getDimension(R.dimen.ds166));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.fqQ = new DragImageView(this.mContext);
        this.fqQ.setLayoutParams(layoutParams);
        this.fqQ.setOnTouchListener(this.frC);
        addView(this.fqQ);
        this.fqS = new SubsamplingScaleImageView(this.mContext);
        this.fqS.setMaxScale(50.0f);
        this.fqS.setOnTouchListener(this.frC);
        this.fqS.setVisibility(4);
        addView(this.fqS, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(getResources().getDrawable(R.drawable.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        bAO();
        this.frz = TbSingleton.getInstance().isCutoutScreen(TbadkApplication.getInst().getCurrentActivity());
    }

    private void bAO() {
        this.frx = new CircleProgressView(this.mContext);
        this.frx.setCircleBackgroundColor(ap.getColor(R.color.CAM_X0109));
        this.frx.setCircleForegroundColor(ap.getColor(R.color.CAM_X0302));
        this.frx.setProgress(0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds80), l.getDimens(getContext(), R.dimen.tbds80));
        layoutParams.addRule(13);
        this.frx.setVisibility(8);
        addView(this.frx, layoutParams);
    }

    public void setIsCanDrag(boolean z) {
        this.fpw = z;
    }

    public String getmCheckOriginPicText() {
        return this.frw;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        Bitmap imageBitmap;
        int height;
        int width;
        if (this.frn && !this.fry && this.fqS.getVisibility() == 0 && !this.fqS.isImageLoaded()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.fpw || !this.fqW) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.fqY && motionEvent.getPointerCount() >= 2) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.fqY || this.fqZ) {
            requestDisallowInterceptTouchEvent(true);
        }
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        float x = motionEvent.getX();
        int i = action & 255;
        if (i == 0) {
            if (this.fra == null) {
                if (this.fqS.getVisibility() == 0) {
                    this.fra = h.bQ(this.fqS);
                } else {
                    this.fra = h.bQ(this.fqQ);
                }
            }
            if (this.mDisplayRect == null && this.fra != null) {
                int measuredWidth = getMeasuredWidth();
                float measuredWidth2 = ((getMeasuredWidth() * 1.0f) / this.fra.getWidth()) * this.fra.getHeight();
                if (measuredWidth2 > getMeasuredHeight()) {
                    measuredWidth2 = getMeasuredHeight();
                }
                RectF rectInScreenFromPosition = getRectInScreenFromPosition(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
                this.mDisplayRect = new Rect((int) rectInScreenFromPosition.left, (int) rectInScreenFromPosition.top, (int) rectInScreenFromPosition.right, (int) rectInScreenFromPosition.bottom);
            }
            if (this.fre == null && this.fra != null) {
                if (this.fqS.getVisibility() == 0) {
                    height = this.fqS.getSHeight();
                    width = this.fqS.getSWidth();
                } else {
                    if (this.fqQ.getImageType() == 1) {
                        imageBitmap = (this.fqQ.getCurrentFrame() == null || this.fqQ.getCurrentFrame().bm == null) ? this.fra : this.fqQ.getCurrentFrame().bm;
                    } else {
                        imageBitmap = this.fqQ.getImageBitmap() == null ? this.fra : this.fqQ.getImageBitmap();
                    }
                    height = imageBitmap.getHeight();
                    width = imageBitmap.getWidth();
                }
                float equipmentDensity = l.getEquipmentDensity(getContext());
                int i2 = (int) (height * equipmentDensity);
                int i3 = (int) (width * equipmentDensity);
                if (i3 > this.fra.getWidth() && this.fra.getWidth() != 0) {
                    float width2 = (i3 * 1.0f) / this.fra.getWidth();
                    i3 = this.fra.getWidth();
                    i2 = (int) (i2 / width2);
                }
                if (i2 > this.fra.getHeight() && this.fra.getHeight() != 0) {
                    i3 = (int) (i3 / ((i2 * 1.0f) / this.fra.getHeight()));
                    i2 = this.fra.getHeight();
                }
                int equipmentHeight = (l.getEquipmentHeight(getContext()) - i2) / 2;
                int equipmentWidth = (l.getEquipmentWidth(getContext()) - i3) / 2;
                this.fre = new Rect(equipmentWidth, equipmentHeight, i3 + equipmentWidth, i2 + equipmentHeight);
                this.frf = new Rect(this.fre);
                this.frm = equipmentHeight / l.getEquipmentHeight(getContext());
                this.frd = new Rect(0, 0, this.fra.getWidth(), this.fra.getHeight());
            }
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (i == 2) {
            this.fqY = w(this.mLastMotionX - x, this.mLastMotionY - y);
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (this.fqY || this.fqZ) {
            this.fqQ.setImageOnLongClickListener(null);
            this.fqS.setOnLongClickListener(null);
            z = true;
        } else {
            this.fqQ.setImageOnLongClickListener(this.mLongClickListener);
            this.fqS.setOnLongClickListener(this.mLongClickListener);
            z = super.dispatchTouchEvent(motionEvent);
        }
        if (i == 1 || i == 3) {
            this.mLastMotionX = 0.0f;
            this.mLastMotionY = 0.0f;
            boolean z2 = (-this.mMoveDistance) > ((float) EXIT_DISTANCE);
            boolean z3 = this.mMoveDistance > ((float) EXIT_DISTANCE);
            if (z2 || z3) {
                this.fqZ = true;
                startExitAnimation();
                if (z2) {
                    TiebaStatic.log(new ar("c13377").dY("obj_type", "3"));
                } else if (z3) {
                    TiebaStatic.log(new ar("c13377").dY("obj_type", "2"));
                }
            } else {
                if (this.fqY && this.frg != null) {
                    this.frg.bHe();
                }
                this.mRatio = 1.0f;
                invalidate();
            }
            this.isInDragScaleMode = false;
            this.mDragMatrix.reset();
            this.fqY = false;
        }
        return z;
    }

    private boolean w(float f, float f2) {
        if (this.fqS.getVisibility() != 0 || this.fqS.isCanDrag()) {
            if (this.foq == null || !this.foq.isLongPic || this.fqS.getVisibility() != 0 || this.fqS.isViewTop()) {
                if (this.foq == null || !this.foq.isLongPic || this.fqS.getVisibility() == 0 || this.fqQ.isAtViewTop() || this.fqQ.bHc()) {
                    if (this.fqS.getVisibility() == 0 || this.fqQ.pagerCantScroll()) {
                        if (this.fra != null && getScrollY() == 0) {
                            boolean z = (this.foq == null || !this.foq.isLongPic) && ((f2 < -15.0f && !this.isInDragScaleMode) || (f2 > 15.0f && !this.isInDragScaleMode));
                            boolean z2 = this.foq != null && this.foq.isLongPic && f2 < 0.0f && !this.isInDragScaleMode;
                            if (z || (z2 && this.fqQ.isViewTop())) {
                                this.fqQ.setImageOnLongClickListener(null);
                                this.fqS.setOnLongClickListener(null);
                                this.isInDragScaleMode = true;
                                this.mMoveDistance = 0.0f;
                                this.mRatio = 1.0f;
                                if (this.frg != null) {
                                    this.frg.onDragStart();
                                }
                            }
                        }
                        if (!this.isInDragScaleMode || this.fra == null) {
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
                        this.mDragMatrix.preScale(1.0f + f3, 1.0f + f3, (this.mRatio * this.fra.getWidth()) / 2.0f, this.mRatio * (this.fra.getHeight() / 2));
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
        if (this.fqY && this.fra != null && !this.fra.isRecycled() && this.isInDragScaleMode) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.mDstRect == null) {
                this.mDstRect = new RectF();
            }
            this.mDragMatrix.mapRect(this.mDstRect, new RectF(this.mDisplayRect));
            canvas.drawBitmap(this.fra, this.frd, this.mDstRect, (Paint) null);
        } else if (this.fqZ && this.fra != null && !this.fra.isRecycled()) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.foq == null || this.foq.getSourceImageRectInScreen() == null) {
                canvas.drawBitmap(this.fra, this.frd, this.mDstRect, (Paint) null);
            } else {
                canvas.drawBitmap(this.fra, this.fre, this.mDstRect, (Paint) null);
            }
        } else {
            super.dispatchDraw(canvas);
        }
    }

    private void startExitAnimation() {
        if (this.foq == null) {
            if (this.frg != null) {
                this.frg.onDragEnd();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.foq.getSourceImageRectInScreen();
        final Rect dstRectInScreen = this.foq.getDstRectInScreen();
        if (sourceImageRectInScreen == null || dstRectInScreen == null) {
            if (this.frg != null) {
                this.frg.onDragEnd();
                return;
            }
            return;
        }
        a(sourceImageRectInScreen, dstRectInScreen);
        b(sourceImageRectInScreen);
        this.frb = new RectF(this.mDstRect);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(150L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && sourceImageRectInScreen != null && dstRectInScreen != null) {
                    UrlDragImageView.this.am(valueAnimator.getAnimatedFraction());
                    UrlDragImageView.this.a(dstRectInScreen, valueAnimator.getAnimatedFraction(), UrlDragImageView.this.frz);
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
                if (UrlDragImageView.this.frg != null) {
                    UrlDragImageView.this.frg.onDragEnd();
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
            this.mDstRect.top += this.mDstRect.height() * this.frm;
            this.mDstRect.bottom = f + this.mDstRect.top;
        }
    }

    public void setCanScale(boolean z) {
        if (this.fqQ != null) {
            this.fqQ.setCanScale(z);
        }
    }

    private void a(Rect rect, Rect rect2) {
        this.fri = 0.0f;
        this.frj = 0.0f;
        this.frk = 1.0f;
        this.frl = 1.0f;
        if (rect != null && rect2 != null && rect.contains(rect2)) {
            this.fri = (rect2.left - rect.left) / rect.width();
            this.frj = (rect2.top - rect.top) / rect.height();
            this.frk = (rect2.right - rect.left) / rect.width();
            this.frl = (rect2.bottom - rect.top) / rect.height();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void am(float f) {
        if (this.fre != null) {
            this.fre.left = (int) (this.frf.left + (this.frf.width() * this.fri * f));
            this.fre.top = (int) (this.frf.top + (this.frf.height() * this.frj * f));
            this.fre.right = (int) (this.frf.left + (this.frf.width() * (((1.0f - this.frk) * (1.0f - f)) + this.frk)));
            this.fre.bottom = (int) (this.frf.top + (this.frf.height() * (((1.0f - this.frl) * (1.0f - f)) + this.frl)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Rect rect, float f, boolean z) {
        int i = 0;
        if (z) {
            i = l.getDimens(getContext(), R.dimen.tbds80);
        }
        if (this.mDstRect != null && rect != null) {
            this.mDstRect.left = this.frb.left + ((rect.left - this.frb.left) * f);
            this.mDstRect.top = (this.frb.top + ((rect.top - this.frb.top) * f)) - i;
            this.mDstRect.right = this.frb.right + ((rect.right - this.frb.right) * f);
            this.mDstRect.bottom = this.frb.bottom + ((rect.bottom - this.frb.bottom) * f);
        }
    }

    private RectF getRectInScreenFromPosition(float f, float f2, float f3, float f4) {
        return new RectF(f - (f3 / 2.0f), f2 - (f4 / 2.0f), (f3 / 2.0f) + f, (f4 / 2.0f) + f2);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.frt = onTouchListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAP() {
        if ((this.fqV || this.fqW) && this.foq != null && this.foq.mPicType == 1 && !TextUtils.isEmpty(this.foq.mTagName)) {
            if (this.fqR != null) {
                this.fqR.setVisibility(8);
                this.fqR = null;
            }
            this.fqR = new TextView(this.mContext);
            this.fqR.setText(this.foq.mTagName);
            this.fqR.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize26));
            ap.setViewTextColor(this.fqR, R.color.common_color_10013, 1, 0);
            ap.setBackgroundColor(this.fqR, R.color.common_color_10215);
            this.fqR.setAlpha(0.75f);
            this.fqR.setIncludeFontPadding(false);
            this.fqR.setGravity(17);
            int dimens = l.getDimens(this.mContext, R.dimen.ds2);
            this.fqR.setPadding(dimens, dimens, dimens, dimens);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.fqQ.getBottomOffset();
            layoutParams.leftMargin = this.fqQ.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.fqR, layoutParams);
            this.fqR.setVisibility(0);
        }
    }

    public void setUrl(String str, boolean z) {
        if (str.contains("*")) {
            str = str.split("[*]")[0];
        }
        this.fqQ.setTag(str);
        this.fqQ.setLoadBigImage(false);
        this.fqQ.setImageDrawable(null);
        this.fqV = false;
        this.fqW = false;
        this.frn = bAX();
        this.frw = null;
        if (Dp(str)) {
            e(str, z, false);
        }
    }

    private boolean bAQ() {
        return this.fqQ != null && this.fqQ.isLoadBigImage();
    }

    public void bAR() {
        if (this.foq != null && !bAQ()) {
            String str = this.foq.imageUrl;
            int i = this.foq.urlType;
            com.baidu.adp.widget.ImageView.a aVar = null;
            if (com.baidu.tbadk.core.util.c.a.an(str, i)) {
                aVar = com.baidu.tbadk.core.util.c.a.ao(str, i);
            }
            if (aVar != null) {
                setThumbBitmapToView(aVar);
            }
        }
    }

    private boolean kh(boolean z) {
        String nameMd5FromUrl;
        if (!this.fro || z) {
            this.fro = true;
            if (!this.frn || this.foq == null || StringUtils.isNull(this.foq.originalUrl, true) || this.foq.originalSize < 0 || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String str = this.frh + at.btU().Ca(nameMd5FromUrl) + "/" + aw.getNameMd5FromUrl(this.foq.originalUrl);
            final int[] imageFileWH = n.getImageFileWH(str);
            this.fqS.setVisibility(0);
            if (this.fqT == null) {
                this.fqT = new SubsamplingScaleImageView.OnImageEventListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12
                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onReady() {
                        UrlDragImageView.this.frw = null;
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.fqQ.restoreSize();
                        UrlDragImageView.this.fqQ.setVisibility(4);
                    }

                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onImageLoaded() {
                        if (UrlDragImageView.this.foq.isLongPic && imageFileWH[0] > 0) {
                            UrlDragImageView.this.fqQ.onDestroy();
                            final float measuredWidth = (UrlDragImageView.this.getMeasuredWidth() * 1.0f) / imageFileWH[0];
                            final PointF pointF = new PointF((imageFileWH[0] * 1.0f) / 2.0f, 0.0f);
                            UrlDragImageView.this.fqS.setScaleAndCenter(measuredWidth, pointF);
                            UrlDragImageView.this.fqS.setMaxScale(2.0f * measuredWidth);
                            UrlDragImageView.this.fqS.setDoubleTapZoomScale(2.0f * measuredWidth);
                            UrlDragImageView.this.fqS.setInitScale(measuredWidth);
                            UrlDragImageView.this.fqS.setDoubleTapZoomStyle(4);
                            UrlDragImageView.this.fqS.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12.1
                                @Override // android.view.View.OnTouchListener
                                public boolean onTouch(View view, MotionEvent motionEvent) {
                                    if (UrlDragImageView.this.frt != null) {
                                        UrlDragImageView.this.frt.onTouch(view, motionEvent);
                                    }
                                    switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                                        case 0:
                                            UrlDragImageView.this.frv = motionEvent.getY();
                                            UrlDragImageView.this.fqS.setOnClickListener(UrlDragImageView.this.fru ? UrlDragImageView.this.mOnClickListener : null);
                                            UrlDragImageView.this.fqS.setOnLongClickListener(UrlDragImageView.this.fru ? UrlDragImageView.this.mLongClickListener : null);
                                            break;
                                        case 1:
                                        case 3:
                                            if (UrlDragImageView.this.fqS.getScale() < measuredWidth) {
                                                UrlDragImageView.this.fqS.setScaleAndCenter(measuredWidth, pointF);
                                            }
                                            e.mY().removeCallbacks(UrlDragImageView.this.frA);
                                            e.mY().postDelayed(UrlDragImageView.this.frA, 1000L);
                                            break;
                                        case 2:
                                            if (Math.abs(motionEvent.getY() - UrlDragImageView.this.frv) > UrlDragImageView.TOUCH_SLOP) {
                                                UrlDragImageView.this.fru = false;
                                                UrlDragImageView.this.fqS.setOnClickListener(null);
                                                UrlDragImageView.this.fqS.setOnLongClickListener(null);
                                            }
                                            UrlDragImageView.this.frv = motionEvent.getY();
                                            break;
                                    }
                                    return false;
                                }
                            });
                            UrlDragImageView.this.fqQ.setVisibility(4);
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
            this.fqS.setOnImageEventListener(this.fqT);
            if (this.fqS.isImageLoaded() && this.foq.isLongPic) {
                this.fqT.onImageLoaded();
            } else {
                this.fqS.setImage(ImageSource.uri(str));
            }
            return true;
        }
        return false;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.frg = dVar;
        if (this.fqQ != null) {
            this.fqQ.setDragToExitListener(dVar);
        }
    }

    public void bAS() {
        kh(false);
    }

    private boolean Dp(String str) {
        return j.isNetWorkAvailable() || com.baidu.tbadk.core.util.c.c.Co(str);
    }

    private void setThumbBitmapToView(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap rawBitmap;
        if (!this.fqW && aVar != null && (rawBitmap = aVar.getRawBitmap()) != null) {
            this.fqV = true;
            if (aVar.isGif()) {
                this.fqQ.setImageUrlData(this.foq);
                this.fqQ.setImageBitmap(rawBitmap);
                this.frw = null;
                this.frq = false;
            } else {
                if (this.foq != null && this.foq.isLongPic) {
                    this.fqQ.createLargeImageDelegate();
                    this.fqQ.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.13
                        @Override // com.baidu.tbadk.widget.largeImage.logic.a
                        public void onLoadFinished() {
                        }
                    });
                }
                this.fqQ.setImageUrlData(this.foq);
                this.fqQ.setImageData(rawBitmap, aVar.getByteData());
            }
            bAP();
        }
    }

    private void e(String str, boolean z, boolean z2) {
        if (Dq(str)) {
            if (z2 || (!this.fqX && !this.fqW)) {
                if (!z2 || !kh(true)) {
                    this.fqX = true;
                    com.baidu.adp.lib.e.c.mS().a(str, 27, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.14
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.b
                        public void onCancelled(String str2) {
                            UrlDragImageView.this.fqX = false;
                            UrlDragImageView.this.fqQ.setVisibility(0);
                            UrlDragImageView.this.mProgressBar.setVisibility(8);
                            UrlDragImageView.this.frw = null;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            UrlDragImageView.this.fqX = false;
                            UrlDragImageView.this.fqW = true;
                            UrlDragImageView.this.b(aVar);
                        }
                    }, 0, 0, false, null, Boolean.valueOf(z), this.fqQ.getImageData(), Boolean.valueOf(this.fpu));
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
        imageFileInfo.addPageAction(d.bi(this.mMaxWidth, this.mMaxHeight));
        com.baidu.adp.widget.ImageView.a a2 = this.frr.a(imageFileInfo, false);
        if (a2 != null) {
            this.fqW = true;
            this.mProgressBar.setVisibility(8);
            this.frw = null;
            b(a2);
            return;
        }
        this.frr.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.2
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.ImageView.a aVar, String str2, boolean z3) {
                UrlDragImageView.this.fqW = true;
                UrlDragImageView.this.mProgressBar.setVisibility(8);
                UrlDragImageView.this.frw = null;
                UrlDragImageView.this.b(aVar);
            }
        }, false);
    }

    private boolean Dq(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null && this.fqU != null) {
            this.fqU.k(aVar.getUrl(), aVar.getByteData());
        }
        if (aVar == null || aVar.getRawBitmap() == null) {
            bAT();
            return;
        }
        Bitmap rawBitmap = aVar.getRawBitmap();
        this.fqQ.setLoadBigImage(true);
        if (aVar.isGif()) {
            this.fqQ.setGifData(aVar.getByteData(), rawBitmap);
            this.fqQ.invalidate();
            this.fqQ.play();
            this.frq = false;
            this.frw = null;
            this.mProgressBar.setVisibility(8);
        } else {
            if (this.foq != null && this.foq.isLongPic) {
                this.fqQ.createLargeImageDelegate();
                this.fqQ.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.3
                    @Override // com.baidu.tbadk.widget.largeImage.logic.a
                    public void onLoadFinished() {
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.frw = null;
                    }
                });
            } else {
                this.mProgressBar.setVisibility(8);
                this.frw = null;
            }
            this.fqQ.setImageUrlData(this.foq);
            this.fqQ.setImageData(rawBitmap, aVar.getByteData());
            bAY();
        }
        bAP();
    }

    private void bAT() {
        if (!this.fqV) {
            this.fqQ.setDefaultBitmap();
        } else {
            this.fqW = false;
        }
        this.frw = null;
        this.mProgressBar.setVisibility(8);
    }

    public void setGifMaxUseableMem(int i) {
        this.fqQ.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.fqQ != null) {
            this.fqQ.onDestroy();
        }
        if (this.fqS != null) {
            this.fqS.recycle();
        }
        if (this.fra != null) {
            this.fra.recycle();
            this.fra = null;
        }
        if (this.mProgressBar != null) {
            this.frw = null;
            this.mProgressBar.setVisibility(8);
        }
        e.mY().removeCallbacks(this.frA);
        com.baidu.tieba.view.c.dXR().setColor(-1);
    }

    public void release() {
        if (this.fqQ != null) {
            this.fqQ.release();
        }
        if (this.mProgressBar != null) {
            this.frw = null;
            this.mProgressBar.setVisibility(8);
        }
        this.frw = null;
    }

    public void bAU() {
        if (this.fqQ != null && this.fqQ.getImageType() == 1) {
            this.fqQ.stop();
        }
    }

    public void E(boolean z, boolean z2) {
        String str;
        if (this.fqQ != null && (str = (String) this.fqQ.getTag()) != null) {
            if (this.fqQ.getImageType() == 1) {
                if (this.fqQ.getGifCache() == null || !this.fqQ.isLoadBigImage()) {
                    e(str, z, z2);
                }
            } else if (this.fqQ.getImageType() == 2) {
                e(str, z, z2);
            } else if (bAV()) {
                e(str, z, z2);
            }
        }
    }

    private boolean bAV() {
        if (this.fqQ.getImageBitmap() != null && this.fqQ.isLoadBigImage()) {
            if (this.foq == null || !this.foq.isLongPic || this.fqQ.hasLoadLongImage()) {
                return false;
            }
            this.fqW = false;
            this.fro = false;
            return true;
        }
        return true;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.foq = imageUrlData;
    }

    public ImageUrlData getmAssistUrlData() {
        return this.foq;
    }

    public void setIsCdn(boolean z) {
        this.fpu = z;
    }

    public void bAW() {
        final String nameMd5FromUrl = aw.getNameMd5FromUrl(this.foq.originalUrl);
        if (this.foq.originalProcess >= 0) {
            com.baidu.tbadk.download.d.bCj().cancelDownLoadById(nameMd5FromUrl, 13);
            this.foq.originalProcess = -1;
            bAY();
            return;
        }
        if (this.fpm != null) {
            this.fpm.bBb();
        }
        com.baidu.adp.base.e<?> J = i.J(this.mContext);
        if (J == null) {
            Dr(nameMd5FromUrl);
        } else if (!j.isNetWorkAvailable() || j.isWifiNet() || com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean(SharedPrefConfig.ORIGINAL_IMG_DOWN_TIP, false)) {
            Dr(nameMd5FromUrl);
        } else {
            com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean(SharedPrefConfig.ORIGINAL_IMG_DOWN_TIP, true);
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(J.getPageActivity());
            aVar.oQ(R.string.original_img_down_no_wifi_tip);
            aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    UrlDragImageView.this.Dr(nameMd5FromUrl);
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                }
            });
            aVar.b(J);
            aVar.brv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dr(String str) {
        if (this.foq != null) {
            this.foq.originalProcess = 0;
            this.frx.setProgress(0);
            this.frx.setVisibility(0);
            DownloadData downloadData = new DownloadData(str);
            downloadData.setStatus(1);
            downloadData.setUrl(this.foq.originalUrl);
            downloadData.setType(13);
            downloadData.setPath(this.frh + at.btU().Ca(str) + "/" + str);
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.6
                @Override // com.baidu.tbadk.download.c
                public boolean onPreDownload(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2 != null) {
                        if (UrlDragImageView.this.foq != null && UrlDragImageView.this.foq.originalProcess != -1) {
                            UrlDragImageView.this.foq.originalProcess = downloadData2.getProcess();
                        }
                        if (UrlDragImageView.this.foq == null || UrlDragImageView.this.foq.originalProcess != -1) {
                            UrlDragImageView.this.frx.setProgress(downloadData2.getProcess());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public boolean onFileDownloaded(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadSucceed(DownloadData downloadData2) {
                    UrlDragImageView.this.frx.setVisibility(8);
                    e.mY().postDelayed(UrlDragImageView.this.frB, 1500L);
                    UrlDragImageView.this.fro = false;
                    UrlDragImageView.this.frn = UrlDragImageView.this.bAX();
                    UrlDragImageView.this.bAS();
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str2) {
                    UrlDragImageView.this.frx.setVisibility(8);
                    UrlDragImageView.this.fro = false;
                    BdToast.b(UrlDragImageView.this.mContext, str2).brA().brB();
                    UrlDragImageView.this.foq.originalProcess = -1;
                    UrlDragImageView.this.bAY();
                }
            });
            com.baidu.tbadk.download.d.bCj().a(downloadData, 100);
            this.fry = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bAX() {
        if (this.foq != null && !StringUtils.isNull(this.foq.originalUrl, true) && this.foq.originalSize >= 0 && !this.foq.isBlockedPic) {
            String nameMd5FromUrl = aw.getNameMd5FromUrl(this.foq.originalUrl);
            File file = new File(this.frh + at.btU().Ca(nameMd5FromUrl) + "/" + nameMd5FromUrl);
            if (file != null && file.exists()) {
                this.foq.originalProcess = 100;
                return true;
            }
            if (this.foq.originalProcess < 0) {
                bAY();
            } else {
                this.frx.setProgress(this.foq.originalProcess);
            }
            this.frq = true;
        } else {
            this.frw = null;
        }
        return false;
    }

    public void bAY() {
        if (this.foq != null) {
            if (!bAZ() || !this.frq) {
                this.frw = null;
            } else if (this.foq.originalSize > 0 && !ed(this.foq.originalSize)) {
                this.frw = fqO + "(" + au.getFormatSize(this.foq.originalSize) + ")";
            } else {
                this.frw = fqO;
            }
        }
    }

    private boolean bAZ() {
        return (this.foq == null || !this.foq.mIsShowOrigonButton || this.foq.isBlockedPic || StringUtils.isNull(this.foq.originalUrl)) ? false : true;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.fpm = bVar;
    }

    private boolean ed(long j) {
        return j > fqP;
    }
}
