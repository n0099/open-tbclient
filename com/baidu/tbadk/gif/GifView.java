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
import com.baidu.tieba.t;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public class GifView extends ImageView implements View.OnClickListener, i, Runnable {
    public static Bitmap axY;
    private com.baidu.adp.gif.b Ar;
    private BdUniqueId aid;
    private final int axQ;
    private int axR;
    private a axS;
    private boolean axT;
    private BitmapDrawable axU;
    private boolean axV;
    private Drawable axW;
    private float axX;
    private float axZ;
    private boolean aya;
    private Drawable ayb;
    private int ayc;
    private final Rect ayd;
    private final Rect aye;
    private boolean ayf;
    private boolean ayg;
    private boolean ayh;
    private boolean ayi;
    private boolean ayj;
    private com.baidu.tbadk.gif.a ayk;
    private boolean ayl;
    private final com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> aym;
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
        this.axQ = t.f.pic_expression_upload_selector;
        this.axT = false;
        this.ayd = new Rect();
        this.aye = new Rect();
        this.ayf = true;
        this.ayg = false;
        this.ayh = false;
        this.ayi = false;
        this.mHandler = new b(this, Looper.getMainLooper());
        this.mType = 20;
        this.ayl = true;
        this.aym = new c(this);
        this.axU = (BitmapDrawable) getResources().getDrawable(t.f.icon_content_animation);
        this.axU.setBounds(0, 0, this.axU.getIntrinsicWidth(), this.axU.getIntrinsicHeight());
        this.axZ = 30.0f;
        if (((BitmapDrawable) getResources().getDrawable(t.f.loading)) != null) {
            axY = a(this);
            this.aye.set(0, 0, axY.getWidth(), axY.getHeight());
        }
        this.axW = getResources().getDrawable(t.f.image_group_load_f);
        e(this.axW);
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
                this.ayd.set(i7, i8, i7 + i6, i6 + i8);
            }
            int intrinsicWidth = this.axW.getIntrinsicWidth();
            int intrinsicHeight = this.axW.getIntrinsicHeight();
            if (intrinsicWidth > i5) {
                intrinsicWidth = i5;
            }
            if (intrinsicHeight > paddingBottom) {
                intrinsicHeight = paddingBottom;
            }
            int i9 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
            int i10 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
            this.axW.setBounds(i9, i10, intrinsicWidth + i9, intrinsicHeight + i10);
            if (this.ayb != null) {
                int intrinsicWidth2 = this.ayb.getIntrinsicWidth();
                int intrinsicHeight2 = this.ayb.getIntrinsicHeight();
                if (intrinsicWidth2 > i5) {
                    intrinsicWidth2 = i5;
                }
                if (intrinsicHeight2 > paddingBottom) {
                    intrinsicHeight2 = paddingBottom;
                }
                int i11 = ((i5 - intrinsicWidth2) / 2) + paddingLeft;
                int i12 = ((paddingBottom - intrinsicHeight2) / 2) + paddingTop;
                this.ayb.setBounds(i11, i12, intrinsicWidth2 + i11, intrinsicHeight2 + i12);
            }
        }
    }

    public void release() {
        if (this.ayh && this.Ar != null && this.Ar != null) {
            this.Ar.close();
            this.Ar = null;
        }
    }

    public void setGif(com.baidu.adp.widget.a.a aVar) {
        this.axV = false;
        this.mIsLoading = false;
        this.aya = false;
        if (this.ayk != null) {
            this.ayk.axK = false;
        }
        if (aVar == null) {
            this.axV = true;
            this.axT = false;
            if (this.ayk != null) {
                this.ayk.axK = true;
            }
            setImageDrawable(null);
            if (this.Ar != null) {
                this.Ar.close();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.jT()) {
                this.axT = true;
                aVar.e(this);
                this.mIsLoading = false;
            }
            if (this.Ar != null) {
                this.Ar.close();
            }
        } else if (this.Ar == null || !aVar.getGif().equals(this.Ar)) {
            this.axT = false;
            try {
                if (this.mBitmap == null || (this.mBitmap.getWidth() != aVar.getGif().getWidth() && this.mBitmap.getHeight() != aVar.getGif().getHeight())) {
                    this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
                }
                this.Ar = aVar.getGif();
                aVar.getGif().U(0);
                aVar.getGif().a(this.mBitmap, null);
                setImageBitmap(this.mBitmap);
                if (this.ayf) {
                    play();
                }
            } catch (Throwable th) {
                onStop();
            }
        } else {
            aVar.getGif().U(this.axR);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.ayf) {
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
        this.ayh = true;
        setGif(e8);
    }

    public boolean getAutoPlay() {
        return this.ayf;
    }

    public void setAutoPlay(boolean z) {
        this.ayf = z;
    }

    public void resume() {
        this.ayi = false;
        com.baidu.adp.gif.b gif = getGif();
        if (gif != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, gif.V(this.axR));
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
        this.ayi = false;
        com.baidu.adp.gif.b gif = getGif();
        if (gif != null) {
            if (this.axR != 0) {
                this.axR = 0;
            }
            gif.U(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, gif.V(this.axR));
        }
    }

    public void Ef() {
        this.ayj = true;
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
        if (!this.axT) {
            if (i == 4 || i == 8) {
                stop();
            } else if (i == 0) {
                play();
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (!this.mIsLoading && !this.axV && !this.aya) {
            super.onDraw(canvas);
        }
        canvas.save();
        try {
            if (this.Ar != null && !this.mIsLoading && !this.axV && !this.aya) {
                this.Ar.a(null, canvas);
            }
        } catch (Throwable th) {
            BdLog.e("setGif:" + th.getMessage());
            onStop();
        }
        canvas.restore();
        if (this.axT) {
            canvas.save();
            this.axU.draw(canvas);
            canvas.restore();
        }
        if (this.mIsLoading && a(this) != null) {
            canvas.save();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            canvas.rotate(this.axX, (width * 0.5f) + getPaddingLeft(), (height * 0.5f) + getPaddingTop());
            canvas.drawBitmap(a(this), this.aye, this.ayd, (Paint) null);
            canvas.restore();
        } else if (this.axV || (this.ayk != null && this.ayk.axK)) {
            canvas.save();
            this.axW.draw(canvas);
            canvas.restore();
        } else if (this.aya) {
            canvas.save();
            this.ayb.draw(canvas);
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

    public void c(boolean z, int i) {
        this.aya = z;
        if (z) {
            this.mIsLoading = false;
            this.axV = false;
            if (this.ayb == null || this.ayc != i) {
                this.ayc = i;
                this.ayb = av.getDrawable(i);
                int intrinsicWidth = this.ayb.getIntrinsicWidth();
                int intrinsicHeight = this.ayb.getIntrinsicHeight();
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
                this.ayb.setBounds(paddingLeft, paddingTop, intrinsicWidth + paddingLeft, intrinsicHeight + paddingTop);
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
        this.axX += this.axZ;
        if (this.axX > 360.0f - this.axZ) {
            this.axX = 0.0f;
        }
        invalidate();
        Eg();
    }

    public void setPlayCallback(a aVar) {
        this.axS = aVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.ayb != null && this.ayb.isStateful()) {
            this.ayb.setState(getDrawableState());
            invalidate();
        }
    }

    public void a(com.baidu.tbadk.gif.a aVar) {
        BdUniqueId bdUniqueId;
        boolean z;
        if (aVar == null) {
            this.ayk = null;
            return;
        }
        boolean GW = h.GW();
        k A = l.A(getContext());
        if (A != null) {
            bdUniqueId = A.getUniqueId();
            z = A.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        if (!(aVar == this.ayk && this.aid == bdUniqueId)) {
            Eh();
        }
        this.ayk = aVar;
        this.aid = bdUniqueId;
        String str = GW ? this.ayk.axN : this.ayk.axM;
        com.baidu.adp.widget.a.a aVar2 = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.g.c.eA().a(this.ayk.axL, 20, this.ayk.mGid, this.ayk.axL, Boolean.valueOf(GW), str);
        if (aVar2 != null) {
            stopLoading();
            setGif(aVar2);
        } else if (this.ayk.axK) {
            setGif(null);
        } else if (!com.baidu.adp.lib.g.c.eA().al(20) && this.ayl) {
            c(true, this.axQ);
        } else {
            startLoading();
            if (!z) {
                com.baidu.adp.lib.g.c.eA().a(this.ayk.axL, 20, this.aym, 0, 0, this.aid, this.ayk.mGid, this.ayk.axL, Boolean.valueOf(GW), str);
            }
        }
    }

    public void Eh() {
        stopLoading();
        this.axV = false;
        this.aya = false;
        if (this.ayk != null) {
            com.baidu.adp.lib.g.c.eA().a(this.ayk.axL, 20, this.aym);
        }
    }

    @Override // com.baidu.adp.newwidget.a.i
    public void refresh() {
        a(this.ayk);
    }

    public void setSupportNoImage(boolean z) {
        this.ayl = z;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(this);
        this.mOnClickListener = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ayk != null) {
            boolean GW = h.GW();
            String str = GW ? this.ayk.axN : this.ayk.axM;
            com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.g.c.eA().a(this.ayk.axL, 20, this.ayk.mGid, this.ayk.axL, Boolean.valueOf(GW), str);
            if (aVar != null) {
                this.ayk.axK = false;
                setGif(aVar);
            } else {
                startLoading();
                com.baidu.adp.lib.g.c.eA().a(this.ayk.axL, 20, this.aym, 0, 0, this.aid, this.ayk.mGid, this.ayk.axL, Boolean.valueOf(GW), str);
                return;
            }
        }
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    public void setIsKeepLastFrame(boolean z) {
        this.ayg = z;
    }

    public static Bitmap a(GifView gifView) {
        if (axY != null && !axY.isRecycled()) {
            return axY;
        }
        BitmapDrawable bitmapDrawable = (BitmapDrawable) gifView.getResources().getDrawable(t.f.loading);
        if (bitmapDrawable != null) {
            axY = bitmapDrawable.getBitmap();
        }
        return axY;
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
        if (this.axS != null && !this.ayi) {
            this.axS.onStop();
            this.ayi = true;
        }
    }
}
