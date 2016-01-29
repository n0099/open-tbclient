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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.t;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public class GifView extends ImageView implements View.OnClickListener, i, Runnable {
    public static Bitmap awE;
    private com.baidu.adp.gif.b He;
    private BitmapDrawable awA;
    private boolean awB;
    private Drawable awC;
    private float awD;
    private float awF;
    private boolean awG;
    private Drawable awH;
    private int awI;
    private final Rect awJ;
    private final Rect awK;
    private boolean awL;
    private boolean awM;
    private boolean awN;
    private boolean awO;
    private boolean awP;
    private com.baidu.tbadk.gif.a awQ;
    private boolean awR;
    private BdUniqueId awS;
    private final com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> awT;
    private final int aww;
    private int awx;
    private a awy;
    private boolean awz;
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
        this.aww = t.f.pic_expression_upload_selector;
        this.awz = false;
        this.awJ = new Rect();
        this.awK = new Rect();
        this.awL = true;
        this.awM = false;
        this.awN = false;
        this.awO = false;
        this.mHandler = new b(this, Looper.getMainLooper());
        this.mType = 20;
        this.awR = true;
        this.awT = new c(this);
        this.awA = (BitmapDrawable) getResources().getDrawable(t.f.icon_content_animation);
        this.awA.setBounds(0, 0, this.awA.getIntrinsicWidth(), this.awA.getIntrinsicHeight());
        this.awF = 30.0f;
        if (((BitmapDrawable) getResources().getDrawable(t.f.loading)) != null) {
            awE = a(this);
            this.awK.set(0, 0, awE.getWidth(), awE.getHeight());
        }
        this.awC = getResources().getDrawable(t.f.image_group_load_f);
        c(this.awC);
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
                this.awJ.set(i7, i8, i7 + i6, i6 + i8);
            }
            int intrinsicWidth = this.awC.getIntrinsicWidth();
            int intrinsicHeight = this.awC.getIntrinsicHeight();
            if (intrinsicWidth > i5) {
                intrinsicWidth = i5;
            }
            if (intrinsicHeight > paddingBottom) {
                intrinsicHeight = paddingBottom;
            }
            int i9 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
            int i10 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
            this.awC.setBounds(i9, i10, intrinsicWidth + i9, intrinsicHeight + i10);
            if (this.awH != null) {
                int intrinsicWidth2 = this.awH.getIntrinsicWidth();
                int intrinsicHeight2 = this.awH.getIntrinsicHeight();
                if (intrinsicWidth2 > i5) {
                    intrinsicWidth2 = i5;
                }
                if (intrinsicHeight2 > paddingBottom) {
                    intrinsicHeight2 = paddingBottom;
                }
                int i11 = ((i5 - intrinsicWidth2) / 2) + paddingLeft;
                int i12 = ((paddingBottom - intrinsicHeight2) / 2) + paddingTop;
                this.awH.setBounds(i11, i12, intrinsicWidth2 + i11, intrinsicHeight2 + i12);
            }
        }
    }

    public void release() {
        if (this.awN && this.He != null && this.He != null) {
            this.He.close();
            this.He = null;
        }
    }

    public void setGif(com.baidu.adp.widget.a.a aVar) {
        this.awB = false;
        this.mIsLoading = false;
        this.awG = false;
        if (this.awQ != null) {
            this.awQ.awq = false;
        }
        if (aVar == null) {
            this.awB = true;
            this.awz = false;
            if (this.awQ != null) {
                this.awQ.awq = true;
            }
            setImageDrawable(null);
            if (this.He != null) {
                this.He.close();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.mQ()) {
                this.awz = true;
                aVar.a(this);
                this.mIsLoading = false;
            }
            if (this.He != null) {
                this.He.close();
            }
        } else if (this.He == null || !aVar.getGif().equals(this.He)) {
            this.awz = false;
            try {
                if (this.mBitmap == null || (this.mBitmap.getWidth() != aVar.getGif().getWidth() && this.mBitmap.getHeight() != aVar.getGif().getHeight())) {
                    this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
                }
                this.He = aVar.getGif();
                aVar.getGif().R(0);
                aVar.getGif().a(this.mBitmap, null);
                setImageBitmap(this.mBitmap);
                if (this.awL) {
                    play();
                }
            } catch (Throwable th) {
                onStop();
            }
        } else {
            aVar.getGif().R(this.awx);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.awL) {
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
        com.baidu.adp.widget.a.a d = a.C0003a.fm().d(bArr, 0, i2);
        this.awN = true;
        setGif(d);
    }

    public boolean getAutoPlay() {
        return this.awL;
    }

    public void setAutoPlay(boolean z) {
        this.awL = z;
    }

    public void resume() {
        this.awO = false;
        com.baidu.adp.gif.b gif = getGif();
        if (gif != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, gif.S(this.awx));
        }
    }

    public void stop() {
        com.baidu.adp.gif.b gif = getGif();
        if (gif != null) {
            this.mHandler.removeMessages(1);
            gif.R(0);
            gif.a(this.mBitmap, null);
            invalidate();
            onStop();
        }
    }

    public void play() {
        this.awO = false;
        com.baidu.adp.gif.b gif = getGif();
        if (gif != null) {
            if (this.awx != 0) {
                this.awx = 0;
            }
            gif.R(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, gif.S(this.awx));
        }
    }

    public void DY() {
        this.awP = true;
        play();
    }

    public void onDestroy() {
        this.He = null;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandler.removeMessages(1);
        Ea();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.mHandler.removeMessages(1);
        Ea();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (!this.awz) {
            if (i == 4 || i == 8) {
                stop();
            } else if (i == 0) {
                play();
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (!this.mIsLoading && !this.awB && !this.awG) {
            super.onDraw(canvas);
        }
        canvas.save();
        try {
            if (this.He != null && !this.mIsLoading && !this.awB && !this.awG) {
                this.He.a(null, canvas);
            }
        } catch (Throwable th) {
            BdLog.e("setGif:" + th.getMessage());
            onStop();
        }
        canvas.restore();
        if (this.awz) {
            canvas.save();
            this.awA.draw(canvas);
            canvas.restore();
        }
        if (this.mIsLoading && a(this) != null) {
            canvas.save();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            canvas.rotate(this.awD, (width * 0.5f) + getPaddingLeft(), (height * 0.5f) + getPaddingTop());
            canvas.drawBitmap(a(this), this.awK, this.awJ, (Paint) null);
            canvas.restore();
        } else if (this.awB || (this.awQ != null && this.awQ.awq)) {
            canvas.save();
            this.awC.draw(canvas);
            canvas.restore();
        } else if (this.awG) {
            canvas.save();
            this.awH.draw(canvas);
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
            DZ();
        }
    }

    public void c(boolean z, int i) {
        this.awG = z;
        if (z) {
            this.mIsLoading = false;
            this.awB = false;
            if (this.awH == null || this.awI != i) {
                this.awI = i;
                this.awH = ar.getDrawable(i);
                int intrinsicWidth = this.awH.getIntrinsicWidth();
                int intrinsicHeight = this.awH.getIntrinsicHeight();
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
                this.awH.setBounds(paddingLeft, paddingTop, intrinsicWidth + paddingLeft, intrinsicHeight + paddingTop);
            }
        }
        invalidate();
    }

    public void stopLoading() {
        this.mIsLoading = false;
        removeCallbacks(this);
        invalidate();
    }

    private void DZ() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.awD += this.awF;
        if (this.awD > 360.0f - this.awF) {
            this.awD = 0.0f;
        }
        invalidate();
        DZ();
    }

    public void setPlayCallback(a aVar) {
        this.awy = aVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.awH != null && this.awH.isStateful()) {
            this.awH.setState(getDrawableState());
            invalidate();
        }
    }

    public void a(com.baidu.tbadk.gif.a aVar) {
        BdUniqueId bdUniqueId;
        boolean z;
        if (aVar == null) {
            this.awQ = null;
            return;
        }
        boolean Gx = com.baidu.tbadk.util.e.Gx();
        k A = l.A(getContext());
        if (A != null) {
            bdUniqueId = A.getUniqueId();
            z = A.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        if (!(aVar == this.awQ && this.awS == bdUniqueId)) {
            Ea();
        }
        this.awQ = aVar;
        this.awS = bdUniqueId;
        String str = Gx ? this.awQ.awt : this.awQ.aws;
        com.baidu.adp.widget.a.a aVar2 = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.g.c.hl().a(this.awQ.awr, 20, this.awQ.mGid, this.awQ.awr, Boolean.valueOf(Gx), str);
        if (aVar2 != null) {
            stopLoading();
            setGif(aVar2);
        } else if (this.awQ.awq) {
            setGif(null);
        } else if (!com.baidu.adp.lib.g.c.hl().ai(20) && this.awR) {
            c(true, this.aww);
        } else {
            startLoading();
            if (!z) {
                com.baidu.adp.lib.g.c.hl().a(this.awQ.awr, 20, this.awT, 0, 0, this.awS, this.awQ.mGid, this.awQ.awr, Boolean.valueOf(Gx), str);
            }
        }
    }

    public void Ea() {
        stopLoading();
        this.awB = false;
        this.awG = false;
        if (this.awQ != null) {
            com.baidu.adp.lib.g.c.hl().a(this.awQ.awr, 20, this.awT);
        }
    }

    @Override // com.baidu.adp.newwidget.a.i
    public void refresh() {
        a(this.awQ);
    }

    public void setSupportNoImage(boolean z) {
        this.awR = z;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(this);
        this.mOnClickListener = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.awQ != null) {
            boolean Gx = com.baidu.tbadk.util.e.Gx();
            String str = Gx ? this.awQ.awt : this.awQ.aws;
            com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.g.c.hl().a(this.awQ.awr, 20, this.awQ.mGid, this.awQ.awr, Boolean.valueOf(Gx), str);
            if (aVar != null) {
                this.awQ.awq = false;
                setGif(aVar);
            } else {
                startLoading();
                com.baidu.adp.lib.g.c.hl().a(this.awQ.awr, 20, this.awT, 0, 0, this.awS, this.awQ.mGid, this.awQ.awr, Boolean.valueOf(Gx), str);
                return;
            }
        }
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    public void setIsKeepLastFrame(boolean z) {
        this.awM = z;
    }

    public static Bitmap a(GifView gifView) {
        if (awE != null && !awE.isRecycled()) {
            return awE;
        }
        BitmapDrawable bitmapDrawable = (BitmapDrawable) gifView.getResources().getDrawable(t.f.loading);
        if (bitmapDrawable != null) {
            awE = bitmapDrawable.getBitmap();
        }
        return awE;
    }

    public com.baidu.adp.gif.b getGif() {
        if (this.He == null) {
            onStop();
            return null;
        }
        return this.He;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStop() {
        if (this.awy != null && !this.awO) {
            this.awy.onStop();
            this.awO = true;
        }
    }
}
