package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.cfb;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class afb implements cfb.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public zeb a;
    public b b;
    public Thread c;
    public List<cfb> d;
    public int e;
    public int f;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ afb a;

        public a(afb afbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {afbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = afbVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                afb afbVar = this.a;
                if (afbVar.j(afbVar.a)) {
                    if (nib.e(this.a.d)) {
                        this.a.m(" start mix chains error:mMixtureChains empty ");
                        return;
                    } else {
                        ((cfb) this.a.d.get(0)).d(this.a.a);
                        return;
                    }
                }
                afb afbVar2 = this.a;
                StringBuilder sb = new StringBuilder();
                sb.append(" start mix chains error:initChainConfig ");
                sb.append(this.a.a == null);
                afbVar2.m(sb.toString());
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void onAudioMixtureCancel();

        void onAudioMixtureFail(String str);

        void onAudioMixtureProgress(int i);

        void onAudioMixtureSuccess(yeb yebVar);
    }

    public afb(zeb zebVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zebVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = zebVar;
        this.d = new ArrayList();
    }

    @Override // com.baidu.tieba.cfb.a
    public void a(cfb cfbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cfbVar) == null) {
            l();
        }
    }

    @Override // com.baidu.tieba.cfb.a
    public void b(cfb cfbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cfbVar) == null) {
            int k = this.e + cfbVar.k();
            this.e = k;
            n(k);
            if (cfbVar == null || !cfbVar.m()) {
                return;
            }
            yeb k2 = k(cfbVar.n());
            if (k2 != null) {
                o(k2);
            } else {
                m("onChainFinished result error");
            }
        }
    }

    @Override // com.baidu.tieba.cfb.a
    public void c(int i, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) || (i3 = (int) (this.e + (((i * 1.0f) / 100.0f) * i2))) <= this.f) {
            return;
        }
        n(i3);
        this.f = i3;
    }

    @Override // com.baidu.tieba.cfb.a
    public void d(String str, cfb cfbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, cfbVar) == null) {
            m(str);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!nib.e(this.d)) {
                for (cfb cfbVar : this.d) {
                    cfbVar.b();
                }
            }
            Thread thread = this.c;
            if (thread != null) {
                thread.interrupt();
            }
        }
    }

    public final boolean j(zeb zebVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, zebVar)) == null) {
            if (zebVar == null || nib.e(zebVar.c())) {
                return false;
            }
            List<bfb> c = zebVar.c();
            yeb yebVar = null;
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            int i = 0;
            for (int i2 = 0; i2 < c.size(); i2++) {
                if (hfb.o(c.get(i2).b())) {
                    z = true;
                }
                if (!nib.e(c.get(i2).a())) {
                    for (xeb xebVar : c.get(i2).a()) {
                        if (xebVar != null) {
                            if (xebVar.c()) {
                                if (yebVar == null) {
                                    yebVar = xebVar.a();
                                }
                                if (yebVar != null) {
                                    int k = yebVar.k(xebVar.a());
                                    z2 = ((yeb.g & k) == 0 && (yeb.i & k) == 0 && (k & yeb.h) == 0) ? false : true;
                                }
                                if (xebVar.b().mSpeed != 1.0f) {
                                    z = true;
                                }
                                if (MimeTypes.AUDIO_RAW.equals(xebVar.a().f())) {
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
                efb efbVar = new efb();
                efbVar.c(z2 ? 50 : 90);
                efbVar.e(this);
                this.d.add(efbVar);
                dfb dfbVar = new dfb();
                dfbVar.c(z2 ? 50 : 10);
                dfbVar.e(this);
                this.d.add(dfbVar);
                efbVar.f(dfbVar);
            } else {
                dfb dfbVar2 = new dfb();
                dfbVar2.c(100);
                dfbVar2.e(this);
                this.d.add(dfbVar2);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final yeb k(zeb zebVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, zebVar)) == null) {
            if (zebVar != null && nib.b(zebVar.c()) == 1 && nib.b(zebVar.c().get(0).a()) == 1) {
                xeb xebVar = zebVar.c().get(0).a().get(0);
                if (xebVar.b() == null || xebVar.b().isNeedEdit() || !xebVar.c()) {
                    return null;
                }
                return xebVar.a();
            }
            return null;
        }
        return (yeb) invokeL.objValue;
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

    public final void o(yeb yebVar) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, yebVar) == null) || (bVar = this.b) == null) {
            return;
        }
        bVar.onAudioMixtureProgress(100);
        this.b.onAudioMixtureSuccess(yebVar);
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || nib.e(this.d)) {
            return;
        }
        for (cfb cfbVar : this.d) {
            cfbVar.h();
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
            yeb k = k(this.a);
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
