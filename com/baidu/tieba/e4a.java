package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.g4a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class e4a implements g4a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d4a a;
    public b b;
    public Thread c;
    public List<g4a> d;
    public int e;
    public int f;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e4a a;

        public a(e4a e4aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e4aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e4aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                e4a e4aVar = this.a;
                if (e4aVar.j(e4aVar.a)) {
                    if (r7a.e(this.a.d)) {
                        this.a.m(" start mix chains error:mMixtureChains empty ");
                        return;
                    } else {
                        ((g4a) this.a.d.get(0)).d(this.a.a);
                        return;
                    }
                }
                e4a e4aVar2 = this.a;
                StringBuilder sb = new StringBuilder();
                sb.append(" start mix chains error:initChainConfig ");
                sb.append(this.a.a == null);
                e4aVar2.m(sb.toString());
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void onAudioMixtureCancel();

        void onAudioMixtureFail(String str);

        void onAudioMixtureProgress(int i);

        void onAudioMixtureSuccess(c4a c4aVar);
    }

    public e4a(d4a d4aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d4aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = d4aVar;
        this.d = new ArrayList();
    }

    @Override // com.baidu.tieba.g4a.a
    public void a(g4a g4aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, g4aVar) == null) {
            l();
        }
    }

    @Override // com.baidu.tieba.g4a.a
    public void b(g4a g4aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, g4aVar) == null) {
            int k = this.e + g4aVar.k();
            this.e = k;
            n(k);
            if (g4aVar == null || !g4aVar.m()) {
                return;
            }
            c4a k2 = k(g4aVar.n());
            if (k2 != null) {
                o(k2);
            } else {
                m("onChainFinished result error");
            }
        }
    }

    @Override // com.baidu.tieba.g4a.a
    public void c(int i, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) || (i3 = (int) (this.e + (((i * 1.0f) / 100.0f) * i2))) <= this.f) {
            return;
        }
        n(i3);
        this.f = i3;
    }

    @Override // com.baidu.tieba.g4a.a
    public void d(String str, g4a g4aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, g4aVar) == null) {
            m(str);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!r7a.e(this.d)) {
                for (g4a g4aVar : this.d) {
                    g4aVar.b();
                }
            }
            Thread thread = this.c;
            if (thread != null) {
                thread.interrupt();
            }
        }
    }

    public final boolean j(d4a d4aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, d4aVar)) == null) {
            if (d4aVar == null || r7a.e(d4aVar.c())) {
                return false;
            }
            List<f4a> c = d4aVar.c();
            c4a c4aVar = null;
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            int i = 0;
            for (int i2 = 0; i2 < c.size(); i2++) {
                if (l4a.o(c.get(i2).b())) {
                    z = true;
                }
                if (!r7a.e(c.get(i2).a())) {
                    for (b4a b4aVar : c.get(i2).a()) {
                        if (b4aVar != null) {
                            if (b4aVar.c()) {
                                if (c4aVar == null) {
                                    c4aVar = b4aVar.a();
                                }
                                if (c4aVar != null) {
                                    int k = c4aVar.k(b4aVar.a());
                                    z2 = ((c4a.g & k) == 0 && (c4a.i & k) == 0 && (k & c4a.h) == 0) ? false : true;
                                }
                                if (b4aVar.b().mSpeed != 1.0f) {
                                    z = true;
                                }
                                if (MimeTypes.AUDIO_RAW.equals(b4aVar.a().f())) {
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
                i4a i4aVar = new i4a();
                i4aVar.c(z2 ? 50 : 90);
                i4aVar.e(this);
                this.d.add(i4aVar);
                h4a h4aVar = new h4a();
                h4aVar.c(z2 ? 50 : 10);
                h4aVar.e(this);
                this.d.add(h4aVar);
                i4aVar.f(h4aVar);
            } else {
                h4a h4aVar2 = new h4a();
                h4aVar2.c(100);
                h4aVar2.e(this);
                this.d.add(h4aVar2);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final c4a k(d4a d4aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, d4aVar)) == null) {
            if (d4aVar != null && r7a.b(d4aVar.c()) == 1 && r7a.b(d4aVar.c().get(0).a()) == 1) {
                b4a b4aVar = d4aVar.c().get(0).a().get(0);
                if (b4aVar.b() == null || b4aVar.b().isNeedEdit() || !b4aVar.c()) {
                    return null;
                }
                return b4aVar.a();
            }
            return null;
        }
        return (c4a) invokeL.objValue;
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

    public final void o(c4a c4aVar) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, c4aVar) == null) || (bVar = this.b) == null) {
            return;
        }
        bVar.onAudioMixtureProgress(100);
        this.b.onAudioMixtureSuccess(c4aVar);
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || r7a.e(this.d)) {
            return;
        }
        for (g4a g4aVar : this.d) {
            g4aVar.h();
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
            c4a k = k(this.a);
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
