package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.requester.NadRequester;
import com.baidu.nadcore.requester.RequestParameters;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class dl0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, String> a;

    /* loaded from: classes5.dex */
    public class a implements NadRequester.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h71 a;
        public final /* synthetic */ dl0 b;

        public a(dl0 dl0Var, h71 h71Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dl0Var, h71Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dl0Var;
            this.a = h71Var;
        }

        @Override // com.baidu.nadcore.requester.NadRequester.b
        public void a(@NonNull NadRequester.Error error) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, error) == null) {
                try {
                    this.a.dismiss();
                } catch (Exception unused) {
                }
                this.b.f();
            }
        }

        @Override // com.baidu.nadcore.requester.NadRequester.b
        public void b(@NonNull List<AdBaseModel> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                try {
                    this.a.dismiss();
                } catch (Exception unused) {
                }
                this.b.d(list);
            }
        }
    }

    public dl0(@NonNull Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {map};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = map;
    }

    public final boolean c(AdBaseModel adBaseModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, adBaseModel)) == null) {
            if (adBaseModel != null && !TextUtils.isEmpty(adBaseModel.f.c)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void e(@NonNull h71 h71Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, h71Var, str) == null) {
            RequestParameters.b bVar = new RequestParameters.b();
            bVar.q(str);
            bVar.n(this.a);
            NadRequester.a(bVar.o(), new a(this, h71Var));
        }
    }

    public final void d(@NonNull List<AdBaseModel> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            if (ky0.g(list)) {
                f();
                return;
            }
            AdBaseModel adBaseModel = (AdBaseModel) ky0.d(list, 0);
            if (!c(adBaseModel)) {
                f();
            } else {
                pe0.d(adBaseModel.f.c, gf0.b(), null);
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            v01.a().showToast(gf0.b(), gf0.b().getString(R.string.nad_reward_video_lp_empty));
        }
    }
}
