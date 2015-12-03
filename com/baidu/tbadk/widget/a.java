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
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends ImageView {
    private float aAO;
    private float aAP;
    private ArrayList<Float> aAQ;
    private float aAR;
    private float aAS;
    private float aAT;
    private float aAU;
    private boolean aAV;
    private int aAW;
    private int aAX;
    private e aAY;
    private View.OnClickListener aAZ;
    private C0056a aBa;
    private float aBb;
    private boolean aBc;
    private boolean aBd;
    private int aBe;
    private volatile com.baidu.adp.gif.b aBf;
    private Bitmap aBg;
    private int aBh;
    private int aBi;
    private int aBj;
    private boolean aBk;
    private boolean aBl;
    private float aBm;
    private Interpolator aBn;
    private int aBo;
    private c aBp;
    private BlockingLinkedDeque<c> aBq;
    private BlockingLinkedDeque<c> aBr;
    private volatile int aBs;
    private b aBt;
    private volatile long aBu;
    private volatile boolean aBv;
    private int acN;
    private View.OnLongClickListener alK;
    private d alM;
    private int alN;
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
        this.aBl = z;
    }

    public a(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aAV = false;
        this.mImageData = null;
        this.alN = 0;
        this.aAW = 1300;
        this.aAX = 0;
        this.aAY = null;
        this.aAZ = null;
        this.alK = null;
        this.alM = null;
        this.aBb = 1.0f;
        this.acN = 0;
        this.mMode = 0;
        this.aBc = false;
        this.aBd = false;
        this.aBe = 0;
        this.aBf = null;
        this.aBg = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aBh = 0;
        this.aBi = 0;
        this.aBj = 0;
        this.aBn = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aBo = 0;
        this.aBp = null;
        this.aBq = new BlockingLinkedDeque<>(5);
        this.aBr = new BlockingLinkedDeque<>(6);
        this.aBs = 0;
        this.aBu = 0L;
        this.mState = 0;
        this.aBv = true;
        this.mHandler = new Handler(new com.baidu.tbadk.widget.b(this));
        initData();
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aAV = false;
        this.mImageData = null;
        this.alN = 0;
        this.aAW = 1300;
        this.aAX = 0;
        this.aAY = null;
        this.aAZ = null;
        this.alK = null;
        this.alM = null;
        this.aBb = 1.0f;
        this.acN = 0;
        this.mMode = 0;
        this.aBc = false;
        this.aBd = false;
        this.aBe = 0;
        this.aBf = null;
        this.aBg = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aBh = 0;
        this.aBi = 0;
        this.aBj = 0;
        this.aBn = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aBo = 0;
        this.aBp = null;
        this.aBq = new BlockingLinkedDeque<>(5);
        this.aBr = new BlockingLinkedDeque<>(6);
        this.aBs = 0;
        this.aBu = 0L;
        this.mState = 0;
        this.aBv = true;
        this.mHandler = new Handler(new com.baidu.tbadk.widget.b(this));
        initData();
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aAV = false;
        this.mImageData = null;
        this.alN = 0;
        this.aAW = 1300;
        this.aAX = 0;
        this.aAY = null;
        this.aAZ = null;
        this.alK = null;
        this.alM = null;
        this.aBb = 1.0f;
        this.acN = 0;
        this.mMode = 0;
        this.aBc = false;
        this.aBd = false;
        this.aBe = 0;
        this.aBf = null;
        this.aBg = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aBh = 0;
        this.aBi = 0;
        this.aBj = 0;
        this.aBn = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aBo = 0;
        this.aBp = null;
        this.aBq = new BlockingLinkedDeque<>(5);
        this.aBr = new BlockingLinkedDeque<>(6);
        this.aBs = 0;
        this.aBu = 0L;
        this.mState = 0;
        this.aBv = true;
        this.mHandler = new Handler(new com.baidu.tbadk.widget.b(this));
        initData();
    }

    public int getImageType() {
        return this.acN;
    }

    public void setImageMode(int i) {
        this.aAX = i;
    }

    public void setOffset(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.alN = i;
    }

    public void actionUp() {
        this.aBd = false;
        this.aAV = false;
        this.mMode = 0;
        FD();
        if (this.aAT < this.aAR) {
            this.aAT = this.aAR;
            FE();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.aAV = true;
                this.aBc = false;
                this.aBd = false;
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
            this.aBb = spacing(motionEvent);
            if (this.aBb > 10.0f) {
                this.mMode = 2;
            }
        }
        if (this.mMode == 2 || !this.mGestureDetector.onTouchEvent(motionEvent)) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.aBc = true;
                        this.aBd = true;
                        if (this.acN != 1 && this.acN != 2) {
                            float spacing = spacing(motionEvent);
                            if (spacing >= 0.0f && Math.abs(this.aBb - spacing) >= 10.0f) {
                                if (Math.abs(this.aBb - spacing) > 100.0f) {
                                    this.aBb = spacing;
                                    break;
                                } else {
                                    float f = spacing / this.aBb;
                                    this.aBb = spacing;
                                    this.aAU = this.aAT;
                                    this.aAT *= f;
                                    if (this.aAT > this.aAS) {
                                        this.aAT = this.aAS;
                                    }
                                    if (this.aAT < this.aAR / 4.0f) {
                                        this.aAT = this.aAR / 4.0f;
                                    }
                                    FE();
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
        return this.aAR == this.aAT;
    }

    private void reInitBitmap() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            if (this.aAX == 0) {
                float width = this.mViewWidth / imageBitmap.getWidth();
                float height = this.mViewHeight / imageBitmap.getHeight();
                if (this.aBl) {
                    if (this.acN == 2) {
                        this.aAR = 2.5f;
                    } else {
                        this.aAR = Math.min(width, height);
                    }
                } else if (this.acN == 2) {
                    this.aAR = 1.0f;
                } else {
                    float f = this.aBm;
                    float f2 = f >= 1.0f ? f : 1.0f;
                    if (imageBitmap.getWidth() * f2 < this.mViewWidth && imageBitmap.getHeight() * f2 < this.mViewHeight) {
                        this.aAR = f2;
                    } else {
                        this.aAR = Math.min(width, height);
                    }
                }
            } else {
                this.aAR = Math.max(this.mViewWidth / imageBitmap.getWidth(), ((this.mViewHeight - this.mTop) - this.mBottom) / imageBitmap.getHeight());
            }
            this.aAS = this.aAW / (imageBitmap.getWidth() * imageBitmap.getHeight());
            this.aAS = FloatMath.sqrt(this.aAS);
            if (this.aAS > 10.0f) {
                this.aAS = 10.0f;
            }
            this.aAQ.clear();
            this.aAQ.add(Float.valueOf(this.aAR));
            this.aAT = this.aAR;
            this.aAU = this.aAT;
            FE();
            FC();
            return;
        }
        this.aAO = 0.0f;
        this.aAP = 0.0f;
        this.aAR = 1.0f;
        this.aAS = 1.0f;
        this.aAT = 1.0f;
        this.aAU = this.aAT;
        this.aAQ.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FC() {
        if (this.aAY != null) {
            this.aAY.a(this, canZoomIn(), canZoomOut());
        }
    }

    public void setOnSizeChangedListener(e eVar) {
        this.aAY = eVar;
    }

    public byte[] getImageData() {
        return this.mImageData;
    }

    public void setImageData(byte[] bArr) {
        this.mImageData = bArr;
    }

    public Bitmap getGifCache() {
        return this.aBg;
    }

    public void setGifCache(Bitmap bitmap) {
        this.aBg = bitmap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        boolean z;
        int i4;
        if (this.acN == 2 && this.aBj != 0 && !this.aBa.FI()) {
            int width = getWidth();
            int height = getHeight();
            Drawable drawable = getDrawable();
            float f = 0.0f;
            float f2 = height * 0.3f;
            float f3 = width;
            float f4 = (1.0f - 0.3f) * height;
            if (this.aBl && drawable != null) {
                Rect bounds = drawable.getBounds();
                int i5 = bounds.right - bounds.left;
                int i6 = bounds.bottom - bounds.top;
                f = (width / 2) - (i5 * 2.5f);
                f2 = (height / 2) - (i6 * 2.5f);
                f3 = (i5 * 2.5f) + (width / 2);
                f4 = (i6 * 2.5f) + (height / 2);
            }
            this.mPaint.setColor(as.getColor(this.aBj));
            canvas.drawRect(f, f2, f3, f4, this.mPaint);
            this.mPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        }
        super.onDraw(canvas);
        if (this.acN == 1 && this.aBg != null && !this.aBg.isRecycled()) {
            int width2 = this.aBg.getWidth();
            int height2 = this.aBg.getHeight();
            int width3 = getWidth();
            int height3 = getHeight();
            int i7 = (width3 - width2) >> 1;
            int i8 = (height3 - height2) >> 1;
            float f5 = this.aBm;
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
            if (this.aBe == 1 && this.aBf != null && this.aBp != null && this.aBp.aBE != null) {
                if (z) {
                    canvas.drawBitmap(this.aBp.aBE, i3, i2, (Paint) null);
                } else {
                    canvas.drawBitmap(this.aBp.aBE, this.mMatrix, this.mPaint);
                }
                invalidate();
            } else if (z) {
                canvas.drawBitmap(this.aBg, i3, i2, (Paint) null);
            } else {
                canvas.drawBitmap(this.aBg, this.mMatrix, this.mPaint);
            }
        }
    }

    public void play() {
        com.baidu.adp.widget.a.a e2;
        if (this.acN == 1) {
            if (this.aBf == null) {
                if (this.aBt != null) {
                    this.aBt.interrupt();
                    this.aBt = null;
                }
                if (this.mImageData != null && (e2 = a.C0002a.fe().e(this.mImageData, 0, this.mImageData.length)) != null && e2.getGif() != null) {
                    this.aBf = e2.getGif();
                    if (this.aBf != null) {
                        this.aBe = 1;
                        this.width = this.aBf.getWidth();
                        this.height = this.aBf.getHeight();
                        this.aBs = 0;
                        this.aBo = this.aBf.ff();
                    } else {
                        this.aBe = 0;
                    }
                } else {
                    return;
                }
            }
            if (this.aBf != null && this.mState == 0) {
                this.aBv = true;
                this.aBt = new b(this, null);
                this.aBq.clear();
                this.aBr.clear();
                this.mState = 1;
                this.aBt.start();
            }
        }
    }

    public void pause() {
        if (this.acN == 1) {
            this.mState = 0;
            if (this.aBt != null) {
                this.aBt.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.acN == 1) {
            this.mState = 0;
            if (this.aBt != null) {
                this.aBt.interrupt();
                this.aBt = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.aBv = true;
            this.aBp = null;
            this.aBr.clear();
            this.aBq.clear();
            this.width = 0;
            this.height = 0;
            this.aBs = 0;
            this.aBo = 0;
            if (this.aBf != null) {
                this.aBf = null;
            }
        }
    }

    private void initData() {
        this.aBm = k.M(getContext());
        this.aAW = k.L(getContext()) * k.K(getContext()) * 2;
        if (this.aAW < 1690000) {
            this.aAW = 1690000;
        }
        this.aAO = 0.0f;
        this.aAP = 0.0f;
        this.aAQ = new ArrayList<>();
        this.aAR = 1.0f;
        this.aAS = 1.0f;
        this.aAT = 1.0f;
        this.aAU = this.aAT;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.aBa = new C0056a();
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWillNotDraw(false);
        scrollTo(0, 0);
        this.mGestureDetector = new GestureDetector(getContext(), new com.baidu.tbadk.widget.c(this));
    }

    private void FD() {
        int i = 0;
        int scrollX = getScrollX();
        if (this.aAO >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.aAO) {
                scrollX = (int) (this.aAO - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.aAP + this.mTop + this.mBottom >= getHeight()) {
            i = scrollY < (-this.aBh) ? -this.aBh : scrollY;
            if (getHeight() + i > this.aAP + this.mBottom + this.aBi) {
                i = (int) ((this.aAP - getHeight()) + this.mBottom + this.aBi);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.aAO;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.aAP;
    }

    public boolean onRightSide() {
        if (this.acN == 1 || this.acN == 2) {
            return true;
        }
        return !this.aBd && getScrollX() >= ((int) (this.aAO - ((float) getWidth()))) + (-1);
    }

    public boolean onLeftSide() {
        if (this.acN == 1 || this.acN == 2) {
            return true;
        }
        return !this.aBd && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.aBa.FI()) {
            this.aBa.stopAnimation();
        }
        this.aBj = 0;
        super.setImageBitmap(bitmap);
        reInitBitmap();
        this.acN = 0;
    }

    public void replaceImageBitmap(Bitmap bitmap) {
        Bitmap imageBitmap = getImageBitmap();
        if (bitmap != null && !bitmap.isRecycled()) {
            if (imageBitmap != null && (imageBitmap.getWidth() != bitmap.getWidth() || imageBitmap.getHeight() != bitmap.getHeight())) {
                setImageBitmap(bitmap);
                return;
            }
            if (this.aBa.FI()) {
                this.aBa.stopAnimation();
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            super.setImageBitmap(bitmap);
            super.setImageMatrix(this.mMatrix);
            scrollTo(scrollX, scrollY);
            this.acN = 0;
        }
    }

    public void a(byte[] bArr, Bitmap bitmap) {
        if (this.aBa.FI()) {
            this.aBa.stopAnimation();
        }
        super.setImageDrawable(null);
        stop();
        reInitBitmap();
        this.acN = 1;
        this.aBg = bitmap;
        this.mImageData = bArr;
        if (this.alM != null) {
            this.alM.a(this);
        }
    }

    public void onDestroy() {
        if (this.aBa.FI()) {
            this.aBa.stopAnimation();
        }
        super.setImageDrawable(null);
        this.mImageData = null;
        this.aBg = null;
        stop();
        if (this.aBf != null) {
            this.aBf.close();
            this.aBf = null;
        }
    }

    public void release() {
        if (this.aBa.FI()) {
            this.aBa.stopAnimation();
        }
        stop();
        super.setImageDrawable(null);
        this.aBg = null;
    }

    public void setDefaultBitmap() {
        if (this.aBa.FI()) {
            this.aBa.stopAnimation();
        }
        if (this.aBl) {
            super.setImageBitmap(com.baidu.tbadk.core.util.c.cn(n.e.icon_default_avatar100));
        } else {
            super.setImageBitmap(com.baidu.tbadk.core.util.c.cn(n.e.btn_see_default));
        }
        this.acN = 2;
        reInitBitmap();
    }

    public void zoomInBitmap() {
        if (this.acN != 1 && this.acN != 2) {
            int size = this.aAQ.size();
            if (size > 0) {
                this.aAQ.add(Float.valueOf(this.aAQ.get(size - 1).floatValue() * 1.25f));
            } else {
                this.aAQ.add(Float.valueOf(this.aAR));
            }
            FE();
            FC();
        }
    }

    public void zoomOutBitmap() {
        if (this.acN != 1 && this.acN != 2) {
            int size = this.aAQ.size();
            if (size > 1) {
                this.aAQ.remove(size - 1);
            }
            FE();
            FC();
        }
    }

    public void restoreSize() {
        FC();
        if (this.acN != 1 && this.acN != 2 && this.aAT != this.aAR) {
            this.aAQ.clear();
            this.aAQ.add(Float.valueOf(this.aAR));
            this.aAT = this.aAR;
            this.aAU = this.aAT;
            FE();
        }
    }

    public boolean canZoomIn() {
        if (this.acN == 1 || this.acN == 2) {
            return false;
        }
        int size = this.aAQ.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.aAQ.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.aAW) && floatValue <= 5.0f;
    }

    public boolean canZoomOut() {
        if (this.acN == 1 || this.acN == 2) {
            return false;
        }
        int size = this.aAQ.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled()) {
            return false;
        }
        return size > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FE() {
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
                    int size = this.aAQ.size();
                    if (size > 0) {
                        f2 = this.aAQ.get(size - 1).floatValue();
                    } else {
                        f2 = this.aAR;
                    }
                    this.aAT = f2;
                }
                this.mMatrix.setScale(this.aAT, this.aAT);
                this.aAO = imageBitmap.getWidth() * this.aAT;
                this.aAP = imageBitmap.getHeight() * this.aAT;
                float width = this.aAU * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.aAU;
                this.aBh = this.mTop;
                this.aBi = 0;
                float f3 = this.aAO < ((float) this.mViewWidth) ? (int) ((this.mViewWidth - this.aAO) / 2.0f) : 0.0f;
                if (this.aAP < this.mViewHeight) {
                    f = (int) ((this.mViewHeight - this.aAP) / 2.0f);
                    if (this.aAX == 1 && f > this.mTop) {
                        f = this.mTop;
                    }
                    this.aBh = (int) (this.mTop - f);
                    this.aBi = this.mTop - this.aBh;
                } else {
                    f = 0.0f;
                }
                this.mMatrix.postTranslate(f3, f);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    scrollX = i > getWidth() ? getWidth() : i;
                    if (this.aAO <= screenWidth) {
                        scrollX = 0;
                    } else if (this.aAO > screenWidth && this.aAO / 2.0f < screenWidth) {
                        scrollX = (int) (scrollX - (this.aAO / 4.0f));
                    }
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.aAO - width) / 2.0f);
                    }
                    if (this.aAO <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.aAO) {
                        scrollX = (int) (this.aAO - getWidth());
                    }
                }
                if (scrollX > 0 && this.aAO - scrollX < getWidth()) {
                    scrollX = (int) (this.aAO - getWidth());
                }
                if (this.mMode == 2) {
                    scrollY += (int) ((this.aAP - height) / 2.0f);
                }
                if (this.aAP <= getHeight()) {
                    scrollY = 0;
                } else if (getHeight() + scrollY > this.aAP) {
                    scrollY = (int) (this.aAP - getHeight());
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
    public class C0056a extends Animation {
        private int Ir;
        private long aBA;
        private int aBB;
        private long aBC;
        private long aBD;
        private boolean aBx = false;
        private boolean aBy = false;
        private long aBz;

        public C0056a() {
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
            this.aBz = f;
            this.aBA = f2;
            this.aBC = Math.abs((f * 1000.0f) / 2500.0f);
            this.aBD = Math.abs((f2 * 1000.0f) / 2500.0f);
            setDuration(Math.max(this.aBC, this.aBD));
            setInterpolator(a.this.aBn);
            this.aBB = a.this.getScrollX();
            this.Ir = a.this.getScrollY();
            this.aBx = true;
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
            if (this.aBC > this.aBD) {
                j = ((float) this.aBC) * f;
            } else {
                j = ((float) this.aBD) * f;
            }
            float f2 = ((float) (j > this.aBC ? this.aBC : j)) / 1000.0f;
            if (this.aBz > 0) {
                i = this.aBB - ((int) (f2 * (((float) this.aBz) - ((2500.0f * f2) / 2.0f))));
            } else {
                i = this.aBB - ((int) (f2 * (((float) this.aBz) + ((2500.0f * f2) / 2.0f))));
            }
            if (j > this.aBD) {
                j = this.aBD;
            }
            float f3 = ((float) j) / 1000.0f;
            if (this.aBA > 0) {
                i2 = this.Ir - ((int) (f3 * (((float) this.aBA) - ((2500.0f * f3) / 2.0f))));
            } else {
                i2 = this.Ir - ((int) (f3 * (((float) this.aBA) + ((2500.0f * f3) / 2.0f))));
            }
            if (a.this.aAP + a.this.mTop + a.this.mBottom > a.this.getHeight()) {
                if (i2 < (-a.this.aBh)) {
                    i2 = -a.this.aBh;
                }
                if (a.this.getHeight() + i2 > a.this.aAP + a.this.mBottom + a.this.aBi) {
                    i2 = (int) ((a.this.aAP - a.this.getHeight()) + a.this.mBottom + a.this.aBi);
                }
            } else {
                i2 = 0;
            }
            if (a.this.aAO > a.this.getWidth()) {
                int width = ((float) (a.this.getWidth() + i)) > a.this.aAO ? (int) (a.this.aAO - a.this.getWidth()) : i;
                if (width >= 0) {
                    i3 = width;
                }
            }
            a.this.scrollTo(i3, i2);
            a.this.invalidate();
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            if (!this.aBy) {
                if (a.this.aAV) {
                    this.aBx = false;
                    return false;
                }
                try {
                    if (!super.getTransformation(j, transformation)) {
                        this.aBx = false;
                        return false;
                    }
                    return true;
                } catch (Exception e) {
                    this.aBx = false;
                    return false;
                }
            }
            this.aBy = false;
            this.aBx = false;
            return false;
        }

        public boolean FI() {
            return this.aBx;
        }

        public void stopAnimation() {
            this.aBy = true;
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.aAZ = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.alK = onLongClickListener;
    }

    public void setGifSetListener(d dVar) {
        this.alM = dVar;
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
    public void FF() {
        long j;
        c poll = this.aBq.poll();
        if (poll == null) {
            this.aBv = true;
            return;
        }
        this.aBv = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.aBp != null) {
            j = this.aBp.delay - (currentTimeMillis - this.aBu);
            this.aBr.offer(this.aBp);
        } else {
            j = 0;
        }
        this.aBp = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public c FG() {
        c poll = this.aBr.poll();
        if (poll == null) {
            poll = new c(null);
            try {
                poll.aBE = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
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
        public Bitmap aBE;
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
            while (a.this.mState == 1 && a.this.aBf != null && a.this.aBo > 0 && a.this.width > 0 && a.this.height > 0) {
                try {
                    a.this.aBf.G(a.this.aBs);
                    c FG = a.this.FG();
                    if (FG.aBE == null || (FG.aBE.getWidth() != a.this.width && FG.aBE.getHeight() != a.this.height)) {
                        try {
                            FG.aBE = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_8888);
                        } catch (OutOfMemoryError e) {
                            TbadkCoreApplication.m411getInst().onAppMemoryLow();
                            try {
                                FG.aBE = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_4444);
                            } catch (OutOfMemoryError e2) {
                                TbadkCoreApplication.m411getInst().onAppMemoryLow();
                            } catch (Throwable th) {
                                BdLog.e(th.getMessage());
                            }
                        } catch (Throwable th2) {
                            BdLog.e(th2.getMessage());
                        }
                    }
                    a.this.aBf.a(FG.aBE, null);
                    FG.delay = a.this.aBf.H(a.this.aBs);
                    a.this.aBs++;
                    if (FG.aBE == null) {
                        a.this.aBs++;
                    }
                    a.this.aBs %= a.this.aBo;
                    a.this.aBq.put(FG);
                    if (a.this.aBv) {
                        a.this.mHandler.sendEmptyMessage(1);
                    }
                } catch (Exception e3) {
                    return;
                }
            }
        }
    }

    public boolean FH() {
        return this.aBk;
    }

    public void setLoadBigImage(boolean z) {
        this.aBk = z;
    }
}
