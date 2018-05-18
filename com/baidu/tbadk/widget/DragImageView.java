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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class DragImageView extends ImageView {
    private static final String TAG = DragImageView.class.getSimpleName();
    private static final int azE = l.ah(TbadkCoreApplication.getInst()) / 5;
    private float aNX;
    private float aNY;
    private ArrayList<Float> aNZ;
    private Rect aOA;
    private int aOB;
    private c aOC;
    private BlockingLinkedDeque<c> aOD;
    private BlockingLinkedDeque<c> aOE;
    private volatile int aOF;
    private b aOG;
    private volatile long aOH;
    private volatile boolean aOI;
    private float aOa;
    private float aOb;
    private float aOc;
    private boolean aOd;
    private byte[] aOe;
    private int aOf;
    private int aOg;
    private f aOh;
    private View.OnClickListener aOi;
    private a aOj;
    private float aOk;
    private boolean aOl;
    private boolean aOm;
    private int aOn;
    private volatile com.baidu.adp.gif.b aOo;
    private Bitmap aOp;
    private int aOq;
    private int aOr;
    private int aOs;
    private int aOt;
    private boolean aOu;
    private boolean aOv;
    private float aOw;
    private com.baidu.tbadk.widget.largeImage.logic.b aOx;
    private ImageUrlData aOy;
    private Interpolator aOz;
    public int ajF;
    private View.OnLongClickListener axX;
    private e aya;
    private int ayb;
    private RectF azA;
    private d azD;
    private boolean azw;
    private float azx;
    private Matrix azy;
    private Rect azz;
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
        public Bitmap aOR;
        public int delay;
    }

    /* loaded from: classes.dex */
    public interface d {
        void In();

        void Io();
    }

    /* loaded from: classes.dex */
    public interface e {
        void a(DragImageView dragImageView);
    }

    /* loaded from: classes.dex */
    public interface f {
        void a(DragImageView dragImageView, boolean z, boolean z2);
    }

    static /* synthetic */ int A(DragImageView dragImageView) {
        int i = dragImageView.aOF;
        dragImageView.aOF = i + 1;
        return i;
    }

    public void setIsHeadImage(boolean z) {
        this.aOv = z;
    }

    public void setImageUrlData(ImageUrlData imageUrlData) {
        this.aOy = imageUrlData;
    }

    public DragImageView(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aOd = false;
        this.aOe = null;
        this.ayb = 0;
        this.aOf = 1300;
        this.aOg = 0;
        this.aOh = null;
        this.aOi = null;
        this.axX = null;
        this.aya = null;
        this.aOk = 1.0f;
        this.ajF = 0;
        this.mMode = 0;
        this.aOl = false;
        this.aOm = false;
        this.aOn = 0;
        this.aOo = null;
        this.aOp = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aOq = 0;
        this.aOr = 0;
        this.aOs = 0;
        this.aOt = 0;
        this.aOz = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.azy = new Matrix();
        this.azw = false;
        this.mRatio = 1.0f;
        this.azx = 0.0f;
        this.azA = new RectF();
        this.width = 0;
        this.height = 0;
        this.aOB = 0;
        this.aOC = null;
        this.aOD = new BlockingLinkedDeque<>(5);
        this.aOE = new BlockingLinkedDeque<>(6);
        this.aOF = 0;
        this.aOH = 0L;
        this.aOI = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.DragImageView.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        DragImageView.this.Ij();
                        break;
                    case 1:
                        if (DragImageView.this.aOI) {
                            DragImageView.this.Ij();
                            break;
                        }
                        break;
                    case 2:
                        DragImageView.this.invalidate();
                        DragImageView.this.aOH = System.currentTimeMillis();
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
        this.aOd = false;
        this.aOe = null;
        this.ayb = 0;
        this.aOf = 1300;
        this.aOg = 0;
        this.aOh = null;
        this.aOi = null;
        this.axX = null;
        this.aya = null;
        this.aOk = 1.0f;
        this.ajF = 0;
        this.mMode = 0;
        this.aOl = false;
        this.aOm = false;
        this.aOn = 0;
        this.aOo = null;
        this.aOp = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aOq = 0;
        this.aOr = 0;
        this.aOs = 0;
        this.aOt = 0;
        this.aOz = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.azy = new Matrix();
        this.azw = false;
        this.mRatio = 1.0f;
        this.azx = 0.0f;
        this.azA = new RectF();
        this.width = 0;
        this.height = 0;
        this.aOB = 0;
        this.aOC = null;
        this.aOD = new BlockingLinkedDeque<>(5);
        this.aOE = new BlockingLinkedDeque<>(6);
        this.aOF = 0;
        this.aOH = 0L;
        this.aOI = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.DragImageView.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        DragImageView.this.Ij();
                        break;
                    case 1:
                        if (DragImageView.this.aOI) {
                            DragImageView.this.Ij();
                            break;
                        }
                        break;
                    case 2:
                        DragImageView.this.invalidate();
                        DragImageView.this.aOH = System.currentTimeMillis();
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
        this.aOd = false;
        this.aOe = null;
        this.ayb = 0;
        this.aOf = 1300;
        this.aOg = 0;
        this.aOh = null;
        this.aOi = null;
        this.axX = null;
        this.aya = null;
        this.aOk = 1.0f;
        this.ajF = 0;
        this.mMode = 0;
        this.aOl = false;
        this.aOm = false;
        this.aOn = 0;
        this.aOo = null;
        this.aOp = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aOq = 0;
        this.aOr = 0;
        this.aOs = 0;
        this.aOt = 0;
        this.aOz = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.azy = new Matrix();
        this.azw = false;
        this.mRatio = 1.0f;
        this.azx = 0.0f;
        this.azA = new RectF();
        this.width = 0;
        this.height = 0;
        this.aOB = 0;
        this.aOC = null;
        this.aOD = new BlockingLinkedDeque<>(5);
        this.aOE = new BlockingLinkedDeque<>(6);
        this.aOF = 0;
        this.aOH = 0L;
        this.aOI = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.DragImageView.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        DragImageView.this.Ij();
                        break;
                    case 1:
                        if (DragImageView.this.aOI) {
                            DragImageView.this.Ij();
                            break;
                        }
                        break;
                    case 2:
                        DragImageView.this.invalidate();
                        DragImageView.this.aOH = System.currentTimeMillis();
                        DragImageView.this.mHandler.sendEmptyMessage(0);
                        break;
                }
                return false;
            }
        });
        initData();
    }

    public void setDragToExitListener(d dVar) {
        this.azD = dVar;
    }

    public int getImageType() {
        return this.ajF;
    }

    public void setImageMode(int i) {
        this.aOg = i;
    }

    public void setOffset(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.ayb = i;
    }

    public boolean HV() {
        if (this.aOx != null) {
            return this.aOx.HV();
        }
        return false;
    }

    public void HW() {
        this.aOm = false;
        this.aOd = false;
        this.mMode = 3;
        Ic();
        if (this.mCurrentScale < this.aOa) {
            this.mCurrentScale = this.aOa;
            Ii();
        }
        invalidate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.aOx != null && this.aOx.onTouchEvent(motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.aOd = true;
                this.aOl = false;
                this.aOm = false;
                break;
            case 1:
                HW();
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
            this.aOk = r(motionEvent);
            if (this.aOk > 10.0f) {
                this.mMode = 2;
            }
        }
        if (this.mMode == 2 || !this.mGestureDetector.onTouchEvent(motionEvent)) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.aOl = true;
                        this.aOm = true;
                        if (this.ajF != 1 && this.ajF != 2) {
                            float r = r(motionEvent);
                            if (r >= 0.0f && Math.abs(this.aOk - r) >= 10.0f) {
                                if (Math.abs(this.aOk - r) > 100.0f) {
                                    this.aOk = r;
                                    break;
                                } else {
                                    float f2 = r / this.aOk;
                                    this.aOk = r;
                                    this.aOc = this.mCurrentScale;
                                    this.mCurrentScale *= f2;
                                    if (this.mCurrentScale > this.aOb) {
                                        this.mCurrentScale = this.aOb;
                                    }
                                    float minScaleValue = getMinScaleValue();
                                    if (this.mCurrentScale < minScaleValue) {
                                        this.mCurrentScale = minScaleValue;
                                    }
                                    Ii();
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
        return this.aOx != null ? this.aOx.getMinScaleValue() : this.aOa / 4.0f;
    }

    public float r(MotionEvent motionEvent) {
        return CompatibleUtile.getInstance().getSpacing(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            this.mViewWidth = i3 - i;
            this.mViewHeight = i4 - i2;
            HY();
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public boolean HX() {
        if (this.aOx != null) {
            return this.aOx.IY();
        }
        return this.aOa == this.mCurrentScale;
    }

    protected float h(Bitmap bitmap) {
        if (this.aOx != null) {
            return this.aOx.Jc();
        }
        if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            return 1.0f;
        }
        if (this.aOg == 0) {
            float width = this.mViewWidth / bitmap.getWidth();
            float height = this.mViewHeight / bitmap.getHeight();
            if (this.aOv) {
                if (this.ajF == 2) {
                    return 2.5f;
                }
                return Math.min(width, height);
            } else if (this.ajF != 2) {
                float f2 = this.aOw;
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

    protected float i(Bitmap bitmap) {
        if (this.aOx != null) {
            return this.aOx.Jd();
        }
        float f2 = 1.0f;
        if (bitmap != null && !bitmap.isRecycled() && bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
            f2 = (float) Math.sqrt(this.aOf / (bitmap.getWidth() * bitmap.getHeight()));
            if (f2 > 10.0f) {
                return 10.0f;
            }
        }
        return f2;
    }

    private void HY() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            this.aOa = h(imageBitmap);
            this.aOb = i(imageBitmap);
            this.aNZ.clear();
            this.aNZ.add(Float.valueOf(this.aOa));
            this.mCurrentScale = this.aOa;
            this.aOc = this.mCurrentScale;
            Ii();
            return;
        }
        this.aNX = 0.0f;
        this.aNY = 0.0f;
        this.aOa = 1.0f;
        this.aOb = 1.0f;
        this.mCurrentScale = 1.0f;
        this.aOc = this.mCurrentScale;
        this.aNZ.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    private void HZ() {
        if (this.aOh != null) {
            this.aOh.a(this, canZoomIn(), canZoomOut());
        }
    }

    public void setOnSizeChangedListener(f fVar) {
        this.aOh = fVar;
    }

    public byte[] getImageData() {
        return this.aOe;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getMeasuredHeight() != 0 && getMeasuredWidth() != 0 && this.aOx != null) {
            this.aOx.Ja();
        }
    }

    public void setImageData(Bitmap bitmap, byte[] bArr) {
        this.aOe = bArr;
        if (this.aOx != null) {
            this.aOx.a(bitmap, bArr);
        }
        setImageBitmap(bitmap);
    }

    public void Ia() {
        if (this.aOx == null) {
            this.aOx = new com.baidu.tbadk.widget.largeImage.logic.b(this);
            this.aOx.setOnClickListener(this.aOi);
            this.aOx.setOnLongClickListener(this.axX);
        }
    }

    public void setImageLoadCallBack(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
        if (this.aOx != null) {
            this.aOx.a(aVar);
        }
    }

    public boolean Ib() {
        return (getImageBitmap() == null || this.aOx == null) ? false : true;
    }

    public Bitmap getGifCache() {
        return this.aOp;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        boolean z;
        if (this.aOx == null || !this.aOx.b(canvas, getImageBitmap())) {
            if (this.ajF == 2 && this.aOt != 0 && !this.aOj.Im()) {
                int width = getWidth();
                int height = getHeight();
                Drawable drawable = getDrawable();
                float f2 = 0.0f;
                float f3 = height * 0.3f;
                float f4 = width;
                float f5 = (1.0f - 0.3f) * height;
                if (this.aOv && drawable != null) {
                    Rect bounds = drawable.getBounds();
                    int i = bounds.right - bounds.left;
                    int i2 = bounds.bottom - bounds.top;
                    f2 = (width / 2) - (i * 2.5f);
                    f3 = (height / 2) - (i2 * 2.5f);
                    f4 = (i * 2.5f) + (width / 2);
                    f5 = (i2 * 2.5f) + (height / 2);
                }
                this.mPaint.setColor(ak.getColor(this.aOt));
                canvas.drawRect(f2, f3, f4, f5, this.mPaint);
                this.mPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
            }
            if (this.mMode == 3 && this.azw) {
                this.azw = false;
                this.azy.reset();
                if (this.azx < azE) {
                    this.mMode = 0;
                } else {
                    this.mMode = 4;
                    Cd();
                }
            }
            if (this.ajF == 0 && this.azw && this.azz != null && this.aOy != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                if (this.azA == null) {
                    this.azA = new RectF();
                }
                this.azy.mapRect(this.azA, new RectF(this.azz));
                Bitmap imageBitmap = getImageBitmap();
                if (imageBitmap != null && !imageBitmap.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.aOA, this.azA, (Paint) null);
                }
            } else if (this.mMode == 4 && this.azz != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                Bitmap imageBitmap2 = getImageBitmap();
                if (imageBitmap2 != null && !imageBitmap2.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.aOA, this.azA, (Paint) null);
                }
            } else {
                super.onDraw(canvas);
            }
            if (this.ajF == 1 && this.aOp != null && !this.aOp.isRecycled()) {
                int width2 = this.aOp.getWidth();
                int height2 = this.aOp.getHeight();
                int width3 = getWidth();
                int height3 = getHeight();
                int i3 = (width3 - width2) >> 1;
                int i4 = (height3 - height2) >> 1;
                float f6 = this.aOw;
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
                if (this.aOn == 1 && this.aOo != null && this.aOC != null && this.aOC.aOR != null) {
                    if (z) {
                        canvas.drawBitmap(this.aOC.aOR, i3, i4, (Paint) null);
                    } else {
                        canvas.drawBitmap(this.aOC.aOR, this.mMatrix, this.mPaint);
                    }
                    invalidate();
                } else if (z) {
                    canvas.drawBitmap(this.aOp, i3, i4, (Paint) null);
                } else {
                    canvas.drawBitmap(this.aOp, this.mMatrix, this.mPaint);
                }
            }
        }
    }

    public void play() {
        com.baidu.adp.widget.ImageView.a aVar;
        if (this.ajF == 1) {
            if (this.aOo == null) {
                if (this.aOG != null) {
                    this.aOG.mIsRunning = false;
                    this.aOG.interrupt();
                    this.aOG = null;
                }
                if (this.aOe != null) {
                    try {
                        aVar = a.C0004a.dl().g(this.aOe, 0, this.aOe.length);
                    } catch (StackOverflowError e2) {
                        aVar = null;
                    }
                    if (aVar == null || aVar.getGif() == null) {
                        com.baidu.tbadk.core.d.a.a("gifplay", -1L, -1, "DragImageView.play", -1, "decode error", new Object[0]);
                        return;
                    }
                    this.aOo = aVar.getGif();
                    if (this.aOo != null) {
                        this.aOn = 1;
                        this.width = this.aOo.getWidth();
                        this.height = this.aOo.getHeight();
                        this.aOF = 0;
                        this.aOB = this.aOo.getFrameCount();
                    } else {
                        this.aOn = 0;
                    }
                } else {
                    return;
                }
            }
            if (this.aOo != null) {
                if (this.aOG == null || (this.aOG != null && !this.aOG.mIsRunning)) {
                    this.aOI = true;
                    this.aOG = new b();
                    this.aOD.clear();
                    this.aOE.clear();
                    this.aOG.mIsRunning = true;
                    this.aOG.start();
                }
            }
        }
    }

    public void pause() {
        if (this.ajF == 1) {
            if (this.aOG != null) {
                this.aOG.mIsRunning = false;
                this.aOG.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.ajF == 1) {
            if (this.aOG != null) {
                this.aOG.mIsRunning = false;
                this.aOG.interrupt();
                this.aOG = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.aOI = true;
            this.aOC = null;
            this.aOE.clear();
            this.aOD.clear();
            this.width = 0;
            this.height = 0;
            this.aOF = 0;
            this.aOB = 0;
            this.aOo = null;
        }
    }

    private void initData() {
        this.aOw = l.ai(getContext());
        this.aOf = l.ah(getContext()) * l.af(getContext()) * 2;
        if (this.aOf < 1690000) {
            this.aOf = 1690000;
        }
        this.aNX = 0.0f;
        this.aNY = 0.0f;
        this.aNZ = new ArrayList<>();
        this.aOa = 1.0f;
        this.aOb = 1.0f;
        this.mCurrentScale = 1.0f;
        this.aOc = this.mCurrentScale;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.aOj = new a();
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWillNotDraw(false);
        scrollTo(0, 0);
        this.mGestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.DragImageView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                if (DragImageView.this.ajF != 2 && (Math.abs(f2) > 200.0f || Math.abs(f3) > 200.0f)) {
                    DragImageView.this.aOj.f(f2, f3);
                    DragImageView.this.startAnimation(DragImageView.this.aOj);
                }
                return super.onFling(motionEvent, motionEvent2, f2, f3);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (DragImageView.this.ajF != 1 && DragImageView.this.ajF != 2) {
                    DragImageView.this.mMode = 2;
                    if (DragImageView.this.mCurrentScale > DragImageView.this.aOa) {
                        DragImageView.this.mCurrentScale = DragImageView.this.aOa;
                        DragImageView.this.aOc = DragImageView.this.mCurrentScale;
                        DragImageView.this.Ii();
                        return true;
                    }
                    DragImageView.this.mCurrentScale = DragImageView.this.aOa * 2.0f;
                    DragImageView.this.e(true, (int) motionEvent.getX(), (int) motionEvent.getY());
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (DragImageView.this.aOi != null && !DragImageView.this.aOl) {
                    DragImageView.this.aOi.onClick(DragImageView.this);
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
                DragImageView.this.aOl = true;
                if (DragImageView.this.aOg == 0 && DragImageView.this.aOm) {
                    return false;
                }
                int scrollX = DragImageView.this.getScrollX();
                int scrollY = DragImageView.this.getScrollY();
                if (DragImageView.this.aNX >= DragImageView.this.getWidth()) {
                    scrollX = (int) (scrollX + f2);
                    if (DragImageView.this.aOg == 0) {
                        i = scrollX >= 0 ? scrollX : 0;
                        if (DragImageView.this.getWidth() + i > DragImageView.this.aNX) {
                            i = (int) (DragImageView.this.aNX - DragImageView.this.getWidth());
                        }
                        if (DragImageView.this.aNY + DragImageView.this.mTop + DragImageView.this.mBottom < DragImageView.this.getHeight()) {
                            i2 = (int) (scrollY + f3);
                            if (DragImageView.this.aOg == 0) {
                                if (i2 < (-DragImageView.this.aOq)) {
                                    i2 = -DragImageView.this.aOq;
                                }
                                if (DragImageView.this.getHeight() + i2 > DragImageView.this.aNY + DragImageView.this.mBottom + DragImageView.this.aOr) {
                                    i2 = (int) ((DragImageView.this.aNY - DragImageView.this.getHeight()) + DragImageView.this.mBottom + DragImageView.this.aOr);
                                }
                            }
                        } else {
                            i2 = scrollY;
                        }
                        if (i == DragImageView.this.getScrollX() || i2 != DragImageView.this.getScrollY()) {
                            DragImageView.this.scrollTo(i, i2);
                            DragImageView.this.invalidate();
                        }
                        return true;
                    }
                }
                i = scrollX;
                if (DragImageView.this.aNY + DragImageView.this.mTop + DragImageView.this.mBottom < DragImageView.this.getHeight()) {
                }
                if (i == DragImageView.this.getScrollX()) {
                }
                DragImageView.this.scrollTo(i, i2);
                DragImageView.this.invalidate();
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (DragImageView.this.axX != null && !DragImageView.this.aOl) {
                    DragImageView.this.axX.onLongClick(DragImageView.this);
                }
                super.onLongPress(motionEvent);
            }
        });
    }

    private void Cd() {
        if (this.aOy == null) {
            if (this.azD != null) {
                this.azD.Io();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.aOy.getSourceImageRectInScreen();
        if (sourceImageRectInScreen == null) {
            if (this.azD != null) {
                this.azD.Io();
                return;
            }
            return;
        }
        this.azA.bottom = (((sourceImageRectInScreen.bottom - sourceImageRectInScreen.top) / (sourceImageRectInScreen.right - sourceImageRectInScreen.left)) * (this.azA.right - this.azA.left)) + this.azA.top;
        final float[] fArr = {(this.azA.left + this.azA.right) / 2.0f, (this.azA.top + this.azA.bottom) / 2.0f};
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
                    DragImageView.this.azA = DragImageView.this.f(floatValue, animatedFraction, sourceImageRectInScreen.right - sourceImageRectInScreen.left, sourceImageRectInScreen.bottom - sourceImageRectInScreen.top);
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
                DragImageView.this.azw = false;
                DragImageView.this.mMode = 4;
                DragImageView.this.invalidate();
                if (DragImageView.this.azD != null) {
                    DragImageView.this.azD.Io();
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
    public RectF f(float f2, float f3, float f4, float f5) {
        return new RectF(f2 - (f4 / 2.0f), f3 - (f5 / 2.0f), (f4 / 2.0f) + f2, (f5 / 2.0f) + f3);
    }

    private void Ic() {
        int i = 0;
        int scrollX = getScrollX();
        if (this.aNX >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.aNX) {
                scrollX = (int) (this.aNX - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.aNY + this.mTop + this.mBottom >= getHeight()) {
            i = scrollY < (-this.aOq) ? -this.aOq : scrollY;
            if (getHeight() + i > this.aNY + this.mBottom + this.aOr) {
                i = (int) ((this.aNY - getHeight()) + this.mBottom + this.aOr);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.aOx != null) {
            this.aOx.IZ();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.aNX;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.aNY;
    }

    public boolean Id() {
        if (this.ajF == 1 || this.ajF == 2) {
            return true;
        }
        return !this.aOm && getScrollX() >= ((int) (this.aNX - ((float) getWidth()))) + (-1);
    }

    public boolean Ie() {
        if (this.ajF == 1 || this.ajF == 2) {
            return true;
        }
        return !this.aOm && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.aOj.Im()) {
            this.aOj.stopAnimation();
        }
        this.aOt = 0;
        super.setImageBitmap(bitmap);
        HY();
        this.ajF = 0;
        if (this.azz == null) {
            int measuredWidth = getMeasuredWidth();
            float measuredWidth2 = ((1.0f * getMeasuredWidth()) / bitmap.getWidth()) * bitmap.getHeight();
            if (measuredWidth2 > getMeasuredHeight()) {
                measuredWidth2 = getMeasuredHeight();
            }
            RectF f2 = f(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
            this.azz = new Rect((int) f2.left, (int) f2.top, (int) f2.right, (int) f2.bottom);
        }
        if (this.aOA == null) {
            this.aOA = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
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
            if (this.aOj.Im()) {
                this.aOj.stopAnimation();
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            super.setImageBitmap(bitmap);
            super.setImageMatrix(this.mMatrix);
            scrollTo(scrollX, scrollY);
            this.ajF = 0;
        }
    }

    public void setGifData(byte[] bArr, Bitmap bitmap) {
        if (this.aOj.Im()) {
            this.aOj.stopAnimation();
        }
        super.setImageDrawable(null);
        stop();
        HY();
        this.ajF = 1;
        this.aOp = bitmap;
        this.aOe = bArr;
        if (this.aya != null) {
            this.aya.a(this);
        }
    }

    public void onDestroy() {
        if (this.aOj.Im()) {
            this.aOj.stopAnimation();
        }
        super.setImageDrawable(null);
        this.aOe = null;
        this.aOp = null;
        stop();
        if (this.aOo != null) {
            this.aOo.close();
            this.aOo = null;
        }
        if (this.aOx != null) {
            this.aOx.release();
            System.gc();
        }
    }

    public void release() {
        if (this.aOj.Im()) {
            this.aOj.stopAnimation();
        }
        stop();
        super.setImageDrawable(null);
        this.aOp = null;
    }

    public void setDefaultBitmap() {
        if (this.aOj.Im()) {
            this.aOj.stopAnimation();
        }
        try {
            if (this.aOv) {
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
        this.ajF = 2;
        HY();
    }

    public void If() {
        if (this.ajF != 1 && this.ajF != 2) {
            int size = this.aNZ.size();
            if (size > 0) {
                this.aNZ.add(Float.valueOf(this.aNZ.get(size - 1).floatValue() * 1.25f));
            } else {
                this.aNZ.add(Float.valueOf(this.aOa));
            }
            Ii();
        }
    }

    public void Ig() {
        if (this.ajF != 1 && this.ajF != 2) {
            int size = this.aNZ.size();
            if (size > 1) {
                this.aNZ.remove(size - 1);
            }
            Ii();
        }
    }

    public void Ih() {
        HZ();
        if (this.ajF != 1 && this.ajF != 2 && this.mCurrentScale != this.aOa) {
            this.aNZ.clear();
            this.aNZ.add(Float.valueOf(this.aOa));
            this.mCurrentScale = this.aOa;
            this.aOc = this.mCurrentScale;
            Ii();
        }
    }

    public boolean canZoomIn() {
        if (this.ajF == 1 || this.ajF == 2) {
            return false;
        }
        int size = this.aNZ.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.aNZ.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.aOf) && floatValue <= 5.0f;
    }

    public boolean canZoomOut() {
        if (this.ajF == 1 || this.ajF == 2) {
            return false;
        }
        int size = this.aNZ.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled()) {
            return false;
        }
        return size > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ii() {
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
                    int size = this.aNZ.size();
                    if (size > 0) {
                        f3 = this.aNZ.get(size - 1).floatValue();
                    } else {
                        f3 = this.aOa;
                    }
                    this.mCurrentScale = f3;
                }
                this.mMatrix.setScale(this.mCurrentScale, this.mCurrentScale);
                this.aNX = imageBitmap.getWidth() * this.mCurrentScale;
                this.aNY = imageBitmap.getHeight() * this.mCurrentScale;
                float width = this.aOc * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.aOc;
                this.aOq = this.mTop;
                this.aOr = 0;
                float f4 = this.aNX < ((float) this.mViewWidth) ? (int) ((this.mViewWidth - this.aNX) / 2.0f) : 0.0f;
                if (this.aNY < this.mViewHeight) {
                    f2 = (int) ((this.mViewHeight - this.aNY) / 2.0f);
                    if (this.aOg == 1 && f2 > this.mTop) {
                        f2 = this.mTop;
                    }
                    this.aOq = (int) (this.mTop - f2);
                    this.aOr = this.mTop - this.aOq;
                } else {
                    f2 = 0.0f;
                }
                this.aOs = (int) f4;
                this.mMatrix.postTranslate(f4, f2);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    int width2 = i > getWidth() ? getWidth() : i;
                    if (this.aNX <= screenWidth) {
                        width2 = 0;
                    } else if (this.aNX > screenWidth && this.aNX / 2.0f < screenWidth) {
                        width2 = (int) (width2 - (this.aNX / 4.0f));
                    }
                    scrollX = width2;
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.aNX - width) / 2.0f);
                    }
                    if (this.aNX <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.aNX) {
                        scrollX = (int) (this.aNX - getWidth());
                    }
                }
                if (scrollX > 0 && this.aNX - scrollX < getWidth()) {
                    scrollX = (int) (this.aNX - getWidth());
                }
                int i3 = this.mMode == 2 ? ((int) ((this.aNY - height) / 2.0f)) + scrollY : scrollY;
                if (this.aNY <= getHeight()) {
                    i3 = 0;
                } else if (getHeight() + i3 > this.aNY) {
                    i3 = (int) (this.aNY - getHeight());
                }
                setHorizontalScrollBarEnabled(false);
                setVerticalScrollBarEnabled(false);
                if (scrollX < 0) {
                    scrollX = 0;
                }
                scrollTo(scrollX, i3 >= 0 ? i3 : 0);
                setImageMatrix(this.mMatrix);
                HZ();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Animation {
        private boolean aOK = false;
        private boolean aOL = false;
        private long aOM;
        private long aON;
        private int aOO;
        private long aOP;
        private long aOQ;
        private int mStartY;

        public a() {
        }

        public void f(float f, float f2) {
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
            this.aOM = f;
            this.aON = f2;
            this.aOP = Math.abs((f * 1000.0f) / 2500.0f);
            this.aOQ = Math.abs((f2 * 1000.0f) / 2500.0f);
            setDuration(Math.max(this.aOP, this.aOQ));
            setInterpolator(DragImageView.this.aOz);
            this.aOO = DragImageView.this.getScrollX();
            this.mStartY = DragImageView.this.getScrollY();
            this.aOK = true;
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
            if (this.aOP > this.aOQ) {
                j = ((float) this.aOP) * f;
            } else {
                j = ((float) this.aOQ) * f;
            }
            float f2 = ((float) (j > this.aOP ? this.aOP : j)) / 1000.0f;
            if (this.aOM > 0) {
                i = this.aOO - ((int) (f2 * (((float) this.aOM) - ((2500.0f * f2) / 2.0f))));
            } else {
                i = this.aOO - ((int) (f2 * (((float) this.aOM) + ((2500.0f * f2) / 2.0f))));
            }
            if (j > this.aOQ) {
                j = this.aOQ;
            }
            float f3 = ((float) j) / 1000.0f;
            if (this.aON > 0) {
                i2 = this.mStartY - ((int) (f3 * (((float) this.aON) - ((2500.0f * f3) / 2.0f))));
            } else {
                i2 = this.mStartY - ((int) (f3 * (((float) this.aON) + ((2500.0f * f3) / 2.0f))));
            }
            if (DragImageView.this.aNY + DragImageView.this.mTop + DragImageView.this.mBottom > DragImageView.this.getHeight()) {
                if (i2 < (-DragImageView.this.aOq)) {
                    i2 = -DragImageView.this.aOq;
                }
                if (DragImageView.this.getHeight() + i2 > DragImageView.this.aNY + DragImageView.this.mBottom + DragImageView.this.aOr) {
                    i2 = (int) ((DragImageView.this.aNY - DragImageView.this.getHeight()) + DragImageView.this.mBottom + DragImageView.this.aOr);
                }
            } else {
                i2 = 0;
            }
            if (DragImageView.this.aNX > DragImageView.this.getWidth()) {
                int width = ((float) (DragImageView.this.getWidth() + i)) > DragImageView.this.aNX ? (int) (DragImageView.this.aNX - DragImageView.this.getWidth()) : i;
                if (width >= 0) {
                    i3 = width;
                }
            }
            DragImageView.this.scrollTo(i3, i2);
            DragImageView.this.invalidate();
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            if (!this.aOL) {
                if (DragImageView.this.aOd) {
                    this.aOK = false;
                    return false;
                }
                try {
                    if (super.getTransformation(j, transformation)) {
                        return true;
                    }
                    this.aOK = false;
                    return false;
                } catch (Exception e) {
                    this.aOK = false;
                    return false;
                }
            }
            this.aOL = false;
            this.aOK = false;
            return false;
        }

        public boolean Im() {
            return this.aOK;
        }

        public void stopAnimation() {
            this.aOL = true;
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.aOi = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.axX = onLongClickListener;
        if (this.aOx != null) {
            this.aOx.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setGifSetListener(e eVar) {
        this.aya = eVar;
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
    public void Ij() {
        long j;
        c poll = this.aOD.poll();
        if (poll == null) {
            this.aOI = true;
            return;
        }
        this.aOI = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.aOC != null) {
            j = this.aOC.delay - (currentTimeMillis - this.aOH);
            this.aOE.offer(this.aOC);
        } else {
            j = 0;
        }
        this.aOC = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public c Ik() {
        c poll = this.aOE.poll();
        if (poll == null) {
            poll = new c();
            try {
                poll.aOR = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
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
        return this.aOC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends Thread {
        private volatile boolean mIsRunning;

        private b() {
            this.mIsRunning = false;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (this.mIsRunning && DragImageView.this.aOo != null && DragImageView.this.aOB > 0 && DragImageView.this.width > 0 && DragImageView.this.height > 0) {
                try {
                    DragImageView.this.aOo.M(DragImageView.this.aOF);
                    c Ik = DragImageView.this.Ik();
                    if (Ik.aOR == null || (Ik.aOR.getWidth() != DragImageView.this.width && Ik.aOR.getHeight() != DragImageView.this.height)) {
                        try {
                            Ik.aOR = Bitmap.createBitmap(DragImageView.this.width, DragImageView.this.height, Bitmap.Config.ARGB_8888);
                        } catch (OutOfMemoryError e) {
                            TbadkCoreApplication.getInst().onAppMemoryLow();
                            try {
                                Ik.aOR = Bitmap.createBitmap(DragImageView.this.width, DragImageView.this.height, Bitmap.Config.ARGB_4444);
                            } catch (OutOfMemoryError e2) {
                                TbadkCoreApplication.getInst().onAppMemoryLow();
                            } catch (Throwable th) {
                                BdLog.e(th.getMessage());
                            }
                        } catch (Throwable th2) {
                            BdLog.e(th2.getMessage());
                        }
                    }
                    DragImageView.this.aOo.a(Ik.aOR, null);
                    Ik.delay = DragImageView.this.aOo.N(DragImageView.this.aOF);
                    DragImageView.A(DragImageView.this);
                    if (Ik.aOR == null) {
                        DragImageView.A(DragImageView.this);
                    }
                    DragImageView.this.aOF %= DragImageView.this.aOB;
                    DragImageView.this.aOD.put(Ik);
                    if (DragImageView.this.aOI) {
                        DragImageView.this.mHandler.sendEmptyMessage(1);
                    }
                } catch (Exception e3) {
                    return;
                }
            }
        }
    }

    public boolean Il() {
        return this.aOu;
    }

    public void setLoadBigImage(boolean z) {
        this.aOu = z;
    }

    public int getBottomOffset() {
        return this.aOr;
    }

    public int getLeftOffset() {
        return this.aOs;
    }
}
