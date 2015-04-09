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
import com.baidu.adp.base.l;
import com.baidu.adp.base.m;
import com.baidu.adp.lib.util.n;
import com.baidu.adp.newwidget.a.i;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.u;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class GifView extends ImageView implements View.OnClickListener, i, Runnable {
    public static Bitmap akJ;
    private WeakReference<com.baidu.adp.gif.c> akA;
    private int akB;
    private e akC;
    private boolean akD;
    private BitmapDrawable akE;
    private boolean akF;
    private Drawable akG;
    private boolean akH;
    private float akI;
    private float akK;
    private boolean akL;
    private Drawable akM;
    private int akN;
    private final Rect akO;
    private final Rect akP;
    private boolean akQ;
    private boolean akR;
    private a akS;
    private boolean akT;
    private BdUniqueId akU;
    private final com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> akV;
    private final int akz;
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
        this.akz = u.pic_expression_upload_selector;
        this.akD = false;
        this.akO = new Rect();
        this.akP = new Rect();
        this.akQ = true;
        this.mHandler = new b(this, Looper.getMainLooper());
        this.mType = 20;
        this.akT = true;
        this.akV = new c(this);
        this.akE = (BitmapDrawable) getResources().getDrawable(u.icon_content_animation);
        this.akE.setBounds(0, 0, this.akE.getIntrinsicWidth(), this.akE.getIntrinsicHeight());
        this.akK = 30.0f;
        if (((BitmapDrawable) getResources().getDrawable(u.loading)) != null) {
            akJ = a(this);
            this.akP.set(0, 0, akJ.getWidth(), akJ.getHeight());
        }
        this.akG = getResources().getDrawable(u.image_group_load_f);
        a(this.akG);
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
                this.akO.set(i7, i8, i7 + i6, i6 + i8);
            }
            int intrinsicWidth = this.akG.getIntrinsicWidth();
            int intrinsicHeight = this.akG.getIntrinsicHeight();
            if (intrinsicWidth > i5) {
                intrinsicWidth = i5;
            }
            if (intrinsicHeight > paddingBottom) {
                intrinsicHeight = paddingBottom;
            }
            int i9 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
            int i10 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
            this.akG.setBounds(i9, i10, intrinsicWidth + i9, intrinsicHeight + i10);
            if (this.akM != null) {
                int intrinsicWidth2 = this.akM.getIntrinsicWidth();
                int intrinsicHeight2 = this.akM.getIntrinsicHeight();
                if (intrinsicWidth2 > i5) {
                    intrinsicWidth2 = i5;
                }
                if (intrinsicHeight2 > paddingBottom) {
                    intrinsicHeight2 = paddingBottom;
                }
                int i11 = ((i5 - intrinsicWidth2) / 2) + paddingLeft;
                int i12 = ((paddingBottom - intrinsicHeight2) / 2) + paddingTop;
                this.akM.setBounds(i11, i12, intrinsicWidth2 + i11, intrinsicHeight2 + i12);
            }
        }
    }

    public static void releaseBitmap() {
        if (akJ != null) {
            if (n.iW()) {
                akJ = null;
            } else {
                new Handler(Looper.getMainLooper()).post(new d());
            }
        }
    }

    public void setGif(com.baidu.adp.widget.a.a aVar) {
        this.akF = false;
        this.akH = false;
        this.akL = false;
        if (this.akS != null) {
            this.akS.akr = false;
        }
        if (aVar == null) {
            this.akF = true;
            this.akD = false;
            if (this.akS != null) {
                this.akS.akr = true;
            }
            setImageDrawable(null);
            if (this.akA != null) {
                this.akA.clear();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.mx()) {
                this.akD = true;
                aVar.a(this);
                this.akH = false;
            }
            if (this.akA != null) {
                this.akA.clear();
            }
        } else if (this.akA == null || !aVar.getGif().equals(this.akA.get())) {
            this.akD = false;
            if (this.mBitmap == null || (this.mBitmap.getWidth() != aVar.getGif().getWidth() && this.mBitmap.getHeight() != aVar.getGif().getHeight())) {
                this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
            }
            this.akA = new WeakReference<>(aVar.getGif());
            aVar.getGif().C(0);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.akQ) {
                play();
            }
        } else {
            aVar.getGif().C(this.akB);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.akQ) {
                resume();
            }
        }
    }

    public boolean getAutoPlay() {
        return this.akQ;
    }

    public void setAutoPlay(boolean z) {
        this.akQ = z;
    }

    public void resume() {
        com.baidu.adp.gif.c cVar;
        if (this.akA != null && (cVar = this.akA.get()) != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, cVar.D(this.akB));
        }
    }

    public void stop() {
        com.baidu.adp.gif.c cVar;
        if (this.akA != null && (cVar = this.akA.get()) != null) {
            this.mHandler.removeMessages(1);
            cVar.C(0);
            cVar.a(this.mBitmap, null);
            invalidate();
        }
    }

    public void play() {
        com.baidu.adp.gif.c cVar;
        if (this.akA != null && (cVar = this.akA.get()) != null) {
            if (this.akB != 0) {
                this.akB = 0;
            }
            cVar.C(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, cVar.D(this.akB));
        }
    }

    public void onDestroy() {
        this.akA = null;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandler.removeMessages(1);
        zw();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.mHandler.removeMessages(1);
        zw();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (!this.akD) {
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
        if (!this.akH && !this.akF && !this.akL) {
            super.onDraw(canvas);
        }
        canvas.save();
        if (this.akA != null && !this.akH && !this.akF && !this.akL && (cVar = this.akA.get()) != null) {
            cVar.a(null, canvas);
        }
        canvas.restore();
        if (this.akD) {
            canvas.save();
            this.akE.draw(canvas);
            canvas.restore();
        }
        if (this.akH && a(this) != null) {
            canvas.save();
            canvas.rotate(this.akI, (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.5f) + getPaddingLeft(), (((getHeight() - getPaddingTop()) - getPaddingBottom()) * 0.5f) + getPaddingTop());
            canvas.drawBitmap(a(this), this.akP, this.akO, (Paint) null);
            canvas.restore();
        } else if (this.akF || (this.akS != null && this.akS.akr)) {
            canvas.save();
            this.akG.draw(canvas);
            canvas.restore();
        } else if (this.akL) {
            canvas.save();
            this.akM.draw(canvas);
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
        if (!this.akH) {
            this.akH = true;
            zv();
        }
    }

    public void b(boolean z, int i) {
        this.akL = z;
        if (z) {
            this.akH = false;
            this.akF = false;
            if (this.akM == null || this.akN != i) {
                this.akN = i;
                this.akM = ba.getDrawable(i);
                int intrinsicWidth = this.akM.getIntrinsicWidth();
                int intrinsicHeight = this.akM.getIntrinsicHeight();
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
                this.akM.setBounds(paddingLeft, paddingTop, intrinsicWidth + paddingLeft, intrinsicHeight + paddingTop);
            }
        }
        invalidate();
    }

    public com.baidu.adp.gif.c getGif() {
        if (this.akA == null) {
            return null;
        }
        return this.akA.get();
    }

    public void stopLoading() {
        this.akH = false;
        removeCallbacks(this);
        invalidate();
    }

    private void zv() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.akI += this.akK;
        if (this.akI > 360.0f - this.akK) {
            this.akI = 0.0f;
        }
        invalidate();
        zv();
    }

    public void setPlayCallback(e eVar) {
        this.akC = eVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.akM != null && this.akM.isStateful()) {
            this.akM.setState(getDrawableState());
            invalidate();
        }
    }

    public void a(a aVar) {
        BdUniqueId bdUniqueId;
        boolean z;
        if (aVar == null) {
            this.akS = null;
            return;
        }
        boolean Dm = com.baidu.tbadk.util.g.Dm();
        l B = m.B(getContext());
        if (B != null) {
            bdUniqueId = B.getUniqueId();
            z = B.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        if (!(aVar == this.akS && this.akU == bdUniqueId)) {
            zw();
        }
        this.akS = aVar;
        this.akU = bdUniqueId;
        String str = Dm ? this.akS.aku : this.akS.akt;
        com.baidu.adp.widget.a.a aVar2 = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.d.hB().a(this.akS.aks, 20, this.akS.akv, this.akS.aks, Boolean.valueOf(Dm), str);
        if (aVar2 != null) {
            stopLoading();
            setGif(aVar2);
        } else if (this.akS.akr) {
            setGif(null);
        } else if (!com.baidu.adp.lib.f.d.hB().X(20) && this.akT) {
            b(true, this.akz);
        } else {
            startLoading();
            if (!z) {
                com.baidu.adp.lib.f.d.hB().a(this.akS.aks, 20, this.akV, 0, 0, this.akU, this.akS.akv, this.akS.aks, Boolean.valueOf(Dm), str);
            }
        }
    }

    public void zw() {
        stopLoading();
        this.akF = false;
        this.akL = false;
        if (this.akS != null) {
            com.baidu.adp.lib.f.d.hB().a(this.akS.aks, 20, this.akV);
        }
    }

    @Override // com.baidu.adp.newwidget.a.i
    public void refresh() {
        a(this.akS);
    }

    public void setSupportNoImage(boolean z) {
        this.akT = z;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(this);
        this.mOnClickListener = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.akS != null) {
            boolean Dm = com.baidu.tbadk.util.g.Dm();
            String str = Dm ? this.akS.aku : this.akS.akt;
            com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.d.hB().a(this.akS.aks, 20, this.akS.akv, this.akS.aks, Boolean.valueOf(Dm), str);
            if (aVar != null) {
                this.akS.akr = false;
                setGif(aVar);
            } else {
                startLoading();
                com.baidu.adp.lib.f.d.hB().a(this.akS.aks, 20, this.akV, 0, 0, this.akU, this.akS.akv, this.akS.aks, Boolean.valueOf(Dm), str);
                return;
            }
        }
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    public static Bitmap a(GifView gifView) {
        if (akJ != null && !akJ.isRecycled()) {
            return akJ;
        }
        BitmapDrawable bitmapDrawable = (BitmapDrawable) gifView.getResources().getDrawable(u.loading);
        if (bitmapDrawable != null) {
            akJ = bitmapDrawable.getBitmap();
        }
        return akJ;
    }
}
