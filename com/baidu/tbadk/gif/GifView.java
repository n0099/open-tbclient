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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.util.g;
import com.baidu.tieba.r;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public class GifView extends ImageView implements View.OnClickListener, i, Runnable {
    public static Bitmap awN;
    private com.baidu.adp.gif.b Ah;
    private final int awF;
    private int awG;
    private a awH;
    private boolean awI;
    private BitmapDrawable awJ;
    private boolean awK;
    private Drawable awL;
    private float awM;
    private float awO;
    private boolean awP;
    private Drawable awQ;
    private int awR;
    private final Rect awS;
    private final Rect awT;
    private boolean awU;
    private boolean awV;
    private boolean awW;
    private boolean awX;
    private boolean awY;
    private boolean awZ;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> axa;
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
        this.awF = r.g.pic_expression_upload_selector;
        this.awI = false;
        this.awS = new Rect();
        this.awT = new Rect();
        this.awU = true;
        this.awV = false;
        this.awW = false;
        this.awX = false;
        this.mHandler = new com.baidu.tbadk.gif.a(this, Looper.getMainLooper());
        this.mType = 20;
        this.awZ = true;
        this.axa = new b(this);
        this.awJ = (BitmapDrawable) getResources().getDrawable(r.g.icon_content_animation);
        this.awJ.setBounds(0, 0, this.awJ.getIntrinsicWidth(), this.awJ.getIntrinsicHeight());
        this.awO = 30.0f;
        if (((BitmapDrawable) getResources().getDrawable(r.g.loading)) != null) {
            awN = a(this);
            this.awT.set(0, 0, awN.getWidth(), awN.getHeight());
        }
        this.awL = getResources().getDrawable(r.g.image_group_load_f);
        e(this.awL);
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
                this.awS.set(i7, i8, i7 + i6, i6 + i8);
            }
            int intrinsicWidth = this.awL.getIntrinsicWidth();
            int intrinsicHeight = this.awL.getIntrinsicHeight();
            if (intrinsicWidth > i5) {
                intrinsicWidth = i5;
            }
            if (intrinsicHeight > paddingBottom) {
                intrinsicHeight = paddingBottom;
            }
            int i9 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
            int i10 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
            this.awL.setBounds(i9, i10, intrinsicWidth + i9, intrinsicHeight + i10);
            if (this.awQ != null) {
                int intrinsicWidth2 = this.awQ.getIntrinsicWidth();
                int intrinsicHeight2 = this.awQ.getIntrinsicHeight();
                if (intrinsicWidth2 > i5) {
                    intrinsicWidth2 = i5;
                }
                if (intrinsicHeight2 > paddingBottom) {
                    intrinsicHeight2 = paddingBottom;
                }
                int i11 = ((i5 - intrinsicWidth2) / 2) + paddingLeft;
                int i12 = ((paddingBottom - intrinsicHeight2) / 2) + paddingTop;
                this.awQ.setBounds(i11, i12, intrinsicWidth2 + i11, intrinsicHeight2 + i12);
            }
        }
    }

    public void release() {
        if (this.awW && this.Ah != null && this.Ah != null) {
            this.Ah.close();
            this.Ah = null;
        }
    }

    public void setGif(com.baidu.adp.widget.a.a aVar) {
        this.awK = false;
        this.mIsLoading = false;
        this.awP = false;
        if (this.mGifInfo != null) {
            this.mGifInfo.mLoadFailed = false;
        }
        if (aVar == null) {
            this.awK = true;
            this.awI = false;
            if (this.mGifInfo != null) {
                this.mGifInfo.mLoadFailed = true;
            }
            setImageDrawable(null);
            if (this.Ah != null) {
                this.Ah.close();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.jR()) {
                this.awI = true;
                aVar.e(this);
                this.mIsLoading = false;
            }
            if (this.Ah != null) {
                this.Ah.close();
            }
        } else if (this.Ah == null || !aVar.getGif().equals(this.Ah)) {
            this.awI = false;
            try {
                if (this.mBitmap == null || (this.mBitmap.getWidth() != aVar.getGif().getWidth() && this.mBitmap.getHeight() != aVar.getGif().getHeight())) {
                    this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
                }
                this.Ah = aVar.getGif();
                aVar.getGif().V(0);
                aVar.getGif().a(this.mBitmap, null);
                setImageBitmap(this.mBitmap);
                if (this.awU) {
                    play();
                }
            } catch (Throwable th) {
                onStop();
            }
        } else {
            aVar.getGif().V(this.awG);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.awU) {
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
        com.baidu.adp.widget.a.a e8 = a.C0003a.cu().e(bArr, 0, i2);
        this.awW = true;
        setGif(e8);
    }

    public boolean getAutoPlay() {
        return this.awU;
    }

    public void setAutoPlay(boolean z) {
        this.awU = z;
    }

    public void resume() {
        this.awX = false;
        com.baidu.adp.gif.b gif = getGif();
        if (gif != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, gif.W(this.awG));
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
        this.awX = false;
        com.baidu.adp.gif.b gif = getGif();
        if (gif != null) {
            if (this.awG != 0) {
                this.awG = 0;
            }
            gif.V(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, gif.W(this.awG));
        }
    }

    public void DN() {
        this.awY = true;
        play();
    }

    public void onDestroy() {
        this.Ah = null;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandler.removeMessages(1);
        DP();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.mHandler.removeMessages(1);
        DP();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (!this.awI) {
            if (i == 4 || i == 8) {
                stop();
            } else if (i == 0) {
                play();
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (!this.mIsLoading && !this.awK && !this.awP) {
            super.onDraw(canvas);
        }
        canvas.save();
        try {
            if (this.Ah != null && !this.mIsLoading && !this.awK && !this.awP) {
                this.Ah.a(null, canvas);
            }
        } catch (Throwable th) {
            BdLog.e("setGif:" + th.getMessage());
            onStop();
        }
        canvas.restore();
        if (this.awI) {
            canvas.save();
            this.awJ.draw(canvas);
            canvas.restore();
        }
        if (this.mIsLoading && a(this) != null) {
            canvas.save();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            canvas.rotate(this.awM, (width * 0.5f) + getPaddingLeft(), (height * 0.5f) + getPaddingTop());
            canvas.drawBitmap(a(this), this.awT, this.awS, (Paint) null);
            canvas.restore();
        } else if (this.awK || (this.mGifInfo != null && this.mGifInfo.mLoadFailed)) {
            canvas.save();
            this.awL.draw(canvas);
            canvas.restore();
        } else if (this.awP) {
            canvas.save();
            this.awQ.draw(canvas);
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
            DO();
        }
    }

    public void d(boolean z, int i) {
        this.awP = z;
        if (z) {
            this.mIsLoading = false;
            this.awK = false;
            if (this.awQ == null || this.awR != i) {
                this.awR = i;
                this.awQ = ap.getDrawable(i);
                int intrinsicWidth = this.awQ.getIntrinsicWidth();
                int intrinsicHeight = this.awQ.getIntrinsicHeight();
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
                this.awQ.setBounds(paddingLeft, paddingTop, intrinsicWidth + paddingLeft, intrinsicHeight + paddingTop);
            }
        }
        invalidate();
    }

    public void stopLoading() {
        this.mIsLoading = false;
        removeCallbacks(this);
        invalidate();
    }

    private void DO() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.awM += this.awO;
        if (this.awM > 360.0f - this.awO) {
            this.awM = 0.0f;
        }
        invalidate();
        DO();
    }

    public void setPlayCallback(a aVar) {
        this.awH = aVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.awQ != null && this.awQ.isStateful()) {
            this.awQ.setState(getDrawableState());
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
        boolean Gm = g.Gm();
        j A = k.A(getContext());
        if (A != null) {
            bdUniqueId = A.getUniqueId();
            z = A.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        if (!(gifInfo == this.mGifInfo && this.mPageId == bdUniqueId)) {
            DP();
        }
        this.mGifInfo = gifInfo;
        this.mPageId = bdUniqueId;
        String str = Gm ? this.mGifInfo.mDynamicUrl : this.mGifInfo.mStaticUrl;
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.ey().a(this.mGifInfo.mSharpText, 20, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(Gm), str);
        if (aVar != null) {
            stopLoading();
            setGif(aVar);
        } else if (this.mGifInfo.mLoadFailed) {
            setGif(null);
        } else if (!com.baidu.adp.lib.f.c.ey().am(20) && this.awZ) {
            d(true, this.awF);
        } else if (!z) {
            com.baidu.adp.lib.f.c.ey().a(this.mGifInfo.mSharpText, 20, this.axa);
            startLoading();
            com.baidu.adp.lib.f.c.ey().a(this.mGifInfo.mSharpText, 20, this.axa, 0, 0, this.mPageId, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(Gm), str);
        }
    }

    public void DP() {
        stopLoading();
        this.awK = false;
        this.awP = false;
        if (this.mGifInfo != null) {
            com.baidu.adp.lib.f.c.ey().a(this.mGifInfo.mSharpText, 20, this.axa);
        }
    }

    @Override // com.baidu.adp.newwidget.a.i
    public void refresh() {
        a(this.mGifInfo);
    }

    public void setSupportNoImage(boolean z) {
        this.awZ = z;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(this);
        this.mOnClickListener = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mGifInfo != null) {
            boolean Gm = g.Gm();
            String str = Gm ? this.mGifInfo.mDynamicUrl : this.mGifInfo.mStaticUrl;
            com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.ey().a(this.mGifInfo.mSharpText, 20, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(Gm), str);
            if (aVar != null) {
                this.mGifInfo.mLoadFailed = false;
                setGif(aVar);
            } else {
                startLoading();
                com.baidu.adp.lib.f.c.ey().a(this.mGifInfo.mSharpText, 20, this.axa, 0, 0, this.mPageId, this.mGifInfo.mGid, this.mGifInfo.mSharpText, Boolean.valueOf(Gm), str);
                return;
            }
        }
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    public void setIsKeepLastFrame(boolean z) {
        this.awV = z;
    }

    public static Bitmap a(GifView gifView) {
        if (awN != null && !awN.isRecycled()) {
            return awN;
        }
        BitmapDrawable bitmapDrawable = (BitmapDrawable) gifView.getResources().getDrawable(r.g.loading);
        if (bitmapDrawable != null) {
            awN = bitmapDrawable.getBitmap();
        }
        return awN;
    }

    public com.baidu.adp.gif.b getGif() {
        if (this.Ah == null) {
            onStop();
            return null;
        }
        return this.Ah;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStop() {
        if (this.awH != null && !this.awX) {
            this.awH.onStop();
            this.awX = true;
        }
    }
}
