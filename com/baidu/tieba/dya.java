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
public class dya extends bya {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public nya h;
    public int i;
    public int j;

    /* loaded from: classes5.dex */
    public class a extends c0b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ AudioPlayData c;
        public final /* synthetic */ wxa d;
        public final /* synthetic */ dya e;

        public a(dya dyaVar, String str, int i, AudioPlayData audioPlayData, wxa wxaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dyaVar, str, Integer.valueOf(i), audioPlayData, wxaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = dyaVar;
            this.a = str;
            this.b = i;
            this.c = audioPlayData;
            this.d = wxaVar;
        }

        @Override // com.baidu.tieba.c0b, com.baidu.tieba.b0b
        public void onExceptionThrown(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.e.h.cancel();
                AudioPlayData audioPlayData = this.c;
                if (audioPlayData.mSpeed != 1.0f || gya.o(audioPlayData.mSoundTypes)) {
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

        @Override // com.baidu.tieba.c0b
        public void onFinishedWriting(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (z) {
                    this.e.q(new wxa(new AudioPlayData(this.a, 0, -1, 1.0f)), this.b);
                }
                synchronized (this.e) {
                    this.e.notifyAll();
                }
            }
        }

        @Override // com.baidu.tieba.c0b, com.baidu.tieba.b0b
        public void onProgressChanged(int i, double d, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Double.valueOf(d), Long.valueOf(j)}) == null) {
                dya dyaVar = this.e;
                dyaVar.i((int) (((((dyaVar.j - 1) + d) * 1.0d) / this.e.i) * 100.0d));
            }
        }
    }

    public dya() {
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

    @Override // com.baidu.tieba.bya
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f = true;
            nya nyaVar = this.h;
            if (nyaVar != null) {
                nyaVar.cancel();
            }
            synchronized (this) {
                notifyAll();
            }
            o();
        }
    }

    @Override // com.baidu.tieba.bya
    public void d(yxa yxaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yxaVar) == null) {
            if (yxaVar == null || m1b.e(yxaVar.c())) {
                g("input data error: null or length=0");
            } else if (!j(yxaVar)) {
                l(yxaVar);
            } else {
                String a2 = yxaVar.a();
                this.g = a2;
                if (!TextUtils.isEmpty(a2) && !FileUtils.isExists(this.g)) {
                    new File(this.g).mkdir();
                }
                this.e = false;
                this.f = false;
                y(yxaVar);
                x(yxaVar);
                List<aya> c = yxaVar.c();
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

    @Override // com.baidu.tieba.bya
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            nya nyaVar = this.h;
            if (nyaVar != null) {
                nyaVar.J();
            }
            synchronized (this) {
                notifyAll();
            }
        }
    }

    public final void q(wxa wxaVar, int i) {
        yxa yxaVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, wxaVar, i) == null) || (yxaVar = this.d) == null || yxaVar.c() == null || this.d.c().get(i) == null) {
            return;
        }
        this.d.c().get(i).a().add(wxaVar);
    }

    public final void r(aya ayaVar, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, ayaVar, i) == null) || ayaVar == null || m1b.e(ayaVar.a()) || this.f || this.e) {
            return;
        }
        for (wxa wxaVar : ayaVar.a()) {
            if (this.e || this.f) {
                return;
            }
            this.j++;
            if (t(wxaVar)) {
                v(wxaVar, i);
            } else {
                q(wxaVar, i);
                i((int) (((this.j * 1.0f) / this.i) * 100.0f));
            }
        }
    }

    public final boolean t(wxa wxaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, wxaVar)) == null) {
            if (wxaVar == null || wxaVar.b() == null || !wxaVar.c()) {
                return false;
            }
            if (!gya.o(wxaVar.b().mSoundTypes) && wxaVar.b().mSpeed == 1.0f && wxaVar.b().start == 0 && wxaVar.b().end == -1 && wxaVar.b().volume == 1.0f) {
                return (wxaVar.a() == null || "audio/mp4a-latm".equals(wxaVar.a().f())) ? false : true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void v(wxa wxaVar, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, wxaVar, i) == null) || this.f || this.e) {
            return;
        }
        AudioPlayData b = wxaVar.b();
        if (b == null || !FileUtils.isExists(b.audioPath)) {
            g("dealAudioPlayData,trackIndx:inputerror");
            return;
        }
        String str = b.audioPath;
        String a2 = a(str, System.currentTimeMillis() + "_mediacodec.aac");
        try {
            nya nyaVar = new nya(b.audioPath, a2, b.mSoundTypes);
            this.h = nyaVar;
            nyaVar.S(new a(this, a2, i, b, wxaVar));
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
            g("dealAudioPlayData exception:" + r1b.g(e));
            e.printStackTrace();
        }
    }

    public final void x(yxa yxaVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, yxaVar) == null) || yxaVar == null || m1b.e(yxaVar.c())) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < yxaVar.c().size(); i++) {
            arrayList.add(new aya(new ArrayList()));
        }
        yxa yxaVar2 = new yxa(arrayList);
        this.d = yxaVar2;
        yxaVar2.e(yxaVar.b());
        this.d.d(yxaVar.a());
    }

    public final void y(yxa yxaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, yxaVar) == null) {
            this.i = 0;
            this.j = 0;
            List<aya> c = yxaVar.c();
            int size = c.size();
            for (int i = 0; i < size; i++) {
                if (c.get(i) != null && c.get(i).a() != null) {
                    this.i += c.get(i).a().size();
                }
            }
        }
    }
}
