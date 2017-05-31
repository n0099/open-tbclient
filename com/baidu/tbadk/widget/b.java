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
public class b extends ImageView {
    private e aJA;
    private View.OnClickListener aJB;
    private a aJC;
    private float aJD;
    private boolean aJE;
    private boolean aJF;
    private int aJG;
    private volatile com.baidu.adp.gif.b aJH;
    private Bitmap aJI;
    private int aJJ;
    private int aJK;
    private int aJL;
    private int aJM;
    private boolean aJN;
    private boolean aJO;
    private float aJP;
    private Interpolator aJQ;
    private int aJR;
    private c aJS;
    private BlockingLinkedDeque<c> aJT;
    private BlockingLinkedDeque<c> aJU;
    private volatile int aJV;
    private C0050b aJW;
    private volatile long aJX;
    private volatile boolean aJY;
    private float aJr;
    private float aJs;
    private ArrayList<Float> aJt;
    private float aJu;
    private float aJv;
    private float aJw;
    private boolean aJx;
    private int aJy;
    private int aJz;
    private int agt;
    private View.OnLongClickListener atb;
    private d atd;
    private int ate;
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
        this.aJO = z;
    }

    public b(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aJx = false;
        this.mImageData = null;
        this.ate = 0;
        this.aJy = 1300;
        this.aJz = 0;
        this.aJA = null;
        this.aJB = null;
        this.atb = null;
        this.atd = null;
        this.aJD = 1.0f;
        this.agt = 0;
        this.mMode = 0;
        this.aJE = false;
        this.aJF = false;
        this.aJG = 0;
        this.aJH = null;
        this.aJI = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aJJ = 0;
        this.aJK = 0;
        this.aJL = 0;
        this.aJM = 0;
        this.aJQ = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aJR = 0;
        this.aJS = null;
        this.aJT = new BlockingLinkedDeque<>(5);
        this.aJU = new BlockingLinkedDeque<>(6);
        this.aJV = 0;
        this.aJX = 0L;
        this.mState = 0;
        this.aJY = true;
        this.mHandler = new Handler(new com.baidu.tbadk.widget.c(this));
        initData();
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aJx = false;
        this.mImageData = null;
        this.ate = 0;
        this.aJy = 1300;
        this.aJz = 0;
        this.aJA = null;
        this.aJB = null;
        this.atb = null;
        this.atd = null;
        this.aJD = 1.0f;
        this.agt = 0;
        this.mMode = 0;
        this.aJE = false;
        this.aJF = false;
        this.aJG = 0;
        this.aJH = null;
        this.aJI = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aJJ = 0;
        this.aJK = 0;
        this.aJL = 0;
        this.aJM = 0;
        this.aJQ = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aJR = 0;
        this.aJS = null;
        this.aJT = new BlockingLinkedDeque<>(5);
        this.aJU = new BlockingLinkedDeque<>(6);
        this.aJV = 0;
        this.aJX = 0L;
        this.mState = 0;
        this.aJY = true;
        this.mHandler = new Handler(new com.baidu.tbadk.widget.c(this));
        initData();
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aJx = false;
        this.mImageData = null;
        this.ate = 0;
        this.aJy = 1300;
        this.aJz = 0;
        this.aJA = null;
        this.aJB = null;
        this.atb = null;
        this.atd = null;
        this.aJD = 1.0f;
        this.agt = 0;
        this.mMode = 0;
        this.aJE = false;
        this.aJF = false;
        this.aJG = 0;
        this.aJH = null;
        this.aJI = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aJJ = 0;
        this.aJK = 0;
        this.aJL = 0;
        this.aJM = 0;
        this.aJQ = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aJR = 0;
        this.aJS = null;
        this.aJT = new BlockingLinkedDeque<>(5);
        this.aJU = new BlockingLinkedDeque<>(6);
        this.aJV = 0;
        this.aJX = 0L;
        this.mState = 0;
        this.aJY = true;
        this.mHandler = new Handler(new com.baidu.tbadk.widget.c(this));
        initData();
    }

    public int getImageType() {
        return this.agt;
    }

    public void setImageMode(int i) {
        this.aJz = i;
    }

    public void h(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.ate = i;
    }

    public void GF() {
        this.aJF = false;
        this.aJx = false;
        this.mMode = 0;
        GJ();
        if (this.mCurrentScale < this.aJu) {
            this.mCurrentScale = this.aJu;
            GQ();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.aJx = true;
                this.aJE = false;
                this.aJF = false;
                break;
            case 1:
                GF();
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
            this.aJD = m(motionEvent);
            if (this.aJD > 10.0f) {
                this.mMode = 2;
            }
        }
        if (this.mMode == 2 || !this.mGestureDetector.onTouchEvent(motionEvent)) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.aJE = true;
                        this.aJF = true;
                        if (this.agt != 1 && this.agt != 2) {
                            float m = m(motionEvent);
                            if (m >= 0.0f && Math.abs(this.aJD - m) >= 10.0f) {
                                if (Math.abs(this.aJD - m) > 100.0f) {
                                    this.aJD = m;
                                    break;
                                } else {
                                    float f = m / this.aJD;
                                    this.aJD = m;
                                    this.aJw = this.mCurrentScale;
                                    this.mCurrentScale *= f;
                                    if (this.mCurrentScale > this.aJv) {
                                        this.mCurrentScale = this.aJv;
                                    }
                                    if (this.mCurrentScale < this.aJu / 4.0f) {
                                        this.mCurrentScale = this.aJu / 4.0f;
                                    }
                                    GQ();
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
            GH();
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public boolean GG() {
        return this.aJu == this.mCurrentScale;
    }

    private void GH() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            if (this.aJz == 0) {
                float width = this.mViewWidth / imageBitmap.getWidth();
                float height = this.mViewHeight / imageBitmap.getHeight();
                if (this.aJO) {
                    if (this.agt == 2) {
                        this.aJu = 2.5f;
                    } else {
                        this.aJu = Math.min(width, height);
                    }
                } else if (this.agt == 2) {
                    this.aJu = 1.0f;
                } else {
                    float f = this.aJP;
                    float f2 = f >= 1.0f ? f : 1.0f;
                    if (imageBitmap.getWidth() * f2 < this.mViewWidth && imageBitmap.getHeight() * f2 < this.mViewHeight) {
                        this.aJu = f2;
                    } else {
                        this.aJu = Math.min(width, height);
                    }
                }
            } else {
                this.aJu = Math.max(this.mViewWidth / imageBitmap.getWidth(), ((this.mViewHeight - this.mTop) - this.mBottom) / imageBitmap.getHeight());
            }
            this.aJv = this.aJy / (imageBitmap.getWidth() * imageBitmap.getHeight());
            this.aJv = FloatMath.sqrt(this.aJv);
            if (this.aJv > 10.0f) {
                this.aJv = 10.0f;
            }
            this.aJt.clear();
            this.aJt.add(Float.valueOf(this.aJu));
            this.mCurrentScale = this.aJu;
            this.aJw = this.mCurrentScale;
            GQ();
            return;
        }
        this.aJr = 0.0f;
        this.aJs = 0.0f;
        this.aJu = 1.0f;
        this.aJv = 1.0f;
        this.mCurrentScale = 1.0f;
        this.aJw = this.mCurrentScale;
        this.aJt.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    private void GI() {
        if (this.aJA != null) {
            this.aJA.a(this, canZoomIn(), canZoomOut());
        }
    }

    public void setOnSizeChangedListener(e eVar) {
        this.aJA = eVar;
    }

    public byte[] getImageData() {
        return this.mImageData;
    }

    public void setImageData(byte[] bArr) {
        this.mImageData = bArr;
    }

    public Bitmap getGifCache() {
        return this.aJI;
    }

    public void setGifCache(Bitmap bitmap) {
        this.aJI = bitmap;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        boolean z;
        int i4;
        if (this.agt == 2 && this.aJM != 0 && !this.aJC.GU()) {
            int width = getWidth();
            int height = getHeight();
            Drawable drawable = getDrawable();
            float f = 0.0f;
            float f2 = height * 0.3f;
            float f3 = width;
            float f4 = (1.0f - 0.3f) * height;
            if (this.aJO && drawable != null) {
                Rect bounds = drawable.getBounds();
                int i5 = bounds.right - bounds.left;
                int i6 = bounds.bottom - bounds.top;
                f = (width / 2) - (i5 * 2.5f);
                f2 = (height / 2) - (i6 * 2.5f);
                f3 = (i5 * 2.5f) + (width / 2);
                f4 = (i6 * 2.5f) + (height / 2);
            }
            this.mPaint.setColor(aq.getColor(this.aJM));
            canvas.drawRect(f, f2, f3, f4, this.mPaint);
            this.mPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        }
        super.onDraw(canvas);
        if (this.agt == 1 && this.aJI != null && !this.aJI.isRecycled()) {
            int width2 = this.aJI.getWidth();
            int height2 = this.aJI.getHeight();
            int width3 = getWidth();
            int height3 = getHeight();
            int i7 = (width3 - width2) >> 1;
            int i8 = (height3 - height2) >> 1;
            float f5 = this.aJP;
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
            if (this.aJG == 1 && this.aJH != null && this.aJS != null && this.aJS.aKh != null) {
                if (z) {
                    canvas.drawBitmap(this.aJS.aKh, i3, i2, (Paint) null);
                } else {
                    canvas.drawBitmap(this.aJS.aKh, this.mMatrix, this.mPaint);
                }
                invalidate();
            } else if (z) {
                canvas.drawBitmap(this.aJI, i3, i2, (Paint) null);
            } else {
                canvas.drawBitmap(this.aJI, this.mMatrix, this.mPaint);
            }
        }
    }

    public void play() {
        com.baidu.adp.widget.a.a aVar;
        if (this.agt == 1) {
            if (this.aJH == null) {
                if (this.aJW != null) {
                    this.aJW.interrupt();
                    this.aJW = null;
                }
                if (this.mImageData != null) {
                    try {
                        aVar = a.C0003a.dD().e(this.mImageData, 0, this.mImageData.length);
                    } catch (StackOverflowError e2) {
                        aVar = null;
                    }
                    if (aVar != null && aVar.getGif() != null) {
                        this.aJH = aVar.getGif();
                        if (this.aJH != null) {
                            this.aJG = 1;
                            this.width = this.aJH.getWidth();
                            this.height = this.aJH.getHeight();
                            this.aJV = 0;
                            this.aJR = this.aJH.dE();
                        } else {
                            this.aJG = 0;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            if (this.aJH != null && this.mState == 0) {
                this.aJY = true;
                this.aJW = new C0050b(this, null);
                this.aJT.clear();
                this.aJU.clear();
                this.mState = 1;
                this.aJW.start();
            }
        }
    }

    public void pause() {
        if (this.agt == 1) {
            this.mState = 0;
            if (this.aJW != null) {
                this.aJW.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.agt == 1) {
            this.mState = 0;
            if (this.aJW != null) {
                this.aJW.interrupt();
                this.aJW = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.aJY = true;
            this.aJS = null;
            this.aJU.clear();
            this.aJT.clear();
            this.width = 0;
            this.height = 0;
            this.aJV = 0;
            this.aJR = 0;
            if (this.aJH != null) {
                this.aJH = null;
            }
        }
    }

    private void initData() {
        this.aJP = k.ah(getContext());
        this.aJy = k.ag(getContext()) * k.af(getContext()) * 2;
        if (this.aJy < 1690000) {
            this.aJy = 1690000;
        }
        this.aJr = 0.0f;
        this.aJs = 0.0f;
        this.aJt = new ArrayList<>();
        this.aJu = 1.0f;
        this.aJv = 1.0f;
        this.mCurrentScale = 1.0f;
        this.aJw = this.mCurrentScale;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.aJC = new a();
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWillNotDraw(false);
        scrollTo(0, 0);
        this.mGestureDetector = new GestureDetector(getContext(), new com.baidu.tbadk.widget.d(this));
    }

    private void GJ() {
        int i = 0;
        int scrollX = getScrollX();
        if (this.aJr >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.aJr) {
                scrollX = (int) (this.aJr - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.aJs + this.mTop + this.mBottom >= getHeight()) {
            i = scrollY < (-this.aJJ) ? -this.aJJ : scrollY;
            if (getHeight() + i > this.aJs + this.mBottom + this.aJK) {
                i = (int) ((this.aJs - getHeight()) + this.mBottom + this.aJK);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.aJr;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.aJs;
    }

    public boolean GK() {
        if (this.agt == 1 || this.agt == 2) {
            return true;
        }
        return !this.aJF && getScrollX() >= ((int) (this.aJr - ((float) getWidth()))) + (-1);
    }

    public boolean GL() {
        if (this.agt == 1 || this.agt == 2) {
            return true;
        }
        return !this.aJF && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.aJC.GU()) {
            this.aJC.stopAnimation();
        }
        this.aJM = 0;
        super.setImageBitmap(bitmap);
        GH();
        this.agt = 0;
    }

    public void i(Bitmap bitmap) {
        Bitmap imageBitmap = getImageBitmap();
        if (bitmap != null && !bitmap.isRecycled()) {
            if (imageBitmap != null && (imageBitmap.getWidth() != bitmap.getWidth() || imageBitmap.getHeight() != bitmap.getHeight())) {
                setImageBitmap(bitmap);
                return;
            }
            if (this.aJC.GU()) {
                this.aJC.stopAnimation();
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            super.setImageBitmap(bitmap);
            super.setImageMatrix(this.mMatrix);
            scrollTo(scrollX, scrollY);
            this.agt = 0;
        }
    }

    public void a(byte[] bArr, Bitmap bitmap) {
        if (this.aJC.GU()) {
            this.aJC.stopAnimation();
        }
        super.setImageDrawable(null);
        stop();
        GH();
        this.agt = 1;
        this.aJI = bitmap;
        this.mImageData = bArr;
        if (this.atd != null) {
            this.atd.a(this);
        }
    }

    public void onDestroy() {
        if (this.aJC.GU()) {
            this.aJC.stopAnimation();
        }
        super.setImageDrawable(null);
        this.mImageData = null;
        this.aJI = null;
        stop();
        if (this.aJH != null) {
            this.aJH.close();
            this.aJH = null;
        }
    }

    public void release() {
        if (this.aJC.GU()) {
            this.aJC.stopAnimation();
        }
        stop();
        super.setImageDrawable(null);
        this.aJI = null;
    }

    public void GM() {
        if (this.aJC.GU()) {
            this.aJC.stopAnimation();
        }
        if (this.aJO) {
            super.setImageBitmap(BitmapHelper.getCashBitmap(w.g.icon_default_avatar100));
        } else {
            super.setImageBitmap(BitmapHelper.getCashBitmap(w.g.btn_see_default));
        }
        this.agt = 2;
        GH();
    }

    public void GN() {
        if (this.agt != 1 && this.agt != 2) {
            int size = this.aJt.size();
            if (size > 0) {
                this.aJt.add(Float.valueOf(this.aJt.get(size - 1).floatValue() * 1.25f));
            } else {
                this.aJt.add(Float.valueOf(this.aJu));
            }
            GQ();
        }
    }

    public void GO() {
        if (this.agt != 1 && this.agt != 2) {
            int size = this.aJt.size();
            if (size > 1) {
                this.aJt.remove(size - 1);
            }
            GQ();
        }
    }

    public void GP() {
        GI();
        if (this.agt != 1 && this.agt != 2 && this.mCurrentScale != this.aJu) {
            this.aJt.clear();
            this.aJt.add(Float.valueOf(this.aJu));
            this.mCurrentScale = this.aJu;
            this.aJw = this.mCurrentScale;
            GQ();
        }
    }

    public boolean canZoomIn() {
        if (this.agt == 1 || this.agt == 2) {
            return false;
        }
        int size = this.aJt.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.aJt.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.aJy) && floatValue <= 5.0f;
    }

    public boolean canZoomOut() {
        if (this.agt == 1 || this.agt == 2) {
            return false;
        }
        int size = this.aJt.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled()) {
            return false;
        }
        return size > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GQ() {
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
                    int size = this.aJt.size();
                    if (size > 0) {
                        f2 = this.aJt.get(size - 1).floatValue();
                    } else {
                        f2 = this.aJu;
                    }
                    this.mCurrentScale = f2;
                }
                this.mMatrix.setScale(this.mCurrentScale, this.mCurrentScale);
                this.aJr = imageBitmap.getWidth() * this.mCurrentScale;
                this.aJs = imageBitmap.getHeight() * this.mCurrentScale;
                float width = this.aJw * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.aJw;
                this.aJJ = this.mTop;
                this.aJK = 0;
                float f3 = this.aJr < ((float) this.mViewWidth) ? (int) ((this.mViewWidth - this.aJr) / 2.0f) : 0.0f;
                if (this.aJs < this.mViewHeight) {
                    f = (int) ((this.mViewHeight - this.aJs) / 2.0f);
                    if (this.aJz == 1 && f > this.mTop) {
                        f = this.mTop;
                    }
                    this.aJJ = (int) (this.mTop - f);
                    this.aJK = this.mTop - this.aJJ;
                } else {
                    f = 0.0f;
                }
                this.aJL = (int) f3;
                this.mMatrix.postTranslate(f3, f);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    scrollX = i > getWidth() ? getWidth() : i;
                    if (this.aJr <= screenWidth) {
                        scrollX = 0;
                    } else if (this.aJr > screenWidth && this.aJr / 2.0f < screenWidth) {
                        scrollX = (int) (scrollX - (this.aJr / 4.0f));
                    }
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.aJr - width) / 2.0f);
                    }
                    if (this.aJr <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.aJr) {
                        scrollX = (int) (this.aJr - getWidth());
                    }
                }
                if (scrollX > 0 && this.aJr - scrollX < getWidth()) {
                    scrollX = (int) (this.aJr - getWidth());
                }
                if (this.mMode == 2) {
                    scrollY += (int) ((this.aJs - height) / 2.0f);
                }
                if (this.aJs <= getHeight()) {
                    scrollY = 0;
                } else if (getHeight() + scrollY > this.aJs) {
                    scrollY = (int) (this.aJs - getHeight());
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
                GI();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Animation {
        private boolean aKa = false;
        private boolean aKb = false;
        private long aKc;
        private long aKd;
        private int aKe;
        private long aKf;
        private long aKg;
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
            this.aKc = f;
            this.aKd = f2;
            this.aKf = Math.abs((f * 1000.0f) / 2500.0f);
            this.aKg = Math.abs((f2 * 1000.0f) / 2500.0f);
            setDuration(Math.max(this.aKf, this.aKg));
            setInterpolator(b.this.aJQ);
            this.aKe = b.this.getScrollX();
            this.mStartY = b.this.getScrollY();
            this.aKa = true;
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
            if (this.aKf > this.aKg) {
                j = ((float) this.aKf) * f;
            } else {
                j = ((float) this.aKg) * f;
            }
            float f2 = ((float) (j > this.aKf ? this.aKf : j)) / 1000.0f;
            if (this.aKc > 0) {
                i = this.aKe - ((int) (f2 * (((float) this.aKc) - ((2500.0f * f2) / 2.0f))));
            } else {
                i = this.aKe - ((int) (f2 * (((float) this.aKc) + ((2500.0f * f2) / 2.0f))));
            }
            if (j > this.aKg) {
                j = this.aKg;
            }
            float f3 = ((float) j) / 1000.0f;
            if (this.aKd > 0) {
                i2 = this.mStartY - ((int) (f3 * (((float) this.aKd) - ((2500.0f * f3) / 2.0f))));
            } else {
                i2 = this.mStartY - ((int) (f3 * (((float) this.aKd) + ((2500.0f * f3) / 2.0f))));
            }
            if (b.this.aJs + b.this.mTop + b.this.mBottom > b.this.getHeight()) {
                if (i2 < (-b.this.aJJ)) {
                    i2 = -b.this.aJJ;
                }
                if (b.this.getHeight() + i2 > b.this.aJs + b.this.mBottom + b.this.aJK) {
                    i2 = (int) ((b.this.aJs - b.this.getHeight()) + b.this.mBottom + b.this.aJK);
                }
            } else {
                i2 = 0;
            }
            if (b.this.aJr > b.this.getWidth()) {
                int width = ((float) (b.this.getWidth() + i)) > b.this.aJr ? (int) (b.this.aJr - b.this.getWidth()) : i;
                if (width >= 0) {
                    i3 = width;
                }
            }
            b.this.scrollTo(i3, i2);
            b.this.invalidate();
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            if (!this.aKb) {
                if (b.this.aJx) {
                    this.aKa = false;
                    return false;
                }
                try {
                    if (!super.getTransformation(j, transformation)) {
                        this.aKa = false;
                        return false;
                    }
                    return true;
                } catch (Exception e) {
                    this.aKa = false;
                    return false;
                }
            }
            this.aKb = false;
            this.aKa = false;
            return false;
        }

        public boolean GU() {
            return this.aKa;
        }

        public void stopAnimation() {
            this.aKb = true;
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.aJB = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.atb = onLongClickListener;
    }

    public void setGifSetListener(d dVar) {
        this.atd = dVar;
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
    public void GR() {
        long j;
        c poll = this.aJT.poll();
        if (poll == null) {
            this.aJY = true;
            return;
        }
        this.aJY = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.aJS != null) {
            j = this.aJS.delay - (currentTimeMillis - this.aJX);
            this.aJU.offer(this.aJS);
        } else {
            j = 0;
        }
        this.aJS = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public c GS() {
        c poll = this.aJU.poll();
        if (poll == null) {
            poll = new c(null);
            try {
                poll.aKh = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
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
        public Bitmap aKh;
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
    public class C0050b extends Thread {
        private C0050b() {
        }

        /* synthetic */ C0050b(b bVar, C0050b c0050b) {
            this();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (b.this.mState == 1 && b.this.aJH != null && b.this.aJR > 0 && b.this.width > 0 && b.this.height > 0) {
                try {
                    b.this.aJH.T(b.this.aJV);
                    c GS = b.this.GS();
                    if (GS.aKh == null || (GS.aKh.getWidth() != b.this.width && GS.aKh.getHeight() != b.this.height)) {
                        try {
                            GS.aKh = Bitmap.createBitmap(b.this.width, b.this.height, Bitmap.Config.ARGB_8888);
                        } catch (OutOfMemoryError e) {
                            TbadkCoreApplication.m9getInst().onAppMemoryLow();
                            try {
                                GS.aKh = Bitmap.createBitmap(b.this.width, b.this.height, Bitmap.Config.ARGB_4444);
                            } catch (OutOfMemoryError e2) {
                                TbadkCoreApplication.m9getInst().onAppMemoryLow();
                            } catch (Throwable th) {
                                BdLog.e(th.getMessage());
                            }
                        } catch (Throwable th2) {
                            BdLog.e(th2.getMessage());
                        }
                    }
                    b.this.aJH.a(GS.aKh, null);
                    GS.delay = b.this.aJH.U(b.this.aJV);
                    b.this.aJV++;
                    if (GS.aKh == null) {
                        b.this.aJV++;
                    }
                    b.this.aJV %= b.this.aJR;
                    b.this.aJT.put(GS);
                    if (b.this.aJY) {
                        b.this.mHandler.sendEmptyMessage(1);
                    }
                } catch (Exception e3) {
                    return;
                }
            }
        }
    }

    public boolean GT() {
        return this.aJN;
    }

    public void setLoadBigImage(boolean z) {
        this.aJN = z;
    }

    public int getBottomOffset() {
        return this.aJK;
    }

    public int getLeftOffset() {
        return this.aJL;
    }
}
