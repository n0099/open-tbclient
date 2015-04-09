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
    public static Bitmap akJ;
    private WeakReference<com.baidu.adp.gif.c> akA;
    private int akB;
    private boolean akF;
    private Drawable akG;
    private boolean akH;
    private float akI;
    private float akK;
    private final Rect akO;
    private final Rect akP;
    private boolean akQ;
    private boolean akR;
    private a akS;
    private BdUniqueId akU;
    private final com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> akV;
    private h akX;
    private boolean akY;
    private boolean akZ;
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
        this.akO = new Rect();
        this.akP = new Rect();
        this.akQ = true;
        this.mType = 20;
        this.isHide = false;
        this.akY = false;
        this.akZ = false;
        this.mHandler = new f(this, Looper.getMainLooper());
        this.akV = new g(this);
        this.akK = 30.0f;
        BitmapDrawable bitmapDrawable = (BitmapDrawable) getResources().getDrawable(u.loading);
        if (bitmapDrawable != null) {
            akJ = bitmapDrawable.getBitmap();
            this.akP.set(0, 0, akJ.getWidth(), akJ.getHeight());
        }
        this.akG = getResources().getDrawable(u.image_group_load_f);
        a(this.akG);
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
            if (akJ != null) {
                int i6 = i5 / 4;
                int i7 = ((i5 - i6) / 2) + paddingLeft;
                int i8 = ((paddingBottom - i6) / 2) + paddingTop;
                this.akO.set(i7, i8, i7 + i6, i6 + i8);
            }
            int intrinsicWidth = this.akG.getIntrinsicWidth();
            int intrinsicHeight = this.akG.getIntrinsicHeight();
            if (intrinsicWidth > i5) {
                intrinsicWidth = i5;
            }
            if (intrinsicHeight > paddingBottom) {
                intrinsicHeight = paddingBottom;
            }
            int i9 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
            int i10 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
            this.akG.setBounds(i9, i10, intrinsicWidth + i9, intrinsicHeight + i10);
        }
    }

    public void setGif(com.baidu.adp.widget.a.a aVar) {
        this.akF = false;
        this.akH = false;
        if (this.akS != null) {
            this.akS.akr = false;
        }
        if (aVar == null) {
            this.akF = true;
            if (this.akS != null) {
                this.akS.akr = true;
            }
            setImageDrawable(null);
            if (this.akA != null) {
                this.akA.clear();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.mx()) {
                aVar.a(this);
                this.akH = false;
            }
            if (this.akA != null) {
                this.akA.clear();
            }
        } else if (this.akA == null || !aVar.getGif().equals(this.akA.get())) {
            if (this.mBitmap == null || this.mBitmap.getWidth() != aVar.getGif().getWidth() || this.mBitmap.getHeight() != aVar.getGif().getHeight() || this.akY) {
                this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
            }
            this.akA = new WeakReference<>(aVar.getGif());
            aVar.getGif().C(0);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.akQ) {
                play();
            }
        } else {
            aVar.getGif().C(this.akB);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.akQ) {
                resume();
            }
        }
    }

    public boolean getAutoPlay() {
        return this.akQ;
    }

    public void setAutoPlay(boolean z) {
        this.akQ = z;
    }

    public void resume() {
        com.baidu.adp.gif.c cVar;
        if (this.akA != null && (cVar = this.akA.get()) != null) {
            this.akZ = false;
            if (this.isHide) {
                setVisibility(4);
                return;
            }
            this.akX.onStart();
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageDelayed(1, cVar.D(this.akB));
            this.mHandler.sendEmptyMessageDelayed(2, 2000L);
        }
    }

    public void stop() {
        com.baidu.adp.gif.c cVar;
        if (this.akA != null && (cVar = this.akA.get()) != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.akB = 0;
            cVar.C(0);
            cVar.a(this.mBitmap, null);
            invalidate();
        }
    }

    public void play() {
        com.baidu.adp.gif.c cVar;
        if (this.akA != null && (cVar = this.akA.get()) != null) {
            this.akZ = false;
            if (this.isHide) {
                setVisibility(4);
                return;
            }
            this.akX.onStart();
            if (this.akB != 0) {
                this.akB = 0;
            }
            cVar.C(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageDelayed(1, cVar.D(this.akB));
            this.mHandler.sendEmptyMessageDelayed(2, 2000L);
        }
    }

    public void setPlayOnce(boolean z) {
        this.akR = z;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        zw();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.mHandler.removeMessages(1);
        zw();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 4 || i == 8) {
            this.isHide = true;
            stop();
            if (this.akX != null) {
                this.akX.onStop();
            }
        } else if (i == 0) {
            play();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        com.baidu.adp.gif.c cVar;
        if (!this.akH && !this.akF) {
            super.onDraw(canvas);
        }
        canvas.save();
        if (this.akA != null && !this.akH && !this.akF && (cVar = this.akA.get()) != null) {
            cVar.a(null, canvas);
        }
        canvas.restore();
        if (this.akH && akJ != null) {
            canvas.save();
            canvas.rotate(this.akI, (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.5f) + getPaddingLeft(), (((getHeight() - getPaddingTop()) - getPaddingBottom()) * 0.5f) + getPaddingTop());
            canvas.drawBitmap(akJ, this.akP, this.akO, (Paint) null);
            canvas.restore();
        } else if (this.akF || (this.akS != null && this.akS.akr)) {
            canvas.save();
            this.akG.draw(canvas);
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
        if (!this.akH) {
            this.akH = true;
            zv();
        }
    }

    public com.baidu.adp.gif.c getGif() {
        if (this.akA == null) {
            return null;
        }
        return this.akA.get();
    }

    public void stopLoading() {
        this.akH = false;
        removeCallbacks(this);
        invalidate();
    }

    private void zv() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.akI += this.akK;
        if (this.akI > 360.0f - this.akK) {
            this.akI = 0.0f;
        }
        invalidate();
        zv();
    }

    public void setPlayCallback(h hVar) {
        this.akX = hVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
    }

    public void a(a aVar) {
        BdUniqueId bdUniqueId;
        boolean z;
        if (aVar == null) {
            this.akS = null;
            return;
        }
        boolean Dm = com.baidu.tbadk.util.g.Dm();
        l B = m.B(getContext());
        if (B != null) {
            bdUniqueId = B.getUniqueId();
            z = B.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        boolean z2 = aVar == this.akS && this.akU == bdUniqueId;
        this.akY = !z2;
        if (!z2) {
            zw();
        }
        this.akS = aVar;
        this.akU = bdUniqueId;
        String str = Dm ? this.akS.aku : this.akS.akt;
        com.baidu.adp.widget.a.a aVar2 = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.d.hB().a(this.akS.aks, 20, this.akS.akv, this.akS.aks, Boolean.valueOf(Dm), str);
        if (aVar2 != null) {
            stopLoading();
            setGif(aVar2);
        } else if (this.akS.akr) {
            setGif(null);
        } else {
            startLoading();
            if (!z) {
                com.baidu.adp.lib.f.d.hB().a(this.akS.aks, 20, this.akV, 0, 0, this.akU, this.akS.akv, this.akS.aks, Boolean.valueOf(Dm), str);
            }
        }
    }

    public void zw() {
        stopLoading();
        this.akF = false;
        if (this.akS != null) {
            com.baidu.adp.lib.f.d.hB().a(this.akS.aks, 20, this.akV);
        }
    }

    @Override // com.baidu.adp.newwidget.a.i
    public void refresh() {
        a(this.akS);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(this);
        this.mOnClickListener = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.akS != null) {
            boolean Dm = com.baidu.tbadk.util.g.Dm();
            String str = Dm ? this.akS.aku : this.akS.akt;
            com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.d.hB().a(this.akS.aks, 20, this.akS.akv, this.akS.aks, Boolean.valueOf(Dm), str);
            if (aVar != null) {
                this.akS.akr = false;
                setGif(aVar);
            } else {
                startLoading();
                com.baidu.adp.lib.f.d.hB().a(this.akS.aks, 20, this.akV, 0, 0, this.akU, this.akS.akv, this.akS.aks, Boolean.valueOf(Dm), str);
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
