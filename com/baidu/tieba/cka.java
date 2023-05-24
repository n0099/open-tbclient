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
public class cka extends aka {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public mka h;
    public int i;
    public int j;

    /* loaded from: classes5.dex */
    public class a extends bma {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ AudioPlayData c;
        public final /* synthetic */ vja d;
        public final /* synthetic */ cka e;

        public a(cka ckaVar, String str, int i, AudioPlayData audioPlayData, vja vjaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ckaVar, str, Integer.valueOf(i), audioPlayData, vjaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ckaVar;
            this.a = str;
            this.b = i;
            this.c = audioPlayData;
            this.d = vjaVar;
        }

        @Override // com.baidu.tieba.bma, com.baidu.tieba.ama
        public void onExceptionThrown(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.e.h.cancel();
                AudioPlayData audioPlayData = this.c;
                if (audioPlayData.mSpeed != 1.0f || fka.o(audioPlayData.mSoundTypes)) {
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

        @Override // com.baidu.tieba.bma
        public void onFinishedWriting(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (z) {
                    this.e.q(new vja(new AudioPlayData(this.a, 0, -1, 1.0f)), this.b);
                }
                synchronized (this.e) {
                    this.e.notifyAll();
                }
            }
        }

        @Override // com.baidu.tieba.bma, com.baidu.tieba.ama
        public void onProgressChanged(int i, double d, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Double.valueOf(d), Long.valueOf(j)}) == null) {
                cka ckaVar = this.e;
                ckaVar.i((int) (((((ckaVar.j - 1) + d) * 1.0d) / this.e.i) * 100.0d));
            }
        }
    }

    public cka() {
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

    @Override // com.baidu.tieba.aka
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f = true;
            mka mkaVar = this.h;
            if (mkaVar != null) {
                mkaVar.cancel();
            }
            synchronized (this) {
                notifyAll();
            }
            o();
        }
    }

    @Override // com.baidu.tieba.aka
    public void d(xja xjaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xjaVar) == null) {
            if (xjaVar == null || lna.e(xjaVar.c())) {
                g("input data error: null or length=0");
            } else if (!j(xjaVar)) {
                l(xjaVar);
            } else {
                String a2 = xjaVar.a();
                this.g = a2;
                if (!TextUtils.isEmpty(a2) && !FileUtils.isExists(this.g)) {
                    new File(this.g).mkdir();
                }
                this.e = false;
                this.f = false;
                y(xjaVar);
                x(xjaVar);
                List<zja> c = xjaVar.c();
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

    @Override // com.baidu.tieba.aka
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            mka mkaVar = this.h;
            if (mkaVar != null) {
                mkaVar.J();
            }
            synchronized (this) {
                notifyAll();
            }
        }
    }

    public final void q(vja vjaVar, int i) {
        xja xjaVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, vjaVar, i) == null) || (xjaVar = this.d) == null || xjaVar.c() == null || this.d.c().get(i) == null) {
            return;
        }
        this.d.c().get(i).a().add(vjaVar);
    }

    public final void r(zja zjaVar, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, zjaVar, i) == null) || zjaVar == null || lna.e(zjaVar.a()) || this.f || this.e) {
            return;
        }
        for (vja vjaVar : zjaVar.a()) {
            if (this.e || this.f) {
                return;
            }
            this.j++;
            if (t(vjaVar)) {
                v(vjaVar, i);
            } else {
                q(vjaVar, i);
                i((int) (((this.j * 1.0f) / this.i) * 100.0f));
            }
        }
    }

    public final boolean t(vja vjaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, vjaVar)) == null) {
            if (vjaVar == null || vjaVar.b() == null || !vjaVar.c()) {
                return false;
            }
            if (!fka.o(vjaVar.b().mSoundTypes) && vjaVar.b().mSpeed == 1.0f && vjaVar.b().start == 0 && vjaVar.b().end == -1 && vjaVar.b().volume == 1.0f) {
                return (vjaVar.a() == null || "audio/mp4a-latm".equals(vjaVar.a().f())) ? false : true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void v(vja vjaVar, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, vjaVar, i) == null) || this.f || this.e) {
            return;
        }
        AudioPlayData b = vjaVar.b();
        if (b == null || !FileUtils.isExists(b.audioPath)) {
            g("dealAudioPlayData,trackIndx:inputerror");
            return;
        }
        String str = b.audioPath;
        String a2 = a(str, System.currentTimeMillis() + "_mediacodec.aac");
        try {
            mka mkaVar = new mka(b.audioPath, a2, b.mSoundTypes);
            this.h = mkaVar;
            mkaVar.S(new a(this, a2, i, b, vjaVar));
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
            g("dealAudioPlayData exception:" + qna.g(e));
            e.printStackTrace();
        }
    }

    public final void x(xja xjaVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, xjaVar) == null) || xjaVar == null || lna.e(xjaVar.c())) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < xjaVar.c().size(); i++) {
            arrayList.add(new zja(new ArrayList()));
        }
        xja xjaVar2 = new xja(arrayList);
        this.d = xjaVar2;
        xjaVar2.e(xjaVar.b());
        this.d.d(xjaVar.a());
    }

    public final void y(xja xjaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, xjaVar) == null) {
            this.i = 0;
            this.j = 0;
            List<zja> c = xjaVar.c();
            int size = c.size();
            for (int i = 0; i < size; i++) {
                if (c.get(i) != null && c.get(i).a() != null) {
                    this.i += c.get(i).a().size();
                }
            }
        }
    }
}
