package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.player.AudioPlayData;
import com.baidu.ugc.utils.FileUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class ee9 extends ce9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public oe9 h;
    public int i;
    public int j;

    /* loaded from: classes3.dex */
    public class a extends dg9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ AudioPlayData c;
        public final /* synthetic */ xd9 d;
        public final /* synthetic */ ee9 e;

        public a(ee9 ee9Var, String str, int i, AudioPlayData audioPlayData, xd9 xd9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ee9Var, str, Integer.valueOf(i), audioPlayData, xd9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ee9Var;
            this.a = str;
            this.b = i;
            this.c = audioPlayData;
            this.d = xd9Var;
        }

        @Override // com.baidu.tieba.dg9, com.baidu.tieba.cg9
        public void onExceptionThrown(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.e.h.cancel();
                AudioPlayData audioPlayData = this.c;
                if (audioPlayData.mSpeed != 1.0f || he9.o(audioPlayData.mSoundTypes)) {
                    this.e.g(str);
                    this.e.h.cancel();
                } else {
                    this.e.h.cancel();
                    this.e.q(this.d, this.b);
                }
                synchronized (this.e) {
                    this.e.notifyAll();
                }
            }
        }

        @Override // com.baidu.tieba.dg9
        public void onFinishedWriting(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (z) {
                    this.e.q(new xd9(new AudioPlayData(this.a, 0, -1, 1.0f)), this.b);
                }
                synchronized (this.e) {
                    this.e.notifyAll();
                }
            }
        }

        @Override // com.baidu.tieba.dg9, com.baidu.tieba.cg9
        public void onProgressChanged(int i, double d, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Double.valueOf(d), Long.valueOf(j)}) == null) {
                ee9 ee9Var = this.e;
                ee9Var.i((int) (((((ee9Var.j - 1) + d) * 1.0d) / this.e.i) * 100.0d));
            }
        }
    }

    public ee9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.ce9
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f = true;
            oe9 oe9Var = this.h;
            if (oe9Var != null) {
                oe9Var.cancel();
            }
            synchronized (this) {
                notifyAll();
            }
            o();
        }
    }

    @Override // com.baidu.tieba.ce9
    public void d(zd9 zd9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zd9Var) == null) {
            if (zd9Var == null || nh9.e(zd9Var.c())) {
                g("input data error: null or length=0");
            } else if (!j(zd9Var)) {
                l(zd9Var);
            } else {
                String a2 = zd9Var.a();
                this.g = a2;
                if (!TextUtils.isEmpty(a2) && !FileUtils.isExists(this.g)) {
                    new File(this.g).mkdir();
                }
                this.e = false;
                this.f = false;
                y(zd9Var);
                x(zd9Var);
                List<be9> c = zd9Var.c();
                int size = c.size();
                for (int i = 0; i < size; i++) {
                    r(c.get(i), i);
                }
                if (this.e || this.f) {
                    return;
                }
                l(this.d);
            }
        }
    }

    @Override // com.baidu.tieba.ce9
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            oe9 oe9Var = this.h;
            if (oe9Var != null) {
                oe9Var.J();
            }
            synchronized (this) {
                notifyAll();
            }
        }
    }

    public final void q(xd9 xd9Var, int i) {
        zd9 zd9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, xd9Var, i) == null) || (zd9Var = this.d) == null || zd9Var.c() == null || this.d.c().get(i) == null) {
            return;
        }
        this.d.c().get(i).a().add(xd9Var);
    }

    public final void r(be9 be9Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, be9Var, i) == null) || be9Var == null || nh9.e(be9Var.a()) || this.f || this.e) {
            return;
        }
        for (xd9 xd9Var : be9Var.a()) {
            if (this.e || this.f) {
                return;
            }
            this.j++;
            if (t(xd9Var)) {
                v(xd9Var, i);
            } else {
                q(xd9Var, i);
                i((int) (((this.j * 1.0f) / this.i) * 100.0f));
            }
        }
    }

    public final boolean t(xd9 xd9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, xd9Var)) == null) {
            if (xd9Var == null || xd9Var.b() == null || !xd9Var.c()) {
                return false;
            }
            if (!he9.o(xd9Var.b().mSoundTypes) && xd9Var.b().mSpeed == 1.0f && xd9Var.b().start == 0 && xd9Var.b().end == -1 && xd9Var.b().volume == 1.0f) {
                return (xd9Var.a() == null || "audio/mp4a-latm".equals(xd9Var.a().f())) ? false : true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void v(xd9 xd9Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, xd9Var, i) == null) || this.f || this.e) {
            return;
        }
        AudioPlayData b = xd9Var.b();
        if (b == null || !FileUtils.isExists(b.audioPath)) {
            g("dealAudioPlayData,trackIndx:inputerror");
            return;
        }
        String str = b.audioPath;
        String a2 = a(str, System.currentTimeMillis() + "_mediacodec.aac");
        try {
            oe9 oe9Var = new oe9(b.audioPath, a2, b.mSoundTypes);
            this.h = oe9Var;
            oe9Var.S(new a(this, a2, i, b, xd9Var));
            this.h.D(b.mSoundTypes);
            this.h.G(b.mSpeed);
            this.h.H(b.volume);
            this.h.B(b.start);
            this.h.R(b.end);
            this.h.I();
            synchronized (this) {
                wait();
            }
        } catch (Exception e) {
            g("dealAudioPlayData exception:" + sh9.g(e));
            e.printStackTrace();
        }
    }

    public final void x(zd9 zd9Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, zd9Var) == null) || zd9Var == null || nh9.e(zd9Var.c())) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < zd9Var.c().size(); i++) {
            arrayList.add(new be9(new ArrayList()));
        }
        zd9 zd9Var2 = new zd9(arrayList);
        this.d = zd9Var2;
        zd9Var2.e(zd9Var.b());
        this.d.d(zd9Var.a());
    }

    public final void y(zd9 zd9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, zd9Var) == null) {
            this.i = 0;
            this.j = 0;
            List<be9> c = zd9Var.c();
            int size = c.size();
            for (int i = 0; i < size; i++) {
                if (c.get(i) != null && c.get(i).a() != null) {
                    this.i += c.get(i).a().size();
                }
            }
        }
    }
}
