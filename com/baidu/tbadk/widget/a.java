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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends ImageView {
    private float aEQ;
    private float aER;
    private ArrayList<Float> aES;
    private float aET;
    private float aEU;
    private float aEV;
    private float aEW;
    private boolean aEX;
    private int aEY;
    private int aEZ;
    private e aFa;
    private View.OnClickListener aFb;
    private C0049a aFc;
    private float aFd;
    private boolean aFe;
    private boolean aFf;
    private int aFg;
    private volatile com.baidu.adp.gif.b aFh;
    private Bitmap aFi;
    private int aFj;
    private int aFk;
    private int aFl;
    private int aFm;
    private boolean aFn;
    private boolean aFo;
    private float aFp;
    private Interpolator aFq;
    private int aFr;
    private c aFs;
    private BlockingLinkedDeque<c> aFt;
    private BlockingLinkedDeque<c> aFu;
    private volatile int aFv;
    private b aFw;
    private volatile long aFx;
    private volatile boolean aFy;
    private int act;
    private View.OnLongClickListener aou;
    private d aow;
    private int aox;
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
        this.aFo = z;
    }

    public a(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aEX = false;
        this.mImageData = null;
        this.aox = 0;
        this.aEY = 1300;
        this.aEZ = 0;
        this.aFa = null;
        this.aFb = null;
        this.aou = null;
        this.aow = null;
        this.aFd = 1.0f;
        this.act = 0;
        this.mMode = 0;
        this.aFe = false;
        this.aFf = false;
        this.aFg = 0;
        this.aFh = null;
        this.aFi = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aFj = 0;
        this.aFk = 0;
        this.aFl = 0;
        this.aFm = 0;
        this.aFq = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aFr = 0;
        this.aFs = null;
        this.aFt = new BlockingLinkedDeque<>(5);
        this.aFu = new BlockingLinkedDeque<>(6);
        this.aFv = 0;
        this.aFx = 0L;
        this.mState = 0;
        this.aFy = true;
        this.mHandler = new Handler(new com.baidu.tbadk.widget.b(this));
        initData();
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aEX = false;
        this.mImageData = null;
        this.aox = 0;
        this.aEY = 1300;
        this.aEZ = 0;
        this.aFa = null;
        this.aFb = null;
        this.aou = null;
        this.aow = null;
        this.aFd = 1.0f;
        this.act = 0;
        this.mMode = 0;
        this.aFe = false;
        this.aFf = false;
        this.aFg = 0;
        this.aFh = null;
        this.aFi = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aFj = 0;
        this.aFk = 0;
        this.aFl = 0;
        this.aFm = 0;
        this.aFq = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aFr = 0;
        this.aFs = null;
        this.aFt = new BlockingLinkedDeque<>(5);
        this.aFu = new BlockingLinkedDeque<>(6);
        this.aFv = 0;
        this.aFx = 0L;
        this.mState = 0;
        this.aFy = true;
        this.mHandler = new Handler(new com.baidu.tbadk.widget.b(this));
        initData();
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aEX = false;
        this.mImageData = null;
        this.aox = 0;
        this.aEY = 1300;
        this.aEZ = 0;
        this.aFa = null;
        this.aFb = null;
        this.aou = null;
        this.aow = null;
        this.aFd = 1.0f;
        this.act = 0;
        this.mMode = 0;
        this.aFe = false;
        this.aFf = false;
        this.aFg = 0;
        this.aFh = null;
        this.aFi = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aFj = 0;
        this.aFk = 0;
        this.aFl = 0;
        this.aFm = 0;
        this.aFq = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aFr = 0;
        this.aFs = null;
        this.aFt = new BlockingLinkedDeque<>(5);
        this.aFu = new BlockingLinkedDeque<>(6);
        this.aFv = 0;
        this.aFx = 0L;
        this.mState = 0;
        this.aFy = true;
        this.mHandler = new Handler(new com.baidu.tbadk.widget.b(this));
        initData();
    }

    public int getImageType() {
        return this.act;
    }

    public void setImageMode(int i) {
        this.aEZ = i;
    }

    public void h(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.aox = i;
    }

    public void GK() {
        this.aFf = false;
        this.aEX = false;
        this.mMode = 0;
        GO();
        if (this.aEV < this.aET) {
            this.aEV = this.aET;
            GV();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.aEX = true;
                this.aFe = false;
                this.aFf = false;
                break;
            case 1:
                GK();
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
            this.aFd = i(motionEvent);
            if (this.aFd > 10.0f) {
                this.mMode = 2;
            }
        }
        if (this.mMode == 2 || !this.mGestureDetector.onTouchEvent(motionEvent)) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.aFe = true;
                        this.aFf = true;
                        if (this.act != 1 && this.act != 2) {
                            float i = i(motionEvent);
                            if (i >= 0.0f && Math.abs(this.aFd - i) >= 10.0f) {
                                if (Math.abs(this.aFd - i) > 100.0f) {
                                    this.aFd = i;
                                    break;
                                } else {
                                    float f = i / this.aFd;
                                    this.aFd = i;
                                    this.aEW = this.aEV;
                                    this.aEV *= f;
                                    if (this.aEV > this.aEU) {
                                        this.aEV = this.aEU;
                                    }
                                    if (this.aEV < this.aET / 4.0f) {
                                        this.aEV = this.aET / 4.0f;
                                    }
                                    GV();
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
            GM();
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public boolean GL() {
        return this.aET == this.aEV;
    }

    private void GM() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            if (this.aEZ == 0) {
                float width = this.mViewWidth / imageBitmap.getWidth();
                float height = this.mViewHeight / imageBitmap.getHeight();
                if (this.aFo) {
                    if (this.act == 2) {
                        this.aET = 2.5f;
                    } else {
                        this.aET = Math.min(width, height);
                    }
                } else if (this.act == 2) {
                    this.aET = 1.0f;
                } else {
                    float f = this.aFp;
                    float f2 = f >= 1.0f ? f : 1.0f;
                    if (imageBitmap.getWidth() * f2 < this.mViewWidth && imageBitmap.getHeight() * f2 < this.mViewHeight) {
                        this.aET = f2;
                    } else {
                        this.aET = Math.min(width, height);
                    }
                }
            } else {
                this.aET = Math.max(this.mViewWidth / imageBitmap.getWidth(), ((this.mViewHeight - this.mTop) - this.mBottom) / imageBitmap.getHeight());
            }
            this.aEU = this.aEY / (imageBitmap.getWidth() * imageBitmap.getHeight());
            this.aEU = FloatMath.sqrt(this.aEU);
            if (this.aEU > 10.0f) {
                this.aEU = 10.0f;
            }
            this.aES.clear();
            this.aES.add(Float.valueOf(this.aET));
            this.aEV = this.aET;
            this.aEW = this.aEV;
            GV();
            return;
        }
        this.aEQ = 0.0f;
        this.aER = 0.0f;
        this.aET = 1.0f;
        this.aEU = 1.0f;
        this.aEV = 1.0f;
        this.aEW = this.aEV;
        this.aES.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    private void GN() {
        if (this.aFa != null) {
            this.aFa.a(this, canZoomIn(), canZoomOut());
        }
    }

    public void setOnSizeChangedListener(e eVar) {
        this.aFa = eVar;
    }

    public byte[] getImageData() {
        return this.mImageData;
    }

    public void setImageData(byte[] bArr) {
        this.mImageData = bArr;
    }

    public Bitmap getGifCache() {
        return this.aFi;
    }

    public void setGifCache(Bitmap bitmap) {
        this.aFi = bitmap;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        boolean z;
        int i4;
        if (this.act == 2 && this.aFm != 0 && !this.aFc.GZ()) {
            int width = getWidth();
            int height = getHeight();
            Drawable drawable = getDrawable();
            float f = 0.0f;
            float f2 = height * 0.3f;
            float f3 = width;
            float f4 = (1.0f - 0.3f) * height;
            if (this.aFo && drawable != null) {
                Rect bounds = drawable.getBounds();
                int i5 = bounds.right - bounds.left;
                int i6 = bounds.bottom - bounds.top;
                f = (width / 2) - (i5 * 2.5f);
                f2 = (height / 2) - (i6 * 2.5f);
                f3 = (i5 * 2.5f) + (width / 2);
                f4 = (i6 * 2.5f) + (height / 2);
            }
            this.mPaint.setColor(ar.getColor(this.aFm));
            canvas.drawRect(f, f2, f3, f4, this.mPaint);
            this.mPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        }
        super.onDraw(canvas);
        if (this.act == 1 && this.aFi != null && !this.aFi.isRecycled()) {
            int width2 = this.aFi.getWidth();
            int height2 = this.aFi.getHeight();
            int width3 = getWidth();
            int height3 = getHeight();
            int i7 = (width3 - width2) >> 1;
            int i8 = (height3 - height2) >> 1;
            float f5 = this.aFp;
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
            if (this.aFg == 1 && this.aFh != null && this.aFs != null && this.aFs.aFH != null) {
                if (z) {
                    canvas.drawBitmap(this.aFs.aFH, i3, i2, (Paint) null);
                } else {
                    canvas.drawBitmap(this.aFs.aFH, this.mMatrix, this.mPaint);
                }
                invalidate();
            } else if (z) {
                canvas.drawBitmap(this.aFi, i3, i2, (Paint) null);
            } else {
                canvas.drawBitmap(this.aFi, this.mMatrix, this.mPaint);
            }
        }
    }

    public void play() {
        com.baidu.adp.widget.a.a aVar;
        if (this.act == 1) {
            if (this.aFh == null) {
                if (this.aFw != null) {
                    this.aFw.interrupt();
                    this.aFw = null;
                }
                if (this.mImageData != null) {
                    try {
                        aVar = a.C0004a.cw().e(this.mImageData, 0, this.mImageData.length);
                    } catch (StackOverflowError e2) {
                        aVar = null;
                    }
                    if (aVar != null && aVar.getGif() != null) {
                        this.aFh = aVar.getGif();
                        if (this.aFh != null) {
                            this.aFg = 1;
                            this.width = this.aFh.getWidth();
                            this.height = this.aFh.getHeight();
                            this.aFv = 0;
                            this.aFr = this.aFh.cx();
                        } else {
                            this.aFg = 0;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            if (this.aFh != null && this.mState == 0) {
                this.aFy = true;
                this.aFw = new b(this, null);
                this.aFt.clear();
                this.aFu.clear();
                this.mState = 1;
                this.aFw.start();
            }
        }
    }

    public void pause() {
        if (this.act == 1) {
            this.mState = 0;
            if (this.aFw != null) {
                this.aFw.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.act == 1) {
            this.mState = 0;
            if (this.aFw != null) {
                this.aFw.interrupt();
                this.aFw = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.aFy = true;
            this.aFs = null;
            this.aFu.clear();
            this.aFt.clear();
            this.width = 0;
            this.height = 0;
            this.aFv = 0;
            this.aFr = 0;
            if (this.aFh != null) {
                this.aFh = null;
            }
        }
    }

    private void initData() {
        this.aFp = k.K(getContext());
        this.aEY = k.J(getContext()) * k.I(getContext()) * 2;
        if (this.aEY < 1690000) {
            this.aEY = 1690000;
        }
        this.aEQ = 0.0f;
        this.aER = 0.0f;
        this.aES = new ArrayList<>();
        this.aET = 1.0f;
        this.aEU = 1.0f;
        this.aEV = 1.0f;
        this.aEW = this.aEV;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.aFc = new C0049a();
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWillNotDraw(false);
        scrollTo(0, 0);
        this.mGestureDetector = new GestureDetector(getContext(), new com.baidu.tbadk.widget.c(this));
    }

    private void GO() {
        int i = 0;
        int scrollX = getScrollX();
        if (this.aEQ >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.aEQ) {
                scrollX = (int) (this.aEQ - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.aER + this.mTop + this.mBottom >= getHeight()) {
            i = scrollY < (-this.aFj) ? -this.aFj : scrollY;
            if (getHeight() + i > this.aER + this.mBottom + this.aFk) {
                i = (int) ((this.aER - getHeight()) + this.mBottom + this.aFk);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.aEQ;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.aER;
    }

    public boolean GP() {
        if (this.act == 1 || this.act == 2) {
            return true;
        }
        return !this.aFf && getScrollX() >= ((int) (this.aEQ - ((float) getWidth()))) + (-1);
    }

    public boolean GQ() {
        if (this.act == 1 || this.act == 2) {
            return true;
        }
        return !this.aFf && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.aFc.GZ()) {
            this.aFc.stopAnimation();
        }
        this.aFm = 0;
        super.setImageBitmap(bitmap);
        GM();
        this.act = 0;
    }

    public void j(Bitmap bitmap) {
        Bitmap imageBitmap = getImageBitmap();
        if (bitmap != null && !bitmap.isRecycled()) {
            if (imageBitmap != null && (imageBitmap.getWidth() != bitmap.getWidth() || imageBitmap.getHeight() != bitmap.getHeight())) {
                setImageBitmap(bitmap);
                return;
            }
            if (this.aFc.GZ()) {
                this.aFc.stopAnimation();
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            super.setImageBitmap(bitmap);
            super.setImageMatrix(this.mMatrix);
            scrollTo(scrollX, scrollY);
            this.act = 0;
        }
    }

    public void a(byte[] bArr, Bitmap bitmap) {
        if (this.aFc.GZ()) {
            this.aFc.stopAnimation();
        }
        super.setImageDrawable(null);
        stop();
        GM();
        this.act = 1;
        this.aFi = bitmap;
        this.mImageData = bArr;
        if (this.aow != null) {
            this.aow.a(this);
        }
    }

    public void onDestroy() {
        if (this.aFc.GZ()) {
            this.aFc.stopAnimation();
        }
        super.setImageDrawable(null);
        this.mImageData = null;
        this.aFi = null;
        stop();
        if (this.aFh != null) {
            this.aFh.close();
            this.aFh = null;
        }
    }

    public void release() {
        if (this.aFc.GZ()) {
            this.aFc.stopAnimation();
        }
        stop();
        super.setImageDrawable(null);
        this.aFi = null;
    }

    public void GR() {
        if (this.aFc.GZ()) {
            this.aFc.stopAnimation();
        }
        if (this.aFo) {
            super.setImageBitmap(BitmapHelper.getCashBitmap(r.f.icon_default_avatar100));
        } else {
            super.setImageBitmap(BitmapHelper.getCashBitmap(r.f.btn_see_default));
        }
        this.act = 2;
        GM();
    }

    public void GS() {
        if (this.act != 1 && this.act != 2) {
            int size = this.aES.size();
            if (size > 0) {
                this.aES.add(Float.valueOf(this.aES.get(size - 1).floatValue() * 1.25f));
            } else {
                this.aES.add(Float.valueOf(this.aET));
            }
            GV();
        }
    }

    public void GT() {
        if (this.act != 1 && this.act != 2) {
            int size = this.aES.size();
            if (size > 1) {
                this.aES.remove(size - 1);
            }
            GV();
        }
    }

    public void GU() {
        GN();
        if (this.act != 1 && this.act != 2 && this.aEV != this.aET) {
            this.aES.clear();
            this.aES.add(Float.valueOf(this.aET));
            this.aEV = this.aET;
            this.aEW = this.aEV;
            GV();
        }
    }

    public boolean canZoomIn() {
        if (this.act == 1 || this.act == 2) {
            return false;
        }
        int size = this.aES.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.aES.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.aEY) && floatValue <= 5.0f;
    }

    public boolean canZoomOut() {
        if (this.act == 1 || this.act == 2) {
            return false;
        }
        int size = this.aES.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled()) {
            return false;
        }
        return size > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GV() {
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
                    int size = this.aES.size();
                    if (size > 0) {
                        f2 = this.aES.get(size - 1).floatValue();
                    } else {
                        f2 = this.aET;
                    }
                    this.aEV = f2;
                }
                this.mMatrix.setScale(this.aEV, this.aEV);
                this.aEQ = imageBitmap.getWidth() * this.aEV;
                this.aER = imageBitmap.getHeight() * this.aEV;
                float width = this.aEW * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.aEW;
                this.aFj = this.mTop;
                this.aFk = 0;
                float f3 = this.aEQ < ((float) this.mViewWidth) ? (int) ((this.mViewWidth - this.aEQ) / 2.0f) : 0.0f;
                if (this.aER < this.mViewHeight) {
                    f = (int) ((this.mViewHeight - this.aER) / 2.0f);
                    if (this.aEZ == 1 && f > this.mTop) {
                        f = this.mTop;
                    }
                    this.aFj = (int) (this.mTop - f);
                    this.aFk = this.mTop - this.aFj;
                } else {
                    f = 0.0f;
                }
                this.aFl = (int) f3;
                this.mMatrix.postTranslate(f3, f);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    scrollX = i > getWidth() ? getWidth() : i;
                    if (this.aEQ <= screenWidth) {
                        scrollX = 0;
                    } else if (this.aEQ > screenWidth && this.aEQ / 2.0f < screenWidth) {
                        scrollX = (int) (scrollX - (this.aEQ / 4.0f));
                    }
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.aEQ - width) / 2.0f);
                    }
                    if (this.aEQ <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.aEQ) {
                        scrollX = (int) (this.aEQ - getWidth());
                    }
                }
                if (scrollX > 0 && this.aEQ - scrollX < getWidth()) {
                    scrollX = (int) (this.aEQ - getWidth());
                }
                if (this.mMode == 2) {
                    scrollY += (int) ((this.aER - height) / 2.0f);
                }
                if (this.aER <= getHeight()) {
                    scrollY = 0;
                } else if (getHeight() + scrollY > this.aER) {
                    scrollY = (int) (this.aER - getHeight());
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
                GN();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0049a extends Animation {
        private int Cj;
        private boolean aFA = false;
        private boolean aFB = false;
        private long aFC;
        private long aFD;
        private int aFE;
        private long aFF;
        private long aFG;

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
            this.aFC = f;
            this.aFD = f2;
            this.aFF = Math.abs((f * 1000.0f) / 2500.0f);
            this.aFG = Math.abs((f2 * 1000.0f) / 2500.0f);
            setDuration(Math.max(this.aFF, this.aFG));
            setInterpolator(a.this.aFq);
            this.aFE = a.this.getScrollX();
            this.Cj = a.this.getScrollY();
            this.aFA = true;
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
            if (this.aFF > this.aFG) {
                j = ((float) this.aFF) * f;
            } else {
                j = ((float) this.aFG) * f;
            }
            float f2 = ((float) (j > this.aFF ? this.aFF : j)) / 1000.0f;
            if (this.aFC > 0) {
                i = this.aFE - ((int) (f2 * (((float) this.aFC) - ((2500.0f * f2) / 2.0f))));
            } else {
                i = this.aFE - ((int) (f2 * (((float) this.aFC) + ((2500.0f * f2) / 2.0f))));
            }
            if (j > this.aFG) {
                j = this.aFG;
            }
            float f3 = ((float) j) / 1000.0f;
            if (this.aFD > 0) {
                i2 = this.Cj - ((int) (f3 * (((float) this.aFD) - ((2500.0f * f3) / 2.0f))));
            } else {
                i2 = this.Cj - ((int) (f3 * (((float) this.aFD) + ((2500.0f * f3) / 2.0f))));
            }
            if (a.this.aER + a.this.mTop + a.this.mBottom > a.this.getHeight()) {
                if (i2 < (-a.this.aFj)) {
                    i2 = -a.this.aFj;
                }
                if (a.this.getHeight() + i2 > a.this.aER + a.this.mBottom + a.this.aFk) {
                    i2 = (int) ((a.this.aER - a.this.getHeight()) + a.this.mBottom + a.this.aFk);
                }
            } else {
                i2 = 0;
            }
            if (a.this.aEQ > a.this.getWidth()) {
                int width = ((float) (a.this.getWidth() + i)) > a.this.aEQ ? (int) (a.this.aEQ - a.this.getWidth()) : i;
                if (width >= 0) {
                    i3 = width;
                }
            }
            a.this.scrollTo(i3, i2);
            a.this.invalidate();
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            if (!this.aFB) {
                if (a.this.aEX) {
                    this.aFA = false;
                    return false;
                }
                try {
                    if (!super.getTransformation(j, transformation)) {
                        this.aFA = false;
                        return false;
                    }
                    return true;
                } catch (Exception e) {
                    this.aFA = false;
                    return false;
                }
            }
            this.aFB = false;
            this.aFA = false;
            return false;
        }

        public boolean GZ() {
            return this.aFA;
        }

        public void stopAnimation() {
            this.aFB = true;
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.aFb = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aou = onLongClickListener;
    }

    public void setGifSetListener(d dVar) {
        this.aow = dVar;
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
    public void GW() {
        long j;
        c poll = this.aFt.poll();
        if (poll == null) {
            this.aFy = true;
            return;
        }
        this.aFy = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.aFs != null) {
            j = this.aFs.delay - (currentTimeMillis - this.aFx);
            this.aFu.offer(this.aFs);
        } else {
            j = 0;
        }
        this.aFs = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public c GX() {
        c poll = this.aFu.poll();
        if (poll == null) {
            poll = new c(null);
            try {
                poll.aFH = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
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
        public Bitmap aFH;
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
            while (a.this.mState == 1 && a.this.aFh != null && a.this.aFr > 0 && a.this.width > 0 && a.this.height > 0) {
                try {
                    a.this.aFh.V(a.this.aFv);
                    c GX = a.this.GX();
                    if (GX.aFH == null || (GX.aFH.getWidth() != a.this.width && GX.aFH.getHeight() != a.this.height)) {
                        try {
                            GX.aFH = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_8888);
                        } catch (OutOfMemoryError e) {
                            TbadkCoreApplication.m9getInst().onAppMemoryLow();
                            try {
                                GX.aFH = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_4444);
                            } catch (OutOfMemoryError e2) {
                                TbadkCoreApplication.m9getInst().onAppMemoryLow();
                            } catch (Throwable th) {
                                BdLog.e(th.getMessage());
                            }
                        } catch (Throwable th2) {
                            BdLog.e(th2.getMessage());
                        }
                    }
                    a.this.aFh.a(GX.aFH, null);
                    GX.delay = a.this.aFh.W(a.this.aFv);
                    a.this.aFv++;
                    if (GX.aFH == null) {
                        a.this.aFv++;
                    }
                    a.this.aFv %= a.this.aFr;
                    a.this.aFt.put(GX);
                    if (a.this.aFy) {
                        a.this.mHandler.sendEmptyMessage(1);
                    }
                } catch (Exception e3) {
                    return;
                }
            }
        }
    }

    public boolean GY() {
        return this.aFn;
    }

    public void setLoadBigImage(boolean z) {
        this.aFn = z;
    }

    public int getBottomOffset() {
        return this.aFk;
    }

    public int getLeftOffset() {
        return this.aFl;
    }
}
