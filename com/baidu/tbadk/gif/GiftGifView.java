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
    public static Bitmap aEV;
    private int aEN;
    private boolean aES;
    private Drawable aET;
    private float aEU;
    private float aEW;
    private final Rect aFa;
    private final Rect aFb;
    private boolean aFc;
    private boolean aFg;
    private final b<com.baidu.adp.widget.a.a> aFi;
    private WeakReference<com.baidu.adp.gif.b> aFk;
    private a aFl;
    private boolean aFm;
    private boolean aFn;
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
        this.aFa = new Rect();
        this.aFb = new Rect();
        this.aFc = true;
        this.isHide = false;
        this.aFm = false;
        this.aFn = false;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.gif.GiftGifView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                com.baidu.adp.gif.b bVar;
                boolean z;
                if (GiftGifView.this.aFk != null && (bVar = (com.baidu.adp.gif.b) GiftGifView.this.aFk.get()) != null) {
                    if (message.what == 2) {
                        GiftGifView.this.aFn = true;
                        removeMessages(2);
                    } else if (message.what == 1) {
                        GiftGifView.this.aEN++;
                        if (GiftGifView.this.aEN >= bVar.dE()) {
                            if (GiftGifView.this.aFg || GiftGifView.this.aFn) {
                                GiftGifView.this.setVisibility(4);
                                GiftGifView.this.aFg = false;
                                z = true;
                            } else {
                                z = false;
                            }
                            GiftGifView.this.aEN = 0;
                        } else {
                            z = false;
                        }
                        bVar.T(GiftGifView.this.aEN);
                        bVar.a(GiftGifView.this.mBitmap, null);
                        GiftGifView.this.invalidate();
                        removeMessages(1);
                        if (!z) {
                            sendEmptyMessageDelayed(1, bVar.U(GiftGifView.this.aEN));
                        } else if (GiftGifView.this.aFl != null) {
                            GiftGifView.this.aFl.onStop();
                        }
                    }
                }
            }
        };
        this.aFi = new b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.gif.GiftGifView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i2) {
                super.onLoaded((AnonymousClass2) aVar, str, i2);
                if (aVar == null) {
                    GiftGifView.this.aFl.Er();
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
        this.aEW = 30.0f;
        BitmapDrawable bitmapDrawable = (BitmapDrawable) getResources().getDrawable(d.g.loading);
        if (bitmapDrawable != null) {
            aEV = bitmapDrawable.getBitmap();
            this.aFb.set(0, 0, aEV.getWidth(), aEV.getHeight());
        }
        this.aET = getResources().getDrawable(d.g.image_group_load_f);
        b(this.aET);
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
            if (aEV != null) {
                int i6 = i5 / 4;
                int i7 = ((i5 - i6) / 2) + paddingLeft;
                int i8 = ((paddingBottom - i6) / 2) + paddingTop;
                this.aFa.set(i7, i8, i7 + i6, i6 + i8);
            }
            int intrinsicWidth = this.aET.getIntrinsicWidth();
            int intrinsicHeight = this.aET.getIntrinsicHeight();
            if (intrinsicWidth > i5) {
                intrinsicWidth = i5;
            }
            if (intrinsicHeight > paddingBottom) {
                intrinsicHeight = paddingBottom;
            }
            int i9 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
            int i10 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
            this.aET.setBounds(i9, i10, intrinsicWidth + i9, intrinsicHeight + i10);
        }
    }

    public void setGif(com.baidu.adp.widget.a.a aVar) {
        this.aES = false;
        this.mIsLoading = false;
        if (this.mGifInfo != null) {
            this.mGifInfo.mLoadFailed = false;
        }
        if (aVar == null) {
            this.aES = true;
            if (this.mGifInfo != null) {
                this.mGifInfo.mLoadFailed = true;
            }
            setImageDrawable(null);
            if (this.aFk != null) {
                this.aFk.clear();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.kM()) {
                aVar.a(this);
                this.mIsLoading = false;
            }
            if (this.aFk != null) {
                this.aFk.clear();
            }
        } else if (this.aFk == null || !aVar.getGif().equals(this.aFk.get())) {
            if (this.mBitmap == null || this.mBitmap.getWidth() != aVar.getGif().getWidth() || this.mBitmap.getHeight() != aVar.getGif().getHeight() || this.aFm) {
                this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
            }
            this.aFk = new WeakReference<>(aVar.getGif());
            aVar.getGif().T(0);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.aFc) {
                play();
            }
        } else {
            aVar.getGif().T(this.aEN);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.aFc) {
                resume();
            }
        }
    }

    public boolean getAutoPlay() {
        return this.aFc;
    }

    public void setAutoPlay(boolean z) {
        this.aFc = z;
    }

    public void resume() {
        com.baidu.adp.gif.b bVar;
        if (this.aFk != null && (bVar = this.aFk.get()) != null) {
            this.aFn = false;
            if (this.isHide) {
                setVisibility(4);
                return;
            }
            this.aFl.onStart();
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageDelayed(1, bVar.U(this.aEN));
            this.mHandler.sendEmptyMessageDelayed(2, 2000L);
        }
    }

    public void stop() {
        com.baidu.adp.gif.b bVar;
        if (this.aFk != null && (bVar = this.aFk.get()) != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.aEN = 0;
            bVar.T(0);
            bVar.a(this.mBitmap, null);
            invalidate();
        }
    }

    public void play() {
        com.baidu.adp.gif.b bVar;
        if (this.aFk != null && (bVar = this.aFk.get()) != null) {
            this.aFn = false;
            if (this.isHide) {
                setVisibility(4);
                return;
            }
            this.aFl.onStart();
            if (this.aEN != 0) {
                this.aEN = 0;
            }
            bVar.T(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageDelayed(1, bVar.U(this.aEN));
            this.mHandler.sendEmptyMessageDelayed(2, 2000L);
        }
    }

    public void setPlayOnce(boolean z) {
        this.aFg = z;
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
            if (this.aFl != null) {
                this.aFl.onStop();
            }
        } else if (i == 0) {
            play();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        com.baidu.adp.gif.b bVar;
        if (!this.mIsLoading && !this.aES) {
            super.onDraw(canvas);
        }
        canvas.save();
        if (this.aFk != null && !this.mIsLoading && !this.aES && (bVar = this.aFk.get()) != null) {
            bVar.a(null, canvas);
        }
        canvas.restore();
        if (this.mIsLoading && aEV != null) {
            canvas.save();
            canvas.rotate(this.aEU, (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.5f) + getPaddingLeft(), (((getHeight() - getPaddingTop()) - getPaddingBottom()) * 0.5f) + getPaddingTop());
            canvas.drawBitmap(aEV, this.aFb, this.aFa, (Paint) null);
            canvas.restore();
        } else if (this.aES || (this.mGifInfo != null && this.mGifInfo.mLoadFailed)) {
            canvas.save();
            this.aET.draw(canvas);
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
        if (this.aFk == null) {
            return null;
        }
        return this.aFk.get();
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
        this.aEU += this.aEW;
        if (this.aEU > 360.0f - this.aEW) {
            this.aEU = 0.0f;
        }
        invalidate();
        Ep();
    }

    public void setPlayCallback(a aVar) {
        this.aFl = aVar;
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
        h W = com.baidu.adp.base.i.W(getContext());
        if (W != null) {
            bdUniqueId = W.getUniqueId();
            z = W.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        boolean z2 = gifInfo == this.mGifInfo && this.mPageId == bdUniqueId;
        this.aFm = !z2;
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
                c.fK().a(this.mGifInfo.mSharpText, 20, this.aFi, 0, 0, this.mPageId, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(Hd), str);
            }
        }
    }

    public void Eq() {
        stopLoading();
        this.aES = false;
        if (this.mGifInfo != null) {
            c.fK().a(this.mGifInfo.mSharpText, 20, this.aFi);
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
                c.fK().a(this.mGifInfo.mSharpText, 20, this.aFi, 0, 0, this.mPageId, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(Hd), str);
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
