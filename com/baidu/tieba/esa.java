package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes5.dex */
public class esa extends xra implements sta {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public fsa B;
    public String C;
    public Thread D;
    public long E;
    public long F;

    /* loaded from: classes5.dex */
    public class a extends tta {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ esa a;

        public a(esa esaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {esaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = esaVar;
        }

        @Override // com.baidu.tieba.tta, com.baidu.tieba.sta
        public void onExceptionThrown(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.a.z == null || this.a.l) {
                return;
            }
            this.a.z.onExceptionThrown(str);
        }

        @Override // com.baidu.tieba.tta
        public void onFinishedWriting(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                this.a.k = true;
                if (this.a.z == null || this.a.l) {
                    return;
                }
                this.a.z.onFinishedWriting(z);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public esa(String str, String str2, int[] iArr) throws Exception {
        super(0, str, iArr);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, iArr};
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
        this.C = str2;
        this.B.e(str2);
        F(this);
    }

    @Override // com.baidu.tieba.xra
    public void B(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            long j2 = j * 1000;
            if (j2 < 0) {
                j2 = 0;
            }
            this.E = j2;
            if (this.e != null) {
                if (j2 > this.e.getDuration()) {
                    j2 = this.e.getDuration();
                }
                synchronized (this.c) {
                    this.e.seek(j2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.xra
    public void C() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.k) {
            return;
        }
        long currentPosition = this.e.getCurrentPosition();
        long j = this.E;
        long j2 = currentPosition - j;
        long j3 = this.F;
        long duration = j3 > 0 ? j3 - j : this.e.getDuration();
        double d = duration == 0 ? 0.0d : j2 / duration;
        double d2 = d >= 0.0d ? d : 0.0d;
        onProgressChanged(this.n, d2 > 1.0d ? 1.0d : d2, j2);
    }

    @Override // com.baidu.tieba.xra
    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.I();
            Thread thread = this.D;
            if (thread == null || !thread.isAlive()) {
                Thread thread2 = new Thread(this);
                this.D = thread2;
                thread2.start();
            }
            super.I();
        }
    }

    public void R(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            long j2 = j * 1000;
            this.F = j2;
            if (this.e != null) {
                if (j2 > this.e.getDuration()) {
                    j2 = this.e.getDuration();
                }
                synchronized (this.c) {
                    this.e.h(j2);
                }
            }
        }
    }

    public void S(tta ttaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ttaVar) == null) {
            this.z = ttaVar;
            this.B.d(new a(this));
        }
    }

    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.l = true;
            this.k = true;
            Thread thread = this.D;
            if (thread != null) {
                try {
                    thread.interrupt();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.D = null;
            }
            try {
                this.B.g();
            } catch (Exception e2) {
                yua.e("VideoMuxer", "cancel finishWriting error:" + e2.getMessage());
            }
        }
    }

    @Override // com.baidu.tieba.sta
    public void onCancel() {
        tta ttaVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (ttaVar = this.z) == null) {
            return;
        }
        ttaVar.onCancel();
    }

    @Override // com.baidu.tieba.sta
    public void onExceptionThrown(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, str) == null) || this.z == null || this.l) {
            return;
        }
        this.z.onExceptionThrown(str);
    }

    @Override // com.baidu.tieba.sta
    public void onProgressChanged(int i, double d, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), Double.valueOf(d), Long.valueOf(j)}) == null) || this.z == null || this.l) {
            return;
        }
        this.z.onProgressChanged(i, d, j);
    }

    @Override // com.baidu.tieba.sta
    public void onTrackEnd(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            try {
                this.B.b();
            } catch (Exception e) {
                yua.e("VideoMuxer", "onTrackEnd finishWriting error:" + e.getMessage());
            }
        }
    }

    @Override // com.baidu.tieba.xra
    public bsa p() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            fsa fsaVar = new fsa(this.C, m(), i());
            this.B = fsaVar;
            return fsaVar;
        }
        return (bsa) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xra
    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

    @Override // com.baidu.tieba.xra
    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    @Override // com.baidu.tieba.xra
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (this.D != null) {
                this.D = null;
            }
            try {
                this.B.b();
            } catch (Exception e) {
                yua.e("VideoMuxer", "onStop finishWriting error:" + e.getMessage());
            }
        }
    }
}
