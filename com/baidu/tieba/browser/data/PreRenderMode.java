package com.baidu.tieba.browser.data;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes3.dex */
public final class PreRenderMode {
    public static final /* synthetic */ PreRenderMode[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final PreRenderMode MULTI;
    public static final PreRenderMode MULTI_AUTO_REMOVE;
    public static final PreRenderMode NONE;
    public static final PreRenderMode ONCE;
    public static final PreRenderMode ONCE_AUTO_REMOVE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1344515471, "Lcom/baidu/tieba/browser/data/PreRenderMode;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1344515471, "Lcom/baidu/tieba/browser/data/PreRenderMode;");
                return;
            }
        }
        NONE = new PreRenderMode(HlsPlaylistParser.METHOD_NONE, 0);
        ONCE = new PreRenderMode("ONCE", 1);
        ONCE_AUTO_REMOVE = new PreRenderMode("ONCE_AUTO_REMOVE", 2);
        MULTI = new PreRenderMode("MULTI", 3);
        PreRenderMode preRenderMode = new PreRenderMode("MULTI_AUTO_REMOVE", 4);
        MULTI_AUTO_REMOVE = preRenderMode;
        $VALUES = new PreRenderMode[]{NONE, ONCE, ONCE_AUTO_REMOVE, MULTI, preRenderMode};
    }

    public PreRenderMode(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static PreRenderMode valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (PreRenderMode) Enum.valueOf(PreRenderMode.class, str);
        }
        return (PreRenderMode) invokeL.objValue;
    }

    public static PreRenderMode[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (PreRenderMode[]) $VALUES.clone();
        }
        return (PreRenderMode[]) invokeV.objValue;
    }
}
