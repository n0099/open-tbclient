package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
/* loaded from: classes6.dex */
public class go1 implements oq1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        /* renamed from: com.baidu.tieba.go1$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0297a implements ik3<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ File a;
            public final /* synthetic */ String b;
            public final /* synthetic */ a c;

            /* renamed from: com.baidu.tieba.go1$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class RunnableC0298a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ File a;
                public final /* synthetic */ C0297a b;

                public RunnableC0298a(C0297a c0297a, File file) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0297a, file};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = c0297a;
                    this.a = file;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        bj3.a(this.b.c.a, this.a);
                    }
                }
            }

            public C0297a(a aVar, File file, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, file, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = aVar;
                this.a = file;
                this.b = str;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ik3
            /* renamed from: b */
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                    try {
                        File file = new File(this.a, "report");
                        sl4.l(file);
                        go1.e(file, this.b, str);
                        go1.d(file);
                        File file2 = new File(this.a, "report.zip");
                        sl4.j(file2);
                        sl4.X(file.getAbsolutePath(), file2.getAbsolutePath());
                        sl4.L(file);
                        jj3.a0(new RunnableC0298a(this, file2));
                    } catch (Exception e) {
                        p22.b("DefaultSwanAppLogManager", Log.getStackTraceString(e));
                        h53.g(AppRuntime.getAppContext(), this.c.a.getString(R.string.obfuscated_res_0x7f0f1503)).G();
                    }
                }
            }
        }

        public a(go1 go1Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {go1Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                File e3 = a52.e3();
                if (e3 == null) {
                    p22.k("DefaultSwanAppLogManager", "cacheDir 为 null");
                } else if (!e3.exists() && !e3.mkdirs()) {
                    p22.k("DefaultSwanAppLogManager", "cacheDir 为不存在且创建目录失败：" + e3.getAbsolutePath());
                } else {
                    ii3.i(this.a, new C0297a(this, e3, ii3.l(this.a) + "===== 启动信息 =====\n"));
                }
            }
        }
    }

    public go1() {
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

    @Override // com.baidu.tieba.oq1
    public void a(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, context) != null) || context == null) {
            return;
        }
        ji3.k(new a(this, context), "log上报");
    }

    public static void d(File file) {
        File[] C;
        File[] C2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, file) == null) {
            File file2 = new File(file, "swan");
            sl4.e(wo2.p0().a(), file2);
            for (File file3 : sl4.C(file2)) {
                if (file3.isDirectory()) {
                    for (File file4 : sl4.C(file3)) {
                        if (file4 != null && file4.isFile() && !file4.getName().endsWith(".log")) {
                            sl4.L(file4);
                        }
                    }
                }
            }
        }
    }

    public static void e(File file, String str, String str2) throws FileNotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, file, str, str2) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            String g = di3.g(currentTimeMillis, "yyyyMMdd");
            File file2 = new File(file, "runninginfo_" + g + ".txt");
            String g2 = di3.g(currentTimeMillis, "yyyy-MM-dd HH:mm:ss");
            PrintWriter printWriter = new PrintWriter(file2);
            printWriter.println(g2 + "\n" + str + str2);
            printWriter.flush();
            printWriter.close();
        }
    }
}
