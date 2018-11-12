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
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class DragImageView extends ImageView {
    private static final String TAG = DragImageView.class.getSimpleName();
    private static final int aRD = l.aQ(TbadkCoreApplication.getInst()) / 5;
    private int PE;
    private View.OnLongClickListener aPP;
    private e aPS;
    private int aPT;
    private d aRC;
    private boolean aRt;
    private float aRu;
    private Matrix aRv;
    private Rect aRw;
    private RectF aRx;
    public int azS;
    private float bfA;
    private ArrayList<Float> bfB;
    private float bfC;
    private float bfD;
    private float bfE;
    private boolean bfF;
    private byte[] bfG;
    private int bfH;
    private int bfI;
    private g bfJ;
    private View.OnClickListener bfK;
    private a bfL;
    private f bfM;
    private float bfN;
    private boolean bfO;
    private boolean bfP;
    private int bfQ;
    private volatile com.baidu.adp.gif.b bfR;
    private Bitmap bfS;
    private int bfT;
    private int bfU;
    private int bfV;
    private int bfW;
    private boolean bfX;
    private boolean bfY;
    private float bfZ;
    private int bfy;
    private float bfz;
    private com.baidu.tbadk.widget.largeImage.logic.b bga;
    private ImageUrlData bgb;
    private Interpolator bgc;
    private Rect bgd;
    private int bge;
    private c bgf;
    private BlockingLinkedDeque<c> bgg;
    private BlockingLinkedDeque<c> bgh;
    private volatile int bgi;
    private b bgj;
    private volatile long bgk;
    private volatile boolean bgl;
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
    private int width;

    /* loaded from: classes.dex */
    public static class c {
        public Bitmap bgw;
        public int delay;
    }

    /* loaded from: classes.dex */
    public interface d {
        void PA();

        void PB();
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

    static /* synthetic */ int B(DragImageView dragImageView) {
        int i = dragImageView.bgi;
        dragImageView.bgi = i + 1;
        return i;
    }

    public void setIsHeadImage(boolean z) {
        this.bfY = z;
    }

    public void setImageUrlData(ImageUrlData imageUrlData) {
        this.bgb = imageUrlData;
    }

    public DragImageView(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.PE = 0;
        this.bfy = 0;
        this.bfF = false;
        this.bfG = null;
        this.aPT = 0;
        this.bfH = 1300;
        this.bfI = 0;
        this.bfJ = null;
        this.bfK = null;
        this.aPP = null;
        this.aPS = null;
        this.bfN = 1.0f;
        this.azS = 0;
        this.mMode = 0;
        this.bfO = false;
        this.bfP = false;
        this.bfQ = 0;
        this.bfR = null;
        this.bfS = null;
        this.mPaint = new Paint(-16777216);
        this.mTop = 0;
        this.mBottom = 0;
        this.bfT = 0;
        this.bfU = 0;
        this.bfV = 0;
        this.bfW = 0;
        this.bgc = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.aRv = new Matrix();
        this.aRt = false;
        this.mRatio = 1.0f;
        this.aRu = 0.0f;
        this.aRx = new RectF();
        this.width = 0;
        this.height = 0;
        this.bge = 0;
        this.bgf = null;
        this.bgg = new BlockingLinkedDeque<>(5);
        this.bgh = new BlockingLinkedDeque<>(6);
        this.bgi = 0;
        this.bgk = 0L;
        this.bgl = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.DragImageView.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        DragImageView.this.Pw();
                        break;
                    case 1:
                        if (DragImageView.this.bgl) {
                            DragImageView.this.Pw();
                            break;
                        }
                        break;
                    case 2:
                        DragImageView.this.invalidate();
                        DragImageView.this.bgk = System.currentTimeMillis();
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
        this.PE = 0;
        this.bfy = 0;
        this.bfF = false;
        this.bfG = null;
        this.aPT = 0;
        this.bfH = 1300;
        this.bfI = 0;
        this.bfJ = null;
        this.bfK = null;
        this.aPP = null;
        this.aPS = null;
        this.bfN = 1.0f;
        this.azS = 0;
        this.mMode = 0;
        this.bfO = false;
        this.bfP = false;
        this.bfQ = 0;
        this.bfR = null;
        this.bfS = null;
        this.mPaint = new Paint(-16777216);
        this.mTop = 0;
        this.mBottom = 0;
        this.bfT = 0;
        this.bfU = 0;
        this.bfV = 0;
        this.bfW = 0;
        this.bgc = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.aRv = new Matrix();
        this.aRt = false;
        this.mRatio = 1.0f;
        this.aRu = 0.0f;
        this.aRx = new RectF();
        this.width = 0;
        this.height = 0;
        this.bge = 0;
        this.bgf = null;
        this.bgg = new BlockingLinkedDeque<>(5);
        this.bgh = new BlockingLinkedDeque<>(6);
        this.bgi = 0;
        this.bgk = 0L;
        this.bgl = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.DragImageView.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        DragImageView.this.Pw();
                        break;
                    case 1:
                        if (DragImageView.this.bgl) {
                            DragImageView.this.Pw();
                            break;
                        }
                        break;
                    case 2:
                        DragImageView.this.invalidate();
                        DragImageView.this.bgk = System.currentTimeMillis();
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
        this.PE = 0;
        this.bfy = 0;
        this.bfF = false;
        this.bfG = null;
        this.aPT = 0;
        this.bfH = 1300;
        this.bfI = 0;
        this.bfJ = null;
        this.bfK = null;
        this.aPP = null;
        this.aPS = null;
        this.bfN = 1.0f;
        this.azS = 0;
        this.mMode = 0;
        this.bfO = false;
        this.bfP = false;
        this.bfQ = 0;
        this.bfR = null;
        this.bfS = null;
        this.mPaint = new Paint(-16777216);
        this.mTop = 0;
        this.mBottom = 0;
        this.bfT = 0;
        this.bfU = 0;
        this.bfV = 0;
        this.bfW = 0;
        this.bgc = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.aRv = new Matrix();
        this.aRt = false;
        this.mRatio = 1.0f;
        this.aRu = 0.0f;
        this.aRx = new RectF();
        this.width = 0;
        this.height = 0;
        this.bge = 0;
        this.bgf = null;
        this.bgg = new BlockingLinkedDeque<>(5);
        this.bgh = new BlockingLinkedDeque<>(6);
        this.bgi = 0;
        this.bgk = 0L;
        this.bgl = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.DragImageView.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        DragImageView.this.Pw();
                        break;
                    case 1:
                        if (DragImageView.this.bgl) {
                            DragImageView.this.Pw();
                            break;
                        }
                        break;
                    case 2:
                        DragImageView.this.invalidate();
                        DragImageView.this.bgk = System.currentTimeMillis();
                        DragImageView.this.mHandler.sendEmptyMessage(0);
                        break;
                }
                return false;
            }
        });
        initData();
    }

    public void setDragToExitListener(d dVar) {
        this.aRC = dVar;
    }

    public int getImageType() {
        return this.azS;
    }

    public void setImageMode(int i) {
        this.bfI = i;
    }

    public void setOffset(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.aPT = i;
    }

    public boolean Pi() {
        if (this.bga != null) {
            return this.bga.Pi();
        }
        return false;
    }

    public void Pj() {
        this.bfP = false;
        this.bfF = false;
        this.mMode = 3;
        Pp();
        if (this.mCurrentScale < this.bfC) {
            this.mCurrentScale = this.bfC;
            Pv();
        }
        invalidate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.bga != null && this.bga.onTouchEvent(motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.bfF = true;
                this.bfO = false;
                this.bfP = false;
                break;
            case 1:
                Pj();
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
            this.bfN = t(motionEvent);
            if (this.bfN > 10.0f) {
                this.mMode = 2;
            }
        }
        if (this.mMode == 2 || !this.mGestureDetector.onTouchEvent(motionEvent)) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.bfO = true;
                        this.bfP = true;
                        if (this.azS != 1 && this.azS != 2) {
                            float t = t(motionEvent);
                            if (t >= 0.0f && Math.abs(this.bfN - t) >= 10.0f) {
                                if (Math.abs(this.bfN - t) > 100.0f) {
                                    this.bfN = t;
                                    break;
                                } else {
                                    float f2 = t / this.bfN;
                                    this.bfN = t;
                                    this.bfE = this.mCurrentScale;
                                    this.mCurrentScale *= f2;
                                    if (this.mCurrentScale > this.bfD) {
                                        this.mCurrentScale = this.bfD;
                                    }
                                    float minScaleValue = getMinScaleValue();
                                    if (this.mCurrentScale < minScaleValue) {
                                        this.mCurrentScale = minScaleValue;
                                    }
                                    Pv();
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
        return this.bga != null ? this.bga.getMinScaleValue() : this.bfC / 4.0f;
    }

    public float t(MotionEvent motionEvent) {
        return CompatibleUtile.getInstance().getSpacing(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            this.PE = i3 - i;
            this.bfy = i4 - i2;
            Pl();
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public boolean Pk() {
        if (this.bga != null) {
            return this.bga.Qj();
        }
        return this.bfC == this.mCurrentScale;
    }

    protected float h(Bitmap bitmap) {
        if (this.bga != null) {
            return this.bga.Qn();
        }
        if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            return 1.0f;
        }
        if (this.bfI == 0) {
            float width = this.PE / bitmap.getWidth();
            float height = this.bfy / bitmap.getHeight();
            if (this.bfY) {
                if (this.azS == 2) {
                    return 2.5f;
                }
                return Math.min(width, height);
            } else if (this.azS != 2) {
                float f2 = this.bfZ;
                float f3 = f2 >= 1.0f ? f2 : 1.0f;
                if (bitmap.getWidth() * f3 >= this.PE || bitmap.getHeight() * f3 >= this.bfy) {
                    return Math.min(width, height);
                }
                return f3;
            } else {
                return 1.0f;
            }
        }
        return Math.max(this.PE / bitmap.getWidth(), ((this.bfy - this.mTop) - this.mBottom) / bitmap.getHeight());
    }

    protected float i(Bitmap bitmap) {
        if (this.bga != null) {
            return this.bga.Qo();
        }
        float f2 = 1.0f;
        if (bitmap != null && !bitmap.isRecycled() && bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
            f2 = (float) Math.sqrt(this.bfH / (bitmap.getWidth() * bitmap.getHeight()));
            if (f2 > 10.0f) {
                return 10.0f;
            }
        }
        return f2;
    }

    private void Pl() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            this.bfC = h(imageBitmap);
            this.bfD = i(imageBitmap);
            this.bfB.clear();
            this.bfB.add(Float.valueOf(this.bfC));
            this.mCurrentScale = this.bfC;
            this.bfE = this.mCurrentScale;
            Pv();
            return;
        }
        this.bfz = 0.0f;
        this.bfA = 0.0f;
        this.bfC = 1.0f;
        this.bfD = 1.0f;
        this.mCurrentScale = 1.0f;
        this.bfE = this.mCurrentScale;
        this.bfB.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    private void Pm() {
        if (this.bfJ != null) {
            this.bfJ.a(this, canZoomIn(), canZoomOut());
        }
    }

    public void setOnSizeChangedListener(g gVar) {
        this.bfJ = gVar;
    }

    public void setOnImageScrollListener(f fVar) {
        this.bfM = fVar;
    }

    public byte[] getImageData() {
        return this.bfG;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getMeasuredHeight() != 0 && getMeasuredWidth() != 0 && this.bga != null) {
            this.bga.Ql();
        }
    }

    public void setImageData(Bitmap bitmap, byte[] bArr) {
        this.bfG = bArr;
        if (this.bga != null) {
            this.bga.a(bitmap, bArr);
        }
        setImageBitmap(bitmap);
    }

    public void Pn() {
        if (this.bga == null) {
            this.bga = new com.baidu.tbadk.widget.largeImage.logic.b(this);
            this.bga.setOnClickListener(this.bfK);
            this.bga.setOnLongClickListener(this.aPP);
        }
    }

    public void setImageLoadCallBack(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
        if (this.bga != null) {
            this.bga.a(aVar);
        }
    }

    public boolean Po() {
        return (getImageBitmap() == null || this.bga == null) ? false : true;
    }

    public Bitmap getGifCache() {
        return this.bfS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        boolean z;
        if (this.bga == null || !this.bga.b(canvas, getImageBitmap())) {
            if (this.azS == 2 && this.bfW != 0 && !this.bfL.Pz()) {
                int width = getWidth();
                int height = getHeight();
                Drawable drawable = getDrawable();
                float f2 = 0.0f;
                float f3 = height * 0.3f;
                float f4 = width;
                float f5 = (1.0f - 0.3f) * height;
                if (this.bfY && drawable != null) {
                    Rect bounds = drawable.getBounds();
                    int i = bounds.right - bounds.left;
                    int i2 = bounds.bottom - bounds.top;
                    f2 = (width / 2) - (i * 2.5f);
                    f3 = (height / 2) - (i2 * 2.5f);
                    f4 = (i * 2.5f) + (width / 2);
                    f5 = (i2 * 2.5f) + (height / 2);
                }
                this.mPaint.setColor(al.getColor(this.bfW));
                canvas.drawRect(f2, f3, f4, f5, this.mPaint);
                this.mPaint.setColor(-16777216);
            }
            if (this.mMode == 3 && this.aRt) {
                this.aRt = false;
                this.aRv.reset();
                if (this.aRu < aRD) {
                    this.mMode = 0;
                } else {
                    this.mMode = 4;
                    Jx();
                }
            }
            if (this.azS == 0 && this.aRt && this.aRw != null && this.bgb != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                if (this.aRx == null) {
                    this.aRx = new RectF();
                }
                this.aRv.mapRect(this.aRx, new RectF(this.aRw));
                Bitmap imageBitmap = getImageBitmap();
                if (imageBitmap != null && !imageBitmap.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.bgd, this.aRx, (Paint) null);
                }
            } else if (this.mMode == 4 && this.aRw != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                Bitmap imageBitmap2 = getImageBitmap();
                if (imageBitmap2 != null && !imageBitmap2.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.bgd, this.aRx, (Paint) null);
                }
            } else {
                super.onDraw(canvas);
            }
            if (this.azS == 1 && this.bfS != null && !this.bfS.isRecycled()) {
                int width2 = this.bfS.getWidth();
                int height2 = this.bfS.getHeight();
                int width3 = getWidth();
                int height3 = getHeight();
                int i3 = (width3 - width2) >> 1;
                int i4 = (height3 - height2) >> 1;
                float f6 = this.bfZ;
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
                if (this.bfQ == 1 && this.bfR != null && this.bgf != null && this.bgf.bgw != null) {
                    if (z) {
                        canvas.drawBitmap(this.bgf.bgw, i3, i4, (Paint) null);
                    } else {
                        canvas.drawBitmap(this.bgf.bgw, this.mMatrix, this.mPaint);
                    }
                    invalidate();
                } else if (z) {
                    canvas.drawBitmap(this.bfS, i3, i4, (Paint) null);
                } else {
                    canvas.drawBitmap(this.bfS, this.mMatrix, this.mPaint);
                }
            }
        }
    }

    public void play() {
        com.baidu.adp.widget.ImageView.a aVar;
        if (this.azS == 1) {
            if (this.bfR == null) {
                if (this.bgj != null) {
                    this.bgj.Et = false;
                    this.bgj.interrupt();
                    this.bgj = null;
                }
                if (this.bfG != null) {
                    try {
                        aVar = a.C0015a.hx().g(this.bfG, 0, this.bfG.length);
                    } catch (StackOverflowError e2) {
                        aVar = null;
                    }
                    if (aVar == null || aVar.getGif() == null) {
                        com.baidu.tbadk.core.d.a.a("gifplay", -1L, -1, "DragImageView.play", -1, "decode error", new Object[0]);
                        return;
                    }
                    this.bfR = aVar.getGif();
                    if (this.bfR != null) {
                        this.bfQ = 1;
                        this.width = this.bfR.getWidth();
                        this.height = this.bfR.getHeight();
                        this.bgi = 0;
                        this.bge = this.bfR.getFrameCount();
                    } else {
                        this.bfQ = 0;
                    }
                } else {
                    return;
                }
            }
            if (this.bfR != null) {
                if (this.bgj == null || (this.bgj != null && !this.bgj.Et)) {
                    this.bgl = true;
                    this.bgj = new b();
                    this.bgg.clear();
                    this.bgh.clear();
                    this.bgj.Et = true;
                    this.bgj.start();
                }
            }
        }
    }

    public void pause() {
        if (this.azS == 1) {
            if (this.bgj != null) {
                this.bgj.Et = false;
                this.bgj.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.azS == 1) {
            if (this.bgj != null) {
                this.bgj.Et = false;
                this.bgj.interrupt();
                this.bgj = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.bgl = true;
            this.bgf = null;
            this.bgh.clear();
            this.bgg.clear();
            this.width = 0;
            this.height = 0;
            this.bgi = 0;
            this.bge = 0;
            this.bfR = null;
        }
    }

    private void initData() {
        this.bfZ = l.aR(getContext());
        this.bfH = l.aQ(getContext()) * l.aO(getContext()) * 2;
        if (this.bfH < 1690000) {
            this.bfH = 1690000;
        }
        this.bfz = 0.0f;
        this.bfA = 0.0f;
        this.bfB = new ArrayList<>();
        this.bfC = 1.0f;
        this.bfD = 1.0f;
        this.mCurrentScale = 1.0f;
        this.bfE = this.mCurrentScale;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.bfL = new a();
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWillNotDraw(false);
        scrollTo(0, 0);
        this.mGestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.DragImageView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                if (DragImageView.this.azS != 2 && (Math.abs(f2) > 200.0f || Math.abs(f3) > 200.0f)) {
                    DragImageView.this.bfL.p(f2, f3);
                    DragImageView.this.startAnimation(DragImageView.this.bfL);
                }
                return super.onFling(motionEvent, motionEvent2, f2, f3);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (DragImageView.this.azS != 1 && DragImageView.this.azS != 2) {
                    DragImageView.this.mMode = 2;
                    if (DragImageView.this.mCurrentScale > DragImageView.this.bfC) {
                        DragImageView.this.mCurrentScale = DragImageView.this.bfC;
                        DragImageView.this.bfE = DragImageView.this.mCurrentScale;
                        DragImageView.this.Pv();
                        return true;
                    }
                    DragImageView.this.mCurrentScale = DragImageView.this.bfC * 2.0f;
                    DragImageView.this.a(true, (int) motionEvent.getX(), (int) motionEvent.getY());
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (DragImageView.this.bfK != null && !DragImageView.this.bfO) {
                    DragImageView.this.bfK.onClick(DragImageView.this);
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
                DragImageView.this.bfO = true;
                if (DragImageView.this.bfI == 0 && DragImageView.this.bfP) {
                    return false;
                }
                int scrollX = DragImageView.this.getScrollX();
                int scrollY = DragImageView.this.getScrollY();
                if (DragImageView.this.bfz >= DragImageView.this.getWidth()) {
                    scrollX = (int) (scrollX + f2);
                    if (DragImageView.this.bfI == 0) {
                        i = scrollX >= 0 ? scrollX : 0;
                        if (DragImageView.this.getWidth() + i > DragImageView.this.bfz) {
                            i = (int) (DragImageView.this.bfz - DragImageView.this.getWidth());
                        }
                        if (DragImageView.this.bfA + DragImageView.this.mTop + DragImageView.this.mBottom < DragImageView.this.getHeight()) {
                            i2 = (int) (scrollY + f3);
                            if (DragImageView.this.bfI == 0) {
                                if (i2 < (-DragImageView.this.bfT)) {
                                    i2 = -DragImageView.this.bfT;
                                }
                                if (DragImageView.this.getHeight() + i2 > DragImageView.this.bfA + DragImageView.this.mBottom + DragImageView.this.bfU) {
                                    i2 = (int) ((DragImageView.this.bfA - DragImageView.this.getHeight()) + DragImageView.this.mBottom + DragImageView.this.bfU);
                                }
                            }
                        } else {
                            i2 = scrollY;
                        }
                        if (i == DragImageView.this.getScrollX() || i2 != DragImageView.this.getScrollY()) {
                            DragImageView.this.scrollTo(i, i2);
                            DragImageView.this.invalidate();
                            if (DragImageView.this.bfM != null) {
                                DragImageView.this.bfM.a(DragImageView.this, i, i2);
                            }
                        }
                        return true;
                    }
                }
                i = scrollX;
                if (DragImageView.this.bfA + DragImageView.this.mTop + DragImageView.this.mBottom < DragImageView.this.getHeight()) {
                }
                if (i == DragImageView.this.getScrollX()) {
                }
                DragImageView.this.scrollTo(i, i2);
                DragImageView.this.invalidate();
                if (DragImageView.this.bfM != null) {
                }
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (DragImageView.this.aPP != null && !DragImageView.this.bfO) {
                    DragImageView.this.aPP.onLongClick(DragImageView.this);
                }
                super.onLongPress(motionEvent);
            }
        });
    }

    private void Jx() {
        if (this.bgb == null) {
            if (this.aRC != null) {
                this.aRC.PB();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.bgb.getSourceImageRectInScreen();
        if (sourceImageRectInScreen == null) {
            if (this.aRC != null) {
                this.aRC.PB();
                return;
            }
            return;
        }
        this.aRx.bottom = (((sourceImageRectInScreen.bottom - sourceImageRectInScreen.top) / (sourceImageRectInScreen.right - sourceImageRectInScreen.left)) * (this.aRx.right - this.aRx.left)) + this.aRx.top;
        final float[] fArr = {(this.aRx.left + this.aRx.right) / 2.0f, (this.aRx.top + this.aRx.bottom) / 2.0f};
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
                    DragImageView.this.aRx = DragImageView.this.h(floatValue, animatedFraction, sourceImageRectInScreen.right - sourceImageRectInScreen.left, sourceImageRectInScreen.bottom - sourceImageRectInScreen.top);
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
                DragImageView.this.aRt = false;
                DragImageView.this.mMode = 4;
                DragImageView.this.invalidate();
                if (DragImageView.this.aRC != null) {
                    DragImageView.this.aRC.PB();
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

    private void Pp() {
        int i = 0;
        int scrollX = getScrollX();
        if (this.bfz >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.bfz) {
                scrollX = (int) (this.bfz - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.bfA + this.mTop + this.mBottom >= getHeight()) {
            i = scrollY < (-this.bfT) ? -this.bfT : scrollY;
            if (getHeight() + i > this.bfA + this.mBottom + this.bfU) {
                i = (int) ((this.bfA - getHeight()) + this.mBottom + this.bfU);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
            if (this.bfM != null) {
                this.bfM.a(this, scrollX, i);
            }
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.bga != null) {
            this.bga.Qk();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.bfz;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.bfA;
    }

    public boolean Pq() {
        if (this.azS == 1 || this.azS == 2) {
            return true;
        }
        return !this.bfP && getScrollX() >= ((int) (this.bfz - ((float) getWidth()))) + (-1);
    }

    public boolean Pr() {
        if (this.azS == 1 || this.azS == 2) {
            return true;
        }
        return !this.bfP && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.bfL.Pz()) {
            this.bfL.stopAnimation();
        }
        this.bfW = 0;
        super.setImageBitmap(bitmap);
        Pl();
        this.azS = 0;
        if (this.aRw == null) {
            int measuredWidth = getMeasuredWidth();
            float measuredWidth2 = ((1.0f * getMeasuredWidth()) / bitmap.getWidth()) * bitmap.getHeight();
            if (measuredWidth2 > getMeasuredHeight()) {
                measuredWidth2 = getMeasuredHeight();
            }
            RectF h = h(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
            this.aRw = new Rect((int) h.left, (int) h.top, (int) h.right, (int) h.bottom);
        }
        if (this.bgd == null) {
            this.bgd = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        }
    }

    public void j(Bitmap bitmap) {
        Bitmap imageBitmap = getImageBitmap();
        if (bitmap != null && !bitmap.isRecycled()) {
            if (imageBitmap != null && (imageBitmap.getWidth() != bitmap.getWidth() || imageBitmap.getHeight() != bitmap.getHeight())) {
                setImageBitmap(bitmap);
                super.setImageMatrix(this.mMatrix);
                return;
            }
            if (this.bfL.Pz()) {
                this.bfL.stopAnimation();
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            super.setImageBitmap(bitmap);
            super.setImageMatrix(this.mMatrix);
            scrollTo(scrollX, scrollY);
            this.azS = 0;
        }
    }

    public void setGifData(byte[] bArr, Bitmap bitmap) {
        if (this.bfL.Pz()) {
            this.bfL.stopAnimation();
        }
        super.setImageDrawable(null);
        stop();
        Pl();
        this.azS = 1;
        this.bfS = bitmap;
        this.bfG = bArr;
        if (this.aPS != null) {
            this.aPS.a(this);
        }
    }

    public void onDestroy() {
        if (this.bfL.Pz()) {
            this.bfL.stopAnimation();
        }
        super.setImageDrawable(null);
        this.bfG = null;
        this.bfS = null;
        stop();
        if (this.bfR != null) {
            this.bfR.close();
            this.bfR = null;
        }
        if (this.bga != null) {
            this.bga.release();
            System.gc();
        }
    }

    public void release() {
        if (this.bfL.Pz()) {
            this.bfL.stopAnimation();
        }
        stop();
        super.setImageDrawable(null);
        this.bfS = null;
    }

    public void setDefaultBitmap() {
        if (this.bfL.Pz()) {
            this.bfL.stopAnimation();
        }
        try {
            if (this.bfY) {
                super.setImageBitmap(BitmapHelper.getCashBitmap(e.f.icon_default_avatar100));
            } else {
                super.setImageBitmap(BitmapHelper.getCashBitmap(e.f.btn_see_default));
            }
        } catch (OutOfMemoryError e2) {
            TbadkCoreApplication.getInst().onAppMemoryLow();
            System.gc();
            super.setImageBitmap(null);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
        this.azS = 2;
        Pl();
    }

    public void Ps() {
        if (this.azS != 1 && this.azS != 2) {
            int size = this.bfB.size();
            if (size > 0) {
                this.bfB.add(Float.valueOf(this.bfB.get(size - 1).floatValue() * 1.25f));
            } else {
                this.bfB.add(Float.valueOf(this.bfC));
            }
            Pv();
        }
    }

    public void Pt() {
        if (this.azS != 1 && this.azS != 2) {
            int size = this.bfB.size();
            if (size > 1) {
                this.bfB.remove(size - 1);
            }
            Pv();
        }
    }

    public void Pu() {
        Pm();
        if (this.azS != 1 && this.azS != 2 && this.mCurrentScale != this.bfC) {
            this.bfB.clear();
            this.bfB.add(Float.valueOf(this.bfC));
            this.mCurrentScale = this.bfC;
            this.bfE = this.mCurrentScale;
            Pv();
        }
    }

    public boolean canZoomIn() {
        if (this.azS == 1 || this.azS == 2) {
            return false;
        }
        int size = this.bfB.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.bfB.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.bfH) && floatValue <= 5.0f;
    }

    public boolean canZoomOut() {
        if (this.azS == 1 || this.azS == 2) {
            return false;
        }
        int size = this.bfB.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled()) {
            return false;
        }
        return size > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pv() {
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
                    int size = this.bfB.size();
                    if (size > 0) {
                        f3 = this.bfB.get(size - 1).floatValue();
                    } else {
                        f3 = this.bfC;
                    }
                    this.mCurrentScale = f3;
                }
                this.mMatrix.setScale(this.mCurrentScale, this.mCurrentScale);
                this.bfz = imageBitmap.getWidth() * this.mCurrentScale;
                this.bfA = imageBitmap.getHeight() * this.mCurrentScale;
                float width = this.bfE * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.bfE;
                this.bfT = this.mTop;
                this.bfU = 0;
                float f4 = this.bfz < ((float) this.PE) ? (int) ((this.PE - this.bfz) / 2.0f) : 0.0f;
                if (this.bfA < this.bfy) {
                    f2 = (int) ((this.bfy - this.bfA) / 2.0f);
                    if (this.bfI == 1 && f2 > this.mTop) {
                        f2 = this.mTop;
                    }
                    this.bfT = (int) (this.mTop - f2);
                    this.bfU = this.mTop - this.bfT;
                } else {
                    f2 = 0.0f;
                }
                this.bfV = (int) f4;
                this.mMatrix.postTranslate(f4, f2);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    int width2 = i > getWidth() ? getWidth() : i;
                    if (this.bfz <= screenWidth) {
                        width2 = 0;
                    } else if (this.bfz > screenWidth && this.bfz / 2.0f < screenWidth) {
                        width2 = (int) (width2 - (this.bfz / 4.0f));
                    }
                    scrollX = width2;
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.bfz - width) / 2.0f);
                    }
                    if (this.bfz <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.bfz) {
                        scrollX = (int) (this.bfz - getWidth());
                    }
                }
                if (scrollX > 0 && this.bfz - scrollX < getWidth()) {
                    scrollX = (int) (this.bfz - getWidth());
                }
                int i3 = this.mMode == 2 ? ((int) ((this.bfA - height) / 2.0f)) + scrollY : scrollY;
                if (this.bfA <= getHeight()) {
                    i3 = 0;
                } else if (getHeight() + i3 > this.bfA) {
                    i3 = (int) (this.bfA - getHeight());
                }
                setHorizontalScrollBarEnabled(false);
                setVerticalScrollBarEnabled(false);
                if (scrollX < 0) {
                    scrollX = 0;
                }
                scrollTo(scrollX, i3 >= 0 ? i3 : 0);
                setImageMatrix(this.mMatrix);
                Pm();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Animation {
        private boolean bgp = false;
        private boolean bgq = false;
        private long bgr;
        private long bgt;
        private long bgu;
        private long bgv;
        private int mStartX;
        private int mStartY;

        public a() {
        }

        public void p(float f, float f2) {
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
            this.bgr = f;
            this.bgt = f2;
            this.bgu = Math.abs((f * 1000.0f) / 2500.0f);
            this.bgv = Math.abs((f2 * 1000.0f) / 2500.0f);
            setDuration(Math.max(this.bgu, this.bgv));
            setInterpolator(DragImageView.this.bgc);
            this.mStartX = DragImageView.this.getScrollX();
            this.mStartY = DragImageView.this.getScrollY();
            this.bgp = true;
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
            if (this.bgu > this.bgv) {
                j = ((float) this.bgu) * f;
            } else {
                j = ((float) this.bgv) * f;
            }
            float f2 = ((float) (j > this.bgu ? this.bgu : j)) / 1000.0f;
            if (this.bgr > 0) {
                i = this.mStartX - ((int) (f2 * (((float) this.bgr) - ((2500.0f * f2) / 2.0f))));
            } else {
                i = this.mStartX - ((int) (f2 * (((float) this.bgr) + ((2500.0f * f2) / 2.0f))));
            }
            if (j > this.bgv) {
                j = this.bgv;
            }
            float f3 = ((float) j) / 1000.0f;
            if (this.bgt > 0) {
                i2 = this.mStartY - ((int) (f3 * (((float) this.bgt) - ((2500.0f * f3) / 2.0f))));
            } else {
                i2 = this.mStartY - ((int) (f3 * (((float) this.bgt) + ((2500.0f * f3) / 2.0f))));
            }
            if (DragImageView.this.bfA + DragImageView.this.mTop + DragImageView.this.mBottom > DragImageView.this.getHeight()) {
                if (i2 < (-DragImageView.this.bfT)) {
                    i2 = -DragImageView.this.bfT;
                }
                if (DragImageView.this.getHeight() + i2 > DragImageView.this.bfA + DragImageView.this.mBottom + DragImageView.this.bfU) {
                    i2 = (int) ((DragImageView.this.bfA - DragImageView.this.getHeight()) + DragImageView.this.mBottom + DragImageView.this.bfU);
                }
            } else {
                i2 = 0;
            }
            if (DragImageView.this.bfz > DragImageView.this.getWidth()) {
                int width = ((float) (DragImageView.this.getWidth() + i)) > DragImageView.this.bfz ? (int) (DragImageView.this.bfz - DragImageView.this.getWidth()) : i;
                if (width >= 0) {
                    i3 = width;
                }
            }
            DragImageView.this.scrollTo(i3, i2);
            DragImageView.this.invalidate();
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            if (!this.bgq) {
                if (DragImageView.this.bfF) {
                    this.bgp = false;
                    return false;
                }
                try {
                    if (super.getTransformation(j, transformation)) {
                        return true;
                    }
                    this.bgp = false;
                    return false;
                } catch (Exception e) {
                    this.bgp = false;
                    return false;
                }
            }
            this.bgq = false;
            this.bgp = false;
            return false;
        }

        public boolean Pz() {
            return this.bgp;
        }

        public void stopAnimation() {
            this.bgq = true;
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.bfK = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aPP = onLongClickListener;
        if (this.bga != null) {
            this.bga.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setGifSetListener(e eVar) {
        this.aPS = eVar;
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
    public void Pw() {
        long j;
        c poll = this.bgg.poll();
        if (poll == null) {
            this.bgl = true;
            return;
        }
        this.bgl = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.bgf != null) {
            j = this.bgf.delay - (currentTimeMillis - this.bgk);
            this.bgh.offer(this.bgf);
        } else {
            j = 0;
        }
        this.bgf = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public c Px() {
        c poll = this.bgh.poll();
        if (poll == null) {
            poll = new c();
            try {
                poll.bgw = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
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
        return this.bgf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends Thread {
        private volatile boolean Et;

        private b() {
            this.Et = false;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (this.Et && DragImageView.this.bfR != null && DragImageView.this.bge > 0 && DragImageView.this.width > 0 && DragImageView.this.height > 0) {
                try {
                    DragImageView.this.bfR.am(DragImageView.this.bgi);
                    c Px = DragImageView.this.Px();
                    if (Px.bgw == null || (Px.bgw.getWidth() != DragImageView.this.width && Px.bgw.getHeight() != DragImageView.this.height)) {
                        try {
                            Px.bgw = Bitmap.createBitmap(DragImageView.this.width, DragImageView.this.height, Bitmap.Config.ARGB_8888);
                        } catch (OutOfMemoryError e) {
                            TbadkCoreApplication.getInst().onAppMemoryLow();
                            try {
                                Px.bgw = Bitmap.createBitmap(DragImageView.this.width, DragImageView.this.height, Bitmap.Config.ARGB_4444);
                            } catch (OutOfMemoryError e2) {
                                TbadkCoreApplication.getInst().onAppMemoryLow();
                            } catch (Throwable th) {
                                BdLog.e(th.getMessage());
                            }
                        } catch (Throwable th2) {
                            BdLog.e(th2.getMessage());
                        }
                    }
                    DragImageView.this.bfR.a(Px.bgw, null);
                    Px.delay = DragImageView.this.bfR.an(DragImageView.this.bgi);
                    DragImageView.B(DragImageView.this);
                    if (Px.bgw == null) {
                        DragImageView.B(DragImageView.this);
                    }
                    DragImageView.this.bgi %= DragImageView.this.bge;
                    DragImageView.this.bgg.put(Px);
                    if (DragImageView.this.bgl) {
                        DragImageView.this.mHandler.sendEmptyMessage(1);
                    }
                } catch (Exception e3) {
                    return;
                }
            }
        }
    }

    public boolean Py() {
        return this.bfX;
    }

    public void setLoadBigImage(boolean z) {
        this.bfX = z;
    }

    public int getBottomOffset() {
        return this.bfU;
    }

    public int getLeftOffset() {
        return this.bfV;
    }
}
