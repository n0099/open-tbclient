package com.baidu.tbadk.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.FloatMath;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BlockingLinkedDeque;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.v;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends ImageView {
    private int Kh;
    private View.OnLongClickListener TL;
    private g TN;
    private int TO;
    private float ahG;
    private float ahH;
    private ArrayList<Float> ahI;
    private float ahJ;
    private float ahK;
    private boolean ahL;
    private int ahM;
    private int ahN;
    private h ahO;
    private View.OnClickListener ahP;
    private d ahQ;
    private float ahR;
    private boolean ahS;
    private boolean ahT;
    private int ahU;
    private volatile com.baidu.adp.gif.c ahV;
    private Bitmap ahW;
    private int ahX;
    private int ahY;
    private int ahZ;
    private boolean aia;
    private Interpolator aib;
    private int aic;
    private f aid;
    private BlockingLinkedDeque<f> aie;
    private BlockingLinkedDeque<f> aif;
    private volatile int aig;
    private e aih;
    private volatile long aii;
    private volatile boolean aij;
    private int height;
    private int mBottom;
    private float mCurrentScale;
    private GestureDetector mGestureDetector;
    public Handler mHandler;
    private byte[] mImageData;
    private Matrix mMatrix;
    private float mMaxScale;
    private int mMode;
    private Paint mPaint;
    private volatile int mState;
    private int mTop;
    private int mViewHeight;
    private int mViewWidth;
    private int width;

    public void setIsHeadImage(boolean z) {
        this.aia = z;
    }

    public a(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.ahL = false;
        this.mImageData = null;
        this.TO = 0;
        this.ahM = 1300;
        this.ahN = 0;
        this.ahO = null;
        this.ahP = null;
        this.TL = null;
        this.TN = null;
        this.ahR = 1.0f;
        this.Kh = 0;
        this.mMode = 0;
        this.ahS = false;
        this.ahT = false;
        this.ahU = 0;
        this.ahV = null;
        this.ahW = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.ahX = 0;
        this.ahY = 0;
        this.ahZ = 0;
        this.aib = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aic = 0;
        this.aid = null;
        this.aie = new BlockingLinkedDeque<>(5);
        this.aif = new BlockingLinkedDeque<>(6);
        this.aig = 0;
        this.aii = 0L;
        this.mState = 0;
        this.aij = true;
        this.mHandler = new Handler(new b(this));
        initData();
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.ahL = false;
        this.mImageData = null;
        this.TO = 0;
        this.ahM = 1300;
        this.ahN = 0;
        this.ahO = null;
        this.ahP = null;
        this.TL = null;
        this.TN = null;
        this.ahR = 1.0f;
        this.Kh = 0;
        this.mMode = 0;
        this.ahS = false;
        this.ahT = false;
        this.ahU = 0;
        this.ahV = null;
        this.ahW = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.ahX = 0;
        this.ahY = 0;
        this.ahZ = 0;
        this.aib = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aic = 0;
        this.aid = null;
        this.aie = new BlockingLinkedDeque<>(5);
        this.aif = new BlockingLinkedDeque<>(6);
        this.aig = 0;
        this.aii = 0L;
        this.mState = 0;
        this.aij = true;
        this.mHandler = new Handler(new b(this));
        initData();
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.ahL = false;
        this.mImageData = null;
        this.TO = 0;
        this.ahM = 1300;
        this.ahN = 0;
        this.ahO = null;
        this.ahP = null;
        this.TL = null;
        this.TN = null;
        this.ahR = 1.0f;
        this.Kh = 0;
        this.mMode = 0;
        this.ahS = false;
        this.ahT = false;
        this.ahU = 0;
        this.ahV = null;
        this.ahW = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.ahX = 0;
        this.ahY = 0;
        this.ahZ = 0;
        this.aib = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aic = 0;
        this.aid = null;
        this.aie = new BlockingLinkedDeque<>(5);
        this.aif = new BlockingLinkedDeque<>(6);
        this.aig = 0;
        this.aii = 0L;
        this.mState = 0;
        this.aij = true;
        this.mHandler = new Handler(new b(this));
        initData();
    }

    public int getImageType() {
        return this.Kh;
    }

    public void setImageMode(int i) {
        this.ahN = i;
    }

    public void setOffset(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.TO = i;
    }

    public void actionUp() {
        this.ahT = false;
        this.ahL = false;
        this.mMode = 0;
        zD();
        if (this.mCurrentScale < this.ahJ) {
            this.mCurrentScale = this.ahJ;
            zE();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.ahL = true;
                this.ahS = false;
                this.ahT = false;
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
            this.ahR = spacing(motionEvent);
            if (this.ahR > 10.0f) {
                this.mMode = 2;
            }
        }
        if (this.mMode == 2 || !this.mGestureDetector.onTouchEvent(motionEvent)) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.ahS = true;
                        this.ahT = true;
                        if (this.Kh != 1 && this.Kh != 2) {
                            float spacing = spacing(motionEvent);
                            if (spacing >= 0.0f && Math.abs(this.ahR - spacing) >= 10.0f) {
                                if (Math.abs(this.ahR - spacing) > 100.0f) {
                                    this.ahR = spacing;
                                    break;
                                } else {
                                    float f = spacing / this.ahR;
                                    this.ahR = spacing;
                                    this.ahK = this.mCurrentScale;
                                    this.mCurrentScale *= f;
                                    if (this.mCurrentScale > this.mMaxScale) {
                                        this.mCurrentScale = this.mMaxScale;
                                    }
                                    if (this.mCurrentScale < this.ahJ / 4.0f) {
                                        this.mCurrentScale = this.ahJ / 4.0f;
                                    }
                                    zE();
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

    public float spacing(MotionEvent motionEvent) {
        return CompatibleUtile.getInstance().getSpacing(motionEvent);
    }

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
        return this.ahJ == this.mCurrentScale;
    }

    private void reInitBitmap() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            if (this.ahN == 0) {
                float width = this.mViewWidth / imageBitmap.getWidth();
                float height = this.mViewHeight / imageBitmap.getHeight();
                if (this.aia) {
                    if (this.Kh == 2) {
                        this.ahJ = 2.5f;
                    } else {
                        this.ahJ = Math.min(width, height);
                    }
                } else if ((imageBitmap.getWidth() <= this.mViewWidth * 0.2f && imageBitmap.getHeight() <= this.mViewHeight * 0.2f) || this.Kh == 2) {
                    this.ahJ = 1.0f;
                } else if (imageBitmap.getWidth() <= this.mViewWidth * 0.4d && imageBitmap.getHeight() <= this.mViewHeight * 0.4d) {
                    this.ahJ = Math.min(width, height) * 0.6f;
                } else {
                    this.ahJ = Math.min(width, height);
                }
            } else {
                this.ahJ = Math.max(this.mViewWidth / imageBitmap.getWidth(), ((this.mViewHeight - this.mTop) - this.mBottom) / imageBitmap.getHeight());
            }
            this.mMaxScale = this.ahM / (imageBitmap.getHeight() * imageBitmap.getWidth());
            this.mMaxScale = FloatMath.sqrt(this.mMaxScale);
            if (this.mMaxScale > 10.0f) {
                this.mMaxScale = 10.0f;
            }
            this.ahI.clear();
            this.ahI.add(Float.valueOf(this.ahJ));
            this.mCurrentScale = this.ahJ;
            this.ahK = this.mCurrentScale;
            zE();
            zC();
            return;
        }
        this.ahG = 0.0f;
        this.ahH = 0.0f;
        this.ahJ = 1.0f;
        this.mMaxScale = 1.0f;
        this.mCurrentScale = 1.0f;
        this.ahK = this.mCurrentScale;
        this.ahI.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    public void zC() {
        if (this.ahO != null) {
            this.ahO.a(this, canZoomIn(), canZoomOut());
        }
    }

    public void setOnSizeChangedListener(h hVar) {
        this.ahO = hVar;
    }

    public byte[] getImageData() {
        return this.mImageData;
    }

    public void setImageData(byte[] bArr) {
        this.mImageData = bArr;
    }

    public Bitmap getGifCache() {
        return this.ahW;
    }

    public void setGifCache(Bitmap bitmap) {
        this.ahW = bitmap;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.Kh == 2 && this.ahZ != 0 && !this.ahQ.zH()) {
            int width = getWidth();
            int height = getHeight();
            Drawable drawable = getDrawable();
            float f = 0.0f;
            float f2 = height * 0.3f;
            float f3 = width;
            float f4 = (1.0f - 0.3f) * height;
            if (this.aia && drawable != null) {
                Rect bounds = drawable.getBounds();
                int i = bounds.right - bounds.left;
                int i2 = bounds.bottom - bounds.top;
                f = (width / 2) - (i * 2.5f);
                f2 = (height / 2) - (i2 * 2.5f);
                f3 = (i * 2.5f) + (width / 2);
                f4 = (i2 * 2.5f) + (height / 2);
            }
            this.mPaint.setColor(ax.getColor(this.ahZ));
            canvas.drawRect(f, f2, f3, f4, this.mPaint);
            this.mPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        }
        super.onDraw(canvas);
        if (this.Kh == 1 && this.ahW != null && !this.ahW.isRecycled()) {
            int width2 = this.ahW.getWidth();
            int height2 = this.ahW.getHeight();
            int width3 = getWidth();
            int height3 = getHeight();
            int i3 = (width3 - width2) >> 1;
            int i4 = (height3 - height2) >> 1;
            boolean z = false;
            if (i3 < 0 || i4 < 0) {
                float min = Math.min(width3 / width2, height3 / height2);
                this.mMatrix.setScale(min, min);
                i3 = (int) ((width3 - (width2 * min)) / 2.0f);
                i4 = (int) ((height3 - (height2 * min)) / 2.0f);
                this.mMatrix.postTranslate(i3, i4);
                width2 = (int) (width2 * min);
                height2 = (int) (height2 * min);
            } else {
                z = true;
            }
            canvas.clipRect(i3, i4, width2 + i3, height2 + i4);
            canvas.drawColor(-1);
            if (this.ahU == 1 && this.ahV != null && this.aid != null && this.aid.air != null) {
                if (z) {
                    canvas.drawBitmap(this.aid.air, i3, i4, (Paint) null);
                } else {
                    canvas.drawBitmap(this.aid.air, this.mMatrix, this.mPaint);
                }
                invalidate();
            } else if (z) {
                canvas.drawBitmap(this.ahW, i3, i4, (Paint) null);
            } else {
                canvas.drawBitmap(this.ahW, this.mMatrix, this.mPaint);
            }
        }
    }

    public void play() {
        if (this.Kh == 1) {
            if (this.ahV == null) {
                if (this.aih != null) {
                    this.aih.interrupt();
                    this.aih = null;
                }
                com.baidu.adp.widget.a.a d = com.baidu.adp.gif.b.bJ().d(this.mImageData, 0, this.mImageData.length);
                if (d != null && d.getGif() != null) {
                    this.ahV = d.getGif();
                    if (this.ahV != null) {
                        this.ahU = 1;
                        this.width = this.ahV.getWidth();
                        this.height = this.ahV.getHeight();
                        this.aig = 0;
                        this.aic = this.ahV.bK();
                    } else {
                        this.ahU = 0;
                    }
                } else {
                    return;
                }
            }
            if (this.ahV != null && this.mState == 0) {
                this.aij = true;
                this.aih = new e(this, null);
                this.aie.clear();
                this.aif.clear();
                this.mState = 1;
                this.aih.start();
            }
        }
    }

    public void pause() {
        if (this.Kh == 1) {
            this.mState = 0;
            if (this.aih != null) {
                this.aih.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.Kh == 1) {
            this.mState = 0;
            if (this.aih != null) {
                this.aih.interrupt();
                this.aih = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.aij = true;
            this.aid = null;
            this.aif.clear();
            this.aie.clear();
            this.width = 0;
            this.height = 0;
            this.aig = 0;
            this.aic = 0;
            if (this.ahV != null) {
                this.ahV = null;
            }
        }
    }

    private void initData() {
        this.ahM = com.baidu.adp.lib.util.l.N(getContext()) * com.baidu.adp.lib.util.l.M(getContext()) * 2;
        if (this.ahM < 1690000) {
            this.ahM = 1690000;
        }
        this.ahG = 0.0f;
        this.ahH = 0.0f;
        this.ahI = new ArrayList<>();
        this.ahJ = 1.0f;
        this.mMaxScale = 1.0f;
        this.mCurrentScale = 1.0f;
        this.ahK = this.mCurrentScale;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.ahQ = new d(this);
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWillNotDraw(false);
        scrollTo(0, 0);
        this.mGestureDetector = new GestureDetector(getContext(), new c(this));
    }

    private void zD() {
        int i = 0;
        int scrollX = getScrollX();
        if (this.ahG >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.ahG) {
                scrollX = (int) (this.ahG - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.ahH + this.mTop + this.mBottom >= getHeight()) {
            i = scrollY < (-this.ahX) ? -this.ahX : scrollY;
            if (getHeight() + i > this.ahH + this.mBottom + this.ahY) {
                i = (int) ((this.ahH - getHeight()) + this.mBottom + this.ahY);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.ahG;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.ahH;
    }

    public boolean onRightSide() {
        if (this.Kh == 1 || this.Kh == 2) {
            return true;
        }
        return !this.ahT && getScrollX() >= ((int) (this.ahG - ((float) getWidth()))) + (-1);
    }

    public boolean onLeftSide() {
        if (this.Kh == 1 || this.Kh == 2) {
            return true;
        }
        return !this.ahT && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.ahQ.zH()) {
            this.ahQ.stopAnimation();
        }
        this.ahZ = 0;
        super.setImageBitmap(bitmap);
        reInitBitmap();
        this.Kh = 0;
    }

    public void replaceImageBitmap(Bitmap bitmap) {
        Bitmap imageBitmap = getImageBitmap();
        if (bitmap != null && !bitmap.isRecycled()) {
            if (imageBitmap != null && (imageBitmap.getWidth() != bitmap.getWidth() || imageBitmap.getHeight() != bitmap.getHeight())) {
                setImageBitmap(bitmap);
                return;
            }
            if (this.ahQ.zH()) {
                this.ahQ.stopAnimation();
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            super.setImageBitmap(bitmap);
            super.setImageMatrix(this.mMatrix);
            scrollTo(scrollX, scrollY);
            this.Kh = 0;
        }
    }

    public void a(byte[] bArr, Bitmap bitmap) {
        if (this.ahQ.zH()) {
            this.ahQ.stopAnimation();
        }
        super.setImageDrawable(null);
        stop();
        reInitBitmap();
        this.Kh = 1;
        this.ahW = bitmap;
        this.mImageData = bArr;
        if (this.TN != null) {
            this.TN.a(this);
        }
    }

    public void onDestroy() {
        if (this.ahQ.zH()) {
            this.ahQ.stopAnimation();
        }
        super.setImageDrawable(null);
        this.mImageData = null;
        this.ahW = null;
        stop();
        if (this.ahV != null) {
            this.ahV.close();
            this.ahV = null;
        }
    }

    public void release() {
        if (this.ahQ.zH()) {
            this.ahQ.stopAnimation();
        }
        stop();
        super.setImageDrawable(null);
        this.ahW = null;
    }

    public void setDefaultBitmap() {
        if (this.ahQ.zH()) {
            this.ahQ.stopAnimation();
        }
        if (this.aia) {
            super.setImageBitmap(com.baidu.tbadk.core.util.d.bI(v.icon_default_avatar100));
        } else {
            super.setImageBitmap(com.baidu.tbadk.core.util.d.bI(v.btn_see_default));
        }
        this.Kh = 2;
        reInitBitmap();
    }

    public void zoomInBitmap() {
        if (this.Kh != 1 && this.Kh != 2) {
            int size = this.ahI.size();
            if (size > 0) {
                this.ahI.add(Float.valueOf(this.ahI.get(size - 1).floatValue() * 1.25f));
            } else {
                this.ahI.add(Float.valueOf(this.ahJ));
            }
            zE();
            zC();
        }
    }

    public void zoomOutBitmap() {
        if (this.Kh != 1 && this.Kh != 2) {
            int size = this.ahI.size();
            if (size > 1) {
                this.ahI.remove(size - 1);
            }
            zE();
            zC();
        }
    }

    public void restoreSize() {
        zC();
        if (this.Kh != 1 && this.Kh != 2 && this.mCurrentScale != this.ahJ) {
            this.ahI.clear();
            this.ahI.add(Float.valueOf(this.ahJ));
            this.mCurrentScale = this.ahJ;
            this.ahK = this.mCurrentScale;
            zE();
        }
    }

    public boolean canZoomIn() {
        if (this.Kh == 1 || this.Kh == 2) {
            return false;
        }
        int size = this.ahI.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.ahI.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.ahM) && floatValue <= 5.0f;
    }

    public boolean canZoomOut() {
        if (this.Kh == 1 || this.Kh == 2) {
            return false;
        }
        int size = this.ahI.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled()) {
            return false;
        }
        return size > 1;
    }

    public void zE() {
        e(false, -1, -1);
    }

    public void e(boolean z, int i, int i2) {
        float f;
        float f2;
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled()) {
            try {
                if (this.mMode != 2) {
                    int size = this.ahI.size();
                    if (size > 0) {
                        f2 = this.ahI.get(size - 1).floatValue();
                    } else {
                        f2 = this.ahJ;
                    }
                    this.mCurrentScale = f2;
                }
                this.mMatrix.setScale(this.mCurrentScale, this.mCurrentScale);
                this.ahG = imageBitmap.getWidth() * this.mCurrentScale;
                this.ahH = imageBitmap.getHeight() * this.mCurrentScale;
                float width = this.ahK * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.ahK;
                this.ahX = this.mTop;
                this.ahY = 0;
                float f3 = this.ahG < ((float) this.mViewWidth) ? (int) ((this.mViewWidth - this.ahG) / 2.0f) : 0.0f;
                if (this.ahH < this.mViewHeight) {
                    f = (int) ((this.mViewHeight - this.ahH) / 2.0f);
                    if (this.ahN == 1 && f > this.mTop) {
                        f = this.mTop;
                    }
                    this.ahX = (int) (this.mTop - f);
                    this.ahY = this.mTop - this.ahX;
                } else {
                    f = 0.0f;
                }
                this.mMatrix.postTranslate(f3, f);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    scrollX = i > getWidth() ? getWidth() : i;
                    if (this.ahG <= screenWidth) {
                        scrollX = 0;
                    } else if (this.ahG > screenWidth && this.ahG / 2.0f < screenWidth) {
                        scrollX = (int) (scrollX - (this.ahG / 4.0f));
                    }
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.ahG - width) / 2.0f);
                    }
                    if (this.ahG <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.ahG) {
                        scrollX = (int) (this.ahG - getWidth());
                    }
                }
                if (this.mMode == 2) {
                    scrollY += (int) ((this.ahH - height) / 2.0f);
                }
                if (this.ahH <= getHeight()) {
                    scrollY = 0;
                } else if (getHeight() + scrollY > this.ahH) {
                    scrollY = (int) (this.ahH - getHeight());
                }
                setHorizontalScrollBarEnabled(false);
                setVerticalScrollBarEnabled(false);
                if (scrollX < 0) {
                    scrollX = 0;
                }
                if (scrollY < 0) {
                    scrollY = 0;
                }
                scrollTo(scrollX, scrollY);
                setImageMatrix(this.mMatrix);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.ahP = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.TL = onLongClickListener;
    }

    public void setGifSetListener(g gVar) {
        this.TN = gVar;
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

    public void zF() {
        long j;
        f poll = this.aie.poll();
        if (poll == null) {
            this.aij = true;
            return;
        }
        this.aij = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.aid != null) {
            j = this.aid.delay - (currentTimeMillis - this.aii);
            this.aif.offer(this.aid);
        } else {
            j = 0;
        }
        this.aid = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public f zG() {
        f poll = this.aif.poll();
        if (poll == null) {
            f fVar = new f(null);
            fVar.air = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
            return fVar;
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
}
