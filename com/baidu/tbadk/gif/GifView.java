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
import com.baidu.adp.gif.a;
import com.baidu.adp.gif.b;
import com.baidu.adp.lib.f.c;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public class GifView extends ImageView implements View.OnClickListener, i, Runnable {
    public static Bitmap aFG;
    private b Iy;
    private boolean aFA;
    private boolean aFB;
    private BitmapDrawable aFC;
    private boolean aFD;
    private Drawable aFE;
    private float aFF;
    private float aFH;
    private boolean aFI;
    private Drawable aFJ;
    private int aFK;
    private final Rect aFL;
    private final Rect aFM;
    private boolean aFN;
    private boolean aFO;
    private boolean aFP;
    private boolean aFQ;
    private boolean aFR;
    private boolean aFS;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> aFT;
    private final int aFx;
    private int aFy;
    private a aFz;
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
        this.aFx = d.g.pic_expression_upload_selector;
        this.aFA = false;
        this.aFB = true;
        this.aFL = new Rect();
        this.aFM = new Rect();
        this.aFN = true;
        this.aFO = false;
        this.aFP = false;
        this.aFQ = false;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.gif.GifView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                boolean z;
                b gif = GifView.this.getGif();
                if (gif != null && message.what == 1) {
                    GifView.this.aFy++;
                    if (GifView.this.aFy >= gif.dO()) {
                        if (GifView.this.aFR) {
                            if (!GifView.this.aFO) {
                                GifView.this.setVisibility(4);
                            }
                            GifView.this.aFR = false;
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!GifView.this.aFO) {
                            GifView.this.aFy = 0;
                        } else {
                            GifView.this.aFy = gif.dO() - 1;
                        }
                    } else {
                        z = false;
                    }
                    gif.W(GifView.this.aFy);
                    gif.a(GifView.this.mBitmap, null);
                    GifView.this.invalidate();
                    removeMessages(1);
                    if (z) {
                        GifView.this.onStop();
                    } else {
                        sendEmptyMessageDelayed(1, gif.X(GifView.this.aFy));
                    }
                }
            }
        };
        this.mType = 20;
        this.aFS = true;
        this.aFT = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.gif.GifView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i2) {
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
        this.aFC = (BitmapDrawable) getResources().getDrawable(d.g.icon_content_animation);
        this.aFC.setBounds(0, 0, this.aFC.getIntrinsicWidth(), this.aFC.getIntrinsicHeight());
        this.aFH = 30.0f;
        if (((BitmapDrawable) getResources().getDrawable(d.g.loading)) != null) {
            aFG = a(this);
            this.aFM.set(0, 0, aFG.getWidth(), aFG.getHeight());
        }
        this.aFE = getResources().getDrawable(d.g.image_group_load_f);
        e(this.aFE);
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
                this.aFL.set(i7, i8, i7 + i6, i6 + i8);
            }
            int intrinsicWidth = this.aFE.getIntrinsicWidth();
            int intrinsicHeight = this.aFE.getIntrinsicHeight();
            if (intrinsicWidth > i5) {
                intrinsicWidth = i5;
            }
            if (intrinsicHeight > paddingBottom) {
                intrinsicHeight = paddingBottom;
            }
            int i9 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
            int i10 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
            this.aFE.setBounds(i9, i10, intrinsicWidth + i9, intrinsicHeight + i10);
            if (this.aFJ != null) {
                int intrinsicWidth2 = this.aFJ.getIntrinsicWidth();
                int intrinsicHeight2 = this.aFJ.getIntrinsicHeight();
                if (intrinsicWidth2 > i5) {
                    intrinsicWidth2 = i5;
                }
                if (intrinsicHeight2 > paddingBottom) {
                    intrinsicHeight2 = paddingBottom;
                }
                int i11 = ((i5 - intrinsicWidth2) / 2) + paddingLeft;
                int i12 = ((paddingBottom - intrinsicHeight2) / 2) + paddingTop;
                this.aFJ.setBounds(i11, i12, intrinsicWidth2 + i11, intrinsicHeight2 + i12);
            }
        }
    }

    public void release() {
        if (this.aFP && this.Iy != null && this.Iy != null) {
            this.Iy.close();
            this.Iy = null;
        }
    }

    public void setGif(com.baidu.adp.widget.a.a aVar) {
        this.aFD = false;
        this.mIsLoading = false;
        this.aFI = false;
        if (this.mGifInfo != null) {
            this.mGifInfo.mLoadFailed = false;
        }
        if (aVar == null) {
            this.aFD = true;
            this.aFA = false;
            if (this.mGifInfo != null) {
                this.mGifInfo.mLoadFailed = true;
            }
            setImageDrawable(null);
            if (this.Iy != null) {
                this.Iy.close();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.kU()) {
                this.aFA = true;
                aVar.e(this);
                this.mIsLoading = false;
            }
            if (this.Iy != null) {
                this.Iy.close();
            }
        } else if (this.Iy == null || !aVar.getGif().equals(this.Iy)) {
            this.aFA = false;
            try {
                if (this.mBitmap == null || (this.mBitmap.getWidth() != aVar.getGif().getWidth() && this.mBitmap.getHeight() != aVar.getGif().getHeight())) {
                    this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
                }
                this.Iy = aVar.getGif();
                aVar.getGif().W(0);
                aVar.getGif().a(this.mBitmap, null);
                setImageBitmap(this.mBitmap);
                if (this.aFN) {
                    play();
                }
            } catch (Throwable th) {
                onStop();
            }
        } else {
            aVar.getGif().W(this.aFy);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.aFN) {
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
        com.baidu.adp.widget.a.a g = a.C0002a.dN().g(bArr, 0, i2);
        this.aFP = true;
        setGif(g);
    }

    public boolean getAutoPlay() {
        return this.aFN;
    }

    public void setAutoPlay(boolean z) {
        this.aFN = z;
    }

    public void pause() {
        this.mHandler.removeMessages(1);
    }

    public void resume() {
        this.aFQ = false;
        b gif = getGif();
        if (gif != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, gif.X(this.aFy));
        }
    }

    public void stop() {
        b gif = getGif();
        if (gif != null) {
            this.mHandler.removeMessages(1);
            gif.W(0);
            gif.a(this.mBitmap, null);
            invalidate();
            onStop();
        }
    }

    public void play() {
        this.aFQ = false;
        b gif = getGif();
        if (gif != null) {
            if (this.aFy != 0) {
                this.aFy = 0;
            }
            gif.W(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, gif.X(this.aFy));
        }
    }

    public void Eq() {
        this.aFR = true;
        play();
    }

    public void onDestroy() {
        this.Iy = null;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandler.removeMessages(1);
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
        if (!this.aFA) {
            if (i == 4 || i == 8) {
                stop();
            } else if (i == 0) {
                play();
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (!this.mIsLoading && !this.aFD && !this.aFI) {
            super.onDraw(canvas);
        }
        canvas.save();
        try {
            if (this.Iy != null && !this.mIsLoading && !this.aFD && !this.aFI) {
                this.Iy.a(null, canvas);
            }
        } catch (Throwable th) {
            BdLog.e("setGif:" + th.getMessage());
            onStop();
        }
        canvas.restore();
        if (this.aFA && this.aFB) {
            canvas.save();
            this.aFC.draw(canvas);
            canvas.restore();
        }
        if (this.mIsLoading && a(this) != null) {
            canvas.save();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            canvas.rotate(this.aFF, (width * 0.5f) + getPaddingLeft(), (height * 0.5f) + getPaddingTop());
            canvas.drawBitmap(a(this), this.aFM, this.aFL, (Paint) null);
            canvas.restore();
        } else if (this.aFD || (this.mGifInfo != null && this.mGifInfo.mLoadFailed)) {
            canvas.save();
            this.aFE.draw(canvas);
            canvas.restore();
        } else if (this.aFI) {
            canvas.save();
            this.aFJ.draw(canvas);
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

    public void d(boolean z, int i) {
        this.aFI = z;
        if (z) {
            this.mIsLoading = false;
            this.aFD = false;
            if (this.aFJ == null || this.aFK != i) {
                this.aFK = i;
                this.aFJ = ai.getDrawable(i);
                int intrinsicWidth = this.aFJ.getIntrinsicWidth();
                int intrinsicHeight = this.aFJ.getIntrinsicHeight();
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
                this.aFJ.setBounds(paddingLeft, paddingTop, intrinsicWidth + paddingLeft, intrinsicHeight + paddingTop);
            }
        }
        invalidate();
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
        this.aFF += this.aFH;
        if (this.aFF > 360.0f - this.aFH) {
            this.aFF = 0.0f;
        }
        invalidate();
        Er();
    }

    public void setPlayCallback(a aVar) {
        this.aFz = aVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.aFJ != null && this.aFJ.isStateful()) {
            this.aFJ.setState(getDrawableState());
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
        boolean He = com.baidu.tbadk.util.i.He();
        h Y = com.baidu.adp.base.i.Y(getContext());
        if (Y != null) {
            bdUniqueId = Y.getUniqueId();
            z = Y.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        if (!(gifInfo == this.mGifInfo && this.mPageId == bdUniqueId)) {
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
        } else if (!c.fU().ao(20) && this.aFS) {
            d(true, this.aFx);
        } else if (!z) {
            c.fU().a(this.mGifInfo.mSharpText, 20, this.aFT);
            startLoading();
            c.fU().a(this.mGifInfo.mSharpText, 20, this.aFT, 0, 0, this.mPageId, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(He), str);
        }
    }

    public void Es() {
        stopLoading();
        this.aFD = false;
        this.aFI = false;
        if (this.mGifInfo != null) {
            c.fU().a(this.mGifInfo.mSharpText, 20, this.aFT);
        }
    }

    @Override // com.baidu.adp.b.a.i
    public void refresh() {
        a(this.mGifInfo);
    }

    public void setSupportNoImage(boolean z) {
        this.aFS = z;
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
                c.fU().a(this.mGifInfo.mSharpText, 20, this.aFT, 0, 0, this.mPageId, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(He), str);
                return;
            }
        }
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    public void setIsKeepLastFrame(boolean z) {
        this.aFO = z;
    }

    public static Bitmap a(GifView gifView) {
        if (aFG != null && !aFG.isRecycled()) {
            return aFG;
        }
        BitmapDrawable bitmapDrawable = (BitmapDrawable) gifView.getResources().getDrawable(d.g.loading);
        if (bitmapDrawable != null) {
            aFG = bitmapDrawable.getBitmap();
        }
        return aFG;
    }

    public b getGif() {
        if (this.Iy == null) {
            onStop();
            return null;
        }
        return this.Iy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStop() {
        if (this.aFz != null && !this.aFQ) {
            this.aFz.onStop();
            this.aFQ = true;
        }
    }

    public void setShowStaticDrawable(boolean z) {
        this.aFB = z;
    }
}
