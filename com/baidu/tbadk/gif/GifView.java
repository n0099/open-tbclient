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
    public static Bitmap auR;
    private BdUniqueId afi;
    private final int auJ;
    private int auK;
    private a auL;
    private boolean auM;
    private BitmapDrawable auN;
    private boolean auO;
    private Drawable auP;
    private float auQ;
    private float auS;
    private boolean auT;
    private Drawable auU;
    private int auV;
    private final Rect auW;
    private final Rect auX;
    private boolean auY;
    private boolean auZ;
    private boolean ava;
    private boolean avb;
    private boolean avc;
    private com.baidu.tbadk.gif.a avd;
    private boolean ave;
    private final com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> avf;
    private Bitmap mBitmap;
    private final Handler mHandler;
    private boolean mIsLoading;
    private View.OnClickListener mOnClickListener;
    private final int mType;
    private com.baidu.adp.gif.b ye;

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
        this.auJ = u.f.pic_expression_upload_selector;
        this.auM = false;
        this.auW = new Rect();
        this.auX = new Rect();
        this.auY = true;
        this.auZ = false;
        this.ava = false;
        this.avb = false;
        this.mHandler = new b(this, Looper.getMainLooper());
        this.mType = 20;
        this.ave = true;
        this.avf = new c(this);
        this.auN = (BitmapDrawable) getResources().getDrawable(u.f.icon_content_animation);
        this.auN.setBounds(0, 0, this.auN.getIntrinsicWidth(), this.auN.getIntrinsicHeight());
        this.auS = 30.0f;
        if (((BitmapDrawable) getResources().getDrawable(u.f.loading)) != null) {
            auR = a(this);
            this.auX.set(0, 0, auR.getWidth(), auR.getHeight());
        }
        this.auP = getResources().getDrawable(u.f.image_group_load_f);
        e(this.auP);
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
                this.auW.set(i7, i8, i7 + i6, i6 + i8);
            }
            int intrinsicWidth = this.auP.getIntrinsicWidth();
            int intrinsicHeight = this.auP.getIntrinsicHeight();
            if (intrinsicWidth > i5) {
                intrinsicWidth = i5;
            }
            if (intrinsicHeight > paddingBottom) {
                intrinsicHeight = paddingBottom;
            }
            int i9 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
            int i10 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
            this.auP.setBounds(i9, i10, intrinsicWidth + i9, intrinsicHeight + i10);
            if (this.auU != null) {
                int intrinsicWidth2 = this.auU.getIntrinsicWidth();
                int intrinsicHeight2 = this.auU.getIntrinsicHeight();
                if (intrinsicWidth2 > i5) {
                    intrinsicWidth2 = i5;
                }
                if (intrinsicHeight2 > paddingBottom) {
                    intrinsicHeight2 = paddingBottom;
                }
                int i11 = ((i5 - intrinsicWidth2) / 2) + paddingLeft;
                int i12 = ((paddingBottom - intrinsicHeight2) / 2) + paddingTop;
                this.auU.setBounds(i11, i12, intrinsicWidth2 + i11, intrinsicHeight2 + i12);
            }
        }
    }

    public void release() {
        if (this.ava && this.ye != null && this.ye != null) {
            this.ye.close();
            this.ye = null;
        }
    }

    public void setGif(com.baidu.adp.widget.a.a aVar) {
        this.auO = false;
        this.mIsLoading = false;
        this.auT = false;
        if (this.avd != null) {
            this.avd.auD = false;
        }
        if (aVar == null) {
            this.auO = true;
            this.auM = false;
            if (this.avd != null) {
                this.avd.auD = true;
            }
            setImageDrawable(null);
            if (this.ye != null) {
                this.ye.close();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.iY()) {
                this.auM = true;
                aVar.e(this);
                this.mIsLoading = false;
            }
            if (this.ye != null) {
                this.ye.close();
            }
        } else if (this.ye == null || !aVar.getGif().equals(this.ye)) {
            this.auM = false;
            try {
                if (this.mBitmap == null || (this.mBitmap.getWidth() != aVar.getGif().getWidth() && this.mBitmap.getHeight() != aVar.getGif().getHeight())) {
                    this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
                }
                this.ye = aVar.getGif();
                aVar.getGif().H(0);
                aVar.getGif().a(this.mBitmap, null);
                setImageBitmap(this.mBitmap);
                if (this.auY) {
                    play();
                }
            } catch (Throwable th) {
                onStop();
            }
        } else {
            aVar.getGif().H(this.auK);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.auY) {
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
        com.baidu.adp.widget.a.a e8 = a.C0004a.bB().e(bArr, 0, i2);
        this.ava = true;
        setGif(e8);
    }

    public boolean getAutoPlay() {
        return this.auY;
    }

    public void setAutoPlay(boolean z) {
        this.auY = z;
    }

    public void resume() {
        this.avb = false;
        com.baidu.adp.gif.b gif = getGif();
        if (gif != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, gif.I(this.auK));
        }
    }

    public void stop() {
        com.baidu.adp.gif.b gif = getGif();
        if (gif != null) {
            this.mHandler.removeMessages(1);
            gif.H(0);
            gif.a(this.mBitmap, null);
            invalidate();
            onStop();
        }
    }

    public void play() {
        this.avb = false;
        com.baidu.adp.gif.b gif = getGif();
        if (gif != null) {
            if (this.auK != 0) {
                this.auK = 0;
            }
            gif.H(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, gif.I(this.auK));
        }
    }

    public void CK() {
        this.avc = true;
        play();
    }

    public void onDestroy() {
        this.ye = null;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandler.removeMessages(1);
        CM();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.mHandler.removeMessages(1);
        CM();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (!this.auM) {
            if (i == 4 || i == 8) {
                stop();
            } else if (i == 0) {
                play();
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (!this.mIsLoading && !this.auO && !this.auT) {
            super.onDraw(canvas);
        }
        canvas.save();
        try {
            if (this.ye != null && !this.mIsLoading && !this.auO && !this.auT) {
                this.ye.a(null, canvas);
            }
        } catch (Throwable th) {
            BdLog.e("setGif:" + th.getMessage());
            onStop();
        }
        canvas.restore();
        if (this.auM) {
            canvas.save();
            this.auN.draw(canvas);
            canvas.restore();
        }
        if (this.mIsLoading && a(this) != null) {
            canvas.save();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            canvas.rotate(this.auQ, (width * 0.5f) + getPaddingLeft(), (height * 0.5f) + getPaddingTop());
            canvas.drawBitmap(a(this), this.auX, this.auW, (Paint) null);
            canvas.restore();
        } else if (this.auO || (this.avd != null && this.avd.auD)) {
            canvas.save();
            this.auP.draw(canvas);
            canvas.restore();
        } else if (this.auT) {
            canvas.save();
            this.auU.draw(canvas);
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
            CL();
        }
    }

    public void c(boolean z, int i) {
        this.auT = z;
        if (z) {
            this.mIsLoading = false;
            this.auO = false;
            if (this.auU == null || this.auV != i) {
                this.auV = i;
                this.auU = av.getDrawable(i);
                int intrinsicWidth = this.auU.getIntrinsicWidth();
                int intrinsicHeight = this.auU.getIntrinsicHeight();
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
                this.auU.setBounds(paddingLeft, paddingTop, intrinsicWidth + paddingLeft, intrinsicHeight + paddingTop);
            }
        }
        invalidate();
    }

    public void stopLoading() {
        this.mIsLoading = false;
        removeCallbacks(this);
        invalidate();
    }

    private void CL() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.auQ += this.auS;
        if (this.auQ > 360.0f - this.auS) {
            this.auQ = 0.0f;
        }
        invalidate();
        CL();
    }

    public void setPlayCallback(a aVar) {
        this.auL = aVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.auU != null && this.auU.isStateful()) {
            this.auU.setState(getDrawableState());
            invalidate();
        }
    }

    public void a(com.baidu.tbadk.gif.a aVar) {
        BdUniqueId bdUniqueId;
        boolean z;
        if (aVar == null) {
            this.avd = null;
            return;
        }
        boolean FC = h.FC();
        k q = l.q(getContext());
        if (q != null) {
            bdUniqueId = q.getUniqueId();
            z = q.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        if (!(aVar == this.avd && this.afi == bdUniqueId)) {
            CM();
        }
        this.avd = aVar;
        this.afi = bdUniqueId;
        String str = FC ? this.avd.auG : this.avd.auF;
        com.baidu.adp.widget.a.a aVar2 = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.g.c.dF().a(this.avd.auE, 20, this.avd.mGid, this.avd.auE, Boolean.valueOf(FC), str);
        if (aVar2 != null) {
            stopLoading();
            setGif(aVar2);
        } else if (this.avd.auD) {
            setGif(null);
        } else if (!com.baidu.adp.lib.g.c.dF().Y(20) && this.ave) {
            c(true, this.auJ);
        } else {
            startLoading();
            if (!z) {
                com.baidu.adp.lib.g.c.dF().a(this.avd.auE, 20, this.avf, 0, 0, this.afi, this.avd.mGid, this.avd.auE, Boolean.valueOf(FC), str);
            }
        }
    }

    public void CM() {
        stopLoading();
        this.auO = false;
        this.auT = false;
        if (this.avd != null) {
            com.baidu.adp.lib.g.c.dF().a(this.avd.auE, 20, this.avf);
        }
    }

    @Override // com.baidu.adp.newwidget.a.i
    public void refresh() {
        a(this.avd);
    }

    public void setSupportNoImage(boolean z) {
        this.ave = z;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(this);
        this.mOnClickListener = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.avd != null) {
            boolean FC = h.FC();
            String str = FC ? this.avd.auG : this.avd.auF;
            com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.g.c.dF().a(this.avd.auE, 20, this.avd.mGid, this.avd.auE, Boolean.valueOf(FC), str);
            if (aVar != null) {
                this.avd.auD = false;
                setGif(aVar);
            } else {
                startLoading();
                com.baidu.adp.lib.g.c.dF().a(this.avd.auE, 20, this.avf, 0, 0, this.afi, this.avd.mGid, this.avd.auE, Boolean.valueOf(FC), str);
                return;
            }
        }
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    public void setIsKeepLastFrame(boolean z) {
        this.auZ = z;
    }

    public static Bitmap a(GifView gifView) {
        if (auR != null && !auR.isRecycled()) {
            return auR;
        }
        BitmapDrawable bitmapDrawable = (BitmapDrawable) gifView.getResources().getDrawable(u.f.loading);
        if (bitmapDrawable != null) {
            auR = bitmapDrawable.getBitmap();
        }
        return auR;
    }

    public com.baidu.adp.gif.b getGif() {
        if (this.ye == null) {
            onStop();
            return null;
        }
        return this.ye;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStop() {
        if (this.auL != null && !this.avb) {
            this.auL.onStop();
            this.avb = true;
        }
    }
}
