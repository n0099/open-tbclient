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
    public static Bitmap akB;
    private float akA;
    private float akC;
    private boolean akD;
    private Drawable akE;
    private int akF;
    private final Rect akG;
    private final Rect akH;
    private boolean akI;
    private boolean akJ;
    private a akK;
    private boolean akL;
    private BdUniqueId akM;
    private final com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> akN;
    private final int akr;
    private WeakReference<com.baidu.adp.gif.c> aks;
    private int akt;
    private e aku;
    private boolean akv;
    private BitmapDrawable akw;
    private boolean akx;
    private Drawable aky;
    private boolean akz;
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
        this.akr = u.pic_expression_upload_selector;
        this.akv = false;
        this.akG = new Rect();
        this.akH = new Rect();
        this.akI = true;
        this.mHandler = new b(this, Looper.getMainLooper());
        this.mType = 20;
        this.akL = true;
        this.akN = new c(this);
        this.akw = (BitmapDrawable) getResources().getDrawable(u.icon_content_animation);
        this.akw.setBounds(0, 0, this.akw.getIntrinsicWidth(), this.akw.getIntrinsicHeight());
        this.akC = 30.0f;
        if (((BitmapDrawable) getResources().getDrawable(u.loading)) != null) {
            akB = a(this);
            this.akH.set(0, 0, akB.getWidth(), akB.getHeight());
        }
        this.aky = getResources().getDrawable(u.image_group_load_f);
        a(this.aky);
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
                this.akG.set(i7, i8, i7 + i6, i6 + i8);
            }
            int intrinsicWidth = this.aky.getIntrinsicWidth();
            int intrinsicHeight = this.aky.getIntrinsicHeight();
            if (intrinsicWidth > i5) {
                intrinsicWidth = i5;
            }
            if (intrinsicHeight > paddingBottom) {
                intrinsicHeight = paddingBottom;
            }
            int i9 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
            int i10 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
            this.aky.setBounds(i9, i10, intrinsicWidth + i9, intrinsicHeight + i10);
            if (this.akE != null) {
                int intrinsicWidth2 = this.akE.getIntrinsicWidth();
                int intrinsicHeight2 = this.akE.getIntrinsicHeight();
                if (intrinsicWidth2 > i5) {
                    intrinsicWidth2 = i5;
                }
                if (intrinsicHeight2 > paddingBottom) {
                    intrinsicHeight2 = paddingBottom;
                }
                int i11 = ((i5 - intrinsicWidth2) / 2) + paddingLeft;
                int i12 = ((paddingBottom - intrinsicHeight2) / 2) + paddingTop;
                this.akE.setBounds(i11, i12, intrinsicWidth2 + i11, intrinsicHeight2 + i12);
            }
        }
    }

    public static void releaseBitmap() {
        if (akB != null) {
            if (n.iW()) {
                akB = null;
            } else {
                new Handler(Looper.getMainLooper()).post(new d());
            }
        }
    }

    public void setGif(com.baidu.adp.widget.a.a aVar) {
        this.akx = false;
        this.akz = false;
        this.akD = false;
        if (this.akK != null) {
            this.akK.akj = false;
        }
        if (aVar == null) {
            this.akx = true;
            this.akv = false;
            if (this.akK != null) {
                this.akK.akj = true;
            }
            setImageDrawable(null);
            if (this.aks != null) {
                this.aks.clear();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.mx()) {
                this.akv = true;
                aVar.a(this);
                this.akz = false;
            }
            if (this.aks != null) {
                this.aks.clear();
            }
        } else if (this.aks == null || !aVar.getGif().equals(this.aks.get())) {
            this.akv = false;
            if (this.mBitmap == null || (this.mBitmap.getWidth() != aVar.getGif().getWidth() && this.mBitmap.getHeight() != aVar.getGif().getHeight())) {
                this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
            }
            this.aks = new WeakReference<>(aVar.getGif());
            aVar.getGif().C(0);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.akI) {
                play();
            }
        } else {
            aVar.getGif().C(this.akt);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.akI) {
                resume();
            }
        }
    }

    public boolean getAutoPlay() {
        return this.akI;
    }

    public void setAutoPlay(boolean z) {
        this.akI = z;
    }

    public void resume() {
        com.baidu.adp.gif.c cVar;
        if (this.aks != null && (cVar = this.aks.get()) != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, cVar.D(this.akt));
        }
    }

    public void stop() {
        com.baidu.adp.gif.c cVar;
        if (this.aks != null && (cVar = this.aks.get()) != null) {
            this.mHandler.removeMessages(1);
            cVar.C(0);
            cVar.a(this.mBitmap, null);
            invalidate();
        }
    }

    public void play() {
        com.baidu.adp.gif.c cVar;
        if (this.aks != null && (cVar = this.aks.get()) != null) {
            if (this.akt != 0) {
                this.akt = 0;
            }
            cVar.C(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, cVar.D(this.akt));
        }
    }

    public void onDestroy() {
        this.aks = null;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandler.removeMessages(1);
        zq();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.mHandler.removeMessages(1);
        zq();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (!this.akv) {
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
        if (!this.akz && !this.akx && !this.akD) {
            super.onDraw(canvas);
        }
        canvas.save();
        if (this.aks != null && !this.akz && !this.akx && !this.akD && (cVar = this.aks.get()) != null) {
            cVar.a(null, canvas);
        }
        canvas.restore();
        if (this.akv) {
            canvas.save();
            this.akw.draw(canvas);
            canvas.restore();
        }
        if (this.akz && a(this) != null) {
            canvas.save();
            canvas.rotate(this.akA, (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.5f) + getPaddingLeft(), (((getHeight() - getPaddingTop()) - getPaddingBottom()) * 0.5f) + getPaddingTop());
            canvas.drawBitmap(a(this), this.akH, this.akG, (Paint) null);
            canvas.restore();
        } else if (this.akx || (this.akK != null && this.akK.akj)) {
            canvas.save();
            this.aky.draw(canvas);
            canvas.restore();
        } else if (this.akD) {
            canvas.save();
            this.akE.draw(canvas);
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
        if (!this.akz) {
            this.akz = true;
            zp();
        }
    }

    public void b(boolean z, int i) {
        this.akD = z;
        if (z) {
            this.akz = false;
            this.akx = false;
            if (this.akE == null || this.akF != i) {
                this.akF = i;
                this.akE = ba.getDrawable(i);
                int intrinsicWidth = this.akE.getIntrinsicWidth();
                int intrinsicHeight = this.akE.getIntrinsicHeight();
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
                this.akE.setBounds(paddingLeft, paddingTop, intrinsicWidth + paddingLeft, intrinsicHeight + paddingTop);
            }
        }
        invalidate();
    }

    public com.baidu.adp.gif.c getGif() {
        if (this.aks == null) {
            return null;
        }
        return this.aks.get();
    }

    public void stopLoading() {
        this.akz = false;
        removeCallbacks(this);
        invalidate();
    }

    private void zp() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.akA += this.akC;
        if (this.akA > 360.0f - this.akC) {
            this.akA = 0.0f;
        }
        invalidate();
        zp();
    }

    public void setPlayCallback(e eVar) {
        this.aku = eVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.akE != null && this.akE.isStateful()) {
            this.akE.setState(getDrawableState());
            invalidate();
        }
    }

    public void a(a aVar) {
        BdUniqueId bdUniqueId;
        boolean z;
        if (aVar == null) {
            this.akK = null;
            return;
        }
        boolean Dg = com.baidu.tbadk.util.g.Dg();
        l B = m.B(getContext());
        if (B != null) {
            bdUniqueId = B.getUniqueId();
            z = B.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        if (!(aVar == this.akK && this.akM == bdUniqueId)) {
            zq();
        }
        this.akK = aVar;
        this.akM = bdUniqueId;
        String str = Dg ? this.akK.akm : this.akK.akl;
        com.baidu.adp.widget.a.a aVar2 = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.d.hB().a(this.akK.akk, 20, this.akK.akn, this.akK.akk, Boolean.valueOf(Dg), str);
        if (aVar2 != null) {
            stopLoading();
            setGif(aVar2);
        } else if (this.akK.akj) {
            setGif(null);
        } else if (!com.baidu.adp.lib.f.d.hB().X(20) && this.akL) {
            b(true, this.akr);
        } else {
            startLoading();
            if (!z) {
                com.baidu.adp.lib.f.d.hB().a(this.akK.akk, 20, this.akN, 0, 0, this.akM, this.akK.akn, this.akK.akk, Boolean.valueOf(Dg), str);
            }
        }
    }

    public void zq() {
        stopLoading();
        this.akx = false;
        this.akD = false;
        if (this.akK != null) {
            com.baidu.adp.lib.f.d.hB().a(this.akK.akk, 20, this.akN);
        }
    }

    @Override // com.baidu.adp.newwidget.a.i
    public void refresh() {
        a(this.akK);
    }

    public void setSupportNoImage(boolean z) {
        this.akL = z;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(this);
        this.mOnClickListener = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.akK != null) {
            boolean Dg = com.baidu.tbadk.util.g.Dg();
            String str = Dg ? this.akK.akm : this.akK.akl;
            com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.d.hB().a(this.akK.akk, 20, this.akK.akn, this.akK.akk, Boolean.valueOf(Dg), str);
            if (aVar != null) {
                this.akK.akj = false;
                setGif(aVar);
            } else {
                startLoading();
                com.baidu.adp.lib.f.d.hB().a(this.akK.akk, 20, this.akN, 0, 0, this.akM, this.akK.akn, this.akK.akk, Boolean.valueOf(Dg), str);
                return;
            }
        }
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    public static Bitmap a(GifView gifView) {
        if (akB != null && !akB.isRecycled()) {
            return akB;
        }
        BitmapDrawable bitmapDrawable = (BitmapDrawable) gifView.getResources().getDrawable(u.loading);
        if (bitmapDrawable != null) {
            akB = bitmapDrawable.getBitmap();
        }
        return akB;
    }
}
