package com.baidu.tieba;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.dns.transmit.model.DnsModel;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.tieba.lo2;
import com.baidu.tieba.mq2;
import com.baidu.tieba.nq2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class fq2 extends m73 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public interface e {
        void a();

        void b();
    }

    /* loaded from: classes6.dex */
    public class a implements ed4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ JSONObject b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ Context e;
        public final /* synthetic */ UnitedSchemeEntity f;
        public final /* synthetic */ CallbackHandler g;
        public final /* synthetic */ p53 h;
        public final /* synthetic */ fq2 i;

        public a(fq2 fq2Var, String str, JSONObject jSONObject, String str2, String str3, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, p53 p53Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fq2Var, str, jSONObject, str2, str3, context, unitedSchemeEntity, callbackHandler, p53Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = fq2Var;
            this.a = str;
            this.b = jSONObject;
            this.c = str2;
            this.d = str3;
            this.e = context;
            this.f = unitedSchemeEntity;
            this.g = callbackHandler;
            this.h = p53Var;
        }

        @Override // com.baidu.tieba.ed4
        public void a(@Nullable Map<String, String> map) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, map) != null) || map == null) {
                return;
            }
            String str = map.get(this.a);
            if (TextUtils.isEmpty(str)) {
                str = this.a;
            }
            this.i.o(this.b, this.c, this.d, this.e, this.f, str, this.g, this.h);
        }

        @Override // com.baidu.tieba.ed4
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                if (m73.b) {
                    Log.e("LaunchAction", "getOpenBundleId", exc);
                }
                this.f.result = UnitedSchemeUtility.wrapCallbackParams(201);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements lo2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nq2.a a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ CallbackHandler d;
        public final /* synthetic */ UnitedSchemeEntity e;
        public final /* synthetic */ String f;

        @Override // com.baidu.tieba.lo2.c
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        public b(fq2 fq2Var, nq2.a aVar, String str, String str2, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fq2Var, aVar, str, str2, callbackHandler, unitedSchemeEntity, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
            this.b = str;
            this.c = str2;
            this.d = callbackHandler;
            this.e = unitedSchemeEntity;
            this.f = str3;
        }

        @Override // com.baidu.tieba.lo2.c
        public void onFailed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                ih3 ih3Var = new ih3();
                ih3Var.k(7L);
                ih3Var.i(9L);
                ih3Var.f("debug download pkg fail");
                mh3.a().f(ih3Var);
                jq2.e(wo2.c(), ih3Var, 0, this.c);
                qc3 qc3Var = new qc3();
                qc3Var.p(ih3Var);
                qc3Var.r(this.a);
                ic3.R(qc3Var);
                this.e.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            }
        }

        @Override // com.baidu.tieba.lo2.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                ((nq2.a) this.a.B0(true)).b1("1.6.0");
                SwanLauncher.j().n(this.a, null);
                fq2.n(this.b, this.c, this.d, this.e, this.f);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ UnitedSchemeEntity b;
        public final /* synthetic */ String c;

        public c(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {callbackHandler, unitedSchemeEntity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = callbackHandler;
            this.b = unitedSchemeEntity;
            this.c = str;
        }

        @Override // com.baidu.tieba.fq2.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            fq2.m(this.a, this.b, this.c, 1001);
        }

        @Override // com.baidu.tieba.fq2.e
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                return;
            }
            fq2.m(this.a, this.b, this.c, 0);
        }
    }

    /* loaded from: classes6.dex */
    public static class d extends v13 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e c;

        public d(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.v13, com.baidu.tieba.w13, com.baidu.tieba.u13
        public void onEvent(@NonNull s13 s13Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, s13Var) == null) {
                if (s13Var.a() != null && s13Var.a().getInt(DnsModel.MSG_OK) == 0) {
                    e eVar = this.c;
                    if (eVar != null) {
                        eVar.b();
                        return;
                    }
                    return;
                }
                e eVar2 = this.c;
                if (eVar2 != null) {
                    eVar2.a();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fq2(m63 m63Var) {
        super(m63Var, "/swanAPI/launch");
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

    public static void m(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(InputDeviceCompat.SOURCE_TRACKBALL, null, callbackHandler, unitedSchemeEntity, str, i) == null) {
            if (TextUtils.isEmpty(str)) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(i));
            } else {
                UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(i).toString(), str);
            }
        }
    }

    public static void n(String str, String str2, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65541, null, str, str2, callbackHandler, unitedSchemeEntity, str3) == null) {
            if (!TextUtils.isEmpty(str3)) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            }
            if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str3)) {
                c cVar = new c(callbackHandler, unitedSchemeEntity, str3);
                if (ProcessUtils.isMainProcess()) {
                    gq2.j(str2, cVar);
                } else {
                    p(str2, cVar);
                }
            }
        }
    }

    public static void p(String str, e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65542, null, str, eVar) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("desAppId", str);
        o53.K().y().X(bundle, gq2.class, new d(eVar));
    }

    @Override // com.baidu.tieba.m73
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, p53 p53Var) {
        InterceptResult invokeLLLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, p53Var)) == null) {
            p22.b("LaunchAction", "handle entity: ", unitedSchemeEntity);
            if (unitedSchemeEntity.getUri() == null) {
                str = "";
            } else {
                str = unitedSchemeEntity.getUri().toString();
            }
            p22.i("LaunchAction", "launch scheme = " + str);
            HashMap<String, String> params = unitedSchemeEntity.getParams();
            String str2 = params.get("params");
            String str3 = params.get("from");
            if (TextUtils.isEmpty(str2)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                ih3 ih3Var = new ih3();
                ih3Var.k(1L);
                ih3Var.i(1L);
                ih3Var.f("paramsValue is empty");
                mh3.a().f(ih3Var);
                jq2.e(context, ih3Var, 0, "");
                qc3 qc3Var = new qc3();
                qc3Var.p(ih3Var);
                qc3Var.t(str3);
                qc3Var.l("scheme", str);
                ic3.R(qc3Var);
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(str2);
                String optString = jSONObject.optString("appid");
                String optString2 = jSONObject.optString("navi");
                if (TextUtils.isEmpty(optString)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    ih3 ih3Var2 = new ih3();
                    ih3Var2.k(1L);
                    ih3Var2.i(1L);
                    ih3Var2.f("appId is empty");
                    mh3.a().f(ih3Var2);
                    jq2.e(context, ih3Var2, 0, "");
                    qc3 qc3Var2 = new qc3();
                    qc3Var2.p(ih3Var2);
                    qc3Var2.t(str3);
                    qc3Var2.l("scheme", str);
                    ic3.R(qc3Var2);
                    return false;
                } else if (ei4.e().g(!jj3.G()) && TextUtils.equals(optString2, "naviTo")) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(optString);
                    zc4.e(arrayList, o53.K().q().P(), new a(this, optString, jSONObject, str3, str, context, unitedSchemeEntity, callbackHandler, p53Var));
                    return true;
                } else {
                    return o(jSONObject, str3, str, context, unitedSchemeEntity, optString, callbackHandler, p53Var);
                }
            } catch (JSONException e2) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                ih3 ih3Var3 = new ih3();
                ih3Var3.k(1L);
                ih3Var3.i(1L);
                ih3Var3.f("parse paramsValue with JSONException:" + e2.getMessage());
                mh3.a().f(ih3Var3);
                jq2.e(context, ih3Var3, 0, "");
                qc3 qc3Var3 = new qc3();
                qc3Var3.p(ih3Var3);
                qc3Var3.t(str3);
                qc3Var3.l("scheme", str);
                ic3.R(qc3Var3);
                return false;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean o(JSONObject jSONObject, String str, String str2, Context context, UnitedSchemeEntity unitedSchemeEntity, String str3, CallbackHandler callbackHandler, p53 p53Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{jSONObject, str, str2, context, unitedSchemeEntity, str3, callbackHandler, p53Var})) == null) {
            String h = SwanLauncher.h();
            o53.K().q().X().K0(h);
            String optString = jSONObject.optString("url");
            String optString2 = jSONObject.optString(PrefetchEvent.EVENT_DATA_EXTRA_DATA);
            String optString3 = jSONObject.optString("downloadurl");
            String optString4 = jSONObject.optString("clkid");
            String optString5 = jSONObject.optString("notinhis");
            String optString6 = jSONObject.optString("cb");
            String optString7 = jSONObject.optString("navi");
            nq2.a aVar = (nq2.a) ((nq2.a) ((nq2.a) ((nq2.a) ((nq2.a) ((nq2.a) ((nq2.a) new nq2.a().w0(str3)).S0(optString)).J0(str)).L0(str2)).z0(optString4)).Q0(optString5)).K0(h);
            if (p53Var != null && !TextUtils.isEmpty(optString7)) {
                aVar.s0(PrefetchEvent.EVENT_DATA_EXTRA_DATA, optString2);
                aVar.s0("navi", optString7);
                mq2.a Z = p53Var.Z();
                if (Z == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                String I = Z.I();
                if (sx1.e(Z) && !sx1.f(str3)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
                aVar.s0("srcAppId", I);
                aVar.s0("srcAppKey", Z.J());
                aVar.r0("srcPkgType", Z.w1());
                aVar.s0("srcAppPage", jj3.n().e());
            }
            if (m73.b && !TextUtils.isEmpty(optString3)) {
                lo2.d dVar = new lo2.d();
                dVar.a = optString3;
                lo2.K(dVar, new b(this, aVar, optString7, str3, callbackHandler, unitedSchemeEntity, optString6));
                return true;
            } else if (TextUtils.isEmpty(optString3)) {
                aVar.B0(false);
                SwanLauncher.j().n(aVar, null);
                n(optString7, str3, callbackHandler, unitedSchemeEntity, optString6);
                return true;
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                ih3 ih3Var = new ih3();
                ih3Var.k(1L);
                ih3Var.i(1L);
                ih3Var.f("release but downloadUrl is not empty");
                mh3.a().f(ih3Var);
                jq2.e(context, ih3Var, 0, str3);
                qc3 qc3Var = new qc3();
                qc3Var.t(str);
                qc3Var.m(str3);
                qc3Var.r(aVar);
                qc3Var.l("scheme", str2);
                ic3.R(qc3Var);
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }
}
