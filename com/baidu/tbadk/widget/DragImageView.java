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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class DragImageView extends ImageView {
    private static final String TAG = DragImageView.class.getSimpleName();
    private static final int cpE = l.ah(TbadkCoreApplication.getInst()) / 5;
    private float cEA;
    private ArrayList<Float> cEB;
    private float cEC;
    private float cED;
    private float cEE;
    private boolean cEF;
    private byte[] cEG;
    private int cEH;
    private int cEI;
    private g cEJ;
    private View.OnClickListener cEK;
    private a cEL;
    private f cEM;
    private float cEN;
    private boolean cEO;
    private boolean cEP;
    private int cEQ;
    private volatile com.baidu.adp.gif.b cER;
    private Bitmap cES;
    private int cET;
    private int cEU;
    private int cEV;
    private int cEW;
    private boolean cEX;
    private boolean cEY;
    private boolean cEZ;
    private float cEz;
    private float cFa;
    private com.baidu.tbadk.widget.largeImage.logic.b cFb;
    private ImageUrlData cFc;
    private Interpolator cFd;
    private Rect cFe;
    private int cFf;
    private c cFg;
    private BlockingLinkedDeque<c> cFh;
    private BlockingLinkedDeque<c> cFi;
    private volatile int cFj;
    private b cFk;
    private volatile long cFl;
    private volatile boolean cFm;
    private View.OnLongClickListener cnB;
    private e cnE;
    private int cnJ;
    private d cpD;
    private boolean cpt;
    private float cpv;
    private Matrix cpw;
    private Rect cpx;
    private RectF cpy;
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
        public Bitmap cFw;
        public int delay;
    }

    /* loaded from: classes.dex */
    public interface d {
        void axv();

        void axw();

        void axx();
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
        int i = dragImageView.cFj;
        dragImageView.cFj = i + 1;
        return i;
    }

    public void setIsHeadImage(boolean z) {
        this.cEZ = z;
    }

    public void setImageUrlData(ImageUrlData imageUrlData) {
        this.cFc = imageUrlData;
    }

    public ImageUrlData getImageUrlData() {
        return this.cFc;
    }

    public void setCanScale(boolean z) {
        this.cEY = z;
    }

    public DragImageView(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.cEF = false;
        this.cEG = null;
        this.cnJ = 0;
        this.cEH = 1300;
        this.cEI = 0;
        this.cEJ = null;
        this.cEK = null;
        this.cnB = null;
        this.cnE = null;
        this.cEN = 1.0f;
        this.mImageType = 0;
        this.mMode = 0;
        this.cEO = false;
        this.cEP = false;
        this.cEQ = 0;
        this.cER = null;
        this.cES = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.cET = 0;
        this.cEU = 0;
        this.cEV = 0;
        this.cEW = 0;
        this.cEY = true;
        this.cFd = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.cpw = new Matrix();
        this.cpt = false;
        this.mRatio = 1.0f;
        this.cpv = 0.0f;
        this.cpy = new RectF();
        this.width = 0;
        this.height = 0;
        this.cFf = 0;
        this.cFg = null;
        this.cFh = new BlockingLinkedDeque<>(5);
        this.cFi = new BlockingLinkedDeque<>(6);
        this.cFj = 0;
        this.cFl = 0L;
        this.cFm = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.DragImageView.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        DragImageView.this.axr();
                        break;
                    case 1:
                        if (DragImageView.this.cFm) {
                            DragImageView.this.axr();
                            break;
                        }
                        break;
                    case 2:
                        DragImageView.this.invalidate();
                        DragImageView.this.cFl = System.currentTimeMillis();
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
        this.cEF = false;
        this.cEG = null;
        this.cnJ = 0;
        this.cEH = 1300;
        this.cEI = 0;
        this.cEJ = null;
        this.cEK = null;
        this.cnB = null;
        this.cnE = null;
        this.cEN = 1.0f;
        this.mImageType = 0;
        this.mMode = 0;
        this.cEO = false;
        this.cEP = false;
        this.cEQ = 0;
        this.cER = null;
        this.cES = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.cET = 0;
        this.cEU = 0;
        this.cEV = 0;
        this.cEW = 0;
        this.cEY = true;
        this.cFd = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.cpw = new Matrix();
        this.cpt = false;
        this.mRatio = 1.0f;
        this.cpv = 0.0f;
        this.cpy = new RectF();
        this.width = 0;
        this.height = 0;
        this.cFf = 0;
        this.cFg = null;
        this.cFh = new BlockingLinkedDeque<>(5);
        this.cFi = new BlockingLinkedDeque<>(6);
        this.cFj = 0;
        this.cFl = 0L;
        this.cFm = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.DragImageView.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        DragImageView.this.axr();
                        break;
                    case 1:
                        if (DragImageView.this.cFm) {
                            DragImageView.this.axr();
                            break;
                        }
                        break;
                    case 2:
                        DragImageView.this.invalidate();
                        DragImageView.this.cFl = System.currentTimeMillis();
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
        this.cEF = false;
        this.cEG = null;
        this.cnJ = 0;
        this.cEH = 1300;
        this.cEI = 0;
        this.cEJ = null;
        this.cEK = null;
        this.cnB = null;
        this.cnE = null;
        this.cEN = 1.0f;
        this.mImageType = 0;
        this.mMode = 0;
        this.cEO = false;
        this.cEP = false;
        this.cEQ = 0;
        this.cER = null;
        this.cES = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.cET = 0;
        this.cEU = 0;
        this.cEV = 0;
        this.cEW = 0;
        this.cEY = true;
        this.cFd = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.cpw = new Matrix();
        this.cpt = false;
        this.mRatio = 1.0f;
        this.cpv = 0.0f;
        this.cpy = new RectF();
        this.width = 0;
        this.height = 0;
        this.cFf = 0;
        this.cFg = null;
        this.cFh = new BlockingLinkedDeque<>(5);
        this.cFi = new BlockingLinkedDeque<>(6);
        this.cFj = 0;
        this.cFl = 0L;
        this.cFm = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.DragImageView.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        DragImageView.this.axr();
                        break;
                    case 1:
                        if (DragImageView.this.cFm) {
                            DragImageView.this.axr();
                            break;
                        }
                        break;
                    case 2:
                        DragImageView.this.invalidate();
                        DragImageView.this.cFl = System.currentTimeMillis();
                        DragImageView.this.mHandler.sendEmptyMessage(0);
                        break;
                }
                return false;
            }
        });
        initData();
    }

    public void setDragToExitListener(d dVar) {
        this.cpD = dVar;
    }

    public int getImageType() {
        return this.mImageType;
    }

    public void setImageMode(int i) {
        this.cEI = i;
    }

    public void setOffset(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.cnJ = i;
    }

    public boolean axb() {
        if (this.cFb != null) {
            return this.cFb.axb();
        }
        return false;
    }

    public void axc() {
        this.cEP = false;
        this.cEF = false;
        this.mMode = 3;
        axi();
        if (this.mCurrentScale < this.cEC) {
            this.mCurrentScale = this.cEC;
            axq();
        }
        invalidate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.cFb != null && this.cFb.onTouchEvent(motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.cEF = true;
                this.cEO = false;
                this.cEP = false;
                break;
            case 1:
                axc();
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
            this.cEN = x(motionEvent);
            if (this.cEN > 10.0f) {
                this.mMode = 2;
            }
        }
        if ((this.mMode == 2 || !this.mGestureDetector.onTouchEvent(motionEvent)) && this.cEY) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.cEO = true;
                        this.cEP = true;
                        if (this.mImageType != 1 && this.mImageType != 2) {
                            float x = x(motionEvent);
                            if (x >= 0.0f && Math.abs(this.cEN - x) >= 10.0f) {
                                if (Math.abs(this.cEN - x) > 100.0f) {
                                    this.cEN = x;
                                    break;
                                } else {
                                    float f2 = x / this.cEN;
                                    this.cEN = x;
                                    this.cEE = this.mCurrentScale;
                                    this.mCurrentScale *= f2;
                                    if (this.mCurrentScale > this.cED) {
                                        this.mCurrentScale = this.cED;
                                    }
                                    float minScaleValue = getMinScaleValue();
                                    if (this.mCurrentScale < minScaleValue) {
                                        this.mCurrentScale = minScaleValue;
                                    }
                                    axq();
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
        return this.cFb != null ? this.cFb.getMinScaleValue() : this.cEC / 4.0f;
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
            axe();
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public boolean axd() {
        if (this.cFb != null) {
            return this.cFb.aym();
        }
        return this.cEC == this.mCurrentScale;
    }

    protected float o(Bitmap bitmap) {
        if (this.cFb != null) {
            return this.cFb.ayq();
        }
        if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            return 1.0f;
        }
        if (this.cEI == 0) {
            float width = this.mViewWidth / bitmap.getWidth();
            float height = this.mViewHeight / bitmap.getHeight();
            if (this.cEZ) {
                if (this.mImageType == 2) {
                    return 2.5f;
                }
                return Math.min(width, height);
            } else if (this.mImageType != 2) {
                float f2 = this.cFa;
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
        if (this.cFb != null) {
            return this.cFb.ayr();
        }
        float f2 = 1.0f;
        if (bitmap != null && !bitmap.isRecycled() && bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
            f2 = (float) Math.sqrt(this.cEH / (bitmap.getWidth() * bitmap.getHeight()));
            if (f2 > 10.0f) {
                return 10.0f;
            }
        }
        return f2;
    }

    private void axe() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            this.cEC = o(imageBitmap);
            this.cED = p(imageBitmap);
            this.cEB.clear();
            this.cEB.add(Float.valueOf(this.cEC));
            this.mCurrentScale = this.cEC;
            this.cEE = this.mCurrentScale;
            axq();
            return;
        }
        this.cEz = 0.0f;
        this.cEA = 0.0f;
        this.cEC = 1.0f;
        this.cED = 1.0f;
        this.mCurrentScale = 1.0f;
        this.cEE = this.mCurrentScale;
        this.cEB.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    private void axf() {
        if (this.cEJ != null) {
            this.cEJ.a(this, axo(), axp());
        }
    }

    public void setOnSizeChangedListener(g gVar) {
        this.cEJ = gVar;
    }

    public void setOnImageScrollListener(f fVar) {
        this.cEM = fVar;
    }

    public byte[] getImageData() {
        return this.cEG;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getMeasuredHeight() != 0 && getMeasuredWidth() != 0 && this.cFb != null) {
            this.cFb.ayo();
        }
    }

    public void setImageData(Bitmap bitmap, byte[] bArr) {
        this.cEG = bArr;
        if (this.cFb != null) {
            this.cFb.a(bitmap, bArr);
        }
        setImageBitmap(bitmap);
    }

    public void axg() {
        if (this.cFb == null) {
            this.cFb = new com.baidu.tbadk.widget.largeImage.logic.b(this);
            this.cFb.setOnClickListener(this.cEK);
            this.cFb.setOnLongClickListener(this.cnB);
        }
    }

    public void setImageLoadCallBack(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
        if (this.cFb != null) {
            this.cFb.a(aVar);
        }
    }

    public boolean axh() {
        return (getImageBitmap() == null || this.cFb == null) ? false : true;
    }

    public Bitmap getGifCache() {
        return this.cES;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        boolean z;
        if (this.cFb == null || !this.cFb.b(canvas, getImageBitmap())) {
            if (this.mImageType == 2 && this.cEW != 0 && !this.cEL.axu()) {
                int width = getWidth();
                int height = getHeight();
                Drawable drawable = getDrawable();
                float f2 = 0.0f;
                float f3 = height * 0.3f;
                float f4 = width;
                float f5 = (1.0f - 0.3f) * height;
                if (this.cEZ && drawable != null) {
                    Rect bounds = drawable.getBounds();
                    int i = bounds.right - bounds.left;
                    int i2 = bounds.bottom - bounds.top;
                    f2 = (width / 2) - (i * 2.5f);
                    f3 = (height / 2) - (i2 * 2.5f);
                    f4 = (i * 2.5f) + (width / 2);
                    f5 = (i2 * 2.5f) + (height / 2);
                }
                this.mPaint.setColor(am.getColor(this.cEW));
                canvas.drawRect(f2, f3, f4, f5, this.mPaint);
                this.mPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
            }
            if (this.mMode == 3 && this.cpt) {
                this.cpt = false;
                this.cpw.reset();
                if (this.cpv < cpE) {
                    this.mMode = 0;
                } else {
                    this.mMode = 4;
                    aqN();
                }
            }
            if (this.mImageType == 0 && this.cpt && this.cpx != null && this.cFc != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                if (this.cpy == null) {
                    this.cpy = new RectF();
                }
                this.cpw.mapRect(this.cpy, new RectF(this.cpx));
                Bitmap imageBitmap = getImageBitmap();
                if (imageBitmap != null && !imageBitmap.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.cFe, this.cpy, (Paint) null);
                }
            } else if (this.mMode == 4 && this.cpx != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                Bitmap imageBitmap2 = getImageBitmap();
                if (imageBitmap2 != null && !imageBitmap2.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.cFe, this.cpy, (Paint) null);
                }
            } else {
                super.onDraw(canvas);
            }
            if (this.mImageType == 1 && this.cES != null && !this.cES.isRecycled()) {
                int width2 = this.cES.getWidth();
                int height2 = this.cES.getHeight();
                int width3 = getWidth();
                int height3 = getHeight();
                int i3 = (width3 - width2) >> 1;
                int i4 = (height3 - height2) >> 1;
                float f6 = this.cFa;
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
                if (this.cEQ == 1 && this.cER != null && this.cFg != null && this.cFg.cFw != null) {
                    if (z) {
                        canvas.drawBitmap(this.cFg.cFw, i3, i4, (Paint) null);
                    } else {
                        canvas.drawBitmap(this.cFg.cFw, this.mMatrix, this.mPaint);
                    }
                    invalidate();
                } else if (z) {
                    canvas.drawBitmap(this.cES, i3, i4, (Paint) null);
                } else {
                    canvas.drawBitmap(this.cES, this.mMatrix, this.mPaint);
                }
            }
        }
    }

    public void play() {
        com.baidu.adp.widget.ImageView.a aVar;
        if (this.mImageType == 1) {
            if (this.cER == null) {
                if (this.cFk != null) {
                    this.cFk.Cg = false;
                    this.cFk.interrupt();
                    this.cFk = null;
                }
                if (this.cEG != null) {
                    try {
                        aVar = a.C0013a.gy().g(this.cEG, 0, this.cEG.length);
                    } catch (StackOverflowError e2) {
                        aVar = null;
                    }
                    if (aVar == null || aVar.getGif() == null) {
                        com.baidu.tbadk.core.e.a.a("gifplay", -1L, -1, "DragImageView.play", -1, "decode error", new Object[0]);
                        return;
                    }
                    this.cER = aVar.getGif();
                    if (this.cER != null) {
                        this.cEQ = 1;
                        this.width = this.cER.getWidth();
                        this.height = this.cER.getHeight();
                        this.cFj = 0;
                        this.cFf = this.cER.getFrameCount();
                    } else {
                        this.cEQ = 0;
                    }
                } else {
                    return;
                }
            }
            if (this.cER != null) {
                if (this.cFk == null || (this.cFk != null && !this.cFk.Cg)) {
                    this.cFm = true;
                    this.cFk = new b();
                    this.cFh.clear();
                    this.cFi.clear();
                    this.cFk.Cg = true;
                    this.cFk.start();
                }
            }
        }
    }

    public void pause() {
        if (this.mImageType == 1) {
            if (this.cFk != null) {
                this.cFk.Cg = false;
                this.cFk.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.mImageType == 1) {
            if (this.cFk != null) {
                this.cFk.Cg = false;
                this.cFk.interrupt();
                this.cFk = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.cFm = true;
            this.cFg = null;
            this.cFi.clear();
            this.cFh.clear();
            this.width = 0;
            this.height = 0;
            this.cFj = 0;
            this.cFf = 0;
            this.cER = null;
        }
    }

    private void initData() {
        this.cFa = l.ai(getContext());
        this.cEH = l.ah(getContext()) * l.af(getContext()) * 2;
        if (this.cEH < 1690000) {
            this.cEH = 1690000;
        }
        this.cEz = 0.0f;
        this.cEA = 0.0f;
        this.cEB = new ArrayList<>();
        this.cEC = 1.0f;
        this.cED = 1.0f;
        this.mCurrentScale = 1.0f;
        this.cEE = this.mCurrentScale;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.cEL = new a();
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
                    DragImageView.this.cEL.s(f2, f3);
                    DragImageView.this.startAnimation(DragImageView.this.cEL);
                }
                return super.onFling(motionEvent, motionEvent2, f2, f3);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (DragImageView.this.mImageType == 1 || DragImageView.this.mImageType == 2 || !DragImageView.this.cEY) {
                    return false;
                }
                DragImageView.this.mMode = 2;
                if (DragImageView.this.mCurrentScale > DragImageView.this.cEC) {
                    DragImageView.this.mCurrentScale = DragImageView.this.cEC;
                    DragImageView.this.cEE = DragImageView.this.mCurrentScale;
                    DragImageView.this.axq();
                } else {
                    DragImageView.this.mCurrentScale = DragImageView.this.cEC * 2.0f;
                    DragImageView.this.a(true, (int) motionEvent.getX(), (int) motionEvent.getY());
                }
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (DragImageView.this.cEK != null && !DragImageView.this.cEO) {
                    DragImageView.this.cEK.onClick(DragImageView.this);
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
                DragImageView.this.cEO = true;
                if (DragImageView.this.cEI == 0 && DragImageView.this.cEP) {
                    return false;
                }
                int scrollX = DragImageView.this.getScrollX();
                int scrollY = DragImageView.this.getScrollY();
                if (DragImageView.this.cEz >= DragImageView.this.getWidth()) {
                    scrollX = (int) (scrollX + f2);
                    if (DragImageView.this.cEI == 0) {
                        i = scrollX >= 0 ? scrollX : 0;
                        if (DragImageView.this.getWidth() + i > DragImageView.this.cEz) {
                            i = (int) (DragImageView.this.cEz - DragImageView.this.getWidth());
                        }
                        if (DragImageView.this.cEA + DragImageView.this.mTop + DragImageView.this.mBottom < DragImageView.this.getHeight()) {
                            i2 = (int) (scrollY + f3);
                            if (DragImageView.this.cEI == 0) {
                                if (i2 < (-DragImageView.this.cET)) {
                                    i2 = -DragImageView.this.cET;
                                }
                                if (DragImageView.this.getHeight() + i2 > DragImageView.this.cEA + DragImageView.this.mBottom + DragImageView.this.cEU) {
                                    i2 = (int) ((DragImageView.this.cEA - DragImageView.this.getHeight()) + DragImageView.this.mBottom + DragImageView.this.cEU);
                                }
                            }
                        } else {
                            i2 = scrollY;
                        }
                        if (i == DragImageView.this.getScrollX() || i2 != DragImageView.this.getScrollY()) {
                            DragImageView.this.scrollTo(i, i2);
                            DragImageView.this.invalidate();
                            if (DragImageView.this.cEM != null) {
                                DragImageView.this.cEM.a(DragImageView.this, i, i2);
                            }
                        }
                        return true;
                    }
                }
                i = scrollX;
                if (DragImageView.this.cEA + DragImageView.this.mTop + DragImageView.this.mBottom < DragImageView.this.getHeight()) {
                }
                if (i == DragImageView.this.getScrollX()) {
                }
                DragImageView.this.scrollTo(i, i2);
                DragImageView.this.invalidate();
                if (DragImageView.this.cEM != null) {
                }
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (DragImageView.this.cnB != null && !DragImageView.this.cEO) {
                    DragImageView.this.cnB.onLongClick(DragImageView.this);
                }
                super.onLongPress(motionEvent);
            }
        });
    }

    private void aqN() {
        if (this.cFc == null) {
            if (this.cpD != null) {
                this.cpD.axw();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.cFc.getSourceImageRectInScreen();
        if (sourceImageRectInScreen == null) {
            if (this.cpD != null) {
                this.cpD.axw();
                return;
            }
            return;
        }
        this.cpy.bottom = (((sourceImageRectInScreen.bottom - sourceImageRectInScreen.top) / (sourceImageRectInScreen.right - sourceImageRectInScreen.left)) * (this.cpy.right - this.cpy.left)) + this.cpy.top;
        final float[] fArr = {(this.cpy.left + this.cpy.right) / 2.0f, (this.cpy.top + this.cpy.bottom) / 2.0f};
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
                    DragImageView.this.cpy = DragImageView.this.h(floatValue, animatedFraction, sourceImageRectInScreen.right - sourceImageRectInScreen.left, sourceImageRectInScreen.bottom - sourceImageRectInScreen.top);
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
                DragImageView.this.cpt = false;
                DragImageView.this.mMode = 4;
                DragImageView.this.invalidate();
                if (DragImageView.this.cpD != null) {
                    DragImageView.this.cpD.axw();
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

    private void axi() {
        int i = 0;
        int scrollX = getScrollX();
        if (this.cEz >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.cEz) {
                scrollX = (int) (this.cEz - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.cEA + this.mTop + this.mBottom >= getHeight()) {
            i = scrollY < (-this.cET) ? -this.cET : scrollY;
            if (getHeight() + i > this.cEA + this.mBottom + this.cEU) {
                i = (int) ((this.cEA - getHeight()) + this.mBottom + this.cEU);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
            if (this.cEM != null) {
                this.cEM.a(this, scrollX, i);
            }
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.cFb != null) {
            this.cFb.ayn();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.cEz;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.cEA;
    }

    public boolean axj() {
        if (this.mImageType == 1 || this.mImageType == 2) {
            return true;
        }
        return !this.cEP && getScrollX() >= ((int) (this.cEz - ((float) getWidth()))) + (-1);
    }

    public boolean axk() {
        if (this.mImageType == 1 || this.mImageType == 2) {
            return true;
        }
        return !this.cEP && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.cEL.axu()) {
            this.cEL.stopAnimation();
        }
        this.cEW = 0;
        super.setImageBitmap(bitmap);
        axe();
        this.mImageType = 0;
        if (this.cpx == null) {
            int measuredWidth = getMeasuredWidth();
            float measuredWidth2 = ((1.0f * getMeasuredWidth()) / bitmap.getWidth()) * bitmap.getHeight();
            if (measuredWidth2 > getMeasuredHeight()) {
                measuredWidth2 = getMeasuredHeight();
            }
            RectF h = h(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
            this.cpx = new Rect((int) h.left, (int) h.top, (int) h.right, (int) h.bottom);
        }
        if (this.cFe == null) {
            this.cFe = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
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
            if (this.cEL.axu()) {
                this.cEL.stopAnimation();
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
        if (this.cEL.axu()) {
            this.cEL.stopAnimation();
        }
        super.setImageDrawable(null);
        stop();
        axe();
        this.mImageType = 1;
        this.cES = bitmap;
        this.cEG = bArr;
        if (this.cnE != null) {
            this.cnE.a(this);
        }
    }

    public void onDestroy() {
        if (this.cEL.axu()) {
            this.cEL.stopAnimation();
        }
        super.setImageDrawable(null);
        this.cEG = null;
        this.cES = null;
        stop();
        if (this.cER != null) {
            this.cER.close();
            this.cER = null;
        }
        if (this.cFb != null) {
            this.cFb.release();
            System.gc();
        }
    }

    public void release() {
        if (this.cEL.axu()) {
            this.cEL.stopAnimation();
        }
        stop();
        super.setImageDrawable(null);
        this.cES = null;
    }

    public void setDefaultBitmap() {
        if (this.cEL.axu()) {
            this.cEL.stopAnimation();
        }
        try {
            if (this.cEZ) {
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
        axe();
    }

    public void axl() {
        if (this.mImageType != 1 && this.mImageType != 2) {
            int size = this.cEB.size();
            if (size > 0) {
                this.cEB.add(Float.valueOf(this.cEB.get(size - 1).floatValue() * 1.25f));
            } else {
                this.cEB.add(Float.valueOf(this.cEC));
            }
            axq();
        }
    }

    public void axm() {
        if (this.mImageType != 1 && this.mImageType != 2) {
            int size = this.cEB.size();
            if (size > 1) {
                this.cEB.remove(size - 1);
            }
            axq();
        }
    }

    public void axn() {
        axf();
        if (this.mImageType != 1 && this.mImageType != 2 && this.mCurrentScale != this.cEC) {
            this.cEB.clear();
            this.cEB.add(Float.valueOf(this.cEC));
            this.mCurrentScale = this.cEC;
            this.cEE = this.mCurrentScale;
            axq();
        }
    }

    public boolean axo() {
        if (this.mImageType == 1 || this.mImageType == 2) {
            return false;
        }
        int size = this.cEB.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.cEB.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.cEH) && floatValue <= 5.0f;
    }

    public boolean axp() {
        if (this.mImageType == 1 || this.mImageType == 2) {
            return false;
        }
        int size = this.cEB.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled()) {
            return false;
        }
        return size > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axq() {
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
                    int size = this.cEB.size();
                    if (size > 0) {
                        f3 = this.cEB.get(size - 1).floatValue();
                    } else {
                        f3 = this.cEC;
                    }
                    this.mCurrentScale = f3;
                }
                this.mMatrix.setScale(this.mCurrentScale, this.mCurrentScale);
                this.cEz = imageBitmap.getWidth() * this.mCurrentScale;
                this.cEA = imageBitmap.getHeight() * this.mCurrentScale;
                float width = this.cEE * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.cEE;
                this.cET = this.mTop;
                this.cEU = 0;
                float f4 = this.cEz < ((float) this.mViewWidth) ? (int) ((this.mViewWidth - this.cEz) / 2.0f) : 0.0f;
                if (this.cEA < this.mViewHeight) {
                    f2 = (int) ((this.mViewHeight - this.cEA) / 2.0f);
                    if (this.cEI == 1 && f2 > this.mTop) {
                        f2 = this.mTop;
                    }
                    this.cET = (int) (this.mTop - f2);
                    this.cEU = this.mTop - this.cET;
                } else {
                    f2 = 0.0f;
                }
                this.cEV = (int) f4;
                this.mMatrix.postTranslate(f4, f2);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    int width2 = i > getWidth() ? getWidth() : i;
                    if (this.cEz <= screenWidth) {
                        width2 = 0;
                    } else if (this.cEz > screenWidth && this.cEz / 2.0f < screenWidth) {
                        width2 = (int) (width2 - (this.cEz / 4.0f));
                    }
                    scrollX = width2;
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.cEz - width) / 2.0f);
                    }
                    if (this.cEz <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.cEz) {
                        scrollX = (int) (this.cEz - getWidth());
                    }
                }
                if (scrollX > 0 && this.cEz - scrollX < getWidth()) {
                    scrollX = (int) (this.cEz - getWidth());
                }
                int i3 = this.mMode == 2 ? ((int) ((this.cEA - height) / 2.0f)) + scrollY : scrollY;
                if (this.cEA <= getHeight()) {
                    i3 = 0;
                } else if (getHeight() + i3 > this.cEA) {
                    i3 = (int) (this.cEA - getHeight());
                }
                setHorizontalScrollBarEnabled(false);
                setVerticalScrollBarEnabled(false);
                if (scrollX < 0) {
                    scrollX = 0;
                }
                scrollTo(scrollX, i3 >= 0 ? i3 : 0);
                setImageMatrix(this.mMatrix);
                axf();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Animation {
        private boolean cFq = false;
        private boolean cFr = false;
        private long cFs;
        private long cFt;
        private long cFu;
        private long cFv;
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
            this.cFs = f;
            this.cFt = f2;
            this.cFu = Math.abs((f * 1000.0f) / 2500.0f);
            this.cFv = Math.abs((f2 * 1000.0f) / 2500.0f);
            setDuration(Math.max(this.cFu, this.cFv));
            setInterpolator(DragImageView.this.cFd);
            this.mStartX = DragImageView.this.getScrollX();
            this.mStartY = DragImageView.this.getScrollY();
            this.cFq = true;
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
            if (this.cFu > this.cFv) {
                j = ((float) this.cFu) * f;
            } else {
                j = ((float) this.cFv) * f;
            }
            float f2 = ((float) (j > this.cFu ? this.cFu : j)) / 1000.0f;
            if (this.cFs > 0) {
                i = this.mStartX - ((int) (f2 * (((float) this.cFs) - ((2500.0f * f2) / 2.0f))));
            } else {
                i = this.mStartX - ((int) (f2 * (((float) this.cFs) + ((2500.0f * f2) / 2.0f))));
            }
            if (j > this.cFv) {
                j = this.cFv;
            }
            float f3 = ((float) j) / 1000.0f;
            if (this.cFt > 0) {
                i2 = this.mStartY - ((int) (f3 * (((float) this.cFt) - ((2500.0f * f3) / 2.0f))));
            } else {
                i2 = this.mStartY - ((int) (f3 * (((float) this.cFt) + ((2500.0f * f3) / 2.0f))));
            }
            if (DragImageView.this.cEA + DragImageView.this.mTop + DragImageView.this.mBottom > DragImageView.this.getHeight()) {
                if (i2 < (-DragImageView.this.cET)) {
                    i2 = -DragImageView.this.cET;
                }
                if (DragImageView.this.getHeight() + i2 > DragImageView.this.cEA + DragImageView.this.mBottom + DragImageView.this.cEU) {
                    i2 = (int) ((DragImageView.this.cEA - DragImageView.this.getHeight()) + DragImageView.this.mBottom + DragImageView.this.cEU);
                }
            } else {
                i2 = 0;
            }
            if (DragImageView.this.cEz > DragImageView.this.getWidth()) {
                int width = ((float) (DragImageView.this.getWidth() + i)) > DragImageView.this.cEz ? (int) (DragImageView.this.cEz - DragImageView.this.getWidth()) : i;
                if (width >= 0) {
                    i3 = width;
                }
            }
            DragImageView.this.scrollTo(i3, i2);
            DragImageView.this.invalidate();
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            if (!this.cFr) {
                if (DragImageView.this.cEF) {
                    this.cFq = false;
                    return false;
                }
                try {
                    if (super.getTransformation(j, transformation)) {
                        return true;
                    }
                    this.cFq = false;
                    return false;
                } catch (Exception e) {
                    this.cFq = false;
                    return false;
                }
            }
            this.cFr = false;
            this.cFq = false;
            return false;
        }

        public boolean axu() {
            return this.cFq;
        }

        public void stopAnimation() {
            this.cFr = true;
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.cEK = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cnB = onLongClickListener;
        if (this.cFb != null) {
            this.cFb.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setGifSetListener(e eVar) {
        this.cnE = eVar;
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
    public void axr() {
        long j;
        c poll = this.cFh.poll();
        if (poll == null) {
            this.cFm = true;
            return;
        }
        this.cFm = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.cFg != null) {
            j = this.cFg.delay - (currentTimeMillis - this.cFl);
            this.cFi.offer(this.cFg);
        } else {
            j = 0;
        }
        this.cFg = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public c axs() {
        c poll = this.cFi.poll();
        if (poll == null) {
            poll = new c();
            try {
                poll.cFw = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
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
        return this.cFg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends Thread {
        private volatile boolean Cg;

        private b() {
            this.Cg = false;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (this.Cg && DragImageView.this.cER != null && DragImageView.this.cFf > 0 && DragImageView.this.width > 0 && DragImageView.this.height > 0) {
                try {
                    DragImageView.this.cER.N(DragImageView.this.cFj);
                    c axs = DragImageView.this.axs();
                    if (axs.cFw == null || (axs.cFw.getWidth() != DragImageView.this.width && axs.cFw.getHeight() != DragImageView.this.height)) {
                        try {
                            axs.cFw = Bitmap.createBitmap(DragImageView.this.width, DragImageView.this.height, Bitmap.Config.ARGB_8888);
                        } catch (OutOfMemoryError e) {
                            TbadkCoreApplication.getInst().onAppMemoryLow();
                            try {
                                axs.cFw = Bitmap.createBitmap(DragImageView.this.width, DragImageView.this.height, Bitmap.Config.ARGB_4444);
                            } catch (OutOfMemoryError e2) {
                                TbadkCoreApplication.getInst().onAppMemoryLow();
                            } catch (Throwable th) {
                                BdLog.e(th.getMessage());
                            }
                        } catch (Throwable th2) {
                            BdLog.e(th2.getMessage());
                        }
                    }
                    DragImageView.this.cER.a(axs.cFw, null);
                    axs.delay = DragImageView.this.cER.O(DragImageView.this.cFj);
                    DragImageView.C(DragImageView.this);
                    if (axs.cFw == null) {
                        DragImageView.C(DragImageView.this);
                    }
                    DragImageView.this.cFj %= DragImageView.this.cFf;
                    DragImageView.this.cFh.put(axs);
                    if (DragImageView.this.cFm) {
                        DragImageView.this.mHandler.sendEmptyMessage(1);
                    }
                } catch (Exception e3) {
                    return;
                }
            }
        }
    }

    public boolean axt() {
        return this.cEX;
    }

    public void setLoadBigImage(boolean z) {
        this.cEX = z;
    }

    public int getBottomOffset() {
        return this.cEU;
    }

    public int getLeftOffset() {
        return this.cEV;
    }
}
