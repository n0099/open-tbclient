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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.util.h;
import com.baidu.tieba.u;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public class GifView extends ImageView implements View.OnClickListener, i, Runnable {
    public static Bitmap auc;
    private BdUniqueId aeu;
    private final int atU;
    private int atV;
    private a atW;
    private boolean atX;
    private BitmapDrawable atY;
    private boolean atZ;
    private Drawable aua;
    private float aub;
    private float aud;
    private boolean aue;
    private Drawable auf;
    private int aug;
    private final Rect auh;
    private final Rect aui;
    private boolean auj;
    private boolean auk;
    private boolean aul;
    private boolean aum;
    private boolean aun;
    private com.baidu.tbadk.gif.a auo;
    private boolean aup;
    private final com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> auq;
    private Bitmap mBitmap;
    private final Handler mHandler;
    private boolean mIsLoading;
    private View.OnClickListener mOnClickListener;
    private final int mType;
    private com.baidu.adp.gif.b xD;

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
        this.atU = u.f.pic_expression_upload_selector;
        this.atX = false;
        this.auh = new Rect();
        this.aui = new Rect();
        this.auj = true;
        this.auk = false;
        this.aul = false;
        this.aum = false;
        this.mHandler = new b(this, Looper.getMainLooper());
        this.mType = 20;
        this.aup = true;
        this.auq = new c(this);
        this.atY = (BitmapDrawable) getResources().getDrawable(u.f.icon_content_animation);
        this.atY.setBounds(0, 0, this.atY.getIntrinsicWidth(), this.atY.getIntrinsicHeight());
        this.aud = 30.0f;
        if (((BitmapDrawable) getResources().getDrawable(u.f.loading)) != null) {
            auc = a(this);
            this.aui.set(0, 0, auc.getWidth(), auc.getHeight());
        }
        this.aua = getResources().getDrawable(u.f.image_group_load_f);
        c(this.aua);
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
                this.auh.set(i7, i8, i7 + i6, i6 + i8);
            }
            int intrinsicWidth = this.aua.getIntrinsicWidth();
            int intrinsicHeight = this.aua.getIntrinsicHeight();
            if (intrinsicWidth > i5) {
                intrinsicWidth = i5;
            }
            if (intrinsicHeight > paddingBottom) {
                intrinsicHeight = paddingBottom;
            }
            int i9 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
            int i10 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
            this.aua.setBounds(i9, i10, intrinsicWidth + i9, intrinsicHeight + i10);
            if (this.auf != null) {
                int intrinsicWidth2 = this.auf.getIntrinsicWidth();
                int intrinsicHeight2 = this.auf.getIntrinsicHeight();
                if (intrinsicWidth2 > i5) {
                    intrinsicWidth2 = i5;
                }
                if (intrinsicHeight2 > paddingBottom) {
                    intrinsicHeight2 = paddingBottom;
                }
                int i11 = ((i5 - intrinsicWidth2) / 2) + paddingLeft;
                int i12 = ((paddingBottom - intrinsicHeight2) / 2) + paddingTop;
                this.auf.setBounds(i11, i12, intrinsicWidth2 + i11, intrinsicHeight2 + i12);
            }
        }
    }

    public void release() {
        if (this.aul && this.xD != null && this.xD != null) {
            this.xD.close();
            this.xD = null;
        }
    }

    public void setGif(com.baidu.adp.widget.a.a aVar) {
        this.atZ = false;
        this.mIsLoading = false;
        this.aue = false;
        if (this.auo != null) {
            this.auo.atO = false;
        }
        if (aVar == null) {
            this.atZ = true;
            this.atX = false;
            if (this.auo != null) {
                this.auo.atO = true;
            }
            setImageDrawable(null);
            if (this.xD != null) {
                this.xD.close();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.iZ()) {
                this.atX = true;
                aVar.a(this);
                this.mIsLoading = false;
            }
            if (this.xD != null) {
                this.xD.close();
            }
        } else if (this.xD == null || !aVar.getGif().equals(this.xD)) {
            this.atX = false;
            try {
                if (this.mBitmap == null || (this.mBitmap.getWidth() != aVar.getGif().getWidth() && this.mBitmap.getHeight() != aVar.getGif().getHeight())) {
                    this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
                }
                this.xD = aVar.getGif();
                aVar.getGif().E(0);
                aVar.getGif().a(this.mBitmap, null);
                setImageBitmap(this.mBitmap);
                if (this.auj) {
                    play();
                }
            } catch (Throwable th) {
                onStop();
            }
        } else {
            aVar.getGif().E(this.atV);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.auj) {
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
        com.baidu.adp.widget.a.a d = a.C0004a.bC().d(bArr, 0, i2);
        this.aul = true;
        setGif(d);
    }

    public boolean getAutoPlay() {
        return this.auj;
    }

    public void setAutoPlay(boolean z) {
        this.auj = z;
    }

    public void resume() {
        this.aum = false;
        com.baidu.adp.gif.b gif = getGif();
        if (gif != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, gif.F(this.atV));
        }
    }

    public void stop() {
        com.baidu.adp.gif.b gif = getGif();
        if (gif != null) {
            this.mHandler.removeMessages(1);
            gif.E(0);
            gif.a(this.mBitmap, null);
            invalidate();
            onStop();
        }
    }

    public void play() {
        this.aum = false;
        com.baidu.adp.gif.b gif = getGif();
        if (gif != null) {
            if (this.atV != 0) {
                this.atV = 0;
            }
            gif.E(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, gif.F(this.atV));
        }
    }

    public void CL() {
        this.aun = true;
        play();
    }

    public void onDestroy() {
        this.xD = null;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandler.removeMessages(1);
        CN();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.mHandler.removeMessages(1);
        CN();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (!this.atX) {
            if (i == 4 || i == 8) {
                stop();
            } else if (i == 0) {
                play();
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (!this.mIsLoading && !this.atZ && !this.aue) {
            super.onDraw(canvas);
        }
        canvas.save();
        try {
            if (this.xD != null && !this.mIsLoading && !this.atZ && !this.aue) {
                this.xD.a(null, canvas);
            }
        } catch (Throwable th) {
            BdLog.e("setGif:" + th.getMessage());
            onStop();
        }
        canvas.restore();
        if (this.atX) {
            canvas.save();
            this.atY.draw(canvas);
            canvas.restore();
        }
        if (this.mIsLoading && a(this) != null) {
            canvas.save();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            canvas.rotate(this.aub, (width * 0.5f) + getPaddingLeft(), (height * 0.5f) + getPaddingTop());
            canvas.drawBitmap(a(this), this.aui, this.auh, (Paint) null);
            canvas.restore();
        } else if (this.atZ || (this.auo != null && this.auo.atO)) {
            canvas.save();
            this.aua.draw(canvas);
            canvas.restore();
        } else if (this.aue) {
            canvas.save();
            this.auf.draw(canvas);
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
            CM();
        }
    }

    public void b(boolean z, int i) {
        this.aue = z;
        if (z) {
            this.mIsLoading = false;
            this.atZ = false;
            if (this.auf == null || this.aug != i) {
                this.aug = i;
                this.auf = av.getDrawable(i);
                int intrinsicWidth = this.auf.getIntrinsicWidth();
                int intrinsicHeight = this.auf.getIntrinsicHeight();
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
                this.auf.setBounds(paddingLeft, paddingTop, intrinsicWidth + paddingLeft, intrinsicHeight + paddingTop);
            }
        }
        invalidate();
    }

    public void stopLoading() {
        this.mIsLoading = false;
        removeCallbacks(this);
        invalidate();
    }

    private void CM() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aub += this.aud;
        if (this.aub > 360.0f - this.aud) {
            this.aub = 0.0f;
        }
        invalidate();
        CM();
    }

    public void setPlayCallback(a aVar) {
        this.atW = aVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.auf != null && this.auf.isStateful()) {
            this.auf.setState(getDrawableState());
            invalidate();
        }
    }

    public void a(com.baidu.tbadk.gif.a aVar) {
        BdUniqueId bdUniqueId;
        boolean z;
        if (aVar == null) {
            this.auo = null;
            return;
        }
        boolean FB = h.FB();
        k q = l.q(getContext());
        if (q != null) {
            bdUniqueId = q.getUniqueId();
            z = q.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        if (!(aVar == this.auo && this.aeu == bdUniqueId)) {
            CN();
        }
        this.auo = aVar;
        this.aeu = bdUniqueId;
        String str = FB ? this.auo.atR : this.auo.atQ;
        com.baidu.adp.widget.a.a aVar2 = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.g.c.dG().a(this.auo.atP, 20, this.auo.mGid, this.auo.atP, Boolean.valueOf(FB), str);
        if (aVar2 != null) {
            stopLoading();
            setGif(aVar2);
        } else if (this.auo.atO) {
            setGif(null);
        } else if (!com.baidu.adp.lib.g.c.dG().V(20) && this.aup) {
            b(true, this.atU);
        } else {
            startLoading();
            if (!z) {
                com.baidu.adp.lib.g.c.dG().a(this.auo.atP, 20, this.auq, 0, 0, this.aeu, this.auo.mGid, this.auo.atP, Boolean.valueOf(FB), str);
            }
        }
    }

    public void CN() {
        stopLoading();
        this.atZ = false;
        this.aue = false;
        if (this.auo != null) {
            com.baidu.adp.lib.g.c.dG().a(this.auo.atP, 20, this.auq);
        }
    }

    @Override // com.baidu.adp.newwidget.a.i
    public void refresh() {
        a(this.auo);
    }

    public void setSupportNoImage(boolean z) {
        this.aup = z;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(this);
        this.mOnClickListener = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.auo != null) {
            boolean FB = h.FB();
            String str = FB ? this.auo.atR : this.auo.atQ;
            com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.g.c.dG().a(this.auo.atP, 20, this.auo.mGid, this.auo.atP, Boolean.valueOf(FB), str);
            if (aVar != null) {
                this.auo.atO = false;
                setGif(aVar);
            } else {
                startLoading();
                com.baidu.adp.lib.g.c.dG().a(this.auo.atP, 20, this.auq, 0, 0, this.aeu, this.auo.mGid, this.auo.atP, Boolean.valueOf(FB), str);
                return;
            }
        }
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    public void setIsKeepLastFrame(boolean z) {
        this.auk = z;
    }

    public static Bitmap a(GifView gifView) {
        if (auc != null && !auc.isRecycled()) {
            return auc;
        }
        BitmapDrawable bitmapDrawable = (BitmapDrawable) gifView.getResources().getDrawable(u.f.loading);
        if (bitmapDrawable != null) {
            auc = bitmapDrawable.getBitmap();
        }
        return auc;
    }

    public com.baidu.adp.gif.b getGif() {
        if (this.xD == null) {
            onStop();
            return null;
        }
        return this.xD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStop() {
        if (this.atW != null && !this.aum) {
            this.atW.onStop();
            this.aum = true;
        }
    }
}
