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
import com.baidu.adp.base.n;
import com.baidu.adp.newwidget.a.i;
import com.baidu.tieba.p;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class GiftGifView extends ImageView implements View.OnClickListener, i, Runnable {
    public static Bitmap alK;
    private WeakReference<com.baidu.adp.gif.c> alB;
    private int alC;
    private boolean alG;
    private Drawable alH;
    private boolean alI;
    private float alJ;
    private float alL;
    private final Rect alP;
    private final Rect alQ;
    private boolean alR;
    private boolean alS;
    private a alT;
    private BdUniqueId alV;
    private final com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> alW;
    private g alY;
    private boolean alZ;
    private boolean ama;
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
        this.alP = new Rect();
        this.alQ = new Rect();
        this.alR = true;
        this.mType = 20;
        this.isHide = false;
        this.alZ = false;
        this.ama = false;
        this.mHandler = new e(this, Looper.getMainLooper());
        this.alW = new f(this);
        this.alL = 30.0f;
        BitmapDrawable bitmapDrawable = (BitmapDrawable) getResources().getDrawable(p.loading);
        if (bitmapDrawable != null) {
            alK = bitmapDrawable.getBitmap();
            this.alQ.set(0, 0, alK.getWidth(), alK.getHeight());
        }
        this.alH = getResources().getDrawable(p.image_group_load_f);
        a(this.alH);
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
            if (alK != null) {
                int i6 = i5 / 4;
                int i7 = ((i5 - i6) / 2) + paddingLeft;
                int i8 = ((paddingBottom - i6) / 2) + paddingTop;
                this.alP.set(i7, i8, i7 + i6, i6 + i8);
            }
            int intrinsicWidth = this.alH.getIntrinsicWidth();
            int intrinsicHeight = this.alH.getIntrinsicHeight();
            if (intrinsicWidth > i5) {
                intrinsicWidth = i5;
            }
            if (intrinsicHeight > paddingBottom) {
                intrinsicHeight = paddingBottom;
            }
            int i9 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
            int i10 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
            this.alH.setBounds(i9, i10, intrinsicWidth + i9, intrinsicHeight + i10);
        }
    }

    public void setGif(com.baidu.adp.widget.a.a aVar) {
        this.alG = false;
        this.alI = false;
        if (this.alT != null) {
            this.alT.als = false;
        }
        if (aVar == null) {
            this.alG = true;
            if (this.alT != null) {
                this.alT.als = true;
            }
            setImageDrawable(null);
            if (this.alB != null) {
                this.alB.clear();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.mQ()) {
                aVar.a(this);
                this.alI = false;
            }
            if (this.alB != null) {
                this.alB.clear();
            }
        } else if (this.alB == null || !aVar.getGif().equals(this.alB.get())) {
            if (this.mBitmap == null || this.mBitmap.getWidth() != aVar.getGif().getWidth() || this.mBitmap.getHeight() != aVar.getGif().getHeight() || this.alZ) {
                this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
            }
            this.alB = new WeakReference<>(aVar.getGif());
            aVar.getGif().D(0);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.alR) {
                play();
            }
        } else {
            aVar.getGif().D(this.alC);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.alR) {
                resume();
            }
        }
    }

    public boolean getAutoPlay() {
        return this.alR;
    }

    public void setAutoPlay(boolean z) {
        this.alR = z;
    }

    public void resume() {
        com.baidu.adp.gif.c cVar;
        if (this.alB != null && (cVar = this.alB.get()) != null) {
            this.ama = false;
            if (this.isHide) {
                setVisibility(4);
                return;
            }
            this.alY.onStart();
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageDelayed(1, cVar.E(this.alC));
            this.mHandler.sendEmptyMessageDelayed(2, 2000L);
        }
    }

    public void stop() {
        com.baidu.adp.gif.c cVar;
        if (this.alB != null && (cVar = this.alB.get()) != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.alC = 0;
            cVar.D(0);
            cVar.a(this.mBitmap, null);
            invalidate();
        }
    }

    public void play() {
        com.baidu.adp.gif.c cVar;
        if (this.alB != null && (cVar = this.alB.get()) != null) {
            this.ama = false;
            if (this.isHide) {
                setVisibility(4);
                return;
            }
            this.alY.onStart();
            if (this.alC != 0) {
                this.alC = 0;
            }
            cVar.D(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageDelayed(1, cVar.E(this.alC));
            this.mHandler.sendEmptyMessageDelayed(2, 2000L);
        }
    }

    public void setPlayOnce(boolean z) {
        this.alS = z;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        Ak();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.mHandler.removeMessages(1);
        Ak();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 4 || i == 8) {
            this.isHide = true;
            stop();
            if (this.alY != null) {
                this.alY.onStop();
            }
        } else if (i == 0) {
            play();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        com.baidu.adp.gif.c cVar;
        if (!this.alI && !this.alG) {
            super.onDraw(canvas);
        }
        canvas.save();
        if (this.alB != null && !this.alI && !this.alG && (cVar = this.alB.get()) != null) {
            cVar.a(null, canvas);
        }
        canvas.restore();
        if (this.alI && alK != null) {
            canvas.save();
            canvas.rotate(this.alJ, (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.5f) + getPaddingLeft(), (((getHeight() - getPaddingTop()) - getPaddingBottom()) * 0.5f) + getPaddingTop());
            canvas.drawBitmap(alK, this.alQ, this.alP, (Paint) null);
            canvas.restore();
        } else if (this.alG || (this.alT != null && this.alT.als)) {
            canvas.save();
            this.alH.draw(canvas);
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
        if (!this.alI) {
            this.alI = true;
            Aj();
        }
    }

    public com.baidu.adp.gif.c getGif() {
        if (this.alB == null) {
            return null;
        }
        return this.alB.get();
    }

    public void stopLoading() {
        this.alI = false;
        removeCallbacks(this);
        invalidate();
    }

    private void Aj() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.alJ += this.alL;
        if (this.alJ > 360.0f - this.alL) {
            this.alJ = 0.0f;
        }
        invalidate();
        Aj();
    }

    public void setPlayCallback(g gVar) {
        this.alY = gVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
    }

    public void a(a aVar) {
        BdUniqueId bdUniqueId;
        boolean z;
        if (aVar == null) {
            this.alT = null;
            return;
        }
        boolean DX = com.baidu.tbadk.util.g.DX();
        m B = n.B(getContext());
        if (B != null) {
            bdUniqueId = B.getUniqueId();
            z = B.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        boolean z2 = aVar == this.alT && this.alV == bdUniqueId;
        this.alZ = !z2;
        if (!z2) {
            Ak();
        }
        this.alT = aVar;
        this.alV = bdUniqueId;
        String str = DX ? this.alT.alv : this.alT.alu;
        com.baidu.adp.widget.a.a aVar2 = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.d.hl().a(this.alT.alt, 20, this.alT.alw, this.alT.alt, Boolean.valueOf(DX), str);
        if (aVar2 != null) {
            stopLoading();
            setGif(aVar2);
        } else if (this.alT.als) {
            setGif(null);
        } else {
            startLoading();
            if (!z) {
                com.baidu.adp.lib.f.d.hl().a(this.alT.alt, 20, this.alW, 0, 0, this.alV, this.alT.alw, this.alT.alt, Boolean.valueOf(DX), str);
            }
        }
    }

    public void Ak() {
        stopLoading();
        this.alG = false;
        if (this.alT != null) {
            com.baidu.adp.lib.f.d.hl().a(this.alT.alt, 20, this.alW);
        }
    }

    @Override // com.baidu.adp.newwidget.a.i
    public void refresh() {
        a(this.alT);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(this);
        this.mOnClickListener = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.alT != null) {
            boolean DX = com.baidu.tbadk.util.g.DX();
            String str = DX ? this.alT.alv : this.alT.alu;
            com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.d.hl().a(this.alT.alt, 20, this.alT.alw, this.alT.alt, Boolean.valueOf(DX), str);
            if (aVar != null) {
                this.alT.als = false;
                setGif(aVar);
            } else {
                startLoading();
                com.baidu.adp.lib.f.d.hl().a(this.alT.alt, 20, this.alW, 0, 0, this.alV, this.alT.alw, this.alT.alt, Boolean.valueOf(DX), str);
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
