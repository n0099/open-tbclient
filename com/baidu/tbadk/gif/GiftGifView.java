package com.baidu.tbadk.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.l;
import com.baidu.adp.base.m;
import com.baidu.adp.newwidget.a.i;
import com.baidu.tieba.v;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class GiftGifView extends ImageView implements View.OnClickListener, i, Runnable {
    public static Bitmap ZF;
    private boolean ZB;
    private Drawable ZC;
    private boolean ZD;
    private float ZE;
    private float ZG;
    private final Rect ZK;
    private final Rect ZL;
    private boolean ZM;
    private boolean ZN;
    private a ZO;
    private BdUniqueId ZQ;
    private final com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> ZR;
    private h ZT;
    private boolean ZU;
    private boolean ZV;
    private WeakReference<com.baidu.adp.gif.c> Zw;
    private int Zx;
    private boolean isHide;
    private Bitmap mBitmap;
    private final Handler mHandler;
    private View.OnClickListener mOnClickListener;
    private final int mType;

    public GiftGifView(Context context) {
        this(context, null, 0);
    }

    public GiftGifView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GiftGifView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ZK = new Rect();
        this.ZL = new Rect();
        this.ZM = true;
        this.mType = 20;
        this.isHide = false;
        this.ZU = false;
        this.ZV = false;
        this.mHandler = new f(this, Looper.getMainLooper());
        this.ZR = new g(this);
        this.ZG = 30.0f;
        BitmapDrawable bitmapDrawable = (BitmapDrawable) getResources().getDrawable(v.loading);
        if (bitmapDrawable != null) {
            ZF = bitmapDrawable.getBitmap();
            this.ZL.set(0, 0, ZF.getWidth(), ZF.getHeight());
        }
        this.ZC = getResources().getDrawable(v.image_group_load_f);
        a(this.ZC);
    }

    private void a(Drawable drawable) {
        if (drawable != null) {
            drawable.setFilterBitmap(true);
            if (drawable instanceof BitmapDrawable) {
                ((BitmapDrawable) drawable).setAntiAlias(true);
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3 || i2 != i4) {
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int paddingTop = getPaddingTop();
            int paddingBottom = i2 - (getPaddingBottom() + paddingTop);
            int i5 = i - (paddingRight + paddingLeft);
            if (ZF != null) {
                int i6 = i5 / 4;
                int i7 = ((i5 - i6) / 2) + paddingLeft;
                int i8 = ((paddingBottom - i6) / 2) + paddingTop;
                this.ZK.set(i7, i8, i7 + i6, i6 + i8);
            }
            int intrinsicWidth = this.ZC.getIntrinsicWidth();
            int intrinsicHeight = this.ZC.getIntrinsicHeight();
            if (intrinsicWidth > i5) {
                intrinsicWidth = i5;
            }
            if (intrinsicHeight > paddingBottom) {
                intrinsicHeight = paddingBottom;
            }
            int i9 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
            int i10 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
            this.ZC.setBounds(i9, i10, intrinsicWidth + i9, intrinsicHeight + i10);
        }
    }

    public void setGif(com.baidu.adp.widget.a.a aVar) {
        this.ZB = false;
        this.ZD = false;
        if (this.ZO != null) {
            this.ZO.Zn = false;
        }
        if (aVar == null) {
            this.ZB = true;
            if (this.ZO != null) {
                this.ZO.Zn = true;
            }
            setImageDrawable(null);
            if (this.Zw != null) {
                this.Zw.clear();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.jg()) {
                aVar.a(this);
                this.ZD = false;
            }
            if (this.Zw != null) {
                this.Zw.clear();
            }
        } else if (this.Zw == null || !aVar.getGif().equals(this.Zw.get())) {
            if (this.mBitmap == null || this.mBitmap.getWidth() != aVar.getGif().getWidth() || this.mBitmap.getHeight() != aVar.getGif().getHeight() || this.ZU) {
                this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
            }
            this.Zw = new WeakReference<>(aVar.getGif());
            aVar.getGif().w(0);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.ZM) {
                play();
            }
        } else {
            aVar.getGif().w(this.Zx);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.ZM) {
                resume();
            }
        }
    }

    public boolean getAutoPlay() {
        return this.ZM;
    }

    public void setAutoPlay(boolean z) {
        this.ZM = z;
    }

    public void resume() {
        com.baidu.adp.gif.c cVar;
        if (this.Zw != null && (cVar = this.Zw.get()) != null) {
            this.ZV = false;
            if (this.isHide) {
                setVisibility(4);
                return;
            }
            this.ZT.onStart();
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageDelayed(1, cVar.x(this.Zx));
            this.mHandler.sendEmptyMessageDelayed(2, 2000L);
        }
    }

    public void stop() {
        com.baidu.adp.gif.c cVar;
        if (this.Zw != null && (cVar = this.Zw.get()) != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.Zx = 0;
            cVar.w(0);
            cVar.a(this.mBitmap, null);
            invalidate();
        }
    }

    public void play() {
        com.baidu.adp.gif.c cVar;
        if (this.Zw != null && (cVar = this.Zw.get()) != null) {
            this.ZV = false;
            if (this.isHide) {
                setVisibility(4);
                return;
            }
            this.ZT.onStart();
            if (this.Zx != 0) {
                this.Zx = 0;
            }
            cVar.w(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageDelayed(1, cVar.x(this.Zx));
            this.mHandler.sendEmptyMessageDelayed(2, 2000L);
        }
    }

    public void setPlayOnce(boolean z) {
        this.ZN = z;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        vE();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.mHandler.removeMessages(1);
        vE();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 4 || i == 8) {
            this.isHide = true;
            stop();
            if (this.ZT != null) {
                this.ZT.onStop();
            }
        } else if (i == 0) {
            play();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        com.baidu.adp.gif.c cVar;
        if (!this.ZD && !this.ZB) {
            super.onDraw(canvas);
        }
        canvas.save();
        if (this.Zw != null && !this.ZD && !this.ZB && (cVar = this.Zw.get()) != null) {
            cVar.a(null, canvas);
        }
        canvas.restore();
        if (this.ZD && ZF != null) {
            canvas.save();
            canvas.rotate(this.ZE, (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.5f) + getPaddingLeft(), (((getHeight() - getPaddingTop()) - getPaddingBottom()) * 0.5f) + getPaddingTop());
            canvas.drawBitmap(ZF, this.ZL, this.ZK, (Paint) null);
            canvas.restore();
        } else if (this.ZB || (this.ZO != null && this.ZO.Zn)) {
            canvas.save();
            this.ZC.draw(canvas);
            canvas.restore();
        }
    }

    public void setIsLoading(boolean z) {
        if (z) {
            startLoading();
        } else {
            stopLoading();
        }
    }

    public void startLoading() {
        if (!this.ZD) {
            this.ZD = true;
            vD();
        }
    }

    public com.baidu.adp.gif.c getGif() {
        if (this.Zw == null) {
            return null;
        }
        return this.Zw.get();
    }

    public void stopLoading() {
        this.ZD = false;
        removeCallbacks(this);
        invalidate();
    }

    private void vD() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.ZE += this.ZG;
        if (this.ZE > 360.0f - this.ZG) {
            this.ZE = 0.0f;
        }
        invalidate();
        vD();
    }

    public void setPlayCallback(h hVar) {
        this.ZT = hVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
    }

    public void a(a aVar) {
        BdUniqueId bdUniqueId;
        boolean z;
        if (aVar == null) {
            this.ZO = null;
            return;
        }
        boolean zz = com.baidu.tbadk.util.e.zz();
        l B = m.B(getContext());
        if (B != null) {
            bdUniqueId = B.getUniqueId();
            z = B.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        boolean z2 = aVar == this.ZO && this.ZQ == bdUniqueId;
        this.ZU = !z2;
        if (!z2) {
            vE();
        }
        this.ZO = aVar;
        this.ZQ = bdUniqueId;
        String str = zz ? this.ZO.Zq : this.ZO.Zp;
        com.baidu.adp.widget.a.a aVar2 = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.d.ee().a(this.ZO.Zo, 20, this.ZO.Zr, this.ZO.Zo, Boolean.valueOf(zz), str);
        if (aVar2 != null) {
            stopLoading();
            setGif(aVar2);
        } else if (this.ZO.Zn) {
            setGif(null);
        } else {
            startLoading();
            if (!z) {
                com.baidu.adp.lib.f.d.ee().a(this.ZO.Zo, 20, this.ZR, 0, 0, this.ZQ, this.ZO.Zr, this.ZO.Zo, Boolean.valueOf(zz), str);
            }
        }
    }

    public void vE() {
        stopLoading();
        this.ZB = false;
        if (this.ZO != null) {
            com.baidu.adp.lib.f.d.ee().a(this.ZO.Zo, 20, this.ZR);
        }
    }

    @Override // com.baidu.adp.newwidget.a.i
    public void refresh() {
        a(this.ZO);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(this);
        this.mOnClickListener = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ZO != null) {
            boolean zz = com.baidu.tbadk.util.e.zz();
            String str = zz ? this.ZO.Zq : this.ZO.Zp;
            com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.d.ee().a(this.ZO.Zo, 20, this.ZO.Zr, this.ZO.Zo, Boolean.valueOf(zz), str);
            if (aVar != null) {
                this.ZO.Zn = false;
                setGif(aVar);
            } else {
                startLoading();
                com.baidu.adp.lib.f.d.ee().a(this.ZO.Zo, 20, this.ZR, 0, 0, this.ZQ, this.ZO.Zr, this.ZO.Zo, Boolean.valueOf(zz), str);
                return;
            }
        }
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    public void setIsHide(boolean z) {
        this.isHide = z;
    }
}
