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
public class dia extends bia {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public nia h;
    public int i;
    public int j;

    /* loaded from: classes4.dex */
    public class a extends cka {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ AudioPlayData c;
        public final /* synthetic */ wha d;
        public final /* synthetic */ dia e;

        public a(dia diaVar, String str, int i, AudioPlayData audioPlayData, wha whaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {diaVar, str, Integer.valueOf(i), audioPlayData, whaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = diaVar;
            this.a = str;
            this.b = i;
            this.c = audioPlayData;
            this.d = whaVar;
        }

        @Override // com.baidu.tieba.cka, com.baidu.tieba.bka
        public void onExceptionThrown(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.e.h.cancel();
                AudioPlayData audioPlayData = this.c;
                if (audioPlayData.mSpeed != 1.0f || gia.o(audioPlayData.mSoundTypes)) {
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

        @Override // com.baidu.tieba.cka
        public void onFinishedWriting(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (z) {
                    this.e.q(new wha(new AudioPlayData(this.a, 0, -1, 1.0f)), this.b);
                }
                synchronized (this.e) {
                    this.e.notifyAll();
                }
            }
        }

        @Override // com.baidu.tieba.cka, com.baidu.tieba.bka
        public void onProgressChanged(int i, double d, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Double.valueOf(d), Long.valueOf(j)}) == null) {
                dia diaVar = this.e;
                diaVar.i((int) (((((diaVar.j - 1) + d) * 1.0d) / this.e.i) * 100.0d));
            }
        }
    }

    public dia() {
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

    @Override // com.baidu.tieba.bia
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f = true;
            nia niaVar = this.h;
            if (niaVar != null) {
                niaVar.cancel();
            }
            synchronized (this) {
                notifyAll();
            }
            o();
        }
    }

    @Override // com.baidu.tieba.bia
    public void d(yha yhaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yhaVar) == null) {
            if (yhaVar == null || mla.e(yhaVar.c())) {
                g("input data error: null or length=0");
            } else if (!j(yhaVar)) {
                l(yhaVar);
            } else {
                String a2 = yhaVar.a();
                this.g = a2;
                if (!TextUtils.isEmpty(a2) && !FileUtils.isExists(this.g)) {
                    new File(this.g).mkdir();
                }
                this.e = false;
                this.f = false;
                y(yhaVar);
                x(yhaVar);
                List<aia> c = yhaVar.c();
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

    @Override // com.baidu.tieba.bia
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            nia niaVar = this.h;
            if (niaVar != null) {
                niaVar.J();
            }
            synchronized (this) {
                notifyAll();
            }
        }
    }

    public final void q(wha whaVar, int i) {
        yha yhaVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, whaVar, i) == null) || (yhaVar = this.d) == null || yhaVar.c() == null || this.d.c().get(i) == null) {
            return;
        }
        this.d.c().get(i).a().add(whaVar);
    }

    public final void r(aia aiaVar, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, aiaVar, i) == null) || aiaVar == null || mla.e(aiaVar.a()) || this.f || this.e) {
            return;
        }
        for (wha whaVar : aiaVar.a()) {
            if (this.e || this.f) {
                return;
            }
            this.j++;
            if (t(whaVar)) {
                v(whaVar, i);
            } else {
                q(whaVar, i);
                i((int) (((this.j * 1.0f) / this.i) * 100.0f));
            }
        }
    }

    public final boolean t(wha whaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, whaVar)) == null) {
            if (whaVar == null || whaVar.b() == null || !whaVar.c()) {
                return false;
            }
            if (!gia.o(whaVar.b().mSoundTypes) && whaVar.b().mSpeed == 1.0f && whaVar.b().start == 0 && whaVar.b().end == -1 && whaVar.b().volume == 1.0f) {
                return (whaVar.a() == null || "audio/mp4a-latm".equals(whaVar.a().f())) ? false : true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void v(wha whaVar, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, whaVar, i) == null) || this.f || this.e) {
            return;
        }
        AudioPlayData b = whaVar.b();
        if (b == null || !FileUtils.isExists(b.audioPath)) {
            g("dealAudioPlayData,trackIndx:inputerror");
            return;
        }
        String str = b.audioPath;
        String a2 = a(str, System.currentTimeMillis() + "_mediacodec.aac");
        try {
            nia niaVar = new nia(b.audioPath, a2, b.mSoundTypes);
            this.h = niaVar;
            niaVar.S(new a(this, a2, i, b, whaVar));
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
            g("dealAudioPlayData exception:" + rla.g(e));
            e.printStackTrace();
        }
    }

    public final void x(yha yhaVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, yhaVar) == null) || yhaVar == null || mla.e(yhaVar.c())) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < yhaVar.c().size(); i++) {
            arrayList.add(new aia(new ArrayList()));
        }
        yha yhaVar2 = new yha(arrayList);
        this.d = yhaVar2;
        yhaVar2.e(yhaVar.b());
        this.d.d(yhaVar.a());
    }

    public final void y(yha yhaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, yhaVar) == null) {
            this.i = 0;
            this.j = 0;
            List<aia> c = yhaVar.c();
            int size = c.size();
            for (int i = 0; i < size; i++) {
                if (c.get(i) != null && c.get(i).a() != null) {
                    this.i += c.get(i).a().size();
                }
            }
        }
    }
}
