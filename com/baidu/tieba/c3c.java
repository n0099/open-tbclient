package com.baidu.tieba;

import android.os.Environment;
import android.os.Looper;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.g3c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public final class c3c {
    public static /* synthetic */ Interceptable $ic;
    public static c3c e;
    public static b3c f;
    public transient /* synthetic */ FieldHolder $fh;
    public g3c a;
    public i3c b;
    public h3c c;
    public List<d3c> d;

    /* loaded from: classes5.dex */
    public class a implements g3c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c3c a;

        public a(c3c c3cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c3cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c3cVar;
        }

        @Override // com.baidu.tieba.g3c.b
        public void a(long j, long j2, long j3, long j4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)}) == null) {
                ArrayList<String> e = this.a.b.e(j, j2);
                if (!e.isEmpty()) {
                    j3c b = j3c.b();
                    b.c(j, j2, j3, j4);
                    b.d(this.a.c.e());
                    b.e(e);
                    b.a();
                    if (c3c.d().displayNotification()) {
                        f3c.c(b.toString());
                    }
                    if (this.a.d.size() != 0) {
                        for (d3c d3cVar : this.a.d) {
                            d3cVar.onBlock(c3c.d().provideContext(), b);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements FilenameFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ".log";
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, file, str)) == null) {
                return str.endsWith(this.a);
            }
            return invokeLL.booleanValue;
        }
    }

    public c3c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = new LinkedList();
        this.b = new i3c(Looper.getMainLooper().getThread(), f.provideDumpInterval());
        this.c = new h3c(f.provideDumpInterval());
        m(new g3c(new a(this), d().provideBlockThreshold(), d().stopWhenDebugging()));
        f3c.b();
    }

    public static String i() {
        InterceptResult invokeV;
        String providePath;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            String externalStorageState = Environment.getExternalStorageState();
            if (d() == null) {
                providePath = "";
            } else {
                providePath = d().providePath();
            }
            if ("mounted".equals(externalStorageState) && Environment.getExternalStorageDirectory().canWrite()) {
                return Environment.getExternalStorageDirectory().getPath() + providePath;
            }
            return d().provideContext().getFilesDir() + d().providePath();
        }
        return (String) invokeV.objValue;
    }

    public static void l(b3c b3cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, b3cVar) == null) {
            f = b3cVar;
        }
    }

    public void b(d3c d3cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, d3cVar) == null) {
            this.d.add(d3cVar);
        }
    }

    public final void m(g3c g3cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, g3cVar) == null) {
            this.a = g3cVar;
        }
    }

    public static File c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            File file = new File(i());
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
        return (File) invokeV.objValue;
    }

    public static b3c d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return f;
        }
        return (b3c) invokeV.objValue;
    }

    public static c3c f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (e == null) {
                synchronized (c3c.class) {
                    if (e == null) {
                        e = new c3c();
                    }
                }
            }
            return e;
        }
        return (c3c) invokeV.objValue;
    }

    public static File[] g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            File c = c();
            if (c.exists() && c.isDirectory()) {
                return c.listFiles(new b());
            }
            return null;
        }
        return (File[]) invokeV.objValue;
    }

    public h3c e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return (h3c) invokeV.objValue;
    }

    public g3c h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (g3c) invokeV.objValue;
    }

    public long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return d().provideBlockThreshold() * 0.8f;
        }
        return invokeV.longValue;
    }

    public i3c k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return (i3c) invokeV.objValue;
    }
}
