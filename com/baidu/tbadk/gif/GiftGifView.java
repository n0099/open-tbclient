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
    public static Bitmap atm;
    private BdUniqueId atA;
    private final com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> atB;
    private WeakReference<com.baidu.adp.gif.b> atD;
    private a atE;
    private boolean atF;
    private boolean atG;
    private int atf;
    private boolean atj;
    private Drawable atk;
    private float atl;
    private float atn;
    private final Rect atr;
    private final Rect ats;
    private boolean att;
    private boolean atx;
    private com.baidu.tbadk.gif.a aty;
    private boolean isHide;
    private Bitmap mBitmap;
    private final Handler mHandler;
    private boolean mIsLoading;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes.dex */
    public interface a {
        void CF();

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
        this.atr = new Rect();
        this.ats = new Rect();
        this.att = true;
        this.isHide = false;
        this.atF = false;
        this.atG = false;
        this.mHandler = new d(this, Looper.getMainLooper());
        this.atB = new e(this);
        this.atn = 30.0f;
        BitmapDrawable bitmapDrawable = (BitmapDrawable) getResources().getDrawable(t.f.loading);
        if (bitmapDrawable != null) {
            atm = bitmapDrawable.getBitmap();
            this.ats.set(0, 0, atm.getWidth(), atm.getHeight());
        }
        this.atk = getResources().getDrawable(t.f.image_group_load_f);
        c(this.atk);
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
            if (atm != null) {
                int i6 = i5 / 4;
                int i7 = ((i5 - i6) / 2) + paddingLeft;
                int i8 = ((paddingBottom - i6) / 2) + paddingTop;
                this.atr.set(i7, i8, i7 + i6, i6 + i8);
            }
            int intrinsicWidth = this.atk.getIntrinsicWidth();
            int intrinsicHeight = this.atk.getIntrinsicHeight();
            if (intrinsicWidth > i5) {
                intrinsicWidth = i5;
            }
            if (intrinsicHeight > paddingBottom) {
                intrinsicHeight = paddingBottom;
            }
            int i9 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
            int i10 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
            this.atk.setBounds(i9, i10, intrinsicWidth + i9, intrinsicHeight + i10);
        }
    }

    public void setGif(com.baidu.adp.widget.a.a aVar) {
        this.atj = false;
        this.mIsLoading = false;
        if (this.aty != null) {
            this.aty.asY = false;
        }
        if (aVar == null) {
            this.atj = true;
            if (this.aty != null) {
                this.aty.asY = true;
            }
            setImageDrawable(null);
            if (this.atD != null) {
                this.atD.clear();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.iW()) {
                aVar.a(this);
                this.mIsLoading = false;
            }
            if (this.atD != null) {
                this.atD.clear();
            }
        } else if (this.atD == null || !aVar.getGif().equals(this.atD.get())) {
            if (this.mBitmap == null || this.mBitmap.getWidth() != aVar.getGif().getWidth() || this.mBitmap.getHeight() != aVar.getGif().getHeight() || this.atF) {
                this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
            }
            this.atD = new WeakReference<>(aVar.getGif());
            aVar.getGif().E(0);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.att) {
                play();
            }
        } else {
            aVar.getGif().E(this.atf);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.att) {
                resume();
            }
        }
    }

    public boolean getAutoPlay() {
        return this.att;
    }

    public void setAutoPlay(boolean z) {
        this.att = z;
    }

    public void resume() {
        com.baidu.adp.gif.b bVar;
        if (this.atD != null && (bVar = this.atD.get()) != null) {
            this.atG = false;
            if (this.isHide) {
                setVisibility(4);
                return;
            }
            this.atE.onStart();
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageDelayed(1, bVar.F(this.atf));
            this.mHandler.sendEmptyMessageDelayed(2, 2000L);
        }
    }

    public void stop() {
        com.baidu.adp.gif.b bVar;
        if (this.atD != null && (bVar = this.atD.get()) != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.atf = 0;
            bVar.E(0);
            bVar.a(this.mBitmap, null);
            invalidate();
        }
    }

    public void play() {
        com.baidu.adp.gif.b bVar;
        if (this.atD != null && (bVar = this.atD.get()) != null) {
            this.atG = false;
            if (this.isHide) {
                setVisibility(4);
                return;
            }
            this.atE.onStart();
            if (this.atf != 0) {
                this.atf = 0;
            }
            bVar.E(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageDelayed(1, bVar.F(this.atf));
            this.mHandler.sendEmptyMessageDelayed(2, 2000L);
        }
    }

    public void setPlayOnce(boolean z) {
        this.atx = z;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        CE();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.mHandler.removeMessages(1);
        CE();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 4 || i == 8) {
            this.isHide = true;
            stop();
            if (this.atE != null) {
                this.atE.onStop();
            }
        } else if (i == 0) {
            play();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        com.baidu.adp.gif.b bVar;
        if (!this.mIsLoading && !this.atj) {
            super.onDraw(canvas);
        }
        canvas.save();
        if (this.atD != null && !this.mIsLoading && !this.atj && (bVar = this.atD.get()) != null) {
            bVar.a(null, canvas);
        }
        canvas.restore();
        if (this.mIsLoading && atm != null) {
            canvas.save();
            canvas.rotate(this.atl, (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.5f) + getPaddingLeft(), (((getHeight() - getPaddingTop()) - getPaddingBottom()) * 0.5f) + getPaddingTop());
            canvas.drawBitmap(atm, this.ats, this.atr, (Paint) null);
            canvas.restore();
        } else if (this.atj || (this.aty != null && this.aty.asY)) {
            canvas.save();
            this.atk.draw(canvas);
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
            CD();
        }
    }

    public com.baidu.adp.gif.b getGif() {
        if (this.atD == null) {
            return null;
        }
        return this.atD.get();
    }

    public void stopLoading() {
        this.mIsLoading = false;
        removeCallbacks(this);
        invalidate();
    }

    private void CD() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.atl += this.atn;
        if (this.atl > 360.0f - this.atn) {
            this.atl = 0.0f;
        }
        invalidate();
        CD();
    }

    public void setPlayCallback(a aVar) {
        this.atE = aVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
    }

    public void a(com.baidu.tbadk.gif.a aVar) {
        BdUniqueId bdUniqueId;
        boolean z;
        if (aVar == null) {
            this.aty = null;
            return;
        }
        boolean Fr = h.Fr();
        k q = l.q(getContext());
        if (q != null) {
            bdUniqueId = q.getUniqueId();
            z = q.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        boolean z2 = aVar == this.aty && this.atA == bdUniqueId;
        this.atF = !z2;
        if (!z2) {
            CE();
        }
        this.aty = aVar;
        this.atA = bdUniqueId;
        String str = Fr ? this.aty.atb : this.aty.ata;
        com.baidu.adp.widget.a.a aVar2 = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.g.c.dF().a(this.aty.asZ, 20, this.aty.mGid, this.aty.asZ, Boolean.valueOf(Fr), str);
        if (aVar2 != null) {
            stopLoading();
            setGif(aVar2);
        } else if (this.aty.asY) {
            setGif(null);
        } else {
            startLoading();
            if (!z) {
                com.baidu.adp.lib.g.c.dF().a(this.aty.asZ, 20, this.atB, 0, 0, this.atA, this.aty.mGid, this.aty.asZ, Boolean.valueOf(Fr), str);
            }
        }
    }

    public void CE() {
        stopLoading();
        this.atj = false;
        if (this.aty != null) {
            com.baidu.adp.lib.g.c.dF().a(this.aty.asZ, 20, this.atB);
        }
    }

    @Override // com.baidu.adp.newwidget.a.i
    public void refresh() {
        a(this.aty);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(this);
        this.mOnClickListener = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aty != null) {
            boolean Fr = h.Fr();
            String str = Fr ? this.aty.atb : this.aty.ata;
            com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.g.c.dF().a(this.aty.asZ, 20, this.aty.mGid, this.aty.asZ, Boolean.valueOf(Fr), str);
            if (aVar != null) {
                this.aty.asY = false;
                setGif(aVar);
            } else {
                startLoading();
                com.baidu.adp.lib.g.c.dF().a(this.aty.asZ, 20, this.atB, 0, 0, this.atA, this.aty.mGid, this.aty.asZ, Boolean.valueOf(Fr), str);
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
