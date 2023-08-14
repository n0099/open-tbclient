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
public class f6b extends d6b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public p6b h;
    public int i;
    public int j;

    /* loaded from: classes5.dex */
    public class a extends e8b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ AudioPlayData c;
        public final /* synthetic */ y5b d;
        public final /* synthetic */ f6b e;

        public a(f6b f6bVar, String str, int i, AudioPlayData audioPlayData, y5b y5bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f6bVar, str, Integer.valueOf(i), audioPlayData, y5bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = f6bVar;
            this.a = str;
            this.b = i;
            this.c = audioPlayData;
            this.d = y5bVar;
        }

        @Override // com.baidu.tieba.e8b, com.baidu.tieba.d8b
        public void onExceptionThrown(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.e.h.cancel();
                AudioPlayData audioPlayData = this.c;
                if (audioPlayData.mSpeed != 1.0f || i6b.o(audioPlayData.mSoundTypes)) {
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

        @Override // com.baidu.tieba.e8b
        public void onFinishedWriting(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (z) {
                    this.e.q(new y5b(new AudioPlayData(this.a, 0, -1, 1.0f)), this.b);
                }
                synchronized (this.e) {
                    this.e.notifyAll();
                }
            }
        }

        @Override // com.baidu.tieba.e8b, com.baidu.tieba.d8b
        public void onProgressChanged(int i, double d, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Double.valueOf(d), Long.valueOf(j)}) == null) {
                f6b f6bVar = this.e;
                f6bVar.i((int) (((((f6bVar.j - 1) + d) * 1.0d) / this.e.i) * 100.0d));
            }
        }
    }

    public f6b() {
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

    @Override // com.baidu.tieba.d6b
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f = true;
            p6b p6bVar = this.h;
            if (p6bVar != null) {
                p6bVar.cancel();
            }
            synchronized (this) {
                notifyAll();
            }
            o();
        }
    }

    @Override // com.baidu.tieba.d6b
    public void d(a6b a6bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, a6bVar) == null) {
            if (a6bVar == null || o9b.e(a6bVar.c())) {
                g("input data error: null or length=0");
            } else if (!j(a6bVar)) {
                l(a6bVar);
            } else {
                String a2 = a6bVar.a();
                this.g = a2;
                if (!TextUtils.isEmpty(a2) && !FileUtils.isExists(this.g)) {
                    new File(this.g).mkdir();
                }
                this.e = false;
                this.f = false;
                y(a6bVar);
                x(a6bVar);
                List<c6b> c = a6bVar.c();
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

    @Override // com.baidu.tieba.d6b
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            p6b p6bVar = this.h;
            if (p6bVar != null) {
                p6bVar.J();
            }
            synchronized (this) {
                notifyAll();
            }
        }
    }

    public final void q(y5b y5bVar, int i) {
        a6b a6bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, y5bVar, i) == null) || (a6bVar = this.d) == null || a6bVar.c() == null || this.d.c().get(i) == null) {
            return;
        }
        this.d.c().get(i).a().add(y5bVar);
    }

    public final void r(c6b c6bVar, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, c6bVar, i) == null) || c6bVar == null || o9b.e(c6bVar.a()) || this.f || this.e) {
            return;
        }
        for (y5b y5bVar : c6bVar.a()) {
            if (this.e || this.f) {
                return;
            }
            this.j++;
            if (t(y5bVar)) {
                v(y5bVar, i);
            } else {
                q(y5bVar, i);
                i((int) (((this.j * 1.0f) / this.i) * 100.0f));
            }
        }
    }

    public final boolean t(y5b y5bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, y5bVar)) == null) {
            if (y5bVar == null || y5bVar.b() == null || !y5bVar.c()) {
                return false;
            }
            if (!i6b.o(y5bVar.b().mSoundTypes) && y5bVar.b().mSpeed == 1.0f && y5bVar.b().start == 0 && y5bVar.b().end == -1 && y5bVar.b().volume == 1.0f) {
                return (y5bVar.a() == null || "audio/mp4a-latm".equals(y5bVar.a().f())) ? false : true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void v(y5b y5bVar, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, y5bVar, i) == null) || this.f || this.e) {
            return;
        }
        AudioPlayData b = y5bVar.b();
        if (b == null || !FileUtils.isExists(b.audioPath)) {
            g("dealAudioPlayData,trackIndx:inputerror");
            return;
        }
        String str = b.audioPath;
        String a2 = a(str, System.currentTimeMillis() + "_mediacodec.aac");
        try {
            p6b p6bVar = new p6b(b.audioPath, a2, b.mSoundTypes);
            this.h = p6bVar;
            p6bVar.S(new a(this, a2, i, b, y5bVar));
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
            g("dealAudioPlayData exception:" + t9b.g(e));
            e.printStackTrace();
        }
    }

    public final void x(a6b a6bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, a6bVar) == null) || a6bVar == null || o9b.e(a6bVar.c())) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < a6bVar.c().size(); i++) {
            arrayList.add(new c6b(new ArrayList()));
        }
        a6b a6bVar2 = new a6b(arrayList);
        this.d = a6bVar2;
        a6bVar2.e(a6bVar.b());
        this.d.d(a6bVar.a());
    }

    public final void y(a6b a6bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, a6bVar) == null) {
            this.i = 0;
            this.j = 0;
            List<c6b> c = a6bVar.c();
            int size = c.size();
            for (int i = 0; i < size; i++) {
                if (c.get(i) != null && c.get(i).a() != null) {
                    this.i += c.get(i).a().size();
                }
            }
        }
    }
}
