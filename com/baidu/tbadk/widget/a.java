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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends ImageView {
    private static final String TAG = a.class.getSimpleName();
    private static final int bpe = l.aq(TbadkCoreApplication.getInst()) / 5;
    public int aYc;
    private float bDA;
    private ArrayList<Float> bDB;
    private float bDC;
    private float bDD;
    private float bDE;
    private boolean bDF;
    private byte[] bDG;
    private int bDH;
    private int bDI;
    private f bDJ;
    private View.OnClickListener bDK;
    private C0116a bDL;
    private float bDM;
    private boolean bDN;
    private boolean bDO;
    private int bDP;
    private volatile com.baidu.adp.gif.b bDQ;
    private Bitmap bDR;
    private int bDS;
    private int bDT;
    private int bDU;
    private int bDV;
    private boolean bDW;
    private boolean bDX;
    private float bDY;
    private com.baidu.tbadk.widget.a.b.b bDZ;
    private float bDz;
    private ImageUrlData bEa;
    private Interpolator bEb;
    private Rect bEc;
    private int bEd;
    private c bEe;
    private BlockingLinkedDeque<c> bEf;
    private BlockingLinkedDeque<c> bEg;
    private volatile int bEh;
    private b bEi;
    private volatile long bEj;
    private volatile boolean bEk;
    private View.OnLongClickListener bmk;
    private e bmn;
    private int bmo;
    private boolean boW;
    private float boX;
    private Matrix boY;
    private Rect boZ;
    private RectF bpa;
    private d bpd;
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
        public Bitmap bEt;
        public int delay;
    }

    /* loaded from: classes.dex */
    public interface d {
        void PO();

        void PP();
    }

    /* loaded from: classes.dex */
    public interface e {
        void a(a aVar);
    }

    /* loaded from: classes.dex */
    public interface f {
        void a(a aVar, boolean z, boolean z2);
    }

    static /* synthetic */ int A(a aVar) {
        int i = aVar.bEh;
        aVar.bEh = i + 1;
        return i;
    }

    public void setIsHeadImage(boolean z) {
        this.bDX = z;
    }

    public void setImageUrlData(ImageUrlData imageUrlData) {
        this.bEa = imageUrlData;
    }

    public a(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.bDF = false;
        this.bDG = null;
        this.bmo = 0;
        this.bDH = 1300;
        this.bDI = 0;
        this.bDJ = null;
        this.bDK = null;
        this.bmk = null;
        this.bmn = null;
        this.bDM = 1.0f;
        this.aYc = 0;
        this.mMode = 0;
        this.bDN = false;
        this.bDO = false;
        this.bDP = 0;
        this.bDQ = null;
        this.bDR = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.bDS = 0;
        this.bDT = 0;
        this.bDU = 0;
        this.bDV = 0;
        this.bEb = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.boY = new Matrix();
        this.boW = false;
        this.mRatio = 1.0f;
        this.boX = 0.0f;
        this.bpa = new RectF();
        this.width = 0;
        this.height = 0;
        this.bEd = 0;
        this.bEe = null;
        this.bEf = new BlockingLinkedDeque<>(5);
        this.bEg = new BlockingLinkedDeque<>(6);
        this.bEh = 0;
        this.bEj = 0L;
        this.bEk = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.a.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        a.this.PK();
                        break;
                    case 1:
                        if (a.this.bEk) {
                            a.this.PK();
                            break;
                        }
                        break;
                    case 2:
                        a.this.invalidate();
                        a.this.bEj = System.currentTimeMillis();
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
        this.bDF = false;
        this.bDG = null;
        this.bmo = 0;
        this.bDH = 1300;
        this.bDI = 0;
        this.bDJ = null;
        this.bDK = null;
        this.bmk = null;
        this.bmn = null;
        this.bDM = 1.0f;
        this.aYc = 0;
        this.mMode = 0;
        this.bDN = false;
        this.bDO = false;
        this.bDP = 0;
        this.bDQ = null;
        this.bDR = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.bDS = 0;
        this.bDT = 0;
        this.bDU = 0;
        this.bDV = 0;
        this.bEb = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.boY = new Matrix();
        this.boW = false;
        this.mRatio = 1.0f;
        this.boX = 0.0f;
        this.bpa = new RectF();
        this.width = 0;
        this.height = 0;
        this.bEd = 0;
        this.bEe = null;
        this.bEf = new BlockingLinkedDeque<>(5);
        this.bEg = new BlockingLinkedDeque<>(6);
        this.bEh = 0;
        this.bEj = 0L;
        this.bEk = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.a.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        a.this.PK();
                        break;
                    case 1:
                        if (a.this.bEk) {
                            a.this.PK();
                            break;
                        }
                        break;
                    case 2:
                        a.this.invalidate();
                        a.this.bEj = System.currentTimeMillis();
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
        this.bDF = false;
        this.bDG = null;
        this.bmo = 0;
        this.bDH = 1300;
        this.bDI = 0;
        this.bDJ = null;
        this.bDK = null;
        this.bmk = null;
        this.bmn = null;
        this.bDM = 1.0f;
        this.aYc = 0;
        this.mMode = 0;
        this.bDN = false;
        this.bDO = false;
        this.bDP = 0;
        this.bDQ = null;
        this.bDR = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.bDS = 0;
        this.bDT = 0;
        this.bDU = 0;
        this.bDV = 0;
        this.bEb = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.boY = new Matrix();
        this.boW = false;
        this.mRatio = 1.0f;
        this.boX = 0.0f;
        this.bpa = new RectF();
        this.width = 0;
        this.height = 0;
        this.bEd = 0;
        this.bEe = null;
        this.bEf = new BlockingLinkedDeque<>(5);
        this.bEg = new BlockingLinkedDeque<>(6);
        this.bEh = 0;
        this.bEj = 0L;
        this.bEk = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.a.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        a.this.PK();
                        break;
                    case 1:
                        if (a.this.bEk) {
                            a.this.PK();
                            break;
                        }
                        break;
                    case 2:
                        a.this.invalidate();
                        a.this.bEj = System.currentTimeMillis();
                        a.this.mHandler.sendEmptyMessage(0);
                        break;
                }
                return false;
            }
        });
        initData();
    }

    public void setDragToExitListener(d dVar) {
        this.bpd = dVar;
    }

    public int getImageType() {
        return this.aYc;
    }

    public void setImageMode(int i) {
        this.bDI = i;
    }

    public void q(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.bmo = i;
    }

    public boolean Pv() {
        if (this.bDZ != null) {
            return this.bDZ.Pv();
        }
        return false;
    }

    public void Pw() {
        this.bDO = false;
        this.bDF = false;
        this.mMode = 3;
        PC();
        if (this.mCurrentScale < this.bDC) {
            this.mCurrentScale = this.bDC;
            PJ();
        }
        invalidate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.bDZ != null && this.bDZ.onTouchEvent(motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.bDF = true;
                this.bDN = false;
                this.bDO = false;
                break;
            case 1:
                Pw();
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
            this.bDM = z(motionEvent);
            if (this.bDM > 10.0f) {
                this.mMode = 2;
            }
        }
        if (this.mMode == 2 || !this.mGestureDetector.onTouchEvent(motionEvent)) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.bDN = true;
                        this.bDO = true;
                        if (this.aYc != 1 && this.aYc != 2) {
                            float z = z(motionEvent);
                            if (z >= 0.0f && Math.abs(this.bDM - z) >= 10.0f) {
                                if (Math.abs(this.bDM - z) > 100.0f) {
                                    this.bDM = z;
                                    break;
                                } else {
                                    float f2 = z / this.bDM;
                                    this.bDM = z;
                                    this.bDE = this.mCurrentScale;
                                    this.mCurrentScale *= f2;
                                    if (this.mCurrentScale > this.bDD) {
                                        this.mCurrentScale = this.bDD;
                                    }
                                    float minScaleValue = getMinScaleValue();
                                    if (this.mCurrentScale < minScaleValue) {
                                        this.mCurrentScale = minScaleValue;
                                    }
                                    PJ();
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
        return this.bDZ != null ? this.bDZ.getMinScaleValue() : this.bDC / 4.0f;
    }

    public float z(MotionEvent motionEvent) {
        return CompatibleUtile.getInstance().getSpacing(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            this.mViewWidth = i3 - i;
            this.mViewHeight = i4 - i2;
            Py();
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public boolean Px() {
        if (this.bDZ != null) {
            return this.bDZ.Qy();
        }
        return this.bDC == this.mCurrentScale;
    }

    protected float k(Bitmap bitmap) {
        if (this.bDZ != null) {
            return this.bDZ.QC();
        }
        if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            return 1.0f;
        }
        if (this.bDI == 0) {
            float width = this.mViewWidth / bitmap.getWidth();
            float height = this.mViewHeight / bitmap.getHeight();
            if (this.bDX) {
                if (this.aYc == 2) {
                    return 2.5f;
                }
                return Math.min(width, height);
            } else if (this.aYc != 2) {
                float f2 = this.bDY;
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

    protected float l(Bitmap bitmap) {
        if (this.bDZ != null) {
            return this.bDZ.QD();
        }
        float f2 = 1.0f;
        if (bitmap != null && !bitmap.isRecycled() && bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
            f2 = (float) Math.sqrt(this.bDH / (bitmap.getWidth() * bitmap.getHeight()));
            if (f2 > 10.0f) {
                return 10.0f;
            }
        }
        return f2;
    }

    private void Py() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            this.bDC = k(imageBitmap);
            this.bDD = l(imageBitmap);
            this.bDB.clear();
            this.bDB.add(Float.valueOf(this.bDC));
            this.mCurrentScale = this.bDC;
            this.bDE = this.mCurrentScale;
            PJ();
            return;
        }
        this.bDz = 0.0f;
        this.bDA = 0.0f;
        this.bDC = 1.0f;
        this.bDD = 1.0f;
        this.mCurrentScale = 1.0f;
        this.bDE = this.mCurrentScale;
        this.bDB.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    private void Pz() {
        if (this.bDJ != null) {
            this.bDJ.a(this, canZoomIn(), canZoomOut());
        }
    }

    public void setOnSizeChangedListener(f fVar) {
        this.bDJ = fVar;
    }

    public byte[] getImageData() {
        return this.bDG;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getMeasuredHeight() != 0 && getMeasuredWidth() != 0 && this.bDZ != null) {
            this.bDZ.QA();
        }
    }

    public void a(Bitmap bitmap, byte[] bArr) {
        this.bDG = bArr;
        if (this.bDZ != null) {
            this.bDZ.b(bitmap, bArr);
        }
        setImageBitmap(bitmap);
    }

    public void PA() {
        if (this.bDZ == null) {
            this.bDZ = new com.baidu.tbadk.widget.a.b.b(this);
            this.bDZ.setOnClickListener(this.bDK);
            this.bDZ.setOnLongClickListener(this.bmk);
        }
    }

    public void setImageLoadCallBack(com.baidu.tbadk.widget.a.b.a aVar) {
        if (this.bDZ != null) {
            this.bDZ.a(aVar);
        }
    }

    public boolean PB() {
        return (getImageBitmap() == null || this.bDZ == null) ? false : true;
    }

    public Bitmap getGifCache() {
        return this.bDR;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        boolean z;
        if (this.bDZ == null || !this.bDZ.b(canvas, getImageBitmap())) {
            if (this.aYc == 2 && this.bDV != 0 && !this.bDL.PN()) {
                int width = getWidth();
                int height = getHeight();
                Drawable drawable = getDrawable();
                float f2 = 0.0f;
                float f3 = height * 0.3f;
                float f4 = width;
                float f5 = (1.0f - 0.3f) * height;
                if (this.bDX && drawable != null) {
                    Rect bounds = drawable.getBounds();
                    int i = bounds.right - bounds.left;
                    int i2 = bounds.bottom - bounds.top;
                    f2 = (width / 2) - (i * 2.5f);
                    f3 = (height / 2) - (i2 * 2.5f);
                    f4 = (i * 2.5f) + (width / 2);
                    f5 = (i2 * 2.5f) + (height / 2);
                }
                this.mPaint.setColor(aj.getColor(this.bDV));
                canvas.drawRect(f2, f3, f4, f5, this.mPaint);
                this.mPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
            }
            if (this.mMode == 3 && this.boW) {
                this.boW = false;
                this.boY.reset();
                if (this.boX < bpe) {
                    this.mMode = 0;
                } else {
                    this.mMode = 4;
                    Jz();
                }
            }
            if (this.aYc == 0 && this.boW && this.boZ != null && this.bEa != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                if (this.bpa == null) {
                    this.bpa = new RectF();
                }
                this.boY.mapRect(this.bpa, new RectF(this.boZ));
                Bitmap imageBitmap = getImageBitmap();
                if (imageBitmap != null && !imageBitmap.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.bEc, this.bpa, (Paint) null);
                }
            } else if (this.mMode == 4 && this.boZ != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                Bitmap imageBitmap2 = getImageBitmap();
                if (imageBitmap2 != null && !imageBitmap2.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.bEc, this.bpa, (Paint) null);
                }
            } else {
                super.onDraw(canvas);
            }
            if (this.aYc == 1 && this.bDR != null && !this.bDR.isRecycled()) {
                int width2 = this.bDR.getWidth();
                int height2 = this.bDR.getHeight();
                int width3 = getWidth();
                int height3 = getHeight();
                int i3 = (width3 - width2) >> 1;
                int i4 = (height3 - height2) >> 1;
                float f6 = this.bDY;
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
                if (this.bDP == 1 && this.bDQ != null && this.bEe != null && this.bEe.bEt != null) {
                    if (z) {
                        canvas.drawBitmap(this.bEe.bEt, i3, i4, (Paint) null);
                    } else {
                        canvas.drawBitmap(this.bEe.bEt, this.mMatrix, this.mPaint);
                    }
                    invalidate();
                } else if (z) {
                    canvas.drawBitmap(this.bDR, i3, i4, (Paint) null);
                } else {
                    canvas.drawBitmap(this.bDR, this.mMatrix, this.mPaint);
                }
            }
        }
    }

    public void play() {
        com.baidu.adp.widget.a.a aVar;
        if (this.aYc == 1) {
            if (this.bDQ == null) {
                if (this.bEi != null) {
                    this.bEi.sw = false;
                    this.bEi.interrupt();
                    this.bEi = null;
                }
                if (this.bDG != null) {
                    try {
                        aVar = a.C0015a.lh().g(this.bDG, 0, this.bDG.length);
                    } catch (StackOverflowError e2) {
                        aVar = null;
                    }
                    if (aVar == null || aVar.getGif() == null) {
                        com.baidu.tbadk.core.d.a.a("gifplay", -1L, -1, "DragImageView.play", -1, "decode error", new Object[0]);
                        return;
                    }
                    this.bDQ = aVar.getGif();
                    if (this.bDQ != null) {
                        this.bDP = 1;
                        this.width = this.bDQ.getWidth();
                        this.height = this.bDQ.getHeight();
                        this.bEh = 0;
                        this.bEd = this.bDQ.getFrameCount();
                    } else {
                        this.bDP = 0;
                    }
                } else {
                    return;
                }
            }
            if (this.bDQ != null) {
                if (this.bEi == null || (this.bEi != null && !this.bEi.sw)) {
                    this.bEk = true;
                    this.bEi = new b();
                    this.bEf.clear();
                    this.bEg.clear();
                    this.bEi.sw = true;
                    this.bEi.start();
                }
            }
        }
    }

    public void pause() {
        if (this.aYc == 1) {
            if (this.bEi != null) {
                this.bEi.sw = false;
                this.bEi.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.aYc == 1) {
            if (this.bEi != null) {
                this.bEi.sw = false;
                this.bEi.interrupt();
                this.bEi = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.bEk = true;
            this.bEe = null;
            this.bEg.clear();
            this.bEf.clear();
            this.width = 0;
            this.height = 0;
            this.bEh = 0;
            this.bEd = 0;
            this.bDQ = null;
        }
    }

    private void initData() {
        this.bDY = l.ar(getContext());
        this.bDH = l.aq(getContext()) * l.ao(getContext()) * 2;
        if (this.bDH < 1690000) {
            this.bDH = 1690000;
        }
        this.bDz = 0.0f;
        this.bDA = 0.0f;
        this.bDB = new ArrayList<>();
        this.bDC = 1.0f;
        this.bDD = 1.0f;
        this.mCurrentScale = 1.0f;
        this.bDE = this.mCurrentScale;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.bDL = new C0116a();
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWillNotDraw(false);
        scrollTo(0, 0);
        this.mGestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.a.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                if (a.this.aYc != 2 && (Math.abs(f2) > 200.0f || Math.abs(f3) > 200.0f)) {
                    a.this.bDL.m(f2, f3);
                    a.this.startAnimation(a.this.bDL);
                }
                return super.onFling(motionEvent, motionEvent2, f2, f3);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (a.this.aYc != 1 && a.this.aYc != 2) {
                    a.this.mMode = 2;
                    if (a.this.mCurrentScale > a.this.bDC) {
                        a.this.mCurrentScale = a.this.bDC;
                        a.this.bDE = a.this.mCurrentScale;
                        a.this.PJ();
                        return true;
                    }
                    a.this.mCurrentScale = a.this.bDC * 2.0f;
                    a.this.e(true, (int) motionEvent.getX(), (int) motionEvent.getY());
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (a.this.bDK != null && !a.this.bDN) {
                    a.this.bDK.onClick(a.this);
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
                a.this.bDN = true;
                if (a.this.bDI == 0 && a.this.bDO) {
                    return false;
                }
                int scrollX = a.this.getScrollX();
                int scrollY = a.this.getScrollY();
                if (a.this.bDz >= a.this.getWidth()) {
                    scrollX = (int) (scrollX + f2);
                    if (a.this.bDI == 0) {
                        i = scrollX >= 0 ? scrollX : 0;
                        if (a.this.getWidth() + i > a.this.bDz) {
                            i = (int) (a.this.bDz - a.this.getWidth());
                        }
                        if (a.this.bDA + a.this.mTop + a.this.mBottom < a.this.getHeight()) {
                            i2 = (int) (scrollY + f3);
                            if (a.this.bDI == 0) {
                                if (i2 < (-a.this.bDS)) {
                                    i2 = -a.this.bDS;
                                }
                                if (a.this.getHeight() + i2 > a.this.bDA + a.this.mBottom + a.this.bDT) {
                                    i2 = (int) ((a.this.bDA - a.this.getHeight()) + a.this.mBottom + a.this.bDT);
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
                if (a.this.bDA + a.this.mTop + a.this.mBottom < a.this.getHeight()) {
                }
                if (i == a.this.getScrollX()) {
                }
                a.this.scrollTo(i, i2);
                a.this.invalidate();
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (a.this.bmk != null && !a.this.bDN) {
                    a.this.bmk.onLongClick(a.this);
                }
                super.onLongPress(motionEvent);
            }
        });
    }

    private void Jz() {
        if (this.bEa == null) {
            if (this.bpd != null) {
                this.bpd.PP();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.bEa.getSourceImageRectInScreen();
        if (sourceImageRectInScreen == null) {
            if (this.bpd != null) {
                this.bpd.PP();
                return;
            }
            return;
        }
        this.bpa.bottom = (((sourceImageRectInScreen.bottom - sourceImageRectInScreen.top) / (sourceImageRectInScreen.right - sourceImageRectInScreen.left)) * (this.bpa.right - this.bpa.left)) + this.bpa.top;
        final float[] fArr = {(this.bpa.left + this.bpa.right) / 2.0f, (this.bpa.top + this.bpa.bottom) / 2.0f};
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
                    a.this.bpa = a.this.i(floatValue, animatedFraction, sourceImageRectInScreen.right - sourceImageRectInScreen.left, sourceImageRectInScreen.bottom - sourceImageRectInScreen.top);
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
                a.this.boW = false;
                a.this.mMode = 4;
                a.this.invalidate();
                if (a.this.bpd != null) {
                    a.this.bpd.PP();
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
    public RectF i(float f2, float f3, float f4, float f5) {
        return new RectF(f2 - (f4 / 2.0f), f3 - (f5 / 2.0f), (f4 / 2.0f) + f2, (f5 / 2.0f) + f3);
    }

    private void PC() {
        int i = 0;
        int scrollX = getScrollX();
        if (this.bDz >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.bDz) {
                scrollX = (int) (this.bDz - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.bDA + this.mTop + this.mBottom >= getHeight()) {
            i = scrollY < (-this.bDS) ? -this.bDS : scrollY;
            if (getHeight() + i > this.bDA + this.mBottom + this.bDT) {
                i = (int) ((this.bDA - getHeight()) + this.mBottom + this.bDT);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.bDZ != null) {
            this.bDZ.Qz();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.bDz;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.bDA;
    }

    public boolean PD() {
        if (this.aYc == 1 || this.aYc == 2) {
            return true;
        }
        return !this.bDO && getScrollX() >= ((int) (this.bDz - ((float) getWidth()))) + (-1);
    }

    public boolean PE() {
        if (this.aYc == 1 || this.aYc == 2) {
            return true;
        }
        return !this.bDO && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.bDL.PN()) {
            this.bDL.stopAnimation();
        }
        this.bDV = 0;
        super.setImageBitmap(bitmap);
        Py();
        this.aYc = 0;
        if (this.boZ == null) {
            int measuredWidth = getMeasuredWidth();
            float measuredWidth2 = ((1.0f * getMeasuredWidth()) / bitmap.getWidth()) * bitmap.getHeight();
            if (measuredWidth2 > getMeasuredHeight()) {
                measuredWidth2 = getMeasuredHeight();
            }
            RectF i = i(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
            this.boZ = new Rect((int) i.left, (int) i.top, (int) i.right, (int) i.bottom);
        }
        if (this.bEc == null) {
            this.bEc = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        }
    }

    public void m(Bitmap bitmap) {
        Bitmap imageBitmap = getImageBitmap();
        if (bitmap != null && !bitmap.isRecycled()) {
            if (imageBitmap != null && (imageBitmap.getWidth() != bitmap.getWidth() || imageBitmap.getHeight() != bitmap.getHeight())) {
                setImageBitmap(bitmap);
                super.setImageMatrix(this.mMatrix);
                return;
            }
            if (this.bDL.PN()) {
                this.bDL.stopAnimation();
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            super.setImageBitmap(bitmap);
            super.setImageMatrix(this.mMatrix);
            scrollTo(scrollX, scrollY);
            this.aYc = 0;
        }
    }

    public void a(byte[] bArr, Bitmap bitmap) {
        if (this.bDL.PN()) {
            this.bDL.stopAnimation();
        }
        super.setImageDrawable(null);
        stop();
        Py();
        this.aYc = 1;
        this.bDR = bitmap;
        this.bDG = bArr;
        if (this.bmn != null) {
            this.bmn.a(this);
        }
    }

    public void onDestroy() {
        if (this.bDL.PN()) {
            this.bDL.stopAnimation();
        }
        super.setImageDrawable(null);
        this.bDG = null;
        this.bDR = null;
        stop();
        if (this.bDQ != null) {
            this.bDQ.close();
            this.bDQ = null;
        }
        if (this.bDZ != null) {
            this.bDZ.release();
            System.gc();
        }
    }

    public void release() {
        if (this.bDL.PN()) {
            this.bDL.stopAnimation();
        }
        stop();
        super.setImageDrawable(null);
        this.bDR = null;
    }

    public void PF() {
        if (this.bDL.PN()) {
            this.bDL.stopAnimation();
        }
        try {
            if (this.bDX) {
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
        this.aYc = 2;
        Py();
    }

    public void PG() {
        if (this.aYc != 1 && this.aYc != 2) {
            int size = this.bDB.size();
            if (size > 0) {
                this.bDB.add(Float.valueOf(this.bDB.get(size - 1).floatValue() * 1.25f));
            } else {
                this.bDB.add(Float.valueOf(this.bDC));
            }
            PJ();
        }
    }

    public void PH() {
        if (this.aYc != 1 && this.aYc != 2) {
            int size = this.bDB.size();
            if (size > 1) {
                this.bDB.remove(size - 1);
            }
            PJ();
        }
    }

    public void PI() {
        Pz();
        if (this.aYc != 1 && this.aYc != 2 && this.mCurrentScale != this.bDC) {
            this.bDB.clear();
            this.bDB.add(Float.valueOf(this.bDC));
            this.mCurrentScale = this.bDC;
            this.bDE = this.mCurrentScale;
            PJ();
        }
    }

    public boolean canZoomIn() {
        if (this.aYc == 1 || this.aYc == 2) {
            return false;
        }
        int size = this.bDB.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.bDB.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.bDH) && floatValue <= 5.0f;
    }

    public boolean canZoomOut() {
        if (this.aYc == 1 || this.aYc == 2) {
            return false;
        }
        int size = this.bDB.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled()) {
            return false;
        }
        return size > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PJ() {
        e(false, -1, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, int i, int i2) {
        float f2;
        float f3;
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled()) {
            try {
                if (this.mMode != 2) {
                    int size = this.bDB.size();
                    if (size > 0) {
                        f3 = this.bDB.get(size - 1).floatValue();
                    } else {
                        f3 = this.bDC;
                    }
                    this.mCurrentScale = f3;
                }
                this.mMatrix.setScale(this.mCurrentScale, this.mCurrentScale);
                this.bDz = imageBitmap.getWidth() * this.mCurrentScale;
                this.bDA = imageBitmap.getHeight() * this.mCurrentScale;
                float width = this.bDE * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.bDE;
                this.bDS = this.mTop;
                this.bDT = 0;
                float f4 = this.bDz < ((float) this.mViewWidth) ? (int) ((this.mViewWidth - this.bDz) / 2.0f) : 0.0f;
                if (this.bDA < this.mViewHeight) {
                    f2 = (int) ((this.mViewHeight - this.bDA) / 2.0f);
                    if (this.bDI == 1 && f2 > this.mTop) {
                        f2 = this.mTop;
                    }
                    this.bDS = (int) (this.mTop - f2);
                    this.bDT = this.mTop - this.bDS;
                } else {
                    f2 = 0.0f;
                }
                this.bDU = (int) f4;
                this.mMatrix.postTranslate(f4, f2);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    int width2 = i > getWidth() ? getWidth() : i;
                    if (this.bDz <= screenWidth) {
                        width2 = 0;
                    } else if (this.bDz > screenWidth && this.bDz / 2.0f < screenWidth) {
                        width2 = (int) (width2 - (this.bDz / 4.0f));
                    }
                    scrollX = width2;
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.bDz - width) / 2.0f);
                    }
                    if (this.bDz <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.bDz) {
                        scrollX = (int) (this.bDz - getWidth());
                    }
                }
                if (scrollX > 0 && this.bDz - scrollX < getWidth()) {
                    scrollX = (int) (this.bDz - getWidth());
                }
                int i3 = this.mMode == 2 ? ((int) ((this.bDA - height) / 2.0f)) + scrollY : scrollY;
                if (this.bDA <= getHeight()) {
                    i3 = 0;
                } else if (getHeight() + i3 > this.bDA) {
                    i3 = (int) (this.bDA - getHeight());
                }
                setHorizontalScrollBarEnabled(false);
                setVerticalScrollBarEnabled(false);
                if (scrollX < 0) {
                    scrollX = 0;
                }
                scrollTo(scrollX, i3 >= 0 ? i3 : 0);
                setImageMatrix(this.mMatrix);
                Pz();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0116a extends Animation {
        private boolean bEm = false;
        private boolean bEn = false;
        private long bEo;
        private long bEp;
        private int bEq;
        private long bEr;
        private long bEs;
        private int mStartY;

        public C0116a() {
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
            this.bEo = f;
            this.bEp = f2;
            this.bEr = Math.abs((f * 1000.0f) / 2500.0f);
            this.bEs = Math.abs((f2 * 1000.0f) / 2500.0f);
            setDuration(Math.max(this.bEr, this.bEs));
            setInterpolator(a.this.bEb);
            this.bEq = a.this.getScrollX();
            this.mStartY = a.this.getScrollY();
            this.bEm = true;
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
            if (this.bEr > this.bEs) {
                j = ((float) this.bEr) * f;
            } else {
                j = ((float) this.bEs) * f;
            }
            float f2 = ((float) (j > this.bEr ? this.bEr : j)) / 1000.0f;
            if (this.bEo > 0) {
                i = this.bEq - ((int) (f2 * (((float) this.bEo) - ((2500.0f * f2) / 2.0f))));
            } else {
                i = this.bEq - ((int) (f2 * (((float) this.bEo) + ((2500.0f * f2) / 2.0f))));
            }
            if (j > this.bEs) {
                j = this.bEs;
            }
            float f3 = ((float) j) / 1000.0f;
            if (this.bEp > 0) {
                i2 = this.mStartY - ((int) (f3 * (((float) this.bEp) - ((2500.0f * f3) / 2.0f))));
            } else {
                i2 = this.mStartY - ((int) (f3 * (((float) this.bEp) + ((2500.0f * f3) / 2.0f))));
            }
            if (a.this.bDA + a.this.mTop + a.this.mBottom > a.this.getHeight()) {
                if (i2 < (-a.this.bDS)) {
                    i2 = -a.this.bDS;
                }
                if (a.this.getHeight() + i2 > a.this.bDA + a.this.mBottom + a.this.bDT) {
                    i2 = (int) ((a.this.bDA - a.this.getHeight()) + a.this.mBottom + a.this.bDT);
                }
            } else {
                i2 = 0;
            }
            if (a.this.bDz > a.this.getWidth()) {
                int width = ((float) (a.this.getWidth() + i)) > a.this.bDz ? (int) (a.this.bDz - a.this.getWidth()) : i;
                if (width >= 0) {
                    i3 = width;
                }
            }
            a.this.scrollTo(i3, i2);
            a.this.invalidate();
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            if (!this.bEn) {
                if (a.this.bDF) {
                    this.bEm = false;
                    return false;
                }
                try {
                    if (super.getTransformation(j, transformation)) {
                        return true;
                    }
                    this.bEm = false;
                    return false;
                } catch (Exception e) {
                    this.bEm = false;
                    return false;
                }
            }
            this.bEn = false;
            this.bEm = false;
            return false;
        }

        public boolean PN() {
            return this.bEm;
        }

        public void stopAnimation() {
            this.bEn = true;
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.bDK = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bmk = onLongClickListener;
        if (this.bDZ != null) {
            this.bDZ.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setGifSetListener(e eVar) {
        this.bmn = eVar;
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
    public void PK() {
        long j;
        c poll = this.bEf.poll();
        if (poll == null) {
            this.bEk = true;
            return;
        }
        this.bEk = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.bEe != null) {
            j = this.bEe.delay - (currentTimeMillis - this.bEj);
            this.bEg.offer(this.bEe);
        } else {
            j = 0;
        }
        this.bEe = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public c PL() {
        c poll = this.bEg.poll();
        if (poll == null) {
            poll = new c();
            try {
                poll.bEt = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
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
        return this.bEe;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends Thread {
        private volatile boolean sw;

        private b() {
            this.sw = false;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (this.sw && a.this.bDQ != null && a.this.bEd > 0 && a.this.width > 0 && a.this.height > 0) {
                try {
                    a.this.bDQ.cM(a.this.bEh);
                    c PL = a.this.PL();
                    if (PL.bEt == null || (PL.bEt.getWidth() != a.this.width && PL.bEt.getHeight() != a.this.height)) {
                        try {
                            PL.bEt = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_8888);
                        } catch (OutOfMemoryError e) {
                            TbadkCoreApplication.getInst().onAppMemoryLow();
                            try {
                                PL.bEt = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_4444);
                            } catch (OutOfMemoryError e2) {
                                TbadkCoreApplication.getInst().onAppMemoryLow();
                            } catch (Throwable th) {
                                BdLog.e(th.getMessage());
                            }
                        } catch (Throwable th2) {
                            BdLog.e(th2.getMessage());
                        }
                    }
                    a.this.bDQ.a(PL.bEt, null);
                    PL.delay = a.this.bDQ.cN(a.this.bEh);
                    a.A(a.this);
                    if (PL.bEt == null) {
                        a.A(a.this);
                    }
                    a.this.bEh %= a.this.bEd;
                    a.this.bEf.put(PL);
                    if (a.this.bEk) {
                        a.this.mHandler.sendEmptyMessage(1);
                    }
                } catch (Exception e3) {
                    return;
                }
            }
        }
    }

    public boolean PM() {
        return this.bDW;
    }

    public void setLoadBigImage(boolean z) {
        this.bDW = z;
    }

    public int getBottomOffset() {
        return this.bDT;
    }

    public int getLeftOffset() {
        return this.bDU;
    }
}
