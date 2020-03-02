package com.baidu.tbadk.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
import android.widget.ImageView;
import com.baidu.adp.gif.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BlockingLinkedDeque;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class DragImageView extends ImageView {
    private g dHa;
    private a dHb;
    private f dHc;
    private volatile com.baidu.adp.gif.b dHd;
    private boolean dHe;
    private com.baidu.tbadk.widget.largeImage.logic.b dHf;
    private ImageUrlData dHg;
    private c dHh;
    private BlockingLinkedDeque<c> dHi;
    private BlockingLinkedDeque<c> dHj;
    private b dHk;
    private volatile int decodeIndex;
    private e drM;
    private d dtG;
    private int frameNum;
    private int height;
    private boolean isHeadImage;
    private boolean isInDragScaleMode;
    private int mBackgroundColorId;
    private int mBottom;
    private int mBottomOffset;
    private View.OnClickListener mClick;
    private float mCurrentScale;
    private Interpolator mDecelerateInterpolater;
    private float mDensity;
    private Rect mDisplayRect;
    private Matrix mDragMatrix;
    private RectF mDstRect;
    private GestureDetector mGestureDetector;
    private Bitmap mGifCache;
    private int mGifMaxUseableMem;
    private int mGifType;
    public Handler mHandler;
    private boolean mHaveMove;
    private boolean mHaveZoom;
    private byte[] mImageData;
    private int mImageMode;
    private Rect mImageRect;
    public int mImageType;
    private float mInitScale;
    private boolean mIsTouched;
    private volatile long mLastPlayTime;
    private int mLeftOffset;
    private volatile boolean mListIsEmpty;
    private boolean mLoadBigImage;
    private Matrix mMatrix;
    private float mMaxScale;
    private int mMaxZoomInSize;
    private int mMode;
    private float mMoveDistance;
    private float mOldDist;
    private float mOldScale;
    private View.OnLongClickListener mOnLongClickListener;
    private Paint mPaint;
    private float mRatio;
    private float mResizedHeight;
    private float mResizedWidth;
    private ArrayList<Float> mScale;
    private int mTop;
    private int mTopOffset;
    private int mViewHeight;
    private int mViewWidth;
    private int width;
    private static final String TAG = DragImageView.class.getSimpleName();
    private static final int EXIT_DISTANCE = l.getEquipmentHeight(TbadkCoreApplication.getInst()) / 5;

    /* loaded from: classes.dex */
    public static class c {
        public Bitmap bm;
        public int delay;
    }

    /* loaded from: classes.dex */
    public interface d {
        void aSF();

        void onDragEnd();

        void onDragStart();
    }

    /* loaded from: classes.dex */
    public interface e {
        void a(DragImageView dragImageView);
    }

    /* loaded from: classes.dex */
    public interface f {
        void a(DragImageView dragImageView, int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface g {
        void a(DragImageView dragImageView, boolean z, boolean z2);
    }

    static /* synthetic */ int C(DragImageView dragImageView) {
        int i = dragImageView.decodeIndex;
        dragImageView.decodeIndex = i + 1;
        return i;
    }

    public void setIsHeadImage(boolean z) {
        this.isHeadImage = z;
    }

    public void setImageUrlData(ImageUrlData imageUrlData) {
        this.dHg = imageUrlData;
    }

    public ImageUrlData getImageUrlData() {
        return this.dHg;
    }

    public void setCanScale(boolean z) {
        this.dHe = z;
    }

    public DragImageView(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.mIsTouched = false;
        this.mImageData = null;
        this.mGifMaxUseableMem = 0;
        this.mMaxZoomInSize = 1300;
        this.mImageMode = 0;
        this.dHa = null;
        this.mClick = null;
        this.mOnLongClickListener = null;
        this.drM = null;
        this.mOldDist = 1.0f;
        this.mImageType = 0;
        this.mMode = 0;
        this.mHaveMove = false;
        this.mHaveZoom = false;
        this.mGifType = 0;
        this.dHd = null;
        this.mGifCache = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.mTopOffset = 0;
        this.mBottomOffset = 0;
        this.mLeftOffset = 0;
        this.mBackgroundColorId = 0;
        this.dHe = true;
        this.mDecelerateInterpolater = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.mDragMatrix = new Matrix();
        this.isInDragScaleMode = false;
        this.mRatio = 1.0f;
        this.mMoveDistance = 0.0f;
        this.mDstRect = new RectF();
        this.width = 0;
        this.height = 0;
        this.frameNum = 0;
        this.dHh = null;
        this.dHi = new BlockingLinkedDeque<>(5);
        this.dHj = new BlockingLinkedDeque<>(6);
        this.decodeIndex = 0;
        this.mLastPlayTime = 0L;
        this.mListIsEmpty = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.DragImageView.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        DragImageView.this.refreshImage();
                        break;
                    case 1:
                        if (DragImageView.this.mListIsEmpty) {
                            DragImageView.this.refreshImage();
                            break;
                        }
                        break;
                    case 2:
                        DragImageView.this.invalidate();
                        DragImageView.this.mLastPlayTime = System.currentTimeMillis();
                        DragImageView.this.mHandler.sendEmptyMessage(0);
                        break;
                }
                return false;
            }
        });
        initData();
    }

    public DragImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.mIsTouched = false;
        this.mImageData = null;
        this.mGifMaxUseableMem = 0;
        this.mMaxZoomInSize = 1300;
        this.mImageMode = 0;
        this.dHa = null;
        this.mClick = null;
        this.mOnLongClickListener = null;
        this.drM = null;
        this.mOldDist = 1.0f;
        this.mImageType = 0;
        this.mMode = 0;
        this.mHaveMove = false;
        this.mHaveZoom = false;
        this.mGifType = 0;
        this.dHd = null;
        this.mGifCache = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.mTopOffset = 0;
        this.mBottomOffset = 0;
        this.mLeftOffset = 0;
        this.mBackgroundColorId = 0;
        this.dHe = true;
        this.mDecelerateInterpolater = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.mDragMatrix = new Matrix();
        this.isInDragScaleMode = false;
        this.mRatio = 1.0f;
        this.mMoveDistance = 0.0f;
        this.mDstRect = new RectF();
        this.width = 0;
        this.height = 0;
        this.frameNum = 0;
        this.dHh = null;
        this.dHi = new BlockingLinkedDeque<>(5);
        this.dHj = new BlockingLinkedDeque<>(6);
        this.decodeIndex = 0;
        this.mLastPlayTime = 0L;
        this.mListIsEmpty = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.DragImageView.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        DragImageView.this.refreshImage();
                        break;
                    case 1:
                        if (DragImageView.this.mListIsEmpty) {
                            DragImageView.this.refreshImage();
                            break;
                        }
                        break;
                    case 2:
                        DragImageView.this.invalidate();
                        DragImageView.this.mLastPlayTime = System.currentTimeMillis();
                        DragImageView.this.mHandler.sendEmptyMessage(0);
                        break;
                }
                return false;
            }
        });
        initData();
    }

    public DragImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.mIsTouched = false;
        this.mImageData = null;
        this.mGifMaxUseableMem = 0;
        this.mMaxZoomInSize = 1300;
        this.mImageMode = 0;
        this.dHa = null;
        this.mClick = null;
        this.mOnLongClickListener = null;
        this.drM = null;
        this.mOldDist = 1.0f;
        this.mImageType = 0;
        this.mMode = 0;
        this.mHaveMove = false;
        this.mHaveZoom = false;
        this.mGifType = 0;
        this.dHd = null;
        this.mGifCache = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.mTopOffset = 0;
        this.mBottomOffset = 0;
        this.mLeftOffset = 0;
        this.mBackgroundColorId = 0;
        this.dHe = true;
        this.mDecelerateInterpolater = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.mDragMatrix = new Matrix();
        this.isInDragScaleMode = false;
        this.mRatio = 1.0f;
        this.mMoveDistance = 0.0f;
        this.mDstRect = new RectF();
        this.width = 0;
        this.height = 0;
        this.frameNum = 0;
        this.dHh = null;
        this.dHi = new BlockingLinkedDeque<>(5);
        this.dHj = new BlockingLinkedDeque<>(6);
        this.decodeIndex = 0;
        this.mLastPlayTime = 0L;
        this.mListIsEmpty = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.DragImageView.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        DragImageView.this.refreshImage();
                        break;
                    case 1:
                        if (DragImageView.this.mListIsEmpty) {
                            DragImageView.this.refreshImage();
                            break;
                        }
                        break;
                    case 2:
                        DragImageView.this.invalidate();
                        DragImageView.this.mLastPlayTime = System.currentTimeMillis();
                        DragImageView.this.mHandler.sendEmptyMessage(0);
                        break;
                }
                return false;
            }
        });
        initData();
    }

    public void setDragToExitListener(d dVar) {
        this.dtG = dVar;
    }

    public int getImageType() {
        return this.mImageType;
    }

    public void setImageMode(int i) {
        this.mImageMode = i;
    }

    public void setOffset(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.mGifMaxUseableMem = i;
    }

    public boolean isViewTop() {
        if (this.dHf == null) {
            return false;
        }
        return this.dHf.isViewTop();
    }

    public boolean aSD() {
        if (this.dHf == null) {
            return false;
        }
        return this.dHf.aSD();
    }

    public boolean isAtViewTop() {
        if (this.dHf != null) {
            return this.dHf.isAtViewTop();
        }
        return false;
    }

    public void actionUp() {
        this.mHaveZoom = false;
        this.mIsTouched = false;
        this.mMode = 3;
        adjustPos();
        if (this.mCurrentScale < this.mInitScale) {
            this.mCurrentScale = this.mInitScale;
            resizeBitmap();
        }
        invalidate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.dHf != null && this.dHf.onTouchEvent(motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.mIsTouched = true;
                this.mHaveMove = false;
                this.mHaveZoom = false;
                break;
            case 1:
                actionUp();
                break;
            case 2:
                if (this.mMode == 0) {
                    this.mMode = 1;
                    break;
                }
                break;
        }
        if (action == CompatibleUtile.getInstance().getActionPointerUp()) {
            this.mMode = 1;
        } else if (action == CompatibleUtile.getInstance().getActionPointerDown()) {
            this.mOldDist = spacing(motionEvent);
            if (this.mOldDist > 10.0f) {
                this.mMode = 2;
            }
        }
        if ((this.mMode == 2 || !this.mGestureDetector.onTouchEvent(motionEvent)) && this.dHe) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.mHaveMove = true;
                        this.mHaveZoom = true;
                        if (this.mImageType != 1 && this.mImageType != 2) {
                            float spacing = spacing(motionEvent);
                            if (spacing >= 0.0f && Math.abs(this.mOldDist - spacing) >= 10.0f) {
                                if (Math.abs(this.mOldDist - spacing) > 100.0f) {
                                    this.mOldDist = spacing;
                                    break;
                                } else {
                                    float f2 = spacing / this.mOldDist;
                                    this.mOldDist = spacing;
                                    this.mOldScale = this.mCurrentScale;
                                    this.mCurrentScale *= f2;
                                    if (this.mCurrentScale > this.mMaxScale) {
                                        this.mCurrentScale = this.mMaxScale;
                                    }
                                    float minScaleValue = getMinScaleValue();
                                    if (this.mCurrentScale < minScaleValue) {
                                        this.mCurrentScale = minScaleValue;
                                    }
                                    resizeBitmap();
                                    break;
                                }
                            }
                        }
                    }
                    break;
            }
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    protected float getMinScaleValue() {
        return this.dHf != null ? this.dHf.getMinScaleValue() : this.mInitScale / 4.0f;
    }

    public float spacing(MotionEvent motionEvent) {
        return CompatibleUtile.getInstance().getSpacing(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            this.mViewWidth = i3 - i;
            this.mViewHeight = i4 - i2;
            reInitBitmap();
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public boolean pagerCantScroll() {
        if (this.dHf != null) {
            return this.dHf.isNormalScale();
        }
        return this.mInitScale == this.mCurrentScale;
    }

    protected float reInitScaleValue(Bitmap bitmap) {
        if (this.dHf != null) {
            return this.dHf.reInitScaleValue();
        }
        if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            return 1.0f;
        }
        if (this.mImageMode == 0) {
            float width = this.mViewWidth / bitmap.getWidth();
            float height = this.mViewHeight / bitmap.getHeight();
            if (this.isHeadImage) {
                if (this.mImageType == 2) {
                    return 2.5f;
                }
                return Math.min(width, height);
            } else if (this.mImageType != 2) {
                float f2 = this.mDensity;
                float f3 = f2 >= 1.0f ? f2 : 1.0f;
                if (bitmap.getWidth() * f3 >= this.mViewWidth || bitmap.getHeight() * f3 >= this.mViewHeight) {
                    return Math.min(width, height);
                }
                return f3;
            } else {
                return 1.0f;
            }
        }
        return Math.max(this.mViewWidth / bitmap.getWidth(), ((this.mViewHeight - this.mTop) - this.mBottom) / bitmap.getHeight());
    }

    protected float getMaxScaleValue(Bitmap bitmap) {
        if (this.dHf != null) {
            return this.dHf.getMaxScaleValue();
        }
        float f2 = 1.0f;
        if (bitmap != null && !bitmap.isRecycled() && bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
            f2 = (float) Math.sqrt(this.mMaxZoomInSize / (bitmap.getWidth() * bitmap.getHeight()));
            if (f2 > 10.0f) {
                return 10.0f;
            }
        }
        return f2;
    }

    private void reInitBitmap() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            this.mInitScale = reInitScaleValue(imageBitmap);
            this.mMaxScale = getMaxScaleValue(imageBitmap);
            this.mScale.clear();
            this.mScale.add(Float.valueOf(this.mInitScale));
            this.mCurrentScale = this.mInitScale;
            this.mOldScale = this.mCurrentScale;
            resizeBitmap();
            return;
        }
        this.mResizedWidth = 0.0f;
        this.mResizedHeight = 0.0f;
        this.mInitScale = 1.0f;
        this.mMaxScale = 1.0f;
        this.mCurrentScale = 1.0f;
        this.mOldScale = this.mCurrentScale;
        this.mScale.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    private void callChangeListener() {
        if (this.dHa != null) {
            this.dHa.a(this, canZoomIn(), canZoomOut());
        }
    }

    public void setOnSizeChangedListener(g gVar) {
        this.dHa = gVar;
    }

    public void setOnImageScrollListener(f fVar) {
        this.dHc = fVar;
    }

    public byte[] getImageData() {
        return this.mImageData;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getMeasuredHeight() != 0 && getMeasuredWidth() != 0 && this.dHf != null) {
            this.dHf.startLoad();
        }
    }

    public void setImageData(Bitmap bitmap, byte[] bArr) {
        this.mImageData = bArr;
        if (this.dHf != null) {
            this.dHf.setImageDatas(bitmap, bArr);
        }
        setImageBitmap(bitmap);
    }

    public void createLargeImageDelegate() {
        if (this.dHf == null) {
            this.dHf = new com.baidu.tbadk.widget.largeImage.logic.b(this);
            this.dHf.setOnClickListener(this.mClick);
            this.dHf.setOnLongClickListener(this.mOnLongClickListener);
        }
    }

    public void setImageLoadCallBack(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
        if (this.dHf != null) {
            this.dHf.a(aVar);
        }
    }

    public boolean hasLoadLongImage() {
        return (getImageBitmap() == null || this.dHf == null) ? false : true;
    }

    public Bitmap getGifCache() {
        return this.mGifCache;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        boolean z;
        if (this.dHf == null || !this.dHf.onDraw(canvas, getImageBitmap())) {
            if (this.mImageType == 2 && this.mBackgroundColorId != 0 && !this.dHb.getIsAnimationInProgre()) {
                int width = getWidth();
                int height = getHeight();
                Drawable drawable = getDrawable();
                float f2 = 0.0f;
                float f3 = height * 0.3f;
                float f4 = width;
                float f5 = (1.0f - 0.3f) * height;
                if (this.isHeadImage && drawable != null) {
                    Rect bounds = drawable.getBounds();
                    int i = bounds.right - bounds.left;
                    int i2 = bounds.bottom - bounds.top;
                    f2 = (width / 2) - (i * 2.5f);
                    f3 = (height / 2) - (i2 * 2.5f);
                    f4 = (i * 2.5f) + (width / 2);
                    f5 = (i2 * 2.5f) + (height / 2);
                }
                this.mPaint.setColor(am.getColor(this.mBackgroundColorId));
                canvas.drawRect(f2, f3, f4, f5, this.mPaint);
                this.mPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
            }
            if (this.mMode == 3 && this.isInDragScaleMode) {
                this.isInDragScaleMode = false;
                this.mDragMatrix.reset();
                if (this.mMoveDistance < EXIT_DISTANCE) {
                    this.mMode = 0;
                } else {
                    this.mMode = 4;
                    startExitAnimation();
                }
            }
            if (this.mImageType == 0 && this.isInDragScaleMode && this.mDisplayRect != null && this.dHg != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                if (this.mDstRect == null) {
                    this.mDstRect = new RectF();
                }
                this.mDragMatrix.mapRect(this.mDstRect, new RectF(this.mDisplayRect));
                Bitmap imageBitmap = getImageBitmap();
                if (imageBitmap != null && !imageBitmap.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.mImageRect, this.mDstRect, (Paint) null);
                }
            } else if (this.mMode == 4 && this.mDisplayRect != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                Bitmap imageBitmap2 = getImageBitmap();
                if (imageBitmap2 != null && !imageBitmap2.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.mImageRect, this.mDstRect, (Paint) null);
                }
            } else {
                super.onDraw(canvas);
            }
            if (this.mImageType == 1 && this.mGifCache != null && !this.mGifCache.isRecycled()) {
                int width2 = this.mGifCache.getWidth();
                int height2 = this.mGifCache.getHeight();
                int width3 = getWidth();
                int height3 = getHeight();
                int i3 = (width3 - width2) >> 1;
                int i4 = (height3 - height2) >> 1;
                float f6 = this.mDensity;
                if (f6 < 1.0f) {
                    f6 = 1.0f;
                }
                if (width2 * f6 >= width3 || height2 * f6 >= height3) {
                    f6 = Math.min(width3 / width2, height3 / height2);
                }
                if (Math.abs(f6 - 1.0f) < 1.0E-8f) {
                    z = true;
                } else {
                    this.mMatrix.setScale(f6, f6);
                    i3 = (int) ((width3 - (width2 * f6)) / 2.0f);
                    i4 = (int) ((height3 - (height2 * f6)) / 2.0f);
                    this.mMatrix.postTranslate(i3, i4);
                    width2 = (int) (width2 * f6);
                    height2 = (int) (f6 * height2);
                    z = false;
                }
                canvas.clipRect(i3, i4, width2 + i3, height2 + i4);
                canvas.drawColor(-1);
                if (this.mGifType == 1 && this.dHd != null && this.dHh != null && this.dHh.bm != null) {
                    if (z) {
                        canvas.drawBitmap(this.dHh.bm, i3, i4, (Paint) null);
                    } else {
                        canvas.drawBitmap(this.dHh.bm, this.mMatrix, this.mPaint);
                    }
                    invalidate();
                } else if (z) {
                    canvas.drawBitmap(this.mGifCache, i3, i4, (Paint) null);
                } else {
                    canvas.drawBitmap(this.mGifCache, this.mMatrix, this.mPaint);
                }
            }
        }
    }

    public void play() {
        com.baidu.adp.widget.ImageView.a aVar;
        if (this.mImageType == 1) {
            if (this.dHd == null) {
                if (this.dHk != null) {
                    this.dHk.mIsRunning = false;
                    this.dHk.interrupt();
                    this.dHk = null;
                }
                if (this.mImageData != null) {
                    try {
                        aVar = a.C0014a.fh().d(this.mImageData, 0, this.mImageData.length);
                    } catch (StackOverflowError e2) {
                        aVar = null;
                    }
                    if (aVar == null || aVar.getGif() == null) {
                        com.baidu.tbadk.core.d.a.a("gifplay", -1L, -1, "DragImageView.play", -1, "decode error", new Object[0]);
                        return;
                    }
                    this.dHd = aVar.getGif();
                    if (this.dHd != null) {
                        this.mGifType = 1;
                        this.width = this.dHd.getWidth();
                        this.height = this.dHd.getHeight();
                        this.decodeIndex = 0;
                        this.frameNum = this.dHd.getFrameCount();
                    } else {
                        this.mGifType = 0;
                    }
                } else {
                    return;
                }
            }
            if (this.dHd != null) {
                if (this.dHk == null || (this.dHk != null && !this.dHk.mIsRunning)) {
                    this.mListIsEmpty = true;
                    this.dHk = new b();
                    this.dHi.clear();
                    this.dHj.clear();
                    this.dHk.mIsRunning = true;
                    this.dHk.start();
                }
            }
        }
    }

    public void pause() {
        if (this.mImageType == 1) {
            if (this.dHk != null) {
                this.dHk.mIsRunning = false;
                this.dHk.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.mImageType == 1) {
            if (this.dHk != null) {
                this.dHk.mIsRunning = false;
                this.dHk.interrupt();
                this.dHk = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mListIsEmpty = true;
            this.dHh = null;
            this.dHj.clear();
            this.dHi.clear();
            this.width = 0;
            this.height = 0;
            this.decodeIndex = 0;
            this.frameNum = 0;
            this.dHd = null;
        }
    }

    private void initData() {
        this.mDensity = l.getEquipmentDensity(getContext());
        this.mMaxZoomInSize = l.getEquipmentHeight(getContext()) * l.getEquipmentWidth(getContext()) * 2;
        if (this.mMaxZoomInSize < 1690000) {
            this.mMaxZoomInSize = 1690000;
        }
        this.mResizedWidth = 0.0f;
        this.mResizedHeight = 0.0f;
        this.mScale = new ArrayList<>();
        this.mInitScale = 1.0f;
        this.mMaxScale = 1.0f;
        this.mCurrentScale = 1.0f;
        this.mOldScale = this.mCurrentScale;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.dHb = new a();
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWillNotDraw(false);
        scrollTo(0, 0);
        this.mGestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.DragImageView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                if (DragImageView.this.mImageType != 2 && (Math.abs(f2) > 200.0f || Math.abs(f3) > 200.0f)) {
                    DragImageView.this.dHb.prepareAnimation(f2, f3);
                    DragImageView.this.startAnimation(DragImageView.this.dHb);
                }
                return super.onFling(motionEvent, motionEvent2, f2, f3);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (DragImageView.this.mImageType == 1 || DragImageView.this.mImageType == 2 || !DragImageView.this.dHe) {
                    return false;
                }
                DragImageView.this.mMode = 2;
                if (DragImageView.this.mCurrentScale > DragImageView.this.mInitScale) {
                    DragImageView.this.mCurrentScale = DragImageView.this.mInitScale;
                    DragImageView.this.mOldScale = DragImageView.this.mCurrentScale;
                    DragImageView.this.resizeBitmap();
                } else {
                    DragImageView.this.mCurrentScale = DragImageView.this.mInitScale * 2.0f;
                    DragImageView.this.resizeBitmap(true, (int) motionEvent.getX(), (int) motionEvent.getY());
                }
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (DragImageView.this.mClick != null && !DragImageView.this.mHaveMove) {
                    DragImageView.this.mClick.onClick(DragImageView.this);
                }
                return super.onSingleTapConfirmed(motionEvent);
            }

            /* JADX WARN: Removed duplicated region for block: B:20:0x0095  */
            /* JADX WARN: Removed duplicated region for block: B:34:0x0113  */
            /* JADX WARN: Removed duplicated region for block: B:36:0x0121  */
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                int i;
                int i2;
                DragImageView.this.mHaveMove = true;
                if (DragImageView.this.mImageMode == 0 && DragImageView.this.mHaveZoom) {
                    return false;
                }
                int scrollX = DragImageView.this.getScrollX();
                int scrollY = DragImageView.this.getScrollY();
                if (!DragImageView.this.onLeftSide()) {
                    DragImageView.this.getParent().requestDisallowInterceptTouchEvent(true);
                }
                if (DragImageView.this.mResizedWidth >= DragImageView.this.getWidth()) {
                    scrollX = (int) (scrollX + f2);
                    if (DragImageView.this.mImageMode == 0) {
                        i = scrollX >= 0 ? scrollX : 0;
                        if (DragImageView.this.getWidth() + i > DragImageView.this.mResizedWidth) {
                            i = (int) (DragImageView.this.mResizedWidth - DragImageView.this.getWidth());
                        }
                        if (DragImageView.this.mResizedHeight + DragImageView.this.mTop + DragImageView.this.mBottom < DragImageView.this.getHeight()) {
                            i2 = (int) (scrollY + f3);
                            if (DragImageView.this.mImageMode == 0) {
                                if (i2 < (-DragImageView.this.mTopOffset)) {
                                    i2 = -DragImageView.this.mTopOffset;
                                }
                                if (DragImageView.this.getHeight() + i2 > DragImageView.this.mResizedHeight + DragImageView.this.mBottom + DragImageView.this.mBottomOffset) {
                                    i2 = (int) ((DragImageView.this.mResizedHeight - DragImageView.this.getHeight()) + DragImageView.this.mBottom + DragImageView.this.mBottomOffset);
                                }
                            }
                        } else {
                            i2 = scrollY;
                        }
                        if (i == DragImageView.this.getScrollX() || i2 != DragImageView.this.getScrollY()) {
                            DragImageView.this.scrollTo(i, i2);
                            DragImageView.this.invalidate();
                            if (DragImageView.this.dHc != null) {
                                DragImageView.this.dHc.a(DragImageView.this, i, i2);
                            }
                        }
                        return true;
                    }
                }
                i = scrollX;
                if (DragImageView.this.mResizedHeight + DragImageView.this.mTop + DragImageView.this.mBottom < DragImageView.this.getHeight()) {
                }
                if (i == DragImageView.this.getScrollX()) {
                }
                DragImageView.this.scrollTo(i, i2);
                DragImageView.this.invalidate();
                if (DragImageView.this.dHc != null) {
                }
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (DragImageView.this.mOnLongClickListener != null && !DragImageView.this.mHaveMove) {
                    DragImageView.this.mOnLongClickListener.onLongClick(DragImageView.this);
                }
                super.onLongPress(motionEvent);
            }
        });
    }

    private void startExitAnimation() {
        if (this.dHg == null) {
            if (this.dtG != null) {
                this.dtG.onDragEnd();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.dHg.getSourceImageRectInScreen();
        if (sourceImageRectInScreen == null) {
            if (this.dtG != null) {
                this.dtG.onDragEnd();
                return;
            }
            return;
        }
        this.mDstRect.bottom = (((sourceImageRectInScreen.bottom - sourceImageRectInScreen.top) / (sourceImageRectInScreen.right - sourceImageRectInScreen.left)) * (this.mDstRect.right - this.mDstRect.left)) + this.mDstRect.top;
        final float[] fArr = {(this.mDstRect.left + this.mDstRect.right) / 2.0f, (this.mDstRect.top + this.mDstRect.bottom) / 2.0f};
        final float[] fArr2 = {(sourceImageRectInScreen.left + sourceImageRectInScreen.right) / 2, (sourceImageRectInScreen.top + sourceImageRectInScreen.bottom) / 2};
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr[0], fArr2[0]);
        ofFloat.setDuration(150L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.DragImageView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && sourceImageRectInScreen != null) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    float animatedFraction = fArr[1] + ((fArr2[1] - fArr[1]) * valueAnimator.getAnimatedFraction());
                    DragImageView.this.mDstRect = DragImageView.this.getRectInScreenFromPosition(floatValue, animatedFraction, sourceImageRectInScreen.right - sourceImageRectInScreen.left, sourceImageRectInScreen.bottom - sourceImageRectInScreen.top);
                    DragImageView.this.invalidate();
                }
            }
        });
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tbadk.widget.DragImageView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                DragImageView.this.isInDragScaleMode = false;
                DragImageView.this.mMode = 4;
                DragImageView.this.invalidate();
                if (DragImageView.this.dtG != null) {
                    DragImageView.this.dtG.onDragEnd();
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

    /* JADX INFO: Access modifiers changed from: private */
    public RectF getRectInScreenFromPosition(float f2, float f3, float f4, float f5) {
        return new RectF(f2 - (f4 / 2.0f), f3 - (f5 / 2.0f), (f4 / 2.0f) + f2, (f5 / 2.0f) + f3);
    }

    private void adjustPos() {
        int i = 0;
        int scrollX = getScrollX();
        if (this.mResizedWidth >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.mResizedWidth) {
                scrollX = (int) (this.mResizedWidth - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.mResizedHeight + this.mTop + this.mBottom >= getHeight()) {
            i = scrollY < (-this.mTopOffset) ? -this.mTopOffset : scrollY;
            if (getHeight() + i > this.mResizedHeight + this.mBottom + this.mBottomOffset) {
                i = (int) ((this.mResizedHeight - getHeight()) + this.mBottom + this.mBottomOffset);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
            if (this.dHc != null) {
                this.dHc.a(this, scrollX, i);
            }
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.dHf != null) {
            this.dHf.computeScroll();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.mResizedWidth;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.mResizedHeight;
    }

    public boolean onRightSide() {
        if (this.mImageType == 1 || this.mImageType == 2) {
            return true;
        }
        return !this.mHaveZoom && getScrollX() >= ((int) (this.mResizedWidth - ((float) getWidth()))) + (-1);
    }

    public boolean onLeftSide() {
        if (this.mImageType == 1 || this.mImageType == 2) {
            return true;
        }
        return !this.mHaveZoom && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.dHb.getIsAnimationInProgre()) {
            this.dHb.stopAnimation();
        }
        this.mBackgroundColorId = 0;
        super.setImageBitmap(bitmap);
        reInitBitmap();
        this.mImageType = 0;
        if (this.mDisplayRect == null) {
            int measuredWidth = getMeasuredWidth();
            float measuredWidth2 = ((1.0f * getMeasuredWidth()) / bitmap.getWidth()) * bitmap.getHeight();
            if (measuredWidth2 > getMeasuredHeight()) {
                measuredWidth2 = getMeasuredHeight();
            }
            RectF rectInScreenFromPosition = getRectInScreenFromPosition(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
            this.mDisplayRect = new Rect((int) rectInScreenFromPosition.left, (int) rectInScreenFromPosition.top, (int) rectInScreenFromPosition.right, (int) rectInScreenFromPosition.bottom);
        }
        if (this.mImageRect == null) {
            this.mImageRect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        }
    }

    public void replaceImageBitmap(Bitmap bitmap) {
        Bitmap imageBitmap = getImageBitmap();
        if (bitmap != null && !bitmap.isRecycled()) {
            if (imageBitmap != null && (imageBitmap.getWidth() != bitmap.getWidth() || imageBitmap.getHeight() != bitmap.getHeight())) {
                setImageBitmap(bitmap);
                super.setImageMatrix(this.mMatrix);
                return;
            }
            if (this.dHb.getIsAnimationInProgre()) {
                this.dHb.stopAnimation();
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            super.setImageBitmap(bitmap);
            super.setImageMatrix(this.mMatrix);
            scrollTo(scrollX, scrollY);
            this.mImageType = 0;
        }
    }

    public void setGifData(byte[] bArr, Bitmap bitmap) {
        if (this.dHb.getIsAnimationInProgre()) {
            this.dHb.stopAnimation();
        }
        super.setImageDrawable(null);
        stop();
        reInitBitmap();
        this.mImageType = 1;
        this.mGifCache = bitmap;
        this.mImageData = bArr;
        if (this.drM != null) {
            this.drM.a(this);
        }
    }

    public void onDestroy() {
        if (this.dHb.getIsAnimationInProgre()) {
            this.dHb.stopAnimation();
        }
        super.setImageDrawable(null);
        this.mImageData = null;
        this.mGifCache = null;
        stop();
        if (this.dHd != null) {
            this.dHd.close();
            this.dHd = null;
        }
        if (this.dHf != null) {
            this.dHf.release();
            System.gc();
        }
    }

    public void release() {
        if (this.dHb.getIsAnimationInProgre()) {
            this.dHb.stopAnimation();
        }
        stop();
        super.setImageDrawable(null);
        this.mGifCache = null;
    }

    public void setDefaultBitmap() {
        if (this.dHb.getIsAnimationInProgre()) {
            this.dHb.stopAnimation();
        }
        try {
            if (this.isHeadImage) {
                super.setImageBitmap(BitmapHelper.getCashBitmap(R.drawable.icon_default_avatar100));
            } else {
                super.setImageBitmap(BitmapHelper.getCashBitmap(R.drawable.btn_see_default));
            }
        } catch (OutOfMemoryError e2) {
            TbadkCoreApplication.getInst().onAppMemoryLow();
            System.gc();
            super.setImageBitmap(null);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
        this.mImageType = 2;
        reInitBitmap();
    }

    public void zoomInBitmap() {
        if (this.mImageType != 1 && this.mImageType != 2) {
            int size = this.mScale.size();
            if (size > 0) {
                this.mScale.add(Float.valueOf(this.mScale.get(size - 1).floatValue() * 1.25f));
            } else {
                this.mScale.add(Float.valueOf(this.mInitScale));
            }
            resizeBitmap();
        }
    }

    public void zoomOutBitmap() {
        if (this.mImageType != 1 && this.mImageType != 2) {
            int size = this.mScale.size();
            if (size > 1) {
                this.mScale.remove(size - 1);
            }
            resizeBitmap();
        }
    }

    public void restoreSize() {
        callChangeListener();
        if (this.mImageType != 1 && this.mImageType != 2 && this.mCurrentScale != this.mInitScale) {
            this.mScale.clear();
            this.mScale.add(Float.valueOf(this.mInitScale));
            this.mCurrentScale = this.mInitScale;
            this.mOldScale = this.mCurrentScale;
            resizeBitmap();
        }
    }

    public boolean canZoomIn() {
        if (this.mImageType == 1 || this.mImageType == 2) {
            return false;
        }
        int size = this.mScale.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.mScale.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.mMaxZoomInSize) && floatValue <= 5.0f;
    }

    public boolean canZoomOut() {
        if (this.mImageType == 1 || this.mImageType == 2) {
            return false;
        }
        int size = this.mScale.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled()) {
            return false;
        }
        return size > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resizeBitmap() {
        resizeBitmap(false, -1, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resizeBitmap(boolean z, int i, int i2) {
        float f2;
        float f3;
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled()) {
            try {
                if (this.mMode != 2) {
                    int size = this.mScale.size();
                    if (size > 0) {
                        f3 = this.mScale.get(size - 1).floatValue();
                    } else {
                        f3 = this.mInitScale;
                    }
                    this.mCurrentScale = f3;
                }
                this.mMatrix.setScale(this.mCurrentScale, this.mCurrentScale);
                this.mResizedWidth = imageBitmap.getWidth() * this.mCurrentScale;
                this.mResizedHeight = imageBitmap.getHeight() * this.mCurrentScale;
                float width = this.mOldScale * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.mOldScale;
                this.mTopOffset = this.mTop;
                this.mBottomOffset = 0;
                float f4 = this.mResizedWidth < ((float) this.mViewWidth) ? (int) ((this.mViewWidth - this.mResizedWidth) / 2.0f) : 0.0f;
                if (this.mResizedHeight < this.mViewHeight) {
                    f2 = (int) ((this.mViewHeight - this.mResizedHeight) / 2.0f);
                    if (this.mImageMode == 1 && f2 > this.mTop) {
                        f2 = this.mTop;
                    }
                    this.mTopOffset = (int) (this.mTop - f2);
                    this.mBottomOffset = this.mTop - this.mTopOffset;
                } else {
                    f2 = 0.0f;
                }
                this.mLeftOffset = (int) f4;
                this.mMatrix.postTranslate(f4, f2);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    int width2 = i > getWidth() ? getWidth() : i;
                    if (this.mResizedWidth <= screenWidth) {
                        width2 = 0;
                    } else if (this.mResizedWidth > screenWidth && this.mResizedWidth / 2.0f < screenWidth) {
                        width2 = (int) (width2 - (this.mResizedWidth / 4.0f));
                    }
                    scrollX = width2;
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.mResizedWidth - width) / 2.0f);
                    }
                    if (this.mResizedWidth <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.mResizedWidth) {
                        scrollX = (int) (this.mResizedWidth - getWidth());
                    }
                }
                if (scrollX > 0 && this.mResizedWidth - scrollX < getWidth()) {
                    scrollX = (int) (this.mResizedWidth - getWidth());
                }
                int i3 = this.mMode == 2 ? ((int) ((this.mResizedHeight - height) / 2.0f)) + scrollY : scrollY;
                if (this.mResizedHeight <= getHeight()) {
                    i3 = 0;
                } else if (getHeight() + i3 > this.mResizedHeight) {
                    i3 = (int) (this.mResizedHeight - getHeight());
                }
                setHorizontalScrollBarEnabled(false);
                setVerticalScrollBarEnabled(false);
                if (scrollX < 0) {
                    scrollX = 0;
                }
                scrollTo(scrollX, i3 >= 0 ? i3 : 0);
                setImageMatrix(this.mMatrix);
                callChangeListener();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Animation {
        private int mStartX;
        private int mStartY;
        private long mTimeX;
        private long mTimeY;
        private long velocityX;
        private long velocityY;
        private boolean mIsAnimationInProgres = false;
        private boolean mStop = false;

        public a() {
        }

        public void prepareAnimation(float f, float f2) {
            if (f > 1500.0f) {
                f = 1500.0f;
            } else if (f < -1500.0f) {
                f = -1500.0f;
            }
            if (f2 > 1500.0f) {
                f2 = 1500.0f;
            } else if (f2 < -1500.0f) {
                f2 = -1500.0f;
            }
            this.velocityX = f;
            this.velocityY = f2;
            this.mTimeX = Math.abs((f * 1000.0f) / 2500.0f);
            this.mTimeY = Math.abs((f2 * 1000.0f) / 2500.0f);
            setDuration(Math.max(this.mTimeX, this.mTimeY));
            setInterpolator(DragImageView.this.mDecelerateInterpolater);
            this.mStartX = DragImageView.this.getScrollX();
            this.mStartY = DragImageView.this.getScrollY();
            this.mIsAnimationInProgres = true;
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f, Transformation transformation) {
            long j;
            int i;
            int i2;
            int i3 = 0;
            if (f > 1.0f) {
                f = 1.0f;
            }
            if (this.mTimeX > this.mTimeY) {
                j = ((float) this.mTimeX) * f;
            } else {
                j = ((float) this.mTimeY) * f;
            }
            float f2 = ((float) (j > this.mTimeX ? this.mTimeX : j)) / 1000.0f;
            if (this.velocityX > 0) {
                i = this.mStartX - ((int) (f2 * (((float) this.velocityX) - ((2500.0f * f2) / 2.0f))));
            } else {
                i = this.mStartX - ((int) (f2 * (((float) this.velocityX) + ((2500.0f * f2) / 2.0f))));
            }
            if (j > this.mTimeY) {
                j = this.mTimeY;
            }
            float f3 = ((float) j) / 1000.0f;
            if (this.velocityY > 0) {
                i2 = this.mStartY - ((int) (f3 * (((float) this.velocityY) - ((2500.0f * f3) / 2.0f))));
            } else {
                i2 = this.mStartY - ((int) (f3 * (((float) this.velocityY) + ((2500.0f * f3) / 2.0f))));
            }
            if (DragImageView.this.mResizedHeight + DragImageView.this.mTop + DragImageView.this.mBottom > DragImageView.this.getHeight()) {
                if (i2 < (-DragImageView.this.mTopOffset)) {
                    i2 = -DragImageView.this.mTopOffset;
                }
                if (DragImageView.this.getHeight() + i2 > DragImageView.this.mResizedHeight + DragImageView.this.mBottom + DragImageView.this.mBottomOffset) {
                    i2 = (int) ((DragImageView.this.mResizedHeight - DragImageView.this.getHeight()) + DragImageView.this.mBottom + DragImageView.this.mBottomOffset);
                }
            } else {
                i2 = 0;
            }
            if (DragImageView.this.mResizedWidth > DragImageView.this.getWidth()) {
                int width = ((float) (DragImageView.this.getWidth() + i)) > DragImageView.this.mResizedWidth ? (int) (DragImageView.this.mResizedWidth - DragImageView.this.getWidth()) : i;
                if (width >= 0) {
                    i3 = width;
                }
            }
            DragImageView.this.scrollTo(i3, i2);
            DragImageView.this.invalidate();
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            if (!this.mStop) {
                if (DragImageView.this.mIsTouched) {
                    this.mIsAnimationInProgres = false;
                    return false;
                }
                try {
                    if (super.getTransformation(j, transformation)) {
                        return true;
                    }
                    this.mIsAnimationInProgres = false;
                    return false;
                } catch (Exception e) {
                    this.mIsAnimationInProgres = false;
                    return false;
                }
            }
            this.mStop = false;
            this.mIsAnimationInProgres = false;
            return false;
        }

        public boolean getIsAnimationInProgre() {
            return this.mIsAnimationInProgres;
        }

        public void stopAnimation() {
            this.mStop = true;
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
        if (this.dHf != null) {
            this.dHf.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setGifSetListener(e eVar) {
        this.drM = eVar;
    }

    public Bitmap getVisableBitmap() {
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        Matrix matrix = new Matrix(this.mMatrix);
        matrix.postTranslate(-scrollX, -scrollY);
        canvas.drawBitmap(getImageBitmap(), matrix, null);
        return createBitmap;
    }

    private int getScreenWidth() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshImage() {
        long j;
        c poll = this.dHi.poll();
        if (poll == null) {
            this.mListIsEmpty = true;
            return;
        }
        this.mListIsEmpty = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.dHh != null) {
            j = this.dHh.delay - (currentTimeMillis - this.mLastPlayTime);
            this.dHj.offer(this.dHh);
        } else {
            j = 0;
        }
        this.dHh = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public c aSE() {
        c poll = this.dHj.poll();
        if (poll == null) {
            poll = new c();
            try {
                poll.bm = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
            } catch (OutOfMemoryError e2) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
            } catch (Throwable th) {
                BdLog.e(th.getMessage());
            }
        }
        return poll;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        play();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        onDestroy();
    }

    public c getCurrentFrame() {
        return this.dHh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends Thread {
        private volatile boolean mIsRunning;

        private b() {
            this.mIsRunning = false;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (this.mIsRunning && DragImageView.this.dHd != null && DragImageView.this.frameNum > 0 && DragImageView.this.width > 0 && DragImageView.this.height > 0) {
                try {
                    DragImageView.this.dHd.E(DragImageView.this.decodeIndex);
                    c aSE = DragImageView.this.aSE();
                    if (aSE.bm == null || (aSE.bm.getWidth() != DragImageView.this.width && aSE.bm.getHeight() != DragImageView.this.height)) {
                        try {
                            aSE.bm = Bitmap.createBitmap(DragImageView.this.width, DragImageView.this.height, Bitmap.Config.ARGB_8888);
                        } catch (OutOfMemoryError e) {
                            TbadkCoreApplication.getInst().onAppMemoryLow();
                            try {
                                aSE.bm = Bitmap.createBitmap(DragImageView.this.width, DragImageView.this.height, Bitmap.Config.ARGB_4444);
                            } catch (OutOfMemoryError e2) {
                                TbadkCoreApplication.getInst().onAppMemoryLow();
                            } catch (Throwable th) {
                                BdLog.e(th.getMessage());
                            }
                        } catch (Throwable th2) {
                            BdLog.e(th2.getMessage());
                        }
                    }
                    DragImageView.this.dHd.a(aSE.bm, null);
                    aSE.delay = DragImageView.this.dHd.F(DragImageView.this.decodeIndex);
                    DragImageView.C(DragImageView.this);
                    if (aSE.bm == null) {
                        DragImageView.C(DragImageView.this);
                    }
                    DragImageView.this.decodeIndex %= DragImageView.this.frameNum;
                    DragImageView.this.dHi.put(aSE);
                    if (DragImageView.this.mListIsEmpty) {
                        DragImageView.this.mHandler.sendEmptyMessage(1);
                    }
                } catch (Exception e3) {
                    return;
                }
            }
        }
    }

    public boolean isLoadBigImage() {
        return this.mLoadBigImage;
    }

    public void setLoadBigImage(boolean z) {
        this.mLoadBigImage = z;
    }

    public int getBottomOffset() {
        return this.mBottomOffset;
    }

    public int getLeftOffset() {
        return this.mLeftOffset;
    }
}
