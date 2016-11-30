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
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends ImageView {
    private float aFA;
    private float aFB;
    private float aFC;
    private boolean aFD;
    private int aFE;
    private int aFF;
    private e aFG;
    private View.OnClickListener aFH;
    private C0049a aFI;
    private float aFJ;
    private boolean aFK;
    private boolean aFL;
    private int aFM;
    private volatile com.baidu.adp.gif.b aFN;
    private Bitmap aFO;
    private int aFP;
    private int aFQ;
    private int aFR;
    private int aFS;
    private boolean aFT;
    private boolean aFU;
    private float aFV;
    private Interpolator aFW;
    private int aFX;
    private c aFY;
    private BlockingLinkedDeque<c> aFZ;
    private float aFw;
    private float aFx;
    private ArrayList<Float> aFy;
    private float aFz;
    private BlockingLinkedDeque<c> aGa;
    private volatile int aGb;
    private b aGc;
    private volatile long aGd;
    private volatile boolean aGe;
    private int ada;
    private View.OnLongClickListener aoS;
    private d aoU;
    private int aoV;
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
        this.aFU = z;
    }

    public a(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aFD = false;
        this.mImageData = null;
        this.aoV = 0;
        this.aFE = 1300;
        this.aFF = 0;
        this.aFG = null;
        this.aFH = null;
        this.aoS = null;
        this.aoU = null;
        this.aFJ = 1.0f;
        this.ada = 0;
        this.mMode = 0;
        this.aFK = false;
        this.aFL = false;
        this.aFM = 0;
        this.aFN = null;
        this.aFO = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aFP = 0;
        this.aFQ = 0;
        this.aFR = 0;
        this.aFS = 0;
        this.aFW = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aFX = 0;
        this.aFY = null;
        this.aFZ = new BlockingLinkedDeque<>(5);
        this.aGa = new BlockingLinkedDeque<>(6);
        this.aGb = 0;
        this.aGd = 0L;
        this.mState = 0;
        this.aGe = true;
        this.mHandler = new Handler(new com.baidu.tbadk.widget.b(this));
        initData();
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aFD = false;
        this.mImageData = null;
        this.aoV = 0;
        this.aFE = 1300;
        this.aFF = 0;
        this.aFG = null;
        this.aFH = null;
        this.aoS = null;
        this.aoU = null;
        this.aFJ = 1.0f;
        this.ada = 0;
        this.mMode = 0;
        this.aFK = false;
        this.aFL = false;
        this.aFM = 0;
        this.aFN = null;
        this.aFO = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aFP = 0;
        this.aFQ = 0;
        this.aFR = 0;
        this.aFS = 0;
        this.aFW = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aFX = 0;
        this.aFY = null;
        this.aFZ = new BlockingLinkedDeque<>(5);
        this.aGa = new BlockingLinkedDeque<>(6);
        this.aGb = 0;
        this.aGd = 0L;
        this.mState = 0;
        this.aGe = true;
        this.mHandler = new Handler(new com.baidu.tbadk.widget.b(this));
        initData();
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aFD = false;
        this.mImageData = null;
        this.aoV = 0;
        this.aFE = 1300;
        this.aFF = 0;
        this.aFG = null;
        this.aFH = null;
        this.aoS = null;
        this.aoU = null;
        this.aFJ = 1.0f;
        this.ada = 0;
        this.mMode = 0;
        this.aFK = false;
        this.aFL = false;
        this.aFM = 0;
        this.aFN = null;
        this.aFO = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aFP = 0;
        this.aFQ = 0;
        this.aFR = 0;
        this.aFS = 0;
        this.aFW = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aFX = 0;
        this.aFY = null;
        this.aFZ = new BlockingLinkedDeque<>(5);
        this.aGa = new BlockingLinkedDeque<>(6);
        this.aGb = 0;
        this.aGd = 0L;
        this.mState = 0;
        this.aGe = true;
        this.mHandler = new Handler(new com.baidu.tbadk.widget.b(this));
        initData();
    }

    public int getImageType() {
        return this.ada;
    }

    public void setImageMode(int i) {
        this.aFF = i;
    }

    public void h(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.aoV = i;
    }

    public void Ho() {
        this.aFL = false;
        this.aFD = false;
        this.mMode = 0;
        Hs();
        if (this.aFB < this.aFz) {
            this.aFB = this.aFz;
            Hz();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.aFD = true;
                this.aFK = false;
                this.aFL = false;
                break;
            case 1:
                Ho();
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
            this.aFJ = j(motionEvent);
            if (this.aFJ > 10.0f) {
                this.mMode = 2;
            }
        }
        if (this.mMode == 2 || !this.mGestureDetector.onTouchEvent(motionEvent)) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.aFK = true;
                        this.aFL = true;
                        if (this.ada != 1 && this.ada != 2) {
                            float j = j(motionEvent);
                            if (j >= 0.0f && Math.abs(this.aFJ - j) >= 10.0f) {
                                if (Math.abs(this.aFJ - j) > 100.0f) {
                                    this.aFJ = j;
                                    break;
                                } else {
                                    float f = j / this.aFJ;
                                    this.aFJ = j;
                                    this.aFC = this.aFB;
                                    this.aFB *= f;
                                    if (this.aFB > this.aFA) {
                                        this.aFB = this.aFA;
                                    }
                                    if (this.aFB < this.aFz / 4.0f) {
                                        this.aFB = this.aFz / 4.0f;
                                    }
                                    Hz();
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

    public float j(MotionEvent motionEvent) {
        return CompatibleUtile.getInstance().getSpacing(motionEvent);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            this.mViewWidth = i3 - i;
            this.mViewHeight = i4 - i2;
            Hq();
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public boolean Hp() {
        return this.aFz == this.aFB;
    }

    private void Hq() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            if (this.aFF == 0) {
                float width = this.mViewWidth / imageBitmap.getWidth();
                float height = this.mViewHeight / imageBitmap.getHeight();
                if (this.aFU) {
                    if (this.ada == 2) {
                        this.aFz = 2.5f;
                    } else {
                        this.aFz = Math.min(width, height);
                    }
                } else if (this.ada == 2) {
                    this.aFz = 1.0f;
                } else {
                    float f = this.aFV;
                    float f2 = f >= 1.0f ? f : 1.0f;
                    if (imageBitmap.getWidth() * f2 < this.mViewWidth && imageBitmap.getHeight() * f2 < this.mViewHeight) {
                        this.aFz = f2;
                    } else {
                        this.aFz = Math.min(width, height);
                    }
                }
            } else {
                this.aFz = Math.max(this.mViewWidth / imageBitmap.getWidth(), ((this.mViewHeight - this.mTop) - this.mBottom) / imageBitmap.getHeight());
            }
            this.aFA = this.aFE / (imageBitmap.getWidth() * imageBitmap.getHeight());
            this.aFA = FloatMath.sqrt(this.aFA);
            if (this.aFA > 10.0f) {
                this.aFA = 10.0f;
            }
            this.aFy.clear();
            this.aFy.add(Float.valueOf(this.aFz));
            this.aFB = this.aFz;
            this.aFC = this.aFB;
            Hz();
            return;
        }
        this.aFw = 0.0f;
        this.aFx = 0.0f;
        this.aFz = 1.0f;
        this.aFA = 1.0f;
        this.aFB = 1.0f;
        this.aFC = this.aFB;
        this.aFy.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    private void Hr() {
        if (this.aFG != null) {
            this.aFG.a(this, canZoomIn(), canZoomOut());
        }
    }

    public void setOnSizeChangedListener(e eVar) {
        this.aFG = eVar;
    }

    public byte[] getImageData() {
        return this.mImageData;
    }

    public void setImageData(byte[] bArr) {
        this.mImageData = bArr;
    }

    public Bitmap getGifCache() {
        return this.aFO;
    }

    public void setGifCache(Bitmap bitmap) {
        this.aFO = bitmap;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        boolean z;
        int i4;
        if (this.ada == 2 && this.aFS != 0 && !this.aFI.HD()) {
            int width = getWidth();
            int height = getHeight();
            Drawable drawable = getDrawable();
            float f = 0.0f;
            float f2 = height * 0.3f;
            float f3 = width;
            float f4 = (1.0f - 0.3f) * height;
            if (this.aFU && drawable != null) {
                Rect bounds = drawable.getBounds();
                int i5 = bounds.right - bounds.left;
                int i6 = bounds.bottom - bounds.top;
                f = (width / 2) - (i5 * 2.5f);
                f2 = (height / 2) - (i6 * 2.5f);
                f3 = (i5 * 2.5f) + (width / 2);
                f4 = (i6 * 2.5f) + (height / 2);
            }
            this.mPaint.setColor(at.getColor(this.aFS));
            canvas.drawRect(f, f2, f3, f4, this.mPaint);
            this.mPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        }
        super.onDraw(canvas);
        if (this.ada == 1 && this.aFO != null && !this.aFO.isRecycled()) {
            int width2 = this.aFO.getWidth();
            int height2 = this.aFO.getHeight();
            int width3 = getWidth();
            int height3 = getHeight();
            int i7 = (width3 - width2) >> 1;
            int i8 = (height3 - height2) >> 1;
            float f5 = this.aFV;
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
            if (this.aFM == 1 && this.aFN != null && this.aFY != null && this.aFY.aGn != null) {
                if (z) {
                    canvas.drawBitmap(this.aFY.aGn, i3, i2, (Paint) null);
                } else {
                    canvas.drawBitmap(this.aFY.aGn, this.mMatrix, this.mPaint);
                }
                invalidate();
            } else if (z) {
                canvas.drawBitmap(this.aFO, i3, i2, (Paint) null);
            } else {
                canvas.drawBitmap(this.aFO, this.mMatrix, this.mPaint);
            }
        }
    }

    public void play() {
        com.baidu.adp.widget.a.a aVar;
        if (this.ada == 1) {
            if (this.aFN == null) {
                if (this.aGc != null) {
                    this.aGc.interrupt();
                    this.aGc = null;
                }
                if (this.mImageData != null) {
                    try {
                        aVar = a.C0004a.cw().e(this.mImageData, 0, this.mImageData.length);
                    } catch (StackOverflowError e2) {
                        aVar = null;
                    }
                    if (aVar != null && aVar.getGif() != null) {
                        this.aFN = aVar.getGif();
                        if (this.aFN != null) {
                            this.aFM = 1;
                            this.width = this.aFN.getWidth();
                            this.height = this.aFN.getHeight();
                            this.aGb = 0;
                            this.aFX = this.aFN.cx();
                        } else {
                            this.aFM = 0;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            if (this.aFN != null && this.mState == 0) {
                this.aGe = true;
                this.aGc = new b(this, null);
                this.aFZ.clear();
                this.aGa.clear();
                this.mState = 1;
                this.aGc.start();
            }
        }
    }

    public void pause() {
        if (this.ada == 1) {
            this.mState = 0;
            if (this.aGc != null) {
                this.aGc.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.ada == 1) {
            this.mState = 0;
            if (this.aGc != null) {
                this.aGc.interrupt();
                this.aGc = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.aGe = true;
            this.aFY = null;
            this.aGa.clear();
            this.aFZ.clear();
            this.width = 0;
            this.height = 0;
            this.aGb = 0;
            this.aFX = 0;
            if (this.aFN != null) {
                this.aFN = null;
            }
        }
    }

    private void initData() {
        this.aFV = k.M(getContext());
        this.aFE = k.L(getContext()) * k.K(getContext()) * 2;
        if (this.aFE < 1690000) {
            this.aFE = 1690000;
        }
        this.aFw = 0.0f;
        this.aFx = 0.0f;
        this.aFy = new ArrayList<>();
        this.aFz = 1.0f;
        this.aFA = 1.0f;
        this.aFB = 1.0f;
        this.aFC = this.aFB;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.aFI = new C0049a();
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWillNotDraw(false);
        scrollTo(0, 0);
        this.mGestureDetector = new GestureDetector(getContext(), new com.baidu.tbadk.widget.c(this));
    }

    private void Hs() {
        int i = 0;
        int scrollX = getScrollX();
        if (this.aFw >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.aFw) {
                scrollX = (int) (this.aFw - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.aFx + this.mTop + this.mBottom >= getHeight()) {
            i = scrollY < (-this.aFP) ? -this.aFP : scrollY;
            if (getHeight() + i > this.aFx + this.mBottom + this.aFQ) {
                i = (int) ((this.aFx - getHeight()) + this.mBottom + this.aFQ);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.aFw;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.aFx;
    }

    public boolean Ht() {
        if (this.ada == 1 || this.ada == 2) {
            return true;
        }
        return !this.aFL && getScrollX() >= ((int) (this.aFw - ((float) getWidth()))) + (-1);
    }

    public boolean Hu() {
        if (this.ada == 1 || this.ada == 2) {
            return true;
        }
        return !this.aFL && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.aFI.HD()) {
            this.aFI.stopAnimation();
        }
        this.aFS = 0;
        super.setImageBitmap(bitmap);
        Hq();
        this.ada = 0;
    }

    public void j(Bitmap bitmap) {
        Bitmap imageBitmap = getImageBitmap();
        if (bitmap != null && !bitmap.isRecycled()) {
            if (imageBitmap != null && (imageBitmap.getWidth() != bitmap.getWidth() || imageBitmap.getHeight() != bitmap.getHeight())) {
                setImageBitmap(bitmap);
                return;
            }
            if (this.aFI.HD()) {
                this.aFI.stopAnimation();
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            super.setImageBitmap(bitmap);
            super.setImageMatrix(this.mMatrix);
            scrollTo(scrollX, scrollY);
            this.ada = 0;
        }
    }

    public void a(byte[] bArr, Bitmap bitmap) {
        if (this.aFI.HD()) {
            this.aFI.stopAnimation();
        }
        super.setImageDrawable(null);
        stop();
        Hq();
        this.ada = 1;
        this.aFO = bitmap;
        this.mImageData = bArr;
        if (this.aoU != null) {
            this.aoU.a(this);
        }
    }

    public void onDestroy() {
        if (this.aFI.HD()) {
            this.aFI.stopAnimation();
        }
        super.setImageDrawable(null);
        this.mImageData = null;
        this.aFO = null;
        stop();
        if (this.aFN != null) {
            this.aFN.close();
            this.aFN = null;
        }
    }

    public void release() {
        if (this.aFI.HD()) {
            this.aFI.stopAnimation();
        }
        stop();
        super.setImageDrawable(null);
        this.aFO = null;
    }

    public void Hv() {
        if (this.aFI.HD()) {
            this.aFI.stopAnimation();
        }
        if (this.aFU) {
            super.setImageBitmap(BitmapHelper.getCashBitmap(r.f.icon_default_avatar100));
        } else {
            super.setImageBitmap(BitmapHelper.getCashBitmap(r.f.btn_see_default));
        }
        this.ada = 2;
        Hq();
    }

    public void Hw() {
        if (this.ada != 1 && this.ada != 2) {
            int size = this.aFy.size();
            if (size > 0) {
                this.aFy.add(Float.valueOf(this.aFy.get(size - 1).floatValue() * 1.25f));
            } else {
                this.aFy.add(Float.valueOf(this.aFz));
            }
            Hz();
        }
    }

    public void Hx() {
        if (this.ada != 1 && this.ada != 2) {
            int size = this.aFy.size();
            if (size > 1) {
                this.aFy.remove(size - 1);
            }
            Hz();
        }
    }

    public void Hy() {
        Hr();
        if (this.ada != 1 && this.ada != 2 && this.aFB != this.aFz) {
            this.aFy.clear();
            this.aFy.add(Float.valueOf(this.aFz));
            this.aFB = this.aFz;
            this.aFC = this.aFB;
            Hz();
        }
    }

    public boolean canZoomIn() {
        if (this.ada == 1 || this.ada == 2) {
            return false;
        }
        int size = this.aFy.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.aFy.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.aFE) && floatValue <= 5.0f;
    }

    public boolean canZoomOut() {
        if (this.ada == 1 || this.ada == 2) {
            return false;
        }
        int size = this.aFy.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled()) {
            return false;
        }
        return size > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hz() {
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
                    int size = this.aFy.size();
                    if (size > 0) {
                        f2 = this.aFy.get(size - 1).floatValue();
                    } else {
                        f2 = this.aFz;
                    }
                    this.aFB = f2;
                }
                this.mMatrix.setScale(this.aFB, this.aFB);
                this.aFw = imageBitmap.getWidth() * this.aFB;
                this.aFx = imageBitmap.getHeight() * this.aFB;
                float width = this.aFC * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.aFC;
                this.aFP = this.mTop;
                this.aFQ = 0;
                float f3 = this.aFw < ((float) this.mViewWidth) ? (int) ((this.mViewWidth - this.aFw) / 2.0f) : 0.0f;
                if (this.aFx < this.mViewHeight) {
                    f = (int) ((this.mViewHeight - this.aFx) / 2.0f);
                    if (this.aFF == 1 && f > this.mTop) {
                        f = this.mTop;
                    }
                    this.aFP = (int) (this.mTop - f);
                    this.aFQ = this.mTop - this.aFP;
                } else {
                    f = 0.0f;
                }
                this.aFR = (int) f3;
                this.mMatrix.postTranslate(f3, f);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    scrollX = i > getWidth() ? getWidth() : i;
                    if (this.aFw <= screenWidth) {
                        scrollX = 0;
                    } else if (this.aFw > screenWidth && this.aFw / 2.0f < screenWidth) {
                        scrollX = (int) (scrollX - (this.aFw / 4.0f));
                    }
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.aFw - width) / 2.0f);
                    }
                    if (this.aFw <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.aFw) {
                        scrollX = (int) (this.aFw - getWidth());
                    }
                }
                if (scrollX > 0 && this.aFw - scrollX < getWidth()) {
                    scrollX = (int) (this.aFw - getWidth());
                }
                if (this.mMode == 2) {
                    scrollY += (int) ((this.aFx - height) / 2.0f);
                }
                if (this.aFx <= getHeight()) {
                    scrollY = 0;
                } else if (getHeight() + scrollY > this.aFx) {
                    scrollY = (int) (this.aFx - getHeight());
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
                Hr();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0049a extends Animation {
        private int Ci;
        private boolean aGg = false;
        private boolean aGh = false;
        private long aGi;
        private long aGj;
        private int aGk;
        private long aGl;
        private long aGm;

        public C0049a() {
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
            this.aGi = f;
            this.aGj = f2;
            this.aGl = Math.abs((f * 1000.0f) / 2500.0f);
            this.aGm = Math.abs((f2 * 1000.0f) / 2500.0f);
            setDuration(Math.max(this.aGl, this.aGm));
            setInterpolator(a.this.aFW);
            this.aGk = a.this.getScrollX();
            this.Ci = a.this.getScrollY();
            this.aGg = true;
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
            if (this.aGl > this.aGm) {
                j = ((float) this.aGl) * f;
            } else {
                j = ((float) this.aGm) * f;
            }
            float f2 = ((float) (j > this.aGl ? this.aGl : j)) / 1000.0f;
            if (this.aGi > 0) {
                i = this.aGk - ((int) (f2 * (((float) this.aGi) - ((2500.0f * f2) / 2.0f))));
            } else {
                i = this.aGk - ((int) (f2 * (((float) this.aGi) + ((2500.0f * f2) / 2.0f))));
            }
            if (j > this.aGm) {
                j = this.aGm;
            }
            float f3 = ((float) j) / 1000.0f;
            if (this.aGj > 0) {
                i2 = this.Ci - ((int) (f3 * (((float) this.aGj) - ((2500.0f * f3) / 2.0f))));
            } else {
                i2 = this.Ci - ((int) (f3 * (((float) this.aGj) + ((2500.0f * f3) / 2.0f))));
            }
            if (a.this.aFx + a.this.mTop + a.this.mBottom > a.this.getHeight()) {
                if (i2 < (-a.this.aFP)) {
                    i2 = -a.this.aFP;
                }
                if (a.this.getHeight() + i2 > a.this.aFx + a.this.mBottom + a.this.aFQ) {
                    i2 = (int) ((a.this.aFx - a.this.getHeight()) + a.this.mBottom + a.this.aFQ);
                }
            } else {
                i2 = 0;
            }
            if (a.this.aFw > a.this.getWidth()) {
                int width = ((float) (a.this.getWidth() + i)) > a.this.aFw ? (int) (a.this.aFw - a.this.getWidth()) : i;
                if (width >= 0) {
                    i3 = width;
                }
            }
            a.this.scrollTo(i3, i2);
            a.this.invalidate();
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            if (!this.aGh) {
                if (a.this.aFD) {
                    this.aGg = false;
                    return false;
                }
                try {
                    if (!super.getTransformation(j, transformation)) {
                        this.aGg = false;
                        return false;
                    }
                    return true;
                } catch (Exception e) {
                    this.aGg = false;
                    return false;
                }
            }
            this.aGh = false;
            this.aGg = false;
            return false;
        }

        public boolean HD() {
            return this.aGg;
        }

        public void stopAnimation() {
            this.aGh = true;
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.aFH = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aoS = onLongClickListener;
    }

    public void setGifSetListener(d dVar) {
        this.aoU = dVar;
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
    public void HA() {
        long j;
        c poll = this.aFZ.poll();
        if (poll == null) {
            this.aGe = true;
            return;
        }
        this.aGe = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.aFY != null) {
            j = this.aFY.delay - (currentTimeMillis - this.aGd);
            this.aGa.offer(this.aFY);
        } else {
            j = 0;
        }
        this.aFY = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public c HB() {
        c poll = this.aGa.poll();
        if (poll == null) {
            poll = new c(null);
            try {
                poll.aGn = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
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
        public Bitmap aGn;
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
            while (a.this.mState == 1 && a.this.aFN != null && a.this.aFX > 0 && a.this.width > 0 && a.this.height > 0) {
                try {
                    a.this.aFN.U(a.this.aGb);
                    c HB = a.this.HB();
                    if (HB.aGn == null || (HB.aGn.getWidth() != a.this.width && HB.aGn.getHeight() != a.this.height)) {
                        try {
                            HB.aGn = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_8888);
                        } catch (OutOfMemoryError e) {
                            TbadkCoreApplication.m9getInst().onAppMemoryLow();
                            try {
                                HB.aGn = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_4444);
                            } catch (OutOfMemoryError e2) {
                                TbadkCoreApplication.m9getInst().onAppMemoryLow();
                            } catch (Throwable th) {
                                BdLog.e(th.getMessage());
                            }
                        } catch (Throwable th2) {
                            BdLog.e(th2.getMessage());
                        }
                    }
                    a.this.aFN.a(HB.aGn, null);
                    HB.delay = a.this.aFN.V(a.this.aGb);
                    a.this.aGb++;
                    if (HB.aGn == null) {
                        a.this.aGb++;
                    }
                    a.this.aGb %= a.this.aFX;
                    a.this.aFZ.put(HB);
                    if (a.this.aGe) {
                        a.this.mHandler.sendEmptyMessage(1);
                    }
                } catch (Exception e3) {
                    return;
                }
            }
        }
    }

    public boolean HC() {
        return this.aFT;
    }

    public void setLoadBigImage(boolean z) {
        this.aFT = z;
    }

    public int getBottomOffset() {
        return this.aFQ;
    }

    public int getLeftOffset() {
        return this.aFR;
    }
}
