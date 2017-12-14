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
    private static final int ayB = l.ae(TbadkCoreApplication.getInst()) / 5;
    private ArrayList<Float> aNA;
    private float aNB;
    private float aNC;
    private float aND;
    private boolean aNE;
    private byte[] aNF;
    private int aNG;
    private int aNH;
    private f aNI;
    private View.OnClickListener aNJ;
    private C0079a aNK;
    private float aNL;
    private boolean aNM;
    private boolean aNN;
    private int aNO;
    private volatile com.baidu.adp.gif.b aNP;
    private Bitmap aNQ;
    private int aNR;
    private int aNS;
    private int aNT;
    private int aNU;
    private boolean aNV;
    private boolean aNW;
    private float aNX;
    private com.baidu.tbadk.widget.a.b.b aNY;
    private ImageUrlData aNZ;
    private float aNy;
    private float aNz;
    private Interpolator aOa;
    private Rect aOb;
    private int aOc;
    private c aOd;
    private BlockingLinkedDeque<c> aOe;
    private BlockingLinkedDeque<c> aOf;
    private volatile int aOg;
    private b aOh;
    private volatile long aOi;
    private volatile boolean aOj;
    public int aip;
    private View.OnLongClickListener avF;
    private e avI;
    private int avJ;
    private d ayA;
    private boolean ayt;
    private float ayu;
    private Matrix ayv;
    private Rect ayw;
    private RectF ayx;
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
        public Bitmap aOs;
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
        int i = aVar.aOg;
        aVar.aOg = i + 1;
        return i;
    }

    public void setIsHeadImage(boolean z) {
        this.aNW = z;
    }

    public void setImageUrlData(ImageUrlData imageUrlData) {
        this.aNZ = imageUrlData;
    }

    public a(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aNE = false;
        this.aNF = null;
        this.avJ = 0;
        this.aNG = 1300;
        this.aNH = 0;
        this.aNI = null;
        this.aNJ = null;
        this.avF = null;
        this.avI = null;
        this.aNL = 1.0f;
        this.aip = 0;
        this.mMode = 0;
        this.aNM = false;
        this.aNN = false;
        this.aNO = 0;
        this.aNP = null;
        this.aNQ = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aNR = 0;
        this.aNS = 0;
        this.aNT = 0;
        this.aNU = 0;
        this.aOa = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.ayv = new Matrix();
        this.ayt = false;
        this.mRatio = 1.0f;
        this.ayu = 0.0f;
        this.ayx = new RectF();
        this.width = 0;
        this.height = 0;
        this.aOc = 0;
        this.aOd = null;
        this.aOe = new BlockingLinkedDeque<>(5);
        this.aOf = new BlockingLinkedDeque<>(6);
        this.aOg = 0;
        this.aOi = 0L;
        this.aOj = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.a.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        a.this.HQ();
                        break;
                    case 1:
                        if (a.this.aOj) {
                            a.this.HQ();
                            break;
                        }
                        break;
                    case 2:
                        a.this.invalidate();
                        a.this.aOi = System.currentTimeMillis();
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
        this.aNE = false;
        this.aNF = null;
        this.avJ = 0;
        this.aNG = 1300;
        this.aNH = 0;
        this.aNI = null;
        this.aNJ = null;
        this.avF = null;
        this.avI = null;
        this.aNL = 1.0f;
        this.aip = 0;
        this.mMode = 0;
        this.aNM = false;
        this.aNN = false;
        this.aNO = 0;
        this.aNP = null;
        this.aNQ = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aNR = 0;
        this.aNS = 0;
        this.aNT = 0;
        this.aNU = 0;
        this.aOa = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.ayv = new Matrix();
        this.ayt = false;
        this.mRatio = 1.0f;
        this.ayu = 0.0f;
        this.ayx = new RectF();
        this.width = 0;
        this.height = 0;
        this.aOc = 0;
        this.aOd = null;
        this.aOe = new BlockingLinkedDeque<>(5);
        this.aOf = new BlockingLinkedDeque<>(6);
        this.aOg = 0;
        this.aOi = 0L;
        this.aOj = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.a.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        a.this.HQ();
                        break;
                    case 1:
                        if (a.this.aOj) {
                            a.this.HQ();
                            break;
                        }
                        break;
                    case 2:
                        a.this.invalidate();
                        a.this.aOi = System.currentTimeMillis();
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
        this.aNE = false;
        this.aNF = null;
        this.avJ = 0;
        this.aNG = 1300;
        this.aNH = 0;
        this.aNI = null;
        this.aNJ = null;
        this.avF = null;
        this.avI = null;
        this.aNL = 1.0f;
        this.aip = 0;
        this.mMode = 0;
        this.aNM = false;
        this.aNN = false;
        this.aNO = 0;
        this.aNP = null;
        this.aNQ = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aNR = 0;
        this.aNS = 0;
        this.aNT = 0;
        this.aNU = 0;
        this.aOa = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.ayv = new Matrix();
        this.ayt = false;
        this.mRatio = 1.0f;
        this.ayu = 0.0f;
        this.ayx = new RectF();
        this.width = 0;
        this.height = 0;
        this.aOc = 0;
        this.aOd = null;
        this.aOe = new BlockingLinkedDeque<>(5);
        this.aOf = new BlockingLinkedDeque<>(6);
        this.aOg = 0;
        this.aOi = 0L;
        this.aOj = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.a.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        a.this.HQ();
                        break;
                    case 1:
                        if (a.this.aOj) {
                            a.this.HQ();
                            break;
                        }
                        break;
                    case 2:
                        a.this.invalidate();
                        a.this.aOi = System.currentTimeMillis();
                        a.this.mHandler.sendEmptyMessage(0);
                        break;
                }
                return false;
            }
        });
        initData();
    }

    public void setDragToExitListener(d dVar) {
        this.ayA = dVar;
    }

    public int getImageType() {
        return this.aip;
    }

    public void setImageMode(int i) {
        this.aNH = i;
    }

    public void i(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.avJ = i;
    }

    public boolean HB() {
        if (this.aNY != null) {
            return this.aNY.HB();
        }
        return false;
    }

    public void HC() {
        this.aNN = false;
        this.aNE = false;
        this.mMode = 3;
        HI();
        if (this.mCurrentScale < this.aNB) {
            this.mCurrentScale = this.aNB;
            HP();
        }
        invalidate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.aNY != null && this.aNY.onTouchEvent(motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.aNE = true;
                this.aNM = false;
                this.aNN = false;
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
            this.aNL = m(motionEvent);
            if (this.aNL > 10.0f) {
                this.mMode = 2;
            }
        }
        if (this.mMode == 2 || !this.mGestureDetector.onTouchEvent(motionEvent)) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.aNM = true;
                        this.aNN = true;
                        if (this.aip != 1 && this.aip != 2) {
                            float m = m(motionEvent);
                            if (m >= 0.0f && Math.abs(this.aNL - m) >= 10.0f) {
                                if (Math.abs(this.aNL - m) > 100.0f) {
                                    this.aNL = m;
                                    break;
                                } else {
                                    float f2 = m / this.aNL;
                                    this.aNL = m;
                                    this.aND = this.mCurrentScale;
                                    this.mCurrentScale *= f2;
                                    if (this.mCurrentScale > this.aNC) {
                                        this.mCurrentScale = this.aNC;
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
        return this.aNY != null ? this.aNY.getMinScaleValue() : this.aNB / 4.0f;
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
        if (this.aNY != null) {
            return this.aNY.IF();
        }
        return this.aNB == this.mCurrentScale;
    }

    protected float f(Bitmap bitmap) {
        if (this.aNY != null) {
            return this.aNY.IJ();
        }
        if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            return 1.0f;
        }
        if (this.aNH == 0) {
            float width = this.mViewWidth / bitmap.getWidth();
            float height = this.mViewHeight / bitmap.getHeight();
            if (this.aNW) {
                if (this.aip == 2) {
                    return 2.5f;
                }
                return Math.min(width, height);
            } else if (this.aip != 2) {
                float f2 = this.aNX;
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
        if (this.aNY != null) {
            return this.aNY.IK();
        }
        float f2 = 1.0f;
        if (bitmap != null && !bitmap.isRecycled() && bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
            f2 = FloatMath.sqrt(this.aNG / (bitmap.getWidth() * bitmap.getHeight()));
            if (f2 > 10.0f) {
                return 10.0f;
            }
        }
        return f2;
    }

    private void HE() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            this.aNB = f(imageBitmap);
            this.aNC = g(imageBitmap);
            this.aNA.clear();
            this.aNA.add(Float.valueOf(this.aNB));
            this.mCurrentScale = this.aNB;
            this.aND = this.mCurrentScale;
            HP();
            return;
        }
        this.aNy = 0.0f;
        this.aNz = 0.0f;
        this.aNB = 1.0f;
        this.aNC = 1.0f;
        this.mCurrentScale = 1.0f;
        this.aND = this.mCurrentScale;
        this.aNA.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    private void HF() {
        if (this.aNI != null) {
            this.aNI.a(this, canZoomIn(), canZoomOut());
        }
    }

    public void setOnSizeChangedListener(f fVar) {
        this.aNI = fVar;
    }

    public byte[] getImageData() {
        return this.aNF;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getMeasuredHeight() != 0 && getMeasuredWidth() != 0 && this.aNY != null) {
            this.aNY.IH();
        }
    }

    public void a(Bitmap bitmap, byte[] bArr) {
        this.aNF = bArr;
        if (this.aNY != null) {
            this.aNY.b(bitmap, bArr);
        }
        setImageBitmap(bitmap);
    }

    public void HG() {
        if (this.aNY == null) {
            this.aNY = new com.baidu.tbadk.widget.a.b.b(this);
            this.aNY.setOnClickListener(this.aNJ);
            this.aNY.setOnLongClickListener(this.avF);
        }
    }

    public void setImageLoadCallBack(com.baidu.tbadk.widget.a.b.a aVar) {
        if (this.aNY != null) {
            this.aNY.a(aVar);
        }
    }

    public boolean HH() {
        return (getImageBitmap() == null || this.aNY == null) ? false : true;
    }

    public Bitmap getGifCache() {
        return this.aNQ;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        boolean z;
        if (this.aNY == null || !this.aNY.b(canvas, getImageBitmap())) {
            if (this.aip == 2 && this.aNU != 0 && !this.aNK.HT()) {
                int width = getWidth();
                int height = getHeight();
                Drawable drawable = getDrawable();
                float f2 = 0.0f;
                float f3 = height * 0.3f;
                float f4 = width;
                float f5 = (1.0f - 0.3f) * height;
                if (this.aNW && drawable != null) {
                    Rect bounds = drawable.getBounds();
                    int i = bounds.right - bounds.left;
                    int i2 = bounds.bottom - bounds.top;
                    f2 = (width / 2) - (i * 2.5f);
                    f3 = (height / 2) - (i2 * 2.5f);
                    f4 = (i * 2.5f) + (width / 2);
                    f5 = (i2 * 2.5f) + (height / 2);
                }
                this.mPaint.setColor(aj.getColor(this.aNU));
                canvas.drawRect(f2, f3, f4, f5, this.mPaint);
                this.mPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
            }
            if (this.mMode == 3 && this.ayt) {
                this.ayt = false;
                this.ayv.reset();
                if (this.ayu < ayB) {
                    this.mMode = 0;
                } else {
                    this.mMode = 4;
                    Bz();
                }
            }
            if (this.aip == 0 && this.ayt && this.ayw != null && this.aNZ != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                if (this.ayx == null) {
                    this.ayx = new RectF();
                }
                this.ayv.mapRect(this.ayx, new RectF(this.ayw));
                Bitmap imageBitmap = getImageBitmap();
                if (imageBitmap != null && !imageBitmap.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.aOb, this.ayx, (Paint) null);
                }
            } else if (this.mMode == 4 && this.ayw != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                Bitmap imageBitmap2 = getImageBitmap();
                if (imageBitmap2 != null && !imageBitmap2.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.aOb, this.ayx, (Paint) null);
                }
            } else {
                super.onDraw(canvas);
            }
            if (this.aip == 1 && this.aNQ != null && !this.aNQ.isRecycled()) {
                int width2 = this.aNQ.getWidth();
                int height2 = this.aNQ.getHeight();
                int width3 = getWidth();
                int height3 = getHeight();
                int i3 = (width3 - width2) >> 1;
                int i4 = (height3 - height2) >> 1;
                float f6 = this.aNX;
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
                if (this.aNO == 1 && this.aNP != null && this.aOd != null && this.aOd.aOs != null) {
                    if (z) {
                        canvas.drawBitmap(this.aOd.aOs, i3, i4, (Paint) null);
                    } else {
                        canvas.drawBitmap(this.aOd.aOs, this.mMatrix, this.mPaint);
                    }
                    invalidate();
                } else if (z) {
                    canvas.drawBitmap(this.aNQ, i3, i4, (Paint) null);
                } else {
                    canvas.drawBitmap(this.aNQ, this.mMatrix, this.mPaint);
                }
            }
        }
    }

    public void play() {
        com.baidu.adp.widget.a.a aVar;
        if (this.aip == 1) {
            if (this.aNP == null) {
                if (this.aOh != null) {
                    this.aOh.wy = false;
                    this.aOh.interrupt();
                    this.aOh = null;
                }
                if (this.aNF != null) {
                    try {
                        aVar = a.C0002a.dD().g(this.aNF, 0, this.aNF.length);
                    } catch (StackOverflowError e2) {
                        aVar = null;
                    }
                    if (aVar == null || aVar.getGif() == null) {
                        com.baidu.tbadk.core.d.a.a("gifplay", -1L, -1, "DragImageView.play", -1, "decode error", new Object[0]);
                        return;
                    }
                    this.aNP = aVar.getGif();
                    if (this.aNP != null) {
                        this.aNO = 1;
                        this.width = this.aNP.getWidth();
                        this.height = this.aNP.getHeight();
                        this.aOg = 0;
                        this.aOc = this.aNP.getFrameCount();
                    } else {
                        this.aNO = 0;
                    }
                } else {
                    return;
                }
            }
            if (this.aNP != null) {
                if (this.aOh == null || (this.aOh != null && !this.aOh.wy)) {
                    this.aOj = true;
                    this.aOh = new b();
                    this.aOe.clear();
                    this.aOf.clear();
                    this.aOh.wy = true;
                    this.aOh.start();
                }
            }
        }
    }

    public void pause() {
        if (this.aip == 1) {
            if (this.aOh != null) {
                this.aOh.wy = false;
                this.aOh.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.aip == 1) {
            if (this.aOh != null) {
                this.aOh.wy = false;
                this.aOh.interrupt();
                this.aOh = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.aOj = true;
            this.aOd = null;
            this.aOf.clear();
            this.aOe.clear();
            this.width = 0;
            this.height = 0;
            this.aOg = 0;
            this.aOc = 0;
            this.aNP = null;
        }
    }

    private void initData() {
        this.aNX = l.af(getContext());
        this.aNG = l.ae(getContext()) * l.ac(getContext()) * 2;
        if (this.aNG < 1690000) {
            this.aNG = 1690000;
        }
        this.aNy = 0.0f;
        this.aNz = 0.0f;
        this.aNA = new ArrayList<>();
        this.aNB = 1.0f;
        this.aNC = 1.0f;
        this.mCurrentScale = 1.0f;
        this.aND = this.mCurrentScale;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.aNK = new C0079a();
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWillNotDraw(false);
        scrollTo(0, 0);
        this.mGestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.a.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                if (a.this.aip != 2 && (Math.abs(f2) > 200.0f || Math.abs(f3) > 200.0f)) {
                    a.this.aNK.e(f2, f3);
                    a.this.startAnimation(a.this.aNK);
                }
                return super.onFling(motionEvent, motionEvent2, f2, f3);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (a.this.aip != 1 && a.this.aip != 2) {
                    a.this.mMode = 2;
                    if (a.this.mCurrentScale > a.this.aNB) {
                        a.this.mCurrentScale = a.this.aNB;
                        a.this.aND = a.this.mCurrentScale;
                        a.this.HP();
                        return true;
                    }
                    a.this.mCurrentScale = a.this.aNB * 2.0f;
                    a.this.d(true, (int) motionEvent.getX(), (int) motionEvent.getY());
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (a.this.aNJ != null && !a.this.aNM) {
                    a.this.aNJ.onClick(a.this);
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
                a.this.aNM = true;
                if (a.this.aNH == 0 && a.this.aNN) {
                    return false;
                }
                int scrollX = a.this.getScrollX();
                int scrollY = a.this.getScrollY();
                if (a.this.aNy >= a.this.getWidth()) {
                    scrollX = (int) (scrollX + f2);
                    if (a.this.aNH == 0) {
                        i = scrollX >= 0 ? scrollX : 0;
                        if (a.this.getWidth() + i > a.this.aNy) {
                            i = (int) (a.this.aNy - a.this.getWidth());
                        }
                        if (a.this.aNz + a.this.mTop + a.this.mBottom < a.this.getHeight()) {
                            i2 = (int) (scrollY + f3);
                            if (a.this.aNH == 0) {
                                if (i2 < (-a.this.aNR)) {
                                    i2 = -a.this.aNR;
                                }
                                if (a.this.getHeight() + i2 > a.this.aNz + a.this.mBottom + a.this.aNS) {
                                    i2 = (int) ((a.this.aNz - a.this.getHeight()) + a.this.mBottom + a.this.aNS);
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
                if (a.this.aNz + a.this.mTop + a.this.mBottom < a.this.getHeight()) {
                }
                if (i == a.this.getScrollX()) {
                }
                a.this.scrollTo(i, i2);
                a.this.invalidate();
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (a.this.avF != null && !a.this.aNM) {
                    a.this.avF.onLongClick(a.this);
                }
                super.onLongPress(motionEvent);
            }
        });
    }

    private void Bz() {
        if (this.aNZ == null) {
            if (this.ayA != null) {
                this.ayA.HV();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.aNZ.getSourceImageRectInScreen();
        if (sourceImageRectInScreen == null) {
            if (this.ayA != null) {
                this.ayA.HV();
                return;
            }
            return;
        }
        this.ayx.bottom = (((sourceImageRectInScreen.bottom - sourceImageRectInScreen.top) / (sourceImageRectInScreen.right - sourceImageRectInScreen.left)) * (this.ayx.right - this.ayx.left)) + this.ayx.top;
        final float[] fArr = {(this.ayx.left + this.ayx.right) / 2.0f, (this.ayx.top + this.ayx.bottom) / 2.0f};
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
                    a.this.ayx = a.this.e(floatValue, animatedFraction, sourceImageRectInScreen.right - sourceImageRectInScreen.left, sourceImageRectInScreen.bottom - sourceImageRectInScreen.top);
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
                a.this.ayt = false;
                a.this.mMode = 4;
                a.this.invalidate();
                if (a.this.ayA != null) {
                    a.this.ayA.HV();
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
        if (this.aNy >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.aNy) {
                scrollX = (int) (this.aNy - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.aNz + this.mTop + this.mBottom >= getHeight()) {
            i = scrollY < (-this.aNR) ? -this.aNR : scrollY;
            if (getHeight() + i > this.aNz + this.mBottom + this.aNS) {
                i = (int) ((this.aNz - getHeight()) + this.mBottom + this.aNS);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.aNY != null) {
            this.aNY.IG();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.aNy;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.aNz;
    }

    public boolean HJ() {
        if (this.aip == 1 || this.aip == 2) {
            return true;
        }
        return !this.aNN && getScrollX() >= ((int) (this.aNy - ((float) getWidth()))) + (-1);
    }

    public boolean HK() {
        if (this.aip == 1 || this.aip == 2) {
            return true;
        }
        return !this.aNN && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.aNK.HT()) {
            this.aNK.stopAnimation();
        }
        this.aNU = 0;
        super.setImageBitmap(bitmap);
        HE();
        this.aip = 0;
        if (this.ayw == null) {
            int measuredWidth = getMeasuredWidth();
            float measuredWidth2 = ((1.0f * getMeasuredWidth()) / bitmap.getWidth()) * bitmap.getHeight();
            if (measuredWidth2 > getMeasuredHeight()) {
                measuredWidth2 = getMeasuredHeight();
            }
            RectF e2 = e(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
            this.ayw = new Rect((int) e2.left, (int) e2.top, (int) e2.right, (int) e2.bottom);
        }
        if (this.aOb == null) {
            this.aOb = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
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
            if (this.aNK.HT()) {
                this.aNK.stopAnimation();
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            super.setImageBitmap(bitmap);
            super.setImageMatrix(this.mMatrix);
            scrollTo(scrollX, scrollY);
            this.aip = 0;
        }
    }

    public void a(byte[] bArr, Bitmap bitmap) {
        if (this.aNK.HT()) {
            this.aNK.stopAnimation();
        }
        super.setImageDrawable(null);
        stop();
        HE();
        this.aip = 1;
        this.aNQ = bitmap;
        this.aNF = bArr;
        if (this.avI != null) {
            this.avI.a(this);
        }
    }

    public void onDestroy() {
        if (this.aNK.HT()) {
            this.aNK.stopAnimation();
        }
        super.setImageDrawable(null);
        this.aNF = null;
        this.aNQ = null;
        stop();
        if (this.aNP != null) {
            this.aNP.close();
            this.aNP = null;
        }
        if (this.aNY != null) {
            this.aNY.release();
            System.gc();
        }
    }

    public void release() {
        if (this.aNK.HT()) {
            this.aNK.stopAnimation();
        }
        stop();
        super.setImageDrawable(null);
        this.aNQ = null;
    }

    public void HL() {
        if (this.aNK.HT()) {
            this.aNK.stopAnimation();
        }
        try {
            if (this.aNW) {
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
        this.aip = 2;
        HE();
    }

    public void HM() {
        if (this.aip != 1 && this.aip != 2) {
            int size = this.aNA.size();
            if (size > 0) {
                this.aNA.add(Float.valueOf(this.aNA.get(size - 1).floatValue() * 1.25f));
            } else {
                this.aNA.add(Float.valueOf(this.aNB));
            }
            HP();
        }
    }

    public void HN() {
        if (this.aip != 1 && this.aip != 2) {
            int size = this.aNA.size();
            if (size > 1) {
                this.aNA.remove(size - 1);
            }
            HP();
        }
    }

    public void HO() {
        HF();
        if (this.aip != 1 && this.aip != 2 && this.mCurrentScale != this.aNB) {
            this.aNA.clear();
            this.aNA.add(Float.valueOf(this.aNB));
            this.mCurrentScale = this.aNB;
            this.aND = this.mCurrentScale;
            HP();
        }
    }

    public boolean canZoomIn() {
        if (this.aip == 1 || this.aip == 2) {
            return false;
        }
        int size = this.aNA.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.aNA.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.aNG) && floatValue <= 5.0f;
    }

    public boolean canZoomOut() {
        if (this.aip == 1 || this.aip == 2) {
            return false;
        }
        int size = this.aNA.size();
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
                    int size = this.aNA.size();
                    if (size > 0) {
                        f3 = this.aNA.get(size - 1).floatValue();
                    } else {
                        f3 = this.aNB;
                    }
                    this.mCurrentScale = f3;
                }
                this.mMatrix.setScale(this.mCurrentScale, this.mCurrentScale);
                this.aNy = imageBitmap.getWidth() * this.mCurrentScale;
                this.aNz = imageBitmap.getHeight() * this.mCurrentScale;
                float width = this.aND * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.aND;
                this.aNR = this.mTop;
                this.aNS = 0;
                float f4 = this.aNy < ((float) this.mViewWidth) ? (int) ((this.mViewWidth - this.aNy) / 2.0f) : 0.0f;
                if (this.aNz < this.mViewHeight) {
                    f2 = (int) ((this.mViewHeight - this.aNz) / 2.0f);
                    if (this.aNH == 1 && f2 > this.mTop) {
                        f2 = this.mTop;
                    }
                    this.aNR = (int) (this.mTop - f2);
                    this.aNS = this.mTop - this.aNR;
                } else {
                    f2 = 0.0f;
                }
                this.aNT = (int) f4;
                this.mMatrix.postTranslate(f4, f2);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    int width2 = i > getWidth() ? getWidth() : i;
                    if (this.aNy <= screenWidth) {
                        width2 = 0;
                    } else if (this.aNy > screenWidth && this.aNy / 2.0f < screenWidth) {
                        width2 = (int) (width2 - (this.aNy / 4.0f));
                    }
                    scrollX = width2;
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.aNy - width) / 2.0f);
                    }
                    if (this.aNy <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.aNy) {
                        scrollX = (int) (this.aNy - getWidth());
                    }
                }
                if (scrollX > 0 && this.aNy - scrollX < getWidth()) {
                    scrollX = (int) (this.aNy - getWidth());
                }
                int i3 = this.mMode == 2 ? ((int) ((this.aNz - height) / 2.0f)) + scrollY : scrollY;
                if (this.aNz <= getHeight()) {
                    i3 = 0;
                } else if (getHeight() + i3 > this.aNz) {
                    i3 = (int) (this.aNz - getHeight());
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
    public class C0079a extends Animation {
        private boolean aOl = false;
        private boolean aOm = false;
        private long aOn;
        private long aOo;
        private int aOp;
        private long aOq;
        private long aOr;
        private int mStartY;

        public C0079a() {
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
            this.aOn = f;
            this.aOo = f2;
            this.aOq = Math.abs((f * 1000.0f) / 2500.0f);
            this.aOr = Math.abs((f2 * 1000.0f) / 2500.0f);
            setDuration(Math.max(this.aOq, this.aOr));
            setInterpolator(a.this.aOa);
            this.aOp = a.this.getScrollX();
            this.mStartY = a.this.getScrollY();
            this.aOl = true;
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
            if (this.aOq > this.aOr) {
                j = ((float) this.aOq) * f;
            } else {
                j = ((float) this.aOr) * f;
            }
            float f2 = ((float) (j > this.aOq ? this.aOq : j)) / 1000.0f;
            if (this.aOn > 0) {
                i = this.aOp - ((int) (f2 * (((float) this.aOn) - ((2500.0f * f2) / 2.0f))));
            } else {
                i = this.aOp - ((int) (f2 * (((float) this.aOn) + ((2500.0f * f2) / 2.0f))));
            }
            if (j > this.aOr) {
                j = this.aOr;
            }
            float f3 = ((float) j) / 1000.0f;
            if (this.aOo > 0) {
                i2 = this.mStartY - ((int) (f3 * (((float) this.aOo) - ((2500.0f * f3) / 2.0f))));
            } else {
                i2 = this.mStartY - ((int) (f3 * (((float) this.aOo) + ((2500.0f * f3) / 2.0f))));
            }
            if (a.this.aNz + a.this.mTop + a.this.mBottom > a.this.getHeight()) {
                if (i2 < (-a.this.aNR)) {
                    i2 = -a.this.aNR;
                }
                if (a.this.getHeight() + i2 > a.this.aNz + a.this.mBottom + a.this.aNS) {
                    i2 = (int) ((a.this.aNz - a.this.getHeight()) + a.this.mBottom + a.this.aNS);
                }
            } else {
                i2 = 0;
            }
            if (a.this.aNy > a.this.getWidth()) {
                int width = ((float) (a.this.getWidth() + i)) > a.this.aNy ? (int) (a.this.aNy - a.this.getWidth()) : i;
                if (width >= 0) {
                    i3 = width;
                }
            }
            a.this.scrollTo(i3, i2);
            a.this.invalidate();
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            if (!this.aOm) {
                if (a.this.aNE) {
                    this.aOl = false;
                    return false;
                }
                try {
                    if (super.getTransformation(j, transformation)) {
                        return true;
                    }
                    this.aOl = false;
                    return false;
                } catch (Exception e) {
                    this.aOl = false;
                    return false;
                }
            }
            this.aOm = false;
            this.aOl = false;
            return false;
        }

        public boolean HT() {
            return this.aOl;
        }

        public void stopAnimation() {
            this.aOm = true;
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.aNJ = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.avF = onLongClickListener;
        if (this.aNY != null) {
            this.aNY.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setGifSetListener(e eVar) {
        this.avI = eVar;
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
        c poll = this.aOe.poll();
        if (poll == null) {
            this.aOj = true;
            return;
        }
        this.aOj = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.aOd != null) {
            j = this.aOd.delay - (currentTimeMillis - this.aOi);
            this.aOf.offer(this.aOd);
        } else {
            j = 0;
        }
        this.aOd = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public c HR() {
        c poll = this.aOf.poll();
        if (poll == null) {
            poll = new c();
            try {
                poll.aOs = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
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
        return this.aOd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends Thread {
        private volatile boolean wy;

        private b() {
            this.wy = false;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (this.wy && a.this.aNP != null && a.this.aOc > 0 && a.this.width > 0 && a.this.height > 0) {
                try {
                    a.this.aNP.S(a.this.aOg);
                    c HR = a.this.HR();
                    if (HR.aOs == null || (HR.aOs.getWidth() != a.this.width && HR.aOs.getHeight() != a.this.height)) {
                        try {
                            HR.aOs = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_8888);
                        } catch (OutOfMemoryError e) {
                            TbadkCoreApplication.getInst().onAppMemoryLow();
                            try {
                                HR.aOs = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_4444);
                            } catch (OutOfMemoryError e2) {
                                TbadkCoreApplication.getInst().onAppMemoryLow();
                            } catch (Throwable th) {
                                BdLog.e(th.getMessage());
                            }
                        } catch (Throwable th2) {
                            BdLog.e(th2.getMessage());
                        }
                    }
                    a.this.aNP.a(HR.aOs, null);
                    HR.delay = a.this.aNP.T(a.this.aOg);
                    a.A(a.this);
                    if (HR.aOs == null) {
                        a.A(a.this);
                    }
                    a.this.aOg %= a.this.aOc;
                    a.this.aOe.put(HR);
                    if (a.this.aOj) {
                        a.this.mHandler.sendEmptyMessage(1);
                    }
                } catch (Exception e3) {
                    return;
                }
            }
        }
    }

    public boolean HS() {
        return this.aNV;
    }

    public void setLoadBigImage(boolean z) {
        this.aNV = z;
    }

    public int getBottomOffset() {
        return this.aNS;
    }

    public int getLeftOffset() {
        return this.aNT;
    }
}
