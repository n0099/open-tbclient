package com.baidu.tieba;

import android.media.AudioTrack;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes5.dex */
public class bpb extends vob {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public apb B;
    public Thread C;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bpb(String str, int[] iArr) throws Exception {
        super(0, str, iArr);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, iArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), (String) objArr2[1], (int[]) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.vob
    public void B(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            M(j * 1000, true);
        }
    }

    @Override // com.baidu.tieba.vob
    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Thread thread = this.C;
            if (thread == null || !thread.isAlive()) {
                Thread thread2 = new Thread(this);
                this.C = thread2;
                thread2.start();
            }
            super.I();
        }
    }

    public final void K() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (i() == 1) {
                i = 4;
            } else {
                i();
                i = 12;
            }
            int i2 = this.q;
            if (i2 != 1 && i2 != 2) {
                this.q = 2;
            }
            this.B = new apb(3, m(), i, h() == 2 ? 2 : 3, AudioTrack.getMinBufferSize(m(), i, h() == 2 ? 2 : 3), 1);
        }
    }

    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            apb apbVar = this.B;
            return apbVar != null && apbVar.getState() == 1;
        }
        return invokeV.booleanValue;
    }

    public final void M(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            if (j < 0) {
                j = 0;
            }
            if (this.e != null && j > this.e.getDuration()) {
                j = this.e.getDuration();
            }
            if (z) {
                int playState = L() ? this.B.getPlayState() : 2;
                if (playState == 2) {
                    pause();
                }
                synchronized (this.b) {
                    if (L()) {
                        this.B.flush();
                    }
                    this.d = 0L;
                }
                e();
                c();
                if (playState == 3) {
                    I();
                }
            }
            synchronized (this.c) {
                if (this.e != null) {
                    this.e.seek(j);
                }
            }
        }
    }

    public void N(float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
            synchronized (this.b) {
                if (L()) {
                    this.B.setStereoVolume(f, f2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.vob
    public zob p() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            K();
            return this.B;
        }
        return (zob) invokeV.objValue;
    }

    @Override // com.baidu.tieba.vob
    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this.b) {
                if (L() && this.B.getPlayState() != 2) {
                    this.B.pause();
                }
            }
        }
    }

    @Override // com.baidu.tieba.vob
    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            synchronized (this.b) {
                if (L() && this.B.getPlayState() != 3) {
                    this.B.play();
                }
            }
        }
    }

    @Override // com.baidu.tieba.vob
    public void v() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.C == null) {
            return;
        }
        this.C = null;
    }
}
