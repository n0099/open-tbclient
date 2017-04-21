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
    public static Bitmap aCz;
    private com.baidu.adp.gif.b GY;
    private float aCA;
    private boolean aCB;
    private Drawable aCC;
    private int aCD;
    private final Rect aCE;
    private final Rect aCF;
    private boolean aCG;
    private boolean aCH;
    private boolean aCI;
    private boolean aCJ;
    private boolean aCK;
    private boolean aCL;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> aCM;
    private final int aCr;
    private int aCs;
    private a aCt;
    private boolean aCu;
    private BitmapDrawable aCv;
    private boolean aCw;
    private Drawable aCx;
    private float aCy;
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
        this.aCr = w.g.pic_expression_upload_selector;
        this.aCu = false;
        this.aCE = new Rect();
        this.aCF = new Rect();
        this.aCG = true;
        this.aCH = false;
        this.aCI = false;
        this.aCJ = false;
        this.mHandler = new com.baidu.tbadk.gif.a(this, Looper.getMainLooper());
        this.mType = 20;
        this.aCL = true;
        this.aCM = new b(this);
        this.aCv = (BitmapDrawable) getResources().getDrawable(w.g.icon_content_animation);
        this.aCv.setBounds(0, 0, this.aCv.getIntrinsicWidth(), this.aCv.getIntrinsicHeight());
        this.aCA = 30.0f;
        if (((BitmapDrawable) getResources().getDrawable(w.g.loading)) != null) {
            aCz = a(this);
            this.aCF.set(0, 0, aCz.getWidth(), aCz.getHeight());
        }
        this.aCx = getResources().getDrawable(w.g.image_group_load_f);
        e(this.aCx);
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
                this.aCE.set(i7, i8, i7 + i6, i6 + i8);
            }
            int intrinsicWidth = this.aCx.getIntrinsicWidth();
            int intrinsicHeight = this.aCx.getIntrinsicHeight();
            if (intrinsicWidth > i5) {
                intrinsicWidth = i5;
            }
            if (intrinsicHeight > paddingBottom) {
                intrinsicHeight = paddingBottom;
            }
            int i9 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
            int i10 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
            this.aCx.setBounds(i9, i10, intrinsicWidth + i9, intrinsicHeight + i10);
            if (this.aCC != null) {
                int intrinsicWidth2 = this.aCC.getIntrinsicWidth();
                int intrinsicHeight2 = this.aCC.getIntrinsicHeight();
                if (intrinsicWidth2 > i5) {
                    intrinsicWidth2 = i5;
                }
                if (intrinsicHeight2 > paddingBottom) {
                    intrinsicHeight2 = paddingBottom;
                }
                int i11 = ((i5 - intrinsicWidth2) / 2) + paddingLeft;
                int i12 = ((paddingBottom - intrinsicHeight2) / 2) + paddingTop;
                this.aCC.setBounds(i11, i12, intrinsicWidth2 + i11, intrinsicHeight2 + i12);
            }
        }
    }

    public void release() {
        if (this.aCI && this.GY != null && this.GY != null) {
            this.GY.close();
            this.GY = null;
        }
    }

    public void setGif(com.baidu.adp.widget.a.a aVar) {
        this.aCw = false;
        this.mIsLoading = false;
        this.aCB = false;
        if (this.mGifInfo != null) {
            this.mGifInfo.mLoadFailed = false;
        }
        if (aVar == null) {
            this.aCw = true;
            this.aCu = false;
            if (this.mGifInfo != null) {
                this.mGifInfo.mLoadFailed = true;
            }
            setImageDrawable(null);
            if (this.GY != null) {
                this.GY.close();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.kQ()) {
                this.aCu = true;
                aVar.e(this);
                this.mIsLoading = false;
            }
            if (this.GY != null) {
                this.GY.close();
            }
        } else if (this.GY == null || !aVar.getGif().equals(this.GY)) {
            this.aCu = false;
            try {
                if (this.mBitmap == null || (this.mBitmap.getWidth() != aVar.getGif().getWidth() && this.mBitmap.getHeight() != aVar.getGif().getHeight())) {
                    this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
                }
                this.GY = aVar.getGif();
                aVar.getGif().T(0);
                aVar.getGif().a(this.mBitmap, null);
                setImageBitmap(this.mBitmap);
                if (this.aCG) {
                    play();
                }
            } catch (Throwable th) {
                onStop();
            }
        } else {
            aVar.getGif().T(this.aCs);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.aCG) {
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
        this.aCI = true;
        setGif(e8);
    }

    public boolean getAutoPlay() {
        return this.aCG;
    }

    public void setAutoPlay(boolean z) {
        this.aCG = z;
    }

    public void resume() {
        this.aCJ = false;
        com.baidu.adp.gif.b gif = getGif();
        if (gif != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, gif.U(this.aCs));
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
        this.aCJ = false;
        com.baidu.adp.gif.b gif = getGif();
        if (gif != null) {
            if (this.aCs != 0) {
                this.aCs = 0;
            }
            gif.T(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, gif.U(this.aCs));
        }
    }

    public void EE() {
        this.aCK = true;
        play();
    }

    public void onDestroy() {
        this.GY = null;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandler.removeMessages(1);
        EG();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.mHandler.removeMessages(1);
        EG();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (!this.aCu) {
            if (i == 4 || i == 8) {
                stop();
            } else if (i == 0) {
                play();
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (!this.mIsLoading && !this.aCw && !this.aCB) {
            super.onDraw(canvas);
        }
        canvas.save();
        try {
            if (this.GY != null && !this.mIsLoading && !this.aCw && !this.aCB) {
                this.GY.a(null, canvas);
            }
        } catch (Throwable th) {
            BdLog.e("setGif:" + th.getMessage());
            onStop();
        }
        canvas.restore();
        if (this.aCu) {
            canvas.save();
            this.aCv.draw(canvas);
            canvas.restore();
        }
        if (this.mIsLoading && a(this) != null) {
            canvas.save();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            canvas.rotate(this.aCy, (width * 0.5f) + getPaddingLeft(), (height * 0.5f) + getPaddingTop());
            canvas.drawBitmap(a(this), this.aCF, this.aCE, (Paint) null);
            canvas.restore();
        } else if (this.aCw || (this.mGifInfo != null && this.mGifInfo.mLoadFailed)) {
            canvas.save();
            this.aCx.draw(canvas);
            canvas.restore();
        } else if (this.aCB) {
            canvas.save();
            this.aCC.draw(canvas);
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
            EF();
        }
    }

    public void d(boolean z, int i) {
        this.aCB = z;
        if (z) {
            this.mIsLoading = false;
            this.aCw = false;
            if (this.aCC == null || this.aCD != i) {
                this.aCD = i;
                this.aCC = aq.getDrawable(i);
                int intrinsicWidth = this.aCC.getIntrinsicWidth();
                int intrinsicHeight = this.aCC.getIntrinsicHeight();
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
                this.aCC.setBounds(paddingLeft, paddingTop, intrinsicWidth + paddingLeft, intrinsicHeight + paddingTop);
            }
        }
        invalidate();
    }

    public void stopLoading() {
        this.mIsLoading = false;
        removeCallbacks(this);
        invalidate();
    }

    private void EF() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aCy += this.aCA;
        if (this.aCy > 360.0f - this.aCA) {
            this.aCy = 0.0f;
        }
        invalidate();
        EF();
    }

    public void setPlayCallback(a aVar) {
        this.aCt = aVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.aCC != null && this.aCC.isStateful()) {
            this.aCC.setState(getDrawableState());
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
        boolean Hk = g.Hk();
        j X = k.X(getContext());
        if (X != null) {
            bdUniqueId = X.getUniqueId();
            z = X.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        if (!(gifInfo == this.mGifInfo && this.mPageId == bdUniqueId)) {
            EG();
        }
        this.mGifInfo = gifInfo;
        this.mPageId = bdUniqueId;
        String str = Hk ? this.mGifInfo.mDynamicUrl : this.mGifInfo.mStaticUrl;
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.fM().a(this.mGifInfo.mSharpText, 20, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(Hk), str);
        if (aVar != null) {
            stopLoading();
            setGif(aVar);
        } else if (this.mGifInfo.mLoadFailed) {
            setGif(null);
        } else if (!com.baidu.adp.lib.f.c.fM().al(20) && this.aCL) {
            d(true, this.aCr);
        } else if (!z) {
            com.baidu.adp.lib.f.c.fM().a(this.mGifInfo.mSharpText, 20, this.aCM);
            startLoading();
            com.baidu.adp.lib.f.c.fM().a(this.mGifInfo.mSharpText, 20, this.aCM, 0, 0, this.mPageId, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(Hk), str);
        }
    }

    public void EG() {
        stopLoading();
        this.aCw = false;
        this.aCB = false;
        if (this.mGifInfo != null) {
            com.baidu.adp.lib.f.c.fM().a(this.mGifInfo.mSharpText, 20, this.aCM);
        }
    }

    @Override // com.baidu.adp.newwidget.a.i
    public void refresh() {
        a(this.mGifInfo);
    }

    public void setSupportNoImage(boolean z) {
        this.aCL = z;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(this);
        this.mOnClickListener = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mGifInfo != null) {
            boolean Hk = g.Hk();
            String str = Hk ? this.mGifInfo.mDynamicUrl : this.mGifInfo.mStaticUrl;
            com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.fM().a(this.mGifInfo.mSharpText, 20, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(Hk), str);
            if (aVar != null) {
                this.mGifInfo.mLoadFailed = false;
                setGif(aVar);
            } else {
                startLoading();
                com.baidu.adp.lib.f.c.fM().a(this.mGifInfo.mSharpText, 20, this.aCM, 0, 0, this.mPageId, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(Hk), str);
                return;
            }
        }
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    public void setIsKeepLastFrame(boolean z) {
        this.aCH = z;
    }

    public static Bitmap a(GifView gifView) {
        if (aCz != null && !aCz.isRecycled()) {
            return aCz;
        }
        BitmapDrawable bitmapDrawable = (BitmapDrawable) gifView.getResources().getDrawable(w.g.loading);
        if (bitmapDrawable != null) {
            aCz = bitmapDrawable.getBitmap();
        }
        return aCz;
    }

    public com.baidu.adp.gif.b getGif() {
        if (this.GY == null) {
            onStop();
            return null;
        }
        return this.GY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStop() {
        if (this.aCt != null && !this.aCJ) {
            this.aCt.onStop();
            this.aCJ = true;
        }
    }
}
