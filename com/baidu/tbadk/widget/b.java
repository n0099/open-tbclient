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
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b extends ImageView {
    private float aKG;
    private float aKH;
    private ArrayList<Float> aKI;
    private float aKJ;
    private float aKK;
    private float aKL;
    private boolean aKM;
    private int aKN;
    private int aKO;
    private e aKP;
    private View.OnClickListener aKQ;
    private a aKR;
    private float aKS;
    private boolean aKT;
    private boolean aKU;
    private int aKV;
    private volatile com.baidu.adp.gif.b aKW;
    private Bitmap aKX;
    private int aKY;
    private int aKZ;
    private int aLa;
    private int aLb;
    private boolean aLc;
    private boolean aLd;
    private float aLe;
    private Interpolator aLf;
    private int aLg;
    private c aLh;
    private BlockingLinkedDeque<c> aLi;
    private BlockingLinkedDeque<c> aLj;
    private volatile int aLk;
    private C0052b aLl;
    private volatile long aLm;
    private volatile boolean aLn;
    private int ahb;
    private View.OnLongClickListener aue;
    private d aug;
    private int auh;
    private int height;
    private int mBottom;
    private float mCurrentScale;
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
        void a(b bVar);
    }

    /* loaded from: classes.dex */
    public interface e {
        void a(b bVar, boolean z, boolean z2);
    }

    public void setIsHeadImage(boolean z) {
        this.aLd = z;
    }

    public b(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aKM = false;
        this.mImageData = null;
        this.auh = 0;
        this.aKN = 1300;
        this.aKO = 0;
        this.aKP = null;
        this.aKQ = null;
        this.aue = null;
        this.aug = null;
        this.aKS = 1.0f;
        this.ahb = 0;
        this.mMode = 0;
        this.aKT = false;
        this.aKU = false;
        this.aKV = 0;
        this.aKW = null;
        this.aKX = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aKY = 0;
        this.aKZ = 0;
        this.aLa = 0;
        this.aLb = 0;
        this.aLf = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aLg = 0;
        this.aLh = null;
        this.aLi = new BlockingLinkedDeque<>(5);
        this.aLj = new BlockingLinkedDeque<>(6);
        this.aLk = 0;
        this.aLm = 0L;
        this.mState = 0;
        this.aLn = true;
        this.mHandler = new Handler(new com.baidu.tbadk.widget.c(this));
        initData();
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aKM = false;
        this.mImageData = null;
        this.auh = 0;
        this.aKN = 1300;
        this.aKO = 0;
        this.aKP = null;
        this.aKQ = null;
        this.aue = null;
        this.aug = null;
        this.aKS = 1.0f;
        this.ahb = 0;
        this.mMode = 0;
        this.aKT = false;
        this.aKU = false;
        this.aKV = 0;
        this.aKW = null;
        this.aKX = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aKY = 0;
        this.aKZ = 0;
        this.aLa = 0;
        this.aLb = 0;
        this.aLf = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aLg = 0;
        this.aLh = null;
        this.aLi = new BlockingLinkedDeque<>(5);
        this.aLj = new BlockingLinkedDeque<>(6);
        this.aLk = 0;
        this.aLm = 0L;
        this.mState = 0;
        this.aLn = true;
        this.mHandler = new Handler(new com.baidu.tbadk.widget.c(this));
        initData();
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aKM = false;
        this.mImageData = null;
        this.auh = 0;
        this.aKN = 1300;
        this.aKO = 0;
        this.aKP = null;
        this.aKQ = null;
        this.aue = null;
        this.aug = null;
        this.aKS = 1.0f;
        this.ahb = 0;
        this.mMode = 0;
        this.aKT = false;
        this.aKU = false;
        this.aKV = 0;
        this.aKW = null;
        this.aKX = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aKY = 0;
        this.aKZ = 0;
        this.aLa = 0;
        this.aLb = 0;
        this.aLf = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aLg = 0;
        this.aLh = null;
        this.aLi = new BlockingLinkedDeque<>(5);
        this.aLj = new BlockingLinkedDeque<>(6);
        this.aLk = 0;
        this.aLm = 0L;
        this.mState = 0;
        this.aLn = true;
        this.mHandler = new Handler(new com.baidu.tbadk.widget.c(this));
        initData();
    }

    public int getImageType() {
        return this.ahb;
    }

    public void setImageMode(int i) {
        this.aKO = i;
    }

    public void h(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.auh = i;
    }

    public void Hc() {
        this.aKU = false;
        this.aKM = false;
        this.mMode = 0;
        Hg();
        if (this.mCurrentScale < this.aKJ) {
            this.mCurrentScale = this.aKJ;
            Hn();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.aKM = true;
                this.aKT = false;
                this.aKU = false;
                break;
            case 1:
                Hc();
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
            this.aKS = m(motionEvent);
            if (this.aKS > 10.0f) {
                this.mMode = 2;
            }
        }
        if (this.mMode == 2 || !this.mGestureDetector.onTouchEvent(motionEvent)) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.aKT = true;
                        this.aKU = true;
                        if (this.ahb != 1 && this.ahb != 2) {
                            float m = m(motionEvent);
                            if (m >= 0.0f && Math.abs(this.aKS - m) >= 10.0f) {
                                if (Math.abs(this.aKS - m) > 100.0f) {
                                    this.aKS = m;
                                    break;
                                } else {
                                    float f = m / this.aKS;
                                    this.aKS = m;
                                    this.aKL = this.mCurrentScale;
                                    this.mCurrentScale *= f;
                                    if (this.mCurrentScale > this.aKK) {
                                        this.mCurrentScale = this.aKK;
                                    }
                                    if (this.mCurrentScale < this.aKJ / 4.0f) {
                                        this.mCurrentScale = this.aKJ / 4.0f;
                                    }
                                    Hn();
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

    public float m(MotionEvent motionEvent) {
        return CompatibleUtile.getInstance().getSpacing(motionEvent);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            this.mViewWidth = i3 - i;
            this.mViewHeight = i4 - i2;
            He();
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public boolean Hd() {
        return this.aKJ == this.mCurrentScale;
    }

    private void He() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            if (this.aKO == 0) {
                float width = this.mViewWidth / imageBitmap.getWidth();
                float height = this.mViewHeight / imageBitmap.getHeight();
                if (this.aLd) {
                    if (this.ahb == 2) {
                        this.aKJ = 2.5f;
                    } else {
                        this.aKJ = Math.min(width, height);
                    }
                } else if (this.ahb == 2) {
                    this.aKJ = 1.0f;
                } else {
                    float f = this.aLe;
                    float f2 = f >= 1.0f ? f : 1.0f;
                    if (imageBitmap.getWidth() * f2 < this.mViewWidth && imageBitmap.getHeight() * f2 < this.mViewHeight) {
                        this.aKJ = f2;
                    } else {
                        this.aKJ = Math.min(width, height);
                    }
                }
            } else {
                this.aKJ = Math.max(this.mViewWidth / imageBitmap.getWidth(), ((this.mViewHeight - this.mTop) - this.mBottom) / imageBitmap.getHeight());
            }
            this.aKK = this.aKN / (imageBitmap.getWidth() * imageBitmap.getHeight());
            this.aKK = FloatMath.sqrt(this.aKK);
            if (this.aKK > 10.0f) {
                this.aKK = 10.0f;
            }
            this.aKI.clear();
            this.aKI.add(Float.valueOf(this.aKJ));
            this.mCurrentScale = this.aKJ;
            this.aKL = this.mCurrentScale;
            Hn();
            return;
        }
        this.aKG = 0.0f;
        this.aKH = 0.0f;
        this.aKJ = 1.0f;
        this.aKK = 1.0f;
        this.mCurrentScale = 1.0f;
        this.aKL = this.mCurrentScale;
        this.aKI.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    private void Hf() {
        if (this.aKP != null) {
            this.aKP.a(this, canZoomIn(), canZoomOut());
        }
    }

    public void setOnSizeChangedListener(e eVar) {
        this.aKP = eVar;
    }

    public byte[] getImageData() {
        return this.mImageData;
    }

    public void setImageData(byte[] bArr) {
        this.mImageData = bArr;
    }

    public Bitmap getGifCache() {
        return this.aKX;
    }

    public void setGifCache(Bitmap bitmap) {
        this.aKX = bitmap;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        boolean z;
        int i4;
        if (this.ahb == 2 && this.aLb != 0 && !this.aKR.Hr()) {
            int width = getWidth();
            int height = getHeight();
            Drawable drawable = getDrawable();
            float f = 0.0f;
            float f2 = height * 0.3f;
            float f3 = width;
            float f4 = (1.0f - 0.3f) * height;
            if (this.aLd && drawable != null) {
                Rect bounds = drawable.getBounds();
                int i5 = bounds.right - bounds.left;
                int i6 = bounds.bottom - bounds.top;
                f = (width / 2) - (i5 * 2.5f);
                f2 = (height / 2) - (i6 * 2.5f);
                f3 = (i5 * 2.5f) + (width / 2);
                f4 = (i6 * 2.5f) + (height / 2);
            }
            this.mPaint.setColor(as.getColor(this.aLb));
            canvas.drawRect(f, f2, f3, f4, this.mPaint);
            this.mPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        }
        super.onDraw(canvas);
        if (this.ahb == 1 && this.aKX != null && !this.aKX.isRecycled()) {
            int width2 = this.aKX.getWidth();
            int height2 = this.aKX.getHeight();
            int width3 = getWidth();
            int height3 = getHeight();
            int i7 = (width3 - width2) >> 1;
            int i8 = (height3 - height2) >> 1;
            float f5 = this.aLe;
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
            if (this.aKV == 1 && this.aKW != null && this.aLh != null && this.aLh.aLw != null) {
                if (z) {
                    canvas.drawBitmap(this.aLh.aLw, i3, i2, (Paint) null);
                } else {
                    canvas.drawBitmap(this.aLh.aLw, this.mMatrix, this.mPaint);
                }
                invalidate();
            } else if (z) {
                canvas.drawBitmap(this.aKX, i3, i2, (Paint) null);
            } else {
                canvas.drawBitmap(this.aKX, this.mMatrix, this.mPaint);
            }
        }
    }

    public void play() {
        com.baidu.adp.widget.a.a aVar;
        if (this.ahb == 1) {
            if (this.aKW == null) {
                if (this.aLl != null) {
                    this.aLl.interrupt();
                    this.aLl = null;
                }
                if (this.mImageData != null) {
                    try {
                        aVar = a.C0003a.dD().g(this.mImageData, 0, this.mImageData.length);
                    } catch (StackOverflowError e2) {
                        aVar = null;
                    }
                    if (aVar != null && aVar.getGif() != null) {
                        this.aKW = aVar.getGif();
                        if (this.aKW != null) {
                            this.aKV = 1;
                            this.width = this.aKW.getWidth();
                            this.height = this.aKW.getHeight();
                            this.aLk = 0;
                            this.aLg = this.aKW.dE();
                        } else {
                            this.aKV = 0;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            if (this.aKW != null && this.mState == 0) {
                this.aLn = true;
                this.aLl = new C0052b(this, null);
                this.aLi.clear();
                this.aLj.clear();
                this.mState = 1;
                this.aLl.start();
            }
        }
    }

    public void pause() {
        if (this.ahb == 1) {
            this.mState = 0;
            if (this.aLl != null) {
                this.aLl.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.ahb == 1) {
            this.mState = 0;
            if (this.aLl != null) {
                this.aLl.interrupt();
                this.aLl = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.aLn = true;
            this.aLh = null;
            this.aLj.clear();
            this.aLi.clear();
            this.width = 0;
            this.height = 0;
            this.aLk = 0;
            this.aLg = 0;
            if (this.aKW != null) {
                this.aKW = null;
            }
        }
    }

    private void initData() {
        this.aLe = k.ah(getContext());
        this.aKN = k.ag(getContext()) * k.af(getContext()) * 2;
        if (this.aKN < 1690000) {
            this.aKN = 1690000;
        }
        this.aKG = 0.0f;
        this.aKH = 0.0f;
        this.aKI = new ArrayList<>();
        this.aKJ = 1.0f;
        this.aKK = 1.0f;
        this.mCurrentScale = 1.0f;
        this.aKL = this.mCurrentScale;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.aKR = new a();
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWillNotDraw(false);
        scrollTo(0, 0);
        this.mGestureDetector = new GestureDetector(getContext(), new com.baidu.tbadk.widget.d(this));
    }

    private void Hg() {
        int i = 0;
        int scrollX = getScrollX();
        if (this.aKG >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.aKG) {
                scrollX = (int) (this.aKG - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.aKH + this.mTop + this.mBottom >= getHeight()) {
            i = scrollY < (-this.aKY) ? -this.aKY : scrollY;
            if (getHeight() + i > this.aKH + this.mBottom + this.aKZ) {
                i = (int) ((this.aKH - getHeight()) + this.mBottom + this.aKZ);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.aKG;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.aKH;
    }

    public boolean Hh() {
        if (this.ahb == 1 || this.ahb == 2) {
            return true;
        }
        return !this.aKU && getScrollX() >= ((int) (this.aKG - ((float) getWidth()))) + (-1);
    }

    public boolean Hi() {
        if (this.ahb == 1 || this.ahb == 2) {
            return true;
        }
        return !this.aKU && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.aKR.Hr()) {
            this.aKR.stopAnimation();
        }
        this.aLb = 0;
        super.setImageBitmap(bitmap);
        He();
        this.ahb = 0;
    }

    public void i(Bitmap bitmap) {
        Bitmap imageBitmap = getImageBitmap();
        if (bitmap != null && !bitmap.isRecycled()) {
            if (imageBitmap != null && (imageBitmap.getWidth() != bitmap.getWidth() || imageBitmap.getHeight() != bitmap.getHeight())) {
                setImageBitmap(bitmap);
                return;
            }
            if (this.aKR.Hr()) {
                this.aKR.stopAnimation();
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            super.setImageBitmap(bitmap);
            super.setImageMatrix(this.mMatrix);
            scrollTo(scrollX, scrollY);
            this.ahb = 0;
        }
    }

    public void a(byte[] bArr, Bitmap bitmap) {
        if (this.aKR.Hr()) {
            this.aKR.stopAnimation();
        }
        super.setImageDrawable(null);
        stop();
        He();
        this.ahb = 1;
        this.aKX = bitmap;
        this.mImageData = bArr;
        if (this.aug != null) {
            this.aug.a(this);
        }
    }

    public void onDestroy() {
        if (this.aKR.Hr()) {
            this.aKR.stopAnimation();
        }
        super.setImageDrawable(null);
        this.mImageData = null;
        this.aKX = null;
        stop();
        if (this.aKW != null) {
            this.aKW.close();
            this.aKW = null;
        }
    }

    public void release() {
        if (this.aKR.Hr()) {
            this.aKR.stopAnimation();
        }
        stop();
        super.setImageDrawable(null);
        this.aKX = null;
    }

    public void Hj() {
        if (this.aKR.Hr()) {
            this.aKR.stopAnimation();
        }
        if (this.aLd) {
            super.setImageBitmap(BitmapHelper.getCashBitmap(w.g.icon_default_avatar100));
        } else {
            super.setImageBitmap(BitmapHelper.getCashBitmap(w.g.btn_see_default));
        }
        this.ahb = 2;
        He();
    }

    public void Hk() {
        if (this.ahb != 1 && this.ahb != 2) {
            int size = this.aKI.size();
            if (size > 0) {
                this.aKI.add(Float.valueOf(this.aKI.get(size - 1).floatValue() * 1.25f));
            } else {
                this.aKI.add(Float.valueOf(this.aKJ));
            }
            Hn();
        }
    }

    public void Hl() {
        if (this.ahb != 1 && this.ahb != 2) {
            int size = this.aKI.size();
            if (size > 1) {
                this.aKI.remove(size - 1);
            }
            Hn();
        }
    }

    public void Hm() {
        Hf();
        if (this.ahb != 1 && this.ahb != 2 && this.mCurrentScale != this.aKJ) {
            this.aKI.clear();
            this.aKI.add(Float.valueOf(this.aKJ));
            this.mCurrentScale = this.aKJ;
            this.aKL = this.mCurrentScale;
            Hn();
        }
    }

    public boolean canZoomIn() {
        if (this.ahb == 1 || this.ahb == 2) {
            return false;
        }
        int size = this.aKI.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.aKI.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.aKN) && floatValue <= 5.0f;
    }

    public boolean canZoomOut() {
        if (this.ahb == 1 || this.ahb == 2) {
            return false;
        }
        int size = this.aKI.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled()) {
            return false;
        }
        return size > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hn() {
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
                    int size = this.aKI.size();
                    if (size > 0) {
                        f2 = this.aKI.get(size - 1).floatValue();
                    } else {
                        f2 = this.aKJ;
                    }
                    this.mCurrentScale = f2;
                }
                this.mMatrix.setScale(this.mCurrentScale, this.mCurrentScale);
                this.aKG = imageBitmap.getWidth() * this.mCurrentScale;
                this.aKH = imageBitmap.getHeight() * this.mCurrentScale;
                float width = this.aKL * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.aKL;
                this.aKY = this.mTop;
                this.aKZ = 0;
                float f3 = this.aKG < ((float) this.mViewWidth) ? (int) ((this.mViewWidth - this.aKG) / 2.0f) : 0.0f;
                if (this.aKH < this.mViewHeight) {
                    f = (int) ((this.mViewHeight - this.aKH) / 2.0f);
                    if (this.aKO == 1 && f > this.mTop) {
                        f = this.mTop;
                    }
                    this.aKY = (int) (this.mTop - f);
                    this.aKZ = this.mTop - this.aKY;
                } else {
                    f = 0.0f;
                }
                this.aLa = (int) f3;
                this.mMatrix.postTranslate(f3, f);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    scrollX = i > getWidth() ? getWidth() : i;
                    if (this.aKG <= screenWidth) {
                        scrollX = 0;
                    } else if (this.aKG > screenWidth && this.aKG / 2.0f < screenWidth) {
                        scrollX = (int) (scrollX - (this.aKG / 4.0f));
                    }
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.aKG - width) / 2.0f);
                    }
                    if (this.aKG <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.aKG) {
                        scrollX = (int) (this.aKG - getWidth());
                    }
                }
                if (scrollX > 0 && this.aKG - scrollX < getWidth()) {
                    scrollX = (int) (this.aKG - getWidth());
                }
                if (this.mMode == 2) {
                    scrollY += (int) ((this.aKH - height) / 2.0f);
                }
                if (this.aKH <= getHeight()) {
                    scrollY = 0;
                } else if (getHeight() + scrollY > this.aKH) {
                    scrollY = (int) (this.aKH - getHeight());
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
                Hf();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Animation {
        private boolean aLp = false;
        private boolean aLq = false;
        private long aLr;
        private long aLs;
        private int aLt;
        private long aLu;
        private long aLv;
        private int mStartY;

        public a() {
        }

        public void e(float f, float f2) {
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
            this.aLr = f;
            this.aLs = f2;
            this.aLu = Math.abs((f * 1000.0f) / 2500.0f);
            this.aLv = Math.abs((f2 * 1000.0f) / 2500.0f);
            setDuration(Math.max(this.aLu, this.aLv));
            setInterpolator(b.this.aLf);
            this.aLt = b.this.getScrollX();
            this.mStartY = b.this.getScrollY();
            this.aLp = true;
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
            if (this.aLu > this.aLv) {
                j = ((float) this.aLu) * f;
            } else {
                j = ((float) this.aLv) * f;
            }
            float f2 = ((float) (j > this.aLu ? this.aLu : j)) / 1000.0f;
            if (this.aLr > 0) {
                i = this.aLt - ((int) (f2 * (((float) this.aLr) - ((2500.0f * f2) / 2.0f))));
            } else {
                i = this.aLt - ((int) (f2 * (((float) this.aLr) + ((2500.0f * f2) / 2.0f))));
            }
            if (j > this.aLv) {
                j = this.aLv;
            }
            float f3 = ((float) j) / 1000.0f;
            if (this.aLs > 0) {
                i2 = this.mStartY - ((int) (f3 * (((float) this.aLs) - ((2500.0f * f3) / 2.0f))));
            } else {
                i2 = this.mStartY - ((int) (f3 * (((float) this.aLs) + ((2500.0f * f3) / 2.0f))));
            }
            if (b.this.aKH + b.this.mTop + b.this.mBottom > b.this.getHeight()) {
                if (i2 < (-b.this.aKY)) {
                    i2 = -b.this.aKY;
                }
                if (b.this.getHeight() + i2 > b.this.aKH + b.this.mBottom + b.this.aKZ) {
                    i2 = (int) ((b.this.aKH - b.this.getHeight()) + b.this.mBottom + b.this.aKZ);
                }
            } else {
                i2 = 0;
            }
            if (b.this.aKG > b.this.getWidth()) {
                int width = ((float) (b.this.getWidth() + i)) > b.this.aKG ? (int) (b.this.aKG - b.this.getWidth()) : i;
                if (width >= 0) {
                    i3 = width;
                }
            }
            b.this.scrollTo(i3, i2);
            b.this.invalidate();
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            if (!this.aLq) {
                if (b.this.aKM) {
                    this.aLp = false;
                    return false;
                }
                try {
                    if (!super.getTransformation(j, transformation)) {
                        this.aLp = false;
                        return false;
                    }
                    return true;
                } catch (Exception e) {
                    this.aLp = false;
                    return false;
                }
            }
            this.aLq = false;
            this.aLp = false;
            return false;
        }

        public boolean Hr() {
            return this.aLp;
        }

        public void stopAnimation() {
            this.aLq = true;
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.aKQ = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aue = onLongClickListener;
    }

    public void setGifSetListener(d dVar) {
        this.aug = dVar;
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
    public void Ho() {
        long j;
        c poll = this.aLi.poll();
        if (poll == null) {
            this.aLn = true;
            return;
        }
        this.aLn = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.aLh != null) {
            j = this.aLh.delay - (currentTimeMillis - this.aLm);
            this.aLj.offer(this.aLh);
        } else {
            j = 0;
        }
        this.aLh = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public c Hp() {
        c poll = this.aLj.poll();
        if (poll == null) {
            poll = new c(null);
            try {
                poll.aLw = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
            } catch (OutOfMemoryError e2) {
                TbadkCoreApplication.m9getInst().onAppMemoryLow();
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
        public Bitmap aLw;
        public int delay;

        private c() {
        }

        /* synthetic */ c(c cVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.widget.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0052b extends Thread {
        private C0052b() {
        }

        /* synthetic */ C0052b(b bVar, C0052b c0052b) {
            this();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (b.this.mState == 1 && b.this.aKW != null && b.this.aLg > 0 && b.this.width > 0 && b.this.height > 0) {
                try {
                    b.this.aKW.T(b.this.aLk);
                    c Hp = b.this.Hp();
                    if (Hp.aLw == null || (Hp.aLw.getWidth() != b.this.width && Hp.aLw.getHeight() != b.this.height)) {
                        try {
                            Hp.aLw = Bitmap.createBitmap(b.this.width, b.this.height, Bitmap.Config.ARGB_8888);
                        } catch (OutOfMemoryError e) {
                            TbadkCoreApplication.m9getInst().onAppMemoryLow();
                            try {
                                Hp.aLw = Bitmap.createBitmap(b.this.width, b.this.height, Bitmap.Config.ARGB_4444);
                            } catch (OutOfMemoryError e2) {
                                TbadkCoreApplication.m9getInst().onAppMemoryLow();
                            } catch (Throwable th) {
                                BdLog.e(th.getMessage());
                            }
                        } catch (Throwable th2) {
                            BdLog.e(th2.getMessage());
                        }
                    }
                    b.this.aKW.a(Hp.aLw, null);
                    Hp.delay = b.this.aKW.U(b.this.aLk);
                    b.this.aLk++;
                    if (Hp.aLw == null) {
                        b.this.aLk++;
                    }
                    b.this.aLk %= b.this.aLg;
                    b.this.aLi.put(Hp);
                    if (b.this.aLn) {
                        b.this.mHandler.sendEmptyMessage(1);
                    }
                } catch (Exception e3) {
                    return;
                }
            }
        }
    }

    public boolean Hq() {
        return this.aLc;
    }

    public void setLoadBigImage(boolean z) {
        this.aLc = z;
    }

    public int getBottomOffset() {
        return this.aKZ;
    }

    public int getLeftOffset() {
        return this.aLa;
    }
}
