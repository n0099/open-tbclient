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
public class i74 {
    public static /* synthetic */ Interceptable $ic;
    public static SparseArray<g74> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947806403, "Lcom/baidu/tieba/i74;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947806403, "Lcom/baidu/tieba/i74;");
                return;
            }
        }
        SparseArray<g74> sparseArray = new SparseArray<>();
        a = sparseArray;
        sparseArray.put(5, new g74(5, R.string.obfuscated_res_0x7f0f00fa, R.drawable.obfuscated_res_0x7f0800f4, true));
        a.put(35, new g74(35, R.string.obfuscated_res_0x7f0f00ed, R.drawable.obfuscated_res_0x7f0800d4, true));
        a.put(39, new g74(39, R.string.obfuscated_res_0x7f0f00f4, R.drawable.obfuscated_res_0x7f0800f7, true));
        a.put(4, new g74(4, R.string.obfuscated_res_0x7f0f00fb, R.drawable.obfuscated_res_0x7f0800fa, true));
        a.put(37, new g74(37, R.string.obfuscated_res_0x7f0f00ef, R.drawable.obfuscated_res_0x7f0800d7, true));
        a.put(38, new g74(38, R.string.obfuscated_res_0x7f0f00f8, R.drawable.obfuscated_res_0x7f0800d3, true));
        a.put(42, new g74(42, R.string.obfuscated_res_0x7f0f00f0, R.drawable.obfuscated_res_0x7f0800f7, true));
        a.put(49, new g74(49, R.string.obfuscated_res_0x7f0f124c, R.drawable.obfuscated_res_0x7f081129, true));
        a.put(50, new g74(50, R.string.obfuscated_res_0x7f0f12d0, R.drawable.obfuscated_res_0x7f081128, true));
        a.put(43, new g74(43, R.string.obfuscated_res_0x7f0f00ee, R.drawable.obfuscated_res_0x7f0800d8, true));
        a.put(9, new g74(9, R.string.obfuscated_res_0x7f0f00f9, R.drawable.obfuscated_res_0x7f0800e4, true));
        a.put(46, new g74(46, R.string.obfuscated_res_0x7f0f00f1, R.drawable.obfuscated_res_0x7f0800e9, true));
        a.put(47, new g74(47, R.string.obfuscated_res_0x7f0f00f2, R.drawable.obfuscated_res_0x7f0800ec, true));
    }

    public static g74 a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) ? g74.k(a.get(i)) : (g74) invokeI.objValue;
    }

    public static List<g74> b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            ArrayList arrayList = new ArrayList();
            if (i != 0) {
                if (i != 12) {
                    if (i != 13) {
                        switch (i) {
                            case 16:
                                arrayList.add(g74.k(a.get(5)));
                                break;
                            case 17:
                            case 18:
                                arrayList.add(g74.k(a.get(38)));
                                arrayList.add(g74.k(a.get(4)));
                                arrayList.add(g74.k(a.get(39)));
                                arrayList.add(g74.k(a.get(35)));
                                arrayList.add(g74.k(a.get(5)));
                                arrayList.add(g74.k(a.get(49)));
                                break;
                            case 19:
                                arrayList.add(g74.l(a.get(38), false));
                                arrayList.add(g74.l(a.get(4), false));
                                arrayList.add(g74.k(a.get(39)));
                                arrayList.add(g74.l(a.get(35), false));
                                arrayList.add(g74.k(a.get(5)));
                                arrayList.add(g74.l(a.get(49), false));
                                break;
                            case 20:
                                arrayList.add(g74.k(a.get(38)));
                                arrayList.add(g74.k(a.get(4)));
                                arrayList.add(g74.k(a.get(39)));
                                arrayList.add(g74.k(a.get(35)));
                                arrayList.add(g74.k(a.get(5)));
                                arrayList.add(g74.k(a.get(49)));
                                break;
                        }
                    } else {
                        arrayList.add(g74.k(a.get(43)));
                    }
                }
                arrayList.add(g74.k(a.get(38)));
                arrayList.add(g74.k(a.get(4)));
                arrayList.add(g74.k(a.get(39)));
                arrayList.add(g74.k(a.get(35)));
                arrayList.add(g74.k(a.get(5)));
                arrayList.add(g74.k(a.get(49)));
            } else {
                arrayList.add(g74.k(a.get(38)));
                arrayList.add(g74.k(a.get(5)));
                arrayList.add(g74.k(a.get(4)));
                arrayList.add(g74.k(a.get(35)));
                arrayList.add(g74.k(a.get(42)));
            }
            return arrayList;
        }
        return (List) invokeI.objValue;
    }
}
