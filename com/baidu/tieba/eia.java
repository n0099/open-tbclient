package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class eia {
    public static /* synthetic */ Interceptable $ic;
    public static ArrayList<Integer> a;
    public static String b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947736684, "Lcom/baidu/tieba/eia;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947736684, "Lcom/baidu/tieba/eia;");
                return;
            }
        }
        ArrayList<Integer> arrayList = new ArrayList<>(4);
        a = arrayList;
        arrayList.add(10000);
        a.add(10001);
        a.add(10002);
        a.add(Integer.valueOf((int) ShareCallPacking.REQUEST_CODE_V2_SHARE_ACCOUNT));
        a.add(-1);
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (TextUtils.isEmpty(b)) {
                b = sia.a();
            }
            if (TextUtils.isEmpty(b)) {
                return ShareCallPacking.REQUEST_CODE_V2_SHARE_ACCOUNT;
            }
            if (b.toUpperCase().contains("HUAWEI")) {
                return 10001;
            }
            if (!b.toUpperCase().contains(RomUtils.ROM_XIAOMI)) {
                return ShareCallPacking.REQUEST_CODE_V2_SHARE_ACCOUNT;
            }
            return 10002;
        }
        return invokeV.intValue;
    }
}
