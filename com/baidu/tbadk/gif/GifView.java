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
    public static Bitmap atm;
    private BdUniqueId atA;
    private final com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> atB;
    private final int ate;
    private int atf;
    private a atg;
    private boolean ath;
    private BitmapDrawable ati;
    private boolean atj;
    private Drawable atk;
    private float atl;
    private float atn;
    private boolean ato;
    private Drawable atp;
    private int atq;
    private final Rect atr;
    private final Rect ats;
    private boolean att;
    private boolean atu;
    private boolean atv;
    private boolean atw;
    private boolean atx;
    private com.baidu.tbadk.gif.a aty;
    private boolean atz;
    private Bitmap mBitmap;
    private final Handler mHandler;
    private boolean mIsLoading;
    private View.OnClickListener mOnClickListener;
    private final int mType;
    private com.baidu.adp.gif.b xB;

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
        this.ate = t.f.pic_expression_upload_selector;
        this.ath = false;
        this.atr = new Rect();
        this.ats = new Rect();
        this.att = true;
        this.atu = false;
        this.atv = false;
        this.atw = false;
        this.mHandler = new b(this, Looper.getMainLooper());
        this.mType = 20;
        this.atz = true;
        this.atB = new c(this);
        this.ati = (BitmapDrawable) getResources().getDrawable(t.f.icon_content_animation);
        this.ati.setBounds(0, 0, this.ati.getIntrinsicWidth(), this.ati.getIntrinsicHeight());
        this.atn = 30.0f;
        if (((BitmapDrawable) getResources().getDrawable(t.f.loading)) != null) {
            atm = a(this);
            this.ats.set(0, 0, atm.getWidth(), atm.getHeight());
        }
        this.atk = getResources().getDrawable(t.f.image_group_load_f);
        c(this.atk);
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
                this.atr.set(i7, i8, i7 + i6, i6 + i8);
            }
            int intrinsicWidth = this.atk.getIntrinsicWidth();
            int intrinsicHeight = this.atk.getIntrinsicHeight();
            if (intrinsicWidth > i5) {
                intrinsicWidth = i5;
            }
            if (intrinsicHeight > paddingBottom) {
                intrinsicHeight = paddingBottom;
            }
            int i9 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
            int i10 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
            this.atk.setBounds(i9, i10, intrinsicWidth + i9, intrinsicHeight + i10);
            if (this.atp != null) {
                int intrinsicWidth2 = this.atp.getIntrinsicWidth();
                int intrinsicHeight2 = this.atp.getIntrinsicHeight();
                if (intrinsicWidth2 > i5) {
                    intrinsicWidth2 = i5;
                }
                if (intrinsicHeight2 > paddingBottom) {
                    intrinsicHeight2 = paddingBottom;
                }
                int i11 = ((i5 - intrinsicWidth2) / 2) + paddingLeft;
                int i12 = ((paddingBottom - intrinsicHeight2) / 2) + paddingTop;
                this.atp.setBounds(i11, i12, intrinsicWidth2 + i11, intrinsicHeight2 + i12);
            }
        }
    }

    public void release() {
        if (this.atv && this.xB != null && this.xB != null) {
            this.xB.close();
            this.xB = null;
        }
    }

    public void setGif(com.baidu.adp.widget.a.a aVar) {
        this.atj = false;
        this.mIsLoading = false;
        this.ato = false;
        if (this.aty != null) {
            this.aty.asY = false;
        }
        if (aVar == null) {
            this.atj = true;
            this.ath = false;
            if (this.aty != null) {
                this.aty.asY = true;
            }
            setImageDrawable(null);
            if (this.xB != null) {
                this.xB.close();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.iW()) {
                this.ath = true;
                aVar.a(this);
                this.mIsLoading = false;
            }
            if (this.xB != null) {
                this.xB.close();
            }
        } else if (this.xB == null || !aVar.getGif().equals(this.xB)) {
            this.ath = false;
            try {
                if (this.mBitmap == null || (this.mBitmap.getWidth() != aVar.getGif().getWidth() && this.mBitmap.getHeight() != aVar.getGif().getHeight())) {
                    this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
                }
                this.xB = aVar.getGif();
                aVar.getGif().E(0);
                aVar.getGif().a(this.mBitmap, null);
                setImageBitmap(this.mBitmap);
                if (this.att) {
                    play();
                }
            } catch (Throwable th) {
                onStop();
            }
        } else {
            aVar.getGif().E(this.atf);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.att) {
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
        com.baidu.adp.widget.a.a d = a.C0004a.bB().d(bArr, 0, i2);
        this.atv = true;
        setGif(d);
    }

    public boolean getAutoPlay() {
        return this.att;
    }

    public void setAutoPlay(boolean z) {
        this.att = z;
    }

    public void resume() {
        this.atw = false;
        com.baidu.adp.gif.b gif = getGif();
        if (gif != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, gif.F(this.atf));
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
        this.atw = false;
        com.baidu.adp.gif.b gif = getGif();
        if (gif != null) {
            if (this.atf != 0) {
                this.atf = 0;
            }
            gif.E(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, gif.F(this.atf));
        }
    }

    public void CC() {
        this.atx = true;
        play();
    }

    public void onDestroy() {
        this.xB = null;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandler.removeMessages(1);
        CE();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.mHandler.removeMessages(1);
        CE();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (!this.ath) {
            if (i == 4 || i == 8) {
                stop();
            } else if (i == 0) {
                play();
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (!this.mIsLoading && !this.atj && !this.ato) {
            super.onDraw(canvas);
        }
        canvas.save();
        try {
            if (this.xB != null && !this.mIsLoading && !this.atj && !this.ato) {
                this.xB.a(null, canvas);
            }
        } catch (Throwable th) {
            BdLog.e("setGif:" + th.getMessage());
            onStop();
        }
        canvas.restore();
        if (this.ath) {
            canvas.save();
            this.ati.draw(canvas);
            canvas.restore();
        }
        if (this.mIsLoading && a(this) != null) {
            canvas.save();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            canvas.rotate(this.atl, (width * 0.5f) + getPaddingLeft(), (height * 0.5f) + getPaddingTop());
            canvas.drawBitmap(a(this), this.ats, this.atr, (Paint) null);
            canvas.restore();
        } else if (this.atj || (this.aty != null && this.aty.asY)) {
            canvas.save();
            this.atk.draw(canvas);
            canvas.restore();
        } else if (this.ato) {
            canvas.save();
            this.atp.draw(canvas);
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
            CD();
        }
    }

    public void c(boolean z, int i) {
        this.ato = z;
        if (z) {
            this.mIsLoading = false;
            this.atj = false;
            if (this.atp == null || this.atq != i) {
                this.atq = i;
                this.atp = at.getDrawable(i);
                int intrinsicWidth = this.atp.getIntrinsicWidth();
                int intrinsicHeight = this.atp.getIntrinsicHeight();
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
                this.atp.setBounds(paddingLeft, paddingTop, intrinsicWidth + paddingLeft, intrinsicHeight + paddingTop);
            }
        }
        invalidate();
    }

    public void stopLoading() {
        this.mIsLoading = false;
        removeCallbacks(this);
        invalidate();
    }

    private void CD() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.atl += this.atn;
        if (this.atl > 360.0f - this.atn) {
            this.atl = 0.0f;
        }
        invalidate();
        CD();
    }

    public void setPlayCallback(a aVar) {
        this.atg = aVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.atp != null && this.atp.isStateful()) {
            this.atp.setState(getDrawableState());
            invalidate();
        }
    }

    public void a(com.baidu.tbadk.gif.a aVar) {
        BdUniqueId bdUniqueId;
        boolean z;
        if (aVar == null) {
            this.aty = null;
            return;
        }
        boolean Fr = h.Fr();
        k q = l.q(getContext());
        if (q != null) {
            bdUniqueId = q.getUniqueId();
            z = q.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        if (!(aVar == this.aty && this.atA == bdUniqueId)) {
            CE();
        }
        this.aty = aVar;
        this.atA = bdUniqueId;
        String str = Fr ? this.aty.atb : this.aty.ata;
        com.baidu.adp.widget.a.a aVar2 = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.g.c.dF().a(this.aty.asZ, 20, this.aty.mGid, this.aty.asZ, Boolean.valueOf(Fr), str);
        if (aVar2 != null) {
            stopLoading();
            setGif(aVar2);
        } else if (this.aty.asY) {
            setGif(null);
        } else if (!com.baidu.adp.lib.g.c.dF().V(20) && this.atz) {
            c(true, this.ate);
        } else {
            startLoading();
            if (!z) {
                com.baidu.adp.lib.g.c.dF().a(this.aty.asZ, 20, this.atB, 0, 0, this.atA, this.aty.mGid, this.aty.asZ, Boolean.valueOf(Fr), str);
            }
        }
    }

    public void CE() {
        stopLoading();
        this.atj = false;
        this.ato = false;
        if (this.aty != null) {
            com.baidu.adp.lib.g.c.dF().a(this.aty.asZ, 20, this.atB);
        }
    }

    @Override // com.baidu.adp.newwidget.a.i
    public void refresh() {
        a(this.aty);
    }

    public void setSupportNoImage(boolean z) {
        this.atz = z;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(this);
        this.mOnClickListener = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aty != null) {
            boolean Fr = h.Fr();
            String str = Fr ? this.aty.atb : this.aty.ata;
            com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.g.c.dF().a(this.aty.asZ, 20, this.aty.mGid, this.aty.asZ, Boolean.valueOf(Fr), str);
            if (aVar != null) {
                this.aty.asY = false;
                setGif(aVar);
            } else {
                startLoading();
                com.baidu.adp.lib.g.c.dF().a(this.aty.asZ, 20, this.atB, 0, 0, this.atA, this.aty.mGid, this.aty.asZ, Boolean.valueOf(Fr), str);
                return;
            }
        }
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    public void setIsKeepLastFrame(boolean z) {
        this.atu = z;
    }

    public static Bitmap a(GifView gifView) {
        if (atm != null && !atm.isRecycled()) {
            return atm;
        }
        BitmapDrawable bitmapDrawable = (BitmapDrawable) gifView.getResources().getDrawable(t.f.loading);
        if (bitmapDrawable != null) {
            atm = bitmapDrawable.getBitmap();
        }
        return atm;
    }

    public com.baidu.adp.gif.b getGif() {
        if (this.xB == null) {
            onStop();
            return null;
        }
        return this.xB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStop() {
        if (this.atg != null && !this.atw) {
            this.atg.onStop();
            this.atw = true;
        }
    }
}
