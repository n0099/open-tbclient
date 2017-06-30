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
import com.baidu.adp.b.a.i;
import com.baidu.adp.base.j;
import com.baidu.adp.base.k;
import com.baidu.tieba.w;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class GiftGifView extends ImageView implements View.OnClickListener, i, Runnable {
    public static Bitmap aDp;
    private boolean aDA;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> aDC;
    private WeakReference<com.baidu.adp.gif.b> aDE;
    private a aDF;
    private boolean aDG;
    private boolean aDH;
    private int aDh;
    private boolean aDm;
    private Drawable aDn;
    private float aDo;
    private float aDq;
    private final Rect aDu;
    private final Rect aDv;
    private boolean aDw;
    private boolean isHide;
    private Bitmap mBitmap;
    private GifInfo mGifInfo;
    private final Handler mHandler;
    private boolean mIsLoading;
    private View.OnClickListener mOnClickListener;
    private BdUniqueId mPageId;

    /* loaded from: classes.dex */
    public interface a {
        void DZ();

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
        this.aDu = new Rect();
        this.aDv = new Rect();
        this.aDw = true;
        this.isHide = false;
        this.aDG = false;
        this.aDH = false;
        this.mHandler = new c(this, Looper.getMainLooper());
        this.aDC = new d(this);
        this.aDq = 30.0f;
        BitmapDrawable bitmapDrawable = (BitmapDrawable) getResources().getDrawable(w.g.loading);
        if (bitmapDrawable != null) {
            aDp = bitmapDrawable.getBitmap();
            this.aDv.set(0, 0, aDp.getWidth(), aDp.getHeight());
        }
        this.aDn = getResources().getDrawable(w.g.image_group_load_f);
        e(this.aDn);
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
            if (aDp != null) {
                int i6 = i5 / 4;
                int i7 = ((i5 - i6) / 2) + paddingLeft;
                int i8 = ((paddingBottom - i6) / 2) + paddingTop;
                this.aDu.set(i7, i8, i7 + i6, i6 + i8);
            }
            int intrinsicWidth = this.aDn.getIntrinsicWidth();
            int intrinsicHeight = this.aDn.getIntrinsicHeight();
            if (intrinsicWidth > i5) {
                intrinsicWidth = i5;
            }
            if (intrinsicHeight > paddingBottom) {
                intrinsicHeight = paddingBottom;
            }
            int i9 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
            int i10 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
            this.aDn.setBounds(i9, i10, intrinsicWidth + i9, intrinsicHeight + i10);
        }
    }

    public void setGif(com.baidu.adp.widget.a.a aVar) {
        this.aDm = false;
        this.mIsLoading = false;
        if (this.mGifInfo != null) {
            this.mGifInfo.mLoadFailed = false;
        }
        if (aVar == null) {
            this.aDm = true;
            if (this.mGifInfo != null) {
                this.mGifInfo.mLoadFailed = true;
            }
            setImageDrawable(null);
            if (this.aDE != null) {
                this.aDE.clear();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.kN()) {
                aVar.e(this);
                this.mIsLoading = false;
            }
            if (this.aDE != null) {
                this.aDE.clear();
            }
        } else if (this.aDE == null || !aVar.getGif().equals(this.aDE.get())) {
            if (this.mBitmap == null || this.mBitmap.getWidth() != aVar.getGif().getWidth() || this.mBitmap.getHeight() != aVar.getGif().getHeight() || this.aDG) {
                this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
            }
            this.aDE = new WeakReference<>(aVar.getGif());
            aVar.getGif().T(0);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.aDw) {
                play();
            }
        } else {
            aVar.getGif().T(this.aDh);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.aDw) {
                resume();
            }
        }
    }

    public boolean getAutoPlay() {
        return this.aDw;
    }

    public void setAutoPlay(boolean z) {
        this.aDw = z;
    }

    public void resume() {
        com.baidu.adp.gif.b bVar;
        if (this.aDE != null && (bVar = this.aDE.get()) != null) {
            this.aDH = false;
            if (this.isHide) {
                setVisibility(4);
                return;
            }
            this.aDF.onStart();
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageDelayed(1, bVar.U(this.aDh));
            this.mHandler.sendEmptyMessageDelayed(2, 2000L);
        }
    }

    public void stop() {
        com.baidu.adp.gif.b bVar;
        if (this.aDE != null && (bVar = this.aDE.get()) != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.aDh = 0;
            bVar.T(0);
            bVar.a(this.mBitmap, null);
            invalidate();
        }
    }

    public void play() {
        com.baidu.adp.gif.b bVar;
        if (this.aDE != null && (bVar = this.aDE.get()) != null) {
            this.aDH = false;
            if (this.isHide) {
                setVisibility(4);
                return;
            }
            this.aDF.onStart();
            if (this.aDh != 0) {
                this.aDh = 0;
            }
            bVar.T(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageDelayed(1, bVar.U(this.aDh));
            this.mHandler.sendEmptyMessageDelayed(2, 2000L);
        }
    }

    public void setPlayOnce(boolean z) {
        this.aDA = z;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        DY();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.mHandler.removeMessages(1);
        DY();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 4 || i == 8) {
            this.isHide = true;
            stop();
            if (this.aDF != null) {
                this.aDF.onStop();
            }
        } else if (i == 0) {
            play();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        com.baidu.adp.gif.b bVar;
        if (!this.mIsLoading && !this.aDm) {
            super.onDraw(canvas);
        }
        canvas.save();
        if (this.aDE != null && !this.mIsLoading && !this.aDm && (bVar = this.aDE.get()) != null) {
            bVar.a(null, canvas);
        }
        canvas.restore();
        if (this.mIsLoading && aDp != null) {
            canvas.save();
            canvas.rotate(this.aDo, (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.5f) + getPaddingLeft(), (((getHeight() - getPaddingTop()) - getPaddingBottom()) * 0.5f) + getPaddingTop());
            canvas.drawBitmap(aDp, this.aDv, this.aDu, (Paint) null);
            canvas.restore();
        } else if (this.aDm || (this.mGifInfo != null && this.mGifInfo.mLoadFailed)) {
            canvas.save();
            this.aDn.draw(canvas);
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
            DX();
        }
    }

    public com.baidu.adp.gif.b getGif() {
        if (this.aDE == null) {
            return null;
        }
        return this.aDE.get();
    }

    public void stopLoading() {
        this.mIsLoading = false;
        removeCallbacks(this);
        invalidate();
    }

    private void DX() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aDo += this.aDq;
        if (this.aDo > 360.0f - this.aDq) {
            this.aDo = 0.0f;
        }
        invalidate();
        DX();
    }

    public void setPlayCallback(a aVar) {
        this.aDF = aVar;
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
        boolean GH = com.baidu.tbadk.util.i.GH();
        j X = k.X(getContext());
        if (X != null) {
            bdUniqueId = X.getUniqueId();
            z = X.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        boolean z2 = gifInfo == this.mGifInfo && this.mPageId == bdUniqueId;
        this.aDG = !z2;
        if (!z2) {
            DY();
        }
        this.mGifInfo = gifInfo;
        this.mPageId = bdUniqueId;
        String str = GH ? this.mGifInfo.mDynamicUrl : this.mGifInfo.mStaticUrl;
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.fL().a(this.mGifInfo.mSharpText, 20, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(GH), str);
        if (aVar != null) {
            stopLoading();
            setGif(aVar);
        } else if (this.mGifInfo.mLoadFailed) {
            setGif(null);
        } else {
            startLoading();
            if (!z) {
                com.baidu.adp.lib.f.c.fL().a(this.mGifInfo.mSharpText, 20, this.aDC, 0, 0, this.mPageId, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(GH), str);
            }
        }
    }

    public void DY() {
        stopLoading();
        this.aDm = false;
        if (this.mGifInfo != null) {
            com.baidu.adp.lib.f.c.fL().a(this.mGifInfo.mSharpText, 20, this.aDC);
        }
    }

    @Override // com.baidu.adp.b.a.i
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
            boolean GH = com.baidu.tbadk.util.i.GH();
            String str = GH ? this.mGifInfo.mDynamicUrl : this.mGifInfo.mStaticUrl;
            com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.fL().a(this.mGifInfo.mSharpText, 20, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(GH), str);
            if (aVar != null) {
                this.mGifInfo.mLoadFailed = false;
                setGif(aVar);
            } else {
                startLoading();
                com.baidu.adp.lib.f.c.fL().a(this.mGifInfo.mSharpText, 20, this.aDC, 0, 0, this.mPageId, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(GH), str);
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
