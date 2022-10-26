package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ce9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class ae9 implements ce9.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public zd9 a;
    public b b;
    public Thread c;
    public List<ce9> d;
    public int e;
    public int f;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ae9 a;

        public a(ae9 ae9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ae9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ae9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ae9 ae9Var = this.a;
                if (ae9Var.j(ae9Var.a)) {
                    if (nh9.e(this.a.d)) {
                        this.a.m(" start mix chains error:mMixtureChains empty ");
                        return;
                    } else {
                        ((ce9) this.a.d.get(0)).d(this.a.a);
                        return;
                    }
                }
                ae9 ae9Var2 = this.a;
                StringBuilder sb = new StringBuilder();
                sb.append(" start mix chains error:initChainConfig ");
                sb.append(this.a.a == null);
                ae9Var2.m(sb.toString());
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void onAudioMixtureCancel();

        void onAudioMixtureFail(String str);

        void onAudioMixtureProgress(int i);

        void onAudioMixtureSuccess(yd9 yd9Var);
    }

    public ae9(zd9 zd9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zd9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = zd9Var;
        this.d = new ArrayList();
    }

    @Override // com.baidu.tieba.ce9.a
    public void a(ce9 ce9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ce9Var) == null) {
            l();
        }
    }

    @Override // com.baidu.tieba.ce9.a
    public void b(ce9 ce9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ce9Var) == null) {
            int k = this.e + ce9Var.k();
            this.e = k;
            n(k);
            if (ce9Var == null || !ce9Var.m()) {
                return;
            }
            yd9 k2 = k(ce9Var.n());
            if (k2 != null) {
                o(k2);
            } else {
                m("onChainFinished result error");
            }
        }
    }

    @Override // com.baidu.tieba.ce9.a
    public void c(int i, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) || (i3 = (int) (this.e + (((i * 1.0f) / 100.0f) * i2))) <= this.f) {
            return;
        }
        n(i3);
        this.f = i3;
    }

    @Override // com.baidu.tieba.ce9.a
    public void d(String str, ce9 ce9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, ce9Var) == null) {
            m(str);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!nh9.e(this.d)) {
                for (ce9 ce9Var : this.d) {
                    ce9Var.b();
                }
            }
            Thread thread = this.c;
            if (thread != null) {
                thread.interrupt();
            }
        }
    }

    public final boolean j(zd9 zd9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, zd9Var)) == null) {
            if (zd9Var == null || nh9.e(zd9Var.c())) {
                return false;
            }
            List<be9> c = zd9Var.c();
            yd9 yd9Var = null;
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            int i = 0;
            for (int i2 = 0; i2 < c.size(); i2++) {
                if (he9.o(c.get(i2).b())) {
                    z = true;
                }
                if (!nh9.e(c.get(i2).a())) {
                    for (xd9 xd9Var : c.get(i2).a()) {
                        if (xd9Var != null) {
                            if (xd9Var.c()) {
                                if (yd9Var == null) {
                                    yd9Var = xd9Var.a();
                                }
                                if (yd9Var != null) {
                                    int k = yd9Var.k(xd9Var.a());
                                    z2 = ((yd9.g & k) == 0 && (yd9.i & k) == 0 && (k & yd9.h) == 0) ? false : true;
                                }
                                if (xd9Var.b().mSpeed != 1.0f) {
                                    z = true;
                                }
                                if (MimeTypes.AUDIO_RAW.equals(xd9Var.a().f())) {
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
                ee9 ee9Var = new ee9();
                ee9Var.c(z2 ? 50 : 90);
                ee9Var.e(this);
                this.d.add(ee9Var);
                de9 de9Var = new de9();
                de9Var.c(z2 ? 50 : 10);
                de9Var.e(this);
                this.d.add(de9Var);
                ee9Var.f(de9Var);
            } else {
                de9 de9Var2 = new de9();
                de9Var2.c(100);
                de9Var2.e(this);
                this.d.add(de9Var2);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final yd9 k(zd9 zd9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, zd9Var)) == null) {
            if (zd9Var != null && nh9.b(zd9Var.c()) == 1 && nh9.b(zd9Var.c().get(0).a()) == 1) {
                xd9 xd9Var = zd9Var.c().get(0).a().get(0);
                if (xd9Var.b() == null || xd9Var.b().isNeedEdit() || !xd9Var.c()) {
                    return null;
                }
                return xd9Var.a();
            }
            return null;
        }
        return (yd9) invokeL.objValue;
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

    public final void o(yd9 yd9Var) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, yd9Var) == null) || (bVar = this.b) == null) {
            return;
        }
        bVar.onAudioMixtureProgress(100);
        this.b.onAudioMixtureSuccess(yd9Var);
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || nh9.e(this.d)) {
            return;
        }
        for (ce9 ce9Var : this.d) {
            ce9Var.h();
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
            yd9 k = k(this.a);
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
