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
    public static Bitmap bvO;
    private boolean bvM;
    private Drawable bvN;
    private float bvP;
    private final Rect bvT;
    private final Rect bvU;
    private boolean bvV;
    private boolean bwa;
    private final b<com.baidu.adp.widget.a.a> bwb;
    private WeakReference<com.baidu.adp.gif.b> bwd;
    private a bwe;
    private boolean bwf;
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
        void Mu();

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
        this.bvT = new Rect();
        this.bvU = new Rect();
        this.bvV = true;
        this.isHide = false;
        this.isNew = false;
        this.bwf = false;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.gif.GiftGifView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                com.baidu.adp.gif.b bVar;
                boolean z;
                if (GiftGifView.this.bwd != null && (bVar = (com.baidu.adp.gif.b) GiftGifView.this.bwd.get()) != null) {
                    if (message.what == 2) {
                        GiftGifView.this.bwf = true;
                        removeMessages(2);
                    } else if (message.what == 1) {
                        GiftGifView.this.mCurrentFrame++;
                        if (GiftGifView.this.mCurrentFrame >= bVar.getFrameCount()) {
                            if (GiftGifView.this.bwa || GiftGifView.this.bwf) {
                                GiftGifView.this.setVisibility(4);
                                GiftGifView.this.bwa = false;
                                z = true;
                            } else {
                                z = false;
                            }
                            GiftGifView.this.mCurrentFrame = 0;
                        } else {
                            z = false;
                        }
                        bVar.cM(GiftGifView.this.mCurrentFrame);
                        bVar.a(GiftGifView.this.mBitmap, null);
                        GiftGifView.this.invalidate();
                        removeMessages(1);
                        if (!z) {
                            sendEmptyMessageDelayed(1, bVar.cN(GiftGifView.this.mCurrentFrame));
                        } else if (GiftGifView.this.bwe != null) {
                            GiftGifView.this.bwe.onStop();
                        }
                    }
                }
            }
        };
        this.bwb = new b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.gif.GiftGifView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i2) {
                super.onLoaded((AnonymousClass2) aVar, str, i2);
                if (aVar == null) {
                    GiftGifView.this.bwe.Mu();
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
        this.bvP = 30.0f;
        BitmapDrawable bitmapDrawable = (BitmapDrawable) getResources().getDrawable(d.f.tb_loading);
        if (bitmapDrawable != null) {
            bvO = bitmapDrawable.getBitmap();
            this.bvU.set(0, 0, bvO.getWidth(), bvO.getHeight());
        }
        this.bvN = getResources().getDrawable(d.f.image_group_load_f);
        j(this.bvN);
    }

    private void j(Drawable drawable) {
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
            if (bvO != null) {
                int i6 = i5 / 4;
                int i7 = ((i5 - i6) / 2) + paddingLeft;
                int i8 = ((paddingBottom - i6) / 2) + paddingTop;
                this.bvT.set(i7, i8, i7 + i6, i6 + i8);
            }
            int intrinsicWidth = this.bvN.getIntrinsicWidth();
            int intrinsicHeight = this.bvN.getIntrinsicHeight();
            if (intrinsicWidth > i5) {
                intrinsicWidth = i5;
            }
            if (intrinsicHeight > paddingBottom) {
                intrinsicHeight = paddingBottom;
            }
            int i9 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
            int i10 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
            this.bvN.setBounds(i9, i10, intrinsicWidth + i9, intrinsicHeight + i10);
        }
    }

    public void setGif(com.baidu.adp.widget.a.a aVar) {
        this.bvM = false;
        this.mIsLoading = false;
        if (this.mGifInfo != null) {
            this.mGifInfo.mLoadFailed = false;
        }
        if (aVar == null) {
            this.bvM = true;
            if (this.mGifInfo != null) {
                this.mGifInfo.mLoadFailed = true;
            }
            setImageDrawable(null);
            if (this.bwd != null) {
                this.bwd.clear();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.sf()) {
                aVar.a(this);
                this.mIsLoading = false;
            }
            if (this.bwd != null) {
                this.bwd.clear();
            }
        } else if (this.bwd == null || !aVar.getGif().equals(this.bwd.get())) {
            if (this.mBitmap == null || this.mBitmap.getWidth() != aVar.getGif().getWidth() || this.mBitmap.getHeight() != aVar.getGif().getHeight() || this.isNew) {
                this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
            }
            this.bwd = new WeakReference<>(aVar.getGif());
            aVar.getGif().cM(0);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.bvV) {
                play();
            }
        } else {
            aVar.getGif().cM(this.mCurrentFrame);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.bvV) {
                resume();
            }
        }
    }

    public boolean getAutoPlay() {
        return this.bvV;
    }

    public void setAutoPlay(boolean z) {
        this.bvV = z;
    }

    public void resume() {
        com.baidu.adp.gif.b bVar;
        if (this.bwd != null && (bVar = this.bwd.get()) != null) {
            this.bwf = false;
            if (this.isHide) {
                setVisibility(4);
                return;
            }
            this.bwe.onStart();
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageDelayed(1, bVar.cN(this.mCurrentFrame));
            this.mHandler.sendEmptyMessageDelayed(2, 2000L);
        }
    }

    public void stop() {
        com.baidu.adp.gif.b bVar;
        if (this.bwd != null && (bVar = this.bwd.get()) != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mCurrentFrame = 0;
            bVar.cM(0);
            bVar.a(this.mBitmap, null);
            invalidate();
        }
    }

    public void play() {
        com.baidu.adp.gif.b bVar;
        if (this.bwd != null && (bVar = this.bwd.get()) != null) {
            this.bwf = false;
            if (this.isHide) {
                setVisibility(4);
                return;
            }
            this.bwe.onStart();
            if (this.mCurrentFrame != 0) {
                this.mCurrentFrame = 0;
            }
            bVar.cM(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageDelayed(1, bVar.cN(this.mCurrentFrame));
            this.mHandler.sendEmptyMessageDelayed(2, 2000L);
        }
    }

    public void setPlayOnce(boolean z) {
        this.bwa = z;
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
            if (this.bwe != null) {
                this.bwe.onStop();
            }
        } else if (i == 0) {
            play();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        com.baidu.adp.gif.b bVar;
        if (!this.mIsLoading && !this.bvM) {
            super.onDraw(canvas);
        }
        canvas.save();
        if (this.bwd != null && !this.mIsLoading && !this.bvM && (bVar = this.bwd.get()) != null) {
            bVar.a(null, canvas);
        }
        canvas.restore();
        if (this.mIsLoading && bvO != null) {
            canvas.save();
            canvas.rotate(this.mCurrentDegrees, (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.5f) + getPaddingLeft(), (((getHeight() - getPaddingTop()) - getPaddingBottom()) * 0.5f) + getPaddingTop());
            canvas.drawBitmap(bvO, this.bvU, this.bvT, (Paint) null);
            canvas.restore();
        } else if (this.bvM || (this.mGifInfo != null && this.mGifInfo.mLoadFailed)) {
            canvas.save();
            this.bvN.draw(canvas);
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
        if (this.bwd == null) {
            return null;
        }
        return this.bwd.get();
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
        this.mCurrentDegrees += this.bvP;
        if (this.mCurrentDegrees > 360.0f - this.bvP) {
            this.mCurrentDegrees = 0.0f;
        }
        invalidate();
        nextLoadingFrame();
    }

    public void setPlayCallback(a aVar) {
        this.bwe = aVar;
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
        boolean Pa = com.baidu.tbadk.util.i.Pa();
        h ai = com.baidu.adp.base.i.ai(getContext());
        if (ai != null) {
            bdUniqueId = ai.getUniqueId();
            z = ai.isScroll();
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
        String str = Pa ? this.mGifInfo.mDynamicUrl : this.mGifInfo.mStaticUrl;
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) c.nm().a(this.mGifInfo.mSharpText, 20, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(Pa), str);
        if (aVar != null) {
            stopLoading();
            setGif(aVar);
        } else if (this.mGifInfo.mLoadFailed) {
            setGif(null);
        } else {
            startLoading();
            if (!z) {
                c.nm().a(this.mGifInfo.mSharpText, 20, this.bwb, 0, 0, this.mPageId, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(Pa), str);
            }
        }
    }

    public void stopLoad() {
        stopLoading();
        this.bvM = false;
        if (this.mGifInfo != null) {
            c.nm().a(this.mGifInfo.mSharpText, 20, this.bwb);
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
            boolean Pa = com.baidu.tbadk.util.i.Pa();
            String str = Pa ? this.mGifInfo.mDynamicUrl : this.mGifInfo.mStaticUrl;
            com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) c.nm().a(this.mGifInfo.mSharpText, 20, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(Pa), str);
            if (aVar != null) {
                this.mGifInfo.mLoadFailed = false;
                setGif(aVar);
            } else {
                startLoading();
                c.nm().a(this.mGifInfo.mSharpText, 20, this.bwb, 0, 0, this.mPageId, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(Pa), str);
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
