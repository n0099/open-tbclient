package com.baidu.tieba;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.j1c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.transvod.player.common.MixAudioExtraInfo;
import com.yy.transvod.player.log.TLog;
import com.yy.transvod.preference.Preference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
/* loaded from: classes5.dex */
public class e1c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public g2c a;
    public j0c b;
    public int c;
    public boolean d;
    public boolean e;
    public WeakReference<x0c> f;
    public j1c.a g;
    public final List<WeakReference<q0c>> h;
    public final q0c i;

    /* loaded from: classes5.dex */
    public interface d {
        void a(Bitmap bitmap);
    }

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? "12.1.0.34" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class a implements j1c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public final /* synthetic */ e1c b;

        public a(e1c e1cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e1cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = e1cVar;
            this.a = 0L;
        }

        @Override // com.baidu.tieba.j1c.a
        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                synchronized (this) {
                    if (j <= this.a) {
                        return;
                    }
                    this.a = j;
                    if (this.b.a != null) {
                        this.b.a.e();
                    }
                }
            }
        }

        @Override // com.baidu.tieba.j1c.a
        public void b(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                synchronized (this) {
                    if (j <= this.a) {
                        return;
                    }
                    this.a = j;
                    if (this.b.a != null) {
                        this.b.a.f();
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements q0c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e1c a;

        public b(e1c e1cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e1cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e1cVar;
        }

        @Override // com.baidu.tieba.q0c
        public void onPlayerFirstVideoFrameShow(e1c e1cVar, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLIII(1048576, this, e1cVar, i, i2, i3) != null) {
                return;
            }
            synchronized (this.a.h) {
                for (WeakReference weakReference : this.a.h) {
                    q0c q0cVar = (q0c) weakReference.get();
                    if (q0cVar != null) {
                        TLog.g(this, "ff notify " + q0cVar);
                        q0cVar.onPlayerFirstVideoFrameShow(e1cVar, i, i2, i3);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static abstract class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public void a(e1c e1cVar, ArrayList<MixAudioExtraInfo> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, e1cVar, arrayList) == null) {
            }
        }

        public c() {
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
    }

    public e1c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.d = false;
        this.e = false;
        this.f = new WeakReference<>(null);
        this.g = new a(this);
        this.h = new ArrayList();
        this.i = new b(this);
    }

    public int G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            TLog.g(this, "start");
            if (this.b == null) {
                TLog.g(this, "start mDataSource is null!");
                return -1;
            }
            this.d = true;
            if (this.e) {
                TLog.g(this, "player start and update DataSource");
                t(this.b);
                this.e = false;
            }
            this.c = (int) this.b.j();
            this.a.F(this.c, e0c.a());
            return this.c;
        }
        return invokeV.intValue;
    }

    public e1c(Context context, d1c d1cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, d1cVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.d = false;
        this.e = false;
        this.f = new WeakReference<>(null);
        this.g = new a(this);
        this.h = new ArrayList();
        this.i = new b(this);
        if (e2c.x(context)) {
            new WeakReference(context);
            b0c.a(context);
            b0c.b(context);
            if (Preference.f()) {
                d1cVar.m = Preference.g();
                TLog.h("[VodPlayer]", "global process config enabled, globalSubprocess=" + d1cVar.m);
            }
            if (d1cVar.m && Preference.h()) {
                d1cVar.m = false;
                TLog.h("[VodPlayer]", "subprocess fail over to main process, so set subprocess as false");
            }
            if (d1cVar.m && !k4c.n().r()) {
                TLog.h("[VodPlayer]", "subprocess is not support in current devices!!");
                d1cVar.m = false;
            }
            if (d1cVar.m && !k4c.n().o(context.getApplicationContext())) {
                TLog.h("[VodPlayer]", "subprocess fail as initSubProcess fail!!");
                d1cVar.m = false;
            }
            if (d1cVar.m && !k4c.n().q()) {
                TLog.h("[VodPlayer]", "initSubProcess but subProcess is not connected, VodPlayer force start in main process !!!");
                d1cVar.m = false;
            }
            TLog.h("[VodPlayer]", d1cVar.toString());
            if (d1cVar.m) {
                i2c i2cVar = new i2c(context.getApplicationContext(), d1cVar, this);
                this.a = i2cVar;
                c1c.a(i2cVar);
            } else {
                this.a = new h2c(context.getApplicationContext(), d1cVar, this);
            }
            j1c.b(this.g);
            TLog.g(this, "VodPlayer, subprocess: " + d1cVar.m + ", vodplayer version : " + h());
            return;
        }
        throw new RuntimeException("dynamic load so enabled, make sure isLibReady returns true or onLibDownloadSuccess!");
    }

    public static boolean l(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            return e2c.x(context);
        }
        return invokeL.booleanValue;
    }

    public static void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65543, null, z) == null) {
            TLog.h("AudioFocus", " setAudioFocusEnable:" + z);
            c1c.b(z);
        }
    }

    public void B(r0c r0cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, r0cVar) == null) {
            this.a.A(r0cVar);
        }
    }

    public void C(w0c w0cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, w0cVar) == null) {
            this.a.B(w0cVar);
        }
    }

    public void D(x0c x0cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, x0cVar) == null) {
            this.a.C(x0cVar);
            this.f = new WeakReference<>(x0cVar);
        }
    }

    public void E(y0c y0cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, y0cVar) == null) {
            this.a.D(y0cVar);
        }
    }

    public void F(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.a.E(i);
        }
    }

    public void r(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048597, this, j) == null) {
            this.a.r(j);
        }
    }

    public void t(j0c j0cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, j0cVar) == null) {
            j0cVar.p(0L);
            this.a.s(j0cVar);
            this.b = j0cVar;
        }
    }

    public void v(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            this.a.u(i);
        }
    }

    public void w(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            this.a.v(i);
        }
    }

    public void y(m0c m0cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, m0cVar) == null) {
            this.a.x(m0cVar);
        }
    }

    public void z(o0c o0cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, o0cVar) == null) {
            this.a.y(o0cVar);
        }
    }

    public static void k(Context context, u1c u1cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, context, u1cVar) == null) {
            e2c.r(context, null, u1cVar, null);
        }
    }

    public void q(Executor executor, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, executor, dVar) == null) {
            this.a.q(executor, dVar);
        }
    }

    public void x(Executor executor, l0c l0cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, executor, l0cVar) == null) {
            this.a.w(executor, l0cVar);
        }
    }

    public void A(q0c q0cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, q0cVar) == null) {
            TLog.g(this, " OnPlayerFirstVideoFrameShowListener:" + q0cVar);
            synchronized (this.h) {
                if (q0cVar == null) {
                    this.h.clear();
                    return;
                }
                for (WeakReference<q0c> weakReference : this.h) {
                    if (weakReference.get() == q0cVar) {
                        TLog.g(this, " OnPlayerFirstVideoFrameShowListener dup:" + q0cVar);
                        return;
                    }
                }
                this.h.add(new WeakReference<>(q0cVar));
                this.a.z(this.i);
            }
        }
    }

    public void u(j0c j0cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, j0cVar) == null) {
            if (j0cVar == null) {
                TLog.g(this, "DataSource is null");
                return;
            }
            j0c j0cVar2 = this.b;
            if (j0cVar2 != null && TextUtils.equals(j0cVar2.k(), j0cVar.k())) {
                TLog.g(this, "setDataSourceAndPrepare pre taskid:" + this.b.j() + " cur taskId:" + j0cVar.j());
                j0cVar.q(this.b.j());
            }
            j0cVar.p(e0c.a());
            j0cVar.m(false);
            this.b = j0cVar;
            if (!this.d) {
                this.a.t(j0cVar);
                return;
            }
            TLog.g(this, "player has already started, need update DataSource when next start");
            this.e = true;
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.d = false;
            this.e = false;
            this.a.G();
        }
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.a.g();
        }
        return invokeV.longValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.c;
        }
        return invokeV.intValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.a.h();
        }
        return invokeV.longValue;
    }

    public x0c f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.f.get();
        }
        return (x0c) invokeV.objValue;
    }

    public void finalize() throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.finalize();
        }
    }

    public Object g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.a.i();
        }
        return invokeV.objValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.a.k();
        }
        return invokeV.intValue;
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.a.l();
        }
        return invokeV.intValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.a.m();
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.a.n();
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.a.o();
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.a.p();
        }
    }
}
