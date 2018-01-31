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
    private static final int bna = l.aq(TbadkCoreApplication.getInst()) / 5;
    public int aWD;
    private float bBF;
    private float bBG;
    private ArrayList<Float> bBH;
    private float bBI;
    private float bBJ;
    private float bBK;
    private boolean bBL;
    private byte[] bBM;
    private int bBN;
    private int bBO;
    private f bBP;
    private View.OnClickListener bBQ;
    private C0092a bBR;
    private float bBS;
    private boolean bBT;
    private boolean bBU;
    private int bBV;
    private volatile com.baidu.adp.gif.b bBW;
    private Bitmap bBX;
    private int bBY;
    private int bBZ;
    private int bCa;
    private int bCb;
    private boolean bCc;
    private boolean bCd;
    private float bCe;
    private com.baidu.tbadk.widget.a.b.b bCf;
    private ImageUrlData bCg;
    private Interpolator bCh;
    private Rect bCi;
    private int bCj;
    private c bCk;
    private BlockingLinkedDeque<c> bCl;
    private BlockingLinkedDeque<c> bCm;
    private volatile int bCn;
    private b bCo;
    private volatile long bCp;
    private volatile boolean bCq;
    private View.OnLongClickListener bkf;
    private e bki;
    private int bkj;
    private boolean bmS;
    private float bmT;
    private Matrix bmU;
    private Rect bmV;
    private RectF bmW;
    private d bmZ;
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
        public Bitmap bCz;
        public int delay;
    }

    /* loaded from: classes.dex */
    public interface d {
        void Pj();

        void Pk();
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
        int i = aVar.bCn;
        aVar.bCn = i + 1;
        return i;
    }

    public void setIsHeadImage(boolean z) {
        this.bCd = z;
    }

    public void setImageUrlData(ImageUrlData imageUrlData) {
        this.bCg = imageUrlData;
    }

    public a(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.bBL = false;
        this.bBM = null;
        this.bkj = 0;
        this.bBN = 1300;
        this.bBO = 0;
        this.bBP = null;
        this.bBQ = null;
        this.bkf = null;
        this.bki = null;
        this.bBS = 1.0f;
        this.aWD = 0;
        this.mMode = 0;
        this.bBT = false;
        this.bBU = false;
        this.bBV = 0;
        this.bBW = null;
        this.bBX = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.bBY = 0;
        this.bBZ = 0;
        this.bCa = 0;
        this.bCb = 0;
        this.bCh = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.bmU = new Matrix();
        this.bmS = false;
        this.mRatio = 1.0f;
        this.bmT = 0.0f;
        this.bmW = new RectF();
        this.width = 0;
        this.height = 0;
        this.bCj = 0;
        this.bCk = null;
        this.bCl = new BlockingLinkedDeque<>(5);
        this.bCm = new BlockingLinkedDeque<>(6);
        this.bCn = 0;
        this.bCp = 0L;
        this.bCq = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.a.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        a.this.Pf();
                        break;
                    case 1:
                        if (a.this.bCq) {
                            a.this.Pf();
                            break;
                        }
                        break;
                    case 2:
                        a.this.invalidate();
                        a.this.bCp = System.currentTimeMillis();
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
        this.bBL = false;
        this.bBM = null;
        this.bkj = 0;
        this.bBN = 1300;
        this.bBO = 0;
        this.bBP = null;
        this.bBQ = null;
        this.bkf = null;
        this.bki = null;
        this.bBS = 1.0f;
        this.aWD = 0;
        this.mMode = 0;
        this.bBT = false;
        this.bBU = false;
        this.bBV = 0;
        this.bBW = null;
        this.bBX = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.bBY = 0;
        this.bBZ = 0;
        this.bCa = 0;
        this.bCb = 0;
        this.bCh = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.bmU = new Matrix();
        this.bmS = false;
        this.mRatio = 1.0f;
        this.bmT = 0.0f;
        this.bmW = new RectF();
        this.width = 0;
        this.height = 0;
        this.bCj = 0;
        this.bCk = null;
        this.bCl = new BlockingLinkedDeque<>(5);
        this.bCm = new BlockingLinkedDeque<>(6);
        this.bCn = 0;
        this.bCp = 0L;
        this.bCq = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.a.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        a.this.Pf();
                        break;
                    case 1:
                        if (a.this.bCq) {
                            a.this.Pf();
                            break;
                        }
                        break;
                    case 2:
                        a.this.invalidate();
                        a.this.bCp = System.currentTimeMillis();
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
        this.bBL = false;
        this.bBM = null;
        this.bkj = 0;
        this.bBN = 1300;
        this.bBO = 0;
        this.bBP = null;
        this.bBQ = null;
        this.bkf = null;
        this.bki = null;
        this.bBS = 1.0f;
        this.aWD = 0;
        this.mMode = 0;
        this.bBT = false;
        this.bBU = false;
        this.bBV = 0;
        this.bBW = null;
        this.bBX = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.bBY = 0;
        this.bBZ = 0;
        this.bCa = 0;
        this.bCb = 0;
        this.bCh = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.bmU = new Matrix();
        this.bmS = false;
        this.mRatio = 1.0f;
        this.bmT = 0.0f;
        this.bmW = new RectF();
        this.width = 0;
        this.height = 0;
        this.bCj = 0;
        this.bCk = null;
        this.bCl = new BlockingLinkedDeque<>(5);
        this.bCm = new BlockingLinkedDeque<>(6);
        this.bCn = 0;
        this.bCp = 0L;
        this.bCq = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.a.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        a.this.Pf();
                        break;
                    case 1:
                        if (a.this.bCq) {
                            a.this.Pf();
                            break;
                        }
                        break;
                    case 2:
                        a.this.invalidate();
                        a.this.bCp = System.currentTimeMillis();
                        a.this.mHandler.sendEmptyMessage(0);
                        break;
                }
                return false;
            }
        });
        initData();
    }

    public void setDragToExitListener(d dVar) {
        this.bmZ = dVar;
    }

    public int getImageType() {
        return this.aWD;
    }

    public void setImageMode(int i) {
        this.bBO = i;
    }

    public void q(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.bkj = i;
    }

    public boolean OQ() {
        if (this.bCf != null) {
            return this.bCf.OQ();
        }
        return false;
    }

    public void OR() {
        this.bBU = false;
        this.bBL = false;
        this.mMode = 3;
        OX();
        if (this.mCurrentScale < this.bBI) {
            this.mCurrentScale = this.bBI;
            Pe();
        }
        invalidate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.bCf != null && this.bCf.onTouchEvent(motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.bBL = true;
                this.bBT = false;
                this.bBU = false;
                break;
            case 1:
                OR();
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
            this.bBS = v(motionEvent);
            if (this.bBS > 10.0f) {
                this.mMode = 2;
            }
        }
        if (this.mMode == 2 || !this.mGestureDetector.onTouchEvent(motionEvent)) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.bBT = true;
                        this.bBU = true;
                        if (this.aWD != 1 && this.aWD != 2) {
                            float v = v(motionEvent);
                            if (v >= 0.0f && Math.abs(this.bBS - v) >= 10.0f) {
                                if (Math.abs(this.bBS - v) > 100.0f) {
                                    this.bBS = v;
                                    break;
                                } else {
                                    float f2 = v / this.bBS;
                                    this.bBS = v;
                                    this.bBK = this.mCurrentScale;
                                    this.mCurrentScale *= f2;
                                    if (this.mCurrentScale > this.bBJ) {
                                        this.mCurrentScale = this.bBJ;
                                    }
                                    float minScaleValue = getMinScaleValue();
                                    if (this.mCurrentScale < minScaleValue) {
                                        this.mCurrentScale = minScaleValue;
                                    }
                                    Pe();
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
        return this.bCf != null ? this.bCf.getMinScaleValue() : this.bBI / 4.0f;
    }

    public float v(MotionEvent motionEvent) {
        return CompatibleUtile.getInstance().getSpacing(motionEvent);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            this.mViewWidth = i3 - i;
            this.mViewHeight = i4 - i2;
            OT();
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public boolean OS() {
        if (this.bCf != null) {
            return this.bCf.PT();
        }
        return this.bBI == this.mCurrentScale;
    }

    protected float i(Bitmap bitmap) {
        if (this.bCf != null) {
            return this.bCf.PX();
        }
        if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            return 1.0f;
        }
        if (this.bBO == 0) {
            float width = this.mViewWidth / bitmap.getWidth();
            float height = this.mViewHeight / bitmap.getHeight();
            if (this.bCd) {
                if (this.aWD == 2) {
                    return 2.5f;
                }
                return Math.min(width, height);
            } else if (this.aWD != 2) {
                float f2 = this.bCe;
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
        if (this.bCf != null) {
            return this.bCf.PY();
        }
        float f2 = 1.0f;
        if (bitmap != null && !bitmap.isRecycled() && bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
            f2 = (float) Math.sqrt(this.bBN / (bitmap.getWidth() * bitmap.getHeight()));
            if (f2 > 10.0f) {
                return 10.0f;
            }
        }
        return f2;
    }

    private void OT() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            this.bBI = i(imageBitmap);
            this.bBJ = j(imageBitmap);
            this.bBH.clear();
            this.bBH.add(Float.valueOf(this.bBI));
            this.mCurrentScale = this.bBI;
            this.bBK = this.mCurrentScale;
            Pe();
            return;
        }
        this.bBF = 0.0f;
        this.bBG = 0.0f;
        this.bBI = 1.0f;
        this.bBJ = 1.0f;
        this.mCurrentScale = 1.0f;
        this.bBK = this.mCurrentScale;
        this.bBH.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    private void OU() {
        if (this.bBP != null) {
            this.bBP.a(this, canZoomIn(), canZoomOut());
        }
    }

    public void setOnSizeChangedListener(f fVar) {
        this.bBP = fVar;
    }

    public byte[] getImageData() {
        return this.bBM;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getMeasuredHeight() != 0 && getMeasuredWidth() != 0 && this.bCf != null) {
            this.bCf.PV();
        }
    }

    public void a(Bitmap bitmap, byte[] bArr) {
        this.bBM = bArr;
        if (this.bCf != null) {
            this.bCf.b(bitmap, bArr);
        }
        setImageBitmap(bitmap);
    }

    public void OV() {
        if (this.bCf == null) {
            this.bCf = new com.baidu.tbadk.widget.a.b.b(this);
            this.bCf.setOnClickListener(this.bBQ);
            this.bCf.setOnLongClickListener(this.bkf);
        }
    }

    public void setImageLoadCallBack(com.baidu.tbadk.widget.a.b.a aVar) {
        if (this.bCf != null) {
            this.bCf.a(aVar);
        }
    }

    public boolean OW() {
        return (getImageBitmap() == null || this.bCf == null) ? false : true;
    }

    public Bitmap getGifCache() {
        return this.bBX;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        boolean z;
        if (this.bCf == null || !this.bCf.b(canvas, getImageBitmap())) {
            if (this.aWD == 2 && this.bCb != 0 && !this.bBR.Pi()) {
                int width = getWidth();
                int height = getHeight();
                Drawable drawable = getDrawable();
                float f2 = 0.0f;
                float f3 = height * 0.3f;
                float f4 = width;
                float f5 = (1.0f - 0.3f) * height;
                if (this.bCd && drawable != null) {
                    Rect bounds = drawable.getBounds();
                    int i = bounds.right - bounds.left;
                    int i2 = bounds.bottom - bounds.top;
                    f2 = (width / 2) - (i * 2.5f);
                    f3 = (height / 2) - (i2 * 2.5f);
                    f4 = (i * 2.5f) + (width / 2);
                    f5 = (i2 * 2.5f) + (height / 2);
                }
                this.mPaint.setColor(aj.getColor(this.bCb));
                canvas.drawRect(f2, f3, f4, f5, this.mPaint);
                this.mPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
            }
            if (this.mMode == 3 && this.bmS) {
                this.bmS = false;
                this.bmU.reset();
                if (this.bmT < bna) {
                    this.mMode = 0;
                } else {
                    this.mMode = 4;
                    IS();
                }
            }
            if (this.aWD == 0 && this.bmS && this.bmV != null && this.bCg != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                if (this.bmW == null) {
                    this.bmW = new RectF();
                }
                this.bmU.mapRect(this.bmW, new RectF(this.bmV));
                Bitmap imageBitmap = getImageBitmap();
                if (imageBitmap != null && !imageBitmap.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.bCi, this.bmW, (Paint) null);
                }
            } else if (this.mMode == 4 && this.bmV != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                Bitmap imageBitmap2 = getImageBitmap();
                if (imageBitmap2 != null && !imageBitmap2.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.bCi, this.bmW, (Paint) null);
                }
            } else {
                super.onDraw(canvas);
            }
            if (this.aWD == 1 && this.bBX != null && !this.bBX.isRecycled()) {
                int width2 = this.bBX.getWidth();
                int height2 = this.bBX.getHeight();
                int width3 = getWidth();
                int height3 = getHeight();
                int i3 = (width3 - width2) >> 1;
                int i4 = (height3 - height2) >> 1;
                float f6 = this.bCe;
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
                if (this.bBV == 1 && this.bBW != null && this.bCk != null && this.bCk.bCz != null) {
                    if (z) {
                        canvas.drawBitmap(this.bCk.bCz, i3, i4, (Paint) null);
                    } else {
                        canvas.drawBitmap(this.bCk.bCz, this.mMatrix, this.mPaint);
                    }
                    invalidate();
                } else if (z) {
                    canvas.drawBitmap(this.bBX, i3, i4, (Paint) null);
                } else {
                    canvas.drawBitmap(this.bBX, this.mMatrix, this.mPaint);
                }
            }
        }
    }

    public void play() {
        com.baidu.adp.widget.a.a aVar;
        if (this.aWD == 1) {
            if (this.bBW == null) {
                if (this.bCo != null) {
                    this.bCo.sx = false;
                    this.bCo.interrupt();
                    this.bCo = null;
                }
                if (this.bBM != null) {
                    try {
                        aVar = a.C0015a.lh().g(this.bBM, 0, this.bBM.length);
                    } catch (StackOverflowError e2) {
                        aVar = null;
                    }
                    if (aVar == null || aVar.getGif() == null) {
                        com.baidu.tbadk.core.d.a.a("gifplay", -1L, -1, "DragImageView.play", -1, "decode error", new Object[0]);
                        return;
                    }
                    this.bBW = aVar.getGif();
                    if (this.bBW != null) {
                        this.bBV = 1;
                        this.width = this.bBW.getWidth();
                        this.height = this.bBW.getHeight();
                        this.bCn = 0;
                        this.bCj = this.bBW.getFrameCount();
                    } else {
                        this.bBV = 0;
                    }
                } else {
                    return;
                }
            }
            if (this.bBW != null) {
                if (this.bCo == null || (this.bCo != null && !this.bCo.sx)) {
                    this.bCq = true;
                    this.bCo = new b();
                    this.bCl.clear();
                    this.bCm.clear();
                    this.bCo.sx = true;
                    this.bCo.start();
                }
            }
        }
    }

    public void pause() {
        if (this.aWD == 1) {
            if (this.bCo != null) {
                this.bCo.sx = false;
                this.bCo.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.aWD == 1) {
            if (this.bCo != null) {
                this.bCo.sx = false;
                this.bCo.interrupt();
                this.bCo = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.bCq = true;
            this.bCk = null;
            this.bCm.clear();
            this.bCl.clear();
            this.width = 0;
            this.height = 0;
            this.bCn = 0;
            this.bCj = 0;
            this.bBW = null;
        }
    }

    private void initData() {
        this.bCe = l.ar(getContext());
        this.bBN = l.aq(getContext()) * l.ao(getContext()) * 2;
        if (this.bBN < 1690000) {
            this.bBN = 1690000;
        }
        this.bBF = 0.0f;
        this.bBG = 0.0f;
        this.bBH = new ArrayList<>();
        this.bBI = 1.0f;
        this.bBJ = 1.0f;
        this.mCurrentScale = 1.0f;
        this.bBK = this.mCurrentScale;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.bBR = new C0092a();
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWillNotDraw(false);
        scrollTo(0, 0);
        this.mGestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.a.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                if (a.this.aWD != 2 && (Math.abs(f2) > 200.0f || Math.abs(f3) > 200.0f)) {
                    a.this.bBR.m(f2, f3);
                    a.this.startAnimation(a.this.bBR);
                }
                return super.onFling(motionEvent, motionEvent2, f2, f3);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (a.this.aWD != 1 && a.this.aWD != 2) {
                    a.this.mMode = 2;
                    if (a.this.mCurrentScale > a.this.bBI) {
                        a.this.mCurrentScale = a.this.bBI;
                        a.this.bBK = a.this.mCurrentScale;
                        a.this.Pe();
                        return true;
                    }
                    a.this.mCurrentScale = a.this.bBI * 2.0f;
                    a.this.d(true, (int) motionEvent.getX(), (int) motionEvent.getY());
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (a.this.bBQ != null && !a.this.bBT) {
                    a.this.bBQ.onClick(a.this);
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
                a.this.bBT = true;
                if (a.this.bBO == 0 && a.this.bBU) {
                    return false;
                }
                int scrollX = a.this.getScrollX();
                int scrollY = a.this.getScrollY();
                if (a.this.bBF >= a.this.getWidth()) {
                    scrollX = (int) (scrollX + f2);
                    if (a.this.bBO == 0) {
                        i = scrollX >= 0 ? scrollX : 0;
                        if (a.this.getWidth() + i > a.this.bBF) {
                            i = (int) (a.this.bBF - a.this.getWidth());
                        }
                        if (a.this.bBG + a.this.mTop + a.this.mBottom < a.this.getHeight()) {
                            i2 = (int) (scrollY + f3);
                            if (a.this.bBO == 0) {
                                if (i2 < (-a.this.bBY)) {
                                    i2 = -a.this.bBY;
                                }
                                if (a.this.getHeight() + i2 > a.this.bBG + a.this.mBottom + a.this.bBZ) {
                                    i2 = (int) ((a.this.bBG - a.this.getHeight()) + a.this.mBottom + a.this.bBZ);
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
                if (a.this.bBG + a.this.mTop + a.this.mBottom < a.this.getHeight()) {
                }
                if (i == a.this.getScrollX()) {
                }
                a.this.scrollTo(i, i2);
                a.this.invalidate();
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (a.this.bkf != null && !a.this.bBT) {
                    a.this.bkf.onLongClick(a.this);
                }
                super.onLongPress(motionEvent);
            }
        });
    }

    private void IS() {
        if (this.bCg == null) {
            if (this.bmZ != null) {
                this.bmZ.Pk();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.bCg.getSourceImageRectInScreen();
        if (sourceImageRectInScreen == null) {
            if (this.bmZ != null) {
                this.bmZ.Pk();
                return;
            }
            return;
        }
        this.bmW.bottom = (((sourceImageRectInScreen.bottom - sourceImageRectInScreen.top) / (sourceImageRectInScreen.right - sourceImageRectInScreen.left)) * (this.bmW.right - this.bmW.left)) + this.bmW.top;
        final float[] fArr = {(this.bmW.left + this.bmW.right) / 2.0f, (this.bmW.top + this.bmW.bottom) / 2.0f};
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
                    a.this.bmW = a.this.h(floatValue, animatedFraction, sourceImageRectInScreen.right - sourceImageRectInScreen.left, sourceImageRectInScreen.bottom - sourceImageRectInScreen.top);
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
                a.this.bmS = false;
                a.this.mMode = 4;
                a.this.invalidate();
                if (a.this.bmZ != null) {
                    a.this.bmZ.Pk();
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

    private void OX() {
        int i = 0;
        int scrollX = getScrollX();
        if (this.bBF >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.bBF) {
                scrollX = (int) (this.bBF - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.bBG + this.mTop + this.mBottom >= getHeight()) {
            i = scrollY < (-this.bBY) ? -this.bBY : scrollY;
            if (getHeight() + i > this.bBG + this.mBottom + this.bBZ) {
                i = (int) ((this.bBG - getHeight()) + this.mBottom + this.bBZ);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.bCf != null) {
            this.bCf.PU();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.bBF;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.bBG;
    }

    public boolean OY() {
        if (this.aWD == 1 || this.aWD == 2) {
            return true;
        }
        return !this.bBU && getScrollX() >= ((int) (this.bBF - ((float) getWidth()))) + (-1);
    }

    public boolean OZ() {
        if (this.aWD == 1 || this.aWD == 2) {
            return true;
        }
        return !this.bBU && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.bBR.Pi()) {
            this.bBR.stopAnimation();
        }
        this.bCb = 0;
        super.setImageBitmap(bitmap);
        OT();
        this.aWD = 0;
        if (this.bmV == null) {
            int measuredWidth = getMeasuredWidth();
            float measuredWidth2 = ((1.0f * getMeasuredWidth()) / bitmap.getWidth()) * bitmap.getHeight();
            if (measuredWidth2 > getMeasuredHeight()) {
                measuredWidth2 = getMeasuredHeight();
            }
            RectF h = h(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
            this.bmV = new Rect((int) h.left, (int) h.top, (int) h.right, (int) h.bottom);
        }
        if (this.bCi == null) {
            this.bCi = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
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
            if (this.bBR.Pi()) {
                this.bBR.stopAnimation();
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            super.setImageBitmap(bitmap);
            super.setImageMatrix(this.mMatrix);
            scrollTo(scrollX, scrollY);
            this.aWD = 0;
        }
    }

    public void a(byte[] bArr, Bitmap bitmap) {
        if (this.bBR.Pi()) {
            this.bBR.stopAnimation();
        }
        super.setImageDrawable(null);
        stop();
        OT();
        this.aWD = 1;
        this.bBX = bitmap;
        this.bBM = bArr;
        if (this.bki != null) {
            this.bki.a(this);
        }
    }

    public void onDestroy() {
        if (this.bBR.Pi()) {
            this.bBR.stopAnimation();
        }
        super.setImageDrawable(null);
        this.bBM = null;
        this.bBX = null;
        stop();
        if (this.bBW != null) {
            this.bBW.close();
            this.bBW = null;
        }
        if (this.bCf != null) {
            this.bCf.release();
            System.gc();
        }
    }

    public void release() {
        if (this.bBR.Pi()) {
            this.bBR.stopAnimation();
        }
        stop();
        super.setImageDrawable(null);
        this.bBX = null;
    }

    public void Pa() {
        if (this.bBR.Pi()) {
            this.bBR.stopAnimation();
        }
        try {
            if (this.bCd) {
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
        this.aWD = 2;
        OT();
    }

    public void Pb() {
        if (this.aWD != 1 && this.aWD != 2) {
            int size = this.bBH.size();
            if (size > 0) {
                this.bBH.add(Float.valueOf(this.bBH.get(size - 1).floatValue() * 1.25f));
            } else {
                this.bBH.add(Float.valueOf(this.bBI));
            }
            Pe();
        }
    }

    public void Pc() {
        if (this.aWD != 1 && this.aWD != 2) {
            int size = this.bBH.size();
            if (size > 1) {
                this.bBH.remove(size - 1);
            }
            Pe();
        }
    }

    public void Pd() {
        OU();
        if (this.aWD != 1 && this.aWD != 2 && this.mCurrentScale != this.bBI) {
            this.bBH.clear();
            this.bBH.add(Float.valueOf(this.bBI));
            this.mCurrentScale = this.bBI;
            this.bBK = this.mCurrentScale;
            Pe();
        }
    }

    public boolean canZoomIn() {
        if (this.aWD == 1 || this.aWD == 2) {
            return false;
        }
        int size = this.bBH.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.bBH.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.bBN) && floatValue <= 5.0f;
    }

    public boolean canZoomOut() {
        if (this.aWD == 1 || this.aWD == 2) {
            return false;
        }
        int size = this.bBH.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled()) {
            return false;
        }
        return size > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pe() {
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
                    int size = this.bBH.size();
                    if (size > 0) {
                        f3 = this.bBH.get(size - 1).floatValue();
                    } else {
                        f3 = this.bBI;
                    }
                    this.mCurrentScale = f3;
                }
                this.mMatrix.setScale(this.mCurrentScale, this.mCurrentScale);
                this.bBF = imageBitmap.getWidth() * this.mCurrentScale;
                this.bBG = imageBitmap.getHeight() * this.mCurrentScale;
                float width = this.bBK * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.bBK;
                this.bBY = this.mTop;
                this.bBZ = 0;
                float f4 = this.bBF < ((float) this.mViewWidth) ? (int) ((this.mViewWidth - this.bBF) / 2.0f) : 0.0f;
                if (this.bBG < this.mViewHeight) {
                    f2 = (int) ((this.mViewHeight - this.bBG) / 2.0f);
                    if (this.bBO == 1 && f2 > this.mTop) {
                        f2 = this.mTop;
                    }
                    this.bBY = (int) (this.mTop - f2);
                    this.bBZ = this.mTop - this.bBY;
                } else {
                    f2 = 0.0f;
                }
                this.bCa = (int) f4;
                this.mMatrix.postTranslate(f4, f2);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    int width2 = i > getWidth() ? getWidth() : i;
                    if (this.bBF <= screenWidth) {
                        width2 = 0;
                    } else if (this.bBF > screenWidth && this.bBF / 2.0f < screenWidth) {
                        width2 = (int) (width2 - (this.bBF / 4.0f));
                    }
                    scrollX = width2;
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.bBF - width) / 2.0f);
                    }
                    if (this.bBF <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.bBF) {
                        scrollX = (int) (this.bBF - getWidth());
                    }
                }
                if (scrollX > 0 && this.bBF - scrollX < getWidth()) {
                    scrollX = (int) (this.bBF - getWidth());
                }
                int i3 = this.mMode == 2 ? ((int) ((this.bBG - height) / 2.0f)) + scrollY : scrollY;
                if (this.bBG <= getHeight()) {
                    i3 = 0;
                } else if (getHeight() + i3 > this.bBG) {
                    i3 = (int) (this.bBG - getHeight());
                }
                setHorizontalScrollBarEnabled(false);
                setVerticalScrollBarEnabled(false);
                if (scrollX < 0) {
                    scrollX = 0;
                }
                scrollTo(scrollX, i3 >= 0 ? i3 : 0);
                setImageMatrix(this.mMatrix);
                OU();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0092a extends Animation {
        private boolean bCs = false;
        private boolean bCt = false;
        private long bCu;
        private long bCv;
        private int bCw;
        private long bCx;
        private long bCy;
        private int mStartY;

        public C0092a() {
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
            this.bCu = f;
            this.bCv = f2;
            this.bCx = Math.abs((f * 1000.0f) / 2500.0f);
            this.bCy = Math.abs((f2 * 1000.0f) / 2500.0f);
            setDuration(Math.max(this.bCx, this.bCy));
            setInterpolator(a.this.bCh);
            this.bCw = a.this.getScrollX();
            this.mStartY = a.this.getScrollY();
            this.bCs = true;
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
            if (this.bCx > this.bCy) {
                j = ((float) this.bCx) * f;
            } else {
                j = ((float) this.bCy) * f;
            }
            float f2 = ((float) (j > this.bCx ? this.bCx : j)) / 1000.0f;
            if (this.bCu > 0) {
                i = this.bCw - ((int) (f2 * (((float) this.bCu) - ((2500.0f * f2) / 2.0f))));
            } else {
                i = this.bCw - ((int) (f2 * (((float) this.bCu) + ((2500.0f * f2) / 2.0f))));
            }
            if (j > this.bCy) {
                j = this.bCy;
            }
            float f3 = ((float) j) / 1000.0f;
            if (this.bCv > 0) {
                i2 = this.mStartY - ((int) (f3 * (((float) this.bCv) - ((2500.0f * f3) / 2.0f))));
            } else {
                i2 = this.mStartY - ((int) (f3 * (((float) this.bCv) + ((2500.0f * f3) / 2.0f))));
            }
            if (a.this.bBG + a.this.mTop + a.this.mBottom > a.this.getHeight()) {
                if (i2 < (-a.this.bBY)) {
                    i2 = -a.this.bBY;
                }
                if (a.this.getHeight() + i2 > a.this.bBG + a.this.mBottom + a.this.bBZ) {
                    i2 = (int) ((a.this.bBG - a.this.getHeight()) + a.this.mBottom + a.this.bBZ);
                }
            } else {
                i2 = 0;
            }
            if (a.this.bBF > a.this.getWidth()) {
                int width = ((float) (a.this.getWidth() + i)) > a.this.bBF ? (int) (a.this.bBF - a.this.getWidth()) : i;
                if (width >= 0) {
                    i3 = width;
                }
            }
            a.this.scrollTo(i3, i2);
            a.this.invalidate();
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            if (!this.bCt) {
                if (a.this.bBL) {
                    this.bCs = false;
                    return false;
                }
                try {
                    if (super.getTransformation(j, transformation)) {
                        return true;
                    }
                    this.bCs = false;
                    return false;
                } catch (Exception e) {
                    this.bCs = false;
                    return false;
                }
            }
            this.bCt = false;
            this.bCs = false;
            return false;
        }

        public boolean Pi() {
            return this.bCs;
        }

        public void stopAnimation() {
            this.bCt = true;
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.bBQ = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bkf = onLongClickListener;
        if (this.bCf != null) {
            this.bCf.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setGifSetListener(e eVar) {
        this.bki = eVar;
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
    public void Pf() {
        long j;
        c poll = this.bCl.poll();
        if (poll == null) {
            this.bCq = true;
            return;
        }
        this.bCq = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.bCk != null) {
            j = this.bCk.delay - (currentTimeMillis - this.bCp);
            this.bCm.offer(this.bCk);
        } else {
            j = 0;
        }
        this.bCk = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public c Pg() {
        c poll = this.bCm.poll();
        if (poll == null) {
            poll = new c();
            try {
                poll.bCz = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
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
        return this.bCk;
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
            while (this.sx && a.this.bBW != null && a.this.bCj > 0 && a.this.width > 0 && a.this.height > 0) {
                try {
                    a.this.bBW.cM(a.this.bCn);
                    c Pg = a.this.Pg();
                    if (Pg.bCz == null || (Pg.bCz.getWidth() != a.this.width && Pg.bCz.getHeight() != a.this.height)) {
                        try {
                            Pg.bCz = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_8888);
                        } catch (OutOfMemoryError e) {
                            TbadkCoreApplication.getInst().onAppMemoryLow();
                            try {
                                Pg.bCz = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_4444);
                            } catch (OutOfMemoryError e2) {
                                TbadkCoreApplication.getInst().onAppMemoryLow();
                            } catch (Throwable th) {
                                BdLog.e(th.getMessage());
                            }
                        } catch (Throwable th2) {
                            BdLog.e(th2.getMessage());
                        }
                    }
                    a.this.bBW.a(Pg.bCz, null);
                    Pg.delay = a.this.bBW.cN(a.this.bCn);
                    a.A(a.this);
                    if (Pg.bCz == null) {
                        a.A(a.this);
                    }
                    a.this.bCn %= a.this.bCj;
                    a.this.bCl.put(Pg);
                    if (a.this.bCq) {
                        a.this.mHandler.sendEmptyMessage(1);
                    }
                } catch (Exception e3) {
                    return;
                }
            }
        }
    }

    public boolean Ph() {
        return this.bCc;
    }

    public void setLoadBigImage(boolean z) {
        this.bCc = z;
    }

    public int getBottomOffset() {
        return this.bBZ;
    }

    public int getLeftOffset() {
        return this.bCa;
    }
}
