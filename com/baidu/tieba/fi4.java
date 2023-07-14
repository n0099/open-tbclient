package com.baidu.tieba;

import android.util.SparseArray;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class fi4 {
    public static /* synthetic */ Interceptable $ic;
    public static SparseArray<di4> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947765080, "Lcom/baidu/tieba/fi4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947765080, "Lcom/baidu/tieba/fi4;");
                return;
            }
        }
        SparseArray<di4> sparseArray = new SparseArray<>();
        a = sparseArray;
        sparseArray.put(5, new di4(5, R.string.obfuscated_res_0x7f0f0128, R.drawable.obfuscated_res_0x7f08010f, true));
        a.put(35, new di4(35, R.string.obfuscated_res_0x7f0f011b, R.drawable.obfuscated_res_0x7f0800ef, true));
        a.put(39, new di4(39, R.string.obfuscated_res_0x7f0f0122, R.drawable.obfuscated_res_0x7f080112, true));
        a.put(4, new di4(4, R.string.obfuscated_res_0x7f0f0129, R.drawable.obfuscated_res_0x7f080115, true));
        a.put(37, new di4(37, R.string.obfuscated_res_0x7f0f011d, R.drawable.obfuscated_res_0x7f0800f2, true));
        a.put(38, new di4(38, R.string.obfuscated_res_0x7f0f0126, R.drawable.obfuscated_res_0x7f0800ee, true));
        a.put(42, new di4(42, R.string.obfuscated_res_0x7f0f011e, R.drawable.obfuscated_res_0x7f080112, true));
        a.put(49, new di4(49, R.string.obfuscated_res_0x7f0f14ad, R.drawable.obfuscated_res_0x7f081403, true));
        a.put(50, new di4(50, R.string.obfuscated_res_0x7f0f1531, R.drawable.obfuscated_res_0x7f081402, true));
        a.put(43, new di4(43, R.string.obfuscated_res_0x7f0f011c, R.drawable.obfuscated_res_0x7f0800f3, true));
        a.put(9, new di4(9, R.string.obfuscated_res_0x7f0f0127, R.drawable.obfuscated_res_0x7f0800ff, true));
        a.put(46, new di4(46, R.string.obfuscated_res_0x7f0f011f, R.drawable.obfuscated_res_0x7f080104, true));
        a.put(47, new di4(47, R.string.obfuscated_res_0x7f0f0120, R.drawable.obfuscated_res_0x7f080107, true));
    }

    public static di4 a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            return di4.k(a.get(i));
        }
        return (di4) invokeI.objValue;
    }

    public static List<di4> b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            ArrayList arrayList = new ArrayList();
            if (i != 0) {
                if (i != 12) {
                    if (i != 13) {
                        switch (i) {
                            case 16:
                                arrayList.add(di4.k(a.get(5)));
                                break;
                            case 17:
                            case 18:
                                arrayList.add(di4.k(a.get(38)));
                                arrayList.add(di4.k(a.get(4)));
                                arrayList.add(di4.k(a.get(39)));
                                arrayList.add(di4.k(a.get(35)));
                                arrayList.add(di4.k(a.get(5)));
                                arrayList.add(di4.k(a.get(49)));
                                break;
                            case 19:
                                arrayList.add(di4.l(a.get(38), false));
                                arrayList.add(di4.l(a.get(4), false));
                                arrayList.add(di4.k(a.get(39)));
                                arrayList.add(di4.l(a.get(35), false));
                                arrayList.add(di4.k(a.get(5)));
                                arrayList.add(di4.l(a.get(49), false));
                                break;
                            case 20:
                                arrayList.add(di4.k(a.get(38)));
                                arrayList.add(di4.k(a.get(4)));
                                arrayList.add(di4.k(a.get(39)));
                                arrayList.add(di4.k(a.get(35)));
                                arrayList.add(di4.k(a.get(5)));
                                arrayList.add(di4.k(a.get(49)));
                                break;
                        }
                    } else {
                        arrayList.add(di4.k(a.get(43)));
                    }
                }
                arrayList.add(di4.k(a.get(38)));
                arrayList.add(di4.k(a.get(4)));
                arrayList.add(di4.k(a.get(39)));
                arrayList.add(di4.k(a.get(35)));
                arrayList.add(di4.k(a.get(5)));
                arrayList.add(di4.k(a.get(49)));
            } else {
                arrayList.add(di4.k(a.get(38)));
                arrayList.add(di4.k(a.get(5)));
                arrayList.add(di4.k(a.get(4)));
                arrayList.add(di4.k(a.get(35)));
                arrayList.add(di4.k(a.get(42)));
            }
            return arrayList;
        }
        return (List) invokeI.objValue;
    }
}
