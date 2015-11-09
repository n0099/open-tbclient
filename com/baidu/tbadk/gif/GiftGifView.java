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
    public static Bitmap ask;
    private boolean asA;
    private WeakReference<com.baidu.adp.gif.b> asb;
    private int asc;
    private boolean asg;
    private Drawable ash;
    private boolean asi;
    private float asj;
    private float asl;
    private final Rect asp;
    private final Rect asq;
    private boolean asr;
    private boolean ass;
    private com.baidu.tbadk.gif.a ast;
    private BdUniqueId asv;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> asw;
    private a asy;
    private boolean asz;
    private boolean isHide;
    private Bitmap mBitmap;
    private final Handler mHandler;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes.dex */
    public interface a {
        void BT();

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
        this.asp = new Rect();
        this.asq = new Rect();
        this.asr = true;
        this.isHide = false;
        this.asz = false;
        this.asA = false;
        this.mHandler = new d(this, Looper.getMainLooper());
        this.asw = new e(this);
        this.asl = 30.0f;
        BitmapDrawable bitmapDrawable = (BitmapDrawable) getResources().getDrawable(i.e.loading);
        if (bitmapDrawable != null) {
            ask = bitmapDrawable.getBitmap();
            this.asq.set(0, 0, ask.getWidth(), ask.getHeight());
        }
        this.ash = getResources().getDrawable(i.e.image_group_load_f);
        c(this.ash);
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
            if (ask != null) {
                int i6 = i5 / 4;
                int i7 = ((i5 - i6) / 2) + paddingLeft;
                int i8 = ((paddingBottom - i6) / 2) + paddingTop;
                this.asp.set(i7, i8, i7 + i6, i6 + i8);
            }
            int intrinsicWidth = this.ash.getIntrinsicWidth();
            int intrinsicHeight = this.ash.getIntrinsicHeight();
            if (intrinsicWidth > i5) {
                intrinsicWidth = i5;
            }
            if (intrinsicHeight > paddingBottom) {
                intrinsicHeight = paddingBottom;
            }
            int i9 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
            int i10 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
            this.ash.setBounds(i9, i10, intrinsicWidth + i9, intrinsicHeight + i10);
        }
    }

    public void setGif(com.baidu.adp.widget.a.a aVar) {
        this.asg = false;
        this.asi = false;
        if (this.ast != null) {
            this.ast.arT = false;
        }
        if (aVar == null) {
            this.asg = true;
            if (this.ast != null) {
                this.ast.arT = true;
            }
            setImageDrawable(null);
            if (this.asb != null) {
                this.asb.clear();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.mZ()) {
                aVar.a(this);
                this.asi = false;
            }
            if (this.asb != null) {
                this.asb.clear();
            }
        } else if (this.asb == null || !aVar.getGif().equals(this.asb.get())) {
            if (this.mBitmap == null || this.mBitmap.getWidth() != aVar.getGif().getWidth() || this.mBitmap.getHeight() != aVar.getGif().getHeight() || this.asz) {
                this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
            }
            this.asb = new WeakReference<>(aVar.getGif());
            aVar.getGif().F(0);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.asr) {
                play();
            }
        } else {
            aVar.getGif().F(this.asc);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.asr) {
                resume();
            }
        }
    }

    public boolean getAutoPlay() {
        return this.asr;
    }

    public void setAutoPlay(boolean z) {
        this.asr = z;
    }

    public void resume() {
        com.baidu.adp.gif.b bVar;
        if (this.asb != null && (bVar = this.asb.get()) != null) {
            this.asA = false;
            if (this.isHide) {
                setVisibility(4);
                return;
            }
            this.asy.onStart();
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageDelayed(1, bVar.G(this.asc));
            this.mHandler.sendEmptyMessageDelayed(2, 2000L);
        }
    }

    public void stop() {
        com.baidu.adp.gif.b bVar;
        if (this.asb != null && (bVar = this.asb.get()) != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.asc = 0;
            bVar.F(0);
            bVar.a(this.mBitmap, null);
            invalidate();
        }
    }

    public void play() {
        com.baidu.adp.gif.b bVar;
        if (this.asb != null && (bVar = this.asb.get()) != null) {
            this.asA = false;
            if (this.isHide) {
                setVisibility(4);
                return;
            }
            this.asy.onStart();
            if (this.asc != 0) {
                this.asc = 0;
            }
            bVar.F(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageDelayed(1, bVar.G(this.asc));
            this.mHandler.sendEmptyMessageDelayed(2, 2000L);
        }
    }

    public void setPlayOnce(boolean z) {
        this.ass = z;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        BS();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.mHandler.removeMessages(1);
        BS();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 4 || i == 8) {
            this.isHide = true;
            stop();
            if (this.asy != null) {
                this.asy.onStop();
            }
        } else if (i == 0) {
            play();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        com.baidu.adp.gif.b bVar;
        if (!this.asi && !this.asg) {
            super.onDraw(canvas);
        }
        canvas.save();
        if (this.asb != null && !this.asi && !this.asg && (bVar = this.asb.get()) != null) {
            bVar.a(null, canvas);
        }
        canvas.restore();
        if (this.asi && ask != null) {
            canvas.save();
            canvas.rotate(this.asj, (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.5f) + getPaddingLeft(), (((getHeight() - getPaddingTop()) - getPaddingBottom()) * 0.5f) + getPaddingTop());
            canvas.drawBitmap(ask, this.asq, this.asp, (Paint) null);
            canvas.restore();
        } else if (this.asg || (this.ast != null && this.ast.arT)) {
            canvas.save();
            this.ash.draw(canvas);
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
        if (!this.asi) {
            this.asi = true;
            BR();
        }
    }

    public com.baidu.adp.gif.b getGif() {
        if (this.asb == null) {
            return null;
        }
        return this.asb.get();
    }

    public void stopLoading() {
        this.asi = false;
        removeCallbacks(this);
        invalidate();
    }

    private void BR() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.asj += this.asl;
        if (this.asj > 360.0f - this.asl) {
            this.asj = 0.0f;
        }
        invalidate();
        BR();
    }

    public void setPlayCallback(a aVar) {
        this.asy = aVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
    }

    public void a(com.baidu.tbadk.gif.a aVar) {
        BdUniqueId bdUniqueId;
        boolean z;
        if (aVar == null) {
            this.ast = null;
            return;
        }
        boolean Ep = com.baidu.tbadk.util.e.Ep();
        k A = l.A(getContext());
        if (A != null) {
            bdUniqueId = A.getUniqueId();
            z = A.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        boolean z2 = aVar == this.ast && this.asv == bdUniqueId;
        this.asz = !z2;
        if (!z2) {
            BS();
        }
        this.ast = aVar;
        this.asv = bdUniqueId;
        String str = Ep ? this.ast.arW : this.ast.arV;
        com.baidu.adp.widget.a.a aVar2 = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.hb().a(this.ast.arU, 20, this.ast.mGid, this.ast.arU, Boolean.valueOf(Ep), str);
        if (aVar2 != null) {
            stopLoading();
            setGif(aVar2);
        } else if (this.ast.arT) {
            setGif(null);
        } else {
            startLoading();
            if (!z) {
                com.baidu.adp.lib.f.c.hb().a(this.ast.arU, 20, this.asw, 0, 0, this.asv, this.ast.mGid, this.ast.arU, Boolean.valueOf(Ep), str);
            }
        }
    }

    public void BS() {
        stopLoading();
        this.asg = false;
        if (this.ast != null) {
            com.baidu.adp.lib.f.c.hb().a(this.ast.arU, 20, this.asw);
        }
    }

    @Override // com.baidu.adp.newwidget.a.i
    public void refresh() {
        a(this.ast);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(this);
        this.mOnClickListener = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ast != null) {
            boolean Ep = com.baidu.tbadk.util.e.Ep();
            String str = Ep ? this.ast.arW : this.ast.arV;
            com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.hb().a(this.ast.arU, 20, this.ast.mGid, this.ast.arU, Boolean.valueOf(Ep), str);
            if (aVar != null) {
                this.ast.arT = false;
                setGif(aVar);
            } else {
                startLoading();
                com.baidu.adp.lib.f.c.hb().a(this.ast.arU, 20, this.asw, 0, 0, this.asv, this.ast.mGid, this.ast.arU, Boolean.valueOf(Ep), str);
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
