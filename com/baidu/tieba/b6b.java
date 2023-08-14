package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.d6b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class b6b implements d6b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a6b a;
    public b b;
    public Thread c;
    public List<d6b> d;
    public int e;
    public int f;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b6b a;

        public a(b6b b6bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b6bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b6bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b6b b6bVar = this.a;
                if (b6bVar.j(b6bVar.a)) {
                    if (o9b.e(this.a.d)) {
                        this.a.m(" start mix chains error:mMixtureChains empty ");
                        return;
                    } else {
                        ((d6b) this.a.d.get(0)).d(this.a.a);
                        return;
                    }
                }
                b6b b6bVar2 = this.a;
                StringBuilder sb = new StringBuilder();
                sb.append(" start mix chains error:initChainConfig ");
                sb.append(this.a.a == null);
                b6bVar2.m(sb.toString());
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void onAudioMixtureCancel();

        void onAudioMixtureFail(String str);

        void onAudioMixtureProgress(int i);

        void onAudioMixtureSuccess(z5b z5bVar);
    }

    public b6b(a6b a6bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {a6bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = a6bVar;
        this.d = new ArrayList();
    }

    @Override // com.baidu.tieba.d6b.a
    public void a(d6b d6bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, d6bVar) == null) {
            l();
        }
    }

    @Override // com.baidu.tieba.d6b.a
    public void b(d6b d6bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d6bVar) == null) {
            int k = this.e + d6bVar.k();
            this.e = k;
            n(k);
            if (d6bVar == null || !d6bVar.m()) {
                return;
            }
            z5b k2 = k(d6bVar.n());
            if (k2 != null) {
                o(k2);
            } else {
                m("onChainFinished result error");
            }
        }
    }

    @Override // com.baidu.tieba.d6b.a
    public void c(int i, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) || (i3 = (int) (this.e + (((i * 1.0f) / 100.0f) * i2))) <= this.f) {
            return;
        }
        n(i3);
        this.f = i3;
    }

    @Override // com.baidu.tieba.d6b.a
    public void d(String str, d6b d6bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, d6bVar) == null) {
            m(str);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!o9b.e(this.d)) {
                for (d6b d6bVar : this.d) {
                    d6bVar.b();
                }
            }
            Thread thread = this.c;
            if (thread != null) {
                thread.interrupt();
            }
        }
    }

    public final boolean j(a6b a6bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, a6bVar)) == null) {
            if (a6bVar == null || o9b.e(a6bVar.c())) {
                return false;
            }
            List<c6b> c = a6bVar.c();
            z5b z5bVar = null;
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            int i = 0;
            for (int i2 = 0; i2 < c.size(); i2++) {
                if (i6b.o(c.get(i2).b())) {
                    z = true;
                }
                if (!o9b.e(c.get(i2).a())) {
                    for (y5b y5bVar : c.get(i2).a()) {
                        if (y5bVar != null) {
                            if (y5bVar.c()) {
                                if (z5bVar == null) {
                                    z5bVar = y5bVar.a();
                                }
                                if (z5bVar != null) {
                                    int k = z5bVar.k(y5bVar.a());
                                    z2 = ((z5b.g & k) == 0 && (z5b.i & k) == 0 && (k & z5b.h) == 0) ? false : true;
                                }
                                if (y5bVar.b().mSpeed != 1.0f) {
                                    z = true;
                                }
                                if (MimeTypes.AUDIO_RAW.equals(y5bVar.a().f())) {
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
                f6b f6bVar = new f6b();
                f6bVar.c(z2 ? 50 : 90);
                f6bVar.e(this);
                this.d.add(f6bVar);
                e6b e6bVar = new e6b();
                e6bVar.c(z2 ? 50 : 10);
                e6bVar.e(this);
                this.d.add(e6bVar);
                f6bVar.f(e6bVar);
            } else {
                e6b e6bVar2 = new e6b();
                e6bVar2.c(100);
                e6bVar2.e(this);
                this.d.add(e6bVar2);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final z5b k(a6b a6bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, a6bVar)) == null) {
            if (a6bVar != null && o9b.b(a6bVar.c()) == 1 && o9b.b(a6bVar.c().get(0).a()) == 1) {
                y5b y5bVar = a6bVar.c().get(0).a().get(0);
                if (y5bVar.b() == null || y5bVar.b().isNeedEdit() || !y5bVar.c()) {
                    return null;
                }
                return y5bVar.a();
            }
            return null;
        }
        return (z5b) invokeL.objValue;
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

    public final void o(z5b z5bVar) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, z5bVar) == null) || (bVar = this.b) == null) {
            return;
        }
        bVar.onAudioMixtureProgress(100);
        this.b.onAudioMixtureSuccess(z5bVar);
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || o9b.e(this.d)) {
            return;
        }
        for (d6b d6bVar : this.d) {
            d6bVar.h();
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
            z5b k = k(this.a);
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
