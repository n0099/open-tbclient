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
    private static final int aMJ = l.af(TbadkCoreApplication.getInst()) / 5;
    private float aLY;
    private float aLZ;
    private Interpolator aMA;
    private Matrix aMB;
    private boolean aMC;
    private float aMD;
    private float aME;
    private Rect aMF;
    private RectF aMG;
    private Rect aMH;
    private d aMI;
    private int aMK;
    private c aML;
    private BlockingLinkedDeque<c> aMM;
    private BlockingLinkedDeque<c> aMN;
    private volatile int aMO;
    private b aMP;
    private volatile long aMQ;
    private volatile boolean aMR;
    private ArrayList<Float> aMa;
    private float aMb;
    private float aMc;
    private float aMd;
    private boolean aMe;
    private byte[] aMf;
    private int aMg;
    private int aMh;
    private f aMi;
    private View.OnClickListener aMj;
    private C0065a aMk;
    private float aMl;
    private boolean aMm;
    private boolean aMn;
    private int aMo;
    private volatile com.baidu.adp.gif.b aMp;
    private Bitmap aMq;
    private int aMr;
    private int aMs;
    private int aMt;
    private int aMu;
    private boolean aMv;
    private boolean aMw;
    private float aMx;
    private com.baidu.tbadk.widget.a.b.b aMy;
    private ImageUrlData aMz;
    public int ahB;
    private View.OnLongClickListener auu;
    private e aux;
    private int auy;
    private int height;
    private int mBottom;
    private float mCurrentScale;
    private GestureDetector mGestureDetector;
    public Handler mHandler;
    private Matrix mMatrix;
    private int mMode;
    private Paint mPaint;
    private float mRatio;
    private volatile int mState;
    private int mTop;
    private int mViewHeight;
    private int mViewWidth;
    private int width;

    /* loaded from: classes.dex */
    public interface d {
        void Hp();
    }

    /* loaded from: classes.dex */
    public interface e {
        void a(a aVar);
    }

    /* loaded from: classes.dex */
    public interface f {
        void a(a aVar, boolean z, boolean z2);
    }

    static /* synthetic */ int C(a aVar) {
        int i = aVar.aMO;
        aVar.aMO = i + 1;
        return i;
    }

    public void setIsHeadImage(boolean z) {
        this.aMw = z;
    }

    public void setImageUrlData(ImageUrlData imageUrlData) {
        this.aMz = imageUrlData;
    }

    public a(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aMe = false;
        this.aMf = null;
        this.auy = 0;
        this.aMg = 1300;
        this.aMh = 0;
        this.aMi = null;
        this.aMj = null;
        this.auu = null;
        this.aux = null;
        this.aMl = 1.0f;
        this.ahB = 0;
        this.mMode = 0;
        this.aMm = false;
        this.aMn = false;
        this.aMo = 0;
        this.aMp = null;
        this.aMq = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aMr = 0;
        this.aMs = 0;
        this.aMt = 0;
        this.aMu = 0;
        this.aMA = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.aMB = new Matrix();
        this.aMC = false;
        this.aMD = 0.0f;
        this.mRatio = 1.0f;
        this.aME = 0.0f;
        this.aMG = new RectF();
        this.width = 0;
        this.height = 0;
        this.aMK = 0;
        this.aML = null;
        this.aMM = new BlockingLinkedDeque<>(5);
        this.aMN = new BlockingLinkedDeque<>(6);
        this.aMO = 0;
        this.aMQ = 0L;
        this.mState = 0;
        this.aMR = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.a.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        a.this.Hl();
                        break;
                    case 1:
                        if (a.this.aMR) {
                            a.this.Hl();
                            break;
                        }
                        break;
                    case 2:
                        a.this.invalidate();
                        a.this.aMQ = System.currentTimeMillis();
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
        this.aMe = false;
        this.aMf = null;
        this.auy = 0;
        this.aMg = 1300;
        this.aMh = 0;
        this.aMi = null;
        this.aMj = null;
        this.auu = null;
        this.aux = null;
        this.aMl = 1.0f;
        this.ahB = 0;
        this.mMode = 0;
        this.aMm = false;
        this.aMn = false;
        this.aMo = 0;
        this.aMp = null;
        this.aMq = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aMr = 0;
        this.aMs = 0;
        this.aMt = 0;
        this.aMu = 0;
        this.aMA = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.aMB = new Matrix();
        this.aMC = false;
        this.aMD = 0.0f;
        this.mRatio = 1.0f;
        this.aME = 0.0f;
        this.aMG = new RectF();
        this.width = 0;
        this.height = 0;
        this.aMK = 0;
        this.aML = null;
        this.aMM = new BlockingLinkedDeque<>(5);
        this.aMN = new BlockingLinkedDeque<>(6);
        this.aMO = 0;
        this.aMQ = 0L;
        this.mState = 0;
        this.aMR = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.a.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        a.this.Hl();
                        break;
                    case 1:
                        if (a.this.aMR) {
                            a.this.Hl();
                            break;
                        }
                        break;
                    case 2:
                        a.this.invalidate();
                        a.this.aMQ = System.currentTimeMillis();
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
        this.aMe = false;
        this.aMf = null;
        this.auy = 0;
        this.aMg = 1300;
        this.aMh = 0;
        this.aMi = null;
        this.aMj = null;
        this.auu = null;
        this.aux = null;
        this.aMl = 1.0f;
        this.ahB = 0;
        this.mMode = 0;
        this.aMm = false;
        this.aMn = false;
        this.aMo = 0;
        this.aMp = null;
        this.aMq = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aMr = 0;
        this.aMs = 0;
        this.aMt = 0;
        this.aMu = 0;
        this.aMA = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.aMB = new Matrix();
        this.aMC = false;
        this.aMD = 0.0f;
        this.mRatio = 1.0f;
        this.aME = 0.0f;
        this.aMG = new RectF();
        this.width = 0;
        this.height = 0;
        this.aMK = 0;
        this.aML = null;
        this.aMM = new BlockingLinkedDeque<>(5);
        this.aMN = new BlockingLinkedDeque<>(6);
        this.aMO = 0;
        this.aMQ = 0L;
        this.mState = 0;
        this.aMR = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.a.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        a.this.Hl();
                        break;
                    case 1:
                        if (a.this.aMR) {
                            a.this.Hl();
                            break;
                        }
                        break;
                    case 2:
                        a.this.invalidate();
                        a.this.aMQ = System.currentTimeMillis();
                        a.this.mHandler.sendEmptyMessage(0);
                        break;
                }
                return false;
            }
        });
        initData();
    }

    public void setDragToExitListener(d dVar) {
        this.aMI = dVar;
    }

    public int getImageType() {
        return this.ahB;
    }

    public void setImageMode(int i) {
        this.aMh = i;
    }

    public void i(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.auy = i;
    }

    public void GW() {
        this.aMn = false;
        this.aMe = false;
        this.mMode = 3;
        Hd();
        if (this.mCurrentScale < this.aMb) {
            this.mCurrentScale = this.aMb;
            Hk();
        }
        invalidate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.aMy != null && this.aMy.onTouchEvent(motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.aMe = true;
                this.aMm = false;
                this.aMn = false;
                break;
            case 1:
                GW();
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
            this.aMl = m(motionEvent);
            if (this.aMl > 10.0f) {
                this.mMode = 2;
            }
        }
        if (this.mMode == 2 || !this.mGestureDetector.onTouchEvent(motionEvent)) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.aMm = true;
                        this.aMn = true;
                        if (this.ahB != 1 && this.ahB != 2) {
                            float m = m(motionEvent);
                            if (m >= 0.0f && Math.abs(this.aMl - m) >= 10.0f) {
                                if (Math.abs(this.aMl - m) > 100.0f) {
                                    this.aMl = m;
                                    break;
                                } else {
                                    float f2 = m / this.aMl;
                                    this.aMl = m;
                                    this.aMd = this.mCurrentScale;
                                    this.mCurrentScale *= f2;
                                    if (this.mCurrentScale > this.aMc) {
                                        this.mCurrentScale = this.aMc;
                                    }
                                    float minScaleValue = getMinScaleValue();
                                    if (this.mCurrentScale < minScaleValue) {
                                        this.mCurrentScale = minScaleValue;
                                    }
                                    Hk();
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
        return this.aMy != null ? this.aMy.getMinScaleValue() : this.aMb / 4.0f;
    }

    public float m(MotionEvent motionEvent) {
        return CompatibleUtile.getInstance().getSpacing(motionEvent);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            this.mViewWidth = i3 - i;
            this.mViewHeight = i4 - i2;
            GY();
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public boolean GX() {
        return this.aMb == this.mCurrentScale;
    }

    protected float f(Bitmap bitmap) {
        if (this.aMy != null) {
            return this.aMy.HQ();
        }
        if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            return 1.0f;
        }
        if (this.aMh == 0) {
            float width = this.mViewWidth / bitmap.getWidth();
            float height = this.mViewHeight / bitmap.getHeight();
            if (this.aMw) {
                if (this.ahB == 2) {
                    return 2.5f;
                }
                return Math.min(width, height);
            } else if (this.ahB != 2) {
                float f2 = this.aMx;
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
        if (this.aMy != null) {
            return this.aMy.HR();
        }
        float f2 = 1.0f;
        if (bitmap != null && !bitmap.isRecycled() && bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
            f2 = FloatMath.sqrt(this.aMg / (bitmap.getWidth() * bitmap.getHeight()));
            if (f2 > 10.0f) {
                return 10.0f;
            }
        }
        return f2;
    }

    private void GY() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            this.aMb = f(imageBitmap);
            this.aMc = g(imageBitmap);
            this.aMa.clear();
            this.aMa.add(Float.valueOf(this.aMb));
            this.mCurrentScale = this.aMb;
            this.aMd = this.mCurrentScale;
            Hk();
            return;
        }
        this.aLY = 0.0f;
        this.aLZ = 0.0f;
        this.aMb = 1.0f;
        this.aMc = 1.0f;
        this.mCurrentScale = 1.0f;
        this.aMd = this.mCurrentScale;
        this.aMa.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    private void GZ() {
        if (this.aMi != null) {
            this.aMi.a(this, canZoomIn(), canZoomOut());
        }
    }

    public void setOnSizeChangedListener(f fVar) {
        this.aMi = fVar;
    }

    public byte[] getImageData() {
        return this.aMf;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getMeasuredHeight() != 0 && getMeasuredWidth() != 0 && this.aMy != null) {
            this.aMy.HP();
        }
    }

    public void a(Bitmap bitmap, byte[] bArr) {
        this.aMf = bArr;
        if (this.aMy != null) {
            this.aMy.b(bitmap, bArr);
        }
        setImageBitmap(bitmap);
    }

    public void Ha() {
        if (this.aMy == null) {
            this.aMy = new com.baidu.tbadk.widget.a.b.b(this);
            this.aMy.setOnClickListener(this.aMj);
            this.aMy.setOnLongClickListener(this.auu);
        }
    }

    public void setImageLoadCallBack(com.baidu.tbadk.widget.a.b.a aVar) {
        if (this.aMy != null) {
            this.aMy.a(aVar);
        }
    }

    public boolean Hb() {
        return (getImageBitmap() == null || this.aMy == null) ? false : true;
    }

    public Bitmap getGifCache() {
        return this.aMq;
    }

    public void setGifCache(Bitmap bitmap) {
        this.aMq = bitmap;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        boolean z;
        if (this.aMy == null || !this.aMy.h(canvas)) {
            if (this.ahB == 2 && this.aMu != 0 && !this.aMk.Ho()) {
                int width = getWidth();
                int height = getHeight();
                Drawable drawable = getDrawable();
                float f2 = 0.0f;
                float f3 = height * 0.3f;
                float f4 = width;
                float f5 = (1.0f - 0.3f) * height;
                if (this.aMw && drawable != null) {
                    Rect bounds = drawable.getBounds();
                    int i = bounds.right - bounds.left;
                    int i2 = bounds.bottom - bounds.top;
                    f2 = (width / 2) - (i * 2.5f);
                    f3 = (height / 2) - (i2 * 2.5f);
                    f4 = (i * 2.5f) + (width / 2);
                    f5 = (i2 * 2.5f) + (height / 2);
                }
                this.mPaint.setColor(aj.getColor(this.aMu));
                canvas.drawRect(f2, f3, f4, f5, this.mPaint);
                this.mPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
            }
            if (this.mMode == 3 && this.aMC) {
                this.aMC = false;
                this.aMB.reset();
                if (this.aME < aMJ) {
                    this.mMode = 0;
                } else {
                    this.mMode = 4;
                    Hc();
                }
            }
            if (this.ahB == 0 && this.aMC && this.aMF != null && this.aMz != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                if (this.aMG == null) {
                    this.aMG = new RectF();
                }
                this.aMB.mapRect(this.aMG, new RectF(this.aMF));
                Bitmap imageBitmap = getImageBitmap();
                if (imageBitmap != null && !imageBitmap.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.aMH, this.aMG, (Paint) null);
                }
            } else if (this.mMode == 4 && this.aMF != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                Bitmap imageBitmap2 = getImageBitmap();
                if (imageBitmap2 != null && !imageBitmap2.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.aMH, this.aMG, (Paint) null);
                }
            } else {
                super.onDraw(canvas);
            }
            if (this.ahB == 1 && this.aMq != null && !this.aMq.isRecycled()) {
                int width2 = this.aMq.getWidth();
                int height2 = this.aMq.getHeight();
                int width3 = getWidth();
                int height3 = getHeight();
                int i3 = (width3 - width2) >> 1;
                int i4 = (height3 - height2) >> 1;
                float f6 = this.aMx;
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
                if (this.aMo == 1 && this.aMp != null && this.aML != null && this.aML.aNc != null) {
                    if (z) {
                        canvas.drawBitmap(this.aML.aNc, i3, i4, (Paint) null);
                    } else {
                        canvas.drawBitmap(this.aML.aNc, this.mMatrix, this.mPaint);
                    }
                    invalidate();
                } else if (z) {
                    canvas.drawBitmap(this.aMq, i3, i4, (Paint) null);
                } else {
                    canvas.drawBitmap(this.aMq, this.mMatrix, this.mPaint);
                }
            }
        }
    }

    public void play() {
        com.baidu.adp.widget.ImageView.a aVar;
        if (this.ahB == 1) {
            if (this.aMp == null) {
                if (this.aMP != null) {
                    this.aMP.interrupt();
                    this.aMP = null;
                }
                if (this.aMf != null) {
                    try {
                        aVar = a.C0002a.dD().g(this.aMf, 0, this.aMf.length);
                    } catch (StackOverflowError e2) {
                        aVar = null;
                    }
                    if (aVar != null && aVar.getGif() != null) {
                        this.aMp = aVar.getGif();
                        if (this.aMp != null) {
                            this.aMo = 1;
                            this.width = this.aMp.getWidth();
                            this.height = this.aMp.getHeight();
                            this.aMO = 0;
                            this.aMK = this.aMp.getFrameCount();
                        } else {
                            this.aMo = 0;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            if (this.aMp != null && this.mState == 0) {
                this.aMR = true;
                this.aMP = new b();
                this.aMM.clear();
                this.aMN.clear();
                this.mState = 1;
                this.aMP.start();
            }
        }
    }

    public void pause() {
        if (this.ahB == 1) {
            this.mState = 0;
            if (this.aMP != null) {
                this.aMP.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.ahB == 1) {
            this.mState = 0;
            if (this.aMP != null) {
                this.aMP.interrupt();
                this.aMP = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.aMR = true;
            this.aML = null;
            this.aMN.clear();
            this.aMM.clear();
            this.width = 0;
            this.height = 0;
            this.aMO = 0;
            this.aMK = 0;
            if (this.aMp != null) {
                this.aMp = null;
            }
        }
    }

    private void initData() {
        this.aMx = l.ag(getContext());
        this.aMg = l.af(getContext()) * l.ad(getContext()) * 2;
        if (this.aMg < 1690000) {
            this.aMg = 1690000;
        }
        this.aLY = 0.0f;
        this.aLZ = 0.0f;
        this.aMa = new ArrayList<>();
        this.aMb = 1.0f;
        this.aMc = 1.0f;
        this.mCurrentScale = 1.0f;
        this.aMd = this.mCurrentScale;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.aMk = new C0065a();
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWillNotDraw(false);
        scrollTo(0, 0);
        this.mGestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.a.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                if (a.this.ahB != 2 && (Math.abs(f2) > 200.0f || Math.abs(f3) > 200.0f)) {
                    a.this.aMk.d(f2, f3);
                    a.this.startAnimation(a.this.aMk);
                }
                return super.onFling(motionEvent, motionEvent2, f2, f3);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (a.this.ahB != 1 && a.this.ahB != 2) {
                    a.this.mMode = 2;
                    if (a.this.mCurrentScale > a.this.aMb) {
                        a.this.mCurrentScale = a.this.aMb;
                        a.this.aMd = a.this.mCurrentScale;
                        a.this.Hk();
                        return true;
                    }
                    a.this.mCurrentScale = a.this.aMb * 2.0f;
                    a.this.d(true, (int) motionEvent.getX(), (int) motionEvent.getY());
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (a.this.aMj != null && !a.this.aMm) {
                    a.this.aMj.onClick(a.this);
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
                a.this.aMm = true;
                if (a.this.aMh == 0 && a.this.aMn) {
                    return false;
                }
                int scrollX = a.this.getScrollX();
                int scrollY = a.this.getScrollY();
                if (a.this.aLY >= a.this.getWidth()) {
                    scrollX = (int) (scrollX + f2);
                    if (a.this.aMh == 0) {
                        i = scrollX >= 0 ? scrollX : 0;
                        if (a.this.getWidth() + i > a.this.aLY) {
                            i = (int) (a.this.aLY - a.this.getWidth());
                        }
                        if (a.this.aLZ + a.this.mTop + a.this.mBottom < a.this.getHeight()) {
                            i2 = (int) (scrollY + f3);
                            if (a.this.aMh == 0) {
                                if (i2 < (-a.this.aMr)) {
                                    i2 = -a.this.aMr;
                                }
                                if (a.this.getHeight() + i2 > a.this.aLZ + a.this.mBottom + a.this.aMs) {
                                    i2 = (int) ((a.this.aLZ - a.this.getHeight()) + a.this.mBottom + a.this.aMs);
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
                if (a.this.aLZ + a.this.mTop + a.this.mBottom < a.this.getHeight()) {
                }
                if (i == a.this.getScrollX()) {
                }
                a.this.scrollTo(i, i2);
                a.this.invalidate();
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (a.this.auu != null && !a.this.aMm) {
                    a.this.auu.onLongClick(a.this);
                }
                super.onLongPress(motionEvent);
            }
        });
    }

    private void Hc() {
        if (this.aMz == null || this.aMz.mSourceImageRectInScreen == null) {
            if (this.aMI != null) {
                this.aMI.Hp();
                return;
            }
            return;
        }
        this.aMG.bottom = (((this.aMz.mSourceImageRectInScreen.bottom - this.aMz.mSourceImageRectInScreen.top) / (this.aMz.mSourceImageRectInScreen.right - this.aMz.mSourceImageRectInScreen.left)) * (this.aMG.right - this.aMG.left)) + this.aMG.top;
        final float[] fArr = {(this.aMG.left + this.aMG.right) / 2.0f, (this.aMG.top + this.aMG.bottom) / 2.0f};
        final float[] fArr2 = {(this.aMz.mSourceImageRectInScreen.left + this.aMz.mSourceImageRectInScreen.right) / 2, (this.aMz.mSourceImageRectInScreen.top + this.aMz.mSourceImageRectInScreen.bottom) / 2};
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr[0], fArr2[0]);
        ofFloat.setDuration(150L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.a.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    float animatedFraction = fArr[1] + ((fArr2[1] - fArr[1]) * valueAnimator.getAnimatedFraction());
                    a.this.aMG = a.this.e(floatValue, animatedFraction, a.this.aMz.mSourceImageRectInScreen.right - a.this.aMz.mSourceImageRectInScreen.left, a.this.aMz.mSourceImageRectInScreen.bottom - a.this.aMz.mSourceImageRectInScreen.top);
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
                a.this.aMC = false;
                a.this.mMode = 4;
                a.this.invalidate();
                if (a.this.aMI != null) {
                    a.this.aMI.Hp();
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

    private void Hd() {
        int i = 0;
        int scrollX = getScrollX();
        if (this.aLY >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.aLY) {
                scrollX = (int) (this.aLY - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.aLZ + this.mTop + this.mBottom >= getHeight()) {
            i = scrollY < (-this.aMr) ? -this.aMr : scrollY;
            if (getHeight() + i > this.aLZ + this.mBottom + this.aMs) {
                i = (int) ((this.aLZ - getHeight()) + this.mBottom + this.aMs);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.aMy != null) {
            this.aMy.HO();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.aLY;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.aLZ;
    }

    public boolean He() {
        if (this.ahB == 1 || this.ahB == 2) {
            return true;
        }
        return !this.aMn && getScrollX() >= ((int) (this.aLY - ((float) getWidth()))) + (-1);
    }

    public boolean Hf() {
        if (this.ahB == 1 || this.ahB == 2) {
            return true;
        }
        return !this.aMn && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.aMk.Ho()) {
            this.aMk.stopAnimation();
        }
        this.aMu = 0;
        super.setImageBitmap(bitmap);
        GY();
        this.ahB = 0;
        if (this.aMF == null) {
            int measuredWidth = getMeasuredWidth();
            float measuredWidth2 = ((1.0f * getMeasuredWidth()) / bitmap.getWidth()) * bitmap.getHeight();
            if (measuredWidth2 > getMeasuredHeight()) {
                measuredWidth2 = getMeasuredHeight();
            }
            RectF e2 = e(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
            this.aMF = new Rect((int) e2.left, (int) e2.top, (int) e2.right, (int) e2.bottom);
        }
        if (this.aMH == null) {
            this.aMH = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
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
            if (this.aMk.Ho()) {
                this.aMk.stopAnimation();
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            super.setImageBitmap(bitmap);
            super.setImageMatrix(this.mMatrix);
            scrollTo(scrollX, scrollY);
            this.ahB = 0;
        }
    }

    public void a(byte[] bArr, Bitmap bitmap) {
        if (this.aMk.Ho()) {
            this.aMk.stopAnimation();
        }
        super.setImageDrawable(null);
        stop();
        GY();
        this.ahB = 1;
        this.aMq = bitmap;
        this.aMf = bArr;
        if (this.aux != null) {
            this.aux.a(this);
        }
    }

    public void onDestroy() {
        if (this.aMk.Ho()) {
            this.aMk.stopAnimation();
        }
        super.setImageDrawable(null);
        this.aMf = null;
        this.aMq = null;
        stop();
        if (this.aMp != null) {
            this.aMp.close();
            this.aMp = null;
        }
        if (this.aMy != null) {
            this.aMy.release();
            System.gc();
        }
    }

    public void release() {
        if (this.aMk.Ho()) {
            this.aMk.stopAnimation();
        }
        stop();
        super.setImageDrawable(null);
        this.aMq = null;
    }

    public void Hg() {
        if (this.aMk.Ho()) {
            this.aMk.stopAnimation();
        }
        try {
            if (this.aMw) {
                super.setImageBitmap(BitmapHelper.getCashBitmap(d.g.icon_default_avatar100));
            } else {
                super.setImageBitmap(BitmapHelper.getCashBitmap(d.g.btn_see_default));
            }
        } catch (OutOfMemoryError e2) {
            TbadkCoreApplication.getInst().onAppMemoryLow();
            System.gc();
            super.setImageBitmap(null);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
        this.ahB = 2;
        GY();
    }

    public void Hh() {
        if (this.ahB != 1 && this.ahB != 2) {
            int size = this.aMa.size();
            if (size > 0) {
                this.aMa.add(Float.valueOf(this.aMa.get(size - 1).floatValue() * 1.25f));
            } else {
                this.aMa.add(Float.valueOf(this.aMb));
            }
            Hk();
        }
    }

    public void Hi() {
        if (this.ahB != 1 && this.ahB != 2) {
            int size = this.aMa.size();
            if (size > 1) {
                this.aMa.remove(size - 1);
            }
            Hk();
        }
    }

    public void Hj() {
        GZ();
        if (this.ahB != 1 && this.ahB != 2 && this.mCurrentScale != this.aMb) {
            this.aMa.clear();
            this.aMa.add(Float.valueOf(this.aMb));
            this.mCurrentScale = this.aMb;
            this.aMd = this.mCurrentScale;
            Hk();
        }
    }

    public boolean canZoomIn() {
        if (this.ahB == 1 || this.ahB == 2) {
            return false;
        }
        int size = this.aMa.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.aMa.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.aMg) && floatValue <= 5.0f;
    }

    public boolean canZoomOut() {
        if (this.ahB == 1 || this.ahB == 2) {
            return false;
        }
        int size = this.aMa.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled()) {
            return false;
        }
        return size > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hk() {
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
                    int size = this.aMa.size();
                    if (size > 0) {
                        f3 = this.aMa.get(size - 1).floatValue();
                    } else {
                        f3 = this.aMb;
                    }
                    this.mCurrentScale = f3;
                }
                this.mMatrix.setScale(this.mCurrentScale, this.mCurrentScale);
                this.aLY = imageBitmap.getWidth() * this.mCurrentScale;
                this.aLZ = imageBitmap.getHeight() * this.mCurrentScale;
                float width = this.aMd * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.aMd;
                this.aMr = this.mTop;
                this.aMs = 0;
                float f4 = this.aLY < ((float) this.mViewWidth) ? (int) ((this.mViewWidth - this.aLY) / 2.0f) : 0.0f;
                if (this.aLZ < this.mViewHeight) {
                    f2 = (int) ((this.mViewHeight - this.aLZ) / 2.0f);
                    if (this.aMh == 1 && f2 > this.mTop) {
                        f2 = this.mTop;
                    }
                    this.aMr = (int) (this.mTop - f2);
                    this.aMs = this.mTop - this.aMr;
                } else {
                    f2 = 0.0f;
                }
                this.aMt = (int) f4;
                this.mMatrix.postTranslate(f4, f2);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    int width2 = i > getWidth() ? getWidth() : i;
                    if (this.aLY <= screenWidth) {
                        width2 = 0;
                    } else if (this.aLY > screenWidth && this.aLY / 2.0f < screenWidth) {
                        width2 = (int) (width2 - (this.aLY / 4.0f));
                    }
                    scrollX = width2;
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.aLY - width) / 2.0f);
                    }
                    if (this.aLY <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.aLY) {
                        scrollX = (int) (this.aLY - getWidth());
                    }
                }
                if (scrollX > 0 && this.aLY - scrollX < getWidth()) {
                    scrollX = (int) (this.aLY - getWidth());
                }
                int i3 = this.mMode == 2 ? ((int) ((this.aLZ - height) / 2.0f)) + scrollY : scrollY;
                if (this.aLZ <= getHeight()) {
                    i3 = 0;
                } else if (getHeight() + i3 > this.aLZ) {
                    i3 = (int) (this.aLZ - getHeight());
                }
                setHorizontalScrollBarEnabled(false);
                setVerticalScrollBarEnabled(false);
                if (scrollX < 0) {
                    scrollX = 0;
                }
                scrollTo(scrollX, i3 >= 0 ? i3 : 0);
                setImageMatrix(this.mMatrix);
                GZ();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0065a extends Animation {
        private boolean aMV = false;
        private boolean aMW = false;
        private long aMX;
        private long aMY;
        private int aMZ;
        private long aNa;
        private long aNb;
        private int mStartY;

        public C0065a() {
        }

        public void d(float f, float f2) {
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
            this.aMX = f;
            this.aMY = f2;
            this.aNa = Math.abs((f * 1000.0f) / 2500.0f);
            this.aNb = Math.abs((f2 * 1000.0f) / 2500.0f);
            setDuration(Math.max(this.aNa, this.aNb));
            setInterpolator(a.this.aMA);
            this.aMZ = a.this.getScrollX();
            this.mStartY = a.this.getScrollY();
            this.aMV = true;
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
            if (this.aNa > this.aNb) {
                j = ((float) this.aNa) * f;
            } else {
                j = ((float) this.aNb) * f;
            }
            float f2 = ((float) (j > this.aNa ? this.aNa : j)) / 1000.0f;
            if (this.aMX > 0) {
                i = this.aMZ - ((int) (f2 * (((float) this.aMX) - ((2500.0f * f2) / 2.0f))));
            } else {
                i = this.aMZ - ((int) (f2 * (((float) this.aMX) + ((2500.0f * f2) / 2.0f))));
            }
            if (j > this.aNb) {
                j = this.aNb;
            }
            float f3 = ((float) j) / 1000.0f;
            if (this.aMY > 0) {
                i2 = this.mStartY - ((int) (f3 * (((float) this.aMY) - ((2500.0f * f3) / 2.0f))));
            } else {
                i2 = this.mStartY - ((int) (f3 * (((float) this.aMY) + ((2500.0f * f3) / 2.0f))));
            }
            if (a.this.aLZ + a.this.mTop + a.this.mBottom > a.this.getHeight()) {
                if (i2 < (-a.this.aMr)) {
                    i2 = -a.this.aMr;
                }
                if (a.this.getHeight() + i2 > a.this.aLZ + a.this.mBottom + a.this.aMs) {
                    i2 = (int) ((a.this.aLZ - a.this.getHeight()) + a.this.mBottom + a.this.aMs);
                }
            } else {
                i2 = 0;
            }
            if (a.this.aLY > a.this.getWidth()) {
                int width = ((float) (a.this.getWidth() + i)) > a.this.aLY ? (int) (a.this.aLY - a.this.getWidth()) : i;
                if (width >= 0) {
                    i3 = width;
                }
            }
            a.this.scrollTo(i3, i2);
            a.this.invalidate();
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            if (!this.aMW) {
                if (a.this.aMe) {
                    this.aMV = false;
                    return false;
                }
                try {
                    if (super.getTransformation(j, transformation)) {
                        return true;
                    }
                    this.aMV = false;
                    return false;
                } catch (Exception e) {
                    this.aMV = false;
                    return false;
                }
            }
            this.aMW = false;
            this.aMV = false;
            return false;
        }

        public boolean Ho() {
            return this.aMV;
        }

        public void stopAnimation() {
            this.aMW = true;
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.aMj = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.auu = onLongClickListener;
    }

    public void setGifSetListener(e eVar) {
        this.aux = eVar;
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
    public void Hl() {
        long j;
        c poll = this.aMM.poll();
        if (poll == null) {
            this.aMR = true;
            return;
        }
        this.aMR = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.aML != null) {
            j = this.aML.delay - (currentTimeMillis - this.aMQ);
            this.aMN.offer(this.aML);
        } else {
            j = 0;
        }
        this.aML = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public c Hm() {
        c poll = this.aMN.poll();
        if (poll == null) {
            poll = new c();
            try {
                poll.aNc = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
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

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        public Bitmap aNc;
        public int delay;

        private c() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends Thread {
        private b() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (a.this.mState == 1 && a.this.aMp != null && a.this.aMK > 0 && a.this.width > 0 && a.this.height > 0) {
                try {
                    a.this.aMp.T(a.this.aMO);
                    c Hm = a.this.Hm();
                    if (Hm.aNc == null || (Hm.aNc.getWidth() != a.this.width && Hm.aNc.getHeight() != a.this.height)) {
                        try {
                            Hm.aNc = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_8888);
                        } catch (OutOfMemoryError e) {
                            TbadkCoreApplication.getInst().onAppMemoryLow();
                            try {
                                Hm.aNc = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_4444);
                            } catch (OutOfMemoryError e2) {
                                TbadkCoreApplication.getInst().onAppMemoryLow();
                            }
                        } catch (Throwable th) {
                            BdLog.e(th.getMessage());
                        }
                    }
                    a.this.aMp.a(Hm.aNc, null);
                    Hm.delay = a.this.aMp.U(a.this.aMO);
                    a.C(a.this);
                    if (Hm.aNc == null) {
                        a.C(a.this);
                    }
                    a.this.aMO %= a.this.aMK;
                    a.this.aMM.put(Hm);
                    if (a.this.aMR) {
                        a.this.mHandler.sendEmptyMessage(1);
                    }
                } catch (Exception e3) {
                    return;
                }
            }
        }
    }

    public boolean Hn() {
        return this.aMv;
    }

    public void setLoadBigImage(boolean z) {
        this.aMv = z;
    }

    public int getBottomOffset() {
        return this.aMs;
    }

    public int getLeftOffset() {
        return this.aMt;
    }
}
