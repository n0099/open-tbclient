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
    private static final int bmJ = l.aq(TbadkCoreApplication.getInst()) / 5;
    public int aWB;
    private C0092a bBA;
    private float bBB;
    private boolean bBC;
    private boolean bBD;
    private int bBE;
    private volatile com.baidu.adp.gif.b bBF;
    private Bitmap bBG;
    private int bBH;
    private int bBI;
    private int bBJ;
    private int bBK;
    private boolean bBL;
    private boolean bBM;
    private float bBN;
    private com.baidu.tbadk.widget.a.b.b bBO;
    private ImageUrlData bBP;
    private Interpolator bBQ;
    private Rect bBR;
    private int bBS;
    private c bBT;
    private BlockingLinkedDeque<c> bBU;
    private BlockingLinkedDeque<c> bBV;
    private volatile int bBW;
    private b bBX;
    private volatile long bBY;
    private volatile boolean bBZ;
    private float bBo;
    private float bBp;
    private ArrayList<Float> bBq;
    private float bBr;
    private float bBs;
    private float bBt;
    private boolean bBu;
    private byte[] bBv;
    private int bBw;
    private int bBx;
    private f bBy;
    private View.OnClickListener bBz;
    private View.OnLongClickListener bjN;
    private e bjQ;
    private int bjR;
    private boolean bmB;
    private float bmC;
    private Matrix bmD;
    private Rect bmE;
    private RectF bmF;
    private d bmI;
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
        public Bitmap bCi;
        public int delay;
    }

    /* loaded from: classes.dex */
    public interface d {
        void Pt();

        void Pu();
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
        int i = aVar.bBW;
        aVar.bBW = i + 1;
        return i;
    }

    public void setIsHeadImage(boolean z) {
        this.bBM = z;
    }

    public void setImageUrlData(ImageUrlData imageUrlData) {
        this.bBP = imageUrlData;
    }

    public a(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.bBu = false;
        this.bBv = null;
        this.bjR = 0;
        this.bBw = 1300;
        this.bBx = 0;
        this.bBy = null;
        this.bBz = null;
        this.bjN = null;
        this.bjQ = null;
        this.bBB = 1.0f;
        this.aWB = 0;
        this.mMode = 0;
        this.bBC = false;
        this.bBD = false;
        this.bBE = 0;
        this.bBF = null;
        this.bBG = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.bBH = 0;
        this.bBI = 0;
        this.bBJ = 0;
        this.bBK = 0;
        this.bBQ = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.bmD = new Matrix();
        this.bmB = false;
        this.mRatio = 1.0f;
        this.bmC = 0.0f;
        this.bmF = new RectF();
        this.width = 0;
        this.height = 0;
        this.bBS = 0;
        this.bBT = null;
        this.bBU = new BlockingLinkedDeque<>(5);
        this.bBV = new BlockingLinkedDeque<>(6);
        this.bBW = 0;
        this.bBY = 0L;
        this.bBZ = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.a.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        a.this.Pp();
                        break;
                    case 1:
                        if (a.this.bBZ) {
                            a.this.Pp();
                            break;
                        }
                        break;
                    case 2:
                        a.this.invalidate();
                        a.this.bBY = System.currentTimeMillis();
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
        this.bBu = false;
        this.bBv = null;
        this.bjR = 0;
        this.bBw = 1300;
        this.bBx = 0;
        this.bBy = null;
        this.bBz = null;
        this.bjN = null;
        this.bjQ = null;
        this.bBB = 1.0f;
        this.aWB = 0;
        this.mMode = 0;
        this.bBC = false;
        this.bBD = false;
        this.bBE = 0;
        this.bBF = null;
        this.bBG = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.bBH = 0;
        this.bBI = 0;
        this.bBJ = 0;
        this.bBK = 0;
        this.bBQ = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.bmD = new Matrix();
        this.bmB = false;
        this.mRatio = 1.0f;
        this.bmC = 0.0f;
        this.bmF = new RectF();
        this.width = 0;
        this.height = 0;
        this.bBS = 0;
        this.bBT = null;
        this.bBU = new BlockingLinkedDeque<>(5);
        this.bBV = new BlockingLinkedDeque<>(6);
        this.bBW = 0;
        this.bBY = 0L;
        this.bBZ = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.a.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        a.this.Pp();
                        break;
                    case 1:
                        if (a.this.bBZ) {
                            a.this.Pp();
                            break;
                        }
                        break;
                    case 2:
                        a.this.invalidate();
                        a.this.bBY = System.currentTimeMillis();
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
        this.bBu = false;
        this.bBv = null;
        this.bjR = 0;
        this.bBw = 1300;
        this.bBx = 0;
        this.bBy = null;
        this.bBz = null;
        this.bjN = null;
        this.bjQ = null;
        this.bBB = 1.0f;
        this.aWB = 0;
        this.mMode = 0;
        this.bBC = false;
        this.bBD = false;
        this.bBE = 0;
        this.bBF = null;
        this.bBG = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.bBH = 0;
        this.bBI = 0;
        this.bBJ = 0;
        this.bBK = 0;
        this.bBQ = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.bmD = new Matrix();
        this.bmB = false;
        this.mRatio = 1.0f;
        this.bmC = 0.0f;
        this.bmF = new RectF();
        this.width = 0;
        this.height = 0;
        this.bBS = 0;
        this.bBT = null;
        this.bBU = new BlockingLinkedDeque<>(5);
        this.bBV = new BlockingLinkedDeque<>(6);
        this.bBW = 0;
        this.bBY = 0L;
        this.bBZ = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.a.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        a.this.Pp();
                        break;
                    case 1:
                        if (a.this.bBZ) {
                            a.this.Pp();
                            break;
                        }
                        break;
                    case 2:
                        a.this.invalidate();
                        a.this.bBY = System.currentTimeMillis();
                        a.this.mHandler.sendEmptyMessage(0);
                        break;
                }
                return false;
            }
        });
        initData();
    }

    public void setDragToExitListener(d dVar) {
        this.bmI = dVar;
    }

    public int getImageType() {
        return this.aWB;
    }

    public void setImageMode(int i) {
        this.bBx = i;
    }

    public void q(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.bjR = i;
    }

    public boolean Pa() {
        if (this.bBO != null) {
            return this.bBO.Pa();
        }
        return false;
    }

    public void Pb() {
        this.bBD = false;
        this.bBu = false;
        this.mMode = 3;
        Ph();
        if (this.mCurrentScale < this.bBr) {
            this.mCurrentScale = this.bBr;
            Po();
        }
        invalidate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.bBO != null && this.bBO.onTouchEvent(motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.bBu = true;
                this.bBC = false;
                this.bBD = false;
                break;
            case 1:
                Pb();
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
            this.bBB = v(motionEvent);
            if (this.bBB > 10.0f) {
                this.mMode = 2;
            }
        }
        if (this.mMode == 2 || !this.mGestureDetector.onTouchEvent(motionEvent)) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.bBC = true;
                        this.bBD = true;
                        if (this.aWB != 1 && this.aWB != 2) {
                            float v = v(motionEvent);
                            if (v >= 0.0f && Math.abs(this.bBB - v) >= 10.0f) {
                                if (Math.abs(this.bBB - v) > 100.0f) {
                                    this.bBB = v;
                                    break;
                                } else {
                                    float f2 = v / this.bBB;
                                    this.bBB = v;
                                    this.bBt = this.mCurrentScale;
                                    this.mCurrentScale *= f2;
                                    if (this.mCurrentScale > this.bBs) {
                                        this.mCurrentScale = this.bBs;
                                    }
                                    float minScaleValue = getMinScaleValue();
                                    if (this.mCurrentScale < minScaleValue) {
                                        this.mCurrentScale = minScaleValue;
                                    }
                                    Po();
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
        return this.bBO != null ? this.bBO.getMinScaleValue() : this.bBr / 4.0f;
    }

    public float v(MotionEvent motionEvent) {
        return CompatibleUtile.getInstance().getSpacing(motionEvent);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            this.mViewWidth = i3 - i;
            this.mViewHeight = i4 - i2;
            Pd();
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public boolean Pc() {
        if (this.bBO != null) {
            return this.bBO.Qd();
        }
        return this.bBr == this.mCurrentScale;
    }

    protected float i(Bitmap bitmap) {
        if (this.bBO != null) {
            return this.bBO.Qh();
        }
        if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            return 1.0f;
        }
        if (this.bBx == 0) {
            float width = this.mViewWidth / bitmap.getWidth();
            float height = this.mViewHeight / bitmap.getHeight();
            if (this.bBM) {
                if (this.aWB == 2) {
                    return 2.5f;
                }
                return Math.min(width, height);
            } else if (this.aWB != 2) {
                float f2 = this.bBN;
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
        if (this.bBO != null) {
            return this.bBO.Qi();
        }
        float f2 = 1.0f;
        if (bitmap != null && !bitmap.isRecycled() && bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
            f2 = (float) Math.sqrt(this.bBw / (bitmap.getWidth() * bitmap.getHeight()));
            if (f2 > 10.0f) {
                return 10.0f;
            }
        }
        return f2;
    }

    private void Pd() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            this.bBr = i(imageBitmap);
            this.bBs = j(imageBitmap);
            this.bBq.clear();
            this.bBq.add(Float.valueOf(this.bBr));
            this.mCurrentScale = this.bBr;
            this.bBt = this.mCurrentScale;
            Po();
            return;
        }
        this.bBo = 0.0f;
        this.bBp = 0.0f;
        this.bBr = 1.0f;
        this.bBs = 1.0f;
        this.mCurrentScale = 1.0f;
        this.bBt = this.mCurrentScale;
        this.bBq.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    private void Pe() {
        if (this.bBy != null) {
            this.bBy.a(this, canZoomIn(), canZoomOut());
        }
    }

    public void setOnSizeChangedListener(f fVar) {
        this.bBy = fVar;
    }

    public byte[] getImageData() {
        return this.bBv;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getMeasuredHeight() != 0 && getMeasuredWidth() != 0 && this.bBO != null) {
            this.bBO.Qf();
        }
    }

    public void a(Bitmap bitmap, byte[] bArr) {
        this.bBv = bArr;
        if (this.bBO != null) {
            this.bBO.b(bitmap, bArr);
        }
        setImageBitmap(bitmap);
    }

    public void Pf() {
        if (this.bBO == null) {
            this.bBO = new com.baidu.tbadk.widget.a.b.b(this);
            this.bBO.setOnClickListener(this.bBz);
            this.bBO.setOnLongClickListener(this.bjN);
        }
    }

    public void setImageLoadCallBack(com.baidu.tbadk.widget.a.b.a aVar) {
        if (this.bBO != null) {
            this.bBO.a(aVar);
        }
    }

    public boolean Pg() {
        return (getImageBitmap() == null || this.bBO == null) ? false : true;
    }

    public Bitmap getGifCache() {
        return this.bBG;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        boolean z;
        if (this.bBO == null || !this.bBO.b(canvas, getImageBitmap())) {
            if (this.aWB == 2 && this.bBK != 0 && !this.bBA.Ps()) {
                int width = getWidth();
                int height = getHeight();
                Drawable drawable = getDrawable();
                float f2 = 0.0f;
                float f3 = height * 0.3f;
                float f4 = width;
                float f5 = (1.0f - 0.3f) * height;
                if (this.bBM && drawable != null) {
                    Rect bounds = drawable.getBounds();
                    int i = bounds.right - bounds.left;
                    int i2 = bounds.bottom - bounds.top;
                    f2 = (width / 2) - (i * 2.5f);
                    f3 = (height / 2) - (i2 * 2.5f);
                    f4 = (i * 2.5f) + (width / 2);
                    f5 = (i2 * 2.5f) + (height / 2);
                }
                this.mPaint.setColor(aj.getColor(this.bBK));
                canvas.drawRect(f2, f3, f4, f5, this.mPaint);
                this.mPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
            }
            if (this.mMode == 3 && this.bmB) {
                this.bmB = false;
                this.bmD.reset();
                if (this.bmC < bmJ) {
                    this.mMode = 0;
                } else {
                    this.mMode = 4;
                    Jb();
                }
            }
            if (this.aWB == 0 && this.bmB && this.bmE != null && this.bBP != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                if (this.bmF == null) {
                    this.bmF = new RectF();
                }
                this.bmD.mapRect(this.bmF, new RectF(this.bmE));
                Bitmap imageBitmap = getImageBitmap();
                if (imageBitmap != null && !imageBitmap.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.bBR, this.bmF, (Paint) null);
                }
            } else if (this.mMode == 4 && this.bmE != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                Bitmap imageBitmap2 = getImageBitmap();
                if (imageBitmap2 != null && !imageBitmap2.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.bBR, this.bmF, (Paint) null);
                }
            } else {
                super.onDraw(canvas);
            }
            if (this.aWB == 1 && this.bBG != null && !this.bBG.isRecycled()) {
                int width2 = this.bBG.getWidth();
                int height2 = this.bBG.getHeight();
                int width3 = getWidth();
                int height3 = getHeight();
                int i3 = (width3 - width2) >> 1;
                int i4 = (height3 - height2) >> 1;
                float f6 = this.bBN;
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
                if (this.bBE == 1 && this.bBF != null && this.bBT != null && this.bBT.bCi != null) {
                    if (z) {
                        canvas.drawBitmap(this.bBT.bCi, i3, i4, (Paint) null);
                    } else {
                        canvas.drawBitmap(this.bBT.bCi, this.mMatrix, this.mPaint);
                    }
                    invalidate();
                } else if (z) {
                    canvas.drawBitmap(this.bBG, i3, i4, (Paint) null);
                } else {
                    canvas.drawBitmap(this.bBG, this.mMatrix, this.mPaint);
                }
            }
        }
    }

    public void play() {
        com.baidu.adp.widget.a.a aVar;
        if (this.aWB == 1) {
            if (this.bBF == null) {
                if (this.bBX != null) {
                    this.bBX.sx = false;
                    this.bBX.interrupt();
                    this.bBX = null;
                }
                if (this.bBv != null) {
                    try {
                        aVar = a.C0015a.lh().g(this.bBv, 0, this.bBv.length);
                    } catch (StackOverflowError e2) {
                        aVar = null;
                    }
                    if (aVar == null || aVar.getGif() == null) {
                        com.baidu.tbadk.core.d.a.a("gifplay", -1L, -1, "DragImageView.play", -1, "decode error", new Object[0]);
                        return;
                    }
                    this.bBF = aVar.getGif();
                    if (this.bBF != null) {
                        this.bBE = 1;
                        this.width = this.bBF.getWidth();
                        this.height = this.bBF.getHeight();
                        this.bBW = 0;
                        this.bBS = this.bBF.getFrameCount();
                    } else {
                        this.bBE = 0;
                    }
                } else {
                    return;
                }
            }
            if (this.bBF != null) {
                if (this.bBX == null || (this.bBX != null && !this.bBX.sx)) {
                    this.bBZ = true;
                    this.bBX = new b();
                    this.bBU.clear();
                    this.bBV.clear();
                    this.bBX.sx = true;
                    this.bBX.start();
                }
            }
        }
    }

    public void pause() {
        if (this.aWB == 1) {
            if (this.bBX != null) {
                this.bBX.sx = false;
                this.bBX.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.aWB == 1) {
            if (this.bBX != null) {
                this.bBX.sx = false;
                this.bBX.interrupt();
                this.bBX = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.bBZ = true;
            this.bBT = null;
            this.bBV.clear();
            this.bBU.clear();
            this.width = 0;
            this.height = 0;
            this.bBW = 0;
            this.bBS = 0;
            this.bBF = null;
        }
    }

    private void initData() {
        this.bBN = l.ar(getContext());
        this.bBw = l.aq(getContext()) * l.ao(getContext()) * 2;
        if (this.bBw < 1690000) {
            this.bBw = 1690000;
        }
        this.bBo = 0.0f;
        this.bBp = 0.0f;
        this.bBq = new ArrayList<>();
        this.bBr = 1.0f;
        this.bBs = 1.0f;
        this.mCurrentScale = 1.0f;
        this.bBt = this.mCurrentScale;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.bBA = new C0092a();
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWillNotDraw(false);
        scrollTo(0, 0);
        this.mGestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.a.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                if (a.this.aWB != 2 && (Math.abs(f2) > 200.0f || Math.abs(f3) > 200.0f)) {
                    a.this.bBA.m(f2, f3);
                    a.this.startAnimation(a.this.bBA);
                }
                return super.onFling(motionEvent, motionEvent2, f2, f3);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (a.this.aWB != 1 && a.this.aWB != 2) {
                    a.this.mMode = 2;
                    if (a.this.mCurrentScale > a.this.bBr) {
                        a.this.mCurrentScale = a.this.bBr;
                        a.this.bBt = a.this.mCurrentScale;
                        a.this.Po();
                        return true;
                    }
                    a.this.mCurrentScale = a.this.bBr * 2.0f;
                    a.this.d(true, (int) motionEvent.getX(), (int) motionEvent.getY());
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (a.this.bBz != null && !a.this.bBC) {
                    a.this.bBz.onClick(a.this);
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
                a.this.bBC = true;
                if (a.this.bBx == 0 && a.this.bBD) {
                    return false;
                }
                int scrollX = a.this.getScrollX();
                int scrollY = a.this.getScrollY();
                if (a.this.bBo >= a.this.getWidth()) {
                    scrollX = (int) (scrollX + f2);
                    if (a.this.bBx == 0) {
                        i = scrollX >= 0 ? scrollX : 0;
                        if (a.this.getWidth() + i > a.this.bBo) {
                            i = (int) (a.this.bBo - a.this.getWidth());
                        }
                        if (a.this.bBp + a.this.mTop + a.this.mBottom < a.this.getHeight()) {
                            i2 = (int) (scrollY + f3);
                            if (a.this.bBx == 0) {
                                if (i2 < (-a.this.bBH)) {
                                    i2 = -a.this.bBH;
                                }
                                if (a.this.getHeight() + i2 > a.this.bBp + a.this.mBottom + a.this.bBI) {
                                    i2 = (int) ((a.this.bBp - a.this.getHeight()) + a.this.mBottom + a.this.bBI);
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
                if (a.this.bBp + a.this.mTop + a.this.mBottom < a.this.getHeight()) {
                }
                if (i == a.this.getScrollX()) {
                }
                a.this.scrollTo(i, i2);
                a.this.invalidate();
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (a.this.bjN != null && !a.this.bBC) {
                    a.this.bjN.onLongClick(a.this);
                }
                super.onLongPress(motionEvent);
            }
        });
    }

    private void Jb() {
        if (this.bBP == null) {
            if (this.bmI != null) {
                this.bmI.Pu();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.bBP.getSourceImageRectInScreen();
        if (sourceImageRectInScreen == null) {
            if (this.bmI != null) {
                this.bmI.Pu();
                return;
            }
            return;
        }
        this.bmF.bottom = (((sourceImageRectInScreen.bottom - sourceImageRectInScreen.top) / (sourceImageRectInScreen.right - sourceImageRectInScreen.left)) * (this.bmF.right - this.bmF.left)) + this.bmF.top;
        final float[] fArr = {(this.bmF.left + this.bmF.right) / 2.0f, (this.bmF.top + this.bmF.bottom) / 2.0f};
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
                    a.this.bmF = a.this.h(floatValue, animatedFraction, sourceImageRectInScreen.right - sourceImageRectInScreen.left, sourceImageRectInScreen.bottom - sourceImageRectInScreen.top);
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
                a.this.bmB = false;
                a.this.mMode = 4;
                a.this.invalidate();
                if (a.this.bmI != null) {
                    a.this.bmI.Pu();
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

    private void Ph() {
        int i = 0;
        int scrollX = getScrollX();
        if (this.bBo >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.bBo) {
                scrollX = (int) (this.bBo - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.bBp + this.mTop + this.mBottom >= getHeight()) {
            i = scrollY < (-this.bBH) ? -this.bBH : scrollY;
            if (getHeight() + i > this.bBp + this.mBottom + this.bBI) {
                i = (int) ((this.bBp - getHeight()) + this.mBottom + this.bBI);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.bBO != null) {
            this.bBO.Qe();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.bBo;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.bBp;
    }

    public boolean Pi() {
        if (this.aWB == 1 || this.aWB == 2) {
            return true;
        }
        return !this.bBD && getScrollX() >= ((int) (this.bBo - ((float) getWidth()))) + (-1);
    }

    public boolean Pj() {
        if (this.aWB == 1 || this.aWB == 2) {
            return true;
        }
        return !this.bBD && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.bBA.Ps()) {
            this.bBA.stopAnimation();
        }
        this.bBK = 0;
        super.setImageBitmap(bitmap);
        Pd();
        this.aWB = 0;
        if (this.bmE == null) {
            int measuredWidth = getMeasuredWidth();
            float measuredWidth2 = ((1.0f * getMeasuredWidth()) / bitmap.getWidth()) * bitmap.getHeight();
            if (measuredWidth2 > getMeasuredHeight()) {
                measuredWidth2 = getMeasuredHeight();
            }
            RectF h = h(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
            this.bmE = new Rect((int) h.left, (int) h.top, (int) h.right, (int) h.bottom);
        }
        if (this.bBR == null) {
            this.bBR = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
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
            if (this.bBA.Ps()) {
                this.bBA.stopAnimation();
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            super.setImageBitmap(bitmap);
            super.setImageMatrix(this.mMatrix);
            scrollTo(scrollX, scrollY);
            this.aWB = 0;
        }
    }

    public void a(byte[] bArr, Bitmap bitmap) {
        if (this.bBA.Ps()) {
            this.bBA.stopAnimation();
        }
        super.setImageDrawable(null);
        stop();
        Pd();
        this.aWB = 1;
        this.bBG = bitmap;
        this.bBv = bArr;
        if (this.bjQ != null) {
            this.bjQ.a(this);
        }
    }

    public void onDestroy() {
        if (this.bBA.Ps()) {
            this.bBA.stopAnimation();
        }
        super.setImageDrawable(null);
        this.bBv = null;
        this.bBG = null;
        stop();
        if (this.bBF != null) {
            this.bBF.close();
            this.bBF = null;
        }
        if (this.bBO != null) {
            this.bBO.release();
            System.gc();
        }
    }

    public void release() {
        if (this.bBA.Ps()) {
            this.bBA.stopAnimation();
        }
        stop();
        super.setImageDrawable(null);
        this.bBG = null;
    }

    public void Pk() {
        if (this.bBA.Ps()) {
            this.bBA.stopAnimation();
        }
        try {
            if (this.bBM) {
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
        this.aWB = 2;
        Pd();
    }

    public void Pl() {
        if (this.aWB != 1 && this.aWB != 2) {
            int size = this.bBq.size();
            if (size > 0) {
                this.bBq.add(Float.valueOf(this.bBq.get(size - 1).floatValue() * 1.25f));
            } else {
                this.bBq.add(Float.valueOf(this.bBr));
            }
            Po();
        }
    }

    public void Pm() {
        if (this.aWB != 1 && this.aWB != 2) {
            int size = this.bBq.size();
            if (size > 1) {
                this.bBq.remove(size - 1);
            }
            Po();
        }
    }

    public void Pn() {
        Pe();
        if (this.aWB != 1 && this.aWB != 2 && this.mCurrentScale != this.bBr) {
            this.bBq.clear();
            this.bBq.add(Float.valueOf(this.bBr));
            this.mCurrentScale = this.bBr;
            this.bBt = this.mCurrentScale;
            Po();
        }
    }

    public boolean canZoomIn() {
        if (this.aWB == 1 || this.aWB == 2) {
            return false;
        }
        int size = this.bBq.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.bBq.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.bBw) && floatValue <= 5.0f;
    }

    public boolean canZoomOut() {
        if (this.aWB == 1 || this.aWB == 2) {
            return false;
        }
        int size = this.bBq.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled()) {
            return false;
        }
        return size > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Po() {
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
                    int size = this.bBq.size();
                    if (size > 0) {
                        f3 = this.bBq.get(size - 1).floatValue();
                    } else {
                        f3 = this.bBr;
                    }
                    this.mCurrentScale = f3;
                }
                this.mMatrix.setScale(this.mCurrentScale, this.mCurrentScale);
                this.bBo = imageBitmap.getWidth() * this.mCurrentScale;
                this.bBp = imageBitmap.getHeight() * this.mCurrentScale;
                float width = this.bBt * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.bBt;
                this.bBH = this.mTop;
                this.bBI = 0;
                float f4 = this.bBo < ((float) this.mViewWidth) ? (int) ((this.mViewWidth - this.bBo) / 2.0f) : 0.0f;
                if (this.bBp < this.mViewHeight) {
                    f2 = (int) ((this.mViewHeight - this.bBp) / 2.0f);
                    if (this.bBx == 1 && f2 > this.mTop) {
                        f2 = this.mTop;
                    }
                    this.bBH = (int) (this.mTop - f2);
                    this.bBI = this.mTop - this.bBH;
                } else {
                    f2 = 0.0f;
                }
                this.bBJ = (int) f4;
                this.mMatrix.postTranslate(f4, f2);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    int width2 = i > getWidth() ? getWidth() : i;
                    if (this.bBo <= screenWidth) {
                        width2 = 0;
                    } else if (this.bBo > screenWidth && this.bBo / 2.0f < screenWidth) {
                        width2 = (int) (width2 - (this.bBo / 4.0f));
                    }
                    scrollX = width2;
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.bBo - width) / 2.0f);
                    }
                    if (this.bBo <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.bBo) {
                        scrollX = (int) (this.bBo - getWidth());
                    }
                }
                if (scrollX > 0 && this.bBo - scrollX < getWidth()) {
                    scrollX = (int) (this.bBo - getWidth());
                }
                int i3 = this.mMode == 2 ? ((int) ((this.bBp - height) / 2.0f)) + scrollY : scrollY;
                if (this.bBp <= getHeight()) {
                    i3 = 0;
                } else if (getHeight() + i3 > this.bBp) {
                    i3 = (int) (this.bBp - getHeight());
                }
                setHorizontalScrollBarEnabled(false);
                setVerticalScrollBarEnabled(false);
                if (scrollX < 0) {
                    scrollX = 0;
                }
                scrollTo(scrollX, i3 >= 0 ? i3 : 0);
                setImageMatrix(this.mMatrix);
                Pe();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0092a extends Animation {
        private boolean bCb = false;
        private boolean bCc = false;
        private long bCd;
        private long bCe;
        private int bCf;
        private long bCg;
        private long bCh;
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
            this.bCd = f;
            this.bCe = f2;
            this.bCg = Math.abs((f * 1000.0f) / 2500.0f);
            this.bCh = Math.abs((f2 * 1000.0f) / 2500.0f);
            setDuration(Math.max(this.bCg, this.bCh));
            setInterpolator(a.this.bBQ);
            this.bCf = a.this.getScrollX();
            this.mStartY = a.this.getScrollY();
            this.bCb = true;
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
            if (this.bCg > this.bCh) {
                j = ((float) this.bCg) * f;
            } else {
                j = ((float) this.bCh) * f;
            }
            float f2 = ((float) (j > this.bCg ? this.bCg : j)) / 1000.0f;
            if (this.bCd > 0) {
                i = this.bCf - ((int) (f2 * (((float) this.bCd) - ((2500.0f * f2) / 2.0f))));
            } else {
                i = this.bCf - ((int) (f2 * (((float) this.bCd) + ((2500.0f * f2) / 2.0f))));
            }
            if (j > this.bCh) {
                j = this.bCh;
            }
            float f3 = ((float) j) / 1000.0f;
            if (this.bCe > 0) {
                i2 = this.mStartY - ((int) (f3 * (((float) this.bCe) - ((2500.0f * f3) / 2.0f))));
            } else {
                i2 = this.mStartY - ((int) (f3 * (((float) this.bCe) + ((2500.0f * f3) / 2.0f))));
            }
            if (a.this.bBp + a.this.mTop + a.this.mBottom > a.this.getHeight()) {
                if (i2 < (-a.this.bBH)) {
                    i2 = -a.this.bBH;
                }
                if (a.this.getHeight() + i2 > a.this.bBp + a.this.mBottom + a.this.bBI) {
                    i2 = (int) ((a.this.bBp - a.this.getHeight()) + a.this.mBottom + a.this.bBI);
                }
            } else {
                i2 = 0;
            }
            if (a.this.bBo > a.this.getWidth()) {
                int width = ((float) (a.this.getWidth() + i)) > a.this.bBo ? (int) (a.this.bBo - a.this.getWidth()) : i;
                if (width >= 0) {
                    i3 = width;
                }
            }
            a.this.scrollTo(i3, i2);
            a.this.invalidate();
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            if (!this.bCc) {
                if (a.this.bBu) {
                    this.bCb = false;
                    return false;
                }
                try {
                    if (super.getTransformation(j, transformation)) {
                        return true;
                    }
                    this.bCb = false;
                    return false;
                } catch (Exception e) {
                    this.bCb = false;
                    return false;
                }
            }
            this.bCc = false;
            this.bCb = false;
            return false;
        }

        public boolean Ps() {
            return this.bCb;
        }

        public void stopAnimation() {
            this.bCc = true;
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.bBz = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bjN = onLongClickListener;
        if (this.bBO != null) {
            this.bBO.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setGifSetListener(e eVar) {
        this.bjQ = eVar;
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
    public void Pp() {
        long j;
        c poll = this.bBU.poll();
        if (poll == null) {
            this.bBZ = true;
            return;
        }
        this.bBZ = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.bBT != null) {
            j = this.bBT.delay - (currentTimeMillis - this.bBY);
            this.bBV.offer(this.bBT);
        } else {
            j = 0;
        }
        this.bBT = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public c Pq() {
        c poll = this.bBV.poll();
        if (poll == null) {
            poll = new c();
            try {
                poll.bCi = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
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
        return this.bBT;
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
            while (this.sx && a.this.bBF != null && a.this.bBS > 0 && a.this.width > 0 && a.this.height > 0) {
                try {
                    a.this.bBF.cM(a.this.bBW);
                    c Pq = a.this.Pq();
                    if (Pq.bCi == null || (Pq.bCi.getWidth() != a.this.width && Pq.bCi.getHeight() != a.this.height)) {
                        try {
                            Pq.bCi = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_8888);
                        } catch (OutOfMemoryError e) {
                            TbadkCoreApplication.getInst().onAppMemoryLow();
                            try {
                                Pq.bCi = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_4444);
                            } catch (OutOfMemoryError e2) {
                                TbadkCoreApplication.getInst().onAppMemoryLow();
                            } catch (Throwable th) {
                                BdLog.e(th.getMessage());
                            }
                        } catch (Throwable th2) {
                            BdLog.e(th2.getMessage());
                        }
                    }
                    a.this.bBF.a(Pq.bCi, null);
                    Pq.delay = a.this.bBF.cN(a.this.bBW);
                    a.A(a.this);
                    if (Pq.bCi == null) {
                        a.A(a.this);
                    }
                    a.this.bBW %= a.this.bBS;
                    a.this.bBU.put(Pq);
                    if (a.this.bBZ) {
                        a.this.mHandler.sendEmptyMessage(1);
                    }
                } catch (Exception e3) {
                    return;
                }
            }
        }
    }

    public boolean Pr() {
        return this.bBL;
    }

    public void setLoadBigImage(boolean z) {
        this.bBL = z;
    }

    public int getBottomOffset() {
        return this.bBI;
    }

    public int getLeftOffset() {
        return this.bBJ;
    }
}
