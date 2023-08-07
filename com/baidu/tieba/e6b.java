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
public class e6b extends c6b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public o6b h;
    public int i;
    public int j;

    /* loaded from: classes5.dex */
    public class a extends d8b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ AudioPlayData c;
        public final /* synthetic */ x5b d;
        public final /* synthetic */ e6b e;

        public a(e6b e6bVar, String str, int i, AudioPlayData audioPlayData, x5b x5bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e6bVar, str, Integer.valueOf(i), audioPlayData, x5bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = e6bVar;
            this.a = str;
            this.b = i;
            this.c = audioPlayData;
            this.d = x5bVar;
        }

        @Override // com.baidu.tieba.d8b, com.baidu.tieba.c8b
        public void onExceptionThrown(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.e.h.cancel();
                AudioPlayData audioPlayData = this.c;
                if (audioPlayData.mSpeed != 1.0f || h6b.o(audioPlayData.mSoundTypes)) {
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

        @Override // com.baidu.tieba.d8b
        public void onFinishedWriting(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (z) {
                    this.e.q(new x5b(new AudioPlayData(this.a, 0, -1, 1.0f)), this.b);
                }
                synchronized (this.e) {
                    this.e.notifyAll();
                }
            }
        }

        @Override // com.baidu.tieba.d8b, com.baidu.tieba.c8b
        public void onProgressChanged(int i, double d, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Double.valueOf(d), Long.valueOf(j)}) == null) {
                e6b e6bVar = this.e;
                e6bVar.i((int) (((((e6bVar.j - 1) + d) * 1.0d) / this.e.i) * 100.0d));
            }
        }
    }

    public e6b() {
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

    @Override // com.baidu.tieba.c6b
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f = true;
            o6b o6bVar = this.h;
            if (o6bVar != null) {
                o6bVar.cancel();
            }
            synchronized (this) {
                notifyAll();
            }
            o();
        }
    }

    @Override // com.baidu.tieba.c6b
    public void d(z5b z5bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z5bVar) == null) {
            if (z5bVar == null || n9b.e(z5bVar.c())) {
                g("input data error: null or length=0");
            } else if (!j(z5bVar)) {
                l(z5bVar);
            } else {
                String a2 = z5bVar.a();
                this.g = a2;
                if (!TextUtils.isEmpty(a2) && !FileUtils.isExists(this.g)) {
                    new File(this.g).mkdir();
                }
                this.e = false;
                this.f = false;
                y(z5bVar);
                x(z5bVar);
                List<b6b> c = z5bVar.c();
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

    @Override // com.baidu.tieba.c6b
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            o6b o6bVar = this.h;
            if (o6bVar != null) {
                o6bVar.J();
            }
            synchronized (this) {
                notifyAll();
            }
        }
    }

    public final void q(x5b x5bVar, int i) {
        z5b z5bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, x5bVar, i) == null) || (z5bVar = this.d) == null || z5bVar.c() == null || this.d.c().get(i) == null) {
            return;
        }
        this.d.c().get(i).a().add(x5bVar);
    }

    public final void r(b6b b6bVar, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, b6bVar, i) == null) || b6bVar == null || n9b.e(b6bVar.a()) || this.f || this.e) {
            return;
        }
        for (x5b x5bVar : b6bVar.a()) {
            if (this.e || this.f) {
                return;
            }
            this.j++;
            if (t(x5bVar)) {
                v(x5bVar, i);
            } else {
                q(x5bVar, i);
                i((int) (((this.j * 1.0f) / this.i) * 100.0f));
            }
        }
    }

    public final boolean t(x5b x5bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, x5bVar)) == null) {
            if (x5bVar == null || x5bVar.b() == null || !x5bVar.c()) {
                return false;
            }
            if (!h6b.o(x5bVar.b().mSoundTypes) && x5bVar.b().mSpeed == 1.0f && x5bVar.b().start == 0 && x5bVar.b().end == -1 && x5bVar.b().volume == 1.0f) {
                return (x5bVar.a() == null || "audio/mp4a-latm".equals(x5bVar.a().f())) ? false : true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void v(x5b x5bVar, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, x5bVar, i) == null) || this.f || this.e) {
            return;
        }
        AudioPlayData b = x5bVar.b();
        if (b == null || !FileUtils.isExists(b.audioPath)) {
            g("dealAudioPlayData,trackIndx:inputerror");
            return;
        }
        String str = b.audioPath;
        String a2 = a(str, System.currentTimeMillis() + "_mediacodec.aac");
        try {
            o6b o6bVar = new o6b(b.audioPath, a2, b.mSoundTypes);
            this.h = o6bVar;
            o6bVar.S(new a(this, a2, i, b, x5bVar));
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
            g("dealAudioPlayData exception:" + s9b.g(e));
            e.printStackTrace();
        }
    }

    public final void x(z5b z5bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, z5bVar) == null) || z5bVar == null || n9b.e(z5bVar.c())) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < z5bVar.c().size(); i++) {
            arrayList.add(new b6b(new ArrayList()));
        }
        z5b z5bVar2 = new z5b(arrayList);
        this.d = z5bVar2;
        z5bVar2.e(z5bVar.b());
        this.d.d(z5bVar.a());
    }

    public final void y(z5b z5bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, z5bVar) == null) {
            this.i = 0;
            this.j = 0;
            List<b6b> c = z5bVar.c();
            int size = c.size();
            for (int i = 0; i < size; i++) {
                if (c.get(i) != null && c.get(i).a() != null) {
                    this.i += c.get(i).a().size();
                }
            }
        }
    }
}
