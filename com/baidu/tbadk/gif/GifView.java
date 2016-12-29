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
import com.baidu.tbadk.util.g;
import com.baidu.tieba.r;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public class GifView extends ImageView implements View.OnClickListener, i, Runnable {
    public static Bitmap axP;
    private com.baidu.adp.gif.b Ar;
    private final int axH;
    private int axI;
    private a axJ;
    private boolean axK;
    private BitmapDrawable axL;
    private boolean axM;
    private Drawable axN;
    private float axO;
    private float axQ;
    private boolean axR;
    private Drawable axS;
    private int axT;
    private final Rect axU;
    private final Rect axV;
    private boolean axW;
    private boolean axX;
    private boolean axY;
    private boolean axZ;
    private boolean aya;
    private com.baidu.tbadk.gif.a ayb;
    private boolean ayc;
    private BdUniqueId ayd;
    private final com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> aye;
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
        this.axH = r.f.pic_expression_upload_selector;
        this.axK = false;
        this.axU = new Rect();
        this.axV = new Rect();
        this.axW = true;
        this.axX = false;
        this.axY = false;
        this.axZ = false;
        this.mHandler = new b(this, Looper.getMainLooper());
        this.mType = 20;
        this.ayc = true;
        this.aye = new c(this);
        this.axL = (BitmapDrawable) getResources().getDrawable(r.f.icon_content_animation);
        this.axL.setBounds(0, 0, this.axL.getIntrinsicWidth(), this.axL.getIntrinsicHeight());
        this.axQ = 30.0f;
        if (((BitmapDrawable) getResources().getDrawable(r.f.loading)) != null) {
            axP = a(this);
            this.axV.set(0, 0, axP.getWidth(), axP.getHeight());
        }
        this.axN = getResources().getDrawable(r.f.image_group_load_f);
        e(this.axN);
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
                this.axU.set(i7, i8, i7 + i6, i6 + i8);
            }
            int intrinsicWidth = this.axN.getIntrinsicWidth();
            int intrinsicHeight = this.axN.getIntrinsicHeight();
            if (intrinsicWidth > i5) {
                intrinsicWidth = i5;
            }
            if (intrinsicHeight > paddingBottom) {
                intrinsicHeight = paddingBottom;
            }
            int i9 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
            int i10 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
            this.axN.setBounds(i9, i10, intrinsicWidth + i9, intrinsicHeight + i10);
            if (this.axS != null) {
                int intrinsicWidth2 = this.axS.getIntrinsicWidth();
                int intrinsicHeight2 = this.axS.getIntrinsicHeight();
                if (intrinsicWidth2 > i5) {
                    intrinsicWidth2 = i5;
                }
                if (intrinsicHeight2 > paddingBottom) {
                    intrinsicHeight2 = paddingBottom;
                }
                int i11 = ((i5 - intrinsicWidth2) / 2) + paddingLeft;
                int i12 = ((paddingBottom - intrinsicHeight2) / 2) + paddingTop;
                this.axS.setBounds(i11, i12, intrinsicWidth2 + i11, intrinsicHeight2 + i12);
            }
        }
    }

    public void release() {
        if (this.axY && this.Ar != null && this.Ar != null) {
            this.Ar.close();
            this.Ar = null;
        }
    }

    public void setGif(com.baidu.adp.widget.a.a aVar) {
        this.axM = false;
        this.mIsLoading = false;
        this.axR = false;
        if (this.ayb != null) {
            this.ayb.axB = false;
        }
        if (aVar == null) {
            this.axM = true;
            this.axK = false;
            if (this.ayb != null) {
                this.ayb.axB = true;
            }
            setImageDrawable(null);
            if (this.Ar != null) {
                this.Ar.close();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.jT()) {
                this.axK = true;
                aVar.e(this);
                this.mIsLoading = false;
            }
            if (this.Ar != null) {
                this.Ar.close();
            }
        } else if (this.Ar == null || !aVar.getGif().equals(this.Ar)) {
            this.axK = false;
            try {
                if (this.mBitmap == null || (this.mBitmap.getWidth() != aVar.getGif().getWidth() && this.mBitmap.getHeight() != aVar.getGif().getHeight())) {
                    this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
                }
                this.Ar = aVar.getGif();
                aVar.getGif().V(0);
                aVar.getGif().a(this.mBitmap, null);
                setImageBitmap(this.mBitmap);
                if (this.axW) {
                    play();
                }
            } catch (Throwable th) {
                onStop();
            }
        } else {
            aVar.getGif().V(this.axI);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.axW) {
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
        this.axY = true;
        setGif(e8);
    }

    public boolean getAutoPlay() {
        return this.axW;
    }

    public void setAutoPlay(boolean z) {
        this.axW = z;
    }

    public void resume() {
        this.axZ = false;
        com.baidu.adp.gif.b gif = getGif();
        if (gif != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, gif.W(this.axI));
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
        this.axZ = false;
        com.baidu.adp.gif.b gif = getGif();
        if (gif != null) {
            if (this.axI != 0) {
                this.axI = 0;
            }
            gif.V(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, gif.W(this.axI));
        }
    }

    public void DS() {
        this.aya = true;
        play();
    }

    public void onDestroy() {
        this.Ar = null;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandler.removeMessages(1);
        DU();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.mHandler.removeMessages(1);
        DU();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (!this.axK) {
            if (i == 4 || i == 8) {
                stop();
            } else if (i == 0) {
                play();
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (!this.mIsLoading && !this.axM && !this.axR) {
            super.onDraw(canvas);
        }
        canvas.save();
        try {
            if (this.Ar != null && !this.mIsLoading && !this.axM && !this.axR) {
                this.Ar.a(null, canvas);
            }
        } catch (Throwable th) {
            BdLog.e("setGif:" + th.getMessage());
            onStop();
        }
        canvas.restore();
        if (this.axK) {
            canvas.save();
            this.axL.draw(canvas);
            canvas.restore();
        }
        if (this.mIsLoading && a(this) != null) {
            canvas.save();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            canvas.rotate(this.axO, (width * 0.5f) + getPaddingLeft(), (height * 0.5f) + getPaddingTop());
            canvas.drawBitmap(a(this), this.axV, this.axU, (Paint) null);
            canvas.restore();
        } else if (this.axM || (this.ayb != null && this.ayb.axB)) {
            canvas.save();
            this.axN.draw(canvas);
            canvas.restore();
        } else if (this.axR) {
            canvas.save();
            this.axS.draw(canvas);
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
            DT();
        }
    }

    public void d(boolean z, int i) {
        this.axR = z;
        if (z) {
            this.mIsLoading = false;
            this.axM = false;
            if (this.axS == null || this.axT != i) {
                this.axT = i;
                this.axS = ar.getDrawable(i);
                int intrinsicWidth = this.axS.getIntrinsicWidth();
                int intrinsicHeight = this.axS.getIntrinsicHeight();
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
                this.axS.setBounds(paddingLeft, paddingTop, intrinsicWidth + paddingLeft, intrinsicHeight + paddingTop);
            }
        }
        invalidate();
    }

    public void stopLoading() {
        this.mIsLoading = false;
        removeCallbacks(this);
        invalidate();
    }

    private void DT() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.axO += this.axQ;
        if (this.axO > 360.0f - this.axQ) {
            this.axO = 0.0f;
        }
        invalidate();
        DT();
    }

    public void setPlayCallback(a aVar) {
        this.axJ = aVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.axS != null && this.axS.isStateful()) {
            this.axS.setState(getDrawableState());
            invalidate();
        }
    }

    public void a(com.baidu.tbadk.gif.a aVar) {
        BdUniqueId bdUniqueId;
        boolean z;
        if (aVar == null) {
            this.ayb = null;
            return;
        }
        boolean Gu = g.Gu();
        k A = l.A(getContext());
        if (A != null) {
            bdUniqueId = A.getUniqueId();
            z = A.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        if (!(aVar == this.ayb && this.ayd == bdUniqueId)) {
            DU();
        }
        this.ayb = aVar;
        this.ayd = bdUniqueId;
        String str = Gu ? this.ayb.axE : this.ayb.axD;
        com.baidu.adp.widget.a.a aVar2 = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.g.c.eA().a(this.ayb.axC, 20, this.ayb.mGid, this.ayb.axC, Boolean.valueOf(Gu), str);
        if (aVar2 != null) {
            stopLoading();
            setGif(aVar2);
        } else if (this.ayb.axB) {
            setGif(null);
        } else if (!com.baidu.adp.lib.g.c.eA().am(20) && this.ayc) {
            d(true, this.axH);
        } else if (!z) {
            com.baidu.adp.lib.g.c.eA().a(this.ayb.axC, 20, this.aye);
            startLoading();
            com.baidu.adp.lib.g.c.eA().a(this.ayb.axC, 20, this.aye, 0, 0, this.ayd, this.ayb.mGid, this.ayb.axC, Boolean.valueOf(Gu), str);
        }
    }

    public void DU() {
        stopLoading();
        this.axM = false;
        this.axR = false;
        if (this.ayb != null) {
            com.baidu.adp.lib.g.c.eA().a(this.ayb.axC, 20, this.aye);
        }
    }

    @Override // com.baidu.adp.newwidget.a.i
    public void refresh() {
        a(this.ayb);
    }

    public void setSupportNoImage(boolean z) {
        this.ayc = z;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(this);
        this.mOnClickListener = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ayb != null) {
            boolean Gu = g.Gu();
            String str = Gu ? this.ayb.axE : this.ayb.axD;
            com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.g.c.eA().a(this.ayb.axC, 20, this.ayb.mGid, this.ayb.axC, Boolean.valueOf(Gu), str);
            if (aVar != null) {
                this.ayb.axB = false;
                setGif(aVar);
            } else {
                startLoading();
                com.baidu.adp.lib.g.c.eA().a(this.ayb.axC, 20, this.aye, 0, 0, this.ayd, this.ayb.mGid, this.ayb.axC, Boolean.valueOf(Gu), str);
                return;
            }
        }
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    public void setIsKeepLastFrame(boolean z) {
        this.axX = z;
    }

    public static Bitmap a(GifView gifView) {
        if (axP != null && !axP.isRecycled()) {
            return axP;
        }
        BitmapDrawable bitmapDrawable = (BitmapDrawable) gifView.getResources().getDrawable(r.f.loading);
        if (bitmapDrawable != null) {
            axP = bitmapDrawable.getBitmap();
        }
        return axP;
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
        if (this.axJ != null && !this.axZ) {
            this.axJ.onStop();
            this.axZ = true;
        }
    }
}
