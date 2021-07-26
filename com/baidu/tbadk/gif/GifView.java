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
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
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
import d.a.d.a.j;
import d.a.d.d.a;
import d.a.d.f.a.i;
import d.a.p0.b1.o;
import d.a.p0.n.d;
import java.io.IOException;
/* loaded from: classes3.dex */
public class GifView extends TbImageView implements Runnable, View.OnClickListener, i {
    public static /* synthetic */ Interceptable $ic;
    public static Bitmap g1;
    public transient /* synthetic */ FieldHolder $fh;
    public int A0;
    public c B0;
    public boolean C0;
    public boolean D0;
    public BitmapDrawable E0;
    public boolean F0;
    public boolean G0;
    public float H0;
    public float I0;
    public boolean J0;
    public Drawable K0;
    public int L0;
    public final Rect M0;
    public final Rect N0;
    public boolean O0;
    public d P0;
    public View.OnClickListener Q0;
    public boolean R0;
    public boolean S0;
    public boolean T0;
    public d.a.d.k.d.a U0;
    public String V0;
    public int W0;
    public int X0;
    public Handler Y0;
    public boolean Z0;
    public GifInfo a1;
    public int b1;
    public boolean c1;
    public BdUniqueId d1;
    public d.a.d.e.l.c<d.a.d.k.d.a> e1;
    public TbRichTextView.x f1;
    public int x0;
    public d.a.d.d.b y0;
    public Bitmap z0;

    /* loaded from: classes3.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GifView f13139a;

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
            this.f13139a = gifView;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d.a.d.d.b gif;
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && (gif = this.f13139a.getGif()) != null && message.what == 1) {
                this.f13139a.A0++;
                boolean z2 = false;
                if (this.f13139a.A0 >= gif.getFrameCount()) {
                    if (this.f13139a.Z0) {
                        if (!this.f13139a.R0) {
                            this.f13139a.setVisibility(4);
                        }
                        this.f13139a.Z0 = false;
                        z = true;
                    } else {
                        z = false;
                    }
                    if (this.f13139a.R0) {
                        this.f13139a.A0 = gif.getFrameCount() - 1;
                    } else {
                        this.f13139a.A0 = 0;
                    }
                    z2 = z;
                }
                gif.c(this.f13139a.A0);
                gif.a(this.f13139a.z0, null);
                this.f13139a.invalidate();
                removeMessages(1);
                if (!z2) {
                    sendEmptyMessageDelayed(1, gif.b(this.f13139a.A0));
                } else {
                    this.f13139a.d0();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends d.a.d.e.l.c<d.a.d.k.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GifView f13140a;

        public b(GifView gifView) {
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
            this.f13140a = gifView;
        }

        @Override // d.a.d.e.l.c
        public void onProgressUpdate(Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, objArr) == null) {
                super.onProgressUpdate(objArr);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.d.e.l.c
        public void onLoaded(d.a.d.k.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) {
                super.onLoaded((b) aVar, str, i2);
                this.f13140a.Q();
                this.f13140a.setGif(aVar);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
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

    private void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            removeCallbacks(this);
            postDelayed(this, 150L);
        }
    }

    public static Bitmap a0(GifView gifView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, gifView)) == null) {
            Bitmap bitmap = g1;
            if (bitmap != null && !bitmap.isRecycled()) {
                return g1;
            }
            BitmapDrawable bitmapDrawable = (BitmapDrawable) gifView.getResources().getDrawable(R.drawable.img_loading);
            if (bitmapDrawable != null) {
                g1 = bitmapDrawable.getBitmap();
            }
            return g1;
        }
        return (Bitmap) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.I();
            this.y0 = null;
            this.z0 = null;
            this.Y0.removeCallbacksAndMessages(null);
            this.F0 = false;
            this.A0 = 0;
            GifInfo gifInfo = this.a1;
            if (gifInfo != null) {
                gifInfo.mLoadFailed = false;
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void O() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.G0) {
            return;
        }
        this.G0 = true;
        A();
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Q();
            this.F0 = false;
            this.J0 = false;
            if (this.a1 != null) {
                d.a.d.e.l.d.h().d(this.a1.mSharpText, this.b1, this.e1);
            }
            if (TextUtils.isEmpty(this.V0)) {
                return;
            }
            d.a.d.e.l.d.h().d(this.V0, this.b1, this.e1);
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.G0 = false;
            removeCallbacks(this);
            invalidate();
        }
    }

    public final boolean b0() {
        InterceptResult invokeV;
        GifInfo gifInfo;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.F0 || ((gifInfo = this.a1) != null && gifInfo.mLoadFailed) : invokeV.booleanValue;
    }

    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.U0 = null;
            d.a.d.d.b bVar = this.y0;
            if (bVar != null) {
                bVar.close();
            }
            if (this.a1 != null) {
                this.a1 = null;
            }
            if (this.z0 != null) {
                this.z0 = null;
            }
        }
    }

    public final void d0() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (cVar = this.B0) == null || this.T0) {
            return;
        }
        cVar.onStop();
        this.T0 = true;
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, motionEvent)) == null) {
            TbRichTextView.x xVar = this.f1;
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
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.drawableStateChanged();
            Drawable drawable = this.K0;
            if (drawable == null || !drawable.isStateful()) {
                return;
            }
            this.K0.setState(getDrawableState());
            invalidate();
        }
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.T0 = false;
            d.a.d.d.b gif = getGif();
            if (gif == null) {
                return;
            }
            if (this.A0 != 0) {
                this.A0 = 0;
            }
            gif.c(0);
            this.Y0.removeMessages(1);
            this.Y0.sendEmptyMessageDelayed(1, gif.b(this.A0));
        }
    }

    public void f0() {
        d.a.d.d.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            P();
            I();
            if (!this.S0 || (bVar = this.y0) == null || bVar == null) {
                return;
            }
            bVar.close();
            this.y0 = null;
        }
    }

    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.x0 = R.drawable.pic_expression_upload_selector;
        }
    }

    public boolean getAutoPlay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.O0 : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView
    public d.a.d.k.d.a getBdImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.U0 : (d.a.d.k.d.a) invokeV.objValue;
    }

    public d.a.d.d.b getGif() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            d.a.d.d.b bVar = this.y0;
            if (bVar == null) {
                d0();
                return null;
            }
            return bVar;
        }
        return (d.a.d.d.b) invokeV.objValue;
    }

    public GifInfo getGifInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.a1 : (GifInfo) invokeV.objValue;
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public int getImageHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            d.a.d.k.d.a aVar = this.U0;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            d.a.d.k.d.a aVar = this.U0;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? d.a.p0.s.u.d.a.b(this.W0) : (float[]) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.V0 : (String) invokeV.objValue;
    }

    public void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.T0 = false;
            d.a.d.d.b gif = getGif();
            if (gif == null) {
                return;
            }
            this.Y0.removeMessages(1);
            this.Y0.sendEmptyMessageDelayed(1, gif.b(this.A0));
        }
    }

    public final void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            SkinManager.setImageResource(this, this.X0);
        }
    }

    public void k0(GifInfo gifInfo) {
        BdUniqueId bdUniqueId;
        boolean z;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, gifInfo) == null) {
            this.b1 = 20;
            if (gifInfo == null) {
                this.a1 = null;
                j0();
                return;
            }
            boolean f2 = o.f();
            d.a.d.a.i c2 = j.c(getContext());
            if (c2 != null) {
                bdUniqueId = c2.getUniqueId();
                z = c2.isScroll();
            } else {
                bdUniqueId = null;
                z = false;
            }
            GifInfo gifInfo2 = this.a1;
            if (!(gifInfo2 != null && (str = gifInfo.mDynamicUrl) != null && StringHelper.equals(str, gifInfo2.mDynamicUrl) && StringHelper.equals(gifInfo.mSharpText, this.a1.mSharpText) && StringHelper.equals(gifInfo.mStaticUrl, this.a1.mStaticUrl) && this.d1 == bdUniqueId)) {
                P();
            }
            this.a1 = gifInfo;
            this.d1 = bdUniqueId;
            this.V0 = null;
            I();
            GifInfo gifInfo3 = this.a1;
            String str2 = f2 ? gifInfo3.mDynamicUrl : gifInfo3.mStaticUrl;
            d.a.d.e.l.d h2 = d.a.d.e.l.d.h();
            GifInfo gifInfo4 = this.a1;
            String str3 = gifInfo4.mSharpText;
            d.a.d.k.d.a aVar = (d.a.d.k.d.a) h2.n(str3, this.b1, gifInfo4.mGid, str3, Boolean.valueOf(f2), str2);
            if (aVar != null) {
                Q();
                setGif(aVar);
            } else if (this.a1.mLoadFailed) {
                setGif(null);
                j0();
            } else if (!d.a.d.e.l.d.h().j(this.b1) && this.c1) {
                setHasNoImage(true, this.x0);
            } else if (z) {
            } else {
                O();
                d.a.d.e.l.d h3 = d.a.d.e.l.d.h();
                GifInfo gifInfo5 = this.a1;
                String str4 = gifInfo5.mSharpText;
                h3.k(str4, this.b1, this.e1, 0, 0, this.d1, gifInfo5.mGid, str4, Boolean.valueOf(f2), str2);
            }
        }
    }

    public void l0(String str, int i2) {
        BdUniqueId bdUniqueId;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048599, this, str, i2) == null) {
            this.b1 = i2;
            this.a1 = null;
            if (TextUtils.isEmpty(str)) {
                this.V0 = null;
                j0();
                return;
            }
            d.a.d.a.i c2 = j.c(getContext());
            if (c2 != null) {
                bdUniqueId = c2.getUniqueId();
                z = c2.isScroll();
            } else {
                bdUniqueId = null;
                z = false;
            }
            if (!(str.equals(this.V0) && i2 == this.b1 && bdUniqueId == this.d1)) {
                P();
            }
            this.d1 = bdUniqueId;
            I();
            this.V0 = str;
            this.a1 = null;
            d.a.d.k.d.a aVar = (d.a.d.k.d.a) d.a.d.e.l.d.h().n(str, i2, new Object[0]);
            if (aVar != null) {
                Q();
                setGif(aVar);
            } else if (!d.a.d.e.l.d.h().j(this.b1) && this.c1) {
                setHasNoImage(true, this.x0);
            } else if (z) {
            } else {
                d.a.d.e.l.d.h().m(this.V0, i2, this.e1, this.d1);
            }
        }
    }

    public void m0() {
        d.a.d.d.b gif;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || (gif = getGif()) == null) {
            return;
        }
        this.Y0.removeMessages(1);
        gif.c(0);
        gif.a(this.z0, null);
        invalidate();
        d0();
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, view) == null) {
            d dVar = this.P0;
            if (dVar == null || !dVar.a(view)) {
                if (this.a1 != null) {
                    boolean f2 = o.f();
                    GifInfo gifInfo = this.a1;
                    String str = f2 ? gifInfo.mDynamicUrl : gifInfo.mStaticUrl;
                    d.a.d.e.l.d h2 = d.a.d.e.l.d.h();
                    GifInfo gifInfo2 = this.a1;
                    String str2 = gifInfo2.mSharpText;
                    d.a.d.k.d.a aVar = (d.a.d.k.d.a) h2.n(str2, this.b1, gifInfo2.mGid, str2, Boolean.valueOf(f2), str);
                    if (aVar != null) {
                        this.a1.mLoadFailed = false;
                        setGif(aVar);
                    } else {
                        O();
                        d.a.d.e.l.d h3 = d.a.d.e.l.d.h();
                        GifInfo gifInfo3 = this.a1;
                        String str3 = gifInfo3.mSharpText;
                        h3.k(str3, this.b1, this.e1, 0, 0, this.d1, gifInfo3.mGid, str3, Boolean.valueOf(f2), str);
                        return;
                    }
                }
                if (!TextUtils.isEmpty(this.V0)) {
                    d.a.d.k.d.a aVar2 = (d.a.d.k.d.a) d.a.d.e.l.d.h().n(this.V0, this.b1, new Object[0]);
                    if (aVar2 != null) {
                        this.F0 = false;
                        setGif(aVar2);
                    } else {
                        O();
                        d.a.d.e.l.d.h().m(this.V0, this.b1, this.e1, this.d1);
                        return;
                    }
                }
                View.OnClickListener onClickListener = this.Q0;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.onDetachedFromWindow();
            this.Y0.removeMessages(1);
            P();
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, canvas) == null) {
            try {
                if ((!this.G0 && !this.F0 && !this.J0) || b0()) {
                    super.onDraw(canvas);
                }
                canvas.save();
                if (this.y0 != null && !this.G0 && !this.F0 && !this.J0) {
                    this.y0.a(null, canvas);
                }
                canvas.restore();
            } catch (Throwable th) {
                BdLog.e("setGif:" + th.getMessage());
                d0();
            }
            if (this.C0 && this.D0) {
                canvas.save();
                this.E0.draw(canvas);
                canvas.restore();
            }
            if (this.G0 && a0(this) != null) {
                canvas.save();
                int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                float height = (((getHeight() - getPaddingTop()) - getPaddingBottom()) * 0.5f) + getPaddingTop();
                canvas.rotate(this.H0, (width * 0.5f) + getPaddingLeft(), height);
                canvas.drawBitmap(a0(this), this.N0, this.M0, (Paint) null);
                canvas.restore();
            } else if (this.J0) {
                canvas.save();
                this.K0.draw(canvas);
                canvas.restore();
            }
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView, android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048604, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            if (i2 == i4 && i3 == i5) {
                return;
            }
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int paddingTop = getPaddingTop();
            int paddingBottom = i3 - (getPaddingBottom() + paddingTop);
            int i6 = i2 - (paddingRight + paddingLeft);
            if (a0(this) != null) {
                int width = g1.getWidth();
                int height = g1.getHeight();
                int i7 = ((i6 - width) / 2) + paddingLeft;
                int i8 = ((paddingBottom - height) / 2) + paddingTop;
                this.M0.set(i7, i8, width + i7, height + i8);
            }
            Drawable drawable = this.K0;
            if (drawable != null) {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = this.K0.getIntrinsicHeight();
                if (intrinsicWidth > i6) {
                    intrinsicWidth = i6;
                }
                if (intrinsicHeight > paddingBottom) {
                    intrinsicHeight = paddingBottom;
                }
                int i9 = ((i6 - intrinsicWidth) / 2) + paddingLeft;
                int i10 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
                this.K0.setBounds(i9, i10, intrinsicWidth + i9, intrinsicHeight + i10);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public void onStartTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            super.onStartTemporaryDetach();
            this.Y0.removeMessages(1);
            P();
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public void onWindowVisibilityChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i2) == null) {
            super.onWindowVisibilityChanged(i2);
            if (i2 == 4 || i2 == 8) {
                P();
            }
            if (this.C0) {
                return;
            }
            if (i2 == 4 || i2 == 8) {
                m0();
            } else if (i2 == 0) {
                e0();
            }
        }
    }

    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.Y0.removeMessages(1);
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, d.a.d.f.a.i
    public void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            GifInfo gifInfo = this.a1;
            if (gifInfo != null) {
                k0(gifInfo);
            }
            if (TextUtils.isEmpty(this.V0)) {
                return;
            }
            l0(this.V0, this.b1);
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            float f2 = this.H0;
            float f3 = this.I0;
            float f4 = f2 + f3;
            this.H0 = f4;
            if (f4 > 360.0f - f3) {
                this.H0 = 0.0f;
            }
            invalidate();
            A();
        }
    }

    public void setAutoPlay(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            this.O0 = z;
        }
    }

    public void setBgImage(d.a.d.k.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, aVar) == null) {
            this.U0 = aVar;
        }
    }

    public void setDefaultNoImageDay(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i2) == null) {
            this.x0 = i2;
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void setDispatchTouchListener(TbRichTextView.x xVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, xVar) == null) {
            this.f1 = xVar;
        }
    }

    public void setErrorResid(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i2) == null) {
            this.X0 = i2;
        }
    }

    public void setGif(d.a.d.k.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, aVar) == null) {
            setBackgroundDrawable(null);
            this.U0 = aVar;
            this.F0 = false;
            this.G0 = false;
            this.J0 = false;
            GifInfo gifInfo = this.a1;
            if (gifInfo != null) {
                gifInfo.mLoadFailed = false;
            }
            if (aVar == null) {
                this.F0 = true;
                this.C0 = false;
                GifInfo gifInfo2 = this.a1;
                if (gifInfo2 != null) {
                    gifInfo2.mLoadFailed = true;
                }
                j0();
                d.a.d.d.b bVar = this.y0;
                if (bVar != null) {
                    bVar.close();
                }
            } else if (aVar.l() == null) {
                if (!aVar.s()) {
                    this.C0 = true;
                    aVar.h(this);
                    this.G0 = false;
                }
                d.a.d.d.b bVar2 = this.y0;
                if (bVar2 != null) {
                    bVar2.close();
                }
            } else if (this.y0 != null && aVar.l().equals(this.y0)) {
                if (this.A0 >= aVar.l().getFrameCount()) {
                    this.A0 = 0;
                }
                aVar.l().c(this.A0);
                aVar.l().a(this.z0, null);
                setImageBitmap(this.z0);
                if (this.O0) {
                    i0();
                }
            } else {
                this.C0 = false;
                try {
                    if (this.z0 == null || (this.z0.getWidth() != aVar.l().getWidth() && this.z0.getHeight() != aVar.l().getHeight())) {
                        this.z0 = Bitmap.createBitmap(aVar.l().getWidth(), aVar.l().getHeight(), Bitmap.Config.ARGB_8888);
                    }
                    this.y0 = aVar.l();
                    aVar.l().c(0);
                    aVar.l().a(this.z0, null);
                    setImageBitmap(this.z0);
                    if (this.O0) {
                        e0();
                    }
                } catch (Throwable unused) {
                    d0();
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
    /* JADX WARN: Type inference failed for: r5v9, types: [d.a.d.d.a] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setGifRaw(int i2) {
        Interceptable interceptable;
        int i3;
        Interceptable interceptable2 = $ic;
        if (interceptable2 != null) {
            interceptable = interceptable2;
            if (interceptable.invokeI(1048616, this, i2) != null) {
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
            d.a.d.k.d.a a2 = a.C0554a.b().a(bArr, 0, interceptable);
            this.S0 = true;
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
        if (interceptable == null || interceptable.invokeCommon(1048617, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            this.J0 = z;
            if (z) {
                this.G0 = false;
                this.F0 = false;
                if (this.K0 == null || this.L0 != i2) {
                    this.L0 = i2;
                    Drawable drawable = SkinManager.getDrawable(i2);
                    this.K0 = drawable;
                    int intrinsicWidth = drawable.getIntrinsicWidth();
                    int intrinsicHeight = this.K0.getIntrinsicHeight();
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
                    this.K0.setBounds(paddingLeft, paddingTop, intrinsicWidth + paddingLeft, intrinsicHeight + paddingTop);
                }
            } else {
                this.K0 = null;
            }
            invalidate();
        }
    }

    public void setIsKeepLastFrame(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
            this.R0 = z;
        }
    }

    public void setIsLoading(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            if (z) {
                O();
            } else {
                Q();
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, onClickListener) == null) {
            super.setOnClickListener(this);
            this.Q0 = onClickListener;
        }
    }

    public void setOnInterceptClickListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, dVar) == null) {
            super.setOnClickListener(this);
            this.P0 = dVar;
        }
    }

    public void setPlayCallback(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, cVar) == null) {
            this.B0 = cVar;
        }
    }

    public void setShowStaticDrawable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z) == null) {
            this.D0 = z;
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void setSupportNoImage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048624, this, z) == null) {
            super.setSupportNoImage(z);
            this.c1 = z;
        }
    }

    public void setType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i2) == null) {
            this.b1 = i2;
        }
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
        this.x0 = R.drawable.pic_expression_upload_selector;
        this.C0 = false;
        this.D0 = true;
        this.M0 = new Rect();
        this.N0 = new Rect();
        this.O0 = true;
        this.R0 = false;
        this.S0 = false;
        this.T0 = false;
        this.X0 = R.drawable.image_group_load_f;
        this.Y0 = new a(this, Looper.getMainLooper());
        this.b1 = 20;
        this.c1 = true;
        this.e1 = new b(this);
        BitmapDrawable bitmapDrawable2 = (BitmapDrawable) getResources().getDrawable(R.drawable.icon_content_animation);
        this.E0 = bitmapDrawable2;
        bitmapDrawable2.setBounds(0, 0, bitmapDrawable2.getIntrinsicWidth(), this.E0.getIntrinsicHeight());
        this.I0 = 30.0f;
        try {
            bitmapDrawable = (BitmapDrawable) getResources().getDrawable(R.drawable.img_loading);
        } catch (Throwable th) {
            th.printStackTrace();
            bitmapDrawable = null;
        }
        if (bitmapDrawable != null) {
            Bitmap a0 = a0(this);
            g1 = a0;
            this.N0.set(0, 0, a0.getWidth(), g1.getHeight());
        }
        this.W0 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
    }
}
