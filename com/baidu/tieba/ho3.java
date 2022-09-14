package com.baidu.tieba;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.apps.alliance.login.SwanAppAllianceLoginHelper;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.a94;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.AbstractBceClient;
import java.util.List;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes4.dex */
public class ho3 extends ql1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public class a extends ResponseCallback<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g94 a;
        public final /* synthetic */ ho3 b;

        public a(ho3 ho3Var, g94 g94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ho3Var, g94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ho3Var;
            this.a = g94Var;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                this.b.v();
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i) == null) {
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, response, i)) == null) {
                this.b.x(response, this.a);
                return response;
            }
            return invokeLI.objValue;
        }
    }

    public ho3() {
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

    @Override // com.baidu.tieba.ql1, com.baidu.tieba.a94
    public void d(int i, List<g94> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, list) == null) {
            super.d(i, list);
            if (i == 12 || i == 15 || i == 17 || i == 18) {
                r(list);
                if ("wYub6F7RD2tEngaTnOQPBEbYXx5s4Y3y".equals(x23.K().getAppId()) || "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u".equals(x23.K().getAppId()) || !fm2.L().a()) {
                    return;
                }
                o(list);
            }
        }
    }

    @Override // com.baidu.tieba.a94
    public void f(int i, List<g94> list, a94.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, list, aVar) == null) {
            aVar.a(40);
        }
    }

    @Override // com.baidu.tieba.a94
    public void i(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
        }
    }

    @Override // com.baidu.tieba.ql1, com.baidu.tieba.a94
    public boolean j(g94 g94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, g94Var)) == null) {
            int c = g94Var.c();
            if (c == 40) {
                u(g94Var);
            } else if (c == 45) {
                t(g94Var);
            }
            return super.j(g94Var);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.a94
    public boolean k(boolean z, int i) {
        InterceptResult invokeCommon;
        y23 b0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (sg3.Q()) {
                Context appContext = AppRuntime.getAppContext();
                if (er1.y(appContext) && (b0 = y23.b0()) != null && b0.N().e(appContext)) {
                    PMSAppInfo f0 = b0.W().f0();
                    return (b0.w0() || f0 == null || TextUtils.isEmpty(f0.paNumber)) ? false : true;
                }
                return false;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public void o(List<g94> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, list) == null) || list == null) {
            return;
        }
        list.add(new g94(40, R.string.obfuscated_res_0x7f0f00f5, R.drawable.obfuscated_res_0x7f0800f2, true));
    }

    public final Uri p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            String schemeHead = SchemeConfig.getSchemeHead();
            if (TextUtils.isEmpty(schemeHead)) {
                schemeHead = "baiduboxapp";
            }
            buildUpon.scheme(schemeHead);
            return buildUpon.build();
        }
        return (Uri) invokeL.objValue;
    }

    public final void q(g94 g94Var) {
        y23 b0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, g94Var) == null) || (b0 = y23.b0()) == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        yf3.f(jSONObject, GameGuideConfigInfo.KEY_APP_KEY, b0.getAppId());
        yf3.f(jSONObject, "srcAppPage", ys2.b(sg3.n()));
        JSONObject jSONObject2 = new JSONObject();
        yf3.f(jSONObject2, "appKey", "pjwYb22xF6hUcKpZKsiqvnhUhsoUvLfT");
        yf3.f(jSONObject2, "path", "pages/conversation/index");
        yf3.f(jSONObject2, PrefetchEvent.EVENT_DATA_EXTRA_DATA, s(b0));
        yf3.f(jSONObject, "params", jSONObject2);
        String I = fm2.o().I();
        ba4 ba4Var = new ba4(I, new Request.Builder().url(I).post(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject.toString())).build().body(), new a(this, g94Var));
        ba4Var.f = true;
        ba4Var.g = false;
        ba4Var.h = true;
        ca4.g().e(ba4Var);
    }

    public final void r(List<g94> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) && list != null && sg3.Q() && er1.y(AppRuntime.getAppContext())) {
            list.add(new g94(45, R.string.obfuscated_res_0x7f0f1269, R.drawable.obfuscated_res_0x7f0800df, true));
        }
    }

    public final JSONObject s(y23 y23Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, y23Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            PMSAppInfo f0 = y23Var.W().f0();
            yf3.f(jSONObject, "appname", f0.appName);
            yf3.f(jSONObject, "iconUrl", f0.iconUrl);
            yf3.f(jSONObject, BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, f0.appKey);
            yf3.f(jSONObject, "pa", f0.paNumber);
            yf3.f(jSONObject, "isBaiduSeries", Boolean.valueOf(SwanAppAllianceLoginHelper.d.h()));
            yf3.f(jSONObject, "isOpenCustomerService", Boolean.valueOf(sg3.Q()));
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public final void t(g94 g94Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, g94Var) == null) || y23.b0() == null) {
            return;
        }
        q(g94Var);
    }

    public final void u(g94 g94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, g94Var) == null) {
            os2.o("appletCenter");
            bp3.a(SchemeConfig.getSchemeHead() + "://swan/wYub6F7RD2tEngaTnOQPBEbYXx5s4Y3y?_baiduboxapp={\"from\":\"1271009000000000\",\"ext\":{}}&callback=_bdbox_js_275&upgrade=0");
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    public final void w(g94 g94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, g94Var) == null) {
            fm2.i().d();
            ws2.j(g94Var);
            os2.q("customerService", String.valueOf(g94Var.e() > 0 ? 1 : 0), "click");
            ws2.i();
        }
    }

    public final void x(Response response, g94 g94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, response, g94Var) == null) {
            try {
                if (!response.isSuccessful()) {
                    v();
                    return;
                }
                JSONObject jSONObject = new JSONObject(response.body().string());
                if (!TextUtils.equals(jSONObject.optString("errno"), "0")) {
                    v();
                    return;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject == null) {
                    v();
                    return;
                }
                Uri p = p(optJSONObject.optString("scheme"));
                if (p == null) {
                    v();
                } else if (SchemeRouter.invokeScheme(AppRuntime.getAppContext(), p, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE)) {
                    w(g94Var);
                }
            } catch (Exception unused) {
                v();
            }
        }
    }
}
