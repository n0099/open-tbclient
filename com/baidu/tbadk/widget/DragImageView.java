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
    private static final int coJ = l.ah(TbadkCoreApplication.getInst()) / 5;
    private float cDI;
    private float cDJ;
    private ArrayList<Float> cDK;
    private float cDL;
    private float cDM;
    private float cDN;
    private boolean cDO;
    private byte[] cDP;
    private int cDQ;
    private int cDR;
    private g cDS;
    private View.OnClickListener cDT;
    private a cDU;
    private f cDV;
    private float cDW;
    private boolean cDX;
    private boolean cDY;
    private int cDZ;
    private volatile com.baidu.adp.gif.b cEa;
    private Bitmap cEb;
    private int cEc;
    private int cEd;
    private int cEe;
    private int cEf;
    private boolean cEg;
    private boolean cEh;
    private boolean cEi;
    private float cEj;
    private com.baidu.tbadk.widget.largeImage.logic.b cEk;
    private ImageUrlData cEl;
    private Interpolator cEm;
    private Rect cEn;
    private int cEo;
    private c cEp;
    private BlockingLinkedDeque<c> cEq;
    private BlockingLinkedDeque<c> cEr;
    private volatile int cEs;
    private b cEt;
    private volatile long cEu;
    private volatile boolean cEv;
    private View.OnLongClickListener cmF;
    private e cmI;
    private int cmN;
    private float coA;
    private Matrix coB;
    private Rect coC;
    private RectF coD;
    private d coI;
    private boolean coz;
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
        public Bitmap cEF;
        public int delay;
    }

    /* loaded from: classes.dex */
    public interface d {
        void axj();

        void axk();

        void axl();
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
        int i = dragImageView.cEs;
        dragImageView.cEs = i + 1;
        return i;
    }

    public void setIsHeadImage(boolean z) {
        this.cEi = z;
    }

    public void setImageUrlData(ImageUrlData imageUrlData) {
        this.cEl = imageUrlData;
    }

    public ImageUrlData getImageUrlData() {
        return this.cEl;
    }

    public void setCanScale(boolean z) {
        this.cEh = z;
    }

    public DragImageView(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.cDO = false;
        this.cDP = null;
        this.cmN = 0;
        this.cDQ = 1300;
        this.cDR = 0;
        this.cDS = null;
        this.cDT = null;
        this.cmF = null;
        this.cmI = null;
        this.cDW = 1.0f;
        this.mImageType = 0;
        this.mMode = 0;
        this.cDX = false;
        this.cDY = false;
        this.cDZ = 0;
        this.cEa = null;
        this.cEb = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.cEc = 0;
        this.cEd = 0;
        this.cEe = 0;
        this.cEf = 0;
        this.cEh = true;
        this.cEm = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.coB = new Matrix();
        this.coz = false;
        this.mRatio = 1.0f;
        this.coA = 0.0f;
        this.coD = new RectF();
        this.width = 0;
        this.height = 0;
        this.cEo = 0;
        this.cEp = null;
        this.cEq = new BlockingLinkedDeque<>(5);
        this.cEr = new BlockingLinkedDeque<>(6);
        this.cEs = 0;
        this.cEu = 0L;
        this.cEv = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.DragImageView.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        DragImageView.this.axf();
                        break;
                    case 1:
                        if (DragImageView.this.cEv) {
                            DragImageView.this.axf();
                            break;
                        }
                        break;
                    case 2:
                        DragImageView.this.invalidate();
                        DragImageView.this.cEu = System.currentTimeMillis();
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
        this.cDO = false;
        this.cDP = null;
        this.cmN = 0;
        this.cDQ = 1300;
        this.cDR = 0;
        this.cDS = null;
        this.cDT = null;
        this.cmF = null;
        this.cmI = null;
        this.cDW = 1.0f;
        this.mImageType = 0;
        this.mMode = 0;
        this.cDX = false;
        this.cDY = false;
        this.cDZ = 0;
        this.cEa = null;
        this.cEb = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.cEc = 0;
        this.cEd = 0;
        this.cEe = 0;
        this.cEf = 0;
        this.cEh = true;
        this.cEm = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.coB = new Matrix();
        this.coz = false;
        this.mRatio = 1.0f;
        this.coA = 0.0f;
        this.coD = new RectF();
        this.width = 0;
        this.height = 0;
        this.cEo = 0;
        this.cEp = null;
        this.cEq = new BlockingLinkedDeque<>(5);
        this.cEr = new BlockingLinkedDeque<>(6);
        this.cEs = 0;
        this.cEu = 0L;
        this.cEv = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.DragImageView.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        DragImageView.this.axf();
                        break;
                    case 1:
                        if (DragImageView.this.cEv) {
                            DragImageView.this.axf();
                            break;
                        }
                        break;
                    case 2:
                        DragImageView.this.invalidate();
                        DragImageView.this.cEu = System.currentTimeMillis();
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
        this.cDO = false;
        this.cDP = null;
        this.cmN = 0;
        this.cDQ = 1300;
        this.cDR = 0;
        this.cDS = null;
        this.cDT = null;
        this.cmF = null;
        this.cmI = null;
        this.cDW = 1.0f;
        this.mImageType = 0;
        this.mMode = 0;
        this.cDX = false;
        this.cDY = false;
        this.cDZ = 0;
        this.cEa = null;
        this.cEb = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.cEc = 0;
        this.cEd = 0;
        this.cEe = 0;
        this.cEf = 0;
        this.cEh = true;
        this.cEm = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.coB = new Matrix();
        this.coz = false;
        this.mRatio = 1.0f;
        this.coA = 0.0f;
        this.coD = new RectF();
        this.width = 0;
        this.height = 0;
        this.cEo = 0;
        this.cEp = null;
        this.cEq = new BlockingLinkedDeque<>(5);
        this.cEr = new BlockingLinkedDeque<>(6);
        this.cEs = 0;
        this.cEu = 0L;
        this.cEv = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.DragImageView.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        DragImageView.this.axf();
                        break;
                    case 1:
                        if (DragImageView.this.cEv) {
                            DragImageView.this.axf();
                            break;
                        }
                        break;
                    case 2:
                        DragImageView.this.invalidate();
                        DragImageView.this.cEu = System.currentTimeMillis();
                        DragImageView.this.mHandler.sendEmptyMessage(0);
                        break;
                }
                return false;
            }
        });
        initData();
    }

    public void setDragToExitListener(d dVar) {
        this.coI = dVar;
    }

    public int getImageType() {
        return this.mImageType;
    }

    public void setImageMode(int i) {
        this.cDR = i;
    }

    public void setOffset(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.cmN = i;
    }

    public boolean awP() {
        if (this.cEk != null) {
            return this.cEk.awP();
        }
        return false;
    }

    public void awQ() {
        this.cDY = false;
        this.cDO = false;
        this.mMode = 3;
        awW();
        if (this.mCurrentScale < this.cDL) {
            this.mCurrentScale = this.cDL;
            axe();
        }
        invalidate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.cEk != null && this.cEk.onTouchEvent(motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.cDO = true;
                this.cDX = false;
                this.cDY = false;
                break;
            case 1:
                awQ();
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
            this.cDW = x(motionEvent);
            if (this.cDW > 10.0f) {
                this.mMode = 2;
            }
        }
        if ((this.mMode == 2 || !this.mGestureDetector.onTouchEvent(motionEvent)) && this.cEh) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.cDX = true;
                        this.cDY = true;
                        if (this.mImageType != 1 && this.mImageType != 2) {
                            float x = x(motionEvent);
                            if (x >= 0.0f && Math.abs(this.cDW - x) >= 10.0f) {
                                if (Math.abs(this.cDW - x) > 100.0f) {
                                    this.cDW = x;
                                    break;
                                } else {
                                    float f2 = x / this.cDW;
                                    this.cDW = x;
                                    this.cDN = this.mCurrentScale;
                                    this.mCurrentScale *= f2;
                                    if (this.mCurrentScale > this.cDM) {
                                        this.mCurrentScale = this.cDM;
                                    }
                                    float minScaleValue = getMinScaleValue();
                                    if (this.mCurrentScale < minScaleValue) {
                                        this.mCurrentScale = minScaleValue;
                                    }
                                    axe();
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
        return this.cEk != null ? this.cEk.getMinScaleValue() : this.cDL / 4.0f;
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
            awS();
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public boolean awR() {
        if (this.cEk != null) {
            return this.cEk.aya();
        }
        return this.cDL == this.mCurrentScale;
    }

    protected float o(Bitmap bitmap) {
        if (this.cEk != null) {
            return this.cEk.aye();
        }
        if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            return 1.0f;
        }
        if (this.cDR == 0) {
            float width = this.mViewWidth / bitmap.getWidth();
            float height = this.mViewHeight / bitmap.getHeight();
            if (this.cEi) {
                if (this.mImageType == 2) {
                    return 2.5f;
                }
                return Math.min(width, height);
            } else if (this.mImageType != 2) {
                float f2 = this.cEj;
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
        if (this.cEk != null) {
            return this.cEk.ayf();
        }
        float f2 = 1.0f;
        if (bitmap != null && !bitmap.isRecycled() && bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
            f2 = (float) Math.sqrt(this.cDQ / (bitmap.getWidth() * bitmap.getHeight()));
            if (f2 > 10.0f) {
                return 10.0f;
            }
        }
        return f2;
    }

    private void awS() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            this.cDL = o(imageBitmap);
            this.cDM = p(imageBitmap);
            this.cDK.clear();
            this.cDK.add(Float.valueOf(this.cDL));
            this.mCurrentScale = this.cDL;
            this.cDN = this.mCurrentScale;
            axe();
            return;
        }
        this.cDI = 0.0f;
        this.cDJ = 0.0f;
        this.cDL = 1.0f;
        this.cDM = 1.0f;
        this.mCurrentScale = 1.0f;
        this.cDN = this.mCurrentScale;
        this.cDK.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    private void awT() {
        if (this.cDS != null) {
            this.cDS.a(this, axc(), axd());
        }
    }

    public void setOnSizeChangedListener(g gVar) {
        this.cDS = gVar;
    }

    public void setOnImageScrollListener(f fVar) {
        this.cDV = fVar;
    }

    public byte[] getImageData() {
        return this.cDP;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getMeasuredHeight() != 0 && getMeasuredWidth() != 0 && this.cEk != null) {
            this.cEk.ayc();
        }
    }

    public void setImageData(Bitmap bitmap, byte[] bArr) {
        this.cDP = bArr;
        if (this.cEk != null) {
            this.cEk.a(bitmap, bArr);
        }
        setImageBitmap(bitmap);
    }

    public void awU() {
        if (this.cEk == null) {
            this.cEk = new com.baidu.tbadk.widget.largeImage.logic.b(this);
            this.cEk.setOnClickListener(this.cDT);
            this.cEk.setOnLongClickListener(this.cmF);
        }
    }

    public void setImageLoadCallBack(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
        if (this.cEk != null) {
            this.cEk.a(aVar);
        }
    }

    public boolean awV() {
        return (getImageBitmap() == null || this.cEk == null) ? false : true;
    }

    public Bitmap getGifCache() {
        return this.cEb;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        boolean z;
        if (this.cEk == null || !this.cEk.b(canvas, getImageBitmap())) {
            if (this.mImageType == 2 && this.cEf != 0 && !this.cDU.axi()) {
                int width = getWidth();
                int height = getHeight();
                Drawable drawable = getDrawable();
                float f2 = 0.0f;
                float f3 = height * 0.3f;
                float f4 = width;
                float f5 = (1.0f - 0.3f) * height;
                if (this.cEi && drawable != null) {
                    Rect bounds = drawable.getBounds();
                    int i = bounds.right - bounds.left;
                    int i2 = bounds.bottom - bounds.top;
                    f2 = (width / 2) - (i * 2.5f);
                    f3 = (height / 2) - (i2 * 2.5f);
                    f4 = (i * 2.5f) + (width / 2);
                    f5 = (i2 * 2.5f) + (height / 2);
                }
                this.mPaint.setColor(am.getColor(this.cEf));
                canvas.drawRect(f2, f3, f4, f5, this.mPaint);
                this.mPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
            }
            if (this.mMode == 3 && this.coz) {
                this.coz = false;
                this.coB.reset();
                if (this.coA < coJ) {
                    this.mMode = 0;
                } else {
                    this.mMode = 4;
                    aqB();
                }
            }
            if (this.mImageType == 0 && this.coz && this.coC != null && this.cEl != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                if (this.coD == null) {
                    this.coD = new RectF();
                }
                this.coB.mapRect(this.coD, new RectF(this.coC));
                Bitmap imageBitmap = getImageBitmap();
                if (imageBitmap != null && !imageBitmap.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.cEn, this.coD, (Paint) null);
                }
            } else if (this.mMode == 4 && this.coC != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                Bitmap imageBitmap2 = getImageBitmap();
                if (imageBitmap2 != null && !imageBitmap2.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.cEn, this.coD, (Paint) null);
                }
            } else {
                super.onDraw(canvas);
            }
            if (this.mImageType == 1 && this.cEb != null && !this.cEb.isRecycled()) {
                int width2 = this.cEb.getWidth();
                int height2 = this.cEb.getHeight();
                int width3 = getWidth();
                int height3 = getHeight();
                int i3 = (width3 - width2) >> 1;
                int i4 = (height3 - height2) >> 1;
                float f6 = this.cEj;
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
                if (this.cDZ == 1 && this.cEa != null && this.cEp != null && this.cEp.cEF != null) {
                    if (z) {
                        canvas.drawBitmap(this.cEp.cEF, i3, i4, (Paint) null);
                    } else {
                        canvas.drawBitmap(this.cEp.cEF, this.mMatrix, this.mPaint);
                    }
                    invalidate();
                } else if (z) {
                    canvas.drawBitmap(this.cEb, i3, i4, (Paint) null);
                } else {
                    canvas.drawBitmap(this.cEb, this.mMatrix, this.mPaint);
                }
            }
        }
    }

    public void play() {
        com.baidu.adp.widget.ImageView.a aVar;
        if (this.mImageType == 1) {
            if (this.cEa == null) {
                if (this.cEt != null) {
                    this.cEt.Cg = false;
                    this.cEt.interrupt();
                    this.cEt = null;
                }
                if (this.cDP != null) {
                    try {
                        aVar = a.C0013a.gy().g(this.cDP, 0, this.cDP.length);
                    } catch (StackOverflowError e2) {
                        aVar = null;
                    }
                    if (aVar == null || aVar.getGif() == null) {
                        com.baidu.tbadk.core.e.a.a("gifplay", -1L, -1, "DragImageView.play", -1, "decode error", new Object[0]);
                        return;
                    }
                    this.cEa = aVar.getGif();
                    if (this.cEa != null) {
                        this.cDZ = 1;
                        this.width = this.cEa.getWidth();
                        this.height = this.cEa.getHeight();
                        this.cEs = 0;
                        this.cEo = this.cEa.getFrameCount();
                    } else {
                        this.cDZ = 0;
                    }
                } else {
                    return;
                }
            }
            if (this.cEa != null) {
                if (this.cEt == null || (this.cEt != null && !this.cEt.Cg)) {
                    this.cEv = true;
                    this.cEt = new b();
                    this.cEq.clear();
                    this.cEr.clear();
                    this.cEt.Cg = true;
                    this.cEt.start();
                }
            }
        }
    }

    public void pause() {
        if (this.mImageType == 1) {
            if (this.cEt != null) {
                this.cEt.Cg = false;
                this.cEt.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.mImageType == 1) {
            if (this.cEt != null) {
                this.cEt.Cg = false;
                this.cEt.interrupt();
                this.cEt = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.cEv = true;
            this.cEp = null;
            this.cEr.clear();
            this.cEq.clear();
            this.width = 0;
            this.height = 0;
            this.cEs = 0;
            this.cEo = 0;
            this.cEa = null;
        }
    }

    private void initData() {
        this.cEj = l.ai(getContext());
        this.cDQ = l.ah(getContext()) * l.af(getContext()) * 2;
        if (this.cDQ < 1690000) {
            this.cDQ = 1690000;
        }
        this.cDI = 0.0f;
        this.cDJ = 0.0f;
        this.cDK = new ArrayList<>();
        this.cDL = 1.0f;
        this.cDM = 1.0f;
        this.mCurrentScale = 1.0f;
        this.cDN = this.mCurrentScale;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.cDU = new a();
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
                    DragImageView.this.cDU.s(f2, f3);
                    DragImageView.this.startAnimation(DragImageView.this.cDU);
                }
                return super.onFling(motionEvent, motionEvent2, f2, f3);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (DragImageView.this.mImageType == 1 || DragImageView.this.mImageType == 2 || !DragImageView.this.cEh) {
                    return false;
                }
                DragImageView.this.mMode = 2;
                if (DragImageView.this.mCurrentScale > DragImageView.this.cDL) {
                    DragImageView.this.mCurrentScale = DragImageView.this.cDL;
                    DragImageView.this.cDN = DragImageView.this.mCurrentScale;
                    DragImageView.this.axe();
                } else {
                    DragImageView.this.mCurrentScale = DragImageView.this.cDL * 2.0f;
                    DragImageView.this.a(true, (int) motionEvent.getX(), (int) motionEvent.getY());
                }
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (DragImageView.this.cDT != null && !DragImageView.this.cDX) {
                    DragImageView.this.cDT.onClick(DragImageView.this);
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
                DragImageView.this.cDX = true;
                if (DragImageView.this.cDR == 0 && DragImageView.this.cDY) {
                    return false;
                }
                int scrollX = DragImageView.this.getScrollX();
                int scrollY = DragImageView.this.getScrollY();
                if (DragImageView.this.cDI >= DragImageView.this.getWidth()) {
                    scrollX = (int) (scrollX + f2);
                    if (DragImageView.this.cDR == 0) {
                        i = scrollX >= 0 ? scrollX : 0;
                        if (DragImageView.this.getWidth() + i > DragImageView.this.cDI) {
                            i = (int) (DragImageView.this.cDI - DragImageView.this.getWidth());
                        }
                        if (DragImageView.this.cDJ + DragImageView.this.mTop + DragImageView.this.mBottom < DragImageView.this.getHeight()) {
                            i2 = (int) (scrollY + f3);
                            if (DragImageView.this.cDR == 0) {
                                if (i2 < (-DragImageView.this.cEc)) {
                                    i2 = -DragImageView.this.cEc;
                                }
                                if (DragImageView.this.getHeight() + i2 > DragImageView.this.cDJ + DragImageView.this.mBottom + DragImageView.this.cEd) {
                                    i2 = (int) ((DragImageView.this.cDJ - DragImageView.this.getHeight()) + DragImageView.this.mBottom + DragImageView.this.cEd);
                                }
                            }
                        } else {
                            i2 = scrollY;
                        }
                        if (i == DragImageView.this.getScrollX() || i2 != DragImageView.this.getScrollY()) {
                            DragImageView.this.scrollTo(i, i2);
                            DragImageView.this.invalidate();
                            if (DragImageView.this.cDV != null) {
                                DragImageView.this.cDV.a(DragImageView.this, i, i2);
                            }
                        }
                        return true;
                    }
                }
                i = scrollX;
                if (DragImageView.this.cDJ + DragImageView.this.mTop + DragImageView.this.mBottom < DragImageView.this.getHeight()) {
                }
                if (i == DragImageView.this.getScrollX()) {
                }
                DragImageView.this.scrollTo(i, i2);
                DragImageView.this.invalidate();
                if (DragImageView.this.cDV != null) {
                }
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (DragImageView.this.cmF != null && !DragImageView.this.cDX) {
                    DragImageView.this.cmF.onLongClick(DragImageView.this);
                }
                super.onLongPress(motionEvent);
            }
        });
    }

    private void aqB() {
        if (this.cEl == null) {
            if (this.coI != null) {
                this.coI.axk();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.cEl.getSourceImageRectInScreen();
        if (sourceImageRectInScreen == null) {
            if (this.coI != null) {
                this.coI.axk();
                return;
            }
            return;
        }
        this.coD.bottom = (((sourceImageRectInScreen.bottom - sourceImageRectInScreen.top) / (sourceImageRectInScreen.right - sourceImageRectInScreen.left)) * (this.coD.right - this.coD.left)) + this.coD.top;
        final float[] fArr = {(this.coD.left + this.coD.right) / 2.0f, (this.coD.top + this.coD.bottom) / 2.0f};
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
                    DragImageView.this.coD = DragImageView.this.h(floatValue, animatedFraction, sourceImageRectInScreen.right - sourceImageRectInScreen.left, sourceImageRectInScreen.bottom - sourceImageRectInScreen.top);
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
                DragImageView.this.coz = false;
                DragImageView.this.mMode = 4;
                DragImageView.this.invalidate();
                if (DragImageView.this.coI != null) {
                    DragImageView.this.coI.axk();
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

    private void awW() {
        int i = 0;
        int scrollX = getScrollX();
        if (this.cDI >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.cDI) {
                scrollX = (int) (this.cDI - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.cDJ + this.mTop + this.mBottom >= getHeight()) {
            i = scrollY < (-this.cEc) ? -this.cEc : scrollY;
            if (getHeight() + i > this.cDJ + this.mBottom + this.cEd) {
                i = (int) ((this.cDJ - getHeight()) + this.mBottom + this.cEd);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
            if (this.cDV != null) {
                this.cDV.a(this, scrollX, i);
            }
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.cEk != null) {
            this.cEk.ayb();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.cDI;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.cDJ;
    }

    public boolean awX() {
        if (this.mImageType == 1 || this.mImageType == 2) {
            return true;
        }
        return !this.cDY && getScrollX() >= ((int) (this.cDI - ((float) getWidth()))) + (-1);
    }

    public boolean awY() {
        if (this.mImageType == 1 || this.mImageType == 2) {
            return true;
        }
        return !this.cDY && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.cDU.axi()) {
            this.cDU.stopAnimation();
        }
        this.cEf = 0;
        super.setImageBitmap(bitmap);
        awS();
        this.mImageType = 0;
        if (this.coC == null) {
            int measuredWidth = getMeasuredWidth();
            float measuredWidth2 = ((1.0f * getMeasuredWidth()) / bitmap.getWidth()) * bitmap.getHeight();
            if (measuredWidth2 > getMeasuredHeight()) {
                measuredWidth2 = getMeasuredHeight();
            }
            RectF h = h(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
            this.coC = new Rect((int) h.left, (int) h.top, (int) h.right, (int) h.bottom);
        }
        if (this.cEn == null) {
            this.cEn = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
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
            if (this.cDU.axi()) {
                this.cDU.stopAnimation();
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
        if (this.cDU.axi()) {
            this.cDU.stopAnimation();
        }
        super.setImageDrawable(null);
        stop();
        awS();
        this.mImageType = 1;
        this.cEb = bitmap;
        this.cDP = bArr;
        if (this.cmI != null) {
            this.cmI.a(this);
        }
    }

    public void onDestroy() {
        if (this.cDU.axi()) {
            this.cDU.stopAnimation();
        }
        super.setImageDrawable(null);
        this.cDP = null;
        this.cEb = null;
        stop();
        if (this.cEa != null) {
            this.cEa.close();
            this.cEa = null;
        }
        if (this.cEk != null) {
            this.cEk.release();
            System.gc();
        }
    }

    public void release() {
        if (this.cDU.axi()) {
            this.cDU.stopAnimation();
        }
        stop();
        super.setImageDrawable(null);
        this.cEb = null;
    }

    public void setDefaultBitmap() {
        if (this.cDU.axi()) {
            this.cDU.stopAnimation();
        }
        try {
            if (this.cEi) {
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
        awS();
    }

    public void awZ() {
        if (this.mImageType != 1 && this.mImageType != 2) {
            int size = this.cDK.size();
            if (size > 0) {
                this.cDK.add(Float.valueOf(this.cDK.get(size - 1).floatValue() * 1.25f));
            } else {
                this.cDK.add(Float.valueOf(this.cDL));
            }
            axe();
        }
    }

    public void axa() {
        if (this.mImageType != 1 && this.mImageType != 2) {
            int size = this.cDK.size();
            if (size > 1) {
                this.cDK.remove(size - 1);
            }
            axe();
        }
    }

    public void axb() {
        awT();
        if (this.mImageType != 1 && this.mImageType != 2 && this.mCurrentScale != this.cDL) {
            this.cDK.clear();
            this.cDK.add(Float.valueOf(this.cDL));
            this.mCurrentScale = this.cDL;
            this.cDN = this.mCurrentScale;
            axe();
        }
    }

    public boolean axc() {
        if (this.mImageType == 1 || this.mImageType == 2) {
            return false;
        }
        int size = this.cDK.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.cDK.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.cDQ) && floatValue <= 5.0f;
    }

    public boolean axd() {
        if (this.mImageType == 1 || this.mImageType == 2) {
            return false;
        }
        int size = this.cDK.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled()) {
            return false;
        }
        return size > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axe() {
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
                    int size = this.cDK.size();
                    if (size > 0) {
                        f3 = this.cDK.get(size - 1).floatValue();
                    } else {
                        f3 = this.cDL;
                    }
                    this.mCurrentScale = f3;
                }
                this.mMatrix.setScale(this.mCurrentScale, this.mCurrentScale);
                this.cDI = imageBitmap.getWidth() * this.mCurrentScale;
                this.cDJ = imageBitmap.getHeight() * this.mCurrentScale;
                float width = this.cDN * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.cDN;
                this.cEc = this.mTop;
                this.cEd = 0;
                float f4 = this.cDI < ((float) this.mViewWidth) ? (int) ((this.mViewWidth - this.cDI) / 2.0f) : 0.0f;
                if (this.cDJ < this.mViewHeight) {
                    f2 = (int) ((this.mViewHeight - this.cDJ) / 2.0f);
                    if (this.cDR == 1 && f2 > this.mTop) {
                        f2 = this.mTop;
                    }
                    this.cEc = (int) (this.mTop - f2);
                    this.cEd = this.mTop - this.cEc;
                } else {
                    f2 = 0.0f;
                }
                this.cEe = (int) f4;
                this.mMatrix.postTranslate(f4, f2);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    int width2 = i > getWidth() ? getWidth() : i;
                    if (this.cDI <= screenWidth) {
                        width2 = 0;
                    } else if (this.cDI > screenWidth && this.cDI / 2.0f < screenWidth) {
                        width2 = (int) (width2 - (this.cDI / 4.0f));
                    }
                    scrollX = width2;
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.cDI - width) / 2.0f);
                    }
                    if (this.cDI <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.cDI) {
                        scrollX = (int) (this.cDI - getWidth());
                    }
                }
                if (scrollX > 0 && this.cDI - scrollX < getWidth()) {
                    scrollX = (int) (this.cDI - getWidth());
                }
                int i3 = this.mMode == 2 ? ((int) ((this.cDJ - height) / 2.0f)) + scrollY : scrollY;
                if (this.cDJ <= getHeight()) {
                    i3 = 0;
                } else if (getHeight() + i3 > this.cDJ) {
                    i3 = (int) (this.cDJ - getHeight());
                }
                setHorizontalScrollBarEnabled(false);
                setVerticalScrollBarEnabled(false);
                if (scrollX < 0) {
                    scrollX = 0;
                }
                scrollTo(scrollX, i3 >= 0 ? i3 : 0);
                setImageMatrix(this.mMatrix);
                awT();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Animation {
        private long cEB;
        private long cEC;
        private long cED;
        private long cEE;
        private int mStartX;
        private int mStartY;
        private boolean cEz = false;
        private boolean cEA = false;

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
            this.cEB = f;
            this.cEC = f2;
            this.cED = Math.abs((f * 1000.0f) / 2500.0f);
            this.cEE = Math.abs((f2 * 1000.0f) / 2500.0f);
            setDuration(Math.max(this.cED, this.cEE));
            setInterpolator(DragImageView.this.cEm);
            this.mStartX = DragImageView.this.getScrollX();
            this.mStartY = DragImageView.this.getScrollY();
            this.cEz = true;
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
            if (this.cED > this.cEE) {
                j = ((float) this.cED) * f;
            } else {
                j = ((float) this.cEE) * f;
            }
            float f2 = ((float) (j > this.cED ? this.cED : j)) / 1000.0f;
            if (this.cEB > 0) {
                i = this.mStartX - ((int) (f2 * (((float) this.cEB) - ((2500.0f * f2) / 2.0f))));
            } else {
                i = this.mStartX - ((int) (f2 * (((float) this.cEB) + ((2500.0f * f2) / 2.0f))));
            }
            if (j > this.cEE) {
                j = this.cEE;
            }
            float f3 = ((float) j) / 1000.0f;
            if (this.cEC > 0) {
                i2 = this.mStartY - ((int) (f3 * (((float) this.cEC) - ((2500.0f * f3) / 2.0f))));
            } else {
                i2 = this.mStartY - ((int) (f3 * (((float) this.cEC) + ((2500.0f * f3) / 2.0f))));
            }
            if (DragImageView.this.cDJ + DragImageView.this.mTop + DragImageView.this.mBottom > DragImageView.this.getHeight()) {
                if (i2 < (-DragImageView.this.cEc)) {
                    i2 = -DragImageView.this.cEc;
                }
                if (DragImageView.this.getHeight() + i2 > DragImageView.this.cDJ + DragImageView.this.mBottom + DragImageView.this.cEd) {
                    i2 = (int) ((DragImageView.this.cDJ - DragImageView.this.getHeight()) + DragImageView.this.mBottom + DragImageView.this.cEd);
                }
            } else {
                i2 = 0;
            }
            if (DragImageView.this.cDI > DragImageView.this.getWidth()) {
                int width = ((float) (DragImageView.this.getWidth() + i)) > DragImageView.this.cDI ? (int) (DragImageView.this.cDI - DragImageView.this.getWidth()) : i;
                if (width >= 0) {
                    i3 = width;
                }
            }
            DragImageView.this.scrollTo(i3, i2);
            DragImageView.this.invalidate();
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            if (!this.cEA) {
                if (DragImageView.this.cDO) {
                    this.cEz = false;
                    return false;
                }
                try {
                    if (super.getTransformation(j, transformation)) {
                        return true;
                    }
                    this.cEz = false;
                    return false;
                } catch (Exception e) {
                    this.cEz = false;
                    return false;
                }
            }
            this.cEA = false;
            this.cEz = false;
            return false;
        }

        public boolean axi() {
            return this.cEz;
        }

        public void stopAnimation() {
            this.cEA = true;
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.cDT = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cmF = onLongClickListener;
        if (this.cEk != null) {
            this.cEk.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setGifSetListener(e eVar) {
        this.cmI = eVar;
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
    public void axf() {
        long j;
        c poll = this.cEq.poll();
        if (poll == null) {
            this.cEv = true;
            return;
        }
        this.cEv = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.cEp != null) {
            j = this.cEp.delay - (currentTimeMillis - this.cEu);
            this.cEr.offer(this.cEp);
        } else {
            j = 0;
        }
        this.cEp = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public c axg() {
        c poll = this.cEr.poll();
        if (poll == null) {
            poll = new c();
            try {
                poll.cEF = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
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
        return this.cEp;
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
            while (this.Cg && DragImageView.this.cEa != null && DragImageView.this.cEo > 0 && DragImageView.this.width > 0 && DragImageView.this.height > 0) {
                try {
                    DragImageView.this.cEa.N(DragImageView.this.cEs);
                    c axg = DragImageView.this.axg();
                    if (axg.cEF == null || (axg.cEF.getWidth() != DragImageView.this.width && axg.cEF.getHeight() != DragImageView.this.height)) {
                        try {
                            axg.cEF = Bitmap.createBitmap(DragImageView.this.width, DragImageView.this.height, Bitmap.Config.ARGB_8888);
                        } catch (OutOfMemoryError e) {
                            TbadkCoreApplication.getInst().onAppMemoryLow();
                            try {
                                axg.cEF = Bitmap.createBitmap(DragImageView.this.width, DragImageView.this.height, Bitmap.Config.ARGB_4444);
                            } catch (OutOfMemoryError e2) {
                                TbadkCoreApplication.getInst().onAppMemoryLow();
                            } catch (Throwable th) {
                                BdLog.e(th.getMessage());
                            }
                        } catch (Throwable th2) {
                            BdLog.e(th2.getMessage());
                        }
                    }
                    DragImageView.this.cEa.a(axg.cEF, null);
                    axg.delay = DragImageView.this.cEa.O(DragImageView.this.cEs);
                    DragImageView.C(DragImageView.this);
                    if (axg.cEF == null) {
                        DragImageView.C(DragImageView.this);
                    }
                    DragImageView.this.cEs %= DragImageView.this.cEo;
                    DragImageView.this.cEq.put(axg);
                    if (DragImageView.this.cEv) {
                        DragImageView.this.mHandler.sendEmptyMessage(1);
                    }
                } catch (Exception e3) {
                    return;
                }
            }
        }
    }

    public boolean axh() {
        return this.cEg;
    }

    public void setLoadBigImage(boolean z) {
        this.cEg = z;
    }

    public int getBottomOffset() {
        return this.cEd;
    }

    public int getLeftOffset() {
        return this.cEe;
    }
}
