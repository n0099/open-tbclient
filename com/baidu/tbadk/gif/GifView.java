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
import com.baidu.tieba.cc;
import com.baidu.tieba.dc;
import com.baidu.tieba.el;
import com.baidu.tieba.gq4;
import com.baidu.tieba.hn;
import com.baidu.tieba.lw4;
import com.baidu.tieba.mi5;
import com.baidu.tieba.rg;
import com.baidu.tieba.sg;
import com.baidu.tieba.v9;
import com.baidu.tieba.w9;
import com.baidu.tieba.z85;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes3.dex */
public class GifView extends TbClipImageView implements Runnable, View.OnClickListener, el {
    public static /* synthetic */ Interceptable $ic;
    public static Bitmap g1;
    public transient /* synthetic */ FieldHolder $fh;
    public c A0;
    public boolean B0;
    public boolean C0;
    public BitmapDrawable D0;
    public boolean E0;
    public boolean F0;
    public float G0;
    public float H0;
    public boolean I0;
    public Drawable J0;
    public int K0;
    public final Rect L0;
    public final Rect M0;
    public boolean N0;
    public gq4 O0;
    public View.OnClickListener P0;
    public boolean Q0;
    public boolean R0;
    public boolean S0;
    public hn T0;
    public String U0;
    public int V0;
    public z85 W0;
    public int X0;
    public Handler Y0;
    public boolean Z0;
    public GifInfo a1;
    public int b1;
    public boolean c1;
    public BdUniqueId d1;
    public rg<hn> e1;
    public TbRichTextView.w f1;
    public int w0;
    public dc x0;
    public Bitmap y0;
    public int z0;

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
            dc gif;
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && (gif = this.a.getGif()) != null && message.what == 1) {
                this.a.z0++;
                boolean z2 = false;
                if (this.a.z0 >= gif.getFrameCount()) {
                    if (this.a.Z0) {
                        if (!this.a.Q0) {
                            this.a.setVisibility(4);
                        }
                        this.a.Z0 = false;
                        z = true;
                    } else {
                        z = false;
                    }
                    if (this.a.Q0) {
                        this.a.z0 = gif.getFrameCount() - 1;
                    } else {
                        this.a.z0 = 0;
                    }
                    z2 = z;
                }
                gif.c(this.a.z0);
                gif.a(this.a.y0, null);
                this.a.invalidate();
                removeMessages(1);
                if (!z2) {
                    sendEmptyMessageDelayed(1, gif.b(this.a.z0));
                } else {
                    this.a.c0();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends rg<hn> {
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

        @Override // com.baidu.tieba.rg
        public void onProgressUpdate(Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, objArr) == null) {
                super.onProgressUpdate(objArr);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rg
        public void onLoaded(hn hnVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, hnVar, str, i) == null) {
                super.onLoaded((b) hnVar, str, i);
                this.a.O();
                this.a.setGif(hnVar);
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
        this.w0 = R.drawable.pic_expression_upload_selector;
        this.B0 = false;
        this.C0 = true;
        this.L0 = new Rect();
        this.M0 = new Rect();
        this.N0 = true;
        this.Q0 = false;
        this.R0 = false;
        this.S0 = false;
        this.X0 = R.drawable.obfuscated_res_0x7f080c04;
        this.Y0 = new a(this, Looper.getMainLooper());
        this.b1 = 20;
        this.c1 = true;
        this.e1 = new b(this);
        BitmapDrawable bitmapDrawable2 = (BitmapDrawable) getResources().getDrawable(R.drawable.icon_content_animation);
        this.D0 = bitmapDrawable2;
        bitmapDrawable2.setBounds(0, 0, bitmapDrawable2.getIntrinsicWidth(), this.D0.getIntrinsicHeight());
        this.H0 = 30.0f;
        try {
            bitmapDrawable = (BitmapDrawable) getResources().getDrawable(R.drawable.img_loading);
        } catch (Throwable th) {
            th.printStackTrace();
            bitmapDrawable = null;
        }
        if (bitmapDrawable != null) {
            Bitmap Z = Z(this);
            g1 = Z;
            this.M0.set(0, 0, Z.getWidth(), g1.getHeight());
        }
        this.V0 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
    }

    private void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            removeCallbacks(this);
            postDelayed(this, 150L);
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.F();
            this.x0 = null;
            this.y0 = null;
            this.Y0.removeCallbacksAndMessages(null);
            this.E0 = false;
            this.z0 = 0;
            GifInfo gifInfo = this.a1;
            if (gifInfo != null) {
                gifInfo.mLoadFailed = false;
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void M() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && !this.F0) {
            this.F0 = true;
            A();
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.F0 = false;
            removeCallbacks(this);
            invalidate();
        }
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.U0 = null;
        }
    }

    public final boolean a0() {
        InterceptResult invokeV;
        GifInfo gifInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (!this.E0 && ((gifInfo = this.a1) == null || !gifInfo.mLoadFailed)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.T0 = null;
            dc dcVar = this.x0;
            if (dcVar != null) {
                dcVar.close();
            }
            if (this.a1 != null) {
                this.a1 = null;
            }
            if (this.y0 != null) {
                this.y0 = null;
            }
        }
    }

    public final void c0() {
        c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (cVar = this.A0) != null && !this.S0) {
            cVar.onStop();
            this.S0 = true;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.drawableStateChanged();
            Drawable drawable = this.J0;
            if (drawable != null && drawable.isStateful()) {
                this.J0.setState(getDrawableState());
                invalidate();
            }
        }
    }

    public void e0() {
        dc dcVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            N();
            F();
            if (this.R0 && (dcVar = this.x0) != null && dcVar != null) {
                dcVar.close();
                this.x0 = null;
            }
        }
    }

    public void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.w0 = R.drawable.pic_expression_upload_selector;
        }
    }

    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.S0 = false;
            dc gif = getGif();
            if (gif == null) {
                return;
            }
            this.Y0.removeMessages(1);
            this.Y0.sendEmptyMessageDelayed(1, gif.b(this.z0));
        }
    }

    public boolean getAutoPlay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.N0;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView
    public hn getBdImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.T0;
        }
        return (hn) invokeV.objValue;
    }

    public dc getGif() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            dc dcVar = this.x0;
            if (dcVar == null) {
                c0();
                return null;
            }
            return dcVar;
        }
        return (dc) invokeV.objValue;
    }

    public GifInfo getGifInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.a1;
        }
        return (GifInfo) invokeV.objValue;
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public int getImageHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            hn hnVar = this.T0;
            if (hnVar == null) {
                return 0;
            }
            return hnVar.m();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public int getImageWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            hn hnVar = this.T0;
            if (hnVar == null) {
                return 0;
            }
            return hnVar.r();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public float[] getRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return lw4.b(this.V0);
        }
        return (float[]) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.U0;
        }
        return (String) invokeV.objValue;
    }

    public final void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            SkinManager.setImageResource(this, this.X0);
            z85 z85Var = this.W0;
            if (z85Var != null) {
                z85Var.onLoadFail();
            }
        }
    }

    public void k0() {
        dc gif;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048601, this) != null) || (gif = getGif()) == null) {
            return;
        }
        this.Y0.removeMessages(1);
        gif.c(0);
        gif.a(this.y0, null);
        invalidate();
        c0();
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            super.onDetachedFromWindow();
            this.Y0.removeMessages(1);
            N();
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public void onStartTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            super.onStartTemporaryDetach();
            this.Y0.removeMessages(1);
            N();
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.tieba.el
    public void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            GifInfo gifInfo = this.a1;
            if (gifInfo != null) {
                i0(gifInfo);
            }
            if (!TextUtils.isEmpty(this.U0)) {
                j0(this.U0, this.b1);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            float f = this.G0;
            float f2 = this.H0;
            float f3 = f + f2;
            this.G0 = f3;
            if (f3 > 360.0f - f2) {
                this.G0 = 0.0f;
            }
            invalidate();
            A();
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, motionEvent)) == null) {
            TbRichTextView.w wVar = this.f1;
            if (wVar != null) {
                wVar.dispatchTouchEvent(motionEvent);
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
                N();
            }
            if (this.B0) {
                return;
            }
            if (i != 4 && i != 8) {
                if (i == 0) {
                    d0();
                    return;
                }
                return;
            }
            k0();
        }
    }

    public void setAutoPlay(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            this.N0 = z;
        }
    }

    public void setBgImage(hn hnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, hnVar) == null) {
            this.T0 = hnVar;
        }
    }

    public void setDefaultNoImageDay(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i) == null) {
            this.w0 = i;
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void setDispatchTouchListener(TbRichTextView.w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, wVar) == null) {
            this.f1 = wVar;
        }
    }

    public void setErrorResid(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i) == null) {
            this.X0 = i;
        }
    }

    public void setGifFile(String str) {
        byte[] GetFileData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048616, this, str) != null) || (GetFileData = FileHelper.GetFileData(str)) == null) {
            return;
        }
        hn a2 = cc.a.b().a(GetFileData, 0, GetFileData.length);
        this.R0 = true;
        setGif(a2);
    }

    public void setIsKeepLastFrame(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            this.Q0 = z;
        }
    }

    public void setIsLoading(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048620, this, z) == null) {
            if (z) {
                M();
            } else {
                O();
            }
        }
    }

    public void setLoadCallback(z85 z85Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, z85Var) == null) {
            this.W0 = z85Var;
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, onClickListener) == null) {
            super.setOnClickListener(this);
            this.P0 = onClickListener;
        }
    }

    public void setOnInterceptClickListener(gq4 gq4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, gq4Var) == null) {
            super.setOnClickListener(this);
            this.O0 = gq4Var;
        }
    }

    public void setPlayCallback(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, cVar) == null) {
            this.A0 = cVar;
        }
    }

    public void setShowStaticDrawable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048625, this, z) == null) {
            this.C0 = z;
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void setSupportNoImage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048626, this, z) == null) {
            super.setSupportNoImage(z);
            this.c1 = z;
        }
    }

    public void setType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048627, this, i) == null) {
            this.b1 = i;
        }
    }

    public static Bitmap Z(GifView gifView) {
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
    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            O();
            this.E0 = false;
            this.I0 = false;
            if (this.a1 != null) {
                sg.h().d(this.a1.mSharpText, this.b1, this.e1);
            }
            if (!TextUtils.isEmpty(this.U0)) {
                sg.h().d(this.U0, this.b1, this.e1);
            }
        }
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.S0 = false;
            dc gif = getGif();
            if (gif == null) {
                return;
            }
            if (this.z0 != 0) {
                this.z0 = 0;
            }
            gif.c(0);
            this.Y0.removeMessages(1);
            this.Y0.sendEmptyMessageDelayed(1, gif.b(this.z0));
        }
    }

    public void i0(GifInfo gifInfo) {
        BdUniqueId bdUniqueId;
        boolean z;
        boolean z2;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, gifInfo) == null) {
            this.b1 = 20;
            if (gifInfo == null) {
                this.a1 = null;
                h0();
                return;
            }
            z85 z85Var = this.W0;
            if (z85Var != null) {
                z85Var.a();
            }
            boolean c2 = mi5.c();
            v9 c3 = w9.c(getContext());
            if (c3 != null) {
                bdUniqueId = c3.getUniqueId();
                z = c3.isScroll();
            } else {
                bdUniqueId = null;
                z = false;
            }
            GifInfo gifInfo2 = this.a1;
            if (gifInfo2 != null && (str2 = gifInfo.mDynamicUrl) != null && StringHelper.equals(str2, gifInfo2.mDynamicUrl) && StringHelper.equals(gifInfo.mSharpText, this.a1.mSharpText) && StringHelper.equals(gifInfo.mStaticUrl, this.a1.mStaticUrl) && this.d1 == bdUniqueId) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                N();
            }
            this.a1 = gifInfo;
            this.d1 = bdUniqueId;
            this.U0 = null;
            F();
            GifInfo gifInfo3 = this.a1;
            if (c2) {
                str = gifInfo3.mDynamicUrl;
            } else {
                str = gifInfo3.mStaticUrl;
            }
            sg h = sg.h();
            GifInfo gifInfo4 = this.a1;
            String str3 = gifInfo4.mSharpText;
            hn hnVar = (hn) h.n(str3, this.b1, gifInfo4.mGid, str3, Boolean.valueOf(c2), str);
            if (hnVar != null) {
                O();
                setGif(hnVar);
            } else if (this.a1.mLoadFailed) {
                setGif(null);
                h0();
            } else if (!sg.h().j(this.b1) && this.c1) {
                setHasNoImage(true, this.w0);
            } else if (z) {
            } else {
                M();
                sg h2 = sg.h();
                GifInfo gifInfo5 = this.a1;
                String str4 = gifInfo5.mSharpText;
                h2.k(str4, this.b1, this.e1, 0, 0, this.d1, gifInfo5.mGid, str4, Boolean.valueOf(c2), str);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, canvas) == null) {
            try {
                if ((!this.F0 && !this.E0 && !this.I0) || a0()) {
                    super.onDraw(canvas);
                }
                canvas.save();
                if (this.x0 != null && !this.F0 && !this.E0 && !this.I0) {
                    this.x0.a(null, canvas);
                }
                canvas.restore();
            } catch (Throwable th) {
                BdLog.e("setGif:" + th.getMessage());
                c0();
            }
            if (this.B0 && this.C0) {
                canvas.save();
                this.D0.draw(canvas);
                canvas.restore();
            }
            if (this.F0 && Z(this) != null) {
                canvas.save();
                int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                float height = (((getHeight() - getPaddingTop()) - getPaddingBottom()) * 0.5f) + getPaddingTop();
                canvas.rotate(this.G0, (width * 0.5f) + getPaddingLeft(), height);
                canvas.drawBitmap(Z(this), this.M0, this.L0, (Paint) null);
                canvas.restore();
            } else if (this.I0) {
                canvas.save();
                this.J0.draw(canvas);
                canvas.restore();
            }
        }
    }

    public void setGif(hn hnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, hnVar) == null) {
            setBackgroundDrawable(null);
            this.T0 = hnVar;
            this.E0 = false;
            this.F0 = false;
            this.I0 = false;
            GifInfo gifInfo = this.a1;
            if (gifInfo != null) {
                gifInfo.mLoadFailed = false;
            }
            if (hnVar == null) {
                this.E0 = true;
                this.B0 = false;
                GifInfo gifInfo2 = this.a1;
                if (gifInfo2 != null) {
                    gifInfo2.mLoadFailed = true;
                }
                h0();
                dc dcVar = this.x0;
                if (dcVar != null) {
                    dcVar.close();
                    return;
                }
                return;
            }
            z85 z85Var = this.W0;
            if (z85Var != null) {
                z85Var.onLoadSuccess();
            }
            if (hnVar.l() == null) {
                if (!hnVar.s()) {
                    this.B0 = true;
                    hnVar.h(this);
                    this.F0 = false;
                }
                dc dcVar2 = this.x0;
                if (dcVar2 != null) {
                    dcVar2.close();
                }
            } else if (this.x0 != null && hnVar.l().equals(this.x0)) {
                if (this.z0 >= hnVar.l().getFrameCount()) {
                    this.z0 = 0;
                }
                hnVar.l().c(this.z0);
                hnVar.l().a(this.y0, null);
                setImageBitmap(this.y0);
                if (this.N0) {
                    g0();
                }
            } else {
                this.B0 = false;
                try {
                    if (this.y0 == null || (this.y0.getWidth() != hnVar.l().getWidth() && this.y0.getHeight() != hnVar.l().getHeight())) {
                        this.y0 = Bitmap.createBitmap(hnVar.l().getWidth(), hnVar.l().getHeight(), Bitmap.Config.ARGB_8888);
                    }
                    this.x0 = hnVar.l();
                    hnVar.l().c(0);
                    hnVar.l().a(this.y0, null);
                    setImageBitmap(this.y0);
                    if (this.N0) {
                        d0();
                    }
                } catch (Throwable unused) {
                    c0();
                }
            }
        }
    }

    public void j0(String str, int i) {
        BdUniqueId bdUniqueId;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048600, this, str, i) == null) {
            this.b1 = i;
            this.a1 = null;
            if (TextUtils.isEmpty(str)) {
                this.U0 = null;
                h0();
                return;
            }
            z85 z85Var = this.W0;
            if (z85Var != null) {
                z85Var.a();
            }
            v9 c2 = w9.c(getContext());
            if (c2 != null) {
                bdUniqueId = c2.getUniqueId();
                z = c2.isScroll();
            } else {
                bdUniqueId = null;
                z = false;
            }
            if (str.equals(this.U0) && i == this.b1 && bdUniqueId == this.d1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                N();
                if (!TextUtils.isEmpty(this.U0)) {
                    setImageDrawable(null);
                    setBgImage(null);
                }
            }
            this.d1 = bdUniqueId;
            F();
            this.U0 = str;
            this.a1 = null;
            hn hnVar = (hn) sg.h().n(str, i, new Object[0]);
            if (hnVar != null) {
                O();
                setGif(hnVar);
            } else if (!sg.h().j(this.b1) && this.c1) {
                setHasNoImage(true, this.w0);
            } else if (z) {
            } else {
                sg.h().m(this.U0, i, this.e1, this.d1);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View.OnClickListener
    public void onClick(View view2) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, view2) == null) {
            gq4 gq4Var = this.O0;
            if (gq4Var != null && gq4Var.a(view2)) {
                return;
            }
            if (this.a1 != null) {
                boolean c2 = mi5.c();
                GifInfo gifInfo = this.a1;
                if (c2) {
                    str = gifInfo.mDynamicUrl;
                } else {
                    str = gifInfo.mStaticUrl;
                }
                sg h = sg.h();
                GifInfo gifInfo2 = this.a1;
                String str2 = gifInfo2.mSharpText;
                hn hnVar = (hn) h.n(str2, this.b1, gifInfo2.mGid, str2, Boolean.valueOf(c2), str);
                if (hnVar != null) {
                    this.a1.mLoadFailed = false;
                    setGif(hnVar);
                } else {
                    M();
                    sg h2 = sg.h();
                    GifInfo gifInfo3 = this.a1;
                    String str3 = gifInfo3.mSharpText;
                    h2.k(str3, this.b1, this.e1, 0, 0, this.d1, gifInfo3.mGid, str3, Boolean.valueOf(c2), str);
                    return;
                }
            }
            if (!TextUtils.isEmpty(this.U0)) {
                hn hnVar2 = (hn) sg.h().n(this.U0, this.b1, new Object[0]);
                if (hnVar2 != null) {
                    this.E0 = false;
                    setGif(hnVar2);
                } else {
                    M();
                    sg.h().m(this.U0, this.b1, this.e1, this.d1);
                    return;
                }
            }
            View.OnClickListener onClickListener = this.P0;
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
            if (Z(this) != null) {
                int width = g1.getWidth();
                int height = g1.getHeight();
                int i6 = ((i5 - width) / 2) + paddingLeft;
                int i7 = ((paddingBottom - height) / 2) + paddingTop;
                this.L0.set(i6, i7, width + i6, height + i7);
            }
            Drawable drawable = this.J0;
            if (drawable != null) {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = this.J0.getIntrinsicHeight();
                if (intrinsicWidth > i5) {
                    intrinsicWidth = i5;
                }
                if (intrinsicHeight > paddingBottom) {
                    intrinsicHeight = paddingBottom;
                }
                int i8 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
                int i9 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
                this.J0.setBounds(i8, i9, intrinsicWidth + i8, intrinsicHeight + i9);
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
    /* JADX WARN: Type inference failed for: r5v9, types: [com.baidu.tieba.cc] */
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
                hn a2 = cc.a.b().a(bArr, 0, interceptable);
                this.R0 = true;
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
            this.I0 = z;
            if (z) {
                this.F0 = false;
                this.E0 = false;
                if (this.J0 == null || this.K0 != i) {
                    this.K0 = i;
                    Drawable drawable = SkinManager.getDrawable(i);
                    this.J0 = drawable;
                    int intrinsicWidth = drawable.getIntrinsicWidth();
                    int intrinsicHeight = this.J0.getIntrinsicHeight();
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
                    this.J0.setBounds(paddingLeft, paddingTop, intrinsicWidth + paddingLeft, intrinsicHeight + paddingTop);
                }
            } else {
                this.J0 = null;
            }
            invalidate();
        }
    }
}
