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
    private int KA;
    private View.OnLongClickListener Uq;
    private g Us;
    private int Ut;
    private int aiA;
    private int aiB;
    private boolean aiC;
    private float aiD;
    private Interpolator aiE;
    private int aiF;
    private f aiG;
    private BlockingLinkedDeque<f> aiH;
    private BlockingLinkedDeque<f> aiI;
    private volatile int aiJ;
    private e aiK;
    private volatile long aiL;
    private volatile boolean aiM;
    private float aii;
    private float aij;
    private ArrayList<Float> aik;
    private float ail;
    private float aim;
    private boolean ain;
    private int aio;
    private int aip;
    private h aiq;
    private View.OnClickListener air;
    private d ais;
    private float ait;
    private boolean aiu;
    private boolean aiv;
    private int aiw;
    private volatile com.baidu.adp.gif.c aix;
    private Bitmap aiy;
    private int aiz;
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
        this.aiC = z;
    }

    public a(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.ain = false;
        this.mImageData = null;
        this.Ut = 0;
        this.aio = 1300;
        this.aip = 0;
        this.aiq = null;
        this.air = null;
        this.Uq = null;
        this.Us = null;
        this.ait = 1.0f;
        this.KA = 0;
        this.mMode = 0;
        this.aiu = false;
        this.aiv = false;
        this.aiw = 0;
        this.aix = null;
        this.aiy = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aiz = 0;
        this.aiA = 0;
        this.aiB = 0;
        this.aiE = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aiF = 0;
        this.aiG = null;
        this.aiH = new BlockingLinkedDeque<>(5);
        this.aiI = new BlockingLinkedDeque<>(6);
        this.aiJ = 0;
        this.aiL = 0L;
        this.mState = 0;
        this.aiM = true;
        this.mHandler = new Handler(new b(this));
        initData();
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.ain = false;
        this.mImageData = null;
        this.Ut = 0;
        this.aio = 1300;
        this.aip = 0;
        this.aiq = null;
        this.air = null;
        this.Uq = null;
        this.Us = null;
        this.ait = 1.0f;
        this.KA = 0;
        this.mMode = 0;
        this.aiu = false;
        this.aiv = false;
        this.aiw = 0;
        this.aix = null;
        this.aiy = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aiz = 0;
        this.aiA = 0;
        this.aiB = 0;
        this.aiE = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aiF = 0;
        this.aiG = null;
        this.aiH = new BlockingLinkedDeque<>(5);
        this.aiI = new BlockingLinkedDeque<>(6);
        this.aiJ = 0;
        this.aiL = 0L;
        this.mState = 0;
        this.aiM = true;
        this.mHandler = new Handler(new b(this));
        initData();
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.ain = false;
        this.mImageData = null;
        this.Ut = 0;
        this.aio = 1300;
        this.aip = 0;
        this.aiq = null;
        this.air = null;
        this.Uq = null;
        this.Us = null;
        this.ait = 1.0f;
        this.KA = 0;
        this.mMode = 0;
        this.aiu = false;
        this.aiv = false;
        this.aiw = 0;
        this.aix = null;
        this.aiy = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aiz = 0;
        this.aiA = 0;
        this.aiB = 0;
        this.aiE = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aiF = 0;
        this.aiG = null;
        this.aiH = new BlockingLinkedDeque<>(5);
        this.aiI = new BlockingLinkedDeque<>(6);
        this.aiJ = 0;
        this.aiL = 0L;
        this.mState = 0;
        this.aiM = true;
        this.mHandler = new Handler(new b(this));
        initData();
    }

    public int getImageType() {
        return this.KA;
    }

    public void setImageMode(int i) {
        this.aip = i;
    }

    public void setOffset(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.Ut = i;
    }

    public void actionUp() {
        this.aiv = false;
        this.ain = false;
        this.mMode = 0;
        zX();
        if (this.mCurrentScale < this.ail) {
            this.mCurrentScale = this.ail;
            zY();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.ain = true;
                this.aiu = false;
                this.aiv = false;
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
            this.ait = spacing(motionEvent);
            if (this.ait > 10.0f) {
                this.mMode = 2;
            }
        }
        if (this.mMode == 2 || !this.mGestureDetector.onTouchEvent(motionEvent)) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.aiu = true;
                        this.aiv = true;
                        if (this.KA != 1 && this.KA != 2) {
                            float spacing = spacing(motionEvent);
                            if (spacing >= 0.0f && Math.abs(this.ait - spacing) >= 10.0f) {
                                if (Math.abs(this.ait - spacing) > 100.0f) {
                                    this.ait = spacing;
                                    break;
                                } else {
                                    float f = spacing / this.ait;
                                    this.ait = spacing;
                                    this.aim = this.mCurrentScale;
                                    this.mCurrentScale *= f;
                                    if (this.mCurrentScale > this.mMaxScale) {
                                        this.mCurrentScale = this.mMaxScale;
                                    }
                                    if (this.mCurrentScale < this.ail / 4.0f) {
                                        this.mCurrentScale = this.ail / 4.0f;
                                    }
                                    zY();
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
        return this.ail == this.mCurrentScale;
    }

    private void reInitBitmap() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            if (this.aip == 0) {
                float width = this.mViewWidth / imageBitmap.getWidth();
                float height = this.mViewHeight / imageBitmap.getHeight();
                if (this.aiC) {
                    if (this.KA == 2) {
                        this.ail = 2.5f;
                    } else {
                        this.ail = Math.min(width, height);
                    }
                } else if (this.KA == 2) {
                    this.ail = 1.0f;
                } else {
                    float f = this.aiD;
                    float f2 = f >= 1.0f ? f : 1.0f;
                    if (imageBitmap.getWidth() * f2 < this.mViewWidth && imageBitmap.getHeight() * f2 < this.mViewHeight) {
                        this.ail = f2;
                    } else {
                        this.ail = Math.min(width, height);
                    }
                }
            } else {
                this.ail = Math.max(this.mViewWidth / imageBitmap.getWidth(), ((this.mViewHeight - this.mTop) - this.mBottom) / imageBitmap.getHeight());
            }
            this.mMaxScale = this.aio / (imageBitmap.getWidth() * imageBitmap.getHeight());
            this.mMaxScale = FloatMath.sqrt(this.mMaxScale);
            if (this.mMaxScale > 10.0f) {
                this.mMaxScale = 10.0f;
            }
            this.aik.clear();
            this.aik.add(Float.valueOf(this.ail));
            this.mCurrentScale = this.ail;
            this.aim = this.mCurrentScale;
            zY();
            zW();
            return;
        }
        this.aii = 0.0f;
        this.aij = 0.0f;
        this.ail = 1.0f;
        this.mMaxScale = 1.0f;
        this.mCurrentScale = 1.0f;
        this.aim = this.mCurrentScale;
        this.aik.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    public void zW() {
        if (this.aiq != null) {
            this.aiq.a(this, canZoomIn(), canZoomOut());
        }
    }

    public void setOnSizeChangedListener(h hVar) {
        this.aiq = hVar;
    }

    public byte[] getImageData() {
        return this.mImageData;
    }

    public void setImageData(byte[] bArr) {
        this.mImageData = bArr;
    }

    public Bitmap getGifCache() {
        return this.aiy;
    }

    public void setGifCache(Bitmap bitmap) {
        this.aiy = bitmap;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        boolean z;
        int i4;
        if (this.KA == 2 && this.aiB != 0 && !this.ais.Ab()) {
            int width = getWidth();
            int height = getHeight();
            Drawable drawable = getDrawable();
            float f = 0.0f;
            float f2 = height * 0.3f;
            float f3 = width;
            float f4 = (1.0f - 0.3f) * height;
            if (this.aiC && drawable != null) {
                Rect bounds = drawable.getBounds();
                int i5 = bounds.right - bounds.left;
                int i6 = bounds.bottom - bounds.top;
                f = (width / 2) - (i5 * 2.5f);
                f2 = (height / 2) - (i6 * 2.5f);
                f3 = (i5 * 2.5f) + (width / 2);
                f4 = (i6 * 2.5f) + (height / 2);
            }
            this.mPaint.setColor(bc.getColor(this.aiB));
            canvas.drawRect(f, f2, f3, f4, this.mPaint);
            this.mPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        }
        super.onDraw(canvas);
        if (this.KA == 1 && this.aiy != null && !this.aiy.isRecycled()) {
            int width2 = this.aiy.getWidth();
            int height2 = this.aiy.getHeight();
            int width3 = getWidth();
            int height3 = getHeight();
            int i7 = (width3 - width2) >> 1;
            int i8 = (height3 - height2) >> 1;
            float f5 = this.aiD;
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
            if (this.aiw == 1 && this.aix != null && this.aiG != null && this.aiG.aiU != null) {
                if (z) {
                    canvas.drawBitmap(this.aiG.aiU, i3, i2, (Paint) null);
                } else {
                    canvas.drawBitmap(this.aiG.aiU, this.mMatrix, this.mPaint);
                }
                invalidate();
            } else if (z) {
                canvas.drawBitmap(this.aiy, i3, i2, (Paint) null);
            } else {
                canvas.drawBitmap(this.aiy, this.mMatrix, this.mPaint);
            }
        }
    }

    public void play() {
        if (this.KA == 1) {
            if (this.aix == null) {
                if (this.aiK != null) {
                    this.aiK.interrupt();
                    this.aiK = null;
                }
                com.baidu.adp.widget.a.a d = com.baidu.adp.gif.b.bH().d(this.mImageData, 0, this.mImageData.length);
                if (d != null && d.getGif() != null) {
                    this.aix = d.getGif();
                    if (this.aix != null) {
                        this.aiw = 1;
                        this.width = this.aix.getWidth();
                        this.height = this.aix.getHeight();
                        this.aiJ = 0;
                        this.aiF = this.aix.bI();
                    } else {
                        this.aiw = 0;
                    }
                } else {
                    return;
                }
            }
            if (this.aix != null && this.mState == 0) {
                this.aiM = true;
                this.aiK = new e(this, null);
                this.aiH.clear();
                this.aiI.clear();
                this.mState = 1;
                this.aiK.start();
            }
        }
    }

    public void pause() {
        if (this.KA == 1) {
            this.mState = 0;
            if (this.aiK != null) {
                this.aiK.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.KA == 1) {
            this.mState = 0;
            if (this.aiK != null) {
                this.aiK.interrupt();
                this.aiK = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.aiM = true;
            this.aiG = null;
            this.aiI.clear();
            this.aiH.clear();
            this.width = 0;
            this.height = 0;
            this.aiJ = 0;
            this.aiF = 0;
            if (this.aix != null) {
                this.aix = null;
            }
        }
    }

    private void initData() {
        this.aiD = com.baidu.adp.lib.util.l.O(getContext());
        this.aio = com.baidu.adp.lib.util.l.N(getContext()) * com.baidu.adp.lib.util.l.M(getContext()) * 2;
        if (this.aio < 1690000) {
            this.aio = 1690000;
        }
        this.aii = 0.0f;
        this.aij = 0.0f;
        this.aik = new ArrayList<>();
        this.ail = 1.0f;
        this.mMaxScale = 1.0f;
        this.mCurrentScale = 1.0f;
        this.aim = this.mCurrentScale;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.ais = new d(this);
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWillNotDraw(false);
        scrollTo(0, 0);
        this.mGestureDetector = new GestureDetector(getContext(), new c(this));
    }

    private void zX() {
        int i = 0;
        int scrollX = getScrollX();
        if (this.aii >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.aii) {
                scrollX = (int) (this.aii - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.aij + this.mTop + this.mBottom >= getHeight()) {
            i = scrollY < (-this.aiz) ? -this.aiz : scrollY;
            if (getHeight() + i > this.aij + this.mBottom + this.aiA) {
                i = (int) ((this.aij - getHeight()) + this.mBottom + this.aiA);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.aii;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.aij;
    }

    public boolean onRightSide() {
        if (this.KA == 1 || this.KA == 2) {
            return true;
        }
        return !this.aiv && getScrollX() >= ((int) (this.aii - ((float) getWidth()))) + (-1);
    }

    public boolean onLeftSide() {
        if (this.KA == 1 || this.KA == 2) {
            return true;
        }
        return !this.aiv && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.ais.Ab()) {
            this.ais.stopAnimation();
        }
        this.aiB = 0;
        super.setImageBitmap(bitmap);
        reInitBitmap();
        this.KA = 0;
    }

    public void replaceImageBitmap(Bitmap bitmap) {
        Bitmap imageBitmap = getImageBitmap();
        if (bitmap != null && !bitmap.isRecycled()) {
            if (imageBitmap != null && (imageBitmap.getWidth() != bitmap.getWidth() || imageBitmap.getHeight() != bitmap.getHeight())) {
                setImageBitmap(bitmap);
                return;
            }
            if (this.ais.Ab()) {
                this.ais.stopAnimation();
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            super.setImageBitmap(bitmap);
            super.setImageMatrix(this.mMatrix);
            scrollTo(scrollX, scrollY);
            this.KA = 0;
        }
    }

    public void a(byte[] bArr, Bitmap bitmap) {
        if (this.ais.Ab()) {
            this.ais.stopAnimation();
        }
        super.setImageDrawable(null);
        stop();
        reInitBitmap();
        this.KA = 1;
        this.aiy = bitmap;
        this.mImageData = bArr;
        if (this.Us != null) {
            this.Us.a(this);
        }
    }

    public void onDestroy() {
        if (this.ais.Ab()) {
            this.ais.stopAnimation();
        }
        super.setImageDrawable(null);
        this.mImageData = null;
        this.aiy = null;
        stop();
        if (this.aix != null) {
            this.aix.close();
            this.aix = null;
        }
    }

    public void release() {
        if (this.ais.Ab()) {
            this.ais.stopAnimation();
        }
        stop();
        super.setImageDrawable(null);
        this.aiy = null;
    }

    public void setDefaultBitmap() {
        if (this.ais.Ab()) {
            this.ais.stopAnimation();
        }
        if (this.aiC) {
            super.setImageBitmap(com.baidu.tbadk.core.util.d.bN(v.icon_default_avatar100));
        } else {
            super.setImageBitmap(com.baidu.tbadk.core.util.d.bN(v.btn_see_default));
        }
        this.KA = 2;
        reInitBitmap();
    }

    public void zoomInBitmap() {
        if (this.KA != 1 && this.KA != 2) {
            int size = this.aik.size();
            if (size > 0) {
                this.aik.add(Float.valueOf(this.aik.get(size - 1).floatValue() * 1.25f));
            } else {
                this.aik.add(Float.valueOf(this.ail));
            }
            zY();
            zW();
        }
    }

    public void zoomOutBitmap() {
        if (this.KA != 1 && this.KA != 2) {
            int size = this.aik.size();
            if (size > 1) {
                this.aik.remove(size - 1);
            }
            zY();
            zW();
        }
    }

    public void restoreSize() {
        zW();
        if (this.KA != 1 && this.KA != 2 && this.mCurrentScale != this.ail) {
            this.aik.clear();
            this.aik.add(Float.valueOf(this.ail));
            this.mCurrentScale = this.ail;
            this.aim = this.mCurrentScale;
            zY();
        }
    }

    public boolean canZoomIn() {
        if (this.KA == 1 || this.KA == 2) {
            return false;
        }
        int size = this.aik.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.aik.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.aio) && floatValue <= 5.0f;
    }

    public boolean canZoomOut() {
        if (this.KA == 1 || this.KA == 2) {
            return false;
        }
        int size = this.aik.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled()) {
            return false;
        }
        return size > 1;
    }

    public void zY() {
        e(false, -1, -1);
    }

    public void e(boolean z, int i, int i2) {
        float f;
        float f2;
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled()) {
            try {
                if (this.mMode != 2) {
                    int size = this.aik.size();
                    if (size > 0) {
                        f2 = this.aik.get(size - 1).floatValue();
                    } else {
                        f2 = this.ail;
                    }
                    this.mCurrentScale = f2;
                }
                this.mMatrix.setScale(this.mCurrentScale, this.mCurrentScale);
                this.aii = imageBitmap.getWidth() * this.mCurrentScale;
                this.aij = imageBitmap.getHeight() * this.mCurrentScale;
                float width = this.aim * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.aim;
                this.aiz = this.mTop;
                this.aiA = 0;
                float f3 = this.aii < ((float) this.mViewWidth) ? (int) ((this.mViewWidth - this.aii) / 2.0f) : 0.0f;
                if (this.aij < this.mViewHeight) {
                    f = (int) ((this.mViewHeight - this.aij) / 2.0f);
                    if (this.aip == 1 && f > this.mTop) {
                        f = this.mTop;
                    }
                    this.aiz = (int) (this.mTop - f);
                    this.aiA = this.mTop - this.aiz;
                } else {
                    f = 0.0f;
                }
                this.mMatrix.postTranslate(f3, f);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    scrollX = i > getWidth() ? getWidth() : i;
                    if (this.aii <= screenWidth) {
                        scrollX = 0;
                    } else if (this.aii > screenWidth && this.aii / 2.0f < screenWidth) {
                        scrollX = (int) (scrollX - (this.aii / 4.0f));
                    }
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.aii - width) / 2.0f);
                    }
                    if (this.aii <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.aii) {
                        scrollX = (int) (this.aii - getWidth());
                    }
                }
                if (this.mMode == 2) {
                    scrollY += (int) ((this.aij - height) / 2.0f);
                }
                if (this.aij <= getHeight()) {
                    scrollY = 0;
                } else if (getHeight() + scrollY > this.aij) {
                    scrollY = (int) (this.aij - getHeight());
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
        this.air = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.Uq = onLongClickListener;
    }

    public void setGifSetListener(g gVar) {
        this.Us = gVar;
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

    public void zZ() {
        long j;
        f poll = this.aiH.poll();
        if (poll == null) {
            this.aiM = true;
            return;
        }
        this.aiM = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.aiG != null) {
            j = this.aiG.delay - (currentTimeMillis - this.aiL);
            this.aiI.offer(this.aiG);
        } else {
            j = 0;
        }
        this.aiG = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public f Aa() {
        f poll = this.aiI.poll();
        if (poll == null) {
            f fVar = new f(null);
            fVar.aiU = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
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
