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
import com.baidu.tieba.t;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class GiftGifView extends ImageView implements View.OnClickListener, i, Runnable {
    public static Bitmap awE;
    private boolean awB;
    private Drawable awC;
    private float awD;
    private float awF;
    private final Rect awJ;
    private final Rect awK;
    private boolean awL;
    private boolean awP;
    private com.baidu.tbadk.gif.a awQ;
    private BdUniqueId awS;
    private final com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> awT;
    private WeakReference<com.baidu.adp.gif.b> awV;
    private a awW;
    private boolean awX;
    private boolean awY;
    private int awx;
    private boolean isHide;
    private Bitmap mBitmap;
    private final Handler mHandler;
    private boolean mIsLoading;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes.dex */
    public interface a {
        void Eb();

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
        this.awJ = new Rect();
        this.awK = new Rect();
        this.awL = true;
        this.isHide = false;
        this.awX = false;
        this.awY = false;
        this.mHandler = new d(this, Looper.getMainLooper());
        this.awT = new e(this);
        this.awF = 30.0f;
        BitmapDrawable bitmapDrawable = (BitmapDrawable) getResources().getDrawable(t.f.loading);
        if (bitmapDrawable != null) {
            awE = bitmapDrawable.getBitmap();
            this.awK.set(0, 0, awE.getWidth(), awE.getHeight());
        }
        this.awC = getResources().getDrawable(t.f.image_group_load_f);
        c(this.awC);
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
            if (awE != null) {
                int i6 = i5 / 4;
                int i7 = ((i5 - i6) / 2) + paddingLeft;
                int i8 = ((paddingBottom - i6) / 2) + paddingTop;
                this.awJ.set(i7, i8, i7 + i6, i6 + i8);
            }
            int intrinsicWidth = this.awC.getIntrinsicWidth();
            int intrinsicHeight = this.awC.getIntrinsicHeight();
            if (intrinsicWidth > i5) {
                intrinsicWidth = i5;
            }
            if (intrinsicHeight > paddingBottom) {
                intrinsicHeight = paddingBottom;
            }
            int i9 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
            int i10 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
            this.awC.setBounds(i9, i10, intrinsicWidth + i9, intrinsicHeight + i10);
        }
    }

    public void setGif(com.baidu.adp.widget.a.a aVar) {
        this.awB = false;
        this.mIsLoading = false;
        if (this.awQ != null) {
            this.awQ.awq = false;
        }
        if (aVar == null) {
            this.awB = true;
            if (this.awQ != null) {
                this.awQ.awq = true;
            }
            setImageDrawable(null);
            if (this.awV != null) {
                this.awV.clear();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.mQ()) {
                aVar.a(this);
                this.mIsLoading = false;
            }
            if (this.awV != null) {
                this.awV.clear();
            }
        } else if (this.awV == null || !aVar.getGif().equals(this.awV.get())) {
            if (this.mBitmap == null || this.mBitmap.getWidth() != aVar.getGif().getWidth() || this.mBitmap.getHeight() != aVar.getGif().getHeight() || this.awX) {
                this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
            }
            this.awV = new WeakReference<>(aVar.getGif());
            aVar.getGif().R(0);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.awL) {
                play();
            }
        } else {
            aVar.getGif().R(this.awx);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.awL) {
                resume();
            }
        }
    }

    public boolean getAutoPlay() {
        return this.awL;
    }

    public void setAutoPlay(boolean z) {
        this.awL = z;
    }

    public void resume() {
        com.baidu.adp.gif.b bVar;
        if (this.awV != null && (bVar = this.awV.get()) != null) {
            this.awY = false;
            if (this.isHide) {
                setVisibility(4);
                return;
            }
            this.awW.onStart();
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageDelayed(1, bVar.S(this.awx));
            this.mHandler.sendEmptyMessageDelayed(2, 2000L);
        }
    }

    public void stop() {
        com.baidu.adp.gif.b bVar;
        if (this.awV != null && (bVar = this.awV.get()) != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.awx = 0;
            bVar.R(0);
            bVar.a(this.mBitmap, null);
            invalidate();
        }
    }

    public void play() {
        com.baidu.adp.gif.b bVar;
        if (this.awV != null && (bVar = this.awV.get()) != null) {
            this.awY = false;
            if (this.isHide) {
                setVisibility(4);
                return;
            }
            this.awW.onStart();
            if (this.awx != 0) {
                this.awx = 0;
            }
            bVar.R(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageDelayed(1, bVar.S(this.awx));
            this.mHandler.sendEmptyMessageDelayed(2, 2000L);
        }
    }

    public void setPlayOnce(boolean z) {
        this.awP = z;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        Ea();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.mHandler.removeMessages(1);
        Ea();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 4 || i == 8) {
            this.isHide = true;
            stop();
            if (this.awW != null) {
                this.awW.onStop();
            }
        } else if (i == 0) {
            play();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        com.baidu.adp.gif.b bVar;
        if (!this.mIsLoading && !this.awB) {
            super.onDraw(canvas);
        }
        canvas.save();
        if (this.awV != null && !this.mIsLoading && !this.awB && (bVar = this.awV.get()) != null) {
            bVar.a(null, canvas);
        }
        canvas.restore();
        if (this.mIsLoading && awE != null) {
            canvas.save();
            canvas.rotate(this.awD, (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.5f) + getPaddingLeft(), (((getHeight() - getPaddingTop()) - getPaddingBottom()) * 0.5f) + getPaddingTop());
            canvas.drawBitmap(awE, this.awK, this.awJ, (Paint) null);
            canvas.restore();
        } else if (this.awB || (this.awQ != null && this.awQ.awq)) {
            canvas.save();
            this.awC.draw(canvas);
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
            DZ();
        }
    }

    public com.baidu.adp.gif.b getGif() {
        if (this.awV == null) {
            return null;
        }
        return this.awV.get();
    }

    public void stopLoading() {
        this.mIsLoading = false;
        removeCallbacks(this);
        invalidate();
    }

    private void DZ() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.awD += this.awF;
        if (this.awD > 360.0f - this.awF) {
            this.awD = 0.0f;
        }
        invalidate();
        DZ();
    }

    public void setPlayCallback(a aVar) {
        this.awW = aVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
    }

    public void a(com.baidu.tbadk.gif.a aVar) {
        BdUniqueId bdUniqueId;
        boolean z;
        if (aVar == null) {
            this.awQ = null;
            return;
        }
        boolean Gx = com.baidu.tbadk.util.e.Gx();
        k A = l.A(getContext());
        if (A != null) {
            bdUniqueId = A.getUniqueId();
            z = A.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        boolean z2 = aVar == this.awQ && this.awS == bdUniqueId;
        this.awX = !z2;
        if (!z2) {
            Ea();
        }
        this.awQ = aVar;
        this.awS = bdUniqueId;
        String str = Gx ? this.awQ.awt : this.awQ.aws;
        com.baidu.adp.widget.a.a aVar2 = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.g.c.hl().a(this.awQ.awr, 20, this.awQ.mGid, this.awQ.awr, Boolean.valueOf(Gx), str);
        if (aVar2 != null) {
            stopLoading();
            setGif(aVar2);
        } else if (this.awQ.awq) {
            setGif(null);
        } else {
            startLoading();
            if (!z) {
                com.baidu.adp.lib.g.c.hl().a(this.awQ.awr, 20, this.awT, 0, 0, this.awS, this.awQ.mGid, this.awQ.awr, Boolean.valueOf(Gx), str);
            }
        }
    }

    public void Ea() {
        stopLoading();
        this.awB = false;
        if (this.awQ != null) {
            com.baidu.adp.lib.g.c.hl().a(this.awQ.awr, 20, this.awT);
        }
    }

    @Override // com.baidu.adp.newwidget.a.i
    public void refresh() {
        a(this.awQ);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(this);
        this.mOnClickListener = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.awQ != null) {
            boolean Gx = com.baidu.tbadk.util.e.Gx();
            String str = Gx ? this.awQ.awt : this.awQ.aws;
            com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.g.c.hl().a(this.awQ.awr, 20, this.awQ.mGid, this.awQ.awr, Boolean.valueOf(Gx), str);
            if (aVar != null) {
                this.awQ.awq = false;
                setGif(aVar);
            } else {
                startLoading();
                com.baidu.adp.lib.g.c.hl().a(this.awQ.awr, 20, this.awT, 0, 0, this.awS, this.awQ.mGid, this.awQ.awr, Boolean.valueOf(Gx), str);
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
