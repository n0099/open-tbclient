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
import com.baidu.adp.gif.a;
import com.baidu.adp.gif.b;
import com.baidu.adp.lib.f.c;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.util.h;
import com.baidu.tieba.d;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public class GifView extends ImageView implements View.OnClickListener, i, Runnable {
    public static Bitmap aEo;
    private b Gt;
    private boolean aEA;
    private boolean aEB;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> aEC;
    private final int aEf;
    private int aEg;
    private a aEh;
    private boolean aEi;
    private boolean aEj;
    private BitmapDrawable aEk;
    private boolean aEl;
    private Drawable aEm;
    private float aEn;
    private float aEp;
    private boolean aEq;
    private Drawable aEr;
    private int aEs;
    private final Rect aEt;
    private final Rect aEu;
    private boolean aEv;
    private boolean aEw;
    private boolean aEx;
    private boolean aEy;
    private com.baidu.adp.widget.ImageView.a aEz;
    private Bitmap mBitmap;
    private GifInfo mGifInfo;
    private final Handler mHandler;
    private boolean mIsLoading;
    private View.OnClickListener mOnClickListener;
    private BdUniqueId mPageId;
    private int mType;

    /* loaded from: classes.dex */
    public interface a {
        void onStop();
    }

    public GifView(Context context) {
        this(context, null, 0);
    }

    public GifView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GifView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aEf = d.g.pic_expression_upload_selector;
        this.aEi = false;
        this.aEj = true;
        this.aEt = new Rect();
        this.aEu = new Rect();
        this.aEv = true;
        this.aEw = false;
        this.aEx = false;
        this.aEy = false;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.gif.GifView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                boolean z;
                b gif = GifView.this.getGif();
                if (gif != null && message.what == 1) {
                    GifView.this.aEg++;
                    if (GifView.this.aEg >= gif.getFrameCount()) {
                        if (GifView.this.aEA) {
                            if (!GifView.this.aEw) {
                                GifView.this.setVisibility(4);
                            }
                            GifView.this.aEA = false;
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!GifView.this.aEw) {
                            GifView.this.aEg = 0;
                        } else {
                            GifView.this.aEg = gif.getFrameCount() - 1;
                        }
                    } else {
                        z = false;
                    }
                    gif.T(GifView.this.aEg);
                    gif.a(GifView.this.mBitmap, null);
                    GifView.this.invalidate();
                    removeMessages(1);
                    if (z) {
                        GifView.this.onStop();
                    } else {
                        sendEmptyMessageDelayed(1, gif.U(GifView.this.aEg));
                    }
                }
            }
        };
        this.mType = 20;
        this.aEB = true;
        this.aEC = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.gif.GifView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                super.onLoaded((AnonymousClass2) aVar, str, i2);
                GifView.this.stopLoading();
                GifView.this.setGif(aVar);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onProgressUpdate(Object... objArr) {
                super.onProgressUpdate(objArr);
            }
        };
        this.aEk = (BitmapDrawable) getResources().getDrawable(d.g.icon_content_animation);
        this.aEk.setBounds(0, 0, this.aEk.getIntrinsicWidth(), this.aEk.getIntrinsicHeight());
        this.aEp = 30.0f;
        if (((BitmapDrawable) getResources().getDrawable(d.g.loading)) != null) {
            aEo = a(this);
            this.aEu.set(0, 0, aEo.getWidth(), aEo.getHeight());
        }
        this.aEm = getResources().getDrawable(d.g.image_group_load_f);
        d(this.aEm);
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
            if (a(this) != null) {
                int i6 = i5 / 4;
                int i7 = ((i5 - i6) / 2) + paddingLeft;
                int i8 = ((paddingBottom - i6) / 2) + paddingTop;
                this.aEt.set(i7, i8, i7 + i6, i6 + i8);
            }
            int intrinsicWidth = this.aEm.getIntrinsicWidth();
            int intrinsicHeight = this.aEm.getIntrinsicHeight();
            if (intrinsicWidth > i5) {
                intrinsicWidth = i5;
            }
            if (intrinsicHeight > paddingBottom) {
                intrinsicHeight = paddingBottom;
            }
            int i9 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
            int i10 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
            this.aEm.setBounds(i9, i10, intrinsicWidth + i9, intrinsicHeight + i10);
            if (this.aEr != null) {
                int intrinsicWidth2 = this.aEr.getIntrinsicWidth();
                int intrinsicHeight2 = this.aEr.getIntrinsicHeight();
                if (intrinsicWidth2 > i5) {
                    intrinsicWidth2 = i5;
                }
                if (intrinsicHeight2 > paddingBottom) {
                    intrinsicHeight2 = paddingBottom;
                }
                int i11 = ((i5 - intrinsicWidth2) / 2) + paddingLeft;
                int i12 = ((paddingBottom - intrinsicHeight2) / 2) + paddingTop;
                this.aEr.setBounds(i11, i12, intrinsicWidth2 + i11, intrinsicHeight2 + i12);
            }
        }
    }

    public void release() {
        if (this.aEx && this.Gt != null && this.Gt != null) {
            this.Gt.close();
            this.Gt = null;
        }
    }

    public void setGif(com.baidu.adp.widget.ImageView.a aVar) {
        this.aEl = false;
        this.mIsLoading = false;
        this.aEq = false;
        if (this.mGifInfo != null) {
            this.mGifInfo.mLoadFailed = false;
        }
        if (aVar == null) {
            this.aEl = true;
            this.aEi = false;
            if (this.mGifInfo != null) {
                this.mGifInfo.mLoadFailed = true;
            }
            setImageDrawable(null);
            if (this.Gt != null) {
                this.Gt.close();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.kL()) {
                this.aEi = true;
                aVar.a(this);
                this.mIsLoading = false;
            }
            if (this.Gt != null) {
                this.Gt.close();
            }
        } else if (this.Gt == null || !aVar.getGif().equals(this.Gt)) {
            this.aEi = false;
            try {
                if (this.mBitmap == null || (this.mBitmap.getWidth() != aVar.getGif().getWidth() && this.mBitmap.getHeight() != aVar.getGif().getHeight())) {
                    this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
                }
                this.Gt = aVar.getGif();
                aVar.getGif().T(0);
                aVar.getGif().a(this.mBitmap, null);
                setImageBitmap(this.mBitmap);
                if (this.aEv) {
                    play();
                }
            } catch (Throwable th) {
                onStop();
            }
        } else {
            aVar.getGif().T(this.aEg);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.aEv) {
                resume();
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [384=4, 382=4, 383=4] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001f A[ADDED_TO_REGION, ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setGifRaw(int i) {
        int i2;
        InputStream openRawResource = getContext().getResources().openRawResource(i);
        byte[] bArr = null;
        try {
            try {
                i2 = openRawResource.available();
            } finally {
                try {
                    openRawResource.close();
                } catch (IOException e) {
                    BdLog.e(e.getMessage());
                }
            }
        } catch (IOException e2) {
            e = e2;
            i2 = 0;
        } catch (OutOfMemoryError e3) {
            e = e3;
            i2 = 0;
        }
        try {
            bArr = new byte[i2];
            openRawResource.read(bArr);
        } catch (IOException e4) {
            e = e4;
            BdLog.e(e.getMessage());
            try {
                openRawResource.close();
            } catch (IOException e5) {
                BdLog.e(e5.getMessage());
            }
            if (bArr == null) {
                return;
            }
            return;
        } catch (OutOfMemoryError e6) {
            e = e6;
            BdLog.e(e.getMessage());
            try {
                openRawResource.close();
            } catch (IOException e7) {
                BdLog.e(e7.getMessage());
            }
            if (bArr == null) {
            }
        }
        if (bArr == null || bArr.length < i2) {
            return;
        }
        com.baidu.adp.widget.ImageView.a g = a.C0002a.dD().g(bArr, 0, i2);
        this.aEx = true;
        setGif(g);
    }

    public boolean getAutoPlay() {
        return this.aEv;
    }

    public void setAutoPlay(boolean z) {
        this.aEv = z;
    }

    public void pause() {
        this.mHandler.removeMessages(1);
    }

    public void resume() {
        this.aEy = false;
        b gif = getGif();
        if (gif != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, gif.U(this.aEg));
        }
    }

    public void stop() {
        b gif = getGif();
        if (gif != null) {
            this.mHandler.removeMessages(1);
            gif.T(0);
            gif.a(this.mBitmap, null);
            invalidate();
            onStop();
        }
    }

    public void play() {
        this.aEy = false;
        b gif = getGif();
        if (gif != null) {
            if (this.aEg != 0) {
                this.aEg = 0;
            }
            gif.T(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, gif.U(this.aEg));
        }
    }

    public void DS() {
        this.aEA = true;
        play();
    }

    public void onDestroy() {
        this.aEz = null;
        if (this.Gt != null) {
            this.Gt.close();
        }
        if (this.mGifInfo != null) {
            this.mGifInfo = null;
        }
        if (this.mBitmap != null) {
            this.mBitmap = null;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandler.removeMessages(1);
        DU();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.mHandler.removeMessages(1);
        DU();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (!this.aEi) {
            if (i == 4 || i == 8) {
                stop();
            } else if (i == 0) {
                play();
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (!this.mIsLoading && !this.aEl && !this.aEq) {
            super.onDraw(canvas);
        }
        canvas.save();
        try {
            if (this.Gt != null && !this.mIsLoading && !this.aEl && !this.aEq) {
                this.Gt.a(null, canvas);
            }
        } catch (Throwable th) {
            BdLog.e("setGif:" + th.getMessage());
            onStop();
        }
        canvas.restore();
        if (this.aEi && this.aEj) {
            canvas.save();
            this.aEk.draw(canvas);
            canvas.restore();
        }
        if (this.mIsLoading && a(this) != null) {
            canvas.save();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            canvas.rotate(this.aEn, (width * 0.5f) + getPaddingLeft(), (height * 0.5f) + getPaddingTop());
            canvas.drawBitmap(a(this), this.aEu, this.aEt, (Paint) null);
            canvas.restore();
        } else if (this.aEl || (this.mGifInfo != null && this.mGifInfo.mLoadFailed)) {
            canvas.save();
            this.aEm.draw(canvas);
            canvas.restore();
        } else if (this.aEq) {
            canvas.save();
            this.aEr.draw(canvas);
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
            DT();
        }
    }

    public void e(boolean z, int i) {
        this.aEq = z;
        if (z) {
            this.mIsLoading = false;
            this.aEl = false;
            if (this.aEr == null || this.aEs != i) {
                this.aEs = i;
                this.aEr = aj.getDrawable(i);
                int intrinsicWidth = this.aEr.getIntrinsicWidth();
                int intrinsicHeight = this.aEr.getIntrinsicHeight();
                int measuredWidth = getMeasuredWidth();
                int measuredHeight = getMeasuredHeight();
                if (intrinsicWidth > measuredWidth) {
                    intrinsicWidth = measuredWidth;
                }
                if (intrinsicHeight > measuredHeight) {
                    intrinsicHeight = measuredHeight;
                }
                int paddingLeft = ((measuredWidth - intrinsicWidth) / 2) + getPaddingLeft();
                int paddingTop = ((measuredHeight - intrinsicHeight) / 2) + getPaddingTop();
                this.aEr.setBounds(paddingLeft, paddingTop, intrinsicWidth + paddingLeft, intrinsicHeight + paddingTop);
            }
        }
        invalidate();
    }

    public void stopLoading() {
        this.mIsLoading = false;
        removeCallbacks(this);
        invalidate();
    }

    private void DT() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aEn += this.aEp;
        if (this.aEn > 360.0f - this.aEp) {
            this.aEn = 0.0f;
        }
        invalidate();
        DT();
    }

    public void setPlayCallback(a aVar) {
        this.aEh = aVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.aEr != null && this.aEr.isStateful()) {
            this.aEr.setState(getDrawableState());
            invalidate();
        }
    }

    public void a(GifInfo gifInfo) {
        BdUniqueId bdUniqueId;
        boolean z;
        if (gifInfo == null) {
            this.mGifInfo = null;
            return;
        }
        boolean GH = h.GH();
        com.baidu.adp.base.h W = com.baidu.adp.base.i.W(getContext());
        if (W != null) {
            bdUniqueId = W.getUniqueId();
            z = W.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        if (!(gifInfo == this.mGifInfo && this.mPageId == bdUniqueId)) {
            DU();
        }
        this.mGifInfo = gifInfo;
        this.mPageId = bdUniqueId;
        String str = GH ? this.mGifInfo.mDynamicUrl : this.mGifInfo.mStaticUrl;
        com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) c.fJ().a(this.mGifInfo.mSharpText, this.mType, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(GH), str);
        if (aVar != null) {
            stopLoading();
            setGif(aVar);
        } else if (this.mGifInfo.mLoadFailed) {
            setGif(null);
        } else if (!c.fJ().ao(this.mType) && this.aEB) {
            e(true, this.aEf);
        } else if (!z) {
            c.fJ().a(this.mGifInfo.mSharpText, this.mType, this.aEC);
            startLoading();
            c.fJ().a(this.mGifInfo.mSharpText, this.mType, this.aEC, 0, 0, this.mPageId, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(GH), str);
        }
    }

    public void DU() {
        stopLoading();
        this.aEl = false;
        this.aEq = false;
        if (this.mGifInfo != null) {
            c.fJ().a(this.mGifInfo.mSharpText, this.mType, this.aEC);
        }
    }

    @Override // com.baidu.adp.b.a.i
    public void refresh() {
        a(this.mGifInfo);
    }

    public void setSupportNoImage(boolean z) {
        this.aEB = z;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(this);
        this.mOnClickListener = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mGifInfo != null) {
            boolean GH = h.GH();
            String str = GH ? this.mGifInfo.mDynamicUrl : this.mGifInfo.mStaticUrl;
            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) c.fJ().a(this.mGifInfo.mSharpText, this.mType, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(GH), str);
            if (aVar != null) {
                this.mGifInfo.mLoadFailed = false;
                setGif(aVar);
            } else {
                startLoading();
                c.fJ().a(this.mGifInfo.mSharpText, this.mType, this.aEC, 0, 0, this.mPageId, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(GH), str);
                return;
            }
        }
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    public void setIsKeepLastFrame(boolean z) {
        this.aEw = z;
    }

    public static Bitmap a(GifView gifView) {
        if (aEo != null && !aEo.isRecycled()) {
            return aEo;
        }
        BitmapDrawable bitmapDrawable = (BitmapDrawable) gifView.getResources().getDrawable(d.g.loading);
        if (bitmapDrawable != null) {
            aEo = bitmapDrawable.getBitmap();
        }
        return aEo;
    }

    public b getGif() {
        if (this.Gt == null) {
            onStop();
            return null;
        }
        return this.Gt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStop() {
        if (this.aEh != null && !this.aEy) {
            this.aEh.onStop();
            this.aEy = true;
        }
    }

    public void setShowStaticDrawable(boolean z) {
        this.aEj = z;
    }

    public GifInfo getGifInfo() {
        return this.mGifInfo;
    }

    public void setBgImage(com.baidu.adp.widget.ImageView.a aVar) {
        this.aEz = aVar;
    }

    public com.baidu.adp.widget.ImageView.a getBdImage() {
        return this.aEz;
    }

    public void setType(int i) {
        this.mType = i;
    }
}
