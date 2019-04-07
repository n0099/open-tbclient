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
import android.support.v4.view.ViewCompat;
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
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class DragImageView extends ImageView {
    private static final String TAG = DragImageView.class.getSimpleName();
    private static final int cfh = l.aQ(TbadkCoreApplication.getInst()) / 5;
    private View.OnLongClickListener cdf;
    private e cdi;
    private int cdn;
    private boolean ceX;
    private float ceY;
    private Matrix ceZ;
    private Rect cfa;
    private RectF cfb;
    private d cfg;
    private float ctY;
    private float ctZ;
    private float cuA;
    private com.baidu.tbadk.widget.largeImage.logic.b cuB;
    private ImageUrlData cuC;
    private Interpolator cuD;
    private Rect cuE;
    private int cuF;
    private c cuG;
    private BlockingLinkedDeque<c> cuH;
    private BlockingLinkedDeque<c> cuI;
    private volatile int cuJ;
    private b cuK;
    private volatile long cuL;
    private volatile boolean cuM;
    private ArrayList<Float> cua;
    private float cub;
    private float cuc;
    private float cud;
    private boolean cue;
    private byte[] cuf;
    private int cug;
    private int cuh;
    private g cui;
    private View.OnClickListener cuj;
    private a cuk;
    private f cul;
    private float cum;
    private boolean cun;
    private boolean cuo;
    private int cup;
    private volatile com.baidu.adp.gif.b cuq;
    private Bitmap cus;
    private int cut;
    private int cuu;
    private int cuv;
    private int cuw;
    private boolean cux;
    private boolean cuy;
    private boolean cuz;
    private int height;
    private int mBottom;
    private float mCurrentScale;
    private GestureDetector mGestureDetector;
    public Handler mHandler;
    public int mImageType;
    private Matrix mMatrix;
    private int mMode;
    private Paint mPaint;
    private float mRatio;
    private int mTop;
    private int mViewHeight;
    private int mViewWidth;
    private int width;

    /* loaded from: classes.dex */
    public static class c {
        public Bitmap cuW;
        public int delay;
    }

    /* loaded from: classes.dex */
    public interface d {
        void aqP();

        void aqQ();

        void aqR();
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

    static /* synthetic */ int C(DragImageView dragImageView) {
        int i = dragImageView.cuJ;
        dragImageView.cuJ = i + 1;
        return i;
    }

    public void setIsHeadImage(boolean z) {
        this.cuz = z;
    }

    public void setImageUrlData(ImageUrlData imageUrlData) {
        this.cuC = imageUrlData;
    }

    public void setCanScale(boolean z) {
        this.cuy = z;
    }

    public DragImageView(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.cue = false;
        this.cuf = null;
        this.cdn = 0;
        this.cug = 1300;
        this.cuh = 0;
        this.cui = null;
        this.cuj = null;
        this.cdf = null;
        this.cdi = null;
        this.cum = 1.0f;
        this.mImageType = 0;
        this.mMode = 0;
        this.cun = false;
        this.cuo = false;
        this.cup = 0;
        this.cuq = null;
        this.cus = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.cut = 0;
        this.cuu = 0;
        this.cuv = 0;
        this.cuw = 0;
        this.cuy = true;
        this.cuD = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.ceZ = new Matrix();
        this.ceX = false;
        this.mRatio = 1.0f;
        this.ceY = 0.0f;
        this.cfb = new RectF();
        this.width = 0;
        this.height = 0;
        this.cuF = 0;
        this.cuG = null;
        this.cuH = new BlockingLinkedDeque<>(5);
        this.cuI = new BlockingLinkedDeque<>(6);
        this.cuJ = 0;
        this.cuL = 0L;
        this.cuM = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.DragImageView.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        DragImageView.this.aqL();
                        break;
                    case 1:
                        if (DragImageView.this.cuM) {
                            DragImageView.this.aqL();
                            break;
                        }
                        break;
                    case 2:
                        DragImageView.this.invalidate();
                        DragImageView.this.cuL = System.currentTimeMillis();
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
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.cue = false;
        this.cuf = null;
        this.cdn = 0;
        this.cug = 1300;
        this.cuh = 0;
        this.cui = null;
        this.cuj = null;
        this.cdf = null;
        this.cdi = null;
        this.cum = 1.0f;
        this.mImageType = 0;
        this.mMode = 0;
        this.cun = false;
        this.cuo = false;
        this.cup = 0;
        this.cuq = null;
        this.cus = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.cut = 0;
        this.cuu = 0;
        this.cuv = 0;
        this.cuw = 0;
        this.cuy = true;
        this.cuD = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.ceZ = new Matrix();
        this.ceX = false;
        this.mRatio = 1.0f;
        this.ceY = 0.0f;
        this.cfb = new RectF();
        this.width = 0;
        this.height = 0;
        this.cuF = 0;
        this.cuG = null;
        this.cuH = new BlockingLinkedDeque<>(5);
        this.cuI = new BlockingLinkedDeque<>(6);
        this.cuJ = 0;
        this.cuL = 0L;
        this.cuM = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.DragImageView.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        DragImageView.this.aqL();
                        break;
                    case 1:
                        if (DragImageView.this.cuM) {
                            DragImageView.this.aqL();
                            break;
                        }
                        break;
                    case 2:
                        DragImageView.this.invalidate();
                        DragImageView.this.cuL = System.currentTimeMillis();
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
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.cue = false;
        this.cuf = null;
        this.cdn = 0;
        this.cug = 1300;
        this.cuh = 0;
        this.cui = null;
        this.cuj = null;
        this.cdf = null;
        this.cdi = null;
        this.cum = 1.0f;
        this.mImageType = 0;
        this.mMode = 0;
        this.cun = false;
        this.cuo = false;
        this.cup = 0;
        this.cuq = null;
        this.cus = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.cut = 0;
        this.cuu = 0;
        this.cuv = 0;
        this.cuw = 0;
        this.cuy = true;
        this.cuD = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.ceZ = new Matrix();
        this.ceX = false;
        this.mRatio = 1.0f;
        this.ceY = 0.0f;
        this.cfb = new RectF();
        this.width = 0;
        this.height = 0;
        this.cuF = 0;
        this.cuG = null;
        this.cuH = new BlockingLinkedDeque<>(5);
        this.cuI = new BlockingLinkedDeque<>(6);
        this.cuJ = 0;
        this.cuL = 0L;
        this.cuM = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.DragImageView.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        DragImageView.this.aqL();
                        break;
                    case 1:
                        if (DragImageView.this.cuM) {
                            DragImageView.this.aqL();
                            break;
                        }
                        break;
                    case 2:
                        DragImageView.this.invalidate();
                        DragImageView.this.cuL = System.currentTimeMillis();
                        DragImageView.this.mHandler.sendEmptyMessage(0);
                        break;
                }
                return false;
            }
        });
        initData();
    }

    public void setDragToExitListener(d dVar) {
        this.cfg = dVar;
    }

    public int getImageType() {
        return this.mImageType;
    }

    public void setImageMode(int i) {
        this.cuh = i;
    }

    public void setOffset(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.cdn = i;
    }

    public boolean aqx() {
        if (this.cuB != null) {
            return this.cuB.aqx();
        }
        return false;
    }

    public void aqy() {
        this.cuo = false;
        this.cue = false;
        this.mMode = 3;
        aqE();
        if (this.mCurrentScale < this.cub) {
            this.mCurrentScale = this.cub;
            aqK();
        }
        invalidate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.cuB != null && this.cuB.onTouchEvent(motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.cue = true;
                this.cun = false;
                this.cuo = false;
                break;
            case 1:
                aqy();
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
            this.cum = x(motionEvent);
            if (this.cum > 10.0f) {
                this.mMode = 2;
            }
        }
        if ((this.mMode == 2 || !this.mGestureDetector.onTouchEvent(motionEvent)) && this.cuy) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.cun = true;
                        this.cuo = true;
                        if (this.mImageType != 1 && this.mImageType != 2) {
                            float x = x(motionEvent);
                            if (x >= 0.0f && Math.abs(this.cum - x) >= 10.0f) {
                                if (Math.abs(this.cum - x) > 100.0f) {
                                    this.cum = x;
                                    break;
                                } else {
                                    float f2 = x / this.cum;
                                    this.cum = x;
                                    this.cud = this.mCurrentScale;
                                    this.mCurrentScale *= f2;
                                    if (this.mCurrentScale > this.cuc) {
                                        this.mCurrentScale = this.cuc;
                                    }
                                    float minScaleValue = getMinScaleValue();
                                    if (this.mCurrentScale < minScaleValue) {
                                        this.mCurrentScale = minScaleValue;
                                    }
                                    aqK();
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
        return this.cuB != null ? this.cuB.getMinScaleValue() : this.cub / 4.0f;
    }

    public float x(MotionEvent motionEvent) {
        return CompatibleUtile.getInstance().getSpacing(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            this.mViewWidth = i3 - i;
            this.mViewHeight = i4 - i2;
            aqA();
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public boolean aqz() {
        if (this.cuB != null) {
            return this.cuB.arF();
        }
        return this.cub == this.mCurrentScale;
    }

    protected float o(Bitmap bitmap) {
        if (this.cuB != null) {
            return this.cuB.arJ();
        }
        if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            return 1.0f;
        }
        if (this.cuh == 0) {
            float width = this.mViewWidth / bitmap.getWidth();
            float height = this.mViewHeight / bitmap.getHeight();
            if (this.cuz) {
                if (this.mImageType == 2) {
                    return 2.5f;
                }
                return Math.min(width, height);
            } else if (this.mImageType != 2) {
                float f2 = this.cuA;
                float f3 = f2 >= 1.0f ? f2 : 1.0f;
                if (bitmap.getWidth() * f3 >= this.mViewWidth || bitmap.getHeight() * f3 >= this.mViewHeight) {
                    return Math.min(width, height);
                }
                return f3;
            } else {
                return 1.0f;
            }
        }
        return Math.max(this.mViewWidth / bitmap.getWidth(), ((this.mViewHeight - this.mTop) - this.mBottom) / bitmap.getHeight());
    }

    protected float p(Bitmap bitmap) {
        if (this.cuB != null) {
            return this.cuB.arK();
        }
        float f2 = 1.0f;
        if (bitmap != null && !bitmap.isRecycled() && bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
            f2 = (float) Math.sqrt(this.cug / (bitmap.getWidth() * bitmap.getHeight()));
            if (f2 > 10.0f) {
                return 10.0f;
            }
        }
        return f2;
    }

    private void aqA() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            this.cub = o(imageBitmap);
            this.cuc = p(imageBitmap);
            this.cua.clear();
            this.cua.add(Float.valueOf(this.cub));
            this.mCurrentScale = this.cub;
            this.cud = this.mCurrentScale;
            aqK();
            return;
        }
        this.ctY = 0.0f;
        this.ctZ = 0.0f;
        this.cub = 1.0f;
        this.cuc = 1.0f;
        this.mCurrentScale = 1.0f;
        this.cud = this.mCurrentScale;
        this.cua.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    private void aqB() {
        if (this.cui != null) {
            this.cui.a(this, canZoomIn(), canZoomOut());
        }
    }

    public void setOnSizeChangedListener(g gVar) {
        this.cui = gVar;
    }

    public void setOnImageScrollListener(f fVar) {
        this.cul = fVar;
    }

    public byte[] getImageData() {
        return this.cuf;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getMeasuredHeight() != 0 && getMeasuredWidth() != 0 && this.cuB != null) {
            this.cuB.arH();
        }
    }

    public void setImageData(Bitmap bitmap, byte[] bArr) {
        this.cuf = bArr;
        if (this.cuB != null) {
            this.cuB.a(bitmap, bArr);
        }
        setImageBitmap(bitmap);
    }

    public void aqC() {
        if (this.cuB == null) {
            this.cuB = new com.baidu.tbadk.widget.largeImage.logic.b(this);
            this.cuB.setOnClickListener(this.cuj);
            this.cuB.setOnLongClickListener(this.cdf);
        }
    }

    public void setImageLoadCallBack(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
        if (this.cuB != null) {
            this.cuB.a(aVar);
        }
    }

    public boolean aqD() {
        return (getImageBitmap() == null || this.cuB == null) ? false : true;
    }

    public Bitmap getGifCache() {
        return this.cus;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        boolean z;
        if (this.cuB == null || !this.cuB.b(canvas, getImageBitmap())) {
            if (this.mImageType == 2 && this.cuw != 0 && !this.cuk.aqO()) {
                int width = getWidth();
                int height = getHeight();
                Drawable drawable = getDrawable();
                float f2 = 0.0f;
                float f3 = height * 0.3f;
                float f4 = width;
                float f5 = (1.0f - 0.3f) * height;
                if (this.cuz && drawable != null) {
                    Rect bounds = drawable.getBounds();
                    int i = bounds.right - bounds.left;
                    int i2 = bounds.bottom - bounds.top;
                    f2 = (width / 2) - (i * 2.5f);
                    f3 = (height / 2) - (i2 * 2.5f);
                    f4 = (i * 2.5f) + (width / 2);
                    f5 = (i2 * 2.5f) + (height / 2);
                }
                this.mPaint.setColor(al.getColor(this.cuw));
                canvas.drawRect(f2, f3, f4, f5, this.mPaint);
                this.mPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
            }
            if (this.mMode == 3 && this.ceX) {
                this.ceX = false;
                this.ceZ.reset();
                if (this.ceY < cfh) {
                    this.mMode = 0;
                } else {
                    this.mMode = 4;
                    akr();
                }
            }
            if (this.mImageType == 0 && this.ceX && this.cfa != null && this.cuC != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                if (this.cfb == null) {
                    this.cfb = new RectF();
                }
                this.ceZ.mapRect(this.cfb, new RectF(this.cfa));
                Bitmap imageBitmap = getImageBitmap();
                if (imageBitmap != null && !imageBitmap.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.cuE, this.cfb, (Paint) null);
                }
            } else if (this.mMode == 4 && this.cfa != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                Bitmap imageBitmap2 = getImageBitmap();
                if (imageBitmap2 != null && !imageBitmap2.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.cuE, this.cfb, (Paint) null);
                }
            } else {
                super.onDraw(canvas);
            }
            if (this.mImageType == 1 && this.cus != null && !this.cus.isRecycled()) {
                int width2 = this.cus.getWidth();
                int height2 = this.cus.getHeight();
                int width3 = getWidth();
                int height3 = getHeight();
                int i3 = (width3 - width2) >> 1;
                int i4 = (height3 - height2) >> 1;
                float f6 = this.cuA;
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
                if (this.cup == 1 && this.cuq != null && this.cuG != null && this.cuG.cuW != null) {
                    if (z) {
                        canvas.drawBitmap(this.cuG.cuW, i3, i4, (Paint) null);
                    } else {
                        canvas.drawBitmap(this.cuG.cuW, this.mMatrix, this.mPaint);
                    }
                    invalidate();
                } else if (z) {
                    canvas.drawBitmap(this.cus, i3, i4, (Paint) null);
                } else {
                    canvas.drawBitmap(this.cus, this.mMatrix, this.mPaint);
                }
            }
        }
    }

    public void play() {
        com.baidu.adp.widget.ImageView.a aVar;
        if (this.mImageType == 1) {
            if (this.cuq == null) {
                if (this.cuK != null) {
                    this.cuK.Es = false;
                    this.cuK.interrupt();
                    this.cuK = null;
                }
                if (this.cuf != null) {
                    try {
                        aVar = a.C0013a.hv().g(this.cuf, 0, this.cuf.length);
                    } catch (StackOverflowError e2) {
                        aVar = null;
                    }
                    if (aVar == null || aVar.getGif() == null) {
                        com.baidu.tbadk.core.d.a.a("gifplay", -1L, -1, "DragImageView.play", -1, "decode error", new Object[0]);
                        return;
                    }
                    this.cuq = aVar.getGif();
                    if (this.cuq != null) {
                        this.cup = 1;
                        this.width = this.cuq.getWidth();
                        this.height = this.cuq.getHeight();
                        this.cuJ = 0;
                        this.cuF = this.cuq.getFrameCount();
                    } else {
                        this.cup = 0;
                    }
                } else {
                    return;
                }
            }
            if (this.cuq != null) {
                if (this.cuK == null || (this.cuK != null && !this.cuK.Es)) {
                    this.cuM = true;
                    this.cuK = new b();
                    this.cuH.clear();
                    this.cuI.clear();
                    this.cuK.Es = true;
                    this.cuK.start();
                }
            }
        }
    }

    public void pause() {
        if (this.mImageType == 1) {
            if (this.cuK != null) {
                this.cuK.Es = false;
                this.cuK.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.mImageType == 1) {
            if (this.cuK != null) {
                this.cuK.Es = false;
                this.cuK.interrupt();
                this.cuK = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.cuM = true;
            this.cuG = null;
            this.cuI.clear();
            this.cuH.clear();
            this.width = 0;
            this.height = 0;
            this.cuJ = 0;
            this.cuF = 0;
            this.cuq = null;
        }
    }

    private void initData() {
        this.cuA = l.aR(getContext());
        this.cug = l.aQ(getContext()) * l.aO(getContext()) * 2;
        if (this.cug < 1690000) {
            this.cug = 1690000;
        }
        this.ctY = 0.0f;
        this.ctZ = 0.0f;
        this.cua = new ArrayList<>();
        this.cub = 1.0f;
        this.cuc = 1.0f;
        this.mCurrentScale = 1.0f;
        this.cud = this.mCurrentScale;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.cuk = new a();
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWillNotDraw(false);
        scrollTo(0, 0);
        this.mGestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.DragImageView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                if (DragImageView.this.mImageType != 2 && (Math.abs(f2) > 200.0f || Math.abs(f3) > 200.0f)) {
                    DragImageView.this.cuk.s(f2, f3);
                    DragImageView.this.startAnimation(DragImageView.this.cuk);
                }
                return super.onFling(motionEvent, motionEvent2, f2, f3);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (DragImageView.this.mImageType == 1 || DragImageView.this.mImageType == 2 || !DragImageView.this.cuy) {
                    return false;
                }
                DragImageView.this.mMode = 2;
                if (DragImageView.this.mCurrentScale > DragImageView.this.cub) {
                    DragImageView.this.mCurrentScale = DragImageView.this.cub;
                    DragImageView.this.cud = DragImageView.this.mCurrentScale;
                    DragImageView.this.aqK();
                } else {
                    DragImageView.this.mCurrentScale = DragImageView.this.cub * 2.0f;
                    DragImageView.this.a(true, (int) motionEvent.getX(), (int) motionEvent.getY());
                }
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (DragImageView.this.cuj != null && !DragImageView.this.cun) {
                    DragImageView.this.cuj.onClick(DragImageView.this);
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
                DragImageView.this.cun = true;
                if (DragImageView.this.cuh == 0 && DragImageView.this.cuo) {
                    return false;
                }
                int scrollX = DragImageView.this.getScrollX();
                int scrollY = DragImageView.this.getScrollY();
                if (DragImageView.this.ctY >= DragImageView.this.getWidth()) {
                    scrollX = (int) (scrollX + f2);
                    if (DragImageView.this.cuh == 0) {
                        i = scrollX >= 0 ? scrollX : 0;
                        if (DragImageView.this.getWidth() + i > DragImageView.this.ctY) {
                            i = (int) (DragImageView.this.ctY - DragImageView.this.getWidth());
                        }
                        if (DragImageView.this.ctZ + DragImageView.this.mTop + DragImageView.this.mBottom < DragImageView.this.getHeight()) {
                            i2 = (int) (scrollY + f3);
                            if (DragImageView.this.cuh == 0) {
                                if (i2 < (-DragImageView.this.cut)) {
                                    i2 = -DragImageView.this.cut;
                                }
                                if (DragImageView.this.getHeight() + i2 > DragImageView.this.ctZ + DragImageView.this.mBottom + DragImageView.this.cuu) {
                                    i2 = (int) ((DragImageView.this.ctZ - DragImageView.this.getHeight()) + DragImageView.this.mBottom + DragImageView.this.cuu);
                                }
                            }
                        } else {
                            i2 = scrollY;
                        }
                        if (i == DragImageView.this.getScrollX() || i2 != DragImageView.this.getScrollY()) {
                            DragImageView.this.scrollTo(i, i2);
                            DragImageView.this.invalidate();
                            if (DragImageView.this.cul != null) {
                                DragImageView.this.cul.a(DragImageView.this, i, i2);
                            }
                        }
                        return true;
                    }
                }
                i = scrollX;
                if (DragImageView.this.ctZ + DragImageView.this.mTop + DragImageView.this.mBottom < DragImageView.this.getHeight()) {
                }
                if (i == DragImageView.this.getScrollX()) {
                }
                DragImageView.this.scrollTo(i, i2);
                DragImageView.this.invalidate();
                if (DragImageView.this.cul != null) {
                }
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (DragImageView.this.cdf != null && !DragImageView.this.cun) {
                    DragImageView.this.cdf.onLongClick(DragImageView.this);
                }
                super.onLongPress(motionEvent);
            }
        });
    }

    private void akr() {
        if (this.cuC == null) {
            if (this.cfg != null) {
                this.cfg.aqQ();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.cuC.getSourceImageRectInScreen();
        if (sourceImageRectInScreen == null) {
            if (this.cfg != null) {
                this.cfg.aqQ();
                return;
            }
            return;
        }
        this.cfb.bottom = (((sourceImageRectInScreen.bottom - sourceImageRectInScreen.top) / (sourceImageRectInScreen.right - sourceImageRectInScreen.left)) * (this.cfb.right - this.cfb.left)) + this.cfb.top;
        final float[] fArr = {(this.cfb.left + this.cfb.right) / 2.0f, (this.cfb.top + this.cfb.bottom) / 2.0f};
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
                    DragImageView.this.cfb = DragImageView.this.h(floatValue, animatedFraction, sourceImageRectInScreen.right - sourceImageRectInScreen.left, sourceImageRectInScreen.bottom - sourceImageRectInScreen.top);
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
                DragImageView.this.ceX = false;
                DragImageView.this.mMode = 4;
                DragImageView.this.invalidate();
                if (DragImageView.this.cfg != null) {
                    DragImageView.this.cfg.aqQ();
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

    private void aqE() {
        int i = 0;
        int scrollX = getScrollX();
        if (this.ctY >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.ctY) {
                scrollX = (int) (this.ctY - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.ctZ + this.mTop + this.mBottom >= getHeight()) {
            i = scrollY < (-this.cut) ? -this.cut : scrollY;
            if (getHeight() + i > this.ctZ + this.mBottom + this.cuu) {
                i = (int) ((this.ctZ - getHeight()) + this.mBottom + this.cuu);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
            if (this.cul != null) {
                this.cul.a(this, scrollX, i);
            }
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.cuB != null) {
            this.cuB.arG();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.ctY;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.ctZ;
    }

    public boolean aqF() {
        if (this.mImageType == 1 || this.mImageType == 2) {
            return true;
        }
        return !this.cuo && getScrollX() >= ((int) (this.ctY - ((float) getWidth()))) + (-1);
    }

    public boolean aqG() {
        if (this.mImageType == 1 || this.mImageType == 2) {
            return true;
        }
        return !this.cuo && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.cuk.aqO()) {
            this.cuk.stopAnimation();
        }
        this.cuw = 0;
        super.setImageBitmap(bitmap);
        aqA();
        this.mImageType = 0;
        if (this.cfa == null) {
            int measuredWidth = getMeasuredWidth();
            float measuredWidth2 = ((1.0f * getMeasuredWidth()) / bitmap.getWidth()) * bitmap.getHeight();
            if (measuredWidth2 > getMeasuredHeight()) {
                measuredWidth2 = getMeasuredHeight();
            }
            RectF h = h(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
            this.cfa = new Rect((int) h.left, (int) h.top, (int) h.right, (int) h.bottom);
        }
        if (this.cuE == null) {
            this.cuE = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        }
    }

    public void q(Bitmap bitmap) {
        Bitmap imageBitmap = getImageBitmap();
        if (bitmap != null && !bitmap.isRecycled()) {
            if (imageBitmap != null && (imageBitmap.getWidth() != bitmap.getWidth() || imageBitmap.getHeight() != bitmap.getHeight())) {
                setImageBitmap(bitmap);
                super.setImageMatrix(this.mMatrix);
                return;
            }
            if (this.cuk.aqO()) {
                this.cuk.stopAnimation();
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            super.setImageBitmap(bitmap);
            super.setImageMatrix(this.mMatrix);
            scrollTo(scrollX, scrollY);
            this.mImageType = 0;
        }
    }

    public void setGifData(byte[] bArr, Bitmap bitmap) {
        if (this.cuk.aqO()) {
            this.cuk.stopAnimation();
        }
        super.setImageDrawable(null);
        stop();
        aqA();
        this.mImageType = 1;
        this.cus = bitmap;
        this.cuf = bArr;
        if (this.cdi != null) {
            this.cdi.a(this);
        }
    }

    public void onDestroy() {
        if (this.cuk.aqO()) {
            this.cuk.stopAnimation();
        }
        super.setImageDrawable(null);
        this.cuf = null;
        this.cus = null;
        stop();
        if (this.cuq != null) {
            this.cuq.close();
            this.cuq = null;
        }
        if (this.cuB != null) {
            this.cuB.release();
            System.gc();
        }
    }

    public void release() {
        if (this.cuk.aqO()) {
            this.cuk.stopAnimation();
        }
        stop();
        super.setImageDrawable(null);
        this.cus = null;
    }

    public void setDefaultBitmap() {
        if (this.cuk.aqO()) {
            this.cuk.stopAnimation();
        }
        try {
            if (this.cuz) {
                super.setImageBitmap(BitmapHelper.getCashBitmap(d.f.icon_default_avatar100));
            } else {
                super.setImageBitmap(BitmapHelper.getCashBitmap(d.f.btn_see_default));
            }
        } catch (OutOfMemoryError e2) {
            TbadkCoreApplication.getInst().onAppMemoryLow();
            System.gc();
            super.setImageBitmap(null);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
        this.mImageType = 2;
        aqA();
    }

    public void aqH() {
        if (this.mImageType != 1 && this.mImageType != 2) {
            int size = this.cua.size();
            if (size > 0) {
                this.cua.add(Float.valueOf(this.cua.get(size - 1).floatValue() * 1.25f));
            } else {
                this.cua.add(Float.valueOf(this.cub));
            }
            aqK();
        }
    }

    public void aqI() {
        if (this.mImageType != 1 && this.mImageType != 2) {
            int size = this.cua.size();
            if (size > 1) {
                this.cua.remove(size - 1);
            }
            aqK();
        }
    }

    public void aqJ() {
        aqB();
        if (this.mImageType != 1 && this.mImageType != 2 && this.mCurrentScale != this.cub) {
            this.cua.clear();
            this.cua.add(Float.valueOf(this.cub));
            this.mCurrentScale = this.cub;
            this.cud = this.mCurrentScale;
            aqK();
        }
    }

    public boolean canZoomIn() {
        if (this.mImageType == 1 || this.mImageType == 2) {
            return false;
        }
        int size = this.cua.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.cua.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.cug) && floatValue <= 5.0f;
    }

    public boolean canZoomOut() {
        if (this.mImageType == 1 || this.mImageType == 2) {
            return false;
        }
        int size = this.cua.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled()) {
            return false;
        }
        return size > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqK() {
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
                    int size = this.cua.size();
                    if (size > 0) {
                        f3 = this.cua.get(size - 1).floatValue();
                    } else {
                        f3 = this.cub;
                    }
                    this.mCurrentScale = f3;
                }
                this.mMatrix.setScale(this.mCurrentScale, this.mCurrentScale);
                this.ctY = imageBitmap.getWidth() * this.mCurrentScale;
                this.ctZ = imageBitmap.getHeight() * this.mCurrentScale;
                float width = this.cud * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.cud;
                this.cut = this.mTop;
                this.cuu = 0;
                float f4 = this.ctY < ((float) this.mViewWidth) ? (int) ((this.mViewWidth - this.ctY) / 2.0f) : 0.0f;
                if (this.ctZ < this.mViewHeight) {
                    f2 = (int) ((this.mViewHeight - this.ctZ) / 2.0f);
                    if (this.cuh == 1 && f2 > this.mTop) {
                        f2 = this.mTop;
                    }
                    this.cut = (int) (this.mTop - f2);
                    this.cuu = this.mTop - this.cut;
                } else {
                    f2 = 0.0f;
                }
                this.cuv = (int) f4;
                this.mMatrix.postTranslate(f4, f2);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    int width2 = i > getWidth() ? getWidth() : i;
                    if (this.ctY <= screenWidth) {
                        width2 = 0;
                    } else if (this.ctY > screenWidth && this.ctY / 2.0f < screenWidth) {
                        width2 = (int) (width2 - (this.ctY / 4.0f));
                    }
                    scrollX = width2;
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.ctY - width) / 2.0f);
                    }
                    if (this.ctY <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.ctY) {
                        scrollX = (int) (this.ctY - getWidth());
                    }
                }
                if (scrollX > 0 && this.ctY - scrollX < getWidth()) {
                    scrollX = (int) (this.ctY - getWidth());
                }
                int i3 = this.mMode == 2 ? ((int) ((this.ctZ - height) / 2.0f)) + scrollY : scrollY;
                if (this.ctZ <= getHeight()) {
                    i3 = 0;
                } else if (getHeight() + i3 > this.ctZ) {
                    i3 = (int) (this.ctZ - getHeight());
                }
                setHorizontalScrollBarEnabled(false);
                setVerticalScrollBarEnabled(false);
                if (scrollX < 0) {
                    scrollX = 0;
                }
                scrollTo(scrollX, i3 >= 0 ? i3 : 0);
                setImageMatrix(this.mMatrix);
                aqB();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Animation {
        private boolean cuQ = false;
        private boolean cuR = false;
        private long cuS;
        private long cuT;
        private long cuU;
        private long cuV;
        private int mStartX;
        private int mStartY;

        public a() {
        }

        public void s(float f, float f2) {
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
            this.cuS = f;
            this.cuT = f2;
            this.cuU = Math.abs((f * 1000.0f) / 2500.0f);
            this.cuV = Math.abs((f2 * 1000.0f) / 2500.0f);
            setDuration(Math.max(this.cuU, this.cuV));
            setInterpolator(DragImageView.this.cuD);
            this.mStartX = DragImageView.this.getScrollX();
            this.mStartY = DragImageView.this.getScrollY();
            this.cuQ = true;
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
            if (this.cuU > this.cuV) {
                j = ((float) this.cuU) * f;
            } else {
                j = ((float) this.cuV) * f;
            }
            float f2 = ((float) (j > this.cuU ? this.cuU : j)) / 1000.0f;
            if (this.cuS > 0) {
                i = this.mStartX - ((int) (f2 * (((float) this.cuS) - ((2500.0f * f2) / 2.0f))));
            } else {
                i = this.mStartX - ((int) (f2 * (((float) this.cuS) + ((2500.0f * f2) / 2.0f))));
            }
            if (j > this.cuV) {
                j = this.cuV;
            }
            float f3 = ((float) j) / 1000.0f;
            if (this.cuT > 0) {
                i2 = this.mStartY - ((int) (f3 * (((float) this.cuT) - ((2500.0f * f3) / 2.0f))));
            } else {
                i2 = this.mStartY - ((int) (f3 * (((float) this.cuT) + ((2500.0f * f3) / 2.0f))));
            }
            if (DragImageView.this.ctZ + DragImageView.this.mTop + DragImageView.this.mBottom > DragImageView.this.getHeight()) {
                if (i2 < (-DragImageView.this.cut)) {
                    i2 = -DragImageView.this.cut;
                }
                if (DragImageView.this.getHeight() + i2 > DragImageView.this.ctZ + DragImageView.this.mBottom + DragImageView.this.cuu) {
                    i2 = (int) ((DragImageView.this.ctZ - DragImageView.this.getHeight()) + DragImageView.this.mBottom + DragImageView.this.cuu);
                }
            } else {
                i2 = 0;
            }
            if (DragImageView.this.ctY > DragImageView.this.getWidth()) {
                int width = ((float) (DragImageView.this.getWidth() + i)) > DragImageView.this.ctY ? (int) (DragImageView.this.ctY - DragImageView.this.getWidth()) : i;
                if (width >= 0) {
                    i3 = width;
                }
            }
            DragImageView.this.scrollTo(i3, i2);
            DragImageView.this.invalidate();
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            if (!this.cuR) {
                if (DragImageView.this.cue) {
                    this.cuQ = false;
                    return false;
                }
                try {
                    if (super.getTransformation(j, transformation)) {
                        return true;
                    }
                    this.cuQ = false;
                    return false;
                } catch (Exception e) {
                    this.cuQ = false;
                    return false;
                }
            }
            this.cuR = false;
            this.cuQ = false;
            return false;
        }

        public boolean aqO() {
            return this.cuQ;
        }

        public void stopAnimation() {
            this.cuR = true;
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.cuj = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cdf = onLongClickListener;
        if (this.cuB != null) {
            this.cuB.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setGifSetListener(e eVar) {
        this.cdi = eVar;
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
    public void aqL() {
        long j;
        c poll = this.cuH.poll();
        if (poll == null) {
            this.cuM = true;
            return;
        }
        this.cuM = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.cuG != null) {
            j = this.cuG.delay - (currentTimeMillis - this.cuL);
            this.cuI.offer(this.cuG);
        } else {
            j = 0;
        }
        this.cuG = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public c aqM() {
        c poll = this.cuI.poll();
        if (poll == null) {
            poll = new c();
            try {
                poll.cuW = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
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
        return this.cuG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends Thread {
        private volatile boolean Es;

        private b() {
            this.Es = false;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (this.Es && DragImageView.this.cuq != null && DragImageView.this.cuF > 0 && DragImageView.this.width > 0 && DragImageView.this.height > 0) {
                try {
                    DragImageView.this.cuq.U(DragImageView.this.cuJ);
                    c aqM = DragImageView.this.aqM();
                    if (aqM.cuW == null || (aqM.cuW.getWidth() != DragImageView.this.width && aqM.cuW.getHeight() != DragImageView.this.height)) {
                        try {
                            aqM.cuW = Bitmap.createBitmap(DragImageView.this.width, DragImageView.this.height, Bitmap.Config.ARGB_8888);
                        } catch (OutOfMemoryError e) {
                            TbadkCoreApplication.getInst().onAppMemoryLow();
                            try {
                                aqM.cuW = Bitmap.createBitmap(DragImageView.this.width, DragImageView.this.height, Bitmap.Config.ARGB_4444);
                            } catch (OutOfMemoryError e2) {
                                TbadkCoreApplication.getInst().onAppMemoryLow();
                            } catch (Throwable th) {
                                BdLog.e(th.getMessage());
                            }
                        } catch (Throwable th2) {
                            BdLog.e(th2.getMessage());
                        }
                    }
                    DragImageView.this.cuq.a(aqM.cuW, null);
                    aqM.delay = DragImageView.this.cuq.V(DragImageView.this.cuJ);
                    DragImageView.C(DragImageView.this);
                    if (aqM.cuW == null) {
                        DragImageView.C(DragImageView.this);
                    }
                    DragImageView.this.cuJ %= DragImageView.this.cuF;
                    DragImageView.this.cuH.put(aqM);
                    if (DragImageView.this.cuM) {
                        DragImageView.this.mHandler.sendEmptyMessage(1);
                    }
                } catch (Exception e3) {
                    return;
                }
            }
        }
    }

    public boolean aqN() {
        return this.cux;
    }

    public void setLoadBigImage(boolean z) {
        this.cux = z;
    }

    public int getBottomOffset() {
        return this.cuu;
    }

    public int getLeftOffset() {
        return this.cuv;
    }
}
