package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.afa;
import com.baidu.tieba.yea;
import com.baidu.tieba.zea;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.download.exception.DownloadException;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executor;
/* loaded from: classes4.dex */
public class ffa implements zea, afa.a, yea.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public sea a;
    public vea b;
    public Executor c;
    public String d;
    public qea e;
    public zea.a f;
    public int g;
    public bfa h;
    public afa i;
    public List<yea> j;

    public ffa(sea seaVar, vea veaVar, Executor executor, String str, qea qeaVar, zea.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {seaVar, veaVar, executor, str, qeaVar, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = seaVar;
        this.b = veaVar;
        this.c = executor;
        this.d = str;
        this.e = qeaVar;
        this.f = aVar;
        g();
    }

    @Override // com.baidu.tieba.yea.a
    public void a(DownloadException downloadException) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, downloadException) == null) && k()) {
            this.g = 108;
            this.b.a(downloadException);
            m();
        }
    }

    @Override // com.baidu.tieba.yea.a
    public void onDownloadCompleted(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, str) == null) && j()) {
            this.g = 105;
            this.b.onDownloadCompleted(str);
            m();
        }
    }

    @Override // com.baidu.tieba.afa.a
    public void b(DownloadException downloadException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadException) == null) {
            if (this.i.isCanceled()) {
                onConnectCanceled();
            } else if (this.i.isPaused()) {
                onDownloadPaused();
            } else {
                this.g = 108;
                this.b.b(downloadException);
                m();
            }
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            File file = new File(this.h.a(), this.h.d());
            if (file.exists() && file.isFile()) {
                file.delete();
            }
        }
    }

    public final jfa f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return new jfa(0, this.d, this.a.c(), 0L);
        }
        return (jfa) invokeV.objValue;
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            for (yea yeaVar : this.j) {
                if (yeaVar.isDownloading()) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.zea
    public boolean isRunning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            int i = this.g;
            if (i != 101 && i != 102 && i != 103 && i != 104) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            for (yea yeaVar : this.j) {
                if (!yeaVar.isComplete()) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            for (yea yeaVar : this.j) {
                if (yeaVar.isDownloading()) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            for (yea yeaVar : this.j) {
                if (yeaVar.isDownloading()) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f.a(this.d, this);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            gfa gfaVar = new gfa(this.a.c(), this);
            this.i = gfaVar;
            this.c.execute(gfaVar);
        }
    }

    @Override // com.baidu.tieba.afa.a
    public void onConnectCanceled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            c();
            this.g = 107;
            this.b.onConnectCanceled();
            m();
        }
    }

    @Override // com.baidu.tieba.afa.a
    public void onConnectPaused() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            onDownloadPaused();
        }
    }

    @Override // com.baidu.tieba.afa.a
    public void onConnecting() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.g = 102;
            this.b.onConnecting();
        }
    }

    @Override // com.baidu.tieba.yea.a
    public void onDownloadCanceled() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && i()) {
            c();
            this.g = 107;
            this.b.onDownloadCanceled();
            m();
        }
    }

    @Override // com.baidu.tieba.yea.a
    public void onDownloadPaused() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && l()) {
            this.g = 106;
            this.b.onDownloadPaused();
            m();
        }
    }

    @Override // com.baidu.tieba.zea
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.g = 101;
            this.b.onStarted();
            n();
        }
    }

    @Override // com.baidu.tieba.zea
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            afa afaVar = this.i;
            if (afaVar != null) {
                afaVar.cancel();
            }
            for (yea yeaVar : this.j) {
                yeaVar.cancel();
            }
            if (this.g != 104) {
                onDownloadCanceled();
            }
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.h = new bfa(this.a.b().toString(), this.a.c(), this.a.a());
            this.j = new LinkedList();
        }
    }

    @Override // com.baidu.tieba.zea
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            afa afaVar = this.i;
            if (afaVar != null) {
                afaVar.pause();
            }
            for (yea yeaVar : this.j) {
                yeaVar.pause();
            }
            if (this.g != 104) {
                onDownloadPaused();
            }
        }
    }

    public final void d(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            this.g = 104;
            h(j, z);
            for (yea yeaVar : this.j) {
                this.c.execute(yeaVar);
            }
        }
    }

    public final List<jfa> e(long j) {
        InterceptResult invokeJ;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j)) == null) {
            ArrayList arrayList = new ArrayList();
            int b = this.e.b();
            for (int i = 0; i < b; i++) {
                long j3 = j / b;
                long j4 = j3 * i;
                if (i == b - 1) {
                    j2 = j;
                } else {
                    j2 = (j3 + j4) - 1;
                }
                arrayList.add(new jfa(i, this.d, this.a.c(), j4, j2, 0L));
            }
            return arrayList;
        }
        return (List) invokeJ.objValue;
    }

    public final void h(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            this.j.clear();
            if (z) {
                List<jfa> e = e(j);
                int i = 0;
                for (jfa jfaVar : e) {
                    i = (int) (i + jfaVar.b());
                }
                this.h.f(i);
                for (jfa jfaVar2 : e) {
                    this.j.add(new hfa(this.h, jfaVar2, this));
                }
                return;
            }
            this.j.add(new ifa(this.h, f(), this));
        }
    }

    @Override // com.baidu.tieba.afa.a
    public void onConnected(long j, long j2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
            if (this.i.isCanceled()) {
                onConnectCanceled();
                return;
            }
            this.g = 103;
            this.b.onConnected(j, j2, z);
            this.h.e(z);
            this.h.g(j2);
            d(j2, z);
        }
    }

    @Override // com.baidu.tieba.yea.a
    public void onDownloadProgress(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.b.onDownloadProgress(j, j2, (int) ((100 * j) / j2));
        }
    }
}
