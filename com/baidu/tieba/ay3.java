package com.baidu.tieba;

import android.app.Application;
import android.net.Uri;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.tieba.mq2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class ay3 extends vx3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ay3() {
        super("navigateToSwanGame");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.vx3
    public qx1 a(JSONObject paramsJson, ti2 callback) {
        InterceptResult invokeLL;
        boolean z;
        Uri parse;
        mq2.a X;
        String J;
        mq2.a X2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, paramsJson, callback)) == null) {
            Intrinsics.checkNotNullParameter(paramsJson, "paramsJson");
            Intrinsics.checkNotNullParameter(callback, "callback");
            Application c = wo2.c();
            if (c == null) {
                callback.onFail(202, "params may be error");
                return null;
            }
            String optString = paramsJson.optString("appKey");
            boolean z2 = false;
            if (optString != null && optString.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                callback.onFail(202, "params may be error");
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            p53 c0 = p53.c0();
            String str = "";
            jSONObject.put("pre_source", (c0 == null || (X2 = c0.X()) == null || (r8 = X2.U()) == null) ? "" : "");
            p53 c02 = p53.c0();
            if (c02 != null && (X = c02.X()) != null && (J = X.J()) != null) {
                str = J;
            }
            jSONObject.put("pre_appid", str);
            paramsJson.put("ubc", jSONObject);
            String e1 = nq2.e1(optString, 1, paramsJson);
            if ((e1 == null || e1.length() == 0) ? true : true) {
                parse = null;
            } else {
                parse = Uri.parse(e1);
            }
            if (parse == null) {
                callback.onFail(202, "params may be error");
                return null;
            }
            if (SchemeRouter.invokeScheme(c, parse, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE)) {
                callback.onSuccess(null);
            } else {
                callback.onFail(202, "params may be error");
            }
            return null;
        }
        return (qx1) invokeLL.objValue;
    }
}
