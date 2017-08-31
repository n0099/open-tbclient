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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends ImageView {
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
    private e aMW;
    private View.OnClickListener aMX;
    private C0067a aMY;
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
    private Interpolator aNm;
    private int aNn;
    private c aNo;
    private BlockingLinkedDeque<c> aNp;
    private BlockingLinkedDeque<c> aNq;
    private volatile int aNr;
    private b aNs;
    private volatile long aNt;
    private volatile boolean aNu;
    private int aim;
    private View.OnLongClickListener avB;
    private d avD;
    private int avE;
    private int height;
    private int mBottom;
    private float mCurrentScale;
    private GestureDetector mGestureDetector;
    public Handler mHandler;
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
        int i = aVar.aNr;
        aVar.aNr = i + 1;
        return i;
    }

    public void setIsHeadImage(boolean z) {
        this.aNk = z;
    }

    public a(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aMS = false;
        this.aMT = null;
        this.avE = 0;
        this.aMU = 1300;
        this.aMV = 0;
        this.aMW = null;
        this.aMX = null;
        this.avB = null;
        this.avD = null;
        this.aMZ = 1.0f;
        this.aim = 0;
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
        this.aNm = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aNn = 0;
        this.aNo = null;
        this.aNp = new BlockingLinkedDeque<>(5);
        this.aNq = new BlockingLinkedDeque<>(6);
        this.aNr = 0;
        this.aNt = 0L;
        this.mState = 0;
        this.aNu = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.a.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        a.this.HK();
                        break;
                    case 1:
                        if (a.this.aNu) {
                            a.this.HK();
                            break;
                        }
                        break;
                    case 2:
                        a.this.invalidate();
                        a.this.aNt = System.currentTimeMillis();
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
        this.avE = 0;
        this.aMU = 1300;
        this.aMV = 0;
        this.aMW = null;
        this.aMX = null;
        this.avB = null;
        this.avD = null;
        this.aMZ = 1.0f;
        this.aim = 0;
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
        this.aNm = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aNn = 0;
        this.aNo = null;
        this.aNp = new BlockingLinkedDeque<>(5);
        this.aNq = new BlockingLinkedDeque<>(6);
        this.aNr = 0;
        this.aNt = 0L;
        this.mState = 0;
        this.aNu = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.a.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        a.this.HK();
                        break;
                    case 1:
                        if (a.this.aNu) {
                            a.this.HK();
                            break;
                        }
                        break;
                    case 2:
                        a.this.invalidate();
                        a.this.aNt = System.currentTimeMillis();
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
        this.avE = 0;
        this.aMU = 1300;
        this.aMV = 0;
        this.aMW = null;
        this.aMX = null;
        this.avB = null;
        this.avD = null;
        this.aMZ = 1.0f;
        this.aim = 0;
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
        this.aNm = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aNn = 0;
        this.aNo = null;
        this.aNp = new BlockingLinkedDeque<>(5);
        this.aNq = new BlockingLinkedDeque<>(6);
        this.aNr = 0;
        this.aNt = 0L;
        this.mState = 0;
        this.aNu = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.a.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        a.this.HK();
                        break;
                    case 1:
                        if (a.this.aNu) {
                            a.this.HK();
                            break;
                        }
                        break;
                    case 2:
                        a.this.invalidate();
                        a.this.aNt = System.currentTimeMillis();
                        a.this.mHandler.sendEmptyMessage(0);
                        break;
                }
                return false;
            }
        });
        initData();
    }

    public int getImageType() {
        return this.aim;
    }

    public void setImageMode(int i) {
        this.aMV = i;
    }

    public void i(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.avE = i;
    }

    public void Hy() {
        this.aNb = false;
        this.aMS = false;
        this.mMode = 0;
        HC();
        if (this.mCurrentScale < this.aMP) {
            this.mCurrentScale = this.aMP;
            HJ();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.aMS = true;
                this.aNa = false;
                this.aNb = false;
                break;
            case 1:
                Hy();
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
                        if (this.aim != 1 && this.aim != 2) {
                            float m = m(motionEvent);
                            if (m >= 0.0f && Math.abs(this.aMZ - m) >= 10.0f) {
                                if (Math.abs(this.aMZ - m) > 100.0f) {
                                    this.aMZ = m;
                                    break;
                                } else {
                                    float f = m / this.aMZ;
                                    this.aMZ = m;
                                    this.aMR = this.mCurrentScale;
                                    this.mCurrentScale *= f;
                                    if (this.mCurrentScale > this.aMQ) {
                                        this.mCurrentScale = this.aMQ;
                                    }
                                    if (this.mCurrentScale < this.aMP / 4.0f) {
                                        this.mCurrentScale = this.aMP / 4.0f;
                                    }
                                    HJ();
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
            HA();
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public boolean Hz() {
        return this.aMP == this.mCurrentScale;
    }

    private void HA() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            if (this.aMV == 0) {
                float width = this.mViewWidth / imageBitmap.getWidth();
                float height = this.mViewHeight / imageBitmap.getHeight();
                if (this.aNk) {
                    if (this.aim == 2) {
                        this.aMP = 2.5f;
                    } else {
                        this.aMP = Math.min(width, height);
                    }
                } else if (this.aim == 2) {
                    this.aMP = 1.0f;
                } else {
                    float f = this.aNl;
                    float f2 = f >= 1.0f ? f : 1.0f;
                    if (imageBitmap.getWidth() * f2 < this.mViewWidth && imageBitmap.getHeight() * f2 < this.mViewHeight) {
                        this.aMP = f2;
                    } else {
                        this.aMP = Math.min(width, height);
                    }
                }
            } else {
                this.aMP = Math.max(this.mViewWidth / imageBitmap.getWidth(), ((this.mViewHeight - this.mTop) - this.mBottom) / imageBitmap.getHeight());
            }
            this.aMQ = this.aMU / (imageBitmap.getWidth() * imageBitmap.getHeight());
            this.aMQ = FloatMath.sqrt(this.aMQ);
            if (this.aMQ > 10.0f) {
                this.aMQ = 10.0f;
            }
            this.aMO.clear();
            this.aMO.add(Float.valueOf(this.aMP));
            this.mCurrentScale = this.aMP;
            this.aMR = this.mCurrentScale;
            HJ();
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

    private void HB() {
        if (this.aMW != null) {
            this.aMW.a(this, canZoomIn(), canZoomOut());
        }
    }

    public void setOnSizeChangedListener(e eVar) {
        this.aMW = eVar;
    }

    public byte[] getImageData() {
        return this.aMT;
    }

    public void setImageData(byte[] bArr) {
        this.aMT = bArr;
    }

    public Bitmap getGifCache() {
        return this.aNe;
    }

    public void setGifCache(Bitmap bitmap) {
        this.aNe = bitmap;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        boolean z;
        int i4;
        if (this.aim == 2 && this.aNi != 0 && !this.aMY.HN()) {
            int width = getWidth();
            int height = getHeight();
            Drawable drawable = getDrawable();
            float f = 0.0f;
            float f2 = height * 0.3f;
            float f3 = width;
            float f4 = (1.0f - 0.3f) * height;
            if (this.aNk && drawable != null) {
                Rect bounds = drawable.getBounds();
                int i5 = bounds.right - bounds.left;
                int i6 = bounds.bottom - bounds.top;
                f = (width / 2) - (i5 * 2.5f);
                f2 = (height / 2) - (i6 * 2.5f);
                f3 = (i5 * 2.5f) + (width / 2);
                f4 = (i6 * 2.5f) + (height / 2);
            }
            this.mPaint.setColor(aj.getColor(this.aNi));
            canvas.drawRect(f, f2, f3, f4, this.mPaint);
            this.mPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        }
        super.onDraw(canvas);
        if (this.aim == 1 && this.aNe != null && !this.aNe.isRecycled()) {
            int width2 = this.aNe.getWidth();
            int height2 = this.aNe.getHeight();
            int width3 = getWidth();
            int height3 = getHeight();
            int i7 = (width3 - width2) >> 1;
            int i8 = (height3 - height2) >> 1;
            float f5 = this.aNl;
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
            if (this.aNc == 1 && this.aNd != null && this.aNo != null && this.aNo.aND != null) {
                if (z) {
                    canvas.drawBitmap(this.aNo.aND, i3, i2, (Paint) null);
                } else {
                    canvas.drawBitmap(this.aNo.aND, this.mMatrix, this.mPaint);
                }
                invalidate();
            } else if (z) {
                canvas.drawBitmap(this.aNe, i3, i2, (Paint) null);
            } else {
                canvas.drawBitmap(this.aNe, this.mMatrix, this.mPaint);
            }
        }
    }

    public void play() {
        com.baidu.adp.widget.a.a aVar;
        if (this.aim == 1) {
            if (this.aNd == null) {
                if (this.aNs != null) {
                    this.aNs.interrupt();
                    this.aNs = null;
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
                            this.aNr = 0;
                            this.aNn = this.aNd.dE();
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
                this.aNu = true;
                this.aNs = new b();
                this.aNp.clear();
                this.aNq.clear();
                this.mState = 1;
                this.aNs.start();
            }
        }
    }

    public void pause() {
        if (this.aim == 1) {
            this.mState = 0;
            if (this.aNs != null) {
                this.aNs.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.aim == 1) {
            this.mState = 0;
            if (this.aNs != null) {
                this.aNs.interrupt();
                this.aNs = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.aNu = true;
            this.aNo = null;
            this.aNq.clear();
            this.aNp.clear();
            this.width = 0;
            this.height = 0;
            this.aNr = 0;
            this.aNn = 0;
            if (this.aNd != null) {
                this.aNd = null;
            }
        }
    }

    private void initData() {
        this.aNl = k.af(getContext());
        this.aMU = k.ae(getContext()) * k.ad(getContext()) * 2;
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
        this.aMY = new C0067a();
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWillNotDraw(false);
        scrollTo(0, 0);
        this.mGestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.a.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (a.this.aim != 2 && (Math.abs(f) > 200.0f || Math.abs(f2) > 200.0f)) {
                    a.this.aMY.d(f, f2);
                    a.this.startAnimation(a.this.aMY);
                }
                return super.onFling(motionEvent, motionEvent2, f, f2);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (a.this.aim != 1 && a.this.aim != 2) {
                    a.this.mMode = 2;
                    if (a.this.mCurrentScale > a.this.aMP) {
                        a.this.mCurrentScale = a.this.aMP;
                        a.this.aMR = a.this.mCurrentScale;
                        a.this.HJ();
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
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                int i;
                int scrollY;
                a.this.aNa = true;
                if (a.this.aMV == 0 && a.this.aNb) {
                    return false;
                }
                int scrollX = a.this.getScrollX();
                if (a.this.aMM >= a.this.getWidth()) {
                    scrollX = (int) (scrollX + f);
                    if (a.this.aMV == 0) {
                        i = scrollX >= 0 ? scrollX : 0;
                        if (a.this.getWidth() + i > a.this.aMM) {
                            i = (int) (a.this.aMM - a.this.getWidth());
                        }
                        scrollY = a.this.getScrollY();
                        if (a.this.aMN + a.this.mTop + a.this.mBottom >= a.this.getHeight()) {
                            scrollY = (int) (scrollY + f2);
                            if (a.this.aMV == 0) {
                                if (scrollY < (-a.this.aNf)) {
                                    scrollY = -a.this.aNf;
                                }
                                if (a.this.getHeight() + scrollY > a.this.aMN + a.this.mBottom + a.this.aNg) {
                                    scrollY = (int) ((a.this.aMN - a.this.getHeight()) + a.this.mBottom + a.this.aNg);
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
                if (a.this.aMN + a.this.mTop + a.this.mBottom >= a.this.getHeight()) {
                }
                if (i == a.this.getScrollX()) {
                }
                a.this.scrollTo(i, scrollY);
                a.this.invalidate();
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (a.this.avB != null && !a.this.aNa) {
                    a.this.avB.onLongClick(a.this);
                }
                super.onLongPress(motionEvent);
            }
        });
    }

    private void HC() {
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
    protected int computeHorizontalScrollRange() {
        return (int) this.aMM;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.aMN;
    }

    public boolean HD() {
        if (this.aim == 1 || this.aim == 2) {
            return true;
        }
        return !this.aNb && getScrollX() >= ((int) (this.aMM - ((float) getWidth()))) + (-1);
    }

    public boolean HE() {
        if (this.aim == 1 || this.aim == 2) {
            return true;
        }
        return !this.aNb && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.aMY.HN()) {
            this.aMY.stopAnimation();
        }
        this.aNi = 0;
        super.setImageBitmap(bitmap);
        HA();
        this.aim = 0;
    }

    public void f(Bitmap bitmap) {
        Bitmap imageBitmap = getImageBitmap();
        if (bitmap != null && !bitmap.isRecycled()) {
            if (imageBitmap != null && (imageBitmap.getWidth() != bitmap.getWidth() || imageBitmap.getHeight() != bitmap.getHeight())) {
                setImageBitmap(bitmap);
                return;
            }
            if (this.aMY.HN()) {
                this.aMY.stopAnimation();
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            super.setImageBitmap(bitmap);
            super.setImageMatrix(this.mMatrix);
            scrollTo(scrollX, scrollY);
            this.aim = 0;
        }
    }

    public void a(byte[] bArr, Bitmap bitmap) {
        if (this.aMY.HN()) {
            this.aMY.stopAnimation();
        }
        super.setImageDrawable(null);
        stop();
        HA();
        this.aim = 1;
        this.aNe = bitmap;
        this.aMT = bArr;
        if (this.avD != null) {
            this.avD.a(this);
        }
    }

    public void onDestroy() {
        if (this.aMY.HN()) {
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
    }

    public void release() {
        if (this.aMY.HN()) {
            this.aMY.stopAnimation();
        }
        stop();
        super.setImageDrawable(null);
        this.aNe = null;
    }

    public void HF() {
        if (this.aMY.HN()) {
            this.aMY.stopAnimation();
        }
        if (this.aNk) {
            super.setImageBitmap(BitmapHelper.getCashBitmap(d.g.icon_default_avatar100));
        } else {
            super.setImageBitmap(BitmapHelper.getCashBitmap(d.g.btn_see_default));
        }
        this.aim = 2;
        HA();
    }

    public void HG() {
        if (this.aim != 1 && this.aim != 2) {
            int size = this.aMO.size();
            if (size > 0) {
                this.aMO.add(Float.valueOf(this.aMO.get(size - 1).floatValue() * 1.25f));
            } else {
                this.aMO.add(Float.valueOf(this.aMP));
            }
            HJ();
        }
    }

    public void HH() {
        if (this.aim != 1 && this.aim != 2) {
            int size = this.aMO.size();
            if (size > 1) {
                this.aMO.remove(size - 1);
            }
            HJ();
        }
    }

    public void HI() {
        HB();
        if (this.aim != 1 && this.aim != 2 && this.mCurrentScale != this.aMP) {
            this.aMO.clear();
            this.aMO.add(Float.valueOf(this.aMP));
            this.mCurrentScale = this.aMP;
            this.aMR = this.mCurrentScale;
            HJ();
        }
    }

    public boolean canZoomIn() {
        if (this.aim == 1 || this.aim == 2) {
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
        if (this.aim == 1 || this.aim == 2) {
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
    public void HJ() {
        d(false, -1, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z, int i, int i2) {
        float f;
        float f2;
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled()) {
            try {
                if (this.mMode != 2) {
                    int size = this.aMO.size();
                    if (size > 0) {
                        f2 = this.aMO.get(size - 1).floatValue();
                    } else {
                        f2 = this.aMP;
                    }
                    this.mCurrentScale = f2;
                }
                this.mMatrix.setScale(this.mCurrentScale, this.mCurrentScale);
                this.aMM = imageBitmap.getWidth() * this.mCurrentScale;
                this.aMN = imageBitmap.getHeight() * this.mCurrentScale;
                float width = this.aMR * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.aMR;
                this.aNf = this.mTop;
                this.aNg = 0;
                float f3 = this.aMM < ((float) this.mViewWidth) ? (int) ((this.mViewWidth - this.aMM) / 2.0f) : 0.0f;
                if (this.aMN < this.mViewHeight) {
                    f = (int) ((this.mViewHeight - this.aMN) / 2.0f);
                    if (this.aMV == 1 && f > this.mTop) {
                        f = this.mTop;
                    }
                    this.aNf = (int) (this.mTop - f);
                    this.aNg = this.mTop - this.aNf;
                } else {
                    f = 0.0f;
                }
                this.aNh = (int) f3;
                this.mMatrix.postTranslate(f3, f);
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
                HB();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0067a extends Animation {
        private int aNA;
        private long aNB;
        private long aNC;
        private boolean aNw = false;
        private boolean aNx = false;
        private long aNy;
        private long aNz;
        private int mStartY;

        public C0067a() {
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
            this.aNy = f;
            this.aNz = f2;
            this.aNB = Math.abs((f * 1000.0f) / 2500.0f);
            this.aNC = Math.abs((f2 * 1000.0f) / 2500.0f);
            setDuration(Math.max(this.aNB, this.aNC));
            setInterpolator(a.this.aNm);
            this.aNA = a.this.getScrollX();
            this.mStartY = a.this.getScrollY();
            this.aNw = true;
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
            if (this.aNB > this.aNC) {
                j = ((float) this.aNB) * f;
            } else {
                j = ((float) this.aNC) * f;
            }
            float f2 = ((float) (j > this.aNB ? this.aNB : j)) / 1000.0f;
            if (this.aNy > 0) {
                i = this.aNA - ((int) (f2 * (((float) this.aNy) - ((2500.0f * f2) / 2.0f))));
            } else {
                i = this.aNA - ((int) (f2 * (((float) this.aNy) + ((2500.0f * f2) / 2.0f))));
            }
            if (j > this.aNC) {
                j = this.aNC;
            }
            float f3 = ((float) j) / 1000.0f;
            if (this.aNz > 0) {
                i2 = this.mStartY - ((int) (f3 * (((float) this.aNz) - ((2500.0f * f3) / 2.0f))));
            } else {
                i2 = this.mStartY - ((int) (f3 * (((float) this.aNz) + ((2500.0f * f3) / 2.0f))));
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
            if (!this.aNx) {
                if (a.this.aMS) {
                    this.aNw = false;
                    return false;
                }
                try {
                    if (super.getTransformation(j, transformation)) {
                        return true;
                    }
                    this.aNw = false;
                    return false;
                } catch (Exception e) {
                    this.aNw = false;
                    return false;
                }
            }
            this.aNx = false;
            this.aNw = false;
            return false;
        }

        public boolean HN() {
            return this.aNw;
        }

        public void stopAnimation() {
            this.aNx = true;
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.aMX = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.avB = onLongClickListener;
    }

    public void setGifSetListener(d dVar) {
        this.avD = dVar;
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
    public void HK() {
        long j;
        c poll = this.aNp.poll();
        if (poll == null) {
            this.aNu = true;
            return;
        }
        this.aNu = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.aNo != null) {
            j = this.aNo.delay - (currentTimeMillis - this.aNt);
            this.aNq.offer(this.aNo);
        } else {
            j = 0;
        }
        this.aNo = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public c HL() {
        c poll = this.aNq.poll();
        if (poll == null) {
            poll = new c();
            try {
                poll.aND = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
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
        public Bitmap aND;
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
            while (a.this.mState == 1 && a.this.aNd != null && a.this.aNn > 0 && a.this.width > 0 && a.this.height > 0) {
                try {
                    a.this.aNd.T(a.this.aNr);
                    c HL = a.this.HL();
                    if (HL.aND == null || (HL.aND.getWidth() != a.this.width && HL.aND.getHeight() != a.this.height)) {
                        try {
                            HL.aND = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_8888);
                        } catch (OutOfMemoryError e) {
                            TbadkCoreApplication.getInst().onAppMemoryLow();
                            try {
                                HL.aND = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_4444);
                            } catch (OutOfMemoryError e2) {
                                TbadkCoreApplication.getInst().onAppMemoryLow();
                            }
                        } catch (Throwable th) {
                            BdLog.e(th.getMessage());
                        }
                    }
                    a.this.aNd.a(HL.aND, null);
                    HL.delay = a.this.aNd.U(a.this.aNr);
                    a.B(a.this);
                    if (HL.aND == null) {
                        a.B(a.this);
                    }
                    a.this.aNr %= a.this.aNn;
                    a.this.aNp.put(HL);
                    if (a.this.aNu) {
                        a.this.mHandler.sendEmptyMessage(1);
                    }
                } catch (Exception e3) {
                    return;
                }
            }
        }
    }

    public boolean HM() {
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
