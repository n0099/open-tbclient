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
    private static final int aVM = l.aQ(TbadkCoreApplication.getInst()) / 5;
    private int PO;
    public int aDW;
    private View.OnLongClickListener aUa;
    private e aUd;
    private int aUe;
    private boolean aVC;
    private float aVD;
    private Matrix aVE;
    private Rect aVF;
    private RectF aVG;
    private d aVL;
    private int bjP;
    private float bjQ;
    private float bjR;
    private ArrayList<Float> bjS;
    private float bjT;
    private float bjU;
    private float bjV;
    private boolean bjW;
    private byte[] bjX;
    private int bjY;
    private int bjZ;
    private volatile int bkA;
    private b bkB;
    private volatile long bkC;
    private volatile boolean bkD;
    private g bka;
    private View.OnClickListener bkb;
    private a bkc;
    private f bkd;
    private float bke;
    private boolean bkf;
    private boolean bkg;
    private int bkh;
    private volatile com.baidu.adp.gif.b bki;
    private Bitmap bkj;
    private int bkk;
    private int bkl;
    private int bkm;
    private int bkn;
    private boolean bko;
    private boolean bkp;
    private boolean bkq;
    private float bkr;
    private com.baidu.tbadk.widget.largeImage.logic.b bks;
    private ImageUrlData bkt;
    private Interpolator bku;
    private Rect bkv;
    private int bkw;
    private c bkx;
    private BlockingLinkedDeque<c> bky;
    private BlockingLinkedDeque<c> bkz;
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
        public Bitmap bkN;
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
        int i = dragImageView.bkA;
        dragImageView.bkA = i + 1;
        return i;
    }

    public void setIsHeadImage(boolean z) {
        this.bkq = z;
    }

    public void setImageUrlData(ImageUrlData imageUrlData) {
        this.bkt = imageUrlData;
    }

    public void setCanScale(boolean z) {
        this.bkp = z;
    }

    public DragImageView(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.PO = 0;
        this.bjP = 0;
        this.bjW = false;
        this.bjX = null;
        this.aUe = 0;
        this.bjY = 1300;
        this.bjZ = 0;
        this.bka = null;
        this.bkb = null;
        this.aUa = null;
        this.aUd = null;
        this.bke = 1.0f;
        this.aDW = 0;
        this.mMode = 0;
        this.bkf = false;
        this.bkg = false;
        this.bkh = 0;
        this.bki = null;
        this.bkj = null;
        this.mPaint = new Paint(-16777216);
        this.mTop = 0;
        this.mBottom = 0;
        this.bkk = 0;
        this.bkl = 0;
        this.bkm = 0;
        this.bkn = 0;
        this.bkp = true;
        this.bku = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.aVE = new Matrix();
        this.aVC = false;
        this.mRatio = 1.0f;
        this.aVD = 0.0f;
        this.aVG = new RectF();
        this.width = 0;
        this.height = 0;
        this.bkw = 0;
        this.bkx = null;
        this.bky = new BlockingLinkedDeque<>(5);
        this.bkz = new BlockingLinkedDeque<>(6);
        this.bkA = 0;
        this.bkC = 0L;
        this.bkD = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.DragImageView.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        DragImageView.this.QZ();
                        break;
                    case 1:
                        if (DragImageView.this.bkD) {
                            DragImageView.this.QZ();
                            break;
                        }
                        break;
                    case 2:
                        DragImageView.this.invalidate();
                        DragImageView.this.bkC = System.currentTimeMillis();
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
        this.bjP = 0;
        this.bjW = false;
        this.bjX = null;
        this.aUe = 0;
        this.bjY = 1300;
        this.bjZ = 0;
        this.bka = null;
        this.bkb = null;
        this.aUa = null;
        this.aUd = null;
        this.bke = 1.0f;
        this.aDW = 0;
        this.mMode = 0;
        this.bkf = false;
        this.bkg = false;
        this.bkh = 0;
        this.bki = null;
        this.bkj = null;
        this.mPaint = new Paint(-16777216);
        this.mTop = 0;
        this.mBottom = 0;
        this.bkk = 0;
        this.bkl = 0;
        this.bkm = 0;
        this.bkn = 0;
        this.bkp = true;
        this.bku = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.aVE = new Matrix();
        this.aVC = false;
        this.mRatio = 1.0f;
        this.aVD = 0.0f;
        this.aVG = new RectF();
        this.width = 0;
        this.height = 0;
        this.bkw = 0;
        this.bkx = null;
        this.bky = new BlockingLinkedDeque<>(5);
        this.bkz = new BlockingLinkedDeque<>(6);
        this.bkA = 0;
        this.bkC = 0L;
        this.bkD = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.DragImageView.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        DragImageView.this.QZ();
                        break;
                    case 1:
                        if (DragImageView.this.bkD) {
                            DragImageView.this.QZ();
                            break;
                        }
                        break;
                    case 2:
                        DragImageView.this.invalidate();
                        DragImageView.this.bkC = System.currentTimeMillis();
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
        this.bjP = 0;
        this.bjW = false;
        this.bjX = null;
        this.aUe = 0;
        this.bjY = 1300;
        this.bjZ = 0;
        this.bka = null;
        this.bkb = null;
        this.aUa = null;
        this.aUd = null;
        this.bke = 1.0f;
        this.aDW = 0;
        this.mMode = 0;
        this.bkf = false;
        this.bkg = false;
        this.bkh = 0;
        this.bki = null;
        this.bkj = null;
        this.mPaint = new Paint(-16777216);
        this.mTop = 0;
        this.mBottom = 0;
        this.bkk = 0;
        this.bkl = 0;
        this.bkm = 0;
        this.bkn = 0;
        this.bkp = true;
        this.bku = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.aVE = new Matrix();
        this.aVC = false;
        this.mRatio = 1.0f;
        this.aVD = 0.0f;
        this.aVG = new RectF();
        this.width = 0;
        this.height = 0;
        this.bkw = 0;
        this.bkx = null;
        this.bky = new BlockingLinkedDeque<>(5);
        this.bkz = new BlockingLinkedDeque<>(6);
        this.bkA = 0;
        this.bkC = 0L;
        this.bkD = true;
        this.mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.tbadk.widget.DragImageView.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        DragImageView.this.QZ();
                        break;
                    case 1:
                        if (DragImageView.this.bkD) {
                            DragImageView.this.QZ();
                            break;
                        }
                        break;
                    case 2:
                        DragImageView.this.invalidate();
                        DragImageView.this.bkC = System.currentTimeMillis();
                        DragImageView.this.mHandler.sendEmptyMessage(0);
                        break;
                }
                return false;
            }
        });
        initData();
    }

    public void setDragToExitListener(d dVar) {
        this.aVL = dVar;
    }

    public int getImageType() {
        return this.aDW;
    }

    public void setImageMode(int i) {
        this.bjZ = i;
    }

    public void setOffset(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.aUe = i;
    }

    public boolean QL() {
        if (this.bks != null) {
            return this.bks.QL();
        }
        return false;
    }

    public void QM() {
        this.bkg = false;
        this.bjW = false;
        this.mMode = 3;
        QS();
        if (this.mCurrentScale < this.bjT) {
            this.mCurrentScale = this.bjT;
            QY();
        }
        invalidate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.bks != null && this.bks.onTouchEvent(motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.bjW = true;
                this.bkf = false;
                this.bkg = false;
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
            this.bke = t(motionEvent);
            if (this.bke > 10.0f) {
                this.mMode = 2;
            }
        }
        if ((this.mMode == 2 || !this.mGestureDetector.onTouchEvent(motionEvent)) && this.bkp) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.bkf = true;
                        this.bkg = true;
                        if (this.aDW != 1 && this.aDW != 2) {
                            float t = t(motionEvent);
                            if (t >= 0.0f && Math.abs(this.bke - t) >= 10.0f) {
                                if (Math.abs(this.bke - t) > 100.0f) {
                                    this.bke = t;
                                    break;
                                } else {
                                    float f2 = t / this.bke;
                                    this.bke = t;
                                    this.bjV = this.mCurrentScale;
                                    this.mCurrentScale *= f2;
                                    if (this.mCurrentScale > this.bjU) {
                                        this.mCurrentScale = this.bjU;
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
        return this.bks != null ? this.bks.getMinScaleValue() : this.bjT / 4.0f;
    }

    public float t(MotionEvent motionEvent) {
        return CompatibleUtile.getInstance().getSpacing(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            this.PO = i3 - i;
            this.bjP = i4 - i2;
            QO();
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public boolean QN() {
        if (this.bks != null) {
            return this.bks.RN();
        }
        return this.bjT == this.mCurrentScale;
    }

    protected float h(Bitmap bitmap) {
        if (this.bks != null) {
            return this.bks.RR();
        }
        if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            return 1.0f;
        }
        if (this.bjZ == 0) {
            float width = this.PO / bitmap.getWidth();
            float height = this.bjP / bitmap.getHeight();
            if (this.bkq) {
                if (this.aDW == 2) {
                    return 2.5f;
                }
                return Math.min(width, height);
            } else if (this.aDW != 2) {
                float f2 = this.bkr;
                float f3 = f2 >= 1.0f ? f2 : 1.0f;
                if (bitmap.getWidth() * f3 >= this.PO || bitmap.getHeight() * f3 >= this.bjP) {
                    return Math.min(width, height);
                }
                return f3;
            } else {
                return 1.0f;
            }
        }
        return Math.max(this.PO / bitmap.getWidth(), ((this.bjP - this.mTop) - this.mBottom) / bitmap.getHeight());
    }

    protected float i(Bitmap bitmap) {
        if (this.bks != null) {
            return this.bks.RS();
        }
        float f2 = 1.0f;
        if (bitmap != null && !bitmap.isRecycled() && bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
            f2 = (float) Math.sqrt(this.bjY / (bitmap.getWidth() * bitmap.getHeight()));
            if (f2 > 10.0f) {
                return 10.0f;
            }
        }
        return f2;
    }

    private void QO() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            this.bjT = h(imageBitmap);
            this.bjU = i(imageBitmap);
            this.bjS.clear();
            this.bjS.add(Float.valueOf(this.bjT));
            this.mCurrentScale = this.bjT;
            this.bjV = this.mCurrentScale;
            QY();
            return;
        }
        this.bjQ = 0.0f;
        this.bjR = 0.0f;
        this.bjT = 1.0f;
        this.bjU = 1.0f;
        this.mCurrentScale = 1.0f;
        this.bjV = this.mCurrentScale;
        this.bjS.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    private void QP() {
        if (this.bka != null) {
            this.bka.a(this, canZoomIn(), canZoomOut());
        }
    }

    public void setOnSizeChangedListener(g gVar) {
        this.bka = gVar;
    }

    public void setOnImageScrollListener(f fVar) {
        this.bkd = fVar;
    }

    public byte[] getImageData() {
        return this.bjX;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getMeasuredHeight() != 0 && getMeasuredWidth() != 0 && this.bks != null) {
            this.bks.RP();
        }
    }

    public void setImageData(Bitmap bitmap, byte[] bArr) {
        this.bjX = bArr;
        if (this.bks != null) {
            this.bks.a(bitmap, bArr);
        }
        setImageBitmap(bitmap);
    }

    public void QQ() {
        if (this.bks == null) {
            this.bks = new com.baidu.tbadk.widget.largeImage.logic.b(this);
            this.bks.setOnClickListener(this.bkb);
            this.bks.setOnLongClickListener(this.aUa);
        }
    }

    public void setImageLoadCallBack(com.baidu.tbadk.widget.largeImage.logic.a aVar) {
        if (this.bks != null) {
            this.bks.a(aVar);
        }
    }

    public boolean QR() {
        return (getImageBitmap() == null || this.bks == null) ? false : true;
    }

    public Bitmap getGifCache() {
        return this.bkj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        boolean z;
        if (this.bks == null || !this.bks.b(canvas, getImageBitmap())) {
            if (this.aDW == 2 && this.bkn != 0 && !this.bkc.Rc()) {
                int width = getWidth();
                int height = getHeight();
                Drawable drawable = getDrawable();
                float f2 = 0.0f;
                float f3 = height * 0.3f;
                float f4 = width;
                float f5 = (1.0f - 0.3f) * height;
                if (this.bkq && drawable != null) {
                    Rect bounds = drawable.getBounds();
                    int i = bounds.right - bounds.left;
                    int i2 = bounds.bottom - bounds.top;
                    f2 = (width / 2) - (i * 2.5f);
                    f3 = (height / 2) - (i2 * 2.5f);
                    f4 = (i * 2.5f) + (width / 2);
                    f5 = (i2 * 2.5f) + (height / 2);
                }
                this.mPaint.setColor(al.getColor(this.bkn));
                canvas.drawRect(f2, f3, f4, f5, this.mPaint);
                this.mPaint.setColor(-16777216);
            }
            if (this.mMode == 3 && this.aVC) {
                this.aVC = false;
                this.aVE.reset();
                if (this.aVD < aVM) {
                    this.mMode = 0;
                } else {
                    this.mMode = 4;
                    KR();
                }
            }
            if (this.aDW == 0 && this.aVC && this.aVF != null && this.bkt != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                if (this.aVG == null) {
                    this.aVG = new RectF();
                }
                this.aVE.mapRect(this.aVG, new RectF(this.aVF));
                Bitmap imageBitmap = getImageBitmap();
                if (imageBitmap != null && !imageBitmap.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.bkv, this.aVG, (Paint) null);
                }
            } else if (this.mMode == 4 && this.aVF != null) {
                canvas.drawColor(Color.argb((int) (255.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
                Bitmap imageBitmap2 = getImageBitmap();
                if (imageBitmap2 != null && !imageBitmap2.isRecycled()) {
                    canvas.drawBitmap(getImageBitmap(), this.bkv, this.aVG, (Paint) null);
                }
            } else {
                super.onDraw(canvas);
            }
            if (this.aDW == 1 && this.bkj != null && !this.bkj.isRecycled()) {
                int width2 = this.bkj.getWidth();
                int height2 = this.bkj.getHeight();
                int width3 = getWidth();
                int height3 = getHeight();
                int i3 = (width3 - width2) >> 1;
                int i4 = (height3 - height2) >> 1;
                float f6 = this.bkr;
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
                if (this.bkh == 1 && this.bki != null && this.bkx != null && this.bkx.bkN != null) {
                    if (z) {
                        canvas.drawBitmap(this.bkx.bkN, i3, i4, (Paint) null);
                    } else {
                        canvas.drawBitmap(this.bkx.bkN, this.mMatrix, this.mPaint);
                    }
                    invalidate();
                } else if (z) {
                    canvas.drawBitmap(this.bkj, i3, i4, (Paint) null);
                } else {
                    canvas.drawBitmap(this.bkj, this.mMatrix, this.mPaint);
                }
            }
        }
    }

    public void play() {
        com.baidu.adp.widget.ImageView.a aVar;
        if (this.aDW == 1) {
            if (this.bki == null) {
                if (this.bkB != null) {
                    this.bkB.Et = false;
                    this.bkB.interrupt();
                    this.bkB = null;
                }
                if (this.bjX != null) {
                    try {
                        aVar = a.C0015a.hx().g(this.bjX, 0, this.bjX.length);
                    } catch (StackOverflowError e2) {
                        aVar = null;
                    }
                    if (aVar == null || aVar.getGif() == null) {
                        com.baidu.tbadk.core.d.a.a("gifplay", -1L, -1, "DragImageView.play", -1, "decode error", new Object[0]);
                        return;
                    }
                    this.bki = aVar.getGif();
                    if (this.bki != null) {
                        this.bkh = 1;
                        this.width = this.bki.getWidth();
                        this.height = this.bki.getHeight();
                        this.bkA = 0;
                        this.bkw = this.bki.getFrameCount();
                    } else {
                        this.bkh = 0;
                    }
                } else {
                    return;
                }
            }
            if (this.bki != null) {
                if (this.bkB == null || (this.bkB != null && !this.bkB.Et)) {
                    this.bkD = true;
                    this.bkB = new b();
                    this.bky.clear();
                    this.bkz.clear();
                    this.bkB.Et = true;
                    this.bkB.start();
                }
            }
        }
    }

    public void pause() {
        if (this.aDW == 1) {
            if (this.bkB != null) {
                this.bkB.Et = false;
                this.bkB.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.aDW == 1) {
            if (this.bkB != null) {
                this.bkB.Et = false;
                this.bkB.interrupt();
                this.bkB = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.bkD = true;
            this.bkx = null;
            this.bkz.clear();
            this.bky.clear();
            this.width = 0;
            this.height = 0;
            this.bkA = 0;
            this.bkw = 0;
            this.bki = null;
        }
    }

    private void initData() {
        this.bkr = l.aR(getContext());
        this.bjY = l.aQ(getContext()) * l.aO(getContext()) * 2;
        if (this.bjY < 1690000) {
            this.bjY = 1690000;
        }
        this.bjQ = 0.0f;
        this.bjR = 0.0f;
        this.bjS = new ArrayList<>();
        this.bjT = 1.0f;
        this.bjU = 1.0f;
        this.mCurrentScale = 1.0f;
        this.bjV = this.mCurrentScale;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.bkc = new a();
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWillNotDraw(false);
        scrollTo(0, 0);
        this.mGestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.DragImageView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                if (DragImageView.this.aDW != 2 && (Math.abs(f2) > 200.0f || Math.abs(f3) > 200.0f)) {
                    DragImageView.this.bkc.p(f2, f3);
                    DragImageView.this.startAnimation(DragImageView.this.bkc);
                }
                return super.onFling(motionEvent, motionEvent2, f2, f3);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (DragImageView.this.aDW == 1 || DragImageView.this.aDW == 2 || !DragImageView.this.bkp) {
                    return false;
                }
                DragImageView.this.mMode = 2;
                if (DragImageView.this.mCurrentScale > DragImageView.this.bjT) {
                    DragImageView.this.mCurrentScale = DragImageView.this.bjT;
                    DragImageView.this.bjV = DragImageView.this.mCurrentScale;
                    DragImageView.this.QY();
                } else {
                    DragImageView.this.mCurrentScale = DragImageView.this.bjT * 2.0f;
                    DragImageView.this.a(true, (int) motionEvent.getX(), (int) motionEvent.getY());
                }
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (DragImageView.this.bkb != null && !DragImageView.this.bkf) {
                    DragImageView.this.bkb.onClick(DragImageView.this);
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
                DragImageView.this.bkf = true;
                if (DragImageView.this.bjZ == 0 && DragImageView.this.bkg) {
                    return false;
                }
                int scrollX = DragImageView.this.getScrollX();
                int scrollY = DragImageView.this.getScrollY();
                if (DragImageView.this.bjQ >= DragImageView.this.getWidth()) {
                    scrollX = (int) (scrollX + f2);
                    if (DragImageView.this.bjZ == 0) {
                        i = scrollX >= 0 ? scrollX : 0;
                        if (DragImageView.this.getWidth() + i > DragImageView.this.bjQ) {
                            i = (int) (DragImageView.this.bjQ - DragImageView.this.getWidth());
                        }
                        if (DragImageView.this.bjR + DragImageView.this.mTop + DragImageView.this.mBottom < DragImageView.this.getHeight()) {
                            i2 = (int) (scrollY + f3);
                            if (DragImageView.this.bjZ == 0) {
                                if (i2 < (-DragImageView.this.bkk)) {
                                    i2 = -DragImageView.this.bkk;
                                }
                                if (DragImageView.this.getHeight() + i2 > DragImageView.this.bjR + DragImageView.this.mBottom + DragImageView.this.bkl) {
                                    i2 = (int) ((DragImageView.this.bjR - DragImageView.this.getHeight()) + DragImageView.this.mBottom + DragImageView.this.bkl);
                                }
                            }
                        } else {
                            i2 = scrollY;
                        }
                        if (i == DragImageView.this.getScrollX() || i2 != DragImageView.this.getScrollY()) {
                            DragImageView.this.scrollTo(i, i2);
                            DragImageView.this.invalidate();
                            if (DragImageView.this.bkd != null) {
                                DragImageView.this.bkd.a(DragImageView.this, i, i2);
                            }
                        }
                        return true;
                    }
                }
                i = scrollX;
                if (DragImageView.this.bjR + DragImageView.this.mTop + DragImageView.this.mBottom < DragImageView.this.getHeight()) {
                }
                if (i == DragImageView.this.getScrollX()) {
                }
                DragImageView.this.scrollTo(i, i2);
                DragImageView.this.invalidate();
                if (DragImageView.this.bkd != null) {
                }
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (DragImageView.this.aUa != null && !DragImageView.this.bkf) {
                    DragImageView.this.aUa.onLongClick(DragImageView.this);
                }
                super.onLongPress(motionEvent);
            }
        });
    }

    private void KR() {
        if (this.bkt == null) {
            if (this.aVL != null) {
                this.aVL.Re();
                return;
            }
            return;
        }
        final Rect sourceImageRectInScreen = this.bkt.getSourceImageRectInScreen();
        if (sourceImageRectInScreen == null) {
            if (this.aVL != null) {
                this.aVL.Re();
                return;
            }
            return;
        }
        this.aVG.bottom = (((sourceImageRectInScreen.bottom - sourceImageRectInScreen.top) / (sourceImageRectInScreen.right - sourceImageRectInScreen.left)) * (this.aVG.right - this.aVG.left)) + this.aVG.top;
        final float[] fArr = {(this.aVG.left + this.aVG.right) / 2.0f, (this.aVG.top + this.aVG.bottom) / 2.0f};
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
                    DragImageView.this.aVG = DragImageView.this.h(floatValue, animatedFraction, sourceImageRectInScreen.right - sourceImageRectInScreen.left, sourceImageRectInScreen.bottom - sourceImageRectInScreen.top);
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
                DragImageView.this.aVC = false;
                DragImageView.this.mMode = 4;
                DragImageView.this.invalidate();
                if (DragImageView.this.aVL != null) {
                    DragImageView.this.aVL.Re();
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
        if (this.bjQ >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.bjQ) {
                scrollX = (int) (this.bjQ - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.bjR + this.mTop + this.mBottom >= getHeight()) {
            i = scrollY < (-this.bkk) ? -this.bkk : scrollY;
            if (getHeight() + i > this.bjR + this.mBottom + this.bkl) {
                i = (int) ((this.bjR - getHeight()) + this.mBottom + this.bkl);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
            if (this.bkd != null) {
                this.bkd.a(this, scrollX, i);
            }
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.bks != null) {
            this.bks.RO();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.bjQ;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.bjR;
    }

    public boolean QT() {
        if (this.aDW == 1 || this.aDW == 2) {
            return true;
        }
        return !this.bkg && getScrollX() >= ((int) (this.bjQ - ((float) getWidth()))) + (-1);
    }

    public boolean QU() {
        if (this.aDW == 1 || this.aDW == 2) {
            return true;
        }
        return !this.bkg && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.bkc.Rc()) {
            this.bkc.stopAnimation();
        }
        this.bkn = 0;
        super.setImageBitmap(bitmap);
        QO();
        this.aDW = 0;
        if (this.aVF == null) {
            int measuredWidth = getMeasuredWidth();
            float measuredWidth2 = ((1.0f * getMeasuredWidth()) / bitmap.getWidth()) * bitmap.getHeight();
            if (measuredWidth2 > getMeasuredHeight()) {
                measuredWidth2 = getMeasuredHeight();
            }
            RectF h = h(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
            this.aVF = new Rect((int) h.left, (int) h.top, (int) h.right, (int) h.bottom);
        }
        if (this.bkv == null) {
            this.bkv = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
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
            if (this.bkc.Rc()) {
                this.bkc.stopAnimation();
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            super.setImageBitmap(bitmap);
            super.setImageMatrix(this.mMatrix);
            scrollTo(scrollX, scrollY);
            this.aDW = 0;
        }
    }

    public void setGifData(byte[] bArr, Bitmap bitmap) {
        if (this.bkc.Rc()) {
            this.bkc.stopAnimation();
        }
        super.setImageDrawable(null);
        stop();
        QO();
        this.aDW = 1;
        this.bkj = bitmap;
        this.bjX = bArr;
        if (this.aUd != null) {
            this.aUd.a(this);
        }
    }

    public void onDestroy() {
        if (this.bkc.Rc()) {
            this.bkc.stopAnimation();
        }
        super.setImageDrawable(null);
        this.bjX = null;
        this.bkj = null;
        stop();
        if (this.bki != null) {
            this.bki.close();
            this.bki = null;
        }
        if (this.bks != null) {
            this.bks.release();
            System.gc();
        }
    }

    public void release() {
        if (this.bkc.Rc()) {
            this.bkc.stopAnimation();
        }
        stop();
        super.setImageDrawable(null);
        this.bkj = null;
    }

    public void setDefaultBitmap() {
        if (this.bkc.Rc()) {
            this.bkc.stopAnimation();
        }
        try {
            if (this.bkq) {
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
        this.aDW = 2;
        QO();
    }

    public void QV() {
        if (this.aDW != 1 && this.aDW != 2) {
            int size = this.bjS.size();
            if (size > 0) {
                this.bjS.add(Float.valueOf(this.bjS.get(size - 1).floatValue() * 1.25f));
            } else {
                this.bjS.add(Float.valueOf(this.bjT));
            }
            QY();
        }
    }

    public void QW() {
        if (this.aDW != 1 && this.aDW != 2) {
            int size = this.bjS.size();
            if (size > 1) {
                this.bjS.remove(size - 1);
            }
            QY();
        }
    }

    public void QX() {
        QP();
        if (this.aDW != 1 && this.aDW != 2 && this.mCurrentScale != this.bjT) {
            this.bjS.clear();
            this.bjS.add(Float.valueOf(this.bjT));
            this.mCurrentScale = this.bjT;
            this.bjV = this.mCurrentScale;
            QY();
        }
    }

    public boolean canZoomIn() {
        if (this.aDW == 1 || this.aDW == 2) {
            return false;
        }
        int size = this.bjS.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.bjS.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.bjY) && floatValue <= 5.0f;
    }

    public boolean canZoomOut() {
        if (this.aDW == 1 || this.aDW == 2) {
            return false;
        }
        int size = this.bjS.size();
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
                    int size = this.bjS.size();
                    if (size > 0) {
                        f3 = this.bjS.get(size - 1).floatValue();
                    } else {
                        f3 = this.bjT;
                    }
                    this.mCurrentScale = f3;
                }
                this.mMatrix.setScale(this.mCurrentScale, this.mCurrentScale);
                this.bjQ = imageBitmap.getWidth() * this.mCurrentScale;
                this.bjR = imageBitmap.getHeight() * this.mCurrentScale;
                float width = this.bjV * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.bjV;
                this.bkk = this.mTop;
                this.bkl = 0;
                float f4 = this.bjQ < ((float) this.PO) ? (int) ((this.PO - this.bjQ) / 2.0f) : 0.0f;
                if (this.bjR < this.bjP) {
                    f2 = (int) ((this.bjP - this.bjR) / 2.0f);
                    if (this.bjZ == 1 && f2 > this.mTop) {
                        f2 = this.mTop;
                    }
                    this.bkk = (int) (this.mTop - f2);
                    this.bkl = this.mTop - this.bkk;
                } else {
                    f2 = 0.0f;
                }
                this.bkm = (int) f4;
                this.mMatrix.postTranslate(f4, f2);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    int width2 = i > getWidth() ? getWidth() : i;
                    if (this.bjQ <= screenWidth) {
                        width2 = 0;
                    } else if (this.bjQ > screenWidth && this.bjQ / 2.0f < screenWidth) {
                        width2 = (int) (width2 - (this.bjQ / 4.0f));
                    }
                    scrollX = width2;
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.bjQ - width) / 2.0f);
                    }
                    if (this.bjQ <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.bjQ) {
                        scrollX = (int) (this.bjQ - getWidth());
                    }
                }
                if (scrollX > 0 && this.bjQ - scrollX < getWidth()) {
                    scrollX = (int) (this.bjQ - getWidth());
                }
                int i3 = this.mMode == 2 ? ((int) ((this.bjR - height) / 2.0f)) + scrollY : scrollY;
                if (this.bjR <= getHeight()) {
                    i3 = 0;
                } else if (getHeight() + i3 > this.bjR) {
                    i3 = (int) (this.bjR - getHeight());
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
        private boolean bkH = false;
        private boolean bkI = false;
        private long bkJ;
        private long bkK;
        private long bkL;
        private long bkM;
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
            this.bkJ = f;
            this.bkK = f2;
            this.bkL = Math.abs((f * 1000.0f) / 2500.0f);
            this.bkM = Math.abs((f2 * 1000.0f) / 2500.0f);
            setDuration(Math.max(this.bkL, this.bkM));
            setInterpolator(DragImageView.this.bku);
            this.mStartX = DragImageView.this.getScrollX();
            this.mStartY = DragImageView.this.getScrollY();
            this.bkH = true;
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
            if (this.bkL > this.bkM) {
                j = ((float) this.bkL) * f;
            } else {
                j = ((float) this.bkM) * f;
            }
            float f2 = ((float) (j > this.bkL ? this.bkL : j)) / 1000.0f;
            if (this.bkJ > 0) {
                i = this.mStartX - ((int) (f2 * (((float) this.bkJ) - ((2500.0f * f2) / 2.0f))));
            } else {
                i = this.mStartX - ((int) (f2 * (((float) this.bkJ) + ((2500.0f * f2) / 2.0f))));
            }
            if (j > this.bkM) {
                j = this.bkM;
            }
            float f3 = ((float) j) / 1000.0f;
            if (this.bkK > 0) {
                i2 = this.mStartY - ((int) (f3 * (((float) this.bkK) - ((2500.0f * f3) / 2.0f))));
            } else {
                i2 = this.mStartY - ((int) (f3 * (((float) this.bkK) + ((2500.0f * f3) / 2.0f))));
            }
            if (DragImageView.this.bjR + DragImageView.this.mTop + DragImageView.this.mBottom > DragImageView.this.getHeight()) {
                if (i2 < (-DragImageView.this.bkk)) {
                    i2 = -DragImageView.this.bkk;
                }
                if (DragImageView.this.getHeight() + i2 > DragImageView.this.bjR + DragImageView.this.mBottom + DragImageView.this.bkl) {
                    i2 = (int) ((DragImageView.this.bjR - DragImageView.this.getHeight()) + DragImageView.this.mBottom + DragImageView.this.bkl);
                }
            } else {
                i2 = 0;
            }
            if (DragImageView.this.bjQ > DragImageView.this.getWidth()) {
                int width = ((float) (DragImageView.this.getWidth() + i)) > DragImageView.this.bjQ ? (int) (DragImageView.this.bjQ - DragImageView.this.getWidth()) : i;
                if (width >= 0) {
                    i3 = width;
                }
            }
            DragImageView.this.scrollTo(i3, i2);
            DragImageView.this.invalidate();
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            if (!this.bkI) {
                if (DragImageView.this.bjW) {
                    this.bkH = false;
                    return false;
                }
                try {
                    if (super.getTransformation(j, transformation)) {
                        return true;
                    }
                    this.bkH = false;
                    return false;
                } catch (Exception e) {
                    this.bkH = false;
                    return false;
                }
            }
            this.bkI = false;
            this.bkH = false;
            return false;
        }

        public boolean Rc() {
            return this.bkH;
        }

        public void stopAnimation() {
            this.bkI = true;
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.bkb = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aUa = onLongClickListener;
        if (this.bks != null) {
            this.bks.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setGifSetListener(e eVar) {
        this.aUd = eVar;
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
        c poll = this.bky.poll();
        if (poll == null) {
            this.bkD = true;
            return;
        }
        this.bkD = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.bkx != null) {
            j = this.bkx.delay - (currentTimeMillis - this.bkC);
            this.bkz.offer(this.bkx);
        } else {
            j = 0;
        }
        this.bkx = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public c Ra() {
        c poll = this.bkz.poll();
        if (poll == null) {
            poll = new c();
            try {
                poll.bkN = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
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
        return this.bkx;
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
            while (this.Et && DragImageView.this.bki != null && DragImageView.this.bkw > 0 && DragImageView.this.width > 0 && DragImageView.this.height > 0) {
                try {
                    DragImageView.this.bki.am(DragImageView.this.bkA);
                    c Ra = DragImageView.this.Ra();
                    if (Ra.bkN == null || (Ra.bkN.getWidth() != DragImageView.this.width && Ra.bkN.getHeight() != DragImageView.this.height)) {
                        try {
                            Ra.bkN = Bitmap.createBitmap(DragImageView.this.width, DragImageView.this.height, Bitmap.Config.ARGB_8888);
                        } catch (OutOfMemoryError e) {
                            TbadkCoreApplication.getInst().onAppMemoryLow();
                            try {
                                Ra.bkN = Bitmap.createBitmap(DragImageView.this.width, DragImageView.this.height, Bitmap.Config.ARGB_4444);
                            } catch (OutOfMemoryError e2) {
                                TbadkCoreApplication.getInst().onAppMemoryLow();
                            } catch (Throwable th) {
                                BdLog.e(th.getMessage());
                            }
                        } catch (Throwable th2) {
                            BdLog.e(th2.getMessage());
                        }
                    }
                    DragImageView.this.bki.a(Ra.bkN, null);
                    Ra.delay = DragImageView.this.bki.an(DragImageView.this.bkA);
                    DragImageView.C(DragImageView.this);
                    if (Ra.bkN == null) {
                        DragImageView.C(DragImageView.this);
                    }
                    DragImageView.this.bkA %= DragImageView.this.bkw;
                    DragImageView.this.bky.put(Ra);
                    if (DragImageView.this.bkD) {
                        DragImageView.this.mHandler.sendEmptyMessage(1);
                    }
                } catch (Exception e3) {
                    return;
                }
            }
        }
    }

    public boolean Rb() {
        return this.bko;
    }

    public void setLoadBigImage(boolean z) {
        this.bko = z;
    }

    public int getBottomOffset() {
        return this.bkl;
    }

    public int getLeftOffset() {
        return this.bkm;
    }
}
