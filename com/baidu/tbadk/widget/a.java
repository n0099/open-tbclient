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
import android.util.FloatMath;
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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends ImageView {
    private static final String TAG = a.class.getSimpleName();
    private static final int ayw = l.ae(TbadkCoreApplication.getInst()) / 5;
    private float aNA;
    private boolean aNB;
    private byte[] aNC;
    private int aND;
    private int aNE;
    private f aNF;
    private View.OnClickListener aNG;
    private C0065a aNH;
    private float aNI;
    private boolean aNJ;
    private boolean aNK;
    private int aNL;
    private volatile com.baidu.adp.gif.b aNM;
    private Bitmap aNN;
    private int aNO;
    private int aNP;
    private int aNQ;
    private int aNR;
    private boolean aNS;
    private boolean aNT;
    private float aNU;
    private com.baidu.tbadk.widget.a.b.b aNV;
    private ImageUrlData aNW;
    private Interpolator aNX;
    private Rect aNY;
    private int aNZ;
    private float aNv;
    private float aNw;
    private ArrayList<Float> aNx;
    private float aNy;
    private float aNz;
    private c aOa;
    private BlockingLinkedDeque<c> aOb;
    private BlockingLinkedDeque<c> aOc;
    private volatile int aOd;
    private b aOe;
    private volatile long aOf;
    private volatile boolean aOg;
    public int aiv;
    private View.OnLongClickListener avA;
    private e avD;
    private int avE;
    private boolean ayo;
    private float ayp;
    private Matrix ayq;
    private Rect ayr;
    private RectF ays;
    private d ayv;
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
    private int mViewHeight;
    private int mViewWidth;
    private int width;

    /* loaded from: classes.dex */
    public static class c {
        public Bitmap aOp;
        public int delay;
    }

    /* loaded from: classes.dex */
    public interface d {
        void HT();

        void HU();
    }

    /* loaded from: classes.dex */
    public interface e {
        void a(a aVar);
    }

    /* loaded from: classes.dex */
    public interface f {
        void a(a aVar, boolean z, boolean z2);
    }

    static /* synthetic */ int A(a aVar) {
        int i = aVar.aOd;
        aVar.aOd = i + 1;
        return i;
    }

    public void setIsHeadImage(boolean z) {
        this.aNT = z;
    }

    public void setImageUrlData(ImageUrlData imageUrlData) {
        this.aNW = imageUrlData;
    }

    public a(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aNB = false;
        this.aNC = null;
        this.avE = 0;
        this.aND = 1300;
        this.aNE = 0;
        this.aNF = null;
        this.aNG = null;
        this.avA = null;
        this.avD = null;
        this.aNI = 1.0f;
        this.aiv = 0;
        this.mMode = 0;
        this.aNJ = false;
        this.aNK = false;
        this.aNL = 0;
        this.aNM = null;
        this.aNN = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aNO = 0;
        this.aNP = 0;
        this.aNQ = 0;
        this.aNR = 0;
        this.aNX = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.ayq = new Matrix();
        this.ayo = false;
        this.mRatio = 1.0f;
        this.ayp = 0.0f;
        this.ays = new RectF();
        this.width = 0;
        this.height = 0;
        this.aNZ = 0;
        this.aOa = null;
        this.aOb = new BlockingLinkedDeque<>(5);
        this.aOc = new BlockingLinkedDeque<>(6);
        this.aOd = 0;
        this.aOf = 0L;
        this.aOg = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.a.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        a.this.HP();
                        break;
                    case 1:
                        if (a.this.aOg) {
                            a.this.HP();
                            break;
                        }
                        break;
                    case 2:
                        a.this.invalidate();
                        a.this.aOf = System.currentTimeMillis();
                        a.this.mHandler.sendEmptyMessage(0);
                        break;
                }
                return false;
            }
        });
        initData();
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aNB = false;
        this.aNC = null;
        this.avE = 0;
        this.aND = 1300;
        this.aNE = 0;
        this.aNF = null;
        this.aNG = null;
        this.avA = null;
        this.avD = null;
        this.aNI = 1.0f;
        this.aiv = 0;
        this.mMode = 0;
        this.aNJ = false;
        this.aNK = false;
        this.aNL = 0;
        this.aNM = null;
        this.aNN = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aNO = 0;
        this.aNP = 0;
        this.aNQ = 0;
        this.aNR = 0;
        this.aNX = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.ayq = new Matrix();
        this.ayo = false;
        this.mRatio = 1.0f;
        this.ayp = 0.0f;
        this.ays = new RectF();
        this.width = 0;
        this.height = 0;
        this.aNZ = 0;
        this.aOa = null;
        this.aOb = new BlockingLinkedDeque<>(5);
        this.aOc = new BlockingLinkedDeque<>(6);
        this.aOd = 0;
        this.aOf = 0L;
        this.aOg = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.a.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        a.this.HP();
                        break;
                    case 1:
                        if (a.this.aOg) {
                            a.this.HP();
                            break;
                        }
                        break;
                    case 2:
                        a.this.invalidate();
                        a.this.aOf = System.currentTimeMillis();
                        a.this.mHandler.sendEmptyMessage(0);
                        break;
                }
                return false;
            }
        });
        initData();
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aNB = false;
        this.aNC = null;
        this.avE = 0;
        this.aND = 1300;
        this.aNE = 0;
        this.aNF = null;
        this.aNG = null;
        this.avA = null;
        this.avD = null;
        this.aNI = 1.0f;
        this.aiv = 0;
        this.mMode = 0;
        this.aNJ = false;
        this.aNK = false;
        this.aNL = 0;
        this.aNM = null;
        this.aNN = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aNO = 0;
        this.aNP = 0;
        this.aNQ = 0;
        this.aNR = 0;
        this.aNX = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.ayq = new Matrix();
        this.ayo = false;
        this.mRatio = 1.0f;
        this.ayp = 0.0f;
        this.ays = new RectF();
        this.width = 0;
        this.height = 0;
        this.aNZ = 0;
        this.aOa = null;
        this.aOb = new BlockingLinkedDeque<>(5);
        this.aOc = new BlockingLinkedDeque<>(6);
        this.aOd = 0;
        this.aOf = 0L;
        this.aOg = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.a.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        a.this.HP();
                        break;
                    case 1:
                        if (a.this.aOg) {
                            a.this.HP();
                            break;
                        }
                        break;
                    case 2:
                        a.this.invalidate();
                        a.this.aOf = System.currentTimeMillis();
                        a.this.mHandler.sendEmptyMessage(0);
                        break;
                }
                return false;
            }
        });
        initData();
    }

    public void setDragToExitListener(d dVar) {
        this.ayv = dVar;
    }

    public int getImageType() {
        return this.aiv;
    }

    public void setImageMode(int i) {
        this.aNE = i;
    }

    public void i(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.avE = i;
    }

    public boolean HA() {
        if (this.aNV != null) {
            return this.aNV.HA();
        }
        return false;
    }

    public void HB() {
        this.aNK = false;
        this.aNB = false;
        this.mMode = 3;
        HH();
        if (this.mCurrentScale < this.aNy) {
            this.mCurrentScale = this.aNy;
            HO();
        }
        invalidate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.aNV != null && this.aNV.onTouchEvent(motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.aNB = true;
                this.aNJ = false;
                this.aNK = false;
                break;
            case 1:
                HB();
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
            this.aNI = m(motionEvent);
            if (this.aNI > 10.0f) {
                this.mMode = 2;
            }
        }
        if (this.mMode == 2 || !this.mGestureDetector.onTouchEvent(motionEvent)) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.aNJ = true;
                        this.aNK = true;
                        if (this.aiv != 1 && this.aiv != 2) {
                            float m = m(motionEvent);
                            if (m >= 0.0f && Math.abs(this.aNI - m) >= 10.0f) {
                                if (Math.abs(this.aNI - m) > 100.0f) {
                                    this.aNI = m;
                                    break;
                                } else {
                                    float f2 = m / this.aNI;
                                    this.aNI = m;
                                    this.aNA = this.mCurrentScale;
                                    this.mCurrentScale *= f2;
                                    if (this.mCurrentScale > this.aNz) {
                                        this.mCurrentScale = this.aNz;
                                    }
                                    float minScaleValue = getMinScaleValue();
                                    if (this.mCurrentScale < minScaleValue) {
                                        this.mCurrentScale = minScaleValue;
                                    }
                                    HO();
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
        return this.aNV != null ? this.aNV.getMinScaleValue() : this.aNy / 4.0f;
    }

    public float m(MotionEvent motionEvent) {
        return CompatibleUtile.getInstance().getSpacing(motionEvent);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            this.mViewWidth = i3 - i;
            this.mViewHeight = i4 - i2;
            HD();
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public boolean HC() {
        if (this.aNV != null) {
            return this.aNV.IE();
        }
        return this.aNy == this.mCurrentScale;
    }

    protected float f(Bitmap bitmap) {
        if (this.aNV != null) {
            return this.aNV.II();
        }
        if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            return 1.0f;
        }
        if (this.aNE == 0) {
            float width = this.mViewWidth / bitmap.getWidth();
            float height = this.mViewHeight / bitmap.getHeight();
            if (this.aNT) {
                if (this.aiv == 2) {
                    return 2.5f;
                }
                return Math.min(width, height);
            } else if (this.aiv != 2) {
                float f2 = this.aNU;
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

    protected float g(Bitmap bitmap) {
        if (this.aNV != null) {
            return this.aNV.IJ();
        }
        float f2 = 1.0f;
        if (bitmap != null && !bitmap.isRecycled() && bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
            f2 = FloatMath.sqrt(this.aND / (bitmap.getWidth() * bitmap.getHeight()));
            if (f2 > 10.0f) {
                return 10.0f;
            }
        }
        return f2;
    }

    private void HD() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            this.aNy = f(imageBitmap);
            this.aNz = g(imageBitmap);
            this.aNx.clear();
            this.aNx.add(Float.valueOf(this.aNy));
            this.mCurrentScale = this.aNy;
            this.aNA = this.mCurrentScale;
            HO();
            return;
        }
        this.aNv = 0.0f;
        this.aNw = 0.0f;
        this.aNy = 1.0f;
        this.aNz = 1.0f;
        this.mCurrentScale = 1.0f;
        this.aNA = this.mCurrentScale;
        this.aNx.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    private void HE() {
        if (this.aNF != null) {
            this.aNF.a(this, canZoomIn(), canZoomOut());
        }
    }

    public void setOnSizeChangedListener(f fVar) {
        this.aNF = fVar;
    }

    public byte[] getImageData() {
        return this.aNC;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getMeasuredHeight() != 0 && getMeasuredWidth() != 0 && this.aNV != null) {
            this.aNV.IG();
        }
    }

    public void a(Bitmap bitmap, byte[] bArr) {
        this.aNC = bArr;
        if (this.aNV != null) {
            this.aNV.b(bitmap, bArr);
        }
        setImageBitmap(bitmap);
    }

    public void HF() {
        if (this.aNV == null) {
            this.aNV = new com.baidu.tbadk.widget.a.b.b(this);
            this.aNV.setOnClickListener(this.aNG);
            this.aNV.setOnLongClickListener(this.avA);
        }
    }

    public void setImageLoadCallBack(com.baidu.tbadk.widget.a.b.a aVar) {
        if (this.aNV != null) {
            this.aNV.a(aVar);
        }
    }

    public boolean HG() {
        return (getImageBitmap() == null || this.aNV == null) ? false : true;
    }

    public Bitmap getGifCache() {
        return this.aNN;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        boolean z;
        if (this.aNV == null || !this.aNV.b(canvas, getImageBitmap())) {
            if (this.aiv == 2 && this.aNR != 0 && !this.aNH.HS()) {
                int width = getWidth();
                int height = getHeight();
                Drawable drawable = getDrawable();
                float f2 = 0.0f;
                float f3 = height * 0.3f;
                float f4 = width;
                float f5 = (1.0f - 0.3f) * height;
                if (this.aNT && drawable != null) {
                    Rect bounds = drawable.getBounds();
                    int i = bounds.right - bounds.left;
                    int i2 = bounds.bottom - bounds.top;
                    f2 = (width / 2) - (i * 2.5f);
                    f3 = (height / 2) - (i2 * 2.5f);
                    f4 = (i * 2.5f) + (width / 2);
                    f5 = (i2 * 2.5f) + (height / 2);
                }
                this.mPaint.setColor(aj.getColor(this.aNR));
                canvas.drawRect(f2, f3, f4, f5, this.mPaint);
                this.mPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
            }
            if (this.mMode == 3 && this.ayo) {
                this.ayo = false;
                this.ayq.reset();
                if (this.ayp < ayw) {
                    this.mMode = 0;
                } else {
                    this.mMode = 4;
                    By();
                }
            }
            if (this.aiv == 0 && this.ayo && this.ayr != null && this.aNW != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                if (this.ays == null) {
                    this.ays = new RectF();
                }
                this.ayq.mapRect(this.ays, new RectF(this.ayr));
                Bitmap imageBitmap = getImageBitmap();
                if (imageBitmap != null && !imageBitmap.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.aNY, this.ays, (Paint) null);
                }
            } else if (this.mMode == 4 && this.ayr != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                Bitmap imageBitmap2 = getImageBitmap();
                if (imageBitmap2 != null && !imageBitmap2.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.aNY, this.ays, (Paint) null);
                }
            } else {
                super.onDraw(canvas);
            }
            if (this.aiv == 1 && this.aNN != null && !this.aNN.isRecycled()) {
                int width2 = this.aNN.getWidth();
                int height2 = this.aNN.getHeight();
                int width3 = getWidth();
                int height3 = getHeight();
                int i3 = (width3 - width2) >> 1;
                int i4 = (height3 - height2) >> 1;
                float f6 = this.aNU;
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
                if (this.aNL == 1 && this.aNM != null && this.aOa != null && this.aOa.aOp != null) {
                    if (z) {
                        canvas.drawBitmap(this.aOa.aOp, i3, i4, (Paint) null);
                    } else {
                        canvas.drawBitmap(this.aOa.aOp, this.mMatrix, this.mPaint);
                    }
                    invalidate();
                } else if (z) {
                    canvas.drawBitmap(this.aNN, i3, i4, (Paint) null);
                } else {
                    canvas.drawBitmap(this.aNN, this.mMatrix, this.mPaint);
                }
            }
        }
    }

    public void play() {
        com.baidu.adp.widget.a.a aVar;
        if (this.aiv == 1) {
            if (this.aNM == null) {
                if (this.aOe != null) {
                    this.aOe.wB = false;
                    this.aOe.interrupt();
                    this.aOe = null;
                }
                if (this.aNC != null) {
                    try {
                        aVar = a.C0002a.dD().g(this.aNC, 0, this.aNC.length);
                    } catch (StackOverflowError e2) {
                        aVar = null;
                    }
                    if (aVar != null && aVar.getGif() != null) {
                        this.aNM = aVar.getGif();
                        if (this.aNM != null) {
                            this.aNL = 1;
                            this.width = this.aNM.getWidth();
                            this.height = this.aNM.getHeight();
                            this.aOd = 0;
                            this.aNZ = this.aNM.getFrameCount();
                        } else {
                            this.aNL = 0;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            if (this.aNM != null) {
                if (this.aOe == null || (this.aOe != null && !this.aOe.wB)) {
                    this.aOg = true;
                    this.aOe = new b();
                    this.aOb.clear();
                    this.aOc.clear();
                    this.aOe.wB = true;
                    this.aOe.start();
                }
            }
        }
    }

    public void pause() {
        if (this.aiv == 1) {
            if (this.aOe != null) {
                this.aOe.wB = false;
                this.aOe.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.aiv == 1) {
            if (this.aOe != null) {
                this.aOe.wB = false;
                this.aOe.interrupt();
                this.aOe = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.aOg = true;
            this.aOa = null;
            this.aOc.clear();
            this.aOb.clear();
            this.width = 0;
            this.height = 0;
            this.aOd = 0;
            this.aNZ = 0;
            this.aNM = null;
        }
    }

    private void initData() {
        this.aNU = l.af(getContext());
        this.aND = l.ae(getContext()) * l.ac(getContext()) * 2;
        if (this.aND < 1690000) {
            this.aND = 1690000;
        }
        this.aNv = 0.0f;
        this.aNw = 0.0f;
        this.aNx = new ArrayList<>();
        this.aNy = 1.0f;
        this.aNz = 1.0f;
        this.mCurrentScale = 1.0f;
        this.aNA = this.mCurrentScale;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.aNH = new C0065a();
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWillNotDraw(false);
        scrollTo(0, 0);
        this.mGestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.a.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                if (a.this.aiv != 2 && (Math.abs(f2) > 200.0f || Math.abs(f3) > 200.0f)) {
                    a.this.aNH.e(f2, f3);
                    a.this.startAnimation(a.this.aNH);
                }
                return super.onFling(motionEvent, motionEvent2, f2, f3);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (a.this.aiv != 1 && a.this.aiv != 2) {
                    a.this.mMode = 2;
                    if (a.this.mCurrentScale > a.this.aNy) {
                        a.this.mCurrentScale = a.this.aNy;
                        a.this.aNA = a.this.mCurrentScale;
                        a.this.HO();
                        return true;
                    }
                    a.this.mCurrentScale = a.this.aNy * 2.0f;
                    a.this.d(true, (int) motionEvent.getX(), (int) motionEvent.getY());
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (a.this.aNG != null && !a.this.aNJ) {
                    a.this.aNG.onClick(a.this);
                }
                return super.onSingleTapConfirmed(motionEvent);
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x0084  */
            /* JADX WARN: Removed duplicated region for block: B:31:0x00fd  */
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                int i;
                int i2;
                a.this.aNJ = true;
                if (a.this.aNE == 0 && a.this.aNK) {
                    return false;
                }
                int scrollX = a.this.getScrollX();
                int scrollY = a.this.getScrollY();
                if (a.this.aNv >= a.this.getWidth()) {
                    scrollX = (int) (scrollX + f2);
                    if (a.this.aNE == 0) {
                        i = scrollX >= 0 ? scrollX : 0;
                        if (a.this.getWidth() + i > a.this.aNv) {
                            i = (int) (a.this.aNv - a.this.getWidth());
                        }
                        if (a.this.aNw + a.this.mTop + a.this.mBottom < a.this.getHeight()) {
                            i2 = (int) (scrollY + f3);
                            if (a.this.aNE == 0) {
                                if (i2 < (-a.this.aNO)) {
                                    i2 = -a.this.aNO;
                                }
                                if (a.this.getHeight() + i2 > a.this.aNw + a.this.mBottom + a.this.aNP) {
                                    i2 = (int) ((a.this.aNw - a.this.getHeight()) + a.this.mBottom + a.this.aNP);
                                }
                            }
                        } else {
                            i2 = scrollY;
                        }
                        if (i == a.this.getScrollX() || i2 != a.this.getScrollY()) {
                            a.this.scrollTo(i, i2);
                            a.this.invalidate();
                        }
                        return true;
                    }
                }
                i = scrollX;
                if (a.this.aNw + a.this.mTop + a.this.mBottom < a.this.getHeight()) {
                }
                if (i == a.this.getScrollX()) {
                }
                a.this.scrollTo(i, i2);
                a.this.invalidate();
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (a.this.avA != null && !a.this.aNJ) {
                    a.this.avA.onLongClick(a.this);
                }
                super.onLongPress(motionEvent);
            }
        });
    }

    private void By() {
        if (this.aNW == null) {
            if (this.ayv != null) {
                this.ayv.HU();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.aNW.getSourceImageRectInScreen();
        if (sourceImageRectInScreen == null) {
            if (this.ayv != null) {
                this.ayv.HU();
                return;
            }
            return;
        }
        this.ays.bottom = (((sourceImageRectInScreen.bottom - sourceImageRectInScreen.top) / (sourceImageRectInScreen.right - sourceImageRectInScreen.left)) * (this.ays.right - this.ays.left)) + this.ays.top;
        final float[] fArr = {(this.ays.left + this.ays.right) / 2.0f, (this.ays.top + this.ays.bottom) / 2.0f};
        final float[] fArr2 = {(sourceImageRectInScreen.left + sourceImageRectInScreen.right) / 2, (sourceImageRectInScreen.top + sourceImageRectInScreen.bottom) / 2};
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr[0], fArr2[0]);
        ofFloat.setDuration(150L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.a.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && sourceImageRectInScreen != null) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    float animatedFraction = fArr[1] + ((fArr2[1] - fArr[1]) * valueAnimator.getAnimatedFraction());
                    a.this.ays = a.this.e(floatValue, animatedFraction, sourceImageRectInScreen.right - sourceImageRectInScreen.left, sourceImageRectInScreen.bottom - sourceImageRectInScreen.top);
                    a.this.invalidate();
                }
            }
        });
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tbadk.widget.a.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.ayo = false;
                a.this.mMode = 4;
                a.this.invalidate();
                if (a.this.ayv != null) {
                    a.this.ayv.HU();
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
    public RectF e(float f2, float f3, float f4, float f5) {
        return new RectF(f2 - (f4 / 2.0f), f3 - (f5 / 2.0f), (f4 / 2.0f) + f2, (f5 / 2.0f) + f3);
    }

    private void HH() {
        int i = 0;
        int scrollX = getScrollX();
        if (this.aNv >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.aNv) {
                scrollX = (int) (this.aNv - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.aNw + this.mTop + this.mBottom >= getHeight()) {
            i = scrollY < (-this.aNO) ? -this.aNO : scrollY;
            if (getHeight() + i > this.aNw + this.mBottom + this.aNP) {
                i = (int) ((this.aNw - getHeight()) + this.mBottom + this.aNP);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.aNV != null) {
            this.aNV.IF();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.aNv;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.aNw;
    }

    public boolean HI() {
        if (this.aiv == 1 || this.aiv == 2) {
            return true;
        }
        return !this.aNK && getScrollX() >= ((int) (this.aNv - ((float) getWidth()))) + (-1);
    }

    public boolean HJ() {
        if (this.aiv == 1 || this.aiv == 2) {
            return true;
        }
        return !this.aNK && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.aNH.HS()) {
            this.aNH.stopAnimation();
        }
        this.aNR = 0;
        super.setImageBitmap(bitmap);
        HD();
        this.aiv = 0;
        if (this.ayr == null) {
            int measuredWidth = getMeasuredWidth();
            float measuredWidth2 = ((1.0f * getMeasuredWidth()) / bitmap.getWidth()) * bitmap.getHeight();
            if (measuredWidth2 > getMeasuredHeight()) {
                measuredWidth2 = getMeasuredHeight();
            }
            RectF e2 = e(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
            this.ayr = new Rect((int) e2.left, (int) e2.top, (int) e2.right, (int) e2.bottom);
        }
        if (this.aNY == null) {
            this.aNY = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        }
    }

    public void h(Bitmap bitmap) {
        Bitmap imageBitmap = getImageBitmap();
        if (bitmap != null && !bitmap.isRecycled()) {
            if (imageBitmap != null && (imageBitmap.getWidth() != bitmap.getWidth() || imageBitmap.getHeight() != bitmap.getHeight())) {
                setImageBitmap(bitmap);
                super.setImageMatrix(this.mMatrix);
                return;
            }
            if (this.aNH.HS()) {
                this.aNH.stopAnimation();
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            super.setImageBitmap(bitmap);
            super.setImageMatrix(this.mMatrix);
            scrollTo(scrollX, scrollY);
            this.aiv = 0;
        }
    }

    public void a(byte[] bArr, Bitmap bitmap) {
        if (this.aNH.HS()) {
            this.aNH.stopAnimation();
        }
        super.setImageDrawable(null);
        stop();
        HD();
        this.aiv = 1;
        this.aNN = bitmap;
        this.aNC = bArr;
        if (this.avD != null) {
            this.avD.a(this);
        }
    }

    public void onDestroy() {
        if (this.aNH.HS()) {
            this.aNH.stopAnimation();
        }
        super.setImageDrawable(null);
        this.aNC = null;
        this.aNN = null;
        stop();
        if (this.aNM != null) {
            this.aNM.close();
            this.aNM = null;
        }
        if (this.aNV != null) {
            this.aNV.release();
            System.gc();
        }
    }

    public void release() {
        if (this.aNH.HS()) {
            this.aNH.stopAnimation();
        }
        stop();
        super.setImageDrawable(null);
        this.aNN = null;
    }

    public void HK() {
        if (this.aNH.HS()) {
            this.aNH.stopAnimation();
        }
        try {
            if (this.aNT) {
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
        this.aiv = 2;
        HD();
    }

    public void HL() {
        if (this.aiv != 1 && this.aiv != 2) {
            int size = this.aNx.size();
            if (size > 0) {
                this.aNx.add(Float.valueOf(this.aNx.get(size - 1).floatValue() * 1.25f));
            } else {
                this.aNx.add(Float.valueOf(this.aNy));
            }
            HO();
        }
    }

    public void HM() {
        if (this.aiv != 1 && this.aiv != 2) {
            int size = this.aNx.size();
            if (size > 1) {
                this.aNx.remove(size - 1);
            }
            HO();
        }
    }

    public void HN() {
        HE();
        if (this.aiv != 1 && this.aiv != 2 && this.mCurrentScale != this.aNy) {
            this.aNx.clear();
            this.aNx.add(Float.valueOf(this.aNy));
            this.mCurrentScale = this.aNy;
            this.aNA = this.mCurrentScale;
            HO();
        }
    }

    public boolean canZoomIn() {
        if (this.aiv == 1 || this.aiv == 2) {
            return false;
        }
        int size = this.aNx.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.aNx.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.aND) && floatValue <= 5.0f;
    }

    public boolean canZoomOut() {
        if (this.aiv == 1 || this.aiv == 2) {
            return false;
        }
        int size = this.aNx.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled()) {
            return false;
        }
        return size > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HO() {
        d(false, -1, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z, int i, int i2) {
        float f2;
        float f3;
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled()) {
            try {
                if (this.mMode != 2) {
                    int size = this.aNx.size();
                    if (size > 0) {
                        f3 = this.aNx.get(size - 1).floatValue();
                    } else {
                        f3 = this.aNy;
                    }
                    this.mCurrentScale = f3;
                }
                this.mMatrix.setScale(this.mCurrentScale, this.mCurrentScale);
                this.aNv = imageBitmap.getWidth() * this.mCurrentScale;
                this.aNw = imageBitmap.getHeight() * this.mCurrentScale;
                float width = this.aNA * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.aNA;
                this.aNO = this.mTop;
                this.aNP = 0;
                float f4 = this.aNv < ((float) this.mViewWidth) ? (int) ((this.mViewWidth - this.aNv) / 2.0f) : 0.0f;
                if (this.aNw < this.mViewHeight) {
                    f2 = (int) ((this.mViewHeight - this.aNw) / 2.0f);
                    if (this.aNE == 1 && f2 > this.mTop) {
                        f2 = this.mTop;
                    }
                    this.aNO = (int) (this.mTop - f2);
                    this.aNP = this.mTop - this.aNO;
                } else {
                    f2 = 0.0f;
                }
                this.aNQ = (int) f4;
                this.mMatrix.postTranslate(f4, f2);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    int width2 = i > getWidth() ? getWidth() : i;
                    if (this.aNv <= screenWidth) {
                        width2 = 0;
                    } else if (this.aNv > screenWidth && this.aNv / 2.0f < screenWidth) {
                        width2 = (int) (width2 - (this.aNv / 4.0f));
                    }
                    scrollX = width2;
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.aNv - width) / 2.0f);
                    }
                    if (this.aNv <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.aNv) {
                        scrollX = (int) (this.aNv - getWidth());
                    }
                }
                if (scrollX > 0 && this.aNv - scrollX < getWidth()) {
                    scrollX = (int) (this.aNv - getWidth());
                }
                int i3 = this.mMode == 2 ? ((int) ((this.aNw - height) / 2.0f)) + scrollY : scrollY;
                if (this.aNw <= getHeight()) {
                    i3 = 0;
                } else if (getHeight() + i3 > this.aNw) {
                    i3 = (int) (this.aNw - getHeight());
                }
                setHorizontalScrollBarEnabled(false);
                setVerticalScrollBarEnabled(false);
                if (scrollX < 0) {
                    scrollX = 0;
                }
                scrollTo(scrollX, i3 >= 0 ? i3 : 0);
                setImageMatrix(this.mMatrix);
                HE();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0065a extends Animation {
        private boolean aOi = false;
        private boolean aOj = false;
        private long aOk;
        private long aOl;
        private int aOm;
        private long aOn;
        private long aOo;
        private int mStartY;

        public C0065a() {
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
            this.aOk = f;
            this.aOl = f2;
            this.aOn = Math.abs((f * 1000.0f) / 2500.0f);
            this.aOo = Math.abs((f2 * 1000.0f) / 2500.0f);
            setDuration(Math.max(this.aOn, this.aOo));
            setInterpolator(a.this.aNX);
            this.aOm = a.this.getScrollX();
            this.mStartY = a.this.getScrollY();
            this.aOi = true;
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
            if (this.aOn > this.aOo) {
                j = ((float) this.aOn) * f;
            } else {
                j = ((float) this.aOo) * f;
            }
            float f2 = ((float) (j > this.aOn ? this.aOn : j)) / 1000.0f;
            if (this.aOk > 0) {
                i = this.aOm - ((int) (f2 * (((float) this.aOk) - ((2500.0f * f2) / 2.0f))));
            } else {
                i = this.aOm - ((int) (f2 * (((float) this.aOk) + ((2500.0f * f2) / 2.0f))));
            }
            if (j > this.aOo) {
                j = this.aOo;
            }
            float f3 = ((float) j) / 1000.0f;
            if (this.aOl > 0) {
                i2 = this.mStartY - ((int) (f3 * (((float) this.aOl) - ((2500.0f * f3) / 2.0f))));
            } else {
                i2 = this.mStartY - ((int) (f3 * (((float) this.aOl) + ((2500.0f * f3) / 2.0f))));
            }
            if (a.this.aNw + a.this.mTop + a.this.mBottom > a.this.getHeight()) {
                if (i2 < (-a.this.aNO)) {
                    i2 = -a.this.aNO;
                }
                if (a.this.getHeight() + i2 > a.this.aNw + a.this.mBottom + a.this.aNP) {
                    i2 = (int) ((a.this.aNw - a.this.getHeight()) + a.this.mBottom + a.this.aNP);
                }
            } else {
                i2 = 0;
            }
            if (a.this.aNv > a.this.getWidth()) {
                int width = ((float) (a.this.getWidth() + i)) > a.this.aNv ? (int) (a.this.aNv - a.this.getWidth()) : i;
                if (width >= 0) {
                    i3 = width;
                }
            }
            a.this.scrollTo(i3, i2);
            a.this.invalidate();
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            if (!this.aOj) {
                if (a.this.aNB) {
                    this.aOi = false;
                    return false;
                }
                try {
                    if (super.getTransformation(j, transformation)) {
                        return true;
                    }
                    this.aOi = false;
                    return false;
                } catch (Exception e) {
                    this.aOi = false;
                    return false;
                }
            }
            this.aOj = false;
            this.aOi = false;
            return false;
        }

        public boolean HS() {
            return this.aOi;
        }

        public void stopAnimation() {
            this.aOj = true;
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.aNG = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.avA = onLongClickListener;
        if (this.aNV != null) {
            this.aNV.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setGifSetListener(e eVar) {
        this.avD = eVar;
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
    public void HP() {
        long j;
        c poll = this.aOb.poll();
        if (poll == null) {
            this.aOg = true;
            return;
        }
        this.aOg = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.aOa != null) {
            j = this.aOa.delay - (currentTimeMillis - this.aOf);
            this.aOc.offer(this.aOa);
        } else {
            j = 0;
        }
        this.aOa = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public c HQ() {
        c poll = this.aOc.poll();
        if (poll == null) {
            poll = new c();
            try {
                poll.aOp = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
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
        return this.aOa;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends Thread {
        private volatile boolean wB;

        private b() {
            this.wB = false;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (this.wB && a.this.aNM != null && a.this.aNZ > 0 && a.this.width > 0 && a.this.height > 0) {
                try {
                    a.this.aNM.T(a.this.aOd);
                    c HQ = a.this.HQ();
                    if (HQ.aOp == null || (HQ.aOp.getWidth() != a.this.width && HQ.aOp.getHeight() != a.this.height)) {
                        try {
                            HQ.aOp = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_8888);
                        } catch (OutOfMemoryError e) {
                            TbadkCoreApplication.getInst().onAppMemoryLow();
                            try {
                                HQ.aOp = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_4444);
                            } catch (OutOfMemoryError e2) {
                                TbadkCoreApplication.getInst().onAppMemoryLow();
                            } catch (Throwable th) {
                                BdLog.e(th.getMessage());
                            }
                        } catch (Throwable th2) {
                            BdLog.e(th2.getMessage());
                        }
                    }
                    a.this.aNM.a(HQ.aOp, null);
                    HQ.delay = a.this.aNM.U(a.this.aOd);
                    a.A(a.this);
                    if (HQ.aOp == null) {
                        a.A(a.this);
                    }
                    a.this.aOd %= a.this.aNZ;
                    a.this.aOb.put(HQ);
                    if (a.this.aOg) {
                        a.this.mHandler.sendEmptyMessage(1);
                    }
                } catch (Exception e3) {
                    return;
                }
            }
        }
    }

    public boolean HR() {
        return this.aNS;
    }

    public void setLoadBigImage(boolean z) {
        this.aNS = z;
    }

    public int getBottomOffset() {
        return this.aNP;
    }

    public int getLeftOffset() {
        return this.aNQ;
    }
}
