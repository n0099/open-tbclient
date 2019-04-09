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
    private static final int cfi = l.aQ(TbadkCoreApplication.getInst()) / 5;
    private View.OnLongClickListener cdg;
    private e cdj;
    private int cdo;
    private boolean ceY;
    private float ceZ;
    private Matrix cfa;
    private Rect cfb;
    private RectF cfc;
    private d cfh;
    private float ctZ;
    private boolean cuA;
    private float cuB;
    private com.baidu.tbadk.widget.largeImage.logic.b cuC;
    private ImageUrlData cuD;
    private Interpolator cuE;
    private Rect cuF;
    private int cuG;
    private c cuH;
    private BlockingLinkedDeque<c> cuI;
    private BlockingLinkedDeque<c> cuJ;
    private volatile int cuK;
    private b cuL;
    private volatile long cuM;
    private volatile boolean cuN;
    private float cua;
    private ArrayList<Float> cub;
    private float cuc;
    private float cud;
    private float cue;
    private boolean cuf;
    private byte[] cug;
    private int cuh;
    private int cui;
    private g cuj;
    private View.OnClickListener cuk;
    private a cul;
    private f cum;
    private float cun;
    private boolean cuo;
    private boolean cup;
    private int cuq;
    private volatile com.baidu.adp.gif.b cus;
    private Bitmap cut;
    private int cuu;
    private int cuv;
    private int cuw;
    private int cux;
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
        public Bitmap cuX;
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
        int i = dragImageView.cuK;
        dragImageView.cuK = i + 1;
        return i;
    }

    public void setIsHeadImage(boolean z) {
        this.cuA = z;
    }

    public void setImageUrlData(ImageUrlData imageUrlData) {
        this.cuD = imageUrlData;
    }

    public void setCanScale(boolean z) {
        this.cuz = z;
    }

    public DragImageView(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.cuf = false;
        this.cug = null;
        this.cdo = 0;
        this.cuh = 1300;
        this.cui = 0;
        this.cuj = null;
        this.cuk = null;
        this.cdg = null;
        this.cdj = null;
        this.cun = 1.0f;
        this.mImageType = 0;
        this.mMode = 0;
        this.cuo = false;
        this.cup = false;
        this.cuq = 0;
        this.cus = null;
        this.cut = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.cuu = 0;
        this.cuv = 0;
        this.cuw = 0;
        this.cux = 0;
        this.cuz = true;
        this.cuE = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.cfa = new Matrix();
        this.ceY = false;
        this.mRatio = 1.0f;
        this.ceZ = 0.0f;
        this.cfc = new RectF();
        this.width = 0;
        this.height = 0;
        this.cuG = 0;
        this.cuH = null;
        this.cuI = new BlockingLinkedDeque<>(5);
        this.cuJ = new BlockingLinkedDeque<>(6);
        this.cuK = 0;
        this.cuM = 0L;
        this.cuN = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.DragImageView.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        DragImageView.this.aqL();
                        break;
                    case 1:
                        if (DragImageView.this.cuN) {
                            DragImageView.this.aqL();
                            break;
                        }
                        break;
                    case 2:
                        DragImageView.this.invalidate();
                        DragImageView.this.cuM = System.currentTimeMillis();
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
        this.cuf = false;
        this.cug = null;
        this.cdo = 0;
        this.cuh = 1300;
        this.cui = 0;
        this.cuj = null;
        this.cuk = null;
        this.cdg = null;
        this.cdj = null;
        this.cun = 1.0f;
        this.mImageType = 0;
        this.mMode = 0;
        this.cuo = false;
        this.cup = false;
        this.cuq = 0;
        this.cus = null;
        this.cut = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.cuu = 0;
        this.cuv = 0;
        this.cuw = 0;
        this.cux = 0;
        this.cuz = true;
        this.cuE = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.cfa = new Matrix();
        this.ceY = false;
        this.mRatio = 1.0f;
        this.ceZ = 0.0f;
        this.cfc = new RectF();
        this.width = 0;
        this.height = 0;
        this.cuG = 0;
        this.cuH = null;
        this.cuI = new BlockingLinkedDeque<>(5);
        this.cuJ = new BlockingLinkedDeque<>(6);
        this.cuK = 0;
        this.cuM = 0L;
        this.cuN = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.DragImageView.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        DragImageView.this.aqL();
                        break;
                    case 1:
                        if (DragImageView.this.cuN) {
                            DragImageView.this.aqL();
                            break;
                        }
                        break;
                    case 2:
                        DragImageView.this.invalidate();
                        DragImageView.this.cuM = System.currentTimeMillis();
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
        this.cuf = false;
        this.cug = null;
        this.cdo = 0;
        this.cuh = 1300;
        this.cui = 0;
        this.cuj = null;
        this.cuk = null;
        this.cdg = null;
        this.cdj = null;
        this.cun = 1.0f;
        this.mImageType = 0;
        this.mMode = 0;
        this.cuo = false;
        this.cup = false;
        this.cuq = 0;
        this.cus = null;
        this.cut = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.cuu = 0;
        this.cuv = 0;
        this.cuw = 0;
        this.cux = 0;
        this.cuz = true;
        this.cuE = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.cfa = new Matrix();
        this.ceY = false;
        this.mRatio = 1.0f;
        this.ceZ = 0.0f;
        this.cfc = new RectF();
        this.width = 0;
        this.height = 0;
        this.cuG = 0;
        this.cuH = null;
        this.cuI = new BlockingLinkedDeque<>(5);
        this.cuJ = new BlockingLinkedDeque<>(6);
        this.cuK = 0;
        this.cuM = 0L;
        this.cuN = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.DragImageView.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        DragImageView.this.aqL();
                        break;
                    case 1:
                        if (DragImageView.this.cuN) {
                            DragImageView.this.aqL();
                            break;
                        }
                        break;
                    case 2:
                        DragImageView.this.invalidate();
                        DragImageView.this.cuM = System.currentTimeMillis();
                        DragImageView.this.mHandler.sendEmptyMessage(0);
                        break;
                }
                return false;
            }
        });
        initData();
    }

    public void setDragToExitListener(d dVar) {
        this.cfh = dVar;
    }

    public int getImageType() {
        return this.mImageType;
    }

    public void setImageMode(int i) {
        this.cui = i;
    }

    public void setOffset(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.cdo = i;
    }

    public boolean aqx() {
        if (this.cuC != null) {
            return this.cuC.aqx();
        }
        return false;
    }

    public void aqy() {
        this.cup = false;
        this.cuf = false;
        this.mMode = 3;
        aqE();
        if (this.mCurrentScale < this.cuc) {
            this.mCurrentScale = this.cuc;
            aqK();
        }
        invalidate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.cuC != null && this.cuC.onTouchEvent(motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.cuf = true;
                this.cuo = false;
                this.cup = false;
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
            this.cun = x(motionEvent);
            if (this.cun > 10.0f) {
                this.mMode = 2;
            }
        }
        if ((this.mMode == 2 || !this.mGestureDetector.onTouchEvent(motionEvent)) && this.cuz) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.cuo = true;
                        this.cup = true;
                        if (this.mImageType != 1 && this.mImageType != 2) {
                            float x = x(motionEvent);
                            if (x >= 0.0f && Math.abs(this.cun - x) >= 10.0f) {
                                if (Math.abs(this.cun - x) > 100.0f) {
                                    this.cun = x;
                                    break;
                                } else {
                                    float f2 = x / this.cun;
                                    this.cun = x;
                                    this.cue = this.mCurrentScale;
                                    this.mCurrentScale *= f2;
                                    if (this.mCurrentScale > this.cud) {
                                        this.mCurrentScale = this.cud;
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
        return this.cuC != null ? this.cuC.getMinScaleValue() : this.cuc / 4.0f;
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
        if (this.cuC != null) {
            return this.cuC.arF();
        }
        return this.cuc == this.mCurrentScale;
    }

    protected float o(Bitmap bitmap) {
        if (this.cuC != null) {
            return this.cuC.arJ();
        }
        if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            return 1.0f;
        }
        if (this.cui == 0) {
            float width = this.mViewWidth / bitmap.getWidth();
            float height = this.mViewHeight / bitmap.getHeight();
            if (this.cuA) {
                if (this.mImageType == 2) {
                    return 2.5f;
                }
                return Math.min(width, height);
            } else if (this.mImageType != 2) {
                float f2 = this.cuB;
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
        if (this.cuC != null) {
            return this.cuC.arK();
        }
        float f2 = 1.0f;
        if (bitmap != null && !bitmap.isRecycled() && bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
            f2 = (float) Math.sqrt(this.cuh / (bitmap.getWidth() * bitmap.getHeight()));
            if (f2 > 10.0f) {
                return 10.0f;
            }
        }
        return f2;
    }

    private void aqA() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            this.cuc = o(imageBitmap);
            this.cud = p(imageBitmap);
            this.cub.clear();
            this.cub.add(Float.valueOf(this.cuc));
            this.mCurrentScale = this.cuc;
            this.cue = this.mCurrentScale;
            aqK();
            return;
        }
        this.ctZ = 0.0f;
        this.cua = 0.0f;
        this.cuc = 1.0f;
        this.cud = 1.0f;
        this.mCurrentScale = 1.0f;
        this.cue = this.mCurrentScale;
        this.cub.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    private void aqB() {
        if (this.cuj != null) {
            this.cuj.a(this, canZoomIn(), canZoomOut());
        }
    }

    public void setOnSizeChangedListener(g gVar) {
        this.cuj = gVar;
    }

    public void setOnImageScrollListener(f fVar) {
        this.cum = fVar;
    }

    public byte[] getImageData() {
        return this.cug;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getMeasuredHeight() != 0 && getMeasuredWidth() != 0 && this.cuC != null) {
            this.cuC.arH();
        }
    }

    public void setImageData(Bitmap bitmap, byte[] bArr) {
        this.cug = bArr;
        if (this.cuC != null) {
            this.cuC.a(bitmap, bArr);
        }
        setImageBitmap(bitmap);
    }

    public void aqC() {
        if (this.cuC == null) {
            this.cuC = new com.baidu.tbadk.widget.largeImage.logic.b(this);
            this.cuC.setOnClickListener(this.cuk);
            this.cuC.setOnLongClickListener(this.cdg);
        }
    }

    public void setImageLoadCallBack(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
        if (this.cuC != null) {
            this.cuC.a(aVar);
        }
    }

    public boolean aqD() {
        return (getImageBitmap() == null || this.cuC == null) ? false : true;
    }

    public Bitmap getGifCache() {
        return this.cut;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        boolean z;
        if (this.cuC == null || !this.cuC.b(canvas, getImageBitmap())) {
            if (this.mImageType == 2 && this.cux != 0 && !this.cul.aqO()) {
                int width = getWidth();
                int height = getHeight();
                Drawable drawable = getDrawable();
                float f2 = 0.0f;
                float f3 = height * 0.3f;
                float f4 = width;
                float f5 = (1.0f - 0.3f) * height;
                if (this.cuA && drawable != null) {
                    Rect bounds = drawable.getBounds();
                    int i = bounds.right - bounds.left;
                    int i2 = bounds.bottom - bounds.top;
                    f2 = (width / 2) - (i * 2.5f);
                    f3 = (height / 2) - (i2 * 2.5f);
                    f4 = (i * 2.5f) + (width / 2);
                    f5 = (i2 * 2.5f) + (height / 2);
                }
                this.mPaint.setColor(al.getColor(this.cux));
                canvas.drawRect(f2, f3, f4, f5, this.mPaint);
                this.mPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
            }
            if (this.mMode == 3 && this.ceY) {
                this.ceY = false;
                this.cfa.reset();
                if (this.ceZ < cfi) {
                    this.mMode = 0;
                } else {
                    this.mMode = 4;
                    akr();
                }
            }
            if (this.mImageType == 0 && this.ceY && this.cfb != null && this.cuD != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                if (this.cfc == null) {
                    this.cfc = new RectF();
                }
                this.cfa.mapRect(this.cfc, new RectF(this.cfb));
                Bitmap imageBitmap = getImageBitmap();
                if (imageBitmap != null && !imageBitmap.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.cuF, this.cfc, (Paint) null);
                }
            } else if (this.mMode == 4 && this.cfb != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                Bitmap imageBitmap2 = getImageBitmap();
                if (imageBitmap2 != null && !imageBitmap2.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.cuF, this.cfc, (Paint) null);
                }
            } else {
                super.onDraw(canvas);
            }
            if (this.mImageType == 1 && this.cut != null && !this.cut.isRecycled()) {
                int width2 = this.cut.getWidth();
                int height2 = this.cut.getHeight();
                int width3 = getWidth();
                int height3 = getHeight();
                int i3 = (width3 - width2) >> 1;
                int i4 = (height3 - height2) >> 1;
                float f6 = this.cuB;
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
                if (this.cuq == 1 && this.cus != null && this.cuH != null && this.cuH.cuX != null) {
                    if (z) {
                        canvas.drawBitmap(this.cuH.cuX, i3, i4, (Paint) null);
                    } else {
                        canvas.drawBitmap(this.cuH.cuX, this.mMatrix, this.mPaint);
                    }
                    invalidate();
                } else if (z) {
                    canvas.drawBitmap(this.cut, i3, i4, (Paint) null);
                } else {
                    canvas.drawBitmap(this.cut, this.mMatrix, this.mPaint);
                }
            }
        }
    }

    public void play() {
        com.baidu.adp.widget.ImageView.a aVar;
        if (this.mImageType == 1) {
            if (this.cus == null) {
                if (this.cuL != null) {
                    this.cuL.Es = false;
                    this.cuL.interrupt();
                    this.cuL = null;
                }
                if (this.cug != null) {
                    try {
                        aVar = a.C0013a.hv().g(this.cug, 0, this.cug.length);
                    } catch (StackOverflowError e2) {
                        aVar = null;
                    }
                    if (aVar == null || aVar.getGif() == null) {
                        com.baidu.tbadk.core.d.a.a("gifplay", -1L, -1, "DragImageView.play", -1, "decode error", new Object[0]);
                        return;
                    }
                    this.cus = aVar.getGif();
                    if (this.cus != null) {
                        this.cuq = 1;
                        this.width = this.cus.getWidth();
                        this.height = this.cus.getHeight();
                        this.cuK = 0;
                        this.cuG = this.cus.getFrameCount();
                    } else {
                        this.cuq = 0;
                    }
                } else {
                    return;
                }
            }
            if (this.cus != null) {
                if (this.cuL == null || (this.cuL != null && !this.cuL.Es)) {
                    this.cuN = true;
                    this.cuL = new b();
                    this.cuI.clear();
                    this.cuJ.clear();
                    this.cuL.Es = true;
                    this.cuL.start();
                }
            }
        }
    }

    public void pause() {
        if (this.mImageType == 1) {
            if (this.cuL != null) {
                this.cuL.Es = false;
                this.cuL.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.mImageType == 1) {
            if (this.cuL != null) {
                this.cuL.Es = false;
                this.cuL.interrupt();
                this.cuL = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.cuN = true;
            this.cuH = null;
            this.cuJ.clear();
            this.cuI.clear();
            this.width = 0;
            this.height = 0;
            this.cuK = 0;
            this.cuG = 0;
            this.cus = null;
        }
    }

    private void initData() {
        this.cuB = l.aR(getContext());
        this.cuh = l.aQ(getContext()) * l.aO(getContext()) * 2;
        if (this.cuh < 1690000) {
            this.cuh = 1690000;
        }
        this.ctZ = 0.0f;
        this.cua = 0.0f;
        this.cub = new ArrayList<>();
        this.cuc = 1.0f;
        this.cud = 1.0f;
        this.mCurrentScale = 1.0f;
        this.cue = this.mCurrentScale;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.cul = new a();
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
                    DragImageView.this.cul.s(f2, f3);
                    DragImageView.this.startAnimation(DragImageView.this.cul);
                }
                return super.onFling(motionEvent, motionEvent2, f2, f3);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (DragImageView.this.mImageType == 1 || DragImageView.this.mImageType == 2 || !DragImageView.this.cuz) {
                    return false;
                }
                DragImageView.this.mMode = 2;
                if (DragImageView.this.mCurrentScale > DragImageView.this.cuc) {
                    DragImageView.this.mCurrentScale = DragImageView.this.cuc;
                    DragImageView.this.cue = DragImageView.this.mCurrentScale;
                    DragImageView.this.aqK();
                } else {
                    DragImageView.this.mCurrentScale = DragImageView.this.cuc * 2.0f;
                    DragImageView.this.a(true, (int) motionEvent.getX(), (int) motionEvent.getY());
                }
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (DragImageView.this.cuk != null && !DragImageView.this.cuo) {
                    DragImageView.this.cuk.onClick(DragImageView.this);
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
                DragImageView.this.cuo = true;
                if (DragImageView.this.cui == 0 && DragImageView.this.cup) {
                    return false;
                }
                int scrollX = DragImageView.this.getScrollX();
                int scrollY = DragImageView.this.getScrollY();
                if (DragImageView.this.ctZ >= DragImageView.this.getWidth()) {
                    scrollX = (int) (scrollX + f2);
                    if (DragImageView.this.cui == 0) {
                        i = scrollX >= 0 ? scrollX : 0;
                        if (DragImageView.this.getWidth() + i > DragImageView.this.ctZ) {
                            i = (int) (DragImageView.this.ctZ - DragImageView.this.getWidth());
                        }
                        if (DragImageView.this.cua + DragImageView.this.mTop + DragImageView.this.mBottom < DragImageView.this.getHeight()) {
                            i2 = (int) (scrollY + f3);
                            if (DragImageView.this.cui == 0) {
                                if (i2 < (-DragImageView.this.cuu)) {
                                    i2 = -DragImageView.this.cuu;
                                }
                                if (DragImageView.this.getHeight() + i2 > DragImageView.this.cua + DragImageView.this.mBottom + DragImageView.this.cuv) {
                                    i2 = (int) ((DragImageView.this.cua - DragImageView.this.getHeight()) + DragImageView.this.mBottom + DragImageView.this.cuv);
                                }
                            }
                        } else {
                            i2 = scrollY;
                        }
                        if (i == DragImageView.this.getScrollX() || i2 != DragImageView.this.getScrollY()) {
                            DragImageView.this.scrollTo(i, i2);
                            DragImageView.this.invalidate();
                            if (DragImageView.this.cum != null) {
                                DragImageView.this.cum.a(DragImageView.this, i, i2);
                            }
                        }
                        return true;
                    }
                }
                i = scrollX;
                if (DragImageView.this.cua + DragImageView.this.mTop + DragImageView.this.mBottom < DragImageView.this.getHeight()) {
                }
                if (i == DragImageView.this.getScrollX()) {
                }
                DragImageView.this.scrollTo(i, i2);
                DragImageView.this.invalidate();
                if (DragImageView.this.cum != null) {
                }
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (DragImageView.this.cdg != null && !DragImageView.this.cuo) {
                    DragImageView.this.cdg.onLongClick(DragImageView.this);
                }
                super.onLongPress(motionEvent);
            }
        });
    }

    private void akr() {
        if (this.cuD == null) {
            if (this.cfh != null) {
                this.cfh.aqQ();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.cuD.getSourceImageRectInScreen();
        if (sourceImageRectInScreen == null) {
            if (this.cfh != null) {
                this.cfh.aqQ();
                return;
            }
            return;
        }
        this.cfc.bottom = (((sourceImageRectInScreen.bottom - sourceImageRectInScreen.top) / (sourceImageRectInScreen.right - sourceImageRectInScreen.left)) * (this.cfc.right - this.cfc.left)) + this.cfc.top;
        final float[] fArr = {(this.cfc.left + this.cfc.right) / 2.0f, (this.cfc.top + this.cfc.bottom) / 2.0f};
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
                    DragImageView.this.cfc = DragImageView.this.h(floatValue, animatedFraction, sourceImageRectInScreen.right - sourceImageRectInScreen.left, sourceImageRectInScreen.bottom - sourceImageRectInScreen.top);
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
                DragImageView.this.ceY = false;
                DragImageView.this.mMode = 4;
                DragImageView.this.invalidate();
                if (DragImageView.this.cfh != null) {
                    DragImageView.this.cfh.aqQ();
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
        if (this.ctZ >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.ctZ) {
                scrollX = (int) (this.ctZ - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.cua + this.mTop + this.mBottom >= getHeight()) {
            i = scrollY < (-this.cuu) ? -this.cuu : scrollY;
            if (getHeight() + i > this.cua + this.mBottom + this.cuv) {
                i = (int) ((this.cua - getHeight()) + this.mBottom + this.cuv);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
            if (this.cum != null) {
                this.cum.a(this, scrollX, i);
            }
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.cuC != null) {
            this.cuC.arG();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.ctZ;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.cua;
    }

    public boolean aqF() {
        if (this.mImageType == 1 || this.mImageType == 2) {
            return true;
        }
        return !this.cup && getScrollX() >= ((int) (this.ctZ - ((float) getWidth()))) + (-1);
    }

    public boolean aqG() {
        if (this.mImageType == 1 || this.mImageType == 2) {
            return true;
        }
        return !this.cup && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.cul.aqO()) {
            this.cul.stopAnimation();
        }
        this.cux = 0;
        super.setImageBitmap(bitmap);
        aqA();
        this.mImageType = 0;
        if (this.cfb == null) {
            int measuredWidth = getMeasuredWidth();
            float measuredWidth2 = ((1.0f * getMeasuredWidth()) / bitmap.getWidth()) * bitmap.getHeight();
            if (measuredWidth2 > getMeasuredHeight()) {
                measuredWidth2 = getMeasuredHeight();
            }
            RectF h = h(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
            this.cfb = new Rect((int) h.left, (int) h.top, (int) h.right, (int) h.bottom);
        }
        if (this.cuF == null) {
            this.cuF = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
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
            if (this.cul.aqO()) {
                this.cul.stopAnimation();
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
        if (this.cul.aqO()) {
            this.cul.stopAnimation();
        }
        super.setImageDrawable(null);
        stop();
        aqA();
        this.mImageType = 1;
        this.cut = bitmap;
        this.cug = bArr;
        if (this.cdj != null) {
            this.cdj.a(this);
        }
    }

    public void onDestroy() {
        if (this.cul.aqO()) {
            this.cul.stopAnimation();
        }
        super.setImageDrawable(null);
        this.cug = null;
        this.cut = null;
        stop();
        if (this.cus != null) {
            this.cus.close();
            this.cus = null;
        }
        if (this.cuC != null) {
            this.cuC.release();
            System.gc();
        }
    }

    public void release() {
        if (this.cul.aqO()) {
            this.cul.stopAnimation();
        }
        stop();
        super.setImageDrawable(null);
        this.cut = null;
    }

    public void setDefaultBitmap() {
        if (this.cul.aqO()) {
            this.cul.stopAnimation();
        }
        try {
            if (this.cuA) {
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
            int size = this.cub.size();
            if (size > 0) {
                this.cub.add(Float.valueOf(this.cub.get(size - 1).floatValue() * 1.25f));
            } else {
                this.cub.add(Float.valueOf(this.cuc));
            }
            aqK();
        }
    }

    public void aqI() {
        if (this.mImageType != 1 && this.mImageType != 2) {
            int size = this.cub.size();
            if (size > 1) {
                this.cub.remove(size - 1);
            }
            aqK();
        }
    }

    public void aqJ() {
        aqB();
        if (this.mImageType != 1 && this.mImageType != 2 && this.mCurrentScale != this.cuc) {
            this.cub.clear();
            this.cub.add(Float.valueOf(this.cuc));
            this.mCurrentScale = this.cuc;
            this.cue = this.mCurrentScale;
            aqK();
        }
    }

    public boolean canZoomIn() {
        if (this.mImageType == 1 || this.mImageType == 2) {
            return false;
        }
        int size = this.cub.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.cub.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.cuh) && floatValue <= 5.0f;
    }

    public boolean canZoomOut() {
        if (this.mImageType == 1 || this.mImageType == 2) {
            return false;
        }
        int size = this.cub.size();
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
                    int size = this.cub.size();
                    if (size > 0) {
                        f3 = this.cub.get(size - 1).floatValue();
                    } else {
                        f3 = this.cuc;
                    }
                    this.mCurrentScale = f3;
                }
                this.mMatrix.setScale(this.mCurrentScale, this.mCurrentScale);
                this.ctZ = imageBitmap.getWidth() * this.mCurrentScale;
                this.cua = imageBitmap.getHeight() * this.mCurrentScale;
                float width = this.cue * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.cue;
                this.cuu = this.mTop;
                this.cuv = 0;
                float f4 = this.ctZ < ((float) this.mViewWidth) ? (int) ((this.mViewWidth - this.ctZ) / 2.0f) : 0.0f;
                if (this.cua < this.mViewHeight) {
                    f2 = (int) ((this.mViewHeight - this.cua) / 2.0f);
                    if (this.cui == 1 && f2 > this.mTop) {
                        f2 = this.mTop;
                    }
                    this.cuu = (int) (this.mTop - f2);
                    this.cuv = this.mTop - this.cuu;
                } else {
                    f2 = 0.0f;
                }
                this.cuw = (int) f4;
                this.mMatrix.postTranslate(f4, f2);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    int width2 = i > getWidth() ? getWidth() : i;
                    if (this.ctZ <= screenWidth) {
                        width2 = 0;
                    } else if (this.ctZ > screenWidth && this.ctZ / 2.0f < screenWidth) {
                        width2 = (int) (width2 - (this.ctZ / 4.0f));
                    }
                    scrollX = width2;
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.ctZ - width) / 2.0f);
                    }
                    if (this.ctZ <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.ctZ) {
                        scrollX = (int) (this.ctZ - getWidth());
                    }
                }
                if (scrollX > 0 && this.ctZ - scrollX < getWidth()) {
                    scrollX = (int) (this.ctZ - getWidth());
                }
                int i3 = this.mMode == 2 ? ((int) ((this.cua - height) / 2.0f)) + scrollY : scrollY;
                if (this.cua <= getHeight()) {
                    i3 = 0;
                } else if (getHeight() + i3 > this.cua) {
                    i3 = (int) (this.cua - getHeight());
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
        private boolean cuR = false;
        private boolean cuS = false;
        private long cuT;
        private long cuU;
        private long cuV;
        private long cuW;
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
            this.cuT = f;
            this.cuU = f2;
            this.cuV = Math.abs((f * 1000.0f) / 2500.0f);
            this.cuW = Math.abs((f2 * 1000.0f) / 2500.0f);
            setDuration(Math.max(this.cuV, this.cuW));
            setInterpolator(DragImageView.this.cuE);
            this.mStartX = DragImageView.this.getScrollX();
            this.mStartY = DragImageView.this.getScrollY();
            this.cuR = true;
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
            if (this.cuV > this.cuW) {
                j = ((float) this.cuV) * f;
            } else {
                j = ((float) this.cuW) * f;
            }
            float f2 = ((float) (j > this.cuV ? this.cuV : j)) / 1000.0f;
            if (this.cuT > 0) {
                i = this.mStartX - ((int) (f2 * (((float) this.cuT) - ((2500.0f * f2) / 2.0f))));
            } else {
                i = this.mStartX - ((int) (f2 * (((float) this.cuT) + ((2500.0f * f2) / 2.0f))));
            }
            if (j > this.cuW) {
                j = this.cuW;
            }
            float f3 = ((float) j) / 1000.0f;
            if (this.cuU > 0) {
                i2 = this.mStartY - ((int) (f3 * (((float) this.cuU) - ((2500.0f * f3) / 2.0f))));
            } else {
                i2 = this.mStartY - ((int) (f3 * (((float) this.cuU) + ((2500.0f * f3) / 2.0f))));
            }
            if (DragImageView.this.cua + DragImageView.this.mTop + DragImageView.this.mBottom > DragImageView.this.getHeight()) {
                if (i2 < (-DragImageView.this.cuu)) {
                    i2 = -DragImageView.this.cuu;
                }
                if (DragImageView.this.getHeight() + i2 > DragImageView.this.cua + DragImageView.this.mBottom + DragImageView.this.cuv) {
                    i2 = (int) ((DragImageView.this.cua - DragImageView.this.getHeight()) + DragImageView.this.mBottom + DragImageView.this.cuv);
                }
            } else {
                i2 = 0;
            }
            if (DragImageView.this.ctZ > DragImageView.this.getWidth()) {
                int width = ((float) (DragImageView.this.getWidth() + i)) > DragImageView.this.ctZ ? (int) (DragImageView.this.ctZ - DragImageView.this.getWidth()) : i;
                if (width >= 0) {
                    i3 = width;
                }
            }
            DragImageView.this.scrollTo(i3, i2);
            DragImageView.this.invalidate();
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            if (!this.cuS) {
                if (DragImageView.this.cuf) {
                    this.cuR = false;
                    return false;
                }
                try {
                    if (super.getTransformation(j, transformation)) {
                        return true;
                    }
                    this.cuR = false;
                    return false;
                } catch (Exception e) {
                    this.cuR = false;
                    return false;
                }
            }
            this.cuS = false;
            this.cuR = false;
            return false;
        }

        public boolean aqO() {
            return this.cuR;
        }

        public void stopAnimation() {
            this.cuS = true;
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.cuk = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cdg = onLongClickListener;
        if (this.cuC != null) {
            this.cuC.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setGifSetListener(e eVar) {
        this.cdj = eVar;
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
        c poll = this.cuI.poll();
        if (poll == null) {
            this.cuN = true;
            return;
        }
        this.cuN = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.cuH != null) {
            j = this.cuH.delay - (currentTimeMillis - this.cuM);
            this.cuJ.offer(this.cuH);
        } else {
            j = 0;
        }
        this.cuH = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public c aqM() {
        c poll = this.cuJ.poll();
        if (poll == null) {
            poll = new c();
            try {
                poll.cuX = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
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
        return this.cuH;
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
            while (this.Es && DragImageView.this.cus != null && DragImageView.this.cuG > 0 && DragImageView.this.width > 0 && DragImageView.this.height > 0) {
                try {
                    DragImageView.this.cus.U(DragImageView.this.cuK);
                    c aqM = DragImageView.this.aqM();
                    if (aqM.cuX == null || (aqM.cuX.getWidth() != DragImageView.this.width && aqM.cuX.getHeight() != DragImageView.this.height)) {
                        try {
                            aqM.cuX = Bitmap.createBitmap(DragImageView.this.width, DragImageView.this.height, Bitmap.Config.ARGB_8888);
                        } catch (OutOfMemoryError e) {
                            TbadkCoreApplication.getInst().onAppMemoryLow();
                            try {
                                aqM.cuX = Bitmap.createBitmap(DragImageView.this.width, DragImageView.this.height, Bitmap.Config.ARGB_4444);
                            } catch (OutOfMemoryError e2) {
                                TbadkCoreApplication.getInst().onAppMemoryLow();
                            } catch (Throwable th) {
                                BdLog.e(th.getMessage());
                            }
                        } catch (Throwable th2) {
                            BdLog.e(th2.getMessage());
                        }
                    }
                    DragImageView.this.cus.a(aqM.cuX, null);
                    aqM.delay = DragImageView.this.cus.V(DragImageView.this.cuK);
                    DragImageView.C(DragImageView.this);
                    if (aqM.cuX == null) {
                        DragImageView.C(DragImageView.this);
                    }
                    DragImageView.this.cuK %= DragImageView.this.cuG;
                    DragImageView.this.cuI.put(aqM);
                    if (DragImageView.this.cuN) {
                        DragImageView.this.mHandler.sendEmptyMessage(1);
                    }
                } catch (Exception e3) {
                    return;
                }
            }
        }
    }

    public boolean aqN() {
        return this.cuy;
    }

    public void setLoadBigImage(boolean z) {
        this.cuy = z;
    }

    public int getBottomOffset() {
        return this.cuv;
    }

    public int getLeftOffset() {
        return this.cuw;
    }
}
