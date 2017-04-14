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
    private int aJA;
    private int aJB;
    private e aJC;
    private View.OnClickListener aJD;
    private C0046a aJE;
    private float aJF;
    private boolean aJG;
    private boolean aJH;
    private int aJI;
    private volatile com.baidu.adp.gif.b aJJ;
    private Bitmap aJK;
    private int aJL;
    private int aJM;
    private int aJN;
    private int aJO;
    private boolean aJP;
    private boolean aJQ;
    private float aJR;
    private Interpolator aJS;
    private int aJT;
    private c aJU;
    private BlockingLinkedDeque<c> aJV;
    private BlockingLinkedDeque<c> aJW;
    private volatile int aJX;
    private b aJY;
    private volatile long aJZ;
    private float aJt;
    private float aJu;
    private ArrayList<Float> aJv;
    private float aJw;
    private float aJx;
    private float aJy;
    private boolean aJz;
    private volatile boolean aKa;
    private int ahj;
    private View.OnLongClickListener atl;
    private d atn;
    private int ato;
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
        this.aJQ = z;
    }

    public a(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aJz = false;
        this.mImageData = null;
        this.ato = 0;
        this.aJA = 1300;
        this.aJB = 0;
        this.aJC = null;
        this.aJD = null;
        this.atl = null;
        this.atn = null;
        this.aJF = 1.0f;
        this.ahj = 0;
        this.mMode = 0;
        this.aJG = false;
        this.aJH = false;
        this.aJI = 0;
        this.aJJ = null;
        this.aJK = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aJL = 0;
        this.aJM = 0;
        this.aJN = 0;
        this.aJO = 0;
        this.aJS = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aJT = 0;
        this.aJU = null;
        this.aJV = new BlockingLinkedDeque<>(5);
        this.aJW = new BlockingLinkedDeque<>(6);
        this.aJX = 0;
        this.aJZ = 0L;
        this.mState = 0;
        this.aKa = true;
        this.mHandler = new Handler(new com.baidu.tbadk.widget.b(this));
        initData();
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aJz = false;
        this.mImageData = null;
        this.ato = 0;
        this.aJA = 1300;
        this.aJB = 0;
        this.aJC = null;
        this.aJD = null;
        this.atl = null;
        this.atn = null;
        this.aJF = 1.0f;
        this.ahj = 0;
        this.mMode = 0;
        this.aJG = false;
        this.aJH = false;
        this.aJI = 0;
        this.aJJ = null;
        this.aJK = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aJL = 0;
        this.aJM = 0;
        this.aJN = 0;
        this.aJO = 0;
        this.aJS = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aJT = 0;
        this.aJU = null;
        this.aJV = new BlockingLinkedDeque<>(5);
        this.aJW = new BlockingLinkedDeque<>(6);
        this.aJX = 0;
        this.aJZ = 0L;
        this.mState = 0;
        this.aKa = true;
        this.mHandler = new Handler(new com.baidu.tbadk.widget.b(this));
        initData();
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aJz = false;
        this.mImageData = null;
        this.ato = 0;
        this.aJA = 1300;
        this.aJB = 0;
        this.aJC = null;
        this.aJD = null;
        this.atl = null;
        this.atn = null;
        this.aJF = 1.0f;
        this.ahj = 0;
        this.mMode = 0;
        this.aJG = false;
        this.aJH = false;
        this.aJI = 0;
        this.aJJ = null;
        this.aJK = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aJL = 0;
        this.aJM = 0;
        this.aJN = 0;
        this.aJO = 0;
        this.aJS = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aJT = 0;
        this.aJU = null;
        this.aJV = new BlockingLinkedDeque<>(5);
        this.aJW = new BlockingLinkedDeque<>(6);
        this.aJX = 0;
        this.aJZ = 0L;
        this.mState = 0;
        this.aKa = true;
        this.mHandler = new Handler(new com.baidu.tbadk.widget.b(this));
        initData();
    }

    public int getImageType() {
        return this.ahj;
    }

    public void setImageMode(int i) {
        this.aJB = i;
    }

    public void h(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.ato = i;
    }

    public void HA() {
        this.aJH = false;
        this.aJz = false;
        this.mMode = 0;
        HE();
        if (this.mCurrentScale < this.aJw) {
            this.mCurrentScale = this.aJw;
            HL();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.aJz = true;
                this.aJG = false;
                this.aJH = false;
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
            this.aJF = m(motionEvent);
            if (this.aJF > 10.0f) {
                this.mMode = 2;
            }
        }
        if (this.mMode == 2 || !this.mGestureDetector.onTouchEvent(motionEvent)) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.aJG = true;
                        this.aJH = true;
                        if (this.ahj != 1 && this.ahj != 2) {
                            float m = m(motionEvent);
                            if (m >= 0.0f && Math.abs(this.aJF - m) >= 10.0f) {
                                if (Math.abs(this.aJF - m) > 100.0f) {
                                    this.aJF = m;
                                    break;
                                } else {
                                    float f = m / this.aJF;
                                    this.aJF = m;
                                    this.aJy = this.mCurrentScale;
                                    this.mCurrentScale *= f;
                                    if (this.mCurrentScale > this.aJx) {
                                        this.mCurrentScale = this.aJx;
                                    }
                                    if (this.mCurrentScale < this.aJw / 4.0f) {
                                        this.mCurrentScale = this.aJw / 4.0f;
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
        return this.aJw == this.mCurrentScale;
    }

    private void HC() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            if (this.aJB == 0) {
                float width = this.mViewWidth / imageBitmap.getWidth();
                float height = this.mViewHeight / imageBitmap.getHeight();
                if (this.aJQ) {
                    if (this.ahj == 2) {
                        this.aJw = 2.5f;
                    } else {
                        this.aJw = Math.min(width, height);
                    }
                } else if (this.ahj == 2) {
                    this.aJw = 1.0f;
                } else {
                    float f = this.aJR;
                    float f2 = f >= 1.0f ? f : 1.0f;
                    if (imageBitmap.getWidth() * f2 < this.mViewWidth && imageBitmap.getHeight() * f2 < this.mViewHeight) {
                        this.aJw = f2;
                    } else {
                        this.aJw = Math.min(width, height);
                    }
                }
            } else {
                this.aJw = Math.max(this.mViewWidth / imageBitmap.getWidth(), ((this.mViewHeight - this.mTop) - this.mBottom) / imageBitmap.getHeight());
            }
            this.aJx = this.aJA / (imageBitmap.getWidth() * imageBitmap.getHeight());
            this.aJx = FloatMath.sqrt(this.aJx);
            if (this.aJx > 10.0f) {
                this.aJx = 10.0f;
            }
            this.aJv.clear();
            this.aJv.add(Float.valueOf(this.aJw));
            this.mCurrentScale = this.aJw;
            this.aJy = this.mCurrentScale;
            HL();
            return;
        }
        this.aJt = 0.0f;
        this.aJu = 0.0f;
        this.aJw = 1.0f;
        this.aJx = 1.0f;
        this.mCurrentScale = 1.0f;
        this.aJy = this.mCurrentScale;
        this.aJv.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    private void HD() {
        if (this.aJC != null) {
            this.aJC.a(this, canZoomIn(), canZoomOut());
        }
    }

    public void setOnSizeChangedListener(e eVar) {
        this.aJC = eVar;
    }

    public byte[] getImageData() {
        return this.mImageData;
    }

    public void setImageData(byte[] bArr) {
        this.mImageData = bArr;
    }

    public Bitmap getGifCache() {
        return this.aJK;
    }

    public void setGifCache(Bitmap bitmap) {
        this.aJK = bitmap;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        boolean z;
        int i4;
        if (this.ahj == 2 && this.aJO != 0 && !this.aJE.HP()) {
            int width = getWidth();
            int height = getHeight();
            Drawable drawable = getDrawable();
            float f = 0.0f;
            float f2 = height * 0.3f;
            float f3 = width;
            float f4 = (1.0f - 0.3f) * height;
            if (this.aJQ && drawable != null) {
                Rect bounds = drawable.getBounds();
                int i5 = bounds.right - bounds.left;
                int i6 = bounds.bottom - bounds.top;
                f = (width / 2) - (i5 * 2.5f);
                f2 = (height / 2) - (i6 * 2.5f);
                f3 = (i5 * 2.5f) + (width / 2);
                f4 = (i6 * 2.5f) + (height / 2);
            }
            this.mPaint.setColor(aq.getColor(this.aJO));
            canvas.drawRect(f, f2, f3, f4, this.mPaint);
            this.mPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        }
        super.onDraw(canvas);
        if (this.ahj == 1 && this.aJK != null && !this.aJK.isRecycled()) {
            int width2 = this.aJK.getWidth();
            int height2 = this.aJK.getHeight();
            int width3 = getWidth();
            int height3 = getHeight();
            int i7 = (width3 - width2) >> 1;
            int i8 = (height3 - height2) >> 1;
            float f5 = this.aJR;
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
            if (this.aJI == 1 && this.aJJ != null && this.aJU != null && this.aJU.aKj != null) {
                if (z) {
                    canvas.drawBitmap(this.aJU.aKj, i3, i2, (Paint) null);
                } else {
                    canvas.drawBitmap(this.aJU.aKj, this.mMatrix, this.mPaint);
                }
                invalidate();
            } else if (z) {
                canvas.drawBitmap(this.aJK, i3, i2, (Paint) null);
            } else {
                canvas.drawBitmap(this.aJK, this.mMatrix, this.mPaint);
            }
        }
    }

    public void play() {
        com.baidu.adp.widget.a.a aVar;
        if (this.ahj == 1) {
            if (this.aJJ == null) {
                if (this.aJY != null) {
                    this.aJY.interrupt();
                    this.aJY = null;
                }
                if (this.mImageData != null) {
                    try {
                        aVar = a.C0003a.dC().e(this.mImageData, 0, this.mImageData.length);
                    } catch (StackOverflowError e2) {
                        aVar = null;
                    }
                    if (aVar != null && aVar.getGif() != null) {
                        this.aJJ = aVar.getGif();
                        if (this.aJJ != null) {
                            this.aJI = 1;
                            this.width = this.aJJ.getWidth();
                            this.height = this.aJJ.getHeight();
                            this.aJX = 0;
                            this.aJT = this.aJJ.dD();
                        } else {
                            this.aJI = 0;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            if (this.aJJ != null && this.mState == 0) {
                this.aKa = true;
                this.aJY = new b(this, null);
                this.aJV.clear();
                this.aJW.clear();
                this.mState = 1;
                this.aJY.start();
            }
        }
    }

    public void pause() {
        if (this.ahj == 1) {
            this.mState = 0;
            if (this.aJY != null) {
                this.aJY.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.ahj == 1) {
            this.mState = 0;
            if (this.aJY != null) {
                this.aJY.interrupt();
                this.aJY = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.aKa = true;
            this.aJU = null;
            this.aJW.clear();
            this.aJV.clear();
            this.width = 0;
            this.height = 0;
            this.aJX = 0;
            this.aJT = 0;
            if (this.aJJ != null) {
                this.aJJ = null;
            }
        }
    }

    private void initData() {
        this.aJR = k.ah(getContext());
        this.aJA = k.ag(getContext()) * k.af(getContext()) * 2;
        if (this.aJA < 1690000) {
            this.aJA = 1690000;
        }
        this.aJt = 0.0f;
        this.aJu = 0.0f;
        this.aJv = new ArrayList<>();
        this.aJw = 1.0f;
        this.aJx = 1.0f;
        this.mCurrentScale = 1.0f;
        this.aJy = this.mCurrentScale;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.aJE = new C0046a();
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
        if (this.aJt >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.aJt) {
                scrollX = (int) (this.aJt - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.aJu + this.mTop + this.mBottom >= getHeight()) {
            i = scrollY < (-this.aJL) ? -this.aJL : scrollY;
            if (getHeight() + i > this.aJu + this.mBottom + this.aJM) {
                i = (int) ((this.aJu - getHeight()) + this.mBottom + this.aJM);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.aJt;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.aJu;
    }

    public boolean HF() {
        if (this.ahj == 1 || this.ahj == 2) {
            return true;
        }
        return !this.aJH && getScrollX() >= ((int) (this.aJt - ((float) getWidth()))) + (-1);
    }

    public boolean HG() {
        if (this.ahj == 1 || this.ahj == 2) {
            return true;
        }
        return !this.aJH && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.aJE.HP()) {
            this.aJE.stopAnimation();
        }
        this.aJO = 0;
        super.setImageBitmap(bitmap);
        HC();
        this.ahj = 0;
    }

    public void i(Bitmap bitmap) {
        Bitmap imageBitmap = getImageBitmap();
        if (bitmap != null && !bitmap.isRecycled()) {
            if (imageBitmap != null && (imageBitmap.getWidth() != bitmap.getWidth() || imageBitmap.getHeight() != bitmap.getHeight())) {
                setImageBitmap(bitmap);
                return;
            }
            if (this.aJE.HP()) {
                this.aJE.stopAnimation();
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            super.setImageBitmap(bitmap);
            super.setImageMatrix(this.mMatrix);
            scrollTo(scrollX, scrollY);
            this.ahj = 0;
        }
    }

    public void a(byte[] bArr, Bitmap bitmap) {
        if (this.aJE.HP()) {
            this.aJE.stopAnimation();
        }
        super.setImageDrawable(null);
        stop();
        HC();
        this.ahj = 1;
        this.aJK = bitmap;
        this.mImageData = bArr;
        if (this.atn != null) {
            this.atn.a(this);
        }
    }

    public void onDestroy() {
        if (this.aJE.HP()) {
            this.aJE.stopAnimation();
        }
        super.setImageDrawable(null);
        this.mImageData = null;
        this.aJK = null;
        stop();
        if (this.aJJ != null) {
            this.aJJ.close();
            this.aJJ = null;
        }
    }

    public void release() {
        if (this.aJE.HP()) {
            this.aJE.stopAnimation();
        }
        stop();
        super.setImageDrawable(null);
        this.aJK = null;
    }

    public void HH() {
        if (this.aJE.HP()) {
            this.aJE.stopAnimation();
        }
        if (this.aJQ) {
            super.setImageBitmap(BitmapHelper.getCashBitmap(w.g.icon_default_avatar100));
        } else {
            super.setImageBitmap(BitmapHelper.getCashBitmap(w.g.btn_see_default));
        }
        this.ahj = 2;
        HC();
    }

    public void HI() {
        if (this.ahj != 1 && this.ahj != 2) {
            int size = this.aJv.size();
            if (size > 0) {
                this.aJv.add(Float.valueOf(this.aJv.get(size - 1).floatValue() * 1.25f));
            } else {
                this.aJv.add(Float.valueOf(this.aJw));
            }
            HL();
        }
    }

    public void HJ() {
        if (this.ahj != 1 && this.ahj != 2) {
            int size = this.aJv.size();
            if (size > 1) {
                this.aJv.remove(size - 1);
            }
            HL();
        }
    }

    public void HK() {
        HD();
        if (this.ahj != 1 && this.ahj != 2 && this.mCurrentScale != this.aJw) {
            this.aJv.clear();
            this.aJv.add(Float.valueOf(this.aJw));
            this.mCurrentScale = this.aJw;
            this.aJy = this.mCurrentScale;
            HL();
        }
    }

    public boolean canZoomIn() {
        if (this.ahj == 1 || this.ahj == 2) {
            return false;
        }
        int size = this.aJv.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.aJv.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.aJA) && floatValue <= 5.0f;
    }

    public boolean canZoomOut() {
        if (this.ahj == 1 || this.ahj == 2) {
            return false;
        }
        int size = this.aJv.size();
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
                    int size = this.aJv.size();
                    if (size > 0) {
                        f2 = this.aJv.get(size - 1).floatValue();
                    } else {
                        f2 = this.aJw;
                    }
                    this.mCurrentScale = f2;
                }
                this.mMatrix.setScale(this.mCurrentScale, this.mCurrentScale);
                this.aJt = imageBitmap.getWidth() * this.mCurrentScale;
                this.aJu = imageBitmap.getHeight() * this.mCurrentScale;
                float width = this.aJy * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.aJy;
                this.aJL = this.mTop;
                this.aJM = 0;
                float f3 = this.aJt < ((float) this.mViewWidth) ? (int) ((this.mViewWidth - this.aJt) / 2.0f) : 0.0f;
                if (this.aJu < this.mViewHeight) {
                    f = (int) ((this.mViewHeight - this.aJu) / 2.0f);
                    if (this.aJB == 1 && f > this.mTop) {
                        f = this.mTop;
                    }
                    this.aJL = (int) (this.mTop - f);
                    this.aJM = this.mTop - this.aJL;
                } else {
                    f = 0.0f;
                }
                this.aJN = (int) f3;
                this.mMatrix.postTranslate(f3, f);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    scrollX = i > getWidth() ? getWidth() : i;
                    if (this.aJt <= screenWidth) {
                        scrollX = 0;
                    } else if (this.aJt > screenWidth && this.aJt / 2.0f < screenWidth) {
                        scrollX = (int) (scrollX - (this.aJt / 4.0f));
                    }
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.aJt - width) / 2.0f);
                    }
                    if (this.aJt <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.aJt) {
                        scrollX = (int) (this.aJt - getWidth());
                    }
                }
                if (scrollX > 0 && this.aJt - scrollX < getWidth()) {
                    scrollX = (int) (this.aJt - getWidth());
                }
                if (this.mMode == 2) {
                    scrollY += (int) ((this.aJu - height) / 2.0f);
                }
                if (this.aJu <= getHeight()) {
                    scrollY = 0;
                } else if (getHeight() + scrollY > this.aJu) {
                    scrollY = (int) (this.aJu - getHeight());
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
        private int Ij;
        private boolean aKc = false;
        private boolean aKd = false;
        private long aKe;
        private long aKf;
        private int aKg;
        private long aKh;
        private long aKi;

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
            this.aKe = f;
            this.aKf = f2;
            this.aKh = Math.abs((f * 1000.0f) / 2500.0f);
            this.aKi = Math.abs((f2 * 1000.0f) / 2500.0f);
            setDuration(Math.max(this.aKh, this.aKi));
            setInterpolator(a.this.aJS);
            this.aKg = a.this.getScrollX();
            this.Ij = a.this.getScrollY();
            this.aKc = true;
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
            if (this.aKh > this.aKi) {
                j = ((float) this.aKh) * f;
            } else {
                j = ((float) this.aKi) * f;
            }
            float f2 = ((float) (j > this.aKh ? this.aKh : j)) / 1000.0f;
            if (this.aKe > 0) {
                i = this.aKg - ((int) (f2 * (((float) this.aKe) - ((2500.0f * f2) / 2.0f))));
            } else {
                i = this.aKg - ((int) (f2 * (((float) this.aKe) + ((2500.0f * f2) / 2.0f))));
            }
            if (j > this.aKi) {
                j = this.aKi;
            }
            float f3 = ((float) j) / 1000.0f;
            if (this.aKf > 0) {
                i2 = this.Ij - ((int) (f3 * (((float) this.aKf) - ((2500.0f * f3) / 2.0f))));
            } else {
                i2 = this.Ij - ((int) (f3 * (((float) this.aKf) + ((2500.0f * f3) / 2.0f))));
            }
            if (a.this.aJu + a.this.mTop + a.this.mBottom > a.this.getHeight()) {
                if (i2 < (-a.this.aJL)) {
                    i2 = -a.this.aJL;
                }
                if (a.this.getHeight() + i2 > a.this.aJu + a.this.mBottom + a.this.aJM) {
                    i2 = (int) ((a.this.aJu - a.this.getHeight()) + a.this.mBottom + a.this.aJM);
                }
            } else {
                i2 = 0;
            }
            if (a.this.aJt > a.this.getWidth()) {
                int width = ((float) (a.this.getWidth() + i)) > a.this.aJt ? (int) (a.this.aJt - a.this.getWidth()) : i;
                if (width >= 0) {
                    i3 = width;
                }
            }
            a.this.scrollTo(i3, i2);
            a.this.invalidate();
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            if (!this.aKd) {
                if (a.this.aJz) {
                    this.aKc = false;
                    return false;
                }
                try {
                    if (!super.getTransformation(j, transformation)) {
                        this.aKc = false;
                        return false;
                    }
                    return true;
                } catch (Exception e) {
                    this.aKc = false;
                    return false;
                }
            }
            this.aKd = false;
            this.aKc = false;
            return false;
        }

        public boolean HP() {
            return this.aKc;
        }

        public void stopAnimation() {
            this.aKd = true;
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.aJD = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.atl = onLongClickListener;
    }

    public void setGifSetListener(d dVar) {
        this.atn = dVar;
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
        c poll = this.aJV.poll();
        if (poll == null) {
            this.aKa = true;
            return;
        }
        this.aKa = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.aJU != null) {
            j = this.aJU.delay - (currentTimeMillis - this.aJZ);
            this.aJW.offer(this.aJU);
        } else {
            j = 0;
        }
        this.aJU = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public c HN() {
        c poll = this.aJW.poll();
        if (poll == null) {
            poll = new c(null);
            try {
                poll.aKj = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
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
        public Bitmap aKj;
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
            while (a.this.mState == 1 && a.this.aJJ != null && a.this.aJT > 0 && a.this.width > 0 && a.this.height > 0) {
                try {
                    a.this.aJJ.T(a.this.aJX);
                    c HN = a.this.HN();
                    if (HN.aKj == null || (HN.aKj.getWidth() != a.this.width && HN.aKj.getHeight() != a.this.height)) {
                        try {
                            HN.aKj = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_8888);
                        } catch (OutOfMemoryError e) {
                            TbadkCoreApplication.m9getInst().onAppMemoryLow();
                            try {
                                HN.aKj = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_4444);
                            } catch (OutOfMemoryError e2) {
                                TbadkCoreApplication.m9getInst().onAppMemoryLow();
                            } catch (Throwable th) {
                                BdLog.e(th.getMessage());
                            }
                        } catch (Throwable th2) {
                            BdLog.e(th2.getMessage());
                        }
                    }
                    a.this.aJJ.a(HN.aKj, null);
                    HN.delay = a.this.aJJ.U(a.this.aJX);
                    a.this.aJX++;
                    if (HN.aKj == null) {
                        a.this.aJX++;
                    }
                    a.this.aJX %= a.this.aJT;
                    a.this.aJV.put(HN);
                    if (a.this.aKa) {
                        a.this.mHandler.sendEmptyMessage(1);
                    }
                } catch (Exception e3) {
                    return;
                }
            }
        }
    }

    public boolean HO() {
        return this.aJP;
    }

    public void setLoadBigImage(boolean z) {
        this.aJP = z;
    }

    public int getBottomOffset() {
        return this.aJM;
    }

    public int getLeftOffset() {
        return this.aJN;
    }
}
