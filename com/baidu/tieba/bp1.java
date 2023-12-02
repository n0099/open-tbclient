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
/* loaded from: classes5.dex */
public class bp1 implements jr1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        /* renamed from: com.baidu.tieba.bp1$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0235a implements dl3<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ File a;
            public final /* synthetic */ String b;
            public final /* synthetic */ a c;

            /* renamed from: com.baidu.tieba.bp1$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class RunnableC0236a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ File a;
                public final /* synthetic */ C0235a b;

                public RunnableC0236a(C0235a c0235a, File file) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0235a, file};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = c0235a;
                    this.a = file;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        wj3.a(this.b.c.a, this.a);
                    }
                }
            }

            public C0235a(a aVar, File file, String str) {
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
            @Override // com.baidu.tieba.dl3
            /* renamed from: b */
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                    try {
                        File file = new File(this.a, "report");
                        nm4.l(file);
                        bp1.e(file, this.b, str);
                        bp1.d(file);
                        File file2 = new File(this.a, "report.zip");
                        nm4.j(file2);
                        nm4.X(file.getAbsolutePath(), file2.getAbsolutePath());
                        nm4.L(file);
                        ek3.a0(new RunnableC0236a(this, file2));
                    } catch (Exception e) {
                        k32.b("DefaultSwanAppLogManager", Log.getStackTraceString(e));
                        c63.g(AppRuntime.getAppContext(), this.c.a.getString(R.string.obfuscated_res_0x7f0f152b)).G();
                    }
                }
            }
        }

        public a(bp1 bp1Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bp1Var, context};
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
                File e3 = v52.e3();
                if (e3 == null) {
                    k32.k("DefaultSwanAppLogManager", "cacheDir 为 null");
                } else if (!e3.exists() && !e3.mkdirs()) {
                    k32.k("DefaultSwanAppLogManager", "cacheDir 为不存在且创建目录失败：" + e3.getAbsolutePath());
                } else {
                    dj3.i(this.a, new C0235a(this, e3, dj3.l(this.a) + "===== 启动信息 =====\n"));
                }
            }
        }
    }

    public bp1() {
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

    @Override // com.baidu.tieba.jr1
    public void a(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, context) != null) || context == null) {
            return;
        }
        ej3.k(new a(this, context), "log上报");
    }

    public static void d(File file) {
        File[] C;
        File[] C2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, file) == null) {
            File file2 = new File(file, "swan");
            nm4.e(rp2.p0().a(), file2);
            for (File file3 : nm4.C(file2)) {
                if (file3.isDirectory()) {
                    for (File file4 : nm4.C(file3)) {
                        if (file4 != null && file4.isFile() && !file4.getName().endsWith(".log")) {
                            nm4.L(file4);
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
            String g = yi3.g(currentTimeMillis, "yyyyMMdd");
            File file2 = new File(file, "runninginfo_" + g + ".txt");
            String g2 = yi3.g(currentTimeMillis, "yyyy-MM-dd HH:mm:ss");
            PrintWriter printWriter = new PrintWriter(file2);
            printWriter.println(g2 + "\n" + str + str2);
            printWriter.flush();
            printWriter.close();
        }
    }
}
