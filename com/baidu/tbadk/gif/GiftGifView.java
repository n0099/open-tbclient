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
import com.baidu.tbadk.util.g;
import com.baidu.tieba.r;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class GiftGifView extends ImageView implements View.OnClickListener, i, Runnable {
    public static Bitmap ays;
    private boolean ayD;
    private com.baidu.tbadk.gif.a ayE;
    private BdUniqueId ayG;
    private final com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> ayH;
    private WeakReference<com.baidu.adp.gif.b> ayJ;
    private a ayK;
    private boolean ayL;
    private boolean ayM;
    private int ayl;
    private boolean ayp;
    private Drawable ayq;
    private float ayr;
    private float ayt;
    private final Rect ayx;
    private final Rect ayy;
    private boolean ayz;
    private boolean isHide;
    private Bitmap mBitmap;
    private final Handler mHandler;
    private boolean mIsLoading;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes.dex */
    public interface a {
        void En();

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
        this.ayx = new Rect();
        this.ayy = new Rect();
        this.ayz = true;
        this.isHide = false;
        this.ayL = false;
        this.ayM = false;
        this.mHandler = new d(this, Looper.getMainLooper());
        this.ayH = new e(this);
        this.ayt = 30.0f;
        BitmapDrawable bitmapDrawable = (BitmapDrawable) getResources().getDrawable(r.f.loading);
        if (bitmapDrawable != null) {
            ays = bitmapDrawable.getBitmap();
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
            if (ays != null) {
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
        }
    }

    public void setGif(com.baidu.adp.widget.a.a aVar) {
        this.ayp = false;
        this.mIsLoading = false;
        if (this.ayE != null) {
            this.ayE.aye = false;
        }
        if (aVar == null) {
            this.ayp = true;
            if (this.ayE != null) {
                this.ayE.aye = true;
            }
            setImageDrawable(null);
            if (this.ayJ != null) {
                this.ayJ.clear();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.jT()) {
                aVar.e(this);
                this.mIsLoading = false;
            }
            if (this.ayJ != null) {
                this.ayJ.clear();
            }
        } else if (this.ayJ == null || !aVar.getGif().equals(this.ayJ.get())) {
            if (this.mBitmap == null || this.mBitmap.getWidth() != aVar.getGif().getWidth() || this.mBitmap.getHeight() != aVar.getGif().getHeight() || this.ayL) {
                this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
            }
            this.ayJ = new WeakReference<>(aVar.getGif());
            aVar.getGif().U(0);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.ayz) {
                play();
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

    public boolean getAutoPlay() {
        return this.ayz;
    }

    public void setAutoPlay(boolean z) {
        this.ayz = z;
    }

    public void resume() {
        com.baidu.adp.gif.b bVar;
        if (this.ayJ != null && (bVar = this.ayJ.get()) != null) {
            this.ayM = false;
            if (this.isHide) {
                setVisibility(4);
                return;
            }
            this.ayK.onStart();
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageDelayed(1, bVar.V(this.ayl));
            this.mHandler.sendEmptyMessageDelayed(2, 2000L);
        }
    }

    public void stop() {
        com.baidu.adp.gif.b bVar;
        if (this.ayJ != null && (bVar = this.ayJ.get()) != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.ayl = 0;
            bVar.U(0);
            bVar.a(this.mBitmap, null);
            invalidate();
        }
    }

    public void play() {
        com.baidu.adp.gif.b bVar;
        if (this.ayJ != null && (bVar = this.ayJ.get()) != null) {
            this.ayM = false;
            if (this.isHide) {
                setVisibility(4);
                return;
            }
            this.ayK.onStart();
            if (this.ayl != 0) {
                this.ayl = 0;
            }
            bVar.U(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageDelayed(1, bVar.V(this.ayl));
            this.mHandler.sendEmptyMessageDelayed(2, 2000L);
        }
    }

    public void setPlayOnce(boolean z) {
        this.ayD = z;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
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
        if (i == 4 || i == 8) {
            this.isHide = true;
            stop();
            if (this.ayK != null) {
                this.ayK.onStop();
            }
        } else if (i == 0) {
            play();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        com.baidu.adp.gif.b bVar;
        if (!this.mIsLoading && !this.ayp) {
            super.onDraw(canvas);
        }
        canvas.save();
        if (this.ayJ != null && !this.mIsLoading && !this.ayp && (bVar = this.ayJ.get()) != null) {
            bVar.a(null, canvas);
        }
        canvas.restore();
        if (this.mIsLoading && ays != null) {
            canvas.save();
            canvas.rotate(this.ayr, (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.5f) + getPaddingLeft(), (((getHeight() - getPaddingTop()) - getPaddingBottom()) * 0.5f) + getPaddingTop());
            canvas.drawBitmap(ays, this.ayy, this.ayx, (Paint) null);
            canvas.restore();
        } else if (this.ayp || (this.ayE != null && this.ayE.aye)) {
            canvas.save();
            this.ayq.draw(canvas);
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

    public com.baidu.adp.gif.b getGif() {
        if (this.ayJ == null) {
            return null;
        }
        return this.ayJ.get();
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
        this.ayK = aVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
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
        boolean z2 = aVar == this.ayE && this.ayG == bdUniqueId;
        this.ayL = !z2;
        if (!z2) {
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
        } else {
            startLoading();
            if (!z) {
                com.baidu.adp.lib.g.c.eA().a(this.ayE.ayf, 20, this.ayH, 0, 0, this.ayG, this.ayE.mGid, this.ayE.ayf, Boolean.valueOf(GY), str);
            }
        }
    }

    public void Em() {
        stopLoading();
        this.ayp = false;
        if (this.ayE != null) {
            com.baidu.adp.lib.g.c.eA().a(this.ayE.ayf, 20, this.ayH);
        }
    }

    @Override // com.baidu.adp.newwidget.a.i
    public void refresh() {
        a(this.ayE);
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

    public void setIsHide(boolean z) {
        this.isHide = z;
    }
}
