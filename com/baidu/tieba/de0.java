package com.baidu.tieba;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class de0 extends yd0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Surface l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947701530, "Lcom/baidu/tieba/de0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947701530, "Lcom/baidu/tieba/de0;");
        }
    }

    public de0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public Surface k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.l;
        }
        return (Surface) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yd0
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.h == 0) {
                this.h = this.e.presentationTimeUs;
                yd0.j = 0L;
            }
            MediaCodec.BufferInfo bufferInfo = this.e;
            long j = bufferInfo.presentationTimeUs - this.h;
            bufferInfo.presentationTimeUs = j;
            yd0.j = j;
            td0.x().V(yd0.j / 1000);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void l(ae0 ae0Var, be0 be0Var) {
        zd0 zd0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, ae0Var, be0Var) == null) {
            boolean z = true;
            if (ae0Var != null && be0Var != null) {
                this.c = be0Var;
                MediaFormat createVideoFormat = MediaFormat.createVideoFormat(ae0Var.j(), ae0Var.n(), ae0Var.l());
                createVideoFormat.setInteger("color-format", 2130708361);
                createVideoFormat.setInteger("bitrate", ae0Var.i());
                createVideoFormat.setInteger("frame-rate", ae0Var.k());
                createVideoFormat.setInteger("i-frame-interval", ae0Var.m());
                try {
                    MediaCodec createEncoderByType = MediaCodec.createEncoderByType(ae0Var.j());
                    this.d = createEncoderByType;
                    createEncoderByType.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
                    this.l = this.d.createInputSurface();
                    this.g = true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                zd0Var = this.f;
                if (zd0Var == null) {
                    zd0Var.b(z);
                    return;
                }
                return;
            }
            z = false;
            zd0Var = this.f;
            if (zd0Var == null) {
            }
        }
    }
}
