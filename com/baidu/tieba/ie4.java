package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ie4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public interface b {
        void a(JSONObject jSONObject);
    }

    /* loaded from: classes6.dex */
    public class a implements aq3<tg3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(ie4 ie4Var, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ie4Var, bVar};
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
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.aq3
        /* renamed from: b */
        public void a(tg3 tg3Var) {
            JSONObject jSONObject;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tg3Var) == null) {
                if (tg3Var != null && (jSONObject = tg3Var.g) != null) {
                    h82.b("OpenData", "onOpenDataCallback success: ", jSONObject);
                    this.a.a(tg3Var.g);
                    return;
                }
                this.a.a(null);
            }
        }
    }

    public ie4() {
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

    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, bVar) != null) || bVar == null || uw2.T().getActivity() == null) {
            return;
        }
        tg3.B(uw2.T().getActivity(), "snsapi_userinfo", null, true, "GameUserInfoRequest", new a(this, bVar));
    }
}
