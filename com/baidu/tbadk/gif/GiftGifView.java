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
    public static Bitmap auR;
    private BdUniqueId afi;
    private int auK;
    private boolean auO;
    private Drawable auP;
    private float auQ;
    private float auS;
    private final Rect auW;
    private final Rect auX;
    private boolean auY;
    private boolean avc;
    private com.baidu.tbadk.gif.a avd;
    private final com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> avf;
    private WeakReference<com.baidu.adp.gif.b> avh;
    private a avi;
    private boolean avj;
    private boolean avk;
    private boolean isHide;
    private Bitmap mBitmap;
    private final Handler mHandler;
    private boolean mIsLoading;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes.dex */
    public interface a {
        void CN();

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
        this.auW = new Rect();
        this.auX = new Rect();
        this.auY = true;
        this.isHide = false;
        this.avj = false;
        this.avk = false;
        this.mHandler = new d(this, Looper.getMainLooper());
        this.avf = new e(this);
        this.auS = 30.0f;
        BitmapDrawable bitmapDrawable = (BitmapDrawable) getResources().getDrawable(u.f.loading);
        if (bitmapDrawable != null) {
            auR = bitmapDrawable.getBitmap();
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
            if (auR != null) {
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
        }
    }

    public void setGif(com.baidu.adp.widget.a.a aVar) {
        this.auO = false;
        this.mIsLoading = false;
        if (this.avd != null) {
            this.avd.auD = false;
        }
        if (aVar == null) {
            this.auO = true;
            if (this.avd != null) {
                this.avd.auD = true;
            }
            setImageDrawable(null);
            if (this.avh != null) {
                this.avh.clear();
            }
        } else if (aVar.getGif() == null) {
            if (!aVar.iY()) {
                aVar.e(this);
                this.mIsLoading = false;
            }
            if (this.avh != null) {
                this.avh.clear();
            }
        } else if (this.avh == null || !aVar.getGif().equals(this.avh.get())) {
            if (this.mBitmap == null || this.mBitmap.getWidth() != aVar.getGif().getWidth() || this.mBitmap.getHeight() != aVar.getGif().getHeight() || this.avj) {
                this.mBitmap = Bitmap.createBitmap(aVar.getGif().getWidth(), aVar.getGif().getHeight(), Bitmap.Config.ARGB_8888);
            }
            this.avh = new WeakReference<>(aVar.getGif());
            aVar.getGif().H(0);
            aVar.getGif().a(this.mBitmap, null);
            setImageBitmap(this.mBitmap);
            if (this.auY) {
                play();
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

    public boolean getAutoPlay() {
        return this.auY;
    }

    public void setAutoPlay(boolean z) {
        this.auY = z;
    }

    public void resume() {
        com.baidu.adp.gif.b bVar;
        if (this.avh != null && (bVar = this.avh.get()) != null) {
            this.avk = false;
            if (this.isHide) {
                setVisibility(4);
                return;
            }
            this.avi.onStart();
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageDelayed(1, bVar.I(this.auK));
            this.mHandler.sendEmptyMessageDelayed(2, 2000L);
        }
    }

    public void stop() {
        com.baidu.adp.gif.b bVar;
        if (this.avh != null && (bVar = this.avh.get()) != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.auK = 0;
            bVar.H(0);
            bVar.a(this.mBitmap, null);
            invalidate();
        }
    }

    public void play() {
        com.baidu.adp.gif.b bVar;
        if (this.avh != null && (bVar = this.avh.get()) != null) {
            this.avk = false;
            if (this.isHide) {
                setVisibility(4);
                return;
            }
            this.avi.onStart();
            if (this.auK != 0) {
                this.auK = 0;
            }
            bVar.H(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.sendEmptyMessageDelayed(1, bVar.I(this.auK));
            this.mHandler.sendEmptyMessageDelayed(2, 2000L);
        }
    }

    public void setPlayOnce(boolean z) {
        this.avc = z;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
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
        if (i == 4 || i == 8) {
            this.isHide = true;
            stop();
            if (this.avi != null) {
                this.avi.onStop();
            }
        } else if (i == 0) {
            play();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        com.baidu.adp.gif.b bVar;
        if (!this.mIsLoading && !this.auO) {
            super.onDraw(canvas);
        }
        canvas.save();
        if (this.avh != null && !this.mIsLoading && !this.auO && (bVar = this.avh.get()) != null) {
            bVar.a(null, canvas);
        }
        canvas.restore();
        if (this.mIsLoading && auR != null) {
            canvas.save();
            canvas.rotate(this.auQ, (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.5f) + getPaddingLeft(), (((getHeight() - getPaddingTop()) - getPaddingBottom()) * 0.5f) + getPaddingTop());
            canvas.drawBitmap(auR, this.auX, this.auW, (Paint) null);
            canvas.restore();
        } else if (this.auO || (this.avd != null && this.avd.auD)) {
            canvas.save();
            this.auP.draw(canvas);
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

    public com.baidu.adp.gif.b getGif() {
        if (this.avh == null) {
            return null;
        }
        return this.avh.get();
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
        this.avi = aVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
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
        boolean z2 = aVar == this.avd && this.afi == bdUniqueId;
        this.avj = !z2;
        if (!z2) {
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
        if (this.avd != null) {
            com.baidu.adp.lib.g.c.dF().a(this.avd.auE, 20, this.avf);
        }
    }

    @Override // com.baidu.adp.newwidget.a.i
    public void refresh() {
        a(this.avd);
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

    public void setIsHide(boolean z) {
        this.isHide = z;
    }
}
