package com.baidu.tbadk.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
import android.widget.ImageView;
import com.baidu.adp.gif.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BlockingLinkedDeque;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends ImageView {
    private float aLO;
    private float aLP;
    private ArrayList<Float> aLQ;
    private float aLR;
    private float aLS;
    private float aLT;
    private boolean aLU;
    private int aLV;
    private int aLW;
    private e aLX;
    private View.OnClickListener aLY;
    private C0064a aLZ;
    private float aMa;
    private boolean aMb;
    private boolean aMc;
    private int aMd;
    private volatile com.baidu.adp.gif.b aMe;
    private Bitmap aMf;
    private int aMg;
    private int aMh;
    private int aMi;
    private int aMj;
    private boolean aMk;
    private boolean aMl;
    private float aMm;
    private Interpolator aMn;
    private int aMo;
    private c aMp;
    private BlockingLinkedDeque<c> aMq;
    private BlockingLinkedDeque<c> aMr;
    private volatile int aMs;
    private b aMt;
    private volatile long aMu;
    private volatile boolean aMv;
    private int ahx;
    private View.OnLongClickListener auW;
    private d auY;
    private int auZ;
    private int height;
    private int mBottom;
    private float mCurrentScale;
    private GestureDetector mGestureDetector;
    public Handler mHandler;
    private byte[] mImageData;
    private Matrix mMatrix;
    private int mMode;
    private Paint mPaint;
    private volatile int mState;
    private int mTop;
    private int mViewHeight;
    private int mViewWidth;
    private int width;

    /* loaded from: classes.dex */
    public interface d {
        void a(a aVar);
    }

    /* loaded from: classes.dex */
    public interface e {
        void a(a aVar, boolean z, boolean z2);
    }

    static /* synthetic */ int B(a aVar) {
        int i = aVar.aMs;
        aVar.aMs = i + 1;
        return i;
    }

    public void setIsHeadImage(boolean z) {
        this.aMl = z;
    }

    public a(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aLU = false;
        this.mImageData = null;
        this.auZ = 0;
        this.aLV = 1300;
        this.aLW = 0;
        this.aLX = null;
        this.aLY = null;
        this.auW = null;
        this.auY = null;
        this.aMa = 1.0f;
        this.ahx = 0;
        this.mMode = 0;
        this.aMb = false;
        this.aMc = false;
        this.aMd = 0;
        this.aMe = null;
        this.aMf = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aMg = 0;
        this.aMh = 0;
        this.aMi = 0;
        this.aMj = 0;
        this.aMn = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aMo = 0;
        this.aMp = null;
        this.aMq = new BlockingLinkedDeque<>(5);
        this.aMr = new BlockingLinkedDeque<>(6);
        this.aMs = 0;
        this.aMu = 0L;
        this.mState = 0;
        this.aMv = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.a.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        a.this.HD();
                        break;
                    case 1:
                        if (a.this.aMv) {
                            a.this.HD();
                            break;
                        }
                        break;
                    case 2:
                        a.this.invalidate();
                        a.this.aMu = System.currentTimeMillis();
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
        this.aLU = false;
        this.mImageData = null;
        this.auZ = 0;
        this.aLV = 1300;
        this.aLW = 0;
        this.aLX = null;
        this.aLY = null;
        this.auW = null;
        this.auY = null;
        this.aMa = 1.0f;
        this.ahx = 0;
        this.mMode = 0;
        this.aMb = false;
        this.aMc = false;
        this.aMd = 0;
        this.aMe = null;
        this.aMf = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aMg = 0;
        this.aMh = 0;
        this.aMi = 0;
        this.aMj = 0;
        this.aMn = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aMo = 0;
        this.aMp = null;
        this.aMq = new BlockingLinkedDeque<>(5);
        this.aMr = new BlockingLinkedDeque<>(6);
        this.aMs = 0;
        this.aMu = 0L;
        this.mState = 0;
        this.aMv = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.a.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        a.this.HD();
                        break;
                    case 1:
                        if (a.this.aMv) {
                            a.this.HD();
                            break;
                        }
                        break;
                    case 2:
                        a.this.invalidate();
                        a.this.aMu = System.currentTimeMillis();
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
        this.aLU = false;
        this.mImageData = null;
        this.auZ = 0;
        this.aLV = 1300;
        this.aLW = 0;
        this.aLX = null;
        this.aLY = null;
        this.auW = null;
        this.auY = null;
        this.aMa = 1.0f;
        this.ahx = 0;
        this.mMode = 0;
        this.aMb = false;
        this.aMc = false;
        this.aMd = 0;
        this.aMe = null;
        this.aMf = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aMg = 0;
        this.aMh = 0;
        this.aMi = 0;
        this.aMj = 0;
        this.aMn = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aMo = 0;
        this.aMp = null;
        this.aMq = new BlockingLinkedDeque<>(5);
        this.aMr = new BlockingLinkedDeque<>(6);
        this.aMs = 0;
        this.aMu = 0L;
        this.mState = 0;
        this.aMv = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.a.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        a.this.HD();
                        break;
                    case 1:
                        if (a.this.aMv) {
                            a.this.HD();
                            break;
                        }
                        break;
                    case 2:
                        a.this.invalidate();
                        a.this.aMu = System.currentTimeMillis();
                        a.this.mHandler.sendEmptyMessage(0);
                        break;
                }
                return false;
            }
        });
        initData();
    }

    public int getImageType() {
        return this.ahx;
    }

    public void setImageMode(int i) {
        this.aLW = i;
    }

    public void j(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.auZ = i;
    }

    public void Hr() {
        this.aMc = false;
        this.aLU = false;
        this.mMode = 0;
        Hv();
        if (this.mCurrentScale < this.aLR) {
            this.mCurrentScale = this.aLR;
            HC();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.aLU = true;
                this.aMb = false;
                this.aMc = false;
                break;
            case 1:
                Hr();
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
            this.aMa = m(motionEvent);
            if (this.aMa > 10.0f) {
                this.mMode = 2;
            }
        }
        if (this.mMode == 2 || !this.mGestureDetector.onTouchEvent(motionEvent)) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.aMb = true;
                        this.aMc = true;
                        if (this.ahx != 1 && this.ahx != 2) {
                            float m = m(motionEvent);
                            if (m >= 0.0f && Math.abs(this.aMa - m) >= 10.0f) {
                                if (Math.abs(this.aMa - m) > 100.0f) {
                                    this.aMa = m;
                                    break;
                                } else {
                                    float f = m / this.aMa;
                                    this.aMa = m;
                                    this.aLT = this.mCurrentScale;
                                    this.mCurrentScale *= f;
                                    if (this.mCurrentScale > this.aLS) {
                                        this.mCurrentScale = this.aLS;
                                    }
                                    if (this.mCurrentScale < this.aLR / 4.0f) {
                                        this.mCurrentScale = this.aLR / 4.0f;
                                    }
                                    HC();
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

    public float m(MotionEvent motionEvent) {
        return CompatibleUtile.getInstance().getSpacing(motionEvent);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            this.mViewWidth = i3 - i;
            this.mViewHeight = i4 - i2;
            Ht();
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public boolean Hs() {
        return this.aLR == this.mCurrentScale;
    }

    private void Ht() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            if (this.aLW == 0) {
                float width = this.mViewWidth / imageBitmap.getWidth();
                float height = this.mViewHeight / imageBitmap.getHeight();
                if (this.aMl) {
                    if (this.ahx == 2) {
                        this.aLR = 2.5f;
                    } else {
                        this.aLR = Math.min(width, height);
                    }
                } else if (this.ahx == 2) {
                    this.aLR = 1.0f;
                } else {
                    float f = this.aMm;
                    float f2 = f >= 1.0f ? f : 1.0f;
                    if (imageBitmap.getWidth() * f2 < this.mViewWidth && imageBitmap.getHeight() * f2 < this.mViewHeight) {
                        this.aLR = f2;
                    } else {
                        this.aLR = Math.min(width, height);
                    }
                }
            } else {
                this.aLR = Math.max(this.mViewWidth / imageBitmap.getWidth(), ((this.mViewHeight - this.mTop) - this.mBottom) / imageBitmap.getHeight());
            }
            this.aLS = this.aLV / (imageBitmap.getWidth() * imageBitmap.getHeight());
            this.aLS = FloatMath.sqrt(this.aLS);
            if (this.aLS > 10.0f) {
                this.aLS = 10.0f;
            }
            this.aLQ.clear();
            this.aLQ.add(Float.valueOf(this.aLR));
            this.mCurrentScale = this.aLR;
            this.aLT = this.mCurrentScale;
            HC();
            return;
        }
        this.aLO = 0.0f;
        this.aLP = 0.0f;
        this.aLR = 1.0f;
        this.aLS = 1.0f;
        this.mCurrentScale = 1.0f;
        this.aLT = this.mCurrentScale;
        this.aLQ.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    private void Hu() {
        if (this.aLX != null) {
            this.aLX.a(this, canZoomIn(), canZoomOut());
        }
    }

    public void setOnSizeChangedListener(e eVar) {
        this.aLX = eVar;
    }

    public byte[] getImageData() {
        return this.mImageData;
    }

    public void setImageData(byte[] bArr) {
        this.mImageData = bArr;
    }

    public Bitmap getGifCache() {
        return this.aMf;
    }

    public void setGifCache(Bitmap bitmap) {
        this.aMf = bitmap;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        boolean z;
        int i4;
        if (this.ahx == 2 && this.aMj != 0 && !this.aLZ.HG()) {
            int width = getWidth();
            int height = getHeight();
            Drawable drawable = getDrawable();
            float f = 0.0f;
            float f2 = height * 0.3f;
            float f3 = width;
            float f4 = (1.0f - 0.3f) * height;
            if (this.aMl && drawable != null) {
                Rect bounds = drawable.getBounds();
                int i5 = bounds.right - bounds.left;
                int i6 = bounds.bottom - bounds.top;
                f = (width / 2) - (i5 * 2.5f);
                f2 = (height / 2) - (i6 * 2.5f);
                f3 = (i5 * 2.5f) + (width / 2);
                f4 = (i6 * 2.5f) + (height / 2);
            }
            this.mPaint.setColor(ai.getColor(this.aMj));
            canvas.drawRect(f, f2, f3, f4, this.mPaint);
            this.mPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        }
        super.onDraw(canvas);
        if (this.ahx == 1 && this.aMf != null && !this.aMf.isRecycled()) {
            int width2 = this.aMf.getWidth();
            int height2 = this.aMf.getHeight();
            int width3 = getWidth();
            int height3 = getHeight();
            int i7 = (width3 - width2) >> 1;
            int i8 = (height3 - height2) >> 1;
            float f5 = this.aMm;
            if (f5 < 1.0f) {
                f5 = 1.0f;
            }
            if (width2 * f5 >= width3 || height2 * f5 >= height3) {
                f5 = Math.min(width3 / width2, height3 / height2);
            }
            if (Math.abs(f5 - 1.0f) < 1.0E-8f) {
                z = true;
                i4 = height2;
                i = width2;
                i2 = i8;
                i3 = i7;
            } else {
                this.mMatrix.setScale(f5, f5);
                int i9 = (int) ((width3 - (width2 * f5)) / 2.0f);
                int i10 = (int) ((height3 - (height2 * f5)) / 2.0f);
                this.mMatrix.postTranslate(i9, i10);
                int i11 = (int) (f5 * height2);
                i = (int) (width2 * f5);
                i2 = i10;
                i3 = i9;
                z = false;
                i4 = i11;
            }
            canvas.clipRect(i3, i2, i + i3, i4 + i2);
            canvas.drawColor(-1);
            if (this.aMd == 1 && this.aMe != null && this.aMp != null && this.aMp.aME != null) {
                if (z) {
                    canvas.drawBitmap(this.aMp.aME, i3, i2, (Paint) null);
                } else {
                    canvas.drawBitmap(this.aMp.aME, this.mMatrix, this.mPaint);
                }
                invalidate();
            } else if (z) {
                canvas.drawBitmap(this.aMf, i3, i2, (Paint) null);
            } else {
                canvas.drawBitmap(this.aMf, this.mMatrix, this.mPaint);
            }
        }
    }

    public void play() {
        com.baidu.adp.widget.a.a aVar;
        if (this.ahx == 1) {
            if (this.aMe == null) {
                if (this.aMt != null) {
                    this.aMt.interrupt();
                    this.aMt = null;
                }
                if (this.mImageData != null) {
                    try {
                        aVar = a.C0003a.dC().g(this.mImageData, 0, this.mImageData.length);
                    } catch (StackOverflowError e2) {
                        aVar = null;
                    }
                    if (aVar != null && aVar.getGif() != null) {
                        this.aMe = aVar.getGif();
                        if (this.aMe != null) {
                            this.aMd = 1;
                            this.width = this.aMe.getWidth();
                            this.height = this.aMe.getHeight();
                            this.aMs = 0;
                            this.aMo = this.aMe.dD();
                        } else {
                            this.aMd = 0;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            if (this.aMe != null && this.mState == 0) {
                this.aMv = true;
                this.aMt = new b();
                this.aMq.clear();
                this.aMr.clear();
                this.mState = 1;
                this.aMt.start();
            }
        }
    }

    public void pause() {
        if (this.ahx == 1) {
            this.mState = 0;
            if (this.aMt != null) {
                this.aMt.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.ahx == 1) {
            this.mState = 0;
            if (this.aMt != null) {
                this.aMt.interrupt();
                this.aMt = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.aMv = true;
            this.aMp = null;
            this.aMr.clear();
            this.aMq.clear();
            this.width = 0;
            this.height = 0;
            this.aMs = 0;
            this.aMo = 0;
            if (this.aMe != null) {
                this.aMe = null;
            }
        }
    }

    private void initData() {
        this.aMm = k.ah(getContext());
        this.aLV = k.ag(getContext()) * k.af(getContext()) * 2;
        if (this.aLV < 1690000) {
            this.aLV = 1690000;
        }
        this.aLO = 0.0f;
        this.aLP = 0.0f;
        this.aLQ = new ArrayList<>();
        this.aLR = 1.0f;
        this.aLS = 1.0f;
        this.mCurrentScale = 1.0f;
        this.aLT = this.mCurrentScale;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.aLZ = new C0064a();
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWillNotDraw(false);
        scrollTo(0, 0);
        this.mGestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.a.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (a.this.ahx != 2 && (Math.abs(f) > 200.0f || Math.abs(f2) > 200.0f)) {
                    a.this.aLZ.e(f, f2);
                    a.this.startAnimation(a.this.aLZ);
                }
                return super.onFling(motionEvent, motionEvent2, f, f2);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (a.this.ahx != 1 && a.this.ahx != 2) {
                    a.this.mMode = 2;
                    if (a.this.mCurrentScale > a.this.aLR) {
                        a.this.mCurrentScale = a.this.aLR;
                        a.this.aLT = a.this.mCurrentScale;
                        a.this.HC();
                        return true;
                    }
                    a.this.mCurrentScale = a.this.aLR * 2.0f;
                    a.this.e(true, (int) motionEvent.getX(), (int) motionEvent.getY());
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (a.this.aLY != null && !a.this.aMb) {
                    a.this.aLY.onClick(a.this);
                }
                return super.onSingleTapConfirmed(motionEvent);
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x0084  */
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                int i;
                int scrollY;
                a.this.aMb = true;
                if (a.this.aLW == 0 && a.this.aMc) {
                    return false;
                }
                int scrollX = a.this.getScrollX();
                if (a.this.aLO >= a.this.getWidth()) {
                    scrollX = (int) (scrollX + f);
                    if (a.this.aLW == 0) {
                        i = scrollX >= 0 ? scrollX : 0;
                        if (a.this.getWidth() + i > a.this.aLO) {
                            i = (int) (a.this.aLO - a.this.getWidth());
                        }
                        scrollY = a.this.getScrollY();
                        if (a.this.aLP + a.this.mTop + a.this.mBottom >= a.this.getHeight()) {
                            scrollY = (int) (scrollY + f2);
                            if (a.this.aLW == 0) {
                                if (scrollY < (-a.this.aMg)) {
                                    scrollY = -a.this.aMg;
                                }
                                if (a.this.getHeight() + scrollY > a.this.aLP + a.this.mBottom + a.this.aMh) {
                                    scrollY = (int) ((a.this.aLP - a.this.getHeight()) + a.this.mBottom + a.this.aMh);
                                }
                            }
                        }
                        if (i == a.this.getScrollX() || scrollY != a.this.getScrollY()) {
                            a.this.scrollTo(i, scrollY);
                            a.this.invalidate();
                        }
                        return true;
                    }
                }
                i = scrollX;
                scrollY = a.this.getScrollY();
                if (a.this.aLP + a.this.mTop + a.this.mBottom >= a.this.getHeight()) {
                }
                if (i == a.this.getScrollX()) {
                }
                a.this.scrollTo(i, scrollY);
                a.this.invalidate();
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (a.this.auW != null && !a.this.aMb) {
                    a.this.auW.onLongClick(a.this);
                }
                super.onLongPress(motionEvent);
            }
        });
    }

    private void Hv() {
        int i = 0;
        int scrollX = getScrollX();
        if (this.aLO >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.aLO) {
                scrollX = (int) (this.aLO - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.aLP + this.mTop + this.mBottom >= getHeight()) {
            i = scrollY < (-this.aMg) ? -this.aMg : scrollY;
            if (getHeight() + i > this.aLP + this.mBottom + this.aMh) {
                i = (int) ((this.aLP - getHeight()) + this.mBottom + this.aMh);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.aLO;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.aLP;
    }

    public boolean Hw() {
        if (this.ahx == 1 || this.ahx == 2) {
            return true;
        }
        return !this.aMc && getScrollX() >= ((int) (this.aLO - ((float) getWidth()))) + (-1);
    }

    public boolean Hx() {
        if (this.ahx == 1 || this.ahx == 2) {
            return true;
        }
        return !this.aMc && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.aLZ.HG()) {
            this.aLZ.stopAnimation();
        }
        this.aMj = 0;
        super.setImageBitmap(bitmap);
        Ht();
        this.ahx = 0;
    }

    public void i(Bitmap bitmap) {
        Bitmap imageBitmap = getImageBitmap();
        if (bitmap != null && !bitmap.isRecycled()) {
            if (imageBitmap != null && (imageBitmap.getWidth() != bitmap.getWidth() || imageBitmap.getHeight() != bitmap.getHeight())) {
                setImageBitmap(bitmap);
                return;
            }
            if (this.aLZ.HG()) {
                this.aLZ.stopAnimation();
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            super.setImageBitmap(bitmap);
            super.setImageMatrix(this.mMatrix);
            scrollTo(scrollX, scrollY);
            this.ahx = 0;
        }
    }

    public void a(byte[] bArr, Bitmap bitmap) {
        if (this.aLZ.HG()) {
            this.aLZ.stopAnimation();
        }
        super.setImageDrawable(null);
        stop();
        Ht();
        this.ahx = 1;
        this.aMf = bitmap;
        this.mImageData = bArr;
        if (this.auY != null) {
            this.auY.a(this);
        }
    }

    public void onDestroy() {
        if (this.aLZ.HG()) {
            this.aLZ.stopAnimation();
        }
        super.setImageDrawable(null);
        this.mImageData = null;
        this.aMf = null;
        stop();
        if (this.aMe != null) {
            this.aMe.close();
            this.aMe = null;
        }
    }

    public void release() {
        if (this.aLZ.HG()) {
            this.aLZ.stopAnimation();
        }
        stop();
        super.setImageDrawable(null);
        this.aMf = null;
    }

    public void Hy() {
        if (this.aLZ.HG()) {
            this.aLZ.stopAnimation();
        }
        if (this.aMl) {
            super.setImageBitmap(BitmapHelper.getCashBitmap(d.g.icon_default_avatar100));
        } else {
            super.setImageBitmap(BitmapHelper.getCashBitmap(d.g.btn_see_default));
        }
        this.ahx = 2;
        Ht();
    }

    public void Hz() {
        if (this.ahx != 1 && this.ahx != 2) {
            int size = this.aLQ.size();
            if (size > 0) {
                this.aLQ.add(Float.valueOf(this.aLQ.get(size - 1).floatValue() * 1.25f));
            } else {
                this.aLQ.add(Float.valueOf(this.aLR));
            }
            HC();
        }
    }

    public void HA() {
        if (this.ahx != 1 && this.ahx != 2) {
            int size = this.aLQ.size();
            if (size > 1) {
                this.aLQ.remove(size - 1);
            }
            HC();
        }
    }

    public void HB() {
        Hu();
        if (this.ahx != 1 && this.ahx != 2 && this.mCurrentScale != this.aLR) {
            this.aLQ.clear();
            this.aLQ.add(Float.valueOf(this.aLR));
            this.mCurrentScale = this.aLR;
            this.aLT = this.mCurrentScale;
            HC();
        }
    }

    public boolean canZoomIn() {
        if (this.ahx == 1 || this.ahx == 2) {
            return false;
        }
        int size = this.aLQ.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.aLQ.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.aLV) && floatValue <= 5.0f;
    }

    public boolean canZoomOut() {
        if (this.ahx == 1 || this.ahx == 2) {
            return false;
        }
        int size = this.aLQ.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled()) {
            return false;
        }
        return size > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HC() {
        e(false, -1, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, int i, int i2) {
        float f;
        float f2;
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled()) {
            try {
                if (this.mMode != 2) {
                    int size = this.aLQ.size();
                    if (size > 0) {
                        f2 = this.aLQ.get(size - 1).floatValue();
                    } else {
                        f2 = this.aLR;
                    }
                    this.mCurrentScale = f2;
                }
                this.mMatrix.setScale(this.mCurrentScale, this.mCurrentScale);
                this.aLO = imageBitmap.getWidth() * this.mCurrentScale;
                this.aLP = imageBitmap.getHeight() * this.mCurrentScale;
                float width = this.aLT * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.aLT;
                this.aMg = this.mTop;
                this.aMh = 0;
                float f3 = this.aLO < ((float) this.mViewWidth) ? (int) ((this.mViewWidth - this.aLO) / 2.0f) : 0.0f;
                if (this.aLP < this.mViewHeight) {
                    f = (int) ((this.mViewHeight - this.aLP) / 2.0f);
                    if (this.aLW == 1 && f > this.mTop) {
                        f = this.mTop;
                    }
                    this.aMg = (int) (this.mTop - f);
                    this.aMh = this.mTop - this.aMg;
                } else {
                    f = 0.0f;
                }
                this.aMi = (int) f3;
                this.mMatrix.postTranslate(f3, f);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    int width2 = i > getWidth() ? getWidth() : i;
                    if (this.aLO <= screenWidth) {
                        width2 = 0;
                    } else if (this.aLO > screenWidth && this.aLO / 2.0f < screenWidth) {
                        width2 = (int) (width2 - (this.aLO / 4.0f));
                    }
                    scrollX = width2;
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.aLO - width) / 2.0f);
                    }
                    if (this.aLO <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.aLO) {
                        scrollX = (int) (this.aLO - getWidth());
                    }
                }
                if (scrollX > 0 && this.aLO - scrollX < getWidth()) {
                    scrollX = (int) (this.aLO - getWidth());
                }
                int i3 = this.mMode == 2 ? ((int) ((this.aLP - height) / 2.0f)) + scrollY : scrollY;
                if (this.aLP <= getHeight()) {
                    i3 = 0;
                } else if (getHeight() + i3 > this.aLP) {
                    i3 = (int) (this.aLP - getHeight());
                }
                setHorizontalScrollBarEnabled(false);
                setVerticalScrollBarEnabled(false);
                if (scrollX < 0) {
                    scrollX = 0;
                }
                scrollTo(scrollX, i3 >= 0 ? i3 : 0);
                setImageMatrix(this.mMatrix);
                Hu();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0064a extends Animation {
        private long aMA;
        private int aMB;
        private long aMC;
        private long aMD;
        private boolean aMx = false;
        private boolean aMy = false;
        private long aMz;
        private int mStartY;

        public C0064a() {
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
            this.aMz = f;
            this.aMA = f2;
            this.aMC = Math.abs((f * 1000.0f) / 2500.0f);
            this.aMD = Math.abs((f2 * 1000.0f) / 2500.0f);
            setDuration(Math.max(this.aMC, this.aMD));
            setInterpolator(a.this.aMn);
            this.aMB = a.this.getScrollX();
            this.mStartY = a.this.getScrollY();
            this.aMx = true;
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
            if (this.aMC > this.aMD) {
                j = ((float) this.aMC) * f;
            } else {
                j = ((float) this.aMD) * f;
            }
            float f2 = ((float) (j > this.aMC ? this.aMC : j)) / 1000.0f;
            if (this.aMz > 0) {
                i = this.aMB - ((int) (f2 * (((float) this.aMz) - ((2500.0f * f2) / 2.0f))));
            } else {
                i = this.aMB - ((int) (f2 * (((float) this.aMz) + ((2500.0f * f2) / 2.0f))));
            }
            if (j > this.aMD) {
                j = this.aMD;
            }
            float f3 = ((float) j) / 1000.0f;
            if (this.aMA > 0) {
                i2 = this.mStartY - ((int) (f3 * (((float) this.aMA) - ((2500.0f * f3) / 2.0f))));
            } else {
                i2 = this.mStartY - ((int) (f3 * (((float) this.aMA) + ((2500.0f * f3) / 2.0f))));
            }
            if (a.this.aLP + a.this.mTop + a.this.mBottom > a.this.getHeight()) {
                if (i2 < (-a.this.aMg)) {
                    i2 = -a.this.aMg;
                }
                if (a.this.getHeight() + i2 > a.this.aLP + a.this.mBottom + a.this.aMh) {
                    i2 = (int) ((a.this.aLP - a.this.getHeight()) + a.this.mBottom + a.this.aMh);
                }
            } else {
                i2 = 0;
            }
            if (a.this.aLO > a.this.getWidth()) {
                int width = ((float) (a.this.getWidth() + i)) > a.this.aLO ? (int) (a.this.aLO - a.this.getWidth()) : i;
                if (width >= 0) {
                    i3 = width;
                }
            }
            a.this.scrollTo(i3, i2);
            a.this.invalidate();
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            if (!this.aMy) {
                if (a.this.aLU) {
                    this.aMx = false;
                    return false;
                }
                try {
                    if (super.getTransformation(j, transformation)) {
                        return true;
                    }
                    this.aMx = false;
                    return false;
                } catch (Exception e) {
                    this.aMx = false;
                    return false;
                }
            }
            this.aMy = false;
            this.aMx = false;
            return false;
        }

        public boolean HG() {
            return this.aMx;
        }

        public void stopAnimation() {
            this.aMy = true;
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.aLY = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.auW = onLongClickListener;
    }

    public void setGifSetListener(d dVar) {
        this.auY = dVar;
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
    public void HD() {
        long j;
        c poll = this.aMq.poll();
        if (poll == null) {
            this.aMv = true;
            return;
        }
        this.aMv = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.aMp != null) {
            j = this.aMp.delay - (currentTimeMillis - this.aMu);
            this.aMr.offer(this.aMp);
        } else {
            j = 0;
        }
        this.aMp = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public c HE() {
        c poll = this.aMr.poll();
        if (poll == null) {
            poll = new c();
            try {
                poll.aME = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
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
        public Bitmap aME;
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
            while (a.this.mState == 1 && a.this.aMe != null && a.this.aMo > 0 && a.this.width > 0 && a.this.height > 0) {
                try {
                    a.this.aMe.T(a.this.aMs);
                    c HE = a.this.HE();
                    if (HE.aME == null || (HE.aME.getWidth() != a.this.width && HE.aME.getHeight() != a.this.height)) {
                        try {
                            HE.aME = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_8888);
                        } catch (OutOfMemoryError e) {
                            TbadkCoreApplication.getInst().onAppMemoryLow();
                            try {
                                HE.aME = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_4444);
                            } catch (OutOfMemoryError e2) {
                                TbadkCoreApplication.getInst().onAppMemoryLow();
                            }
                        } catch (Throwable th) {
                            BdLog.e(th.getMessage());
                        }
                    }
                    a.this.aMe.a(HE.aME, null);
                    HE.delay = a.this.aMe.U(a.this.aMs);
                    a.B(a.this);
                    if (HE.aME == null) {
                        a.B(a.this);
                    }
                    a.this.aMs %= a.this.aMo;
                    a.this.aMq.put(HE);
                    if (a.this.aMv) {
                        a.this.mHandler.sendEmptyMessage(1);
                    }
                } catch (Exception e3) {
                    return;
                }
            }
        }
    }

    public boolean HF() {
        return this.aMk;
    }

    public void setLoadBigImage(boolean z) {
        this.aMk = z;
    }

    public int getBottomOffset() {
        return this.aMh;
    }

    public int getLeftOffset() {
        return this.aMi;
    }
}
