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
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.i;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class GifView extends ImageView implements View.OnClickListener, i, Runnable {
    public static Bitmap atw;
    private int atA;
    private final Rect atB;
    private final Rect atC;
    private boolean atD;
    private boolean atE;
    private com.baidu.tbadk.gif.a atF;
    private boolean atG;
    private BdUniqueId atH;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> atI;
    private final int atm;
    private WeakReference<com.baidu.adp.gif.b> atn;
    private int ato;
    private a atp;
    private boolean atq;
    private BitmapDrawable atr;
    private boolean ats;
    private Drawable att;
    private boolean atu;
    private float atv;
    private float atx;
    private boolean aty;
    private Drawable atz;
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
        this.atm = i.e.pic_expression_upload_selector;
        this.atq = false;
        this.atB = new Rect();
        this.atC = new Rect();
        this.atD = true;
        this.mHandler = new b(this, Looper.getMainLooper());
        this.mType = 20;
        this.atG = true;
        this.atI = new c(this);
        this.atr = (BitmapDrawable) getResources().getDrawable(i.e.icon_content_animation);
        this.atr.setBounds(0, 0, this.atr.getIntrinsicWidth(), this.atr.getIntrinsicHeight());
        this.atx = 30.0f;
        if (((BitmapDrawable) getResources().getDrawable(i.e.loading)) != null) {
            atw = a(this);
            this.atC.set(0, 0, atw.getWidth(), atw.getHeight());
        }
        this.att = getResources().getDrawable(i.e.image_group_load_f);
        c(this.att);
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
                this.atB.set(i7, i8, i7 + i6, i6 + i8);
            }
            int intrinsicWidth = this.att.getIntrinsicWidth();
            int intrinsicHeight = this.att.getIntrinsicHeight();
            if (intrinsicWidth > i5) {
                intrinsicWidth = i5;
            }
            if (intrinsicHeight > paddingBottom) {
                intrinsicHeight = paddingBottom;
            }
            int i9 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
            int i10 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
            this.att.setBounds(i9, i10, intrinsicWidth + i9, intrinsicHeight + i10);
            if (this.atz != null) {
                int intrinsicWidth2 = this.atz.getIntrinsicWidth();
                int intrinsicHeight2 = this.atz.getIntrinsicHeight();
                if (intrinsicWidth2 > i5) {
                    intrinsicWidth2 = i5;
                }
                if (intrinsicHeight2 > paddingBottom) {
                    intrinsicHeight2 = paddingBottom;
                }
                int i11 = ((i5 - intrinsicWidth2) / 2) + paddingLeft;
                int i12 = ((paddingBottom - intrinsicHeight2) / 2) + paddingTop;
                this.atz.setBounds(i11, i12, intrinsicWidth2 + i11, intrinsicHeight2 + i12);
            }
        }
    }

    public void setGif(com.baidu.adp.widget.a.a aVar) {
        this.ats = false;
        this.atu = false;
        this.aty = false;
        if (this.atF != null) {
            this.atF.atf = false;
        }
        if (aVar == null) {
            this.ats = true;
            this.atq = false;
            if (this.atF != null) {
                this.atF.atf = true;
            }
            setImageDrawable(null);
            if (this.atn != null) {
                this.atn.clear();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.mY()) {
                this.atq = true;
                aVar.a(this);
                this.atu = false;
            }
            if (this.atn != null) {
                this.atn.clear();
            }
        } else if (this.atn == null || !aVar.getGif().equals(this.atn.get())) {
            this.atq = false;
            if (this.mBitmap == null || (this.mBitmap.getWidth() != aVar.getGif().getWidth() && this.mBitmap.getHeight() != aVar.getGif().getHeight())) {
                this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
            }
            this.atn = new WeakReference<>(aVar.getGif());
            aVar.getGif().F(0);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.atD) {
                play();
            }
        } else {
            aVar.getGif().F(this.ato);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.atD) {
                resume();
            }
        }
    }

    public boolean getAutoPlay() {
        return this.atD;
    }

    public void setAutoPlay(boolean z) {
        this.atD = z;
    }

    public void resume() {
        com.baidu.adp.gif.b bVar;
        if (this.atn != null && (bVar = this.atn.get()) != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, bVar.G(this.ato));
        }
    }

    public void stop() {
        com.baidu.adp.gif.b bVar;
        if (this.atn != null && (bVar = this.atn.get()) != null) {
            this.mHandler.removeMessages(1);
            bVar.F(0);
            bVar.a(this.mBitmap, null);
            invalidate();
        }
    }

    public void play() {
        com.baidu.adp.gif.b bVar;
        if (this.atn != null && (bVar = this.atn.get()) != null) {
            if (this.ato != 0) {
                this.ato = 0;
            }
            bVar.F(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, bVar.G(this.ato));
        }
    }

    public void onDestroy() {
        this.atn = null;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandler.removeMessages(1);
        BZ();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.mHandler.removeMessages(1);
        BZ();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (!this.atq) {
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
        if (!this.atu && !this.ats && !this.aty) {
            super.onDraw(canvas);
        }
        canvas.save();
        if (this.atn != null && !this.atu && !this.ats && !this.aty && (bVar = this.atn.get()) != null) {
            bVar.a(null, canvas);
        }
        canvas.restore();
        if (this.atq) {
            canvas.save();
            this.atr.draw(canvas);
            canvas.restore();
        }
        if (this.atu && a(this) != null) {
            canvas.save();
            canvas.rotate(this.atv, (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.5f) + getPaddingLeft(), (((getHeight() - getPaddingTop()) - getPaddingBottom()) * 0.5f) + getPaddingTop());
            canvas.drawBitmap(a(this), this.atC, this.atB, (Paint) null);
            canvas.restore();
        } else if (this.ats || (this.atF != null && this.atF.atf)) {
            canvas.save();
            this.att.draw(canvas);
            canvas.restore();
        } else if (this.aty) {
            canvas.save();
            this.atz.draw(canvas);
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
        if (!this.atu) {
            this.atu = true;
            BY();
        }
    }

    public void a(boolean z, int i) {
        this.aty = z;
        if (z) {
            this.atu = false;
            this.ats = false;
            if (this.atz == null || this.atA != i) {
                this.atA = i;
                this.atz = an.getDrawable(i);
                int intrinsicWidth = this.atz.getIntrinsicWidth();
                int intrinsicHeight = this.atz.getIntrinsicHeight();
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
                this.atz.setBounds(paddingLeft, paddingTop, intrinsicWidth + paddingLeft, intrinsicHeight + paddingTop);
            }
        }
        invalidate();
    }

    public com.baidu.adp.gif.b getGif() {
        if (this.atn == null) {
            return null;
        }
        return this.atn.get();
    }

    public void stopLoading() {
        this.atu = false;
        removeCallbacks(this);
        invalidate();
    }

    private void BY() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.atv += this.atx;
        if (this.atv > 360.0f - this.atx) {
            this.atv = 0.0f;
        }
        invalidate();
        BY();
    }

    public void setPlayCallback(a aVar) {
        this.atp = aVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.atz != null && this.atz.isStateful()) {
            this.atz.setState(getDrawableState());
            invalidate();
        }
    }

    public void a(com.baidu.tbadk.gif.a aVar) {
        BdUniqueId bdUniqueId;
        boolean z;
        if (aVar == null) {
            this.atF = null;
            return;
        }
        boolean Ew = com.baidu.tbadk.util.e.Ew();
        k A = l.A(getContext());
        if (A != null) {
            bdUniqueId = A.getUniqueId();
            z = A.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        if (!(aVar == this.atF && this.atH == bdUniqueId)) {
            BZ();
        }
        this.atF = aVar;
        this.atH = bdUniqueId;
        String str = Ew ? this.atF.ati : this.atF.ath;
        com.baidu.adp.widget.a.a aVar2 = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.ha().a(this.atF.atg, 20, this.atF.mGid, this.atF.atg, Boolean.valueOf(Ew), str);
        if (aVar2 != null) {
            stopLoading();
            setGif(aVar2);
        } else if (this.atF.atf) {
            setGif(null);
        } else if (!com.baidu.adp.lib.f.c.ha().W(20) && this.atG) {
            a(true, this.atm);
        } else {
            startLoading();
            if (!z) {
                com.baidu.adp.lib.f.c.ha().a(this.atF.atg, 20, this.atI, 0, 0, this.atH, this.atF.mGid, this.atF.atg, Boolean.valueOf(Ew), str);
            }
        }
    }

    public void BZ() {
        stopLoading();
        this.ats = false;
        this.aty = false;
        if (this.atF != null) {
            com.baidu.adp.lib.f.c.ha().a(this.atF.atg, 20, this.atI);
        }
    }

    @Override // com.baidu.adp.newwidget.a.i
    public void refresh() {
        a(this.atF);
    }

    public void setSupportNoImage(boolean z) {
        this.atG = z;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(this);
        this.mOnClickListener = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.atF != null) {
            boolean Ew = com.baidu.tbadk.util.e.Ew();
            String str = Ew ? this.atF.ati : this.atF.ath;
            com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.ha().a(this.atF.atg, 20, this.atF.mGid, this.atF.atg, Boolean.valueOf(Ew), str);
            if (aVar != null) {
                this.atF.atf = false;
                setGif(aVar);
            } else {
                startLoading();
                com.baidu.adp.lib.f.c.ha().a(this.atF.atg, 20, this.atI, 0, 0, this.atH, this.atF.mGid, this.atF.atg, Boolean.valueOf(Ew), str);
                return;
            }
        }
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    public static Bitmap a(GifView gifView) {
        if (atw != null && !atw.isRecycled()) {
            return atw;
        }
        BitmapDrawable bitmapDrawable = (BitmapDrawable) gifView.getResources().getDrawable(i.e.loading);
        if (bitmapDrawable != null) {
            atw = bitmapDrawable.getBitmap();
        }
        return atw;
    }
}
