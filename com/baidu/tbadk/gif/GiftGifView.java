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
import com.baidu.adp.base.j;
import com.baidu.adp.base.k;
import com.baidu.adp.newwidget.a.i;
import com.baidu.tbadk.util.g;
import com.baidu.tieba.w;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class GiftGifView extends ImageView implements View.OnClickListener, i, Runnable {
    public static Bitmap aCh;
    private int aCa;
    private boolean aCe;
    private Drawable aCf;
    private float aCg;
    private float aCi;
    private final Rect aCm;
    private final Rect aCn;
    private boolean aCo;
    private boolean aCs;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> aCu;
    private WeakReference<com.baidu.adp.gif.b> aCw;
    private a aCx;
    private boolean aCy;
    private boolean aCz;
    private boolean isHide;
    private Bitmap mBitmap;
    private GifInfo mGifInfo;
    private final Handler mHandler;
    private boolean mIsLoading;
    private View.OnClickListener mOnClickListener;
    private BdUniqueId mPageId;

    /* loaded from: classes.dex */
    public interface a {
        void Ej();

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
        this.aCm = new Rect();
        this.aCn = new Rect();
        this.aCo = true;
        this.isHide = false;
        this.aCy = false;
        this.aCz = false;
        this.mHandler = new c(this, Looper.getMainLooper());
        this.aCu = new d(this);
        this.aCi = 30.0f;
        BitmapDrawable bitmapDrawable = (BitmapDrawable) getResources().getDrawable(w.g.loading);
        if (bitmapDrawable != null) {
            aCh = bitmapDrawable.getBitmap();
            this.aCn.set(0, 0, aCh.getWidth(), aCh.getHeight());
        }
        this.aCf = getResources().getDrawable(w.g.image_group_load_f);
        e(this.aCf);
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
            if (aCh != null) {
                int i6 = i5 / 4;
                int i7 = ((i5 - i6) / 2) + paddingLeft;
                int i8 = ((paddingBottom - i6) / 2) + paddingTop;
                this.aCm.set(i7, i8, i7 + i6, i6 + i8);
            }
            int intrinsicWidth = this.aCf.getIntrinsicWidth();
            int intrinsicHeight = this.aCf.getIntrinsicHeight();
            if (intrinsicWidth > i5) {
                intrinsicWidth = i5;
            }
            if (intrinsicHeight > paddingBottom) {
                intrinsicHeight = paddingBottom;
            }
            int i9 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
            int i10 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
            this.aCf.setBounds(i9, i10, intrinsicWidth + i9, intrinsicHeight + i10);
        }
    }

    public void setGif(com.baidu.adp.widget.a.a aVar) {
        this.aCe = false;
        this.mIsLoading = false;
        if (this.mGifInfo != null) {
            this.mGifInfo.mLoadFailed = false;
        }
        if (aVar == null) {
            this.aCe = true;
            if (this.mGifInfo != null) {
                this.mGifInfo.mLoadFailed = true;
            }
            setImageDrawable(null);
            if (this.aCw != null) {
                this.aCw.clear();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.kL()) {
                aVar.e(this);
                this.mIsLoading = false;
            }
            if (this.aCw != null) {
                this.aCw.clear();
            }
        } else if (this.aCw == null || !aVar.getGif().equals(this.aCw.get())) {
            if (this.mBitmap == null || this.mBitmap.getWidth() != aVar.getGif().getWidth() || this.mBitmap.getHeight() != aVar.getGif().getHeight() || this.aCy) {
                this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
            }
            this.aCw = new WeakReference<>(aVar.getGif());
            aVar.getGif().V(0);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.aCo) {
                play();
            }
        } else {
            aVar.getGif().V(this.aCa);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.aCo) {
                resume();
            }
        }
    }

    public boolean getAutoPlay() {
        return this.aCo;
    }

    public void setAutoPlay(boolean z) {
        this.aCo = z;
    }

    public void resume() {
        com.baidu.adp.gif.b bVar;
        if (this.aCw != null && (bVar = this.aCw.get()) != null) {
            this.aCz = false;
            if (this.isHide) {
                setVisibility(4);
                return;
            }
            this.aCx.onStart();
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageDelayed(1, bVar.W(this.aCa));
            this.mHandler.sendEmptyMessageDelayed(2, 2000L);
        }
    }

    public void stop() {
        com.baidu.adp.gif.b bVar;
        if (this.aCw != null && (bVar = this.aCw.get()) != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.aCa = 0;
            bVar.V(0);
            bVar.a(this.mBitmap, null);
            invalidate();
        }
    }

    public void play() {
        com.baidu.adp.gif.b bVar;
        if (this.aCw != null && (bVar = this.aCw.get()) != null) {
            this.aCz = false;
            if (this.isHide) {
                setVisibility(4);
                return;
            }
            this.aCx.onStart();
            if (this.aCa != 0) {
                this.aCa = 0;
            }
            bVar.V(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageDelayed(1, bVar.W(this.aCa));
            this.mHandler.sendEmptyMessageDelayed(2, 2000L);
        }
    }

    public void setPlayOnce(boolean z) {
        this.aCs = z;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        Ei();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.mHandler.removeMessages(1);
        Ei();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 4 || i == 8) {
            this.isHide = true;
            stop();
            if (this.aCx != null) {
                this.aCx.onStop();
            }
        } else if (i == 0) {
            play();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        com.baidu.adp.gif.b bVar;
        if (!this.mIsLoading && !this.aCe) {
            super.onDraw(canvas);
        }
        canvas.save();
        if (this.aCw != null && !this.mIsLoading && !this.aCe && (bVar = this.aCw.get()) != null) {
            bVar.a(null, canvas);
        }
        canvas.restore();
        if (this.mIsLoading && aCh != null) {
            canvas.save();
            canvas.rotate(this.aCg, (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.5f) + getPaddingLeft(), (((getHeight() - getPaddingTop()) - getPaddingBottom()) * 0.5f) + getPaddingTop());
            canvas.drawBitmap(aCh, this.aCn, this.aCm, (Paint) null);
            canvas.restore();
        } else if (this.aCe || (this.mGifInfo != null && this.mGifInfo.mLoadFailed)) {
            canvas.save();
            this.aCf.draw(canvas);
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
            Eh();
        }
    }

    public com.baidu.adp.gif.b getGif() {
        if (this.aCw == null) {
            return null;
        }
        return this.aCw.get();
    }

    public void stopLoading() {
        this.mIsLoading = false;
        removeCallbacks(this);
        invalidate();
    }

    private void Eh() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aCg += this.aCi;
        if (this.aCg > 360.0f - this.aCi) {
            this.aCg = 0.0f;
        }
        invalidate();
        Eh();
    }

    public void setPlayCallback(a aVar) {
        this.aCx = aVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
    }

    public void a(GifInfo gifInfo) {
        BdUniqueId bdUniqueId;
        boolean z;
        if (gifInfo == null) {
            this.mGifInfo = null;
            return;
        }
        boolean GL = g.GL();
        j Y = k.Y(getContext());
        if (Y != null) {
            bdUniqueId = Y.getUniqueId();
            z = Y.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        boolean z2 = gifInfo == this.mGifInfo && this.mPageId == bdUniqueId;
        this.aCy = !z2;
        if (!z2) {
            Ei();
        }
        this.mGifInfo = gifInfo;
        this.mPageId = bdUniqueId;
        String str = GL ? this.mGifInfo.mDynamicUrl : this.mGifInfo.mStaticUrl;
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.fG().a(this.mGifInfo.mSharpText, 20, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(GL), str);
        if (aVar != null) {
            stopLoading();
            setGif(aVar);
        } else if (this.mGifInfo.mLoadFailed) {
            setGif(null);
        } else {
            startLoading();
            if (!z) {
                com.baidu.adp.lib.f.c.fG().a(this.mGifInfo.mSharpText, 20, this.aCu, 0, 0, this.mPageId, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(GL), str);
            }
        }
    }

    public void Ei() {
        stopLoading();
        this.aCe = false;
        if (this.mGifInfo != null) {
            com.baidu.adp.lib.f.c.fG().a(this.mGifInfo.mSharpText, 20, this.aCu);
        }
    }

    @Override // com.baidu.adp.newwidget.a.i
    public void refresh() {
        a(this.mGifInfo);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(this);
        this.mOnClickListener = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mGifInfo != null) {
            boolean GL = g.GL();
            String str = GL ? this.mGifInfo.mDynamicUrl : this.mGifInfo.mStaticUrl;
            com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.fG().a(this.mGifInfo.mSharpText, 20, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(GL), str);
            if (aVar != null) {
                this.mGifInfo.mLoadFailed = false;
                setGif(aVar);
            } else {
                startLoading();
                com.baidu.adp.lib.f.c.fG().a(this.mGifInfo.mSharpText, 20, this.aCu, 0, 0, this.mPageId, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(GL), str);
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
