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
    public static Bitmap aEV;
    private b Gs;
    private final int aEM;
    private int aEN;
    private a aEO;
    private boolean aEP;
    private boolean aEQ;
    private BitmapDrawable aER;
    private boolean aES;
    private Drawable aET;
    private float aEU;
    private float aEW;
    private boolean aEX;
    private Drawable aEY;
    private int aEZ;
    private final Rect aFa;
    private final Rect aFb;
    private boolean aFc;
    private boolean aFd;
    private boolean aFe;
    private boolean aFf;
    private boolean aFg;
    private boolean aFh;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> aFi;
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
        this.aEM = d.g.pic_expression_upload_selector;
        this.aEP = false;
        this.aEQ = true;
        this.aFa = new Rect();
        this.aFb = new Rect();
        this.aFc = true;
        this.aFd = false;
        this.aFe = false;
        this.aFf = false;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.gif.GifView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                boolean z;
                b gif = GifView.this.getGif();
                if (gif != null && message.what == 1) {
                    GifView.this.aEN++;
                    if (GifView.this.aEN >= gif.dE()) {
                        if (GifView.this.aFg) {
                            if (!GifView.this.aFd) {
                                GifView.this.setVisibility(4);
                            }
                            GifView.this.aFg = false;
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!GifView.this.aFd) {
                            GifView.this.aEN = 0;
                        } else {
                            GifView.this.aEN = gif.dE() - 1;
                        }
                    } else {
                        z = false;
                    }
                    gif.T(GifView.this.aEN);
                    gif.a(GifView.this.mBitmap, null);
                    GifView.this.invalidate();
                    removeMessages(1);
                    if (z) {
                        GifView.this.onStop();
                    } else {
                        sendEmptyMessageDelayed(1, gif.U(GifView.this.aEN));
                    }
                }
            }
        };
        this.mType = 20;
        this.aFh = true;
        this.aFi = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.gif.GifView.2
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
        this.aER = (BitmapDrawable) getResources().getDrawable(d.g.icon_content_animation);
        this.aER.setBounds(0, 0, this.aER.getIntrinsicWidth(), this.aER.getIntrinsicHeight());
        this.aEW = 30.0f;
        if (((BitmapDrawable) getResources().getDrawable(d.g.loading)) != null) {
            aEV = a(this);
            this.aFb.set(0, 0, aEV.getWidth(), aEV.getHeight());
        }
        this.aET = getResources().getDrawable(d.g.image_group_load_f);
        b(this.aET);
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
                this.aFa.set(i7, i8, i7 + i6, i6 + i8);
            }
            int intrinsicWidth = this.aET.getIntrinsicWidth();
            int intrinsicHeight = this.aET.getIntrinsicHeight();
            if (intrinsicWidth > i5) {
                intrinsicWidth = i5;
            }
            if (intrinsicHeight > paddingBottom) {
                intrinsicHeight = paddingBottom;
            }
            int i9 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
            int i10 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
            this.aET.setBounds(i9, i10, intrinsicWidth + i9, intrinsicHeight + i10);
            if (this.aEY != null) {
                int intrinsicWidth2 = this.aEY.getIntrinsicWidth();
                int intrinsicHeight2 = this.aEY.getIntrinsicHeight();
                if (intrinsicWidth2 > i5) {
                    intrinsicWidth2 = i5;
                }
                if (intrinsicHeight2 > paddingBottom) {
                    intrinsicHeight2 = paddingBottom;
                }
                int i11 = ((i5 - intrinsicWidth2) / 2) + paddingLeft;
                int i12 = ((paddingBottom - intrinsicHeight2) / 2) + paddingTop;
                this.aEY.setBounds(i11, i12, intrinsicWidth2 + i11, intrinsicHeight2 + i12);
            }
        }
    }

    public void release() {
        if (this.aFe && this.Gs != null && this.Gs != null) {
            this.Gs.close();
            this.Gs = null;
        }
    }

    public void setGif(com.baidu.adp.widget.a.a aVar) {
        this.aES = false;
        this.mIsLoading = false;
        this.aEX = false;
        if (this.mGifInfo != null) {
            this.mGifInfo.mLoadFailed = false;
        }
        if (aVar == null) {
            this.aES = true;
            this.aEP = false;
            if (this.mGifInfo != null) {
                this.mGifInfo.mLoadFailed = true;
            }
            setImageDrawable(null);
            if (this.Gs != null) {
                this.Gs.close();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.kM()) {
                this.aEP = true;
                aVar.a(this);
                this.mIsLoading = false;
            }
            if (this.Gs != null) {
                this.Gs.close();
            }
        } else if (this.Gs == null || !aVar.getGif().equals(this.Gs)) {
            this.aEP = false;
            try {
                if (this.mBitmap == null || (this.mBitmap.getWidth() != aVar.getGif().getWidth() && this.mBitmap.getHeight() != aVar.getGif().getHeight())) {
                    this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
                }
                this.Gs = aVar.getGif();
                aVar.getGif().T(0);
                aVar.getGif().a(this.mBitmap, null);
                setImageBitmap(this.mBitmap);
                if (this.aFc) {
                    play();
                }
            } catch (Throwable th) {
                onStop();
            }
        } else {
            aVar.getGif().T(this.aEN);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.aFc) {
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
        com.baidu.adp.widget.a.a g = a.C0002a.dD().g(bArr, 0, i2);
        this.aFe = true;
        setGif(g);
    }

    public boolean getAutoPlay() {
        return this.aFc;
    }

    public void setAutoPlay(boolean z) {
        this.aFc = z;
    }

    public void pause() {
        this.mHandler.removeMessages(1);
    }

    public void resume() {
        this.aFf = false;
        b gif = getGif();
        if (gif != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, gif.U(this.aEN));
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
        this.aFf = false;
        b gif = getGif();
        if (gif != null) {
            if (this.aEN != 0) {
                this.aEN = 0;
            }
            gif.T(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, gif.U(this.aEN));
        }
    }

    public void Eo() {
        this.aFg = true;
        play();
    }

    public void onDestroy() {
        this.Gs = null;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandler.removeMessages(1);
        Eq();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.mHandler.removeMessages(1);
        Eq();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (!this.aEP) {
            if (i == 4 || i == 8) {
                stop();
            } else if (i == 0) {
                play();
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (!this.mIsLoading && !this.aES && !this.aEX) {
            super.onDraw(canvas);
        }
        canvas.save();
        try {
            if (this.Gs != null && !this.mIsLoading && !this.aES && !this.aEX) {
                this.Gs.a(null, canvas);
            }
        } catch (Throwable th) {
            BdLog.e("setGif:" + th.getMessage());
            onStop();
        }
        canvas.restore();
        if (this.aEP && this.aEQ) {
            canvas.save();
            this.aER.draw(canvas);
            canvas.restore();
        }
        if (this.mIsLoading && a(this) != null) {
            canvas.save();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            canvas.rotate(this.aEU, (width * 0.5f) + getPaddingLeft(), (height * 0.5f) + getPaddingTop());
            canvas.drawBitmap(a(this), this.aFb, this.aFa, (Paint) null);
            canvas.restore();
        } else if (this.aES || (this.mGifInfo != null && this.mGifInfo.mLoadFailed)) {
            canvas.save();
            this.aET.draw(canvas);
            canvas.restore();
        } else if (this.aEX) {
            canvas.save();
            this.aEY.draw(canvas);
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
            Ep();
        }
    }

    public void e(boolean z, int i) {
        this.aEX = z;
        if (z) {
            this.mIsLoading = false;
            this.aES = false;
            if (this.aEY == null || this.aEZ != i) {
                this.aEZ = i;
                this.aEY = aj.getDrawable(i);
                int intrinsicWidth = this.aEY.getIntrinsicWidth();
                int intrinsicHeight = this.aEY.getIntrinsicHeight();
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
                this.aEY.setBounds(paddingLeft, paddingTop, intrinsicWidth + paddingLeft, intrinsicHeight + paddingTop);
            }
        }
        invalidate();
    }

    public void stopLoading() {
        this.mIsLoading = false;
        removeCallbacks(this);
        invalidate();
    }

    private void Ep() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aEU += this.aEW;
        if (this.aEU > 360.0f - this.aEW) {
            this.aEU = 0.0f;
        }
        invalidate();
        Ep();
    }

    public void setPlayCallback(a aVar) {
        this.aEO = aVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.aEY != null && this.aEY.isStateful()) {
            this.aEY.setState(getDrawableState());
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
        boolean Hd = com.baidu.tbadk.util.i.Hd();
        h W = com.baidu.adp.base.i.W(getContext());
        if (W != null) {
            bdUniqueId = W.getUniqueId();
            z = W.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        if (!(gifInfo == this.mGifInfo && this.mPageId == bdUniqueId)) {
            Eq();
        }
        this.mGifInfo = gifInfo;
        this.mPageId = bdUniqueId;
        String str = Hd ? this.mGifInfo.mDynamicUrl : this.mGifInfo.mStaticUrl;
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) c.fK().a(this.mGifInfo.mSharpText, 20, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(Hd), str);
        if (aVar != null) {
            stopLoading();
            setGif(aVar);
        } else if (this.mGifInfo.mLoadFailed) {
            setGif(null);
        } else if (!c.fK().al(20) && this.aFh) {
            e(true, this.aEM);
        } else if (!z) {
            c.fK().a(this.mGifInfo.mSharpText, 20, this.aFi);
            startLoading();
            c.fK().a(this.mGifInfo.mSharpText, 20, this.aFi, 0, 0, this.mPageId, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(Hd), str);
        }
    }

    public void Eq() {
        stopLoading();
        this.aES = false;
        this.aEX = false;
        if (this.mGifInfo != null) {
            c.fK().a(this.mGifInfo.mSharpText, 20, this.aFi);
        }
    }

    @Override // com.baidu.adp.b.a.i
    public void refresh() {
        a(this.mGifInfo);
    }

    public void setSupportNoImage(boolean z) {
        this.aFh = z;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(this);
        this.mOnClickListener = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mGifInfo != null) {
            boolean Hd = com.baidu.tbadk.util.i.Hd();
            String str = Hd ? this.mGifInfo.mDynamicUrl : this.mGifInfo.mStaticUrl;
            com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) c.fK().a(this.mGifInfo.mSharpText, 20, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(Hd), str);
            if (aVar != null) {
                this.mGifInfo.mLoadFailed = false;
                setGif(aVar);
            } else {
                startLoading();
                c.fK().a(this.mGifInfo.mSharpText, 20, this.aFi, 0, 0, this.mPageId, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(Hd), str);
                return;
            }
        }
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    public void setIsKeepLastFrame(boolean z) {
        this.aFd = z;
    }

    public static Bitmap a(GifView gifView) {
        if (aEV != null && !aEV.isRecycled()) {
            return aEV;
        }
        BitmapDrawable bitmapDrawable = (BitmapDrawable) gifView.getResources().getDrawable(d.g.loading);
        if (bitmapDrawable != null) {
            aEV = bitmapDrawable.getBitmap();
        }
        return aEV;
    }

    public b getGif() {
        if (this.Gs == null) {
            onStop();
            return null;
        }
        return this.Gs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStop() {
        if (this.aEO != null && !this.aFf) {
            this.aEO.onStop();
            this.aFf = true;
        }
    }

    public void setShowStaticDrawable(boolean z) {
        this.aEQ = z;
    }
}
