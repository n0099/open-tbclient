package com.baidu.tieba;

import android.content.res.AssetManager;
import android.graphics.BitmapFactory;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.switchs.WebpForceSwitch;
import com.baidu.tbadk.switchs.WebpSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes4.dex */
public class gq5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void e(boolean z, @Nullable String str, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Boolean.valueOf(z), str, str2}) == null) {
        }
    }

    public static void g(@NonNull String str, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, str, str2) == null) {
        }
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            return TbadkCoreApplication.getInst().getCapabilityOfWebp();
        }
        return invokeV.booleanValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (!WebpForceSwitch.isOn() && (!a() || !h())) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (SwitchManager.getInstance().findType(WebpSwitch.WEBP_ENABLE) == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static void b(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            int loadInt = TbadkSettings.getInst().loadInt("webp_failure_count", 0) + 1;
            if (loadInt > 5) {
                TbadkCoreApplication.getInst().setCapableOfWebp(false);
                TbadkSettings.getInst().saveBoolean("capable_of_webp_format", false);
                return;
            }
            TbadkSettings.getInst().saveInt("webp_failure_count", loadInt);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void c() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            int i = 0;
            if (TbadkSettings.getInst().loadInt("webp_failure_count", -1) == -1) {
                AssetManager assets = TbadkCoreApplication.getInst().getContext().getAssets();
                if (assets != null) {
                    InputStream inputStream = null;
                    try {
                        inputStream = assets.open("webp_test/test.webp");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (inputStream != null && BitmapFactory.decodeStream(inputStream) != null) {
                        z = true;
                        if (!z) {
                            TiebaStatic.log("LocalWebpUnSupport");
                            i = 6;
                        }
                        TbadkCoreApplication.getInst().setCapableOfWebp(z);
                        TbadkSettings.getInst().saveInt("webp_failure_count", i);
                        TbadkSettings.getInst().saveBoolean("capable_of_webp_format", z);
                        return;
                    }
                }
                z = false;
                if (!z) {
                }
                TbadkCoreApplication.getInst().setCapableOfWebp(z);
                TbadkSettings.getInst().saveInt("webp_failure_count", i);
                TbadkSettings.getInst().saveBoolean("capable_of_webp_format", z);
                return;
            }
            TbadkCoreApplication.getInst().setCapableOfWebp(TbadkSettings.getInst().loadBoolean("capable_of_webp_format", false));
        }
    }

    @NonNull
    public static Pair<Boolean, String> d(@Nullable String str) {
        InterceptResult invokeL;
        int lastIndexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (!f()) {
                return new Pair<>(Boolean.FALSE, str);
            }
            if (str != null && str.length() != 0) {
                int indexOf = str.indexOf("hiphotos.baidu.com");
                if (indexOf <= 0) {
                    indexOf = str.indexOf("tiebapic.baidu.com");
                }
                if (indexOf > 0 && (lastIndexOf = str.lastIndexOf(".jpg")) > 0) {
                    return new Pair<>(Boolean.TRUE, str.substring(0, lastIndexOf) + ".webp" + str.substring(lastIndexOf + 4));
                }
                return new Pair<>(Boolean.FALSE, str);
            }
            return new Pair<>(Boolean.FALSE, str);
        }
        return (Pair) invokeL.objValue;
    }
}
