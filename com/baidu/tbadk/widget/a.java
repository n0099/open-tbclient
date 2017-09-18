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
    private float aMJ;
    private float aMK;
    private ArrayList<Float> aML;
    private float aMM;
    private float aMN;
    private float aMO;
    private boolean aMP;
    private byte[] aMQ;
    private int aMR;
    private int aMS;
    private e aMT;
    private View.OnClickListener aMU;
    private C0066a aMV;
    private float aMW;
    private boolean aMX;
    private boolean aMY;
    private int aMZ;
    private volatile com.baidu.adp.gif.b aNa;
    private Bitmap aNb;
    private int aNc;
    private int aNd;
    private int aNe;
    private int aNf;
    private boolean aNg;
    private boolean aNh;
    private float aNi;
    private Interpolator aNj;
    private int aNk;
    private c aNl;
    private BlockingLinkedDeque<c> aNm;
    private BlockingLinkedDeque<c> aNn;
    private volatile int aNo;
    private b aNp;
    private volatile long aNq;
    private volatile boolean aNr;
    private int ail;
    private d avA;
    private int avB;
    private View.OnLongClickListener avy;
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
        int i = aVar.aNo;
        aVar.aNo = i + 1;
        return i;
    }

    public void setIsHeadImage(boolean z) {
        this.aNh = z;
    }

    public a(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aMP = false;
        this.aMQ = null;
        this.avB = 0;
        this.aMR = 1300;
        this.aMS = 0;
        this.aMT = null;
        this.aMU = null;
        this.avy = null;
        this.avA = null;
        this.aMW = 1.0f;
        this.ail = 0;
        this.mMode = 0;
        this.aMX = false;
        this.aMY = false;
        this.aMZ = 0;
        this.aNa = null;
        this.aNb = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aNc = 0;
        this.aNd = 0;
        this.aNe = 0;
        this.aNf = 0;
        this.aNj = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aNk = 0;
        this.aNl = null;
        this.aNm = new BlockingLinkedDeque<>(5);
        this.aNn = new BlockingLinkedDeque<>(6);
        this.aNo = 0;
        this.aNq = 0L;
        this.mState = 0;
        this.aNr = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.a.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        a.this.HK();
                        break;
                    case 1:
                        if (a.this.aNr) {
                            a.this.HK();
                            break;
                        }
                        break;
                    case 2:
                        a.this.invalidate();
                        a.this.aNq = System.currentTimeMillis();
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
        this.aMP = false;
        this.aMQ = null;
        this.avB = 0;
        this.aMR = 1300;
        this.aMS = 0;
        this.aMT = null;
        this.aMU = null;
        this.avy = null;
        this.avA = null;
        this.aMW = 1.0f;
        this.ail = 0;
        this.mMode = 0;
        this.aMX = false;
        this.aMY = false;
        this.aMZ = 0;
        this.aNa = null;
        this.aNb = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aNc = 0;
        this.aNd = 0;
        this.aNe = 0;
        this.aNf = 0;
        this.aNj = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aNk = 0;
        this.aNl = null;
        this.aNm = new BlockingLinkedDeque<>(5);
        this.aNn = new BlockingLinkedDeque<>(6);
        this.aNo = 0;
        this.aNq = 0L;
        this.mState = 0;
        this.aNr = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.a.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        a.this.HK();
                        break;
                    case 1:
                        if (a.this.aNr) {
                            a.this.HK();
                            break;
                        }
                        break;
                    case 2:
                        a.this.invalidate();
                        a.this.aNq = System.currentTimeMillis();
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
        this.aMP = false;
        this.aMQ = null;
        this.avB = 0;
        this.aMR = 1300;
        this.aMS = 0;
        this.aMT = null;
        this.aMU = null;
        this.avy = null;
        this.avA = null;
        this.aMW = 1.0f;
        this.ail = 0;
        this.mMode = 0;
        this.aMX = false;
        this.aMY = false;
        this.aMZ = 0;
        this.aNa = null;
        this.aNb = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aNc = 0;
        this.aNd = 0;
        this.aNe = 0;
        this.aNf = 0;
        this.aNj = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aNk = 0;
        this.aNl = null;
        this.aNm = new BlockingLinkedDeque<>(5);
        this.aNn = new BlockingLinkedDeque<>(6);
        this.aNo = 0;
        this.aNq = 0L;
        this.mState = 0;
        this.aNr = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.a.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        a.this.HK();
                        break;
                    case 1:
                        if (a.this.aNr) {
                            a.this.HK();
                            break;
                        }
                        break;
                    case 2:
                        a.this.invalidate();
                        a.this.aNq = System.currentTimeMillis();
                        a.this.mHandler.sendEmptyMessage(0);
                        break;
                }
                return false;
            }
        });
        initData();
    }

    public int getImageType() {
        return this.ail;
    }

    public void setImageMode(int i) {
        this.aMS = i;
    }

    public void i(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.avB = i;
    }

    public void Hy() {
        this.aMY = false;
        this.aMP = false;
        this.mMode = 0;
        HC();
        if (this.mCurrentScale < this.aMM) {
            this.mCurrentScale = this.aMM;
            HJ();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.aMP = true;
                this.aMX = false;
                this.aMY = false;
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
            this.aMW = m(motionEvent);
            if (this.aMW > 10.0f) {
                this.mMode = 2;
            }
        }
        if (this.mMode == 2 || !this.mGestureDetector.onTouchEvent(motionEvent)) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.aMX = true;
                        this.aMY = true;
                        if (this.ail != 1 && this.ail != 2) {
                            float m = m(motionEvent);
                            if (m >= 0.0f && Math.abs(this.aMW - m) >= 10.0f) {
                                if (Math.abs(this.aMW - m) > 100.0f) {
                                    this.aMW = m;
                                    break;
                                } else {
                                    float f = m / this.aMW;
                                    this.aMW = m;
                                    this.aMO = this.mCurrentScale;
                                    this.mCurrentScale *= f;
                                    if (this.mCurrentScale > this.aMN) {
                                        this.mCurrentScale = this.aMN;
                                    }
                                    if (this.mCurrentScale < this.aMM / 4.0f) {
                                        this.mCurrentScale = this.aMM / 4.0f;
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
        return this.aMM == this.mCurrentScale;
    }

    private void HA() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            if (this.aMS == 0) {
                float width = this.mViewWidth / imageBitmap.getWidth();
                float height = this.mViewHeight / imageBitmap.getHeight();
                if (this.aNh) {
                    if (this.ail == 2) {
                        this.aMM = 2.5f;
                    } else {
                        this.aMM = Math.min(width, height);
                    }
                } else if (this.ail == 2) {
                    this.aMM = 1.0f;
                } else {
                    float f = this.aNi;
                    float f2 = f >= 1.0f ? f : 1.0f;
                    if (imageBitmap.getWidth() * f2 < this.mViewWidth && imageBitmap.getHeight() * f2 < this.mViewHeight) {
                        this.aMM = f2;
                    } else {
                        this.aMM = Math.min(width, height);
                    }
                }
            } else {
                this.aMM = Math.max(this.mViewWidth / imageBitmap.getWidth(), ((this.mViewHeight - this.mTop) - this.mBottom) / imageBitmap.getHeight());
            }
            this.aMN = this.aMR / (imageBitmap.getWidth() * imageBitmap.getHeight());
            this.aMN = FloatMath.sqrt(this.aMN);
            if (this.aMN > 10.0f) {
                this.aMN = 10.0f;
            }
            this.aML.clear();
            this.aML.add(Float.valueOf(this.aMM));
            this.mCurrentScale = this.aMM;
            this.aMO = this.mCurrentScale;
            HJ();
            return;
        }
        this.aMJ = 0.0f;
        this.aMK = 0.0f;
        this.aMM = 1.0f;
        this.aMN = 1.0f;
        this.mCurrentScale = 1.0f;
        this.aMO = this.mCurrentScale;
        this.aML.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    private void HB() {
        if (this.aMT != null) {
            this.aMT.a(this, canZoomIn(), canZoomOut());
        }
    }

    public void setOnSizeChangedListener(e eVar) {
        this.aMT = eVar;
    }

    public byte[] getImageData() {
        return this.aMQ;
    }

    public void setImageData(byte[] bArr) {
        this.aMQ = bArr;
    }

    public Bitmap getGifCache() {
        return this.aNb;
    }

    public void setGifCache(Bitmap bitmap) {
        this.aNb = bitmap;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        boolean z;
        int i4;
        if (this.ail == 2 && this.aNf != 0 && !this.aMV.HN()) {
            int width = getWidth();
            int height = getHeight();
            Drawable drawable = getDrawable();
            float f = 0.0f;
            float f2 = height * 0.3f;
            float f3 = width;
            float f4 = (1.0f - 0.3f) * height;
            if (this.aNh && drawable != null) {
                Rect bounds = drawable.getBounds();
                int i5 = bounds.right - bounds.left;
                int i6 = bounds.bottom - bounds.top;
                f = (width / 2) - (i5 * 2.5f);
                f2 = (height / 2) - (i6 * 2.5f);
                f3 = (i5 * 2.5f) + (width / 2);
                f4 = (i6 * 2.5f) + (height / 2);
            }
            this.mPaint.setColor(aj.getColor(this.aNf));
            canvas.drawRect(f, f2, f3, f4, this.mPaint);
            this.mPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        }
        super.onDraw(canvas);
        if (this.ail == 1 && this.aNb != null && !this.aNb.isRecycled()) {
            int width2 = this.aNb.getWidth();
            int height2 = this.aNb.getHeight();
            int width3 = getWidth();
            int height3 = getHeight();
            int i7 = (width3 - width2) >> 1;
            int i8 = (height3 - height2) >> 1;
            float f5 = this.aNi;
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
            if (this.aMZ == 1 && this.aNa != null && this.aNl != null && this.aNl.aNA != null) {
                if (z) {
                    canvas.drawBitmap(this.aNl.aNA, i3, i2, (Paint) null);
                } else {
                    canvas.drawBitmap(this.aNl.aNA, this.mMatrix, this.mPaint);
                }
                invalidate();
            } else if (z) {
                canvas.drawBitmap(this.aNb, i3, i2, (Paint) null);
            } else {
                canvas.drawBitmap(this.aNb, this.mMatrix, this.mPaint);
            }
        }
    }

    public void play() {
        com.baidu.adp.widget.a.a aVar;
        if (this.ail == 1) {
            if (this.aNa == null) {
                if (this.aNp != null) {
                    this.aNp.interrupt();
                    this.aNp = null;
                }
                if (this.aMQ != null) {
                    try {
                        aVar = a.C0002a.dD().g(this.aMQ, 0, this.aMQ.length);
                    } catch (StackOverflowError e2) {
                        aVar = null;
                    }
                    if (aVar != null && aVar.getGif() != null) {
                        this.aNa = aVar.getGif();
                        if (this.aNa != null) {
                            this.aMZ = 1;
                            this.width = this.aNa.getWidth();
                            this.height = this.aNa.getHeight();
                            this.aNo = 0;
                            this.aNk = this.aNa.dE();
                        } else {
                            this.aMZ = 0;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            if (this.aNa != null && this.mState == 0) {
                this.aNr = true;
                this.aNp = new b();
                this.aNm.clear();
                this.aNn.clear();
                this.mState = 1;
                this.aNp.start();
            }
        }
    }

    public void pause() {
        if (this.ail == 1) {
            this.mState = 0;
            if (this.aNp != null) {
                this.aNp.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.ail == 1) {
            this.mState = 0;
            if (this.aNp != null) {
                this.aNp.interrupt();
                this.aNp = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.aNr = true;
            this.aNl = null;
            this.aNn.clear();
            this.aNm.clear();
            this.width = 0;
            this.height = 0;
            this.aNo = 0;
            this.aNk = 0;
            if (this.aNa != null) {
                this.aNa = null;
            }
        }
    }

    private void initData() {
        this.aNi = k.ag(getContext());
        this.aMR = k.af(getContext()) * k.ae(getContext()) * 2;
        if (this.aMR < 1690000) {
            this.aMR = 1690000;
        }
        this.aMJ = 0.0f;
        this.aMK = 0.0f;
        this.aML = new ArrayList<>();
        this.aMM = 1.0f;
        this.aMN = 1.0f;
        this.mCurrentScale = 1.0f;
        this.aMO = this.mCurrentScale;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.aMV = new C0066a();
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWillNotDraw(false);
        scrollTo(0, 0);
        this.mGestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.a.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (a.this.ail != 2 && (Math.abs(f) > 200.0f || Math.abs(f2) > 200.0f)) {
                    a.this.aMV.d(f, f2);
                    a.this.startAnimation(a.this.aMV);
                }
                return super.onFling(motionEvent, motionEvent2, f, f2);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (a.this.ail != 1 && a.this.ail != 2) {
                    a.this.mMode = 2;
                    if (a.this.mCurrentScale > a.this.aMM) {
                        a.this.mCurrentScale = a.this.aMM;
                        a.this.aMO = a.this.mCurrentScale;
                        a.this.HJ();
                        return true;
                    }
                    a.this.mCurrentScale = a.this.aMM * 2.0f;
                    a.this.d(true, (int) motionEvent.getX(), (int) motionEvent.getY());
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (a.this.aMU != null && !a.this.aMX) {
                    a.this.aMU.onClick(a.this);
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
                a.this.aMX = true;
                if (a.this.aMS == 0 && a.this.aMY) {
                    return false;
                }
                int scrollX = a.this.getScrollX();
                if (a.this.aMJ >= a.this.getWidth()) {
                    scrollX = (int) (scrollX + f);
                    if (a.this.aMS == 0) {
                        i = scrollX >= 0 ? scrollX : 0;
                        if (a.this.getWidth() + i > a.this.aMJ) {
                            i = (int) (a.this.aMJ - a.this.getWidth());
                        }
                        scrollY = a.this.getScrollY();
                        if (a.this.aMK + a.this.mTop + a.this.mBottom >= a.this.getHeight()) {
                            scrollY = (int) (scrollY + f2);
                            if (a.this.aMS == 0) {
                                if (scrollY < (-a.this.aNc)) {
                                    scrollY = -a.this.aNc;
                                }
                                if (a.this.getHeight() + scrollY > a.this.aMK + a.this.mBottom + a.this.aNd) {
                                    scrollY = (int) ((a.this.aMK - a.this.getHeight()) + a.this.mBottom + a.this.aNd);
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
                if (a.this.aMK + a.this.mTop + a.this.mBottom >= a.this.getHeight()) {
                }
                if (i == a.this.getScrollX()) {
                }
                a.this.scrollTo(i, scrollY);
                a.this.invalidate();
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (a.this.avy != null && !a.this.aMX) {
                    a.this.avy.onLongClick(a.this);
                }
                super.onLongPress(motionEvent);
            }
        });
    }

    private void HC() {
        int i = 0;
        int scrollX = getScrollX();
        if (this.aMJ >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.aMJ) {
                scrollX = (int) (this.aMJ - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.aMK + this.mTop + this.mBottom >= getHeight()) {
            i = scrollY < (-this.aNc) ? -this.aNc : scrollY;
            if (getHeight() + i > this.aMK + this.mBottom + this.aNd) {
                i = (int) ((this.aMK - getHeight()) + this.mBottom + this.aNd);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.aMJ;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.aMK;
    }

    public boolean HD() {
        if (this.ail == 1 || this.ail == 2) {
            return true;
        }
        return !this.aMY && getScrollX() >= ((int) (this.aMJ - ((float) getWidth()))) + (-1);
    }

    public boolean HE() {
        if (this.ail == 1 || this.ail == 2) {
            return true;
        }
        return !this.aMY && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.aMV.HN()) {
            this.aMV.stopAnimation();
        }
        this.aNf = 0;
        super.setImageBitmap(bitmap);
        HA();
        this.ail = 0;
    }

    public void f(Bitmap bitmap) {
        Bitmap imageBitmap = getImageBitmap();
        if (bitmap != null && !bitmap.isRecycled()) {
            if (imageBitmap != null && (imageBitmap.getWidth() != bitmap.getWidth() || imageBitmap.getHeight() != bitmap.getHeight())) {
                setImageBitmap(bitmap);
                return;
            }
            if (this.aMV.HN()) {
                this.aMV.stopAnimation();
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            super.setImageBitmap(bitmap);
            super.setImageMatrix(this.mMatrix);
            scrollTo(scrollX, scrollY);
            this.ail = 0;
        }
    }

    public void a(byte[] bArr, Bitmap bitmap) {
        if (this.aMV.HN()) {
            this.aMV.stopAnimation();
        }
        super.setImageDrawable(null);
        stop();
        HA();
        this.ail = 1;
        this.aNb = bitmap;
        this.aMQ = bArr;
        if (this.avA != null) {
            this.avA.a(this);
        }
    }

    public void onDestroy() {
        if (this.aMV.HN()) {
            this.aMV.stopAnimation();
        }
        super.setImageDrawable(null);
        this.aMQ = null;
        this.aNb = null;
        stop();
        if (this.aNa != null) {
            this.aNa.close();
            this.aNa = null;
        }
    }

    public void release() {
        if (this.aMV.HN()) {
            this.aMV.stopAnimation();
        }
        stop();
        super.setImageDrawable(null);
        this.aNb = null;
    }

    public void HF() {
        if (this.aMV.HN()) {
            this.aMV.stopAnimation();
        }
        if (this.aNh) {
            super.setImageBitmap(BitmapHelper.getCashBitmap(d.g.icon_default_avatar100));
        } else {
            super.setImageBitmap(BitmapHelper.getCashBitmap(d.g.btn_see_default));
        }
        this.ail = 2;
        HA();
    }

    public void HG() {
        if (this.ail != 1 && this.ail != 2) {
            int size = this.aML.size();
            if (size > 0) {
                this.aML.add(Float.valueOf(this.aML.get(size - 1).floatValue() * 1.25f));
            } else {
                this.aML.add(Float.valueOf(this.aMM));
            }
            HJ();
        }
    }

    public void HH() {
        if (this.ail != 1 && this.ail != 2) {
            int size = this.aML.size();
            if (size > 1) {
                this.aML.remove(size - 1);
            }
            HJ();
        }
    }

    public void HI() {
        HB();
        if (this.ail != 1 && this.ail != 2 && this.mCurrentScale != this.aMM) {
            this.aML.clear();
            this.aML.add(Float.valueOf(this.aMM));
            this.mCurrentScale = this.aMM;
            this.aMO = this.mCurrentScale;
            HJ();
        }
    }

    public boolean canZoomIn() {
        if (this.ail == 1 || this.ail == 2) {
            return false;
        }
        int size = this.aML.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.aML.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.aMR) && floatValue <= 5.0f;
    }

    public boolean canZoomOut() {
        if (this.ail == 1 || this.ail == 2) {
            return false;
        }
        int size = this.aML.size();
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
                    int size = this.aML.size();
                    if (size > 0) {
                        f2 = this.aML.get(size - 1).floatValue();
                    } else {
                        f2 = this.aMM;
                    }
                    this.mCurrentScale = f2;
                }
                this.mMatrix.setScale(this.mCurrentScale, this.mCurrentScale);
                this.aMJ = imageBitmap.getWidth() * this.mCurrentScale;
                this.aMK = imageBitmap.getHeight() * this.mCurrentScale;
                float width = this.aMO * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.aMO;
                this.aNc = this.mTop;
                this.aNd = 0;
                float f3 = this.aMJ < ((float) this.mViewWidth) ? (int) ((this.mViewWidth - this.aMJ) / 2.0f) : 0.0f;
                if (this.aMK < this.mViewHeight) {
                    f = (int) ((this.mViewHeight - this.aMK) / 2.0f);
                    if (this.aMS == 1 && f > this.mTop) {
                        f = this.mTop;
                    }
                    this.aNc = (int) (this.mTop - f);
                    this.aNd = this.mTop - this.aNc;
                } else {
                    f = 0.0f;
                }
                this.aNe = (int) f3;
                this.mMatrix.postTranslate(f3, f);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    int width2 = i > getWidth() ? getWidth() : i;
                    if (this.aMJ <= screenWidth) {
                        width2 = 0;
                    } else if (this.aMJ > screenWidth && this.aMJ / 2.0f < screenWidth) {
                        width2 = (int) (width2 - (this.aMJ / 4.0f));
                    }
                    scrollX = width2;
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.aMJ - width) / 2.0f);
                    }
                    if (this.aMJ <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.aMJ) {
                        scrollX = (int) (this.aMJ - getWidth());
                    }
                }
                if (scrollX > 0 && this.aMJ - scrollX < getWidth()) {
                    scrollX = (int) (this.aMJ - getWidth());
                }
                int i3 = this.mMode == 2 ? ((int) ((this.aMK - height) / 2.0f)) + scrollY : scrollY;
                if (this.aMK <= getHeight()) {
                    i3 = 0;
                } else if (getHeight() + i3 > this.aMK) {
                    i3 = (int) (this.aMK - getHeight());
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
    public class C0066a extends Animation {
        private boolean aNt = false;
        private boolean aNu = false;
        private long aNv;
        private long aNw;
        private int aNx;
        private long aNy;
        private long aNz;
        private int mStartY;

        public C0066a() {
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
            this.aNv = f;
            this.aNw = f2;
            this.aNy = Math.abs((f * 1000.0f) / 2500.0f);
            this.aNz = Math.abs((f2 * 1000.0f) / 2500.0f);
            setDuration(Math.max(this.aNy, this.aNz));
            setInterpolator(a.this.aNj);
            this.aNx = a.this.getScrollX();
            this.mStartY = a.this.getScrollY();
            this.aNt = true;
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
            if (this.aNy > this.aNz) {
                j = ((float) this.aNy) * f;
            } else {
                j = ((float) this.aNz) * f;
            }
            float f2 = ((float) (j > this.aNy ? this.aNy : j)) / 1000.0f;
            if (this.aNv > 0) {
                i = this.aNx - ((int) (f2 * (((float) this.aNv) - ((2500.0f * f2) / 2.0f))));
            } else {
                i = this.aNx - ((int) (f2 * (((float) this.aNv) + ((2500.0f * f2) / 2.0f))));
            }
            if (j > this.aNz) {
                j = this.aNz;
            }
            float f3 = ((float) j) / 1000.0f;
            if (this.aNw > 0) {
                i2 = this.mStartY - ((int) (f3 * (((float) this.aNw) - ((2500.0f * f3) / 2.0f))));
            } else {
                i2 = this.mStartY - ((int) (f3 * (((float) this.aNw) + ((2500.0f * f3) / 2.0f))));
            }
            if (a.this.aMK + a.this.mTop + a.this.mBottom > a.this.getHeight()) {
                if (i2 < (-a.this.aNc)) {
                    i2 = -a.this.aNc;
                }
                if (a.this.getHeight() + i2 > a.this.aMK + a.this.mBottom + a.this.aNd) {
                    i2 = (int) ((a.this.aMK - a.this.getHeight()) + a.this.mBottom + a.this.aNd);
                }
            } else {
                i2 = 0;
            }
            if (a.this.aMJ > a.this.getWidth()) {
                int width = ((float) (a.this.getWidth() + i)) > a.this.aMJ ? (int) (a.this.aMJ - a.this.getWidth()) : i;
                if (width >= 0) {
                    i3 = width;
                }
            }
            a.this.scrollTo(i3, i2);
            a.this.invalidate();
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            if (!this.aNu) {
                if (a.this.aMP) {
                    this.aNt = false;
                    return false;
                }
                try {
                    if (super.getTransformation(j, transformation)) {
                        return true;
                    }
                    this.aNt = false;
                    return false;
                } catch (Exception e) {
                    this.aNt = false;
                    return false;
                }
            }
            this.aNu = false;
            this.aNt = false;
            return false;
        }

        public boolean HN() {
            return this.aNt;
        }

        public void stopAnimation() {
            this.aNu = true;
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.aMU = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.avy = onLongClickListener;
    }

    public void setGifSetListener(d dVar) {
        this.avA = dVar;
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
        c poll = this.aNm.poll();
        if (poll == null) {
            this.aNr = true;
            return;
        }
        this.aNr = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.aNl != null) {
            j = this.aNl.delay - (currentTimeMillis - this.aNq);
            this.aNn.offer(this.aNl);
        } else {
            j = 0;
        }
        this.aNl = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public c HL() {
        c poll = this.aNn.poll();
        if (poll == null) {
            poll = new c();
            try {
                poll.aNA = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
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
        public Bitmap aNA;
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
            while (a.this.mState == 1 && a.this.aNa != null && a.this.aNk > 0 && a.this.width > 0 && a.this.height > 0) {
                try {
                    a.this.aNa.T(a.this.aNo);
                    c HL = a.this.HL();
                    if (HL.aNA == null || (HL.aNA.getWidth() != a.this.width && HL.aNA.getHeight() != a.this.height)) {
                        try {
                            HL.aNA = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_8888);
                        } catch (OutOfMemoryError e) {
                            TbadkCoreApplication.getInst().onAppMemoryLow();
                            try {
                                HL.aNA = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_4444);
                            } catch (OutOfMemoryError e2) {
                                TbadkCoreApplication.getInst().onAppMemoryLow();
                            }
                        } catch (Throwable th) {
                            BdLog.e(th.getMessage());
                        }
                    }
                    a.this.aNa.a(HL.aNA, null);
                    HL.delay = a.this.aNa.U(a.this.aNo);
                    a.B(a.this);
                    if (HL.aNA == null) {
                        a.B(a.this);
                    }
                    a.this.aNo %= a.this.aNk;
                    a.this.aNm.put(HL);
                    if (a.this.aNr) {
                        a.this.mHandler.sendEmptyMessage(1);
                    }
                } catch (Exception e3) {
                    return;
                }
            }
        }
    }

    public boolean HM() {
        return this.aNg;
    }

    public void setLoadBigImage(boolean z) {
        this.aNg = z;
    }

    public int getBottomOffset() {
        return this.aNd;
    }

    public int getLeftOffset() {
        return this.aNe;
    }
}
