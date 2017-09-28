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
    private static final int aMW = l.af(TbadkCoreApplication.getInst()) / 5;
    private boolean aMA;
    private int aMB;
    private volatile com.baidu.adp.gif.b aMC;
    private Bitmap aMD;
    private int aME;
    private int aMF;
    private int aMG;
    private int aMH;
    private boolean aMI;
    private boolean aMJ;
    private float aMK;
    private com.baidu.tbadk.widget.a.b.b aML;
    private ImageUrlData aMM;
    private Interpolator aMN;
    private Matrix aMO;
    private boolean aMP;
    private float aMQ;
    private float aMR;
    private Rect aMS;
    private RectF aMT;
    private Rect aMU;
    private d aMV;
    private int aMX;
    private c aMY;
    private BlockingLinkedDeque<c> aMZ;
    private float aMl;
    private float aMm;
    private ArrayList<Float> aMn;
    private float aMo;
    private float aMp;
    private float aMq;
    private boolean aMr;
    private byte[] aMs;
    private int aMt;
    private int aMu;
    private f aMv;
    private View.OnClickListener aMw;
    private C0065a aMx;
    private float aMy;
    private boolean aMz;
    private BlockingLinkedDeque<c> aNa;
    private volatile int aNb;
    private b aNc;
    private volatile long aNd;
    private volatile boolean aNe;
    public int ahN;
    private View.OnLongClickListener auG;
    private e auJ;
    private int auK;
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
        void Hv();
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
        int i = aVar.aNb;
        aVar.aNb = i + 1;
        return i;
    }

    public void setIsHeadImage(boolean z) {
        this.aMJ = z;
    }

    public void setImageUrlData(ImageUrlData imageUrlData) {
        this.aMM = imageUrlData;
    }

    public a(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aMr = false;
        this.aMs = null;
        this.auK = 0;
        this.aMt = 1300;
        this.aMu = 0;
        this.aMv = null;
        this.aMw = null;
        this.auG = null;
        this.auJ = null;
        this.aMy = 1.0f;
        this.ahN = 0;
        this.mMode = 0;
        this.aMz = false;
        this.aMA = false;
        this.aMB = 0;
        this.aMC = null;
        this.aMD = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aME = 0;
        this.aMF = 0;
        this.aMG = 0;
        this.aMH = 0;
        this.aMN = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.aMO = new Matrix();
        this.aMP = false;
        this.aMQ = 0.0f;
        this.mRatio = 1.0f;
        this.aMR = 0.0f;
        this.aMT = new RectF();
        this.width = 0;
        this.height = 0;
        this.aMX = 0;
        this.aMY = null;
        this.aMZ = new BlockingLinkedDeque<>(5);
        this.aNa = new BlockingLinkedDeque<>(6);
        this.aNb = 0;
        this.aNd = 0L;
        this.mState = 0;
        this.aNe = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.a.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        a.this.Hr();
                        break;
                    case 1:
                        if (a.this.aNe) {
                            a.this.Hr();
                            break;
                        }
                        break;
                    case 2:
                        a.this.invalidate();
                        a.this.aNd = System.currentTimeMillis();
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
        this.aMr = false;
        this.aMs = null;
        this.auK = 0;
        this.aMt = 1300;
        this.aMu = 0;
        this.aMv = null;
        this.aMw = null;
        this.auG = null;
        this.auJ = null;
        this.aMy = 1.0f;
        this.ahN = 0;
        this.mMode = 0;
        this.aMz = false;
        this.aMA = false;
        this.aMB = 0;
        this.aMC = null;
        this.aMD = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aME = 0;
        this.aMF = 0;
        this.aMG = 0;
        this.aMH = 0;
        this.aMN = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.aMO = new Matrix();
        this.aMP = false;
        this.aMQ = 0.0f;
        this.mRatio = 1.0f;
        this.aMR = 0.0f;
        this.aMT = new RectF();
        this.width = 0;
        this.height = 0;
        this.aMX = 0;
        this.aMY = null;
        this.aMZ = new BlockingLinkedDeque<>(5);
        this.aNa = new BlockingLinkedDeque<>(6);
        this.aNb = 0;
        this.aNd = 0L;
        this.mState = 0;
        this.aNe = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.a.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        a.this.Hr();
                        break;
                    case 1:
                        if (a.this.aNe) {
                            a.this.Hr();
                            break;
                        }
                        break;
                    case 2:
                        a.this.invalidate();
                        a.this.aNd = System.currentTimeMillis();
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
        this.aMr = false;
        this.aMs = null;
        this.auK = 0;
        this.aMt = 1300;
        this.aMu = 0;
        this.aMv = null;
        this.aMw = null;
        this.auG = null;
        this.auJ = null;
        this.aMy = 1.0f;
        this.ahN = 0;
        this.mMode = 0;
        this.aMz = false;
        this.aMA = false;
        this.aMB = 0;
        this.aMC = null;
        this.aMD = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aME = 0;
        this.aMF = 0;
        this.aMG = 0;
        this.aMH = 0;
        this.aMN = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.aMO = new Matrix();
        this.aMP = false;
        this.aMQ = 0.0f;
        this.mRatio = 1.0f;
        this.aMR = 0.0f;
        this.aMT = new RectF();
        this.width = 0;
        this.height = 0;
        this.aMX = 0;
        this.aMY = null;
        this.aMZ = new BlockingLinkedDeque<>(5);
        this.aNa = new BlockingLinkedDeque<>(6);
        this.aNb = 0;
        this.aNd = 0L;
        this.mState = 0;
        this.aNe = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.a.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        a.this.Hr();
                        break;
                    case 1:
                        if (a.this.aNe) {
                            a.this.Hr();
                            break;
                        }
                        break;
                    case 2:
                        a.this.invalidate();
                        a.this.aNd = System.currentTimeMillis();
                        a.this.mHandler.sendEmptyMessage(0);
                        break;
                }
                return false;
            }
        });
        initData();
    }

    public void setDragToExitListener(d dVar) {
        this.aMV = dVar;
    }

    public int getImageType() {
        return this.ahN;
    }

    public void setImageMode(int i) {
        this.aMu = i;
    }

    public void i(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.auK = i;
    }

    public void Hc() {
        this.aMA = false;
        this.aMr = false;
        this.mMode = 3;
        Hj();
        if (this.mCurrentScale < this.aMo) {
            this.mCurrentScale = this.aMo;
            Hq();
        }
        invalidate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.aML != null && this.aML.onTouchEvent(motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.aMr = true;
                this.aMz = false;
                this.aMA = false;
                break;
            case 1:
                Hc();
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
            this.aMy = m(motionEvent);
            if (this.aMy > 10.0f) {
                this.mMode = 2;
            }
        }
        if (this.mMode == 2 || !this.mGestureDetector.onTouchEvent(motionEvent)) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.aMz = true;
                        this.aMA = true;
                        if (this.ahN != 1 && this.ahN != 2) {
                            float m = m(motionEvent);
                            if (m >= 0.0f && Math.abs(this.aMy - m) >= 10.0f) {
                                if (Math.abs(this.aMy - m) > 100.0f) {
                                    this.aMy = m;
                                    break;
                                } else {
                                    float f2 = m / this.aMy;
                                    this.aMy = m;
                                    this.aMq = this.mCurrentScale;
                                    this.mCurrentScale *= f2;
                                    if (this.mCurrentScale > this.aMp) {
                                        this.mCurrentScale = this.aMp;
                                    }
                                    float minScaleValue = getMinScaleValue();
                                    if (this.mCurrentScale < minScaleValue) {
                                        this.mCurrentScale = minScaleValue;
                                    }
                                    Hq();
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
        return this.aML != null ? this.aML.getMinScaleValue() : this.aMo / 4.0f;
    }

    public float m(MotionEvent motionEvent) {
        return CompatibleUtile.getInstance().getSpacing(motionEvent);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            this.mViewWidth = i3 - i;
            this.mViewHeight = i4 - i2;
            He();
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public boolean Hd() {
        return this.aMo == this.mCurrentScale;
    }

    protected float f(Bitmap bitmap) {
        if (this.aML != null) {
            return this.aML.HW();
        }
        if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            return 1.0f;
        }
        if (this.aMu == 0) {
            float width = this.mViewWidth / bitmap.getWidth();
            float height = this.mViewHeight / bitmap.getHeight();
            if (this.aMJ) {
                if (this.ahN == 2) {
                    return 2.5f;
                }
                return Math.min(width, height);
            } else if (this.ahN != 2) {
                float f2 = this.aMK;
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
        if (this.aML != null) {
            return this.aML.HX();
        }
        float f2 = 1.0f;
        if (bitmap != null && !bitmap.isRecycled() && bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
            f2 = FloatMath.sqrt(this.aMt / (bitmap.getWidth() * bitmap.getHeight()));
            if (f2 > 10.0f) {
                return 10.0f;
            }
        }
        return f2;
    }

    private void He() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            this.aMo = f(imageBitmap);
            this.aMp = g(imageBitmap);
            this.aMn.clear();
            this.aMn.add(Float.valueOf(this.aMo));
            this.mCurrentScale = this.aMo;
            this.aMq = this.mCurrentScale;
            Hq();
            return;
        }
        this.aMl = 0.0f;
        this.aMm = 0.0f;
        this.aMo = 1.0f;
        this.aMp = 1.0f;
        this.mCurrentScale = 1.0f;
        this.aMq = this.mCurrentScale;
        this.aMn.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    private void Hf() {
        if (this.aMv != null) {
            this.aMv.a(this, canZoomIn(), canZoomOut());
        }
    }

    public void setOnSizeChangedListener(f fVar) {
        this.aMv = fVar;
    }

    public byte[] getImageData() {
        return this.aMs;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getMeasuredHeight() != 0 && getMeasuredWidth() != 0 && this.aML != null) {
            this.aML.HV();
        }
    }

    public void a(Bitmap bitmap, byte[] bArr) {
        this.aMs = bArr;
        if (this.aML != null) {
            this.aML.b(bitmap, bArr);
        }
        setImageBitmap(bitmap);
    }

    public void Hg() {
        if (this.aML == null) {
            this.aML = new com.baidu.tbadk.widget.a.b.b(this);
            this.aML.setOnClickListener(this.aMw);
            this.aML.setOnLongClickListener(this.auG);
        }
    }

    public void setImageLoadCallBack(com.baidu.tbadk.widget.a.b.a aVar) {
        if (this.aML != null) {
            this.aML.a(aVar);
        }
    }

    public boolean Hh() {
        return (getImageBitmap() == null || this.aML == null) ? false : true;
    }

    public Bitmap getGifCache() {
        return this.aMD;
    }

    public void setGifCache(Bitmap bitmap) {
        this.aMD = bitmap;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        boolean z;
        if (this.aML == null || !this.aML.h(canvas)) {
            if (this.ahN == 2 && this.aMH != 0 && !this.aMx.Hu()) {
                int width = getWidth();
                int height = getHeight();
                Drawable drawable = getDrawable();
                float f2 = 0.0f;
                float f3 = height * 0.3f;
                float f4 = width;
                float f5 = (1.0f - 0.3f) * height;
                if (this.aMJ && drawable != null) {
                    Rect bounds = drawable.getBounds();
                    int i = bounds.right - bounds.left;
                    int i2 = bounds.bottom - bounds.top;
                    f2 = (width / 2) - (i * 2.5f);
                    f3 = (height / 2) - (i2 * 2.5f);
                    f4 = (i * 2.5f) + (width / 2);
                    f5 = (i2 * 2.5f) + (height / 2);
                }
                this.mPaint.setColor(aj.getColor(this.aMH));
                canvas.drawRect(f2, f3, f4, f5, this.mPaint);
                this.mPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
            }
            if (this.mMode == 3 && this.aMP) {
                this.aMP = false;
                this.aMO.reset();
                if (this.aMR < aMW) {
                    this.mMode = 0;
                } else {
                    this.mMode = 4;
                    Hi();
                }
            }
            if (this.ahN == 0 && this.aMP && this.aMS != null && this.aMM != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                if (this.aMT == null) {
                    this.aMT = new RectF();
                }
                this.aMO.mapRect(this.aMT, new RectF(this.aMS));
                canvas.drawBitmap(getImageBitmap(), this.aMU, this.aMT, (Paint) null);
            } else if (this.mMode == 4 && this.aMS != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                canvas.drawBitmap(getImageBitmap(), this.aMU, this.aMT, (Paint) null);
            } else {
                super.onDraw(canvas);
            }
            if (this.ahN == 1 && this.aMD != null && !this.aMD.isRecycled()) {
                int width2 = this.aMD.getWidth();
                int height2 = this.aMD.getHeight();
                int width3 = getWidth();
                int height3 = getHeight();
                int i3 = (width3 - width2) >> 1;
                int i4 = (height3 - height2) >> 1;
                float f6 = this.aMK;
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
                if (this.aMB == 1 && this.aMC != null && this.aMY != null && this.aMY.aNp != null) {
                    if (z) {
                        canvas.drawBitmap(this.aMY.aNp, i3, i4, (Paint) null);
                    } else {
                        canvas.drawBitmap(this.aMY.aNp, this.mMatrix, this.mPaint);
                    }
                    invalidate();
                } else if (z) {
                    canvas.drawBitmap(this.aMD, i3, i4, (Paint) null);
                } else {
                    canvas.drawBitmap(this.aMD, this.mMatrix, this.mPaint);
                }
            }
        }
    }

    public void play() {
        com.baidu.adp.widget.ImageView.a aVar;
        if (this.ahN == 1) {
            if (this.aMC == null) {
                if (this.aNc != null) {
                    this.aNc.interrupt();
                    this.aNc = null;
                }
                if (this.aMs != null) {
                    try {
                        aVar = a.C0002a.dD().g(this.aMs, 0, this.aMs.length);
                    } catch (StackOverflowError e2) {
                        aVar = null;
                    }
                    if (aVar != null && aVar.getGif() != null) {
                        this.aMC = aVar.getGif();
                        if (this.aMC != null) {
                            this.aMB = 1;
                            this.width = this.aMC.getWidth();
                            this.height = this.aMC.getHeight();
                            this.aNb = 0;
                            this.aMX = this.aMC.getFrameCount();
                        } else {
                            this.aMB = 0;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            if (this.aMC != null && this.mState == 0) {
                this.aNe = true;
                this.aNc = new b();
                this.aMZ.clear();
                this.aNa.clear();
                this.mState = 1;
                this.aNc.start();
            }
        }
    }

    public void pause() {
        if (this.ahN == 1) {
            this.mState = 0;
            if (this.aNc != null) {
                this.aNc.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.ahN == 1) {
            this.mState = 0;
            if (this.aNc != null) {
                this.aNc.interrupt();
                this.aNc = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.aNe = true;
            this.aMY = null;
            this.aNa.clear();
            this.aMZ.clear();
            this.width = 0;
            this.height = 0;
            this.aNb = 0;
            this.aMX = 0;
            if (this.aMC != null) {
                this.aMC = null;
            }
        }
    }

    private void initData() {
        this.aMK = l.ag(getContext());
        this.aMt = l.af(getContext()) * l.ad(getContext()) * 2;
        if (this.aMt < 1690000) {
            this.aMt = 1690000;
        }
        this.aMl = 0.0f;
        this.aMm = 0.0f;
        this.aMn = new ArrayList<>();
        this.aMo = 1.0f;
        this.aMp = 1.0f;
        this.mCurrentScale = 1.0f;
        this.aMq = this.mCurrentScale;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.aMx = new C0065a();
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWillNotDraw(false);
        scrollTo(0, 0);
        this.mGestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.a.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                if (a.this.ahN != 2 && (Math.abs(f2) > 200.0f || Math.abs(f3) > 200.0f)) {
                    a.this.aMx.d(f2, f3);
                    a.this.startAnimation(a.this.aMx);
                }
                return super.onFling(motionEvent, motionEvent2, f2, f3);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (a.this.ahN != 1 && a.this.ahN != 2) {
                    a.this.mMode = 2;
                    if (a.this.mCurrentScale > a.this.aMo) {
                        a.this.mCurrentScale = a.this.aMo;
                        a.this.aMq = a.this.mCurrentScale;
                        a.this.Hq();
                        return true;
                    }
                    a.this.mCurrentScale = a.this.aMo * 2.0f;
                    a.this.d(true, (int) motionEvent.getX(), (int) motionEvent.getY());
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (a.this.aMw != null && !a.this.aMz) {
                    a.this.aMw.onClick(a.this);
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
                a.this.aMz = true;
                if (a.this.aMu == 0 && a.this.aMA) {
                    return false;
                }
                int scrollX = a.this.getScrollX();
                int scrollY = a.this.getScrollY();
                if (a.this.aMl >= a.this.getWidth()) {
                    scrollX = (int) (scrollX + f2);
                    if (a.this.aMu == 0) {
                        i = scrollX >= 0 ? scrollX : 0;
                        if (a.this.getWidth() + i > a.this.aMl) {
                            i = (int) (a.this.aMl - a.this.getWidth());
                        }
                        if (a.this.aMm + a.this.mTop + a.this.mBottom < a.this.getHeight()) {
                            i2 = (int) (scrollY + f3);
                            if (a.this.aMu == 0) {
                                if (i2 < (-a.this.aME)) {
                                    i2 = -a.this.aME;
                                }
                                if (a.this.getHeight() + i2 > a.this.aMm + a.this.mBottom + a.this.aMF) {
                                    i2 = (int) ((a.this.aMm - a.this.getHeight()) + a.this.mBottom + a.this.aMF);
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
                if (a.this.aMm + a.this.mTop + a.this.mBottom < a.this.getHeight()) {
                }
                if (i == a.this.getScrollX()) {
                }
                a.this.scrollTo(i, i2);
                a.this.invalidate();
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (a.this.auG != null && !a.this.aMz) {
                    a.this.auG.onLongClick(a.this);
                }
                super.onLongPress(motionEvent);
            }
        });
    }

    private void Hi() {
        if (this.aMM == null || this.aMM.mSourceImageRectInScreen == null) {
            if (this.aMV != null) {
                this.aMV.Hv();
                return;
            }
            return;
        }
        this.aMT.bottom = (((this.aMM.mSourceImageRectInScreen.bottom - this.aMM.mSourceImageRectInScreen.top) / (this.aMM.mSourceImageRectInScreen.right - this.aMM.mSourceImageRectInScreen.left)) * (this.aMT.right - this.aMT.left)) + this.aMT.top;
        final float[] fArr = {(this.aMT.left + this.aMT.right) / 2.0f, (this.aMT.top + this.aMT.bottom) / 2.0f};
        final float[] fArr2 = {(this.aMM.mSourceImageRectInScreen.left + this.aMM.mSourceImageRectInScreen.right) / 2, (this.aMM.mSourceImageRectInScreen.top + this.aMM.mSourceImageRectInScreen.bottom) / 2};
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr[0], fArr2[0]);
        ofFloat.setDuration(150L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.a.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    float animatedFraction = fArr[1] + ((fArr2[1] - fArr[1]) * valueAnimator.getAnimatedFraction());
                    a.this.aMT = a.this.e(floatValue, animatedFraction, a.this.aMM.mSourceImageRectInScreen.right - a.this.aMM.mSourceImageRectInScreen.left, a.this.aMM.mSourceImageRectInScreen.bottom - a.this.aMM.mSourceImageRectInScreen.top);
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
                a.this.aMP = false;
                a.this.mMode = 4;
                a.this.invalidate();
                if (a.this.aMV != null) {
                    a.this.aMV.Hv();
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

    private void Hj() {
        int i = 0;
        int scrollX = getScrollX();
        if (this.aMl >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.aMl) {
                scrollX = (int) (this.aMl - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.aMm + this.mTop + this.mBottom >= getHeight()) {
            i = scrollY < (-this.aME) ? -this.aME : scrollY;
            if (getHeight() + i > this.aMm + this.mBottom + this.aMF) {
                i = (int) ((this.aMm - getHeight()) + this.mBottom + this.aMF);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.aML != null) {
            this.aML.HU();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.aMl;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.aMm;
    }

    public boolean Hk() {
        if (this.ahN == 1 || this.ahN == 2) {
            return true;
        }
        return !this.aMA && getScrollX() >= ((int) (this.aMl - ((float) getWidth()))) + (-1);
    }

    public boolean Hl() {
        if (this.ahN == 1 || this.ahN == 2) {
            return true;
        }
        return !this.aMA && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.aMx.Hu()) {
            this.aMx.stopAnimation();
        }
        this.aMH = 0;
        super.setImageBitmap(bitmap);
        He();
        this.ahN = 0;
        if (this.aMS == null) {
            int measuredWidth = getMeasuredWidth();
            float measuredWidth2 = ((1.0f * getMeasuredWidth()) / bitmap.getWidth()) * bitmap.getHeight();
            if (measuredWidth2 > getMeasuredHeight()) {
                measuredWidth2 = getMeasuredHeight();
            }
            RectF e2 = e(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
            this.aMS = new Rect((int) e2.left, (int) e2.top, (int) e2.right, (int) e2.bottom);
        }
        if (this.aMU == null) {
            this.aMU = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
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
            if (this.aMx.Hu()) {
                this.aMx.stopAnimation();
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            super.setImageBitmap(bitmap);
            super.setImageMatrix(this.mMatrix);
            scrollTo(scrollX, scrollY);
            this.ahN = 0;
        }
    }

    public void a(byte[] bArr, Bitmap bitmap) {
        if (this.aMx.Hu()) {
            this.aMx.stopAnimation();
        }
        super.setImageDrawable(null);
        stop();
        He();
        this.ahN = 1;
        this.aMD = bitmap;
        this.aMs = bArr;
        if (this.auJ != null) {
            this.auJ.a(this);
        }
    }

    public void onDestroy() {
        if (this.aMx.Hu()) {
            this.aMx.stopAnimation();
        }
        super.setImageDrawable(null);
        this.aMs = null;
        this.aMD = null;
        stop();
        if (this.aMC != null) {
            this.aMC.close();
            this.aMC = null;
        }
        if (this.aML != null) {
            this.aML.release();
            System.gc();
        }
    }

    public void release() {
        if (this.aMx.Hu()) {
            this.aMx.stopAnimation();
        }
        stop();
        super.setImageDrawable(null);
        this.aMD = null;
    }

    public void Hm() {
        if (this.aMx.Hu()) {
            this.aMx.stopAnimation();
        }
        try {
            if (this.aMJ) {
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
        this.ahN = 2;
        He();
    }

    public void Hn() {
        if (this.ahN != 1 && this.ahN != 2) {
            int size = this.aMn.size();
            if (size > 0) {
                this.aMn.add(Float.valueOf(this.aMn.get(size - 1).floatValue() * 1.25f));
            } else {
                this.aMn.add(Float.valueOf(this.aMo));
            }
            Hq();
        }
    }

    public void Ho() {
        if (this.ahN != 1 && this.ahN != 2) {
            int size = this.aMn.size();
            if (size > 1) {
                this.aMn.remove(size - 1);
            }
            Hq();
        }
    }

    public void Hp() {
        Hf();
        if (this.ahN != 1 && this.ahN != 2 && this.mCurrentScale != this.aMo) {
            this.aMn.clear();
            this.aMn.add(Float.valueOf(this.aMo));
            this.mCurrentScale = this.aMo;
            this.aMq = this.mCurrentScale;
            Hq();
        }
    }

    public boolean canZoomIn() {
        if (this.ahN == 1 || this.ahN == 2) {
            return false;
        }
        int size = this.aMn.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.aMn.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.aMt) && floatValue <= 5.0f;
    }

    public boolean canZoomOut() {
        if (this.ahN == 1 || this.ahN == 2) {
            return false;
        }
        int size = this.aMn.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled()) {
            return false;
        }
        return size > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hq() {
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
                    int size = this.aMn.size();
                    if (size > 0) {
                        f3 = this.aMn.get(size - 1).floatValue();
                    } else {
                        f3 = this.aMo;
                    }
                    this.mCurrentScale = f3;
                }
                this.mMatrix.setScale(this.mCurrentScale, this.mCurrentScale);
                this.aMl = imageBitmap.getWidth() * this.mCurrentScale;
                this.aMm = imageBitmap.getHeight() * this.mCurrentScale;
                float width = this.aMq * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.aMq;
                this.aME = this.mTop;
                this.aMF = 0;
                float f4 = this.aMl < ((float) this.mViewWidth) ? (int) ((this.mViewWidth - this.aMl) / 2.0f) : 0.0f;
                if (this.aMm < this.mViewHeight) {
                    f2 = (int) ((this.mViewHeight - this.aMm) / 2.0f);
                    if (this.aMu == 1 && f2 > this.mTop) {
                        f2 = this.mTop;
                    }
                    this.aME = (int) (this.mTop - f2);
                    this.aMF = this.mTop - this.aME;
                } else {
                    f2 = 0.0f;
                }
                this.aMG = (int) f4;
                this.mMatrix.postTranslate(f4, f2);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    int width2 = i > getWidth() ? getWidth() : i;
                    if (this.aMl <= screenWidth) {
                        width2 = 0;
                    } else if (this.aMl > screenWidth && this.aMl / 2.0f < screenWidth) {
                        width2 = (int) (width2 - (this.aMl / 4.0f));
                    }
                    scrollX = width2;
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.aMl - width) / 2.0f);
                    }
                    if (this.aMl <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.aMl) {
                        scrollX = (int) (this.aMl - getWidth());
                    }
                }
                if (scrollX > 0 && this.aMl - scrollX < getWidth()) {
                    scrollX = (int) (this.aMl - getWidth());
                }
                int i3 = this.mMode == 2 ? ((int) ((this.aMm - height) / 2.0f)) + scrollY : scrollY;
                if (this.aMm <= getHeight()) {
                    i3 = 0;
                } else if (getHeight() + i3 > this.aMm) {
                    i3 = (int) (this.aMm - getHeight());
                }
                setHorizontalScrollBarEnabled(false);
                setVerticalScrollBarEnabled(false);
                if (scrollX < 0) {
                    scrollX = 0;
                }
                scrollTo(scrollX, i3 >= 0 ? i3 : 0);
                setImageMatrix(this.mMatrix);
                Hf();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0065a extends Animation {
        private boolean aNi = false;
        private boolean aNj = false;
        private long aNk;
        private long aNl;
        private int aNm;
        private long aNn;
        private long aNo;
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
            this.aNk = f;
            this.aNl = f2;
            this.aNn = Math.abs((f * 1000.0f) / 2500.0f);
            this.aNo = Math.abs((f2 * 1000.0f) / 2500.0f);
            setDuration(Math.max(this.aNn, this.aNo));
            setInterpolator(a.this.aMN);
            this.aNm = a.this.getScrollX();
            this.mStartY = a.this.getScrollY();
            this.aNi = true;
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
            if (this.aNn > this.aNo) {
                j = ((float) this.aNn) * f;
            } else {
                j = ((float) this.aNo) * f;
            }
            float f2 = ((float) (j > this.aNn ? this.aNn : j)) / 1000.0f;
            if (this.aNk > 0) {
                i = this.aNm - ((int) (f2 * (((float) this.aNk) - ((2500.0f * f2) / 2.0f))));
            } else {
                i = this.aNm - ((int) (f2 * (((float) this.aNk) + ((2500.0f * f2) / 2.0f))));
            }
            if (j > this.aNo) {
                j = this.aNo;
            }
            float f3 = ((float) j) / 1000.0f;
            if (this.aNl > 0) {
                i2 = this.mStartY - ((int) (f3 * (((float) this.aNl) - ((2500.0f * f3) / 2.0f))));
            } else {
                i2 = this.mStartY - ((int) (f3 * (((float) this.aNl) + ((2500.0f * f3) / 2.0f))));
            }
            if (a.this.aMm + a.this.mTop + a.this.mBottom > a.this.getHeight()) {
                if (i2 < (-a.this.aME)) {
                    i2 = -a.this.aME;
                }
                if (a.this.getHeight() + i2 > a.this.aMm + a.this.mBottom + a.this.aMF) {
                    i2 = (int) ((a.this.aMm - a.this.getHeight()) + a.this.mBottom + a.this.aMF);
                }
            } else {
                i2 = 0;
            }
            if (a.this.aMl > a.this.getWidth()) {
                int width = ((float) (a.this.getWidth() + i)) > a.this.aMl ? (int) (a.this.aMl - a.this.getWidth()) : i;
                if (width >= 0) {
                    i3 = width;
                }
            }
            a.this.scrollTo(i3, i2);
            a.this.invalidate();
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            if (!this.aNj) {
                if (a.this.aMr) {
                    this.aNi = false;
                    return false;
                }
                try {
                    if (super.getTransformation(j, transformation)) {
                        return true;
                    }
                    this.aNi = false;
                    return false;
                } catch (Exception e) {
                    this.aNi = false;
                    return false;
                }
            }
            this.aNj = false;
            this.aNi = false;
            return false;
        }

        public boolean Hu() {
            return this.aNi;
        }

        public void stopAnimation() {
            this.aNj = true;
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.aMw = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.auG = onLongClickListener;
    }

    public void setGifSetListener(e eVar) {
        this.auJ = eVar;
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
    public void Hr() {
        long j;
        c poll = this.aMZ.poll();
        if (poll == null) {
            this.aNe = true;
            return;
        }
        this.aNe = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.aMY != null) {
            j = this.aMY.delay - (currentTimeMillis - this.aNd);
            this.aNa.offer(this.aMY);
        } else {
            j = 0;
        }
        this.aMY = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public c Hs() {
        c poll = this.aNa.poll();
        if (poll == null) {
            poll = new c();
            try {
                poll.aNp = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
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
        public Bitmap aNp;
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
            while (a.this.mState == 1 && a.this.aMC != null && a.this.aMX > 0 && a.this.width > 0 && a.this.height > 0) {
                try {
                    a.this.aMC.T(a.this.aNb);
                    c Hs = a.this.Hs();
                    if (Hs.aNp == null || (Hs.aNp.getWidth() != a.this.width && Hs.aNp.getHeight() != a.this.height)) {
                        try {
                            Hs.aNp = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_8888);
                        } catch (OutOfMemoryError e) {
                            TbadkCoreApplication.getInst().onAppMemoryLow();
                            try {
                                Hs.aNp = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_4444);
                            } catch (OutOfMemoryError e2) {
                                TbadkCoreApplication.getInst().onAppMemoryLow();
                            }
                        } catch (Throwable th) {
                            BdLog.e(th.getMessage());
                        }
                    }
                    a.this.aMC.a(Hs.aNp, null);
                    Hs.delay = a.this.aMC.U(a.this.aNb);
                    a.C(a.this);
                    if (Hs.aNp == null) {
                        a.C(a.this);
                    }
                    a.this.aNb %= a.this.aMX;
                    a.this.aMZ.put(Hs);
                    if (a.this.aNe) {
                        a.this.mHandler.sendEmptyMessage(1);
                    }
                } catch (Exception e3) {
                    return;
                }
            }
        }
    }

    public boolean Ht() {
        return this.aMI;
    }

    public void setLoadBigImage(boolean z) {
        this.aMI = z;
    }

    public int getBottomOffset() {
        return this.aMF;
    }

    public int getLeftOffset() {
        return this.aMG;
    }
}
