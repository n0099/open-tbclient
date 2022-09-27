package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.kd9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class id9 implements kd9.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public hd9 a;
    public b b;
    public Thread c;
    public List<kd9> d;
    public int e;
    public int f;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ id9 a;

        public a(id9 id9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {id9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = id9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                id9 id9Var = this.a;
                if (id9Var.j(id9Var.a)) {
                    if (vg9.e(this.a.d)) {
                        this.a.m(" start mix chains error:mMixtureChains empty ");
                        return;
                    } else {
                        ((kd9) this.a.d.get(0)).d(this.a.a);
                        return;
                    }
                }
                id9 id9Var2 = this.a;
                StringBuilder sb = new StringBuilder();
                sb.append(" start mix chains error:initChainConfig ");
                sb.append(this.a.a == null);
                id9Var2.m(sb.toString());
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void onAudioMixtureCancel();

        void onAudioMixtureFail(String str);

        void onAudioMixtureProgress(int i);

        void onAudioMixtureSuccess(gd9 gd9Var);
    }

    public id9(hd9 hd9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hd9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = hd9Var;
        this.d = new ArrayList();
    }

    @Override // com.baidu.tieba.kd9.a
    public void a(kd9 kd9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, kd9Var) == null) {
            l();
        }
    }

    @Override // com.baidu.tieba.kd9.a
    public void b(kd9 kd9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kd9Var) == null) {
            int k = this.e + kd9Var.k();
            this.e = k;
            n(k);
            if (kd9Var == null || !kd9Var.m()) {
                return;
            }
            gd9 k2 = k(kd9Var.n());
            if (k2 != null) {
                o(k2);
            } else {
                m("onChainFinished result error");
            }
        }
    }

    @Override // com.baidu.tieba.kd9.a
    public void c(int i, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) || (i3 = (int) (this.e + (((i * 1.0f) / 100.0f) * i2))) <= this.f) {
            return;
        }
        n(i3);
        this.f = i3;
    }

    @Override // com.baidu.tieba.kd9.a
    public void d(String str, kd9 kd9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, kd9Var) == null) {
            m(str);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!vg9.e(this.d)) {
                for (kd9 kd9Var : this.d) {
                    kd9Var.b();
                }
            }
            Thread thread = this.c;
            if (thread != null) {
                thread.interrupt();
            }
        }
    }

    public final boolean j(hd9 hd9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, hd9Var)) == null) {
            if (hd9Var == null || vg9.e(hd9Var.c())) {
                return false;
            }
            List<jd9> c = hd9Var.c();
            gd9 gd9Var = null;
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            int i = 0;
            for (int i2 = 0; i2 < c.size(); i2++) {
                if (pd9.o(c.get(i2).b())) {
                    z = true;
                }
                if (!vg9.e(c.get(i2).a())) {
                    for (fd9 fd9Var : c.get(i2).a()) {
                        if (fd9Var != null) {
                            if (fd9Var.c()) {
                                if (gd9Var == null) {
                                    gd9Var = fd9Var.a();
                                }
                                if (gd9Var != null) {
                                    int k = gd9Var.k(fd9Var.a());
                                    z2 = ((gd9.g & k) == 0 && (gd9.i & k) == 0 && (k & gd9.h) == 0) ? false : true;
                                }
                                if (fd9Var.b().mSpeed != 1.0f) {
                                    z = true;
                                }
                                if (MimeTypes.AUDIO_RAW.equals(fd9Var.a().f())) {
                                    z = true;
                                }
                                z3 = true;
                            }
                            i++;
                            if (i > 1) {
                                z2 = true;
                            }
                            if (z2 && z && z3) {
                                break;
                            }
                        }
                    }
                }
                if (z2 && z && z3) {
                    break;
                }
            }
            if (z) {
                md9 md9Var = new md9();
                md9Var.c(z2 ? 50 : 90);
                md9Var.e(this);
                this.d.add(md9Var);
                ld9 ld9Var = new ld9();
                ld9Var.c(z2 ? 50 : 10);
                ld9Var.e(this);
                this.d.add(ld9Var);
                md9Var.f(ld9Var);
            } else {
                ld9 ld9Var2 = new ld9();
                ld9Var2.c(100);
                ld9Var2.e(this);
                this.d.add(ld9Var2);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final gd9 k(hd9 hd9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, hd9Var)) == null) {
            if (hd9Var != null && vg9.b(hd9Var.c()) == 1 && vg9.b(hd9Var.c().get(0).a()) == 1) {
                fd9 fd9Var = hd9Var.c().get(0).a().get(0);
                if (fd9Var.b() == null || fd9Var.b().isNeedEdit() || !fd9Var.c()) {
                    return null;
                }
                return fd9Var.a();
            }
            return null;
        }
        return (gd9) invokeL.objValue;
    }

    public final void l() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (bVar = this.b) == null) {
            return;
        }
        bVar.onAudioMixtureCancel();
    }

    public final void m(String str) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) || (bVar = this.b) == null) {
            return;
        }
        bVar.onAudioMixtureFail(str);
    }

    public final void n(int i) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i) == null) || (bVar = this.b) == null) {
            return;
        }
        bVar.onAudioMixtureProgress(i);
    }

    public final void o(gd9 gd9Var) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, gd9Var) == null) || (bVar = this.b) == null) {
            return;
        }
        bVar.onAudioMixtureProgress(100);
        this.b.onAudioMixtureSuccess(gd9Var);
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || vg9.e(this.d)) {
            return;
        }
        for (kd9 kd9Var : this.d) {
            kd9Var.h();
        }
    }

    public void q(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) {
            this.b = bVar;
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.d.clear();
            this.e = 0;
            this.f = 0;
            gd9 k = k(this.a);
            if (k != null && k.i()) {
                o(k);
                return;
            }
            Thread thread = this.c;
            if (thread != null) {
                thread.interrupt();
                this.c = null;
            }
            Thread thread2 = new Thread(new a(this));
            this.c = thread2;
            thread2.start();
        }
    }
}
