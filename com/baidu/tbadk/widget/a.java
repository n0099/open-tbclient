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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
import android.widget.ImageView;
import com.baidu.adp.gif.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BlockingLinkedDeque;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends ImageView {
    private volatile long aAA;
    private volatile boolean aAB;
    private float aAa;
    private boolean aAb;
    private int aAc;
    private int aAd;
    private e aAe;
    private View.OnClickListener aAf;
    private C0054a aAg;
    private float aAh;
    private boolean aAi;
    private boolean aAj;
    private int aAk;
    private volatile com.baidu.adp.gif.b aAl;
    private Bitmap aAm;
    private int aAn;
    private int aAo;
    private int aAp;
    private boolean aAq;
    private boolean aAr;
    private float aAs;
    private Interpolator aAt;
    private int aAu;
    private c aAv;
    private BlockingLinkedDeque<c> aAw;
    private BlockingLinkedDeque<c> aAx;
    private volatile int aAy;
    private b aAz;
    private int abQ;
    private View.OnLongClickListener ajU;
    private d ajW;
    private int ajX;
    private float azU;
    private float azV;
    private ArrayList<Float> azW;
    private float azX;
    private float azY;
    private float azZ;
    private int height;
    private int mBottom;
    private GestureDetector mGestureDetector;
    public Handler mHandler;
    private byte[] mImageData;
    private Matrix mMatrix;
    private int mMode;
    private Paint mPaint;
    private volatile int mState;
    private int mTop;
    private int mViewHeight;
    private int mViewWidth;
    private int width;

    /* loaded from: classes.dex */
    public interface d {
        void a(a aVar);
    }

    /* loaded from: classes.dex */
    public interface e {
        void a(a aVar, boolean z, boolean z2);
    }

    public void setIsHeadImage(boolean z) {
        this.aAr = z;
    }

    public a(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aAb = false;
        this.mImageData = null;
        this.ajX = 0;
        this.aAc = 1300;
        this.aAd = 0;
        this.aAe = null;
        this.aAf = null;
        this.ajU = null;
        this.ajW = null;
        this.aAh = 1.0f;
        this.abQ = 0;
        this.mMode = 0;
        this.aAi = false;
        this.aAj = false;
        this.aAk = 0;
        this.aAl = null;
        this.aAm = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aAn = 0;
        this.aAo = 0;
        this.aAp = 0;
        this.aAt = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aAu = 0;
        this.aAv = null;
        this.aAw = new BlockingLinkedDeque<>(5);
        this.aAx = new BlockingLinkedDeque<>(6);
        this.aAy = 0;
        this.aAA = 0L;
        this.mState = 0;
        this.aAB = true;
        this.mHandler = new Handler(new com.baidu.tbadk.widget.b(this));
        initData();
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aAb = false;
        this.mImageData = null;
        this.ajX = 0;
        this.aAc = 1300;
        this.aAd = 0;
        this.aAe = null;
        this.aAf = null;
        this.ajU = null;
        this.ajW = null;
        this.aAh = 1.0f;
        this.abQ = 0;
        this.mMode = 0;
        this.aAi = false;
        this.aAj = false;
        this.aAk = 0;
        this.aAl = null;
        this.aAm = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aAn = 0;
        this.aAo = 0;
        this.aAp = 0;
        this.aAt = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aAu = 0;
        this.aAv = null;
        this.aAw = new BlockingLinkedDeque<>(5);
        this.aAx = new BlockingLinkedDeque<>(6);
        this.aAy = 0;
        this.aAA = 0L;
        this.mState = 0;
        this.aAB = true;
        this.mHandler = new Handler(new com.baidu.tbadk.widget.b(this));
        initData();
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aAb = false;
        this.mImageData = null;
        this.ajX = 0;
        this.aAc = 1300;
        this.aAd = 0;
        this.aAe = null;
        this.aAf = null;
        this.ajU = null;
        this.ajW = null;
        this.aAh = 1.0f;
        this.abQ = 0;
        this.mMode = 0;
        this.aAi = false;
        this.aAj = false;
        this.aAk = 0;
        this.aAl = null;
        this.aAm = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aAn = 0;
        this.aAo = 0;
        this.aAp = 0;
        this.aAt = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aAu = 0;
        this.aAv = null;
        this.aAw = new BlockingLinkedDeque<>(5);
        this.aAx = new BlockingLinkedDeque<>(6);
        this.aAy = 0;
        this.aAA = 0L;
        this.mState = 0;
        this.aAB = true;
        this.mHandler = new Handler(new com.baidu.tbadk.widget.b(this));
        initData();
    }

    public int getImageType() {
        return this.abQ;
    }

    public void setImageMode(int i) {
        this.aAd = i;
    }

    public void setOffset(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.ajX = i;
    }

    public void actionUp() {
        this.aAj = false;
        this.aAb = false;
        this.mMode = 0;
        EH();
        if (this.azZ < this.azX) {
            this.azZ = this.azX;
            EI();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.aAb = true;
                this.aAi = false;
                this.aAj = false;
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
            this.aAh = spacing(motionEvent);
            if (this.aAh > 10.0f) {
                this.mMode = 2;
            }
        }
        if (this.mMode == 2 || !this.mGestureDetector.onTouchEvent(motionEvent)) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.aAi = true;
                        this.aAj = true;
                        if (this.abQ != 1 && this.abQ != 2) {
                            float spacing = spacing(motionEvent);
                            if (spacing >= 0.0f && Math.abs(this.aAh - spacing) >= 10.0f) {
                                if (Math.abs(this.aAh - spacing) > 100.0f) {
                                    this.aAh = spacing;
                                    break;
                                } else {
                                    float f = spacing / this.aAh;
                                    this.aAh = spacing;
                                    this.aAa = this.azZ;
                                    this.azZ *= f;
                                    if (this.azZ > this.azY) {
                                        this.azZ = this.azY;
                                    }
                                    if (this.azZ < this.azX / 4.0f) {
                                        this.azZ = this.azX / 4.0f;
                                    }
                                    EI();
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
        return this.azX == this.azZ;
    }

    private void reInitBitmap() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            if (this.aAd == 0) {
                float width = this.mViewWidth / imageBitmap.getWidth();
                float height = this.mViewHeight / imageBitmap.getHeight();
                if (this.aAr) {
                    if (this.abQ == 2) {
                        this.azX = 2.5f;
                    } else {
                        this.azX = Math.min(width, height);
                    }
                } else if (this.abQ == 2) {
                    this.azX = 1.0f;
                } else {
                    float f = this.aAs;
                    float f2 = f >= 1.0f ? f : 1.0f;
                    if (imageBitmap.getWidth() * f2 < this.mViewWidth && imageBitmap.getHeight() * f2 < this.mViewHeight) {
                        this.azX = f2;
                    } else {
                        this.azX = Math.min(width, height);
                    }
                }
            } else {
                this.azX = Math.max(this.mViewWidth / imageBitmap.getWidth(), ((this.mViewHeight - this.mTop) - this.mBottom) / imageBitmap.getHeight());
            }
            this.azY = this.aAc / (imageBitmap.getWidth() * imageBitmap.getHeight());
            this.azY = FloatMath.sqrt(this.azY);
            if (this.azY > 10.0f) {
                this.azY = 10.0f;
            }
            this.azW.clear();
            this.azW.add(Float.valueOf(this.azX));
            this.azZ = this.azX;
            this.aAa = this.azZ;
            EI();
            EG();
            return;
        }
        this.azU = 0.0f;
        this.azV = 0.0f;
        this.azX = 1.0f;
        this.azY = 1.0f;
        this.azZ = 1.0f;
        this.aAa = this.azZ;
        this.azW.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EG() {
        if (this.aAe != null) {
            this.aAe.a(this, canZoomIn(), canZoomOut());
        }
    }

    public void setOnSizeChangedListener(e eVar) {
        this.aAe = eVar;
    }

    public byte[] getImageData() {
        return this.mImageData;
    }

    public void setImageData(byte[] bArr) {
        this.mImageData = bArr;
    }

    public Bitmap getGifCache() {
        return this.aAm;
    }

    public void setGifCache(Bitmap bitmap) {
        this.aAm = bitmap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        boolean z;
        int i4;
        if (this.abQ == 2 && this.aAp != 0 && !this.aAg.EM()) {
            int width = getWidth();
            int height = getHeight();
            Drawable drawable = getDrawable();
            float f = 0.0f;
            float f2 = height * 0.3f;
            float f3 = width;
            float f4 = (1.0f - 0.3f) * height;
            if (this.aAr && drawable != null) {
                Rect bounds = drawable.getBounds();
                int i5 = bounds.right - bounds.left;
                int i6 = bounds.bottom - bounds.top;
                f = (width / 2) - (i5 * 2.5f);
                f2 = (height / 2) - (i6 * 2.5f);
                f3 = (i5 * 2.5f) + (width / 2);
                f4 = (i6 * 2.5f) + (height / 2);
            }
            this.mPaint.setColor(an.getColor(this.aAp));
            canvas.drawRect(f, f2, f3, f4, this.mPaint);
            this.mPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        }
        super.onDraw(canvas);
        if (this.abQ == 1 && this.aAm != null && !this.aAm.isRecycled()) {
            int width2 = this.aAm.getWidth();
            int height2 = this.aAm.getHeight();
            int width3 = getWidth();
            int height3 = getHeight();
            int i7 = (width3 - width2) >> 1;
            int i8 = (height3 - height2) >> 1;
            float f5 = this.aAs;
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
            if (this.aAk == 1 && this.aAl != null && this.aAv != null && this.aAv.aAK != null) {
                if (z) {
                    canvas.drawBitmap(this.aAv.aAK, i3, i2, (Paint) null);
                } else {
                    canvas.drawBitmap(this.aAv.aAK, this.mMatrix, this.mPaint);
                }
                invalidate();
            } else if (z) {
                canvas.drawBitmap(this.aAm, i3, i2, (Paint) null);
            } else {
                canvas.drawBitmap(this.aAm, this.mMatrix, this.mPaint);
            }
        }
    }

    public void play() {
        com.baidu.adp.widget.a.a e2;
        if (this.abQ == 1) {
            if (this.aAl == null) {
                if (this.aAz != null) {
                    this.aAz.interrupt();
                    this.aAz = null;
                }
                if (this.mImageData != null && (e2 = a.C0002a.fe().e(this.mImageData, 0, this.mImageData.length)) != null && e2.getGif() != null) {
                    this.aAl = e2.getGif();
                    if (this.aAl != null) {
                        this.aAk = 1;
                        this.width = this.aAl.getWidth();
                        this.height = this.aAl.getHeight();
                        this.aAy = 0;
                        this.aAu = this.aAl.ff();
                    } else {
                        this.aAk = 0;
                    }
                } else {
                    return;
                }
            }
            if (this.aAl != null && this.mState == 0) {
                this.aAB = true;
                this.aAz = new b(this, null);
                this.aAw.clear();
                this.aAx.clear();
                this.mState = 1;
                this.aAz.start();
            }
        }
    }

    public void pause() {
        if (this.abQ == 1) {
            this.mState = 0;
            if (this.aAz != null) {
                this.aAz.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.abQ == 1) {
            this.mState = 0;
            if (this.aAz != null) {
                this.aAz.interrupt();
                this.aAz = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.aAB = true;
            this.aAv = null;
            this.aAx.clear();
            this.aAw.clear();
            this.width = 0;
            this.height = 0;
            this.aAy = 0;
            this.aAu = 0;
            if (this.aAl != null) {
                this.aAl = null;
            }
        }
    }

    private void initData() {
        this.aAs = k.M(getContext());
        this.aAc = k.L(getContext()) * k.K(getContext()) * 2;
        if (this.aAc < 1690000) {
            this.aAc = 1690000;
        }
        this.azU = 0.0f;
        this.azV = 0.0f;
        this.azW = new ArrayList<>();
        this.azX = 1.0f;
        this.azY = 1.0f;
        this.azZ = 1.0f;
        this.aAa = this.azZ;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.aAg = new C0054a();
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWillNotDraw(false);
        scrollTo(0, 0);
        this.mGestureDetector = new GestureDetector(getContext(), new com.baidu.tbadk.widget.c(this));
    }

    private void EH() {
        int i = 0;
        int scrollX = getScrollX();
        if (this.azU >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.azU) {
                scrollX = (int) (this.azU - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.azV + this.mTop + this.mBottom >= getHeight()) {
            i = scrollY < (-this.aAn) ? -this.aAn : scrollY;
            if (getHeight() + i > this.azV + this.mBottom + this.aAo) {
                i = (int) ((this.azV - getHeight()) + this.mBottom + this.aAo);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.azU;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.azV;
    }

    public boolean onRightSide() {
        if (this.abQ == 1 || this.abQ == 2) {
            return true;
        }
        return !this.aAj && getScrollX() >= ((int) (this.azU - ((float) getWidth()))) + (-1);
    }

    public boolean onLeftSide() {
        if (this.abQ == 1 || this.abQ == 2) {
            return true;
        }
        return !this.aAj && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.aAg.EM()) {
            this.aAg.stopAnimation();
        }
        this.aAp = 0;
        super.setImageBitmap(bitmap);
        reInitBitmap();
        this.abQ = 0;
    }

    public void replaceImageBitmap(Bitmap bitmap) {
        Bitmap imageBitmap = getImageBitmap();
        if (bitmap != null && !bitmap.isRecycled()) {
            if (imageBitmap != null && (imageBitmap.getWidth() != bitmap.getWidth() || imageBitmap.getHeight() != bitmap.getHeight())) {
                setImageBitmap(bitmap);
                return;
            }
            if (this.aAg.EM()) {
                this.aAg.stopAnimation();
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            super.setImageBitmap(bitmap);
            super.setImageMatrix(this.mMatrix);
            scrollTo(scrollX, scrollY);
            this.abQ = 0;
        }
    }

    public void a(byte[] bArr, Bitmap bitmap) {
        if (this.aAg.EM()) {
            this.aAg.stopAnimation();
        }
        super.setImageDrawable(null);
        stop();
        reInitBitmap();
        this.abQ = 1;
        this.aAm = bitmap;
        this.mImageData = bArr;
        if (this.ajW != null) {
            this.ajW.a(this);
        }
    }

    public void onDestroy() {
        if (this.aAg.EM()) {
            this.aAg.stopAnimation();
        }
        super.setImageDrawable(null);
        this.mImageData = null;
        this.aAm = null;
        stop();
        if (this.aAl != null) {
            this.aAl.close();
            this.aAl = null;
        }
    }

    public void release() {
        if (this.aAg.EM()) {
            this.aAg.stopAnimation();
        }
        stop();
        super.setImageDrawable(null);
        this.aAm = null;
    }

    public void setDefaultBitmap() {
        if (this.aAg.EM()) {
            this.aAg.stopAnimation();
        }
        if (this.aAr) {
            super.setImageBitmap(com.baidu.tbadk.core.util.c.cf(i.e.icon_default_avatar100));
        } else {
            super.setImageBitmap(com.baidu.tbadk.core.util.c.cf(i.e.btn_see_default));
        }
        this.abQ = 2;
        reInitBitmap();
    }

    public void zoomInBitmap() {
        if (this.abQ != 1 && this.abQ != 2) {
            int size = this.azW.size();
            if (size > 0) {
                this.azW.add(Float.valueOf(this.azW.get(size - 1).floatValue() * 1.25f));
            } else {
                this.azW.add(Float.valueOf(this.azX));
            }
            EI();
            EG();
        }
    }

    public void zoomOutBitmap() {
        if (this.abQ != 1 && this.abQ != 2) {
            int size = this.azW.size();
            if (size > 1) {
                this.azW.remove(size - 1);
            }
            EI();
            EG();
        }
    }

    public void restoreSize() {
        EG();
        if (this.abQ != 1 && this.abQ != 2 && this.azZ != this.azX) {
            this.azW.clear();
            this.azW.add(Float.valueOf(this.azX));
            this.azZ = this.azX;
            this.aAa = this.azZ;
            EI();
        }
    }

    public boolean canZoomIn() {
        if (this.abQ == 1 || this.abQ == 2) {
            return false;
        }
        int size = this.azW.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.azW.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.aAc) && floatValue <= 5.0f;
    }

    public boolean canZoomOut() {
        if (this.abQ == 1 || this.abQ == 2) {
            return false;
        }
        int size = this.azW.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled()) {
            return false;
        }
        return size > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EI() {
        e(false, -1, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, int i, int i2) {
        float f;
        float f2;
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled()) {
            try {
                if (this.mMode != 2) {
                    int size = this.azW.size();
                    if (size > 0) {
                        f2 = this.azW.get(size - 1).floatValue();
                    } else {
                        f2 = this.azX;
                    }
                    this.azZ = f2;
                }
                this.mMatrix.setScale(this.azZ, this.azZ);
                this.azU = imageBitmap.getWidth() * this.azZ;
                this.azV = imageBitmap.getHeight() * this.azZ;
                float width = this.aAa * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.aAa;
                this.aAn = this.mTop;
                this.aAo = 0;
                float f3 = this.azU < ((float) this.mViewWidth) ? (int) ((this.mViewWidth - this.azU) / 2.0f) : 0.0f;
                if (this.azV < this.mViewHeight) {
                    f = (int) ((this.mViewHeight - this.azV) / 2.0f);
                    if (this.aAd == 1 && f > this.mTop) {
                        f = this.mTop;
                    }
                    this.aAn = (int) (this.mTop - f);
                    this.aAo = this.mTop - this.aAn;
                } else {
                    f = 0.0f;
                }
                this.mMatrix.postTranslate(f3, f);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    scrollX = i > getWidth() ? getWidth() : i;
                    if (this.azU <= screenWidth) {
                        scrollX = 0;
                    } else if (this.azU > screenWidth && this.azU / 2.0f < screenWidth) {
                        scrollX = (int) (scrollX - (this.azU / 4.0f));
                    }
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.azU - width) / 2.0f);
                    }
                    if (this.azU <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.azU) {
                        scrollX = (int) (this.azU - getWidth());
                    }
                }
                if (scrollX > 0 && this.azU - scrollX < getWidth()) {
                    scrollX = (int) (this.azU - getWidth());
                }
                if (this.mMode == 2) {
                    scrollY += (int) ((this.azV - height) / 2.0f);
                }
                if (this.azV <= getHeight()) {
                    scrollY = 0;
                } else if (getHeight() + scrollY > this.azV) {
                    scrollY = (int) (this.azV - getHeight());
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
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0054a extends Animation {
        private int HZ;
        private boolean aAD = false;
        private boolean aAE = false;
        private long aAF;
        private long aAG;
        private int aAH;
        private long aAI;
        private long aAJ;

        public C0054a() {
        }

        public void d(float f, float f2) {
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
            this.aAF = f;
            this.aAG = f2;
            this.aAI = Math.abs((f * 1000.0f) / 2500.0f);
            this.aAJ = Math.abs((f2 * 1000.0f) / 2500.0f);
            setDuration(Math.max(this.aAI, this.aAJ));
            setInterpolator(a.this.aAt);
            this.aAH = a.this.getScrollX();
            this.HZ = a.this.getScrollY();
            this.aAD = true;
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
            if (this.aAI > this.aAJ) {
                j = ((float) this.aAI) * f;
            } else {
                j = ((float) this.aAJ) * f;
            }
            float f2 = ((float) (j > this.aAI ? this.aAI : j)) / 1000.0f;
            if (this.aAF > 0) {
                i = this.aAH - ((int) (f2 * (((float) this.aAF) - ((2500.0f * f2) / 2.0f))));
            } else {
                i = this.aAH - ((int) (f2 * (((float) this.aAF) + ((2500.0f * f2) / 2.0f))));
            }
            if (j > this.aAJ) {
                j = this.aAJ;
            }
            float f3 = ((float) j) / 1000.0f;
            if (this.aAG > 0) {
                i2 = this.HZ - ((int) (f3 * (((float) this.aAG) - ((2500.0f * f3) / 2.0f))));
            } else {
                i2 = this.HZ - ((int) (f3 * (((float) this.aAG) + ((2500.0f * f3) / 2.0f))));
            }
            if (a.this.azV + a.this.mTop + a.this.mBottom > a.this.getHeight()) {
                if (i2 < (-a.this.aAn)) {
                    i2 = -a.this.aAn;
                }
                if (a.this.getHeight() + i2 > a.this.azV + a.this.mBottom + a.this.aAo) {
                    i2 = (int) ((a.this.azV - a.this.getHeight()) + a.this.mBottom + a.this.aAo);
                }
            } else {
                i2 = 0;
            }
            if (a.this.azU > a.this.getWidth()) {
                int width = ((float) (a.this.getWidth() + i)) > a.this.azU ? (int) (a.this.azU - a.this.getWidth()) : i;
                if (width >= 0) {
                    i3 = width;
                }
            }
            a.this.scrollTo(i3, i2);
            a.this.invalidate();
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            if (!this.aAE) {
                if (a.this.aAb) {
                    this.aAD = false;
                    return false;
                }
                try {
                    if (!super.getTransformation(j, transformation)) {
                        this.aAD = false;
                        return false;
                    }
                    return true;
                } catch (Exception e) {
                    this.aAD = false;
                    return false;
                }
            }
            this.aAE = false;
            this.aAD = false;
            return false;
        }

        public boolean EM() {
            return this.aAD;
        }

        public void stopAnimation() {
            this.aAE = true;
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.aAf = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.ajU = onLongClickListener;
    }

    public void setGifSetListener(d dVar) {
        this.ajW = dVar;
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
    public void EJ() {
        long j;
        c poll = this.aAw.poll();
        if (poll == null) {
            this.aAB = true;
            return;
        }
        this.aAB = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.aAv != null) {
            j = this.aAv.delay - (currentTimeMillis - this.aAA);
            this.aAx.offer(this.aAv);
        } else {
            j = 0;
        }
        this.aAv = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public c EK() {
        c poll = this.aAx.poll();
        if (poll == null) {
            poll = new c(null);
            try {
                poll.aAK = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
            } catch (OutOfMemoryError e2) {
                TbadkCoreApplication.m411getInst().onAppMemoryLow();
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

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        public Bitmap aAK;
        public int delay;

        private c() {
        }

        /* synthetic */ c(c cVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends Thread {
        private b() {
        }

        /* synthetic */ b(a aVar, b bVar) {
            this();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (a.this.mState == 1 && a.this.aAl != null && a.this.aAu > 0 && a.this.width > 0 && a.this.height > 0) {
                try {
                    a.this.aAl.F(a.this.aAy);
                    c EK = a.this.EK();
                    if (EK.aAK == null || (EK.aAK.getWidth() != a.this.width && EK.aAK.getHeight() != a.this.height)) {
                        try {
                            EK.aAK = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_8888);
                        } catch (OutOfMemoryError e) {
                            TbadkCoreApplication.m411getInst().onAppMemoryLow();
                            try {
                                EK.aAK = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_4444);
                            } catch (OutOfMemoryError e2) {
                                TbadkCoreApplication.m411getInst().onAppMemoryLow();
                            } catch (Throwable th) {
                                BdLog.e(th.getMessage());
                            }
                        } catch (Throwable th2) {
                            BdLog.e(th2.getMessage());
                        }
                    }
                    a.this.aAl.a(EK.aAK, null);
                    EK.delay = a.this.aAl.G(a.this.aAy);
                    a.this.aAy++;
                    if (EK.aAK == null) {
                        a.this.aAy++;
                    }
                    a.this.aAy %= a.this.aAu;
                    a.this.aAw.put(EK);
                    if (a.this.aAB) {
                        a.this.mHandler.sendEmptyMessage(1);
                    }
                } catch (Exception e3) {
                    return;
                }
            }
        }
    }

    public boolean EL() {
        return this.aAq;
    }

    public void setLoadBigImage(boolean z) {
        this.aAq = z;
    }
}
