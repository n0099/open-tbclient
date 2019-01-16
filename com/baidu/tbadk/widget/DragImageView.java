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
    private static final int aVL = l.aQ(TbadkCoreApplication.getInst()) / 5;
    private int PO;
    public int aDV;
    private View.OnLongClickListener aTZ;
    private e aUc;
    private int aUd;
    private boolean aVB;
    private float aVC;
    private Matrix aVD;
    private Rect aVE;
    private RectF aVF;
    private d aVK;
    private int bjO;
    private float bjP;
    private float bjQ;
    private ArrayList<Float> bjR;
    private float bjS;
    private float bjT;
    private float bjU;
    private boolean bjV;
    private byte[] bjW;
    private int bjX;
    private int bjY;
    private g bjZ;
    private b bkA;
    private volatile long bkB;
    private volatile boolean bkC;
    private View.OnClickListener bka;
    private a bkb;
    private f bkc;
    private float bkd;
    private boolean bke;
    private boolean bkf;
    private int bkg;
    private volatile com.baidu.adp.gif.b bkh;
    private Bitmap bki;
    private int bkj;
    private int bkk;
    private int bkl;
    private int bkm;
    private boolean bkn;
    private boolean bko;
    private boolean bkp;
    private float bkq;
    private com.baidu.tbadk.widget.largeImage.logic.b bkr;
    private ImageUrlData bks;
    private Interpolator bkt;
    private Rect bku;
    private int bkv;
    private c bkw;
    private BlockingLinkedDeque<c> bkx;
    private BlockingLinkedDeque<c> bky;
    private volatile int bkz;
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
        public Bitmap bkM;
        public int delay;
    }

    /* loaded from: classes.dex */
    public interface d {
        void Rd();

        void Re();

        void Rf();
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
        int i = dragImageView.bkz;
        dragImageView.bkz = i + 1;
        return i;
    }

    public void setIsHeadImage(boolean z) {
        this.bkp = z;
    }

    public void setImageUrlData(ImageUrlData imageUrlData) {
        this.bks = imageUrlData;
    }

    public void setCanScale(boolean z) {
        this.bko = z;
    }

    public DragImageView(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.PO = 0;
        this.bjO = 0;
        this.bjV = false;
        this.bjW = null;
        this.aUd = 0;
        this.bjX = 1300;
        this.bjY = 0;
        this.bjZ = null;
        this.bka = null;
        this.aTZ = null;
        this.aUc = null;
        this.bkd = 1.0f;
        this.aDV = 0;
        this.mMode = 0;
        this.bke = false;
        this.bkf = false;
        this.bkg = 0;
        this.bkh = null;
        this.bki = null;
        this.mPaint = new Paint(-16777216);
        this.mTop = 0;
        this.mBottom = 0;
        this.bkj = 0;
        this.bkk = 0;
        this.bkl = 0;
        this.bkm = 0;
        this.bko = true;
        this.bkt = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.aVD = new Matrix();
        this.aVB = false;
        this.mRatio = 1.0f;
        this.aVC = 0.0f;
        this.aVF = new RectF();
        this.width = 0;
        this.height = 0;
        this.bkv = 0;
        this.bkw = null;
        this.bkx = new BlockingLinkedDeque<>(5);
        this.bky = new BlockingLinkedDeque<>(6);
        this.bkz = 0;
        this.bkB = 0L;
        this.bkC = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.DragImageView.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        DragImageView.this.QZ();
                        break;
                    case 1:
                        if (DragImageView.this.bkC) {
                            DragImageView.this.QZ();
                            break;
                        }
                        break;
                    case 2:
                        DragImageView.this.invalidate();
                        DragImageView.this.bkB = System.currentTimeMillis();
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
        this.PO = 0;
        this.bjO = 0;
        this.bjV = false;
        this.bjW = null;
        this.aUd = 0;
        this.bjX = 1300;
        this.bjY = 0;
        this.bjZ = null;
        this.bka = null;
        this.aTZ = null;
        this.aUc = null;
        this.bkd = 1.0f;
        this.aDV = 0;
        this.mMode = 0;
        this.bke = false;
        this.bkf = false;
        this.bkg = 0;
        this.bkh = null;
        this.bki = null;
        this.mPaint = new Paint(-16777216);
        this.mTop = 0;
        this.mBottom = 0;
        this.bkj = 0;
        this.bkk = 0;
        this.bkl = 0;
        this.bkm = 0;
        this.bko = true;
        this.bkt = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.aVD = new Matrix();
        this.aVB = false;
        this.mRatio = 1.0f;
        this.aVC = 0.0f;
        this.aVF = new RectF();
        this.width = 0;
        this.height = 0;
        this.bkv = 0;
        this.bkw = null;
        this.bkx = new BlockingLinkedDeque<>(5);
        this.bky = new BlockingLinkedDeque<>(6);
        this.bkz = 0;
        this.bkB = 0L;
        this.bkC = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.DragImageView.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        DragImageView.this.QZ();
                        break;
                    case 1:
                        if (DragImageView.this.bkC) {
                            DragImageView.this.QZ();
                            break;
                        }
                        break;
                    case 2:
                        DragImageView.this.invalidate();
                        DragImageView.this.bkB = System.currentTimeMillis();
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
        this.PO = 0;
        this.bjO = 0;
        this.bjV = false;
        this.bjW = null;
        this.aUd = 0;
        this.bjX = 1300;
        this.bjY = 0;
        this.bjZ = null;
        this.bka = null;
        this.aTZ = null;
        this.aUc = null;
        this.bkd = 1.0f;
        this.aDV = 0;
        this.mMode = 0;
        this.bke = false;
        this.bkf = false;
        this.bkg = 0;
        this.bkh = null;
        this.bki = null;
        this.mPaint = new Paint(-16777216);
        this.mTop = 0;
        this.mBottom = 0;
        this.bkj = 0;
        this.bkk = 0;
        this.bkl = 0;
        this.bkm = 0;
        this.bko = true;
        this.bkt = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.aVD = new Matrix();
        this.aVB = false;
        this.mRatio = 1.0f;
        this.aVC = 0.0f;
        this.aVF = new RectF();
        this.width = 0;
        this.height = 0;
        this.bkv = 0;
        this.bkw = null;
        this.bkx = new BlockingLinkedDeque<>(5);
        this.bky = new BlockingLinkedDeque<>(6);
        this.bkz = 0;
        this.bkB = 0L;
        this.bkC = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.DragImageView.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        DragImageView.this.QZ();
                        break;
                    case 1:
                        if (DragImageView.this.bkC) {
                            DragImageView.this.QZ();
                            break;
                        }
                        break;
                    case 2:
                        DragImageView.this.invalidate();
                        DragImageView.this.bkB = System.currentTimeMillis();
                        DragImageView.this.mHandler.sendEmptyMessage(0);
                        break;
                }
                return false;
            }
        });
        initData();
    }

    public void setDragToExitListener(d dVar) {
        this.aVK = dVar;
    }

    public int getImageType() {
        return this.aDV;
    }

    public void setImageMode(int i) {
        this.bjY = i;
    }

    public void setOffset(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.aUd = i;
    }

    public boolean QL() {
        if (this.bkr != null) {
            return this.bkr.QL();
        }
        return false;
    }

    public void QM() {
        this.bkf = false;
        this.bjV = false;
        this.mMode = 3;
        QS();
        if (this.mCurrentScale < this.bjS) {
            this.mCurrentScale = this.bjS;
            QY();
        }
        invalidate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.bkr != null && this.bkr.onTouchEvent(motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.bjV = true;
                this.bke = false;
                this.bkf = false;
                break;
            case 1:
                QM();
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
            this.bkd = t(motionEvent);
            if (this.bkd > 10.0f) {
                this.mMode = 2;
            }
        }
        if ((this.mMode == 2 || !this.mGestureDetector.onTouchEvent(motionEvent)) && this.bko) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.bke = true;
                        this.bkf = true;
                        if (this.aDV != 1 && this.aDV != 2) {
                            float t = t(motionEvent);
                            if (t >= 0.0f && Math.abs(this.bkd - t) >= 10.0f) {
                                if (Math.abs(this.bkd - t) > 100.0f) {
                                    this.bkd = t;
                                    break;
                                } else {
                                    float f2 = t / this.bkd;
                                    this.bkd = t;
                                    this.bjU = this.mCurrentScale;
                                    this.mCurrentScale *= f2;
                                    if (this.mCurrentScale > this.bjT) {
                                        this.mCurrentScale = this.bjT;
                                    }
                                    float minScaleValue = getMinScaleValue();
                                    if (this.mCurrentScale < minScaleValue) {
                                        this.mCurrentScale = minScaleValue;
                                    }
                                    QY();
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
        return this.bkr != null ? this.bkr.getMinScaleValue() : this.bjS / 4.0f;
    }

    public float t(MotionEvent motionEvent) {
        return CompatibleUtile.getInstance().getSpacing(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            this.PO = i3 - i;
            this.bjO = i4 - i2;
            QO();
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public boolean QN() {
        if (this.bkr != null) {
            return this.bkr.RN();
        }
        return this.bjS == this.mCurrentScale;
    }

    protected float h(Bitmap bitmap) {
        if (this.bkr != null) {
            return this.bkr.RR();
        }
        if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            return 1.0f;
        }
        if (this.bjY == 0) {
            float width = this.PO / bitmap.getWidth();
            float height = this.bjO / bitmap.getHeight();
            if (this.bkp) {
                if (this.aDV == 2) {
                    return 2.5f;
                }
                return Math.min(width, height);
            } else if (this.aDV != 2) {
                float f2 = this.bkq;
                float f3 = f2 >= 1.0f ? f2 : 1.0f;
                if (bitmap.getWidth() * f3 >= this.PO || bitmap.getHeight() * f3 >= this.bjO) {
                    return Math.min(width, height);
                }
                return f3;
            } else {
                return 1.0f;
            }
        }
        return Math.max(this.PO / bitmap.getWidth(), ((this.bjO - this.mTop) - this.mBottom) / bitmap.getHeight());
    }

    protected float i(Bitmap bitmap) {
        if (this.bkr != null) {
            return this.bkr.RS();
        }
        float f2 = 1.0f;
        if (bitmap != null && !bitmap.isRecycled() && bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
            f2 = (float) Math.sqrt(this.bjX / (bitmap.getWidth() * bitmap.getHeight()));
            if (f2 > 10.0f) {
                return 10.0f;
            }
        }
        return f2;
    }

    private void QO() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            this.bjS = h(imageBitmap);
            this.bjT = i(imageBitmap);
            this.bjR.clear();
            this.bjR.add(Float.valueOf(this.bjS));
            this.mCurrentScale = this.bjS;
            this.bjU = this.mCurrentScale;
            QY();
            return;
        }
        this.bjP = 0.0f;
        this.bjQ = 0.0f;
        this.bjS = 1.0f;
        this.bjT = 1.0f;
        this.mCurrentScale = 1.0f;
        this.bjU = this.mCurrentScale;
        this.bjR.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    private void QP() {
        if (this.bjZ != null) {
            this.bjZ.a(this, canZoomIn(), canZoomOut());
        }
    }

    public void setOnSizeChangedListener(g gVar) {
        this.bjZ = gVar;
    }

    public void setOnImageScrollListener(f fVar) {
        this.bkc = fVar;
    }

    public byte[] getImageData() {
        return this.bjW;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getMeasuredHeight() != 0 && getMeasuredWidth() != 0 && this.bkr != null) {
            this.bkr.RP();
        }
    }

    public void setImageData(Bitmap bitmap, byte[] bArr) {
        this.bjW = bArr;
        if (this.bkr != null) {
            this.bkr.a(bitmap, bArr);
        }
        setImageBitmap(bitmap);
    }

    public void QQ() {
        if (this.bkr == null) {
            this.bkr = new com.baidu.tbadk.widget.largeImage.logic.b(this);
            this.bkr.setOnClickListener(this.bka);
            this.bkr.setOnLongClickListener(this.aTZ);
        }
    }

    public void setImageLoadCallBack(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
        if (this.bkr != null) {
            this.bkr.a(aVar);
        }
    }

    public boolean QR() {
        return (getImageBitmap() == null || this.bkr == null) ? false : true;
    }

    public Bitmap getGifCache() {
        return this.bki;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        boolean z;
        if (this.bkr == null || !this.bkr.b(canvas, getImageBitmap())) {
            if (this.aDV == 2 && this.bkm != 0 && !this.bkb.Rc()) {
                int width = getWidth();
                int height = getHeight();
                Drawable drawable = getDrawable();
                float f2 = 0.0f;
                float f3 = height * 0.3f;
                float f4 = width;
                float f5 = (1.0f - 0.3f) * height;
                if (this.bkp && drawable != null) {
                    Rect bounds = drawable.getBounds();
                    int i = bounds.right - bounds.left;
                    int i2 = bounds.bottom - bounds.top;
                    f2 = (width / 2) - (i * 2.5f);
                    f3 = (height / 2) - (i2 * 2.5f);
                    f4 = (i * 2.5f) + (width / 2);
                    f5 = (i2 * 2.5f) + (height / 2);
                }
                this.mPaint.setColor(al.getColor(this.bkm));
                canvas.drawRect(f2, f3, f4, f5, this.mPaint);
                this.mPaint.setColor(-16777216);
            }
            if (this.mMode == 3 && this.aVB) {
                this.aVB = false;
                this.aVD.reset();
                if (this.aVC < aVL) {
                    this.mMode = 0;
                } else {
                    this.mMode = 4;
                    KR();
                }
            }
            if (this.aDV == 0 && this.aVB && this.aVE != null && this.bks != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                if (this.aVF == null) {
                    this.aVF = new RectF();
                }
                this.aVD.mapRect(this.aVF, new RectF(this.aVE));
                Bitmap imageBitmap = getImageBitmap();
                if (imageBitmap != null && !imageBitmap.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.bku, this.aVF, (Paint) null);
                }
            } else if (this.mMode == 4 && this.aVE != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                Bitmap imageBitmap2 = getImageBitmap();
                if (imageBitmap2 != null && !imageBitmap2.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.bku, this.aVF, (Paint) null);
                }
            } else {
                super.onDraw(canvas);
            }
            if (this.aDV == 1 && this.bki != null && !this.bki.isRecycled()) {
                int width2 = this.bki.getWidth();
                int height2 = this.bki.getHeight();
                int width3 = getWidth();
                int height3 = getHeight();
                int i3 = (width3 - width2) >> 1;
                int i4 = (height3 - height2) >> 1;
                float f6 = this.bkq;
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
                if (this.bkg == 1 && this.bkh != null && this.bkw != null && this.bkw.bkM != null) {
                    if (z) {
                        canvas.drawBitmap(this.bkw.bkM, i3, i4, (Paint) null);
                    } else {
                        canvas.drawBitmap(this.bkw.bkM, this.mMatrix, this.mPaint);
                    }
                    invalidate();
                } else if (z) {
                    canvas.drawBitmap(this.bki, i3, i4, (Paint) null);
                } else {
                    canvas.drawBitmap(this.bki, this.mMatrix, this.mPaint);
                }
            }
        }
    }

    public void play() {
        com.baidu.adp.widget.ImageView.a aVar;
        if (this.aDV == 1) {
            if (this.bkh == null) {
                if (this.bkA != null) {
                    this.bkA.Et = false;
                    this.bkA.interrupt();
                    this.bkA = null;
                }
                if (this.bjW != null) {
                    try {
                        aVar = a.C0015a.hx().g(this.bjW, 0, this.bjW.length);
                    } catch (StackOverflowError e2) {
                        aVar = null;
                    }
                    if (aVar == null || aVar.getGif() == null) {
                        com.baidu.tbadk.core.d.a.a("gifplay", -1L, -1, "DragImageView.play", -1, "decode error", new Object[0]);
                        return;
                    }
                    this.bkh = aVar.getGif();
                    if (this.bkh != null) {
                        this.bkg = 1;
                        this.width = this.bkh.getWidth();
                        this.height = this.bkh.getHeight();
                        this.bkz = 0;
                        this.bkv = this.bkh.getFrameCount();
                    } else {
                        this.bkg = 0;
                    }
                } else {
                    return;
                }
            }
            if (this.bkh != null) {
                if (this.bkA == null || (this.bkA != null && !this.bkA.Et)) {
                    this.bkC = true;
                    this.bkA = new b();
                    this.bkx.clear();
                    this.bky.clear();
                    this.bkA.Et = true;
                    this.bkA.start();
                }
            }
        }
    }

    public void pause() {
        if (this.aDV == 1) {
            if (this.bkA != null) {
                this.bkA.Et = false;
                this.bkA.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.aDV == 1) {
            if (this.bkA != null) {
                this.bkA.Et = false;
                this.bkA.interrupt();
                this.bkA = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.bkC = true;
            this.bkw = null;
            this.bky.clear();
            this.bkx.clear();
            this.width = 0;
            this.height = 0;
            this.bkz = 0;
            this.bkv = 0;
            this.bkh = null;
        }
    }

    private void initData() {
        this.bkq = l.aR(getContext());
        this.bjX = l.aQ(getContext()) * l.aO(getContext()) * 2;
        if (this.bjX < 1690000) {
            this.bjX = 1690000;
        }
        this.bjP = 0.0f;
        this.bjQ = 0.0f;
        this.bjR = new ArrayList<>();
        this.bjS = 1.0f;
        this.bjT = 1.0f;
        this.mCurrentScale = 1.0f;
        this.bjU = this.mCurrentScale;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.bkb = new a();
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWillNotDraw(false);
        scrollTo(0, 0);
        this.mGestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.DragImageView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                if (DragImageView.this.aDV != 2 && (Math.abs(f2) > 200.0f || Math.abs(f3) > 200.0f)) {
                    DragImageView.this.bkb.p(f2, f3);
                    DragImageView.this.startAnimation(DragImageView.this.bkb);
                }
                return super.onFling(motionEvent, motionEvent2, f2, f3);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (DragImageView.this.aDV == 1 || DragImageView.this.aDV == 2 || !DragImageView.this.bko) {
                    return false;
                }
                DragImageView.this.mMode = 2;
                if (DragImageView.this.mCurrentScale > DragImageView.this.bjS) {
                    DragImageView.this.mCurrentScale = DragImageView.this.bjS;
                    DragImageView.this.bjU = DragImageView.this.mCurrentScale;
                    DragImageView.this.QY();
                } else {
                    DragImageView.this.mCurrentScale = DragImageView.this.bjS * 2.0f;
                    DragImageView.this.a(true, (int) motionEvent.getX(), (int) motionEvent.getY());
                }
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (DragImageView.this.bka != null && !DragImageView.this.bke) {
                    DragImageView.this.bka.onClick(DragImageView.this);
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
                DragImageView.this.bke = true;
                if (DragImageView.this.bjY == 0 && DragImageView.this.bkf) {
                    return false;
                }
                int scrollX = DragImageView.this.getScrollX();
                int scrollY = DragImageView.this.getScrollY();
                if (DragImageView.this.bjP >= DragImageView.this.getWidth()) {
                    scrollX = (int) (scrollX + f2);
                    if (DragImageView.this.bjY == 0) {
                        i = scrollX >= 0 ? scrollX : 0;
                        if (DragImageView.this.getWidth() + i > DragImageView.this.bjP) {
                            i = (int) (DragImageView.this.bjP - DragImageView.this.getWidth());
                        }
                        if (DragImageView.this.bjQ + DragImageView.this.mTop + DragImageView.this.mBottom < DragImageView.this.getHeight()) {
                            i2 = (int) (scrollY + f3);
                            if (DragImageView.this.bjY == 0) {
                                if (i2 < (-DragImageView.this.bkj)) {
                                    i2 = -DragImageView.this.bkj;
                                }
                                if (DragImageView.this.getHeight() + i2 > DragImageView.this.bjQ + DragImageView.this.mBottom + DragImageView.this.bkk) {
                                    i2 = (int) ((DragImageView.this.bjQ - DragImageView.this.getHeight()) + DragImageView.this.mBottom + DragImageView.this.bkk);
                                }
                            }
                        } else {
                            i2 = scrollY;
                        }
                        if (i == DragImageView.this.getScrollX() || i2 != DragImageView.this.getScrollY()) {
                            DragImageView.this.scrollTo(i, i2);
                            DragImageView.this.invalidate();
                            if (DragImageView.this.bkc != null) {
                                DragImageView.this.bkc.a(DragImageView.this, i, i2);
                            }
                        }
                        return true;
                    }
                }
                i = scrollX;
                if (DragImageView.this.bjQ + DragImageView.this.mTop + DragImageView.this.mBottom < DragImageView.this.getHeight()) {
                }
                if (i == DragImageView.this.getScrollX()) {
                }
                DragImageView.this.scrollTo(i, i2);
                DragImageView.this.invalidate();
                if (DragImageView.this.bkc != null) {
                }
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (DragImageView.this.aTZ != null && !DragImageView.this.bke) {
                    DragImageView.this.aTZ.onLongClick(DragImageView.this);
                }
                super.onLongPress(motionEvent);
            }
        });
    }

    private void KR() {
        if (this.bks == null) {
            if (this.aVK != null) {
                this.aVK.Re();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.bks.getSourceImageRectInScreen();
        if (sourceImageRectInScreen == null) {
            if (this.aVK != null) {
                this.aVK.Re();
                return;
            }
            return;
        }
        this.aVF.bottom = (((sourceImageRectInScreen.bottom - sourceImageRectInScreen.top) / (sourceImageRectInScreen.right - sourceImageRectInScreen.left)) * (this.aVF.right - this.aVF.left)) + this.aVF.top;
        final float[] fArr = {(this.aVF.left + this.aVF.right) / 2.0f, (this.aVF.top + this.aVF.bottom) / 2.0f};
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
                    DragImageView.this.aVF = DragImageView.this.h(floatValue, animatedFraction, sourceImageRectInScreen.right - sourceImageRectInScreen.left, sourceImageRectInScreen.bottom - sourceImageRectInScreen.top);
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
                DragImageView.this.aVB = false;
                DragImageView.this.mMode = 4;
                DragImageView.this.invalidate();
                if (DragImageView.this.aVK != null) {
                    DragImageView.this.aVK.Re();
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

    private void QS() {
        int i = 0;
        int scrollX = getScrollX();
        if (this.bjP >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.bjP) {
                scrollX = (int) (this.bjP - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.bjQ + this.mTop + this.mBottom >= getHeight()) {
            i = scrollY < (-this.bkj) ? -this.bkj : scrollY;
            if (getHeight() + i > this.bjQ + this.mBottom + this.bkk) {
                i = (int) ((this.bjQ - getHeight()) + this.mBottom + this.bkk);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
            if (this.bkc != null) {
                this.bkc.a(this, scrollX, i);
            }
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.bkr != null) {
            this.bkr.RO();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.bjP;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.bjQ;
    }

    public boolean QT() {
        if (this.aDV == 1 || this.aDV == 2) {
            return true;
        }
        return !this.bkf && getScrollX() >= ((int) (this.bjP - ((float) getWidth()))) + (-1);
    }

    public boolean QU() {
        if (this.aDV == 1 || this.aDV == 2) {
            return true;
        }
        return !this.bkf && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.bkb.Rc()) {
            this.bkb.stopAnimation();
        }
        this.bkm = 0;
        super.setImageBitmap(bitmap);
        QO();
        this.aDV = 0;
        if (this.aVE == null) {
            int measuredWidth = getMeasuredWidth();
            float measuredWidth2 = ((1.0f * getMeasuredWidth()) / bitmap.getWidth()) * bitmap.getHeight();
            if (measuredWidth2 > getMeasuredHeight()) {
                measuredWidth2 = getMeasuredHeight();
            }
            RectF h = h(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
            this.aVE = new Rect((int) h.left, (int) h.top, (int) h.right, (int) h.bottom);
        }
        if (this.bku == null) {
            this.bku = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
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
            if (this.bkb.Rc()) {
                this.bkb.stopAnimation();
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            super.setImageBitmap(bitmap);
            super.setImageMatrix(this.mMatrix);
            scrollTo(scrollX, scrollY);
            this.aDV = 0;
        }
    }

    public void setGifData(byte[] bArr, Bitmap bitmap) {
        if (this.bkb.Rc()) {
            this.bkb.stopAnimation();
        }
        super.setImageDrawable(null);
        stop();
        QO();
        this.aDV = 1;
        this.bki = bitmap;
        this.bjW = bArr;
        if (this.aUc != null) {
            this.aUc.a(this);
        }
    }

    public void onDestroy() {
        if (this.bkb.Rc()) {
            this.bkb.stopAnimation();
        }
        super.setImageDrawable(null);
        this.bjW = null;
        this.bki = null;
        stop();
        if (this.bkh != null) {
            this.bkh.close();
            this.bkh = null;
        }
        if (this.bkr != null) {
            this.bkr.release();
            System.gc();
        }
    }

    public void release() {
        if (this.bkb.Rc()) {
            this.bkb.stopAnimation();
        }
        stop();
        super.setImageDrawable(null);
        this.bki = null;
    }

    public void setDefaultBitmap() {
        if (this.bkb.Rc()) {
            this.bkb.stopAnimation();
        }
        try {
            if (this.bkp) {
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
        this.aDV = 2;
        QO();
    }

    public void QV() {
        if (this.aDV != 1 && this.aDV != 2) {
            int size = this.bjR.size();
            if (size > 0) {
                this.bjR.add(Float.valueOf(this.bjR.get(size - 1).floatValue() * 1.25f));
            } else {
                this.bjR.add(Float.valueOf(this.bjS));
            }
            QY();
        }
    }

    public void QW() {
        if (this.aDV != 1 && this.aDV != 2) {
            int size = this.bjR.size();
            if (size > 1) {
                this.bjR.remove(size - 1);
            }
            QY();
        }
    }

    public void QX() {
        QP();
        if (this.aDV != 1 && this.aDV != 2 && this.mCurrentScale != this.bjS) {
            this.bjR.clear();
            this.bjR.add(Float.valueOf(this.bjS));
            this.mCurrentScale = this.bjS;
            this.bjU = this.mCurrentScale;
            QY();
        }
    }

    public boolean canZoomIn() {
        if (this.aDV == 1 || this.aDV == 2) {
            return false;
        }
        int size = this.bjR.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.bjR.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.bjX) && floatValue <= 5.0f;
    }

    public boolean canZoomOut() {
        if (this.aDV == 1 || this.aDV == 2) {
            return false;
        }
        int size = this.bjR.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled()) {
            return false;
        }
        return size > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QY() {
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
                    int size = this.bjR.size();
                    if (size > 0) {
                        f3 = this.bjR.get(size - 1).floatValue();
                    } else {
                        f3 = this.bjS;
                    }
                    this.mCurrentScale = f3;
                }
                this.mMatrix.setScale(this.mCurrentScale, this.mCurrentScale);
                this.bjP = imageBitmap.getWidth() * this.mCurrentScale;
                this.bjQ = imageBitmap.getHeight() * this.mCurrentScale;
                float width = this.bjU * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.bjU;
                this.bkj = this.mTop;
                this.bkk = 0;
                float f4 = this.bjP < ((float) this.PO) ? (int) ((this.PO - this.bjP) / 2.0f) : 0.0f;
                if (this.bjQ < this.bjO) {
                    f2 = (int) ((this.bjO - this.bjQ) / 2.0f);
                    if (this.bjY == 1 && f2 > this.mTop) {
                        f2 = this.mTop;
                    }
                    this.bkj = (int) (this.mTop - f2);
                    this.bkk = this.mTop - this.bkj;
                } else {
                    f2 = 0.0f;
                }
                this.bkl = (int) f4;
                this.mMatrix.postTranslate(f4, f2);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    int width2 = i > getWidth() ? getWidth() : i;
                    if (this.bjP <= screenWidth) {
                        width2 = 0;
                    } else if (this.bjP > screenWidth && this.bjP / 2.0f < screenWidth) {
                        width2 = (int) (width2 - (this.bjP / 4.0f));
                    }
                    scrollX = width2;
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.bjP - width) / 2.0f);
                    }
                    if (this.bjP <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.bjP) {
                        scrollX = (int) (this.bjP - getWidth());
                    }
                }
                if (scrollX > 0 && this.bjP - scrollX < getWidth()) {
                    scrollX = (int) (this.bjP - getWidth());
                }
                int i3 = this.mMode == 2 ? ((int) ((this.bjQ - height) / 2.0f)) + scrollY : scrollY;
                if (this.bjQ <= getHeight()) {
                    i3 = 0;
                } else if (getHeight() + i3 > this.bjQ) {
                    i3 = (int) (this.bjQ - getHeight());
                }
                setHorizontalScrollBarEnabled(false);
                setVerticalScrollBarEnabled(false);
                if (scrollX < 0) {
                    scrollX = 0;
                }
                scrollTo(scrollX, i3 >= 0 ? i3 : 0);
                setImageMatrix(this.mMatrix);
                QP();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Animation {
        private boolean bkG = false;
        private boolean bkH = false;
        private long bkI;
        private long bkJ;
        private long bkK;
        private long bkL;
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
            this.bkI = f;
            this.bkJ = f2;
            this.bkK = Math.abs((f * 1000.0f) / 2500.0f);
            this.bkL = Math.abs((f2 * 1000.0f) / 2500.0f);
            setDuration(Math.max(this.bkK, this.bkL));
            setInterpolator(DragImageView.this.bkt);
            this.mStartX = DragImageView.this.getScrollX();
            this.mStartY = DragImageView.this.getScrollY();
            this.bkG = true;
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
            if (this.bkK > this.bkL) {
                j = ((float) this.bkK) * f;
            } else {
                j = ((float) this.bkL) * f;
            }
            float f2 = ((float) (j > this.bkK ? this.bkK : j)) / 1000.0f;
            if (this.bkI > 0) {
                i = this.mStartX - ((int) (f2 * (((float) this.bkI) - ((2500.0f * f2) / 2.0f))));
            } else {
                i = this.mStartX - ((int) (f2 * (((float) this.bkI) + ((2500.0f * f2) / 2.0f))));
            }
            if (j > this.bkL) {
                j = this.bkL;
            }
            float f3 = ((float) j) / 1000.0f;
            if (this.bkJ > 0) {
                i2 = this.mStartY - ((int) (f3 * (((float) this.bkJ) - ((2500.0f * f3) / 2.0f))));
            } else {
                i2 = this.mStartY - ((int) (f3 * (((float) this.bkJ) + ((2500.0f * f3) / 2.0f))));
            }
            if (DragImageView.this.bjQ + DragImageView.this.mTop + DragImageView.this.mBottom > DragImageView.this.getHeight()) {
                if (i2 < (-DragImageView.this.bkj)) {
                    i2 = -DragImageView.this.bkj;
                }
                if (DragImageView.this.getHeight() + i2 > DragImageView.this.bjQ + DragImageView.this.mBottom + DragImageView.this.bkk) {
                    i2 = (int) ((DragImageView.this.bjQ - DragImageView.this.getHeight()) + DragImageView.this.mBottom + DragImageView.this.bkk);
                }
            } else {
                i2 = 0;
            }
            if (DragImageView.this.bjP > DragImageView.this.getWidth()) {
                int width = ((float) (DragImageView.this.getWidth() + i)) > DragImageView.this.bjP ? (int) (DragImageView.this.bjP - DragImageView.this.getWidth()) : i;
                if (width >= 0) {
                    i3 = width;
                }
            }
            DragImageView.this.scrollTo(i3, i2);
            DragImageView.this.invalidate();
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            if (!this.bkH) {
                if (DragImageView.this.bjV) {
                    this.bkG = false;
                    return false;
                }
                try {
                    if (super.getTransformation(j, transformation)) {
                        return true;
                    }
                    this.bkG = false;
                    return false;
                } catch (Exception e) {
                    this.bkG = false;
                    return false;
                }
            }
            this.bkH = false;
            this.bkG = false;
            return false;
        }

        public boolean Rc() {
            return this.bkG;
        }

        public void stopAnimation() {
            this.bkH = true;
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.bka = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aTZ = onLongClickListener;
        if (this.bkr != null) {
            this.bkr.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setGifSetListener(e eVar) {
        this.aUc = eVar;
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
    public void QZ() {
        long j;
        c poll = this.bkx.poll();
        if (poll == null) {
            this.bkC = true;
            return;
        }
        this.bkC = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.bkw != null) {
            j = this.bkw.delay - (currentTimeMillis - this.bkB);
            this.bky.offer(this.bkw);
        } else {
            j = 0;
        }
        this.bkw = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public c Ra() {
        c poll = this.bky.poll();
        if (poll == null) {
            poll = new c();
            try {
                poll.bkM = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
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
        return this.bkw;
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
            while (this.Et && DragImageView.this.bkh != null && DragImageView.this.bkv > 0 && DragImageView.this.width > 0 && DragImageView.this.height > 0) {
                try {
                    DragImageView.this.bkh.am(DragImageView.this.bkz);
                    c Ra = DragImageView.this.Ra();
                    if (Ra.bkM == null || (Ra.bkM.getWidth() != DragImageView.this.width && Ra.bkM.getHeight() != DragImageView.this.height)) {
                        try {
                            Ra.bkM = Bitmap.createBitmap(DragImageView.this.width, DragImageView.this.height, Bitmap.Config.ARGB_8888);
                        } catch (OutOfMemoryError e) {
                            TbadkCoreApplication.getInst().onAppMemoryLow();
                            try {
                                Ra.bkM = Bitmap.createBitmap(DragImageView.this.width, DragImageView.this.height, Bitmap.Config.ARGB_4444);
                            } catch (OutOfMemoryError e2) {
                                TbadkCoreApplication.getInst().onAppMemoryLow();
                            } catch (Throwable th) {
                                BdLog.e(th.getMessage());
                            }
                        } catch (Throwable th2) {
                            BdLog.e(th2.getMessage());
                        }
                    }
                    DragImageView.this.bkh.a(Ra.bkM, null);
                    Ra.delay = DragImageView.this.bkh.an(DragImageView.this.bkz);
                    DragImageView.C(DragImageView.this);
                    if (Ra.bkM == null) {
                        DragImageView.C(DragImageView.this);
                    }
                    DragImageView.this.bkz %= DragImageView.this.bkv;
                    DragImageView.this.bkx.put(Ra);
                    if (DragImageView.this.bkC) {
                        DragImageView.this.mHandler.sendEmptyMessage(1);
                    }
                } catch (Exception e3) {
                    return;
                }
            }
        }
    }

    public boolean Rb() {
        return this.bkn;
    }

    public void setLoadBigImage(boolean z) {
        this.bkn = z;
    }

    public int getBottomOffset() {
        return this.bkk;
    }

    public int getLeftOffset() {
        return this.bkl;
    }
}
