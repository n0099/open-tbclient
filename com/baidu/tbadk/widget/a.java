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
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BlockingLinkedDeque;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends ImageView {
    private int VZ;
    private g aeA;
    private int aeB;
    private View.OnLongClickListener aey;
    private float aqO;
    private float aqP;
    private ArrayList<Float> aqQ;
    private float aqR;
    private float aqS;
    private boolean aqT;
    private int aqU;
    private int aqV;
    private h aqW;
    private View.OnClickListener aqX;
    private d aqY;
    private float aqZ;
    private boolean ara;
    private boolean arb;
    private int arc;
    private volatile com.baidu.adp.gif.c ard;
    private Bitmap are;
    private int arf;
    private int arg;
    private int arh;
    private boolean ari;
    private boolean arj;
    private float ark;
    private Interpolator arl;
    private int arm;
    private f arn;
    private BlockingLinkedDeque<f> aro;
    private BlockingLinkedDeque<f> arp;
    private volatile int arq;
    private e arr;
    private volatile long ars;
    private volatile boolean art;
    private int height;
    private int mBottom;
    private float mCurrentScale;
    private GestureDetector mGestureDetector;
    public Handler mHandler;
    private byte[] mImageData;
    private Matrix mMatrix;
    private float mMaxScale;
    private int mMode;
    private Paint mPaint;
    private volatile int mState;
    private int mTop;
    private int mViewHeight;
    private int mViewWidth;
    private int width;

    public void setIsHeadImage(boolean z) {
        this.arj = z;
    }

    public a(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aqT = false;
        this.mImageData = null;
        this.aeB = 0;
        this.aqU = 1300;
        this.aqV = 0;
        this.aqW = null;
        this.aqX = null;
        this.aey = null;
        this.aeA = null;
        this.aqZ = 1.0f;
        this.VZ = 0;
        this.mMode = 0;
        this.ara = false;
        this.arb = false;
        this.arc = 0;
        this.ard = null;
        this.are = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.arf = 0;
        this.arg = 0;
        this.arh = 0;
        this.arl = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.arm = 0;
        this.arn = null;
        this.aro = new BlockingLinkedDeque<>(5);
        this.arp = new BlockingLinkedDeque<>(6);
        this.arq = 0;
        this.ars = 0L;
        this.mState = 0;
        this.art = true;
        this.mHandler = new Handler(new b(this));
        initData();
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aqT = false;
        this.mImageData = null;
        this.aeB = 0;
        this.aqU = 1300;
        this.aqV = 0;
        this.aqW = null;
        this.aqX = null;
        this.aey = null;
        this.aeA = null;
        this.aqZ = 1.0f;
        this.VZ = 0;
        this.mMode = 0;
        this.ara = false;
        this.arb = false;
        this.arc = 0;
        this.ard = null;
        this.are = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.arf = 0;
        this.arg = 0;
        this.arh = 0;
        this.arl = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.arm = 0;
        this.arn = null;
        this.aro = new BlockingLinkedDeque<>(5);
        this.arp = new BlockingLinkedDeque<>(6);
        this.arq = 0;
        this.ars = 0L;
        this.mState = 0;
        this.art = true;
        this.mHandler = new Handler(new b(this));
        initData();
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aqT = false;
        this.mImageData = null;
        this.aeB = 0;
        this.aqU = 1300;
        this.aqV = 0;
        this.aqW = null;
        this.aqX = null;
        this.aey = null;
        this.aeA = null;
        this.aqZ = 1.0f;
        this.VZ = 0;
        this.mMode = 0;
        this.ara = false;
        this.arb = false;
        this.arc = 0;
        this.ard = null;
        this.are = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.arf = 0;
        this.arg = 0;
        this.arh = 0;
        this.arl = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.arm = 0;
        this.arn = null;
        this.aro = new BlockingLinkedDeque<>(5);
        this.arp = new BlockingLinkedDeque<>(6);
        this.arq = 0;
        this.ars = 0L;
        this.mState = 0;
        this.art = true;
        this.mHandler = new Handler(new b(this));
        initData();
    }

    public int getImageType() {
        return this.VZ;
    }

    public void setImageMode(int i) {
        this.aqV = i;
    }

    public void setOffset(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.aeB = i;
    }

    public void actionUp() {
        this.arb = false;
        this.aqT = false;
        this.mMode = 0;
        Ds();
        if (this.mCurrentScale < this.aqR) {
            this.mCurrentScale = this.aqR;
            Dt();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.aqT = true;
                this.ara = false;
                this.arb = false;
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
            this.aqZ = spacing(motionEvent);
            if (this.aqZ > 10.0f) {
                this.mMode = 2;
            }
        }
        if (this.mMode == 2 || !this.mGestureDetector.onTouchEvent(motionEvent)) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.ara = true;
                        this.arb = true;
                        if (this.VZ != 1 && this.VZ != 2) {
                            float spacing = spacing(motionEvent);
                            if (spacing >= 0.0f && Math.abs(this.aqZ - spacing) >= 10.0f) {
                                if (Math.abs(this.aqZ - spacing) > 100.0f) {
                                    this.aqZ = spacing;
                                    break;
                                } else {
                                    float f = spacing / this.aqZ;
                                    this.aqZ = spacing;
                                    this.aqS = this.mCurrentScale;
                                    this.mCurrentScale *= f;
                                    if (this.mCurrentScale > this.mMaxScale) {
                                        this.mCurrentScale = this.mMaxScale;
                                    }
                                    if (this.mCurrentScale < this.aqR / 4.0f) {
                                        this.mCurrentScale = this.aqR / 4.0f;
                                    }
                                    Dt();
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
        return this.aqR == this.mCurrentScale;
    }

    private void reInitBitmap() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            if (this.aqV == 0) {
                float width = this.mViewWidth / imageBitmap.getWidth();
                float height = this.mViewHeight / imageBitmap.getHeight();
                if (this.arj) {
                    if (this.VZ == 2) {
                        this.aqR = 2.5f;
                    } else {
                        this.aqR = Math.min(width, height);
                    }
                } else if (this.VZ == 2) {
                    this.aqR = 1.0f;
                } else {
                    float f = this.ark;
                    float f2 = f >= 1.0f ? f : 1.0f;
                    if (imageBitmap.getWidth() * f2 < this.mViewWidth && imageBitmap.getHeight() * f2 < this.mViewHeight) {
                        this.aqR = f2;
                    } else {
                        this.aqR = Math.min(width, height);
                    }
                }
            } else {
                this.aqR = Math.max(this.mViewWidth / imageBitmap.getWidth(), ((this.mViewHeight - this.mTop) - this.mBottom) / imageBitmap.getHeight());
            }
            this.mMaxScale = this.aqU / (imageBitmap.getWidth() * imageBitmap.getHeight());
            this.mMaxScale = FloatMath.sqrt(this.mMaxScale);
            if (this.mMaxScale > 10.0f) {
                this.mMaxScale = 10.0f;
            }
            this.aqQ.clear();
            this.aqQ.add(Float.valueOf(this.aqR));
            this.mCurrentScale = this.aqR;
            this.aqS = this.mCurrentScale;
            Dt();
            Dr();
            return;
        }
        this.aqO = 0.0f;
        this.aqP = 0.0f;
        this.aqR = 1.0f;
        this.mMaxScale = 1.0f;
        this.mCurrentScale = 1.0f;
        this.aqS = this.mCurrentScale;
        this.aqQ.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    public void Dr() {
        if (this.aqW != null) {
            this.aqW.a(this, canZoomIn(), canZoomOut());
        }
    }

    public void setOnSizeChangedListener(h hVar) {
        this.aqW = hVar;
    }

    public byte[] getImageData() {
        return this.mImageData;
    }

    public void setImageData(byte[] bArr) {
        this.mImageData = bArr;
    }

    public Bitmap getGifCache() {
        return this.are;
    }

    public void setGifCache(Bitmap bitmap) {
        this.are = bitmap;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        boolean z;
        int i4;
        if (this.VZ == 2 && this.arh != 0 && !this.aqY.Dx()) {
            int width = getWidth();
            int height = getHeight();
            Drawable drawable = getDrawable();
            float f = 0.0f;
            float f2 = height * 0.3f;
            float f3 = width;
            float f4 = (1.0f - 0.3f) * height;
            if (this.arj && drawable != null) {
                Rect bounds = drawable.getBounds();
                int i5 = bounds.right - bounds.left;
                int i6 = bounds.bottom - bounds.top;
                f = (width / 2) - (i5 * 2.5f);
                f2 = (height / 2) - (i6 * 2.5f);
                f3 = (i5 * 2.5f) + (width / 2);
                f4 = (i6 * 2.5f) + (height / 2);
            }
            this.mPaint.setColor(ba.getColor(this.arh));
            canvas.drawRect(f, f2, f3, f4, this.mPaint);
            this.mPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        }
        super.onDraw(canvas);
        if (this.VZ == 1 && this.are != null && !this.are.isRecycled()) {
            int width2 = this.are.getWidth();
            int height2 = this.are.getHeight();
            int width3 = getWidth();
            int height3 = getHeight();
            int i7 = (width3 - width2) >> 1;
            int i8 = (height3 - height2) >> 1;
            float f5 = this.ark;
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
            if (this.arc == 1 && this.ard != null && this.arn != null && this.arn.arB != null) {
                if (z) {
                    canvas.drawBitmap(this.arn.arB, i3, i2, (Paint) null);
                } else {
                    canvas.drawBitmap(this.arn.arB, this.mMatrix, this.mPaint);
                }
                invalidate();
            } else if (z) {
                canvas.drawBitmap(this.are, i3, i2, (Paint) null);
            } else {
                canvas.drawBitmap(this.are, this.mMatrix, this.mPaint);
            }
        }
    }

    public void play() {
        com.baidu.adp.widget.a.a d;
        if (this.VZ == 1) {
            if (this.ard == null) {
                if (this.arr != null) {
                    this.arr.interrupt();
                    this.arr = null;
                }
                if (this.mImageData != null && (d = com.baidu.adp.gif.b.ff().d(this.mImageData, 0, this.mImageData.length)) != null && d.getGif() != null) {
                    this.ard = d.getGif();
                    if (this.ard != null) {
                        this.arc = 1;
                        this.width = this.ard.getWidth();
                        this.height = this.ard.getHeight();
                        this.arq = 0;
                        this.arm = this.ard.fg();
                    } else {
                        this.arc = 0;
                    }
                } else {
                    return;
                }
            }
            if (this.ard != null && this.mState == 0) {
                this.art = true;
                this.arr = new e(this, null);
                this.aro.clear();
                this.arp.clear();
                this.mState = 1;
                this.arr.start();
            }
        }
    }

    public void pause() {
        if (this.VZ == 1) {
            this.mState = 0;
            if (this.arr != null) {
                this.arr.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.VZ == 1) {
            this.mState = 0;
            if (this.arr != null) {
                this.arr.interrupt();
                this.arr = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.art = true;
            this.arn = null;
            this.arp.clear();
            this.aro.clear();
            this.width = 0;
            this.height = 0;
            this.arq = 0;
            this.arm = 0;
            if (this.ard != null) {
                this.ard = null;
            }
        }
    }

    private void initData() {
        this.ark = com.baidu.adp.lib.util.n.O(getContext());
        this.aqU = com.baidu.adp.lib.util.n.N(getContext()) * com.baidu.adp.lib.util.n.M(getContext()) * 2;
        if (this.aqU < 1690000) {
            this.aqU = 1690000;
        }
        this.aqO = 0.0f;
        this.aqP = 0.0f;
        this.aqQ = new ArrayList<>();
        this.aqR = 1.0f;
        this.mMaxScale = 1.0f;
        this.mCurrentScale = 1.0f;
        this.aqS = this.mCurrentScale;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.aqY = new d(this);
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWillNotDraw(false);
        scrollTo(0, 0);
        this.mGestureDetector = new GestureDetector(getContext(), new c(this));
    }

    private void Ds() {
        int i = 0;
        int scrollX = getScrollX();
        if (this.aqO >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.aqO) {
                scrollX = (int) (this.aqO - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.aqP + this.mTop + this.mBottom >= getHeight()) {
            i = scrollY < (-this.arf) ? -this.arf : scrollY;
            if (getHeight() + i > this.aqP + this.mBottom + this.arg) {
                i = (int) ((this.aqP - getHeight()) + this.mBottom + this.arg);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.aqO;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.aqP;
    }

    public boolean onRightSide() {
        if (this.VZ == 1 || this.VZ == 2) {
            return true;
        }
        return !this.arb && getScrollX() >= ((int) (this.aqO - ((float) getWidth()))) + (-1);
    }

    public boolean onLeftSide() {
        if (this.VZ == 1 || this.VZ == 2) {
            return true;
        }
        return !this.arb && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.aqY.Dx()) {
            this.aqY.stopAnimation();
        }
        this.arh = 0;
        super.setImageBitmap(bitmap);
        reInitBitmap();
        this.VZ = 0;
    }

    public void replaceImageBitmap(Bitmap bitmap) {
        Bitmap imageBitmap = getImageBitmap();
        if (bitmap != null && !bitmap.isRecycled()) {
            if (imageBitmap != null && (imageBitmap.getWidth() != bitmap.getWidth() || imageBitmap.getHeight() != bitmap.getHeight())) {
                setImageBitmap(bitmap);
                return;
            }
            if (this.aqY.Dx()) {
                this.aqY.stopAnimation();
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            super.setImageBitmap(bitmap);
            super.setImageMatrix(this.mMatrix);
            scrollTo(scrollX, scrollY);
            this.VZ = 0;
        }
    }

    public void a(byte[] bArr, Bitmap bitmap) {
        if (this.aqY.Dx()) {
            this.aqY.stopAnimation();
        }
        super.setImageDrawable(null);
        stop();
        reInitBitmap();
        this.VZ = 1;
        this.are = bitmap;
        this.mImageData = bArr;
        if (this.aeA != null) {
            this.aeA.a(this);
        }
    }

    public void onDestroy() {
        if (this.aqY.Dx()) {
            this.aqY.stopAnimation();
        }
        super.setImageDrawable(null);
        this.mImageData = null;
        this.are = null;
        stop();
        if (this.ard != null) {
            this.ard.close();
            this.ard = null;
        }
    }

    public void release() {
        if (this.aqY.Dx()) {
            this.aqY.stopAnimation();
        }
        stop();
        super.setImageDrawable(null);
        this.are = null;
    }

    public void setDefaultBitmap() {
        if (this.aqY.Dx()) {
            this.aqY.stopAnimation();
        }
        if (this.arj) {
            super.setImageBitmap(com.baidu.tbadk.core.util.c.bO(u.icon_default_avatar100));
        } else {
            super.setImageBitmap(com.baidu.tbadk.core.util.c.bO(u.btn_see_default));
        }
        this.VZ = 2;
        reInitBitmap();
    }

    public void zoomInBitmap() {
        if (this.VZ != 1 && this.VZ != 2) {
            int size = this.aqQ.size();
            if (size > 0) {
                this.aqQ.add(Float.valueOf(this.aqQ.get(size - 1).floatValue() * 1.25f));
            } else {
                this.aqQ.add(Float.valueOf(this.aqR));
            }
            Dt();
            Dr();
        }
    }

    public void zoomOutBitmap() {
        if (this.VZ != 1 && this.VZ != 2) {
            int size = this.aqQ.size();
            if (size > 1) {
                this.aqQ.remove(size - 1);
            }
            Dt();
            Dr();
        }
    }

    public void restoreSize() {
        Dr();
        if (this.VZ != 1 && this.VZ != 2 && this.mCurrentScale != this.aqR) {
            this.aqQ.clear();
            this.aqQ.add(Float.valueOf(this.aqR));
            this.mCurrentScale = this.aqR;
            this.aqS = this.mCurrentScale;
            Dt();
        }
    }

    public boolean canZoomIn() {
        if (this.VZ == 1 || this.VZ == 2) {
            return false;
        }
        int size = this.aqQ.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.aqQ.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.aqU) && floatValue <= 5.0f;
    }

    public boolean canZoomOut() {
        if (this.VZ == 1 || this.VZ == 2) {
            return false;
        }
        int size = this.aqQ.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled()) {
            return false;
        }
        return size > 1;
    }

    public void Dt() {
        e(false, -1, -1);
    }

    public void e(boolean z, int i, int i2) {
        float f;
        float f2;
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled()) {
            try {
                if (this.mMode != 2) {
                    int size = this.aqQ.size();
                    if (size > 0) {
                        f2 = this.aqQ.get(size - 1).floatValue();
                    } else {
                        f2 = this.aqR;
                    }
                    this.mCurrentScale = f2;
                }
                this.mMatrix.setScale(this.mCurrentScale, this.mCurrentScale);
                this.aqO = imageBitmap.getWidth() * this.mCurrentScale;
                this.aqP = imageBitmap.getHeight() * this.mCurrentScale;
                float width = this.aqS * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.aqS;
                this.arf = this.mTop;
                this.arg = 0;
                float f3 = this.aqO < ((float) this.mViewWidth) ? (int) ((this.mViewWidth - this.aqO) / 2.0f) : 0.0f;
                if (this.aqP < this.mViewHeight) {
                    f = (int) ((this.mViewHeight - this.aqP) / 2.0f);
                    if (this.aqV == 1 && f > this.mTop) {
                        f = this.mTop;
                    }
                    this.arf = (int) (this.mTop - f);
                    this.arg = this.mTop - this.arf;
                } else {
                    f = 0.0f;
                }
                this.mMatrix.postTranslate(f3, f);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    scrollX = i > getWidth() ? getWidth() : i;
                    if (this.aqO <= screenWidth) {
                        scrollX = 0;
                    } else if (this.aqO > screenWidth && this.aqO / 2.0f < screenWidth) {
                        scrollX = (int) (scrollX - (this.aqO / 4.0f));
                    }
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.aqO - width) / 2.0f);
                    }
                    if (this.aqO <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.aqO) {
                        scrollX = (int) (this.aqO - getWidth());
                    }
                }
                if (scrollX > 0 && this.aqO - scrollX < getWidth()) {
                    scrollX = (int) (this.aqO - getWidth());
                }
                if (this.mMode == 2) {
                    scrollY += (int) ((this.aqP - height) / 2.0f);
                }
                if (this.aqP <= getHeight()) {
                    scrollY = 0;
                } else if (getHeight() + scrollY > this.aqP) {
                    scrollY = (int) (this.aqP - getHeight());
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
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.aqX = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aey = onLongClickListener;
    }

    public void setGifSetListener(g gVar) {
        this.aeA = gVar;
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

    public void Du() {
        long j;
        f poll = this.aro.poll();
        if (poll == null) {
            this.art = true;
            return;
        }
        this.art = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.arn != null) {
            j = this.arn.delay - (currentTimeMillis - this.ars);
            this.arp.offer(this.arn);
        } else {
            j = 0;
        }
        this.arn = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public f Dv() {
        f poll = this.arp.poll();
        if (poll == null) {
            f fVar = new f(null);
            fVar.arB = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
            return fVar;
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

    public boolean Dw() {
        return this.ari;
    }

    public void setLoadBigImage(boolean z) {
        this.ari = z;
    }
}
