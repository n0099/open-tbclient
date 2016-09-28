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
import com.baidu.tieba.r;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public class GifView extends ImageView implements View.OnClickListener, i, Runnable {
    public static Bitmap axB;
    private com.baidu.adp.gif.b Ar;
    private BdUniqueId ahL;
    private float axA;
    private float axC;
    private boolean axD;
    private Drawable axE;
    private int axF;
    private final Rect axG;
    private final Rect axH;
    private boolean axI;
    private boolean axJ;
    private boolean axK;
    private boolean axL;
    private boolean axM;
    private com.baidu.tbadk.gif.a axN;
    private boolean axO;
    private final com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> axP;
    private final int axt;
    private int axu;
    private a axv;
    private boolean axw;
    private BitmapDrawable axx;
    private boolean axy;
    private Drawable axz;
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
        this.axt = r.f.pic_expression_upload_selector;
        this.axw = false;
        this.axG = new Rect();
        this.axH = new Rect();
        this.axI = true;
        this.axJ = false;
        this.axK = false;
        this.axL = false;
        this.mHandler = new b(this, Looper.getMainLooper());
        this.mType = 20;
        this.axO = true;
        this.axP = new c(this);
        this.axx = (BitmapDrawable) getResources().getDrawable(r.f.icon_content_animation);
        this.axx.setBounds(0, 0, this.axx.getIntrinsicWidth(), this.axx.getIntrinsicHeight());
        this.axC = 30.0f;
        if (((BitmapDrawable) getResources().getDrawable(r.f.loading)) != null) {
            axB = a(this);
            this.axH.set(0, 0, axB.getWidth(), axB.getHeight());
        }
        this.axz = getResources().getDrawable(r.f.image_group_load_f);
        e(this.axz);
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
                this.axG.set(i7, i8, i7 + i6, i6 + i8);
            }
            int intrinsicWidth = this.axz.getIntrinsicWidth();
            int intrinsicHeight = this.axz.getIntrinsicHeight();
            if (intrinsicWidth > i5) {
                intrinsicWidth = i5;
            }
            if (intrinsicHeight > paddingBottom) {
                intrinsicHeight = paddingBottom;
            }
            int i9 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
            int i10 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
            this.axz.setBounds(i9, i10, intrinsicWidth + i9, intrinsicHeight + i10);
            if (this.axE != null) {
                int intrinsicWidth2 = this.axE.getIntrinsicWidth();
                int intrinsicHeight2 = this.axE.getIntrinsicHeight();
                if (intrinsicWidth2 > i5) {
                    intrinsicWidth2 = i5;
                }
                if (intrinsicHeight2 > paddingBottom) {
                    intrinsicHeight2 = paddingBottom;
                }
                int i11 = ((i5 - intrinsicWidth2) / 2) + paddingLeft;
                int i12 = ((paddingBottom - intrinsicHeight2) / 2) + paddingTop;
                this.axE.setBounds(i11, i12, intrinsicWidth2 + i11, intrinsicHeight2 + i12);
            }
        }
    }

    public void release() {
        if (this.axK && this.Ar != null && this.Ar != null) {
            this.Ar.close();
            this.Ar = null;
        }
    }

    public void setGif(com.baidu.adp.widget.a.a aVar) {
        this.axy = false;
        this.mIsLoading = false;
        this.axD = false;
        if (this.axN != null) {
            this.axN.axn = false;
        }
        if (aVar == null) {
            this.axy = true;
            this.axw = false;
            if (this.axN != null) {
                this.axN.axn = true;
            }
            setImageDrawable(null);
            if (this.Ar != null) {
                this.Ar.close();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.jT()) {
                this.axw = true;
                aVar.e(this);
                this.mIsLoading = false;
            }
            if (this.Ar != null) {
                this.Ar.close();
            }
        } else if (this.Ar == null || !aVar.getGif().equals(this.Ar)) {
            this.axw = false;
            try {
                if (this.mBitmap == null || (this.mBitmap.getWidth() != aVar.getGif().getWidth() && this.mBitmap.getHeight() != aVar.getGif().getHeight())) {
                    this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
                }
                this.Ar = aVar.getGif();
                aVar.getGif().U(0);
                aVar.getGif().a(this.mBitmap, null);
                setImageBitmap(this.mBitmap);
                if (this.axI) {
                    play();
                }
            } catch (Throwable th) {
                onStop();
            }
        } else {
            aVar.getGif().U(this.axu);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.axI) {
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
        com.baidu.adp.widget.a.a e8 = a.C0004a.cw().e(bArr, 0, i2);
        this.axK = true;
        setGif(e8);
    }

    public boolean getAutoPlay() {
        return this.axI;
    }

    public void setAutoPlay(boolean z) {
        this.axI = z;
    }

    public void resume() {
        this.axL = false;
        com.baidu.adp.gif.b gif = getGif();
        if (gif != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, gif.V(this.axu));
        }
    }

    public void stop() {
        com.baidu.adp.gif.b gif = getGif();
        if (gif != null) {
            this.mHandler.removeMessages(1);
            gif.U(0);
            gif.a(this.mBitmap, null);
            invalidate();
            onStop();
        }
    }

    public void play() {
        this.axL = false;
        com.baidu.adp.gif.b gif = getGif();
        if (gif != null) {
            if (this.axu != 0) {
                this.axu = 0;
            }
            gif.U(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, gif.V(this.axu));
        }
    }

    public void Ef() {
        this.axM = true;
        play();
    }

    public void onDestroy() {
        this.Ar = null;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandler.removeMessages(1);
        Eh();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.mHandler.removeMessages(1);
        Eh();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (!this.axw) {
            if (i == 4 || i == 8) {
                stop();
            } else if (i == 0) {
                play();
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (!this.mIsLoading && !this.axy && !this.axD) {
            super.onDraw(canvas);
        }
        canvas.save();
        try {
            if (this.Ar != null && !this.mIsLoading && !this.axy && !this.axD) {
                this.Ar.a(null, canvas);
            }
        } catch (Throwable th) {
            BdLog.e("setGif:" + th.getMessage());
            onStop();
        }
        canvas.restore();
        if (this.axw) {
            canvas.save();
            this.axx.draw(canvas);
            canvas.restore();
        }
        if (this.mIsLoading && a(this) != null) {
            canvas.save();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            canvas.rotate(this.axA, (width * 0.5f) + getPaddingLeft(), (height * 0.5f) + getPaddingTop());
            canvas.drawBitmap(a(this), this.axH, this.axG, (Paint) null);
            canvas.restore();
        } else if (this.axy || (this.axN != null && this.axN.axn)) {
            canvas.save();
            this.axz.draw(canvas);
            canvas.restore();
        } else if (this.axD) {
            canvas.save();
            this.axE.draw(canvas);
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
            Eg();
        }
    }

    public void d(boolean z, int i) {
        this.axD = z;
        if (z) {
            this.mIsLoading = false;
            this.axy = false;
            if (this.axE == null || this.axF != i) {
                this.axF = i;
                this.axE = av.getDrawable(i);
                int intrinsicWidth = this.axE.getIntrinsicWidth();
                int intrinsicHeight = this.axE.getIntrinsicHeight();
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
                this.axE.setBounds(paddingLeft, paddingTop, intrinsicWidth + paddingLeft, intrinsicHeight + paddingTop);
            }
        }
        invalidate();
    }

    public void stopLoading() {
        this.mIsLoading = false;
        removeCallbacks(this);
        invalidate();
    }

    private void Eg() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.axA += this.axC;
        if (this.axA > 360.0f - this.axC) {
            this.axA = 0.0f;
        }
        invalidate();
        Eg();
    }

    public void setPlayCallback(a aVar) {
        this.axv = aVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.axE != null && this.axE.isStateful()) {
            this.axE.setState(getDrawableState());
            invalidate();
        }
    }

    public void a(com.baidu.tbadk.gif.a aVar) {
        BdUniqueId bdUniqueId;
        boolean z;
        if (aVar == null) {
            this.axN = null;
            return;
        }
        boolean GV = h.GV();
        k A = l.A(getContext());
        if (A != null) {
            bdUniqueId = A.getUniqueId();
            z = A.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        if (!(aVar == this.axN && this.ahL == bdUniqueId)) {
            Eh();
        }
        this.axN = aVar;
        this.ahL = bdUniqueId;
        String str = GV ? this.axN.axq : this.axN.axp;
        com.baidu.adp.widget.a.a aVar2 = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.g.c.eA().a(this.axN.axo, 20, this.axN.mGid, this.axN.axo, Boolean.valueOf(GV), str);
        if (aVar2 != null) {
            stopLoading();
            setGif(aVar2);
        } else if (this.axN.axn) {
            setGif(null);
        } else if (!com.baidu.adp.lib.g.c.eA().al(20) && this.axO) {
            d(true, this.axt);
        } else {
            startLoading();
            if (!z) {
                com.baidu.adp.lib.g.c.eA().a(this.axN.axo, 20, this.axP, 0, 0, this.ahL, this.axN.mGid, this.axN.axo, Boolean.valueOf(GV), str);
            }
        }
    }

    public void Eh() {
        stopLoading();
        this.axy = false;
        this.axD = false;
        if (this.axN != null) {
            com.baidu.adp.lib.g.c.eA().a(this.axN.axo, 20, this.axP);
        }
    }

    @Override // com.baidu.adp.newwidget.a.i
    public void refresh() {
        a(this.axN);
    }

    public void setSupportNoImage(boolean z) {
        this.axO = z;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(this);
        this.mOnClickListener = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.axN != null) {
            boolean GV = h.GV();
            String str = GV ? this.axN.axq : this.axN.axp;
            com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.g.c.eA().a(this.axN.axo, 20, this.axN.mGid, this.axN.axo, Boolean.valueOf(GV), str);
            if (aVar != null) {
                this.axN.axn = false;
                setGif(aVar);
            } else {
                startLoading();
                com.baidu.adp.lib.g.c.eA().a(this.axN.axo, 20, this.axP, 0, 0, this.ahL, this.axN.mGid, this.axN.axo, Boolean.valueOf(GV), str);
                return;
            }
        }
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    public void setIsKeepLastFrame(boolean z) {
        this.axJ = z;
    }

    public static Bitmap a(GifView gifView) {
        if (axB != null && !axB.isRecycled()) {
            return axB;
        }
        BitmapDrawable bitmapDrawable = (BitmapDrawable) gifView.getResources().getDrawable(r.f.loading);
        if (bitmapDrawable != null) {
            axB = bitmapDrawable.getBitmap();
        }
        return axB;
    }

    public com.baidu.adp.gif.b getGif() {
        if (this.Ar == null) {
            onStop();
            return null;
        }
        return this.Ar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStop() {
        if (this.axv != null && !this.axL) {
            this.axv.onStop();
            this.axL = true;
        }
    }
}
