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
    private static final int aVa = l.aQ(TbadkCoreApplication.getInst()) / 5;
    private int PE;
    public int aDs;
    private View.OnLongClickListener aTo;
    private e aTr;
    private int aTs;
    private boolean aUQ;
    private float aUR;
    private Matrix aUS;
    private Rect aUT;
    private RectF aUU;
    private d aUZ;
    private int biY;
    private float biZ;
    private com.baidu.tbadk.widget.largeImage.logic.b bjA;
    private ImageUrlData bjB;
    private Interpolator bjC;
    private Rect bjD;
    private int bjE;
    private c bjF;
    private BlockingLinkedDeque<c> bjG;
    private BlockingLinkedDeque<c> bjH;
    private volatile int bjI;
    private b bjJ;
    private volatile long bjK;
    private volatile boolean bjL;
    private float bja;
    private ArrayList<Float> bjb;
    private float bjc;
    private float bjd;
    private float bje;
    private boolean bjf;
    private byte[] bjg;
    private int bjh;
    private int bji;
    private g bjj;
    private View.OnClickListener bjk;
    private a bjl;
    private f bjm;
    private float bjn;
    private boolean bjo;
    private boolean bjp;
    private int bjq;
    private volatile com.baidu.adp.gif.b bjr;
    private Bitmap bjs;
    private int bjt;
    private int bju;
    private int bjv;
    private int bjw;
    private boolean bjx;
    private boolean bjy;
    private float bjz;
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
        public Bitmap bjV;
        public int delay;
    }

    /* loaded from: classes.dex */
    public interface d {
        void QG();

        void QH();
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
        int i = dragImageView.bjI;
        dragImageView.bjI = i + 1;
        return i;
    }

    public void setIsHeadImage(boolean z) {
        this.bjy = z;
    }

    public void setImageUrlData(ImageUrlData imageUrlData) {
        this.bjB = imageUrlData;
    }

    public DragImageView(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.PE = 0;
        this.biY = 0;
        this.bjf = false;
        this.bjg = null;
        this.aTs = 0;
        this.bjh = 1300;
        this.bji = 0;
        this.bjj = null;
        this.bjk = null;
        this.aTo = null;
        this.aTr = null;
        this.bjn = 1.0f;
        this.aDs = 0;
        this.mMode = 0;
        this.bjo = false;
        this.bjp = false;
        this.bjq = 0;
        this.bjr = null;
        this.bjs = null;
        this.mPaint = new Paint(-16777216);
        this.mTop = 0;
        this.mBottom = 0;
        this.bjt = 0;
        this.bju = 0;
        this.bjv = 0;
        this.bjw = 0;
        this.bjC = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.aUS = new Matrix();
        this.aUQ = false;
        this.mRatio = 1.0f;
        this.aUR = 0.0f;
        this.aUU = new RectF();
        this.width = 0;
        this.height = 0;
        this.bjE = 0;
        this.bjF = null;
        this.bjG = new BlockingLinkedDeque<>(5);
        this.bjH = new BlockingLinkedDeque<>(6);
        this.bjI = 0;
        this.bjK = 0L;
        this.bjL = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.DragImageView.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        DragImageView.this.QC();
                        break;
                    case 1:
                        if (DragImageView.this.bjL) {
                            DragImageView.this.QC();
                            break;
                        }
                        break;
                    case 2:
                        DragImageView.this.invalidate();
                        DragImageView.this.bjK = System.currentTimeMillis();
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
        this.biY = 0;
        this.bjf = false;
        this.bjg = null;
        this.aTs = 0;
        this.bjh = 1300;
        this.bji = 0;
        this.bjj = null;
        this.bjk = null;
        this.aTo = null;
        this.aTr = null;
        this.bjn = 1.0f;
        this.aDs = 0;
        this.mMode = 0;
        this.bjo = false;
        this.bjp = false;
        this.bjq = 0;
        this.bjr = null;
        this.bjs = null;
        this.mPaint = new Paint(-16777216);
        this.mTop = 0;
        this.mBottom = 0;
        this.bjt = 0;
        this.bju = 0;
        this.bjv = 0;
        this.bjw = 0;
        this.bjC = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.aUS = new Matrix();
        this.aUQ = false;
        this.mRatio = 1.0f;
        this.aUR = 0.0f;
        this.aUU = new RectF();
        this.width = 0;
        this.height = 0;
        this.bjE = 0;
        this.bjF = null;
        this.bjG = new BlockingLinkedDeque<>(5);
        this.bjH = new BlockingLinkedDeque<>(6);
        this.bjI = 0;
        this.bjK = 0L;
        this.bjL = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.DragImageView.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        DragImageView.this.QC();
                        break;
                    case 1:
                        if (DragImageView.this.bjL) {
                            DragImageView.this.QC();
                            break;
                        }
                        break;
                    case 2:
                        DragImageView.this.invalidate();
                        DragImageView.this.bjK = System.currentTimeMillis();
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
        this.biY = 0;
        this.bjf = false;
        this.bjg = null;
        this.aTs = 0;
        this.bjh = 1300;
        this.bji = 0;
        this.bjj = null;
        this.bjk = null;
        this.aTo = null;
        this.aTr = null;
        this.bjn = 1.0f;
        this.aDs = 0;
        this.mMode = 0;
        this.bjo = false;
        this.bjp = false;
        this.bjq = 0;
        this.bjr = null;
        this.bjs = null;
        this.mPaint = new Paint(-16777216);
        this.mTop = 0;
        this.mBottom = 0;
        this.bjt = 0;
        this.bju = 0;
        this.bjv = 0;
        this.bjw = 0;
        this.bjC = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.aUS = new Matrix();
        this.aUQ = false;
        this.mRatio = 1.0f;
        this.aUR = 0.0f;
        this.aUU = new RectF();
        this.width = 0;
        this.height = 0;
        this.bjE = 0;
        this.bjF = null;
        this.bjG = new BlockingLinkedDeque<>(5);
        this.bjH = new BlockingLinkedDeque<>(6);
        this.bjI = 0;
        this.bjK = 0L;
        this.bjL = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.DragImageView.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        DragImageView.this.QC();
                        break;
                    case 1:
                        if (DragImageView.this.bjL) {
                            DragImageView.this.QC();
                            break;
                        }
                        break;
                    case 2:
                        DragImageView.this.invalidate();
                        DragImageView.this.bjK = System.currentTimeMillis();
                        DragImageView.this.mHandler.sendEmptyMessage(0);
                        break;
                }
                return false;
            }
        });
        initData();
    }

    public void setDragToExitListener(d dVar) {
        this.aUZ = dVar;
    }

    public int getImageType() {
        return this.aDs;
    }

    public void setImageMode(int i) {
        this.bji = i;
    }

    public void setOffset(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.aTs = i;
    }

    public boolean Qo() {
        if (this.bjA != null) {
            return this.bjA.Qo();
        }
        return false;
    }

    public void Qp() {
        this.bjp = false;
        this.bjf = false;
        this.mMode = 3;
        Qv();
        if (this.mCurrentScale < this.bjc) {
            this.mCurrentScale = this.bjc;
            QB();
        }
        invalidate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.bjA != null && this.bjA.onTouchEvent(motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.bjf = true;
                this.bjo = false;
                this.bjp = false;
                break;
            case 1:
                Qp();
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
            this.bjn = t(motionEvent);
            if (this.bjn > 10.0f) {
                this.mMode = 2;
            }
        }
        if (this.mMode == 2 || !this.mGestureDetector.onTouchEvent(motionEvent)) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.bjo = true;
                        this.bjp = true;
                        if (this.aDs != 1 && this.aDs != 2) {
                            float t = t(motionEvent);
                            if (t >= 0.0f && Math.abs(this.bjn - t) >= 10.0f) {
                                if (Math.abs(this.bjn - t) > 100.0f) {
                                    this.bjn = t;
                                    break;
                                } else {
                                    float f2 = t / this.bjn;
                                    this.bjn = t;
                                    this.bje = this.mCurrentScale;
                                    this.mCurrentScale *= f2;
                                    if (this.mCurrentScale > this.bjd) {
                                        this.mCurrentScale = this.bjd;
                                    }
                                    float minScaleValue = getMinScaleValue();
                                    if (this.mCurrentScale < minScaleValue) {
                                        this.mCurrentScale = minScaleValue;
                                    }
                                    QB();
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
        return this.bjA != null ? this.bjA.getMinScaleValue() : this.bjc / 4.0f;
    }

    public float t(MotionEvent motionEvent) {
        return CompatibleUtile.getInstance().getSpacing(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            this.PE = i3 - i;
            this.biY = i4 - i2;
            Qr();
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public boolean Qq() {
        if (this.bjA != null) {
            return this.bjA.Rp();
        }
        return this.bjc == this.mCurrentScale;
    }

    protected float h(Bitmap bitmap) {
        if (this.bjA != null) {
            return this.bjA.Rt();
        }
        if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            return 1.0f;
        }
        if (this.bji == 0) {
            float width = this.PE / bitmap.getWidth();
            float height = this.biY / bitmap.getHeight();
            if (this.bjy) {
                if (this.aDs == 2) {
                    return 2.5f;
                }
                return Math.min(width, height);
            } else if (this.aDs != 2) {
                float f2 = this.bjz;
                float f3 = f2 >= 1.0f ? f2 : 1.0f;
                if (bitmap.getWidth() * f3 >= this.PE || bitmap.getHeight() * f3 >= this.biY) {
                    return Math.min(width, height);
                }
                return f3;
            } else {
                return 1.0f;
            }
        }
        return Math.max(this.PE / bitmap.getWidth(), ((this.biY - this.mTop) - this.mBottom) / bitmap.getHeight());
    }

    protected float i(Bitmap bitmap) {
        if (this.bjA != null) {
            return this.bjA.Ru();
        }
        float f2 = 1.0f;
        if (bitmap != null && !bitmap.isRecycled() && bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
            f2 = (float) Math.sqrt(this.bjh / (bitmap.getWidth() * bitmap.getHeight()));
            if (f2 > 10.0f) {
                return 10.0f;
            }
        }
        return f2;
    }

    private void Qr() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            this.bjc = h(imageBitmap);
            this.bjd = i(imageBitmap);
            this.bjb.clear();
            this.bjb.add(Float.valueOf(this.bjc));
            this.mCurrentScale = this.bjc;
            this.bje = this.mCurrentScale;
            QB();
            return;
        }
        this.biZ = 0.0f;
        this.bja = 0.0f;
        this.bjc = 1.0f;
        this.bjd = 1.0f;
        this.mCurrentScale = 1.0f;
        this.bje = this.mCurrentScale;
        this.bjb.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    private void Qs() {
        if (this.bjj != null) {
            this.bjj.a(this, canZoomIn(), canZoomOut());
        }
    }

    public void setOnSizeChangedListener(g gVar) {
        this.bjj = gVar;
    }

    public void setOnImageScrollListener(f fVar) {
        this.bjm = fVar;
    }

    public byte[] getImageData() {
        return this.bjg;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getMeasuredHeight() != 0 && getMeasuredWidth() != 0 && this.bjA != null) {
            this.bjA.Rr();
        }
    }

    public void setImageData(Bitmap bitmap, byte[] bArr) {
        this.bjg = bArr;
        if (this.bjA != null) {
            this.bjA.a(bitmap, bArr);
        }
        setImageBitmap(bitmap);
    }

    public void Qt() {
        if (this.bjA == null) {
            this.bjA = new com.baidu.tbadk.widget.largeImage.logic.b(this);
            this.bjA.setOnClickListener(this.bjk);
            this.bjA.setOnLongClickListener(this.aTo);
        }
    }

    public void setImageLoadCallBack(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
        if (this.bjA != null) {
            this.bjA.a(aVar);
        }
    }

    public boolean Qu() {
        return (getImageBitmap() == null || this.bjA == null) ? false : true;
    }

    public Bitmap getGifCache() {
        return this.bjs;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        boolean z;
        if (this.bjA == null || !this.bjA.b(canvas, getImageBitmap())) {
            if (this.aDs == 2 && this.bjw != 0 && !this.bjl.QF()) {
                int width = getWidth();
                int height = getHeight();
                Drawable drawable = getDrawable();
                float f2 = 0.0f;
                float f3 = height * 0.3f;
                float f4 = width;
                float f5 = (1.0f - 0.3f) * height;
                if (this.bjy && drawable != null) {
                    Rect bounds = drawable.getBounds();
                    int i = bounds.right - bounds.left;
                    int i2 = bounds.bottom - bounds.top;
                    f2 = (width / 2) - (i * 2.5f);
                    f3 = (height / 2) - (i2 * 2.5f);
                    f4 = (i * 2.5f) + (width / 2);
                    f5 = (i2 * 2.5f) + (height / 2);
                }
                this.mPaint.setColor(al.getColor(this.bjw));
                canvas.drawRect(f2, f3, f4, f5, this.mPaint);
                this.mPaint.setColor(-16777216);
            }
            if (this.mMode == 3 && this.aUQ) {
                this.aUQ = false;
                this.aUS.reset();
                if (this.aUR < aVa) {
                    this.mMode = 0;
                } else {
                    this.mMode = 4;
                    KB();
                }
            }
            if (this.aDs == 0 && this.aUQ && this.aUT != null && this.bjB != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                if (this.aUU == null) {
                    this.aUU = new RectF();
                }
                this.aUS.mapRect(this.aUU, new RectF(this.aUT));
                Bitmap imageBitmap = getImageBitmap();
                if (imageBitmap != null && !imageBitmap.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.bjD, this.aUU, (Paint) null);
                }
            } else if (this.mMode == 4 && this.aUT != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                Bitmap imageBitmap2 = getImageBitmap();
                if (imageBitmap2 != null && !imageBitmap2.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.bjD, this.aUU, (Paint) null);
                }
            } else {
                super.onDraw(canvas);
            }
            if (this.aDs == 1 && this.bjs != null && !this.bjs.isRecycled()) {
                int width2 = this.bjs.getWidth();
                int height2 = this.bjs.getHeight();
                int width3 = getWidth();
                int height3 = getHeight();
                int i3 = (width3 - width2) >> 1;
                int i4 = (height3 - height2) >> 1;
                float f6 = this.bjz;
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
                if (this.bjq == 1 && this.bjr != null && this.bjF != null && this.bjF.bjV != null) {
                    if (z) {
                        canvas.drawBitmap(this.bjF.bjV, i3, i4, (Paint) null);
                    } else {
                        canvas.drawBitmap(this.bjF.bjV, this.mMatrix, this.mPaint);
                    }
                    invalidate();
                } else if (z) {
                    canvas.drawBitmap(this.bjs, i3, i4, (Paint) null);
                } else {
                    canvas.drawBitmap(this.bjs, this.mMatrix, this.mPaint);
                }
            }
        }
    }

    public void play() {
        com.baidu.adp.widget.ImageView.a aVar;
        if (this.aDs == 1) {
            if (this.bjr == null) {
                if (this.bjJ != null) {
                    this.bjJ.Et = false;
                    this.bjJ.interrupt();
                    this.bjJ = null;
                }
                if (this.bjg != null) {
                    try {
                        aVar = a.C0015a.hx().g(this.bjg, 0, this.bjg.length);
                    } catch (StackOverflowError e2) {
                        aVar = null;
                    }
                    if (aVar == null || aVar.getGif() == null) {
                        com.baidu.tbadk.core.d.a.a("gifplay", -1L, -1, "DragImageView.play", -1, "decode error", new Object[0]);
                        return;
                    }
                    this.bjr = aVar.getGif();
                    if (this.bjr != null) {
                        this.bjq = 1;
                        this.width = this.bjr.getWidth();
                        this.height = this.bjr.getHeight();
                        this.bjI = 0;
                        this.bjE = this.bjr.getFrameCount();
                    } else {
                        this.bjq = 0;
                    }
                } else {
                    return;
                }
            }
            if (this.bjr != null) {
                if (this.bjJ == null || (this.bjJ != null && !this.bjJ.Et)) {
                    this.bjL = true;
                    this.bjJ = new b();
                    this.bjG.clear();
                    this.bjH.clear();
                    this.bjJ.Et = true;
                    this.bjJ.start();
                }
            }
        }
    }

    public void pause() {
        if (this.aDs == 1) {
            if (this.bjJ != null) {
                this.bjJ.Et = false;
                this.bjJ.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.aDs == 1) {
            if (this.bjJ != null) {
                this.bjJ.Et = false;
                this.bjJ.interrupt();
                this.bjJ = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.bjL = true;
            this.bjF = null;
            this.bjH.clear();
            this.bjG.clear();
            this.width = 0;
            this.height = 0;
            this.bjI = 0;
            this.bjE = 0;
            this.bjr = null;
        }
    }

    private void initData() {
        this.bjz = l.aR(getContext());
        this.bjh = l.aQ(getContext()) * l.aO(getContext()) * 2;
        if (this.bjh < 1690000) {
            this.bjh = 1690000;
        }
        this.biZ = 0.0f;
        this.bja = 0.0f;
        this.bjb = new ArrayList<>();
        this.bjc = 1.0f;
        this.bjd = 1.0f;
        this.mCurrentScale = 1.0f;
        this.bje = this.mCurrentScale;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.bjl = new a();
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWillNotDraw(false);
        scrollTo(0, 0);
        this.mGestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.DragImageView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                if (DragImageView.this.aDs != 2 && (Math.abs(f2) > 200.0f || Math.abs(f3) > 200.0f)) {
                    DragImageView.this.bjl.p(f2, f3);
                    DragImageView.this.startAnimation(DragImageView.this.bjl);
                }
                return super.onFling(motionEvent, motionEvent2, f2, f3);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (DragImageView.this.aDs != 1 && DragImageView.this.aDs != 2) {
                    DragImageView.this.mMode = 2;
                    if (DragImageView.this.mCurrentScale > DragImageView.this.bjc) {
                        DragImageView.this.mCurrentScale = DragImageView.this.bjc;
                        DragImageView.this.bje = DragImageView.this.mCurrentScale;
                        DragImageView.this.QB();
                        return true;
                    }
                    DragImageView.this.mCurrentScale = DragImageView.this.bjc * 2.0f;
                    DragImageView.this.a(true, (int) motionEvent.getX(), (int) motionEvent.getY());
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (DragImageView.this.bjk != null && !DragImageView.this.bjo) {
                    DragImageView.this.bjk.onClick(DragImageView.this);
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
                DragImageView.this.bjo = true;
                if (DragImageView.this.bji == 0 && DragImageView.this.bjp) {
                    return false;
                }
                int scrollX = DragImageView.this.getScrollX();
                int scrollY = DragImageView.this.getScrollY();
                if (DragImageView.this.biZ >= DragImageView.this.getWidth()) {
                    scrollX = (int) (scrollX + f2);
                    if (DragImageView.this.bji == 0) {
                        i = scrollX >= 0 ? scrollX : 0;
                        if (DragImageView.this.getWidth() + i > DragImageView.this.biZ) {
                            i = (int) (DragImageView.this.biZ - DragImageView.this.getWidth());
                        }
                        if (DragImageView.this.bja + DragImageView.this.mTop + DragImageView.this.mBottom < DragImageView.this.getHeight()) {
                            i2 = (int) (scrollY + f3);
                            if (DragImageView.this.bji == 0) {
                                if (i2 < (-DragImageView.this.bjt)) {
                                    i2 = -DragImageView.this.bjt;
                                }
                                if (DragImageView.this.getHeight() + i2 > DragImageView.this.bja + DragImageView.this.mBottom + DragImageView.this.bju) {
                                    i2 = (int) ((DragImageView.this.bja - DragImageView.this.getHeight()) + DragImageView.this.mBottom + DragImageView.this.bju);
                                }
                            }
                        } else {
                            i2 = scrollY;
                        }
                        if (i == DragImageView.this.getScrollX() || i2 != DragImageView.this.getScrollY()) {
                            DragImageView.this.scrollTo(i, i2);
                            DragImageView.this.invalidate();
                            if (DragImageView.this.bjm != null) {
                                DragImageView.this.bjm.a(DragImageView.this, i, i2);
                            }
                        }
                        return true;
                    }
                }
                i = scrollX;
                if (DragImageView.this.bja + DragImageView.this.mTop + DragImageView.this.mBottom < DragImageView.this.getHeight()) {
                }
                if (i == DragImageView.this.getScrollX()) {
                }
                DragImageView.this.scrollTo(i, i2);
                DragImageView.this.invalidate();
                if (DragImageView.this.bjm != null) {
                }
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (DragImageView.this.aTo != null && !DragImageView.this.bjo) {
                    DragImageView.this.aTo.onLongClick(DragImageView.this);
                }
                super.onLongPress(motionEvent);
            }
        });
    }

    private void KB() {
        if (this.bjB == null) {
            if (this.aUZ != null) {
                this.aUZ.QH();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.bjB.getSourceImageRectInScreen();
        if (sourceImageRectInScreen == null) {
            if (this.aUZ != null) {
                this.aUZ.QH();
                return;
            }
            return;
        }
        this.aUU.bottom = (((sourceImageRectInScreen.bottom - sourceImageRectInScreen.top) / (sourceImageRectInScreen.right - sourceImageRectInScreen.left)) * (this.aUU.right - this.aUU.left)) + this.aUU.top;
        final float[] fArr = {(this.aUU.left + this.aUU.right) / 2.0f, (this.aUU.top + this.aUU.bottom) / 2.0f};
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
                    DragImageView.this.aUU = DragImageView.this.h(floatValue, animatedFraction, sourceImageRectInScreen.right - sourceImageRectInScreen.left, sourceImageRectInScreen.bottom - sourceImageRectInScreen.top);
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
                DragImageView.this.aUQ = false;
                DragImageView.this.mMode = 4;
                DragImageView.this.invalidate();
                if (DragImageView.this.aUZ != null) {
                    DragImageView.this.aUZ.QH();
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

    private void Qv() {
        int i = 0;
        int scrollX = getScrollX();
        if (this.biZ >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.biZ) {
                scrollX = (int) (this.biZ - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.bja + this.mTop + this.mBottom >= getHeight()) {
            i = scrollY < (-this.bjt) ? -this.bjt : scrollY;
            if (getHeight() + i > this.bja + this.mBottom + this.bju) {
                i = (int) ((this.bja - getHeight()) + this.mBottom + this.bju);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
            if (this.bjm != null) {
                this.bjm.a(this, scrollX, i);
            }
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.bjA != null) {
            this.bjA.Rq();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.biZ;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.bja;
    }

    public boolean Qw() {
        if (this.aDs == 1 || this.aDs == 2) {
            return true;
        }
        return !this.bjp && getScrollX() >= ((int) (this.biZ - ((float) getWidth()))) + (-1);
    }

    public boolean Qx() {
        if (this.aDs == 1 || this.aDs == 2) {
            return true;
        }
        return !this.bjp && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.bjl.QF()) {
            this.bjl.stopAnimation();
        }
        this.bjw = 0;
        super.setImageBitmap(bitmap);
        Qr();
        this.aDs = 0;
        if (this.aUT == null) {
            int measuredWidth = getMeasuredWidth();
            float measuredWidth2 = ((1.0f * getMeasuredWidth()) / bitmap.getWidth()) * bitmap.getHeight();
            if (measuredWidth2 > getMeasuredHeight()) {
                measuredWidth2 = getMeasuredHeight();
            }
            RectF h = h(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
            this.aUT = new Rect((int) h.left, (int) h.top, (int) h.right, (int) h.bottom);
        }
        if (this.bjD == null) {
            this.bjD = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
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
            if (this.bjl.QF()) {
                this.bjl.stopAnimation();
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            super.setImageBitmap(bitmap);
            super.setImageMatrix(this.mMatrix);
            scrollTo(scrollX, scrollY);
            this.aDs = 0;
        }
    }

    public void setGifData(byte[] bArr, Bitmap bitmap) {
        if (this.bjl.QF()) {
            this.bjl.stopAnimation();
        }
        super.setImageDrawable(null);
        stop();
        Qr();
        this.aDs = 1;
        this.bjs = bitmap;
        this.bjg = bArr;
        if (this.aTr != null) {
            this.aTr.a(this);
        }
    }

    public void onDestroy() {
        if (this.bjl.QF()) {
            this.bjl.stopAnimation();
        }
        super.setImageDrawable(null);
        this.bjg = null;
        this.bjs = null;
        stop();
        if (this.bjr != null) {
            this.bjr.close();
            this.bjr = null;
        }
        if (this.bjA != null) {
            this.bjA.release();
            System.gc();
        }
    }

    public void release() {
        if (this.bjl.QF()) {
            this.bjl.stopAnimation();
        }
        stop();
        super.setImageDrawable(null);
        this.bjs = null;
    }

    public void setDefaultBitmap() {
        if (this.bjl.QF()) {
            this.bjl.stopAnimation();
        }
        try {
            if (this.bjy) {
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
        this.aDs = 2;
        Qr();
    }

    public void Qy() {
        if (this.aDs != 1 && this.aDs != 2) {
            int size = this.bjb.size();
            if (size > 0) {
                this.bjb.add(Float.valueOf(this.bjb.get(size - 1).floatValue() * 1.25f));
            } else {
                this.bjb.add(Float.valueOf(this.bjc));
            }
            QB();
        }
    }

    public void Qz() {
        if (this.aDs != 1 && this.aDs != 2) {
            int size = this.bjb.size();
            if (size > 1) {
                this.bjb.remove(size - 1);
            }
            QB();
        }
    }

    public void QA() {
        Qs();
        if (this.aDs != 1 && this.aDs != 2 && this.mCurrentScale != this.bjc) {
            this.bjb.clear();
            this.bjb.add(Float.valueOf(this.bjc));
            this.mCurrentScale = this.bjc;
            this.bje = this.mCurrentScale;
            QB();
        }
    }

    public boolean canZoomIn() {
        if (this.aDs == 1 || this.aDs == 2) {
            return false;
        }
        int size = this.bjb.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.bjb.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.bjh) && floatValue <= 5.0f;
    }

    public boolean canZoomOut() {
        if (this.aDs == 1 || this.aDs == 2) {
            return false;
        }
        int size = this.bjb.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled()) {
            return false;
        }
        return size > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QB() {
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
                    int size = this.bjb.size();
                    if (size > 0) {
                        f3 = this.bjb.get(size - 1).floatValue();
                    } else {
                        f3 = this.bjc;
                    }
                    this.mCurrentScale = f3;
                }
                this.mMatrix.setScale(this.mCurrentScale, this.mCurrentScale);
                this.biZ = imageBitmap.getWidth() * this.mCurrentScale;
                this.bja = imageBitmap.getHeight() * this.mCurrentScale;
                float width = this.bje * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.bje;
                this.bjt = this.mTop;
                this.bju = 0;
                float f4 = this.biZ < ((float) this.PE) ? (int) ((this.PE - this.biZ) / 2.0f) : 0.0f;
                if (this.bja < this.biY) {
                    f2 = (int) ((this.biY - this.bja) / 2.0f);
                    if (this.bji == 1 && f2 > this.mTop) {
                        f2 = this.mTop;
                    }
                    this.bjt = (int) (this.mTop - f2);
                    this.bju = this.mTop - this.bjt;
                } else {
                    f2 = 0.0f;
                }
                this.bjv = (int) f4;
                this.mMatrix.postTranslate(f4, f2);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    int width2 = i > getWidth() ? getWidth() : i;
                    if (this.biZ <= screenWidth) {
                        width2 = 0;
                    } else if (this.biZ > screenWidth && this.biZ / 2.0f < screenWidth) {
                        width2 = (int) (width2 - (this.biZ / 4.0f));
                    }
                    scrollX = width2;
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.biZ - width) / 2.0f);
                    }
                    if (this.biZ <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.biZ) {
                        scrollX = (int) (this.biZ - getWidth());
                    }
                }
                if (scrollX > 0 && this.biZ - scrollX < getWidth()) {
                    scrollX = (int) (this.biZ - getWidth());
                }
                int i3 = this.mMode == 2 ? ((int) ((this.bja - height) / 2.0f)) + scrollY : scrollY;
                if (this.bja <= getHeight()) {
                    i3 = 0;
                } else if (getHeight() + i3 > this.bja) {
                    i3 = (int) (this.bja - getHeight());
                }
                setHorizontalScrollBarEnabled(false);
                setVerticalScrollBarEnabled(false);
                if (scrollX < 0) {
                    scrollX = 0;
                }
                scrollTo(scrollX, i3 >= 0 ? i3 : 0);
                setImageMatrix(this.mMatrix);
                Qs();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Animation {
        private boolean bjP = false;
        private boolean bjQ = false;
        private long bjR;
        private long bjS;
        private long bjT;
        private long bjU;
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
            this.bjR = f;
            this.bjS = f2;
            this.bjT = Math.abs((f * 1000.0f) / 2500.0f);
            this.bjU = Math.abs((f2 * 1000.0f) / 2500.0f);
            setDuration(Math.max(this.bjT, this.bjU));
            setInterpolator(DragImageView.this.bjC);
            this.mStartX = DragImageView.this.getScrollX();
            this.mStartY = DragImageView.this.getScrollY();
            this.bjP = true;
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
            if (this.bjT > this.bjU) {
                j = ((float) this.bjT) * f;
            } else {
                j = ((float) this.bjU) * f;
            }
            float f2 = ((float) (j > this.bjT ? this.bjT : j)) / 1000.0f;
            if (this.bjR > 0) {
                i = this.mStartX - ((int) (f2 * (((float) this.bjR) - ((2500.0f * f2) / 2.0f))));
            } else {
                i = this.mStartX - ((int) (f2 * (((float) this.bjR) + ((2500.0f * f2) / 2.0f))));
            }
            if (j > this.bjU) {
                j = this.bjU;
            }
            float f3 = ((float) j) / 1000.0f;
            if (this.bjS > 0) {
                i2 = this.mStartY - ((int) (f3 * (((float) this.bjS) - ((2500.0f * f3) / 2.0f))));
            } else {
                i2 = this.mStartY - ((int) (f3 * (((float) this.bjS) + ((2500.0f * f3) / 2.0f))));
            }
            if (DragImageView.this.bja + DragImageView.this.mTop + DragImageView.this.mBottom > DragImageView.this.getHeight()) {
                if (i2 < (-DragImageView.this.bjt)) {
                    i2 = -DragImageView.this.bjt;
                }
                if (DragImageView.this.getHeight() + i2 > DragImageView.this.bja + DragImageView.this.mBottom + DragImageView.this.bju) {
                    i2 = (int) ((DragImageView.this.bja - DragImageView.this.getHeight()) + DragImageView.this.mBottom + DragImageView.this.bju);
                }
            } else {
                i2 = 0;
            }
            if (DragImageView.this.biZ > DragImageView.this.getWidth()) {
                int width = ((float) (DragImageView.this.getWidth() + i)) > DragImageView.this.biZ ? (int) (DragImageView.this.biZ - DragImageView.this.getWidth()) : i;
                if (width >= 0) {
                    i3 = width;
                }
            }
            DragImageView.this.scrollTo(i3, i2);
            DragImageView.this.invalidate();
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            if (!this.bjQ) {
                if (DragImageView.this.bjf) {
                    this.bjP = false;
                    return false;
                }
                try {
                    if (super.getTransformation(j, transformation)) {
                        return true;
                    }
                    this.bjP = false;
                    return false;
                } catch (Exception e) {
                    this.bjP = false;
                    return false;
                }
            }
            this.bjQ = false;
            this.bjP = false;
            return false;
        }

        public boolean QF() {
            return this.bjP;
        }

        public void stopAnimation() {
            this.bjQ = true;
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.bjk = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aTo = onLongClickListener;
        if (this.bjA != null) {
            this.bjA.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setGifSetListener(e eVar) {
        this.aTr = eVar;
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
    public void QC() {
        long j;
        c poll = this.bjG.poll();
        if (poll == null) {
            this.bjL = true;
            return;
        }
        this.bjL = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.bjF != null) {
            j = this.bjF.delay - (currentTimeMillis - this.bjK);
            this.bjH.offer(this.bjF);
        } else {
            j = 0;
        }
        this.bjF = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public c QD() {
        c poll = this.bjH.poll();
        if (poll == null) {
            poll = new c();
            try {
                poll.bjV = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
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
        return this.bjF;
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
            while (this.Et && DragImageView.this.bjr != null && DragImageView.this.bjE > 0 && DragImageView.this.width > 0 && DragImageView.this.height > 0) {
                try {
                    DragImageView.this.bjr.am(DragImageView.this.bjI);
                    c QD = DragImageView.this.QD();
                    if (QD.bjV == null || (QD.bjV.getWidth() != DragImageView.this.width && QD.bjV.getHeight() != DragImageView.this.height)) {
                        try {
                            QD.bjV = Bitmap.createBitmap(DragImageView.this.width, DragImageView.this.height, Bitmap.Config.ARGB_8888);
                        } catch (OutOfMemoryError e) {
                            TbadkCoreApplication.getInst().onAppMemoryLow();
                            try {
                                QD.bjV = Bitmap.createBitmap(DragImageView.this.width, DragImageView.this.height, Bitmap.Config.ARGB_4444);
                            } catch (OutOfMemoryError e2) {
                                TbadkCoreApplication.getInst().onAppMemoryLow();
                            } catch (Throwable th) {
                                BdLog.e(th.getMessage());
                            }
                        } catch (Throwable th2) {
                            BdLog.e(th2.getMessage());
                        }
                    }
                    DragImageView.this.bjr.a(QD.bjV, null);
                    QD.delay = DragImageView.this.bjr.an(DragImageView.this.bjI);
                    DragImageView.B(DragImageView.this);
                    if (QD.bjV == null) {
                        DragImageView.B(DragImageView.this);
                    }
                    DragImageView.this.bjI %= DragImageView.this.bjE;
                    DragImageView.this.bjG.put(QD);
                    if (DragImageView.this.bjL) {
                        DragImageView.this.mHandler.sendEmptyMessage(1);
                    }
                } catch (Exception e3) {
                    return;
                }
            }
        }
    }

    public boolean QE() {
        return this.bjx;
    }

    public void setLoadBigImage(boolean z) {
        this.bjx = z;
    }

    public int getBottomOffset() {
        return this.bju;
    }

    public int getLeftOffset() {
        return this.bjv;
    }
}
