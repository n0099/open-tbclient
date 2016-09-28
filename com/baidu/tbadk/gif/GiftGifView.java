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
import com.baidu.tieba.r;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class GiftGifView extends ImageView implements View.OnClickListener, i, Runnable {
    public static Bitmap axB;
    private BdUniqueId ahL;
    private float axA;
    private float axC;
    private final Rect axG;
    private final Rect axH;
    private boolean axI;
    private boolean axM;
    private com.baidu.tbadk.gif.a axN;
    private final com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> axP;
    private WeakReference<com.baidu.adp.gif.b> axR;
    private a axS;
    private boolean axT;
    private boolean axU;
    private int axu;
    private boolean axy;
    private Drawable axz;
    private boolean isHide;
    private Bitmap mBitmap;
    private final Handler mHandler;
    private boolean mIsLoading;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes.dex */
    public interface a {
        void Ei();

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
        this.axG = new Rect();
        this.axH = new Rect();
        this.axI = true;
        this.isHide = false;
        this.axT = false;
        this.axU = false;
        this.mHandler = new d(this, Looper.getMainLooper());
        this.axP = new e(this);
        this.axC = 30.0f;
        BitmapDrawable bitmapDrawable = (BitmapDrawable) getResources().getDrawable(r.f.loading);
        if (bitmapDrawable != null) {
            axB = bitmapDrawable.getBitmap();
            this.axH.set(0, 0, axB.getWidth(), axB.getHeight());
        }
        this.axz = getResources().getDrawable(r.f.image_group_load_f);
        e(this.axz);
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
            if (axB != null) {
                int i6 = i5 / 4;
                int i7 = ((i5 - i6) / 2) + paddingLeft;
                int i8 = ((paddingBottom - i6) / 2) + paddingTop;
                this.axG.set(i7, i8, i7 + i6, i6 + i8);
            }
            int intrinsicWidth = this.axz.getIntrinsicWidth();
            int intrinsicHeight = this.axz.getIntrinsicHeight();
            if (intrinsicWidth > i5) {
                intrinsicWidth = i5;
            }
            if (intrinsicHeight > paddingBottom) {
                intrinsicHeight = paddingBottom;
            }
            int i9 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
            int i10 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
            this.axz.setBounds(i9, i10, intrinsicWidth + i9, intrinsicHeight + i10);
        }
    }

    public void setGif(com.baidu.adp.widget.a.a aVar) {
        this.axy = false;
        this.mIsLoading = false;
        if (this.axN != null) {
            this.axN.axn = false;
        }
        if (aVar == null) {
            this.axy = true;
            if (this.axN != null) {
                this.axN.axn = true;
            }
            setImageDrawable(null);
            if (this.axR != null) {
                this.axR.clear();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.jT()) {
                aVar.e(this);
                this.mIsLoading = false;
            }
            if (this.axR != null) {
                this.axR.clear();
            }
        } else if (this.axR == null || !aVar.getGif().equals(this.axR.get())) {
            if (this.mBitmap == null || this.mBitmap.getWidth() != aVar.getGif().getWidth() || this.mBitmap.getHeight() != aVar.getGif().getHeight() || this.axT) {
                this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
            }
            this.axR = new WeakReference<>(aVar.getGif());
            aVar.getGif().U(0);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.axI) {
                play();
            }
        } else {
            aVar.getGif().U(this.axu);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.axI) {
                resume();
            }
        }
    }

    public boolean getAutoPlay() {
        return this.axI;
    }

    public void setAutoPlay(boolean z) {
        this.axI = z;
    }

    public void resume() {
        com.baidu.adp.gif.b bVar;
        if (this.axR != null && (bVar = this.axR.get()) != null) {
            this.axU = false;
            if (this.isHide) {
                setVisibility(4);
                return;
            }
            this.axS.onStart();
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageDelayed(1, bVar.V(this.axu));
            this.mHandler.sendEmptyMessageDelayed(2, 2000L);
        }
    }

    public void stop() {
        com.baidu.adp.gif.b bVar;
        if (this.axR != null && (bVar = this.axR.get()) != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.axu = 0;
            bVar.U(0);
            bVar.a(this.mBitmap, null);
            invalidate();
        }
    }

    public void play() {
        com.baidu.adp.gif.b bVar;
        if (this.axR != null && (bVar = this.axR.get()) != null) {
            this.axU = false;
            if (this.isHide) {
                setVisibility(4);
                return;
            }
            this.axS.onStart();
            if (this.axu != 0) {
                this.axu = 0;
            }
            bVar.U(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageDelayed(1, bVar.V(this.axu));
            this.mHandler.sendEmptyMessageDelayed(2, 2000L);
        }
    }

    public void setPlayOnce(boolean z) {
        this.axM = z;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        Eh();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.mHandler.removeMessages(1);
        Eh();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 4 || i == 8) {
            this.isHide = true;
            stop();
            if (this.axS != null) {
                this.axS.onStop();
            }
        } else if (i == 0) {
            play();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        com.baidu.adp.gif.b bVar;
        if (!this.mIsLoading && !this.axy) {
            super.onDraw(canvas);
        }
        canvas.save();
        if (this.axR != null && !this.mIsLoading && !this.axy && (bVar = this.axR.get()) != null) {
            bVar.a(null, canvas);
        }
        canvas.restore();
        if (this.mIsLoading && axB != null) {
            canvas.save();
            canvas.rotate(this.axA, (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.5f) + getPaddingLeft(), (((getHeight() - getPaddingTop()) - getPaddingBottom()) * 0.5f) + getPaddingTop());
            canvas.drawBitmap(axB, this.axH, this.axG, (Paint) null);
            canvas.restore();
        } else if (this.axy || (this.axN != null && this.axN.axn)) {
            canvas.save();
            this.axz.draw(canvas);
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
            Eg();
        }
    }

    public com.baidu.adp.gif.b getGif() {
        if (this.axR == null) {
            return null;
        }
        return this.axR.get();
    }

    public void stopLoading() {
        this.mIsLoading = false;
        removeCallbacks(this);
        invalidate();
    }

    private void Eg() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.axA += this.axC;
        if (this.axA > 360.0f - this.axC) {
            this.axA = 0.0f;
        }
        invalidate();
        Eg();
    }

    public void setPlayCallback(a aVar) {
        this.axS = aVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
    }

    public void a(com.baidu.tbadk.gif.a aVar) {
        BdUniqueId bdUniqueId;
        boolean z;
        if (aVar == null) {
            this.axN = null;
            return;
        }
        boolean GV = h.GV();
        k A = l.A(getContext());
        if (A != null) {
            bdUniqueId = A.getUniqueId();
            z = A.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        boolean z2 = aVar == this.axN && this.ahL == bdUniqueId;
        this.axT = !z2;
        if (!z2) {
            Eh();
        }
        this.axN = aVar;
        this.ahL = bdUniqueId;
        String str = GV ? this.axN.axq : this.axN.axp;
        com.baidu.adp.widget.a.a aVar2 = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.g.c.eA().a(this.axN.axo, 20, this.axN.mGid, this.axN.axo, Boolean.valueOf(GV), str);
        if (aVar2 != null) {
            stopLoading();
            setGif(aVar2);
        } else if (this.axN.axn) {
            setGif(null);
        } else {
            startLoading();
            if (!z) {
                com.baidu.adp.lib.g.c.eA().a(this.axN.axo, 20, this.axP, 0, 0, this.ahL, this.axN.mGid, this.axN.axo, Boolean.valueOf(GV), str);
            }
        }
    }

    public void Eh() {
        stopLoading();
        this.axy = false;
        if (this.axN != null) {
            com.baidu.adp.lib.g.c.eA().a(this.axN.axo, 20, this.axP);
        }
    }

    @Override // com.baidu.adp.newwidget.a.i
    public void refresh() {
        a(this.axN);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(this);
        this.mOnClickListener = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.axN != null) {
            boolean GV = h.GV();
            String str = GV ? this.axN.axq : this.axN.axp;
            com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.g.c.eA().a(this.axN.axo, 20, this.axN.mGid, this.axN.axo, Boolean.valueOf(GV), str);
            if (aVar != null) {
                this.axN.axn = false;
                setGif(aVar);
            } else {
                startLoading();
                com.baidu.adp.lib.g.c.eA().a(this.axN.axo, 20, this.axP, 0, 0, this.ahL, this.axN.mGid, this.axN.axo, Boolean.valueOf(GV), str);
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
