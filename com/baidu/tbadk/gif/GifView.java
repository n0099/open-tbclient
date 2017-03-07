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
import com.baidu.adp.gif.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.newwidget.a.i;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.util.g;
import com.baidu.tieba.w;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public class GifView extends ImageView implements View.OnClickListener, i, Runnable {
    public static Bitmap aCh;
    private com.baidu.adp.gif.b Hu;
    private final int aBZ;
    private int aCa;
    private a aCb;
    private boolean aCc;
    private BitmapDrawable aCd;
    private boolean aCe;
    private Drawable aCf;
    private float aCg;
    private float aCi;
    private boolean aCj;
    private Drawable aCk;
    private int aCl;
    private final Rect aCm;
    private final Rect aCn;
    private boolean aCo;
    private boolean aCp;
    private boolean aCq;
    private boolean aCr;
    private boolean aCs;
    private boolean aCt;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> aCu;
    private Bitmap mBitmap;
    private GifInfo mGifInfo;
    private final Handler mHandler;
    private boolean mIsLoading;
    private View.OnClickListener mOnClickListener;
    private BdUniqueId mPageId;
    private final int mType;

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
        this.aBZ = w.g.pic_expression_upload_selector;
        this.aCc = false;
        this.aCm = new Rect();
        this.aCn = new Rect();
        this.aCo = true;
        this.aCp = false;
        this.aCq = false;
        this.aCr = false;
        this.mHandler = new com.baidu.tbadk.gif.a(this, Looper.getMainLooper());
        this.mType = 20;
        this.aCt = true;
        this.aCu = new b(this);
        this.aCd = (BitmapDrawable) getResources().getDrawable(w.g.icon_content_animation);
        this.aCd.setBounds(0, 0, this.aCd.getIntrinsicWidth(), this.aCd.getIntrinsicHeight());
        this.aCi = 30.0f;
        if (((BitmapDrawable) getResources().getDrawable(w.g.loading)) != null) {
            aCh = a(this);
            this.aCn.set(0, 0, aCh.getWidth(), aCh.getHeight());
        }
        this.aCf = getResources().getDrawable(w.g.image_group_load_f);
        e(this.aCf);
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
            if (a(this) != null) {
                int i6 = i5 / 4;
                int i7 = ((i5 - i6) / 2) + paddingLeft;
                int i8 = ((paddingBottom - i6) / 2) + paddingTop;
                this.aCm.set(i7, i8, i7 + i6, i6 + i8);
            }
            int intrinsicWidth = this.aCf.getIntrinsicWidth();
            int intrinsicHeight = this.aCf.getIntrinsicHeight();
            if (intrinsicWidth > i5) {
                intrinsicWidth = i5;
            }
            if (intrinsicHeight > paddingBottom) {
                intrinsicHeight = paddingBottom;
            }
            int i9 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
            int i10 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
            this.aCf.setBounds(i9, i10, intrinsicWidth + i9, intrinsicHeight + i10);
            if (this.aCk != null) {
                int intrinsicWidth2 = this.aCk.getIntrinsicWidth();
                int intrinsicHeight2 = this.aCk.getIntrinsicHeight();
                if (intrinsicWidth2 > i5) {
                    intrinsicWidth2 = i5;
                }
                if (intrinsicHeight2 > paddingBottom) {
                    intrinsicHeight2 = paddingBottom;
                }
                int i11 = ((i5 - intrinsicWidth2) / 2) + paddingLeft;
                int i12 = ((paddingBottom - intrinsicHeight2) / 2) + paddingTop;
                this.aCk.setBounds(i11, i12, intrinsicWidth2 + i11, intrinsicHeight2 + i12);
            }
        }
    }

    public void release() {
        if (this.aCq && this.Hu != null && this.Hu != null) {
            this.Hu.close();
            this.Hu = null;
        }
    }

    public void setGif(com.baidu.adp.widget.a.a aVar) {
        this.aCe = false;
        this.mIsLoading = false;
        this.aCj = false;
        if (this.mGifInfo != null) {
            this.mGifInfo.mLoadFailed = false;
        }
        if (aVar == null) {
            this.aCe = true;
            this.aCc = false;
            if (this.mGifInfo != null) {
                this.mGifInfo.mLoadFailed = true;
            }
            setImageDrawable(null);
            if (this.Hu != null) {
                this.Hu.close();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.kL()) {
                this.aCc = true;
                aVar.e(this);
                this.mIsLoading = false;
            }
            if (this.Hu != null) {
                this.Hu.close();
            }
        } else if (this.Hu == null || !aVar.getGif().equals(this.Hu)) {
            this.aCc = false;
            try {
                if (this.mBitmap == null || (this.mBitmap.getWidth() != aVar.getGif().getWidth() && this.mBitmap.getHeight() != aVar.getGif().getHeight())) {
                    this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
                }
                this.Hu = aVar.getGif();
                aVar.getGif().V(0);
                aVar.getGif().a(this.mBitmap, null);
                setImageBitmap(this.mBitmap);
                if (this.aCo) {
                    play();
                }
            } catch (Throwable th) {
                onStop();
            }
        } else {
            aVar.getGif().V(this.aCa);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.aCo) {
                resume();
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [377=4, 378=4, 379=4] */
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
        com.baidu.adp.widget.a.a e8 = a.C0003a.dD().e(bArr, 0, i2);
        this.aCq = true;
        setGif(e8);
    }

    public boolean getAutoPlay() {
        return this.aCo;
    }

    public void setAutoPlay(boolean z) {
        this.aCo = z;
    }

    public void resume() {
        this.aCr = false;
        com.baidu.adp.gif.b gif = getGif();
        if (gif != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, gif.W(this.aCa));
        }
    }

    public void stop() {
        com.baidu.adp.gif.b gif = getGif();
        if (gif != null) {
            this.mHandler.removeMessages(1);
            gif.V(0);
            gif.a(this.mBitmap, null);
            invalidate();
            onStop();
        }
    }

    public void play() {
        this.aCr = false;
        com.baidu.adp.gif.b gif = getGif();
        if (gif != null) {
            if (this.aCa != 0) {
                this.aCa = 0;
            }
            gif.V(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, gif.W(this.aCa));
        }
    }

    public void Eg() {
        this.aCs = true;
        play();
    }

    public void onDestroy() {
        this.Hu = null;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandler.removeMessages(1);
        Ei();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.mHandler.removeMessages(1);
        Ei();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (!this.aCc) {
            if (i == 4 || i == 8) {
                stop();
            } else if (i == 0) {
                play();
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (!this.mIsLoading && !this.aCe && !this.aCj) {
            super.onDraw(canvas);
        }
        canvas.save();
        try {
            if (this.Hu != null && !this.mIsLoading && !this.aCe && !this.aCj) {
                this.Hu.a(null, canvas);
            }
        } catch (Throwable th) {
            BdLog.e("setGif:" + th.getMessage());
            onStop();
        }
        canvas.restore();
        if (this.aCc) {
            canvas.save();
            this.aCd.draw(canvas);
            canvas.restore();
        }
        if (this.mIsLoading && a(this) != null) {
            canvas.save();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            canvas.rotate(this.aCg, (width * 0.5f) + getPaddingLeft(), (height * 0.5f) + getPaddingTop());
            canvas.drawBitmap(a(this), this.aCn, this.aCm, (Paint) null);
            canvas.restore();
        } else if (this.aCe || (this.mGifInfo != null && this.mGifInfo.mLoadFailed)) {
            canvas.save();
            this.aCf.draw(canvas);
            canvas.restore();
        } else if (this.aCj) {
            canvas.save();
            this.aCk.draw(canvas);
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
            Eh();
        }
    }

    public void d(boolean z, int i) {
        this.aCj = z;
        if (z) {
            this.mIsLoading = false;
            this.aCe = false;
            if (this.aCk == null || this.aCl != i) {
                this.aCl = i;
                this.aCk = aq.getDrawable(i);
                int intrinsicWidth = this.aCk.getIntrinsicWidth();
                int intrinsicHeight = this.aCk.getIntrinsicHeight();
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
                this.aCk.setBounds(paddingLeft, paddingTop, intrinsicWidth + paddingLeft, intrinsicHeight + paddingTop);
            }
        }
        invalidate();
    }

    public void stopLoading() {
        this.mIsLoading = false;
        removeCallbacks(this);
        invalidate();
    }

    private void Eh() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aCg += this.aCi;
        if (this.aCg > 360.0f - this.aCi) {
            this.aCg = 0.0f;
        }
        invalidate();
        Eh();
    }

    public void setPlayCallback(a aVar) {
        this.aCb = aVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.aCk != null && this.aCk.isStateful()) {
            this.aCk.setState(getDrawableState());
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
        boolean GL = g.GL();
        j Y = k.Y(getContext());
        if (Y != null) {
            bdUniqueId = Y.getUniqueId();
            z = Y.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        if (!(gifInfo == this.mGifInfo && this.mPageId == bdUniqueId)) {
            Ei();
        }
        this.mGifInfo = gifInfo;
        this.mPageId = bdUniqueId;
        String str = GL ? this.mGifInfo.mDynamicUrl : this.mGifInfo.mStaticUrl;
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.fG().a(this.mGifInfo.mSharpText, 20, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(GL), str);
        if (aVar != null) {
            stopLoading();
            setGif(aVar);
        } else if (this.mGifInfo.mLoadFailed) {
            setGif(null);
        } else if (!com.baidu.adp.lib.f.c.fG().am(20) && this.aCt) {
            d(true, this.aBZ);
        } else if (!z) {
            com.baidu.adp.lib.f.c.fG().a(this.mGifInfo.mSharpText, 20, this.aCu);
            startLoading();
            com.baidu.adp.lib.f.c.fG().a(this.mGifInfo.mSharpText, 20, this.aCu, 0, 0, this.mPageId, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(GL), str);
        }
    }

    public void Ei() {
        stopLoading();
        this.aCe = false;
        this.aCj = false;
        if (this.mGifInfo != null) {
            com.baidu.adp.lib.f.c.fG().a(this.mGifInfo.mSharpText, 20, this.aCu);
        }
    }

    @Override // com.baidu.adp.newwidget.a.i
    public void refresh() {
        a(this.mGifInfo);
    }

    public void setSupportNoImage(boolean z) {
        this.aCt = z;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(this);
        this.mOnClickListener = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mGifInfo != null) {
            boolean GL = g.GL();
            String str = GL ? this.mGifInfo.mDynamicUrl : this.mGifInfo.mStaticUrl;
            com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.fG().a(this.mGifInfo.mSharpText, 20, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(GL), str);
            if (aVar != null) {
                this.mGifInfo.mLoadFailed = false;
                setGif(aVar);
            } else {
                startLoading();
                com.baidu.adp.lib.f.c.fG().a(this.mGifInfo.mSharpText, 20, this.aCu, 0, 0, this.mPageId, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(GL), str);
                return;
            }
        }
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    public void setIsKeepLastFrame(boolean z) {
        this.aCp = z;
    }

    public static Bitmap a(GifView gifView) {
        if (aCh != null && !aCh.isRecycled()) {
            return aCh;
        }
        BitmapDrawable bitmapDrawable = (BitmapDrawable) gifView.getResources().getDrawable(w.g.loading);
        if (bitmapDrawable != null) {
            aCh = bitmapDrawable.getBitmap();
        }
        return aCh;
    }

    public com.baidu.adp.gif.b getGif() {
        if (this.Hu == null) {
            onStop();
            return null;
        }
        return this.Hu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStop() {
        if (this.aCb != null && !this.aCr) {
            this.aCb.onStop();
            this.aCr = true;
        }
    }
}
