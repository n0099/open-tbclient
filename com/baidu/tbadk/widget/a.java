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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends ImageView {
    private int VX;
    private View.OnLongClickListener aeq;
    private g aes;
    private int aet;
    private float aqG;
    private float aqH;
    private ArrayList<Float> aqI;
    private float aqJ;
    private float aqK;
    private boolean aqL;
    private int aqM;
    private int aqN;
    private h aqO;
    private View.OnClickListener aqP;
    private d aqQ;
    private float aqR;
    private boolean aqS;
    private boolean aqT;
    private int aqU;
    private volatile com.baidu.adp.gif.c aqV;
    private Bitmap aqW;
    private int aqX;
    private int aqY;
    private int aqZ;
    private boolean ara;
    private boolean arb;
    private float arc;
    private Interpolator ard;
    private int are;
    private f arf;
    private BlockingLinkedDeque<f> arg;
    private BlockingLinkedDeque<f> arh;
    private volatile int ari;
    private e arj;
    private volatile long ark;
    private volatile boolean arl;
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
        this.arb = z;
    }

    public a(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aqL = false;
        this.mImageData = null;
        this.aet = 0;
        this.aqM = 1300;
        this.aqN = 0;
        this.aqO = null;
        this.aqP = null;
        this.aeq = null;
        this.aes = null;
        this.aqR = 1.0f;
        this.VX = 0;
        this.mMode = 0;
        this.aqS = false;
        this.aqT = false;
        this.aqU = 0;
        this.aqV = null;
        this.aqW = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aqX = 0;
        this.aqY = 0;
        this.aqZ = 0;
        this.ard = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.are = 0;
        this.arf = null;
        this.arg = new BlockingLinkedDeque<>(5);
        this.arh = new BlockingLinkedDeque<>(6);
        this.ari = 0;
        this.ark = 0L;
        this.mState = 0;
        this.arl = true;
        this.mHandler = new Handler(new b(this));
        initData();
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aqL = false;
        this.mImageData = null;
        this.aet = 0;
        this.aqM = 1300;
        this.aqN = 0;
        this.aqO = null;
        this.aqP = null;
        this.aeq = null;
        this.aes = null;
        this.aqR = 1.0f;
        this.VX = 0;
        this.mMode = 0;
        this.aqS = false;
        this.aqT = false;
        this.aqU = 0;
        this.aqV = null;
        this.aqW = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aqX = 0;
        this.aqY = 0;
        this.aqZ = 0;
        this.ard = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.are = 0;
        this.arf = null;
        this.arg = new BlockingLinkedDeque<>(5);
        this.arh = new BlockingLinkedDeque<>(6);
        this.ari = 0;
        this.ark = 0L;
        this.mState = 0;
        this.arl = true;
        this.mHandler = new Handler(new b(this));
        initData();
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aqL = false;
        this.mImageData = null;
        this.aet = 0;
        this.aqM = 1300;
        this.aqN = 0;
        this.aqO = null;
        this.aqP = null;
        this.aeq = null;
        this.aes = null;
        this.aqR = 1.0f;
        this.VX = 0;
        this.mMode = 0;
        this.aqS = false;
        this.aqT = false;
        this.aqU = 0;
        this.aqV = null;
        this.aqW = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aqX = 0;
        this.aqY = 0;
        this.aqZ = 0;
        this.ard = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.are = 0;
        this.arf = null;
        this.arg = new BlockingLinkedDeque<>(5);
        this.arh = new BlockingLinkedDeque<>(6);
        this.ari = 0;
        this.ark = 0L;
        this.mState = 0;
        this.arl = true;
        this.mHandler = new Handler(new b(this));
        initData();
    }

    public int getImageType() {
        return this.VX;
    }

    public void setImageMode(int i) {
        this.aqN = i;
    }

    public void setOffset(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.aet = i;
    }

    public void actionUp() {
        this.aqT = false;
        this.aqL = false;
        this.mMode = 0;
        Dm();
        if (this.mCurrentScale < this.aqJ) {
            this.mCurrentScale = this.aqJ;
            Dn();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.aqL = true;
                this.aqS = false;
                this.aqT = false;
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
            this.aqR = spacing(motionEvent);
            if (this.aqR > 10.0f) {
                this.mMode = 2;
            }
        }
        if (this.mMode == 2 || !this.mGestureDetector.onTouchEvent(motionEvent)) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.aqS = true;
                        this.aqT = true;
                        if (this.VX != 1 && this.VX != 2) {
                            float spacing = spacing(motionEvent);
                            if (spacing >= 0.0f && Math.abs(this.aqR - spacing) >= 10.0f) {
                                if (Math.abs(this.aqR - spacing) > 100.0f) {
                                    this.aqR = spacing;
                                    break;
                                } else {
                                    float f = spacing / this.aqR;
                                    this.aqR = spacing;
                                    this.aqK = this.mCurrentScale;
                                    this.mCurrentScale *= f;
                                    if (this.mCurrentScale > this.mMaxScale) {
                                        this.mCurrentScale = this.mMaxScale;
                                    }
                                    if (this.mCurrentScale < this.aqJ / 4.0f) {
                                        this.mCurrentScale = this.aqJ / 4.0f;
                                    }
                                    Dn();
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
        return this.aqJ == this.mCurrentScale;
    }

    private void reInitBitmap() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            if (this.aqN == 0) {
                float width = this.mViewWidth / imageBitmap.getWidth();
                float height = this.mViewHeight / imageBitmap.getHeight();
                if (this.arb) {
                    if (this.VX == 2) {
                        this.aqJ = 2.5f;
                    } else {
                        this.aqJ = Math.min(width, height);
                    }
                } else if (this.VX == 2) {
                    this.aqJ = 1.0f;
                } else {
                    float f = this.arc;
                    float f2 = f >= 1.0f ? f : 1.0f;
                    if (imageBitmap.getWidth() * f2 < this.mViewWidth && imageBitmap.getHeight() * f2 < this.mViewHeight) {
                        this.aqJ = f2;
                    } else {
                        this.aqJ = Math.min(width, height);
                    }
                }
            } else {
                this.aqJ = Math.max(this.mViewWidth / imageBitmap.getWidth(), ((this.mViewHeight - this.mTop) - this.mBottom) / imageBitmap.getHeight());
            }
            this.mMaxScale = this.aqM / (imageBitmap.getWidth() * imageBitmap.getHeight());
            this.mMaxScale = FloatMath.sqrt(this.mMaxScale);
            if (this.mMaxScale > 10.0f) {
                this.mMaxScale = 10.0f;
            }
            this.aqI.clear();
            this.aqI.add(Float.valueOf(this.aqJ));
            this.mCurrentScale = this.aqJ;
            this.aqK = this.mCurrentScale;
            Dn();
            Dl();
            return;
        }
        this.aqG = 0.0f;
        this.aqH = 0.0f;
        this.aqJ = 1.0f;
        this.mMaxScale = 1.0f;
        this.mCurrentScale = 1.0f;
        this.aqK = this.mCurrentScale;
        this.aqI.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    public void Dl() {
        if (this.aqO != null) {
            this.aqO.a(this, canZoomIn(), canZoomOut());
        }
    }

    public void setOnSizeChangedListener(h hVar) {
        this.aqO = hVar;
    }

    public byte[] getImageData() {
        return this.mImageData;
    }

    public void setImageData(byte[] bArr) {
        this.mImageData = bArr;
    }

    public Bitmap getGifCache() {
        return this.aqW;
    }

    public void setGifCache(Bitmap bitmap) {
        this.aqW = bitmap;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        boolean z;
        int i4;
        if (this.VX == 2 && this.aqZ != 0 && !this.aqQ.Dr()) {
            int width = getWidth();
            int height = getHeight();
            Drawable drawable = getDrawable();
            float f = 0.0f;
            float f2 = height * 0.3f;
            float f3 = width;
            float f4 = (1.0f - 0.3f) * height;
            if (this.arb && drawable != null) {
                Rect bounds = drawable.getBounds();
                int i5 = bounds.right - bounds.left;
                int i6 = bounds.bottom - bounds.top;
                f = (width / 2) - (i5 * 2.5f);
                f2 = (height / 2) - (i6 * 2.5f);
                f3 = (i5 * 2.5f) + (width / 2);
                f4 = (i6 * 2.5f) + (height / 2);
            }
            this.mPaint.setColor(ba.getColor(this.aqZ));
            canvas.drawRect(f, f2, f3, f4, this.mPaint);
            this.mPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        }
        super.onDraw(canvas);
        if (this.VX == 1 && this.aqW != null && !this.aqW.isRecycled()) {
            int width2 = this.aqW.getWidth();
            int height2 = this.aqW.getHeight();
            int width3 = getWidth();
            int height3 = getHeight();
            int i7 = (width3 - width2) >> 1;
            int i8 = (height3 - height2) >> 1;
            float f5 = this.arc;
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
            if (this.aqU == 1 && this.aqV != null && this.arf != null && this.arf.art != null) {
                if (z) {
                    canvas.drawBitmap(this.arf.art, i3, i2, (Paint) null);
                } else {
                    canvas.drawBitmap(this.arf.art, this.mMatrix, this.mPaint);
                }
                invalidate();
            } else if (z) {
                canvas.drawBitmap(this.aqW, i3, i2, (Paint) null);
            } else {
                canvas.drawBitmap(this.aqW, this.mMatrix, this.mPaint);
            }
        }
    }

    public void play() {
        com.baidu.adp.widget.a.a d;
        if (this.VX == 1) {
            if (this.aqV == null) {
                if (this.arj != null) {
                    this.arj.interrupt();
                    this.arj = null;
                }
                if (this.mImageData != null && (d = com.baidu.adp.gif.b.ff().d(this.mImageData, 0, this.mImageData.length)) != null && d.getGif() != null) {
                    this.aqV = d.getGif();
                    if (this.aqV != null) {
                        this.aqU = 1;
                        this.width = this.aqV.getWidth();
                        this.height = this.aqV.getHeight();
                        this.ari = 0;
                        this.are = this.aqV.fg();
                    } else {
                        this.aqU = 0;
                    }
                } else {
                    return;
                }
            }
            if (this.aqV != null && this.mState == 0) {
                this.arl = true;
                this.arj = new e(this, null);
                this.arg.clear();
                this.arh.clear();
                this.mState = 1;
                this.arj.start();
            }
        }
    }

    public void pause() {
        if (this.VX == 1) {
            this.mState = 0;
            if (this.arj != null) {
                this.arj.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.VX == 1) {
            this.mState = 0;
            if (this.arj != null) {
                this.arj.interrupt();
                this.arj = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.arl = true;
            this.arf = null;
            this.arh.clear();
            this.arg.clear();
            this.width = 0;
            this.height = 0;
            this.ari = 0;
            this.are = 0;
            if (this.aqV != null) {
                this.aqV = null;
            }
        }
    }

    private void initData() {
        this.arc = com.baidu.adp.lib.util.n.O(getContext());
        this.aqM = com.baidu.adp.lib.util.n.N(getContext()) * com.baidu.adp.lib.util.n.M(getContext()) * 2;
        if (this.aqM < 1690000) {
            this.aqM = 1690000;
        }
        this.aqG = 0.0f;
        this.aqH = 0.0f;
        this.aqI = new ArrayList<>();
        this.aqJ = 1.0f;
        this.mMaxScale = 1.0f;
        this.mCurrentScale = 1.0f;
        this.aqK = this.mCurrentScale;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.aqQ = new d(this);
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWillNotDraw(false);
        scrollTo(0, 0);
        this.mGestureDetector = new GestureDetector(getContext(), new c(this));
    }

    private void Dm() {
        int i = 0;
        int scrollX = getScrollX();
        if (this.aqG >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.aqG) {
                scrollX = (int) (this.aqG - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.aqH + this.mTop + this.mBottom >= getHeight()) {
            i = scrollY < (-this.aqX) ? -this.aqX : scrollY;
            if (getHeight() + i > this.aqH + this.mBottom + this.aqY) {
                i = (int) ((this.aqH - getHeight()) + this.mBottom + this.aqY);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.aqG;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.aqH;
    }

    public boolean onRightSide() {
        if (this.VX == 1 || this.VX == 2) {
            return true;
        }
        return !this.aqT && getScrollX() >= ((int) (this.aqG - ((float) getWidth()))) + (-1);
    }

    public boolean onLeftSide() {
        if (this.VX == 1 || this.VX == 2) {
            return true;
        }
        return !this.aqT && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.aqQ.Dr()) {
            this.aqQ.stopAnimation();
        }
        this.aqZ = 0;
        super.setImageBitmap(bitmap);
        reInitBitmap();
        this.VX = 0;
    }

    public void replaceImageBitmap(Bitmap bitmap) {
        Bitmap imageBitmap = getImageBitmap();
        if (bitmap != null && !bitmap.isRecycled()) {
            if (imageBitmap != null && (imageBitmap.getWidth() != bitmap.getWidth() || imageBitmap.getHeight() != bitmap.getHeight())) {
                setImageBitmap(bitmap);
                return;
            }
            if (this.aqQ.Dr()) {
                this.aqQ.stopAnimation();
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            super.setImageBitmap(bitmap);
            super.setImageMatrix(this.mMatrix);
            scrollTo(scrollX, scrollY);
            this.VX = 0;
        }
    }

    public void a(byte[] bArr, Bitmap bitmap) {
        if (this.aqQ.Dr()) {
            this.aqQ.stopAnimation();
        }
        super.setImageDrawable(null);
        stop();
        reInitBitmap();
        this.VX = 1;
        this.aqW = bitmap;
        this.mImageData = bArr;
        if (this.aes != null) {
            this.aes.a(this);
        }
    }

    public void onDestroy() {
        if (this.aqQ.Dr()) {
            this.aqQ.stopAnimation();
        }
        super.setImageDrawable(null);
        this.mImageData = null;
        this.aqW = null;
        stop();
        if (this.aqV != null) {
            this.aqV.close();
            this.aqV = null;
        }
    }

    public void release() {
        if (this.aqQ.Dr()) {
            this.aqQ.stopAnimation();
        }
        stop();
        super.setImageDrawable(null);
        this.aqW = null;
    }

    public void setDefaultBitmap() {
        if (this.aqQ.Dr()) {
            this.aqQ.stopAnimation();
        }
        if (this.arb) {
            super.setImageBitmap(com.baidu.tbadk.core.util.c.bO(u.icon_default_avatar100));
        } else {
            super.setImageBitmap(com.baidu.tbadk.core.util.c.bO(u.btn_see_default));
        }
        this.VX = 2;
        reInitBitmap();
    }

    public void zoomInBitmap() {
        if (this.VX != 1 && this.VX != 2) {
            int size = this.aqI.size();
            if (size > 0) {
                this.aqI.add(Float.valueOf(this.aqI.get(size - 1).floatValue() * 1.25f));
            } else {
                this.aqI.add(Float.valueOf(this.aqJ));
            }
            Dn();
            Dl();
        }
    }

    public void zoomOutBitmap() {
        if (this.VX != 1 && this.VX != 2) {
            int size = this.aqI.size();
            if (size > 1) {
                this.aqI.remove(size - 1);
            }
            Dn();
            Dl();
        }
    }

    public void restoreSize() {
        Dl();
        if (this.VX != 1 && this.VX != 2 && this.mCurrentScale != this.aqJ) {
            this.aqI.clear();
            this.aqI.add(Float.valueOf(this.aqJ));
            this.mCurrentScale = this.aqJ;
            this.aqK = this.mCurrentScale;
            Dn();
        }
    }

    public boolean canZoomIn() {
        if (this.VX == 1 || this.VX == 2) {
            return false;
        }
        int size = this.aqI.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.aqI.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.aqM) && floatValue <= 5.0f;
    }

    public boolean canZoomOut() {
        if (this.VX == 1 || this.VX == 2) {
            return false;
        }
        int size = this.aqI.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled()) {
            return false;
        }
        return size > 1;
    }

    public void Dn() {
        e(false, -1, -1);
    }

    public void e(boolean z, int i, int i2) {
        float f;
        float f2;
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled()) {
            try {
                if (this.mMode != 2) {
                    int size = this.aqI.size();
                    if (size > 0) {
                        f2 = this.aqI.get(size - 1).floatValue();
                    } else {
                        f2 = this.aqJ;
                    }
                    this.mCurrentScale = f2;
                }
                this.mMatrix.setScale(this.mCurrentScale, this.mCurrentScale);
                this.aqG = imageBitmap.getWidth() * this.mCurrentScale;
                this.aqH = imageBitmap.getHeight() * this.mCurrentScale;
                float width = this.aqK * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.aqK;
                this.aqX = this.mTop;
                this.aqY = 0;
                float f3 = this.aqG < ((float) this.mViewWidth) ? (int) ((this.mViewWidth - this.aqG) / 2.0f) : 0.0f;
                if (this.aqH < this.mViewHeight) {
                    f = (int) ((this.mViewHeight - this.aqH) / 2.0f);
                    if (this.aqN == 1 && f > this.mTop) {
                        f = this.mTop;
                    }
                    this.aqX = (int) (this.mTop - f);
                    this.aqY = this.mTop - this.aqX;
                } else {
                    f = 0.0f;
                }
                this.mMatrix.postTranslate(f3, f);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    scrollX = i > getWidth() ? getWidth() : i;
                    if (this.aqG <= screenWidth) {
                        scrollX = 0;
                    } else if (this.aqG > screenWidth && this.aqG / 2.0f < screenWidth) {
                        scrollX = (int) (scrollX - (this.aqG / 4.0f));
                    }
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.aqG - width) / 2.0f);
                    }
                    if (this.aqG <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.aqG) {
                        scrollX = (int) (this.aqG - getWidth());
                    }
                }
                if (scrollX > 0 && this.aqG - scrollX < getWidth()) {
                    scrollX = (int) (this.aqG - getWidth());
                }
                if (this.mMode == 2) {
                    scrollY += (int) ((this.aqH - height) / 2.0f);
                }
                if (this.aqH <= getHeight()) {
                    scrollY = 0;
                } else if (getHeight() + scrollY > this.aqH) {
                    scrollY = (int) (this.aqH - getHeight());
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
        this.aqP = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aeq = onLongClickListener;
    }

    public void setGifSetListener(g gVar) {
        this.aes = gVar;
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

    public void Do() {
        long j;
        f poll = this.arg.poll();
        if (poll == null) {
            this.arl = true;
            return;
        }
        this.arl = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.arf != null) {
            j = this.arf.delay - (currentTimeMillis - this.ark);
            this.arh.offer(this.arf);
        } else {
            j = 0;
        }
        this.arf = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public f Dp() {
        f poll = this.arh.poll();
        if (poll == null) {
            f fVar = new f(null);
            fVar.art = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
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

    public boolean Dq() {
        return this.ara;
    }

    public void setLoadBigImage(boolean z) {
        this.ara = z;
    }
}
