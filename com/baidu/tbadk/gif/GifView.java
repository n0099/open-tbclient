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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.util.h;
import com.baidu.tieba.t;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public class GifView extends ImageView implements View.OnClickListener, i, Runnable {
    public static Bitmap axl;
    private com.baidu.adp.gif.b Hj;
    private final com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> axA;
    private final int axd;
    private int axe;
    private a axf;
    private boolean axg;
    private BitmapDrawable axh;
    private boolean axi;
    private Drawable axj;
    private float axk;
    private float axm;
    private boolean axn;
    private Drawable axo;
    private int axp;
    private final Rect axq;
    private final Rect axr;
    private boolean axs;
    private boolean axt;
    private boolean axu;
    private boolean axv;
    private boolean axw;
    private com.baidu.tbadk.gif.a axx;
    private boolean axy;
    private BdUniqueId axz;
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
        this.axd = t.f.pic_expression_upload_selector;
        this.axg = false;
        this.axq = new Rect();
        this.axr = new Rect();
        this.axs = true;
        this.axt = false;
        this.axu = false;
        this.axv = false;
        this.mHandler = new b(this, Looper.getMainLooper());
        this.mType = 20;
        this.axy = true;
        this.axA = new c(this);
        this.axh = (BitmapDrawable) getResources().getDrawable(t.f.icon_content_animation);
        this.axh.setBounds(0, 0, this.axh.getIntrinsicWidth(), this.axh.getIntrinsicHeight());
        this.axm = 30.0f;
        if (((BitmapDrawable) getResources().getDrawable(t.f.loading)) != null) {
            axl = a(this);
            this.axr.set(0, 0, axl.getWidth(), axl.getHeight());
        }
        this.axj = getResources().getDrawable(t.f.image_group_load_f);
        c(this.axj);
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
                this.axq.set(i7, i8, i7 + i6, i6 + i8);
            }
            int intrinsicWidth = this.axj.getIntrinsicWidth();
            int intrinsicHeight = this.axj.getIntrinsicHeight();
            if (intrinsicWidth > i5) {
                intrinsicWidth = i5;
            }
            if (intrinsicHeight > paddingBottom) {
                intrinsicHeight = paddingBottom;
            }
            int i9 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
            int i10 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
            this.axj.setBounds(i9, i10, intrinsicWidth + i9, intrinsicHeight + i10);
            if (this.axo != null) {
                int intrinsicWidth2 = this.axo.getIntrinsicWidth();
                int intrinsicHeight2 = this.axo.getIntrinsicHeight();
                if (intrinsicWidth2 > i5) {
                    intrinsicWidth2 = i5;
                }
                if (intrinsicHeight2 > paddingBottom) {
                    intrinsicHeight2 = paddingBottom;
                }
                int i11 = ((i5 - intrinsicWidth2) / 2) + paddingLeft;
                int i12 = ((paddingBottom - intrinsicHeight2) / 2) + paddingTop;
                this.axo.setBounds(i11, i12, intrinsicWidth2 + i11, intrinsicHeight2 + i12);
            }
        }
    }

    public void release() {
        if (this.axu && this.Hj != null && this.Hj != null) {
            this.Hj.close();
            this.Hj = null;
        }
    }

    public void setGif(com.baidu.adp.widget.a.a aVar) {
        this.axi = false;
        this.mIsLoading = false;
        this.axn = false;
        if (this.axx != null) {
            this.axx.awX = false;
        }
        if (aVar == null) {
            this.axi = true;
            this.axg = false;
            if (this.axx != null) {
                this.axx.awX = true;
            }
            setImageDrawable(null);
            if (this.Hj != null) {
                this.Hj.close();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.mI()) {
                this.axg = true;
                aVar.a(this);
                this.mIsLoading = false;
            }
            if (this.Hj != null) {
                this.Hj.close();
            }
        } else if (this.Hj == null || !aVar.getGif().equals(this.Hj)) {
            this.axg = false;
            try {
                if (this.mBitmap == null || (this.mBitmap.getWidth() != aVar.getGif().getWidth() && this.mBitmap.getHeight() != aVar.getGif().getHeight())) {
                    this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
                }
                this.Hj = aVar.getGif();
                aVar.getGif().Q(0);
                aVar.getGif().a(this.mBitmap, null);
                setImageBitmap(this.mBitmap);
                if (this.axs) {
                    play();
                }
            } catch (Throwable th) {
                onStop();
            }
        } else {
            aVar.getGif().Q(this.axe);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.axs) {
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
        com.baidu.adp.widget.a.a d = a.C0004a.fn().d(bArr, 0, i2);
        this.axu = true;
        setGif(d);
    }

    public boolean getAutoPlay() {
        return this.axs;
    }

    public void setAutoPlay(boolean z) {
        this.axs = z;
    }

    public void resume() {
        this.axv = false;
        com.baidu.adp.gif.b gif = getGif();
        if (gif != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, gif.R(this.axe));
        }
    }

    public void stop() {
        com.baidu.adp.gif.b gif = getGif();
        if (gif != null) {
            this.mHandler.removeMessages(1);
            gif.Q(0);
            gif.a(this.mBitmap, null);
            invalidate();
            onStop();
        }
    }

    public void play() {
        this.axv = false;
        com.baidu.adp.gif.b gif = getGif();
        if (gif != null) {
            if (this.axe != 0) {
                this.axe = 0;
            }
            gif.Q(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, gif.R(this.axe));
        }
    }

    public void EJ() {
        this.axw = true;
        play();
    }

    public void onDestroy() {
        this.Hj = null;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandler.removeMessages(1);
        EL();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.mHandler.removeMessages(1);
        EL();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (!this.axg) {
            if (i == 4 || i == 8) {
                stop();
            } else if (i == 0) {
                play();
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (!this.mIsLoading && !this.axi && !this.axn) {
            super.onDraw(canvas);
        }
        canvas.save();
        try {
            if (this.Hj != null && !this.mIsLoading && !this.axi && !this.axn) {
                this.Hj.a(null, canvas);
            }
        } catch (Throwable th) {
            BdLog.e("setGif:" + th.getMessage());
            onStop();
        }
        canvas.restore();
        if (this.axg) {
            canvas.save();
            this.axh.draw(canvas);
            canvas.restore();
        }
        if (this.mIsLoading && a(this) != null) {
            canvas.save();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            canvas.rotate(this.axk, (width * 0.5f) + getPaddingLeft(), (height * 0.5f) + getPaddingTop());
            canvas.drawBitmap(a(this), this.axr, this.axq, (Paint) null);
            canvas.restore();
        } else if (this.axi || (this.axx != null && this.axx.awX)) {
            canvas.save();
            this.axj.draw(canvas);
            canvas.restore();
        } else if (this.axn) {
            canvas.save();
            this.axo.draw(canvas);
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
            EK();
        }
    }

    public void c(boolean z, int i) {
        this.axn = z;
        if (z) {
            this.mIsLoading = false;
            this.axi = false;
            if (this.axo == null || this.axp != i) {
                this.axp = i;
                this.axo = at.getDrawable(i);
                int intrinsicWidth = this.axo.getIntrinsicWidth();
                int intrinsicHeight = this.axo.getIntrinsicHeight();
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
                this.axo.setBounds(paddingLeft, paddingTop, intrinsicWidth + paddingLeft, intrinsicHeight + paddingTop);
            }
        }
        invalidate();
    }

    public void stopLoading() {
        this.mIsLoading = false;
        removeCallbacks(this);
        invalidate();
    }

    private void EK() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.axk += this.axm;
        if (this.axk > 360.0f - this.axm) {
            this.axk = 0.0f;
        }
        invalidate();
        EK();
    }

    public void setPlayCallback(a aVar) {
        this.axf = aVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.axo != null && this.axo.isStateful()) {
            this.axo.setState(getDrawableState());
            invalidate();
        }
    }

    public void a(com.baidu.tbadk.gif.a aVar) {
        BdUniqueId bdUniqueId;
        boolean z;
        if (aVar == null) {
            this.axx = null;
            return;
        }
        boolean Ht = h.Ht();
        k q = l.q(getContext());
        if (q != null) {
            bdUniqueId = q.getUniqueId();
            z = q.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        if (!(aVar == this.axx && this.axz == bdUniqueId)) {
            EL();
        }
        this.axx = aVar;
        this.axz = bdUniqueId;
        String str = Ht ? this.axx.axa : this.axx.awZ;
        com.baidu.adp.widget.a.a aVar2 = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.g.c.hr().a(this.axx.awY, 20, this.axx.mGid, this.axx.awY, Boolean.valueOf(Ht), str);
        if (aVar2 != null) {
            stopLoading();
            setGif(aVar2);
        } else if (this.axx.awX) {
            setGif(null);
        } else if (!com.baidu.adp.lib.g.c.hr().ah(20) && this.axy) {
            c(true, this.axd);
        } else {
            startLoading();
            if (!z) {
                com.baidu.adp.lib.g.c.hr().a(this.axx.awY, 20, this.axA, 0, 0, this.axz, this.axx.mGid, this.axx.awY, Boolean.valueOf(Ht), str);
            }
        }
    }

    public void EL() {
        stopLoading();
        this.axi = false;
        this.axn = false;
        if (this.axx != null) {
            com.baidu.adp.lib.g.c.hr().a(this.axx.awY, 20, this.axA);
        }
    }

    @Override // com.baidu.adp.newwidget.a.i
    public void refresh() {
        a(this.axx);
    }

    public void setSupportNoImage(boolean z) {
        this.axy = z;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(this);
        this.mOnClickListener = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.axx != null) {
            boolean Ht = h.Ht();
            String str = Ht ? this.axx.axa : this.axx.awZ;
            com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.g.c.hr().a(this.axx.awY, 20, this.axx.mGid, this.axx.awY, Boolean.valueOf(Ht), str);
            if (aVar != null) {
                this.axx.awX = false;
                setGif(aVar);
            } else {
                startLoading();
                com.baidu.adp.lib.g.c.hr().a(this.axx.awY, 20, this.axA, 0, 0, this.axz, this.axx.mGid, this.axx.awY, Boolean.valueOf(Ht), str);
                return;
            }
        }
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    public void setIsKeepLastFrame(boolean z) {
        this.axt = z;
    }

    public static Bitmap a(GifView gifView) {
        if (axl != null && !axl.isRecycled()) {
            return axl;
        }
        BitmapDrawable bitmapDrawable = (BitmapDrawable) gifView.getResources().getDrawable(t.f.loading);
        if (bitmapDrawable != null) {
            axl = bitmapDrawable.getBitmap();
        }
        return axl;
    }

    public com.baidu.adp.gif.b getGif() {
        if (this.Hj == null) {
            onStop();
            return null;
        }
        return this.Hj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStop() {
        if (this.axf != null && !this.axv) {
            this.axf.onStop();
            this.axv = true;
        }
    }
}
