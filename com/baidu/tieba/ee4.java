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
public class ee4 {
    public static /* synthetic */ Interceptable $ic;
    public static SparseArray<ce4> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947731445, "Lcom/baidu/tieba/ee4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947731445, "Lcom/baidu/tieba/ee4;");
                return;
            }
        }
        SparseArray<ce4> sparseArray = new SparseArray<>();
        a = sparseArray;
        sparseArray.put(5, new ce4(5, R.string.obfuscated_res_0x7f0f00fe, R.drawable.obfuscated_res_0x7f0800f6, true));
        a.put(35, new ce4(35, R.string.obfuscated_res_0x7f0f00f1, R.drawable.obfuscated_res_0x7f0800d6, true));
        a.put(39, new ce4(39, R.string.obfuscated_res_0x7f0f00f8, R.drawable.obfuscated_res_0x7f0800f9, true));
        a.put(4, new ce4(4, R.string.obfuscated_res_0x7f0f00ff, R.drawable.obfuscated_res_0x7f0800fc, true));
        a.put(37, new ce4(37, R.string.obfuscated_res_0x7f0f00f3, R.drawable.obfuscated_res_0x7f0800d9, true));
        a.put(38, new ce4(38, R.string.obfuscated_res_0x7f0f00fc, R.drawable.obfuscated_res_0x7f0800d5, true));
        a.put(42, new ce4(42, R.string.obfuscated_res_0x7f0f00f4, R.drawable.obfuscated_res_0x7f0800f9, true));
        a.put(49, new ce4(49, R.string.obfuscated_res_0x7f0f1339, R.drawable.obfuscated_res_0x7f0811e9, true));
        a.put(50, new ce4(50, R.string.obfuscated_res_0x7f0f13bd, R.drawable.obfuscated_res_0x7f0811e8, true));
        a.put(43, new ce4(43, R.string.obfuscated_res_0x7f0f00f2, R.drawable.obfuscated_res_0x7f0800da, true));
        a.put(9, new ce4(9, R.string.obfuscated_res_0x7f0f00fd, R.drawable.obfuscated_res_0x7f0800e6, true));
        a.put(46, new ce4(46, R.string.obfuscated_res_0x7f0f00f5, R.drawable.obfuscated_res_0x7f0800eb, true));
        a.put(47, new ce4(47, R.string.obfuscated_res_0x7f0f00f6, R.drawable.obfuscated_res_0x7f0800ee, true));
    }

    public static ce4 a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            return ce4.k(a.get(i));
        }
        return (ce4) invokeI.objValue;
    }

    public static List<ce4> b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            ArrayList arrayList = new ArrayList();
            if (i != 0) {
                if (i != 12) {
                    if (i != 13) {
                        switch (i) {
                            case 16:
                                arrayList.add(ce4.k(a.get(5)));
                                break;
                            case 17:
                            case 18:
                                arrayList.add(ce4.k(a.get(38)));
                                arrayList.add(ce4.k(a.get(4)));
                                arrayList.add(ce4.k(a.get(39)));
                                arrayList.add(ce4.k(a.get(35)));
                                arrayList.add(ce4.k(a.get(5)));
                                arrayList.add(ce4.k(a.get(49)));
                                break;
                            case 19:
                                arrayList.add(ce4.l(a.get(38), false));
                                arrayList.add(ce4.l(a.get(4), false));
                                arrayList.add(ce4.k(a.get(39)));
                                arrayList.add(ce4.l(a.get(35), false));
                                arrayList.add(ce4.k(a.get(5)));
                                arrayList.add(ce4.l(a.get(49), false));
                                break;
                            case 20:
                                arrayList.add(ce4.k(a.get(38)));
                                arrayList.add(ce4.k(a.get(4)));
                                arrayList.add(ce4.k(a.get(39)));
                                arrayList.add(ce4.k(a.get(35)));
                                arrayList.add(ce4.k(a.get(5)));
                                arrayList.add(ce4.k(a.get(49)));
                                break;
                        }
                    } else {
                        arrayList.add(ce4.k(a.get(43)));
                    }
                }
                arrayList.add(ce4.k(a.get(38)));
                arrayList.add(ce4.k(a.get(4)));
                arrayList.add(ce4.k(a.get(39)));
                arrayList.add(ce4.k(a.get(35)));
                arrayList.add(ce4.k(a.get(5)));
                arrayList.add(ce4.k(a.get(49)));
            } else {
                arrayList.add(ce4.k(a.get(38)));
                arrayList.add(ce4.k(a.get(5)));
                arrayList.add(ce4.k(a.get(4)));
                arrayList.add(ce4.k(a.get(35)));
                arrayList.add(ce4.k(a.get(42)));
            }
            return arrayList;
        }
        return (List) invokeI.objValue;
    }
}
