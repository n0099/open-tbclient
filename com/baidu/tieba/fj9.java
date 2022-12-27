package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.hj9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class fj9 implements hj9.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ej9 a;
    public b b;
    public Thread c;
    public List<hj9> d;
    public int e;
    public int f;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fj9 a;

        public a(fj9 fj9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fj9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fj9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                fj9 fj9Var = this.a;
                if (fj9Var.j(fj9Var.a)) {
                    if (sm9.e(this.a.d)) {
                        this.a.m(" start mix chains error:mMixtureChains empty ");
                        return;
                    } else {
                        ((hj9) this.a.d.get(0)).d(this.a.a);
                        return;
                    }
                }
                fj9 fj9Var2 = this.a;
                StringBuilder sb = new StringBuilder();
                sb.append(" start mix chains error:initChainConfig ");
                sb.append(this.a.a == null);
                fj9Var2.m(sb.toString());
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void onAudioMixtureCancel();

        void onAudioMixtureFail(String str);

        void onAudioMixtureProgress(int i);

        void onAudioMixtureSuccess(dj9 dj9Var);
    }

    public fj9(ej9 ej9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ej9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = ej9Var;
        this.d = new ArrayList();
    }

    @Override // com.baidu.tieba.hj9.a
    public void a(hj9 hj9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, hj9Var) == null) {
            l();
        }
    }

    @Override // com.baidu.tieba.hj9.a
    public void b(hj9 hj9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hj9Var) == null) {
            int k = this.e + hj9Var.k();
            this.e = k;
            n(k);
            if (hj9Var == null || !hj9Var.m()) {
                return;
            }
            dj9 k2 = k(hj9Var.n());
            if (k2 != null) {
                o(k2);
            } else {
                m("onChainFinished result error");
            }
        }
    }

    @Override // com.baidu.tieba.hj9.a
    public void c(int i, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) || (i3 = (int) (this.e + (((i * 1.0f) / 100.0f) * i2))) <= this.f) {
            return;
        }
        n(i3);
        this.f = i3;
    }

    @Override // com.baidu.tieba.hj9.a
    public void d(String str, hj9 hj9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, hj9Var) == null) {
            m(str);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!sm9.e(this.d)) {
                for (hj9 hj9Var : this.d) {
                    hj9Var.b();
                }
            }
            Thread thread = this.c;
            if (thread != null) {
                thread.interrupt();
            }
        }
    }

    public final boolean j(ej9 ej9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, ej9Var)) == null) {
            if (ej9Var == null || sm9.e(ej9Var.c())) {
                return false;
            }
            List<gj9> c = ej9Var.c();
            dj9 dj9Var = null;
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            int i = 0;
            for (int i2 = 0; i2 < c.size(); i2++) {
                if (mj9.o(c.get(i2).b())) {
                    z = true;
                }
                if (!sm9.e(c.get(i2).a())) {
                    for (cj9 cj9Var : c.get(i2).a()) {
                        if (cj9Var != null) {
                            if (cj9Var.c()) {
                                if (dj9Var == null) {
                                    dj9Var = cj9Var.a();
                                }
                                if (dj9Var != null) {
                                    int k = dj9Var.k(cj9Var.a());
                                    z2 = ((dj9.g & k) == 0 && (dj9.i & k) == 0 && (k & dj9.h) == 0) ? false : true;
                                }
                                if (cj9Var.b().mSpeed != 1.0f) {
                                    z = true;
                                }
                                if (MimeTypes.AUDIO_RAW.equals(cj9Var.a().f())) {
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
                jj9 jj9Var = new jj9();
                jj9Var.c(z2 ? 50 : 90);
                jj9Var.e(this);
                this.d.add(jj9Var);
                ij9 ij9Var = new ij9();
                ij9Var.c(z2 ? 50 : 10);
                ij9Var.e(this);
                this.d.add(ij9Var);
                jj9Var.f(ij9Var);
            } else {
                ij9 ij9Var2 = new ij9();
                ij9Var2.c(100);
                ij9Var2.e(this);
                this.d.add(ij9Var2);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final dj9 k(ej9 ej9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, ej9Var)) == null) {
            if (ej9Var != null && sm9.b(ej9Var.c()) == 1 && sm9.b(ej9Var.c().get(0).a()) == 1) {
                cj9 cj9Var = ej9Var.c().get(0).a().get(0);
                if (cj9Var.b() == null || cj9Var.b().isNeedEdit() || !cj9Var.c()) {
                    return null;
                }
                return cj9Var.a();
            }
            return null;
        }
        return (dj9) invokeL.objValue;
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

    public final void o(dj9 dj9Var) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, dj9Var) == null) || (bVar = this.b) == null) {
            return;
        }
        bVar.onAudioMixtureProgress(100);
        this.b.onAudioMixtureSuccess(dj9Var);
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || sm9.e(this.d)) {
            return;
        }
        for (hj9 hj9Var : this.d) {
            hj9Var.h();
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
            dj9 k = k(this.a);
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
