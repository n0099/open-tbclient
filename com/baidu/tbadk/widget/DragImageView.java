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
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class DragImageView extends ImageView {
    private static final String TAG = DragImageView.class.getSimpleName();
    private static final int cno = l.ah(TbadkCoreApplication.getInst()) / 5;
    private int cCA;
    private volatile com.baidu.adp.gif.b cCB;
    private Bitmap cCC;
    private int cCD;
    private int cCE;
    private int cCF;
    private int cCG;
    private boolean cCH;
    private boolean cCI;
    private boolean cCJ;
    private float cCK;
    private com.baidu.tbadk.widget.largeImage.logic.b cCL;
    private ImageUrlData cCM;
    private Interpolator cCN;
    private Rect cCO;
    private int cCP;
    private c cCQ;
    private BlockingLinkedDeque<c> cCR;
    private BlockingLinkedDeque<c> cCS;
    private volatile int cCT;
    private b cCU;
    private volatile long cCV;
    private volatile boolean cCW;
    private float cCj;
    private float cCk;
    private ArrayList<Float> cCl;
    private float cCm;
    private float cCn;
    private float cCo;
    private boolean cCp;
    private byte[] cCq;
    private int cCr;
    private int cCs;
    private g cCt;
    private View.OnClickListener cCu;
    private a cCv;
    private f cCw;
    private float cCx;
    private boolean cCy;
    private boolean cCz;
    private View.OnLongClickListener clk;
    private e cln;
    private int cls;
    private boolean cne;
    private float cnf;
    private Matrix cng;
    private Rect cnh;
    private RectF cni;
    private d cnn;
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
        public Bitmap cDg;
        public int delay;
    }

    /* loaded from: classes.dex */
    public interface d {
        void avV();

        void avW();

        void avX();
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
        int i = dragImageView.cCT;
        dragImageView.cCT = i + 1;
        return i;
    }

    public void setIsHeadImage(boolean z) {
        this.cCJ = z;
    }

    public void setImageUrlData(ImageUrlData imageUrlData) {
        this.cCM = imageUrlData;
    }

    public ImageUrlData getImageUrlData() {
        return this.cCM;
    }

    public void setCanScale(boolean z) {
        this.cCI = z;
    }

    public DragImageView(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.cCp = false;
        this.cCq = null;
        this.cls = 0;
        this.cCr = 1300;
        this.cCs = 0;
        this.cCt = null;
        this.cCu = null;
        this.clk = null;
        this.cln = null;
        this.cCx = 1.0f;
        this.mImageType = 0;
        this.mMode = 0;
        this.cCy = false;
        this.cCz = false;
        this.cCA = 0;
        this.cCB = null;
        this.cCC = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.cCD = 0;
        this.cCE = 0;
        this.cCF = 0;
        this.cCG = 0;
        this.cCI = true;
        this.cCN = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.cng = new Matrix();
        this.cne = false;
        this.mRatio = 1.0f;
        this.cnf = 0.0f;
        this.cni = new RectF();
        this.width = 0;
        this.height = 0;
        this.cCP = 0;
        this.cCQ = null;
        this.cCR = new BlockingLinkedDeque<>(5);
        this.cCS = new BlockingLinkedDeque<>(6);
        this.cCT = 0;
        this.cCV = 0L;
        this.cCW = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.DragImageView.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        DragImageView.this.avR();
                        break;
                    case 1:
                        if (DragImageView.this.cCW) {
                            DragImageView.this.avR();
                            break;
                        }
                        break;
                    case 2:
                        DragImageView.this.invalidate();
                        DragImageView.this.cCV = System.currentTimeMillis();
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
        this.cCp = false;
        this.cCq = null;
        this.cls = 0;
        this.cCr = 1300;
        this.cCs = 0;
        this.cCt = null;
        this.cCu = null;
        this.clk = null;
        this.cln = null;
        this.cCx = 1.0f;
        this.mImageType = 0;
        this.mMode = 0;
        this.cCy = false;
        this.cCz = false;
        this.cCA = 0;
        this.cCB = null;
        this.cCC = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.cCD = 0;
        this.cCE = 0;
        this.cCF = 0;
        this.cCG = 0;
        this.cCI = true;
        this.cCN = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.cng = new Matrix();
        this.cne = false;
        this.mRatio = 1.0f;
        this.cnf = 0.0f;
        this.cni = new RectF();
        this.width = 0;
        this.height = 0;
        this.cCP = 0;
        this.cCQ = null;
        this.cCR = new BlockingLinkedDeque<>(5);
        this.cCS = new BlockingLinkedDeque<>(6);
        this.cCT = 0;
        this.cCV = 0L;
        this.cCW = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.DragImageView.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        DragImageView.this.avR();
                        break;
                    case 1:
                        if (DragImageView.this.cCW) {
                            DragImageView.this.avR();
                            break;
                        }
                        break;
                    case 2:
                        DragImageView.this.invalidate();
                        DragImageView.this.cCV = System.currentTimeMillis();
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
        this.cCp = false;
        this.cCq = null;
        this.cls = 0;
        this.cCr = 1300;
        this.cCs = 0;
        this.cCt = null;
        this.cCu = null;
        this.clk = null;
        this.cln = null;
        this.cCx = 1.0f;
        this.mImageType = 0;
        this.mMode = 0;
        this.cCy = false;
        this.cCz = false;
        this.cCA = 0;
        this.cCB = null;
        this.cCC = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.cCD = 0;
        this.cCE = 0;
        this.cCF = 0;
        this.cCG = 0;
        this.cCI = true;
        this.cCN = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.cng = new Matrix();
        this.cne = false;
        this.mRatio = 1.0f;
        this.cnf = 0.0f;
        this.cni = new RectF();
        this.width = 0;
        this.height = 0;
        this.cCP = 0;
        this.cCQ = null;
        this.cCR = new BlockingLinkedDeque<>(5);
        this.cCS = new BlockingLinkedDeque<>(6);
        this.cCT = 0;
        this.cCV = 0L;
        this.cCW = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.DragImageView.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        DragImageView.this.avR();
                        break;
                    case 1:
                        if (DragImageView.this.cCW) {
                            DragImageView.this.avR();
                            break;
                        }
                        break;
                    case 2:
                        DragImageView.this.invalidate();
                        DragImageView.this.cCV = System.currentTimeMillis();
                        DragImageView.this.mHandler.sendEmptyMessage(0);
                        break;
                }
                return false;
            }
        });
        initData();
    }

    public void setDragToExitListener(d dVar) {
        this.cnn = dVar;
    }

    public int getImageType() {
        return this.mImageType;
    }

    public void setImageMode(int i) {
        this.cCs = i;
    }

    public void setOffset(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.cls = i;
    }

    public boolean avD() {
        if (this.cCL != null) {
            return this.cCL.avD();
        }
        return false;
    }

    public void avE() {
        this.cCz = false;
        this.cCp = false;
        this.mMode = 3;
        avK();
        if (this.mCurrentScale < this.cCm) {
            this.mCurrentScale = this.cCm;
            avQ();
        }
        invalidate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.cCL != null && this.cCL.onTouchEvent(motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.cCp = true;
                this.cCy = false;
                this.cCz = false;
                break;
            case 1:
                avE();
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
            this.cCx = x(motionEvent);
            if (this.cCx > 10.0f) {
                this.mMode = 2;
            }
        }
        if ((this.mMode == 2 || !this.mGestureDetector.onTouchEvent(motionEvent)) && this.cCI) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.cCy = true;
                        this.cCz = true;
                        if (this.mImageType != 1 && this.mImageType != 2) {
                            float x = x(motionEvent);
                            if (x >= 0.0f && Math.abs(this.cCx - x) >= 10.0f) {
                                if (Math.abs(this.cCx - x) > 100.0f) {
                                    this.cCx = x;
                                    break;
                                } else {
                                    float f2 = x / this.cCx;
                                    this.cCx = x;
                                    this.cCo = this.mCurrentScale;
                                    this.mCurrentScale *= f2;
                                    if (this.mCurrentScale > this.cCn) {
                                        this.mCurrentScale = this.cCn;
                                    }
                                    float minScaleValue = getMinScaleValue();
                                    if (this.mCurrentScale < minScaleValue) {
                                        this.mCurrentScale = minScaleValue;
                                    }
                                    avQ();
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
        return this.cCL != null ? this.cCL.getMinScaleValue() : this.cCm / 4.0f;
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
            avG();
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public boolean avF() {
        if (this.cCL != null) {
            return this.cCL.awL();
        }
        return this.cCm == this.mCurrentScale;
    }

    protected float o(Bitmap bitmap) {
        if (this.cCL != null) {
            return this.cCL.awP();
        }
        if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            return 1.0f;
        }
        if (this.cCs == 0) {
            float width = this.mViewWidth / bitmap.getWidth();
            float height = this.mViewHeight / bitmap.getHeight();
            if (this.cCJ) {
                if (this.mImageType == 2) {
                    return 2.5f;
                }
                return Math.min(width, height);
            } else if (this.mImageType != 2) {
                float f2 = this.cCK;
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
        if (this.cCL != null) {
            return this.cCL.awQ();
        }
        float f2 = 1.0f;
        if (bitmap != null && !bitmap.isRecycled() && bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
            f2 = (float) Math.sqrt(this.cCr / (bitmap.getWidth() * bitmap.getHeight()));
            if (f2 > 10.0f) {
                return 10.0f;
            }
        }
        return f2;
    }

    private void avG() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            this.cCm = o(imageBitmap);
            this.cCn = p(imageBitmap);
            this.cCl.clear();
            this.cCl.add(Float.valueOf(this.cCm));
            this.mCurrentScale = this.cCm;
            this.cCo = this.mCurrentScale;
            avQ();
            return;
        }
        this.cCj = 0.0f;
        this.cCk = 0.0f;
        this.cCm = 1.0f;
        this.cCn = 1.0f;
        this.mCurrentScale = 1.0f;
        this.cCo = this.mCurrentScale;
        this.cCl.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    private void avH() {
        if (this.cCt != null) {
            this.cCt.a(this, canZoomIn(), canZoomOut());
        }
    }

    public void setOnSizeChangedListener(g gVar) {
        this.cCt = gVar;
    }

    public void setOnImageScrollListener(f fVar) {
        this.cCw = fVar;
    }

    public byte[] getImageData() {
        return this.cCq;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getMeasuredHeight() != 0 && getMeasuredWidth() != 0 && this.cCL != null) {
            this.cCL.awN();
        }
    }

    public void setImageData(Bitmap bitmap, byte[] bArr) {
        this.cCq = bArr;
        if (this.cCL != null) {
            this.cCL.a(bitmap, bArr);
        }
        setImageBitmap(bitmap);
    }

    public void avI() {
        if (this.cCL == null) {
            this.cCL = new com.baidu.tbadk.widget.largeImage.logic.b(this);
            this.cCL.setOnClickListener(this.cCu);
            this.cCL.setOnLongClickListener(this.clk);
        }
    }

    public void setImageLoadCallBack(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
        if (this.cCL != null) {
            this.cCL.a(aVar);
        }
    }

    public boolean avJ() {
        return (getImageBitmap() == null || this.cCL == null) ? false : true;
    }

    public Bitmap getGifCache() {
        return this.cCC;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        boolean z;
        if (this.cCL == null || !this.cCL.b(canvas, getImageBitmap())) {
            if (this.mImageType == 2 && this.cCG != 0 && !this.cCv.avU()) {
                int width = getWidth();
                int height = getHeight();
                Drawable drawable = getDrawable();
                float f2 = 0.0f;
                float f3 = height * 0.3f;
                float f4 = width;
                float f5 = (1.0f - 0.3f) * height;
                if (this.cCJ && drawable != null) {
                    Rect bounds = drawable.getBounds();
                    int i = bounds.right - bounds.left;
                    int i2 = bounds.bottom - bounds.top;
                    f2 = (width / 2) - (i * 2.5f);
                    f3 = (height / 2) - (i2 * 2.5f);
                    f4 = (i * 2.5f) + (width / 2);
                    f5 = (i2 * 2.5f) + (height / 2);
                }
                this.mPaint.setColor(al.getColor(this.cCG));
                canvas.drawRect(f2, f3, f4, f5, this.mPaint);
                this.mPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
            }
            if (this.mMode == 3 && this.cne) {
                this.cne = false;
                this.cng.reset();
                if (this.cnf < cno) {
                    this.mMode = 0;
                } else {
                    this.mMode = 4;
                    apu();
                }
            }
            if (this.mImageType == 0 && this.cne && this.cnh != null && this.cCM != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                if (this.cni == null) {
                    this.cni = new RectF();
                }
                this.cng.mapRect(this.cni, new RectF(this.cnh));
                Bitmap imageBitmap = getImageBitmap();
                if (imageBitmap != null && !imageBitmap.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.cCO, this.cni, (Paint) null);
                }
            } else if (this.mMode == 4 && this.cnh != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                Bitmap imageBitmap2 = getImageBitmap();
                if (imageBitmap2 != null && !imageBitmap2.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.cCO, this.cni, (Paint) null);
                }
            } else {
                super.onDraw(canvas);
            }
            if (this.mImageType == 1 && this.cCC != null && !this.cCC.isRecycled()) {
                int width2 = this.cCC.getWidth();
                int height2 = this.cCC.getHeight();
                int width3 = getWidth();
                int height3 = getHeight();
                int i3 = (width3 - width2) >> 1;
                int i4 = (height3 - height2) >> 1;
                float f6 = this.cCK;
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
                if (this.cCA == 1 && this.cCB != null && this.cCQ != null && this.cCQ.cDg != null) {
                    if (z) {
                        canvas.drawBitmap(this.cCQ.cDg, i3, i4, (Paint) null);
                    } else {
                        canvas.drawBitmap(this.cCQ.cDg, this.mMatrix, this.mPaint);
                    }
                    invalidate();
                } else if (z) {
                    canvas.drawBitmap(this.cCC, i3, i4, (Paint) null);
                } else {
                    canvas.drawBitmap(this.cCC, this.mMatrix, this.mPaint);
                }
            }
        }
    }

    public void play() {
        com.baidu.adp.widget.ImageView.a aVar;
        if (this.mImageType == 1) {
            if (this.cCB == null) {
                if (this.cCU != null) {
                    this.cCU.Cb = false;
                    this.cCU.interrupt();
                    this.cCU = null;
                }
                if (this.cCq != null) {
                    try {
                        aVar = a.C0013a.gp().g(this.cCq, 0, this.cCq.length);
                    } catch (StackOverflowError e2) {
                        aVar = null;
                    }
                    if (aVar == null || aVar.getGif() == null) {
                        com.baidu.tbadk.core.d.a.a("gifplay", -1L, -1, "DragImageView.play", -1, "decode error", new Object[0]);
                        return;
                    }
                    this.cCB = aVar.getGif();
                    if (this.cCB != null) {
                        this.cCA = 1;
                        this.width = this.cCB.getWidth();
                        this.height = this.cCB.getHeight();
                        this.cCT = 0;
                        this.cCP = this.cCB.getFrameCount();
                    } else {
                        this.cCA = 0;
                    }
                } else {
                    return;
                }
            }
            if (this.cCB != null) {
                if (this.cCU == null || (this.cCU != null && !this.cCU.Cb)) {
                    this.cCW = true;
                    this.cCU = new b();
                    this.cCR.clear();
                    this.cCS.clear();
                    this.cCU.Cb = true;
                    this.cCU.start();
                }
            }
        }
    }

    public void pause() {
        if (this.mImageType == 1) {
            if (this.cCU != null) {
                this.cCU.Cb = false;
                this.cCU.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.mImageType == 1) {
            if (this.cCU != null) {
                this.cCU.Cb = false;
                this.cCU.interrupt();
                this.cCU = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.cCW = true;
            this.cCQ = null;
            this.cCS.clear();
            this.cCR.clear();
            this.width = 0;
            this.height = 0;
            this.cCT = 0;
            this.cCP = 0;
            this.cCB = null;
        }
    }

    private void initData() {
        this.cCK = l.ai(getContext());
        this.cCr = l.ah(getContext()) * l.af(getContext()) * 2;
        if (this.cCr < 1690000) {
            this.cCr = 1690000;
        }
        this.cCj = 0.0f;
        this.cCk = 0.0f;
        this.cCl = new ArrayList<>();
        this.cCm = 1.0f;
        this.cCn = 1.0f;
        this.mCurrentScale = 1.0f;
        this.cCo = this.mCurrentScale;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.cCv = new a();
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
                    DragImageView.this.cCv.s(f2, f3);
                    DragImageView.this.startAnimation(DragImageView.this.cCv);
                }
                return super.onFling(motionEvent, motionEvent2, f2, f3);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (DragImageView.this.mImageType == 1 || DragImageView.this.mImageType == 2 || !DragImageView.this.cCI) {
                    return false;
                }
                DragImageView.this.mMode = 2;
                if (DragImageView.this.mCurrentScale > DragImageView.this.cCm) {
                    DragImageView.this.mCurrentScale = DragImageView.this.cCm;
                    DragImageView.this.cCo = DragImageView.this.mCurrentScale;
                    DragImageView.this.avQ();
                } else {
                    DragImageView.this.mCurrentScale = DragImageView.this.cCm * 2.0f;
                    DragImageView.this.a(true, (int) motionEvent.getX(), (int) motionEvent.getY());
                }
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (DragImageView.this.cCu != null && !DragImageView.this.cCy) {
                    DragImageView.this.cCu.onClick(DragImageView.this);
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
                DragImageView.this.cCy = true;
                if (DragImageView.this.cCs == 0 && DragImageView.this.cCz) {
                    return false;
                }
                int scrollX = DragImageView.this.getScrollX();
                int scrollY = DragImageView.this.getScrollY();
                if (DragImageView.this.cCj >= DragImageView.this.getWidth()) {
                    scrollX = (int) (scrollX + f2);
                    if (DragImageView.this.cCs == 0) {
                        i = scrollX >= 0 ? scrollX : 0;
                        if (DragImageView.this.getWidth() + i > DragImageView.this.cCj) {
                            i = (int) (DragImageView.this.cCj - DragImageView.this.getWidth());
                        }
                        if (DragImageView.this.cCk + DragImageView.this.mTop + DragImageView.this.mBottom < DragImageView.this.getHeight()) {
                            i2 = (int) (scrollY + f3);
                            if (DragImageView.this.cCs == 0) {
                                if (i2 < (-DragImageView.this.cCD)) {
                                    i2 = -DragImageView.this.cCD;
                                }
                                if (DragImageView.this.getHeight() + i2 > DragImageView.this.cCk + DragImageView.this.mBottom + DragImageView.this.cCE) {
                                    i2 = (int) ((DragImageView.this.cCk - DragImageView.this.getHeight()) + DragImageView.this.mBottom + DragImageView.this.cCE);
                                }
                            }
                        } else {
                            i2 = scrollY;
                        }
                        if (i == DragImageView.this.getScrollX() || i2 != DragImageView.this.getScrollY()) {
                            DragImageView.this.scrollTo(i, i2);
                            DragImageView.this.invalidate();
                            if (DragImageView.this.cCw != null) {
                                DragImageView.this.cCw.a(DragImageView.this, i, i2);
                            }
                        }
                        return true;
                    }
                }
                i = scrollX;
                if (DragImageView.this.cCk + DragImageView.this.mTop + DragImageView.this.mBottom < DragImageView.this.getHeight()) {
                }
                if (i == DragImageView.this.getScrollX()) {
                }
                DragImageView.this.scrollTo(i, i2);
                DragImageView.this.invalidate();
                if (DragImageView.this.cCw != null) {
                }
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (DragImageView.this.clk != null && !DragImageView.this.cCy) {
                    DragImageView.this.clk.onLongClick(DragImageView.this);
                }
                super.onLongPress(motionEvent);
            }
        });
    }

    private void apu() {
        if (this.cCM == null) {
            if (this.cnn != null) {
                this.cnn.avW();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.cCM.getSourceImageRectInScreen();
        if (sourceImageRectInScreen == null) {
            if (this.cnn != null) {
                this.cnn.avW();
                return;
            }
            return;
        }
        this.cni.bottom = (((sourceImageRectInScreen.bottom - sourceImageRectInScreen.top) / (sourceImageRectInScreen.right - sourceImageRectInScreen.left)) * (this.cni.right - this.cni.left)) + this.cni.top;
        final float[] fArr = {(this.cni.left + this.cni.right) / 2.0f, (this.cni.top + this.cni.bottom) / 2.0f};
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
                    DragImageView.this.cni = DragImageView.this.h(floatValue, animatedFraction, sourceImageRectInScreen.right - sourceImageRectInScreen.left, sourceImageRectInScreen.bottom - sourceImageRectInScreen.top);
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
                DragImageView.this.cne = false;
                DragImageView.this.mMode = 4;
                DragImageView.this.invalidate();
                if (DragImageView.this.cnn != null) {
                    DragImageView.this.cnn.avW();
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

    private void avK() {
        int i = 0;
        int scrollX = getScrollX();
        if (this.cCj >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.cCj) {
                scrollX = (int) (this.cCj - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.cCk + this.mTop + this.mBottom >= getHeight()) {
            i = scrollY < (-this.cCD) ? -this.cCD : scrollY;
            if (getHeight() + i > this.cCk + this.mBottom + this.cCE) {
                i = (int) ((this.cCk - getHeight()) + this.mBottom + this.cCE);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
            if (this.cCw != null) {
                this.cCw.a(this, scrollX, i);
            }
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.cCL != null) {
            this.cCL.awM();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.cCj;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.cCk;
    }

    public boolean avL() {
        if (this.mImageType == 1 || this.mImageType == 2) {
            return true;
        }
        return !this.cCz && getScrollX() >= ((int) (this.cCj - ((float) getWidth()))) + (-1);
    }

    public boolean avM() {
        if (this.mImageType == 1 || this.mImageType == 2) {
            return true;
        }
        return !this.cCz && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.cCv.avU()) {
            this.cCv.stopAnimation();
        }
        this.cCG = 0;
        super.setImageBitmap(bitmap);
        avG();
        this.mImageType = 0;
        if (this.cnh == null) {
            int measuredWidth = getMeasuredWidth();
            float measuredWidth2 = ((1.0f * getMeasuredWidth()) / bitmap.getWidth()) * bitmap.getHeight();
            if (measuredWidth2 > getMeasuredHeight()) {
                measuredWidth2 = getMeasuredHeight();
            }
            RectF h = h(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
            this.cnh = new Rect((int) h.left, (int) h.top, (int) h.right, (int) h.bottom);
        }
        if (this.cCO == null) {
            this.cCO = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
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
            if (this.cCv.avU()) {
                this.cCv.stopAnimation();
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
        if (this.cCv.avU()) {
            this.cCv.stopAnimation();
        }
        super.setImageDrawable(null);
        stop();
        avG();
        this.mImageType = 1;
        this.cCC = bitmap;
        this.cCq = bArr;
        if (this.cln != null) {
            this.cln.a(this);
        }
    }

    public void onDestroy() {
        if (this.cCv.avU()) {
            this.cCv.stopAnimation();
        }
        super.setImageDrawable(null);
        this.cCq = null;
        this.cCC = null;
        stop();
        if (this.cCB != null) {
            this.cCB.close();
            this.cCB = null;
        }
        if (this.cCL != null) {
            this.cCL.release();
            System.gc();
        }
    }

    public void release() {
        if (this.cCv.avU()) {
            this.cCv.stopAnimation();
        }
        stop();
        super.setImageDrawable(null);
        this.cCC = null;
    }

    public void setDefaultBitmap() {
        if (this.cCv.avU()) {
            this.cCv.stopAnimation();
        }
        try {
            if (this.cCJ) {
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
        avG();
    }

    public void avN() {
        if (this.mImageType != 1 && this.mImageType != 2) {
            int size = this.cCl.size();
            if (size > 0) {
                this.cCl.add(Float.valueOf(this.cCl.get(size - 1).floatValue() * 1.25f));
            } else {
                this.cCl.add(Float.valueOf(this.cCm));
            }
            avQ();
        }
    }

    public void avO() {
        if (this.mImageType != 1 && this.mImageType != 2) {
            int size = this.cCl.size();
            if (size > 1) {
                this.cCl.remove(size - 1);
            }
            avQ();
        }
    }

    public void avP() {
        avH();
        if (this.mImageType != 1 && this.mImageType != 2 && this.mCurrentScale != this.cCm) {
            this.cCl.clear();
            this.cCl.add(Float.valueOf(this.cCm));
            this.mCurrentScale = this.cCm;
            this.cCo = this.mCurrentScale;
            avQ();
        }
    }

    public boolean canZoomIn() {
        if (this.mImageType == 1 || this.mImageType == 2) {
            return false;
        }
        int size = this.cCl.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.cCl.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.cCr) && floatValue <= 5.0f;
    }

    public boolean canZoomOut() {
        if (this.mImageType == 1 || this.mImageType == 2) {
            return false;
        }
        int size = this.cCl.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled()) {
            return false;
        }
        return size > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avQ() {
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
                    int size = this.cCl.size();
                    if (size > 0) {
                        f3 = this.cCl.get(size - 1).floatValue();
                    } else {
                        f3 = this.cCm;
                    }
                    this.mCurrentScale = f3;
                }
                this.mMatrix.setScale(this.mCurrentScale, this.mCurrentScale);
                this.cCj = imageBitmap.getWidth() * this.mCurrentScale;
                this.cCk = imageBitmap.getHeight() * this.mCurrentScale;
                float width = this.cCo * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.cCo;
                this.cCD = this.mTop;
                this.cCE = 0;
                float f4 = this.cCj < ((float) this.mViewWidth) ? (int) ((this.mViewWidth - this.cCj) / 2.0f) : 0.0f;
                if (this.cCk < this.mViewHeight) {
                    f2 = (int) ((this.mViewHeight - this.cCk) / 2.0f);
                    if (this.cCs == 1 && f2 > this.mTop) {
                        f2 = this.mTop;
                    }
                    this.cCD = (int) (this.mTop - f2);
                    this.cCE = this.mTop - this.cCD;
                } else {
                    f2 = 0.0f;
                }
                this.cCF = (int) f4;
                this.mMatrix.postTranslate(f4, f2);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    int width2 = i > getWidth() ? getWidth() : i;
                    if (this.cCj <= screenWidth) {
                        width2 = 0;
                    } else if (this.cCj > screenWidth && this.cCj / 2.0f < screenWidth) {
                        width2 = (int) (width2 - (this.cCj / 4.0f));
                    }
                    scrollX = width2;
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.cCj - width) / 2.0f);
                    }
                    if (this.cCj <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.cCj) {
                        scrollX = (int) (this.cCj - getWidth());
                    }
                }
                if (scrollX > 0 && this.cCj - scrollX < getWidth()) {
                    scrollX = (int) (this.cCj - getWidth());
                }
                int i3 = this.mMode == 2 ? ((int) ((this.cCk - height) / 2.0f)) + scrollY : scrollY;
                if (this.cCk <= getHeight()) {
                    i3 = 0;
                } else if (getHeight() + i3 > this.cCk) {
                    i3 = (int) (this.cCk - getHeight());
                }
                setHorizontalScrollBarEnabled(false);
                setVerticalScrollBarEnabled(false);
                if (scrollX < 0) {
                    scrollX = 0;
                }
                scrollTo(scrollX, i3 >= 0 ? i3 : 0);
                setImageMatrix(this.mMatrix);
                avH();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Animation {
        private boolean cDa = false;
        private boolean cDb = false;
        private long cDc;
        private long cDd;
        private long cDe;
        private long cDf;
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
            this.cDc = f;
            this.cDd = f2;
            this.cDe = Math.abs((f * 1000.0f) / 2500.0f);
            this.cDf = Math.abs((f2 * 1000.0f) / 2500.0f);
            setDuration(Math.max(this.cDe, this.cDf));
            setInterpolator(DragImageView.this.cCN);
            this.mStartX = DragImageView.this.getScrollX();
            this.mStartY = DragImageView.this.getScrollY();
            this.cDa = true;
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
            if (this.cDe > this.cDf) {
                j = ((float) this.cDe) * f;
            } else {
                j = ((float) this.cDf) * f;
            }
            float f2 = ((float) (j > this.cDe ? this.cDe : j)) / 1000.0f;
            if (this.cDc > 0) {
                i = this.mStartX - ((int) (f2 * (((float) this.cDc) - ((2500.0f * f2) / 2.0f))));
            } else {
                i = this.mStartX - ((int) (f2 * (((float) this.cDc) + ((2500.0f * f2) / 2.0f))));
            }
            if (j > this.cDf) {
                j = this.cDf;
            }
            float f3 = ((float) j) / 1000.0f;
            if (this.cDd > 0) {
                i2 = this.mStartY - ((int) (f3 * (((float) this.cDd) - ((2500.0f * f3) / 2.0f))));
            } else {
                i2 = this.mStartY - ((int) (f3 * (((float) this.cDd) + ((2500.0f * f3) / 2.0f))));
            }
            if (DragImageView.this.cCk + DragImageView.this.mTop + DragImageView.this.mBottom > DragImageView.this.getHeight()) {
                if (i2 < (-DragImageView.this.cCD)) {
                    i2 = -DragImageView.this.cCD;
                }
                if (DragImageView.this.getHeight() + i2 > DragImageView.this.cCk + DragImageView.this.mBottom + DragImageView.this.cCE) {
                    i2 = (int) ((DragImageView.this.cCk - DragImageView.this.getHeight()) + DragImageView.this.mBottom + DragImageView.this.cCE);
                }
            } else {
                i2 = 0;
            }
            if (DragImageView.this.cCj > DragImageView.this.getWidth()) {
                int width = ((float) (DragImageView.this.getWidth() + i)) > DragImageView.this.cCj ? (int) (DragImageView.this.cCj - DragImageView.this.getWidth()) : i;
                if (width >= 0) {
                    i3 = width;
                }
            }
            DragImageView.this.scrollTo(i3, i2);
            DragImageView.this.invalidate();
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            if (!this.cDb) {
                if (DragImageView.this.cCp) {
                    this.cDa = false;
                    return false;
                }
                try {
                    if (super.getTransformation(j, transformation)) {
                        return true;
                    }
                    this.cDa = false;
                    return false;
                } catch (Exception e) {
                    this.cDa = false;
                    return false;
                }
            }
            this.cDb = false;
            this.cDa = false;
            return false;
        }

        public boolean avU() {
            return this.cDa;
        }

        public void stopAnimation() {
            this.cDb = true;
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.cCu = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.clk = onLongClickListener;
        if (this.cCL != null) {
            this.cCL.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setGifSetListener(e eVar) {
        this.cln = eVar;
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
    public void avR() {
        long j;
        c poll = this.cCR.poll();
        if (poll == null) {
            this.cCW = true;
            return;
        }
        this.cCW = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.cCQ != null) {
            j = this.cCQ.delay - (currentTimeMillis - this.cCV);
            this.cCS.offer(this.cCQ);
        } else {
            j = 0;
        }
        this.cCQ = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public c avS() {
        c poll = this.cCS.poll();
        if (poll == null) {
            poll = new c();
            try {
                poll.cDg = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
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
        return this.cCQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends Thread {
        private volatile boolean Cb;

        private b() {
            this.Cb = false;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (this.Cb && DragImageView.this.cCB != null && DragImageView.this.cCP > 0 && DragImageView.this.width > 0 && DragImageView.this.height > 0) {
                try {
                    DragImageView.this.cCB.N(DragImageView.this.cCT);
                    c avS = DragImageView.this.avS();
                    if (avS.cDg == null || (avS.cDg.getWidth() != DragImageView.this.width && avS.cDg.getHeight() != DragImageView.this.height)) {
                        try {
                            avS.cDg = Bitmap.createBitmap(DragImageView.this.width, DragImageView.this.height, Bitmap.Config.ARGB_8888);
                        } catch (OutOfMemoryError e) {
                            TbadkCoreApplication.getInst().onAppMemoryLow();
                            try {
                                avS.cDg = Bitmap.createBitmap(DragImageView.this.width, DragImageView.this.height, Bitmap.Config.ARGB_4444);
                            } catch (OutOfMemoryError e2) {
                                TbadkCoreApplication.getInst().onAppMemoryLow();
                            } catch (Throwable th) {
                                BdLog.e(th.getMessage());
                            }
                        } catch (Throwable th2) {
                            BdLog.e(th2.getMessage());
                        }
                    }
                    DragImageView.this.cCB.a(avS.cDg, null);
                    avS.delay = DragImageView.this.cCB.O(DragImageView.this.cCT);
                    DragImageView.C(DragImageView.this);
                    if (avS.cDg == null) {
                        DragImageView.C(DragImageView.this);
                    }
                    DragImageView.this.cCT %= DragImageView.this.cCP;
                    DragImageView.this.cCR.put(avS);
                    if (DragImageView.this.cCW) {
                        DragImageView.this.mHandler.sendEmptyMessage(1);
                    }
                } catch (Exception e3) {
                    return;
                }
            }
        }
    }

    public boolean avT() {
        return this.cCH;
    }

    public void setLoadBigImage(boolean z) {
        this.cCH = z;
    }

    public int getBottomOffset() {
        return this.cCE;
    }

    public int getLeftOffset() {
        return this.cCF;
    }
}
