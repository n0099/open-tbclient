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
    private int ZC;
    private Interpolator aCA;
    private int aCB;
    private c aCC;
    private BlockingLinkedDeque<c> aCD;
    private BlockingLinkedDeque<c> aCE;
    private volatile int aCF;
    private b aCG;
    private volatile long aCH;
    private volatile boolean aCI;
    private float aCb;
    private float aCc;
    private ArrayList<Float> aCd;
    private float aCe;
    private float aCf;
    private float aCg;
    private float aCh;
    private boolean aCi;
    private int aCj;
    private int aCk;
    private e aCl;
    private View.OnClickListener aCm;
    private C0049a aCn;
    private float aCo;
    private boolean aCp;
    private boolean aCq;
    private int aCr;
    private volatile com.baidu.adp.gif.b aCs;
    private Bitmap aCt;
    private int aCu;
    private int aCv;
    private int aCw;
    private boolean aCx;
    private boolean aCy;
    private float aCz;
    private View.OnLongClickListener alj;
    private d alm;
    private int aln;
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
        this.aCy = z;
    }

    public a(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aCi = false;
        this.mImageData = null;
        this.aln = 0;
        this.aCj = 1300;
        this.aCk = 0;
        this.aCl = null;
        this.aCm = null;
        this.alj = null;
        this.alm = null;
        this.aCo = 1.0f;
        this.ZC = 0;
        this.mMode = 0;
        this.aCp = false;
        this.aCq = false;
        this.aCr = 0;
        this.aCs = null;
        this.aCt = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aCu = 0;
        this.aCv = 0;
        this.aCw = 0;
        this.aCA = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aCB = 0;
        this.aCC = null;
        this.aCD = new BlockingLinkedDeque<>(5);
        this.aCE = new BlockingLinkedDeque<>(6);
        this.aCF = 0;
        this.aCH = 0L;
        this.mState = 0;
        this.aCI = true;
        this.mHandler = new Handler(new com.baidu.tbadk.widget.b(this));
        initData();
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aCi = false;
        this.mImageData = null;
        this.aln = 0;
        this.aCj = 1300;
        this.aCk = 0;
        this.aCl = null;
        this.aCm = null;
        this.alj = null;
        this.alm = null;
        this.aCo = 1.0f;
        this.ZC = 0;
        this.mMode = 0;
        this.aCp = false;
        this.aCq = false;
        this.aCr = 0;
        this.aCs = null;
        this.aCt = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aCu = 0;
        this.aCv = 0;
        this.aCw = 0;
        this.aCA = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aCB = 0;
        this.aCC = null;
        this.aCD = new BlockingLinkedDeque<>(5);
        this.aCE = new BlockingLinkedDeque<>(6);
        this.aCF = 0;
        this.aCH = 0L;
        this.mState = 0;
        this.aCI = true;
        this.mHandler = new Handler(new com.baidu.tbadk.widget.b(this));
        initData();
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aCi = false;
        this.mImageData = null;
        this.aln = 0;
        this.aCj = 1300;
        this.aCk = 0;
        this.aCl = null;
        this.aCm = null;
        this.alj = null;
        this.alm = null;
        this.aCo = 1.0f;
        this.ZC = 0;
        this.mMode = 0;
        this.aCp = false;
        this.aCq = false;
        this.aCr = 0;
        this.aCs = null;
        this.aCt = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aCu = 0;
        this.aCv = 0;
        this.aCw = 0;
        this.aCA = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aCB = 0;
        this.aCC = null;
        this.aCD = new BlockingLinkedDeque<>(5);
        this.aCE = new BlockingLinkedDeque<>(6);
        this.aCF = 0;
        this.aCH = 0L;
        this.mState = 0;
        this.aCI = true;
        this.mHandler = new Handler(new com.baidu.tbadk.widget.b(this));
        initData();
    }

    public int getImageType() {
        return this.ZC;
    }

    public void setImageMode(int i) {
        this.aCk = i;
    }

    public void h(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.aln = i;
    }

    public void FS() {
        this.aCq = false;
        this.aCi = false;
        this.mMode = 0;
        FW();
        if (this.aCg < this.aCe) {
            this.aCg = this.aCe;
            Gd();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.aCi = true;
                this.aCp = false;
                this.aCq = false;
                break;
            case 1:
                FS();
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
            this.aCo = g(motionEvent);
            if (this.aCo > 10.0f) {
                this.mMode = 2;
            }
        }
        if (this.mMode == 2 || !this.mGestureDetector.onTouchEvent(motionEvent)) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.aCp = true;
                        this.aCq = true;
                        if (this.ZC != 1 && this.ZC != 2) {
                            float g = g(motionEvent);
                            if (g >= 0.0f && Math.abs(this.aCo - g) >= 10.0f) {
                                if (Math.abs(this.aCo - g) > 100.0f) {
                                    this.aCo = g;
                                    break;
                                } else {
                                    float f = g / this.aCo;
                                    this.aCo = g;
                                    this.aCh = this.aCg;
                                    this.aCg *= f;
                                    if (this.aCg > this.aCf) {
                                        this.aCg = this.aCf;
                                    }
                                    if (this.aCg < this.aCe / 4.0f) {
                                        this.aCg = this.aCe / 4.0f;
                                    }
                                    Gd();
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

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            this.mViewWidth = i3 - i;
            this.mViewHeight = i4 - i2;
            FU();
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public boolean FT() {
        return this.aCe == this.aCg;
    }

    private void FU() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            if (this.aCk == 0) {
                float width = this.mViewWidth / imageBitmap.getWidth();
                float height = this.mViewHeight / imageBitmap.getHeight();
                if (this.aCy) {
                    if (this.ZC == 2) {
                        this.aCe = 2.5f;
                    } else {
                        this.aCe = Math.min(width, height);
                    }
                } else if (this.ZC == 2) {
                    this.aCe = 1.0f;
                } else {
                    float f = this.aCz;
                    float f2 = f >= 1.0f ? f : 1.0f;
                    if (imageBitmap.getWidth() * f2 < this.mViewWidth && imageBitmap.getHeight() * f2 < this.mViewHeight) {
                        this.aCe = f2;
                    } else {
                        this.aCe = Math.min(width, height);
                    }
                }
            } else {
                this.aCe = Math.max(this.mViewWidth / imageBitmap.getWidth(), ((this.mViewHeight - this.mTop) - this.mBottom) / imageBitmap.getHeight());
            }
            this.aCf = this.aCj / (imageBitmap.getWidth() * imageBitmap.getHeight());
            this.aCf = FloatMath.sqrt(this.aCf);
            if (this.aCf > 10.0f) {
                this.aCf = 10.0f;
            }
            this.aCd.clear();
            this.aCd.add(Float.valueOf(this.aCe));
            this.aCg = this.aCe;
            this.aCh = this.aCg;
            Gd();
            FV();
            return;
        }
        this.aCb = 0.0f;
        this.aCc = 0.0f;
        this.aCe = 1.0f;
        this.aCf = 1.0f;
        this.aCg = 1.0f;
        this.aCh = this.aCg;
        this.aCd.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FV() {
        if (this.aCl != null) {
            this.aCl.a(this, canZoomIn(), canZoomOut());
        }
    }

    public void setOnSizeChangedListener(e eVar) {
        this.aCl = eVar;
    }

    public byte[] getImageData() {
        return this.mImageData;
    }

    public void setImageData(byte[] bArr) {
        this.mImageData = bArr;
    }

    public Bitmap getGifCache() {
        return this.aCt;
    }

    public void setGifCache(Bitmap bitmap) {
        this.aCt = bitmap;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        boolean z;
        int i4;
        if (this.ZC == 2 && this.aCw != 0 && !this.aCn.Gh()) {
            int width = getWidth();
            int height = getHeight();
            Drawable drawable = getDrawable();
            float f = 0.0f;
            float f2 = height * 0.3f;
            float f3 = width;
            float f4 = (1.0f - 0.3f) * height;
            if (this.aCy && drawable != null) {
                Rect bounds = drawable.getBounds();
                int i5 = bounds.right - bounds.left;
                int i6 = bounds.bottom - bounds.top;
                f = (width / 2) - (i5 * 2.5f);
                f2 = (height / 2) - (i6 * 2.5f);
                f3 = (i5 * 2.5f) + (width / 2);
                f4 = (i6 * 2.5f) + (height / 2);
            }
            this.mPaint.setColor(av.getColor(this.aCw));
            canvas.drawRect(f, f2, f3, f4, this.mPaint);
            this.mPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        }
        super.onDraw(canvas);
        if (this.ZC == 1 && this.aCt != null && !this.aCt.isRecycled()) {
            int width2 = this.aCt.getWidth();
            int height2 = this.aCt.getHeight();
            int width3 = getWidth();
            int height3 = getHeight();
            int i7 = (width3 - width2) >> 1;
            int i8 = (height3 - height2) >> 1;
            float f5 = this.aCz;
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
            if (this.aCr == 1 && this.aCs != null && this.aCC != null && this.aCC.aCR != null) {
                if (z) {
                    canvas.drawBitmap(this.aCC.aCR, i3, i2, (Paint) null);
                } else {
                    canvas.drawBitmap(this.aCC.aCR, this.mMatrix, this.mPaint);
                }
                invalidate();
            } else if (z) {
                canvas.drawBitmap(this.aCt, i3, i2, (Paint) null);
            } else {
                canvas.drawBitmap(this.aCt, this.mMatrix, this.mPaint);
            }
        }
    }

    public void play() {
        com.baidu.adp.widget.a.a e2;
        if (this.ZC == 1) {
            if (this.aCs == null) {
                if (this.aCG != null) {
                    this.aCG.interrupt();
                    this.aCG = null;
                }
                if (this.mImageData != null && (e2 = a.C0004a.bB().e(this.mImageData, 0, this.mImageData.length)) != null && e2.getGif() != null) {
                    this.aCs = e2.getGif();
                    if (this.aCs != null) {
                        this.aCr = 1;
                        this.width = this.aCs.getWidth();
                        this.height = this.aCs.getHeight();
                        this.aCF = 0;
                        this.aCB = this.aCs.bC();
                    } else {
                        this.aCr = 0;
                    }
                } else {
                    return;
                }
            }
            if (this.aCs != null && this.mState == 0) {
                this.aCI = true;
                this.aCG = new b(this, null);
                this.aCD.clear();
                this.aCE.clear();
                this.mState = 1;
                this.aCG.start();
            }
        }
    }

    public void pause() {
        if (this.ZC == 1) {
            this.mState = 0;
            if (this.aCG != null) {
                this.aCG.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.ZC == 1) {
            this.mState = 0;
            if (this.aCG != null) {
                this.aCG.interrupt();
                this.aCG = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.aCI = true;
            this.aCC = null;
            this.aCE.clear();
            this.aCD.clear();
            this.width = 0;
            this.height = 0;
            this.aCF = 0;
            this.aCB = 0;
            if (this.aCs != null) {
                this.aCs = null;
            }
        }
    }

    private void initData() {
        this.aCz = k.C(getContext());
        this.aCj = k.B(getContext()) * k.A(getContext()) * 2;
        if (this.aCj < 1690000) {
            this.aCj = 1690000;
        }
        this.aCb = 0.0f;
        this.aCc = 0.0f;
        this.aCd = new ArrayList<>();
        this.aCe = 1.0f;
        this.aCf = 1.0f;
        this.aCg = 1.0f;
        this.aCh = this.aCg;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.aCn = new C0049a();
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWillNotDraw(false);
        scrollTo(0, 0);
        this.mGestureDetector = new GestureDetector(getContext(), new com.baidu.tbadk.widget.c(this));
    }

    private void FW() {
        int i = 0;
        int scrollX = getScrollX();
        if (this.aCb >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.aCb) {
                scrollX = (int) (this.aCb - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.aCc + this.mTop + this.mBottom >= getHeight()) {
            i = scrollY < (-this.aCu) ? -this.aCu : scrollY;
            if (getHeight() + i > this.aCc + this.mBottom + this.aCv) {
                i = (int) ((this.aCc - getHeight()) + this.mBottom + this.aCv);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.aCb;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.aCc;
    }

    public boolean FX() {
        if (this.ZC == 1 || this.ZC == 2) {
            return true;
        }
        return !this.aCq && getScrollX() >= ((int) (this.aCb - ((float) getWidth()))) + (-1);
    }

    public boolean FY() {
        if (this.ZC == 1 || this.ZC == 2) {
            return true;
        }
        return !this.aCq && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.aCn.Gh()) {
            this.aCn.stopAnimation();
        }
        this.aCw = 0;
        super.setImageBitmap(bitmap);
        FU();
        this.ZC = 0;
    }

    public void i(Bitmap bitmap) {
        Bitmap imageBitmap = getImageBitmap();
        if (bitmap != null && !bitmap.isRecycled()) {
            if (imageBitmap != null && (imageBitmap.getWidth() != bitmap.getWidth() || imageBitmap.getHeight() != bitmap.getHeight())) {
                setImageBitmap(bitmap);
                return;
            }
            if (this.aCn.Gh()) {
                this.aCn.stopAnimation();
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            super.setImageBitmap(bitmap);
            super.setImageMatrix(this.mMatrix);
            scrollTo(scrollX, scrollY);
            this.ZC = 0;
        }
    }

    public void a(byte[] bArr, Bitmap bitmap) {
        if (this.aCn.Gh()) {
            this.aCn.stopAnimation();
        }
        super.setImageDrawable(null);
        stop();
        FU();
        this.ZC = 1;
        this.aCt = bitmap;
        this.mImageData = bArr;
        if (this.alm != null) {
            this.alm.a(this);
        }
    }

    public void onDestroy() {
        if (this.aCn.Gh()) {
            this.aCn.stopAnimation();
        }
        super.setImageDrawable(null);
        this.mImageData = null;
        this.aCt = null;
        stop();
        if (this.aCs != null) {
            this.aCs.close();
            this.aCs = null;
        }
    }

    public void release() {
        if (this.aCn.Gh()) {
            this.aCn.stopAnimation();
        }
        stop();
        super.setImageDrawable(null);
        this.aCt = null;
    }

    public void FZ() {
        if (this.aCn.Gh()) {
            this.aCn.stopAnimation();
        }
        if (this.aCy) {
            super.setImageBitmap(BitmapHelper.getCashBitmap(u.f.icon_default_avatar100));
        } else {
            super.setImageBitmap(BitmapHelper.getCashBitmap(u.f.btn_see_default));
        }
        this.ZC = 2;
        FU();
    }

    public void Ga() {
        if (this.ZC != 1 && this.ZC != 2) {
            int size = this.aCd.size();
            if (size > 0) {
                this.aCd.add(Float.valueOf(this.aCd.get(size - 1).floatValue() * 1.25f));
            } else {
                this.aCd.add(Float.valueOf(this.aCe));
            }
            Gd();
            FV();
        }
    }

    public void Gb() {
        if (this.ZC != 1 && this.ZC != 2) {
            int size = this.aCd.size();
            if (size > 1) {
                this.aCd.remove(size - 1);
            }
            Gd();
            FV();
        }
    }

    public void Gc() {
        FV();
        if (this.ZC != 1 && this.ZC != 2 && this.aCg != this.aCe) {
            this.aCd.clear();
            this.aCd.add(Float.valueOf(this.aCe));
            this.aCg = this.aCe;
            this.aCh = this.aCg;
            Gd();
        }
    }

    public boolean canZoomIn() {
        if (this.ZC == 1 || this.ZC == 2) {
            return false;
        }
        int size = this.aCd.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.aCd.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.aCj) && floatValue <= 5.0f;
    }

    public boolean canZoomOut() {
        if (this.ZC == 1 || this.ZC == 2) {
            return false;
        }
        int size = this.aCd.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled()) {
            return false;
        }
        return size > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gd() {
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
                    int size = this.aCd.size();
                    if (size > 0) {
                        f2 = this.aCd.get(size - 1).floatValue();
                    } else {
                        f2 = this.aCe;
                    }
                    this.aCg = f2;
                }
                this.mMatrix.setScale(this.aCg, this.aCg);
                this.aCb = imageBitmap.getWidth() * this.aCg;
                this.aCc = imageBitmap.getHeight() * this.aCg;
                float width = this.aCh * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.aCh;
                this.aCu = this.mTop;
                this.aCv = 0;
                float f3 = this.aCb < ((float) this.mViewWidth) ? (int) ((this.mViewWidth - this.aCb) / 2.0f) : 0.0f;
                if (this.aCc < this.mViewHeight) {
                    f = (int) ((this.mViewHeight - this.aCc) / 2.0f);
                    if (this.aCk == 1 && f > this.mTop) {
                        f = this.mTop;
                    }
                    this.aCu = (int) (this.mTop - f);
                    this.aCv = this.mTop - this.aCu;
                } else {
                    f = 0.0f;
                }
                this.mMatrix.postTranslate(f3, f);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    scrollX = i > getWidth() ? getWidth() : i;
                    if (this.aCb <= screenWidth) {
                        scrollX = 0;
                    } else if (this.aCb > screenWidth && this.aCb / 2.0f < screenWidth) {
                        scrollX = (int) (scrollX - (this.aCb / 4.0f));
                    }
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.aCb - width) / 2.0f);
                    }
                    if (this.aCb <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.aCb) {
                        scrollX = (int) (this.aCb - getWidth());
                    }
                }
                if (scrollX > 0 && this.aCb - scrollX < getWidth()) {
                    scrollX = (int) (this.aCb - getWidth());
                }
                if (this.mMode == 2) {
                    scrollY += (int) ((this.aCc - height) / 2.0f);
                }
                if (this.aCc <= getHeight()) {
                    scrollY = 0;
                } else if (getHeight() + scrollY > this.aCc) {
                    scrollY = (int) (this.aCc - getHeight());
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
        private boolean aCK = false;
        private boolean aCL = false;
        private long aCM;
        private long aCN;
        private int aCO;
        private long aCP;
        private long aCQ;
        private int zT;

        public C0049a() {
        }

        public void c(float f, float f2) {
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
            this.aCM = f;
            this.aCN = f2;
            this.aCP = Math.abs((f * 1000.0f) / 2500.0f);
            this.aCQ = Math.abs((f2 * 1000.0f) / 2500.0f);
            setDuration(Math.max(this.aCP, this.aCQ));
            setInterpolator(a.this.aCA);
            this.aCO = a.this.getScrollX();
            this.zT = a.this.getScrollY();
            this.aCK = true;
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
            if (this.aCP > this.aCQ) {
                j = ((float) this.aCP) * f;
            } else {
                j = ((float) this.aCQ) * f;
            }
            float f2 = ((float) (j > this.aCP ? this.aCP : j)) / 1000.0f;
            if (this.aCM > 0) {
                i = this.aCO - ((int) (f2 * (((float) this.aCM) - ((2500.0f * f2) / 2.0f))));
            } else {
                i = this.aCO - ((int) (f2 * (((float) this.aCM) + ((2500.0f * f2) / 2.0f))));
            }
            if (j > this.aCQ) {
                j = this.aCQ;
            }
            float f3 = ((float) j) / 1000.0f;
            if (this.aCN > 0) {
                i2 = this.zT - ((int) (f3 * (((float) this.aCN) - ((2500.0f * f3) / 2.0f))));
            } else {
                i2 = this.zT - ((int) (f3 * (((float) this.aCN) + ((2500.0f * f3) / 2.0f))));
            }
            if (a.this.aCc + a.this.mTop + a.this.mBottom > a.this.getHeight()) {
                if (i2 < (-a.this.aCu)) {
                    i2 = -a.this.aCu;
                }
                if (a.this.getHeight() + i2 > a.this.aCc + a.this.mBottom + a.this.aCv) {
                    i2 = (int) ((a.this.aCc - a.this.getHeight()) + a.this.mBottom + a.this.aCv);
                }
            } else {
                i2 = 0;
            }
            if (a.this.aCb > a.this.getWidth()) {
                int width = ((float) (a.this.getWidth() + i)) > a.this.aCb ? (int) (a.this.aCb - a.this.getWidth()) : i;
                if (width >= 0) {
                    i3 = width;
                }
            }
            a.this.scrollTo(i3, i2);
            a.this.invalidate();
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            if (!this.aCL) {
                if (a.this.aCi) {
                    this.aCK = false;
                    return false;
                }
                try {
                    if (!super.getTransformation(j, transformation)) {
                        this.aCK = false;
                        return false;
                    }
                    return true;
                } catch (Exception e) {
                    this.aCK = false;
                    return false;
                }
            }
            this.aCL = false;
            this.aCK = false;
            return false;
        }

        public boolean Gh() {
            return this.aCK;
        }

        public void stopAnimation() {
            this.aCL = true;
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.aCm = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.alj = onLongClickListener;
    }

    public void setGifSetListener(d dVar) {
        this.alm = dVar;
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
    public void Ge() {
        long j;
        c poll = this.aCD.poll();
        if (poll == null) {
            this.aCI = true;
            return;
        }
        this.aCI = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.aCC != null) {
            j = this.aCC.delay - (currentTimeMillis - this.aCH);
            this.aCE.offer(this.aCC);
        } else {
            j = 0;
        }
        this.aCC = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public c Gf() {
        c poll = this.aCE.poll();
        if (poll == null) {
            poll = new c(null);
            try {
                poll.aCR = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
            } catch (OutOfMemoryError e2) {
                TbadkCoreApplication.m10getInst().onAppMemoryLow();
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
        public Bitmap aCR;
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
            while (a.this.mState == 1 && a.this.aCs != null && a.this.aCB > 0 && a.this.width > 0 && a.this.height > 0) {
                try {
                    a.this.aCs.H(a.this.aCF);
                    c Gf = a.this.Gf();
                    if (Gf.aCR == null || (Gf.aCR.getWidth() != a.this.width && Gf.aCR.getHeight() != a.this.height)) {
                        try {
                            Gf.aCR = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_8888);
                        } catch (OutOfMemoryError e) {
                            TbadkCoreApplication.m10getInst().onAppMemoryLow();
                            try {
                                Gf.aCR = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_4444);
                            } catch (OutOfMemoryError e2) {
                                TbadkCoreApplication.m10getInst().onAppMemoryLow();
                            } catch (Throwable th) {
                                BdLog.e(th.getMessage());
                            }
                        } catch (Throwable th2) {
                            BdLog.e(th2.getMessage());
                        }
                    }
                    a.this.aCs.a(Gf.aCR, null);
                    Gf.delay = a.this.aCs.I(a.this.aCF);
                    a.this.aCF++;
                    if (Gf.aCR == null) {
                        a.this.aCF++;
                    }
                    a.this.aCF %= a.this.aCB;
                    a.this.aCD.put(Gf);
                    if (a.this.aCI) {
                        a.this.mHandler.sendEmptyMessage(1);
                    }
                } catch (Exception e3) {
                    return;
                }
            }
        }
    }

    public boolean Gg() {
        return this.aCx;
    }

    public void setLoadBigImage(boolean z) {
        this.aCx = z;
    }
}
