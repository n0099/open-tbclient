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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class DragImageView extends ImageView {
    private static final String TAG = DragImageView.class.getSimpleName();
    private static final int aHZ = l.aj(TbadkCoreApplication.getInst()) / 5;
    private View.OnLongClickListener aGs;
    private e aGv;
    private int aGw;
    private boolean aHR;
    private float aHS;
    private Matrix aHT;
    private Rect aHU;
    private RectF aHV;
    private d aHY;
    private float aVU;
    private float aVV;
    private ArrayList<Float> aVW;
    private float aVX;
    private float aVY;
    private float aVZ;
    private BlockingLinkedDeque<c> aWA;
    private BlockingLinkedDeque<c> aWB;
    private volatile int aWC;
    private b aWD;
    private volatile long aWE;
    private volatile boolean aWF;
    private boolean aWa;
    private byte[] aWb;
    private int aWc;
    private int aWd;
    private f aWe;
    private View.OnClickListener aWf;
    private a aWg;
    private float aWh;
    private boolean aWi;
    private boolean aWj;
    private int aWk;
    private volatile com.baidu.adp.gif.b aWl;
    private Bitmap aWm;
    private int aWn;
    private int aWo;
    private int aWp;
    private int aWq;
    private boolean aWr;
    private boolean aWs;
    private float aWt;
    private com.baidu.tbadk.widget.largeImage.logic.b aWu;
    private ImageUrlData aWv;
    private Interpolator aWw;
    private Rect aWx;
    private int aWy;
    private c aWz;
    public int arN;
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
        public Bitmap aWN;
        public int delay;
    }

    /* loaded from: classes.dex */
    public interface d {
        void LJ();

        void LK();
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
        int i = dragImageView.aWC;
        dragImageView.aWC = i + 1;
        return i;
    }

    public void setIsHeadImage(boolean z) {
        this.aWs = z;
    }

    public void setImageUrlData(ImageUrlData imageUrlData) {
        this.aWv = imageUrlData;
    }

    public DragImageView(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aWa = false;
        this.aWb = null;
        this.aGw = 0;
        this.aWc = 1300;
        this.aWd = 0;
        this.aWe = null;
        this.aWf = null;
        this.aGs = null;
        this.aGv = null;
        this.aWh = 1.0f;
        this.arN = 0;
        this.mMode = 0;
        this.aWi = false;
        this.aWj = false;
        this.aWk = 0;
        this.aWl = null;
        this.aWm = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aWn = 0;
        this.aWo = 0;
        this.aWp = 0;
        this.aWq = 0;
        this.aWw = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.aHT = new Matrix();
        this.aHR = false;
        this.mRatio = 1.0f;
        this.aHS = 0.0f;
        this.aHV = new RectF();
        this.width = 0;
        this.height = 0;
        this.aWy = 0;
        this.aWz = null;
        this.aWA = new BlockingLinkedDeque<>(5);
        this.aWB = new BlockingLinkedDeque<>(6);
        this.aWC = 0;
        this.aWE = 0L;
        this.aWF = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.DragImageView.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        DragImageView.this.LF();
                        break;
                    case 1:
                        if (DragImageView.this.aWF) {
                            DragImageView.this.LF();
                            break;
                        }
                        break;
                    case 2:
                        DragImageView.this.invalidate();
                        DragImageView.this.aWE = System.currentTimeMillis();
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
        this.aWa = false;
        this.aWb = null;
        this.aGw = 0;
        this.aWc = 1300;
        this.aWd = 0;
        this.aWe = null;
        this.aWf = null;
        this.aGs = null;
        this.aGv = null;
        this.aWh = 1.0f;
        this.arN = 0;
        this.mMode = 0;
        this.aWi = false;
        this.aWj = false;
        this.aWk = 0;
        this.aWl = null;
        this.aWm = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aWn = 0;
        this.aWo = 0;
        this.aWp = 0;
        this.aWq = 0;
        this.aWw = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.aHT = new Matrix();
        this.aHR = false;
        this.mRatio = 1.0f;
        this.aHS = 0.0f;
        this.aHV = new RectF();
        this.width = 0;
        this.height = 0;
        this.aWy = 0;
        this.aWz = null;
        this.aWA = new BlockingLinkedDeque<>(5);
        this.aWB = new BlockingLinkedDeque<>(6);
        this.aWC = 0;
        this.aWE = 0L;
        this.aWF = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.DragImageView.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        DragImageView.this.LF();
                        break;
                    case 1:
                        if (DragImageView.this.aWF) {
                            DragImageView.this.LF();
                            break;
                        }
                        break;
                    case 2:
                        DragImageView.this.invalidate();
                        DragImageView.this.aWE = System.currentTimeMillis();
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
        this.aWa = false;
        this.aWb = null;
        this.aGw = 0;
        this.aWc = 1300;
        this.aWd = 0;
        this.aWe = null;
        this.aWf = null;
        this.aGs = null;
        this.aGv = null;
        this.aWh = 1.0f;
        this.arN = 0;
        this.mMode = 0;
        this.aWi = false;
        this.aWj = false;
        this.aWk = 0;
        this.aWl = null;
        this.aWm = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aWn = 0;
        this.aWo = 0;
        this.aWp = 0;
        this.aWq = 0;
        this.aWw = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.aHT = new Matrix();
        this.aHR = false;
        this.mRatio = 1.0f;
        this.aHS = 0.0f;
        this.aHV = new RectF();
        this.width = 0;
        this.height = 0;
        this.aWy = 0;
        this.aWz = null;
        this.aWA = new BlockingLinkedDeque<>(5);
        this.aWB = new BlockingLinkedDeque<>(6);
        this.aWC = 0;
        this.aWE = 0L;
        this.aWF = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.DragImageView.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        DragImageView.this.LF();
                        break;
                    case 1:
                        if (DragImageView.this.aWF) {
                            DragImageView.this.LF();
                            break;
                        }
                        break;
                    case 2:
                        DragImageView.this.invalidate();
                        DragImageView.this.aWE = System.currentTimeMillis();
                        DragImageView.this.mHandler.sendEmptyMessage(0);
                        break;
                }
                return false;
            }
        });
        initData();
    }

    public void setDragToExitListener(d dVar) {
        this.aHY = dVar;
    }

    public int getImageType() {
        return this.arN;
    }

    public void setImageMode(int i) {
        this.aWd = i;
    }

    public void setOffset(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.aGw = i;
    }

    public boolean Lr() {
        if (this.aWu != null) {
            return this.aWu.Lr();
        }
        return false;
    }

    public void Ls() {
        this.aWj = false;
        this.aWa = false;
        this.mMode = 3;
        Ly();
        if (this.mCurrentScale < this.aVX) {
            this.mCurrentScale = this.aVX;
            LE();
        }
        invalidate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.aWu != null && this.aWu.onTouchEvent(motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.aWa = true;
                this.aWi = false;
                this.aWj = false;
                break;
            case 1:
                Ls();
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
            this.aWh = s(motionEvent);
            if (this.aWh > 10.0f) {
                this.mMode = 2;
            }
        }
        if (this.mMode == 2 || !this.mGestureDetector.onTouchEvent(motionEvent)) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.aWi = true;
                        this.aWj = true;
                        if (this.arN != 1 && this.arN != 2) {
                            float s = s(motionEvent);
                            if (s >= 0.0f && Math.abs(this.aWh - s) >= 10.0f) {
                                if (Math.abs(this.aWh - s) > 100.0f) {
                                    this.aWh = s;
                                    break;
                                } else {
                                    float f2 = s / this.aWh;
                                    this.aWh = s;
                                    this.aVZ = this.mCurrentScale;
                                    this.mCurrentScale *= f2;
                                    if (this.mCurrentScale > this.aVY) {
                                        this.mCurrentScale = this.aVY;
                                    }
                                    float minScaleValue = getMinScaleValue();
                                    if (this.mCurrentScale < minScaleValue) {
                                        this.mCurrentScale = minScaleValue;
                                    }
                                    LE();
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
        return this.aWu != null ? this.aWu.getMinScaleValue() : this.aVX / 4.0f;
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
            Lu();
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public boolean Lt() {
        if (this.aWu != null) {
            return this.aWu.Mu();
        }
        return this.aVX == this.mCurrentScale;
    }

    protected float g(Bitmap bitmap) {
        if (this.aWu != null) {
            return this.aWu.My();
        }
        if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            return 1.0f;
        }
        if (this.aWd == 0) {
            float width = this.mViewWidth / bitmap.getWidth();
            float height = this.mViewHeight / bitmap.getHeight();
            if (this.aWs) {
                if (this.arN == 2) {
                    return 2.5f;
                }
                return Math.min(width, height);
            } else if (this.arN != 2) {
                float f2 = this.aWt;
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
        if (this.aWu != null) {
            return this.aWu.Mz();
        }
        float f2 = 1.0f;
        if (bitmap != null && !bitmap.isRecycled() && bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
            f2 = (float) Math.sqrt(this.aWc / (bitmap.getWidth() * bitmap.getHeight()));
            if (f2 > 10.0f) {
                return 10.0f;
            }
        }
        return f2;
    }

    private void Lu() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            this.aVX = g(imageBitmap);
            this.aVY = h(imageBitmap);
            this.aVW.clear();
            this.aVW.add(Float.valueOf(this.aVX));
            this.mCurrentScale = this.aVX;
            this.aVZ = this.mCurrentScale;
            LE();
            return;
        }
        this.aVU = 0.0f;
        this.aVV = 0.0f;
        this.aVX = 1.0f;
        this.aVY = 1.0f;
        this.mCurrentScale = 1.0f;
        this.aVZ = this.mCurrentScale;
        this.aVW.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    private void Lv() {
        if (this.aWe != null) {
            this.aWe.a(this, canZoomIn(), canZoomOut());
        }
    }

    public void setOnSizeChangedListener(f fVar) {
        this.aWe = fVar;
    }

    public byte[] getImageData() {
        return this.aWb;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getMeasuredHeight() != 0 && getMeasuredWidth() != 0 && this.aWu != null) {
            this.aWu.Mw();
        }
    }

    public void setImageData(Bitmap bitmap, byte[] bArr) {
        this.aWb = bArr;
        if (this.aWu != null) {
            this.aWu.a(bitmap, bArr);
        }
        setImageBitmap(bitmap);
    }

    public void Lw() {
        if (this.aWu == null) {
            this.aWu = new com.baidu.tbadk.widget.largeImage.logic.b(this);
            this.aWu.setOnClickListener(this.aWf);
            this.aWu.setOnLongClickListener(this.aGs);
        }
    }

    public void setImageLoadCallBack(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
        if (this.aWu != null) {
            this.aWu.a(aVar);
        }
    }

    public boolean Lx() {
        return (getImageBitmap() == null || this.aWu == null) ? false : true;
    }

    public Bitmap getGifCache() {
        return this.aWm;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        boolean z;
        if (this.aWu == null || !this.aWu.b(canvas, getImageBitmap())) {
            if (this.arN == 2 && this.aWq != 0 && !this.aWg.LI()) {
                int width = getWidth();
                int height = getHeight();
                Drawable drawable = getDrawable();
                float f2 = 0.0f;
                float f3 = height * 0.3f;
                float f4 = width;
                float f5 = (1.0f - 0.3f) * height;
                if (this.aWs && drawable != null) {
                    Rect bounds = drawable.getBounds();
                    int i = bounds.right - bounds.left;
                    int i2 = bounds.bottom - bounds.top;
                    f2 = (width / 2) - (i * 2.5f);
                    f3 = (height / 2) - (i2 * 2.5f);
                    f4 = (i * 2.5f) + (width / 2);
                    f5 = (i2 * 2.5f) + (height / 2);
                }
                this.mPaint.setColor(al.getColor(this.aWq));
                canvas.drawRect(f2, f3, f4, f5, this.mPaint);
                this.mPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
            }
            if (this.mMode == 3 && this.aHR) {
                this.aHR = false;
                this.aHT.reset();
                if (this.aHS < aHZ) {
                    this.mMode = 0;
                } else {
                    this.mMode = 4;
                    FG();
                }
            }
            if (this.arN == 0 && this.aHR && this.aHU != null && this.aWv != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                if (this.aHV == null) {
                    this.aHV = new RectF();
                }
                this.aHT.mapRect(this.aHV, new RectF(this.aHU));
                Bitmap imageBitmap = getImageBitmap();
                if (imageBitmap != null && !imageBitmap.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.aWx, this.aHV, (Paint) null);
                }
            } else if (this.mMode == 4 && this.aHU != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                Bitmap imageBitmap2 = getImageBitmap();
                if (imageBitmap2 != null && !imageBitmap2.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.aWx, this.aHV, (Paint) null);
                }
            } else {
                super.onDraw(canvas);
            }
            if (this.arN == 1 && this.aWm != null && !this.aWm.isRecycled()) {
                int width2 = this.aWm.getWidth();
                int height2 = this.aWm.getHeight();
                int width3 = getWidth();
                int height3 = getHeight();
                int i3 = (width3 - width2) >> 1;
                int i4 = (height3 - height2) >> 1;
                float f6 = this.aWt;
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
                if (this.aWk == 1 && this.aWl != null && this.aWz != null && this.aWz.aWN != null) {
                    if (z) {
                        canvas.drawBitmap(this.aWz.aWN, i3, i4, (Paint) null);
                    } else {
                        canvas.drawBitmap(this.aWz.aWN, this.mMatrix, this.mPaint);
                    }
                    invalidate();
                } else if (z) {
                    canvas.drawBitmap(this.aWm, i3, i4, (Paint) null);
                } else {
                    canvas.drawBitmap(this.aWm, this.mMatrix, this.mPaint);
                }
            }
        }
    }

    public void play() {
        com.baidu.adp.widget.ImageView.a aVar;
        if (this.arN == 1) {
            if (this.aWl == null) {
                if (this.aWD != null) {
                    this.aWD.Bo = false;
                    this.aWD.interrupt();
                    this.aWD = null;
                }
                if (this.aWb != null) {
                    try {
                        aVar = a.C0012a.ga().g(this.aWb, 0, this.aWb.length);
                    } catch (StackOverflowError e2) {
                        aVar = null;
                    }
                    if (aVar == null || aVar.getGif() == null) {
                        com.baidu.tbadk.core.d.a.a("gifplay", -1L, -1, "DragImageView.play", -1, "decode error", new Object[0]);
                        return;
                    }
                    this.aWl = aVar.getGif();
                    if (this.aWl != null) {
                        this.aWk = 1;
                        this.width = this.aWl.getWidth();
                        this.height = this.aWl.getHeight();
                        this.aWC = 0;
                        this.aWy = this.aWl.getFrameCount();
                    } else {
                        this.aWk = 0;
                    }
                } else {
                    return;
                }
            }
            if (this.aWl != null) {
                if (this.aWD == null || (this.aWD != null && !this.aWD.Bo)) {
                    this.aWF = true;
                    this.aWD = new b();
                    this.aWA.clear();
                    this.aWB.clear();
                    this.aWD.Bo = true;
                    this.aWD.start();
                }
            }
        }
    }

    public void pause() {
        if (this.arN == 1) {
            if (this.aWD != null) {
                this.aWD.Bo = false;
                this.aWD.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.arN == 1) {
            if (this.aWD != null) {
                this.aWD.Bo = false;
                this.aWD.interrupt();
                this.aWD = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.aWF = true;
            this.aWz = null;
            this.aWB.clear();
            this.aWA.clear();
            this.width = 0;
            this.height = 0;
            this.aWC = 0;
            this.aWy = 0;
            this.aWl = null;
        }
    }

    private void initData() {
        this.aWt = l.ak(getContext());
        this.aWc = l.aj(getContext()) * l.ah(getContext()) * 2;
        if (this.aWc < 1690000) {
            this.aWc = 1690000;
        }
        this.aVU = 0.0f;
        this.aVV = 0.0f;
        this.aVW = new ArrayList<>();
        this.aVX = 1.0f;
        this.aVY = 1.0f;
        this.mCurrentScale = 1.0f;
        this.aVZ = this.mCurrentScale;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.aWg = new a();
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWillNotDraw(false);
        scrollTo(0, 0);
        this.mGestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.DragImageView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                if (DragImageView.this.arN != 2 && (Math.abs(f2) > 200.0f || Math.abs(f3) > 200.0f)) {
                    DragImageView.this.aWg.m(f2, f3);
                    DragImageView.this.startAnimation(DragImageView.this.aWg);
                }
                return super.onFling(motionEvent, motionEvent2, f2, f3);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (DragImageView.this.arN != 1 && DragImageView.this.arN != 2) {
                    DragImageView.this.mMode = 2;
                    if (DragImageView.this.mCurrentScale > DragImageView.this.aVX) {
                        DragImageView.this.mCurrentScale = DragImageView.this.aVX;
                        DragImageView.this.aVZ = DragImageView.this.mCurrentScale;
                        DragImageView.this.LE();
                        return true;
                    }
                    DragImageView.this.mCurrentScale = DragImageView.this.aVX * 2.0f;
                    DragImageView.this.a(true, (int) motionEvent.getX(), (int) motionEvent.getY());
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (DragImageView.this.aWf != null && !DragImageView.this.aWi) {
                    DragImageView.this.aWf.onClick(DragImageView.this);
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
                DragImageView.this.aWi = true;
                if (DragImageView.this.aWd == 0 && DragImageView.this.aWj) {
                    return false;
                }
                int scrollX = DragImageView.this.getScrollX();
                int scrollY = DragImageView.this.getScrollY();
                if (DragImageView.this.aVU >= DragImageView.this.getWidth()) {
                    scrollX = (int) (scrollX + f2);
                    if (DragImageView.this.aWd == 0) {
                        i = scrollX >= 0 ? scrollX : 0;
                        if (DragImageView.this.getWidth() + i > DragImageView.this.aVU) {
                            i = (int) (DragImageView.this.aVU - DragImageView.this.getWidth());
                        }
                        if (DragImageView.this.aVV + DragImageView.this.mTop + DragImageView.this.mBottom < DragImageView.this.getHeight()) {
                            i2 = (int) (scrollY + f3);
                            if (DragImageView.this.aWd == 0) {
                                if (i2 < (-DragImageView.this.aWn)) {
                                    i2 = -DragImageView.this.aWn;
                                }
                                if (DragImageView.this.getHeight() + i2 > DragImageView.this.aVV + DragImageView.this.mBottom + DragImageView.this.aWo) {
                                    i2 = (int) ((DragImageView.this.aVV - DragImageView.this.getHeight()) + DragImageView.this.mBottom + DragImageView.this.aWo);
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
                if (DragImageView.this.aVV + DragImageView.this.mTop + DragImageView.this.mBottom < DragImageView.this.getHeight()) {
                }
                if (i == DragImageView.this.getScrollX()) {
                }
                DragImageView.this.scrollTo(i, i2);
                DragImageView.this.invalidate();
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (DragImageView.this.aGs != null && !DragImageView.this.aWi) {
                    DragImageView.this.aGs.onLongClick(DragImageView.this);
                }
                super.onLongPress(motionEvent);
            }
        });
    }

    private void FG() {
        if (this.aWv == null) {
            if (this.aHY != null) {
                this.aHY.LK();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.aWv.getSourceImageRectInScreen();
        if (sourceImageRectInScreen == null) {
            if (this.aHY != null) {
                this.aHY.LK();
                return;
            }
            return;
        }
        this.aHV.bottom = (((sourceImageRectInScreen.bottom - sourceImageRectInScreen.top) / (sourceImageRectInScreen.right - sourceImageRectInScreen.left)) * (this.aHV.right - this.aHV.left)) + this.aHV.top;
        final float[] fArr = {(this.aHV.left + this.aHV.right) / 2.0f, (this.aHV.top + this.aHV.bottom) / 2.0f};
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
                    DragImageView.this.aHV = DragImageView.this.g(floatValue, animatedFraction, sourceImageRectInScreen.right - sourceImageRectInScreen.left, sourceImageRectInScreen.bottom - sourceImageRectInScreen.top);
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
                DragImageView.this.aHR = false;
                DragImageView.this.mMode = 4;
                DragImageView.this.invalidate();
                if (DragImageView.this.aHY != null) {
                    DragImageView.this.aHY.LK();
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

    private void Ly() {
        int i = 0;
        int scrollX = getScrollX();
        if (this.aVU >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.aVU) {
                scrollX = (int) (this.aVU - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.aVV + this.mTop + this.mBottom >= getHeight()) {
            i = scrollY < (-this.aWn) ? -this.aWn : scrollY;
            if (getHeight() + i > this.aVV + this.mBottom + this.aWo) {
                i = (int) ((this.aVV - getHeight()) + this.mBottom + this.aWo);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.aWu != null) {
            this.aWu.Mv();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.aVU;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.aVV;
    }

    public boolean Lz() {
        if (this.arN == 1 || this.arN == 2) {
            return true;
        }
        return !this.aWj && getScrollX() >= ((int) (this.aVU - ((float) getWidth()))) + (-1);
    }

    public boolean LA() {
        if (this.arN == 1 || this.arN == 2) {
            return true;
        }
        return !this.aWj && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.aWg.LI()) {
            this.aWg.stopAnimation();
        }
        this.aWq = 0;
        super.setImageBitmap(bitmap);
        Lu();
        this.arN = 0;
        if (this.aHU == null) {
            int measuredWidth = getMeasuredWidth();
            float measuredWidth2 = ((1.0f * getMeasuredWidth()) / bitmap.getWidth()) * bitmap.getHeight();
            if (measuredWidth2 > getMeasuredHeight()) {
                measuredWidth2 = getMeasuredHeight();
            }
            RectF g = g(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
            this.aHU = new Rect((int) g.left, (int) g.top, (int) g.right, (int) g.bottom);
        }
        if (this.aWx == null) {
            this.aWx = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
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
            if (this.aWg.LI()) {
                this.aWg.stopAnimation();
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            super.setImageBitmap(bitmap);
            super.setImageMatrix(this.mMatrix);
            scrollTo(scrollX, scrollY);
            this.arN = 0;
        }
    }

    public void setGifData(byte[] bArr, Bitmap bitmap) {
        if (this.aWg.LI()) {
            this.aWg.stopAnimation();
        }
        super.setImageDrawable(null);
        stop();
        Lu();
        this.arN = 1;
        this.aWm = bitmap;
        this.aWb = bArr;
        if (this.aGv != null) {
            this.aGv.a(this);
        }
    }

    public void onDestroy() {
        if (this.aWg.LI()) {
            this.aWg.stopAnimation();
        }
        super.setImageDrawable(null);
        this.aWb = null;
        this.aWm = null;
        stop();
        if (this.aWl != null) {
            this.aWl.close();
            this.aWl = null;
        }
        if (this.aWu != null) {
            this.aWu.release();
            System.gc();
        }
    }

    public void release() {
        if (this.aWg.LI()) {
            this.aWg.stopAnimation();
        }
        stop();
        super.setImageDrawable(null);
        this.aWm = null;
    }

    public void setDefaultBitmap() {
        if (this.aWg.LI()) {
            this.aWg.stopAnimation();
        }
        try {
            if (this.aWs) {
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
        this.arN = 2;
        Lu();
    }

    public void LB() {
        if (this.arN != 1 && this.arN != 2) {
            int size = this.aVW.size();
            if (size > 0) {
                this.aVW.add(Float.valueOf(this.aVW.get(size - 1).floatValue() * 1.25f));
            } else {
                this.aVW.add(Float.valueOf(this.aVX));
            }
            LE();
        }
    }

    public void LC() {
        if (this.arN != 1 && this.arN != 2) {
            int size = this.aVW.size();
            if (size > 1) {
                this.aVW.remove(size - 1);
            }
            LE();
        }
    }

    public void LD() {
        Lv();
        if (this.arN != 1 && this.arN != 2 && this.mCurrentScale != this.aVX) {
            this.aVW.clear();
            this.aVW.add(Float.valueOf(this.aVX));
            this.mCurrentScale = this.aVX;
            this.aVZ = this.mCurrentScale;
            LE();
        }
    }

    public boolean canZoomIn() {
        if (this.arN == 1 || this.arN == 2) {
            return false;
        }
        int size = this.aVW.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.aVW.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.aWc) && floatValue <= 5.0f;
    }

    public boolean canZoomOut() {
        if (this.arN == 1 || this.arN == 2) {
            return false;
        }
        int size = this.aVW.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled()) {
            return false;
        }
        return size > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LE() {
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
                    int size = this.aVW.size();
                    if (size > 0) {
                        f3 = this.aVW.get(size - 1).floatValue();
                    } else {
                        f3 = this.aVX;
                    }
                    this.mCurrentScale = f3;
                }
                this.mMatrix.setScale(this.mCurrentScale, this.mCurrentScale);
                this.aVU = imageBitmap.getWidth() * this.mCurrentScale;
                this.aVV = imageBitmap.getHeight() * this.mCurrentScale;
                float width = this.aVZ * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.aVZ;
                this.aWn = this.mTop;
                this.aWo = 0;
                float f4 = this.aVU < ((float) this.mViewWidth) ? (int) ((this.mViewWidth - this.aVU) / 2.0f) : 0.0f;
                if (this.aVV < this.mViewHeight) {
                    f2 = (int) ((this.mViewHeight - this.aVV) / 2.0f);
                    if (this.aWd == 1 && f2 > this.mTop) {
                        f2 = this.mTop;
                    }
                    this.aWn = (int) (this.mTop - f2);
                    this.aWo = this.mTop - this.aWn;
                } else {
                    f2 = 0.0f;
                }
                this.aWp = (int) f4;
                this.mMatrix.postTranslate(f4, f2);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    int width2 = i > getWidth() ? getWidth() : i;
                    if (this.aVU <= screenWidth) {
                        width2 = 0;
                    } else if (this.aVU > screenWidth && this.aVU / 2.0f < screenWidth) {
                        width2 = (int) (width2 - (this.aVU / 4.0f));
                    }
                    scrollX = width2;
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.aVU - width) / 2.0f);
                    }
                    if (this.aVU <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.aVU) {
                        scrollX = (int) (this.aVU - getWidth());
                    }
                }
                if (scrollX > 0 && this.aVU - scrollX < getWidth()) {
                    scrollX = (int) (this.aVU - getWidth());
                }
                int i3 = this.mMode == 2 ? ((int) ((this.aVV - height) / 2.0f)) + scrollY : scrollY;
                if (this.aVV <= getHeight()) {
                    i3 = 0;
                } else if (getHeight() + i3 > this.aVV) {
                    i3 = (int) (this.aVV - getHeight());
                }
                setHorizontalScrollBarEnabled(false);
                setVerticalScrollBarEnabled(false);
                if (scrollX < 0) {
                    scrollX = 0;
                }
                scrollTo(scrollX, i3 >= 0 ? i3 : 0);
                setImageMatrix(this.mMatrix);
                Lv();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Animation {
        private boolean aWH = false;
        private boolean aWI = false;
        private long aWJ;
        private long aWK;
        private long aWL;
        private long aWM;
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
            this.aWJ = f;
            this.aWK = f2;
            this.aWL = Math.abs((f * 1000.0f) / 2500.0f);
            this.aWM = Math.abs((f2 * 1000.0f) / 2500.0f);
            setDuration(Math.max(this.aWL, this.aWM));
            setInterpolator(DragImageView.this.aWw);
            this.mStartX = DragImageView.this.getScrollX();
            this.mStartY = DragImageView.this.getScrollY();
            this.aWH = true;
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
            if (this.aWL > this.aWM) {
                j = ((float) this.aWL) * f;
            } else {
                j = ((float) this.aWM) * f;
            }
            float f2 = ((float) (j > this.aWL ? this.aWL : j)) / 1000.0f;
            if (this.aWJ > 0) {
                i = this.mStartX - ((int) (f2 * (((float) this.aWJ) - ((2500.0f * f2) / 2.0f))));
            } else {
                i = this.mStartX - ((int) (f2 * (((float) this.aWJ) + ((2500.0f * f2) / 2.0f))));
            }
            if (j > this.aWM) {
                j = this.aWM;
            }
            float f3 = ((float) j) / 1000.0f;
            if (this.aWK > 0) {
                i2 = this.mStartY - ((int) (f3 * (((float) this.aWK) - ((2500.0f * f3) / 2.0f))));
            } else {
                i2 = this.mStartY - ((int) (f3 * (((float) this.aWK) + ((2500.0f * f3) / 2.0f))));
            }
            if (DragImageView.this.aVV + DragImageView.this.mTop + DragImageView.this.mBottom > DragImageView.this.getHeight()) {
                if (i2 < (-DragImageView.this.aWn)) {
                    i2 = -DragImageView.this.aWn;
                }
                if (DragImageView.this.getHeight() + i2 > DragImageView.this.aVV + DragImageView.this.mBottom + DragImageView.this.aWo) {
                    i2 = (int) ((DragImageView.this.aVV - DragImageView.this.getHeight()) + DragImageView.this.mBottom + DragImageView.this.aWo);
                }
            } else {
                i2 = 0;
            }
            if (DragImageView.this.aVU > DragImageView.this.getWidth()) {
                int width = ((float) (DragImageView.this.getWidth() + i)) > DragImageView.this.aVU ? (int) (DragImageView.this.aVU - DragImageView.this.getWidth()) : i;
                if (width >= 0) {
                    i3 = width;
                }
            }
            DragImageView.this.scrollTo(i3, i2);
            DragImageView.this.invalidate();
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            if (!this.aWI) {
                if (DragImageView.this.aWa) {
                    this.aWH = false;
                    return false;
                }
                try {
                    if (super.getTransformation(j, transformation)) {
                        return true;
                    }
                    this.aWH = false;
                    return false;
                } catch (Exception e) {
                    this.aWH = false;
                    return false;
                }
            }
            this.aWI = false;
            this.aWH = false;
            return false;
        }

        public boolean LI() {
            return this.aWH;
        }

        public void stopAnimation() {
            this.aWI = true;
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.aWf = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aGs = onLongClickListener;
        if (this.aWu != null) {
            this.aWu.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setGifSetListener(e eVar) {
        this.aGv = eVar;
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
    public void LF() {
        long j;
        c poll = this.aWA.poll();
        if (poll == null) {
            this.aWF = true;
            return;
        }
        this.aWF = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.aWz != null) {
            j = this.aWz.delay - (currentTimeMillis - this.aWE);
            this.aWB.offer(this.aWz);
        } else {
            j = 0;
        }
        this.aWz = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public c LG() {
        c poll = this.aWB.poll();
        if (poll == null) {
            poll = new c();
            try {
                poll.aWN = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
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
        return this.aWz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends Thread {
        private volatile boolean Bo;

        private b() {
            this.Bo = false;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (this.Bo && DragImageView.this.aWl != null && DragImageView.this.aWy > 0 && DragImageView.this.width > 0 && DragImageView.this.height > 0) {
                try {
                    DragImageView.this.aWl.N(DragImageView.this.aWC);
                    c LG = DragImageView.this.LG();
                    if (LG.aWN == null || (LG.aWN.getWidth() != DragImageView.this.width && LG.aWN.getHeight() != DragImageView.this.height)) {
                        try {
                            LG.aWN = Bitmap.createBitmap(DragImageView.this.width, DragImageView.this.height, Bitmap.Config.ARGB_8888);
                        } catch (OutOfMemoryError e) {
                            TbadkCoreApplication.getInst().onAppMemoryLow();
                            try {
                                LG.aWN = Bitmap.createBitmap(DragImageView.this.width, DragImageView.this.height, Bitmap.Config.ARGB_4444);
                            } catch (OutOfMemoryError e2) {
                                TbadkCoreApplication.getInst().onAppMemoryLow();
                            } catch (Throwable th) {
                                BdLog.e(th.getMessage());
                            }
                        } catch (Throwable th2) {
                            BdLog.e(th2.getMessage());
                        }
                    }
                    DragImageView.this.aWl.a(LG.aWN, null);
                    LG.delay = DragImageView.this.aWl.O(DragImageView.this.aWC);
                    DragImageView.A(DragImageView.this);
                    if (LG.aWN == null) {
                        DragImageView.A(DragImageView.this);
                    }
                    DragImageView.this.aWC %= DragImageView.this.aWy;
                    DragImageView.this.aWA.put(LG);
                    if (DragImageView.this.aWF) {
                        DragImageView.this.mHandler.sendEmptyMessage(1);
                    }
                } catch (Exception e3) {
                    return;
                }
            }
        }
    }

    public boolean LH() {
        return this.aWr;
    }

    public void setLoadBigImage(boolean z) {
        this.aWr = z;
    }

    public int getBottomOffset() {
        return this.aWo;
    }

    public int getLeftOffset() {
        return this.aWp;
    }
}
