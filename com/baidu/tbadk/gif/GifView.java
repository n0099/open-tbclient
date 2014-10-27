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
import com.baidu.adp.newwidget.a.i;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.u;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class GifView extends ImageView implements View.OnClickListener, i, Runnable {
    public static Bitmap Tw;
    private int TA;
    private final Rect TB;
    private final Rect TC;
    private boolean TD;
    private boolean TE;
    private a TF;
    private boolean TG;
    private BdUniqueId TH;
    private final com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> TI;
    private final int Tm;
    private WeakReference<com.baidu.adp.gif.c> Tn;
    private int To;
    private d Tp;
    private boolean Tq;
    private BitmapDrawable Tr;
    private boolean Ts;
    private Drawable Tt;
    private boolean Tu;
    private float Tv;
    private float Tx;
    private boolean Ty;
    private Drawable Tz;
    private Bitmap mBitmap;
    private final Handler mHandler;
    private View.OnClickListener mOnClickListener;
    private final int mType;

    public GifView(Context context) {
        this(context, null, 0);
    }

    public GifView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GifView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Tm = u.pic_expression_upload_selector;
        this.Tq = false;
        this.TB = new Rect();
        this.TC = new Rect();
        this.TD = true;
        this.mHandler = new b(this, Looper.getMainLooper());
        this.mType = 20;
        this.TG = true;
        this.TI = new c(this);
        this.Tr = (BitmapDrawable) getResources().getDrawable(u.icon_content_animation);
        this.Tr.setBounds(0, 0, this.Tr.getIntrinsicWidth(), this.Tr.getIntrinsicHeight());
        this.Tx = 30.0f;
        BitmapDrawable bitmapDrawable = (BitmapDrawable) getResources().getDrawable(u.loading);
        if (bitmapDrawable != null) {
            Tw = bitmapDrawable.getBitmap();
            this.TC.set(0, 0, Tw.getWidth(), Tw.getHeight());
        }
        this.Tt = getResources().getDrawable(u.image_group_load_f);
        a(this.Tt);
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
            if (Tw != null) {
                int i6 = i5 / 4;
                int i7 = ((i5 - i6) / 2) + paddingLeft;
                int i8 = ((paddingBottom - i6) / 2) + paddingTop;
                this.TB.set(i7, i8, i7 + i6, i6 + i8);
            }
            int intrinsicWidth = this.Tt.getIntrinsicWidth();
            int intrinsicHeight = this.Tt.getIntrinsicHeight();
            if (intrinsicWidth > i5) {
                intrinsicWidth = i5;
            }
            if (intrinsicHeight > paddingBottom) {
                intrinsicHeight = paddingBottom;
            }
            int i9 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
            int i10 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
            this.Tt.setBounds(i9, i10, intrinsicWidth + i9, intrinsicHeight + i10);
            if (this.Tz != null) {
                int intrinsicWidth2 = this.Tz.getIntrinsicWidth();
                int intrinsicHeight2 = this.Tz.getIntrinsicHeight();
                if (intrinsicWidth2 > i5) {
                    intrinsicWidth2 = i5;
                }
                if (intrinsicHeight2 > paddingBottom) {
                    intrinsicHeight2 = paddingBottom;
                }
                int i11 = ((i5 - intrinsicWidth2) / 2) + paddingLeft;
                int i12 = ((paddingBottom - intrinsicHeight2) / 2) + paddingTop;
                this.Tz.setBounds(i11, i12, intrinsicWidth2 + i11, intrinsicHeight2 + i12);
            }
        }
    }

    public void setGif(com.baidu.adp.widget.a.a aVar) {
        this.Ts = false;
        this.Tu = false;
        this.Ty = false;
        if (this.TF != null) {
            this.TF.Te = false;
        }
        if (aVar == null) {
            this.Ts = true;
            this.Tq = false;
            if (this.TF != null) {
                this.TF.Te = true;
            }
            setImageDrawable(null);
            if (this.Tn != null) {
                this.Tn.clear();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.hj()) {
                this.Tq = true;
                aVar.a(this);
                this.Tu = false;
            }
            if (this.Tn != null) {
                this.Tn.clear();
            }
        } else if (this.Tn == null || !aVar.getGif().equals(this.Tn.get())) {
            this.Tq = false;
            if (this.mBitmap == null || (this.mBitmap.getWidth() != aVar.getGif().getWidth() && this.mBitmap.getHeight() != aVar.getGif().getHeight())) {
                this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
            }
            this.Tn = new WeakReference<>(aVar.getGif());
            aVar.getGif().k(0);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.TD) {
                play();
            }
        } else {
            aVar.getGif().k(this.To);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.TD) {
                resume();
            }
        }
    }

    public boolean getAutoPlay() {
        return this.TD;
    }

    public void setAutoPlay(boolean z) {
        this.TD = z;
    }

    public void resume() {
        com.baidu.adp.gif.c cVar;
        if (this.Tn != null && (cVar = this.Tn.get()) != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, cVar.l(this.To));
        }
    }

    public void stop() {
        com.baidu.adp.gif.c cVar;
        if (this.Tn != null && (cVar = this.Tn.get()) != null) {
            this.mHandler.removeMessages(1);
            cVar.k(0);
            cVar.a(this.mBitmap, null);
            invalidate();
        }
    }

    public void play() {
        com.baidu.adp.gif.c cVar;
        if (this.Tn != null && (cVar = this.Tn.get()) != null) {
            if (this.To != 0) {
                this.To = 0;
            }
            cVar.k(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, cVar.l(this.To));
        }
    }

    public void onDestroy() {
        this.Tn = null;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandler.removeMessages(1);
        rX();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.mHandler.removeMessages(1);
        rX();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (!this.Tq) {
            if (i == 4 || i == 8) {
                stop();
            } else if (i == 0) {
                play();
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        com.baidu.adp.gif.c cVar;
        if (!this.Tu && !this.Ts && !this.Ty) {
            super.onDraw(canvas);
        }
        canvas.save();
        if (this.Tn != null && !this.Tu && !this.Ts && !this.Ty && (cVar = this.Tn.get()) != null) {
            cVar.a(null, canvas);
        }
        canvas.restore();
        if (this.Tq) {
            canvas.save();
            this.Tr.draw(canvas);
            canvas.restore();
        }
        if (this.Tu && Tw != null) {
            canvas.save();
            canvas.rotate(this.Tv, (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.5f) + getPaddingLeft(), (((getHeight() - getPaddingTop()) - getPaddingBottom()) * 0.5f) + getPaddingTop());
            canvas.drawBitmap(Tw, this.TC, this.TB, (Paint) null);
            canvas.restore();
        } else if (this.Ts || (this.TF != null && this.TF.Te)) {
            canvas.save();
            this.Tt.draw(canvas);
            canvas.restore();
        } else if (this.Ty) {
            canvas.save();
            this.Tz.draw(canvas);
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
        if (!this.Tu) {
            this.Tu = true;
            rW();
        }
    }

    public void b(boolean z, int i) {
        this.Ty = z;
        if (z) {
            this.Tu = false;
            this.Ts = false;
            if (this.Tz == null || this.TA != i) {
                this.TA = i;
                this.Tz = aw.getDrawable(i);
                int intrinsicWidth = this.Tz.getIntrinsicWidth();
                int intrinsicHeight = this.Tz.getIntrinsicHeight();
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
                this.Tz.setBounds(paddingLeft, paddingTop, intrinsicWidth + paddingLeft, intrinsicHeight + paddingTop);
            }
        }
        invalidate();
    }

    public com.baidu.adp.gif.c getGif() {
        if (this.Tn == null) {
            return null;
        }
        return this.Tn.get();
    }

    public void stopLoading() {
        this.Tu = false;
        removeCallbacks(this);
        invalidate();
    }

    private void rW() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Tv += this.Tx;
        if (this.Tv > 360.0f - this.Tx) {
            this.Tv = 0.0f;
        }
        invalidate();
        rW();
    }

    public void setPlayCallback(d dVar) {
        this.Tp = dVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.Tz != null && this.Tz.isStateful()) {
            this.Tz.setState(getDrawableState());
            invalidate();
        }
    }

    public void a(a aVar) {
        BdUniqueId bdUniqueId;
        boolean z;
        if (aVar == null) {
            this.TF = null;
            return;
        }
        boolean va = com.baidu.tbadk.util.e.va();
        Context context = getContext();
        if (context == null || !(context instanceof com.baidu.adp.base.i)) {
            bdUniqueId = null;
            z = false;
        } else {
            com.baidu.adp.base.i iVar = (com.baidu.adp.base.i) context;
            BdUniqueId uniqueId = iVar.getUniqueId();
            z = iVar.isScroll();
            bdUniqueId = uniqueId;
        }
        if (!(aVar == this.TF && this.TH == bdUniqueId)) {
            rX();
        }
        this.TF = aVar;
        this.TH = bdUniqueId;
        String str = va ? this.TF.Th : this.TF.Tg;
        com.baidu.adp.widget.a.a aVar2 = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.d.ef().a(this.TF.Tf, 20, this.TF.Ti, this.TF.Tf, Boolean.valueOf(va), str);
        if (aVar2 != null) {
            stopLoading();
            setGif(aVar2);
        } else if (this.TF.Te) {
            setGif(null);
        } else if (!com.baidu.adp.lib.f.d.ef().J(20) && this.TG) {
            b(true, this.Tm);
        } else {
            startLoading();
            if (!z) {
                com.baidu.adp.lib.f.d.ef().a(this.TF.Tf, 20, this.TI, 0, 0, this.TH, this.TF.Ti, this.TF.Tf, Boolean.valueOf(va), str);
            }
        }
    }

    public void rX() {
        stopLoading();
        this.Ts = false;
        this.Ty = false;
        if (this.TF != null) {
            com.baidu.adp.lib.f.d.ef().a(this.TF.Tf, 20, this.TI);
        }
    }

    @Override // com.baidu.adp.newwidget.a.i
    public void refresh() {
        a(this.TF);
    }

    public void setSupportNoImage(boolean z) {
        this.TG = z;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(this);
        this.mOnClickListener = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.TF != null) {
            boolean va = com.baidu.tbadk.util.e.va();
            String str = va ? this.TF.Th : this.TF.Tg;
            com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.d.ef().a(this.TF.Tf, 20, this.TF.Ti, this.TF.Tf, Boolean.valueOf(va), str);
            if (aVar != null) {
                this.TF.Te = false;
                setGif(aVar);
            } else {
                startLoading();
                com.baidu.adp.lib.f.d.ef().a(this.TF.Tf, 20, this.TI, 0, 0, this.TH, this.TF.Ti, this.TF.Tf, Boolean.valueOf(va), str);
                return;
            }
        }
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }
}
