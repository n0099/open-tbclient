package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tieba.mq2;
import com.baidu.tieba.nq2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class h32 extends m73 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public j32 c;
    public ExecutorService d;
    public int e;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ File b;
        public final /* synthetic */ UnitedSchemeEntity c;
        public final /* synthetic */ CallbackHandler d;
        public final /* synthetic */ h32 e;

        public a(h32 h32Var, Context context, File file, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h32Var, context, file, unitedSchemeEntity, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = h32Var;
            this.a = context;
            this.b = file;
            this.c = unitedSchemeEntity;
            this.d = callbackHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                h32 h32Var = this.e;
                h32Var.q(this.a, h32Var.c.b, this.e.c.c, this.b, this.c, this.d);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ File d;
        public final /* synthetic */ UnitedSchemeEntity e;
        public final /* synthetic */ CallbackHandler f;
        public final /* synthetic */ h32 g;

        public b(h32 h32Var, Context context, String str, String str2, File file, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h32Var, context, str, str2, file, unitedSchemeEntity, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = h32Var;
            this.a = context;
            this.b = str;
            this.c = str2;
            this.d = file;
            this.e = unitedSchemeEntity;
            this.f = callbackHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.g.q(this.a, this.b, this.c, this.d, this.e, this.f);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h32(m63 m63Var) {
        super(m63Var, "/swanAPI/wirelessdebuglaunch");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {m63Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final String m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            try {
                return URLEncoder.encode(str, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                if (m73.b) {
                    Log.e("WirelessDebugAction", "url encode fail", e);
                    return str;
                }
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.m73
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, p53 p53Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, p53Var)) == null) {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo != null && optParamsAsJo.length() > 0) {
                j32 e = j32.e(optParamsAsJo);
                this.c = e;
                if (e != null && !e.d()) {
                    l(context, unitedSchemeEntity, callbackHandler);
                    return true;
                }
                if (m73.b) {
                    Log.e("WirelessDebugAction", "Wireless Debug params is invalid");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            p22.c("WirelessDebugAction", "param is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final void l(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler) == null) {
            File b2 = i32.b();
            if (b2.exists()) {
                b2.delete();
            }
            this.d = Executors.newFixedThreadPool(4);
            this.e = 0;
            JSONArray jSONArray = this.c.g;
            if (jSONArray != null && jSONArray.length() > 0) {
                int length = this.c.g.length();
                for (int i = 0; i < length; i++) {
                    String a2 = this.c.a(i);
                    if (TextUtils.isEmpty(a2)) {
                        int i2 = this.e + 1;
                        this.e = i2;
                        if (i2 >= length) {
                            p22.c("WirelessDebugAction", "Hosts are invalid");
                            p(context, com.baidu.mobads.sdk.internal.ci.b);
                        }
                    } else {
                        this.d.execute(new b(this, context, a2, this.c.c(i), b2, unitedSchemeEntity, callbackHandler));
                    }
                }
                return;
            }
            ExecutorUtilsExt.postOnSerial(new a(this, context, b2, unitedSchemeEntity, callbackHandler), "WirelessDebugAction");
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            mq2.a X = o53.K().q().X();
            sc3 sc3Var = new sc3();
            sc3Var.j(X);
            sc3Var.a = ic3.n(X.H());
            sc3Var.b = "launch";
            sc3Var.c = "adb-debug";
            sc3Var.e = DownloadStatisticConstants.UBC_VALUE_DOWNLOAD_FAIL;
            ic3.onEvent(sc3Var);
        }
    }

    public final nq2.a o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return (nq2.a) ((nq2.a) ((nq2.a) new nq2.a().w0(this.c.a)).B0(false)).Q0(this.c.d);
        }
        return (nq2.a) invokeV.objValue;
    }

    public final void p(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, context, str) == null) {
            String string = de3.a().getString("errorURL", "");
            if (TextUtils.isEmpty(string)) {
                h53.g(context, "IPs are invalid ：" + str).G();
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(SchemeConfig.getSchemeHead());
            sb.append("://v1/easybrowse/open?url=");
            sb.append(m(string + "?" + str));
            SchemeRouter.invoke(context, sb.toString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b9, code lost:
        if (r6 >= r4.c.g.length()) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void q(Context context, String str, String str2, File file, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{context, str, str2, file, unitedSchemeEntity, callbackHandler}) == null) {
            try {
                Response executeSync = tc4.g().getRequest().url(str).connectionTimeout(1500).build().executeSync();
                if (executeSync != null && executeSync.code() == 200 && executeSync.body() != null) {
                    vl4.a(executeSync.body().byteStream(), file);
                    Intent h1 = nq2.h1(context, o());
                    h1.putExtra(PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD, this.c.e);
                    h1.putExtra("slavePreload", this.c.f);
                    h1.putExtra("extraWSUrl", str2);
                    context.startActivity(h1);
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    if (this.d != null) {
                        this.d.shutdownNow();
                        this.d = null;
                    }
                    if (!ProcessUtils.isMainProcess()) {
                        if (m73.b) {
                            Log.d("WirelessDebugAction", "Suicide for reload.");
                        }
                        k32.d();
                    }
                }
                if (executeSync != null) {
                    executeSync.close();
                }
            } catch (IOException unused) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                synchronized (this) {
                    if (this.c.g != null) {
                        int i = this.e + 1;
                        this.e = i;
                    }
                    p22.c("WirelessDebugAction", "Host IPs are invalid");
                    p(context, com.baidu.mobads.sdk.internal.ci.b);
                    n();
                }
            }
        }
    }
}
