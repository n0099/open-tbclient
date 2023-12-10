package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.bgc;
import com.baidu.tieba.igc;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.yalog.LoggerManager;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
/* loaded from: classes5.dex */
public final class agc {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "CrashSdkUtil";
    public static final long b = 600;
    public static final agc c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static final class a implements jgc {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @Override // com.baidu.tieba.jgc
        public void d(String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) && str2 != null) {
                bgc.b.b(agc.b(agc.c), str2);
            }
        }

        @Override // com.baidu.tieba.jgc
        public void e(String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) && str2 != null) {
                bgc.b.d(agc.b(agc.c), str2);
            }
        }

        @Override // com.baidu.tieba.jgc
        public void i(String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) && str2 != null) {
                bgc.b.g(agc.b(agc.c), str2);
            }
        }

        @Override // com.baidu.tieba.jgc
        public void w(String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) && str2 != null) {
                bgc.b.j(agc.b(agc.c), str2);
            }
        }

        @Override // com.baidu.tieba.jgc
        public void e(String str, String str2, Throwable th) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, th) == null) && str2 != null) {
                bgc.b.d(agc.b(agc.c), str2);
            }
        }

        @Override // com.baidu.tieba.jgc
        public void i(String str, String str2, Throwable th) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(1048580, this, str, str2, th) == null) && str2 != null) {
                bgc.b.g(agc.b(agc.c), str2);
            }
        }

        @Override // com.baidu.tieba.jgc
        public void w(String str, String str2, Throwable th) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(1048582, this, str, str2, th) == null) && str2 != null) {
                bgc.b.j(agc.b(agc.c), str2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class b implements igc.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        @Override // com.baidu.tieba.igc.e
        public void a(String str, boolean z, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, Boolean.valueOf(z), str2, str3, str4}) == null) {
                bgc.b.g(agc.b(agc.c), "afterCrashCallback");
            }
        }

        @Override // com.baidu.tieba.igc.e
        public void b(String str, boolean z, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, Boolean.valueOf(z), str2, str3, str4}) == null) {
                bgc.b.g(agc.b(agc.c), "crashCallback");
            }
        }

        @Override // com.baidu.tieba.igc.e
        public void c(boolean z, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), str, str2, str3}) == null) {
                try {
                    bgc.b.g(agc.b(agc.c), "preCrashCallback");
                    igc.s(agc.c.e(agc.a(agc.c)));
                } catch (Throwable th) {
                    bgc.b.d(agc.b(agc.c), th.toString());
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947615660, "Lcom/baidu/tieba/agc;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947615660, "Lcom/baidu/tieba/agc;");
                return;
            }
        }
        c = new agc();
    }

    public agc() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static final /* synthetic */ long a(agc agcVar) {
        return b;
    }

    public static final /* synthetic */ String b(agc agcVar) {
        return a;
    }

    public final void d(Context context, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, context, str, str2, str3) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("processName", str);
            try {
                igc.f fVar = new igc.f();
                fVar.h(context);
                fVar.g("baidu-yyremoteview");
                fVar.j(str2);
                fVar.i(new a());
                igc.n(fVar);
                ngc.W(str3);
                igc.r(hashMap);
                igc.q(new b());
            } catch (Throwable th) {
                bgc.a aVar = bgc.b;
                String str4 = a;
                th.printStackTrace();
                aVar.d(str4, Unit.INSTANCE.toString());
            }
        }
    }

    public final List<String> e(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            long j2 = currentTimeMillis - j;
            bgc.b.e(true);
            String baseDir = LoggerManager.getBaseDir();
            List<String> queryLogFiles = LoggerManager.queryLogFiles(j2, currentTimeMillis, "yylivesdk", "*");
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = queryLogFiles.iterator();
            while (it.hasNext()) {
                arrayList.add(baseDir + WebvttCueParser.CHAR_SLASH + it.next());
            }
            return arrayList;
        }
        return (List) invokeJ.objValue;
    }
}
