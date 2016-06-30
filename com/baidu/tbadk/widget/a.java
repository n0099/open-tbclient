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
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends ImageView {
    private int YT;
    private boolean aBA;
    private int aBB;
    private volatile com.baidu.adp.gif.b aBC;
    private Bitmap aBD;
    private int aBE;
    private int aBF;
    private int aBG;
    private boolean aBH;
    private boolean aBI;
    private float aBJ;
    private Interpolator aBK;
    private int aBL;
    private c aBM;
    private BlockingLinkedDeque<c> aBN;
    private BlockingLinkedDeque<c> aBO;
    private volatile int aBP;
    private b aBQ;
    private volatile long aBR;
    private volatile boolean aBS;
    private float aBl;
    private float aBm;
    private ArrayList<Float> aBn;
    private float aBo;
    private float aBp;
    private float aBq;
    private float aBr;
    private boolean aBs;
    private int aBt;
    private int aBu;
    private e aBv;
    private View.OnClickListener aBw;
    private C0048a aBx;
    private float aBy;
    private boolean aBz;
    private View.OnLongClickListener aku;
    private d akw;
    private int akx;
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
        this.aBI = z;
    }

    public a(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aBs = false;
        this.mImageData = null;
        this.akx = 0;
        this.aBt = 1300;
        this.aBu = 0;
        this.aBv = null;
        this.aBw = null;
        this.aku = null;
        this.akw = null;
        this.aBy = 1.0f;
        this.YT = 0;
        this.mMode = 0;
        this.aBz = false;
        this.aBA = false;
        this.aBB = 0;
        this.aBC = null;
        this.aBD = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aBE = 0;
        this.aBF = 0;
        this.aBG = 0;
        this.aBK = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aBL = 0;
        this.aBM = null;
        this.aBN = new BlockingLinkedDeque<>(5);
        this.aBO = new BlockingLinkedDeque<>(6);
        this.aBP = 0;
        this.aBR = 0L;
        this.mState = 0;
        this.aBS = true;
        this.mHandler = new Handler(new com.baidu.tbadk.widget.b(this));
        initData();
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aBs = false;
        this.mImageData = null;
        this.akx = 0;
        this.aBt = 1300;
        this.aBu = 0;
        this.aBv = null;
        this.aBw = null;
        this.aku = null;
        this.akw = null;
        this.aBy = 1.0f;
        this.YT = 0;
        this.mMode = 0;
        this.aBz = false;
        this.aBA = false;
        this.aBB = 0;
        this.aBC = null;
        this.aBD = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aBE = 0;
        this.aBF = 0;
        this.aBG = 0;
        this.aBK = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aBL = 0;
        this.aBM = null;
        this.aBN = new BlockingLinkedDeque<>(5);
        this.aBO = new BlockingLinkedDeque<>(6);
        this.aBP = 0;
        this.aBR = 0L;
        this.mState = 0;
        this.aBS = true;
        this.mHandler = new Handler(new com.baidu.tbadk.widget.b(this));
        initData();
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aBs = false;
        this.mImageData = null;
        this.akx = 0;
        this.aBt = 1300;
        this.aBu = 0;
        this.aBv = null;
        this.aBw = null;
        this.aku = null;
        this.akw = null;
        this.aBy = 1.0f;
        this.YT = 0;
        this.mMode = 0;
        this.aBz = false;
        this.aBA = false;
        this.aBB = 0;
        this.aBC = null;
        this.aBD = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aBE = 0;
        this.aBF = 0;
        this.aBG = 0;
        this.aBK = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aBL = 0;
        this.aBM = null;
        this.aBN = new BlockingLinkedDeque<>(5);
        this.aBO = new BlockingLinkedDeque<>(6);
        this.aBP = 0;
        this.aBR = 0L;
        this.mState = 0;
        this.aBS = true;
        this.mHandler = new Handler(new com.baidu.tbadk.widget.b(this));
        initData();
    }

    public int getImageType() {
        return this.YT;
    }

    public void setImageMode(int i) {
        this.aBu = i;
    }

    public void g(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.akx = i;
    }

    public void FP() {
        this.aBA = false;
        this.aBs = false;
        this.mMode = 0;
        FT();
        if (this.aBq < this.aBo) {
            this.aBq = this.aBo;
            Ga();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.aBs = true;
                this.aBz = false;
                this.aBA = false;
                break;
            case 1:
                FP();
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
            this.aBy = g(motionEvent);
            if (this.aBy > 10.0f) {
                this.mMode = 2;
            }
        }
        if (this.mMode == 2 || !this.mGestureDetector.onTouchEvent(motionEvent)) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.aBz = true;
                        this.aBA = true;
                        if (this.YT != 1 && this.YT != 2) {
                            float g = g(motionEvent);
                            if (g >= 0.0f && Math.abs(this.aBy - g) >= 10.0f) {
                                if (Math.abs(this.aBy - g) > 100.0f) {
                                    this.aBy = g;
                                    break;
                                } else {
                                    float f = g / this.aBy;
                                    this.aBy = g;
                                    this.aBr = this.aBq;
                                    this.aBq *= f;
                                    if (this.aBq > this.aBp) {
                                        this.aBq = this.aBp;
                                    }
                                    if (this.aBq < this.aBo / 4.0f) {
                                        this.aBq = this.aBo / 4.0f;
                                    }
                                    Ga();
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
            FR();
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public boolean FQ() {
        return this.aBo == this.aBq;
    }

    private void FR() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            if (this.aBu == 0) {
                float width = this.mViewWidth / imageBitmap.getWidth();
                float height = this.mViewHeight / imageBitmap.getHeight();
                if (this.aBI) {
                    if (this.YT == 2) {
                        this.aBo = 2.5f;
                    } else {
                        this.aBo = Math.min(width, height);
                    }
                } else if (this.YT == 2) {
                    this.aBo = 1.0f;
                } else {
                    float f = this.aBJ;
                    float f2 = f >= 1.0f ? f : 1.0f;
                    if (imageBitmap.getWidth() * f2 < this.mViewWidth && imageBitmap.getHeight() * f2 < this.mViewHeight) {
                        this.aBo = f2;
                    } else {
                        this.aBo = Math.min(width, height);
                    }
                }
            } else {
                this.aBo = Math.max(this.mViewWidth / imageBitmap.getWidth(), ((this.mViewHeight - this.mTop) - this.mBottom) / imageBitmap.getHeight());
            }
            this.aBp = this.aBt / (imageBitmap.getWidth() * imageBitmap.getHeight());
            this.aBp = FloatMath.sqrt(this.aBp);
            if (this.aBp > 10.0f) {
                this.aBp = 10.0f;
            }
            this.aBn.clear();
            this.aBn.add(Float.valueOf(this.aBo));
            this.aBq = this.aBo;
            this.aBr = this.aBq;
            Ga();
            FS();
            return;
        }
        this.aBl = 0.0f;
        this.aBm = 0.0f;
        this.aBo = 1.0f;
        this.aBp = 1.0f;
        this.aBq = 1.0f;
        this.aBr = this.aBq;
        this.aBn.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FS() {
        if (this.aBv != null) {
            this.aBv.a(this, canZoomIn(), canZoomOut());
        }
    }

    public void setOnSizeChangedListener(e eVar) {
        this.aBv = eVar;
    }

    public byte[] getImageData() {
        return this.mImageData;
    }

    public void setImageData(byte[] bArr) {
        this.mImageData = bArr;
    }

    public Bitmap getGifCache() {
        return this.aBD;
    }

    public void setGifCache(Bitmap bitmap) {
        this.aBD = bitmap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        boolean z;
        int i4;
        if (this.YT == 2 && this.aBG != 0 && !this.aBx.Ge()) {
            int width = getWidth();
            int height = getHeight();
            Drawable drawable = getDrawable();
            float f = 0.0f;
            float f2 = height * 0.3f;
            float f3 = width;
            float f4 = (1.0f - 0.3f) * height;
            if (this.aBI && drawable != null) {
                Rect bounds = drawable.getBounds();
                int i5 = bounds.right - bounds.left;
                int i6 = bounds.bottom - bounds.top;
                f = (width / 2) - (i5 * 2.5f);
                f2 = (height / 2) - (i6 * 2.5f);
                f3 = (i5 * 2.5f) + (width / 2);
                f4 = (i6 * 2.5f) + (height / 2);
            }
            this.mPaint.setColor(av.getColor(this.aBG));
            canvas.drawRect(f, f2, f3, f4, this.mPaint);
            this.mPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        }
        super.onDraw(canvas);
        if (this.YT == 1 && this.aBD != null && !this.aBD.isRecycled()) {
            int width2 = this.aBD.getWidth();
            int height2 = this.aBD.getHeight();
            int width3 = getWidth();
            int height3 = getHeight();
            int i7 = (width3 - width2) >> 1;
            int i8 = (height3 - height2) >> 1;
            float f5 = this.aBJ;
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
            if (this.aBB == 1 && this.aBC != null && this.aBM != null && this.aBM.aCb != null) {
                if (z) {
                    canvas.drawBitmap(this.aBM.aCb, i3, i2, (Paint) null);
                } else {
                    canvas.drawBitmap(this.aBM.aCb, this.mMatrix, this.mPaint);
                }
                invalidate();
            } else if (z) {
                canvas.drawBitmap(this.aBD, i3, i2, (Paint) null);
            } else {
                canvas.drawBitmap(this.aBD, this.mMatrix, this.mPaint);
            }
        }
    }

    public void play() {
        com.baidu.adp.widget.a.a d2;
        if (this.YT == 1) {
            if (this.aBC == null) {
                if (this.aBQ != null) {
                    this.aBQ.interrupt();
                    this.aBQ = null;
                }
                if (this.mImageData != null && (d2 = a.C0004a.bC().d(this.mImageData, 0, this.mImageData.length)) != null && d2.getGif() != null) {
                    this.aBC = d2.getGif();
                    if (this.aBC != null) {
                        this.aBB = 1;
                        this.width = this.aBC.getWidth();
                        this.height = this.aBC.getHeight();
                        this.aBP = 0;
                        this.aBL = this.aBC.bD();
                    } else {
                        this.aBB = 0;
                    }
                } else {
                    return;
                }
            }
            if (this.aBC != null && this.mState == 0) {
                this.aBS = true;
                this.aBQ = new b(this, null);
                this.aBN.clear();
                this.aBO.clear();
                this.mState = 1;
                this.aBQ.start();
            }
        }
    }

    public void pause() {
        if (this.YT == 1) {
            this.mState = 0;
            if (this.aBQ != null) {
                this.aBQ.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.YT == 1) {
            this.mState = 0;
            if (this.aBQ != null) {
                this.aBQ.interrupt();
                this.aBQ = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.aBS = true;
            this.aBM = null;
            this.aBO.clear();
            this.aBN.clear();
            this.width = 0;
            this.height = 0;
            this.aBP = 0;
            this.aBL = 0;
            if (this.aBC != null) {
                this.aBC = null;
            }
        }
    }

    private void initData() {
        this.aBJ = k.C(getContext());
        this.aBt = k.B(getContext()) * k.A(getContext()) * 2;
        if (this.aBt < 1690000) {
            this.aBt = 1690000;
        }
        this.aBl = 0.0f;
        this.aBm = 0.0f;
        this.aBn = new ArrayList<>();
        this.aBo = 1.0f;
        this.aBp = 1.0f;
        this.aBq = 1.0f;
        this.aBr = this.aBq;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.aBx = new C0048a();
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWillNotDraw(false);
        scrollTo(0, 0);
        this.mGestureDetector = new GestureDetector(getContext(), new com.baidu.tbadk.widget.c(this));
    }

    private void FT() {
        int i = 0;
        int scrollX = getScrollX();
        if (this.aBl >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.aBl) {
                scrollX = (int) (this.aBl - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.aBm + this.mTop + this.mBottom >= getHeight()) {
            i = scrollY < (-this.aBE) ? -this.aBE : scrollY;
            if (getHeight() + i > this.aBm + this.mBottom + this.aBF) {
                i = (int) ((this.aBm - getHeight()) + this.mBottom + this.aBF);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.aBl;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.aBm;
    }

    public boolean FU() {
        if (this.YT == 1 || this.YT == 2) {
            return true;
        }
        return !this.aBA && getScrollX() >= ((int) (this.aBl - ((float) getWidth()))) + (-1);
    }

    public boolean FV() {
        if (this.YT == 1 || this.YT == 2) {
            return true;
        }
        return !this.aBA && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.aBx.Ge()) {
            this.aBx.stopAnimation();
        }
        this.aBG = 0;
        super.setImageBitmap(bitmap);
        FR();
        this.YT = 0;
    }

    public void f(Bitmap bitmap) {
        Bitmap imageBitmap = getImageBitmap();
        if (bitmap != null && !bitmap.isRecycled()) {
            if (imageBitmap != null && (imageBitmap.getWidth() != bitmap.getWidth() || imageBitmap.getHeight() != bitmap.getHeight())) {
                setImageBitmap(bitmap);
                return;
            }
            if (this.aBx.Ge()) {
                this.aBx.stopAnimation();
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            super.setImageBitmap(bitmap);
            super.setImageMatrix(this.mMatrix);
            scrollTo(scrollX, scrollY);
            this.YT = 0;
        }
    }

    public void a(byte[] bArr, Bitmap bitmap) {
        if (this.aBx.Ge()) {
            this.aBx.stopAnimation();
        }
        super.setImageDrawable(null);
        stop();
        FR();
        this.YT = 1;
        this.aBD = bitmap;
        this.mImageData = bArr;
        if (this.akw != null) {
            this.akw.a(this);
        }
    }

    public void onDestroy() {
        if (this.aBx.Ge()) {
            this.aBx.stopAnimation();
        }
        super.setImageDrawable(null);
        this.mImageData = null;
        this.aBD = null;
        stop();
        if (this.aBC != null) {
            this.aBC.close();
            this.aBC = null;
        }
    }

    public void release() {
        if (this.aBx.Ge()) {
            this.aBx.stopAnimation();
        }
        stop();
        super.setImageDrawable(null);
        this.aBD = null;
    }

    public void FW() {
        if (this.aBx.Ge()) {
            this.aBx.stopAnimation();
        }
        if (this.aBI) {
            super.setImageBitmap(BitmapHelper.getCashBitmap(u.f.icon_default_avatar100));
        } else {
            super.setImageBitmap(BitmapHelper.getCashBitmap(u.f.btn_see_default));
        }
        this.YT = 2;
        FR();
    }

    public void FX() {
        if (this.YT != 1 && this.YT != 2) {
            int size = this.aBn.size();
            if (size > 0) {
                this.aBn.add(Float.valueOf(this.aBn.get(size - 1).floatValue() * 1.25f));
            } else {
                this.aBn.add(Float.valueOf(this.aBo));
            }
            Ga();
            FS();
        }
    }

    public void FY() {
        if (this.YT != 1 && this.YT != 2) {
            int size = this.aBn.size();
            if (size > 1) {
                this.aBn.remove(size - 1);
            }
            Ga();
            FS();
        }
    }

    public void FZ() {
        FS();
        if (this.YT != 1 && this.YT != 2 && this.aBq != this.aBo) {
            this.aBn.clear();
            this.aBn.add(Float.valueOf(this.aBo));
            this.aBq = this.aBo;
            this.aBr = this.aBq;
            Ga();
        }
    }

    public boolean canZoomIn() {
        if (this.YT == 1 || this.YT == 2) {
            return false;
        }
        int size = this.aBn.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.aBn.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.aBt) && floatValue <= 5.0f;
    }

    public boolean canZoomOut() {
        if (this.YT == 1 || this.YT == 2) {
            return false;
        }
        int size = this.aBn.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled()) {
            return false;
        }
        return size > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ga() {
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
                    int size = this.aBn.size();
                    if (size > 0) {
                        f2 = this.aBn.get(size - 1).floatValue();
                    } else {
                        f2 = this.aBo;
                    }
                    this.aBq = f2;
                }
                this.mMatrix.setScale(this.aBq, this.aBq);
                this.aBl = imageBitmap.getWidth() * this.aBq;
                this.aBm = imageBitmap.getHeight() * this.aBq;
                float width = this.aBr * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.aBr;
                this.aBE = this.mTop;
                this.aBF = 0;
                float f3 = this.aBl < ((float) this.mViewWidth) ? (int) ((this.mViewWidth - this.aBl) / 2.0f) : 0.0f;
                if (this.aBm < this.mViewHeight) {
                    f = (int) ((this.mViewHeight - this.aBm) / 2.0f);
                    if (this.aBu == 1 && f > this.mTop) {
                        f = this.mTop;
                    }
                    this.aBE = (int) (this.mTop - f);
                    this.aBF = this.mTop - this.aBE;
                } else {
                    f = 0.0f;
                }
                this.mMatrix.postTranslate(f3, f);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    scrollX = i > getWidth() ? getWidth() : i;
                    if (this.aBl <= screenWidth) {
                        scrollX = 0;
                    } else if (this.aBl > screenWidth && this.aBl / 2.0f < screenWidth) {
                        scrollX = (int) (scrollX - (this.aBl / 4.0f));
                    }
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.aBl - width) / 2.0f);
                    }
                    if (this.aBl <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.aBl) {
                        scrollX = (int) (this.aBl - getWidth());
                    }
                }
                if (scrollX > 0 && this.aBl - scrollX < getWidth()) {
                    scrollX = (int) (this.aBl - getWidth());
                }
                if (this.mMode == 2) {
                    scrollY += (int) ((this.aBm - height) / 2.0f);
                }
                if (this.aBm <= getHeight()) {
                    scrollY = 0;
                } else if (getHeight() + scrollY > this.aBm) {
                    scrollY = (int) (this.aBm - getHeight());
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
        private boolean aBU = false;
        private boolean aBV = false;
        private long aBW;
        private long aBX;
        private int aBY;
        private long aBZ;
        private long aCa;
        private int zs;

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
            this.aBW = f;
            this.aBX = f2;
            this.aBZ = Math.abs((f * 1000.0f) / 2500.0f);
            this.aCa = Math.abs((f2 * 1000.0f) / 2500.0f);
            setDuration(Math.max(this.aBZ, this.aCa));
            setInterpolator(a.this.aBK);
            this.aBY = a.this.getScrollX();
            this.zs = a.this.getScrollY();
            this.aBU = true;
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
            if (this.aBZ > this.aCa) {
                j = ((float) this.aBZ) * f;
            } else {
                j = ((float) this.aCa) * f;
            }
            float f2 = ((float) (j > this.aBZ ? this.aBZ : j)) / 1000.0f;
            if (this.aBW > 0) {
                i = this.aBY - ((int) (f2 * (((float) this.aBW) - ((2500.0f * f2) / 2.0f))));
            } else {
                i = this.aBY - ((int) (f2 * (((float) this.aBW) + ((2500.0f * f2) / 2.0f))));
            }
            if (j > this.aCa) {
                j = this.aCa;
            }
            float f3 = ((float) j) / 1000.0f;
            if (this.aBX > 0) {
                i2 = this.zs - ((int) (f3 * (((float) this.aBX) - ((2500.0f * f3) / 2.0f))));
            } else {
                i2 = this.zs - ((int) (f3 * (((float) this.aBX) + ((2500.0f * f3) / 2.0f))));
            }
            if (a.this.aBm + a.this.mTop + a.this.mBottom > a.this.getHeight()) {
                if (i2 < (-a.this.aBE)) {
                    i2 = -a.this.aBE;
                }
                if (a.this.getHeight() + i2 > a.this.aBm + a.this.mBottom + a.this.aBF) {
                    i2 = (int) ((a.this.aBm - a.this.getHeight()) + a.this.mBottom + a.this.aBF);
                }
            } else {
                i2 = 0;
            }
            if (a.this.aBl > a.this.getWidth()) {
                int width = ((float) (a.this.getWidth() + i)) > a.this.aBl ? (int) (a.this.aBl - a.this.getWidth()) : i;
                if (width >= 0) {
                    i3 = width;
                }
            }
            a.this.scrollTo(i3, i2);
            a.this.invalidate();
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            if (!this.aBV) {
                if (a.this.aBs) {
                    this.aBU = false;
                    return false;
                }
                try {
                    if (!super.getTransformation(j, transformation)) {
                        this.aBU = false;
                        return false;
                    }
                    return true;
                } catch (Exception e) {
                    this.aBU = false;
                    return false;
                }
            }
            this.aBV = false;
            this.aBU = false;
            return false;
        }

        public boolean Ge() {
            return this.aBU;
        }

        public void stopAnimation() {
            this.aBV = true;
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.aBw = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aku = onLongClickListener;
    }

    public void setGifSetListener(d dVar) {
        this.akw = dVar;
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
    public void Gb() {
        long j;
        c poll = this.aBN.poll();
        if (poll == null) {
            this.aBS = true;
            return;
        }
        this.aBS = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.aBM != null) {
            j = this.aBM.delay - (currentTimeMillis - this.aBR);
            this.aBO.offer(this.aBM);
        } else {
            j = 0;
        }
        this.aBM = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public c Gc() {
        c poll = this.aBO.poll();
        if (poll == null) {
            poll = new c(null);
            try {
                poll.aCb = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
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
        public Bitmap aCb;
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
            while (a.this.mState == 1 && a.this.aBC != null && a.this.aBL > 0 && a.this.width > 0 && a.this.height > 0) {
                try {
                    a.this.aBC.E(a.this.aBP);
                    c Gc = a.this.Gc();
                    if (Gc.aCb == null || (Gc.aCb.getWidth() != a.this.width && Gc.aCb.getHeight() != a.this.height)) {
                        try {
                            Gc.aCb = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_8888);
                        } catch (OutOfMemoryError e) {
                            TbadkCoreApplication.m9getInst().onAppMemoryLow();
                            try {
                                Gc.aCb = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_4444);
                            } catch (OutOfMemoryError e2) {
                                TbadkCoreApplication.m9getInst().onAppMemoryLow();
                            } catch (Throwable th) {
                                BdLog.e(th.getMessage());
                            }
                        } catch (Throwable th2) {
                            BdLog.e(th2.getMessage());
                        }
                    }
                    a.this.aBC.a(Gc.aCb, null);
                    Gc.delay = a.this.aBC.F(a.this.aBP);
                    a.this.aBP++;
                    if (Gc.aCb == null) {
                        a.this.aBP++;
                    }
                    a.this.aBP %= a.this.aBL;
                    a.this.aBN.put(Gc);
                    if (a.this.aBS) {
                        a.this.mHandler.sendEmptyMessage(1);
                    }
                } catch (Exception e3) {
                    return;
                }
            }
        }
    }

    public boolean Gd() {
        return this.aBH;
    }

    public void setLoadBigImage(boolean z) {
        this.aBH = z;
    }
}
