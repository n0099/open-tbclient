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
    private boolean aNA;
    private float aNB;
    private Interpolator aNC;
    private int aND;
    private c aNE;
    private BlockingLinkedDeque<c> aNF;
    private BlockingLinkedDeque<c> aNG;
    private volatile int aNH;
    private b aNI;
    private volatile long aNJ;
    private volatile boolean aNK;
    private float aNd;
    private float aNe;
    private ArrayList<Float> aNf;
    private float aNg;
    private float aNh;
    private float aNi;
    private boolean aNj;
    private int aNk;
    private int aNl;
    private e aNm;
    private View.OnClickListener aNn;
    private C0064a aNo;
    private float aNp;
    private boolean aNq;
    private boolean aNr;
    private int aNs;
    private volatile com.baidu.adp.gif.b aNt;
    private Bitmap aNu;
    private int aNv;
    private int aNw;
    private int aNx;
    private int aNy;
    private boolean aNz;
    private int aiQ;
    private View.OnLongClickListener awn;
    private d awp;
    private int awq;
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
        int i = aVar.aNH;
        aVar.aNH = i + 1;
        return i;
    }

    public void setIsHeadImage(boolean z) {
        this.aNA = z;
    }

    public a(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aNj = false;
        this.mImageData = null;
        this.awq = 0;
        this.aNk = 1300;
        this.aNl = 0;
        this.aNm = null;
        this.aNn = null;
        this.awn = null;
        this.awp = null;
        this.aNp = 1.0f;
        this.aiQ = 0;
        this.mMode = 0;
        this.aNq = false;
        this.aNr = false;
        this.aNs = 0;
        this.aNt = null;
        this.aNu = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aNv = 0;
        this.aNw = 0;
        this.aNx = 0;
        this.aNy = 0;
        this.aNC = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aND = 0;
        this.aNE = null;
        this.aNF = new BlockingLinkedDeque<>(5);
        this.aNG = new BlockingLinkedDeque<>(6);
        this.aNH = 0;
        this.aNJ = 0L;
        this.mState = 0;
        this.aNK = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.a.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        a.this.HL();
                        break;
                    case 1:
                        if (a.this.aNK) {
                            a.this.HL();
                            break;
                        }
                        break;
                    case 2:
                        a.this.invalidate();
                        a.this.aNJ = System.currentTimeMillis();
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
        this.aNj = false;
        this.mImageData = null;
        this.awq = 0;
        this.aNk = 1300;
        this.aNl = 0;
        this.aNm = null;
        this.aNn = null;
        this.awn = null;
        this.awp = null;
        this.aNp = 1.0f;
        this.aiQ = 0;
        this.mMode = 0;
        this.aNq = false;
        this.aNr = false;
        this.aNs = 0;
        this.aNt = null;
        this.aNu = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aNv = 0;
        this.aNw = 0;
        this.aNx = 0;
        this.aNy = 0;
        this.aNC = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aND = 0;
        this.aNE = null;
        this.aNF = new BlockingLinkedDeque<>(5);
        this.aNG = new BlockingLinkedDeque<>(6);
        this.aNH = 0;
        this.aNJ = 0L;
        this.mState = 0;
        this.aNK = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.a.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        a.this.HL();
                        break;
                    case 1:
                        if (a.this.aNK) {
                            a.this.HL();
                            break;
                        }
                        break;
                    case 2:
                        a.this.invalidate();
                        a.this.aNJ = System.currentTimeMillis();
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
        this.aNj = false;
        this.mImageData = null;
        this.awq = 0;
        this.aNk = 1300;
        this.aNl = 0;
        this.aNm = null;
        this.aNn = null;
        this.awn = null;
        this.awp = null;
        this.aNp = 1.0f;
        this.aiQ = 0;
        this.mMode = 0;
        this.aNq = false;
        this.aNr = false;
        this.aNs = 0;
        this.aNt = null;
        this.aNu = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aNv = 0;
        this.aNw = 0;
        this.aNx = 0;
        this.aNy = 0;
        this.aNC = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aND = 0;
        this.aNE = null;
        this.aNF = new BlockingLinkedDeque<>(5);
        this.aNG = new BlockingLinkedDeque<>(6);
        this.aNH = 0;
        this.aNJ = 0L;
        this.mState = 0;
        this.aNK = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.a.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        a.this.HL();
                        break;
                    case 1:
                        if (a.this.aNK) {
                            a.this.HL();
                            break;
                        }
                        break;
                    case 2:
                        a.this.invalidate();
                        a.this.aNJ = System.currentTimeMillis();
                        a.this.mHandler.sendEmptyMessage(0);
                        break;
                }
                return false;
            }
        });
        initData();
    }

    public int getImageType() {
        return this.aiQ;
    }

    public void setImageMode(int i) {
        this.aNl = i;
    }

    public void k(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.awq = i;
    }

    public void Hz() {
        this.aNr = false;
        this.aNj = false;
        this.mMode = 0;
        HD();
        if (this.mCurrentScale < this.aNg) {
            this.mCurrentScale = this.aNg;
            HK();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.aNj = true;
                this.aNq = false;
                this.aNr = false;
                break;
            case 1:
                Hz();
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
            this.aNp = m(motionEvent);
            if (this.aNp > 10.0f) {
                this.mMode = 2;
            }
        }
        if (this.mMode == 2 || !this.mGestureDetector.onTouchEvent(motionEvent)) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.aNq = true;
                        this.aNr = true;
                        if (this.aiQ != 1 && this.aiQ != 2) {
                            float m = m(motionEvent);
                            if (m >= 0.0f && Math.abs(this.aNp - m) >= 10.0f) {
                                if (Math.abs(this.aNp - m) > 100.0f) {
                                    this.aNp = m;
                                    break;
                                } else {
                                    float f = m / this.aNp;
                                    this.aNp = m;
                                    this.aNi = this.mCurrentScale;
                                    this.mCurrentScale *= f;
                                    if (this.mCurrentScale > this.aNh) {
                                        this.mCurrentScale = this.aNh;
                                    }
                                    if (this.mCurrentScale < this.aNg / 4.0f) {
                                        this.mCurrentScale = this.aNg / 4.0f;
                                    }
                                    HK();
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
            HB();
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public boolean HA() {
        return this.aNg == this.mCurrentScale;
    }

    private void HB() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            if (this.aNl == 0) {
                float width = this.mViewWidth / imageBitmap.getWidth();
                float height = this.mViewHeight / imageBitmap.getHeight();
                if (this.aNA) {
                    if (this.aiQ == 2) {
                        this.aNg = 2.5f;
                    } else {
                        this.aNg = Math.min(width, height);
                    }
                } else if (this.aiQ == 2) {
                    this.aNg = 1.0f;
                } else {
                    float f = this.aNB;
                    float f2 = f >= 1.0f ? f : 1.0f;
                    if (imageBitmap.getWidth() * f2 < this.mViewWidth && imageBitmap.getHeight() * f2 < this.mViewHeight) {
                        this.aNg = f2;
                    } else {
                        this.aNg = Math.min(width, height);
                    }
                }
            } else {
                this.aNg = Math.max(this.mViewWidth / imageBitmap.getWidth(), ((this.mViewHeight - this.mTop) - this.mBottom) / imageBitmap.getHeight());
            }
            this.aNh = this.aNk / (imageBitmap.getWidth() * imageBitmap.getHeight());
            this.aNh = FloatMath.sqrt(this.aNh);
            if (this.aNh > 10.0f) {
                this.aNh = 10.0f;
            }
            this.aNf.clear();
            this.aNf.add(Float.valueOf(this.aNg));
            this.mCurrentScale = this.aNg;
            this.aNi = this.mCurrentScale;
            HK();
            return;
        }
        this.aNd = 0.0f;
        this.aNe = 0.0f;
        this.aNg = 1.0f;
        this.aNh = 1.0f;
        this.mCurrentScale = 1.0f;
        this.aNi = this.mCurrentScale;
        this.aNf.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    private void HC() {
        if (this.aNm != null) {
            this.aNm.a(this, canZoomIn(), canZoomOut());
        }
    }

    public void setOnSizeChangedListener(e eVar) {
        this.aNm = eVar;
    }

    public byte[] getImageData() {
        return this.mImageData;
    }

    public void setImageData(byte[] bArr) {
        this.mImageData = bArr;
    }

    public Bitmap getGifCache() {
        return this.aNu;
    }

    public void setGifCache(Bitmap bitmap) {
        this.aNu = bitmap;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        boolean z;
        int i4;
        if (this.aiQ == 2 && this.aNy != 0 && !this.aNo.HO()) {
            int width = getWidth();
            int height = getHeight();
            Drawable drawable = getDrawable();
            float f = 0.0f;
            float f2 = height * 0.3f;
            float f3 = width;
            float f4 = (1.0f - 0.3f) * height;
            if (this.aNA && drawable != null) {
                Rect bounds = drawable.getBounds();
                int i5 = bounds.right - bounds.left;
                int i6 = bounds.bottom - bounds.top;
                f = (width / 2) - (i5 * 2.5f);
                f2 = (height / 2) - (i6 * 2.5f);
                f3 = (i5 * 2.5f) + (width / 2);
                f4 = (i6 * 2.5f) + (height / 2);
            }
            this.mPaint.setColor(ai.getColor(this.aNy));
            canvas.drawRect(f, f2, f3, f4, this.mPaint);
            this.mPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        }
        super.onDraw(canvas);
        if (this.aiQ == 1 && this.aNu != null && !this.aNu.isRecycled()) {
            int width2 = this.aNu.getWidth();
            int height2 = this.aNu.getHeight();
            int width3 = getWidth();
            int height3 = getHeight();
            int i7 = (width3 - width2) >> 1;
            int i8 = (height3 - height2) >> 1;
            float f5 = this.aNB;
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
            if (this.aNs == 1 && this.aNt != null && this.aNE != null && this.aNE.aNS != null) {
                if (z) {
                    canvas.drawBitmap(this.aNE.aNS, i3, i2, (Paint) null);
                } else {
                    canvas.drawBitmap(this.aNE.aNS, this.mMatrix, this.mPaint);
                }
                invalidate();
            } else if (z) {
                canvas.drawBitmap(this.aNu, i3, i2, (Paint) null);
            } else {
                canvas.drawBitmap(this.aNu, this.mMatrix, this.mPaint);
            }
        }
    }

    public void play() {
        com.baidu.adp.widget.a.a aVar;
        if (this.aiQ == 1) {
            if (this.aNt == null) {
                if (this.aNI != null) {
                    this.aNI.interrupt();
                    this.aNI = null;
                }
                if (this.mImageData != null) {
                    try {
                        aVar = a.C0003a.dN().g(this.mImageData, 0, this.mImageData.length);
                    } catch (StackOverflowError e2) {
                        aVar = null;
                    }
                    if (aVar != null && aVar.getGif() != null) {
                        this.aNt = aVar.getGif();
                        if (this.aNt != null) {
                            this.aNs = 1;
                            this.width = this.aNt.getWidth();
                            this.height = this.aNt.getHeight();
                            this.aNH = 0;
                            this.aND = this.aNt.dO();
                        } else {
                            this.aNs = 0;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            if (this.aNt != null && this.mState == 0) {
                this.aNK = true;
                this.aNI = new b();
                this.aNF.clear();
                this.aNG.clear();
                this.mState = 1;
                this.aNI.start();
            }
        }
    }

    public void pause() {
        if (this.aiQ == 1) {
            this.mState = 0;
            if (this.aNI != null) {
                this.aNI.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.aiQ == 1) {
            this.mState = 0;
            if (this.aNI != null) {
                this.aNI.interrupt();
                this.aNI = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.aNK = true;
            this.aNE = null;
            this.aNG.clear();
            this.aNF.clear();
            this.width = 0;
            this.height = 0;
            this.aNH = 0;
            this.aND = 0;
            if (this.aNt != null) {
                this.aNt = null;
            }
        }
    }

    private void initData() {
        this.aNB = k.ai(getContext());
        this.aNk = k.ah(getContext()) * k.ag(getContext()) * 2;
        if (this.aNk < 1690000) {
            this.aNk = 1690000;
        }
        this.aNd = 0.0f;
        this.aNe = 0.0f;
        this.aNf = new ArrayList<>();
        this.aNg = 1.0f;
        this.aNh = 1.0f;
        this.mCurrentScale = 1.0f;
        this.aNi = this.mCurrentScale;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.aNo = new C0064a();
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWillNotDraw(false);
        scrollTo(0, 0);
        this.mGestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.a.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (a.this.aiQ != 2 && (Math.abs(f) > 200.0f || Math.abs(f2) > 200.0f)) {
                    a.this.aNo.e(f, f2);
                    a.this.startAnimation(a.this.aNo);
                }
                return super.onFling(motionEvent, motionEvent2, f, f2);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (a.this.aiQ != 1 && a.this.aiQ != 2) {
                    a.this.mMode = 2;
                    if (a.this.mCurrentScale > a.this.aNg) {
                        a.this.mCurrentScale = a.this.aNg;
                        a.this.aNi = a.this.mCurrentScale;
                        a.this.HK();
                        return true;
                    }
                    a.this.mCurrentScale = a.this.aNg * 2.0f;
                    a.this.e(true, (int) motionEvent.getX(), (int) motionEvent.getY());
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (a.this.aNn != null && !a.this.aNq) {
                    a.this.aNn.onClick(a.this);
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
                a.this.aNq = true;
                if (a.this.aNl == 0 && a.this.aNr) {
                    return false;
                }
                int scrollX = a.this.getScrollX();
                if (a.this.aNd >= a.this.getWidth()) {
                    scrollX = (int) (scrollX + f);
                    if (a.this.aNl == 0) {
                        i = scrollX >= 0 ? scrollX : 0;
                        if (a.this.getWidth() + i > a.this.aNd) {
                            i = (int) (a.this.aNd - a.this.getWidth());
                        }
                        scrollY = a.this.getScrollY();
                        if (a.this.aNe + a.this.mTop + a.this.mBottom >= a.this.getHeight()) {
                            scrollY = (int) (scrollY + f2);
                            if (a.this.aNl == 0) {
                                if (scrollY < (-a.this.aNv)) {
                                    scrollY = -a.this.aNv;
                                }
                                if (a.this.getHeight() + scrollY > a.this.aNe + a.this.mBottom + a.this.aNw) {
                                    scrollY = (int) ((a.this.aNe - a.this.getHeight()) + a.this.mBottom + a.this.aNw);
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
                if (a.this.aNe + a.this.mTop + a.this.mBottom >= a.this.getHeight()) {
                }
                if (i == a.this.getScrollX()) {
                }
                a.this.scrollTo(i, scrollY);
                a.this.invalidate();
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (a.this.awn != null && !a.this.aNq) {
                    a.this.awn.onLongClick(a.this);
                }
                super.onLongPress(motionEvent);
            }
        });
    }

    private void HD() {
        int i = 0;
        int scrollX = getScrollX();
        if (this.aNd >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.aNd) {
                scrollX = (int) (this.aNd - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.aNe + this.mTop + this.mBottom >= getHeight()) {
            i = scrollY < (-this.aNv) ? -this.aNv : scrollY;
            if (getHeight() + i > this.aNe + this.mBottom + this.aNw) {
                i = (int) ((this.aNe - getHeight()) + this.mBottom + this.aNw);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.aNd;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.aNe;
    }

    public boolean HE() {
        if (this.aiQ == 1 || this.aiQ == 2) {
            return true;
        }
        return !this.aNr && getScrollX() >= ((int) (this.aNd - ((float) getWidth()))) + (-1);
    }

    public boolean HF() {
        if (this.aiQ == 1 || this.aiQ == 2) {
            return true;
        }
        return !this.aNr && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.aNo.HO()) {
            this.aNo.stopAnimation();
        }
        this.aNy = 0;
        super.setImageBitmap(bitmap);
        HB();
        this.aiQ = 0;
    }

    public void j(Bitmap bitmap) {
        Bitmap imageBitmap = getImageBitmap();
        if (bitmap != null && !bitmap.isRecycled()) {
            if (imageBitmap != null && (imageBitmap.getWidth() != bitmap.getWidth() || imageBitmap.getHeight() != bitmap.getHeight())) {
                setImageBitmap(bitmap);
                return;
            }
            if (this.aNo.HO()) {
                this.aNo.stopAnimation();
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            super.setImageBitmap(bitmap);
            super.setImageMatrix(this.mMatrix);
            scrollTo(scrollX, scrollY);
            this.aiQ = 0;
        }
    }

    public void a(byte[] bArr, Bitmap bitmap) {
        if (this.aNo.HO()) {
            this.aNo.stopAnimation();
        }
        super.setImageDrawable(null);
        stop();
        HB();
        this.aiQ = 1;
        this.aNu = bitmap;
        this.mImageData = bArr;
        if (this.awp != null) {
            this.awp.a(this);
        }
    }

    public void onDestroy() {
        if (this.aNo.HO()) {
            this.aNo.stopAnimation();
        }
        super.setImageDrawable(null);
        this.mImageData = null;
        this.aNu = null;
        stop();
        if (this.aNt != null) {
            this.aNt.close();
            this.aNt = null;
        }
    }

    public void release() {
        if (this.aNo.HO()) {
            this.aNo.stopAnimation();
        }
        stop();
        super.setImageDrawable(null);
        this.aNu = null;
    }

    public void HG() {
        if (this.aNo.HO()) {
            this.aNo.stopAnimation();
        }
        if (this.aNA) {
            super.setImageBitmap(BitmapHelper.getCashBitmap(d.g.icon_default_avatar100));
        } else {
            super.setImageBitmap(BitmapHelper.getCashBitmap(d.g.btn_see_default));
        }
        this.aiQ = 2;
        HB();
    }

    public void HH() {
        if (this.aiQ != 1 && this.aiQ != 2) {
            int size = this.aNf.size();
            if (size > 0) {
                this.aNf.add(Float.valueOf(this.aNf.get(size - 1).floatValue() * 1.25f));
            } else {
                this.aNf.add(Float.valueOf(this.aNg));
            }
            HK();
        }
    }

    public void HI() {
        if (this.aiQ != 1 && this.aiQ != 2) {
            int size = this.aNf.size();
            if (size > 1) {
                this.aNf.remove(size - 1);
            }
            HK();
        }
    }

    public void HJ() {
        HC();
        if (this.aiQ != 1 && this.aiQ != 2 && this.mCurrentScale != this.aNg) {
            this.aNf.clear();
            this.aNf.add(Float.valueOf(this.aNg));
            this.mCurrentScale = this.aNg;
            this.aNi = this.mCurrentScale;
            HK();
        }
    }

    public boolean canZoomIn() {
        if (this.aiQ == 1 || this.aiQ == 2) {
            return false;
        }
        int size = this.aNf.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.aNf.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.aNk) && floatValue <= 5.0f;
    }

    public boolean canZoomOut() {
        if (this.aiQ == 1 || this.aiQ == 2) {
            return false;
        }
        int size = this.aNf.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled()) {
            return false;
        }
        return size > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HK() {
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
                    int size = this.aNf.size();
                    if (size > 0) {
                        f2 = this.aNf.get(size - 1).floatValue();
                    } else {
                        f2 = this.aNg;
                    }
                    this.mCurrentScale = f2;
                }
                this.mMatrix.setScale(this.mCurrentScale, this.mCurrentScale);
                this.aNd = imageBitmap.getWidth() * this.mCurrentScale;
                this.aNe = imageBitmap.getHeight() * this.mCurrentScale;
                float width = this.aNi * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.aNi;
                this.aNv = this.mTop;
                this.aNw = 0;
                float f3 = this.aNd < ((float) this.mViewWidth) ? (int) ((this.mViewWidth - this.aNd) / 2.0f) : 0.0f;
                if (this.aNe < this.mViewHeight) {
                    f = (int) ((this.mViewHeight - this.aNe) / 2.0f);
                    if (this.aNl == 1 && f > this.mTop) {
                        f = this.mTop;
                    }
                    this.aNv = (int) (this.mTop - f);
                    this.aNw = this.mTop - this.aNv;
                } else {
                    f = 0.0f;
                }
                this.aNx = (int) f3;
                this.mMatrix.postTranslate(f3, f);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    int width2 = i > getWidth() ? getWidth() : i;
                    if (this.aNd <= screenWidth) {
                        width2 = 0;
                    } else if (this.aNd > screenWidth && this.aNd / 2.0f < screenWidth) {
                        width2 = (int) (width2 - (this.aNd / 4.0f));
                    }
                    scrollX = width2;
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.aNd - width) / 2.0f);
                    }
                    if (this.aNd <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.aNd) {
                        scrollX = (int) (this.aNd - getWidth());
                    }
                }
                if (scrollX > 0 && this.aNd - scrollX < getWidth()) {
                    scrollX = (int) (this.aNd - getWidth());
                }
                int i3 = this.mMode == 2 ? ((int) ((this.aNe - height) / 2.0f)) + scrollY : scrollY;
                if (this.aNe <= getHeight()) {
                    i3 = 0;
                } else if (getHeight() + i3 > this.aNe) {
                    i3 = (int) (this.aNe - getHeight());
                }
                setHorizontalScrollBarEnabled(false);
                setVerticalScrollBarEnabled(false);
                if (scrollX < 0) {
                    scrollX = 0;
                }
                scrollTo(scrollX, i3 >= 0 ? i3 : 0);
                setImageMatrix(this.mMatrix);
                HC();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0064a extends Animation {
        private long aNN;
        private long aNO;
        private int aNP;
        private long aNQ;
        private long aNR;
        private int mStartY;
        private boolean aNM = false;
        private boolean mStop = false;

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
            this.aNN = f;
            this.aNO = f2;
            this.aNQ = Math.abs((f * 1000.0f) / 2500.0f);
            this.aNR = Math.abs((f2 * 1000.0f) / 2500.0f);
            setDuration(Math.max(this.aNQ, this.aNR));
            setInterpolator(a.this.aNC);
            this.aNP = a.this.getScrollX();
            this.mStartY = a.this.getScrollY();
            this.aNM = true;
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
            if (this.aNQ > this.aNR) {
                j = ((float) this.aNQ) * f;
            } else {
                j = ((float) this.aNR) * f;
            }
            float f2 = ((float) (j > this.aNQ ? this.aNQ : j)) / 1000.0f;
            if (this.aNN > 0) {
                i = this.aNP - ((int) (f2 * (((float) this.aNN) - ((2500.0f * f2) / 2.0f))));
            } else {
                i = this.aNP - ((int) (f2 * (((float) this.aNN) + ((2500.0f * f2) / 2.0f))));
            }
            if (j > this.aNR) {
                j = this.aNR;
            }
            float f3 = ((float) j) / 1000.0f;
            if (this.aNO > 0) {
                i2 = this.mStartY - ((int) (f3 * (((float) this.aNO) - ((2500.0f * f3) / 2.0f))));
            } else {
                i2 = this.mStartY - ((int) (f3 * (((float) this.aNO) + ((2500.0f * f3) / 2.0f))));
            }
            if (a.this.aNe + a.this.mTop + a.this.mBottom > a.this.getHeight()) {
                if (i2 < (-a.this.aNv)) {
                    i2 = -a.this.aNv;
                }
                if (a.this.getHeight() + i2 > a.this.aNe + a.this.mBottom + a.this.aNw) {
                    i2 = (int) ((a.this.aNe - a.this.getHeight()) + a.this.mBottom + a.this.aNw);
                }
            } else {
                i2 = 0;
            }
            if (a.this.aNd > a.this.getWidth()) {
                int width = ((float) (a.this.getWidth() + i)) > a.this.aNd ? (int) (a.this.aNd - a.this.getWidth()) : i;
                if (width >= 0) {
                    i3 = width;
                }
            }
            a.this.scrollTo(i3, i2);
            a.this.invalidate();
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            if (!this.mStop) {
                if (a.this.aNj) {
                    this.aNM = false;
                    return false;
                }
                try {
                    if (super.getTransformation(j, transformation)) {
                        return true;
                    }
                    this.aNM = false;
                    return false;
                } catch (Exception e) {
                    this.aNM = false;
                    return false;
                }
            }
            this.mStop = false;
            this.aNM = false;
            return false;
        }

        public boolean HO() {
            return this.aNM;
        }

        public void stopAnimation() {
            this.mStop = true;
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.aNn = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.awn = onLongClickListener;
    }

    public void setGifSetListener(d dVar) {
        this.awp = dVar;
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
    public void HL() {
        long j;
        c poll = this.aNF.poll();
        if (poll == null) {
            this.aNK = true;
            return;
        }
        this.aNK = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.aNE != null) {
            j = this.aNE.delay - (currentTimeMillis - this.aNJ);
            this.aNG.offer(this.aNE);
        } else {
            j = 0;
        }
        this.aNE = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public c HM() {
        c poll = this.aNG.poll();
        if (poll == null) {
            poll = new c();
            try {
                poll.aNS = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
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
        public Bitmap aNS;
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
            while (a.this.mState == 1 && a.this.aNt != null && a.this.aND > 0 && a.this.width > 0 && a.this.height > 0) {
                try {
                    a.this.aNt.W(a.this.aNH);
                    c HM = a.this.HM();
                    if (HM.aNS == null || (HM.aNS.getWidth() != a.this.width && HM.aNS.getHeight() != a.this.height)) {
                        try {
                            HM.aNS = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_8888);
                        } catch (OutOfMemoryError e) {
                            TbadkCoreApplication.getInst().onAppMemoryLow();
                            try {
                                HM.aNS = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_4444);
                            } catch (OutOfMemoryError e2) {
                                TbadkCoreApplication.getInst().onAppMemoryLow();
                            }
                        } catch (Throwable th) {
                            BdLog.e(th.getMessage());
                        }
                    }
                    a.this.aNt.a(HM.aNS, null);
                    HM.delay = a.this.aNt.X(a.this.aNH);
                    a.B(a.this);
                    if (HM.aNS == null) {
                        a.B(a.this);
                    }
                    a.this.aNH %= a.this.aND;
                    a.this.aNF.put(HM);
                    if (a.this.aNK) {
                        a.this.mHandler.sendEmptyMessage(1);
                    }
                } catch (Exception e3) {
                    return;
                }
            }
        }
    }

    public boolean HN() {
        return this.aNz;
    }

    public void setLoadBigImage(boolean z) {
        this.aNz = z;
    }

    public int getBottomOffset() {
        return this.aNw;
    }

    public int getLeftOffset() {
        return this.aNx;
    }
}
