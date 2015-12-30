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
import com.baidu.adp.base.k;
import com.baidu.adp.base.l;
import com.baidu.adp.newwidget.a.i;
import com.baidu.tieba.n;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class GiftGifView extends ImageView implements View.OnClickListener, i, Runnable {
    public static Bitmap avN;
    private int avG;
    private boolean avK;
    private Drawable avL;
    private float avM;
    private float avO;
    private final Rect avS;
    private final Rect avT;
    private boolean avU;
    private boolean avY;
    private com.baidu.tbadk.gif.a avZ;
    private BdUniqueId awb;
    private final com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> awc;
    private WeakReference<com.baidu.adp.gif.b> awe;
    private a awf;
    private boolean awg;
    private boolean awh;
    private boolean isHide;
    private Bitmap mBitmap;
    private final Handler mHandler;
    private boolean mIsLoading;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes.dex */
    public interface a {
        void CK();

        void onStart();

        void onStop();
    }

    public GiftGifView(Context context) {
        this(context, null, 0);
    }

    public GiftGifView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GiftGifView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.avS = new Rect();
        this.avT = new Rect();
        this.avU = true;
        this.isHide = false;
        this.awg = false;
        this.awh = false;
        this.mHandler = new d(this, Looper.getMainLooper());
        this.awc = new e(this);
        this.avO = 30.0f;
        BitmapDrawable bitmapDrawable = (BitmapDrawable) getResources().getDrawable(n.f.loading);
        if (bitmapDrawable != null) {
            avN = bitmapDrawable.getBitmap();
            this.avT.set(0, 0, avN.getWidth(), avN.getHeight());
        }
        this.avL = getResources().getDrawable(n.f.image_group_load_f);
        c(this.avL);
    }

    private void c(Drawable drawable) {
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
            if (avN != null) {
                int i6 = i5 / 4;
                int i7 = ((i5 - i6) / 2) + paddingLeft;
                int i8 = ((paddingBottom - i6) / 2) + paddingTop;
                this.avS.set(i7, i8, i7 + i6, i6 + i8);
            }
            int intrinsicWidth = this.avL.getIntrinsicWidth();
            int intrinsicHeight = this.avL.getIntrinsicHeight();
            if (intrinsicWidth > i5) {
                intrinsicWidth = i5;
            }
            if (intrinsicHeight > paddingBottom) {
                intrinsicHeight = paddingBottom;
            }
            int i9 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
            int i10 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
            this.avL.setBounds(i9, i10, intrinsicWidth + i9, intrinsicHeight + i10);
        }
    }

    public void setGif(com.baidu.adp.widget.a.a aVar) {
        this.avK = false;
        this.mIsLoading = false;
        if (this.avZ != null) {
            this.avZ.avy = false;
        }
        if (aVar == null) {
            this.avK = true;
            if (this.avZ != null) {
                this.avZ.avy = true;
            }
            setImageDrawable(null);
            if (this.awe != null) {
                this.awe.clear();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.mC()) {
                aVar.a(this);
                this.mIsLoading = false;
            }
            if (this.awe != null) {
                this.awe.clear();
            }
        } else if (this.awe == null || !aVar.getGif().equals(this.awe.get())) {
            if (this.mBitmap == null || this.mBitmap.getWidth() != aVar.getGif().getWidth() || this.mBitmap.getHeight() != aVar.getGif().getHeight() || this.awg) {
                this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
            }
            this.awe = new WeakReference<>(aVar.getGif());
            aVar.getGif().G(0);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.avU) {
                play();
            }
        } else {
            aVar.getGif().G(this.avG);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.avU) {
                resume();
            }
        }
    }

    public boolean getAutoPlay() {
        return this.avU;
    }

    public void setAutoPlay(boolean z) {
        this.avU = z;
    }

    public void resume() {
        com.baidu.adp.gif.b bVar;
        if (this.awe != null && (bVar = this.awe.get()) != null) {
            this.awh = false;
            if (this.isHide) {
                setVisibility(4);
                return;
            }
            this.awf.onStart();
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageDelayed(1, bVar.H(this.avG));
            this.mHandler.sendEmptyMessageDelayed(2, 2000L);
        }
    }

    public void stop() {
        com.baidu.adp.gif.b bVar;
        if (this.awe != null && (bVar = this.awe.get()) != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.avG = 0;
            bVar.G(0);
            bVar.a(this.mBitmap, null);
            invalidate();
        }
    }

    public void play() {
        com.baidu.adp.gif.b bVar;
        if (this.awe != null && (bVar = this.awe.get()) != null) {
            this.awh = false;
            if (this.isHide) {
                setVisibility(4);
                return;
            }
            this.awf.onStart();
            if (this.avG != 0) {
                this.avG = 0;
            }
            bVar.G(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageDelayed(1, bVar.H(this.avG));
            this.mHandler.sendEmptyMessageDelayed(2, 2000L);
        }
    }

    public void setPlayOnce(boolean z) {
        this.avY = z;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        CJ();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.mHandler.removeMessages(1);
        CJ();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 4 || i == 8) {
            this.isHide = true;
            stop();
            if (this.awf != null) {
                this.awf.onStop();
            }
        } else if (i == 0) {
            play();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        com.baidu.adp.gif.b bVar;
        if (!this.mIsLoading && !this.avK) {
            super.onDraw(canvas);
        }
        canvas.save();
        if (this.awe != null && !this.mIsLoading && !this.avK && (bVar = this.awe.get()) != null) {
            bVar.a(null, canvas);
        }
        canvas.restore();
        if (this.mIsLoading && avN != null) {
            canvas.save();
            canvas.rotate(this.avM, (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.5f) + getPaddingLeft(), (((getHeight() - getPaddingTop()) - getPaddingBottom()) * 0.5f) + getPaddingTop());
            canvas.drawBitmap(avN, this.avT, this.avS, (Paint) null);
            canvas.restore();
        } else if (this.avK || (this.avZ != null && this.avZ.avy)) {
            canvas.save();
            this.avL.draw(canvas);
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
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            CI();
        }
    }

    public com.baidu.adp.gif.b getGif() {
        if (this.awe == null) {
            return null;
        }
        return this.awe.get();
    }

    public void stopLoading() {
        this.mIsLoading = false;
        removeCallbacks(this);
        invalidate();
    }

    private void CI() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.avM += this.avO;
        if (this.avM > 360.0f - this.avO) {
            this.avM = 0.0f;
        }
        invalidate();
        CI();
    }

    public void setPlayCallback(a aVar) {
        this.awf = aVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
    }

    public void a(com.baidu.tbadk.gif.a aVar) {
        BdUniqueId bdUniqueId;
        boolean z;
        if (aVar == null) {
            this.avZ = null;
            return;
        }
        boolean Ff = com.baidu.tbadk.util.e.Ff();
        k A = l.A(getContext());
        if (A != null) {
            bdUniqueId = A.getUniqueId();
            z = A.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        boolean z2 = aVar == this.avZ && this.awb == bdUniqueId;
        this.awg = !z2;
        if (!z2) {
            CJ();
        }
        this.avZ = aVar;
        this.awb = bdUniqueId;
        String str = Ff ? this.avZ.avB : this.avZ.avA;
        com.baidu.adp.widget.a.a aVar2 = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.g.c.hd().a(this.avZ.avz, 20, this.avZ.mGid, this.avZ.avz, Boolean.valueOf(Ff), str);
        if (aVar2 != null) {
            stopLoading();
            setGif(aVar2);
        } else if (this.avZ.avy) {
            setGif(null);
        } else {
            startLoading();
            if (!z) {
                com.baidu.adp.lib.g.c.hd().a(this.avZ.avz, 20, this.awc, 0, 0, this.awb, this.avZ.mGid, this.avZ.avz, Boolean.valueOf(Ff), str);
            }
        }
    }

    public void CJ() {
        stopLoading();
        this.avK = false;
        if (this.avZ != null) {
            com.baidu.adp.lib.g.c.hd().a(this.avZ.avz, 20, this.awc);
        }
    }

    @Override // com.baidu.adp.newwidget.a.i
    public void refresh() {
        a(this.avZ);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(this);
        this.mOnClickListener = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.avZ != null) {
            boolean Ff = com.baidu.tbadk.util.e.Ff();
            String str = Ff ? this.avZ.avB : this.avZ.avA;
            com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.g.c.hd().a(this.avZ.avz, 20, this.avZ.mGid, this.avZ.avz, Boolean.valueOf(Ff), str);
            if (aVar != null) {
                this.avZ.avy = false;
                setGif(aVar);
            } else {
                startLoading();
                com.baidu.adp.lib.g.c.hd().a(this.avZ.avz, 20, this.awc, 0, 0, this.awb, this.avZ.mGid, this.avZ.avz, Boolean.valueOf(Ff), str);
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
