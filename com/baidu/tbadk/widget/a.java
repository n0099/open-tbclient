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
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.v;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends ImageView {
    private int Kx;
    private View.OnLongClickListener Un;
    private g Up;
    private int Uq;
    private float aiA;
    private Interpolator aiB;
    private int aiC;
    private f aiD;
    private BlockingLinkedDeque<f> aiE;
    private BlockingLinkedDeque<f> aiF;
    private volatile int aiG;
    private e aiH;
    private volatile long aiI;
    private volatile boolean aiJ;
    private float aif;
    private float aig;
    private ArrayList<Float> aih;
    private float aii;
    private float aij;
    private boolean aik;
    private int ail;
    private int aim;
    private h ain;
    private View.OnClickListener aio;
    private d aip;
    private float aiq;
    private boolean air;
    private boolean ais;
    private int ait;
    private volatile com.baidu.adp.gif.c aiu;
    private Bitmap aiv;
    private int aiw;
    private int aix;
    private int aiy;
    private boolean aiz;
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
        this.aiz = z;
    }

    public a(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aik = false;
        this.mImageData = null;
        this.Uq = 0;
        this.ail = 1300;
        this.aim = 0;
        this.ain = null;
        this.aio = null;
        this.Un = null;
        this.Up = null;
        this.aiq = 1.0f;
        this.Kx = 0;
        this.mMode = 0;
        this.air = false;
        this.ais = false;
        this.ait = 0;
        this.aiu = null;
        this.aiv = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aiw = 0;
        this.aix = 0;
        this.aiy = 0;
        this.aiB = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aiC = 0;
        this.aiD = null;
        this.aiE = new BlockingLinkedDeque<>(5);
        this.aiF = new BlockingLinkedDeque<>(6);
        this.aiG = 0;
        this.aiI = 0L;
        this.mState = 0;
        this.aiJ = true;
        this.mHandler = new Handler(new b(this));
        initData();
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aik = false;
        this.mImageData = null;
        this.Uq = 0;
        this.ail = 1300;
        this.aim = 0;
        this.ain = null;
        this.aio = null;
        this.Un = null;
        this.Up = null;
        this.aiq = 1.0f;
        this.Kx = 0;
        this.mMode = 0;
        this.air = false;
        this.ais = false;
        this.ait = 0;
        this.aiu = null;
        this.aiv = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aiw = 0;
        this.aix = 0;
        this.aiy = 0;
        this.aiB = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aiC = 0;
        this.aiD = null;
        this.aiE = new BlockingLinkedDeque<>(5);
        this.aiF = new BlockingLinkedDeque<>(6);
        this.aiG = 0;
        this.aiI = 0L;
        this.mState = 0;
        this.aiJ = true;
        this.mHandler = new Handler(new b(this));
        initData();
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aik = false;
        this.mImageData = null;
        this.Uq = 0;
        this.ail = 1300;
        this.aim = 0;
        this.ain = null;
        this.aio = null;
        this.Un = null;
        this.Up = null;
        this.aiq = 1.0f;
        this.Kx = 0;
        this.mMode = 0;
        this.air = false;
        this.ais = false;
        this.ait = 0;
        this.aiu = null;
        this.aiv = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aiw = 0;
        this.aix = 0;
        this.aiy = 0;
        this.aiB = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aiC = 0;
        this.aiD = null;
        this.aiE = new BlockingLinkedDeque<>(5);
        this.aiF = new BlockingLinkedDeque<>(6);
        this.aiG = 0;
        this.aiI = 0L;
        this.mState = 0;
        this.aiJ = true;
        this.mHandler = new Handler(new b(this));
        initData();
    }

    public int getImageType() {
        return this.Kx;
    }

    public void setImageMode(int i) {
        this.aim = i;
    }

    public void setOffset(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.Uq = i;
    }

    public void actionUp() {
        this.ais = false;
        this.aik = false;
        this.mMode = 0;
        zR();
        if (this.mCurrentScale < this.aii) {
            this.mCurrentScale = this.aii;
            zS();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.aik = true;
                this.air = false;
                this.ais = false;
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
            this.aiq = spacing(motionEvent);
            if (this.aiq > 10.0f) {
                this.mMode = 2;
            }
        }
        if (this.mMode == 2 || !this.mGestureDetector.onTouchEvent(motionEvent)) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.air = true;
                        this.ais = true;
                        if (this.Kx != 1 && this.Kx != 2) {
                            float spacing = spacing(motionEvent);
                            if (spacing >= 0.0f && Math.abs(this.aiq - spacing) >= 10.0f) {
                                if (Math.abs(this.aiq - spacing) > 100.0f) {
                                    this.aiq = spacing;
                                    break;
                                } else {
                                    float f = spacing / this.aiq;
                                    this.aiq = spacing;
                                    this.aij = this.mCurrentScale;
                                    this.mCurrentScale *= f;
                                    if (this.mCurrentScale > this.mMaxScale) {
                                        this.mCurrentScale = this.mMaxScale;
                                    }
                                    if (this.mCurrentScale < this.aii / 4.0f) {
                                        this.mCurrentScale = this.aii / 4.0f;
                                    }
                                    zS();
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
        return this.aii == this.mCurrentScale;
    }

    private void reInitBitmap() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            if (this.aim == 0) {
                float width = this.mViewWidth / imageBitmap.getWidth();
                float height = this.mViewHeight / imageBitmap.getHeight();
                if (this.aiz) {
                    if (this.Kx == 2) {
                        this.aii = 2.5f;
                    } else {
                        this.aii = Math.min(width, height);
                    }
                } else if (this.Kx == 2) {
                    this.aii = 1.0f;
                } else {
                    float f = this.aiA;
                    float f2 = f >= 1.0f ? f : 1.0f;
                    if (imageBitmap.getWidth() * f2 < this.mViewWidth && imageBitmap.getHeight() * f2 < this.mViewHeight) {
                        this.aii = f2;
                    } else {
                        this.aii = Math.min(width, height);
                    }
                }
            } else {
                this.aii = Math.max(this.mViewWidth / imageBitmap.getWidth(), ((this.mViewHeight - this.mTop) - this.mBottom) / imageBitmap.getHeight());
            }
            this.mMaxScale = this.ail / (imageBitmap.getWidth() * imageBitmap.getHeight());
            this.mMaxScale = FloatMath.sqrt(this.mMaxScale);
            if (this.mMaxScale > 10.0f) {
                this.mMaxScale = 10.0f;
            }
            this.aih.clear();
            this.aih.add(Float.valueOf(this.aii));
            this.mCurrentScale = this.aii;
            this.aij = this.mCurrentScale;
            zS();
            zQ();
            return;
        }
        this.aif = 0.0f;
        this.aig = 0.0f;
        this.aii = 1.0f;
        this.mMaxScale = 1.0f;
        this.mCurrentScale = 1.0f;
        this.aij = this.mCurrentScale;
        this.aih.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    public void zQ() {
        if (this.ain != null) {
            this.ain.a(this, canZoomIn(), canZoomOut());
        }
    }

    public void setOnSizeChangedListener(h hVar) {
        this.ain = hVar;
    }

    public byte[] getImageData() {
        return this.mImageData;
    }

    public void setImageData(byte[] bArr) {
        this.mImageData = bArr;
    }

    public Bitmap getGifCache() {
        return this.aiv;
    }

    public void setGifCache(Bitmap bitmap) {
        this.aiv = bitmap;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        boolean z;
        int i4;
        if (this.Kx == 2 && this.aiy != 0 && !this.aip.zV()) {
            int width = getWidth();
            int height = getHeight();
            Drawable drawable = getDrawable();
            float f = 0.0f;
            float f2 = height * 0.3f;
            float f3 = width;
            float f4 = (1.0f - 0.3f) * height;
            if (this.aiz && drawable != null) {
                Rect bounds = drawable.getBounds();
                int i5 = bounds.right - bounds.left;
                int i6 = bounds.bottom - bounds.top;
                f = (width / 2) - (i5 * 2.5f);
                f2 = (height / 2) - (i6 * 2.5f);
                f3 = (i5 * 2.5f) + (width / 2);
                f4 = (i6 * 2.5f) + (height / 2);
            }
            this.mPaint.setColor(bc.getColor(this.aiy));
            canvas.drawRect(f, f2, f3, f4, this.mPaint);
            this.mPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        }
        super.onDraw(canvas);
        if (this.Kx == 1 && this.aiv != null && !this.aiv.isRecycled()) {
            int width2 = this.aiv.getWidth();
            int height2 = this.aiv.getHeight();
            int width3 = getWidth();
            int height3 = getHeight();
            int i7 = (width3 - width2) >> 1;
            int i8 = (height3 - height2) >> 1;
            float f5 = this.aiA;
            if (f5 < 1.0f) {
                f5 = 1.0f;
            }
            if (width2 * f5 >= width3 || height2 * f5 >= height3) {
                f5 = Math.min(width3 / width2, height3 / height2);
            }
            if (Math.abs(f5 - 1.0f) < 1.0E-8f) {
                z = true;
                i4 = height2;
                i = width2;
                i2 = i8;
                i3 = i7;
            } else {
                this.mMatrix.setScale(f5, f5);
                int i9 = (int) ((width3 - (width2 * f5)) / 2.0f);
                int i10 = (int) ((height3 - (height2 * f5)) / 2.0f);
                this.mMatrix.postTranslate(i9, i10);
                int i11 = (int) (f5 * height2);
                i = (int) (width2 * f5);
                i2 = i10;
                i3 = i9;
                z = false;
                i4 = i11;
            }
            canvas.clipRect(i3, i2, i + i3, i4 + i2);
            canvas.drawColor(-1);
            if (this.ait == 1 && this.aiu != null && this.aiD != null && this.aiD.aiR != null) {
                if (z) {
                    canvas.drawBitmap(this.aiD.aiR, i3, i2, (Paint) null);
                } else {
                    canvas.drawBitmap(this.aiD.aiR, this.mMatrix, this.mPaint);
                }
                invalidate();
            } else if (z) {
                canvas.drawBitmap(this.aiv, i3, i2, (Paint) null);
            } else {
                canvas.drawBitmap(this.aiv, this.mMatrix, this.mPaint);
            }
        }
    }

    public void play() {
        if (this.Kx == 1) {
            if (this.aiu == null) {
                if (this.aiH != null) {
                    this.aiH.interrupt();
                    this.aiH = null;
                }
                com.baidu.adp.widget.a.a d = com.baidu.adp.gif.b.bH().d(this.mImageData, 0, this.mImageData.length);
                if (d != null && d.getGif() != null) {
                    this.aiu = d.getGif();
                    if (this.aiu != null) {
                        this.ait = 1;
                        this.width = this.aiu.getWidth();
                        this.height = this.aiu.getHeight();
                        this.aiG = 0;
                        this.aiC = this.aiu.bI();
                    } else {
                        this.ait = 0;
                    }
                } else {
                    return;
                }
            }
            if (this.aiu != null && this.mState == 0) {
                this.aiJ = true;
                this.aiH = new e(this, null);
                this.aiE.clear();
                this.aiF.clear();
                this.mState = 1;
                this.aiH.start();
            }
        }
    }

    public void pause() {
        if (this.Kx == 1) {
            this.mState = 0;
            if (this.aiH != null) {
                this.aiH.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.Kx == 1) {
            this.mState = 0;
            if (this.aiH != null) {
                this.aiH.interrupt();
                this.aiH = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.aiJ = true;
            this.aiD = null;
            this.aiF.clear();
            this.aiE.clear();
            this.width = 0;
            this.height = 0;
            this.aiG = 0;
            this.aiC = 0;
            if (this.aiu != null) {
                this.aiu = null;
            }
        }
    }

    private void initData() {
        this.aiA = com.baidu.adp.lib.util.l.O(getContext());
        this.ail = com.baidu.adp.lib.util.l.N(getContext()) * com.baidu.adp.lib.util.l.M(getContext()) * 2;
        if (this.ail < 1690000) {
            this.ail = 1690000;
        }
        this.aif = 0.0f;
        this.aig = 0.0f;
        this.aih = new ArrayList<>();
        this.aii = 1.0f;
        this.mMaxScale = 1.0f;
        this.mCurrentScale = 1.0f;
        this.aij = this.mCurrentScale;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.aip = new d(this);
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWillNotDraw(false);
        scrollTo(0, 0);
        this.mGestureDetector = new GestureDetector(getContext(), new c(this));
    }

    private void zR() {
        int i = 0;
        int scrollX = getScrollX();
        if (this.aif >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.aif) {
                scrollX = (int) (this.aif - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.aig + this.mTop + this.mBottom >= getHeight()) {
            i = scrollY < (-this.aiw) ? -this.aiw : scrollY;
            if (getHeight() + i > this.aig + this.mBottom + this.aix) {
                i = (int) ((this.aig - getHeight()) + this.mBottom + this.aix);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.aif;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.aig;
    }

    public boolean onRightSide() {
        if (this.Kx == 1 || this.Kx == 2) {
            return true;
        }
        return !this.ais && getScrollX() >= ((int) (this.aif - ((float) getWidth()))) + (-1);
    }

    public boolean onLeftSide() {
        if (this.Kx == 1 || this.Kx == 2) {
            return true;
        }
        return !this.ais && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.aip.zV()) {
            this.aip.stopAnimation();
        }
        this.aiy = 0;
        super.setImageBitmap(bitmap);
        reInitBitmap();
        this.Kx = 0;
    }

    public void replaceImageBitmap(Bitmap bitmap) {
        Bitmap imageBitmap = getImageBitmap();
        if (bitmap != null && !bitmap.isRecycled()) {
            if (imageBitmap != null && (imageBitmap.getWidth() != bitmap.getWidth() || imageBitmap.getHeight() != bitmap.getHeight())) {
                setImageBitmap(bitmap);
                return;
            }
            if (this.aip.zV()) {
                this.aip.stopAnimation();
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            super.setImageBitmap(bitmap);
            super.setImageMatrix(this.mMatrix);
            scrollTo(scrollX, scrollY);
            this.Kx = 0;
        }
    }

    public void a(byte[] bArr, Bitmap bitmap) {
        if (this.aip.zV()) {
            this.aip.stopAnimation();
        }
        super.setImageDrawable(null);
        stop();
        reInitBitmap();
        this.Kx = 1;
        this.aiv = bitmap;
        this.mImageData = bArr;
        if (this.Up != null) {
            this.Up.a(this);
        }
    }

    public void onDestroy() {
        if (this.aip.zV()) {
            this.aip.stopAnimation();
        }
        super.setImageDrawable(null);
        this.mImageData = null;
        this.aiv = null;
        stop();
        if (this.aiu != null) {
            this.aiu.close();
            this.aiu = null;
        }
    }

    public void release() {
        if (this.aip.zV()) {
            this.aip.stopAnimation();
        }
        stop();
        super.setImageDrawable(null);
        this.aiv = null;
    }

    public void setDefaultBitmap() {
        if (this.aip.zV()) {
            this.aip.stopAnimation();
        }
        if (this.aiz) {
            super.setImageBitmap(com.baidu.tbadk.core.util.d.bN(v.icon_default_avatar100));
        } else {
            super.setImageBitmap(com.baidu.tbadk.core.util.d.bN(v.btn_see_default));
        }
        this.Kx = 2;
        reInitBitmap();
    }

    public void zoomInBitmap() {
        if (this.Kx != 1 && this.Kx != 2) {
            int size = this.aih.size();
            if (size > 0) {
                this.aih.add(Float.valueOf(this.aih.get(size - 1).floatValue() * 1.25f));
            } else {
                this.aih.add(Float.valueOf(this.aii));
            }
            zS();
            zQ();
        }
    }

    public void zoomOutBitmap() {
        if (this.Kx != 1 && this.Kx != 2) {
            int size = this.aih.size();
            if (size > 1) {
                this.aih.remove(size - 1);
            }
            zS();
            zQ();
        }
    }

    public void restoreSize() {
        zQ();
        if (this.Kx != 1 && this.Kx != 2 && this.mCurrentScale != this.aii) {
            this.aih.clear();
            this.aih.add(Float.valueOf(this.aii));
            this.mCurrentScale = this.aii;
            this.aij = this.mCurrentScale;
            zS();
        }
    }

    public boolean canZoomIn() {
        if (this.Kx == 1 || this.Kx == 2) {
            return false;
        }
        int size = this.aih.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.aih.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.ail) && floatValue <= 5.0f;
    }

    public boolean canZoomOut() {
        if (this.Kx == 1 || this.Kx == 2) {
            return false;
        }
        int size = this.aih.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled()) {
            return false;
        }
        return size > 1;
    }

    public void zS() {
        e(false, -1, -1);
    }

    public void e(boolean z, int i, int i2) {
        float f;
        float f2;
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled()) {
            try {
                if (this.mMode != 2) {
                    int size = this.aih.size();
                    if (size > 0) {
                        f2 = this.aih.get(size - 1).floatValue();
                    } else {
                        f2 = this.aii;
                    }
                    this.mCurrentScale = f2;
                }
                this.mMatrix.setScale(this.mCurrentScale, this.mCurrentScale);
                this.aif = imageBitmap.getWidth() * this.mCurrentScale;
                this.aig = imageBitmap.getHeight() * this.mCurrentScale;
                float width = this.aij * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.aij;
                this.aiw = this.mTop;
                this.aix = 0;
                float f3 = this.aif < ((float) this.mViewWidth) ? (int) ((this.mViewWidth - this.aif) / 2.0f) : 0.0f;
                if (this.aig < this.mViewHeight) {
                    f = (int) ((this.mViewHeight - this.aig) / 2.0f);
                    if (this.aim == 1 && f > this.mTop) {
                        f = this.mTop;
                    }
                    this.aiw = (int) (this.mTop - f);
                    this.aix = this.mTop - this.aiw;
                } else {
                    f = 0.0f;
                }
                this.mMatrix.postTranslate(f3, f);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    scrollX = i > getWidth() ? getWidth() : i;
                    if (this.aif <= screenWidth) {
                        scrollX = 0;
                    } else if (this.aif > screenWidth && this.aif / 2.0f < screenWidth) {
                        scrollX = (int) (scrollX - (this.aif / 4.0f));
                    }
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.aif - width) / 2.0f);
                    }
                    if (this.aif <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.aif) {
                        scrollX = (int) (this.aif - getWidth());
                    }
                }
                if (this.mMode == 2) {
                    scrollY += (int) ((this.aig - height) / 2.0f);
                }
                if (this.aig <= getHeight()) {
                    scrollY = 0;
                } else if (getHeight() + scrollY > this.aig) {
                    scrollY = (int) (this.aig - getHeight());
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
        this.aio = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.Un = onLongClickListener;
    }

    public void setGifSetListener(g gVar) {
        this.Up = gVar;
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

    public void zT() {
        long j;
        f poll = this.aiE.poll();
        if (poll == null) {
            this.aiJ = true;
            return;
        }
        this.aiJ = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.aiD != null) {
            j = this.aiD.delay - (currentTimeMillis - this.aiI);
            this.aiF.offer(this.aiD);
        } else {
            j = 0;
        }
        this.aiD = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public f zU() {
        f poll = this.aiF.poll();
        if (poll == null) {
            f fVar = new f(null);
            fVar.aiR = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
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
