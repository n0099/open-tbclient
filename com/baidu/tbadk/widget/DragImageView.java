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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class DragImageView extends ImageView {
    private static final String TAG = DragImageView.class.getSimpleName();
    private static final int aIW = l.aj(TbadkCoreApplication.getInst()) / 5;
    private View.OnLongClickListener aHk;
    private e aHn;
    private int aHo;
    private boolean aIO;
    private float aIP;
    private Matrix aIQ;
    private Rect aIR;
    private RectF aIS;
    private d aIV;
    private float aWP;
    private float aWQ;
    private ArrayList<Float> aWR;
    private float aWS;
    private float aWT;
    private float aWU;
    private boolean aWV;
    private byte[] aWW;
    private int aWX;
    private int aWY;
    private f aWZ;
    private volatile boolean aXA;
    private View.OnClickListener aXa;
    private a aXb;
    private float aXc;
    private boolean aXd;
    private boolean aXe;
    private int aXf;
    private volatile com.baidu.adp.gif.b aXg;
    private Bitmap aXh;
    private int aXi;
    private int aXj;
    private int aXk;
    private int aXl;
    private boolean aXm;
    private boolean aXn;
    private float aXo;
    private com.baidu.tbadk.widget.largeImage.logic.b aXp;
    private ImageUrlData aXq;
    private Interpolator aXr;
    private Rect aXs;
    private int aXt;
    private c aXu;
    private BlockingLinkedDeque<c> aXv;
    private BlockingLinkedDeque<c> aXw;
    private volatile int aXx;
    private b aXy;
    private volatile long aXz;
    public int asq;
    private int height;
    private int mBottom;
    private float mCurrentScale;
    private GestureDetector mGestureDetector;
    public Handler mHandler;
    private Matrix mMatrix;
    private int mMode;
    private Paint mPaint;
    private float mRatio;
    private int mTop;
    private int mViewHeight;
    private int mViewWidth;
    private int width;

    /* loaded from: classes.dex */
    public static class c {
        public Bitmap aXI;
        public int delay;
    }

    /* loaded from: classes.dex */
    public interface d {
        void Mb();

        void Mc();
    }

    /* loaded from: classes.dex */
    public interface e {
        void a(DragImageView dragImageView);
    }

    /* loaded from: classes.dex */
    public interface f {
        void a(DragImageView dragImageView, boolean z, boolean z2);
    }

    static /* synthetic */ int A(DragImageView dragImageView) {
        int i = dragImageView.aXx;
        dragImageView.aXx = i + 1;
        return i;
    }

    public void setIsHeadImage(boolean z) {
        this.aXn = z;
    }

    public void setImageUrlData(ImageUrlData imageUrlData) {
        this.aXq = imageUrlData;
    }

    public DragImageView(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aWV = false;
        this.aWW = null;
        this.aHo = 0;
        this.aWX = 1300;
        this.aWY = 0;
        this.aWZ = null;
        this.aXa = null;
        this.aHk = null;
        this.aHn = null;
        this.aXc = 1.0f;
        this.asq = 0;
        this.mMode = 0;
        this.aXd = false;
        this.aXe = false;
        this.aXf = 0;
        this.aXg = null;
        this.aXh = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aXi = 0;
        this.aXj = 0;
        this.aXk = 0;
        this.aXl = 0;
        this.aXr = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.aIQ = new Matrix();
        this.aIO = false;
        this.mRatio = 1.0f;
        this.aIP = 0.0f;
        this.aIS = new RectF();
        this.width = 0;
        this.height = 0;
        this.aXt = 0;
        this.aXu = null;
        this.aXv = new BlockingLinkedDeque<>(5);
        this.aXw = new BlockingLinkedDeque<>(6);
        this.aXx = 0;
        this.aXz = 0L;
        this.aXA = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.DragImageView.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        DragImageView.this.LX();
                        break;
                    case 1:
                        if (DragImageView.this.aXA) {
                            DragImageView.this.LX();
                            break;
                        }
                        break;
                    case 2:
                        DragImageView.this.invalidate();
                        DragImageView.this.aXz = System.currentTimeMillis();
                        DragImageView.this.mHandler.sendEmptyMessage(0);
                        break;
                }
                return false;
            }
        });
        initData();
    }

    public DragImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aWV = false;
        this.aWW = null;
        this.aHo = 0;
        this.aWX = 1300;
        this.aWY = 0;
        this.aWZ = null;
        this.aXa = null;
        this.aHk = null;
        this.aHn = null;
        this.aXc = 1.0f;
        this.asq = 0;
        this.mMode = 0;
        this.aXd = false;
        this.aXe = false;
        this.aXf = 0;
        this.aXg = null;
        this.aXh = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aXi = 0;
        this.aXj = 0;
        this.aXk = 0;
        this.aXl = 0;
        this.aXr = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.aIQ = new Matrix();
        this.aIO = false;
        this.mRatio = 1.0f;
        this.aIP = 0.0f;
        this.aIS = new RectF();
        this.width = 0;
        this.height = 0;
        this.aXt = 0;
        this.aXu = null;
        this.aXv = new BlockingLinkedDeque<>(5);
        this.aXw = new BlockingLinkedDeque<>(6);
        this.aXx = 0;
        this.aXz = 0L;
        this.aXA = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.DragImageView.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        DragImageView.this.LX();
                        break;
                    case 1:
                        if (DragImageView.this.aXA) {
                            DragImageView.this.LX();
                            break;
                        }
                        break;
                    case 2:
                        DragImageView.this.invalidate();
                        DragImageView.this.aXz = System.currentTimeMillis();
                        DragImageView.this.mHandler.sendEmptyMessage(0);
                        break;
                }
                return false;
            }
        });
        initData();
    }

    public DragImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aWV = false;
        this.aWW = null;
        this.aHo = 0;
        this.aWX = 1300;
        this.aWY = 0;
        this.aWZ = null;
        this.aXa = null;
        this.aHk = null;
        this.aHn = null;
        this.aXc = 1.0f;
        this.asq = 0;
        this.mMode = 0;
        this.aXd = false;
        this.aXe = false;
        this.aXf = 0;
        this.aXg = null;
        this.aXh = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aXi = 0;
        this.aXj = 0;
        this.aXk = 0;
        this.aXl = 0;
        this.aXr = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.aIQ = new Matrix();
        this.aIO = false;
        this.mRatio = 1.0f;
        this.aIP = 0.0f;
        this.aIS = new RectF();
        this.width = 0;
        this.height = 0;
        this.aXt = 0;
        this.aXu = null;
        this.aXv = new BlockingLinkedDeque<>(5);
        this.aXw = new BlockingLinkedDeque<>(6);
        this.aXx = 0;
        this.aXz = 0L;
        this.aXA = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.DragImageView.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        DragImageView.this.LX();
                        break;
                    case 1:
                        if (DragImageView.this.aXA) {
                            DragImageView.this.LX();
                            break;
                        }
                        break;
                    case 2:
                        DragImageView.this.invalidate();
                        DragImageView.this.aXz = System.currentTimeMillis();
                        DragImageView.this.mHandler.sendEmptyMessage(0);
                        break;
                }
                return false;
            }
        });
        initData();
    }

    public void setDragToExitListener(d dVar) {
        this.aIV = dVar;
    }

    public int getImageType() {
        return this.asq;
    }

    public void setImageMode(int i) {
        this.aWY = i;
    }

    public void setOffset(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.aHo = i;
    }

    public boolean LJ() {
        if (this.aXp != null) {
            return this.aXp.LJ();
        }
        return false;
    }

    public void LK() {
        this.aXe = false;
        this.aWV = false;
        this.mMode = 3;
        LQ();
        if (this.mCurrentScale < this.aWS) {
            this.mCurrentScale = this.aWS;
            LW();
        }
        invalidate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.aXp != null && this.aXp.onTouchEvent(motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.aWV = true;
                this.aXd = false;
                this.aXe = false;
                break;
            case 1:
                LK();
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
            this.aXc = s(motionEvent);
            if (this.aXc > 10.0f) {
                this.mMode = 2;
            }
        }
        if (this.mMode == 2 || !this.mGestureDetector.onTouchEvent(motionEvent)) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.aXd = true;
                        this.aXe = true;
                        if (this.asq != 1 && this.asq != 2) {
                            float s = s(motionEvent);
                            if (s >= 0.0f && Math.abs(this.aXc - s) >= 10.0f) {
                                if (Math.abs(this.aXc - s) > 100.0f) {
                                    this.aXc = s;
                                    break;
                                } else {
                                    float f2 = s / this.aXc;
                                    this.aXc = s;
                                    this.aWU = this.mCurrentScale;
                                    this.mCurrentScale *= f2;
                                    if (this.mCurrentScale > this.aWT) {
                                        this.mCurrentScale = this.aWT;
                                    }
                                    float minScaleValue = getMinScaleValue();
                                    if (this.mCurrentScale < minScaleValue) {
                                        this.mCurrentScale = minScaleValue;
                                    }
                                    LW();
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
        return this.aXp != null ? this.aXp.getMinScaleValue() : this.aWS / 4.0f;
    }

    public float s(MotionEvent motionEvent) {
        return CompatibleUtile.getInstance().getSpacing(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            this.mViewWidth = i3 - i;
            this.mViewHeight = i4 - i2;
            LM();
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public boolean LL() {
        if (this.aXp != null) {
            return this.aXp.MM();
        }
        return this.aWS == this.mCurrentScale;
    }

    protected float g(Bitmap bitmap) {
        if (this.aXp != null) {
            return this.aXp.MQ();
        }
        if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            return 1.0f;
        }
        if (this.aWY == 0) {
            float width = this.mViewWidth / bitmap.getWidth();
            float height = this.mViewHeight / bitmap.getHeight();
            if (this.aXn) {
                if (this.asq == 2) {
                    return 2.5f;
                }
                return Math.min(width, height);
            } else if (this.asq != 2) {
                float f2 = this.aXo;
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

    protected float h(Bitmap bitmap) {
        if (this.aXp != null) {
            return this.aXp.MR();
        }
        float f2 = 1.0f;
        if (bitmap != null && !bitmap.isRecycled() && bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
            f2 = (float) Math.sqrt(this.aWX / (bitmap.getWidth() * bitmap.getHeight()));
            if (f2 > 10.0f) {
                return 10.0f;
            }
        }
        return f2;
    }

    private void LM() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            this.aWS = g(imageBitmap);
            this.aWT = h(imageBitmap);
            this.aWR.clear();
            this.aWR.add(Float.valueOf(this.aWS));
            this.mCurrentScale = this.aWS;
            this.aWU = this.mCurrentScale;
            LW();
            return;
        }
        this.aWP = 0.0f;
        this.aWQ = 0.0f;
        this.aWS = 1.0f;
        this.aWT = 1.0f;
        this.mCurrentScale = 1.0f;
        this.aWU = this.mCurrentScale;
        this.aWR.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    private void LN() {
        if (this.aWZ != null) {
            this.aWZ.a(this, canZoomIn(), canZoomOut());
        }
    }

    public void setOnSizeChangedListener(f fVar) {
        this.aWZ = fVar;
    }

    public byte[] getImageData() {
        return this.aWW;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getMeasuredHeight() != 0 && getMeasuredWidth() != 0 && this.aXp != null) {
            this.aXp.MO();
        }
    }

    public void setImageData(Bitmap bitmap, byte[] bArr) {
        this.aWW = bArr;
        if (this.aXp != null) {
            this.aXp.a(bitmap, bArr);
        }
        setImageBitmap(bitmap);
    }

    public void LO() {
        if (this.aXp == null) {
            this.aXp = new com.baidu.tbadk.widget.largeImage.logic.b(this);
            this.aXp.setOnClickListener(this.aXa);
            this.aXp.setOnLongClickListener(this.aHk);
        }
    }

    public void setImageLoadCallBack(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
        if (this.aXp != null) {
            this.aXp.a(aVar);
        }
    }

    public boolean LP() {
        return (getImageBitmap() == null || this.aXp == null) ? false : true;
    }

    public Bitmap getGifCache() {
        return this.aXh;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        boolean z;
        if (this.aXp == null || !this.aXp.b(canvas, getImageBitmap())) {
            if (this.asq == 2 && this.aXl != 0 && !this.aXb.Ma()) {
                int width = getWidth();
                int height = getHeight();
                Drawable drawable = getDrawable();
                float f2 = 0.0f;
                float f3 = height * 0.3f;
                float f4 = width;
                float f5 = (1.0f - 0.3f) * height;
                if (this.aXn && drawable != null) {
                    Rect bounds = drawable.getBounds();
                    int i = bounds.right - bounds.left;
                    int i2 = bounds.bottom - bounds.top;
                    f2 = (width / 2) - (i * 2.5f);
                    f3 = (height / 2) - (i2 * 2.5f);
                    f4 = (i * 2.5f) + (width / 2);
                    f5 = (i2 * 2.5f) + (height / 2);
                }
                this.mPaint.setColor(am.getColor(this.aXl));
                canvas.drawRect(f2, f3, f4, f5, this.mPaint);
                this.mPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
            }
            if (this.mMode == 3 && this.aIO) {
                this.aIO = false;
                this.aIQ.reset();
                if (this.aIP < aIW) {
                    this.mMode = 0;
                } else {
                    this.mMode = 4;
                    FY();
                }
            }
            if (this.asq == 0 && this.aIO && this.aIR != null && this.aXq != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                if (this.aIS == null) {
                    this.aIS = new RectF();
                }
                this.aIQ.mapRect(this.aIS, new RectF(this.aIR));
                Bitmap imageBitmap = getImageBitmap();
                if (imageBitmap != null && !imageBitmap.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.aXs, this.aIS, (Paint) null);
                }
            } else if (this.mMode == 4 && this.aIR != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                Bitmap imageBitmap2 = getImageBitmap();
                if (imageBitmap2 != null && !imageBitmap2.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.aXs, this.aIS, (Paint) null);
                }
            } else {
                super.onDraw(canvas);
            }
            if (this.asq == 1 && this.aXh != null && !this.aXh.isRecycled()) {
                int width2 = this.aXh.getWidth();
                int height2 = this.aXh.getHeight();
                int width3 = getWidth();
                int height3 = getHeight();
                int i3 = (width3 - width2) >> 1;
                int i4 = (height3 - height2) >> 1;
                float f6 = this.aXo;
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
                if (this.aXf == 1 && this.aXg != null && this.aXu != null && this.aXu.aXI != null) {
                    if (z) {
                        canvas.drawBitmap(this.aXu.aXI, i3, i4, (Paint) null);
                    } else {
                        canvas.drawBitmap(this.aXu.aXI, this.mMatrix, this.mPaint);
                    }
                    invalidate();
                } else if (z) {
                    canvas.drawBitmap(this.aXh, i3, i4, (Paint) null);
                } else {
                    canvas.drawBitmap(this.aXh, this.mMatrix, this.mPaint);
                }
            }
        }
    }

    public void play() {
        com.baidu.adp.widget.ImageView.a aVar;
        if (this.asq == 1) {
            if (this.aXg == null) {
                if (this.aXy != null) {
                    this.aXy.Bq = false;
                    this.aXy.interrupt();
                    this.aXy = null;
                }
                if (this.aWW != null) {
                    try {
                        aVar = a.C0012a.ga().g(this.aWW, 0, this.aWW.length);
                    } catch (StackOverflowError e2) {
                        aVar = null;
                    }
                    if (aVar == null || aVar.getGif() == null) {
                        com.baidu.tbadk.core.d.a.a("gifplay", -1L, -1, "DragImageView.play", -1, "decode error", new Object[0]);
                        return;
                    }
                    this.aXg = aVar.getGif();
                    if (this.aXg != null) {
                        this.aXf = 1;
                        this.width = this.aXg.getWidth();
                        this.height = this.aXg.getHeight();
                        this.aXx = 0;
                        this.aXt = this.aXg.getFrameCount();
                    } else {
                        this.aXf = 0;
                    }
                } else {
                    return;
                }
            }
            if (this.aXg != null) {
                if (this.aXy == null || (this.aXy != null && !this.aXy.Bq)) {
                    this.aXA = true;
                    this.aXy = new b();
                    this.aXv.clear();
                    this.aXw.clear();
                    this.aXy.Bq = true;
                    this.aXy.start();
                }
            }
        }
    }

    public void pause() {
        if (this.asq == 1) {
            if (this.aXy != null) {
                this.aXy.Bq = false;
                this.aXy.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.asq == 1) {
            if (this.aXy != null) {
                this.aXy.Bq = false;
                this.aXy.interrupt();
                this.aXy = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.aXA = true;
            this.aXu = null;
            this.aXw.clear();
            this.aXv.clear();
            this.width = 0;
            this.height = 0;
            this.aXx = 0;
            this.aXt = 0;
            this.aXg = null;
        }
    }

    private void initData() {
        this.aXo = l.ak(getContext());
        this.aWX = l.aj(getContext()) * l.ah(getContext()) * 2;
        if (this.aWX < 1690000) {
            this.aWX = 1690000;
        }
        this.aWP = 0.0f;
        this.aWQ = 0.0f;
        this.aWR = new ArrayList<>();
        this.aWS = 1.0f;
        this.aWT = 1.0f;
        this.mCurrentScale = 1.0f;
        this.aWU = this.mCurrentScale;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.aXb = new a();
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWillNotDraw(false);
        scrollTo(0, 0);
        this.mGestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.DragImageView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                if (DragImageView.this.asq != 2 && (Math.abs(f2) > 200.0f || Math.abs(f3) > 200.0f)) {
                    DragImageView.this.aXb.m(f2, f3);
                    DragImageView.this.startAnimation(DragImageView.this.aXb);
                }
                return super.onFling(motionEvent, motionEvent2, f2, f3);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (DragImageView.this.asq != 1 && DragImageView.this.asq != 2) {
                    DragImageView.this.mMode = 2;
                    if (DragImageView.this.mCurrentScale > DragImageView.this.aWS) {
                        DragImageView.this.mCurrentScale = DragImageView.this.aWS;
                        DragImageView.this.aWU = DragImageView.this.mCurrentScale;
                        DragImageView.this.LW();
                        return true;
                    }
                    DragImageView.this.mCurrentScale = DragImageView.this.aWS * 2.0f;
                    DragImageView.this.a(true, (int) motionEvent.getX(), (int) motionEvent.getY());
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (DragImageView.this.aXa != null && !DragImageView.this.aXd) {
                    DragImageView.this.aXa.onClick(DragImageView.this);
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
                DragImageView.this.aXd = true;
                if (DragImageView.this.aWY == 0 && DragImageView.this.aXe) {
                    return false;
                }
                int scrollX = DragImageView.this.getScrollX();
                int scrollY = DragImageView.this.getScrollY();
                if (DragImageView.this.aWP >= DragImageView.this.getWidth()) {
                    scrollX = (int) (scrollX + f2);
                    if (DragImageView.this.aWY == 0) {
                        i = scrollX >= 0 ? scrollX : 0;
                        if (DragImageView.this.getWidth() + i > DragImageView.this.aWP) {
                            i = (int) (DragImageView.this.aWP - DragImageView.this.getWidth());
                        }
                        if (DragImageView.this.aWQ + DragImageView.this.mTop + DragImageView.this.mBottom < DragImageView.this.getHeight()) {
                            i2 = (int) (scrollY + f3);
                            if (DragImageView.this.aWY == 0) {
                                if (i2 < (-DragImageView.this.aXi)) {
                                    i2 = -DragImageView.this.aXi;
                                }
                                if (DragImageView.this.getHeight() + i2 > DragImageView.this.aWQ + DragImageView.this.mBottom + DragImageView.this.aXj) {
                                    i2 = (int) ((DragImageView.this.aWQ - DragImageView.this.getHeight()) + DragImageView.this.mBottom + DragImageView.this.aXj);
                                }
                            }
                        } else {
                            i2 = scrollY;
                        }
                        if (i == DragImageView.this.getScrollX() || i2 != DragImageView.this.getScrollY()) {
                            DragImageView.this.scrollTo(i, i2);
                            DragImageView.this.invalidate();
                        }
                        return true;
                    }
                }
                i = scrollX;
                if (DragImageView.this.aWQ + DragImageView.this.mTop + DragImageView.this.mBottom < DragImageView.this.getHeight()) {
                }
                if (i == DragImageView.this.getScrollX()) {
                }
                DragImageView.this.scrollTo(i, i2);
                DragImageView.this.invalidate();
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (DragImageView.this.aHk != null && !DragImageView.this.aXd) {
                    DragImageView.this.aHk.onLongClick(DragImageView.this);
                }
                super.onLongPress(motionEvent);
            }
        });
    }

    private void FY() {
        if (this.aXq == null) {
            if (this.aIV != null) {
                this.aIV.Mc();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.aXq.getSourceImageRectInScreen();
        if (sourceImageRectInScreen == null) {
            if (this.aIV != null) {
                this.aIV.Mc();
                return;
            }
            return;
        }
        this.aIS.bottom = (((sourceImageRectInScreen.bottom - sourceImageRectInScreen.top) / (sourceImageRectInScreen.right - sourceImageRectInScreen.left)) * (this.aIS.right - this.aIS.left)) + this.aIS.top;
        final float[] fArr = {(this.aIS.left + this.aIS.right) / 2.0f, (this.aIS.top + this.aIS.bottom) / 2.0f};
        final float[] fArr2 = {(sourceImageRectInScreen.left + sourceImageRectInScreen.right) / 2, (sourceImageRectInScreen.top + sourceImageRectInScreen.bottom) / 2};
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr[0], fArr2[0]);
        ofFloat.setDuration(150L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.widget.DragImageView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && sourceImageRectInScreen != null) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    float animatedFraction = fArr[1] + ((fArr2[1] - fArr[1]) * valueAnimator.getAnimatedFraction());
                    DragImageView.this.aIS = DragImageView.this.g(floatValue, animatedFraction, sourceImageRectInScreen.right - sourceImageRectInScreen.left, sourceImageRectInScreen.bottom - sourceImageRectInScreen.top);
                    DragImageView.this.invalidate();
                }
            }
        });
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tbadk.widget.DragImageView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                DragImageView.this.aIO = false;
                DragImageView.this.mMode = 4;
                DragImageView.this.invalidate();
                if (DragImageView.this.aIV != null) {
                    DragImageView.this.aIV.Mc();
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
    public RectF g(float f2, float f3, float f4, float f5) {
        return new RectF(f2 - (f4 / 2.0f), f3 - (f5 / 2.0f), (f4 / 2.0f) + f2, (f5 / 2.0f) + f3);
    }

    private void LQ() {
        int i = 0;
        int scrollX = getScrollX();
        if (this.aWP >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.aWP) {
                scrollX = (int) (this.aWP - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.aWQ + this.mTop + this.mBottom >= getHeight()) {
            i = scrollY < (-this.aXi) ? -this.aXi : scrollY;
            if (getHeight() + i > this.aWQ + this.mBottom + this.aXj) {
                i = (int) ((this.aWQ - getHeight()) + this.mBottom + this.aXj);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.aXp != null) {
            this.aXp.MN();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.aWP;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.aWQ;
    }

    public boolean LR() {
        if (this.asq == 1 || this.asq == 2) {
            return true;
        }
        return !this.aXe && getScrollX() >= ((int) (this.aWP - ((float) getWidth()))) + (-1);
    }

    public boolean LS() {
        if (this.asq == 1 || this.asq == 2) {
            return true;
        }
        return !this.aXe && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.aXb.Ma()) {
            this.aXb.stopAnimation();
        }
        this.aXl = 0;
        super.setImageBitmap(bitmap);
        LM();
        this.asq = 0;
        if (this.aIR == null) {
            int measuredWidth = getMeasuredWidth();
            float measuredWidth2 = ((1.0f * getMeasuredWidth()) / bitmap.getWidth()) * bitmap.getHeight();
            if (measuredWidth2 > getMeasuredHeight()) {
                measuredWidth2 = getMeasuredHeight();
            }
            RectF g = g(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
            this.aIR = new Rect((int) g.left, (int) g.top, (int) g.right, (int) g.bottom);
        }
        if (this.aXs == null) {
            this.aXs = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        }
    }

    public void i(Bitmap bitmap) {
        Bitmap imageBitmap = getImageBitmap();
        if (bitmap != null && !bitmap.isRecycled()) {
            if (imageBitmap != null && (imageBitmap.getWidth() != bitmap.getWidth() || imageBitmap.getHeight() != bitmap.getHeight())) {
                setImageBitmap(bitmap);
                super.setImageMatrix(this.mMatrix);
                return;
            }
            if (this.aXb.Ma()) {
                this.aXb.stopAnimation();
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            super.setImageBitmap(bitmap);
            super.setImageMatrix(this.mMatrix);
            scrollTo(scrollX, scrollY);
            this.asq = 0;
        }
    }

    public void setGifData(byte[] bArr, Bitmap bitmap) {
        if (this.aXb.Ma()) {
            this.aXb.stopAnimation();
        }
        super.setImageDrawable(null);
        stop();
        LM();
        this.asq = 1;
        this.aXh = bitmap;
        this.aWW = bArr;
        if (this.aHn != null) {
            this.aHn.a(this);
        }
    }

    public void onDestroy() {
        if (this.aXb.Ma()) {
            this.aXb.stopAnimation();
        }
        super.setImageDrawable(null);
        this.aWW = null;
        this.aXh = null;
        stop();
        if (this.aXg != null) {
            this.aXg.close();
            this.aXg = null;
        }
        if (this.aXp != null) {
            this.aXp.release();
            System.gc();
        }
    }

    public void release() {
        if (this.aXb.Ma()) {
            this.aXb.stopAnimation();
        }
        stop();
        super.setImageDrawable(null);
        this.aXh = null;
    }

    public void setDefaultBitmap() {
        if (this.aXb.Ma()) {
            this.aXb.stopAnimation();
        }
        try {
            if (this.aXn) {
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
        this.asq = 2;
        LM();
    }

    public void LT() {
        if (this.asq != 1 && this.asq != 2) {
            int size = this.aWR.size();
            if (size > 0) {
                this.aWR.add(Float.valueOf(this.aWR.get(size - 1).floatValue() * 1.25f));
            } else {
                this.aWR.add(Float.valueOf(this.aWS));
            }
            LW();
        }
    }

    public void LU() {
        if (this.asq != 1 && this.asq != 2) {
            int size = this.aWR.size();
            if (size > 1) {
                this.aWR.remove(size - 1);
            }
            LW();
        }
    }

    public void LV() {
        LN();
        if (this.asq != 1 && this.asq != 2 && this.mCurrentScale != this.aWS) {
            this.aWR.clear();
            this.aWR.add(Float.valueOf(this.aWS));
            this.mCurrentScale = this.aWS;
            this.aWU = this.mCurrentScale;
            LW();
        }
    }

    public boolean canZoomIn() {
        if (this.asq == 1 || this.asq == 2) {
            return false;
        }
        int size = this.aWR.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.aWR.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.aWX) && floatValue <= 5.0f;
    }

    public boolean canZoomOut() {
        if (this.asq == 1 || this.asq == 2) {
            return false;
        }
        int size = this.aWR.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled()) {
            return false;
        }
        return size > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LW() {
        a(false, -1, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, int i, int i2) {
        float f2;
        float f3;
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled()) {
            try {
                if (this.mMode != 2) {
                    int size = this.aWR.size();
                    if (size > 0) {
                        f3 = this.aWR.get(size - 1).floatValue();
                    } else {
                        f3 = this.aWS;
                    }
                    this.mCurrentScale = f3;
                }
                this.mMatrix.setScale(this.mCurrentScale, this.mCurrentScale);
                this.aWP = imageBitmap.getWidth() * this.mCurrentScale;
                this.aWQ = imageBitmap.getHeight() * this.mCurrentScale;
                float width = this.aWU * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.aWU;
                this.aXi = this.mTop;
                this.aXj = 0;
                float f4 = this.aWP < ((float) this.mViewWidth) ? (int) ((this.mViewWidth - this.aWP) / 2.0f) : 0.0f;
                if (this.aWQ < this.mViewHeight) {
                    f2 = (int) ((this.mViewHeight - this.aWQ) / 2.0f);
                    if (this.aWY == 1 && f2 > this.mTop) {
                        f2 = this.mTop;
                    }
                    this.aXi = (int) (this.mTop - f2);
                    this.aXj = this.mTop - this.aXi;
                } else {
                    f2 = 0.0f;
                }
                this.aXk = (int) f4;
                this.mMatrix.postTranslate(f4, f2);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    int width2 = i > getWidth() ? getWidth() : i;
                    if (this.aWP <= screenWidth) {
                        width2 = 0;
                    } else if (this.aWP > screenWidth && this.aWP / 2.0f < screenWidth) {
                        width2 = (int) (width2 - (this.aWP / 4.0f));
                    }
                    scrollX = width2;
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.aWP - width) / 2.0f);
                    }
                    if (this.aWP <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.aWP) {
                        scrollX = (int) (this.aWP - getWidth());
                    }
                }
                if (scrollX > 0 && this.aWP - scrollX < getWidth()) {
                    scrollX = (int) (this.aWP - getWidth());
                }
                int i3 = this.mMode == 2 ? ((int) ((this.aWQ - height) / 2.0f)) + scrollY : scrollY;
                if (this.aWQ <= getHeight()) {
                    i3 = 0;
                } else if (getHeight() + i3 > this.aWQ) {
                    i3 = (int) (this.aWQ - getHeight());
                }
                setHorizontalScrollBarEnabled(false);
                setVerticalScrollBarEnabled(false);
                if (scrollX < 0) {
                    scrollX = 0;
                }
                scrollTo(scrollX, i3 >= 0 ? i3 : 0);
                setImageMatrix(this.mMatrix);
                LN();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Animation {
        private boolean aXC = false;
        private boolean aXD = false;
        private long aXE;
        private long aXF;
        private long aXG;
        private long aXH;
        private int mStartX;
        private int mStartY;

        public a() {
        }

        public void m(float f, float f2) {
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
            this.aXE = f;
            this.aXF = f2;
            this.aXG = Math.abs((f * 1000.0f) / 2500.0f);
            this.aXH = Math.abs((f2 * 1000.0f) / 2500.0f);
            setDuration(Math.max(this.aXG, this.aXH));
            setInterpolator(DragImageView.this.aXr);
            this.mStartX = DragImageView.this.getScrollX();
            this.mStartY = DragImageView.this.getScrollY();
            this.aXC = true;
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
            if (this.aXG > this.aXH) {
                j = ((float) this.aXG) * f;
            } else {
                j = ((float) this.aXH) * f;
            }
            float f2 = ((float) (j > this.aXG ? this.aXG : j)) / 1000.0f;
            if (this.aXE > 0) {
                i = this.mStartX - ((int) (f2 * (((float) this.aXE) - ((2500.0f * f2) / 2.0f))));
            } else {
                i = this.mStartX - ((int) (f2 * (((float) this.aXE) + ((2500.0f * f2) / 2.0f))));
            }
            if (j > this.aXH) {
                j = this.aXH;
            }
            float f3 = ((float) j) / 1000.0f;
            if (this.aXF > 0) {
                i2 = this.mStartY - ((int) (f3 * (((float) this.aXF) - ((2500.0f * f3) / 2.0f))));
            } else {
                i2 = this.mStartY - ((int) (f3 * (((float) this.aXF) + ((2500.0f * f3) / 2.0f))));
            }
            if (DragImageView.this.aWQ + DragImageView.this.mTop + DragImageView.this.mBottom > DragImageView.this.getHeight()) {
                if (i2 < (-DragImageView.this.aXi)) {
                    i2 = -DragImageView.this.aXi;
                }
                if (DragImageView.this.getHeight() + i2 > DragImageView.this.aWQ + DragImageView.this.mBottom + DragImageView.this.aXj) {
                    i2 = (int) ((DragImageView.this.aWQ - DragImageView.this.getHeight()) + DragImageView.this.mBottom + DragImageView.this.aXj);
                }
            } else {
                i2 = 0;
            }
            if (DragImageView.this.aWP > DragImageView.this.getWidth()) {
                int width = ((float) (DragImageView.this.getWidth() + i)) > DragImageView.this.aWP ? (int) (DragImageView.this.aWP - DragImageView.this.getWidth()) : i;
                if (width >= 0) {
                    i3 = width;
                }
            }
            DragImageView.this.scrollTo(i3, i2);
            DragImageView.this.invalidate();
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            if (!this.aXD) {
                if (DragImageView.this.aWV) {
                    this.aXC = false;
                    return false;
                }
                try {
                    if (super.getTransformation(j, transformation)) {
                        return true;
                    }
                    this.aXC = false;
                    return false;
                } catch (Exception e) {
                    this.aXC = false;
                    return false;
                }
            }
            this.aXD = false;
            this.aXC = false;
            return false;
        }

        public boolean Ma() {
            return this.aXC;
        }

        public void stopAnimation() {
            this.aXD = true;
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.aXa = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aHk = onLongClickListener;
        if (this.aXp != null) {
            this.aXp.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setGifSetListener(e eVar) {
        this.aHn = eVar;
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
    public void LX() {
        long j;
        c poll = this.aXv.poll();
        if (poll == null) {
            this.aXA = true;
            return;
        }
        this.aXA = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.aXu != null) {
            j = this.aXu.delay - (currentTimeMillis - this.aXz);
            this.aXw.offer(this.aXu);
        } else {
            j = 0;
        }
        this.aXu = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public c LY() {
        c poll = this.aXw.poll();
        if (poll == null) {
            poll = new c();
            try {
                poll.aXI = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
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
        return this.aXu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends Thread {
        private volatile boolean Bq;

        private b() {
            this.Bq = false;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (this.Bq && DragImageView.this.aXg != null && DragImageView.this.aXt > 0 && DragImageView.this.width > 0 && DragImageView.this.height > 0) {
                try {
                    DragImageView.this.aXg.N(DragImageView.this.aXx);
                    c LY = DragImageView.this.LY();
                    if (LY.aXI == null || (LY.aXI.getWidth() != DragImageView.this.width && LY.aXI.getHeight() != DragImageView.this.height)) {
                        try {
                            LY.aXI = Bitmap.createBitmap(DragImageView.this.width, DragImageView.this.height, Bitmap.Config.ARGB_8888);
                        } catch (OutOfMemoryError e) {
                            TbadkCoreApplication.getInst().onAppMemoryLow();
                            try {
                                LY.aXI = Bitmap.createBitmap(DragImageView.this.width, DragImageView.this.height, Bitmap.Config.ARGB_4444);
                            } catch (OutOfMemoryError e2) {
                                TbadkCoreApplication.getInst().onAppMemoryLow();
                            } catch (Throwable th) {
                                BdLog.e(th.getMessage());
                            }
                        } catch (Throwable th2) {
                            BdLog.e(th2.getMessage());
                        }
                    }
                    DragImageView.this.aXg.a(LY.aXI, null);
                    LY.delay = DragImageView.this.aXg.O(DragImageView.this.aXx);
                    DragImageView.A(DragImageView.this);
                    if (LY.aXI == null) {
                        DragImageView.A(DragImageView.this);
                    }
                    DragImageView.this.aXx %= DragImageView.this.aXt;
                    DragImageView.this.aXv.put(LY);
                    if (DragImageView.this.aXA) {
                        DragImageView.this.mHandler.sendEmptyMessage(1);
                    }
                } catch (Exception e3) {
                    return;
                }
            }
        }
    }

    public boolean LZ() {
        return this.aXm;
    }

    public void setLoadBigImage(boolean z) {
        this.aXm = z;
    }

    public int getBottomOffset() {
        return this.aXj;
    }

    public int getLeftOffset() {
        return this.aXk;
    }
}
