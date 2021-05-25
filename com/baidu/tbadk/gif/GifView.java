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
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import d.a.c.a.j;
import d.a.c.d.a;
import d.a.c.f.a.i;
import d.a.m0.m.d;
import d.a.m0.z0.o;
import java.io.IOException;
/* loaded from: classes3.dex */
public class GifView extends TbImageView implements Runnable, View.OnClickListener, i {
    public static Bitmap k1;
    public c A0;
    public boolean B0;
    public boolean C0;
    public BitmapDrawable D0;
    public boolean E0;
    public boolean K0;
    public float L0;
    public float M0;
    public boolean N0;
    public Drawable O0;
    public int P0;
    public final Rect Q0;
    public final Rect R0;
    public boolean S0;
    public d T0;
    public View.OnClickListener U0;
    public boolean V0;
    public boolean W0;
    public boolean X0;
    public d.a.c.j.d.a Y0;
    public String Z0;
    public int a1;
    public int b1;
    public Handler c1;
    public boolean d1;
    public GifInfo e1;
    public int f1;
    public boolean g1;
    public BdUniqueId h1;
    public d.a.c.e.l.c<d.a.c.j.d.a> i1;
    public TbRichTextView.v j1;
    public int w0;
    public d.a.c.d.b x0;
    public Bitmap y0;
    public int z0;

    /* loaded from: classes3.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            boolean z;
            d.a.c.d.b gif = GifView.this.getGif();
            if (gif != null && message.what == 1) {
                GifView.this.z0++;
                boolean z2 = false;
                if (GifView.this.z0 >= gif.getFrameCount()) {
                    if (GifView.this.d1) {
                        if (!GifView.this.V0) {
                            GifView.this.setVisibility(4);
                        }
                        GifView.this.d1 = false;
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!GifView.this.V0) {
                        GifView.this.z0 = 0;
                    } else {
                        GifView.this.z0 = gif.getFrameCount() - 1;
                    }
                    z2 = z;
                }
                gif.c(GifView.this.z0);
                gif.a(GifView.this.y0, null);
                GifView.this.invalidate();
                removeMessages(1);
                if (!z2) {
                    sendEmptyMessageDelayed(1, gif.b(GifView.this.z0));
                } else {
                    GifView.this.p0();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends d.a.c.e.l.c<d.a.c.j.d.a> {
        public b() {
        }

        @Override // d.a.c.e.l.c
        public void onProgressUpdate(Object... objArr) {
            super.onProgressUpdate(objArr);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.j.d.a aVar, String str, int i2) {
            super.onLoaded((b) aVar, str, i2);
            GifView.this.Z();
            GifView.this.setGif(aVar);
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void onStop();
    }

    public GifView(Context context) {
        this(context, null, 0);
    }

    private void L() {
        removeCallbacks(this);
        postDelayed(this, 150L);
    }

    public static Bitmap j0(GifView gifView) {
        Bitmap bitmap = k1;
        if (bitmap != null && !bitmap.isRecycled()) {
            return k1;
        }
        BitmapDrawable bitmapDrawable = (BitmapDrawable) gifView.getResources().getDrawable(R.drawable.img_loading);
        if (bitmapDrawable != null) {
            k1 = bitmapDrawable.getBitmap();
        }
        return k1;
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void Q() {
        super.Q();
        this.x0 = null;
        this.y0 = null;
        this.c1.removeCallbacksAndMessages(null);
        this.E0 = false;
        this.z0 = 0;
        GifInfo gifInfo = this.e1;
        if (gifInfo != null) {
            gifInfo.mLoadFailed = false;
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void X() {
        if (this.K0) {
            return;
        }
        this.K0 = true;
        L();
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void Y() {
        Z();
        this.E0 = false;
        this.N0 = false;
        if (this.e1 != null) {
            d.a.c.e.l.d.h().d(this.e1.mSharpText, this.f1, this.i1);
        }
        if (TextUtils.isEmpty(this.Z0)) {
            return;
        }
        d.a.c.e.l.d.h().d(this.Z0, this.f1, this.i1);
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void Z() {
        this.K0 = false;
        removeCallbacks(this);
        invalidate();
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        TbRichTextView.v vVar = this.j1;
        if (vVar != null) {
            vVar.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.O0;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        this.O0.setState(getDrawableState());
        invalidate();
    }

    public boolean getAutoPlay() {
        return this.S0;
    }

    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView
    public d.a.c.j.d.a getBdImage() {
        return this.Y0;
    }

    public d.a.c.d.b getGif() {
        d.a.c.d.b bVar = this.x0;
        if (bVar == null) {
            p0();
            return null;
        }
        return bVar;
    }

    public GifInfo getGifInfo() {
        return this.e1;
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public int getImageHeight() {
        d.a.c.j.d.a aVar = this.Y0;
        if (aVar == null) {
            return 0;
        }
        return aVar.m();
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public int getImageWidth() {
        d.a.c.j.d.a aVar = this.Y0;
        if (aVar == null) {
            return 0;
        }
        return aVar.r();
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public float[] getRadius() {
        return d.a.m0.r.u.d.a.b(this.a1);
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public String getUrl() {
        return this.Z0;
    }

    public final boolean m0() {
        GifInfo gifInfo;
        return this.E0 || ((gifInfo = this.e1) != null && gifInfo.mLoadFailed);
    }

    public void n0() {
        this.Y0 = null;
        d.a.c.d.b bVar = this.x0;
        if (bVar != null) {
            bVar.close();
        }
        if (this.e1 != null) {
            this.e1 = null;
        }
        if (this.y0 != null) {
            this.y0 = null;
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View.OnClickListener
    public void onClick(View view) {
        d dVar = this.T0;
        if (dVar == null || !dVar.a(view)) {
            if (this.e1 != null) {
                boolean f2 = o.f();
                GifInfo gifInfo = this.e1;
                String str = f2 ? gifInfo.mDynamicUrl : gifInfo.mStaticUrl;
                d.a.c.e.l.d h2 = d.a.c.e.l.d.h();
                GifInfo gifInfo2 = this.e1;
                String str2 = gifInfo2.mSharpText;
                d.a.c.j.d.a aVar = (d.a.c.j.d.a) h2.n(str2, this.f1, gifInfo2.mGid, str2, Boolean.valueOf(f2), str);
                if (aVar != null) {
                    this.e1.mLoadFailed = false;
                    setGif(aVar);
                } else {
                    X();
                    d.a.c.e.l.d h3 = d.a.c.e.l.d.h();
                    GifInfo gifInfo3 = this.e1;
                    String str3 = gifInfo3.mSharpText;
                    h3.k(str3, this.f1, this.i1, 0, 0, this.h1, gifInfo3.mGid, str3, Boolean.valueOf(f2), str);
                    return;
                }
            }
            if (!TextUtils.isEmpty(this.Z0)) {
                d.a.c.j.d.a aVar2 = (d.a.c.j.d.a) d.a.c.e.l.d.h().n(this.Z0, this.f1, new Object[0]);
                if (aVar2 != null) {
                    this.E0 = false;
                    setGif(aVar2);
                } else {
                    X();
                    d.a.c.e.l.d.h().m(this.Z0, this.f1, this.i1, this.h1);
                    return;
                }
            }
            View.OnClickListener onClickListener = this.U0;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.c1.removeMessages(1);
        Y();
    }

    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        try {
            if ((!this.K0 && !this.E0 && !this.N0) || m0()) {
                super.onDraw(canvas);
            }
            canvas.save();
            if (this.x0 != null && !this.K0 && !this.E0 && !this.N0) {
                this.x0.a(null, canvas);
            }
            canvas.restore();
        } catch (Throwable th) {
            BdLog.e("setGif:" + th.getMessage());
            p0();
        }
        if (this.B0 && this.C0) {
            canvas.save();
            this.D0.draw(canvas);
            canvas.restore();
        }
        if (this.K0 && j0(this) != null) {
            canvas.save();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            float height = (((getHeight() - getPaddingTop()) - getPaddingBottom()) * 0.5f) + getPaddingTop();
            canvas.rotate(this.L0, (width * 0.5f) + getPaddingLeft(), height);
            canvas.drawBitmap(j0(this), this.R0, this.Q0, (Paint) null);
            canvas.restore();
        } else if (this.N0) {
            canvas.save();
            this.O0.draw(canvas);
            canvas.restore();
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView, android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 == i4 && i3 == i5) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = i3 - (getPaddingBottom() + paddingTop);
        int i6 = i2 - (paddingRight + paddingLeft);
        if (j0(this) != null) {
            int width = k1.getWidth();
            int height = k1.getHeight();
            int i7 = ((i6 - width) / 2) + paddingLeft;
            int i8 = ((paddingBottom - height) / 2) + paddingTop;
            this.Q0.set(i7, i8, width + i7, height + i8);
        }
        Drawable drawable = this.O0;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = this.O0.getIntrinsicHeight();
            if (intrinsicWidth > i6) {
                intrinsicWidth = i6;
            }
            if (intrinsicHeight > paddingBottom) {
                intrinsicHeight = paddingBottom;
            }
            int i9 = ((i6 - intrinsicWidth) / 2) + paddingLeft;
            int i10 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
            this.O0.setBounds(i9, i10, intrinsicWidth + i9, intrinsicHeight + i10);
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.c1.removeMessages(1);
        Y();
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        if (i2 == 4 || i2 == 8) {
            Y();
        }
        if (this.B0) {
            return;
        }
        if (i2 == 4 || i2 == 8) {
            y0();
        } else if (i2 == 0) {
            q0();
        }
    }

    public final void p0() {
        c cVar = this.A0;
        if (cVar == null || this.X0) {
            return;
        }
        cVar.onStop();
        this.X0 = true;
    }

    public void pause() {
        this.c1.removeMessages(1);
    }

    public void q0() {
        this.X0 = false;
        d.a.c.d.b gif = getGif();
        if (gif == null) {
            return;
        }
        if (this.z0 != 0) {
            this.z0 = 0;
        }
        gif.c(0);
        this.c1.removeMessages(1);
        this.c1.sendEmptyMessageDelayed(1, gif.b(this.z0));
    }

    @Override // com.baidu.tbadk.widget.TbImageView, d.a.c.f.a.i
    public void refresh() {
        GifInfo gifInfo = this.e1;
        if (gifInfo != null) {
            w0(gifInfo);
        }
        if (TextUtils.isEmpty(this.Z0)) {
            return;
        }
        x0(this.Z0, this.f1);
    }

    @Override // com.baidu.tbadk.widget.TbImageView, java.lang.Runnable
    public void run() {
        float f2 = this.L0;
        float f3 = this.M0;
        float f4 = f2 + f3;
        this.L0 = f4;
        if (f4 > 360.0f - f3) {
            this.L0 = 0.0f;
        }
        invalidate();
        L();
    }

    public void s0() {
        d.a.c.d.b bVar;
        Y();
        Q();
        if (!this.W0 || (bVar = this.x0) == null || bVar == null) {
            return;
        }
        bVar.close();
        this.x0 = null;
    }

    public void setAutoPlay(boolean z) {
        this.S0 = z;
    }

    public void setBgImage(d.a.c.j.d.a aVar) {
        this.Y0 = aVar;
    }

    public void setDefaultNoImageDay(int i2) {
        this.w0 = i2;
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void setDispatchTouchListener(TbRichTextView.v vVar) {
        this.j1 = vVar;
    }

    public void setErrorResid(int i2) {
        this.b1 = i2;
    }

    public void setGif(d.a.c.j.d.a aVar) {
        setBackgroundDrawable(null);
        this.Y0 = aVar;
        this.E0 = false;
        this.K0 = false;
        this.N0 = false;
        GifInfo gifInfo = this.e1;
        if (gifInfo != null) {
            gifInfo.mLoadFailed = false;
        }
        if (aVar == null) {
            this.E0 = true;
            this.B0 = false;
            GifInfo gifInfo2 = this.e1;
            if (gifInfo2 != null) {
                gifInfo2.mLoadFailed = true;
            }
            v0();
            d.a.c.d.b bVar = this.x0;
            if (bVar != null) {
                bVar.close();
            }
        } else if (aVar.l() == null) {
            if (!aVar.s()) {
                this.B0 = true;
                aVar.h(this);
                this.K0 = false;
            }
            d.a.c.d.b bVar2 = this.x0;
            if (bVar2 != null) {
                bVar2.close();
            }
        } else if (this.x0 != null && aVar.l().equals(this.x0)) {
            if (this.z0 >= aVar.l().getFrameCount()) {
                this.z0 = 0;
            }
            aVar.l().c(this.z0);
            aVar.l().a(this.y0, null);
            setImageBitmap(this.y0);
            if (this.S0) {
                u0();
            }
        } else {
            this.B0 = false;
            try {
                if (this.y0 == null || (this.y0.getWidth() != aVar.l().getWidth() && this.y0.getHeight() != aVar.l().getHeight())) {
                    this.y0 = Bitmap.createBitmap(aVar.l().getWidth(), aVar.l().getHeight(), Bitmap.Config.ARGB_8888);
                }
                this.x0 = aVar.l();
                aVar.l().c(0);
                aVar.l().a(this.y0, null);
                setImageBitmap(this.y0);
                if (this.S0) {
                    q0();
                }
            } catch (Throwable unused) {
                p0();
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:36:? */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:37:0x0043 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setGifRaw(int i2) {
        int i3;
        ?? openRawResource = getContext().getResources().openRawResource(i2);
        byte[] bArr = null;
        try {
            try {
                try {
                    i3 = openRawResource.available();
                    try {
                        bArr = new byte[i3];
                        openRawResource.read(bArr);
                        openRawResource.close();
                    } catch (IOException e2) {
                        e = e2;
                        BdLog.e(e.getMessage());
                        openRawResource.close();
                        if (bArr == null) {
                            return;
                        }
                        return;
                    } catch (OutOfMemoryError e3) {
                        e = e3;
                        BdLog.e(e.getMessage());
                        openRawResource.close();
                        if (bArr == null) {
                        }
                    }
                } catch (Throwable th) {
                    try {
                        openRawResource.close();
                    } catch (IOException e4) {
                        BdLog.e(e4.getMessage());
                    }
                    throw th;
                }
            } catch (IOException e5) {
                e = e5;
                i3 = 0;
            } catch (OutOfMemoryError e6) {
                e = e6;
                i3 = 0;
            }
        } catch (IOException e7) {
            openRawResource = e7.getMessage();
            BdLog.e((String) openRawResource);
        }
        if (bArr == null || bArr.length < i3) {
            return;
        }
        d.a.c.j.d.a a2 = a.C0480a.b().a(bArr, 0, i3);
        this.W0 = true;
        setGif(a2);
    }

    public void setHasNoImage(boolean z, int i2) {
        this.N0 = z;
        if (z) {
            this.K0 = false;
            this.E0 = false;
            if (this.O0 == null || this.P0 != i2) {
                this.P0 = i2;
                Drawable drawable = SkinManager.getDrawable(i2);
                this.O0 = drawable;
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = this.O0.getIntrinsicHeight();
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
                this.O0.setBounds(paddingLeft, paddingTop, intrinsicWidth + paddingLeft, intrinsicHeight + paddingTop);
            }
        } else {
            this.O0 = null;
        }
        invalidate();
    }

    public void setIsKeepLastFrame(boolean z) {
        this.V0 = z;
    }

    public void setIsLoading(boolean z) {
        if (z) {
            X();
        } else {
            Z();
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(this);
        this.U0 = onClickListener;
    }

    public void setOnInterceptClickListener(d dVar) {
        super.setOnClickListener(this);
        this.T0 = dVar;
    }

    public void setPlayCallback(c cVar) {
        this.A0 = cVar;
    }

    public void setShowStaticDrawable(boolean z) {
        this.C0 = z;
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void setSupportNoImage(boolean z) {
        super.setSupportNoImage(z);
        this.g1 = z;
    }

    public void setType(int i2) {
        this.f1 = i2;
    }

    public void t0() {
        this.w0 = R.drawable.pic_expression_upload_selector;
    }

    public void u0() {
        this.X0 = false;
        d.a.c.d.b gif = getGif();
        if (gif == null) {
            return;
        }
        this.c1.removeMessages(1);
        this.c1.sendEmptyMessageDelayed(1, gif.b(this.z0));
    }

    public final void v0() {
        SkinManager.setImageResource(this, this.b1);
    }

    public void w0(GifInfo gifInfo) {
        BdUniqueId bdUniqueId;
        boolean z;
        String str;
        this.f1 = 20;
        if (gifInfo == null) {
            this.e1 = null;
            v0();
            return;
        }
        boolean f2 = o.f();
        d.a.c.a.i c2 = j.c(getContext());
        if (c2 != null) {
            bdUniqueId = c2.getUniqueId();
            z = c2.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        GifInfo gifInfo2 = this.e1;
        if (!(gifInfo2 != null && (str = gifInfo.mDynamicUrl) != null && StringHelper.equals(str, gifInfo2.mDynamicUrl) && StringHelper.equals(gifInfo.mSharpText, this.e1.mSharpText) && StringHelper.equals(gifInfo.mStaticUrl, this.e1.mStaticUrl) && this.h1 == bdUniqueId)) {
            Y();
        }
        this.e1 = gifInfo;
        this.h1 = bdUniqueId;
        this.Z0 = null;
        Q();
        GifInfo gifInfo3 = this.e1;
        String str2 = f2 ? gifInfo3.mDynamicUrl : gifInfo3.mStaticUrl;
        d.a.c.e.l.d h2 = d.a.c.e.l.d.h();
        GifInfo gifInfo4 = this.e1;
        String str3 = gifInfo4.mSharpText;
        d.a.c.j.d.a aVar = (d.a.c.j.d.a) h2.n(str3, this.f1, gifInfo4.mGid, str3, Boolean.valueOf(f2), str2);
        if (aVar != null) {
            Z();
            setGif(aVar);
        } else if (this.e1.mLoadFailed) {
            setGif(null);
            v0();
        } else if (!d.a.c.e.l.d.h().j(this.f1) && this.g1) {
            setHasNoImage(true, this.w0);
        } else if (z) {
        } else {
            X();
            d.a.c.e.l.d h3 = d.a.c.e.l.d.h();
            GifInfo gifInfo5 = this.e1;
            String str4 = gifInfo5.mSharpText;
            h3.k(str4, this.f1, this.i1, 0, 0, this.h1, gifInfo5.mGid, str4, Boolean.valueOf(f2), str2);
        }
    }

    public void x0(String str, int i2) {
        BdUniqueId bdUniqueId;
        boolean z;
        this.f1 = i2;
        this.e1 = null;
        if (TextUtils.isEmpty(str)) {
            this.Z0 = null;
            v0();
            return;
        }
        d.a.c.a.i c2 = j.c(getContext());
        if (c2 != null) {
            bdUniqueId = c2.getUniqueId();
            z = c2.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        if (!(str.equals(this.Z0) && i2 == this.f1 && bdUniqueId == this.h1)) {
            Y();
        }
        this.h1 = bdUniqueId;
        Q();
        this.Z0 = str;
        this.e1 = null;
        d.a.c.j.d.a aVar = (d.a.c.j.d.a) d.a.c.e.l.d.h().n(str, i2, new Object[0]);
        if (aVar != null) {
            Z();
            setGif(aVar);
        } else if (!d.a.c.e.l.d.h().j(this.f1) && this.g1) {
            setHasNoImage(true, this.w0);
        } else if (z) {
        } else {
            d.a.c.e.l.d.h().m(this.Z0, i2, this.i1, this.h1);
        }
    }

    public void y0() {
        d.a.c.d.b gif = getGif();
        if (gif == null) {
            return;
        }
        this.c1.removeMessages(1);
        gif.c(0);
        gif.a(this.y0, null);
        invalidate();
        p0();
    }

    public GifView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GifView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        BitmapDrawable bitmapDrawable;
        this.w0 = R.drawable.pic_expression_upload_selector;
        this.B0 = false;
        this.C0 = true;
        this.Q0 = new Rect();
        this.R0 = new Rect();
        this.S0 = true;
        this.V0 = false;
        this.W0 = false;
        this.X0 = false;
        this.b1 = R.drawable.image_group_load_f;
        this.c1 = new a(Looper.getMainLooper());
        this.f1 = 20;
        this.g1 = true;
        this.i1 = new b();
        BitmapDrawable bitmapDrawable2 = (BitmapDrawable) getResources().getDrawable(R.drawable.icon_content_animation);
        this.D0 = bitmapDrawable2;
        bitmapDrawable2.setBounds(0, 0, bitmapDrawable2.getIntrinsicWidth(), this.D0.getIntrinsicHeight());
        this.M0 = 30.0f;
        try {
            bitmapDrawable = (BitmapDrawable) getResources().getDrawable(R.drawable.img_loading);
        } catch (Throwable th) {
            th.printStackTrace();
            bitmapDrawable = null;
        }
        if (bitmapDrawable != null) {
            Bitmap j0 = j0(this);
            k1 = j0;
            this.R0.set(0, 0, j0.getWidth(), k1.getHeight());
        }
        this.a1 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
    }
}
