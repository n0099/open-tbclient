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
import com.baidu.adp.newwidget.a.i;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.i;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class GifView extends ImageView implements View.OnClickListener, i, Runnable {
    public static Bitmap auY;
    private final int auO;
    private WeakReference<com.baidu.adp.gif.b> auP;
    private int auQ;
    private a auR;
    private boolean auS;
    private BitmapDrawable auT;
    private boolean auU;
    private Drawable auV;
    private boolean auW;
    private float auX;
    private float auZ;
    private boolean ava;
    private Drawable avb;
    private int avc;
    private final Rect avd;
    private final Rect ave;
    private boolean avf;
    private boolean avg;
    private com.baidu.tbadk.gif.a avh;
    private boolean avi;
    private BdUniqueId avj;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> avk;
    private Bitmap mBitmap;
    private final Handler mHandler;
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
        this.auO = i.e.pic_expression_upload_selector;
        this.auS = false;
        this.avd = new Rect();
        this.ave = new Rect();
        this.avf = true;
        this.mHandler = new b(this, Looper.getMainLooper());
        this.mType = 20;
        this.avi = true;
        this.avk = new c(this);
        this.auT = (BitmapDrawable) getResources().getDrawable(i.e.icon_content_animation);
        this.auT.setBounds(0, 0, this.auT.getIntrinsicWidth(), this.auT.getIntrinsicHeight());
        this.auZ = 30.0f;
        if (((BitmapDrawable) getResources().getDrawable(i.e.loading)) != null) {
            auY = a(this);
            this.ave.set(0, 0, auY.getWidth(), auY.getHeight());
        }
        this.auV = getResources().getDrawable(i.e.image_group_load_f);
        c(this.auV);
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
                this.avd.set(i7, i8, i7 + i6, i6 + i8);
            }
            int intrinsicWidth = this.auV.getIntrinsicWidth();
            int intrinsicHeight = this.auV.getIntrinsicHeight();
            if (intrinsicWidth > i5) {
                intrinsicWidth = i5;
            }
            if (intrinsicHeight > paddingBottom) {
                intrinsicHeight = paddingBottom;
            }
            int i9 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
            int i10 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
            this.auV.setBounds(i9, i10, intrinsicWidth + i9, intrinsicHeight + i10);
            if (this.avb != null) {
                int intrinsicWidth2 = this.avb.getIntrinsicWidth();
                int intrinsicHeight2 = this.avb.getIntrinsicHeight();
                if (intrinsicWidth2 > i5) {
                    intrinsicWidth2 = i5;
                }
                if (intrinsicHeight2 > paddingBottom) {
                    intrinsicHeight2 = paddingBottom;
                }
                int i11 = ((i5 - intrinsicWidth2) / 2) + paddingLeft;
                int i12 = ((paddingBottom - intrinsicHeight2) / 2) + paddingTop;
                this.avb.setBounds(i11, i12, intrinsicWidth2 + i11, intrinsicHeight2 + i12);
            }
        }
    }

    public void setGif(com.baidu.adp.widget.a.a aVar) {
        this.auU = false;
        this.auW = false;
        this.ava = false;
        if (this.avh != null) {
            this.avh.auH = false;
        }
        if (aVar == null) {
            this.auU = true;
            this.auS = false;
            if (this.avh != null) {
                this.avh.auH = true;
            }
            setImageDrawable(null);
            if (this.auP != null) {
                this.auP.clear();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.mX()) {
                this.auS = true;
                aVar.a(this);
                this.auW = false;
            }
            if (this.auP != null) {
                this.auP.clear();
            }
        } else if (this.auP == null || !aVar.getGif().equals(this.auP.get())) {
            this.auS = false;
            if (this.mBitmap == null || (this.mBitmap.getWidth() != aVar.getGif().getWidth() && this.mBitmap.getHeight() != aVar.getGif().getHeight())) {
                this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
            }
            this.auP = new WeakReference<>(aVar.getGif());
            aVar.getGif().F(0);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.avf) {
                play();
            }
        } else {
            aVar.getGif().F(this.auQ);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.avf) {
                resume();
            }
        }
    }

    public boolean getAutoPlay() {
        return this.avf;
    }

    public void setAutoPlay(boolean z) {
        this.avf = z;
    }

    public void resume() {
        com.baidu.adp.gif.b bVar;
        if (this.auP != null && (bVar = this.auP.get()) != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, bVar.G(this.auQ));
        }
    }

    public void stop() {
        com.baidu.adp.gif.b bVar;
        if (this.auP != null && (bVar = this.auP.get()) != null) {
            this.mHandler.removeMessages(1);
            bVar.F(0);
            bVar.a(this.mBitmap, null);
            invalidate();
        }
    }

    public void play() {
        com.baidu.adp.gif.b bVar;
        if (this.auP != null && (bVar = this.auP.get()) != null) {
            if (this.auQ != 0) {
                this.auQ = 0;
            }
            bVar.F(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, bVar.G(this.auQ));
        }
    }

    public void onDestroy() {
        this.auP = null;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandler.removeMessages(1);
        Cp();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.mHandler.removeMessages(1);
        Cp();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (!this.auS) {
            if (i == 4 || i == 8) {
                stop();
            } else if (i == 0) {
                play();
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        com.baidu.adp.gif.b bVar;
        if (!this.auW && !this.auU && !this.ava) {
            super.onDraw(canvas);
        }
        canvas.save();
        if (this.auP != null && !this.auW && !this.auU && !this.ava && (bVar = this.auP.get()) != null) {
            bVar.a(null, canvas);
        }
        canvas.restore();
        if (this.auS) {
            canvas.save();
            this.auT.draw(canvas);
            canvas.restore();
        }
        if (this.auW && a(this) != null) {
            canvas.save();
            canvas.rotate(this.auX, (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.5f) + getPaddingLeft(), (((getHeight() - getPaddingTop()) - getPaddingBottom()) * 0.5f) + getPaddingTop());
            canvas.drawBitmap(a(this), this.ave, this.avd, (Paint) null);
            canvas.restore();
        } else if (this.auU || (this.avh != null && this.avh.auH)) {
            canvas.save();
            this.auV.draw(canvas);
            canvas.restore();
        } else if (this.ava) {
            canvas.save();
            this.avb.draw(canvas);
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
        if (!this.auW) {
            this.auW = true;
            Co();
        }
    }

    public void a(boolean z, int i) {
        this.ava = z;
        if (z) {
            this.auW = false;
            this.auU = false;
            if (this.avb == null || this.avc != i) {
                this.avc = i;
                this.avb = al.getDrawable(i);
                int intrinsicWidth = this.avb.getIntrinsicWidth();
                int intrinsicHeight = this.avb.getIntrinsicHeight();
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
                this.avb.setBounds(paddingLeft, paddingTop, intrinsicWidth + paddingLeft, intrinsicHeight + paddingTop);
            }
        }
        invalidate();
    }

    public com.baidu.adp.gif.b getGif() {
        if (this.auP == null) {
            return null;
        }
        return this.auP.get();
    }

    public void stopLoading() {
        this.auW = false;
        removeCallbacks(this);
        invalidate();
    }

    private void Co() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.auX += this.auZ;
        if (this.auX > 360.0f - this.auZ) {
            this.auX = 0.0f;
        }
        invalidate();
        Co();
    }

    public void setPlayCallback(a aVar) {
        this.auR = aVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.avb != null && this.avb.isStateful()) {
            this.avb.setState(getDrawableState());
            invalidate();
        }
    }

    public void a(com.baidu.tbadk.gif.a aVar) {
        BdUniqueId bdUniqueId;
        boolean z;
        if (aVar == null) {
            this.avh = null;
            return;
        }
        boolean EM = com.baidu.tbadk.util.d.EM();
        k A = l.A(getContext());
        if (A != null) {
            bdUniqueId = A.getUniqueId();
            z = A.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        if (!(aVar == this.avh && this.avj == bdUniqueId)) {
            Cp();
        }
        this.avh = aVar;
        this.avj = bdUniqueId;
        String str = EM ? this.avh.auK : this.avh.auJ;
        com.baidu.adp.widget.a.a aVar2 = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.gZ().a(this.avh.auI, 20, this.avh.mGid, this.avh.auI, Boolean.valueOf(EM), str);
        if (aVar2 != null) {
            stopLoading();
            setGif(aVar2);
        } else if (this.avh.auH) {
            setGif(null);
        } else if (!com.baidu.adp.lib.f.c.gZ().W(20) && this.avi) {
            a(true, this.auO);
        } else {
            startLoading();
            if (!z) {
                com.baidu.adp.lib.f.c.gZ().a(this.avh.auI, 20, this.avk, 0, 0, this.avj, this.avh.mGid, this.avh.auI, Boolean.valueOf(EM), str);
            }
        }
    }

    public void Cp() {
        stopLoading();
        this.auU = false;
        this.ava = false;
        if (this.avh != null) {
            com.baidu.adp.lib.f.c.gZ().a(this.avh.auI, 20, this.avk);
        }
    }

    @Override // com.baidu.adp.newwidget.a.i
    public void refresh() {
        a(this.avh);
    }

    public void setSupportNoImage(boolean z) {
        this.avi = z;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(this);
        this.mOnClickListener = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.avh != null) {
            boolean EM = com.baidu.tbadk.util.d.EM();
            String str = EM ? this.avh.auK : this.avh.auJ;
            com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.gZ().a(this.avh.auI, 20, this.avh.mGid, this.avh.auI, Boolean.valueOf(EM), str);
            if (aVar != null) {
                this.avh.auH = false;
                setGif(aVar);
            } else {
                startLoading();
                com.baidu.adp.lib.f.c.gZ().a(this.avh.auI, 20, this.avk, 0, 0, this.avj, this.avh.mGid, this.avh.auI, Boolean.valueOf(EM), str);
                return;
            }
        }
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    public static Bitmap a(GifView gifView) {
        if (auY != null && !auY.isRecycled()) {
            return auY;
        }
        BitmapDrawable bitmapDrawable = (BitmapDrawable) gifView.getResources().getDrawable(i.e.loading);
        if (bitmapDrawable != null) {
            auY = bitmapDrawable.getBitmap();
        }
        return auY;
    }
}
