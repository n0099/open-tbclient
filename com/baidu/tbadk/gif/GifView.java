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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public class GifView extends ImageView implements View.OnClickListener, i, Runnable {
    public static Bitmap aEL;
    private b Gf;
    private final int aED;
    private int aEE;
    private a aEF;
    private boolean aEG;
    private boolean aEH;
    private BitmapDrawable aEI;
    private boolean aEJ;
    private Drawable aEK;
    private float aEM;
    private boolean aEN;
    private Drawable aEO;
    private int aEP;
    private final Rect aEQ;
    private final Rect aER;
    private boolean aES;
    private boolean aET;
    private boolean aEU;
    private boolean aEV;
    private com.baidu.adp.widget.a.a aEW;
    private boolean aEX;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> aEY;
    private Bitmap mBitmap;
    private float mCurrentDegrees;
    private GifInfo mGifInfo;
    private final Handler mHandler;
    private boolean mIsLoading;
    private View.OnClickListener mOnClickListener;
    private BdUniqueId mPageId;
    private boolean mSupportNoImage;
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
        this.aED = d.f.pic_expression_upload_selector;
        this.aEG = false;
        this.aEH = true;
        this.aEQ = new Rect();
        this.aER = new Rect();
        this.aES = true;
        this.aET = false;
        this.aEU = false;
        this.aEV = false;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.gif.GifView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                boolean z;
                b gif = GifView.this.getGif();
                if (gif != null && message.what == 1) {
                    GifView.this.aEE++;
                    if (GifView.this.aEE >= gif.getFrameCount()) {
                        if (GifView.this.aEX) {
                            if (!GifView.this.aET) {
                                GifView.this.setVisibility(4);
                            }
                            GifView.this.aEX = false;
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!GifView.this.aET) {
                            GifView.this.aEE = 0;
                        } else {
                            GifView.this.aEE = gif.getFrameCount() - 1;
                        }
                    } else {
                        z = false;
                    }
                    gif.T(GifView.this.aEE);
                    gif.a(GifView.this.mBitmap, null);
                    GifView.this.invalidate();
                    removeMessages(1);
                    if (z) {
                        GifView.this.onStop();
                    } else {
                        sendEmptyMessageDelayed(1, gif.U(GifView.this.aEE));
                    }
                }
            }
        };
        this.mType = 20;
        this.mSupportNoImage = true;
        this.aEY = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.gif.GifView.2
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
        this.aEI = (BitmapDrawable) getResources().getDrawable(d.f.icon_content_animation);
        this.aEI.setBounds(0, 0, this.aEI.getIntrinsicWidth(), this.aEI.getIntrinsicHeight());
        this.aEM = 30.0f;
        if (((BitmapDrawable) getResources().getDrawable(d.f.loading)) != null) {
            aEL = a(this);
            this.aER.set(0, 0, aEL.getWidth(), aEL.getHeight());
        }
        this.aEK = getResources().getDrawable(d.f.image_group_load_f);
        b(this.aEK);
    }

    private void b(Drawable drawable) {
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
                this.aEQ.set(i7, i8, i7 + i6, i6 + i8);
            }
            int intrinsicWidth = this.aEK.getIntrinsicWidth();
            int intrinsicHeight = this.aEK.getIntrinsicHeight();
            if (intrinsicWidth > i5) {
                intrinsicWidth = i5;
            }
            if (intrinsicHeight > paddingBottom) {
                intrinsicHeight = paddingBottom;
            }
            int i9 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
            int i10 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
            this.aEK.setBounds(i9, i10, intrinsicWidth + i9, intrinsicHeight + i10);
            if (this.aEO != null) {
                int intrinsicWidth2 = this.aEO.getIntrinsicWidth();
                int intrinsicHeight2 = this.aEO.getIntrinsicHeight();
                if (intrinsicWidth2 > i5) {
                    intrinsicWidth2 = i5;
                }
                if (intrinsicHeight2 > paddingBottom) {
                    intrinsicHeight2 = paddingBottom;
                }
                int i11 = ((i5 - intrinsicWidth2) / 2) + paddingLeft;
                int i12 = ((paddingBottom - intrinsicHeight2) / 2) + paddingTop;
                this.aEO.setBounds(i11, i12, intrinsicWidth2 + i11, intrinsicHeight2 + i12);
            }
        }
    }

    public void release() {
        if (this.aEU && this.Gf != null && this.Gf != null) {
            this.Gf.close();
            this.Gf = null;
        }
    }

    public void setGif(com.baidu.adp.widget.a.a aVar) {
        this.aEJ = false;
        this.mIsLoading = false;
        this.aEN = false;
        if (this.mGifInfo != null) {
            this.mGifInfo.mLoadFailed = false;
        }
        if (aVar == null) {
            this.aEJ = true;
            this.aEG = false;
            if (this.mGifInfo != null) {
                this.mGifInfo.mLoadFailed = true;
            }
            setImageDrawable(null);
            if (this.Gf != null) {
                this.Gf.close();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.kI()) {
                this.aEG = true;
                aVar.a(this);
                this.mIsLoading = false;
            }
            if (this.Gf != null) {
                this.Gf.close();
            }
        } else if (this.Gf == null || !aVar.getGif().equals(this.Gf)) {
            this.aEG = false;
            try {
                if (this.mBitmap == null || (this.mBitmap.getWidth() != aVar.getGif().getWidth() && this.mBitmap.getHeight() != aVar.getGif().getHeight())) {
                    this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
                }
                this.Gf = aVar.getGif();
                aVar.getGif().T(0);
                aVar.getGif().a(this.mBitmap, null);
                setImageBitmap(this.mBitmap);
                if (this.aES) {
                    play();
                }
            } catch (Throwable th) {
                onStop();
            }
        } else {
            aVar.getGif().T(this.aEE);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.aES) {
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
        com.baidu.adp.widget.a.a g = a.C0002a.dD().g(bArr, 0, i2);
        this.aEU = true;
        setGif(g);
    }

    public boolean getAutoPlay() {
        return this.aES;
    }

    public void setAutoPlay(boolean z) {
        this.aES = z;
    }

    public void pause() {
        this.mHandler.removeMessages(1);
    }

    public void resume() {
        this.aEV = false;
        b gif = getGif();
        if (gif != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, gif.U(this.aEE));
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
        this.aEV = false;
        b gif = getGif();
        if (gif != null) {
            if (this.aEE != 0) {
                this.aEE = 0;
            }
            gif.T(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, gif.U(this.aEE));
        }
    }

    public void Eb() {
        this.aEX = true;
        play();
    }

    public void onDestroy() {
        this.aEW = null;
        if (this.Gf != null) {
            this.Gf.close();
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
        if (!this.aEG) {
            if (i == 4 || i == 8) {
                stop();
            } else if (i == 0) {
                play();
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (!this.mIsLoading && !this.aEJ && !this.aEN) {
            super.onDraw(canvas);
        }
        canvas.save();
        try {
            if (this.Gf != null && !this.mIsLoading && !this.aEJ && !this.aEN) {
                this.Gf.a(null, canvas);
            }
        } catch (Throwable th) {
            BdLog.e("setGif:" + th.getMessage());
            onStop();
        }
        canvas.restore();
        if (this.aEG && this.aEH) {
            canvas.save();
            this.aEI.draw(canvas);
            canvas.restore();
        }
        if (this.mIsLoading && a(this) != null) {
            canvas.save();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            canvas.rotate(this.mCurrentDegrees, (width * 0.5f) + getPaddingLeft(), (height * 0.5f) + getPaddingTop());
            canvas.drawBitmap(a(this), this.aER, this.aEQ, (Paint) null);
            canvas.restore();
        } else if (this.aEJ || (this.mGifInfo != null && this.mGifInfo.mLoadFailed)) {
            canvas.save();
            this.aEK.draw(canvas);
            canvas.restore();
        } else if (this.aEN) {
            canvas.save();
            this.aEO.draw(canvas);
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

    public void e(boolean z, int i) {
        this.aEN = z;
        if (z) {
            this.mIsLoading = false;
            this.aEJ = false;
            if (this.aEO == null || this.aEP != i) {
                this.aEP = i;
                this.aEO = aj.getDrawable(i);
                int intrinsicWidth = this.aEO.getIntrinsicWidth();
                int intrinsicHeight = this.aEO.getIntrinsicHeight();
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
                this.aEO.setBounds(paddingLeft, paddingTop, intrinsicWidth + paddingLeft, intrinsicHeight + paddingTop);
            }
        }
        invalidate();
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
        this.mCurrentDegrees += this.aEM;
        if (this.mCurrentDegrees > 360.0f - this.aEM) {
            this.mCurrentDegrees = 0.0f;
        }
        invalidate();
        nextLoadingFrame();
    }

    public void setPlayCallback(a aVar) {
        this.aEF = aVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.aEO != null && this.aEO.isStateful()) {
            this.aEO.setState(getDrawableState());
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
        boolean GN = com.baidu.tbadk.util.i.GN();
        h W = com.baidu.adp.base.i.W(getContext());
        if (W != null) {
            bdUniqueId = W.getUniqueId();
            z = W.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        if (!(gifInfo == this.mGifInfo && this.mPageId == bdUniqueId)) {
            stopLoad();
        }
        this.mGifInfo = gifInfo;
        this.mPageId = bdUniqueId;
        String str = GN ? this.mGifInfo.mDynamicUrl : this.mGifInfo.mStaticUrl;
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) c.fJ().a(this.mGifInfo.mSharpText, this.mType, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(GN), str);
        if (aVar != null) {
            stopLoading();
            setGif(aVar);
        } else if (this.mGifInfo.mLoadFailed) {
            setGif(null);
        } else if (!c.fJ().ao(this.mType) && this.mSupportNoImage) {
            e(true, this.aED);
        } else if (!z) {
            c.fJ().a(this.mGifInfo.mSharpText, this.mType, this.aEY);
            startLoading();
            c.fJ().a(this.mGifInfo.mSharpText, this.mType, this.aEY, 0, 0, this.mPageId, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(GN), str);
        }
    }

    public void stopLoad() {
        stopLoading();
        this.aEJ = false;
        this.aEN = false;
        if (this.mGifInfo != null) {
            c.fJ().a(this.mGifInfo.mSharpText, this.mType, this.aEY);
        }
    }

    @Override // com.baidu.adp.b.a.i
    public void refresh() {
        a(this.mGifInfo);
    }

    public void setSupportNoImage(boolean z) {
        this.mSupportNoImage = z;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(this);
        this.mOnClickListener = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mGifInfo != null) {
            boolean GN = com.baidu.tbadk.util.i.GN();
            String str = GN ? this.mGifInfo.mDynamicUrl : this.mGifInfo.mStaticUrl;
            com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) c.fJ().a(this.mGifInfo.mSharpText, this.mType, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(GN), str);
            if (aVar != null) {
                this.mGifInfo.mLoadFailed = false;
                setGif(aVar);
            } else {
                startLoading();
                c.fJ().a(this.mGifInfo.mSharpText, this.mType, this.aEY, 0, 0, this.mPageId, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(GN), str);
                return;
            }
        }
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    public void setIsKeepLastFrame(boolean z) {
        this.aET = z;
    }

    public static Bitmap a(GifView gifView) {
        if (aEL != null && !aEL.isRecycled()) {
            return aEL;
        }
        BitmapDrawable bitmapDrawable = (BitmapDrawable) gifView.getResources().getDrawable(d.f.loading);
        if (bitmapDrawable != null) {
            aEL = bitmapDrawable.getBitmap();
        }
        return aEL;
    }

    public b getGif() {
        if (this.Gf == null) {
            onStop();
            return null;
        }
        return this.Gf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStop() {
        if (this.aEF != null && !this.aEV) {
            this.aEF.onStop();
            this.aEV = true;
        }
    }

    public void setShowStaticDrawable(boolean z) {
        this.aEH = z;
    }

    public GifInfo getGifInfo() {
        return this.mGifInfo;
    }

    public void setBgImage(com.baidu.adp.widget.a.a aVar) {
        this.aEW = aVar;
    }

    public com.baidu.adp.widget.a.a getBdImage() {
        return this.aEW;
    }

    public void setType(int i) {
        this.mType = i;
    }
}
