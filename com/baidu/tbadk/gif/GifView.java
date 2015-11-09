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
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.i;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class GifView extends ImageView implements View.OnClickListener, i, Runnable {
    public static Bitmap ask;
    private final int asa;
    private WeakReference<com.baidu.adp.gif.b> asb;
    private int asc;
    private a asd;
    private boolean ase;
    private BitmapDrawable asf;
    private boolean asg;
    private Drawable ash;
    private boolean asi;
    private float asj;
    private float asl;
    private boolean asm;
    private Drawable asn;
    private int aso;
    private final Rect asp;
    private final Rect asq;
    private boolean asr;
    private boolean ass;
    private com.baidu.tbadk.gif.a ast;
    private boolean asu;
    private BdUniqueId asv;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> asw;
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
        this.asa = i.e.pic_expression_upload_selector;
        this.ase = false;
        this.asp = new Rect();
        this.asq = new Rect();
        this.asr = true;
        this.mHandler = new b(this, Looper.getMainLooper());
        this.mType = 20;
        this.asu = true;
        this.asw = new c(this);
        this.asf = (BitmapDrawable) getResources().getDrawable(i.e.icon_content_animation);
        this.asf.setBounds(0, 0, this.asf.getIntrinsicWidth(), this.asf.getIntrinsicHeight());
        this.asl = 30.0f;
        if (((BitmapDrawable) getResources().getDrawable(i.e.loading)) != null) {
            ask = a(this);
            this.asq.set(0, 0, ask.getWidth(), ask.getHeight());
        }
        this.ash = getResources().getDrawable(i.e.image_group_load_f);
        c(this.ash);
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
                this.asp.set(i7, i8, i7 + i6, i6 + i8);
            }
            int intrinsicWidth = this.ash.getIntrinsicWidth();
            int intrinsicHeight = this.ash.getIntrinsicHeight();
            if (intrinsicWidth > i5) {
                intrinsicWidth = i5;
            }
            if (intrinsicHeight > paddingBottom) {
                intrinsicHeight = paddingBottom;
            }
            int i9 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
            int i10 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
            this.ash.setBounds(i9, i10, intrinsicWidth + i9, intrinsicHeight + i10);
            if (this.asn != null) {
                int intrinsicWidth2 = this.asn.getIntrinsicWidth();
                int intrinsicHeight2 = this.asn.getIntrinsicHeight();
                if (intrinsicWidth2 > i5) {
                    intrinsicWidth2 = i5;
                }
                if (intrinsicHeight2 > paddingBottom) {
                    intrinsicHeight2 = paddingBottom;
                }
                int i11 = ((i5 - intrinsicWidth2) / 2) + paddingLeft;
                int i12 = ((paddingBottom - intrinsicHeight2) / 2) + paddingTop;
                this.asn.setBounds(i11, i12, intrinsicWidth2 + i11, intrinsicHeight2 + i12);
            }
        }
    }

    public void setGif(com.baidu.adp.widget.a.a aVar) {
        this.asg = false;
        this.asi = false;
        this.asm = false;
        if (this.ast != null) {
            this.ast.arT = false;
        }
        if (aVar == null) {
            this.asg = true;
            this.ase = false;
            if (this.ast != null) {
                this.ast.arT = true;
            }
            setImageDrawable(null);
            if (this.asb != null) {
                this.asb.clear();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.mZ()) {
                this.ase = true;
                aVar.a(this);
                this.asi = false;
            }
            if (this.asb != null) {
                this.asb.clear();
            }
        } else if (this.asb == null || !aVar.getGif().equals(this.asb.get())) {
            this.ase = false;
            if (this.mBitmap == null || (this.mBitmap.getWidth() != aVar.getGif().getWidth() && this.mBitmap.getHeight() != aVar.getGif().getHeight())) {
                this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
            }
            this.asb = new WeakReference<>(aVar.getGif());
            aVar.getGif().F(0);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.asr) {
                play();
            }
        } else {
            aVar.getGif().F(this.asc);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.asr) {
                resume();
            }
        }
    }

    public boolean getAutoPlay() {
        return this.asr;
    }

    public void setAutoPlay(boolean z) {
        this.asr = z;
    }

    public void resume() {
        com.baidu.adp.gif.b bVar;
        if (this.asb != null && (bVar = this.asb.get()) != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, bVar.G(this.asc));
        }
    }

    public void stop() {
        com.baidu.adp.gif.b bVar;
        if (this.asb != null && (bVar = this.asb.get()) != null) {
            this.mHandler.removeMessages(1);
            bVar.F(0);
            bVar.a(this.mBitmap, null);
            invalidate();
        }
    }

    public void play() {
        com.baidu.adp.gif.b bVar;
        if (this.asb != null && (bVar = this.asb.get()) != null) {
            if (this.asc != 0) {
                this.asc = 0;
            }
            bVar.F(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, bVar.G(this.asc));
        }
    }

    public void onDestroy() {
        this.asb = null;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandler.removeMessages(1);
        BS();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.mHandler.removeMessages(1);
        BS();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (!this.ase) {
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
        if (!this.asi && !this.asg && !this.asm) {
            super.onDraw(canvas);
        }
        canvas.save();
        if (this.asb != null && !this.asi && !this.asg && !this.asm && (bVar = this.asb.get()) != null) {
            bVar.a(null, canvas);
        }
        canvas.restore();
        if (this.ase) {
            canvas.save();
            this.asf.draw(canvas);
            canvas.restore();
        }
        if (this.asi && a(this) != null) {
            canvas.save();
            canvas.rotate(this.asj, (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.5f) + getPaddingLeft(), (((getHeight() - getPaddingTop()) - getPaddingBottom()) * 0.5f) + getPaddingTop());
            canvas.drawBitmap(a(this), this.asq, this.asp, (Paint) null);
            canvas.restore();
        } else if (this.asg || (this.ast != null && this.ast.arT)) {
            canvas.save();
            this.ash.draw(canvas);
            canvas.restore();
        } else if (this.asm) {
            canvas.save();
            this.asn.draw(canvas);
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
        if (!this.asi) {
            this.asi = true;
            BR();
        }
    }

    public void a(boolean z, int i) {
        this.asm = z;
        if (z) {
            this.asi = false;
            this.asg = false;
            if (this.asn == null || this.aso != i) {
                this.aso = i;
                this.asn = an.getDrawable(i);
                int intrinsicWidth = this.asn.getIntrinsicWidth();
                int intrinsicHeight = this.asn.getIntrinsicHeight();
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
                this.asn.setBounds(paddingLeft, paddingTop, intrinsicWidth + paddingLeft, intrinsicHeight + paddingTop);
            }
        }
        invalidate();
    }

    public com.baidu.adp.gif.b getGif() {
        if (this.asb == null) {
            return null;
        }
        return this.asb.get();
    }

    public void stopLoading() {
        this.asi = false;
        removeCallbacks(this);
        invalidate();
    }

    private void BR() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.asj += this.asl;
        if (this.asj > 360.0f - this.asl) {
            this.asj = 0.0f;
        }
        invalidate();
        BR();
    }

    public void setPlayCallback(a aVar) {
        this.asd = aVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.asn != null && this.asn.isStateful()) {
            this.asn.setState(getDrawableState());
            invalidate();
        }
    }

    public void a(com.baidu.tbadk.gif.a aVar) {
        BdUniqueId bdUniqueId;
        boolean z;
        if (aVar == null) {
            this.ast = null;
            return;
        }
        boolean Ep = com.baidu.tbadk.util.e.Ep();
        k A = l.A(getContext());
        if (A != null) {
            bdUniqueId = A.getUniqueId();
            z = A.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        if (!(aVar == this.ast && this.asv == bdUniqueId)) {
            BS();
        }
        this.ast = aVar;
        this.asv = bdUniqueId;
        String str = Ep ? this.ast.arW : this.ast.arV;
        com.baidu.adp.widget.a.a aVar2 = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.hb().a(this.ast.arU, 20, this.ast.mGid, this.ast.arU, Boolean.valueOf(Ep), str);
        if (aVar2 != null) {
            stopLoading();
            setGif(aVar2);
        } else if (this.ast.arT) {
            setGif(null);
        } else if (!com.baidu.adp.lib.f.c.hb().W(20) && this.asu) {
            a(true, this.asa);
        } else {
            startLoading();
            if (!z) {
                com.baidu.adp.lib.f.c.hb().a(this.ast.arU, 20, this.asw, 0, 0, this.asv, this.ast.mGid, this.ast.arU, Boolean.valueOf(Ep), str);
            }
        }
    }

    public void BS() {
        stopLoading();
        this.asg = false;
        this.asm = false;
        if (this.ast != null) {
            com.baidu.adp.lib.f.c.hb().a(this.ast.arU, 20, this.asw);
        }
    }

    @Override // com.baidu.adp.newwidget.a.i
    public void refresh() {
        a(this.ast);
    }

    public void setSupportNoImage(boolean z) {
        this.asu = z;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(this);
        this.mOnClickListener = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ast != null) {
            boolean Ep = com.baidu.tbadk.util.e.Ep();
            String str = Ep ? this.ast.arW : this.ast.arV;
            com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.hb().a(this.ast.arU, 20, this.ast.mGid, this.ast.arU, Boolean.valueOf(Ep), str);
            if (aVar != null) {
                this.ast.arT = false;
                setGif(aVar);
            } else {
                startLoading();
                com.baidu.adp.lib.f.c.hb().a(this.ast.arU, 20, this.asw, 0, 0, this.asv, this.ast.mGid, this.ast.arU, Boolean.valueOf(Ep), str);
                return;
            }
        }
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    public static Bitmap a(GifView gifView) {
        if (ask != null && !ask.isRecycled()) {
            return ask;
        }
        BitmapDrawable bitmapDrawable = (BitmapDrawable) gifView.getResources().getDrawable(i.e.loading);
        if (bitmapDrawable != null) {
            ask = bitmapDrawable.getBitmap();
        }
        return ask;
    }
}
