package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.gamecenter.network.models.ReservationGameInfo;
import com.baidu.swan.gamecenter.network.models.ReservationGameResultData;
import com.baidu.swan.gamecenter.network.models.ResultData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class h44 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Gson a;

    /* loaded from: classes6.dex */
    public class a extends StringResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i44 a;
        public final /* synthetic */ h44 b;

        /* renamed from: com.baidu.tieba.h44$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0322a extends TypeToken<ResultData<ReservationGameResultData>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0322a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }
        }

        public a(h44 h44Var, i44 i44Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h44Var, i44Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = h44Var;
            this.a = i44Var;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            i44 i44Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, exc) == null) && (i44Var = this.a) != null) {
                i44Var.onFail(exc.toString());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(String str, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i) == null) && !TextUtils.isEmpty(str) && this.a != null) {
                ResultData resultData = (ResultData) this.b.a.fromJson(str, new C0322a(this).getType());
                if (resultData == null) {
                    this.a.onFail("result is null");
                } else if (resultData.errno == 0) {
                    T t = resultData.data;
                    if (t != 0 && ((ReservationGameResultData) t).apps != null) {
                        this.a.onSuccess(((ReservationGameResultData) t).apps);
                        return;
                    }
                    this.a.onFail("result data is null");
                } else {
                    i44 i44Var = this.a;
                    if (i44Var != null) {
                        i44Var.onFail(resultData.errmsg);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends StringResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i) == null) {
            }
        }

        public b(h44 h44Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h44Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static final h44 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-795206462, "Lcom/baidu/tieba/h44$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-795206462, "Lcom/baidu/tieba/h44$c;");
                    return;
                }
            }
            a = new h44(null);
        }
    }

    public h44() {
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
        this.a = new Gson();
    }

    public static final h44 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return c.a;
        }
        return (h44) invokeV.objValue;
    }

    public /* synthetic */ h44(a aVar) {
        this();
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (!SwanAppNetworkUtils.i(AppRuntime.getAppContext())) {
                nb3.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f01cc).G();
            } else if (TextUtils.isEmpty(str)) {
            } else {
                String n = m84.b().n();
                xg3 a2 = cv2.q().a();
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("app_id", Long.valueOf(str));
                    zi4.g().getRequest().cookieManager(a2).url(n).addUrlParam("data", jSONObject.toString()).build().executeAsync(new b(this));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void d(i44<List<ReservationGameInfo>> i44Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i44Var) != null) || !SwanAppNetworkUtils.i(AppRuntime.getAppContext())) {
            return;
        }
        String c2 = m84.b().c();
        xg3 a2 = cv2.q().a();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("status", 2);
            zi4.g().getRequest().cookieManager(a2).url(c2).addUrlParam("data", jSONObject.toString()).build().executeAsync(new a(this, i44Var));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
