package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c02 extends a02 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.yz1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "CheckSessionApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class a implements oq3<yg3<JSONObject>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gt1 a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ String c;

        public a(c02 c02Var, gt1 gt1Var, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c02Var, gt1Var, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gt1Var;
            this.b = callbackHandler;
            this.c = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oq3
        /* renamed from: b */
        public void a(yg3<JSONObject> yg3Var) {
            JSONObject wrapCallbackParams;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yg3Var) == null) {
                if (yg3Var.c() && c02.y(yg3Var.a)) {
                    JSONObject optJSONObject = yg3Var.a.optJSONObject("data");
                    if (optJSONObject != null && optJSONObject.optBoolean("result")) {
                        wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(optJSONObject, 0);
                        oi3.T("checkSession", "success");
                    } else {
                        wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(1001, "session key expired");
                        oi3.U("checkSession", "fail", "session key expired");
                    }
                } else {
                    wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(yg3Var.b());
                    this.a.g(this.b, wrapCallbackParams.toString());
                    oi3.U("checkSession", "fail", "result failed");
                }
                this.b.handleSchemeDispatchCallback(this.c, wrapCallbackParams.toString());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c02(@NonNull wz1 wz1Var) {
        super(wz1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wz1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((wz1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static boolean y(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject != null && TextUtils.equals(jSONObject.optString("errno"), "0")) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public v32 x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#checkSession", false);
            oi3.T("checkSession", "create");
            gt1 j = dv2.j();
            CallbackHandler e = a().e();
            vb3 b0 = vb3.b0();
            if (b0 == null) {
                j.g(e, UnitedSchemeUtility.wrapCallbackParams(1001, "swan app is null").toString());
                oi3.U("checkSession", "fail", "empty swanApp");
                return new v32(1001, "swan app is null");
            }
            String O = b0.O();
            if (TextUtils.isEmpty(O)) {
                j.g(e, UnitedSchemeUtility.wrapCallbackParams(1001, "empty app key").toString());
                oi3.U("checkSession", "fail", "empty app key");
                return new v32(1001, "empty app key");
            }
            JSONObject r = yz1.r(str);
            if (r == null) {
                j.g(e, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                oi3.U("checkSession", "fail", "empty joParams");
                return new v32(201, "empty joParams");
            }
            String optString = r.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                j.g(e, UnitedSchemeUtility.wrapCallbackParams(201, "cb is empty").toString());
                oi3.U("checkSession", "fail", "empty cb");
                return new v32(201, "cb is empty");
            }
            Context context = getContext();
            if (!b0.N().e(context)) {
                j.g(e, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                oi3.U("checkSession", "fail", "account not login");
                return new v32(10004, "user not logged in");
            }
            oi3.T("checkSession", "checkSession");
            bh3 g = ub3.K().x().a().b().g(context, O);
            g.q("checkSession");
            g.o(new a(this, j, e, optString));
            g.call();
            return new v32(0);
        }
        return (v32) invokeL.objValue;
    }
}
