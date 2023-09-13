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
/* loaded from: classes5.dex */
public class efb extends cfb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ofb h;
    public int i;
    public int j;

    /* loaded from: classes5.dex */
    public class a extends dhb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ AudioPlayData c;
        public final /* synthetic */ xeb d;
        public final /* synthetic */ efb e;

        public a(efb efbVar, String str, int i, AudioPlayData audioPlayData, xeb xebVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {efbVar, str, Integer.valueOf(i), audioPlayData, xebVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = efbVar;
            this.a = str;
            this.b = i;
            this.c = audioPlayData;
            this.d = xebVar;
        }

        @Override // com.baidu.tieba.dhb, com.baidu.tieba.chb
        public void onExceptionThrown(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.e.h.cancel();
                AudioPlayData audioPlayData = this.c;
                if (audioPlayData.mSpeed != 1.0f || hfb.o(audioPlayData.mSoundTypes)) {
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

        @Override // com.baidu.tieba.dhb
        public void onFinishedWriting(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (z) {
                    this.e.q(new xeb(new AudioPlayData(this.a, 0, -1, 1.0f)), this.b);
                }
                synchronized (this.e) {
                    this.e.notifyAll();
                }
            }
        }

        @Override // com.baidu.tieba.dhb, com.baidu.tieba.chb
        public void onProgressChanged(int i, double d, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Double.valueOf(d), Long.valueOf(j)}) == null) {
                efb efbVar = this.e;
                efbVar.i((int) (((((efbVar.j - 1) + d) * 1.0d) / this.e.i) * 100.0d));
            }
        }
    }

    public efb() {
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

    @Override // com.baidu.tieba.cfb
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f = true;
            ofb ofbVar = this.h;
            if (ofbVar != null) {
                ofbVar.cancel();
            }
            synchronized (this) {
                notifyAll();
            }
            o();
        }
    }

    @Override // com.baidu.tieba.cfb
    public void d(zeb zebVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zebVar) == null) {
            if (zebVar == null || nib.e(zebVar.c())) {
                g("input data error: null or length=0");
            } else if (!j(zebVar)) {
                l(zebVar);
            } else {
                String a2 = zebVar.a();
                this.g = a2;
                if (!TextUtils.isEmpty(a2) && !FileUtils.isExists(this.g)) {
                    new File(this.g).mkdir();
                }
                this.e = false;
                this.f = false;
                y(zebVar);
                x(zebVar);
                List<bfb> c = zebVar.c();
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

    @Override // com.baidu.tieba.cfb
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ofb ofbVar = this.h;
            if (ofbVar != null) {
                ofbVar.J();
            }
            synchronized (this) {
                notifyAll();
            }
        }
    }

    public final void q(xeb xebVar, int i) {
        zeb zebVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, xebVar, i) == null) || (zebVar = this.d) == null || zebVar.c() == null || this.d.c().get(i) == null) {
            return;
        }
        this.d.c().get(i).a().add(xebVar);
    }

    public final void r(bfb bfbVar, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, bfbVar, i) == null) || bfbVar == null || nib.e(bfbVar.a()) || this.f || this.e) {
            return;
        }
        for (xeb xebVar : bfbVar.a()) {
            if (this.e || this.f) {
                return;
            }
            this.j++;
            if (t(xebVar)) {
                v(xebVar, i);
            } else {
                q(xebVar, i);
                i((int) (((this.j * 1.0f) / this.i) * 100.0f));
            }
        }
    }

    public final boolean t(xeb xebVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, xebVar)) == null) {
            if (xebVar == null || xebVar.b() == null || !xebVar.c()) {
                return false;
            }
            if (!hfb.o(xebVar.b().mSoundTypes) && xebVar.b().mSpeed == 1.0f && xebVar.b().start == 0 && xebVar.b().end == -1 && xebVar.b().volume == 1.0f) {
                return (xebVar.a() == null || "audio/mp4a-latm".equals(xebVar.a().f())) ? false : true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void v(xeb xebVar, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, xebVar, i) == null) || this.f || this.e) {
            return;
        }
        AudioPlayData b = xebVar.b();
        if (b == null || !FileUtils.isExists(b.audioPath)) {
            g("dealAudioPlayData,trackIndx:inputerror");
            return;
        }
        String str = b.audioPath;
        String a2 = a(str, System.currentTimeMillis() + "_mediacodec.aac");
        try {
            ofb ofbVar = new ofb(b.audioPath, a2, b.mSoundTypes);
            this.h = ofbVar;
            ofbVar.S(new a(this, a2, i, b, xebVar));
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
            g("dealAudioPlayData exception:" + sib.g(e));
            e.printStackTrace();
        }
    }

    public final void x(zeb zebVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, zebVar) == null) || zebVar == null || nib.e(zebVar.c())) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < zebVar.c().size(); i++) {
            arrayList.add(new bfb(new ArrayList()));
        }
        zeb zebVar2 = new zeb(arrayList);
        this.d = zebVar2;
        zebVar2.e(zebVar.b());
        this.d.d(zebVar.a());
    }

    public final void y(zeb zebVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, zebVar) == null) {
            this.i = 0;
            this.j = 0;
            List<bfb> c = zebVar.c();
            int size = c.size();
            for (int i = 0; i < size; i++) {
                if (c.get(i) != null && c.get(i).a() != null) {
                    this.i += c.get(i).a().size();
                }
            }
        }
    }
}
