package com.baidu.tbadk.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
import android.widget.ImageView;
import com.baidu.adp.gif.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BlockingLinkedDeque;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class DragImageView extends ImageView {
    private static final String TAG = DragImageView.class.getSimpleName();
    private static final int aVd = l.aQ(TbadkCoreApplication.getInst()) / 5;
    private int PE;
    public int aDt;
    private View.OnLongClickListener aTr;
    private e aTu;
    private int aTv;
    private boolean aUT;
    private float aUU;
    private Matrix aUV;
    private Rect aUW;
    private RectF aUX;
    private d aVc;
    private boolean bjA;
    private boolean bjB;
    private float bjC;
    private com.baidu.tbadk.widget.largeImage.logic.b bjD;
    private ImageUrlData bjE;
    private Interpolator bjF;
    private Rect bjG;
    private int bjH;
    private c bjI;
    private BlockingLinkedDeque<c> bjJ;
    private BlockingLinkedDeque<c> bjK;
    private volatile int bjL;
    private b bjM;
    private volatile long bjN;
    private volatile boolean bjO;
    private int bjb;
    private float bjc;
    private float bjd;
    private ArrayList<Float> bje;
    private float bjf;
    private float bjg;
    private float bjh;
    private boolean bji;
    private byte[] bjj;
    private int bjk;
    private int bjl;
    private g bjm;
    private View.OnClickListener bjn;
    private a bjo;
    private f bjp;
    private float bjq;
    private boolean bjr;
    private boolean bjs;
    private int bjt;
    private volatile com.baidu.adp.gif.b bju;
    private Bitmap bjv;
    private int bjw;
    private int bjx;
    private int bjy;
    private int bjz;
    private int height;
    private int mBottom;
    private float mCurrentScale;
    private GestureDetector mGestureDetector;
    public Handler mHandler;
    private Matrix mMatrix;
    private int mMode;
    private Paint mPaint;
    private float mRatio;
    private int mTop;
    private int width;

    /* loaded from: classes.dex */
    public static class c {
        public Bitmap bjY;
        public int delay;
    }

    /* loaded from: classes.dex */
    public interface d {
        void QI();

        void QJ();
    }

    /* loaded from: classes.dex */
    public interface e {
        void a(DragImageView dragImageView);
    }

    /* loaded from: classes.dex */
    public interface f {
        void a(DragImageView dragImageView, int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface g {
        void a(DragImageView dragImageView, boolean z, boolean z2);
    }

    static /* synthetic */ int B(DragImageView dragImageView) {
        int i = dragImageView.bjL;
        dragImageView.bjL = i + 1;
        return i;
    }

    public void setIsHeadImage(boolean z) {
        this.bjB = z;
    }

    public void setImageUrlData(ImageUrlData imageUrlData) {
        this.bjE = imageUrlData;
    }

    public DragImageView(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.PE = 0;
        this.bjb = 0;
        this.bji = false;
        this.bjj = null;
        this.aTv = 0;
        this.bjk = 1300;
        this.bjl = 0;
        this.bjm = null;
        this.bjn = null;
        this.aTr = null;
        this.aTu = null;
        this.bjq = 1.0f;
        this.aDt = 0;
        this.mMode = 0;
        this.bjr = false;
        this.bjs = false;
        this.bjt = 0;
        this.bju = null;
        this.bjv = null;
        this.mPaint = new Paint(-16777216);
        this.mTop = 0;
        this.mBottom = 0;
        this.bjw = 0;
        this.bjx = 0;
        this.bjy = 0;
        this.bjz = 0;
        this.bjF = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.aUV = new Matrix();
        this.aUT = false;
        this.mRatio = 1.0f;
        this.aUU = 0.0f;
        this.aUX = new RectF();
        this.width = 0;
        this.height = 0;
        this.bjH = 0;
        this.bjI = null;
        this.bjJ = new BlockingLinkedDeque<>(5);
        this.bjK = new BlockingLinkedDeque<>(6);
        this.bjL = 0;
        this.bjN = 0L;
        this.bjO = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.DragImageView.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        DragImageView.this.QE();
                        break;
                    case 1:
                        if (DragImageView.this.bjO) {
                            DragImageView.this.QE();
                            break;
                        }
                        break;
                    case 2:
                        DragImageView.this.invalidate();
                        DragImageView.this.bjN = System.currentTimeMillis();
                        DragImageView.this.mHandler.sendEmptyMessage(0);
                        break;
                }
                return false;
            }
        });
        initData();
    }

    public DragImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMatrix = new Matrix();
        this.PE = 0;
        this.bjb = 0;
        this.bji = false;
        this.bjj = null;
        this.aTv = 0;
        this.bjk = 1300;
        this.bjl = 0;
        this.bjm = null;
        this.bjn = null;
        this.aTr = null;
        this.aTu = null;
        this.bjq = 1.0f;
        this.aDt = 0;
        this.mMode = 0;
        this.bjr = false;
        this.bjs = false;
        this.bjt = 0;
        this.bju = null;
        this.bjv = null;
        this.mPaint = new Paint(-16777216);
        this.mTop = 0;
        this.mBottom = 0;
        this.bjw = 0;
        this.bjx = 0;
        this.bjy = 0;
        this.bjz = 0;
        this.bjF = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.aUV = new Matrix();
        this.aUT = false;
        this.mRatio = 1.0f;
        this.aUU = 0.0f;
        this.aUX = new RectF();
        this.width = 0;
        this.height = 0;
        this.bjH = 0;
        this.bjI = null;
        this.bjJ = new BlockingLinkedDeque<>(5);
        this.bjK = new BlockingLinkedDeque<>(6);
        this.bjL = 0;
        this.bjN = 0L;
        this.bjO = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.DragImageView.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        DragImageView.this.QE();
                        break;
                    case 1:
                        if (DragImageView.this.bjO) {
                            DragImageView.this.QE();
                            break;
                        }
                        break;
                    case 2:
                        DragImageView.this.invalidate();
                        DragImageView.this.bjN = System.currentTimeMillis();
                        DragImageView.this.mHandler.sendEmptyMessage(0);
                        break;
                }
                return false;
            }
        });
        initData();
    }

    public DragImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMatrix = new Matrix();
        this.PE = 0;
        this.bjb = 0;
        this.bji = false;
        this.bjj = null;
        this.aTv = 0;
        this.bjk = 1300;
        this.bjl = 0;
        this.bjm = null;
        this.bjn = null;
        this.aTr = null;
        this.aTu = null;
        this.bjq = 1.0f;
        this.aDt = 0;
        this.mMode = 0;
        this.bjr = false;
        this.bjs = false;
        this.bjt = 0;
        this.bju = null;
        this.bjv = null;
        this.mPaint = new Paint(-16777216);
        this.mTop = 0;
        this.mBottom = 0;
        this.bjw = 0;
        this.bjx = 0;
        this.bjy = 0;
        this.bjz = 0;
        this.bjF = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.aUV = new Matrix();
        this.aUT = false;
        this.mRatio = 1.0f;
        this.aUU = 0.0f;
        this.aUX = new RectF();
        this.width = 0;
        this.height = 0;
        this.bjH = 0;
        this.bjI = null;
        this.bjJ = new BlockingLinkedDeque<>(5);
        this.bjK = new BlockingLinkedDeque<>(6);
        this.bjL = 0;
        this.bjN = 0L;
        this.bjO = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.DragImageView.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        DragImageView.this.QE();
                        break;
                    case 1:
                        if (DragImageView.this.bjO) {
                            DragImageView.this.QE();
                            break;
                        }
                        break;
                    case 2:
                        DragImageView.this.invalidate();
                        DragImageView.this.bjN = System.currentTimeMillis();
                        DragImageView.this.mHandler.sendEmptyMessage(0);
                        break;
                }
                return false;
            }
        });
        initData();
    }

    public void setDragToExitListener(d dVar) {
        this.aVc = dVar;
    }

    public int getImageType() {
        return this.aDt;
    }

    public void setImageMode(int i) {
        this.bjl = i;
    }

    public void setOffset(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.aTv = i;
    }

    public boolean Qq() {
        if (this.bjD != null) {
            return this.bjD.Qq();
        }
        return false;
    }

    public void Qr() {
        this.bjs = false;
        this.bji = false;
        this.mMode = 3;
        Qx();
        if (this.mCurrentScale < this.bjf) {
            this.mCurrentScale = this.bjf;
            QD();
        }
        invalidate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.bjD != null && this.bjD.onTouchEvent(motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.bji = true;
                this.bjr = false;
                this.bjs = false;
                break;
            case 1:
                Qr();
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
            this.bjq = t(motionEvent);
            if (this.bjq > 10.0f) {
                this.mMode = 2;
            }
        }
        if (this.mMode == 2 || !this.mGestureDetector.onTouchEvent(motionEvent)) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.bjr = true;
                        this.bjs = true;
                        if (this.aDt != 1 && this.aDt != 2) {
                            float t = t(motionEvent);
                            if (t >= 0.0f && Math.abs(this.bjq - t) >= 10.0f) {
                                if (Math.abs(this.bjq - t) > 100.0f) {
                                    this.bjq = t;
                                    break;
                                } else {
                                    float f2 = t / this.bjq;
                                    this.bjq = t;
                                    this.bjh = this.mCurrentScale;
                                    this.mCurrentScale *= f2;
                                    if (this.mCurrentScale > this.bjg) {
                                        this.mCurrentScale = this.bjg;
                                    }
                                    float minScaleValue = getMinScaleValue();
                                    if (this.mCurrentScale < minScaleValue) {
                                        this.mCurrentScale = minScaleValue;
                                    }
                                    QD();
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

    protected float getMinScaleValue() {
        return this.bjD != null ? this.bjD.getMinScaleValue() : this.bjf / 4.0f;
    }

    public float t(MotionEvent motionEvent) {
        return CompatibleUtile.getInstance().getSpacing(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            this.PE = i3 - i;
            this.bjb = i4 - i2;
            Qt();
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public boolean Qs() {
        if (this.bjD != null) {
            return this.bjD.Rr();
        }
        return this.bjf == this.mCurrentScale;
    }

    protected float h(Bitmap bitmap) {
        if (this.bjD != null) {
            return this.bjD.Rv();
        }
        if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            return 1.0f;
        }
        if (this.bjl == 0) {
            float width = this.PE / bitmap.getWidth();
            float height = this.bjb / bitmap.getHeight();
            if (this.bjB) {
                if (this.aDt == 2) {
                    return 2.5f;
                }
                return Math.min(width, height);
            } else if (this.aDt != 2) {
                float f2 = this.bjC;
                float f3 = f2 >= 1.0f ? f2 : 1.0f;
                if (bitmap.getWidth() * f3 >= this.PE || bitmap.getHeight() * f3 >= this.bjb) {
                    return Math.min(width, height);
                }
                return f3;
            } else {
                return 1.0f;
            }
        }
        return Math.max(this.PE / bitmap.getWidth(), ((this.bjb - this.mTop) - this.mBottom) / bitmap.getHeight());
    }

    protected float i(Bitmap bitmap) {
        if (this.bjD != null) {
            return this.bjD.Rw();
        }
        float f2 = 1.0f;
        if (bitmap != null && !bitmap.isRecycled() && bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
            f2 = (float) Math.sqrt(this.bjk / (bitmap.getWidth() * bitmap.getHeight()));
            if (f2 > 10.0f) {
                return 10.0f;
            }
        }
        return f2;
    }

    private void Qt() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            this.bjf = h(imageBitmap);
            this.bjg = i(imageBitmap);
            this.bje.clear();
            this.bje.add(Float.valueOf(this.bjf));
            this.mCurrentScale = this.bjf;
            this.bjh = this.mCurrentScale;
            QD();
            return;
        }
        this.bjc = 0.0f;
        this.bjd = 0.0f;
        this.bjf = 1.0f;
        this.bjg = 1.0f;
        this.mCurrentScale = 1.0f;
        this.bjh = this.mCurrentScale;
        this.bje.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    private void Qu() {
        if (this.bjm != null) {
            this.bjm.a(this, canZoomIn(), canZoomOut());
        }
    }

    public void setOnSizeChangedListener(g gVar) {
        this.bjm = gVar;
    }

    public void setOnImageScrollListener(f fVar) {
        this.bjp = fVar;
    }

    public byte[] getImageData() {
        return this.bjj;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getMeasuredHeight() != 0 && getMeasuredWidth() != 0 && this.bjD != null) {
            this.bjD.Rt();
        }
    }

    public void setImageData(Bitmap bitmap, byte[] bArr) {
        this.bjj = bArr;
        if (this.bjD != null) {
            this.bjD.a(bitmap, bArr);
        }
        setImageBitmap(bitmap);
    }

    public void Qv() {
        if (this.bjD == null) {
            this.bjD = new com.baidu.tbadk.widget.largeImage.logic.b(this);
            this.bjD.setOnClickListener(this.bjn);
            this.bjD.setOnLongClickListener(this.aTr);
        }
    }

    public void setImageLoadCallBack(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
        if (this.bjD != null) {
            this.bjD.a(aVar);
        }
    }

    public boolean Qw() {
        return (getImageBitmap() == null || this.bjD == null) ? false : true;
    }

    public Bitmap getGifCache() {
        return this.bjv;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        boolean z;
        if (this.bjD == null || !this.bjD.b(canvas, getImageBitmap())) {
            if (this.aDt == 2 && this.bjz != 0 && !this.bjo.QH()) {
                int width = getWidth();
                int height = getHeight();
                Drawable drawable = getDrawable();
                float f2 = 0.0f;
                float f3 = height * 0.3f;
                float f4 = width;
                float f5 = (1.0f - 0.3f) * height;
                if (this.bjB && drawable != null) {
                    Rect bounds = drawable.getBounds();
                    int i = bounds.right - bounds.left;
                    int i2 = bounds.bottom - bounds.top;
                    f2 = (width / 2) - (i * 2.5f);
                    f3 = (height / 2) - (i2 * 2.5f);
                    f4 = (i * 2.5f) + (width / 2);
                    f5 = (i2 * 2.5f) + (height / 2);
                }
                this.mPaint.setColor(al.getColor(this.bjz));
                canvas.drawRect(f2, f3, f4, f5, this.mPaint);
                this.mPaint.setColor(-16777216);
            }
            if (this.mMode == 3 && this.aUT) {
                this.aUT = false;
                this.aUV.reset();
                if (this.aUU < aVd) {
                    this.mMode = 0;
                } else {
                    this.mMode = 4;
                    KC();
                }
            }
            if (this.aDt == 0 && this.aUT && this.aUW != null && this.bjE != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                if (this.aUX == null) {
                    this.aUX = new RectF();
                }
                this.aUV.mapRect(this.aUX, new RectF(this.aUW));
                Bitmap imageBitmap = getImageBitmap();
                if (imageBitmap != null && !imageBitmap.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.bjG, this.aUX, (Paint) null);
                }
            } else if (this.mMode == 4 && this.aUW != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                Bitmap imageBitmap2 = getImageBitmap();
                if (imageBitmap2 != null && !imageBitmap2.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.bjG, this.aUX, (Paint) null);
                }
            } else {
                super.onDraw(canvas);
            }
            if (this.aDt == 1 && this.bjv != null && !this.bjv.isRecycled()) {
                int width2 = this.bjv.getWidth();
                int height2 = this.bjv.getHeight();
                int width3 = getWidth();
                int height3 = getHeight();
                int i3 = (width3 - width2) >> 1;
                int i4 = (height3 - height2) >> 1;
                float f6 = this.bjC;
                if (f6 < 1.0f) {
                    f6 = 1.0f;
                }
                if (width2 * f6 >= width3 || height2 * f6 >= height3) {
                    f6 = Math.min(width3 / width2, height3 / height2);
                }
                if (Math.abs(f6 - 1.0f) < 1.0E-8f) {
                    z = true;
                } else {
                    this.mMatrix.setScale(f6, f6);
                    i3 = (int) ((width3 - (width2 * f6)) / 2.0f);
                    i4 = (int) ((height3 - (height2 * f6)) / 2.0f);
                    this.mMatrix.postTranslate(i3, i4);
                    width2 = (int) (width2 * f6);
                    height2 = (int) (f6 * height2);
                    z = false;
                }
                canvas.clipRect(i3, i4, width2 + i3, height2 + i4);
                canvas.drawColor(-1);
                if (this.bjt == 1 && this.bju != null && this.bjI != null && this.bjI.bjY != null) {
                    if (z) {
                        canvas.drawBitmap(this.bjI.bjY, i3, i4, (Paint) null);
                    } else {
                        canvas.drawBitmap(this.bjI.bjY, this.mMatrix, this.mPaint);
                    }
                    invalidate();
                } else if (z) {
                    canvas.drawBitmap(this.bjv, i3, i4, (Paint) null);
                } else {
                    canvas.drawBitmap(this.bjv, this.mMatrix, this.mPaint);
                }
            }
        }
    }

    public void play() {
        com.baidu.adp.widget.ImageView.a aVar;
        if (this.aDt == 1) {
            if (this.bju == null) {
                if (this.bjM != null) {
                    this.bjM.Et = false;
                    this.bjM.interrupt();
                    this.bjM = null;
                }
                if (this.bjj != null) {
                    try {
                        aVar = a.C0015a.hx().g(this.bjj, 0, this.bjj.length);
                    } catch (StackOverflowError e2) {
                        aVar = null;
                    }
                    if (aVar == null || aVar.getGif() == null) {
                        com.baidu.tbadk.core.d.a.a("gifplay", -1L, -1, "DragImageView.play", -1, "decode error", new Object[0]);
                        return;
                    }
                    this.bju = aVar.getGif();
                    if (this.bju != null) {
                        this.bjt = 1;
                        this.width = this.bju.getWidth();
                        this.height = this.bju.getHeight();
                        this.bjL = 0;
                        this.bjH = this.bju.getFrameCount();
                    } else {
                        this.bjt = 0;
                    }
                } else {
                    return;
                }
            }
            if (this.bju != null) {
                if (this.bjM == null || (this.bjM != null && !this.bjM.Et)) {
                    this.bjO = true;
                    this.bjM = new b();
                    this.bjJ.clear();
                    this.bjK.clear();
                    this.bjM.Et = true;
                    this.bjM.start();
                }
            }
        }
    }

    public void pause() {
        if (this.aDt == 1) {
            if (this.bjM != null) {
                this.bjM.Et = false;
                this.bjM.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.aDt == 1) {
            if (this.bjM != null) {
                this.bjM.Et = false;
                this.bjM.interrupt();
                this.bjM = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.bjO = true;
            this.bjI = null;
            this.bjK.clear();
            this.bjJ.clear();
            this.width = 0;
            this.height = 0;
            this.bjL = 0;
            this.bjH = 0;
            this.bju = null;
        }
    }

    private void initData() {
        this.bjC = l.aR(getContext());
        this.bjk = l.aQ(getContext()) * l.aO(getContext()) * 2;
        if (this.bjk < 1690000) {
            this.bjk = 1690000;
        }
        this.bjc = 0.0f;
        this.bjd = 0.0f;
        this.bje = new ArrayList<>();
        this.bjf = 1.0f;
        this.bjg = 1.0f;
        this.mCurrentScale = 1.0f;
        this.bjh = this.mCurrentScale;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.bjo = new a();
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWillNotDraw(false);
        scrollTo(0, 0);
        this.mGestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.DragImageView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                if (DragImageView.this.aDt != 2 && (Math.abs(f2) > 200.0f || Math.abs(f3) > 200.0f)) {
                    DragImageView.this.bjo.p(f2, f3);
                    DragImageView.this.startAnimation(DragImageView.this.bjo);
                }
                return super.onFling(motionEvent, motionEvent2, f2, f3);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (DragImageView.this.aDt != 1 && DragImageView.this.aDt != 2) {
                    DragImageView.this.mMode = 2;
                    if (DragImageView.this.mCurrentScale > DragImageView.this.bjf) {
                        DragImageView.this.mCurrentScale = DragImageView.this.bjf;
                        DragImageView.this.bjh = DragImageView.this.mCurrentScale;
                        DragImageView.this.QD();
                        return true;
                    }
                    DragImageView.this.mCurrentScale = DragImageView.this.bjf * 2.0f;
                    DragImageView.this.a(true, (int) motionEvent.getX(), (int) motionEvent.getY());
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (DragImageView.this.bjn != null && !DragImageView.this.bjr) {
                    DragImageView.this.bjn.onClick(DragImageView.this);
                }
                return super.onSingleTapConfirmed(motionEvent);
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x0084  */
            /* JADX WARN: Removed duplicated region for block: B:31:0x0102  */
            /* JADX WARN: Removed duplicated region for block: B:33:0x0110  */
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                int i;
                int i2;
                DragImageView.this.bjr = true;
                if (DragImageView.this.bjl == 0 && DragImageView.this.bjs) {
                    return false;
                }
                int scrollX = DragImageView.this.getScrollX();
                int scrollY = DragImageView.this.getScrollY();
                if (DragImageView.this.bjc >= DragImageView.this.getWidth()) {
                    scrollX = (int) (scrollX + f2);
                    if (DragImageView.this.bjl == 0) {
                        i = scrollX >= 0 ? scrollX : 0;
                        if (DragImageView.this.getWidth() + i > DragImageView.this.bjc) {
                            i = (int) (DragImageView.this.bjc - DragImageView.this.getWidth());
                        }
                        if (DragImageView.this.bjd + DragImageView.this.mTop + DragImageView.this.mBottom < DragImageView.this.getHeight()) {
                            i2 = (int) (scrollY + f3);
                            if (DragImageView.this.bjl == 0) {
                                if (i2 < (-DragImageView.this.bjw)) {
                                    i2 = -DragImageView.this.bjw;
                                }
                                if (DragImageView.this.getHeight() + i2 > DragImageView.this.bjd + DragImageView.this.mBottom + DragImageView.this.bjx) {
                                    i2 = (int) ((DragImageView.this.bjd - DragImageView.this.getHeight()) + DragImageView.this.mBottom + DragImageView.this.bjx);
                                }
                            }
                        } else {
                            i2 = scrollY;
                        }
                        if (i == DragImageView.this.getScrollX() || i2 != DragImageView.this.getScrollY()) {
                            DragImageView.this.scrollTo(i, i2);
                            DragImageView.this.invalidate();
                            if (DragImageView.this.bjp != null) {
                                DragImageView.this.bjp.a(DragImageView.this, i, i2);
                            }
                        }
                        return true;
                    }
                }
                i = scrollX;
                if (DragImageView.this.bjd + DragImageView.this.mTop + DragImageView.this.mBottom < DragImageView.this.getHeight()) {
                }
                if (i == DragImageView.this.getScrollX()) {
                }
                DragImageView.this.scrollTo(i, i2);
                DragImageView.this.invalidate();
                if (DragImageView.this.bjp != null) {
                }
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (DragImageView.this.aTr != null && !DragImageView.this.bjr) {
                    DragImageView.this.aTr.onLongClick(DragImageView.this);
                }
                super.onLongPress(motionEvent);
            }
        });
    }

    private void KC() {
        if (this.bjE == null) {
            if (this.aVc != null) {
                this.aVc.QJ();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.bjE.getSourceImageRectInScreen();
        if (sourceImageRectInScreen == null) {
            if (this.aVc != null) {
                this.aVc.QJ();
                return;
            }
            return;
        }
        this.aUX.bottom = (((sourceImageRectInScreen.bottom - sourceImageRectInScreen.top) / (sourceImageRectInScreen.right - sourceImageRectInScreen.left)) * (this.aUX.right - this.aUX.left)) + this.aUX.top;
        final float[] fArr = {(this.aUX.left + this.aUX.right) / 2.0f, (this.aUX.top + this.aUX.bottom) / 2.0f};
        final float[] fArr2 = {(sourceImageRectInScreen.left + sourceImageRectInScreen.right) / 2, (sourceImageRectInScreen.top + sourceImageRectInScreen.bottom) / 2};
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr[0], fArr2[0]);
        ofFloat.setDuration(150L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.DragImageView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && sourceImageRectInScreen != null) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    float animatedFraction = fArr[1] + ((fArr2[1] - fArr[1]) * valueAnimator.getAnimatedFraction());
                    DragImageView.this.aUX = DragImageView.this.h(floatValue, animatedFraction, sourceImageRectInScreen.right - sourceImageRectInScreen.left, sourceImageRectInScreen.bottom - sourceImageRectInScreen.top);
                    DragImageView.this.invalidate();
                }
            }
        });
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tbadk.widget.DragImageView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                DragImageView.this.aUT = false;
                DragImageView.this.mMode = 4;
                DragImageView.this.invalidate();
                if (DragImageView.this.aVc != null) {
                    DragImageView.this.aVc.QJ();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RectF h(float f2, float f3, float f4, float f5) {
        return new RectF(f2 - (f4 / 2.0f), f3 - (f5 / 2.0f), (f4 / 2.0f) + f2, (f5 / 2.0f) + f3);
    }

    private void Qx() {
        int i = 0;
        int scrollX = getScrollX();
        if (this.bjc >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.bjc) {
                scrollX = (int) (this.bjc - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.bjd + this.mTop + this.mBottom >= getHeight()) {
            i = scrollY < (-this.bjw) ? -this.bjw : scrollY;
            if (getHeight() + i > this.bjd + this.mBottom + this.bjx) {
                i = (int) ((this.bjd - getHeight()) + this.mBottom + this.bjx);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
            if (this.bjp != null) {
                this.bjp.a(this, scrollX, i);
            }
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.bjD != null) {
            this.bjD.Rs();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.bjc;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.bjd;
    }

    public boolean Qy() {
        if (this.aDt == 1 || this.aDt == 2) {
            return true;
        }
        return !this.bjs && getScrollX() >= ((int) (this.bjc - ((float) getWidth()))) + (-1);
    }

    public boolean Qz() {
        if (this.aDt == 1 || this.aDt == 2) {
            return true;
        }
        return !this.bjs && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.bjo.QH()) {
            this.bjo.stopAnimation();
        }
        this.bjz = 0;
        super.setImageBitmap(bitmap);
        Qt();
        this.aDt = 0;
        if (this.aUW == null) {
            int measuredWidth = getMeasuredWidth();
            float measuredWidth2 = ((1.0f * getMeasuredWidth()) / bitmap.getWidth()) * bitmap.getHeight();
            if (measuredWidth2 > getMeasuredHeight()) {
                measuredWidth2 = getMeasuredHeight();
            }
            RectF h = h(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
            this.aUW = new Rect((int) h.left, (int) h.top, (int) h.right, (int) h.bottom);
        }
        if (this.bjG == null) {
            this.bjG = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        }
    }

    public void j(Bitmap bitmap) {
        Bitmap imageBitmap = getImageBitmap();
        if (bitmap != null && !bitmap.isRecycled()) {
            if (imageBitmap != null && (imageBitmap.getWidth() != bitmap.getWidth() || imageBitmap.getHeight() != bitmap.getHeight())) {
                setImageBitmap(bitmap);
                super.setImageMatrix(this.mMatrix);
                return;
            }
            if (this.bjo.QH()) {
                this.bjo.stopAnimation();
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            super.setImageBitmap(bitmap);
            super.setImageMatrix(this.mMatrix);
            scrollTo(scrollX, scrollY);
            this.aDt = 0;
        }
    }

    public void setGifData(byte[] bArr, Bitmap bitmap) {
        if (this.bjo.QH()) {
            this.bjo.stopAnimation();
        }
        super.setImageDrawable(null);
        stop();
        Qt();
        this.aDt = 1;
        this.bjv = bitmap;
        this.bjj = bArr;
        if (this.aTu != null) {
            this.aTu.a(this);
        }
    }

    public void onDestroy() {
        if (this.bjo.QH()) {
            this.bjo.stopAnimation();
        }
        super.setImageDrawable(null);
        this.bjj = null;
        this.bjv = null;
        stop();
        if (this.bju != null) {
            this.bju.close();
            this.bju = null;
        }
        if (this.bjD != null) {
            this.bjD.release();
            System.gc();
        }
    }

    public void release() {
        if (this.bjo.QH()) {
            this.bjo.stopAnimation();
        }
        stop();
        super.setImageDrawable(null);
        this.bjv = null;
    }

    public void setDefaultBitmap() {
        if (this.bjo.QH()) {
            this.bjo.stopAnimation();
        }
        try {
            if (this.bjB) {
                super.setImageBitmap(BitmapHelper.getCashBitmap(e.f.icon_default_avatar100));
            } else {
                super.setImageBitmap(BitmapHelper.getCashBitmap(e.f.btn_see_default));
            }
        } catch (OutOfMemoryError e2) {
            TbadkCoreApplication.getInst().onAppMemoryLow();
            System.gc();
            super.setImageBitmap(null);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
        this.aDt = 2;
        Qt();
    }

    public void QA() {
        if (this.aDt != 1 && this.aDt != 2) {
            int size = this.bje.size();
            if (size > 0) {
                this.bje.add(Float.valueOf(this.bje.get(size - 1).floatValue() * 1.25f));
            } else {
                this.bje.add(Float.valueOf(this.bjf));
            }
            QD();
        }
    }

    public void QB() {
        if (this.aDt != 1 && this.aDt != 2) {
            int size = this.bje.size();
            if (size > 1) {
                this.bje.remove(size - 1);
            }
            QD();
        }
    }

    public void QC() {
        Qu();
        if (this.aDt != 1 && this.aDt != 2 && this.mCurrentScale != this.bjf) {
            this.bje.clear();
            this.bje.add(Float.valueOf(this.bjf));
            this.mCurrentScale = this.bjf;
            this.bjh = this.mCurrentScale;
            QD();
        }
    }

    public boolean canZoomIn() {
        if (this.aDt == 1 || this.aDt == 2) {
            return false;
        }
        int size = this.bje.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.bje.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.bjk) && floatValue <= 5.0f;
    }

    public boolean canZoomOut() {
        if (this.aDt == 1 || this.aDt == 2) {
            return false;
        }
        int size = this.bje.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled()) {
            return false;
        }
        return size > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QD() {
        a(false, -1, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, int i, int i2) {
        float f2;
        float f3;
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled()) {
            try {
                if (this.mMode != 2) {
                    int size = this.bje.size();
                    if (size > 0) {
                        f3 = this.bje.get(size - 1).floatValue();
                    } else {
                        f3 = this.bjf;
                    }
                    this.mCurrentScale = f3;
                }
                this.mMatrix.setScale(this.mCurrentScale, this.mCurrentScale);
                this.bjc = imageBitmap.getWidth() * this.mCurrentScale;
                this.bjd = imageBitmap.getHeight() * this.mCurrentScale;
                float width = this.bjh * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.bjh;
                this.bjw = this.mTop;
                this.bjx = 0;
                float f4 = this.bjc < ((float) this.PE) ? (int) ((this.PE - this.bjc) / 2.0f) : 0.0f;
                if (this.bjd < this.bjb) {
                    f2 = (int) ((this.bjb - this.bjd) / 2.0f);
                    if (this.bjl == 1 && f2 > this.mTop) {
                        f2 = this.mTop;
                    }
                    this.bjw = (int) (this.mTop - f2);
                    this.bjx = this.mTop - this.bjw;
                } else {
                    f2 = 0.0f;
                }
                this.bjy = (int) f4;
                this.mMatrix.postTranslate(f4, f2);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    int width2 = i > getWidth() ? getWidth() : i;
                    if (this.bjc <= screenWidth) {
                        width2 = 0;
                    } else if (this.bjc > screenWidth && this.bjc / 2.0f < screenWidth) {
                        width2 = (int) (width2 - (this.bjc / 4.0f));
                    }
                    scrollX = width2;
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.bjc - width) / 2.0f);
                    }
                    if (this.bjc <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.bjc) {
                        scrollX = (int) (this.bjc - getWidth());
                    }
                }
                if (scrollX > 0 && this.bjc - scrollX < getWidth()) {
                    scrollX = (int) (this.bjc - getWidth());
                }
                int i3 = this.mMode == 2 ? ((int) ((this.bjd - height) / 2.0f)) + scrollY : scrollY;
                if (this.bjd <= getHeight()) {
                    i3 = 0;
                } else if (getHeight() + i3 > this.bjd) {
                    i3 = (int) (this.bjd - getHeight());
                }
                setHorizontalScrollBarEnabled(false);
                setVerticalScrollBarEnabled(false);
                if (scrollX < 0) {
                    scrollX = 0;
                }
                scrollTo(scrollX, i3 >= 0 ? i3 : 0);
                setImageMatrix(this.mMatrix);
                Qu();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Animation {
        private boolean bjS = false;
        private boolean bjT = false;
        private long bjU;
        private long bjV;
        private long bjW;
        private long bjX;
        private int mStartX;
        private int mStartY;

        public a() {
        }

        public void p(float f, float f2) {
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
            this.bjU = f;
            this.bjV = f2;
            this.bjW = Math.abs((f * 1000.0f) / 2500.0f);
            this.bjX = Math.abs((f2 * 1000.0f) / 2500.0f);
            setDuration(Math.max(this.bjW, this.bjX));
            setInterpolator(DragImageView.this.bjF);
            this.mStartX = DragImageView.this.getScrollX();
            this.mStartY = DragImageView.this.getScrollY();
            this.bjS = true;
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
            if (this.bjW > this.bjX) {
                j = ((float) this.bjW) * f;
            } else {
                j = ((float) this.bjX) * f;
            }
            float f2 = ((float) (j > this.bjW ? this.bjW : j)) / 1000.0f;
            if (this.bjU > 0) {
                i = this.mStartX - ((int) (f2 * (((float) this.bjU) - ((2500.0f * f2) / 2.0f))));
            } else {
                i = this.mStartX - ((int) (f2 * (((float) this.bjU) + ((2500.0f * f2) / 2.0f))));
            }
            if (j > this.bjX) {
                j = this.bjX;
            }
            float f3 = ((float) j) / 1000.0f;
            if (this.bjV > 0) {
                i2 = this.mStartY - ((int) (f3 * (((float) this.bjV) - ((2500.0f * f3) / 2.0f))));
            } else {
                i2 = this.mStartY - ((int) (f3 * (((float) this.bjV) + ((2500.0f * f3) / 2.0f))));
            }
            if (DragImageView.this.bjd + DragImageView.this.mTop + DragImageView.this.mBottom > DragImageView.this.getHeight()) {
                if (i2 < (-DragImageView.this.bjw)) {
                    i2 = -DragImageView.this.bjw;
                }
                if (DragImageView.this.getHeight() + i2 > DragImageView.this.bjd + DragImageView.this.mBottom + DragImageView.this.bjx) {
                    i2 = (int) ((DragImageView.this.bjd - DragImageView.this.getHeight()) + DragImageView.this.mBottom + DragImageView.this.bjx);
                }
            } else {
                i2 = 0;
            }
            if (DragImageView.this.bjc > DragImageView.this.getWidth()) {
                int width = ((float) (DragImageView.this.getWidth() + i)) > DragImageView.this.bjc ? (int) (DragImageView.this.bjc - DragImageView.this.getWidth()) : i;
                if (width >= 0) {
                    i3 = width;
                }
            }
            DragImageView.this.scrollTo(i3, i2);
            DragImageView.this.invalidate();
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            if (!this.bjT) {
                if (DragImageView.this.bji) {
                    this.bjS = false;
                    return false;
                }
                try {
                    if (super.getTransformation(j, transformation)) {
                        return true;
                    }
                    this.bjS = false;
                    return false;
                } catch (Exception e) {
                    this.bjS = false;
                    return false;
                }
            }
            this.bjT = false;
            this.bjS = false;
            return false;
        }

        public boolean QH() {
            return this.bjS;
        }

        public void stopAnimation() {
            this.bjT = true;
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.bjn = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aTr = onLongClickListener;
        if (this.bjD != null) {
            this.bjD.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setGifSetListener(e eVar) {
        this.aTu = eVar;
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
    public void QE() {
        long j;
        c poll = this.bjJ.poll();
        if (poll == null) {
            this.bjO = true;
            return;
        }
        this.bjO = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.bjI != null) {
            j = this.bjI.delay - (currentTimeMillis - this.bjN);
            this.bjK.offer(this.bjI);
        } else {
            j = 0;
        }
        this.bjI = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public c QF() {
        c poll = this.bjK.poll();
        if (poll == null) {
            poll = new c();
            try {
                poll.bjY = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
            } catch (OutOfMemoryError e2) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
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

    public c getCurrentFrame() {
        return this.bjI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends Thread {
        private volatile boolean Et;

        private b() {
            this.Et = false;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (this.Et && DragImageView.this.bju != null && DragImageView.this.bjH > 0 && DragImageView.this.width > 0 && DragImageView.this.height > 0) {
                try {
                    DragImageView.this.bju.am(DragImageView.this.bjL);
                    c QF = DragImageView.this.QF();
                    if (QF.bjY == null || (QF.bjY.getWidth() != DragImageView.this.width && QF.bjY.getHeight() != DragImageView.this.height)) {
                        try {
                            QF.bjY = Bitmap.createBitmap(DragImageView.this.width, DragImageView.this.height, Bitmap.Config.ARGB_8888);
                        } catch (OutOfMemoryError e) {
                            TbadkCoreApplication.getInst().onAppMemoryLow();
                            try {
                                QF.bjY = Bitmap.createBitmap(DragImageView.this.width, DragImageView.this.height, Bitmap.Config.ARGB_4444);
                            } catch (OutOfMemoryError e2) {
                                TbadkCoreApplication.getInst().onAppMemoryLow();
                            } catch (Throwable th) {
                                BdLog.e(th.getMessage());
                            }
                        } catch (Throwable th2) {
                            BdLog.e(th2.getMessage());
                        }
                    }
                    DragImageView.this.bju.a(QF.bjY, null);
                    QF.delay = DragImageView.this.bju.an(DragImageView.this.bjL);
                    DragImageView.B(DragImageView.this);
                    if (QF.bjY == null) {
                        DragImageView.B(DragImageView.this);
                    }
                    DragImageView.this.bjL %= DragImageView.this.bjH;
                    DragImageView.this.bjJ.put(QF);
                    if (DragImageView.this.bjO) {
                        DragImageView.this.mHandler.sendEmptyMessage(1);
                    }
                } catch (Exception e3) {
                    return;
                }
            }
        }
    }

    public boolean QG() {
        return this.bjA;
    }

    public void setLoadBigImage(boolean z) {
        this.bjA = z;
    }

    public int getBottomOffset() {
        return this.bjx;
    }

    public int getLeftOffset() {
        return this.bjy;
    }
}
