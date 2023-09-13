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
public class ec3 extends UnitedSchemeBaseDispatcher {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, ed3> a;

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

    public ec3() {
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
        List<ed3> c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.clear();
            b(new yc3(this));
            b(new r23(this));
            b(new hd3(this));
            b(new kc3(this));
            b(new k23(this));
            b(new tc3(this));
            b(new dj3(this));
            b(new ej3(this));
            b(new xi3(this));
            b(new yi3(this));
            b(new fj3(this));
            b(new gj3(this));
            b(new aj3(this));
            b(new bj3(this));
            b(new si3(this));
            b(new ti3(this));
            b(new yf3(this));
            b(new xf3(this));
            b(new vf3(this));
            b(new tf3(this));
            b(new sf3(this));
            b(new rf3(this));
            b(new uf3(this));
            b(new bg3(this));
            b(new nc3(this));
            b(new cd3(this));
            b(new di2(this));
            b(new gd3(this));
            b(new vc3(this));
            b(new uc3(this));
            b(new hl3(this));
            b(new il3(this));
            b(new uk3(this));
            b(new vk3(this));
            b(new uz2(this));
            b(new xc3(this));
            b(new c03(this));
            b(new w23(this));
            b(new oc3(this));
            b(new ee3(this));
            b(new be3(this));
            b(new m32(this));
            b(new bd3(this));
            b(new SwanAppDownloadAction(this));
            b(new fd3(this));
            b(new ce3(this));
            b(new zd3(this));
            b(new yd3(this));
            b(new ql3(this));
            b(new rl3(this));
            b(new dl3(this));
            b(new bl3(this));
            b(new wk3(this));
            b(new tl3(this));
            b(new xk3(this));
            b(new yk3(this));
            b(new sl3(this));
            b(new yy1(this));
            b(new zf3(this));
            b(new as2(this));
            b(new zy1(this));
            b(new q83(this));
            b(new o83(this));
            b(new r83(this));
            b(new p83(this));
            ms1 d = pu2.d();
            if (d != null && (c = d.c(this)) != null && !c.isEmpty()) {
                for (ed3 ed3Var : c) {
                    b(ed3Var);
                }
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public void b(ed3 ed3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ed3Var) == null) {
            this.a.put(ed3Var.a, ed3Var);
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
                            ed3 ed3Var = this.a.get(str);
                            if (ed3Var != null) {
                                if (unitedSchemeEntity.isOnlyVerify()) {
                                    return true;
                                }
                                return ed3Var.h(context, unitedSchemeEntity, callbackHandler, "/swanAPI" + uri.getPath());
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
