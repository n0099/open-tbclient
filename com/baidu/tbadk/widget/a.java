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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends ImageView {
    private float aJA;
    private boolean aJB;
    private int aJC;
    private int aJD;
    private e aJE;
    private View.OnClickListener aJF;
    private C0046a aJG;
    private float aJH;
    private boolean aJI;
    private boolean aJJ;
    private int aJK;
    private volatile com.baidu.adp.gif.b aJL;
    private Bitmap aJM;
    private int aJN;
    private int aJO;
    private int aJP;
    private int aJQ;
    private boolean aJR;
    private boolean aJS;
    private float aJT;
    private Interpolator aJU;
    private int aJV;
    private c aJW;
    private BlockingLinkedDeque<c> aJX;
    private BlockingLinkedDeque<c> aJY;
    private volatile int aJZ;
    private float aJv;
    private float aJw;
    private ArrayList<Float> aJx;
    private float aJy;
    private float aJz;
    private b aKa;
    private volatile long aKb;
    private volatile boolean aKc;
    private int ahk;
    private View.OnLongClickListener atn;
    private d atp;
    private int atq;
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
        this.aJS = z;
    }

    public a(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aJB = false;
        this.mImageData = null;
        this.atq = 0;
        this.aJC = 1300;
        this.aJD = 0;
        this.aJE = null;
        this.aJF = null;
        this.atn = null;
        this.atp = null;
        this.aJH = 1.0f;
        this.ahk = 0;
        this.mMode = 0;
        this.aJI = false;
        this.aJJ = false;
        this.aJK = 0;
        this.aJL = null;
        this.aJM = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aJN = 0;
        this.aJO = 0;
        this.aJP = 0;
        this.aJQ = 0;
        this.aJU = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aJV = 0;
        this.aJW = null;
        this.aJX = new BlockingLinkedDeque<>(5);
        this.aJY = new BlockingLinkedDeque<>(6);
        this.aJZ = 0;
        this.aKb = 0L;
        this.mState = 0;
        this.aKc = true;
        this.mHandler = new Handler(new com.baidu.tbadk.widget.b(this));
        initData();
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aJB = false;
        this.mImageData = null;
        this.atq = 0;
        this.aJC = 1300;
        this.aJD = 0;
        this.aJE = null;
        this.aJF = null;
        this.atn = null;
        this.atp = null;
        this.aJH = 1.0f;
        this.ahk = 0;
        this.mMode = 0;
        this.aJI = false;
        this.aJJ = false;
        this.aJK = 0;
        this.aJL = null;
        this.aJM = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aJN = 0;
        this.aJO = 0;
        this.aJP = 0;
        this.aJQ = 0;
        this.aJU = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aJV = 0;
        this.aJW = null;
        this.aJX = new BlockingLinkedDeque<>(5);
        this.aJY = new BlockingLinkedDeque<>(6);
        this.aJZ = 0;
        this.aKb = 0L;
        this.mState = 0;
        this.aKc = true;
        this.mHandler = new Handler(new com.baidu.tbadk.widget.b(this));
        initData();
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aJB = false;
        this.mImageData = null;
        this.atq = 0;
        this.aJC = 1300;
        this.aJD = 0;
        this.aJE = null;
        this.aJF = null;
        this.atn = null;
        this.atp = null;
        this.aJH = 1.0f;
        this.ahk = 0;
        this.mMode = 0;
        this.aJI = false;
        this.aJJ = false;
        this.aJK = 0;
        this.aJL = null;
        this.aJM = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aJN = 0;
        this.aJO = 0;
        this.aJP = 0;
        this.aJQ = 0;
        this.aJU = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aJV = 0;
        this.aJW = null;
        this.aJX = new BlockingLinkedDeque<>(5);
        this.aJY = new BlockingLinkedDeque<>(6);
        this.aJZ = 0;
        this.aKb = 0L;
        this.mState = 0;
        this.aKc = true;
        this.mHandler = new Handler(new com.baidu.tbadk.widget.b(this));
        initData();
    }

    public int getImageType() {
        return this.ahk;
    }

    public void setImageMode(int i) {
        this.aJD = i;
    }

    public void h(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.atq = i;
    }

    public void HA() {
        this.aJJ = false;
        this.aJB = false;
        this.mMode = 0;
        HE();
        if (this.mCurrentScale < this.aJy) {
            this.mCurrentScale = this.aJy;
            HL();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.aJB = true;
                this.aJI = false;
                this.aJJ = false;
                break;
            case 1:
                HA();
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
            this.aJH = m(motionEvent);
            if (this.aJH > 10.0f) {
                this.mMode = 2;
            }
        }
        if (this.mMode == 2 || !this.mGestureDetector.onTouchEvent(motionEvent)) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.aJI = true;
                        this.aJJ = true;
                        if (this.ahk != 1 && this.ahk != 2) {
                            float m = m(motionEvent);
                            if (m >= 0.0f && Math.abs(this.aJH - m) >= 10.0f) {
                                if (Math.abs(this.aJH - m) > 100.0f) {
                                    this.aJH = m;
                                    break;
                                } else {
                                    float f = m / this.aJH;
                                    this.aJH = m;
                                    this.aJA = this.mCurrentScale;
                                    this.mCurrentScale *= f;
                                    if (this.mCurrentScale > this.aJz) {
                                        this.mCurrentScale = this.aJz;
                                    }
                                    if (this.mCurrentScale < this.aJy / 4.0f) {
                                        this.mCurrentScale = this.aJy / 4.0f;
                                    }
                                    HL();
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
            HC();
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public boolean HB() {
        return this.aJy == this.mCurrentScale;
    }

    private void HC() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            if (this.aJD == 0) {
                float width = this.mViewWidth / imageBitmap.getWidth();
                float height = this.mViewHeight / imageBitmap.getHeight();
                if (this.aJS) {
                    if (this.ahk == 2) {
                        this.aJy = 2.5f;
                    } else {
                        this.aJy = Math.min(width, height);
                    }
                } else if (this.ahk == 2) {
                    this.aJy = 1.0f;
                } else {
                    float f = this.aJT;
                    float f2 = f >= 1.0f ? f : 1.0f;
                    if (imageBitmap.getWidth() * f2 < this.mViewWidth && imageBitmap.getHeight() * f2 < this.mViewHeight) {
                        this.aJy = f2;
                    } else {
                        this.aJy = Math.min(width, height);
                    }
                }
            } else {
                this.aJy = Math.max(this.mViewWidth / imageBitmap.getWidth(), ((this.mViewHeight - this.mTop) - this.mBottom) / imageBitmap.getHeight());
            }
            this.aJz = this.aJC / (imageBitmap.getWidth() * imageBitmap.getHeight());
            this.aJz = FloatMath.sqrt(this.aJz);
            if (this.aJz > 10.0f) {
                this.aJz = 10.0f;
            }
            this.aJx.clear();
            this.aJx.add(Float.valueOf(this.aJy));
            this.mCurrentScale = this.aJy;
            this.aJA = this.mCurrentScale;
            HL();
            return;
        }
        this.aJv = 0.0f;
        this.aJw = 0.0f;
        this.aJy = 1.0f;
        this.aJz = 1.0f;
        this.mCurrentScale = 1.0f;
        this.aJA = this.mCurrentScale;
        this.aJx.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    private void HD() {
        if (this.aJE != null) {
            this.aJE.a(this, canZoomIn(), canZoomOut());
        }
    }

    public void setOnSizeChangedListener(e eVar) {
        this.aJE = eVar;
    }

    public byte[] getImageData() {
        return this.mImageData;
    }

    public void setImageData(byte[] bArr) {
        this.mImageData = bArr;
    }

    public Bitmap getGifCache() {
        return this.aJM;
    }

    public void setGifCache(Bitmap bitmap) {
        this.aJM = bitmap;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        boolean z;
        int i4;
        if (this.ahk == 2 && this.aJQ != 0 && !this.aJG.HP()) {
            int width = getWidth();
            int height = getHeight();
            Drawable drawable = getDrawable();
            float f = 0.0f;
            float f2 = height * 0.3f;
            float f3 = width;
            float f4 = (1.0f - 0.3f) * height;
            if (this.aJS && drawable != null) {
                Rect bounds = drawable.getBounds();
                int i5 = bounds.right - bounds.left;
                int i6 = bounds.bottom - bounds.top;
                f = (width / 2) - (i5 * 2.5f);
                f2 = (height / 2) - (i6 * 2.5f);
                f3 = (i5 * 2.5f) + (width / 2);
                f4 = (i6 * 2.5f) + (height / 2);
            }
            this.mPaint.setColor(aq.getColor(this.aJQ));
            canvas.drawRect(f, f2, f3, f4, this.mPaint);
            this.mPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        }
        super.onDraw(canvas);
        if (this.ahk == 1 && this.aJM != null && !this.aJM.isRecycled()) {
            int width2 = this.aJM.getWidth();
            int height2 = this.aJM.getHeight();
            int width3 = getWidth();
            int height3 = getHeight();
            int i7 = (width3 - width2) >> 1;
            int i8 = (height3 - height2) >> 1;
            float f5 = this.aJT;
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
            if (this.aJK == 1 && this.aJL != null && this.aJW != null && this.aJW.aKl != null) {
                if (z) {
                    canvas.drawBitmap(this.aJW.aKl, i3, i2, (Paint) null);
                } else {
                    canvas.drawBitmap(this.aJW.aKl, this.mMatrix, this.mPaint);
                }
                invalidate();
            } else if (z) {
                canvas.drawBitmap(this.aJM, i3, i2, (Paint) null);
            } else {
                canvas.drawBitmap(this.aJM, this.mMatrix, this.mPaint);
            }
        }
    }

    public void play() {
        com.baidu.adp.widget.a.a aVar;
        if (this.ahk == 1) {
            if (this.aJL == null) {
                if (this.aKa != null) {
                    this.aKa.interrupt();
                    this.aKa = null;
                }
                if (this.mImageData != null) {
                    try {
                        aVar = a.C0003a.dD().e(this.mImageData, 0, this.mImageData.length);
                    } catch (StackOverflowError e2) {
                        aVar = null;
                    }
                    if (aVar != null && aVar.getGif() != null) {
                        this.aJL = aVar.getGif();
                        if (this.aJL != null) {
                            this.aJK = 1;
                            this.width = this.aJL.getWidth();
                            this.height = this.aJL.getHeight();
                            this.aJZ = 0;
                            this.aJV = this.aJL.dE();
                        } else {
                            this.aJK = 0;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            if (this.aJL != null && this.mState == 0) {
                this.aKc = true;
                this.aKa = new b(this, null);
                this.aJX.clear();
                this.aJY.clear();
                this.mState = 1;
                this.aKa.start();
            }
        }
    }

    public void pause() {
        if (this.ahk == 1) {
            this.mState = 0;
            if (this.aKa != null) {
                this.aKa.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.ahk == 1) {
            this.mState = 0;
            if (this.aKa != null) {
                this.aKa.interrupt();
                this.aKa = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.aKc = true;
            this.aJW = null;
            this.aJY.clear();
            this.aJX.clear();
            this.width = 0;
            this.height = 0;
            this.aJZ = 0;
            this.aJV = 0;
            if (this.aJL != null) {
                this.aJL = null;
            }
        }
    }

    private void initData() {
        this.aJT = k.ah(getContext());
        this.aJC = k.ag(getContext()) * k.af(getContext()) * 2;
        if (this.aJC < 1690000) {
            this.aJC = 1690000;
        }
        this.aJv = 0.0f;
        this.aJw = 0.0f;
        this.aJx = new ArrayList<>();
        this.aJy = 1.0f;
        this.aJz = 1.0f;
        this.mCurrentScale = 1.0f;
        this.aJA = this.mCurrentScale;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.aJG = new C0046a();
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWillNotDraw(false);
        scrollTo(0, 0);
        this.mGestureDetector = new GestureDetector(getContext(), new com.baidu.tbadk.widget.c(this));
    }

    private void HE() {
        int i = 0;
        int scrollX = getScrollX();
        if (this.aJv >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.aJv) {
                scrollX = (int) (this.aJv - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.aJw + this.mTop + this.mBottom >= getHeight()) {
            i = scrollY < (-this.aJN) ? -this.aJN : scrollY;
            if (getHeight() + i > this.aJw + this.mBottom + this.aJO) {
                i = (int) ((this.aJw - getHeight()) + this.mBottom + this.aJO);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.aJv;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.aJw;
    }

    public boolean HF() {
        if (this.ahk == 1 || this.ahk == 2) {
            return true;
        }
        return !this.aJJ && getScrollX() >= ((int) (this.aJv - ((float) getWidth()))) + (-1);
    }

    public boolean HG() {
        if (this.ahk == 1 || this.ahk == 2) {
            return true;
        }
        return !this.aJJ && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.aJG.HP()) {
            this.aJG.stopAnimation();
        }
        this.aJQ = 0;
        super.setImageBitmap(bitmap);
        HC();
        this.ahk = 0;
    }

    public void i(Bitmap bitmap) {
        Bitmap imageBitmap = getImageBitmap();
        if (bitmap != null && !bitmap.isRecycled()) {
            if (imageBitmap != null && (imageBitmap.getWidth() != bitmap.getWidth() || imageBitmap.getHeight() != bitmap.getHeight())) {
                setImageBitmap(bitmap);
                return;
            }
            if (this.aJG.HP()) {
                this.aJG.stopAnimation();
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            super.setImageBitmap(bitmap);
            super.setImageMatrix(this.mMatrix);
            scrollTo(scrollX, scrollY);
            this.ahk = 0;
        }
    }

    public void a(byte[] bArr, Bitmap bitmap) {
        if (this.aJG.HP()) {
            this.aJG.stopAnimation();
        }
        super.setImageDrawable(null);
        stop();
        HC();
        this.ahk = 1;
        this.aJM = bitmap;
        this.mImageData = bArr;
        if (this.atp != null) {
            this.atp.a(this);
        }
    }

    public void onDestroy() {
        if (this.aJG.HP()) {
            this.aJG.stopAnimation();
        }
        super.setImageDrawable(null);
        this.mImageData = null;
        this.aJM = null;
        stop();
        if (this.aJL != null) {
            this.aJL.close();
            this.aJL = null;
        }
    }

    public void release() {
        if (this.aJG.HP()) {
            this.aJG.stopAnimation();
        }
        stop();
        super.setImageDrawable(null);
        this.aJM = null;
    }

    public void HH() {
        if (this.aJG.HP()) {
            this.aJG.stopAnimation();
        }
        if (this.aJS) {
            super.setImageBitmap(BitmapHelper.getCashBitmap(w.g.icon_default_avatar100));
        } else {
            super.setImageBitmap(BitmapHelper.getCashBitmap(w.g.btn_see_default));
        }
        this.ahk = 2;
        HC();
    }

    public void HI() {
        if (this.ahk != 1 && this.ahk != 2) {
            int size = this.aJx.size();
            if (size > 0) {
                this.aJx.add(Float.valueOf(this.aJx.get(size - 1).floatValue() * 1.25f));
            } else {
                this.aJx.add(Float.valueOf(this.aJy));
            }
            HL();
        }
    }

    public void HJ() {
        if (this.ahk != 1 && this.ahk != 2) {
            int size = this.aJx.size();
            if (size > 1) {
                this.aJx.remove(size - 1);
            }
            HL();
        }
    }

    public void HK() {
        HD();
        if (this.ahk != 1 && this.ahk != 2 && this.mCurrentScale != this.aJy) {
            this.aJx.clear();
            this.aJx.add(Float.valueOf(this.aJy));
            this.mCurrentScale = this.aJy;
            this.aJA = this.mCurrentScale;
            HL();
        }
    }

    public boolean canZoomIn() {
        if (this.ahk == 1 || this.ahk == 2) {
            return false;
        }
        int size = this.aJx.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.aJx.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.aJC) && floatValue <= 5.0f;
    }

    public boolean canZoomOut() {
        if (this.ahk == 1 || this.ahk == 2) {
            return false;
        }
        int size = this.aJx.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled()) {
            return false;
        }
        return size > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HL() {
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
                    int size = this.aJx.size();
                    if (size > 0) {
                        f2 = this.aJx.get(size - 1).floatValue();
                    } else {
                        f2 = this.aJy;
                    }
                    this.mCurrentScale = f2;
                }
                this.mMatrix.setScale(this.mCurrentScale, this.mCurrentScale);
                this.aJv = imageBitmap.getWidth() * this.mCurrentScale;
                this.aJw = imageBitmap.getHeight() * this.mCurrentScale;
                float width = this.aJA * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.aJA;
                this.aJN = this.mTop;
                this.aJO = 0;
                float f3 = this.aJv < ((float) this.mViewWidth) ? (int) ((this.mViewWidth - this.aJv) / 2.0f) : 0.0f;
                if (this.aJw < this.mViewHeight) {
                    f = (int) ((this.mViewHeight - this.aJw) / 2.0f);
                    if (this.aJD == 1 && f > this.mTop) {
                        f = this.mTop;
                    }
                    this.aJN = (int) (this.mTop - f);
                    this.aJO = this.mTop - this.aJN;
                } else {
                    f = 0.0f;
                }
                this.aJP = (int) f3;
                this.mMatrix.postTranslate(f3, f);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    scrollX = i > getWidth() ? getWidth() : i;
                    if (this.aJv <= screenWidth) {
                        scrollX = 0;
                    } else if (this.aJv > screenWidth && this.aJv / 2.0f < screenWidth) {
                        scrollX = (int) (scrollX - (this.aJv / 4.0f));
                    }
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.aJv - width) / 2.0f);
                    }
                    if (this.aJv <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.aJv) {
                        scrollX = (int) (this.aJv - getWidth());
                    }
                }
                if (scrollX > 0 && this.aJv - scrollX < getWidth()) {
                    scrollX = (int) (this.aJv - getWidth());
                }
                if (this.mMode == 2) {
                    scrollY += (int) ((this.aJw - height) / 2.0f);
                }
                if (this.aJw <= getHeight()) {
                    scrollY = 0;
                } else if (getHeight() + scrollY > this.aJw) {
                    scrollY = (int) (this.aJw - getHeight());
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
                HD();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0046a extends Animation {
        private int Il;
        private boolean aKe = false;
        private boolean aKf = false;
        private long aKg;
        private long aKh;
        private int aKi;
        private long aKj;
        private long aKk;

        public C0046a() {
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
            this.aKg = f;
            this.aKh = f2;
            this.aKj = Math.abs((f * 1000.0f) / 2500.0f);
            this.aKk = Math.abs((f2 * 1000.0f) / 2500.0f);
            setDuration(Math.max(this.aKj, this.aKk));
            setInterpolator(a.this.aJU);
            this.aKi = a.this.getScrollX();
            this.Il = a.this.getScrollY();
            this.aKe = true;
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
            if (this.aKj > this.aKk) {
                j = ((float) this.aKj) * f;
            } else {
                j = ((float) this.aKk) * f;
            }
            float f2 = ((float) (j > this.aKj ? this.aKj : j)) / 1000.0f;
            if (this.aKg > 0) {
                i = this.aKi - ((int) (f2 * (((float) this.aKg) - ((2500.0f * f2) / 2.0f))));
            } else {
                i = this.aKi - ((int) (f2 * (((float) this.aKg) + ((2500.0f * f2) / 2.0f))));
            }
            if (j > this.aKk) {
                j = this.aKk;
            }
            float f3 = ((float) j) / 1000.0f;
            if (this.aKh > 0) {
                i2 = this.Il - ((int) (f3 * (((float) this.aKh) - ((2500.0f * f3) / 2.0f))));
            } else {
                i2 = this.Il - ((int) (f3 * (((float) this.aKh) + ((2500.0f * f3) / 2.0f))));
            }
            if (a.this.aJw + a.this.mTop + a.this.mBottom > a.this.getHeight()) {
                if (i2 < (-a.this.aJN)) {
                    i2 = -a.this.aJN;
                }
                if (a.this.getHeight() + i2 > a.this.aJw + a.this.mBottom + a.this.aJO) {
                    i2 = (int) ((a.this.aJw - a.this.getHeight()) + a.this.mBottom + a.this.aJO);
                }
            } else {
                i2 = 0;
            }
            if (a.this.aJv > a.this.getWidth()) {
                int width = ((float) (a.this.getWidth() + i)) > a.this.aJv ? (int) (a.this.aJv - a.this.getWidth()) : i;
                if (width >= 0) {
                    i3 = width;
                }
            }
            a.this.scrollTo(i3, i2);
            a.this.invalidate();
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            if (!this.aKf) {
                if (a.this.aJB) {
                    this.aKe = false;
                    return false;
                }
                try {
                    if (!super.getTransformation(j, transformation)) {
                        this.aKe = false;
                        return false;
                    }
                    return true;
                } catch (Exception e) {
                    this.aKe = false;
                    return false;
                }
            }
            this.aKf = false;
            this.aKe = false;
            return false;
        }

        public boolean HP() {
            return this.aKe;
        }

        public void stopAnimation() {
            this.aKf = true;
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.aJF = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.atn = onLongClickListener;
    }

    public void setGifSetListener(d dVar) {
        this.atp = dVar;
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
    public void HM() {
        long j;
        c poll = this.aJX.poll();
        if (poll == null) {
            this.aKc = true;
            return;
        }
        this.aKc = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.aJW != null) {
            j = this.aJW.delay - (currentTimeMillis - this.aKb);
            this.aJY.offer(this.aJW);
        } else {
            j = 0;
        }
        this.aJW = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public c HN() {
        c poll = this.aJY.poll();
        if (poll == null) {
            poll = new c(null);
            try {
                poll.aKl = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
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
        public Bitmap aKl;
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
            while (a.this.mState == 1 && a.this.aJL != null && a.this.aJV > 0 && a.this.width > 0 && a.this.height > 0) {
                try {
                    a.this.aJL.T(a.this.aJZ);
                    c HN = a.this.HN();
                    if (HN.aKl == null || (HN.aKl.getWidth() != a.this.width && HN.aKl.getHeight() != a.this.height)) {
                        try {
                            HN.aKl = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_8888);
                        } catch (OutOfMemoryError e) {
                            TbadkCoreApplication.m9getInst().onAppMemoryLow();
                            try {
                                HN.aKl = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_4444);
                            } catch (OutOfMemoryError e2) {
                                TbadkCoreApplication.m9getInst().onAppMemoryLow();
                            } catch (Throwable th) {
                                BdLog.e(th.getMessage());
                            }
                        } catch (Throwable th2) {
                            BdLog.e(th2.getMessage());
                        }
                    }
                    a.this.aJL.a(HN.aKl, null);
                    HN.delay = a.this.aJL.U(a.this.aJZ);
                    a.this.aJZ++;
                    if (HN.aKl == null) {
                        a.this.aJZ++;
                    }
                    a.this.aJZ %= a.this.aJV;
                    a.this.aJX.put(HN);
                    if (a.this.aKc) {
                        a.this.mHandler.sendEmptyMessage(1);
                    }
                } catch (Exception e3) {
                    return;
                }
            }
        }
    }

    public boolean HO() {
        return this.aJR;
    }

    public void setLoadBigImage(boolean z) {
        this.aJR = z;
    }

    public int getBottomOffset() {
        return this.aJO;
    }

    public int getLeftOffset() {
        return this.aJP;
    }
}
