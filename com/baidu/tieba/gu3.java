package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import com.baidu.tieba.mk4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.IOException;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class gu3 extends kk4<String> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final mk4.a a;

    public gu3(mk4.a aVar) {
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
                return;
            }
        }
        this.a = aVar;
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.a != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.mk4.a
    public void onStart() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && a()) {
            this.a.onStart();
        }
    }

    @Override // com.baidu.tieba.mk4.a
    public void b(String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, jSONObject) == null) && a()) {
            this.a.b(str, str2, jSONObject);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.callback.StatResponseCallback
    /* renamed from: c */
    public String parseResponse(Response response, int i, NetworkStatRecord networkStatRecord) throws Exception {
        InterceptResult invokeLIL;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, response, i, networkStatRecord)) == null) {
            if (response != null && response.body() != null) {
                fu3 l = fu3.l();
                if (TextUtils.equals(response.headers().get("Bdtls"), com.baidu.searchbox.download.model.Constants.RECOVERY_DIRECTORY)) {
                    l.m().s(0);
                    return com.baidu.searchbox.download.model.Constants.RECOVERY_DIRECTORY;
                }
                if (l.k()) {
                    string = l.d.g(response.body().bytes());
                    if (zt3.a) {
                        Log.d("BDTLS", "BdtlsPmsRequest parseResponse=" + string);
                    }
                } else {
                    string = response.body().string();
                }
                b(String.valueOf(response.request().url()), string, networkStatRecord.toUBCJson());
                return string;
            }
            return "";
        }
        return (String) invokeLIL.objValue;
    }

    @Override // com.baidu.searchbox.http.callback.StatResponseCallback, com.baidu.tieba.mk4.a
    public void onFail(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, exc) == null) {
            if (zt3.a) {
                Log.d("BDTLS", "BdtlsPmsRequest onFail = " + exc.getMessage());
            }
            if (a()) {
                this.a.onFail(exc);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.callback.StatResponseCallback
    public void onSuccess(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, str, i) == null) {
            if (zt3.a) {
                Log.d("BDTLS", "BdtlsPmsRequest onSuccess=" + str);
            }
            if (this.a == null) {
                return;
            }
            fu3 l = fu3.l();
            if (TextUtils.equals(str, com.baidu.searchbox.download.model.Constants.RECOVERY_DIRECTORY)) {
                if (l.m().b()) {
                    l.m().a();
                    l.d.i(true);
                    tu3 tu3Var = l.d;
                    if (tu3Var instanceof ru3) {
                        ((ru3) tu3Var).j();
                        return;
                    }
                    return;
                }
                this.a.onFail(new Exception("Exceeded the limit of continuous downgrade"));
                return;
            }
            l.m().k();
            tu3 tu3Var2 = l.d;
            if (tu3Var2 instanceof ru3) {
                ru3 ru3Var = (ru3) tu3Var2;
                if (l.k()) {
                    if (l.d.b == 1) {
                        eu3.a(MimeTypes.BASE_TYPE_APPLICATION);
                        this.a.onSuccess(str, i);
                        ru3Var.h = 0;
                        return;
                    }
                    int i2 = ru3Var.h;
                    ru3Var.h = i2 + 1;
                    if (i2 < 3) {
                        ru3Var.j();
                        return;
                    }
                    mk4.a aVar = this.a;
                    aVar.onFail(new IOException("request fail : " + str));
                    ru3Var.h = 0;
                    return;
                }
                this.a.onSuccess(str, i);
                ru3Var.h = 0;
            }
        }
    }
}
