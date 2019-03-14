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
    private static final int cff = l.aQ(TbadkCoreApplication.getInst()) / 5;
    private View.OnLongClickListener cdd;
    private e cdg;
    private int cdl;
    private boolean ceV;
    private float ceW;
    private Matrix ceX;
    private Rect ceY;
    private RectF ceZ;
    private d cfe;
    private float ctW;
    private float ctX;
    private ArrayList<Float> ctY;
    private float ctZ;
    private ImageUrlData cuA;
    private Interpolator cuB;
    private Rect cuC;
    private int cuD;
    private c cuE;
    private BlockingLinkedDeque<c> cuF;
    private BlockingLinkedDeque<c> cuG;
    private volatile int cuH;
    private b cuI;
    private volatile long cuJ;
    private volatile boolean cuK;
    private float cua;
    private float cub;
    private boolean cuc;
    private byte[] cud;
    private int cue;
    private int cuf;
    private g cug;
    private View.OnClickListener cuh;
    private a cui;
    private f cuj;
    private float cuk;
    private boolean cul;
    private boolean cum;
    private int cun;
    private volatile com.baidu.adp.gif.b cuo;
    private Bitmap cup;
    private int cuq;
    private int cus;
    private int cut;
    private int cuu;
    private boolean cuv;
    private boolean cuw;
    private boolean cux;
    private float cuy;
    private com.baidu.tbadk.widget.largeImage.logic.b cuz;
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
        public Bitmap cuU;
        public int delay;
    }

    /* loaded from: classes.dex */
    public interface d {
        void aqS();

        void aqT();

        void aqU();
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
        int i = dragImageView.cuH;
        dragImageView.cuH = i + 1;
        return i;
    }

    public void setIsHeadImage(boolean z) {
        this.cux = z;
    }

    public void setImageUrlData(ImageUrlData imageUrlData) {
        this.cuA = imageUrlData;
    }

    public void setCanScale(boolean z) {
        this.cuw = z;
    }

    public DragImageView(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.cuc = false;
        this.cud = null;
        this.cdl = 0;
        this.cue = 1300;
        this.cuf = 0;
        this.cug = null;
        this.cuh = null;
        this.cdd = null;
        this.cdg = null;
        this.cuk = 1.0f;
        this.mImageType = 0;
        this.mMode = 0;
        this.cul = false;
        this.cum = false;
        this.cun = 0;
        this.cuo = null;
        this.cup = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.cuq = 0;
        this.cus = 0;
        this.cut = 0;
        this.cuu = 0;
        this.cuw = true;
        this.cuB = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.ceX = new Matrix();
        this.ceV = false;
        this.mRatio = 1.0f;
        this.ceW = 0.0f;
        this.ceZ = new RectF();
        this.width = 0;
        this.height = 0;
        this.cuD = 0;
        this.cuE = null;
        this.cuF = new BlockingLinkedDeque<>(5);
        this.cuG = new BlockingLinkedDeque<>(6);
        this.cuH = 0;
        this.cuJ = 0L;
        this.cuK = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.DragImageView.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        DragImageView.this.aqO();
                        break;
                    case 1:
                        if (DragImageView.this.cuK) {
                            DragImageView.this.aqO();
                            break;
                        }
                        break;
                    case 2:
                        DragImageView.this.invalidate();
                        DragImageView.this.cuJ = System.currentTimeMillis();
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
        this.cuc = false;
        this.cud = null;
        this.cdl = 0;
        this.cue = 1300;
        this.cuf = 0;
        this.cug = null;
        this.cuh = null;
        this.cdd = null;
        this.cdg = null;
        this.cuk = 1.0f;
        this.mImageType = 0;
        this.mMode = 0;
        this.cul = false;
        this.cum = false;
        this.cun = 0;
        this.cuo = null;
        this.cup = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.cuq = 0;
        this.cus = 0;
        this.cut = 0;
        this.cuu = 0;
        this.cuw = true;
        this.cuB = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.ceX = new Matrix();
        this.ceV = false;
        this.mRatio = 1.0f;
        this.ceW = 0.0f;
        this.ceZ = new RectF();
        this.width = 0;
        this.height = 0;
        this.cuD = 0;
        this.cuE = null;
        this.cuF = new BlockingLinkedDeque<>(5);
        this.cuG = new BlockingLinkedDeque<>(6);
        this.cuH = 0;
        this.cuJ = 0L;
        this.cuK = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.DragImageView.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        DragImageView.this.aqO();
                        break;
                    case 1:
                        if (DragImageView.this.cuK) {
                            DragImageView.this.aqO();
                            break;
                        }
                        break;
                    case 2:
                        DragImageView.this.invalidate();
                        DragImageView.this.cuJ = System.currentTimeMillis();
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
        this.cuc = false;
        this.cud = null;
        this.cdl = 0;
        this.cue = 1300;
        this.cuf = 0;
        this.cug = null;
        this.cuh = null;
        this.cdd = null;
        this.cdg = null;
        this.cuk = 1.0f;
        this.mImageType = 0;
        this.mMode = 0;
        this.cul = false;
        this.cum = false;
        this.cun = 0;
        this.cuo = null;
        this.cup = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.cuq = 0;
        this.cus = 0;
        this.cut = 0;
        this.cuu = 0;
        this.cuw = true;
        this.cuB = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.ceX = new Matrix();
        this.ceV = false;
        this.mRatio = 1.0f;
        this.ceW = 0.0f;
        this.ceZ = new RectF();
        this.width = 0;
        this.height = 0;
        this.cuD = 0;
        this.cuE = null;
        this.cuF = new BlockingLinkedDeque<>(5);
        this.cuG = new BlockingLinkedDeque<>(6);
        this.cuH = 0;
        this.cuJ = 0L;
        this.cuK = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.DragImageView.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        DragImageView.this.aqO();
                        break;
                    case 1:
                        if (DragImageView.this.cuK) {
                            DragImageView.this.aqO();
                            break;
                        }
                        break;
                    case 2:
                        DragImageView.this.invalidate();
                        DragImageView.this.cuJ = System.currentTimeMillis();
                        DragImageView.this.mHandler.sendEmptyMessage(0);
                        break;
                }
                return false;
            }
        });
        initData();
    }

    public void setDragToExitListener(d dVar) {
        this.cfe = dVar;
    }

    public int getImageType() {
        return this.mImageType;
    }

    public void setImageMode(int i) {
        this.cuf = i;
    }

    public void setOffset(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.cdl = i;
    }

    public boolean aqA() {
        if (this.cuz != null) {
            return this.cuz.aqA();
        }
        return false;
    }

    public void aqB() {
        this.cum = false;
        this.cuc = false;
        this.mMode = 3;
        aqH();
        if (this.mCurrentScale < this.ctZ) {
            this.mCurrentScale = this.ctZ;
            aqN();
        }
        invalidate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.cuz != null && this.cuz.onTouchEvent(motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.cuc = true;
                this.cul = false;
                this.cum = false;
                break;
            case 1:
                aqB();
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
            this.cuk = x(motionEvent);
            if (this.cuk > 10.0f) {
                this.mMode = 2;
            }
        }
        if ((this.mMode == 2 || !this.mGestureDetector.onTouchEvent(motionEvent)) && this.cuw) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.cul = true;
                        this.cum = true;
                        if (this.mImageType != 1 && this.mImageType != 2) {
                            float x = x(motionEvent);
                            if (x >= 0.0f && Math.abs(this.cuk - x) >= 10.0f) {
                                if (Math.abs(this.cuk - x) > 100.0f) {
                                    this.cuk = x;
                                    break;
                                } else {
                                    float f2 = x / this.cuk;
                                    this.cuk = x;
                                    this.cub = this.mCurrentScale;
                                    this.mCurrentScale *= f2;
                                    if (this.mCurrentScale > this.cua) {
                                        this.mCurrentScale = this.cua;
                                    }
                                    float minScaleValue = getMinScaleValue();
                                    if (this.mCurrentScale < minScaleValue) {
                                        this.mCurrentScale = minScaleValue;
                                    }
                                    aqN();
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
        return this.cuz != null ? this.cuz.getMinScaleValue() : this.ctZ / 4.0f;
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
            aqD();
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public boolean aqC() {
        if (this.cuz != null) {
            return this.cuz.arI();
        }
        return this.ctZ == this.mCurrentScale;
    }

    protected float o(Bitmap bitmap) {
        if (this.cuz != null) {
            return this.cuz.arM();
        }
        if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            return 1.0f;
        }
        if (this.cuf == 0) {
            float width = this.mViewWidth / bitmap.getWidth();
            float height = this.mViewHeight / bitmap.getHeight();
            if (this.cux) {
                if (this.mImageType == 2) {
                    return 2.5f;
                }
                return Math.min(width, height);
            } else if (this.mImageType != 2) {
                float f2 = this.cuy;
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
        if (this.cuz != null) {
            return this.cuz.arN();
        }
        float f2 = 1.0f;
        if (bitmap != null && !bitmap.isRecycled() && bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
            f2 = (float) Math.sqrt(this.cue / (bitmap.getWidth() * bitmap.getHeight()));
            if (f2 > 10.0f) {
                return 10.0f;
            }
        }
        return f2;
    }

    private void aqD() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            this.ctZ = o(imageBitmap);
            this.cua = p(imageBitmap);
            this.ctY.clear();
            this.ctY.add(Float.valueOf(this.ctZ));
            this.mCurrentScale = this.ctZ;
            this.cub = this.mCurrentScale;
            aqN();
            return;
        }
        this.ctW = 0.0f;
        this.ctX = 0.0f;
        this.ctZ = 1.0f;
        this.cua = 1.0f;
        this.mCurrentScale = 1.0f;
        this.cub = this.mCurrentScale;
        this.ctY.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    private void aqE() {
        if (this.cug != null) {
            this.cug.a(this, canZoomIn(), canZoomOut());
        }
    }

    public void setOnSizeChangedListener(g gVar) {
        this.cug = gVar;
    }

    public void setOnImageScrollListener(f fVar) {
        this.cuj = fVar;
    }

    public byte[] getImageData() {
        return this.cud;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getMeasuredHeight() != 0 && getMeasuredWidth() != 0 && this.cuz != null) {
            this.cuz.arK();
        }
    }

    public void setImageData(Bitmap bitmap, byte[] bArr) {
        this.cud = bArr;
        if (this.cuz != null) {
            this.cuz.a(bitmap, bArr);
        }
        setImageBitmap(bitmap);
    }

    public void aqF() {
        if (this.cuz == null) {
            this.cuz = new com.baidu.tbadk.widget.largeImage.logic.b(this);
            this.cuz.setOnClickListener(this.cuh);
            this.cuz.setOnLongClickListener(this.cdd);
        }
    }

    public void setImageLoadCallBack(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
        if (this.cuz != null) {
            this.cuz.a(aVar);
        }
    }

    public boolean aqG() {
        return (getImageBitmap() == null || this.cuz == null) ? false : true;
    }

    public Bitmap getGifCache() {
        return this.cup;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        boolean z;
        if (this.cuz == null || !this.cuz.b(canvas, getImageBitmap())) {
            if (this.mImageType == 2 && this.cuu != 0 && !this.cui.aqR()) {
                int width = getWidth();
                int height = getHeight();
                Drawable drawable = getDrawable();
                float f2 = 0.0f;
                float f3 = height * 0.3f;
                float f4 = width;
                float f5 = (1.0f - 0.3f) * height;
                if (this.cux && drawable != null) {
                    Rect bounds = drawable.getBounds();
                    int i = bounds.right - bounds.left;
                    int i2 = bounds.bottom - bounds.top;
                    f2 = (width / 2) - (i * 2.5f);
                    f3 = (height / 2) - (i2 * 2.5f);
                    f4 = (i * 2.5f) + (width / 2);
                    f5 = (i2 * 2.5f) + (height / 2);
                }
                this.mPaint.setColor(al.getColor(this.cuu));
                canvas.drawRect(f2, f3, f4, f5, this.mPaint);
                this.mPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
            }
            if (this.mMode == 3 && this.ceV) {
                this.ceV = false;
                this.ceX.reset();
                if (this.ceW < cff) {
                    this.mMode = 0;
                } else {
                    this.mMode = 4;
                    aku();
                }
            }
            if (this.mImageType == 0 && this.ceV && this.ceY != null && this.cuA != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                if (this.ceZ == null) {
                    this.ceZ = new RectF();
                }
                this.ceX.mapRect(this.ceZ, new RectF(this.ceY));
                Bitmap imageBitmap = getImageBitmap();
                if (imageBitmap != null && !imageBitmap.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.cuC, this.ceZ, (Paint) null);
                }
            } else if (this.mMode == 4 && this.ceY != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                Bitmap imageBitmap2 = getImageBitmap();
                if (imageBitmap2 != null && !imageBitmap2.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.cuC, this.ceZ, (Paint) null);
                }
            } else {
                super.onDraw(canvas);
            }
            if (this.mImageType == 1 && this.cup != null && !this.cup.isRecycled()) {
                int width2 = this.cup.getWidth();
                int height2 = this.cup.getHeight();
                int width3 = getWidth();
                int height3 = getHeight();
                int i3 = (width3 - width2) >> 1;
                int i4 = (height3 - height2) >> 1;
                float f6 = this.cuy;
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
                if (this.cun == 1 && this.cuo != null && this.cuE != null && this.cuE.cuU != null) {
                    if (z) {
                        canvas.drawBitmap(this.cuE.cuU, i3, i4, (Paint) null);
                    } else {
                        canvas.drawBitmap(this.cuE.cuU, this.mMatrix, this.mPaint);
                    }
                    invalidate();
                } else if (z) {
                    canvas.drawBitmap(this.cup, i3, i4, (Paint) null);
                } else {
                    canvas.drawBitmap(this.cup, this.mMatrix, this.mPaint);
                }
            }
        }
    }

    public void play() {
        com.baidu.adp.widget.ImageView.a aVar;
        if (this.mImageType == 1) {
            if (this.cuo == null) {
                if (this.cuI != null) {
                    this.cuI.Es = false;
                    this.cuI.interrupt();
                    this.cuI = null;
                }
                if (this.cud != null) {
                    try {
                        aVar = a.C0013a.hv().g(this.cud, 0, this.cud.length);
                    } catch (StackOverflowError e2) {
                        aVar = null;
                    }
                    if (aVar == null || aVar.getGif() == null) {
                        com.baidu.tbadk.core.d.a.a("gifplay", -1L, -1, "DragImageView.play", -1, "decode error", new Object[0]);
                        return;
                    }
                    this.cuo = aVar.getGif();
                    if (this.cuo != null) {
                        this.cun = 1;
                        this.width = this.cuo.getWidth();
                        this.height = this.cuo.getHeight();
                        this.cuH = 0;
                        this.cuD = this.cuo.getFrameCount();
                    } else {
                        this.cun = 0;
                    }
                } else {
                    return;
                }
            }
            if (this.cuo != null) {
                if (this.cuI == null || (this.cuI != null && !this.cuI.Es)) {
                    this.cuK = true;
                    this.cuI = new b();
                    this.cuF.clear();
                    this.cuG.clear();
                    this.cuI.Es = true;
                    this.cuI.start();
                }
            }
        }
    }

    public void pause() {
        if (this.mImageType == 1) {
            if (this.cuI != null) {
                this.cuI.Es = false;
                this.cuI.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.mImageType == 1) {
            if (this.cuI != null) {
                this.cuI.Es = false;
                this.cuI.interrupt();
                this.cuI = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.cuK = true;
            this.cuE = null;
            this.cuG.clear();
            this.cuF.clear();
            this.width = 0;
            this.height = 0;
            this.cuH = 0;
            this.cuD = 0;
            this.cuo = null;
        }
    }

    private void initData() {
        this.cuy = l.aR(getContext());
        this.cue = l.aQ(getContext()) * l.aO(getContext()) * 2;
        if (this.cue < 1690000) {
            this.cue = 1690000;
        }
        this.ctW = 0.0f;
        this.ctX = 0.0f;
        this.ctY = new ArrayList<>();
        this.ctZ = 1.0f;
        this.cua = 1.0f;
        this.mCurrentScale = 1.0f;
        this.cub = this.mCurrentScale;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.cui = new a();
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
                    DragImageView.this.cui.s(f2, f3);
                    DragImageView.this.startAnimation(DragImageView.this.cui);
                }
                return super.onFling(motionEvent, motionEvent2, f2, f3);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (DragImageView.this.mImageType == 1 || DragImageView.this.mImageType == 2 || !DragImageView.this.cuw) {
                    return false;
                }
                DragImageView.this.mMode = 2;
                if (DragImageView.this.mCurrentScale > DragImageView.this.ctZ) {
                    DragImageView.this.mCurrentScale = DragImageView.this.ctZ;
                    DragImageView.this.cub = DragImageView.this.mCurrentScale;
                    DragImageView.this.aqN();
                } else {
                    DragImageView.this.mCurrentScale = DragImageView.this.ctZ * 2.0f;
                    DragImageView.this.a(true, (int) motionEvent.getX(), (int) motionEvent.getY());
                }
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (DragImageView.this.cuh != null && !DragImageView.this.cul) {
                    DragImageView.this.cuh.onClick(DragImageView.this);
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
                DragImageView.this.cul = true;
                if (DragImageView.this.cuf == 0 && DragImageView.this.cum) {
                    return false;
                }
                int scrollX = DragImageView.this.getScrollX();
                int scrollY = DragImageView.this.getScrollY();
                if (DragImageView.this.ctW >= DragImageView.this.getWidth()) {
                    scrollX = (int) (scrollX + f2);
                    if (DragImageView.this.cuf == 0) {
                        i = scrollX >= 0 ? scrollX : 0;
                        if (DragImageView.this.getWidth() + i > DragImageView.this.ctW) {
                            i = (int) (DragImageView.this.ctW - DragImageView.this.getWidth());
                        }
                        if (DragImageView.this.ctX + DragImageView.this.mTop + DragImageView.this.mBottom < DragImageView.this.getHeight()) {
                            i2 = (int) (scrollY + f3);
                            if (DragImageView.this.cuf == 0) {
                                if (i2 < (-DragImageView.this.cuq)) {
                                    i2 = -DragImageView.this.cuq;
                                }
                                if (DragImageView.this.getHeight() + i2 > DragImageView.this.ctX + DragImageView.this.mBottom + DragImageView.this.cus) {
                                    i2 = (int) ((DragImageView.this.ctX - DragImageView.this.getHeight()) + DragImageView.this.mBottom + DragImageView.this.cus);
                                }
                            }
                        } else {
                            i2 = scrollY;
                        }
                        if (i == DragImageView.this.getScrollX() || i2 != DragImageView.this.getScrollY()) {
                            DragImageView.this.scrollTo(i, i2);
                            DragImageView.this.invalidate();
                            if (DragImageView.this.cuj != null) {
                                DragImageView.this.cuj.a(DragImageView.this, i, i2);
                            }
                        }
                        return true;
                    }
                }
                i = scrollX;
                if (DragImageView.this.ctX + DragImageView.this.mTop + DragImageView.this.mBottom < DragImageView.this.getHeight()) {
                }
                if (i == DragImageView.this.getScrollX()) {
                }
                DragImageView.this.scrollTo(i, i2);
                DragImageView.this.invalidate();
                if (DragImageView.this.cuj != null) {
                }
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (DragImageView.this.cdd != null && !DragImageView.this.cul) {
                    DragImageView.this.cdd.onLongClick(DragImageView.this);
                }
                super.onLongPress(motionEvent);
            }
        });
    }

    private void aku() {
        if (this.cuA == null) {
            if (this.cfe != null) {
                this.cfe.aqT();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.cuA.getSourceImageRectInScreen();
        if (sourceImageRectInScreen == null) {
            if (this.cfe != null) {
                this.cfe.aqT();
                return;
            }
            return;
        }
        this.ceZ.bottom = (((sourceImageRectInScreen.bottom - sourceImageRectInScreen.top) / (sourceImageRectInScreen.right - sourceImageRectInScreen.left)) * (this.ceZ.right - this.ceZ.left)) + this.ceZ.top;
        final float[] fArr = {(this.ceZ.left + this.ceZ.right) / 2.0f, (this.ceZ.top + this.ceZ.bottom) / 2.0f};
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
                    DragImageView.this.ceZ = DragImageView.this.h(floatValue, animatedFraction, sourceImageRectInScreen.right - sourceImageRectInScreen.left, sourceImageRectInScreen.bottom - sourceImageRectInScreen.top);
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
                DragImageView.this.ceV = false;
                DragImageView.this.mMode = 4;
                DragImageView.this.invalidate();
                if (DragImageView.this.cfe != null) {
                    DragImageView.this.cfe.aqT();
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

    private void aqH() {
        int i = 0;
        int scrollX = getScrollX();
        if (this.ctW >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.ctW) {
                scrollX = (int) (this.ctW - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.ctX + this.mTop + this.mBottom >= getHeight()) {
            i = scrollY < (-this.cuq) ? -this.cuq : scrollY;
            if (getHeight() + i > this.ctX + this.mBottom + this.cus) {
                i = (int) ((this.ctX - getHeight()) + this.mBottom + this.cus);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
            if (this.cuj != null) {
                this.cuj.a(this, scrollX, i);
            }
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.cuz != null) {
            this.cuz.arJ();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.ctW;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.ctX;
    }

    public boolean aqI() {
        if (this.mImageType == 1 || this.mImageType == 2) {
            return true;
        }
        return !this.cum && getScrollX() >= ((int) (this.ctW - ((float) getWidth()))) + (-1);
    }

    public boolean aqJ() {
        if (this.mImageType == 1 || this.mImageType == 2) {
            return true;
        }
        return !this.cum && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.cui.aqR()) {
            this.cui.stopAnimation();
        }
        this.cuu = 0;
        super.setImageBitmap(bitmap);
        aqD();
        this.mImageType = 0;
        if (this.ceY == null) {
            int measuredWidth = getMeasuredWidth();
            float measuredWidth2 = ((1.0f * getMeasuredWidth()) / bitmap.getWidth()) * bitmap.getHeight();
            if (measuredWidth2 > getMeasuredHeight()) {
                measuredWidth2 = getMeasuredHeight();
            }
            RectF h = h(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
            this.ceY = new Rect((int) h.left, (int) h.top, (int) h.right, (int) h.bottom);
        }
        if (this.cuC == null) {
            this.cuC = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
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
            if (this.cui.aqR()) {
                this.cui.stopAnimation();
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
        if (this.cui.aqR()) {
            this.cui.stopAnimation();
        }
        super.setImageDrawable(null);
        stop();
        aqD();
        this.mImageType = 1;
        this.cup = bitmap;
        this.cud = bArr;
        if (this.cdg != null) {
            this.cdg.a(this);
        }
    }

    public void onDestroy() {
        if (this.cui.aqR()) {
            this.cui.stopAnimation();
        }
        super.setImageDrawable(null);
        this.cud = null;
        this.cup = null;
        stop();
        if (this.cuo != null) {
            this.cuo.close();
            this.cuo = null;
        }
        if (this.cuz != null) {
            this.cuz.release();
            System.gc();
        }
    }

    public void release() {
        if (this.cui.aqR()) {
            this.cui.stopAnimation();
        }
        stop();
        super.setImageDrawable(null);
        this.cup = null;
    }

    public void setDefaultBitmap() {
        if (this.cui.aqR()) {
            this.cui.stopAnimation();
        }
        try {
            if (this.cux) {
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
        aqD();
    }

    public void aqK() {
        if (this.mImageType != 1 && this.mImageType != 2) {
            int size = this.ctY.size();
            if (size > 0) {
                this.ctY.add(Float.valueOf(this.ctY.get(size - 1).floatValue() * 1.25f));
            } else {
                this.ctY.add(Float.valueOf(this.ctZ));
            }
            aqN();
        }
    }

    public void aqL() {
        if (this.mImageType != 1 && this.mImageType != 2) {
            int size = this.ctY.size();
            if (size > 1) {
                this.ctY.remove(size - 1);
            }
            aqN();
        }
    }

    public void aqM() {
        aqE();
        if (this.mImageType != 1 && this.mImageType != 2 && this.mCurrentScale != this.ctZ) {
            this.ctY.clear();
            this.ctY.add(Float.valueOf(this.ctZ));
            this.mCurrentScale = this.ctZ;
            this.cub = this.mCurrentScale;
            aqN();
        }
    }

    public boolean canZoomIn() {
        if (this.mImageType == 1 || this.mImageType == 2) {
            return false;
        }
        int size = this.ctY.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.ctY.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.cue) && floatValue <= 5.0f;
    }

    public boolean canZoomOut() {
        if (this.mImageType == 1 || this.mImageType == 2) {
            return false;
        }
        int size = this.ctY.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled()) {
            return false;
        }
        return size > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqN() {
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
                    int size = this.ctY.size();
                    if (size > 0) {
                        f3 = this.ctY.get(size - 1).floatValue();
                    } else {
                        f3 = this.ctZ;
                    }
                    this.mCurrentScale = f3;
                }
                this.mMatrix.setScale(this.mCurrentScale, this.mCurrentScale);
                this.ctW = imageBitmap.getWidth() * this.mCurrentScale;
                this.ctX = imageBitmap.getHeight() * this.mCurrentScale;
                float width = this.cub * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.cub;
                this.cuq = this.mTop;
                this.cus = 0;
                float f4 = this.ctW < ((float) this.mViewWidth) ? (int) ((this.mViewWidth - this.ctW) / 2.0f) : 0.0f;
                if (this.ctX < this.mViewHeight) {
                    f2 = (int) ((this.mViewHeight - this.ctX) / 2.0f);
                    if (this.cuf == 1 && f2 > this.mTop) {
                        f2 = this.mTop;
                    }
                    this.cuq = (int) (this.mTop - f2);
                    this.cus = this.mTop - this.cuq;
                } else {
                    f2 = 0.0f;
                }
                this.cut = (int) f4;
                this.mMatrix.postTranslate(f4, f2);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    int width2 = i > getWidth() ? getWidth() : i;
                    if (this.ctW <= screenWidth) {
                        width2 = 0;
                    } else if (this.ctW > screenWidth && this.ctW / 2.0f < screenWidth) {
                        width2 = (int) (width2 - (this.ctW / 4.0f));
                    }
                    scrollX = width2;
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.ctW - width) / 2.0f);
                    }
                    if (this.ctW <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.ctW) {
                        scrollX = (int) (this.ctW - getWidth());
                    }
                }
                if (scrollX > 0 && this.ctW - scrollX < getWidth()) {
                    scrollX = (int) (this.ctW - getWidth());
                }
                int i3 = this.mMode == 2 ? ((int) ((this.ctX - height) / 2.0f)) + scrollY : scrollY;
                if (this.ctX <= getHeight()) {
                    i3 = 0;
                } else if (getHeight() + i3 > this.ctX) {
                    i3 = (int) (this.ctX - getHeight());
                }
                setHorizontalScrollBarEnabled(false);
                setVerticalScrollBarEnabled(false);
                if (scrollX < 0) {
                    scrollX = 0;
                }
                scrollTo(scrollX, i3 >= 0 ? i3 : 0);
                setImageMatrix(this.mMatrix);
                aqE();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Animation {
        private boolean cuO = false;
        private boolean cuP = false;
        private long cuQ;
        private long cuR;
        private long cuS;
        private long cuT;
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
            this.cuQ = f;
            this.cuR = f2;
            this.cuS = Math.abs((f * 1000.0f) / 2500.0f);
            this.cuT = Math.abs((f2 * 1000.0f) / 2500.0f);
            setDuration(Math.max(this.cuS, this.cuT));
            setInterpolator(DragImageView.this.cuB);
            this.mStartX = DragImageView.this.getScrollX();
            this.mStartY = DragImageView.this.getScrollY();
            this.cuO = true;
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
            if (this.cuS > this.cuT) {
                j = ((float) this.cuS) * f;
            } else {
                j = ((float) this.cuT) * f;
            }
            float f2 = ((float) (j > this.cuS ? this.cuS : j)) / 1000.0f;
            if (this.cuQ > 0) {
                i = this.mStartX - ((int) (f2 * (((float) this.cuQ) - ((2500.0f * f2) / 2.0f))));
            } else {
                i = this.mStartX - ((int) (f2 * (((float) this.cuQ) + ((2500.0f * f2) / 2.0f))));
            }
            if (j > this.cuT) {
                j = this.cuT;
            }
            float f3 = ((float) j) / 1000.0f;
            if (this.cuR > 0) {
                i2 = this.mStartY - ((int) (f3 * (((float) this.cuR) - ((2500.0f * f3) / 2.0f))));
            } else {
                i2 = this.mStartY - ((int) (f3 * (((float) this.cuR) + ((2500.0f * f3) / 2.0f))));
            }
            if (DragImageView.this.ctX + DragImageView.this.mTop + DragImageView.this.mBottom > DragImageView.this.getHeight()) {
                if (i2 < (-DragImageView.this.cuq)) {
                    i2 = -DragImageView.this.cuq;
                }
                if (DragImageView.this.getHeight() + i2 > DragImageView.this.ctX + DragImageView.this.mBottom + DragImageView.this.cus) {
                    i2 = (int) ((DragImageView.this.ctX - DragImageView.this.getHeight()) + DragImageView.this.mBottom + DragImageView.this.cus);
                }
            } else {
                i2 = 0;
            }
            if (DragImageView.this.ctW > DragImageView.this.getWidth()) {
                int width = ((float) (DragImageView.this.getWidth() + i)) > DragImageView.this.ctW ? (int) (DragImageView.this.ctW - DragImageView.this.getWidth()) : i;
                if (width >= 0) {
                    i3 = width;
                }
            }
            DragImageView.this.scrollTo(i3, i2);
            DragImageView.this.invalidate();
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            if (!this.cuP) {
                if (DragImageView.this.cuc) {
                    this.cuO = false;
                    return false;
                }
                try {
                    if (super.getTransformation(j, transformation)) {
                        return true;
                    }
                    this.cuO = false;
                    return false;
                } catch (Exception e) {
                    this.cuO = false;
                    return false;
                }
            }
            this.cuP = false;
            this.cuO = false;
            return false;
        }

        public boolean aqR() {
            return this.cuO;
        }

        public void stopAnimation() {
            this.cuP = true;
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.cuh = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cdd = onLongClickListener;
        if (this.cuz != null) {
            this.cuz.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setGifSetListener(e eVar) {
        this.cdg = eVar;
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
    public void aqO() {
        long j;
        c poll = this.cuF.poll();
        if (poll == null) {
            this.cuK = true;
            return;
        }
        this.cuK = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.cuE != null) {
            j = this.cuE.delay - (currentTimeMillis - this.cuJ);
            this.cuG.offer(this.cuE);
        } else {
            j = 0;
        }
        this.cuE = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public c aqP() {
        c poll = this.cuG.poll();
        if (poll == null) {
            poll = new c();
            try {
                poll.cuU = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
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
        return this.cuE;
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
            while (this.Es && DragImageView.this.cuo != null && DragImageView.this.cuD > 0 && DragImageView.this.width > 0 && DragImageView.this.height > 0) {
                try {
                    DragImageView.this.cuo.V(DragImageView.this.cuH);
                    c aqP = DragImageView.this.aqP();
                    if (aqP.cuU == null || (aqP.cuU.getWidth() != DragImageView.this.width && aqP.cuU.getHeight() != DragImageView.this.height)) {
                        try {
                            aqP.cuU = Bitmap.createBitmap(DragImageView.this.width, DragImageView.this.height, Bitmap.Config.ARGB_8888);
                        } catch (OutOfMemoryError e) {
                            TbadkCoreApplication.getInst().onAppMemoryLow();
                            try {
                                aqP.cuU = Bitmap.createBitmap(DragImageView.this.width, DragImageView.this.height, Bitmap.Config.ARGB_4444);
                            } catch (OutOfMemoryError e2) {
                                TbadkCoreApplication.getInst().onAppMemoryLow();
                            } catch (Throwable th) {
                                BdLog.e(th.getMessage());
                            }
                        } catch (Throwable th2) {
                            BdLog.e(th2.getMessage());
                        }
                    }
                    DragImageView.this.cuo.a(aqP.cuU, null);
                    aqP.delay = DragImageView.this.cuo.W(DragImageView.this.cuH);
                    DragImageView.C(DragImageView.this);
                    if (aqP.cuU == null) {
                        DragImageView.C(DragImageView.this);
                    }
                    DragImageView.this.cuH %= DragImageView.this.cuD;
                    DragImageView.this.cuF.put(aqP);
                    if (DragImageView.this.cuK) {
                        DragImageView.this.mHandler.sendEmptyMessage(1);
                    }
                } catch (Exception e3) {
                    return;
                }
            }
        }
    }

    public boolean aqQ() {
        return this.cuv;
    }

    public void setLoadBigImage(boolean z) {
        this.cuv = z;
    }

    public int getBottomOffset() {
        return this.cus;
    }

    public int getLeftOffset() {
        return this.cut;
    }
}
