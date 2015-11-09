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
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends ImageView {
    private int abV;
    private View.OnLongClickListener ajZ;
    private d akb;
    private int akc;
    private float ayI;
    private float ayJ;
    private ArrayList<Float> ayK;
    private float ayL;
    private float ayM;
    private float ayN;
    private float ayO;
    private boolean ayP;
    private int ayQ;
    private int ayR;
    private e ayS;
    private View.OnClickListener ayT;
    private C0054a ayU;
    private float ayV;
    private boolean ayW;
    private boolean ayX;
    private int ayY;
    private volatile com.baidu.adp.gif.b ayZ;
    private Bitmap aza;
    private int azb;
    private int azc;
    private int azd;
    private boolean aze;
    private boolean azf;
    private float azg;
    private Interpolator azh;
    private int azi;
    private c azj;
    private BlockingLinkedDeque<c> azk;
    private BlockingLinkedDeque<c> azl;
    private volatile int azm;
    private b azn;
    private volatile long azo;
    private volatile boolean azp;
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
        this.azf = z;
    }

    public a(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.ayP = false;
        this.mImageData = null;
        this.akc = 0;
        this.ayQ = 1300;
        this.ayR = 0;
        this.ayS = null;
        this.ayT = null;
        this.ajZ = null;
        this.akb = null;
        this.ayV = 1.0f;
        this.abV = 0;
        this.mMode = 0;
        this.ayW = false;
        this.ayX = false;
        this.ayY = 0;
        this.ayZ = null;
        this.aza = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.azb = 0;
        this.azc = 0;
        this.azd = 0;
        this.azh = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.azi = 0;
        this.azj = null;
        this.azk = new BlockingLinkedDeque<>(5);
        this.azl = new BlockingLinkedDeque<>(6);
        this.azm = 0;
        this.azo = 0L;
        this.mState = 0;
        this.azp = true;
        this.mHandler = new Handler(new com.baidu.tbadk.widget.b(this));
        initData();
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.ayP = false;
        this.mImageData = null;
        this.akc = 0;
        this.ayQ = 1300;
        this.ayR = 0;
        this.ayS = null;
        this.ayT = null;
        this.ajZ = null;
        this.akb = null;
        this.ayV = 1.0f;
        this.abV = 0;
        this.mMode = 0;
        this.ayW = false;
        this.ayX = false;
        this.ayY = 0;
        this.ayZ = null;
        this.aza = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.azb = 0;
        this.azc = 0;
        this.azd = 0;
        this.azh = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.azi = 0;
        this.azj = null;
        this.azk = new BlockingLinkedDeque<>(5);
        this.azl = new BlockingLinkedDeque<>(6);
        this.azm = 0;
        this.azo = 0L;
        this.mState = 0;
        this.azp = true;
        this.mHandler = new Handler(new com.baidu.tbadk.widget.b(this));
        initData();
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.ayP = false;
        this.mImageData = null;
        this.akc = 0;
        this.ayQ = 1300;
        this.ayR = 0;
        this.ayS = null;
        this.ayT = null;
        this.ajZ = null;
        this.akb = null;
        this.ayV = 1.0f;
        this.abV = 0;
        this.mMode = 0;
        this.ayW = false;
        this.ayX = false;
        this.ayY = 0;
        this.ayZ = null;
        this.aza = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.azb = 0;
        this.azc = 0;
        this.azd = 0;
        this.azh = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.azi = 0;
        this.azj = null;
        this.azk = new BlockingLinkedDeque<>(5);
        this.azl = new BlockingLinkedDeque<>(6);
        this.azm = 0;
        this.azo = 0L;
        this.mState = 0;
        this.azp = true;
        this.mHandler = new Handler(new com.baidu.tbadk.widget.b(this));
        initData();
    }

    public int getImageType() {
        return this.abV;
    }

    public void setImageMode(int i) {
        this.ayR = i;
    }

    public void setOffset(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.akc = i;
    }

    public void actionUp() {
        this.ayX = false;
        this.ayP = false;
        this.mMode = 0;
        EA();
        if (this.ayN < this.ayL) {
            this.ayN = this.ayL;
            EB();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.ayP = true;
                this.ayW = false;
                this.ayX = false;
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
            this.ayV = spacing(motionEvent);
            if (this.ayV > 10.0f) {
                this.mMode = 2;
            }
        }
        if (this.mMode == 2 || !this.mGestureDetector.onTouchEvent(motionEvent)) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.ayW = true;
                        this.ayX = true;
                        if (this.abV != 1 && this.abV != 2) {
                            float spacing = spacing(motionEvent);
                            if (spacing >= 0.0f && Math.abs(this.ayV - spacing) >= 10.0f) {
                                if (Math.abs(this.ayV - spacing) > 100.0f) {
                                    this.ayV = spacing;
                                    break;
                                } else {
                                    float f = spacing / this.ayV;
                                    this.ayV = spacing;
                                    this.ayO = this.ayN;
                                    this.ayN *= f;
                                    if (this.ayN > this.ayM) {
                                        this.ayN = this.ayM;
                                    }
                                    if (this.ayN < this.ayL / 4.0f) {
                                        this.ayN = this.ayL / 4.0f;
                                    }
                                    EB();
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
        return this.ayL == this.ayN;
    }

    private void reInitBitmap() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            if (this.ayR == 0) {
                float width = this.mViewWidth / imageBitmap.getWidth();
                float height = this.mViewHeight / imageBitmap.getHeight();
                if (this.azf) {
                    if (this.abV == 2) {
                        this.ayL = 2.5f;
                    } else {
                        this.ayL = Math.min(width, height);
                    }
                } else if (this.abV == 2) {
                    this.ayL = 1.0f;
                } else {
                    float f = this.azg;
                    float f2 = f >= 1.0f ? f : 1.0f;
                    if (imageBitmap.getWidth() * f2 < this.mViewWidth && imageBitmap.getHeight() * f2 < this.mViewHeight) {
                        this.ayL = f2;
                    } else {
                        this.ayL = Math.min(width, height);
                    }
                }
            } else {
                this.ayL = Math.max(this.mViewWidth / imageBitmap.getWidth(), ((this.mViewHeight - this.mTop) - this.mBottom) / imageBitmap.getHeight());
            }
            this.ayM = this.ayQ / (imageBitmap.getWidth() * imageBitmap.getHeight());
            this.ayM = FloatMath.sqrt(this.ayM);
            if (this.ayM > 10.0f) {
                this.ayM = 10.0f;
            }
            this.ayK.clear();
            this.ayK.add(Float.valueOf(this.ayL));
            this.ayN = this.ayL;
            this.ayO = this.ayN;
            EB();
            Ez();
            return;
        }
        this.ayI = 0.0f;
        this.ayJ = 0.0f;
        this.ayL = 1.0f;
        this.ayM = 1.0f;
        this.ayN = 1.0f;
        this.ayO = this.ayN;
        this.ayK.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ez() {
        if (this.ayS != null) {
            this.ayS.a(this, canZoomIn(), canZoomOut());
        }
    }

    public void setOnSizeChangedListener(e eVar) {
        this.ayS = eVar;
    }

    public byte[] getImageData() {
        return this.mImageData;
    }

    public void setImageData(byte[] bArr) {
        this.mImageData = bArr;
    }

    public Bitmap getGifCache() {
        return this.aza;
    }

    public void setGifCache(Bitmap bitmap) {
        this.aza = bitmap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        boolean z;
        int i4;
        if (this.abV == 2 && this.azd != 0 && !this.ayU.EF()) {
            int width = getWidth();
            int height = getHeight();
            Drawable drawable = getDrawable();
            float f = 0.0f;
            float f2 = height * 0.3f;
            float f3 = width;
            float f4 = (1.0f - 0.3f) * height;
            if (this.azf && drawable != null) {
                Rect bounds = drawable.getBounds();
                int i5 = bounds.right - bounds.left;
                int i6 = bounds.bottom - bounds.top;
                f = (width / 2) - (i5 * 2.5f);
                f2 = (height / 2) - (i6 * 2.5f);
                f3 = (i5 * 2.5f) + (width / 2);
                f4 = (i6 * 2.5f) + (height / 2);
            }
            this.mPaint.setColor(an.getColor(this.azd));
            canvas.drawRect(f, f2, f3, f4, this.mPaint);
            this.mPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        }
        super.onDraw(canvas);
        if (this.abV == 1 && this.aza != null && !this.aza.isRecycled()) {
            int width2 = this.aza.getWidth();
            int height2 = this.aza.getHeight();
            int width3 = getWidth();
            int height3 = getHeight();
            int i7 = (width3 - width2) >> 1;
            int i8 = (height3 - height2) >> 1;
            float f5 = this.azg;
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
            if (this.ayY == 1 && this.ayZ != null && this.azj != null && this.azj.azy != null) {
                if (z) {
                    canvas.drawBitmap(this.azj.azy, i3, i2, (Paint) null);
                } else {
                    canvas.drawBitmap(this.azj.azy, this.mMatrix, this.mPaint);
                }
                invalidate();
            } else if (z) {
                canvas.drawBitmap(this.aza, i3, i2, (Paint) null);
            } else {
                canvas.drawBitmap(this.aza, this.mMatrix, this.mPaint);
            }
        }
    }

    public void play() {
        com.baidu.adp.widget.a.a e2;
        if (this.abV == 1) {
            if (this.ayZ == null) {
                if (this.azn != null) {
                    this.azn.interrupt();
                    this.azn = null;
                }
                if (this.mImageData != null && (e2 = a.C0002a.fe().e(this.mImageData, 0, this.mImageData.length)) != null && e2.getGif() != null) {
                    this.ayZ = e2.getGif();
                    if (this.ayZ != null) {
                        this.ayY = 1;
                        this.width = this.ayZ.getWidth();
                        this.height = this.ayZ.getHeight();
                        this.azm = 0;
                        this.azi = this.ayZ.ff();
                    } else {
                        this.ayY = 0;
                    }
                } else {
                    return;
                }
            }
            if (this.ayZ != null && this.mState == 0) {
                this.azp = true;
                this.azn = new b(this, null);
                this.azk.clear();
                this.azl.clear();
                this.mState = 1;
                this.azn.start();
            }
        }
    }

    public void pause() {
        if (this.abV == 1) {
            this.mState = 0;
            if (this.azn != null) {
                this.azn.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.abV == 1) {
            this.mState = 0;
            if (this.azn != null) {
                this.azn.interrupt();
                this.azn = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.azp = true;
            this.azj = null;
            this.azl.clear();
            this.azk.clear();
            this.width = 0;
            this.height = 0;
            this.azm = 0;
            this.azi = 0;
            if (this.ayZ != null) {
                this.ayZ = null;
            }
        }
    }

    private void initData() {
        this.azg = k.M(getContext());
        this.ayQ = k.L(getContext()) * k.K(getContext()) * 2;
        if (this.ayQ < 1690000) {
            this.ayQ = 1690000;
        }
        this.ayI = 0.0f;
        this.ayJ = 0.0f;
        this.ayK = new ArrayList<>();
        this.ayL = 1.0f;
        this.ayM = 1.0f;
        this.ayN = 1.0f;
        this.ayO = this.ayN;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.ayU = new C0054a();
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWillNotDraw(false);
        scrollTo(0, 0);
        this.mGestureDetector = new GestureDetector(getContext(), new com.baidu.tbadk.widget.c(this));
    }

    private void EA() {
        int i = 0;
        int scrollX = getScrollX();
        if (this.ayI >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.ayI) {
                scrollX = (int) (this.ayI - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.ayJ + this.mTop + this.mBottom >= getHeight()) {
            i = scrollY < (-this.azb) ? -this.azb : scrollY;
            if (getHeight() + i > this.ayJ + this.mBottom + this.azc) {
                i = (int) ((this.ayJ - getHeight()) + this.mBottom + this.azc);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.ayI;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.ayJ;
    }

    public boolean onRightSide() {
        if (this.abV == 1 || this.abV == 2) {
            return true;
        }
        return !this.ayX && getScrollX() >= ((int) (this.ayI - ((float) getWidth()))) + (-1);
    }

    public boolean onLeftSide() {
        if (this.abV == 1 || this.abV == 2) {
            return true;
        }
        return !this.ayX && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.ayU.EF()) {
            this.ayU.stopAnimation();
        }
        this.azd = 0;
        super.setImageBitmap(bitmap);
        reInitBitmap();
        this.abV = 0;
    }

    public void replaceImageBitmap(Bitmap bitmap) {
        Bitmap imageBitmap = getImageBitmap();
        if (bitmap != null && !bitmap.isRecycled()) {
            if (imageBitmap != null && (imageBitmap.getWidth() != bitmap.getWidth() || imageBitmap.getHeight() != bitmap.getHeight())) {
                setImageBitmap(bitmap);
                return;
            }
            if (this.ayU.EF()) {
                this.ayU.stopAnimation();
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            super.setImageBitmap(bitmap);
            super.setImageMatrix(this.mMatrix);
            scrollTo(scrollX, scrollY);
            this.abV = 0;
        }
    }

    public void a(byte[] bArr, Bitmap bitmap) {
        if (this.ayU.EF()) {
            this.ayU.stopAnimation();
        }
        super.setImageDrawable(null);
        stop();
        reInitBitmap();
        this.abV = 1;
        this.aza = bitmap;
        this.mImageData = bArr;
        if (this.akb != null) {
            this.akb.a(this);
        }
    }

    public void onDestroy() {
        if (this.ayU.EF()) {
            this.ayU.stopAnimation();
        }
        super.setImageDrawable(null);
        this.mImageData = null;
        this.aza = null;
        stop();
        if (this.ayZ != null) {
            this.ayZ.close();
            this.ayZ = null;
        }
    }

    public void release() {
        if (this.ayU.EF()) {
            this.ayU.stopAnimation();
        }
        stop();
        super.setImageDrawable(null);
        this.aza = null;
    }

    public void setDefaultBitmap() {
        if (this.ayU.EF()) {
            this.ayU.stopAnimation();
        }
        if (this.azf) {
            super.setImageBitmap(com.baidu.tbadk.core.util.c.cf(i.e.icon_default_avatar100));
        } else {
            super.setImageBitmap(com.baidu.tbadk.core.util.c.cf(i.e.btn_see_default));
        }
        this.abV = 2;
        reInitBitmap();
    }

    public void zoomInBitmap() {
        if (this.abV != 1 && this.abV != 2) {
            int size = this.ayK.size();
            if (size > 0) {
                this.ayK.add(Float.valueOf(this.ayK.get(size - 1).floatValue() * 1.25f));
            } else {
                this.ayK.add(Float.valueOf(this.ayL));
            }
            EB();
            Ez();
        }
    }

    public void zoomOutBitmap() {
        if (this.abV != 1 && this.abV != 2) {
            int size = this.ayK.size();
            if (size > 1) {
                this.ayK.remove(size - 1);
            }
            EB();
            Ez();
        }
    }

    public void restoreSize() {
        Ez();
        if (this.abV != 1 && this.abV != 2 && this.ayN != this.ayL) {
            this.ayK.clear();
            this.ayK.add(Float.valueOf(this.ayL));
            this.ayN = this.ayL;
            this.ayO = this.ayN;
            EB();
        }
    }

    public boolean canZoomIn() {
        if (this.abV == 1 || this.abV == 2) {
            return false;
        }
        int size = this.ayK.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.ayK.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.ayQ) && floatValue <= 5.0f;
    }

    public boolean canZoomOut() {
        if (this.abV == 1 || this.abV == 2) {
            return false;
        }
        int size = this.ayK.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled()) {
            return false;
        }
        return size > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EB() {
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
                    int size = this.ayK.size();
                    if (size > 0) {
                        f2 = this.ayK.get(size - 1).floatValue();
                    } else {
                        f2 = this.ayL;
                    }
                    this.ayN = f2;
                }
                this.mMatrix.setScale(this.ayN, this.ayN);
                this.ayI = imageBitmap.getWidth() * this.ayN;
                this.ayJ = imageBitmap.getHeight() * this.ayN;
                float width = this.ayO * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.ayO;
                this.azb = this.mTop;
                this.azc = 0;
                float f3 = this.ayI < ((float) this.mViewWidth) ? (int) ((this.mViewWidth - this.ayI) / 2.0f) : 0.0f;
                if (this.ayJ < this.mViewHeight) {
                    f = (int) ((this.mViewHeight - this.ayJ) / 2.0f);
                    if (this.ayR == 1 && f > this.mTop) {
                        f = this.mTop;
                    }
                    this.azb = (int) (this.mTop - f);
                    this.azc = this.mTop - this.azb;
                } else {
                    f = 0.0f;
                }
                this.mMatrix.postTranslate(f3, f);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    scrollX = i > getWidth() ? getWidth() : i;
                    if (this.ayI <= screenWidth) {
                        scrollX = 0;
                    } else if (this.ayI > screenWidth && this.ayI / 2.0f < screenWidth) {
                        scrollX = (int) (scrollX - (this.ayI / 4.0f));
                    }
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.ayI - width) / 2.0f);
                    }
                    if (this.ayI <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.ayI) {
                        scrollX = (int) (this.ayI - getWidth());
                    }
                }
                if (scrollX > 0 && this.ayI - scrollX < getWidth()) {
                    scrollX = (int) (this.ayI - getWidth());
                }
                if (this.mMode == 2) {
                    scrollY += (int) ((this.ayJ - height) / 2.0f);
                }
                if (this.ayJ <= getHeight()) {
                    scrollY = 0;
                } else if (getHeight() + scrollY > this.ayJ) {
                    scrollY = (int) (this.ayJ - getHeight());
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
        private int Ia;
        private boolean azr = false;
        private boolean azs = false;
        private long azt;
        private long azu;
        private int azv;
        private long azw;
        private long azx;

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
            this.azt = f;
            this.azu = f2;
            this.azw = Math.abs((f * 1000.0f) / 2500.0f);
            this.azx = Math.abs((f2 * 1000.0f) / 2500.0f);
            setDuration(Math.max(this.azw, this.azx));
            setInterpolator(a.this.azh);
            this.azv = a.this.getScrollX();
            this.Ia = a.this.getScrollY();
            this.azr = true;
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
            if (this.azw > this.azx) {
                j = ((float) this.azw) * f;
            } else {
                j = ((float) this.azx) * f;
            }
            float f2 = ((float) (j > this.azw ? this.azw : j)) / 1000.0f;
            if (this.azt > 0) {
                i = this.azv - ((int) (f2 * (((float) this.azt) - ((2500.0f * f2) / 2.0f))));
            } else {
                i = this.azv - ((int) (f2 * (((float) this.azt) + ((2500.0f * f2) / 2.0f))));
            }
            if (j > this.azx) {
                j = this.azx;
            }
            float f3 = ((float) j) / 1000.0f;
            if (this.azu > 0) {
                i2 = this.Ia - ((int) (f3 * (((float) this.azu) - ((2500.0f * f3) / 2.0f))));
            } else {
                i2 = this.Ia - ((int) (f3 * (((float) this.azu) + ((2500.0f * f3) / 2.0f))));
            }
            if (a.this.ayJ + a.this.mTop + a.this.mBottom > a.this.getHeight()) {
                if (i2 < (-a.this.azb)) {
                    i2 = -a.this.azb;
                }
                if (a.this.getHeight() + i2 > a.this.ayJ + a.this.mBottom + a.this.azc) {
                    i2 = (int) ((a.this.ayJ - a.this.getHeight()) + a.this.mBottom + a.this.azc);
                }
            } else {
                i2 = 0;
            }
            if (a.this.ayI > a.this.getWidth()) {
                int width = ((float) (a.this.getWidth() + i)) > a.this.ayI ? (int) (a.this.ayI - a.this.getWidth()) : i;
                if (width >= 0) {
                    i3 = width;
                }
            }
            a.this.scrollTo(i3, i2);
            a.this.invalidate();
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            if (!this.azs) {
                if (a.this.ayP) {
                    this.azr = false;
                    return false;
                }
                try {
                    if (!super.getTransformation(j, transformation)) {
                        this.azr = false;
                        return false;
                    }
                    return true;
                } catch (Exception e) {
                    this.azr = false;
                    return false;
                }
            }
            this.azs = false;
            this.azr = false;
            return false;
        }

        public boolean EF() {
            return this.azr;
        }

        public void stopAnimation() {
            this.azs = true;
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.ayT = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.ajZ = onLongClickListener;
    }

    public void setGifSetListener(d dVar) {
        this.akb = dVar;
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
    public void EC() {
        long j;
        c poll = this.azk.poll();
        if (poll == null) {
            this.azp = true;
            return;
        }
        this.azp = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.azj != null) {
            j = this.azj.delay - (currentTimeMillis - this.azo);
            this.azl.offer(this.azj);
        } else {
            j = 0;
        }
        this.azj = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public c ED() {
        c poll = this.azl.poll();
        if (poll == null) {
            poll = new c(null);
            try {
                poll.azy = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
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
        public Bitmap azy;
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
            while (a.this.mState == 1 && a.this.ayZ != null && a.this.azi > 0 && a.this.width > 0 && a.this.height > 0) {
                try {
                    a.this.ayZ.F(a.this.azm);
                    c ED = a.this.ED();
                    if (ED.azy == null || (ED.azy.getWidth() != a.this.width && ED.azy.getHeight() != a.this.height)) {
                        try {
                            ED.azy = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_8888);
                        } catch (OutOfMemoryError e) {
                            TbadkCoreApplication.m411getInst().onAppMemoryLow();
                            try {
                                ED.azy = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_4444);
                            } catch (OutOfMemoryError e2) {
                                TbadkCoreApplication.m411getInst().onAppMemoryLow();
                            } catch (Throwable th) {
                                BdLog.e(th.getMessage());
                            }
                        } catch (Throwable th2) {
                            BdLog.e(th2.getMessage());
                        }
                    }
                    a.this.ayZ.a(ED.azy, null);
                    ED.delay = a.this.ayZ.G(a.this.azm);
                    a.this.azm++;
                    if (ED.azy == null) {
                        a.this.azm++;
                    }
                    a.this.azm %= a.this.azi;
                    a.this.azk.put(ED);
                    if (a.this.azp) {
                        a.this.mHandler.sendEmptyMessage(1);
                    }
                } catch (Exception e3) {
                    return;
                }
            }
        }
    }

    public boolean EE() {
        return this.aze;
    }

    public void setLoadBigImage(boolean z) {
        this.aze = z;
    }
}
