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
import com.baidu.tieba.u;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class GiftGifView extends ImageView implements View.OnClickListener, i, Runnable {
    public static Bitmap TA;
    private float TB;
    private final Rect TF;
    private final Rect TG;
    private boolean TH;
    private boolean TI;
    private a TJ;
    private BdUniqueId TL;
    private final com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> TM;
    private g TO;
    private boolean TP;
    private boolean TQ;
    private WeakReference<com.baidu.adp.gif.c> Tr;
    private int Ts;
    private boolean Tw;
    private Drawable Tx;
    private boolean Ty;
    private float Tz;
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
        this.TF = new Rect();
        this.TG = new Rect();
        this.TH = true;
        this.mType = 20;
        this.isHide = false;
        this.TP = false;
        this.TQ = false;
        this.mHandler = new e(this, Looper.getMainLooper());
        this.TM = new f(this);
        this.TB = 30.0f;
        BitmapDrawable bitmapDrawable = (BitmapDrawable) getResources().getDrawable(u.loading);
        if (bitmapDrawable != null) {
            TA = bitmapDrawable.getBitmap();
            this.TG.set(0, 0, TA.getWidth(), TA.getHeight());
        }
        this.Tx = getResources().getDrawable(u.image_group_load_f);
        a(this.Tx);
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
            if (TA != null) {
                int i6 = i5 / 4;
                int i7 = ((i5 - i6) / 2) + paddingLeft;
                int i8 = ((paddingBottom - i6) / 2) + paddingTop;
                this.TF.set(i7, i8, i7 + i6, i6 + i8);
            }
            int intrinsicWidth = this.Tx.getIntrinsicWidth();
            int intrinsicHeight = this.Tx.getIntrinsicHeight();
            if (intrinsicWidth > i5) {
                intrinsicWidth = i5;
            }
            if (intrinsicHeight > paddingBottom) {
                intrinsicHeight = paddingBottom;
            }
            int i9 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
            int i10 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
            this.Tx.setBounds(i9, i10, intrinsicWidth + i9, intrinsicHeight + i10);
        }
    }

    public void setGif(com.baidu.adp.widget.a.a aVar) {
        this.Tw = false;
        this.Ty = false;
        if (this.TJ != null) {
            this.TJ.Ti = false;
        }
        if (aVar == null) {
            this.Tw = true;
            if (this.TJ != null) {
                this.TJ.Ti = true;
            }
            setImageDrawable(null);
            if (this.Tr != null) {
                this.Tr.clear();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.hj()) {
                aVar.a(this);
                this.Ty = false;
            }
            if (this.Tr != null) {
                this.Tr.clear();
            }
        } else if (this.Tr == null || !aVar.getGif().equals(this.Tr.get())) {
            if (this.mBitmap == null || this.mBitmap.getWidth() != aVar.getGif().getWidth() || this.mBitmap.getHeight() != aVar.getGif().getHeight() || this.TP) {
                this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
            }
            this.Tr = new WeakReference<>(aVar.getGif());
            aVar.getGif().k(0);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.TH) {
                play();
            }
        } else {
            aVar.getGif().k(this.Ts);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.TH) {
                resume();
            }
        }
    }

    public boolean getAutoPlay() {
        return this.TH;
    }

    public void setAutoPlay(boolean z) {
        this.TH = z;
    }

    public void resume() {
        com.baidu.adp.gif.c cVar;
        if (this.Tr != null && (cVar = this.Tr.get()) != null) {
            this.TQ = false;
            if (this.isHide) {
                setVisibility(4);
                return;
            }
            this.TO.onStart();
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageDelayed(1, cVar.l(this.Ts));
            this.mHandler.sendEmptyMessageDelayed(2, 2000L);
        }
    }

    public void stop() {
        com.baidu.adp.gif.c cVar;
        if (this.Tr != null && (cVar = this.Tr.get()) != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.Ts = 0;
            cVar.k(0);
            cVar.a(this.mBitmap, null);
            invalidate();
        }
    }

    public void play() {
        com.baidu.adp.gif.c cVar;
        if (this.Tr != null && (cVar = this.Tr.get()) != null) {
            this.TQ = false;
            if (this.isHide) {
                setVisibility(4);
                return;
            }
            this.TO.onStart();
            if (this.Ts != 0) {
                this.Ts = 0;
            }
            cVar.k(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageDelayed(1, cVar.l(this.Ts));
            this.mHandler.sendEmptyMessageDelayed(2, 2000L);
        }
    }

    public void setPlayOnce(boolean z) {
        this.TI = z;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        rZ();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.mHandler.removeMessages(1);
        rZ();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 4 || i == 8) {
            this.isHide = true;
            stop();
            if (this.TO != null) {
                this.TO.onStop();
            }
        } else if (i == 0) {
            play();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        com.baidu.adp.gif.c cVar;
        if (!this.Ty && !this.Tw) {
            super.onDraw(canvas);
        }
        canvas.save();
        if (this.Tr != null && !this.Ty && !this.Tw && (cVar = this.Tr.get()) != null) {
            cVar.a(null, canvas);
        }
        canvas.restore();
        if (this.Ty && TA != null) {
            canvas.save();
            canvas.rotate(this.Tz, (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.5f) + getPaddingLeft(), (((getHeight() - getPaddingTop()) - getPaddingBottom()) * 0.5f) + getPaddingTop());
            canvas.drawBitmap(TA, this.TG, this.TF, (Paint) null);
            canvas.restore();
        } else if (this.Tw || (this.TJ != null && this.TJ.Ti)) {
            canvas.save();
            this.Tx.draw(canvas);
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
        if (!this.Ty) {
            this.Ty = true;
            rY();
        }
    }

    public com.baidu.adp.gif.c getGif() {
        if (this.Tr == null) {
            return null;
        }
        return this.Tr.get();
    }

    public void stopLoading() {
        this.Ty = false;
        removeCallbacks(this);
        invalidate();
    }

    private void rY() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Tz += this.TB;
        if (this.Tz > 360.0f - this.TB) {
            this.Tz = 0.0f;
        }
        invalidate();
        rY();
    }

    public void setPlayCallback(g gVar) {
        this.TO = gVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
    }

    public void a(a aVar) {
        BdUniqueId bdUniqueId;
        boolean z;
        if (aVar == null) {
            this.TJ = null;
            return;
        }
        boolean vc = com.baidu.tbadk.util.e.vc();
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
        boolean z2 = aVar == this.TJ && this.TL == bdUniqueId;
        this.TP = !z2;
        if (!z2) {
            rZ();
        }
        this.TJ = aVar;
        this.TL = bdUniqueId;
        String str = vc ? this.TJ.Tl : this.TJ.Tk;
        com.baidu.adp.widget.a.a aVar2 = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.d.ef().a(this.TJ.Tj, 20, this.TJ.Tm, this.TJ.Tj, Boolean.valueOf(vc), str);
        if (aVar2 != null) {
            stopLoading();
            setGif(aVar2);
        } else if (this.TJ.Ti) {
            setGif(null);
        } else {
            startLoading();
            if (!z) {
                com.baidu.adp.lib.f.d.ef().a(this.TJ.Tj, 20, this.TM, 0, 0, this.TL, this.TJ.Tm, this.TJ.Tj, Boolean.valueOf(vc), str);
            }
        }
    }

    public void rZ() {
        stopLoading();
        this.Tw = false;
        if (this.TJ != null) {
            com.baidu.adp.lib.f.d.ef().a(this.TJ.Tj, 20, this.TM);
        }
    }

    @Override // com.baidu.adp.newwidget.a.i
    public void refresh() {
        a(this.TJ);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(this);
        this.mOnClickListener = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.TJ != null) {
            boolean vc = com.baidu.tbadk.util.e.vc();
            String str = vc ? this.TJ.Tl : this.TJ.Tk;
            com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.d.ef().a(this.TJ.Tj, 20, this.TJ.Tm, this.TJ.Tj, Boolean.valueOf(vc), str);
            if (aVar != null) {
                this.TJ.Ti = false;
                setGif(aVar);
            } else {
                startLoading();
                com.baidu.adp.lib.f.d.ef().a(this.TJ.Tj, 20, this.TM, 0, 0, this.TL, this.TJ.Tm, this.TJ.Tj, Boolean.valueOf(vc), str);
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
