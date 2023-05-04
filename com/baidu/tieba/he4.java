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
public class he4 {
    public static /* synthetic */ Interceptable $ic;
    public static SparseArray<fe4> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947820818, "Lcom/baidu/tieba/he4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947820818, "Lcom/baidu/tieba/he4;");
                return;
            }
        }
        SparseArray<fe4> sparseArray = new SparseArray<>();
        a = sparseArray;
        sparseArray.put(5, new fe4(5, R.string.obfuscated_res_0x7f0f00fc, R.drawable.obfuscated_res_0x7f0800f7, true));
        a.put(35, new fe4(35, R.string.obfuscated_res_0x7f0f00ef, R.drawable.obfuscated_res_0x7f0800d7, true));
        a.put(39, new fe4(39, R.string.obfuscated_res_0x7f0f00f6, R.drawable.obfuscated_res_0x7f0800fa, true));
        a.put(4, new fe4(4, R.string.obfuscated_res_0x7f0f00fd, R.drawable.obfuscated_res_0x7f0800fd, true));
        a.put(37, new fe4(37, R.string.obfuscated_res_0x7f0f00f1, R.drawable.obfuscated_res_0x7f0800da, true));
        a.put(38, new fe4(38, R.string.obfuscated_res_0x7f0f00fa, R.drawable.obfuscated_res_0x7f0800d6, true));
        a.put(42, new fe4(42, R.string.obfuscated_res_0x7f0f00f2, R.drawable.obfuscated_res_0x7f0800fa, true));
        a.put(49, new fe4(49, R.string.obfuscated_res_0x7f0f1352, R.drawable.obfuscated_res_0x7f08121a, true));
        a.put(50, new fe4(50, R.string.obfuscated_res_0x7f0f13d6, R.drawable.obfuscated_res_0x7f081219, true));
        a.put(43, new fe4(43, R.string.obfuscated_res_0x7f0f00f0, R.drawable.obfuscated_res_0x7f0800db, true));
        a.put(9, new fe4(9, R.string.obfuscated_res_0x7f0f00fb, R.drawable.obfuscated_res_0x7f0800e7, true));
        a.put(46, new fe4(46, R.string.obfuscated_res_0x7f0f00f3, R.drawable.obfuscated_res_0x7f0800ec, true));
        a.put(47, new fe4(47, R.string.obfuscated_res_0x7f0f00f4, R.drawable.obfuscated_res_0x7f0800ef, true));
    }

    public static fe4 a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            return fe4.k(a.get(i));
        }
        return (fe4) invokeI.objValue;
    }

    public static List<fe4> b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            ArrayList arrayList = new ArrayList();
            if (i != 0) {
                if (i != 12) {
                    if (i != 13) {
                        switch (i) {
                            case 16:
                                arrayList.add(fe4.k(a.get(5)));
                                break;
                            case 17:
                            case 18:
                                arrayList.add(fe4.k(a.get(38)));
                                arrayList.add(fe4.k(a.get(4)));
                                arrayList.add(fe4.k(a.get(39)));
                                arrayList.add(fe4.k(a.get(35)));
                                arrayList.add(fe4.k(a.get(5)));
                                arrayList.add(fe4.k(a.get(49)));
                                break;
                            case 19:
                                arrayList.add(fe4.l(a.get(38), false));
                                arrayList.add(fe4.l(a.get(4), false));
                                arrayList.add(fe4.k(a.get(39)));
                                arrayList.add(fe4.l(a.get(35), false));
                                arrayList.add(fe4.k(a.get(5)));
                                arrayList.add(fe4.l(a.get(49), false));
                                break;
                            case 20:
                                arrayList.add(fe4.k(a.get(38)));
                                arrayList.add(fe4.k(a.get(4)));
                                arrayList.add(fe4.k(a.get(39)));
                                arrayList.add(fe4.k(a.get(35)));
                                arrayList.add(fe4.k(a.get(5)));
                                arrayList.add(fe4.k(a.get(49)));
                                break;
                        }
                    } else {
                        arrayList.add(fe4.k(a.get(43)));
                    }
                }
                arrayList.add(fe4.k(a.get(38)));
                arrayList.add(fe4.k(a.get(4)));
                arrayList.add(fe4.k(a.get(39)));
                arrayList.add(fe4.k(a.get(35)));
                arrayList.add(fe4.k(a.get(5)));
                arrayList.add(fe4.k(a.get(49)));
            } else {
                arrayList.add(fe4.k(a.get(38)));
                arrayList.add(fe4.k(a.get(5)));
                arrayList.add(fe4.k(a.get(4)));
                arrayList.add(fe4.k(a.get(35)));
                arrayList.add(fe4.k(a.get(42)));
            }
            return arrayList;
        }
        return (List) invokeI.objValue;
    }
}
