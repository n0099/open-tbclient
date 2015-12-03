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
import com.baidu.tieba.n;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class GiftGifView extends ImageView implements View.OnClickListener, i, Runnable {
    public static Bitmap auj;
    private WeakReference<com.baidu.adp.gif.b> auA;
    private a auB;
    private boolean auC;
    private boolean auD;
    private int auc;
    private boolean aug;
    private Drawable auh;
    private float aui;
    private float auk;
    private final Rect auo;
    private final Rect aup;
    private boolean auq;
    private boolean auu;
    private com.baidu.tbadk.gif.a auv;
    private BdUniqueId aux;
    private final com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> auy;
    private boolean isHide;
    private Bitmap mBitmap;
    private final Handler mHandler;
    private boolean mIsLoading;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes.dex */
    public interface a {
        void CV();

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
        this.auo = new Rect();
        this.aup = new Rect();
        this.auq = true;
        this.isHide = false;
        this.auC = false;
        this.auD = false;
        this.mHandler = new d(this, Looper.getMainLooper());
        this.auy = new e(this);
        this.auk = 30.0f;
        BitmapDrawable bitmapDrawable = (BitmapDrawable) getResources().getDrawable(n.e.loading);
        if (bitmapDrawable != null) {
            auj = bitmapDrawable.getBitmap();
            this.aup.set(0, 0, auj.getWidth(), auj.getHeight());
        }
        this.auh = getResources().getDrawable(n.e.image_group_load_f);
        c(this.auh);
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
            if (auj != null) {
                int i6 = i5 / 4;
                int i7 = ((i5 - i6) / 2) + paddingLeft;
                int i8 = ((paddingBottom - i6) / 2) + paddingTop;
                this.auo.set(i7, i8, i7 + i6, i6 + i8);
            }
            int intrinsicWidth = this.auh.getIntrinsicWidth();
            int intrinsicHeight = this.auh.getIntrinsicHeight();
            if (intrinsicWidth > i5) {
                intrinsicWidth = i5;
            }
            if (intrinsicHeight > paddingBottom) {
                intrinsicHeight = paddingBottom;
            }
            int i9 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
            int i10 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
            this.auh.setBounds(i9, i10, intrinsicWidth + i9, intrinsicHeight + i10);
        }
    }

    public void setGif(com.baidu.adp.widget.a.a aVar) {
        this.aug = false;
        this.mIsLoading = false;
        if (this.auv != null) {
            this.auv.atU = false;
        }
        if (aVar == null) {
            this.aug = true;
            if (this.auv != null) {
                this.auv.atU = true;
            }
            setImageDrawable(null);
            if (this.auA != null) {
                this.auA.clear();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.ne()) {
                aVar.a(this);
                this.mIsLoading = false;
            }
            if (this.auA != null) {
                this.auA.clear();
            }
        } else if (this.auA == null || !aVar.getGif().equals(this.auA.get())) {
            if (this.mBitmap == null || this.mBitmap.getWidth() != aVar.getGif().getWidth() || this.mBitmap.getHeight() != aVar.getGif().getHeight() || this.auC) {
                this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
            }
            this.auA = new WeakReference<>(aVar.getGif());
            aVar.getGif().G(0);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.auq) {
                play();
            }
        } else {
            aVar.getGif().G(this.auc);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.auq) {
                resume();
            }
        }
    }

    public boolean getAutoPlay() {
        return this.auq;
    }

    public void setAutoPlay(boolean z) {
        this.auq = z;
    }

    public void resume() {
        com.baidu.adp.gif.b bVar;
        if (this.auA != null && (bVar = this.auA.get()) != null) {
            this.auD = false;
            if (this.isHide) {
                setVisibility(4);
                return;
            }
            this.auB.onStart();
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageDelayed(1, bVar.H(this.auc));
            this.mHandler.sendEmptyMessageDelayed(2, 2000L);
        }
    }

    public void stop() {
        com.baidu.adp.gif.b bVar;
        if (this.auA != null && (bVar = this.auA.get()) != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.auc = 0;
            bVar.G(0);
            bVar.a(this.mBitmap, null);
            invalidate();
        }
    }

    public void play() {
        com.baidu.adp.gif.b bVar;
        if (this.auA != null && (bVar = this.auA.get()) != null) {
            this.auD = false;
            if (this.isHide) {
                setVisibility(4);
                return;
            }
            this.auB.onStart();
            if (this.auc != 0) {
                this.auc = 0;
            }
            bVar.G(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageDelayed(1, bVar.H(this.auc));
            this.mHandler.sendEmptyMessageDelayed(2, 2000L);
        }
    }

    public void setPlayOnce(boolean z) {
        this.auu = z;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        CU();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.mHandler.removeMessages(1);
        CU();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 4 || i == 8) {
            this.isHide = true;
            stop();
            if (this.auB != null) {
                this.auB.onStop();
            }
        } else if (i == 0) {
            play();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        com.baidu.adp.gif.b bVar;
        if (!this.mIsLoading && !this.aug) {
            super.onDraw(canvas);
        }
        canvas.save();
        if (this.auA != null && !this.mIsLoading && !this.aug && (bVar = this.auA.get()) != null) {
            bVar.a(null, canvas);
        }
        canvas.restore();
        if (this.mIsLoading && auj != null) {
            canvas.save();
            canvas.rotate(this.aui, (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.5f) + getPaddingLeft(), (((getHeight() - getPaddingTop()) - getPaddingBottom()) * 0.5f) + getPaddingTop());
            canvas.drawBitmap(auj, this.aup, this.auo, (Paint) null);
            canvas.restore();
        } else if (this.aug || (this.auv != null && this.auv.atU)) {
            canvas.save();
            this.auh.draw(canvas);
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
            CT();
        }
    }

    public com.baidu.adp.gif.b getGif() {
        if (this.auA == null) {
            return null;
        }
        return this.auA.get();
    }

    public void stopLoading() {
        this.mIsLoading = false;
        removeCallbacks(this);
        invalidate();
    }

    private void CT() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aui += this.auk;
        if (this.aui > 360.0f - this.auk) {
            this.aui = 0.0f;
        }
        invalidate();
        CT();
    }

    public void setPlayCallback(a aVar) {
        this.auB = aVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
    }

    public void a(com.baidu.tbadk.gif.a aVar) {
        BdUniqueId bdUniqueId;
        boolean z;
        if (aVar == null) {
            this.auv = null;
            return;
        }
        boolean Fr = com.baidu.tbadk.util.e.Fr();
        k A = l.A(getContext());
        if (A != null) {
            bdUniqueId = A.getUniqueId();
            z = A.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        boolean z2 = aVar == this.auv && this.aux == bdUniqueId;
        this.auC = !z2;
        if (!z2) {
            CU();
        }
        this.auv = aVar;
        this.aux = bdUniqueId;
        String str = Fr ? this.auv.atX : this.auv.atW;
        com.baidu.adp.widget.a.a aVar2 = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.g.c.hd().a(this.auv.atV, 20, this.auv.mGid, this.auv.atV, Boolean.valueOf(Fr), str);
        if (aVar2 != null) {
            stopLoading();
            setGif(aVar2);
        } else if (this.auv.atU) {
            setGif(null);
        } else {
            startLoading();
            if (!z) {
                com.baidu.adp.lib.g.c.hd().a(this.auv.atV, 20, this.auy, 0, 0, this.aux, this.auv.mGid, this.auv.atV, Boolean.valueOf(Fr), str);
            }
        }
    }

    public void CU() {
        stopLoading();
        this.aug = false;
        if (this.auv != null) {
            com.baidu.adp.lib.g.c.hd().a(this.auv.atV, 20, this.auy);
        }
    }

    @Override // com.baidu.adp.newwidget.a.i
    public void refresh() {
        a(this.auv);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(this);
        this.mOnClickListener = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.auv != null) {
            boolean Fr = com.baidu.tbadk.util.e.Fr();
            String str = Fr ? this.auv.atX : this.auv.atW;
            com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.g.c.hd().a(this.auv.atV, 20, this.auv.mGid, this.auv.atV, Boolean.valueOf(Fr), str);
            if (aVar != null) {
                this.auv.atU = false;
                setGif(aVar);
            } else {
                startLoading();
                com.baidu.adp.lib.g.c.hd().a(this.auv.atV, 20, this.auy, 0, 0, this.aux, this.auv.mGid, this.auv.atV, Boolean.valueOf(Fr), str);
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
