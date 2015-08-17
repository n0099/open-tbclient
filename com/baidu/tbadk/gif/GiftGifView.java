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
    public static Bitmap ato;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> atA;
    private a atC;
    private boolean atD;
    private boolean atE;
    private WeakReference<com.baidu.adp.gif.b> atf;
    private int atg;
    private boolean atk;
    private Drawable atl;
    private boolean atm;
    private float atn;
    private float atp;
    private final Rect att;
    private final Rect atu;
    private boolean atv;
    private boolean atw;
    private com.baidu.tbadk.gif.a atx;
    private BdUniqueId atz;
    private boolean isHide;
    private Bitmap mBitmap;
    private final Handler mHandler;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes.dex */
    public interface a {
        void Cc();

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
        this.att = new Rect();
        this.atu = new Rect();
        this.atv = true;
        this.isHide = false;
        this.atD = false;
        this.atE = false;
        this.mHandler = new d(this, Looper.getMainLooper());
        this.atA = new e(this);
        this.atp = 30.0f;
        BitmapDrawable bitmapDrawable = (BitmapDrawable) getResources().getDrawable(i.e.loading);
        if (bitmapDrawable != null) {
            ato = bitmapDrawable.getBitmap();
            this.atu.set(0, 0, ato.getWidth(), ato.getHeight());
        }
        this.atl = getResources().getDrawable(i.e.image_group_load_f);
        c(this.atl);
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
            if (ato != null) {
                int i6 = i5 / 4;
                int i7 = ((i5 - i6) / 2) + paddingLeft;
                int i8 = ((paddingBottom - i6) / 2) + paddingTop;
                this.att.set(i7, i8, i7 + i6, i6 + i8);
            }
            int intrinsicWidth = this.atl.getIntrinsicWidth();
            int intrinsicHeight = this.atl.getIntrinsicHeight();
            if (intrinsicWidth > i5) {
                intrinsicWidth = i5;
            }
            if (intrinsicHeight > paddingBottom) {
                intrinsicHeight = paddingBottom;
            }
            int i9 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
            int i10 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
            this.atl.setBounds(i9, i10, intrinsicWidth + i9, intrinsicHeight + i10);
        }
    }

    public void setGif(com.baidu.adp.widget.a.a aVar) {
        this.atk = false;
        this.atm = false;
        if (this.atx != null) {
            this.atx.asX = false;
        }
        if (aVar == null) {
            this.atk = true;
            if (this.atx != null) {
                this.atx.asX = true;
            }
            setImageDrawable(null);
            if (this.atf != null) {
                this.atf.clear();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.na()) {
                aVar.a(this);
                this.atm = false;
            }
            if (this.atf != null) {
                this.atf.clear();
            }
        } else if (this.atf == null || !aVar.getGif().equals(this.atf.get())) {
            if (this.mBitmap == null || this.mBitmap.getWidth() != aVar.getGif().getWidth() || this.mBitmap.getHeight() != aVar.getGif().getHeight() || this.atD) {
                this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
            }
            this.atf = new WeakReference<>(aVar.getGif());
            aVar.getGif().F(0);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.atv) {
                play();
            }
        } else {
            aVar.getGif().F(this.atg);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.atv) {
                resume();
            }
        }
    }

    public boolean getAutoPlay() {
        return this.atv;
    }

    public void setAutoPlay(boolean z) {
        this.atv = z;
    }

    public void resume() {
        com.baidu.adp.gif.b bVar;
        if (this.atf != null && (bVar = this.atf.get()) != null) {
            this.atE = false;
            if (this.isHide) {
                setVisibility(4);
                return;
            }
            this.atC.onStart();
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageDelayed(1, bVar.G(this.atg));
            this.mHandler.sendEmptyMessageDelayed(2, 2000L);
        }
    }

    public void stop() {
        com.baidu.adp.gif.b bVar;
        if (this.atf != null && (bVar = this.atf.get()) != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.atg = 0;
            bVar.F(0);
            bVar.a(this.mBitmap, null);
            invalidate();
        }
    }

    public void play() {
        com.baidu.adp.gif.b bVar;
        if (this.atf != null && (bVar = this.atf.get()) != null) {
            this.atE = false;
            if (this.isHide) {
                setVisibility(4);
                return;
            }
            this.atC.onStart();
            if (this.atg != 0) {
                this.atg = 0;
            }
            bVar.F(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageDelayed(1, bVar.G(this.atg));
            this.mHandler.sendEmptyMessageDelayed(2, 2000L);
        }
    }

    public void setPlayOnce(boolean z) {
        this.atw = z;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        Cb();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.mHandler.removeMessages(1);
        Cb();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 4 || i == 8) {
            this.isHide = true;
            stop();
            if (this.atC != null) {
                this.atC.onStop();
            }
        } else if (i == 0) {
            play();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        com.baidu.adp.gif.b bVar;
        if (!this.atm && !this.atk) {
            super.onDraw(canvas);
        }
        canvas.save();
        if (this.atf != null && !this.atm && !this.atk && (bVar = this.atf.get()) != null) {
            bVar.a(null, canvas);
        }
        canvas.restore();
        if (this.atm && ato != null) {
            canvas.save();
            canvas.rotate(this.atn, (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.5f) + getPaddingLeft(), (((getHeight() - getPaddingTop()) - getPaddingBottom()) * 0.5f) + getPaddingTop());
            canvas.drawBitmap(ato, this.atu, this.att, (Paint) null);
            canvas.restore();
        } else if (this.atk || (this.atx != null && this.atx.asX)) {
            canvas.save();
            this.atl.draw(canvas);
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
        if (!this.atm) {
            this.atm = true;
            Ca();
        }
    }

    public com.baidu.adp.gif.b getGif() {
        if (this.atf == null) {
            return null;
        }
        return this.atf.get();
    }

    public void stopLoading() {
        this.atm = false;
        removeCallbacks(this);
        invalidate();
    }

    private void Ca() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.atn += this.atp;
        if (this.atn > 360.0f - this.atp) {
            this.atn = 0.0f;
        }
        invalidate();
        Ca();
    }

    public void setPlayCallback(a aVar) {
        this.atC = aVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
    }

    public void a(com.baidu.tbadk.gif.a aVar) {
        BdUniqueId bdUniqueId;
        boolean z;
        if (aVar == null) {
            this.atx = null;
            return;
        }
        boolean EC = com.baidu.tbadk.util.d.EC();
        k A = l.A(getContext());
        if (A != null) {
            bdUniqueId = A.getUniqueId();
            z = A.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        boolean z2 = aVar == this.atx && this.atz == bdUniqueId;
        this.atD = !z2;
        if (!z2) {
            Cb();
        }
        this.atx = aVar;
        this.atz = bdUniqueId;
        String str = EC ? this.atx.ata : this.atx.asZ;
        com.baidu.adp.widget.a.a aVar2 = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.hc().a(this.atx.asY, 20, this.atx.mGid, this.atx.asY, Boolean.valueOf(EC), str);
        if (aVar2 != null) {
            stopLoading();
            setGif(aVar2);
        } else if (this.atx.asX) {
            setGif(null);
        } else {
            startLoading();
            if (!z) {
                com.baidu.adp.lib.f.c.hc().a(this.atx.asY, 20, this.atA, 0, 0, this.atz, this.atx.mGid, this.atx.asY, Boolean.valueOf(EC), str);
            }
        }
    }

    public void Cb() {
        stopLoading();
        this.atk = false;
        if (this.atx != null) {
            com.baidu.adp.lib.f.c.hc().a(this.atx.asY, 20, this.atA);
        }
    }

    @Override // com.baidu.adp.newwidget.a.i
    public void refresh() {
        a(this.atx);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(this);
        this.mOnClickListener = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.atx != null) {
            boolean EC = com.baidu.tbadk.util.d.EC();
            String str = EC ? this.atx.ata : this.atx.asZ;
            com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.hc().a(this.atx.asY, 20, this.atx.mGid, this.atx.asY, Boolean.valueOf(EC), str);
            if (aVar != null) {
                this.atx.asX = false;
                setGif(aVar);
            } else {
                startLoading();
                com.baidu.adp.lib.f.c.hc().a(this.atx.asY, 20, this.atA, 0, 0, this.atz, this.atx.mGid, this.atx.asY, Boolean.valueOf(EC), str);
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
