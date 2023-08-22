package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeAbsDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class ac3 extends UnitedSchemeBaseDispatcher {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, ad3> a;

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public String getDispatcherName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "swanAPI" : (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public Class<? extends UnitedSchemeAbsDispatcher> getSubDispatcher(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            return null;
        }
        return (Class) invokeL.objValue;
    }

    public ac3() {
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
        this.a = new HashMap();
        a();
    }

    public void a() {
        List<ad3> c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.clear();
            b(new uc3(this));
            b(new n23(this));
            b(new dd3(this));
            b(new gc3(this));
            b(new g23(this));
            b(new pc3(this));
            b(new zi3(this));
            b(new aj3(this));
            b(new ti3(this));
            b(new ui3(this));
            b(new bj3(this));
            b(new cj3(this));
            b(new wi3(this));
            b(new xi3(this));
            b(new oi3(this));
            b(new pi3(this));
            b(new uf3(this));
            b(new tf3(this));
            b(new rf3(this));
            b(new pf3(this));
            b(new of3(this));
            b(new nf3(this));
            b(new qf3(this));
            b(new xf3(this));
            b(new jc3(this));
            b(new yc3(this));
            b(new zh2(this));
            b(new cd3(this));
            b(new rc3(this));
            b(new qc3(this));
            b(new dl3(this));
            b(new el3(this));
            b(new qk3(this));
            b(new rk3(this));
            b(new qz2(this));
            b(new tc3(this));
            b(new yz2(this));
            b(new s23(this));
            b(new kc3(this));
            b(new ae3(this));
            b(new xd3(this));
            b(new i32(this));
            b(new xc3(this));
            b(new SwanAppDownloadAction(this));
            b(new bd3(this));
            b(new yd3(this));
            b(new vd3(this));
            b(new ud3(this));
            b(new ml3(this));
            b(new nl3(this));
            b(new zk3(this));
            b(new xk3(this));
            b(new sk3(this));
            b(new pl3(this));
            b(new tk3(this));
            b(new uk3(this));
            b(new ol3(this));
            b(new uy1(this));
            b(new vf3(this));
            b(new wr2(this));
            b(new vy1(this));
            b(new m83(this));
            b(new k83(this));
            b(new n83(this));
            b(new l83(this));
            is1 d = lu2.d();
            if (d != null && (c = d.c(this)) != null && !c.isEmpty()) {
                for (ad3 ad3Var : c) {
                    b(ad3Var);
                }
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public void b(ad3 ad3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ad3Var) == null) {
            this.a.put(ad3Var.a, ad3Var);
        }
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public boolean invoke(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, context, unitedSchemeEntity, callbackHandler)) == null) {
            Uri uri = unitedSchemeEntity.getUri();
            if (uri == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty url");
                return false;
            } else if (uri.getPathSegments() != null && !uri.getPathSegments().isEmpty()) {
                ArrayList arrayList = new ArrayList();
                arrayList.add("swanAPI");
                arrayList.addAll(uri.getPathSegments());
                String str = "/swanAPI" + uri.getPath();
                if (!TextUtils.isEmpty(str) && str.startsWith("/")) {
                    for (int size = arrayList.size(); size > 0; size--) {
                        String str2 = "/" + ((String) arrayList.get(size - 1));
                        if (!str.isEmpty() && str.length() >= str2.length()) {
                            ad3 ad3Var = this.a.get(str);
                            if (ad3Var != null) {
                                if (unitedSchemeEntity.isOnlyVerify()) {
                                    return true;
                                }
                                return ad3Var.h(context, unitedSchemeEntity, callbackHandler, "/swanAPI" + uri.getPath());
                            }
                            str = str.substring(0, str.length() - str2.length());
                        } else {
                            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302, "err path ：" + str + " @ " + str2);
                            return false;
                        }
                    }
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302, "not support such action ：" + uri.getPath());
                    return false;
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302, "err path ：" + str);
                return false;
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty Segment");
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }
}
