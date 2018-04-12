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
    private static final int azD = l.ah(TbadkCoreApplication.getInst()) / 5;
    private float aNW;
    private float aNX;
    private ArrayList<Float> aNY;
    private float aNZ;
    private int aOA;
    private c aOB;
    private BlockingLinkedDeque<c> aOC;
    private BlockingLinkedDeque<c> aOD;
    private volatile int aOE;
    private b aOF;
    private volatile long aOG;
    private volatile boolean aOH;
    private float aOa;
    private float aOb;
    private boolean aOc;
    private byte[] aOd;
    private int aOe;
    private int aOf;
    private f aOg;
    private View.OnClickListener aOh;
    private a aOi;
    private float aOj;
    private boolean aOk;
    private boolean aOl;
    private int aOm;
    private volatile com.baidu.adp.gif.b aOn;
    private Bitmap aOo;
    private int aOp;
    private int aOq;
    private int aOr;
    private int aOs;
    private boolean aOt;
    private boolean aOu;
    private float aOv;
    private com.baidu.tbadk.widget.largeImage.logic.b aOw;
    private ImageUrlData aOx;
    private Interpolator aOy;
    private Rect aOz;
    public int ajF;
    private View.OnLongClickListener axW;
    private e axZ;
    private int aya;
    private d azC;
    private boolean azv;
    private float azw;
    private Matrix azx;
    private Rect azy;
    private RectF azz;
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
        public Bitmap aOQ;
        public int delay;
    }

    /* loaded from: classes.dex */
    public interface d {
        void Ip();

        void Iq();
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
        int i = dragImageView.aOE;
        dragImageView.aOE = i + 1;
        return i;
    }

    public void setIsHeadImage(boolean z) {
        this.aOu = z;
    }

    public void setImageUrlData(ImageUrlData imageUrlData) {
        this.aOx = imageUrlData;
    }

    public DragImageView(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aOc = false;
        this.aOd = null;
        this.aya = 0;
        this.aOe = 1300;
        this.aOf = 0;
        this.aOg = null;
        this.aOh = null;
        this.axW = null;
        this.axZ = null;
        this.aOj = 1.0f;
        this.ajF = 0;
        this.mMode = 0;
        this.aOk = false;
        this.aOl = false;
        this.aOm = 0;
        this.aOn = null;
        this.aOo = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aOp = 0;
        this.aOq = 0;
        this.aOr = 0;
        this.aOs = 0;
        this.aOy = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.azx = new Matrix();
        this.azv = false;
        this.mRatio = 1.0f;
        this.azw = 0.0f;
        this.azz = new RectF();
        this.width = 0;
        this.height = 0;
        this.aOA = 0;
        this.aOB = null;
        this.aOC = new BlockingLinkedDeque<>(5);
        this.aOD = new BlockingLinkedDeque<>(6);
        this.aOE = 0;
        this.aOG = 0L;
        this.aOH = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.DragImageView.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        DragImageView.this.Il();
                        break;
                    case 1:
                        if (DragImageView.this.aOH) {
                            DragImageView.this.Il();
                            break;
                        }
                        break;
                    case 2:
                        DragImageView.this.invalidate();
                        DragImageView.this.aOG = System.currentTimeMillis();
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
        this.aOc = false;
        this.aOd = null;
        this.aya = 0;
        this.aOe = 1300;
        this.aOf = 0;
        this.aOg = null;
        this.aOh = null;
        this.axW = null;
        this.axZ = null;
        this.aOj = 1.0f;
        this.ajF = 0;
        this.mMode = 0;
        this.aOk = false;
        this.aOl = false;
        this.aOm = 0;
        this.aOn = null;
        this.aOo = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aOp = 0;
        this.aOq = 0;
        this.aOr = 0;
        this.aOs = 0;
        this.aOy = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.azx = new Matrix();
        this.azv = false;
        this.mRatio = 1.0f;
        this.azw = 0.0f;
        this.azz = new RectF();
        this.width = 0;
        this.height = 0;
        this.aOA = 0;
        this.aOB = null;
        this.aOC = new BlockingLinkedDeque<>(5);
        this.aOD = new BlockingLinkedDeque<>(6);
        this.aOE = 0;
        this.aOG = 0L;
        this.aOH = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.DragImageView.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        DragImageView.this.Il();
                        break;
                    case 1:
                        if (DragImageView.this.aOH) {
                            DragImageView.this.Il();
                            break;
                        }
                        break;
                    case 2:
                        DragImageView.this.invalidate();
                        DragImageView.this.aOG = System.currentTimeMillis();
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
        this.aOc = false;
        this.aOd = null;
        this.aya = 0;
        this.aOe = 1300;
        this.aOf = 0;
        this.aOg = null;
        this.aOh = null;
        this.axW = null;
        this.axZ = null;
        this.aOj = 1.0f;
        this.ajF = 0;
        this.mMode = 0;
        this.aOk = false;
        this.aOl = false;
        this.aOm = 0;
        this.aOn = null;
        this.aOo = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aOp = 0;
        this.aOq = 0;
        this.aOr = 0;
        this.aOs = 0;
        this.aOy = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.azx = new Matrix();
        this.azv = false;
        this.mRatio = 1.0f;
        this.azw = 0.0f;
        this.azz = new RectF();
        this.width = 0;
        this.height = 0;
        this.aOA = 0;
        this.aOB = null;
        this.aOC = new BlockingLinkedDeque<>(5);
        this.aOD = new BlockingLinkedDeque<>(6);
        this.aOE = 0;
        this.aOG = 0L;
        this.aOH = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.DragImageView.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        DragImageView.this.Il();
                        break;
                    case 1:
                        if (DragImageView.this.aOH) {
                            DragImageView.this.Il();
                            break;
                        }
                        break;
                    case 2:
                        DragImageView.this.invalidate();
                        DragImageView.this.aOG = System.currentTimeMillis();
                        DragImageView.this.mHandler.sendEmptyMessage(0);
                        break;
                }
                return false;
            }
        });
        initData();
    }

    public void setDragToExitListener(d dVar) {
        this.azC = dVar;
    }

    public int getImageType() {
        return this.ajF;
    }

    public void setImageMode(int i) {
        this.aOf = i;
    }

    public void setOffset(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.aya = i;
    }

    public boolean HX() {
        if (this.aOw != null) {
            return this.aOw.HX();
        }
        return false;
    }

    public void HY() {
        this.aOl = false;
        this.aOc = false;
        this.mMode = 3;
        Ie();
        if (this.mCurrentScale < this.aNZ) {
            this.mCurrentScale = this.aNZ;
            Ik();
        }
        invalidate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.aOw != null && this.aOw.onTouchEvent(motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.aOc = true;
                this.aOk = false;
                this.aOl = false;
                break;
            case 1:
                HY();
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
            this.aOj = r(motionEvent);
            if (this.aOj > 10.0f) {
                this.mMode = 2;
            }
        }
        if (this.mMode == 2 || !this.mGestureDetector.onTouchEvent(motionEvent)) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.aOk = true;
                        this.aOl = true;
                        if (this.ajF != 1 && this.ajF != 2) {
                            float r = r(motionEvent);
                            if (r >= 0.0f && Math.abs(this.aOj - r) >= 10.0f) {
                                if (Math.abs(this.aOj - r) > 100.0f) {
                                    this.aOj = r;
                                    break;
                                } else {
                                    float f2 = r / this.aOj;
                                    this.aOj = r;
                                    this.aOb = this.mCurrentScale;
                                    this.mCurrentScale *= f2;
                                    if (this.mCurrentScale > this.aOa) {
                                        this.mCurrentScale = this.aOa;
                                    }
                                    float minScaleValue = getMinScaleValue();
                                    if (this.mCurrentScale < minScaleValue) {
                                        this.mCurrentScale = minScaleValue;
                                    }
                                    Ik();
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
        return this.aOw != null ? this.aOw.getMinScaleValue() : this.aNZ / 4.0f;
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
            Ia();
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public boolean HZ() {
        if (this.aOw != null) {
            return this.aOw.Ja();
        }
        return this.aNZ == this.mCurrentScale;
    }

    protected float h(Bitmap bitmap) {
        if (this.aOw != null) {
            return this.aOw.Je();
        }
        if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            return 1.0f;
        }
        if (this.aOf == 0) {
            float width = this.mViewWidth / bitmap.getWidth();
            float height = this.mViewHeight / bitmap.getHeight();
            if (this.aOu) {
                if (this.ajF == 2) {
                    return 2.5f;
                }
                return Math.min(width, height);
            } else if (this.ajF != 2) {
                float f2 = this.aOv;
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
        if (this.aOw != null) {
            return this.aOw.Jf();
        }
        float f2 = 1.0f;
        if (bitmap != null && !bitmap.isRecycled() && bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
            f2 = (float) Math.sqrt(this.aOe / (bitmap.getWidth() * bitmap.getHeight()));
            if (f2 > 10.0f) {
                return 10.0f;
            }
        }
        return f2;
    }

    private void Ia() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            this.aNZ = h(imageBitmap);
            this.aOa = i(imageBitmap);
            this.aNY.clear();
            this.aNY.add(Float.valueOf(this.aNZ));
            this.mCurrentScale = this.aNZ;
            this.aOb = this.mCurrentScale;
            Ik();
            return;
        }
        this.aNW = 0.0f;
        this.aNX = 0.0f;
        this.aNZ = 1.0f;
        this.aOa = 1.0f;
        this.mCurrentScale = 1.0f;
        this.aOb = this.mCurrentScale;
        this.aNY.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    private void Ib() {
        if (this.aOg != null) {
            this.aOg.a(this, canZoomIn(), canZoomOut());
        }
    }

    public void setOnSizeChangedListener(f fVar) {
        this.aOg = fVar;
    }

    public byte[] getImageData() {
        return this.aOd;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getMeasuredHeight() != 0 && getMeasuredWidth() != 0 && this.aOw != null) {
            this.aOw.Jc();
        }
    }

    public void setImageData(Bitmap bitmap, byte[] bArr) {
        this.aOd = bArr;
        if (this.aOw != null) {
            this.aOw.a(bitmap, bArr);
        }
        setImageBitmap(bitmap);
    }

    public void Ic() {
        if (this.aOw == null) {
            this.aOw = new com.baidu.tbadk.widget.largeImage.logic.b(this);
            this.aOw.setOnClickListener(this.aOh);
            this.aOw.setOnLongClickListener(this.axW);
        }
    }

    public void setImageLoadCallBack(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
        if (this.aOw != null) {
            this.aOw.a(aVar);
        }
    }

    public boolean Id() {
        return (getImageBitmap() == null || this.aOw == null) ? false : true;
    }

    public Bitmap getGifCache() {
        return this.aOo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        boolean z;
        if (this.aOw == null || !this.aOw.b(canvas, getImageBitmap())) {
            if (this.ajF == 2 && this.aOs != 0 && !this.aOi.Io()) {
                int width = getWidth();
                int height = getHeight();
                Drawable drawable = getDrawable();
                float f2 = 0.0f;
                float f3 = height * 0.3f;
                float f4 = width;
                float f5 = (1.0f - 0.3f) * height;
                if (this.aOu && drawable != null) {
                    Rect bounds = drawable.getBounds();
                    int i = bounds.right - bounds.left;
                    int i2 = bounds.bottom - bounds.top;
                    f2 = (width / 2) - (i * 2.5f);
                    f3 = (height / 2) - (i2 * 2.5f);
                    f4 = (i * 2.5f) + (width / 2);
                    f5 = (i2 * 2.5f) + (height / 2);
                }
                this.mPaint.setColor(ak.getColor(this.aOs));
                canvas.drawRect(f2, f3, f4, f5, this.mPaint);
                this.mPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
            }
            if (this.mMode == 3 && this.azv) {
                this.azv = false;
                this.azx.reset();
                if (this.azw < azD) {
                    this.mMode = 0;
                } else {
                    this.mMode = 4;
                    Cf();
                }
            }
            if (this.ajF == 0 && this.azv && this.azy != null && this.aOx != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                if (this.azz == null) {
                    this.azz = new RectF();
                }
                this.azx.mapRect(this.azz, new RectF(this.azy));
                Bitmap imageBitmap = getImageBitmap();
                if (imageBitmap != null && !imageBitmap.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.aOz, this.azz, (Paint) null);
                }
            } else if (this.mMode == 4 && this.azy != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                Bitmap imageBitmap2 = getImageBitmap();
                if (imageBitmap2 != null && !imageBitmap2.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.aOz, this.azz, (Paint) null);
                }
            } else {
                super.onDraw(canvas);
            }
            if (this.ajF == 1 && this.aOo != null && !this.aOo.isRecycled()) {
                int width2 = this.aOo.getWidth();
                int height2 = this.aOo.getHeight();
                int width3 = getWidth();
                int height3 = getHeight();
                int i3 = (width3 - width2) >> 1;
                int i4 = (height3 - height2) >> 1;
                float f6 = this.aOv;
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
                if (this.aOm == 1 && this.aOn != null && this.aOB != null && this.aOB.aOQ != null) {
                    if (z) {
                        canvas.drawBitmap(this.aOB.aOQ, i3, i4, (Paint) null);
                    } else {
                        canvas.drawBitmap(this.aOB.aOQ, this.mMatrix, this.mPaint);
                    }
                    invalidate();
                } else if (z) {
                    canvas.drawBitmap(this.aOo, i3, i4, (Paint) null);
                } else {
                    canvas.drawBitmap(this.aOo, this.mMatrix, this.mPaint);
                }
            }
        }
    }

    public void play() {
        com.baidu.adp.widget.ImageView.a aVar;
        if (this.ajF == 1) {
            if (this.aOn == null) {
                if (this.aOF != null) {
                    this.aOF.mIsRunning = false;
                    this.aOF.interrupt();
                    this.aOF = null;
                }
                if (this.aOd != null) {
                    try {
                        aVar = a.C0004a.dl().g(this.aOd, 0, this.aOd.length);
                    } catch (StackOverflowError e2) {
                        aVar = null;
                    }
                    if (aVar == null || aVar.getGif() == null) {
                        com.baidu.tbadk.core.d.a.a("gifplay", -1L, -1, "DragImageView.play", -1, "decode error", new Object[0]);
                        return;
                    }
                    this.aOn = aVar.getGif();
                    if (this.aOn != null) {
                        this.aOm = 1;
                        this.width = this.aOn.getWidth();
                        this.height = this.aOn.getHeight();
                        this.aOE = 0;
                        this.aOA = this.aOn.getFrameCount();
                    } else {
                        this.aOm = 0;
                    }
                } else {
                    return;
                }
            }
            if (this.aOn != null) {
                if (this.aOF == null || (this.aOF != null && !this.aOF.mIsRunning)) {
                    this.aOH = true;
                    this.aOF = new b();
                    this.aOC.clear();
                    this.aOD.clear();
                    this.aOF.mIsRunning = true;
                    this.aOF.start();
                }
            }
        }
    }

    public void pause() {
        if (this.ajF == 1) {
            if (this.aOF != null) {
                this.aOF.mIsRunning = false;
                this.aOF.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.ajF == 1) {
            if (this.aOF != null) {
                this.aOF.mIsRunning = false;
                this.aOF.interrupt();
                this.aOF = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.aOH = true;
            this.aOB = null;
            this.aOD.clear();
            this.aOC.clear();
            this.width = 0;
            this.height = 0;
            this.aOE = 0;
            this.aOA = 0;
            this.aOn = null;
        }
    }

    private void initData() {
        this.aOv = l.ai(getContext());
        this.aOe = l.ah(getContext()) * l.af(getContext()) * 2;
        if (this.aOe < 1690000) {
            this.aOe = 1690000;
        }
        this.aNW = 0.0f;
        this.aNX = 0.0f;
        this.aNY = new ArrayList<>();
        this.aNZ = 1.0f;
        this.aOa = 1.0f;
        this.mCurrentScale = 1.0f;
        this.aOb = this.mCurrentScale;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.aOi = new a();
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
                    DragImageView.this.aOi.f(f2, f3);
                    DragImageView.this.startAnimation(DragImageView.this.aOi);
                }
                return super.onFling(motionEvent, motionEvent2, f2, f3);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (DragImageView.this.ajF != 1 && DragImageView.this.ajF != 2) {
                    DragImageView.this.mMode = 2;
                    if (DragImageView.this.mCurrentScale > DragImageView.this.aNZ) {
                        DragImageView.this.mCurrentScale = DragImageView.this.aNZ;
                        DragImageView.this.aOb = DragImageView.this.mCurrentScale;
                        DragImageView.this.Ik();
                        return true;
                    }
                    DragImageView.this.mCurrentScale = DragImageView.this.aNZ * 2.0f;
                    DragImageView.this.e(true, (int) motionEvent.getX(), (int) motionEvent.getY());
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (DragImageView.this.aOh != null && !DragImageView.this.aOk) {
                    DragImageView.this.aOh.onClick(DragImageView.this);
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
                DragImageView.this.aOk = true;
                if (DragImageView.this.aOf == 0 && DragImageView.this.aOl) {
                    return false;
                }
                int scrollX = DragImageView.this.getScrollX();
                int scrollY = DragImageView.this.getScrollY();
                if (DragImageView.this.aNW >= DragImageView.this.getWidth()) {
                    scrollX = (int) (scrollX + f2);
                    if (DragImageView.this.aOf == 0) {
                        i = scrollX >= 0 ? scrollX : 0;
                        if (DragImageView.this.getWidth() + i > DragImageView.this.aNW) {
                            i = (int) (DragImageView.this.aNW - DragImageView.this.getWidth());
                        }
                        if (DragImageView.this.aNX + DragImageView.this.mTop + DragImageView.this.mBottom < DragImageView.this.getHeight()) {
                            i2 = (int) (scrollY + f3);
                            if (DragImageView.this.aOf == 0) {
                                if (i2 < (-DragImageView.this.aOp)) {
                                    i2 = -DragImageView.this.aOp;
                                }
                                if (DragImageView.this.getHeight() + i2 > DragImageView.this.aNX + DragImageView.this.mBottom + DragImageView.this.aOq) {
                                    i2 = (int) ((DragImageView.this.aNX - DragImageView.this.getHeight()) + DragImageView.this.mBottom + DragImageView.this.aOq);
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
                if (DragImageView.this.aNX + DragImageView.this.mTop + DragImageView.this.mBottom < DragImageView.this.getHeight()) {
                }
                if (i == DragImageView.this.getScrollX()) {
                }
                DragImageView.this.scrollTo(i, i2);
                DragImageView.this.invalidate();
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (DragImageView.this.axW != null && !DragImageView.this.aOk) {
                    DragImageView.this.axW.onLongClick(DragImageView.this);
                }
                super.onLongPress(motionEvent);
            }
        });
    }

    private void Cf() {
        if (this.aOx == null) {
            if (this.azC != null) {
                this.azC.Iq();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.aOx.getSourceImageRectInScreen();
        if (sourceImageRectInScreen == null) {
            if (this.azC != null) {
                this.azC.Iq();
                return;
            }
            return;
        }
        this.azz.bottom = (((sourceImageRectInScreen.bottom - sourceImageRectInScreen.top) / (sourceImageRectInScreen.right - sourceImageRectInScreen.left)) * (this.azz.right - this.azz.left)) + this.azz.top;
        final float[] fArr = {(this.azz.left + this.azz.right) / 2.0f, (this.azz.top + this.azz.bottom) / 2.0f};
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
                    DragImageView.this.azz = DragImageView.this.f(floatValue, animatedFraction, sourceImageRectInScreen.right - sourceImageRectInScreen.left, sourceImageRectInScreen.bottom - sourceImageRectInScreen.top);
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
                DragImageView.this.azv = false;
                DragImageView.this.mMode = 4;
                DragImageView.this.invalidate();
                if (DragImageView.this.azC != null) {
                    DragImageView.this.azC.Iq();
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

    private void Ie() {
        int i = 0;
        int scrollX = getScrollX();
        if (this.aNW >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.aNW) {
                scrollX = (int) (this.aNW - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.aNX + this.mTop + this.mBottom >= getHeight()) {
            i = scrollY < (-this.aOp) ? -this.aOp : scrollY;
            if (getHeight() + i > this.aNX + this.mBottom + this.aOq) {
                i = (int) ((this.aNX - getHeight()) + this.mBottom + this.aOq);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.aOw != null) {
            this.aOw.Jb();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.aNW;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.aNX;
    }

    public boolean If() {
        if (this.ajF == 1 || this.ajF == 2) {
            return true;
        }
        return !this.aOl && getScrollX() >= ((int) (this.aNW - ((float) getWidth()))) + (-1);
    }

    public boolean Ig() {
        if (this.ajF == 1 || this.ajF == 2) {
            return true;
        }
        return !this.aOl && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.aOi.Io()) {
            this.aOi.stopAnimation();
        }
        this.aOs = 0;
        super.setImageBitmap(bitmap);
        Ia();
        this.ajF = 0;
        if (this.azy == null) {
            int measuredWidth = getMeasuredWidth();
            float measuredWidth2 = ((1.0f * getMeasuredWidth()) / bitmap.getWidth()) * bitmap.getHeight();
            if (measuredWidth2 > getMeasuredHeight()) {
                measuredWidth2 = getMeasuredHeight();
            }
            RectF f2 = f(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
            this.azy = new Rect((int) f2.left, (int) f2.top, (int) f2.right, (int) f2.bottom);
        }
        if (this.aOz == null) {
            this.aOz = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
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
            if (this.aOi.Io()) {
                this.aOi.stopAnimation();
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
        if (this.aOi.Io()) {
            this.aOi.stopAnimation();
        }
        super.setImageDrawable(null);
        stop();
        Ia();
        this.ajF = 1;
        this.aOo = bitmap;
        this.aOd = bArr;
        if (this.axZ != null) {
            this.axZ.a(this);
        }
    }

    public void onDestroy() {
        if (this.aOi.Io()) {
            this.aOi.stopAnimation();
        }
        super.setImageDrawable(null);
        this.aOd = null;
        this.aOo = null;
        stop();
        if (this.aOn != null) {
            this.aOn.close();
            this.aOn = null;
        }
        if (this.aOw != null) {
            this.aOw.release();
            System.gc();
        }
    }

    public void release() {
        if (this.aOi.Io()) {
            this.aOi.stopAnimation();
        }
        stop();
        super.setImageDrawable(null);
        this.aOo = null;
    }

    public void setDefaultBitmap() {
        if (this.aOi.Io()) {
            this.aOi.stopAnimation();
        }
        try {
            if (this.aOu) {
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
        Ia();
    }

    public void Ih() {
        if (this.ajF != 1 && this.ajF != 2) {
            int size = this.aNY.size();
            if (size > 0) {
                this.aNY.add(Float.valueOf(this.aNY.get(size - 1).floatValue() * 1.25f));
            } else {
                this.aNY.add(Float.valueOf(this.aNZ));
            }
            Ik();
        }
    }

    public void Ii() {
        if (this.ajF != 1 && this.ajF != 2) {
            int size = this.aNY.size();
            if (size > 1) {
                this.aNY.remove(size - 1);
            }
            Ik();
        }
    }

    public void Ij() {
        Ib();
        if (this.ajF != 1 && this.ajF != 2 && this.mCurrentScale != this.aNZ) {
            this.aNY.clear();
            this.aNY.add(Float.valueOf(this.aNZ));
            this.mCurrentScale = this.aNZ;
            this.aOb = this.mCurrentScale;
            Ik();
        }
    }

    public boolean canZoomIn() {
        if (this.ajF == 1 || this.ajF == 2) {
            return false;
        }
        int size = this.aNY.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.aNY.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.aOe) && floatValue <= 5.0f;
    }

    public boolean canZoomOut() {
        if (this.ajF == 1 || this.ajF == 2) {
            return false;
        }
        int size = this.aNY.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled()) {
            return false;
        }
        return size > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ik() {
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
                    int size = this.aNY.size();
                    if (size > 0) {
                        f3 = this.aNY.get(size - 1).floatValue();
                    } else {
                        f3 = this.aNZ;
                    }
                    this.mCurrentScale = f3;
                }
                this.mMatrix.setScale(this.mCurrentScale, this.mCurrentScale);
                this.aNW = imageBitmap.getWidth() * this.mCurrentScale;
                this.aNX = imageBitmap.getHeight() * this.mCurrentScale;
                float width = this.aOb * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.aOb;
                this.aOp = this.mTop;
                this.aOq = 0;
                float f4 = this.aNW < ((float) this.mViewWidth) ? (int) ((this.mViewWidth - this.aNW) / 2.0f) : 0.0f;
                if (this.aNX < this.mViewHeight) {
                    f2 = (int) ((this.mViewHeight - this.aNX) / 2.0f);
                    if (this.aOf == 1 && f2 > this.mTop) {
                        f2 = this.mTop;
                    }
                    this.aOp = (int) (this.mTop - f2);
                    this.aOq = this.mTop - this.aOp;
                } else {
                    f2 = 0.0f;
                }
                this.aOr = (int) f4;
                this.mMatrix.postTranslate(f4, f2);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    int width2 = i > getWidth() ? getWidth() : i;
                    if (this.aNW <= screenWidth) {
                        width2 = 0;
                    } else if (this.aNW > screenWidth && this.aNW / 2.0f < screenWidth) {
                        width2 = (int) (width2 - (this.aNW / 4.0f));
                    }
                    scrollX = width2;
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.aNW - width) / 2.0f);
                    }
                    if (this.aNW <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.aNW) {
                        scrollX = (int) (this.aNW - getWidth());
                    }
                }
                if (scrollX > 0 && this.aNW - scrollX < getWidth()) {
                    scrollX = (int) (this.aNW - getWidth());
                }
                int i3 = this.mMode == 2 ? ((int) ((this.aNX - height) / 2.0f)) + scrollY : scrollY;
                if (this.aNX <= getHeight()) {
                    i3 = 0;
                } else if (getHeight() + i3 > this.aNX) {
                    i3 = (int) (this.aNX - getHeight());
                }
                setHorizontalScrollBarEnabled(false);
                setVerticalScrollBarEnabled(false);
                if (scrollX < 0) {
                    scrollX = 0;
                }
                scrollTo(scrollX, i3 >= 0 ? i3 : 0);
                setImageMatrix(this.mMatrix);
                Ib();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Animation {
        private boolean aOJ = false;
        private boolean aOK = false;
        private long aOL;
        private long aOM;
        private int aON;
        private long aOO;
        private long aOP;
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
            this.aOL = f;
            this.aOM = f2;
            this.aOO = Math.abs((f * 1000.0f) / 2500.0f);
            this.aOP = Math.abs((f2 * 1000.0f) / 2500.0f);
            setDuration(Math.max(this.aOO, this.aOP));
            setInterpolator(DragImageView.this.aOy);
            this.aON = DragImageView.this.getScrollX();
            this.mStartY = DragImageView.this.getScrollY();
            this.aOJ = true;
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
            if (this.aOO > this.aOP) {
                j = ((float) this.aOO) * f;
            } else {
                j = ((float) this.aOP) * f;
            }
            float f2 = ((float) (j > this.aOO ? this.aOO : j)) / 1000.0f;
            if (this.aOL > 0) {
                i = this.aON - ((int) (f2 * (((float) this.aOL) - ((2500.0f * f2) / 2.0f))));
            } else {
                i = this.aON - ((int) (f2 * (((float) this.aOL) + ((2500.0f * f2) / 2.0f))));
            }
            if (j > this.aOP) {
                j = this.aOP;
            }
            float f3 = ((float) j) / 1000.0f;
            if (this.aOM > 0) {
                i2 = this.mStartY - ((int) (f3 * (((float) this.aOM) - ((2500.0f * f3) / 2.0f))));
            } else {
                i2 = this.mStartY - ((int) (f3 * (((float) this.aOM) + ((2500.0f * f3) / 2.0f))));
            }
            if (DragImageView.this.aNX + DragImageView.this.mTop + DragImageView.this.mBottom > DragImageView.this.getHeight()) {
                if (i2 < (-DragImageView.this.aOp)) {
                    i2 = -DragImageView.this.aOp;
                }
                if (DragImageView.this.getHeight() + i2 > DragImageView.this.aNX + DragImageView.this.mBottom + DragImageView.this.aOq) {
                    i2 = (int) ((DragImageView.this.aNX - DragImageView.this.getHeight()) + DragImageView.this.mBottom + DragImageView.this.aOq);
                }
            } else {
                i2 = 0;
            }
            if (DragImageView.this.aNW > DragImageView.this.getWidth()) {
                int width = ((float) (DragImageView.this.getWidth() + i)) > DragImageView.this.aNW ? (int) (DragImageView.this.aNW - DragImageView.this.getWidth()) : i;
                if (width >= 0) {
                    i3 = width;
                }
            }
            DragImageView.this.scrollTo(i3, i2);
            DragImageView.this.invalidate();
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            if (!this.aOK) {
                if (DragImageView.this.aOc) {
                    this.aOJ = false;
                    return false;
                }
                try {
                    if (super.getTransformation(j, transformation)) {
                        return true;
                    }
                    this.aOJ = false;
                    return false;
                } catch (Exception e) {
                    this.aOJ = false;
                    return false;
                }
            }
            this.aOK = false;
            this.aOJ = false;
            return false;
        }

        public boolean Io() {
            return this.aOJ;
        }

        public void stopAnimation() {
            this.aOK = true;
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.aOh = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.axW = onLongClickListener;
        if (this.aOw != null) {
            this.aOw.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setGifSetListener(e eVar) {
        this.axZ = eVar;
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
    public void Il() {
        long j;
        c poll = this.aOC.poll();
        if (poll == null) {
            this.aOH = true;
            return;
        }
        this.aOH = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.aOB != null) {
            j = this.aOB.delay - (currentTimeMillis - this.aOG);
            this.aOD.offer(this.aOB);
        } else {
            j = 0;
        }
        this.aOB = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public c Im() {
        c poll = this.aOD.poll();
        if (poll == null) {
            poll = new c();
            try {
                poll.aOQ = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
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
        return this.aOB;
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
            while (this.mIsRunning && DragImageView.this.aOn != null && DragImageView.this.aOA > 0 && DragImageView.this.width > 0 && DragImageView.this.height > 0) {
                try {
                    DragImageView.this.aOn.M(DragImageView.this.aOE);
                    c Im = DragImageView.this.Im();
                    if (Im.aOQ == null || (Im.aOQ.getWidth() != DragImageView.this.width && Im.aOQ.getHeight() != DragImageView.this.height)) {
                        try {
                            Im.aOQ = Bitmap.createBitmap(DragImageView.this.width, DragImageView.this.height, Bitmap.Config.ARGB_8888);
                        } catch (OutOfMemoryError e) {
                            TbadkCoreApplication.getInst().onAppMemoryLow();
                            try {
                                Im.aOQ = Bitmap.createBitmap(DragImageView.this.width, DragImageView.this.height, Bitmap.Config.ARGB_4444);
                            } catch (OutOfMemoryError e2) {
                                TbadkCoreApplication.getInst().onAppMemoryLow();
                            } catch (Throwable th) {
                                BdLog.e(th.getMessage());
                            }
                        } catch (Throwable th2) {
                            BdLog.e(th2.getMessage());
                        }
                    }
                    DragImageView.this.aOn.a(Im.aOQ, null);
                    Im.delay = DragImageView.this.aOn.N(DragImageView.this.aOE);
                    DragImageView.A(DragImageView.this);
                    if (Im.aOQ == null) {
                        DragImageView.A(DragImageView.this);
                    }
                    DragImageView.this.aOE %= DragImageView.this.aOA;
                    DragImageView.this.aOC.put(Im);
                    if (DragImageView.this.aOH) {
                        DragImageView.this.mHandler.sendEmptyMessage(1);
                    }
                } catch (Exception e3) {
                    return;
                }
            }
        }
    }

    public boolean In() {
        return this.aOt;
    }

    public void setLoadBigImage(boolean z) {
        this.aOt = z;
    }

    public int getBottomOffset() {
        return this.aOq;
    }

    public int getLeftOffset() {
        return this.aOr;
    }
}
