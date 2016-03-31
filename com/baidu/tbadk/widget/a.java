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
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends ImageView {
    private float aEB;
    private float aEC;
    private ArrayList<Float> aED;
    private float aEE;
    private float aEF;
    private float aEG;
    private float aEH;
    private boolean aEI;
    private int aEJ;
    private int aEK;
    private e aEL;
    private View.OnClickListener aEM;
    private C0057a aEN;
    private float aEO;
    private boolean aEP;
    private boolean aEQ;
    private int aER;
    private volatile com.baidu.adp.gif.b aES;
    private Bitmap aET;
    private int aEU;
    private int aEV;
    private int aEW;
    private boolean aEX;
    private boolean aEY;
    private float aEZ;
    private Interpolator aFa;
    private int aFb;
    private c aFc;
    private BlockingLinkedDeque<c> aFd;
    private BlockingLinkedDeque<c> aFe;
    private volatile int aFf;
    private b aFg;
    private volatile long aFh;
    private volatile boolean aFi;
    private int ade;
    private View.OnLongClickListener aoa;
    private d aoc;
    private int aod;
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
        this.aEY = z;
    }

    public a(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aEI = false;
        this.mImageData = null;
        this.aod = 0;
        this.aEJ = 1300;
        this.aEK = 0;
        this.aEL = null;
        this.aEM = null;
        this.aoa = null;
        this.aoc = null;
        this.aEO = 1.0f;
        this.ade = 0;
        this.mMode = 0;
        this.aEP = false;
        this.aEQ = false;
        this.aER = 0;
        this.aES = null;
        this.aET = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aEU = 0;
        this.aEV = 0;
        this.aEW = 0;
        this.aFa = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aFb = 0;
        this.aFc = null;
        this.aFd = new BlockingLinkedDeque<>(5);
        this.aFe = new BlockingLinkedDeque<>(6);
        this.aFf = 0;
        this.aFh = 0L;
        this.mState = 0;
        this.aFi = true;
        this.mHandler = new Handler(new com.baidu.tbadk.widget.b(this));
        initData();
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aEI = false;
        this.mImageData = null;
        this.aod = 0;
        this.aEJ = 1300;
        this.aEK = 0;
        this.aEL = null;
        this.aEM = null;
        this.aoa = null;
        this.aoc = null;
        this.aEO = 1.0f;
        this.ade = 0;
        this.mMode = 0;
        this.aEP = false;
        this.aEQ = false;
        this.aER = 0;
        this.aES = null;
        this.aET = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aEU = 0;
        this.aEV = 0;
        this.aEW = 0;
        this.aFa = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aFb = 0;
        this.aFc = null;
        this.aFd = new BlockingLinkedDeque<>(5);
        this.aFe = new BlockingLinkedDeque<>(6);
        this.aFf = 0;
        this.aFh = 0L;
        this.mState = 0;
        this.aFi = true;
        this.mHandler = new Handler(new com.baidu.tbadk.widget.b(this));
        initData();
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aEI = false;
        this.mImageData = null;
        this.aod = 0;
        this.aEJ = 1300;
        this.aEK = 0;
        this.aEL = null;
        this.aEM = null;
        this.aoa = null;
        this.aoc = null;
        this.aEO = 1.0f;
        this.ade = 0;
        this.mMode = 0;
        this.aEP = false;
        this.aEQ = false;
        this.aER = 0;
        this.aES = null;
        this.aET = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aEU = 0;
        this.aEV = 0;
        this.aEW = 0;
        this.aFa = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aFb = 0;
        this.aFc = null;
        this.aFd = new BlockingLinkedDeque<>(5);
        this.aFe = new BlockingLinkedDeque<>(6);
        this.aFf = 0;
        this.aFh = 0L;
        this.mState = 0;
        this.aFi = true;
        this.mHandler = new Handler(new com.baidu.tbadk.widget.b(this));
        initData();
    }

    public int getImageType() {
        return this.ade;
    }

    public void setImageMode(int i) {
        this.aEK = i;
    }

    public void setOffset(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.aod = i;
    }

    public void actionUp() {
        this.aEQ = false;
        this.aEI = false;
        this.mMode = 0;
        HL();
        if (this.aEG < this.aEE) {
            this.aEG = this.aEE;
            HM();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.aEI = true;
                this.aEP = false;
                this.aEQ = false;
                break;
            case 1:
                actionUp();
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
            this.aEO = spacing(motionEvent);
            if (this.aEO > 10.0f) {
                this.mMode = 2;
            }
        }
        if (this.mMode == 2 || !this.mGestureDetector.onTouchEvent(motionEvent)) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.aEP = true;
                        this.aEQ = true;
                        if (this.ade != 1 && this.ade != 2) {
                            float spacing = spacing(motionEvent);
                            if (spacing >= 0.0f && Math.abs(this.aEO - spacing) >= 10.0f) {
                                if (Math.abs(this.aEO - spacing) > 100.0f) {
                                    this.aEO = spacing;
                                    break;
                                } else {
                                    float f = spacing / this.aEO;
                                    this.aEO = spacing;
                                    this.aEH = this.aEG;
                                    this.aEG *= f;
                                    if (this.aEG > this.aEF) {
                                        this.aEG = this.aEF;
                                    }
                                    if (this.aEG < this.aEE / 4.0f) {
                                        this.aEG = this.aEE / 4.0f;
                                    }
                                    HM();
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

    public float spacing(MotionEvent motionEvent) {
        return CompatibleUtile.getInstance().getSpacing(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            this.mViewWidth = i3 - i;
            this.mViewHeight = i4 - i2;
            reInitBitmap();
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public boolean pagerCantScroll() {
        return this.aEE == this.aEG;
    }

    private void reInitBitmap() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            if (this.aEK == 0) {
                float width = this.mViewWidth / imageBitmap.getWidth();
                float height = this.mViewHeight / imageBitmap.getHeight();
                if (this.aEY) {
                    if (this.ade == 2) {
                        this.aEE = 2.5f;
                    } else {
                        this.aEE = Math.min(width, height);
                    }
                } else if (this.ade == 2) {
                    this.aEE = 1.0f;
                } else {
                    float f = this.aEZ;
                    float f2 = f >= 1.0f ? f : 1.0f;
                    if (imageBitmap.getWidth() * f2 < this.mViewWidth && imageBitmap.getHeight() * f2 < this.mViewHeight) {
                        this.aEE = f2;
                    } else {
                        this.aEE = Math.min(width, height);
                    }
                }
            } else {
                this.aEE = Math.max(this.mViewWidth / imageBitmap.getWidth(), ((this.mViewHeight - this.mTop) - this.mBottom) / imageBitmap.getHeight());
            }
            this.aEF = this.aEJ / (imageBitmap.getWidth() * imageBitmap.getHeight());
            this.aEF = FloatMath.sqrt(this.aEF);
            if (this.aEF > 10.0f) {
                this.aEF = 10.0f;
            }
            this.aED.clear();
            this.aED.add(Float.valueOf(this.aEE));
            this.aEG = this.aEE;
            this.aEH = this.aEG;
            HM();
            HK();
            return;
        }
        this.aEB = 0.0f;
        this.aEC = 0.0f;
        this.aEE = 1.0f;
        this.aEF = 1.0f;
        this.aEG = 1.0f;
        this.aEH = this.aEG;
        this.aED.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HK() {
        if (this.aEL != null) {
            this.aEL.a(this, canZoomIn(), canZoomOut());
        }
    }

    public void setOnSizeChangedListener(e eVar) {
        this.aEL = eVar;
    }

    public byte[] getImageData() {
        return this.mImageData;
    }

    public void setImageData(byte[] bArr) {
        this.mImageData = bArr;
    }

    public Bitmap getGifCache() {
        return this.aET;
    }

    public void setGifCache(Bitmap bitmap) {
        this.aET = bitmap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        boolean z;
        int i4;
        if (this.ade == 2 && this.aEW != 0 && !this.aEN.HQ()) {
            int width = getWidth();
            int height = getHeight();
            Drawable drawable = getDrawable();
            float f = 0.0f;
            float f2 = height * 0.3f;
            float f3 = width;
            float f4 = (1.0f - 0.3f) * height;
            if (this.aEY && drawable != null) {
                Rect bounds = drawable.getBounds();
                int i5 = bounds.right - bounds.left;
                int i6 = bounds.bottom - bounds.top;
                f = (width / 2) - (i5 * 2.5f);
                f2 = (height / 2) - (i6 * 2.5f);
                f3 = (i5 * 2.5f) + (width / 2);
                f4 = (i6 * 2.5f) + (height / 2);
            }
            this.mPaint.setColor(at.getColor(this.aEW));
            canvas.drawRect(f, f2, f3, f4, this.mPaint);
            this.mPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        }
        super.onDraw(canvas);
        if (this.ade == 1 && this.aET != null && !this.aET.isRecycled()) {
            int width2 = this.aET.getWidth();
            int height2 = this.aET.getHeight();
            int width3 = getWidth();
            int height3 = getHeight();
            int i7 = (width3 - width2) >> 1;
            int i8 = (height3 - height2) >> 1;
            float f5 = this.aEZ;
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
            if (this.aER == 1 && this.aES != null && this.aFc != null && this.aFc.aFr != null) {
                if (z) {
                    canvas.drawBitmap(this.aFc.aFr, i3, i2, (Paint) null);
                } else {
                    canvas.drawBitmap(this.aFc.aFr, this.mMatrix, this.mPaint);
                }
                invalidate();
            } else if (z) {
                canvas.drawBitmap(this.aET, i3, i2, (Paint) null);
            } else {
                canvas.drawBitmap(this.aET, this.mMatrix, this.mPaint);
            }
        }
    }

    public void play() {
        com.baidu.adp.widget.a.a d2;
        if (this.ade == 1) {
            if (this.aES == null) {
                if (this.aFg != null) {
                    this.aFg.interrupt();
                    this.aFg = null;
                }
                if (this.mImageData != null && (d2 = a.C0004a.fn().d(this.mImageData, 0, this.mImageData.length)) != null && d2.getGif() != null) {
                    this.aES = d2.getGif();
                    if (this.aES != null) {
                        this.aER = 1;
                        this.width = this.aES.getWidth();
                        this.height = this.aES.getHeight();
                        this.aFf = 0;
                        this.aFb = this.aES.fo();
                    } else {
                        this.aER = 0;
                    }
                } else {
                    return;
                }
            }
            if (this.aES != null && this.mState == 0) {
                this.aFi = true;
                this.aFg = new b(this, null);
                this.aFd.clear();
                this.aFe.clear();
                this.mState = 1;
                this.aFg.start();
            }
        }
    }

    public void pause() {
        if (this.ade == 1) {
            this.mState = 0;
            if (this.aFg != null) {
                this.aFg.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.ade == 1) {
            this.mState = 0;
            if (this.aFg != null) {
                this.aFg.interrupt();
                this.aFg = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.aFi = true;
            this.aFc = null;
            this.aFe.clear();
            this.aFd.clear();
            this.width = 0;
            this.height = 0;
            this.aFf = 0;
            this.aFb = 0;
            if (this.aES != null) {
                this.aES = null;
            }
        }
    }

    private void initData() {
        this.aEZ = k.D(getContext());
        this.aEJ = k.C(getContext()) * k.B(getContext()) * 2;
        if (this.aEJ < 1690000) {
            this.aEJ = 1690000;
        }
        this.aEB = 0.0f;
        this.aEC = 0.0f;
        this.aED = new ArrayList<>();
        this.aEE = 1.0f;
        this.aEF = 1.0f;
        this.aEG = 1.0f;
        this.aEH = this.aEG;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.aEN = new C0057a();
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWillNotDraw(false);
        scrollTo(0, 0);
        this.mGestureDetector = new GestureDetector(getContext(), new com.baidu.tbadk.widget.c(this));
    }

    private void HL() {
        int i = 0;
        int scrollX = getScrollX();
        if (this.aEB >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.aEB) {
                scrollX = (int) (this.aEB - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.aEC + this.mTop + this.mBottom >= getHeight()) {
            i = scrollY < (-this.aEU) ? -this.aEU : scrollY;
            if (getHeight() + i > this.aEC + this.mBottom + this.aEV) {
                i = (int) ((this.aEC - getHeight()) + this.mBottom + this.aEV);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.aEB;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.aEC;
    }

    public boolean onRightSide() {
        if (this.ade == 1 || this.ade == 2) {
            return true;
        }
        return !this.aEQ && getScrollX() >= ((int) (this.aEB - ((float) getWidth()))) + (-1);
    }

    public boolean onLeftSide() {
        if (this.ade == 1 || this.ade == 2) {
            return true;
        }
        return !this.aEQ && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.aEN.HQ()) {
            this.aEN.stopAnimation();
        }
        this.aEW = 0;
        super.setImageBitmap(bitmap);
        reInitBitmap();
        this.ade = 0;
    }

    public void replaceImageBitmap(Bitmap bitmap) {
        Bitmap imageBitmap = getImageBitmap();
        if (bitmap != null && !bitmap.isRecycled()) {
            if (imageBitmap != null && (imageBitmap.getWidth() != bitmap.getWidth() || imageBitmap.getHeight() != bitmap.getHeight())) {
                setImageBitmap(bitmap);
                return;
            }
            if (this.aEN.HQ()) {
                this.aEN.stopAnimation();
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            super.setImageBitmap(bitmap);
            super.setImageMatrix(this.mMatrix);
            scrollTo(scrollX, scrollY);
            this.ade = 0;
        }
    }

    public void a(byte[] bArr, Bitmap bitmap) {
        if (this.aEN.HQ()) {
            this.aEN.stopAnimation();
        }
        super.setImageDrawable(null);
        stop();
        reInitBitmap();
        this.ade = 1;
        this.aET = bitmap;
        this.mImageData = bArr;
        if (this.aoc != null) {
            this.aoc.a(this);
        }
    }

    public void onDestroy() {
        if (this.aEN.HQ()) {
            this.aEN.stopAnimation();
        }
        super.setImageDrawable(null);
        this.mImageData = null;
        this.aET = null;
        stop();
        if (this.aES != null) {
            this.aES.close();
            this.aES = null;
        }
    }

    public void release() {
        if (this.aEN.HQ()) {
            this.aEN.stopAnimation();
        }
        stop();
        super.setImageDrawable(null);
        this.aET = null;
    }

    public void setDefaultBitmap() {
        if (this.aEN.HQ()) {
            this.aEN.stopAnimation();
        }
        if (this.aEY) {
            super.setImageBitmap(BitmapHelper.getCashBitmap(t.f.icon_default_avatar100));
        } else {
            super.setImageBitmap(BitmapHelper.getCashBitmap(t.f.btn_see_default));
        }
        this.ade = 2;
        reInitBitmap();
    }

    public void zoomInBitmap() {
        if (this.ade != 1 && this.ade != 2) {
            int size = this.aED.size();
            if (size > 0) {
                this.aED.add(Float.valueOf(this.aED.get(size - 1).floatValue() * 1.25f));
            } else {
                this.aED.add(Float.valueOf(this.aEE));
            }
            HM();
            HK();
        }
    }

    public void zoomOutBitmap() {
        if (this.ade != 1 && this.ade != 2) {
            int size = this.aED.size();
            if (size > 1) {
                this.aED.remove(size - 1);
            }
            HM();
            HK();
        }
    }

    public void restoreSize() {
        HK();
        if (this.ade != 1 && this.ade != 2 && this.aEG != this.aEE) {
            this.aED.clear();
            this.aED.add(Float.valueOf(this.aEE));
            this.aEG = this.aEE;
            this.aEH = this.aEG;
            HM();
        }
    }

    public boolean canZoomIn() {
        if (this.ade == 1 || this.ade == 2) {
            return false;
        }
        int size = this.aED.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.aED.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.aEJ) && floatValue <= 5.0f;
    }

    public boolean canZoomOut() {
        if (this.ade == 1 || this.ade == 2) {
            return false;
        }
        int size = this.aED.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled()) {
            return false;
        }
        return size > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HM() {
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
                    int size = this.aED.size();
                    if (size > 0) {
                        f2 = this.aED.get(size - 1).floatValue();
                    } else {
                        f2 = this.aEE;
                    }
                    this.aEG = f2;
                }
                this.mMatrix.setScale(this.aEG, this.aEG);
                this.aEB = imageBitmap.getWidth() * this.aEG;
                this.aEC = imageBitmap.getHeight() * this.aEG;
                float width = this.aEH * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.aEH;
                this.aEU = this.mTop;
                this.aEV = 0;
                float f3 = this.aEB < ((float) this.mViewWidth) ? (int) ((this.mViewWidth - this.aEB) / 2.0f) : 0.0f;
                if (this.aEC < this.mViewHeight) {
                    f = (int) ((this.mViewHeight - this.aEC) / 2.0f);
                    if (this.aEK == 1 && f > this.mTop) {
                        f = this.mTop;
                    }
                    this.aEU = (int) (this.mTop - f);
                    this.aEV = this.mTop - this.aEU;
                } else {
                    f = 0.0f;
                }
                this.mMatrix.postTranslate(f3, f);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    scrollX = i > getWidth() ? getWidth() : i;
                    if (this.aEB <= screenWidth) {
                        scrollX = 0;
                    } else if (this.aEB > screenWidth && this.aEB / 2.0f < screenWidth) {
                        scrollX = (int) (scrollX - (this.aEB / 4.0f));
                    }
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.aEB - width) / 2.0f);
                    }
                    if (this.aEB <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.aEB) {
                        scrollX = (int) (this.aEB - getWidth());
                    }
                }
                if (scrollX > 0 && this.aEB - scrollX < getWidth()) {
                    scrollX = (int) (this.aEB - getWidth());
                }
                if (this.mMode == 2) {
                    scrollY += (int) ((this.aEC - height) / 2.0f);
                }
                if (this.aEC <= getHeight()) {
                    scrollY = 0;
                } else if (getHeight() + scrollY > this.aEC) {
                    scrollY = (int) (this.aEC - getHeight());
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
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0057a extends Animation {
        private int Jd;
        private boolean aFk = false;
        private boolean aFl = false;
        private long aFm;
        private long aFn;
        private int aFo;
        private long aFp;
        private long aFq;

        public C0057a() {
        }

        public void b(float f, float f2) {
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
            this.aFm = f;
            this.aFn = f2;
            this.aFp = Math.abs((f * 1000.0f) / 2500.0f);
            this.aFq = Math.abs((f2 * 1000.0f) / 2500.0f);
            setDuration(Math.max(this.aFp, this.aFq));
            setInterpolator(a.this.aFa);
            this.aFo = a.this.getScrollX();
            this.Jd = a.this.getScrollY();
            this.aFk = true;
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
            if (this.aFp > this.aFq) {
                j = ((float) this.aFp) * f;
            } else {
                j = ((float) this.aFq) * f;
            }
            float f2 = ((float) (j > this.aFp ? this.aFp : j)) / 1000.0f;
            if (this.aFm > 0) {
                i = this.aFo - ((int) (f2 * (((float) this.aFm) - ((2500.0f * f2) / 2.0f))));
            } else {
                i = this.aFo - ((int) (f2 * (((float) this.aFm) + ((2500.0f * f2) / 2.0f))));
            }
            if (j > this.aFq) {
                j = this.aFq;
            }
            float f3 = ((float) j) / 1000.0f;
            if (this.aFn > 0) {
                i2 = this.Jd - ((int) (f3 * (((float) this.aFn) - ((2500.0f * f3) / 2.0f))));
            } else {
                i2 = this.Jd - ((int) (f3 * (((float) this.aFn) + ((2500.0f * f3) / 2.0f))));
            }
            if (a.this.aEC + a.this.mTop + a.this.mBottom > a.this.getHeight()) {
                if (i2 < (-a.this.aEU)) {
                    i2 = -a.this.aEU;
                }
                if (a.this.getHeight() + i2 > a.this.aEC + a.this.mBottom + a.this.aEV) {
                    i2 = (int) ((a.this.aEC - a.this.getHeight()) + a.this.mBottom + a.this.aEV);
                }
            } else {
                i2 = 0;
            }
            if (a.this.aEB > a.this.getWidth()) {
                int width = ((float) (a.this.getWidth() + i)) > a.this.aEB ? (int) (a.this.aEB - a.this.getWidth()) : i;
                if (width >= 0) {
                    i3 = width;
                }
            }
            a.this.scrollTo(i3, i2);
            a.this.invalidate();
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            if (!this.aFl) {
                if (a.this.aEI) {
                    this.aFk = false;
                    return false;
                }
                try {
                    if (!super.getTransformation(j, transformation)) {
                        this.aFk = false;
                        return false;
                    }
                    return true;
                } catch (Exception e) {
                    this.aFk = false;
                    return false;
                }
            }
            this.aFl = false;
            this.aFk = false;
            return false;
        }

        public boolean HQ() {
            return this.aFk;
        }

        public void stopAnimation() {
            this.aFl = true;
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.aEM = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aoa = onLongClickListener;
    }

    public void setGifSetListener(d dVar) {
        this.aoc = dVar;
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
    public void HN() {
        long j;
        c poll = this.aFd.poll();
        if (poll == null) {
            this.aFi = true;
            return;
        }
        this.aFi = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.aFc != null) {
            j = this.aFc.delay - (currentTimeMillis - this.aFh);
            this.aFe.offer(this.aFc);
        } else {
            j = 0;
        }
        this.aFc = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public c HO() {
        c poll = this.aFe.poll();
        if (poll == null) {
            poll = new c(null);
            try {
                poll.aFr = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
            } catch (OutOfMemoryError e2) {
                TbadkCoreApplication.m411getInst().onAppMemoryLow();
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
        public Bitmap aFr;
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
            while (a.this.mState == 1 && a.this.aES != null && a.this.aFb > 0 && a.this.width > 0 && a.this.height > 0) {
                try {
                    a.this.aES.Q(a.this.aFf);
                    c HO = a.this.HO();
                    if (HO.aFr == null || (HO.aFr.getWidth() != a.this.width && HO.aFr.getHeight() != a.this.height)) {
                        try {
                            HO.aFr = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_8888);
                        } catch (OutOfMemoryError e) {
                            TbadkCoreApplication.m411getInst().onAppMemoryLow();
                            try {
                                HO.aFr = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_4444);
                            } catch (OutOfMemoryError e2) {
                                TbadkCoreApplication.m411getInst().onAppMemoryLow();
                            } catch (Throwable th) {
                                BdLog.e(th.getMessage());
                            }
                        } catch (Throwable th2) {
                            BdLog.e(th2.getMessage());
                        }
                    }
                    a.this.aES.a(HO.aFr, null);
                    HO.delay = a.this.aES.R(a.this.aFf);
                    a.this.aFf++;
                    if (HO.aFr == null) {
                        a.this.aFf++;
                    }
                    a.this.aFf %= a.this.aFb;
                    a.this.aFd.put(HO);
                    if (a.this.aFi) {
                        a.this.mHandler.sendEmptyMessage(1);
                    }
                } catch (Exception e3) {
                    return;
                }
            }
        }
    }

    public boolean HP() {
        return this.aEX;
    }

    public void setLoadBigImage(boolean z) {
        this.aEX = z;
    }
}
