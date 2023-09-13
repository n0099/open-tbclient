package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.transvod.player.log.TLog;
import com.yy.transvod.player.mediacodec.MediaSample;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class f6c extends y5c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public v5c l;
    public v5c m;
    public v5c n;
    public v5c o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public AtomicBoolean t;
    public u6c u;
    public e5c v;

    public f6c(int i, e5c e5cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), e5cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = false;
        this.q = false;
        this.r = false;
        this.s = false;
        this.t = new AtomicBoolean(false);
        this.v = null;
        this.v = e5cVar;
        this.b = i;
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.q = z;
        }
    }

    @Override // com.baidu.tieba.y5c, com.baidu.tieba.w5c
    public void f(MediaSample mediaSample) {
        v5c v5cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, mediaSample) == null) && this.t.get() && (v5cVar = this.l) != null) {
            v5cVar.f(mediaSample);
        }
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.p = z;
        }
    }

    public void B(u6c u6cVar, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{u6cVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.u = u6cVar;
            this.s = z2;
            this.r = z;
        }
    }

    @Override // com.baidu.tieba.w5c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.t.set(true);
        }
    }

    @Override // com.baidu.tieba.y5c
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.l = null;
            this.v = null;
            v5c v5cVar = this.m;
            if (v5cVar != null) {
                v5cVar.p();
                this.m = null;
            }
            v5c v5cVar2 = this.n;
            if (v5cVar2 != null) {
                v5cVar2.p();
                this.n = null;
            }
            v5c v5cVar3 = this.o;
            if (v5cVar3 != null) {
                v5cVar3.p();
                this.o = null;
            }
        }
    }

    @Override // com.baidu.tieba.y5c
    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.t.set(false);
            v5c v5cVar = this.m;
            if (v5cVar != null) {
                v5cVar.x();
            }
            v5c v5cVar2 = this.n;
            if (v5cVar2 != null) {
                v5cVar2.x();
            }
            v5c v5cVar3 = this.o;
            if (v5cVar3 != null) {
                v5cVar3.x();
            }
            TLog.g(this, "VideoDecodeFilter stop");
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.p = false;
            this.q = false;
        }
    }

    @Override // com.baidu.tieba.y5c, com.baidu.tieba.w5c
    public void b(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048579, this, i) != null) || !this.t.get()) {
            return;
        }
        TLog.g(this, "H264UseHWDecode :" + this.p + ", H265UseHWDecode :" + this.q + ", netCode:" + i);
        v5c v5cVar = this.l;
        if (2002 == i) {
            if (this.q) {
                if (this.m == null) {
                    this.m = new g6c(this.u, this.r, this.s, this.v, this.b);
                    a5c a5cVar = this.g.get();
                    if (a5cVar != null) {
                        this.m.s(a5cVar);
                    }
                }
                this.l = this.m;
                this.v.z(3);
                TLog.g(this, "hw decoder h265");
            } else {
                if (this.o == null) {
                    this.o = new h6c(this.v, this.b);
                    a5c a5cVar2 = this.g.get();
                    if (a5cVar2 != null) {
                        this.o.s(a5cVar2);
                    }
                }
                this.l = this.o;
                this.v.z(4);
                TLog.g(this, "ittiam decoder h265");
            }
        } else if (this.p) {
            if (this.m == null) {
                this.m = new g6c(this.u, this.r, this.s, this.v, this.b);
                a5c a5cVar3 = this.g.get();
                if (a5cVar3 != null) {
                    this.m.s(a5cVar3);
                }
            }
            this.l = this.m;
            this.v.z(1);
            TLog.g(this, "hw decoder h264");
        } else {
            if (this.n == null) {
                this.n = new i6c(this.v, this.b);
                a5c a5cVar4 = this.g.get();
                if (a5cVar4 != null) {
                    this.n.s(a5cVar4);
                }
            }
            this.l = this.n;
            this.v.z(2);
            TLog.g(this, "ffmpeg decoder h264");
        }
        if (v5cVar != null && !v5cVar.equals(this.l)) {
            v5cVar.x();
        }
        v5c v5cVar2 = this.l;
        if (v5cVar2 != null) {
            v5cVar2.r(this.h);
            WeakReference<a5c> weakReference = this.g;
            if (weakReference != null) {
                this.l.s(weakReference.get());
            }
            this.l.t(this.c);
            this.l.q(this.e);
            this.l.k(this.d);
            this.l.a();
        }
    }

    @Override // com.baidu.tieba.y5c, com.baidu.tieba.w5c
    public void d(String str, Object obj, int i, boolean z) {
        v5c v5cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, obj, Integer.valueOf(i), Boolean.valueOf(z)}) == null) && (v5cVar = this.l) != null) {
            v5cVar.d(str, obj, i, z);
        }
    }
}
