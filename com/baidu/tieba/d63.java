package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class d63 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i)) == null) ? i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "" : "getPhoneContacts" : "calendar" : "saveImageToPhotosAlbum" : "getRecorderManager" : "camera" : "location" : (String) invokeI.objValue;
    }

    public static String b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(65537, null, z)) == null) ? z ? "success" : "fail" : (String) invokeZ.objValue;
    }
}
