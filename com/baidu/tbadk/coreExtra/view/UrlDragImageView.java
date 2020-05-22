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
    private ImageUrlData efD;
    private b egB;
    private boolean egI;
    private boolean egK;
    private com.baidu.tbadk.img.b eiA;
    private View.OnTouchListener eiB;
    private boolean eiC;
    private float eiD;
    private String eiE;
    private CircleProgressView eiF;
    private boolean eiG;
    private boolean eiH;
    private Runnable eiI;
    private Runnable eiJ;
    private View.OnTouchListener eiK;
    protected DragImageView eia;
    protected TextView eib;
    protected SubsamplingScaleImageView eic;
    private SubsamplingScaleImageView.OnImageEventListener eid;
    private a eie;
    private boolean eif;
    private boolean eig;
    private boolean eih;
    private boolean eii;
    private boolean eij;
    private Bitmap eik;
    private RectF eil;
    private Rect eim;
    private Rect ein;
    private Rect eio;
    private DragImageView.d eip;
    private String eiq;
    private float eir;
    private float eis;
    private float eit;
    private float eiu;
    private float eiv;
    private boolean eiw;
    private boolean eix;
    private boolean eiy;
    public boolean eiz;
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
    private static final String ehY = TbadkCoreApplication.getInst().getString(R.string.original_img_look);
    private static long ehZ = Config.RAVEN_LOG_LIMIT;
    private static final int EXIT_DISTANCE = l.getEquipmentHeight(TbadkCoreApplication.getInst()) / 5;
    private static final String TAG = UrlDragImageView.class.getSimpleName();
    private static final int TOUCH_SLOP = ViewConfiguration.get(TbadkCoreApplication.getInst()).getScaledTouchSlop();

    /* loaded from: classes8.dex */
    public interface a {
        void k(String str, byte[] bArr);
    }

    /* loaded from: classes8.dex */
    public interface b {
        void bbQ();
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
        if (this.eia != null) {
            this.eia.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.eie = aVar;
    }

    public UrlDragImageView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.eia = null;
        this.eie = null;
        this.egI = false;
        this.eih = false;
        this.isInDragScaleMode = false;
        this.mRatio = 1.0f;
        this.mMoveDistance = 0.0f;
        this.mDragMatrix = new Matrix();
        this.mDstRect = new RectF();
        this.eir = 0.0f;
        this.eis = 0.0f;
        this.eit = 1.0f;
        this.eiu = 1.0f;
        this.eiv = 0.0f;
        this.eiw = false;
        this.eix = false;
        this.eiy = false;
        this.eiz = false;
        this.eiC = true;
        this.eiD = 0.0f;
        this.mOnClickListener = null;
        this.mLongClickListener = null;
        this.eiE = null;
        this.eiI = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.eiC = true;
            }
        };
        this.eiJ = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.eiF.setVisibility(8);
                        UrlDragImageView.this.eiE = null;
                        UrlDragImageView.this.eiz = false;
                    }
                });
            }
        };
        this.eiK = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.eiB != null) {
                    UrlDragImageView.this.eiB.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.eiA = new com.baidu.tbadk.img.b();
        init();
    }

    public UrlDragImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.eia = null;
        this.eie = null;
        this.egI = false;
        this.eih = false;
        this.isInDragScaleMode = false;
        this.mRatio = 1.0f;
        this.mMoveDistance = 0.0f;
        this.mDragMatrix = new Matrix();
        this.mDstRect = new RectF();
        this.eir = 0.0f;
        this.eis = 0.0f;
        this.eit = 1.0f;
        this.eiu = 1.0f;
        this.eiv = 0.0f;
        this.eiw = false;
        this.eix = false;
        this.eiy = false;
        this.eiz = false;
        this.eiC = true;
        this.eiD = 0.0f;
        this.mOnClickListener = null;
        this.mLongClickListener = null;
        this.eiE = null;
        this.eiI = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                UrlDragImageView.this.eiC = true;
            }
        };
        this.eiJ = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.7
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
                        UrlDragImageView.this.eiF.setVisibility(8);
                        UrlDragImageView.this.eiE = null;
                        UrlDragImageView.this.eiz = false;
                    }
                });
            }
        };
        this.eiK = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.eiB != null) {
                    UrlDragImageView.this.eiB.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.eiA = new com.baidu.tbadk.img.b();
        init();
    }

    public DragImageView getImageView() {
        return this.eia;
    }

    public void setGifSetListener(DragImageView.e eVar) {
        this.eia.setGifSetListener(eVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.eia.setImageOnClickListener(onClickListener);
        this.eic.setOnClickListener(onClickListener);
        this.mOnClickListener = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mLongClickListener = onLongClickListener;
        if (!this.egK) {
            this.eia.setImageOnLongClickListener(this.mLongClickListener);
            this.eic.setOnLongClickListener(this.mLongClickListener);
        }
    }

    public void setOnSizeChangedListener(final DragImageView.g gVar) {
        this.eia.setOnSizeChangedListener(new DragImageView.g() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.8
            @Override // com.baidu.tbadk.widget.DragImageView.g
            public void a(DragImageView dragImageView, boolean z, boolean z2) {
                if (gVar != null) {
                    gVar.a(dragImageView, z, z2);
                }
                UrlDragImageView.this.bbE();
            }
        });
    }

    protected void init() {
        this.eiq = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        this.mMaxWidth = l.getEquipmentWidth(this.mContext);
        this.mMaxHeight = l.getEquipmentHeight(this.mContext) - ((int) this.mContext.getResources().getDimension(R.dimen.ds166));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.eia = new DragImageView(this.mContext);
        this.eia.setLayoutParams(layoutParams);
        this.eia.setOnTouchListener(this.eiK);
        addView(this.eia);
        this.eic = new SubsamplingScaleImageView(this.mContext);
        this.eic.setMaxScale(50.0f);
        this.eic.setOnTouchListener(this.eiK);
        this.eic.setVisibility(4);
        addView(this.eic, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(getResources().getDrawable(R.drawable.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        bbD();
        this.eiH = TbSingleton.getInstance().isCutoutScreen(TbadkApplication.getInst().getCurrentActivity());
    }

    private void bbD() {
        this.eiF = new CircleProgressView(this.mContext);
        this.eiF.setCircleBackgroundColor(am.getColor(R.color.cp_cont_d));
        this.eiF.setCircleForegroundColor(am.getColor(R.color.cp_link_tip_a));
        this.eiF.setProgress(0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds80), l.getDimens(getContext(), R.dimen.tbds80));
        layoutParams.addRule(13);
        this.eiF.setVisibility(8);
        addView(this.eiF, layoutParams);
    }

    public void setIsCanDrag(boolean z) {
        this.egK = z;
    }

    public String getmCheckOriginPicText() {
        return this.eiE;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        Bitmap imageBitmap;
        int height;
        int width;
        if (this.eiw && !this.eiG && this.eic.getVisibility() == 0 && !this.eic.isImageLoaded()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.egK || !this.eig) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.eii && motionEvent.getPointerCount() >= 2) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.eii || this.eij) {
            requestDisallowInterceptTouchEvent(true);
        }
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        float x = motionEvent.getX();
        int i = action & 255;
        if (i == 0) {
            if (this.eik == null) {
                if (this.eic.getVisibility() == 0) {
                    this.eik = g.bk(this.eic);
                } else {
                    this.eik = g.bk(this.eia);
                }
            }
            if (this.mDisplayRect == null && this.eik != null) {
                int measuredWidth = getMeasuredWidth();
                float measuredWidth2 = ((getMeasuredWidth() * 1.0f) / this.eik.getWidth()) * this.eik.getHeight();
                if (measuredWidth2 > getMeasuredHeight()) {
                    measuredWidth2 = getMeasuredHeight();
                }
                RectF rectInScreenFromPosition = getRectInScreenFromPosition(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
                this.mDisplayRect = new Rect((int) rectInScreenFromPosition.left, (int) rectInScreenFromPosition.top, (int) rectInScreenFromPosition.right, (int) rectInScreenFromPosition.bottom);
            }
            if (this.ein == null && this.eik != null) {
                if (this.eic.getVisibility() == 0) {
                    height = this.eic.getSHeight();
                    width = this.eic.getSWidth();
                } else {
                    if (this.eia.getImageType() == 1) {
                        imageBitmap = (this.eia.getCurrentFrame() == null || this.eia.getCurrentFrame().bm == null) ? this.eik : this.eia.getCurrentFrame().bm;
                    } else {
                        imageBitmap = this.eia.getImageBitmap() == null ? this.eik : this.eia.getImageBitmap();
                    }
                    height = imageBitmap.getHeight();
                    width = imageBitmap.getWidth();
                }
                float equipmentDensity = l.getEquipmentDensity(getContext());
                int i2 = (int) (height * equipmentDensity);
                int i3 = (int) (width * equipmentDensity);
                if (i3 > this.eik.getWidth() && this.eik.getWidth() != 0) {
                    float width2 = (i3 * 1.0f) / this.eik.getWidth();
                    i3 = this.eik.getWidth();
                    i2 = (int) (i2 / width2);
                }
                if (i2 > this.eik.getHeight() && this.eik.getHeight() != 0) {
                    i3 = (int) (i3 / ((i2 * 1.0f) / this.eik.getHeight()));
                    i2 = this.eik.getHeight();
                }
                int equipmentHeight = (l.getEquipmentHeight(getContext()) - i2) / 2;
                int equipmentWidth = (l.getEquipmentWidth(getContext()) - i3) / 2;
                this.ein = new Rect(equipmentWidth, equipmentHeight, i3 + equipmentWidth, i2 + equipmentHeight);
                this.eio = new Rect(this.ein);
                this.eiv = equipmentHeight / l.getEquipmentHeight(getContext());
                this.eim = new Rect(0, 0, this.eik.getWidth(), this.eik.getHeight());
            }
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (i == 2) {
            this.eii = r(this.mLastMotionX - x, this.mLastMotionY - y);
            this.mLastMotionX = x;
            this.mLastMotionY = y;
        }
        if (this.eii || this.eij) {
            this.eia.setImageOnLongClickListener(null);
            this.eic.setOnLongClickListener(null);
            z = true;
        } else {
            this.eia.setImageOnLongClickListener(this.mLongClickListener);
            this.eic.setOnLongClickListener(this.mLongClickListener);
            z = super.dispatchTouchEvent(motionEvent);
        }
        if (i == 1 || i == 3) {
            this.mLastMotionX = 0.0f;
            this.mLastMotionY = 0.0f;
            boolean z2 = (-this.mMoveDistance) > ((float) EXIT_DISTANCE);
            boolean z3 = this.mMoveDistance > ((float) EXIT_DISTANCE);
            if (z2 || z3) {
                this.eij = true;
                startExitAnimation();
                if (z2) {
                    TiebaStatic.log(new an("c13377").dh("obj_type", "3"));
                } else if (z3) {
                    TiebaStatic.log(new an("c13377").dh("obj_type", "2"));
                }
            } else {
                if (this.eii && this.eip != null) {
                    this.eip.bhc();
                }
                this.mRatio = 1.0f;
                invalidate();
            }
            this.isInDragScaleMode = false;
            this.mDragMatrix.reset();
            this.eii = false;
        }
        return z;
    }

    private boolean r(float f, float f2) {
        if (this.eic.getVisibility() != 0 || this.eic.isCanDrag()) {
            if (this.efD == null || !this.efD.isLongPic || this.eic.getVisibility() != 0 || this.eic.isViewTop()) {
                if (this.efD == null || !this.efD.isLongPic || this.eic.getVisibility() == 0 || this.eia.isAtViewTop() || this.eia.bha()) {
                    if (this.eic.getVisibility() == 0 || this.eia.pagerCantScroll()) {
                        if (this.eik != null && getScrollY() == 0) {
                            boolean z = (this.efD == null || !this.efD.isLongPic) && ((f2 < -15.0f && !this.isInDragScaleMode) || (f2 > 15.0f && !this.isInDragScaleMode));
                            boolean z2 = this.efD != null && this.efD.isLongPic && f2 < 0.0f && !this.isInDragScaleMode;
                            if (z || (z2 && this.eia.isViewTop())) {
                                this.eia.setImageOnLongClickListener(null);
                                this.eic.setOnLongClickListener(null);
                                this.isInDragScaleMode = true;
                                this.mMoveDistance = 0.0f;
                                this.mRatio = 1.0f;
                                if (this.eip != null) {
                                    this.eip.onDragStart();
                                }
                            }
                        }
                        if (!this.isInDragScaleMode || this.eik == null) {
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
                        this.mDragMatrix.preScale(1.0f + f3, 1.0f + f3, (this.mRatio * this.eik.getWidth()) / 2.0f, this.mRatio * (this.eik.getHeight() / 2));
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
        if (this.eii && this.eik != null && !this.eik.isRecycled() && this.isInDragScaleMode) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.mDstRect == null) {
                this.mDstRect = new RectF();
            }
            this.mDragMatrix.mapRect(this.mDstRect, new RectF(this.mDisplayRect));
            canvas.drawBitmap(this.eik, this.eim, this.mDstRect, (Paint) null);
        } else if (this.eij && this.eik != null && !this.eik.isRecycled()) {
            canvas.drawColor(Color.argb((int) (this.mRatio * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
            if (this.efD == null || this.efD.getSourceImageRectInScreen() == null) {
                canvas.drawBitmap(this.eik, this.eim, this.mDstRect, (Paint) null);
            } else {
                canvas.drawBitmap(this.eik, this.ein, this.mDstRect, (Paint) null);
            }
        } else {
            super.dispatchDraw(canvas);
        }
    }

    private void startExitAnimation() {
        if (this.efD == null) {
            if (this.eip != null) {
                this.eip.onDragEnd();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.efD.getSourceImageRectInScreen();
        final Rect dstRectInScreen = this.efD.getDstRectInScreen();
        if (sourceImageRectInScreen == null || dstRectInScreen == null) {
            if (this.eip != null) {
                this.eip.onDragEnd();
                return;
            }
            return;
        }
        b(sourceImageRectInScreen, dstRectInScreen);
        b(sourceImageRectInScreen);
        this.eil = new RectF(this.mDstRect);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(150L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && sourceImageRectInScreen != null && dstRectInScreen != null) {
                    UrlDragImageView.this.Y(valueAnimator.getAnimatedFraction());
                    UrlDragImageView.this.a(dstRectInScreen, valueAnimator.getAnimatedFraction(), UrlDragImageView.this.eiH);
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
                if (UrlDragImageView.this.eip != null) {
                    UrlDragImageView.this.eip.onDragEnd();
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
            this.mDstRect.top += this.mDstRect.height() * this.eiv;
            this.mDstRect.bottom = f + this.mDstRect.top;
        }
    }

    public void setCanScale(boolean z) {
        if (this.eia != null) {
            this.eia.setCanScale(z);
        }
    }

    private void b(Rect rect, Rect rect2) {
        this.eir = 0.0f;
        this.eis = 0.0f;
        this.eit = 1.0f;
        this.eiu = 1.0f;
        if (rect != null && rect2 != null && rect.contains(rect2)) {
            this.eir = (rect2.left - rect.left) / rect.width();
            this.eis = (rect2.top - rect.top) / rect.height();
            this.eit = (rect2.right - rect.left) / rect.width();
            this.eiu = (rect2.bottom - rect.top) / rect.height();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(float f) {
        if (this.ein != null) {
            this.ein.left = (int) (this.eio.left + (this.eio.width() * this.eir * f));
            this.ein.top = (int) (this.eio.top + (this.eio.height() * this.eis * f));
            this.ein.right = (int) (this.eio.left + (this.eio.width() * (((1.0f - this.eit) * (1.0f - f)) + this.eit)));
            this.ein.bottom = (int) (this.eio.top + (this.eio.height() * (((1.0f - this.eiu) * (1.0f - f)) + this.eiu)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Rect rect, float f, boolean z) {
        int i = 0;
        if (z) {
            i = l.getDimens(getContext(), R.dimen.tbds80);
        }
        if (this.mDstRect != null && rect != null) {
            this.mDstRect.left = this.eil.left + ((rect.left - this.eil.left) * f);
            this.mDstRect.top = (this.eil.top + ((rect.top - this.eil.top) * f)) - i;
            this.mDstRect.right = this.eil.right + ((rect.right - this.eil.right) * f);
            this.mDstRect.bottom = this.eil.bottom + ((rect.bottom - this.eil.bottom) * f);
        }
    }

    private RectF getRectInScreenFromPosition(float f, float f2, float f3, float f4) {
        return new RectF(f - (f3 / 2.0f), f2 - (f4 / 2.0f), (f3 / 2.0f) + f, (f4 / 2.0f) + f2);
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.eiB = onTouchListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbE() {
        if ((this.eif || this.eig) && this.efD != null && this.efD.mPicType == 1 && !TextUtils.isEmpty(this.efD.mTagName)) {
            if (this.eib != null) {
                this.eib.setVisibility(8);
                this.eib = null;
            }
            this.eib = new TextView(this.mContext);
            this.eib.setText(this.efD.mTagName);
            this.eib.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize26));
            am.setViewTextColor(this.eib, R.color.common_color_10013, 1, 0);
            am.setBackgroundColor(this.eib, R.color.common_color_10215);
            this.eib.setAlpha(0.75f);
            this.eib.setIncludeFontPadding(false);
            this.eib.setGravity(17);
            int dimens = l.getDimens(this.mContext, R.dimen.ds2);
            this.eib.setPadding(dimens, dimens, dimens, dimens);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.eia.getBottomOffset();
            layoutParams.leftMargin = this.eia.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.eib, layoutParams);
            this.eib.setVisibility(0);
        }
    }

    public void setUrl(String str, boolean z) {
        if (str.contains("*")) {
            str = str.split("[*]")[0];
        }
        this.eia.setTag(str);
        this.eia.setLoadBigImage(false);
        this.eia.setImageDrawable(null);
        this.eif = false;
        this.eig = false;
        this.eiw = bbM();
        this.eiE = null;
        if (xD(str)) {
            e(str, z, false);
        }
    }

    private boolean bbF() {
        return this.eia != null && this.eia.isLoadBigImage();
    }

    public void bbG() {
        if (this.efD != null && !bbF()) {
            String str = this.efD.imageUrl;
            int i = this.efD.urlType;
            com.baidu.adp.widget.ImageView.a aVar = null;
            if (com.baidu.tbadk.core.util.c.a.ai(str, i)) {
                aVar = com.baidu.tbadk.core.util.c.a.aj(str, i);
            }
            if (aVar != null) {
                setThumbBitmapToView(aVar);
            }
        }
    }

    private boolean hM(boolean z) {
        String nameMd5FromUrl;
        if (!this.eix || z) {
            this.eix = true;
            if (!this.eiw || this.efD == null || StringUtils.isNull(this.efD.originalUrl, true) || this.efD.originalSize < 0 || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String str = this.eiq + ap.aUT().ws(nameMd5FromUrl) + "/" + as.getNameMd5FromUrl(this.efD.originalUrl);
            final int[] imageFileWH = m.getImageFileWH(str);
            this.eic.setVisibility(0);
            if (this.eid == null) {
                this.eid = new SubsamplingScaleImageView.OnImageEventListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12
                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onReady() {
                        UrlDragImageView.this.eiE = null;
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.eia.restoreSize();
                        UrlDragImageView.this.eia.setVisibility(4);
                    }

                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onImageLoaded() {
                        if (UrlDragImageView.this.efD.isLongPic && imageFileWH[0] > 0) {
                            UrlDragImageView.this.eia.onDestroy();
                            final float measuredWidth = (UrlDragImageView.this.getMeasuredWidth() * 1.0f) / imageFileWH[0];
                            final PointF pointF = new PointF((imageFileWH[0] * 1.0f) / 2.0f, 0.0f);
                            UrlDragImageView.this.eic.setScaleAndCenter(measuredWidth, pointF);
                            UrlDragImageView.this.eic.setMaxScale(2.0f * measuredWidth);
                            UrlDragImageView.this.eic.setDoubleTapZoomScale(2.0f * measuredWidth);
                            UrlDragImageView.this.eic.setInitScale(measuredWidth);
                            UrlDragImageView.this.eic.setDoubleTapZoomStyle(4);
                            UrlDragImageView.this.eic.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.12.1
                                @Override // android.view.View.OnTouchListener
                                public boolean onTouch(View view, MotionEvent motionEvent) {
                                    if (UrlDragImageView.this.eiB != null) {
                                        UrlDragImageView.this.eiB.onTouch(view, motionEvent);
                                    }
                                    switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                                        case 0:
                                            UrlDragImageView.this.eiD = motionEvent.getY();
                                            UrlDragImageView.this.eic.setOnClickListener(UrlDragImageView.this.eiC ? UrlDragImageView.this.mOnClickListener : null);
                                            UrlDragImageView.this.eic.setOnLongClickListener(UrlDragImageView.this.eiC ? UrlDragImageView.this.mLongClickListener : null);
                                            break;
                                        case 1:
                                        case 3:
                                            if (UrlDragImageView.this.eic.getScale() < measuredWidth) {
                                                UrlDragImageView.this.eic.setScaleAndCenter(measuredWidth, pointF);
                                            }
                                            e.ld().removeCallbacks(UrlDragImageView.this.eiI);
                                            e.ld().postDelayed(UrlDragImageView.this.eiI, 1000L);
                                            break;
                                        case 2:
                                            if (Math.abs(motionEvent.getY() - UrlDragImageView.this.eiD) > UrlDragImageView.TOUCH_SLOP) {
                                                UrlDragImageView.this.eiC = false;
                                                UrlDragImageView.this.eic.setOnClickListener(null);
                                                UrlDragImageView.this.eic.setOnLongClickListener(null);
                                            }
                                            UrlDragImageView.this.eiD = motionEvent.getY();
                                            break;
                                    }
                                    return false;
                                }
                            });
                            UrlDragImageView.this.eia.setVisibility(4);
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
            this.eic.setOnImageEventListener(this.eid);
            if (this.eic.isImageLoaded() && this.efD.isLongPic) {
                this.eid.onImageLoaded();
            } else {
                this.eic.setImage(ImageSource.uri(str));
            }
            return true;
        }
        return false;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.eip = dVar;
        if (this.eia != null) {
            this.eia.setDragToExitListener(dVar);
        }
    }

    public void bbH() {
        hM(false);
    }

    private boolean xD(String str) {
        return j.isNetWorkAvailable() || com.baidu.tbadk.core.util.c.c.wE(str);
    }

    private void setThumbBitmapToView(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap rawBitmap;
        if (!this.eig && aVar != null && (rawBitmap = aVar.getRawBitmap()) != null) {
            this.eif = true;
            if (aVar.isGif()) {
                this.eia.setImageUrlData(this.efD);
                this.eia.setImageBitmap(rawBitmap);
                this.eiE = null;
                this.eiz = false;
            } else {
                if (this.efD != null && this.efD.isLongPic) {
                    this.eia.createLargeImageDelegate();
                    this.eia.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.13
                        @Override // com.baidu.tbadk.widget.largeImage.logic.a
                        public void onLoadFinished() {
                        }
                    });
                }
                this.eia.setImageUrlData(this.efD);
                this.eia.setImageData(rawBitmap, aVar.getByteData());
            }
            bbE();
        }
    }

    private void e(String str, boolean z, boolean z2) {
        if (xE(str)) {
            if (z2 || (!this.eih && !this.eig)) {
                if (!z2 || !hM(true)) {
                    this.eih = true;
                    com.baidu.adp.lib.e.c.kX().a(str, 27, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.14
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.b
                        public void onCancelled(String str2) {
                            UrlDragImageView.this.eih = false;
                            UrlDragImageView.this.eia.setVisibility(0);
                            UrlDragImageView.this.mProgressBar.setVisibility(8);
                            UrlDragImageView.this.eiE = null;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            UrlDragImageView.this.eih = false;
                            UrlDragImageView.this.eig = true;
                            UrlDragImageView.this.b(aVar);
                        }
                    }, 0, 0, false, null, Boolean.valueOf(z), this.eia.getImageData(), Boolean.valueOf(this.egI));
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
        imageFileInfo.addPageAction(d.aS(this.mMaxWidth, this.mMaxHeight));
        com.baidu.adp.widget.ImageView.a a2 = this.eiA.a(imageFileInfo, false);
        if (a2 != null) {
            this.eig = true;
            this.mProgressBar.setVisibility(8);
            this.eiE = null;
            b(a2);
            return;
        }
        this.eiA.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.2
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.ImageView.a aVar, String str2, boolean z3) {
                UrlDragImageView.this.eig = true;
                UrlDragImageView.this.mProgressBar.setVisibility(8);
                UrlDragImageView.this.eiE = null;
                UrlDragImageView.this.b(aVar);
            }
        }, false);
    }

    private boolean xE(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null && this.eie != null) {
            this.eie.k(aVar.getUrl(), aVar.getByteData());
        }
        if (aVar == null || aVar.getRawBitmap() == null) {
            bbI();
            return;
        }
        Bitmap rawBitmap = aVar.getRawBitmap();
        this.eia.setLoadBigImage(true);
        if (aVar.isGif()) {
            this.eia.setGifData(aVar.getByteData(), rawBitmap);
            this.eia.invalidate();
            this.eia.play();
            this.eiz = false;
            this.eiE = null;
            this.mProgressBar.setVisibility(8);
        } else {
            if (this.efD != null && this.efD.isLongPic) {
                this.eia.createLargeImageDelegate();
                this.eia.setImageLoadCallBack(new com.baidu.tbadk.widget.largeImage.logic.a() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.3
                    @Override // com.baidu.tbadk.widget.largeImage.logic.a
                    public void onLoadFinished() {
                        UrlDragImageView.this.mProgressBar.setVisibility(8);
                        UrlDragImageView.this.eiE = null;
                    }
                });
            } else {
                this.mProgressBar.setVisibility(8);
                this.eiE = null;
            }
            this.eia.setImageUrlData(this.efD);
            this.eia.setImageData(rawBitmap, aVar.getByteData());
            bbN();
        }
        bbE();
    }

    private void bbI() {
        if (!this.eif) {
            this.eia.setDefaultBitmap();
        } else {
            this.eig = false;
        }
        this.eiE = null;
        this.mProgressBar.setVisibility(8);
    }

    public void setGifMaxUseableMem(int i) {
        this.eia.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.eia != null) {
            this.eia.onDestroy();
        }
        if (this.eic != null) {
            this.eic.recycle();
        }
        if (this.eik != null) {
            this.eik.recycle();
            this.eik = null;
        }
        if (this.mProgressBar != null) {
            this.eiE = null;
            this.mProgressBar.setVisibility(8);
        }
        e.ld().removeCallbacks(this.eiI);
        com.baidu.tieba.view.c.dlQ().setColor(-1);
    }

    public void release() {
        if (this.eia != null) {
            this.eia.release();
        }
        if (this.mProgressBar != null) {
            this.eiE = null;
            this.mProgressBar.setVisibility(8);
        }
        this.eiE = null;
    }

    public void bbJ() {
        if (this.eia != null && this.eia.getImageType() == 1) {
            this.eia.stop();
        }
    }

    public void A(boolean z, boolean z2) {
        String str;
        if (this.eia != null && (str = (String) this.eia.getTag()) != null) {
            if (this.eia.getImageType() == 1) {
                if (this.eia.getGifCache() == null || !this.eia.isLoadBigImage()) {
                    e(str, z, z2);
                }
            } else if (this.eia.getImageType() == 2) {
                e(str, z, z2);
            } else if (bbK()) {
                e(str, z, z2);
            }
        }
    }

    private boolean bbK() {
        if (this.eia.getImageBitmap() != null && this.eia.isLoadBigImage()) {
            if (this.efD == null || !this.efD.isLongPic || this.eia.hasLoadLongImage()) {
                return false;
            }
            this.eig = false;
            this.eix = false;
            return true;
        }
        return true;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.efD = imageUrlData;
    }

    public ImageUrlData getmAssistUrlData() {
        return this.efD;
    }

    public void setIsCdn(boolean z) {
        this.egI = z;
    }

    public void bbL() {
        final String nameMd5FromUrl = as.getNameMd5FromUrl(this.efD.originalUrl);
        if (this.efD.originalProcess >= 0) {
            com.baidu.tbadk.download.d.bcT().cancelDownLoadById(nameMd5FromUrl, 13);
            this.efD.originalProcess = -1;
            bbN();
            return;
        }
        if (this.egB != null) {
            this.egB.bbQ();
        }
        com.baidu.adp.base.e<?> G = i.G(this.mContext);
        if (G == null) {
            xF(nameMd5FromUrl);
        } else if (!j.isNetWorkAvailable() || j.isWifiNet() || com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(SharedPrefConfig.ORIGINAL_IMG_DOWN_TIP, false)) {
            xF(nameMd5FromUrl);
        } else {
            com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(SharedPrefConfig.ORIGINAL_IMG_DOWN_TIP, true);
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(G.getPageActivity());
            aVar.kD(R.string.original_img_down_no_wifi_tip);
            aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                    UrlDragImageView.this.xF(nameMd5FromUrl);
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                }
            });
            aVar.b(G);
            aVar.aST();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xF(String str) {
        if (this.efD != null) {
            this.efD.originalProcess = 0;
            this.eiF.setProgress(0);
            this.eiF.setVisibility(0);
            DownloadData downloadData = new DownloadData(str);
            downloadData.setStatus(1);
            downloadData.setUrl(this.efD.originalUrl);
            downloadData.setType(13);
            downloadData.setPath(this.eiq + ap.aUT().ws(str) + "/" + str);
            downloadData.setCallback(new com.baidu.tbadk.download.c() { // from class: com.baidu.tbadk.coreExtra.view.UrlDragImageView.6
                @Override // com.baidu.tbadk.download.c
                public boolean onPreDownload(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileUpdateProgress(DownloadData downloadData2) {
                    if (downloadData2 != null) {
                        if (UrlDragImageView.this.efD != null && UrlDragImageView.this.efD.originalProcess != -1) {
                            UrlDragImageView.this.efD.originalProcess = downloadData2.getProcess();
                        }
                        if (UrlDragImageView.this.efD == null || UrlDragImageView.this.efD.originalProcess != -1) {
                            UrlDragImageView.this.eiF.setProgress(downloadData2.getProcess());
                        }
                    }
                }

                @Override // com.baidu.tbadk.download.c
                public boolean onFileDownloaded(DownloadData downloadData2) {
                    return true;
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadSucceed(DownloadData downloadData2) {
                    UrlDragImageView.this.eiF.setVisibility(8);
                    e.ld().postDelayed(UrlDragImageView.this.eiJ, 1500L);
                    UrlDragImageView.this.eix = false;
                    UrlDragImageView.this.eiw = UrlDragImageView.this.bbM();
                    UrlDragImageView.this.bbH();
                }

                @Override // com.baidu.tbadk.download.c
                public void onFileDownloadFailed(DownloadData downloadData2, int i, String str2) {
                    UrlDragImageView.this.eiF.setVisibility(8);
                    UrlDragImageView.this.eix = false;
                    BdToast.b(UrlDragImageView.this.mContext, str2).aSX().aSY();
                    UrlDragImageView.this.efD.originalProcess = -1;
                    UrlDragImageView.this.bbN();
                }
            });
            com.baidu.tbadk.download.d.bcT().a(downloadData, 100);
            this.eiG = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bbM() {
        if (this.efD != null && !StringUtils.isNull(this.efD.originalUrl, true) && this.efD.originalSize >= 0 && !this.efD.isBlockedPic) {
            String nameMd5FromUrl = as.getNameMd5FromUrl(this.efD.originalUrl);
            File file = new File(this.eiq + ap.aUT().ws(nameMd5FromUrl) + "/" + nameMd5FromUrl);
            if (file != null && file.exists()) {
                this.efD.originalProcess = 100;
                return true;
            }
            if (this.efD.originalProcess < 0) {
                bbN();
            } else {
                this.eiF.setProgress(this.efD.originalProcess);
            }
            this.eiz = true;
        } else {
            this.eiE = null;
        }
        return false;
    }

    public void bbN() {
        if (this.efD != null) {
            if (!bbO() || !this.eiz) {
                this.eiE = null;
            } else if (this.efD.originalSize > 0 && !cq(this.efD.originalSize)) {
                this.eiE = ehY + "(" + aq.getFormatSize(this.efD.originalSize) + ")";
            } else {
                this.eiE = ehY;
            }
        }
    }

    private boolean bbO() {
        return (this.efD == null || !this.efD.mIsShowOrigonButton || this.efD.isBlockedPic || StringUtils.isNull(this.efD.originalUrl)) ? false : true;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.egB = bVar;
    }

    private boolean cq(long j) {
        return j > ehZ;
    }
}
