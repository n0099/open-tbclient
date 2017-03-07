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
    private boolean aJA;
    private float aJB;
    private Interpolator aJC;
    private int aJD;
    private c aJE;
    private BlockingLinkedDeque<c> aJF;
    private BlockingLinkedDeque<c> aJG;
    private volatile int aJH;
    private b aJI;
    private volatile long aJJ;
    private volatile boolean aJK;
    private float aJd;
    private float aJe;
    private ArrayList<Float> aJf;
    private float aJg;
    private float aJh;
    private float aJi;
    private boolean aJj;
    private int aJk;
    private int aJl;
    private e aJm;
    private View.OnClickListener aJn;
    private C0047a aJo;
    private float aJp;
    private boolean aJq;
    private boolean aJr;
    private int aJs;
    private volatile com.baidu.adp.gif.b aJt;
    private Bitmap aJu;
    private int aJv;
    private int aJw;
    private int aJx;
    private int aJy;
    private boolean aJz;
    private int agV;
    private View.OnLongClickListener asV;
    private d asX;
    private int asY;
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
        this.aJA = z;
    }

    public a(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aJj = false;
        this.mImageData = null;
        this.asY = 0;
        this.aJk = 1300;
        this.aJl = 0;
        this.aJm = null;
        this.aJn = null;
        this.asV = null;
        this.asX = null;
        this.aJp = 1.0f;
        this.agV = 0;
        this.mMode = 0;
        this.aJq = false;
        this.aJr = false;
        this.aJs = 0;
        this.aJt = null;
        this.aJu = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aJv = 0;
        this.aJw = 0;
        this.aJx = 0;
        this.aJy = 0;
        this.aJC = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aJD = 0;
        this.aJE = null;
        this.aJF = new BlockingLinkedDeque<>(5);
        this.aJG = new BlockingLinkedDeque<>(6);
        this.aJH = 0;
        this.aJJ = 0L;
        this.mState = 0;
        this.aJK = true;
        this.mHandler = new Handler(new com.baidu.tbadk.widget.b(this));
        initData();
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aJj = false;
        this.mImageData = null;
        this.asY = 0;
        this.aJk = 1300;
        this.aJl = 0;
        this.aJm = null;
        this.aJn = null;
        this.asV = null;
        this.asX = null;
        this.aJp = 1.0f;
        this.agV = 0;
        this.mMode = 0;
        this.aJq = false;
        this.aJr = false;
        this.aJs = 0;
        this.aJt = null;
        this.aJu = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aJv = 0;
        this.aJw = 0;
        this.aJx = 0;
        this.aJy = 0;
        this.aJC = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aJD = 0;
        this.aJE = null;
        this.aJF = new BlockingLinkedDeque<>(5);
        this.aJG = new BlockingLinkedDeque<>(6);
        this.aJH = 0;
        this.aJJ = 0L;
        this.mState = 0;
        this.aJK = true;
        this.mHandler = new Handler(new com.baidu.tbadk.widget.b(this));
        initData();
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aJj = false;
        this.mImageData = null;
        this.asY = 0;
        this.aJk = 1300;
        this.aJl = 0;
        this.aJm = null;
        this.aJn = null;
        this.asV = null;
        this.asX = null;
        this.aJp = 1.0f;
        this.agV = 0;
        this.mMode = 0;
        this.aJq = false;
        this.aJr = false;
        this.aJs = 0;
        this.aJt = null;
        this.aJu = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aJv = 0;
        this.aJw = 0;
        this.aJx = 0;
        this.aJy = 0;
        this.aJC = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aJD = 0;
        this.aJE = null;
        this.aJF = new BlockingLinkedDeque<>(5);
        this.aJG = new BlockingLinkedDeque<>(6);
        this.aJH = 0;
        this.aJJ = 0L;
        this.mState = 0;
        this.aJK = true;
        this.mHandler = new Handler(new com.baidu.tbadk.widget.b(this));
        initData();
    }

    public int getImageType() {
        return this.agV;
    }

    public void setImageMode(int i) {
        this.aJl = i;
    }

    public void h(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.asY = i;
    }

    public void Hb() {
        this.aJr = false;
        this.aJj = false;
        this.mMode = 0;
        Hf();
        if (this.mCurrentScale < this.aJg) {
            this.mCurrentScale = this.aJg;
            Hm();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.aJj = true;
                this.aJq = false;
                this.aJr = false;
                break;
            case 1:
                Hb();
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
            this.aJp = i(motionEvent);
            if (this.aJp > 10.0f) {
                this.mMode = 2;
            }
        }
        if (this.mMode == 2 || !this.mGestureDetector.onTouchEvent(motionEvent)) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.aJq = true;
                        this.aJr = true;
                        if (this.agV != 1 && this.agV != 2) {
                            float i = i(motionEvent);
                            if (i >= 0.0f && Math.abs(this.aJp - i) >= 10.0f) {
                                if (Math.abs(this.aJp - i) > 100.0f) {
                                    this.aJp = i;
                                    break;
                                } else {
                                    float f = i / this.aJp;
                                    this.aJp = i;
                                    this.aJi = this.mCurrentScale;
                                    this.mCurrentScale *= f;
                                    if (this.mCurrentScale > this.aJh) {
                                        this.mCurrentScale = this.aJh;
                                    }
                                    if (this.mCurrentScale < this.aJg / 4.0f) {
                                        this.mCurrentScale = this.aJg / 4.0f;
                                    }
                                    Hm();
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
            Hd();
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public boolean Hc() {
        return this.aJg == this.mCurrentScale;
    }

    private void Hd() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            if (this.aJl == 0) {
                float width = this.mViewWidth / imageBitmap.getWidth();
                float height = this.mViewHeight / imageBitmap.getHeight();
                if (this.aJA) {
                    if (this.agV == 2) {
                        this.aJg = 2.5f;
                    } else {
                        this.aJg = Math.min(width, height);
                    }
                } else if (this.agV == 2) {
                    this.aJg = 1.0f;
                } else {
                    float f = this.aJB;
                    float f2 = f >= 1.0f ? f : 1.0f;
                    if (imageBitmap.getWidth() * f2 < this.mViewWidth && imageBitmap.getHeight() * f2 < this.mViewHeight) {
                        this.aJg = f2;
                    } else {
                        this.aJg = Math.min(width, height);
                    }
                }
            } else {
                this.aJg = Math.max(this.mViewWidth / imageBitmap.getWidth(), ((this.mViewHeight - this.mTop) - this.mBottom) / imageBitmap.getHeight());
            }
            this.aJh = this.aJk / (imageBitmap.getWidth() * imageBitmap.getHeight());
            this.aJh = FloatMath.sqrt(this.aJh);
            if (this.aJh > 10.0f) {
                this.aJh = 10.0f;
            }
            this.aJf.clear();
            this.aJf.add(Float.valueOf(this.aJg));
            this.mCurrentScale = this.aJg;
            this.aJi = this.mCurrentScale;
            Hm();
            return;
        }
        this.aJd = 0.0f;
        this.aJe = 0.0f;
        this.aJg = 1.0f;
        this.aJh = 1.0f;
        this.mCurrentScale = 1.0f;
        this.aJi = this.mCurrentScale;
        this.aJf.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    private void He() {
        if (this.aJm != null) {
            this.aJm.a(this, canZoomIn(), canZoomOut());
        }
    }

    public void setOnSizeChangedListener(e eVar) {
        this.aJm = eVar;
    }

    public byte[] getImageData() {
        return this.mImageData;
    }

    public void setImageData(byte[] bArr) {
        this.mImageData = bArr;
    }

    public Bitmap getGifCache() {
        return this.aJu;
    }

    public void setGifCache(Bitmap bitmap) {
        this.aJu = bitmap;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        boolean z;
        int i4;
        if (this.agV == 2 && this.aJy != 0 && !this.aJo.Hq()) {
            int width = getWidth();
            int height = getHeight();
            Drawable drawable = getDrawable();
            float f = 0.0f;
            float f2 = height * 0.3f;
            float f3 = width;
            float f4 = (1.0f - 0.3f) * height;
            if (this.aJA && drawable != null) {
                Rect bounds = drawable.getBounds();
                int i5 = bounds.right - bounds.left;
                int i6 = bounds.bottom - bounds.top;
                f = (width / 2) - (i5 * 2.5f);
                f2 = (height / 2) - (i6 * 2.5f);
                f3 = (i5 * 2.5f) + (width / 2);
                f4 = (i6 * 2.5f) + (height / 2);
            }
            this.mPaint.setColor(aq.getColor(this.aJy));
            canvas.drawRect(f, f2, f3, f4, this.mPaint);
            this.mPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        }
        super.onDraw(canvas);
        if (this.agV == 1 && this.aJu != null && !this.aJu.isRecycled()) {
            int width2 = this.aJu.getWidth();
            int height2 = this.aJu.getHeight();
            int width3 = getWidth();
            int height3 = getHeight();
            int i7 = (width3 - width2) >> 1;
            int i8 = (height3 - height2) >> 1;
            float f5 = this.aJB;
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
            if (this.aJs == 1 && this.aJt != null && this.aJE != null && this.aJE.aJT != null) {
                if (z) {
                    canvas.drawBitmap(this.aJE.aJT, i3, i2, (Paint) null);
                } else {
                    canvas.drawBitmap(this.aJE.aJT, this.mMatrix, this.mPaint);
                }
                invalidate();
            } else if (z) {
                canvas.drawBitmap(this.aJu, i3, i2, (Paint) null);
            } else {
                canvas.drawBitmap(this.aJu, this.mMatrix, this.mPaint);
            }
        }
    }

    public void play() {
        com.baidu.adp.widget.a.a aVar;
        if (this.agV == 1) {
            if (this.aJt == null) {
                if (this.aJI != null) {
                    this.aJI.interrupt();
                    this.aJI = null;
                }
                if (this.mImageData != null) {
                    try {
                        aVar = a.C0003a.dD().e(this.mImageData, 0, this.mImageData.length);
                    } catch (StackOverflowError e2) {
                        aVar = null;
                    }
                    if (aVar != null && aVar.getGif() != null) {
                        this.aJt = aVar.getGif();
                        if (this.aJt != null) {
                            this.aJs = 1;
                            this.width = this.aJt.getWidth();
                            this.height = this.aJt.getHeight();
                            this.aJH = 0;
                            this.aJD = this.aJt.dE();
                        } else {
                            this.aJs = 0;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            if (this.aJt != null && this.mState == 0) {
                this.aJK = true;
                this.aJI = new b(this, null);
                this.aJF.clear();
                this.aJG.clear();
                this.mState = 1;
                this.aJI.start();
            }
        }
    }

    public void pause() {
        if (this.agV == 1) {
            this.mState = 0;
            if (this.aJI != null) {
                this.aJI.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.agV == 1) {
            this.mState = 0;
            if (this.aJI != null) {
                this.aJI.interrupt();
                this.aJI = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.aJK = true;
            this.aJE = null;
            this.aJG.clear();
            this.aJF.clear();
            this.width = 0;
            this.height = 0;
            this.aJH = 0;
            this.aJD = 0;
            if (this.aJt != null) {
                this.aJt = null;
            }
        }
    }

    private void initData() {
        this.aJB = k.ai(getContext());
        this.aJk = k.ah(getContext()) * k.ag(getContext()) * 2;
        if (this.aJk < 1690000) {
            this.aJk = 1690000;
        }
        this.aJd = 0.0f;
        this.aJe = 0.0f;
        this.aJf = new ArrayList<>();
        this.aJg = 1.0f;
        this.aJh = 1.0f;
        this.mCurrentScale = 1.0f;
        this.aJi = this.mCurrentScale;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.aJo = new C0047a();
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWillNotDraw(false);
        scrollTo(0, 0);
        this.mGestureDetector = new GestureDetector(getContext(), new com.baidu.tbadk.widget.c(this));
    }

    private void Hf() {
        int i = 0;
        int scrollX = getScrollX();
        if (this.aJd >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.aJd) {
                scrollX = (int) (this.aJd - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.aJe + this.mTop + this.mBottom >= getHeight()) {
            i = scrollY < (-this.aJv) ? -this.aJv : scrollY;
            if (getHeight() + i > this.aJe + this.mBottom + this.aJw) {
                i = (int) ((this.aJe - getHeight()) + this.mBottom + this.aJw);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.aJd;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.aJe;
    }

    public boolean Hg() {
        if (this.agV == 1 || this.agV == 2) {
            return true;
        }
        return !this.aJr && getScrollX() >= ((int) (this.aJd - ((float) getWidth()))) + (-1);
    }

    public boolean Hh() {
        if (this.agV == 1 || this.agV == 2) {
            return true;
        }
        return !this.aJr && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.aJo.Hq()) {
            this.aJo.stopAnimation();
        }
        this.aJy = 0;
        super.setImageBitmap(bitmap);
        Hd();
        this.agV = 0;
    }

    public void j(Bitmap bitmap) {
        Bitmap imageBitmap = getImageBitmap();
        if (bitmap != null && !bitmap.isRecycled()) {
            if (imageBitmap != null && (imageBitmap.getWidth() != bitmap.getWidth() || imageBitmap.getHeight() != bitmap.getHeight())) {
                setImageBitmap(bitmap);
                return;
            }
            if (this.aJo.Hq()) {
                this.aJo.stopAnimation();
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            super.setImageBitmap(bitmap);
            super.setImageMatrix(this.mMatrix);
            scrollTo(scrollX, scrollY);
            this.agV = 0;
        }
    }

    public void a(byte[] bArr, Bitmap bitmap) {
        if (this.aJo.Hq()) {
            this.aJo.stopAnimation();
        }
        super.setImageDrawable(null);
        stop();
        Hd();
        this.agV = 1;
        this.aJu = bitmap;
        this.mImageData = bArr;
        if (this.asX != null) {
            this.asX.a(this);
        }
    }

    public void onDestroy() {
        if (this.aJo.Hq()) {
            this.aJo.stopAnimation();
        }
        super.setImageDrawable(null);
        this.mImageData = null;
        this.aJu = null;
        stop();
        if (this.aJt != null) {
            this.aJt.close();
            this.aJt = null;
        }
    }

    public void release() {
        if (this.aJo.Hq()) {
            this.aJo.stopAnimation();
        }
        stop();
        super.setImageDrawable(null);
        this.aJu = null;
    }

    public void Hi() {
        if (this.aJo.Hq()) {
            this.aJo.stopAnimation();
        }
        if (this.aJA) {
            super.setImageBitmap(BitmapHelper.getCashBitmap(w.g.icon_default_avatar100));
        } else {
            super.setImageBitmap(BitmapHelper.getCashBitmap(w.g.btn_see_default));
        }
        this.agV = 2;
        Hd();
    }

    public void Hj() {
        if (this.agV != 1 && this.agV != 2) {
            int size = this.aJf.size();
            if (size > 0) {
                this.aJf.add(Float.valueOf(this.aJf.get(size - 1).floatValue() * 1.25f));
            } else {
                this.aJf.add(Float.valueOf(this.aJg));
            }
            Hm();
        }
    }

    public void Hk() {
        if (this.agV != 1 && this.agV != 2) {
            int size = this.aJf.size();
            if (size > 1) {
                this.aJf.remove(size - 1);
            }
            Hm();
        }
    }

    public void Hl() {
        He();
        if (this.agV != 1 && this.agV != 2 && this.mCurrentScale != this.aJg) {
            this.aJf.clear();
            this.aJf.add(Float.valueOf(this.aJg));
            this.mCurrentScale = this.aJg;
            this.aJi = this.mCurrentScale;
            Hm();
        }
    }

    public boolean canZoomIn() {
        if (this.agV == 1 || this.agV == 2) {
            return false;
        }
        int size = this.aJf.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.aJf.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.aJk) && floatValue <= 5.0f;
    }

    public boolean canZoomOut() {
        if (this.agV == 1 || this.agV == 2) {
            return false;
        }
        int size = this.aJf.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled()) {
            return false;
        }
        return size > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hm() {
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
                    int size = this.aJf.size();
                    if (size > 0) {
                        f2 = this.aJf.get(size - 1).floatValue();
                    } else {
                        f2 = this.aJg;
                    }
                    this.mCurrentScale = f2;
                }
                this.mMatrix.setScale(this.mCurrentScale, this.mCurrentScale);
                this.aJd = imageBitmap.getWidth() * this.mCurrentScale;
                this.aJe = imageBitmap.getHeight() * this.mCurrentScale;
                float width = this.aJi * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.aJi;
                this.aJv = this.mTop;
                this.aJw = 0;
                float f3 = this.aJd < ((float) this.mViewWidth) ? (int) ((this.mViewWidth - this.aJd) / 2.0f) : 0.0f;
                if (this.aJe < this.mViewHeight) {
                    f = (int) ((this.mViewHeight - this.aJe) / 2.0f);
                    if (this.aJl == 1 && f > this.mTop) {
                        f = this.mTop;
                    }
                    this.aJv = (int) (this.mTop - f);
                    this.aJw = this.mTop - this.aJv;
                } else {
                    f = 0.0f;
                }
                this.aJx = (int) f3;
                this.mMatrix.postTranslate(f3, f);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    scrollX = i > getWidth() ? getWidth() : i;
                    if (this.aJd <= screenWidth) {
                        scrollX = 0;
                    } else if (this.aJd > screenWidth && this.aJd / 2.0f < screenWidth) {
                        scrollX = (int) (scrollX - (this.aJd / 4.0f));
                    }
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.aJd - width) / 2.0f);
                    }
                    if (this.aJd <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.aJd) {
                        scrollX = (int) (this.aJd - getWidth());
                    }
                }
                if (scrollX > 0 && this.aJd - scrollX < getWidth()) {
                    scrollX = (int) (this.aJd - getWidth());
                }
                if (this.mMode == 2) {
                    scrollY += (int) ((this.aJe - height) / 2.0f);
                }
                if (this.aJe <= getHeight()) {
                    scrollY = 0;
                } else if (getHeight() + scrollY > this.aJe) {
                    scrollY = (int) (this.aJe - getHeight());
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
                He();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0047a extends Animation {
        private int IJ;
        private boolean aJM = false;
        private boolean aJN = false;
        private long aJO;
        private long aJP;
        private int aJQ;
        private long aJR;
        private long aJS;

        public C0047a() {
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
            this.aJO = f;
            this.aJP = f2;
            this.aJR = Math.abs((f * 1000.0f) / 2500.0f);
            this.aJS = Math.abs((f2 * 1000.0f) / 2500.0f);
            setDuration(Math.max(this.aJR, this.aJS));
            setInterpolator(a.this.aJC);
            this.aJQ = a.this.getScrollX();
            this.IJ = a.this.getScrollY();
            this.aJM = true;
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
            if (this.aJR > this.aJS) {
                j = ((float) this.aJR) * f;
            } else {
                j = ((float) this.aJS) * f;
            }
            float f2 = ((float) (j > this.aJR ? this.aJR : j)) / 1000.0f;
            if (this.aJO > 0) {
                i = this.aJQ - ((int) (f2 * (((float) this.aJO) - ((2500.0f * f2) / 2.0f))));
            } else {
                i = this.aJQ - ((int) (f2 * (((float) this.aJO) + ((2500.0f * f2) / 2.0f))));
            }
            if (j > this.aJS) {
                j = this.aJS;
            }
            float f3 = ((float) j) / 1000.0f;
            if (this.aJP > 0) {
                i2 = this.IJ - ((int) (f3 * (((float) this.aJP) - ((2500.0f * f3) / 2.0f))));
            } else {
                i2 = this.IJ - ((int) (f3 * (((float) this.aJP) + ((2500.0f * f3) / 2.0f))));
            }
            if (a.this.aJe + a.this.mTop + a.this.mBottom > a.this.getHeight()) {
                if (i2 < (-a.this.aJv)) {
                    i2 = -a.this.aJv;
                }
                if (a.this.getHeight() + i2 > a.this.aJe + a.this.mBottom + a.this.aJw) {
                    i2 = (int) ((a.this.aJe - a.this.getHeight()) + a.this.mBottom + a.this.aJw);
                }
            } else {
                i2 = 0;
            }
            if (a.this.aJd > a.this.getWidth()) {
                int width = ((float) (a.this.getWidth() + i)) > a.this.aJd ? (int) (a.this.aJd - a.this.getWidth()) : i;
                if (width >= 0) {
                    i3 = width;
                }
            }
            a.this.scrollTo(i3, i2);
            a.this.invalidate();
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            if (!this.aJN) {
                if (a.this.aJj) {
                    this.aJM = false;
                    return false;
                }
                try {
                    if (!super.getTransformation(j, transformation)) {
                        this.aJM = false;
                        return false;
                    }
                    return true;
                } catch (Exception e) {
                    this.aJM = false;
                    return false;
                }
            }
            this.aJN = false;
            this.aJM = false;
            return false;
        }

        public boolean Hq() {
            return this.aJM;
        }

        public void stopAnimation() {
            this.aJN = true;
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.aJn = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.asV = onLongClickListener;
    }

    public void setGifSetListener(d dVar) {
        this.asX = dVar;
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
    public void Hn() {
        long j;
        c poll = this.aJF.poll();
        if (poll == null) {
            this.aJK = true;
            return;
        }
        this.aJK = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.aJE != null) {
            j = this.aJE.delay - (currentTimeMillis - this.aJJ);
            this.aJG.offer(this.aJE);
        } else {
            j = 0;
        }
        this.aJE = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public c Ho() {
        c poll = this.aJG.poll();
        if (poll == null) {
            poll = new c(null);
            try {
                poll.aJT = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
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
        public Bitmap aJT;
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
            while (a.this.mState == 1 && a.this.aJt != null && a.this.aJD > 0 && a.this.width > 0 && a.this.height > 0) {
                try {
                    a.this.aJt.V(a.this.aJH);
                    c Ho = a.this.Ho();
                    if (Ho.aJT == null || (Ho.aJT.getWidth() != a.this.width && Ho.aJT.getHeight() != a.this.height)) {
                        try {
                            Ho.aJT = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_8888);
                        } catch (OutOfMemoryError e) {
                            TbadkCoreApplication.m9getInst().onAppMemoryLow();
                            try {
                                Ho.aJT = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_4444);
                            } catch (OutOfMemoryError e2) {
                                TbadkCoreApplication.m9getInst().onAppMemoryLow();
                            } catch (Throwable th) {
                                BdLog.e(th.getMessage());
                            }
                        } catch (Throwable th2) {
                            BdLog.e(th2.getMessage());
                        }
                    }
                    a.this.aJt.a(Ho.aJT, null);
                    Ho.delay = a.this.aJt.W(a.this.aJH);
                    a.this.aJH++;
                    if (Ho.aJT == null) {
                        a.this.aJH++;
                    }
                    a.this.aJH %= a.this.aJD;
                    a.this.aJF.put(Ho);
                    if (a.this.aJK) {
                        a.this.mHandler.sendEmptyMessage(1);
                    }
                } catch (Exception e3) {
                    return;
                }
            }
        }
    }

    public boolean Hp() {
        return this.aJz;
    }

    public void setLoadBigImage(boolean z) {
        this.aJz = z;
    }

    public int getBottomOffset() {
        return this.aJw;
    }

    public int getLeftOffset() {
        return this.aJx;
    }
}
