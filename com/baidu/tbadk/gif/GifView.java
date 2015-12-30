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
import com.baidu.adp.base.k;
import com.baidu.adp.base.l;
import com.baidu.adp.gif.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.newwidget.a.i;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.n;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public class GifView extends ImageView implements View.OnClickListener, i, Runnable {
    public static Bitmap avN;
    private com.baidu.adp.gif.b GR;
    private final int avF;
    private int avG;
    private a avH;
    private boolean avI;
    private BitmapDrawable avJ;
    private boolean avK;
    private Drawable avL;
    private float avM;
    private float avO;
    private boolean avP;
    private Drawable avQ;
    private int avR;
    private final Rect avS;
    private final Rect avT;
    private boolean avU;
    private boolean avV;
    private boolean avW;
    private boolean avX;
    private boolean avY;
    private com.baidu.tbadk.gif.a avZ;
    private boolean awa;
    private BdUniqueId awb;
    private final com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> awc;
    private Bitmap mBitmap;
    private final Handler mHandler;
    private boolean mIsLoading;
    private View.OnClickListener mOnClickListener;
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
        this.avF = n.f.pic_expression_upload_selector;
        this.avI = false;
        this.avS = new Rect();
        this.avT = new Rect();
        this.avU = true;
        this.avV = false;
        this.avW = false;
        this.avX = false;
        this.mHandler = new b(this, Looper.getMainLooper());
        this.mType = 20;
        this.awa = true;
        this.awc = new c(this);
        this.avJ = (BitmapDrawable) getResources().getDrawable(n.f.icon_content_animation);
        this.avJ.setBounds(0, 0, this.avJ.getIntrinsicWidth(), this.avJ.getIntrinsicHeight());
        this.avO = 30.0f;
        if (((BitmapDrawable) getResources().getDrawable(n.f.loading)) != null) {
            avN = a(this);
            this.avT.set(0, 0, avN.getWidth(), avN.getHeight());
        }
        this.avL = getResources().getDrawable(n.f.image_group_load_f);
        c(this.avL);
    }

    private void c(Drawable drawable) {
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
                this.avS.set(i7, i8, i7 + i6, i6 + i8);
            }
            int intrinsicWidth = this.avL.getIntrinsicWidth();
            int intrinsicHeight = this.avL.getIntrinsicHeight();
            if (intrinsicWidth > i5) {
                intrinsicWidth = i5;
            }
            if (intrinsicHeight > paddingBottom) {
                intrinsicHeight = paddingBottom;
            }
            int i9 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
            int i10 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
            this.avL.setBounds(i9, i10, intrinsicWidth + i9, intrinsicHeight + i10);
            if (this.avQ != null) {
                int intrinsicWidth2 = this.avQ.getIntrinsicWidth();
                int intrinsicHeight2 = this.avQ.getIntrinsicHeight();
                if (intrinsicWidth2 > i5) {
                    intrinsicWidth2 = i5;
                }
                if (intrinsicHeight2 > paddingBottom) {
                    intrinsicHeight2 = paddingBottom;
                }
                int i11 = ((i5 - intrinsicWidth2) / 2) + paddingLeft;
                int i12 = ((paddingBottom - intrinsicHeight2) / 2) + paddingTop;
                this.avQ.setBounds(i11, i12, intrinsicWidth2 + i11, intrinsicHeight2 + i12);
            }
        }
    }

    public void release() {
        if (this.avW && this.GR != null && this.GR != null) {
            this.GR.close();
            this.GR = null;
        }
    }

    public void setGif(com.baidu.adp.widget.a.a aVar) {
        this.avK = false;
        this.mIsLoading = false;
        this.avP = false;
        if (this.avZ != null) {
            this.avZ.avy = false;
        }
        if (aVar == null) {
            this.avK = true;
            this.avI = false;
            if (this.avZ != null) {
                this.avZ.avy = true;
            }
            setImageDrawable(null);
            if (this.GR != null) {
                this.GR.close();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.mC()) {
                this.avI = true;
                aVar.a(this);
                this.mIsLoading = false;
            }
            if (this.GR != null) {
                this.GR.close();
            }
        } else if (this.GR == null || !aVar.getGif().equals(this.GR)) {
            this.avI = false;
            try {
                if (this.mBitmap == null || (this.mBitmap.getWidth() != aVar.getGif().getWidth() && this.mBitmap.getHeight() != aVar.getGif().getHeight())) {
                    this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
                }
                this.GR = aVar.getGif();
                aVar.getGif().G(0);
                aVar.getGif().a(this.mBitmap, null);
                setImageBitmap(this.mBitmap);
                if (this.avU) {
                    play();
                }
            } catch (Throwable th) {
                onStop();
            }
        } else {
            aVar.getGif().G(this.avG);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.avU) {
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
        com.baidu.adp.widget.a.a e8 = a.C0003a.fe().e(bArr, 0, i2);
        this.avW = true;
        setGif(e8);
    }

    public boolean getAutoPlay() {
        return this.avU;
    }

    public void setAutoPlay(boolean z) {
        this.avU = z;
    }

    public void resume() {
        this.avX = false;
        com.baidu.adp.gif.b gif = getGif();
        if (gif != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, gif.H(this.avG));
        }
    }

    public void stop() {
        com.baidu.adp.gif.b gif = getGif();
        if (gif != null) {
            this.mHandler.removeMessages(1);
            gif.G(0);
            gif.a(this.mBitmap, null);
            invalidate();
            onStop();
        }
    }

    public void play() {
        this.avX = false;
        com.baidu.adp.gif.b gif = getGif();
        if (gif != null) {
            if (this.avG != 0) {
                this.avG = 0;
            }
            gif.G(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, gif.H(this.avG));
        }
    }

    public void CH() {
        this.avY = true;
        play();
    }

    public void onDestroy() {
        this.GR = null;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandler.removeMessages(1);
        CJ();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.mHandler.removeMessages(1);
        CJ();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (!this.avI) {
            if (i == 4 || i == 8) {
                stop();
            } else if (i == 0) {
                play();
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (!this.mIsLoading && !this.avK && !this.avP) {
            super.onDraw(canvas);
        }
        canvas.save();
        try {
            if (this.GR != null && !this.mIsLoading && !this.avK && !this.avP) {
                this.GR.a(null, canvas);
            }
        } catch (Throwable th) {
            BdLog.e("setGif:" + th.getMessage());
            onStop();
        }
        canvas.restore();
        if (this.avI) {
            canvas.save();
            this.avJ.draw(canvas);
            canvas.restore();
        }
        if (this.mIsLoading && a(this) != null) {
            canvas.save();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            canvas.rotate(this.avM, (width * 0.5f) + getPaddingLeft(), (height * 0.5f) + getPaddingTop());
            canvas.drawBitmap(a(this), this.avT, this.avS, (Paint) null);
            canvas.restore();
        } else if (this.avK || (this.avZ != null && this.avZ.avy)) {
            canvas.save();
            this.avL.draw(canvas);
            canvas.restore();
        } else if (this.avP) {
            canvas.save();
            this.avQ.draw(canvas);
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
            CI();
        }
    }

    public void a(boolean z, int i) {
        this.avP = z;
        if (z) {
            this.mIsLoading = false;
            this.avK = false;
            if (this.avQ == null || this.avR != i) {
                this.avR = i;
                this.avQ = as.getDrawable(i);
                int intrinsicWidth = this.avQ.getIntrinsicWidth();
                int intrinsicHeight = this.avQ.getIntrinsicHeight();
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
                this.avQ.setBounds(paddingLeft, paddingTop, intrinsicWidth + paddingLeft, intrinsicHeight + paddingTop);
            }
        }
        invalidate();
    }

    public void stopLoading() {
        this.mIsLoading = false;
        removeCallbacks(this);
        invalidate();
    }

    private void CI() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.avM += this.avO;
        if (this.avM > 360.0f - this.avO) {
            this.avM = 0.0f;
        }
        invalidate();
        CI();
    }

    public void setPlayCallback(a aVar) {
        this.avH = aVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.avQ != null && this.avQ.isStateful()) {
            this.avQ.setState(getDrawableState());
            invalidate();
        }
    }

    public void a(com.baidu.tbadk.gif.a aVar) {
        BdUniqueId bdUniqueId;
        boolean z;
        if (aVar == null) {
            this.avZ = null;
            return;
        }
        boolean Ff = com.baidu.tbadk.util.e.Ff();
        k A = l.A(getContext());
        if (A != null) {
            bdUniqueId = A.getUniqueId();
            z = A.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        if (!(aVar == this.avZ && this.awb == bdUniqueId)) {
            CJ();
        }
        this.avZ = aVar;
        this.awb = bdUniqueId;
        String str = Ff ? this.avZ.avB : this.avZ.avA;
        com.baidu.adp.widget.a.a aVar2 = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.g.c.hd().a(this.avZ.avz, 20, this.avZ.mGid, this.avZ.avz, Boolean.valueOf(Ff), str);
        if (aVar2 != null) {
            stopLoading();
            setGif(aVar2);
        } else if (this.avZ.avy) {
            setGif(null);
        } else if (!com.baidu.adp.lib.g.c.hd().X(20) && this.awa) {
            a(true, this.avF);
        } else {
            startLoading();
            if (!z) {
                com.baidu.adp.lib.g.c.hd().a(this.avZ.avz, 20, this.awc, 0, 0, this.awb, this.avZ.mGid, this.avZ.avz, Boolean.valueOf(Ff), str);
            }
        }
    }

    public void CJ() {
        stopLoading();
        this.avK = false;
        this.avP = false;
        if (this.avZ != null) {
            com.baidu.adp.lib.g.c.hd().a(this.avZ.avz, 20, this.awc);
        }
    }

    @Override // com.baidu.adp.newwidget.a.i
    public void refresh() {
        a(this.avZ);
    }

    public void setSupportNoImage(boolean z) {
        this.awa = z;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(this);
        this.mOnClickListener = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.avZ != null) {
            boolean Ff = com.baidu.tbadk.util.e.Ff();
            String str = Ff ? this.avZ.avB : this.avZ.avA;
            com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.g.c.hd().a(this.avZ.avz, 20, this.avZ.mGid, this.avZ.avz, Boolean.valueOf(Ff), str);
            if (aVar != null) {
                this.avZ.avy = false;
                setGif(aVar);
            } else {
                startLoading();
                com.baidu.adp.lib.g.c.hd().a(this.avZ.avz, 20, this.awc, 0, 0, this.awb, this.avZ.mGid, this.avZ.avz, Boolean.valueOf(Ff), str);
                return;
            }
        }
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    public void setIsKeepLastFrame(boolean z) {
        this.avV = z;
    }

    public static Bitmap a(GifView gifView) {
        if (avN != null && !avN.isRecycled()) {
            return avN;
        }
        BitmapDrawable bitmapDrawable = (BitmapDrawable) gifView.getResources().getDrawable(n.f.loading);
        if (bitmapDrawable != null) {
            avN = bitmapDrawable.getBitmap();
        }
        return avN;
    }

    public com.baidu.adp.gif.b getGif() {
        if (this.GR == null) {
            onStop();
            return null;
        }
        return this.GR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStop() {
        if (this.avH != null && !this.avX) {
            this.avH.onStop();
            this.avX = true;
        }
    }
}
