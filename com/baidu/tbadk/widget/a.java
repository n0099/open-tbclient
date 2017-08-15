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
    private boolean aNB;
    private float aNC;
    private Interpolator aND;
    private int aNE;
    private c aNF;
    private BlockingLinkedDeque<c> aNG;
    private BlockingLinkedDeque<c> aNH;
    private volatile int aNI;
    private b aNJ;
    private volatile long aNK;
    private volatile boolean aNL;
    private float aNe;
    private float aNf;
    private ArrayList<Float> aNg;
    private float aNh;
    private float aNi;
    private float aNj;
    private boolean aNk;
    private int aNl;
    private int aNm;
    private e aNn;
    private View.OnClickListener aNo;
    private C0064a aNp;
    private float aNq;
    private boolean aNr;
    private boolean aNs;
    private int aNt;
    private volatile com.baidu.adp.gif.b aNu;
    private Bitmap aNv;
    private int aNw;
    private int aNx;
    private int aNy;
    private int aNz;
    private int aiS;
    private View.OnLongClickListener awo;
    private d awq;
    private int awr;
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
        int i = aVar.aNI;
        aVar.aNI = i + 1;
        return i;
    }

    public void setIsHeadImage(boolean z) {
        this.aNB = z;
    }

    public a(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aNk = false;
        this.mImageData = null;
        this.awr = 0;
        this.aNl = 1300;
        this.aNm = 0;
        this.aNn = null;
        this.aNo = null;
        this.awo = null;
        this.awq = null;
        this.aNq = 1.0f;
        this.aiS = 0;
        this.mMode = 0;
        this.aNr = false;
        this.aNs = false;
        this.aNt = 0;
        this.aNu = null;
        this.aNv = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aNw = 0;
        this.aNx = 0;
        this.aNy = 0;
        this.aNz = 0;
        this.aND = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aNE = 0;
        this.aNF = null;
        this.aNG = new BlockingLinkedDeque<>(5);
        this.aNH = new BlockingLinkedDeque<>(6);
        this.aNI = 0;
        this.aNK = 0L;
        this.mState = 0;
        this.aNL = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.a.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        a.this.HL();
                        break;
                    case 1:
                        if (a.this.aNL) {
                            a.this.HL();
                            break;
                        }
                        break;
                    case 2:
                        a.this.invalidate();
                        a.this.aNK = System.currentTimeMillis();
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
        this.aNk = false;
        this.mImageData = null;
        this.awr = 0;
        this.aNl = 1300;
        this.aNm = 0;
        this.aNn = null;
        this.aNo = null;
        this.awo = null;
        this.awq = null;
        this.aNq = 1.0f;
        this.aiS = 0;
        this.mMode = 0;
        this.aNr = false;
        this.aNs = false;
        this.aNt = 0;
        this.aNu = null;
        this.aNv = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aNw = 0;
        this.aNx = 0;
        this.aNy = 0;
        this.aNz = 0;
        this.aND = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aNE = 0;
        this.aNF = null;
        this.aNG = new BlockingLinkedDeque<>(5);
        this.aNH = new BlockingLinkedDeque<>(6);
        this.aNI = 0;
        this.aNK = 0L;
        this.mState = 0;
        this.aNL = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.a.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        a.this.HL();
                        break;
                    case 1:
                        if (a.this.aNL) {
                            a.this.HL();
                            break;
                        }
                        break;
                    case 2:
                        a.this.invalidate();
                        a.this.aNK = System.currentTimeMillis();
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
        this.aNk = false;
        this.mImageData = null;
        this.awr = 0;
        this.aNl = 1300;
        this.aNm = 0;
        this.aNn = null;
        this.aNo = null;
        this.awo = null;
        this.awq = null;
        this.aNq = 1.0f;
        this.aiS = 0;
        this.mMode = 0;
        this.aNr = false;
        this.aNs = false;
        this.aNt = 0;
        this.aNu = null;
        this.aNv = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aNw = 0;
        this.aNx = 0;
        this.aNy = 0;
        this.aNz = 0;
        this.aND = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aNE = 0;
        this.aNF = null;
        this.aNG = new BlockingLinkedDeque<>(5);
        this.aNH = new BlockingLinkedDeque<>(6);
        this.aNI = 0;
        this.aNK = 0L;
        this.mState = 0;
        this.aNL = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.a.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        a.this.HL();
                        break;
                    case 1:
                        if (a.this.aNL) {
                            a.this.HL();
                            break;
                        }
                        break;
                    case 2:
                        a.this.invalidate();
                        a.this.aNK = System.currentTimeMillis();
                        a.this.mHandler.sendEmptyMessage(0);
                        break;
                }
                return false;
            }
        });
        initData();
    }

    public int getImageType() {
        return this.aiS;
    }

    public void setImageMode(int i) {
        this.aNm = i;
    }

    public void k(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.awr = i;
    }

    public void Hz() {
        this.aNs = false;
        this.aNk = false;
        this.mMode = 0;
        HD();
        if (this.mCurrentScale < this.aNh) {
            this.mCurrentScale = this.aNh;
            HK();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.aNk = true;
                this.aNr = false;
                this.aNs = false;
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
            this.aNq = m(motionEvent);
            if (this.aNq > 10.0f) {
                this.mMode = 2;
            }
        }
        if (this.mMode == 2 || !this.mGestureDetector.onTouchEvent(motionEvent)) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.aNr = true;
                        this.aNs = true;
                        if (this.aiS != 1 && this.aiS != 2) {
                            float m = m(motionEvent);
                            if (m >= 0.0f && Math.abs(this.aNq - m) >= 10.0f) {
                                if (Math.abs(this.aNq - m) > 100.0f) {
                                    this.aNq = m;
                                    break;
                                } else {
                                    float f = m / this.aNq;
                                    this.aNq = m;
                                    this.aNj = this.mCurrentScale;
                                    this.mCurrentScale *= f;
                                    if (this.mCurrentScale > this.aNi) {
                                        this.mCurrentScale = this.aNi;
                                    }
                                    if (this.mCurrentScale < this.aNh / 4.0f) {
                                        this.mCurrentScale = this.aNh / 4.0f;
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
        return this.aNh == this.mCurrentScale;
    }

    private void HB() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            if (this.aNm == 0) {
                float width = this.mViewWidth / imageBitmap.getWidth();
                float height = this.mViewHeight / imageBitmap.getHeight();
                if (this.aNB) {
                    if (this.aiS == 2) {
                        this.aNh = 2.5f;
                    } else {
                        this.aNh = Math.min(width, height);
                    }
                } else if (this.aiS == 2) {
                    this.aNh = 1.0f;
                } else {
                    float f = this.aNC;
                    float f2 = f >= 1.0f ? f : 1.0f;
                    if (imageBitmap.getWidth() * f2 < this.mViewWidth && imageBitmap.getHeight() * f2 < this.mViewHeight) {
                        this.aNh = f2;
                    } else {
                        this.aNh = Math.min(width, height);
                    }
                }
            } else {
                this.aNh = Math.max(this.mViewWidth / imageBitmap.getWidth(), ((this.mViewHeight - this.mTop) - this.mBottom) / imageBitmap.getHeight());
            }
            this.aNi = this.aNl / (imageBitmap.getWidth() * imageBitmap.getHeight());
            this.aNi = FloatMath.sqrt(this.aNi);
            if (this.aNi > 10.0f) {
                this.aNi = 10.0f;
            }
            this.aNg.clear();
            this.aNg.add(Float.valueOf(this.aNh));
            this.mCurrentScale = this.aNh;
            this.aNj = this.mCurrentScale;
            HK();
            return;
        }
        this.aNe = 0.0f;
        this.aNf = 0.0f;
        this.aNh = 1.0f;
        this.aNi = 1.0f;
        this.mCurrentScale = 1.0f;
        this.aNj = this.mCurrentScale;
        this.aNg.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    private void HC() {
        if (this.aNn != null) {
            this.aNn.a(this, canZoomIn(), canZoomOut());
        }
    }

    public void setOnSizeChangedListener(e eVar) {
        this.aNn = eVar;
    }

    public byte[] getImageData() {
        return this.mImageData;
    }

    public void setImageData(byte[] bArr) {
        this.mImageData = bArr;
    }

    public Bitmap getGifCache() {
        return this.aNv;
    }

    public void setGifCache(Bitmap bitmap) {
        this.aNv = bitmap;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        boolean z;
        int i4;
        if (this.aiS == 2 && this.aNz != 0 && !this.aNp.HO()) {
            int width = getWidth();
            int height = getHeight();
            Drawable drawable = getDrawable();
            float f = 0.0f;
            float f2 = height * 0.3f;
            float f3 = width;
            float f4 = (1.0f - 0.3f) * height;
            if (this.aNB && drawable != null) {
                Rect bounds = drawable.getBounds();
                int i5 = bounds.right - bounds.left;
                int i6 = bounds.bottom - bounds.top;
                f = (width / 2) - (i5 * 2.5f);
                f2 = (height / 2) - (i6 * 2.5f);
                f3 = (i5 * 2.5f) + (width / 2);
                f4 = (i6 * 2.5f) + (height / 2);
            }
            this.mPaint.setColor(ai.getColor(this.aNz));
            canvas.drawRect(f, f2, f3, f4, this.mPaint);
            this.mPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        }
        super.onDraw(canvas);
        if (this.aiS == 1 && this.aNv != null && !this.aNv.isRecycled()) {
            int width2 = this.aNv.getWidth();
            int height2 = this.aNv.getHeight();
            int width3 = getWidth();
            int height3 = getHeight();
            int i7 = (width3 - width2) >> 1;
            int i8 = (height3 - height2) >> 1;
            float f5 = this.aNC;
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
            if (this.aNt == 1 && this.aNu != null && this.aNF != null && this.aNF.aNT != null) {
                if (z) {
                    canvas.drawBitmap(this.aNF.aNT, i3, i2, (Paint) null);
                } else {
                    canvas.drawBitmap(this.aNF.aNT, this.mMatrix, this.mPaint);
                }
                invalidate();
            } else if (z) {
                canvas.drawBitmap(this.aNv, i3, i2, (Paint) null);
            } else {
                canvas.drawBitmap(this.aNv, this.mMatrix, this.mPaint);
            }
        }
    }

    public void play() {
        com.baidu.adp.widget.a.a aVar;
        if (this.aiS == 1) {
            if (this.aNu == null) {
                if (this.aNJ != null) {
                    this.aNJ.interrupt();
                    this.aNJ = null;
                }
                if (this.mImageData != null) {
                    try {
                        aVar = a.C0002a.dN().g(this.mImageData, 0, this.mImageData.length);
                    } catch (StackOverflowError e2) {
                        aVar = null;
                    }
                    if (aVar != null && aVar.getGif() != null) {
                        this.aNu = aVar.getGif();
                        if (this.aNu != null) {
                            this.aNt = 1;
                            this.width = this.aNu.getWidth();
                            this.height = this.aNu.getHeight();
                            this.aNI = 0;
                            this.aNE = this.aNu.dO();
                        } else {
                            this.aNt = 0;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            if (this.aNu != null && this.mState == 0) {
                this.aNL = true;
                this.aNJ = new b();
                this.aNG.clear();
                this.aNH.clear();
                this.mState = 1;
                this.aNJ.start();
            }
        }
    }

    public void pause() {
        if (this.aiS == 1) {
            this.mState = 0;
            if (this.aNJ != null) {
                this.aNJ.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.aiS == 1) {
            this.mState = 0;
            if (this.aNJ != null) {
                this.aNJ.interrupt();
                this.aNJ = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.aNL = true;
            this.aNF = null;
            this.aNH.clear();
            this.aNG.clear();
            this.width = 0;
            this.height = 0;
            this.aNI = 0;
            this.aNE = 0;
            if (this.aNu != null) {
                this.aNu = null;
            }
        }
    }

    private void initData() {
        this.aNC = k.ai(getContext());
        this.aNl = k.ah(getContext()) * k.ag(getContext()) * 2;
        if (this.aNl < 1690000) {
            this.aNl = 1690000;
        }
        this.aNe = 0.0f;
        this.aNf = 0.0f;
        this.aNg = new ArrayList<>();
        this.aNh = 1.0f;
        this.aNi = 1.0f;
        this.mCurrentScale = 1.0f;
        this.aNj = this.mCurrentScale;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.aNp = new C0064a();
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWillNotDraw(false);
        scrollTo(0, 0);
        this.mGestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.a.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (a.this.aiS != 2 && (Math.abs(f) > 200.0f || Math.abs(f2) > 200.0f)) {
                    a.this.aNp.e(f, f2);
                    a.this.startAnimation(a.this.aNp);
                }
                return super.onFling(motionEvent, motionEvent2, f, f2);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (a.this.aiS != 1 && a.this.aiS != 2) {
                    a.this.mMode = 2;
                    if (a.this.mCurrentScale > a.this.aNh) {
                        a.this.mCurrentScale = a.this.aNh;
                        a.this.aNj = a.this.mCurrentScale;
                        a.this.HK();
                        return true;
                    }
                    a.this.mCurrentScale = a.this.aNh * 2.0f;
                    a.this.e(true, (int) motionEvent.getX(), (int) motionEvent.getY());
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (a.this.aNo != null && !a.this.aNr) {
                    a.this.aNo.onClick(a.this);
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
                a.this.aNr = true;
                if (a.this.aNm == 0 && a.this.aNs) {
                    return false;
                }
                int scrollX = a.this.getScrollX();
                if (a.this.aNe >= a.this.getWidth()) {
                    scrollX = (int) (scrollX + f);
                    if (a.this.aNm == 0) {
                        i = scrollX >= 0 ? scrollX : 0;
                        if (a.this.getWidth() + i > a.this.aNe) {
                            i = (int) (a.this.aNe - a.this.getWidth());
                        }
                        scrollY = a.this.getScrollY();
                        if (a.this.aNf + a.this.mTop + a.this.mBottom >= a.this.getHeight()) {
                            scrollY = (int) (scrollY + f2);
                            if (a.this.aNm == 0) {
                                if (scrollY < (-a.this.aNw)) {
                                    scrollY = -a.this.aNw;
                                }
                                if (a.this.getHeight() + scrollY > a.this.aNf + a.this.mBottom + a.this.aNx) {
                                    scrollY = (int) ((a.this.aNf - a.this.getHeight()) + a.this.mBottom + a.this.aNx);
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
                if (a.this.aNf + a.this.mTop + a.this.mBottom >= a.this.getHeight()) {
                }
                if (i == a.this.getScrollX()) {
                }
                a.this.scrollTo(i, scrollY);
                a.this.invalidate();
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (a.this.awo != null && !a.this.aNr) {
                    a.this.awo.onLongClick(a.this);
                }
                super.onLongPress(motionEvent);
            }
        });
    }

    private void HD() {
        int i = 0;
        int scrollX = getScrollX();
        if (this.aNe >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.aNe) {
                scrollX = (int) (this.aNe - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.aNf + this.mTop + this.mBottom >= getHeight()) {
            i = scrollY < (-this.aNw) ? -this.aNw : scrollY;
            if (getHeight() + i > this.aNf + this.mBottom + this.aNx) {
                i = (int) ((this.aNf - getHeight()) + this.mBottom + this.aNx);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.aNe;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.aNf;
    }

    public boolean HE() {
        if (this.aiS == 1 || this.aiS == 2) {
            return true;
        }
        return !this.aNs && getScrollX() >= ((int) (this.aNe - ((float) getWidth()))) + (-1);
    }

    public boolean HF() {
        if (this.aiS == 1 || this.aiS == 2) {
            return true;
        }
        return !this.aNs && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.aNp.HO()) {
            this.aNp.stopAnimation();
        }
        this.aNz = 0;
        super.setImageBitmap(bitmap);
        HB();
        this.aiS = 0;
    }

    public void j(Bitmap bitmap) {
        Bitmap imageBitmap = getImageBitmap();
        if (bitmap != null && !bitmap.isRecycled()) {
            if (imageBitmap != null && (imageBitmap.getWidth() != bitmap.getWidth() || imageBitmap.getHeight() != bitmap.getHeight())) {
                setImageBitmap(bitmap);
                return;
            }
            if (this.aNp.HO()) {
                this.aNp.stopAnimation();
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            super.setImageBitmap(bitmap);
            super.setImageMatrix(this.mMatrix);
            scrollTo(scrollX, scrollY);
            this.aiS = 0;
        }
    }

    public void a(byte[] bArr, Bitmap bitmap) {
        if (this.aNp.HO()) {
            this.aNp.stopAnimation();
        }
        super.setImageDrawable(null);
        stop();
        HB();
        this.aiS = 1;
        this.aNv = bitmap;
        this.mImageData = bArr;
        if (this.awq != null) {
            this.awq.a(this);
        }
    }

    public void onDestroy() {
        if (this.aNp.HO()) {
            this.aNp.stopAnimation();
        }
        super.setImageDrawable(null);
        this.mImageData = null;
        this.aNv = null;
        stop();
        if (this.aNu != null) {
            this.aNu.close();
            this.aNu = null;
        }
    }

    public void release() {
        if (this.aNp.HO()) {
            this.aNp.stopAnimation();
        }
        stop();
        super.setImageDrawable(null);
        this.aNv = null;
    }

    public void HG() {
        if (this.aNp.HO()) {
            this.aNp.stopAnimation();
        }
        if (this.aNB) {
            super.setImageBitmap(BitmapHelper.getCashBitmap(d.g.icon_default_avatar100));
        } else {
            super.setImageBitmap(BitmapHelper.getCashBitmap(d.g.btn_see_default));
        }
        this.aiS = 2;
        HB();
    }

    public void HH() {
        if (this.aiS != 1 && this.aiS != 2) {
            int size = this.aNg.size();
            if (size > 0) {
                this.aNg.add(Float.valueOf(this.aNg.get(size - 1).floatValue() * 1.25f));
            } else {
                this.aNg.add(Float.valueOf(this.aNh));
            }
            HK();
        }
    }

    public void HI() {
        if (this.aiS != 1 && this.aiS != 2) {
            int size = this.aNg.size();
            if (size > 1) {
                this.aNg.remove(size - 1);
            }
            HK();
        }
    }

    public void HJ() {
        HC();
        if (this.aiS != 1 && this.aiS != 2 && this.mCurrentScale != this.aNh) {
            this.aNg.clear();
            this.aNg.add(Float.valueOf(this.aNh));
            this.mCurrentScale = this.aNh;
            this.aNj = this.mCurrentScale;
            HK();
        }
    }

    public boolean canZoomIn() {
        if (this.aiS == 1 || this.aiS == 2) {
            return false;
        }
        int size = this.aNg.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.aNg.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.aNl) && floatValue <= 5.0f;
    }

    public boolean canZoomOut() {
        if (this.aiS == 1 || this.aiS == 2) {
            return false;
        }
        int size = this.aNg.size();
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
                    int size = this.aNg.size();
                    if (size > 0) {
                        f2 = this.aNg.get(size - 1).floatValue();
                    } else {
                        f2 = this.aNh;
                    }
                    this.mCurrentScale = f2;
                }
                this.mMatrix.setScale(this.mCurrentScale, this.mCurrentScale);
                this.aNe = imageBitmap.getWidth() * this.mCurrentScale;
                this.aNf = imageBitmap.getHeight() * this.mCurrentScale;
                float width = this.aNj * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.aNj;
                this.aNw = this.mTop;
                this.aNx = 0;
                float f3 = this.aNe < ((float) this.mViewWidth) ? (int) ((this.mViewWidth - this.aNe) / 2.0f) : 0.0f;
                if (this.aNf < this.mViewHeight) {
                    f = (int) ((this.mViewHeight - this.aNf) / 2.0f);
                    if (this.aNm == 1 && f > this.mTop) {
                        f = this.mTop;
                    }
                    this.aNw = (int) (this.mTop - f);
                    this.aNx = this.mTop - this.aNw;
                } else {
                    f = 0.0f;
                }
                this.aNy = (int) f3;
                this.mMatrix.postTranslate(f3, f);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    int width2 = i > getWidth() ? getWidth() : i;
                    if (this.aNe <= screenWidth) {
                        width2 = 0;
                    } else if (this.aNe > screenWidth && this.aNe / 2.0f < screenWidth) {
                        width2 = (int) (width2 - (this.aNe / 4.0f));
                    }
                    scrollX = width2;
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.aNe - width) / 2.0f);
                    }
                    if (this.aNe <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.aNe) {
                        scrollX = (int) (this.aNe - getWidth());
                    }
                }
                if (scrollX > 0 && this.aNe - scrollX < getWidth()) {
                    scrollX = (int) (this.aNe - getWidth());
                }
                int i3 = this.mMode == 2 ? ((int) ((this.aNf - height) / 2.0f)) + scrollY : scrollY;
                if (this.aNf <= getHeight()) {
                    i3 = 0;
                } else if (getHeight() + i3 > this.aNf) {
                    i3 = (int) (this.aNf - getHeight());
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
        private long aNO;
        private long aNP;
        private int aNQ;
        private long aNR;
        private long aNS;
        private int mStartY;
        private boolean aNN = false;
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
            this.aNO = f;
            this.aNP = f2;
            this.aNR = Math.abs((f * 1000.0f) / 2500.0f);
            this.aNS = Math.abs((f2 * 1000.0f) / 2500.0f);
            setDuration(Math.max(this.aNR, this.aNS));
            setInterpolator(a.this.aND);
            this.aNQ = a.this.getScrollX();
            this.mStartY = a.this.getScrollY();
            this.aNN = true;
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
            if (this.aNR > this.aNS) {
                j = ((float) this.aNR) * f;
            } else {
                j = ((float) this.aNS) * f;
            }
            float f2 = ((float) (j > this.aNR ? this.aNR : j)) / 1000.0f;
            if (this.aNO > 0) {
                i = this.aNQ - ((int) (f2 * (((float) this.aNO) - ((2500.0f * f2) / 2.0f))));
            } else {
                i = this.aNQ - ((int) (f2 * (((float) this.aNO) + ((2500.0f * f2) / 2.0f))));
            }
            if (j > this.aNS) {
                j = this.aNS;
            }
            float f3 = ((float) j) / 1000.0f;
            if (this.aNP > 0) {
                i2 = this.mStartY - ((int) (f3 * (((float) this.aNP) - ((2500.0f * f3) / 2.0f))));
            } else {
                i2 = this.mStartY - ((int) (f3 * (((float) this.aNP) + ((2500.0f * f3) / 2.0f))));
            }
            if (a.this.aNf + a.this.mTop + a.this.mBottom > a.this.getHeight()) {
                if (i2 < (-a.this.aNw)) {
                    i2 = -a.this.aNw;
                }
                if (a.this.getHeight() + i2 > a.this.aNf + a.this.mBottom + a.this.aNx) {
                    i2 = (int) ((a.this.aNf - a.this.getHeight()) + a.this.mBottom + a.this.aNx);
                }
            } else {
                i2 = 0;
            }
            if (a.this.aNe > a.this.getWidth()) {
                int width = ((float) (a.this.getWidth() + i)) > a.this.aNe ? (int) (a.this.aNe - a.this.getWidth()) : i;
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
                if (a.this.aNk) {
                    this.aNN = false;
                    return false;
                }
                try {
                    if (super.getTransformation(j, transformation)) {
                        return true;
                    }
                    this.aNN = false;
                    return false;
                } catch (Exception e) {
                    this.aNN = false;
                    return false;
                }
            }
            this.mStop = false;
            this.aNN = false;
            return false;
        }

        public boolean HO() {
            return this.aNN;
        }

        public void stopAnimation() {
            this.mStop = true;
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.aNo = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.awo = onLongClickListener;
    }

    public void setGifSetListener(d dVar) {
        this.awq = dVar;
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
        c poll = this.aNG.poll();
        if (poll == null) {
            this.aNL = true;
            return;
        }
        this.aNL = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.aNF != null) {
            j = this.aNF.delay - (currentTimeMillis - this.aNK);
            this.aNH.offer(this.aNF);
        } else {
            j = 0;
        }
        this.aNF = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public c HM() {
        c poll = this.aNH.poll();
        if (poll == null) {
            poll = new c();
            try {
                poll.aNT = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
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
        public Bitmap aNT;
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
            while (a.this.mState == 1 && a.this.aNu != null && a.this.aNE > 0 && a.this.width > 0 && a.this.height > 0) {
                try {
                    a.this.aNu.W(a.this.aNI);
                    c HM = a.this.HM();
                    if (HM.aNT == null || (HM.aNT.getWidth() != a.this.width && HM.aNT.getHeight() != a.this.height)) {
                        try {
                            HM.aNT = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_8888);
                        } catch (OutOfMemoryError e) {
                            TbadkCoreApplication.getInst().onAppMemoryLow();
                            try {
                                HM.aNT = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_4444);
                            } catch (OutOfMemoryError e2) {
                                TbadkCoreApplication.getInst().onAppMemoryLow();
                            }
                        } catch (Throwable th) {
                            BdLog.e(th.getMessage());
                        }
                    }
                    a.this.aNu.a(HM.aNT, null);
                    HM.delay = a.this.aNu.X(a.this.aNI);
                    a.B(a.this);
                    if (HM.aNT == null) {
                        a.B(a.this);
                    }
                    a.this.aNI %= a.this.aNE;
                    a.this.aNG.put(HM);
                    if (a.this.aNL) {
                        a.this.mHandler.sendEmptyMessage(1);
                    }
                } catch (Exception e3) {
                    return;
                }
            }
        }
    }

    public boolean HN() {
        return this.aNA;
    }

    public void setLoadBigImage(boolean z) {
        this.aNA = z;
    }

    public int getBottomOffset() {
        return this.aNx;
    }

    public int getLeftOffset() {
        return this.aNy;
    }
}
