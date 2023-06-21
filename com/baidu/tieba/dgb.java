package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.egb;
import com.baidu.tieba.lgb;
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
public final class dgb {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "CrashSdkUtil";
    public static final long b = 600;
    public static final dgb c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static final class a implements lgb.e {
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

        @Override // com.baidu.tieba.lgb.e
        public void a(String str, boolean z, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, Boolean.valueOf(z), str2, str3, str4}) == null) {
                egb.b.g(dgb.b(dgb.c), "afterCrashCallback");
            }
        }

        @Override // com.baidu.tieba.lgb.e
        public void b(String str, boolean z, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, Boolean.valueOf(z), str2, str3, str4}) == null) {
                egb.b.g(dgb.b(dgb.c), "crashCallback");
            }
        }

        @Override // com.baidu.tieba.lgb.e
        public void c(boolean z, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), str, str2, str3}) == null) {
                try {
                    egb.b.g(dgb.b(dgb.c), "preCrashCallback");
                    lgb.s(dgb.c.e(dgb.a(dgb.c)));
                } catch (Throwable th) {
                    egb.b.d(dgb.b(dgb.c), th.toString());
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947705002, "Lcom/baidu/tieba/dgb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947705002, "Lcom/baidu/tieba/dgb;");
                return;
            }
        }
        c = new dgb();
    }

    public dgb() {
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

    public static final /* synthetic */ long a(dgb dgbVar) {
        return b;
    }

    public static final /* synthetic */ String b(dgb dgbVar) {
        return a;
    }

    public final void d(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, context, str, str2) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("processName", str);
            try {
                lgb.f fVar = new lgb.f();
                fVar.g(context);
                fVar.f("baidu-yyremoteview");
                fVar.h(str2);
                lgb.n(fVar);
                lgb.r(hashMap);
                lgb.q(new a());
            } catch (Throwable th) {
                egb.a aVar = egb.b;
                String str3 = a;
                th.printStackTrace();
                aVar.d(str3, Unit.INSTANCE.toString());
            }
        }
    }

    public final List<String> e(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            long j2 = currentTimeMillis - j;
            egb.b.e(true);
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
