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
    private static final int ayE = l.ae(TbadkCoreApplication.getInst()) / 5;
    private float aNB;
    private float aNC;
    private ArrayList<Float> aND;
    private float aNE;
    private float aNF;
    private float aNG;
    private boolean aNH;
    private byte[] aNI;
    private int aNJ;
    private int aNK;
    private f aNL;
    private View.OnClickListener aNM;
    private C0078a aNN;
    private float aNO;
    private boolean aNP;
    private boolean aNQ;
    private int aNR;
    private volatile com.baidu.adp.gif.b aNS;
    private Bitmap aNT;
    private int aNU;
    private int aNV;
    private int aNW;
    private int aNX;
    private boolean aNY;
    private boolean aNZ;
    private float aOa;
    private com.baidu.tbadk.widget.a.b.b aOb;
    private ImageUrlData aOc;
    private Interpolator aOd;
    private Rect aOe;
    private int aOf;
    private c aOg;
    private BlockingLinkedDeque<c> aOh;
    private BlockingLinkedDeque<c> aOi;
    private volatile int aOj;
    private b aOk;
    private volatile long aOl;
    private volatile boolean aOm;
    public int ais;
    private View.OnLongClickListener avI;
    private e avL;
    private int avM;
    private RectF ayA;
    private d ayD;
    private boolean ayw;
    private float ayx;
    private Matrix ayy;
    private Rect ayz;
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
        public Bitmap aOv;
        public int delay;
    }

    /* loaded from: classes.dex */
    public interface d {
        void HU();

        void HV();
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
        int i = aVar.aOj;
        aVar.aOj = i + 1;
        return i;
    }

    public void setIsHeadImage(boolean z) {
        this.aNZ = z;
    }

    public void setImageUrlData(ImageUrlData imageUrlData) {
        this.aOc = imageUrlData;
    }

    public a(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aNH = false;
        this.aNI = null;
        this.avM = 0;
        this.aNJ = 1300;
        this.aNK = 0;
        this.aNL = null;
        this.aNM = null;
        this.avI = null;
        this.avL = null;
        this.aNO = 1.0f;
        this.ais = 0;
        this.mMode = 0;
        this.aNP = false;
        this.aNQ = false;
        this.aNR = 0;
        this.aNS = null;
        this.aNT = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aNU = 0;
        this.aNV = 0;
        this.aNW = 0;
        this.aNX = 0;
        this.aOd = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.ayy = new Matrix();
        this.ayw = false;
        this.mRatio = 1.0f;
        this.ayx = 0.0f;
        this.ayA = new RectF();
        this.width = 0;
        this.height = 0;
        this.aOf = 0;
        this.aOg = null;
        this.aOh = new BlockingLinkedDeque<>(5);
        this.aOi = new BlockingLinkedDeque<>(6);
        this.aOj = 0;
        this.aOl = 0L;
        this.aOm = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.a.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        a.this.HQ();
                        break;
                    case 1:
                        if (a.this.aOm) {
                            a.this.HQ();
                            break;
                        }
                        break;
                    case 2:
                        a.this.invalidate();
                        a.this.aOl = System.currentTimeMillis();
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
        this.aNH = false;
        this.aNI = null;
        this.avM = 0;
        this.aNJ = 1300;
        this.aNK = 0;
        this.aNL = null;
        this.aNM = null;
        this.avI = null;
        this.avL = null;
        this.aNO = 1.0f;
        this.ais = 0;
        this.mMode = 0;
        this.aNP = false;
        this.aNQ = false;
        this.aNR = 0;
        this.aNS = null;
        this.aNT = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aNU = 0;
        this.aNV = 0;
        this.aNW = 0;
        this.aNX = 0;
        this.aOd = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.ayy = new Matrix();
        this.ayw = false;
        this.mRatio = 1.0f;
        this.ayx = 0.0f;
        this.ayA = new RectF();
        this.width = 0;
        this.height = 0;
        this.aOf = 0;
        this.aOg = null;
        this.aOh = new BlockingLinkedDeque<>(5);
        this.aOi = new BlockingLinkedDeque<>(6);
        this.aOj = 0;
        this.aOl = 0L;
        this.aOm = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.a.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        a.this.HQ();
                        break;
                    case 1:
                        if (a.this.aOm) {
                            a.this.HQ();
                            break;
                        }
                        break;
                    case 2:
                        a.this.invalidate();
                        a.this.aOl = System.currentTimeMillis();
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
        this.aNH = false;
        this.aNI = null;
        this.avM = 0;
        this.aNJ = 1300;
        this.aNK = 0;
        this.aNL = null;
        this.aNM = null;
        this.avI = null;
        this.avL = null;
        this.aNO = 1.0f;
        this.ais = 0;
        this.mMode = 0;
        this.aNP = false;
        this.aNQ = false;
        this.aNR = 0;
        this.aNS = null;
        this.aNT = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aNU = 0;
        this.aNV = 0;
        this.aNW = 0;
        this.aNX = 0;
        this.aOd = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.ayy = new Matrix();
        this.ayw = false;
        this.mRatio = 1.0f;
        this.ayx = 0.0f;
        this.ayA = new RectF();
        this.width = 0;
        this.height = 0;
        this.aOf = 0;
        this.aOg = null;
        this.aOh = new BlockingLinkedDeque<>(5);
        this.aOi = new BlockingLinkedDeque<>(6);
        this.aOj = 0;
        this.aOl = 0L;
        this.aOm = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.a.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        a.this.HQ();
                        break;
                    case 1:
                        if (a.this.aOm) {
                            a.this.HQ();
                            break;
                        }
                        break;
                    case 2:
                        a.this.invalidate();
                        a.this.aOl = System.currentTimeMillis();
                        a.this.mHandler.sendEmptyMessage(0);
                        break;
                }
                return false;
            }
        });
        initData();
    }

    public void setDragToExitListener(d dVar) {
        this.ayD = dVar;
    }

    public int getImageType() {
        return this.ais;
    }

    public void setImageMode(int i) {
        this.aNK = i;
    }

    public void i(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.avM = i;
    }

    public boolean HB() {
        if (this.aOb != null) {
            return this.aOb.HB();
        }
        return false;
    }

    public void HC() {
        this.aNQ = false;
        this.aNH = false;
        this.mMode = 3;
        HI();
        if (this.mCurrentScale < this.aNE) {
            this.mCurrentScale = this.aNE;
            HP();
        }
        invalidate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.aOb != null && this.aOb.onTouchEvent(motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.aNH = true;
                this.aNP = false;
                this.aNQ = false;
                break;
            case 1:
                HC();
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
            this.aNO = m(motionEvent);
            if (this.aNO > 10.0f) {
                this.mMode = 2;
            }
        }
        if (this.mMode == 2 || !this.mGestureDetector.onTouchEvent(motionEvent)) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.aNP = true;
                        this.aNQ = true;
                        if (this.ais != 1 && this.ais != 2) {
                            float m = m(motionEvent);
                            if (m >= 0.0f && Math.abs(this.aNO - m) >= 10.0f) {
                                if (Math.abs(this.aNO - m) > 100.0f) {
                                    this.aNO = m;
                                    break;
                                } else {
                                    float f2 = m / this.aNO;
                                    this.aNO = m;
                                    this.aNG = this.mCurrentScale;
                                    this.mCurrentScale *= f2;
                                    if (this.mCurrentScale > this.aNF) {
                                        this.mCurrentScale = this.aNF;
                                    }
                                    float minScaleValue = getMinScaleValue();
                                    if (this.mCurrentScale < minScaleValue) {
                                        this.mCurrentScale = minScaleValue;
                                    }
                                    HP();
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
        return this.aOb != null ? this.aOb.getMinScaleValue() : this.aNE / 4.0f;
    }

    public float m(MotionEvent motionEvent) {
        return CompatibleUtile.getInstance().getSpacing(motionEvent);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            this.mViewWidth = i3 - i;
            this.mViewHeight = i4 - i2;
            HE();
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public boolean HD() {
        if (this.aOb != null) {
            return this.aOb.IF();
        }
        return this.aNE == this.mCurrentScale;
    }

    protected float f(Bitmap bitmap) {
        if (this.aOb != null) {
            return this.aOb.IJ();
        }
        if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            return 1.0f;
        }
        if (this.aNK == 0) {
            float width = this.mViewWidth / bitmap.getWidth();
            float height = this.mViewHeight / bitmap.getHeight();
            if (this.aNZ) {
                if (this.ais == 2) {
                    return 2.5f;
                }
                return Math.min(width, height);
            } else if (this.ais != 2) {
                float f2 = this.aOa;
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
        if (this.aOb != null) {
            return this.aOb.IK();
        }
        float f2 = 1.0f;
        if (bitmap != null && !bitmap.isRecycled() && bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
            f2 = FloatMath.sqrt(this.aNJ / (bitmap.getWidth() * bitmap.getHeight()));
            if (f2 > 10.0f) {
                return 10.0f;
            }
        }
        return f2;
    }

    private void HE() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            this.aNE = f(imageBitmap);
            this.aNF = g(imageBitmap);
            this.aND.clear();
            this.aND.add(Float.valueOf(this.aNE));
            this.mCurrentScale = this.aNE;
            this.aNG = this.mCurrentScale;
            HP();
            return;
        }
        this.aNB = 0.0f;
        this.aNC = 0.0f;
        this.aNE = 1.0f;
        this.aNF = 1.0f;
        this.mCurrentScale = 1.0f;
        this.aNG = this.mCurrentScale;
        this.aND.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    private void HF() {
        if (this.aNL != null) {
            this.aNL.a(this, canZoomIn(), canZoomOut());
        }
    }

    public void setOnSizeChangedListener(f fVar) {
        this.aNL = fVar;
    }

    public byte[] getImageData() {
        return this.aNI;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getMeasuredHeight() != 0 && getMeasuredWidth() != 0 && this.aOb != null) {
            this.aOb.IH();
        }
    }

    public void a(Bitmap bitmap, byte[] bArr) {
        this.aNI = bArr;
        if (this.aOb != null) {
            this.aOb.b(bitmap, bArr);
        }
        setImageBitmap(bitmap);
    }

    public void HG() {
        if (this.aOb == null) {
            this.aOb = new com.baidu.tbadk.widget.a.b.b(this);
            this.aOb.setOnClickListener(this.aNM);
            this.aOb.setOnLongClickListener(this.avI);
        }
    }

    public void setImageLoadCallBack(com.baidu.tbadk.widget.a.b.a aVar) {
        if (this.aOb != null) {
            this.aOb.a(aVar);
        }
    }

    public boolean HH() {
        return (getImageBitmap() == null || this.aOb == null) ? false : true;
    }

    public Bitmap getGifCache() {
        return this.aNT;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        boolean z;
        if (this.aOb == null || !this.aOb.b(canvas, getImageBitmap())) {
            if (this.ais == 2 && this.aNX != 0 && !this.aNN.HT()) {
                int width = getWidth();
                int height = getHeight();
                Drawable drawable = getDrawable();
                float f2 = 0.0f;
                float f3 = height * 0.3f;
                float f4 = width;
                float f5 = (1.0f - 0.3f) * height;
                if (this.aNZ && drawable != null) {
                    Rect bounds = drawable.getBounds();
                    int i = bounds.right - bounds.left;
                    int i2 = bounds.bottom - bounds.top;
                    f2 = (width / 2) - (i * 2.5f);
                    f3 = (height / 2) - (i2 * 2.5f);
                    f4 = (i * 2.5f) + (width / 2);
                    f5 = (i2 * 2.5f) + (height / 2);
                }
                this.mPaint.setColor(aj.getColor(this.aNX));
                canvas.drawRect(f2, f3, f4, f5, this.mPaint);
                this.mPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
            }
            if (this.mMode == 3 && this.ayw) {
                this.ayw = false;
                this.ayy.reset();
                if (this.ayx < ayE) {
                    this.mMode = 0;
                } else {
                    this.mMode = 4;
                    Bz();
                }
            }
            if (this.ais == 0 && this.ayw && this.ayz != null && this.aOc != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                if (this.ayA == null) {
                    this.ayA = new RectF();
                }
                this.ayy.mapRect(this.ayA, new RectF(this.ayz));
                Bitmap imageBitmap = getImageBitmap();
                if (imageBitmap != null && !imageBitmap.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.aOe, this.ayA, (Paint) null);
                }
            } else if (this.mMode == 4 && this.ayz != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                Bitmap imageBitmap2 = getImageBitmap();
                if (imageBitmap2 != null && !imageBitmap2.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.aOe, this.ayA, (Paint) null);
                }
            } else {
                super.onDraw(canvas);
            }
            if (this.ais == 1 && this.aNT != null && !this.aNT.isRecycled()) {
                int width2 = this.aNT.getWidth();
                int height2 = this.aNT.getHeight();
                int width3 = getWidth();
                int height3 = getHeight();
                int i3 = (width3 - width2) >> 1;
                int i4 = (height3 - height2) >> 1;
                float f6 = this.aOa;
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
                if (this.aNR == 1 && this.aNS != null && this.aOg != null && this.aOg.aOv != null) {
                    if (z) {
                        canvas.drawBitmap(this.aOg.aOv, i3, i4, (Paint) null);
                    } else {
                        canvas.drawBitmap(this.aOg.aOv, this.mMatrix, this.mPaint);
                    }
                    invalidate();
                } else if (z) {
                    canvas.drawBitmap(this.aNT, i3, i4, (Paint) null);
                } else {
                    canvas.drawBitmap(this.aNT, this.mMatrix, this.mPaint);
                }
            }
        }
    }

    public void play() {
        com.baidu.adp.widget.a.a aVar;
        if (this.ais == 1) {
            if (this.aNS == null) {
                if (this.aOk != null) {
                    this.aOk.wz = false;
                    this.aOk.interrupt();
                    this.aOk = null;
                }
                if (this.aNI != null) {
                    try {
                        aVar = a.C0002a.dD().g(this.aNI, 0, this.aNI.length);
                    } catch (StackOverflowError e2) {
                        aVar = null;
                    }
                    if (aVar == null || aVar.getGif() == null) {
                        com.baidu.tbadk.core.d.a.a("gifplay", -1L, -1, "DragImageView.play", -1, "decode error", new Object[0]);
                        return;
                    }
                    this.aNS = aVar.getGif();
                    if (this.aNS != null) {
                        this.aNR = 1;
                        this.width = this.aNS.getWidth();
                        this.height = this.aNS.getHeight();
                        this.aOj = 0;
                        this.aOf = this.aNS.getFrameCount();
                    } else {
                        this.aNR = 0;
                    }
                } else {
                    return;
                }
            }
            if (this.aNS != null) {
                if (this.aOk == null || (this.aOk != null && !this.aOk.wz)) {
                    this.aOm = true;
                    this.aOk = new b();
                    this.aOh.clear();
                    this.aOi.clear();
                    this.aOk.wz = true;
                    this.aOk.start();
                }
            }
        }
    }

    public void pause() {
        if (this.ais == 1) {
            if (this.aOk != null) {
                this.aOk.wz = false;
                this.aOk.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.ais == 1) {
            if (this.aOk != null) {
                this.aOk.wz = false;
                this.aOk.interrupt();
                this.aOk = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.aOm = true;
            this.aOg = null;
            this.aOi.clear();
            this.aOh.clear();
            this.width = 0;
            this.height = 0;
            this.aOj = 0;
            this.aOf = 0;
            this.aNS = null;
        }
    }

    private void initData() {
        this.aOa = l.af(getContext());
        this.aNJ = l.ae(getContext()) * l.ac(getContext()) * 2;
        if (this.aNJ < 1690000) {
            this.aNJ = 1690000;
        }
        this.aNB = 0.0f;
        this.aNC = 0.0f;
        this.aND = new ArrayList<>();
        this.aNE = 1.0f;
        this.aNF = 1.0f;
        this.mCurrentScale = 1.0f;
        this.aNG = this.mCurrentScale;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.aNN = new C0078a();
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWillNotDraw(false);
        scrollTo(0, 0);
        this.mGestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.a.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                if (a.this.ais != 2 && (Math.abs(f2) > 200.0f || Math.abs(f3) > 200.0f)) {
                    a.this.aNN.e(f2, f3);
                    a.this.startAnimation(a.this.aNN);
                }
                return super.onFling(motionEvent, motionEvent2, f2, f3);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (a.this.ais != 1 && a.this.ais != 2) {
                    a.this.mMode = 2;
                    if (a.this.mCurrentScale > a.this.aNE) {
                        a.this.mCurrentScale = a.this.aNE;
                        a.this.aNG = a.this.mCurrentScale;
                        a.this.HP();
                        return true;
                    }
                    a.this.mCurrentScale = a.this.aNE * 2.0f;
                    a.this.d(true, (int) motionEvent.getX(), (int) motionEvent.getY());
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (a.this.aNM != null && !a.this.aNP) {
                    a.this.aNM.onClick(a.this);
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
                a.this.aNP = true;
                if (a.this.aNK == 0 && a.this.aNQ) {
                    return false;
                }
                int scrollX = a.this.getScrollX();
                int scrollY = a.this.getScrollY();
                if (a.this.aNB >= a.this.getWidth()) {
                    scrollX = (int) (scrollX + f2);
                    if (a.this.aNK == 0) {
                        i = scrollX >= 0 ? scrollX : 0;
                        if (a.this.getWidth() + i > a.this.aNB) {
                            i = (int) (a.this.aNB - a.this.getWidth());
                        }
                        if (a.this.aNC + a.this.mTop + a.this.mBottom < a.this.getHeight()) {
                            i2 = (int) (scrollY + f3);
                            if (a.this.aNK == 0) {
                                if (i2 < (-a.this.aNU)) {
                                    i2 = -a.this.aNU;
                                }
                                if (a.this.getHeight() + i2 > a.this.aNC + a.this.mBottom + a.this.aNV) {
                                    i2 = (int) ((a.this.aNC - a.this.getHeight()) + a.this.mBottom + a.this.aNV);
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
                if (a.this.aNC + a.this.mTop + a.this.mBottom < a.this.getHeight()) {
                }
                if (i == a.this.getScrollX()) {
                }
                a.this.scrollTo(i, i2);
                a.this.invalidate();
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (a.this.avI != null && !a.this.aNP) {
                    a.this.avI.onLongClick(a.this);
                }
                super.onLongPress(motionEvent);
            }
        });
    }

    private void Bz() {
        if (this.aOc == null) {
            if (this.ayD != null) {
                this.ayD.HV();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.aOc.getSourceImageRectInScreen();
        if (sourceImageRectInScreen == null) {
            if (this.ayD != null) {
                this.ayD.HV();
                return;
            }
            return;
        }
        this.ayA.bottom = (((sourceImageRectInScreen.bottom - sourceImageRectInScreen.top) / (sourceImageRectInScreen.right - sourceImageRectInScreen.left)) * (this.ayA.right - this.ayA.left)) + this.ayA.top;
        final float[] fArr = {(this.ayA.left + this.ayA.right) / 2.0f, (this.ayA.top + this.ayA.bottom) / 2.0f};
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
                    a.this.ayA = a.this.e(floatValue, animatedFraction, sourceImageRectInScreen.right - sourceImageRectInScreen.left, sourceImageRectInScreen.bottom - sourceImageRectInScreen.top);
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
                a.this.ayw = false;
                a.this.mMode = 4;
                a.this.invalidate();
                if (a.this.ayD != null) {
                    a.this.ayD.HV();
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

    private void HI() {
        int i = 0;
        int scrollX = getScrollX();
        if (this.aNB >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.aNB) {
                scrollX = (int) (this.aNB - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.aNC + this.mTop + this.mBottom >= getHeight()) {
            i = scrollY < (-this.aNU) ? -this.aNU : scrollY;
            if (getHeight() + i > this.aNC + this.mBottom + this.aNV) {
                i = (int) ((this.aNC - getHeight()) + this.mBottom + this.aNV);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.aOb != null) {
            this.aOb.IG();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.aNB;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.aNC;
    }

    public boolean HJ() {
        if (this.ais == 1 || this.ais == 2) {
            return true;
        }
        return !this.aNQ && getScrollX() >= ((int) (this.aNB - ((float) getWidth()))) + (-1);
    }

    public boolean HK() {
        if (this.ais == 1 || this.ais == 2) {
            return true;
        }
        return !this.aNQ && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.aNN.HT()) {
            this.aNN.stopAnimation();
        }
        this.aNX = 0;
        super.setImageBitmap(bitmap);
        HE();
        this.ais = 0;
        if (this.ayz == null) {
            int measuredWidth = getMeasuredWidth();
            float measuredWidth2 = ((1.0f * getMeasuredWidth()) / bitmap.getWidth()) * bitmap.getHeight();
            if (measuredWidth2 > getMeasuredHeight()) {
                measuredWidth2 = getMeasuredHeight();
            }
            RectF e2 = e(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
            this.ayz = new Rect((int) e2.left, (int) e2.top, (int) e2.right, (int) e2.bottom);
        }
        if (this.aOe == null) {
            this.aOe = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
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
            if (this.aNN.HT()) {
                this.aNN.stopAnimation();
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            super.setImageBitmap(bitmap);
            super.setImageMatrix(this.mMatrix);
            scrollTo(scrollX, scrollY);
            this.ais = 0;
        }
    }

    public void a(byte[] bArr, Bitmap bitmap) {
        if (this.aNN.HT()) {
            this.aNN.stopAnimation();
        }
        super.setImageDrawable(null);
        stop();
        HE();
        this.ais = 1;
        this.aNT = bitmap;
        this.aNI = bArr;
        if (this.avL != null) {
            this.avL.a(this);
        }
    }

    public void onDestroy() {
        if (this.aNN.HT()) {
            this.aNN.stopAnimation();
        }
        super.setImageDrawable(null);
        this.aNI = null;
        this.aNT = null;
        stop();
        if (this.aNS != null) {
            this.aNS.close();
            this.aNS = null;
        }
        if (this.aOb != null) {
            this.aOb.release();
            System.gc();
        }
    }

    public void release() {
        if (this.aNN.HT()) {
            this.aNN.stopAnimation();
        }
        stop();
        super.setImageDrawable(null);
        this.aNT = null;
    }

    public void HL() {
        if (this.aNN.HT()) {
            this.aNN.stopAnimation();
        }
        try {
            if (this.aNZ) {
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
        this.ais = 2;
        HE();
    }

    public void HM() {
        if (this.ais != 1 && this.ais != 2) {
            int size = this.aND.size();
            if (size > 0) {
                this.aND.add(Float.valueOf(this.aND.get(size - 1).floatValue() * 1.25f));
            } else {
                this.aND.add(Float.valueOf(this.aNE));
            }
            HP();
        }
    }

    public void HN() {
        if (this.ais != 1 && this.ais != 2) {
            int size = this.aND.size();
            if (size > 1) {
                this.aND.remove(size - 1);
            }
            HP();
        }
    }

    public void HO() {
        HF();
        if (this.ais != 1 && this.ais != 2 && this.mCurrentScale != this.aNE) {
            this.aND.clear();
            this.aND.add(Float.valueOf(this.aNE));
            this.mCurrentScale = this.aNE;
            this.aNG = this.mCurrentScale;
            HP();
        }
    }

    public boolean canZoomIn() {
        if (this.ais == 1 || this.ais == 2) {
            return false;
        }
        int size = this.aND.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.aND.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.aNJ) && floatValue <= 5.0f;
    }

    public boolean canZoomOut() {
        if (this.ais == 1 || this.ais == 2) {
            return false;
        }
        int size = this.aND.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled()) {
            return false;
        }
        return size > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HP() {
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
                    int size = this.aND.size();
                    if (size > 0) {
                        f3 = this.aND.get(size - 1).floatValue();
                    } else {
                        f3 = this.aNE;
                    }
                    this.mCurrentScale = f3;
                }
                this.mMatrix.setScale(this.mCurrentScale, this.mCurrentScale);
                this.aNB = imageBitmap.getWidth() * this.mCurrentScale;
                this.aNC = imageBitmap.getHeight() * this.mCurrentScale;
                float width = this.aNG * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.aNG;
                this.aNU = this.mTop;
                this.aNV = 0;
                float f4 = this.aNB < ((float) this.mViewWidth) ? (int) ((this.mViewWidth - this.aNB) / 2.0f) : 0.0f;
                if (this.aNC < this.mViewHeight) {
                    f2 = (int) ((this.mViewHeight - this.aNC) / 2.0f);
                    if (this.aNK == 1 && f2 > this.mTop) {
                        f2 = this.mTop;
                    }
                    this.aNU = (int) (this.mTop - f2);
                    this.aNV = this.mTop - this.aNU;
                } else {
                    f2 = 0.0f;
                }
                this.aNW = (int) f4;
                this.mMatrix.postTranslate(f4, f2);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    int width2 = i > getWidth() ? getWidth() : i;
                    if (this.aNB <= screenWidth) {
                        width2 = 0;
                    } else if (this.aNB > screenWidth && this.aNB / 2.0f < screenWidth) {
                        width2 = (int) (width2 - (this.aNB / 4.0f));
                    }
                    scrollX = width2;
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.aNB - width) / 2.0f);
                    }
                    if (this.aNB <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.aNB) {
                        scrollX = (int) (this.aNB - getWidth());
                    }
                }
                if (scrollX > 0 && this.aNB - scrollX < getWidth()) {
                    scrollX = (int) (this.aNB - getWidth());
                }
                int i3 = this.mMode == 2 ? ((int) ((this.aNC - height) / 2.0f)) + scrollY : scrollY;
                if (this.aNC <= getHeight()) {
                    i3 = 0;
                } else if (getHeight() + i3 > this.aNC) {
                    i3 = (int) (this.aNC - getHeight());
                }
                setHorizontalScrollBarEnabled(false);
                setVerticalScrollBarEnabled(false);
                if (scrollX < 0) {
                    scrollX = 0;
                }
                scrollTo(scrollX, i3 >= 0 ? i3 : 0);
                setImageMatrix(this.mMatrix);
                HF();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0078a extends Animation {
        private boolean aOo = false;
        private boolean aOp = false;
        private long aOq;
        private long aOr;
        private int aOs;
        private long aOt;
        private long aOu;
        private int mStartY;

        public C0078a() {
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
            this.aOq = f;
            this.aOr = f2;
            this.aOt = Math.abs((f * 1000.0f) / 2500.0f);
            this.aOu = Math.abs((f2 * 1000.0f) / 2500.0f);
            setDuration(Math.max(this.aOt, this.aOu));
            setInterpolator(a.this.aOd);
            this.aOs = a.this.getScrollX();
            this.mStartY = a.this.getScrollY();
            this.aOo = true;
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
            if (this.aOt > this.aOu) {
                j = ((float) this.aOt) * f;
            } else {
                j = ((float) this.aOu) * f;
            }
            float f2 = ((float) (j > this.aOt ? this.aOt : j)) / 1000.0f;
            if (this.aOq > 0) {
                i = this.aOs - ((int) (f2 * (((float) this.aOq) - ((2500.0f * f2) / 2.0f))));
            } else {
                i = this.aOs - ((int) (f2 * (((float) this.aOq) + ((2500.0f * f2) / 2.0f))));
            }
            if (j > this.aOu) {
                j = this.aOu;
            }
            float f3 = ((float) j) / 1000.0f;
            if (this.aOr > 0) {
                i2 = this.mStartY - ((int) (f3 * (((float) this.aOr) - ((2500.0f * f3) / 2.0f))));
            } else {
                i2 = this.mStartY - ((int) (f3 * (((float) this.aOr) + ((2500.0f * f3) / 2.0f))));
            }
            if (a.this.aNC + a.this.mTop + a.this.mBottom > a.this.getHeight()) {
                if (i2 < (-a.this.aNU)) {
                    i2 = -a.this.aNU;
                }
                if (a.this.getHeight() + i2 > a.this.aNC + a.this.mBottom + a.this.aNV) {
                    i2 = (int) ((a.this.aNC - a.this.getHeight()) + a.this.mBottom + a.this.aNV);
                }
            } else {
                i2 = 0;
            }
            if (a.this.aNB > a.this.getWidth()) {
                int width = ((float) (a.this.getWidth() + i)) > a.this.aNB ? (int) (a.this.aNB - a.this.getWidth()) : i;
                if (width >= 0) {
                    i3 = width;
                }
            }
            a.this.scrollTo(i3, i2);
            a.this.invalidate();
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            if (!this.aOp) {
                if (a.this.aNH) {
                    this.aOo = false;
                    return false;
                }
                try {
                    if (super.getTransformation(j, transformation)) {
                        return true;
                    }
                    this.aOo = false;
                    return false;
                } catch (Exception e) {
                    this.aOo = false;
                    return false;
                }
            }
            this.aOp = false;
            this.aOo = false;
            return false;
        }

        public boolean HT() {
            return this.aOo;
        }

        public void stopAnimation() {
            this.aOp = true;
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.aNM = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.avI = onLongClickListener;
        if (this.aOb != null) {
            this.aOb.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setGifSetListener(e eVar) {
        this.avL = eVar;
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
    public void HQ() {
        long j;
        c poll = this.aOh.poll();
        if (poll == null) {
            this.aOm = true;
            return;
        }
        this.aOm = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.aOg != null) {
            j = this.aOg.delay - (currentTimeMillis - this.aOl);
            this.aOi.offer(this.aOg);
        } else {
            j = 0;
        }
        this.aOg = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public c HR() {
        c poll = this.aOi.poll();
        if (poll == null) {
            poll = new c();
            try {
                poll.aOv = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
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
        return this.aOg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends Thread {
        private volatile boolean wz;

        private b() {
            this.wz = false;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (this.wz && a.this.aNS != null && a.this.aOf > 0 && a.this.width > 0 && a.this.height > 0) {
                try {
                    a.this.aNS.S(a.this.aOj);
                    c HR = a.this.HR();
                    if (HR.aOv == null || (HR.aOv.getWidth() != a.this.width && HR.aOv.getHeight() != a.this.height)) {
                        try {
                            HR.aOv = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_8888);
                        } catch (OutOfMemoryError e) {
                            TbadkCoreApplication.getInst().onAppMemoryLow();
                            try {
                                HR.aOv = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_4444);
                            } catch (OutOfMemoryError e2) {
                                TbadkCoreApplication.getInst().onAppMemoryLow();
                            } catch (Throwable th) {
                                BdLog.e(th.getMessage());
                            }
                        } catch (Throwable th2) {
                            BdLog.e(th2.getMessage());
                        }
                    }
                    a.this.aNS.a(HR.aOv, null);
                    HR.delay = a.this.aNS.T(a.this.aOj);
                    a.A(a.this);
                    if (HR.aOv == null) {
                        a.A(a.this);
                    }
                    a.this.aOj %= a.this.aOf;
                    a.this.aOh.put(HR);
                    if (a.this.aOm) {
                        a.this.mHandler.sendEmptyMessage(1);
                    }
                } catch (Exception e3) {
                    return;
                }
            }
        }
    }

    public boolean HS() {
        return this.aNY;
    }

    public void setLoadBigImage(boolean z) {
        this.aNY = z;
    }

    public int getBottomOffset() {
        return this.aNV;
    }

    public int getLeftOffset() {
        return this.aNW;
    }
}
