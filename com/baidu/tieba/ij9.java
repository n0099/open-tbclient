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
/* loaded from: classes4.dex */
public class ij9 extends gj9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public sj9 h;
    public int i;
    public int j;

    /* loaded from: classes4.dex */
    public class a extends hl9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ AudioPlayData c;
        public final /* synthetic */ bj9 d;
        public final /* synthetic */ ij9 e;

        public a(ij9 ij9Var, String str, int i, AudioPlayData audioPlayData, bj9 bj9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ij9Var, str, Integer.valueOf(i), audioPlayData, bj9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ij9Var;
            this.a = str;
            this.b = i;
            this.c = audioPlayData;
            this.d = bj9Var;
        }

        @Override // com.baidu.tieba.hl9, com.baidu.tieba.gl9
        public void onExceptionThrown(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.e.h.cancel();
                AudioPlayData audioPlayData = this.c;
                if (audioPlayData.mSpeed != 1.0f || lj9.o(audioPlayData.mSoundTypes)) {
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

        @Override // com.baidu.tieba.hl9
        public void onFinishedWriting(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (z) {
                    this.e.q(new bj9(new AudioPlayData(this.a, 0, -1, 1.0f)), this.b);
                }
                synchronized (this.e) {
                    this.e.notifyAll();
                }
            }
        }

        @Override // com.baidu.tieba.hl9, com.baidu.tieba.gl9
        public void onProgressChanged(int i, double d, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Double.valueOf(d), Long.valueOf(j)}) == null) {
                ij9 ij9Var = this.e;
                ij9Var.i((int) (((((ij9Var.j - 1) + d) * 1.0d) / this.e.i) * 100.0d));
            }
        }
    }

    public ij9() {
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

    @Override // com.baidu.tieba.gj9
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f = true;
            sj9 sj9Var = this.h;
            if (sj9Var != null) {
                sj9Var.cancel();
            }
            synchronized (this) {
                notifyAll();
            }
            o();
        }
    }

    @Override // com.baidu.tieba.gj9
    public void d(dj9 dj9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dj9Var) == null) {
            if (dj9Var == null || rm9.e(dj9Var.c())) {
                g("input data error: null or length=0");
            } else if (!j(dj9Var)) {
                l(dj9Var);
            } else {
                String a2 = dj9Var.a();
                this.g = a2;
                if (!TextUtils.isEmpty(a2) && !FileUtils.isExists(this.g)) {
                    new File(this.g).mkdir();
                }
                this.e = false;
                this.f = false;
                y(dj9Var);
                x(dj9Var);
                List<fj9> c = dj9Var.c();
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

    @Override // com.baidu.tieba.gj9
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            sj9 sj9Var = this.h;
            if (sj9Var != null) {
                sj9Var.J();
            }
            synchronized (this) {
                notifyAll();
            }
        }
    }

    public final void q(bj9 bj9Var, int i) {
        dj9 dj9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, bj9Var, i) == null) || (dj9Var = this.d) == null || dj9Var.c() == null || this.d.c().get(i) == null) {
            return;
        }
        this.d.c().get(i).a().add(bj9Var);
    }

    public final void r(fj9 fj9Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, fj9Var, i) == null) || fj9Var == null || rm9.e(fj9Var.a()) || this.f || this.e) {
            return;
        }
        for (bj9 bj9Var : fj9Var.a()) {
            if (this.e || this.f) {
                return;
            }
            this.j++;
            if (t(bj9Var)) {
                v(bj9Var, i);
            } else {
                q(bj9Var, i);
                i((int) (((this.j * 1.0f) / this.i) * 100.0f));
            }
        }
    }

    public final boolean t(bj9 bj9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bj9Var)) == null) {
            if (bj9Var == null || bj9Var.b() == null || !bj9Var.c()) {
                return false;
            }
            if (!lj9.o(bj9Var.b().mSoundTypes) && bj9Var.b().mSpeed == 1.0f && bj9Var.b().start == 0 && bj9Var.b().end == -1 && bj9Var.b().volume == 1.0f) {
                return (bj9Var.a() == null || "audio/mp4a-latm".equals(bj9Var.a().f())) ? false : true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void v(bj9 bj9Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, bj9Var, i) == null) || this.f || this.e) {
            return;
        }
        AudioPlayData b = bj9Var.b();
        if (b == null || !FileUtils.isExists(b.audioPath)) {
            g("dealAudioPlayData,trackIndx:inputerror");
            return;
        }
        String str = b.audioPath;
        String a2 = a(str, System.currentTimeMillis() + "_mediacodec.aac");
        try {
            sj9 sj9Var = new sj9(b.audioPath, a2, b.mSoundTypes);
            this.h = sj9Var;
            sj9Var.S(new a(this, a2, i, b, bj9Var));
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
            g("dealAudioPlayData exception:" + wm9.g(e));
            e.printStackTrace();
        }
    }

    public final void x(dj9 dj9Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, dj9Var) == null) || dj9Var == null || rm9.e(dj9Var.c())) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < dj9Var.c().size(); i++) {
            arrayList.add(new fj9(new ArrayList()));
        }
        dj9 dj9Var2 = new dj9(arrayList);
        this.d = dj9Var2;
        dj9Var2.e(dj9Var.b());
        this.d.d(dj9Var.a());
    }

    public final void y(dj9 dj9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dj9Var) == null) {
            this.i = 0;
            this.j = 0;
            List<fj9> c = dj9Var.c();
            int size = c.size();
            for (int i = 0; i < size; i++) {
                if (c.get(i) != null && c.get(i).a() != null) {
                    this.i += c.get(i).a().size();
                }
            }
        }
    }
}
