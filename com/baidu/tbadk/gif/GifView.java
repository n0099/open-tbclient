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
    public static Bitmap aEb;
    private b Gu;
    private final int aDS;
    private int aDT;
    private a aDU;
    private boolean aDV;
    private boolean aDW;
    private BitmapDrawable aDX;
    private boolean aDY;
    private Drawable aDZ;
    private float aEa;
    private float aEc;
    private boolean aEd;
    private Drawable aEe;
    private int aEf;
    private final Rect aEg;
    private final Rect aEh;
    private boolean aEi;
    private boolean aEj;
    private boolean aEk;
    private boolean aEl;
    private com.baidu.adp.widget.ImageView.a aEm;
    private boolean aEn;
    private boolean aEo;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> aEp;
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
        this.aDS = d.g.pic_expression_upload_selector;
        this.aDV = false;
        this.aDW = true;
        this.aEg = new Rect();
        this.aEh = new Rect();
        this.aEi = true;
        this.aEj = false;
        this.aEk = false;
        this.aEl = false;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.gif.GifView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                boolean z;
                b gif = GifView.this.getGif();
                if (gif != null && message.what == 1) {
                    GifView.this.aDT++;
                    if (GifView.this.aDT >= gif.getFrameCount()) {
                        if (GifView.this.aEn) {
                            if (!GifView.this.aEj) {
                                GifView.this.setVisibility(4);
                            }
                            GifView.this.aEn = false;
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!GifView.this.aEj) {
                            GifView.this.aDT = 0;
                        } else {
                            GifView.this.aDT = gif.getFrameCount() - 1;
                        }
                    } else {
                        z = false;
                    }
                    gif.T(GifView.this.aDT);
                    gif.a(GifView.this.mBitmap, null);
                    GifView.this.invalidate();
                    removeMessages(1);
                    if (z) {
                        GifView.this.onStop();
                    } else {
                        sendEmptyMessageDelayed(1, gif.U(GifView.this.aDT));
                    }
                }
            }
        };
        this.mType = 20;
        this.aEo = true;
        this.aEp = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.gif.GifView.2
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
        this.aDX = (BitmapDrawable) getResources().getDrawable(d.g.icon_content_animation);
        this.aDX.setBounds(0, 0, this.aDX.getIntrinsicWidth(), this.aDX.getIntrinsicHeight());
        this.aEc = 30.0f;
        if (((BitmapDrawable) getResources().getDrawable(d.g.loading)) != null) {
            aEb = a(this);
            this.aEh.set(0, 0, aEb.getWidth(), aEb.getHeight());
        }
        this.aDZ = getResources().getDrawable(d.g.image_group_load_f);
        d(this.aDZ);
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
                this.aEg.set(i7, i8, i7 + i6, i6 + i8);
            }
            int intrinsicWidth = this.aDZ.getIntrinsicWidth();
            int intrinsicHeight = this.aDZ.getIntrinsicHeight();
            if (intrinsicWidth > i5) {
                intrinsicWidth = i5;
            }
            if (intrinsicHeight > paddingBottom) {
                intrinsicHeight = paddingBottom;
            }
            int i9 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
            int i10 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
            this.aDZ.setBounds(i9, i10, intrinsicWidth + i9, intrinsicHeight + i10);
            if (this.aEe != null) {
                int intrinsicWidth2 = this.aEe.getIntrinsicWidth();
                int intrinsicHeight2 = this.aEe.getIntrinsicHeight();
                if (intrinsicWidth2 > i5) {
                    intrinsicWidth2 = i5;
                }
                if (intrinsicHeight2 > paddingBottom) {
                    intrinsicHeight2 = paddingBottom;
                }
                int i11 = ((i5 - intrinsicWidth2) / 2) + paddingLeft;
                int i12 = ((paddingBottom - intrinsicHeight2) / 2) + paddingTop;
                this.aEe.setBounds(i11, i12, intrinsicWidth2 + i11, intrinsicHeight2 + i12);
            }
        }
    }

    public void release() {
        if (this.aEk && this.Gu != null && this.Gu != null) {
            this.Gu.close();
            this.Gu = null;
        }
    }

    public void setGif(com.baidu.adp.widget.ImageView.a aVar) {
        this.aDY = false;
        this.mIsLoading = false;
        this.aEd = false;
        if (this.mGifInfo != null) {
            this.mGifInfo.mLoadFailed = false;
        }
        if (aVar == null) {
            this.aDY = true;
            this.aDV = false;
            if (this.mGifInfo != null) {
                this.mGifInfo.mLoadFailed = true;
            }
            setImageDrawable(null);
            if (this.Gu != null) {
                this.Gu.close();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.kL()) {
                this.aDV = true;
                aVar.a(this);
                this.mIsLoading = false;
            }
            if (this.Gu != null) {
                this.Gu.close();
            }
        } else if (this.Gu == null || !aVar.getGif().equals(this.Gu)) {
            this.aDV = false;
            try {
                if (this.mBitmap == null || (this.mBitmap.getWidth() != aVar.getGif().getWidth() && this.mBitmap.getHeight() != aVar.getGif().getHeight())) {
                    this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
                }
                this.Gu = aVar.getGif();
                aVar.getGif().T(0);
                aVar.getGif().a(this.mBitmap, null);
                setImageBitmap(this.mBitmap);
                if (this.aEi) {
                    play();
                }
            } catch (Throwable th) {
                onStop();
            }
        } else {
            aVar.getGif().T(this.aDT);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.aEi) {
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
        this.aEk = true;
        setGif(g);
    }

    public boolean getAutoPlay() {
        return this.aEi;
    }

    public void setAutoPlay(boolean z) {
        this.aEi = z;
    }

    public void pause() {
        this.mHandler.removeMessages(1);
    }

    public void resume() {
        this.aEl = false;
        b gif = getGif();
        if (gif != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, gif.U(this.aDT));
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
        this.aEl = false;
        b gif = getGif();
        if (gif != null) {
            if (this.aDT != 0) {
                this.aDT = 0;
            }
            gif.T(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, gif.U(this.aDT));
        }
    }

    public void DM() {
        this.aEn = true;
        play();
    }

    public void onDestroy() {
        this.aEm = null;
        if (this.Gu != null) {
            this.Gu.close();
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
        DO();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.mHandler.removeMessages(1);
        DO();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (!this.aDV) {
            if (i == 4 || i == 8) {
                stop();
            } else if (i == 0) {
                play();
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (!this.mIsLoading && !this.aDY && !this.aEd) {
            super.onDraw(canvas);
        }
        canvas.save();
        try {
            if (this.Gu != null && !this.mIsLoading && !this.aDY && !this.aEd) {
                this.Gu.a(null, canvas);
            }
        } catch (Throwable th) {
            BdLog.e("setGif:" + th.getMessage());
            onStop();
        }
        canvas.restore();
        if (this.aDV && this.aDW) {
            canvas.save();
            this.aDX.draw(canvas);
            canvas.restore();
        }
        if (this.mIsLoading && a(this) != null) {
            canvas.save();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            canvas.rotate(this.aEa, (width * 0.5f) + getPaddingLeft(), (height * 0.5f) + getPaddingTop());
            canvas.drawBitmap(a(this), this.aEh, this.aEg, (Paint) null);
            canvas.restore();
        } else if (this.aDY || (this.mGifInfo != null && this.mGifInfo.mLoadFailed)) {
            canvas.save();
            this.aDZ.draw(canvas);
            canvas.restore();
        } else if (this.aEd) {
            canvas.save();
            this.aEe.draw(canvas);
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
            DN();
        }
    }

    public void e(boolean z, int i) {
        this.aEd = z;
        if (z) {
            this.mIsLoading = false;
            this.aDY = false;
            if (this.aEe == null || this.aEf != i) {
                this.aEf = i;
                this.aEe = aj.getDrawable(i);
                int intrinsicWidth = this.aEe.getIntrinsicWidth();
                int intrinsicHeight = this.aEe.getIntrinsicHeight();
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
                this.aEe.setBounds(paddingLeft, paddingTop, intrinsicWidth + paddingLeft, intrinsicHeight + paddingTop);
            }
        }
        invalidate();
    }

    public void stopLoading() {
        this.mIsLoading = false;
        removeCallbacks(this);
        invalidate();
    }

    private void DN() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aEa += this.aEc;
        if (this.aEa > 360.0f - this.aEc) {
            this.aEa = 0.0f;
        }
        invalidate();
        DN();
    }

    public void setPlayCallback(a aVar) {
        this.aDU = aVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.aEe != null && this.aEe.isStateful()) {
            this.aEe.setState(getDrawableState());
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
        boolean GB = h.GB();
        com.baidu.adp.base.h W = com.baidu.adp.base.i.W(getContext());
        if (W != null) {
            bdUniqueId = W.getUniqueId();
            z = W.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        if (!(gifInfo == this.mGifInfo && this.mPageId == bdUniqueId)) {
            DO();
        }
        this.mGifInfo = gifInfo;
        this.mPageId = bdUniqueId;
        String str = GB ? this.mGifInfo.mDynamicUrl : this.mGifInfo.mStaticUrl;
        com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) c.fJ().a(this.mGifInfo.mSharpText, this.mType, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(GB), str);
        if (aVar != null) {
            stopLoading();
            setGif(aVar);
        } else if (this.mGifInfo.mLoadFailed) {
            setGif(null);
        } else if (!c.fJ().ao(this.mType) && this.aEo) {
            e(true, this.aDS);
        } else if (!z) {
            c.fJ().a(this.mGifInfo.mSharpText, this.mType, this.aEp);
            startLoading();
            c.fJ().a(this.mGifInfo.mSharpText, this.mType, this.aEp, 0, 0, this.mPageId, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(GB), str);
        }
    }

    public void DO() {
        stopLoading();
        this.aDY = false;
        this.aEd = false;
        if (this.mGifInfo != null) {
            c.fJ().a(this.mGifInfo.mSharpText, this.mType, this.aEp);
        }
    }

    @Override // com.baidu.adp.b.a.i
    public void refresh() {
        a(this.mGifInfo);
    }

    public void setSupportNoImage(boolean z) {
        this.aEo = z;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(this);
        this.mOnClickListener = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mGifInfo != null) {
            boolean GB = h.GB();
            String str = GB ? this.mGifInfo.mDynamicUrl : this.mGifInfo.mStaticUrl;
            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) c.fJ().a(this.mGifInfo.mSharpText, this.mType, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(GB), str);
            if (aVar != null) {
                this.mGifInfo.mLoadFailed = false;
                setGif(aVar);
            } else {
                startLoading();
                c.fJ().a(this.mGifInfo.mSharpText, this.mType, this.aEp, 0, 0, this.mPageId, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(GB), str);
                return;
            }
        }
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    public void setIsKeepLastFrame(boolean z) {
        this.aEj = z;
    }

    public static Bitmap a(GifView gifView) {
        if (aEb != null && !aEb.isRecycled()) {
            return aEb;
        }
        BitmapDrawable bitmapDrawable = (BitmapDrawable) gifView.getResources().getDrawable(d.g.loading);
        if (bitmapDrawable != null) {
            aEb = bitmapDrawable.getBitmap();
        }
        return aEb;
    }

    public b getGif() {
        if (this.Gu == null) {
            onStop();
            return null;
        }
        return this.Gu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStop() {
        if (this.aDU != null && !this.aEl) {
            this.aDU.onStop();
            this.aEl = true;
        }
    }

    public void setShowStaticDrawable(boolean z) {
        this.aDW = z;
    }

    public GifInfo getGifInfo() {
        return this.mGifInfo;
    }

    public void setBgImage(com.baidu.adp.widget.ImageView.a aVar) {
        this.aEm = aVar;
    }

    public com.baidu.adp.widget.ImageView.a getBdImage() {
        return this.aEm;
    }

    public void setType(int i) {
        this.mType = i;
    }
}
