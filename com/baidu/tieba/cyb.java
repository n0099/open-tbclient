package com.baidu.tieba;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Message;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.transvod.player.log.TLog;
/* loaded from: classes5.dex */
public class cyb extends wxb implements TextureView.SurfaceTextureListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextureView K;
    public int L;
    public boolean M;
    public Surface N;

    public cyb(Context context, View view2, int i, int i2, gwb gwbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view2, Integer.valueOf(i), Integer.valueOf(i2), gwbVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.K = null;
        this.L = 0;
        this.M = false;
        this.N = null;
        A(context, view2, i, i2, gwbVar);
    }

    @Override // com.baidu.tieba.wxb
    public void A(Context context, Object obj, int i, int i2, gwb gwbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{context, obj, Integer.valueOf(i), Integer.valueOf(i2), gwbVar}) == null) {
            super.A(context, obj, i, i2, gwbVar);
            if (obj != null && (obj instanceof TextureView)) {
                TextureView textureView = (TextureView) obj;
                this.K = textureView;
                textureView.setSurfaceTextureListener(this);
                b0();
                if (Build.MODEL.equals("OPPO A33t")) {
                    this.K.setLayerType(1, null);
                }
                if (this.K.isAvailable()) {
                    this.N = new Surface(this.K.getSurfaceTexture());
                    Z(this.K.getSurfaceTexture());
                    a0(this.K.getSurfaceTexture(), this.K.getWidth(), this.K.getHeight());
                }
            }
        }
    }

    public final void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            X(false);
            synchronized (this.i) {
                if (this.d != null && this.a.available()) {
                    this.d.g(2402);
                    this.d.f(2402);
                }
            }
        }
    }

    public final void Z(SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, surfaceTexture) == null) {
            X(true);
            synchronized (this.i) {
                if (this.d != null) {
                    if (this.a.available()) {
                        this.d.g(2402);
                        this.d.f(2402);
                    }
                    TLog.l(this, "do send surfaceCreated, playerUID:" + this.r);
                    this.d.g(2401);
                    this.d.sendMessage(Message.obtain(null, 2401, surfaceTexture));
                }
            }
        }
    }

    public final void a0(SurfaceTexture surfaceTexture, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048579, this, surfaceTexture, i, i2) == null) {
            synchronized (this.i) {
                if (this.d != null) {
                    this.d.g(2404);
                    this.d.sendMessage(Message.obtain(null, 2404, i, i2, surfaceTexture));
                    TLog.l(this, "onSurfaceTextureSizeChanged() width:" + i + ", height:" + i2 + ", playerUID:" + this.r);
                }
            }
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048587, this, surfaceTexture, i, i2) == null) {
            if (this.L % 100 == 0) {
                TLog.l(this, "onSurfaceTextureSizeChanged() width:" + i + ", height:" + i2 + ", playerUID:" + this.r);
            }
            D();
            this.I.set(true);
            U();
            this.L++;
            a0(surfaceTexture, i, i2);
        }
    }

    public final void b0() {
        TextureView textureView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (textureView = this.K) != null) {
            textureView.setOpaque(false);
            if (Build.VERSION.SDK_INT < 24) {
                this.K.setBackgroundColor(0);
            }
        }
    }

    @Override // com.baidu.tieba.txb
    public void c() {
        Surface surface;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (surface = this.N) != null) {
            surface.release();
            this.N = null;
        }
    }

    public void finalize() throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.finalize();
        }
    }

    @Override // com.baidu.tieba.txb
    public Object getWindow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.N;
        }
        return invokeV.objValue;
    }

    @Override // com.baidu.tieba.txb
    public void d(SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, surfaceTexture) == null) {
            this.N = new Surface(surfaceTexture);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, surfaceTexture) == null) {
            synchronized (this.i) {
                if (this.d != null && this.a.available()) {
                    this.d.g(2405);
                    this.d.f(2405);
                }
            }
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048585, this, surfaceTexture, i, i2) == null) {
            TLog.l(this, "onSurfaceTextureAvailable() width:" + i + ", height:" + i2 + ", playerUID:" + this.r);
            this.I.set(true);
            Z(surfaceTexture);
            a0(surfaceTexture, i, i2);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, surfaceTexture)) == null) {
            TLog.l(this, "onSurfaceTextureDestroyed playerUID:" + this.r);
            D();
            this.I.set(false);
            U();
            Y();
            return this.M;
        }
        return invokeL.booleanValue;
    }
}
