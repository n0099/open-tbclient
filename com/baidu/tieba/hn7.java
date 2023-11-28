package com.baidu.tieba;

import android.app.Activity;
import com.baidu.adp.lib.resourceLoader.BdResourceLoader;
import com.baidu.adp.lib.safe.UiUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.FrsSpriteNewUserGuide;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.log.YunDialogLog;
import com.baidu.tbadk.data.DialogStrategiesData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import tbclient.ThemeColorInfo;
/* loaded from: classes6.dex */
public final class hn7 implements z15 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public hn7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static final void d(String resultBgUrl) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, resultBgUrl) == null) {
            Intrinsics.checkNotNullParameter(resultBgUrl, "$resultBgUrl");
            BdResourceLoader.getInstance().loadResource(resultBgUrl, 59, null, null);
        }
    }

    public final void c(ThemeColorInfo themeColorInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, themeColorInfo) != null) || themeColorInfo == null) {
            return;
        }
        final String g = z5b.g(themeColorInfo);
        if (!StringUtils.isNotNull(g)) {
            UiUtils.post(new Runnable() { // from class: com.baidu.tieba.cn7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        hn7.d(g);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.z15
    public Map<String, Object> a(DialogStrategiesData dialogData, Map<String, ? extends Object> strategyData, Map<String, ? extends Object> extraData) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, dialogData, strategyData, extraData)) == null) {
            Intrinsics.checkNotNullParameter(dialogData, "dialogData");
            Intrinsics.checkNotNullParameter(strategyData, "strategyData");
            Intrinsics.checkNotNullParameter(extraData, "extraData");
            HashMap hashMap = new HashMap(strategyData);
            hashMap.put("dialogName", "frsFullPush");
            hashMap.putAll(strategyData);
            hashMap.putAll(extraData);
            return hashMap;
        }
        return (Map) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.z15
    public boolean b(Map<String, ? extends Object> map) {
        InterceptResult invokeL;
        boolean z;
        ThemeColorInfo themeColorInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map)) == null) {
            Intrinsics.checkNotNullParameter(map, "map");
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity instanceof f25) {
                f25 f25Var = (f25) currentActivity;
                if (f25Var.i1() != null) {
                    if (!ik5.f(true)) {
                        YunDialogLog.getInstance().e(YunDialogManager.LOG_KEY, "全员推送弹窗策略校验失败：动画资源未就绪");
                        return false;
                    } else if (pb5.j()) {
                        YunDialogLog.getInstance().e(YunDialogManager.LOG_KEY, "全员推送弹窗策略校验失败：S级事件正在展示互斥不展示");
                        return false;
                    } else {
                        e25 i1 = f25Var.i1();
                        if (i1.I0()) {
                            YunDialogLog.getInstance().e(YunDialogManager.LOG_KEY, "全员推送弹窗策略校验失败：底部直播动画弹窗存在互斥");
                            return false;
                        } else if (!i1.g1()) {
                            YunDialogLog.getInstance().e(YunDialogManager.LOG_KEY, "全员推送弹窗策略校验失败：当次已经展示过了");
                            return false;
                        } else {
                            FrsSpriteNewUserGuide F0 = i1.F0();
                            if (F0 == null) {
                                return false;
                            }
                            if (F0.isTitleAndDescValid()) {
                                FrsSpriteNewUserGuide.BubbleText bubbleText = F0.bubbleText;
                                if (bubbleText != null && bubbleText.type == 2) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (z) {
                                    FrsSpriteNewUserGuide.BubbleText bubbleText2 = F0.bubbleText;
                                    if (bubbleText2 != null) {
                                        themeColorInfo = bubbleText2.bgUrlTheme;
                                    } else {
                                        themeColorInfo = null;
                                    }
                                    c(themeColorInfo);
                                    return true;
                                }
                            }
                            YunDialogLog.getInstance().e(YunDialogManager.LOG_KEY, "全员推送弹窗策略校验失败：该吧未下发全员推送配置");
                            return false;
                        }
                    }
                }
            }
            YunDialogLog.getInstance().e(YunDialogManager.LOG_KEY, "全员推送弹窗策略校验失败：获取到的IForumDialogExtSupport为空");
            return false;
        }
        return invokeL.booleanValue;
    }
}
