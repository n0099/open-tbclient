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
    public static Bitmap aag;
    private WeakReference<com.baidu.adp.gif.c> ZX;
    private int ZY;
    private boolean aac;
    private Drawable aad;
    private boolean aae;
    private float aaf;
    private float aah;
    private final Rect aal;
    private final Rect aam;
    private boolean aan;
    private boolean aao;
    private a aap;
    private BdUniqueId aar;
    private final com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> aas;
    private h aau;
    private boolean aav;
    private boolean aaw;
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
        this.aal = new Rect();
        this.aam = new Rect();
        this.aan = true;
        this.mType = 20;
        this.isHide = false;
        this.aav = false;
        this.aaw = false;
        this.mHandler = new f(this, Looper.getMainLooper());
        this.aas = new g(this);
        this.aah = 30.0f;
        BitmapDrawable bitmapDrawable = (BitmapDrawable) getResources().getDrawable(v.loading);
        if (bitmapDrawable != null) {
            aag = bitmapDrawable.getBitmap();
            this.aam.set(0, 0, aag.getWidth(), aag.getHeight());
        }
        this.aad = getResources().getDrawable(v.image_group_load_f);
        a(this.aad);
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
            if (aag != null) {
                int i6 = i5 / 4;
                int i7 = ((i5 - i6) / 2) + paddingLeft;
                int i8 = ((paddingBottom - i6) / 2) + paddingTop;
                this.aal.set(i7, i8, i7 + i6, i6 + i8);
            }
            int intrinsicWidth = this.aad.getIntrinsicWidth();
            int intrinsicHeight = this.aad.getIntrinsicHeight();
            if (intrinsicWidth > i5) {
                intrinsicWidth = i5;
            }
            if (intrinsicHeight > paddingBottom) {
                intrinsicHeight = paddingBottom;
            }
            int i9 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
            int i10 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
            this.aad.setBounds(i9, i10, intrinsicWidth + i9, intrinsicHeight + i10);
        }
    }

    public void setGif(com.baidu.adp.widget.a.a aVar) {
        this.aac = false;
        this.aae = false;
        if (this.aap != null) {
            this.aap.ZO = false;
        }
        if (aVar == null) {
            this.aac = true;
            if (this.aap != null) {
                this.aap.ZO = true;
            }
            setImageDrawable(null);
            if (this.ZX != null) {
                this.ZX.clear();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.jh()) {
                aVar.a(this);
                this.aae = false;
            }
            if (this.ZX != null) {
                this.ZX.clear();
            }
        } else if (this.ZX == null || !aVar.getGif().equals(this.ZX.get())) {
            if (this.mBitmap == null || this.mBitmap.getWidth() != aVar.getGif().getWidth() || this.mBitmap.getHeight() != aVar.getGif().getHeight() || this.aav) {
                this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
            }
            this.ZX = new WeakReference<>(aVar.getGif());
            aVar.getGif().B(0);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.aan) {
                play();
            }
        } else {
            aVar.getGif().B(this.ZY);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.aan) {
                resume();
            }
        }
    }

    public boolean getAutoPlay() {
        return this.aan;
    }

    public void setAutoPlay(boolean z) {
        this.aan = z;
    }

    public void resume() {
        com.baidu.adp.gif.c cVar;
        if (this.ZX != null && (cVar = this.ZX.get()) != null) {
            this.aaw = false;
            if (this.isHide) {
                setVisibility(4);
                return;
            }
            this.aau.onStart();
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageDelayed(1, cVar.C(this.ZY));
            this.mHandler.sendEmptyMessageDelayed(2, 2000L);
        }
    }

    public void stop() {
        com.baidu.adp.gif.c cVar;
        if (this.ZX != null && (cVar = this.ZX.get()) != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.ZY = 0;
            cVar.B(0);
            cVar.a(this.mBitmap, null);
            invalidate();
        }
    }

    public void play() {
        com.baidu.adp.gif.c cVar;
        if (this.ZX != null && (cVar = this.ZX.get()) != null) {
            this.aaw = false;
            if (this.isHide) {
                setVisibility(4);
                return;
            }
            this.aau.onStart();
            if (this.ZY != 0) {
                this.ZY = 0;
            }
            cVar.B(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageDelayed(1, cVar.C(this.ZY));
            this.mHandler.sendEmptyMessageDelayed(2, 2000L);
        }
    }

    public void setPlayOnce(boolean z) {
        this.aao = z;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        vW();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.mHandler.removeMessages(1);
        vW();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 4 || i == 8) {
            this.isHide = true;
            stop();
            if (this.aau != null) {
                this.aau.onStop();
            }
        } else if (i == 0) {
            play();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        com.baidu.adp.gif.c cVar;
        if (!this.aae && !this.aac) {
            super.onDraw(canvas);
        }
        canvas.save();
        if (this.ZX != null && !this.aae && !this.aac && (cVar = this.ZX.get()) != null) {
            cVar.a(null, canvas);
        }
        canvas.restore();
        if (this.aae && aag != null) {
            canvas.save();
            canvas.rotate(this.aaf, (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.5f) + getPaddingLeft(), (((getHeight() - getPaddingTop()) - getPaddingBottom()) * 0.5f) + getPaddingTop());
            canvas.drawBitmap(aag, this.aam, this.aal, (Paint) null);
            canvas.restore();
        } else if (this.aac || (this.aap != null && this.aap.ZO)) {
            canvas.save();
            this.aad.draw(canvas);
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
        if (!this.aae) {
            this.aae = true;
            vV();
        }
    }

    public com.baidu.adp.gif.c getGif() {
        if (this.ZX == null) {
            return null;
        }
        return this.ZX.get();
    }

    public void stopLoading() {
        this.aae = false;
        removeCallbacks(this);
        invalidate();
    }

    private void vV() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aaf += this.aah;
        if (this.aaf > 360.0f - this.aah) {
            this.aaf = 0.0f;
        }
        invalidate();
        vV();
    }

    public void setPlayCallback(h hVar) {
        this.aau = hVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
    }

    public void a(a aVar) {
        BdUniqueId bdUniqueId;
        boolean z;
        if (aVar == null) {
            this.aap = null;
            return;
        }
        boolean zS = com.baidu.tbadk.util.h.zS();
        l B = m.B(getContext());
        if (B != null) {
            bdUniqueId = B.getUniqueId();
            z = B.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        boolean z2 = aVar == this.aap && this.aar == bdUniqueId;
        this.aav = !z2;
        if (!z2) {
            vW();
        }
        this.aap = aVar;
        this.aar = bdUniqueId;
        String str = zS ? this.aap.ZR : this.aap.ZQ;
        com.baidu.adp.widget.a.a aVar2 = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.d.ec().a(this.aap.ZP, 20, this.aap.ZS, this.aap.ZP, Boolean.valueOf(zS), str);
        if (aVar2 != null) {
            stopLoading();
            setGif(aVar2);
        } else if (this.aap.ZO) {
            setGif(null);
        } else {
            startLoading();
            if (!z) {
                com.baidu.adp.lib.f.d.ec().a(this.aap.ZP, 20, this.aas, 0, 0, this.aar, this.aap.ZS, this.aap.ZP, Boolean.valueOf(zS), str);
            }
        }
    }

    public void vW() {
        stopLoading();
        this.aac = false;
        if (this.aap != null) {
            com.baidu.adp.lib.f.d.ec().a(this.aap.ZP, 20, this.aas);
        }
    }

    @Override // com.baidu.adp.newwidget.a.i
    public void refresh() {
        a(this.aap);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(this);
        this.mOnClickListener = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aap != null) {
            boolean zS = com.baidu.tbadk.util.h.zS();
            String str = zS ? this.aap.ZR : this.aap.ZQ;
            com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.d.ec().a(this.aap.ZP, 20, this.aap.ZS, this.aap.ZP, Boolean.valueOf(zS), str);
            if (aVar != null) {
                this.aap.ZO = false;
                setGif(aVar);
            } else {
                startLoading();
                com.baidu.adp.lib.f.d.ec().a(this.aap.ZP, 20, this.aas, 0, 0, this.aar, this.aap.ZS, this.aap.ZP, Boolean.valueOf(zS), str);
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
