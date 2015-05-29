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
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BlockingLinkedDeque;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.compatible.CompatibleUtile;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends ImageView {
    private int WG;
    private View.OnLongClickListener afC;
    private g afE;
    private int afF;
    private View.OnClickListener asA;
    private d asB;
    private float asC;
    private boolean asD;
    private boolean asE;
    private int asF;
    private volatile com.baidu.adp.gif.c asG;
    private Bitmap asH;
    private int asI;
    private int asJ;
    private int asK;
    private boolean asL;
    private boolean asM;
    private float asN;
    private Interpolator asO;
    private int asP;
    private f asQ;
    private BlockingLinkedDeque<f> asR;
    private BlockingLinkedDeque<f> asS;
    private volatile int asT;
    private e asU;
    private volatile long asV;
    private volatile boolean asW;
    private float asr;
    private float ass;
    private ArrayList<Float> ast;
    private float asu;
    private float asv;
    private boolean asw;
    private int asx;
    private int asy;
    private h asz;
    private int height;
    private int mBottom;
    private float mCurrentScale;
    private GestureDetector mGestureDetector;
    public Handler mHandler;
    private byte[] mImageData;
    private Matrix mMatrix;
    private float mMaxScale;
    private int mMode;
    private Paint mPaint;
    private volatile int mState;
    private int mTop;
    private int mViewHeight;
    private int mViewWidth;
    private int width;

    public void setIsHeadImage(boolean z) {
        this.asM = z;
    }

    public a(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.asw = false;
        this.mImageData = null;
        this.afF = 0;
        this.asx = 1300;
        this.asy = 0;
        this.asz = null;
        this.asA = null;
        this.afC = null;
        this.afE = null;
        this.asC = 1.0f;
        this.WG = 0;
        this.mMode = 0;
        this.asD = false;
        this.asE = false;
        this.asF = 0;
        this.asG = null;
        this.asH = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.asI = 0;
        this.asJ = 0;
        this.asK = 0;
        this.asO = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.asP = 0;
        this.asQ = null;
        this.asR = new BlockingLinkedDeque<>(5);
        this.asS = new BlockingLinkedDeque<>(6);
        this.asT = 0;
        this.asV = 0L;
        this.mState = 0;
        this.asW = true;
        this.mHandler = new Handler(new b(this));
        initData();
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.asw = false;
        this.mImageData = null;
        this.afF = 0;
        this.asx = 1300;
        this.asy = 0;
        this.asz = null;
        this.asA = null;
        this.afC = null;
        this.afE = null;
        this.asC = 1.0f;
        this.WG = 0;
        this.mMode = 0;
        this.asD = false;
        this.asE = false;
        this.asF = 0;
        this.asG = null;
        this.asH = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.asI = 0;
        this.asJ = 0;
        this.asK = 0;
        this.asO = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.asP = 0;
        this.asQ = null;
        this.asR = new BlockingLinkedDeque<>(5);
        this.asS = new BlockingLinkedDeque<>(6);
        this.asT = 0;
        this.asV = 0L;
        this.mState = 0;
        this.asW = true;
        this.mHandler = new Handler(new b(this));
        initData();
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.asw = false;
        this.mImageData = null;
        this.afF = 0;
        this.asx = 1300;
        this.asy = 0;
        this.asz = null;
        this.asA = null;
        this.afC = null;
        this.afE = null;
        this.asC = 1.0f;
        this.WG = 0;
        this.mMode = 0;
        this.asD = false;
        this.asE = false;
        this.asF = 0;
        this.asG = null;
        this.asH = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.asI = 0;
        this.asJ = 0;
        this.asK = 0;
        this.asO = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.asP = 0;
        this.asQ = null;
        this.asR = new BlockingLinkedDeque<>(5);
        this.asS = new BlockingLinkedDeque<>(6);
        this.asT = 0;
        this.asV = 0L;
        this.mState = 0;
        this.asW = true;
        this.mHandler = new Handler(new b(this));
        initData();
    }

    public int getImageType() {
        return this.WG;
    }

    public void setImageMode(int i) {
        this.asy = i;
    }

    public void setOffset(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.afF = i;
    }

    public void actionUp() {
        this.asE = false;
        this.asw = false;
        this.mMode = 0;
        Ec();
        if (this.mCurrentScale < this.asu) {
            this.mCurrentScale = this.asu;
            Ed();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.asw = true;
                this.asD = false;
                this.asE = false;
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
            this.asC = spacing(motionEvent);
            if (this.asC > 10.0f) {
                this.mMode = 2;
            }
        }
        if (this.mMode == 2 || !this.mGestureDetector.onTouchEvent(motionEvent)) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.asD = true;
                        this.asE = true;
                        if (this.WG != 1 && this.WG != 2) {
                            float spacing = spacing(motionEvent);
                            if (spacing >= 0.0f && Math.abs(this.asC - spacing) >= 10.0f) {
                                if (Math.abs(this.asC - spacing) > 100.0f) {
                                    this.asC = spacing;
                                    break;
                                } else {
                                    float f = spacing / this.asC;
                                    this.asC = spacing;
                                    this.asv = this.mCurrentScale;
                                    this.mCurrentScale *= f;
                                    if (this.mCurrentScale > this.mMaxScale) {
                                        this.mCurrentScale = this.mMaxScale;
                                    }
                                    if (this.mCurrentScale < this.asu / 4.0f) {
                                        this.mCurrentScale = this.asu / 4.0f;
                                    }
                                    Ed();
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
        return this.asu == this.mCurrentScale;
    }

    private void reInitBitmap() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            if (this.asy == 0) {
                float width = this.mViewWidth / imageBitmap.getWidth();
                float height = this.mViewHeight / imageBitmap.getHeight();
                if (this.asM) {
                    if (this.WG == 2) {
                        this.asu = 2.5f;
                    } else {
                        this.asu = Math.min(width, height);
                    }
                } else if (this.WG == 2) {
                    this.asu = 1.0f;
                } else {
                    float f = this.asN;
                    float f2 = f >= 1.0f ? f : 1.0f;
                    if (imageBitmap.getWidth() * f2 < this.mViewWidth && imageBitmap.getHeight() * f2 < this.mViewHeight) {
                        this.asu = f2;
                    } else {
                        this.asu = Math.min(width, height);
                    }
                }
            } else {
                this.asu = Math.max(this.mViewWidth / imageBitmap.getWidth(), ((this.mViewHeight - this.mTop) - this.mBottom) / imageBitmap.getHeight());
            }
            this.mMaxScale = this.asx / (imageBitmap.getWidth() * imageBitmap.getHeight());
            this.mMaxScale = FloatMath.sqrt(this.mMaxScale);
            if (this.mMaxScale > 10.0f) {
                this.mMaxScale = 10.0f;
            }
            this.ast.clear();
            this.ast.add(Float.valueOf(this.asu));
            this.mCurrentScale = this.asu;
            this.asv = this.mCurrentScale;
            Ed();
            Eb();
            return;
        }
        this.asr = 0.0f;
        this.ass = 0.0f;
        this.asu = 1.0f;
        this.mMaxScale = 1.0f;
        this.mCurrentScale = 1.0f;
        this.asv = this.mCurrentScale;
        this.ast.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    public void Eb() {
        if (this.asz != null) {
            this.asz.a(this, canZoomIn(), canZoomOut());
        }
    }

    public void setOnSizeChangedListener(h hVar) {
        this.asz = hVar;
    }

    public byte[] getImageData() {
        return this.mImageData;
    }

    public void setImageData(byte[] bArr) {
        this.mImageData = bArr;
    }

    public Bitmap getGifCache() {
        return this.asH;
    }

    public void setGifCache(Bitmap bitmap) {
        this.asH = bitmap;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        boolean z;
        int i4;
        if (this.WG == 2 && this.asK != 0 && !this.asB.Eh()) {
            int width = getWidth();
            int height = getHeight();
            Drawable drawable = getDrawable();
            float f = 0.0f;
            float f2 = height * 0.3f;
            float f3 = width;
            float f4 = (1.0f - 0.3f) * height;
            if (this.asM && drawable != null) {
                Rect bounds = drawable.getBounds();
                int i5 = bounds.right - bounds.left;
                int i6 = bounds.bottom - bounds.top;
                f = (width / 2) - (i5 * 2.5f);
                f2 = (height / 2) - (i6 * 2.5f);
                f3 = (i5 * 2.5f) + (width / 2);
                f4 = (i6 * 2.5f) + (height / 2);
            }
            this.mPaint.setColor(ay.getColor(this.asK));
            canvas.drawRect(f, f2, f3, f4, this.mPaint);
            this.mPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        }
        super.onDraw(canvas);
        if (this.WG == 1 && this.asH != null && !this.asH.isRecycled()) {
            int width2 = this.asH.getWidth();
            int height2 = this.asH.getHeight();
            int width3 = getWidth();
            int height3 = getHeight();
            int i7 = (width3 - width2) >> 1;
            int i8 = (height3 - height2) >> 1;
            float f5 = this.asN;
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
            if (this.asF == 1 && this.asG != null && this.asQ != null && this.asQ.ate != null) {
                if (z) {
                    canvas.drawBitmap(this.asQ.ate, i3, i2, (Paint) null);
                } else {
                    canvas.drawBitmap(this.asQ.ate, this.mMatrix, this.mPaint);
                }
                invalidate();
            } else if (z) {
                canvas.drawBitmap(this.asH, i3, i2, (Paint) null);
            } else {
                canvas.drawBitmap(this.asH, this.mMatrix, this.mPaint);
            }
        }
    }

    public void play() {
        com.baidu.adp.widget.a.a d;
        if (this.WG == 1) {
            if (this.asG == null) {
                if (this.asU != null) {
                    this.asU.interrupt();
                    this.asU = null;
                }
                if (this.mImageData != null && (d = com.baidu.adp.gif.b.fk().d(this.mImageData, 0, this.mImageData.length)) != null && d.getGif() != null) {
                    this.asG = d.getGif();
                    if (this.asG != null) {
                        this.asF = 1;
                        this.width = this.asG.getWidth();
                        this.height = this.asG.getHeight();
                        this.asT = 0;
                        this.asP = this.asG.fl();
                    } else {
                        this.asF = 0;
                    }
                } else {
                    return;
                }
            }
            if (this.asG != null && this.mState == 0) {
                this.asW = true;
                this.asU = new e(this, null);
                this.asR.clear();
                this.asS.clear();
                this.mState = 1;
                this.asU.start();
            }
        }
    }

    public void pause() {
        if (this.WG == 1) {
            this.mState = 0;
            if (this.asU != null) {
                this.asU.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.WG == 1) {
            this.mState = 0;
            if (this.asU != null) {
                this.asU.interrupt();
                this.asU = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.asW = true;
            this.asQ = null;
            this.asS.clear();
            this.asR.clear();
            this.width = 0;
            this.height = 0;
            this.asT = 0;
            this.asP = 0;
            if (this.asG != null) {
                this.asG = null;
            }
        }
    }

    private void initData() {
        this.asN = com.baidu.adp.lib.util.n.O(getContext());
        this.asx = com.baidu.adp.lib.util.n.N(getContext()) * com.baidu.adp.lib.util.n.M(getContext()) * 2;
        if (this.asx < 1690000) {
            this.asx = 1690000;
        }
        this.asr = 0.0f;
        this.ass = 0.0f;
        this.ast = new ArrayList<>();
        this.asu = 1.0f;
        this.mMaxScale = 1.0f;
        this.mCurrentScale = 1.0f;
        this.asv = this.mCurrentScale;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.asB = new d(this);
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWillNotDraw(false);
        scrollTo(0, 0);
        this.mGestureDetector = new GestureDetector(getContext(), new c(this));
    }

    private void Ec() {
        int i = 0;
        int scrollX = getScrollX();
        if (this.asr >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.asr) {
                scrollX = (int) (this.asr - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.ass + this.mTop + this.mBottom >= getHeight()) {
            i = scrollY < (-this.asI) ? -this.asI : scrollY;
            if (getHeight() + i > this.ass + this.mBottom + this.asJ) {
                i = (int) ((this.ass - getHeight()) + this.mBottom + this.asJ);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.asr;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.ass;
    }

    public boolean onRightSide() {
        if (this.WG == 1 || this.WG == 2) {
            return true;
        }
        return !this.asE && getScrollX() >= ((int) (this.asr - ((float) getWidth()))) + (-1);
    }

    public boolean onLeftSide() {
        if (this.WG == 1 || this.WG == 2) {
            return true;
        }
        return !this.asE && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.asB.Eh()) {
            this.asB.stopAnimation();
        }
        this.asK = 0;
        super.setImageBitmap(bitmap);
        reInitBitmap();
        this.WG = 0;
    }

    public void replaceImageBitmap(Bitmap bitmap) {
        Bitmap imageBitmap = getImageBitmap();
        if (bitmap != null && !bitmap.isRecycled()) {
            if (imageBitmap != null && (imageBitmap.getWidth() != bitmap.getWidth() || imageBitmap.getHeight() != bitmap.getHeight())) {
                setImageBitmap(bitmap);
                return;
            }
            if (this.asB.Eh()) {
                this.asB.stopAnimation();
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            super.setImageBitmap(bitmap);
            super.setImageMatrix(this.mMatrix);
            scrollTo(scrollX, scrollY);
            this.WG = 0;
        }
    }

    public void a(byte[] bArr, Bitmap bitmap) {
        if (this.asB.Eh()) {
            this.asB.stopAnimation();
        }
        super.setImageDrawable(null);
        stop();
        reInitBitmap();
        this.WG = 1;
        this.asH = bitmap;
        this.mImageData = bArr;
        if (this.afE != null) {
            this.afE.a(this);
        }
    }

    public void onDestroy() {
        if (this.asB.Eh()) {
            this.asB.stopAnimation();
        }
        super.setImageDrawable(null);
        this.mImageData = null;
        this.asH = null;
        stop();
        if (this.asG != null) {
            this.asG.close();
            this.asG = null;
        }
    }

    public void release() {
        if (this.asB.Eh()) {
            this.asB.stopAnimation();
        }
        stop();
        super.setImageDrawable(null);
        this.asH = null;
    }

    public void setDefaultBitmap() {
        if (this.asB.Eh()) {
            this.asB.stopAnimation();
        }
        if (this.asM) {
            super.setImageBitmap(com.baidu.tbadk.core.util.c.bR(com.baidu.tieba.p.icon_default_avatar100));
        } else {
            super.setImageBitmap(com.baidu.tbadk.core.util.c.bR(com.baidu.tieba.p.btn_see_default));
        }
        this.WG = 2;
        reInitBitmap();
    }

    public void zoomInBitmap() {
        if (this.WG != 1 && this.WG != 2) {
            int size = this.ast.size();
            if (size > 0) {
                this.ast.add(Float.valueOf(this.ast.get(size - 1).floatValue() * 1.25f));
            } else {
                this.ast.add(Float.valueOf(this.asu));
            }
            Ed();
            Eb();
        }
    }

    public void zoomOutBitmap() {
        if (this.WG != 1 && this.WG != 2) {
            int size = this.ast.size();
            if (size > 1) {
                this.ast.remove(size - 1);
            }
            Ed();
            Eb();
        }
    }

    public void restoreSize() {
        Eb();
        if (this.WG != 1 && this.WG != 2 && this.mCurrentScale != this.asu) {
            this.ast.clear();
            this.ast.add(Float.valueOf(this.asu));
            this.mCurrentScale = this.asu;
            this.asv = this.mCurrentScale;
            Ed();
        }
    }

    public boolean canZoomIn() {
        if (this.WG == 1 || this.WG == 2) {
            return false;
        }
        int size = this.ast.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.ast.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.asx) && floatValue <= 5.0f;
    }

    public boolean canZoomOut() {
        if (this.WG == 1 || this.WG == 2) {
            return false;
        }
        int size = this.ast.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled()) {
            return false;
        }
        return size > 1;
    }

    public void Ed() {
        e(false, -1, -1);
    }

    public void e(boolean z, int i, int i2) {
        float f;
        float f2;
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled()) {
            try {
                if (this.mMode != 2) {
                    int size = this.ast.size();
                    if (size > 0) {
                        f2 = this.ast.get(size - 1).floatValue();
                    } else {
                        f2 = this.asu;
                    }
                    this.mCurrentScale = f2;
                }
                this.mMatrix.setScale(this.mCurrentScale, this.mCurrentScale);
                this.asr = imageBitmap.getWidth() * this.mCurrentScale;
                this.ass = imageBitmap.getHeight() * this.mCurrentScale;
                float width = this.asv * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.asv;
                this.asI = this.mTop;
                this.asJ = 0;
                float f3 = this.asr < ((float) this.mViewWidth) ? (int) ((this.mViewWidth - this.asr) / 2.0f) : 0.0f;
                if (this.ass < this.mViewHeight) {
                    f = (int) ((this.mViewHeight - this.ass) / 2.0f);
                    if (this.asy == 1 && f > this.mTop) {
                        f = this.mTop;
                    }
                    this.asI = (int) (this.mTop - f);
                    this.asJ = this.mTop - this.asI;
                } else {
                    f = 0.0f;
                }
                this.mMatrix.postTranslate(f3, f);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    scrollX = i > getWidth() ? getWidth() : i;
                    if (this.asr <= screenWidth) {
                        scrollX = 0;
                    } else if (this.asr > screenWidth && this.asr / 2.0f < screenWidth) {
                        scrollX = (int) (scrollX - (this.asr / 4.0f));
                    }
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.asr - width) / 2.0f);
                    }
                    if (this.asr <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.asr) {
                        scrollX = (int) (this.asr - getWidth());
                    }
                }
                if (scrollX > 0 && this.asr - scrollX < getWidth()) {
                    scrollX = (int) (this.asr - getWidth());
                }
                if (this.mMode == 2) {
                    scrollY += (int) ((this.ass - height) / 2.0f);
                }
                if (this.ass <= getHeight()) {
                    scrollY = 0;
                } else if (getHeight() + scrollY > this.ass) {
                    scrollY = (int) (this.ass - getHeight());
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
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.asA = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.afC = onLongClickListener;
    }

    public void setGifSetListener(g gVar) {
        this.afE = gVar;
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

    public void Ee() {
        long j;
        f poll = this.asR.poll();
        if (poll == null) {
            this.asW = true;
            return;
        }
        this.asW = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.asQ != null) {
            j = this.asQ.delay - (currentTimeMillis - this.asV);
            this.asS.offer(this.asQ);
        } else {
            j = 0;
        }
        this.asQ = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public f Ef() {
        f poll = this.asS.poll();
        if (poll == null) {
            f fVar = new f(null);
            fVar.ate = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
            return fVar;
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

    public boolean Eg() {
        return this.asL;
    }

    public void setLoadBigImage(boolean z) {
        this.asL = z;
    }
}
