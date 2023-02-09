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
public class cu9 extends au9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public mu9 h;
    public int i;
    public int j;

    /* loaded from: classes4.dex */
    public class a extends bw9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ AudioPlayData c;
        public final /* synthetic */ vt9 d;
        public final /* synthetic */ cu9 e;

        public a(cu9 cu9Var, String str, int i, AudioPlayData audioPlayData, vt9 vt9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cu9Var, str, Integer.valueOf(i), audioPlayData, vt9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = cu9Var;
            this.a = str;
            this.b = i;
            this.c = audioPlayData;
            this.d = vt9Var;
        }

        @Override // com.baidu.tieba.bw9, com.baidu.tieba.aw9
        public void onExceptionThrown(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.e.h.cancel();
                AudioPlayData audioPlayData = this.c;
                if (audioPlayData.mSpeed != 1.0f || fu9.o(audioPlayData.mSoundTypes)) {
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

        @Override // com.baidu.tieba.bw9
        public void onFinishedWriting(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (z) {
                    this.e.q(new vt9(new AudioPlayData(this.a, 0, -1, 1.0f)), this.b);
                }
                synchronized (this.e) {
                    this.e.notifyAll();
                }
            }
        }

        @Override // com.baidu.tieba.bw9, com.baidu.tieba.aw9
        public void onProgressChanged(int i, double d, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Double.valueOf(d), Long.valueOf(j)}) == null) {
                cu9 cu9Var = this.e;
                cu9Var.i((int) (((((cu9Var.j - 1) + d) * 1.0d) / this.e.i) * 100.0d));
            }
        }
    }

    public cu9() {
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

    @Override // com.baidu.tieba.au9
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f = true;
            mu9 mu9Var = this.h;
            if (mu9Var != null) {
                mu9Var.cancel();
            }
            synchronized (this) {
                notifyAll();
            }
            o();
        }
    }

    @Override // com.baidu.tieba.au9
    public void d(xt9 xt9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xt9Var) == null) {
            if (xt9Var == null || lx9.e(xt9Var.c())) {
                g("input data error: null or length=0");
            } else if (!j(xt9Var)) {
                l(xt9Var);
            } else {
                String a2 = xt9Var.a();
                this.g = a2;
                if (!TextUtils.isEmpty(a2) && !FileUtils.isExists(this.g)) {
                    new File(this.g).mkdir();
                }
                this.e = false;
                this.f = false;
                y(xt9Var);
                x(xt9Var);
                List<zt9> c = xt9Var.c();
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

    @Override // com.baidu.tieba.au9
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            mu9 mu9Var = this.h;
            if (mu9Var != null) {
                mu9Var.J();
            }
            synchronized (this) {
                notifyAll();
            }
        }
    }

    public final void q(vt9 vt9Var, int i) {
        xt9 xt9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, vt9Var, i) == null) || (xt9Var = this.d) == null || xt9Var.c() == null || this.d.c().get(i) == null) {
            return;
        }
        this.d.c().get(i).a().add(vt9Var);
    }

    public final void r(zt9 zt9Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, zt9Var, i) == null) || zt9Var == null || lx9.e(zt9Var.a()) || this.f || this.e) {
            return;
        }
        for (vt9 vt9Var : zt9Var.a()) {
            if (this.e || this.f) {
                return;
            }
            this.j++;
            if (t(vt9Var)) {
                v(vt9Var, i);
            } else {
                q(vt9Var, i);
                i((int) (((this.j * 1.0f) / this.i) * 100.0f));
            }
        }
    }

    public final boolean t(vt9 vt9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, vt9Var)) == null) {
            if (vt9Var == null || vt9Var.b() == null || !vt9Var.c()) {
                return false;
            }
            if (!fu9.o(vt9Var.b().mSoundTypes) && vt9Var.b().mSpeed == 1.0f && vt9Var.b().start == 0 && vt9Var.b().end == -1 && vt9Var.b().volume == 1.0f) {
                return (vt9Var.a() == null || "audio/mp4a-latm".equals(vt9Var.a().f())) ? false : true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void v(vt9 vt9Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, vt9Var, i) == null) || this.f || this.e) {
            return;
        }
        AudioPlayData b = vt9Var.b();
        if (b == null || !FileUtils.isExists(b.audioPath)) {
            g("dealAudioPlayData,trackIndx:inputerror");
            return;
        }
        String str = b.audioPath;
        String a2 = a(str, System.currentTimeMillis() + "_mediacodec.aac");
        try {
            mu9 mu9Var = new mu9(b.audioPath, a2, b.mSoundTypes);
            this.h = mu9Var;
            mu9Var.S(new a(this, a2, i, b, vt9Var));
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
            g("dealAudioPlayData exception:" + qx9.g(e));
            e.printStackTrace();
        }
    }

    public final void x(xt9 xt9Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, xt9Var) == null) || xt9Var == null || lx9.e(xt9Var.c())) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < xt9Var.c().size(); i++) {
            arrayList.add(new zt9(new ArrayList()));
        }
        xt9 xt9Var2 = new xt9(arrayList);
        this.d = xt9Var2;
        xt9Var2.e(xt9Var.b());
        this.d.d(xt9Var.a());
    }

    public final void y(xt9 xt9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, xt9Var) == null) {
            this.i = 0;
            this.j = 0;
            List<zt9> c = xt9Var.c();
            int size = c.size();
            for (int i = 0; i < size; i++) {
                if (c.get(i) != null && c.get(i).a() != null) {
                    this.i += c.get(i).a().size();
                }
            }
        }
    }
}
