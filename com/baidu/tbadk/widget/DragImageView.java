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
import com.baidu.tieba.f;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class DragImageView extends ImageView {
    private static final String TAG = DragImageView.class.getSimpleName();
    private static final int aIV = l.aj(TbadkCoreApplication.getInst()) / 5;
    private int MJ;
    private View.OnLongClickListener aHj;
    private e aHm;
    private int aHn;
    private boolean aIL;
    private float aIM;
    private Matrix aIN;
    private Rect aIO;
    private RectF aIP;
    private d aIU;
    private int aWR;
    private float aWS;
    private float aWT;
    private ArrayList<Float> aWU;
    private float aWV;
    private float aWW;
    private float aWX;
    private boolean aWY;
    private byte[] aWZ;
    private BlockingLinkedDeque<c> aXA;
    private volatile int aXB;
    private b aXC;
    private volatile long aXD;
    private volatile boolean aXE;
    private int aXa;
    private int aXb;
    private g aXc;
    private View.OnClickListener aXd;
    private a aXe;
    private f aXf;
    private float aXg;
    private boolean aXh;
    private boolean aXi;
    private int aXj;
    private volatile com.baidu.adp.gif.b aXk;
    private Bitmap aXl;
    private int aXm;
    private int aXn;
    private int aXo;
    private int aXp;
    private boolean aXq;
    private boolean aXr;
    private float aXs;
    private com.baidu.tbadk.widget.largeImage.logic.b aXt;
    private ImageUrlData aXu;
    private Interpolator aXv;
    private Rect aXw;
    private int aXx;
    private c aXy;
    private BlockingLinkedDeque<c> aXz;
    public int arU;
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
    private int width;

    /* loaded from: classes.dex */
    public static class c {
        public Bitmap aXO;
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
        void a(DragImageView dragImageView, int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface g {
        void a(DragImageView dragImageView, boolean z, boolean z2);
    }

    static /* synthetic */ int B(DragImageView dragImageView) {
        int i = dragImageView.aXB;
        dragImageView.aXB = i + 1;
        return i;
    }

    public void setIsHeadImage(boolean z) {
        this.aXr = z;
    }

    public void setImageUrlData(ImageUrlData imageUrlData) {
        this.aXu = imageUrlData;
    }

    public DragImageView(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.MJ = 0;
        this.aWR = 0;
        this.aWY = false;
        this.aWZ = null;
        this.aHn = 0;
        this.aXa = 1300;
        this.aXb = 0;
        this.aXc = null;
        this.aXd = null;
        this.aHj = null;
        this.aHm = null;
        this.aXg = 1.0f;
        this.arU = 0;
        this.mMode = 0;
        this.aXh = false;
        this.aXi = false;
        this.aXj = 0;
        this.aXk = null;
        this.aXl = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aXm = 0;
        this.aXn = 0;
        this.aXo = 0;
        this.aXp = 0;
        this.aXv = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.aIN = new Matrix();
        this.aIL = false;
        this.mRatio = 1.0f;
        this.aIM = 0.0f;
        this.aIP = new RectF();
        this.width = 0;
        this.height = 0;
        this.aXx = 0;
        this.aXy = null;
        this.aXz = new BlockingLinkedDeque<>(5);
        this.aXA = new BlockingLinkedDeque<>(6);
        this.aXB = 0;
        this.aXD = 0L;
        this.aXE = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.DragImageView.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        DragImageView.this.LX();
                        break;
                    case 1:
                        if (DragImageView.this.aXE) {
                            DragImageView.this.LX();
                            break;
                        }
                        break;
                    case 2:
                        DragImageView.this.invalidate();
                        DragImageView.this.aXD = System.currentTimeMillis();
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
        this.MJ = 0;
        this.aWR = 0;
        this.aWY = false;
        this.aWZ = null;
        this.aHn = 0;
        this.aXa = 1300;
        this.aXb = 0;
        this.aXc = null;
        this.aXd = null;
        this.aHj = null;
        this.aHm = null;
        this.aXg = 1.0f;
        this.arU = 0;
        this.mMode = 0;
        this.aXh = false;
        this.aXi = false;
        this.aXj = 0;
        this.aXk = null;
        this.aXl = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aXm = 0;
        this.aXn = 0;
        this.aXo = 0;
        this.aXp = 0;
        this.aXv = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.aIN = new Matrix();
        this.aIL = false;
        this.mRatio = 1.0f;
        this.aIM = 0.0f;
        this.aIP = new RectF();
        this.width = 0;
        this.height = 0;
        this.aXx = 0;
        this.aXy = null;
        this.aXz = new BlockingLinkedDeque<>(5);
        this.aXA = new BlockingLinkedDeque<>(6);
        this.aXB = 0;
        this.aXD = 0L;
        this.aXE = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.DragImageView.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        DragImageView.this.LX();
                        break;
                    case 1:
                        if (DragImageView.this.aXE) {
                            DragImageView.this.LX();
                            break;
                        }
                        break;
                    case 2:
                        DragImageView.this.invalidate();
                        DragImageView.this.aXD = System.currentTimeMillis();
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
        this.MJ = 0;
        this.aWR = 0;
        this.aWY = false;
        this.aWZ = null;
        this.aHn = 0;
        this.aXa = 1300;
        this.aXb = 0;
        this.aXc = null;
        this.aXd = null;
        this.aHj = null;
        this.aHm = null;
        this.aXg = 1.0f;
        this.arU = 0;
        this.mMode = 0;
        this.aXh = false;
        this.aXi = false;
        this.aXj = 0;
        this.aXk = null;
        this.aXl = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aXm = 0;
        this.aXn = 0;
        this.aXo = 0;
        this.aXp = 0;
        this.aXv = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.aIN = new Matrix();
        this.aIL = false;
        this.mRatio = 1.0f;
        this.aIM = 0.0f;
        this.aIP = new RectF();
        this.width = 0;
        this.height = 0;
        this.aXx = 0;
        this.aXy = null;
        this.aXz = new BlockingLinkedDeque<>(5);
        this.aXA = new BlockingLinkedDeque<>(6);
        this.aXB = 0;
        this.aXD = 0L;
        this.aXE = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.DragImageView.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        DragImageView.this.LX();
                        break;
                    case 1:
                        if (DragImageView.this.aXE) {
                            DragImageView.this.LX();
                            break;
                        }
                        break;
                    case 2:
                        DragImageView.this.invalidate();
                        DragImageView.this.aXD = System.currentTimeMillis();
                        DragImageView.this.mHandler.sendEmptyMessage(0);
                        break;
                }
                return false;
            }
        });
        initData();
    }

    public void setDragToExitListener(d dVar) {
        this.aIU = dVar;
    }

    public int getImageType() {
        return this.arU;
    }

    public void setImageMode(int i) {
        this.aXb = i;
    }

    public void setOffset(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.aHn = i;
    }

    public boolean LJ() {
        if (this.aXt != null) {
            return this.aXt.LJ();
        }
        return false;
    }

    public void LK() {
        this.aXi = false;
        this.aWY = false;
        this.mMode = 3;
        LQ();
        if (this.mCurrentScale < this.aWV) {
            this.mCurrentScale = this.aWV;
            LW();
        }
        invalidate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.aXt != null && this.aXt.onTouchEvent(motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.aWY = true;
                this.aXh = false;
                this.aXi = false;
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
            this.aXg = t(motionEvent);
            if (this.aXg > 10.0f) {
                this.mMode = 2;
            }
        }
        if (this.mMode == 2 || !this.mGestureDetector.onTouchEvent(motionEvent)) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.aXh = true;
                        this.aXi = true;
                        if (this.arU != 1 && this.arU != 2) {
                            float t = t(motionEvent);
                            if (t >= 0.0f && Math.abs(this.aXg - t) >= 10.0f) {
                                if (Math.abs(this.aXg - t) > 100.0f) {
                                    this.aXg = t;
                                    break;
                                } else {
                                    float f2 = t / this.aXg;
                                    this.aXg = t;
                                    this.aWX = this.mCurrentScale;
                                    this.mCurrentScale *= f2;
                                    if (this.mCurrentScale > this.aWW) {
                                        this.mCurrentScale = this.aWW;
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
        return this.aXt != null ? this.aXt.getMinScaleValue() : this.aWV / 4.0f;
    }

    public float t(MotionEvent motionEvent) {
        return CompatibleUtile.getInstance().getSpacing(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            this.MJ = i3 - i;
            this.aWR = i4 - i2;
            LM();
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public boolean LL() {
        if (this.aXt != null) {
            return this.aXt.MM();
        }
        return this.aWV == this.mCurrentScale;
    }

    protected float g(Bitmap bitmap) {
        if (this.aXt != null) {
            return this.aXt.MQ();
        }
        if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            return 1.0f;
        }
        if (this.aXb == 0) {
            float width = this.MJ / bitmap.getWidth();
            float height = this.aWR / bitmap.getHeight();
            if (this.aXr) {
                if (this.arU == 2) {
                    return 2.5f;
                }
                return Math.min(width, height);
            } else if (this.arU != 2) {
                float f2 = this.aXs;
                float f3 = f2 >= 1.0f ? f2 : 1.0f;
                if (bitmap.getWidth() * f3 >= this.MJ || bitmap.getHeight() * f3 >= this.aWR) {
                    return Math.min(width, height);
                }
                return f3;
            } else {
                return 1.0f;
            }
        }
        return Math.max(this.MJ / bitmap.getWidth(), ((this.aWR - this.mTop) - this.mBottom) / bitmap.getHeight());
    }

    protected float h(Bitmap bitmap) {
        if (this.aXt != null) {
            return this.aXt.MR();
        }
        float f2 = 1.0f;
        if (bitmap != null && !bitmap.isRecycled() && bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
            f2 = (float) Math.sqrt(this.aXa / (bitmap.getWidth() * bitmap.getHeight()));
            if (f2 > 10.0f) {
                return 10.0f;
            }
        }
        return f2;
    }

    private void LM() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            this.aWV = g(imageBitmap);
            this.aWW = h(imageBitmap);
            this.aWU.clear();
            this.aWU.add(Float.valueOf(this.aWV));
            this.mCurrentScale = this.aWV;
            this.aWX = this.mCurrentScale;
            LW();
            return;
        }
        this.aWS = 0.0f;
        this.aWT = 0.0f;
        this.aWV = 1.0f;
        this.aWW = 1.0f;
        this.mCurrentScale = 1.0f;
        this.aWX = this.mCurrentScale;
        this.aWU.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    private void LN() {
        if (this.aXc != null) {
            this.aXc.a(this, canZoomIn(), canZoomOut());
        }
    }

    public void setOnSizeChangedListener(g gVar) {
        this.aXc = gVar;
    }

    public void setOnImageScrollListener(f fVar) {
        this.aXf = fVar;
    }

    public byte[] getImageData() {
        return this.aWZ;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getMeasuredHeight() != 0 && getMeasuredWidth() != 0 && this.aXt != null) {
            this.aXt.MO();
        }
    }

    public void setImageData(Bitmap bitmap, byte[] bArr) {
        this.aWZ = bArr;
        if (this.aXt != null) {
            this.aXt.a(bitmap, bArr);
        }
        setImageBitmap(bitmap);
    }

    public void LO() {
        if (this.aXt == null) {
            this.aXt = new com.baidu.tbadk.widget.largeImage.logic.b(this);
            this.aXt.setOnClickListener(this.aXd);
            this.aXt.setOnLongClickListener(this.aHj);
        }
    }

    public void setImageLoadCallBack(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
        if (this.aXt != null) {
            this.aXt.a(aVar);
        }
    }

    public boolean LP() {
        return (getImageBitmap() == null || this.aXt == null) ? false : true;
    }

    public Bitmap getGifCache() {
        return this.aXl;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        boolean z;
        if (this.aXt == null || !this.aXt.b(canvas, getImageBitmap())) {
            if (this.arU == 2 && this.aXp != 0 && !this.aXe.Ma()) {
                int width = getWidth();
                int height = getHeight();
                Drawable drawable = getDrawable();
                float f2 = 0.0f;
                float f3 = height * 0.3f;
                float f4 = width;
                float f5 = (1.0f - 0.3f) * height;
                if (this.aXr && drawable != null) {
                    Rect bounds = drawable.getBounds();
                    int i = bounds.right - bounds.left;
                    int i2 = bounds.bottom - bounds.top;
                    f2 = (width / 2) - (i * 2.5f);
                    f3 = (height / 2) - (i2 * 2.5f);
                    f4 = (i * 2.5f) + (width / 2);
                    f5 = (i2 * 2.5f) + (height / 2);
                }
                this.mPaint.setColor(am.getColor(this.aXp));
                canvas.drawRect(f2, f3, f4, f5, this.mPaint);
                this.mPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
            }
            if (this.mMode == 3 && this.aIL) {
                this.aIL = false;
                this.aIN.reset();
                if (this.aIM < aIV) {
                    this.mMode = 0;
                } else {
                    this.mMode = 4;
                    FU();
                }
            }
            if (this.arU == 0 && this.aIL && this.aIO != null && this.aXu != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                if (this.aIP == null) {
                    this.aIP = new RectF();
                }
                this.aIN.mapRect(this.aIP, new RectF(this.aIO));
                Bitmap imageBitmap = getImageBitmap();
                if (imageBitmap != null && !imageBitmap.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.aXw, this.aIP, (Paint) null);
                }
            } else if (this.mMode == 4 && this.aIO != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                Bitmap imageBitmap2 = getImageBitmap();
                if (imageBitmap2 != null && !imageBitmap2.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.aXw, this.aIP, (Paint) null);
                }
            } else {
                super.onDraw(canvas);
            }
            if (this.arU == 1 && this.aXl != null && !this.aXl.isRecycled()) {
                int width2 = this.aXl.getWidth();
                int height2 = this.aXl.getHeight();
                int width3 = getWidth();
                int height3 = getHeight();
                int i3 = (width3 - width2) >> 1;
                int i4 = (height3 - height2) >> 1;
                float f6 = this.aXs;
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
                if (this.aXj == 1 && this.aXk != null && this.aXy != null && this.aXy.aXO != null) {
                    if (z) {
                        canvas.drawBitmap(this.aXy.aXO, i3, i4, (Paint) null);
                    } else {
                        canvas.drawBitmap(this.aXy.aXO, this.mMatrix, this.mPaint);
                    }
                    invalidate();
                } else if (z) {
                    canvas.drawBitmap(this.aXl, i3, i4, (Paint) null);
                } else {
                    canvas.drawBitmap(this.aXl, this.mMatrix, this.mPaint);
                }
            }
        }
    }

    public void play() {
        com.baidu.adp.widget.ImageView.a aVar;
        if (this.arU == 1) {
            if (this.aXk == null) {
                if (this.aXC != null) {
                    this.aXC.Bm = false;
                    this.aXC.interrupt();
                    this.aXC = null;
                }
                if (this.aWZ != null) {
                    try {
                        aVar = a.C0012a.fZ().g(this.aWZ, 0, this.aWZ.length);
                    } catch (StackOverflowError e2) {
                        aVar = null;
                    }
                    if (aVar == null || aVar.getGif() == null) {
                        com.baidu.tbadk.core.d.a.a("gifplay", -1L, -1, "DragImageView.play", -1, "decode error", new Object[0]);
                        return;
                    }
                    this.aXk = aVar.getGif();
                    if (this.aXk != null) {
                        this.aXj = 1;
                        this.width = this.aXk.getWidth();
                        this.height = this.aXk.getHeight();
                        this.aXB = 0;
                        this.aXx = this.aXk.getFrameCount();
                    } else {
                        this.aXj = 0;
                    }
                } else {
                    return;
                }
            }
            if (this.aXk != null) {
                if (this.aXC == null || (this.aXC != null && !this.aXC.Bm)) {
                    this.aXE = true;
                    this.aXC = new b();
                    this.aXz.clear();
                    this.aXA.clear();
                    this.aXC.Bm = true;
                    this.aXC.start();
                }
            }
        }
    }

    public void pause() {
        if (this.arU == 1) {
            if (this.aXC != null) {
                this.aXC.Bm = false;
                this.aXC.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.arU == 1) {
            if (this.aXC != null) {
                this.aXC.Bm = false;
                this.aXC.interrupt();
                this.aXC = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.aXE = true;
            this.aXy = null;
            this.aXA.clear();
            this.aXz.clear();
            this.width = 0;
            this.height = 0;
            this.aXB = 0;
            this.aXx = 0;
            this.aXk = null;
        }
    }

    private void initData() {
        this.aXs = l.ak(getContext());
        this.aXa = l.aj(getContext()) * l.ah(getContext()) * 2;
        if (this.aXa < 1690000) {
            this.aXa = 1690000;
        }
        this.aWS = 0.0f;
        this.aWT = 0.0f;
        this.aWU = new ArrayList<>();
        this.aWV = 1.0f;
        this.aWW = 1.0f;
        this.mCurrentScale = 1.0f;
        this.aWX = this.mCurrentScale;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.aXe = new a();
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWillNotDraw(false);
        scrollTo(0, 0);
        this.mGestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.DragImageView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                if (DragImageView.this.arU != 2 && (Math.abs(f2) > 200.0f || Math.abs(f3) > 200.0f)) {
                    DragImageView.this.aXe.m(f2, f3);
                    DragImageView.this.startAnimation(DragImageView.this.aXe);
                }
                return super.onFling(motionEvent, motionEvent2, f2, f3);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (DragImageView.this.arU != 1 && DragImageView.this.arU != 2) {
                    DragImageView.this.mMode = 2;
                    if (DragImageView.this.mCurrentScale > DragImageView.this.aWV) {
                        DragImageView.this.mCurrentScale = DragImageView.this.aWV;
                        DragImageView.this.aWX = DragImageView.this.mCurrentScale;
                        DragImageView.this.LW();
                        return true;
                    }
                    DragImageView.this.mCurrentScale = DragImageView.this.aWV * 2.0f;
                    DragImageView.this.a(true, (int) motionEvent.getX(), (int) motionEvent.getY());
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (DragImageView.this.aXd != null && !DragImageView.this.aXh) {
                    DragImageView.this.aXd.onClick(DragImageView.this);
                }
                return super.onSingleTapConfirmed(motionEvent);
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x0084  */
            /* JADX WARN: Removed duplicated region for block: B:31:0x0102  */
            /* JADX WARN: Removed duplicated region for block: B:33:0x0110  */
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                int i;
                int i2;
                DragImageView.this.aXh = true;
                if (DragImageView.this.aXb == 0 && DragImageView.this.aXi) {
                    return false;
                }
                int scrollX = DragImageView.this.getScrollX();
                int scrollY = DragImageView.this.getScrollY();
                if (DragImageView.this.aWS >= DragImageView.this.getWidth()) {
                    scrollX = (int) (scrollX + f2);
                    if (DragImageView.this.aXb == 0) {
                        i = scrollX >= 0 ? scrollX : 0;
                        if (DragImageView.this.getWidth() + i > DragImageView.this.aWS) {
                            i = (int) (DragImageView.this.aWS - DragImageView.this.getWidth());
                        }
                        if (DragImageView.this.aWT + DragImageView.this.mTop + DragImageView.this.mBottom < DragImageView.this.getHeight()) {
                            i2 = (int) (scrollY + f3);
                            if (DragImageView.this.aXb == 0) {
                                if (i2 < (-DragImageView.this.aXm)) {
                                    i2 = -DragImageView.this.aXm;
                                }
                                if (DragImageView.this.getHeight() + i2 > DragImageView.this.aWT + DragImageView.this.mBottom + DragImageView.this.aXn) {
                                    i2 = (int) ((DragImageView.this.aWT - DragImageView.this.getHeight()) + DragImageView.this.mBottom + DragImageView.this.aXn);
                                }
                            }
                        } else {
                            i2 = scrollY;
                        }
                        if (i == DragImageView.this.getScrollX() || i2 != DragImageView.this.getScrollY()) {
                            DragImageView.this.scrollTo(i, i2);
                            DragImageView.this.invalidate();
                            if (DragImageView.this.aXf != null) {
                                DragImageView.this.aXf.a(DragImageView.this, i, i2);
                            }
                        }
                        return true;
                    }
                }
                i = scrollX;
                if (DragImageView.this.aWT + DragImageView.this.mTop + DragImageView.this.mBottom < DragImageView.this.getHeight()) {
                }
                if (i == DragImageView.this.getScrollX()) {
                }
                DragImageView.this.scrollTo(i, i2);
                DragImageView.this.invalidate();
                if (DragImageView.this.aXf != null) {
                }
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (DragImageView.this.aHj != null && !DragImageView.this.aXh) {
                    DragImageView.this.aHj.onLongClick(DragImageView.this);
                }
                super.onLongPress(motionEvent);
            }
        });
    }

    private void FU() {
        if (this.aXu == null) {
            if (this.aIU != null) {
                this.aIU.Mc();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.aXu.getSourceImageRectInScreen();
        if (sourceImageRectInScreen == null) {
            if (this.aIU != null) {
                this.aIU.Mc();
                return;
            }
            return;
        }
        this.aIP.bottom = (((sourceImageRectInScreen.bottom - sourceImageRectInScreen.top) / (sourceImageRectInScreen.right - sourceImageRectInScreen.left)) * (this.aIP.right - this.aIP.left)) + this.aIP.top;
        final float[] fArr = {(this.aIP.left + this.aIP.right) / 2.0f, (this.aIP.top + this.aIP.bottom) / 2.0f};
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
                    DragImageView.this.aIP = DragImageView.this.g(floatValue, animatedFraction, sourceImageRectInScreen.right - sourceImageRectInScreen.left, sourceImageRectInScreen.bottom - sourceImageRectInScreen.top);
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
                DragImageView.this.aIL = false;
                DragImageView.this.mMode = 4;
                DragImageView.this.invalidate();
                if (DragImageView.this.aIU != null) {
                    DragImageView.this.aIU.Mc();
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
        if (this.aWS >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.aWS) {
                scrollX = (int) (this.aWS - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.aWT + this.mTop + this.mBottom >= getHeight()) {
            i = scrollY < (-this.aXm) ? -this.aXm : scrollY;
            if (getHeight() + i > this.aWT + this.mBottom + this.aXn) {
                i = (int) ((this.aWT - getHeight()) + this.mBottom + this.aXn);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
            if (this.aXf != null) {
                this.aXf.a(this, scrollX, i);
            }
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.aXt != null) {
            this.aXt.MN();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.aWS;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.aWT;
    }

    public boolean LR() {
        if (this.arU == 1 || this.arU == 2) {
            return true;
        }
        return !this.aXi && getScrollX() >= ((int) (this.aWS - ((float) getWidth()))) + (-1);
    }

    public boolean LS() {
        if (this.arU == 1 || this.arU == 2) {
            return true;
        }
        return !this.aXi && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.aXe.Ma()) {
            this.aXe.stopAnimation();
        }
        this.aXp = 0;
        super.setImageBitmap(bitmap);
        LM();
        this.arU = 0;
        if (this.aIO == null) {
            int measuredWidth = getMeasuredWidth();
            float measuredWidth2 = ((1.0f * getMeasuredWidth()) / bitmap.getWidth()) * bitmap.getHeight();
            if (measuredWidth2 > getMeasuredHeight()) {
                measuredWidth2 = getMeasuredHeight();
            }
            RectF g2 = g(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
            this.aIO = new Rect((int) g2.left, (int) g2.top, (int) g2.right, (int) g2.bottom);
        }
        if (this.aXw == null) {
            this.aXw = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
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
            if (this.aXe.Ma()) {
                this.aXe.stopAnimation();
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            super.setImageBitmap(bitmap);
            super.setImageMatrix(this.mMatrix);
            scrollTo(scrollX, scrollY);
            this.arU = 0;
        }
    }

    public void setGifData(byte[] bArr, Bitmap bitmap) {
        if (this.aXe.Ma()) {
            this.aXe.stopAnimation();
        }
        super.setImageDrawable(null);
        stop();
        LM();
        this.arU = 1;
        this.aXl = bitmap;
        this.aWZ = bArr;
        if (this.aHm != null) {
            this.aHm.a(this);
        }
    }

    public void onDestroy() {
        if (this.aXe.Ma()) {
            this.aXe.stopAnimation();
        }
        super.setImageDrawable(null);
        this.aWZ = null;
        this.aXl = null;
        stop();
        if (this.aXk != null) {
            this.aXk.close();
            this.aXk = null;
        }
        if (this.aXt != null) {
            this.aXt.release();
            System.gc();
        }
    }

    public void release() {
        if (this.aXe.Ma()) {
            this.aXe.stopAnimation();
        }
        stop();
        super.setImageDrawable(null);
        this.aXl = null;
    }

    public void setDefaultBitmap() {
        if (this.aXe.Ma()) {
            this.aXe.stopAnimation();
        }
        try {
            if (this.aXr) {
                super.setImageBitmap(BitmapHelper.getCashBitmap(f.C0146f.icon_default_avatar100));
            } else {
                super.setImageBitmap(BitmapHelper.getCashBitmap(f.C0146f.btn_see_default));
            }
        } catch (OutOfMemoryError e2) {
            TbadkCoreApplication.getInst().onAppMemoryLow();
            System.gc();
            super.setImageBitmap(null);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
        this.arU = 2;
        LM();
    }

    public void LT() {
        if (this.arU != 1 && this.arU != 2) {
            int size = this.aWU.size();
            if (size > 0) {
                this.aWU.add(Float.valueOf(this.aWU.get(size - 1).floatValue() * 1.25f));
            } else {
                this.aWU.add(Float.valueOf(this.aWV));
            }
            LW();
        }
    }

    public void LU() {
        if (this.arU != 1 && this.arU != 2) {
            int size = this.aWU.size();
            if (size > 1) {
                this.aWU.remove(size - 1);
            }
            LW();
        }
    }

    public void LV() {
        LN();
        if (this.arU != 1 && this.arU != 2 && this.mCurrentScale != this.aWV) {
            this.aWU.clear();
            this.aWU.add(Float.valueOf(this.aWV));
            this.mCurrentScale = this.aWV;
            this.aWX = this.mCurrentScale;
            LW();
        }
    }

    public boolean canZoomIn() {
        if (this.arU == 1 || this.arU == 2) {
            return false;
        }
        int size = this.aWU.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.aWU.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.aXa) && floatValue <= 5.0f;
    }

    public boolean canZoomOut() {
        if (this.arU == 1 || this.arU == 2) {
            return false;
        }
        int size = this.aWU.size();
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
                    int size = this.aWU.size();
                    if (size > 0) {
                        f3 = this.aWU.get(size - 1).floatValue();
                    } else {
                        f3 = this.aWV;
                    }
                    this.mCurrentScale = f3;
                }
                this.mMatrix.setScale(this.mCurrentScale, this.mCurrentScale);
                this.aWS = imageBitmap.getWidth() * this.mCurrentScale;
                this.aWT = imageBitmap.getHeight() * this.mCurrentScale;
                float width = this.aWX * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.aWX;
                this.aXm = this.mTop;
                this.aXn = 0;
                float f4 = this.aWS < ((float) this.MJ) ? (int) ((this.MJ - this.aWS) / 2.0f) : 0.0f;
                if (this.aWT < this.aWR) {
                    f2 = (int) ((this.aWR - this.aWT) / 2.0f);
                    if (this.aXb == 1 && f2 > this.mTop) {
                        f2 = this.mTop;
                    }
                    this.aXm = (int) (this.mTop - f2);
                    this.aXn = this.mTop - this.aXm;
                } else {
                    f2 = 0.0f;
                }
                this.aXo = (int) f4;
                this.mMatrix.postTranslate(f4, f2);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    int width2 = i > getWidth() ? getWidth() : i;
                    if (this.aWS <= screenWidth) {
                        width2 = 0;
                    } else if (this.aWS > screenWidth && this.aWS / 2.0f < screenWidth) {
                        width2 = (int) (width2 - (this.aWS / 4.0f));
                    }
                    scrollX = width2;
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.aWS - width) / 2.0f);
                    }
                    if (this.aWS <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.aWS) {
                        scrollX = (int) (this.aWS - getWidth());
                    }
                }
                if (scrollX > 0 && this.aWS - scrollX < getWidth()) {
                    scrollX = (int) (this.aWS - getWidth());
                }
                int i3 = this.mMode == 2 ? ((int) ((this.aWT - height) / 2.0f)) + scrollY : scrollY;
                if (this.aWT <= getHeight()) {
                    i3 = 0;
                } else if (getHeight() + i3 > this.aWT) {
                    i3 = (int) (this.aWT - getHeight());
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
        private boolean aXI = false;
        private boolean aXJ = false;
        private long aXK;
        private long aXL;
        private long aXM;
        private long aXN;
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
            this.aXK = f;
            this.aXL = f2;
            this.aXM = Math.abs((f * 1000.0f) / 2500.0f);
            this.aXN = Math.abs((f2 * 1000.0f) / 2500.0f);
            setDuration(Math.max(this.aXM, this.aXN));
            setInterpolator(DragImageView.this.aXv);
            this.mStartX = DragImageView.this.getScrollX();
            this.mStartY = DragImageView.this.getScrollY();
            this.aXI = true;
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
            if (this.aXM > this.aXN) {
                j = ((float) this.aXM) * f;
            } else {
                j = ((float) this.aXN) * f;
            }
            float f2 = ((float) (j > this.aXM ? this.aXM : j)) / 1000.0f;
            if (this.aXK > 0) {
                i = this.mStartX - ((int) (f2 * (((float) this.aXK) - ((2500.0f * f2) / 2.0f))));
            } else {
                i = this.mStartX - ((int) (f2 * (((float) this.aXK) + ((2500.0f * f2) / 2.0f))));
            }
            if (j > this.aXN) {
                j = this.aXN;
            }
            float f3 = ((float) j) / 1000.0f;
            if (this.aXL > 0) {
                i2 = this.mStartY - ((int) (f3 * (((float) this.aXL) - ((2500.0f * f3) / 2.0f))));
            } else {
                i2 = this.mStartY - ((int) (f3 * (((float) this.aXL) + ((2500.0f * f3) / 2.0f))));
            }
            if (DragImageView.this.aWT + DragImageView.this.mTop + DragImageView.this.mBottom > DragImageView.this.getHeight()) {
                if (i2 < (-DragImageView.this.aXm)) {
                    i2 = -DragImageView.this.aXm;
                }
                if (DragImageView.this.getHeight() + i2 > DragImageView.this.aWT + DragImageView.this.mBottom + DragImageView.this.aXn) {
                    i2 = (int) ((DragImageView.this.aWT - DragImageView.this.getHeight()) + DragImageView.this.mBottom + DragImageView.this.aXn);
                }
            } else {
                i2 = 0;
            }
            if (DragImageView.this.aWS > DragImageView.this.getWidth()) {
                int width = ((float) (DragImageView.this.getWidth() + i)) > DragImageView.this.aWS ? (int) (DragImageView.this.aWS - DragImageView.this.getWidth()) : i;
                if (width >= 0) {
                    i3 = width;
                }
            }
            DragImageView.this.scrollTo(i3, i2);
            DragImageView.this.invalidate();
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            if (!this.aXJ) {
                if (DragImageView.this.aWY) {
                    this.aXI = false;
                    return false;
                }
                try {
                    if (super.getTransformation(j, transformation)) {
                        return true;
                    }
                    this.aXI = false;
                    return false;
                } catch (Exception e) {
                    this.aXI = false;
                    return false;
                }
            }
            this.aXJ = false;
            this.aXI = false;
            return false;
        }

        public boolean Ma() {
            return this.aXI;
        }

        public void stopAnimation() {
            this.aXJ = true;
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.aXd = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aHj = onLongClickListener;
        if (this.aXt != null) {
            this.aXt.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setGifSetListener(e eVar) {
        this.aHm = eVar;
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
        c poll = this.aXz.poll();
        if (poll == null) {
            this.aXE = true;
            return;
        }
        this.aXE = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.aXy != null) {
            j = this.aXy.delay - (currentTimeMillis - this.aXD);
            this.aXA.offer(this.aXy);
        } else {
            j = 0;
        }
        this.aXy = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public c LY() {
        c poll = this.aXA.poll();
        if (poll == null) {
            poll = new c();
            try {
                poll.aXO = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
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
        return this.aXy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends Thread {
        private volatile boolean Bm;

        private b() {
            this.Bm = false;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (this.Bm && DragImageView.this.aXk != null && DragImageView.this.aXx > 0 && DragImageView.this.width > 0 && DragImageView.this.height > 0) {
                try {
                    DragImageView.this.aXk.N(DragImageView.this.aXB);
                    c LY = DragImageView.this.LY();
                    if (LY.aXO == null || (LY.aXO.getWidth() != DragImageView.this.width && LY.aXO.getHeight() != DragImageView.this.height)) {
                        try {
                            LY.aXO = Bitmap.createBitmap(DragImageView.this.width, DragImageView.this.height, Bitmap.Config.ARGB_8888);
                        } catch (OutOfMemoryError e) {
                            TbadkCoreApplication.getInst().onAppMemoryLow();
                            try {
                                LY.aXO = Bitmap.createBitmap(DragImageView.this.width, DragImageView.this.height, Bitmap.Config.ARGB_4444);
                            } catch (OutOfMemoryError e2) {
                                TbadkCoreApplication.getInst().onAppMemoryLow();
                            } catch (Throwable th) {
                                BdLog.e(th.getMessage());
                            }
                        } catch (Throwable th2) {
                            BdLog.e(th2.getMessage());
                        }
                    }
                    DragImageView.this.aXk.a(LY.aXO, null);
                    LY.delay = DragImageView.this.aXk.O(DragImageView.this.aXB);
                    DragImageView.B(DragImageView.this);
                    if (LY.aXO == null) {
                        DragImageView.B(DragImageView.this);
                    }
                    DragImageView.this.aXB %= DragImageView.this.aXx;
                    DragImageView.this.aXz.put(LY);
                    if (DragImageView.this.aXE) {
                        DragImageView.this.mHandler.sendEmptyMessage(1);
                    }
                } catch (Exception e3) {
                    return;
                }
            }
        }
    }

    public boolean LZ() {
        return this.aXq;
    }

    public void setLoadBigImage(boolean z) {
        this.aXq = z;
    }

    public int getBottomOffset() {
        return this.aXn;
    }

    public int getLeftOffset() {
        return this.aXo;
    }
}
