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
import androidx.core.view.InputDeviceCompat;
import c.a.e.a.j;
import c.a.e.d.a;
import c.a.e.e.p.l;
import c.a.e.f.a.i;
import c.a.o0.b1.o;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.gif.NSGif;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes6.dex */
public class GifView extends TbImageView implements Runnable, View.OnClickListener, i {
    public static /* synthetic */ Interceptable $ic;
    public static Bitmap loadingBm;
    public transient /* synthetic */ FieldHolder $fh;
    public int A0;
    public boolean B0;
    public BdUniqueId C0;
    public c.a.e.e.l.c<c.a.e.k.d.a> D0;
    public TbRichTextView.x E0;
    public int O;
    public c.a.e.d.b P;
    public Bitmap Q;
    public int R;
    public d S;
    public boolean T;
    public boolean U;
    public BitmapDrawable V;
    public boolean W;
    public boolean a0;
    public float b0;
    public float c0;
    public boolean i0;
    public Drawable j0;
    public int k0;
    public final Rect l0;
    public final Rect m0;
    public boolean n0;
    public c.a.o0.n.d o0;
    public View.OnClickListener p0;
    public boolean q0;
    public boolean r0;
    public boolean s0;
    public c.a.e.k.d.a t0;
    public String u0;
    public int v0;
    public int w0;
    public Handler x0;
    public boolean y0;
    public GifInfo z0;

    /* loaded from: classes6.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GifView f48144a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(GifView gifView, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gifView, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48144a = gifView;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            c.a.e.d.b gif;
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && (gif = this.f48144a.getGif()) != null && message.what == 1) {
                this.f48144a.R++;
                boolean z2 = false;
                if (this.f48144a.R >= gif.getFrameCount()) {
                    if (this.f48144a.y0) {
                        if (!this.f48144a.q0) {
                            this.f48144a.setVisibility(4);
                        }
                        this.f48144a.y0 = false;
                        z = true;
                    } else {
                        z = false;
                    }
                    if (this.f48144a.q0) {
                        this.f48144a.R = gif.getFrameCount() - 1;
                    } else {
                        this.f48144a.R = 0;
                    }
                    z2 = z;
                }
                gif.c(this.f48144a.R);
                gif.a(this.f48144a.Q, null);
                this.f48144a.invalidate();
                removeMessages(1);
                if (!z2) {
                    sendEmptyMessageDelayed(1, gif.b(this.f48144a.R));
                } else {
                    this.f48144a.A();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                GifView.loadingBm = null;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends c.a.e.e.l.c<c.a.e.k.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GifView f48145a;

        public c(GifView gifView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gifView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48145a = gifView;
        }

        @Override // c.a.e.e.l.c
        public void onProgressUpdate(Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, objArr) == null) {
                super.onProgressUpdate(objArr);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.l.c
        public void onLoaded(c.a.e.k.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) {
                super.onLoaded((c) aVar, str, i2);
                this.f48145a.stopLoading();
                this.f48145a.setGif(aVar);
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface d {
        void onStop();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GifView(Context context) {
        this(context, null, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static Bitmap getLoadingBitmap(GifView gifView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, gifView)) == null) {
            Bitmap bitmap = loadingBm;
            if (bitmap != null && !bitmap.isRecycled()) {
                return loadingBm;
            }
            BitmapDrawable bitmapDrawable = (BitmapDrawable) gifView.getResources().getDrawable(R.drawable.img_loading);
            if (bitmapDrawable != null) {
                loadingBm = bitmapDrawable.getBitmap();
            }
            return loadingBm;
        }
        return (Bitmap) invokeL.objValue;
    }

    private void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            removeCallbacks(this);
            postDelayed(this, 150L);
        }
    }

    public static void releaseBitmap() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null) == null) || loadingBm == null) {
            return;
        }
        if (l.C()) {
            loadingBm = null;
        } else {
            new Handler(Looper.getMainLooper()).post(new b());
        }
    }

    public final void A() {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (dVar = this.S) == null || this.s0) {
            return;
        }
        dVar.onStop();
        this.s0 = true;
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setImageResource(this, this.w0);
        }
    }

    public void addCallback(c.a.e.d.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, motionEvent)) == null) {
            TbRichTextView.x xVar = this.E0;
            if (xVar != null) {
                xVar.dispatchTouchEvent(motionEvent);
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.drawableStateChanged();
            Drawable drawable = this.j0;
            if (drawable == null || !drawable.isStateful()) {
                return;
            }
            this.j0.setState(getDrawableState());
            invalidate();
        }
    }

    public boolean getAutoPlay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.n0 : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView
    public c.a.e.k.d.a getBdImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.t0 : (c.a.e.k.d.a) invokeV.objValue;
    }

    public c.a.e.d.b getGif() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            c.a.e.d.b bVar = this.P;
            if (bVar == null) {
                A();
                return null;
            }
            return bVar;
        }
        return (c.a.e.d.b) invokeV.objValue;
    }

    public GifInfo getGifInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.z0 : (GifInfo) invokeV.objValue;
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public int getImageHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            c.a.e.k.d.a aVar = this.t0;
            if (aVar == null) {
                return 0;
            }
            return aVar.m();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public int getImageWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            c.a.e.k.d.a aVar = this.t0;
            if (aVar == null) {
                return 0;
            }
            return aVar.r();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public float[] getRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? c.a.o0.s.u.d.a.b(this.v0) : (float[]) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.u0 : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view) == null) {
            c.a.o0.n.d dVar = this.o0;
            if (dVar == null || !dVar.onClickEvent(view)) {
                if (this.z0 != null) {
                    boolean f2 = o.f();
                    GifInfo gifInfo = this.z0;
                    String str = f2 ? gifInfo.mDynamicUrl : gifInfo.mStaticUrl;
                    c.a.e.e.l.d h2 = c.a.e.e.l.d.h();
                    GifInfo gifInfo2 = this.z0;
                    String str2 = gifInfo2.mSharpText;
                    c.a.e.k.d.a aVar = (c.a.e.k.d.a) h2.n(str2, this.A0, gifInfo2.mGid, str2, Boolean.valueOf(f2), str);
                    if (aVar != null) {
                        this.z0.mLoadFailed = false;
                        setGif(aVar);
                    } else {
                        startLoading();
                        c.a.e.e.l.d h3 = c.a.e.e.l.d.h();
                        GifInfo gifInfo3 = this.z0;
                        String str3 = gifInfo3.mSharpText;
                        h3.k(str3, this.A0, this.D0, 0, 0, this.C0, gifInfo3.mGid, str3, Boolean.valueOf(f2), str);
                        return;
                    }
                }
                if (!TextUtils.isEmpty(this.u0)) {
                    c.a.e.k.d.a aVar2 = (c.a.e.k.d.a) c.a.e.e.l.d.h().n(this.u0, this.A0, new Object[0]);
                    if (aVar2 != null) {
                        this.W = false;
                        setGif(aVar2);
                    } else {
                        startLoading();
                        c.a.e.e.l.d.h().m(this.u0, this.A0, this.D0, this.C0);
                        return;
                    }
                }
                View.OnClickListener onClickListener = this.p0;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.t0 = null;
            c.a.e.d.b bVar = this.P;
            if (bVar != null) {
                bVar.close();
            }
            if (this.z0 != null) {
                this.z0 = null;
            }
            if (this.Q != null) {
                this.Q = null;
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onDetachedFromWindow();
            this.x0.removeMessages(1);
            stopLoad();
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, canvas) == null) {
            try {
                if ((!this.a0 && !this.W && !this.i0) || z()) {
                    super.onDraw(canvas);
                }
                canvas.save();
                if (this.P != null && !this.a0 && !this.W && !this.i0) {
                    this.P.a(null, canvas);
                }
                canvas.restore();
            } catch (Throwable th) {
                BdLog.e("setGif:" + th.getMessage());
                A();
            }
            if (this.T && this.U) {
                canvas.save();
                this.V.draw(canvas);
                canvas.restore();
            }
            if (this.a0 && getLoadingBitmap(this) != null) {
                canvas.save();
                int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                float height = (((getHeight() - getPaddingTop()) - getPaddingBottom()) * 0.5f) + getPaddingTop();
                canvas.rotate(this.b0, (width * 0.5f) + getPaddingLeft(), height);
                canvas.drawBitmap(getLoadingBitmap(this), this.m0, this.l0, (Paint) null);
                canvas.restore();
            } else if (this.i0) {
                canvas.save();
                this.j0.draw(canvas);
                canvas.restore();
            }
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView, android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048593, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            if (i2 == i4 && i3 == i5) {
                return;
            }
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int paddingTop = getPaddingTop();
            int paddingBottom = i3 - (getPaddingBottom() + paddingTop);
            int i6 = i2 - (paddingRight + paddingLeft);
            if (getLoadingBitmap(this) != null) {
                int width = loadingBm.getWidth();
                int height = loadingBm.getHeight();
                int i7 = ((i6 - width) / 2) + paddingLeft;
                int i8 = ((paddingBottom - height) / 2) + paddingTop;
                this.l0.set(i7, i8, width + i7, height + i8);
            }
            Drawable drawable = this.j0;
            if (drawable != null) {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = this.j0.getIntrinsicHeight();
                if (intrinsicWidth > i6) {
                    intrinsicWidth = i6;
                }
                if (intrinsicHeight > paddingBottom) {
                    intrinsicHeight = paddingBottom;
                }
                int i9 = ((i6 - intrinsicWidth) / 2) + paddingLeft;
                int i10 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
                this.j0.setBounds(i9, i10, intrinsicWidth + i9, intrinsicHeight + i10);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public void onStartTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onStartTemporaryDetach();
            this.x0.removeMessages(1);
            stopLoad();
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public void onWindowVisibilityChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            super.onWindowVisibilityChanged(i2);
            if (i2 == 4 || i2 == 8) {
                stopLoad();
            }
            if (this.T) {
                return;
            }
            if (i2 == 4 || i2 == 8) {
                stop();
            } else if (i2 == 0) {
                play();
            }
        }
    }

    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.x0.removeMessages(1);
        }
    }

    public void play() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.s0 = false;
            c.a.e.d.b gif = getGif();
            if (gif == null) {
                return;
            }
            if (this.R != 0) {
                this.R = 0;
            }
            gif.c(0);
            this.x0.removeMessages(1);
            this.x0.sendEmptyMessageDelayed(1, gif.b(this.R));
        }
    }

    public void playOnce() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.y0 = true;
            play();
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, c.a.e.f.a.i
    public void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            GifInfo gifInfo = this.z0;
            if (gifInfo != null) {
                startLoad(gifInfo);
            }
            if (TextUtils.isEmpty(this.u0)) {
                return;
            }
            startLoad(this.u0, this.A0);
        }
    }

    public void release() {
        c.a.e.d.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            stopLoad();
            reset();
            if (!this.r0 || (bVar = this.P) == null || bVar == null) {
                return;
            }
            bVar.close();
            this.P = null;
        }
    }

    public void removeCallback(c.a.e.d.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, cVar) == null) {
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.reset();
            this.P = null;
            this.Q = null;
            this.x0.removeCallbacksAndMessages(null);
            this.W = false;
            this.R = 0;
            GifInfo gifInfo = this.z0;
            if (gifInfo != null) {
                gifInfo.mLoadFailed = false;
            }
        }
    }

    public void resetDefaultNoImageDay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.O = R.drawable.pic_expression_upload_selector;
        }
    }

    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.s0 = false;
            c.a.e.d.b gif = getGif();
            if (gif == null) {
                return;
            }
            this.x0.removeMessages(1);
            this.x0.sendEmptyMessageDelayed(1, gif.b(this.R));
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            float f2 = this.b0;
            float f3 = this.c0;
            float f4 = f2 + f3;
            this.b0 = f4;
            if (f4 > 360.0f - f3) {
                this.b0 = 0.0f;
            }
            invalidate();
            m();
        }
    }

    public void setAutoPlay(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            this.n0 = z;
        }
    }

    public void setBgImage(c.a.e.k.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, aVar) == null) {
            this.t0 = aVar;
        }
    }

    public void setDefaultNoImageDay(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            this.O = i2;
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void setDispatchTouchListener(TbRichTextView.x xVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, xVar) == null) {
            this.E0 = xVar;
        }
    }

    public void setErrorResid(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i2) == null) {
            this.w0 = i2;
        }
    }

    public void setGif(c.a.e.k.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, aVar) == null) {
            setBackgroundDrawable(null);
            this.t0 = aVar;
            this.W = false;
            this.a0 = false;
            this.i0 = false;
            GifInfo gifInfo = this.z0;
            if (gifInfo != null) {
                gifInfo.mLoadFailed = false;
            }
            if (aVar == null) {
                this.W = true;
                this.T = false;
                GifInfo gifInfo2 = this.z0;
                if (gifInfo2 != null) {
                    gifInfo2.mLoadFailed = true;
                }
                B();
                c.a.e.d.b bVar = this.P;
                if (bVar != null) {
                    bVar.close();
                }
            } else if (aVar.l() == null) {
                if (!aVar.s()) {
                    this.T = true;
                    aVar.h(this);
                    this.a0 = false;
                }
                c.a.e.d.b bVar2 = this.P;
                if (bVar2 != null) {
                    bVar2.close();
                }
            } else if (this.P != null && aVar.l().equals(this.P)) {
                if (this.R >= aVar.l().getFrameCount()) {
                    this.R = 0;
                }
                aVar.l().c(this.R);
                aVar.l().a(this.Q, null);
                setImageBitmap(this.Q);
                if (this.n0) {
                    resume();
                }
            } else {
                this.T = false;
                try {
                    if (this.Q == null || (this.Q.getWidth() != aVar.l().getWidth() && this.Q.getHeight() != aVar.l().getHeight())) {
                        this.Q = Bitmap.createBitmap(aVar.l().getWidth(), aVar.l().getHeight(), Bitmap.Config.ARGB_8888);
                    }
                    this.P = aVar.l();
                    aVar.l().c(0);
                    aVar.l().a(this.Q, null);
                    setImageBitmap(this.Q);
                    if (this.n0) {
                        play();
                    }
                } catch (Throwable unused) {
                    A();
                }
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:11:0x0028 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:13:0x002a */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:40:0x0047 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:41:0x0012 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:45:0x0012 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v9, types: [c.a.e.d.a] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setGifRaw(int i2) {
        Interceptable interceptable;
        int i3;
        Interceptable interceptable2 = $ic;
        if (interceptable2 != null) {
            interceptable = interceptable2;
            if (interceptable.invokeI(1048612, this, i2) != null) {
                return;
            }
        }
        ?? openRawResource = getContext().getResources().openRawResource(i2);
        byte[] bArr = null;
        try {
            try {
                try {
                    i3 = openRawResource.available();
                } catch (IOException e2) {
                    openRawResource = e2.getMessage();
                    BdLog.e((String) openRawResource);
                }
                try {
                    bArr = new byte[i3];
                    openRawResource.read(bArr);
                    openRawResource.close();
                    interceptable = i3;
                } catch (IOException e3) {
                    e = e3;
                    BdLog.e(e.getMessage());
                    openRawResource.close();
                    interceptable = i3;
                    if (bArr == null) {
                        return;
                    }
                    return;
                } catch (OutOfMemoryError e4) {
                    e = e4;
                    BdLog.e(e.getMessage());
                    openRawResource.close();
                    interceptable = i3;
                    if (bArr == null) {
                    }
                }
            } catch (IOException e5) {
                e = e5;
                i3 = 0;
            } catch (OutOfMemoryError e6) {
                e = e6;
                i3 = 0;
            }
            if (bArr == null || bArr.length < interceptable) {
                return;
            }
            c.a.e.k.d.a a2 = a.C0040a.b().a(bArr, 0, interceptable);
            this.r0 = true;
            setGif(a2);
        } catch (Throwable th) {
            try {
                openRawResource.close();
            } catch (IOException e7) {
                BdLog.e(e7.getMessage());
            }
            throw th;
        }
    }

    public void setHasNoImage(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            this.i0 = z;
            if (z) {
                this.a0 = false;
                this.W = false;
                if (this.j0 == null || this.k0 != i2) {
                    this.k0 = i2;
                    Drawable drawable = SkinManager.getDrawable(i2);
                    this.j0 = drawable;
                    int intrinsicWidth = drawable.getIntrinsicWidth();
                    int intrinsicHeight = this.j0.getIntrinsicHeight();
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
                    this.j0.setBounds(paddingLeft, paddingTop, intrinsicWidth + paddingLeft, intrinsicHeight + paddingTop);
                }
            } else {
                this.j0 = null;
            }
            invalidate();
        }
    }

    public void setIsKeepLastFrame(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            this.q0 = z;
        }
    }

    public void setIsLoading(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            if (z) {
                startLoading();
            } else {
                stopLoading();
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, onClickListener) == null) {
            super.setOnClickListener(this);
            this.p0 = onClickListener;
        }
    }

    public void setOnInterceptClickListener(c.a.o0.n.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, dVar) == null) {
            super.setOnClickListener(this);
            this.o0 = dVar;
        }
    }

    public void setPlayCallback(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, dVar) == null) {
            this.S = dVar;
        }
    }

    public void setShowStaticDrawable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            this.U = z;
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void setSupportNoImage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048620, this, z) == null) {
            super.setSupportNoImage(z);
            this.B0 = z;
        }
    }

    public void setType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i2) == null) {
            this.A0 = i2;
        }
    }

    public void startLoad(GifInfo gifInfo) {
        BdUniqueId bdUniqueId;
        boolean z;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, gifInfo) == null) {
            this.A0 = 20;
            if (gifInfo == null) {
                this.z0 = null;
                B();
                return;
            }
            boolean f2 = o.f();
            c.a.e.a.i c2 = j.c(getContext());
            if (c2 != null) {
                bdUniqueId = c2.getUniqueId();
                z = c2.isScroll();
            } else {
                bdUniqueId = null;
                z = false;
            }
            GifInfo gifInfo2 = this.z0;
            if (!(gifInfo2 != null && (str = gifInfo.mDynamicUrl) != null && StringHelper.equals(str, gifInfo2.mDynamicUrl) && StringHelper.equals(gifInfo.mSharpText, this.z0.mSharpText) && StringHelper.equals(gifInfo.mStaticUrl, this.z0.mStaticUrl) && this.C0 == bdUniqueId)) {
                stopLoad();
            }
            this.z0 = gifInfo;
            this.C0 = bdUniqueId;
            this.u0 = null;
            reset();
            GifInfo gifInfo3 = this.z0;
            String str2 = f2 ? gifInfo3.mDynamicUrl : gifInfo3.mStaticUrl;
            c.a.e.e.l.d h2 = c.a.e.e.l.d.h();
            GifInfo gifInfo4 = this.z0;
            String str3 = gifInfo4.mSharpText;
            c.a.e.k.d.a aVar = (c.a.e.k.d.a) h2.n(str3, this.A0, gifInfo4.mGid, str3, Boolean.valueOf(f2), str2);
            if (aVar != null) {
                stopLoading();
                setGif(aVar);
            } else if (this.z0.mLoadFailed) {
                setGif(null);
                B();
            } else if (!c.a.e.e.l.d.h().j(this.A0) && this.B0) {
                setHasNoImage(true, this.O);
            } else if (z) {
            } else {
                startLoading();
                c.a.e.e.l.d h3 = c.a.e.e.l.d.h();
                GifInfo gifInfo5 = this.z0;
                String str4 = gifInfo5.mSharpText;
                h3.k(str4, this.A0, this.D0, 0, 0, this.C0, gifInfo5.mGid, str4, Boolean.valueOf(f2), str2);
            }
        }
    }

    public void startLoadGifOrBitmapByByte(byte[] bArr, Bitmap bitmap, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048624, this, bArr, bitmap, z) == null) || bArr == null || bArr.length <= 0 || bitmap == null) {
            return;
        }
        if (!c.a.e.e.l.d.h().j(this.A0) && this.B0) {
            setHasNoImage(true, this.O);
        } else if (!z) {
            if (bitmap != null) {
                setImageBitmap(bitmap);
            }
        } else {
            NSGif f2 = NSGif.f(bArr, 0, bArr.length);
            if (f2 == null) {
                return;
            }
            this.P = f2;
            f2.c(0);
            Bitmap bitmap2 = this.Q;
            if (bitmap2 == null || (bitmap2.getWidth() != this.P.getWidth() && this.Q.getHeight() != this.P.getHeight())) {
                this.Q = Bitmap.createBitmap(this.P.getWidth(), this.P.getHeight(), Bitmap.Config.ARGB_8888);
            }
            this.P.a(this.Q, null);
            setImageBitmap(this.Q);
            play();
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void startLoading() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048625, this) == null) || this.a0) {
            return;
        }
        this.a0 = true;
        m();
    }

    public void stop() {
        c.a.e.d.b gif;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048626, this) == null) || (gif = getGif()) == null) {
            return;
        }
        this.x0.removeMessages(1);
        gif.c(0);
        gif.a(this.Q, null);
        invalidate();
        A();
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void stopLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            stopLoading();
            this.W = false;
            this.i0 = false;
            if (this.z0 != null) {
                c.a.e.e.l.d.h().d(this.z0.mSharpText, this.A0, this.D0);
            }
            if (TextUtils.isEmpty(this.u0)) {
                return;
            }
            c.a.e.e.l.d.h().d(this.u0, this.A0, this.D0);
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void stopLoading() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            this.a0 = false;
            removeCallbacks(this);
            invalidate();
        }
    }

    public final boolean z() {
        InterceptResult invokeV;
        GifInfo gifInfo;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.W || ((gifInfo = this.z0) != null && gifInfo.mLoadFailed) : invokeV.booleanValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GifView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GifView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        BitmapDrawable bitmapDrawable;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.O = R.drawable.pic_expression_upload_selector;
        this.T = false;
        this.U = true;
        this.l0 = new Rect();
        this.m0 = new Rect();
        this.n0 = true;
        this.q0 = false;
        this.r0 = false;
        this.s0 = false;
        this.w0 = R.drawable.image_group_load_f;
        this.x0 = new a(this, Looper.getMainLooper());
        this.A0 = 20;
        this.B0 = true;
        this.D0 = new c(this);
        BitmapDrawable bitmapDrawable2 = (BitmapDrawable) getResources().getDrawable(R.drawable.icon_content_animation);
        this.V = bitmapDrawable2;
        bitmapDrawable2.setBounds(0, 0, bitmapDrawable2.getIntrinsicWidth(), this.V.getIntrinsicHeight());
        this.c0 = 30.0f;
        try {
            bitmapDrawable = (BitmapDrawable) getResources().getDrawable(R.drawable.img_loading);
        } catch (Throwable th) {
            th.printStackTrace();
            bitmapDrawable = null;
        }
        if (bitmapDrawable != null) {
            Bitmap loadingBitmap = getLoadingBitmap(this);
            loadingBm = loadingBitmap;
            this.m0.set(0, 0, loadingBitmap.getWidth(), loadingBm.getHeight());
        }
        this.v0 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
    }

    public void startLoad(String str, int i2) {
        BdUniqueId bdUniqueId;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048623, this, str, i2) == null) {
            this.A0 = i2;
            this.z0 = null;
            if (TextUtils.isEmpty(str)) {
                this.u0 = null;
                B();
                return;
            }
            c.a.e.a.i c2 = j.c(getContext());
            if (c2 != null) {
                bdUniqueId = c2.getUniqueId();
                z = c2.isScroll();
            } else {
                bdUniqueId = null;
                z = false;
            }
            if (!(str.equals(this.u0) && i2 == this.A0 && bdUniqueId == this.C0)) {
                stopLoad();
            }
            this.C0 = bdUniqueId;
            reset();
            this.u0 = str;
            this.z0 = null;
            c.a.e.k.d.a aVar = (c.a.e.k.d.a) c.a.e.e.l.d.h().n(str, i2, new Object[0]);
            if (aVar != null) {
                stopLoading();
                setGif(aVar);
            } else if (!c.a.e.e.l.d.h().j(this.A0) && this.B0) {
                setHasNoImage(true, this.O);
            } else if (z) {
            } else {
                c.a.e.e.l.d.h().m(this.u0, i2, this.D0, this.C0);
            }
        }
    }
}
