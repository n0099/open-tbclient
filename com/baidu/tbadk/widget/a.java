package com.baidu.tbadk.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.FloatMath;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
import android.widget.ImageView;
import com.baidu.adp.gif.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BlockingLinkedDeque;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends ImageView {
    private float aEG;
    private float aEH;
    private ArrayList<Float> aEI;
    private float aEJ;
    private float aEK;
    private float aEL;
    private float aEM;
    private boolean aEN;
    private int aEO;
    private int aEP;
    private e aEQ;
    private View.OnClickListener aER;
    private C0049a aES;
    private float aET;
    private boolean aEU;
    private boolean aEV;
    private int aEW;
    private volatile com.baidu.adp.gif.b aEX;
    private Bitmap aEY;
    private int aEZ;
    private int aFa;
    private int aFb;
    private int aFc;
    private boolean aFd;
    private boolean aFe;
    private float aFf;
    private Interpolator aFg;
    private int aFh;
    private c aFi;
    private BlockingLinkedDeque<c> aFj;
    private BlockingLinkedDeque<c> aFk;
    private volatile int aFl;
    private b aFm;
    private volatile long aFn;
    private volatile boolean aFo;
    private int acC;
    private View.OnLongClickListener anY;
    private d aoa;
    private int aob;
    private int height;
    private int mBottom;
    private GestureDetector mGestureDetector;
    public Handler mHandler;
    private byte[] mImageData;
    private Matrix mMatrix;
    private int mMode;
    private Paint mPaint;
    private volatile int mState;
    private int mTop;
    private int mViewHeight;
    private int mViewWidth;
    private int width;

    /* loaded from: classes.dex */
    public interface d {
        void a(a aVar);
    }

    /* loaded from: classes.dex */
    public interface e {
        void a(a aVar, boolean z, boolean z2);
    }

    public void setIsHeadImage(boolean z) {
        this.aFe = z;
    }

    public a(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aEN = false;
        this.mImageData = null;
        this.aob = 0;
        this.aEO = 1300;
        this.aEP = 0;
        this.aEQ = null;
        this.aER = null;
        this.anY = null;
        this.aoa = null;
        this.aET = 1.0f;
        this.acC = 0;
        this.mMode = 0;
        this.aEU = false;
        this.aEV = false;
        this.aEW = 0;
        this.aEX = null;
        this.aEY = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aEZ = 0;
        this.aFa = 0;
        this.aFb = 0;
        this.aFc = 0;
        this.aFg = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aFh = 0;
        this.aFi = null;
        this.aFj = new BlockingLinkedDeque<>(5);
        this.aFk = new BlockingLinkedDeque<>(6);
        this.aFl = 0;
        this.aFn = 0L;
        this.mState = 0;
        this.aFo = true;
        this.mHandler = new Handler(new com.baidu.tbadk.widget.b(this));
        initData();
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aEN = false;
        this.mImageData = null;
        this.aob = 0;
        this.aEO = 1300;
        this.aEP = 0;
        this.aEQ = null;
        this.aER = null;
        this.anY = null;
        this.aoa = null;
        this.aET = 1.0f;
        this.acC = 0;
        this.mMode = 0;
        this.aEU = false;
        this.aEV = false;
        this.aEW = 0;
        this.aEX = null;
        this.aEY = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aEZ = 0;
        this.aFa = 0;
        this.aFb = 0;
        this.aFc = 0;
        this.aFg = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aFh = 0;
        this.aFi = null;
        this.aFj = new BlockingLinkedDeque<>(5);
        this.aFk = new BlockingLinkedDeque<>(6);
        this.aFl = 0;
        this.aFn = 0L;
        this.mState = 0;
        this.aFo = true;
        this.mHandler = new Handler(new com.baidu.tbadk.widget.b(this));
        initData();
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aEN = false;
        this.mImageData = null;
        this.aob = 0;
        this.aEO = 1300;
        this.aEP = 0;
        this.aEQ = null;
        this.aER = null;
        this.anY = null;
        this.aoa = null;
        this.aET = 1.0f;
        this.acC = 0;
        this.mMode = 0;
        this.aEU = false;
        this.aEV = false;
        this.aEW = 0;
        this.aEX = null;
        this.aEY = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aEZ = 0;
        this.aFa = 0;
        this.aFb = 0;
        this.aFc = 0;
        this.aFg = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aFh = 0;
        this.aFi = null;
        this.aFj = new BlockingLinkedDeque<>(5);
        this.aFk = new BlockingLinkedDeque<>(6);
        this.aFl = 0;
        this.aFn = 0L;
        this.mState = 0;
        this.aFo = true;
        this.mHandler = new Handler(new com.baidu.tbadk.widget.b(this));
        initData();
    }

    public int getImageType() {
        return this.acC;
    }

    public void setImageMode(int i) {
        this.aEP = i;
    }

    public void h(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.aob = i;
    }

    public void Hl() {
        this.aEV = false;
        this.aEN = false;
        this.mMode = 0;
        Hp();
        if (this.aEL < this.aEJ) {
            this.aEL = this.aEJ;
            Hw();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.aEN = true;
                this.aEU = false;
                this.aEV = false;
                break;
            case 1:
                Hl();
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
            this.aET = i(motionEvent);
            if (this.aET > 10.0f) {
                this.mMode = 2;
            }
        }
        if (this.mMode == 2 || !this.mGestureDetector.onTouchEvent(motionEvent)) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.aEU = true;
                        this.aEV = true;
                        if (this.acC != 1 && this.acC != 2) {
                            float i = i(motionEvent);
                            if (i >= 0.0f && Math.abs(this.aET - i) >= 10.0f) {
                                if (Math.abs(this.aET - i) > 100.0f) {
                                    this.aET = i;
                                    break;
                                } else {
                                    float f = i / this.aET;
                                    this.aET = i;
                                    this.aEM = this.aEL;
                                    this.aEL *= f;
                                    if (this.aEL > this.aEK) {
                                        this.aEL = this.aEK;
                                    }
                                    if (this.aEL < this.aEJ / 4.0f) {
                                        this.aEL = this.aEJ / 4.0f;
                                    }
                                    Hw();
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

    public float i(MotionEvent motionEvent) {
        return CompatibleUtile.getInstance().getSpacing(motionEvent);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            this.mViewWidth = i3 - i;
            this.mViewHeight = i4 - i2;
            Hn();
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public boolean Hm() {
        return this.aEJ == this.aEL;
    }

    private void Hn() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            if (this.aEP == 0) {
                float width = this.mViewWidth / imageBitmap.getWidth();
                float height = this.mViewHeight / imageBitmap.getHeight();
                if (this.aFe) {
                    if (this.acC == 2) {
                        this.aEJ = 2.5f;
                    } else {
                        this.aEJ = Math.min(width, height);
                    }
                } else if (this.acC == 2) {
                    this.aEJ = 1.0f;
                } else {
                    float f = this.aFf;
                    float f2 = f >= 1.0f ? f : 1.0f;
                    if (imageBitmap.getWidth() * f2 < this.mViewWidth && imageBitmap.getHeight() * f2 < this.mViewHeight) {
                        this.aEJ = f2;
                    } else {
                        this.aEJ = Math.min(width, height);
                    }
                }
            } else {
                this.aEJ = Math.max(this.mViewWidth / imageBitmap.getWidth(), ((this.mViewHeight - this.mTop) - this.mBottom) / imageBitmap.getHeight());
            }
            this.aEK = this.aEO / (imageBitmap.getWidth() * imageBitmap.getHeight());
            this.aEK = FloatMath.sqrt(this.aEK);
            if (this.aEK > 10.0f) {
                this.aEK = 10.0f;
            }
            this.aEI.clear();
            this.aEI.add(Float.valueOf(this.aEJ));
            this.aEL = this.aEJ;
            this.aEM = this.aEL;
            Hw();
            return;
        }
        this.aEG = 0.0f;
        this.aEH = 0.0f;
        this.aEJ = 1.0f;
        this.aEK = 1.0f;
        this.aEL = 1.0f;
        this.aEM = this.aEL;
        this.aEI.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    private void Ho() {
        if (this.aEQ != null) {
            this.aEQ.a(this, canZoomIn(), canZoomOut());
        }
    }

    public void setOnSizeChangedListener(e eVar) {
        this.aEQ = eVar;
    }

    public byte[] getImageData() {
        return this.mImageData;
    }

    public void setImageData(byte[] bArr) {
        this.mImageData = bArr;
    }

    public Bitmap getGifCache() {
        return this.aEY;
    }

    public void setGifCache(Bitmap bitmap) {
        this.aEY = bitmap;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        boolean z;
        int i4;
        if (this.acC == 2 && this.aFc != 0 && !this.aES.HA()) {
            int width = getWidth();
            int height = getHeight();
            Drawable drawable = getDrawable();
            float f = 0.0f;
            float f2 = height * 0.3f;
            float f3 = width;
            float f4 = (1.0f - 0.3f) * height;
            if (this.aFe && drawable != null) {
                Rect bounds = drawable.getBounds();
                int i5 = bounds.right - bounds.left;
                int i6 = bounds.bottom - bounds.top;
                f = (width / 2) - (i5 * 2.5f);
                f2 = (height / 2) - (i6 * 2.5f);
                f3 = (i5 * 2.5f) + (width / 2);
                f4 = (i6 * 2.5f) + (height / 2);
            }
            this.mPaint.setColor(av.getColor(this.aFc));
            canvas.drawRect(f, f2, f3, f4, this.mPaint);
            this.mPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        }
        super.onDraw(canvas);
        if (this.acC == 1 && this.aEY != null && !this.aEY.isRecycled()) {
            int width2 = this.aEY.getWidth();
            int height2 = this.aEY.getHeight();
            int width3 = getWidth();
            int height3 = getHeight();
            int i7 = (width3 - width2) >> 1;
            int i8 = (height3 - height2) >> 1;
            float f5 = this.aFf;
            if (f5 < 1.0f) {
                f5 = 1.0f;
            }
            if (width2 * f5 >= width3 || height2 * f5 >= height3) {
                f5 = Math.min(width3 / width2, height3 / height2);
            }
            if (Math.abs(f5 - 1.0f) < 1.0E-8f) {
                z = true;
                i4 = height2;
                i = width2;
                i2 = i8;
                i3 = i7;
            } else {
                this.mMatrix.setScale(f5, f5);
                int i9 = (int) ((width3 - (width2 * f5)) / 2.0f);
                int i10 = (int) ((height3 - (height2 * f5)) / 2.0f);
                this.mMatrix.postTranslate(i9, i10);
                int i11 = (int) (f5 * height2);
                i = (int) (width2 * f5);
                i2 = i10;
                i3 = i9;
                z = false;
                i4 = i11;
            }
            canvas.clipRect(i3, i2, i + i3, i4 + i2);
            canvas.drawColor(-1);
            if (this.aEW == 1 && this.aEX != null && this.aFi != null && this.aFi.aFx != null) {
                if (z) {
                    canvas.drawBitmap(this.aFi.aFx, i3, i2, (Paint) null);
                } else {
                    canvas.drawBitmap(this.aFi.aFx, this.mMatrix, this.mPaint);
                }
                invalidate();
            } else if (z) {
                canvas.drawBitmap(this.aEY, i3, i2, (Paint) null);
            } else {
                canvas.drawBitmap(this.aEY, this.mMatrix, this.mPaint);
            }
        }
    }

    public void play() {
        com.baidu.adp.widget.a.a aVar;
        if (this.acC == 1) {
            if (this.aEX == null) {
                if (this.aFm != null) {
                    this.aFm.interrupt();
                    this.aFm = null;
                }
                if (this.mImageData != null) {
                    try {
                        aVar = a.C0004a.cw().e(this.mImageData, 0, this.mImageData.length);
                    } catch (StackOverflowError e2) {
                        aVar = null;
                    }
                    if (aVar != null && aVar.getGif() != null) {
                        this.aEX = aVar.getGif();
                        if (this.aEX != null) {
                            this.aEW = 1;
                            this.width = this.aEX.getWidth();
                            this.height = this.aEX.getHeight();
                            this.aFl = 0;
                            this.aFh = this.aEX.cx();
                        } else {
                            this.aEW = 0;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            if (this.aEX != null && this.mState == 0) {
                this.aFo = true;
                this.aFm = new b(this, null);
                this.aFj.clear();
                this.aFk.clear();
                this.mState = 1;
                this.aFm.start();
            }
        }
    }

    public void pause() {
        if (this.acC == 1) {
            this.mState = 0;
            if (this.aFm != null) {
                this.aFm.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.acC == 1) {
            this.mState = 0;
            if (this.aFm != null) {
                this.aFm.interrupt();
                this.aFm = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.aFo = true;
            this.aFi = null;
            this.aFk.clear();
            this.aFj.clear();
            this.width = 0;
            this.height = 0;
            this.aFl = 0;
            this.aFh = 0;
            if (this.aEX != null) {
                this.aEX = null;
            }
        }
    }

    private void initData() {
        this.aFf = k.M(getContext());
        this.aEO = k.L(getContext()) * k.K(getContext()) * 2;
        if (this.aEO < 1690000) {
            this.aEO = 1690000;
        }
        this.aEG = 0.0f;
        this.aEH = 0.0f;
        this.aEI = new ArrayList<>();
        this.aEJ = 1.0f;
        this.aEK = 1.0f;
        this.aEL = 1.0f;
        this.aEM = this.aEL;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.aES = new C0049a();
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWillNotDraw(false);
        scrollTo(0, 0);
        this.mGestureDetector = new GestureDetector(getContext(), new com.baidu.tbadk.widget.c(this));
    }

    private void Hp() {
        int i = 0;
        int scrollX = getScrollX();
        if (this.aEG >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.aEG) {
                scrollX = (int) (this.aEG - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.aEH + this.mTop + this.mBottom >= getHeight()) {
            i = scrollY < (-this.aEZ) ? -this.aEZ : scrollY;
            if (getHeight() + i > this.aEH + this.mBottom + this.aFa) {
                i = (int) ((this.aEH - getHeight()) + this.mBottom + this.aFa);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.aEG;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.aEH;
    }

    public boolean Hq() {
        if (this.acC == 1 || this.acC == 2) {
            return true;
        }
        return !this.aEV && getScrollX() >= ((int) (this.aEG - ((float) getWidth()))) + (-1);
    }

    public boolean Hr() {
        if (this.acC == 1 || this.acC == 2) {
            return true;
        }
        return !this.aEV && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.aES.HA()) {
            this.aES.stopAnimation();
        }
        this.aFc = 0;
        super.setImageBitmap(bitmap);
        Hn();
        this.acC = 0;
    }

    public void j(Bitmap bitmap) {
        Bitmap imageBitmap = getImageBitmap();
        if (bitmap != null && !bitmap.isRecycled()) {
            if (imageBitmap != null && (imageBitmap.getWidth() != bitmap.getWidth() || imageBitmap.getHeight() != bitmap.getHeight())) {
                setImageBitmap(bitmap);
                return;
            }
            if (this.aES.HA()) {
                this.aES.stopAnimation();
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            super.setImageBitmap(bitmap);
            super.setImageMatrix(this.mMatrix);
            scrollTo(scrollX, scrollY);
            this.acC = 0;
        }
    }

    public void a(byte[] bArr, Bitmap bitmap) {
        if (this.aES.HA()) {
            this.aES.stopAnimation();
        }
        super.setImageDrawable(null);
        stop();
        Hn();
        this.acC = 1;
        this.aEY = bitmap;
        this.mImageData = bArr;
        if (this.aoa != null) {
            this.aoa.a(this);
        }
    }

    public void onDestroy() {
        if (this.aES.HA()) {
            this.aES.stopAnimation();
        }
        super.setImageDrawable(null);
        this.mImageData = null;
        this.aEY = null;
        stop();
        if (this.aEX != null) {
            this.aEX.close();
            this.aEX = null;
        }
    }

    public void release() {
        if (this.aES.HA()) {
            this.aES.stopAnimation();
        }
        stop();
        super.setImageDrawable(null);
        this.aEY = null;
    }

    public void Hs() {
        if (this.aES.HA()) {
            this.aES.stopAnimation();
        }
        if (this.aFe) {
            super.setImageBitmap(BitmapHelper.getCashBitmap(r.f.icon_default_avatar100));
        } else {
            super.setImageBitmap(BitmapHelper.getCashBitmap(r.f.btn_see_default));
        }
        this.acC = 2;
        Hn();
    }

    public void Ht() {
        if (this.acC != 1 && this.acC != 2) {
            int size = this.aEI.size();
            if (size > 0) {
                this.aEI.add(Float.valueOf(this.aEI.get(size - 1).floatValue() * 1.25f));
            } else {
                this.aEI.add(Float.valueOf(this.aEJ));
            }
            Hw();
        }
    }

    public void Hu() {
        if (this.acC != 1 && this.acC != 2) {
            int size = this.aEI.size();
            if (size > 1) {
                this.aEI.remove(size - 1);
            }
            Hw();
        }
    }

    public void Hv() {
        Ho();
        if (this.acC != 1 && this.acC != 2 && this.aEL != this.aEJ) {
            this.aEI.clear();
            this.aEI.add(Float.valueOf(this.aEJ));
            this.aEL = this.aEJ;
            this.aEM = this.aEL;
            Hw();
        }
    }

    public boolean canZoomIn() {
        if (this.acC == 1 || this.acC == 2) {
            return false;
        }
        int size = this.aEI.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.aEI.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.aEO) && floatValue <= 5.0f;
    }

    public boolean canZoomOut() {
        if (this.acC == 1 || this.acC == 2) {
            return false;
        }
        int size = this.aEI.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled()) {
            return false;
        }
        return size > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hw() {
        e(false, -1, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, int i, int i2) {
        float f;
        float f2;
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled()) {
            try {
                if (this.mMode != 2) {
                    int size = this.aEI.size();
                    if (size > 0) {
                        f2 = this.aEI.get(size - 1).floatValue();
                    } else {
                        f2 = this.aEJ;
                    }
                    this.aEL = f2;
                }
                this.mMatrix.setScale(this.aEL, this.aEL);
                this.aEG = imageBitmap.getWidth() * this.aEL;
                this.aEH = imageBitmap.getHeight() * this.aEL;
                float width = this.aEM * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.aEM;
                this.aEZ = this.mTop;
                this.aFa = 0;
                float f3 = this.aEG < ((float) this.mViewWidth) ? (int) ((this.mViewWidth - this.aEG) / 2.0f) : 0.0f;
                if (this.aEH < this.mViewHeight) {
                    f = (int) ((this.mViewHeight - this.aEH) / 2.0f);
                    if (this.aEP == 1 && f > this.mTop) {
                        f = this.mTop;
                    }
                    this.aEZ = (int) (this.mTop - f);
                    this.aFa = this.mTop - this.aEZ;
                } else {
                    f = 0.0f;
                }
                this.aFb = (int) f3;
                this.mMatrix.postTranslate(f3, f);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    scrollX = i > getWidth() ? getWidth() : i;
                    if (this.aEG <= screenWidth) {
                        scrollX = 0;
                    } else if (this.aEG > screenWidth && this.aEG / 2.0f < screenWidth) {
                        scrollX = (int) (scrollX - (this.aEG / 4.0f));
                    }
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.aEG - width) / 2.0f);
                    }
                    if (this.aEG <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.aEG) {
                        scrollX = (int) (this.aEG - getWidth());
                    }
                }
                if (scrollX > 0 && this.aEG - scrollX < getWidth()) {
                    scrollX = (int) (this.aEG - getWidth());
                }
                if (this.mMode == 2) {
                    scrollY += (int) ((this.aEH - height) / 2.0f);
                }
                if (this.aEH <= getHeight()) {
                    scrollY = 0;
                } else if (getHeight() + scrollY > this.aEH) {
                    scrollY = (int) (this.aEH - getHeight());
                }
                setHorizontalScrollBarEnabled(false);
                setVerticalScrollBarEnabled(false);
                if (scrollX < 0) {
                    scrollX = 0;
                }
                if (scrollY < 0) {
                    scrollY = 0;
                }
                scrollTo(scrollX, scrollY);
                setImageMatrix(this.mMatrix);
                Ho();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0049a extends Animation {
        private int Ci;
        private boolean aFq = false;
        private boolean aFr = false;
        private long aFs;
        private long aFt;
        private int aFu;
        private long aFv;
        private long aFw;

        public C0049a() {
        }

        public void e(float f, float f2) {
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
            this.aFs = f;
            this.aFt = f2;
            this.aFv = Math.abs((f * 1000.0f) / 2500.0f);
            this.aFw = Math.abs((f2 * 1000.0f) / 2500.0f);
            setDuration(Math.max(this.aFv, this.aFw));
            setInterpolator(a.this.aFg);
            this.aFu = a.this.getScrollX();
            this.Ci = a.this.getScrollY();
            this.aFq = true;
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
            if (this.aFv > this.aFw) {
                j = ((float) this.aFv) * f;
            } else {
                j = ((float) this.aFw) * f;
            }
            float f2 = ((float) (j > this.aFv ? this.aFv : j)) / 1000.0f;
            if (this.aFs > 0) {
                i = this.aFu - ((int) (f2 * (((float) this.aFs) - ((2500.0f * f2) / 2.0f))));
            } else {
                i = this.aFu - ((int) (f2 * (((float) this.aFs) + ((2500.0f * f2) / 2.0f))));
            }
            if (j > this.aFw) {
                j = this.aFw;
            }
            float f3 = ((float) j) / 1000.0f;
            if (this.aFt > 0) {
                i2 = this.Ci - ((int) (f3 * (((float) this.aFt) - ((2500.0f * f3) / 2.0f))));
            } else {
                i2 = this.Ci - ((int) (f3 * (((float) this.aFt) + ((2500.0f * f3) / 2.0f))));
            }
            if (a.this.aEH + a.this.mTop + a.this.mBottom > a.this.getHeight()) {
                if (i2 < (-a.this.aEZ)) {
                    i2 = -a.this.aEZ;
                }
                if (a.this.getHeight() + i2 > a.this.aEH + a.this.mBottom + a.this.aFa) {
                    i2 = (int) ((a.this.aEH - a.this.getHeight()) + a.this.mBottom + a.this.aFa);
                }
            } else {
                i2 = 0;
            }
            if (a.this.aEG > a.this.getWidth()) {
                int width = ((float) (a.this.getWidth() + i)) > a.this.aEG ? (int) (a.this.aEG - a.this.getWidth()) : i;
                if (width >= 0) {
                    i3 = width;
                }
            }
            a.this.scrollTo(i3, i2);
            a.this.invalidate();
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            if (!this.aFr) {
                if (a.this.aEN) {
                    this.aFq = false;
                    return false;
                }
                try {
                    if (!super.getTransformation(j, transformation)) {
                        this.aFq = false;
                        return false;
                    }
                    return true;
                } catch (Exception e) {
                    this.aFq = false;
                    return false;
                }
            }
            this.aFr = false;
            this.aFq = false;
            return false;
        }

        public boolean HA() {
            return this.aFq;
        }

        public void stopAnimation() {
            this.aFr = true;
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.aER = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.anY = onLongClickListener;
    }

    public void setGifSetListener(d dVar) {
        this.aoa = dVar;
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
    public void Hx() {
        long j;
        c poll = this.aFj.poll();
        if (poll == null) {
            this.aFo = true;
            return;
        }
        this.aFo = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.aFi != null) {
            j = this.aFi.delay - (currentTimeMillis - this.aFn);
            this.aFk.offer(this.aFi);
        } else {
            j = 0;
        }
        this.aFi = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public c Hy() {
        c poll = this.aFk.poll();
        if (poll == null) {
            poll = new c(null);
            try {
                poll.aFx = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
            } catch (OutOfMemoryError e2) {
                TbadkCoreApplication.m9getInst().onAppMemoryLow();
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

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        public Bitmap aFx;
        public int delay;

        private c() {
        }

        /* synthetic */ c(c cVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends Thread {
        private b() {
        }

        /* synthetic */ b(a aVar, b bVar) {
            this();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (a.this.mState == 1 && a.this.aEX != null && a.this.aFh > 0 && a.this.width > 0 && a.this.height > 0) {
                try {
                    a.this.aEX.U(a.this.aFl);
                    c Hy = a.this.Hy();
                    if (Hy.aFx == null || (Hy.aFx.getWidth() != a.this.width && Hy.aFx.getHeight() != a.this.height)) {
                        try {
                            Hy.aFx = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_8888);
                        } catch (OutOfMemoryError e) {
                            TbadkCoreApplication.m9getInst().onAppMemoryLow();
                            try {
                                Hy.aFx = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_4444);
                            } catch (OutOfMemoryError e2) {
                                TbadkCoreApplication.m9getInst().onAppMemoryLow();
                            } catch (Throwable th) {
                                BdLog.e(th.getMessage());
                            }
                        } catch (Throwable th2) {
                            BdLog.e(th2.getMessage());
                        }
                    }
                    a.this.aEX.a(Hy.aFx, null);
                    Hy.delay = a.this.aEX.V(a.this.aFl);
                    a.this.aFl++;
                    if (Hy.aFx == null) {
                        a.this.aFl++;
                    }
                    a.this.aFl %= a.this.aFh;
                    a.this.aFj.put(Hy);
                    if (a.this.aFo) {
                        a.this.mHandler.sendEmptyMessage(1);
                    }
                } catch (Exception e3) {
                    return;
                }
            }
        }
    }

    public boolean Hz() {
        return this.aFd;
    }

    public void setLoadBigImage(boolean z) {
        this.aFd = z;
    }

    public int getBottomOffset() {
        return this.aFa;
    }

    public int getLeftOffset() {
        return this.aFb;
    }
}
