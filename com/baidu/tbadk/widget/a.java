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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends ImageView {
    private BlockingLinkedDeque<c> aAa;
    private volatile int aAb;
    private b aAc;
    private volatile long aAd;
    private volatile boolean aAe;
    private int abG;
    private View.OnLongClickListener akJ;
    private d akL;
    private int akM;
    private float azA;
    private float azB;
    private float azC;
    private float azD;
    private boolean azE;
    private int azF;
    private int azG;
    private e azH;
    private View.OnClickListener azI;
    private C0054a azJ;
    private float azK;
    private boolean azL;
    private boolean azM;
    private int azN;
    private volatile com.baidu.adp.gif.b azO;
    private Bitmap azP;
    private int azQ;
    private int azR;
    private int azS;
    private boolean azT;
    private boolean azU;
    private float azV;
    private Interpolator azW;
    private int azX;
    private c azY;
    private BlockingLinkedDeque<c> azZ;
    private float azx;
    private float azy;
    private ArrayList<Float> azz;
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
        this.azU = z;
    }

    public a(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.azE = false;
        this.mImageData = null;
        this.akM = 0;
        this.azF = 1300;
        this.azG = 0;
        this.azH = null;
        this.azI = null;
        this.akJ = null;
        this.akL = null;
        this.azK = 1.0f;
        this.abG = 0;
        this.mMode = 0;
        this.azL = false;
        this.azM = false;
        this.azN = 0;
        this.azO = null;
        this.azP = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.azQ = 0;
        this.azR = 0;
        this.azS = 0;
        this.azW = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.azX = 0;
        this.azY = null;
        this.azZ = new BlockingLinkedDeque<>(5);
        this.aAa = new BlockingLinkedDeque<>(6);
        this.aAb = 0;
        this.aAd = 0L;
        this.mState = 0;
        this.aAe = true;
        this.mHandler = new Handler(new com.baidu.tbadk.widget.b(this));
        initData();
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.azE = false;
        this.mImageData = null;
        this.akM = 0;
        this.azF = 1300;
        this.azG = 0;
        this.azH = null;
        this.azI = null;
        this.akJ = null;
        this.akL = null;
        this.azK = 1.0f;
        this.abG = 0;
        this.mMode = 0;
        this.azL = false;
        this.azM = false;
        this.azN = 0;
        this.azO = null;
        this.azP = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.azQ = 0;
        this.azR = 0;
        this.azS = 0;
        this.azW = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.azX = 0;
        this.azY = null;
        this.azZ = new BlockingLinkedDeque<>(5);
        this.aAa = new BlockingLinkedDeque<>(6);
        this.aAb = 0;
        this.aAd = 0L;
        this.mState = 0;
        this.aAe = true;
        this.mHandler = new Handler(new com.baidu.tbadk.widget.b(this));
        initData();
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.azE = false;
        this.mImageData = null;
        this.akM = 0;
        this.azF = 1300;
        this.azG = 0;
        this.azH = null;
        this.azI = null;
        this.akJ = null;
        this.akL = null;
        this.azK = 1.0f;
        this.abG = 0;
        this.mMode = 0;
        this.azL = false;
        this.azM = false;
        this.azN = 0;
        this.azO = null;
        this.azP = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.azQ = 0;
        this.azR = 0;
        this.azS = 0;
        this.azW = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.azX = 0;
        this.azY = null;
        this.azZ = new BlockingLinkedDeque<>(5);
        this.aAa = new BlockingLinkedDeque<>(6);
        this.aAb = 0;
        this.aAd = 0L;
        this.mState = 0;
        this.aAe = true;
        this.mHandler = new Handler(new com.baidu.tbadk.widget.b(this));
        initData();
    }

    public int getImageType() {
        return this.abG;
    }

    public void setImageMode(int i) {
        this.azG = i;
    }

    public void setOffset(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.akM = i;
    }

    public void actionUp() {
        this.azM = false;
        this.azE = false;
        this.mMode = 0;
        EM();
        if (this.azC < this.azA) {
            this.azC = this.azA;
            EN();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.azE = true;
                this.azL = false;
                this.azM = false;
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
            this.azK = spacing(motionEvent);
            if (this.azK > 10.0f) {
                this.mMode = 2;
            }
        }
        if (this.mMode == 2 || !this.mGestureDetector.onTouchEvent(motionEvent)) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.azL = true;
                        this.azM = true;
                        if (this.abG != 1 && this.abG != 2) {
                            float spacing = spacing(motionEvent);
                            if (spacing >= 0.0f && Math.abs(this.azK - spacing) >= 10.0f) {
                                if (Math.abs(this.azK - spacing) > 100.0f) {
                                    this.azK = spacing;
                                    break;
                                } else {
                                    float f = spacing / this.azK;
                                    this.azK = spacing;
                                    this.azD = this.azC;
                                    this.azC *= f;
                                    if (this.azC > this.azB) {
                                        this.azC = this.azB;
                                    }
                                    if (this.azC < this.azA / 4.0f) {
                                        this.azC = this.azA / 4.0f;
                                    }
                                    EN();
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
        return this.azA == this.azC;
    }

    private void reInitBitmap() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            if (this.azG == 0) {
                float width = this.mViewWidth / imageBitmap.getWidth();
                float height = this.mViewHeight / imageBitmap.getHeight();
                if (this.azU) {
                    if (this.abG == 2) {
                        this.azA = 2.5f;
                    } else {
                        this.azA = Math.min(width, height);
                    }
                } else if (this.abG == 2) {
                    this.azA = 1.0f;
                } else {
                    float f = this.azV;
                    float f2 = f >= 1.0f ? f : 1.0f;
                    if (imageBitmap.getWidth() * f2 < this.mViewWidth && imageBitmap.getHeight() * f2 < this.mViewHeight) {
                        this.azA = f2;
                    } else {
                        this.azA = Math.min(width, height);
                    }
                }
            } else {
                this.azA = Math.max(this.mViewWidth / imageBitmap.getWidth(), ((this.mViewHeight - this.mTop) - this.mBottom) / imageBitmap.getHeight());
            }
            this.azB = this.azF / (imageBitmap.getWidth() * imageBitmap.getHeight());
            this.azB = FloatMath.sqrt(this.azB);
            if (this.azB > 10.0f) {
                this.azB = 10.0f;
            }
            this.azz.clear();
            this.azz.add(Float.valueOf(this.azA));
            this.azC = this.azA;
            this.azD = this.azC;
            EN();
            EL();
            return;
        }
        this.azx = 0.0f;
        this.azy = 0.0f;
        this.azA = 1.0f;
        this.azB = 1.0f;
        this.azC = 1.0f;
        this.azD = this.azC;
        this.azz.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EL() {
        if (this.azH != null) {
            this.azH.a(this, canZoomIn(), canZoomOut());
        }
    }

    public void setOnSizeChangedListener(e eVar) {
        this.azH = eVar;
    }

    public byte[] getImageData() {
        return this.mImageData;
    }

    public void setImageData(byte[] bArr) {
        this.mImageData = bArr;
    }

    public Bitmap getGifCache() {
        return this.azP;
    }

    public void setGifCache(Bitmap bitmap) {
        this.azP = bitmap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        boolean z;
        int i4;
        if (this.abG == 2 && this.azS != 0 && !this.azJ.ER()) {
            int width = getWidth();
            int height = getHeight();
            Drawable drawable = getDrawable();
            float f = 0.0f;
            float f2 = height * 0.3f;
            float f3 = width;
            float f4 = (1.0f - 0.3f) * height;
            if (this.azU && drawable != null) {
                Rect bounds = drawable.getBounds();
                int i5 = bounds.right - bounds.left;
                int i6 = bounds.bottom - bounds.top;
                f = (width / 2) - (i5 * 2.5f);
                f2 = (height / 2) - (i6 * 2.5f);
                f3 = (i5 * 2.5f) + (width / 2);
                f4 = (i6 * 2.5f) + (height / 2);
            }
            this.mPaint.setColor(al.getColor(this.azS));
            canvas.drawRect(f, f2, f3, f4, this.mPaint);
            this.mPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        }
        super.onDraw(canvas);
        if (this.abG == 1 && this.azP != null && !this.azP.isRecycled()) {
            int width2 = this.azP.getWidth();
            int height2 = this.azP.getHeight();
            int width3 = getWidth();
            int height3 = getHeight();
            int i7 = (width3 - width2) >> 1;
            int i8 = (height3 - height2) >> 1;
            float f5 = this.azV;
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
            if (this.azN == 1 && this.azO != null && this.azY != null && this.azY.aAn != null) {
                if (z) {
                    canvas.drawBitmap(this.azY.aAn, i3, i2, (Paint) null);
                } else {
                    canvas.drawBitmap(this.azY.aAn, this.mMatrix, this.mPaint);
                }
                invalidate();
            } else if (z) {
                canvas.drawBitmap(this.azP, i3, i2, (Paint) null);
            } else {
                canvas.drawBitmap(this.azP, this.mMatrix, this.mPaint);
            }
        }
    }

    public void play() {
        com.baidu.adp.widget.a.a e2;
        if (this.abG == 1) {
            if (this.azO == null) {
                if (this.aAc != null) {
                    this.aAc.interrupt();
                    this.aAc = null;
                }
                if (this.mImageData != null && (e2 = a.C0002a.fh().e(this.mImageData, 0, this.mImageData.length)) != null && e2.getGif() != null) {
                    this.azO = e2.getGif();
                    if (this.azO != null) {
                        this.azN = 1;
                        this.width = this.azO.getWidth();
                        this.height = this.azO.getHeight();
                        this.aAb = 0;
                        this.azX = this.azO.fi();
                    } else {
                        this.azN = 0;
                    }
                } else {
                    return;
                }
            }
            if (this.azO != null && this.mState == 0) {
                this.aAe = true;
                this.aAc = new b(this, null);
                this.azZ.clear();
                this.aAa.clear();
                this.mState = 1;
                this.aAc.start();
            }
        }
    }

    public void pause() {
        if (this.abG == 1) {
            this.mState = 0;
            if (this.aAc != null) {
                this.aAc.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.abG == 1) {
            this.mState = 0;
            if (this.aAc != null) {
                this.aAc.interrupt();
                this.aAc = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.aAe = true;
            this.azY = null;
            this.aAa.clear();
            this.azZ.clear();
            this.width = 0;
            this.height = 0;
            this.aAb = 0;
            this.azX = 0;
            if (this.azO != null) {
                this.azO = null;
            }
        }
    }

    private void initData() {
        this.azV = k.M(getContext());
        this.azF = k.L(getContext()) * k.K(getContext()) * 2;
        if (this.azF < 1690000) {
            this.azF = 1690000;
        }
        this.azx = 0.0f;
        this.azy = 0.0f;
        this.azz = new ArrayList<>();
        this.azA = 1.0f;
        this.azB = 1.0f;
        this.azC = 1.0f;
        this.azD = this.azC;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.azJ = new C0054a();
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWillNotDraw(false);
        scrollTo(0, 0);
        this.mGestureDetector = new GestureDetector(getContext(), new com.baidu.tbadk.widget.c(this));
    }

    private void EM() {
        int i = 0;
        int scrollX = getScrollX();
        if (this.azx >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.azx) {
                scrollX = (int) (this.azx - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.azy + this.mTop + this.mBottom >= getHeight()) {
            i = scrollY < (-this.azQ) ? -this.azQ : scrollY;
            if (getHeight() + i > this.azy + this.mBottom + this.azR) {
                i = (int) ((this.azy - getHeight()) + this.mBottom + this.azR);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.azx;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.azy;
    }

    public boolean onRightSide() {
        if (this.abG == 1 || this.abG == 2) {
            return true;
        }
        return !this.azM && getScrollX() >= ((int) (this.azx - ((float) getWidth()))) + (-1);
    }

    public boolean onLeftSide() {
        if (this.abG == 1 || this.abG == 2) {
            return true;
        }
        return !this.azM && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.azJ.ER()) {
            this.azJ.ES();
        }
        this.azS = 0;
        super.setImageBitmap(bitmap);
        reInitBitmap();
        this.abG = 0;
    }

    public void replaceImageBitmap(Bitmap bitmap) {
        Bitmap imageBitmap = getImageBitmap();
        if (bitmap != null && !bitmap.isRecycled()) {
            if (imageBitmap != null && (imageBitmap.getWidth() != bitmap.getWidth() || imageBitmap.getHeight() != bitmap.getHeight())) {
                setImageBitmap(bitmap);
                return;
            }
            if (this.azJ.ER()) {
                this.azJ.ES();
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            super.setImageBitmap(bitmap);
            super.setImageMatrix(this.mMatrix);
            scrollTo(scrollX, scrollY);
            this.abG = 0;
        }
    }

    public void a(byte[] bArr, Bitmap bitmap) {
        if (this.azJ.ER()) {
            this.azJ.ES();
        }
        super.setImageDrawable(null);
        stop();
        reInitBitmap();
        this.abG = 1;
        this.azP = bitmap;
        this.mImageData = bArr;
        if (this.akL != null) {
            this.akL.a(this);
        }
    }

    public void onDestroy() {
        if (this.azJ.ER()) {
            this.azJ.ES();
        }
        super.setImageDrawable(null);
        this.mImageData = null;
        this.azP = null;
        stop();
        if (this.azO != null) {
            this.azO.close();
            this.azO = null;
        }
    }

    public void release() {
        if (this.azJ.ER()) {
            this.azJ.ES();
        }
        stop();
        super.setImageDrawable(null);
        this.azP = null;
    }

    public void setDefaultBitmap() {
        if (this.azJ.ER()) {
            this.azJ.ES();
        }
        if (this.azU) {
            super.setImageBitmap(com.baidu.tbadk.core.util.c.bZ(i.e.icon_default_avatar100));
        } else {
            super.setImageBitmap(com.baidu.tbadk.core.util.c.bZ(i.e.btn_see_default));
        }
        this.abG = 2;
        reInitBitmap();
    }

    public void zoomInBitmap() {
        if (this.abG != 1 && this.abG != 2) {
            int size = this.azz.size();
            if (size > 0) {
                this.azz.add(Float.valueOf(this.azz.get(size - 1).floatValue() * 1.25f));
            } else {
                this.azz.add(Float.valueOf(this.azA));
            }
            EN();
            EL();
        }
    }

    public void zoomOutBitmap() {
        if (this.abG != 1 && this.abG != 2) {
            int size = this.azz.size();
            if (size > 1) {
                this.azz.remove(size - 1);
            }
            EN();
            EL();
        }
    }

    public void restoreSize() {
        EL();
        if (this.abG != 1 && this.abG != 2 && this.azC != this.azA) {
            this.azz.clear();
            this.azz.add(Float.valueOf(this.azA));
            this.azC = this.azA;
            this.azD = this.azC;
            EN();
        }
    }

    public boolean canZoomIn() {
        if (this.abG == 1 || this.abG == 2) {
            return false;
        }
        int size = this.azz.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.azz.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.azF) && floatValue <= 5.0f;
    }

    public boolean canZoomOut() {
        if (this.abG == 1 || this.abG == 2) {
            return false;
        }
        int size = this.azz.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled()) {
            return false;
        }
        return size > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EN() {
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
                    int size = this.azz.size();
                    if (size > 0) {
                        f2 = this.azz.get(size - 1).floatValue();
                    } else {
                        f2 = this.azA;
                    }
                    this.azC = f2;
                }
                this.mMatrix.setScale(this.azC, this.azC);
                this.azx = imageBitmap.getWidth() * this.azC;
                this.azy = imageBitmap.getHeight() * this.azC;
                float width = this.azD * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.azD;
                this.azQ = this.mTop;
                this.azR = 0;
                float f3 = this.azx < ((float) this.mViewWidth) ? (int) ((this.mViewWidth - this.azx) / 2.0f) : 0.0f;
                if (this.azy < this.mViewHeight) {
                    f = (int) ((this.mViewHeight - this.azy) / 2.0f);
                    if (this.azG == 1 && f > this.mTop) {
                        f = this.mTop;
                    }
                    this.azQ = (int) (this.mTop - f);
                    this.azR = this.mTop - this.azQ;
                } else {
                    f = 0.0f;
                }
                this.mMatrix.postTranslate(f3, f);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    scrollX = i > getWidth() ? getWidth() : i;
                    if (this.azx <= screenWidth) {
                        scrollX = 0;
                    } else if (this.azx > screenWidth && this.azx / 2.0f < screenWidth) {
                        scrollX = (int) (scrollX - (this.azx / 4.0f));
                    }
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.azx - width) / 2.0f);
                    }
                    if (this.azx <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.azx) {
                        scrollX = (int) (this.azx - getWidth());
                    }
                }
                if (scrollX > 0 && this.azx - scrollX < getWidth()) {
                    scrollX = (int) (this.azx - getWidth());
                }
                if (this.mMode == 2) {
                    scrollY += (int) ((this.azy - height) / 2.0f);
                }
                if (this.azy <= getHeight()) {
                    scrollY = 0;
                } else if (getHeight() + scrollY > this.azy) {
                    scrollY = (int) (this.azy - getHeight());
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
    public class C0054a extends Animation {
        private int HY;
        private boolean aAg = false;
        private boolean aAh = false;
        private long aAi;
        private long aAj;
        private int aAk;
        private long aAl;
        private long aAm;

        public C0054a() {
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
            this.aAi = f;
            this.aAj = f2;
            this.aAl = Math.abs((f * 1000.0f) / 2500.0f);
            this.aAm = Math.abs((f2 * 1000.0f) / 2500.0f);
            setDuration(Math.max(this.aAl, this.aAm));
            setInterpolator(a.this.azW);
            this.aAk = a.this.getScrollX();
            this.HY = a.this.getScrollY();
            this.aAg = true;
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
            if (this.aAl > this.aAm) {
                j = ((float) this.aAl) * f;
            } else {
                j = ((float) this.aAm) * f;
            }
            float f2 = ((float) (j > this.aAl ? this.aAl : j)) / 1000.0f;
            if (this.aAi > 0) {
                i = this.aAk - ((int) (f2 * (((float) this.aAi) - ((2500.0f * f2) / 2.0f))));
            } else {
                i = this.aAk - ((int) (f2 * (((float) this.aAi) + ((2500.0f * f2) / 2.0f))));
            }
            if (j > this.aAm) {
                j = this.aAm;
            }
            float f3 = ((float) j) / 1000.0f;
            if (this.aAj > 0) {
                i2 = this.HY - ((int) (f3 * (((float) this.aAj) - ((2500.0f * f3) / 2.0f))));
            } else {
                i2 = this.HY - ((int) (f3 * (((float) this.aAj) + ((2500.0f * f3) / 2.0f))));
            }
            if (a.this.azy + a.this.mTop + a.this.mBottom > a.this.getHeight()) {
                if (i2 < (-a.this.azQ)) {
                    i2 = -a.this.azQ;
                }
                if (a.this.getHeight() + i2 > a.this.azy + a.this.mBottom + a.this.azR) {
                    i2 = (int) ((a.this.azy - a.this.getHeight()) + a.this.mBottom + a.this.azR);
                }
            } else {
                i2 = 0;
            }
            if (a.this.azx > a.this.getWidth()) {
                int width = ((float) (a.this.getWidth() + i)) > a.this.azx ? (int) (a.this.azx - a.this.getWidth()) : i;
                if (width >= 0) {
                    i3 = width;
                }
            }
            a.this.scrollTo(i3, i2);
            a.this.invalidate();
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            if (!this.aAh) {
                if (a.this.azE) {
                    this.aAg = false;
                    return false;
                }
                try {
                    if (!super.getTransformation(j, transformation)) {
                        this.aAg = false;
                        return false;
                    }
                    return true;
                } catch (Exception e) {
                    this.aAg = false;
                    return false;
                }
            }
            this.aAh = false;
            this.aAg = false;
            return false;
        }

        public boolean ER() {
            return this.aAg;
        }

        public void ES() {
            this.aAh = true;
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.azI = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.akJ = onLongClickListener;
    }

    public void setGifSetListener(d dVar) {
        this.akL = dVar;
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
    public void EO() {
        long j;
        c poll = this.azZ.poll();
        if (poll == null) {
            this.aAe = true;
            return;
        }
        this.aAe = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.azY != null) {
            j = this.azY.delay - (currentTimeMillis - this.aAd);
            this.aAa.offer(this.azY);
        } else {
            j = 0;
        }
        this.azY = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public c EP() {
        c poll = this.aAa.poll();
        if (poll == null) {
            c cVar = new c(null);
            cVar.aAn = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
            return cVar;
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
        public Bitmap aAn;
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
            while (a.this.mState == 1 && a.this.azO != null && a.this.azX > 0 && a.this.width > 0 && a.this.height > 0) {
                try {
                    a.this.azO.F(a.this.aAb);
                    c EP = a.this.EP();
                    if (EP.aAn == null || (EP.aAn.getWidth() != a.this.width && EP.aAn.getHeight() != a.this.height)) {
                        EP.aAn = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_8888);
                    }
                    a.this.azO.a(EP.aAn, null);
                    EP.delay = a.this.azO.G(a.this.aAb);
                    a.this.aAb++;
                    if (EP.aAn == null) {
                        a.this.aAb++;
                    }
                    a.this.aAb %= a.this.azX;
                    a.this.azZ.put(EP);
                    if (a.this.aAe) {
                        a.this.mHandler.sendEmptyMessage(1);
                    }
                } catch (Exception e) {
                    return;
                }
            }
        }
    }

    public boolean EQ() {
        return this.azT;
    }

    public void setLoadBigImage(boolean z) {
        this.azT = z;
    }
}
