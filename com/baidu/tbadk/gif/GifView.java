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
import com.baidu.tbadk.util.g;
import com.baidu.tieba.r;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public class GifView extends ImageView implements View.OnClickListener, i, Runnable {
    public static Bitmap ays;
    private com.baidu.adp.gif.b Ar;
    private boolean ayA;
    private boolean ayB;
    private boolean ayC;
    private boolean ayD;
    private com.baidu.tbadk.gif.a ayE;
    private boolean ayF;
    private BdUniqueId ayG;
    private final com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> ayH;
    private final int ayk;
    private int ayl;
    private a aym;
    private boolean ayn;
    private BitmapDrawable ayo;
    private boolean ayp;
    private Drawable ayq;
    private float ayr;
    private float ayt;
    private boolean ayu;
    private Drawable ayv;
    private int ayw;
    private final Rect ayx;
    private final Rect ayy;
    private boolean ayz;
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
        this.ayk = r.f.pic_expression_upload_selector;
        this.ayn = false;
        this.ayx = new Rect();
        this.ayy = new Rect();
        this.ayz = true;
        this.ayA = false;
        this.ayB = false;
        this.ayC = false;
        this.mHandler = new b(this, Looper.getMainLooper());
        this.mType = 20;
        this.ayF = true;
        this.ayH = new c(this);
        this.ayo = (BitmapDrawable) getResources().getDrawable(r.f.icon_content_animation);
        this.ayo.setBounds(0, 0, this.ayo.getIntrinsicWidth(), this.ayo.getIntrinsicHeight());
        this.ayt = 30.0f;
        if (((BitmapDrawable) getResources().getDrawable(r.f.loading)) != null) {
            ays = a(this);
            this.ayy.set(0, 0, ays.getWidth(), ays.getHeight());
        }
        this.ayq = getResources().getDrawable(r.f.image_group_load_f);
        e(this.ayq);
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
                this.ayx.set(i7, i8, i7 + i6, i6 + i8);
            }
            int intrinsicWidth = this.ayq.getIntrinsicWidth();
            int intrinsicHeight = this.ayq.getIntrinsicHeight();
            if (intrinsicWidth > i5) {
                intrinsicWidth = i5;
            }
            if (intrinsicHeight > paddingBottom) {
                intrinsicHeight = paddingBottom;
            }
            int i9 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
            int i10 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
            this.ayq.setBounds(i9, i10, intrinsicWidth + i9, intrinsicHeight + i10);
            if (this.ayv != null) {
                int intrinsicWidth2 = this.ayv.getIntrinsicWidth();
                int intrinsicHeight2 = this.ayv.getIntrinsicHeight();
                if (intrinsicWidth2 > i5) {
                    intrinsicWidth2 = i5;
                }
                if (intrinsicHeight2 > paddingBottom) {
                    intrinsicHeight2 = paddingBottom;
                }
                int i11 = ((i5 - intrinsicWidth2) / 2) + paddingLeft;
                int i12 = ((paddingBottom - intrinsicHeight2) / 2) + paddingTop;
                this.ayv.setBounds(i11, i12, intrinsicWidth2 + i11, intrinsicHeight2 + i12);
            }
        }
    }

    public void release() {
        if (this.ayB && this.Ar != null && this.Ar != null) {
            this.Ar.close();
            this.Ar = null;
        }
    }

    public void setGif(com.baidu.adp.widget.a.a aVar) {
        this.ayp = false;
        this.mIsLoading = false;
        this.ayu = false;
        if (this.ayE != null) {
            this.ayE.aye = false;
        }
        if (aVar == null) {
            this.ayp = true;
            this.ayn = false;
            if (this.ayE != null) {
                this.ayE.aye = true;
            }
            setImageDrawable(null);
            if (this.Ar != null) {
                this.Ar.close();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.jT()) {
                this.ayn = true;
                aVar.e(this);
                this.mIsLoading = false;
            }
            if (this.Ar != null) {
                this.Ar.close();
            }
        } else if (this.Ar == null || !aVar.getGif().equals(this.Ar)) {
            this.ayn = false;
            try {
                if (this.mBitmap == null || (this.mBitmap.getWidth() != aVar.getGif().getWidth() && this.mBitmap.getHeight() != aVar.getGif().getHeight())) {
                    this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
                }
                this.Ar = aVar.getGif();
                aVar.getGif().U(0);
                aVar.getGif().a(this.mBitmap, null);
                setImageBitmap(this.mBitmap);
                if (this.ayz) {
                    play();
                }
            } catch (Throwable th) {
                onStop();
            }
        } else {
            aVar.getGif().U(this.ayl);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.ayz) {
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
        this.ayB = true;
        setGif(e8);
    }

    public boolean getAutoPlay() {
        return this.ayz;
    }

    public void setAutoPlay(boolean z) {
        this.ayz = z;
    }

    public void resume() {
        this.ayC = false;
        com.baidu.adp.gif.b gif = getGif();
        if (gif != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, gif.V(this.ayl));
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
        this.ayC = false;
        com.baidu.adp.gif.b gif = getGif();
        if (gif != null) {
            if (this.ayl != 0) {
                this.ayl = 0;
            }
            gif.U(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, gif.V(this.ayl));
        }
    }

    public void Ek() {
        this.ayD = true;
        play();
    }

    public void onDestroy() {
        this.Ar = null;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandler.removeMessages(1);
        Em();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.mHandler.removeMessages(1);
        Em();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (!this.ayn) {
            if (i == 4 || i == 8) {
                stop();
            } else if (i == 0) {
                play();
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (!this.mIsLoading && !this.ayp && !this.ayu) {
            super.onDraw(canvas);
        }
        canvas.save();
        try {
            if (this.Ar != null && !this.mIsLoading && !this.ayp && !this.ayu) {
                this.Ar.a(null, canvas);
            }
        } catch (Throwable th) {
            BdLog.e("setGif:" + th.getMessage());
            onStop();
        }
        canvas.restore();
        if (this.ayn) {
            canvas.save();
            this.ayo.draw(canvas);
            canvas.restore();
        }
        if (this.mIsLoading && a(this) != null) {
            canvas.save();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            canvas.rotate(this.ayr, (width * 0.5f) + getPaddingLeft(), (height * 0.5f) + getPaddingTop());
            canvas.drawBitmap(a(this), this.ayy, this.ayx, (Paint) null);
            canvas.restore();
        } else if (this.ayp || (this.ayE != null && this.ayE.aye)) {
            canvas.save();
            this.ayq.draw(canvas);
            canvas.restore();
        } else if (this.ayu) {
            canvas.save();
            this.ayv.draw(canvas);
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
            El();
        }
    }

    public void d(boolean z, int i) {
        this.ayu = z;
        if (z) {
            this.mIsLoading = false;
            this.ayp = false;
            if (this.ayv == null || this.ayw != i) {
                this.ayw = i;
                this.ayv = at.getDrawable(i);
                int intrinsicWidth = this.ayv.getIntrinsicWidth();
                int intrinsicHeight = this.ayv.getIntrinsicHeight();
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
                this.ayv.setBounds(paddingLeft, paddingTop, intrinsicWidth + paddingLeft, intrinsicHeight + paddingTop);
            }
        }
        invalidate();
    }

    public void stopLoading() {
        this.mIsLoading = false;
        removeCallbacks(this);
        invalidate();
    }

    private void El() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.ayr += this.ayt;
        if (this.ayr > 360.0f - this.ayt) {
            this.ayr = 0.0f;
        }
        invalidate();
        El();
    }

    public void setPlayCallback(a aVar) {
        this.aym = aVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.ayv != null && this.ayv.isStateful()) {
            this.ayv.setState(getDrawableState());
            invalidate();
        }
    }

    public void a(com.baidu.tbadk.gif.a aVar) {
        BdUniqueId bdUniqueId;
        boolean z;
        if (aVar == null) {
            this.ayE = null;
            return;
        }
        boolean GY = g.GY();
        k A = l.A(getContext());
        if (A != null) {
            bdUniqueId = A.getUniqueId();
            z = A.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        if (!(aVar == this.ayE && this.ayG == bdUniqueId)) {
            Em();
        }
        this.ayE = aVar;
        this.ayG = bdUniqueId;
        String str = GY ? this.ayE.ayh : this.ayE.ayg;
        com.baidu.adp.widget.a.a aVar2 = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.g.c.eA().a(this.ayE.ayf, 20, this.ayE.mGid, this.ayE.ayf, Boolean.valueOf(GY), str);
        if (aVar2 != null) {
            stopLoading();
            setGif(aVar2);
        } else if (this.ayE.aye) {
            setGif(null);
        } else if (!com.baidu.adp.lib.g.c.eA().al(20) && this.ayF) {
            d(true, this.ayk);
        } else if (!z) {
            com.baidu.adp.lib.g.c.eA().a(this.ayE.ayf, 20, this.ayH);
            startLoading();
            com.baidu.adp.lib.g.c.eA().a(this.ayE.ayf, 20, this.ayH, 0, 0, this.ayG, this.ayE.mGid, this.ayE.ayf, Boolean.valueOf(GY), str);
        }
    }

    public void Em() {
        stopLoading();
        this.ayp = false;
        this.ayu = false;
        if (this.ayE != null) {
            com.baidu.adp.lib.g.c.eA().a(this.ayE.ayf, 20, this.ayH);
        }
    }

    @Override // com.baidu.adp.newwidget.a.i
    public void refresh() {
        a(this.ayE);
    }

    public void setSupportNoImage(boolean z) {
        this.ayF = z;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(this);
        this.mOnClickListener = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ayE != null) {
            boolean GY = g.GY();
            String str = GY ? this.ayE.ayh : this.ayE.ayg;
            com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.g.c.eA().a(this.ayE.ayf, 20, this.ayE.mGid, this.ayE.ayf, Boolean.valueOf(GY), str);
            if (aVar != null) {
                this.ayE.aye = false;
                setGif(aVar);
            } else {
                startLoading();
                com.baidu.adp.lib.g.c.eA().a(this.ayE.ayf, 20, this.ayH, 0, 0, this.ayG, this.ayE.mGid, this.ayE.ayf, Boolean.valueOf(GY), str);
                return;
            }
        }
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    public void setIsKeepLastFrame(boolean z) {
        this.ayA = z;
    }

    public static Bitmap a(GifView gifView) {
        if (ays != null && !ays.isRecycled()) {
            return ays;
        }
        BitmapDrawable bitmapDrawable = (BitmapDrawable) gifView.getResources().getDrawable(r.f.loading);
        if (bitmapDrawable != null) {
            ays = bitmapDrawable.getBitmap();
        }
        return ays;
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
        if (this.aym != null && !this.ayC) {
            this.aym.onStop();
            this.ayC = true;
        }
    }
}
