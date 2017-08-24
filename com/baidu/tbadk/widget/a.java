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
    private int aNA;
    private boolean aNB;
    private boolean aNC;
    private float aND;
    private Interpolator aNE;
    private int aNF;
    private c aNG;
    private BlockingLinkedDeque<c> aNH;
    private BlockingLinkedDeque<c> aNI;
    private volatile int aNJ;
    private b aNK;
    private volatile long aNL;
    private volatile boolean aNM;
    private float aNf;
    private float aNg;
    private ArrayList<Float> aNh;
    private float aNi;
    private float aNj;
    private float aNk;
    private boolean aNl;
    private int aNm;
    private int aNn;
    private e aNo;
    private View.OnClickListener aNp;
    private C0064a aNq;
    private float aNr;
    private boolean aNs;
    private boolean aNt;
    private int aNu;
    private volatile com.baidu.adp.gif.b aNv;
    private Bitmap aNw;
    private int aNx;
    private int aNy;
    private int aNz;
    private int aiS;
    private View.OnLongClickListener awp;
    private d awr;
    private int aws;
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
        int i = aVar.aNJ;
        aVar.aNJ = i + 1;
        return i;
    }

    public void setIsHeadImage(boolean z) {
        this.aNC = z;
    }

    public a(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aNl = false;
        this.mImageData = null;
        this.aws = 0;
        this.aNm = 1300;
        this.aNn = 0;
        this.aNo = null;
        this.aNp = null;
        this.awp = null;
        this.awr = null;
        this.aNr = 1.0f;
        this.aiS = 0;
        this.mMode = 0;
        this.aNs = false;
        this.aNt = false;
        this.aNu = 0;
        this.aNv = null;
        this.aNw = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aNx = 0;
        this.aNy = 0;
        this.aNz = 0;
        this.aNA = 0;
        this.aNE = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aNF = 0;
        this.aNG = null;
        this.aNH = new BlockingLinkedDeque<>(5);
        this.aNI = new BlockingLinkedDeque<>(6);
        this.aNJ = 0;
        this.aNL = 0L;
        this.mState = 0;
        this.aNM = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.a.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        a.this.HL();
                        break;
                    case 1:
                        if (a.this.aNM) {
                            a.this.HL();
                            break;
                        }
                        break;
                    case 2:
                        a.this.invalidate();
                        a.this.aNL = System.currentTimeMillis();
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
        this.aNl = false;
        this.mImageData = null;
        this.aws = 0;
        this.aNm = 1300;
        this.aNn = 0;
        this.aNo = null;
        this.aNp = null;
        this.awp = null;
        this.awr = null;
        this.aNr = 1.0f;
        this.aiS = 0;
        this.mMode = 0;
        this.aNs = false;
        this.aNt = false;
        this.aNu = 0;
        this.aNv = null;
        this.aNw = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aNx = 0;
        this.aNy = 0;
        this.aNz = 0;
        this.aNA = 0;
        this.aNE = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aNF = 0;
        this.aNG = null;
        this.aNH = new BlockingLinkedDeque<>(5);
        this.aNI = new BlockingLinkedDeque<>(6);
        this.aNJ = 0;
        this.aNL = 0L;
        this.mState = 0;
        this.aNM = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.a.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        a.this.HL();
                        break;
                    case 1:
                        if (a.this.aNM) {
                            a.this.HL();
                            break;
                        }
                        break;
                    case 2:
                        a.this.invalidate();
                        a.this.aNL = System.currentTimeMillis();
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
        this.aNl = false;
        this.mImageData = null;
        this.aws = 0;
        this.aNm = 1300;
        this.aNn = 0;
        this.aNo = null;
        this.aNp = null;
        this.awp = null;
        this.awr = null;
        this.aNr = 1.0f;
        this.aiS = 0;
        this.mMode = 0;
        this.aNs = false;
        this.aNt = false;
        this.aNu = 0;
        this.aNv = null;
        this.aNw = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aNx = 0;
        this.aNy = 0;
        this.aNz = 0;
        this.aNA = 0;
        this.aNE = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aNF = 0;
        this.aNG = null;
        this.aNH = new BlockingLinkedDeque<>(5);
        this.aNI = new BlockingLinkedDeque<>(6);
        this.aNJ = 0;
        this.aNL = 0L;
        this.mState = 0;
        this.aNM = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.a.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        a.this.HL();
                        break;
                    case 1:
                        if (a.this.aNM) {
                            a.this.HL();
                            break;
                        }
                        break;
                    case 2:
                        a.this.invalidate();
                        a.this.aNL = System.currentTimeMillis();
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
        this.aNn = i;
    }

    public void k(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.aws = i;
    }

    public void Hz() {
        this.aNt = false;
        this.aNl = false;
        this.mMode = 0;
        HD();
        if (this.mCurrentScale < this.aNi) {
            this.mCurrentScale = this.aNi;
            HK();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.aNl = true;
                this.aNs = false;
                this.aNt = false;
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
            this.aNr = m(motionEvent);
            if (this.aNr > 10.0f) {
                this.mMode = 2;
            }
        }
        if (this.mMode == 2 || !this.mGestureDetector.onTouchEvent(motionEvent)) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.aNs = true;
                        this.aNt = true;
                        if (this.aiS != 1 && this.aiS != 2) {
                            float m = m(motionEvent);
                            if (m >= 0.0f && Math.abs(this.aNr - m) >= 10.0f) {
                                if (Math.abs(this.aNr - m) > 100.0f) {
                                    this.aNr = m;
                                    break;
                                } else {
                                    float f = m / this.aNr;
                                    this.aNr = m;
                                    this.aNk = this.mCurrentScale;
                                    this.mCurrentScale *= f;
                                    if (this.mCurrentScale > this.aNj) {
                                        this.mCurrentScale = this.aNj;
                                    }
                                    if (this.mCurrentScale < this.aNi / 4.0f) {
                                        this.mCurrentScale = this.aNi / 4.0f;
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
        return this.aNi == this.mCurrentScale;
    }

    private void HB() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            if (this.aNn == 0) {
                float width = this.mViewWidth / imageBitmap.getWidth();
                float height = this.mViewHeight / imageBitmap.getHeight();
                if (this.aNC) {
                    if (this.aiS == 2) {
                        this.aNi = 2.5f;
                    } else {
                        this.aNi = Math.min(width, height);
                    }
                } else if (this.aiS == 2) {
                    this.aNi = 1.0f;
                } else {
                    float f = this.aND;
                    float f2 = f >= 1.0f ? f : 1.0f;
                    if (imageBitmap.getWidth() * f2 < this.mViewWidth && imageBitmap.getHeight() * f2 < this.mViewHeight) {
                        this.aNi = f2;
                    } else {
                        this.aNi = Math.min(width, height);
                    }
                }
            } else {
                this.aNi = Math.max(this.mViewWidth / imageBitmap.getWidth(), ((this.mViewHeight - this.mTop) - this.mBottom) / imageBitmap.getHeight());
            }
            this.aNj = this.aNm / (imageBitmap.getWidth() * imageBitmap.getHeight());
            this.aNj = FloatMath.sqrt(this.aNj);
            if (this.aNj > 10.0f) {
                this.aNj = 10.0f;
            }
            this.aNh.clear();
            this.aNh.add(Float.valueOf(this.aNi));
            this.mCurrentScale = this.aNi;
            this.aNk = this.mCurrentScale;
            HK();
            return;
        }
        this.aNf = 0.0f;
        this.aNg = 0.0f;
        this.aNi = 1.0f;
        this.aNj = 1.0f;
        this.mCurrentScale = 1.0f;
        this.aNk = this.mCurrentScale;
        this.aNh.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    private void HC() {
        if (this.aNo != null) {
            this.aNo.a(this, canZoomIn(), canZoomOut());
        }
    }

    public void setOnSizeChangedListener(e eVar) {
        this.aNo = eVar;
    }

    public byte[] getImageData() {
        return this.mImageData;
    }

    public void setImageData(byte[] bArr) {
        this.mImageData = bArr;
    }

    public Bitmap getGifCache() {
        return this.aNw;
    }

    public void setGifCache(Bitmap bitmap) {
        this.aNw = bitmap;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        boolean z;
        int i4;
        if (this.aiS == 2 && this.aNA != 0 && !this.aNq.HO()) {
            int width = getWidth();
            int height = getHeight();
            Drawable drawable = getDrawable();
            float f = 0.0f;
            float f2 = height * 0.3f;
            float f3 = width;
            float f4 = (1.0f - 0.3f) * height;
            if (this.aNC && drawable != null) {
                Rect bounds = drawable.getBounds();
                int i5 = bounds.right - bounds.left;
                int i6 = bounds.bottom - bounds.top;
                f = (width / 2) - (i5 * 2.5f);
                f2 = (height / 2) - (i6 * 2.5f);
                f3 = (i5 * 2.5f) + (width / 2);
                f4 = (i6 * 2.5f) + (height / 2);
            }
            this.mPaint.setColor(ai.getColor(this.aNA));
            canvas.drawRect(f, f2, f3, f4, this.mPaint);
            this.mPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        }
        super.onDraw(canvas);
        if (this.aiS == 1 && this.aNw != null && !this.aNw.isRecycled()) {
            int width2 = this.aNw.getWidth();
            int height2 = this.aNw.getHeight();
            int width3 = getWidth();
            int height3 = getHeight();
            int i7 = (width3 - width2) >> 1;
            int i8 = (height3 - height2) >> 1;
            float f5 = this.aND;
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
            if (this.aNu == 1 && this.aNv != null && this.aNG != null && this.aNG.aNU != null) {
                if (z) {
                    canvas.drawBitmap(this.aNG.aNU, i3, i2, (Paint) null);
                } else {
                    canvas.drawBitmap(this.aNG.aNU, this.mMatrix, this.mPaint);
                }
                invalidate();
            } else if (z) {
                canvas.drawBitmap(this.aNw, i3, i2, (Paint) null);
            } else {
                canvas.drawBitmap(this.aNw, this.mMatrix, this.mPaint);
            }
        }
    }

    public void play() {
        com.baidu.adp.widget.a.a aVar;
        if (this.aiS == 1) {
            if (this.aNv == null) {
                if (this.aNK != null) {
                    this.aNK.interrupt();
                    this.aNK = null;
                }
                if (this.mImageData != null) {
                    try {
                        aVar = a.C0002a.dN().g(this.mImageData, 0, this.mImageData.length);
                    } catch (StackOverflowError e2) {
                        aVar = null;
                    }
                    if (aVar != null && aVar.getGif() != null) {
                        this.aNv = aVar.getGif();
                        if (this.aNv != null) {
                            this.aNu = 1;
                            this.width = this.aNv.getWidth();
                            this.height = this.aNv.getHeight();
                            this.aNJ = 0;
                            this.aNF = this.aNv.dO();
                        } else {
                            this.aNu = 0;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            if (this.aNv != null && this.mState == 0) {
                this.aNM = true;
                this.aNK = new b();
                this.aNH.clear();
                this.aNI.clear();
                this.mState = 1;
                this.aNK.start();
            }
        }
    }

    public void pause() {
        if (this.aiS == 1) {
            this.mState = 0;
            if (this.aNK != null) {
                this.aNK.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.aiS == 1) {
            this.mState = 0;
            if (this.aNK != null) {
                this.aNK.interrupt();
                this.aNK = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.aNM = true;
            this.aNG = null;
            this.aNI.clear();
            this.aNH.clear();
            this.width = 0;
            this.height = 0;
            this.aNJ = 0;
            this.aNF = 0;
            if (this.aNv != null) {
                this.aNv = null;
            }
        }
    }

    private void initData() {
        this.aND = k.ai(getContext());
        this.aNm = k.ah(getContext()) * k.ag(getContext()) * 2;
        if (this.aNm < 1690000) {
            this.aNm = 1690000;
        }
        this.aNf = 0.0f;
        this.aNg = 0.0f;
        this.aNh = new ArrayList<>();
        this.aNi = 1.0f;
        this.aNj = 1.0f;
        this.mCurrentScale = 1.0f;
        this.aNk = this.mCurrentScale;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.aNq = new C0064a();
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
                    a.this.aNq.e(f, f2);
                    a.this.startAnimation(a.this.aNq);
                }
                return super.onFling(motionEvent, motionEvent2, f, f2);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (a.this.aiS != 1 && a.this.aiS != 2) {
                    a.this.mMode = 2;
                    if (a.this.mCurrentScale > a.this.aNi) {
                        a.this.mCurrentScale = a.this.aNi;
                        a.this.aNk = a.this.mCurrentScale;
                        a.this.HK();
                        return true;
                    }
                    a.this.mCurrentScale = a.this.aNi * 2.0f;
                    a.this.e(true, (int) motionEvent.getX(), (int) motionEvent.getY());
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (a.this.aNp != null && !a.this.aNs) {
                    a.this.aNp.onClick(a.this);
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
                a.this.aNs = true;
                if (a.this.aNn == 0 && a.this.aNt) {
                    return false;
                }
                int scrollX = a.this.getScrollX();
                if (a.this.aNf >= a.this.getWidth()) {
                    scrollX = (int) (scrollX + f);
                    if (a.this.aNn == 0) {
                        i = scrollX >= 0 ? scrollX : 0;
                        if (a.this.getWidth() + i > a.this.aNf) {
                            i = (int) (a.this.aNf - a.this.getWidth());
                        }
                        scrollY = a.this.getScrollY();
                        if (a.this.aNg + a.this.mTop + a.this.mBottom >= a.this.getHeight()) {
                            scrollY = (int) (scrollY + f2);
                            if (a.this.aNn == 0) {
                                if (scrollY < (-a.this.aNx)) {
                                    scrollY = -a.this.aNx;
                                }
                                if (a.this.getHeight() + scrollY > a.this.aNg + a.this.mBottom + a.this.aNy) {
                                    scrollY = (int) ((a.this.aNg - a.this.getHeight()) + a.this.mBottom + a.this.aNy);
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
                if (a.this.aNg + a.this.mTop + a.this.mBottom >= a.this.getHeight()) {
                }
                if (i == a.this.getScrollX()) {
                }
                a.this.scrollTo(i, scrollY);
                a.this.invalidate();
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (a.this.awp != null && !a.this.aNs) {
                    a.this.awp.onLongClick(a.this);
                }
                super.onLongPress(motionEvent);
            }
        });
    }

    private void HD() {
        int i = 0;
        int scrollX = getScrollX();
        if (this.aNf >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.aNf) {
                scrollX = (int) (this.aNf - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.aNg + this.mTop + this.mBottom >= getHeight()) {
            i = scrollY < (-this.aNx) ? -this.aNx : scrollY;
            if (getHeight() + i > this.aNg + this.mBottom + this.aNy) {
                i = (int) ((this.aNg - getHeight()) + this.mBottom + this.aNy);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.aNf;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.aNg;
    }

    public boolean HE() {
        if (this.aiS == 1 || this.aiS == 2) {
            return true;
        }
        return !this.aNt && getScrollX() >= ((int) (this.aNf - ((float) getWidth()))) + (-1);
    }

    public boolean HF() {
        if (this.aiS == 1 || this.aiS == 2) {
            return true;
        }
        return !this.aNt && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.aNq.HO()) {
            this.aNq.stopAnimation();
        }
        this.aNA = 0;
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
            if (this.aNq.HO()) {
                this.aNq.stopAnimation();
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
        if (this.aNq.HO()) {
            this.aNq.stopAnimation();
        }
        super.setImageDrawable(null);
        stop();
        HB();
        this.aiS = 1;
        this.aNw = bitmap;
        this.mImageData = bArr;
        if (this.awr != null) {
            this.awr.a(this);
        }
    }

    public void onDestroy() {
        if (this.aNq.HO()) {
            this.aNq.stopAnimation();
        }
        super.setImageDrawable(null);
        this.mImageData = null;
        this.aNw = null;
        stop();
        if (this.aNv != null) {
            this.aNv.close();
            this.aNv = null;
        }
    }

    public void release() {
        if (this.aNq.HO()) {
            this.aNq.stopAnimation();
        }
        stop();
        super.setImageDrawable(null);
        this.aNw = null;
    }

    public void HG() {
        if (this.aNq.HO()) {
            this.aNq.stopAnimation();
        }
        if (this.aNC) {
            super.setImageBitmap(BitmapHelper.getCashBitmap(d.g.icon_default_avatar100));
        } else {
            super.setImageBitmap(BitmapHelper.getCashBitmap(d.g.btn_see_default));
        }
        this.aiS = 2;
        HB();
    }

    public void HH() {
        if (this.aiS != 1 && this.aiS != 2) {
            int size = this.aNh.size();
            if (size > 0) {
                this.aNh.add(Float.valueOf(this.aNh.get(size - 1).floatValue() * 1.25f));
            } else {
                this.aNh.add(Float.valueOf(this.aNi));
            }
            HK();
        }
    }

    public void HI() {
        if (this.aiS != 1 && this.aiS != 2) {
            int size = this.aNh.size();
            if (size > 1) {
                this.aNh.remove(size - 1);
            }
            HK();
        }
    }

    public void HJ() {
        HC();
        if (this.aiS != 1 && this.aiS != 2 && this.mCurrentScale != this.aNi) {
            this.aNh.clear();
            this.aNh.add(Float.valueOf(this.aNi));
            this.mCurrentScale = this.aNi;
            this.aNk = this.mCurrentScale;
            HK();
        }
    }

    public boolean canZoomIn() {
        if (this.aiS == 1 || this.aiS == 2) {
            return false;
        }
        int size = this.aNh.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.aNh.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.aNm) && floatValue <= 5.0f;
    }

    public boolean canZoomOut() {
        if (this.aiS == 1 || this.aiS == 2) {
            return false;
        }
        int size = this.aNh.size();
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
                    int size = this.aNh.size();
                    if (size > 0) {
                        f2 = this.aNh.get(size - 1).floatValue();
                    } else {
                        f2 = this.aNi;
                    }
                    this.mCurrentScale = f2;
                }
                this.mMatrix.setScale(this.mCurrentScale, this.mCurrentScale);
                this.aNf = imageBitmap.getWidth() * this.mCurrentScale;
                this.aNg = imageBitmap.getHeight() * this.mCurrentScale;
                float width = this.aNk * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.aNk;
                this.aNx = this.mTop;
                this.aNy = 0;
                float f3 = this.aNf < ((float) this.mViewWidth) ? (int) ((this.mViewWidth - this.aNf) / 2.0f) : 0.0f;
                if (this.aNg < this.mViewHeight) {
                    f = (int) ((this.mViewHeight - this.aNg) / 2.0f);
                    if (this.aNn == 1 && f > this.mTop) {
                        f = this.mTop;
                    }
                    this.aNx = (int) (this.mTop - f);
                    this.aNy = this.mTop - this.aNx;
                } else {
                    f = 0.0f;
                }
                this.aNz = (int) f3;
                this.mMatrix.postTranslate(f3, f);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    int width2 = i > getWidth() ? getWidth() : i;
                    if (this.aNf <= screenWidth) {
                        width2 = 0;
                    } else if (this.aNf > screenWidth && this.aNf / 2.0f < screenWidth) {
                        width2 = (int) (width2 - (this.aNf / 4.0f));
                    }
                    scrollX = width2;
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.aNf - width) / 2.0f);
                    }
                    if (this.aNf <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.aNf) {
                        scrollX = (int) (this.aNf - getWidth());
                    }
                }
                if (scrollX > 0 && this.aNf - scrollX < getWidth()) {
                    scrollX = (int) (this.aNf - getWidth());
                }
                int i3 = this.mMode == 2 ? ((int) ((this.aNg - height) / 2.0f)) + scrollY : scrollY;
                if (this.aNg <= getHeight()) {
                    i3 = 0;
                } else if (getHeight() + i3 > this.aNg) {
                    i3 = (int) (this.aNg - getHeight());
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
        private long aNP;
        private long aNQ;
        private int aNR;
        private long aNS;
        private long aNT;
        private int mStartY;
        private boolean aNO = false;
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
            this.aNP = f;
            this.aNQ = f2;
            this.aNS = Math.abs((f * 1000.0f) / 2500.0f);
            this.aNT = Math.abs((f2 * 1000.0f) / 2500.0f);
            setDuration(Math.max(this.aNS, this.aNT));
            setInterpolator(a.this.aNE);
            this.aNR = a.this.getScrollX();
            this.mStartY = a.this.getScrollY();
            this.aNO = true;
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
            if (this.aNS > this.aNT) {
                j = ((float) this.aNS) * f;
            } else {
                j = ((float) this.aNT) * f;
            }
            float f2 = ((float) (j > this.aNS ? this.aNS : j)) / 1000.0f;
            if (this.aNP > 0) {
                i = this.aNR - ((int) (f2 * (((float) this.aNP) - ((2500.0f * f2) / 2.0f))));
            } else {
                i = this.aNR - ((int) (f2 * (((float) this.aNP) + ((2500.0f * f2) / 2.0f))));
            }
            if (j > this.aNT) {
                j = this.aNT;
            }
            float f3 = ((float) j) / 1000.0f;
            if (this.aNQ > 0) {
                i2 = this.mStartY - ((int) (f3 * (((float) this.aNQ) - ((2500.0f * f3) / 2.0f))));
            } else {
                i2 = this.mStartY - ((int) (f3 * (((float) this.aNQ) + ((2500.0f * f3) / 2.0f))));
            }
            if (a.this.aNg + a.this.mTop + a.this.mBottom > a.this.getHeight()) {
                if (i2 < (-a.this.aNx)) {
                    i2 = -a.this.aNx;
                }
                if (a.this.getHeight() + i2 > a.this.aNg + a.this.mBottom + a.this.aNy) {
                    i2 = (int) ((a.this.aNg - a.this.getHeight()) + a.this.mBottom + a.this.aNy);
                }
            } else {
                i2 = 0;
            }
            if (a.this.aNf > a.this.getWidth()) {
                int width = ((float) (a.this.getWidth() + i)) > a.this.aNf ? (int) (a.this.aNf - a.this.getWidth()) : i;
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
                if (a.this.aNl) {
                    this.aNO = false;
                    return false;
                }
                try {
                    if (super.getTransformation(j, transformation)) {
                        return true;
                    }
                    this.aNO = false;
                    return false;
                } catch (Exception e) {
                    this.aNO = false;
                    return false;
                }
            }
            this.mStop = false;
            this.aNO = false;
            return false;
        }

        public boolean HO() {
            return this.aNO;
        }

        public void stopAnimation() {
            this.mStop = true;
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.aNp = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.awp = onLongClickListener;
    }

    public void setGifSetListener(d dVar) {
        this.awr = dVar;
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
        c poll = this.aNH.poll();
        if (poll == null) {
            this.aNM = true;
            return;
        }
        this.aNM = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.aNG != null) {
            j = this.aNG.delay - (currentTimeMillis - this.aNL);
            this.aNI.offer(this.aNG);
        } else {
            j = 0;
        }
        this.aNG = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public c HM() {
        c poll = this.aNI.poll();
        if (poll == null) {
            poll = new c();
            try {
                poll.aNU = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
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
        public Bitmap aNU;
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
            while (a.this.mState == 1 && a.this.aNv != null && a.this.aNF > 0 && a.this.width > 0 && a.this.height > 0) {
                try {
                    a.this.aNv.W(a.this.aNJ);
                    c HM = a.this.HM();
                    if (HM.aNU == null || (HM.aNU.getWidth() != a.this.width && HM.aNU.getHeight() != a.this.height)) {
                        try {
                            HM.aNU = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_8888);
                        } catch (OutOfMemoryError e) {
                            TbadkCoreApplication.getInst().onAppMemoryLow();
                            try {
                                HM.aNU = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_4444);
                            } catch (OutOfMemoryError e2) {
                                TbadkCoreApplication.getInst().onAppMemoryLow();
                            }
                        } catch (Throwable th) {
                            BdLog.e(th.getMessage());
                        }
                    }
                    a.this.aNv.a(HM.aNU, null);
                    HM.delay = a.this.aNv.X(a.this.aNJ);
                    a.B(a.this);
                    if (HM.aNU == null) {
                        a.B(a.this);
                    }
                    a.this.aNJ %= a.this.aNF;
                    a.this.aNH.put(HM);
                    if (a.this.aNM) {
                        a.this.mHandler.sendEmptyMessage(1);
                    }
                } catch (Exception e3) {
                    return;
                }
            }
        }
    }

    public boolean HN() {
        return this.aNB;
    }

    public void setLoadBigImage(boolean z) {
        this.aNB = z;
    }

    public int getBottomOffset() {
        return this.aNy;
    }

    public int getLeftOffset() {
        return this.aNz;
    }
}
