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
    private static final int cnp = l.ah(TbadkCoreApplication.getInst()) / 5;
    private boolean cCA;
    private int cCB;
    private volatile com.baidu.adp.gif.b cCC;
    private Bitmap cCD;
    private int cCE;
    private int cCF;
    private int cCG;
    private int cCH;
    private boolean cCI;
    private boolean cCJ;
    private boolean cCK;
    private float cCL;
    private com.baidu.tbadk.widget.largeImage.logic.b cCM;
    private ImageUrlData cCN;
    private Interpolator cCO;
    private Rect cCP;
    private int cCQ;
    private c cCR;
    private BlockingLinkedDeque<c> cCS;
    private BlockingLinkedDeque<c> cCT;
    private volatile int cCU;
    private b cCV;
    private volatile long cCW;
    private volatile boolean cCX;
    private float cCk;
    private float cCl;
    private ArrayList<Float> cCm;
    private float cCn;
    private float cCo;
    private float cCp;
    private boolean cCq;
    private byte[] cCr;
    private int cCs;
    private int cCt;
    private g cCu;
    private View.OnClickListener cCv;
    private a cCw;
    private f cCx;
    private float cCy;
    private boolean cCz;
    private View.OnLongClickListener cll;
    private e clo;
    private int clt;
    private boolean cnf;
    private float cng;
    private Matrix cnh;
    private Rect cni;
    private RectF cnj;
    private d cno;
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
        public Bitmap cDh;
        public int delay;
    }

    /* loaded from: classes.dex */
    public interface d {
        void avW();

        void avX();

        void avY();
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
        int i = dragImageView.cCU;
        dragImageView.cCU = i + 1;
        return i;
    }

    public void setIsHeadImage(boolean z) {
        this.cCK = z;
    }

    public void setImageUrlData(ImageUrlData imageUrlData) {
        this.cCN = imageUrlData;
    }

    public ImageUrlData getImageUrlData() {
        return this.cCN;
    }

    public void setCanScale(boolean z) {
        this.cCJ = z;
    }

    public DragImageView(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.cCq = false;
        this.cCr = null;
        this.clt = 0;
        this.cCs = 1300;
        this.cCt = 0;
        this.cCu = null;
        this.cCv = null;
        this.cll = null;
        this.clo = null;
        this.cCy = 1.0f;
        this.mImageType = 0;
        this.mMode = 0;
        this.cCz = false;
        this.cCA = false;
        this.cCB = 0;
        this.cCC = null;
        this.cCD = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.cCE = 0;
        this.cCF = 0;
        this.cCG = 0;
        this.cCH = 0;
        this.cCJ = true;
        this.cCO = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.cnh = new Matrix();
        this.cnf = false;
        this.mRatio = 1.0f;
        this.cng = 0.0f;
        this.cnj = new RectF();
        this.width = 0;
        this.height = 0;
        this.cCQ = 0;
        this.cCR = null;
        this.cCS = new BlockingLinkedDeque<>(5);
        this.cCT = new BlockingLinkedDeque<>(6);
        this.cCU = 0;
        this.cCW = 0L;
        this.cCX = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.DragImageView.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        DragImageView.this.avS();
                        break;
                    case 1:
                        if (DragImageView.this.cCX) {
                            DragImageView.this.avS();
                            break;
                        }
                        break;
                    case 2:
                        DragImageView.this.invalidate();
                        DragImageView.this.cCW = System.currentTimeMillis();
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
        this.cCq = false;
        this.cCr = null;
        this.clt = 0;
        this.cCs = 1300;
        this.cCt = 0;
        this.cCu = null;
        this.cCv = null;
        this.cll = null;
        this.clo = null;
        this.cCy = 1.0f;
        this.mImageType = 0;
        this.mMode = 0;
        this.cCz = false;
        this.cCA = false;
        this.cCB = 0;
        this.cCC = null;
        this.cCD = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.cCE = 0;
        this.cCF = 0;
        this.cCG = 0;
        this.cCH = 0;
        this.cCJ = true;
        this.cCO = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.cnh = new Matrix();
        this.cnf = false;
        this.mRatio = 1.0f;
        this.cng = 0.0f;
        this.cnj = new RectF();
        this.width = 0;
        this.height = 0;
        this.cCQ = 0;
        this.cCR = null;
        this.cCS = new BlockingLinkedDeque<>(5);
        this.cCT = new BlockingLinkedDeque<>(6);
        this.cCU = 0;
        this.cCW = 0L;
        this.cCX = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.DragImageView.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        DragImageView.this.avS();
                        break;
                    case 1:
                        if (DragImageView.this.cCX) {
                            DragImageView.this.avS();
                            break;
                        }
                        break;
                    case 2:
                        DragImageView.this.invalidate();
                        DragImageView.this.cCW = System.currentTimeMillis();
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
        this.cCq = false;
        this.cCr = null;
        this.clt = 0;
        this.cCs = 1300;
        this.cCt = 0;
        this.cCu = null;
        this.cCv = null;
        this.cll = null;
        this.clo = null;
        this.cCy = 1.0f;
        this.mImageType = 0;
        this.mMode = 0;
        this.cCz = false;
        this.cCA = false;
        this.cCB = 0;
        this.cCC = null;
        this.cCD = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.cCE = 0;
        this.cCF = 0;
        this.cCG = 0;
        this.cCH = 0;
        this.cCJ = true;
        this.cCO = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.cnh = new Matrix();
        this.cnf = false;
        this.mRatio = 1.0f;
        this.cng = 0.0f;
        this.cnj = new RectF();
        this.width = 0;
        this.height = 0;
        this.cCQ = 0;
        this.cCR = null;
        this.cCS = new BlockingLinkedDeque<>(5);
        this.cCT = new BlockingLinkedDeque<>(6);
        this.cCU = 0;
        this.cCW = 0L;
        this.cCX = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.DragImageView.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        DragImageView.this.avS();
                        break;
                    case 1:
                        if (DragImageView.this.cCX) {
                            DragImageView.this.avS();
                            break;
                        }
                        break;
                    case 2:
                        DragImageView.this.invalidate();
                        DragImageView.this.cCW = System.currentTimeMillis();
                        DragImageView.this.mHandler.sendEmptyMessage(0);
                        break;
                }
                return false;
            }
        });
        initData();
    }

    public void setDragToExitListener(d dVar) {
        this.cno = dVar;
    }

    public int getImageType() {
        return this.mImageType;
    }

    public void setImageMode(int i) {
        this.cCt = i;
    }

    public void setOffset(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.clt = i;
    }

    public boolean avE() {
        if (this.cCM != null) {
            return this.cCM.avE();
        }
        return false;
    }

    public void avF() {
        this.cCA = false;
        this.cCq = false;
        this.mMode = 3;
        avL();
        if (this.mCurrentScale < this.cCn) {
            this.mCurrentScale = this.cCn;
            avR();
        }
        invalidate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.cCM != null && this.cCM.onTouchEvent(motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.cCq = true;
                this.cCz = false;
                this.cCA = false;
                break;
            case 1:
                avF();
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
            this.cCy = x(motionEvent);
            if (this.cCy > 10.0f) {
                this.mMode = 2;
            }
        }
        if ((this.mMode == 2 || !this.mGestureDetector.onTouchEvent(motionEvent)) && this.cCJ) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.cCz = true;
                        this.cCA = true;
                        if (this.mImageType != 1 && this.mImageType != 2) {
                            float x = x(motionEvent);
                            if (x >= 0.0f && Math.abs(this.cCy - x) >= 10.0f) {
                                if (Math.abs(this.cCy - x) > 100.0f) {
                                    this.cCy = x;
                                    break;
                                } else {
                                    float f2 = x / this.cCy;
                                    this.cCy = x;
                                    this.cCp = this.mCurrentScale;
                                    this.mCurrentScale *= f2;
                                    if (this.mCurrentScale > this.cCo) {
                                        this.mCurrentScale = this.cCo;
                                    }
                                    float minScaleValue = getMinScaleValue();
                                    if (this.mCurrentScale < minScaleValue) {
                                        this.mCurrentScale = minScaleValue;
                                    }
                                    avR();
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
        return this.cCM != null ? this.cCM.getMinScaleValue() : this.cCn / 4.0f;
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
            avH();
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public boolean avG() {
        if (this.cCM != null) {
            return this.cCM.awM();
        }
        return this.cCn == this.mCurrentScale;
    }

    protected float o(Bitmap bitmap) {
        if (this.cCM != null) {
            return this.cCM.awQ();
        }
        if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            return 1.0f;
        }
        if (this.cCt == 0) {
            float width = this.mViewWidth / bitmap.getWidth();
            float height = this.mViewHeight / bitmap.getHeight();
            if (this.cCK) {
                if (this.mImageType == 2) {
                    return 2.5f;
                }
                return Math.min(width, height);
            } else if (this.mImageType != 2) {
                float f2 = this.cCL;
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
        if (this.cCM != null) {
            return this.cCM.awR();
        }
        float f2 = 1.0f;
        if (bitmap != null && !bitmap.isRecycled() && bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
            f2 = (float) Math.sqrt(this.cCs / (bitmap.getWidth() * bitmap.getHeight()));
            if (f2 > 10.0f) {
                return 10.0f;
            }
        }
        return f2;
    }

    private void avH() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            this.cCn = o(imageBitmap);
            this.cCo = p(imageBitmap);
            this.cCm.clear();
            this.cCm.add(Float.valueOf(this.cCn));
            this.mCurrentScale = this.cCn;
            this.cCp = this.mCurrentScale;
            avR();
            return;
        }
        this.cCk = 0.0f;
        this.cCl = 0.0f;
        this.cCn = 1.0f;
        this.cCo = 1.0f;
        this.mCurrentScale = 1.0f;
        this.cCp = this.mCurrentScale;
        this.cCm.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    private void avI() {
        if (this.cCu != null) {
            this.cCu.a(this, canZoomIn(), canZoomOut());
        }
    }

    public void setOnSizeChangedListener(g gVar) {
        this.cCu = gVar;
    }

    public void setOnImageScrollListener(f fVar) {
        this.cCx = fVar;
    }

    public byte[] getImageData() {
        return this.cCr;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getMeasuredHeight() != 0 && getMeasuredWidth() != 0 && this.cCM != null) {
            this.cCM.awO();
        }
    }

    public void setImageData(Bitmap bitmap, byte[] bArr) {
        this.cCr = bArr;
        if (this.cCM != null) {
            this.cCM.a(bitmap, bArr);
        }
        setImageBitmap(bitmap);
    }

    public void avJ() {
        if (this.cCM == null) {
            this.cCM = new com.baidu.tbadk.widget.largeImage.logic.b(this);
            this.cCM.setOnClickListener(this.cCv);
            this.cCM.setOnLongClickListener(this.cll);
        }
    }

    public void setImageLoadCallBack(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
        if (this.cCM != null) {
            this.cCM.a(aVar);
        }
    }

    public boolean avK() {
        return (getImageBitmap() == null || this.cCM == null) ? false : true;
    }

    public Bitmap getGifCache() {
        return this.cCD;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        boolean z;
        if (this.cCM == null || !this.cCM.b(canvas, getImageBitmap())) {
            if (this.mImageType == 2 && this.cCH != 0 && !this.cCw.avV()) {
                int width = getWidth();
                int height = getHeight();
                Drawable drawable = getDrawable();
                float f2 = 0.0f;
                float f3 = height * 0.3f;
                float f4 = width;
                float f5 = (1.0f - 0.3f) * height;
                if (this.cCK && drawable != null) {
                    Rect bounds = drawable.getBounds();
                    int i = bounds.right - bounds.left;
                    int i2 = bounds.bottom - bounds.top;
                    f2 = (width / 2) - (i * 2.5f);
                    f3 = (height / 2) - (i2 * 2.5f);
                    f4 = (i * 2.5f) + (width / 2);
                    f5 = (i2 * 2.5f) + (height / 2);
                }
                this.mPaint.setColor(al.getColor(this.cCH));
                canvas.drawRect(f2, f3, f4, f5, this.mPaint);
                this.mPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
            }
            if (this.mMode == 3 && this.cnf) {
                this.cnf = false;
                this.cnh.reset();
                if (this.cng < cnp) {
                    this.mMode = 0;
                } else {
                    this.mMode = 4;
                    apu();
                }
            }
            if (this.mImageType == 0 && this.cnf && this.cni != null && this.cCN != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                if (this.cnj == null) {
                    this.cnj = new RectF();
                }
                this.cnh.mapRect(this.cnj, new RectF(this.cni));
                Bitmap imageBitmap = getImageBitmap();
                if (imageBitmap != null && !imageBitmap.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.cCP, this.cnj, (Paint) null);
                }
            } else if (this.mMode == 4 && this.cni != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                Bitmap imageBitmap2 = getImageBitmap();
                if (imageBitmap2 != null && !imageBitmap2.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.cCP, this.cnj, (Paint) null);
                }
            } else {
                super.onDraw(canvas);
            }
            if (this.mImageType == 1 && this.cCD != null && !this.cCD.isRecycled()) {
                int width2 = this.cCD.getWidth();
                int height2 = this.cCD.getHeight();
                int width3 = getWidth();
                int height3 = getHeight();
                int i3 = (width3 - width2) >> 1;
                int i4 = (height3 - height2) >> 1;
                float f6 = this.cCL;
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
                if (this.cCB == 1 && this.cCC != null && this.cCR != null && this.cCR.cDh != null) {
                    if (z) {
                        canvas.drawBitmap(this.cCR.cDh, i3, i4, (Paint) null);
                    } else {
                        canvas.drawBitmap(this.cCR.cDh, this.mMatrix, this.mPaint);
                    }
                    invalidate();
                } else if (z) {
                    canvas.drawBitmap(this.cCD, i3, i4, (Paint) null);
                } else {
                    canvas.drawBitmap(this.cCD, this.mMatrix, this.mPaint);
                }
            }
        }
    }

    public void play() {
        com.baidu.adp.widget.ImageView.a aVar;
        if (this.mImageType == 1) {
            if (this.cCC == null) {
                if (this.cCV != null) {
                    this.cCV.Ca = false;
                    this.cCV.interrupt();
                    this.cCV = null;
                }
                if (this.cCr != null) {
                    try {
                        aVar = a.C0013a.gp().g(this.cCr, 0, this.cCr.length);
                    } catch (StackOverflowError e2) {
                        aVar = null;
                    }
                    if (aVar == null || aVar.getGif() == null) {
                        com.baidu.tbadk.core.d.a.a("gifplay", -1L, -1, "DragImageView.play", -1, "decode error", new Object[0]);
                        return;
                    }
                    this.cCC = aVar.getGif();
                    if (this.cCC != null) {
                        this.cCB = 1;
                        this.width = this.cCC.getWidth();
                        this.height = this.cCC.getHeight();
                        this.cCU = 0;
                        this.cCQ = this.cCC.getFrameCount();
                    } else {
                        this.cCB = 0;
                    }
                } else {
                    return;
                }
            }
            if (this.cCC != null) {
                if (this.cCV == null || (this.cCV != null && !this.cCV.Ca)) {
                    this.cCX = true;
                    this.cCV = new b();
                    this.cCS.clear();
                    this.cCT.clear();
                    this.cCV.Ca = true;
                    this.cCV.start();
                }
            }
        }
    }

    public void pause() {
        if (this.mImageType == 1) {
            if (this.cCV != null) {
                this.cCV.Ca = false;
                this.cCV.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.mImageType == 1) {
            if (this.cCV != null) {
                this.cCV.Ca = false;
                this.cCV.interrupt();
                this.cCV = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.cCX = true;
            this.cCR = null;
            this.cCT.clear();
            this.cCS.clear();
            this.width = 0;
            this.height = 0;
            this.cCU = 0;
            this.cCQ = 0;
            this.cCC = null;
        }
    }

    private void initData() {
        this.cCL = l.ai(getContext());
        this.cCs = l.ah(getContext()) * l.af(getContext()) * 2;
        if (this.cCs < 1690000) {
            this.cCs = 1690000;
        }
        this.cCk = 0.0f;
        this.cCl = 0.0f;
        this.cCm = new ArrayList<>();
        this.cCn = 1.0f;
        this.cCo = 1.0f;
        this.mCurrentScale = 1.0f;
        this.cCp = this.mCurrentScale;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.cCw = new a();
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
                    DragImageView.this.cCw.s(f2, f3);
                    DragImageView.this.startAnimation(DragImageView.this.cCw);
                }
                return super.onFling(motionEvent, motionEvent2, f2, f3);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (DragImageView.this.mImageType == 1 || DragImageView.this.mImageType == 2 || !DragImageView.this.cCJ) {
                    return false;
                }
                DragImageView.this.mMode = 2;
                if (DragImageView.this.mCurrentScale > DragImageView.this.cCn) {
                    DragImageView.this.mCurrentScale = DragImageView.this.cCn;
                    DragImageView.this.cCp = DragImageView.this.mCurrentScale;
                    DragImageView.this.avR();
                } else {
                    DragImageView.this.mCurrentScale = DragImageView.this.cCn * 2.0f;
                    DragImageView.this.a(true, (int) motionEvent.getX(), (int) motionEvent.getY());
                }
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (DragImageView.this.cCv != null && !DragImageView.this.cCz) {
                    DragImageView.this.cCv.onClick(DragImageView.this);
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
                DragImageView.this.cCz = true;
                if (DragImageView.this.cCt == 0 && DragImageView.this.cCA) {
                    return false;
                }
                int scrollX = DragImageView.this.getScrollX();
                int scrollY = DragImageView.this.getScrollY();
                if (DragImageView.this.cCk >= DragImageView.this.getWidth()) {
                    scrollX = (int) (scrollX + f2);
                    if (DragImageView.this.cCt == 0) {
                        i = scrollX >= 0 ? scrollX : 0;
                        if (DragImageView.this.getWidth() + i > DragImageView.this.cCk) {
                            i = (int) (DragImageView.this.cCk - DragImageView.this.getWidth());
                        }
                        if (DragImageView.this.cCl + DragImageView.this.mTop + DragImageView.this.mBottom < DragImageView.this.getHeight()) {
                            i2 = (int) (scrollY + f3);
                            if (DragImageView.this.cCt == 0) {
                                if (i2 < (-DragImageView.this.cCE)) {
                                    i2 = -DragImageView.this.cCE;
                                }
                                if (DragImageView.this.getHeight() + i2 > DragImageView.this.cCl + DragImageView.this.mBottom + DragImageView.this.cCF) {
                                    i2 = (int) ((DragImageView.this.cCl - DragImageView.this.getHeight()) + DragImageView.this.mBottom + DragImageView.this.cCF);
                                }
                            }
                        } else {
                            i2 = scrollY;
                        }
                        if (i == DragImageView.this.getScrollX() || i2 != DragImageView.this.getScrollY()) {
                            DragImageView.this.scrollTo(i, i2);
                            DragImageView.this.invalidate();
                            if (DragImageView.this.cCx != null) {
                                DragImageView.this.cCx.a(DragImageView.this, i, i2);
                            }
                        }
                        return true;
                    }
                }
                i = scrollX;
                if (DragImageView.this.cCl + DragImageView.this.mTop + DragImageView.this.mBottom < DragImageView.this.getHeight()) {
                }
                if (i == DragImageView.this.getScrollX()) {
                }
                DragImageView.this.scrollTo(i, i2);
                DragImageView.this.invalidate();
                if (DragImageView.this.cCx != null) {
                }
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (DragImageView.this.cll != null && !DragImageView.this.cCz) {
                    DragImageView.this.cll.onLongClick(DragImageView.this);
                }
                super.onLongPress(motionEvent);
            }
        });
    }

    private void apu() {
        if (this.cCN == null) {
            if (this.cno != null) {
                this.cno.avX();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.cCN.getSourceImageRectInScreen();
        if (sourceImageRectInScreen == null) {
            if (this.cno != null) {
                this.cno.avX();
                return;
            }
            return;
        }
        this.cnj.bottom = (((sourceImageRectInScreen.bottom - sourceImageRectInScreen.top) / (sourceImageRectInScreen.right - sourceImageRectInScreen.left)) * (this.cnj.right - this.cnj.left)) + this.cnj.top;
        final float[] fArr = {(this.cnj.left + this.cnj.right) / 2.0f, (this.cnj.top + this.cnj.bottom) / 2.0f};
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
                    DragImageView.this.cnj = DragImageView.this.h(floatValue, animatedFraction, sourceImageRectInScreen.right - sourceImageRectInScreen.left, sourceImageRectInScreen.bottom - sourceImageRectInScreen.top);
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
                DragImageView.this.cnf = false;
                DragImageView.this.mMode = 4;
                DragImageView.this.invalidate();
                if (DragImageView.this.cno != null) {
                    DragImageView.this.cno.avX();
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

    private void avL() {
        int i = 0;
        int scrollX = getScrollX();
        if (this.cCk >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.cCk) {
                scrollX = (int) (this.cCk - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.cCl + this.mTop + this.mBottom >= getHeight()) {
            i = scrollY < (-this.cCE) ? -this.cCE : scrollY;
            if (getHeight() + i > this.cCl + this.mBottom + this.cCF) {
                i = (int) ((this.cCl - getHeight()) + this.mBottom + this.cCF);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
            if (this.cCx != null) {
                this.cCx.a(this, scrollX, i);
            }
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.cCM != null) {
            this.cCM.awN();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.cCk;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.cCl;
    }

    public boolean avM() {
        if (this.mImageType == 1 || this.mImageType == 2) {
            return true;
        }
        return !this.cCA && getScrollX() >= ((int) (this.cCk - ((float) getWidth()))) + (-1);
    }

    public boolean avN() {
        if (this.mImageType == 1 || this.mImageType == 2) {
            return true;
        }
        return !this.cCA && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.cCw.avV()) {
            this.cCw.stopAnimation();
        }
        this.cCH = 0;
        super.setImageBitmap(bitmap);
        avH();
        this.mImageType = 0;
        if (this.cni == null) {
            int measuredWidth = getMeasuredWidth();
            float measuredWidth2 = ((1.0f * getMeasuredWidth()) / bitmap.getWidth()) * bitmap.getHeight();
            if (measuredWidth2 > getMeasuredHeight()) {
                measuredWidth2 = getMeasuredHeight();
            }
            RectF h = h(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
            this.cni = new Rect((int) h.left, (int) h.top, (int) h.right, (int) h.bottom);
        }
        if (this.cCP == null) {
            this.cCP = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
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
            if (this.cCw.avV()) {
                this.cCw.stopAnimation();
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
        if (this.cCw.avV()) {
            this.cCw.stopAnimation();
        }
        super.setImageDrawable(null);
        stop();
        avH();
        this.mImageType = 1;
        this.cCD = bitmap;
        this.cCr = bArr;
        if (this.clo != null) {
            this.clo.a(this);
        }
    }

    public void onDestroy() {
        if (this.cCw.avV()) {
            this.cCw.stopAnimation();
        }
        super.setImageDrawable(null);
        this.cCr = null;
        this.cCD = null;
        stop();
        if (this.cCC != null) {
            this.cCC.close();
            this.cCC = null;
        }
        if (this.cCM != null) {
            this.cCM.release();
            System.gc();
        }
    }

    public void release() {
        if (this.cCw.avV()) {
            this.cCw.stopAnimation();
        }
        stop();
        super.setImageDrawable(null);
        this.cCD = null;
    }

    public void setDefaultBitmap() {
        if (this.cCw.avV()) {
            this.cCw.stopAnimation();
        }
        try {
            if (this.cCK) {
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
        avH();
    }

    public void avO() {
        if (this.mImageType != 1 && this.mImageType != 2) {
            int size = this.cCm.size();
            if (size > 0) {
                this.cCm.add(Float.valueOf(this.cCm.get(size - 1).floatValue() * 1.25f));
            } else {
                this.cCm.add(Float.valueOf(this.cCn));
            }
            avR();
        }
    }

    public void avP() {
        if (this.mImageType != 1 && this.mImageType != 2) {
            int size = this.cCm.size();
            if (size > 1) {
                this.cCm.remove(size - 1);
            }
            avR();
        }
    }

    public void avQ() {
        avI();
        if (this.mImageType != 1 && this.mImageType != 2 && this.mCurrentScale != this.cCn) {
            this.cCm.clear();
            this.cCm.add(Float.valueOf(this.cCn));
            this.mCurrentScale = this.cCn;
            this.cCp = this.mCurrentScale;
            avR();
        }
    }

    public boolean canZoomIn() {
        if (this.mImageType == 1 || this.mImageType == 2) {
            return false;
        }
        int size = this.cCm.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.cCm.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.cCs) && floatValue <= 5.0f;
    }

    public boolean canZoomOut() {
        if (this.mImageType == 1 || this.mImageType == 2) {
            return false;
        }
        int size = this.cCm.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled()) {
            return false;
        }
        return size > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avR() {
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
                    int size = this.cCm.size();
                    if (size > 0) {
                        f3 = this.cCm.get(size - 1).floatValue();
                    } else {
                        f3 = this.cCn;
                    }
                    this.mCurrentScale = f3;
                }
                this.mMatrix.setScale(this.mCurrentScale, this.mCurrentScale);
                this.cCk = imageBitmap.getWidth() * this.mCurrentScale;
                this.cCl = imageBitmap.getHeight() * this.mCurrentScale;
                float width = this.cCp * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.cCp;
                this.cCE = this.mTop;
                this.cCF = 0;
                float f4 = this.cCk < ((float) this.mViewWidth) ? (int) ((this.mViewWidth - this.cCk) / 2.0f) : 0.0f;
                if (this.cCl < this.mViewHeight) {
                    f2 = (int) ((this.mViewHeight - this.cCl) / 2.0f);
                    if (this.cCt == 1 && f2 > this.mTop) {
                        f2 = this.mTop;
                    }
                    this.cCE = (int) (this.mTop - f2);
                    this.cCF = this.mTop - this.cCE;
                } else {
                    f2 = 0.0f;
                }
                this.cCG = (int) f4;
                this.mMatrix.postTranslate(f4, f2);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    int width2 = i > getWidth() ? getWidth() : i;
                    if (this.cCk <= screenWidth) {
                        width2 = 0;
                    } else if (this.cCk > screenWidth && this.cCk / 2.0f < screenWidth) {
                        width2 = (int) (width2 - (this.cCk / 4.0f));
                    }
                    scrollX = width2;
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.cCk - width) / 2.0f);
                    }
                    if (this.cCk <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.cCk) {
                        scrollX = (int) (this.cCk - getWidth());
                    }
                }
                if (scrollX > 0 && this.cCk - scrollX < getWidth()) {
                    scrollX = (int) (this.cCk - getWidth());
                }
                int i3 = this.mMode == 2 ? ((int) ((this.cCl - height) / 2.0f)) + scrollY : scrollY;
                if (this.cCl <= getHeight()) {
                    i3 = 0;
                } else if (getHeight() + i3 > this.cCl) {
                    i3 = (int) (this.cCl - getHeight());
                }
                setHorizontalScrollBarEnabled(false);
                setVerticalScrollBarEnabled(false);
                if (scrollX < 0) {
                    scrollX = 0;
                }
                scrollTo(scrollX, i3 >= 0 ? i3 : 0);
                setImageMatrix(this.mMatrix);
                avI();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Animation {
        private boolean cDb = false;
        private boolean cDc = false;
        private long cDd;
        private long cDe;
        private long cDf;
        private long cDg;
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
            this.cDd = f;
            this.cDe = f2;
            this.cDf = Math.abs((f * 1000.0f) / 2500.0f);
            this.cDg = Math.abs((f2 * 1000.0f) / 2500.0f);
            setDuration(Math.max(this.cDf, this.cDg));
            setInterpolator(DragImageView.this.cCO);
            this.mStartX = DragImageView.this.getScrollX();
            this.mStartY = DragImageView.this.getScrollY();
            this.cDb = true;
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
            if (this.cDf > this.cDg) {
                j = ((float) this.cDf) * f;
            } else {
                j = ((float) this.cDg) * f;
            }
            float f2 = ((float) (j > this.cDf ? this.cDf : j)) / 1000.0f;
            if (this.cDd > 0) {
                i = this.mStartX - ((int) (f2 * (((float) this.cDd) - ((2500.0f * f2) / 2.0f))));
            } else {
                i = this.mStartX - ((int) (f2 * (((float) this.cDd) + ((2500.0f * f2) / 2.0f))));
            }
            if (j > this.cDg) {
                j = this.cDg;
            }
            float f3 = ((float) j) / 1000.0f;
            if (this.cDe > 0) {
                i2 = this.mStartY - ((int) (f3 * (((float) this.cDe) - ((2500.0f * f3) / 2.0f))));
            } else {
                i2 = this.mStartY - ((int) (f3 * (((float) this.cDe) + ((2500.0f * f3) / 2.0f))));
            }
            if (DragImageView.this.cCl + DragImageView.this.mTop + DragImageView.this.mBottom > DragImageView.this.getHeight()) {
                if (i2 < (-DragImageView.this.cCE)) {
                    i2 = -DragImageView.this.cCE;
                }
                if (DragImageView.this.getHeight() + i2 > DragImageView.this.cCl + DragImageView.this.mBottom + DragImageView.this.cCF) {
                    i2 = (int) ((DragImageView.this.cCl - DragImageView.this.getHeight()) + DragImageView.this.mBottom + DragImageView.this.cCF);
                }
            } else {
                i2 = 0;
            }
            if (DragImageView.this.cCk > DragImageView.this.getWidth()) {
                int width = ((float) (DragImageView.this.getWidth() + i)) > DragImageView.this.cCk ? (int) (DragImageView.this.cCk - DragImageView.this.getWidth()) : i;
                if (width >= 0) {
                    i3 = width;
                }
            }
            DragImageView.this.scrollTo(i3, i2);
            DragImageView.this.invalidate();
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            if (!this.cDc) {
                if (DragImageView.this.cCq) {
                    this.cDb = false;
                    return false;
                }
                try {
                    if (super.getTransformation(j, transformation)) {
                        return true;
                    }
                    this.cDb = false;
                    return false;
                } catch (Exception e) {
                    this.cDb = false;
                    return false;
                }
            }
            this.cDc = false;
            this.cDb = false;
            return false;
        }

        public boolean avV() {
            return this.cDb;
        }

        public void stopAnimation() {
            this.cDc = true;
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.cCv = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cll = onLongClickListener;
        if (this.cCM != null) {
            this.cCM.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setGifSetListener(e eVar) {
        this.clo = eVar;
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
    public void avS() {
        long j;
        c poll = this.cCS.poll();
        if (poll == null) {
            this.cCX = true;
            return;
        }
        this.cCX = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.cCR != null) {
            j = this.cCR.delay - (currentTimeMillis - this.cCW);
            this.cCT.offer(this.cCR);
        } else {
            j = 0;
        }
        this.cCR = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public c avT() {
        c poll = this.cCT.poll();
        if (poll == null) {
            poll = new c();
            try {
                poll.cDh = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
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
        return this.cCR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends Thread {
        private volatile boolean Ca;

        private b() {
            this.Ca = false;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (this.Ca && DragImageView.this.cCC != null && DragImageView.this.cCQ > 0 && DragImageView.this.width > 0 && DragImageView.this.height > 0) {
                try {
                    DragImageView.this.cCC.N(DragImageView.this.cCU);
                    c avT = DragImageView.this.avT();
                    if (avT.cDh == null || (avT.cDh.getWidth() != DragImageView.this.width && avT.cDh.getHeight() != DragImageView.this.height)) {
                        try {
                            avT.cDh = Bitmap.createBitmap(DragImageView.this.width, DragImageView.this.height, Bitmap.Config.ARGB_8888);
                        } catch (OutOfMemoryError e) {
                            TbadkCoreApplication.getInst().onAppMemoryLow();
                            try {
                                avT.cDh = Bitmap.createBitmap(DragImageView.this.width, DragImageView.this.height, Bitmap.Config.ARGB_4444);
                            } catch (OutOfMemoryError e2) {
                                TbadkCoreApplication.getInst().onAppMemoryLow();
                            } catch (Throwable th) {
                                BdLog.e(th.getMessage());
                            }
                        } catch (Throwable th2) {
                            BdLog.e(th2.getMessage());
                        }
                    }
                    DragImageView.this.cCC.a(avT.cDh, null);
                    avT.delay = DragImageView.this.cCC.O(DragImageView.this.cCU);
                    DragImageView.C(DragImageView.this);
                    if (avT.cDh == null) {
                        DragImageView.C(DragImageView.this);
                    }
                    DragImageView.this.cCU %= DragImageView.this.cCQ;
                    DragImageView.this.cCS.put(avT);
                    if (DragImageView.this.cCX) {
                        DragImageView.this.mHandler.sendEmptyMessage(1);
                    }
                } catch (Exception e3) {
                    return;
                }
            }
        }
    }

    public boolean avU() {
        return this.cCI;
    }

    public void setLoadBigImage(boolean z) {
        this.cCI = z;
    }

    public int getBottomOffset() {
        return this.cCF;
    }

    public int getLeftOffset() {
        return this.cCG;
    }
}
