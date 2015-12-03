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
    public static Bitmap auj;
    private com.baidu.adp.gif.b GA;
    private final int aub;
    private int auc;
    private a aud;
    private boolean aue;
    private BitmapDrawable auf;
    private boolean aug;
    private Drawable auh;
    private float aui;
    private float auk;
    private boolean aul;
    private Drawable aum;
    private int aun;
    private final Rect auo;
    private final Rect aup;
    private boolean auq;
    private boolean aur;
    private boolean aus;
    private boolean aut;
    private boolean auu;
    private com.baidu.tbadk.gif.a auv;
    private boolean auw;
    private BdUniqueId aux;
    private final com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> auy;
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
        this.aub = n.e.pic_expression_upload_selector;
        this.aue = false;
        this.auo = new Rect();
        this.aup = new Rect();
        this.auq = true;
        this.aur = false;
        this.aus = false;
        this.aut = false;
        this.mHandler = new b(this, Looper.getMainLooper());
        this.mType = 20;
        this.auw = true;
        this.auy = new c(this);
        this.auf = (BitmapDrawable) getResources().getDrawable(n.e.icon_content_animation);
        this.auf.setBounds(0, 0, this.auf.getIntrinsicWidth(), this.auf.getIntrinsicHeight());
        this.auk = 30.0f;
        if (((BitmapDrawable) getResources().getDrawable(n.e.loading)) != null) {
            auj = a(this);
            this.aup.set(0, 0, auj.getWidth(), auj.getHeight());
        }
        this.auh = getResources().getDrawable(n.e.image_group_load_f);
        c(this.auh);
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
                this.auo.set(i7, i8, i7 + i6, i6 + i8);
            }
            int intrinsicWidth = this.auh.getIntrinsicWidth();
            int intrinsicHeight = this.auh.getIntrinsicHeight();
            if (intrinsicWidth > i5) {
                intrinsicWidth = i5;
            }
            if (intrinsicHeight > paddingBottom) {
                intrinsicHeight = paddingBottom;
            }
            int i9 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
            int i10 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
            this.auh.setBounds(i9, i10, intrinsicWidth + i9, intrinsicHeight + i10);
            if (this.aum != null) {
                int intrinsicWidth2 = this.aum.getIntrinsicWidth();
                int intrinsicHeight2 = this.aum.getIntrinsicHeight();
                if (intrinsicWidth2 > i5) {
                    intrinsicWidth2 = i5;
                }
                if (intrinsicHeight2 > paddingBottom) {
                    intrinsicHeight2 = paddingBottom;
                }
                int i11 = ((i5 - intrinsicWidth2) / 2) + paddingLeft;
                int i12 = ((paddingBottom - intrinsicHeight2) / 2) + paddingTop;
                this.aum.setBounds(i11, i12, intrinsicWidth2 + i11, intrinsicHeight2 + i12);
            }
        }
    }

    public void release() {
        if (this.aus && this.GA != null && this.GA != null) {
            this.GA.close();
            this.GA = null;
        }
    }

    public void setGif(com.baidu.adp.widget.a.a aVar) {
        this.aug = false;
        this.mIsLoading = false;
        this.aul = false;
        if (this.auv != null) {
            this.auv.atU = false;
        }
        if (aVar == null) {
            this.aug = true;
            this.aue = false;
            if (this.auv != null) {
                this.auv.atU = true;
            }
            setImageDrawable(null);
            if (this.GA != null) {
                this.GA.close();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.ne()) {
                this.aue = true;
                aVar.a(this);
                this.mIsLoading = false;
            }
            if (this.GA != null) {
                this.GA.close();
            }
        } else if (this.GA == null || !aVar.getGif().equals(this.GA)) {
            this.aue = false;
            try {
                if (this.mBitmap == null || (this.mBitmap.getWidth() != aVar.getGif().getWidth() && this.mBitmap.getHeight() != aVar.getGif().getHeight())) {
                    this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
                }
                this.GA = aVar.getGif();
                aVar.getGif().G(0);
                aVar.getGif().a(this.mBitmap, null);
                setImageBitmap(this.mBitmap);
                if (this.auq) {
                    play();
                }
            } catch (Throwable th) {
                onStop();
            }
        } else {
            aVar.getGif().G(this.auc);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.auq) {
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
        com.baidu.adp.widget.a.a e8 = a.C0002a.fe().e(bArr, 0, i2);
        this.aus = true;
        setGif(e8);
    }

    public boolean getAutoPlay() {
        return this.auq;
    }

    public void setAutoPlay(boolean z) {
        this.auq = z;
    }

    public void resume() {
        this.aut = false;
        com.baidu.adp.gif.b gif = getGif();
        if (gif != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, gif.H(this.auc));
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
        this.aut = false;
        com.baidu.adp.gif.b gif = getGif();
        if (gif != null) {
            if (this.auc != 0) {
                this.auc = 0;
            }
            gif.G(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, gif.H(this.auc));
        }
    }

    public void CS() {
        this.auu = true;
        play();
    }

    public void onDestroy() {
        this.GA = null;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandler.removeMessages(1);
        CU();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.mHandler.removeMessages(1);
        CU();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (!this.aue) {
            if (i == 4 || i == 8) {
                stop();
            } else if (i == 0) {
                play();
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (!this.mIsLoading && !this.aug && !this.aul) {
            super.onDraw(canvas);
        }
        canvas.save();
        try {
            if (this.GA != null && !this.mIsLoading && !this.aug && !this.aul) {
                this.GA.a(null, canvas);
            }
        } catch (Throwable th) {
            BdLog.e("setGif:" + th.getMessage());
            onStop();
        }
        canvas.restore();
        if (this.aue) {
            canvas.save();
            this.auf.draw(canvas);
            canvas.restore();
        }
        if (this.mIsLoading && a(this) != null) {
            canvas.save();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            canvas.rotate(this.aui, (width * 0.5f) + getPaddingLeft(), (height * 0.5f) + getPaddingTop());
            canvas.drawBitmap(a(this), this.aup, this.auo, (Paint) null);
            canvas.restore();
        } else if (this.aug || (this.auv != null && this.auv.atU)) {
            canvas.save();
            this.auh.draw(canvas);
            canvas.restore();
        } else if (this.aul) {
            canvas.save();
            this.aum.draw(canvas);
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
            CT();
        }
    }

    public void a(boolean z, int i) {
        this.aul = z;
        if (z) {
            this.mIsLoading = false;
            this.aug = false;
            if (this.aum == null || this.aun != i) {
                this.aun = i;
                this.aum = as.getDrawable(i);
                int intrinsicWidth = this.aum.getIntrinsicWidth();
                int intrinsicHeight = this.aum.getIntrinsicHeight();
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
                this.aum.setBounds(paddingLeft, paddingTop, intrinsicWidth + paddingLeft, intrinsicHeight + paddingTop);
            }
        }
        invalidate();
    }

    public void stopLoading() {
        this.mIsLoading = false;
        removeCallbacks(this);
        invalidate();
    }

    private void CT() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aui += this.auk;
        if (this.aui > 360.0f - this.auk) {
            this.aui = 0.0f;
        }
        invalidate();
        CT();
    }

    public void setPlayCallback(a aVar) {
        this.aud = aVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.aum != null && this.aum.isStateful()) {
            this.aum.setState(getDrawableState());
            invalidate();
        }
    }

    public void a(com.baidu.tbadk.gif.a aVar) {
        BdUniqueId bdUniqueId;
        boolean z;
        if (aVar == null) {
            this.auv = null;
            return;
        }
        boolean Fr = com.baidu.tbadk.util.e.Fr();
        k A = l.A(getContext());
        if (A != null) {
            bdUniqueId = A.getUniqueId();
            z = A.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        if (!(aVar == this.auv && this.aux == bdUniqueId)) {
            CU();
        }
        this.auv = aVar;
        this.aux = bdUniqueId;
        String str = Fr ? this.auv.atX : this.auv.atW;
        com.baidu.adp.widget.a.a aVar2 = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.g.c.hd().a(this.auv.atV, 20, this.auv.mGid, this.auv.atV, Boolean.valueOf(Fr), str);
        if (aVar2 != null) {
            stopLoading();
            setGif(aVar2);
        } else if (this.auv.atU) {
            setGif(null);
        } else if (!com.baidu.adp.lib.g.c.hd().X(20) && this.auw) {
            a(true, this.aub);
        } else {
            startLoading();
            if (!z) {
                com.baidu.adp.lib.g.c.hd().a(this.auv.atV, 20, this.auy, 0, 0, this.aux, this.auv.mGid, this.auv.atV, Boolean.valueOf(Fr), str);
            }
        }
    }

    public void CU() {
        stopLoading();
        this.aug = false;
        this.aul = false;
        if (this.auv != null) {
            com.baidu.adp.lib.g.c.hd().a(this.auv.atV, 20, this.auy);
        }
    }

    @Override // com.baidu.adp.newwidget.a.i
    public void refresh() {
        a(this.auv);
    }

    public void setSupportNoImage(boolean z) {
        this.auw = z;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(this);
        this.mOnClickListener = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.auv != null) {
            boolean Fr = com.baidu.tbadk.util.e.Fr();
            String str = Fr ? this.auv.atX : this.auv.atW;
            com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.g.c.hd().a(this.auv.atV, 20, this.auv.mGid, this.auv.atV, Boolean.valueOf(Fr), str);
            if (aVar != null) {
                this.auv.atU = false;
                setGif(aVar);
            } else {
                startLoading();
                com.baidu.adp.lib.g.c.hd().a(this.auv.atV, 20, this.auy, 0, 0, this.aux, this.auv.mGid, this.auv.atV, Boolean.valueOf(Fr), str);
                return;
            }
        }
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    public void setIsKeepLastFrame(boolean z) {
        this.aur = z;
    }

    public static Bitmap a(GifView gifView) {
        if (auj != null && !auj.isRecycled()) {
            return auj;
        }
        BitmapDrawable bitmapDrawable = (BitmapDrawable) gifView.getResources().getDrawable(n.e.loading);
        if (bitmapDrawable != null) {
            auj = bitmapDrawable.getBitmap();
        }
        return auj;
    }

    public com.baidu.adp.gif.b getGif() {
        if (this.GA == null) {
            onStop();
            return null;
        }
        return this.GA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStop() {
        if (this.aud != null && !this.aut) {
            this.aud.onStop();
            this.aut = true;
        }
    }
}
