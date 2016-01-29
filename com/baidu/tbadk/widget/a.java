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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends ImageView {
    private boolean aDA;
    private int aDB;
    private volatile com.baidu.adp.gif.b aDC;
    private Bitmap aDD;
    private int aDE;
    private int aDF;
    private int aDG;
    private boolean aDH;
    private boolean aDI;
    private float aDJ;
    private Interpolator aDK;
    private int aDL;
    private c aDM;
    private BlockingLinkedDeque<c> aDN;
    private BlockingLinkedDeque<c> aDO;
    private volatile int aDP;
    private b aDQ;
    private volatile long aDR;
    private volatile boolean aDS;
    private float aDl;
    private float aDm;
    private ArrayList<Float> aDn;
    private float aDo;
    private float aDp;
    private float aDq;
    private float aDr;
    private boolean aDs;
    private int aDt;
    private int aDu;
    private e aDv;
    private View.OnClickListener aDw;
    private C0057a aDx;
    private float aDy;
    private boolean aDz;
    private int adO;
    private View.OnLongClickListener anJ;
    private d anL;
    private int anM;
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
        this.aDI = z;
    }

    public a(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aDs = false;
        this.mImageData = null;
        this.anM = 0;
        this.aDt = 1300;
        this.aDu = 0;
        this.aDv = null;
        this.aDw = null;
        this.anJ = null;
        this.anL = null;
        this.aDy = 1.0f;
        this.adO = 0;
        this.mMode = 0;
        this.aDz = false;
        this.aDA = false;
        this.aDB = 0;
        this.aDC = null;
        this.aDD = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aDE = 0;
        this.aDF = 0;
        this.aDG = 0;
        this.aDK = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aDL = 0;
        this.aDM = null;
        this.aDN = new BlockingLinkedDeque<>(5);
        this.aDO = new BlockingLinkedDeque<>(6);
        this.aDP = 0;
        this.aDR = 0L;
        this.mState = 0;
        this.aDS = true;
        this.mHandler = new Handler(new com.baidu.tbadk.widget.b(this));
        initData();
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aDs = false;
        this.mImageData = null;
        this.anM = 0;
        this.aDt = 1300;
        this.aDu = 0;
        this.aDv = null;
        this.aDw = null;
        this.anJ = null;
        this.anL = null;
        this.aDy = 1.0f;
        this.adO = 0;
        this.mMode = 0;
        this.aDz = false;
        this.aDA = false;
        this.aDB = 0;
        this.aDC = null;
        this.aDD = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aDE = 0;
        this.aDF = 0;
        this.aDG = 0;
        this.aDK = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aDL = 0;
        this.aDM = null;
        this.aDN = new BlockingLinkedDeque<>(5);
        this.aDO = new BlockingLinkedDeque<>(6);
        this.aDP = 0;
        this.aDR = 0L;
        this.mState = 0;
        this.aDS = true;
        this.mHandler = new Handler(new com.baidu.tbadk.widget.b(this));
        initData();
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aDs = false;
        this.mImageData = null;
        this.anM = 0;
        this.aDt = 1300;
        this.aDu = 0;
        this.aDv = null;
        this.aDw = null;
        this.anJ = null;
        this.anL = null;
        this.aDy = 1.0f;
        this.adO = 0;
        this.mMode = 0;
        this.aDz = false;
        this.aDA = false;
        this.aDB = 0;
        this.aDC = null;
        this.aDD = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aDE = 0;
        this.aDF = 0;
        this.aDG = 0;
        this.aDK = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aDL = 0;
        this.aDM = null;
        this.aDN = new BlockingLinkedDeque<>(5);
        this.aDO = new BlockingLinkedDeque<>(6);
        this.aDP = 0;
        this.aDR = 0L;
        this.mState = 0;
        this.aDS = true;
        this.mHandler = new Handler(new com.baidu.tbadk.widget.b(this));
        initData();
    }

    public int getImageType() {
        return this.adO;
    }

    public void setImageMode(int i) {
        this.aDu = i;
    }

    public void setOffset(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.anM = i;
    }

    public void actionUp() {
        this.aDA = false;
        this.aDs = false;
        this.mMode = 0;
        GJ();
        if (this.aDq < this.aDo) {
            this.aDq = this.aDo;
            GK();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.aDs = true;
                this.aDz = false;
                this.aDA = false;
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
            this.aDy = spacing(motionEvent);
            if (this.aDy > 10.0f) {
                this.mMode = 2;
            }
        }
        if (this.mMode == 2 || !this.mGestureDetector.onTouchEvent(motionEvent)) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.aDz = true;
                        this.aDA = true;
                        if (this.adO != 1 && this.adO != 2) {
                            float spacing = spacing(motionEvent);
                            if (spacing >= 0.0f && Math.abs(this.aDy - spacing) >= 10.0f) {
                                if (Math.abs(this.aDy - spacing) > 100.0f) {
                                    this.aDy = spacing;
                                    break;
                                } else {
                                    float f = spacing / this.aDy;
                                    this.aDy = spacing;
                                    this.aDr = this.aDq;
                                    this.aDq *= f;
                                    if (this.aDq > this.aDp) {
                                        this.aDq = this.aDp;
                                    }
                                    if (this.aDq < this.aDo / 4.0f) {
                                        this.aDq = this.aDo / 4.0f;
                                    }
                                    GK();
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
        return this.aDo == this.aDq;
    }

    private void reInitBitmap() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            if (this.aDu == 0) {
                float width = this.mViewWidth / imageBitmap.getWidth();
                float height = this.mViewHeight / imageBitmap.getHeight();
                if (this.aDI) {
                    if (this.adO == 2) {
                        this.aDo = 2.5f;
                    } else {
                        this.aDo = Math.min(width, height);
                    }
                } else if (this.adO == 2) {
                    this.aDo = 1.0f;
                } else {
                    float f = this.aDJ;
                    float f2 = f >= 1.0f ? f : 1.0f;
                    if (imageBitmap.getWidth() * f2 < this.mViewWidth && imageBitmap.getHeight() * f2 < this.mViewHeight) {
                        this.aDo = f2;
                    } else {
                        this.aDo = Math.min(width, height);
                    }
                }
            } else {
                this.aDo = Math.max(this.mViewWidth / imageBitmap.getWidth(), ((this.mViewHeight - this.mTop) - this.mBottom) / imageBitmap.getHeight());
            }
            this.aDp = this.aDt / (imageBitmap.getWidth() * imageBitmap.getHeight());
            this.aDp = FloatMath.sqrt(this.aDp);
            if (this.aDp > 10.0f) {
                this.aDp = 10.0f;
            }
            this.aDn.clear();
            this.aDn.add(Float.valueOf(this.aDo));
            this.aDq = this.aDo;
            this.aDr = this.aDq;
            GK();
            GI();
            return;
        }
        this.aDl = 0.0f;
        this.aDm = 0.0f;
        this.aDo = 1.0f;
        this.aDp = 1.0f;
        this.aDq = 1.0f;
        this.aDr = this.aDq;
        this.aDn.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GI() {
        if (this.aDv != null) {
            this.aDv.a(this, canZoomIn(), canZoomOut());
        }
    }

    public void setOnSizeChangedListener(e eVar) {
        this.aDv = eVar;
    }

    public byte[] getImageData() {
        return this.mImageData;
    }

    public void setImageData(byte[] bArr) {
        this.mImageData = bArr;
    }

    public Bitmap getGifCache() {
        return this.aDD;
    }

    public void setGifCache(Bitmap bitmap) {
        this.aDD = bitmap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        boolean z;
        int i4;
        if (this.adO == 2 && this.aDG != 0 && !this.aDx.GO()) {
            int width = getWidth();
            int height = getHeight();
            Drawable drawable = getDrawable();
            float f = 0.0f;
            float f2 = height * 0.3f;
            float f3 = width;
            float f4 = (1.0f - 0.3f) * height;
            if (this.aDI && drawable != null) {
                Rect bounds = drawable.getBounds();
                int i5 = bounds.right - bounds.left;
                int i6 = bounds.bottom - bounds.top;
                f = (width / 2) - (i5 * 2.5f);
                f2 = (height / 2) - (i6 * 2.5f);
                f3 = (i5 * 2.5f) + (width / 2);
                f4 = (i6 * 2.5f) + (height / 2);
            }
            this.mPaint.setColor(ar.getColor(this.aDG));
            canvas.drawRect(f, f2, f3, f4, this.mPaint);
            this.mPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        }
        super.onDraw(canvas);
        if (this.adO == 1 && this.aDD != null && !this.aDD.isRecycled()) {
            int width2 = this.aDD.getWidth();
            int height2 = this.aDD.getHeight();
            int width3 = getWidth();
            int height3 = getHeight();
            int i7 = (width3 - width2) >> 1;
            int i8 = (height3 - height2) >> 1;
            float f5 = this.aDJ;
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
            if (this.aDB == 1 && this.aDC != null && this.aDM != null && this.aDM.aEb != null) {
                if (z) {
                    canvas.drawBitmap(this.aDM.aEb, i3, i2, (Paint) null);
                } else {
                    canvas.drawBitmap(this.aDM.aEb, this.mMatrix, this.mPaint);
                }
                invalidate();
            } else if (z) {
                canvas.drawBitmap(this.aDD, i3, i2, (Paint) null);
            } else {
                canvas.drawBitmap(this.aDD, this.mMatrix, this.mPaint);
            }
        }
    }

    public void play() {
        com.baidu.adp.widget.a.a d2;
        if (this.adO == 1) {
            if (this.aDC == null) {
                if (this.aDQ != null) {
                    this.aDQ.interrupt();
                    this.aDQ = null;
                }
                if (this.mImageData != null && (d2 = a.C0003a.fm().d(this.mImageData, 0, this.mImageData.length)) != null && d2.getGif() != null) {
                    this.aDC = d2.getGif();
                    if (this.aDC != null) {
                        this.aDB = 1;
                        this.width = this.aDC.getWidth();
                        this.height = this.aDC.getHeight();
                        this.aDP = 0;
                        this.aDL = this.aDC.fn();
                    } else {
                        this.aDB = 0;
                    }
                } else {
                    return;
                }
            }
            if (this.aDC != null && this.mState == 0) {
                this.aDS = true;
                this.aDQ = new b(this, null);
                this.aDN.clear();
                this.aDO.clear();
                this.mState = 1;
                this.aDQ.start();
            }
        }
    }

    public void pause() {
        if (this.adO == 1) {
            this.mState = 0;
            if (this.aDQ != null) {
                this.aDQ.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.adO == 1) {
            this.mState = 0;
            if (this.aDQ != null) {
                this.aDQ.interrupt();
                this.aDQ = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.aDS = true;
            this.aDM = null;
            this.aDO.clear();
            this.aDN.clear();
            this.width = 0;
            this.height = 0;
            this.aDP = 0;
            this.aDL = 0;
            if (this.aDC != null) {
                this.aDC = null;
            }
        }
    }

    private void initData() {
        this.aDJ = k.M(getContext());
        this.aDt = k.L(getContext()) * k.K(getContext()) * 2;
        if (this.aDt < 1690000) {
            this.aDt = 1690000;
        }
        this.aDl = 0.0f;
        this.aDm = 0.0f;
        this.aDn = new ArrayList<>();
        this.aDo = 1.0f;
        this.aDp = 1.0f;
        this.aDq = 1.0f;
        this.aDr = this.aDq;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.aDx = new C0057a();
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWillNotDraw(false);
        scrollTo(0, 0);
        this.mGestureDetector = new GestureDetector(getContext(), new com.baidu.tbadk.widget.c(this));
    }

    private void GJ() {
        int i = 0;
        int scrollX = getScrollX();
        if (this.aDl >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.aDl) {
                scrollX = (int) (this.aDl - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.aDm + this.mTop + this.mBottom >= getHeight()) {
            i = scrollY < (-this.aDE) ? -this.aDE : scrollY;
            if (getHeight() + i > this.aDm + this.mBottom + this.aDF) {
                i = (int) ((this.aDm - getHeight()) + this.mBottom + this.aDF);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.aDl;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.aDm;
    }

    public boolean onRightSide() {
        if (this.adO == 1 || this.adO == 2) {
            return true;
        }
        return !this.aDA && getScrollX() >= ((int) (this.aDl - ((float) getWidth()))) + (-1);
    }

    public boolean onLeftSide() {
        if (this.adO == 1 || this.adO == 2) {
            return true;
        }
        return !this.aDA && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.aDx.GO()) {
            this.aDx.stopAnimation();
        }
        this.aDG = 0;
        super.setImageBitmap(bitmap);
        reInitBitmap();
        this.adO = 0;
    }

    public void replaceImageBitmap(Bitmap bitmap) {
        Bitmap imageBitmap = getImageBitmap();
        if (bitmap != null && !bitmap.isRecycled()) {
            if (imageBitmap != null && (imageBitmap.getWidth() != bitmap.getWidth() || imageBitmap.getHeight() != bitmap.getHeight())) {
                setImageBitmap(bitmap);
                return;
            }
            if (this.aDx.GO()) {
                this.aDx.stopAnimation();
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            super.setImageBitmap(bitmap);
            super.setImageMatrix(this.mMatrix);
            scrollTo(scrollX, scrollY);
            this.adO = 0;
        }
    }

    public void a(byte[] bArr, Bitmap bitmap) {
        if (this.aDx.GO()) {
            this.aDx.stopAnimation();
        }
        super.setImageDrawable(null);
        stop();
        reInitBitmap();
        this.adO = 1;
        this.aDD = bitmap;
        this.mImageData = bArr;
        if (this.anL != null) {
            this.anL.a(this);
        }
    }

    public void onDestroy() {
        if (this.aDx.GO()) {
            this.aDx.stopAnimation();
        }
        super.setImageDrawable(null);
        this.mImageData = null;
        this.aDD = null;
        stop();
        if (this.aDC != null) {
            this.aDC.close();
            this.aDC = null;
        }
    }

    public void release() {
        if (this.aDx.GO()) {
            this.aDx.stopAnimation();
        }
        stop();
        super.setImageDrawable(null);
        this.aDD = null;
    }

    public void setDefaultBitmap() {
        if (this.aDx.GO()) {
            this.aDx.stopAnimation();
        }
        if (this.aDI) {
            super.setImageBitmap(BitmapHelper.getCashBitmap(t.f.icon_default_avatar100));
        } else {
            super.setImageBitmap(BitmapHelper.getCashBitmap(t.f.btn_see_default));
        }
        this.adO = 2;
        reInitBitmap();
    }

    public void zoomInBitmap() {
        if (this.adO != 1 && this.adO != 2) {
            int size = this.aDn.size();
            if (size > 0) {
                this.aDn.add(Float.valueOf(this.aDn.get(size - 1).floatValue() * 1.25f));
            } else {
                this.aDn.add(Float.valueOf(this.aDo));
            }
            GK();
            GI();
        }
    }

    public void zoomOutBitmap() {
        if (this.adO != 1 && this.adO != 2) {
            int size = this.aDn.size();
            if (size > 1) {
                this.aDn.remove(size - 1);
            }
            GK();
            GI();
        }
    }

    public void restoreSize() {
        GI();
        if (this.adO != 1 && this.adO != 2 && this.aDq != this.aDo) {
            this.aDn.clear();
            this.aDn.add(Float.valueOf(this.aDo));
            this.aDq = this.aDo;
            this.aDr = this.aDq;
            GK();
        }
    }

    public boolean canZoomIn() {
        if (this.adO == 1 || this.adO == 2) {
            return false;
        }
        int size = this.aDn.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.aDn.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.aDt) && floatValue <= 5.0f;
    }

    public boolean canZoomOut() {
        if (this.adO == 1 || this.adO == 2) {
            return false;
        }
        int size = this.aDn.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled()) {
            return false;
        }
        return size > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GK() {
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
                    int size = this.aDn.size();
                    if (size > 0) {
                        f2 = this.aDn.get(size - 1).floatValue();
                    } else {
                        f2 = this.aDo;
                    }
                    this.aDq = f2;
                }
                this.mMatrix.setScale(this.aDq, this.aDq);
                this.aDl = imageBitmap.getWidth() * this.aDq;
                this.aDm = imageBitmap.getHeight() * this.aDq;
                float width = this.aDr * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.aDr;
                this.aDE = this.mTop;
                this.aDF = 0;
                float f3 = this.aDl < ((float) this.mViewWidth) ? (int) ((this.mViewWidth - this.aDl) / 2.0f) : 0.0f;
                if (this.aDm < this.mViewHeight) {
                    f = (int) ((this.mViewHeight - this.aDm) / 2.0f);
                    if (this.aDu == 1 && f > this.mTop) {
                        f = this.mTop;
                    }
                    this.aDE = (int) (this.mTop - f);
                    this.aDF = this.mTop - this.aDE;
                } else {
                    f = 0.0f;
                }
                this.mMatrix.postTranslate(f3, f);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    scrollX = i > getWidth() ? getWidth() : i;
                    if (this.aDl <= screenWidth) {
                        scrollX = 0;
                    } else if (this.aDl > screenWidth && this.aDl / 2.0f < screenWidth) {
                        scrollX = (int) (scrollX - (this.aDl / 4.0f));
                    }
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.aDl - width) / 2.0f);
                    }
                    if (this.aDl <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.aDl) {
                        scrollX = (int) (this.aDl - getWidth());
                    }
                }
                if (scrollX > 0 && this.aDl - scrollX < getWidth()) {
                    scrollX = (int) (this.aDl - getWidth());
                }
                if (this.mMode == 2) {
                    scrollY += (int) ((this.aDm - height) / 2.0f);
                }
                if (this.aDm <= getHeight()) {
                    scrollY = 0;
                } else if (getHeight() + scrollY > this.aDm) {
                    scrollY = (int) (this.aDm - getHeight());
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
    public class C0057a extends Animation {
        private int IX;
        private boolean aDU = false;
        private boolean aDV = false;
        private long aDW;
        private long aDX;
        private int aDY;
        private long aDZ;
        private long aEa;

        public C0057a() {
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
            this.aDW = f;
            this.aDX = f2;
            this.aDZ = Math.abs((f * 1000.0f) / 2500.0f);
            this.aEa = Math.abs((f2 * 1000.0f) / 2500.0f);
            setDuration(Math.max(this.aDZ, this.aEa));
            setInterpolator(a.this.aDK);
            this.aDY = a.this.getScrollX();
            this.IX = a.this.getScrollY();
            this.aDU = true;
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
            if (this.aDZ > this.aEa) {
                j = ((float) this.aDZ) * f;
            } else {
                j = ((float) this.aEa) * f;
            }
            float f2 = ((float) (j > this.aDZ ? this.aDZ : j)) / 1000.0f;
            if (this.aDW > 0) {
                i = this.aDY - ((int) (f2 * (((float) this.aDW) - ((2500.0f * f2) / 2.0f))));
            } else {
                i = this.aDY - ((int) (f2 * (((float) this.aDW) + ((2500.0f * f2) / 2.0f))));
            }
            if (j > this.aEa) {
                j = this.aEa;
            }
            float f3 = ((float) j) / 1000.0f;
            if (this.aDX > 0) {
                i2 = this.IX - ((int) (f3 * (((float) this.aDX) - ((2500.0f * f3) / 2.0f))));
            } else {
                i2 = this.IX - ((int) (f3 * (((float) this.aDX) + ((2500.0f * f3) / 2.0f))));
            }
            if (a.this.aDm + a.this.mTop + a.this.mBottom > a.this.getHeight()) {
                if (i2 < (-a.this.aDE)) {
                    i2 = -a.this.aDE;
                }
                if (a.this.getHeight() + i2 > a.this.aDm + a.this.mBottom + a.this.aDF) {
                    i2 = (int) ((a.this.aDm - a.this.getHeight()) + a.this.mBottom + a.this.aDF);
                }
            } else {
                i2 = 0;
            }
            if (a.this.aDl > a.this.getWidth()) {
                int width = ((float) (a.this.getWidth() + i)) > a.this.aDl ? (int) (a.this.aDl - a.this.getWidth()) : i;
                if (width >= 0) {
                    i3 = width;
                }
            }
            a.this.scrollTo(i3, i2);
            a.this.invalidate();
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            if (!this.aDV) {
                if (a.this.aDs) {
                    this.aDU = false;
                    return false;
                }
                try {
                    if (!super.getTransformation(j, transformation)) {
                        this.aDU = false;
                        return false;
                    }
                    return true;
                } catch (Exception e) {
                    this.aDU = false;
                    return false;
                }
            }
            this.aDV = false;
            this.aDU = false;
            return false;
        }

        public boolean GO() {
            return this.aDU;
        }

        public void stopAnimation() {
            this.aDV = true;
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.aDw = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.anJ = onLongClickListener;
    }

    public void setGifSetListener(d dVar) {
        this.anL = dVar;
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
    public void GL() {
        long j;
        c poll = this.aDN.poll();
        if (poll == null) {
            this.aDS = true;
            return;
        }
        this.aDS = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.aDM != null) {
            j = this.aDM.delay - (currentTimeMillis - this.aDR);
            this.aDO.offer(this.aDM);
        } else {
            j = 0;
        }
        this.aDM = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public c GM() {
        c poll = this.aDO.poll();
        if (poll == null) {
            poll = new c(null);
            try {
                poll.aEb = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
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
        public Bitmap aEb;
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
            while (a.this.mState == 1 && a.this.aDC != null && a.this.aDL > 0 && a.this.width > 0 && a.this.height > 0) {
                try {
                    a.this.aDC.R(a.this.aDP);
                    c GM = a.this.GM();
                    if (GM.aEb == null || (GM.aEb.getWidth() != a.this.width && GM.aEb.getHeight() != a.this.height)) {
                        try {
                            GM.aEb = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_8888);
                        } catch (OutOfMemoryError e) {
                            TbadkCoreApplication.m411getInst().onAppMemoryLow();
                            try {
                                GM.aEb = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_4444);
                            } catch (OutOfMemoryError e2) {
                                TbadkCoreApplication.m411getInst().onAppMemoryLow();
                            } catch (Throwable th) {
                                BdLog.e(th.getMessage());
                            }
                        } catch (Throwable th2) {
                            BdLog.e(th2.getMessage());
                        }
                    }
                    a.this.aDC.a(GM.aEb, null);
                    GM.delay = a.this.aDC.S(a.this.aDP);
                    a.this.aDP++;
                    if (GM.aEb == null) {
                        a.this.aDP++;
                    }
                    a.this.aDP %= a.this.aDL;
                    a.this.aDN.put(GM);
                    if (a.this.aDS) {
                        a.this.mHandler.sendEmptyMessage(1);
                    }
                } catch (Exception e3) {
                    return;
                }
            }
        }
    }

    public boolean GN() {
        return this.aDH;
    }

    public void setLoadBigImage(boolean z) {
        this.aDH = z;
    }
}
