package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.t99;
import com.baidu.tieba.u99;
import com.baidu.tieba.v99;
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
/* loaded from: classes3.dex */
public class aa9 implements u99, v99.a, t99.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public n99 a;
    public q99 b;
    public Executor c;
    public String d;
    public l99 e;
    public u99.a f;
    public int g;
    public w99 h;
    public v99 i;
    public List<t99> j;

    public aa9(n99 n99Var, q99 q99Var, Executor executor, String str, l99 l99Var, u99.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {n99Var, q99Var, executor, str, l99Var, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = n99Var;
        this.b = q99Var;
        this.c = executor;
        this.d = str;
        this.e = l99Var;
        this.f = aVar;
        g();
    }

    @Override // com.baidu.tieba.t99.a
    public void a(DownloadException downloadException) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, downloadException) == null) && k()) {
            this.g = 108;
            this.b.a(downloadException);
            m();
        }
    }

    @Override // com.baidu.tieba.v99.a
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

    @Override // com.baidu.tieba.u99
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            v99 v99Var = this.i;
            if (v99Var != null) {
                v99Var.cancel();
            }
            for (t99 t99Var : this.j) {
                t99Var.cancel();
            }
            if (this.g != 104) {
                onDownloadCanceled();
            }
        }
    }

    public final void d(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            this.g = 104;
            h(j, z);
            for (t99 t99Var : this.j) {
                this.c.execute(t99Var);
            }
        }
    }

    public final List<ea9> e(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j)) == null) {
            ArrayList arrayList = new ArrayList();
            int b = this.e.b();
            int i = 0;
            while (i < b) {
                long j2 = j / b;
                long j3 = j2 * i;
                arrayList.add(new ea9(i, this.d, this.a.c(), j3, i == b + (-1) ? j : (j2 + j3) - 1, 0L));
                i++;
            }
            return arrayList;
        }
        return (List) invokeJ.objValue;
    }

    public final ea9 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new ea9(0, this.d, this.a.c(), 0L) : (ea9) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.h = new w99(this.a.b().toString(), this.a.c(), this.a.a());
            this.j = new LinkedList();
        }
    }

    public final void h(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            this.j.clear();
            if (z) {
                List<ea9> e = e(j);
                int i = 0;
                for (ea9 ea9Var : e) {
                    i = (int) (i + ea9Var.b());
                }
                this.h.f(i);
                for (ea9 ea9Var2 : e) {
                    this.j.add(new ca9(this.h, ea9Var2, this));
                }
                return;
            }
            this.j.add(new da9(this.h, f(), this));
        }
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            for (t99 t99Var : this.j) {
                if (t99Var.isDownloading()) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.u99
    public boolean isRunning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            int i = this.g;
            return i == 101 || i == 102 || i == 103 || i == 104;
        }
        return invokeV.booleanValue;
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            for (t99 t99Var : this.j) {
                if (!t99Var.isComplete()) {
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
            for (t99 t99Var : this.j) {
                if (t99Var.isDownloading()) {
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
            for (t99 t99Var : this.j) {
                if (t99Var.isDownloading()) {
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
            ba9 ba9Var = new ba9(this.a.c(), this);
            this.i = ba9Var;
            this.c.execute(ba9Var);
        }
    }

    @Override // com.baidu.tieba.v99.a
    public void onConnectCanceled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            c();
            this.g = 107;
            this.b.onConnectCanceled();
            m();
        }
    }

    @Override // com.baidu.tieba.v99.a
    public void onConnectPaused() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            onDownloadPaused();
        }
    }

    @Override // com.baidu.tieba.v99.a
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

    @Override // com.baidu.tieba.v99.a
    public void onConnecting() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.g = 102;
            this.b.onConnecting();
        }
    }

    @Override // com.baidu.tieba.t99.a
    public void onDownloadCanceled() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && i()) {
            c();
            this.g = 107;
            this.b.onDownloadCanceled();
            m();
        }
    }

    @Override // com.baidu.tieba.t99.a
    public void onDownloadCompleted(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, str) == null) && j()) {
            this.g = 105;
            this.b.onDownloadCompleted(str);
            m();
        }
    }

    @Override // com.baidu.tieba.t99.a
    public void onDownloadPaused() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && l()) {
            this.g = 106;
            this.b.onDownloadPaused();
            m();
        }
    }

    @Override // com.baidu.tieba.t99.a
    public void onDownloadProgress(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.b.onDownloadProgress(j, j2, (int) ((100 * j) / j2));
        }
    }

    @Override // com.baidu.tieba.u99
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            v99 v99Var = this.i;
            if (v99Var != null) {
                v99Var.pause();
            }
            for (t99 t99Var : this.j) {
                t99Var.pause();
            }
            if (this.g != 104) {
                onDownloadPaused();
            }
        }
    }

    @Override // com.baidu.tieba.u99
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.g = 101;
            this.b.onStarted();
            n();
        }
    }
}
