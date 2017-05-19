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
    private float aJE;
    private float aJF;
    private ArrayList<Float> aJG;
    private float aJH;
    private float aJI;
    private float aJJ;
    private boolean aJK;
    private int aJL;
    private int aJM;
    private e aJN;
    private View.OnClickListener aJO;
    private a aJP;
    private float aJQ;
    private boolean aJR;
    private boolean aJS;
    private int aJT;
    private volatile com.baidu.adp.gif.b aJU;
    private Bitmap aJV;
    private int aJW;
    private int aJX;
    private int aJY;
    private int aJZ;
    private boolean aKa;
    private boolean aKb;
    private float aKc;
    private Interpolator aKd;
    private int aKe;
    private c aKf;
    private BlockingLinkedDeque<c> aKg;
    private BlockingLinkedDeque<c> aKh;
    private volatile int aKi;
    private C0050b aKj;
    private volatile long aKk;
    private volatile boolean aKl;
    private int agC;
    private View.OnLongClickListener atr;
    private d att;
    private int atu;
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
        this.aKb = z;
    }

    public b(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aJK = false;
        this.mImageData = null;
        this.atu = 0;
        this.aJL = 1300;
        this.aJM = 0;
        this.aJN = null;
        this.aJO = null;
        this.atr = null;
        this.att = null;
        this.aJQ = 1.0f;
        this.agC = 0;
        this.mMode = 0;
        this.aJR = false;
        this.aJS = false;
        this.aJT = 0;
        this.aJU = null;
        this.aJV = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aJW = 0;
        this.aJX = 0;
        this.aJY = 0;
        this.aJZ = 0;
        this.aKd = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aKe = 0;
        this.aKf = null;
        this.aKg = new BlockingLinkedDeque<>(5);
        this.aKh = new BlockingLinkedDeque<>(6);
        this.aKi = 0;
        this.aKk = 0L;
        this.mState = 0;
        this.aKl = true;
        this.mHandler = new Handler(new com.baidu.tbadk.widget.c(this));
        initData();
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aJK = false;
        this.mImageData = null;
        this.atu = 0;
        this.aJL = 1300;
        this.aJM = 0;
        this.aJN = null;
        this.aJO = null;
        this.atr = null;
        this.att = null;
        this.aJQ = 1.0f;
        this.agC = 0;
        this.mMode = 0;
        this.aJR = false;
        this.aJS = false;
        this.aJT = 0;
        this.aJU = null;
        this.aJV = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aJW = 0;
        this.aJX = 0;
        this.aJY = 0;
        this.aJZ = 0;
        this.aKd = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aKe = 0;
        this.aKf = null;
        this.aKg = new BlockingLinkedDeque<>(5);
        this.aKh = new BlockingLinkedDeque<>(6);
        this.aKi = 0;
        this.aKk = 0L;
        this.mState = 0;
        this.aKl = true;
        this.mHandler = new Handler(new com.baidu.tbadk.widget.c(this));
        initData();
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aJK = false;
        this.mImageData = null;
        this.atu = 0;
        this.aJL = 1300;
        this.aJM = 0;
        this.aJN = null;
        this.aJO = null;
        this.atr = null;
        this.att = null;
        this.aJQ = 1.0f;
        this.agC = 0;
        this.mMode = 0;
        this.aJR = false;
        this.aJS = false;
        this.aJT = 0;
        this.aJU = null;
        this.aJV = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aJW = 0;
        this.aJX = 0;
        this.aJY = 0;
        this.aJZ = 0;
        this.aKd = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aKe = 0;
        this.aKf = null;
        this.aKg = new BlockingLinkedDeque<>(5);
        this.aKh = new BlockingLinkedDeque<>(6);
        this.aKi = 0;
        this.aKk = 0L;
        this.mState = 0;
        this.aKl = true;
        this.mHandler = new Handler(new com.baidu.tbadk.widget.c(this));
        initData();
    }

    public int getImageType() {
        return this.agC;
    }

    public void setImageMode(int i) {
        this.aJM = i;
    }

    public void h(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.atu = i;
    }

    public void GL() {
        this.aJS = false;
        this.aJK = false;
        this.mMode = 0;
        GP();
        if (this.mCurrentScale < this.aJH) {
            this.mCurrentScale = this.aJH;
            GW();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.aJK = true;
                this.aJR = false;
                this.aJS = false;
                break;
            case 1:
                GL();
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
            this.aJQ = m(motionEvent);
            if (this.aJQ > 10.0f) {
                this.mMode = 2;
            }
        }
        if (this.mMode == 2 || !this.mGestureDetector.onTouchEvent(motionEvent)) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.aJR = true;
                        this.aJS = true;
                        if (this.agC != 1 && this.agC != 2) {
                            float m = m(motionEvent);
                            if (m >= 0.0f && Math.abs(this.aJQ - m) >= 10.0f) {
                                if (Math.abs(this.aJQ - m) > 100.0f) {
                                    this.aJQ = m;
                                    break;
                                } else {
                                    float f = m / this.aJQ;
                                    this.aJQ = m;
                                    this.aJJ = this.mCurrentScale;
                                    this.mCurrentScale *= f;
                                    if (this.mCurrentScale > this.aJI) {
                                        this.mCurrentScale = this.aJI;
                                    }
                                    if (this.mCurrentScale < this.aJH / 4.0f) {
                                        this.mCurrentScale = this.aJH / 4.0f;
                                    }
                                    GW();
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
            GN();
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public boolean GM() {
        return this.aJH == this.mCurrentScale;
    }

    private void GN() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            if (this.aJM == 0) {
                float width = this.mViewWidth / imageBitmap.getWidth();
                float height = this.mViewHeight / imageBitmap.getHeight();
                if (this.aKb) {
                    if (this.agC == 2) {
                        this.aJH = 2.5f;
                    } else {
                        this.aJH = Math.min(width, height);
                    }
                } else if (this.agC == 2) {
                    this.aJH = 1.0f;
                } else {
                    float f = this.aKc;
                    float f2 = f >= 1.0f ? f : 1.0f;
                    if (imageBitmap.getWidth() * f2 < this.mViewWidth && imageBitmap.getHeight() * f2 < this.mViewHeight) {
                        this.aJH = f2;
                    } else {
                        this.aJH = Math.min(width, height);
                    }
                }
            } else {
                this.aJH = Math.max(this.mViewWidth / imageBitmap.getWidth(), ((this.mViewHeight - this.mTop) - this.mBottom) / imageBitmap.getHeight());
            }
            this.aJI = this.aJL / (imageBitmap.getWidth() * imageBitmap.getHeight());
            this.aJI = FloatMath.sqrt(this.aJI);
            if (this.aJI > 10.0f) {
                this.aJI = 10.0f;
            }
            this.aJG.clear();
            this.aJG.add(Float.valueOf(this.aJH));
            this.mCurrentScale = this.aJH;
            this.aJJ = this.mCurrentScale;
            GW();
            return;
        }
        this.aJE = 0.0f;
        this.aJF = 0.0f;
        this.aJH = 1.0f;
        this.aJI = 1.0f;
        this.mCurrentScale = 1.0f;
        this.aJJ = this.mCurrentScale;
        this.aJG.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    private void GO() {
        if (this.aJN != null) {
            this.aJN.a(this, canZoomIn(), canZoomOut());
        }
    }

    public void setOnSizeChangedListener(e eVar) {
        this.aJN = eVar;
    }

    public byte[] getImageData() {
        return this.mImageData;
    }

    public void setImageData(byte[] bArr) {
        this.mImageData = bArr;
    }

    public Bitmap getGifCache() {
        return this.aJV;
    }

    public void setGifCache(Bitmap bitmap) {
        this.aJV = bitmap;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        boolean z;
        int i4;
        if (this.agC == 2 && this.aJZ != 0 && !this.aJP.Ha()) {
            int width = getWidth();
            int height = getHeight();
            Drawable drawable = getDrawable();
            float f = 0.0f;
            float f2 = height * 0.3f;
            float f3 = width;
            float f4 = (1.0f - 0.3f) * height;
            if (this.aKb && drawable != null) {
                Rect bounds = drawable.getBounds();
                int i5 = bounds.right - bounds.left;
                int i6 = bounds.bottom - bounds.top;
                f = (width / 2) - (i5 * 2.5f);
                f2 = (height / 2) - (i6 * 2.5f);
                f3 = (i5 * 2.5f) + (width / 2);
                f4 = (i6 * 2.5f) + (height / 2);
            }
            this.mPaint.setColor(aq.getColor(this.aJZ));
            canvas.drawRect(f, f2, f3, f4, this.mPaint);
            this.mPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        }
        super.onDraw(canvas);
        if (this.agC == 1 && this.aJV != null && !this.aJV.isRecycled()) {
            int width2 = this.aJV.getWidth();
            int height2 = this.aJV.getHeight();
            int width3 = getWidth();
            int height3 = getHeight();
            int i7 = (width3 - width2) >> 1;
            int i8 = (height3 - height2) >> 1;
            float f5 = this.aKc;
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
            if (this.aJT == 1 && this.aJU != null && this.aKf != null && this.aKf.aKu != null) {
                if (z) {
                    canvas.drawBitmap(this.aKf.aKu, i3, i2, (Paint) null);
                } else {
                    canvas.drawBitmap(this.aKf.aKu, this.mMatrix, this.mPaint);
                }
                invalidate();
            } else if (z) {
                canvas.drawBitmap(this.aJV, i3, i2, (Paint) null);
            } else {
                canvas.drawBitmap(this.aJV, this.mMatrix, this.mPaint);
            }
        }
    }

    public void play() {
        com.baidu.adp.widget.a.a aVar;
        if (this.agC == 1) {
            if (this.aJU == null) {
                if (this.aKj != null) {
                    this.aKj.interrupt();
                    this.aKj = null;
                }
                if (this.mImageData != null) {
                    try {
                        aVar = a.C0003a.dD().e(this.mImageData, 0, this.mImageData.length);
                    } catch (StackOverflowError e2) {
                        aVar = null;
                    }
                    if (aVar != null && aVar.getGif() != null) {
                        this.aJU = aVar.getGif();
                        if (this.aJU != null) {
                            this.aJT = 1;
                            this.width = this.aJU.getWidth();
                            this.height = this.aJU.getHeight();
                            this.aKi = 0;
                            this.aKe = this.aJU.dE();
                        } else {
                            this.aJT = 0;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            if (this.aJU != null && this.mState == 0) {
                this.aKl = true;
                this.aKj = new C0050b(this, null);
                this.aKg.clear();
                this.aKh.clear();
                this.mState = 1;
                this.aKj.start();
            }
        }
    }

    public void pause() {
        if (this.agC == 1) {
            this.mState = 0;
            if (this.aKj != null) {
                this.aKj.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.agC == 1) {
            this.mState = 0;
            if (this.aKj != null) {
                this.aKj.interrupt();
                this.aKj = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.aKl = true;
            this.aKf = null;
            this.aKh.clear();
            this.aKg.clear();
            this.width = 0;
            this.height = 0;
            this.aKi = 0;
            this.aKe = 0;
            if (this.aJU != null) {
                this.aJU = null;
            }
        }
    }

    private void initData() {
        this.aKc = k.ah(getContext());
        this.aJL = k.ag(getContext()) * k.af(getContext()) * 2;
        if (this.aJL < 1690000) {
            this.aJL = 1690000;
        }
        this.aJE = 0.0f;
        this.aJF = 0.0f;
        this.aJG = new ArrayList<>();
        this.aJH = 1.0f;
        this.aJI = 1.0f;
        this.mCurrentScale = 1.0f;
        this.aJJ = this.mCurrentScale;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.aJP = new a();
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWillNotDraw(false);
        scrollTo(0, 0);
        this.mGestureDetector = new GestureDetector(getContext(), new com.baidu.tbadk.widget.d(this));
    }

    private void GP() {
        int i = 0;
        int scrollX = getScrollX();
        if (this.aJE >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.aJE) {
                scrollX = (int) (this.aJE - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.aJF + this.mTop + this.mBottom >= getHeight()) {
            i = scrollY < (-this.aJW) ? -this.aJW : scrollY;
            if (getHeight() + i > this.aJF + this.mBottom + this.aJX) {
                i = (int) ((this.aJF - getHeight()) + this.mBottom + this.aJX);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.aJE;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.aJF;
    }

    public boolean GQ() {
        if (this.agC == 1 || this.agC == 2) {
            return true;
        }
        return !this.aJS && getScrollX() >= ((int) (this.aJE - ((float) getWidth()))) + (-1);
    }

    public boolean GR() {
        if (this.agC == 1 || this.agC == 2) {
            return true;
        }
        return !this.aJS && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.aJP.Ha()) {
            this.aJP.stopAnimation();
        }
        this.aJZ = 0;
        super.setImageBitmap(bitmap);
        GN();
        this.agC = 0;
    }

    public void i(Bitmap bitmap) {
        Bitmap imageBitmap = getImageBitmap();
        if (bitmap != null && !bitmap.isRecycled()) {
            if (imageBitmap != null && (imageBitmap.getWidth() != bitmap.getWidth() || imageBitmap.getHeight() != bitmap.getHeight())) {
                setImageBitmap(bitmap);
                return;
            }
            if (this.aJP.Ha()) {
                this.aJP.stopAnimation();
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            super.setImageBitmap(bitmap);
            super.setImageMatrix(this.mMatrix);
            scrollTo(scrollX, scrollY);
            this.agC = 0;
        }
    }

    public void a(byte[] bArr, Bitmap bitmap) {
        if (this.aJP.Ha()) {
            this.aJP.stopAnimation();
        }
        super.setImageDrawable(null);
        stop();
        GN();
        this.agC = 1;
        this.aJV = bitmap;
        this.mImageData = bArr;
        if (this.att != null) {
            this.att.a(this);
        }
    }

    public void onDestroy() {
        if (this.aJP.Ha()) {
            this.aJP.stopAnimation();
        }
        super.setImageDrawable(null);
        this.mImageData = null;
        this.aJV = null;
        stop();
        if (this.aJU != null) {
            this.aJU.close();
            this.aJU = null;
        }
    }

    public void release() {
        if (this.aJP.Ha()) {
            this.aJP.stopAnimation();
        }
        stop();
        super.setImageDrawable(null);
        this.aJV = null;
    }

    public void GS() {
        if (this.aJP.Ha()) {
            this.aJP.stopAnimation();
        }
        if (this.aKb) {
            super.setImageBitmap(BitmapHelper.getCashBitmap(w.g.icon_default_avatar100));
        } else {
            super.setImageBitmap(BitmapHelper.getCashBitmap(w.g.btn_see_default));
        }
        this.agC = 2;
        GN();
    }

    public void GT() {
        if (this.agC != 1 && this.agC != 2) {
            int size = this.aJG.size();
            if (size > 0) {
                this.aJG.add(Float.valueOf(this.aJG.get(size - 1).floatValue() * 1.25f));
            } else {
                this.aJG.add(Float.valueOf(this.aJH));
            }
            GW();
        }
    }

    public void GU() {
        if (this.agC != 1 && this.agC != 2) {
            int size = this.aJG.size();
            if (size > 1) {
                this.aJG.remove(size - 1);
            }
            GW();
        }
    }

    public void GV() {
        GO();
        if (this.agC != 1 && this.agC != 2 && this.mCurrentScale != this.aJH) {
            this.aJG.clear();
            this.aJG.add(Float.valueOf(this.aJH));
            this.mCurrentScale = this.aJH;
            this.aJJ = this.mCurrentScale;
            GW();
        }
    }

    public boolean canZoomIn() {
        if (this.agC == 1 || this.agC == 2) {
            return false;
        }
        int size = this.aJG.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.aJG.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.aJL) && floatValue <= 5.0f;
    }

    public boolean canZoomOut() {
        if (this.agC == 1 || this.agC == 2) {
            return false;
        }
        int size = this.aJG.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled()) {
            return false;
        }
        return size > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GW() {
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
                    int size = this.aJG.size();
                    if (size > 0) {
                        f2 = this.aJG.get(size - 1).floatValue();
                    } else {
                        f2 = this.aJH;
                    }
                    this.mCurrentScale = f2;
                }
                this.mMatrix.setScale(this.mCurrentScale, this.mCurrentScale);
                this.aJE = imageBitmap.getWidth() * this.mCurrentScale;
                this.aJF = imageBitmap.getHeight() * this.mCurrentScale;
                float width = this.aJJ * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.aJJ;
                this.aJW = this.mTop;
                this.aJX = 0;
                float f3 = this.aJE < ((float) this.mViewWidth) ? (int) ((this.mViewWidth - this.aJE) / 2.0f) : 0.0f;
                if (this.aJF < this.mViewHeight) {
                    f = (int) ((this.mViewHeight - this.aJF) / 2.0f);
                    if (this.aJM == 1 && f > this.mTop) {
                        f = this.mTop;
                    }
                    this.aJW = (int) (this.mTop - f);
                    this.aJX = this.mTop - this.aJW;
                } else {
                    f = 0.0f;
                }
                this.aJY = (int) f3;
                this.mMatrix.postTranslate(f3, f);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    scrollX = i > getWidth() ? getWidth() : i;
                    if (this.aJE <= screenWidth) {
                        scrollX = 0;
                    } else if (this.aJE > screenWidth && this.aJE / 2.0f < screenWidth) {
                        scrollX = (int) (scrollX - (this.aJE / 4.0f));
                    }
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.aJE - width) / 2.0f);
                    }
                    if (this.aJE <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.aJE) {
                        scrollX = (int) (this.aJE - getWidth());
                    }
                }
                if (scrollX > 0 && this.aJE - scrollX < getWidth()) {
                    scrollX = (int) (this.aJE - getWidth());
                }
                if (this.mMode == 2) {
                    scrollY += (int) ((this.aJF - height) / 2.0f);
                }
                if (this.aJF <= getHeight()) {
                    scrollY = 0;
                } else if (getHeight() + scrollY > this.aJF) {
                    scrollY = (int) (this.aJF - getHeight());
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
                GO();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Animation {
        private int Il;
        private boolean aKn = false;
        private boolean aKo = false;
        private long aKp;
        private long aKq;
        private int aKr;
        private long aKs;
        private long aKt;

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
            this.aKp = f;
            this.aKq = f2;
            this.aKs = Math.abs((f * 1000.0f) / 2500.0f);
            this.aKt = Math.abs((f2 * 1000.0f) / 2500.0f);
            setDuration(Math.max(this.aKs, this.aKt));
            setInterpolator(b.this.aKd);
            this.aKr = b.this.getScrollX();
            this.Il = b.this.getScrollY();
            this.aKn = true;
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
            if (this.aKs > this.aKt) {
                j = ((float) this.aKs) * f;
            } else {
                j = ((float) this.aKt) * f;
            }
            float f2 = ((float) (j > this.aKs ? this.aKs : j)) / 1000.0f;
            if (this.aKp > 0) {
                i = this.aKr - ((int) (f2 * (((float) this.aKp) - ((2500.0f * f2) / 2.0f))));
            } else {
                i = this.aKr - ((int) (f2 * (((float) this.aKp) + ((2500.0f * f2) / 2.0f))));
            }
            if (j > this.aKt) {
                j = this.aKt;
            }
            float f3 = ((float) j) / 1000.0f;
            if (this.aKq > 0) {
                i2 = this.Il - ((int) (f3 * (((float) this.aKq) - ((2500.0f * f3) / 2.0f))));
            } else {
                i2 = this.Il - ((int) (f3 * (((float) this.aKq) + ((2500.0f * f3) / 2.0f))));
            }
            if (b.this.aJF + b.this.mTop + b.this.mBottom > b.this.getHeight()) {
                if (i2 < (-b.this.aJW)) {
                    i2 = -b.this.aJW;
                }
                if (b.this.getHeight() + i2 > b.this.aJF + b.this.mBottom + b.this.aJX) {
                    i2 = (int) ((b.this.aJF - b.this.getHeight()) + b.this.mBottom + b.this.aJX);
                }
            } else {
                i2 = 0;
            }
            if (b.this.aJE > b.this.getWidth()) {
                int width = ((float) (b.this.getWidth() + i)) > b.this.aJE ? (int) (b.this.aJE - b.this.getWidth()) : i;
                if (width >= 0) {
                    i3 = width;
                }
            }
            b.this.scrollTo(i3, i2);
            b.this.invalidate();
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            if (!this.aKo) {
                if (b.this.aJK) {
                    this.aKn = false;
                    return false;
                }
                try {
                    if (!super.getTransformation(j, transformation)) {
                        this.aKn = false;
                        return false;
                    }
                    return true;
                } catch (Exception e) {
                    this.aKn = false;
                    return false;
                }
            }
            this.aKo = false;
            this.aKn = false;
            return false;
        }

        public boolean Ha() {
            return this.aKn;
        }

        public void stopAnimation() {
            this.aKo = true;
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.aJO = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.atr = onLongClickListener;
    }

    public void setGifSetListener(d dVar) {
        this.att = dVar;
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
    public void GX() {
        long j;
        c poll = this.aKg.poll();
        if (poll == null) {
            this.aKl = true;
            return;
        }
        this.aKl = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.aKf != null) {
            j = this.aKf.delay - (currentTimeMillis - this.aKk);
            this.aKh.offer(this.aKf);
        } else {
            j = 0;
        }
        this.aKf = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public c GY() {
        c poll = this.aKh.poll();
        if (poll == null) {
            poll = new c(null);
            try {
                poll.aKu = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
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
        public Bitmap aKu;
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
            while (b.this.mState == 1 && b.this.aJU != null && b.this.aKe > 0 && b.this.width > 0 && b.this.height > 0) {
                try {
                    b.this.aJU.T(b.this.aKi);
                    c GY = b.this.GY();
                    if (GY.aKu == null || (GY.aKu.getWidth() != b.this.width && GY.aKu.getHeight() != b.this.height)) {
                        try {
                            GY.aKu = Bitmap.createBitmap(b.this.width, b.this.height, Bitmap.Config.ARGB_8888);
                        } catch (OutOfMemoryError e) {
                            TbadkCoreApplication.m9getInst().onAppMemoryLow();
                            try {
                                GY.aKu = Bitmap.createBitmap(b.this.width, b.this.height, Bitmap.Config.ARGB_4444);
                            } catch (OutOfMemoryError e2) {
                                TbadkCoreApplication.m9getInst().onAppMemoryLow();
                            } catch (Throwable th) {
                                BdLog.e(th.getMessage());
                            }
                        } catch (Throwable th2) {
                            BdLog.e(th2.getMessage());
                        }
                    }
                    b.this.aJU.a(GY.aKu, null);
                    GY.delay = b.this.aJU.U(b.this.aKi);
                    b.this.aKi++;
                    if (GY.aKu == null) {
                        b.this.aKi++;
                    }
                    b.this.aKi %= b.this.aKe;
                    b.this.aKg.put(GY);
                    if (b.this.aKl) {
                        b.this.mHandler.sendEmptyMessage(1);
                    }
                } catch (Exception e3) {
                    return;
                }
            }
        }
    }

    public boolean GZ() {
        return this.aKa;
    }

    public void setLoadBigImage(boolean z) {
        this.aKa = z;
    }

    public int getBottomOffset() {
        return this.aJX;
    }

    public int getLeftOffset() {
        return this.aJY;
    }
}
