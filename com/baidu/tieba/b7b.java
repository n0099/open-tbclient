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
public class b7b extends z6b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public l7b h;
    public int i;
    public int j;

    /* loaded from: classes5.dex */
    public class a extends a9b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ AudioPlayData c;
        public final /* synthetic */ u6b d;
        public final /* synthetic */ b7b e;

        public a(b7b b7bVar, String str, int i, AudioPlayData audioPlayData, u6b u6bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b7bVar, str, Integer.valueOf(i), audioPlayData, u6bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = b7bVar;
            this.a = str;
            this.b = i;
            this.c = audioPlayData;
            this.d = u6bVar;
        }

        @Override // com.baidu.tieba.a9b, com.baidu.tieba.z8b
        public void onExceptionThrown(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.e.h.cancel();
                AudioPlayData audioPlayData = this.c;
                if (audioPlayData.mSpeed != 1.0f || e7b.o(audioPlayData.mSoundTypes)) {
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

        @Override // com.baidu.tieba.a9b
        public void onFinishedWriting(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (z) {
                    this.e.q(new u6b(new AudioPlayData(this.a, 0, -1, 1.0f)), this.b);
                }
                synchronized (this.e) {
                    this.e.notifyAll();
                }
            }
        }

        @Override // com.baidu.tieba.a9b, com.baidu.tieba.z8b
        public void onProgressChanged(int i, double d, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Double.valueOf(d), Long.valueOf(j)}) == null) {
                b7b b7bVar = this.e;
                b7bVar.i((int) (((((b7bVar.j - 1) + d) * 1.0d) / this.e.i) * 100.0d));
            }
        }
    }

    public b7b() {
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

    @Override // com.baidu.tieba.z6b
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f = true;
            l7b l7bVar = this.h;
            if (l7bVar != null) {
                l7bVar.cancel();
            }
            synchronized (this) {
                notifyAll();
            }
            o();
        }
    }

    @Override // com.baidu.tieba.z6b
    public void d(w6b w6bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, w6bVar) == null) {
            if (w6bVar == null || kab.e(w6bVar.c())) {
                g("input data error: null or length=0");
            } else if (!j(w6bVar)) {
                l(w6bVar);
            } else {
                String a2 = w6bVar.a();
                this.g = a2;
                if (!TextUtils.isEmpty(a2) && !FileUtils.isExists(this.g)) {
                    new File(this.g).mkdir();
                }
                this.e = false;
                this.f = false;
                y(w6bVar);
                x(w6bVar);
                List<y6b> c = w6bVar.c();
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

    @Override // com.baidu.tieba.z6b
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            l7b l7bVar = this.h;
            if (l7bVar != null) {
                l7bVar.J();
            }
            synchronized (this) {
                notifyAll();
            }
        }
    }

    public final void q(u6b u6bVar, int i) {
        w6b w6bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, u6bVar, i) == null) || (w6bVar = this.d) == null || w6bVar.c() == null || this.d.c().get(i) == null) {
            return;
        }
        this.d.c().get(i).a().add(u6bVar);
    }

    public final void r(y6b y6bVar, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, y6bVar, i) == null) || y6bVar == null || kab.e(y6bVar.a()) || this.f || this.e) {
            return;
        }
        for (u6b u6bVar : y6bVar.a()) {
            if (this.e || this.f) {
                return;
            }
            this.j++;
            if (t(u6bVar)) {
                v(u6bVar, i);
            } else {
                q(u6bVar, i);
                i((int) (((this.j * 1.0f) / this.i) * 100.0f));
            }
        }
    }

    public final boolean t(u6b u6bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, u6bVar)) == null) {
            if (u6bVar == null || u6bVar.b() == null || !u6bVar.c()) {
                return false;
            }
            if (!e7b.o(u6bVar.b().mSoundTypes) && u6bVar.b().mSpeed == 1.0f && u6bVar.b().start == 0 && u6bVar.b().end == -1 && u6bVar.b().volume == 1.0f) {
                return (u6bVar.a() == null || "audio/mp4a-latm".equals(u6bVar.a().f())) ? false : true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void v(u6b u6bVar, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, u6bVar, i) == null) || this.f || this.e) {
            return;
        }
        AudioPlayData b = u6bVar.b();
        if (b == null || !FileUtils.isExists(b.audioPath)) {
            g("dealAudioPlayData,trackIndx:inputerror");
            return;
        }
        String str = b.audioPath;
        String a2 = a(str, System.currentTimeMillis() + "_mediacodec.aac");
        try {
            l7b l7bVar = new l7b(b.audioPath, a2, b.mSoundTypes);
            this.h = l7bVar;
            l7bVar.S(new a(this, a2, i, b, u6bVar));
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
            g("dealAudioPlayData exception:" + pab.g(e));
            e.printStackTrace();
        }
    }

    public final void x(w6b w6bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, w6bVar) == null) || w6bVar == null || kab.e(w6bVar.c())) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < w6bVar.c().size(); i++) {
            arrayList.add(new y6b(new ArrayList()));
        }
        w6b w6bVar2 = new w6b(arrayList);
        this.d = w6bVar2;
        w6bVar2.e(w6bVar.b());
        this.d.d(w6bVar.a());
    }

    public final void y(w6b w6bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, w6bVar) == null) {
            this.i = 0;
            this.j = 0;
            List<y6b> c = w6bVar.c();
            int size = c.size();
            for (int i = 0; i < size; i++) {
                if (c.get(i) != null && c.get(i).a() != null) {
                    this.i += c.get(i).a().size();
                }
            }
        }
    }
}
