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
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends ImageView {
    private float aCA;
    private float aCB;
    private boolean aCC;
    private int aCD;
    private int aCE;
    private e aCF;
    private View.OnClickListener aCG;
    private C0056a aCH;
    private float aCI;
    private boolean aCJ;
    private boolean aCK;
    private int aCL;
    private volatile com.baidu.adp.gif.b aCM;
    private Bitmap aCN;
    private int aCO;
    private int aCP;
    private int aCQ;
    private boolean aCR;
    private boolean aCS;
    private float aCT;
    private Interpolator aCU;
    private int aCV;
    private c aCW;
    private BlockingLinkedDeque<c> aCX;
    private BlockingLinkedDeque<c> aCY;
    private volatile int aCZ;
    private float aCv;
    private float aCw;
    private ArrayList<Float> aCx;
    private float aCy;
    private float aCz;
    private b aDa;
    private volatile long aDb;
    private volatile boolean aDc;
    private int ads;
    private View.OnLongClickListener amQ;
    private d amS;
    private int amT;
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
        this.aCS = z;
    }

    public a(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aCC = false;
        this.mImageData = null;
        this.amT = 0;
        this.aCD = 1300;
        this.aCE = 0;
        this.aCF = null;
        this.aCG = null;
        this.amQ = null;
        this.amS = null;
        this.aCI = 1.0f;
        this.ads = 0;
        this.mMode = 0;
        this.aCJ = false;
        this.aCK = false;
        this.aCL = 0;
        this.aCM = null;
        this.aCN = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aCO = 0;
        this.aCP = 0;
        this.aCQ = 0;
        this.aCU = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aCV = 0;
        this.aCW = null;
        this.aCX = new BlockingLinkedDeque<>(5);
        this.aCY = new BlockingLinkedDeque<>(6);
        this.aCZ = 0;
        this.aDb = 0L;
        this.mState = 0;
        this.aDc = true;
        this.mHandler = new Handler(new com.baidu.tbadk.widget.b(this));
        initData();
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aCC = false;
        this.mImageData = null;
        this.amT = 0;
        this.aCD = 1300;
        this.aCE = 0;
        this.aCF = null;
        this.aCG = null;
        this.amQ = null;
        this.amS = null;
        this.aCI = 1.0f;
        this.ads = 0;
        this.mMode = 0;
        this.aCJ = false;
        this.aCK = false;
        this.aCL = 0;
        this.aCM = null;
        this.aCN = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aCO = 0;
        this.aCP = 0;
        this.aCQ = 0;
        this.aCU = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aCV = 0;
        this.aCW = null;
        this.aCX = new BlockingLinkedDeque<>(5);
        this.aCY = new BlockingLinkedDeque<>(6);
        this.aCZ = 0;
        this.aDb = 0L;
        this.mState = 0;
        this.aDc = true;
        this.mHandler = new Handler(new com.baidu.tbadk.widget.b(this));
        initData();
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.aCC = false;
        this.mImageData = null;
        this.amT = 0;
        this.aCD = 1300;
        this.aCE = 0;
        this.aCF = null;
        this.aCG = null;
        this.amQ = null;
        this.amS = null;
        this.aCI = 1.0f;
        this.ads = 0;
        this.mMode = 0;
        this.aCJ = false;
        this.aCK = false;
        this.aCL = 0;
        this.aCM = null;
        this.aCN = null;
        this.mPaint = new Paint((int) ViewCompat.MEASURED_STATE_MASK);
        this.mTop = 0;
        this.mBottom = 0;
        this.aCO = 0;
        this.aCP = 0;
        this.aCQ = 0;
        this.aCU = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.width = 0;
        this.height = 0;
        this.aCV = 0;
        this.aCW = null;
        this.aCX = new BlockingLinkedDeque<>(5);
        this.aCY = new BlockingLinkedDeque<>(6);
        this.aCZ = 0;
        this.aDb = 0L;
        this.mState = 0;
        this.aDc = true;
        this.mHandler = new Handler(new com.baidu.tbadk.widget.b(this));
        initData();
    }

    public int getImageType() {
        return this.ads;
    }

    public void setImageMode(int i) {
        this.aCE = i;
    }

    public void setOffset(int i, int i2, int i3, int i4) {
        this.mTop = i2;
        this.mBottom = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.amT = i;
    }

    public void actionUp() {
        this.aCK = false;
        this.aCC = false;
        this.mMode = 0;
        Fr();
        if (this.aCA < this.aCy) {
            this.aCA = this.aCy;
            Fs();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.aCC = true;
                this.aCJ = false;
                this.aCK = false;
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
            this.aCI = spacing(motionEvent);
            if (this.aCI > 10.0f) {
                this.mMode = 2;
            }
        }
        if (this.mMode == 2 || !this.mGestureDetector.onTouchEvent(motionEvent)) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.aCJ = true;
                        this.aCK = true;
                        if (this.ads != 1 && this.ads != 2) {
                            float spacing = spacing(motionEvent);
                            if (spacing >= 0.0f && Math.abs(this.aCI - spacing) >= 10.0f) {
                                if (Math.abs(this.aCI - spacing) > 100.0f) {
                                    this.aCI = spacing;
                                    break;
                                } else {
                                    float f = spacing / this.aCI;
                                    this.aCI = spacing;
                                    this.aCB = this.aCA;
                                    this.aCA *= f;
                                    if (this.aCA > this.aCz) {
                                        this.aCA = this.aCz;
                                    }
                                    if (this.aCA < this.aCy / 4.0f) {
                                        this.aCA = this.aCy / 4.0f;
                                    }
                                    Fs();
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
        return this.aCy == this.aCA;
    }

    private void reInitBitmap() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            if (this.aCE == 0) {
                float width = this.mViewWidth / imageBitmap.getWidth();
                float height = this.mViewHeight / imageBitmap.getHeight();
                if (this.aCS) {
                    if (this.ads == 2) {
                        this.aCy = 2.5f;
                    } else {
                        this.aCy = Math.min(width, height);
                    }
                } else if (this.ads == 2) {
                    this.aCy = 1.0f;
                } else {
                    float f = this.aCT;
                    float f2 = f >= 1.0f ? f : 1.0f;
                    if (imageBitmap.getWidth() * f2 < this.mViewWidth && imageBitmap.getHeight() * f2 < this.mViewHeight) {
                        this.aCy = f2;
                    } else {
                        this.aCy = Math.min(width, height);
                    }
                }
            } else {
                this.aCy = Math.max(this.mViewWidth / imageBitmap.getWidth(), ((this.mViewHeight - this.mTop) - this.mBottom) / imageBitmap.getHeight());
            }
            this.aCz = this.aCD / (imageBitmap.getWidth() * imageBitmap.getHeight());
            this.aCz = FloatMath.sqrt(this.aCz);
            if (this.aCz > 10.0f) {
                this.aCz = 10.0f;
            }
            this.aCx.clear();
            this.aCx.add(Float.valueOf(this.aCy));
            this.aCA = this.aCy;
            this.aCB = this.aCA;
            Fs();
            Fq();
            return;
        }
        this.aCv = 0.0f;
        this.aCw = 0.0f;
        this.aCy = 1.0f;
        this.aCz = 1.0f;
        this.aCA = 1.0f;
        this.aCB = this.aCA;
        this.aCx.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fq() {
        if (this.aCF != null) {
            this.aCF.a(this, canZoomIn(), canZoomOut());
        }
    }

    public void setOnSizeChangedListener(e eVar) {
        this.aCF = eVar;
    }

    public byte[] getImageData() {
        return this.mImageData;
    }

    public void setImageData(byte[] bArr) {
        this.mImageData = bArr;
    }

    public Bitmap getGifCache() {
        return this.aCN;
    }

    public void setGifCache(Bitmap bitmap) {
        this.aCN = bitmap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        boolean z;
        int i4;
        if (this.ads == 2 && this.aCQ != 0 && !this.aCH.Fw()) {
            int width = getWidth();
            int height = getHeight();
            Drawable drawable = getDrawable();
            float f = 0.0f;
            float f2 = height * 0.3f;
            float f3 = width;
            float f4 = (1.0f - 0.3f) * height;
            if (this.aCS && drawable != null) {
                Rect bounds = drawable.getBounds();
                int i5 = bounds.right - bounds.left;
                int i6 = bounds.bottom - bounds.top;
                f = (width / 2) - (i5 * 2.5f);
                f2 = (height / 2) - (i6 * 2.5f);
                f3 = (i5 * 2.5f) + (width / 2);
                f4 = (i6 * 2.5f) + (height / 2);
            }
            this.mPaint.setColor(as.getColor(this.aCQ));
            canvas.drawRect(f, f2, f3, f4, this.mPaint);
            this.mPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        }
        super.onDraw(canvas);
        if (this.ads == 1 && this.aCN != null && !this.aCN.isRecycled()) {
            int width2 = this.aCN.getWidth();
            int height2 = this.aCN.getHeight();
            int width3 = getWidth();
            int height3 = getHeight();
            int i7 = (width3 - width2) >> 1;
            int i8 = (height3 - height2) >> 1;
            float f5 = this.aCT;
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
            if (this.aCL == 1 && this.aCM != null && this.aCW != null && this.aCW.aDl != null) {
                if (z) {
                    canvas.drawBitmap(this.aCW.aDl, i3, i2, (Paint) null);
                } else {
                    canvas.drawBitmap(this.aCW.aDl, this.mMatrix, this.mPaint);
                }
                invalidate();
            } else if (z) {
                canvas.drawBitmap(this.aCN, i3, i2, (Paint) null);
            } else {
                canvas.drawBitmap(this.aCN, this.mMatrix, this.mPaint);
            }
        }
    }

    public void play() {
        com.baidu.adp.widget.a.a e2;
        if (this.ads == 1) {
            if (this.aCM == null) {
                if (this.aDa != null) {
                    this.aDa.interrupt();
                    this.aDa = null;
                }
                if (this.mImageData != null && (e2 = a.C0003a.fe().e(this.mImageData, 0, this.mImageData.length)) != null && e2.getGif() != null) {
                    this.aCM = e2.getGif();
                    if (this.aCM != null) {
                        this.aCL = 1;
                        this.width = this.aCM.getWidth();
                        this.height = this.aCM.getHeight();
                        this.aCZ = 0;
                        this.aCV = this.aCM.ff();
                    } else {
                        this.aCL = 0;
                    }
                } else {
                    return;
                }
            }
            if (this.aCM != null && this.mState == 0) {
                this.aDc = true;
                this.aDa = new b(this, null);
                this.aCX.clear();
                this.aCY.clear();
                this.mState = 1;
                this.aDa.start();
            }
        }
    }

    public void pause() {
        if (this.ads == 1) {
            this.mState = 0;
            if (this.aDa != null) {
                this.aDa.interrupt();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void stop() {
        if (this.ads == 1) {
            this.mState = 0;
            if (this.aDa != null) {
                this.aDa.interrupt();
                this.aDa = null;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.aDc = true;
            this.aCW = null;
            this.aCY.clear();
            this.aCX.clear();
            this.width = 0;
            this.height = 0;
            this.aCZ = 0;
            this.aCV = 0;
            if (this.aCM != null) {
                this.aCM = null;
            }
        }
    }

    private void initData() {
        this.aCT = k.M(getContext());
        this.aCD = k.L(getContext()) * k.K(getContext()) * 2;
        if (this.aCD < 1690000) {
            this.aCD = 1690000;
        }
        this.aCv = 0.0f;
        this.aCw = 0.0f;
        this.aCx = new ArrayList<>();
        this.aCy = 1.0f;
        this.aCz = 1.0f;
        this.aCA = 1.0f;
        this.aCB = this.aCA;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.aCH = new C0056a();
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWillNotDraw(false);
        scrollTo(0, 0);
        this.mGestureDetector = new GestureDetector(getContext(), new com.baidu.tbadk.widget.c(this));
    }

    private void Fr() {
        int i = 0;
        int scrollX = getScrollX();
        if (this.aCv >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.aCv) {
                scrollX = (int) (this.aCv - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.aCw + this.mTop + this.mBottom >= getHeight()) {
            i = scrollY < (-this.aCO) ? -this.aCO : scrollY;
            if (getHeight() + i > this.aCw + this.mBottom + this.aCP) {
                i = (int) ((this.aCw - getHeight()) + this.mBottom + this.aCP);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.aCv;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.aCw;
    }

    public boolean onRightSide() {
        if (this.ads == 1 || this.ads == 2) {
            return true;
        }
        return !this.aCK && getScrollX() >= ((int) (this.aCv - ((float) getWidth()))) + (-1);
    }

    public boolean onLeftSide() {
        if (this.ads == 1 || this.ads == 2) {
            return true;
        }
        return !this.aCK && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.aCH.Fw()) {
            this.aCH.stopAnimation();
        }
        this.aCQ = 0;
        super.setImageBitmap(bitmap);
        reInitBitmap();
        this.ads = 0;
    }

    public void replaceImageBitmap(Bitmap bitmap) {
        Bitmap imageBitmap = getImageBitmap();
        if (bitmap != null && !bitmap.isRecycled()) {
            if (imageBitmap != null && (imageBitmap.getWidth() != bitmap.getWidth() || imageBitmap.getHeight() != bitmap.getHeight())) {
                setImageBitmap(bitmap);
                return;
            }
            if (this.aCH.Fw()) {
                this.aCH.stopAnimation();
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            super.setImageBitmap(bitmap);
            super.setImageMatrix(this.mMatrix);
            scrollTo(scrollX, scrollY);
            this.ads = 0;
        }
    }

    public void a(byte[] bArr, Bitmap bitmap) {
        if (this.aCH.Fw()) {
            this.aCH.stopAnimation();
        }
        super.setImageDrawable(null);
        stop();
        reInitBitmap();
        this.ads = 1;
        this.aCN = bitmap;
        this.mImageData = bArr;
        if (this.amS != null) {
            this.amS.a(this);
        }
    }

    public void onDestroy() {
        if (this.aCH.Fw()) {
            this.aCH.stopAnimation();
        }
        super.setImageDrawable(null);
        this.mImageData = null;
        this.aCN = null;
        stop();
        if (this.aCM != null) {
            this.aCM.close();
            this.aCM = null;
        }
    }

    public void release() {
        if (this.aCH.Fw()) {
            this.aCH.stopAnimation();
        }
        stop();
        super.setImageDrawable(null);
        this.aCN = null;
    }

    public void setDefaultBitmap() {
        if (this.aCH.Fw()) {
            this.aCH.stopAnimation();
        }
        if (this.aCS) {
            super.setImageBitmap(com.baidu.tbadk.core.util.c.cg(n.f.icon_default_avatar100));
        } else {
            super.setImageBitmap(com.baidu.tbadk.core.util.c.cg(n.f.btn_see_default));
        }
        this.ads = 2;
        reInitBitmap();
    }

    public void zoomInBitmap() {
        if (this.ads != 1 && this.ads != 2) {
            int size = this.aCx.size();
            if (size > 0) {
                this.aCx.add(Float.valueOf(this.aCx.get(size - 1).floatValue() * 1.25f));
            } else {
                this.aCx.add(Float.valueOf(this.aCy));
            }
            Fs();
            Fq();
        }
    }

    public void zoomOutBitmap() {
        if (this.ads != 1 && this.ads != 2) {
            int size = this.aCx.size();
            if (size > 1) {
                this.aCx.remove(size - 1);
            }
            Fs();
            Fq();
        }
    }

    public void restoreSize() {
        Fq();
        if (this.ads != 1 && this.ads != 2 && this.aCA != this.aCy) {
            this.aCx.clear();
            this.aCx.add(Float.valueOf(this.aCy));
            this.aCA = this.aCy;
            this.aCB = this.aCA;
            Fs();
        }
    }

    public boolean canZoomIn() {
        if (this.ads == 1 || this.ads == 2) {
            return false;
        }
        int size = this.aCx.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.aCx.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.aCD) && floatValue <= 5.0f;
    }

    public boolean canZoomOut() {
        if (this.ads == 1 || this.ads == 2) {
            return false;
        }
        int size = this.aCx.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled()) {
            return false;
        }
        return size > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fs() {
        f(false, -1, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z, int i, int i2) {
        float f;
        float f2;
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled()) {
            try {
                if (this.mMode != 2) {
                    int size = this.aCx.size();
                    if (size > 0) {
                        f2 = this.aCx.get(size - 1).floatValue();
                    } else {
                        f2 = this.aCy;
                    }
                    this.aCA = f2;
                }
                this.mMatrix.setScale(this.aCA, this.aCA);
                this.aCv = imageBitmap.getWidth() * this.aCA;
                this.aCw = imageBitmap.getHeight() * this.aCA;
                float width = this.aCB * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.aCB;
                this.aCO = this.mTop;
                this.aCP = 0;
                float f3 = this.aCv < ((float) this.mViewWidth) ? (int) ((this.mViewWidth - this.aCv) / 2.0f) : 0.0f;
                if (this.aCw < this.mViewHeight) {
                    f = (int) ((this.mViewHeight - this.aCw) / 2.0f);
                    if (this.aCE == 1 && f > this.mTop) {
                        f = this.mTop;
                    }
                    this.aCO = (int) (this.mTop - f);
                    this.aCP = this.mTop - this.aCO;
                } else {
                    f = 0.0f;
                }
                this.mMatrix.postTranslate(f3, f);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    scrollX = i > getWidth() ? getWidth() : i;
                    if (this.aCv <= screenWidth) {
                        scrollX = 0;
                    } else if (this.aCv > screenWidth && this.aCv / 2.0f < screenWidth) {
                        scrollX = (int) (scrollX - (this.aCv / 4.0f));
                    }
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.aCv - width) / 2.0f);
                    }
                    if (this.aCv <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.aCv) {
                        scrollX = (int) (this.aCv - getWidth());
                    }
                }
                if (scrollX > 0 && this.aCv - scrollX < getWidth()) {
                    scrollX = (int) (this.aCv - getWidth());
                }
                if (this.mMode == 2) {
                    scrollY += (int) ((this.aCw - height) / 2.0f);
                }
                if (this.aCw <= getHeight()) {
                    scrollY = 0;
                } else if (getHeight() + scrollY > this.aCw) {
                    scrollY = (int) (this.aCw - getHeight());
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
    public class C0056a extends Animation {
        private int II;
        private boolean aDe = false;
        private boolean aDf = false;
        private long aDg;
        private long aDh;
        private int aDi;
        private long aDj;
        private long aDk;

        public C0056a() {
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
            this.aDg = f;
            this.aDh = f2;
            this.aDj = Math.abs((f * 1000.0f) / 2500.0f);
            this.aDk = Math.abs((f2 * 1000.0f) / 2500.0f);
            setDuration(Math.max(this.aDj, this.aDk));
            setInterpolator(a.this.aCU);
            this.aDi = a.this.getScrollX();
            this.II = a.this.getScrollY();
            this.aDe = true;
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
            if (this.aDj > this.aDk) {
                j = ((float) this.aDj) * f;
            } else {
                j = ((float) this.aDk) * f;
            }
            float f2 = ((float) (j > this.aDj ? this.aDj : j)) / 1000.0f;
            if (this.aDg > 0) {
                i = this.aDi - ((int) (f2 * (((float) this.aDg) - ((2500.0f * f2) / 2.0f))));
            } else {
                i = this.aDi - ((int) (f2 * (((float) this.aDg) + ((2500.0f * f2) / 2.0f))));
            }
            if (j > this.aDk) {
                j = this.aDk;
            }
            float f3 = ((float) j) / 1000.0f;
            if (this.aDh > 0) {
                i2 = this.II - ((int) (f3 * (((float) this.aDh) - ((2500.0f * f3) / 2.0f))));
            } else {
                i2 = this.II - ((int) (f3 * (((float) this.aDh) + ((2500.0f * f3) / 2.0f))));
            }
            if (a.this.aCw + a.this.mTop + a.this.mBottom > a.this.getHeight()) {
                if (i2 < (-a.this.aCO)) {
                    i2 = -a.this.aCO;
                }
                if (a.this.getHeight() + i2 > a.this.aCw + a.this.mBottom + a.this.aCP) {
                    i2 = (int) ((a.this.aCw - a.this.getHeight()) + a.this.mBottom + a.this.aCP);
                }
            } else {
                i2 = 0;
            }
            if (a.this.aCv > a.this.getWidth()) {
                int width = ((float) (a.this.getWidth() + i)) > a.this.aCv ? (int) (a.this.aCv - a.this.getWidth()) : i;
                if (width >= 0) {
                    i3 = width;
                }
            }
            a.this.scrollTo(i3, i2);
            a.this.invalidate();
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            if (!this.aDf) {
                if (a.this.aCC) {
                    this.aDe = false;
                    return false;
                }
                try {
                    if (!super.getTransformation(j, transformation)) {
                        this.aDe = false;
                        return false;
                    }
                    return true;
                } catch (Exception e) {
                    this.aDe = false;
                    return false;
                }
            }
            this.aDf = false;
            this.aDe = false;
            return false;
        }

        public boolean Fw() {
            return this.aDe;
        }

        public void stopAnimation() {
            this.aDf = true;
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.aCG = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.amQ = onLongClickListener;
    }

    public void setGifSetListener(d dVar) {
        this.amS = dVar;
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
    public void Ft() {
        long j;
        c poll = this.aCX.poll();
        if (poll == null) {
            this.aDc = true;
            return;
        }
        this.aDc = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.aCW != null) {
            j = this.aCW.delay - (currentTimeMillis - this.aDb);
            this.aCY.offer(this.aCW);
        } else {
            j = 0;
        }
        this.aCW = poll;
        this.mHandler.sendEmptyMessageDelayed(2, j > 0 ? j : 0L);
    }

    public c Fu() {
        c poll = this.aCY.poll();
        if (poll == null) {
            poll = new c(null);
            try {
                poll.aDl = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
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
        public Bitmap aDl;
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
            while (a.this.mState == 1 && a.this.aCM != null && a.this.aCV > 0 && a.this.width > 0 && a.this.height > 0) {
                try {
                    a.this.aCM.G(a.this.aCZ);
                    c Fu = a.this.Fu();
                    if (Fu.aDl == null || (Fu.aDl.getWidth() != a.this.width && Fu.aDl.getHeight() != a.this.height)) {
                        try {
                            Fu.aDl = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_8888);
                        } catch (OutOfMemoryError e) {
                            TbadkCoreApplication.m411getInst().onAppMemoryLow();
                            try {
                                Fu.aDl = Bitmap.createBitmap(a.this.width, a.this.height, Bitmap.Config.ARGB_4444);
                            } catch (OutOfMemoryError e2) {
                                TbadkCoreApplication.m411getInst().onAppMemoryLow();
                            } catch (Throwable th) {
                                BdLog.e(th.getMessage());
                            }
                        } catch (Throwable th2) {
                            BdLog.e(th2.getMessage());
                        }
                    }
                    a.this.aCM.a(Fu.aDl, null);
                    Fu.delay = a.this.aCM.H(a.this.aCZ);
                    a.this.aCZ++;
                    if (Fu.aDl == null) {
                        a.this.aCZ++;
                    }
                    a.this.aCZ %= a.this.aCV;
                    a.this.aCX.put(Fu);
                    if (a.this.aDc) {
                        a.this.mHandler.sendEmptyMessage(1);
                    }
                } catch (Exception e3) {
                    return;
                }
            }
        }
    }

    public boolean Fv() {
        return this.aCR;
    }

    public void setLoadBigImage(boolean z) {
        this.aCR = z;
    }
}
