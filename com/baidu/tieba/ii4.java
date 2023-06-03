package com.baidu.tieba;

import android.util.SparseArray;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class ii4 {
    public static /* synthetic */ Interceptable $ic;
    public static SparseArray<gi4> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947854453, "Lcom/baidu/tieba/ii4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947854453, "Lcom/baidu/tieba/ii4;");
                return;
            }
        }
        SparseArray<gi4> sparseArray = new SparseArray<>();
        a = sparseArray;
        sparseArray.put(5, new gi4(5, R.string.obfuscated_res_0x7f0f0126, R.drawable.obfuscated_res_0x7f08010f, true));
        a.put(35, new gi4(35, R.string.obfuscated_res_0x7f0f0119, R.drawable.obfuscated_res_0x7f0800ef, true));
        a.put(39, new gi4(39, R.string.obfuscated_res_0x7f0f0120, R.drawable.obfuscated_res_0x7f080112, true));
        a.put(4, new gi4(4, R.string.obfuscated_res_0x7f0f0127, R.drawable.obfuscated_res_0x7f080115, true));
        a.put(37, new gi4(37, R.string.obfuscated_res_0x7f0f011b, R.drawable.obfuscated_res_0x7f0800f2, true));
        a.put(38, new gi4(38, R.string.obfuscated_res_0x7f0f0124, R.drawable.obfuscated_res_0x7f0800ee, true));
        a.put(42, new gi4(42, R.string.obfuscated_res_0x7f0f011c, R.drawable.obfuscated_res_0x7f080112, true));
        a.put(49, new gi4(49, R.string.obfuscated_res_0x7f0f1476, R.drawable.obfuscated_res_0x7f0813b8, true));
        a.put(50, new gi4(50, R.string.obfuscated_res_0x7f0f14fa, R.drawable.obfuscated_res_0x7f0813b7, true));
        a.put(43, new gi4(43, R.string.obfuscated_res_0x7f0f011a, R.drawable.obfuscated_res_0x7f0800f3, true));
        a.put(9, new gi4(9, R.string.obfuscated_res_0x7f0f0125, R.drawable.obfuscated_res_0x7f0800ff, true));
        a.put(46, new gi4(46, R.string.obfuscated_res_0x7f0f011d, R.drawable.obfuscated_res_0x7f080104, true));
        a.put(47, new gi4(47, R.string.obfuscated_res_0x7f0f011e, R.drawable.obfuscated_res_0x7f080107, true));
    }

    public static gi4 a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            return gi4.k(a.get(i));
        }
        return (gi4) invokeI.objValue;
    }

    public static List<gi4> b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            ArrayList arrayList = new ArrayList();
            if (i != 0) {
                if (i != 12) {
                    if (i != 13) {
                        switch (i) {
                            case 16:
                                arrayList.add(gi4.k(a.get(5)));
                                break;
                            case 17:
                            case 18:
                                arrayList.add(gi4.k(a.get(38)));
                                arrayList.add(gi4.k(a.get(4)));
                                arrayList.add(gi4.k(a.get(39)));
                                arrayList.add(gi4.k(a.get(35)));
                                arrayList.add(gi4.k(a.get(5)));
                                arrayList.add(gi4.k(a.get(49)));
                                break;
                            case 19:
                                arrayList.add(gi4.l(a.get(38), false));
                                arrayList.add(gi4.l(a.get(4), false));
                                arrayList.add(gi4.k(a.get(39)));
                                arrayList.add(gi4.l(a.get(35), false));
                                arrayList.add(gi4.k(a.get(5)));
                                arrayList.add(gi4.l(a.get(49), false));
                                break;
                            case 20:
                                arrayList.add(gi4.k(a.get(38)));
                                arrayList.add(gi4.k(a.get(4)));
                                arrayList.add(gi4.k(a.get(39)));
                                arrayList.add(gi4.k(a.get(35)));
                                arrayList.add(gi4.k(a.get(5)));
                                arrayList.add(gi4.k(a.get(49)));
                                break;
                        }
                    } else {
                        arrayList.add(gi4.k(a.get(43)));
                    }
                }
                arrayList.add(gi4.k(a.get(38)));
                arrayList.add(gi4.k(a.get(4)));
                arrayList.add(gi4.k(a.get(39)));
                arrayList.add(gi4.k(a.get(35)));
                arrayList.add(gi4.k(a.get(5)));
                arrayList.add(gi4.k(a.get(49)));
            } else {
                arrayList.add(gi4.k(a.get(38)));
                arrayList.add(gi4.k(a.get(5)));
                arrayList.add(gi4.k(a.get(4)));
                arrayList.add(gi4.k(a.get(35)));
                arrayList.add(gi4.k(a.get(42)));
            }
            return arrayList;
        }
        return (List) invokeI.objValue;
    }
}
