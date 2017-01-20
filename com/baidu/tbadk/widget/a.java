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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends ImageView {
    private float aDG;
    private float aDH;
    private ArrayList<Float> aDI;
    private float aDJ;
    private float aDK;
    private float aDL;
    private boolean aDM;
    private int aDN;
    private int aDO;
    private e aDP;
    private View.OnClickListener aDQ;
    private C0048a aDR;
    private float aDS;
    private boolean aDT;
    private boolean aDU;
    private int aDV;
    private volatile com.baidu.adp.gif.b aDW;
    private Bitmap aDX;
    private int aDY;
    private int aDZ;
    private int aEa;
    private int aEb;
    private boolean aEc;
    private boolean aEd;
    private float aEe;
    private Interpolator aEf;
    private int aEg;
    private c aEh;
    private BlockingLinkedDeque<c> aEi;
    private BlockingLinkedDeque<c> aEj;
    private volatile int aEk;
    private b aEl;
    private volatile long aEm;
    private volatile boolean aEn;
    private int abF;
    private View.OnLongClickListener anA;
    private d anC;
    private int anD;
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
        void a(a aVar);
    }

    /* loaded from: classes.dex */
    public interface e {
        void a(a aVar, boolean z, boolean z2);
    }

    public void setIsHeadImage(boolean z) {
        this.aEd = z;
    }

    public a(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aDM = false;
        this.mImageData = null;
        this.anD = 0;
        this.aDN = 1300;
        this.aDO = 0;
        this.aDP = null;
        this.aDQ = null;
        this.anA = null;
        this.anC = null;
        this.aDS = 1.0f;
        this.abF = 0;
        this.mMode = 0;
        this.aDT = false;
        this.aDU = false;
        this.aDV = 0;
        this.aDW = null;
        this.aDX = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aDY = 0;
        this.aDZ = 0;
        this.aEa = 0;
        this.aEb = 0;
        this.aEf = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aEg = 0;
        this.aEh = null;
        this.aEi = new BlockingLinkedDeque<>(5);
        this.aEj = new BlockingLinkedDeque<>(6);
        this.aEk = 0;
        this.aEm = 0L;
        this.mState = 0;
        this.aEn = true;
        this.mHandler = new Handler(new com.baidu.tbadk.widget.b(this));
        initData();
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aDM = false;
        this.mImageData = null;
        this.anD = 0;
        this.aDN = 1300;
        this.aDO = 0;
        this.aDP = null;
        this.aDQ = null;
        this.anA = null;
        this.anC = null;
        this.aDS = 1.0f;
        this.abF = 0;
        this.mMode = 0;
        this.aDT = false;
        this.aDU = false;
        this.aDV = 0;
        this.aDW = null;
        this.aDX = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aDY = 0;
        this.aDZ = 0;
        this.aEa = 0;
        this.aEb = 0;
        this.aEf = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aEg = 0;
        this.aEh = null;
        this.aEi = new BlockingLinkedDeque<>(5);
        this.aEj = new BlockingLinkedDeque<>(6);
        this.aEk = 0;
        this.aEm = 0L;
        this.mState = 0;
        this.aEn = true;
        this.mHandler = new Handler(new com.baidu.tbadk.widget.b(this));
        initData();
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aDM = false;
        this.mImageData = null;
        this.anD = 0;
        this.aDN = 1300;
        this.aDO = 0;
        this.aDP = null;
        this.aDQ = null;
        this.anA = null;
        this.anC = null;
        this.aDS = 1.0f;
        this.abF = 0;
        this.mMode = 0;
        this.aDT = false;
        this.aDU = false;
        this.aDV = 0;
        this.aDW = null;
        this.aDX = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aDY = 0;
        this.aDZ = 0;
        this.aEa = 0;
        this.aEb = 0;
        this.aEf = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aEg = 0;
        this.aEh = null;
        this.aEi = new BlockingLinkedDeque<>(5);
        this.aEj = new BlockingLinkedDeque<>(6);
        this.aEk = 0;
        this.aEm = 0L;
        this.mState = 0;
        this.aEn = true;
        this.mHandler = new Handler(new com.baidu.tbadk.widget.b(this));
        initData();
    }

    public int getImageType() {
        return this.abF;
    }

    public void setImageMode(int i) {
        this.aDO = i;
    }

    public void h(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.anD = i;
    }

    public void GC() {
        this.aDU = false;
        this.aDM = false;
        this.mMode = 0;
        GG();
        if (this.mCurrentScale < this.aDJ) {
            this.mCurrentScale = this.aDJ;
            GN();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.aDM = true;
                this.aDT = false;
                this.aDU = false;
                break;
            case 1:
                GC();
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
            this.aDS = i(motionEvent);
            if (this.aDS > 10.0f) {
                this.mMode = 2;
            }
        }
        if (this.mMode == 2 || !this.mGestureDetector.onTouchEvent(motionEvent)) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.aDT = true;
                        this.aDU = true;
                        if (this.abF != 1 && this.abF != 2) {
                            float i = i(motionEvent);
                            if (i >= 0.0f && Math.abs(this.aDS - i) >= 10.0f) {
                                if (Math.abs(this.aDS - i) > 100.0f) {
                                    this.aDS = i;
                                    break;
                                } else {
                                    float f = i / this.aDS;
                                    this.aDS = i;
                                    this.aDL = this.mCurrentScale;
                                    this.mCurrentScale *= f;
                                    if (this.mCurrentScale > this.aDK) {
                                        this.mCurrentScale = this.aDK;
                                    }
                                    if (this.mCurrentScale < this.aDJ / 4.0f) {
                                        this.mCurrentScale = this.aDJ / 4.0f;
                                    }
                                    GN();
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

    public float i(MotionEvent motionEvent) {
        return CompatibleUtile.getInstance().getSpacing(motionEvent);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            this.mViewWidth = i3 - i;
            this.mViewHeight = i4 - i2;
            GE();
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public boolean GD() {
        return this.aDJ == this.mCurrentScale;
    }

    private void GE() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            if (this.aDO == 0) {
                float width = this.mViewWidth / imageBitmap.getWidth();
                float height = this.mViewHeight / imageBitmap.getHeight();
                if (this.aEd) {
                    if (this.abF == 2) {
                        this.aDJ = 2.5f;
                    } else {
                        this.aDJ = Math.min(width, height);
                    }
                } else if (this.abF == 2) {
                    this.aDJ = 1.0f;
                } else {
                    float f = this.aEe;
                    float f2 = f >= 1.0f ? f : 1.0f;
                    if (imageBitmap.getWidth() * f2 < this.mViewWidth && imageBitmap.getHeight() * f2 < this.mViewHeight) {
                        this.aDJ = f2;
                    } else {
                        this.aDJ = Math.min(width, height);
                    }
                }
            } else {
                this.aDJ = Math.max(this.mViewWidth / imageBitmap.getWidth(), ((this.mViewHeight - this.mTop) - this.mBottom) / imageBitmap.getHeight());
            }
            this.aDK = this.aDN / (imageBitmap.getWidth() * imageBitmap.getHeight());
            this.aDK = FloatMath.sqrt(this.aDK);
            if (this.aDK > 10.0f) {
                this.aDK = 10.0f;
            }
            this.aDI.clear();
            this.aDI.add(Float.valueOf(this.aDJ));
            this.mCurrentScale = this.aDJ;
            this.aDL = this.mCurrentScale;
            GN();
            return;
        }
        this.aDG = 0.0f;
        this.aDH = 0.0f;
        this.aDJ = 1.0f;
        this.aDK = 1.0f;
        this.mCurrentScale = 1.0f;
        this.aDL = this.mCurrentScale;
        this.aDI.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    private void GF() {
        if (this.aDP != null) {
            this.aDP.a(this, canZoomIn(), canZoomOut());
        }
    }

    public void setOnSizeChangedListener(e eVar) {
        this.aDP = eVar;
    }

    public byte[] getImageData() {
        return this.mImageData;
    }

    public void setImageData(byte[] bArr) {
        this.mImageData = bArr;
    }

    public Bitmap getGifCache() {
        return this.aDX;
    }

    public void setGifCache(Bitmap bitmap) {
        this.aDX = bitmap;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        boolean z;
        int i4;
        if (this.abF == 2 && this.aEb != 0 && !this.aDR.GR()) {
            int width = getWidth();
            int height = getHeight();
            Drawable drawable = getDrawable();
            float f = 0.0f;
            float f2 = height * 0.3f;
            float f3 = width;
            float f4 = (1.0f - 0.3f) * height;
            if (this.aEd && drawable != null) {
                Rect bounds = drawable.getBounds();
                int i5 = bounds.right - bounds.left;
                int i6 = bounds.bottom - bounds.top;
                f = (width / 2) - (i5 * 2.5f);
                f2 = (height / 2) - (i6 * 2.5f);
                f3 = (i5 * 2.5f) + (width / 2);
                f4 = (i6 * 2.5f) + (height / 2);
            }
            this.mPaint.setColor(ap.getColor(this.aEb));
            canvas.drawRect(f, f2, f3, f4, this.mPaint);
            this.mPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        }
        super.onDraw(canvas);
        if (this.abF == 1 && this.aDX != null && !this.aDX.isRecycled()) {
            int width2 = this.aDX.getWidth();
            int height2 = this.aDX.getHeight();
            int width3 = getWidth();
            int height3 = getHeight();
            int i7 = (width3 - width2) >> 1;
            int i8 = (height3 - height2) >> 1;
            float f5 = this.aEe;
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
            if (this.aDV == 1 && this.aDW != null && this.aEh != null && this.aEh.aEw != null) {
                if (z) {
                    canvas.drawBitmap(this.aEh.aEw, i3, i2, (Paint) null);
                } else {
                    canvas.drawBitmap(this.aEh.aEw, this.mMatrix, this.mPaint);
                }
                invalidate();
            } else if (z) {
                canvas.drawBitmap(this.aDX, i3, i2, (Paint) null);
            } else {
                canvas.drawBitmap(this.aDX, this.mMatrix, this.mPaint);
            }
        }
    }

    public void play() {
        com.baidu.adp.widget.a.a aVar;
        if (this.abF == 1) {
            if (this.aDW == null) {
                if (this.aEl != null) {
                    this.aEl.interrupt();
                    this.aEl = null;
                }
                if (this.mImageData != null) {
                    try {
                        aVar = a.C0003a.cu().e(this.mImageData, 0, this.mImageData.length);
                    } catch (StackOverflowError e2) {
                        aVar = null;
                    }
                    if (aVar != null && aVar.getGif() != null) {
                        this.aDW = aVar.getGif();
                        if (this.aDW != null) {
                            this.aDV = 1;
                            this.width = this.aDW.getWidth();
                            this.height = this.aDW.getHeight();
                            this.aEk = 0;
                            this.aEg = this.aDW.cv();
                        } else {
                            this.aDV = 0;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            if (this.aDW != null && this.mState == 0) {
                this.aEn = true;
                this.aEl = new b(this, null);
                this.aEi.clear();
                this.aEj.clear();
                this.mState = 1;
                this.aEl.start();
            }
        }
    }

    public void pause() {
        if (this.abF == 1) {
            this.mState = 0;
            if (this.aEl != null) {
                this.aEl.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.abF == 1) {
            this.mState = 0;
            if (this.aEl != null) {
                this.aEl.interrupt();
                this.aEl = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.aEn = true;
            this.aEh = null;
            this.aEj.clear();
            this.aEi.clear();
            this.width = 0;
            this.height = 0;
            this.aEk = 0;
            this.aEg = 0;
            if (this.aDW != null) {
                this.aDW = null;
            }
        }
    }

    private void initData() {
        this.aEe = k.K(getContext());
        this.aDN = k.J(getContext()) * k.I(getContext()) * 2;
        if (this.aDN < 1690000) {
            this.aDN = 1690000;
        }
        this.aDG = 0.0f;
        this.aDH = 0.0f;
        this.aDI = new ArrayList<>();
        this.aDJ = 1.0f;
        this.aDK = 1.0f;
        this.mCurrentScale = 1.0f;
        this.aDL = this.mCurrentScale;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.aDR = new C0048a();
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWillNotDraw(false);
        scrollTo(0, 0);
        this.mGestureDetector = new GestureDetector(getContext(), new com.baidu.tbadk.widget.c(this));
    }

    private void GG() {
        int i = 0;
        int scrollX = getScrollX();
        if (this.aDG >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.aDG) {
                scrollX = (int) (this.aDG - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.aDH + this.mTop + this.mBottom >= getHeight()) {
            i = scrollY < (-this.aDY) ? -this.aDY : scrollY;
            if (getHeight() + i > this.aDH + this.mBottom + this.aDZ) {
                i = (int) ((this.aDH - getHeight()) + this.mBottom + this.aDZ);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.aDG;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.aDH;
    }

    public boolean GH() {
        if (this.abF == 1 || this.abF == 2) {
            return true;
        }
        return !this.aDU && getScrollX() >= ((int) (this.aDG - ((float) getWidth()))) + (-1);
    }

    public boolean GI() {
        if (this.abF == 1 || this.abF == 2) {
            return true;
        }
        return !this.aDU && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.aDR.GR()) {
            this.aDR.stopAnimation();
        }
        this.aEb = 0;
        super.setImageBitmap(bitmap);
        GE();
        this.abF = 0;
    }

    public void j(Bitmap bitmap) {
        Bitmap imageBitmap = getImageBitmap();
        if (bitmap != null && !bitmap.isRecycled()) {
            if (imageBitmap != null && (imageBitmap.getWidth() != bitmap.getWidth() || imageBitmap.getHeight() != bitmap.getHeight())) {
                setImageBitmap(bitmap);
                return;
            }
            if (this.aDR.GR()) {
                this.aDR.stopAnimation();
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            super.setImageBitmap(bitmap);
            super.setImageMatrix(this.mMatrix);
            scrollTo(scrollX, scrollY);
            this.abF = 0;
        }
    }

    public void a(byte[] bArr, Bitmap bitmap) {
        if (this.aDR.GR()) {
            this.aDR.stopAnimation();
        }
        super.setImageDrawable(null);
        stop();
        GE();
        this.abF = 1;
        this.aDX = bitmap;
        this.mImageData = bArr;
        if (this.anC != null) {
            this.anC.a(this);
        }
    }

    public void onDestroy() {
        if (this.aDR.GR()) {
            this.aDR.stopAnimation();
        }
        super.setImageDrawable(null);
        this.mImageData = null;
        this.aDX = null;
        stop();
        if (this.aDW != null) {
            this.aDW.close();
            this.aDW = null;
        }
    }

    public void release() {
        if (this.aDR.GR()) {
            this.aDR.stopAnimation();
        }
        stop();
        super.setImageDrawable(null);
        this.aDX = null;
    }

    public void GJ() {
        if (this.aDR.GR()) {
            this.aDR.stopAnimation();
        }
        if (this.aEd) {
            super.setImageBitmap(BitmapHelper.getCashBitmap(r.g.icon_default_avatar100));
        } else {
            super.setImageBitmap(BitmapHelper.getCashBitmap(r.g.btn_see_default));
        }
        this.abF = 2;
        GE();
    }

    public void GK() {
        if (this.abF != 1 && this.abF != 2) {
            int size = this.aDI.size();
            if (size > 0) {
                this.aDI.add(Float.valueOf(this.aDI.get(size - 1).floatValue() * 1.25f));
            } else {
                this.aDI.add(Float.valueOf(this.aDJ));
            }
            GN();
        }
    }

    public void GL() {
        if (this.abF != 1 && this.abF != 2) {
            int size = this.aDI.size();
            if (size > 1) {
                this.aDI.remove(size - 1);
            }
            GN();
        }
    }

    public void GM() {
        GF();
        if (this.abF != 1 && this.abF != 2 && this.mCurrentScale != this.aDJ) {
            this.aDI.clear();
            this.aDI.add(Float.valueOf(this.aDJ));
            this.mCurrentScale = this.aDJ;
            this.aDL = this.mCurrentScale;
            GN();
        }
    }

    public boolean canZoomIn() {
        if (this.abF == 1 || this.abF == 2) {
            return false;
        }
        int size = this.aDI.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.aDI.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.aDN) && floatValue <= 5.0f;
    }

    public boolean canZoomOut() {
        if (this.abF == 1 || this.abF == 2) {
            return false;
        }
        int size = this.aDI.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled()) {
            return false;
        }
        return size > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GN() {
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
                    int size = this.aDI.size();
                    if (size > 0) {
                        f2 = this.aDI.get(size - 1).floatValue();
                    } else {
                        f2 = this.aDJ;
                    }
                    this.mCurrentScale = f2;
                }
                this.mMatrix.setScale(this.mCurrentScale, this.mCurrentScale);
                this.aDG = imageBitmap.getWidth() * this.mCurrentScale;
                this.aDH = imageBitmap.getHeight() * this.mCurrentScale;
                float width = this.aDL * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.aDL;
                this.aDY = this.mTop;
                this.aDZ = 0;
                float f3 = this.aDG < ((float) this.mViewWidth) ? (int) ((this.mViewWidth - this.aDG) / 2.0f) : 0.0f;
                if (this.aDH < this.mViewHeight) {
                    f = (int) ((this.mViewHeight - this.aDH) / 2.0f);
                    if (this.aDO == 1 && f > this.mTop) {
                        f = this.mTop;
                    }
                    this.aDY = (int) (this.mTop - f);
                    this.aDZ = this.mTop - this.aDY;
                } else {
                    f = 0.0f;
                }
                this.aEa = (int) f3;
                this.mMatrix.postTranslate(f3, f);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    scrollX = i > getWidth() ? getWidth() : i;
                    if (this.aDG <= screenWidth) {
                        scrollX = 0;
                    } else if (this.aDG > screenWidth && this.aDG / 2.0f < screenWidth) {
                        scrollX = (int) (scrollX - (this.aDG / 4.0f));
                    }
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.aDG - width) / 2.0f);
                    }
                    if (this.aDG <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.aDG) {
                        scrollX = (int) (this.aDG - getWidth());
                    }
                }
                if (scrollX > 0 && this.aDG - scrollX < getWidth()) {
                    scrollX = (int) (this.aDG - getWidth());
                }
                if (this.mMode == 2) {
                    scrollY += (int) ((this.aDH - height) / 2.0f);
                }
                if (this.aDH <= getHeight()) {
                    scrollY = 0;
                } else if (getHeight() + scrollY > this.aDH) {
                    scrollY = (int) (this.aDH - getHeight());
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
                GF();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0048a extends Animation {
        private int Bv;
        private boolean aEp = false;
        private boolean aEq = false;
        private long aEr;
        private long aEs;
        private int aEt;
        private long aEu;
        private long aEv;

        public C0048a() {
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
            this.aEr = f;
            this.aEs = f2;
            this.aEu = Math.abs((f * 1000.0f) / 2500.0f);
            this.aEv = Math.abs((f2 * 1000.0f) / 2500.0f);
            setDuration(Math.max(this.aEu, this.aEv));
            setInterpolator(a.this.aEf);
            this.aEt = a.this.getScrollX();
            this.Bv = a.this.getScrollY();
            this.aEp = true;
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
            if (this.aEu > this.aEv) {
                j = ((float) this.aEu) * f;
            } else {
                j = ((float) this.aEv) * f;
            }
            float f2 = ((float) (j > this.aEu ? this.aEu : j)) / 1000.0f;
            if (this.aEr > 0) {
                i = this.aEt - ((int) (f2 * (((float) this.aEr) - ((2500.0f * f2) / 2.0f))));
            } else {
                i = this.aEt - ((int) (f2 * (((float) this.aEr) + ((2500.0f * f2) / 2.0f))));
            }
            if (j > this.aEv) {
                j = this.aEv;
            }
            float f3 = ((float) j) / 1000.0f;
            if (this.aEs > 0) {
                i2 = this.Bv - ((int) (f3 * (((float) this.aEs) - ((2500.0f * f3) / 2.0f))));
            } else {
                i2 = this.Bv - ((int) (f3 * (((float) this.aEs) + ((2500.0f * f3) / 2.0f))));
            }
            if (a.this.aDH + a.this.mTop + a.this.mBottom > a.this.getHeight()) {
                if (i2 < (-a.this.aDY)) {
                    i2 = -a.this.aDY;
                }
                if (a.this.getHeight() + i2 > a.this.aDH + a.this.mBottom + a.this.aDZ) {
                    i2 = (int) ((a.this.aDH - a.this.getHeight()) + a.this.mBottom + a.this.aDZ);
                }
            } else {
                i2 = 0;
            }
            if (a.this.aDG > a.this.getWidth()) {
                int width = ((float) (a.this.getWidth() + i)) > a.this.aDG ? (int) (a.this.aDG - a.this.getWidth()) : i;
                if (width >= 0) {
                    i3 = width;
                }
            }
            a.this.scrollTo(i3, i2);
            a.this.invalidate();
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            if (!this.aEq) {
                if (a.this.aDM) {
                    this.aEp = false;
                    return false;
                }
                try {
                    if (!super.getTransformation(j, transformation)) {
                        this.aEp = false;
                        return false;
                    }
                    return true;
                } catch (Exception e) {
                    this.aEp = false;
                    return false;
                }
            }
            this.aEq = false;
            this.aEp = false;
            return false;
        }

        public boolean GR() {
            return this.aEp;
        }

        public void stopAnimation() {
            this.aEq = true;
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.aDQ = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.anA = onLongClickListener;
    }

    public void setGifSetListener(d dVar) {
        this.anC = dVar;
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
    public void GO() {
        long j;
        c poll = this.aEi.poll();
        if (poll == null) {
            this.aEn = true;
            return;
        }
        this.aEn = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.aEh != null) {
            j = this.aEh.delay - (currentTimeMillis - this.aEm);
            this.aEj.offer(this.aEh);
        } else {
            j = 0;
        }
        this.aEh = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public c GP() {
        c poll = this.aEj.poll();
        if (poll == null) {
            poll = new c(null);
            try {
                poll.aEw = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
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
        public Bitmap aEw;
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
            while (a.this.mState == 1 && a.this.aDW != null && a.this.aEg > 0 && a.this.width > 0 && a.this.height > 0) {
                try {
                    a.this.aDW.V(a.this.aEk);
                    c GP = a.this.GP();
                    if (GP.aEw == null || (GP.aEw.getWidth() != a.this.width && GP.aEw.getHeight() != a.this.height)) {
                        try {
                            GP.aEw = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_8888);
                        } catch (OutOfMemoryError e) {
                            TbadkCoreApplication.m9getInst().onAppMemoryLow();
                            try {
                                GP.aEw = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_4444);
                            } catch (OutOfMemoryError e2) {
                                TbadkCoreApplication.m9getInst().onAppMemoryLow();
                            } catch (Throwable th) {
                                BdLog.e(th.getMessage());
                            }
                        } catch (Throwable th2) {
                            BdLog.e(th2.getMessage());
                        }
                    }
                    a.this.aDW.a(GP.aEw, null);
                    GP.delay = a.this.aDW.W(a.this.aEk);
                    a.this.aEk++;
                    if (GP.aEw == null) {
                        a.this.aEk++;
                    }
                    a.this.aEk %= a.this.aEg;
                    a.this.aEi.put(GP);
                    if (a.this.aEn) {
                        a.this.mHandler.sendEmptyMessage(1);
                    }
                } catch (Exception e3) {
                    return;
                }
            }
        }
    }

    public boolean GQ() {
        return this.aEc;
    }

    public void setLoadBigImage(boolean z) {
        this.aEc = z;
    }

    public int getBottomOffset() {
        return this.aDZ;
    }

    public int getLeftOffset() {
        return this.aEa;
    }
}
