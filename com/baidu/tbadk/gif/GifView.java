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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.i;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class GifView extends ImageView implements View.OnClickListener, i, Runnable {
    public static Bitmap ato;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> atA;
    private final int ate;
    private WeakReference<com.baidu.adp.gif.b> atf;
    private int atg;
    private a ath;
    private boolean ati;
    private BitmapDrawable atj;
    private boolean atk;
    private Drawable atl;
    private boolean atm;
    private float atn;
    private float atp;
    private boolean atq;
    private Drawable atr;
    private int ats;
    private final Rect att;
    private final Rect atu;
    private boolean atv;
    private boolean atw;
    private com.baidu.tbadk.gif.a atx;
    private boolean aty;
    private BdUniqueId atz;
    private Bitmap mBitmap;
    private final Handler mHandler;
    private View.OnClickListener mOnClickListener;
    private final int mType;

    /* loaded from: classes.dex */
    public interface a {
        void onStop();
    }

    public GifView(Context context) {
        this(context, null, 0);
    }

    public GifView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GifView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ate = i.e.pic_expression_upload_selector;
        this.ati = false;
        this.att = new Rect();
        this.atu = new Rect();
        this.atv = true;
        this.mHandler = new b(this, Looper.getMainLooper());
        this.mType = 20;
        this.aty = true;
        this.atA = new c(this);
        this.atj = (BitmapDrawable) getResources().getDrawable(i.e.icon_content_animation);
        this.atj.setBounds(0, 0, this.atj.getIntrinsicWidth(), this.atj.getIntrinsicHeight());
        this.atp = 30.0f;
        if (((BitmapDrawable) getResources().getDrawable(i.e.loading)) != null) {
            ato = a(this);
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
            if (a(this) != null) {
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
            if (this.atr != null) {
                int intrinsicWidth2 = this.atr.getIntrinsicWidth();
                int intrinsicHeight2 = this.atr.getIntrinsicHeight();
                if (intrinsicWidth2 > i5) {
                    intrinsicWidth2 = i5;
                }
                if (intrinsicHeight2 > paddingBottom) {
                    intrinsicHeight2 = paddingBottom;
                }
                int i11 = ((i5 - intrinsicWidth2) / 2) + paddingLeft;
                int i12 = ((paddingBottom - intrinsicHeight2) / 2) + paddingTop;
                this.atr.setBounds(i11, i12, intrinsicWidth2 + i11, intrinsicHeight2 + i12);
            }
        }
    }

    public void setGif(com.baidu.adp.widget.a.a aVar) {
        this.atk = false;
        this.atm = false;
        this.atq = false;
        if (this.atx != null) {
            this.atx.asX = false;
        }
        if (aVar == null) {
            this.atk = true;
            this.ati = false;
            if (this.atx != null) {
                this.atx.asX = true;
            }
            setImageDrawable(null);
            if (this.atf != null) {
                this.atf.clear();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.na()) {
                this.ati = true;
                aVar.a(this);
                this.atm = false;
            }
            if (this.atf != null) {
                this.atf.clear();
            }
        } else if (this.atf == null || !aVar.getGif().equals(this.atf.get())) {
            this.ati = false;
            if (this.mBitmap == null || (this.mBitmap.getWidth() != aVar.getGif().getWidth() && this.mBitmap.getHeight() != aVar.getGif().getHeight())) {
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
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, bVar.G(this.atg));
        }
    }

    public void stop() {
        com.baidu.adp.gif.b bVar;
        if (this.atf != null && (bVar = this.atf.get()) != null) {
            this.mHandler.removeMessages(1);
            bVar.F(0);
            bVar.a(this.mBitmap, null);
            invalidate();
        }
    }

    public void play() {
        com.baidu.adp.gif.b bVar;
        if (this.atf != null && (bVar = this.atf.get()) != null) {
            if (this.atg != 0) {
                this.atg = 0;
            }
            bVar.F(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, bVar.G(this.atg));
        }
    }

    public void onDestroy() {
        this.atf = null;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandler.removeMessages(1);
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
        if (!this.ati) {
            if (i == 4 || i == 8) {
                stop();
            } else if (i == 0) {
                play();
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        com.baidu.adp.gif.b bVar;
        if (!this.atm && !this.atk && !this.atq) {
            super.onDraw(canvas);
        }
        canvas.save();
        if (this.atf != null && !this.atm && !this.atk && !this.atq && (bVar = this.atf.get()) != null) {
            bVar.a(null, canvas);
        }
        canvas.restore();
        if (this.ati) {
            canvas.save();
            this.atj.draw(canvas);
            canvas.restore();
        }
        if (this.atm && a(this) != null) {
            canvas.save();
            canvas.rotate(this.atn, (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.5f) + getPaddingLeft(), (((getHeight() - getPaddingTop()) - getPaddingBottom()) * 0.5f) + getPaddingTop());
            canvas.drawBitmap(a(this), this.atu, this.att, (Paint) null);
            canvas.restore();
        } else if (this.atk || (this.atx != null && this.atx.asX)) {
            canvas.save();
            this.atl.draw(canvas);
            canvas.restore();
        } else if (this.atq) {
            canvas.save();
            this.atr.draw(canvas);
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

    public void a(boolean z, int i) {
        this.atq = z;
        if (z) {
            this.atm = false;
            this.atk = false;
            if (this.atr == null || this.ats != i) {
                this.ats = i;
                this.atr = al.getDrawable(i);
                int intrinsicWidth = this.atr.getIntrinsicWidth();
                int intrinsicHeight = this.atr.getIntrinsicHeight();
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
                this.atr.setBounds(paddingLeft, paddingTop, intrinsicWidth + paddingLeft, intrinsicHeight + paddingTop);
            }
        }
        invalidate();
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
        this.ath = aVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.atr != null && this.atr.isStateful()) {
            this.atr.setState(getDrawableState());
            invalidate();
        }
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
        if (!(aVar == this.atx && this.atz == bdUniqueId)) {
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
        } else if (!com.baidu.adp.lib.f.c.hc().W(20) && this.aty) {
            a(true, this.ate);
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
        this.atq = false;
        if (this.atx != null) {
            com.baidu.adp.lib.f.c.hc().a(this.atx.asY, 20, this.atA);
        }
    }

    @Override // com.baidu.adp.newwidget.a.i
    public void refresh() {
        a(this.atx);
    }

    public void setSupportNoImage(boolean z) {
        this.aty = z;
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

    public static Bitmap a(GifView gifView) {
        if (ato != null && !ato.isRecycled()) {
            return ato;
        }
        BitmapDrawable bitmapDrawable = (BitmapDrawable) gifView.getResources().getDrawable(i.e.loading);
        if (bitmapDrawable != null) {
            ato = bitmapDrawable.getBitmap();
        }
        return ato;
    }
}
