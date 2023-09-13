package com.baidu.tieba;

import android.util.SparseArray;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import org.json.JSONArray;
/* loaded from: classes6.dex */
public class id implements gd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public JSONArray a;

    public id(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONArray};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = jSONArray;
    }

    @Override // com.baidu.tieba.gd
    public Object a(wd wdVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, wdVar)) == null) {
            Class<?> a = wdVar.a();
            Type[] b = wdVar.b();
            if (a.isArray()) {
                Class<?> componentType = a.getComponentType();
                Object newInstance = Array.newInstance(componentType, this.a.length());
                int length = this.a.length();
                for (int i = 0; i < length; i++) {
                    Object a2 = ae.a(this.a.opt(i)).a(new wd(componentType));
                    if (a2 != null) {
                        Array.set(newInstance, i, a2);
                    }
                }
                return newInstance;
            } else if (b != null && b.length >= 1) {
                if (dc.e(a, List.class)) {
                    List<Object> a3 = ud.a(wdVar, this.a.length());
                    if (a3 != null) {
                        int length2 = this.a.length();
                        for (int i2 = 0; i2 < length2; i2++) {
                            Object a4 = ae.a(this.a.opt(i2)).a(new wd(b[0]));
                            if (a4 != null) {
                                a3.add(a4);
                            }
                        }
                    }
                    return a3;
                } else if (dc.e(a, Set.class)) {
                    Set<Object> d = ud.d(wdVar, this.a.length());
                    if (d != null) {
                        int length3 = this.a.length();
                        for (int i3 = 0; i3 < length3; i3++) {
                            Object a5 = ae.a(this.a.opt(i3)).a(new wd(b[0]));
                            if (a5 != null) {
                                d.add(a5);
                            }
                        }
                    }
                    return d;
                } else if (dc.e(a, Map.class)) {
                    Map<String, Object> b2 = ud.b(wdVar, this.a.length());
                    if (b2 != null) {
                        int length4 = this.a.length();
                        for (int i4 = 0; i4 < length4; i4++) {
                            Object a6 = ae.a(this.a.opt(i4)).a(new wd(b[0]));
                            if (a6 != null) {
                                b2.put(String.valueOf(i4), a6);
                            }
                        }
                    }
                    return b2;
                } else if (dc.e(a, Queue.class)) {
                    Queue<Object> c = ud.c(wdVar, this.a.length());
                    if (c != null) {
                        int length5 = this.a.length();
                        for (int i5 = 0; i5 < length5; i5++) {
                            Object a7 = ae.a(this.a.opt(i5)).a(new wd(b[0]));
                            if (a7 != null) {
                                c.add(a7);
                            }
                        }
                    }
                    return c;
                } else if (a == SparseArray.class) {
                    SparseArray sparseArray = new SparseArray(this.a.length());
                    int length6 = this.a.length();
                    for (int i6 = 0; i6 < length6; i6++) {
                        Object a8 = ae.a(this.a.opt(i6)).a(new wd(b[0]));
                        if (a8 != null) {
                            sparseArray.put(i6, a8);
                        }
                    }
                    return sparseArray;
                } else {
                    return null;
                }
            } else {
                return null;
            }
        }
        return invokeL.objValue;
    }
}
