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
    public static Bitmap aFF;
    private b Iy;
    private boolean aFA;
    private BitmapDrawable aFB;
    private boolean aFC;
    private Drawable aFD;
    private float aFE;
    private float aFG;
    private boolean aFH;
    private Drawable aFI;
    private int aFJ;
    private final Rect aFK;
    private final Rect aFL;
    private boolean aFM;
    private boolean aFN;
    private boolean aFO;
    private boolean aFP;
    private boolean aFQ;
    private boolean aFR;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> aFS;
    private final int aFw;
    private int aFx;
    private a aFy;
    private boolean aFz;
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
        this.aFw = d.g.pic_expression_upload_selector;
        this.aFz = false;
        this.aFA = true;
        this.aFK = new Rect();
        this.aFL = new Rect();
        this.aFM = true;
        this.aFN = false;
        this.aFO = false;
        this.aFP = false;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.gif.GifView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                boolean z;
                b gif = GifView.this.getGif();
                if (gif != null && message.what == 1) {
                    GifView.this.aFx++;
                    if (GifView.this.aFx >= gif.dO()) {
                        if (GifView.this.aFQ) {
                            if (!GifView.this.aFN) {
                                GifView.this.setVisibility(4);
                            }
                            GifView.this.aFQ = false;
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!GifView.this.aFN) {
                            GifView.this.aFx = 0;
                        } else {
                            GifView.this.aFx = gif.dO() - 1;
                        }
                    } else {
                        z = false;
                    }
                    gif.W(GifView.this.aFx);
                    gif.a(GifView.this.mBitmap, null);
                    GifView.this.invalidate();
                    removeMessages(1);
                    if (z) {
                        GifView.this.onStop();
                    } else {
                        sendEmptyMessageDelayed(1, gif.X(GifView.this.aFx));
                    }
                }
            }
        };
        this.mType = 20;
        this.aFR = true;
        this.aFS = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.gif.GifView.2
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
        this.aFB = (BitmapDrawable) getResources().getDrawable(d.g.icon_content_animation);
        this.aFB.setBounds(0, 0, this.aFB.getIntrinsicWidth(), this.aFB.getIntrinsicHeight());
        this.aFG = 30.0f;
        if (((BitmapDrawable) getResources().getDrawable(d.g.loading)) != null) {
            aFF = a(this);
            this.aFL.set(0, 0, aFF.getWidth(), aFF.getHeight());
        }
        this.aFD = getResources().getDrawable(d.g.image_group_load_f);
        e(this.aFD);
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
                this.aFK.set(i7, i8, i7 + i6, i6 + i8);
            }
            int intrinsicWidth = this.aFD.getIntrinsicWidth();
            int intrinsicHeight = this.aFD.getIntrinsicHeight();
            if (intrinsicWidth > i5) {
                intrinsicWidth = i5;
            }
            if (intrinsicHeight > paddingBottom) {
                intrinsicHeight = paddingBottom;
            }
            int i9 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
            int i10 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
            this.aFD.setBounds(i9, i10, intrinsicWidth + i9, intrinsicHeight + i10);
            if (this.aFI != null) {
                int intrinsicWidth2 = this.aFI.getIntrinsicWidth();
                int intrinsicHeight2 = this.aFI.getIntrinsicHeight();
                if (intrinsicWidth2 > i5) {
                    intrinsicWidth2 = i5;
                }
                if (intrinsicHeight2 > paddingBottom) {
                    intrinsicHeight2 = paddingBottom;
                }
                int i11 = ((i5 - intrinsicWidth2) / 2) + paddingLeft;
                int i12 = ((paddingBottom - intrinsicHeight2) / 2) + paddingTop;
                this.aFI.setBounds(i11, i12, intrinsicWidth2 + i11, intrinsicHeight2 + i12);
            }
        }
    }

    public void release() {
        if (this.aFO && this.Iy != null && this.Iy != null) {
            this.Iy.close();
            this.Iy = null;
        }
    }

    public void setGif(com.baidu.adp.widget.a.a aVar) {
        this.aFC = false;
        this.mIsLoading = false;
        this.aFH = false;
        if (this.mGifInfo != null) {
            this.mGifInfo.mLoadFailed = false;
        }
        if (aVar == null) {
            this.aFC = true;
            this.aFz = false;
            if (this.mGifInfo != null) {
                this.mGifInfo.mLoadFailed = true;
            }
            setImageDrawable(null);
            if (this.Iy != null) {
                this.Iy.close();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.kV()) {
                this.aFz = true;
                aVar.e(this);
                this.mIsLoading = false;
            }
            if (this.Iy != null) {
                this.Iy.close();
            }
        } else if (this.Iy == null || !aVar.getGif().equals(this.Iy)) {
            this.aFz = false;
            try {
                if (this.mBitmap == null || (this.mBitmap.getWidth() != aVar.getGif().getWidth() && this.mBitmap.getHeight() != aVar.getGif().getHeight())) {
                    this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
                }
                this.Iy = aVar.getGif();
                aVar.getGif().W(0);
                aVar.getGif().a(this.mBitmap, null);
                setImageBitmap(this.mBitmap);
                if (this.aFM) {
                    play();
                }
            } catch (Throwable th) {
                onStop();
            }
        } else {
            aVar.getGif().W(this.aFx);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.aFM) {
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
        this.aFO = true;
        setGif(g);
    }

    public boolean getAutoPlay() {
        return this.aFM;
    }

    public void setAutoPlay(boolean z) {
        this.aFM = z;
    }

    public void pause() {
        this.mHandler.removeMessages(1);
    }

    public void resume() {
        this.aFP = false;
        b gif = getGif();
        if (gif != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, gif.X(this.aFx));
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
        this.aFP = false;
        b gif = getGif();
        if (gif != null) {
            if (this.aFx != 0) {
                this.aFx = 0;
            }
            gif.W(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, gif.X(this.aFx));
        }
    }

    public void Eq() {
        this.aFQ = true;
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
        if (!this.aFz) {
            if (i == 4 || i == 8) {
                stop();
            } else if (i == 0) {
                play();
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (!this.mIsLoading && !this.aFC && !this.aFH) {
            super.onDraw(canvas);
        }
        canvas.save();
        try {
            if (this.Iy != null && !this.mIsLoading && !this.aFC && !this.aFH) {
                this.Iy.a(null, canvas);
            }
        } catch (Throwable th) {
            BdLog.e("setGif:" + th.getMessage());
            onStop();
        }
        canvas.restore();
        if (this.aFz && this.aFA) {
            canvas.save();
            this.aFB.draw(canvas);
            canvas.restore();
        }
        if (this.mIsLoading && a(this) != null) {
            canvas.save();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            canvas.rotate(this.aFE, (width * 0.5f) + getPaddingLeft(), (height * 0.5f) + getPaddingTop());
            canvas.drawBitmap(a(this), this.aFL, this.aFK, (Paint) null);
            canvas.restore();
        } else if (this.aFC || (this.mGifInfo != null && this.mGifInfo.mLoadFailed)) {
            canvas.save();
            this.aFD.draw(canvas);
            canvas.restore();
        } else if (this.aFH) {
            canvas.save();
            this.aFI.draw(canvas);
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
        this.aFH = z;
        if (z) {
            this.mIsLoading = false;
            this.aFC = false;
            if (this.aFI == null || this.aFJ != i) {
                this.aFJ = i;
                this.aFI = ai.getDrawable(i);
                int intrinsicWidth = this.aFI.getIntrinsicWidth();
                int intrinsicHeight = this.aFI.getIntrinsicHeight();
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
                this.aFI.setBounds(paddingLeft, paddingTop, intrinsicWidth + paddingLeft, intrinsicHeight + paddingTop);
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
        this.aFE += this.aFG;
        if (this.aFE > 360.0f - this.aFG) {
            this.aFE = 0.0f;
        }
        invalidate();
        Er();
    }

    public void setPlayCallback(a aVar) {
        this.aFy = aVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.aFI != null && this.aFI.isStateful()) {
            this.aFI.setState(getDrawableState());
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
        } else if (!c.fU().ao(20) && this.aFR) {
            d(true, this.aFw);
        } else if (!z) {
            c.fU().a(this.mGifInfo.mSharpText, 20, this.aFS);
            startLoading();
            c.fU().a(this.mGifInfo.mSharpText, 20, this.aFS, 0, 0, this.mPageId, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(He), str);
        }
    }

    public void Es() {
        stopLoading();
        this.aFC = false;
        this.aFH = false;
        if (this.mGifInfo != null) {
            c.fU().a(this.mGifInfo.mSharpText, 20, this.aFS);
        }
    }

    @Override // com.baidu.adp.b.a.i
    public void refresh() {
        a(this.mGifInfo);
    }

    public void setSupportNoImage(boolean z) {
        this.aFR = z;
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
                c.fU().a(this.mGifInfo.mSharpText, 20, this.aFS, 0, 0, this.mPageId, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(He), str);
                return;
            }
        }
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    public void setIsKeepLastFrame(boolean z) {
        this.aFN = z;
    }

    public static Bitmap a(GifView gifView) {
        if (aFF != null && !aFF.isRecycled()) {
            return aFF;
        }
        BitmapDrawable bitmapDrawable = (BitmapDrawable) gifView.getResources().getDrawable(d.g.loading);
        if (bitmapDrawable != null) {
            aFF = bitmapDrawable.getBitmap();
        }
        return aFF;
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
        if (this.aFy != null && !this.aFP) {
            this.aFy.onStop();
            this.aFP = true;
        }
    }

    public void setShowStaticDrawable(boolean z) {
        this.aFA = z;
    }
}
