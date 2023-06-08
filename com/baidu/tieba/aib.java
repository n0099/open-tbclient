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
public class aib extends thb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public qhb l;
    public qhb m;
    public qhb n;
    public qhb o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public AtomicBoolean t;
    public pib u;
    public zgb v;

    public aib(int i, zgb zgbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), zgbVar};
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
        this.v = zgbVar;
        this.b = i;
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.q = z;
        }
    }

    @Override // com.baidu.tieba.thb, com.baidu.tieba.rhb
    public void f(MediaSample mediaSample) {
        qhb qhbVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, mediaSample) == null) && this.t.get() && (qhbVar = this.l) != null) {
            qhbVar.f(mediaSample);
        }
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.p = z;
        }
    }

    public void B(pib pibVar, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{pibVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.u = pibVar;
            this.s = z2;
            this.r = z;
        }
    }

    @Override // com.baidu.tieba.rhb
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.t.set(true);
        }
    }

    @Override // com.baidu.tieba.thb
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.l = null;
            this.v = null;
            qhb qhbVar = this.m;
            if (qhbVar != null) {
                qhbVar.p();
                this.m = null;
            }
            qhb qhbVar2 = this.n;
            if (qhbVar2 != null) {
                qhbVar2.p();
                this.n = null;
            }
            qhb qhbVar3 = this.o;
            if (qhbVar3 != null) {
                qhbVar3.p();
                this.o = null;
            }
        }
    }

    @Override // com.baidu.tieba.thb
    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.t.set(false);
            qhb qhbVar = this.m;
            if (qhbVar != null) {
                qhbVar.x();
            }
            qhb qhbVar2 = this.n;
            if (qhbVar2 != null) {
                qhbVar2.x();
            }
            qhb qhbVar3 = this.o;
            if (qhbVar3 != null) {
                qhbVar3.x();
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

    @Override // com.baidu.tieba.thb, com.baidu.tieba.rhb
    public void b(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048579, this, i) != null) || !this.t.get()) {
            return;
        }
        TLog.g(this, "H264UseHWDecode :" + this.p + ", H265UseHWDecode :" + this.q + ", netCode:" + i);
        qhb qhbVar = this.l;
        if (2002 == i) {
            if (this.q) {
                if (this.m == null) {
                    this.m = new bib(this.u, this.r, this.s, this.v, this.b);
                    vgb vgbVar = this.g.get();
                    if (vgbVar != null) {
                        this.m.s(vgbVar);
                    }
                }
                this.l = this.m;
                this.v.z(3);
                TLog.g(this, "hw decoder h265");
            } else {
                if (this.o == null) {
                    this.o = new cib(this.v, this.b);
                    vgb vgbVar2 = this.g.get();
                    if (vgbVar2 != null) {
                        this.o.s(vgbVar2);
                    }
                }
                this.l = this.o;
                this.v.z(4);
                TLog.g(this, "ittiam decoder h265");
            }
        } else if (this.p) {
            if (this.m == null) {
                this.m = new bib(this.u, this.r, this.s, this.v, this.b);
                vgb vgbVar3 = this.g.get();
                if (vgbVar3 != null) {
                    this.m.s(vgbVar3);
                }
            }
            this.l = this.m;
            this.v.z(1);
            TLog.g(this, "hw decoder h264");
        } else {
            if (this.n == null) {
                this.n = new dib(this.v, this.b);
                vgb vgbVar4 = this.g.get();
                if (vgbVar4 != null) {
                    this.n.s(vgbVar4);
                }
            }
            this.l = this.n;
            this.v.z(2);
            TLog.g(this, "ffmpeg decoder h264");
        }
        if (qhbVar != null && !qhbVar.equals(this.l)) {
            qhbVar.x();
        }
        qhb qhbVar2 = this.l;
        if (qhbVar2 != null) {
            qhbVar2.r(this.h);
            WeakReference<vgb> weakReference = this.g;
            if (weakReference != null) {
                this.l.s(weakReference.get());
            }
            this.l.t(this.c);
            this.l.q(this.e);
            this.l.k(this.d);
            this.l.a();
        }
    }

    @Override // com.baidu.tieba.thb, com.baidu.tieba.rhb
    public void d(String str, Object obj, int i, boolean z) {
        qhb qhbVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, obj, Integer.valueOf(i), Boolean.valueOf(z)}) == null) && (qhbVar = this.l) != null) {
            qhbVar.d(str, obj, i, z);
        }
    }
}
