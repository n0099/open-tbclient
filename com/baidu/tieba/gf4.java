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
public class gf4 {
    public static /* synthetic */ Interceptable $ic;
    public static SparseArray<ef4> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947791988, "Lcom/baidu/tieba/gf4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947791988, "Lcom/baidu/tieba/gf4;");
                return;
            }
        }
        SparseArray<ef4> sparseArray = new SparseArray<>();
        a = sparseArray;
        sparseArray.put(5, new ef4(5, R.string.obfuscated_res_0x7f0f00fe, R.drawable.obfuscated_res_0x7f0800f5, true));
        a.put(35, new ef4(35, R.string.obfuscated_res_0x7f0f00f1, R.drawable.obfuscated_res_0x7f0800d5, true));
        a.put(39, new ef4(39, R.string.obfuscated_res_0x7f0f00f8, R.drawable.obfuscated_res_0x7f0800f8, true));
        a.put(4, new ef4(4, R.string.obfuscated_res_0x7f0f00ff, R.drawable.obfuscated_res_0x7f0800fb, true));
        a.put(37, new ef4(37, R.string.obfuscated_res_0x7f0f00f3, R.drawable.obfuscated_res_0x7f0800d8, true));
        a.put(38, new ef4(38, R.string.obfuscated_res_0x7f0f00fc, R.drawable.obfuscated_res_0x7f0800d4, true));
        a.put(42, new ef4(42, R.string.obfuscated_res_0x7f0f00f4, R.drawable.obfuscated_res_0x7f0800f8, true));
        a.put(49, new ef4(49, R.string.obfuscated_res_0x7f0f132c, R.drawable.obfuscated_res_0x7f0811e0, true));
        a.put(50, new ef4(50, R.string.obfuscated_res_0x7f0f13b0, R.drawable.obfuscated_res_0x7f0811df, true));
        a.put(43, new ef4(43, R.string.obfuscated_res_0x7f0f00f2, R.drawable.obfuscated_res_0x7f0800d9, true));
        a.put(9, new ef4(9, R.string.obfuscated_res_0x7f0f00fd, R.drawable.obfuscated_res_0x7f0800e5, true));
        a.put(46, new ef4(46, R.string.obfuscated_res_0x7f0f00f5, R.drawable.obfuscated_res_0x7f0800ea, true));
        a.put(47, new ef4(47, R.string.obfuscated_res_0x7f0f00f6, R.drawable.obfuscated_res_0x7f0800ed, true));
    }

    public static ef4 a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            return ef4.k(a.get(i));
        }
        return (ef4) invokeI.objValue;
    }

    public static List<ef4> b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            ArrayList arrayList = new ArrayList();
            if (i != 0) {
                if (i != 12) {
                    if (i != 13) {
                        switch (i) {
                            case 16:
                                arrayList.add(ef4.k(a.get(5)));
                                break;
                            case 17:
                            case 18:
                                arrayList.add(ef4.k(a.get(38)));
                                arrayList.add(ef4.k(a.get(4)));
                                arrayList.add(ef4.k(a.get(39)));
                                arrayList.add(ef4.k(a.get(35)));
                                arrayList.add(ef4.k(a.get(5)));
                                arrayList.add(ef4.k(a.get(49)));
                                break;
                            case 19:
                                arrayList.add(ef4.l(a.get(38), false));
                                arrayList.add(ef4.l(a.get(4), false));
                                arrayList.add(ef4.k(a.get(39)));
                                arrayList.add(ef4.l(a.get(35), false));
                                arrayList.add(ef4.k(a.get(5)));
                                arrayList.add(ef4.l(a.get(49), false));
                                break;
                            case 20:
                                arrayList.add(ef4.k(a.get(38)));
                                arrayList.add(ef4.k(a.get(4)));
                                arrayList.add(ef4.k(a.get(39)));
                                arrayList.add(ef4.k(a.get(35)));
                                arrayList.add(ef4.k(a.get(5)));
                                arrayList.add(ef4.k(a.get(49)));
                                break;
                        }
                    } else {
                        arrayList.add(ef4.k(a.get(43)));
                    }
                }
                arrayList.add(ef4.k(a.get(38)));
                arrayList.add(ef4.k(a.get(4)));
                arrayList.add(ef4.k(a.get(39)));
                arrayList.add(ef4.k(a.get(35)));
                arrayList.add(ef4.k(a.get(5)));
                arrayList.add(ef4.k(a.get(49)));
            } else {
                arrayList.add(ef4.k(a.get(38)));
                arrayList.add(ef4.k(a.get(5)));
                arrayList.add(ef4.k(a.get(4)));
                arrayList.add(ef4.k(a.get(35)));
                arrayList.add(ef4.k(a.get(42)));
            }
            return arrayList;
        }
        return (List) invokeI.objValue;
    }
}
