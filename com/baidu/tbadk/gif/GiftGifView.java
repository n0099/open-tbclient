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
import com.baidu.tbadk.util.h;
import com.baidu.tieba.u;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class GiftGifView extends ImageView implements View.OnClickListener, i, Runnable {
    public static Bitmap auc;
    private BdUniqueId aeu;
    private int atV;
    private boolean atZ;
    private Drawable aua;
    private float aub;
    private float aud;
    private final Rect auh;
    private final Rect aui;
    private boolean auj;
    private boolean aun;
    private com.baidu.tbadk.gif.a auo;
    private final com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> auq;
    private WeakReference<com.baidu.adp.gif.b> aus;
    private a aut;
    private boolean auu;
    private boolean auv;
    private boolean isHide;
    private Bitmap mBitmap;
    private final Handler mHandler;
    private boolean mIsLoading;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes.dex */
    public interface a {
        void CO();

        void onStart();

        void onStop();
    }

    public GiftGifView(Context context) {
        this(context, null, 0);
    }

    public GiftGifView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GiftGifView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.auh = new Rect();
        this.aui = new Rect();
        this.auj = true;
        this.isHide = false;
        this.auu = false;
        this.auv = false;
        this.mHandler = new d(this, Looper.getMainLooper());
        this.auq = new e(this);
        this.aud = 30.0f;
        BitmapDrawable bitmapDrawable = (BitmapDrawable) getResources().getDrawable(u.f.loading);
        if (bitmapDrawable != null) {
            auc = bitmapDrawable.getBitmap();
            this.aui.set(0, 0, auc.getWidth(), auc.getHeight());
        }
        this.aua = getResources().getDrawable(u.f.image_group_load_f);
        c(this.aua);
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
            if (auc != null) {
                int i6 = i5 / 4;
                int i7 = ((i5 - i6) / 2) + paddingLeft;
                int i8 = ((paddingBottom - i6) / 2) + paddingTop;
                this.auh.set(i7, i8, i7 + i6, i6 + i8);
            }
            int intrinsicWidth = this.aua.getIntrinsicWidth();
            int intrinsicHeight = this.aua.getIntrinsicHeight();
            if (intrinsicWidth > i5) {
                intrinsicWidth = i5;
            }
            if (intrinsicHeight > paddingBottom) {
                intrinsicHeight = paddingBottom;
            }
            int i9 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
            int i10 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
            this.aua.setBounds(i9, i10, intrinsicWidth + i9, intrinsicHeight + i10);
        }
    }

    public void setGif(com.baidu.adp.widget.a.a aVar) {
        this.atZ = false;
        this.mIsLoading = false;
        if (this.auo != null) {
            this.auo.atO = false;
        }
        if (aVar == null) {
            this.atZ = true;
            if (this.auo != null) {
                this.auo.atO = true;
            }
            setImageDrawable(null);
            if (this.aus != null) {
                this.aus.clear();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.iZ()) {
                aVar.a(this);
                this.mIsLoading = false;
            }
            if (this.aus != null) {
                this.aus.clear();
            }
        } else if (this.aus == null || !aVar.getGif().equals(this.aus.get())) {
            if (this.mBitmap == null || this.mBitmap.getWidth() != aVar.getGif().getWidth() || this.mBitmap.getHeight() != aVar.getGif().getHeight() || this.auu) {
                this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
            }
            this.aus = new WeakReference<>(aVar.getGif());
            aVar.getGif().E(0);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.auj) {
                play();
            }
        } else {
            aVar.getGif().E(this.atV);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.auj) {
                resume();
            }
        }
    }

    public boolean getAutoPlay() {
        return this.auj;
    }

    public void setAutoPlay(boolean z) {
        this.auj = z;
    }

    public void resume() {
        com.baidu.adp.gif.b bVar;
        if (this.aus != null && (bVar = this.aus.get()) != null) {
            this.auv = false;
            if (this.isHide) {
                setVisibility(4);
                return;
            }
            this.aut.onStart();
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageDelayed(1, bVar.F(this.atV));
            this.mHandler.sendEmptyMessageDelayed(2, 2000L);
        }
    }

    public void stop() {
        com.baidu.adp.gif.b bVar;
        if (this.aus != null && (bVar = this.aus.get()) != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.atV = 0;
            bVar.E(0);
            bVar.a(this.mBitmap, null);
            invalidate();
        }
    }

    public void play() {
        com.baidu.adp.gif.b bVar;
        if (this.aus != null && (bVar = this.aus.get()) != null) {
            this.auv = false;
            if (this.isHide) {
                setVisibility(4);
                return;
            }
            this.aut.onStart();
            if (this.atV != 0) {
                this.atV = 0;
            }
            bVar.E(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageDelayed(1, bVar.F(this.atV));
            this.mHandler.sendEmptyMessageDelayed(2, 2000L);
        }
    }

    public void setPlayOnce(boolean z) {
        this.aun = z;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        CN();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.mHandler.removeMessages(1);
        CN();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 4 || i == 8) {
            this.isHide = true;
            stop();
            if (this.aut != null) {
                this.aut.onStop();
            }
        } else if (i == 0) {
            play();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        com.baidu.adp.gif.b bVar;
        if (!this.mIsLoading && !this.atZ) {
            super.onDraw(canvas);
        }
        canvas.save();
        if (this.aus != null && !this.mIsLoading && !this.atZ && (bVar = this.aus.get()) != null) {
            bVar.a(null, canvas);
        }
        canvas.restore();
        if (this.mIsLoading && auc != null) {
            canvas.save();
            canvas.rotate(this.aub, (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.5f) + getPaddingLeft(), (((getHeight() - getPaddingTop()) - getPaddingBottom()) * 0.5f) + getPaddingTop());
            canvas.drawBitmap(auc, this.aui, this.auh, (Paint) null);
            canvas.restore();
        } else if (this.atZ || (this.auo != null && this.auo.atO)) {
            canvas.save();
            this.aua.draw(canvas);
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
            CM();
        }
    }

    public com.baidu.adp.gif.b getGif() {
        if (this.aus == null) {
            return null;
        }
        return this.aus.get();
    }

    public void stopLoading() {
        this.mIsLoading = false;
        removeCallbacks(this);
        invalidate();
    }

    private void CM() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aub += this.aud;
        if (this.aub > 360.0f - this.aud) {
            this.aub = 0.0f;
        }
        invalidate();
        CM();
    }

    public void setPlayCallback(a aVar) {
        this.aut = aVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
    }

    public void a(com.baidu.tbadk.gif.a aVar) {
        BdUniqueId bdUniqueId;
        boolean z;
        if (aVar == null) {
            this.auo = null;
            return;
        }
        boolean FB = h.FB();
        k q = l.q(getContext());
        if (q != null) {
            bdUniqueId = q.getUniqueId();
            z = q.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        boolean z2 = aVar == this.auo && this.aeu == bdUniqueId;
        this.auu = !z2;
        if (!z2) {
            CN();
        }
        this.auo = aVar;
        this.aeu = bdUniqueId;
        String str = FB ? this.auo.atR : this.auo.atQ;
        com.baidu.adp.widget.a.a aVar2 = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.g.c.dG().a(this.auo.atP, 20, this.auo.mGid, this.auo.atP, Boolean.valueOf(FB), str);
        if (aVar2 != null) {
            stopLoading();
            setGif(aVar2);
        } else if (this.auo.atO) {
            setGif(null);
        } else {
            startLoading();
            if (!z) {
                com.baidu.adp.lib.g.c.dG().a(this.auo.atP, 20, this.auq, 0, 0, this.aeu, this.auo.mGid, this.auo.atP, Boolean.valueOf(FB), str);
            }
        }
    }

    public void CN() {
        stopLoading();
        this.atZ = false;
        if (this.auo != null) {
            com.baidu.adp.lib.g.c.dG().a(this.auo.atP, 20, this.auq);
        }
    }

    @Override // com.baidu.adp.newwidget.a.i
    public void refresh() {
        a(this.auo);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(this);
        this.mOnClickListener = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.auo != null) {
            boolean FB = h.FB();
            String str = FB ? this.auo.atR : this.auo.atQ;
            com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.g.c.dG().a(this.auo.atP, 20, this.auo.mGid, this.auo.atP, Boolean.valueOf(FB), str);
            if (aVar != null) {
                this.auo.atO = false;
                setGif(aVar);
            } else {
                startLoading();
                com.baidu.adp.lib.g.c.dG().a(this.auo.atP, 20, this.auq, 0, 0, this.aeu, this.auo.mGid, this.auo.atP, Boolean.valueOf(FB), str);
                return;
            }
        }
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    public void setIsHide(boolean z) {
        this.isHide = z;
    }
}
