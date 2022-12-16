package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ed implements cd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<?> a;

    public ed(List<?> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = list;
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
    public Object e(le leVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, leVar)) == null) {
            return d(leVar);
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.cd
    public Object d(le leVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, leVar)) == null) {
            Type[] b = leVar.b();
            ArrayList arrayList = new ArrayList();
            for (Object obj : this.a) {
                if (obj != null) {
                    if (b != null && b.length >= 1) {
                        Object f = oe.a(obj).f(new le(b[0]));
                        if (f != null) {
                            arrayList.add(f.toString());
                        }
                    } else {
                        Object f2 = oe.a(obj).f(new le(leVar.a()));
                        if (f2 != null) {
                            arrayList.add(f2.toString());
                        }
                    }
                }
            }
            return arrayList;
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.cd
    public Object f(le leVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, leVar)) == null) {
            Type[] b = leVar.b();
            JSONArray jSONArray = new JSONArray();
            for (Object obj : this.a) {
                if (obj != null) {
                    if (b != null && b.length >= 1) {
                        Object f = oe.a(obj).f(new le(b[0]));
                        if (f != null) {
                            jSONArray.put(f);
                        }
                    } else {
                        Object f2 = oe.a(obj).f(new le(leVar.a()));
                        if (f2 != null) {
                            jSONArray.put(f2);
                        }
                    }
                }
            }
            return jSONArray;
        }
        return invokeL.objValue;
    }
}
