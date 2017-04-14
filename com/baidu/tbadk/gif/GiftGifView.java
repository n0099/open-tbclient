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
    public static Bitmap aCx;
    private final Rect aCC;
    private final Rect aCD;
    private boolean aCE;
    private boolean aCI;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> aCK;
    private WeakReference<com.baidu.adp.gif.b> aCM;
    private a aCN;
    private boolean aCO;
    private boolean aCP;
    private int aCq;
    private boolean aCu;
    private Drawable aCv;
    private float aCw;
    private float aCy;
    private boolean isHide;
    private Bitmap mBitmap;
    private GifInfo mGifInfo;
    private final Handler mHandler;
    private boolean mIsLoading;
    private View.OnClickListener mOnClickListener;
    private BdUniqueId mPageId;

    /* loaded from: classes.dex */
    public interface a {
        void EH();

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
        this.aCC = new Rect();
        this.aCD = new Rect();
        this.aCE = true;
        this.isHide = false;
        this.aCO = false;
        this.aCP = false;
        this.mHandler = new c(this, Looper.getMainLooper());
        this.aCK = new d(this);
        this.aCy = 30.0f;
        BitmapDrawable bitmapDrawable = (BitmapDrawable) getResources().getDrawable(w.g.loading);
        if (bitmapDrawable != null) {
            aCx = bitmapDrawable.getBitmap();
            this.aCD.set(0, 0, aCx.getWidth(), aCx.getHeight());
        }
        this.aCv = getResources().getDrawable(w.g.image_group_load_f);
        e(this.aCv);
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
            if (aCx != null) {
                int i6 = i5 / 4;
                int i7 = ((i5 - i6) / 2) + paddingLeft;
                int i8 = ((paddingBottom - i6) / 2) + paddingTop;
                this.aCC.set(i7, i8, i7 + i6, i6 + i8);
            }
            int intrinsicWidth = this.aCv.getIntrinsicWidth();
            int intrinsicHeight = this.aCv.getIntrinsicHeight();
            if (intrinsicWidth > i5) {
                intrinsicWidth = i5;
            }
            if (intrinsicHeight > paddingBottom) {
                intrinsicHeight = paddingBottom;
            }
            int i9 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
            int i10 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
            this.aCv.setBounds(i9, i10, intrinsicWidth + i9, intrinsicHeight + i10);
        }
    }

    public void setGif(com.baidu.adp.widget.a.a aVar) {
        this.aCu = false;
        this.mIsLoading = false;
        if (this.mGifInfo != null) {
            this.mGifInfo.mLoadFailed = false;
        }
        if (aVar == null) {
            this.aCu = true;
            if (this.mGifInfo != null) {
                this.mGifInfo.mLoadFailed = true;
            }
            setImageDrawable(null);
            if (this.aCM != null) {
                this.aCM.clear();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.kP()) {
                aVar.e(this);
                this.mIsLoading = false;
            }
            if (this.aCM != null) {
                this.aCM.clear();
            }
        } else if (this.aCM == null || !aVar.getGif().equals(this.aCM.get())) {
            if (this.mBitmap == null || this.mBitmap.getWidth() != aVar.getGif().getWidth() || this.mBitmap.getHeight() != aVar.getGif().getHeight() || this.aCO) {
                this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
            }
            this.aCM = new WeakReference<>(aVar.getGif());
            aVar.getGif().T(0);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.aCE) {
                play();
            }
        } else {
            aVar.getGif().T(this.aCq);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.aCE) {
                resume();
            }
        }
    }

    public boolean getAutoPlay() {
        return this.aCE;
    }

    public void setAutoPlay(boolean z) {
        this.aCE = z;
    }

    public void resume() {
        com.baidu.adp.gif.b bVar;
        if (this.aCM != null && (bVar = this.aCM.get()) != null) {
            this.aCP = false;
            if (this.isHide) {
                setVisibility(4);
                return;
            }
            this.aCN.onStart();
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageDelayed(1, bVar.U(this.aCq));
            this.mHandler.sendEmptyMessageDelayed(2, 2000L);
        }
    }

    public void stop() {
        com.baidu.adp.gif.b bVar;
        if (this.aCM != null && (bVar = this.aCM.get()) != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.aCq = 0;
            bVar.T(0);
            bVar.a(this.mBitmap, null);
            invalidate();
        }
    }

    public void play() {
        com.baidu.adp.gif.b bVar;
        if (this.aCM != null && (bVar = this.aCM.get()) != null) {
            this.aCP = false;
            if (this.isHide) {
                setVisibility(4);
                return;
            }
            this.aCN.onStart();
            if (this.aCq != 0) {
                this.aCq = 0;
            }
            bVar.T(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageDelayed(1, bVar.U(this.aCq));
            this.mHandler.sendEmptyMessageDelayed(2, 2000L);
        }
    }

    public void setPlayOnce(boolean z) {
        this.aCI = z;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        EG();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.mHandler.removeMessages(1);
        EG();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 4 || i == 8) {
            this.isHide = true;
            stop();
            if (this.aCN != null) {
                this.aCN.onStop();
            }
        } else if (i == 0) {
            play();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        com.baidu.adp.gif.b bVar;
        if (!this.mIsLoading && !this.aCu) {
            super.onDraw(canvas);
        }
        canvas.save();
        if (this.aCM != null && !this.mIsLoading && !this.aCu && (bVar = this.aCM.get()) != null) {
            bVar.a(null, canvas);
        }
        canvas.restore();
        if (this.mIsLoading && aCx != null) {
            canvas.save();
            canvas.rotate(this.aCw, (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.5f) + getPaddingLeft(), (((getHeight() - getPaddingTop()) - getPaddingBottom()) * 0.5f) + getPaddingTop());
            canvas.drawBitmap(aCx, this.aCD, this.aCC, (Paint) null);
            canvas.restore();
        } else if (this.aCu || (this.mGifInfo != null && this.mGifInfo.mLoadFailed)) {
            canvas.save();
            this.aCv.draw(canvas);
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
            EF();
        }
    }

    public com.baidu.adp.gif.b getGif() {
        if (this.aCM == null) {
            return null;
        }
        return this.aCM.get();
    }

    public void stopLoading() {
        this.mIsLoading = false;
        removeCallbacks(this);
        invalidate();
    }

    private void EF() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aCw += this.aCy;
        if (this.aCw > 360.0f - this.aCy) {
            this.aCw = 0.0f;
        }
        invalidate();
        EF();
    }

    public void setPlayCallback(a aVar) {
        this.aCN = aVar;
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
        boolean Hk = g.Hk();
        j X = k.X(getContext());
        if (X != null) {
            bdUniqueId = X.getUniqueId();
            z = X.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        boolean z2 = gifInfo == this.mGifInfo && this.mPageId == bdUniqueId;
        this.aCO = !z2;
        if (!z2) {
            EG();
        }
        this.mGifInfo = gifInfo;
        this.mPageId = bdUniqueId;
        String str = Hk ? this.mGifInfo.mDynamicUrl : this.mGifInfo.mStaticUrl;
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.fL().a(this.mGifInfo.mSharpText, 20, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(Hk), str);
        if (aVar != null) {
            stopLoading();
            setGif(aVar);
        } else if (this.mGifInfo.mLoadFailed) {
            setGif(null);
        } else {
            startLoading();
            if (!z) {
                com.baidu.adp.lib.f.c.fL().a(this.mGifInfo.mSharpText, 20, this.aCK, 0, 0, this.mPageId, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(Hk), str);
            }
        }
    }

    public void EG() {
        stopLoading();
        this.aCu = false;
        if (this.mGifInfo != null) {
            com.baidu.adp.lib.f.c.fL().a(this.mGifInfo.mSharpText, 20, this.aCK);
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
            boolean Hk = g.Hk();
            String str = Hk ? this.mGifInfo.mDynamicUrl : this.mGifInfo.mStaticUrl;
            com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.fL().a(this.mGifInfo.mSharpText, 20, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(Hk), str);
            if (aVar != null) {
                this.mGifInfo.mLoadFailed = false;
                setGif(aVar);
            } else {
                startLoading();
                com.baidu.adp.lib.f.c.fL().a(this.mGifInfo.mSharpText, 20, this.aCK, 0, 0, this.mPageId, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(Hk), str);
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
