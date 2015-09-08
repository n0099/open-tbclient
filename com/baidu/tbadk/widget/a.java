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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends ImageView {
    private int aBA;
    private boolean aBB;
    private boolean aBC;
    private float aBD;
    private Interpolator aBE;
    private int aBF;
    private c aBG;
    private BlockingLinkedDeque<c> aBH;
    private BlockingLinkedDeque<c> aBI;
    private volatile int aBJ;
    private b aBK;
    private volatile long aBL;
    private volatile boolean aBM;
    private float aBf;
    private float aBg;
    private ArrayList<Float> aBh;
    private float aBi;
    private float aBj;
    private float aBk;
    private float aBl;
    private boolean aBm;
    private int aBn;
    private int aBo;
    private e aBp;
    private View.OnClickListener aBq;
    private C0054a aBr;
    private float aBs;
    private boolean aBt;
    private boolean aBu;
    private int aBv;
    private volatile com.baidu.adp.gif.b aBw;
    private Bitmap aBx;
    private int aBy;
    private int aBz;
    private int abO;
    private View.OnLongClickListener alb;
    private d ald;
    private int ale;
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
        this.aBC = z;
    }

    public a(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aBm = false;
        this.mImageData = null;
        this.ale = 0;
        this.aBn = 1300;
        this.aBo = 0;
        this.aBp = null;
        this.aBq = null;
        this.alb = null;
        this.ald = null;
        this.aBs = 1.0f;
        this.abO = 0;
        this.mMode = 0;
        this.aBt = false;
        this.aBu = false;
        this.aBv = 0;
        this.aBw = null;
        this.aBx = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aBy = 0;
        this.aBz = 0;
        this.aBA = 0;
        this.aBE = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aBF = 0;
        this.aBG = null;
        this.aBH = new BlockingLinkedDeque<>(5);
        this.aBI = new BlockingLinkedDeque<>(6);
        this.aBJ = 0;
        this.aBL = 0L;
        this.mState = 0;
        this.aBM = true;
        this.mHandler = new Handler(new com.baidu.tbadk.widget.b(this));
        initData();
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aBm = false;
        this.mImageData = null;
        this.ale = 0;
        this.aBn = 1300;
        this.aBo = 0;
        this.aBp = null;
        this.aBq = null;
        this.alb = null;
        this.ald = null;
        this.aBs = 1.0f;
        this.abO = 0;
        this.mMode = 0;
        this.aBt = false;
        this.aBu = false;
        this.aBv = 0;
        this.aBw = null;
        this.aBx = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aBy = 0;
        this.aBz = 0;
        this.aBA = 0;
        this.aBE = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aBF = 0;
        this.aBG = null;
        this.aBH = new BlockingLinkedDeque<>(5);
        this.aBI = new BlockingLinkedDeque<>(6);
        this.aBJ = 0;
        this.aBL = 0L;
        this.mState = 0;
        this.aBM = true;
        this.mHandler = new Handler(new com.baidu.tbadk.widget.b(this));
        initData();
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aBm = false;
        this.mImageData = null;
        this.ale = 0;
        this.aBn = 1300;
        this.aBo = 0;
        this.aBp = null;
        this.aBq = null;
        this.alb = null;
        this.ald = null;
        this.aBs = 1.0f;
        this.abO = 0;
        this.mMode = 0;
        this.aBt = false;
        this.aBu = false;
        this.aBv = 0;
        this.aBw = null;
        this.aBx = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aBy = 0;
        this.aBz = 0;
        this.aBA = 0;
        this.aBE = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aBF = 0;
        this.aBG = null;
        this.aBH = new BlockingLinkedDeque<>(5);
        this.aBI = new BlockingLinkedDeque<>(6);
        this.aBJ = 0;
        this.aBL = 0L;
        this.mState = 0;
        this.aBM = true;
        this.mHandler = new Handler(new com.baidu.tbadk.widget.b(this));
        initData();
    }

    public int getImageType() {
        return this.abO;
    }

    public void setImageMode(int i) {
        this.aBo = i;
    }

    public void setOffset(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.ale = i;
    }

    public void actionUp() {
        this.aBu = false;
        this.aBm = false;
        this.mMode = 0;
        EW();
        if (this.aBk < this.aBi) {
            this.aBk = this.aBi;
            EX();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.aBm = true;
                this.aBt = false;
                this.aBu = false;
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
            this.aBs = spacing(motionEvent);
            if (this.aBs > 10.0f) {
                this.mMode = 2;
            }
        }
        if (this.mMode == 2 || !this.mGestureDetector.onTouchEvent(motionEvent)) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.aBt = true;
                        this.aBu = true;
                        if (this.abO != 1 && this.abO != 2) {
                            float spacing = spacing(motionEvent);
                            if (spacing >= 0.0f && Math.abs(this.aBs - spacing) >= 10.0f) {
                                if (Math.abs(this.aBs - spacing) > 100.0f) {
                                    this.aBs = spacing;
                                    break;
                                } else {
                                    float f = spacing / this.aBs;
                                    this.aBs = spacing;
                                    this.aBl = this.aBk;
                                    this.aBk *= f;
                                    if (this.aBk > this.aBj) {
                                        this.aBk = this.aBj;
                                    }
                                    if (this.aBk < this.aBi / 4.0f) {
                                        this.aBk = this.aBi / 4.0f;
                                    }
                                    EX();
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
        return this.aBi == this.aBk;
    }

    private void reInitBitmap() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            if (this.aBo == 0) {
                float width = this.mViewWidth / imageBitmap.getWidth();
                float height = this.mViewHeight / imageBitmap.getHeight();
                if (this.aBC) {
                    if (this.abO == 2) {
                        this.aBi = 2.5f;
                    } else {
                        this.aBi = Math.min(width, height);
                    }
                } else if (this.abO == 2) {
                    this.aBi = 1.0f;
                } else {
                    float f = this.aBD;
                    float f2 = f >= 1.0f ? f : 1.0f;
                    if (imageBitmap.getWidth() * f2 < this.mViewWidth && imageBitmap.getHeight() * f2 < this.mViewHeight) {
                        this.aBi = f2;
                    } else {
                        this.aBi = Math.min(width, height);
                    }
                }
            } else {
                this.aBi = Math.max(this.mViewWidth / imageBitmap.getWidth(), ((this.mViewHeight - this.mTop) - this.mBottom) / imageBitmap.getHeight());
            }
            this.aBj = this.aBn / (imageBitmap.getWidth() * imageBitmap.getHeight());
            this.aBj = FloatMath.sqrt(this.aBj);
            if (this.aBj > 10.0f) {
                this.aBj = 10.0f;
            }
            this.aBh.clear();
            this.aBh.add(Float.valueOf(this.aBi));
            this.aBk = this.aBi;
            this.aBl = this.aBk;
            EX();
            EV();
            return;
        }
        this.aBf = 0.0f;
        this.aBg = 0.0f;
        this.aBi = 1.0f;
        this.aBj = 1.0f;
        this.aBk = 1.0f;
        this.aBl = this.aBk;
        this.aBh.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EV() {
        if (this.aBp != null) {
            this.aBp.a(this, canZoomIn(), canZoomOut());
        }
    }

    public void setOnSizeChangedListener(e eVar) {
        this.aBp = eVar;
    }

    public byte[] getImageData() {
        return this.mImageData;
    }

    public void setImageData(byte[] bArr) {
        this.mImageData = bArr;
    }

    public Bitmap getGifCache() {
        return this.aBx;
    }

    public void setGifCache(Bitmap bitmap) {
        this.aBx = bitmap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        boolean z;
        int i4;
        if (this.abO == 2 && this.aBA != 0 && !this.aBr.Fb()) {
            int width = getWidth();
            int height = getHeight();
            Drawable drawable = getDrawable();
            float f = 0.0f;
            float f2 = height * 0.3f;
            float f3 = width;
            float f4 = (1.0f - 0.3f) * height;
            if (this.aBC && drawable != null) {
                Rect bounds = drawable.getBounds();
                int i5 = bounds.right - bounds.left;
                int i6 = bounds.bottom - bounds.top;
                f = (width / 2) - (i5 * 2.5f);
                f2 = (height / 2) - (i6 * 2.5f);
                f3 = (i5 * 2.5f) + (width / 2);
                f4 = (i6 * 2.5f) + (height / 2);
            }
            this.mPaint.setColor(al.getColor(this.aBA));
            canvas.drawRect(f, f2, f3, f4, this.mPaint);
            this.mPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        }
        super.onDraw(canvas);
        if (this.abO == 1 && this.aBx != null && !this.aBx.isRecycled()) {
            int width2 = this.aBx.getWidth();
            int height2 = this.aBx.getHeight();
            int width3 = getWidth();
            int height3 = getHeight();
            int i7 = (width3 - width2) >> 1;
            int i8 = (height3 - height2) >> 1;
            float f5 = this.aBD;
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
            if (this.aBv == 1 && this.aBw != null && this.aBG != null && this.aBG.aBV != null) {
                if (z) {
                    canvas.drawBitmap(this.aBG.aBV, i3, i2, (Paint) null);
                } else {
                    canvas.drawBitmap(this.aBG.aBV, this.mMatrix, this.mPaint);
                }
                invalidate();
            } else if (z) {
                canvas.drawBitmap(this.aBx, i3, i2, (Paint) null);
            } else {
                canvas.drawBitmap(this.aBx, this.mMatrix, this.mPaint);
            }
        }
    }

    public void play() {
        com.baidu.adp.widget.a.a e2;
        if (this.abO == 1) {
            if (this.aBw == null) {
                if (this.aBK != null) {
                    this.aBK.interrupt();
                    this.aBK = null;
                }
                if (this.mImageData != null && (e2 = a.C0002a.fe().e(this.mImageData, 0, this.mImageData.length)) != null && e2.getGif() != null) {
                    this.aBw = e2.getGif();
                    if (this.aBw != null) {
                        this.aBv = 1;
                        this.width = this.aBw.getWidth();
                        this.height = this.aBw.getHeight();
                        this.aBJ = 0;
                        this.aBF = this.aBw.ff();
                    } else {
                        this.aBv = 0;
                    }
                } else {
                    return;
                }
            }
            if (this.aBw != null && this.mState == 0) {
                this.aBM = true;
                this.aBK = new b(this, null);
                this.aBH.clear();
                this.aBI.clear();
                this.mState = 1;
                this.aBK.start();
            }
        }
    }

    public void pause() {
        if (this.abO == 1) {
            this.mState = 0;
            if (this.aBK != null) {
                this.aBK.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.abO == 1) {
            this.mState = 0;
            if (this.aBK != null) {
                this.aBK.interrupt();
                this.aBK = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.aBM = true;
            this.aBG = null;
            this.aBI.clear();
            this.aBH.clear();
            this.width = 0;
            this.height = 0;
            this.aBJ = 0;
            this.aBF = 0;
            if (this.aBw != null) {
                this.aBw = null;
            }
        }
    }

    private void initData() {
        this.aBD = k.M(getContext());
        this.aBn = k.L(getContext()) * k.K(getContext()) * 2;
        if (this.aBn < 1690000) {
            this.aBn = 1690000;
        }
        this.aBf = 0.0f;
        this.aBg = 0.0f;
        this.aBh = new ArrayList<>();
        this.aBi = 1.0f;
        this.aBj = 1.0f;
        this.aBk = 1.0f;
        this.aBl = this.aBk;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.aBr = new C0054a();
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWillNotDraw(false);
        scrollTo(0, 0);
        this.mGestureDetector = new GestureDetector(getContext(), new com.baidu.tbadk.widget.c(this));
    }

    private void EW() {
        int i = 0;
        int scrollX = getScrollX();
        if (this.aBf >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.aBf) {
                scrollX = (int) (this.aBf - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.aBg + this.mTop + this.mBottom >= getHeight()) {
            i = scrollY < (-this.aBy) ? -this.aBy : scrollY;
            if (getHeight() + i > this.aBg + this.mBottom + this.aBz) {
                i = (int) ((this.aBg - getHeight()) + this.mBottom + this.aBz);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.aBf;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.aBg;
    }

    public boolean onRightSide() {
        if (this.abO == 1 || this.abO == 2) {
            return true;
        }
        return !this.aBu && getScrollX() >= ((int) (this.aBf - ((float) getWidth()))) + (-1);
    }

    public boolean onLeftSide() {
        if (this.abO == 1 || this.abO == 2) {
            return true;
        }
        return !this.aBu && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.aBr.Fb()) {
            this.aBr.Fc();
        }
        this.aBA = 0;
        super.setImageBitmap(bitmap);
        reInitBitmap();
        this.abO = 0;
    }

    public void replaceImageBitmap(Bitmap bitmap) {
        Bitmap imageBitmap = getImageBitmap();
        if (bitmap != null && !bitmap.isRecycled()) {
            if (imageBitmap != null && (imageBitmap.getWidth() != bitmap.getWidth() || imageBitmap.getHeight() != bitmap.getHeight())) {
                setImageBitmap(bitmap);
                return;
            }
            if (this.aBr.Fb()) {
                this.aBr.Fc();
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            super.setImageBitmap(bitmap);
            super.setImageMatrix(this.mMatrix);
            scrollTo(scrollX, scrollY);
            this.abO = 0;
        }
    }

    public void a(byte[] bArr, Bitmap bitmap) {
        if (this.aBr.Fb()) {
            this.aBr.Fc();
        }
        super.setImageDrawable(null);
        stop();
        reInitBitmap();
        this.abO = 1;
        this.aBx = bitmap;
        this.mImageData = bArr;
        if (this.ald != null) {
            this.ald.a(this);
        }
    }

    public void onDestroy() {
        if (this.aBr.Fb()) {
            this.aBr.Fc();
        }
        super.setImageDrawable(null);
        this.mImageData = null;
        this.aBx = null;
        stop();
        if (this.aBw != null) {
            this.aBw.close();
            this.aBw = null;
        }
    }

    public void release() {
        if (this.aBr.Fb()) {
            this.aBr.Fc();
        }
        stop();
        super.setImageDrawable(null);
        this.aBx = null;
    }

    public void setDefaultBitmap() {
        if (this.aBr.Fb()) {
            this.aBr.Fc();
        }
        if (this.aBC) {
            super.setImageBitmap(com.baidu.tbadk.core.util.c.cd(i.e.icon_default_avatar100));
        } else {
            super.setImageBitmap(com.baidu.tbadk.core.util.c.cd(i.e.btn_see_default));
        }
        this.abO = 2;
        reInitBitmap();
    }

    public void zoomInBitmap() {
        if (this.abO != 1 && this.abO != 2) {
            int size = this.aBh.size();
            if (size > 0) {
                this.aBh.add(Float.valueOf(this.aBh.get(size - 1).floatValue() * 1.25f));
            } else {
                this.aBh.add(Float.valueOf(this.aBi));
            }
            EX();
            EV();
        }
    }

    public void zoomOutBitmap() {
        if (this.abO != 1 && this.abO != 2) {
            int size = this.aBh.size();
            if (size > 1) {
                this.aBh.remove(size - 1);
            }
            EX();
            EV();
        }
    }

    public void restoreSize() {
        EV();
        if (this.abO != 1 && this.abO != 2 && this.aBk != this.aBi) {
            this.aBh.clear();
            this.aBh.add(Float.valueOf(this.aBi));
            this.aBk = this.aBi;
            this.aBl = this.aBk;
            EX();
        }
    }

    public boolean canZoomIn() {
        if (this.abO == 1 || this.abO == 2) {
            return false;
        }
        int size = this.aBh.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.aBh.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.aBn) && floatValue <= 5.0f;
    }

    public boolean canZoomOut() {
        if (this.abO == 1 || this.abO == 2) {
            return false;
        }
        int size = this.aBh.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled()) {
            return false;
        }
        return size > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EX() {
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
                    int size = this.aBh.size();
                    if (size > 0) {
                        f2 = this.aBh.get(size - 1).floatValue();
                    } else {
                        f2 = this.aBi;
                    }
                    this.aBk = f2;
                }
                this.mMatrix.setScale(this.aBk, this.aBk);
                this.aBf = imageBitmap.getWidth() * this.aBk;
                this.aBg = imageBitmap.getHeight() * this.aBk;
                float width = this.aBl * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.aBl;
                this.aBy = this.mTop;
                this.aBz = 0;
                float f3 = this.aBf < ((float) this.mViewWidth) ? (int) ((this.mViewWidth - this.aBf) / 2.0f) : 0.0f;
                if (this.aBg < this.mViewHeight) {
                    f = (int) ((this.mViewHeight - this.aBg) / 2.0f);
                    if (this.aBo == 1 && f > this.mTop) {
                        f = this.mTop;
                    }
                    this.aBy = (int) (this.mTop - f);
                    this.aBz = this.mTop - this.aBy;
                } else {
                    f = 0.0f;
                }
                this.mMatrix.postTranslate(f3, f);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    scrollX = i > getWidth() ? getWidth() : i;
                    if (this.aBf <= screenWidth) {
                        scrollX = 0;
                    } else if (this.aBf > screenWidth && this.aBf / 2.0f < screenWidth) {
                        scrollX = (int) (scrollX - (this.aBf / 4.0f));
                    }
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.aBf - width) / 2.0f);
                    }
                    if (this.aBf <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.aBf) {
                        scrollX = (int) (this.aBf - getWidth());
                    }
                }
                if (scrollX > 0 && this.aBf - scrollX < getWidth()) {
                    scrollX = (int) (this.aBf - getWidth());
                }
                if (this.mMode == 2) {
                    scrollY += (int) ((this.aBg - height) / 2.0f);
                }
                if (this.aBg <= getHeight()) {
                    scrollY = 0;
                } else if (getHeight() + scrollY > this.aBg) {
                    scrollY = (int) (this.aBg - getHeight());
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
    public class C0054a extends Animation {
        private int HY;
        private boolean aBO = false;
        private boolean aBP = false;
        private long aBQ;
        private long aBR;
        private int aBS;
        private long aBT;
        private long aBU;

        public C0054a() {
        }

        public void d(float f, float f2) {
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
            this.aBQ = f;
            this.aBR = f2;
            this.aBT = Math.abs((f * 1000.0f) / 2500.0f);
            this.aBU = Math.abs((f2 * 1000.0f) / 2500.0f);
            setDuration(Math.max(this.aBT, this.aBU));
            setInterpolator(a.this.aBE);
            this.aBS = a.this.getScrollX();
            this.HY = a.this.getScrollY();
            this.aBO = true;
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
            if (this.aBT > this.aBU) {
                j = ((float) this.aBT) * f;
            } else {
                j = ((float) this.aBU) * f;
            }
            float f2 = ((float) (j > this.aBT ? this.aBT : j)) / 1000.0f;
            if (this.aBQ > 0) {
                i = this.aBS - ((int) (f2 * (((float) this.aBQ) - ((2500.0f * f2) / 2.0f))));
            } else {
                i = this.aBS - ((int) (f2 * (((float) this.aBQ) + ((2500.0f * f2) / 2.0f))));
            }
            if (j > this.aBU) {
                j = this.aBU;
            }
            float f3 = ((float) j) / 1000.0f;
            if (this.aBR > 0) {
                i2 = this.HY - ((int) (f3 * (((float) this.aBR) - ((2500.0f * f3) / 2.0f))));
            } else {
                i2 = this.HY - ((int) (f3 * (((float) this.aBR) + ((2500.0f * f3) / 2.0f))));
            }
            if (a.this.aBg + a.this.mTop + a.this.mBottom > a.this.getHeight()) {
                if (i2 < (-a.this.aBy)) {
                    i2 = -a.this.aBy;
                }
                if (a.this.getHeight() + i2 > a.this.aBg + a.this.mBottom + a.this.aBz) {
                    i2 = (int) ((a.this.aBg - a.this.getHeight()) + a.this.mBottom + a.this.aBz);
                }
            } else {
                i2 = 0;
            }
            if (a.this.aBf > a.this.getWidth()) {
                int width = ((float) (a.this.getWidth() + i)) > a.this.aBf ? (int) (a.this.aBf - a.this.getWidth()) : i;
                if (width >= 0) {
                    i3 = width;
                }
            }
            a.this.scrollTo(i3, i2);
            a.this.invalidate();
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            if (!this.aBP) {
                if (a.this.aBm) {
                    this.aBO = false;
                    return false;
                }
                try {
                    if (!super.getTransformation(j, transformation)) {
                        this.aBO = false;
                        return false;
                    }
                    return true;
                } catch (Exception e) {
                    this.aBO = false;
                    return false;
                }
            }
            this.aBP = false;
            this.aBO = false;
            return false;
        }

        public boolean Fb() {
            return this.aBO;
        }

        public void Fc() {
            this.aBP = true;
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.aBq = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.alb = onLongClickListener;
    }

    public void setGifSetListener(d dVar) {
        this.ald = dVar;
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
    public void EY() {
        long j;
        c poll = this.aBH.poll();
        if (poll == null) {
            this.aBM = true;
            return;
        }
        this.aBM = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.aBG != null) {
            j = this.aBG.delay - (currentTimeMillis - this.aBL);
            this.aBI.offer(this.aBG);
        } else {
            j = 0;
        }
        this.aBG = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public c EZ() {
        c poll = this.aBI.poll();
        if (poll == null) {
            poll = new c(null);
            try {
                poll.aBV = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
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
        public Bitmap aBV;
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
            while (a.this.mState == 1 && a.this.aBw != null && a.this.aBF > 0 && a.this.width > 0 && a.this.height > 0) {
                try {
                    a.this.aBw.F(a.this.aBJ);
                    c EZ = a.this.EZ();
                    if (EZ.aBV == null || (EZ.aBV.getWidth() != a.this.width && EZ.aBV.getHeight() != a.this.height)) {
                        try {
                            EZ.aBV = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_8888);
                        } catch (OutOfMemoryError e) {
                            TbadkCoreApplication.m411getInst().onAppMemoryLow();
                            try {
                                EZ.aBV = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_4444);
                            } catch (OutOfMemoryError e2) {
                                TbadkCoreApplication.m411getInst().onAppMemoryLow();
                            } catch (Throwable th) {
                                BdLog.e(th.getMessage());
                            }
                        } catch (Throwable th2) {
                            BdLog.e(th2.getMessage());
                        }
                    }
                    a.this.aBw.a(EZ.aBV, null);
                    EZ.delay = a.this.aBw.G(a.this.aBJ);
                    a.this.aBJ++;
                    if (EZ.aBV == null) {
                        a.this.aBJ++;
                    }
                    a.this.aBJ %= a.this.aBF;
                    a.this.aBH.put(EZ);
                    if (a.this.aBM) {
                        a.this.mHandler.sendEmptyMessage(1);
                    }
                } catch (Exception e3) {
                    return;
                }
            }
        }
    }

    public boolean Fa() {
        return this.aBB;
    }

    public void setLoadBigImage(boolean z) {
        this.aBB = z;
    }
}
