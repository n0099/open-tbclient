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
import com.baidu.tieba.ca;
import com.baidu.tieba.da;
import com.baidu.tieba.gv4;
import com.baidu.tieba.ie5;
import com.baidu.tieba.jc;
import com.baidu.tieba.kc;
import com.baidu.tieba.ll;
import com.baidu.tieba.on;
import com.baidu.tieba.po5;
import com.baidu.tieba.q15;
import com.baidu.tieba.yg;
import com.baidu.tieba.zg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes3.dex */
public class GifView extends TbClipImageView implements Runnable, View.OnClickListener, ll {
    public static /* synthetic */ Interceptable $ic;
    public static Bitmap h1;
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
    public gv4 P0;
    public View.OnClickListener Q0;
    public boolean R0;
    public boolean S0;
    public boolean T0;
    public on U0;
    public String V0;
    public int W0;
    public ie5 X0;
    public int Y0;
    public Handler Z0;
    public boolean a1;
    public GifInfo b1;
    public int c1;
    public boolean d1;
    public BdUniqueId e1;
    public yg<on> f1;
    public TbRichTextView.y g1;
    public int x0;
    public kc y0;
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
            kc gif;
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && (gif = this.a.getGif()) != null && message.what == 1) {
                this.a.A0++;
                boolean z2 = false;
                if (this.a.A0 >= gif.getFrameCount()) {
                    if (this.a.a1) {
                        if (!this.a.R0) {
                            this.a.setVisibility(4);
                        }
                        this.a.a1 = false;
                        z = true;
                    } else {
                        z = false;
                    }
                    if (this.a.R0) {
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
                    this.a.c0();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends yg<on> {
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

        @Override // com.baidu.tieba.yg
        public void onProgressUpdate(Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, objArr) == null) {
                super.onProgressUpdate(objArr);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yg
        public void onLoaded(on onVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, onVar, str, i) == null) {
                super.onLoaded((b) onVar, str, i);
                this.a.O();
                this.a.setGif(onVar);
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
        this.M0 = new Rect();
        this.N0 = new Rect();
        this.O0 = true;
        this.R0 = false;
        this.S0 = false;
        this.T0 = false;
        this.Y0 = R.drawable.image_group_load_f;
        this.Z0 = new a(this, Looper.getMainLooper());
        this.c1 = 20;
        this.d1 = true;
        this.f1 = new b(this);
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
            Bitmap Z = Z(this);
            h1 = Z;
            this.N0.set(0, 0, Z.getWidth(), h1.getHeight());
        }
        this.W0 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
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
            this.y0 = null;
            this.z0 = null;
            this.Z0.removeCallbacksAndMessages(null);
            this.F0 = false;
            this.A0 = 0;
            GifInfo gifInfo = this.b1;
            if (gifInfo != null) {
                gifInfo.mLoadFailed = false;
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void M() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && !this.G0) {
            this.G0 = true;
            A();
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.G0 = false;
            removeCallbacks(this);
            invalidate();
        }
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.V0 = null;
        }
    }

    public final boolean a0() {
        InterceptResult invokeV;
        GifInfo gifInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (!this.F0 && ((gifInfo = this.b1) == null || !gifInfo.mLoadFailed)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.U0 = null;
            kc kcVar = this.y0;
            if (kcVar != null) {
                kcVar.close();
            }
            if (this.b1 != null) {
                this.b1 = null;
            }
            if (this.z0 != null) {
                this.z0 = null;
            }
        }
    }

    public final void c0() {
        c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (cVar = this.B0) != null && !this.T0) {
            cVar.onStop();
            this.T0 = true;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.drawableStateChanged();
            Drawable drawable = this.K0;
            if (drawable != null && drawable.isStateful()) {
                this.K0.setState(getDrawableState());
                invalidate();
            }
        }
    }

    public void e0() {
        kc kcVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            N();
            F();
            if (this.S0 && (kcVar = this.y0) != null && kcVar != null) {
                kcVar.close();
                this.y0 = null;
            }
        }
    }

    public void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.x0 = R.drawable.pic_expression_upload_selector;
        }
    }

    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.T0 = false;
            kc gif = getGif();
            if (gif == null) {
                return;
            }
            this.Z0.removeMessages(1);
            this.Z0.sendEmptyMessageDelayed(1, gif.b(this.A0));
        }
    }

    public boolean getAutoPlay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.O0;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView
    public on getBdImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.U0;
        }
        return (on) invokeV.objValue;
    }

    public kc getGif() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            kc kcVar = this.y0;
            if (kcVar == null) {
                c0();
                return null;
            }
            return kcVar;
        }
        return (kc) invokeV.objValue;
    }

    public GifInfo getGifInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.b1;
        }
        return (GifInfo) invokeV.objValue;
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public int getImageHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            on onVar = this.U0;
            if (onVar == null) {
                return 0;
            }
            return onVar.m();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public int getImageWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            on onVar = this.U0;
            if (onVar == null) {
                return 0;
            }
            return onVar.r();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public float[] getRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return q15.b(this.W0);
        }
        return (float[]) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.V0;
        }
        return (String) invokeV.objValue;
    }

    public final void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            SkinManager.setImageResource(this, this.Y0);
            ie5 ie5Var = this.X0;
            if (ie5Var != null) {
                ie5Var.onLoadFail();
            }
        }
    }

    public void k0() {
        kc gif;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048601, this) != null) || (gif = getGif()) == null) {
            return;
        }
        this.Z0.removeMessages(1);
        gif.c(0);
        gif.a(this.z0, null);
        invalidate();
        c0();
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            super.onDetachedFromWindow();
            this.Z0.removeMessages(1);
            N();
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public void onStartTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            super.onStartTemporaryDetach();
            this.Z0.removeMessages(1);
            N();
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.tieba.ll
    public void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            GifInfo gifInfo = this.b1;
            if (gifInfo != null) {
                i0(gifInfo);
            }
            if (!TextUtils.isEmpty(this.V0)) {
                j0(this.V0, this.c1);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            float f = this.H0;
            float f2 = this.I0;
            float f3 = f + f2;
            this.H0 = f3;
            if (f3 > 360.0f - f2) {
                this.H0 = 0.0f;
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
            TbRichTextView.y yVar = this.g1;
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
                N();
            }
            if (this.C0) {
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
            this.O0 = z;
        }
    }

    public void setBgImage(on onVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, onVar) == null) {
            this.U0 = onVar;
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
            this.g1 = yVar;
        }
    }

    public void setErrorResid(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i) == null) {
            this.Y0 = i;
        }
    }

    public void setGifFile(String str) {
        byte[] GetFileData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048616, this, str) != null) || (GetFileData = FileHelper.GetFileData(str)) == null) {
            return;
        }
        on a2 = jc.a.b().a(GetFileData, 0, GetFileData.length);
        this.S0 = true;
        setGif(a2);
    }

    public void setIsKeepLastFrame(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            this.R0 = z;
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

    public void setLoadCallback(ie5 ie5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, ie5Var) == null) {
            this.X0 = ie5Var;
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, onClickListener) == null) {
            super.setOnClickListener(this);
            this.Q0 = onClickListener;
        }
    }

    public void setOnInterceptClickListener(gv4 gv4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, gv4Var) == null) {
            super.setOnClickListener(this);
            this.P0 = gv4Var;
        }
    }

    public void setPlayCallback(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, cVar) == null) {
            this.B0 = cVar;
        }
    }

    public void setShowStaticDrawable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048625, this, z) == null) {
            this.D0 = z;
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void setSupportNoImage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048626, this, z) == null) {
            super.setSupportNoImage(z);
            this.d1 = z;
        }
    }

    public void setType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048627, this, i) == null) {
            this.c1 = i;
        }
    }

    public static Bitmap Z(GifView gifView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, gifView)) == null) {
            Bitmap bitmap = h1;
            if (bitmap != null && !bitmap.isRecycled()) {
                return h1;
            }
            BitmapDrawable bitmapDrawable = (BitmapDrawable) gifView.getResources().getDrawable(R.drawable.img_loading);
            if (bitmapDrawable != null) {
                h1 = bitmapDrawable.getBitmap();
            }
            return h1;
        }
        return (Bitmap) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            O();
            this.F0 = false;
            this.J0 = false;
            if (this.b1 != null) {
                zg.h().d(this.b1.mSharpText, this.c1, this.f1);
            }
            if (!TextUtils.isEmpty(this.V0)) {
                zg.h().d(this.V0, this.c1, this.f1);
            }
        }
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.T0 = false;
            kc gif = getGif();
            if (gif == null) {
                return;
            }
            if (this.A0 != 0) {
                this.A0 = 0;
            }
            gif.c(0);
            this.Z0.removeMessages(1);
            this.Z0.sendEmptyMessageDelayed(1, gif.b(this.A0));
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
            this.c1 = 20;
            if (gifInfo == null) {
                this.b1 = null;
                h0();
                return;
            }
            ie5 ie5Var = this.X0;
            if (ie5Var != null) {
                ie5Var.a();
            }
            boolean c2 = po5.c();
            ca c3 = da.c(getContext());
            if (c3 != null) {
                bdUniqueId = c3.getUniqueId();
                z = c3.isScroll();
            } else {
                bdUniqueId = null;
                z = false;
            }
            GifInfo gifInfo2 = this.b1;
            if (gifInfo2 != null && (str2 = gifInfo.mDynamicUrl) != null && StringHelper.equals(str2, gifInfo2.mDynamicUrl) && StringHelper.equals(gifInfo.mSharpText, this.b1.mSharpText) && StringHelper.equals(gifInfo.mStaticUrl, this.b1.mStaticUrl) && this.e1 == bdUniqueId) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                N();
            }
            this.b1 = gifInfo;
            this.e1 = bdUniqueId;
            this.V0 = null;
            F();
            GifInfo gifInfo3 = this.b1;
            if (c2) {
                str = gifInfo3.mDynamicUrl;
            } else {
                str = gifInfo3.mStaticUrl;
            }
            zg h = zg.h();
            GifInfo gifInfo4 = this.b1;
            String str3 = gifInfo4.mSharpText;
            on onVar = (on) h.n(str3, this.c1, gifInfo4.mGid, str3, Boolean.valueOf(c2), str);
            if (onVar != null) {
                O();
                setGif(onVar);
            } else if (this.b1.mLoadFailed) {
                setGif(null);
                h0();
            } else if (!zg.h().j(this.c1) && this.d1) {
                setHasNoImage(true, this.x0);
            } else if (z) {
            } else {
                M();
                zg h2 = zg.h();
                GifInfo gifInfo5 = this.b1;
                String str4 = gifInfo5.mSharpText;
                h2.k(str4, this.c1, this.f1, 0, 0, this.e1, gifInfo5.mGid, str4, Boolean.valueOf(c2), str);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, canvas) == null) {
            try {
                if ((!this.G0 && !this.F0 && !this.J0) || a0()) {
                    super.onDraw(canvas);
                }
                canvas.save();
                if (this.y0 != null && !this.G0 && !this.F0 && !this.J0) {
                    this.y0.a(null, canvas);
                }
                canvas.restore();
            } catch (Throwable th) {
                BdLog.e("setGif:" + th.getMessage());
                c0();
            }
            if (this.C0 && this.D0) {
                canvas.save();
                this.E0.draw(canvas);
                canvas.restore();
            }
            if (this.G0 && Z(this) != null) {
                canvas.save();
                int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                float height = (((getHeight() - getPaddingTop()) - getPaddingBottom()) * 0.5f) + getPaddingTop();
                canvas.rotate(this.H0, (width * 0.5f) + getPaddingLeft(), height);
                canvas.drawBitmap(Z(this), this.N0, this.M0, (Paint) null);
                canvas.restore();
            } else if (this.J0) {
                canvas.save();
                this.K0.draw(canvas);
                canvas.restore();
            }
        }
    }

    public void setGif(on onVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, onVar) == null) {
            setBackgroundDrawable(null);
            this.U0 = onVar;
            this.F0 = false;
            this.G0 = false;
            this.J0 = false;
            GifInfo gifInfo = this.b1;
            if (gifInfo != null) {
                gifInfo.mLoadFailed = false;
            }
            if (onVar == null) {
                this.F0 = true;
                this.C0 = false;
                GifInfo gifInfo2 = this.b1;
                if (gifInfo2 != null) {
                    gifInfo2.mLoadFailed = true;
                }
                h0();
                kc kcVar = this.y0;
                if (kcVar != null) {
                    kcVar.close();
                    return;
                }
                return;
            }
            ie5 ie5Var = this.X0;
            if (ie5Var != null) {
                ie5Var.onLoadSuccess();
            }
            if (onVar.l() == null) {
                if (!onVar.s()) {
                    this.C0 = true;
                    onVar.h(this);
                    this.G0 = false;
                }
                kc kcVar2 = this.y0;
                if (kcVar2 != null) {
                    kcVar2.close();
                }
            } else if (this.y0 != null && onVar.l().equals(this.y0)) {
                if (this.A0 >= onVar.l().getFrameCount()) {
                    this.A0 = 0;
                }
                onVar.l().c(this.A0);
                onVar.l().a(this.z0, null);
                setImageBitmap(this.z0);
                if (this.O0) {
                    g0();
                }
            } else {
                this.C0 = false;
                try {
                    if (this.z0 == null || (this.z0.getWidth() != onVar.l().getWidth() && this.z0.getHeight() != onVar.l().getHeight())) {
                        this.z0 = Bitmap.createBitmap(onVar.l().getWidth(), onVar.l().getHeight(), Bitmap.Config.ARGB_8888);
                    }
                    this.y0 = onVar.l();
                    onVar.l().c(0);
                    onVar.l().a(this.z0, null);
                    setImageBitmap(this.z0);
                    if (this.O0) {
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
            this.c1 = i;
            this.b1 = null;
            if (TextUtils.isEmpty(str)) {
                this.V0 = null;
                h0();
                return;
            }
            ie5 ie5Var = this.X0;
            if (ie5Var != null) {
                ie5Var.a();
            }
            ca c2 = da.c(getContext());
            if (c2 != null) {
                bdUniqueId = c2.getUniqueId();
                z = c2.isScroll();
            } else {
                bdUniqueId = null;
                z = false;
            }
            if (str.equals(this.V0) && i == this.c1 && bdUniqueId == this.e1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                N();
                if (!TextUtils.isEmpty(this.V0)) {
                    setImageDrawable(null);
                    setBgImage(null);
                }
            }
            this.e1 = bdUniqueId;
            F();
            this.V0 = str;
            this.b1 = null;
            on onVar = (on) zg.h().n(str, i, new Object[0]);
            if (onVar != null) {
                O();
                setGif(onVar);
            } else if (!zg.h().j(this.c1) && this.d1) {
                setHasNoImage(true, this.x0);
            } else if (z) {
            } else {
                zg.h().m(this.V0, i, this.f1, this.e1);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View.OnClickListener
    public void onClick(View view2) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, view2) == null) {
            gv4 gv4Var = this.P0;
            if (gv4Var != null && gv4Var.a(view2)) {
                return;
            }
            if (this.b1 != null) {
                boolean c2 = po5.c();
                GifInfo gifInfo = this.b1;
                if (c2) {
                    str = gifInfo.mDynamicUrl;
                } else {
                    str = gifInfo.mStaticUrl;
                }
                zg h = zg.h();
                GifInfo gifInfo2 = this.b1;
                String str2 = gifInfo2.mSharpText;
                on onVar = (on) h.n(str2, this.c1, gifInfo2.mGid, str2, Boolean.valueOf(c2), str);
                if (onVar != null) {
                    this.b1.mLoadFailed = false;
                    setGif(onVar);
                } else {
                    M();
                    zg h2 = zg.h();
                    GifInfo gifInfo3 = this.b1;
                    String str3 = gifInfo3.mSharpText;
                    h2.k(str3, this.c1, this.f1, 0, 0, this.e1, gifInfo3.mGid, str3, Boolean.valueOf(c2), str);
                    return;
                }
            }
            if (!TextUtils.isEmpty(this.V0)) {
                on onVar2 = (on) zg.h().n(this.V0, this.c1, new Object[0]);
                if (onVar2 != null) {
                    this.F0 = false;
                    setGif(onVar2);
                } else {
                    M();
                    zg.h().m(this.V0, this.c1, this.f1, this.e1);
                    return;
                }
            }
            View.OnClickListener onClickListener = this.Q0;
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
                int width = h1.getWidth();
                int height = h1.getHeight();
                int i6 = ((i5 - width) / 2) + paddingLeft;
                int i7 = ((paddingBottom - height) / 2) + paddingTop;
                this.M0.set(i6, i7, width + i6, height + i7);
            }
            Drawable drawable = this.K0;
            if (drawable != null) {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = this.K0.getIntrinsicHeight();
                if (intrinsicWidth > i5) {
                    intrinsicWidth = i5;
                }
                if (intrinsicHeight > paddingBottom) {
                    intrinsicHeight = paddingBottom;
                }
                int i8 = ((i5 - intrinsicWidth) / 2) + paddingLeft;
                int i9 = ((paddingBottom - intrinsicHeight) / 2) + paddingTop;
                this.K0.setBounds(i8, i9, intrinsicWidth + i8, intrinsicHeight + i9);
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
    /* JADX WARN: Type inference failed for: r5v9, types: [com.baidu.tieba.jc] */
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
                on a2 = jc.a.b().a(bArr, 0, interceptable);
                this.S0 = true;
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
            this.J0 = z;
            if (z) {
                this.G0 = false;
                this.F0 = false;
                if (this.K0 == null || this.L0 != i) {
                    this.L0 = i;
                    Drawable drawable = SkinManager.getDrawable(i);
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
}
