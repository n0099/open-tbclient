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
    private static final int bpb = l.aq(TbadkCoreApplication.getInst()) / 5;
    public int aYa;
    private float bDA;
    private float bDB;
    private boolean bDC;
    private byte[] bDD;
    private int bDE;
    private int bDF;
    private f bDG;
    private View.OnClickListener bDH;
    private C0116a bDI;
    private float bDJ;
    private boolean bDK;
    private boolean bDL;
    private int bDM;
    private volatile com.baidu.adp.gif.b bDN;
    private Bitmap bDO;
    private int bDP;
    private int bDQ;
    private int bDR;
    private int bDS;
    private boolean bDT;
    private boolean bDU;
    private float bDV;
    private com.baidu.tbadk.widget.a.b.b bDW;
    private ImageUrlData bDX;
    private Interpolator bDY;
    private Rect bDZ;
    private float bDw;
    private float bDx;
    private ArrayList<Float> bDy;
    private float bDz;
    private int bEa;
    private c bEb;
    private BlockingLinkedDeque<c> bEc;
    private BlockingLinkedDeque<c> bEd;
    private volatile int bEe;
    private b bEf;
    private volatile long bEg;
    private volatile boolean bEh;
    private View.OnLongClickListener bmh;
    private e bmk;
    private int bml;
    private boolean boT;
    private float boU;
    private Matrix boV;
    private Rect boW;
    private RectF boX;
    private d bpa;
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
        public Bitmap bEq;
        public int delay;
    }

    /* loaded from: classes.dex */
    public interface d {
        void PN();

        void PO();
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
        int i = aVar.bEe;
        aVar.bEe = i + 1;
        return i;
    }

    public void setIsHeadImage(boolean z) {
        this.bDU = z;
    }

    public void setImageUrlData(ImageUrlData imageUrlData) {
        this.bDX = imageUrlData;
    }

    public a(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.bDC = false;
        this.bDD = null;
        this.bml = 0;
        this.bDE = 1300;
        this.bDF = 0;
        this.bDG = null;
        this.bDH = null;
        this.bmh = null;
        this.bmk = null;
        this.bDJ = 1.0f;
        this.aYa = 0;
        this.mMode = 0;
        this.bDK = false;
        this.bDL = false;
        this.bDM = 0;
        this.bDN = null;
        this.bDO = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.bDP = 0;
        this.bDQ = 0;
        this.bDR = 0;
        this.bDS = 0;
        this.bDY = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.boV = new Matrix();
        this.boT = false;
        this.mRatio = 1.0f;
        this.boU = 0.0f;
        this.boX = new RectF();
        this.width = 0;
        this.height = 0;
        this.bEa = 0;
        this.bEb = null;
        this.bEc = new BlockingLinkedDeque<>(5);
        this.bEd = new BlockingLinkedDeque<>(6);
        this.bEe = 0;
        this.bEg = 0L;
        this.bEh = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.a.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        a.this.PJ();
                        break;
                    case 1:
                        if (a.this.bEh) {
                            a.this.PJ();
                            break;
                        }
                        break;
                    case 2:
                        a.this.invalidate();
                        a.this.bEg = System.currentTimeMillis();
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
        this.bDC = false;
        this.bDD = null;
        this.bml = 0;
        this.bDE = 1300;
        this.bDF = 0;
        this.bDG = null;
        this.bDH = null;
        this.bmh = null;
        this.bmk = null;
        this.bDJ = 1.0f;
        this.aYa = 0;
        this.mMode = 0;
        this.bDK = false;
        this.bDL = false;
        this.bDM = 0;
        this.bDN = null;
        this.bDO = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.bDP = 0;
        this.bDQ = 0;
        this.bDR = 0;
        this.bDS = 0;
        this.bDY = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.boV = new Matrix();
        this.boT = false;
        this.mRatio = 1.0f;
        this.boU = 0.0f;
        this.boX = new RectF();
        this.width = 0;
        this.height = 0;
        this.bEa = 0;
        this.bEb = null;
        this.bEc = new BlockingLinkedDeque<>(5);
        this.bEd = new BlockingLinkedDeque<>(6);
        this.bEe = 0;
        this.bEg = 0L;
        this.bEh = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.a.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        a.this.PJ();
                        break;
                    case 1:
                        if (a.this.bEh) {
                            a.this.PJ();
                            break;
                        }
                        break;
                    case 2:
                        a.this.invalidate();
                        a.this.bEg = System.currentTimeMillis();
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
        this.bDC = false;
        this.bDD = null;
        this.bml = 0;
        this.bDE = 1300;
        this.bDF = 0;
        this.bDG = null;
        this.bDH = null;
        this.bmh = null;
        this.bmk = null;
        this.bDJ = 1.0f;
        this.aYa = 0;
        this.mMode = 0;
        this.bDK = false;
        this.bDL = false;
        this.bDM = 0;
        this.bDN = null;
        this.bDO = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.bDP = 0;
        this.bDQ = 0;
        this.bDR = 0;
        this.bDS = 0;
        this.bDY = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.boV = new Matrix();
        this.boT = false;
        this.mRatio = 1.0f;
        this.boU = 0.0f;
        this.boX = new RectF();
        this.width = 0;
        this.height = 0;
        this.bEa = 0;
        this.bEb = null;
        this.bEc = new BlockingLinkedDeque<>(5);
        this.bEd = new BlockingLinkedDeque<>(6);
        this.bEe = 0;
        this.bEg = 0L;
        this.bEh = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.a.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        a.this.PJ();
                        break;
                    case 1:
                        if (a.this.bEh) {
                            a.this.PJ();
                            break;
                        }
                        break;
                    case 2:
                        a.this.invalidate();
                        a.this.bEg = System.currentTimeMillis();
                        a.this.mHandler.sendEmptyMessage(0);
                        break;
                }
                return false;
            }
        });
        initData();
    }

    public void setDragToExitListener(d dVar) {
        this.bpa = dVar;
    }

    public int getImageType() {
        return this.aYa;
    }

    public void setImageMode(int i) {
        this.bDF = i;
    }

    public void q(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.bml = i;
    }

    public boolean Pu() {
        if (this.bDW != null) {
            return this.bDW.Pu();
        }
        return false;
    }

    public void Pv() {
        this.bDL = false;
        this.bDC = false;
        this.mMode = 3;
        PB();
        if (this.mCurrentScale < this.bDz) {
            this.mCurrentScale = this.bDz;
            PI();
        }
        invalidate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.bDW != null && this.bDW.onTouchEvent(motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.bDC = true;
                this.bDK = false;
                this.bDL = false;
                break;
            case 1:
                Pv();
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
            this.bDJ = z(motionEvent);
            if (this.bDJ > 10.0f) {
                this.mMode = 2;
            }
        }
        if (this.mMode == 2 || !this.mGestureDetector.onTouchEvent(motionEvent)) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.bDK = true;
                        this.bDL = true;
                        if (this.aYa != 1 && this.aYa != 2) {
                            float z = z(motionEvent);
                            if (z >= 0.0f && Math.abs(this.bDJ - z) >= 10.0f) {
                                if (Math.abs(this.bDJ - z) > 100.0f) {
                                    this.bDJ = z;
                                    break;
                                } else {
                                    float f2 = z / this.bDJ;
                                    this.bDJ = z;
                                    this.bDB = this.mCurrentScale;
                                    this.mCurrentScale *= f2;
                                    if (this.mCurrentScale > this.bDA) {
                                        this.mCurrentScale = this.bDA;
                                    }
                                    float minScaleValue = getMinScaleValue();
                                    if (this.mCurrentScale < minScaleValue) {
                                        this.mCurrentScale = minScaleValue;
                                    }
                                    PI();
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
        return this.bDW != null ? this.bDW.getMinScaleValue() : this.bDz / 4.0f;
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
            Px();
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public boolean Pw() {
        if (this.bDW != null) {
            return this.bDW.Qx();
        }
        return this.bDz == this.mCurrentScale;
    }

    protected float k(Bitmap bitmap) {
        if (this.bDW != null) {
            return this.bDW.QB();
        }
        if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            return 1.0f;
        }
        if (this.bDF == 0) {
            float width = this.mViewWidth / bitmap.getWidth();
            float height = this.mViewHeight / bitmap.getHeight();
            if (this.bDU) {
                if (this.aYa == 2) {
                    return 2.5f;
                }
                return Math.min(width, height);
            } else if (this.aYa != 2) {
                float f2 = this.bDV;
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
        if (this.bDW != null) {
            return this.bDW.QC();
        }
        float f2 = 1.0f;
        if (bitmap != null && !bitmap.isRecycled() && bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
            f2 = (float) Math.sqrt(this.bDE / (bitmap.getWidth() * bitmap.getHeight()));
            if (f2 > 10.0f) {
                return 10.0f;
            }
        }
        return f2;
    }

    private void Px() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            this.bDz = k(imageBitmap);
            this.bDA = l(imageBitmap);
            this.bDy.clear();
            this.bDy.add(Float.valueOf(this.bDz));
            this.mCurrentScale = this.bDz;
            this.bDB = this.mCurrentScale;
            PI();
            return;
        }
        this.bDw = 0.0f;
        this.bDx = 0.0f;
        this.bDz = 1.0f;
        this.bDA = 1.0f;
        this.mCurrentScale = 1.0f;
        this.bDB = this.mCurrentScale;
        this.bDy.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    private void Py() {
        if (this.bDG != null) {
            this.bDG.a(this, canZoomIn(), canZoomOut());
        }
    }

    public void setOnSizeChangedListener(f fVar) {
        this.bDG = fVar;
    }

    public byte[] getImageData() {
        return this.bDD;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getMeasuredHeight() != 0 && getMeasuredWidth() != 0 && this.bDW != null) {
            this.bDW.Qz();
        }
    }

    public void a(Bitmap bitmap, byte[] bArr) {
        this.bDD = bArr;
        if (this.bDW != null) {
            this.bDW.b(bitmap, bArr);
        }
        setImageBitmap(bitmap);
    }

    public void Pz() {
        if (this.bDW == null) {
            this.bDW = new com.baidu.tbadk.widget.a.b.b(this);
            this.bDW.setOnClickListener(this.bDH);
            this.bDW.setOnLongClickListener(this.bmh);
        }
    }

    public void setImageLoadCallBack(com.baidu.tbadk.widget.a.b.a aVar) {
        if (this.bDW != null) {
            this.bDW.a(aVar);
        }
    }

    public boolean PA() {
        return (getImageBitmap() == null || this.bDW == null) ? false : true;
    }

    public Bitmap getGifCache() {
        return this.bDO;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        boolean z;
        if (this.bDW == null || !this.bDW.b(canvas, getImageBitmap())) {
            if (this.aYa == 2 && this.bDS != 0 && !this.bDI.PM()) {
                int width = getWidth();
                int height = getHeight();
                Drawable drawable = getDrawable();
                float f2 = 0.0f;
                float f3 = height * 0.3f;
                float f4 = width;
                float f5 = (1.0f - 0.3f) * height;
                if (this.bDU && drawable != null) {
                    Rect bounds = drawable.getBounds();
                    int i = bounds.right - bounds.left;
                    int i2 = bounds.bottom - bounds.top;
                    f2 = (width / 2) - (i * 2.5f);
                    f3 = (height / 2) - (i2 * 2.5f);
                    f4 = (i * 2.5f) + (width / 2);
                    f5 = (i2 * 2.5f) + (height / 2);
                }
                this.mPaint.setColor(aj.getColor(this.bDS));
                canvas.drawRect(f2, f3, f4, f5, this.mPaint);
                this.mPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
            }
            if (this.mMode == 3 && this.boT) {
                this.boT = false;
                this.boV.reset();
                if (this.boU < bpb) {
                    this.mMode = 0;
                } else {
                    this.mMode = 4;
                    Jy();
                }
            }
            if (this.aYa == 0 && this.boT && this.boW != null && this.bDX != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                if (this.boX == null) {
                    this.boX = new RectF();
                }
                this.boV.mapRect(this.boX, new RectF(this.boW));
                Bitmap imageBitmap = getImageBitmap();
                if (imageBitmap != null && !imageBitmap.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.bDZ, this.boX, (Paint) null);
                }
            } else if (this.mMode == 4 && this.boW != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                Bitmap imageBitmap2 = getImageBitmap();
                if (imageBitmap2 != null && !imageBitmap2.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.bDZ, this.boX, (Paint) null);
                }
            } else {
                super.onDraw(canvas);
            }
            if (this.aYa == 1 && this.bDO != null && !this.bDO.isRecycled()) {
                int width2 = this.bDO.getWidth();
                int height2 = this.bDO.getHeight();
                int width3 = getWidth();
                int height3 = getHeight();
                int i3 = (width3 - width2) >> 1;
                int i4 = (height3 - height2) >> 1;
                float f6 = this.bDV;
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
                if (this.bDM == 1 && this.bDN != null && this.bEb != null && this.bEb.bEq != null) {
                    if (z) {
                        canvas.drawBitmap(this.bEb.bEq, i3, i4, (Paint) null);
                    } else {
                        canvas.drawBitmap(this.bEb.bEq, this.mMatrix, this.mPaint);
                    }
                    invalidate();
                } else if (z) {
                    canvas.drawBitmap(this.bDO, i3, i4, (Paint) null);
                } else {
                    canvas.drawBitmap(this.bDO, this.mMatrix, this.mPaint);
                }
            }
        }
    }

    public void play() {
        com.baidu.adp.widget.a.a aVar;
        if (this.aYa == 1) {
            if (this.bDN == null) {
                if (this.bEf != null) {
                    this.bEf.sw = false;
                    this.bEf.interrupt();
                    this.bEf = null;
                }
                if (this.bDD != null) {
                    try {
                        aVar = a.C0015a.lh().g(this.bDD, 0, this.bDD.length);
                    } catch (StackOverflowError e2) {
                        aVar = null;
                    }
                    if (aVar == null || aVar.getGif() == null) {
                        com.baidu.tbadk.core.d.a.a("gifplay", -1L, -1, "DragImageView.play", -1, "decode error", new Object[0]);
                        return;
                    }
                    this.bDN = aVar.getGif();
                    if (this.bDN != null) {
                        this.bDM = 1;
                        this.width = this.bDN.getWidth();
                        this.height = this.bDN.getHeight();
                        this.bEe = 0;
                        this.bEa = this.bDN.getFrameCount();
                    } else {
                        this.bDM = 0;
                    }
                } else {
                    return;
                }
            }
            if (this.bDN != null) {
                if (this.bEf == null || (this.bEf != null && !this.bEf.sw)) {
                    this.bEh = true;
                    this.bEf = new b();
                    this.bEc.clear();
                    this.bEd.clear();
                    this.bEf.sw = true;
                    this.bEf.start();
                }
            }
        }
    }

    public void pause() {
        if (this.aYa == 1) {
            if (this.bEf != null) {
                this.bEf.sw = false;
                this.bEf.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.aYa == 1) {
            if (this.bEf != null) {
                this.bEf.sw = false;
                this.bEf.interrupt();
                this.bEf = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.bEh = true;
            this.bEb = null;
            this.bEd.clear();
            this.bEc.clear();
            this.width = 0;
            this.height = 0;
            this.bEe = 0;
            this.bEa = 0;
            this.bDN = null;
        }
    }

    private void initData() {
        this.bDV = l.ar(getContext());
        this.bDE = l.aq(getContext()) * l.ao(getContext()) * 2;
        if (this.bDE < 1690000) {
            this.bDE = 1690000;
        }
        this.bDw = 0.0f;
        this.bDx = 0.0f;
        this.bDy = new ArrayList<>();
        this.bDz = 1.0f;
        this.bDA = 1.0f;
        this.mCurrentScale = 1.0f;
        this.bDB = this.mCurrentScale;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.bDI = new C0116a();
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWillNotDraw(false);
        scrollTo(0, 0);
        this.mGestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.a.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                if (a.this.aYa != 2 && (Math.abs(f2) > 200.0f || Math.abs(f3) > 200.0f)) {
                    a.this.bDI.m(f2, f3);
                    a.this.startAnimation(a.this.bDI);
                }
                return super.onFling(motionEvent, motionEvent2, f2, f3);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (a.this.aYa != 1 && a.this.aYa != 2) {
                    a.this.mMode = 2;
                    if (a.this.mCurrentScale > a.this.bDz) {
                        a.this.mCurrentScale = a.this.bDz;
                        a.this.bDB = a.this.mCurrentScale;
                        a.this.PI();
                        return true;
                    }
                    a.this.mCurrentScale = a.this.bDz * 2.0f;
                    a.this.e(true, (int) motionEvent.getX(), (int) motionEvent.getY());
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (a.this.bDH != null && !a.this.bDK) {
                    a.this.bDH.onClick(a.this);
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
                a.this.bDK = true;
                if (a.this.bDF == 0 && a.this.bDL) {
                    return false;
                }
                int scrollX = a.this.getScrollX();
                int scrollY = a.this.getScrollY();
                if (a.this.bDw >= a.this.getWidth()) {
                    scrollX = (int) (scrollX + f2);
                    if (a.this.bDF == 0) {
                        i = scrollX >= 0 ? scrollX : 0;
                        if (a.this.getWidth() + i > a.this.bDw) {
                            i = (int) (a.this.bDw - a.this.getWidth());
                        }
                        if (a.this.bDx + a.this.mTop + a.this.mBottom < a.this.getHeight()) {
                            i2 = (int) (scrollY + f3);
                            if (a.this.bDF == 0) {
                                if (i2 < (-a.this.bDP)) {
                                    i2 = -a.this.bDP;
                                }
                                if (a.this.getHeight() + i2 > a.this.bDx + a.this.mBottom + a.this.bDQ) {
                                    i2 = (int) ((a.this.bDx - a.this.getHeight()) + a.this.mBottom + a.this.bDQ);
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
                if (a.this.bDx + a.this.mTop + a.this.mBottom < a.this.getHeight()) {
                }
                if (i == a.this.getScrollX()) {
                }
                a.this.scrollTo(i, i2);
                a.this.invalidate();
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (a.this.bmh != null && !a.this.bDK) {
                    a.this.bmh.onLongClick(a.this);
                }
                super.onLongPress(motionEvent);
            }
        });
    }

    private void Jy() {
        if (this.bDX == null) {
            if (this.bpa != null) {
                this.bpa.PO();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.bDX.getSourceImageRectInScreen();
        if (sourceImageRectInScreen == null) {
            if (this.bpa != null) {
                this.bpa.PO();
                return;
            }
            return;
        }
        this.boX.bottom = (((sourceImageRectInScreen.bottom - sourceImageRectInScreen.top) / (sourceImageRectInScreen.right - sourceImageRectInScreen.left)) * (this.boX.right - this.boX.left)) + this.boX.top;
        final float[] fArr = {(this.boX.left + this.boX.right) / 2.0f, (this.boX.top + this.boX.bottom) / 2.0f};
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
                    a.this.boX = a.this.i(floatValue, animatedFraction, sourceImageRectInScreen.right - sourceImageRectInScreen.left, sourceImageRectInScreen.bottom - sourceImageRectInScreen.top);
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
                a.this.boT = false;
                a.this.mMode = 4;
                a.this.invalidate();
                if (a.this.bpa != null) {
                    a.this.bpa.PO();
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

    private void PB() {
        int i = 0;
        int scrollX = getScrollX();
        if (this.bDw >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.bDw) {
                scrollX = (int) (this.bDw - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.bDx + this.mTop + this.mBottom >= getHeight()) {
            i = scrollY < (-this.bDP) ? -this.bDP : scrollY;
            if (getHeight() + i > this.bDx + this.mBottom + this.bDQ) {
                i = (int) ((this.bDx - getHeight()) + this.mBottom + this.bDQ);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.bDW != null) {
            this.bDW.Qy();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.bDw;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.bDx;
    }

    public boolean PC() {
        if (this.aYa == 1 || this.aYa == 2) {
            return true;
        }
        return !this.bDL && getScrollX() >= ((int) (this.bDw - ((float) getWidth()))) + (-1);
    }

    public boolean PD() {
        if (this.aYa == 1 || this.aYa == 2) {
            return true;
        }
        return !this.bDL && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.bDI.PM()) {
            this.bDI.stopAnimation();
        }
        this.bDS = 0;
        super.setImageBitmap(bitmap);
        Px();
        this.aYa = 0;
        if (this.boW == null) {
            int measuredWidth = getMeasuredWidth();
            float measuredWidth2 = ((1.0f * getMeasuredWidth()) / bitmap.getWidth()) * bitmap.getHeight();
            if (measuredWidth2 > getMeasuredHeight()) {
                measuredWidth2 = getMeasuredHeight();
            }
            RectF i = i(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
            this.boW = new Rect((int) i.left, (int) i.top, (int) i.right, (int) i.bottom);
        }
        if (this.bDZ == null) {
            this.bDZ = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
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
            if (this.bDI.PM()) {
                this.bDI.stopAnimation();
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            super.setImageBitmap(bitmap);
            super.setImageMatrix(this.mMatrix);
            scrollTo(scrollX, scrollY);
            this.aYa = 0;
        }
    }

    public void a(byte[] bArr, Bitmap bitmap) {
        if (this.bDI.PM()) {
            this.bDI.stopAnimation();
        }
        super.setImageDrawable(null);
        stop();
        Px();
        this.aYa = 1;
        this.bDO = bitmap;
        this.bDD = bArr;
        if (this.bmk != null) {
            this.bmk.a(this);
        }
    }

    public void onDestroy() {
        if (this.bDI.PM()) {
            this.bDI.stopAnimation();
        }
        super.setImageDrawable(null);
        this.bDD = null;
        this.bDO = null;
        stop();
        if (this.bDN != null) {
            this.bDN.close();
            this.bDN = null;
        }
        if (this.bDW != null) {
            this.bDW.release();
            System.gc();
        }
    }

    public void release() {
        if (this.bDI.PM()) {
            this.bDI.stopAnimation();
        }
        stop();
        super.setImageDrawable(null);
        this.bDO = null;
    }

    public void PE() {
        if (this.bDI.PM()) {
            this.bDI.stopAnimation();
        }
        try {
            if (this.bDU) {
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
        this.aYa = 2;
        Px();
    }

    public void PF() {
        if (this.aYa != 1 && this.aYa != 2) {
            int size = this.bDy.size();
            if (size > 0) {
                this.bDy.add(Float.valueOf(this.bDy.get(size - 1).floatValue() * 1.25f));
            } else {
                this.bDy.add(Float.valueOf(this.bDz));
            }
            PI();
        }
    }

    public void PG() {
        if (this.aYa != 1 && this.aYa != 2) {
            int size = this.bDy.size();
            if (size > 1) {
                this.bDy.remove(size - 1);
            }
            PI();
        }
    }

    public void PH() {
        Py();
        if (this.aYa != 1 && this.aYa != 2 && this.mCurrentScale != this.bDz) {
            this.bDy.clear();
            this.bDy.add(Float.valueOf(this.bDz));
            this.mCurrentScale = this.bDz;
            this.bDB = this.mCurrentScale;
            PI();
        }
    }

    public boolean canZoomIn() {
        if (this.aYa == 1 || this.aYa == 2) {
            return false;
        }
        int size = this.bDy.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.bDy.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.bDE) && floatValue <= 5.0f;
    }

    public boolean canZoomOut() {
        if (this.aYa == 1 || this.aYa == 2) {
            return false;
        }
        int size = this.bDy.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled()) {
            return false;
        }
        return size > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PI() {
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
                    int size = this.bDy.size();
                    if (size > 0) {
                        f3 = this.bDy.get(size - 1).floatValue();
                    } else {
                        f3 = this.bDz;
                    }
                    this.mCurrentScale = f3;
                }
                this.mMatrix.setScale(this.mCurrentScale, this.mCurrentScale);
                this.bDw = imageBitmap.getWidth() * this.mCurrentScale;
                this.bDx = imageBitmap.getHeight() * this.mCurrentScale;
                float width = this.bDB * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.bDB;
                this.bDP = this.mTop;
                this.bDQ = 0;
                float f4 = this.bDw < ((float) this.mViewWidth) ? (int) ((this.mViewWidth - this.bDw) / 2.0f) : 0.0f;
                if (this.bDx < this.mViewHeight) {
                    f2 = (int) ((this.mViewHeight - this.bDx) / 2.0f);
                    if (this.bDF == 1 && f2 > this.mTop) {
                        f2 = this.mTop;
                    }
                    this.bDP = (int) (this.mTop - f2);
                    this.bDQ = this.mTop - this.bDP;
                } else {
                    f2 = 0.0f;
                }
                this.bDR = (int) f4;
                this.mMatrix.postTranslate(f4, f2);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    int width2 = i > getWidth() ? getWidth() : i;
                    if (this.bDw <= screenWidth) {
                        width2 = 0;
                    } else if (this.bDw > screenWidth && this.bDw / 2.0f < screenWidth) {
                        width2 = (int) (width2 - (this.bDw / 4.0f));
                    }
                    scrollX = width2;
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.bDw - width) / 2.0f);
                    }
                    if (this.bDw <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.bDw) {
                        scrollX = (int) (this.bDw - getWidth());
                    }
                }
                if (scrollX > 0 && this.bDw - scrollX < getWidth()) {
                    scrollX = (int) (this.bDw - getWidth());
                }
                int i3 = this.mMode == 2 ? ((int) ((this.bDx - height) / 2.0f)) + scrollY : scrollY;
                if (this.bDx <= getHeight()) {
                    i3 = 0;
                } else if (getHeight() + i3 > this.bDx) {
                    i3 = (int) (this.bDx - getHeight());
                }
                setHorizontalScrollBarEnabled(false);
                setVerticalScrollBarEnabled(false);
                if (scrollX < 0) {
                    scrollX = 0;
                }
                scrollTo(scrollX, i3 >= 0 ? i3 : 0);
                setImageMatrix(this.mMatrix);
                Py();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0116a extends Animation {
        private boolean bEj = false;
        private boolean bEk = false;
        private long bEl;
        private long bEm;
        private int bEn;
        private long bEo;
        private long bEp;
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
            this.bEl = f;
            this.bEm = f2;
            this.bEo = Math.abs((f * 1000.0f) / 2500.0f);
            this.bEp = Math.abs((f2 * 1000.0f) / 2500.0f);
            setDuration(Math.max(this.bEo, this.bEp));
            setInterpolator(a.this.bDY);
            this.bEn = a.this.getScrollX();
            this.mStartY = a.this.getScrollY();
            this.bEj = true;
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
            if (this.bEo > this.bEp) {
                j = ((float) this.bEo) * f;
            } else {
                j = ((float) this.bEp) * f;
            }
            float f2 = ((float) (j > this.bEo ? this.bEo : j)) / 1000.0f;
            if (this.bEl > 0) {
                i = this.bEn - ((int) (f2 * (((float) this.bEl) - ((2500.0f * f2) / 2.0f))));
            } else {
                i = this.bEn - ((int) (f2 * (((float) this.bEl) + ((2500.0f * f2) / 2.0f))));
            }
            if (j > this.bEp) {
                j = this.bEp;
            }
            float f3 = ((float) j) / 1000.0f;
            if (this.bEm > 0) {
                i2 = this.mStartY - ((int) (f3 * (((float) this.bEm) - ((2500.0f * f3) / 2.0f))));
            } else {
                i2 = this.mStartY - ((int) (f3 * (((float) this.bEm) + ((2500.0f * f3) / 2.0f))));
            }
            if (a.this.bDx + a.this.mTop + a.this.mBottom > a.this.getHeight()) {
                if (i2 < (-a.this.bDP)) {
                    i2 = -a.this.bDP;
                }
                if (a.this.getHeight() + i2 > a.this.bDx + a.this.mBottom + a.this.bDQ) {
                    i2 = (int) ((a.this.bDx - a.this.getHeight()) + a.this.mBottom + a.this.bDQ);
                }
            } else {
                i2 = 0;
            }
            if (a.this.bDw > a.this.getWidth()) {
                int width = ((float) (a.this.getWidth() + i)) > a.this.bDw ? (int) (a.this.bDw - a.this.getWidth()) : i;
                if (width >= 0) {
                    i3 = width;
                }
            }
            a.this.scrollTo(i3, i2);
            a.this.invalidate();
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            if (!this.bEk) {
                if (a.this.bDC) {
                    this.bEj = false;
                    return false;
                }
                try {
                    if (super.getTransformation(j, transformation)) {
                        return true;
                    }
                    this.bEj = false;
                    return false;
                } catch (Exception e) {
                    this.bEj = false;
                    return false;
                }
            }
            this.bEk = false;
            this.bEj = false;
            return false;
        }

        public boolean PM() {
            return this.bEj;
        }

        public void stopAnimation() {
            this.bEk = true;
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.bDH = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bmh = onLongClickListener;
        if (this.bDW != null) {
            this.bDW.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setGifSetListener(e eVar) {
        this.bmk = eVar;
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
    public void PJ() {
        long j;
        c poll = this.bEc.poll();
        if (poll == null) {
            this.bEh = true;
            return;
        }
        this.bEh = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.bEb != null) {
            j = this.bEb.delay - (currentTimeMillis - this.bEg);
            this.bEd.offer(this.bEb);
        } else {
            j = 0;
        }
        this.bEb = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public c PK() {
        c poll = this.bEd.poll();
        if (poll == null) {
            poll = new c();
            try {
                poll.bEq = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
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
        return this.bEb;
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
            while (this.sw && a.this.bDN != null && a.this.bEa > 0 && a.this.width > 0 && a.this.height > 0) {
                try {
                    a.this.bDN.cM(a.this.bEe);
                    c PK = a.this.PK();
                    if (PK.bEq == null || (PK.bEq.getWidth() != a.this.width && PK.bEq.getHeight() != a.this.height)) {
                        try {
                            PK.bEq = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_8888);
                        } catch (OutOfMemoryError e) {
                            TbadkCoreApplication.getInst().onAppMemoryLow();
                            try {
                                PK.bEq = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_4444);
                            } catch (OutOfMemoryError e2) {
                                TbadkCoreApplication.getInst().onAppMemoryLow();
                            } catch (Throwable th) {
                                BdLog.e(th.getMessage());
                            }
                        } catch (Throwable th2) {
                            BdLog.e(th2.getMessage());
                        }
                    }
                    a.this.bDN.a(PK.bEq, null);
                    PK.delay = a.this.bDN.cN(a.this.bEe);
                    a.A(a.this);
                    if (PK.bEq == null) {
                        a.A(a.this);
                    }
                    a.this.bEe %= a.this.bEa;
                    a.this.bEc.put(PK);
                    if (a.this.bEh) {
                        a.this.mHandler.sendEmptyMessage(1);
                    }
                } catch (Exception e3) {
                    return;
                }
            }
        }
    }

    public boolean PL() {
        return this.bDT;
    }

    public void setLoadBigImage(boolean z) {
        this.bDT = z;
    }

    public int getBottomOffset() {
        return this.bDQ;
    }

    public int getLeftOffset() {
        return this.bDR;
    }
}
