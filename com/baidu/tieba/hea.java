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
/* loaded from: classes4.dex */
public class hea extends fea {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public rea h;
    public int i;
    public int j;

    /* loaded from: classes4.dex */
    public class a extends gga {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ AudioPlayData c;
        public final /* synthetic */ aea d;
        public final /* synthetic */ hea e;

        public a(hea heaVar, String str, int i, AudioPlayData audioPlayData, aea aeaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {heaVar, str, Integer.valueOf(i), audioPlayData, aeaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = heaVar;
            this.a = str;
            this.b = i;
            this.c = audioPlayData;
            this.d = aeaVar;
        }

        @Override // com.baidu.tieba.gga, com.baidu.tieba.fga
        public void onExceptionThrown(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.e.h.cancel();
                AudioPlayData audioPlayData = this.c;
                if (audioPlayData.mSpeed != 1.0f || kea.o(audioPlayData.mSoundTypes)) {
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

        @Override // com.baidu.tieba.gga
        public void onFinishedWriting(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (z) {
                    this.e.q(new aea(new AudioPlayData(this.a, 0, -1, 1.0f)), this.b);
                }
                synchronized (this.e) {
                    this.e.notifyAll();
                }
            }
        }

        @Override // com.baidu.tieba.gga, com.baidu.tieba.fga
        public void onProgressChanged(int i, double d, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Double.valueOf(d), Long.valueOf(j)}) == null) {
                hea heaVar = this.e;
                heaVar.i((int) (((((heaVar.j - 1) + d) * 1.0d) / this.e.i) * 100.0d));
            }
        }
    }

    public hea() {
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

    @Override // com.baidu.tieba.fea
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f = true;
            rea reaVar = this.h;
            if (reaVar != null) {
                reaVar.cancel();
            }
            synchronized (this) {
                notifyAll();
            }
            o();
        }
    }

    @Override // com.baidu.tieba.fea
    public void d(cea ceaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ceaVar) == null) {
            if (ceaVar == null || qha.e(ceaVar.c())) {
                g("input data error: null or length=0");
            } else if (!j(ceaVar)) {
                l(ceaVar);
            } else {
                String a2 = ceaVar.a();
                this.g = a2;
                if (!TextUtils.isEmpty(a2) && !FileUtils.isExists(this.g)) {
                    new File(this.g).mkdir();
                }
                this.e = false;
                this.f = false;
                y(ceaVar);
                x(ceaVar);
                List<eea> c = ceaVar.c();
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

    @Override // com.baidu.tieba.fea
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            rea reaVar = this.h;
            if (reaVar != null) {
                reaVar.J();
            }
            synchronized (this) {
                notifyAll();
            }
        }
    }

    public final void q(aea aeaVar, int i) {
        cea ceaVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, aeaVar, i) == null) || (ceaVar = this.d) == null || ceaVar.c() == null || this.d.c().get(i) == null) {
            return;
        }
        this.d.c().get(i).a().add(aeaVar);
    }

    public final void r(eea eeaVar, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, eeaVar, i) == null) || eeaVar == null || qha.e(eeaVar.a()) || this.f || this.e) {
            return;
        }
        for (aea aeaVar : eeaVar.a()) {
            if (this.e || this.f) {
                return;
            }
            this.j++;
            if (t(aeaVar)) {
                v(aeaVar, i);
            } else {
                q(aeaVar, i);
                i((int) (((this.j * 1.0f) / this.i) * 100.0f));
            }
        }
    }

    public final boolean t(aea aeaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, aeaVar)) == null) {
            if (aeaVar == null || aeaVar.b() == null || !aeaVar.c()) {
                return false;
            }
            if (!kea.o(aeaVar.b().mSoundTypes) && aeaVar.b().mSpeed == 1.0f && aeaVar.b().start == 0 && aeaVar.b().end == -1 && aeaVar.b().volume == 1.0f) {
                return (aeaVar.a() == null || "audio/mp4a-latm".equals(aeaVar.a().f())) ? false : true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void v(aea aeaVar, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, aeaVar, i) == null) || this.f || this.e) {
            return;
        }
        AudioPlayData b = aeaVar.b();
        if (b == null || !FileUtils.isExists(b.audioPath)) {
            g("dealAudioPlayData,trackIndx:inputerror");
            return;
        }
        String str = b.audioPath;
        String a2 = a(str, System.currentTimeMillis() + "_mediacodec.aac");
        try {
            rea reaVar = new rea(b.audioPath, a2, b.mSoundTypes);
            this.h = reaVar;
            reaVar.S(new a(this, a2, i, b, aeaVar));
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
            g("dealAudioPlayData exception:" + vha.g(e));
            e.printStackTrace();
        }
    }

    public final void x(cea ceaVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, ceaVar) == null) || ceaVar == null || qha.e(ceaVar.c())) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < ceaVar.c().size(); i++) {
            arrayList.add(new eea(new ArrayList()));
        }
        cea ceaVar2 = new cea(arrayList);
        this.d = ceaVar2;
        ceaVar2.e(ceaVar.b());
        this.d.d(ceaVar.a());
    }

    public final void y(cea ceaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ceaVar) == null) {
            this.i = 0;
            this.j = 0;
            List<eea> c = ceaVar.c();
            int size = c.size();
            for (int i = 0; i < size; i++) {
                if (c.get(i) != null && c.get(i).a() != null) {
                    this.i += c.get(i).a().size();
                }
            }
        }
    }
}
