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
public class i4a extends g4a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public s4a h;
    public int i;
    public int j;

    /* loaded from: classes4.dex */
    public class a extends h6a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ AudioPlayData c;
        public final /* synthetic */ b4a d;
        public final /* synthetic */ i4a e;

        public a(i4a i4aVar, String str, int i, AudioPlayData audioPlayData, b4a b4aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i4aVar, str, Integer.valueOf(i), audioPlayData, b4aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = i4aVar;
            this.a = str;
            this.b = i;
            this.c = audioPlayData;
            this.d = b4aVar;
        }

        @Override // com.baidu.tieba.h6a, com.baidu.tieba.g6a
        public void onExceptionThrown(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.e.h.cancel();
                AudioPlayData audioPlayData = this.c;
                if (audioPlayData.mSpeed != 1.0f || l4a.o(audioPlayData.mSoundTypes)) {
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

        @Override // com.baidu.tieba.h6a
        public void onFinishedWriting(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (z) {
                    this.e.q(new b4a(new AudioPlayData(this.a, 0, -1, 1.0f)), this.b);
                }
                synchronized (this.e) {
                    this.e.notifyAll();
                }
            }
        }

        @Override // com.baidu.tieba.h6a, com.baidu.tieba.g6a
        public void onProgressChanged(int i, double d, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Double.valueOf(d), Long.valueOf(j)}) == null) {
                i4a i4aVar = this.e;
                i4aVar.i((int) (((((i4aVar.j - 1) + d) * 1.0d) / this.e.i) * 100.0d));
            }
        }
    }

    public i4a() {
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

    @Override // com.baidu.tieba.g4a
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f = true;
            s4a s4aVar = this.h;
            if (s4aVar != null) {
                s4aVar.cancel();
            }
            synchronized (this) {
                notifyAll();
            }
            o();
        }
    }

    @Override // com.baidu.tieba.g4a
    public void d(d4a d4aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d4aVar) == null) {
            if (d4aVar == null || r7a.e(d4aVar.c())) {
                g("input data error: null or length=0");
            } else if (!j(d4aVar)) {
                l(d4aVar);
            } else {
                String a2 = d4aVar.a();
                this.g = a2;
                if (!TextUtils.isEmpty(a2) && !FileUtils.isExists(this.g)) {
                    new File(this.g).mkdir();
                }
                this.e = false;
                this.f = false;
                y(d4aVar);
                x(d4aVar);
                List<f4a> c = d4aVar.c();
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

    @Override // com.baidu.tieba.g4a
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            s4a s4aVar = this.h;
            if (s4aVar != null) {
                s4aVar.J();
            }
            synchronized (this) {
                notifyAll();
            }
        }
    }

    public final void q(b4a b4aVar, int i) {
        d4a d4aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, b4aVar, i) == null) || (d4aVar = this.d) == null || d4aVar.c() == null || this.d.c().get(i) == null) {
            return;
        }
        this.d.c().get(i).a().add(b4aVar);
    }

    public final void r(f4a f4aVar, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, f4aVar, i) == null) || f4aVar == null || r7a.e(f4aVar.a()) || this.f || this.e) {
            return;
        }
        for (b4a b4aVar : f4aVar.a()) {
            if (this.e || this.f) {
                return;
            }
            this.j++;
            if (t(b4aVar)) {
                v(b4aVar, i);
            } else {
                q(b4aVar, i);
                i((int) (((this.j * 1.0f) / this.i) * 100.0f));
            }
        }
    }

    public final boolean t(b4a b4aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, b4aVar)) == null) {
            if (b4aVar == null || b4aVar.b() == null || !b4aVar.c()) {
                return false;
            }
            if (!l4a.o(b4aVar.b().mSoundTypes) && b4aVar.b().mSpeed == 1.0f && b4aVar.b().start == 0 && b4aVar.b().end == -1 && b4aVar.b().volume == 1.0f) {
                return (b4aVar.a() == null || "audio/mp4a-latm".equals(b4aVar.a().f())) ? false : true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void v(b4a b4aVar, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, b4aVar, i) == null) || this.f || this.e) {
            return;
        }
        AudioPlayData b = b4aVar.b();
        if (b == null || !FileUtils.isExists(b.audioPath)) {
            g("dealAudioPlayData,trackIndx:inputerror");
            return;
        }
        String str = b.audioPath;
        String a2 = a(str, System.currentTimeMillis() + "_mediacodec.aac");
        try {
            s4a s4aVar = new s4a(b.audioPath, a2, b.mSoundTypes);
            this.h = s4aVar;
            s4aVar.S(new a(this, a2, i, b, b4aVar));
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
            g("dealAudioPlayData exception:" + w7a.g(e));
            e.printStackTrace();
        }
    }

    public final void x(d4a d4aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, d4aVar) == null) || d4aVar == null || r7a.e(d4aVar.c())) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < d4aVar.c().size(); i++) {
            arrayList.add(new f4a(new ArrayList()));
        }
        d4a d4aVar2 = new d4a(arrayList);
        this.d = d4aVar2;
        d4aVar2.e(d4aVar.b());
        this.d.d(d4aVar.a());
    }

    public final void y(d4a d4aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, d4aVar) == null) {
            this.i = 0;
            this.j = 0;
            List<f4a> c = d4aVar.c();
            int size = c.size();
            for (int i = 0; i < size; i++) {
                if (c.get(i) != null && c.get(i).a() != null) {
                    this.i += c.get(i).a().size();
                }
            }
        }
    }
}
