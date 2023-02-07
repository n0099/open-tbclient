package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.a30;
import com.baidu.tieba.y30;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a40 implements d40 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a40() {
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

    @Override // com.baidu.tieba.d40
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? b30.b().a() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.d40
    public String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) ? a30.f(context.getApplicationContext()).c() : (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.d40
    public JSONArray b(Context context) {
        InterceptResult invokeL;
        T t;
        a30.f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            y30 y30Var = new y30();
            a30.f(context).q(y30Var);
            boolean b = y30Var.b(10000);
            JSONArray jSONArray = new JSONArray();
            if (b) {
                y30.b a = y30Var.a();
                if (a != null && (t = a.a) != 0 && (fVar = (a30.f) t) != null && fVar.b() != null) {
                    for (a30.g gVar : fVar.b()) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("aid", gVar.b);
                            jSONObject.put("pkg", gVar.a);
                            jSONObject.put("priority", gVar.c);
                            jSONArray.put(jSONObject);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else {
                y30Var.c();
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    @Override // com.baidu.tieba.d40
    public String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            y30 y30Var = new y30();
            a30.f(context).m(y30Var);
            if (!y30Var.b(10000)) {
                y30Var.c();
                return null;
            }
            y30.b a = y30Var.a();
            if (a == null || TextUtils.isEmpty((CharSequence) a.a)) {
                return null;
            }
            return (String) a.a;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.d40
    public String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            y30 y30Var = new y30();
            a30.f(context).o(y30Var);
            if (!y30Var.b(10000)) {
                y30Var.c();
                return null;
            }
            y30.b a = y30Var.a();
            if (a == null || TextUtils.isEmpty((CharSequence) a.a)) {
                return null;
            }
            return (String) a.a;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.d40
    public JSONArray e(Context context) {
        InterceptResult invokeL;
        T t;
        List<u50> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
            y30 y30Var = new y30();
            b30.b().e(context, y30Var);
            boolean b = y30Var.b(10000);
            JSONArray jSONArray = new JSONArray();
            if (b) {
                y30.b a = y30Var.a();
                if (a != null && (t = a.a) != 0 && (list = (List) t) != null && list.size() > 0) {
                    for (u50 u50Var : list) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("pkg", u50Var.a);
                            jSONObject.put("sigs", Arrays.toString(u50Var.b));
                            jSONObject.put("vc", u50Var.c);
                            jSONObject.put("va", u50Var.d);
                            jSONObject.put("installts", u50Var.e);
                            jSONObject.put("lstupdatets", u50Var.f);
                            jSONArray.put(jSONObject);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else {
                y30Var.c();
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    @Override // com.baidu.tieba.d40
    public JSONObject f(Context context) {
        InterceptResult invokeL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) {
            y30 y30Var = new y30();
            b30.b().c(context, y30Var);
            boolean b = y30Var.b(10000);
            JSONObject jSONObject = new JSONObject();
            if (b) {
                y30.b a = y30Var.a();
                if (a != null && (t = a.a) != 0) {
                    t50 t50Var = (t50) t;
                }
            } else {
                y30Var.c();
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    @Override // com.baidu.tieba.d40
    public String g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) ? a30.f(context.getApplicationContext()).e() : (String) invokeL.objValue;
    }
}
