package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.tieba.du2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class i64 extends ed3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements du2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i64 a;

        @Override // com.baidu.tieba.du2.c
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        public a(i64 i64Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i64Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i64Var;
        }

        @Override // com.baidu.tieba.du2.c
        public void onFailed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.l(R.string.obfuscated_res_0x7f0f0194);
            }
        }

        @Override // com.baidu.tieba.du2.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                File c = j64.c();
                File b = j64.b();
                if (!c.exists() || !lr4.U(c.getPath(), b.getPath())) {
                    this.a.l(R.string.obfuscated_res_0x7f0f0194);
                } else {
                    this.a.l(R.string.obfuscated_res_0x7f0f0195);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i64(ec3 ec3Var) {
        super(ec3Var, "/swanAPI/debug/dashboardConnect");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ec3Var};
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

    @Override // com.baidu.tieba.ed3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, hb3 hb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, hb3Var)) == null) {
            if (!ed3.b) {
                return false;
            }
            JSONObject a2 = ed3.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                l(R.string.obfuscated_res_0x7f0f0160);
                return false;
            }
            String optString = a2.optString("meterUrl");
            if (TextUtils.isEmpty(optString)) {
                l(R.string.obfuscated_res_0x7f0f0161);
                return false;
            }
            j64.a();
            du2.d dVar = new du2.d();
            dVar.a = k(context, optString);
            new oi2().e(dVar, j64.c().getPath(), new a(this));
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final String k(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str)) == null) {
            String i = ou2.h0().i(context);
            String str2 = new String(y74.g().a("BASE64", (i + "\u0000\u0000").getBytes()));
            String str3 = "?";
            if (str.contains("?")) {
                str3 = "&";
            }
            return str + str3 + "cuid=" + str2;
        }
        return (String) invokeLL.objValue;
    }

    public final void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            Toast.makeText(ou2.c(), i, 1).show();
        }
    }
}
