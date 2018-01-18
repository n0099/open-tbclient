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
    private static final int bmS = l.aq(TbadkCoreApplication.getInst()) / 5;
    public int aWA;
    private float bBA;
    private float bBB;
    private float bBC;
    private boolean bBD;
    private byte[] bBE;
    private int bBF;
    private int bBG;
    private f bBH;
    private View.OnClickListener bBI;
    private C0091a bBJ;
    private float bBK;
    private boolean bBL;
    private boolean bBM;
    private int bBN;
    private volatile com.baidu.adp.gif.b bBO;
    private Bitmap bBP;
    private int bBQ;
    private int bBR;
    private int bBS;
    private int bBT;
    private boolean bBU;
    private boolean bBV;
    private float bBW;
    private com.baidu.tbadk.widget.a.b.b bBX;
    private ImageUrlData bBY;
    private Interpolator bBZ;
    private float bBx;
    private float bBy;
    private ArrayList<Float> bBz;
    private Rect bCa;
    private int bCb;
    private c bCc;
    private BlockingLinkedDeque<c> bCd;
    private BlockingLinkedDeque<c> bCe;
    private volatile int bCf;
    private b bCg;
    private volatile long bCh;
    private volatile boolean bCi;
    private View.OnLongClickListener bjX;
    private e bka;
    private int bkb;
    private boolean bmK;
    private float bmL;
    private Matrix bmM;
    private Rect bmN;
    private RectF bmO;
    private d bmR;
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
        public Bitmap bCr;
        public int delay;
    }

    /* loaded from: classes.dex */
    public interface d {
        void Ph();

        void Pi();
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
        int i = aVar.bCf;
        aVar.bCf = i + 1;
        return i;
    }

    public void setIsHeadImage(boolean z) {
        this.bBV = z;
    }

    public void setImageUrlData(ImageUrlData imageUrlData) {
        this.bBY = imageUrlData;
    }

    public a(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.bBD = false;
        this.bBE = null;
        this.bkb = 0;
        this.bBF = 1300;
        this.bBG = 0;
        this.bBH = null;
        this.bBI = null;
        this.bjX = null;
        this.bka = null;
        this.bBK = 1.0f;
        this.aWA = 0;
        this.mMode = 0;
        this.bBL = false;
        this.bBM = false;
        this.bBN = 0;
        this.bBO = null;
        this.bBP = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.bBQ = 0;
        this.bBR = 0;
        this.bBS = 0;
        this.bBT = 0;
        this.bBZ = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.bmM = new Matrix();
        this.bmK = false;
        this.mRatio = 1.0f;
        this.bmL = 0.0f;
        this.bmO = new RectF();
        this.width = 0;
        this.height = 0;
        this.bCb = 0;
        this.bCc = null;
        this.bCd = new BlockingLinkedDeque<>(5);
        this.bCe = new BlockingLinkedDeque<>(6);
        this.bCf = 0;
        this.bCh = 0L;
        this.bCi = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.a.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        a.this.Pd();
                        break;
                    case 1:
                        if (a.this.bCi) {
                            a.this.Pd();
                            break;
                        }
                        break;
                    case 2:
                        a.this.invalidate();
                        a.this.bCh = System.currentTimeMillis();
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
        this.bBD = false;
        this.bBE = null;
        this.bkb = 0;
        this.bBF = 1300;
        this.bBG = 0;
        this.bBH = null;
        this.bBI = null;
        this.bjX = null;
        this.bka = null;
        this.bBK = 1.0f;
        this.aWA = 0;
        this.mMode = 0;
        this.bBL = false;
        this.bBM = false;
        this.bBN = 0;
        this.bBO = null;
        this.bBP = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.bBQ = 0;
        this.bBR = 0;
        this.bBS = 0;
        this.bBT = 0;
        this.bBZ = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.bmM = new Matrix();
        this.bmK = false;
        this.mRatio = 1.0f;
        this.bmL = 0.0f;
        this.bmO = new RectF();
        this.width = 0;
        this.height = 0;
        this.bCb = 0;
        this.bCc = null;
        this.bCd = new BlockingLinkedDeque<>(5);
        this.bCe = new BlockingLinkedDeque<>(6);
        this.bCf = 0;
        this.bCh = 0L;
        this.bCi = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.a.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        a.this.Pd();
                        break;
                    case 1:
                        if (a.this.bCi) {
                            a.this.Pd();
                            break;
                        }
                        break;
                    case 2:
                        a.this.invalidate();
                        a.this.bCh = System.currentTimeMillis();
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
        this.bBD = false;
        this.bBE = null;
        this.bkb = 0;
        this.bBF = 1300;
        this.bBG = 0;
        this.bBH = null;
        this.bBI = null;
        this.bjX = null;
        this.bka = null;
        this.bBK = 1.0f;
        this.aWA = 0;
        this.mMode = 0;
        this.bBL = false;
        this.bBM = false;
        this.bBN = 0;
        this.bBO = null;
        this.bBP = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.bBQ = 0;
        this.bBR = 0;
        this.bBS = 0;
        this.bBT = 0;
        this.bBZ = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.bmM = new Matrix();
        this.bmK = false;
        this.mRatio = 1.0f;
        this.bmL = 0.0f;
        this.bmO = new RectF();
        this.width = 0;
        this.height = 0;
        this.bCb = 0;
        this.bCc = null;
        this.bCd = new BlockingLinkedDeque<>(5);
        this.bCe = new BlockingLinkedDeque<>(6);
        this.bCf = 0;
        this.bCh = 0L;
        this.bCi = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.a.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        a.this.Pd();
                        break;
                    case 1:
                        if (a.this.bCi) {
                            a.this.Pd();
                            break;
                        }
                        break;
                    case 2:
                        a.this.invalidate();
                        a.this.bCh = System.currentTimeMillis();
                        a.this.mHandler.sendEmptyMessage(0);
                        break;
                }
                return false;
            }
        });
        initData();
    }

    public void setDragToExitListener(d dVar) {
        this.bmR = dVar;
    }

    public int getImageType() {
        return this.aWA;
    }

    public void setImageMode(int i) {
        this.bBG = i;
    }

    public void q(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.bkb = i;
    }

    public boolean OO() {
        if (this.bBX != null) {
            return this.bBX.OO();
        }
        return false;
    }

    public void OP() {
        this.bBM = false;
        this.bBD = false;
        this.mMode = 3;
        OV();
        if (this.mCurrentScale < this.bBA) {
            this.mCurrentScale = this.bBA;
            Pc();
        }
        invalidate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.bBX != null && this.bBX.onTouchEvent(motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.bBD = true;
                this.bBL = false;
                this.bBM = false;
                break;
            case 1:
                OP();
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
            this.bBK = v(motionEvent);
            if (this.bBK > 10.0f) {
                this.mMode = 2;
            }
        }
        if (this.mMode == 2 || !this.mGestureDetector.onTouchEvent(motionEvent)) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.bBL = true;
                        this.bBM = true;
                        if (this.aWA != 1 && this.aWA != 2) {
                            float v = v(motionEvent);
                            if (v >= 0.0f && Math.abs(this.bBK - v) >= 10.0f) {
                                if (Math.abs(this.bBK - v) > 100.0f) {
                                    this.bBK = v;
                                    break;
                                } else {
                                    float f2 = v / this.bBK;
                                    this.bBK = v;
                                    this.bBC = this.mCurrentScale;
                                    this.mCurrentScale *= f2;
                                    if (this.mCurrentScale > this.bBB) {
                                        this.mCurrentScale = this.bBB;
                                    }
                                    float minScaleValue = getMinScaleValue();
                                    if (this.mCurrentScale < minScaleValue) {
                                        this.mCurrentScale = minScaleValue;
                                    }
                                    Pc();
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
        return this.bBX != null ? this.bBX.getMinScaleValue() : this.bBA / 4.0f;
    }

    public float v(MotionEvent motionEvent) {
        return CompatibleUtile.getInstance().getSpacing(motionEvent);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            this.mViewWidth = i3 - i;
            this.mViewHeight = i4 - i2;
            OR();
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public boolean OQ() {
        if (this.bBX != null) {
            return this.bBX.PR();
        }
        return this.bBA == this.mCurrentScale;
    }

    protected float i(Bitmap bitmap) {
        if (this.bBX != null) {
            return this.bBX.PV();
        }
        if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            return 1.0f;
        }
        if (this.bBG == 0) {
            float width = this.mViewWidth / bitmap.getWidth();
            float height = this.mViewHeight / bitmap.getHeight();
            if (this.bBV) {
                if (this.aWA == 2) {
                    return 2.5f;
                }
                return Math.min(width, height);
            } else if (this.aWA != 2) {
                float f2 = this.bBW;
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

    protected float j(Bitmap bitmap) {
        if (this.bBX != null) {
            return this.bBX.PW();
        }
        float f2 = 1.0f;
        if (bitmap != null && !bitmap.isRecycled() && bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
            f2 = (float) Math.sqrt(this.bBF / (bitmap.getWidth() * bitmap.getHeight()));
            if (f2 > 10.0f) {
                return 10.0f;
            }
        }
        return f2;
    }

    private void OR() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            this.bBA = i(imageBitmap);
            this.bBB = j(imageBitmap);
            this.bBz.clear();
            this.bBz.add(Float.valueOf(this.bBA));
            this.mCurrentScale = this.bBA;
            this.bBC = this.mCurrentScale;
            Pc();
            return;
        }
        this.bBx = 0.0f;
        this.bBy = 0.0f;
        this.bBA = 1.0f;
        this.bBB = 1.0f;
        this.mCurrentScale = 1.0f;
        this.bBC = this.mCurrentScale;
        this.bBz.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    private void OS() {
        if (this.bBH != null) {
            this.bBH.a(this, canZoomIn(), canZoomOut());
        }
    }

    public void setOnSizeChangedListener(f fVar) {
        this.bBH = fVar;
    }

    public byte[] getImageData() {
        return this.bBE;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getMeasuredHeight() != 0 && getMeasuredWidth() != 0 && this.bBX != null) {
            this.bBX.PT();
        }
    }

    public void a(Bitmap bitmap, byte[] bArr) {
        this.bBE = bArr;
        if (this.bBX != null) {
            this.bBX.b(bitmap, bArr);
        }
        setImageBitmap(bitmap);
    }

    public void OT() {
        if (this.bBX == null) {
            this.bBX = new com.baidu.tbadk.widget.a.b.b(this);
            this.bBX.setOnClickListener(this.bBI);
            this.bBX.setOnLongClickListener(this.bjX);
        }
    }

    public void setImageLoadCallBack(com.baidu.tbadk.widget.a.b.a aVar) {
        if (this.bBX != null) {
            this.bBX.a(aVar);
        }
    }

    public boolean OU() {
        return (getImageBitmap() == null || this.bBX == null) ? false : true;
    }

    public Bitmap getGifCache() {
        return this.bBP;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        boolean z;
        if (this.bBX == null || !this.bBX.b(canvas, getImageBitmap())) {
            if (this.aWA == 2 && this.bBT != 0 && !this.bBJ.Pg()) {
                int width = getWidth();
                int height = getHeight();
                Drawable drawable = getDrawable();
                float f2 = 0.0f;
                float f3 = height * 0.3f;
                float f4 = width;
                float f5 = (1.0f - 0.3f) * height;
                if (this.bBV && drawable != null) {
                    Rect bounds = drawable.getBounds();
                    int i = bounds.right - bounds.left;
                    int i2 = bounds.bottom - bounds.top;
                    f2 = (width / 2) - (i * 2.5f);
                    f3 = (height / 2) - (i2 * 2.5f);
                    f4 = (i * 2.5f) + (width / 2);
                    f5 = (i2 * 2.5f) + (height / 2);
                }
                this.mPaint.setColor(aj.getColor(this.bBT));
                canvas.drawRect(f2, f3, f4, f5, this.mPaint);
                this.mPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
            }
            if (this.mMode == 3 && this.bmK) {
                this.bmK = false;
                this.bmM.reset();
                if (this.bmL < bmS) {
                    this.mMode = 0;
                } else {
                    this.mMode = 4;
                    IQ();
                }
            }
            if (this.aWA == 0 && this.bmK && this.bmN != null && this.bBY != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                if (this.bmO == null) {
                    this.bmO = new RectF();
                }
                this.bmM.mapRect(this.bmO, new RectF(this.bmN));
                Bitmap imageBitmap = getImageBitmap();
                if (imageBitmap != null && !imageBitmap.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.bCa, this.bmO, (Paint) null);
                }
            } else if (this.mMode == 4 && this.bmN != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                Bitmap imageBitmap2 = getImageBitmap();
                if (imageBitmap2 != null && !imageBitmap2.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.bCa, this.bmO, (Paint) null);
                }
            } else {
                super.onDraw(canvas);
            }
            if (this.aWA == 1 && this.bBP != null && !this.bBP.isRecycled()) {
                int width2 = this.bBP.getWidth();
                int height2 = this.bBP.getHeight();
                int width3 = getWidth();
                int height3 = getHeight();
                int i3 = (width3 - width2) >> 1;
                int i4 = (height3 - height2) >> 1;
                float f6 = this.bBW;
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
                if (this.bBN == 1 && this.bBO != null && this.bCc != null && this.bCc.bCr != null) {
                    if (z) {
                        canvas.drawBitmap(this.bCc.bCr, i3, i4, (Paint) null);
                    } else {
                        canvas.drawBitmap(this.bCc.bCr, this.mMatrix, this.mPaint);
                    }
                    invalidate();
                } else if (z) {
                    canvas.drawBitmap(this.bBP, i3, i4, (Paint) null);
                } else {
                    canvas.drawBitmap(this.bBP, this.mMatrix, this.mPaint);
                }
            }
        }
    }

    public void play() {
        com.baidu.adp.widget.a.a aVar;
        if (this.aWA == 1) {
            if (this.bBO == null) {
                if (this.bCg != null) {
                    this.bCg.sx = false;
                    this.bCg.interrupt();
                    this.bCg = null;
                }
                if (this.bBE != null) {
                    try {
                        aVar = a.C0015a.lh().g(this.bBE, 0, this.bBE.length);
                    } catch (StackOverflowError e2) {
                        aVar = null;
                    }
                    if (aVar == null || aVar.getGif() == null) {
                        com.baidu.tbadk.core.d.a.a("gifplay", -1L, -1, "DragImageView.play", -1, "decode error", new Object[0]);
                        return;
                    }
                    this.bBO = aVar.getGif();
                    if (this.bBO != null) {
                        this.bBN = 1;
                        this.width = this.bBO.getWidth();
                        this.height = this.bBO.getHeight();
                        this.bCf = 0;
                        this.bCb = this.bBO.getFrameCount();
                    } else {
                        this.bBN = 0;
                    }
                } else {
                    return;
                }
            }
            if (this.bBO != null) {
                if (this.bCg == null || (this.bCg != null && !this.bCg.sx)) {
                    this.bCi = true;
                    this.bCg = new b();
                    this.bCd.clear();
                    this.bCe.clear();
                    this.bCg.sx = true;
                    this.bCg.start();
                }
            }
        }
    }

    public void pause() {
        if (this.aWA == 1) {
            if (this.bCg != null) {
                this.bCg.sx = false;
                this.bCg.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.aWA == 1) {
            if (this.bCg != null) {
                this.bCg.sx = false;
                this.bCg.interrupt();
                this.bCg = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.bCi = true;
            this.bCc = null;
            this.bCe.clear();
            this.bCd.clear();
            this.width = 0;
            this.height = 0;
            this.bCf = 0;
            this.bCb = 0;
            this.bBO = null;
        }
    }

    private void initData() {
        this.bBW = l.ar(getContext());
        this.bBF = l.aq(getContext()) * l.ao(getContext()) * 2;
        if (this.bBF < 1690000) {
            this.bBF = 1690000;
        }
        this.bBx = 0.0f;
        this.bBy = 0.0f;
        this.bBz = new ArrayList<>();
        this.bBA = 1.0f;
        this.bBB = 1.0f;
        this.mCurrentScale = 1.0f;
        this.bBC = this.mCurrentScale;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.bBJ = new C0091a();
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWillNotDraw(false);
        scrollTo(0, 0);
        this.mGestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.a.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                if (a.this.aWA != 2 && (Math.abs(f2) > 200.0f || Math.abs(f3) > 200.0f)) {
                    a.this.bBJ.m(f2, f3);
                    a.this.startAnimation(a.this.bBJ);
                }
                return super.onFling(motionEvent, motionEvent2, f2, f3);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (a.this.aWA != 1 && a.this.aWA != 2) {
                    a.this.mMode = 2;
                    if (a.this.mCurrentScale > a.this.bBA) {
                        a.this.mCurrentScale = a.this.bBA;
                        a.this.bBC = a.this.mCurrentScale;
                        a.this.Pc();
                        return true;
                    }
                    a.this.mCurrentScale = a.this.bBA * 2.0f;
                    a.this.d(true, (int) motionEvent.getX(), (int) motionEvent.getY());
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (a.this.bBI != null && !a.this.bBL) {
                    a.this.bBI.onClick(a.this);
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
                a.this.bBL = true;
                if (a.this.bBG == 0 && a.this.bBM) {
                    return false;
                }
                int scrollX = a.this.getScrollX();
                int scrollY = a.this.getScrollY();
                if (a.this.bBx >= a.this.getWidth()) {
                    scrollX = (int) (scrollX + f2);
                    if (a.this.bBG == 0) {
                        i = scrollX >= 0 ? scrollX : 0;
                        if (a.this.getWidth() + i > a.this.bBx) {
                            i = (int) (a.this.bBx - a.this.getWidth());
                        }
                        if (a.this.bBy + a.this.mTop + a.this.mBottom < a.this.getHeight()) {
                            i2 = (int) (scrollY + f3);
                            if (a.this.bBG == 0) {
                                if (i2 < (-a.this.bBQ)) {
                                    i2 = -a.this.bBQ;
                                }
                                if (a.this.getHeight() + i2 > a.this.bBy + a.this.mBottom + a.this.bBR) {
                                    i2 = (int) ((a.this.bBy - a.this.getHeight()) + a.this.mBottom + a.this.bBR);
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
                if (a.this.bBy + a.this.mTop + a.this.mBottom < a.this.getHeight()) {
                }
                if (i == a.this.getScrollX()) {
                }
                a.this.scrollTo(i, i2);
                a.this.invalidate();
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (a.this.bjX != null && !a.this.bBL) {
                    a.this.bjX.onLongClick(a.this);
                }
                super.onLongPress(motionEvent);
            }
        });
    }

    private void IQ() {
        if (this.bBY == null) {
            if (this.bmR != null) {
                this.bmR.Pi();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.bBY.getSourceImageRectInScreen();
        if (sourceImageRectInScreen == null) {
            if (this.bmR != null) {
                this.bmR.Pi();
                return;
            }
            return;
        }
        this.bmO.bottom = (((sourceImageRectInScreen.bottom - sourceImageRectInScreen.top) / (sourceImageRectInScreen.right - sourceImageRectInScreen.left)) * (this.bmO.right - this.bmO.left)) + this.bmO.top;
        final float[] fArr = {(this.bmO.left + this.bmO.right) / 2.0f, (this.bmO.top + this.bmO.bottom) / 2.0f};
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
                    a.this.bmO = a.this.h(floatValue, animatedFraction, sourceImageRectInScreen.right - sourceImageRectInScreen.left, sourceImageRectInScreen.bottom - sourceImageRectInScreen.top);
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
                a.this.bmK = false;
                a.this.mMode = 4;
                a.this.invalidate();
                if (a.this.bmR != null) {
                    a.this.bmR.Pi();
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

    private void OV() {
        int i = 0;
        int scrollX = getScrollX();
        if (this.bBx >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.bBx) {
                scrollX = (int) (this.bBx - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.bBy + this.mTop + this.mBottom >= getHeight()) {
            i = scrollY < (-this.bBQ) ? -this.bBQ : scrollY;
            if (getHeight() + i > this.bBy + this.mBottom + this.bBR) {
                i = (int) ((this.bBy - getHeight()) + this.mBottom + this.bBR);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.bBX != null) {
            this.bBX.PS();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.bBx;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.bBy;
    }

    public boolean OW() {
        if (this.aWA == 1 || this.aWA == 2) {
            return true;
        }
        return !this.bBM && getScrollX() >= ((int) (this.bBx - ((float) getWidth()))) + (-1);
    }

    public boolean OX() {
        if (this.aWA == 1 || this.aWA == 2) {
            return true;
        }
        return !this.bBM && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.bBJ.Pg()) {
            this.bBJ.stopAnimation();
        }
        this.bBT = 0;
        super.setImageBitmap(bitmap);
        OR();
        this.aWA = 0;
        if (this.bmN == null) {
            int measuredWidth = getMeasuredWidth();
            float measuredWidth2 = ((1.0f * getMeasuredWidth()) / bitmap.getWidth()) * bitmap.getHeight();
            if (measuredWidth2 > getMeasuredHeight()) {
                measuredWidth2 = getMeasuredHeight();
            }
            RectF h = h(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
            this.bmN = new Rect((int) h.left, (int) h.top, (int) h.right, (int) h.bottom);
        }
        if (this.bCa == null) {
            this.bCa = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        }
    }

    public void k(Bitmap bitmap) {
        Bitmap imageBitmap = getImageBitmap();
        if (bitmap != null && !bitmap.isRecycled()) {
            if (imageBitmap != null && (imageBitmap.getWidth() != bitmap.getWidth() || imageBitmap.getHeight() != bitmap.getHeight())) {
                setImageBitmap(bitmap);
                super.setImageMatrix(this.mMatrix);
                return;
            }
            if (this.bBJ.Pg()) {
                this.bBJ.stopAnimation();
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            super.setImageBitmap(bitmap);
            super.setImageMatrix(this.mMatrix);
            scrollTo(scrollX, scrollY);
            this.aWA = 0;
        }
    }

    public void a(byte[] bArr, Bitmap bitmap) {
        if (this.bBJ.Pg()) {
            this.bBJ.stopAnimation();
        }
        super.setImageDrawable(null);
        stop();
        OR();
        this.aWA = 1;
        this.bBP = bitmap;
        this.bBE = bArr;
        if (this.bka != null) {
            this.bka.a(this);
        }
    }

    public void onDestroy() {
        if (this.bBJ.Pg()) {
            this.bBJ.stopAnimation();
        }
        super.setImageDrawable(null);
        this.bBE = null;
        this.bBP = null;
        stop();
        if (this.bBO != null) {
            this.bBO.close();
            this.bBO = null;
        }
        if (this.bBX != null) {
            this.bBX.release();
            System.gc();
        }
    }

    public void release() {
        if (this.bBJ.Pg()) {
            this.bBJ.stopAnimation();
        }
        stop();
        super.setImageDrawable(null);
        this.bBP = null;
    }

    public void OY() {
        if (this.bBJ.Pg()) {
            this.bBJ.stopAnimation();
        }
        try {
            if (this.bBV) {
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
        this.aWA = 2;
        OR();
    }

    public void OZ() {
        if (this.aWA != 1 && this.aWA != 2) {
            int size = this.bBz.size();
            if (size > 0) {
                this.bBz.add(Float.valueOf(this.bBz.get(size - 1).floatValue() * 1.25f));
            } else {
                this.bBz.add(Float.valueOf(this.bBA));
            }
            Pc();
        }
    }

    public void Pa() {
        if (this.aWA != 1 && this.aWA != 2) {
            int size = this.bBz.size();
            if (size > 1) {
                this.bBz.remove(size - 1);
            }
            Pc();
        }
    }

    public void Pb() {
        OS();
        if (this.aWA != 1 && this.aWA != 2 && this.mCurrentScale != this.bBA) {
            this.bBz.clear();
            this.bBz.add(Float.valueOf(this.bBA));
            this.mCurrentScale = this.bBA;
            this.bBC = this.mCurrentScale;
            Pc();
        }
    }

    public boolean canZoomIn() {
        if (this.aWA == 1 || this.aWA == 2) {
            return false;
        }
        int size = this.bBz.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.bBz.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.bBF) && floatValue <= 5.0f;
    }

    public boolean canZoomOut() {
        if (this.aWA == 1 || this.aWA == 2) {
            return false;
        }
        int size = this.bBz.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled()) {
            return false;
        }
        return size > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pc() {
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
                    int size = this.bBz.size();
                    if (size > 0) {
                        f3 = this.bBz.get(size - 1).floatValue();
                    } else {
                        f3 = this.bBA;
                    }
                    this.mCurrentScale = f3;
                }
                this.mMatrix.setScale(this.mCurrentScale, this.mCurrentScale);
                this.bBx = imageBitmap.getWidth() * this.mCurrentScale;
                this.bBy = imageBitmap.getHeight() * this.mCurrentScale;
                float width = this.bBC * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.bBC;
                this.bBQ = this.mTop;
                this.bBR = 0;
                float f4 = this.bBx < ((float) this.mViewWidth) ? (int) ((this.mViewWidth - this.bBx) / 2.0f) : 0.0f;
                if (this.bBy < this.mViewHeight) {
                    f2 = (int) ((this.mViewHeight - this.bBy) / 2.0f);
                    if (this.bBG == 1 && f2 > this.mTop) {
                        f2 = this.mTop;
                    }
                    this.bBQ = (int) (this.mTop - f2);
                    this.bBR = this.mTop - this.bBQ;
                } else {
                    f2 = 0.0f;
                }
                this.bBS = (int) f4;
                this.mMatrix.postTranslate(f4, f2);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    int width2 = i > getWidth() ? getWidth() : i;
                    if (this.bBx <= screenWidth) {
                        width2 = 0;
                    } else if (this.bBx > screenWidth && this.bBx / 2.0f < screenWidth) {
                        width2 = (int) (width2 - (this.bBx / 4.0f));
                    }
                    scrollX = width2;
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.bBx - width) / 2.0f);
                    }
                    if (this.bBx <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.bBx) {
                        scrollX = (int) (this.bBx - getWidth());
                    }
                }
                if (scrollX > 0 && this.bBx - scrollX < getWidth()) {
                    scrollX = (int) (this.bBx - getWidth());
                }
                int i3 = this.mMode == 2 ? ((int) ((this.bBy - height) / 2.0f)) + scrollY : scrollY;
                if (this.bBy <= getHeight()) {
                    i3 = 0;
                } else if (getHeight() + i3 > this.bBy) {
                    i3 = (int) (this.bBy - getHeight());
                }
                setHorizontalScrollBarEnabled(false);
                setVerticalScrollBarEnabled(false);
                if (scrollX < 0) {
                    scrollX = 0;
                }
                scrollTo(scrollX, i3 >= 0 ? i3 : 0);
                setImageMatrix(this.mMatrix);
                OS();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0091a extends Animation {
        private boolean bCk = false;
        private boolean bCl = false;
        private long bCm;
        private long bCn;
        private int bCo;
        private long bCp;
        private long bCq;
        private int mStartY;

        public C0091a() {
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
            this.bCm = f;
            this.bCn = f2;
            this.bCp = Math.abs((f * 1000.0f) / 2500.0f);
            this.bCq = Math.abs((f2 * 1000.0f) / 2500.0f);
            setDuration(Math.max(this.bCp, this.bCq));
            setInterpolator(a.this.bBZ);
            this.bCo = a.this.getScrollX();
            this.mStartY = a.this.getScrollY();
            this.bCk = true;
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
            if (this.bCp > this.bCq) {
                j = ((float) this.bCp) * f;
            } else {
                j = ((float) this.bCq) * f;
            }
            float f2 = ((float) (j > this.bCp ? this.bCp : j)) / 1000.0f;
            if (this.bCm > 0) {
                i = this.bCo - ((int) (f2 * (((float) this.bCm) - ((2500.0f * f2) / 2.0f))));
            } else {
                i = this.bCo - ((int) (f2 * (((float) this.bCm) + ((2500.0f * f2) / 2.0f))));
            }
            if (j > this.bCq) {
                j = this.bCq;
            }
            float f3 = ((float) j) / 1000.0f;
            if (this.bCn > 0) {
                i2 = this.mStartY - ((int) (f3 * (((float) this.bCn) - ((2500.0f * f3) / 2.0f))));
            } else {
                i2 = this.mStartY - ((int) (f3 * (((float) this.bCn) + ((2500.0f * f3) / 2.0f))));
            }
            if (a.this.bBy + a.this.mTop + a.this.mBottom > a.this.getHeight()) {
                if (i2 < (-a.this.bBQ)) {
                    i2 = -a.this.bBQ;
                }
                if (a.this.getHeight() + i2 > a.this.bBy + a.this.mBottom + a.this.bBR) {
                    i2 = (int) ((a.this.bBy - a.this.getHeight()) + a.this.mBottom + a.this.bBR);
                }
            } else {
                i2 = 0;
            }
            if (a.this.bBx > a.this.getWidth()) {
                int width = ((float) (a.this.getWidth() + i)) > a.this.bBx ? (int) (a.this.bBx - a.this.getWidth()) : i;
                if (width >= 0) {
                    i3 = width;
                }
            }
            a.this.scrollTo(i3, i2);
            a.this.invalidate();
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            if (!this.bCl) {
                if (a.this.bBD) {
                    this.bCk = false;
                    return false;
                }
                try {
                    if (super.getTransformation(j, transformation)) {
                        return true;
                    }
                    this.bCk = false;
                    return false;
                } catch (Exception e) {
                    this.bCk = false;
                    return false;
                }
            }
            this.bCl = false;
            this.bCk = false;
            return false;
        }

        public boolean Pg() {
            return this.bCk;
        }

        public void stopAnimation() {
            this.bCl = true;
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.bBI = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bjX = onLongClickListener;
        if (this.bBX != null) {
            this.bBX.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setGifSetListener(e eVar) {
        this.bka = eVar;
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
    public void Pd() {
        long j;
        c poll = this.bCd.poll();
        if (poll == null) {
            this.bCi = true;
            return;
        }
        this.bCi = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.bCc != null) {
            j = this.bCc.delay - (currentTimeMillis - this.bCh);
            this.bCe.offer(this.bCc);
        } else {
            j = 0;
        }
        this.bCc = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public c Pe() {
        c poll = this.bCe.poll();
        if (poll == null) {
            poll = new c();
            try {
                poll.bCr = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
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
        return this.bCc;
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
            while (this.sx && a.this.bBO != null && a.this.bCb > 0 && a.this.width > 0 && a.this.height > 0) {
                try {
                    a.this.bBO.cM(a.this.bCf);
                    c Pe = a.this.Pe();
                    if (Pe.bCr == null || (Pe.bCr.getWidth() != a.this.width && Pe.bCr.getHeight() != a.this.height)) {
                        try {
                            Pe.bCr = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_8888);
                        } catch (OutOfMemoryError e) {
                            TbadkCoreApplication.getInst().onAppMemoryLow();
                            try {
                                Pe.bCr = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_4444);
                            } catch (OutOfMemoryError e2) {
                                TbadkCoreApplication.getInst().onAppMemoryLow();
                            } catch (Throwable th) {
                                BdLog.e(th.getMessage());
                            }
                        } catch (Throwable th2) {
                            BdLog.e(th2.getMessage());
                        }
                    }
                    a.this.bBO.a(Pe.bCr, null);
                    Pe.delay = a.this.bBO.cN(a.this.bCf);
                    a.A(a.this);
                    if (Pe.bCr == null) {
                        a.A(a.this);
                    }
                    a.this.bCf %= a.this.bCb;
                    a.this.bCd.put(Pe);
                    if (a.this.bCi) {
                        a.this.mHandler.sendEmptyMessage(1);
                    }
                } catch (Exception e3) {
                    return;
                }
            }
        }
    }

    public boolean Pf() {
        return this.bBU;
    }

    public void setLoadBigImage(boolean z) {
        this.bBU = z;
    }

    public int getBottomOffset() {
        return this.bBR;
    }

    public int getLeftOffset() {
        return this.bBS;
    }
}
