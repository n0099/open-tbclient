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
import com.baidu.tieba.cn;
import com.baidu.tieba.js5;
import com.baidu.tieba.kg;
import com.baidu.tieba.l9;
import com.baidu.tieba.lg;
import com.baidu.tieba.m9;
import com.baidu.tieba.ph5;
import com.baidu.tieba.q45;
import com.baidu.tieba.sb;
import com.baidu.tieba.tb;
import com.baidu.tieba.xw4;
import com.baidu.tieba.zk;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes4.dex */
public class GifView extends TbClipImageView implements Runnable, View.OnClickListener, zk {
    public static /* synthetic */ Interceptable $ic;
    public static Bitmap j1;
    public transient /* synthetic */ FieldHolder $fh;
    public Bitmap A0;
    public int B0;
    public c C0;
    public boolean D0;
    public boolean E0;
    public boolean F0;
    public BitmapDrawable G0;
    public boolean H0;
    public boolean I0;
    public float J0;
    public float K0;
    public boolean L0;
    public Drawable M0;
    public int N0;
    public final Rect O0;
    public final Rect P0;
    public boolean Q0;
    public xw4 R0;
    public View.OnClickListener S0;
    public boolean T0;
    public boolean U0;
    public boolean V0;
    public cn W0;
    public String X0;
    public int Y0;
    public ph5 Z0;
    public int a1;
    public Handler b1;
    public boolean c1;
    public GifInfo d1;
    public int e1;
    public boolean f1;
    public BdUniqueId g1;
    public kg<cn> h1;
    public TbRichTextView.y i1;
    public int y0;
    public tb z0;

    /* loaded from: classes4.dex */
    public interface c {
        void onStop();
    }

    /* loaded from: classes4.dex */
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
            tb gif;
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && (gif = this.a.getGif()) != null && message.what == 1) {
                this.a.B0++;
                boolean z2 = false;
                if (this.a.B0 >= gif.getFrameCount()) {
                    if (this.a.c1) {
                        if (!this.a.T0) {
                            this.a.setVisibility(4);
                        }
                        this.a.c1 = false;
                        z = true;
                    } else {
                        z = false;
                    }
                    if (this.a.T0) {
                        this.a.B0 = gif.getFrameCount() - 1;
                    } else {
                        this.a.B0 = 0;
                    }
                    z2 = z;
                }
                gif.c(this.a.B0);
                gif.a(this.a.A0, null);
                this.a.invalidate();
                removeMessages(1);
                if (!z2) {
                    sendEmptyMessageDelayed(1, gif.b(this.a.B0));
                } else {
                    this.a.f0();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends kg<cn> {
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

        @Override // com.baidu.tieba.kg
        public void onProgressUpdate(Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, objArr) == null) {
                super.onProgressUpdate(objArr);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kg
        public void onLoaded(cn cnVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, cnVar, str, i) == null) {
                super.onLoaded((b) cnVar, str, i);
                this.a.R();
                this.a.setGif(cnVar);
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
        this.y0 = R.drawable.pic_expression_upload_selector;
        this.D0 = false;
        this.E0 = true;
        this.F0 = true;
        this.O0 = new Rect();
        this.P0 = new Rect();
        this.Q0 = true;
        this.T0 = false;
        this.U0 = false;
        this.V0 = false;
        this.a1 = R.drawable.image_group_load_f;
        this.b1 = new a(this, Looper.getMainLooper());
        this.e1 = 20;
        this.f1 = true;
        this.h1 = new b(this);
        BitmapDrawable bitmapDrawable2 = (BitmapDrawable) getResources().getDrawable(R.drawable.icon_content_animation);
        this.G0 = bitmapDrawable2;
        bitmapDrawable2.setBounds(0, 0, bitmapDrawable2.getIntrinsicWidth(), this.G0.getIntrinsicHeight());
        this.K0 = 30.0f;
        try {
            bitmapDrawable = (BitmapDrawable) getResources().getDrawable(R.drawable.img_loading);
        } catch (Throwable th) {
            th.printStackTrace();
            bitmapDrawable = null;
        }
        if (bitmapDrawable != null) {
            Bitmap c0 = c0(this);
            j1 = c0;
            this.P0.set(0, 0, c0.getWidth(), j1.getHeight());
        }
        this.Y0 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
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
            this.z0 = null;
            this.A0 = null;
            this.b1.removeCallbacksAndMessages(null);
            this.H0 = false;
            this.B0 = 0;
            GifInfo gifInfo = this.d1;
            if (gifInfo != null) {
                gifInfo.mLoadFailed = false;
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void P() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && !this.I0) {
            this.I0 = true;
            C();
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.I0 = false;
            removeCallbacks(this);
            invalidate();
        }
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.X0 = null;
        }
    }

    public final boolean d0() {
        InterceptResult invokeV;
        GifInfo gifInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (!this.H0 && ((gifInfo = this.d1) == null || !gifInfo.mLoadFailed)) {
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
            Drawable drawable = this.M0;
            if (drawable != null && drawable.isStateful()) {
                this.M0.setState(getDrawableState());
                invalidate();
            }
        }
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.W0 = null;
            tb tbVar = this.z0;
            if (tbVar != null) {
                tbVar.close();
            }
            if (this.d1 != null) {
                this.d1 = null;
            }
            if (this.A0 != null) {
                this.A0 = null;
            }
        }
    }

    public final void f0() {
        c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (cVar = this.C0) != null && !this.V0) {
            cVar.onStop();
            this.V0 = true;
        }
    }

    public boolean getAutoPlay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.Q0;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView
    public cn getBdImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.W0;
        }
        return (cn) invokeV.objValue;
    }

    public tb getGif() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            tb tbVar = this.z0;
            if (tbVar == null) {
                f0();
                return null;
            }
            return tbVar;
        }
        return (tb) invokeV.objValue;
    }

    public GifInfo getGifInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.d1;
        }
        return (GifInfo) invokeV.objValue;
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public int getImageHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            cn cnVar = this.W0;
            if (cnVar == null) {
                return 0;
            }
            return cnVar.m();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public int getImageWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            cn cnVar = this.W0;
            if (cnVar == null) {
                return 0;
            }
            return cnVar.r();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public float[] getRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return q45.b(this.Y0);
        }
        return (float[]) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.X0;
        }
        return (String) invokeV.objValue;
    }

    public void h0() {
        tb tbVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            Q();
            H();
            if (this.U0 && (tbVar = this.z0) != null && tbVar != null) {
                tbVar.close();
                this.z0 = null;
            }
        }
    }

    public void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.y0 = R.drawable.pic_expression_upload_selector;
        }
    }

    public void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.V0 = false;
            tb gif = getGif();
            if (gif == null) {
                return;
            }
            this.b1.removeMessages(1);
            this.b1.sendEmptyMessageDelayed(1, gif.b(this.B0));
        }
    }

    public final void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            if (this.F0) {
                SkinManager.setImageResource(this, this.a1);
            }
            ph5 ph5Var = this.Z0;
            if (ph5Var != null) {
                ph5Var.onLoadFail();
            }
        }
    }

    public void n0() {
        tb gif;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048601, this) != null) || (gif = getGif()) == null) {
            return;
        }
        this.b1.removeMessages(1);
        gif.c(0);
        gif.a(this.A0, null);
        invalidate();
        f0();
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            super.onDetachedFromWindow();
            this.b1.removeMessages(1);
            Q();
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public void onStartTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            super.onStartTemporaryDetach();
            this.b1.removeMessages(1);
            Q();
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.tieba.zk
    public void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            GifInfo gifInfo = this.d1;
            if (gifInfo != null) {
                l0(gifInfo);
            }
            if (!TextUtils.isEmpty(this.X0)) {
                m0(this.X0, this.e1);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            float f = this.J0;
            float f2 = this.K0;
            float f3 = f + f2;
            this.J0 = f3;
            if (f3 > 360.0f - f2) {
                this.J0 = 0.0f;
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
            TbRichTextView.y yVar = this.i1;
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
            if (this.D0) {
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
            this.Q0 = z;
        }
    }

    public void setBgImage(cn cnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, cnVar) == null) {
            this.W0 = cnVar;
        }
    }

    public void setDefaultNoImageDay(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i) == null) {
            this.y0 = i;
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void setDispatchTouchListener(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, yVar) == null) {
            this.i1 = yVar;
        }
    }

    public void setErrorResid(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i) == null) {
            this.a1 = i;
        }
    }

    public void setGifFile(String str) {
        byte[] GetFileData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048616, this, str) != null) || (GetFileData = FileHelper.GetFileData(str)) == null) {
            return;
        }
        cn a2 = sb.a.b().a(GetFileData, 0, GetFileData.length);
        this.U0 = true;
        setGif(a2);
    }

    public void setIsKeepLastFrame(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            this.T0 = z;
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

    public void setLoadCallback(ph5 ph5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, ph5Var) == null) {
            this.Z0 = ph5Var;
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, onClickListener) == null) {
            super.setOnClickListener(this);
            this.S0 = onClickListener;
        }
    }

    public void setOnInterceptClickListener(xw4 xw4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, xw4Var) == null) {
            super.setOnClickListener(this);
            this.R0 = xw4Var;
        }
    }

    public void setPlayCallback(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, cVar) == null) {
            this.C0 = cVar;
        }
    }

    public void setShowError(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048625, this, z) == null) {
            this.F0 = z;
        }
    }

    public void setShowStaticDrawable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048626, this, z) == null) {
            this.E0 = z;
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void setSupportNoImage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048627, this, z) == null) {
            super.setSupportNoImage(z);
            this.f1 = z;
        }
    }

    public void setType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048628, this, i) == null) {
            this.e1 = i;
        }
    }

    public static Bitmap c0(GifView gifView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, gifView)) == null) {
            Bitmap bitmap = j1;
            if (bitmap != null && !bitmap.isRecycled()) {
                return j1;
            }
            BitmapDrawable bitmapDrawable = (BitmapDrawable) gifView.getResources().getDrawable(R.drawable.img_loading);
            if (bitmapDrawable != null) {
                j1 = bitmapDrawable.getBitmap();
            }
            return j1;
        }
        return (Bitmap) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            R();
            this.H0 = false;
            this.L0 = false;
            if (this.d1 != null) {
                lg.h().d(this.d1.mSharpText, this.e1, this.h1);
            }
            if (!TextUtils.isEmpty(this.X0)) {
                lg.h().d(this.X0, this.e1, this.h1);
            }
        }
    }

    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.V0 = false;
            tb gif = getGif();
            if (gif == null) {
                return;
            }
            if (this.B0 != 0) {
                this.B0 = 0;
            }
            gif.c(0);
            this.b1.removeMessages(1);
            this.b1.sendEmptyMessageDelayed(1, gif.b(this.B0));
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
            this.e1 = 20;
            if (gifInfo == null) {
                this.d1 = null;
                k0();
                return;
            }
            ph5 ph5Var = this.Z0;
            if (ph5Var != null) {
                ph5Var.a();
            }
            boolean c2 = js5.c();
            l9 c3 = m9.c(getContext());
            if (c3 != null) {
                bdUniqueId = c3.getUniqueId();
                z = c3.isScroll();
            } else {
                bdUniqueId = null;
                z = false;
            }
            GifInfo gifInfo2 = this.d1;
            if (gifInfo2 != null && (str2 = gifInfo.mDynamicUrl) != null && StringHelper.equals(str2, gifInfo2.mDynamicUrl) && StringHelper.equals(gifInfo.mSharpText, this.d1.mSharpText) && StringHelper.equals(gifInfo.mStaticUrl, this.d1.mStaticUrl) && this.g1 == bdUniqueId) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                Q();
            }
            this.d1 = gifInfo;
            this.g1 = bdUniqueId;
            this.X0 = null;
            H();
            GifInfo gifInfo3 = this.d1;
            if (c2) {
                str = gifInfo3.mDynamicUrl;
            } else {
                str = gifInfo3.mStaticUrl;
            }
            lg h = lg.h();
            GifInfo gifInfo4 = this.d1;
            String str3 = gifInfo4.mSharpText;
            cn cnVar = (cn) h.n(str3, this.e1, gifInfo4.mGid, str3, Boolean.valueOf(c2), str);
            if (cnVar != null) {
                R();
                setGif(cnVar);
            } else if (this.d1.mLoadFailed) {
                setGif(null);
                k0();
            } else if (!lg.h().j(this.e1) && this.f1) {
                setHasNoImage(true, this.y0);
            } else if (z) {
            } else {
                P();
                lg h2 = lg.h();
                GifInfo gifInfo5 = this.d1;
                String str4 = gifInfo5.mSharpText;
                h2.k(str4, this.e1, this.h1, 0, 0, this.g1, gifInfo5.mGid, str4, Boolean.valueOf(c2), str);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, canvas) == null) {
            try {
                if ((!this.I0 && !this.H0 && !this.L0) || d0()) {
                    super.onDraw(canvas);
                }
                canvas.save();
                if (this.z0 != null && !this.I0 && !this.H0 && !this.L0) {
                    this.z0.a(null, canvas);
                }
                canvas.restore();
            } catch (Throwable th) {
                BdLog.e("setGif:" + th.getMessage());
                f0();
            }
            if (this.D0 && this.E0) {
                canvas.save();
                this.G0.draw(canvas);
                canvas.restore();
            }
            if (this.I0 && c0(this) != null) {
                canvas.save();
                int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                float height = (((getHeight() - getPaddingTop()) - getPaddingBottom()) * 0.5f) + getPaddingTop();
                canvas.rotate(this.J0, (width * 0.5f) + getPaddingLeft(), height);
                canvas.drawBitmap(c0(this), this.P0, this.O0, (Paint) null);
                canvas.restore();
            } else if (this.L0) {
                canvas.save();
                this.M0.draw(canvas);
                canvas.restore();
            }
        }
    }

    public void setGif(cn cnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, cnVar) == null) {
            setBackgroundDrawable(null);
            this.W0 = cnVar;
            this.H0 = false;
            this.I0 = false;
            this.L0 = false;
            GifInfo gifInfo = this.d1;
            if (gifInfo != null) {
                gifInfo.mLoadFailed = false;
            }
            if (cnVar == null) {
                this.H0 = true;
                this.D0 = false;
                GifInfo gifInfo2 = this.d1;
                if (gifInfo2 != null) {
                    gifInfo2.mLoadFailed = true;
                }
                k0();
                tb tbVar = this.z0;
                if (tbVar != null) {
                    tbVar.close();
                    return;
                }
                return;
            }
            ph5 ph5Var = this.Z0;
            if (ph5Var != null) {
                ph5Var.onLoadSuccess();
            }
            if (cnVar.l() == null) {
                if (!cnVar.s()) {
                    this.D0 = true;
                    cnVar.h(this);
                    this.I0 = false;
                }
                tb tbVar2 = this.z0;
                if (tbVar2 != null) {
                    tbVar2.close();
                }
            } else if (this.z0 != null && cnVar.l().equals(this.z0)) {
                if (this.B0 >= cnVar.l().getFrameCount()) {
                    this.B0 = 0;
                }
                cnVar.l().c(this.B0);
                cnVar.l().a(this.A0, null);
                setImageBitmap(this.A0);
                if (this.Q0) {
                    j0();
                }
            } else {
                this.D0 = false;
                try {
                    if (this.A0 == null || (this.A0.getWidth() != cnVar.l().getWidth() && this.A0.getHeight() != cnVar.l().getHeight())) {
                        this.A0 = Bitmap.createBitmap(cnVar.l().getWidth(), cnVar.l().getHeight(), Bitmap.Config.ARGB_8888);
                    }
                    this.z0 = cnVar.l();
                    cnVar.l().c(0);
                    cnVar.l().a(this.A0, null);
                    setImageBitmap(this.A0);
                    if (this.Q0) {
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
            this.e1 = i;
            this.d1 = null;
            if (TextUtils.isEmpty(str)) {
                this.X0 = null;
                k0();
                return;
            }
            ph5 ph5Var = this.Z0;
            if (ph5Var != null) {
                ph5Var.a();
            }
            l9 c2 = m9.c(getContext());
            if (c2 != null) {
                bdUniqueId = c2.getUniqueId();
                z = c2.isScroll();
            } else {
                bdUniqueId = null;
                z = false;
            }
            if (str.equals(this.X0) && i == this.e1 && bdUniqueId == this.g1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                Q();
                if (!TextUtils.isEmpty(this.X0)) {
                    setImageDrawable(null);
                    setBgImage(null);
                }
            }
            this.g1 = bdUniqueId;
            H();
            this.X0 = str;
            this.d1 = null;
            cn cnVar = (cn) lg.h().n(str, i, new Object[0]);
            if (cnVar != null) {
                R();
                setGif(cnVar);
            } else if (!lg.h().j(this.e1) && this.f1) {
                setHasNoImage(true, this.y0);
            } else if (z) {
            } else {
                lg.h().m(this.X0, i, this.h1, this.g1);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View.OnClickListener
    public void onClick(View view2) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, view2) == null) {
            xw4 xw4Var = this.R0;
            if (xw4Var != null && xw4Var.a(view2)) {
                return;
            }
            if (this.d1 != null) {
                boolean c2 = js5.c();
                GifInfo gifInfo = this.d1;
                if (c2) {
                    str = gifInfo.mDynamicUrl;
                } else {
                    str = gifInfo.mStaticUrl;
                }
                lg h = lg.h();
                GifInfo gifInfo2 = this.d1;
                String str2 = gifInfo2.mSharpText;
                cn cnVar = (cn) h.n(str2, this.e1, gifInfo2.mGid, str2, Boolean.valueOf(c2), str);
                if (cnVar != null) {
                    this.d1.mLoadFailed = false;
                    setGif(cnVar);
                } else {
                    P();
                    lg h2 = lg.h();
                    GifInfo gifInfo3 = this.d1;
                    String str3 = gifInfo3.mSharpText;
                    h2.k(str3, this.e1, this.h1, 0, 0, this.g1, gifInfo3.mGid, str3, Boolean.valueOf(c2), str);
                    return;
                }
            }
            if (!TextUtils.isEmpty(this.X0)) {
                cn cnVar2 = (cn) lg.h().n(this.X0, this.e1, new Object[0]);
                if (cnVar2 != null) {
                    this.H0 = false;
                    setGif(cnVar2);
                } else {
                    P();
                    lg.h().m(this.X0, this.e1, this.h1, this.g1);
                    return;
                }
            }
            View.OnClickListener onClickListener = this.S0;
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
                int width = j1.getWidth();
                int height = j1.getHeight();
                int i6 = ((i5 - width) / 2) + paddingLeft;
                int i7 = ((paddingBottom - height) / 2) + paddingTop;
                this.O0.set(i6, i7, width + i6, height + i7);
            }
            Drawable drawable = this.M0;
            if (drawable != null) {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = this.M0.getIntrinsicHeight();
                if (intrinsicWidth > i5) {
                    intrinsicWidth = i5;
                }
                if (intrinsicHeight > paddingBottom) {
                    intrinsicHeight = paddingBottom;
                }
                int i8 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
                int i9 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
                this.M0.setBounds(i8, i9, intrinsicWidth + i8, intrinsicHeight + i9);
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
    /* JADX WARN: Type inference failed for: r5v9, types: [com.baidu.tieba.sb] */
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
                cn a2 = sb.a.b().a(bArr, 0, interceptable);
                this.U0 = true;
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
            this.L0 = z;
            if (z) {
                this.I0 = false;
                this.H0 = false;
                if (this.M0 == null || this.N0 != i) {
                    this.N0 = i;
                    Drawable drawable = SkinManager.getDrawable(i);
                    this.M0 = drawable;
                    int intrinsicWidth = drawable.getIntrinsicWidth();
                    int intrinsicHeight = this.M0.getIntrinsicHeight();
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
                    this.M0.setBounds(paddingLeft, paddingTop, intrinsicWidth + paddingLeft, intrinsicHeight + paddingTop);
                }
            } else {
                this.M0 = null;
            }
            invalidate();
        }
    }
}
