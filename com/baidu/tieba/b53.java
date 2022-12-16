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
/* loaded from: classes3.dex */
public class b53 extends UnitedSchemeBaseDispatcher {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, b63> a;

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

    public b53() {
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
        List<b63> c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.clear();
            b(new v53(this));
            b(new ov2(this));
            b(new e63(this));
            b(new h53(this));
            b(new hv2(this));
            b(new q53(this));
            b(new ac3(this));
            b(new bc3(this));
            b(new ub3(this));
            b(new vb3(this));
            b(new cc3(this));
            b(new dc3(this));
            b(new xb3(this));
            b(new yb3(this));
            b(new pb3(this));
            b(new qb3(this));
            b(new v83(this));
            b(new u83(this));
            b(new s83(this));
            b(new q83(this));
            b(new p83(this));
            b(new o83(this));
            b(new r83(this));
            b(new y83(this));
            b(new k53(this));
            b(new z53(this));
            b(new ab2(this));
            b(new d63(this));
            b(new s53(this));
            b(new r53(this));
            b(new ee3(this));
            b(new fe3(this));
            b(new rd3(this));
            b(new sd3(this));
            b(new rs2(this));
            b(new u53(this));
            b(new zs2(this));
            b(new tv2(this));
            b(new l53(this));
            b(new b73(this));
            b(new y63(this));
            b(new jw1(this));
            b(new y53(this));
            b(new SwanAppDownloadAction(this));
            b(new c63(this));
            b(new z63(this));
            b(new w63(this));
            b(new v63(this));
            b(new ne3(this));
            b(new oe3(this));
            b(new ae3(this));
            b(new yd3(this));
            b(new td3(this));
            b(new qe3(this));
            b(new ud3(this));
            b(new vd3(this));
            b(new pe3(this));
            b(new vr1(this));
            b(new w83(this));
            b(new xk2(this));
            b(new wr1(this));
            b(new n13(this));
            b(new l13(this));
            b(new o13(this));
            b(new m13(this));
            jl1 d = mn2.d();
            if (d != null && (c = d.c(this)) != null && !c.isEmpty()) {
                for (b63 b63Var : c) {
                    b(b63Var);
                }
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public void b(b63 b63Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b63Var) == null) {
            this.a.put(b63Var.a, b63Var);
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
                            b63 b63Var = this.a.get(str);
                            if (b63Var != null) {
                                if (unitedSchemeEntity.isOnlyVerify()) {
                                    return true;
                                }
                                return b63Var.h(context, unitedSchemeEntity, callbackHandler, "/swanAPI" + uri.getPath());
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
