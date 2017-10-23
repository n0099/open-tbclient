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
import com.baidu.adp.lib.f.b;
import com.baidu.adp.lib.f.c;
import com.baidu.tbadk.util.h;
import com.baidu.tieba.d;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class GiftGifView extends ImageView implements View.OnClickListener, i, Runnable {
    public static Bitmap aEb;
    private int aDT;
    private boolean aDY;
    private Drawable aDZ;
    private float aEa;
    private float aEc;
    private final Rect aEg;
    private final Rect aEh;
    private boolean aEi;
    private boolean aEn;
    private final b<com.baidu.adp.widget.ImageView.a> aEp;
    private WeakReference<com.baidu.adp.gif.b> aEr;
    private a aEs;
    private boolean aEt;
    private boolean aEu;
    private boolean isHide;
    private Bitmap mBitmap;
    private GifInfo mGifInfo;
    private final Handler mHandler;
    private boolean mIsLoading;
    private View.OnClickListener mOnClickListener;
    private BdUniqueId mPageId;

    /* loaded from: classes.dex */
    public interface a {
        void DP();

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
        this.aEg = new Rect();
        this.aEh = new Rect();
        this.aEi = true;
        this.isHide = false;
        this.aEt = false;
        this.aEu = false;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.gif.GiftGifView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                com.baidu.adp.gif.b bVar;
                boolean z;
                if (GiftGifView.this.aEr != null && (bVar = (com.baidu.adp.gif.b) GiftGifView.this.aEr.get()) != null) {
                    if (message.what == 2) {
                        GiftGifView.this.aEu = true;
                        removeMessages(2);
                    } else if (message.what == 1) {
                        GiftGifView.this.aDT++;
                        if (GiftGifView.this.aDT >= bVar.getFrameCount()) {
                            if (GiftGifView.this.aEn || GiftGifView.this.aEu) {
                                GiftGifView.this.setVisibility(4);
                                GiftGifView.this.aEn = false;
                                z = true;
                            } else {
                                z = false;
                            }
                            GiftGifView.this.aDT = 0;
                        } else {
                            z = false;
                        }
                        bVar.T(GiftGifView.this.aDT);
                        bVar.a(GiftGifView.this.mBitmap, null);
                        GiftGifView.this.invalidate();
                        removeMessages(1);
                        if (!z) {
                            sendEmptyMessageDelayed(1, bVar.U(GiftGifView.this.aDT));
                        } else if (GiftGifView.this.aEs != null) {
                            GiftGifView.this.aEs.onStop();
                        }
                    }
                }
            }
        };
        this.aEp = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.gif.GiftGifView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                super.onLoaded((AnonymousClass2) aVar, str, i2);
                if (aVar == null) {
                    GiftGifView.this.aEs.DP();
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
        this.aEc = 30.0f;
        BitmapDrawable bitmapDrawable = (BitmapDrawable) getResources().getDrawable(d.g.loading);
        if (bitmapDrawable != null) {
            aEb = bitmapDrawable.getBitmap();
            this.aEh.set(0, 0, aEb.getWidth(), aEb.getHeight());
        }
        this.aDZ = getResources().getDrawable(d.g.image_group_load_f);
        d(this.aDZ);
    }

    private void d(Drawable drawable) {
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
            if (aEb != null) {
                int i6 = i5 / 4;
                int i7 = ((i5 - i6) / 2) + paddingLeft;
                int i8 = ((paddingBottom - i6) / 2) + paddingTop;
                this.aEg.set(i7, i8, i7 + i6, i6 + i8);
            }
            int intrinsicWidth = this.aDZ.getIntrinsicWidth();
            int intrinsicHeight = this.aDZ.getIntrinsicHeight();
            if (intrinsicWidth > i5) {
                intrinsicWidth = i5;
            }
            if (intrinsicHeight > paddingBottom) {
                intrinsicHeight = paddingBottom;
            }
            int i9 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
            int i10 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
            this.aDZ.setBounds(i9, i10, intrinsicWidth + i9, intrinsicHeight + i10);
        }
    }

    public void setGif(com.baidu.adp.widget.ImageView.a aVar) {
        this.aDY = false;
        this.mIsLoading = false;
        if (this.mGifInfo != null) {
            this.mGifInfo.mLoadFailed = false;
        }
        if (aVar == null) {
            this.aDY = true;
            if (this.mGifInfo != null) {
                this.mGifInfo.mLoadFailed = true;
            }
            setImageDrawable(null);
            if (this.aEr != null) {
                this.aEr.clear();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.kL()) {
                aVar.a(this);
                this.mIsLoading = false;
            }
            if (this.aEr != null) {
                this.aEr.clear();
            }
        } else if (this.aEr == null || !aVar.getGif().equals(this.aEr.get())) {
            if (this.mBitmap == null || this.mBitmap.getWidth() != aVar.getGif().getWidth() || this.mBitmap.getHeight() != aVar.getGif().getHeight() || this.aEt) {
                this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
            }
            this.aEr = new WeakReference<>(aVar.getGif());
            aVar.getGif().T(0);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.aEi) {
                play();
            }
        } else {
            aVar.getGif().T(this.aDT);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.aEi) {
                resume();
            }
        }
    }

    public boolean getAutoPlay() {
        return this.aEi;
    }

    public void setAutoPlay(boolean z) {
        this.aEi = z;
    }

    public void resume() {
        com.baidu.adp.gif.b bVar;
        if (this.aEr != null && (bVar = this.aEr.get()) != null) {
            this.aEu = false;
            if (this.isHide) {
                setVisibility(4);
                return;
            }
            this.aEs.onStart();
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageDelayed(1, bVar.U(this.aDT));
            this.mHandler.sendEmptyMessageDelayed(2, 2000L);
        }
    }

    public void stop() {
        com.baidu.adp.gif.b bVar;
        if (this.aEr != null && (bVar = this.aEr.get()) != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.aDT = 0;
            bVar.T(0);
            bVar.a(this.mBitmap, null);
            invalidate();
        }
    }

    public void play() {
        com.baidu.adp.gif.b bVar;
        if (this.aEr != null && (bVar = this.aEr.get()) != null) {
            this.aEu = false;
            if (this.isHide) {
                setVisibility(4);
                return;
            }
            this.aEs.onStart();
            if (this.aDT != 0) {
                this.aDT = 0;
            }
            bVar.T(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageDelayed(1, bVar.U(this.aDT));
            this.mHandler.sendEmptyMessageDelayed(2, 2000L);
        }
    }

    public void setPlayOnce(boolean z) {
        this.aEn = z;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        DO();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.mHandler.removeMessages(1);
        DO();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 4 || i == 8) {
            this.isHide = true;
            stop();
            if (this.aEs != null) {
                this.aEs.onStop();
            }
        } else if (i == 0) {
            play();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        com.baidu.adp.gif.b bVar;
        if (!this.mIsLoading && !this.aDY) {
            super.onDraw(canvas);
        }
        canvas.save();
        if (this.aEr != null && !this.mIsLoading && !this.aDY && (bVar = this.aEr.get()) != null) {
            bVar.a(null, canvas);
        }
        canvas.restore();
        if (this.mIsLoading && aEb != null) {
            canvas.save();
            canvas.rotate(this.aEa, (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.5f) + getPaddingLeft(), (((getHeight() - getPaddingTop()) - getPaddingBottom()) * 0.5f) + getPaddingTop());
            canvas.drawBitmap(aEb, this.aEh, this.aEg, (Paint) null);
            canvas.restore();
        } else if (this.aDY || (this.mGifInfo != null && this.mGifInfo.mLoadFailed)) {
            canvas.save();
            this.aDZ.draw(canvas);
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
            DN();
        }
    }

    public com.baidu.adp.gif.b getGif() {
        if (this.aEr == null) {
            return null;
        }
        return this.aEr.get();
    }

    public void stopLoading() {
        this.mIsLoading = false;
        removeCallbacks(this);
        invalidate();
    }

    private void DN() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aEa += this.aEc;
        if (this.aEa > 360.0f - this.aEc) {
            this.aEa = 0.0f;
        }
        invalidate();
        DN();
    }

    public void setPlayCallback(a aVar) {
        this.aEs = aVar;
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
        boolean GB = h.GB();
        com.baidu.adp.base.h W = com.baidu.adp.base.i.W(getContext());
        if (W != null) {
            bdUniqueId = W.getUniqueId();
            z = W.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        boolean z2 = gifInfo == this.mGifInfo && this.mPageId == bdUniqueId;
        this.aEt = !z2;
        if (!z2) {
            DO();
        }
        this.mGifInfo = gifInfo;
        this.mPageId = bdUniqueId;
        String str = GB ? this.mGifInfo.mDynamicUrl : this.mGifInfo.mStaticUrl;
        com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) c.fJ().a(this.mGifInfo.mSharpText, 20, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(GB), str);
        if (aVar != null) {
            stopLoading();
            setGif(aVar);
        } else if (this.mGifInfo.mLoadFailed) {
            setGif(null);
        } else {
            startLoading();
            if (!z) {
                c.fJ().a(this.mGifInfo.mSharpText, 20, this.aEp, 0, 0, this.mPageId, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(GB), str);
            }
        }
    }

    public void DO() {
        stopLoading();
        this.aDY = false;
        if (this.mGifInfo != null) {
            c.fJ().a(this.mGifInfo.mSharpText, 20, this.aEp);
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
            boolean GB = h.GB();
            String str = GB ? this.mGifInfo.mDynamicUrl : this.mGifInfo.mStaticUrl;
            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) c.fJ().a(this.mGifInfo.mSharpText, 20, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(GB), str);
            if (aVar != null) {
                this.mGifInfo.mLoadFailed = false;
                setGif(aVar);
            } else {
                startLoading();
                c.fJ().a(this.mGifInfo.mSharpText, 20, this.aEp, 0, 0, this.mPageId, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(GB), str);
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
