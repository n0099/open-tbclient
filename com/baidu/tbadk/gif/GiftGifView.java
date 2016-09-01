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
import com.baidu.tieba.t;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class GiftGifView extends ImageView implements View.OnClickListener, i, Runnable {
    public static Bitmap axY;
    private BdUniqueId aid;
    private int axR;
    private boolean axV;
    private Drawable axW;
    private float axX;
    private float axZ;
    private final Rect ayd;
    private final Rect aye;
    private boolean ayf;
    private boolean ayj;
    private com.baidu.tbadk.gif.a ayk;
    private final com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> aym;
    private WeakReference<com.baidu.adp.gif.b> ayo;
    private a ayp;
    private boolean ayq;
    private boolean ayr;
    private boolean isHide;
    private Bitmap mBitmap;
    private final Handler mHandler;
    private boolean mIsLoading;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes.dex */
    public interface a {
        void Ei();

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
        this.ayd = new Rect();
        this.aye = new Rect();
        this.ayf = true;
        this.isHide = false;
        this.ayq = false;
        this.ayr = false;
        this.mHandler = new d(this, Looper.getMainLooper());
        this.aym = new e(this);
        this.axZ = 30.0f;
        BitmapDrawable bitmapDrawable = (BitmapDrawable) getResources().getDrawable(t.f.loading);
        if (bitmapDrawable != null) {
            axY = bitmapDrawable.getBitmap();
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
            if (axY != null) {
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
        }
    }

    public void setGif(com.baidu.adp.widget.a.a aVar) {
        this.axV = false;
        this.mIsLoading = false;
        if (this.ayk != null) {
            this.ayk.axK = false;
        }
        if (aVar == null) {
            this.axV = true;
            if (this.ayk != null) {
                this.ayk.axK = true;
            }
            setImageDrawable(null);
            if (this.ayo != null) {
                this.ayo.clear();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.jT()) {
                aVar.e(this);
                this.mIsLoading = false;
            }
            if (this.ayo != null) {
                this.ayo.clear();
            }
        } else if (this.ayo == null || !aVar.getGif().equals(this.ayo.get())) {
            if (this.mBitmap == null || this.mBitmap.getWidth() != aVar.getGif().getWidth() || this.mBitmap.getHeight() != aVar.getGif().getHeight() || this.ayq) {
                this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
            }
            this.ayo = new WeakReference<>(aVar.getGif());
            aVar.getGif().U(0);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.ayf) {
                play();
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

    public boolean getAutoPlay() {
        return this.ayf;
    }

    public void setAutoPlay(boolean z) {
        this.ayf = z;
    }

    public void resume() {
        com.baidu.adp.gif.b bVar;
        if (this.ayo != null && (bVar = this.ayo.get()) != null) {
            this.ayr = false;
            if (this.isHide) {
                setVisibility(4);
                return;
            }
            this.ayp.onStart();
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageDelayed(1, bVar.V(this.axR));
            this.mHandler.sendEmptyMessageDelayed(2, 2000L);
        }
    }

    public void stop() {
        com.baidu.adp.gif.b bVar;
        if (this.ayo != null && (bVar = this.ayo.get()) != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.axR = 0;
            bVar.U(0);
            bVar.a(this.mBitmap, null);
            invalidate();
        }
    }

    public void play() {
        com.baidu.adp.gif.b bVar;
        if (this.ayo != null && (bVar = this.ayo.get()) != null) {
            this.ayr = false;
            if (this.isHide) {
                setVisibility(4);
                return;
            }
            this.ayp.onStart();
            if (this.axR != 0) {
                this.axR = 0;
            }
            bVar.U(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageDelayed(1, bVar.V(this.axR));
            this.mHandler.sendEmptyMessageDelayed(2, 2000L);
        }
    }

    public void setPlayOnce(boolean z) {
        this.ayj = z;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
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
        if (i == 4 || i == 8) {
            this.isHide = true;
            stop();
            if (this.ayp != null) {
                this.ayp.onStop();
            }
        } else if (i == 0) {
            play();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        com.baidu.adp.gif.b bVar;
        if (!this.mIsLoading && !this.axV) {
            super.onDraw(canvas);
        }
        canvas.save();
        if (this.ayo != null && !this.mIsLoading && !this.axV && (bVar = this.ayo.get()) != null) {
            bVar.a(null, canvas);
        }
        canvas.restore();
        if (this.mIsLoading && axY != null) {
            canvas.save();
            canvas.rotate(this.axX, (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.5f) + getPaddingLeft(), (((getHeight() - getPaddingTop()) - getPaddingBottom()) * 0.5f) + getPaddingTop());
            canvas.drawBitmap(axY, this.aye, this.ayd, (Paint) null);
            canvas.restore();
        } else if (this.axV || (this.ayk != null && this.ayk.axK)) {
            canvas.save();
            this.axW.draw(canvas);
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

    public com.baidu.adp.gif.b getGif() {
        if (this.ayo == null) {
            return null;
        }
        return this.ayo.get();
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
        this.ayp = aVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
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
        boolean z2 = aVar == this.ayk && this.aid == bdUniqueId;
        this.ayq = !z2;
        if (!z2) {
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
        if (this.ayk != null) {
            com.baidu.adp.lib.g.c.eA().a(this.ayk.axL, 20, this.aym);
        }
    }

    @Override // com.baidu.adp.newwidget.a.i
    public void refresh() {
        a(this.ayk);
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

    public void setIsHide(boolean z) {
        this.isHide = z;
    }
}
