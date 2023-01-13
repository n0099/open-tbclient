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
public class fd implements dd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<?> a;

    public fd(List<?> list) {
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

    @Override // com.baidu.tieba.dd
    public Object a(me meVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, meVar)) == null) {
            Object f = f(meVar);
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

    @Override // com.baidu.tieba.dd
    public Object b(me meVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, meVar)) == null) {
            return this.a;
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.dd
    public Object c(me meVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, meVar)) == null) {
            return this.a;
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.dd
    public Object e(me meVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, meVar)) == null) {
            return d(meVar);
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.dd
    public Object d(me meVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, meVar)) == null) {
            Type[] b = meVar.b();
            ArrayList arrayList = new ArrayList();
            for (Object obj : this.a) {
                if (obj != null) {
                    if (b != null && b.length >= 1) {
                        Object f = pe.a(obj).f(new me(b[0]));
                        if (f != null) {
                            arrayList.add(f.toString());
                        }
                    } else {
                        Object f2 = pe.a(obj).f(new me(meVar.a()));
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

    @Override // com.baidu.tieba.dd
    public Object f(me meVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, meVar)) == null) {
            Type[] b = meVar.b();
            JSONArray jSONArray = new JSONArray();
            for (Object obj : this.a) {
                if (obj != null) {
                    if (b != null && b.length >= 1) {
                        Object f = pe.a(obj).f(new me(b[0]));
                        if (f != null) {
                            jSONArray.put(f);
                        }
                    } else {
                        Object f2 = pe.a(obj).f(new me(meVar.a()));
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
