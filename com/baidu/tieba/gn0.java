package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.BDPTask;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.nadcore.net.request.Headers;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.pyramid.runtime.service.ServiceNotFoundException;
import com.baidu.tieba.qn0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class gn0 extends pj1<qn0> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public class a implements qn0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.baidu.tieba.gn0$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0274a implements hr0<JSONObject> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ rp0 a;
            public final /* synthetic */ qn0.b b;
            public final /* synthetic */ hq0 c;
            public final /* synthetic */ a d;

            @Override // com.baidu.tieba.gr0
            public void c(Headers headers, InputStream inputStream, int i) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, headers, inputStream, i) == null) {
                }
            }

            public C0274a(a aVar, rp0 rp0Var, qn0.b bVar, hq0 hq0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, rp0Var, bVar, hq0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.d = aVar;
                this.a = rp0Var;
                this.b = bVar;
                this.c = hq0Var;
            }

            @Override // com.baidu.tieba.gr0
            public void a(Exception exc, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) {
                    k11.b(new ClogBuilder().y(ClogBuilder.LogType.REWARD_TOKEN_FAIL).u(ClogBuilder.Page.WELFAREMAXLP).p(this.a.f.d));
                    this.b.onFail(exc);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.hr0
            /* renamed from: f */
            public JSONObject d(Headers headers, String str, int i) throws Exception {
                InterceptResult invokeLLI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048581, this, headers, str, i)) == null) {
                    return new JSONObject(str);
                }
                return (JSONObject) invokeLLI.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.hr0
            /* renamed from: e */
            public void b(Headers headers, JSONObject jSONObject, int i) {
                JSONObject optJSONObject;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLI(1048580, this, headers, jSONObject, i) == null) {
                    if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                        this.d.e(optJSONObject.optString("token"), this.a, this.c, this.b);
                        return;
                    }
                    k11.b(new ClogBuilder().y(ClogBuilder.LogType.REWARD_TOKEN_FAIL).u(ClogBuilder.Page.WELFAREMAXLP).p(this.a.f.d));
                    this.b.onFail(new IllegalArgumentException("data: null"));
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements jq {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ qn0.b a;
            public final /* synthetic */ rp0 b;

            public b(a aVar, qn0.b bVar, rp0 rp0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, bVar, rp0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
                this.b = rp0Var;
            }

            @Override // com.baidu.tieba.jq
            public void a(@NonNull TaskResponseData taskResponseData) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, taskResponseData) == null) {
                    try {
                        this.a.a(jn0.b(new JSONObject(taskResponseData.getUi().getExtra())));
                    } catch (Exception e) {
                        k11.b(new ClogBuilder().y(ClogBuilder.LogType.REWARD_COIN_FAIL).u(ClogBuilder.Page.WELFAREMAXLP).p(this.b.f.d).k("1").l("2"));
                        this.a.onFail(e);
                    }
                }
            }

            @Override // com.baidu.tieba.jq
            public void onError(int i, @NonNull String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                    k11.b(new ClogBuilder().y(ClogBuilder.LogType.REWARD_COIN_FAIL).u(ClogBuilder.Page.WELFAREMAXLP).p(this.b.f.d).k("1").l("1").m(String.valueOf(i)));
                    this.a.onFail(new RuntimeException(str));
                }
            }
        }

        public a(gn0 gn0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gn0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public final String d(@Nullable iq0 iq0Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iq0Var)) == null) {
                if (iq0Var != null && !TextUtils.isEmpty(iq0Var.a())) {
                    return iq0Var.a();
                }
                return fn0.a().b();
            }
            return (String) invokeL.objValue;
        }

        @Override // com.baidu.tieba.qn0
        public void a(@NonNull rp0 rp0Var, @NonNull hq0 hq0Var, @NonNull qn0.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, rp0Var, hq0Var, bVar) == null) {
                String A = rp0Var.g().A();
                if (!TextUtils.isEmpty(A)) {
                    e(A, rp0Var, hq0Var, bVar);
                    return;
                }
                ar0 a = wq0.b().a();
                pr0 pr0Var = new pr0();
                pr0Var.l(d(rp0Var.g()));
                pr0Var.h(kr0.c);
                pr0Var.d("User-Agent", hi0.c().a().h());
                a.a(pr0Var, new C0274a(this, rp0Var, bVar, hq0Var));
            }
        }

        @Nullable
        public final JSONObject c(rp0 rp0Var, hq0 hq0Var) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rp0Var, hq0Var)) == null) {
                try {
                    iq0 g = rp0Var.g();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("id_from", g.t());
                    jSONObject.put("logid", g.B());
                    jSONObject.put("session_rewards", hq0Var.a());
                    jSONObject.put("task_policy", g.v());
                    return jSONObject;
                } catch (JSONException unused) {
                    return null;
                }
            }
            return (JSONObject) invokeLL.objValue;
        }

        public final void e(String str, @NonNull rp0 rp0Var, @NonNull hq0 hq0Var, @NonNull qn0.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048579, this, str, rp0Var, hq0Var, bVar) == null) {
                String u = rp0Var.g().u();
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(u)) {
                    BDPTask.m.G(str, u, 0, c(rp0Var, hq0Var), new b(this, bVar, rp0Var));
                    return;
                }
                bVar.onFail(new IllegalArgumentException("token: " + str + " taskId: " + u));
            }
        }
    }

    public gn0() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pj1
    /* renamed from: a */
    public qn0 createService() throws ServiceNotFoundException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new a(this);
        }
        return (qn0) invokeV.objValue;
    }
}
