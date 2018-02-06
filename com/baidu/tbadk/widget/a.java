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
    private static final int bpo = l.aq(TbadkCoreApplication.getInst()) / 5;
    public int aYm;
    private float bDJ;
    private float bDK;
    private ArrayList<Float> bDL;
    private float bDM;
    private float bDN;
    private float bDO;
    private boolean bDP;
    private byte[] bDQ;
    private int bDR;
    private int bDS;
    private f bDT;
    private View.OnClickListener bDU;
    private C0115a bDV;
    private float bDW;
    private boolean bDX;
    private boolean bDY;
    private int bDZ;
    private volatile com.baidu.adp.gif.b bEa;
    private Bitmap bEb;
    private int bEc;
    private int bEd;
    private int bEe;
    private int bEf;
    private boolean bEg;
    private boolean bEh;
    private float bEi;
    private com.baidu.tbadk.widget.a.b.b bEj;
    private ImageUrlData bEk;
    private Interpolator bEl;
    private Rect bEm;
    private int bEn;
    private c bEo;
    private BlockingLinkedDeque<c> bEp;
    private BlockingLinkedDeque<c> bEq;
    private volatile int bEr;
    private b bEs;
    private volatile long bEt;
    private volatile boolean bEu;
    private View.OnLongClickListener bmu;
    private e bmx;
    private int bmy;
    private boolean bpg;
    private float bph;
    private Matrix bpi;
    private Rect bpj;
    private RectF bpk;
    private d bpn;
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
        public Bitmap bED;
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
        int i = aVar.bEr;
        aVar.bEr = i + 1;
        return i;
    }

    public void setIsHeadImage(boolean z) {
        this.bEh = z;
    }

    public void setImageUrlData(ImageUrlData imageUrlData) {
        this.bEk = imageUrlData;
    }

    public a(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.bDP = false;
        this.bDQ = null;
        this.bmy = 0;
        this.bDR = 1300;
        this.bDS = 0;
        this.bDT = null;
        this.bDU = null;
        this.bmu = null;
        this.bmx = null;
        this.bDW = 1.0f;
        this.aYm = 0;
        this.mMode = 0;
        this.bDX = false;
        this.bDY = false;
        this.bDZ = 0;
        this.bEa = null;
        this.bEb = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.bEc = 0;
        this.bEd = 0;
        this.bEe = 0;
        this.bEf = 0;
        this.bEl = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.bpi = new Matrix();
        this.bpg = false;
        this.mRatio = 1.0f;
        this.bph = 0.0f;
        this.bpk = new RectF();
        this.width = 0;
        this.height = 0;
        this.bEn = 0;
        this.bEo = null;
        this.bEp = new BlockingLinkedDeque<>(5);
        this.bEq = new BlockingLinkedDeque<>(6);
        this.bEr = 0;
        this.bEt = 0L;
        this.bEu = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.a.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        a.this.PK();
                        break;
                    case 1:
                        if (a.this.bEu) {
                            a.this.PK();
                            break;
                        }
                        break;
                    case 2:
                        a.this.invalidate();
                        a.this.bEt = System.currentTimeMillis();
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
        this.bDP = false;
        this.bDQ = null;
        this.bmy = 0;
        this.bDR = 1300;
        this.bDS = 0;
        this.bDT = null;
        this.bDU = null;
        this.bmu = null;
        this.bmx = null;
        this.bDW = 1.0f;
        this.aYm = 0;
        this.mMode = 0;
        this.bDX = false;
        this.bDY = false;
        this.bDZ = 0;
        this.bEa = null;
        this.bEb = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.bEc = 0;
        this.bEd = 0;
        this.bEe = 0;
        this.bEf = 0;
        this.bEl = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.bpi = new Matrix();
        this.bpg = false;
        this.mRatio = 1.0f;
        this.bph = 0.0f;
        this.bpk = new RectF();
        this.width = 0;
        this.height = 0;
        this.bEn = 0;
        this.bEo = null;
        this.bEp = new BlockingLinkedDeque<>(5);
        this.bEq = new BlockingLinkedDeque<>(6);
        this.bEr = 0;
        this.bEt = 0L;
        this.bEu = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.a.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        a.this.PK();
                        break;
                    case 1:
                        if (a.this.bEu) {
                            a.this.PK();
                            break;
                        }
                        break;
                    case 2:
                        a.this.invalidate();
                        a.this.bEt = System.currentTimeMillis();
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
        this.bDP = false;
        this.bDQ = null;
        this.bmy = 0;
        this.bDR = 1300;
        this.bDS = 0;
        this.bDT = null;
        this.bDU = null;
        this.bmu = null;
        this.bmx = null;
        this.bDW = 1.0f;
        this.aYm = 0;
        this.mMode = 0;
        this.bDX = false;
        this.bDY = false;
        this.bDZ = 0;
        this.bEa = null;
        this.bEb = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.bEc = 0;
        this.bEd = 0;
        this.bEe = 0;
        this.bEf = 0;
        this.bEl = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.bpi = new Matrix();
        this.bpg = false;
        this.mRatio = 1.0f;
        this.bph = 0.0f;
        this.bpk = new RectF();
        this.width = 0;
        this.height = 0;
        this.bEn = 0;
        this.bEo = null;
        this.bEp = new BlockingLinkedDeque<>(5);
        this.bEq = new BlockingLinkedDeque<>(6);
        this.bEr = 0;
        this.bEt = 0L;
        this.bEu = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.a.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        a.this.PK();
                        break;
                    case 1:
                        if (a.this.bEu) {
                            a.this.PK();
                            break;
                        }
                        break;
                    case 2:
                        a.this.invalidate();
                        a.this.bEt = System.currentTimeMillis();
                        a.this.mHandler.sendEmptyMessage(0);
                        break;
                }
                return false;
            }
        });
        initData();
    }

    public void setDragToExitListener(d dVar) {
        this.bpn = dVar;
    }

    public int getImageType() {
        return this.aYm;
    }

    public void setImageMode(int i) {
        this.bDS = i;
    }

    public void q(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.bmy = i;
    }

    public boolean Pv() {
        if (this.bEj != null) {
            return this.bEj.Pv();
        }
        return false;
    }

    public void Pw() {
        this.bDY = false;
        this.bDP = false;
        this.mMode = 3;
        PC();
        if (this.mCurrentScale < this.bDM) {
            this.mCurrentScale = this.bDM;
            PJ();
        }
        invalidate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.bEj != null && this.bEj.onTouchEvent(motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.bDP = true;
                this.bDX = false;
                this.bDY = false;
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
            this.bDW = z(motionEvent);
            if (this.bDW > 10.0f) {
                this.mMode = 2;
            }
        }
        if (this.mMode == 2 || !this.mGestureDetector.onTouchEvent(motionEvent)) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.bDX = true;
                        this.bDY = true;
                        if (this.aYm != 1 && this.aYm != 2) {
                            float z = z(motionEvent);
                            if (z >= 0.0f && Math.abs(this.bDW - z) >= 10.0f) {
                                if (Math.abs(this.bDW - z) > 100.0f) {
                                    this.bDW = z;
                                    break;
                                } else {
                                    float f2 = z / this.bDW;
                                    this.bDW = z;
                                    this.bDO = this.mCurrentScale;
                                    this.mCurrentScale *= f2;
                                    if (this.mCurrentScale > this.bDN) {
                                        this.mCurrentScale = this.bDN;
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
        return this.bEj != null ? this.bEj.getMinScaleValue() : this.bDM / 4.0f;
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
        if (this.bEj != null) {
            return this.bEj.Qy();
        }
        return this.bDM == this.mCurrentScale;
    }

    protected float k(Bitmap bitmap) {
        if (this.bEj != null) {
            return this.bEj.QC();
        }
        if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            return 1.0f;
        }
        if (this.bDS == 0) {
            float width = this.mViewWidth / bitmap.getWidth();
            float height = this.mViewHeight / bitmap.getHeight();
            if (this.bEh) {
                if (this.aYm == 2) {
                    return 2.5f;
                }
                return Math.min(width, height);
            } else if (this.aYm != 2) {
                float f2 = this.bEi;
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
        if (this.bEj != null) {
            return this.bEj.QD();
        }
        float f2 = 1.0f;
        if (bitmap != null && !bitmap.isRecycled() && bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
            f2 = (float) Math.sqrt(this.bDR / (bitmap.getWidth() * bitmap.getHeight()));
            if (f2 > 10.0f) {
                return 10.0f;
            }
        }
        return f2;
    }

    private void Py() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            this.bDM = k(imageBitmap);
            this.bDN = l(imageBitmap);
            this.bDL.clear();
            this.bDL.add(Float.valueOf(this.bDM));
            this.mCurrentScale = this.bDM;
            this.bDO = this.mCurrentScale;
            PJ();
            return;
        }
        this.bDJ = 0.0f;
        this.bDK = 0.0f;
        this.bDM = 1.0f;
        this.bDN = 1.0f;
        this.mCurrentScale = 1.0f;
        this.bDO = this.mCurrentScale;
        this.bDL.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    private void Pz() {
        if (this.bDT != null) {
            this.bDT.a(this, canZoomIn(), canZoomOut());
        }
    }

    public void setOnSizeChangedListener(f fVar) {
        this.bDT = fVar;
    }

    public byte[] getImageData() {
        return this.bDQ;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getMeasuredHeight() != 0 && getMeasuredWidth() != 0 && this.bEj != null) {
            this.bEj.QA();
        }
    }

    public void a(Bitmap bitmap, byte[] bArr) {
        this.bDQ = bArr;
        if (this.bEj != null) {
            this.bEj.b(bitmap, bArr);
        }
        setImageBitmap(bitmap);
    }

    public void PA() {
        if (this.bEj == null) {
            this.bEj = new com.baidu.tbadk.widget.a.b.b(this);
            this.bEj.setOnClickListener(this.bDU);
            this.bEj.setOnLongClickListener(this.bmu);
        }
    }

    public void setImageLoadCallBack(com.baidu.tbadk.widget.a.b.a aVar) {
        if (this.bEj != null) {
            this.bEj.a(aVar);
        }
    }

    public boolean PB() {
        return (getImageBitmap() == null || this.bEj == null) ? false : true;
    }

    public Bitmap getGifCache() {
        return this.bEb;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        boolean z;
        if (this.bEj == null || !this.bEj.b(canvas, getImageBitmap())) {
            if (this.aYm == 2 && this.bEf != 0 && !this.bDV.PN()) {
                int width = getWidth();
                int height = getHeight();
                Drawable drawable = getDrawable();
                float f2 = 0.0f;
                float f3 = height * 0.3f;
                float f4 = width;
                float f5 = (1.0f - 0.3f) * height;
                if (this.bEh && drawable != null) {
                    Rect bounds = drawable.getBounds();
                    int i = bounds.right - bounds.left;
                    int i2 = bounds.bottom - bounds.top;
                    f2 = (width / 2) - (i * 2.5f);
                    f3 = (height / 2) - (i2 * 2.5f);
                    f4 = (i * 2.5f) + (width / 2);
                    f5 = (i2 * 2.5f) + (height / 2);
                }
                this.mPaint.setColor(aj.getColor(this.bEf));
                canvas.drawRect(f2, f3, f4, f5, this.mPaint);
                this.mPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
            }
            if (this.mMode == 3 && this.bpg) {
                this.bpg = false;
                this.bpi.reset();
                if (this.bph < bpo) {
                    this.mMode = 0;
                } else {
                    this.mMode = 4;
                    Jz();
                }
            }
            if (this.aYm == 0 && this.bpg && this.bpj != null && this.bEk != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                if (this.bpk == null) {
                    this.bpk = new RectF();
                }
                this.bpi.mapRect(this.bpk, new RectF(this.bpj));
                Bitmap imageBitmap = getImageBitmap();
                if (imageBitmap != null && !imageBitmap.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.bEm, this.bpk, (Paint) null);
                }
            } else if (this.mMode == 4 && this.bpj != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                Bitmap imageBitmap2 = getImageBitmap();
                if (imageBitmap2 != null && !imageBitmap2.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.bEm, this.bpk, (Paint) null);
                }
            } else {
                super.onDraw(canvas);
            }
            if (this.aYm == 1 && this.bEb != null && !this.bEb.isRecycled()) {
                int width2 = this.bEb.getWidth();
                int height2 = this.bEb.getHeight();
                int width3 = getWidth();
                int height3 = getHeight();
                int i3 = (width3 - width2) >> 1;
                int i4 = (height3 - height2) >> 1;
                float f6 = this.bEi;
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
                if (this.bDZ == 1 && this.bEa != null && this.bEo != null && this.bEo.bED != null) {
                    if (z) {
                        canvas.drawBitmap(this.bEo.bED, i3, i4, (Paint) null);
                    } else {
                        canvas.drawBitmap(this.bEo.bED, this.mMatrix, this.mPaint);
                    }
                    invalidate();
                } else if (z) {
                    canvas.drawBitmap(this.bEb, i3, i4, (Paint) null);
                } else {
                    canvas.drawBitmap(this.bEb, this.mMatrix, this.mPaint);
                }
            }
        }
    }

    public void play() {
        com.baidu.adp.widget.a.a aVar;
        if (this.aYm == 1) {
            if (this.bEa == null) {
                if (this.bEs != null) {
                    this.bEs.sx = false;
                    this.bEs.interrupt();
                    this.bEs = null;
                }
                if (this.bDQ != null) {
                    try {
                        aVar = a.C0015a.lh().g(this.bDQ, 0, this.bDQ.length);
                    } catch (StackOverflowError e2) {
                        aVar = null;
                    }
                    if (aVar == null || aVar.getGif() == null) {
                        com.baidu.tbadk.core.d.a.a("gifplay", -1L, -1, "DragImageView.play", -1, "decode error", new Object[0]);
                        return;
                    }
                    this.bEa = aVar.getGif();
                    if (this.bEa != null) {
                        this.bDZ = 1;
                        this.width = this.bEa.getWidth();
                        this.height = this.bEa.getHeight();
                        this.bEr = 0;
                        this.bEn = this.bEa.getFrameCount();
                    } else {
                        this.bDZ = 0;
                    }
                } else {
                    return;
                }
            }
            if (this.bEa != null) {
                if (this.bEs == null || (this.bEs != null && !this.bEs.sx)) {
                    this.bEu = true;
                    this.bEs = new b();
                    this.bEp.clear();
                    this.bEq.clear();
                    this.bEs.sx = true;
                    this.bEs.start();
                }
            }
        }
    }

    public void pause() {
        if (this.aYm == 1) {
            if (this.bEs != null) {
                this.bEs.sx = false;
                this.bEs.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.aYm == 1) {
            if (this.bEs != null) {
                this.bEs.sx = false;
                this.bEs.interrupt();
                this.bEs = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.bEu = true;
            this.bEo = null;
            this.bEq.clear();
            this.bEp.clear();
            this.width = 0;
            this.height = 0;
            this.bEr = 0;
            this.bEn = 0;
            this.bEa = null;
        }
    }

    private void initData() {
        this.bEi = l.ar(getContext());
        this.bDR = l.aq(getContext()) * l.ao(getContext()) * 2;
        if (this.bDR < 1690000) {
            this.bDR = 1690000;
        }
        this.bDJ = 0.0f;
        this.bDK = 0.0f;
        this.bDL = new ArrayList<>();
        this.bDM = 1.0f;
        this.bDN = 1.0f;
        this.mCurrentScale = 1.0f;
        this.bDO = this.mCurrentScale;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.bDV = new C0115a();
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWillNotDraw(false);
        scrollTo(0, 0);
        this.mGestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.a.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                if (a.this.aYm != 2 && (Math.abs(f2) > 200.0f || Math.abs(f3) > 200.0f)) {
                    a.this.bDV.m(f2, f3);
                    a.this.startAnimation(a.this.bDV);
                }
                return super.onFling(motionEvent, motionEvent2, f2, f3);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (a.this.aYm != 1 && a.this.aYm != 2) {
                    a.this.mMode = 2;
                    if (a.this.mCurrentScale > a.this.bDM) {
                        a.this.mCurrentScale = a.this.bDM;
                        a.this.bDO = a.this.mCurrentScale;
                        a.this.PJ();
                        return true;
                    }
                    a.this.mCurrentScale = a.this.bDM * 2.0f;
                    a.this.e(true, (int) motionEvent.getX(), (int) motionEvent.getY());
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (a.this.bDU != null && !a.this.bDX) {
                    a.this.bDU.onClick(a.this);
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
                a.this.bDX = true;
                if (a.this.bDS == 0 && a.this.bDY) {
                    return false;
                }
                int scrollX = a.this.getScrollX();
                int scrollY = a.this.getScrollY();
                if (a.this.bDJ >= a.this.getWidth()) {
                    scrollX = (int) (scrollX + f2);
                    if (a.this.bDS == 0) {
                        i = scrollX >= 0 ? scrollX : 0;
                        if (a.this.getWidth() + i > a.this.bDJ) {
                            i = (int) (a.this.bDJ - a.this.getWidth());
                        }
                        if (a.this.bDK + a.this.mTop + a.this.mBottom < a.this.getHeight()) {
                            i2 = (int) (scrollY + f3);
                            if (a.this.bDS == 0) {
                                if (i2 < (-a.this.bEc)) {
                                    i2 = -a.this.bEc;
                                }
                                if (a.this.getHeight() + i2 > a.this.bDK + a.this.mBottom + a.this.bEd) {
                                    i2 = (int) ((a.this.bDK - a.this.getHeight()) + a.this.mBottom + a.this.bEd);
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
                if (a.this.bDK + a.this.mTop + a.this.mBottom < a.this.getHeight()) {
                }
                if (i == a.this.getScrollX()) {
                }
                a.this.scrollTo(i, i2);
                a.this.invalidate();
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (a.this.bmu != null && !a.this.bDX) {
                    a.this.bmu.onLongClick(a.this);
                }
                super.onLongPress(motionEvent);
            }
        });
    }

    private void Jz() {
        if (this.bEk == null) {
            if (this.bpn != null) {
                this.bpn.PP();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.bEk.getSourceImageRectInScreen();
        if (sourceImageRectInScreen == null) {
            if (this.bpn != null) {
                this.bpn.PP();
                return;
            }
            return;
        }
        this.bpk.bottom = (((sourceImageRectInScreen.bottom - sourceImageRectInScreen.top) / (sourceImageRectInScreen.right - sourceImageRectInScreen.left)) * (this.bpk.right - this.bpk.left)) + this.bpk.top;
        final float[] fArr = {(this.bpk.left + this.bpk.right) / 2.0f, (this.bpk.top + this.bpk.bottom) / 2.0f};
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
                    a.this.bpk = a.this.i(floatValue, animatedFraction, sourceImageRectInScreen.right - sourceImageRectInScreen.left, sourceImageRectInScreen.bottom - sourceImageRectInScreen.top);
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
                a.this.bpg = false;
                a.this.mMode = 4;
                a.this.invalidate();
                if (a.this.bpn != null) {
                    a.this.bpn.PP();
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
        if (this.bDJ >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.bDJ) {
                scrollX = (int) (this.bDJ - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.bDK + this.mTop + this.mBottom >= getHeight()) {
            i = scrollY < (-this.bEc) ? -this.bEc : scrollY;
            if (getHeight() + i > this.bDK + this.mBottom + this.bEd) {
                i = (int) ((this.bDK - getHeight()) + this.mBottom + this.bEd);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.bEj != null) {
            this.bEj.Qz();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.bDJ;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.bDK;
    }

    public boolean PD() {
        if (this.aYm == 1 || this.aYm == 2) {
            return true;
        }
        return !this.bDY && getScrollX() >= ((int) (this.bDJ - ((float) getWidth()))) + (-1);
    }

    public boolean PE() {
        if (this.aYm == 1 || this.aYm == 2) {
            return true;
        }
        return !this.bDY && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.bDV.PN()) {
            this.bDV.stopAnimation();
        }
        this.bEf = 0;
        super.setImageBitmap(bitmap);
        Py();
        this.aYm = 0;
        if (this.bpj == null) {
            int measuredWidth = getMeasuredWidth();
            float measuredWidth2 = ((1.0f * getMeasuredWidth()) / bitmap.getWidth()) * bitmap.getHeight();
            if (measuredWidth2 > getMeasuredHeight()) {
                measuredWidth2 = getMeasuredHeight();
            }
            RectF i = i(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
            this.bpj = new Rect((int) i.left, (int) i.top, (int) i.right, (int) i.bottom);
        }
        if (this.bEm == null) {
            this.bEm = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
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
            if (this.bDV.PN()) {
                this.bDV.stopAnimation();
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            super.setImageBitmap(bitmap);
            super.setImageMatrix(this.mMatrix);
            scrollTo(scrollX, scrollY);
            this.aYm = 0;
        }
    }

    public void a(byte[] bArr, Bitmap bitmap) {
        if (this.bDV.PN()) {
            this.bDV.stopAnimation();
        }
        super.setImageDrawable(null);
        stop();
        Py();
        this.aYm = 1;
        this.bEb = bitmap;
        this.bDQ = bArr;
        if (this.bmx != null) {
            this.bmx.a(this);
        }
    }

    public void onDestroy() {
        if (this.bDV.PN()) {
            this.bDV.stopAnimation();
        }
        super.setImageDrawable(null);
        this.bDQ = null;
        this.bEb = null;
        stop();
        if (this.bEa != null) {
            this.bEa.close();
            this.bEa = null;
        }
        if (this.bEj != null) {
            this.bEj.release();
            System.gc();
        }
    }

    public void release() {
        if (this.bDV.PN()) {
            this.bDV.stopAnimation();
        }
        stop();
        super.setImageDrawable(null);
        this.bEb = null;
    }

    public void PF() {
        if (this.bDV.PN()) {
            this.bDV.stopAnimation();
        }
        try {
            if (this.bEh) {
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
        this.aYm = 2;
        Py();
    }

    public void PG() {
        if (this.aYm != 1 && this.aYm != 2) {
            int size = this.bDL.size();
            if (size > 0) {
                this.bDL.add(Float.valueOf(this.bDL.get(size - 1).floatValue() * 1.25f));
            } else {
                this.bDL.add(Float.valueOf(this.bDM));
            }
            PJ();
        }
    }

    public void PH() {
        if (this.aYm != 1 && this.aYm != 2) {
            int size = this.bDL.size();
            if (size > 1) {
                this.bDL.remove(size - 1);
            }
            PJ();
        }
    }

    public void PI() {
        Pz();
        if (this.aYm != 1 && this.aYm != 2 && this.mCurrentScale != this.bDM) {
            this.bDL.clear();
            this.bDL.add(Float.valueOf(this.bDM));
            this.mCurrentScale = this.bDM;
            this.bDO = this.mCurrentScale;
            PJ();
        }
    }

    public boolean canZoomIn() {
        if (this.aYm == 1 || this.aYm == 2) {
            return false;
        }
        int size = this.bDL.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.bDL.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.bDR) && floatValue <= 5.0f;
    }

    public boolean canZoomOut() {
        if (this.aYm == 1 || this.aYm == 2) {
            return false;
        }
        int size = this.bDL.size();
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
                    int size = this.bDL.size();
                    if (size > 0) {
                        f3 = this.bDL.get(size - 1).floatValue();
                    } else {
                        f3 = this.bDM;
                    }
                    this.mCurrentScale = f3;
                }
                this.mMatrix.setScale(this.mCurrentScale, this.mCurrentScale);
                this.bDJ = imageBitmap.getWidth() * this.mCurrentScale;
                this.bDK = imageBitmap.getHeight() * this.mCurrentScale;
                float width = this.bDO * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.bDO;
                this.bEc = this.mTop;
                this.bEd = 0;
                float f4 = this.bDJ < ((float) this.mViewWidth) ? (int) ((this.mViewWidth - this.bDJ) / 2.0f) : 0.0f;
                if (this.bDK < this.mViewHeight) {
                    f2 = (int) ((this.mViewHeight - this.bDK) / 2.0f);
                    if (this.bDS == 1 && f2 > this.mTop) {
                        f2 = this.mTop;
                    }
                    this.bEc = (int) (this.mTop - f2);
                    this.bEd = this.mTop - this.bEc;
                } else {
                    f2 = 0.0f;
                }
                this.bEe = (int) f4;
                this.mMatrix.postTranslate(f4, f2);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    int width2 = i > getWidth() ? getWidth() : i;
                    if (this.bDJ <= screenWidth) {
                        width2 = 0;
                    } else if (this.bDJ > screenWidth && this.bDJ / 2.0f < screenWidth) {
                        width2 = (int) (width2 - (this.bDJ / 4.0f));
                    }
                    scrollX = width2;
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.bDJ - width) / 2.0f);
                    }
                    if (this.bDJ <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.bDJ) {
                        scrollX = (int) (this.bDJ - getWidth());
                    }
                }
                if (scrollX > 0 && this.bDJ - scrollX < getWidth()) {
                    scrollX = (int) (this.bDJ - getWidth());
                }
                int i3 = this.mMode == 2 ? ((int) ((this.bDK - height) / 2.0f)) + scrollY : scrollY;
                if (this.bDK <= getHeight()) {
                    i3 = 0;
                } else if (getHeight() + i3 > this.bDK) {
                    i3 = (int) (this.bDK - getHeight());
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
    public class C0115a extends Animation {
        private int bEA;
        private long bEB;
        private long bEC;
        private boolean bEw = false;
        private boolean bEx = false;
        private long bEy;
        private long bEz;
        private int mStartY;

        public C0115a() {
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
            this.bEy = f;
            this.bEz = f2;
            this.bEB = Math.abs((f * 1000.0f) / 2500.0f);
            this.bEC = Math.abs((f2 * 1000.0f) / 2500.0f);
            setDuration(Math.max(this.bEB, this.bEC));
            setInterpolator(a.this.bEl);
            this.bEA = a.this.getScrollX();
            this.mStartY = a.this.getScrollY();
            this.bEw = true;
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
            if (this.bEB > this.bEC) {
                j = ((float) this.bEB) * f;
            } else {
                j = ((float) this.bEC) * f;
            }
            float f2 = ((float) (j > this.bEB ? this.bEB : j)) / 1000.0f;
            if (this.bEy > 0) {
                i = this.bEA - ((int) (f2 * (((float) this.bEy) - ((2500.0f * f2) / 2.0f))));
            } else {
                i = this.bEA - ((int) (f2 * (((float) this.bEy) + ((2500.0f * f2) / 2.0f))));
            }
            if (j > this.bEC) {
                j = this.bEC;
            }
            float f3 = ((float) j) / 1000.0f;
            if (this.bEz > 0) {
                i2 = this.mStartY - ((int) (f3 * (((float) this.bEz) - ((2500.0f * f3) / 2.0f))));
            } else {
                i2 = this.mStartY - ((int) (f3 * (((float) this.bEz) + ((2500.0f * f3) / 2.0f))));
            }
            if (a.this.bDK + a.this.mTop + a.this.mBottom > a.this.getHeight()) {
                if (i2 < (-a.this.bEc)) {
                    i2 = -a.this.bEc;
                }
                if (a.this.getHeight() + i2 > a.this.bDK + a.this.mBottom + a.this.bEd) {
                    i2 = (int) ((a.this.bDK - a.this.getHeight()) + a.this.mBottom + a.this.bEd);
                }
            } else {
                i2 = 0;
            }
            if (a.this.bDJ > a.this.getWidth()) {
                int width = ((float) (a.this.getWidth() + i)) > a.this.bDJ ? (int) (a.this.bDJ - a.this.getWidth()) : i;
                if (width >= 0) {
                    i3 = width;
                }
            }
            a.this.scrollTo(i3, i2);
            a.this.invalidate();
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            if (!this.bEx) {
                if (a.this.bDP) {
                    this.bEw = false;
                    return false;
                }
                try {
                    if (super.getTransformation(j, transformation)) {
                        return true;
                    }
                    this.bEw = false;
                    return false;
                } catch (Exception e) {
                    this.bEw = false;
                    return false;
                }
            }
            this.bEx = false;
            this.bEw = false;
            return false;
        }

        public boolean PN() {
            return this.bEw;
        }

        public void stopAnimation() {
            this.bEx = true;
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.bDU = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bmu = onLongClickListener;
        if (this.bEj != null) {
            this.bEj.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setGifSetListener(e eVar) {
        this.bmx = eVar;
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
        c poll = this.bEp.poll();
        if (poll == null) {
            this.bEu = true;
            return;
        }
        this.bEu = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.bEo != null) {
            j = this.bEo.delay - (currentTimeMillis - this.bEt);
            this.bEq.offer(this.bEo);
        } else {
            j = 0;
        }
        this.bEo = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public c PL() {
        c poll = this.bEq.poll();
        if (poll == null) {
            poll = new c();
            try {
                poll.bED = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
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
        return this.bEo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends Thread {
        private volatile boolean sx;

        private b() {
            this.sx = false;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (this.sx && a.this.bEa != null && a.this.bEn > 0 && a.this.width > 0 && a.this.height > 0) {
                try {
                    a.this.bEa.cM(a.this.bEr);
                    c PL = a.this.PL();
                    if (PL.bED == null || (PL.bED.getWidth() != a.this.width && PL.bED.getHeight() != a.this.height)) {
                        try {
                            PL.bED = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_8888);
                        } catch (OutOfMemoryError e) {
                            TbadkCoreApplication.getInst().onAppMemoryLow();
                            try {
                                PL.bED = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_4444);
                            } catch (OutOfMemoryError e2) {
                                TbadkCoreApplication.getInst().onAppMemoryLow();
                            } catch (Throwable th) {
                                BdLog.e(th.getMessage());
                            }
                        } catch (Throwable th2) {
                            BdLog.e(th2.getMessage());
                        }
                    }
                    a.this.bEa.a(PL.bED, null);
                    PL.delay = a.this.bEa.cN(a.this.bEr);
                    a.A(a.this);
                    if (PL.bED == null) {
                        a.A(a.this);
                    }
                    a.this.bEr %= a.this.bEn;
                    a.this.bEp.put(PL);
                    if (a.this.bEu) {
                        a.this.mHandler.sendEmptyMessage(1);
                    }
                } catch (Exception e3) {
                    return;
                }
            }
        }
    }

    public boolean PM() {
        return this.bEg;
    }

    public void setLoadBigImage(boolean z) {
        this.bEg = z;
    }

    public int getBottomOffset() {
        return this.bEd;
    }

    public int getLeftOffset() {
        return this.bEe;
    }
}
