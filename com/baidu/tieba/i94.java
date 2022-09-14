package com.baidu.tieba;

import android.util.SparseArray;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class i94 {
    public static /* synthetic */ Interceptable $ic;
    public static SparseArray<g94> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947808325, "Lcom/baidu/tieba/i94;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947808325, "Lcom/baidu/tieba/i94;");
                return;
            }
        }
        SparseArray<g94> sparseArray = new SparseArray<>();
        a = sparseArray;
        sparseArray.put(5, new g94(5, R.string.obfuscated_res_0x7f0f00fc, R.drawable.obfuscated_res_0x7f0800f5, true));
        a.put(35, new g94(35, R.string.obfuscated_res_0x7f0f00ef, R.drawable.obfuscated_res_0x7f0800d5, true));
        a.put(39, new g94(39, R.string.obfuscated_res_0x7f0f00f6, R.drawable.obfuscated_res_0x7f0800f8, true));
        a.put(4, new g94(4, R.string.obfuscated_res_0x7f0f00fd, R.drawable.obfuscated_res_0x7f0800fb, true));
        a.put(37, new g94(37, R.string.obfuscated_res_0x7f0f00f1, R.drawable.obfuscated_res_0x7f0800d8, true));
        a.put(38, new g94(38, R.string.obfuscated_res_0x7f0f00fa, R.drawable.obfuscated_res_0x7f0800d4, true));
        a.put(42, new g94(42, R.string.obfuscated_res_0x7f0f00f2, R.drawable.obfuscated_res_0x7f0800f8, true));
        a.put(49, new g94(49, R.string.obfuscated_res_0x7f0f126a, R.drawable.obfuscated_res_0x7f081153, true));
        a.put(50, new g94(50, R.string.obfuscated_res_0x7f0f12ee, R.drawable.obfuscated_res_0x7f081152, true));
        a.put(43, new g94(43, R.string.obfuscated_res_0x7f0f00f0, R.drawable.obfuscated_res_0x7f0800d9, true));
        a.put(9, new g94(9, R.string.obfuscated_res_0x7f0f00fb, R.drawable.obfuscated_res_0x7f0800e5, true));
        a.put(46, new g94(46, R.string.obfuscated_res_0x7f0f00f3, R.drawable.obfuscated_res_0x7f0800ea, true));
        a.put(47, new g94(47, R.string.obfuscated_res_0x7f0f00f4, R.drawable.obfuscated_res_0x7f0800ed, true));
    }

    public static g94 a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) ? g94.k(a.get(i)) : (g94) invokeI.objValue;
    }

    public static List<g94> b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            ArrayList arrayList = new ArrayList();
            if (i != 0) {
                if (i != 12) {
                    if (i != 13) {
                        switch (i) {
                            case 16:
                                arrayList.add(g94.k(a.get(5)));
                                break;
                            case 17:
                            case 18:
                                arrayList.add(g94.k(a.get(38)));
                                arrayList.add(g94.k(a.get(4)));
                                arrayList.add(g94.k(a.get(39)));
                                arrayList.add(g94.k(a.get(35)));
                                arrayList.add(g94.k(a.get(5)));
                                arrayList.add(g94.k(a.get(49)));
                                break;
                            case 19:
                                arrayList.add(g94.l(a.get(38), false));
                                arrayList.add(g94.l(a.get(4), false));
                                arrayList.add(g94.k(a.get(39)));
                                arrayList.add(g94.l(a.get(35), false));
                                arrayList.add(g94.k(a.get(5)));
                                arrayList.add(g94.l(a.get(49), false));
                                break;
                            case 20:
                                arrayList.add(g94.k(a.get(38)));
                                arrayList.add(g94.k(a.get(4)));
                                arrayList.add(g94.k(a.get(39)));
                                arrayList.add(g94.k(a.get(35)));
                                arrayList.add(g94.k(a.get(5)));
                                arrayList.add(g94.k(a.get(49)));
                                break;
                        }
                    } else {
                        arrayList.add(g94.k(a.get(43)));
                    }
                }
                arrayList.add(g94.k(a.get(38)));
                arrayList.add(g94.k(a.get(4)));
                arrayList.add(g94.k(a.get(39)));
                arrayList.add(g94.k(a.get(35)));
                arrayList.add(g94.k(a.get(5)));
                arrayList.add(g94.k(a.get(49)));
            } else {
                arrayList.add(g94.k(a.get(38)));
                arrayList.add(g94.k(a.get(5)));
                arrayList.add(g94.k(a.get(4)));
                arrayList.add(g94.k(a.get(35)));
                arrayList.add(g94.k(a.get(42)));
            }
            return arrayList;
        }
        return (List) invokeI.objValue;
    }
}
