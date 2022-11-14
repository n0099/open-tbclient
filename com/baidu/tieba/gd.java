package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Type;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class gd implements cd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, Object> a;

    public gd(Map<String, Object> map) {
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

    @Override // com.baidu.tieba.cd
    public Object a(le leVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, leVar)) == null) {
            Object f = f(leVar);
            if (f != null) {
                if (f instanceof JSONObject) {
                    return f.toString();
                }
                if (f instanceof JSONArray) {
                    return f.toString();
                }
                return f;
            }
            return null;
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.cd
    public Object b(le leVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, leVar)) == null) {
            return this.a;
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.cd
    public Object c(le leVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, leVar)) == null) {
            return this.a;
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.cd
    public Object d(le leVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, leVar)) == null) {
            Object f = f(leVar);
            if (f != null && (f instanceof JSONObject)) {
                return f.toString();
            }
            return null;
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.cd
    public Object e(le leVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, leVar)) == null) {
            return d(leVar);
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.cd
    public Object f(le leVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, leVar)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (this.a == null) {
                return jSONObject;
            }
            Type[] b = leVar.b();
            for (String str : this.a.keySet()) {
                Object obj = this.a.get(str);
                if (b != null && b.length >= 2) {
                    try {
                        jSONObject.put(str, oe.a(obj).f(new le(b[1])));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        jSONObject.put(str, oe.a(obj).f(new le(leVar.a())));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
            return jSONObject;
        }
        return invokeL.objValue;
    }
}
