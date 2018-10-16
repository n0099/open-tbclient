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
    private static final int aQN = l.aQ(TbadkCoreApplication.getInst()) / 5;
    private int PC;
    private View.OnLongClickListener aOZ;
    private e aPc;
    private int aPd;
    private boolean aQD;
    private float aQE;
    private Matrix aQF;
    private Rect aQG;
    private RectF aQH;
    private d aQM;
    public int azd;
    private int beL;
    private float beM;
    private float beN;
    private ArrayList<Float> beO;
    private float beP;
    private float beQ;
    private float beR;
    private boolean beS;
    private byte[] beT;
    private int beU;
    private int beV;
    private g beW;
    private View.OnClickListener beX;
    private a beY;
    private f beZ;
    private float bfa;
    private boolean bfc;
    private boolean bfd;
    private int bfe;
    private volatile com.baidu.adp.gif.b bff;
    private Bitmap bfg;
    private int bfh;
    private int bfi;
    private int bfj;
    private int bfk;
    private boolean bfl;
    private boolean bfm;
    private float bfn;
    private com.baidu.tbadk.widget.largeImage.logic.b bfo;
    private ImageUrlData bfp;
    private Interpolator bfq;
    private Rect bfr;
    private int bfs;
    private c bft;
    private BlockingLinkedDeque<c> bfu;
    private BlockingLinkedDeque<c> bfv;
    private volatile int bfw;
    private b bfx;
    private volatile long bfy;
    private volatile boolean bfz;
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
        public Bitmap bfJ;
        public int delay;
    }

    /* loaded from: classes.dex */
    public interface d {
        void Pr();

        void Ps();
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
        int i = dragImageView.bfw;
        dragImageView.bfw = i + 1;
        return i;
    }

    public void setIsHeadImage(boolean z) {
        this.bfm = z;
    }

    public void setImageUrlData(ImageUrlData imageUrlData) {
        this.bfp = imageUrlData;
    }

    public DragImageView(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.PC = 0;
        this.beL = 0;
        this.beS = false;
        this.beT = null;
        this.aPd = 0;
        this.beU = 1300;
        this.beV = 0;
        this.beW = null;
        this.beX = null;
        this.aOZ = null;
        this.aPc = null;
        this.bfa = 1.0f;
        this.azd = 0;
        this.mMode = 0;
        this.bfc = false;
        this.bfd = false;
        this.bfe = 0;
        this.bff = null;
        this.bfg = null;
        this.mPaint = new Paint(-16777216);
        this.mTop = 0;
        this.mBottom = 0;
        this.bfh = 0;
        this.bfi = 0;
        this.bfj = 0;
        this.bfk = 0;
        this.bfq = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.aQF = new Matrix();
        this.aQD = false;
        this.mRatio = 1.0f;
        this.aQE = 0.0f;
        this.aQH = new RectF();
        this.width = 0;
        this.height = 0;
        this.bfs = 0;
        this.bft = null;
        this.bfu = new BlockingLinkedDeque<>(5);
        this.bfv = new BlockingLinkedDeque<>(6);
        this.bfw = 0;
        this.bfy = 0L;
        this.bfz = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.DragImageView.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        DragImageView.this.Pn();
                        break;
                    case 1:
                        if (DragImageView.this.bfz) {
                            DragImageView.this.Pn();
                            break;
                        }
                        break;
                    case 2:
                        DragImageView.this.invalidate();
                        DragImageView.this.bfy = System.currentTimeMillis();
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
        this.PC = 0;
        this.beL = 0;
        this.beS = false;
        this.beT = null;
        this.aPd = 0;
        this.beU = 1300;
        this.beV = 0;
        this.beW = null;
        this.beX = null;
        this.aOZ = null;
        this.aPc = null;
        this.bfa = 1.0f;
        this.azd = 0;
        this.mMode = 0;
        this.bfc = false;
        this.bfd = false;
        this.bfe = 0;
        this.bff = null;
        this.bfg = null;
        this.mPaint = new Paint(-16777216);
        this.mTop = 0;
        this.mBottom = 0;
        this.bfh = 0;
        this.bfi = 0;
        this.bfj = 0;
        this.bfk = 0;
        this.bfq = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.aQF = new Matrix();
        this.aQD = false;
        this.mRatio = 1.0f;
        this.aQE = 0.0f;
        this.aQH = new RectF();
        this.width = 0;
        this.height = 0;
        this.bfs = 0;
        this.bft = null;
        this.bfu = new BlockingLinkedDeque<>(5);
        this.bfv = new BlockingLinkedDeque<>(6);
        this.bfw = 0;
        this.bfy = 0L;
        this.bfz = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.DragImageView.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        DragImageView.this.Pn();
                        break;
                    case 1:
                        if (DragImageView.this.bfz) {
                            DragImageView.this.Pn();
                            break;
                        }
                        break;
                    case 2:
                        DragImageView.this.invalidate();
                        DragImageView.this.bfy = System.currentTimeMillis();
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
        this.PC = 0;
        this.beL = 0;
        this.beS = false;
        this.beT = null;
        this.aPd = 0;
        this.beU = 1300;
        this.beV = 0;
        this.beW = null;
        this.beX = null;
        this.aOZ = null;
        this.aPc = null;
        this.bfa = 1.0f;
        this.azd = 0;
        this.mMode = 0;
        this.bfc = false;
        this.bfd = false;
        this.bfe = 0;
        this.bff = null;
        this.bfg = null;
        this.mPaint = new Paint(-16777216);
        this.mTop = 0;
        this.mBottom = 0;
        this.bfh = 0;
        this.bfi = 0;
        this.bfj = 0;
        this.bfk = 0;
        this.bfq = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.aQF = new Matrix();
        this.aQD = false;
        this.mRatio = 1.0f;
        this.aQE = 0.0f;
        this.aQH = new RectF();
        this.width = 0;
        this.height = 0;
        this.bfs = 0;
        this.bft = null;
        this.bfu = new BlockingLinkedDeque<>(5);
        this.bfv = new BlockingLinkedDeque<>(6);
        this.bfw = 0;
        this.bfy = 0L;
        this.bfz = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.DragImageView.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        DragImageView.this.Pn();
                        break;
                    case 1:
                        if (DragImageView.this.bfz) {
                            DragImageView.this.Pn();
                            break;
                        }
                        break;
                    case 2:
                        DragImageView.this.invalidate();
                        DragImageView.this.bfy = System.currentTimeMillis();
                        DragImageView.this.mHandler.sendEmptyMessage(0);
                        break;
                }
                return false;
            }
        });
        initData();
    }

    public void setDragToExitListener(d dVar) {
        this.aQM = dVar;
    }

    public int getImageType() {
        return this.azd;
    }

    public void setImageMode(int i) {
        this.beV = i;
    }

    public void setOffset(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.aPd = i;
    }

    public boolean OZ() {
        if (this.bfo != null) {
            return this.bfo.OZ();
        }
        return false;
    }

    public void Pa() {
        this.bfd = false;
        this.beS = false;
        this.mMode = 3;
        Pg();
        if (this.mCurrentScale < this.beP) {
            this.mCurrentScale = this.beP;
            Pm();
        }
        invalidate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.bfo != null && this.bfo.onTouchEvent(motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.beS = true;
                this.bfc = false;
                this.bfd = false;
                break;
            case 1:
                Pa();
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
            this.bfa = t(motionEvent);
            if (this.bfa > 10.0f) {
                this.mMode = 2;
            }
        }
        if (this.mMode == 2 || !this.mGestureDetector.onTouchEvent(motionEvent)) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.bfc = true;
                        this.bfd = true;
                        if (this.azd != 1 && this.azd != 2) {
                            float t = t(motionEvent);
                            if (t >= 0.0f && Math.abs(this.bfa - t) >= 10.0f) {
                                if (Math.abs(this.bfa - t) > 100.0f) {
                                    this.bfa = t;
                                    break;
                                } else {
                                    float f2 = t / this.bfa;
                                    this.bfa = t;
                                    this.beR = this.mCurrentScale;
                                    this.mCurrentScale *= f2;
                                    if (this.mCurrentScale > this.beQ) {
                                        this.mCurrentScale = this.beQ;
                                    }
                                    float minScaleValue = getMinScaleValue();
                                    if (this.mCurrentScale < minScaleValue) {
                                        this.mCurrentScale = minScaleValue;
                                    }
                                    Pm();
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
        return this.bfo != null ? this.bfo.getMinScaleValue() : this.beP / 4.0f;
    }

    public float t(MotionEvent motionEvent) {
        return CompatibleUtile.getInstance().getSpacing(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            this.PC = i3 - i;
            this.beL = i4 - i2;
            Pc();
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public boolean Pb() {
        if (this.bfo != null) {
            return this.bfo.Qa();
        }
        return this.beP == this.mCurrentScale;
    }

    protected float h(Bitmap bitmap) {
        if (this.bfo != null) {
            return this.bfo.Qe();
        }
        if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            return 1.0f;
        }
        if (this.beV == 0) {
            float width = this.PC / bitmap.getWidth();
            float height = this.beL / bitmap.getHeight();
            if (this.bfm) {
                if (this.azd == 2) {
                    return 2.5f;
                }
                return Math.min(width, height);
            } else if (this.azd != 2) {
                float f2 = this.bfn;
                float f3 = f2 >= 1.0f ? f2 : 1.0f;
                if (bitmap.getWidth() * f3 >= this.PC || bitmap.getHeight() * f3 >= this.beL) {
                    return Math.min(width, height);
                }
                return f3;
            } else {
                return 1.0f;
            }
        }
        return Math.max(this.PC / bitmap.getWidth(), ((this.beL - this.mTop) - this.mBottom) / bitmap.getHeight());
    }

    protected float i(Bitmap bitmap) {
        if (this.bfo != null) {
            return this.bfo.Qf();
        }
        float f2 = 1.0f;
        if (bitmap != null && !bitmap.isRecycled() && bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
            f2 = (float) Math.sqrt(this.beU / (bitmap.getWidth() * bitmap.getHeight()));
            if (f2 > 10.0f) {
                return 10.0f;
            }
        }
        return f2;
    }

    private void Pc() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            this.beP = h(imageBitmap);
            this.beQ = i(imageBitmap);
            this.beO.clear();
            this.beO.add(Float.valueOf(this.beP));
            this.mCurrentScale = this.beP;
            this.beR = this.mCurrentScale;
            Pm();
            return;
        }
        this.beM = 0.0f;
        this.beN = 0.0f;
        this.beP = 1.0f;
        this.beQ = 1.0f;
        this.mCurrentScale = 1.0f;
        this.beR = this.mCurrentScale;
        this.beO.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    private void Pd() {
        if (this.beW != null) {
            this.beW.a(this, canZoomIn(), canZoomOut());
        }
    }

    public void setOnSizeChangedListener(g gVar) {
        this.beW = gVar;
    }

    public void setOnImageScrollListener(f fVar) {
        this.beZ = fVar;
    }

    public byte[] getImageData() {
        return this.beT;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getMeasuredHeight() != 0 && getMeasuredWidth() != 0 && this.bfo != null) {
            this.bfo.Qc();
        }
    }

    public void setImageData(Bitmap bitmap, byte[] bArr) {
        this.beT = bArr;
        if (this.bfo != null) {
            this.bfo.a(bitmap, bArr);
        }
        setImageBitmap(bitmap);
    }

    public void Pe() {
        if (this.bfo == null) {
            this.bfo = new com.baidu.tbadk.widget.largeImage.logic.b(this);
            this.bfo.setOnClickListener(this.beX);
            this.bfo.setOnLongClickListener(this.aOZ);
        }
    }

    public void setImageLoadCallBack(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
        if (this.bfo != null) {
            this.bfo.a(aVar);
        }
    }

    public boolean Pf() {
        return (getImageBitmap() == null || this.bfo == null) ? false : true;
    }

    public Bitmap getGifCache() {
        return this.bfg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        boolean z;
        if (this.bfo == null || !this.bfo.b(canvas, getImageBitmap())) {
            if (this.azd == 2 && this.bfk != 0 && !this.beY.Pq()) {
                int width = getWidth();
                int height = getHeight();
                Drawable drawable = getDrawable();
                float f2 = 0.0f;
                float f3 = height * 0.3f;
                float f4 = width;
                float f5 = (1.0f - 0.3f) * height;
                if (this.bfm && drawable != null) {
                    Rect bounds = drawable.getBounds();
                    int i = bounds.right - bounds.left;
                    int i2 = bounds.bottom - bounds.top;
                    f2 = (width / 2) - (i * 2.5f);
                    f3 = (height / 2) - (i2 * 2.5f);
                    f4 = (i * 2.5f) + (width / 2);
                    f5 = (i2 * 2.5f) + (height / 2);
                }
                this.mPaint.setColor(al.getColor(this.bfk));
                canvas.drawRect(f2, f3, f4, f5, this.mPaint);
                this.mPaint.setColor(-16777216);
            }
            if (this.mMode == 3 && this.aQD) {
                this.aQD = false;
                this.aQF.reset();
                if (this.aQE < aQN) {
                    this.mMode = 0;
                } else {
                    this.mMode = 4;
                    Jl();
                }
            }
            if (this.azd == 0 && this.aQD && this.aQG != null && this.bfp != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                if (this.aQH == null) {
                    this.aQH = new RectF();
                }
                this.aQF.mapRect(this.aQH, new RectF(this.aQG));
                Bitmap imageBitmap = getImageBitmap();
                if (imageBitmap != null && !imageBitmap.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.bfr, this.aQH, (Paint) null);
                }
            } else if (this.mMode == 4 && this.aQG != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                Bitmap imageBitmap2 = getImageBitmap();
                if (imageBitmap2 != null && !imageBitmap2.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.bfr, this.aQH, (Paint) null);
                }
            } else {
                super.onDraw(canvas);
            }
            if (this.azd == 1 && this.bfg != null && !this.bfg.isRecycled()) {
                int width2 = this.bfg.getWidth();
                int height2 = this.bfg.getHeight();
                int width3 = getWidth();
                int height3 = getHeight();
                int i3 = (width3 - width2) >> 1;
                int i4 = (height3 - height2) >> 1;
                float f6 = this.bfn;
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
                if (this.bfe == 1 && this.bff != null && this.bft != null && this.bft.bfJ != null) {
                    if (z) {
                        canvas.drawBitmap(this.bft.bfJ, i3, i4, (Paint) null);
                    } else {
                        canvas.drawBitmap(this.bft.bfJ, this.mMatrix, this.mPaint);
                    }
                    invalidate();
                } else if (z) {
                    canvas.drawBitmap(this.bfg, i3, i4, (Paint) null);
                } else {
                    canvas.drawBitmap(this.bfg, this.mMatrix, this.mPaint);
                }
            }
        }
    }

    public void play() {
        com.baidu.adp.widget.ImageView.a aVar;
        if (this.azd == 1) {
            if (this.bff == null) {
                if (this.bfx != null) {
                    this.bfx.Ep = false;
                    this.bfx.interrupt();
                    this.bfx = null;
                }
                if (this.beT != null) {
                    try {
                        aVar = a.C0015a.hy().g(this.beT, 0, this.beT.length);
                    } catch (StackOverflowError e2) {
                        aVar = null;
                    }
                    if (aVar == null || aVar.getGif() == null) {
                        com.baidu.tbadk.core.d.a.a("gifplay", -1L, -1, "DragImageView.play", -1, "decode error", new Object[0]);
                        return;
                    }
                    this.bff = aVar.getGif();
                    if (this.bff != null) {
                        this.bfe = 1;
                        this.width = this.bff.getWidth();
                        this.height = this.bff.getHeight();
                        this.bfw = 0;
                        this.bfs = this.bff.getFrameCount();
                    } else {
                        this.bfe = 0;
                    }
                } else {
                    return;
                }
            }
            if (this.bff != null) {
                if (this.bfx == null || (this.bfx != null && !this.bfx.Ep)) {
                    this.bfz = true;
                    this.bfx = new b();
                    this.bfu.clear();
                    this.bfv.clear();
                    this.bfx.Ep = true;
                    this.bfx.start();
                }
            }
        }
    }

    public void pause() {
        if (this.azd == 1) {
            if (this.bfx != null) {
                this.bfx.Ep = false;
                this.bfx.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.azd == 1) {
            if (this.bfx != null) {
                this.bfx.Ep = false;
                this.bfx.interrupt();
                this.bfx = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.bfz = true;
            this.bft = null;
            this.bfv.clear();
            this.bfu.clear();
            this.width = 0;
            this.height = 0;
            this.bfw = 0;
            this.bfs = 0;
            this.bff = null;
        }
    }

    private void initData() {
        this.bfn = l.aR(getContext());
        this.beU = l.aQ(getContext()) * l.aO(getContext()) * 2;
        if (this.beU < 1690000) {
            this.beU = 1690000;
        }
        this.beM = 0.0f;
        this.beN = 0.0f;
        this.beO = new ArrayList<>();
        this.beP = 1.0f;
        this.beQ = 1.0f;
        this.mCurrentScale = 1.0f;
        this.beR = this.mCurrentScale;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.beY = new a();
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWillNotDraw(false);
        scrollTo(0, 0);
        this.mGestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.DragImageView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                if (DragImageView.this.azd != 2 && (Math.abs(f2) > 200.0f || Math.abs(f3) > 200.0f)) {
                    DragImageView.this.beY.m(f2, f3);
                    DragImageView.this.startAnimation(DragImageView.this.beY);
                }
                return super.onFling(motionEvent, motionEvent2, f2, f3);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (DragImageView.this.azd != 1 && DragImageView.this.azd != 2) {
                    DragImageView.this.mMode = 2;
                    if (DragImageView.this.mCurrentScale > DragImageView.this.beP) {
                        DragImageView.this.mCurrentScale = DragImageView.this.beP;
                        DragImageView.this.beR = DragImageView.this.mCurrentScale;
                        DragImageView.this.Pm();
                        return true;
                    }
                    DragImageView.this.mCurrentScale = DragImageView.this.beP * 2.0f;
                    DragImageView.this.a(true, (int) motionEvent.getX(), (int) motionEvent.getY());
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (DragImageView.this.beX != null && !DragImageView.this.bfc) {
                    DragImageView.this.beX.onClick(DragImageView.this);
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
                DragImageView.this.bfc = true;
                if (DragImageView.this.beV == 0 && DragImageView.this.bfd) {
                    return false;
                }
                int scrollX = DragImageView.this.getScrollX();
                int scrollY = DragImageView.this.getScrollY();
                if (DragImageView.this.beM >= DragImageView.this.getWidth()) {
                    scrollX = (int) (scrollX + f2);
                    if (DragImageView.this.beV == 0) {
                        i = scrollX >= 0 ? scrollX : 0;
                        if (DragImageView.this.getWidth() + i > DragImageView.this.beM) {
                            i = (int) (DragImageView.this.beM - DragImageView.this.getWidth());
                        }
                        if (DragImageView.this.beN + DragImageView.this.mTop + DragImageView.this.mBottom < DragImageView.this.getHeight()) {
                            i2 = (int) (scrollY + f3);
                            if (DragImageView.this.beV == 0) {
                                if (i2 < (-DragImageView.this.bfh)) {
                                    i2 = -DragImageView.this.bfh;
                                }
                                if (DragImageView.this.getHeight() + i2 > DragImageView.this.beN + DragImageView.this.mBottom + DragImageView.this.bfi) {
                                    i2 = (int) ((DragImageView.this.beN - DragImageView.this.getHeight()) + DragImageView.this.mBottom + DragImageView.this.bfi);
                                }
                            }
                        } else {
                            i2 = scrollY;
                        }
                        if (i == DragImageView.this.getScrollX() || i2 != DragImageView.this.getScrollY()) {
                            DragImageView.this.scrollTo(i, i2);
                            DragImageView.this.invalidate();
                            if (DragImageView.this.beZ != null) {
                                DragImageView.this.beZ.a(DragImageView.this, i, i2);
                            }
                        }
                        return true;
                    }
                }
                i = scrollX;
                if (DragImageView.this.beN + DragImageView.this.mTop + DragImageView.this.mBottom < DragImageView.this.getHeight()) {
                }
                if (i == DragImageView.this.getScrollX()) {
                }
                DragImageView.this.scrollTo(i, i2);
                DragImageView.this.invalidate();
                if (DragImageView.this.beZ != null) {
                }
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (DragImageView.this.aOZ != null && !DragImageView.this.bfc) {
                    DragImageView.this.aOZ.onLongClick(DragImageView.this);
                }
                super.onLongPress(motionEvent);
            }
        });
    }

    private void Jl() {
        if (this.bfp == null) {
            if (this.aQM != null) {
                this.aQM.Ps();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.bfp.getSourceImageRectInScreen();
        if (sourceImageRectInScreen == null) {
            if (this.aQM != null) {
                this.aQM.Ps();
                return;
            }
            return;
        }
        this.aQH.bottom = (((sourceImageRectInScreen.bottom - sourceImageRectInScreen.top) / (sourceImageRectInScreen.right - sourceImageRectInScreen.left)) * (this.aQH.right - this.aQH.left)) + this.aQH.top;
        final float[] fArr = {(this.aQH.left + this.aQH.right) / 2.0f, (this.aQH.top + this.aQH.bottom) / 2.0f};
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
                    DragImageView.this.aQH = DragImageView.this.h(floatValue, animatedFraction, sourceImageRectInScreen.right - sourceImageRectInScreen.left, sourceImageRectInScreen.bottom - sourceImageRectInScreen.top);
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
                DragImageView.this.aQD = false;
                DragImageView.this.mMode = 4;
                DragImageView.this.invalidate();
                if (DragImageView.this.aQM != null) {
                    DragImageView.this.aQM.Ps();
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

    private void Pg() {
        int i = 0;
        int scrollX = getScrollX();
        if (this.beM >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.beM) {
                scrollX = (int) (this.beM - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.beN + this.mTop + this.mBottom >= getHeight()) {
            i = scrollY < (-this.bfh) ? -this.bfh : scrollY;
            if (getHeight() + i > this.beN + this.mBottom + this.bfi) {
                i = (int) ((this.beN - getHeight()) + this.mBottom + this.bfi);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
            if (this.beZ != null) {
                this.beZ.a(this, scrollX, i);
            }
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.bfo != null) {
            this.bfo.Qb();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.beM;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.beN;
    }

    public boolean Ph() {
        if (this.azd == 1 || this.azd == 2) {
            return true;
        }
        return !this.bfd && getScrollX() >= ((int) (this.beM - ((float) getWidth()))) + (-1);
    }

    public boolean Pi() {
        if (this.azd == 1 || this.azd == 2) {
            return true;
        }
        return !this.bfd && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.beY.Pq()) {
            this.beY.stopAnimation();
        }
        this.bfk = 0;
        super.setImageBitmap(bitmap);
        Pc();
        this.azd = 0;
        if (this.aQG == null) {
            int measuredWidth = getMeasuredWidth();
            float measuredWidth2 = ((1.0f * getMeasuredWidth()) / bitmap.getWidth()) * bitmap.getHeight();
            if (measuredWidth2 > getMeasuredHeight()) {
                measuredWidth2 = getMeasuredHeight();
            }
            RectF h = h(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
            this.aQG = new Rect((int) h.left, (int) h.top, (int) h.right, (int) h.bottom);
        }
        if (this.bfr == null) {
            this.bfr = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
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
            if (this.beY.Pq()) {
                this.beY.stopAnimation();
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            super.setImageBitmap(bitmap);
            super.setImageMatrix(this.mMatrix);
            scrollTo(scrollX, scrollY);
            this.azd = 0;
        }
    }

    public void setGifData(byte[] bArr, Bitmap bitmap) {
        if (this.beY.Pq()) {
            this.beY.stopAnimation();
        }
        super.setImageDrawable(null);
        stop();
        Pc();
        this.azd = 1;
        this.bfg = bitmap;
        this.beT = bArr;
        if (this.aPc != null) {
            this.aPc.a(this);
        }
    }

    public void onDestroy() {
        if (this.beY.Pq()) {
            this.beY.stopAnimation();
        }
        super.setImageDrawable(null);
        this.beT = null;
        this.bfg = null;
        stop();
        if (this.bff != null) {
            this.bff.close();
            this.bff = null;
        }
        if (this.bfo != null) {
            this.bfo.release();
            System.gc();
        }
    }

    public void release() {
        if (this.beY.Pq()) {
            this.beY.stopAnimation();
        }
        stop();
        super.setImageDrawable(null);
        this.bfg = null;
    }

    public void setDefaultBitmap() {
        if (this.beY.Pq()) {
            this.beY.stopAnimation();
        }
        try {
            if (this.bfm) {
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
        this.azd = 2;
        Pc();
    }

    public void Pj() {
        if (this.azd != 1 && this.azd != 2) {
            int size = this.beO.size();
            if (size > 0) {
                this.beO.add(Float.valueOf(this.beO.get(size - 1).floatValue() * 1.25f));
            } else {
                this.beO.add(Float.valueOf(this.beP));
            }
            Pm();
        }
    }

    public void Pk() {
        if (this.azd != 1 && this.azd != 2) {
            int size = this.beO.size();
            if (size > 1) {
                this.beO.remove(size - 1);
            }
            Pm();
        }
    }

    public void Pl() {
        Pd();
        if (this.azd != 1 && this.azd != 2 && this.mCurrentScale != this.beP) {
            this.beO.clear();
            this.beO.add(Float.valueOf(this.beP));
            this.mCurrentScale = this.beP;
            this.beR = this.mCurrentScale;
            Pm();
        }
    }

    public boolean canZoomIn() {
        if (this.azd == 1 || this.azd == 2) {
            return false;
        }
        int size = this.beO.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.beO.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.beU) && floatValue <= 5.0f;
    }

    public boolean canZoomOut() {
        if (this.azd == 1 || this.azd == 2) {
            return false;
        }
        int size = this.beO.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled()) {
            return false;
        }
        return size > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pm() {
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
                    int size = this.beO.size();
                    if (size > 0) {
                        f3 = this.beO.get(size - 1).floatValue();
                    } else {
                        f3 = this.beP;
                    }
                    this.mCurrentScale = f3;
                }
                this.mMatrix.setScale(this.mCurrentScale, this.mCurrentScale);
                this.beM = imageBitmap.getWidth() * this.mCurrentScale;
                this.beN = imageBitmap.getHeight() * this.mCurrentScale;
                float width = this.beR * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.beR;
                this.bfh = this.mTop;
                this.bfi = 0;
                float f4 = this.beM < ((float) this.PC) ? (int) ((this.PC - this.beM) / 2.0f) : 0.0f;
                if (this.beN < this.beL) {
                    f2 = (int) ((this.beL - this.beN) / 2.0f);
                    if (this.beV == 1 && f2 > this.mTop) {
                        f2 = this.mTop;
                    }
                    this.bfh = (int) (this.mTop - f2);
                    this.bfi = this.mTop - this.bfh;
                } else {
                    f2 = 0.0f;
                }
                this.bfj = (int) f4;
                this.mMatrix.postTranslate(f4, f2);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    int width2 = i > getWidth() ? getWidth() : i;
                    if (this.beM <= screenWidth) {
                        width2 = 0;
                    } else if (this.beM > screenWidth && this.beM / 2.0f < screenWidth) {
                        width2 = (int) (width2 - (this.beM / 4.0f));
                    }
                    scrollX = width2;
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.beM - width) / 2.0f);
                    }
                    if (this.beM <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.beM) {
                        scrollX = (int) (this.beM - getWidth());
                    }
                }
                if (scrollX > 0 && this.beM - scrollX < getWidth()) {
                    scrollX = (int) (this.beM - getWidth());
                }
                int i3 = this.mMode == 2 ? ((int) ((this.beN - height) / 2.0f)) + scrollY : scrollY;
                if (this.beN <= getHeight()) {
                    i3 = 0;
                } else if (getHeight() + i3 > this.beN) {
                    i3 = (int) (this.beN - getHeight());
                }
                setHorizontalScrollBarEnabled(false);
                setVerticalScrollBarEnabled(false);
                if (scrollX < 0) {
                    scrollX = 0;
                }
                scrollTo(scrollX, i3 >= 0 ? i3 : 0);
                setImageMatrix(this.mMatrix);
                Pd();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Animation {
        private boolean bfD = false;
        private boolean bfE = false;
        private long bfF;
        private long bfG;
        private long bfH;
        private long bfI;
        private int mStartX;
        private int mStartY;

        public a() {
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
            this.bfF = f;
            this.bfG = f2;
            this.bfH = Math.abs((f * 1000.0f) / 2500.0f);
            this.bfI = Math.abs((f2 * 1000.0f) / 2500.0f);
            setDuration(Math.max(this.bfH, this.bfI));
            setInterpolator(DragImageView.this.bfq);
            this.mStartX = DragImageView.this.getScrollX();
            this.mStartY = DragImageView.this.getScrollY();
            this.bfD = true;
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
            if (this.bfH > this.bfI) {
                j = ((float) this.bfH) * f;
            } else {
                j = ((float) this.bfI) * f;
            }
            float f2 = ((float) (j > this.bfH ? this.bfH : j)) / 1000.0f;
            if (this.bfF > 0) {
                i = this.mStartX - ((int) (f2 * (((float) this.bfF) - ((2500.0f * f2) / 2.0f))));
            } else {
                i = this.mStartX - ((int) (f2 * (((float) this.bfF) + ((2500.0f * f2) / 2.0f))));
            }
            if (j > this.bfI) {
                j = this.bfI;
            }
            float f3 = ((float) j) / 1000.0f;
            if (this.bfG > 0) {
                i2 = this.mStartY - ((int) (f3 * (((float) this.bfG) - ((2500.0f * f3) / 2.0f))));
            } else {
                i2 = this.mStartY - ((int) (f3 * (((float) this.bfG) + ((2500.0f * f3) / 2.0f))));
            }
            if (DragImageView.this.beN + DragImageView.this.mTop + DragImageView.this.mBottom > DragImageView.this.getHeight()) {
                if (i2 < (-DragImageView.this.bfh)) {
                    i2 = -DragImageView.this.bfh;
                }
                if (DragImageView.this.getHeight() + i2 > DragImageView.this.beN + DragImageView.this.mBottom + DragImageView.this.bfi) {
                    i2 = (int) ((DragImageView.this.beN - DragImageView.this.getHeight()) + DragImageView.this.mBottom + DragImageView.this.bfi);
                }
            } else {
                i2 = 0;
            }
            if (DragImageView.this.beM > DragImageView.this.getWidth()) {
                int width = ((float) (DragImageView.this.getWidth() + i)) > DragImageView.this.beM ? (int) (DragImageView.this.beM - DragImageView.this.getWidth()) : i;
                if (width >= 0) {
                    i3 = width;
                }
            }
            DragImageView.this.scrollTo(i3, i2);
            DragImageView.this.invalidate();
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            if (!this.bfE) {
                if (DragImageView.this.beS) {
                    this.bfD = false;
                    return false;
                }
                try {
                    if (super.getTransformation(j, transformation)) {
                        return true;
                    }
                    this.bfD = false;
                    return false;
                } catch (Exception e) {
                    this.bfD = false;
                    return false;
                }
            }
            this.bfE = false;
            this.bfD = false;
            return false;
        }

        public boolean Pq() {
            return this.bfD;
        }

        public void stopAnimation() {
            this.bfE = true;
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.beX = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aOZ = onLongClickListener;
        if (this.bfo != null) {
            this.bfo.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setGifSetListener(e eVar) {
        this.aPc = eVar;
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
    public void Pn() {
        long j;
        c poll = this.bfu.poll();
        if (poll == null) {
            this.bfz = true;
            return;
        }
        this.bfz = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.bft != null) {
            j = this.bft.delay - (currentTimeMillis - this.bfy);
            this.bfv.offer(this.bft);
        } else {
            j = 0;
        }
        this.bft = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public c Po() {
        c poll = this.bfv.poll();
        if (poll == null) {
            poll = new c();
            try {
                poll.bfJ = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
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
        return this.bft;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends Thread {
        private volatile boolean Ep;

        private b() {
            this.Ep = false;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (this.Ep && DragImageView.this.bff != null && DragImageView.this.bfs > 0 && DragImageView.this.width > 0 && DragImageView.this.height > 0) {
                try {
                    DragImageView.this.bff.V(DragImageView.this.bfw);
                    c Po = DragImageView.this.Po();
                    if (Po.bfJ == null || (Po.bfJ.getWidth() != DragImageView.this.width && Po.bfJ.getHeight() != DragImageView.this.height)) {
                        try {
                            Po.bfJ = Bitmap.createBitmap(DragImageView.this.width, DragImageView.this.height, Bitmap.Config.ARGB_8888);
                        } catch (OutOfMemoryError e) {
                            TbadkCoreApplication.getInst().onAppMemoryLow();
                            try {
                                Po.bfJ = Bitmap.createBitmap(DragImageView.this.width, DragImageView.this.height, Bitmap.Config.ARGB_4444);
                            } catch (OutOfMemoryError e2) {
                                TbadkCoreApplication.getInst().onAppMemoryLow();
                            } catch (Throwable th) {
                                BdLog.e(th.getMessage());
                            }
                        } catch (Throwable th2) {
                            BdLog.e(th2.getMessage());
                        }
                    }
                    DragImageView.this.bff.a(Po.bfJ, null);
                    Po.delay = DragImageView.this.bff.W(DragImageView.this.bfw);
                    DragImageView.B(DragImageView.this);
                    if (Po.bfJ == null) {
                        DragImageView.B(DragImageView.this);
                    }
                    DragImageView.this.bfw %= DragImageView.this.bfs;
                    DragImageView.this.bfu.put(Po);
                    if (DragImageView.this.bfz) {
                        DragImageView.this.mHandler.sendEmptyMessage(1);
                    }
                } catch (Exception e3) {
                    return;
                }
            }
        }
    }

    public boolean Pp() {
        return this.bfl;
    }

    public void setLoadBigImage(boolean z) {
        this.bfl = z;
    }

    public int getBottomOffset() {
        return this.bfi;
    }

    public int getLeftOffset() {
        return this.bfj;
    }
}
