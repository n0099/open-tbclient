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
    public static Bitmap aad;
    private WeakReference<com.baidu.adp.gif.c> ZU;
    private int ZV;
    private boolean ZZ;
    private Drawable aaa;
    private boolean aab;
    private float aac;
    private float aae;
    private final Rect aai;
    private final Rect aaj;
    private boolean aak;
    private boolean aal;
    private a aam;
    private BdUniqueId aao;
    private final com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> aap;
    private h aar;
    private boolean aas;
    private boolean aat;
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
        this.aai = new Rect();
        this.aaj = new Rect();
        this.aak = true;
        this.mType = 20;
        this.isHide = false;
        this.aas = false;
        this.aat = false;
        this.mHandler = new f(this, Looper.getMainLooper());
        this.aap = new g(this);
        this.aae = 30.0f;
        BitmapDrawable bitmapDrawable = (BitmapDrawable) getResources().getDrawable(v.loading);
        if (bitmapDrawable != null) {
            aad = bitmapDrawable.getBitmap();
            this.aaj.set(0, 0, aad.getWidth(), aad.getHeight());
        }
        this.aaa = getResources().getDrawable(v.image_group_load_f);
        a(this.aaa);
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
            if (aad != null) {
                int i6 = i5 / 4;
                int i7 = ((i5 - i6) / 2) + paddingLeft;
                int i8 = ((paddingBottom - i6) / 2) + paddingTop;
                this.aai.set(i7, i8, i7 + i6, i6 + i8);
            }
            int intrinsicWidth = this.aaa.getIntrinsicWidth();
            int intrinsicHeight = this.aaa.getIntrinsicHeight();
            if (intrinsicWidth > i5) {
                intrinsicWidth = i5;
            }
            if (intrinsicHeight > paddingBottom) {
                intrinsicHeight = paddingBottom;
            }
            int i9 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
            int i10 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
            this.aaa.setBounds(i9, i10, intrinsicWidth + i9, intrinsicHeight + i10);
        }
    }

    public void setGif(com.baidu.adp.widget.a.a aVar) {
        this.ZZ = false;
        this.aab = false;
        if (this.aam != null) {
            this.aam.ZL = false;
        }
        if (aVar == null) {
            this.ZZ = true;
            if (this.aam != null) {
                this.aam.ZL = true;
            }
            setImageDrawable(null);
            if (this.ZU != null) {
                this.ZU.clear();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.ja()) {
                aVar.a(this);
                this.aab = false;
            }
            if (this.ZU != null) {
                this.ZU.clear();
            }
        } else if (this.ZU == null || !aVar.getGif().equals(this.ZU.get())) {
            if (this.mBitmap == null || this.mBitmap.getWidth() != aVar.getGif().getWidth() || this.mBitmap.getHeight() != aVar.getGif().getHeight() || this.aas) {
                this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
            }
            this.ZU = new WeakReference<>(aVar.getGif());
            aVar.getGif().B(0);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.aak) {
                play();
            }
        } else {
            aVar.getGif().B(this.ZV);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.aak) {
                resume();
            }
        }
    }

    public boolean getAutoPlay() {
        return this.aak;
    }

    public void setAutoPlay(boolean z) {
        this.aak = z;
    }

    public void resume() {
        com.baidu.adp.gif.c cVar;
        if (this.ZU != null && (cVar = this.ZU.get()) != null) {
            this.aat = false;
            if (this.isHide) {
                setVisibility(4);
                return;
            }
            this.aar.onStart();
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageDelayed(1, cVar.C(this.ZV));
            this.mHandler.sendEmptyMessageDelayed(2, 2000L);
        }
    }

    public void stop() {
        com.baidu.adp.gif.c cVar;
        if (this.ZU != null && (cVar = this.ZU.get()) != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.ZV = 0;
            cVar.B(0);
            cVar.a(this.mBitmap, null);
            invalidate();
        }
    }

    public void play() {
        com.baidu.adp.gif.c cVar;
        if (this.ZU != null && (cVar = this.ZU.get()) != null) {
            this.aat = false;
            if (this.isHide) {
                setVisibility(4);
                return;
            }
            this.aar.onStart();
            if (this.ZV != 0) {
                this.ZV = 0;
            }
            cVar.B(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageDelayed(1, cVar.C(this.ZV));
            this.mHandler.sendEmptyMessageDelayed(2, 2000L);
        }
    }

    public void setPlayOnce(boolean z) {
        this.aal = z;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        vQ();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.mHandler.removeMessages(1);
        vQ();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 4 || i == 8) {
            this.isHide = true;
            stop();
            if (this.aar != null) {
                this.aar.onStop();
            }
        } else if (i == 0) {
            play();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        com.baidu.adp.gif.c cVar;
        if (!this.aab && !this.ZZ) {
            super.onDraw(canvas);
        }
        canvas.save();
        if (this.ZU != null && !this.aab && !this.ZZ && (cVar = this.ZU.get()) != null) {
            cVar.a(null, canvas);
        }
        canvas.restore();
        if (this.aab && aad != null) {
            canvas.save();
            canvas.rotate(this.aac, (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.5f) + getPaddingLeft(), (((getHeight() - getPaddingTop()) - getPaddingBottom()) * 0.5f) + getPaddingTop());
            canvas.drawBitmap(aad, this.aaj, this.aai, (Paint) null);
            canvas.restore();
        } else if (this.ZZ || (this.aam != null && this.aam.ZL)) {
            canvas.save();
            this.aaa.draw(canvas);
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
        if (!this.aab) {
            this.aab = true;
            vP();
        }
    }

    public com.baidu.adp.gif.c getGif() {
        if (this.ZU == null) {
            return null;
        }
        return this.ZU.get();
    }

    public void stopLoading() {
        this.aab = false;
        removeCallbacks(this);
        invalidate();
    }

    private void vP() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aac += this.aae;
        if (this.aac > 360.0f - this.aae) {
            this.aac = 0.0f;
        }
        invalidate();
        vP();
    }

    public void setPlayCallback(h hVar) {
        this.aar = hVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
    }

    public void a(a aVar) {
        BdUniqueId bdUniqueId;
        boolean z;
        if (aVar == null) {
            this.aam = null;
            return;
        }
        boolean zM = com.baidu.tbadk.util.h.zM();
        l B = m.B(getContext());
        if (B != null) {
            bdUniqueId = B.getUniqueId();
            z = B.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        boolean z2 = aVar == this.aam && this.aao == bdUniqueId;
        this.aas = !z2;
        if (!z2) {
            vQ();
        }
        this.aam = aVar;
        this.aao = bdUniqueId;
        String str = zM ? this.aam.ZO : this.aam.ZN;
        com.baidu.adp.widget.a.a aVar2 = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.d.ec().a(this.aam.ZM, 20, this.aam.ZP, this.aam.ZM, Boolean.valueOf(zM), str);
        if (aVar2 != null) {
            stopLoading();
            setGif(aVar2);
        } else if (this.aam.ZL) {
            setGif(null);
        } else {
            startLoading();
            if (!z) {
                com.baidu.adp.lib.f.d.ec().a(this.aam.ZM, 20, this.aap, 0, 0, this.aao, this.aam.ZP, this.aam.ZM, Boolean.valueOf(zM), str);
            }
        }
    }

    public void vQ() {
        stopLoading();
        this.ZZ = false;
        if (this.aam != null) {
            com.baidu.adp.lib.f.d.ec().a(this.aam.ZM, 20, this.aap);
        }
    }

    @Override // com.baidu.adp.newwidget.a.i
    public void refresh() {
        a(this.aam);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(this);
        this.mOnClickListener = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aam != null) {
            boolean zM = com.baidu.tbadk.util.h.zM();
            String str = zM ? this.aam.ZO : this.aam.ZN;
            com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.d.ec().a(this.aam.ZM, 20, this.aam.ZP, this.aam.ZM, Boolean.valueOf(zM), str);
            if (aVar != null) {
                this.aam.ZL = false;
                setGif(aVar);
            } else {
                startLoading();
                com.baidu.adp.lib.f.d.ec().a(this.aam.ZM, 20, this.aap, 0, 0, this.aao, this.aam.ZP, this.aam.ZM, Boolean.valueOf(zM), str);
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
