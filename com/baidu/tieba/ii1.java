package com.baidu.tieba;

import android.content.res.ColorStateList;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidubce.auth.NTLMEngineImpl;
/* loaded from: classes4.dex */
public class ii1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ColorStateList a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i)) == null) {
            int i2 = i - (-805306368);
            return new ColorStateList(new int[][]{new int[]{-16842910, 16842912}, new int[]{-16842910}, new int[]{16842912, 16842919}, new int[]{-16842912, 16842919}, new int[]{16842912}, new int[]{-16842912}}, new int[]{i - (-520093696), LaunchTaskConstants.OTHER_PROCESS, i2, NTLMEngineImpl.FLAG_REQUEST_128BIT_KEY_EXCH, i2, NTLMEngineImpl.FLAG_REQUEST_128BIT_KEY_EXCH});
        }
        return (ColorStateList) invokeI.objValue;
    }

    public static ColorStateList b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            int i2 = i - (-1728053248);
            return new ColorStateList(new int[][]{new int[]{-16842910, 16842912}, new int[]{-16842910}, new int[]{16842919, -16842912}, new int[]{16842919, 16842912}, new int[]{16842912}, new int[]{-16842912}}, new int[]{i - (-1442840576), -4539718, i2, i2, i | (-16777216), -1118482});
        }
        return (ColorStateList) invokeI.objValue;
    }
}
