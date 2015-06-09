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
import com.baidu.adp.base.m;
import com.baidu.adp.base.n;
import com.baidu.adp.newwidget.a.i;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.p;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class GifView extends ImageView implements View.OnClickListener, i, Runnable {
    public static Bitmap alK;
    private final int alA;
    private WeakReference<com.baidu.adp.gif.c> alB;
    private int alC;
    private d alD;
    private boolean alE;
    private BitmapDrawable alF;
    private boolean alG;
    private Drawable alH;
    private boolean alI;
    private float alJ;
    private float alL;
    private boolean alM;
    private Drawable alN;
    private int alO;
    private final Rect alP;
    private final Rect alQ;
    private boolean alR;
    private boolean alS;
    private a alT;
    private boolean alU;
    private BdUniqueId alV;
    private final com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> alW;
    private Bitmap mBitmap;
    private final Handler mHandler;
    private View.OnClickListener mOnClickListener;
    private final int mType;

    public GifView(Context context) {
        this(context, null, 0);
    }

    public GifView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GifView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.alA = p.pic_expression_upload_selector;
        this.alE = false;
        this.alP = new Rect();
        this.alQ = new Rect();
        this.alR = true;
        this.mHandler = new b(this, Looper.getMainLooper());
        this.mType = 20;
        this.alU = true;
        this.alW = new c(this);
        this.alF = (BitmapDrawable) getResources().getDrawable(p.icon_content_animation);
        this.alF.setBounds(0, 0, this.alF.getIntrinsicWidth(), this.alF.getIntrinsicHeight());
        this.alL = 30.0f;
        if (((BitmapDrawable) getResources().getDrawable(p.loading)) != null) {
            alK = a(this);
            this.alQ.set(0, 0, alK.getWidth(), alK.getHeight());
        }
        this.alH = getResources().getDrawable(p.image_group_load_f);
        a(this.alH);
    }

    private void a(Drawable drawable) {
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
                this.alP.set(i7, i8, i7 + i6, i6 + i8);
            }
            int intrinsicWidth = this.alH.getIntrinsicWidth();
            int intrinsicHeight = this.alH.getIntrinsicHeight();
            if (intrinsicWidth > i5) {
                intrinsicWidth = i5;
            }
            if (intrinsicHeight > paddingBottom) {
                intrinsicHeight = paddingBottom;
            }
            int i9 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
            int i10 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
            this.alH.setBounds(i9, i10, intrinsicWidth + i9, intrinsicHeight + i10);
            if (this.alN != null) {
                int intrinsicWidth2 = this.alN.getIntrinsicWidth();
                int intrinsicHeight2 = this.alN.getIntrinsicHeight();
                if (intrinsicWidth2 > i5) {
                    intrinsicWidth2 = i5;
                }
                if (intrinsicHeight2 > paddingBottom) {
                    intrinsicHeight2 = paddingBottom;
                }
                int i11 = ((i5 - intrinsicWidth2) / 2) + paddingLeft;
                int i12 = ((paddingBottom - intrinsicHeight2) / 2) + paddingTop;
                this.alN.setBounds(i11, i12, intrinsicWidth2 + i11, intrinsicHeight2 + i12);
            }
        }
    }

    public void setGif(com.baidu.adp.widget.a.a aVar) {
        this.alG = false;
        this.alI = false;
        this.alM = false;
        if (this.alT != null) {
            this.alT.als = false;
        }
        if (aVar == null) {
            this.alG = true;
            this.alE = false;
            if (this.alT != null) {
                this.alT.als = true;
            }
            setImageDrawable(null);
            if (this.alB != null) {
                this.alB.clear();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.mQ()) {
                this.alE = true;
                aVar.a(this);
                this.alI = false;
            }
            if (this.alB != null) {
                this.alB.clear();
            }
        } else if (this.alB == null || !aVar.getGif().equals(this.alB.get())) {
            this.alE = false;
            if (this.mBitmap == null || (this.mBitmap.getWidth() != aVar.getGif().getWidth() && this.mBitmap.getHeight() != aVar.getGif().getHeight())) {
                this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
            }
            this.alB = new WeakReference<>(aVar.getGif());
            aVar.getGif().D(0);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.alR) {
                play();
            }
        } else {
            aVar.getGif().D(this.alC);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.alR) {
                resume();
            }
        }
    }

    public boolean getAutoPlay() {
        return this.alR;
    }

    public void setAutoPlay(boolean z) {
        this.alR = z;
    }

    public void resume() {
        com.baidu.adp.gif.c cVar;
        if (this.alB != null && (cVar = this.alB.get()) != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, cVar.E(this.alC));
        }
    }

    public void stop() {
        com.baidu.adp.gif.c cVar;
        if (this.alB != null && (cVar = this.alB.get()) != null) {
            this.mHandler.removeMessages(1);
            cVar.D(0);
            cVar.a(this.mBitmap, null);
            invalidate();
        }
    }

    public void play() {
        com.baidu.adp.gif.c cVar;
        if (this.alB != null && (cVar = this.alB.get()) != null) {
            if (this.alC != 0) {
                this.alC = 0;
            }
            cVar.D(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, cVar.E(this.alC));
        }
    }

    public void onDestroy() {
        this.alB = null;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandler.removeMessages(1);
        Ak();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.mHandler.removeMessages(1);
        Ak();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (!this.alE) {
            if (i == 4 || i == 8) {
                stop();
            } else if (i == 0) {
                play();
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        com.baidu.adp.gif.c cVar;
        if (!this.alI && !this.alG && !this.alM) {
            super.onDraw(canvas);
        }
        canvas.save();
        if (this.alB != null && !this.alI && !this.alG && !this.alM && (cVar = this.alB.get()) != null) {
            cVar.a(null, canvas);
        }
        canvas.restore();
        if (this.alE) {
            canvas.save();
            this.alF.draw(canvas);
            canvas.restore();
        }
        if (this.alI && a(this) != null) {
            canvas.save();
            canvas.rotate(this.alJ, (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.5f) + getPaddingLeft(), (((getHeight() - getPaddingTop()) - getPaddingBottom()) * 0.5f) + getPaddingTop());
            canvas.drawBitmap(a(this), this.alQ, this.alP, (Paint) null);
            canvas.restore();
        } else if (this.alG || (this.alT != null && this.alT.als)) {
            canvas.save();
            this.alH.draw(canvas);
            canvas.restore();
        } else if (this.alM) {
            canvas.save();
            this.alN.draw(canvas);
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
        if (!this.alI) {
            this.alI = true;
            Aj();
        }
    }

    public void a(boolean z, int i) {
        this.alM = z;
        if (z) {
            this.alI = false;
            this.alG = false;
            if (this.alN == null || this.alO != i) {
                this.alO = i;
                this.alN = ay.getDrawable(i);
                int intrinsicWidth = this.alN.getIntrinsicWidth();
                int intrinsicHeight = this.alN.getIntrinsicHeight();
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
                this.alN.setBounds(paddingLeft, paddingTop, intrinsicWidth + paddingLeft, intrinsicHeight + paddingTop);
            }
        }
        invalidate();
    }

    public com.baidu.adp.gif.c getGif() {
        if (this.alB == null) {
            return null;
        }
        return this.alB.get();
    }

    public void stopLoading() {
        this.alI = false;
        removeCallbacks(this);
        invalidate();
    }

    private void Aj() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.alJ += this.alL;
        if (this.alJ > 360.0f - this.alL) {
            this.alJ = 0.0f;
        }
        invalidate();
        Aj();
    }

    public void setPlayCallback(d dVar) {
        this.alD = dVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.alN != null && this.alN.isStateful()) {
            this.alN.setState(getDrawableState());
            invalidate();
        }
    }

    public void a(a aVar) {
        BdUniqueId bdUniqueId;
        boolean z;
        if (aVar == null) {
            this.alT = null;
            return;
        }
        boolean DX = com.baidu.tbadk.util.g.DX();
        m B = n.B(getContext());
        if (B != null) {
            bdUniqueId = B.getUniqueId();
            z = B.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        if (!(aVar == this.alT && this.alV == bdUniqueId)) {
            Ak();
        }
        this.alT = aVar;
        this.alV = bdUniqueId;
        String str = DX ? this.alT.alv : this.alT.alu;
        com.baidu.adp.widget.a.a aVar2 = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.d.hl().a(this.alT.alt, 20, this.alT.alw, this.alT.alt, Boolean.valueOf(DX), str);
        if (aVar2 != null) {
            stopLoading();
            setGif(aVar2);
        } else if (this.alT.als) {
            setGif(null);
        } else if (!com.baidu.adp.lib.f.d.hl().V(20) && this.alU) {
            a(true, this.alA);
        } else {
            startLoading();
            if (!z) {
                com.baidu.adp.lib.f.d.hl().a(this.alT.alt, 20, this.alW, 0, 0, this.alV, this.alT.alw, this.alT.alt, Boolean.valueOf(DX), str);
            }
        }
    }

    public void Ak() {
        stopLoading();
        this.alG = false;
        this.alM = false;
        if (this.alT != null) {
            com.baidu.adp.lib.f.d.hl().a(this.alT.alt, 20, this.alW);
        }
    }

    @Override // com.baidu.adp.newwidget.a.i
    public void refresh() {
        a(this.alT);
    }

    public void setSupportNoImage(boolean z) {
        this.alU = z;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(this);
        this.mOnClickListener = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.alT != null) {
            boolean DX = com.baidu.tbadk.util.g.DX();
            String str = DX ? this.alT.alv : this.alT.alu;
            com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.d.hl().a(this.alT.alt, 20, this.alT.alw, this.alT.alt, Boolean.valueOf(DX), str);
            if (aVar != null) {
                this.alT.als = false;
                setGif(aVar);
            } else {
                startLoading();
                com.baidu.adp.lib.f.d.hl().a(this.alT.alt, 20, this.alW, 0, 0, this.alV, this.alT.alw, this.alT.alt, Boolean.valueOf(DX), str);
                return;
            }
        }
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    public static Bitmap a(GifView gifView) {
        if (alK != null && !alK.isRecycled()) {
            return alK;
        }
        BitmapDrawable bitmapDrawable = (BitmapDrawable) gifView.getResources().getDrawable(p.loading);
        if (bitmapDrawable != null) {
            alK = bitmapDrawable.getBitmap();
        }
        return alK;
    }
}
