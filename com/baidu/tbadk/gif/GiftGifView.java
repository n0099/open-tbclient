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
import com.baidu.adp.lib.f.b;
import com.baidu.adp.lib.f.c;
import com.baidu.adp.newwidget.ImageView.h;
import com.baidu.tbadk.util.i;
import com.baidu.tieba.d;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class GiftGifView extends ImageView implements View.OnClickListener, h, Runnable {
    public static Bitmap aOH;
    private boolean aOG;
    private float aOI;
    private final Rect aOM;
    private final Rect aON;
    private boolean aOO;
    private boolean aOU;
    private final b<com.baidu.adp.widget.ImageView.a> aOV;
    private WeakReference<com.baidu.adp.gif.b> aOX;
    private a aOY;
    private Drawable aOZ;
    private boolean aPa;
    private boolean isHide;
    private boolean isNew;
    private Bitmap mBitmap;
    private float mCurrentDegrees;
    private int mCurrentFrame;
    private GifInfo mGifInfo;
    private final Handler mHandler;
    private boolean mIsLoading;
    private View.OnClickListener mOnClickListener;
    private BdUniqueId mPageId;

    /* loaded from: classes.dex */
    public interface a {
        void onFail();

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
        this.aOM = new Rect();
        this.aON = new Rect();
        this.aOO = true;
        this.isHide = false;
        this.isNew = false;
        this.aPa = false;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.gif.GiftGifView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                com.baidu.adp.gif.b bVar;
                boolean z;
                if (GiftGifView.this.aOX != null && (bVar = (com.baidu.adp.gif.b) GiftGifView.this.aOX.get()) != null) {
                    if (message.what == 2) {
                        GiftGifView.this.aPa = true;
                        removeMessages(2);
                    } else if (message.what == 1) {
                        GiftGifView.this.mCurrentFrame++;
                        if (GiftGifView.this.mCurrentFrame >= bVar.getFrameCount()) {
                            if (GiftGifView.this.aOU || GiftGifView.this.aPa) {
                                GiftGifView.this.setVisibility(4);
                                GiftGifView.this.aOU = false;
                                z = true;
                            } else {
                                z = false;
                            }
                            GiftGifView.this.mCurrentFrame = 0;
                        } else {
                            z = false;
                        }
                        bVar.N(GiftGifView.this.mCurrentFrame);
                        bVar.a(GiftGifView.this.mBitmap, null);
                        GiftGifView.this.invalidate();
                        removeMessages(1);
                        if (!z) {
                            sendEmptyMessageDelayed(1, bVar.O(GiftGifView.this.mCurrentFrame));
                        } else if (GiftGifView.this.aOY != null) {
                            GiftGifView.this.aOY.onStop();
                        }
                    }
                }
            }
        };
        this.aOV = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.gif.GiftGifView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                super.onLoaded((AnonymousClass2) aVar, str, i2);
                if (aVar == null) {
                    GiftGifView.this.aOY.onFail();
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
        this.aOI = 30.0f;
        BitmapDrawable bitmapDrawable = (BitmapDrawable) getResources().getDrawable(d.f.tb_loading);
        if (bitmapDrawable != null) {
            aOH = bitmapDrawable.getBitmap();
            this.aON.set(0, 0, aOH.getWidth(), aOH.getHeight());
        }
        this.aOZ = getResources().getDrawable(d.f.image_group_load_f);
        e(this.aOZ);
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
            if (aOH != null) {
                int i6 = i5 / 4;
                int i7 = ((i5 - i6) / 2) + paddingLeft;
                int i8 = ((paddingBottom - i6) / 2) + paddingTop;
                this.aOM.set(i7, i8, i7 + i6, i6 + i8);
            }
            int intrinsicWidth = this.aOZ.getIntrinsicWidth();
            int intrinsicHeight = this.aOZ.getIntrinsicHeight();
            if (intrinsicWidth > i5) {
                intrinsicWidth = i5;
            }
            if (intrinsicHeight > paddingBottom) {
                intrinsicHeight = paddingBottom;
            }
            int i9 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
            int i10 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
            this.aOZ.setBounds(i9, i10, intrinsicWidth + i9, intrinsicHeight + i10);
        }
    }

    public void setGif(com.baidu.adp.widget.ImageView.a aVar) {
        this.aOG = false;
        this.mIsLoading = false;
        if (this.mGifInfo != null) {
            this.mGifInfo.mLoadFailed = false;
        }
        if (aVar == null) {
            this.aOG = true;
            if (this.mGifInfo != null) {
                this.mGifInfo.mLoadFailed = true;
            }
            setImageDrawable(null);
            if (this.aOX != null) {
                this.aOX.clear();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.mX()) {
                aVar.a(this);
                this.mIsLoading = false;
            }
            if (this.aOX != null) {
                this.aOX.clear();
            }
        } else if (this.aOX == null || !aVar.getGif().equals(this.aOX.get())) {
            if (this.mBitmap == null || this.mBitmap.getWidth() != aVar.getGif().getWidth() || this.mBitmap.getHeight() != aVar.getGif().getHeight() || this.isNew) {
                this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
            }
            this.aOX = new WeakReference<>(aVar.getGif());
            aVar.getGif().N(0);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.aOO) {
                play();
            }
        } else {
            aVar.getGif().N(this.mCurrentFrame);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.aOO) {
                resume();
            }
        }
    }

    public boolean getAutoPlay() {
        return this.aOO;
    }

    public void setAutoPlay(boolean z) {
        this.aOO = z;
    }

    public void resume() {
        com.baidu.adp.gif.b bVar;
        if (this.aOX != null && (bVar = this.aOX.get()) != null) {
            this.aPa = false;
            if (this.isHide) {
                setVisibility(4);
                return;
            }
            this.aOY.onStart();
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageDelayed(1, bVar.O(this.mCurrentFrame));
            this.mHandler.sendEmptyMessageDelayed(2, 2000L);
        }
    }

    public void stop() {
        com.baidu.adp.gif.b bVar;
        if (this.aOX != null && (bVar = this.aOX.get()) != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mCurrentFrame = 0;
            bVar.N(0);
            bVar.a(this.mBitmap, null);
            invalidate();
        }
    }

    public void play() {
        com.baidu.adp.gif.b bVar;
        if (this.aOX != null && (bVar = this.aOX.get()) != null) {
            this.aPa = false;
            if (this.isHide) {
                setVisibility(4);
                return;
            }
            this.aOY.onStart();
            if (this.mCurrentFrame != 0) {
                this.mCurrentFrame = 0;
            }
            bVar.N(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageDelayed(1, bVar.O(this.mCurrentFrame));
            this.mHandler.sendEmptyMessageDelayed(2, 2000L);
        }
    }

    public void setPlayOnce(boolean z) {
        this.aOU = z;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        stopLoad();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.mHandler.removeMessages(1);
        stopLoad();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 4 || i == 8) {
            this.isHide = true;
            stop();
            if (this.aOY != null) {
                this.aOY.onStop();
            }
        } else if (i == 0) {
            play();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        com.baidu.adp.gif.b bVar;
        if (!this.mIsLoading && !this.aOG) {
            super.onDraw(canvas);
        }
        canvas.save();
        if (this.aOX != null && !this.mIsLoading && !this.aOG && (bVar = this.aOX.get()) != null) {
            bVar.a(null, canvas);
        }
        canvas.restore();
        if (this.mIsLoading && aOH != null) {
            canvas.save();
            canvas.rotate(this.mCurrentDegrees, (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.5f) + getPaddingLeft(), (((getHeight() - getPaddingTop()) - getPaddingBottom()) * 0.5f) + getPaddingTop());
            canvas.drawBitmap(aOH, this.aON, this.aOM, (Paint) null);
            canvas.restore();
        } else if (this.aOG || (this.mGifInfo != null && this.mGifInfo.mLoadFailed)) {
            canvas.save();
            this.aOZ.draw(canvas);
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
            nextLoadingFrame();
        }
    }

    public com.baidu.adp.gif.b getGif() {
        if (this.aOX == null) {
            return null;
        }
        return this.aOX.get();
    }

    public void stopLoading() {
        this.mIsLoading = false;
        removeCallbacks(this);
        invalidate();
    }

    private void nextLoadingFrame() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.mCurrentDegrees += this.aOI;
        if (this.mCurrentDegrees > 360.0f - this.aOI) {
            this.mCurrentDegrees = 0.0f;
        }
        invalidate();
        nextLoadingFrame();
    }

    public void setPlayCallback(a aVar) {
        this.aOY = aVar;
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
        boolean KV = i.KV();
        com.baidu.adp.base.h ab = com.baidu.adp.base.i.ab(getContext());
        if (ab != null) {
            bdUniqueId = ab.getUniqueId();
            z = ab.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        boolean z2 = gifInfo == this.mGifInfo && this.mPageId == bdUniqueId;
        this.isNew = !z2;
        if (!z2) {
            stopLoad();
        }
        this.mGifInfo = gifInfo;
        this.mPageId = bdUniqueId;
        String str = KV ? this.mGifInfo.mDynamicUrl : this.mGifInfo.mStaticUrl;
        com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) c.ig().a(this.mGifInfo.mSharpText, 20, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(KV), str);
        if (aVar != null) {
            stopLoading();
            setGif(aVar);
        } else if (this.mGifInfo.mLoadFailed) {
            setGif(null);
        } else {
            startLoading();
            if (!z) {
                c.ig().a(this.mGifInfo.mSharpText, 20, this.aOV, 0, 0, this.mPageId, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(KV), str);
            }
        }
    }

    public void stopLoad() {
        stopLoading();
        this.aOG = false;
        if (this.mGifInfo != null) {
            c.ig().a(this.mGifInfo.mSharpText, 20, this.aOV);
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.h
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
            boolean KV = i.KV();
            String str = KV ? this.mGifInfo.mDynamicUrl : this.mGifInfo.mStaticUrl;
            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) c.ig().a(this.mGifInfo.mSharpText, 20, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(KV), str);
            if (aVar != null) {
                this.mGifInfo.mLoadFailed = false;
                setGif(aVar);
            } else {
                startLoading();
                c.ig().a(this.mGifInfo.mSharpText, 20, this.aOV, 0, 0, this.mPageId, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(KV), str);
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
