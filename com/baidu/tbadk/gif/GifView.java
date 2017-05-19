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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.util.h;
import com.baidu.tieba.w;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public class GifView extends ImageView implements View.OnClickListener, i, Runnable {
    public static Bitmap aCy;
    private com.baidu.adp.gif.b GY;
    private boolean aCA;
    private Drawable aCB;
    private int aCC;
    private final Rect aCD;
    private final Rect aCE;
    private boolean aCF;
    private boolean aCG;
    private boolean aCH;
    private boolean aCI;
    private boolean aCJ;
    private boolean aCK;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> aCL;
    private final int aCq;
    private int aCr;
    private a aCs;
    private boolean aCt;
    private BitmapDrawable aCu;
    private boolean aCv;
    private Drawable aCw;
    private float aCx;
    private float aCz;
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
        this.aCq = w.g.pic_expression_upload_selector;
        this.aCt = false;
        this.aCD = new Rect();
        this.aCE = new Rect();
        this.aCF = true;
        this.aCG = false;
        this.aCH = false;
        this.aCI = false;
        this.mHandler = new com.baidu.tbadk.gif.a(this, Looper.getMainLooper());
        this.mType = 20;
        this.aCK = true;
        this.aCL = new b(this);
        this.aCu = (BitmapDrawable) getResources().getDrawable(w.g.icon_content_animation);
        this.aCu.setBounds(0, 0, this.aCu.getIntrinsicWidth(), this.aCu.getIntrinsicHeight());
        this.aCz = 30.0f;
        if (((BitmapDrawable) getResources().getDrawable(w.g.loading)) != null) {
            aCy = a(this);
            this.aCE.set(0, 0, aCy.getWidth(), aCy.getHeight());
        }
        this.aCw = getResources().getDrawable(w.g.image_group_load_f);
        e(this.aCw);
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
                this.aCD.set(i7, i8, i7 + i6, i6 + i8);
            }
            int intrinsicWidth = this.aCw.getIntrinsicWidth();
            int intrinsicHeight = this.aCw.getIntrinsicHeight();
            if (intrinsicWidth > i5) {
                intrinsicWidth = i5;
            }
            if (intrinsicHeight > paddingBottom) {
                intrinsicHeight = paddingBottom;
            }
            int i9 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
            int i10 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
            this.aCw.setBounds(i9, i10, intrinsicWidth + i9, intrinsicHeight + i10);
            if (this.aCB != null) {
                int intrinsicWidth2 = this.aCB.getIntrinsicWidth();
                int intrinsicHeight2 = this.aCB.getIntrinsicHeight();
                if (intrinsicWidth2 > i5) {
                    intrinsicWidth2 = i5;
                }
                if (intrinsicHeight2 > paddingBottom) {
                    intrinsicHeight2 = paddingBottom;
                }
                int i11 = ((i5 - intrinsicWidth2) / 2) + paddingLeft;
                int i12 = ((paddingBottom - intrinsicHeight2) / 2) + paddingTop;
                this.aCB.setBounds(i11, i12, intrinsicWidth2 + i11, intrinsicHeight2 + i12);
            }
        }
    }

    public void release() {
        if (this.aCH && this.GY != null && this.GY != null) {
            this.GY.close();
            this.GY = null;
        }
    }

    public void setGif(com.baidu.adp.widget.a.a aVar) {
        this.aCv = false;
        this.mIsLoading = false;
        this.aCA = false;
        if (this.mGifInfo != null) {
            this.mGifInfo.mLoadFailed = false;
        }
        if (aVar == null) {
            this.aCv = true;
            this.aCt = false;
            if (this.mGifInfo != null) {
                this.mGifInfo.mLoadFailed = true;
            }
            setImageDrawable(null);
            if (this.GY != null) {
                this.GY.close();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.kP()) {
                this.aCt = true;
                aVar.e(this);
                this.mIsLoading = false;
            }
            if (this.GY != null) {
                this.GY.close();
            }
        } else if (this.GY == null || !aVar.getGif().equals(this.GY)) {
            this.aCt = false;
            try {
                if (this.mBitmap == null || (this.mBitmap.getWidth() != aVar.getGif().getWidth() && this.mBitmap.getHeight() != aVar.getGif().getHeight())) {
                    this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
                }
                this.GY = aVar.getGif();
                aVar.getGif().T(0);
                aVar.getGif().a(this.mBitmap, null);
                setImageBitmap(this.mBitmap);
                if (this.aCF) {
                    play();
                }
            } catch (Throwable th) {
                onStop();
            }
        } else {
            aVar.getGif().T(this.aCr);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.aCF) {
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
        this.aCH = true;
        setGif(e8);
    }

    public boolean getAutoPlay() {
        return this.aCF;
    }

    public void setAutoPlay(boolean z) {
        this.aCF = z;
    }

    public void resume() {
        this.aCI = false;
        com.baidu.adp.gif.b gif = getGif();
        if (gif != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, gif.U(this.aCr));
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
        this.aCI = false;
        com.baidu.adp.gif.b gif = getGif();
        if (gif != null) {
            if (this.aCr != 0) {
                this.aCr = 0;
            }
            gif.T(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, gif.U(this.aCr));
        }
    }

    public void DI() {
        this.aCJ = true;
        play();
    }

    public void onDestroy() {
        this.GY = null;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandler.removeMessages(1);
        DK();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.mHandler.removeMessages(1);
        DK();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (!this.aCt) {
            if (i == 4 || i == 8) {
                stop();
            } else if (i == 0) {
                play();
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (!this.mIsLoading && !this.aCv && !this.aCA) {
            super.onDraw(canvas);
        }
        canvas.save();
        try {
            if (this.GY != null && !this.mIsLoading && !this.aCv && !this.aCA) {
                this.GY.a(null, canvas);
            }
        } catch (Throwable th) {
            BdLog.e("setGif:" + th.getMessage());
            onStop();
        }
        canvas.restore();
        if (this.aCt) {
            canvas.save();
            this.aCu.draw(canvas);
            canvas.restore();
        }
        if (this.mIsLoading && a(this) != null) {
            canvas.save();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            canvas.rotate(this.aCx, (width * 0.5f) + getPaddingLeft(), (height * 0.5f) + getPaddingTop());
            canvas.drawBitmap(a(this), this.aCE, this.aCD, (Paint) null);
            canvas.restore();
        } else if (this.aCv || (this.mGifInfo != null && this.mGifInfo.mLoadFailed)) {
            canvas.save();
            this.aCw.draw(canvas);
            canvas.restore();
        } else if (this.aCA) {
            canvas.save();
            this.aCB.draw(canvas);
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
            DJ();
        }
    }

    public void d(boolean z, int i) {
        this.aCA = z;
        if (z) {
            this.mIsLoading = false;
            this.aCv = false;
            if (this.aCB == null || this.aCC != i) {
                this.aCC = i;
                this.aCB = aq.getDrawable(i);
                int intrinsicWidth = this.aCB.getIntrinsicWidth();
                int intrinsicHeight = this.aCB.getIntrinsicHeight();
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
                this.aCB.setBounds(paddingLeft, paddingTop, intrinsicWidth + paddingLeft, intrinsicHeight + paddingTop);
            }
        }
        invalidate();
    }

    public void stopLoading() {
        this.mIsLoading = false;
        removeCallbacks(this);
        invalidate();
    }

    private void DJ() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aCx += this.aCz;
        if (this.aCx > 360.0f - this.aCz) {
            this.aCx = 0.0f;
        }
        invalidate();
        DJ();
    }

    public void setPlayCallback(a aVar) {
        this.aCs = aVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.aCB != null && this.aCB.isStateful()) {
            this.aCB.setState(getDrawableState());
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
        boolean Gq = h.Gq();
        j X = k.X(getContext());
        if (X != null) {
            bdUniqueId = X.getUniqueId();
            z = X.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        if (!(gifInfo == this.mGifInfo && this.mPageId == bdUniqueId)) {
            DK();
        }
        this.mGifInfo = gifInfo;
        this.mPageId = bdUniqueId;
        String str = Gq ? this.mGifInfo.mDynamicUrl : this.mGifInfo.mStaticUrl;
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.fM().a(this.mGifInfo.mSharpText, 20, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(Gq), str);
        if (aVar != null) {
            stopLoading();
            setGif(aVar);
        } else if (this.mGifInfo.mLoadFailed) {
            setGif(null);
        } else if (!com.baidu.adp.lib.f.c.fM().ak(20) && this.aCK) {
            d(true, this.aCq);
        } else if (!z) {
            com.baidu.adp.lib.f.c.fM().a(this.mGifInfo.mSharpText, 20, this.aCL);
            startLoading();
            com.baidu.adp.lib.f.c.fM().a(this.mGifInfo.mSharpText, 20, this.aCL, 0, 0, this.mPageId, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(Gq), str);
        }
    }

    public void DK() {
        stopLoading();
        this.aCv = false;
        this.aCA = false;
        if (this.mGifInfo != null) {
            com.baidu.adp.lib.f.c.fM().a(this.mGifInfo.mSharpText, 20, this.aCL);
        }
    }

    @Override // com.baidu.adp.b.a.i
    public void refresh() {
        a(this.mGifInfo);
    }

    public void setSupportNoImage(boolean z) {
        this.aCK = z;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(this);
        this.mOnClickListener = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mGifInfo != null) {
            boolean Gq = h.Gq();
            String str = Gq ? this.mGifInfo.mDynamicUrl : this.mGifInfo.mStaticUrl;
            com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.fM().a(this.mGifInfo.mSharpText, 20, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(Gq), str);
            if (aVar != null) {
                this.mGifInfo.mLoadFailed = false;
                setGif(aVar);
            } else {
                startLoading();
                com.baidu.adp.lib.f.c.fM().a(this.mGifInfo.mSharpText, 20, this.aCL, 0, 0, this.mPageId, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(Gq), str);
                return;
            }
        }
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    public void setIsKeepLastFrame(boolean z) {
        this.aCG = z;
    }

    public static Bitmap a(GifView gifView) {
        if (aCy != null && !aCy.isRecycled()) {
            return aCy;
        }
        BitmapDrawable bitmapDrawable = (BitmapDrawable) gifView.getResources().getDrawable(w.g.loading);
        if (bitmapDrawable != null) {
            aCy = bitmapDrawable.getBitmap();
        }
        return aCy;
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
        if (this.aCs != null && !this.aCI) {
            this.aCs.onStop();
            this.aCI = true;
        }
    }
}
