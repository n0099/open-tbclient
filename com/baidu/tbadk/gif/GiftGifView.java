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
import com.baidu.tieba.i;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class GiftGifView extends ImageView implements View.OnClickListener, i, Runnable {
    public static Bitmap atv;
    private final Rect atA;
    private final Rect atB;
    private boolean atC;
    private boolean atD;
    private com.baidu.tbadk.gif.a atE;
    private BdUniqueId atG;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> atH;
    private a atJ;
    private boolean atK;
    private boolean atL;
    private WeakReference<com.baidu.adp.gif.b> atm;
    private int atn;
    private boolean atr;
    private Drawable ats;
    private boolean att;
    private float atu;
    private float atw;
    private boolean isHide;
    private Bitmap mBitmap;
    private final Handler mHandler;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes.dex */
    public interface a {
        void Cd();

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
        this.atA = new Rect();
        this.atB = new Rect();
        this.atC = true;
        this.isHide = false;
        this.atK = false;
        this.atL = false;
        this.mHandler = new d(this, Looper.getMainLooper());
        this.atH = new e(this);
        this.atw = 30.0f;
        BitmapDrawable bitmapDrawable = (BitmapDrawable) getResources().getDrawable(i.e.loading);
        if (bitmapDrawable != null) {
            atv = bitmapDrawable.getBitmap();
            this.atB.set(0, 0, atv.getWidth(), atv.getHeight());
        }
        this.ats = getResources().getDrawable(i.e.image_group_load_f);
        c(this.ats);
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
            if (atv != null) {
                int i6 = i5 / 4;
                int i7 = ((i5 - i6) / 2) + paddingLeft;
                int i8 = ((paddingBottom - i6) / 2) + paddingTop;
                this.atA.set(i7, i8, i7 + i6, i6 + i8);
            }
            int intrinsicWidth = this.ats.getIntrinsicWidth();
            int intrinsicHeight = this.ats.getIntrinsicHeight();
            if (intrinsicWidth > i5) {
                intrinsicWidth = i5;
            }
            if (intrinsicHeight > paddingBottom) {
                intrinsicHeight = paddingBottom;
            }
            int i9 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
            int i10 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
            this.ats.setBounds(i9, i10, intrinsicWidth + i9, intrinsicHeight + i10);
        }
    }

    public void setGif(com.baidu.adp.widget.a.a aVar) {
        this.atr = false;
        this.att = false;
        if (this.atE != null) {
            this.atE.ate = false;
        }
        if (aVar == null) {
            this.atr = true;
            if (this.atE != null) {
                this.atE.ate = true;
            }
            setImageDrawable(null);
            if (this.atm != null) {
                this.atm.clear();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.mY()) {
                aVar.a(this);
                this.att = false;
            }
            if (this.atm != null) {
                this.atm.clear();
            }
        } else if (this.atm == null || !aVar.getGif().equals(this.atm.get())) {
            if (this.mBitmap == null || this.mBitmap.getWidth() != aVar.getGif().getWidth() || this.mBitmap.getHeight() != aVar.getGif().getHeight() || this.atK) {
                this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
            }
            this.atm = new WeakReference<>(aVar.getGif());
            aVar.getGif().F(0);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.atC) {
                play();
            }
        } else {
            aVar.getGif().F(this.atn);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.atC) {
                resume();
            }
        }
    }

    public boolean getAutoPlay() {
        return this.atC;
    }

    public void setAutoPlay(boolean z) {
        this.atC = z;
    }

    public void resume() {
        com.baidu.adp.gif.b bVar;
        if (this.atm != null && (bVar = this.atm.get()) != null) {
            this.atL = false;
            if (this.isHide) {
                setVisibility(4);
                return;
            }
            this.atJ.onStart();
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageDelayed(1, bVar.G(this.atn));
            this.mHandler.sendEmptyMessageDelayed(2, 2000L);
        }
    }

    public void stop() {
        com.baidu.adp.gif.b bVar;
        if (this.atm != null && (bVar = this.atm.get()) != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.atn = 0;
            bVar.F(0);
            bVar.a(this.mBitmap, null);
            invalidate();
        }
    }

    public void play() {
        com.baidu.adp.gif.b bVar;
        if (this.atm != null && (bVar = this.atm.get()) != null) {
            this.atL = false;
            if (this.isHide) {
                setVisibility(4);
                return;
            }
            this.atJ.onStart();
            if (this.atn != 0) {
                this.atn = 0;
            }
            bVar.F(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageDelayed(1, bVar.G(this.atn));
            this.mHandler.sendEmptyMessageDelayed(2, 2000L);
        }
    }

    public void setPlayOnce(boolean z) {
        this.atD = z;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        Cc();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.mHandler.removeMessages(1);
        Cc();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 4 || i == 8) {
            this.isHide = true;
            stop();
            if (this.atJ != null) {
                this.atJ.onStop();
            }
        } else if (i == 0) {
            play();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        com.baidu.adp.gif.b bVar;
        if (!this.att && !this.atr) {
            super.onDraw(canvas);
        }
        canvas.save();
        if (this.atm != null && !this.att && !this.atr && (bVar = this.atm.get()) != null) {
            bVar.a(null, canvas);
        }
        canvas.restore();
        if (this.att && atv != null) {
            canvas.save();
            canvas.rotate(this.atu, (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.5f) + getPaddingLeft(), (((getHeight() - getPaddingTop()) - getPaddingBottom()) * 0.5f) + getPaddingTop());
            canvas.drawBitmap(atv, this.atB, this.atA, (Paint) null);
            canvas.restore();
        } else if (this.atr || (this.atE != null && this.atE.ate)) {
            canvas.save();
            this.ats.draw(canvas);
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
        if (!this.att) {
            this.att = true;
            Cb();
        }
    }

    public com.baidu.adp.gif.b getGif() {
        if (this.atm == null) {
            return null;
        }
        return this.atm.get();
    }

    public void stopLoading() {
        this.att = false;
        removeCallbacks(this);
        invalidate();
    }

    private void Cb() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.atu += this.atw;
        if (this.atu > 360.0f - this.atw) {
            this.atu = 0.0f;
        }
        invalidate();
        Cb();
    }

    public void setPlayCallback(a aVar) {
        this.atJ = aVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
    }

    public void a(com.baidu.tbadk.gif.a aVar) {
        BdUniqueId bdUniqueId;
        boolean z;
        if (aVar == null) {
            this.atE = null;
            return;
        }
        boolean EA = com.baidu.tbadk.util.e.EA();
        k A = l.A(getContext());
        if (A != null) {
            bdUniqueId = A.getUniqueId();
            z = A.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        boolean z2 = aVar == this.atE && this.atG == bdUniqueId;
        this.atK = !z2;
        if (!z2) {
            Cc();
        }
        this.atE = aVar;
        this.atG = bdUniqueId;
        String str = EA ? this.atE.ath : this.atE.atg;
        com.baidu.adp.widget.a.a aVar2 = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.ha().a(this.atE.atf, 20, this.atE.mGid, this.atE.atf, Boolean.valueOf(EA), str);
        if (aVar2 != null) {
            stopLoading();
            setGif(aVar2);
        } else if (this.atE.ate) {
            setGif(null);
        } else {
            startLoading();
            if (!z) {
                com.baidu.adp.lib.f.c.ha().a(this.atE.atf, 20, this.atH, 0, 0, this.atG, this.atE.mGid, this.atE.atf, Boolean.valueOf(EA), str);
            }
        }
    }

    public void Cc() {
        stopLoading();
        this.atr = false;
        if (this.atE != null) {
            com.baidu.adp.lib.f.c.ha().a(this.atE.atf, 20, this.atH);
        }
    }

    @Override // com.baidu.adp.newwidget.a.i
    public void refresh() {
        a(this.atE);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(this);
        this.mOnClickListener = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.atE != null) {
            boolean EA = com.baidu.tbadk.util.e.EA();
            String str = EA ? this.atE.ath : this.atE.atg;
            com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.ha().a(this.atE.atf, 20, this.atE.mGid, this.atE.atf, Boolean.valueOf(EA), str);
            if (aVar != null) {
                this.atE.ate = false;
                setGif(aVar);
            } else {
                startLoading();
                com.baidu.adp.lib.f.c.ha().a(this.atE.atf, 20, this.atH, 0, 0, this.atG, this.atE.mGid, this.atE.atf, Boolean.valueOf(EA), str);
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
