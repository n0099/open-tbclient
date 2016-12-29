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
import com.baidu.tbadk.util.g;
import com.baidu.tieba.r;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class GiftGifView extends ImageView implements View.OnClickListener, i, Runnable {
    public static Bitmap axP;
    private int axI;
    private boolean axM;
    private Drawable axN;
    private float axO;
    private float axQ;
    private final Rect axU;
    private final Rect axV;
    private boolean axW;
    private boolean aya;
    private com.baidu.tbadk.gif.a ayb;
    private BdUniqueId ayd;
    private final com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> aye;
    private WeakReference<com.baidu.adp.gif.b> ayg;
    private a ayh;
    private boolean ayi;
    private boolean ayj;
    private boolean isHide;
    private Bitmap mBitmap;
    private final Handler mHandler;
    private boolean mIsLoading;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes.dex */
    public interface a {
        void DV();

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
        this.axU = new Rect();
        this.axV = new Rect();
        this.axW = true;
        this.isHide = false;
        this.ayi = false;
        this.ayj = false;
        this.mHandler = new d(this, Looper.getMainLooper());
        this.aye = new e(this);
        this.axQ = 30.0f;
        BitmapDrawable bitmapDrawable = (BitmapDrawable) getResources().getDrawable(r.f.loading);
        if (bitmapDrawable != null) {
            axP = bitmapDrawable.getBitmap();
            this.axV.set(0, 0, axP.getWidth(), axP.getHeight());
        }
        this.axN = getResources().getDrawable(r.f.image_group_load_f);
        e(this.axN);
    }

    private void e(Drawable drawable) {
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
            if (axP != null) {
                int i6 = i5 / 4;
                int i7 = ((i5 - i6) / 2) + paddingLeft;
                int i8 = ((paddingBottom - i6) / 2) + paddingTop;
                this.axU.set(i7, i8, i7 + i6, i6 + i8);
            }
            int intrinsicWidth = this.axN.getIntrinsicWidth();
            int intrinsicHeight = this.axN.getIntrinsicHeight();
            if (intrinsicWidth > i5) {
                intrinsicWidth = i5;
            }
            if (intrinsicHeight > paddingBottom) {
                intrinsicHeight = paddingBottom;
            }
            int i9 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
            int i10 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
            this.axN.setBounds(i9, i10, intrinsicWidth + i9, intrinsicHeight + i10);
        }
    }

    public void setGif(com.baidu.adp.widget.a.a aVar) {
        this.axM = false;
        this.mIsLoading = false;
        if (this.ayb != null) {
            this.ayb.axB = false;
        }
        if (aVar == null) {
            this.axM = true;
            if (this.ayb != null) {
                this.ayb.axB = true;
            }
            setImageDrawable(null);
            if (this.ayg != null) {
                this.ayg.clear();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.jT()) {
                aVar.e(this);
                this.mIsLoading = false;
            }
            if (this.ayg != null) {
                this.ayg.clear();
            }
        } else if (this.ayg == null || !aVar.getGif().equals(this.ayg.get())) {
            if (this.mBitmap == null || this.mBitmap.getWidth() != aVar.getGif().getWidth() || this.mBitmap.getHeight() != aVar.getGif().getHeight() || this.ayi) {
                this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
            }
            this.ayg = new WeakReference<>(aVar.getGif());
            aVar.getGif().V(0);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.axW) {
                play();
            }
        } else {
            aVar.getGif().V(this.axI);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.axW) {
                resume();
            }
        }
    }

    public boolean getAutoPlay() {
        return this.axW;
    }

    public void setAutoPlay(boolean z) {
        this.axW = z;
    }

    public void resume() {
        com.baidu.adp.gif.b bVar;
        if (this.ayg != null && (bVar = this.ayg.get()) != null) {
            this.ayj = false;
            if (this.isHide) {
                setVisibility(4);
                return;
            }
            this.ayh.onStart();
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageDelayed(1, bVar.W(this.axI));
            this.mHandler.sendEmptyMessageDelayed(2, 2000L);
        }
    }

    public void stop() {
        com.baidu.adp.gif.b bVar;
        if (this.ayg != null && (bVar = this.ayg.get()) != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.axI = 0;
            bVar.V(0);
            bVar.a(this.mBitmap, null);
            invalidate();
        }
    }

    public void play() {
        com.baidu.adp.gif.b bVar;
        if (this.ayg != null && (bVar = this.ayg.get()) != null) {
            this.ayj = false;
            if (this.isHide) {
                setVisibility(4);
                return;
            }
            this.ayh.onStart();
            if (this.axI != 0) {
                this.axI = 0;
            }
            bVar.V(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageDelayed(1, bVar.W(this.axI));
            this.mHandler.sendEmptyMessageDelayed(2, 2000L);
        }
    }

    public void setPlayOnce(boolean z) {
        this.aya = z;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        DU();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.mHandler.removeMessages(1);
        DU();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 4 || i == 8) {
            this.isHide = true;
            stop();
            if (this.ayh != null) {
                this.ayh.onStop();
            }
        } else if (i == 0) {
            play();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        com.baidu.adp.gif.b bVar;
        if (!this.mIsLoading && !this.axM) {
            super.onDraw(canvas);
        }
        canvas.save();
        if (this.ayg != null && !this.mIsLoading && !this.axM && (bVar = this.ayg.get()) != null) {
            bVar.a(null, canvas);
        }
        canvas.restore();
        if (this.mIsLoading && axP != null) {
            canvas.save();
            canvas.rotate(this.axO, (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.5f) + getPaddingLeft(), (((getHeight() - getPaddingTop()) - getPaddingBottom()) * 0.5f) + getPaddingTop());
            canvas.drawBitmap(axP, this.axV, this.axU, (Paint) null);
            canvas.restore();
        } else if (this.axM || (this.ayb != null && this.ayb.axB)) {
            canvas.save();
            this.axN.draw(canvas);
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
            DT();
        }
    }

    public com.baidu.adp.gif.b getGif() {
        if (this.ayg == null) {
            return null;
        }
        return this.ayg.get();
    }

    public void stopLoading() {
        this.mIsLoading = false;
        removeCallbacks(this);
        invalidate();
    }

    private void DT() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.axO += this.axQ;
        if (this.axO > 360.0f - this.axQ) {
            this.axO = 0.0f;
        }
        invalidate();
        DT();
    }

    public void setPlayCallback(a aVar) {
        this.ayh = aVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
    }

    public void a(com.baidu.tbadk.gif.a aVar) {
        BdUniqueId bdUniqueId;
        boolean z;
        if (aVar == null) {
            this.ayb = null;
            return;
        }
        boolean Gu = g.Gu();
        k A = l.A(getContext());
        if (A != null) {
            bdUniqueId = A.getUniqueId();
            z = A.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        boolean z2 = aVar == this.ayb && this.ayd == bdUniqueId;
        this.ayi = !z2;
        if (!z2) {
            DU();
        }
        this.ayb = aVar;
        this.ayd = bdUniqueId;
        String str = Gu ? this.ayb.axE : this.ayb.axD;
        com.baidu.adp.widget.a.a aVar2 = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.g.c.eA().a(this.ayb.axC, 20, this.ayb.mGid, this.ayb.axC, Boolean.valueOf(Gu), str);
        if (aVar2 != null) {
            stopLoading();
            setGif(aVar2);
        } else if (this.ayb.axB) {
            setGif(null);
        } else {
            startLoading();
            if (!z) {
                com.baidu.adp.lib.g.c.eA().a(this.ayb.axC, 20, this.aye, 0, 0, this.ayd, this.ayb.mGid, this.ayb.axC, Boolean.valueOf(Gu), str);
            }
        }
    }

    public void DU() {
        stopLoading();
        this.axM = false;
        if (this.ayb != null) {
            com.baidu.adp.lib.g.c.eA().a(this.ayb.axC, 20, this.aye);
        }
    }

    @Override // com.baidu.adp.newwidget.a.i
    public void refresh() {
        a(this.ayb);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(this);
        this.mOnClickListener = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ayb != null) {
            boolean Gu = g.Gu();
            String str = Gu ? this.ayb.axE : this.ayb.axD;
            com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.g.c.eA().a(this.ayb.axC, 20, this.ayb.mGid, this.ayb.axC, Boolean.valueOf(Gu), str);
            if (aVar != null) {
                this.ayb.axB = false;
                setGif(aVar);
            } else {
                startLoading();
                com.baidu.adp.lib.g.c.eA().a(this.ayb.axC, 20, this.aye, 0, 0, this.ayd, this.ayb.mGid, this.ayb.axC, Boolean.valueOf(Gu), str);
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
