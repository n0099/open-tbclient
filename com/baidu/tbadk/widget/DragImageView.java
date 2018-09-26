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
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class DragImageView extends ImageView {
    private static final String TAG = DragImageView.class.getSimpleName();
    private static final int aMl = l.aQ(TbadkCoreApplication.getInst()) / 5;
    private int Pm;
    private e aKA;
    private int aKB;
    private View.OnLongClickListener aKx;
    private boolean aMb;
    private float aMc;
    private Matrix aMd;
    private Rect aMe;
    private RectF aMf;
    private d aMk;
    public int aus;
    private boolean baA;
    private boolean baB;
    private int baC;
    private volatile com.baidu.adp.gif.b baD;
    private Bitmap baE;
    private int baF;
    private int baG;
    private int baH;
    private int baI;
    private boolean baJ;
    private boolean baK;
    private float baL;
    private com.baidu.tbadk.widget.largeImage.logic.b baM;
    private ImageUrlData baN;
    private Interpolator baO;
    private Rect baP;
    private int baQ;
    private c baR;
    private BlockingLinkedDeque<c> baS;
    private BlockingLinkedDeque<c> baT;
    private volatile int baU;
    private b baV;
    private volatile long baW;
    private volatile boolean baX;
    private int baj;
    private float bak;
    private float bal;
    private ArrayList<Float> bam;
    private float ban;
    private float bao;
    private float bap;
    private boolean baq;
    private byte[] bas;
    private int bat;
    private int bau;
    private g bav;
    private View.OnClickListener baw;
    private a bax;
    private f bay;
    private float baz;
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
        public Bitmap bbh;
        public int delay;
    }

    /* loaded from: classes.dex */
    public interface d {
        void Nt();

        void Nu();
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
        int i = dragImageView.baU;
        dragImageView.baU = i + 1;
        return i;
    }

    public void setIsHeadImage(boolean z) {
        this.baK = z;
    }

    public void setImageUrlData(ImageUrlData imageUrlData) {
        this.baN = imageUrlData;
    }

    public DragImageView(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.Pm = 0;
        this.baj = 0;
        this.baq = false;
        this.bas = null;
        this.aKB = 0;
        this.bat = 1300;
        this.bau = 0;
        this.bav = null;
        this.baw = null;
        this.aKx = null;
        this.aKA = null;
        this.baz = 1.0f;
        this.aus = 0;
        this.mMode = 0;
        this.baA = false;
        this.baB = false;
        this.baC = 0;
        this.baD = null;
        this.baE = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.baF = 0;
        this.baG = 0;
        this.baH = 0;
        this.baI = 0;
        this.baO = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.aMd = new Matrix();
        this.aMb = false;
        this.mRatio = 1.0f;
        this.aMc = 0.0f;
        this.aMf = new RectF();
        this.width = 0;
        this.height = 0;
        this.baQ = 0;
        this.baR = null;
        this.baS = new BlockingLinkedDeque<>(5);
        this.baT = new BlockingLinkedDeque<>(6);
        this.baU = 0;
        this.baW = 0L;
        this.baX = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.DragImageView.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        DragImageView.this.Np();
                        break;
                    case 1:
                        if (DragImageView.this.baX) {
                            DragImageView.this.Np();
                            break;
                        }
                        break;
                    case 2:
                        DragImageView.this.invalidate();
                        DragImageView.this.baW = System.currentTimeMillis();
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
        this.Pm = 0;
        this.baj = 0;
        this.baq = false;
        this.bas = null;
        this.aKB = 0;
        this.bat = 1300;
        this.bau = 0;
        this.bav = null;
        this.baw = null;
        this.aKx = null;
        this.aKA = null;
        this.baz = 1.0f;
        this.aus = 0;
        this.mMode = 0;
        this.baA = false;
        this.baB = false;
        this.baC = 0;
        this.baD = null;
        this.baE = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.baF = 0;
        this.baG = 0;
        this.baH = 0;
        this.baI = 0;
        this.baO = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.aMd = new Matrix();
        this.aMb = false;
        this.mRatio = 1.0f;
        this.aMc = 0.0f;
        this.aMf = new RectF();
        this.width = 0;
        this.height = 0;
        this.baQ = 0;
        this.baR = null;
        this.baS = new BlockingLinkedDeque<>(5);
        this.baT = new BlockingLinkedDeque<>(6);
        this.baU = 0;
        this.baW = 0L;
        this.baX = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.DragImageView.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        DragImageView.this.Np();
                        break;
                    case 1:
                        if (DragImageView.this.baX) {
                            DragImageView.this.Np();
                            break;
                        }
                        break;
                    case 2:
                        DragImageView.this.invalidate();
                        DragImageView.this.baW = System.currentTimeMillis();
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
        this.Pm = 0;
        this.baj = 0;
        this.baq = false;
        this.bas = null;
        this.aKB = 0;
        this.bat = 1300;
        this.bau = 0;
        this.bav = null;
        this.baw = null;
        this.aKx = null;
        this.aKA = null;
        this.baz = 1.0f;
        this.aus = 0;
        this.mMode = 0;
        this.baA = false;
        this.baB = false;
        this.baC = 0;
        this.baD = null;
        this.baE = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.baF = 0;
        this.baG = 0;
        this.baH = 0;
        this.baI = 0;
        this.baO = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.aMd = new Matrix();
        this.aMb = false;
        this.mRatio = 1.0f;
        this.aMc = 0.0f;
        this.aMf = new RectF();
        this.width = 0;
        this.height = 0;
        this.baQ = 0;
        this.baR = null;
        this.baS = new BlockingLinkedDeque<>(5);
        this.baT = new BlockingLinkedDeque<>(6);
        this.baU = 0;
        this.baW = 0L;
        this.baX = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.DragImageView.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        DragImageView.this.Np();
                        break;
                    case 1:
                        if (DragImageView.this.baX) {
                            DragImageView.this.Np();
                            break;
                        }
                        break;
                    case 2:
                        DragImageView.this.invalidate();
                        DragImageView.this.baW = System.currentTimeMillis();
                        DragImageView.this.mHandler.sendEmptyMessage(0);
                        break;
                }
                return false;
            }
        });
        initData();
    }

    public void setDragToExitListener(d dVar) {
        this.aMk = dVar;
    }

    public int getImageType() {
        return this.aus;
    }

    public void setImageMode(int i) {
        this.bau = i;
    }

    public void setOffset(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.aKB = i;
    }

    public boolean Nb() {
        if (this.baM != null) {
            return this.baM.Nb();
        }
        return false;
    }

    public void Nc() {
        this.baB = false;
        this.baq = false;
        this.mMode = 3;
        Ni();
        if (this.mCurrentScale < this.ban) {
            this.mCurrentScale = this.ban;
            No();
        }
        invalidate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.baM != null && this.baM.onTouchEvent(motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.baq = true;
                this.baA = false;
                this.baB = false;
                break;
            case 1:
                Nc();
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
            this.baz = t(motionEvent);
            if (this.baz > 10.0f) {
                this.mMode = 2;
            }
        }
        if (this.mMode == 2 || !this.mGestureDetector.onTouchEvent(motionEvent)) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.baA = true;
                        this.baB = true;
                        if (this.aus != 1 && this.aus != 2) {
                            float t = t(motionEvent);
                            if (t >= 0.0f && Math.abs(this.baz - t) >= 10.0f) {
                                if (Math.abs(this.baz - t) > 100.0f) {
                                    this.baz = t;
                                    break;
                                } else {
                                    float f2 = t / this.baz;
                                    this.baz = t;
                                    this.bap = this.mCurrentScale;
                                    this.mCurrentScale *= f2;
                                    if (this.mCurrentScale > this.bao) {
                                        this.mCurrentScale = this.bao;
                                    }
                                    float minScaleValue = getMinScaleValue();
                                    if (this.mCurrentScale < minScaleValue) {
                                        this.mCurrentScale = minScaleValue;
                                    }
                                    No();
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
        return this.baM != null ? this.baM.getMinScaleValue() : this.ban / 4.0f;
    }

    public float t(MotionEvent motionEvent) {
        return CompatibleUtile.getInstance().getSpacing(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            this.Pm = i3 - i;
            this.baj = i4 - i2;
            Ne();
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public boolean Nd() {
        if (this.baM != null) {
            return this.baM.Oe();
        }
        return this.ban == this.mCurrentScale;
    }

    protected float h(Bitmap bitmap) {
        if (this.baM != null) {
            return this.baM.Oi();
        }
        if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            return 1.0f;
        }
        if (this.bau == 0) {
            float width = this.Pm / bitmap.getWidth();
            float height = this.baj / bitmap.getHeight();
            if (this.baK) {
                if (this.aus == 2) {
                    return 2.5f;
                }
                return Math.min(width, height);
            } else if (this.aus != 2) {
                float f2 = this.baL;
                float f3 = f2 >= 1.0f ? f2 : 1.0f;
                if (bitmap.getWidth() * f3 >= this.Pm || bitmap.getHeight() * f3 >= this.baj) {
                    return Math.min(width, height);
                }
                return f3;
            } else {
                return 1.0f;
            }
        }
        return Math.max(this.Pm / bitmap.getWidth(), ((this.baj - this.mTop) - this.mBottom) / bitmap.getHeight());
    }

    protected float i(Bitmap bitmap) {
        if (this.baM != null) {
            return this.baM.Oj();
        }
        float f2 = 1.0f;
        if (bitmap != null && !bitmap.isRecycled() && bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
            f2 = (float) Math.sqrt(this.bat / (bitmap.getWidth() * bitmap.getHeight()));
            if (f2 > 10.0f) {
                return 10.0f;
            }
        }
        return f2;
    }

    private void Ne() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            this.ban = h(imageBitmap);
            this.bao = i(imageBitmap);
            this.bam.clear();
            this.bam.add(Float.valueOf(this.ban));
            this.mCurrentScale = this.ban;
            this.bap = this.mCurrentScale;
            No();
            return;
        }
        this.bak = 0.0f;
        this.bal = 0.0f;
        this.ban = 1.0f;
        this.bao = 1.0f;
        this.mCurrentScale = 1.0f;
        this.bap = this.mCurrentScale;
        this.bam.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    private void Nf() {
        if (this.bav != null) {
            this.bav.a(this, canZoomIn(), canZoomOut());
        }
    }

    public void setOnSizeChangedListener(g gVar) {
        this.bav = gVar;
    }

    public void setOnImageScrollListener(f fVar) {
        this.bay = fVar;
    }

    public byte[] getImageData() {
        return this.bas;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getMeasuredHeight() != 0 && getMeasuredWidth() != 0 && this.baM != null) {
            this.baM.Og();
        }
    }

    public void setImageData(Bitmap bitmap, byte[] bArr) {
        this.bas = bArr;
        if (this.baM != null) {
            this.baM.a(bitmap, bArr);
        }
        setImageBitmap(bitmap);
    }

    public void Ng() {
        if (this.baM == null) {
            this.baM = new com.baidu.tbadk.widget.largeImage.logic.b(this);
            this.baM.setOnClickListener(this.baw);
            this.baM.setOnLongClickListener(this.aKx);
        }
    }

    public void setImageLoadCallBack(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
        if (this.baM != null) {
            this.baM.a(aVar);
        }
    }

    public boolean Nh() {
        return (getImageBitmap() == null || this.baM == null) ? false : true;
    }

    public Bitmap getGifCache() {
        return this.baE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        boolean z;
        if (this.baM == null || !this.baM.b(canvas, getImageBitmap())) {
            if (this.aus == 2 && this.baI != 0 && !this.bax.Ns()) {
                int width = getWidth();
                int height = getHeight();
                Drawable drawable = getDrawable();
                float f2 = 0.0f;
                float f3 = height * 0.3f;
                float f4 = width;
                float f5 = (1.0f - 0.3f) * height;
                if (this.baK && drawable != null) {
                    Rect bounds = drawable.getBounds();
                    int i = bounds.right - bounds.left;
                    int i2 = bounds.bottom - bounds.top;
                    f2 = (width / 2) - (i * 2.5f);
                    f3 = (height / 2) - (i2 * 2.5f);
                    f4 = (i * 2.5f) + (width / 2);
                    f5 = (i2 * 2.5f) + (height / 2);
                }
                this.mPaint.setColor(al.getColor(this.baI));
                canvas.drawRect(f2, f3, f4, f5, this.mPaint);
                this.mPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
            }
            if (this.mMode == 3 && this.aMb) {
                this.aMb = false;
                this.aMd.reset();
                if (this.aMc < aMl) {
                    this.mMode = 0;
                } else {
                    this.mMode = 4;
                    Hk();
                }
            }
            if (this.aus == 0 && this.aMb && this.aMe != null && this.baN != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                if (this.aMf == null) {
                    this.aMf = new RectF();
                }
                this.aMd.mapRect(this.aMf, new RectF(this.aMe));
                Bitmap imageBitmap = getImageBitmap();
                if (imageBitmap != null && !imageBitmap.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.baP, this.aMf, (Paint) null);
                }
            } else if (this.mMode == 4 && this.aMe != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                Bitmap imageBitmap2 = getImageBitmap();
                if (imageBitmap2 != null && !imageBitmap2.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.baP, this.aMf, (Paint) null);
                }
            } else {
                super.onDraw(canvas);
            }
            if (this.aus == 1 && this.baE != null && !this.baE.isRecycled()) {
                int width2 = this.baE.getWidth();
                int height2 = this.baE.getHeight();
                int width3 = getWidth();
                int height3 = getHeight();
                int i3 = (width3 - width2) >> 1;
                int i4 = (height3 - height2) >> 1;
                float f6 = this.baL;
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
                if (this.baC == 1 && this.baD != null && this.baR != null && this.baR.bbh != null) {
                    if (z) {
                        canvas.drawBitmap(this.baR.bbh, i3, i4, (Paint) null);
                    } else {
                        canvas.drawBitmap(this.baR.bbh, this.mMatrix, this.mPaint);
                    }
                    invalidate();
                } else if (z) {
                    canvas.drawBitmap(this.baE, i3, i4, (Paint) null);
                } else {
                    canvas.drawBitmap(this.baE, this.mMatrix, this.mPaint);
                }
            }
        }
    }

    public void play() {
        com.baidu.adp.widget.ImageView.a aVar;
        if (this.aus == 1) {
            if (this.baD == null) {
                if (this.baV != null) {
                    this.baV.DG = false;
                    this.baV.interrupt();
                    this.baV = null;
                }
                if (this.bas != null) {
                    try {
                        aVar = a.C0012a.hh().g(this.bas, 0, this.bas.length);
                    } catch (StackOverflowError e2) {
                        aVar = null;
                    }
                    if (aVar == null || aVar.getGif() == null) {
                        com.baidu.tbadk.core.d.a.a("gifplay", -1L, -1, "DragImageView.play", -1, "decode error", new Object[0]);
                        return;
                    }
                    this.baD = aVar.getGif();
                    if (this.baD != null) {
                        this.baC = 1;
                        this.width = this.baD.getWidth();
                        this.height = this.baD.getHeight();
                        this.baU = 0;
                        this.baQ = this.baD.getFrameCount();
                    } else {
                        this.baC = 0;
                    }
                } else {
                    return;
                }
            }
            if (this.baD != null) {
                if (this.baV == null || (this.baV != null && !this.baV.DG)) {
                    this.baX = true;
                    this.baV = new b();
                    this.baS.clear();
                    this.baT.clear();
                    this.baV.DG = true;
                    this.baV.start();
                }
            }
        }
    }

    public void pause() {
        if (this.aus == 1) {
            if (this.baV != null) {
                this.baV.DG = false;
                this.baV.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.aus == 1) {
            if (this.baV != null) {
                this.baV.DG = false;
                this.baV.interrupt();
                this.baV = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.baX = true;
            this.baR = null;
            this.baT.clear();
            this.baS.clear();
            this.width = 0;
            this.height = 0;
            this.baU = 0;
            this.baQ = 0;
            this.baD = null;
        }
    }

    private void initData() {
        this.baL = l.aR(getContext());
        this.bat = l.aQ(getContext()) * l.aO(getContext()) * 2;
        if (this.bat < 1690000) {
            this.bat = 1690000;
        }
        this.bak = 0.0f;
        this.bal = 0.0f;
        this.bam = new ArrayList<>();
        this.ban = 1.0f;
        this.bao = 1.0f;
        this.mCurrentScale = 1.0f;
        this.bap = this.mCurrentScale;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.bax = new a();
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWillNotDraw(false);
        scrollTo(0, 0);
        this.mGestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.DragImageView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                if (DragImageView.this.aus != 2 && (Math.abs(f2) > 200.0f || Math.abs(f3) > 200.0f)) {
                    DragImageView.this.bax.m(f2, f3);
                    DragImageView.this.startAnimation(DragImageView.this.bax);
                }
                return super.onFling(motionEvent, motionEvent2, f2, f3);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (DragImageView.this.aus != 1 && DragImageView.this.aus != 2) {
                    DragImageView.this.mMode = 2;
                    if (DragImageView.this.mCurrentScale > DragImageView.this.ban) {
                        DragImageView.this.mCurrentScale = DragImageView.this.ban;
                        DragImageView.this.bap = DragImageView.this.mCurrentScale;
                        DragImageView.this.No();
                        return true;
                    }
                    DragImageView.this.mCurrentScale = DragImageView.this.ban * 2.0f;
                    DragImageView.this.a(true, (int) motionEvent.getX(), (int) motionEvent.getY());
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (DragImageView.this.baw != null && !DragImageView.this.baA) {
                    DragImageView.this.baw.onClick(DragImageView.this);
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
                DragImageView.this.baA = true;
                if (DragImageView.this.bau == 0 && DragImageView.this.baB) {
                    return false;
                }
                int scrollX = DragImageView.this.getScrollX();
                int scrollY = DragImageView.this.getScrollY();
                if (DragImageView.this.bak >= DragImageView.this.getWidth()) {
                    scrollX = (int) (scrollX + f2);
                    if (DragImageView.this.bau == 0) {
                        i = scrollX >= 0 ? scrollX : 0;
                        if (DragImageView.this.getWidth() + i > DragImageView.this.bak) {
                            i = (int) (DragImageView.this.bak - DragImageView.this.getWidth());
                        }
                        if (DragImageView.this.bal + DragImageView.this.mTop + DragImageView.this.mBottom < DragImageView.this.getHeight()) {
                            i2 = (int) (scrollY + f3);
                            if (DragImageView.this.bau == 0) {
                                if (i2 < (-DragImageView.this.baF)) {
                                    i2 = -DragImageView.this.baF;
                                }
                                if (DragImageView.this.getHeight() + i2 > DragImageView.this.bal + DragImageView.this.mBottom + DragImageView.this.baG) {
                                    i2 = (int) ((DragImageView.this.bal - DragImageView.this.getHeight()) + DragImageView.this.mBottom + DragImageView.this.baG);
                                }
                            }
                        } else {
                            i2 = scrollY;
                        }
                        if (i == DragImageView.this.getScrollX() || i2 != DragImageView.this.getScrollY()) {
                            DragImageView.this.scrollTo(i, i2);
                            DragImageView.this.invalidate();
                            if (DragImageView.this.bay != null) {
                                DragImageView.this.bay.a(DragImageView.this, i, i2);
                            }
                        }
                        return true;
                    }
                }
                i = scrollX;
                if (DragImageView.this.bal + DragImageView.this.mTop + DragImageView.this.mBottom < DragImageView.this.getHeight()) {
                }
                if (i == DragImageView.this.getScrollX()) {
                }
                DragImageView.this.scrollTo(i, i2);
                DragImageView.this.invalidate();
                if (DragImageView.this.bay != null) {
                }
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (DragImageView.this.aKx != null && !DragImageView.this.baA) {
                    DragImageView.this.aKx.onLongClick(DragImageView.this);
                }
                super.onLongPress(motionEvent);
            }
        });
    }

    private void Hk() {
        if (this.baN == null) {
            if (this.aMk != null) {
                this.aMk.Nu();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.baN.getSourceImageRectInScreen();
        if (sourceImageRectInScreen == null) {
            if (this.aMk != null) {
                this.aMk.Nu();
                return;
            }
            return;
        }
        this.aMf.bottom = (((sourceImageRectInScreen.bottom - sourceImageRectInScreen.top) / (sourceImageRectInScreen.right - sourceImageRectInScreen.left)) * (this.aMf.right - this.aMf.left)) + this.aMf.top;
        final float[] fArr = {(this.aMf.left + this.aMf.right) / 2.0f, (this.aMf.top + this.aMf.bottom) / 2.0f};
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
                    DragImageView.this.aMf = DragImageView.this.h(floatValue, animatedFraction, sourceImageRectInScreen.right - sourceImageRectInScreen.left, sourceImageRectInScreen.bottom - sourceImageRectInScreen.top);
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
                DragImageView.this.aMb = false;
                DragImageView.this.mMode = 4;
                DragImageView.this.invalidate();
                if (DragImageView.this.aMk != null) {
                    DragImageView.this.aMk.Nu();
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

    private void Ni() {
        int i = 0;
        int scrollX = getScrollX();
        if (this.bak >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.bak) {
                scrollX = (int) (this.bak - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.bal + this.mTop + this.mBottom >= getHeight()) {
            i = scrollY < (-this.baF) ? -this.baF : scrollY;
            if (getHeight() + i > this.bal + this.mBottom + this.baG) {
                i = (int) ((this.bal - getHeight()) + this.mBottom + this.baG);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
            if (this.bay != null) {
                this.bay.a(this, scrollX, i);
            }
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.baM != null) {
            this.baM.Of();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.bak;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.bal;
    }

    public boolean Nj() {
        if (this.aus == 1 || this.aus == 2) {
            return true;
        }
        return !this.baB && getScrollX() >= ((int) (this.bak - ((float) getWidth()))) + (-1);
    }

    public boolean Nk() {
        if (this.aus == 1 || this.aus == 2) {
            return true;
        }
        return !this.baB && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.bax.Ns()) {
            this.bax.stopAnimation();
        }
        this.baI = 0;
        super.setImageBitmap(bitmap);
        Ne();
        this.aus = 0;
        if (this.aMe == null) {
            int measuredWidth = getMeasuredWidth();
            float measuredWidth2 = ((1.0f * getMeasuredWidth()) / bitmap.getWidth()) * bitmap.getHeight();
            if (measuredWidth2 > getMeasuredHeight()) {
                measuredWidth2 = getMeasuredHeight();
            }
            RectF h = h(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
            this.aMe = new Rect((int) h.left, (int) h.top, (int) h.right, (int) h.bottom);
        }
        if (this.baP == null) {
            this.baP = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
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
            if (this.bax.Ns()) {
                this.bax.stopAnimation();
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            super.setImageBitmap(bitmap);
            super.setImageMatrix(this.mMatrix);
            scrollTo(scrollX, scrollY);
            this.aus = 0;
        }
    }

    public void setGifData(byte[] bArr, Bitmap bitmap) {
        if (this.bax.Ns()) {
            this.bax.stopAnimation();
        }
        super.setImageDrawable(null);
        stop();
        Ne();
        this.aus = 1;
        this.baE = bitmap;
        this.bas = bArr;
        if (this.aKA != null) {
            this.aKA.a(this);
        }
    }

    public void onDestroy() {
        if (this.bax.Ns()) {
            this.bax.stopAnimation();
        }
        super.setImageDrawable(null);
        this.bas = null;
        this.baE = null;
        stop();
        if (this.baD != null) {
            this.baD.close();
            this.baD = null;
        }
        if (this.baM != null) {
            this.baM.release();
            System.gc();
        }
    }

    public void release() {
        if (this.bax.Ns()) {
            this.bax.stopAnimation();
        }
        stop();
        super.setImageDrawable(null);
        this.baE = null;
    }

    public void setDefaultBitmap() {
        if (this.bax.Ns()) {
            this.bax.stopAnimation();
        }
        try {
            if (this.baK) {
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
        this.aus = 2;
        Ne();
    }

    public void Nl() {
        if (this.aus != 1 && this.aus != 2) {
            int size = this.bam.size();
            if (size > 0) {
                this.bam.add(Float.valueOf(this.bam.get(size - 1).floatValue() * 1.25f));
            } else {
                this.bam.add(Float.valueOf(this.ban));
            }
            No();
        }
    }

    public void Nm() {
        if (this.aus != 1 && this.aus != 2) {
            int size = this.bam.size();
            if (size > 1) {
                this.bam.remove(size - 1);
            }
            No();
        }
    }

    public void Nn() {
        Nf();
        if (this.aus != 1 && this.aus != 2 && this.mCurrentScale != this.ban) {
            this.bam.clear();
            this.bam.add(Float.valueOf(this.ban));
            this.mCurrentScale = this.ban;
            this.bap = this.mCurrentScale;
            No();
        }
    }

    public boolean canZoomIn() {
        if (this.aus == 1 || this.aus == 2) {
            return false;
        }
        int size = this.bam.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.bam.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.bat) && floatValue <= 5.0f;
    }

    public boolean canZoomOut() {
        if (this.aus == 1 || this.aus == 2) {
            return false;
        }
        int size = this.bam.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled()) {
            return false;
        }
        return size > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void No() {
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
                    int size = this.bam.size();
                    if (size > 0) {
                        f3 = this.bam.get(size - 1).floatValue();
                    } else {
                        f3 = this.ban;
                    }
                    this.mCurrentScale = f3;
                }
                this.mMatrix.setScale(this.mCurrentScale, this.mCurrentScale);
                this.bak = imageBitmap.getWidth() * this.mCurrentScale;
                this.bal = imageBitmap.getHeight() * this.mCurrentScale;
                float width = this.bap * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.bap;
                this.baF = this.mTop;
                this.baG = 0;
                float f4 = this.bak < ((float) this.Pm) ? (int) ((this.Pm - this.bak) / 2.0f) : 0.0f;
                if (this.bal < this.baj) {
                    f2 = (int) ((this.baj - this.bal) / 2.0f);
                    if (this.bau == 1 && f2 > this.mTop) {
                        f2 = this.mTop;
                    }
                    this.baF = (int) (this.mTop - f2);
                    this.baG = this.mTop - this.baF;
                } else {
                    f2 = 0.0f;
                }
                this.baH = (int) f4;
                this.mMatrix.postTranslate(f4, f2);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    int width2 = i > getWidth() ? getWidth() : i;
                    if (this.bak <= screenWidth) {
                        width2 = 0;
                    } else if (this.bak > screenWidth && this.bak / 2.0f < screenWidth) {
                        width2 = (int) (width2 - (this.bak / 4.0f));
                    }
                    scrollX = width2;
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.bak - width) / 2.0f);
                    }
                    if (this.bak <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.bak) {
                        scrollX = (int) (this.bak - getWidth());
                    }
                }
                if (scrollX > 0 && this.bak - scrollX < getWidth()) {
                    scrollX = (int) (this.bak - getWidth());
                }
                int i3 = this.mMode == 2 ? ((int) ((this.bal - height) / 2.0f)) + scrollY : scrollY;
                if (this.bal <= getHeight()) {
                    i3 = 0;
                } else if (getHeight() + i3 > this.bal) {
                    i3 = (int) (this.bal - getHeight());
                }
                setHorizontalScrollBarEnabled(false);
                setVerticalScrollBarEnabled(false);
                if (scrollX < 0) {
                    scrollX = 0;
                }
                scrollTo(scrollX, i3 >= 0 ? i3 : 0);
                setImageMatrix(this.mMatrix);
                Nf();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Animation {
        private boolean bbb = false;
        private boolean bbc = false;
        private long bbd;
        private long bbe;
        private long bbf;
        private long bbg;
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
            this.bbd = f;
            this.bbe = f2;
            this.bbf = Math.abs((f * 1000.0f) / 2500.0f);
            this.bbg = Math.abs((f2 * 1000.0f) / 2500.0f);
            setDuration(Math.max(this.bbf, this.bbg));
            setInterpolator(DragImageView.this.baO);
            this.mStartX = DragImageView.this.getScrollX();
            this.mStartY = DragImageView.this.getScrollY();
            this.bbb = true;
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
            if (this.bbf > this.bbg) {
                j = ((float) this.bbf) * f;
            } else {
                j = ((float) this.bbg) * f;
            }
            float f2 = ((float) (j > this.bbf ? this.bbf : j)) / 1000.0f;
            if (this.bbd > 0) {
                i = this.mStartX - ((int) (f2 * (((float) this.bbd) - ((2500.0f * f2) / 2.0f))));
            } else {
                i = this.mStartX - ((int) (f2 * (((float) this.bbd) + ((2500.0f * f2) / 2.0f))));
            }
            if (j > this.bbg) {
                j = this.bbg;
            }
            float f3 = ((float) j) / 1000.0f;
            if (this.bbe > 0) {
                i2 = this.mStartY - ((int) (f3 * (((float) this.bbe) - ((2500.0f * f3) / 2.0f))));
            } else {
                i2 = this.mStartY - ((int) (f3 * (((float) this.bbe) + ((2500.0f * f3) / 2.0f))));
            }
            if (DragImageView.this.bal + DragImageView.this.mTop + DragImageView.this.mBottom > DragImageView.this.getHeight()) {
                if (i2 < (-DragImageView.this.baF)) {
                    i2 = -DragImageView.this.baF;
                }
                if (DragImageView.this.getHeight() + i2 > DragImageView.this.bal + DragImageView.this.mBottom + DragImageView.this.baG) {
                    i2 = (int) ((DragImageView.this.bal - DragImageView.this.getHeight()) + DragImageView.this.mBottom + DragImageView.this.baG);
                }
            } else {
                i2 = 0;
            }
            if (DragImageView.this.bak > DragImageView.this.getWidth()) {
                int width = ((float) (DragImageView.this.getWidth() + i)) > DragImageView.this.bak ? (int) (DragImageView.this.bak - DragImageView.this.getWidth()) : i;
                if (width >= 0) {
                    i3 = width;
                }
            }
            DragImageView.this.scrollTo(i3, i2);
            DragImageView.this.invalidate();
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            if (!this.bbc) {
                if (DragImageView.this.baq) {
                    this.bbb = false;
                    return false;
                }
                try {
                    if (super.getTransformation(j, transformation)) {
                        return true;
                    }
                    this.bbb = false;
                    return false;
                } catch (Exception e) {
                    this.bbb = false;
                    return false;
                }
            }
            this.bbc = false;
            this.bbb = false;
            return false;
        }

        public boolean Ns() {
            return this.bbb;
        }

        public void stopAnimation() {
            this.bbc = true;
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.baw = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aKx = onLongClickListener;
        if (this.baM != null) {
            this.baM.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setGifSetListener(e eVar) {
        this.aKA = eVar;
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
    public void Np() {
        long j;
        c poll = this.baS.poll();
        if (poll == null) {
            this.baX = true;
            return;
        }
        this.baX = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.baR != null) {
            j = this.baR.delay - (currentTimeMillis - this.baW);
            this.baT.offer(this.baR);
        } else {
            j = 0;
        }
        this.baR = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public c Nq() {
        c poll = this.baT.poll();
        if (poll == null) {
            poll = new c();
            try {
                poll.bbh = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
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
        return this.baR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends Thread {
        private volatile boolean DG;

        private b() {
            this.DG = false;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (this.DG && DragImageView.this.baD != null && DragImageView.this.baQ > 0 && DragImageView.this.width > 0 && DragImageView.this.height > 0) {
                try {
                    DragImageView.this.baD.V(DragImageView.this.baU);
                    c Nq = DragImageView.this.Nq();
                    if (Nq.bbh == null || (Nq.bbh.getWidth() != DragImageView.this.width && Nq.bbh.getHeight() != DragImageView.this.height)) {
                        try {
                            Nq.bbh = Bitmap.createBitmap(DragImageView.this.width, DragImageView.this.height, Bitmap.Config.ARGB_8888);
                        } catch (OutOfMemoryError e) {
                            TbadkCoreApplication.getInst().onAppMemoryLow();
                            try {
                                Nq.bbh = Bitmap.createBitmap(DragImageView.this.width, DragImageView.this.height, Bitmap.Config.ARGB_4444);
                            } catch (OutOfMemoryError e2) {
                                TbadkCoreApplication.getInst().onAppMemoryLow();
                            } catch (Throwable th) {
                                BdLog.e(th.getMessage());
                            }
                        } catch (Throwable th2) {
                            BdLog.e(th2.getMessage());
                        }
                    }
                    DragImageView.this.baD.a(Nq.bbh, null);
                    Nq.delay = DragImageView.this.baD.W(DragImageView.this.baU);
                    DragImageView.B(DragImageView.this);
                    if (Nq.bbh == null) {
                        DragImageView.B(DragImageView.this);
                    }
                    DragImageView.this.baU %= DragImageView.this.baQ;
                    DragImageView.this.baS.put(Nq);
                    if (DragImageView.this.baX) {
                        DragImageView.this.mHandler.sendEmptyMessage(1);
                    }
                } catch (Exception e3) {
                    return;
                }
            }
        }
    }

    public boolean Nr() {
        return this.baJ;
    }

    public void setLoadBigImage(boolean z) {
        this.baJ = z;
    }

    public int getBottomOffset() {
        return this.baG;
    }

    public int getLeftOffset() {
        return this.baH;
    }
}
