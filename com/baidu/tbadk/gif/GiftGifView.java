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
import com.baidu.tieba.u;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class GiftGifView extends ImageView implements View.OnClickListener, i, Runnable {
    public static Bitmap akB;
    private float akA;
    private float akC;
    private final Rect akG;
    private final Rect akH;
    private boolean akI;
    private boolean akJ;
    private a akK;
    private BdUniqueId akM;
    private final com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> akN;
    private h akP;
    private boolean akQ;
    private boolean akR;
    private WeakReference<com.baidu.adp.gif.c> aks;
    private int akt;
    private boolean akx;
    private Drawable aky;
    private boolean akz;
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
        this.akG = new Rect();
        this.akH = new Rect();
        this.akI = true;
        this.mType = 20;
        this.isHide = false;
        this.akQ = false;
        this.akR = false;
        this.mHandler = new f(this, Looper.getMainLooper());
        this.akN = new g(this);
        this.akC = 30.0f;
        BitmapDrawable bitmapDrawable = (BitmapDrawable) getResources().getDrawable(u.loading);
        if (bitmapDrawable != null) {
            akB = bitmapDrawable.getBitmap();
            this.akH.set(0, 0, akB.getWidth(), akB.getHeight());
        }
        this.aky = getResources().getDrawable(u.image_group_load_f);
        a(this.aky);
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
            if (akB != null) {
                int i6 = i5 / 4;
                int i7 = ((i5 - i6) / 2) + paddingLeft;
                int i8 = ((paddingBottom - i6) / 2) + paddingTop;
                this.akG.set(i7, i8, i7 + i6, i6 + i8);
            }
            int intrinsicWidth = this.aky.getIntrinsicWidth();
            int intrinsicHeight = this.aky.getIntrinsicHeight();
            if (intrinsicWidth > i5) {
                intrinsicWidth = i5;
            }
            if (intrinsicHeight > paddingBottom) {
                intrinsicHeight = paddingBottom;
            }
            int i9 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
            int i10 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
            this.aky.setBounds(i9, i10, intrinsicWidth + i9, intrinsicHeight + i10);
        }
    }

    public void setGif(com.baidu.adp.widget.a.a aVar) {
        this.akx = false;
        this.akz = false;
        if (this.akK != null) {
            this.akK.akj = false;
        }
        if (aVar == null) {
            this.akx = true;
            if (this.akK != null) {
                this.akK.akj = true;
            }
            setImageDrawable(null);
            if (this.aks != null) {
                this.aks.clear();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.mx()) {
                aVar.a(this);
                this.akz = false;
            }
            if (this.aks != null) {
                this.aks.clear();
            }
        } else if (this.aks == null || !aVar.getGif().equals(this.aks.get())) {
            if (this.mBitmap == null || this.mBitmap.getWidth() != aVar.getGif().getWidth() || this.mBitmap.getHeight() != aVar.getGif().getHeight() || this.akQ) {
                this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
            }
            this.aks = new WeakReference<>(aVar.getGif());
            aVar.getGif().C(0);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.akI) {
                play();
            }
        } else {
            aVar.getGif().C(this.akt);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.akI) {
                resume();
            }
        }
    }

    public boolean getAutoPlay() {
        return this.akI;
    }

    public void setAutoPlay(boolean z) {
        this.akI = z;
    }

    public void resume() {
        com.baidu.adp.gif.c cVar;
        if (this.aks != null && (cVar = this.aks.get()) != null) {
            this.akR = false;
            if (this.isHide) {
                setVisibility(4);
                return;
            }
            this.akP.onStart();
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageDelayed(1, cVar.D(this.akt));
            this.mHandler.sendEmptyMessageDelayed(2, 2000L);
        }
    }

    public void stop() {
        com.baidu.adp.gif.c cVar;
        if (this.aks != null && (cVar = this.aks.get()) != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.akt = 0;
            cVar.C(0);
            cVar.a(this.mBitmap, null);
            invalidate();
        }
    }

    public void play() {
        com.baidu.adp.gif.c cVar;
        if (this.aks != null && (cVar = this.aks.get()) != null) {
            this.akR = false;
            if (this.isHide) {
                setVisibility(4);
                return;
            }
            this.akP.onStart();
            if (this.akt != 0) {
                this.akt = 0;
            }
            cVar.C(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageDelayed(1, cVar.D(this.akt));
            this.mHandler.sendEmptyMessageDelayed(2, 2000L);
        }
    }

    public void setPlayOnce(boolean z) {
        this.akJ = z;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        zq();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.mHandler.removeMessages(1);
        zq();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 4 || i == 8) {
            this.isHide = true;
            stop();
            if (this.akP != null) {
                this.akP.onStop();
            }
        } else if (i == 0) {
            play();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        com.baidu.adp.gif.c cVar;
        if (!this.akz && !this.akx) {
            super.onDraw(canvas);
        }
        canvas.save();
        if (this.aks != null && !this.akz && !this.akx && (cVar = this.aks.get()) != null) {
            cVar.a(null, canvas);
        }
        canvas.restore();
        if (this.akz && akB != null) {
            canvas.save();
            canvas.rotate(this.akA, (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.5f) + getPaddingLeft(), (((getHeight() - getPaddingTop()) - getPaddingBottom()) * 0.5f) + getPaddingTop());
            canvas.drawBitmap(akB, this.akH, this.akG, (Paint) null);
            canvas.restore();
        } else if (this.akx || (this.akK != null && this.akK.akj)) {
            canvas.save();
            this.aky.draw(canvas);
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
        if (!this.akz) {
            this.akz = true;
            zp();
        }
    }

    public com.baidu.adp.gif.c getGif() {
        if (this.aks == null) {
            return null;
        }
        return this.aks.get();
    }

    public void stopLoading() {
        this.akz = false;
        removeCallbacks(this);
        invalidate();
    }

    private void zp() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.akA += this.akC;
        if (this.akA > 360.0f - this.akC) {
            this.akA = 0.0f;
        }
        invalidate();
        zp();
    }

    public void setPlayCallback(h hVar) {
        this.akP = hVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
    }

    public void a(a aVar) {
        BdUniqueId bdUniqueId;
        boolean z;
        if (aVar == null) {
            this.akK = null;
            return;
        }
        boolean Dg = com.baidu.tbadk.util.g.Dg();
        l B = m.B(getContext());
        if (B != null) {
            bdUniqueId = B.getUniqueId();
            z = B.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        boolean z2 = aVar == this.akK && this.akM == bdUniqueId;
        this.akQ = !z2;
        if (!z2) {
            zq();
        }
        this.akK = aVar;
        this.akM = bdUniqueId;
        String str = Dg ? this.akK.akm : this.akK.akl;
        com.baidu.adp.widget.a.a aVar2 = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.d.hB().a(this.akK.akk, 20, this.akK.akn, this.akK.akk, Boolean.valueOf(Dg), str);
        if (aVar2 != null) {
            stopLoading();
            setGif(aVar2);
        } else if (this.akK.akj) {
            setGif(null);
        } else {
            startLoading();
            if (!z) {
                com.baidu.adp.lib.f.d.hB().a(this.akK.akk, 20, this.akN, 0, 0, this.akM, this.akK.akn, this.akK.akk, Boolean.valueOf(Dg), str);
            }
        }
    }

    public void zq() {
        stopLoading();
        this.akx = false;
        if (this.akK != null) {
            com.baidu.adp.lib.f.d.hB().a(this.akK.akk, 20, this.akN);
        }
    }

    @Override // com.baidu.adp.newwidget.a.i
    public void refresh() {
        a(this.akK);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(this);
        this.mOnClickListener = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.akK != null) {
            boolean Dg = com.baidu.tbadk.util.g.Dg();
            String str = Dg ? this.akK.akm : this.akK.akl;
            com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.d.hB().a(this.akK.akk, 20, this.akK.akn, this.akK.akk, Boolean.valueOf(Dg), str);
            if (aVar != null) {
                this.akK.akj = false;
                setGif(aVar);
            } else {
                startLoading();
                com.baidu.adp.lib.f.d.hB().a(this.akK.akk, 20, this.akN, 0, 0, this.akM, this.akK.akn, this.akK.akk, Boolean.valueOf(Dg), str);
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
