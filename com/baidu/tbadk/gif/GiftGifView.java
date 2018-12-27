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
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import com.baidu.tbadk.util.i;
import com.baidu.tieba.e;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class GiftGifView extends ImageView implements View.OnClickListener, h, Runnable {
    public static Bitmap bbH;
    private boolean bbG;
    private float bbI;
    private final Rect bbM;
    private final Rect bbN;
    private boolean bbT;
    private final b<com.baidu.adp.widget.ImageView.a> bbU;
    private WeakReference<com.baidu.adp.gif.b> bbW;
    private a bbX;
    private Drawable bbY;
    private boolean bbZ;
    private boolean isHide;
    private boolean isNew;
    private boolean mAutoPlay;
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
        this.bbM = new Rect();
        this.bbN = new Rect();
        this.mAutoPlay = true;
        this.isHide = false;
        this.isNew = false;
        this.bbZ = false;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.gif.GiftGifView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                com.baidu.adp.gif.b bVar;
                boolean z;
                if (GiftGifView.this.bbW != null && (bVar = (com.baidu.adp.gif.b) GiftGifView.this.bbW.get()) != null) {
                    if (message.what == 2) {
                        GiftGifView.this.bbZ = true;
                        removeMessages(2);
                    } else if (message.what == 1) {
                        GiftGifView.this.mCurrentFrame++;
                        if (GiftGifView.this.mCurrentFrame >= bVar.getFrameCount()) {
                            if (GiftGifView.this.bbT || GiftGifView.this.bbZ) {
                                GiftGifView.this.setVisibility(4);
                                GiftGifView.this.bbT = false;
                                z = true;
                            } else {
                                z = false;
                            }
                            GiftGifView.this.mCurrentFrame = 0;
                        } else {
                            z = false;
                        }
                        bVar.am(GiftGifView.this.mCurrentFrame);
                        bVar.a(GiftGifView.this.mBitmap, null);
                        GiftGifView.this.invalidate();
                        removeMessages(1);
                        if (!z) {
                            sendEmptyMessageDelayed(1, bVar.an(GiftGifView.this.mCurrentFrame));
                        } else if (GiftGifView.this.bbX != null) {
                            GiftGifView.this.bbX.onStop();
                        }
                    }
                }
            }
        };
        this.bbU = new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.gif.GiftGifView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                super.onLoaded((AnonymousClass2) aVar, str, i2);
                if (aVar == null) {
                    GiftGifView.this.bbX.onFail();
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
        this.bbI = 30.0f;
        BitmapDrawable bitmapDrawable = (BitmapDrawable) getResources().getDrawable(e.f.tb_loading);
        if (bitmapDrawable != null) {
            bbH = bitmapDrawable.getBitmap();
            this.bbN.set(0, 0, bbH.getWidth(), bbH.getHeight());
        }
        this.bbY = getResources().getDrawable(e.f.image_group_load_f);
        d(this.bbY);
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
            if (bbH != null) {
                int i6 = i5 / 4;
                int i7 = ((i5 - i6) / 2) + paddingLeft;
                int i8 = ((paddingBottom - i6) / 2) + paddingTop;
                this.bbM.set(i7, i8, i7 + i6, i6 + i8);
            }
            int intrinsicWidth = this.bbY.getIntrinsicWidth();
            int intrinsicHeight = this.bbY.getIntrinsicHeight();
            if (intrinsicWidth > i5) {
                intrinsicWidth = i5;
            }
            if (intrinsicHeight > paddingBottom) {
                intrinsicHeight = paddingBottom;
            }
            int i9 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
            int i10 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
            this.bbY.setBounds(i9, i10, intrinsicWidth + i9, intrinsicHeight + i10);
        }
    }

    public void setGif(com.baidu.adp.widget.ImageView.a aVar) {
        this.bbG = false;
        this.mIsLoading = false;
        if (this.mGifInfo != null) {
            this.mGifInfo.mLoadFailed = false;
        }
        if (aVar == null) {
            this.bbG = true;
            if (this.mGifInfo != null) {
                this.mGifInfo.mLoadFailed = true;
            }
            setImageDrawable(null);
            if (this.bbW != null) {
                this.bbW.clear();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.on()) {
                aVar.a(this);
                this.mIsLoading = false;
            }
            if (this.bbW != null) {
                this.bbW.clear();
            }
        } else if (this.bbW == null || !aVar.getGif().equals(this.bbW.get())) {
            if (this.mBitmap == null || this.mBitmap.getWidth() != aVar.getGif().getWidth() || this.mBitmap.getHeight() != aVar.getGif().getHeight() || this.isNew) {
                this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
            }
            this.bbW = new WeakReference<>(aVar.getGif());
            aVar.getGif().am(0);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.mAutoPlay) {
                play();
            }
        } else {
            aVar.getGif().am(this.mCurrentFrame);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.mAutoPlay) {
                resume();
            }
        }
    }

    public boolean getAutoPlay() {
        return this.mAutoPlay;
    }

    public void setAutoPlay(boolean z) {
        this.mAutoPlay = z;
    }

    public void resume() {
        com.baidu.adp.gif.b bVar;
        if (this.bbW != null && (bVar = this.bbW.get()) != null) {
            this.bbZ = false;
            if (this.isHide) {
                setVisibility(4);
                return;
            }
            this.bbX.onStart();
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageDelayed(1, bVar.an(this.mCurrentFrame));
            this.mHandler.sendEmptyMessageDelayed(2, SystemScreenshotManager.DELAY_TIME);
        }
    }

    public void stop() {
        com.baidu.adp.gif.b bVar;
        if (this.bbW != null && (bVar = this.bbW.get()) != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mCurrentFrame = 0;
            bVar.am(0);
            bVar.a(this.mBitmap, null);
            invalidate();
        }
    }

    public void play() {
        com.baidu.adp.gif.b bVar;
        if (this.bbW != null && (bVar = this.bbW.get()) != null) {
            this.bbZ = false;
            if (this.isHide) {
                setVisibility(4);
                return;
            }
            this.bbX.onStart();
            if (this.mCurrentFrame != 0) {
                this.mCurrentFrame = 0;
            }
            bVar.am(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageDelayed(1, bVar.an(this.mCurrentFrame));
            this.mHandler.sendEmptyMessageDelayed(2, SystemScreenshotManager.DELAY_TIME);
        }
    }

    public void setPlayOnce(boolean z) {
        this.bbT = z;
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
            if (this.bbX != null) {
                this.bbX.onStop();
            }
        } else if (i == 0) {
            play();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        com.baidu.adp.gif.b bVar;
        if (!this.mIsLoading && !this.bbG) {
            super.onDraw(canvas);
        }
        canvas.save();
        if (this.bbW != null && !this.mIsLoading && !this.bbG && (bVar = this.bbW.get()) != null) {
            bVar.a(null, canvas);
        }
        canvas.restore();
        if (this.mIsLoading && bbH != null) {
            canvas.save();
            canvas.rotate(this.mCurrentDegrees, (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.5f) + getPaddingLeft(), (((getHeight() - getPaddingTop()) - getPaddingBottom()) * 0.5f) + getPaddingTop());
            canvas.drawBitmap(bbH, this.bbN, this.bbM, (Paint) null);
            canvas.restore();
        } else if (this.bbG || (this.mGifInfo != null && this.mGifInfo.mLoadFailed)) {
            canvas.save();
            this.bbY.draw(canvas);
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
        if (this.bbW == null) {
            return null;
        }
        return this.bbW.get();
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
        this.mCurrentDegrees += this.bbI;
        if (this.mCurrentDegrees > 360.0f - this.bbI) {
            this.mCurrentDegrees = 0.0f;
        }
        invalidate();
        nextLoadingFrame();
    }

    public void setPlayCallback(a aVar) {
        this.bbX = aVar;
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
        boolean PS = i.PS();
        com.baidu.adp.base.h aI = com.baidu.adp.base.i.aI(getContext());
        if (aI != null) {
            bdUniqueId = aI.getUniqueId();
            z = aI.isScroll();
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
        String str = PS ? this.mGifInfo.mDynamicUrl : this.mGifInfo.mStaticUrl;
        com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) c.jA().a(this.mGifInfo.mSharpText, 20, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(PS), str);
        if (aVar != null) {
            stopLoading();
            setGif(aVar);
        } else if (this.mGifInfo.mLoadFailed) {
            setGif(null);
        } else {
            startLoading();
            if (!z) {
                c.jA().a(this.mGifInfo.mSharpText, 20, this.bbU, 0, 0, this.mPageId, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(PS), str);
            }
        }
    }

    public void stopLoad() {
        stopLoading();
        this.bbG = false;
        if (this.mGifInfo != null) {
            c.jA().a(this.mGifInfo.mSharpText, 20, this.bbU);
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
            boolean PS = i.PS();
            String str = PS ? this.mGifInfo.mDynamicUrl : this.mGifInfo.mStaticUrl;
            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) c.jA().a(this.mGifInfo.mSharpText, 20, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(PS), str);
            if (aVar != null) {
                this.mGifInfo.mLoadFailed = false;
                setGif(aVar);
            } else {
                startLoading();
                c.jA().a(this.mGifInfo.mSharpText, 20, this.bbU, 0, 0, this.mPageId, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(PS), str);
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
