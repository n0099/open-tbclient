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
import com.baidu.tbadk.util.h;
import com.baidu.tieba.t;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class GiftGifView extends ImageView implements View.OnClickListener, i, Runnable {
    public static Bitmap axl;
    private final com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> axA;
    private WeakReference<com.baidu.adp.gif.b> axC;
    private a axD;
    private boolean axE;
    private boolean axF;
    private int axe;
    private boolean axi;
    private Drawable axj;
    private float axk;
    private float axm;
    private final Rect axq;
    private final Rect axr;
    private boolean axs;
    private boolean axw;
    private com.baidu.tbadk.gif.a axx;
    private BdUniqueId axz;
    private boolean isHide;
    private Bitmap mBitmap;
    private final Handler mHandler;
    private boolean mIsLoading;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes.dex */
    public interface a {
        void EM();

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
        this.axq = new Rect();
        this.axr = new Rect();
        this.axs = true;
        this.isHide = false;
        this.axE = false;
        this.axF = false;
        this.mHandler = new d(this, Looper.getMainLooper());
        this.axA = new e(this);
        this.axm = 30.0f;
        BitmapDrawable bitmapDrawable = (BitmapDrawable) getResources().getDrawable(t.f.loading);
        if (bitmapDrawable != null) {
            axl = bitmapDrawable.getBitmap();
            this.axr.set(0, 0, axl.getWidth(), axl.getHeight());
        }
        this.axj = getResources().getDrawable(t.f.image_group_load_f);
        c(this.axj);
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
            if (axl != null) {
                int i6 = i5 / 4;
                int i7 = ((i5 - i6) / 2) + paddingLeft;
                int i8 = ((paddingBottom - i6) / 2) + paddingTop;
                this.axq.set(i7, i8, i7 + i6, i6 + i8);
            }
            int intrinsicWidth = this.axj.getIntrinsicWidth();
            int intrinsicHeight = this.axj.getIntrinsicHeight();
            if (intrinsicWidth > i5) {
                intrinsicWidth = i5;
            }
            if (intrinsicHeight > paddingBottom) {
                intrinsicHeight = paddingBottom;
            }
            int i9 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
            int i10 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
            this.axj.setBounds(i9, i10, intrinsicWidth + i9, intrinsicHeight + i10);
        }
    }

    public void setGif(com.baidu.adp.widget.a.a aVar) {
        this.axi = false;
        this.mIsLoading = false;
        if (this.axx != null) {
            this.axx.awX = false;
        }
        if (aVar == null) {
            this.axi = true;
            if (this.axx != null) {
                this.axx.awX = true;
            }
            setImageDrawable(null);
            if (this.axC != null) {
                this.axC.clear();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.mI()) {
                aVar.a(this);
                this.mIsLoading = false;
            }
            if (this.axC != null) {
                this.axC.clear();
            }
        } else if (this.axC == null || !aVar.getGif().equals(this.axC.get())) {
            if (this.mBitmap == null || this.mBitmap.getWidth() != aVar.getGif().getWidth() || this.mBitmap.getHeight() != aVar.getGif().getHeight() || this.axE) {
                this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
            }
            this.axC = new WeakReference<>(aVar.getGif());
            aVar.getGif().Q(0);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.axs) {
                play();
            }
        } else {
            aVar.getGif().Q(this.axe);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.axs) {
                resume();
            }
        }
    }

    public boolean getAutoPlay() {
        return this.axs;
    }

    public void setAutoPlay(boolean z) {
        this.axs = z;
    }

    public void resume() {
        com.baidu.adp.gif.b bVar;
        if (this.axC != null && (bVar = this.axC.get()) != null) {
            this.axF = false;
            if (this.isHide) {
                setVisibility(4);
                return;
            }
            this.axD.onStart();
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageDelayed(1, bVar.R(this.axe));
            this.mHandler.sendEmptyMessageDelayed(2, 2000L);
        }
    }

    public void stop() {
        com.baidu.adp.gif.b bVar;
        if (this.axC != null && (bVar = this.axC.get()) != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.axe = 0;
            bVar.Q(0);
            bVar.a(this.mBitmap, null);
            invalidate();
        }
    }

    public void play() {
        com.baidu.adp.gif.b bVar;
        if (this.axC != null && (bVar = this.axC.get()) != null) {
            this.axF = false;
            if (this.isHide) {
                setVisibility(4);
                return;
            }
            this.axD.onStart();
            if (this.axe != 0) {
                this.axe = 0;
            }
            bVar.Q(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageDelayed(1, bVar.R(this.axe));
            this.mHandler.sendEmptyMessageDelayed(2, 2000L);
        }
    }

    public void setPlayOnce(boolean z) {
        this.axw = z;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        EL();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.mHandler.removeMessages(1);
        EL();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 4 || i == 8) {
            this.isHide = true;
            stop();
            if (this.axD != null) {
                this.axD.onStop();
            }
        } else if (i == 0) {
            play();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        com.baidu.adp.gif.b bVar;
        if (!this.mIsLoading && !this.axi) {
            super.onDraw(canvas);
        }
        canvas.save();
        if (this.axC != null && !this.mIsLoading && !this.axi && (bVar = this.axC.get()) != null) {
            bVar.a(null, canvas);
        }
        canvas.restore();
        if (this.mIsLoading && axl != null) {
            canvas.save();
            canvas.rotate(this.axk, (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.5f) + getPaddingLeft(), (((getHeight() - getPaddingTop()) - getPaddingBottom()) * 0.5f) + getPaddingTop());
            canvas.drawBitmap(axl, this.axr, this.axq, (Paint) null);
            canvas.restore();
        } else if (this.axi || (this.axx != null && this.axx.awX)) {
            canvas.save();
            this.axj.draw(canvas);
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
            EK();
        }
    }

    public com.baidu.adp.gif.b getGif() {
        if (this.axC == null) {
            return null;
        }
        return this.axC.get();
    }

    public void stopLoading() {
        this.mIsLoading = false;
        removeCallbacks(this);
        invalidate();
    }

    private void EK() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.axk += this.axm;
        if (this.axk > 360.0f - this.axm) {
            this.axk = 0.0f;
        }
        invalidate();
        EK();
    }

    public void setPlayCallback(a aVar) {
        this.axD = aVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
    }

    public void a(com.baidu.tbadk.gif.a aVar) {
        BdUniqueId bdUniqueId;
        boolean z;
        if (aVar == null) {
            this.axx = null;
            return;
        }
        boolean Ht = h.Ht();
        k q = l.q(getContext());
        if (q != null) {
            bdUniqueId = q.getUniqueId();
            z = q.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        boolean z2 = aVar == this.axx && this.axz == bdUniqueId;
        this.axE = !z2;
        if (!z2) {
            EL();
        }
        this.axx = aVar;
        this.axz = bdUniqueId;
        String str = Ht ? this.axx.axa : this.axx.awZ;
        com.baidu.adp.widget.a.a aVar2 = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.g.c.hr().a(this.axx.awY, 20, this.axx.mGid, this.axx.awY, Boolean.valueOf(Ht), str);
        if (aVar2 != null) {
            stopLoading();
            setGif(aVar2);
        } else if (this.axx.awX) {
            setGif(null);
        } else {
            startLoading();
            if (!z) {
                com.baidu.adp.lib.g.c.hr().a(this.axx.awY, 20, this.axA, 0, 0, this.axz, this.axx.mGid, this.axx.awY, Boolean.valueOf(Ht), str);
            }
        }
    }

    public void EL() {
        stopLoading();
        this.axi = false;
        if (this.axx != null) {
            com.baidu.adp.lib.g.c.hr().a(this.axx.awY, 20, this.axA);
        }
    }

    @Override // com.baidu.adp.newwidget.a.i
    public void refresh() {
        a(this.axx);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(this);
        this.mOnClickListener = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.axx != null) {
            boolean Ht = h.Ht();
            String str = Ht ? this.axx.axa : this.axx.awZ;
            com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.g.c.hr().a(this.axx.awY, 20, this.axx.mGid, this.axx.awY, Boolean.valueOf(Ht), str);
            if (aVar != null) {
                this.axx.awX = false;
                setGif(aVar);
            } else {
                startLoading();
                com.baidu.adp.lib.g.c.hr().a(this.axx.awY, 20, this.axA, 0, 0, this.axz, this.axx.mGid, this.axx.awY, Boolean.valueOf(Ht), str);
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
