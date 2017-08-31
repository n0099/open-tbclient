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
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.b.a.i;
import com.baidu.adp.base.h;
import com.baidu.adp.lib.f.b;
import com.baidu.adp.lib.f.c;
import com.baidu.tieba.d;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class GiftGifView extends ImageView implements View.OnClickListener, i, Runnable {
    public static Bitmap aEY;
    private int aEQ;
    private boolean aEV;
    private Drawable aEW;
    private float aEX;
    private float aEZ;
    private final Rect aFd;
    private final Rect aFe;
    private boolean aFf;
    private boolean aFj;
    private final b<com.baidu.adp.widget.a.a> aFl;
    private WeakReference<com.baidu.adp.gif.b> aFn;
    private a aFo;
    private boolean aFp;
    private boolean aFq;
    private boolean isHide;
    private Bitmap mBitmap;
    private GifInfo mGifInfo;
    private final Handler mHandler;
    private boolean mIsLoading;
    private View.OnClickListener mOnClickListener;
    private BdUniqueId mPageId;

    /* loaded from: classes.dex */
    public interface a {
        void Er();

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
        this.aFd = new Rect();
        this.aFe = new Rect();
        this.aFf = true;
        this.isHide = false;
        this.aFp = false;
        this.aFq = false;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.gif.GiftGifView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                com.baidu.adp.gif.b bVar;
                boolean z;
                if (GiftGifView.this.aFn != null && (bVar = (com.baidu.adp.gif.b) GiftGifView.this.aFn.get()) != null) {
                    if (message.what == 2) {
                        GiftGifView.this.aFq = true;
                        removeMessages(2);
                    } else if (message.what == 1) {
                        GiftGifView.this.aEQ++;
                        if (GiftGifView.this.aEQ >= bVar.dE()) {
                            if (GiftGifView.this.aFj || GiftGifView.this.aFq) {
                                GiftGifView.this.setVisibility(4);
                                GiftGifView.this.aFj = false;
                                z = true;
                            } else {
                                z = false;
                            }
                            GiftGifView.this.aEQ = 0;
                        } else {
                            z = false;
                        }
                        bVar.T(GiftGifView.this.aEQ);
                        bVar.a(GiftGifView.this.mBitmap, null);
                        GiftGifView.this.invalidate();
                        removeMessages(1);
                        if (!z) {
                            sendEmptyMessageDelayed(1, bVar.U(GiftGifView.this.aEQ));
                        } else if (GiftGifView.this.aFo != null) {
                            GiftGifView.this.aFo.onStop();
                        }
                    }
                }
            }
        };
        this.aFl = new b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.gif.GiftGifView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i2) {
                super.onLoaded((AnonymousClass2) aVar, str, i2);
                if (aVar == null) {
                    GiftGifView.this.aFo.Er();
                }
                GiftGifView.this.stopLoading();
                GiftGifView.this.setGif(aVar);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onProgressUpdate(Object... objArr) {
                super.onProgressUpdate(objArr);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onCancelled(String str) {
                super.onCancelled(str);
            }
        };
        this.aEZ = 30.0f;
        BitmapDrawable bitmapDrawable = (BitmapDrawable) getResources().getDrawable(d.g.loading);
        if (bitmapDrawable != null) {
            aEY = bitmapDrawable.getBitmap();
            this.aFe.set(0, 0, aEY.getWidth(), aEY.getHeight());
        }
        this.aEW = getResources().getDrawable(d.g.image_group_load_f);
        b(this.aEW);
    }

    private void b(Drawable drawable) {
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
            if (aEY != null) {
                int i6 = i5 / 4;
                int i7 = ((i5 - i6) / 2) + paddingLeft;
                int i8 = ((paddingBottom - i6) / 2) + paddingTop;
                this.aFd.set(i7, i8, i7 + i6, i6 + i8);
            }
            int intrinsicWidth = this.aEW.getIntrinsicWidth();
            int intrinsicHeight = this.aEW.getIntrinsicHeight();
            if (intrinsicWidth > i5) {
                intrinsicWidth = i5;
            }
            if (intrinsicHeight > paddingBottom) {
                intrinsicHeight = paddingBottom;
            }
            int i9 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
            int i10 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
            this.aEW.setBounds(i9, i10, intrinsicWidth + i9, intrinsicHeight + i10);
        }
    }

    public void setGif(com.baidu.adp.widget.a.a aVar) {
        this.aEV = false;
        this.mIsLoading = false;
        if (this.mGifInfo != null) {
            this.mGifInfo.mLoadFailed = false;
        }
        if (aVar == null) {
            this.aEV = true;
            if (this.mGifInfo != null) {
                this.mGifInfo.mLoadFailed = true;
            }
            setImageDrawable(null);
            if (this.aFn != null) {
                this.aFn.clear();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.kM()) {
                aVar.a(this);
                this.mIsLoading = false;
            }
            if (this.aFn != null) {
                this.aFn.clear();
            }
        } else if (this.aFn == null || !aVar.getGif().equals(this.aFn.get())) {
            if (this.mBitmap == null || this.mBitmap.getWidth() != aVar.getGif().getWidth() || this.mBitmap.getHeight() != aVar.getGif().getHeight() || this.aFp) {
                this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
            }
            this.aFn = new WeakReference<>(aVar.getGif());
            aVar.getGif().T(0);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.aFf) {
                play();
            }
        } else {
            aVar.getGif().T(this.aEQ);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.aFf) {
                resume();
            }
        }
    }

    public boolean getAutoPlay() {
        return this.aFf;
    }

    public void setAutoPlay(boolean z) {
        this.aFf = z;
    }

    public void resume() {
        com.baidu.adp.gif.b bVar;
        if (this.aFn != null && (bVar = this.aFn.get()) != null) {
            this.aFq = false;
            if (this.isHide) {
                setVisibility(4);
                return;
            }
            this.aFo.onStart();
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageDelayed(1, bVar.U(this.aEQ));
            this.mHandler.sendEmptyMessageDelayed(2, 2000L);
        }
    }

    public void stop() {
        com.baidu.adp.gif.b bVar;
        if (this.aFn != null && (bVar = this.aFn.get()) != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.aEQ = 0;
            bVar.T(0);
            bVar.a(this.mBitmap, null);
            invalidate();
        }
    }

    public void play() {
        com.baidu.adp.gif.b bVar;
        if (this.aFn != null && (bVar = this.aFn.get()) != null) {
            this.aFq = false;
            if (this.isHide) {
                setVisibility(4);
                return;
            }
            this.aFo.onStart();
            if (this.aEQ != 0) {
                this.aEQ = 0;
            }
            bVar.T(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageDelayed(1, bVar.U(this.aEQ));
            this.mHandler.sendEmptyMessageDelayed(2, 2000L);
        }
    }

    public void setPlayOnce(boolean z) {
        this.aFj = z;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        Eq();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.mHandler.removeMessages(1);
        Eq();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 4 || i == 8) {
            this.isHide = true;
            stop();
            if (this.aFo != null) {
                this.aFo.onStop();
            }
        } else if (i == 0) {
            play();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        com.baidu.adp.gif.b bVar;
        if (!this.mIsLoading && !this.aEV) {
            super.onDraw(canvas);
        }
        canvas.save();
        if (this.aFn != null && !this.mIsLoading && !this.aEV && (bVar = this.aFn.get()) != null) {
            bVar.a(null, canvas);
        }
        canvas.restore();
        if (this.mIsLoading && aEY != null) {
            canvas.save();
            canvas.rotate(this.aEX, (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.5f) + getPaddingLeft(), (((getHeight() - getPaddingTop()) - getPaddingBottom()) * 0.5f) + getPaddingTop());
            canvas.drawBitmap(aEY, this.aFe, this.aFd, (Paint) null);
            canvas.restore();
        } else if (this.aEV || (this.mGifInfo != null && this.mGifInfo.mLoadFailed)) {
            canvas.save();
            this.aEW.draw(canvas);
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
            Ep();
        }
    }

    public com.baidu.adp.gif.b getGif() {
        if (this.aFn == null) {
            return null;
        }
        return this.aFn.get();
    }

    public void stopLoading() {
        this.mIsLoading = false;
        removeCallbacks(this);
        invalidate();
    }

    private void Ep() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aEX += this.aEZ;
        if (this.aEX > 360.0f - this.aEZ) {
            this.aEX = 0.0f;
        }
        invalidate();
        Ep();
    }

    public void setPlayCallback(a aVar) {
        this.aFo = aVar;
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
        boolean Hd = com.baidu.tbadk.util.i.Hd();
        h V = com.baidu.adp.base.i.V(getContext());
        if (V != null) {
            bdUniqueId = V.getUniqueId();
            z = V.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        boolean z2 = gifInfo == this.mGifInfo && this.mPageId == bdUniqueId;
        this.aFp = !z2;
        if (!z2) {
            Eq();
        }
        this.mGifInfo = gifInfo;
        this.mPageId = bdUniqueId;
        String str = Hd ? this.mGifInfo.mDynamicUrl : this.mGifInfo.mStaticUrl;
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) c.fK().a(this.mGifInfo.mSharpText, 20, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(Hd), str);
        if (aVar != null) {
            stopLoading();
            setGif(aVar);
        } else if (this.mGifInfo.mLoadFailed) {
            setGif(null);
        } else {
            startLoading();
            if (!z) {
                c.fK().a(this.mGifInfo.mSharpText, 20, this.aFl, 0, 0, this.mPageId, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(Hd), str);
            }
        }
    }

    public void Eq() {
        stopLoading();
        this.aEV = false;
        if (this.mGifInfo != null) {
            c.fK().a(this.mGifInfo.mSharpText, 20, this.aFl);
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
            boolean Hd = com.baidu.tbadk.util.i.Hd();
            String str = Hd ? this.mGifInfo.mDynamicUrl : this.mGifInfo.mStaticUrl;
            com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) c.fK().a(this.mGifInfo.mSharpText, 20, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(Hd), str);
            if (aVar != null) {
                this.mGifInfo.mLoadFailed = false;
                setGif(aVar);
            } else {
                startLoading();
                c.fK().a(this.mGifInfo.mSharpText, 20, this.aFl, 0, 0, this.mPageId, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(Hd), str);
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
