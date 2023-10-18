package com.baidu.tieba;

import android.os.Environment;
import android.os.Looper;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.fqb;
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
public final class bqb {
    public static /* synthetic */ Interceptable $ic;
    public static bqb e;
    public static aqb f;
    public transient /* synthetic */ FieldHolder $fh;
    public fqb a;
    public hqb b;
    public gqb c;
    public List<cqb> d;

    /* loaded from: classes5.dex */
    public class a implements fqb.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bqb a;

        public a(bqb bqbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bqbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bqbVar;
        }

        @Override // com.baidu.tieba.fqb.b
        public void a(long j, long j2, long j3, long j4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)}) == null) {
                ArrayList<String> e = this.a.b.e(j, j2);
                if (!e.isEmpty()) {
                    iqb b = iqb.b();
                    b.c(j, j2, j3, j4);
                    b.d(this.a.c.e());
                    b.e(e);
                    b.a();
                    if (bqb.d().displayNotification()) {
                        eqb.c(b.toString());
                    }
                    if (this.a.d.size() != 0) {
                        for (cqb cqbVar : this.a.d) {
                            cqbVar.onBlock(bqb.d().provideContext(), b);
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

    public bqb() {
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
        this.b = new hqb(Looper.getMainLooper().getThread(), f.provideDumpInterval());
        this.c = new gqb(f.provideDumpInterval());
        m(new fqb(new a(this), d().provideBlockThreshold(), d().stopWhenDebugging()));
        eqb.b();
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

    public static void l(aqb aqbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, aqbVar) == null) {
            f = aqbVar;
        }
    }

    public void b(cqb cqbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cqbVar) == null) {
            this.d.add(cqbVar);
        }
    }

    public final void m(fqb fqbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fqbVar) == null) {
            this.a = fqbVar;
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

    public static aqb d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return f;
        }
        return (aqb) invokeV.objValue;
    }

    public static bqb f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (e == null) {
                synchronized (bqb.class) {
                    if (e == null) {
                        e = new bqb();
                    }
                }
            }
            return e;
        }
        return (bqb) invokeV.objValue;
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

    public gqb e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return (gqb) invokeV.objValue;
    }

    public fqb h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (fqb) invokeV.objValue;
    }

    public long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return d().provideBlockThreshold() * 0.8f;
        }
        return invokeV.longValue;
    }

    public hqb k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return (hqb) invokeV.objValue;
    }
}
