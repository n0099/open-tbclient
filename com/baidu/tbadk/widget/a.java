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
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends ImageView {
    private Bitmap aFA;
    private int aFB;
    private int aFC;
    private int aFD;
    private boolean aFE;
    private boolean aFF;
    private float aFG;
    private Interpolator aFH;
    private int aFI;
    private c aFJ;
    private BlockingLinkedDeque<c> aFK;
    private BlockingLinkedDeque<c> aFL;
    private volatile int aFM;
    private b aFN;
    private volatile long aFO;
    private volatile boolean aFP;
    private float aFi;
    private float aFj;
    private ArrayList<Float> aFk;
    private float aFl;
    private float aFm;
    private float aFn;
    private float aFo;
    private boolean aFp;
    private int aFq;
    private int aFr;
    private e aFs;
    private View.OnClickListener aFt;
    private C0049a aFu;
    private float aFv;
    private boolean aFw;
    private boolean aFx;
    private int aFy;
    private volatile com.baidu.adp.gif.b aFz;
    private int acr;
    private View.OnLongClickListener aoq;
    private d aos;
    private int aot;
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
        this.aFF = z;
    }

    public a(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aFp = false;
        this.mImageData = null;
        this.aot = 0;
        this.aFq = 1300;
        this.aFr = 0;
        this.aFs = null;
        this.aFt = null;
        this.aoq = null;
        this.aos = null;
        this.aFv = 1.0f;
        this.acr = 0;
        this.mMode = 0;
        this.aFw = false;
        this.aFx = false;
        this.aFy = 0;
        this.aFz = null;
        this.aFA = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aFB = 0;
        this.aFC = 0;
        this.aFD = 0;
        this.aFH = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aFI = 0;
        this.aFJ = null;
        this.aFK = new BlockingLinkedDeque<>(5);
        this.aFL = new BlockingLinkedDeque<>(6);
        this.aFM = 0;
        this.aFO = 0L;
        this.mState = 0;
        this.aFP = true;
        this.mHandler = new Handler(new com.baidu.tbadk.widget.b(this));
        initData();
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aFp = false;
        this.mImageData = null;
        this.aot = 0;
        this.aFq = 1300;
        this.aFr = 0;
        this.aFs = null;
        this.aFt = null;
        this.aoq = null;
        this.aos = null;
        this.aFv = 1.0f;
        this.acr = 0;
        this.mMode = 0;
        this.aFw = false;
        this.aFx = false;
        this.aFy = 0;
        this.aFz = null;
        this.aFA = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aFB = 0;
        this.aFC = 0;
        this.aFD = 0;
        this.aFH = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aFI = 0;
        this.aFJ = null;
        this.aFK = new BlockingLinkedDeque<>(5);
        this.aFL = new BlockingLinkedDeque<>(6);
        this.aFM = 0;
        this.aFO = 0L;
        this.mState = 0;
        this.aFP = true;
        this.mHandler = new Handler(new com.baidu.tbadk.widget.b(this));
        initData();
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aFp = false;
        this.mImageData = null;
        this.aot = 0;
        this.aFq = 1300;
        this.aFr = 0;
        this.aFs = null;
        this.aFt = null;
        this.aoq = null;
        this.aos = null;
        this.aFv = 1.0f;
        this.acr = 0;
        this.mMode = 0;
        this.aFw = false;
        this.aFx = false;
        this.aFy = 0;
        this.aFz = null;
        this.aFA = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aFB = 0;
        this.aFC = 0;
        this.aFD = 0;
        this.aFH = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aFI = 0;
        this.aFJ = null;
        this.aFK = new BlockingLinkedDeque<>(5);
        this.aFL = new BlockingLinkedDeque<>(6);
        this.aFM = 0;
        this.aFO = 0L;
        this.mState = 0;
        this.aFP = true;
        this.mHandler = new Handler(new com.baidu.tbadk.widget.b(this));
        initData();
    }

    public int getImageType() {
        return this.acr;
    }

    public void setImageMode(int i) {
        this.aFr = i;
    }

    public void h(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.aot = i;
    }

    public void Hm() {
        this.aFx = false;
        this.aFp = false;
        this.mMode = 0;
        Hq();
        if (this.aFn < this.aFl) {
            this.aFn = this.aFl;
            Hx();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.aFp = true;
                this.aFw = false;
                this.aFx = false;
                break;
            case 1:
                Hm();
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
            this.aFv = i(motionEvent);
            if (this.aFv > 10.0f) {
                this.mMode = 2;
            }
        }
        if (this.mMode == 2 || !this.mGestureDetector.onTouchEvent(motionEvent)) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.aFw = true;
                        this.aFx = true;
                        if (this.acr != 1 && this.acr != 2) {
                            float i = i(motionEvent);
                            if (i >= 0.0f && Math.abs(this.aFv - i) >= 10.0f) {
                                if (Math.abs(this.aFv - i) > 100.0f) {
                                    this.aFv = i;
                                    break;
                                } else {
                                    float f = i / this.aFv;
                                    this.aFv = i;
                                    this.aFo = this.aFn;
                                    this.aFn *= f;
                                    if (this.aFn > this.aFm) {
                                        this.aFn = this.aFm;
                                    }
                                    if (this.aFn < this.aFl / 4.0f) {
                                        this.aFn = this.aFl / 4.0f;
                                    }
                                    Hx();
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
            Ho();
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public boolean Hn() {
        return this.aFl == this.aFn;
    }

    private void Ho() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            if (this.aFr == 0) {
                float width = this.mViewWidth / imageBitmap.getWidth();
                float height = this.mViewHeight / imageBitmap.getHeight();
                if (this.aFF) {
                    if (this.acr == 2) {
                        this.aFl = 2.5f;
                    } else {
                        this.aFl = Math.min(width, height);
                    }
                } else if (this.acr == 2) {
                    this.aFl = 1.0f;
                } else {
                    float f = this.aFG;
                    float f2 = f >= 1.0f ? f : 1.0f;
                    if (imageBitmap.getWidth() * f2 < this.mViewWidth && imageBitmap.getHeight() * f2 < this.mViewHeight) {
                        this.aFl = f2;
                    } else {
                        this.aFl = Math.min(width, height);
                    }
                }
            } else {
                this.aFl = Math.max(this.mViewWidth / imageBitmap.getWidth(), ((this.mViewHeight - this.mTop) - this.mBottom) / imageBitmap.getHeight());
            }
            this.aFm = this.aFq / (imageBitmap.getWidth() * imageBitmap.getHeight());
            this.aFm = FloatMath.sqrt(this.aFm);
            if (this.aFm > 10.0f) {
                this.aFm = 10.0f;
            }
            this.aFk.clear();
            this.aFk.add(Float.valueOf(this.aFl));
            this.aFn = this.aFl;
            this.aFo = this.aFn;
            Hx();
            Hp();
            return;
        }
        this.aFi = 0.0f;
        this.aFj = 0.0f;
        this.aFl = 1.0f;
        this.aFm = 1.0f;
        this.aFn = 1.0f;
        this.aFo = this.aFn;
        this.aFk.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hp() {
        if (this.aFs != null) {
            this.aFs.a(this, canZoomIn(), canZoomOut());
        }
    }

    public void setOnSizeChangedListener(e eVar) {
        this.aFs = eVar;
    }

    public byte[] getImageData() {
        return this.mImageData;
    }

    public void setImageData(byte[] bArr) {
        this.mImageData = bArr;
    }

    public Bitmap getGifCache() {
        return this.aFA;
    }

    public void setGifCache(Bitmap bitmap) {
        this.aFA = bitmap;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        boolean z;
        int i4;
        if (this.acr == 2 && this.aFD != 0 && !this.aFu.HB()) {
            int width = getWidth();
            int height = getHeight();
            Drawable drawable = getDrawable();
            float f = 0.0f;
            float f2 = height * 0.3f;
            float f3 = width;
            float f4 = (1.0f - 0.3f) * height;
            if (this.aFF && drawable != null) {
                Rect bounds = drawable.getBounds();
                int i5 = bounds.right - bounds.left;
                int i6 = bounds.bottom - bounds.top;
                f = (width / 2) - (i5 * 2.5f);
                f2 = (height / 2) - (i6 * 2.5f);
                f3 = (i5 * 2.5f) + (width / 2);
                f4 = (i6 * 2.5f) + (height / 2);
            }
            this.mPaint.setColor(av.getColor(this.aFD));
            canvas.drawRect(f, f2, f3, f4, this.mPaint);
            this.mPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        }
        super.onDraw(canvas);
        if (this.acr == 1 && this.aFA != null && !this.aFA.isRecycled()) {
            int width2 = this.aFA.getWidth();
            int height2 = this.aFA.getHeight();
            int width3 = getWidth();
            int height3 = getHeight();
            int i7 = (width3 - width2) >> 1;
            int i8 = (height3 - height2) >> 1;
            float f5 = this.aFG;
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
            if (this.aFy == 1 && this.aFz != null && this.aFJ != null && this.aFJ.aFY != null) {
                if (z) {
                    canvas.drawBitmap(this.aFJ.aFY, i3, i2, (Paint) null);
                } else {
                    canvas.drawBitmap(this.aFJ.aFY, this.mMatrix, this.mPaint);
                }
                invalidate();
            } else if (z) {
                canvas.drawBitmap(this.aFA, i3, i2, (Paint) null);
            } else {
                canvas.drawBitmap(this.aFA, this.mMatrix, this.mPaint);
            }
        }
    }

    public void play() {
        com.baidu.adp.widget.a.a e2;
        if (this.acr == 1) {
            if (this.aFz == null) {
                if (this.aFN != null) {
                    this.aFN.interrupt();
                    this.aFN = null;
                }
                if (this.mImageData != null && (e2 = a.C0004a.cw().e(this.mImageData, 0, this.mImageData.length)) != null && e2.getGif() != null) {
                    this.aFz = e2.getGif();
                    if (this.aFz != null) {
                        this.aFy = 1;
                        this.width = this.aFz.getWidth();
                        this.height = this.aFz.getHeight();
                        this.aFM = 0;
                        this.aFI = this.aFz.cx();
                    } else {
                        this.aFy = 0;
                    }
                } else {
                    return;
                }
            }
            if (this.aFz != null && this.mState == 0) {
                this.aFP = true;
                this.aFN = new b(this, null);
                this.aFK.clear();
                this.aFL.clear();
                this.mState = 1;
                this.aFN.start();
            }
        }
    }

    public void pause() {
        if (this.acr == 1) {
            this.mState = 0;
            if (this.aFN != null) {
                this.aFN.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.acr == 1) {
            this.mState = 0;
            if (this.aFN != null) {
                this.aFN.interrupt();
                this.aFN = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.aFP = true;
            this.aFJ = null;
            this.aFL.clear();
            this.aFK.clear();
            this.width = 0;
            this.height = 0;
            this.aFM = 0;
            this.aFI = 0;
            if (this.aFz != null) {
                this.aFz = null;
            }
        }
    }

    private void initData() {
        this.aFG = k.M(getContext());
        this.aFq = k.L(getContext()) * k.K(getContext()) * 2;
        if (this.aFq < 1690000) {
            this.aFq = 1690000;
        }
        this.aFi = 0.0f;
        this.aFj = 0.0f;
        this.aFk = new ArrayList<>();
        this.aFl = 1.0f;
        this.aFm = 1.0f;
        this.aFn = 1.0f;
        this.aFo = this.aFn;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.aFu = new C0049a();
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWillNotDraw(false);
        scrollTo(0, 0);
        this.mGestureDetector = new GestureDetector(getContext(), new com.baidu.tbadk.widget.c(this));
    }

    private void Hq() {
        int i = 0;
        int scrollX = getScrollX();
        if (this.aFi >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.aFi) {
                scrollX = (int) (this.aFi - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.aFj + this.mTop + this.mBottom >= getHeight()) {
            i = scrollY < (-this.aFB) ? -this.aFB : scrollY;
            if (getHeight() + i > this.aFj + this.mBottom + this.aFC) {
                i = (int) ((this.aFj - getHeight()) + this.mBottom + this.aFC);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.aFi;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.aFj;
    }

    public boolean Hr() {
        if (this.acr == 1 || this.acr == 2) {
            return true;
        }
        return !this.aFx && getScrollX() >= ((int) (this.aFi - ((float) getWidth()))) + (-1);
    }

    public boolean Hs() {
        if (this.acr == 1 || this.acr == 2) {
            return true;
        }
        return !this.aFx && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.aFu.HB()) {
            this.aFu.stopAnimation();
        }
        this.aFD = 0;
        super.setImageBitmap(bitmap);
        Ho();
        this.acr = 0;
    }

    public void j(Bitmap bitmap) {
        Bitmap imageBitmap = getImageBitmap();
        if (bitmap != null && !bitmap.isRecycled()) {
            if (imageBitmap != null && (imageBitmap.getWidth() != bitmap.getWidth() || imageBitmap.getHeight() != bitmap.getHeight())) {
                setImageBitmap(bitmap);
                return;
            }
            if (this.aFu.HB()) {
                this.aFu.stopAnimation();
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            super.setImageBitmap(bitmap);
            super.setImageMatrix(this.mMatrix);
            scrollTo(scrollX, scrollY);
            this.acr = 0;
        }
    }

    public void a(byte[] bArr, Bitmap bitmap) {
        if (this.aFu.HB()) {
            this.aFu.stopAnimation();
        }
        super.setImageDrawable(null);
        stop();
        Ho();
        this.acr = 1;
        this.aFA = bitmap;
        this.mImageData = bArr;
        if (this.aos != null) {
            this.aos.a(this);
        }
    }

    public void onDestroy() {
        if (this.aFu.HB()) {
            this.aFu.stopAnimation();
        }
        super.setImageDrawable(null);
        this.mImageData = null;
        this.aFA = null;
        stop();
        if (this.aFz != null) {
            this.aFz.close();
            this.aFz = null;
        }
    }

    public void release() {
        if (this.aFu.HB()) {
            this.aFu.stopAnimation();
        }
        stop();
        super.setImageDrawable(null);
        this.aFA = null;
    }

    public void Ht() {
        if (this.aFu.HB()) {
            this.aFu.stopAnimation();
        }
        if (this.aFF) {
            super.setImageBitmap(BitmapHelper.getCashBitmap(t.f.icon_default_avatar100));
        } else {
            super.setImageBitmap(BitmapHelper.getCashBitmap(t.f.btn_see_default));
        }
        this.acr = 2;
        Ho();
    }

    public void Hu() {
        if (this.acr != 1 && this.acr != 2) {
            int size = this.aFk.size();
            if (size > 0) {
                this.aFk.add(Float.valueOf(this.aFk.get(size - 1).floatValue() * 1.25f));
            } else {
                this.aFk.add(Float.valueOf(this.aFl));
            }
            Hx();
            Hp();
        }
    }

    public void Hv() {
        if (this.acr != 1 && this.acr != 2) {
            int size = this.aFk.size();
            if (size > 1) {
                this.aFk.remove(size - 1);
            }
            Hx();
            Hp();
        }
    }

    public void Hw() {
        Hp();
        if (this.acr != 1 && this.acr != 2 && this.aFn != this.aFl) {
            this.aFk.clear();
            this.aFk.add(Float.valueOf(this.aFl));
            this.aFn = this.aFl;
            this.aFo = this.aFn;
            Hx();
        }
    }

    public boolean canZoomIn() {
        if (this.acr == 1 || this.acr == 2) {
            return false;
        }
        int size = this.aFk.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.aFk.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.aFq) && floatValue <= 5.0f;
    }

    public boolean canZoomOut() {
        if (this.acr == 1 || this.acr == 2) {
            return false;
        }
        int size = this.aFk.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled()) {
            return false;
        }
        return size > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hx() {
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
                    int size = this.aFk.size();
                    if (size > 0) {
                        f2 = this.aFk.get(size - 1).floatValue();
                    } else {
                        f2 = this.aFl;
                    }
                    this.aFn = f2;
                }
                this.mMatrix.setScale(this.aFn, this.aFn);
                this.aFi = imageBitmap.getWidth() * this.aFn;
                this.aFj = imageBitmap.getHeight() * this.aFn;
                float width = this.aFo * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.aFo;
                this.aFB = this.mTop;
                this.aFC = 0;
                float f3 = this.aFi < ((float) this.mViewWidth) ? (int) ((this.mViewWidth - this.aFi) / 2.0f) : 0.0f;
                if (this.aFj < this.mViewHeight) {
                    f = (int) ((this.mViewHeight - this.aFj) / 2.0f);
                    if (this.aFr == 1 && f > this.mTop) {
                        f = this.mTop;
                    }
                    this.aFB = (int) (this.mTop - f);
                    this.aFC = this.mTop - this.aFB;
                } else {
                    f = 0.0f;
                }
                this.mMatrix.postTranslate(f3, f);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    scrollX = i > getWidth() ? getWidth() : i;
                    if (this.aFi <= screenWidth) {
                        scrollX = 0;
                    } else if (this.aFi > screenWidth && this.aFi / 2.0f < screenWidth) {
                        scrollX = (int) (scrollX - (this.aFi / 4.0f));
                    }
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.aFi - width) / 2.0f);
                    }
                    if (this.aFi <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.aFi) {
                        scrollX = (int) (this.aFi - getWidth());
                    }
                }
                if (scrollX > 0 && this.aFi - scrollX < getWidth()) {
                    scrollX = (int) (this.aFi - getWidth());
                }
                if (this.mMode == 2) {
                    scrollY += (int) ((this.aFj - height) / 2.0f);
                }
                if (this.aFj <= getHeight()) {
                    scrollY = 0;
                } else if (getHeight() + scrollY > this.aFj) {
                    scrollY = (int) (this.aFj - getHeight());
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
    public class C0049a extends Animation {
        private int Ci;
        private boolean aFR = false;
        private boolean aFS = false;
        private long aFT;
        private long aFU;
        private int aFV;
        private long aFW;
        private long aFX;

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
            this.aFT = f;
            this.aFU = f2;
            this.aFW = Math.abs((f * 1000.0f) / 2500.0f);
            this.aFX = Math.abs((f2 * 1000.0f) / 2500.0f);
            setDuration(Math.max(this.aFW, this.aFX));
            setInterpolator(a.this.aFH);
            this.aFV = a.this.getScrollX();
            this.Ci = a.this.getScrollY();
            this.aFR = true;
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
            if (this.aFW > this.aFX) {
                j = ((float) this.aFW) * f;
            } else {
                j = ((float) this.aFX) * f;
            }
            float f2 = ((float) (j > this.aFW ? this.aFW : j)) / 1000.0f;
            if (this.aFT > 0) {
                i = this.aFV - ((int) (f2 * (((float) this.aFT) - ((2500.0f * f2) / 2.0f))));
            } else {
                i = this.aFV - ((int) (f2 * (((float) this.aFT) + ((2500.0f * f2) / 2.0f))));
            }
            if (j > this.aFX) {
                j = this.aFX;
            }
            float f3 = ((float) j) / 1000.0f;
            if (this.aFU > 0) {
                i2 = this.Ci - ((int) (f3 * (((float) this.aFU) - ((2500.0f * f3) / 2.0f))));
            } else {
                i2 = this.Ci - ((int) (f3 * (((float) this.aFU) + ((2500.0f * f3) / 2.0f))));
            }
            if (a.this.aFj + a.this.mTop + a.this.mBottom > a.this.getHeight()) {
                if (i2 < (-a.this.aFB)) {
                    i2 = -a.this.aFB;
                }
                if (a.this.getHeight() + i2 > a.this.aFj + a.this.mBottom + a.this.aFC) {
                    i2 = (int) ((a.this.aFj - a.this.getHeight()) + a.this.mBottom + a.this.aFC);
                }
            } else {
                i2 = 0;
            }
            if (a.this.aFi > a.this.getWidth()) {
                int width = ((float) (a.this.getWidth() + i)) > a.this.aFi ? (int) (a.this.aFi - a.this.getWidth()) : i;
                if (width >= 0) {
                    i3 = width;
                }
            }
            a.this.scrollTo(i3, i2);
            a.this.invalidate();
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            if (!this.aFS) {
                if (a.this.aFp) {
                    this.aFR = false;
                    return false;
                }
                try {
                    if (!super.getTransformation(j, transformation)) {
                        this.aFR = false;
                        return false;
                    }
                    return true;
                } catch (Exception e) {
                    this.aFR = false;
                    return false;
                }
            }
            this.aFS = false;
            this.aFR = false;
            return false;
        }

        public boolean HB() {
            return this.aFR;
        }

        public void stopAnimation() {
            this.aFS = true;
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.aFt = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aoq = onLongClickListener;
    }

    public void setGifSetListener(d dVar) {
        this.aos = dVar;
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
    public void Hy() {
        long j;
        c poll = this.aFK.poll();
        if (poll == null) {
            this.aFP = true;
            return;
        }
        this.aFP = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.aFJ != null) {
            j = this.aFJ.delay - (currentTimeMillis - this.aFO);
            this.aFL.offer(this.aFJ);
        } else {
            j = 0;
        }
        this.aFJ = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public c Hz() {
        c poll = this.aFL.poll();
        if (poll == null) {
            poll = new c(null);
            try {
                poll.aFY = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
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
        public Bitmap aFY;
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
            while (a.this.mState == 1 && a.this.aFz != null && a.this.aFI > 0 && a.this.width > 0 && a.this.height > 0) {
                try {
                    a.this.aFz.U(a.this.aFM);
                    c Hz = a.this.Hz();
                    if (Hz.aFY == null || (Hz.aFY.getWidth() != a.this.width && Hz.aFY.getHeight() != a.this.height)) {
                        try {
                            Hz.aFY = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_8888);
                        } catch (OutOfMemoryError e) {
                            TbadkCoreApplication.m9getInst().onAppMemoryLow();
                            try {
                                Hz.aFY = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_4444);
                            } catch (OutOfMemoryError e2) {
                                TbadkCoreApplication.m9getInst().onAppMemoryLow();
                            } catch (Throwable th) {
                                BdLog.e(th.getMessage());
                            }
                        } catch (Throwable th2) {
                            BdLog.e(th2.getMessage());
                        }
                    }
                    a.this.aFz.a(Hz.aFY, null);
                    Hz.delay = a.this.aFz.V(a.this.aFM);
                    a.this.aFM++;
                    if (Hz.aFY == null) {
                        a.this.aFM++;
                    }
                    a.this.aFM %= a.this.aFI;
                    a.this.aFK.put(Hz);
                    if (a.this.aFP) {
                        a.this.mHandler.sendEmptyMessage(1);
                    }
                } catch (Exception e3) {
                    return;
                }
            }
        }
    }

    public boolean HA() {
        return this.aFE;
    }

    public void setLoadBigImage(boolean z) {
        this.aFE = z;
    }
}
