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
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.bg;
import com.baidu.tieba.cg;
import com.baidu.tieba.f9;
import com.baidu.tieba.g9;
import com.baidu.tieba.hq5;
import com.baidu.tieba.mb;
import com.baidu.tieba.nb;
import com.baidu.tieba.nf5;
import com.baidu.tieba.qk;
import com.baidu.tieba.s25;
import com.baidu.tieba.tm;
import com.baidu.tieba.yu4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes3.dex */
public class GifView extends TbClipImageView implements Runnable, View.OnClickListener, qk {
    public static /* synthetic */ Interceptable $ic;
    public static Bitmap i1;
    public transient /* synthetic */ FieldHolder $fh;
    public int A0;
    public c B0;
    public boolean C0;
    public boolean D0;
    public boolean E0;
    public BitmapDrawable F0;
    public boolean G0;
    public boolean H0;
    public float I0;
    public float J0;
    public boolean K0;
    public Drawable L0;
    public int M0;
    public final Rect N0;
    public final Rect O0;
    public boolean P0;
    public yu4 Q0;
    public View.OnClickListener R0;
    public boolean S0;
    public boolean T0;
    public boolean U0;
    public tm V0;
    public String W0;
    public int X0;
    public nf5 Y0;
    public int Z0;
    public Handler a1;
    public boolean b1;
    public GifInfo c1;
    public int d1;
    public boolean e1;
    public BdUniqueId f1;
    public bg<tm> g1;
    public TbRichTextView.y h1;
    public int x0;
    public nb y0;
    public Bitmap z0;

    /* loaded from: classes3.dex */
    public interface c {
        void onStop();
    }

    /* loaded from: classes3.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GifView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(GifView gifView, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gifView, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gifView;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            nb gif;
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && (gif = this.a.getGif()) != null && message.what == 1) {
                this.a.A0++;
                boolean z2 = false;
                if (this.a.A0 >= gif.getFrameCount()) {
                    if (this.a.b1) {
                        if (!this.a.S0) {
                            this.a.setVisibility(4);
                        }
                        this.a.b1 = false;
                        z = true;
                    } else {
                        z = false;
                    }
                    if (this.a.S0) {
                        this.a.A0 = gif.getFrameCount() - 1;
                    } else {
                        this.a.A0 = 0;
                    }
                    z2 = z;
                }
                gif.c(this.a.A0);
                gif.a(this.a.z0, null);
                this.a.invalidate();
                removeMessages(1);
                if (!z2) {
                    sendEmptyMessageDelayed(1, gif.b(this.a.A0));
                } else {
                    this.a.f0();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends bg<tm> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GifView a;

        public b(GifView gifView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gifView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gifView;
        }

        @Override // com.baidu.tieba.bg
        public void onProgressUpdate(Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, objArr) == null) {
                super.onProgressUpdate(objArr);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bg
        public void onLoaded(tm tmVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, tmVar, str, i) == null) {
                super.onLoaded((b) tmVar, str, i);
                this.a.R();
                this.a.setGif(tmVar);
            }
        }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GifView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        BitmapDrawable bitmapDrawable;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        this.E0 = true;
        this.N0 = new Rect();
        this.O0 = new Rect();
        this.P0 = true;
        this.S0 = false;
        this.T0 = false;
        this.U0 = false;
        this.Z0 = R.drawable.image_group_load_f;
        this.a1 = new a(this, Looper.getMainLooper());
        this.d1 = 20;
        this.e1 = true;
        this.g1 = new b(this);
        BitmapDrawable bitmapDrawable2 = (BitmapDrawable) getResources().getDrawable(R.drawable.icon_content_animation);
        this.F0 = bitmapDrawable2;
        bitmapDrawable2.setBounds(0, 0, bitmapDrawable2.getIntrinsicWidth(), this.F0.getIntrinsicHeight());
        this.J0 = 30.0f;
        try {
            bitmapDrawable = (BitmapDrawable) getResources().getDrawable(R.drawable.img_loading);
        } catch (Throwable th) {
            th.printStackTrace();
            bitmapDrawable = null;
        }
        if (bitmapDrawable != null) {
            Bitmap c0 = c0(this);
            i1 = c0;
            this.O0.set(0, 0, c0.getWidth(), i1.getHeight());
        }
        this.X0 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
    }

    private void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            removeCallbacks(this);
            postDelayed(this, 150L);
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.H();
            this.y0 = null;
            this.z0 = null;
            this.a1.removeCallbacksAndMessages(null);
            this.G0 = false;
            this.A0 = 0;
            GifInfo gifInfo = this.c1;
            if (gifInfo != null) {
                gifInfo.mLoadFailed = false;
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void P() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && !this.H0) {
            this.H0 = true;
            C();
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.H0 = false;
            removeCallbacks(this);
            invalidate();
        }
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.W0 = null;
        }
    }

    public final boolean d0() {
        InterceptResult invokeV;
        GifInfo gifInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (!this.G0 && ((gifInfo = this.c1) == null || !gifInfo.mLoadFailed)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.drawableStateChanged();
            Drawable drawable = this.L0;
            if (drawable != null && drawable.isStateful()) {
                this.L0.setState(getDrawableState());
                invalidate();
            }
        }
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.V0 = null;
            nb nbVar = this.y0;
            if (nbVar != null) {
                nbVar.close();
            }
            if (this.c1 != null) {
                this.c1 = null;
            }
            if (this.z0 != null) {
                this.z0 = null;
            }
        }
    }

    public final void f0() {
        c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (cVar = this.B0) != null && !this.U0) {
            cVar.onStop();
            this.U0 = true;
        }
    }

    public boolean getAutoPlay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.P0;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView
    public tm getBdImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.V0;
        }
        return (tm) invokeV.objValue;
    }

    public nb getGif() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            nb nbVar = this.y0;
            if (nbVar == null) {
                f0();
                return null;
            }
            return nbVar;
        }
        return (nb) invokeV.objValue;
    }

    public GifInfo getGifInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.c1;
        }
        return (GifInfo) invokeV.objValue;
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public int getImageHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            tm tmVar = this.V0;
            if (tmVar == null) {
                return 0;
            }
            return tmVar.m();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public int getImageWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            tm tmVar = this.V0;
            if (tmVar == null) {
                return 0;
            }
            return tmVar.r();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public float[] getRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return s25.b(this.X0);
        }
        return (float[]) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.W0;
        }
        return (String) invokeV.objValue;
    }

    public void h0() {
        nb nbVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            Q();
            H();
            if (this.T0 && (nbVar = this.y0) != null && nbVar != null) {
                nbVar.close();
                this.y0 = null;
            }
        }
    }

    public void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.x0 = R.drawable.pic_expression_upload_selector;
        }
    }

    public void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.U0 = false;
            nb gif = getGif();
            if (gif == null) {
                return;
            }
            this.a1.removeMessages(1);
            this.a1.sendEmptyMessageDelayed(1, gif.b(this.A0));
        }
    }

    public final void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            if (this.E0) {
                SkinManager.setImageResource(this, this.Z0);
            }
            nf5 nf5Var = this.Y0;
            if (nf5Var != null) {
                nf5Var.onLoadFail();
            }
        }
    }

    public void n0() {
        nb gif;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048601, this) != null) || (gif = getGif()) == null) {
            return;
        }
        this.a1.removeMessages(1);
        gif.c(0);
        gif.a(this.z0, null);
        invalidate();
        f0();
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            super.onDetachedFromWindow();
            this.a1.removeMessages(1);
            Q();
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public void onStartTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            super.onStartTemporaryDetach();
            this.a1.removeMessages(1);
            Q();
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.tieba.qk
    public void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            GifInfo gifInfo = this.c1;
            if (gifInfo != null) {
                l0(gifInfo);
            }
            if (!TextUtils.isEmpty(this.W0)) {
                m0(this.W0, this.d1);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            float f = this.I0;
            float f2 = this.J0;
            float f3 = f + f2;
            this.I0 = f3;
            if (f3 > 360.0f - f2) {
                this.I0 = 0.0f;
            }
            invalidate();
            C();
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) {
            TbRichTextView.y yVar = this.h1;
            if (yVar != null) {
                yVar.dispatchTouchEvent(motionEvent);
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public void onWindowVisibilityChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i) == null) {
            super.onWindowVisibilityChanged(i);
            if (i == 4 || i == 8) {
                Q();
            }
            if (this.C0) {
                return;
            }
            if (i != 4 && i != 8) {
                if (i == 0) {
                    g0();
                    return;
                }
                return;
            }
            n0();
        }
    }

    public void setAutoPlay(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            this.P0 = z;
        }
    }

    public void setBgImage(tm tmVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, tmVar) == null) {
            this.V0 = tmVar;
        }
    }

    public void setDefaultNoImageDay(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i) == null) {
            this.x0 = i;
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void setDispatchTouchListener(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, yVar) == null) {
            this.h1 = yVar;
        }
    }

    public void setErrorResid(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i) == null) {
            this.Z0 = i;
        }
    }

    public void setGifFile(String str) {
        byte[] GetFileData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048616, this, str) != null) || (GetFileData = FileHelper.GetFileData(str)) == null) {
            return;
        }
        tm a2 = mb.a.b().a(GetFileData, 0, GetFileData.length);
        this.T0 = true;
        setGif(a2);
    }

    public void setIsKeepLastFrame(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            this.S0 = z;
        }
    }

    public void setIsLoading(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048620, this, z) == null) {
            if (z) {
                P();
            } else {
                R();
            }
        }
    }

    public void setLoadCallback(nf5 nf5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, nf5Var) == null) {
            this.Y0 = nf5Var;
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, onClickListener) == null) {
            super.setOnClickListener(this);
            this.R0 = onClickListener;
        }
    }

    public void setOnInterceptClickListener(yu4 yu4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, yu4Var) == null) {
            super.setOnClickListener(this);
            this.Q0 = yu4Var;
        }
    }

    public void setPlayCallback(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, cVar) == null) {
            this.B0 = cVar;
        }
    }

    public void setShowError(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048625, this, z) == null) {
            this.E0 = z;
        }
    }

    public void setShowStaticDrawable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048626, this, z) == null) {
            this.D0 = z;
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void setSupportNoImage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048627, this, z) == null) {
            super.setSupportNoImage(z);
            this.e1 = z;
        }
    }

    public void setType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048628, this, i) == null) {
            this.d1 = i;
        }
    }

    public static Bitmap c0(GifView gifView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, gifView)) == null) {
            Bitmap bitmap = i1;
            if (bitmap != null && !bitmap.isRecycled()) {
                return i1;
            }
            BitmapDrawable bitmapDrawable = (BitmapDrawable) gifView.getResources().getDrawable(R.drawable.img_loading);
            if (bitmapDrawable != null) {
                i1 = bitmapDrawable.getBitmap();
            }
            return i1;
        }
        return (Bitmap) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            R();
            this.G0 = false;
            this.K0 = false;
            if (this.c1 != null) {
                cg.h().d(this.c1.mSharpText, this.d1, this.g1);
            }
            if (!TextUtils.isEmpty(this.W0)) {
                cg.h().d(this.W0, this.d1, this.g1);
            }
        }
    }

    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.U0 = false;
            nb gif = getGif();
            if (gif == null) {
                return;
            }
            if (this.A0 != 0) {
                this.A0 = 0;
            }
            gif.c(0);
            this.a1.removeMessages(1);
            this.a1.sendEmptyMessageDelayed(1, gif.b(this.A0));
        }
    }

    public void l0(GifInfo gifInfo) {
        BdUniqueId bdUniqueId;
        boolean z;
        boolean z2;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, gifInfo) == null) {
            this.d1 = 20;
            if (gifInfo == null) {
                this.c1 = null;
                k0();
                return;
            }
            nf5 nf5Var = this.Y0;
            if (nf5Var != null) {
                nf5Var.a();
            }
            boolean c2 = hq5.c();
            f9 c3 = g9.c(getContext());
            if (c3 != null) {
                bdUniqueId = c3.getUniqueId();
                z = c3.isScroll();
            } else {
                bdUniqueId = null;
                z = false;
            }
            GifInfo gifInfo2 = this.c1;
            if (gifInfo2 != null && (str2 = gifInfo.mDynamicUrl) != null && StringHelper.equals(str2, gifInfo2.mDynamicUrl) && StringHelper.equals(gifInfo.mSharpText, this.c1.mSharpText) && StringHelper.equals(gifInfo.mStaticUrl, this.c1.mStaticUrl) && this.f1 == bdUniqueId) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                Q();
            }
            this.c1 = gifInfo;
            this.f1 = bdUniqueId;
            this.W0 = null;
            H();
            GifInfo gifInfo3 = this.c1;
            if (c2) {
                str = gifInfo3.mDynamicUrl;
            } else {
                str = gifInfo3.mStaticUrl;
            }
            cg h = cg.h();
            GifInfo gifInfo4 = this.c1;
            String str3 = gifInfo4.mSharpText;
            tm tmVar = (tm) h.n(str3, this.d1, gifInfo4.mGid, str3, Boolean.valueOf(c2), str);
            if (tmVar != null) {
                R();
                setGif(tmVar);
            } else if (this.c1.mLoadFailed) {
                setGif(null);
                k0();
            } else if (!cg.h().j(this.d1) && this.e1) {
                setHasNoImage(true, this.x0);
            } else if (z) {
            } else {
                P();
                cg h2 = cg.h();
                GifInfo gifInfo5 = this.c1;
                String str4 = gifInfo5.mSharpText;
                h2.k(str4, this.d1, this.g1, 0, 0, this.f1, gifInfo5.mGid, str4, Boolean.valueOf(c2), str);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, canvas) == null) {
            try {
                if ((!this.H0 && !this.G0 && !this.K0) || d0()) {
                    super.onDraw(canvas);
                }
                canvas.save();
                if (this.y0 != null && !this.H0 && !this.G0 && !this.K0) {
                    this.y0.a(null, canvas);
                }
                canvas.restore();
            } catch (Throwable th) {
                BdLog.e("setGif:" + th.getMessage());
                f0();
            }
            if (this.C0 && this.D0) {
                canvas.save();
                this.F0.draw(canvas);
                canvas.restore();
            }
            if (this.H0 && c0(this) != null) {
                canvas.save();
                int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                float height = (((getHeight() - getPaddingTop()) - getPaddingBottom()) * 0.5f) + getPaddingTop();
                canvas.rotate(this.I0, (width * 0.5f) + getPaddingLeft(), height);
                canvas.drawBitmap(c0(this), this.O0, this.N0, (Paint) null);
                canvas.restore();
            } else if (this.K0) {
                canvas.save();
                this.L0.draw(canvas);
                canvas.restore();
            }
        }
    }

    public void setGif(tm tmVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, tmVar) == null) {
            setBackgroundDrawable(null);
            this.V0 = tmVar;
            this.G0 = false;
            this.H0 = false;
            this.K0 = false;
            GifInfo gifInfo = this.c1;
            if (gifInfo != null) {
                gifInfo.mLoadFailed = false;
            }
            if (tmVar == null) {
                this.G0 = true;
                this.C0 = false;
                GifInfo gifInfo2 = this.c1;
                if (gifInfo2 != null) {
                    gifInfo2.mLoadFailed = true;
                }
                k0();
                nb nbVar = this.y0;
                if (nbVar != null) {
                    nbVar.close();
                    return;
                }
                return;
            }
            nf5 nf5Var = this.Y0;
            if (nf5Var != null) {
                nf5Var.onLoadSuccess();
            }
            if (tmVar.l() == null) {
                if (!tmVar.s()) {
                    this.C0 = true;
                    tmVar.h(this);
                    this.H0 = false;
                }
                nb nbVar2 = this.y0;
                if (nbVar2 != null) {
                    nbVar2.close();
                }
            } else if (this.y0 != null && tmVar.l().equals(this.y0)) {
                if (this.A0 >= tmVar.l().getFrameCount()) {
                    this.A0 = 0;
                }
                tmVar.l().c(this.A0);
                tmVar.l().a(this.z0, null);
                setImageBitmap(this.z0);
                if (this.P0) {
                    j0();
                }
            } else {
                this.C0 = false;
                try {
                    if (this.z0 == null || (this.z0.getWidth() != tmVar.l().getWidth() && this.z0.getHeight() != tmVar.l().getHeight())) {
                        this.z0 = Bitmap.createBitmap(tmVar.l().getWidth(), tmVar.l().getHeight(), Bitmap.Config.ARGB_8888);
                    }
                    this.y0 = tmVar.l();
                    tmVar.l().c(0);
                    tmVar.l().a(this.z0, null);
                    setImageBitmap(this.z0);
                    if (this.P0) {
                        g0();
                    }
                } catch (Throwable unused) {
                    f0();
                }
            }
        }
    }

    public void m0(String str, int i) {
        BdUniqueId bdUniqueId;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048600, this, str, i) == null) {
            this.d1 = i;
            this.c1 = null;
            if (TextUtils.isEmpty(str)) {
                this.W0 = null;
                k0();
                return;
            }
            nf5 nf5Var = this.Y0;
            if (nf5Var != null) {
                nf5Var.a();
            }
            f9 c2 = g9.c(getContext());
            if (c2 != null) {
                bdUniqueId = c2.getUniqueId();
                z = c2.isScroll();
            } else {
                bdUniqueId = null;
                z = false;
            }
            if (str.equals(this.W0) && i == this.d1 && bdUniqueId == this.f1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                Q();
                if (!TextUtils.isEmpty(this.W0)) {
                    setImageDrawable(null);
                    setBgImage(null);
                }
            }
            this.f1 = bdUniqueId;
            H();
            this.W0 = str;
            this.c1 = null;
            tm tmVar = (tm) cg.h().n(str, i, new Object[0]);
            if (tmVar != null) {
                R();
                setGif(tmVar);
            } else if (!cg.h().j(this.d1) && this.e1) {
                setHasNoImage(true, this.x0);
            } else if (z) {
            } else {
                cg.h().m(this.W0, i, this.g1, this.f1);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View.OnClickListener
    public void onClick(View view2) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, view2) == null) {
            yu4 yu4Var = this.Q0;
            if (yu4Var != null && yu4Var.a(view2)) {
                return;
            }
            if (this.c1 != null) {
                boolean c2 = hq5.c();
                GifInfo gifInfo = this.c1;
                if (c2) {
                    str = gifInfo.mDynamicUrl;
                } else {
                    str = gifInfo.mStaticUrl;
                }
                cg h = cg.h();
                GifInfo gifInfo2 = this.c1;
                String str2 = gifInfo2.mSharpText;
                tm tmVar = (tm) h.n(str2, this.d1, gifInfo2.mGid, str2, Boolean.valueOf(c2), str);
                if (tmVar != null) {
                    this.c1.mLoadFailed = false;
                    setGif(tmVar);
                } else {
                    P();
                    cg h2 = cg.h();
                    GifInfo gifInfo3 = this.c1;
                    String str3 = gifInfo3.mSharpText;
                    h2.k(str3, this.d1, this.g1, 0, 0, this.f1, gifInfo3.mGid, str3, Boolean.valueOf(c2), str);
                    return;
                }
            }
            if (!TextUtils.isEmpty(this.W0)) {
                tm tmVar2 = (tm) cg.h().n(this.W0, this.d1, new Object[0]);
                if (tmVar2 != null) {
                    this.G0 = false;
                    setGif(tmVar2);
                } else {
                    P();
                    cg.h().m(this.W0, this.d1, this.g1, this.f1);
                    return;
                }
            }
            View.OnClickListener onClickListener = this.R0;
            if (onClickListener != null) {
                onClickListener.onClick(view2);
            }
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048605, this, i, i2, i3, i4) == null) {
            super.onSizeChanged(i, i2, i3, i4);
            if (i == i3 && i2 == i4) {
                return;
            }
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int paddingTop = getPaddingTop();
            int paddingBottom = i2 - (getPaddingBottom() + paddingTop);
            int i5 = i - (paddingRight + paddingLeft);
            if (c0(this) != null) {
                int width = i1.getWidth();
                int height = i1.getHeight();
                int i6 = ((i5 - width) / 2) + paddingLeft;
                int i7 = ((paddingBottom - height) / 2) + paddingTop;
                this.N0.set(i6, i7, width + i6, height + i7);
            }
            Drawable drawable = this.L0;
            if (drawable != null) {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = this.L0.getIntrinsicHeight();
                if (intrinsicWidth > i5) {
                    intrinsicWidth = i5;
                }
                if (intrinsicHeight > paddingBottom) {
                    intrinsicHeight = paddingBottom;
                }
                int i8 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
                int i9 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
                this.L0.setBounds(i8, i9, intrinsicWidth + i8, intrinsicHeight + i9);
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
    /* JADX WARN: Type inference failed for: r5v9, types: [com.baidu.tieba.mb] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setGifRaw(int i) {
        Interceptable interceptable;
        int i2;
        Interceptable interceptable2 = $ic;
        if (interceptable2 != null) {
            interceptable = interceptable2;
            if (interceptable.invokeI(1048617, this, i) != null) {
                return;
            }
        }
        ?? openRawResource = getContext().getResources().openRawResource(i);
        byte[] bArr = null;
        try {
            try {
                try {
                    i2 = openRawResource.available();
                } catch (IOException e) {
                    openRawResource = e.getMessage();
                    BdLog.e((String) openRawResource);
                }
                try {
                    bArr = new byte[i2];
                    openRawResource.read(bArr);
                    openRawResource.close();
                    interceptable = i2;
                } catch (IOException e2) {
                    e = e2;
                    BdLog.e(e.getMessage());
                    openRawResource.close();
                    interceptable = i2;
                    if (bArr != null) {
                    }
                    return;
                } catch (OutOfMemoryError e3) {
                    e = e3;
                    BdLog.e(e.getMessage());
                    openRawResource.close();
                    interceptable = i2;
                    if (bArr != null) {
                    }
                }
            } catch (IOException e4) {
                e = e4;
                i2 = 0;
            } catch (OutOfMemoryError e5) {
                e = e5;
                i2 = 0;
            }
            if (bArr != null && bArr.length >= interceptable) {
                tm a2 = mb.a.b().a(bArr, 0, interceptable);
                this.T0 = true;
                setGif(a2);
            }
        } catch (Throwable th) {
            try {
                openRawResource.close();
            } catch (IOException e6) {
                BdLog.e(e6.getMessage());
            }
            throw th;
        }
    }

    public void setHasNoImage(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048618, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            this.K0 = z;
            if (z) {
                this.H0 = false;
                this.G0 = false;
                if (this.L0 == null || this.M0 != i) {
                    this.M0 = i;
                    Drawable drawable = SkinManager.getDrawable(i);
                    this.L0 = drawable;
                    int intrinsicWidth = drawable.getIntrinsicWidth();
                    int intrinsicHeight = this.L0.getIntrinsicHeight();
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
                    this.L0.setBounds(paddingLeft, paddingTop, intrinsicWidth + paddingLeft, intrinsicHeight + paddingTop);
                }
            } else {
                this.L0 = null;
            }
            invalidate();
        }
    }
}
