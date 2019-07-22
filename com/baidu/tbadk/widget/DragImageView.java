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
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class DragImageView extends ImageView {
    private static final String TAG = DragImageView.class.getSimpleName();
    private static final int coC = l.ah(TbadkCoreApplication.getInst()) / 5;
    private float cDB;
    private float cDC;
    private ArrayList<Float> cDD;
    private float cDE;
    private float cDF;
    private float cDG;
    private boolean cDH;
    private byte[] cDI;
    private int cDJ;
    private int cDK;
    private g cDL;
    private View.OnClickListener cDM;
    private a cDN;
    private f cDO;
    private float cDP;
    private boolean cDQ;
    private boolean cDR;
    private int cDS;
    private volatile com.baidu.adp.gif.b cDT;
    private Bitmap cDU;
    private int cDV;
    private int cDW;
    private int cDX;
    private int cDY;
    private boolean cDZ;
    private boolean cEa;
    private boolean cEb;
    private float cEc;
    private com.baidu.tbadk.widget.largeImage.logic.b cEd;
    private ImageUrlData cEe;
    private Interpolator cEf;
    private Rect cEg;
    private int cEh;
    private c cEi;
    private BlockingLinkedDeque<c> cEj;
    private BlockingLinkedDeque<c> cEk;
    private volatile int cEl;
    private b cEm;
    private volatile long cEn;
    private volatile boolean cEo;
    private e cmB;
    private int cmG;
    private View.OnLongClickListener cmy;
    private d coB;
    private boolean cos;
    private float cot;
    private Matrix cou;
    private Rect cov;
    private RectF cow;
    private int height;
    private int mBottom;
    private float mCurrentScale;
    private GestureDetector mGestureDetector;
    public Handler mHandler;
    public int mImageType;
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
        public Bitmap cEy;
        public int delay;
    }

    /* loaded from: classes.dex */
    public interface d {
        void axh();

        void axi();

        void axj();
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

    static /* synthetic */ int C(DragImageView dragImageView) {
        int i = dragImageView.cEl;
        dragImageView.cEl = i + 1;
        return i;
    }

    public void setIsHeadImage(boolean z) {
        this.cEb = z;
    }

    public void setImageUrlData(ImageUrlData imageUrlData) {
        this.cEe = imageUrlData;
    }

    public ImageUrlData getImageUrlData() {
        return this.cEe;
    }

    public void setCanScale(boolean z) {
        this.cEa = z;
    }

    public DragImageView(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.cDH = false;
        this.cDI = null;
        this.cmG = 0;
        this.cDJ = 1300;
        this.cDK = 0;
        this.cDL = null;
        this.cDM = null;
        this.cmy = null;
        this.cmB = null;
        this.cDP = 1.0f;
        this.mImageType = 0;
        this.mMode = 0;
        this.cDQ = false;
        this.cDR = false;
        this.cDS = 0;
        this.cDT = null;
        this.cDU = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.cDV = 0;
        this.cDW = 0;
        this.cDX = 0;
        this.cDY = 0;
        this.cEa = true;
        this.cEf = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.cou = new Matrix();
        this.cos = false;
        this.mRatio = 1.0f;
        this.cot = 0.0f;
        this.cow = new RectF();
        this.width = 0;
        this.height = 0;
        this.cEh = 0;
        this.cEi = null;
        this.cEj = new BlockingLinkedDeque<>(5);
        this.cEk = new BlockingLinkedDeque<>(6);
        this.cEl = 0;
        this.cEn = 0L;
        this.cEo = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.DragImageView.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        DragImageView.this.axd();
                        break;
                    case 1:
                        if (DragImageView.this.cEo) {
                            DragImageView.this.axd();
                            break;
                        }
                        break;
                    case 2:
                        DragImageView.this.invalidate();
                        DragImageView.this.cEn = System.currentTimeMillis();
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
        this.cDH = false;
        this.cDI = null;
        this.cmG = 0;
        this.cDJ = 1300;
        this.cDK = 0;
        this.cDL = null;
        this.cDM = null;
        this.cmy = null;
        this.cmB = null;
        this.cDP = 1.0f;
        this.mImageType = 0;
        this.mMode = 0;
        this.cDQ = false;
        this.cDR = false;
        this.cDS = 0;
        this.cDT = null;
        this.cDU = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.cDV = 0;
        this.cDW = 0;
        this.cDX = 0;
        this.cDY = 0;
        this.cEa = true;
        this.cEf = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.cou = new Matrix();
        this.cos = false;
        this.mRatio = 1.0f;
        this.cot = 0.0f;
        this.cow = new RectF();
        this.width = 0;
        this.height = 0;
        this.cEh = 0;
        this.cEi = null;
        this.cEj = new BlockingLinkedDeque<>(5);
        this.cEk = new BlockingLinkedDeque<>(6);
        this.cEl = 0;
        this.cEn = 0L;
        this.cEo = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.DragImageView.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        DragImageView.this.axd();
                        break;
                    case 1:
                        if (DragImageView.this.cEo) {
                            DragImageView.this.axd();
                            break;
                        }
                        break;
                    case 2:
                        DragImageView.this.invalidate();
                        DragImageView.this.cEn = System.currentTimeMillis();
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
        this.cDH = false;
        this.cDI = null;
        this.cmG = 0;
        this.cDJ = 1300;
        this.cDK = 0;
        this.cDL = null;
        this.cDM = null;
        this.cmy = null;
        this.cmB = null;
        this.cDP = 1.0f;
        this.mImageType = 0;
        this.mMode = 0;
        this.cDQ = false;
        this.cDR = false;
        this.cDS = 0;
        this.cDT = null;
        this.cDU = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.cDV = 0;
        this.cDW = 0;
        this.cDX = 0;
        this.cDY = 0;
        this.cEa = true;
        this.cEf = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.cou = new Matrix();
        this.cos = false;
        this.mRatio = 1.0f;
        this.cot = 0.0f;
        this.cow = new RectF();
        this.width = 0;
        this.height = 0;
        this.cEh = 0;
        this.cEi = null;
        this.cEj = new BlockingLinkedDeque<>(5);
        this.cEk = new BlockingLinkedDeque<>(6);
        this.cEl = 0;
        this.cEn = 0L;
        this.cEo = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.DragImageView.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        DragImageView.this.axd();
                        break;
                    case 1:
                        if (DragImageView.this.cEo) {
                            DragImageView.this.axd();
                            break;
                        }
                        break;
                    case 2:
                        DragImageView.this.invalidate();
                        DragImageView.this.cEn = System.currentTimeMillis();
                        DragImageView.this.mHandler.sendEmptyMessage(0);
                        break;
                }
                return false;
            }
        });
        initData();
    }

    public void setDragToExitListener(d dVar) {
        this.coB = dVar;
    }

    public int getImageType() {
        return this.mImageType;
    }

    public void setImageMode(int i) {
        this.cDK = i;
    }

    public void setOffset(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.cmG = i;
    }

    public boolean awN() {
        if (this.cEd != null) {
            return this.cEd.awN();
        }
        return false;
    }

    public void awO() {
        this.cDR = false;
        this.cDH = false;
        this.mMode = 3;
        awU();
        if (this.mCurrentScale < this.cDE) {
            this.mCurrentScale = this.cDE;
            axc();
        }
        invalidate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.cEd != null && this.cEd.onTouchEvent(motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.cDH = true;
                this.cDQ = false;
                this.cDR = false;
                break;
            case 1:
                awO();
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
            this.cDP = x(motionEvent);
            if (this.cDP > 10.0f) {
                this.mMode = 2;
            }
        }
        if ((this.mMode == 2 || !this.mGestureDetector.onTouchEvent(motionEvent)) && this.cEa) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.cDQ = true;
                        this.cDR = true;
                        if (this.mImageType != 1 && this.mImageType != 2) {
                            float x = x(motionEvent);
                            if (x >= 0.0f && Math.abs(this.cDP - x) >= 10.0f) {
                                if (Math.abs(this.cDP - x) > 100.0f) {
                                    this.cDP = x;
                                    break;
                                } else {
                                    float f2 = x / this.cDP;
                                    this.cDP = x;
                                    this.cDG = this.mCurrentScale;
                                    this.mCurrentScale *= f2;
                                    if (this.mCurrentScale > this.cDF) {
                                        this.mCurrentScale = this.cDF;
                                    }
                                    float minScaleValue = getMinScaleValue();
                                    if (this.mCurrentScale < minScaleValue) {
                                        this.mCurrentScale = minScaleValue;
                                    }
                                    axc();
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
        return this.cEd != null ? this.cEd.getMinScaleValue() : this.cDE / 4.0f;
    }

    public float x(MotionEvent motionEvent) {
        return CompatibleUtile.getInstance().getSpacing(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            this.mViewWidth = i3 - i;
            this.mViewHeight = i4 - i2;
            awQ();
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public boolean awP() {
        if (this.cEd != null) {
            return this.cEd.axY();
        }
        return this.cDE == this.mCurrentScale;
    }

    protected float o(Bitmap bitmap) {
        if (this.cEd != null) {
            return this.cEd.ayc();
        }
        if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            return 1.0f;
        }
        if (this.cDK == 0) {
            float width = this.mViewWidth / bitmap.getWidth();
            float height = this.mViewHeight / bitmap.getHeight();
            if (this.cEb) {
                if (this.mImageType == 2) {
                    return 2.5f;
                }
                return Math.min(width, height);
            } else if (this.mImageType != 2) {
                float f2 = this.cEc;
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

    protected float p(Bitmap bitmap) {
        if (this.cEd != null) {
            return this.cEd.ayd();
        }
        float f2 = 1.0f;
        if (bitmap != null && !bitmap.isRecycled() && bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
            f2 = (float) Math.sqrt(this.cDJ / (bitmap.getWidth() * bitmap.getHeight()));
            if (f2 > 10.0f) {
                return 10.0f;
            }
        }
        return f2;
    }

    private void awQ() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            this.cDE = o(imageBitmap);
            this.cDF = p(imageBitmap);
            this.cDD.clear();
            this.cDD.add(Float.valueOf(this.cDE));
            this.mCurrentScale = this.cDE;
            this.cDG = this.mCurrentScale;
            axc();
            return;
        }
        this.cDB = 0.0f;
        this.cDC = 0.0f;
        this.cDE = 1.0f;
        this.cDF = 1.0f;
        this.mCurrentScale = 1.0f;
        this.cDG = this.mCurrentScale;
        this.cDD.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    private void awR() {
        if (this.cDL != null) {
            this.cDL.a(this, axa(), axb());
        }
    }

    public void setOnSizeChangedListener(g gVar) {
        this.cDL = gVar;
    }

    public void setOnImageScrollListener(f fVar) {
        this.cDO = fVar;
    }

    public byte[] getImageData() {
        return this.cDI;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getMeasuredHeight() != 0 && getMeasuredWidth() != 0 && this.cEd != null) {
            this.cEd.aya();
        }
    }

    public void setImageData(Bitmap bitmap, byte[] bArr) {
        this.cDI = bArr;
        if (this.cEd != null) {
            this.cEd.a(bitmap, bArr);
        }
        setImageBitmap(bitmap);
    }

    public void awS() {
        if (this.cEd == null) {
            this.cEd = new com.baidu.tbadk.widget.largeImage.logic.b(this);
            this.cEd.setOnClickListener(this.cDM);
            this.cEd.setOnLongClickListener(this.cmy);
        }
    }

    public void setImageLoadCallBack(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
        if (this.cEd != null) {
            this.cEd.a(aVar);
        }
    }

    public boolean awT() {
        return (getImageBitmap() == null || this.cEd == null) ? false : true;
    }

    public Bitmap getGifCache() {
        return this.cDU;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        boolean z;
        if (this.cEd == null || !this.cEd.b(canvas, getImageBitmap())) {
            if (this.mImageType == 2 && this.cDY != 0 && !this.cDN.axg()) {
                int width = getWidth();
                int height = getHeight();
                Drawable drawable = getDrawable();
                float f2 = 0.0f;
                float f3 = height * 0.3f;
                float f4 = width;
                float f5 = (1.0f - 0.3f) * height;
                if (this.cEb && drawable != null) {
                    Rect bounds = drawable.getBounds();
                    int i = bounds.right - bounds.left;
                    int i2 = bounds.bottom - bounds.top;
                    f2 = (width / 2) - (i * 2.5f);
                    f3 = (height / 2) - (i2 * 2.5f);
                    f4 = (i * 2.5f) + (width / 2);
                    f5 = (i2 * 2.5f) + (height / 2);
                }
                this.mPaint.setColor(am.getColor(this.cDY));
                canvas.drawRect(f2, f3, f4, f5, this.mPaint);
                this.mPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
            }
            if (this.mMode == 3 && this.cos) {
                this.cos = false;
                this.cou.reset();
                if (this.cot < coC) {
                    this.mMode = 0;
                } else {
                    this.mMode = 4;
                    aqz();
                }
            }
            if (this.mImageType == 0 && this.cos && this.cov != null && this.cEe != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                if (this.cow == null) {
                    this.cow = new RectF();
                }
                this.cou.mapRect(this.cow, new RectF(this.cov));
                Bitmap imageBitmap = getImageBitmap();
                if (imageBitmap != null && !imageBitmap.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.cEg, this.cow, (Paint) null);
                }
            } else if (this.mMode == 4 && this.cov != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                Bitmap imageBitmap2 = getImageBitmap();
                if (imageBitmap2 != null && !imageBitmap2.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.cEg, this.cow, (Paint) null);
                }
            } else {
                super.onDraw(canvas);
            }
            if (this.mImageType == 1 && this.cDU != null && !this.cDU.isRecycled()) {
                int width2 = this.cDU.getWidth();
                int height2 = this.cDU.getHeight();
                int width3 = getWidth();
                int height3 = getHeight();
                int i3 = (width3 - width2) >> 1;
                int i4 = (height3 - height2) >> 1;
                float f6 = this.cEc;
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
                if (this.cDS == 1 && this.cDT != null && this.cEi != null && this.cEi.cEy != null) {
                    if (z) {
                        canvas.drawBitmap(this.cEi.cEy, i3, i4, (Paint) null);
                    } else {
                        canvas.drawBitmap(this.cEi.cEy, this.mMatrix, this.mPaint);
                    }
                    invalidate();
                } else if (z) {
                    canvas.drawBitmap(this.cDU, i3, i4, (Paint) null);
                } else {
                    canvas.drawBitmap(this.cDU, this.mMatrix, this.mPaint);
                }
            }
        }
    }

    public void play() {
        com.baidu.adp.widget.ImageView.a aVar;
        if (this.mImageType == 1) {
            if (this.cDT == null) {
                if (this.cEm != null) {
                    this.cEm.Cg = false;
                    this.cEm.interrupt();
                    this.cEm = null;
                }
                if (this.cDI != null) {
                    try {
                        aVar = a.C0013a.gy().g(this.cDI, 0, this.cDI.length);
                    } catch (StackOverflowError e2) {
                        aVar = null;
                    }
                    if (aVar == null || aVar.getGif() == null) {
                        com.baidu.tbadk.core.e.a.a("gifplay", -1L, -1, "DragImageView.play", -1, "decode error", new Object[0]);
                        return;
                    }
                    this.cDT = aVar.getGif();
                    if (this.cDT != null) {
                        this.cDS = 1;
                        this.width = this.cDT.getWidth();
                        this.height = this.cDT.getHeight();
                        this.cEl = 0;
                        this.cEh = this.cDT.getFrameCount();
                    } else {
                        this.cDS = 0;
                    }
                } else {
                    return;
                }
            }
            if (this.cDT != null) {
                if (this.cEm == null || (this.cEm != null && !this.cEm.Cg)) {
                    this.cEo = true;
                    this.cEm = new b();
                    this.cEj.clear();
                    this.cEk.clear();
                    this.cEm.Cg = true;
                    this.cEm.start();
                }
            }
        }
    }

    public void pause() {
        if (this.mImageType == 1) {
            if (this.cEm != null) {
                this.cEm.Cg = false;
                this.cEm.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.mImageType == 1) {
            if (this.cEm != null) {
                this.cEm.Cg = false;
                this.cEm.interrupt();
                this.cEm = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.cEo = true;
            this.cEi = null;
            this.cEk.clear();
            this.cEj.clear();
            this.width = 0;
            this.height = 0;
            this.cEl = 0;
            this.cEh = 0;
            this.cDT = null;
        }
    }

    private void initData() {
        this.cEc = l.ai(getContext());
        this.cDJ = l.ah(getContext()) * l.af(getContext()) * 2;
        if (this.cDJ < 1690000) {
            this.cDJ = 1690000;
        }
        this.cDB = 0.0f;
        this.cDC = 0.0f;
        this.cDD = new ArrayList<>();
        this.cDE = 1.0f;
        this.cDF = 1.0f;
        this.mCurrentScale = 1.0f;
        this.cDG = this.mCurrentScale;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.cDN = new a();
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWillNotDraw(false);
        scrollTo(0, 0);
        this.mGestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.DragImageView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                if (DragImageView.this.mImageType != 2 && (Math.abs(f2) > 200.0f || Math.abs(f3) > 200.0f)) {
                    DragImageView.this.cDN.s(f2, f3);
                    DragImageView.this.startAnimation(DragImageView.this.cDN);
                }
                return super.onFling(motionEvent, motionEvent2, f2, f3);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (DragImageView.this.mImageType == 1 || DragImageView.this.mImageType == 2 || !DragImageView.this.cEa) {
                    return false;
                }
                DragImageView.this.mMode = 2;
                if (DragImageView.this.mCurrentScale > DragImageView.this.cDE) {
                    DragImageView.this.mCurrentScale = DragImageView.this.cDE;
                    DragImageView.this.cDG = DragImageView.this.mCurrentScale;
                    DragImageView.this.axc();
                } else {
                    DragImageView.this.mCurrentScale = DragImageView.this.cDE * 2.0f;
                    DragImageView.this.a(true, (int) motionEvent.getX(), (int) motionEvent.getY());
                }
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (DragImageView.this.cDM != null && !DragImageView.this.cDQ) {
                    DragImageView.this.cDM.onClick(DragImageView.this);
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
                DragImageView.this.cDQ = true;
                if (DragImageView.this.cDK == 0 && DragImageView.this.cDR) {
                    return false;
                }
                int scrollX = DragImageView.this.getScrollX();
                int scrollY = DragImageView.this.getScrollY();
                if (DragImageView.this.cDB >= DragImageView.this.getWidth()) {
                    scrollX = (int) (scrollX + f2);
                    if (DragImageView.this.cDK == 0) {
                        i = scrollX >= 0 ? scrollX : 0;
                        if (DragImageView.this.getWidth() + i > DragImageView.this.cDB) {
                            i = (int) (DragImageView.this.cDB - DragImageView.this.getWidth());
                        }
                        if (DragImageView.this.cDC + DragImageView.this.mTop + DragImageView.this.mBottom < DragImageView.this.getHeight()) {
                            i2 = (int) (scrollY + f3);
                            if (DragImageView.this.cDK == 0) {
                                if (i2 < (-DragImageView.this.cDV)) {
                                    i2 = -DragImageView.this.cDV;
                                }
                                if (DragImageView.this.getHeight() + i2 > DragImageView.this.cDC + DragImageView.this.mBottom + DragImageView.this.cDW) {
                                    i2 = (int) ((DragImageView.this.cDC - DragImageView.this.getHeight()) + DragImageView.this.mBottom + DragImageView.this.cDW);
                                }
                            }
                        } else {
                            i2 = scrollY;
                        }
                        if (i == DragImageView.this.getScrollX() || i2 != DragImageView.this.getScrollY()) {
                            DragImageView.this.scrollTo(i, i2);
                            DragImageView.this.invalidate();
                            if (DragImageView.this.cDO != null) {
                                DragImageView.this.cDO.a(DragImageView.this, i, i2);
                            }
                        }
                        return true;
                    }
                }
                i = scrollX;
                if (DragImageView.this.cDC + DragImageView.this.mTop + DragImageView.this.mBottom < DragImageView.this.getHeight()) {
                }
                if (i == DragImageView.this.getScrollX()) {
                }
                DragImageView.this.scrollTo(i, i2);
                DragImageView.this.invalidate();
                if (DragImageView.this.cDO != null) {
                }
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (DragImageView.this.cmy != null && !DragImageView.this.cDQ) {
                    DragImageView.this.cmy.onLongClick(DragImageView.this);
                }
                super.onLongPress(motionEvent);
            }
        });
    }

    private void aqz() {
        if (this.cEe == null) {
            if (this.coB != null) {
                this.coB.axi();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.cEe.getSourceImageRectInScreen();
        if (sourceImageRectInScreen == null) {
            if (this.coB != null) {
                this.coB.axi();
                return;
            }
            return;
        }
        this.cow.bottom = (((sourceImageRectInScreen.bottom - sourceImageRectInScreen.top) / (sourceImageRectInScreen.right - sourceImageRectInScreen.left)) * (this.cow.right - this.cow.left)) + this.cow.top;
        final float[] fArr = {(this.cow.left + this.cow.right) / 2.0f, (this.cow.top + this.cow.bottom) / 2.0f};
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
                    DragImageView.this.cow = DragImageView.this.h(floatValue, animatedFraction, sourceImageRectInScreen.right - sourceImageRectInScreen.left, sourceImageRectInScreen.bottom - sourceImageRectInScreen.top);
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
                DragImageView.this.cos = false;
                DragImageView.this.mMode = 4;
                DragImageView.this.invalidate();
                if (DragImageView.this.coB != null) {
                    DragImageView.this.coB.axi();
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
    public RectF h(float f2, float f3, float f4, float f5) {
        return new RectF(f2 - (f4 / 2.0f), f3 - (f5 / 2.0f), (f4 / 2.0f) + f2, (f5 / 2.0f) + f3);
    }

    private void awU() {
        int i = 0;
        int scrollX = getScrollX();
        if (this.cDB >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.cDB) {
                scrollX = (int) (this.cDB - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.cDC + this.mTop + this.mBottom >= getHeight()) {
            i = scrollY < (-this.cDV) ? -this.cDV : scrollY;
            if (getHeight() + i > this.cDC + this.mBottom + this.cDW) {
                i = (int) ((this.cDC - getHeight()) + this.mBottom + this.cDW);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
            if (this.cDO != null) {
                this.cDO.a(this, scrollX, i);
            }
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.cEd != null) {
            this.cEd.axZ();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.cDB;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.cDC;
    }

    public boolean awV() {
        if (this.mImageType == 1 || this.mImageType == 2) {
            return true;
        }
        return !this.cDR && getScrollX() >= ((int) (this.cDB - ((float) getWidth()))) + (-1);
    }

    public boolean awW() {
        if (this.mImageType == 1 || this.mImageType == 2) {
            return true;
        }
        return !this.cDR && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.cDN.axg()) {
            this.cDN.stopAnimation();
        }
        this.cDY = 0;
        super.setImageBitmap(bitmap);
        awQ();
        this.mImageType = 0;
        if (this.cov == null) {
            int measuredWidth = getMeasuredWidth();
            float measuredWidth2 = ((1.0f * getMeasuredWidth()) / bitmap.getWidth()) * bitmap.getHeight();
            if (measuredWidth2 > getMeasuredHeight()) {
                measuredWidth2 = getMeasuredHeight();
            }
            RectF h = h(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
            this.cov = new Rect((int) h.left, (int) h.top, (int) h.right, (int) h.bottom);
        }
        if (this.cEg == null) {
            this.cEg = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        }
    }

    public void q(Bitmap bitmap) {
        Bitmap imageBitmap = getImageBitmap();
        if (bitmap != null && !bitmap.isRecycled()) {
            if (imageBitmap != null && (imageBitmap.getWidth() != bitmap.getWidth() || imageBitmap.getHeight() != bitmap.getHeight())) {
                setImageBitmap(bitmap);
                super.setImageMatrix(this.mMatrix);
                return;
            }
            if (this.cDN.axg()) {
                this.cDN.stopAnimation();
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            super.setImageBitmap(bitmap);
            super.setImageMatrix(this.mMatrix);
            scrollTo(scrollX, scrollY);
            this.mImageType = 0;
        }
    }

    public void setGifData(byte[] bArr, Bitmap bitmap) {
        if (this.cDN.axg()) {
            this.cDN.stopAnimation();
        }
        super.setImageDrawable(null);
        stop();
        awQ();
        this.mImageType = 1;
        this.cDU = bitmap;
        this.cDI = bArr;
        if (this.cmB != null) {
            this.cmB.a(this);
        }
    }

    public void onDestroy() {
        if (this.cDN.axg()) {
            this.cDN.stopAnimation();
        }
        super.setImageDrawable(null);
        this.cDI = null;
        this.cDU = null;
        stop();
        if (this.cDT != null) {
            this.cDT.close();
            this.cDT = null;
        }
        if (this.cEd != null) {
            this.cEd.release();
            System.gc();
        }
    }

    public void release() {
        if (this.cDN.axg()) {
            this.cDN.stopAnimation();
        }
        stop();
        super.setImageDrawable(null);
        this.cDU = null;
    }

    public void setDefaultBitmap() {
        if (this.cDN.axg()) {
            this.cDN.stopAnimation();
        }
        try {
            if (this.cEb) {
                super.setImageBitmap(BitmapHelper.getCashBitmap(R.drawable.icon_default_avatar100));
            } else {
                super.setImageBitmap(BitmapHelper.getCashBitmap(R.drawable.btn_see_default));
            }
        } catch (OutOfMemoryError e2) {
            TbadkCoreApplication.getInst().onAppMemoryLow();
            System.gc();
            super.setImageBitmap(null);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
        this.mImageType = 2;
        awQ();
    }

    public void awX() {
        if (this.mImageType != 1 && this.mImageType != 2) {
            int size = this.cDD.size();
            if (size > 0) {
                this.cDD.add(Float.valueOf(this.cDD.get(size - 1).floatValue() * 1.25f));
            } else {
                this.cDD.add(Float.valueOf(this.cDE));
            }
            axc();
        }
    }

    public void awY() {
        if (this.mImageType != 1 && this.mImageType != 2) {
            int size = this.cDD.size();
            if (size > 1) {
                this.cDD.remove(size - 1);
            }
            axc();
        }
    }

    public void awZ() {
        awR();
        if (this.mImageType != 1 && this.mImageType != 2 && this.mCurrentScale != this.cDE) {
            this.cDD.clear();
            this.cDD.add(Float.valueOf(this.cDE));
            this.mCurrentScale = this.cDE;
            this.cDG = this.mCurrentScale;
            axc();
        }
    }

    public boolean axa() {
        if (this.mImageType == 1 || this.mImageType == 2) {
            return false;
        }
        int size = this.cDD.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.cDD.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.cDJ) && floatValue <= 5.0f;
    }

    public boolean axb() {
        if (this.mImageType == 1 || this.mImageType == 2) {
            return false;
        }
        int size = this.cDD.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled()) {
            return false;
        }
        return size > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axc() {
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
                    int size = this.cDD.size();
                    if (size > 0) {
                        f3 = this.cDD.get(size - 1).floatValue();
                    } else {
                        f3 = this.cDE;
                    }
                    this.mCurrentScale = f3;
                }
                this.mMatrix.setScale(this.mCurrentScale, this.mCurrentScale);
                this.cDB = imageBitmap.getWidth() * this.mCurrentScale;
                this.cDC = imageBitmap.getHeight() * this.mCurrentScale;
                float width = this.cDG * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.cDG;
                this.cDV = this.mTop;
                this.cDW = 0;
                float f4 = this.cDB < ((float) this.mViewWidth) ? (int) ((this.mViewWidth - this.cDB) / 2.0f) : 0.0f;
                if (this.cDC < this.mViewHeight) {
                    f2 = (int) ((this.mViewHeight - this.cDC) / 2.0f);
                    if (this.cDK == 1 && f2 > this.mTop) {
                        f2 = this.mTop;
                    }
                    this.cDV = (int) (this.mTop - f2);
                    this.cDW = this.mTop - this.cDV;
                } else {
                    f2 = 0.0f;
                }
                this.cDX = (int) f4;
                this.mMatrix.postTranslate(f4, f2);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    int width2 = i > getWidth() ? getWidth() : i;
                    if (this.cDB <= screenWidth) {
                        width2 = 0;
                    } else if (this.cDB > screenWidth && this.cDB / 2.0f < screenWidth) {
                        width2 = (int) (width2 - (this.cDB / 4.0f));
                    }
                    scrollX = width2;
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.cDB - width) / 2.0f);
                    }
                    if (this.cDB <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.cDB) {
                        scrollX = (int) (this.cDB - getWidth());
                    }
                }
                if (scrollX > 0 && this.cDB - scrollX < getWidth()) {
                    scrollX = (int) (this.cDB - getWidth());
                }
                int i3 = this.mMode == 2 ? ((int) ((this.cDC - height) / 2.0f)) + scrollY : scrollY;
                if (this.cDC <= getHeight()) {
                    i3 = 0;
                } else if (getHeight() + i3 > this.cDC) {
                    i3 = (int) (this.cDC - getHeight());
                }
                setHorizontalScrollBarEnabled(false);
                setVerticalScrollBarEnabled(false);
                if (scrollX < 0) {
                    scrollX = 0;
                }
                scrollTo(scrollX, i3 >= 0 ? i3 : 0);
                setImageMatrix(this.mMatrix);
                awR();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Animation {
        private boolean cEs = false;
        private boolean cEt = false;
        private long cEu;
        private long cEv;
        private long cEw;
        private long cEx;
        private int mStartX;
        private int mStartY;

        public a() {
        }

        public void s(float f, float f2) {
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
            this.cEu = f;
            this.cEv = f2;
            this.cEw = Math.abs((f * 1000.0f) / 2500.0f);
            this.cEx = Math.abs((f2 * 1000.0f) / 2500.0f);
            setDuration(Math.max(this.cEw, this.cEx));
            setInterpolator(DragImageView.this.cEf);
            this.mStartX = DragImageView.this.getScrollX();
            this.mStartY = DragImageView.this.getScrollY();
            this.cEs = true;
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
            if (this.cEw > this.cEx) {
                j = ((float) this.cEw) * f;
            } else {
                j = ((float) this.cEx) * f;
            }
            float f2 = ((float) (j > this.cEw ? this.cEw : j)) / 1000.0f;
            if (this.cEu > 0) {
                i = this.mStartX - ((int) (f2 * (((float) this.cEu) - ((2500.0f * f2) / 2.0f))));
            } else {
                i = this.mStartX - ((int) (f2 * (((float) this.cEu) + ((2500.0f * f2) / 2.0f))));
            }
            if (j > this.cEx) {
                j = this.cEx;
            }
            float f3 = ((float) j) / 1000.0f;
            if (this.cEv > 0) {
                i2 = this.mStartY - ((int) (f3 * (((float) this.cEv) - ((2500.0f * f3) / 2.0f))));
            } else {
                i2 = this.mStartY - ((int) (f3 * (((float) this.cEv) + ((2500.0f * f3) / 2.0f))));
            }
            if (DragImageView.this.cDC + DragImageView.this.mTop + DragImageView.this.mBottom > DragImageView.this.getHeight()) {
                if (i2 < (-DragImageView.this.cDV)) {
                    i2 = -DragImageView.this.cDV;
                }
                if (DragImageView.this.getHeight() + i2 > DragImageView.this.cDC + DragImageView.this.mBottom + DragImageView.this.cDW) {
                    i2 = (int) ((DragImageView.this.cDC - DragImageView.this.getHeight()) + DragImageView.this.mBottom + DragImageView.this.cDW);
                }
            } else {
                i2 = 0;
            }
            if (DragImageView.this.cDB > DragImageView.this.getWidth()) {
                int width = ((float) (DragImageView.this.getWidth() + i)) > DragImageView.this.cDB ? (int) (DragImageView.this.cDB - DragImageView.this.getWidth()) : i;
                if (width >= 0) {
                    i3 = width;
                }
            }
            DragImageView.this.scrollTo(i3, i2);
            DragImageView.this.invalidate();
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            if (!this.cEt) {
                if (DragImageView.this.cDH) {
                    this.cEs = false;
                    return false;
                }
                try {
                    if (super.getTransformation(j, transformation)) {
                        return true;
                    }
                    this.cEs = false;
                    return false;
                } catch (Exception e) {
                    this.cEs = false;
                    return false;
                }
            }
            this.cEt = false;
            this.cEs = false;
            return false;
        }

        public boolean axg() {
            return this.cEs;
        }

        public void stopAnimation() {
            this.cEt = true;
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.cDM = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cmy = onLongClickListener;
        if (this.cEd != null) {
            this.cEd.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setGifSetListener(e eVar) {
        this.cmB = eVar;
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
    public void axd() {
        long j;
        c poll = this.cEj.poll();
        if (poll == null) {
            this.cEo = true;
            return;
        }
        this.cEo = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.cEi != null) {
            j = this.cEi.delay - (currentTimeMillis - this.cEn);
            this.cEk.offer(this.cEi);
        } else {
            j = 0;
        }
        this.cEi = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public c axe() {
        c poll = this.cEk.poll();
        if (poll == null) {
            poll = new c();
            try {
                poll.cEy = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
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
        return this.cEi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends Thread {
        private volatile boolean Cg;

        private b() {
            this.Cg = false;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (this.Cg && DragImageView.this.cDT != null && DragImageView.this.cEh > 0 && DragImageView.this.width > 0 && DragImageView.this.height > 0) {
                try {
                    DragImageView.this.cDT.N(DragImageView.this.cEl);
                    c axe = DragImageView.this.axe();
                    if (axe.cEy == null || (axe.cEy.getWidth() != DragImageView.this.width && axe.cEy.getHeight() != DragImageView.this.height)) {
                        try {
                            axe.cEy = Bitmap.createBitmap(DragImageView.this.width, DragImageView.this.height, Bitmap.Config.ARGB_8888);
                        } catch (OutOfMemoryError e) {
                            TbadkCoreApplication.getInst().onAppMemoryLow();
                            try {
                                axe.cEy = Bitmap.createBitmap(DragImageView.this.width, DragImageView.this.height, Bitmap.Config.ARGB_4444);
                            } catch (OutOfMemoryError e2) {
                                TbadkCoreApplication.getInst().onAppMemoryLow();
                            } catch (Throwable th) {
                                BdLog.e(th.getMessage());
                            }
                        } catch (Throwable th2) {
                            BdLog.e(th2.getMessage());
                        }
                    }
                    DragImageView.this.cDT.a(axe.cEy, null);
                    axe.delay = DragImageView.this.cDT.O(DragImageView.this.cEl);
                    DragImageView.C(DragImageView.this);
                    if (axe.cEy == null) {
                        DragImageView.C(DragImageView.this);
                    }
                    DragImageView.this.cEl %= DragImageView.this.cEh;
                    DragImageView.this.cEj.put(axe);
                    if (DragImageView.this.cEo) {
                        DragImageView.this.mHandler.sendEmptyMessage(1);
                    }
                } catch (Exception e3) {
                    return;
                }
            }
        }
    }

    public boolean axf() {
        return this.cDZ;
    }

    public void setLoadBigImage(boolean z) {
        this.cDZ = z;
    }

    public int getBottomOffset() {
        return this.cDW;
    }

    public int getLeftOffset() {
        return this.cDX;
    }
}
