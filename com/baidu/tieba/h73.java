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
/* loaded from: classes6.dex */
public class h73 extends UnitedSchemeBaseDispatcher {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, h83> a;

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

    public h73() {
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
        List<h83> c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.clear();
            b(new b83(this));
            b(new ux2(this));
            b(new k83(this));
            b(new n73(this));
            b(new nx2(this));
            b(new w73(this));
            b(new ge3(this));
            b(new he3(this));
            b(new ae3(this));
            b(new be3(this));
            b(new ie3(this));
            b(new je3(this));
            b(new de3(this));
            b(new ee3(this));
            b(new vd3(this));
            b(new wd3(this));
            b(new bb3(this));
            b(new ab3(this));
            b(new ya3(this));
            b(new wa3(this));
            b(new va3(this));
            b(new ua3(this));
            b(new xa3(this));
            b(new eb3(this));
            b(new q73(this));
            b(new f83(this));
            b(new gd2(this));
            b(new j83(this));
            b(new y73(this));
            b(new x73(this));
            b(new kg3(this));
            b(new lg3(this));
            b(new xf3(this));
            b(new yf3(this));
            b(new xu2(this));
            b(new a83(this));
            b(new fv2(this));
            b(new zx2(this));
            b(new r73(this));
            b(new h93(this));
            b(new e93(this));
            b(new qy1(this));
            b(new e83(this));
            b(new SwanAppDownloadAction(this));
            b(new i83(this));
            b(new f93(this));
            b(new c93(this));
            b(new b93(this));
            b(new tg3(this));
            b(new ug3(this));
            b(new gg3(this));
            b(new eg3(this));
            b(new zf3(this));
            b(new wg3(this));
            b(new ag3(this));
            b(new bg3(this));
            b(new vg3(this));
            b(new cu1(this));
            b(new cb3(this));
            b(new dn2(this));
            b(new du1(this));
            b(new t33(this));
            b(new r33(this));
            b(new u33(this));
            b(new s33(this));
            qn1 d = sp2.d();
            if (d != null && (c = d.c(this)) != null && !c.isEmpty()) {
                for (h83 h83Var : c) {
                    b(h83Var);
                }
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public void b(h83 h83Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h83Var) == null) {
            this.a.put(h83Var.a, h83Var);
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
                            h83 h83Var = this.a.get(str);
                            if (h83Var != null) {
                                if (unitedSchemeEntity.isOnlyVerify()) {
                                    return true;
                                }
                                return h83Var.h(context, unitedSchemeEntity, callbackHandler, "/swanAPI" + uri.getPath());
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
