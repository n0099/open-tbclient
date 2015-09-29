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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends ImageView {
    private volatile com.baidu.adp.gif.b aAa;
    private Bitmap aAb;
    private int aAc;
    private int aAd;
    private int aAe;
    private boolean aAf;
    private boolean aAg;
    private float aAh;
    private Interpolator aAi;
    private int aAj;
    private c aAk;
    private BlockingLinkedDeque<c> aAl;
    private BlockingLinkedDeque<c> aAm;
    private volatile int aAn;
    private b aAo;
    private volatile long aAp;
    private volatile boolean aAq;
    private int abN;
    private View.OnLongClickListener ajT;
    private d ajV;
    private int ajW;
    private float azJ;
    private float azK;
    private ArrayList<Float> azL;
    private float azM;
    private float azN;
    private float azO;
    private float azP;
    private boolean azQ;
    private int azR;
    private int azS;
    private e azT;
    private View.OnClickListener azU;
    private C0054a azV;
    private float azW;
    private boolean azX;
    private boolean azY;
    private int azZ;
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
        this.aAg = z;
    }

    public a(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.azQ = false;
        this.mImageData = null;
        this.ajW = 0;
        this.azR = 1300;
        this.azS = 0;
        this.azT = null;
        this.azU = null;
        this.ajT = null;
        this.ajV = null;
        this.azW = 1.0f;
        this.abN = 0;
        this.mMode = 0;
        this.azX = false;
        this.azY = false;
        this.azZ = 0;
        this.aAa = null;
        this.aAb = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aAc = 0;
        this.aAd = 0;
        this.aAe = 0;
        this.aAi = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aAj = 0;
        this.aAk = null;
        this.aAl = new BlockingLinkedDeque<>(5);
        this.aAm = new BlockingLinkedDeque<>(6);
        this.aAn = 0;
        this.aAp = 0L;
        this.mState = 0;
        this.aAq = true;
        this.mHandler = new Handler(new com.baidu.tbadk.widget.b(this));
        initData();
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.azQ = false;
        this.mImageData = null;
        this.ajW = 0;
        this.azR = 1300;
        this.azS = 0;
        this.azT = null;
        this.azU = null;
        this.ajT = null;
        this.ajV = null;
        this.azW = 1.0f;
        this.abN = 0;
        this.mMode = 0;
        this.azX = false;
        this.azY = false;
        this.azZ = 0;
        this.aAa = null;
        this.aAb = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aAc = 0;
        this.aAd = 0;
        this.aAe = 0;
        this.aAi = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aAj = 0;
        this.aAk = null;
        this.aAl = new BlockingLinkedDeque<>(5);
        this.aAm = new BlockingLinkedDeque<>(6);
        this.aAn = 0;
        this.aAp = 0L;
        this.mState = 0;
        this.aAq = true;
        this.mHandler = new Handler(new com.baidu.tbadk.widget.b(this));
        initData();
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.azQ = false;
        this.mImageData = null;
        this.ajW = 0;
        this.azR = 1300;
        this.azS = 0;
        this.azT = null;
        this.azU = null;
        this.ajT = null;
        this.ajV = null;
        this.azW = 1.0f;
        this.abN = 0;
        this.mMode = 0;
        this.azX = false;
        this.azY = false;
        this.azZ = 0;
        this.aAa = null;
        this.aAb = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aAc = 0;
        this.aAd = 0;
        this.aAe = 0;
        this.aAi = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aAj = 0;
        this.aAk = null;
        this.aAl = new BlockingLinkedDeque<>(5);
        this.aAm = new BlockingLinkedDeque<>(6);
        this.aAn = 0;
        this.aAp = 0L;
        this.mState = 0;
        this.aAq = true;
        this.mHandler = new Handler(new com.baidu.tbadk.widget.b(this));
        initData();
    }

    public int getImageType() {
        return this.abN;
    }

    public void setImageMode(int i) {
        this.azS = i;
    }

    public void setOffset(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.ajW = i;
    }

    public void actionUp() {
        this.azY = false;
        this.azQ = false;
        this.mMode = 0;
        EL();
        if (this.azO < this.azM) {
            this.azO = this.azM;
            EM();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.azQ = true;
                this.azX = false;
                this.azY = false;
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
            this.azW = spacing(motionEvent);
            if (this.azW > 10.0f) {
                this.mMode = 2;
            }
        }
        if (this.mMode == 2 || !this.mGestureDetector.onTouchEvent(motionEvent)) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.azX = true;
                        this.azY = true;
                        if (this.abN != 1 && this.abN != 2) {
                            float spacing = spacing(motionEvent);
                            if (spacing >= 0.0f && Math.abs(this.azW - spacing) >= 10.0f) {
                                if (Math.abs(this.azW - spacing) > 100.0f) {
                                    this.azW = spacing;
                                    break;
                                } else {
                                    float f = spacing / this.azW;
                                    this.azW = spacing;
                                    this.azP = this.azO;
                                    this.azO *= f;
                                    if (this.azO > this.azN) {
                                        this.azO = this.azN;
                                    }
                                    if (this.azO < this.azM / 4.0f) {
                                        this.azO = this.azM / 4.0f;
                                    }
                                    EM();
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
        return this.azM == this.azO;
    }

    private void reInitBitmap() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            if (this.azS == 0) {
                float width = this.mViewWidth / imageBitmap.getWidth();
                float height = this.mViewHeight / imageBitmap.getHeight();
                if (this.aAg) {
                    if (this.abN == 2) {
                        this.azM = 2.5f;
                    } else {
                        this.azM = Math.min(width, height);
                    }
                } else if (this.abN == 2) {
                    this.azM = 1.0f;
                } else {
                    float f = this.aAh;
                    float f2 = f >= 1.0f ? f : 1.0f;
                    if (imageBitmap.getWidth() * f2 < this.mViewWidth && imageBitmap.getHeight() * f2 < this.mViewHeight) {
                        this.azM = f2;
                    } else {
                        this.azM = Math.min(width, height);
                    }
                }
            } else {
                this.azM = Math.max(this.mViewWidth / imageBitmap.getWidth(), ((this.mViewHeight - this.mTop) - this.mBottom) / imageBitmap.getHeight());
            }
            this.azN = this.azR / (imageBitmap.getWidth() * imageBitmap.getHeight());
            this.azN = FloatMath.sqrt(this.azN);
            if (this.azN > 10.0f) {
                this.azN = 10.0f;
            }
            this.azL.clear();
            this.azL.add(Float.valueOf(this.azM));
            this.azO = this.azM;
            this.azP = this.azO;
            EM();
            EK();
            return;
        }
        this.azJ = 0.0f;
        this.azK = 0.0f;
        this.azM = 1.0f;
        this.azN = 1.0f;
        this.azO = 1.0f;
        this.azP = this.azO;
        this.azL.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EK() {
        if (this.azT != null) {
            this.azT.a(this, canZoomIn(), canZoomOut());
        }
    }

    public void setOnSizeChangedListener(e eVar) {
        this.azT = eVar;
    }

    public byte[] getImageData() {
        return this.mImageData;
    }

    public void setImageData(byte[] bArr) {
        this.mImageData = bArr;
    }

    public Bitmap getGifCache() {
        return this.aAb;
    }

    public void setGifCache(Bitmap bitmap) {
        this.aAb = bitmap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        boolean z;
        int i4;
        if (this.abN == 2 && this.aAe != 0 && !this.azV.EQ()) {
            int width = getWidth();
            int height = getHeight();
            Drawable drawable = getDrawable();
            float f = 0.0f;
            float f2 = height * 0.3f;
            float f3 = width;
            float f4 = (1.0f - 0.3f) * height;
            if (this.aAg && drawable != null) {
                Rect bounds = drawable.getBounds();
                int i5 = bounds.right - bounds.left;
                int i6 = bounds.bottom - bounds.top;
                f = (width / 2) - (i5 * 2.5f);
                f2 = (height / 2) - (i6 * 2.5f);
                f3 = (i5 * 2.5f) + (width / 2);
                f4 = (i6 * 2.5f) + (height / 2);
            }
            this.mPaint.setColor(am.getColor(this.aAe));
            canvas.drawRect(f, f2, f3, f4, this.mPaint);
            this.mPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        }
        super.onDraw(canvas);
        if (this.abN == 1 && this.aAb != null && !this.aAb.isRecycled()) {
            int width2 = this.aAb.getWidth();
            int height2 = this.aAb.getHeight();
            int width3 = getWidth();
            int height3 = getHeight();
            int i7 = (width3 - width2) >> 1;
            int i8 = (height3 - height2) >> 1;
            float f5 = this.aAh;
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
            if (this.azZ == 1 && this.aAa != null && this.aAk != null && this.aAk.aAz != null) {
                if (z) {
                    canvas.drawBitmap(this.aAk.aAz, i3, i2, (Paint) null);
                } else {
                    canvas.drawBitmap(this.aAk.aAz, this.mMatrix, this.mPaint);
                }
                invalidate();
            } else if (z) {
                canvas.drawBitmap(this.aAb, i3, i2, (Paint) null);
            } else {
                canvas.drawBitmap(this.aAb, this.mMatrix, this.mPaint);
            }
        }
    }

    public void play() {
        com.baidu.adp.widget.a.a e2;
        if (this.abN == 1) {
            if (this.aAa == null) {
                if (this.aAo != null) {
                    this.aAo.interrupt();
                    this.aAo = null;
                }
                if (this.mImageData != null && (e2 = a.C0002a.fe().e(this.mImageData, 0, this.mImageData.length)) != null && e2.getGif() != null) {
                    this.aAa = e2.getGif();
                    if (this.aAa != null) {
                        this.azZ = 1;
                        this.width = this.aAa.getWidth();
                        this.height = this.aAa.getHeight();
                        this.aAn = 0;
                        this.aAj = this.aAa.ff();
                    } else {
                        this.azZ = 0;
                    }
                } else {
                    return;
                }
            }
            if (this.aAa != null && this.mState == 0) {
                this.aAq = true;
                this.aAo = new b(this, null);
                this.aAl.clear();
                this.aAm.clear();
                this.mState = 1;
                this.aAo.start();
            }
        }
    }

    public void pause() {
        if (this.abN == 1) {
            this.mState = 0;
            if (this.aAo != null) {
                this.aAo.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.abN == 1) {
            this.mState = 0;
            if (this.aAo != null) {
                this.aAo.interrupt();
                this.aAo = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.aAq = true;
            this.aAk = null;
            this.aAm.clear();
            this.aAl.clear();
            this.width = 0;
            this.height = 0;
            this.aAn = 0;
            this.aAj = 0;
            if (this.aAa != null) {
                this.aAa = null;
            }
        }
    }

    private void initData() {
        this.aAh = k.M(getContext());
        this.azR = k.L(getContext()) * k.K(getContext()) * 2;
        if (this.azR < 1690000) {
            this.azR = 1690000;
        }
        this.azJ = 0.0f;
        this.azK = 0.0f;
        this.azL = new ArrayList<>();
        this.azM = 1.0f;
        this.azN = 1.0f;
        this.azO = 1.0f;
        this.azP = this.azO;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.azV = new C0054a();
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWillNotDraw(false);
        scrollTo(0, 0);
        this.mGestureDetector = new GestureDetector(getContext(), new com.baidu.tbadk.widget.c(this));
    }

    private void EL() {
        int i = 0;
        int scrollX = getScrollX();
        if (this.azJ >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.azJ) {
                scrollX = (int) (this.azJ - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.azK + this.mTop + this.mBottom >= getHeight()) {
            i = scrollY < (-this.aAc) ? -this.aAc : scrollY;
            if (getHeight() + i > this.azK + this.mBottom + this.aAd) {
                i = (int) ((this.azK - getHeight()) + this.mBottom + this.aAd);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.azJ;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.azK;
    }

    public boolean onRightSide() {
        if (this.abN == 1 || this.abN == 2) {
            return true;
        }
        return !this.azY && getScrollX() >= ((int) (this.azJ - ((float) getWidth()))) + (-1);
    }

    public boolean onLeftSide() {
        if (this.abN == 1 || this.abN == 2) {
            return true;
        }
        return !this.azY && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.azV.EQ()) {
            this.azV.stopAnimation();
        }
        this.aAe = 0;
        super.setImageBitmap(bitmap);
        reInitBitmap();
        this.abN = 0;
    }

    public void replaceImageBitmap(Bitmap bitmap) {
        Bitmap imageBitmap = getImageBitmap();
        if (bitmap != null && !bitmap.isRecycled()) {
            if (imageBitmap != null && (imageBitmap.getWidth() != bitmap.getWidth() || imageBitmap.getHeight() != bitmap.getHeight())) {
                setImageBitmap(bitmap);
                return;
            }
            if (this.azV.EQ()) {
                this.azV.stopAnimation();
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            super.setImageBitmap(bitmap);
            super.setImageMatrix(this.mMatrix);
            scrollTo(scrollX, scrollY);
            this.abN = 0;
        }
    }

    public void a(byte[] bArr, Bitmap bitmap) {
        if (this.azV.EQ()) {
            this.azV.stopAnimation();
        }
        super.setImageDrawable(null);
        stop();
        reInitBitmap();
        this.abN = 1;
        this.aAb = bitmap;
        this.mImageData = bArr;
        if (this.ajV != null) {
            this.ajV.a(this);
        }
    }

    public void onDestroy() {
        if (this.azV.EQ()) {
            this.azV.stopAnimation();
        }
        super.setImageDrawable(null);
        this.mImageData = null;
        this.aAb = null;
        stop();
        if (this.aAa != null) {
            this.aAa.close();
            this.aAa = null;
        }
    }

    public void release() {
        if (this.azV.EQ()) {
            this.azV.stopAnimation();
        }
        stop();
        super.setImageDrawable(null);
        this.aAb = null;
    }

    public void setDefaultBitmap() {
        if (this.azV.EQ()) {
            this.azV.stopAnimation();
        }
        if (this.aAg) {
            super.setImageBitmap(com.baidu.tbadk.core.util.c.cf(i.e.icon_default_avatar100));
        } else {
            super.setImageBitmap(com.baidu.tbadk.core.util.c.cf(i.e.btn_see_default));
        }
        this.abN = 2;
        reInitBitmap();
    }

    public void zoomInBitmap() {
        if (this.abN != 1 && this.abN != 2) {
            int size = this.azL.size();
            if (size > 0) {
                this.azL.add(Float.valueOf(this.azL.get(size - 1).floatValue() * 1.25f));
            } else {
                this.azL.add(Float.valueOf(this.azM));
            }
            EM();
            EK();
        }
    }

    public void zoomOutBitmap() {
        if (this.abN != 1 && this.abN != 2) {
            int size = this.azL.size();
            if (size > 1) {
                this.azL.remove(size - 1);
            }
            EM();
            EK();
        }
    }

    public void restoreSize() {
        EK();
        if (this.abN != 1 && this.abN != 2 && this.azO != this.azM) {
            this.azL.clear();
            this.azL.add(Float.valueOf(this.azM));
            this.azO = this.azM;
            this.azP = this.azO;
            EM();
        }
    }

    public boolean canZoomIn() {
        if (this.abN == 1 || this.abN == 2) {
            return false;
        }
        int size = this.azL.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.azL.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.azR) && floatValue <= 5.0f;
    }

    public boolean canZoomOut() {
        if (this.abN == 1 || this.abN == 2) {
            return false;
        }
        int size = this.azL.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled()) {
            return false;
        }
        return size > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EM() {
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
                    int size = this.azL.size();
                    if (size > 0) {
                        f2 = this.azL.get(size - 1).floatValue();
                    } else {
                        f2 = this.azM;
                    }
                    this.azO = f2;
                }
                this.mMatrix.setScale(this.azO, this.azO);
                this.azJ = imageBitmap.getWidth() * this.azO;
                this.azK = imageBitmap.getHeight() * this.azO;
                float width = this.azP * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.azP;
                this.aAc = this.mTop;
                this.aAd = 0;
                float f3 = this.azJ < ((float) this.mViewWidth) ? (int) ((this.mViewWidth - this.azJ) / 2.0f) : 0.0f;
                if (this.azK < this.mViewHeight) {
                    f = (int) ((this.mViewHeight - this.azK) / 2.0f);
                    if (this.azS == 1 && f > this.mTop) {
                        f = this.mTop;
                    }
                    this.aAc = (int) (this.mTop - f);
                    this.aAd = this.mTop - this.aAc;
                } else {
                    f = 0.0f;
                }
                this.mMatrix.postTranslate(f3, f);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    scrollX = i > getWidth() ? getWidth() : i;
                    if (this.azJ <= screenWidth) {
                        scrollX = 0;
                    } else if (this.azJ > screenWidth && this.azJ / 2.0f < screenWidth) {
                        scrollX = (int) (scrollX - (this.azJ / 4.0f));
                    }
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.azJ - width) / 2.0f);
                    }
                    if (this.azJ <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.azJ) {
                        scrollX = (int) (this.azJ - getWidth());
                    }
                }
                if (scrollX > 0 && this.azJ - scrollX < getWidth()) {
                    scrollX = (int) (this.azJ - getWidth());
                }
                if (this.mMode == 2) {
                    scrollY += (int) ((this.azK - height) / 2.0f);
                }
                if (this.azK <= getHeight()) {
                    scrollY = 0;
                } else if (getHeight() + scrollY > this.azK) {
                    scrollY = (int) (this.azK - getHeight());
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
        private boolean aAs = false;
        private boolean aAt = false;
        private long aAu;
        private long aAv;
        private int aAw;
        private long aAx;
        private long aAy;

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
            this.aAu = f;
            this.aAv = f2;
            this.aAx = Math.abs((f * 1000.0f) / 2500.0f);
            this.aAy = Math.abs((f2 * 1000.0f) / 2500.0f);
            setDuration(Math.max(this.aAx, this.aAy));
            setInterpolator(a.this.aAi);
            this.aAw = a.this.getScrollX();
            this.HY = a.this.getScrollY();
            this.aAs = true;
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
            if (this.aAx > this.aAy) {
                j = ((float) this.aAx) * f;
            } else {
                j = ((float) this.aAy) * f;
            }
            float f2 = ((float) (j > this.aAx ? this.aAx : j)) / 1000.0f;
            if (this.aAu > 0) {
                i = this.aAw - ((int) (f2 * (((float) this.aAu) - ((2500.0f * f2) / 2.0f))));
            } else {
                i = this.aAw - ((int) (f2 * (((float) this.aAu) + ((2500.0f * f2) / 2.0f))));
            }
            if (j > this.aAy) {
                j = this.aAy;
            }
            float f3 = ((float) j) / 1000.0f;
            if (this.aAv > 0) {
                i2 = this.HY - ((int) (f3 * (((float) this.aAv) - ((2500.0f * f3) / 2.0f))));
            } else {
                i2 = this.HY - ((int) (f3 * (((float) this.aAv) + ((2500.0f * f3) / 2.0f))));
            }
            if (a.this.azK + a.this.mTop + a.this.mBottom > a.this.getHeight()) {
                if (i2 < (-a.this.aAc)) {
                    i2 = -a.this.aAc;
                }
                if (a.this.getHeight() + i2 > a.this.azK + a.this.mBottom + a.this.aAd) {
                    i2 = (int) ((a.this.azK - a.this.getHeight()) + a.this.mBottom + a.this.aAd);
                }
            } else {
                i2 = 0;
            }
            if (a.this.azJ > a.this.getWidth()) {
                int width = ((float) (a.this.getWidth() + i)) > a.this.azJ ? (int) (a.this.azJ - a.this.getWidth()) : i;
                if (width >= 0) {
                    i3 = width;
                }
            }
            a.this.scrollTo(i3, i2);
            a.this.invalidate();
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            if (!this.aAt) {
                if (a.this.azQ) {
                    this.aAs = false;
                    return false;
                }
                try {
                    if (!super.getTransformation(j, transformation)) {
                        this.aAs = false;
                        return false;
                    }
                    return true;
                } catch (Exception e) {
                    this.aAs = false;
                    return false;
                }
            }
            this.aAt = false;
            this.aAs = false;
            return false;
        }

        public boolean EQ() {
            return this.aAs;
        }

        public void stopAnimation() {
            this.aAt = true;
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.azU = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.ajT = onLongClickListener;
    }

    public void setGifSetListener(d dVar) {
        this.ajV = dVar;
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
    public void EN() {
        long j;
        c poll = this.aAl.poll();
        if (poll == null) {
            this.aAq = true;
            return;
        }
        this.aAq = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.aAk != null) {
            j = this.aAk.delay - (currentTimeMillis - this.aAp);
            this.aAm.offer(this.aAk);
        } else {
            j = 0;
        }
        this.aAk = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public c EO() {
        c poll = this.aAm.poll();
        if (poll == null) {
            poll = new c(null);
            try {
                poll.aAz = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
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
        public Bitmap aAz;
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
            while (a.this.mState == 1 && a.this.aAa != null && a.this.aAj > 0 && a.this.width > 0 && a.this.height > 0) {
                try {
                    a.this.aAa.F(a.this.aAn);
                    c EO = a.this.EO();
                    if (EO.aAz == null || (EO.aAz.getWidth() != a.this.width && EO.aAz.getHeight() != a.this.height)) {
                        try {
                            EO.aAz = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_8888);
                        } catch (OutOfMemoryError e) {
                            TbadkCoreApplication.m411getInst().onAppMemoryLow();
                            try {
                                EO.aAz = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_4444);
                            } catch (OutOfMemoryError e2) {
                                TbadkCoreApplication.m411getInst().onAppMemoryLow();
                            } catch (Throwable th) {
                                BdLog.e(th.getMessage());
                            }
                        } catch (Throwable th2) {
                            BdLog.e(th2.getMessage());
                        }
                    }
                    a.this.aAa.a(EO.aAz, null);
                    EO.delay = a.this.aAa.G(a.this.aAn);
                    a.this.aAn++;
                    if (EO.aAz == null) {
                        a.this.aAn++;
                    }
                    a.this.aAn %= a.this.aAj;
                    a.this.aAl.put(EO);
                    if (a.this.aAq) {
                        a.this.mHandler.sendEmptyMessage(1);
                    }
                } catch (Exception e3) {
                    return;
                }
            }
        }
    }

    public boolean EP() {
        return this.aAf;
    }

    public void setLoadBigImage(boolean z) {
        this.aAf = z;
    }
}
