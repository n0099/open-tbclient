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
    private static final int axN = l.ae(TbadkCoreApplication.getInst()) / 5;
    private float aMM;
    private float aMN;
    private ArrayList<Float> aMO;
    private float aMP;
    private float aMQ;
    private float aMR;
    private boolean aMS;
    private byte[] aMT;
    private int aMU;
    private int aMV;
    private f aMW;
    private View.OnClickListener aMX;
    private C0065a aMY;
    private float aMZ;
    private boolean aNa;
    private boolean aNb;
    private int aNc;
    private volatile com.baidu.adp.gif.b aNd;
    private Bitmap aNe;
    private int aNf;
    private int aNg;
    private int aNh;
    private int aNi;
    private boolean aNj;
    private boolean aNk;
    private float aNl;
    private com.baidu.tbadk.widget.a.b.b aNm;
    private ImageUrlData aNn;
    private Interpolator aNo;
    private Rect aNp;
    private int aNq;
    private c aNr;
    private BlockingLinkedDeque<c> aNs;
    private BlockingLinkedDeque<c> aNt;
    private volatile int aNu;
    private b aNv;
    private volatile long aNw;
    private volatile boolean aNx;
    public int ahY;
    private View.OnLongClickListener auR;
    private e auU;
    private int auV;
    private boolean axF;
    private float axG;
    private Matrix axH;
    private Rect axI;
    private RectF axJ;
    private d axM;
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
    public static class c {
        public Bitmap aNG;
        public int delay;
    }

    /* loaded from: classes.dex */
    public interface d {
        void HB();

        void HC();
    }

    /* loaded from: classes.dex */
    public interface e {
        void a(a aVar);
    }

    /* loaded from: classes.dex */
    public interface f {
        void a(a aVar, boolean z, boolean z2);
    }

    static /* synthetic */ int B(a aVar) {
        int i = aVar.aNu;
        aVar.aNu = i + 1;
        return i;
    }

    public void setIsHeadImage(boolean z) {
        this.aNk = z;
    }

    public void setImageUrlData(ImageUrlData imageUrlData) {
        this.aNn = imageUrlData;
    }

    public a(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aMS = false;
        this.aMT = null;
        this.auV = 0;
        this.aMU = 1300;
        this.aMV = 0;
        this.aMW = null;
        this.aMX = null;
        this.auR = null;
        this.auU = null;
        this.aMZ = 1.0f;
        this.ahY = 0;
        this.mMode = 0;
        this.aNa = false;
        this.aNb = false;
        this.aNc = 0;
        this.aNd = null;
        this.aNe = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aNf = 0;
        this.aNg = 0;
        this.aNh = 0;
        this.aNi = 0;
        this.aNo = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.axH = new Matrix();
        this.axF = false;
        this.mRatio = 1.0f;
        this.axG = 0.0f;
        this.axJ = new RectF();
        this.width = 0;
        this.height = 0;
        this.aNq = 0;
        this.aNr = null;
        this.aNs = new BlockingLinkedDeque<>(5);
        this.aNt = new BlockingLinkedDeque<>(6);
        this.aNu = 0;
        this.aNw = 0L;
        this.mState = 0;
        this.aNx = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.a.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        a.this.Hx();
                        break;
                    case 1:
                        if (a.this.aNx) {
                            a.this.Hx();
                            break;
                        }
                        break;
                    case 2:
                        a.this.invalidate();
                        a.this.aNw = System.currentTimeMillis();
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
        this.aMS = false;
        this.aMT = null;
        this.auV = 0;
        this.aMU = 1300;
        this.aMV = 0;
        this.aMW = null;
        this.aMX = null;
        this.auR = null;
        this.auU = null;
        this.aMZ = 1.0f;
        this.ahY = 0;
        this.mMode = 0;
        this.aNa = false;
        this.aNb = false;
        this.aNc = 0;
        this.aNd = null;
        this.aNe = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aNf = 0;
        this.aNg = 0;
        this.aNh = 0;
        this.aNi = 0;
        this.aNo = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.axH = new Matrix();
        this.axF = false;
        this.mRatio = 1.0f;
        this.axG = 0.0f;
        this.axJ = new RectF();
        this.width = 0;
        this.height = 0;
        this.aNq = 0;
        this.aNr = null;
        this.aNs = new BlockingLinkedDeque<>(5);
        this.aNt = new BlockingLinkedDeque<>(6);
        this.aNu = 0;
        this.aNw = 0L;
        this.mState = 0;
        this.aNx = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.a.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        a.this.Hx();
                        break;
                    case 1:
                        if (a.this.aNx) {
                            a.this.Hx();
                            break;
                        }
                        break;
                    case 2:
                        a.this.invalidate();
                        a.this.aNw = System.currentTimeMillis();
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
        this.aMS = false;
        this.aMT = null;
        this.auV = 0;
        this.aMU = 1300;
        this.aMV = 0;
        this.aMW = null;
        this.aMX = null;
        this.auR = null;
        this.auU = null;
        this.aMZ = 1.0f;
        this.ahY = 0;
        this.mMode = 0;
        this.aNa = false;
        this.aNb = false;
        this.aNc = 0;
        this.aNd = null;
        this.aNe = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aNf = 0;
        this.aNg = 0;
        this.aNh = 0;
        this.aNi = 0;
        this.aNo = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.axH = new Matrix();
        this.axF = false;
        this.mRatio = 1.0f;
        this.axG = 0.0f;
        this.axJ = new RectF();
        this.width = 0;
        this.height = 0;
        this.aNq = 0;
        this.aNr = null;
        this.aNs = new BlockingLinkedDeque<>(5);
        this.aNt = new BlockingLinkedDeque<>(6);
        this.aNu = 0;
        this.aNw = 0L;
        this.mState = 0;
        this.aNx = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.a.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        a.this.Hx();
                        break;
                    case 1:
                        if (a.this.aNx) {
                            a.this.Hx();
                            break;
                        }
                        break;
                    case 2:
                        a.this.invalidate();
                        a.this.aNw = System.currentTimeMillis();
                        a.this.mHandler.sendEmptyMessage(0);
                        break;
                }
                return false;
            }
        });
        initData();
    }

    public void setDragToExitListener(d dVar) {
        this.axM = dVar;
    }

    public int getImageType() {
        return this.ahY;
    }

    public void setImageMode(int i) {
        this.aMV = i;
    }

    public void i(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.auV = i;
    }

    public boolean Hi() {
        if (this.aNm != null) {
            return this.aNm.Hi();
        }
        return false;
    }

    public void Hj() {
        this.aNb = false;
        this.aMS = false;
        this.mMode = 3;
        Hp();
        if (this.mCurrentScale < this.aMP) {
            this.mCurrentScale = this.aMP;
            Hw();
        }
        invalidate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.aNm != null && this.aNm.onTouchEvent(motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.aMS = true;
                this.aNa = false;
                this.aNb = false;
                break;
            case 1:
                Hj();
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
            this.aMZ = m(motionEvent);
            if (this.aMZ > 10.0f) {
                this.mMode = 2;
            }
        }
        if (this.mMode == 2 || !this.mGestureDetector.onTouchEvent(motionEvent)) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.aNa = true;
                        this.aNb = true;
                        if (this.ahY != 1 && this.ahY != 2) {
                            float m = m(motionEvent);
                            if (m >= 0.0f && Math.abs(this.aMZ - m) >= 10.0f) {
                                if (Math.abs(this.aMZ - m) > 100.0f) {
                                    this.aMZ = m;
                                    break;
                                } else {
                                    float f2 = m / this.aMZ;
                                    this.aMZ = m;
                                    this.aMR = this.mCurrentScale;
                                    this.mCurrentScale *= f2;
                                    if (this.mCurrentScale > this.aMQ) {
                                        this.mCurrentScale = this.aMQ;
                                    }
                                    float minScaleValue = getMinScaleValue();
                                    if (this.mCurrentScale < minScaleValue) {
                                        this.mCurrentScale = minScaleValue;
                                    }
                                    Hw();
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
        return this.aNm != null ? this.aNm.getMinScaleValue() : this.aMP / 4.0f;
    }

    public float m(MotionEvent motionEvent) {
        return CompatibleUtile.getInstance().getSpacing(motionEvent);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            this.mViewWidth = i3 - i;
            this.mViewHeight = i4 - i2;
            Hl();
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public boolean Hk() {
        if (this.aNm != null) {
            return this.aNm.HW();
        }
        return this.aMP == this.mCurrentScale;
    }

    protected float f(Bitmap bitmap) {
        if (this.aNm != null) {
            return this.aNm.Ia();
        }
        if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            return 1.0f;
        }
        if (this.aMV == 0) {
            float width = this.mViewWidth / bitmap.getWidth();
            float height = this.mViewHeight / bitmap.getHeight();
            if (this.aNk) {
                if (this.ahY == 2) {
                    return 2.5f;
                }
                return Math.min(width, height);
            } else if (this.ahY != 2) {
                float f2 = this.aNl;
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
        if (this.aNm != null) {
            return this.aNm.Ib();
        }
        float f2 = 1.0f;
        if (bitmap != null && !bitmap.isRecycled() && bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
            f2 = FloatMath.sqrt(this.aMU / (bitmap.getWidth() * bitmap.getHeight()));
            if (f2 > 10.0f) {
                return 10.0f;
            }
        }
        return f2;
    }

    private void Hl() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            this.aMP = f(imageBitmap);
            this.aMQ = g(imageBitmap);
            this.aMO.clear();
            this.aMO.add(Float.valueOf(this.aMP));
            this.mCurrentScale = this.aMP;
            this.aMR = this.mCurrentScale;
            Hw();
            return;
        }
        this.aMM = 0.0f;
        this.aMN = 0.0f;
        this.aMP = 1.0f;
        this.aMQ = 1.0f;
        this.mCurrentScale = 1.0f;
        this.aMR = this.mCurrentScale;
        this.aMO.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    private void Hm() {
        if (this.aMW != null) {
            this.aMW.a(this, canZoomIn(), canZoomOut());
        }
    }

    public void setOnSizeChangedListener(f fVar) {
        this.aMW = fVar;
    }

    public byte[] getImageData() {
        return this.aMT;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getMeasuredHeight() != 0 && getMeasuredWidth() != 0 && this.aNm != null) {
            this.aNm.HY();
        }
    }

    public void a(Bitmap bitmap, byte[] bArr) {
        this.aMT = bArr;
        if (this.aNm != null) {
            this.aNm.b(bitmap, bArr);
        }
        setImageBitmap(bitmap);
    }

    public void Hn() {
        if (this.aNm == null) {
            this.aNm = new com.baidu.tbadk.widget.a.b.b(this);
            this.aNm.setOnClickListener(this.aMX);
            this.aNm.setOnLongClickListener(this.auR);
        }
    }

    public void setImageLoadCallBack(com.baidu.tbadk.widget.a.b.a aVar) {
        if (this.aNm != null) {
            this.aNm.a(aVar);
        }
    }

    public boolean Ho() {
        return (getImageBitmap() == null || this.aNm == null) ? false : true;
    }

    public Bitmap getGifCache() {
        return this.aNe;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        boolean z;
        if (this.aNm == null || !this.aNm.b(canvas, getImageBitmap())) {
            if (this.ahY == 2 && this.aNi != 0 && !this.aMY.HA()) {
                int width = getWidth();
                int height = getHeight();
                Drawable drawable = getDrawable();
                float f2 = 0.0f;
                float f3 = height * 0.3f;
                float f4 = width;
                float f5 = (1.0f - 0.3f) * height;
                if (this.aNk && drawable != null) {
                    Rect bounds = drawable.getBounds();
                    int i = bounds.right - bounds.left;
                    int i2 = bounds.bottom - bounds.top;
                    f2 = (width / 2) - (i * 2.5f);
                    f3 = (height / 2) - (i2 * 2.5f);
                    f4 = (i * 2.5f) + (width / 2);
                    f5 = (i2 * 2.5f) + (height / 2);
                }
                this.mPaint.setColor(aj.getColor(this.aNi));
                canvas.drawRect(f2, f3, f4, f5, this.mPaint);
                this.mPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
            }
            if (this.mMode == 3 && this.axF) {
                this.axF = false;
                this.axH.reset();
                if (this.axG < axN) {
                    this.mMode = 0;
                } else {
                    this.mMode = 4;
                    Bc();
                }
            }
            if (this.ahY == 0 && this.axF && this.axI != null && this.aNn != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                if (this.axJ == null) {
                    this.axJ = new RectF();
                }
                this.axH.mapRect(this.axJ, new RectF(this.axI));
                Bitmap imageBitmap = getImageBitmap();
                if (imageBitmap != null && !imageBitmap.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.aNp, this.axJ, (Paint) null);
                }
            } else if (this.mMode == 4 && this.axI != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                Bitmap imageBitmap2 = getImageBitmap();
                if (imageBitmap2 != null && !imageBitmap2.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.aNp, this.axJ, (Paint) null);
                }
            } else {
                super.onDraw(canvas);
            }
            if (this.ahY == 1 && this.aNe != null && !this.aNe.isRecycled()) {
                int width2 = this.aNe.getWidth();
                int height2 = this.aNe.getHeight();
                int width3 = getWidth();
                int height3 = getHeight();
                int i3 = (width3 - width2) >> 1;
                int i4 = (height3 - height2) >> 1;
                float f6 = this.aNl;
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
                if (this.aNc == 1 && this.aNd != null && this.aNr != null && this.aNr.aNG != null) {
                    if (z) {
                        canvas.drawBitmap(this.aNr.aNG, i3, i4, (Paint) null);
                    } else {
                        canvas.drawBitmap(this.aNr.aNG, this.mMatrix, this.mPaint);
                    }
                    invalidate();
                } else if (z) {
                    canvas.drawBitmap(this.aNe, i3, i4, (Paint) null);
                } else {
                    canvas.drawBitmap(this.aNe, this.mMatrix, this.mPaint);
                }
            }
        }
    }

    public void play() {
        com.baidu.adp.widget.a.a aVar;
        if (this.ahY == 1) {
            if (this.aNd == null) {
                if (this.aNv != null) {
                    this.aNv.interrupt();
                    this.aNv = null;
                }
                if (this.aMT != null) {
                    try {
                        aVar = a.C0002a.dD().g(this.aMT, 0, this.aMT.length);
                    } catch (StackOverflowError e2) {
                        aVar = null;
                    }
                    if (aVar != null && aVar.getGif() != null) {
                        this.aNd = aVar.getGif();
                        if (this.aNd != null) {
                            this.aNc = 1;
                            this.width = this.aNd.getWidth();
                            this.height = this.aNd.getHeight();
                            this.aNu = 0;
                            this.aNq = this.aNd.getFrameCount();
                        } else {
                            this.aNc = 0;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            if (this.aNd != null && this.mState == 0) {
                this.aNx = true;
                this.aNv = new b();
                this.aNs.clear();
                this.aNt.clear();
                this.mState = 1;
                this.aNv.start();
            }
        }
    }

    public void pause() {
        if (this.ahY == 1) {
            this.mState = 0;
            if (this.aNv != null) {
                this.aNv.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.ahY == 1) {
            this.mState = 0;
            if (this.aNv != null) {
                this.aNv.interrupt();
                this.aNv = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.aNx = true;
            this.aNr = null;
            this.aNt.clear();
            this.aNs.clear();
            this.width = 0;
            this.height = 0;
            this.aNu = 0;
            this.aNq = 0;
            this.aNd = null;
        }
    }

    private void initData() {
        this.aNl = l.af(getContext());
        this.aMU = l.ae(getContext()) * l.ac(getContext()) * 2;
        if (this.aMU < 1690000) {
            this.aMU = 1690000;
        }
        this.aMM = 0.0f;
        this.aMN = 0.0f;
        this.aMO = new ArrayList<>();
        this.aMP = 1.0f;
        this.aMQ = 1.0f;
        this.mCurrentScale = 1.0f;
        this.aMR = this.mCurrentScale;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.aMY = new C0065a();
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWillNotDraw(false);
        scrollTo(0, 0);
        this.mGestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.a.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                if (a.this.ahY != 2 && (Math.abs(f2) > 200.0f || Math.abs(f3) > 200.0f)) {
                    a.this.aMY.e(f2, f3);
                    a.this.startAnimation(a.this.aMY);
                }
                return super.onFling(motionEvent, motionEvent2, f2, f3);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (a.this.ahY != 1 && a.this.ahY != 2) {
                    a.this.mMode = 2;
                    if (a.this.mCurrentScale > a.this.aMP) {
                        a.this.mCurrentScale = a.this.aMP;
                        a.this.aMR = a.this.mCurrentScale;
                        a.this.Hw();
                        return true;
                    }
                    a.this.mCurrentScale = a.this.aMP * 2.0f;
                    a.this.d(true, (int) motionEvent.getX(), (int) motionEvent.getY());
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (a.this.aMX != null && !a.this.aNa) {
                    a.this.aMX.onClick(a.this);
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
                a.this.aNa = true;
                if (a.this.aMV == 0 && a.this.aNb) {
                    return false;
                }
                int scrollX = a.this.getScrollX();
                int scrollY = a.this.getScrollY();
                if (a.this.aMM >= a.this.getWidth()) {
                    scrollX = (int) (scrollX + f2);
                    if (a.this.aMV == 0) {
                        i = scrollX >= 0 ? scrollX : 0;
                        if (a.this.getWidth() + i > a.this.aMM) {
                            i = (int) (a.this.aMM - a.this.getWidth());
                        }
                        if (a.this.aMN + a.this.mTop + a.this.mBottom < a.this.getHeight()) {
                            i2 = (int) (scrollY + f3);
                            if (a.this.aMV == 0) {
                                if (i2 < (-a.this.aNf)) {
                                    i2 = -a.this.aNf;
                                }
                                if (a.this.getHeight() + i2 > a.this.aMN + a.this.mBottom + a.this.aNg) {
                                    i2 = (int) ((a.this.aMN - a.this.getHeight()) + a.this.mBottom + a.this.aNg);
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
                if (a.this.aMN + a.this.mTop + a.this.mBottom < a.this.getHeight()) {
                }
                if (i == a.this.getScrollX()) {
                }
                a.this.scrollTo(i, i2);
                a.this.invalidate();
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (a.this.auR != null && !a.this.aNa) {
                    a.this.auR.onLongClick(a.this);
                }
                super.onLongPress(motionEvent);
            }
        });
    }

    private void Bc() {
        if (this.aNn == null) {
            if (this.axM != null) {
                this.axM.HC();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.aNn.getSourceImageRectInScreen();
        if (sourceImageRectInScreen == null) {
            if (this.axM != null) {
                this.axM.HC();
                return;
            }
            return;
        }
        this.axJ.bottom = (((sourceImageRectInScreen.bottom - sourceImageRectInScreen.top) / (sourceImageRectInScreen.right - sourceImageRectInScreen.left)) * (this.axJ.right - this.axJ.left)) + this.axJ.top;
        final float[] fArr = {(this.axJ.left + this.axJ.right) / 2.0f, (this.axJ.top + this.axJ.bottom) / 2.0f};
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
                    a.this.axJ = a.this.e(floatValue, animatedFraction, sourceImageRectInScreen.right - sourceImageRectInScreen.left, sourceImageRectInScreen.bottom - sourceImageRectInScreen.top);
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
                a.this.axF = false;
                a.this.mMode = 4;
                a.this.invalidate();
                if (a.this.axM != null) {
                    a.this.axM.HC();
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

    private void Hp() {
        int i = 0;
        int scrollX = getScrollX();
        if (this.aMM >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.aMM) {
                scrollX = (int) (this.aMM - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.aMN + this.mTop + this.mBottom >= getHeight()) {
            i = scrollY < (-this.aNf) ? -this.aNf : scrollY;
            if (getHeight() + i > this.aMN + this.mBottom + this.aNg) {
                i = (int) ((this.aMN - getHeight()) + this.mBottom + this.aNg);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.aNm != null) {
            this.aNm.HX();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.aMM;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.aMN;
    }

    public boolean Hq() {
        if (this.ahY == 1 || this.ahY == 2) {
            return true;
        }
        return !this.aNb && getScrollX() >= ((int) (this.aMM - ((float) getWidth()))) + (-1);
    }

    public boolean Hr() {
        if (this.ahY == 1 || this.ahY == 2) {
            return true;
        }
        return !this.aNb && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.aMY.HA()) {
            this.aMY.stopAnimation();
        }
        this.aNi = 0;
        super.setImageBitmap(bitmap);
        Hl();
        this.ahY = 0;
        if (this.axI == null) {
            int measuredWidth = getMeasuredWidth();
            float measuredWidth2 = ((1.0f * getMeasuredWidth()) / bitmap.getWidth()) * bitmap.getHeight();
            if (measuredWidth2 > getMeasuredHeight()) {
                measuredWidth2 = getMeasuredHeight();
            }
            RectF e2 = e(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
            this.axI = new Rect((int) e2.left, (int) e2.top, (int) e2.right, (int) e2.bottom);
        }
        if (this.aNp == null) {
            this.aNp = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
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
            if (this.aMY.HA()) {
                this.aMY.stopAnimation();
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            super.setImageBitmap(bitmap);
            super.setImageMatrix(this.mMatrix);
            scrollTo(scrollX, scrollY);
            this.ahY = 0;
        }
    }

    public void a(byte[] bArr, Bitmap bitmap) {
        if (this.aMY.HA()) {
            this.aMY.stopAnimation();
        }
        super.setImageDrawable(null);
        stop();
        Hl();
        this.ahY = 1;
        this.aNe = bitmap;
        this.aMT = bArr;
        if (this.auU != null) {
            this.auU.a(this);
        }
    }

    public void onDestroy() {
        if (this.aMY.HA()) {
            this.aMY.stopAnimation();
        }
        super.setImageDrawable(null);
        this.aMT = null;
        this.aNe = null;
        stop();
        if (this.aNd != null) {
            this.aNd.close();
            this.aNd = null;
        }
        if (this.aNm != null) {
            this.aNm.release();
            System.gc();
        }
    }

    public void release() {
        if (this.aMY.HA()) {
            this.aMY.stopAnimation();
        }
        stop();
        super.setImageDrawable(null);
        this.aNe = null;
    }

    public void Hs() {
        if (this.aMY.HA()) {
            this.aMY.stopAnimation();
        }
        try {
            if (this.aNk) {
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
        this.ahY = 2;
        Hl();
    }

    public void Ht() {
        if (this.ahY != 1 && this.ahY != 2) {
            int size = this.aMO.size();
            if (size > 0) {
                this.aMO.add(Float.valueOf(this.aMO.get(size - 1).floatValue() * 1.25f));
            } else {
                this.aMO.add(Float.valueOf(this.aMP));
            }
            Hw();
        }
    }

    public void Hu() {
        if (this.ahY != 1 && this.ahY != 2) {
            int size = this.aMO.size();
            if (size > 1) {
                this.aMO.remove(size - 1);
            }
            Hw();
        }
    }

    public void Hv() {
        Hm();
        if (this.ahY != 1 && this.ahY != 2 && this.mCurrentScale != this.aMP) {
            this.aMO.clear();
            this.aMO.add(Float.valueOf(this.aMP));
            this.mCurrentScale = this.aMP;
            this.aMR = this.mCurrentScale;
            Hw();
        }
    }

    public boolean canZoomIn() {
        if (this.ahY == 1 || this.ahY == 2) {
            return false;
        }
        int size = this.aMO.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.aMO.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.aMU) && floatValue <= 5.0f;
    }

    public boolean canZoomOut() {
        if (this.ahY == 1 || this.ahY == 2) {
            return false;
        }
        int size = this.aMO.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled()) {
            return false;
        }
        return size > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hw() {
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
                    int size = this.aMO.size();
                    if (size > 0) {
                        f3 = this.aMO.get(size - 1).floatValue();
                    } else {
                        f3 = this.aMP;
                    }
                    this.mCurrentScale = f3;
                }
                this.mMatrix.setScale(this.mCurrentScale, this.mCurrentScale);
                this.aMM = imageBitmap.getWidth() * this.mCurrentScale;
                this.aMN = imageBitmap.getHeight() * this.mCurrentScale;
                float width = this.aMR * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.aMR;
                this.aNf = this.mTop;
                this.aNg = 0;
                float f4 = this.aMM < ((float) this.mViewWidth) ? (int) ((this.mViewWidth - this.aMM) / 2.0f) : 0.0f;
                if (this.aMN < this.mViewHeight) {
                    f2 = (int) ((this.mViewHeight - this.aMN) / 2.0f);
                    if (this.aMV == 1 && f2 > this.mTop) {
                        f2 = this.mTop;
                    }
                    this.aNf = (int) (this.mTop - f2);
                    this.aNg = this.mTop - this.aNf;
                } else {
                    f2 = 0.0f;
                }
                this.aNh = (int) f4;
                this.mMatrix.postTranslate(f4, f2);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    int width2 = i > getWidth() ? getWidth() : i;
                    if (this.aMM <= screenWidth) {
                        width2 = 0;
                    } else if (this.aMM > screenWidth && this.aMM / 2.0f < screenWidth) {
                        width2 = (int) (width2 - (this.aMM / 4.0f));
                    }
                    scrollX = width2;
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.aMM - width) / 2.0f);
                    }
                    if (this.aMM <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.aMM) {
                        scrollX = (int) (this.aMM - getWidth());
                    }
                }
                if (scrollX > 0 && this.aMM - scrollX < getWidth()) {
                    scrollX = (int) (this.aMM - getWidth());
                }
                int i3 = this.mMode == 2 ? ((int) ((this.aMN - height) / 2.0f)) + scrollY : scrollY;
                if (this.aMN <= getHeight()) {
                    i3 = 0;
                } else if (getHeight() + i3 > this.aMN) {
                    i3 = (int) (this.aMN - getHeight());
                }
                setHorizontalScrollBarEnabled(false);
                setVerticalScrollBarEnabled(false);
                if (scrollX < 0) {
                    scrollX = 0;
                }
                scrollTo(scrollX, i3 >= 0 ? i3 : 0);
                setImageMatrix(this.mMatrix);
                Hm();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0065a extends Animation {
        private long aNB;
        private long aNC;
        private int aND;
        private long aNE;
        private long aNF;
        private int mStartY;
        private boolean aNz = false;
        private boolean aNA = false;

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
            this.aNB = f;
            this.aNC = f2;
            this.aNE = Math.abs((f * 1000.0f) / 2500.0f);
            this.aNF = Math.abs((f2 * 1000.0f) / 2500.0f);
            setDuration(Math.max(this.aNE, this.aNF));
            setInterpolator(a.this.aNo);
            this.aND = a.this.getScrollX();
            this.mStartY = a.this.getScrollY();
            this.aNz = true;
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
            if (this.aNE > this.aNF) {
                j = ((float) this.aNE) * f;
            } else {
                j = ((float) this.aNF) * f;
            }
            float f2 = ((float) (j > this.aNE ? this.aNE : j)) / 1000.0f;
            if (this.aNB > 0) {
                i = this.aND - ((int) (f2 * (((float) this.aNB) - ((2500.0f * f2) / 2.0f))));
            } else {
                i = this.aND - ((int) (f2 * (((float) this.aNB) + ((2500.0f * f2) / 2.0f))));
            }
            if (j > this.aNF) {
                j = this.aNF;
            }
            float f3 = ((float) j) / 1000.0f;
            if (this.aNC > 0) {
                i2 = this.mStartY - ((int) (f3 * (((float) this.aNC) - ((2500.0f * f3) / 2.0f))));
            } else {
                i2 = this.mStartY - ((int) (f3 * (((float) this.aNC) + ((2500.0f * f3) / 2.0f))));
            }
            if (a.this.aMN + a.this.mTop + a.this.mBottom > a.this.getHeight()) {
                if (i2 < (-a.this.aNf)) {
                    i2 = -a.this.aNf;
                }
                if (a.this.getHeight() + i2 > a.this.aMN + a.this.mBottom + a.this.aNg) {
                    i2 = (int) ((a.this.aMN - a.this.getHeight()) + a.this.mBottom + a.this.aNg);
                }
            } else {
                i2 = 0;
            }
            if (a.this.aMM > a.this.getWidth()) {
                int width = ((float) (a.this.getWidth() + i)) > a.this.aMM ? (int) (a.this.aMM - a.this.getWidth()) : i;
                if (width >= 0) {
                    i3 = width;
                }
            }
            a.this.scrollTo(i3, i2);
            a.this.invalidate();
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            if (!this.aNA) {
                if (a.this.aMS) {
                    this.aNz = false;
                    return false;
                }
                try {
                    if (super.getTransformation(j, transformation)) {
                        return true;
                    }
                    this.aNz = false;
                    return false;
                } catch (Exception e) {
                    this.aNz = false;
                    return false;
                }
            }
            this.aNA = false;
            this.aNz = false;
            return false;
        }

        public boolean HA() {
            return this.aNz;
        }

        public void stopAnimation() {
            this.aNA = true;
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.aMX = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.auR = onLongClickListener;
        if (this.aNm != null) {
            this.aNm.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setGifSetListener(e eVar) {
        this.auU = eVar;
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
    public void Hx() {
        long j;
        c poll = this.aNs.poll();
        if (poll == null) {
            this.aNx = true;
            return;
        }
        this.aNx = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.aNr != null) {
            j = this.aNr.delay - (currentTimeMillis - this.aNw);
            this.aNt.offer(this.aNr);
        } else {
            j = 0;
        }
        this.aNr = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public c Hy() {
        c poll = this.aNt.poll();
        if (poll == null) {
            poll = new c();
            try {
                poll.aNG = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
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
        return this.aNr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends Thread {
        private b() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (a.this.mState == 1 && a.this.aNd != null && a.this.aNq > 0 && a.this.width > 0 && a.this.height > 0) {
                try {
                    a.this.aNd.T(a.this.aNu);
                    c Hy = a.this.Hy();
                    if (Hy.aNG == null || (Hy.aNG.getWidth() != a.this.width && Hy.aNG.getHeight() != a.this.height)) {
                        try {
                            Hy.aNG = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_8888);
                        } catch (OutOfMemoryError e) {
                            TbadkCoreApplication.getInst().onAppMemoryLow();
                            try {
                                Hy.aNG = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_4444);
                            } catch (OutOfMemoryError e2) {
                                TbadkCoreApplication.getInst().onAppMemoryLow();
                            }
                        } catch (Throwable th) {
                            BdLog.e(th.getMessage());
                        }
                    }
                    a.this.aNd.a(Hy.aNG, null);
                    Hy.delay = a.this.aNd.U(a.this.aNu);
                    a.B(a.this);
                    if (Hy.aNG == null) {
                        a.B(a.this);
                    }
                    a.this.aNu %= a.this.aNq;
                    a.this.aNs.put(Hy);
                    if (a.this.aNx) {
                        a.this.mHandler.sendEmptyMessage(1);
                    }
                } catch (Exception e3) {
                    return;
                }
            }
        }
    }

    public boolean Hz() {
        return this.aNj;
    }

    public void setLoadBigImage(boolean z) {
        this.aNj = z;
    }

    public int getBottomOffset() {
        return this.aNg;
    }

    public int getLeftOffset() {
        return this.aNh;
    }
}
