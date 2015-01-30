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
import com.baidu.adp.base.m;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.newwidget.a.i;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.v;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class GifView extends ImageView implements View.OnClickListener, i, Runnable {
    public static Bitmap aag;
    private final int ZW;
    private WeakReference<com.baidu.adp.gif.c> ZX;
    private int ZY;
    private e ZZ;
    private boolean aaa;
    private BitmapDrawable aab;
    private boolean aac;
    private Drawable aad;
    private boolean aae;
    private float aaf;
    private float aah;
    private boolean aai;
    private Drawable aaj;
    private int aak;
    private final Rect aal;
    private final Rect aam;
    private boolean aan;
    private boolean aao;
    private a aap;
    private boolean aaq;
    private BdUniqueId aar;
    private final com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> aas;
    private Bitmap mBitmap;
    private final Handler mHandler;
    private View.OnClickListener mOnClickListener;
    private final int mType;

    public GifView(Context context) {
        this(context, null, 0);
    }

    public GifView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GifView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ZW = v.pic_expression_upload_selector;
        this.aaa = false;
        this.aal = new Rect();
        this.aam = new Rect();
        this.aan = true;
        this.mHandler = new b(this, Looper.getMainLooper());
        this.mType = 20;
        this.aaq = true;
        this.aas = new c(this);
        this.aab = (BitmapDrawable) getResources().getDrawable(v.icon_content_animation);
        this.aab.setBounds(0, 0, this.aab.getIntrinsicWidth(), this.aab.getIntrinsicHeight());
        this.aah = 30.0f;
        if (((BitmapDrawable) getResources().getDrawable(v.loading)) != null) {
            aag = a(this);
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
            if (a(this) != null) {
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
            if (this.aaj != null) {
                int intrinsicWidth2 = this.aaj.getIntrinsicWidth();
                int intrinsicHeight2 = this.aaj.getIntrinsicHeight();
                if (intrinsicWidth2 > i5) {
                    intrinsicWidth2 = i5;
                }
                if (intrinsicHeight2 > paddingBottom) {
                    intrinsicHeight2 = paddingBottom;
                }
                int i11 = ((i5 - intrinsicWidth2) / 2) + paddingLeft;
                int i12 = ((paddingBottom - intrinsicHeight2) / 2) + paddingTop;
                this.aaj.setBounds(i11, i12, intrinsicWidth2 + i11, intrinsicHeight2 + i12);
            }
        }
    }

    public static void releaseBitmap() {
        if (aag != null) {
            if (l.ft()) {
                aag = null;
            } else {
                new Handler(Looper.getMainLooper()).post(new d());
            }
        }
    }

    public void setGif(com.baidu.adp.widget.a.a aVar) {
        this.aac = false;
        this.aae = false;
        this.aai = false;
        if (this.aap != null) {
            this.aap.ZO = false;
        }
        if (aVar == null) {
            this.aac = true;
            this.aaa = false;
            if (this.aap != null) {
                this.aap.ZO = true;
            }
            setImageDrawable(null);
            if (this.ZX != null) {
                this.ZX.clear();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.jh()) {
                this.aaa = true;
                aVar.a(this);
                this.aae = false;
            }
            if (this.ZX != null) {
                this.ZX.clear();
            }
        } else if (this.ZX == null || !aVar.getGif().equals(this.ZX.get())) {
            this.aaa = false;
            if (this.mBitmap == null || (this.mBitmap.getWidth() != aVar.getGif().getWidth() && this.mBitmap.getHeight() != aVar.getGif().getHeight())) {
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
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, cVar.C(this.ZY));
        }
    }

    public void stop() {
        com.baidu.adp.gif.c cVar;
        if (this.ZX != null && (cVar = this.ZX.get()) != null) {
            this.mHandler.removeMessages(1);
            cVar.B(0);
            cVar.a(this.mBitmap, null);
            invalidate();
        }
    }

    public void play() {
        com.baidu.adp.gif.c cVar;
        if (this.ZX != null && (cVar = this.ZX.get()) != null) {
            if (this.ZY != 0) {
                this.ZY = 0;
            }
            cVar.B(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, cVar.C(this.ZY));
        }
    }

    public void onDestroy() {
        this.ZX = null;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandler.removeMessages(1);
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
        if (!this.aaa) {
            if (i == 4 || i == 8) {
                stop();
            } else if (i == 0) {
                play();
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        com.baidu.adp.gif.c cVar;
        if (!this.aae && !this.aac && !this.aai) {
            super.onDraw(canvas);
        }
        canvas.save();
        if (this.ZX != null && !this.aae && !this.aac && !this.aai && (cVar = this.ZX.get()) != null) {
            cVar.a(null, canvas);
        }
        canvas.restore();
        if (this.aaa) {
            canvas.save();
            this.aab.draw(canvas);
            canvas.restore();
        }
        if (this.aae && a(this) != null) {
            canvas.save();
            canvas.rotate(this.aaf, (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.5f) + getPaddingLeft(), (((getHeight() - getPaddingTop()) - getPaddingBottom()) * 0.5f) + getPaddingTop());
            canvas.drawBitmap(a(this), this.aam, this.aal, (Paint) null);
            canvas.restore();
        } else if (this.aac || (this.aap != null && this.aap.ZO)) {
            canvas.save();
            this.aad.draw(canvas);
            canvas.restore();
        } else if (this.aai) {
            canvas.save();
            this.aaj.draw(canvas);
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

    public void b(boolean z, int i) {
        this.aai = z;
        if (z) {
            this.aae = false;
            this.aac = false;
            if (this.aaj == null || this.aak != i) {
                this.aak = i;
                this.aaj = bc.getDrawable(i);
                int intrinsicWidth = this.aaj.getIntrinsicWidth();
                int intrinsicHeight = this.aaj.getIntrinsicHeight();
                int measuredWidth = getMeasuredWidth();
                int measuredHeight = getMeasuredHeight();
                if (intrinsicWidth > measuredWidth) {
                    intrinsicWidth = measuredWidth;
                }
                if (intrinsicHeight > measuredHeight) {
                    intrinsicHeight = measuredHeight;
                }
                int paddingLeft = ((measuredWidth - intrinsicWidth) / 2) + getPaddingLeft();
                int paddingTop = ((measuredHeight - intrinsicHeight) / 2) + getPaddingTop();
                this.aaj.setBounds(paddingLeft, paddingTop, intrinsicWidth + paddingLeft, intrinsicHeight + paddingTop);
            }
        }
        invalidate();
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

    public void setPlayCallback(e eVar) {
        this.ZZ = eVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.aaj != null && this.aaj.isStateful()) {
            this.aaj.setState(getDrawableState());
            invalidate();
        }
    }

    public void a(a aVar) {
        BdUniqueId bdUniqueId;
        boolean z;
        if (aVar == null) {
            this.aap = null;
            return;
        }
        boolean zS = com.baidu.tbadk.util.h.zS();
        com.baidu.adp.base.l B = m.B(getContext());
        if (B != null) {
            bdUniqueId = B.getUniqueId();
            z = B.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        if (!(aVar == this.aap && this.aar == bdUniqueId)) {
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
        } else if (!com.baidu.adp.lib.f.d.ec().W(20) && this.aaq) {
            b(true, this.ZW);
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
        this.aai = false;
        if (this.aap != null) {
            com.baidu.adp.lib.f.d.ec().a(this.aap.ZP, 20, this.aas);
        }
    }

    @Override // com.baidu.adp.newwidget.a.i
    public void refresh() {
        a(this.aap);
    }

    public void setSupportNoImage(boolean z) {
        this.aaq = z;
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

    public static Bitmap a(GifView gifView) {
        if (aag != null && !aag.isRecycled()) {
            return aag;
        }
        BitmapDrawable bitmapDrawable = (BitmapDrawable) gifView.getResources().getDrawable(v.loading);
        if (bitmapDrawable != null) {
            aag = bitmapDrawable.getBitmap();
        }
        return aag;
    }
}
