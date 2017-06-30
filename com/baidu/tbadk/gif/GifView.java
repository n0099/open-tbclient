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
import com.baidu.adp.b.a.i;
import com.baidu.adp.base.j;
import com.baidu.adp.base.k;
import com.baidu.adp.gif.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.w;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public class GifView extends ImageView implements View.OnClickListener, i, Runnable {
    public static Bitmap aDp;
    private com.baidu.adp.gif.b GX;
    private boolean aDA;
    private boolean aDB;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> aDC;
    private final int aDg;
    private int aDh;
    private a aDi;
    private boolean aDj;
    private boolean aDk;
    private BitmapDrawable aDl;
    private boolean aDm;
    private Drawable aDn;
    private float aDo;
    private float aDq;
    private boolean aDr;
    private Drawable aDs;
    private int aDt;
    private final Rect aDu;
    private final Rect aDv;
    private boolean aDw;
    private boolean aDx;
    private boolean aDy;
    private boolean aDz;
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
        this.aDg = w.g.pic_expression_upload_selector;
        this.aDj = false;
        this.aDk = true;
        this.aDu = new Rect();
        this.aDv = new Rect();
        this.aDw = true;
        this.aDx = false;
        this.aDy = false;
        this.aDz = false;
        this.mHandler = new com.baidu.tbadk.gif.a(this, Looper.getMainLooper());
        this.mType = 20;
        this.aDB = true;
        this.aDC = new b(this);
        this.aDl = (BitmapDrawable) getResources().getDrawable(w.g.icon_content_animation);
        this.aDl.setBounds(0, 0, this.aDl.getIntrinsicWidth(), this.aDl.getIntrinsicHeight());
        this.aDq = 30.0f;
        if (((BitmapDrawable) getResources().getDrawable(w.g.loading)) != null) {
            aDp = a(this);
            this.aDv.set(0, 0, aDp.getWidth(), aDp.getHeight());
        }
        this.aDn = getResources().getDrawable(w.g.image_group_load_f);
        e(this.aDn);
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
                this.aDu.set(i7, i8, i7 + i6, i6 + i8);
            }
            int intrinsicWidth = this.aDn.getIntrinsicWidth();
            int intrinsicHeight = this.aDn.getIntrinsicHeight();
            if (intrinsicWidth > i5) {
                intrinsicWidth = i5;
            }
            if (intrinsicHeight > paddingBottom) {
                intrinsicHeight = paddingBottom;
            }
            int i9 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
            int i10 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
            this.aDn.setBounds(i9, i10, intrinsicWidth + i9, intrinsicHeight + i10);
            if (this.aDs != null) {
                int intrinsicWidth2 = this.aDs.getIntrinsicWidth();
                int intrinsicHeight2 = this.aDs.getIntrinsicHeight();
                if (intrinsicWidth2 > i5) {
                    intrinsicWidth2 = i5;
                }
                if (intrinsicHeight2 > paddingBottom) {
                    intrinsicHeight2 = paddingBottom;
                }
                int i11 = ((i5 - intrinsicWidth2) / 2) + paddingLeft;
                int i12 = ((paddingBottom - intrinsicHeight2) / 2) + paddingTop;
                this.aDs.setBounds(i11, i12, intrinsicWidth2 + i11, intrinsicHeight2 + i12);
            }
        }
    }

    public void release() {
        if (this.aDy && this.GX != null && this.GX != null) {
            this.GX.close();
            this.GX = null;
        }
    }

    public void setGif(com.baidu.adp.widget.a.a aVar) {
        this.aDm = false;
        this.mIsLoading = false;
        this.aDr = false;
        if (this.mGifInfo != null) {
            this.mGifInfo.mLoadFailed = false;
        }
        if (aVar == null) {
            this.aDm = true;
            this.aDj = false;
            if (this.mGifInfo != null) {
                this.mGifInfo.mLoadFailed = true;
            }
            setImageDrawable(null);
            if (this.GX != null) {
                this.GX.close();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.kN()) {
                this.aDj = true;
                aVar.e(this);
                this.mIsLoading = false;
            }
            if (this.GX != null) {
                this.GX.close();
            }
        } else if (this.GX == null || !aVar.getGif().equals(this.GX)) {
            this.aDj = false;
            try {
                if (this.mBitmap == null || (this.mBitmap.getWidth() != aVar.getGif().getWidth() && this.mBitmap.getHeight() != aVar.getGif().getHeight())) {
                    this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
                }
                this.GX = aVar.getGif();
                aVar.getGif().T(0);
                aVar.getGif().a(this.mBitmap, null);
                setImageBitmap(this.mBitmap);
                if (this.aDw) {
                    play();
                }
            } catch (Throwable th) {
                onStop();
            }
        } else {
            aVar.getGif().T(this.aDh);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.aDw) {
                resume();
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [379=4, 380=4, 381=4] */
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
        com.baidu.adp.widget.a.a g = a.C0003a.dD().g(bArr, 0, i2);
        this.aDy = true;
        setGif(g);
    }

    public boolean getAutoPlay() {
        return this.aDw;
    }

    public void setAutoPlay(boolean z) {
        this.aDw = z;
    }

    public void resume() {
        this.aDz = false;
        com.baidu.adp.gif.b gif = getGif();
        if (gif != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, gif.U(this.aDh));
        }
    }

    public void stop() {
        com.baidu.adp.gif.b gif = getGif();
        if (gif != null) {
            this.mHandler.removeMessages(1);
            gif.T(0);
            gif.a(this.mBitmap, null);
            invalidate();
            onStop();
        }
    }

    public void play() {
        this.aDz = false;
        com.baidu.adp.gif.b gif = getGif();
        if (gif != null) {
            if (this.aDh != 0) {
                this.aDh = 0;
            }
            gif.T(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, gif.U(this.aDh));
        }
    }

    public void DW() {
        this.aDA = true;
        play();
    }

    public void onDestroy() {
        this.GX = null;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandler.removeMessages(1);
        DY();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.mHandler.removeMessages(1);
        DY();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (!this.aDj) {
            if (i == 4 || i == 8) {
                stop();
            } else if (i == 0) {
                play();
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (!this.mIsLoading && !this.aDm && !this.aDr) {
            super.onDraw(canvas);
        }
        canvas.save();
        try {
            if (this.GX != null && !this.mIsLoading && !this.aDm && !this.aDr) {
                this.GX.a(null, canvas);
            }
        } catch (Throwable th) {
            BdLog.e("setGif:" + th.getMessage());
            onStop();
        }
        canvas.restore();
        if (this.aDj && this.aDk) {
            canvas.save();
            this.aDl.draw(canvas);
            canvas.restore();
        }
        if (this.mIsLoading && a(this) != null) {
            canvas.save();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            canvas.rotate(this.aDo, (width * 0.5f) + getPaddingLeft(), (height * 0.5f) + getPaddingTop());
            canvas.drawBitmap(a(this), this.aDv, this.aDu, (Paint) null);
            canvas.restore();
        } else if (this.aDm || (this.mGifInfo != null && this.mGifInfo.mLoadFailed)) {
            canvas.save();
            this.aDn.draw(canvas);
            canvas.restore();
        } else if (this.aDr) {
            canvas.save();
            this.aDs.draw(canvas);
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
            DX();
        }
    }

    public void d(boolean z, int i) {
        this.aDr = z;
        if (z) {
            this.mIsLoading = false;
            this.aDm = false;
            if (this.aDs == null || this.aDt != i) {
                this.aDt = i;
                this.aDs = as.getDrawable(i);
                int intrinsicWidth = this.aDs.getIntrinsicWidth();
                int intrinsicHeight = this.aDs.getIntrinsicHeight();
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
                this.aDs.setBounds(paddingLeft, paddingTop, intrinsicWidth + paddingLeft, intrinsicHeight + paddingTop);
            }
        }
        invalidate();
    }

    public void stopLoading() {
        this.mIsLoading = false;
        removeCallbacks(this);
        invalidate();
    }

    private void DX() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aDo += this.aDq;
        if (this.aDo > 360.0f - this.aDq) {
            this.aDo = 0.0f;
        }
        invalidate();
        DX();
    }

    public void setPlayCallback(a aVar) {
        this.aDi = aVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.aDs != null && this.aDs.isStateful()) {
            this.aDs.setState(getDrawableState());
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
        boolean GH = com.baidu.tbadk.util.i.GH();
        j X = k.X(getContext());
        if (X != null) {
            bdUniqueId = X.getUniqueId();
            z = X.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        if (!(gifInfo == this.mGifInfo && this.mPageId == bdUniqueId)) {
            DY();
        }
        this.mGifInfo = gifInfo;
        this.mPageId = bdUniqueId;
        String str = GH ? this.mGifInfo.mDynamicUrl : this.mGifInfo.mStaticUrl;
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.fL().a(this.mGifInfo.mSharpText, 20, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(GH), str);
        if (aVar != null) {
            stopLoading();
            setGif(aVar);
        } else if (this.mGifInfo.mLoadFailed) {
            setGif(null);
        } else if (!com.baidu.adp.lib.f.c.fL().al(20) && this.aDB) {
            d(true, this.aDg);
        } else if (!z) {
            com.baidu.adp.lib.f.c.fL().a(this.mGifInfo.mSharpText, 20, this.aDC);
            startLoading();
            com.baidu.adp.lib.f.c.fL().a(this.mGifInfo.mSharpText, 20, this.aDC, 0, 0, this.mPageId, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(GH), str);
        }
    }

    public void DY() {
        stopLoading();
        this.aDm = false;
        this.aDr = false;
        if (this.mGifInfo != null) {
            com.baidu.adp.lib.f.c.fL().a(this.mGifInfo.mSharpText, 20, this.aDC);
        }
    }

    @Override // com.baidu.adp.b.a.i
    public void refresh() {
        a(this.mGifInfo);
    }

    public void setSupportNoImage(boolean z) {
        this.aDB = z;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(this);
        this.mOnClickListener = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mGifInfo != null) {
            boolean GH = com.baidu.tbadk.util.i.GH();
            String str = GH ? this.mGifInfo.mDynamicUrl : this.mGifInfo.mStaticUrl;
            com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.fL().a(this.mGifInfo.mSharpText, 20, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(GH), str);
            if (aVar != null) {
                this.mGifInfo.mLoadFailed = false;
                setGif(aVar);
            } else {
                startLoading();
                com.baidu.adp.lib.f.c.fL().a(this.mGifInfo.mSharpText, 20, this.aDC, 0, 0, this.mPageId, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(GH), str);
                return;
            }
        }
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    public void setIsKeepLastFrame(boolean z) {
        this.aDx = z;
    }

    public static Bitmap a(GifView gifView) {
        if (aDp != null && !aDp.isRecycled()) {
            return aDp;
        }
        BitmapDrawable bitmapDrawable = (BitmapDrawable) gifView.getResources().getDrawable(w.g.loading);
        if (bitmapDrawable != null) {
            aDp = bitmapDrawable.getBitmap();
        }
        return aDp;
    }

    public com.baidu.adp.gif.b getGif() {
        if (this.GX == null) {
            onStop();
            return null;
        }
        return this.GX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStop() {
        if (this.aDi != null && !this.aDz) {
            this.aDi.onStop();
            this.aDz = true;
        }
    }

    public void setShowStaticDrawable(boolean z) {
        this.aDk = z;
    }
}
