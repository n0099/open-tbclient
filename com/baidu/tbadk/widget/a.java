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
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends ImageView {
    private int YC;
    private float aAL;
    private float aAM;
    private ArrayList<Float> aAN;
    private float aAO;
    private float aAP;
    private float aAQ;
    private float aAR;
    private boolean aAS;
    private int aAT;
    private int aAU;
    private e aAV;
    private View.OnClickListener aAW;
    private C0048a aAX;
    private float aAY;
    private boolean aAZ;
    private boolean aBa;
    private int aBb;
    private volatile com.baidu.adp.gif.b aBc;
    private Bitmap aBd;
    private int aBe;
    private int aBf;
    private int aBg;
    private boolean aBh;
    private boolean aBi;
    private float aBj;
    private Interpolator aBk;
    private int aBl;
    private c aBm;
    private BlockingLinkedDeque<c> aBn;
    private BlockingLinkedDeque<c> aBo;
    private volatile int aBp;
    private b aBq;
    private volatile long aBr;
    private volatile boolean aBs;
    private View.OnLongClickListener ajO;
    private d ajQ;
    private int ajR;
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
        this.aBi = z;
    }

    public a(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aAS = false;
        this.mImageData = null;
        this.ajR = 0;
        this.aAT = 1300;
        this.aAU = 0;
        this.aAV = null;
        this.aAW = null;
        this.ajO = null;
        this.ajQ = null;
        this.aAY = 1.0f;
        this.YC = 0;
        this.mMode = 0;
        this.aAZ = false;
        this.aBa = false;
        this.aBb = 0;
        this.aBc = null;
        this.aBd = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aBe = 0;
        this.aBf = 0;
        this.aBg = 0;
        this.aBk = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aBl = 0;
        this.aBm = null;
        this.aBn = new BlockingLinkedDeque<>(5);
        this.aBo = new BlockingLinkedDeque<>(6);
        this.aBp = 0;
        this.aBr = 0L;
        this.mState = 0;
        this.aBs = true;
        this.mHandler = new Handler(new com.baidu.tbadk.widget.b(this));
        initData();
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aAS = false;
        this.mImageData = null;
        this.ajR = 0;
        this.aAT = 1300;
        this.aAU = 0;
        this.aAV = null;
        this.aAW = null;
        this.ajO = null;
        this.ajQ = null;
        this.aAY = 1.0f;
        this.YC = 0;
        this.mMode = 0;
        this.aAZ = false;
        this.aBa = false;
        this.aBb = 0;
        this.aBc = null;
        this.aBd = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aBe = 0;
        this.aBf = 0;
        this.aBg = 0;
        this.aBk = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aBl = 0;
        this.aBm = null;
        this.aBn = new BlockingLinkedDeque<>(5);
        this.aBo = new BlockingLinkedDeque<>(6);
        this.aBp = 0;
        this.aBr = 0L;
        this.mState = 0;
        this.aBs = true;
        this.mHandler = new Handler(new com.baidu.tbadk.widget.b(this));
        initData();
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aAS = false;
        this.mImageData = null;
        this.ajR = 0;
        this.aAT = 1300;
        this.aAU = 0;
        this.aAV = null;
        this.aAW = null;
        this.ajO = null;
        this.ajQ = null;
        this.aAY = 1.0f;
        this.YC = 0;
        this.mMode = 0;
        this.aAZ = false;
        this.aBa = false;
        this.aBb = 0;
        this.aBc = null;
        this.aBd = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aBe = 0;
        this.aBf = 0;
        this.aBg = 0;
        this.aBk = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aBl = 0;
        this.aBm = null;
        this.aBn = new BlockingLinkedDeque<>(5);
        this.aBo = new BlockingLinkedDeque<>(6);
        this.aBp = 0;
        this.aBr = 0L;
        this.mState = 0;
        this.aBs = true;
        this.mHandler = new Handler(new com.baidu.tbadk.widget.b(this));
        initData();
    }

    public int getImageType() {
        return this.YC;
    }

    public void setImageMode(int i) {
        this.aAU = i;
    }

    public void g(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.ajR = i;
    }

    public void FO() {
        this.aBa = false;
        this.aAS = false;
        this.mMode = 0;
        FS();
        if (this.aAQ < this.aAO) {
            this.aAQ = this.aAO;
            FZ();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.aAS = true;
                this.aAZ = false;
                this.aBa = false;
                break;
            case 1:
                FO();
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
            this.aAY = g(motionEvent);
            if (this.aAY > 10.0f) {
                this.mMode = 2;
            }
        }
        if (this.mMode == 2 || !this.mGestureDetector.onTouchEvent(motionEvent)) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.aAZ = true;
                        this.aBa = true;
                        if (this.YC != 1 && this.YC != 2) {
                            float g = g(motionEvent);
                            if (g >= 0.0f && Math.abs(this.aAY - g) >= 10.0f) {
                                if (Math.abs(this.aAY - g) > 100.0f) {
                                    this.aAY = g;
                                    break;
                                } else {
                                    float f = g / this.aAY;
                                    this.aAY = g;
                                    this.aAR = this.aAQ;
                                    this.aAQ *= f;
                                    if (this.aAQ > this.aAP) {
                                        this.aAQ = this.aAP;
                                    }
                                    if (this.aAQ < this.aAO / 4.0f) {
                                        this.aAQ = this.aAO / 4.0f;
                                    }
                                    FZ();
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

    public float g(MotionEvent motionEvent) {
        return CompatibleUtile.getInstance().getSpacing(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            this.mViewWidth = i3 - i;
            this.mViewHeight = i4 - i2;
            FQ();
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public boolean FP() {
        return this.aAO == this.aAQ;
    }

    private void FQ() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            if (this.aAU == 0) {
                float width = this.mViewWidth / imageBitmap.getWidth();
                float height = this.mViewHeight / imageBitmap.getHeight();
                if (this.aBi) {
                    if (this.YC == 2) {
                        this.aAO = 2.5f;
                    } else {
                        this.aAO = Math.min(width, height);
                    }
                } else if (this.YC == 2) {
                    this.aAO = 1.0f;
                } else {
                    float f = this.aBj;
                    float f2 = f >= 1.0f ? f : 1.0f;
                    if (imageBitmap.getWidth() * f2 < this.mViewWidth && imageBitmap.getHeight() * f2 < this.mViewHeight) {
                        this.aAO = f2;
                    } else {
                        this.aAO = Math.min(width, height);
                    }
                }
            } else {
                this.aAO = Math.max(this.mViewWidth / imageBitmap.getWidth(), ((this.mViewHeight - this.mTop) - this.mBottom) / imageBitmap.getHeight());
            }
            this.aAP = this.aAT / (imageBitmap.getWidth() * imageBitmap.getHeight());
            this.aAP = FloatMath.sqrt(this.aAP);
            if (this.aAP > 10.0f) {
                this.aAP = 10.0f;
            }
            this.aAN.clear();
            this.aAN.add(Float.valueOf(this.aAO));
            this.aAQ = this.aAO;
            this.aAR = this.aAQ;
            FZ();
            FR();
            return;
        }
        this.aAL = 0.0f;
        this.aAM = 0.0f;
        this.aAO = 1.0f;
        this.aAP = 1.0f;
        this.aAQ = 1.0f;
        this.aAR = this.aAQ;
        this.aAN.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FR() {
        if (this.aAV != null) {
            this.aAV.a(this, canZoomIn(), canZoomOut());
        }
    }

    public void setOnSizeChangedListener(e eVar) {
        this.aAV = eVar;
    }

    public byte[] getImageData() {
        return this.mImageData;
    }

    public void setImageData(byte[] bArr) {
        this.mImageData = bArr;
    }

    public Bitmap getGifCache() {
        return this.aBd;
    }

    public void setGifCache(Bitmap bitmap) {
        this.aBd = bitmap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        boolean z;
        int i4;
        if (this.YC == 2 && this.aBg != 0 && !this.aAX.Gd()) {
            int width = getWidth();
            int height = getHeight();
            Drawable drawable = getDrawable();
            float f = 0.0f;
            float f2 = height * 0.3f;
            float f3 = width;
            float f4 = (1.0f - 0.3f) * height;
            if (this.aBi && drawable != null) {
                Rect bounds = drawable.getBounds();
                int i5 = bounds.right - bounds.left;
                int i6 = bounds.bottom - bounds.top;
                f = (width / 2) - (i5 * 2.5f);
                f2 = (height / 2) - (i6 * 2.5f);
                f3 = (i5 * 2.5f) + (width / 2);
                f4 = (i6 * 2.5f) + (height / 2);
            }
            this.mPaint.setColor(at.getColor(this.aBg));
            canvas.drawRect(f, f2, f3, f4, this.mPaint);
            this.mPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        }
        super.onDraw(canvas);
        if (this.YC == 1 && this.aBd != null && !this.aBd.isRecycled()) {
            int width2 = this.aBd.getWidth();
            int height2 = this.aBd.getHeight();
            int width3 = getWidth();
            int height3 = getHeight();
            int i7 = (width3 - width2) >> 1;
            int i8 = (height3 - height2) >> 1;
            float f5 = this.aBj;
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
            if (this.aBb == 1 && this.aBc != null && this.aBm != null && this.aBm.aBB != null) {
                if (z) {
                    canvas.drawBitmap(this.aBm.aBB, i3, i2, (Paint) null);
                } else {
                    canvas.drawBitmap(this.aBm.aBB, this.mMatrix, this.mPaint);
                }
                invalidate();
            } else if (z) {
                canvas.drawBitmap(this.aBd, i3, i2, (Paint) null);
            } else {
                canvas.drawBitmap(this.aBd, this.mMatrix, this.mPaint);
            }
        }
    }

    public void play() {
        com.baidu.adp.widget.a.a d2;
        if (this.YC == 1) {
            if (this.aBc == null) {
                if (this.aBq != null) {
                    this.aBq.interrupt();
                    this.aBq = null;
                }
                if (this.mImageData != null && (d2 = a.C0004a.bB().d(this.mImageData, 0, this.mImageData.length)) != null && d2.getGif() != null) {
                    this.aBc = d2.getGif();
                    if (this.aBc != null) {
                        this.aBb = 1;
                        this.width = this.aBc.getWidth();
                        this.height = this.aBc.getHeight();
                        this.aBp = 0;
                        this.aBl = this.aBc.bC();
                    } else {
                        this.aBb = 0;
                    }
                } else {
                    return;
                }
            }
            if (this.aBc != null && this.mState == 0) {
                this.aBs = true;
                this.aBq = new b(this, null);
                this.aBn.clear();
                this.aBo.clear();
                this.mState = 1;
                this.aBq.start();
            }
        }
    }

    public void pause() {
        if (this.YC == 1) {
            this.mState = 0;
            if (this.aBq != null) {
                this.aBq.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.YC == 1) {
            this.mState = 0;
            if (this.aBq != null) {
                this.aBq.interrupt();
                this.aBq = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.aBs = true;
            this.aBm = null;
            this.aBo.clear();
            this.aBn.clear();
            this.width = 0;
            this.height = 0;
            this.aBp = 0;
            this.aBl = 0;
            if (this.aBc != null) {
                this.aBc = null;
            }
        }
    }

    private void initData() {
        this.aBj = k.D(getContext());
        this.aAT = k.C(getContext()) * k.B(getContext()) * 2;
        if (this.aAT < 1690000) {
            this.aAT = 1690000;
        }
        this.aAL = 0.0f;
        this.aAM = 0.0f;
        this.aAN = new ArrayList<>();
        this.aAO = 1.0f;
        this.aAP = 1.0f;
        this.aAQ = 1.0f;
        this.aAR = this.aAQ;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.aAX = new C0048a();
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWillNotDraw(false);
        scrollTo(0, 0);
        this.mGestureDetector = new GestureDetector(getContext(), new com.baidu.tbadk.widget.c(this));
    }

    private void FS() {
        int i = 0;
        int scrollX = getScrollX();
        if (this.aAL >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.aAL) {
                scrollX = (int) (this.aAL - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.aAM + this.mTop + this.mBottom >= getHeight()) {
            i = scrollY < (-this.aBe) ? -this.aBe : scrollY;
            if (getHeight() + i > this.aAM + this.mBottom + this.aBf) {
                i = (int) ((this.aAM - getHeight()) + this.mBottom + this.aBf);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.aAL;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.aAM;
    }

    public boolean FT() {
        if (this.YC == 1 || this.YC == 2) {
            return true;
        }
        return !this.aBa && getScrollX() >= ((int) (this.aAL - ((float) getWidth()))) + (-1);
    }

    public boolean FU() {
        if (this.YC == 1 || this.YC == 2) {
            return true;
        }
        return !this.aBa && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.aAX.Gd()) {
            this.aAX.stopAnimation();
        }
        this.aBg = 0;
        super.setImageBitmap(bitmap);
        FQ();
        this.YC = 0;
    }

    public void f(Bitmap bitmap) {
        Bitmap imageBitmap = getImageBitmap();
        if (bitmap != null && !bitmap.isRecycled()) {
            if (imageBitmap != null && (imageBitmap.getWidth() != bitmap.getWidth() || imageBitmap.getHeight() != bitmap.getHeight())) {
                setImageBitmap(bitmap);
                return;
            }
            if (this.aAX.Gd()) {
                this.aAX.stopAnimation();
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            super.setImageBitmap(bitmap);
            super.setImageMatrix(this.mMatrix);
            scrollTo(scrollX, scrollY);
            this.YC = 0;
        }
    }

    public void a(byte[] bArr, Bitmap bitmap) {
        if (this.aAX.Gd()) {
            this.aAX.stopAnimation();
        }
        super.setImageDrawable(null);
        stop();
        FQ();
        this.YC = 1;
        this.aBd = bitmap;
        this.mImageData = bArr;
        if (this.ajQ != null) {
            this.ajQ.a(this);
        }
    }

    public void onDestroy() {
        if (this.aAX.Gd()) {
            this.aAX.stopAnimation();
        }
        super.setImageDrawable(null);
        this.mImageData = null;
        this.aBd = null;
        stop();
        if (this.aBc != null) {
            this.aBc.close();
            this.aBc = null;
        }
    }

    public void release() {
        if (this.aAX.Gd()) {
            this.aAX.stopAnimation();
        }
        stop();
        super.setImageDrawable(null);
        this.aBd = null;
    }

    public void FV() {
        if (this.aAX.Gd()) {
            this.aAX.stopAnimation();
        }
        if (this.aBi) {
            super.setImageBitmap(BitmapHelper.getCashBitmap(t.f.icon_default_avatar100));
        } else {
            super.setImageBitmap(BitmapHelper.getCashBitmap(t.f.btn_see_default));
        }
        this.YC = 2;
        FQ();
    }

    public void FW() {
        if (this.YC != 1 && this.YC != 2) {
            int size = this.aAN.size();
            if (size > 0) {
                this.aAN.add(Float.valueOf(this.aAN.get(size - 1).floatValue() * 1.25f));
            } else {
                this.aAN.add(Float.valueOf(this.aAO));
            }
            FZ();
            FR();
        }
    }

    public void FX() {
        if (this.YC != 1 && this.YC != 2) {
            int size = this.aAN.size();
            if (size > 1) {
                this.aAN.remove(size - 1);
            }
            FZ();
            FR();
        }
    }

    public void FY() {
        FR();
        if (this.YC != 1 && this.YC != 2 && this.aAQ != this.aAO) {
            this.aAN.clear();
            this.aAN.add(Float.valueOf(this.aAO));
            this.aAQ = this.aAO;
            this.aAR = this.aAQ;
            FZ();
        }
    }

    public boolean canZoomIn() {
        if (this.YC == 1 || this.YC == 2) {
            return false;
        }
        int size = this.aAN.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.aAN.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.aAT) && floatValue <= 5.0f;
    }

    public boolean canZoomOut() {
        if (this.YC == 1 || this.YC == 2) {
            return false;
        }
        int size = this.aAN.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled()) {
            return false;
        }
        return size > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FZ() {
        d(false, -1, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z, int i, int i2) {
        float f;
        float f2;
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled()) {
            try {
                if (this.mMode != 2) {
                    int size = this.aAN.size();
                    if (size > 0) {
                        f2 = this.aAN.get(size - 1).floatValue();
                    } else {
                        f2 = this.aAO;
                    }
                    this.aAQ = f2;
                }
                this.mMatrix.setScale(this.aAQ, this.aAQ);
                this.aAL = imageBitmap.getWidth() * this.aAQ;
                this.aAM = imageBitmap.getHeight() * this.aAQ;
                float width = this.aAR * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.aAR;
                this.aBe = this.mTop;
                this.aBf = 0;
                float f3 = this.aAL < ((float) this.mViewWidth) ? (int) ((this.mViewWidth - this.aAL) / 2.0f) : 0.0f;
                if (this.aAM < this.mViewHeight) {
                    f = (int) ((this.mViewHeight - this.aAM) / 2.0f);
                    if (this.aAU == 1 && f > this.mTop) {
                        f = this.mTop;
                    }
                    this.aBe = (int) (this.mTop - f);
                    this.aBf = this.mTop - this.aBe;
                } else {
                    f = 0.0f;
                }
                this.mMatrix.postTranslate(f3, f);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    scrollX = i > getWidth() ? getWidth() : i;
                    if (this.aAL <= screenWidth) {
                        scrollX = 0;
                    } else if (this.aAL > screenWidth && this.aAL / 2.0f < screenWidth) {
                        scrollX = (int) (scrollX - (this.aAL / 4.0f));
                    }
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.aAL - width) / 2.0f);
                    }
                    if (this.aAL <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.aAL) {
                        scrollX = (int) (this.aAL - getWidth());
                    }
                }
                if (scrollX > 0 && this.aAL - scrollX < getWidth()) {
                    scrollX = (int) (this.aAL - getWidth());
                }
                if (this.mMode == 2) {
                    scrollY += (int) ((this.aAM - height) / 2.0f);
                }
                if (this.aAM <= getHeight()) {
                    scrollY = 0;
                } else if (getHeight() + scrollY > this.aAM) {
                    scrollY = (int) (this.aAM - getHeight());
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
    public class C0048a extends Animation {
        private long aBA;
        private boolean aBu = false;
        private boolean aBv = false;
        private long aBw;
        private long aBx;
        private int aBy;
        private long aBz;
        private int zt;

        public C0048a() {
        }

        public void a(float f, float f2) {
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
            this.aBw = f;
            this.aBx = f2;
            this.aBz = Math.abs((f * 1000.0f) / 2500.0f);
            this.aBA = Math.abs((f2 * 1000.0f) / 2500.0f);
            setDuration(Math.max(this.aBz, this.aBA));
            setInterpolator(a.this.aBk);
            this.aBy = a.this.getScrollX();
            this.zt = a.this.getScrollY();
            this.aBu = true;
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
            if (this.aBz > this.aBA) {
                j = ((float) this.aBz) * f;
            } else {
                j = ((float) this.aBA) * f;
            }
            float f2 = ((float) (j > this.aBz ? this.aBz : j)) / 1000.0f;
            if (this.aBw > 0) {
                i = this.aBy - ((int) (f2 * (((float) this.aBw) - ((2500.0f * f2) / 2.0f))));
            } else {
                i = this.aBy - ((int) (f2 * (((float) this.aBw) + ((2500.0f * f2) / 2.0f))));
            }
            if (j > this.aBA) {
                j = this.aBA;
            }
            float f3 = ((float) j) / 1000.0f;
            if (this.aBx > 0) {
                i2 = this.zt - ((int) (f3 * (((float) this.aBx) - ((2500.0f * f3) / 2.0f))));
            } else {
                i2 = this.zt - ((int) (f3 * (((float) this.aBx) + ((2500.0f * f3) / 2.0f))));
            }
            if (a.this.aAM + a.this.mTop + a.this.mBottom > a.this.getHeight()) {
                if (i2 < (-a.this.aBe)) {
                    i2 = -a.this.aBe;
                }
                if (a.this.getHeight() + i2 > a.this.aAM + a.this.mBottom + a.this.aBf) {
                    i2 = (int) ((a.this.aAM - a.this.getHeight()) + a.this.mBottom + a.this.aBf);
                }
            } else {
                i2 = 0;
            }
            if (a.this.aAL > a.this.getWidth()) {
                int width = ((float) (a.this.getWidth() + i)) > a.this.aAL ? (int) (a.this.aAL - a.this.getWidth()) : i;
                if (width >= 0) {
                    i3 = width;
                }
            }
            a.this.scrollTo(i3, i2);
            a.this.invalidate();
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            if (!this.aBv) {
                if (a.this.aAS) {
                    this.aBu = false;
                    return false;
                }
                try {
                    if (!super.getTransformation(j, transformation)) {
                        this.aBu = false;
                        return false;
                    }
                    return true;
                } catch (Exception e) {
                    this.aBu = false;
                    return false;
                }
            }
            this.aBv = false;
            this.aBu = false;
            return false;
        }

        public boolean Gd() {
            return this.aBu;
        }

        public void stopAnimation() {
            this.aBv = true;
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.aAW = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.ajO = onLongClickListener;
    }

    public void setGifSetListener(d dVar) {
        this.ajQ = dVar;
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
    public void Ga() {
        long j;
        c poll = this.aBn.poll();
        if (poll == null) {
            this.aBs = true;
            return;
        }
        this.aBs = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.aBm != null) {
            j = this.aBm.delay - (currentTimeMillis - this.aBr);
            this.aBo.offer(this.aBm);
        } else {
            j = 0;
        }
        this.aBm = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public c Gb() {
        c poll = this.aBo.poll();
        if (poll == null) {
            poll = new c(null);
            try {
                poll.aBB = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
            } catch (OutOfMemoryError e2) {
                TbadkCoreApplication.m11getInst().onAppMemoryLow();
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
        public Bitmap aBB;
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
            while (a.this.mState == 1 && a.this.aBc != null && a.this.aBl > 0 && a.this.width > 0 && a.this.height > 0) {
                try {
                    a.this.aBc.E(a.this.aBp);
                    c Gb = a.this.Gb();
                    if (Gb.aBB == null || (Gb.aBB.getWidth() != a.this.width && Gb.aBB.getHeight() != a.this.height)) {
                        try {
                            Gb.aBB = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_8888);
                        } catch (OutOfMemoryError e) {
                            TbadkCoreApplication.m11getInst().onAppMemoryLow();
                            try {
                                Gb.aBB = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_4444);
                            } catch (OutOfMemoryError e2) {
                                TbadkCoreApplication.m11getInst().onAppMemoryLow();
                            } catch (Throwable th) {
                                BdLog.e(th.getMessage());
                            }
                        } catch (Throwable th2) {
                            BdLog.e(th2.getMessage());
                        }
                    }
                    a.this.aBc.a(Gb.aBB, null);
                    Gb.delay = a.this.aBc.F(a.this.aBp);
                    a.this.aBp++;
                    if (Gb.aBB == null) {
                        a.this.aBp++;
                    }
                    a.this.aBp %= a.this.aBl;
                    a.this.aBn.put(Gb);
                    if (a.this.aBs) {
                        a.this.mHandler.sendEmptyMessage(1);
                    }
                } catch (Exception e3) {
                    return;
                }
            }
        }
    }

    public boolean Gc() {
        return this.aBh;
    }

    public void setLoadBigImage(boolean z) {
        this.aBh = z;
    }
}
