package com.baidu.tbadk.util;

import android.content.Context;
import android.media.AudioManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.switchs.FrsHeadVideoAutoPlaySwitch;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes5.dex */
public class VideoAudioHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int AUTOPLAY_SOURCE_FRS = 2;
    public static final int AUTOPLAY_SOURCE_FRS_HEAD = 5;
    public static final int AUTOPLAY_SOURCE_HOME = 1;
    public static final int AUTOPLAY_SOURCE_LIST = 4;
    public static final int AUTOPLAY_SOURCE_PB = 3;
    public static boolean isBGMPlaying;
    public static boolean isPlayVoicePlaying;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1236519672, "Lcom/baidu/tbadk/util/VideoAudioHelper;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1236519672, "Lcom/baidu/tbadk/util/VideoAudioHelper;");
        }
    }

    public VideoAudioHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean isBGMPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return isBGMPlaying;
        }
        return invokeV.booleanValue;
    }

    public static boolean checkNeedAutoPlay(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            if (i != 3 && i != 4) {
                if (i != 5) {
                    int autoPlaySwitch = TbadkCoreApplication.getInst().getAutoPlaySwitch();
                    if ((autoPlaySwitch == 3 || !BdNetTypeUtil.isWifiNet()) && (autoPlaySwitch != 2 || !BdNetTypeUtil.isMobileNet())) {
                        return false;
                    }
                } else if (TbadkCoreApplication.getInst().getVideoAutoPlayReal() != 2 && (!FrsHeadVideoAutoPlaySwitch.getIsOn() || !BdNetTypeUtil.isWifiNet() || TbadkCoreApplication.getInst().getVideoAutoPlayReal() != 1)) {
                    return false;
                }
                return true;
            }
            return BdNetTypeUtil.isWifiNet();
        }
        return invokeI.booleanValue;
    }

    public static boolean checkNeedAutoPlay(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65539, null, i, str)) == null) {
            return checkNeedAutoPlay(i);
        }
        return invokeIL.booleanValue;
    }

    public static boolean isLocalSettingCanAutoPlay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if ((BdNetTypeUtil.isWifiNet() && TbadkCoreApplication.getInst().getVideoAutoPlayReal() != 3) || (BdNetTypeUtil.isMobileNet() && TbadkCoreApplication.getInst().getVideoAutoPlayReal() == 2)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean muteAudioFocus(WeakReference<Context> weakReference, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65542, null, weakReference, z)) == null) {
            if (weakReference == null || weakReference.get() == null) {
                return false;
            }
            AudioManager audioManager = (AudioManager) weakReference.get().getSystemService("audio");
            if (z) {
                if (audioManager.requestAudioFocus(null, 3, 2) != 1) {
                    return false;
                }
            } else if (audioManager.abandonAudioFocus(null) != 1) {
                return false;
            }
            return true;
        }
        return invokeLZ.booleanValue;
    }

    public static void refreshBGMPlayingStatus(WeakReference<Context> weakReference) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, weakReference) == null) && weakReference != null && weakReference.get() != null) {
            isBGMPlaying = ((AudioManager) weakReference.get().getSystemService("audio")).isMusicActive();
        }
    }
}
