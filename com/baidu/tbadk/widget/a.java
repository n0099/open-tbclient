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
    private static final int axV = l.ae(TbadkCoreApplication.getInst()) / 5;
    private float aMU;
    private float aMV;
    private ArrayList<Float> aMW;
    private float aMX;
    private float aMY;
    private float aMZ;
    private BlockingLinkedDeque<c> aNA;
    private BlockingLinkedDeque<c> aNB;
    private volatile int aNC;
    private b aND;
    private volatile long aNE;
    private volatile boolean aNF;
    private boolean aNa;
    private byte[] aNb;
    private int aNc;
    private int aNd;
    private f aNe;
    private View.OnClickListener aNf;
    private C0065a aNg;
    private float aNh;
    private boolean aNi;
    private boolean aNj;
    private int aNk;
    private volatile com.baidu.adp.gif.b aNl;
    private Bitmap aNm;
    private int aNn;
    private int aNo;
    private int aNp;
    private int aNq;
    private boolean aNr;
    private boolean aNs;
    private float aNt;
    private com.baidu.tbadk.widget.a.b.b aNu;
    private ImageUrlData aNv;
    private Interpolator aNw;
    private Rect aNx;
    private int aNy;
    private c aNz;
    public int ahY;
    private View.OnLongClickListener auZ;
    private e avc;
    private int avd;
    private boolean axN;
    private float axO;
    private Matrix axP;
    private Rect axQ;
    private RectF axR;
    private d axU;
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
        public Bitmap aNO;
        public int delay;
    }

    /* loaded from: classes.dex */
    public interface d {
        void HM();

        void HN();
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
        int i = aVar.aNC;
        aVar.aNC = i + 1;
        return i;
    }

    public void setIsHeadImage(boolean z) {
        this.aNs = z;
    }

    public void setImageUrlData(ImageUrlData imageUrlData) {
        this.aNv = imageUrlData;
    }

    public a(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aNa = false;
        this.aNb = null;
        this.avd = 0;
        this.aNc = 1300;
        this.aNd = 0;
        this.aNe = null;
        this.aNf = null;
        this.auZ = null;
        this.avc = null;
        this.aNh = 1.0f;
        this.ahY = 0;
        this.mMode = 0;
        this.aNi = false;
        this.aNj = false;
        this.aNk = 0;
        this.aNl = null;
        this.aNm = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aNn = 0;
        this.aNo = 0;
        this.aNp = 0;
        this.aNq = 0;
        this.aNw = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.axP = new Matrix();
        this.axN = false;
        this.mRatio = 1.0f;
        this.axO = 0.0f;
        this.axR = new RectF();
        this.width = 0;
        this.height = 0;
        this.aNy = 0;
        this.aNz = null;
        this.aNA = new BlockingLinkedDeque<>(5);
        this.aNB = new BlockingLinkedDeque<>(6);
        this.aNC = 0;
        this.aNE = 0L;
        this.mState = 0;
        this.aNF = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.a.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        a.this.HI();
                        break;
                    case 1:
                        if (a.this.aNF) {
                            a.this.HI();
                            break;
                        }
                        break;
                    case 2:
                        a.this.invalidate();
                        a.this.aNE = System.currentTimeMillis();
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
        this.aNa = false;
        this.aNb = null;
        this.avd = 0;
        this.aNc = 1300;
        this.aNd = 0;
        this.aNe = null;
        this.aNf = null;
        this.auZ = null;
        this.avc = null;
        this.aNh = 1.0f;
        this.ahY = 0;
        this.mMode = 0;
        this.aNi = false;
        this.aNj = false;
        this.aNk = 0;
        this.aNl = null;
        this.aNm = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aNn = 0;
        this.aNo = 0;
        this.aNp = 0;
        this.aNq = 0;
        this.aNw = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.axP = new Matrix();
        this.axN = false;
        this.mRatio = 1.0f;
        this.axO = 0.0f;
        this.axR = new RectF();
        this.width = 0;
        this.height = 0;
        this.aNy = 0;
        this.aNz = null;
        this.aNA = new BlockingLinkedDeque<>(5);
        this.aNB = new BlockingLinkedDeque<>(6);
        this.aNC = 0;
        this.aNE = 0L;
        this.mState = 0;
        this.aNF = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.a.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        a.this.HI();
                        break;
                    case 1:
                        if (a.this.aNF) {
                            a.this.HI();
                            break;
                        }
                        break;
                    case 2:
                        a.this.invalidate();
                        a.this.aNE = System.currentTimeMillis();
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
        this.aNa = false;
        this.aNb = null;
        this.avd = 0;
        this.aNc = 1300;
        this.aNd = 0;
        this.aNe = null;
        this.aNf = null;
        this.auZ = null;
        this.avc = null;
        this.aNh = 1.0f;
        this.ahY = 0;
        this.mMode = 0;
        this.aNi = false;
        this.aNj = false;
        this.aNk = 0;
        this.aNl = null;
        this.aNm = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aNn = 0;
        this.aNo = 0;
        this.aNp = 0;
        this.aNq = 0;
        this.aNw = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.axP = new Matrix();
        this.axN = false;
        this.mRatio = 1.0f;
        this.axO = 0.0f;
        this.axR = new RectF();
        this.width = 0;
        this.height = 0;
        this.aNy = 0;
        this.aNz = null;
        this.aNA = new BlockingLinkedDeque<>(5);
        this.aNB = new BlockingLinkedDeque<>(6);
        this.aNC = 0;
        this.aNE = 0L;
        this.mState = 0;
        this.aNF = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.a.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        a.this.HI();
                        break;
                    case 1:
                        if (a.this.aNF) {
                            a.this.HI();
                            break;
                        }
                        break;
                    case 2:
                        a.this.invalidate();
                        a.this.aNE = System.currentTimeMillis();
                        a.this.mHandler.sendEmptyMessage(0);
                        break;
                }
                return false;
            }
        });
        initData();
    }

    public void setDragToExitListener(d dVar) {
        this.axU = dVar;
    }

    public int getImageType() {
        return this.ahY;
    }

    public void setImageMode(int i) {
        this.aNd = i;
    }

    public void i(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.avd = i;
    }

    public boolean Ht() {
        if (this.aNu != null) {
            return this.aNu.Ht();
        }
        return false;
    }

    public void Hu() {
        this.aNj = false;
        this.aNa = false;
        this.mMode = 3;
        HA();
        if (this.mCurrentScale < this.aMX) {
            this.mCurrentScale = this.aMX;
            HH();
        }
        invalidate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.aNu != null && this.aNu.onTouchEvent(motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.aNa = true;
                this.aNi = false;
                this.aNj = false;
                break;
            case 1:
                Hu();
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
            this.aNh = m(motionEvent);
            if (this.aNh > 10.0f) {
                this.mMode = 2;
            }
        }
        if (this.mMode == 2 || !this.mGestureDetector.onTouchEvent(motionEvent)) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.aNi = true;
                        this.aNj = true;
                        if (this.ahY != 1 && this.ahY != 2) {
                            float m = m(motionEvent);
                            if (m >= 0.0f && Math.abs(this.aNh - m) >= 10.0f) {
                                if (Math.abs(this.aNh - m) > 100.0f) {
                                    this.aNh = m;
                                    break;
                                } else {
                                    float f2 = m / this.aNh;
                                    this.aNh = m;
                                    this.aMZ = this.mCurrentScale;
                                    this.mCurrentScale *= f2;
                                    if (this.mCurrentScale > this.aMY) {
                                        this.mCurrentScale = this.aMY;
                                    }
                                    float minScaleValue = getMinScaleValue();
                                    if (this.mCurrentScale < minScaleValue) {
                                        this.mCurrentScale = minScaleValue;
                                    }
                                    HH();
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
        return this.aNu != null ? this.aNu.getMinScaleValue() : this.aMX / 4.0f;
    }

    public float m(MotionEvent motionEvent) {
        return CompatibleUtile.getInstance().getSpacing(motionEvent);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            this.mViewWidth = i3 - i;
            this.mViewHeight = i4 - i2;
            Hw();
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public boolean Hv() {
        if (this.aNu != null) {
            return this.aNu.Ih();
        }
        return this.aMX == this.mCurrentScale;
    }

    protected float f(Bitmap bitmap) {
        if (this.aNu != null) {
            return this.aNu.Il();
        }
        if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            return 1.0f;
        }
        if (this.aNd == 0) {
            float width = this.mViewWidth / bitmap.getWidth();
            float height = this.mViewHeight / bitmap.getHeight();
            if (this.aNs) {
                if (this.ahY == 2) {
                    return 2.5f;
                }
                return Math.min(width, height);
            } else if (this.ahY != 2) {
                float f2 = this.aNt;
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
        if (this.aNu != null) {
            return this.aNu.Im();
        }
        float f2 = 1.0f;
        if (bitmap != null && !bitmap.isRecycled() && bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
            f2 = FloatMath.sqrt(this.aNc / (bitmap.getWidth() * bitmap.getHeight()));
            if (f2 > 10.0f) {
                return 10.0f;
            }
        }
        return f2;
    }

    private void Hw() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            this.aMX = f(imageBitmap);
            this.aMY = g(imageBitmap);
            this.aMW.clear();
            this.aMW.add(Float.valueOf(this.aMX));
            this.mCurrentScale = this.aMX;
            this.aMZ = this.mCurrentScale;
            HH();
            return;
        }
        this.aMU = 0.0f;
        this.aMV = 0.0f;
        this.aMX = 1.0f;
        this.aMY = 1.0f;
        this.mCurrentScale = 1.0f;
        this.aMZ = this.mCurrentScale;
        this.aMW.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    private void Hx() {
        if (this.aNe != null) {
            this.aNe.a(this, canZoomIn(), canZoomOut());
        }
    }

    public void setOnSizeChangedListener(f fVar) {
        this.aNe = fVar;
    }

    public byte[] getImageData() {
        return this.aNb;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getMeasuredHeight() != 0 && getMeasuredWidth() != 0 && this.aNu != null) {
            this.aNu.Ij();
        }
    }

    public void a(Bitmap bitmap, byte[] bArr) {
        this.aNb = bArr;
        if (this.aNu != null) {
            this.aNu.b(bitmap, bArr);
        }
        setImageBitmap(bitmap);
    }

    public void Hy() {
        if (this.aNu == null) {
            this.aNu = new com.baidu.tbadk.widget.a.b.b(this);
            this.aNu.setOnClickListener(this.aNf);
            this.aNu.setOnLongClickListener(this.auZ);
        }
    }

    public void setImageLoadCallBack(com.baidu.tbadk.widget.a.b.a aVar) {
        if (this.aNu != null) {
            this.aNu.a(aVar);
        }
    }

    public boolean Hz() {
        return (getImageBitmap() == null || this.aNu == null) ? false : true;
    }

    public Bitmap getGifCache() {
        return this.aNm;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        boolean z;
        if (this.aNu == null || !this.aNu.b(canvas, getImageBitmap())) {
            if (this.ahY == 2 && this.aNq != 0 && !this.aNg.HL()) {
                int width = getWidth();
                int height = getHeight();
                Drawable drawable = getDrawable();
                float f2 = 0.0f;
                float f3 = height * 0.3f;
                float f4 = width;
                float f5 = (1.0f - 0.3f) * height;
                if (this.aNs && drawable != null) {
                    Rect bounds = drawable.getBounds();
                    int i = bounds.right - bounds.left;
                    int i2 = bounds.bottom - bounds.top;
                    f2 = (width / 2) - (i * 2.5f);
                    f3 = (height / 2) - (i2 * 2.5f);
                    f4 = (i * 2.5f) + (width / 2);
                    f5 = (i2 * 2.5f) + (height / 2);
                }
                this.mPaint.setColor(aj.getColor(this.aNq));
                canvas.drawRect(f2, f3, f4, f5, this.mPaint);
                this.mPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
            }
            if (this.mMode == 3 && this.axN) {
                this.axN = false;
                this.axP.reset();
                if (this.axO < axV) {
                    this.mMode = 0;
                } else {
                    this.mMode = 4;
                    Bo();
                }
            }
            if (this.ahY == 0 && this.axN && this.axQ != null && this.aNv != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                if (this.axR == null) {
                    this.axR = new RectF();
                }
                this.axP.mapRect(this.axR, new RectF(this.axQ));
                Bitmap imageBitmap = getImageBitmap();
                if (imageBitmap != null && !imageBitmap.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.aNx, this.axR, (Paint) null);
                }
            } else if (this.mMode == 4 && this.axQ != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                Bitmap imageBitmap2 = getImageBitmap();
                if (imageBitmap2 != null && !imageBitmap2.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.aNx, this.axR, (Paint) null);
                }
            } else {
                super.onDraw(canvas);
            }
            if (this.ahY == 1 && this.aNm != null && !this.aNm.isRecycled()) {
                int width2 = this.aNm.getWidth();
                int height2 = this.aNm.getHeight();
                int width3 = getWidth();
                int height3 = getHeight();
                int i3 = (width3 - width2) >> 1;
                int i4 = (height3 - height2) >> 1;
                float f6 = this.aNt;
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
                if (this.aNk == 1 && this.aNl != null && this.aNz != null && this.aNz.aNO != null) {
                    if (z) {
                        canvas.drawBitmap(this.aNz.aNO, i3, i4, (Paint) null);
                    } else {
                        canvas.drawBitmap(this.aNz.aNO, this.mMatrix, this.mPaint);
                    }
                    invalidate();
                } else if (z) {
                    canvas.drawBitmap(this.aNm, i3, i4, (Paint) null);
                } else {
                    canvas.drawBitmap(this.aNm, this.mMatrix, this.mPaint);
                }
            }
        }
    }

    public void play() {
        com.baidu.adp.widget.a.a aVar;
        if (this.ahY == 1) {
            if (this.aNl == null) {
                if (this.aND != null) {
                    this.aND.interrupt();
                    this.aND = null;
                }
                if (this.aNb != null) {
                    try {
                        aVar = a.C0002a.dD().g(this.aNb, 0, this.aNb.length);
                    } catch (StackOverflowError e2) {
                        aVar = null;
                    }
                    if (aVar != null && aVar.getGif() != null) {
                        this.aNl = aVar.getGif();
                        if (this.aNl != null) {
                            this.aNk = 1;
                            this.width = this.aNl.getWidth();
                            this.height = this.aNl.getHeight();
                            this.aNC = 0;
                            this.aNy = this.aNl.getFrameCount();
                        } else {
                            this.aNk = 0;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            if (this.aNl != null && this.mState == 0) {
                this.aNF = true;
                this.aND = new b();
                this.aNA.clear();
                this.aNB.clear();
                this.mState = 1;
                this.aND.start();
            }
        }
    }

    public void pause() {
        if (this.ahY == 1) {
            this.mState = 0;
            if (this.aND != null) {
                this.aND.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.ahY == 1) {
            this.mState = 0;
            if (this.aND != null) {
                this.aND.interrupt();
                this.aND = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.aNF = true;
            this.aNz = null;
            this.aNB.clear();
            this.aNA.clear();
            this.width = 0;
            this.height = 0;
            this.aNC = 0;
            this.aNy = 0;
            this.aNl = null;
        }
    }

    private void initData() {
        this.aNt = l.af(getContext());
        this.aNc = l.ae(getContext()) * l.ac(getContext()) * 2;
        if (this.aNc < 1690000) {
            this.aNc = 1690000;
        }
        this.aMU = 0.0f;
        this.aMV = 0.0f;
        this.aMW = new ArrayList<>();
        this.aMX = 1.0f;
        this.aMY = 1.0f;
        this.mCurrentScale = 1.0f;
        this.aMZ = this.mCurrentScale;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.aNg = new C0065a();
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
                    a.this.aNg.e(f2, f3);
                    a.this.startAnimation(a.this.aNg);
                }
                return super.onFling(motionEvent, motionEvent2, f2, f3);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (a.this.ahY != 1 && a.this.ahY != 2) {
                    a.this.mMode = 2;
                    if (a.this.mCurrentScale > a.this.aMX) {
                        a.this.mCurrentScale = a.this.aMX;
                        a.this.aMZ = a.this.mCurrentScale;
                        a.this.HH();
                        return true;
                    }
                    a.this.mCurrentScale = a.this.aMX * 2.0f;
                    a.this.d(true, (int) motionEvent.getX(), (int) motionEvent.getY());
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (a.this.aNf != null && !a.this.aNi) {
                    a.this.aNf.onClick(a.this);
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
                a.this.aNi = true;
                if (a.this.aNd == 0 && a.this.aNj) {
                    return false;
                }
                int scrollX = a.this.getScrollX();
                int scrollY = a.this.getScrollY();
                if (a.this.aMU >= a.this.getWidth()) {
                    scrollX = (int) (scrollX + f2);
                    if (a.this.aNd == 0) {
                        i = scrollX >= 0 ? scrollX : 0;
                        if (a.this.getWidth() + i > a.this.aMU) {
                            i = (int) (a.this.aMU - a.this.getWidth());
                        }
                        if (a.this.aMV + a.this.mTop + a.this.mBottom < a.this.getHeight()) {
                            i2 = (int) (scrollY + f3);
                            if (a.this.aNd == 0) {
                                if (i2 < (-a.this.aNn)) {
                                    i2 = -a.this.aNn;
                                }
                                if (a.this.getHeight() + i2 > a.this.aMV + a.this.mBottom + a.this.aNo) {
                                    i2 = (int) ((a.this.aMV - a.this.getHeight()) + a.this.mBottom + a.this.aNo);
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
                if (a.this.aMV + a.this.mTop + a.this.mBottom < a.this.getHeight()) {
                }
                if (i == a.this.getScrollX()) {
                }
                a.this.scrollTo(i, i2);
                a.this.invalidate();
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (a.this.auZ != null && !a.this.aNi) {
                    a.this.auZ.onLongClick(a.this);
                }
                super.onLongPress(motionEvent);
            }
        });
    }

    private void Bo() {
        if (this.aNv == null) {
            if (this.axU != null) {
                this.axU.HN();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.aNv.getSourceImageRectInScreen();
        if (sourceImageRectInScreen == null) {
            if (this.axU != null) {
                this.axU.HN();
                return;
            }
            return;
        }
        this.axR.bottom = (((sourceImageRectInScreen.bottom - sourceImageRectInScreen.top) / (sourceImageRectInScreen.right - sourceImageRectInScreen.left)) * (this.axR.right - this.axR.left)) + this.axR.top;
        final float[] fArr = {(this.axR.left + this.axR.right) / 2.0f, (this.axR.top + this.axR.bottom) / 2.0f};
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
                    a.this.axR = a.this.e(floatValue, animatedFraction, sourceImageRectInScreen.right - sourceImageRectInScreen.left, sourceImageRectInScreen.bottom - sourceImageRectInScreen.top);
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
                a.this.axN = false;
                a.this.mMode = 4;
                a.this.invalidate();
                if (a.this.axU != null) {
                    a.this.axU.HN();
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

    private void HA() {
        int i = 0;
        int scrollX = getScrollX();
        if (this.aMU >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.aMU) {
                scrollX = (int) (this.aMU - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.aMV + this.mTop + this.mBottom >= getHeight()) {
            i = scrollY < (-this.aNn) ? -this.aNn : scrollY;
            if (getHeight() + i > this.aMV + this.mBottom + this.aNo) {
                i = (int) ((this.aMV - getHeight()) + this.mBottom + this.aNo);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.aNu != null) {
            this.aNu.Ii();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.aMU;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.aMV;
    }

    public boolean HB() {
        if (this.ahY == 1 || this.ahY == 2) {
            return true;
        }
        return !this.aNj && getScrollX() >= ((int) (this.aMU - ((float) getWidth()))) + (-1);
    }

    public boolean HC() {
        if (this.ahY == 1 || this.ahY == 2) {
            return true;
        }
        return !this.aNj && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.aNg.HL()) {
            this.aNg.stopAnimation();
        }
        this.aNq = 0;
        super.setImageBitmap(bitmap);
        Hw();
        this.ahY = 0;
        if (this.axQ == null) {
            int measuredWidth = getMeasuredWidth();
            float measuredWidth2 = ((1.0f * getMeasuredWidth()) / bitmap.getWidth()) * bitmap.getHeight();
            if (measuredWidth2 > getMeasuredHeight()) {
                measuredWidth2 = getMeasuredHeight();
            }
            RectF e2 = e(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
            this.axQ = new Rect((int) e2.left, (int) e2.top, (int) e2.right, (int) e2.bottom);
        }
        if (this.aNx == null) {
            this.aNx = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
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
            if (this.aNg.HL()) {
                this.aNg.stopAnimation();
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
        if (this.aNg.HL()) {
            this.aNg.stopAnimation();
        }
        super.setImageDrawable(null);
        stop();
        Hw();
        this.ahY = 1;
        this.aNm = bitmap;
        this.aNb = bArr;
        if (this.avc != null) {
            this.avc.a(this);
        }
    }

    public void onDestroy() {
        if (this.aNg.HL()) {
            this.aNg.stopAnimation();
        }
        super.setImageDrawable(null);
        this.aNb = null;
        this.aNm = null;
        stop();
        if (this.aNl != null) {
            this.aNl.close();
            this.aNl = null;
        }
        if (this.aNu != null) {
            this.aNu.release();
            System.gc();
        }
    }

    public void release() {
        if (this.aNg.HL()) {
            this.aNg.stopAnimation();
        }
        stop();
        super.setImageDrawable(null);
        this.aNm = null;
    }

    public void HD() {
        if (this.aNg.HL()) {
            this.aNg.stopAnimation();
        }
        try {
            if (this.aNs) {
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
        Hw();
    }

    public void HE() {
        if (this.ahY != 1 && this.ahY != 2) {
            int size = this.aMW.size();
            if (size > 0) {
                this.aMW.add(Float.valueOf(this.aMW.get(size - 1).floatValue() * 1.25f));
            } else {
                this.aMW.add(Float.valueOf(this.aMX));
            }
            HH();
        }
    }

    public void HF() {
        if (this.ahY != 1 && this.ahY != 2) {
            int size = this.aMW.size();
            if (size > 1) {
                this.aMW.remove(size - 1);
            }
            HH();
        }
    }

    public void HG() {
        Hx();
        if (this.ahY != 1 && this.ahY != 2 && this.mCurrentScale != this.aMX) {
            this.aMW.clear();
            this.aMW.add(Float.valueOf(this.aMX));
            this.mCurrentScale = this.aMX;
            this.aMZ = this.mCurrentScale;
            HH();
        }
    }

    public boolean canZoomIn() {
        if (this.ahY == 1 || this.ahY == 2) {
            return false;
        }
        int size = this.aMW.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.aMW.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.aNc) && floatValue <= 5.0f;
    }

    public boolean canZoomOut() {
        if (this.ahY == 1 || this.ahY == 2) {
            return false;
        }
        int size = this.aMW.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled()) {
            return false;
        }
        return size > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HH() {
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
                    int size = this.aMW.size();
                    if (size > 0) {
                        f3 = this.aMW.get(size - 1).floatValue();
                    } else {
                        f3 = this.aMX;
                    }
                    this.mCurrentScale = f3;
                }
                this.mMatrix.setScale(this.mCurrentScale, this.mCurrentScale);
                this.aMU = imageBitmap.getWidth() * this.mCurrentScale;
                this.aMV = imageBitmap.getHeight() * this.mCurrentScale;
                float width = this.aMZ * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.aMZ;
                this.aNn = this.mTop;
                this.aNo = 0;
                float f4 = this.aMU < ((float) this.mViewWidth) ? (int) ((this.mViewWidth - this.aMU) / 2.0f) : 0.0f;
                if (this.aMV < this.mViewHeight) {
                    f2 = (int) ((this.mViewHeight - this.aMV) / 2.0f);
                    if (this.aNd == 1 && f2 > this.mTop) {
                        f2 = this.mTop;
                    }
                    this.aNn = (int) (this.mTop - f2);
                    this.aNo = this.mTop - this.aNn;
                } else {
                    f2 = 0.0f;
                }
                this.aNp = (int) f4;
                this.mMatrix.postTranslate(f4, f2);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    int width2 = i > getWidth() ? getWidth() : i;
                    if (this.aMU <= screenWidth) {
                        width2 = 0;
                    } else if (this.aMU > screenWidth && this.aMU / 2.0f < screenWidth) {
                        width2 = (int) (width2 - (this.aMU / 4.0f));
                    }
                    scrollX = width2;
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.aMU - width) / 2.0f);
                    }
                    if (this.aMU <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.aMU) {
                        scrollX = (int) (this.aMU - getWidth());
                    }
                }
                if (scrollX > 0 && this.aMU - scrollX < getWidth()) {
                    scrollX = (int) (this.aMU - getWidth());
                }
                int i3 = this.mMode == 2 ? ((int) ((this.aMV - height) / 2.0f)) + scrollY : scrollY;
                if (this.aMV <= getHeight()) {
                    i3 = 0;
                } else if (getHeight() + i3 > this.aMV) {
                    i3 = (int) (this.aMV - getHeight());
                }
                setHorizontalScrollBarEnabled(false);
                setVerticalScrollBarEnabled(false);
                if (scrollX < 0) {
                    scrollX = 0;
                }
                scrollTo(scrollX, i3 >= 0 ? i3 : 0);
                setImageMatrix(this.mMatrix);
                Hx();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0065a extends Animation {
        private boolean aNH = false;
        private boolean aNI = false;
        private long aNJ;
        private long aNK;
        private int aNL;
        private long aNM;
        private long aNN;
        private int mStartY;

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
            this.aNJ = f;
            this.aNK = f2;
            this.aNM = Math.abs((f * 1000.0f) / 2500.0f);
            this.aNN = Math.abs((f2 * 1000.0f) / 2500.0f);
            setDuration(Math.max(this.aNM, this.aNN));
            setInterpolator(a.this.aNw);
            this.aNL = a.this.getScrollX();
            this.mStartY = a.this.getScrollY();
            this.aNH = true;
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
            if (this.aNM > this.aNN) {
                j = ((float) this.aNM) * f;
            } else {
                j = ((float) this.aNN) * f;
            }
            float f2 = ((float) (j > this.aNM ? this.aNM : j)) / 1000.0f;
            if (this.aNJ > 0) {
                i = this.aNL - ((int) (f2 * (((float) this.aNJ) - ((2500.0f * f2) / 2.0f))));
            } else {
                i = this.aNL - ((int) (f2 * (((float) this.aNJ) + ((2500.0f * f2) / 2.0f))));
            }
            if (j > this.aNN) {
                j = this.aNN;
            }
            float f3 = ((float) j) / 1000.0f;
            if (this.aNK > 0) {
                i2 = this.mStartY - ((int) (f3 * (((float) this.aNK) - ((2500.0f * f3) / 2.0f))));
            } else {
                i2 = this.mStartY - ((int) (f3 * (((float) this.aNK) + ((2500.0f * f3) / 2.0f))));
            }
            if (a.this.aMV + a.this.mTop + a.this.mBottom > a.this.getHeight()) {
                if (i2 < (-a.this.aNn)) {
                    i2 = -a.this.aNn;
                }
                if (a.this.getHeight() + i2 > a.this.aMV + a.this.mBottom + a.this.aNo) {
                    i2 = (int) ((a.this.aMV - a.this.getHeight()) + a.this.mBottom + a.this.aNo);
                }
            } else {
                i2 = 0;
            }
            if (a.this.aMU > a.this.getWidth()) {
                int width = ((float) (a.this.getWidth() + i)) > a.this.aMU ? (int) (a.this.aMU - a.this.getWidth()) : i;
                if (width >= 0) {
                    i3 = width;
                }
            }
            a.this.scrollTo(i3, i2);
            a.this.invalidate();
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            if (!this.aNI) {
                if (a.this.aNa) {
                    this.aNH = false;
                    return false;
                }
                try {
                    if (super.getTransformation(j, transformation)) {
                        return true;
                    }
                    this.aNH = false;
                    return false;
                } catch (Exception e) {
                    this.aNH = false;
                    return false;
                }
            }
            this.aNI = false;
            this.aNH = false;
            return false;
        }

        public boolean HL() {
            return this.aNH;
        }

        public void stopAnimation() {
            this.aNI = true;
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.aNf = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.auZ = onLongClickListener;
        if (this.aNu != null) {
            this.aNu.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setGifSetListener(e eVar) {
        this.avc = eVar;
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
    public void HI() {
        long j;
        c poll = this.aNA.poll();
        if (poll == null) {
            this.aNF = true;
            return;
        }
        this.aNF = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.aNz != null) {
            j = this.aNz.delay - (currentTimeMillis - this.aNE);
            this.aNB.offer(this.aNz);
        } else {
            j = 0;
        }
        this.aNz = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public c HJ() {
        c poll = this.aNB.poll();
        if (poll == null) {
            poll = new c();
            try {
                poll.aNO = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
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
        return this.aNz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends Thread {
        private b() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (a.this.mState == 1 && a.this.aNl != null && a.this.aNy > 0 && a.this.width > 0 && a.this.height > 0) {
                try {
                    a.this.aNl.T(a.this.aNC);
                    c HJ = a.this.HJ();
                    if (HJ.aNO == null || (HJ.aNO.getWidth() != a.this.width && HJ.aNO.getHeight() != a.this.height)) {
                        try {
                            HJ.aNO = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_8888);
                        } catch (OutOfMemoryError e) {
                            TbadkCoreApplication.getInst().onAppMemoryLow();
                            try {
                                HJ.aNO = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_4444);
                            } catch (OutOfMemoryError e2) {
                                TbadkCoreApplication.getInst().onAppMemoryLow();
                            }
                        } catch (Throwable th) {
                            BdLog.e(th.getMessage());
                        }
                    }
                    a.this.aNl.a(HJ.aNO, null);
                    HJ.delay = a.this.aNl.U(a.this.aNC);
                    a.B(a.this);
                    if (HJ.aNO == null) {
                        a.B(a.this);
                    }
                    a.this.aNC %= a.this.aNy;
                    a.this.aNA.put(HJ);
                    if (a.this.aNF) {
                        a.this.mHandler.sendEmptyMessage(1);
                    }
                } catch (Exception e3) {
                    return;
                }
            }
        }
    }

    public boolean HK() {
        return this.aNr;
    }

    public void setLoadBigImage(boolean z) {
        this.aNr = z;
    }

    public int getBottomOffset() {
        return this.aNo;
    }

    public int getLeftOffset() {
        return this.aNp;
    }
}
