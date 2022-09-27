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
/* loaded from: classes4.dex */
public class i43 extends UnitedSchemeBaseDispatcher {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, i53> a;

    public i43() {
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
        List<i53> c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.clear();
            b(new c53(this));
            b(new vu2(this));
            b(new l53(this));
            b(new o43(this));
            b(new ou2(this));
            b(new x43(this));
            b(new hb3(this));
            b(new ib3(this));
            b(new bb3(this));
            b(new cb3(this));
            b(new jb3(this));
            b(new kb3(this));
            b(new eb3(this));
            b(new fb3(this));
            b(new wa3(this));
            b(new xa3(this));
            b(new c83(this));
            b(new b83(this));
            b(new z73(this));
            b(new x73(this));
            b(new w73(this));
            b(new v73(this));
            b(new y73(this));
            b(new f83(this));
            b(new r43(this));
            b(new g53(this));
            b(new ha2(this));
            b(new k53(this));
            b(new z43(this));
            b(new y43(this));
            b(new ld3(this));
            b(new md3(this));
            b(new yc3(this));
            b(new zc3(this));
            b(new yr2(this));
            b(new b53(this));
            b(new gs2(this));
            b(new av2(this));
            b(new s43(this));
            b(new i63(this));
            b(new f63(this));
            b(new qv1(this));
            b(new f53(this));
            b(new SwanAppDownloadAction(this));
            b(new j53(this));
            b(new g63(this));
            b(new d63(this));
            b(new c63(this));
            b(new ud3(this));
            b(new vd3(this));
            b(new hd3(this));
            b(new fd3(this));
            b(new ad3(this));
            b(new xd3(this));
            b(new bd3(this));
            b(new cd3(this));
            b(new wd3(this));
            b(new cr1(this));
            b(new d83(this));
            b(new ek2(this));
            b(new dr1(this));
            b(new u03(this));
            b(new s03(this));
            b(new v03(this));
            b(new t03(this));
            qk1 d = tm2.d();
            if (d == null || (c = d.c(this)) == null || c.isEmpty()) {
                return;
            }
            for (i53 i53Var : c) {
                b(i53Var);
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public void b(i53 i53Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i53Var) == null) {
            this.a.put(i53Var.a, i53Var);
        }
    }

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
                        if (str.isEmpty() || str.length() < str2.length()) {
                            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302, "err path ：" + str + " @ " + str2);
                            return false;
                        }
                        i53 i53Var = this.a.get(str);
                        if (i53Var != null) {
                            if (unitedSchemeEntity.isOnlyVerify()) {
                                return true;
                            }
                            return i53Var.h(context, unitedSchemeEntity, callbackHandler, "/swanAPI" + uri.getPath());
                        }
                        str = str.substring(0, str.length() - str2.length());
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
