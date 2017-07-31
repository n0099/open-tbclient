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
    public static Bitmap aFE;
    private boolean aFB;
    private Drawable aFC;
    private float aFD;
    private float aFF;
    private final Rect aFJ;
    private final Rect aFK;
    private boolean aFL;
    private boolean aFP;
    private final b<com.baidu.adp.widget.a.a> aFR;
    private WeakReference<com.baidu.adp.gif.b> aFT;
    private a aFU;
    private boolean aFV;
    private boolean aFW;
    private int aFw;
    private boolean isHide;
    private Bitmap mBitmap;
    private GifInfo mGifInfo;
    private final Handler mHandler;
    private boolean mIsLoading;
    private View.OnClickListener mOnClickListener;
    private BdUniqueId mPageId;

    /* loaded from: classes.dex */
    public interface a {
        void Et();

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
        this.aFJ = new Rect();
        this.aFK = new Rect();
        this.aFL = true;
        this.isHide = false;
        this.aFV = false;
        this.aFW = false;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.gif.GiftGifView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                com.baidu.adp.gif.b bVar;
                boolean z;
                if (GiftGifView.this.aFT != null && (bVar = (com.baidu.adp.gif.b) GiftGifView.this.aFT.get()) != null) {
                    if (message.what == 2) {
                        GiftGifView.this.aFW = true;
                        removeMessages(2);
                    } else if (message.what == 1) {
                        GiftGifView.this.aFw++;
                        if (GiftGifView.this.aFw >= bVar.dO()) {
                            if (GiftGifView.this.aFP || GiftGifView.this.aFW) {
                                GiftGifView.this.setVisibility(4);
                                GiftGifView.this.aFP = false;
                                z = true;
                            } else {
                                z = false;
                            }
                            GiftGifView.this.aFw = 0;
                        } else {
                            z = false;
                        }
                        bVar.W(GiftGifView.this.aFw);
                        bVar.a(GiftGifView.this.mBitmap, null);
                        GiftGifView.this.invalidate();
                        removeMessages(1);
                        if (!z) {
                            sendEmptyMessageDelayed(1, bVar.X(GiftGifView.this.aFw));
                        } else if (GiftGifView.this.aFU != null) {
                            GiftGifView.this.aFU.onStop();
                        }
                    }
                }
            }
        };
        this.aFR = new b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.gif.GiftGifView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i2) {
                super.onLoaded((AnonymousClass2) aVar, str, i2);
                if (aVar == null) {
                    GiftGifView.this.aFU.Et();
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
        this.aFF = 30.0f;
        BitmapDrawable bitmapDrawable = (BitmapDrawable) getResources().getDrawable(d.g.loading);
        if (bitmapDrawable != null) {
            aFE = bitmapDrawable.getBitmap();
            this.aFK.set(0, 0, aFE.getWidth(), aFE.getHeight());
        }
        this.aFC = getResources().getDrawable(d.g.image_group_load_f);
        e(this.aFC);
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
            if (aFE != null) {
                int i6 = i5 / 4;
                int i7 = ((i5 - i6) / 2) + paddingLeft;
                int i8 = ((paddingBottom - i6) / 2) + paddingTop;
                this.aFJ.set(i7, i8, i7 + i6, i6 + i8);
            }
            int intrinsicWidth = this.aFC.getIntrinsicWidth();
            int intrinsicHeight = this.aFC.getIntrinsicHeight();
            if (intrinsicWidth > i5) {
                intrinsicWidth = i5;
            }
            if (intrinsicHeight > paddingBottom) {
                intrinsicHeight = paddingBottom;
            }
            int i9 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
            int i10 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
            this.aFC.setBounds(i9, i10, intrinsicWidth + i9, intrinsicHeight + i10);
        }
    }

    public void setGif(com.baidu.adp.widget.a.a aVar) {
        this.aFB = false;
        this.mIsLoading = false;
        if (this.mGifInfo != null) {
            this.mGifInfo.mLoadFailed = false;
        }
        if (aVar == null) {
            this.aFB = true;
            if (this.mGifInfo != null) {
                this.mGifInfo.mLoadFailed = true;
            }
            setImageDrawable(null);
            if (this.aFT != null) {
                this.aFT.clear();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.kV()) {
                aVar.e(this);
                this.mIsLoading = false;
            }
            if (this.aFT != null) {
                this.aFT.clear();
            }
        } else if (this.aFT == null || !aVar.getGif().equals(this.aFT.get())) {
            if (this.mBitmap == null || this.mBitmap.getWidth() != aVar.getGif().getWidth() || this.mBitmap.getHeight() != aVar.getGif().getHeight() || this.aFV) {
                this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
            }
            this.aFT = new WeakReference<>(aVar.getGif());
            aVar.getGif().W(0);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.aFL) {
                play();
            }
        } else {
            aVar.getGif().W(this.aFw);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.aFL) {
                resume();
            }
        }
    }

    public boolean getAutoPlay() {
        return this.aFL;
    }

    public void setAutoPlay(boolean z) {
        this.aFL = z;
    }

    public void resume() {
        com.baidu.adp.gif.b bVar;
        if (this.aFT != null && (bVar = this.aFT.get()) != null) {
            this.aFW = false;
            if (this.isHide) {
                setVisibility(4);
                return;
            }
            this.aFU.onStart();
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageDelayed(1, bVar.X(this.aFw));
            this.mHandler.sendEmptyMessageDelayed(2, 2000L);
        }
    }

    public void stop() {
        com.baidu.adp.gif.b bVar;
        if (this.aFT != null && (bVar = this.aFT.get()) != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.aFw = 0;
            bVar.W(0);
            bVar.a(this.mBitmap, null);
            invalidate();
        }
    }

    public void play() {
        com.baidu.adp.gif.b bVar;
        if (this.aFT != null && (bVar = this.aFT.get()) != null) {
            this.aFW = false;
            if (this.isHide) {
                setVisibility(4);
                return;
            }
            this.aFU.onStart();
            if (this.aFw != 0) {
                this.aFw = 0;
            }
            bVar.W(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageDelayed(1, bVar.X(this.aFw));
            this.mHandler.sendEmptyMessageDelayed(2, 2000L);
        }
    }

    public void setPlayOnce(boolean z) {
        this.aFP = z;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        Es();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.mHandler.removeMessages(1);
        Es();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 4 || i == 8) {
            this.isHide = true;
            stop();
            if (this.aFU != null) {
                this.aFU.onStop();
            }
        } else if (i == 0) {
            play();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        com.baidu.adp.gif.b bVar;
        if (!this.mIsLoading && !this.aFB) {
            super.onDraw(canvas);
        }
        canvas.save();
        if (this.aFT != null && !this.mIsLoading && !this.aFB && (bVar = this.aFT.get()) != null) {
            bVar.a(null, canvas);
        }
        canvas.restore();
        if (this.mIsLoading && aFE != null) {
            canvas.save();
            canvas.rotate(this.aFD, (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.5f) + getPaddingLeft(), (((getHeight() - getPaddingTop()) - getPaddingBottom()) * 0.5f) + getPaddingTop());
            canvas.drawBitmap(aFE, this.aFK, this.aFJ, (Paint) null);
            canvas.restore();
        } else if (this.aFB || (this.mGifInfo != null && this.mGifInfo.mLoadFailed)) {
            canvas.save();
            this.aFC.draw(canvas);
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
            Er();
        }
    }

    public com.baidu.adp.gif.b getGif() {
        if (this.aFT == null) {
            return null;
        }
        return this.aFT.get();
    }

    public void stopLoading() {
        this.mIsLoading = false;
        removeCallbacks(this);
        invalidate();
    }

    private void Er() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aFD += this.aFF;
        if (this.aFD > 360.0f - this.aFF) {
            this.aFD = 0.0f;
        }
        invalidate();
        Er();
    }

    public void setPlayCallback(a aVar) {
        this.aFU = aVar;
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
        boolean He = com.baidu.tbadk.util.i.He();
        h Y = com.baidu.adp.base.i.Y(getContext());
        if (Y != null) {
            bdUniqueId = Y.getUniqueId();
            z = Y.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        boolean z2 = gifInfo == this.mGifInfo && this.mPageId == bdUniqueId;
        this.aFV = !z2;
        if (!z2) {
            Es();
        }
        this.mGifInfo = gifInfo;
        this.mPageId = bdUniqueId;
        String str = He ? this.mGifInfo.mDynamicUrl : this.mGifInfo.mStaticUrl;
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) c.fU().a(this.mGifInfo.mSharpText, 20, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(He), str);
        if (aVar != null) {
            stopLoading();
            setGif(aVar);
        } else if (this.mGifInfo.mLoadFailed) {
            setGif(null);
        } else {
            startLoading();
            if (!z) {
                c.fU().a(this.mGifInfo.mSharpText, 20, this.aFR, 0, 0, this.mPageId, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(He), str);
            }
        }
    }

    public void Es() {
        stopLoading();
        this.aFB = false;
        if (this.mGifInfo != null) {
            c.fU().a(this.mGifInfo.mSharpText, 20, this.aFR);
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
            boolean He = com.baidu.tbadk.util.i.He();
            String str = He ? this.mGifInfo.mDynamicUrl : this.mGifInfo.mStaticUrl;
            com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) c.fU().a(this.mGifInfo.mSharpText, 20, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(He), str);
            if (aVar != null) {
                this.mGifInfo.mLoadFailed = false;
                setGif(aVar);
            } else {
                startLoading();
                c.fU().a(this.mGifInfo.mSharpText, 20, this.aFR, 0, 0, this.mPageId, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(He), str);
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
